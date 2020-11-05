package com.epegase.forms.caisse;

import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CaissesJour;
import com.epegase.systeme.classe.CaissesMois;
import com.epegase.systeme.classe.ConsultationActes;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.ConsultationReglement;
import com.epegase.systeme.classe.Devise;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.HospitalisationReglement;
import com.epegase.systeme.classe.LaboratoireEntete;
import com.epegase.systeme.classe.LaboratoireLigne;
import com.epegase.systeme.classe.LaboratoireReglement;
import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.PharmacieLigne;
import com.epegase.systeme.classe.PharmacieReglement;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CaissesJourDao;
import com.epegase.systeme.dao.CaissesMoisDao;
import com.epegase.systeme.dao.ConsultationActesDao;
import com.epegase.systeme.dao.ConsultationEnteteGeneDao;
import com.epegase.systeme.dao.ConsultationReglementDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.HospitalisationEnteteDao;
import com.epegase.systeme.dao.HospitalisationReglementDao;
import com.epegase.systeme.dao.HospitalisationSejourDao;
import com.epegase.systeme.dao.LaboratoireEnteteDao;
import com.epegase.systeme.dao.LaboratoireLigneDao;
import com.epegase.systeme.dao.LaboratoireReglementDao;
import com.epegase.systeme.dao.PharmacieEnteteDao;
import com.epegase.systeme.dao.PharmacieLigneDao;
import com.epegase.systeme.dao.PharmacieReglementDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.LectureTypeReglement;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.ObjetDevises;
import com.epegase.systeme.xml.OptionCaisses;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
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
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormJournauxCaisse implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private OptionCaisses optionCaisses;
   private ExercicesCaisse selectedExo;
   private ExercicesCaisse lastExo;
   private UtilNombre utilNombre = new UtilNombre();
   private UtilDate utilDate = new UtilDate();
   private List mesOnglets;
   private int var_nb_max = 100;
   private int var_type_onglet = 99;
   private int modeJournal;
   private int typeVente;
   private CaissesCommerciales caissesCommerciales = new CaissesCommerciales();
   private CaissesCommercialesDao caissesCommercialesDao;
   private String var_caisse;
   private String var_modele;
   private String var_banque;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private boolean champCltVide = false;
   private boolean var_acc_descriptif = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean visibleOnglet = false;
   private boolean var_affiche_depot = false;
   private boolean var_depot = false;
   private boolean var_verrou_caisse = false;
   private String inputBanqEmetteur;
   private String inputBanqRecepteur;
   private int var_choix_modele;
   private String requete;
   private String filtre;
   private String format = "PDF";
   private String nomModeleListe;
   private String nomModeleDocument;
   private String nomRepMod;
   private boolean visibleOptionMail = false;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private boolean affListeDoc = false;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private boolean showModalPanelPrint = false;
   private Date dateSoldeCaisse;
   private Reglements reglements;
   private ReglementsDao reglementsDao;
   private transient DataModel datamodelElement = new ListDataModel();
   private List lesPeriodes = new ArrayList();
   private String periode;
   private CaissesJour caissesJour = new CaissesJour();
   private CaissesJourDao caissesJourDao;
   private List lescaissesJour = new ArrayList();
   private boolean afficheTJJ = false;
   private transient DataModel dataModelJour = new ListDataModel();
   private UIDataTable extDTableJour = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionJour = new SimpleSelection();
   private int nbJour;
   private String jourEnCours;
   private transient DataModel datamodelJournaux = new ListDataModel();
   private boolean afficheTJM = false;
   private transient DataModel dataModelMois = new ListDataModel();
   private UIDataTable extDTableMois = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionMois = new SimpleSelection();
   private UIDataTable extDTableJournaux = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionJournaux = new SimpleSelection();
   private List lescaissesActives = new ArrayList();
   private List lescaissesMois = new ArrayList();
   private CaissesMois caissesMois = new CaissesMois();
   private int nbPeriode;
   private List mesPeriodes = new ArrayList();
   private boolean sansChrono = false;
   private CaissesMoisDao caissesMoisDao;
   private List lesReglements;
   private double debitAnterieur;
   private double creditAnterieur;
   private double totalMvtsdebit;
   private double totalMvtscredit;
   private double soldefinalDeb;
   private double soldefinalCred;
   private double soldeCred;
   private double soldeDeb;
   private transient DataModel dataModelEspece = new ListDataModel();
   private transient DataModel dataModelCheque = new ListDataModel();
   private transient DataModel dataModelVirement = new ListDataModel();
   private transient DataModel dataModelTraite = new ListDataModel();
   private transient DataModel dataModelTpe = new ListDataModel();
   private transient DataModel dataModelTransfert = new ListDataModel();
   private transient DataModel dataModelePaiement = new ListDataModel();
   private transient DataModel dataModelCredoc = new ListDataModel();
   private transient DataModel dataModelFactor = new ListDataModel();
   private transient DataModel dataModelCompense = new ListDataModel();
   private transient DataModel dataModelTerme = new ListDataModel();
   private transient DataModel dataModelLettreGarantie = new ListDataModel();
   private transient DataModel dataModelPrelevement = new ListDataModel();
   private transient DataModel dataModelAlcoin = new ListDataModel();
   private transient DataModel dataModelBonsCaisse = new ListDataModel();
   private transient DataModel dataModelEcart = new ListDataModel();
   private transient DataModel dataModelErreur = new ListDataModel();
   private List lesEspeces;
   private List lesCheques;
   private List lesVirements;
   private List lesTraites;
   private List lesTpes;
   private List lesTransferts;
   private List lesePaiements;
   private List lesCredocs;
   private List lesFactors;
   private List lesCompenses;
   private List lesTermes;
   private List lesLettreGarantie;
   private List lesPrelevement;
   private List lesAlcoin;
   private List lesBonsCaisse;
   private List lesEcart;
   private List lesErreurs;
   private boolean var_afficheEspece;
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
   private boolean var_afficheLettreGarante;
   private boolean var_affichePrelevement;
   private boolean var_afficheAlcoin;
   private double soldeAnterieurEspece;
   private double depensesEspece;
   private double recettesEspece;
   private double soldeFinalEspece;
   private double soldeAnterieurCheque;
   private double depensesCheque;
   private double recettesCheque;
   private double soldeFinalCheque;
   private double soldeAnterieurVirement;
   private double depensesVirement;
   private double recettesVirement;
   private double soldeFinalVirement;
   private double soldeAnterieurTraite;
   private double depensesTraite;
   private double recettesTraite;
   private double soldeFinalTraite;
   private double soldeAnterieurTpe;
   private double depensesTpe;
   private double recettesTpe;
   private double soldeFinalTpe;
   private double soldeAnterieurTransfert;
   private double depensesTransfert;
   private double recettesTransfert;
   private double soldeFinalTransfert;
   private double soldeAnterieurePaiement;
   private double depensesePaiement;
   private double recettesePaiement;
   private double soldeFinalePaiement;
   private double soldeAnterieurCredoc;
   private double depensesCredoc;
   private double recettesCredoc;
   private double soldeFinalCredoc;
   private double soldeAnterieurFactor;
   private double depensesFactor;
   private double recettesFactor;
   private double soldeFinalFactor;
   private double soldeAnterieurCompense;
   private double depensesCompense;
   private double recettesCompense;
   private double soldeFinalCompense;
   private double soldeAnterieurTerme;
   private double soldeAnterieurLettreGarantie;
   private double soldeAnterieurPrelevement;
   private double soldeAnterieurAlcoin;
   private double depensesTerme;
   private double recettesTerme;
   private double depensesLettreGarantie;
   private double recettesLettreGarantie;
   private double depensesPrelevement;
   private double recettesPrelevement;
   private double depensesAlcoin;
   private double recettesAlcoin;
   private double soldeFinalTerme;
   private double soldeFinalLettreGarantie;
   private double soldeFinalPrelevement;
   private double soldeFinalAlcoin;
   private double soldeAnterieurBonCaisse;
   private double depensesBonCaisse;
   private double soldeFinalBonCaisse;
   private String var_mode_reglement;
   private List mesModeReglements;
   private boolean showModalPanelCloture = false;
   private int val_b1 = 0;
   private int val_b2 = 0;
   private int val_b3 = 0;
   private int val_b4 = 0;
   private int val_b5 = 0;
   private int val_b6 = 0;
   private int val_b7 = 0;
   private int val_b8 = 0;
   private int val_b9 = 0;
   private int val_b10 = 0;
   private int val_p1 = 0;
   private int val_p2 = 0;
   private int val_p3 = 0;
   private int val_p4 = 0;
   private int val_p5 = 0;
   private int val_p6 = 0;
   private int val_p7 = 0;
   private int val_p8 = 0;
   private int val_p9 = 0;
   private int val_p10 = 0;
   private double tot_b1 = 0.0D;
   private double tot_b2 = 0.0D;
   private double tot_b3 = 0.0D;
   private double tot_b4 = 0.0D;
   private double tot_b5 = 0.0D;
   private double tot_b6 = 0.0D;
   private double tot_b7 = 0.0D;
   private double tot_b8 = 0.0D;
   private double tot_b9 = 0.0D;
   private double tot_b10 = 0.0D;
   private double tot_p1 = 0.0D;
   private double tot_p2 = 0.0D;
   private double tot_p3 = 0.0D;
   private double tot_p4 = 0.0D;
   private double tot_p5 = 0.0D;
   private double tot_p6 = 0.0D;
   private double tot_p7 = 0.0D;
   private double tot_p8 = 0.0D;
   private double tot_p9 = 0.0D;
   private double tot_p10 = 0.0D;
   private double totalBillet = 0.0D;
   private double totalPiece = 0.0D;
   private String devise1 = "*";
   private String devise2 = "*";
   private String devise3 = "*";
   private String devise4 = "*";
   private String devise5 = "*";
   private double totalCaisse = 0.0D;
   private double ecart = 0.0D;
   private double soldeCorrection;
   private DeviseDao deviseDao;
   private Devise devise;
   private LectureDevises lectureDevises;
   private boolean showModalpanelDetail = false;
   private boolean projetActif;
   private List lesPostesBudgetaires;

   public FormJournauxCaisse() {
      this.datamodelElement = new ListDataModel();
      this.lesReglements = new ArrayList();
      this.reglements = new Reglements();
      this.lesEspeces = new ArrayList();
      this.lesCheques = new ArrayList();
      this.lesVirements = new ArrayList();
      this.lesTraites = new ArrayList();
      this.lesTpes = new ArrayList();
      this.lesTransferts = new ArrayList();
      this.lesePaiements = new ArrayList();
      this.lesCredocs = new ArrayList();
      this.lesFactors = new ArrayList();
      this.lesCompenses = new ArrayList();
      this.lesTermes = new ArrayList();
      this.lesLettreGarantie = new ArrayList();
      this.lesPrelevement = new ArrayList();
      this.lesAlcoin = new ArrayList();
      this.lesBonsCaisse = new ArrayList();
      this.lesEcart = new ArrayList();
      this.lesErreurs = new ArrayList();
      this.lectureDevises = new LectureDevises();
      this.lesPostesBudgetaires = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.caissesMoisDao = new CaissesMoisDao(this.baseLog, this.utilInitHibernate);
      this.caissesJourDao = new CaissesJourDao(this.baseLog, this.utilInitHibernate);
      this.deviseDao = new DeviseDao(this.baseLog, this.utilInitHibernate);
   }

   public void configCaisses(Session var1) throws HibernateException, NamingException {
      Object var2 = null;
      if (this.optionCaisses.getNbLigneMax() != null && !this.optionCaisses.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionCaisses.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionCaisses.getB1() != null && !this.optionCaisses.getB1().isEmpty()) {
         this.val_b1 = Integer.parseInt(this.optionCaisses.getB1());
      }

      if (this.optionCaisses.getB2() != null && !this.optionCaisses.getB2().isEmpty()) {
         this.val_b2 = Integer.parseInt(this.optionCaisses.getB2());
      }

      if (this.optionCaisses.getB3() != null && !this.optionCaisses.getB3().isEmpty()) {
         this.val_b3 = Integer.parseInt(this.optionCaisses.getB3());
      }

      if (this.optionCaisses.getB4() != null && !this.optionCaisses.getB4().isEmpty()) {
         this.val_b4 = Integer.parseInt(this.optionCaisses.getB4());
      }

      if (this.optionCaisses.getB5() != null && !this.optionCaisses.getB5().isEmpty()) {
         this.val_b5 = Integer.parseInt(this.optionCaisses.getB5());
      }

      if (this.optionCaisses.getB6() != null && !this.optionCaisses.getB6().isEmpty()) {
         this.val_b6 = Integer.parseInt(this.optionCaisses.getB6());
      }

      if (this.optionCaisses.getB7() != null && !this.optionCaisses.getB7().isEmpty()) {
         this.val_b7 = Integer.parseInt(this.optionCaisses.getB7());
      }

      if (this.optionCaisses.getB8() != null && !this.optionCaisses.getB8().isEmpty()) {
         this.val_b8 = Integer.parseInt(this.optionCaisses.getB8());
      }

      if (this.optionCaisses.getB9() != null && !this.optionCaisses.getB9().isEmpty()) {
         this.val_b9 = Integer.parseInt(this.optionCaisses.getB9());
      }

      if (this.optionCaisses.getB10() != null && !this.optionCaisses.getB10().isEmpty()) {
         this.val_b10 = Integer.parseInt(this.optionCaisses.getB10());
      }

      if (this.optionCaisses.getP1() != null && !this.optionCaisses.getP1().isEmpty()) {
         this.val_p1 = Integer.parseInt(this.optionCaisses.getP1());
      }

      if (this.optionCaisses.getP2() != null && !this.optionCaisses.getP2().isEmpty()) {
         this.val_p2 = Integer.parseInt(this.optionCaisses.getP2());
      }

      if (this.optionCaisses.getP3() != null && !this.optionCaisses.getP3().isEmpty()) {
         this.val_p3 = Integer.parseInt(this.optionCaisses.getP3());
      }

      if (this.optionCaisses.getP4() != null && !this.optionCaisses.getP4().isEmpty()) {
         this.val_p4 = Integer.parseInt(this.optionCaisses.getP4());
      }

      if (this.optionCaisses.getP5() != null && !this.optionCaisses.getP5().isEmpty()) {
         this.val_p5 = Integer.parseInt(this.optionCaisses.getP5());
      }

      if (this.optionCaisses.getP6() != null && !this.optionCaisses.getP6().isEmpty()) {
         this.val_p6 = Integer.parseInt(this.optionCaisses.getP6());
      }

      if (this.optionCaisses.getP7() != null && !this.optionCaisses.getP7().isEmpty()) {
         this.val_p7 = Integer.parseInt(this.optionCaisses.getP7());
      }

      if (this.optionCaisses.getP8() != null && !this.optionCaisses.getP8().isEmpty()) {
         this.val_p8 = Integer.parseInt(this.optionCaisses.getP8());
      }

      if (this.optionCaisses.getP9() != null && !this.optionCaisses.getP9().isEmpty()) {
         this.val_p9 = Integer.parseInt(this.optionCaisses.getP9());
      }

      if (this.optionCaisses.getP10() != null && !this.optionCaisses.getP10().isEmpty()) {
         this.val_p10 = Integer.parseInt(this.optionCaisses.getP10());
      }

      new ArrayList();
      List var3 = this.deviseDao.chargerLesDevises(var1);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            if (var4 == 0) {
               this.devise1 = ((Devise)var3.get(var4)).getDevCode();
            } else if (var4 == 1) {
               this.devise2 = ((Devise)var3.get(var4)).getDevCode();
            } else if (var4 == 2) {
               this.devise3 = ((Devise)var3.get(var4)).getDevCode();
            } else if (var4 == 3) {
               this.devise4 = ((Devise)var3.get(var4)).getDevCode();
            } else if (var4 == 4) {
            }
         }
      }

      this.devise5 = this.structureLog.getStrdevise();
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

   }

   public void accesResteintUser() {
   }

   public void accesResteintGroupe() {
   }

   public void calculPeriode() throws ParseException {
      this.jourEnCours = this.utilDate.dateToStringFrLg(new Date());
      this.nbPeriode = 0;
      this.mesPeriodes.clear();
      this.lesPeriodes.clear();
      Date var1 = this.selectedExo.getExecaiDateDebut();
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(var1);
      Date var3 = this.selectedExo.getExecaiDateFin();
      GregorianCalendar var4 = new GregorianCalendar();
      var4.setTime(var3);
      var2.add(2, -1);
      var4.add(2, -1);
      String var5 = null;

      while(var2.compareTo(var4) < 0) {
         var2.add(2, 1);
         Date var6 = var2.getTime();
         var5 = this.formatPeriode(var6);
         ++this.nbPeriode;
         this.mesPeriodes.add(var5);
         this.lesPeriodes.add(new SelectItem(var5));
      }

   }

   public String formatPeriode(Date var1) {
      SimpleDateFormat var2 = new SimpleDateFormat("dd-MM-yyyy");
      var2.format(var1);
      String var3 = "" + var2.format(var1);
      String[] var4 = var3.split("-");
      String var5 = var4[0];
      String var6 = var4[1];
      String var7 = var4[2];
      String var8 = var6 + ":" + var7;
      return var8;
   }

   public void chargerTypeReglement() {
      this.var_afficheEspece = false;
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
      this.var_afficheLettreGarante = false;
      this.var_affichePrelevement = false;
      this.var_afficheAlcoin = false;
      LectureTypeReglement var1 = new LectureTypeReglement(this.baseLog);
      new ArrayList();
      List var2 = var1.getMesTypeReglement();
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            new ObjetCompte();
            ObjetCompte var4 = (ObjetCompte)var2.get(var3);
            if (var4.isValide()) {
               if (var4.getCode().equals("0") && this.caissesCommerciales.getCaiJrEspece() != null && !this.caissesCommerciales.getCaiJrEspece().isEmpty() && !this.caissesCommerciales.getCaiJrEspece().equals("100") || var4.getCode().equals("11") && this.caissesCommerciales.getCaiJrEspeceST() != null && !this.caissesCommerciales.getCaiJrEspeceST().isEmpty() && !this.caissesCommerciales.getCaiJrEspeceST().equals("100")) {
                  this.var_afficheEspece = true;
               } else if (var4.getCode().equals("1") && this.caissesCommerciales.getCaiJrCheque() != null && !this.caissesCommerciales.getCaiJrCheque().isEmpty() && !this.caissesCommerciales.getCaiJrCheque().equals("100")) {
                  this.var_afficheCheque = true;
               } else if (var4.getCode().equals("2") && this.caissesCommerciales.getCaiJrVirement() != null && !this.caissesCommerciales.getCaiJrVirement().isEmpty() && !this.caissesCommerciales.getCaiJrVirement().equals("100")) {
                  this.var_afficheVirement = true;
               } else if (var4.getCode().equals("3") && this.caissesCommerciales.getCaiJrTraite() != null && !this.caissesCommerciales.getCaiJrTraite().isEmpty() && !this.caissesCommerciales.getCaiJrTraite().equals("100")) {
                  this.var_afficheTraite = true;
               } else if (var4.getCode().equals("4") && this.caissesCommerciales.getCaiJrTpe() != null && !this.caissesCommerciales.getCaiJrTpe().isEmpty() && !this.caissesCommerciales.getCaiJrTpe().equals("100")) {
                  this.var_afficheTpe = true;
               } else if (var4.getCode().equals("5") && this.caissesCommerciales.getCaiJrTransfert() != null && !this.caissesCommerciales.getCaiJrTransfert().isEmpty() && !this.caissesCommerciales.getCaiJrTransfert().equals("100")) {
                  this.var_afficheTransfert = true;
               } else if (var4.getCode().equals("6") && this.caissesCommerciales.getCaiJrePaiement() != null && !this.caissesCommerciales.getCaiJrePaiement().isEmpty() && !this.caissesCommerciales.getCaiJrePaiement().equals("100")) {
                  this.var_afficheePaiement = true;
               } else if (var4.getCode().equals("7") && this.caissesCommerciales.getCaiJrCredoc() != null && !this.caissesCommerciales.getCaiJrCredoc().isEmpty() && !this.caissesCommerciales.getCaiJrCredoc().equals("100")) {
                  this.var_afficheCredoc = true;
               } else if (var4.getCode().equals("8") && this.caissesCommerciales.getCaiJrFactor() != null && !this.caissesCommerciales.getCaiJrFactor().isEmpty() && !this.caissesCommerciales.getCaiJrFactor().equals("100")) {
                  this.var_afficheFactor = true;
               } else if (var4.getCode().equals("9") && this.caissesCommerciales.getCaiJrCompense() != null && !this.caissesCommerciales.getCaiJrCompense().isEmpty() && !this.caissesCommerciales.getCaiJrCompense().equals("100")) {
                  this.var_afficheCompense = true;
               } else if (var4.getCode().equals("10") && this.caissesCommerciales.getCaiJrTerme() != null && !this.caissesCommerciales.getCaiJrTerme().isEmpty() && !this.caissesCommerciales.getCaiJrTerme().equals("100")) {
                  this.var_afficheTerme = true;
               } else if (var4.getCode().equals("12") && this.caissesCommerciales.getCaiJrLettreGarantie() != null && !this.caissesCommerciales.getCaiJrLettreGarantie().isEmpty() && !this.caissesCommerciales.getCaiJrLettreGarantie().equals("100")) {
                  this.var_afficheLettreGarante = true;
               } else if (var4.getCode().equals("13") && this.caissesCommerciales.getCaiJrPrelevement() != null && !this.caissesCommerciales.getCaiJrPrelevement().isEmpty() && !this.caissesCommerciales.getCaiJrPrelevement().equals("100")) {
                  this.var_affichePrelevement = true;
               } else if (var4.getCode().equals("14") && this.caissesCommerciales.getCaiJrAlcoin() != null && !this.caissesCommerciales.getCaiJrAlcoin().isEmpty() && !this.caissesCommerciales.getCaiJrAlcoin().equals("100")) {
                  this.var_afficheAlcoin = true;
               }
            }
         }
      }

   }

   public void chargerCaisseCommerciale(Session var1) throws HibernateException, NamingException {
      this.lescaissesActives.clear();
      new ArrayList();
      List var2;
      int var3;
      if (this.optionCaisses.getAccesJournaux().equals("0")) {
         var2 = this.usersChronoDao.selectListCaisseByUser(this.usersLog, var1);
         if (var2.size() > 1) {
            for(var3 = 0; var3 < var2.size(); ++var3) {
               this.usersChrono = (UsersChrono)var2.get(var3);
               if (this.usersChrono.getUsrchrJournal() == 1) {
                  this.caissesCommerciales = this.caissesCommercialesDao.selectCaisseByCode(this.usersChrono.getUsrchrCodeCaisse(), this.lastExo, var1);
                  if (this.caissesCommerciales != null) {
                     this.lescaissesActives.add(this.caissesCommerciales);
                  }
               }
            }
         }
      } else if (this.optionCaisses.getAccesJournaux().equals("1")) {
         var2 = this.usersChronoDao.selectListRecuByUser(this.usersLog, var1);
         if (var2.size() != 0) {
            for(var3 = 0; var3 < var2.size(); ++var3) {
               this.usersChrono = (UsersChrono)var2.get(var3);
               this.caissesCommerciales = this.caissesCommercialesDao.selectCaisseByCode(this.usersChrono.getUsrchrCodeCaisse(), this.lastExo, var1);
               if (this.caissesCommerciales != null) {
                  this.lescaissesActives.add(this.caissesCommerciales);
               }
            }
         }
      }

      this.datamodelJournaux.setWrappedData(this.lescaissesActives);
   }

   public void selectionJournalMensuel() throws HibernateException, NamingException {
      if (this.extDTableJournaux != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionJournaux.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableJournaux.setRowKey(var3);
            if (this.extDTableJournaux.isRowAvailable()) {
               var1.add(this.extDTableJournaux.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.extDTableMois = new HtmlExtendedDataTable();
            this.simpleSelectionMois.clear();
            this.extDTableJour = new HtmlExtendedDataTable();
            this.simpleSelectionJour.clear();
            this.caissesCommerciales = (CaissesCommerciales)var1.get(0);
            this.afficheTJM = true;
            this.afficheTJJ = false;
            if (this.caissesCommerciales.getCaiNom().contains("(***SANS CHRONO***)")) {
               this.sansChrono = true;
            } else {
               this.sansChrono = false;
            }

            this.lescaissesMois.clear();
            this.lescaissesMois = this.caissesMoisDao.mesjournauxmois(this.caissesCommerciales.getCaiCode(), this.selectedExo, (Session)null);
            if (this.nbPeriode > this.lescaissesMois.size()) {
               this.caissesMoisDao.ajoutPeriode(this.caissesCommerciales, this.selectedExo, this.mesPeriodes);
               this.lescaissesMois.clear();
               this.lescaissesMois = this.caissesMoisDao.mesjournauxmois(this.caissesCommerciales.getCaiCode(), this.selectedExo, (Session)null);
            }

            this.dataModelMois.setWrappedData(this.lescaissesMois);
            this.caissesMois = null;
         }
      }

   }

   public void selectionMoisSaisieLight() throws HibernateException, NamingException, ParseException {
      if (this.caissesCommerciales != null && this.extDTableJournaux != null) {
         int var1 = 0;
         ArrayList var2 = new ArrayList();
         Iterator var3 = this.simpleSelectionMois.getKeys();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            var1 = Integer.parseInt(var4.toString());
            this.extDTableMois.setRowKey(var4);
            if (this.extDTableMois.isRowAvailable()) {
               var2.add(this.extDTableMois.getRowData());
            }
         }

         for(int var5 = 0; var5 < this.lescaissesMois.size(); ++var5) {
            this.caissesMois = (CaissesMois)this.lescaissesMois.get(var5);
            if (var5 == var1) {
               this.caissesMois.setSelect(true);
            } else {
               this.caissesMois.setSelect(false);
            }
         }

         this.dataModelMois.setWrappedData(this.lescaissesMois);
         if (var2.size() != 0) {
            this.caissesMois = (CaissesMois)var2.get(0);
         }
      }

   }

   public void selectionMoisSaisie() throws HibernateException, NamingException, ParseException {
      this.dataModelEspece = new ListDataModel();
      this.dataModelCheque = new ListDataModel();
      this.dataModelVirement = new ListDataModel();
      this.dataModelTraite = new ListDataModel();
      this.dataModelTpe = new ListDataModel();
      this.dataModelTransfert = new ListDataModel();
      this.dataModelePaiement = new ListDataModel();
      this.dataModelCredoc = new ListDataModel();
      this.dataModelFactor = new ListDataModel();
      this.dataModelCompense = new ListDataModel();
      this.dataModelTerme = new ListDataModel();
      this.dataModelLettreGarantie = new ListDataModel();
      this.dataModelPrelevement = new ListDataModel();
      this.dataModelAlcoin = new ListDataModel();
      this.dataModelBonsCaisse = new ListDataModel();
      if (this.caissesCommerciales != null && this.dataModelMois.isRowAvailable()) {
         this.caissesMois = (CaissesMois)this.dataModelMois.getRowData();
         this.caissesMois = this.caissesMoisDao.recupererCaissesMois(this.caissesMois.getCaimenCle1(), (Session)null);
         if (this.caissesMois != null) {
            this.ouvrirLeJournalEncours();
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
            this.ChargerLesEcritures(var1);
            if (this.caissesMois.getCaimenEtat() != 0) {
               this.var_action = 3;
            } else if (this.selectedExo.getExecaiId() != this.lastExo.getExecaiId()) {
               this.var_action = 3;
            } else {
               this.var_action = 1;
            }

            this.var_memo_action = this.var_action;
            this.utilInitHibernate.closeSession();
            this.chargerTypeReglement();
         }
      }

   }

   public void ouvrirLeJournalEncours() throws HibernateException, NamingException {
      if (this.caissesMois != null) {
         this.caissesMois.setCaimenOpenJournal(1);
         if (this.usersLog.getUsrPatronyme() != null && !this.usersLog.getUsrPatronyme().isEmpty()) {
            this.caissesMois.setCaimenOpenUserJournal(this.usersLog.getUsrPatronyme());
         } else {
            this.caissesMois.setCaimenOpenUserJournal(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         }

         this.caissesMois.setCaimenUserIdCaisse(this.usersLog.getUsrid());
         this.caissesMois = this.caissesMoisDao.majJournal(this.caissesMois);
      }

   }

   public void fermerLeJournalEncours() throws NamingException, JDOMException, IOException {
      if (this.caissesMois != null) {
         this.caissesMois.setCaimenOpenUserJournal("");
         this.caissesMois.setCaimenOpenJournal(0);
         this.caissesMois.setCaimenUserIdCaisse(0L);
         this.caissesMois = this.caissesMoisDao.majJournal(this.caissesMois);
         this.afficheTJM = true;
         this.var_action = 0;
      }

   }

   public void calculerSoldeAnterieur(Session var1) throws NamingException, ParseException {
      this.debitAnterieur = 0.0D;
      this.creditAnterieur = 0.0D;
      boolean var2 = false;
      new ArrayList();
      List var3 = this.caissesMoisDao.listeDateDebut(this.caissesMois.getCaimenCode(), this.caissesMois.getCaimenPeriode(), this.selectedExo, var1);
      CaissesMois var4 = new CaissesMois();
      boolean var5 = false;
      if (var3.size() != 0) {
         int var6 = 0;

         for(int var7 = var3.size() - 1; var7 >= 0; --var7) {
            var4 = (CaissesMois)var3.get(var7);
            ++var6;
            if (var4.getCaimenEtat() == 1) {
               var5 = true;
               if (var6 == 1) {
                  var2 = true;
               }
               break;
            }
         }
      }

      ExercicesCaisse var71;
      if (!var5) {
         new ExercicesCaisse();
         ExercicesCaisseDao var72 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
         var71 = var72.recupererLExoSelect(this.selectedExo.getExecaiId() - 1L, var1);
         int var8;
         if (var71 != null) {
            var3 = this.caissesMoisDao.listeDateDebut(this.caissesMois.getCaimenCode(), this.caissesMois.getCaimenPeriode(), var71, var1);
            var4 = new CaissesMois();
            var5 = false;
            if (var3.size() != 0) {
               for(var8 = var3.size() - 1; var8 >= 0; --var8) {
                  var4 = (CaissesMois)var3.get(var8);
                  if (var4.getCaimenEtat() == 1) {
                     var5 = true;
                     break;
                  }
               }
            }
         }

         if (!var5) {
            var71 = var72.recupererLExoSelect(this.selectedExo.getExecaiId() - 2L, var1);
            if (var71 != null) {
               var3 = this.caissesMoisDao.listeDateDebut(this.caissesMois.getCaimenCode(), this.caissesMois.getCaimenPeriode(), var71, var1);
               var4 = new CaissesMois();
               var5 = false;
               if (var3.size() != 0) {
                  for(var8 = var3.size() - 1; var8 >= 0; --var8) {
                     var4 = (CaissesMois)var3.get(var8);
                     if (var4.getCaimenEtat() == 1) {
                        var5 = true;
                        break;
                     }
                  }
               }
            }

            if (!var5) {
               var71 = var72.recupererLExoSelect(this.selectedExo.getExecaiId() - 3L, var1);
               if (var71 != null) {
                  var3 = this.caissesMoisDao.listeDateDebut(this.caissesMois.getCaimenCode(), this.caissesMois.getCaimenPeriode(), var71, var1);
                  var4 = new CaissesMois();
                  var5 = false;
                  if (var3.size() != 0) {
                     for(var8 = var3.size() - 1; var8 >= 0; --var8) {
                        var4 = (CaissesMois)var3.get(var8);
                        if (var4.getCaimenEtat() == 1) {
                           var5 = true;
                           break;
                        }
                     }
                  }
               }
            }
         }
      }

      var71 = null;
      Date var73;
      if (var5) {
         String[] var74 = var4.getCaimenPeriode().split(":");
         var73 = this.utilDate.stringToDateSQLLight(var74[1] + "-" + var74[0] + "- 01");
         this.soldeAnterieurEspece = var4.getCaimenSoldeEspece();
         this.soldeAnterieurCheque = var4.getCaimenSoldeCheque();
         this.soldeAnterieurVirement = var4.getCaimenSoldeVirement();
         this.soldeAnterieurTraite = var4.getCaimenSoldeTraite();
         this.soldeAnterieurTpe = var4.getCaimenSoldeTpe();
         this.soldeAnterieurTransfert = var4.getCaimenSoldeTransfert();
         this.soldeAnterieurePaiement = var4.getCaimenSoldeePaiement();
         this.soldeAnterieurCredoc = var4.getCaimenSoldeCredoc();
         this.soldeAnterieurFactor = var4.getCaimenSoldeFactor();
         this.soldeAnterieurCompense = var4.getCaimenSoldeCompense();
         this.soldeAnterieurTerme = var4.getCaimenSoldeTerme();
         this.soldeAnterieurLettreGarantie = var4.getCaimenSoldeLettreGarantie();
         this.soldeAnterieurPrelevement = var4.getCaimenSoldePrelevement();
         this.soldeAnterieurAlcoin = var4.getCaimenSoldeAlcoin();
         this.soldeAnterieurBonCaisse = var4.getCaimenSoldeBonCaisse();
      } else {
         var73 = this.caissesCommerciales.getCaiDateInit();
         if (var73 == null) {
            var73 = this.selectedExo.getExecaiDateDebut();
         }

         this.soldeAnterieurEspece = this.caissesCommerciales.getCaiMontantInitEspece();
         this.soldeAnterieurCheque = this.caissesCommerciales.getCaiMontantInitCheque();
         this.soldeAnterieurVirement = this.caissesCommerciales.getCaiMontantInitVirement();
         this.soldeAnterieurTraite = this.caissesCommerciales.getCaiMontantInitTraite();
         this.soldeAnterieurTpe = this.caissesCommerciales.getCaiMontantInitTpe();
         this.soldeAnterieurTransfert = this.caissesCommerciales.getCaiMontantInitTransfert();
         this.soldeAnterieurePaiement = this.caissesCommerciales.getCaiMontantInitePaiement();
         this.soldeAnterieurCredoc = this.caissesCommerciales.getCaiMontantInitCredoc();
         this.soldeAnterieurFactor = this.caissesCommerciales.getCaiMontantInitFactor();
         this.soldeAnterieurCompense = this.caissesCommerciales.getCaiMontantInitCompense();
         this.soldeAnterieurTerme = this.caissesCommerciales.getCaiMontantInitTerme();
         this.soldeAnterieurLettreGarantie = this.caissesCommerciales.getCaiMontantInitLettreGarantie();
         this.soldeAnterieurPrelevement = this.caissesCommerciales.getCaiMontantInitPrelevement();
         this.soldeAnterieurAlcoin = this.caissesCommerciales.getCaiMontantInitAlcoin();
         this.soldeAnterieurBonCaisse = 0.0D;
      }

      if (!var2) {
         double var75 = 0.0D;
         double var9 = 0.0D;
         double var11 = 0.0D;
         double var13 = 0.0D;
         double var15 = 0.0D;
         double var17 = 0.0D;
         double var19 = 0.0D;
         double var21 = 0.0D;
         double var23 = 0.0D;
         double var25 = 0.0D;
         double var27 = 0.0D;
         double var29 = 0.0D;
         double var31 = 0.0D;
         double var33 = 0.0D;
         double var35 = 0.0D;
         double var37 = 0.0D;
         double var39 = 0.0D;
         double var41 = 0.0D;
         double var43 = 0.0D;
         double var45 = 0.0D;
         double var47 = 0.0D;
         double var49 = 0.0D;
         double var51 = 0.0D;
         double var53 = 0.0D;
         double var55 = 0.0D;
         double var57 = 0.0D;
         double var59 = 0.0D;
         double var61 = 0.0D;
         String[] var63 = this.caissesMois.getCaimenPeriode().split(":");
         String var64 = var63[1] + "-" + var63[0] + "-01";
         Date var65 = this.utilDate.stringToDateSQLLight(var64);
         new ArrayList();
         var73 = this.utilDate.dateDernierJourMois(var73);
         List var66 = this.reglementsDao.calculToutSoldeAnterieur(this.caissesMois.getCaimenCode(), var73, var65, var1);
         if (var66.size() != 0) {
            new Reglements();

            for(int var68 = 0; var68 < var66.size(); ++var68) {
               Reglements var67 = (Reglements)var66.get(var68);
               if (var67.getRglImp() == 0 && var67.getRglCodeCaiss() != null && !var67.getRglCodeCaiss().isEmpty() && !var67.getRglCodeCaiss().equals(this.caissesMois.getCaimenCode())) {
                  double var69 = var67.getRglRecette();
                  var67.setRglRecette(var67.getRglDepense());
                  var67.setRglDepense(var69);
               }

               if (var67.getRglOperation() == null || var67.getRglOperation().isEmpty()) {
                  var67.setRglOperation("00");
               }

               var67.setSel_ecriture(false);
               if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 11) {
                  var67.setRglTypeReg(0);
               } else if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 10) {
                  var67.setRglTypeReg(0);
               } else if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 100) {
                  var67.setRglTypeReg(0);
               }

               if (var67.getRglImp() != 0 || var67.getRglTypeReg() != 0 && (var67.getRglCategorie() != 64 || !var67.getRglOperation().equals("71") && !var67.getRglOperation().equals("73") && !var67.getRglOperation().equals("77") && !var67.getRglOperation().equals("80") && !var67.getRglOperation().equals("85"))) {
                  if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 1) {
                     if (var67.getRglOperation() != null && !var67.getRglOperation().isEmpty() && var67.getRglOperation().equals("81")) {
                        var67.setRglNumMvt1(var67.getRglNum());
                     }

                     var11 += var67.getRglDepense();
                     var13 += var67.getRglRecette();
                  } else if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 2) {
                     var15 += var67.getRglDepense();
                     var17 += var67.getRglRecette();
                  } else if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 3) {
                     var19 += var67.getRglDepense();
                     var21 += var67.getRglRecette();
                  } else if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 4) {
                     var23 += var67.getRglDepense();
                     var25 += var67.getRglRecette();
                  } else if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 5) {
                     var27 += var67.getRglDepense();
                     var29 += var67.getRglRecette();
                  } else if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 6) {
                     var31 += var67.getRglDepense();
                     var33 += var67.getRglRecette();
                  } else if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 7) {
                     var35 += var67.getRglDepense();
                     var37 += var67.getRglRecette();
                  } else if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 8) {
                     var39 += var67.getRglDepense();
                     var41 += var67.getRglRecette();
                  } else if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 9) {
                     var43 += var67.getRglDepense();
                     var45 += var67.getRglRecette();
                  } else if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 10) {
                     var47 += var67.getRglDepense();
                     var49 += var67.getRglRecette();
                  } else if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 12) {
                     var51 += var67.getRglDepense();
                     var53 += var67.getRglRecette();
                  } else if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 13) {
                     var55 += var67.getRglDepense();
                     var57 += var67.getRglRecette();
                  } else if (var67.getRglImp() == 0 && var67.getRglTypeReg() == 14) {
                     var59 += var67.getRglDepense();
                     var61 += var67.getRglRecette();
                  }
               } else {
                  var75 += var67.getRglDepense();
                  var9 += var67.getRglRecette();
               }
            }

            this.soldeAnterieurEspece = this.soldeAnterieurEspece + var9 - var75;
            this.soldeAnterieurCheque = this.soldeAnterieurCheque + var13 - var11;
            this.soldeAnterieurVirement = this.soldeAnterieurVirement + var17 - var15;
            this.soldeAnterieurTraite = this.soldeAnterieurTraite + var21 - var19;
            this.soldeAnterieurTpe = this.soldeAnterieurTpe + var25 - var23;
            this.soldeAnterieurTransfert = this.soldeAnterieurTransfert + var29 - var27;
            this.soldeAnterieurePaiement = this.soldeAnterieurePaiement + var33 - var31;
            this.soldeAnterieurCredoc = this.soldeAnterieurCredoc + var37 - var35;
            this.soldeAnterieurFactor = this.soldeAnterieurFactor + var41 - var39;
            this.soldeAnterieurCompense = this.soldeAnterieurCompense + var45 - var43;
            this.soldeAnterieurTerme = this.soldeAnterieurTerme + var49 - var47;
            this.soldeAnterieurLettreGarantie = this.soldeAnterieurLettreGarantie + var53 - var51;
            this.soldeAnterieurPrelevement = this.soldeAnterieurPrelevement + var57 - var55;
            this.soldeAnterieurAlcoin = this.soldeAnterieurAlcoin + var61 - var59;
         }
      }

   }

   public String convertitrPeriodeSql(String var1) {
      String[] var2 = var1.split(":");
      String var3 = var2[0];
      String var4 = var2[1];
      String var5 = var4 + "-" + var3;
      return var5;
   }

   public void ChargerLesEcritures(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesReglements.clear();
      if (this.caissesCommerciales != null) {
         this.lesEspeces.clear();
         this.lesCheques.clear();
         this.lesVirements.clear();
         this.lesTraites.clear();
         this.lesTpes.clear();
         this.lesTransferts.clear();
         this.lesePaiements.clear();
         this.lesCredocs.clear();
         this.lesFactors.clear();
         this.lesCompenses.clear();
         this.lesTermes.clear();
         this.lesLettreGarantie.clear();
         this.lesPrelevement.clear();
         this.lesAlcoin.clear();
         this.lesBonsCaisse.clear();
         this.lesEcart.clear();
         this.lesErreurs.clear();
         new ArrayList();
         List var2 = this.reglementsDao.reglementMensuel(this.caissesMois.getCaimenCle1(), var1);
         Reglements var3;
         int var4;
         if (var2.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < var2.size(); ++var4) {
               var3 = (Reglements)var2.get(var4);
               if (var3.getRglCodeCaiss() != null && !var3.getRglCodeCaiss().isEmpty() && !var3.getRglCodeCaiss().equals(this.caissesMois.getCaimenCode())) {
                  double var5 = var3.getRglRecette();
                  var3.setRglRecette(var3.getRglDepense());
                  var3.setRglDepense(var5);
               }

               if (var3.getRglOperation() == null || var3.getRglOperation().isEmpty()) {
                  var3.setRglOperation("00");
               }

               if (this.typeVente == 815 && var3.getRglService() != null && !var3.getRglService().isEmpty()) {
                  var3.setRglObjet(var3.getRglService());
                  if (var3.getRglPdv() != null && !var3.getRglPdv().isEmpty()) {
                     var3.setRglObjet(var3.getRglObjet() + " / " + var3.getRglPdv());
                  }
               }

               var3.setSel_ecriture(false);
               if (var3.getRglImp() == 0) {
                  this.lesReglements.add(var3);
               }

               if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 11) {
                  var3.setRglTypeReg(0);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 10) {
                  var3.setRglTypeReg(0);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 100) {
                  var3.setRglTypeReg(0);
               }

               if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 0) {
                  this.lesEspeces.add(var3);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 1) {
                  if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty() && var3.getRglOperation().equals("81")) {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }

                  this.lesCheques.add(var3);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 2) {
                  if ((var3.getRglCodeEmetrice() == null || var3.getRglCodeEmetrice().isEmpty()) && var3.getRglCodeReceptrice() != null && !var3.getRglCodeReceptrice().isEmpty()) {
                     var3.setRglCodeEmetrice(var3.getRglCodeReceptrice());
                     var3.setRglLibEmetrice(var3.getRglLibReceptrice());
                  }

                  this.lesVirements.add(var3);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 3) {
                  this.lesTraites.add(var3);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 4) {
                  this.lesTpes.add(var3);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 5) {
                  this.lesTransferts.add(var3);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 6) {
                  this.lesePaiements.add(var3);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 7) {
                  this.lesCredocs.add(var3);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 8) {
                  this.lesFactors.add(var3);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 9) {
                  this.lesCompenses.add(var3);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 10) {
                  this.lesTermes.add(var3);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 12) {
                  this.lesLettreGarantie.add(var3);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 13) {
                  this.lesPrelevement.add(var3);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 14) {
                  this.lesAlcoin.add(var3);
               } else if (var3.getRglImp() == 0) {
                  this.lesErreurs.add(var3);
               }
            }
         }

         this.dataModelEspece.setWrappedData(this.lesEspeces);
         this.dataModelCheque.setWrappedData(this.lesCheques);
         this.dataModelVirement.setWrappedData(this.lesVirements);
         this.dataModelTraite.setWrappedData(this.lesTraites);
         this.dataModelTpe.setWrappedData(this.lesTpes);
         this.dataModelTransfert.setWrappedData(this.lesTransferts);
         this.dataModelePaiement.setWrappedData(this.lesePaiements);
         this.dataModelCredoc.setWrappedData(this.lesCredocs);
         this.dataModelFactor.setWrappedData(this.lesFactors);
         this.dataModelCompense.setWrappedData(this.lesCompenses);
         this.dataModelTerme.setWrappedData(this.lesTermes);
         this.dataModelLettreGarantie.setWrappedData(this.lesLettreGarantie);
         this.dataModelPrelevement.setWrappedData(this.lesPrelevement);
         this.dataModelAlcoin.setWrappedData(this.lesAlcoin);
         this.dataModelErreur.setWrappedData(this.lesErreurs);
         this.datamodelElement.setWrappedData(this.lesReglements);
         this.lesBonsCaisse = this.reglementsDao.reglementMensuelBonCaisse(this.caissesMois.getCaimenCle1(), var1);
         this.dataModelBonsCaisse.setWrappedData(this.lesBonsCaisse);
         this.lesEcart = this.reglementsDao.reglementMensuelEcart(this.caissesMois.getCaimenCle1(), var1);
         this.dataModelEcart.setWrappedData(this.lesEcart);
         this.soldeAnterieurEspece = 0.0D;
         this.depensesEspece = 0.0D;
         this.recettesEspece = 0.0D;
         this.soldeFinalEspece = 0.0D;
         this.soldeAnterieurCheque = 0.0D;
         this.depensesCheque = 0.0D;
         this.recettesCheque = 0.0D;
         this.soldeFinalCheque = 0.0D;
         this.soldeAnterieurVirement = 0.0D;
         this.depensesVirement = 0.0D;
         this.recettesVirement = 0.0D;
         this.soldeFinalVirement = 0.0D;
         this.soldeAnterieurTraite = 0.0D;
         this.depensesTraite = 0.0D;
         this.recettesTraite = 0.0D;
         this.soldeFinalTraite = 0.0D;
         this.soldeAnterieurTpe = 0.0D;
         this.depensesTpe = 0.0D;
         this.recettesTpe = 0.0D;
         this.soldeFinalTpe = 0.0D;
         this.soldeAnterieurTransfert = 0.0D;
         this.depensesTransfert = 0.0D;
         this.recettesTransfert = 0.0D;
         this.soldeFinalTransfert = 0.0D;
         this.soldeAnterieurePaiement = 0.0D;
         this.depensesePaiement = 0.0D;
         this.recettesePaiement = 0.0D;
         this.soldeFinalePaiement = 0.0D;
         this.soldeAnterieurCredoc = 0.0D;
         this.depensesCredoc = 0.0D;
         this.recettesCredoc = 0.0D;
         this.soldeFinalCredoc = 0.0D;
         this.soldeAnterieurFactor = 0.0D;
         this.depensesFactor = 0.0D;
         this.recettesFactor = 0.0D;
         this.soldeFinalFactor = 0.0D;
         this.soldeAnterieurCompense = 0.0D;
         this.depensesCompense = 0.0D;
         this.recettesCompense = 0.0D;
         this.soldeFinalCompense = 0.0D;
         this.soldeAnterieurTerme = 0.0D;
         this.depensesTerme = 0.0D;
         this.recettesTerme = 0.0D;
         this.soldeFinalTerme = 0.0D;
         this.soldeAnterieurLettreGarantie = 0.0D;
         this.depensesLettreGarantie = 0.0D;
         this.recettesLettreGarantie = 0.0D;
         this.soldeFinalLettreGarantie = 0.0D;
         this.soldeAnterieurPrelevement = 0.0D;
         this.depensesPrelevement = 0.0D;
         this.recettesPrelevement = 0.0D;
         this.soldeFinalPrelevement = 0.0D;
         this.soldeAnterieurAlcoin = 0.0D;
         this.depensesAlcoin = 0.0D;
         this.recettesAlcoin = 0.0D;
         this.soldeFinalAlcoin = 0.0D;
         this.soldeAnterieurBonCaisse = 0.0D;
         this.depensesBonCaisse = 0.0D;
         this.soldeFinalBonCaisse = 0.0D;
         this.calculerSoldeAnterieur(var1);
         if (this.lesEspeces.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesEspeces.size(); ++var4) {
               var3 = (Reglements)this.lesEspeces.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesEspece += var3.getVal_depense();
               this.recettesEspece += var3.getVal_recette();
            }
         }

         this.soldeFinalEspece = this.soldeAnterieurEspece + this.recettesEspece - this.depensesEspece;
         if (this.lesCheques.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesCheques.size(); ++var4) {
               var3 = (Reglements)this.lesCheques.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesCheque += var3.getRglDepense();
               this.recettesCheque += var3.getRglRecette();
            }
         }

         this.soldeFinalCheque = this.soldeAnterieurCheque + this.recettesCheque - this.depensesCheque;
         if (this.lesVirements.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesVirements.size(); ++var4) {
               var3 = (Reglements)this.lesVirements.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesVirement += var3.getRglDepense();
               this.recettesVirement += var3.getRglRecette();
            }
         }

         this.soldeFinalVirement = this.soldeAnterieurVirement + this.recettesVirement - this.depensesVirement;
         if (this.lesTraites.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesTraites.size(); ++var4) {
               var3 = (Reglements)this.lesTraites.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesTraite += var3.getRglDepense();
               this.recettesTraite += var3.getRglRecette();
            }
         }

         this.soldeFinalTraite = this.soldeAnterieurTraite + this.recettesTraite - this.depensesTraite;
         if (this.lesTpes.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesTpes.size(); ++var4) {
               var3 = (Reglements)this.lesTpes.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesTpe += var3.getRglDepense();
               this.recettesTpe += var3.getRglRecette();
            }
         }

         this.soldeFinalTpe = this.soldeAnterieurTpe + this.recettesTpe - this.depensesTpe;
         if (this.lesTransferts.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesTransferts.size(); ++var4) {
               var3 = (Reglements)this.lesTransferts.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesTransfert += var3.getRglDepense();
               this.recettesTransfert += var3.getRglRecette();
            }
         }

         this.soldeFinalTransfert = this.soldeAnterieurTransfert + this.recettesTransfert - this.depensesTransfert;
         if (this.lesePaiements.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesePaiements.size(); ++var4) {
               var3 = (Reglements)this.lesePaiements.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesePaiement += var3.getRglDepense();
               this.recettesePaiement += var3.getRglRecette();
            }
         }

         this.soldeFinalePaiement = this.soldeAnterieurePaiement + this.recettesePaiement - this.depensesePaiement;
         if (this.lesCredocs.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesCredocs.size(); ++var4) {
               var3 = (Reglements)this.lesCredocs.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesCredoc += var3.getRglDepense();
               this.recettesCredoc += var3.getRglRecette();
            }
         }

         this.soldeFinalCredoc = this.soldeAnterieurCredoc + this.recettesCredoc - this.depensesCredoc;
         if (this.lesFactors.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesFactors.size(); ++var4) {
               var3 = (Reglements)this.lesFactors.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesFactor += var3.getRglDepense();
               this.recettesFactor += var3.getRglRecette();
            }
         }

         this.soldeFinalFactor = this.soldeAnterieurFactor + this.recettesFactor - this.depensesFactor;
         if (this.lesCompenses.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesCompenses.size(); ++var4) {
               var3 = (Reglements)this.lesCompenses.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesCompense += var3.getRglDepense();
               this.recettesCompense += var3.getRglRecette();
            }
         }

         this.soldeFinalCompense = this.soldeAnterieurCompense + this.recettesCompense - this.depensesCompense;
         if (this.lesTermes.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesTermes.size(); ++var4) {
               var3 = (Reglements)this.lesTermes.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesTerme += var3.getRglDepense();
               this.recettesTerme += var3.getRglRecette();
            }
         }

         this.soldeFinalTerme = this.soldeAnterieurTerme + this.recettesTerme - this.depensesTerme;
         if (this.lesBonsCaisse.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesBonsCaisse.size(); ++var4) {
               var3 = (Reglements)this.lesBonsCaisse.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesBonCaisse += var3.getRglDepense();
            }
         }

         this.soldeFinalBonCaisse = this.soldeAnterieurBonCaisse - this.depensesBonCaisse;
         if (this.lesLettreGarantie.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesLettreGarantie.size(); ++var4) {
               var3 = (Reglements)this.lesLettreGarantie.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesLettreGarantie += var3.getRglDepense();
               this.recettesLettreGarantie += var3.getRglRecette();
            }
         }

         this.soldeFinalLettreGarantie = this.soldeAnterieurLettreGarantie + this.recettesLettreGarantie - this.depensesLettreGarantie;
         if (this.lesPrelevement.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesPrelevement.size(); ++var4) {
               var3 = (Reglements)this.lesPrelevement.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesPrelevement += var3.getRglDepense();
               this.recettesPrelevement += var3.getRglRecette();
            }
         }

         this.soldeFinalPrelevement = this.soldeAnterieurPrelevement + this.recettesPrelevement - this.depensesPrelevement;
         if (this.lesAlcoin.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesAlcoin.size(); ++var4) {
               var3 = (Reglements)this.lesAlcoin.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesAlcoin += var3.getRglDepense();
               this.recettesAlcoin += var3.getRglRecette();
            }
         }

         this.soldeFinalAlcoin = this.soldeAnterieurAlcoin + this.recettesAlcoin - this.depensesAlcoin;
         double var7 = this.soldeAnterieurEspece + this.soldeAnterieurCheque + this.soldeAnterieurVirement + this.soldeAnterieurTraite + this.soldeAnterieurTpe + this.soldeAnterieurTransfert + this.soldeAnterieurePaiement + this.soldeAnterieurCredoc + this.soldeAnterieurFactor + this.soldeAnterieurCompense + this.soldeAnterieurTerme + this.soldeAnterieurLettreGarantie + this.soldeAnterieurPrelevement + this.soldeAnterieurAlcoin;
         if (var7 < 0.0D) {
            this.debitAnterieur = var7 * -1.0D;
            this.creditAnterieur = 0.0D;
         } else {
            this.debitAnterieur = 0.0D;
            this.creditAnterieur = var7;
         }

         this.totalMvtsdebit = this.depensesEspece + this.depensesCheque + this.depensesVirement + this.depensesTraite + this.depensesTpe + this.depensesTransfert + this.depensesePaiement + this.depensesCredoc + this.depensesFactor + this.depensesCompense + this.depensesTerme + this.depensesLettreGarantie + this.depensesPrelevement + this.depensesPrelevement;
         this.totalMvtscredit = this.recettesEspece + this.recettesCheque + this.recettesVirement + this.recettesTraite + this.recettesTpe + this.recettesTransfert + this.recettesePaiement + this.recettesCredoc + this.recettesFactor + this.recettesCompense + this.recettesTerme + this.recettesLettreGarantie + this.recettesPrelevement + this.recettesAlcoin;
         if (this.totalMvtsdebit > this.totalMvtscredit) {
            this.soldeDeb = this.totalMvtscredit - this.totalMvtsdebit;
            this.soldeCred = 0.0D;
         } else {
            this.soldeDeb = 0.0D;
            this.soldeCred = this.totalMvtscredit - this.totalMvtsdebit;
         }

         if (this.debitAnterieur + this.totalMvtsdebit > this.creditAnterieur + this.totalMvtscredit) {
            this.soldefinalDeb = this.debitAnterieur + this.totalMvtsdebit - (this.creditAnterieur + this.totalMvtscredit);
            this.soldefinalCred = 0.0D;
         } else {
            this.soldefinalDeb = 0.0D;
            this.soldefinalCred = this.creditAnterieur + this.totalMvtscredit - (this.debitAnterieur + this.totalMvtsdebit);
         }
      }

   }

   public void selectionReglement() {
      this.reglements = new Reglements();
      if (this.var_type_onglet == 99) {
         if (this.datamodelElement.isRowAvailable()) {
            this.reglements = (Reglements)this.datamodelElement.getRowData();
         }
      } else if (this.var_type_onglet == 90) {
         if (this.dataModelBonsCaisse.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelBonsCaisse.getRowData();
         }
      } else if (this.var_type_onglet == 91) {
         if (this.dataModelEcart.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelEcart.getRowData();
         }
      } else if (this.var_type_onglet == 92) {
         if (this.dataModelErreur.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelErreur.getRowData();
         }
      } else if (this.var_type_onglet == 0) {
         if (this.dataModelEspece.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelEspece.getRowData();
         }
      } else if (this.var_type_onglet == 1) {
         if (this.dataModelCheque.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelCheque.getRowData();
            this.soldeCorrection();
         }
      } else if (this.var_type_onglet == 2) {
         if (this.dataModelVirement.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelVirement.getRowData();
         }
      } else if (this.var_type_onglet == 3) {
         if (this.dataModelTraite.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelTraite.getRowData();
         }
      } else if (this.var_type_onglet == 4) {
         if (this.dataModelTpe.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelTpe.getRowData();
         }
      } else if (this.var_type_onglet == 5) {
         if (this.dataModelTransfert.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelTransfert.getRowData();
         }
      } else if (this.var_type_onglet == 6) {
         if (this.dataModelePaiement.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelePaiement.getRowData();
         }
      } else if (this.var_type_onglet == 7) {
         if (this.dataModelCredoc.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelCredoc.getRowData();
         }
      } else if (this.var_type_onglet == 8) {
         if (this.dataModelFactor.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelFactor.getRowData();
         }
      } else if (this.var_type_onglet == 9) {
         if (this.dataModelCompense.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelCompense.getRowData();
         }
      } else if (this.var_type_onglet == 10) {
         if (this.dataModelTerme.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelTerme.getRowData();
         }
      } else if (this.var_type_onglet == 12) {
         if (this.dataModelLettreGarantie.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelLettreGarantie.getRowData();
         }
      } else if (this.var_type_onglet == 13) {
         if (this.dataModelPrelevement.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelPrelevement.getRowData();
         }
      } else if (this.var_type_onglet == 14 && this.dataModelAlcoin.isRowAvailable()) {
         this.reglements = (Reglements)this.dataModelAlcoin.getRowData();
      }

      if (this.mesModeReglements.size() != 0) {
         for(int var1 = 0; var1 < this.mesModeReglements.size(); ++var1) {
            String var2 = ((SelectItem)this.mesModeReglements.get(var1)).getValue().toString();
            String[] var3 = var2.split(":");
            if (this.reglements.getRglTypeReg() == Integer.parseInt(var3[0])) {
               this.var_mode_reglement = var2;
            }
         }
      }

   }

   public void voirReglement() {
      if (this.reglements != null) {
      }

   }

   public void soldeCorrection() {
      if (this.lesCheques.size() != 0) {
         this.soldeCorrection = 0.0D;

         for(int var1 = 0; var1 < this.lesCheques.size(); ++var1) {
            if (((Reglements)this.lesCheques.get(var1)).isSel_ecriture()) {
               this.soldeCorrection = this.soldeCorrection + ((Reglements)this.lesCheques.get(var1)).getRglDepense() - ((Reglements)this.lesCheques.get(var1)).getRglRecette();
            }
         }
      }

   }

   public void correctionMouvement() throws HibernateException, NamingException, ParseException {
      if (this.lesCheques.size() != 0 && this.soldeCorrection == 0.0D) {
         String var1 = "";
         Date var2 = null;

         for(int var3 = 0; var3 < this.lesCheques.size(); ++var3) {
            if (((Reglements)this.lesCheques.get(var3)).isSel_ecriture() && ((Reglements)this.lesCheques.get(var3)).getRglNumMvt1() != null && !((Reglements)this.lesCheques.get(var3)).getRglNumMvt1().isEmpty()) {
               var1 = ((Reglements)this.lesCheques.get(var3)).getRglNumMvt1();
               var2 = ((Reglements)this.lesCheques.get(var3)).getRglDateReg();
               break;
            }
         }

         if (var1 != null && !var1.isEmpty()) {
            Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
            Transaction var4 = null;

            int var5;
            try {
               var4 = var11.beginTransaction();

               for(var5 = 0; var5 < this.lesCheques.size(); ++var5) {
                  this.reglements = (Reglements)this.lesCheques.get(var5);
                  if (this.reglements.isSel_ecriture() && (this.reglements.getRglNumMvt1() == null || this.reglements.getRglNumMvt1().isEmpty())) {
                     this.reglements.setRglNumMvt1(var1);
                     this.reglements.setRglDateMvt1(var2);
                     if (this.reglements.getRglCodeReceptrice() == null || this.reglements.getRglCodeReceptrice().isEmpty()) {
                        this.reglements.setRglCodeReceptrice("18TE");
                        this.reglements.setRglLibReceptrice("CAISSE TRESO CHEQUE");
                     }

                     this.reglements.setRglCaisseMvt1(this.reglements.getRglCodeReceptrice());
                     this.reglements = this.reglementsDao.modifierReg(this.reglements, var11);
                  }
               }

               var4.commit();
            } catch (HibernateException var9) {
               if (var4 != null) {
                  var4.rollback();
               }

               throw var9;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            for(var5 = 0; var5 < this.lesCheques.size(); ++var5) {
               this.reglements = (Reglements)this.lesCheques.get(var5);
               this.reglements.setSel_ecriture(false);
            }
         }
      }

   }

   public void selectionJournalJour() throws HibernateException, NamingException, ParseException {
      if (this.extDTableMois != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionMois.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableMois.setRowKey(var3);
            if (this.extDTableMois.isRowAvailable()) {
               var1.add(this.extDTableMois.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.caissesMois = (CaissesMois)var1.get(0);
            this.extDTableJour = new HtmlExtendedDataTable();
            this.simpleSelectionJour.clear();
            this.afficheTJJ = true;
            this.lescaissesJour.clear();
            this.lescaissesJour = this.caissesJourDao.mesjournauxjour(this.caissesCommerciales.getCaiCode(), this.caissesMois.getCaimenPeriode(), this.selectedExo, (Session)null);
            if (this.lescaissesJour.size() == 0) {
               this.caissesJourDao.ajoutPeriode(this.caissesCommerciales, this.caissesMois.getCaimenPeriode(), this.selectedExo);
               this.lescaissesJour.clear();
               this.lescaissesJour = this.caissesJourDao.mesjournauxjour(this.caissesCommerciales.getCaiCode(), this.caissesMois.getCaimenPeriode(), this.selectedExo, (Session)null);
            }

            this.dataModelJour.setWrappedData(this.lescaissesJour);
            this.caissesJour = null;
         }
      }

   }

   public void selectionJourSaisieLight() throws HibernateException, NamingException, ParseException {
      if (this.caissesCommerciales != null && this.extDTableJournaux != null) {
         int var1 = 0;
         ArrayList var2 = new ArrayList();
         Iterator var3 = this.simpleSelectionJour.getKeys();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            var1 = Integer.parseInt(var4.toString());
            this.extDTableJour.setRowKey(var4);
            if (this.extDTableJour.isRowAvailable()) {
               var2.add(this.extDTableJour.getRowData());
            }
         }

         for(int var5 = 0; var5 < this.lescaissesJour.size(); ++var5) {
            this.caissesJour = (CaissesJour)this.lescaissesJour.get(var5);
            if (var5 == var1) {
               this.caissesJour.setSelect(true);
            } else {
               this.caissesJour.setSelect(false);
            }
         }

         this.dataModelJour.setWrappedData(this.lescaissesJour);
         if (var2.size() != 0) {
            this.caissesJour = (CaissesJour)var2.get(0);
         }
      }

   }

   public void selectionJourSaisie() throws HibernateException, NamingException, ParseException {
      this.dataModelEspece = new ListDataModel();
      this.dataModelCheque = new ListDataModel();
      this.dataModelVirement = new ListDataModel();
      this.dataModelTraite = new ListDataModel();
      this.dataModelTpe = new ListDataModel();
      this.dataModelTransfert = new ListDataModel();
      this.dataModelePaiement = new ListDataModel();
      this.dataModelCredoc = new ListDataModel();
      this.dataModelFactor = new ListDataModel();
      this.dataModelCompense = new ListDataModel();
      this.dataModelTerme = new ListDataModel();
      this.dataModelLettreGarantie = new ListDataModel();
      this.dataModelPrelevement = new ListDataModel();
      this.dataModelAlcoin = new ListDataModel();
      this.dataModelBonsCaisse = new ListDataModel();
      if (this.caissesCommerciales != null && this.dataModelJour.isRowAvailable()) {
         this.caissesJour = (CaissesJour)this.dataModelJour.getRowData();
         this.caissesJour = this.caissesJourDao.recupererCaissesJour(this.caissesJour.getCaijouDate(), this.caissesJour.getCaijouCode(), (Session)null);
         this.ouvrirLeJournalJournalierEncours();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
         this.ChargerLesEcrituresJournalier(var1);
         if (this.caissesJour.getCaijouEtat() != 0) {
            this.var_action = 3;
         } else if (this.selectedExo.getExecaiId() != this.lastExo.getExecaiId()) {
            this.var_action = 3;
         } else {
            this.var_action = 1;
         }

         this.var_memo_action = this.var_action;
         this.utilInitHibernate.closeSession();
         this.chargerTypeReglement();
      }

   }

   public void ouvrirJourenCours() throws HibernateException, NamingException, ParseException {
      this.dataModelEspece = new ListDataModel();
      this.dataModelCheque = new ListDataModel();
      this.dataModelVirement = new ListDataModel();
      this.dataModelTraite = new ListDataModel();
      this.dataModelTpe = new ListDataModel();
      this.dataModelTransfert = new ListDataModel();
      this.dataModelePaiement = new ListDataModel();
      this.dataModelCredoc = new ListDataModel();
      this.dataModelFactor = new ListDataModel();
      this.dataModelCompense = new ListDataModel();
      this.dataModelTerme = new ListDataModel();
      this.dataModelLettreGarantie = new ListDataModel();
      this.dataModelPrelevement = new ListDataModel();
      this.dataModelAlcoin = new ListDataModel();
      this.dataModelBonsCaisse = new ListDataModel();
      if (this.caissesCommerciales != null) {
         this.caissesJour = this.caissesJourDao.recupererCaissesJour(new Date(), this.caissesCommerciales.getCaiCode(), (Session)null);
         if (this.caissesJour == null) {
            String var1 = this.formatPeriode(new Date());
            this.caissesJourDao.ajoutPeriode(this.caissesCommerciales, var1, this.selectedExo);
         }

         this.caissesJour = this.caissesJourDao.recupererCaissesJour(new Date(), this.caissesCommerciales.getCaiCode(), (Session)null);
         if (this.caissesJour != null) {
            this.ouvrirLeJournalJournalierEncours();
            Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
            this.ChargerLesEcrituresJournalier(var2);
            if (this.caissesJour.getCaijouEtat() != 0) {
               this.var_action = 3;
            } else if (this.selectedExo.getExecaiId() != this.lastExo.getExecaiId()) {
               this.var_action = 3;
            } else {
               this.var_action = 1;
            }

            this.var_memo_action = this.var_action;
            this.utilInitHibernate.closeSession();
            this.chargerTypeReglement();
         }
      }

   }

   public void ouvrirLeJournalJournalierEncours() throws HibernateException, NamingException {
      if (this.caissesJour != null) {
         this.caissesJour.setCaijouOpenJournal(1);
         if (this.usersLog.getUsrPatronyme() != null && !this.usersLog.getUsrPatronyme().isEmpty()) {
            this.caissesJour.setCaijouOpenUserJournal(this.usersLog.getUsrPatronyme());
         } else {
            this.caissesJour.setCaijouOpenUserJournal(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         }

         this.caissesJour.setCaijouUserIdCaisse(this.usersLog.getUsrid());
         this.caissesJour = this.caissesJourDao.majJournal(this.caissesJour);
      }

   }

   public void fermerLeJournalJournalierEncours() throws NamingException, JDOMException, IOException {
      if (this.caissesJour != null) {
         this.caissesJour.setCaijouOpenUserJournal("");
         this.caissesJour.setCaijouOpenJournal(0);
         this.caissesJour.setCaijouUserIdCaisse(0L);
         this.caissesJour = this.caissesJourDao.majJournal(this.caissesJour);
         this.afficheTJM = true;
         this.afficheTJJ = true;
         this.var_action = 0;
      }

   }

   public void calculerSoldeAnterieurJournalier(Session var1) throws NamingException {
      this.debitAnterieur = 0.0D;
      this.creditAnterieur = 0.0D;
      boolean var2 = false;
      new ArrayList();
      List var3 = this.caissesJourDao.listeDateDebut(this.caissesJour.getCaijouCode(), this.selectedExo.getExecaiDateDebut(), this.caissesJour.getCaijouDate(), var1);
      CaissesJour var4 = new CaissesJour();
      boolean var5 = false;
      if (var3.size() != 0) {
         int var6 = 0;

         for(int var7 = var3.size() - 1; var7 >= 0; --var7) {
            var4 = (CaissesJour)var3.get(var7);
            ++var6;
            if (var4.getCaijouEtat() == 1) {
               var5 = true;
               if (var6 == 1) {
                  var2 = true;
               }
               break;
            }
         }
      }

      ExercicesCaisse var68;
      if (!var5) {
         new ExercicesCaisse();
         ExercicesCaisseDao var69 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
         var68 = var69.recupererLExoSelect(this.selectedExo.getExecaiId() - 1L, var1);
         int var8;
         if (var68 != null) {
            var3 = this.caissesJourDao.listeDateDebut(this.caissesJour.getCaijouCode(), var68.getExecaiDateDebut(), this.caissesJour.getCaijouDate(), var1);
            var4 = new CaissesJour();
            var5 = false;
            if (var3.size() != 0) {
               for(var8 = var3.size() - 1; var8 >= 0; --var8) {
                  var4 = (CaissesJour)var3.get(var8);
                  if (var4.getCaijouEtat() == 1) {
                     var5 = true;
                     break;
                  }
               }
            }
         }

         if (!var5) {
            var68 = var69.recupererLExoSelect(this.selectedExo.getExecaiId() - 2L, var1);
            if (var68 != null) {
               var3 = this.caissesJourDao.listeDateDebut(this.caissesJour.getCaijouCode(), var68.getExecaiDateDebut(), this.caissesJour.getCaijouDate(), var1);
               var4 = new CaissesJour();
               var5 = false;
               if (var3.size() != 0) {
                  for(var8 = var3.size() - 1; var8 >= 0; --var8) {
                     var4 = (CaissesJour)var3.get(var8);
                     if (var4.getCaijouEtat() == 1) {
                        var5 = true;
                        break;
                     }
                  }
               }
            }

            if (!var5) {
               var68 = var69.recupererLExoSelect(this.selectedExo.getExecaiId() - 3L, var1);
               if (var68 != null) {
                  var3 = this.caissesJourDao.listeDateDebut(this.caissesJour.getCaijouCode(), var68.getExecaiDateDebut(), this.caissesJour.getCaijouDate(), var1);
                  var4 = new CaissesJour();
                  var5 = false;
                  if (var3.size() != 0) {
                     for(var8 = var3.size() - 1; var8 >= 0; --var8) {
                        var4 = (CaissesJour)var3.get(var8);
                        if (var4.getCaijouEtat() == 1) {
                           var5 = true;
                           break;
                        }
                     }
                  }
               }
            }
         }
      }

      var68 = null;
      Date var70;
      if (var5) {
         var70 = var4.getCaijouDate();
         this.soldeAnterieurEspece = var4.getCaijouSoldeEspece();
         this.soldeAnterieurCheque = var4.getCaijouSoldeCheque();
         this.soldeAnterieurVirement = var4.getCaijouSoldeVirement();
         this.soldeAnterieurTraite = var4.getCaijouSoldeTraite();
         this.soldeAnterieurTpe = var4.getCaijouSoldeTpe();
         this.soldeAnterieurTransfert = var4.getCaijouSoldeTransfert();
         this.soldeAnterieurePaiement = var4.getCaijouSoldeePaiement();
         this.soldeAnterieurCredoc = var4.getCaijouSoldeCredoc();
         this.soldeAnterieurFactor = var4.getCaijouSoldeFactor();
         this.soldeAnterieurCompense = var4.getCaijouSoldeCompense();
         this.soldeAnterieurTerme = var4.getCaijouSoldeTerme();
         this.soldeAnterieurLettreGarantie = var4.getCaijouSoldeLettreGarantie();
         this.soldeAnterieurPrelevement = var4.getCaijouSoldePrelevement();
         this.soldeAnterieurAlcoin = var4.getCaijouSoldeAlcoin();
         this.soldeAnterieurBonCaisse = var4.getCaijouSoldeBonCaisse();
      } else {
         var70 = this.caissesCommerciales.getCaiDateInit();
         if (var70 == null) {
            var70 = this.selectedExo.getExecaiDateDebut();
         }

         this.soldeAnterieurEspece = this.caissesCommerciales.getCaiMontantInitEspece();
         this.soldeAnterieurCheque = this.caissesCommerciales.getCaiMontantInitCheque();
         this.soldeAnterieurVirement = this.caissesCommerciales.getCaiMontantInitVirement();
         this.soldeAnterieurTraite = this.caissesCommerciales.getCaiMontantInitTraite();
         this.soldeAnterieurTpe = this.caissesCommerciales.getCaiMontantInitTpe();
         this.soldeAnterieurTransfert = this.caissesCommerciales.getCaiMontantInitTransfert();
         this.soldeAnterieurePaiement = this.caissesCommerciales.getCaiMontantInitePaiement();
         this.soldeAnterieurCredoc = this.caissesCommerciales.getCaiMontantInitCredoc();
         this.soldeAnterieurFactor = this.caissesCommerciales.getCaiMontantInitFactor();
         this.soldeAnterieurCompense = this.caissesCommerciales.getCaiMontantInitCompense();
         this.soldeAnterieurTerme = this.caissesCommerciales.getCaiMontantInitTerme();
         this.soldeAnterieurLettreGarantie = this.caissesCommerciales.getCaiMontantInitLettreGarantie();
         this.soldeAnterieurPrelevement = this.caissesCommerciales.getCaiMontantInitPrelevement();
         this.soldeAnterieurAlcoin = this.caissesCommerciales.getCaiMontantInitAlcoin();
         this.soldeAnterieurBonCaisse = 0.0D;
      }

      if (!var2) {
         double var71 = 0.0D;
         double var9 = 0.0D;
         double var11 = 0.0D;
         double var13 = 0.0D;
         double var15 = 0.0D;
         double var17 = 0.0D;
         double var19 = 0.0D;
         double var21 = 0.0D;
         double var23 = 0.0D;
         double var25 = 0.0D;
         double var27 = 0.0D;
         double var29 = 0.0D;
         double var31 = 0.0D;
         double var33 = 0.0D;
         double var35 = 0.0D;
         double var37 = 0.0D;
         double var39 = 0.0D;
         double var41 = 0.0D;
         double var43 = 0.0D;
         double var45 = 0.0D;
         double var47 = 0.0D;
         double var49 = 0.0D;
         double var51 = 0.0D;
         double var53 = 0.0D;
         double var55 = 0.0D;
         double var57 = 0.0D;
         double var59 = 0.0D;
         double var61 = 0.0D;
         new ArrayList();
         List var63 = this.reglementsDao.calculToutSoldeAnterieur(this.caissesJour.getCaijouCode(), var70, this.caissesJour.getCaijouDate(), var1);
         if (var63.size() != 0) {
            new Reglements();

            for(int var65 = 0; var65 < var63.size(); ++var65) {
               Reglements var64 = (Reglements)var63.get(var65);
               if (var64.getRglImp() == 0 && var64.getRglCodeCaiss() != null && !var64.getRglCodeCaiss().isEmpty() && !var64.getRglCodeCaiss().equals(this.caissesJour.getCaijouCode())) {
                  double var66 = var64.getRglRecette();
                  var64.setRglRecette(var64.getRglDepense());
                  var64.setRglDepense(var66);
               }

               if (var64.getRglOperation() == null || var64.getRglOperation().isEmpty()) {
                  var64.setRglOperation("00");
               }

               var64.setSel_ecriture(false);
               if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 11) {
                  var64.setRglTypeReg(0);
               } else if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 10) {
                  var64.setRglTypeReg(0);
               } else if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 100) {
                  var64.setRglTypeReg(0);
               }

               if (var64.getRglImp() != 0 || var64.getRglTypeReg() != 0 && (var64.getRglCategorie() != 64 || !var64.getRglOperation().equals("71") && !var64.getRglOperation().equals("73") && !var64.getRglOperation().equals("77") && !var64.getRglOperation().equals("80") && !var64.getRglOperation().equals("85"))) {
                  if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 1) {
                     if (var64.getRglOperation() != null && !var64.getRglOperation().isEmpty() && var64.getRglOperation().equals("81")) {
                        var64.setRglNumMvt1(var64.getRglNum());
                     }

                     var11 += var64.getRglDepense();
                     var13 += var64.getRglRecette();
                  } else if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 2) {
                     var15 += var64.getRglDepense();
                     var17 += var64.getRglRecette();
                  } else if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 3) {
                     var19 += var64.getRglDepense();
                     var21 += var64.getRglRecette();
                  } else if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 4) {
                     var23 += var64.getRglDepense();
                     var25 += var64.getRglRecette();
                  } else if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 5) {
                     var27 += var64.getRglDepense();
                     var29 += var64.getRglRecette();
                  } else if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 6) {
                     var31 += var64.getRglDepense();
                     var33 += var64.getRglRecette();
                  } else if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 7) {
                     var35 += var64.getRglDepense();
                     var37 += var64.getRglRecette();
                  } else if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 8) {
                     var39 += var64.getRglDepense();
                     var41 += var64.getRglRecette();
                  } else if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 9) {
                     var43 += var64.getRglDepense();
                     var45 += var64.getRglRecette();
                  } else if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 10) {
                     var47 += var64.getRglDepense();
                     var49 += var64.getRglRecette();
                  } else if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 12) {
                     var51 += var64.getRglDepense();
                     var53 += var64.getRglRecette();
                  } else if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 13) {
                     var55 += var64.getRglDepense();
                     var57 += var64.getRglRecette();
                  } else if (var64.getRglImp() == 0 && var64.getRglTypeReg() == 14) {
                     var59 += var64.getRglDepense();
                     var61 += var64.getRglRecette();
                  }
               } else {
                  var71 += var64.getRglDepense();
                  var9 += var64.getRglRecette();
               }
            }

            this.soldeAnterieurEspece = this.soldeAnterieurEspece + var9 - var71;
            this.soldeAnterieurCheque = this.soldeAnterieurCheque + var13 - var11;
            this.soldeAnterieurVirement = this.soldeAnterieurVirement + var17 - var15;
            this.soldeAnterieurTraite = this.soldeAnterieurTraite + var21 - var19;
            this.soldeAnterieurTpe = this.soldeAnterieurTpe + var25 - var23;
            this.soldeAnterieurTransfert = this.soldeAnterieurTransfert + var29 - var27;
            this.soldeAnterieurePaiement = this.soldeAnterieurePaiement + var33 - var31;
            this.soldeAnterieurCredoc = this.soldeAnterieurCredoc + var37 - var35;
            this.soldeAnterieurFactor = this.soldeAnterieurFactor + var41 - var39;
            this.soldeAnterieurCompense = this.soldeAnterieurCompense + var45 - var43;
            this.soldeAnterieurTerme = this.soldeAnterieurTerme + var49 - var47;
            this.soldeAnterieurLettreGarantie = this.soldeAnterieurLettreGarantie + var53 - var51;
            this.soldeAnterieurPrelevement = this.soldeAnterieurPrelevement + var57 - var55;
            this.soldeAnterieurAlcoin = this.soldeAnterieurAlcoin + var61 - var59;
         }
      }

   }

   public void ChargerLesEcrituresJournalier(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesReglements.clear();
      if (this.caissesCommerciales != null) {
         this.lesEspeces.clear();
         this.lesCheques.clear();
         this.lesVirements.clear();
         this.lesTraites.clear();
         this.lesTpes.clear();
         this.lesTransferts.clear();
         this.lesePaiements.clear();
         this.lesCredocs.clear();
         this.lesFactors.clear();
         this.lesCompenses.clear();
         this.lesTermes.clear();
         this.lesLettreGarantie.clear();
         this.lesPrelevement.clear();
         this.lesAlcoin.clear();
         this.lesBonsCaisse.clear();
         this.lesEcart.clear();
         this.lesErreurs.clear();
         new ArrayList();
         List var2 = this.reglementsDao.reglementJournalier(this.caissesJour.getCaijouCle1(), this.caissesJour.getCaijouDate(), var1);
         Reglements var3;
         int var4;
         if (var2.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < var2.size(); ++var4) {
               var3 = (Reglements)var2.get(var4);
               if (var3.getRglImp() == 0 && var3.getRglCodeCaiss() != null && !var3.getRglCodeCaiss().isEmpty() && !var3.getRglCodeCaiss().equals(this.caissesJour.getCaijouCode())) {
                  double var5 = var3.getRglRecette();
                  var3.setRglRecette(var3.getRglDepense());
                  var3.setRglDepense(var5);
               }

               if (var3.getRglOperation() == null || var3.getRglOperation().isEmpty()) {
                  var3.setRglOperation("00");
               }

               if (this.typeVente == 815 && var3.getRglService() != null && !var3.getRglService().isEmpty()) {
                  var3.setRglObjet(var3.getRglService());
                  if (var3.getRglPdv() != null && !var3.getRglPdv().isEmpty()) {
                     var3.setRglObjet(var3.getRglObjet() + " / " + var3.getRglPdv());
                  }
               }

               var3.setSel_ecriture(false);
               if (var3.getRglImp() == 0) {
                  this.lesReglements.add(var3);
               }

               if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 11) {
                  var3.setRglTypeReg(0);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 10) {
                  var3.setRglTypeReg(0);
               } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 100) {
                  var3.setRglTypeReg(0);
               }

               if (var3.getRglImp() != 0 || var3.getRglTypeReg() != 0 && (var3.getRglCategorie() != 64 || !var3.getRglOperation().equals("71") && !var3.getRglOperation().equals("73") && !var3.getRglOperation().equals("77") && !var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("85"))) {
                  if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 1) {
                     if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty() && var3.getRglOperation().equals("81")) {
                        var3.setRglNumMvt1(var3.getRglNum());
                     }

                     this.lesCheques.add(var3);
                  } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 2) {
                     if ((var3.getRglCodeEmetrice() == null || var3.getRglCodeEmetrice().isEmpty()) && var3.getRglCodeReceptrice() != null && !var3.getRglCodeReceptrice().isEmpty()) {
                        var3.setRglCodeEmetrice(var3.getRglCodeReceptrice());
                        var3.setRglLibEmetrice(var3.getRglLibReceptrice());
                     }

                     this.lesVirements.add(var3);
                  } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 3) {
                     this.lesTraites.add(var3);
                  } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 4) {
                     this.lesTpes.add(var3);
                  } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 5) {
                     this.lesTransferts.add(var3);
                  } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 6) {
                     this.lesePaiements.add(var3);
                  } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 7) {
                     this.lesCredocs.add(var3);
                  } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 8) {
                     this.lesFactors.add(var3);
                  } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 9) {
                     this.lesCompenses.add(var3);
                  } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 10) {
                     this.lesTermes.add(var3);
                  } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 12) {
                     this.lesLettreGarantie.add(var3);
                  } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 13) {
                     this.lesPrelevement.add(var3);
                  } else if (var3.getRglImp() == 0 && var3.getRglTypeReg() == 14) {
                     this.lesAlcoin.add(var3);
                  } else if (var3.getRglImp() == 0) {
                     this.lesErreurs.add(var3);
                  }
               } else {
                  this.lesEspeces.add(var3);
               }
            }
         }

         this.dataModelEspece.setWrappedData(this.lesEspeces);
         this.dataModelCheque.setWrappedData(this.lesCheques);
         this.dataModelVirement.setWrappedData(this.lesVirements);
         this.dataModelTraite.setWrappedData(this.lesTraites);
         this.dataModelTpe.setWrappedData(this.lesTpes);
         this.dataModelTransfert.setWrappedData(this.lesTransferts);
         this.dataModelePaiement.setWrappedData(this.lesePaiements);
         this.dataModelCredoc.setWrappedData(this.lesCredocs);
         this.dataModelFactor.setWrappedData(this.lesFactors);
         this.dataModelCompense.setWrappedData(this.lesCompenses);
         this.dataModelTerme.setWrappedData(this.lesTermes);
         this.dataModelLettreGarantie.setWrappedData(this.lesLettreGarantie);
         this.dataModelPrelevement.setWrappedData(this.lesPrelevement);
         this.dataModelAlcoin.setWrappedData(this.lesAlcoin);
         this.dataModelErreur.setWrappedData(this.lesErreurs);
         this.datamodelElement.setWrappedData(this.lesReglements);
         this.lesBonsCaisse = this.reglementsDao.reglementJournalierBonCaisse(this.caissesJour.getCaijouCle1(), this.caissesJour.getCaijouDate(), var1);
         this.dataModelBonsCaisse.setWrappedData(this.lesBonsCaisse);
         this.lesEcart = this.reglementsDao.reglementJournalierEcart(this.caissesJour.getCaijouCle1(), this.caissesJour.getCaijouDate(), var1);
         this.dataModelEcart.setWrappedData(this.lesEcart);
         this.soldeAnterieurEspece = 0.0D;
         this.depensesEspece = 0.0D;
         this.recettesEspece = 0.0D;
         this.soldeFinalEspece = 0.0D;
         this.soldeAnterieurCheque = 0.0D;
         this.depensesCheque = 0.0D;
         this.recettesCheque = 0.0D;
         this.soldeFinalCheque = 0.0D;
         this.soldeAnterieurVirement = 0.0D;
         this.depensesVirement = 0.0D;
         this.recettesVirement = 0.0D;
         this.soldeFinalVirement = 0.0D;
         this.soldeAnterieurTraite = 0.0D;
         this.depensesTraite = 0.0D;
         this.recettesTraite = 0.0D;
         this.soldeFinalTraite = 0.0D;
         this.soldeAnterieurTpe = 0.0D;
         this.depensesTpe = 0.0D;
         this.recettesTpe = 0.0D;
         this.soldeFinalTpe = 0.0D;
         this.soldeAnterieurTransfert = 0.0D;
         this.depensesTransfert = 0.0D;
         this.recettesTransfert = 0.0D;
         this.soldeFinalTransfert = 0.0D;
         this.soldeAnterieurePaiement = 0.0D;
         this.depensesePaiement = 0.0D;
         this.recettesePaiement = 0.0D;
         this.soldeFinalePaiement = 0.0D;
         this.soldeAnterieurCredoc = 0.0D;
         this.depensesCredoc = 0.0D;
         this.recettesCredoc = 0.0D;
         this.soldeFinalCredoc = 0.0D;
         this.soldeAnterieurFactor = 0.0D;
         this.depensesFactor = 0.0D;
         this.recettesFactor = 0.0D;
         this.soldeFinalFactor = 0.0D;
         this.soldeAnterieurCompense = 0.0D;
         this.depensesCompense = 0.0D;
         this.recettesCompense = 0.0D;
         this.soldeFinalCompense = 0.0D;
         this.soldeAnterieurTerme = 0.0D;
         this.depensesTerme = 0.0D;
         this.recettesTerme = 0.0D;
         this.soldeFinalTerme = 0.0D;
         this.soldeAnterieurBonCaisse = 0.0D;
         this.depensesBonCaisse = 0.0D;
         this.soldeFinalBonCaisse = 0.0D;
         this.soldeAnterieurLettreGarantie = 0.0D;
         this.depensesLettreGarantie = 0.0D;
         this.recettesLettreGarantie = 0.0D;
         this.soldeFinalLettreGarantie = 0.0D;
         this.soldeAnterieurPrelevement = 0.0D;
         this.depensesPrelevement = 0.0D;
         this.recettesPrelevement = 0.0D;
         this.soldeFinalPrelevement = 0.0D;
         this.soldeAnterieurAlcoin = 0.0D;
         this.depensesAlcoin = 0.0D;
         this.recettesAlcoin = 0.0D;
         this.soldeFinalAlcoin = 0.0D;
         this.calculerSoldeAnterieurJournalier(var1);
         if (this.lesEspeces.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesEspeces.size(); ++var4) {
               var3 = (Reglements)this.lesEspeces.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesEspece += var3.getVal_depense();
               this.recettesEspece += var3.getVal_recette();
            }
         }

         this.soldeFinalEspece = this.soldeAnterieurEspece + this.recettesEspece - this.depensesEspece;
         if (this.lesCheques.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesCheques.size(); ++var4) {
               var3 = (Reglements)this.lesCheques.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesCheque += var3.getRglDepense();
               this.recettesCheque += var3.getRglRecette();
            }
         }

         this.soldeFinalCheque = this.soldeAnterieurCheque + this.recettesCheque - this.depensesCheque;
         if (this.lesVirements.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesVirements.size(); ++var4) {
               var3 = (Reglements)this.lesVirements.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesVirement += var3.getRglDepense();
               this.recettesVirement += var3.getRglRecette();
            }
         }

         this.soldeFinalVirement = this.soldeAnterieurVirement + this.recettesVirement - this.depensesVirement;
         if (this.lesTraites.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesTraites.size(); ++var4) {
               var3 = (Reglements)this.lesTraites.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesTraite += var3.getRglDepense();
               this.recettesTraite += var3.getRglRecette();
            }
         }

         this.soldeFinalTraite = this.soldeAnterieurTraite + this.recettesTraite - this.depensesTraite;
         if (this.lesTpes.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesTpes.size(); ++var4) {
               var3 = (Reglements)this.lesTpes.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesTpe += var3.getRglDepense();
               this.recettesTpe += var3.getRglRecette();
            }
         }

         this.soldeFinalTpe = this.soldeAnterieurTpe + this.recettesTpe - this.depensesTpe;
         if (this.lesTransferts.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesTransferts.size(); ++var4) {
               var3 = (Reglements)this.lesTransferts.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesTransfert += var3.getRglDepense();
               this.recettesTransfert += var3.getRglRecette();
            }
         }

         this.soldeFinalTransfert = this.soldeAnterieurTransfert + this.recettesTransfert - this.depensesTransfert;
         if (this.lesePaiements.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesePaiements.size(); ++var4) {
               var3 = (Reglements)this.lesePaiements.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesePaiement += var3.getRglDepense();
               this.recettesePaiement += var3.getRglRecette();
            }
         }

         this.soldeFinalePaiement = this.soldeAnterieurePaiement + this.recettesePaiement - this.depensesePaiement;
         if (this.lesCredocs.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesCredocs.size(); ++var4) {
               var3 = (Reglements)this.lesCredocs.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesCredoc += var3.getRglDepense();
               this.recettesCredoc += var3.getRglRecette();
            }
         }

         this.soldeFinalCredoc = this.soldeAnterieurCredoc + this.recettesCredoc - this.depensesCredoc;
         if (this.lesFactors.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesFactors.size(); ++var4) {
               var3 = (Reglements)this.lesFactors.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesFactor += var3.getRglDepense();
               this.recettesFactor += var3.getRglRecette();
            }
         }

         this.soldeFinalFactor = this.soldeAnterieurFactor + this.recettesFactor - this.depensesFactor;
         if (this.lesCompenses.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesCompenses.size(); ++var4) {
               var3 = (Reglements)this.lesCompenses.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesCompense += var3.getRglDepense();
               this.recettesCompense += var3.getRglRecette();
            }
         }

         this.soldeFinalCompense = this.soldeAnterieurCompense + this.recettesCompense - this.depensesCompense;
         if (this.lesTermes.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesTermes.size(); ++var4) {
               var3 = (Reglements)this.lesTermes.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesTerme += var3.getRglDepense();
               this.recettesTerme += var3.getRglRecette();
            }
         }

         this.soldeFinalTerme = this.soldeAnterieurTerme + this.recettesTerme - this.depensesTerme;
         if (this.lesLettreGarantie.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesLettreGarantie.size(); ++var4) {
               var3 = (Reglements)this.lesLettreGarantie.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesLettreGarantie += var3.getRglDepense();
               this.recettesLettreGarantie += var3.getRglRecette();
            }
         }

         this.soldeFinalLettreGarantie = this.soldeAnterieurLettreGarantie + this.recettesLettreGarantie - this.depensesLettreGarantie;
         if (this.lesPrelevement.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesPrelevement.size(); ++var4) {
               var3 = (Reglements)this.lesPrelevement.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesPrelevement += var3.getRglDepense();
               this.recettesPrelevement += var3.getRglRecette();
            }
         }

         this.soldeFinalPrelevement = this.soldeAnterieurPrelevement + this.recettesPrelevement - this.depensesPrelevement;
         if (this.lesAlcoin.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesAlcoin.size(); ++var4) {
               var3 = (Reglements)this.lesAlcoin.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesAlcoin += var3.getRglDepense();
               this.recettesAlcoin += var3.getRglRecette();
            }
         }

         this.soldeFinalAlcoin = this.soldeAnterieurAlcoin + this.recettesAlcoin - this.depensesAlcoin;
         if (this.lesBonsCaisse.size() != 0) {
            new Reglements();

            for(var4 = 0; var4 < this.lesBonsCaisse.size(); ++var4) {
               var3 = (Reglements)this.lesBonsCaisse.get(var4);
               if (var3.getRglOperation() != null && !var3.getRglOperation().isEmpty()) {
                  if (!var3.getRglOperation().equals("80") && !var3.getRglOperation().equals("81") && !var3.getRglOperation().equals("82")) {
                     if (var3.getRglOperation().equals("83") || var3.getRglOperation().equals("84") || var3.getRglOperation().equals("85")) {
                        var3.setRglNumMvt2(var3.getRglNum());
                     }
                  } else {
                     var3.setRglNumMvt1(var3.getRglNum());
                  }
               }

               this.depensesBonCaisse += var3.getRglDepense();
            }
         }

         this.soldeFinalBonCaisse = this.soldeAnterieurBonCaisse - this.depensesBonCaisse;
         double var7 = this.soldeAnterieurEspece + this.soldeAnterieurCheque + this.soldeAnterieurVirement + this.soldeAnterieurTraite + this.soldeAnterieurTpe + this.soldeAnterieurTransfert + this.soldeAnterieurePaiement + this.soldeAnterieurCredoc + this.soldeAnterieurFactor + this.soldeAnterieurCompense + this.soldeAnterieurTerme + this.soldeAnterieurLettreGarantie + this.soldeAnterieurPrelevement + this.soldeAnterieurAlcoin;
         if (var7 < 0.0D) {
            this.debitAnterieur = var7 * -1.0D;
            this.creditAnterieur = 0.0D;
         } else {
            this.debitAnterieur = 0.0D;
            this.creditAnterieur = var7;
         }

         this.totalMvtsdebit = this.depensesEspece + this.depensesCheque + this.depensesVirement + this.depensesTraite + this.depensesTpe + this.depensesTransfert + this.depensesePaiement + this.depensesCredoc + this.depensesFactor + this.depensesCompense + this.depensesTerme + this.depensesLettreGarantie + this.depensesPrelevement + this.depensesAlcoin;
         this.totalMvtscredit = this.recettesEspece + this.recettesCheque + this.recettesVirement + this.recettesTraite + this.recettesTpe + this.recettesTransfert + this.recettesePaiement + this.recettesCredoc + this.recettesFactor + this.recettesCompense + this.recettesTerme + this.recettesLettreGarantie + this.recettesAlcoin + this.recettesAlcoin;
         if (this.totalMvtsdebit > this.totalMvtscredit) {
            this.soldeDeb = this.totalMvtscredit - this.totalMvtsdebit;
            this.soldeCred = 0.0D;
         } else {
            this.soldeDeb = 0.0D;
            this.soldeCred = this.totalMvtscredit - this.totalMvtsdebit;
         }

         if (this.debitAnterieur + this.totalMvtsdebit > this.creditAnterieur + this.totalMvtscredit) {
            this.soldefinalDeb = this.debitAnterieur + this.totalMvtsdebit - (this.creditAnterieur + this.totalMvtscredit);
            this.soldefinalCred = 0.0D;
         } else {
            this.soldefinalDeb = 0.0D;
            this.soldefinalCred = this.creditAnterieur + this.totalMvtscredit - (this.debitAnterieur + this.totalMvtsdebit);
         }
      }

   }

   public void majReglementJour() throws HibernateException, NamingException {
      if (this.reglements != null) {
         if (this.var_mode_reglement.contains(":")) {
            String[] var1 = this.var_mode_reglement.split(":");
            this.reglements.setRglMode(var1[0]);
            this.reglements.setRglTypeReg(Integer.parseInt(var1[0]));
         }

         String var4 = "";
         if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
            var4 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
         } else {
            var4 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
         }

         String var2 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
         this.reglements.setRglPeriode(var4 + ":" + var2);
         this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
         String var3 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
         this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var3);
         this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var3);
         this.reglements.setRglDateModif(new Date());
         this.reglements.setRglUserModif(this.usersLog.getUsrid());
         this.reglements = this.reglementsDao.modifier(this.reglements);
         this.showModalpanelDetail = false;
      }

   }

   public void ongletGlobal() {
      this.var_type_onglet = 99;
   }

   public void ongletBonCaisse() {
      this.var_type_onglet = 90;
   }

   public void ongletEcart() {
      this.var_type_onglet = 91;
   }

   public void ongletErreur() {
      this.var_type_onglet = 92;
   }

   public void ongletEspece() {
      this.var_type_onglet = 0;
   }

   public void ongletCheque() {
      this.var_type_onglet = 1;
   }

   public void ongletVirement() {
      this.var_type_onglet = 2;
   }

   public void ongletTraite() {
      this.var_type_onglet = 3;
   }

   public void ongletTpe() {
      this.var_type_onglet = 4;
   }

   public void ongletTransfert() {
      this.var_type_onglet = 5;
   }

   public void ongletePaiement() {
      this.var_type_onglet = 6;
   }

   public void ongletCredoc() {
      this.var_type_onglet = 7;
   }

   public void ongletFactor() {
      this.var_type_onglet = 8;
   }

   public void ongletCompenses() {
      this.var_type_onglet = 9;
   }

   public void ongletTermes() {
      this.var_type_onglet = 10;
   }

   public void ongletLettreGarantie() {
      this.var_type_onglet = 12;
   }

   public void detailReglement() {
      this.reglements = new Reglements();
      if (this.var_type_onglet == 99) {
         if (this.datamodelElement.isRowAvailable()) {
            this.reglements = (Reglements)this.datamodelElement.getRowData();
         }
      } else if (this.var_type_onglet == 90) {
         if (this.dataModelBonsCaisse.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelBonsCaisse.getRowData();
         }
      } else if (this.var_type_onglet == 91) {
         if (this.dataModelEcart.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelEcart.getRowData();
         }
      } else if (this.var_type_onglet == 92) {
         if (this.dataModelErreur.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelErreur.getRowData();
         }
      } else if (this.var_type_onglet == 0) {
         if (this.dataModelEspece.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelEspece.getRowData();
         }
      } else if (this.var_type_onglet == 1) {
         if (this.dataModelCheque.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelCheque.getRowData();
         }
      } else if (this.var_type_onglet == 2) {
         if (this.dataModelVirement.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelVirement.getRowData();
         }
      } else if (this.var_type_onglet == 3) {
         if (this.dataModelTraite.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelTraite.getRowData();
         }
      } else if (this.var_type_onglet == 4) {
         if (this.dataModelTpe.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelTpe.getRowData();
         }
      } else if (this.var_type_onglet == 5) {
         if (this.dataModelTransfert.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelTransfert.getRowData();
         }
      } else if (this.var_type_onglet == 6) {
         if (this.dataModelePaiement.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelePaiement.getRowData();
         }
      } else if (this.var_type_onglet == 7) {
         if (this.dataModelCredoc.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelCredoc.getRowData();
         }
      } else if (this.var_type_onglet == 8) {
         if (this.dataModelFactor.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelFactor.getRowData();
         }
      } else if (this.var_type_onglet == 9) {
         if (this.dataModelCompense.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelCompense.getRowData();
         }
      } else if (this.var_type_onglet == 10) {
         if (this.dataModelTerme.isRowAvailable()) {
            this.reglements = (Reglements)this.dataModelTerme.getRowData();
         }
      } else if (this.var_type_onglet == 12 && this.dataModelLettreGarantie.isRowAvailable()) {
         this.reglements = (Reglements)this.dataModelLettreGarantie.getRowData();
      }

      if (this.reglements != null) {
         this.showModalpanelDetail = true;
      }

   }

   public void fermerDetailReglement() {
      this.showModalpanelDetail = false;
   }

   public void clotureMensuelle() throws HibernateException, NamingException {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      int var9;
      if (this.lesReglements.size() != 0) {
         for(var9 = 0; var9 < this.lesReglements.size(); ++var9) {
            this.reglements = (Reglements)this.lesReglements.get(var9);
            if (this.reglements.getRglTypeReg() != 0) {
               var5 += this.reglements.getRglDepense();
               var7 += this.reglements.getRglRecette();
            }
         }
      }

      this.caissesMois.setCaimenEspeceTheorique(this.soldeFinalEspece);
      if (var5 > var7) {
         this.caissesMois.setCaimenAutre(var5 - var7);
      } else {
         this.caissesMois.setCaimenAutre(var7 - var5);
      }

      if (this.lesBonsCaisse.size() != 0) {
         for(var9 = 0; var9 < this.lesBonsCaisse.size(); ++var9) {
            this.reglements = (Reglements)this.lesBonsCaisse.get(var9);
            var1 += this.reglements.getRglDepense();
            var3 += this.reglements.getRglRecette();
         }
      }

      if (var1 > var3) {
         this.caissesMois.setCaimenBon(var1 - var3);
      } else {
         this.caissesMois.setCaimenBon(var3 - var1);
      }

      this.calculBilletageMensuel();
      this.showModalPanelCloture = true;
   }

   public void enregistrerClotureMensuelle() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.caissesMois.setCaimenEtat(0);
         this.caissesMois.setCaimenUserIdCloture(this.usersLog.getUsrid());
         this.caissesMois.setCaimenOpenJournal(0);
         this.caissesMois.setCaimenOpenUserJournal("");
         this.caissesMois.setCaimenSoldeEspece(this.soldeFinalEspece);
         this.caissesMois.setCaimenSoldeCheque(this.soldeFinalCheque);
         this.caissesMois.setCaimenSoldeVirement(this.soldeFinalVirement);
         this.caissesMois.setCaimenSoldeTraite(this.soldeFinalTraite);
         this.caissesMois.setCaimenSoldeTpe(this.soldeFinalTpe);
         this.caissesMois.setCaimenSoldeePaiement(this.soldeFinalePaiement);
         this.caissesMois.setCaimenSoldeCredoc(this.soldeFinalCredoc);
         this.caissesMois.setCaimenSoldeFactor(this.soldeFinalFactor);
         this.caissesMois.setCaimenSoldeCompense(this.soldeFinalCompense);
         this.caissesMois.setCaimenSoldeTerme(this.soldeFinalTerme);
         this.caissesMois.setCaimenSoldeBonCaisse(this.soldeFinalBonCaisse);
         this.caissesMois.setCaimenEcart(this.ecart);
         this.caissesMois = this.caissesMoisDao.majJournal(this.caissesMois, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.afficheTJM = false;
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.showModalPanelCloture = false;
   }

   public void valideClotureMensuelle() throws HibernateException, NamingException {
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         Reglements var5;
         if (this.lesReglements.size() != 0) {
            for(int var4 = 0; var4 < this.lesReglements.size(); ++var4) {
               new Reglements();
               var5 = (Reglements)this.lesReglements.get(var4);
               var5.setRglDateCloture(new Date());
               this.reglementsDao.modifierReg(var5, var2);
            }
         }

         this.caissesMois.setCaimenEtat(1);
         this.caissesMois.setCaimenUserIdCloture(this.usersLog.getUsrid());
         this.caissesMois.setCaimenOpenJournal(0);
         this.caissesMois.setCaimenOpenUserJournal("");
         this.caissesMois.setCaimenSoldeEspece(this.soldeFinalEspece);
         this.caissesMois.setCaimenSoldeCheque(this.soldeFinalCheque);
         this.caissesMois.setCaimenSoldeVirement(this.soldeFinalVirement);
         this.caissesMois.setCaimenSoldeTraite(this.soldeFinalTraite);
         this.caissesMois.setCaimenSoldeTpe(this.soldeFinalTpe);
         this.caissesMois.setCaimenSoldeePaiement(this.soldeFinalePaiement);
         this.caissesMois.setCaimenSoldeCredoc(this.soldeFinalCredoc);
         this.caissesMois.setCaimenSoldeFactor(this.soldeFinalFactor);
         this.caissesMois.setCaimenSoldeCompense(this.soldeFinalCompense);
         this.caissesMois.setCaimenSoldeTerme(this.soldeFinalTerme);
         this.caissesMois.setCaimenSoldeBonCaisse(this.soldeFinalBonCaisse);
         this.caissesMois.setCaimenEcart(this.ecart);
         this.caissesMois = this.caissesMoisDao.majJournal(this.caissesMois, var2);
         if (this.ecart != 0.0D) {
            CalculChrono var15 = new CalculChrono(this.baseLog, this.utilInitHibernate);
            var5 = new Reglements();
            var5.setRglDateReg(this.caissesJour.getCaijouDate());
            String var6 = "";
            if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
               var6 = var15.numCompose(new Date(), 61, "0", "", var2);
            } else {
               var6 = var15.numCompose(new Date(), 61, "", var2);
            }

            if (this.ecart > 0.0D) {
               var5.setRglOperation("27");
               var5.setRglRecette(0.0D);
               var5.setRglDepense(this.ecart);
            } else {
               var5.setRglOperation("17");
               var5.setRglRecette(this.ecart * -1.0D);
               var5.setRglDepense(0.0D);
            }

            var5.setRglBon("");
            var5.setRglCategorie(10);
            var5.setRglCodeCaiss(this.caissesCommerciales.getCaiCode());
            var5.setRglLibCaiss(this.caissesCommerciales.getCaiNom());
            var5.setRglCodeEmetrice("");
            var5.setRglLibEmetrice("");
            var5.setRglCodeReceptrice("");
            var5.setRglLibReceptrice("");
            var5.setRglDateCreation(new Date());
            var5.setRglDateImp((Date)null);
            var5.setRglDateTransfert((Date)null);
            var5.setRglDateValeur((Date)null);
            var5.setRglFormatDevise(this.structureLog.getStrformatdevise());
            var5.setRglIdCaissier(this.usersLog.getUsrid());
            var5.setRglIdDocument(0L);
            var5.setRglIdTiers(0L);
            var5.setRglDepotTiers(0);
            var5.setRglMode("0");
            var5.setRglModele("");
            var5.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            var5.setRglIdContact(0L);
            var5.setRglNomContact("");
            var5.setRglNum(var6);
            var5.setRglObjet("Ecart caisse");
            var5.setRglParc("");
            var5.setRglTimbre(0.0D);
            var5.setRglTrf(0);
            var5.setRglTypeTiers(3);
            var5.setRglUserCreat(this.usersLog.getUsrid());
            var5.setRglUserModif(0L);
            String var7 = "";
            if (var5.getRglDateReg().getMonth() + 1 <= 9) {
               var7 = "0" + (var5.getRglDateReg().getMonth() + 1);
            } else {
               var7 = "" + (var5.getRglDateReg().getMonth() + 1);
            }

            String var8 = "" + (var5.getRglDateReg().getYear() + 1900);
            var5.setRglPeriode(var7 + ":" + var8);
            var5.setRglCle1(var5.getRglCodeCaiss() + ":" + var5.getRglPeriode());
            String var9 = this.utilDate.dateToStringSQLLight(var5.getRglDateReg());
            var5.setRglCle2(var5.getRglCodeCaiss() + ":" + var9);
            var5.setRglCle3(var5.getRglCodeReceptrice() + ":" + var5.getRglPeriode());
            var5.setRglCle4(var5.getRglCodeReceptrice() + ":" + var9);
            var5.setExercicesCaisse(this.selectedExo);
            this.reglementsDao.insert(var5, var2);
         }

         var3.commit();
         var1 = true;
      } catch (HibernateException var13) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var1 && this.optionCaisses.getModeleClotMois() != null && !this.optionCaisses.getModeleClotMois().isEmpty()) {
         if (this.optionCaisses.getMailClotMois() != null && !this.optionCaisses.getMailClotMois().isEmpty()) {
            this.impressionRapport(this.optionCaisses.getModeleClotMois(), this.optionCaisses.getMailClotMois());
         } else {
            this.impressionRapport(this.optionCaisses.getModeleClotMois(), "");
         }
      }

      this.afficheTJM = false;
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.showModalPanelCloture = false;
   }

   public void clotureJournaliere() throws HibernateException, NamingException {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      int var9;
      if (this.lesReglements.size() != 0) {
         for(var9 = 0; var9 < this.lesReglements.size(); ++var9) {
            this.reglements = (Reglements)this.lesReglements.get(var9);
            if (this.reglements.getRglTypeReg() != 0) {
               var5 += this.reglements.getRglDepense();
               var7 += this.reglements.getRglRecette();
            }
         }
      }

      this.caissesJour.setCaijouEspeceTheorique(this.soldeFinalEspece);
      if (var5 > var7) {
         this.caissesJour.setCaijouAutre(var5 - var7);
      } else {
         this.caissesJour.setCaijouAutre(var7 - var5);
      }

      if (this.lesBonsCaisse.size() != 0) {
         for(var9 = 0; var9 < this.lesBonsCaisse.size(); ++var9) {
            this.reglements = (Reglements)this.lesBonsCaisse.get(var9);
            var1 += this.reglements.getRglDepense();
            var3 += this.reglements.getRglRecette();
         }
      }

      if (var1 > var3) {
         this.caissesJour.setCaijouBon(var1 - var3);
      } else {
         this.caissesJour.setCaijouBon(var3 - var1);
      }

      this.calculBilletageJournalier();
      this.showModalPanelCloture = true;
   }

   public void enregistrerClotureJournaliere() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.caissesJour.setCaijouEtat(0);
         this.caissesJour.setCaijouUserIdCloture(this.usersLog.getUsrid());
         this.caissesJour.setCaijouOpenJournal(0);
         this.caissesJour.setCaijouOpenUserJournal("");
         this.caissesJour.setCaijouSoldeEspece(this.soldeFinalEspece);
         this.caissesJour.setCaijouSoldeCheque(this.soldeFinalCheque);
         this.caissesJour.setCaijouSoldeVirement(this.soldeFinalVirement);
         this.caissesJour.setCaijouSoldeTraite(this.soldeFinalTraite);
         this.caissesJour.setCaijouSoldeTpe(this.soldeFinalTpe);
         this.caissesJour.setCaijouSoldeePaiement(this.soldeFinalePaiement);
         this.caissesJour.setCaijouSoldeCredoc(this.soldeFinalCredoc);
         this.caissesJour.setCaijouSoldeFactor(this.soldeFinalFactor);
         this.caissesJour.setCaijouSoldeCompense(this.soldeFinalCompense);
         this.caissesJour.setCaijouSoldeTerme(this.soldeFinalTerme);
         this.caissesJour.setCaijouSoldeBonCaisse(this.soldeFinalBonCaisse);
         this.caissesJour.setCaijouEcart(this.ecart);
         this.caissesJour = this.caissesJourDao.majJournal(this.caissesJour, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.afficheTJM = false;
      this.afficheTJJ = false;
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.showModalPanelCloture = false;
   }

   public void valideClotureJournaliere() throws HibernateException, NamingException {
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         Reglements var5;
         if (this.lesReglements.size() != 0) {
            for(int var4 = 0; var4 < this.lesReglements.size(); ++var4) {
               new Reglements();
               var5 = (Reglements)this.lesReglements.get(var4);
               var5.setRglDateCloture(new Date());
               this.reglementsDao.modifierReg(var5, var2);
            }
         }

         this.caissesJour.setCaijouEtat(1);
         this.caissesJour.setCaijouUserIdCloture(this.usersLog.getUsrid());
         this.caissesJour.setCaijouOpenJournal(0);
         this.caissesJour.setCaijouOpenUserJournal("");
         this.caissesJour.setCaijouSoldeEspece(this.soldeFinalEspece);
         this.caissesJour.setCaijouSoldeCheque(this.soldeFinalCheque);
         this.caissesJour.setCaijouSoldeVirement(this.soldeFinalVirement);
         this.caissesJour.setCaijouSoldeTraite(this.soldeFinalTraite);
         this.caissesJour.setCaijouSoldeTpe(this.soldeFinalTpe);
         this.caissesJour.setCaijouSoldeePaiement(this.soldeFinalePaiement);
         this.caissesJour.setCaijouSoldeCredoc(this.soldeFinalCredoc);
         this.caissesJour.setCaijouSoldeFactor(this.soldeFinalFactor);
         this.caissesJour.setCaijouSoldeCompense(this.soldeFinalCompense);
         this.caissesJour.setCaijouSoldeTerme(this.soldeFinalTerme);
         this.caissesJour.setCaijouSoldeBonCaisse(this.soldeFinalBonCaisse);
         this.caissesJour.setCaijouEcart(this.ecart);
         this.caissesJour = this.caissesJourDao.majJournal(this.caissesJour, var2);
         if (this.ecart != 0.0D) {
            CalculChrono var15 = new CalculChrono(this.baseLog, this.utilInitHibernate);
            var5 = new Reglements();
            var5.setRglDateReg(this.caissesJour.getCaijouDate());
            String var6 = "";
            if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
               var6 = var15.numCompose(new Date(), 61, "0", "", var2);
            } else {
               var6 = var15.numCompose(new Date(), 61, "", var2);
            }

            if (this.ecart > 0.0D) {
               var5.setRglOperation("27");
               var5.setRglRecette(0.0D);
               var5.setRglDepense(this.ecart);
            } else {
               var5.setRglOperation("17");
               var5.setRglRecette(this.ecart * -1.0D);
               var5.setRglDepense(0.0D);
            }

            var5.setRglBon("");
            var5.setRglCategorie(10);
            var5.setRglCodeCaiss(this.caissesCommerciales.getCaiCode());
            var5.setRglLibCaiss(this.caissesCommerciales.getCaiNom());
            var5.setRglCodeEmetrice("");
            var5.setRglLibEmetrice("");
            var5.setRglCodeReceptrice("");
            var5.setRglLibReceptrice("");
            var5.setRglDateCreation(new Date());
            var5.setRglDateImp((Date)null);
            var5.setRglDateTransfert((Date)null);
            var5.setRglDateValeur((Date)null);
            var5.setRglFormatDevise(this.structureLog.getStrformatdevise());
            var5.setRglIdCaissier(this.usersLog.getUsrid());
            var5.setRglIdDocument(0L);
            var5.setRglIdTiers(0L);
            var5.setRglDepotTiers(0);
            var5.setRglMode("0");
            var5.setRglModele("");
            var5.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            var5.setRglIdContact(0L);
            var5.setRglNomContact("");
            var5.setRglNum(var6);
            var5.setRglObjet("Ecart caisse");
            var5.setRglParc("");
            var5.setRglTimbre(0.0D);
            var5.setRglTrf(0);
            var5.setRglTypeTiers(3);
            var5.setRglUserCreat(this.usersLog.getUsrid());
            var5.setRglUserModif(0L);
            String var7 = "";
            if (var5.getRglDateReg().getMonth() + 1 <= 9) {
               var7 = "0" + (var5.getRglDateReg().getMonth() + 1);
            } else {
               var7 = "" + (var5.getRglDateReg().getMonth() + 1);
            }

            String var8 = "" + (var5.getRglDateReg().getYear() + 1900);
            var5.setRglPeriode(var7 + ":" + var8);
            var5.setRglCle1(var5.getRglCodeCaiss() + ":" + var5.getRglPeriode());
            String var9 = this.utilDate.dateToStringSQLLight(var5.getRglDateReg());
            var5.setRglCle2(var5.getRglCodeCaiss() + ":" + var9);
            var5.setRglCle3(var5.getRglCodeReceptrice() + ":" + var5.getRglPeriode());
            var5.setRglCle4(var5.getRglCodeReceptrice() + ":" + var9);
            var5.setExercicesCaisse(this.selectedExo);
            this.reglementsDao.insert(var5, var2);
         }

         var3.commit();
         var1 = true;
      } catch (HibernateException var13) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var1 && this.optionCaisses.getModeleClotJour() != null && !this.optionCaisses.getModeleClotJour().isEmpty()) {
         if (this.optionCaisses.getMailClotJour() != null && !this.optionCaisses.getMailClotJour().isEmpty()) {
            this.impressionRapport(this.optionCaisses.getModeleClotJour(), this.optionCaisses.getMailClotJour());
         } else {
            this.impressionRapport(this.optionCaisses.getModeleClotJour(), "");
         }
      }

      this.afficheTJM = false;
      this.afficheTJJ = false;
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.showModalPanelCloture = false;
   }

   public void impressionRapport(String var1, String var2) {
      if (var1 != null && !var1.isEmpty() && var2 != null && !var2.isEmpty()) {
      }

   }

   public void initImpressionSituationJournaliere() throws HibernateException, NamingException {
      if (this.caissesCommerciales != null && this.dataModelJour.isRowAvailable()) {
         this.caissesJour = (CaissesJour)this.dataModelJour.getRowData();
         this.caissesJour = this.caissesJourDao.recupererCaissesJour(this.caissesJour.getCaijouDate(), this.caissesJour.getCaijouCode(), (Session)null);
         if (this.caissesJour != null) {
            this.utilPrint = new UtilPrint(this.utilInitHibernate);
            this.nomModeleListe = "clotureJournaliere";
            this.showModalPanelPrint = true;
         }
      }

   }

   public void calculBilletageJournalier() throws HibernateException, NamingException {
      this.tot_b1 = (double)(this.val_b1 * this.caissesJour.getCaijouB1());
      this.tot_b2 = (double)(this.val_b2 * this.caissesJour.getCaijouB2());
      this.tot_b3 = (double)(this.val_b3 * this.caissesJour.getCaijouB3());
      this.tot_b4 = (double)(this.val_b4 * this.caissesJour.getCaijouB4());
      this.tot_b5 = (double)(this.val_b5 * this.caissesJour.getCaijouB5());
      this.tot_b6 = (double)(this.val_b6 * this.caissesJour.getCaijouB6());
      this.tot_b7 = (double)(this.val_b7 * this.caissesJour.getCaijouB7());
      this.tot_b8 = (double)(this.val_b8 * this.caissesJour.getCaijouB8());
      this.tot_b9 = (double)(this.val_b9 * this.caissesJour.getCaijouB9());
      this.tot_b10 = (double)(this.val_b10 * this.caissesJour.getCaijouB10());
      this.totalBillet = this.tot_b1 + this.tot_b2 + this.tot_b3 + this.tot_b4 + this.tot_b5 + this.tot_b6 + this.tot_b7 + this.tot_b8 + this.tot_b9 + this.tot_b10;
      this.tot_p1 = (double)(this.val_p1 * this.caissesJour.getCaijouP1());
      this.tot_p2 = (double)(this.val_p2 * this.caissesJour.getCaijouP2());
      this.tot_p3 = (double)(this.val_p3 * this.caissesJour.getCaijouP3());
      this.tot_p4 = (double)(this.val_p4 * this.caissesJour.getCaijouP4());
      this.tot_p5 = (double)(this.val_p5 * this.caissesJour.getCaijouP5());
      this.tot_p6 = (double)(this.val_p6 * this.caissesJour.getCaijouP6());
      this.tot_p7 = (double)(this.val_p7 * this.caissesJour.getCaijouP7());
      this.tot_p8 = (double)(this.val_p8 * this.caissesJour.getCaijouP8());
      this.tot_p9 = (double)(this.val_p9 * this.caissesJour.getCaijouP9());
      this.tot_p10 = (double)(this.val_p10 * this.caissesJour.getCaijouP10());
      this.totalPiece = this.tot_p1 + this.tot_p2 + this.tot_p3 + this.tot_p4 + this.tot_p5 + this.tot_p6 + this.tot_p7 + this.tot_p8 + this.tot_p9 + this.tot_p10;
      this.caissesJour.setCaijouEspeceReel(this.totalBillet + this.totalPiece);
      double var1 = 0.0D;
      if (!this.devise1.equals("*") && this.caissesJour.getCaijouDevise1() != 0.0D) {
         var1 = this.calculDevise(this.devise1, this.caissesJour.getCaijouDevise1());
      }

      double var3 = 0.0D;
      if (!this.devise2.equals("*") && this.caissesJour.getCaijouDevise2() != 0.0D) {
         var3 = this.calculDevise(this.devise2, this.caissesJour.getCaijouDevise2());
      }

      double var5 = 0.0D;
      if (!this.devise3.equals("*") && this.caissesJour.getCaijouDevise3() != 0.0D) {
         var5 = this.calculDevise(this.devise3, this.caissesJour.getCaijouDevise3());
      }

      double var7 = 0.0D;
      if (!this.devise4.equals("*") && this.caissesJour.getCaijouDevise4() != 0.0D) {
         var7 = this.calculDevise(this.devise4, this.caissesJour.getCaijouDevise4());
      }

      double var9 = 0.0D;
      if (!this.devise5.equals("*") && this.caissesJour.getCaijouDevise5() != 0.0D) {
         var9 = this.calculDevise(this.devise5, this.caissesJour.getCaijouDevise5());
      }

      this.caissesJour.setCaijouTimbre(var1 + var3 + var5 + var7 + var9);
      this.totalCaisse = this.caissesJour.getCaijouBon() + this.caissesJour.getCaijouEspeceReel() + this.caissesJour.getCaijouTimbre();
      this.ecart = this.caissesJour.getCaijouEspeceTheorique() - this.totalCaisse;
      this.caissesJour.setCaijouEcart(this.ecart);
   }

   public double calculDevise(String var1, double var2) {
      double var4 = 0.0D;
      float var6 = 0.0F;
      float var7 = 0.0F;
      if (var1.equals(this.structureLog.getStrdevise())) {
         var6 = 1.0F;
         var7 = 1.0F;
      } else {
         new ObjetDevises();
         ObjetDevises var8 = this.lectureDevises.devisesRecherchee(var1, this.structureLog.getStrdevise());
         if (var8 != null && var8.getTaux1() != null) {
            var6 = Float.parseFloat(var8.getTaux1());
         }

         if (var6 == 0.0F) {
            var6 = this.utilNombre.deviseTaux1(var1, this.caissesJour.getCaijouDate());
         }

         var8 = this.lectureDevises.devisesRecherchee(this.structureLog.getStrdevise(), this.structureLog.getStrdevise());
         if (var8 != null && var8.getTaux2() != null) {
            var7 = Float.parseFloat(var8.getTaux2());
         }

         if (var7 == 0.0F) {
            var7 = this.utilNombre.deviseTaux1(var1, this.caissesJour.getCaijouDate());
         }
      }

      var4 = var2 * (double)var6 * (double)var7;
      return var4;
   }

   public void calculBilletageMensuel() {
      this.tot_b1 = (double)(this.val_b1 * this.caissesMois.getCaimenB1());
      this.tot_b2 = (double)(this.val_b2 * this.caissesMois.getCaimenB2());
      this.tot_b3 = (double)(this.val_b3 * this.caissesMois.getCaimenB3());
      this.tot_b4 = (double)(this.val_b4 * this.caissesMois.getCaimenB4());
      this.tot_b5 = (double)(this.val_b5 * this.caissesMois.getCaimenB5());
      this.tot_b6 = (double)(this.val_b6 * this.caissesMois.getCaimenB6());
      this.tot_b7 = (double)(this.val_b7 * this.caissesMois.getCaimenB7());
      this.tot_b8 = (double)(this.val_b8 * this.caissesMois.getCaimenB8());
      this.tot_b9 = (double)(this.val_b9 * this.caissesMois.getCaimenB9());
      this.tot_b10 = (double)(this.val_b10 * this.caissesMois.getCaimenB10());
      this.totalBillet = this.tot_b1 + this.tot_b2 + this.tot_b3 + this.tot_b4 + this.tot_b5 + this.tot_b6 + this.tot_b7 + this.tot_b8 + this.tot_b9 + this.tot_b10;
      this.tot_p1 = (double)(this.val_p1 * this.caissesMois.getCaimenP1());
      this.tot_p2 = (double)(this.val_p2 * this.caissesMois.getCaimenP2());
      this.tot_p3 = (double)(this.val_p3 * this.caissesMois.getCaimenP3());
      this.tot_p4 = (double)(this.val_p4 * this.caissesMois.getCaimenP4());
      this.tot_p5 = (double)(this.val_p5 * this.caissesMois.getCaimenP5());
      this.tot_p6 = (double)(this.val_p6 * this.caissesMois.getCaimenP6());
      this.tot_p7 = (double)(this.val_p7 * this.caissesMois.getCaimenP7());
      this.tot_p8 = (double)(this.val_p8 * this.caissesMois.getCaimenP8());
      this.tot_p9 = (double)(this.val_p9 * this.caissesMois.getCaimenP9());
      this.tot_p10 = (double)(this.val_p10 * this.caissesMois.getCaimenP10());
      this.totalPiece = this.tot_p1 + this.tot_p2 + this.tot_p3 + this.tot_p4 + this.tot_p5 + this.tot_p6 + this.tot_p7 + this.tot_p8 + this.tot_p9 + this.tot_p10;
   }

   public void fermerCloture() {
      this.showModalPanelCloture = false;
   }

   public void envoieMAILSituation() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
         if (this.utilPrint.getLesbalEmetteursItems().size() != 0 && this.utilPrint.getLesbalDestinatairesItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public void imprimerPRTSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PRT";
      this.imprimerSituation();
   }

   public void imprimerJRVSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimerSituation();
   }

   public void imprimerPDFSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimerSituation();
   }

   public void imprimerODTSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "ODT";
      this.imprimerSituation();
   }

   public void imprimerXLSSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XLS";
      this.imprimerSituation();
   }

   public void imprimerDOCSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "DOC";
      this.imprimerSituation();
   }

   public void imprimerHTMLSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "HTML";
      this.imprimerSituation();
   }

   public void imprimerXMLSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XML";
      this.imprimerSituation();
   }

   public void imprimerMAILSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimerSituation();
      }

   }

   public String calculeCheminRapportSituation(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator + "cloture" + File.separator;
      return var2;
   }

   public String calculeCheminSousRapportSituation(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public void imprimerSituation() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.calculerSoldeAnterieurJournalier((Session)null);
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Situation caisse " + this.caissesCommerciales.getCaiCode() + " " + this.caissesCommerciales.getCaiNom());
         if (this.modeJournal == 0) {
            String var1 = this.utilDate.dateToStringFr(this.caissesJour.getCaijouDate());
            this.utilPrint.setFiltre("Du " + var1);
            this.requete = "caijou_id = " + this.caissesJour.getCaijouId();
         } else {
            this.utilPrint.setFiltre("Période " + this.caissesMois.getCaimenPeriode());
            this.requete = "caimen_id = " + this.caissesMois.getCaimenId();
         }

         this.utilPrint.setValeur1(this.soldeAnterieurEspece);
         this.utilPrint.setCheminRapport(this.calculeCheminRapportSituation("structure" + this.structureLog.getStrid()));
         this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapportSituation("structure" + this.structureLog.getStrid()));
         this.utilPrint.setRequete(this.requete);
         this.utilPrint.setNomMapping("Reglements");
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(this.nature);
         this.utilPrint.setId_doc(0L);
         ArrayList var3 = new ArrayList();
         JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var3);
         this.utilPrint.setjRBeanCollectionDataSource(var2);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

      this.showModalPanelPrint = false;
   }

   public void initImpressionMensuelle() throws IOException, ParseException {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.affMail = false;
      String[] var1 = this.caissesMois.getCaimenPeriode().split(":");
      String var2 = var1[0];
      String var3 = var1[1];
      this.dateSoldeCaisse = this.utilDate.dateDernierJourMois(this.utilDate.stringToDateSQLLight(var3 + "-" + var2 + "-01"));
      this.showModalPanelPrint = true;
   }

   public void initImpressionJournaliere() throws IOException {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.affMail = false;
      this.dateSoldeCaisse = this.caissesJour.getCaijouDate();
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
   }

   public void OptionMail() {
      if (this.format.equalsIgnoreCase("MAIL")) {
         this.visibleOptionMail = true;
      } else {
         this.visibleOptionMail = false;
      }

   }

   public void envoieMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
         if (this.utilPrint.getLesbalEmetteursItems().size() != 0 && this.utilPrint.getLesbalDestinatairesItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

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

   public void imprimerMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimer();
      }

   }

   public void ListeDocImp() {
      if (this.var_choix_modele == 0) {
         this.affListeDoc = false;
      } else {
         this.affListeDoc = true;
      }

   }

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator + "journaux" + File.separator;
      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommunJournalier() throws IOException, HibernateException, NamingException {
      JRBeanCollectionDataSource var1 = null;
      if (this.nomModeleListe.equalsIgnoreCase("EtatCaisse")) {
         this.var_type_onglet = 99;
      }

      if (this.var_type_onglet == 99) {
         this.utilPrint.setValeur1(this.soldeAnterieurEspece + this.soldeAnterieurCheque + this.soldeAnterieurVirement + this.soldeAnterieurTpe + this.soldeAnterieurTransfert + this.soldeAnterieurePaiement + this.soldeAnterieurCredoc + this.soldeAnterieurFactor + this.soldeAnterieurCompense + this.soldeAnterieurTerme);
         if (this.nomModeleListe.equalsIgnoreCase("EtatCaisse")) {
            ArrayList var2 = new ArrayList();
            int var3;
            if (this.lesReglements.size() != 0) {
               for(var3 = 0; var3 < this.lesReglements.size(); ++var3) {
                  this.reglements = (Reglements)this.lesReglements.get(var3);
                  if ((this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) && (this.reglements.getRglDateMvt1() == null || this.reglements.getRglDateMvt1() != null && this.reglements.getRglDateMvt1().before(this.dateSoldeCaisse) || this.reglements.getRglDateMvt1().equals(this.dateSoldeCaisse))) {
                     var2.add(this.reglements);
                  }
               }
            }

            Reglements var4;
            if (this.lesBonsCaisse.size() != 0) {
               for(var3 = 0; var3 < this.lesBonsCaisse.size(); ++var3) {
                  new Reglements();
                  var4 = (Reglements)this.lesBonsCaisse.get(var3);
                  if ((var4.getRglDateReg().before(this.dateSoldeCaisse) || var4.getRglDateReg().equals(this.dateSoldeCaisse)) && var4.getRglDateExecBc() == null) {
                     var4.setRglTypeReg(90);
                     var2.add(var4);
                  }
               }
            }

            if (this.lesEcart.size() != 0) {
               for(var3 = 0; var3 < this.lesEcart.size(); ++var3) {
                  new Reglements();
                  var4 = (Reglements)this.lesEcart.get(var3);
                  if ((var4.getRglDateReg().before(this.dateSoldeCaisse) || var4.getRglDateReg().equals(this.dateSoldeCaisse)) && var4.getRglDateExecBc() == null) {
                     var4.setRglTypeReg(91);
                     var2.add(var4);
                  }
               }
            }

            var1 = new JRBeanCollectionDataSource(var2);
         } else {
            var1 = new JRBeanCollectionDataSource(this.lesReglements);
         }
      } else if (this.var_type_onglet == 90) {
         this.utilPrint.setValeur1(0.0D);
         var1 = new JRBeanCollectionDataSource(this.lesBonsCaisse);
      } else if (this.var_type_onglet == 91) {
         this.utilPrint.setValeur1(0.0D);
         var1 = new JRBeanCollectionDataSource(this.lesEcart);
      } else if (this.var_type_onglet == 92) {
         this.utilPrint.setValeur1(0.0D);
         var1 = new JRBeanCollectionDataSource(this.lesErreurs);
      } else if (this.var_type_onglet != 0 && this.var_type_onglet != 11) {
         if (this.var_type_onglet == 1) {
            this.utilPrint.setValeur1(this.soldeAnterieurCheque);
            var1 = new JRBeanCollectionDataSource(this.lesCheques);
         } else if (this.var_type_onglet == 2) {
            this.utilPrint.setValeur1(this.soldeAnterieurVirement);
            var1 = new JRBeanCollectionDataSource(this.lesVirements);
         } else if (this.var_type_onglet == 3) {
            this.utilPrint.setValeur1(this.soldeAnterieurVirement);
            var1 = new JRBeanCollectionDataSource(this.lesTraites);
         } else if (this.var_type_onglet == 4) {
            this.utilPrint.setValeur1(this.soldeAnterieurTpe);
            var1 = new JRBeanCollectionDataSource(this.lesTpes);
         } else if (this.var_type_onglet == 5) {
            this.utilPrint.setValeur1(this.soldeAnterieurTransfert);
            var1 = new JRBeanCollectionDataSource(this.lesTransferts);
         } else if (this.var_type_onglet == 6) {
            this.utilPrint.setValeur1(this.soldeAnterieurePaiement);
            var1 = new JRBeanCollectionDataSource(this.lesePaiements);
         } else if (this.var_type_onglet == 7) {
            this.utilPrint.setValeur1(this.soldeAnterieurCredoc);
            var1 = new JRBeanCollectionDataSource(this.lesCredocs);
         } else if (this.var_type_onglet == 8) {
            this.utilPrint.setValeur1(this.soldeAnterieurFactor);
            var1 = new JRBeanCollectionDataSource(this.lesFactors);
         } else if (this.var_type_onglet == 9) {
            this.utilPrint.setValeur1(this.soldeAnterieurCompense);
            var1 = new JRBeanCollectionDataSource(this.lesCompenses);
         } else if (this.var_type_onglet == 10) {
            this.utilPrint.setValeur1(this.soldeAnterieurTerme);
            var1 = new JRBeanCollectionDataSource(this.lesTermes);
         }
      } else {
         this.utilPrint.setValeur1(this.soldeAnterieurEspece);
         var1 = new JRBeanCollectionDataSource(this.lesEspeces);
      }

      return var1;
   }

   public JRBeanCollectionDataSource calculeImpressionCommunMensuel() throws IOException, HibernateException, NamingException {
      JRBeanCollectionDataSource var1 = null;
      if (this.nomModeleListe.equalsIgnoreCase("EtatCaisse")) {
         this.var_type_onglet = 99;
      }

      ArrayList var2 = new ArrayList();
      int var3;
      if (this.var_type_onglet == 99) {
         this.utilPrint.setValeur1(this.soldeAnterieurEspece + this.soldeAnterieurCheque + this.soldeAnterieurVirement + this.soldeAnterieurTpe + this.soldeAnterieurTransfert + this.soldeAnterieurePaiement + this.soldeAnterieurCredoc + this.soldeAnterieurFactor + this.soldeAnterieurCompense + this.soldeAnterieurTerme);
         if (this.nomModeleListe.equalsIgnoreCase("EtatCaisse")) {
            if (this.lesReglements.size() != 0) {
               for(var3 = 0; var3 < this.lesReglements.size(); ++var3) {
                  this.reglements = (Reglements)this.lesReglements.get(var3);
                  if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                     var2.add(this.reglements);
                  }
               }
            }

            Reglements var4;
            if (this.lesBonsCaisse.size() != 0) {
               for(var3 = 0; var3 < this.lesBonsCaisse.size(); ++var3) {
                  new Reglements();
                  var4 = (Reglements)this.lesBonsCaisse.get(var3);
                  if ((var4.getRglDateReg().before(this.dateSoldeCaisse) || var4.getRglDateReg().equals(this.dateSoldeCaisse)) && var4.getRglDateExecBc() == null) {
                     var4.setRglTypeReg(90);
                     var2.add(var4);
                  }
               }
            }

            if (this.lesEcart.size() != 0) {
               for(var3 = 0; var3 < this.lesEcart.size(); ++var3) {
                  new Reglements();
                  var4 = (Reglements)this.lesEcart.get(var3);
                  if ((var4.getRglDateReg().before(this.dateSoldeCaisse) || var4.getRglDateReg().equals(this.dateSoldeCaisse)) && var4.getRglDateExecBc() == null) {
                     var4.setRglTypeReg(91);
                     var2.add(var4);
                  }
               }
            }

            var1 = new JRBeanCollectionDataSource(var2);
         } else {
            if (this.lesReglements.size() != 0) {
               for(var3 = 0; var3 < this.lesReglements.size(); ++var3) {
                  this.reglements = (Reglements)this.lesReglements.get(var3);
                  if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                     var2.add(this.reglements);
                  }
               }
            }

            var1 = new JRBeanCollectionDataSource(var2);
         }
      } else if (this.var_type_onglet == 90) {
         this.utilPrint.setValeur1(0.0D);
         if (this.lesBonsCaisse.size() != 0) {
            for(var3 = 0; var3 < this.lesBonsCaisse.size(); ++var3) {
               this.reglements = (Reglements)this.lesBonsCaisse.get(var3);
               if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                  var2.add(this.reglements);
               }
            }
         }

         var1 = new JRBeanCollectionDataSource(var2);
      } else if (this.var_type_onglet == 91) {
         this.utilPrint.setValeur1(0.0D);
         if (this.lesEcart.size() != 0) {
            for(var3 = 0; var3 < this.lesEcart.size(); ++var3) {
               this.reglements = (Reglements)this.lesEcart.get(var3);
               if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                  var2.add(this.reglements);
               }
            }
         }

         var1 = new JRBeanCollectionDataSource(var2);
      } else if (this.var_type_onglet == 92) {
         this.utilPrint.setValeur1(0.0D);
         if (this.lesErreurs.size() != 0) {
            for(var3 = 0; var3 < this.lesErreurs.size(); ++var3) {
               this.reglements = (Reglements)this.lesErreurs.get(var3);
               if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                  var2.add(this.reglements);
               }
            }
         }

         var1 = new JRBeanCollectionDataSource(var2);
      } else if (this.var_type_onglet != 0 && this.var_type_onglet != 11) {
         if (this.var_type_onglet == 1) {
            this.utilPrint.setValeur1(this.soldeAnterieurCheque);
            if (this.lesCheques.size() != 0) {
               for(var3 = 0; var3 < this.lesCheques.size(); ++var3) {
                  this.reglements = (Reglements)this.lesCheques.get(var3);
                  if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                     var2.add(this.reglements);
                  }
               }
            }

            var1 = new JRBeanCollectionDataSource(var2);
         } else if (this.var_type_onglet == 2) {
            this.utilPrint.setValeur1(this.soldeAnterieurVirement);
            if (this.lesVirements.size() != 0) {
               for(var3 = 0; var3 < this.lesVirements.size(); ++var3) {
                  this.reglements = (Reglements)this.lesVirements.get(var3);
                  if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                     var2.add(this.reglements);
                  }
               }
            }

            var1 = new JRBeanCollectionDataSource(var2);
         } else if (this.var_type_onglet == 3) {
            this.utilPrint.setValeur1(this.soldeAnterieurVirement);
            if (this.lesTraites.size() != 0) {
               for(var3 = 0; var3 < this.lesTraites.size(); ++var3) {
                  this.reglements = (Reglements)this.lesTraites.get(var3);
                  if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                     var2.add(this.reglements);
                  }
               }
            }

            var1 = new JRBeanCollectionDataSource(var2);
         } else if (this.var_type_onglet == 4) {
            this.utilPrint.setValeur1(this.soldeAnterieurTpe);
            if (this.lesTpes.size() != 0) {
               for(var3 = 0; var3 < this.lesTpes.size(); ++var3) {
                  this.reglements = (Reglements)this.lesTpes.get(var3);
                  if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                     var2.add(this.reglements);
                  }
               }
            }

            var1 = new JRBeanCollectionDataSource(var2);
         } else if (this.var_type_onglet == 5) {
            this.utilPrint.setValeur1(this.soldeAnterieurTransfert);
            if (this.lesTransferts.size() != 0) {
               for(var3 = 0; var3 < this.lesTransferts.size(); ++var3) {
                  this.reglements = (Reglements)this.lesTransferts.get(var3);
                  if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                     var2.add(this.reglements);
                  }
               }
            }

            var1 = new JRBeanCollectionDataSource(var2);
         } else if (this.var_type_onglet == 6) {
            this.utilPrint.setValeur1(this.soldeAnterieurePaiement);
            if (this.lesePaiements.size() != 0) {
               for(var3 = 0; var3 < this.lesePaiements.size(); ++var3) {
                  this.reglements = (Reglements)this.lesePaiements.get(var3);
                  if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                     var2.add(this.reglements);
                  }
               }
            }

            var1 = new JRBeanCollectionDataSource(var2);
         } else if (this.var_type_onglet == 7) {
            this.utilPrint.setValeur1(this.soldeAnterieurCredoc);
            if (this.lesCredocs.size() != 0) {
               for(var3 = 0; var3 < this.lesCredocs.size(); ++var3) {
                  this.reglements = (Reglements)this.lesCredocs.get(var3);
                  if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                     var2.add(this.reglements);
                  }
               }
            }

            var1 = new JRBeanCollectionDataSource(var2);
         } else if (this.var_type_onglet == 8) {
            this.utilPrint.setValeur1(this.soldeAnterieurFactor);
            if (this.lesFactors.size() != 0) {
               for(var3 = 0; var3 < this.lesFactors.size(); ++var3) {
                  this.reglements = (Reglements)this.lesFactors.get(var3);
                  if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                     var2.add(this.reglements);
                  }
               }
            }

            var1 = new JRBeanCollectionDataSource(var2);
         } else if (this.var_type_onglet == 9) {
            this.utilPrint.setValeur1(this.soldeAnterieurCompense);
            if (this.lesCompenses.size() != 0) {
               for(var3 = 0; var3 < this.lesCompenses.size(); ++var3) {
                  this.reglements = (Reglements)this.lesCompenses.get(var3);
                  if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                     var2.add(this.reglements);
                  }
               }
            }

            var1 = new JRBeanCollectionDataSource(var2);
         } else if (this.var_type_onglet == 10) {
            this.utilPrint.setValeur1(this.soldeAnterieurTerme);
            if (this.lesTermes.size() != 0) {
               for(var3 = 0; var3 < this.lesTermes.size(); ++var3) {
                  this.reglements = (Reglements)this.lesTermes.get(var3);
                  if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                     var2.add(this.reglements);
                  }
               }
            }

            var1 = new JRBeanCollectionDataSource(var2);
         }
      } else {
         this.utilPrint.setValeur1(this.soldeAnterieurEspece);
         if (this.lesEspeces.size() != 0) {
            for(var3 = 0; var3 < this.lesEspeces.size(); ++var3) {
               this.reglements = (Reglements)this.lesEspeces.get(var3);
               if (this.reglements.getRglDateReg().before(this.dateSoldeCaisse) || this.reglements.getRglDateReg().equals(this.dateSoldeCaisse)) {
                  var2.add(this.reglements);
               }
            }
         }

         var1 = new JRBeanCollectionDataSource(var2);
      }

      return var1;
   }

   public JRBeanCollectionDataSource calculeImpressionBordereauVersementJournalier() throws IOException, HibernateException, NamingException {
      JRBeanCollectionDataSource var1 = null;
      ArrayList var2 = new ArrayList();
      new DocumentEntete();
      new ArrayList();
      new ConsultationReglement();
      ConsultationReglementDao var6 = new ConsultationReglementDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new PharmacieReglement();
      PharmacieReglementDao var9 = new PharmacieReglementDao(this.baseLog, this.utilInitHibernate);
      LaboratoireEntete var10 = new LaboratoireEntete();
      new ArrayList();
      new LaboratoireReglement();
      LaboratoireReglementDao var13 = new LaboratoireReglementDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new HospitalisationReglement();
      HospitalisationReglementDao var16 = new HospitalisationReglementDao(this.baseLog, this.utilInitHibernate);
      Session var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
      ArrayList var18 = new ArrayList();
      double var19 = 0.0D;
      new ArrayList();
      ConsultationActesDao var22 = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      PharmacieLigneDao var24 = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      LaboratoireLigneDao var26 = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
      if (this.lesReglements.size() != 0) {
         for(int var27 = 0; var27 < this.lesReglements.size(); ++var27) {
            this.reglements = (Reglements)this.lesReglements.get(var27);
            DocumentEntete var3;
            boolean var29;
            int var31;
            int var35;
            byte var36;
            boolean var38;
            if (this.reglements.getRglNatureDoc() == 71) {
               List var4 = var6.selectReglementByIdRecu(this.reglements.getRglId(), var17);
               if (var4.size() != 0) {
                  for(var35 = 0; var35 < var4.size(); ++var35) {
                     ConsultationReglement var5 = (ConsultationReglement)var4.get(var35);
                     var29 = false;
                     if (var5.getCsgregCaisse().equals(this.caissesJour.getCaijouCode()) && var5.getCsgregDate().equals(this.caissesJour.getCaijouDate())) {
                        if (this.reglements.getRglService() != null && !this.reglements.getRglService().isEmpty() && var5.getCsgregService() != null && !var5.getCsgregService().isEmpty() && var5.getCsgregService().equals(this.reglements.getRglService())) {
                           var36 = 1;
                        } else if (this.reglements.getRglService() != null && !this.reglements.getRglService().isEmpty() && (var5.getCsgregService() == null || var5.getCsgregService().isEmpty()) && var5.getCsgregPatient() < 0.0D) {
                           var36 = 2;
                        } else {
                           var36 = 3;
                        }

                        if (var36 != 0) {
                           var3 = new DocumentEntete();
                           var3.setDocCodeCaiss(this.caissesJour.getCaijouCode());
                           var3.setDocIdResponsable(var5.getConsultationEnteteGene().getCsgIdPatient());
                           var3.setDocAnal2(var5.getCsgregProduit());
                           var3.setDocAnal4(var5.getCsgregLibelle());
                           var3.setDocNum(var5.getConsultationEnteteGene().getCsgNum());
                           var38 = false;
                           if (var2.size() != 0) {
                              for(var31 = 0; var31 < var2.size(); ++var31) {
                                 if (((DocumentEntete)var2.get(var31)).getDocNum().equals(var5.getConsultationEnteteGene().getCsgNum()) && ((DocumentEntete)var2.get(var31)).getDocAnal2().equals(var5.getCsgregProduit()) && ((DocumentEntete)var2.get(var31)).getDocService().equals(var5.getCsgregService())) {
                                    var38 = true;
                                    break;
                                 }
                              }
                           }

                           if (var38 && var5.getCsgregPatient() >= 0.0D) {
                              var3.setDocQte(0.0F);
                           } else if (var5.getCsgregPatient() < 0.0D) {
                              var3.setDocQte(-1.0F);
                           } else {
                              var3.setDocQte(1.0F);
                           }

                           var19 = 0.0D;
                           List var21 = var22.selectConsActesByConsEnt(this.reglements.getRglIdDocument(), var17);
                           if (var21.size() != 0) {
                              for(var31 = 0; var31 < var21.size(); ++var31) {
                                 if (((ConsultationActes)var21.get(var31)).getCslactProduit() != null && !((ConsultationActes)var21.get(var31)).getCslactProduit().isEmpty() && ((ConsultationActes)var21.get(var31)).getCslactProduit().equals(var5.getCsgregProduit())) {
                                    var19 += ((ConsultationActes)var21.get(var31)).getCslactPatientHt() + ((ConsultationActes)var21.get(var31)).getCslactPatientTaxe();
                                 }
                              }
                           }

                           var3.setDocTotHt(var19);
                           var3.setDocTotReglement(var5.getCsgregPatient());
                           var3.setDocService(var5.getCsgregService());
                           if (var36 != 2 || var3.getDocService() != null && !var3.getDocService().isEmpty()) {
                              if (var36 == 3 && (var3.getDocService() == null || var3.getDocService().isEmpty())) {
                                 var3.setDocService("SERVICE NON RENSEIGNE");
                              }
                           } else {
                              var3.setDocService("ANNULATION");
                           }

                           var2.add(var3);
                        }
                     }
                  }
               } else {
                  var3 = new DocumentEntete();
                  var3.setDocCodeCaiss(this.caissesJour.getCaijouCode());
                  var3.setDocIdResponsable(this.reglements.getRglIdTiers());
                  var3.setDocAnal2("");
                  var3.setDocAnal4(this.reglements.getRglLibelle());
                  var3.setDocNum(this.reglements.getRglDocument());
                  if (this.reglements.getRglRecette() < 0.0D) {
                     if (this.reglements.getRglRecette() < 0.0D) {
                        var3.setDocQte(-1.0F);
                     } else {
                        var3.setDocQte(1.0F);
                     }
                  } else {
                     var3.setDocQte(0.0F);
                  }

                  var3.setDocTotHt(0.0D);
                  var3.setDocTotReglement(this.reglements.getRglRecette());
                  var3.setDocService(this.reglements.getRglService());
                  if (this.reglements.getRglRecette() >= 0.0D || this.reglements.getRglService() != null && !this.reglements.getRglService().isEmpty()) {
                     if (this.reglements.getRglRecette() > 0.0D && (this.reglements.getRglService() == null || this.reglements.getRglService().isEmpty())) {
                        var3.setDocService("SERVICE NON RENSEIGNE");
                     }
                  } else {
                     var3.setDocService("ANNULATION");
                  }

                  var2.add(var3);
               }
            } else if (this.reglements.getRglNatureDoc() == 73) {
               List var7 = var9.selectReglementByIdRecu(this.reglements.getRglId(), var17);
               if (var7.size() != 0) {
                  for(var35 = 0; var35 < var7.size(); ++var35) {
                     PharmacieReglement var8 = (PharmacieReglement)var7.get(var35);
                     var29 = false;
                     if (var8.getPharegCaisse().equals(this.caissesJour.getCaijouCode()) && var8.getPharegDate().equals(this.caissesJour.getCaijouDate())) {
                        if (this.reglements.getRglService() != null && !this.reglements.getRglService().isEmpty() && var8.getPharegService() != null && !var8.getPharegService().isEmpty() && var8.getPharegService().equals(this.reglements.getRglService())) {
                           var36 = 1;
                        } else if (this.reglements.getRglService() != null && !this.reglements.getRglService().isEmpty() && (var8.getPharegService() == null || var8.getPharegService().isEmpty()) && var8.getPharegPatient() < 0.0D) {
                           var36 = 2;
                        } else {
                           var36 = 3;
                        }

                        if (var36 != 0) {
                           var3 = new DocumentEntete();
                           var3.setDocCodeCaiss(this.caissesJour.getCaijouCode());
                           var3.setDocIdResponsable(var8.getPharmacieEntete().getPhaIdPatient());
                           var3.setDocAnal2(var8.getPharegProduit());
                           var3.setDocAnal4(var8.getPharegLibelle());
                           var3.setDocNum(var8.getPharmacieEntete().getPhaNum());
                           var38 = false;
                           if (var2.size() != 0) {
                              for(var31 = 0; var31 < var2.size(); ++var31) {
                                 if (((DocumentEntete)var2.get(var31)).getDocNum().equals(var8.getPharmacieEntete().getPhaNum()) && ((DocumentEntete)var2.get(var31)).getDocAnal2().equals(var8.getPharegProduit()) && ((DocumentEntete)var2.get(var31)).getDocService().equals(var8.getPharegService())) {
                                    var38 = true;
                                    break;
                                 }
                              }
                           }

                           if (var38 && var8.getPharegPatient() >= 0.0D) {
                              var3.setDocQte(0.0F);
                           } else if (var8.getPharegPatient() < 0.0D) {
                              var3.setDocQte(-1.0F);
                           } else {
                              var3.setDocQte(1.0F);
                           }

                           var19 = 0.0D;
                           List var23 = var24.selectConsActesByConsEnt(this.reglements.getRglIdDocument(), var17);
                           if (var23.size() != 0) {
                              for(var31 = 0; var31 < var23.size(); ++var31) {
                                 if (((PharmacieLigne)var23.get(var31)).getPhaligProduit() != null && !((PharmacieLigne)var23.get(var31)).getPhaligProduit().isEmpty() && ((PharmacieLigne)var23.get(var31)).getPhaligProduit().equals(var8.getPharegProduit())) {
                                    var19 += ((PharmacieLigne)var23.get(var31)).getPhaligPatientHt() + ((PharmacieLigne)var23.get(var31)).getPhaligPatientTaxe();
                                 }
                              }
                           }

                           var3.setDocTotHt(var19);
                           var3.setDocTotReglement(var8.getPharegPatient());
                           var3.setDocService(var8.getPharegService());
                           if (var36 == 2 && (var3.getDocService() == null || var3.getDocService().isEmpty())) {
                              var3.setDocService("ANNULATION");
                           } else if (var36 == 3 && (var3.getDocService() == null || var3.getDocService().isEmpty())) {
                              var3.setDocService("SERVICE NON RENSEIGNE");
                           }

                           var2.add(var3);
                        }
                     }
                  }
               } else {
                  var3 = new DocumentEntete();
                  var3.setDocCodeCaiss(this.caissesJour.getCaijouCode());
                  var3.setDocIdResponsable(this.reglements.getRglIdTiers());
                  var3.setDocAnal2("");
                  var3.setDocAnal4(this.reglements.getRglLibelle());
                  var3.setDocNum(this.reglements.getRglDocument());
                  if (this.reglements.getRglRecette() < 0.0D) {
                     if (this.reglements.getRglRecette() < 0.0D) {
                        var3.setDocQte(-1.0F);
                     } else {
                        var3.setDocQte(1.0F);
                     }
                  } else {
                     var3.setDocQte(0.0F);
                  }

                  var3.setDocTotHt(0.0D);
                  var3.setDocTotReglement(this.reglements.getRglRecette());
                  var3.setDocService(this.reglements.getRglService());
                  if (this.reglements.getRglRecette() >= 0.0D || this.reglements.getRglService() != null && !this.reglements.getRglService().isEmpty()) {
                     if (this.reglements.getRglRecette() > 0.0D && (this.reglements.getRglService() == null || this.reglements.getRglService().isEmpty())) {
                        var3.setDocService("SERVICE NON RENSEIGNE");
                     }
                  } else {
                     var3.setDocService("ANNULATION");
                  }

                  var2.add(var3);
               }
            } else if (this.reglements.getRglNatureDoc() == 74) {
               List var11 = var13.selectReglementByIdRecu(this.reglements.getRglId(), var17);
               if (var11.size() != 0) {
                  for(var35 = 0; var35 < var11.size(); ++var35) {
                     LaboratoireReglement var12 = (LaboratoireReglement)var11.get(var35);
                     var29 = false;
                     if (var12.getLabregCaisse().equals(this.caissesJour.getCaijouCode()) && var12.getLabregDate().compareTo(this.caissesJour.getCaijouDate()) == 0) {
                        if (this.reglements.getRglPdv() != null && !this.reglements.getRglPdv().isEmpty() && var12.getLabregLaboratoire() != null && !var12.getLabregLaboratoire().isEmpty() && var12.getLabregLaboratoire().equals(this.reglements.getRglPdv())) {
                           var36 = 1;
                        } else if (this.reglements.getRglPdv() != null && !this.reglements.getRglPdv().isEmpty() && (var12.getLabregLaboratoire() == null || var12.getLabregLaboratoire().isEmpty()) && var12.getLabregPatient() < 0.0D) {
                           var36 = 2;
                        } else {
                           var36 = 3;
                        }

                        if (var36 != 0) {
                           var3 = new DocumentEntete();
                           var3.setDocCodeCaiss(this.caissesJour.getCaijouCode());
                           var3.setDocIdResponsable(var12.getLaboratoireEntete().getLabIdPatient());
                           var3.setDocAnal2(var12.getLabregProduit());
                           var3.setDocAnal4(var12.getLabregLibelle());
                           var3.setDocNum(var12.getLaboratoireEntete().getLabNum());
                           var38 = false;
                           if (var2.size() != 0) {
                              for(var31 = 0; var31 < var2.size(); ++var31) {
                                 if (((DocumentEntete)var2.get(var31)).getDocNum().equals(var12.getLaboratoireEntete().getLabNum()) && ((DocumentEntete)var2.get(var31)).getDocAnal2().equals(var12.getLabregProduit()) && ((DocumentEntete)var2.get(var31)).getDocService().equals(var12.getLabregService())) {
                                    var38 = true;
                                    break;
                                 }
                              }
                           }

                           if (!var38) {
                              var3.setDocQte(1.0F);
                           } else {
                              var3.setDocQte(0.0F);
                           }

                           var19 = 0.0D;
                           List var25 = var26.selectConsActesByConsEnt(this.reglements.getRglIdDocument(), var17);
                           if (var25.size() != 0) {
                              for(var31 = 0; var31 < var25.size(); ++var31) {
                                 if (((LaboratoireLigne)var25.get(var31)).getLabligProduit() != null && !((LaboratoireLigne)var25.get(var31)).getLabligProduit().isEmpty() && ((LaboratoireLigne)var25.get(var31)).getLabligProduit().equals(var12.getLabregProduit())) {
                                    var19 += ((LaboratoireLigne)var25.get(var31)).getLabligPatientHt() + ((LaboratoireLigne)var25.get(var31)).getLabligPatientTaxe();
                                 }
                              }
                           }

                           var3.setDocTotHt(var19);
                           var3.setDocTotReglement(var12.getLabregPatient());
                           if (var12.getLabregLaboratoire() != null && !var12.getLabregLaboratoire().isEmpty()) {
                              var3.setDocNomEquipe(var12.getLabregLaboratoire());
                              var3.setDocService(var3.getDocNomEquipe());
                           } else if (var10.getLabLaboratoire() != null && !var10.getLabLaboratoire().isEmpty()) {
                              var3.setDocNomEquipe(var10.getLabLaboratoire());
                              var3.setDocService(var3.getDocNomEquipe());
                           } else {
                              var3.setDocNomEquipe(var10.getLabService());
                              var3.setDocService(var3.getDocNomEquipe());
                           }

                           if (var36 == 2 && (var3.getDocService() == null || var3.getDocService().isEmpty())) {
                              var3.setDocService("ANNULATION");
                           } else if (var36 == 3 && (var3.getDocService() == null || var3.getDocService().isEmpty())) {
                              var3.setDocService("SERVICE NON RENSEIGNE");
                           }

                           var2.add(var3);
                        }
                     }
                  }
               } else {
                  var3 = new DocumentEntete();
                  var3.setDocCodeCaiss(this.caissesJour.getCaijouCode());
                  var3.setDocIdResponsable(this.reglements.getRglIdTiers());
                  var3.setDocAnal2("");
                  var3.setDocAnal4(this.reglements.getRglLibelle());
                  var3.setDocNum(this.reglements.getRglDocument());
                  if (this.reglements.getRglRecette() < 0.0D) {
                     if (this.reglements.getRglRecette() < 0.0D) {
                        var3.setDocQte(-1.0F);
                     } else {
                        var3.setDocQte(1.0F);
                     }
                  } else {
                     var3.setDocQte(0.0F);
                  }

                  var3.setDocTotHt(0.0D);
                  var3.setDocTotReglement(this.reglements.getRglRecette());
                  var3.setDocService(this.reglements.getRglService());
                  if (this.reglements.getRglRecette() < 0.0D && (this.reglements.getRglService() == null || this.reglements.getRglService().isEmpty())) {
                     var3.setDocService("ANNULATION");
                  } else if (this.reglements.getRglRecette() > 0.0D && (this.reglements.getRglService() == null || this.reglements.getRglService().isEmpty())) {
                     var3.setDocService("SERVICE NON RENSEIGNE");
                  }

                  var2.add(var3);
               }
            } else if (this.reglements.getRglNatureDoc() == 76) {
               double var28 = this.reglements.getRglRecette();
               double var30 = 0.0D;
               List var14 = var16.selectReglementByIdRecu(this.reglements.getRglId(), this.reglements.getRglIdDocument(), var17);
               if (var14.size() != 0) {
                  for(int var32 = 0; var32 < var14.size(); ++var32) {
                     HospitalisationReglement var15 = (HospitalisationReglement)var14.get(var32);
                     boolean var33 = false;
                     if (var15.getHosregCaisse().equals(this.caissesJour.getCaijouCode()) && var15.getHosregDate().compareTo(this.caissesJour.getCaijouDate()) == 0) {
                        if (var15.getHosregIdRecu() == this.reglements.getRglId()) {
                           var33 = true;
                           var30 += var15.getHosregPatient();
                        }

                        if (var33 && var15.getHosregIdCaution() != 0L) {
                           var3 = new DocumentEntete();
                           var3.setDocCodeCaiss(this.caissesJour.getCaijouCode());
                           var3.setDocIdResponsable(var15.getHospitalisationEntete().getHosIdPatient());
                           var3.setDocService(var15.getHosregService());
                           var3.setDocNomEquipe("");
                           var3.setDocAnal2("CAUTION");
                           var3.setDocAnal4("Versement caution");
                           var3.setDocNum(var15.getHospitalisationEntete().getHosNum());
                           var3.setDocQte(1.0F);
                           var3.setDocTotHt(0.0D);
                           var3.setDocTotReglement(var15.getHosregPatient());
                           var2.add(var3);
                           var18.add(var15);
                        } else if (var33 && var15.getHosregIdCaution() == 0L && var15.getHosregLaboratoire() != null && !var15.getHosregLaboratoire().isEmpty() && var15.getHosregLaboratoire().equals("RMB CAUTION")) {
                           var3 = new DocumentEntete();
                           var3.setDocCodeCaiss(this.caissesJour.getCaijouCode());
                           var3.setDocIdResponsable(var15.getHospitalisationEntete().getHosIdPatient());
                           var3.setDocService(var15.getHosregService());
                           var3.setDocNomEquipe("");
                           var3.setDocAnal2("RMB CAUTION");
                           var3.setDocAnal4("Remboursement caution");
                           var3.setDocNum(var15.getHospitalisationEntete().getHosNum());
                           var3.setDocQte(1.0F);
                           var3.setDocTotHt(0.0D);
                           var3.setDocTotReglement(var15.getHosregPatient());
                           var2.add(var3);
                           var18.add(var15);
                        } else if (var33) {
                           var3 = new DocumentEntete();
                           var3.setDocCodeCaiss(this.caissesJour.getCaijouCode());
                           var3.setDocIdResponsable(var15.getHospitalisationEntete().getHosIdPatient());
                           var3.setDocService(var15.getHosregService());
                           var3.setDocNomEquipe("");
                           var3.setDocAnal2("N° " + var15.getHospitalisationEntete().getHosNum());
                           var3.setDocAnal4("Hospilisation");
                           var3.setDocNum(var15.getHospitalisationEntete().getHosNum());
                           var3.setDocQte(1.0F);
                           var3.setDocTotHt(0.0D);
                           if (var30 <= var28) {
                              var3.setDocTotReglement(var15.getHosregPatient());
                           } else {
                              var3.setDocTotReglement(var30 - var28);
                           }

                           var2.add(var3);
                           var18.add(var15);
                        }
                     }
                  }
               }
            }
         }
      }

      new ArrayList();
      HospitalisationSejourDao var37 = new HospitalisationSejourDao(this.baseLog, this.utilInitHibernate);
      String var39 = this.utilDate.dateToStringSQLLight(this.caissesJour.getCaijouDate());
      List var34 = var37.chargerLesMvtsJour(var39, var17);
      if (var34.size() != 0) {
      }

      this.utilInitHibernate.closeSession();
      var1 = new JRBeanCollectionDataSource(var2);
      return var1;
   }

   public JRBeanCollectionDataSource calculeImpressionBordereauVersementMensuel() throws IOException, HibernateException, NamingException {
      JRBeanCollectionDataSource var1 = null;
      ArrayList var2 = new ArrayList();
      new DocumentEntete();
      new ConsultationEnteteGene();
      ConsultationEnteteGeneDao var5 = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ConsultationReglement();
      ConsultationReglementDao var8 = new ConsultationReglementDao(this.baseLog, this.utilInitHibernate);
      new PharmacieEntete();
      PharmacieEnteteDao var10 = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new PharmacieReglement();
      PharmacieReglementDao var13 = new PharmacieReglementDao(this.baseLog, this.utilInitHibernate);
      new LaboratoireEntete();
      LaboratoireEnteteDao var15 = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new LaboratoireReglement();
      LaboratoireReglementDao var18 = new LaboratoireReglementDao(this.baseLog, this.utilInitHibernate);
      new HospitalisationEntete();
      HospitalisationEnteteDao var20 = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new HospitalisationReglement();
      HospitalisationReglementDao var23 = new HospitalisationReglementDao(this.baseLog, this.utilInitHibernate);
      if (this.lesReglements.size() != 0) {
         Session var24 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");

         for(int var25 = 0; var25 < this.lesReglements.size(); ++var25) {
            this.reglements = (Reglements)this.lesReglements.get(var25);
            DocumentEntete var3;
            int var26;
            byte var27;
            boolean var28;
            int var29;
            if (this.reglements.getRglNatureDoc() == 71) {
               ConsultationEnteteGene var4 = var5.selectById(this.reglements.getRglIdDocument(), var24);
               if (var4 != null) {
                  List var6 = var8.selectReglementByEnt(var4, var24);
                  if (var6.size() != 0) {
                     for(var26 = 0; var26 < var6.size(); ++var26) {
                        ConsultationReglement var7 = (ConsultationReglement)var6.get(var26);
                        var27 = 0;
                        if (var7.getCsgregCaisse().equals(this.caissesJour.getCaijouCode()) && var7.getCsgregDate().equals(this.caissesJour.getCaijouDate())) {
                           if (this.reglements.getRglService() != null && !this.reglements.getRglService().isEmpty() && var7.getCsgregService() != null && !var7.getCsgregService().isEmpty() && var7.getCsgregService().equals(this.reglements.getRglService())) {
                              var27 = 1;
                           } else if (this.reglements.getRglService() != null && !this.reglements.getRglService().isEmpty() && (var7.getCsgregService() == null || var7.getCsgregService().isEmpty()) && var7.getCsgregPatient() < 0.0D) {
                              var27 = 2;
                           }

                           if (var27 != 0) {
                              var3 = new DocumentEntete();
                              var3.setDocCodeCaiss(this.caissesJour.getCaijouCode());
                              var3.setDocIdResponsable(var7.getConsultationEnteteGene().getCsgIdPatient());
                              var3.setDocAnal2(var7.getCsgregProduit());
                              var3.setDocAnal4(var7.getCsgregLibelle());
                              var3.setDocNum(var7.getConsultationEnteteGene().getCsgNum());
                              var28 = false;
                              if (var2.size() != 0) {
                                 for(var29 = 0; var29 < var2.size(); ++var29) {
                                    if (((DocumentEntete)var2.get(var29)).getDocNum().equals(var7.getConsultationEnteteGene().getCsgNum()) && ((DocumentEntete)var2.get(var29)).getDocAnal2().equals(var7.getCsgregProduit()) && ((DocumentEntete)var2.get(var29)).getDocService().equals(var7.getCsgregService())) {
                                       var28 = true;
                                       break;
                                    }
                                 }
                              }

                              if (!var28) {
                                 var3.setDocQte(1.0F);
                              } else {
                                 var3.setDocQte(0.0F);
                              }

                              var3.setDocTotHt(var7.getCsgregPatient());
                              var3.setDocTotReglement(var7.getCsgregPatient());
                              var3.setDocService(var7.getCsgregService());
                              if (var27 == 2 && (var3.getDocService() == null || var3.getDocService().isEmpty())) {
                                 var3.setDocService("ANNULATION");
                              }

                              var2.add(var3);
                           }
                        }
                     }
                  }
               }
            }

            if (this.reglements.getRglNatureDoc() == 73) {
               PharmacieEntete var9 = var10.selectById(this.reglements.getRglIdDocument(), var24);
               if (var9 != null) {
                  List var11 = var13.selectReglementByEnt(var9, var24);
                  if (var11.size() != 0) {
                     for(var26 = 0; var26 < var11.size(); ++var26) {
                        PharmacieReglement var12 = (PharmacieReglement)var11.get(var26);
                        var27 = 0;
                        if (var12.getPharegCaisse().equals(this.caissesJour.getCaijouCode()) && var12.getPharegDate().equals(this.caissesJour.getCaijouDate())) {
                           if (this.reglements.getRglService() != null && !this.reglements.getRglService().isEmpty() && var12.getPharegService() != null && !var12.getPharegService().isEmpty() && var12.getPharegService().equals(this.reglements.getRglService())) {
                              var27 = 1;
                           } else if (this.reglements.getRglService() != null && !this.reglements.getRglService().isEmpty() && (var12.getPharegService() == null || var12.getPharegService().isEmpty()) && var12.getPharegPatient() < 0.0D) {
                              var27 = 2;
                           }

                           if (var27 != 0) {
                              var3 = new DocumentEntete();
                              var3.setDocCodeCaiss(this.caissesJour.getCaijouCode());
                              var3.setDocIdResponsable(var12.getPharmacieEntete().getPhaIdPatient());
                              var3.setDocAnal2(var12.getPharegProduit());
                              var3.setDocAnal4(var12.getPharegLibelle());
                              var3.setDocNum(var12.getPharmacieEntete().getPhaNum());
                              var28 = false;
                              if (var2.size() != 0) {
                                 for(var29 = 0; var29 < var2.size(); ++var29) {
                                    if (((DocumentEntete)var2.get(var29)).getDocNum().equals(var12.getPharmacieEntete().getPhaNum()) && ((DocumentEntete)var2.get(var29)).getDocAnal2().equals(var12.getPharegProduit()) && ((DocumentEntete)var2.get(var29)).getDocService().equals(var12.getPharegService())) {
                                       var28 = true;
                                       break;
                                    }
                                 }
                              }

                              if (!var28) {
                                 var3.setDocQte(1.0F);
                              } else {
                                 var3.setDocQte(0.0F);
                              }

                              var3.setDocTotHt(var12.getPharegPatient());
                              var3.setDocTotReglement(var12.getPharegPatient());
                              var3.setDocService(var12.getPharegService());
                              if (var27 == 2 && (var3.getDocService() == null || var3.getDocService().isEmpty())) {
                                 var3.setDocService("ANNULATION");
                              }

                              var2.add(var3);
                           }
                        }
                     }
                  }
               }
            }

            if (this.reglements.getRglNatureDoc() == 74) {
               LaboratoireEntete var14 = var15.selectById(this.reglements.getRglIdDocument(), var24);
               if (var14 != null) {
                  List var16 = var18.selectReglementByEnt(var14, var24);
                  if (var16.size() != 0) {
                     for(var26 = 0; var26 < var16.size(); ++var26) {
                        LaboratoireReglement var17 = (LaboratoireReglement)var16.get(var26);
                        var27 = 0;
                        if (var17.getLabregCaisse().equals(this.caissesJour.getCaijouCode()) && var17.getLabregDate().compareTo(this.caissesJour.getCaijouDate()) == 0) {
                           if (this.reglements.getRglPdv() != null && !this.reglements.getRglPdv().isEmpty() && var17.getLabregLaboratoire() != null && !var17.getLabregLaboratoire().isEmpty() && var17.getLabregLaboratoire().equals(this.reglements.getRglPdv())) {
                              var27 = 1;
                           } else if (this.reglements.getRglPdv() != null && !this.reglements.getRglPdv().isEmpty() && (var17.getLabregLaboratoire() == null || var17.getLabregLaboratoire().isEmpty()) && var17.getLabregPatient() < 0.0D) {
                              var27 = 2;
                           }

                           if (var27 != 0) {
                              var3 = new DocumentEntete();
                              var3.setDocCodeCaiss(this.caissesJour.getCaijouCode());
                              var3.setDocIdResponsable(var17.getLaboratoireEntete().getLabIdPatient());
                              var3.setDocAnal2(var17.getLabregProduit());
                              var3.setDocAnal4(var17.getLabregLibelle());
                              var3.setDocNum(var17.getLaboratoireEntete().getLabNum());
                              var28 = false;
                              if (var2.size() != 0) {
                                 for(var29 = 0; var29 < var2.size(); ++var29) {
                                    if (((DocumentEntete)var2.get(var29)).getDocNum().equals(var17.getLaboratoireEntete().getLabNum()) && ((DocumentEntete)var2.get(var29)).getDocAnal2().equals(var17.getLabregProduit()) && ((DocumentEntete)var2.get(var29)).getDocService().equals(var17.getLabregService())) {
                                       var28 = true;
                                       break;
                                    }
                                 }
                              }

                              if (!var28) {
                                 var3.setDocQte(1.0F);
                              } else {
                                 var3.setDocQte(0.0F);
                              }

                              var3.setDocTotHt(var17.getLabregPatient());
                              var3.setDocTotReglement(var17.getLabregPatient());
                              if (var17.getLabregLaboratoire() != null && !var17.getLabregLaboratoire().isEmpty()) {
                                 var3.setDocNomEquipe(var17.getLabregLaboratoire());
                                 var3.setDocService(var3.getDocNomEquipe());
                              } else if (var14.getLabLaboratoire() != null && !var14.getLabLaboratoire().isEmpty()) {
                                 var3.setDocNomEquipe(var14.getLabLaboratoire());
                                 var3.setDocService(var3.getDocNomEquipe());
                              } else {
                                 var3.setDocNomEquipe(var14.getLabService());
                                 var3.setDocService(var3.getDocNomEquipe());
                              }

                              if (var27 == 2 && (var3.getDocService() == null || var3.getDocService().isEmpty())) {
                                 var3.setDocService("ANNULATION");
                              }

                              var2.add(var3);
                           }
                        }
                     }
                  }
               }
            }

            if (this.reglements.getRglNatureDoc() == 76) {
               HospitalisationEntete var19 = var20.selectById(this.reglements.getRglIdDocument(), var24);
               if (var19 != null) {
                  List var21 = var23.selectReglementByEnt(var19, var24);
                  if (var21.size() != 0) {
                     for(var26 = 0; var26 < var21.size(); ++var26) {
                        HospitalisationReglement var22 = (HospitalisationReglement)var21.get(var26);
                        var27 = 0;
                        if (var22.getHosregCaisse().equals(this.caissesJour.getCaijouCode()) && var22.getHosregDate().getMonth() == this.caissesJour.getCaijouDate().getMonth() && var22.getHosregDate().getYear() == this.caissesJour.getCaijouDate().getYear()) {
                           if (var22.getHosregNumRecu() != null && !var22.getHosregNumRecu().isEmpty() && var22.getHosregNumRecu().equals(this.reglements.getRglNum())) {
                              var27 = 1;
                           }

                           if (var27 != 0) {
                              var3 = new DocumentEntete();
                              var3.setDocCodeCaiss(this.caissesJour.getCaijouCode());
                              var3.setDocIdResponsable(var22.getHospitalisationEntete().getHosIdPatient());
                              var3.setDocNum(var22.getHospitalisationEntete().getHosNum());
                              var28 = false;
                              if (var2.size() != 0) {
                                 for(var29 = 0; var29 < var2.size(); ++var29) {
                                    if (((DocumentEntete)var2.get(var29)).getDocIdResponsable() == var22.getHospitalisationEntete().getHosIdPatient()) {
                                       var28 = true;
                                       break;
                                    }
                                 }
                              }

                              if (!var28) {
                                 var3.setDocQte(1.0F);
                              } else {
                                 var3.setDocQte(0.0F);
                              }

                              var3.setDocTotHt(var22.getHosregPatient());
                              var3.setDocTotReglement(var22.getHosregPatient());
                              if (var22.getHosregLaboratoire() != null && !var22.getHosregLaboratoire().isEmpty()) {
                                 var3.setDocService(var22.getHosregService());
                                 var3.setDocNomEquipe(var22.getHosregLaboratoire());
                              } else {
                                 var3.setDocService(var22.getHosregService());
                                 var3.setDocNomEquipe(var22.getHosregLaboratoire());
                              }

                              if (var27 == 2 && (var3.getDocService() == null || var3.getDocService().isEmpty())) {
                                 var3.setDocService("ANNULATION");
                              }

                              var2.add(var3);
                           }
                        }
                     }
                  }
               }
            }
         }

         this.utilInitHibernate.closeSession();
      }

      var1 = new JRBeanCollectionDataSource(var2);
      return var1;
   }

   public JRBeanCollectionDataSource controleReglementJournalier() throws IOException, HibernateException, NamingException {
      JRBeanCollectionDataSource var1 = null;
      ArrayList var2 = new ArrayList();
      new DocumentEntete();
      new ArrayList();
      ConsultationReglementDao var5 = new ConsultationReglementDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      PharmacieReglementDao var7 = new PharmacieReglementDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      LaboratoireReglementDao var9 = new LaboratoireReglementDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      HospitalisationReglementDao var11 = new HospitalisationReglementDao(this.baseLog, this.utilInitHibernate);
      Session var12 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
      if (this.lesReglements.size() != 0) {
         for(int var13 = 0; var13 < this.lesReglements.size(); ++var13) {
            this.reglements = (Reglements)this.lesReglements.get(var13);
            DocumentEntete var3;
            int var14;
            if (this.reglements.getRglNatureDoc() == 71) {
               List var4 = var5.selectReglementByIdRecu(this.reglements.getRglId(), var12);
               if (var4.size() != 0) {
                  for(var14 = 0; var14 < var4.size(); ++var14) {
                     var3 = new DocumentEntete();
                     var3.setDocIdCommercial(this.reglements.getRglId());
                     var3.setDocTotHt(this.reglements.getRglRecette());
                     var3.setDocNumBon(this.reglements.getRglNum());
                     var3.setDocNumDocument(this.reglements.getRglDocument());
                     var3.setDocNomCommercial(this.reglements.getRglNomTiers());
                     var3.setDocCaiss(this.reglements.getRglCodeCaiss());
                     var3.setDocNomEquipe("Consultation");
                     var3.setDocId(((ConsultationReglement)var4.get(var14)).getCsgregId());
                     var3.setDocDate(((ConsultationReglement)var4.get(var14)).getCsgregDate());
                     var3.setDocTotReglement(((ConsultationReglement)var4.get(var14)).getCsgregPatient());
                     var3.setDocService(((ConsultationReglement)var4.get(var14)).getCsgregService());
                     var3.setDocObject(((ConsultationReglement)var4.get(var14)).getCsgregProduit());
                     var3.setDocLibelle(((ConsultationReglement)var4.get(var14)).getCsgregLibelle());
                     var3.setDocNomTiers(((ConsultationReglement)var4.get(var14)).getCsgregNumPieceTiers());
                     var2.add(var3);
                  }
               } else {
                  var3 = new DocumentEntete();
                  var3.setDocIdCommercial(this.reglements.getRglId());
                  var3.setDocTotHt(this.reglements.getRglRecette());
                  var3.setDocNumBon(this.reglements.getRglNum());
                  var3.setDocNumDocument(this.reglements.getRglDocument());
                  var3.setDocNomCommercial(this.reglements.getRglNomTiers());
                  var3.setDocCaiss(this.reglements.getRglCodeCaiss());
                  var3.setDocNomEquipe("Consultation");
                  var3.setDocId(0L);
                  var3.setDocDate((Date)null);
                  var3.setDocTotReglement(0.0D);
                  var3.setDocService("");
                  var3.setDocObject("");
                  var3.setDocLibelle("");
                  var3.setDocNomTiers("");
                  var2.add(var3);
               }
            } else if (this.reglements.getRglNatureDoc() == 73) {
               List var6 = var7.selectReglementByIdRecu(this.reglements.getRglId(), var12);
               if (var6.size() != 0) {
                  for(var14 = 0; var14 < var6.size(); ++var14) {
                     var3 = new DocumentEntete();
                     var3.setDocIdCommercial(this.reglements.getRglId());
                     var3.setDocTotHt(this.reglements.getRglRecette());
                     var3.setDocNumBon(this.reglements.getRglNum());
                     var3.setDocNumDocument(this.reglements.getRglDocument());
                     var3.setDocNomCommercial(this.reglements.getRglNomTiers());
                     var3.setDocCaiss(this.reglements.getRglCodeCaiss());
                     var3.setDocNomEquipe("Pharmacie");
                     var3.setDocId(((PharmacieReglement)var6.get(var14)).getPharegId());
                     var3.setDocDate(((PharmacieReglement)var6.get(var14)).getPharegDate());
                     var3.setDocTotReglement(((PharmacieReglement)var6.get(var14)).getPharegPatient());
                     var3.setDocService(((PharmacieReglement)var6.get(var14)).getPharegService());
                     var3.setDocObject(((PharmacieReglement)var6.get(var14)).getPharegProduit());
                     var3.setDocLibelle(((PharmacieReglement)var6.get(var14)).getPharegLibelle());
                     var3.setDocNomTiers(((PharmacieReglement)var6.get(var14)).getPharegNumPieceTiers());
                     var2.add(var3);
                  }
               } else {
                  var3 = new DocumentEntete();
                  var3.setDocIdCommercial(this.reglements.getRglId());
                  var3.setDocTotHt(this.reglements.getRglRecette());
                  var3.setDocNumBon(this.reglements.getRglNum());
                  var3.setDocNumDocument(this.reglements.getRglDocument());
                  var3.setDocNomCommercial(this.reglements.getRglNomTiers());
                  var3.setDocCaiss(this.reglements.getRglCodeCaiss());
                  var3.setDocNomEquipe("Pharmacie");
                  var3.setDocId(0L);
                  var3.setDocDate((Date)null);
                  var3.setDocTotReglement(0.0D);
                  var3.setDocService("");
                  var3.setDocObject("");
                  var3.setDocLibelle("");
                  var3.setDocNomTiers("");
                  var2.add(var3);
               }
            } else if (this.reglements.getRglNatureDoc() == 74) {
               List var8 = var9.selectReglementByIdRecu(this.reglements.getRglId(), var12);
               if (var8.size() != 0) {
                  for(var14 = 0; var14 < var8.size(); ++var14) {
                     var3 = new DocumentEntete();
                     var3.setDocIdCommercial(this.reglements.getRglId());
                     var3.setDocTotHt(this.reglements.getRglRecette());
                     var3.setDocNumBon(this.reglements.getRglNum());
                     var3.setDocNumDocument(this.reglements.getRglDocument());
                     var3.setDocNomCommercial(this.reglements.getRglNomTiers());
                     var3.setDocCaiss(this.reglements.getRglCodeCaiss());
                     var3.setDocNomEquipe("Laboratoire");
                     var3.setDocId(((LaboratoireReglement)var8.get(var14)).getLabregId());
                     var3.setDocDate(((LaboratoireReglement)var8.get(var14)).getLabregDate());
                     var3.setDocTotReglement(((LaboratoireReglement)var8.get(var14)).getLabregPatient());
                     var3.setDocService(((LaboratoireReglement)var8.get(var14)).getLabregService());
                     var3.setDocObject(((LaboratoireReglement)var8.get(var14)).getLabregProduit());
                     var3.setDocLibelle(((LaboratoireReglement)var8.get(var14)).getLabregLibelle());
                     var3.setDocNomTiers(((LaboratoireReglement)var8.get(var14)).getLabregNumPieceTiers());
                     var2.add(var3);
                  }
               } else {
                  var3 = new DocumentEntete();
                  var3.setDocIdCommercial(this.reglements.getRglId());
                  var3.setDocTotHt(this.reglements.getRglRecette());
                  var3.setDocNumBon(this.reglements.getRglNum());
                  var3.setDocNumDocument(this.reglements.getRglDocument());
                  var3.setDocNomCommercial(this.reglements.getRglNomTiers());
                  var3.setDocCaiss(this.reglements.getRglCodeCaiss());
                  var3.setDocNomEquipe("Laboratoire");
                  var3.setDocId(0L);
                  var3.setDocDate((Date)null);
                  var3.setDocTotReglement(0.0D);
                  var3.setDocService("");
                  var3.setDocObject("");
                  var3.setDocLibelle("");
                  var3.setDocNomTiers("");
                  var2.add(var3);
               }
            } else if (this.reglements.getRglNatureDoc() == 76) {
               List var10 = var11.selectReglementByIdRecu(this.reglements.getRglId(), this.reglements.getRglIdDocument(), var12);
               if (var10.size() != 0) {
                  for(var14 = 0; var14 < var10.size(); ++var14) {
                     var3 = new DocumentEntete();
                     var3.setDocIdCommercial(this.reglements.getRglId());
                     var3.setDocTotHt(this.reglements.getRglRecette());
                     var3.setDocNumBon(this.reglements.getRglNum());
                     var3.setDocNumDocument(this.reglements.getRglDocument());
                     var3.setDocNomCommercial(this.reglements.getRglNomTiers());
                     var3.setDocCaiss(this.reglements.getRglCodeCaiss());
                     var3.setDocNomEquipe("Hospitalisation");
                     var3.setDocId(((HospitalisationReglement)var10.get(var14)).getHosregId());
                     var3.setDocDate(((HospitalisationReglement)var10.get(var14)).getHosregDate());
                     var3.setDocTotReglement(((HospitalisationReglement)var10.get(var14)).getHosregPatient());
                     var3.setDocService(((HospitalisationReglement)var10.get(var14)).getHosregService());
                     var3.setDocObject(((HospitalisationReglement)var10.get(var14)).getHosregLaboratoire());
                     var3.setDocLibelle("");
                     var3.setDocNomTiers(((HospitalisationReglement)var10.get(var14)).getHosregNumPieceTiers());
                     var2.add(var3);
                  }
               } else {
                  var3 = new DocumentEntete();
                  var3.setDocIdCommercial(this.reglements.getRglId());
                  var3.setDocTotHt(this.reglements.getRglRecette());
                  var3.setDocNumBon(this.reglements.getRglNum());
                  var3.setDocNumDocument(this.reglements.getRglDocument());
                  var3.setDocNomCommercial(this.reglements.getRglNomTiers());
                  var3.setDocCaiss(this.reglements.getRglCodeCaiss());
                  var3.setDocNomEquipe("Hospitalisation");
                  var3.setDocId(0L);
                  var3.setDocDate((Date)null);
                  var3.setDocTotReglement(0.0D);
                  var3.setDocService("");
                  var3.setDocObject("");
                  var3.setDocLibelle("");
                  var3.setDocNomTiers("");
                  var2.add(var3);
               }
            }
         }
      }

      this.utilInitHibernate.closeSession();
      var1 = new JRBeanCollectionDataSource(var2);
      return var1;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      return var2;
   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         String var1;
         String var2;
         if (this.nomModeleListe.startsWith("BordereauVersement")) {
            this.utilPrint.setRapport(this.nomModeleListe);
            this.utilPrint.setEntete("Impression de la caisse " + this.caissesCommerciales.getCaiCode() + " " + this.caissesCommerciales.getCaiNom());
            var1 = "";
            if (this.modeJournal == 0) {
               var2 = this.utilDate.dateToStringFr(this.caissesJour.getCaijouDate());
               this.utilPrint.setFiltre("Du " + var2 + " mode : " + var1);
            } else {
               this.utilPrint.setFiltre("Période " + this.caissesMois.getCaimenPeriode() + " mode : " + var1);
            }

            this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setIdResponsable(0L);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setNature(this.nature);
            this.utilPrint.setId_doc(0L);
            if (this.modeJournal == 0) {
               this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionBordereauVersementJournalier());
            } else {
               this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionBordereauVersementMensuel());
            }

            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         } else if (this.nomModeleListe.equals("ControleReglementHopital")) {
            this.utilPrint.setRapport(this.nomModeleListe);
            this.utilPrint.setEntete("Controle réglements " + this.caissesCommerciales.getCaiCode() + " " + this.caissesCommerciales.getCaiNom());
            var1 = "";
            if (this.modeJournal == 0) {
               var2 = this.utilDate.dateToStringFr(this.caissesJour.getCaijouDate());
               this.utilPrint.setFiltre("Du " + var2 + " mode : " + var1);
            } else {
               this.utilPrint.setFiltre("Période " + this.caissesMois.getCaimenPeriode() + " mode : " + var1);
            }

            this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setIdResponsable(0L);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setNature(this.nature);
            this.utilPrint.setId_doc(0L);
            if (this.modeJournal == 0) {
               this.utilPrint.setjRBeanCollectionDataSource(this.controleReglementJournalier());
            }

            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         } else {
            this.utilPrint.setRapport(this.nomModeleListe);
            this.utilPrint.setEntete("Impression de la caisse " + this.caissesCommerciales.getCaiCode() + " " + this.caissesCommerciales.getCaiNom());
            var1 = "";
            if (this.var_type_onglet == 99) {
               var1 = "Tous les modes";
            } else if (this.var_type_onglet == 90) {
               var1 = "Bons de caisse";
            } else if (this.var_type_onglet == 91) {
               var1 = "Ecart cloture";
            } else if (this.var_type_onglet == 92) {
               var1 = "Erreur";
            } else if (this.var_type_onglet != 0 && this.var_type_onglet != 11) {
               if (this.var_type_onglet == 1) {
                  var1 = "Chèques";
               } else if (this.var_type_onglet == 2) {
                  var1 = "Virements";
               } else if (this.var_type_onglet == 3) {
                  var1 = "Traites";
               } else if (this.var_type_onglet == 4) {
                  var1 = "TPE";
               } else if (this.var_type_onglet == 5) {
                  var1 = "Transfert";
               } else if (this.var_type_onglet == 6) {
                  var1 = "ePaiement";
               } else if (this.var_type_onglet == 7) {
                  var1 = "CREDOC";
               } else if (this.var_type_onglet == 8) {
                  var1 = "FACTOR";
               } else if (this.var_type_onglet == 9) {
                  var1 = "Compense";
               } else if (this.var_type_onglet == 10) {
                  var1 = "Terme";
               } else if (this.var_type_onglet == 12) {
                  var1 = "Prélévement";
               } else if (this.var_type_onglet == 13) {
                  var1 = "Lettre Garantie";
               } else if (this.var_type_onglet == 14) {
                  var1 = "ALCOIN";
               } else {
                  var1 = "";
               }
            } else {
               var1 = "Espèces";
            }

            if (this.modeJournal == 0) {
               var2 = this.utilDate.dateToStringFr(this.caissesJour.getCaijouDate());
               this.utilPrint.setFiltre("Du " + var2 + " mode : " + var1);
            } else {
               this.utilPrint.setFiltre("Période " + this.caissesMois.getCaimenPeriode() + " mode : " + var1);
            }

            this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setIdResponsable(0L);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setNature(this.nature);
            this.utilPrint.setId_doc(0L);
            if (this.modeJournal == 0) {
               this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommunJournalier());
            } else {
               this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommunMensuel());
            }

            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      }

   }

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public String getVar_caisse() {
      return this.var_caisse;
   }

   public void setVar_caisse(String var1) {
      this.var_caisse = var1;
   }

   public ExercicesCaisse getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesCaisse var1) {
      this.lastExo = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public String getNomModeleDocument() {
      return this.nomModeleDocument;
   }

   public void setNomModeleDocument(String var1) {
      this.nomModeleDocument = var1;
   }

   public String getNomModeleListe() {
      return this.nomModeleListe;
   }

   public void setNomModeleListe(String var1) {
      this.nomModeleListe = var1;
   }

   public String getNomRepMod() {
      return this.nomRepMod;
   }

   public void setNomRepMod(String var1) {
      this.nomRepMod = var1;
   }

   public ExercicesCaisse getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesCaisse var1) {
      this.selectedExo = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isVar_acc_descriptif() {
      return this.var_acc_descriptif;
   }

   public void setVar_acc_descriptif(boolean var1) {
      this.var_acc_descriptif = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVar_ajt() {
      return this.var_ajt;
   }

   public void setVar_ajt(boolean var1) {
      this.var_ajt = var1;
   }

   public boolean isVar_imp() {
      return this.var_imp;
   }

   public void setVar_imp(boolean var1) {
      this.var_imp = var1;
   }

   public boolean isVar_mod() {
      return this.var_mod;
   }

   public void setVar_mod(boolean var1) {
      this.var_mod = var1;
   }

   public boolean isVar_sup() {
      return this.var_sup;
   }

   public void setVar_sup(boolean var1) {
      this.var_sup = var1;
   }

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
   }

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
   }

   public DataModel getDatamodelElement() {
      return this.datamodelElement;
   }

   public void setDatamodelElement(DataModel var1) {
      this.datamodelElement = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public OptionCaisses getOptionCaisses() {
      return this.optionCaisses;
   }

   public void setOptionCaisses(OptionCaisses var1) {
      this.optionCaisses = var1;
   }

   public Reglements getReglements() {
      return this.reglements;
   }

   public void setReglements(Reglements var1) {
      this.reglements = var1;
   }

   public String getImpDestinataire() {
      return this.impDestinataire;
   }

   public void setImpDestinataire(String var1) {
      this.impDestinataire = var1;
   }

   public String getImpEmetteur() {
      return this.impEmetteur;
   }

   public void setImpEmetteur(String var1) {
      this.impEmetteur = var1;
   }

   public boolean isVar_verrou_caisse() {
      return this.var_verrou_caisse;
   }

   public void setVar_verrou_caisse(boolean var1) {
      this.var_verrou_caisse = var1;
   }

   public boolean isVar_affiche_depot() {
      return this.var_affiche_depot;
   }

   public void setVar_affiche_depot(boolean var1) {
      this.var_affiche_depot = var1;
   }

   public String getInputBanqEmetteur() {
      return this.inputBanqEmetteur;
   }

   public void setInputBanqEmetteur(String var1) {
      this.inputBanqEmetteur = var1;
   }

   public String getInputBanqRecepteur() {
      return this.inputBanqRecepteur;
   }

   public void setInputBanqRecepteur(String var1) {
      this.inputBanqRecepteur = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public String getVar_modele() {
      return this.var_modele;
   }

   public void setVar_modele(String var1) {
      this.var_modele = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
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

   public String getVar_banque() {
      return this.var_banque;
   }

   public void setVar_banque(String var1) {
      this.var_banque = var1;
   }

   public boolean isVar_depot() {
      return this.var_depot;
   }

   public void setVar_depot(boolean var1) {
      this.var_depot = var1;
   }

   public List getLesPeriodes() {
      return this.lesPeriodes;
   }

   public void setLesPeriodes(List var1) {
      this.lesPeriodes = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public String getImpDestinataireCC() {
      return this.impDestinataireCC;
   }

   public void setImpDestinataireCC(String var1) {
      this.impDestinataireCC = var1;
   }

   public String getImpDestinataireCCI() {
      return this.impDestinataireCCI;
   }

   public void setImpDestinataireCCI(String var1) {
      this.impDestinataireCCI = var1;
   }

   public boolean isAfficheTJM() {
      return this.afficheTJM;
   }

   public void setAfficheTJM(boolean var1) {
      this.afficheTJM = var1;
   }

   public DataModel getDataModelMois() {
      return this.dataModelMois;
   }

   public void setDataModelMois(DataModel var1) {
      this.dataModelMois = var1;
   }

   public DataModel getDatamodelJournaux() {
      return this.datamodelJournaux;
   }

   public void setDatamodelJournaux(DataModel var1) {
      this.datamodelJournaux = var1;
   }

   public boolean isSansChrono() {
      return this.sansChrono;
   }

   public void setSansChrono(boolean var1) {
      this.sansChrono = var1;
   }

   public double getCreditAnterieur() {
      return this.creditAnterieur;
   }

   public void setCreditAnterieur(double var1) {
      this.creditAnterieur = var1;
   }

   public double getDebitAnterieur() {
      return this.debitAnterieur;
   }

   public void setDebitAnterieur(double var1) {
      this.debitAnterieur = var1;
   }

   public double getSoldefinalCred() {
      return this.soldefinalCred;
   }

   public void setSoldefinalCred(double var1) {
      this.soldefinalCred = var1;
   }

   public double getSoldefinalDeb() {
      return this.soldefinalDeb;
   }

   public void setSoldefinalDeb(double var1) {
      this.soldefinalDeb = var1;
   }

   public double getTotalMvtscredit() {
      return this.totalMvtscredit;
   }

   public void setTotalMvtscredit(double var1) {
      this.totalMvtscredit = var1;
   }

   public double getTotalMvtsdebit() {
      return this.totalMvtsdebit;
   }

   public void setTotalMvtsdebit(double var1) {
      this.totalMvtsdebit = var1;
   }

   public CaissesCommerciales getCaissesCommerciales() {
      return this.caissesCommerciales;
   }

   public void setCaissesCommerciales(CaissesCommerciales var1) {
      this.caissesCommerciales = var1;
   }

   public CaissesMois getCaissesMois() {
      return this.caissesMois;
   }

   public void setCaissesMois(CaissesMois var1) {
      this.caissesMois = var1;
   }

   public double getSoldeCred() {
      return this.soldeCred;
   }

   public void setSoldeCred(double var1) {
      this.soldeCred = var1;
   }

   public double getSoldeDeb() {
      return this.soldeDeb;
   }

   public void setSoldeDeb(double var1) {
      this.soldeDeb = var1;
   }

   public DataModel getDataModelCheque() {
      return this.dataModelCheque;
   }

   public void setDataModelCheque(DataModel var1) {
      this.dataModelCheque = var1;
   }

   public DataModel getDataModelCompense() {
      return this.dataModelCompense;
   }

   public void setDataModelCompense(DataModel var1) {
      this.dataModelCompense = var1;
   }

   public DataModel getDataModelCredoc() {
      return this.dataModelCredoc;
   }

   public void setDataModelCredoc(DataModel var1) {
      this.dataModelCredoc = var1;
   }

   public DataModel getDataModelEspece() {
      return this.dataModelEspece;
   }

   public void setDataModelEspece(DataModel var1) {
      this.dataModelEspece = var1;
   }

   public DataModel getDataModelFactor() {
      return this.dataModelFactor;
   }

   public void setDataModelFactor(DataModel var1) {
      this.dataModelFactor = var1;
   }

   public DataModel getDataModelTerme() {
      return this.dataModelTerme;
   }

   public void setDataModelTerme(DataModel var1) {
      this.dataModelTerme = var1;
   }

   public DataModel getDataModelTpe() {
      return this.dataModelTpe;
   }

   public void setDataModelTpe(DataModel var1) {
      this.dataModelTpe = var1;
   }

   public DataModel getDataModelTraite() {
      return this.dataModelTraite;
   }

   public void setDataModelTraite(DataModel var1) {
      this.dataModelTraite = var1;
   }

   public DataModel getDataModelTransfert() {
      return this.dataModelTransfert;
   }

   public void setDataModelTransfert(DataModel var1) {
      this.dataModelTransfert = var1;
   }

   public DataModel getDataModelVirement() {
      return this.dataModelVirement;
   }

   public void setDataModelVirement(DataModel var1) {
      this.dataModelVirement = var1;
   }

   public DataModel getDataModelePaiement() {
      return this.dataModelePaiement;
   }

   public void setDataModelePaiement(DataModel var1) {
      this.dataModelePaiement = var1;
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

   public double getDepensesCheque() {
      return this.depensesCheque;
   }

   public void setDepensesCheque(double var1) {
      this.depensesCheque = var1;
   }

   public double getDepensesCompense() {
      return this.depensesCompense;
   }

   public void setDepensesCompense(double var1) {
      this.depensesCompense = var1;
   }

   public double getDepensesCredoc() {
      return this.depensesCredoc;
   }

   public void setDepensesCredoc(double var1) {
      this.depensesCredoc = var1;
   }

   public double getDepensesEspece() {
      return this.depensesEspece;
   }

   public void setDepensesEspece(double var1) {
      this.depensesEspece = var1;
   }

   public double getDepensesFactor() {
      return this.depensesFactor;
   }

   public void setDepensesFactor(double var1) {
      this.depensesFactor = var1;
   }

   public double getDepensesTerme() {
      return this.depensesTerme;
   }

   public void setDepensesTerme(double var1) {
      this.depensesTerme = var1;
   }

   public double getDepensesTpe() {
      return this.depensesTpe;
   }

   public void setDepensesTpe(double var1) {
      this.depensesTpe = var1;
   }

   public double getDepensesTraite() {
      return this.depensesTraite;
   }

   public void setDepensesTraite(double var1) {
      this.depensesTraite = var1;
   }

   public double getDepensesTransfert() {
      return this.depensesTransfert;
   }

   public void setDepensesTransfert(double var1) {
      this.depensesTransfert = var1;
   }

   public double getDepensesVirement() {
      return this.depensesVirement;
   }

   public void setDepensesVirement(double var1) {
      this.depensesVirement = var1;
   }

   public double getDepensesePaiement() {
      return this.depensesePaiement;
   }

   public void setDepensesePaiement(double var1) {
      this.depensesePaiement = var1;
   }

   public double getRecettesCheque() {
      return this.recettesCheque;
   }

   public void setRecettesCheque(double var1) {
      this.recettesCheque = var1;
   }

   public double getRecettesCompense() {
      return this.recettesCompense;
   }

   public void setRecettesCompense(double var1) {
      this.recettesCompense = var1;
   }

   public double getRecettesCredoc() {
      return this.recettesCredoc;
   }

   public void setRecettesCredoc(double var1) {
      this.recettesCredoc = var1;
   }

   public double getRecettesEspece() {
      return this.recettesEspece;
   }

   public void setRecettesEspece(double var1) {
      this.recettesEspece = var1;
   }

   public double getRecettesFactor() {
      return this.recettesFactor;
   }

   public void setRecettesFactor(double var1) {
      this.recettesFactor = var1;
   }

   public double getRecettesTerme() {
      return this.recettesTerme;
   }

   public void setRecettesTerme(double var1) {
      this.recettesTerme = var1;
   }

   public double getRecettesTpe() {
      return this.recettesTpe;
   }

   public void setRecettesTpe(double var1) {
      this.recettesTpe = var1;
   }

   public double getRecettesTraite() {
      return this.recettesTraite;
   }

   public void setRecettesTraite(double var1) {
      this.recettesTraite = var1;
   }

   public double getRecettesTransfert() {
      return this.recettesTransfert;
   }

   public void setRecettesTransfert(double var1) {
      this.recettesTransfert = var1;
   }

   public double getRecettesVirement() {
      return this.recettesVirement;
   }

   public void setRecettesVirement(double var1) {
      this.recettesVirement = var1;
   }

   public double getRecettesePaiement() {
      return this.recettesePaiement;
   }

   public void setRecettesePaiement(double var1) {
      this.recettesePaiement = var1;
   }

   public double getSoldeAnterieurCheque() {
      return this.soldeAnterieurCheque;
   }

   public void setSoldeAnterieurCheque(double var1) {
      this.soldeAnterieurCheque = var1;
   }

   public double getSoldeAnterieurCompense() {
      return this.soldeAnterieurCompense;
   }

   public void setSoldeAnterieurCompense(double var1) {
      this.soldeAnterieurCompense = var1;
   }

   public double getSoldeAnterieurCredoc() {
      return this.soldeAnterieurCredoc;
   }

   public void setSoldeAnterieurCredoc(double var1) {
      this.soldeAnterieurCredoc = var1;
   }

   public double getSoldeAnterieurEspece() {
      return this.soldeAnterieurEspece;
   }

   public void setSoldeAnterieurEspece(double var1) {
      this.soldeAnterieurEspece = var1;
   }

   public double getSoldeAnterieurFactor() {
      return this.soldeAnterieurFactor;
   }

   public void setSoldeAnterieurFactor(double var1) {
      this.soldeAnterieurFactor = var1;
   }

   public double getSoldeAnterieurTerme() {
      return this.soldeAnterieurTerme;
   }

   public void setSoldeAnterieurTerme(double var1) {
      this.soldeAnterieurTerme = var1;
   }

   public double getSoldeAnterieurTpe() {
      return this.soldeAnterieurTpe;
   }

   public void setSoldeAnterieurTpe(double var1) {
      this.soldeAnterieurTpe = var1;
   }

   public double getSoldeAnterieurTraite() {
      return this.soldeAnterieurTraite;
   }

   public void setSoldeAnterieurTraite(double var1) {
      this.soldeAnterieurTraite = var1;
   }

   public double getSoldeAnterieurTransfert() {
      return this.soldeAnterieurTransfert;
   }

   public void setSoldeAnterieurTransfert(double var1) {
      this.soldeAnterieurTransfert = var1;
   }

   public double getSoldeAnterieurVirement() {
      return this.soldeAnterieurVirement;
   }

   public void setSoldeAnterieurVirement(double var1) {
      this.soldeAnterieurVirement = var1;
   }

   public double getSoldeAnterieurePaiement() {
      return this.soldeAnterieurePaiement;
   }

   public void setSoldeAnterieurePaiement(double var1) {
      this.soldeAnterieurePaiement = var1;
   }

   public double getSoldeFinalCheque() {
      return this.soldeFinalCheque;
   }

   public void setSoldeFinalCheque(double var1) {
      this.soldeFinalCheque = var1;
   }

   public double getSoldeFinalCompense() {
      return this.soldeFinalCompense;
   }

   public void setSoldeFinalCompense(double var1) {
      this.soldeFinalCompense = var1;
   }

   public double getSoldeFinalCredoc() {
      return this.soldeFinalCredoc;
   }

   public void setSoldeFinalCredoc(double var1) {
      this.soldeFinalCredoc = var1;
   }

   public double getSoldeFinalEspece() {
      return this.soldeFinalEspece;
   }

   public void setSoldeFinalEspece(double var1) {
      this.soldeFinalEspece = var1;
   }

   public double getSoldeFinalFactor() {
      return this.soldeFinalFactor;
   }

   public void setSoldeFinalFactor(double var1) {
      this.soldeFinalFactor = var1;
   }

   public double getSoldeFinalTerme() {
      return this.soldeFinalTerme;
   }

   public void setSoldeFinalTerme(double var1) {
      this.soldeFinalTerme = var1;
   }

   public double getSoldeFinalTpe() {
      return this.soldeFinalTpe;
   }

   public void setSoldeFinalTpe(double var1) {
      this.soldeFinalTpe = var1;
   }

   public double getSoldeFinalTraite() {
      return this.soldeFinalTraite;
   }

   public void setSoldeFinalTraite(double var1) {
      this.soldeFinalTraite = var1;
   }

   public double getSoldeFinalTransfert() {
      return this.soldeFinalTransfert;
   }

   public void setSoldeFinalTransfert(double var1) {
      this.soldeFinalTransfert = var1;
   }

   public double getSoldeFinalVirement() {
      return this.soldeFinalVirement;
   }

   public void setSoldeFinalVirement(double var1) {
      this.soldeFinalVirement = var1;
   }

   public double getSoldeFinalePaiement() {
      return this.soldeFinalePaiement;
   }

   public void setSoldeFinalePaiement(double var1) {
      this.soldeFinalePaiement = var1;
   }

   public boolean isAfficheTJJ() {
      return this.afficheTJJ;
   }

   public void setAfficheTJJ(boolean var1) {
      this.afficheTJJ = var1;
   }

   public DataModel getDataModelJour() {
      return this.dataModelJour;
   }

   public void setDataModelJour(DataModel var1) {
      this.dataModelJour = var1;
   }

   public CaissesJour getCaissesJour() {
      return this.caissesJour;
   }

   public void setCaissesJour(CaissesJour var1) {
      this.caissesJour = var1;
   }

   public int getModeJournal() {
      return this.modeJournal;
   }

   public void setModeJournal(int var1) {
      this.modeJournal = var1;
   }

   public double getTot_b1() {
      return this.tot_b1;
   }

   public void setTot_b1(double var1) {
      this.tot_b1 = var1;
   }

   public double getTot_b10() {
      return this.tot_b10;
   }

   public void setTot_b10(double var1) {
      this.tot_b10 = var1;
   }

   public double getTot_b2() {
      return this.tot_b2;
   }

   public void setTot_b2(double var1) {
      this.tot_b2 = var1;
   }

   public double getTot_b3() {
      return this.tot_b3;
   }

   public void setTot_b3(double var1) {
      this.tot_b3 = var1;
   }

   public double getTot_b4() {
      return this.tot_b4;
   }

   public void setTot_b4(double var1) {
      this.tot_b4 = var1;
   }

   public double getTot_b5() {
      return this.tot_b5;
   }

   public void setTot_b5(double var1) {
      this.tot_b5 = var1;
   }

   public double getTot_b6() {
      return this.tot_b6;
   }

   public void setTot_b6(double var1) {
      this.tot_b6 = var1;
   }

   public double getTot_b7() {
      return this.tot_b7;
   }

   public void setTot_b7(double var1) {
      this.tot_b7 = var1;
   }

   public double getTot_b8() {
      return this.tot_b8;
   }

   public void setTot_b8(double var1) {
      this.tot_b8 = var1;
   }

   public double getTot_b9() {
      return this.tot_b9;
   }

   public void setTot_b9(double var1) {
      this.tot_b9 = var1;
   }

   public double getTot_p1() {
      return this.tot_p1;
   }

   public void setTot_p1(double var1) {
      this.tot_p1 = var1;
   }

   public double getTot_p10() {
      return this.tot_p10;
   }

   public void setTot_p10(double var1) {
      this.tot_p10 = var1;
   }

   public double getTot_p2() {
      return this.tot_p2;
   }

   public void setTot_p2(double var1) {
      this.tot_p2 = var1;
   }

   public double getTot_p3() {
      return this.tot_p3;
   }

   public void setTot_p3(double var1) {
      this.tot_p3 = var1;
   }

   public double getTot_p4() {
      return this.tot_p4;
   }

   public void setTot_p4(double var1) {
      this.tot_p4 = var1;
   }

   public double getTot_p5() {
      return this.tot_p5;
   }

   public void setTot_p5(double var1) {
      this.tot_p5 = var1;
   }

   public double getTot_p6() {
      return this.tot_p6;
   }

   public void setTot_p6(double var1) {
      this.tot_p6 = var1;
   }

   public double getTot_p7() {
      return this.tot_p7;
   }

   public void setTot_p7(double var1) {
      this.tot_p7 = var1;
   }

   public double getTot_p8() {
      return this.tot_p8;
   }

   public void setTot_p8(double var1) {
      this.tot_p8 = var1;
   }

   public double getTot_p9() {
      return this.tot_p9;
   }

   public void setTot_p9(double var1) {
      this.tot_p9 = var1;
   }

   public double getTotalBillet() {
      return this.totalBillet;
   }

   public void setTotalBillet(double var1) {
      this.totalBillet = var1;
   }

   public double getTotalCaisse() {
      return this.totalCaisse;
   }

   public void setTotalCaisse(double var1) {
      this.totalCaisse = var1;
   }

   public double getTotalPiece() {
      return this.totalPiece;
   }

   public void setTotalPiece(double var1) {
      this.totalPiece = var1;
   }

   public int getVal_b1() {
      return this.val_b1;
   }

   public void setVal_b1(int var1) {
      this.val_b1 = var1;
   }

   public int getVal_b10() {
      return this.val_b10;
   }

   public void setVal_b10(int var1) {
      this.val_b10 = var1;
   }

   public int getVal_b2() {
      return this.val_b2;
   }

   public void setVal_b2(int var1) {
      this.val_b2 = var1;
   }

   public int getVal_b3() {
      return this.val_b3;
   }

   public void setVal_b3(int var1) {
      this.val_b3 = var1;
   }

   public int getVal_b4() {
      return this.val_b4;
   }

   public void setVal_b4(int var1) {
      this.val_b4 = var1;
   }

   public int getVal_b5() {
      return this.val_b5;
   }

   public void setVal_b5(int var1) {
      this.val_b5 = var1;
   }

   public int getVal_b6() {
      return this.val_b6;
   }

   public void setVal_b6(int var1) {
      this.val_b6 = var1;
   }

   public int getVal_b7() {
      return this.val_b7;
   }

   public void setVal_b7(int var1) {
      this.val_b7 = var1;
   }

   public int getVal_b8() {
      return this.val_b8;
   }

   public void setVal_b8(int var1) {
      this.val_b8 = var1;
   }

   public int getVal_b9() {
      return this.val_b9;
   }

   public void setVal_b9(int var1) {
      this.val_b9 = var1;
   }

   public int getVal_p1() {
      return this.val_p1;
   }

   public void setVal_p1(int var1) {
      this.val_p1 = var1;
   }

   public int getVal_p10() {
      return this.val_p10;
   }

   public void setVal_p10(int var1) {
      this.val_p10 = var1;
   }

   public int getVal_p2() {
      return this.val_p2;
   }

   public void setVal_p2(int var1) {
      this.val_p2 = var1;
   }

   public int getVal_p3() {
      return this.val_p3;
   }

   public void setVal_p3(int var1) {
      this.val_p3 = var1;
   }

   public int getVal_p4() {
      return this.val_p4;
   }

   public void setVal_p4(int var1) {
      this.val_p4 = var1;
   }

   public int getVal_p5() {
      return this.val_p5;
   }

   public void setVal_p5(int var1) {
      this.val_p5 = var1;
   }

   public int getVal_p6() {
      return this.val_p6;
   }

   public void setVal_p6(int var1) {
      this.val_p6 = var1;
   }

   public int getVal_p7() {
      return this.val_p7;
   }

   public void setVal_p7(int var1) {
      this.val_p7 = var1;
   }

   public int getVal_p8() {
      return this.val_p8;
   }

   public void setVal_p8(int var1) {
      this.val_p8 = var1;
   }

   public int getVal_p9() {
      return this.val_p9;
   }

   public void setVal_p9(int var1) {
      this.val_p9 = var1;
   }

   public String getDevise1() {
      return this.devise1;
   }

   public void setDevise1(String var1) {
      this.devise1 = var1;
   }

   public String getDevise2() {
      return this.devise2;
   }

   public void setDevise2(String var1) {
      this.devise2 = var1;
   }

   public String getDevise3() {
      return this.devise3;
   }

   public void setDevise3(String var1) {
      this.devise3 = var1;
   }

   public String getDevise4() {
      return this.devise4;
   }

   public void setDevise4(String var1) {
      this.devise4 = var1;
   }

   public String getDevise5() {
      return this.devise5;
   }

   public void setDevise5(String var1) {
      this.devise5 = var1;
   }

   public boolean isShowModalPanelCloture() {
      return this.showModalPanelCloture;
   }

   public void setShowModalPanelCloture(boolean var1) {
      this.showModalPanelCloture = var1;
   }

   public double getEcart() {
      return this.ecart;
   }

   public void setEcart(double var1) {
      this.ecart = var1;
   }

   public DataModel getDataModelBonsCaisse() {
      return this.dataModelBonsCaisse;
   }

   public void setDataModelBonsCaisse(DataModel var1) {
      this.dataModelBonsCaisse = var1;
   }

   public double getSoldeCorrection() {
      return this.soldeCorrection;
   }

   public void setSoldeCorrection(double var1) {
      this.soldeCorrection = var1;
   }

   public Date getDateSoldeCaisse() {
      return this.dateSoldeCaisse;
   }

   public void setDateSoldeCaisse(Date var1) {
      this.dateSoldeCaisse = var1;
   }

   public DataModel getDataModelEcart() {
      return this.dataModelEcart;
   }

   public void setDataModelEcart(DataModel var1) {
      this.dataModelEcart = var1;
   }

   public DataModel getDataModelErreur() {
      return this.dataModelErreur;
   }

   public void setDataModelErreur(DataModel var1) {
      this.dataModelErreur = var1;
   }

   public boolean isShowModalpanelDetail() {
      return this.showModalpanelDetail;
   }

   public void setShowModalpanelDetail(boolean var1) {
      this.showModalpanelDetail = var1;
   }

   public String getVar_mode_reglement() {
      return this.var_mode_reglement;
   }

   public void setVar_mode_reglement(String var1) {
      this.var_mode_reglement = var1;
   }

   public List getMesModeReglements() {
      return this.mesModeReglements;
   }

   public void setMesModeReglements(List var1) {
      this.mesModeReglements = var1;
   }

   public int getVar_type_onglet() {
      return this.var_type_onglet;
   }

   public void setVar_type_onglet(int var1) {
      this.var_type_onglet = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isProjetActif() {
      return this.projetActif;
   }

   public void setProjetActif(boolean var1) {
      this.projetActif = var1;
   }

   public List getLesPostesBudgetaires() {
      return this.lesPostesBudgetaires;
   }

   public void setLesPostesBudgetaires(List var1) {
      this.lesPostesBudgetaires = var1;
   }

   public boolean isVar_afficheLettreGarante() {
      return this.var_afficheLettreGarante;
   }

   public void setVar_afficheLettreGarante(boolean var1) {
      this.var_afficheLettreGarante = var1;
   }

   public double getSoldeAnterieurBonCaisse() {
      return this.soldeAnterieurBonCaisse;
   }

   public void setSoldeAnterieurBonCaisse(double var1) {
      this.soldeAnterieurBonCaisse = var1;
   }

   public double getSoldeAnterieurLettreGarantie() {
      return this.soldeAnterieurLettreGarantie;
   }

   public void setSoldeAnterieurLettreGarantie(double var1) {
      this.soldeAnterieurLettreGarantie = var1;
   }

   public DataModel getDataModelLettreGarantie() {
      return this.dataModelLettreGarantie;
   }

   public void setDataModelLettreGarantie(DataModel var1) {
      this.dataModelLettreGarantie = var1;
   }

   public double getDepensesBonCaisse() {
      return this.depensesBonCaisse;
   }

   public void setDepensesBonCaisse(double var1) {
      this.depensesBonCaisse = var1;
   }

   public double getDepensesLettreGarantie() {
      return this.depensesLettreGarantie;
   }

   public void setDepensesLettreGarantie(double var1) {
      this.depensesLettreGarantie = var1;
   }

   public double getRecettesLettreGarantie() {
      return this.recettesLettreGarantie;
   }

   public void setRecettesLettreGarantie(double var1) {
      this.recettesLettreGarantie = var1;
   }

   public double getSoldeFinalBonCaisse() {
      return this.soldeFinalBonCaisse;
   }

   public void setSoldeFinalBonCaisse(double var1) {
      this.soldeFinalBonCaisse = var1;
   }

   public double getSoldeFinalLettreGarantie() {
      return this.soldeFinalLettreGarantie;
   }

   public void setSoldeFinalLettreGarantie(double var1) {
      this.soldeFinalLettreGarantie = var1;
   }

   public DataModel getDataModelAlcoin() {
      return this.dataModelAlcoin;
   }

   public void setDataModelAlcoin(DataModel var1) {
      this.dataModelAlcoin = var1;
   }

   public DataModel getDataModelPrelevement() {
      return this.dataModelPrelevement;
   }

   public void setDataModelPrelevement(DataModel var1) {
      this.dataModelPrelevement = var1;
   }

   public double getDepensesAlcoin() {
      return this.depensesAlcoin;
   }

   public void setDepensesAlcoin(double var1) {
      this.depensesAlcoin = var1;
   }

   public double getDepensesPrelevement() {
      return this.depensesPrelevement;
   }

   public void setDepensesPrelevement(double var1) {
      this.depensesPrelevement = var1;
   }

   public double getRecettesAlcoin() {
      return this.recettesAlcoin;
   }

   public void setRecettesAlcoin(double var1) {
      this.recettesAlcoin = var1;
   }

   public double getRecettesPrelevement() {
      return this.recettesPrelevement;
   }

   public void setRecettesPrelevement(double var1) {
      this.recettesPrelevement = var1;
   }

   public double getSoldeAnterieurAlcoin() {
      return this.soldeAnterieurAlcoin;
   }

   public void setSoldeAnterieurAlcoin(double var1) {
      this.soldeAnterieurAlcoin = var1;
   }

   public double getSoldeAnterieurPrelevement() {
      return this.soldeAnterieurPrelevement;
   }

   public void setSoldeAnterieurPrelevement(double var1) {
      this.soldeAnterieurPrelevement = var1;
   }

   public double getSoldeFinalAlcoin() {
      return this.soldeFinalAlcoin;
   }

   public void setSoldeFinalAlcoin(double var1) {
      this.soldeFinalAlcoin = var1;
   }

   public double getSoldeFinalPrelevement() {
      return this.soldeFinalPrelevement;
   }

   public void setSoldeFinalPrelevement(double var1) {
      this.soldeFinalPrelevement = var1;
   }

   public boolean isVar_afficheAlcoin() {
      return this.var_afficheAlcoin;
   }

   public void setVar_afficheAlcoin(boolean var1) {
      this.var_afficheAlcoin = var1;
   }

   public boolean isVar_affichePrelevement() {
      return this.var_affichePrelevement;
   }

   public void setVar_affichePrelevement(boolean var1) {
      this.var_affichePrelevement = var1;
   }

   public String getJourEnCours() {
      return this.jourEnCours;
   }

   public void setJourEnCours(String var1) {
      this.jourEnCours = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public UIDataTable getExtDTableJournaux() {
      return this.extDTableJournaux;
   }

   public void setExtDTableJournaux(UIDataTable var1) {
      this.extDTableJournaux = var1;
   }

   public SimpleSelection getSimpleSelectionJournaux() {
      return this.simpleSelectionJournaux;
   }

   public void setSimpleSelectionJournaux(SimpleSelection var1) {
      this.simpleSelectionJournaux = var1;
   }

   public UIDataTable getExtDTableMois() {
      return this.extDTableMois;
   }

   public void setExtDTableMois(UIDataTable var1) {
      this.extDTableMois = var1;
   }

   public SimpleSelection getSimpleSelectionMois() {
      return this.simpleSelectionMois;
   }

   public void setSimpleSelectionMois(SimpleSelection var1) {
      this.simpleSelectionMois = var1;
   }

   public UIDataTable getExtDTableJour() {
      return this.extDTableJour;
   }

   public void setExtDTableJour(UIDataTable var1) {
      this.extDTableJour = var1;
   }

   public SimpleSelection getSimpleSelectionJour() {
      return this.simpleSelectionJour;
   }

   public void setSimpleSelectionJour(SimpleSelection var1) {
      this.simpleSelectionJour = var1;
   }
}
