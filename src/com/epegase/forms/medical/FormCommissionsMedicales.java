package com.epegase.forms.medical;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.CommissionEnteteVentes;
import com.epegase.systeme.classe.CommissionLigneVentes;
import com.epegase.systeme.classe.ConsultationActes;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.ConsultationLabo;
import com.epegase.systeme.classe.ConsultationOrdo;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteMedical;
import com.epegase.systeme.classe.FactureLigneMedical;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.HospitalisationActes;
import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.HospitalisationLabo;
import com.epegase.systeme.classe.HospitalisationMedi;
import com.epegase.systeme.classe.HospitalisationPrest;
import com.epegase.systeme.classe.HospitalisationSejour;
import com.epegase.systeme.classe.LaboratoireEntete;
import com.epegase.systeme.classe.LaboratoireLigne;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.PharmacieLigne;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.RapportMedical;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.DocumentMedical;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.CommissionEnteteVentesDao;
import com.epegase.systeme.dao.CommissionLigneVentesDao;
import com.epegase.systeme.dao.ConsultationActesDao;
import com.epegase.systeme.dao.ConsultationEnteteGeneDao;
import com.epegase.systeme.dao.ConsultationLaboDao;
import com.epegase.systeme.dao.ConsultationOrdoDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.FactureEnteteMedicalDao;
import com.epegase.systeme.dao.FactureLigneMedicalDao;
import com.epegase.systeme.dao.HospitalisationActesDao;
import com.epegase.systeme.dao.HospitalisationEnteteDao;
import com.epegase.systeme.dao.HospitalisationLaboDao;
import com.epegase.systeme.dao.HospitalisationMediDao;
import com.epegase.systeme.dao.HospitalisationPrestDao;
import com.epegase.systeme.dao.HospitalisationSejourDao;
import com.epegase.systeme.dao.LaboratoireEnteteDao;
import com.epegase.systeme.dao.LaboratoireLigneDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.PharmacieEnteteDao;
import com.epegase.systeme.dao.PharmacieLigneDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.RapportMedicalDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionMedical;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

public class FormCommissionsMedicales implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private boolean infirmerie;
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private List mesOnglets;
   private OptionMedical optionMedical;
   private ExercicesVentes exercicesVentes;
   private ExercicesVentes lastExoVentes;
   private EspionDao espionDao;
   private int var_nb_max = 100;
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();
   private CalculChrono calculChrono;
   private transient DataModel datamodelCommission = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List listCommission = new ArrayList();
   private CommissionEnteteVentes commissionEnteteVentes = new CommissionEnteteVentes();
   private CommissionEnteteVentesDao commissionEnteteVentesDao;
   private transient DataModel datamodelDetailCommission = new ListDataModel();
   private List listDetailCommission = new ArrayList();
   private CommissionLigneVentes commissionLigneVentes = new CommissionLigneVentes();
   private CommissionLigneVentesDao commissionLigneVentesDao;
   private boolean visibiliteBton = false;
   private boolean showModalPanelAnnuler = false;
   private ResponsableDao responsableDao;
   private TiersDao tiersDao;
   private String labelOnglet;
   private List listDetailConsultation = new ArrayList();
   private ConsultationEnteteGene consultationEnteteGene = new ConsultationEnteteGene();
   private ConsultationEnteteGeneDao consultationEnteteGeneDao;
   private ConsultationActes consultationActes = new ConsultationActes();
   private ConsultationActesDao consultationActesDao;
   private ConsultationOrdoDao consultationOrdoDao;
   private ConsultationLaboDao consultationLaboDao;
   private List listDetailPharmacie = new ArrayList();
   private PharmacieEntete pharmacieEntete = new PharmacieEntete();
   private PharmacieEnteteDao pharmacieEnteteDao;
   private PharmacieLigne pharmacieLigne = new PharmacieLigne();
   private PharmacieLigneDao pharmacieLigneDao;
   private List listDetailLaboratoire = new ArrayList();
   private LaboratoireEntete laboratoireEntete = new LaboratoireEntete();
   private LaboratoireEnteteDao laboratoireEnteteDao;
   private LaboratoireLigne laboratoireLigne = new LaboratoireLigne();
   private LaboratoireLigneDao laboratoireLigneDao;
   private List listDetailHospitalisation = new ArrayList();
   private HospitalisationEntete hospitalisationEntete = new HospitalisationEntete();
   private HospitalisationEnteteDao hospitalisationEnteteDao;
   private HospitalisationActes hospitalisationActes = new HospitalisationActes();
   private HospitalisationActesDao hospitalisationActesDao;
   private HospitalisationLabo hospitalisationLabo = new HospitalisationLabo();
   private HospitalisationLaboDao hospitalisationLaboDao;
   private HospitalisationMedi hospitalisationMedi = new HospitalisationMedi();
   private HospitalisationMediDao hospitalisationMediDao;
   private HospitalisationPrest hospitalisationPrest = new HospitalisationPrest();
   private HospitalisationPrestDao hospitalisationPrestDao;
   private HospitalisationSejour hospitalisationSejour = new HospitalisationSejour();
   private HospitalisationSejourDao hospitalisationSejourDao;
   private List listDetailRefacturation = new ArrayList();
   private FactureEnteteMedical factureEnteteMedical = new FactureEnteteMedical();
   private FactureEnteteMedicalDao factureEnteteMedicalDao;
   private FactureLigneMedical factureLigneMedical = new FactureLigneMedical();
   private FactureLigneMedicalDao factureLigneMedicalDao;
   private List listDetailFactureExterne = new ArrayList();
   private NoteDebitEnteteVentes noteDebitEnteteVentes = new NoteDebitEnteteVentes();
   private NoteDebitEnteteVentesDao noteDebitEnteteVentesDao;
   private NoteDebitLigneVentes noteDebitLigneVentes = new NoteDebitLigneVentes();
   private NoteDebitLigneVentesDao noteDebitLigneVentesDao;
   private Date inpDate;
   private Date inpDu;
   private Date inpAu;
   private String dateDebut;
   private String dateFin;
   private int inpNb;
   private int inpEtat;
   private int inpType;
   private int inpMode;
   private String periode;
   private String inpNum;
   private String inpService;
   private String inpSite;
   private String inpActivite;
   private String inpResponsable;
   private long inpIdResponsable;
   private String inpMedecin;
   private long inpIdMedecin;
   private Produits produits = new Produits();
   private ProduitsVtesDao produitsVtesDao;
   private double montantCommission;
   private double montantTotal;
   private double montantPatient;
   private double montantTiers;
   private double montantReglement;
   private double montantSolde;
   private int var_nb_ligne;
   private List mesResponsablesItems;
   private List mesMedecinItems;
   private List mesMedecinBaremeItems;
   private boolean affichagePump = false;
   private boolean var_acc_document = false;
   private boolean var_acc_imputation = false;
   private boolean var_acc_complement = false;
   private boolean var_acc_reglement = false;
   private boolean var_acc_dre = false;
   private boolean var_acc_habilitation = false;
   private boolean var_acc_etat = false;
   private boolean var_acc_tracabilite = false;
   private boolean var_acc_exoneration = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean var_acces_rapport = false;
   private Habilitation habilitation;
   private DocumentTraceVentesDao documentTraceVentesDao;
   private UtilParapheur utilParapheur;
   private boolean existParapheur;
   private Users responsable;
   private long var_nom_commercial;
   private UserDao userDao;
   private boolean showModalPanelAjoutCalcul = false;
   private String montant_lettre;
   private boolean showModalPanelPrint = false;
   private List listDetailReglement = new ArrayList();
   private Reglements reglements = new Reglements();
   private ReglementsDao reglementsDao;
   private boolean var_affiche_dollar = false;
   private boolean var_affiche_valide = false;
   private double montantElmTotBonEnc;
   private boolean afficheRecu;
   private transient DataModel datamodelRecu;
   private boolean var_verouxModReg;
   private boolean var_affichMontant;
   private String var_inputCaisse;
   private double var_netAPayer;
   private double var_solde;
   private double var_tot_precompte;
   private double var_verse;
   private double var_dejaPaye;
   private boolean showModalPanelPaye = false;
   private int varTypeReg;
   private String var_modele_trf;
   private String var_num_cheque;
   private String var_banque_tireur;
   private List listCommissionSelectionne;
   private transient DataModel datamodelPaiement;
   private List mesCaissesSeriesItems;
   private List listCaisses;
   private boolean showModalPanelHistoReglement = false;
   private boolean var_anal_activite;
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private EcrituresAnalytiqueCtrl ecrituresAnalytiqueCtrl;
   private List lesDecoupagesActivites;
   private transient DataModel dataModelDecoupageActivtes;
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private double totalImputation;
   private double soldeImputation;
   private DocumentEntete documentEntete;
   private List lesAnalyses;
   private transient DataModel dataModelAnalyse;
   private boolean visibiliteBtonRapport = false;
   private boolean showModalPanelRapport = false;
   private RapportMedical rapportMedical;
   private RapportMedicalDao rapportMedicalDao;
   private List lesRapports;
   private transient DataModel dataModelRapport;
   private Baremes baremes;
   private BaremesDao baremesDao;
   private List lesBaremes;
   private List lesDetailsCommissions;
   private DocumentMedical documentMedical;

   public FormCommissionsMedicales() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.datamodelRecu = new ListDataModel();
      this.listCommissionSelectionne = new ArrayList();
      this.datamodelPaiement = new ListDataModel();
      this.lesDecoupagesActivites = new ArrayList();
      this.dataModelDecoupageActivtes = new ListDataModel();
      this.mesResponsablesItems = new ArrayList();
      this.mesMedecinItems = new ArrayList();
      this.lesAnalyses = new ArrayList();
      this.dataModelAnalyse = new ListDataModel();
      this.lesRapports = new ArrayList();
      this.dataModelRapport = new ListDataModel();
      this.lesBaremes = new ArrayList();
      this.lesDetailsCommissions = new ArrayList();
      this.mesMedecinBaremeItems = new ArrayList();
      this.mesCaissesSeriesItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.commissionEnteteVentesDao = new CommissionEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.commissionLigneVentesDao = new CommissionLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.responsableDao = new ResponsableDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.consultationEnteteGeneDao = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      this.consultationActesDao = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
      this.consultationOrdoDao = new ConsultationOrdoDao(this.baseLog, this.utilInitHibernate);
      this.consultationLaboDao = new ConsultationLaboDao(this.baseLog, this.utilInitHibernate);
      this.pharmacieEnteteDao = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
      this.pharmacieLigneDao = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
      this.laboratoireEnteteDao = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      this.laboratoireLigneDao = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationEnteteDao = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationActesDao = new HospitalisationActesDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationLaboDao = new HospitalisationLaboDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationMediDao = new HospitalisationMediDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationPrestDao = new HospitalisationPrestDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationSejourDao = new HospitalisationSejourDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteMedicalDao = new FactureEnteteMedicalDao(this.baseLog, this.utilInitHibernate);
      this.factureLigneMedicalDao = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteVentesDao = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitLigneVentesDao = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.rapportMedicalDao = new RapportMedicalDao(this.baseLog, this.utilInitHibernate);
      this.baremesDao = new BaremesDao(this.baseLog, this.utilInitHibernate);
   }

   public void configVentes(Session var1) throws HibernateException, NamingException {
      if (this.structureLog.getStrtypeentreprise() == null || this.structureLog.getStrtypeentreprise().isEmpty()) {
         this.structureLog.setStrtypeentreprise("0");
      }

      if (this.optionMedical.getNbLigneMax() != null && !this.optionMedical.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionMedical.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.periode = this.optionMedical.getAffichInGlobViewCOMMISSION();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
      this.usersChrono = new UsersChrono();
      this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
      this.infirmerie = this.rechercheModule(81500);
      if (this.infirmerie && this.usersLog.getUsrSite() != null && !this.usersLog.getUsrSite().isEmpty()) {
         this.inpSite = this.usersLog.getUsrSite();
      }

   }

   public boolean rechercheModule(int var1) {
      boolean var2 = false;
      ArrayList var3 = new ArrayList();
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
         var3.add(this.structureLog.getStrmod1());
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
         var3.add(this.structureLog.getStrmod2());
      }

      if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
         var3.add(this.structureLog.getStrmod3());
      }

      if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
         var3.add(this.structureLog.getStrmod4());
      }

      if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
         var3.add(this.structureLog.getStrmod5());
      }

      if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
         var3.add(this.structureLog.getStrmod6());
      }

      if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
         var3.add(this.structureLog.getStrmod7());
      }

      if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod8());
      }

      if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod9());
      }

      if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
         var3.add(this.structureLog.getStrmod10());
      }

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         String var5 = "" + var1;
         if (var5.contentEquals((CharSequence)var3.get(var4))) {
            var2 = true;
         }
      }

      return var2;
   }

   public void accesResteintUser(Session var1) throws HibernateException, NamingException {
      if (this.usersLog.getUsrAffPump() == 0) {
         this.affichagePump = false;
      } else {
         this.affichagePump = true;
      }

      this.var_acces_rapport = false;
      new UsersChrono();
      UsersChrono var2 = this.usersChronoDao.chronoByUserNat(this.usersLog, 180, var1);
      if (var2 != null) {
         this.var_acces_rapport = true;
      }

   }

   public void accesResteintGroupe() {
      this.var_acc_document = false;
      this.var_acc_imputation = false;
      this.var_acc_complement = false;
      this.var_acc_reglement = false;
      this.var_acc_dre = false;
      this.var_acc_habilitation = false;
      this.var_acc_etat = false;
      this.var_acc_tracabilite = false;
      this.var_acc_exoneration = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("51")) {
               this.var_acc_document = true;
            } else if (var1.getCode().equals("52")) {
               this.var_acc_imputation = true;
            } else if (var1.getCode().equals("53")) {
               this.var_acc_complement = true;
            } else if (var1.getCode().equals("54")) {
               this.var_acc_reglement = true;
            } else if (var1.getCode().equals("55")) {
               this.var_acc_dre = true;
            } else if (var1.getCode().equals("56")) {
               this.var_acc_habilitation = true;
            } else if (var1.getCode().equals("57")) {
               this.var_acc_etat = true;
            } else if (var1.getCode().equals("58")) {
               this.var_acc_tracabilite = true;
            } else if (var1.getCode().equals("59")) {
               this.var_acc_exoneration = true;
            }
         }
      }

   }

   public void autorisationDocument() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("51")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationImputation() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("52")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationComplement() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("53")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationReglement() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("54")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationDre() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("55")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationHabilitation() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("56")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationEtat() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("57")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationTracabilite() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("58")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationExoneration() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("59")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void documentAnalyse() {
      this.labelOnglet = "tabAnalyse";
   }

   public void rapport() {
      this.labelOnglet = "tabRapport";
   }

   public void document() {
      this.labelOnglet = "tabCom";
   }

   public void executerRequete() throws NamingException, HibernateException, ParseException {
      this.executerRequete((Session)null);
   }

   public void executerRequete(Session var1) throws NamingException, HibernateException, ParseException {
      this.listCommission.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.var_nb_ligne = 0;
      this.inpNum = "";
      this.inpService = "100";
      this.inpActivite = "100";
      Object var2 = null;
      Object var3 = null;
      double var4 = 0.0D;
      double var6 = 0.0D;
      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      this.listCommission = this.commissionEnteteVentesDao.recherche(var1, this.exercicesVentes.getExevteId(), this.inpNum, this.inpEtat, this.periode, this.inpService, this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.inpIdResponsable, this.inpIdMedecin, this.inpActivite, (String)var2, (String)var3);
      if (this.listCommission.size() > 0) {
         new CommissionEnteteVentes();

         for(int var9 = 0; var9 < this.listCommission.size(); ++var9) {
            CommissionEnteteVentes var8 = (CommissionEnteteVentes)this.listCommission.get(var9);
            var4 += var8.getComNetPayer();
            var6 += var8.getComTotReglement();
         }

         this.var_nb_ligne = this.listCommission.size();
      }

      this.datamodelCommission.setWrappedData(this.listCommission);
      this.montantCommission = var4;
      this.montantReglement = var6;
      this.montantSolde = this.montantCommission - var6;
      this.visibiliteBton = false;
   }

   public void selectionLigne() throws HibernateException, NamingException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionEntete.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.commissionEnteteVentes = (CommissionEnteteVentes)var1.get(0);
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "CommissionEnteteMedical");
            this.chargerDetail(var4);
            this.chargerBonEncaissement(var4);
            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            this.visibiliteBton = true;
            this.utilInitHibernate.closeSession();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.commissionEnteteVentes != null) {
         this.consultDocument();
      }

   }

   public void consultDocument() {
      this.var_action = 1;
      this.var_memo_action = this.var_action;
   }

   public void chargerDetail(Session var1) throws HibernateException, NamingException {
      if (this.commissionEnteteVentes != null) {
         this.listDetailCommission.clear();
         this.listDetailCommission = this.commissionLigneVentesDao.chargerLesLignes(this.commissionEnteteVentes, var1);
         this.datamodelDetailCommission.setWrappedData(this.listDetailCommission);
      }

   }

   public void chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      new ArrayList();
      List var4 = this.reglementsDao.reglementDocument(this.commissionEnteteVentes.getComId(), this.nature, var1);
      this.afficheRecu = false;
      if (var4.size() != 0) {
         this.afficheRecu = true;

         for(int var5 = 0; var5 < var4.size(); ++var5) {
            var2 += ((Reglements)var4.get(var5)).getRglDepense();
         }
      }

      this.datamodelRecu.setWrappedData(var4);
      if (var2 < this.commissionEnteteVentes.getComTotCommission()) {
         this.var_affiche_dollar = true;
      } else {
         this.var_affiche_dollar = false;
      }

   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.commissionEnteteVentes != null) {
         this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
      }

   }

   public void annuleCommission() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void valideDocument() throws HibernateException, NamingException, ParseException {
      if (this.commissionEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CommissionEnteteMedical");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.commissionEnteteVentes.getComEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.commissionEnteteVentes.setComEtat(1);
               this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes, var1);
            }

            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Validation manuelle commission (C.) N° " + this.commissionEnteteVentes.getComNum() + " du " + this.utilDate.dateToStringSQLLight(this.commissionEnteteVentes.getComDate()));
            this.espionDao.mAJEspion(var3, var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.executerRequete((Session)null);
      }

   }

   public void deValideDocument() throws HibernateException, NamingException, ParseException {
      if (this.commissionEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CommissionEnteteMedical");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.commissionEnteteVentes.getComEtat() == 1 && this.habilitation == null) {
               this.commissionEnteteVentes.setComEtat(0);
               this.commissionEnteteVentes.setComDateImp((Date)null);
               this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes, var1);
            }

            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Dévalidation manuelle commission (C.) N° " + this.commissionEnteteVentes.getComNum() + " du " + this.utilDate.dateToStringSQLLight(this.commissionEnteteVentes.getComDate()));
            this.espionDao.mAJEspion(var3, var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.executerRequete((Session)null);
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.commissionEnteteVentes.getComActivite() != null && !this.commissionEnteteVentes.getComActivite().isEmpty() && this.commissionEnteteVentes.getComActivite().contains(":")) {
         String[] var1 = null;
         if (!this.commissionEnteteVentes.getComActivite().contains("#")) {
            var1 = this.commissionEnteteVentes.getComActivite().split(":");
            if (var1.length == 8) {
               this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
               this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
               this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
               this.ecrituresAnalytiqueCtrl.setZoneActivite(this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib());
               this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[2]);
               this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[3]);
               this.ecrituresAnalytiqueCtrl.setZoneAnal1(this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib());
               this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[4]);
               this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[5]);
               this.ecrituresAnalytiqueCtrl.setZoneAnal3(this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib());
               this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(Float.parseFloat(var1[6]));
               this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[7]));
               this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
               this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            }
         } else {
            String[] var2 = this.commissionEnteteVentes.getComActivite().split("#");

            for(int var3 = 0; var3 < var2.length; ++var3) {
               var1 = var2[var3].split(":");
               if (var1.length == 8) {
                  this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
                  this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
                  this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
                  this.ecrituresAnalytiqueCtrl.setZoneActivite(this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib());
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[2]);
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[3]);
                  this.ecrituresAnalytiqueCtrl.setZoneAnal1(this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib());
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[4]);
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[5]);
                  this.ecrituresAnalytiqueCtrl.setZoneAnal3(this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib());
                  this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(Float.parseFloat(var1[6]));
                  this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[7]));
                  this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                  this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
               }
            }
         }
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void selectionAnalytique() {
      if (this.dataModelDecoupageActivtes.isRowAvailable()) {
         this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.dataModelDecoupageActivtes.getRowData();
      }

   }

   public void valideColonne1() {
      if (this.ecrituresAnalytiqueCtrl.getZoneActivite() != null && !this.ecrituresAnalytiqueCtrl.getZoneActivite().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneActivite().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneActivite().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
      }

   }

   public void valideColonne2() {
      if (this.ecrituresAnalytiqueCtrl.getZoneAnal1() != null && !this.ecrituresAnalytiqueCtrl.getZoneAnal1().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneAnal1().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneAnal1().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[1]);
      }

   }

   public void valideColonne3() {
      if (this.ecrituresAnalytiqueCtrl.getZoneAnal3() != null && !this.ecrituresAnalytiqueCtrl.getZoneAnal3().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneAnal3().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneAnal3().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[1]);
      }

   }

   public void calculPourcentage() {
      if (this.ecrituresAnalytiqueCtrl != null && this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() != 0.0F) {
         double var1 = this.utilNombre.myRoundDevise(this.commissionEnteteVentes.getComTotCommission() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
         this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(var1);
      }

   }

   public void supprimerAnalytique() {
      if (this.ecrituresAnalytiqueCtrl == null) {
         this.selectionAnalytique();
      }

      if (this.ecrituresAnalytiqueCtrl != null) {
         this.lesDecoupagesActivites.remove(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
         this.ecrituresAnalytiqueCtrl = null;
      }

      if (this.lesDecoupagesActivites.size() == 0) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void controleEcartAnalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      float var1 = 0.0F;
      if (this.lesDecoupagesActivites.size() != 0) {
         for(int var2 = 0; var2 < this.lesDecoupagesActivites.size(); ++var2) {
            this.totalImputation += ((EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var2)).getEcranaMontantSaisie();
            var1 += ((EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var2)).getEcranaPourcentage();
         }
      }

      this.soldeImputation = this.commissionEnteteVentes.getComTotCommission() - this.totalImputation;
      if (this.soldeImputation > 0.0D) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         if (var1 != 0.0F) {
            this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(100.0F - var1);
         }

         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void annulerDocument() {
      if (this.commissionEnteteVentes != null) {
         this.commissionEnteteVentes.setComDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.commissionEnteteVentes != null) {
         if (this.commissionEnteteVentes.getComDateAnnule() == null) {
            this.commissionEnteteVentes.setComDateAnnule(new Date());
         }

         this.commissionEnteteVentes.setComEtat(3);
         this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation commission vente N° " + this.commissionEnteteVentes.getComNum() + " le " + this.commissionEnteteVentes.getComDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.listCommission.remove(this.commissionEnteteVentes);
         this.datamodelCommission.setWrappedData(this.listCommission);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void payeDocument() throws HibernateException, NamingException {
      if (this.commissionEnteteVentes != null) {
         this.var_num_cheque = "";
         this.var_banque_tireur = "";
         this.varTypeReg = 0;
         this.mesCaissesSeriesItems.clear();

         for(int var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2)) {
               String var2 = ((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var1)).getUsrchrLib();
               this.mesCaissesSeriesItems.add(new SelectItem(var2));
            }
         }

         this.var_netAPayer = 0.0D;
         this.var_dejaPaye = 0.0D;
         this.var_solde = 0.0D;
         this.toutDesel();
         this.reglements = new Reglements();
         this.reglements.setRglDateReg(new Date());
         this.listCommissionSelectionne.clear();
         ArrayList var3 = new ArrayList();
         List var4 = this.calculeDetailPatient(var3);
         if (var4.size() != 0) {
            for(int var5 = 0; var5 < var4.size(); ++var5) {
               if (((CommissionLigneVentes)var4.get(var5)).getComligTotVerse() == 0.0D) {
                  this.listCommissionSelectionne.add(var4.get(var5));
               }
            }

            this.datamodelPaiement.setWrappedData(this.listCommissionSelectionne);
            this.showModalPanelPaye = true;
         }
      }

   }

   public void annulePaye() {
      this.showModalPanelPaye = false;
   }

   public void miseajourPaye() throws HibernateException, NamingException, ParseException {
      if (this.commissionEnteteVentes != null && this.var_netAPayer != 0.0D) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CommissionEnteteMedical");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new ExercicesCaisse();
            ExercicesCaisseDao var4 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
            ExercicesCaisse var3 = var4.recupererLastExo(var1);
            if (var3 != null) {
               String var5 = this.calculChrono.numCompose(this.reglements.getRglDateReg(), 61, "", var1);
               this.reglements.setRglOperation("24");
               this.reglements.setRglActivite(this.commissionEnteteVentes.getComActivite());
               this.reglements.setRglBanqueTireur(this.var_banque_tireur);
               this.reglements.setRglBudget("");
               this.reglements.setRglBon("");
               this.reglements.setRglCategorie(50);
               if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
                  String[] var6 = this.var_inputCaisse.split(":");
                  this.reglements.setRglCodeCaiss(var6[0]);
                  this.reglements.setRglLibCaiss(var6[1]);
               } else {
                  this.reglements.setRglCodeCaiss((String)null);
                  this.reglements.setRglLibCaiss((String)null);
               }

               this.reglements.setRglCodeEmetrice((String)null);
               this.reglements.setRglCodeReceptrice((String)null);
               this.reglements.setRglDateCreation(new Date());
               this.reglements.setRglDateImp((Date)null);
               this.reglements.setRglDateTransfert((Date)null);
               this.reglements.setRglDateValeur((Date)null);
               this.reglements.setRglDepartement(this.commissionEnteteVentes.getComDepartement());
               this.reglements.setRglDepense(this.var_netAPayer);
               this.reglements.setRglDevise(this.structureLog.getStrdevise());
               this.reglements.setRglDossier("");
               this.reglements.setRglFormatDevise(this.structureLog.getStrformatdevise());
               this.reglements.setRglDocument("");
               this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
               this.reglements.setRglIdBon(0L);
               this.reglements.setRglIdDocument(this.commissionEnteteVentes.getComId());
               this.reglements.setRglIdTiers(this.commissionEnteteVentes.getComIdCommercial());
               this.reglements.setRglDepotTiers(0);
               this.reglements.setRglLibEmetrice("");
               this.reglements.setRglLibReceptrice("");
               this.reglements.setRglLibelle("");
               this.reglements.setRglMode("" + this.varTypeReg);
               this.reglements.setRglModele(this.var_modele_trf);
               this.reglements.setRglNumChqBdx(this.var_num_cheque);
               this.reglements.setRglNatureDoc(7);
               this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
               this.reglements.setRglNomTiers(this.commissionEnteteVentes.getComNomCommercial());
               this.reglements.setRglNum(var5);
               this.reglements.setRglObjet("Paiement commission");
               this.reglements.setRglParc("");
               this.reglements.setRglPdv("");
               this.reglements.setRglRecette(0.0D);
               this.reglements.setRglTimbre(0.0D);
               this.reglements.setRglRegion("");
               this.reglements.setRglSecteur("");
               this.reglements.setRglSerie("");
               this.reglements.setRglService(this.commissionEnteteVentes.getComService());
               this.reglements.setRglSite(this.commissionEnteteVentes.getComSite());
               this.reglements.setRglTrf(0);
               this.reglements.setRglTypeTiers(6);
               this.reglements.setRglTypeReg(this.varTypeReg);
               this.reglements.setRglUserCreat(this.usersLog.getUsrid());
               this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
               this.reglements.setRglUserModif(0L);
               this.reglements.setRglIdResponsable(0L);
               this.reglements.setRglNomResponsable("");
               this.reglements.setRglIdCommercial(0L);
               this.reglements.setRglNomCommercial("");
               this.reglements.setRglIdEquipe(0L);
               this.reglements.setRglNomEquipe("");
               String var16 = "";
               if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                  var16 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
               } else {
                  var16 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
               }

               String var7 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
               this.reglements.setRglPeriode(var16 + ":" + var7);
               this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
               String var8 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
               this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var8);
               this.reglements.setExercicesCaisse(var3);
               this.reglementsDao.insert(this.reglements, var1);
               new CommissionLigneVentes();

               for(int var10 = 0; var10 < this.listCommissionSelectionne.size(); ++var10) {
                  CommissionLigneVentes var9 = (CommissionLigneVentes)this.listCommissionSelectionne.get(var10);
                  if (var9.isSelect() && var9.getComligTotCommissionReel() != 0.0D) {
                     var9.setComligTotVerse(var9.getComligTotCommissionReel());
                     var9.setComligIdRecu(this.reglements.getRglId());
                     this.commissionLigneVentesDao.modifLigne(var9, var1);
                  }
               }

               this.commissionEnteteVentes.setComTotReglement(this.commissionEnteteVentes.getComTotReglement() + this.var_verse);
               this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes, var1);
            }

            var2.commit();
         } catch (HibernateException var14) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var14;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.executerRequete();
      this.showModalPanelPaye = false;
      this.visibiliteBton = false;
   }

   public void calulNetPayer() {
      this.var_netAPayer = 0.0D;

      for(int var1 = 0; var1 < this.listCommissionSelectionne.size(); ++var1) {
         if (((CommissionLigneVentes)this.listCommissionSelectionne.get(var1)).isSelect() && ((CommissionLigneVentes)this.listCommissionSelectionne.get(var1)).getComligTotCommissionReel() != 0.0D) {
            this.var_netAPayer += ((CommissionLigneVentes)this.listCommissionSelectionne.get(var1)).getComligTotCommissionReel();
         }
      }

      this.var_dejaPaye = this.commissionEnteteVentes.getComNetPayer() - this.commissionEnteteVentes.getComTotReglement();
      if (this.commissionEnteteVentes.getComTauxTaxe() != 0.0F && this.var_netAPayer != 0.0D) {
         this.var_tot_precompte = this.utilNombre.myRoundDevise(this.var_netAPayer * (double)this.commissionEnteteVentes.getComTauxTaxe() / 100.0D, this.structureLog.getStrdevise());
      } else {
         this.var_tot_precompte = 0.0D;
      }

      this.var_verse = this.var_netAPayer - this.var_tot_precompte;
      this.var_solde = this.var_dejaPaye - this.var_verse;
   }

   public void selPartPatient() {
      for(int var1 = 0; var1 < this.listCommissionSelectionne.size(); ++var1) {
         if (((CommissionLigneVentes)this.listCommissionSelectionne.get(var1)).getPayePatient() != 0.0D && ((CommissionLigneVentes)this.listCommissionSelectionne.get(var1)).getComligTotCommissionReel() != 0.0D) {
            ((CommissionLigneVentes)this.listCommissionSelectionne.get(var1)).setSelect(true);
         }
      }

      this.datamodelPaiement.setWrappedData(this.listCommissionSelectionne);
      this.calulNetPayer();
   }

   public void selPartTiers() {
      for(int var1 = 0; var1 < this.listCommissionSelectionne.size(); ++var1) {
         if (((CommissionLigneVentes)this.listCommissionSelectionne.get(var1)).getPayeTiers() != 0.0D && ((CommissionLigneVentes)this.listCommissionSelectionne.get(var1)).getComligTotCommissionReel() != 0.0D) {
            ((CommissionLigneVentes)this.listCommissionSelectionne.get(var1)).setSelect(true);
         }
      }

      this.datamodelPaiement.setWrappedData(this.listCommissionSelectionne);
      this.calulNetPayer();
   }

   public void toutDesel() {
      for(int var1 = 0; var1 < this.listCommissionSelectionne.size(); ++var1) {
         ((CommissionLigneVentes)this.listCommissionSelectionne.get(var1)).setSelect(false);
      }

      this.datamodelPaiement.setWrappedData(this.listCommissionSelectionne);
      this.calulNetPayer();
   }

   public void toutSel() {
      for(int var1 = 0; var1 < this.listCommissionSelectionne.size(); ++var1) {
         if (((CommissionLigneVentes)this.listCommissionSelectionne.get(var1)).getComligTotCommissionReel() != 0.0D) {
            ((CommissionLigneVentes)this.listCommissionSelectionne.get(var1)).setSelect(true);
         }
      }

      this.datamodelPaiement.setWrappedData(this.listCommissionSelectionne);
      this.calulNetPayer();
   }

   public void histoReglement() {
      if (this.commissionEnteteVentes != null) {
         this.showModalPanelHistoReglement = true;
      }

   }

   public void fermerHistoReglement() {
      this.showModalPanelHistoReglement = false;
   }

   public void ajoutCalcul() throws ParseException, HibernateException, NamingException {
      if (this.inpDu == null) {
         this.inpDu = this.utilDate.datePremierJourMois(new Date());
      }

      if (this.inpAu == null) {
         this.inpAu = this.utilDate.dateDernierJourMois(new Date());
      }

      this.inpDate = new Date();
      this.inpResponsable = "";
      this.inpIdMedecin = 0L;
      this.mesMedecinBaremeItems.clear();
      if (this.mesMedecinItems.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Baremes");
         new Users();

         for(int var3 = 0; var3 < this.mesMedecinItems.size(); ++var3) {
            long var4 = Long.parseLong(((SelectItem)this.mesMedecinItems.get(var3)).getValue().toString());
            Users var2 = this.userDao.selectLeUserId(var4, var1);
            if (var2 != null) {
               this.lesBaremes.clear();
               this.lesBaremes = this.baremesDao.listBaremesByMedecins(var2.getUsrid(), var1);
               if (this.lesBaremes.size() != 0) {
                  this.mesMedecinBaremeItems.add(this.mesMedecinItems.get(var3));
               }
            }
         }

         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelAjoutCalcul = true;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void fermerCalcul() {
      this.showModalPanelAjoutCalcul = false;
      this.visibiliteBton = false;
   }

   public void valideCalcul() throws NamingException, ParseException {
      this.lesBaremes.clear();
      this.listCommission.clear();
      this.lesDetailsCommissions.clear();
      this.listDetailConsultation.clear();
      this.listDetailPharmacie.clear();
      this.listDetailLaboratoire.clear();
      this.listDetailHospitalisation.clear();
      this.listDetailReglement.clear();
      if (this.inpDu == null) {
         this.inpDu = this.utilDate.datePremierJourMois(new Date());
      }

      if (this.inpAu == null) {
         this.inpAu = this.utilDate.dateDernierJourMois(new Date());
      }

      this.dateDebut = this.utilDate.dateToStringSQLLight(this.inpDu) + " 00:00:00";
      this.dateFin = this.utilDate.dateToStringSQLLight(this.inpAu) + " 23:59:59";
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CommissionEnteteMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         new Users();
         Users var3 = this.userDao.selectLeUserId(this.inpIdMedecin, var1);
         if (var3 != null) {
            this.inpMedecin = var3.getUsrPatronyme();
            this.lesBaremes = this.baremesDao.listBaremesByMedecins(this.inpIdMedecin, var1);
            if (this.lesBaremes.size() != 0) {
               ArrayList var4 = new ArrayList();
               ArrayList var5 = new ArrayList();
               ArrayList var6 = new ArrayList();
               List var12 = this.calculConsultation(var4, var1);
               List var13 = this.calculPharmacie(var5, var1);
               List var14 = this.calculLaboratoire(var6, var1);
               this.commissionMedecins(var12, var13, var14, var1);
               if (this.lesDetailsCommissions.size() != 0) {
                  this.miseAJourMedecins(var1);
               }
            }
         }

         var2.commit();
      } catch (HibernateException var10) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelAjoutCalcul = false;
      this.visibiliteBton = false;
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.executerRequete((Session)null);
   }

   public List calculConsultation(List var1, Session var2) throws HibernateException, NamingException, ParseException {
      String var3 = "ConsultationEnteteGene.csgDate>='" + this.dateDebut + "' and ConsultationEnteteGene.csgDate<='" + this.dateFin + "' and ConsultationEnteteGene.csgIdMedecin=" + this.inpIdMedecin + " and (((ConsultationEnteteGene.csgIdAssurance<>0 or ConsultationEnteteGene.csgIdSociete<>0 or  ConsultationEnteteGene.csgIdComplementaire<>0 or ConsultationEnteteGene.csgPecCnamgs<>0) and (ConsultationEnteteGene.csgEtat=1 or ConsultationEnteteGene.csgEtat=4 or ConsultationEnteteGene.csgEtat=5 or ConsultationEnteteGene.csgEtat=6 or ConsultationEnteteGene.csgEtat=7)) or ((ConsultationEnteteGene.csgIdAssurance=0 and ConsultationEnteteGene.csgIdSociete=0 and ConsultationEnteteGene.csgIdComplementaire=0 and ConsultationEnteteGene.csgPecCnamgs=0) and (ConsultationEnteteGene.csgEtat=1 or ConsultationEnteteGene.csgEtat=4 or ConsultationEnteteGene.csgEtat=5 or ConsultationEnteteGene.csgEtat=6 or ConsultationEnteteGene.csgEtat=7)))";
      var1 = this.consultationActesDao.chargerConsultationByRequete(var3, var2);
      return var1;
   }

   public List calculPharmacie(List var1, Session var2) throws HibernateException, NamingException, ParseException {
      String var3 = "pharmacieEntete.phaDate>='" + this.dateDebut + "' and pharmacieEntete.phaDate<='" + this.dateFin + "' and pharmacieEntete.phaIdMedecin=" + this.inpIdMedecin + " and (((pharmacieEntete.phaIdAssurance<>0 or pharmacieEntete.phaIdSociete<>0 or pharmacieEntete.phaIdComplementaire<>0 or pharmacieEntete.phaPecCnamgs<>0) and (pharmacieEntete.phaEtat=1 or pharmacieEntete.phaEtat=4 or pharmacieEntete.phaEtat=5 or pharmacieEntete.phaEtat=6 or pharmacieEntete.phaEtat=7)) or ((pharmacieEntete.phaIdAssurance=0 and pharmacieEntete.phaIdSociete=0 and pharmacieEntete.phaIdComplementaire=0 and pharmacieEntete.phaPecCnamgs=0) and (pharmacieEntete.phaEtat=1 or pharmacieEntete.phaEtat=4 or pharmacieEntete.phaEtat=5 or pharmacieEntete.phaEtat=6 or pharmacieEntete.phaEtat=7)))";
      var1 = this.pharmacieLigneDao.chargerPharmacieByRequete(var3, var2);
      return var1;
   }

   public List calculLaboratoire(List var1, Session var2) throws HibernateException, NamingException, ParseException {
      String var3 = "laboratoireEntete.labDate>='" + this.dateDebut + "' and laboratoireEntete.labDate<='" + this.dateFin + "' and laboratoireEntete.labIdMedecin=" + this.inpIdMedecin + " and (((laboratoireEntete.labIdAssurance<>0 or laboratoireEntete.labIdSociete<>0 or laboratoireEntete.labIdComplementaire<>0 or laboratoireEntete.labPecCnamgs<>0) and (laboratoireEntete.labEtat=1 or laboratoireEntete.labEtat=4 or laboratoireEntete.labEtat=5 or laboratoireEntete.labEtat=6 or laboratoireEntete.labEtat=7)) or ((laboratoireEntete.labIdAssurance=0 and laboratoireEntete.labIdSociete=0 and laboratoireEntete.labIdComplementaire=0 and laboratoireEntete.labPecCnamgs=0) and (laboratoireEntete.labEtat=1 or laboratoireEntete.labEtat=4 or laboratoireEntete.labEtat=5 or laboratoireEntete.labEtat=6or laboratoireEntete.labEtat=7)))";
      var1 = this.laboratoireLigneDao.chargerLaboratoireByRequete(var3, var2);
      return var1;
   }

   public void calculHospitalisation(Session var1) throws HibernateException, NamingException, ParseException {
   }

   public void commissionMedecins(List var1, List var2, List var3, Session var4) {
      boolean var5 = false;
      boolean var6 = false;

      int var7;
      for(var7 = 0; var7 < this.lesBaremes.size(); ++var7) {
         this.baremes = (Baremes)this.lesBaremes.get(var7);
         if (this.baremes.getBarType() != 8 && this.baremes.getBarType() != 9) {
            if (this.baremes.getBarType() == 2) {
               var6 = true;
            }
         } else {
            var5 = true;
         }
      }

      for(var7 = 0; var7 < this.lesBaremes.size(); ++var7) {
         this.baremes = (Baremes)this.lesBaremes.get(var7);
         if (this.baremes.getBarType() == 2 && !var5) {
            this.calculCas2(var5, var6, var1, var2, var3);
         } else if (this.baremes.getBarType() != 3 || var5) {
            if (this.baremes.getBarType() == 4 && !var5) {
               this.calculCas4(var5, var6, var1);
            } else if (this.baremes.getBarType() == 5 && !var5) {
               this.calculCas5(var5, var6, var2);
            } else if (this.baremes.getBarType() == 6 && !var5) {
               this.calculCas6(var5, var6, var3);
            } else if (this.baremes.getBarType() != 7 || var5) {
               if (this.baremes.getBarType() == 8) {
                  this.calculCas8(var5, var6, var1, var2, var3);
               } else if (this.baremes.getBarType() == 9) {
                  this.calculCas9(var5, var6, var1, var2, var3);
               }
            }
         }
      }

   }

   public void calculCas2(boolean var1, boolean var2, List var3, List var4, List var5) {
      int var6;
      for(var6 = 0; var6 < var3.size(); ++var6) {
         this.consultationActes = (ConsultationActes)var3.get(var6);
         this.consultationEnteteGene = this.consultationActes.getConsultationEnteteGene();
         if (this.consultationActes.getCslactProduit() != null && !this.consultationActes.getCslactProduit().isEmpty() && this.baremes.getBarCodeProduit() != null && !this.baremes.getBarCodeProduit().isEmpty() && this.consultationActes.getCslactProduit().equals(this.baremes.getBarCodeProduit())) {
            this.documentMedical = new DocumentMedical();
            this.documentMedical.setDocDate(this.consultationEnteteGene.getCsgDate());
            this.documentMedical.setDocNum(this.consultationEnteteGene.getCsgNum());
            this.documentMedical.setDocNature(71);
            this.documentMedical.setDocId(this.consultationActes.getCslactId());
            this.documentMedical.setDocObs(this.consultationEnteteGene.getCsgSerie());
            this.documentMedical.setDocNomPatient(this.consultationEnteteGene.getCsgNomPatient());
            this.documentMedical.setDocIdPatient(this.consultationEnteteGene.getCsgIdPatient());
            this.documentMedical.setDocCivilite(this.consultationEnteteGene.getCsgCivilite());
            this.documentMedical.setDocFam(this.consultationEnteteGene.getCsgFam());
            this.documentMedical.setDocService(this.consultationEnteteGene.getCsgService());
            this.documentMedical.setDocDossier(this.consultationEnteteGene.getPatients().getPatDossier());
            if (this.consultationEnteteGene.getCsgIdAssurance() != 0L) {
               this.documentMedical.setDocPrescripteur("ASS." + this.consultationEnteteGene.getCsgNomAssurance());
            } else if (this.consultationEnteteGene.getCsgIdSociete() != 0L) {
               this.documentMedical.setDocPrescripteur("SOC." + this.consultationEnteteGene.getCsgNomSociete());
            } else if (this.consultationEnteteGene.getCsgPecCnamgs() != 0.0F) {
               this.documentMedical.setDocPrescripteur("CNAMGS");
            } else {
               this.documentMedical.setDocPrescripteur("PRIVE");
            }

            if (this.consultationEnteteGene.getCsgIdAssurance() == 0L && this.consultationEnteteGene.getCsgIdSociete() == 0L && this.consultationEnteteGene.getCsgIdComplementaire() == 0L && this.consultationEnteteGene.getCsgPecCnamgs() == 0.0F && this.consultationEnteteGene.getCsgRegPatient() != 0.0D) {
               this.documentMedical.setDocRegPatient(this.consultationEnteteGene.getCsgRegPatient());
            } else {
               this.documentMedical.setDocRegPatient(0.0D);
            }

            this.documentMedical.setDocRegTiers(this.consultationEnteteGene.getCsgRegTiers());
            this.documentMedical.setDocCode(this.consultationActes.getCslactProduit());
            this.documentMedical.setDocLibelleNature(this.consultationActes.getCslactLibelle());
            this.documentMedical.setDocQte(this.consultationActes.getCslactQte());
            if (this.baremes.getBarRemise() != 0.0F) {
               this.documentMedical.setDocRemise(this.baremes.getBarRemise());
               this.documentMedical.setDocPu(this.consultationActes.getCslactPu());
               this.documentMedical.setDocCom(this.utilNombre.myRoundDevise(this.documentMedical.getDocPu() * (double)this.documentMedical.getDocQte() * (double)this.baremes.getBarRemise() / 100.0D, this.structureLog.getStrdevise()));
            } else {
               this.documentMedical.setDocRemise(0.0F);
               this.documentMedical.setDocPu(this.baremes.getBarPrix());
               this.documentMedical.setDocCom(this.utilNombre.myRoundDevise(this.documentMedical.getDocPu() * (double)this.documentMedical.getDocQte(), this.structureLog.getStrdevise()));
            }

            if (this.consultationEnteteGene.getCsgEtat() <= 3) {
               this.documentMedical.setDocCom(0.0D);
            }

            this.lesDetailsCommissions.add(this.documentMedical);
         }
      }

      for(var6 = 0; var6 < var4.size(); ++var6) {
         this.pharmacieLigne = (PharmacieLigne)var4.get(var6);
         this.pharmacieEntete = this.pharmacieLigne.getPharmacieEntete();
         if (this.pharmacieLigne.getPhaligProduit() != null && !this.pharmacieLigne.getPhaligProduit().isEmpty() && this.baremes.getBarCodeProduit() != null && !this.baremes.getBarCodeProduit().isEmpty() && this.pharmacieLigne.getPhaligProduit().equals(this.baremes.getBarCodeProduit())) {
            this.documentMedical = new DocumentMedical();
            this.documentMedical.setDocDate(this.pharmacieEntete.getPhaDate());
            this.documentMedical.setDocNum(this.pharmacieEntete.getPhaNum());
            this.documentMedical.setDocNature(73);
            this.documentMedical.setDocId(this.pharmacieLigne.getPhaligId());
            this.documentMedical.setDocObs(this.pharmacieEntete.getPhaSerie());
            this.documentMedical.setDocNomPatient(this.pharmacieEntete.getPhaNomPatient());
            this.documentMedical.setDocIdPatient(this.pharmacieEntete.getPhaIdPatient());
            this.documentMedical.setDocCivilite(this.pharmacieEntete.getPhaCivilite());
            this.documentMedical.setDocFam(this.pharmacieEntete.getPhaFam());
            this.documentMedical.setDocService(this.pharmacieEntete.getPhaService());
            this.documentMedical.setDocDossier(this.pharmacieEntete.getPatients().getPatDossier());
            if (this.pharmacieEntete.getPhaIdAssurance() != 0L) {
               this.documentMedical.setDocPrescripteur("ASS." + this.pharmacieEntete.getPhaNomAssurance());
            } else if (this.pharmacieEntete.getPhaIdSociete() != 0L) {
               this.documentMedical.setDocPrescripteur("SOC." + this.pharmacieEntete.getPhaNomSociete());
            } else if (this.pharmacieEntete.getPhaPecCnamgs() != 0.0F) {
               this.documentMedical.setDocPrescripteur("CNAMGS");
            } else {
               this.documentMedical.setDocPrescripteur("PRIVE");
            }

            if (this.pharmacieEntete.getPhaIdAssurance() == 0L && this.pharmacieEntete.getPhaIdSociete() == 0L && this.pharmacieEntete.getPhaIdComplementaire() == 0L && this.pharmacieEntete.getPhaPecCnamgs() == 0.0F && this.pharmacieEntete.getPhaRegPatient() != 0.0D) {
               this.documentMedical.setDocRegPatient(this.pharmacieEntete.getPhaRegPatient());
            } else {
               this.documentMedical.setDocRegPatient(0.0D);
            }

            this.documentMedical.setDocRegTiers(this.pharmacieEntete.getPhaRegTiers());
            this.documentMedical.setDocCode(this.pharmacieLigne.getPhaligProduit());
            this.documentMedical.setDocLibelleNature(this.pharmacieLigne.getPhaligLibelle());
            this.documentMedical.setDocQte(this.pharmacieLigne.getPhaligQte());
            if (this.baremes.getBarRemise() != 0.0F) {
               this.documentMedical.setDocRemise(this.baremes.getBarRemise());
               this.documentMedical.setDocPu(this.pharmacieLigne.getPhaligPu());
               this.documentMedical.setDocCom(this.utilNombre.myRoundDevise(this.documentMedical.getDocPu() * (double)this.documentMedical.getDocQte() * (double)this.baremes.getBarRemise() / 100.0D, this.structureLog.getStrdevise()));
            } else {
               this.documentMedical.setDocRemise(0.0F);
               this.documentMedical.setDocPu(this.baremes.getBarPrix());
               this.documentMedical.setDocCom(this.utilNombre.myRoundDevise(this.documentMedical.getDocPu() * (double)this.documentMedical.getDocQte(), this.structureLog.getStrdevise()));
            }

            if (this.pharmacieEntete.getPhaEtat() <= 3) {
               this.documentMedical.setDocCom(0.0D);
            }

            this.lesDetailsCommissions.add(this.documentMedical);
         }
      }

      for(var6 = 0; var6 < var5.size(); ++var6) {
         this.laboratoireLigne = (LaboratoireLigne)var5.get(var6);
         this.laboratoireEntete = this.laboratoireLigne.getLaboratoireEntete();
         if (this.laboratoireLigne.getLabligProduit() != null && !this.laboratoireLigne.getLabligProduit().isEmpty() && this.baremes.getBarCodeProduit() != null && !this.baremes.getBarCodeProduit().isEmpty() && this.laboratoireLigne.getLabligProduit().equals(this.baremes.getBarCodeProduit())) {
            this.documentMedical = new DocumentMedical();
            this.documentMedical.setDocDate(this.laboratoireEntete.getLabDate());
            this.documentMedical.setDocNum(this.laboratoireEntete.getLabNum());
            this.documentMedical.setDocNature(74);
            this.documentMedical.setDocId(this.laboratoireLigne.getLabligId());
            this.documentMedical.setDocObs(this.laboratoireEntete.getLabSerie());
            this.documentMedical.setDocNomPatient(this.laboratoireEntete.getLabNomPatient());
            this.documentMedical.setDocIdPatient(this.laboratoireEntete.getLabIdPatient());
            this.documentMedical.setDocCivilite(this.laboratoireEntete.getLabCivilite());
            this.documentMedical.setDocFam(this.laboratoireEntete.getLabFam());
            this.documentMedical.setDocService(this.laboratoireEntete.getLabLaboratoire());
            this.documentMedical.setDocDossier(this.laboratoireEntete.getPatients().getPatDossier());
            if (this.laboratoireEntete.getLabIdAssurance() != 0L) {
               this.documentMedical.setDocPrescripteur("ASS." + this.laboratoireEntete.getLabNomAssurance());
            } else if (this.laboratoireEntete.getLabIdSociete() != 0L) {
               this.documentMedical.setDocPrescripteur("SOC." + this.laboratoireEntete.getLabNomSociete());
            } else if (this.laboratoireEntete.getLabPecCnamgs() != 0.0F) {
               this.documentMedical.setDocPrescripteur("CNAMGS");
            } else {
               this.documentMedical.setDocPrescripteur("PRIVE");
            }

            if (this.laboratoireEntete.getLabIdAssurance() == 0L && this.laboratoireEntete.getLabIdSociete() == 0L && this.laboratoireEntete.getLabIdComplementaire() == 0L && this.laboratoireEntete.getLabPecCnamgs() == 0.0F && this.laboratoireEntete.getLabRegPatient() != 0.0D) {
               this.documentMedical.setDocRegPatient(this.laboratoireEntete.getLabRegPatient());
            } else {
               this.documentMedical.setDocRegPatient(0.0D);
            }

            this.documentMedical.setDocRegTiers(this.laboratoireEntete.getLabRegTiers());
            this.documentMedical.setDocCode(this.laboratoireLigne.getLabligProduit());
            this.documentMedical.setDocLibelleNature(this.laboratoireLigne.getLabligLibelle());
            this.documentMedical.setDocQte(this.laboratoireLigne.getLabligQte());
            if (this.baremes.getBarRemise() != 0.0F) {
               this.documentMedical.setDocRemise(this.baremes.getBarRemise());
               this.documentMedical.setDocPu(this.laboratoireLigne.getLabligPu());
               this.documentMedical.setDocCom(this.utilNombre.myRoundDevise(this.documentMedical.getDocPu() * (double)this.documentMedical.getDocQte() * (double)this.baremes.getBarRemise() / 100.0D, this.structureLog.getStrdevise()));
            } else {
               this.documentMedical.setDocRemise(0.0F);
               this.documentMedical.setDocPu(this.baremes.getBarPrix());
               this.documentMedical.setDocCom(this.utilNombre.myRoundDevise(this.documentMedical.getDocPu() * (double)this.documentMedical.getDocQte(), this.structureLog.getStrdevise()));
            }

            if (this.laboratoireEntete.getLabEtat() <= 3) {
               this.documentMedical.setDocCom(0.0D);
            }

            this.lesDetailsCommissions.add(this.documentMedical);
         }
      }

   }

   public void calculCas4(boolean var1, boolean var2, List var3) {
      for(int var4 = 0; var4 < var3.size(); ++var4) {
         this.consultationActes = (ConsultationActes)var3.get(var4);
         this.consultationEnteteGene = this.consultationActes.getConsultationEnteteGene();
         this.documentMedical = new DocumentMedical();
         this.documentMedical.setDocDate(this.consultationEnteteGene.getCsgDate());
         this.documentMedical.setDocNum(this.consultationEnteteGene.getCsgNum());
         this.documentMedical.setDocNature(71);
         this.documentMedical.setDocId(this.consultationActes.getCslactId());
         this.documentMedical.setDocObs(this.consultationEnteteGene.getCsgSerie());
         this.documentMedical.setDocNomPatient(this.consultationEnteteGene.getCsgNomPatient());
         this.documentMedical.setDocIdPatient(this.consultationEnteteGene.getCsgIdPatient());
         this.documentMedical.setDocCivilite(this.consultationEnteteGene.getCsgCivilite());
         this.documentMedical.setDocFam(this.consultationEnteteGene.getCsgFam());
         this.documentMedical.setDocService(this.consultationEnteteGene.getCsgService());
         this.documentMedical.setDocDossier(this.consultationEnteteGene.getPatients().getPatDossier());
         if (this.consultationEnteteGene.getCsgIdAssurance() != 0L) {
            this.documentMedical.setDocPrescripteur("ASS." + this.consultationEnteteGene.getCsgNomAssurance());
         } else if (this.consultationEnteteGene.getCsgIdSociete() != 0L) {
            this.documentMedical.setDocPrescripteur("SOC." + this.consultationEnteteGene.getCsgNomSociete());
         } else if (this.consultationEnteteGene.getCsgPecCnamgs() != 0.0F) {
            this.documentMedical.setDocPrescripteur("CNAMGS");
         } else {
            this.documentMedical.setDocPrescripteur("PRIVE");
         }

         if (this.consultationEnteteGene.getCsgIdAssurance() == 0L && this.consultationEnteteGene.getCsgIdSociete() == 0L && this.consultationEnteteGene.getCsgIdComplementaire() == 0L && this.consultationEnteteGene.getCsgPecCnamgs() == 0.0F && this.consultationEnteteGene.getCsgRegPatient() != 0.0D) {
            this.documentMedical.setDocRegPatient(this.consultationEnteteGene.getCsgRegPatient());
         } else {
            this.documentMedical.setDocRegPatient(0.0D);
         }

         this.documentMedical.setDocRegTiers(this.consultationEnteteGene.getCsgRegTiers());
         this.documentMedical.setDocCode(this.consultationActes.getCslactProduit());
         this.documentMedical.setDocLibelleNature(this.consultationActes.getCslactLibelle());
         this.documentMedical.setDocQte(this.consultationActes.getCslactQte());
         if (var1 && var2) {
            boolean var5 = false;

            for(int var6 = 0; var6 < this.lesBaremes.size(); ++var6) {
               if (((Baremes)this.lesBaremes.get(var6)).getBarType() == 2 && ((Baremes)this.lesBaremes.get(var6)).getBarCodeProduit() != null && !((Baremes)this.lesBaremes.get(var6)).getBarCodeProduit().isEmpty() && this.documentMedical.getDocCode() != null && !this.documentMedical.getDocCode().isEmpty() && ((Baremes)this.lesBaremes.get(var6)).getBarCodeProduit().equals(this.documentMedical.getDocCode())) {
                  this.documentMedical.setDocPu(((Baremes)this.lesBaremes.get(var6)).getBarPrix());
                  var5 = true;
                  break;
               }
            }

            if (!var5) {
               this.documentMedical.setDocPu(this.consultationActes.getCslactPu());
            }
         } else {
            this.documentMedical.setDocPu(this.consultationActes.getCslactPu());
         }

         this.documentMedical.setDocRemise(this.baremes.getBarRemise());
         this.documentMedical.setDocCom(this.utilNombre.myRoundDevise(this.documentMedical.getDocPu() * (double)this.documentMedical.getDocQte() * (double)this.baremes.getBarRemise() / 100.0D, this.structureLog.getStrdevise()));
         if (this.consultationEnteteGene.getCsgEtat() <= 3) {
            this.documentMedical.setDocCom(0.0D);
         }

         this.lesDetailsCommissions.add(this.documentMedical);
      }

   }

   public void calculCas5(boolean var1, boolean var2, List var3) {
      for(int var4 = 0; var4 < var3.size(); ++var4) {
         this.pharmacieLigne = (PharmacieLigne)var3.get(var4);
         this.pharmacieEntete = this.pharmacieLigne.getPharmacieEntete();
         this.documentMedical = new DocumentMedical();
         this.documentMedical.setDocDate(this.pharmacieEntete.getPhaDate());
         this.documentMedical.setDocNum(this.pharmacieEntete.getPhaNum());
         this.documentMedical.setDocNature(73);
         this.documentMedical.setDocId(this.pharmacieLigne.getPhaligId());
         this.documentMedical.setDocObs(this.pharmacieEntete.getPhaSerie());
         this.documentMedical.setDocNomPatient(this.pharmacieEntete.getPhaNomPatient());
         this.documentMedical.setDocIdPatient(this.pharmacieEntete.getPhaIdPatient());
         this.documentMedical.setDocCivilite(this.pharmacieEntete.getPhaCivilite());
         this.documentMedical.setDocFam(this.pharmacieEntete.getPhaFam());
         this.documentMedical.setDocService(this.pharmacieEntete.getPhaService());
         this.documentMedical.setDocDossier(this.pharmacieEntete.getPatients().getPatDossier());
         if (this.pharmacieEntete.getPhaIdAssurance() != 0L) {
            this.documentMedical.setDocPrescripteur("ASS." + this.pharmacieEntete.getPhaNomAssurance());
         } else if (this.pharmacieEntete.getPhaIdSociete() != 0L) {
            this.documentMedical.setDocPrescripteur("SOC." + this.pharmacieEntete.getPhaNomSociete());
         } else if (this.pharmacieEntete.getPhaPecCnamgs() != 0.0F) {
            this.documentMedical.setDocPrescripteur("CNAMGS");
         } else {
            this.documentMedical.setDocPrescripteur("PRIVE");
         }

         if (this.pharmacieEntete.getPhaIdAssurance() == 0L && this.pharmacieEntete.getPhaIdSociete() == 0L && this.pharmacieEntete.getPhaIdComplementaire() == 0L && this.pharmacieEntete.getPhaPecCnamgs() == 0.0F && this.pharmacieEntete.getPhaRegPatient() != 0.0D) {
            this.documentMedical.setDocRegPatient(this.pharmacieEntete.getPhaRegPatient());
         } else {
            this.documentMedical.setDocRegPatient(0.0D);
         }

         this.documentMedical.setDocRegTiers(this.pharmacieEntete.getPhaRegTiers());
         this.documentMedical.setDocCode(this.pharmacieLigne.getPhaligProduit());
         this.documentMedical.setDocLibelleNature(this.pharmacieLigne.getPhaligLibelle());
         this.documentMedical.setDocQte(this.pharmacieLigne.getPhaligQte());
         if (var1 && var2) {
            boolean var5 = false;

            for(int var6 = 0; var6 < this.lesBaremes.size(); ++var6) {
               if (((Baremes)this.lesBaremes.get(var6)).getBarType() == 2 && ((Baremes)this.lesBaremes.get(var6)).getBarCodeProduit() != null && !((Baremes)this.lesBaremes.get(var6)).getBarCodeProduit().isEmpty() && this.documentMedical.getDocCode() != null && !this.documentMedical.getDocCode().isEmpty() && ((Baremes)this.lesBaremes.get(var6)).getBarCodeProduit().equals(this.documentMedical.getDocCode())) {
                  this.documentMedical.setDocPu(((Baremes)this.lesBaremes.get(var6)).getBarPrix());
                  var5 = true;
                  break;
               }
            }

            if (!var5) {
               this.documentMedical.setDocPu(this.pharmacieLigne.getPhaligPu());
            }
         } else {
            this.documentMedical.setDocPu(this.pharmacieLigne.getPhaligPu());
         }

         this.documentMedical.setDocRemise(this.baremes.getBarRemise());
         this.documentMedical.setDocCom(this.utilNombre.myRoundDevise(this.documentMedical.getDocPu() * (double)this.documentMedical.getDocQte() * (double)this.baremes.getBarRemise() / 100.0D, this.structureLog.getStrdevise()));
         if (this.pharmacieEntete.getPhaEtat() <= 3) {
            this.documentMedical.setDocCom(0.0D);
         }

         this.lesDetailsCommissions.add(this.documentMedical);
      }

   }

   public void calculCas6(boolean var1, boolean var2, List var3) {
      for(int var4 = 0; var4 < var3.size(); ++var4) {
         this.laboratoireLigne = (LaboratoireLigne)var3.get(var4);
         this.laboratoireEntete = this.laboratoireLigne.getLaboratoireEntete();
         this.documentMedical = new DocumentMedical();
         this.documentMedical.setDocDate(this.laboratoireEntete.getLabDate());
         this.documentMedical.setDocNum(this.laboratoireEntete.getLabNum());
         this.documentMedical.setDocNature(74);
         this.documentMedical.setDocId(this.laboratoireLigne.getLabligId());
         this.documentMedical.setDocObs(this.laboratoireEntete.getLabSerie());
         this.documentMedical.setDocNomPatient(this.laboratoireEntete.getLabNomPatient());
         this.documentMedical.setDocIdPatient(this.laboratoireEntete.getLabIdPatient());
         this.documentMedical.setDocCivilite(this.laboratoireEntete.getLabCivilite());
         this.documentMedical.setDocFam(this.laboratoireEntete.getLabFam());
         this.documentMedical.setDocService(this.laboratoireEntete.getLabLaboratoire());
         this.documentMedical.setDocDossier(this.laboratoireEntete.getPatients().getPatDossier());
         if (this.laboratoireEntete.getLabIdAssurance() != 0L) {
            this.documentMedical.setDocPrescripteur("ASS." + this.laboratoireEntete.getLabNomAssurance());
         } else if (this.laboratoireEntete.getLabIdSociete() != 0L) {
            this.documentMedical.setDocPrescripteur("SOC." + this.laboratoireEntete.getLabNomSociete());
         } else if (this.laboratoireEntete.getLabPecCnamgs() != 0.0F) {
            this.documentMedical.setDocPrescripteur("CNAMGS");
         } else {
            this.documentMedical.setDocPrescripteur("PRIVE");
         }

         if (this.laboratoireEntete.getLabIdAssurance() == 0L && this.laboratoireEntete.getLabIdSociete() == 0L && this.laboratoireEntete.getLabIdComplementaire() == 0L && this.laboratoireEntete.getLabPecCnamgs() == 0.0F && this.laboratoireEntete.getLabRegPatient() != 0.0D) {
            this.documentMedical.setDocRegPatient(this.laboratoireEntete.getLabRegPatient());
         } else {
            this.documentMedical.setDocRegPatient(0.0D);
         }

         this.documentMedical.setDocRegTiers(this.laboratoireEntete.getLabRegTiers());
         this.documentMedical.setDocCode(this.laboratoireLigne.getLabligProduit());
         this.documentMedical.setDocLibelleNature(this.laboratoireLigne.getLabligLibelle());
         this.documentMedical.setDocQte(this.laboratoireLigne.getLabligQte());
         if (var1 && var2) {
            boolean var5 = false;

            for(int var6 = 0; var6 < this.lesBaremes.size(); ++var6) {
               if (((Baremes)this.lesBaremes.get(var6)).getBarType() == 2 && ((Baremes)this.lesBaremes.get(var6)).getBarCodeProduit() != null && !((Baremes)this.lesBaremes.get(var6)).getBarCodeProduit().isEmpty() && this.documentMedical.getDocCode() != null && !this.documentMedical.getDocCode().isEmpty() && ((Baremes)this.lesBaremes.get(var6)).getBarCodeProduit().equals(this.documentMedical.getDocCode())) {
                  this.documentMedical.setDocPu(((Baremes)this.lesBaremes.get(var6)).getBarPrix());
                  var5 = true;
                  break;
               }
            }

            if (!var5) {
               this.documentMedical.setDocPu(this.laboratoireLigne.getLabligPu());
            }
         } else {
            this.documentMedical.setDocPu(this.laboratoireLigne.getLabligPu());
         }

         this.documentMedical.setDocRemise(this.baremes.getBarRemise());
         this.documentMedical.setDocCom(this.utilNombre.myRoundDevise(this.documentMedical.getDocPu() * (double)this.documentMedical.getDocQte() * (double)this.baremes.getBarRemise() / 100.0D, this.structureLog.getStrdevise()));
         if (this.laboratoireEntete.getLabEtat() <= 3) {
            this.documentMedical.setDocCom(0.0D);
         }

         this.lesDetailsCommissions.add(this.documentMedical);
      }

   }

   public void calculCas8(boolean var1, boolean var2, List var3, List var4, List var5) {
      int var6;
      boolean var7;
      int var8;
      for(var6 = 0; var6 < var3.size(); ++var6) {
         this.consultationActes = (ConsultationActes)var3.get(var6);
         this.consultationEnteteGene = this.consultationActes.getConsultationEnteteGene();
         if (this.consultationEnteteGene.getCsgIdAssurance() == 0L && this.consultationEnteteGene.getCsgIdSociete() == 0L && this.consultationEnteteGene.getCsgIdComplementaire() == 0L && this.consultationEnteteGene.getCsgPecCnamgs() == 0.0F) {
            this.documentMedical = new DocumentMedical();
            this.documentMedical.setDocDate(this.consultationEnteteGene.getCsgDate());
            this.documentMedical.setDocNum(this.consultationEnteteGene.getCsgNum());
            this.documentMedical.setDocNature(71);
            this.documentMedical.setDocId(this.consultationActes.getCslactId());
            this.documentMedical.setDocObs(this.consultationEnteteGene.getCsgSerie());
            this.documentMedical.setDocNomPatient(this.consultationEnteteGene.getCsgNomPatient());
            this.documentMedical.setDocIdPatient(this.consultationEnteteGene.getCsgIdPatient());
            this.documentMedical.setDocCivilite(this.consultationEnteteGene.getCsgCivilite());
            this.documentMedical.setDocFam(this.consultationEnteteGene.getCsgFam());
            this.documentMedical.setDocService(this.consultationEnteteGene.getCsgService());
            this.documentMedical.setDocDossier(this.consultationEnteteGene.getPatients().getPatDossier());
            if (this.consultationEnteteGene.getCsgIdAssurance() != 0L) {
               this.documentMedical.setDocPrescripteur("ASS." + this.consultationEnteteGene.getCsgNomAssurance());
            } else if (this.consultationEnteteGene.getCsgIdSociete() != 0L) {
               this.documentMedical.setDocPrescripteur("SOC." + this.consultationEnteteGene.getCsgNomSociete());
            } else if (this.consultationEnteteGene.getCsgPecCnamgs() != 0.0F) {
               this.documentMedical.setDocPrescripteur("CNAMGS");
            } else {
               this.documentMedical.setDocPrescripteur("PRIVE");
            }

            if (this.consultationEnteteGene.getCsgIdAssurance() == 0L && this.consultationEnteteGene.getCsgIdSociete() == 0L && this.consultationEnteteGene.getCsgIdComplementaire() == 0L && this.consultationEnteteGene.getCsgPecCnamgs() == 0.0F && this.consultationEnteteGene.getCsgRegPatient() != 0.0D) {
               this.documentMedical.setDocRegPatient(this.consultationEnteteGene.getCsgRegPatient());
            } else {
               this.documentMedical.setDocRegPatient(0.0D);
            }

            this.documentMedical.setDocRegTiers(this.consultationEnteteGene.getCsgRegTiers());
            this.documentMedical.setDocCode(this.consultationActes.getCslactProduit());
            this.documentMedical.setDocLibelleNature(this.consultationActes.getCslactLibelle());
            this.documentMedical.setDocQte(this.consultationActes.getCslactQte());
            if (var1 && var2) {
               var7 = false;

               for(var8 = 0; var8 < this.lesBaremes.size(); ++var8) {
                  if (((Baremes)this.lesBaremes.get(var8)).getBarType() == 2 && ((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit() != null && !((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit().isEmpty() && this.documentMedical.getDocCode() != null && !this.documentMedical.getDocCode().isEmpty() && ((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit().equals(this.documentMedical.getDocCode())) {
                     this.documentMedical.setDocPu(((Baremes)this.lesBaremes.get(var8)).getBarPrix());
                     var7 = true;
                     break;
                  }
               }

               if (!var7) {
                  this.documentMedical.setDocPu(this.consultationActes.getCslactPu());
               }
            } else {
               this.documentMedical.setDocPu(this.consultationActes.getCslactPu());
            }

            this.documentMedical.setDocRemise(this.baremes.getBarRemise());
            this.documentMedical.setDocCom(this.utilNombre.myRoundDevise(this.documentMedical.getDocPu() * (double)this.documentMedical.getDocQte() * (double)this.baremes.getBarRemise() / 100.0D, this.structureLog.getStrdevise()));
            if (this.consultationEnteteGene.getCsgEtat() <= 3) {
               this.documentMedical.setDocCom(0.0D);
            }

            this.lesDetailsCommissions.add(this.documentMedical);
         }
      }

      for(var6 = 0; var6 < var4.size(); ++var6) {
         this.pharmacieLigne = (PharmacieLigne)var4.get(var6);
         this.pharmacieEntete = this.pharmacieLigne.getPharmacieEntete();
         if (this.pharmacieEntete.getPhaIdAssurance() == 0L && this.pharmacieEntete.getPhaIdSociete() == 0L && this.pharmacieEntete.getPhaIdComplementaire() == 0L && this.pharmacieEntete.getPhaPecCnamgs() == 0.0F) {
            this.documentMedical = new DocumentMedical();
            this.documentMedical.setDocDate(this.pharmacieEntete.getPhaDate());
            this.documentMedical.setDocNum(this.pharmacieEntete.getPhaNum());
            this.documentMedical.setDocNature(73);
            this.documentMedical.setDocId(this.pharmacieLigne.getPhaligId());
            this.documentMedical.setDocObs(this.pharmacieEntete.getPhaSerie());
            this.documentMedical.setDocNomPatient(this.pharmacieEntete.getPhaNomPatient());
            this.documentMedical.setDocIdPatient(this.pharmacieEntete.getPhaIdPatient());
            this.documentMedical.setDocCivilite(this.pharmacieEntete.getPhaCivilite());
            this.documentMedical.setDocFam(this.pharmacieEntete.getPhaFam());
            this.documentMedical.setDocService(this.pharmacieEntete.getPhaService());
            this.documentMedical.setDocDossier(this.pharmacieEntete.getPatients().getPatDossier());
            if (this.pharmacieEntete.getPhaIdAssurance() != 0L) {
               this.documentMedical.setDocPrescripteur("ASS." + this.pharmacieEntete.getPhaNomAssurance());
            } else if (this.pharmacieEntete.getPhaIdSociete() != 0L) {
               this.documentMedical.setDocPrescripteur("SOC." + this.pharmacieEntete.getPhaNomSociete());
            } else if (this.pharmacieEntete.getPhaPecCnamgs() != 0.0F) {
               this.documentMedical.setDocPrescripteur("CNAMGS");
            } else {
               this.documentMedical.setDocPrescripteur("PRIVE");
            }

            if (this.pharmacieEntete.getPhaIdAssurance() == 0L && this.pharmacieEntete.getPhaIdSociete() == 0L && this.pharmacieEntete.getPhaIdComplementaire() == 0L && this.pharmacieEntete.getPhaPecCnamgs() == 0.0F && this.pharmacieEntete.getPhaRegPatient() != 0.0D) {
               this.documentMedical.setDocRegPatient(this.pharmacieEntete.getPhaRegPatient());
            } else {
               this.documentMedical.setDocRegPatient(0.0D);
            }

            this.documentMedical.setDocRegTiers(this.pharmacieEntete.getPhaRegTiers());
            this.documentMedical.setDocCode(this.pharmacieLigne.getPhaligProduit());
            this.documentMedical.setDocLibelleNature(this.pharmacieLigne.getPhaligLibelle());
            this.documentMedical.setDocQte(this.pharmacieLigne.getPhaligQte());
            if (var1 && var2) {
               var7 = false;

               for(var8 = 0; var8 < this.lesBaremes.size(); ++var8) {
                  if (((Baremes)this.lesBaremes.get(var8)).getBarType() == 2 && ((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit() != null && !((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit().isEmpty() && this.documentMedical.getDocCode() != null && !this.documentMedical.getDocCode().isEmpty() && ((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit().equals(this.documentMedical.getDocCode())) {
                     this.documentMedical.setDocPu(((Baremes)this.lesBaremes.get(var8)).getBarPrix());
                     var7 = true;
                     break;
                  }
               }

               if (!var7) {
                  this.documentMedical.setDocPu(this.pharmacieLigne.getPhaligPu());
               }
            } else {
               this.documentMedical.setDocPu(this.pharmacieLigne.getPhaligPu());
            }

            this.documentMedical.setDocRemise(this.baremes.getBarRemise());
            this.documentMedical.setDocCom(this.utilNombre.myRoundDevise(this.documentMedical.getDocPu() * (double)this.documentMedical.getDocQte() * (double)this.baremes.getBarRemise() / 100.0D, this.structureLog.getStrdevise()));
            if (this.pharmacieEntete.getPhaEtat() <= 3) {
               this.documentMedical.setDocCom(0.0D);
            }

            this.lesDetailsCommissions.add(this.documentMedical);
         }
      }

      for(var6 = 0; var6 < var5.size(); ++var6) {
         this.laboratoireLigne = (LaboratoireLigne)var5.get(var6);
         this.laboratoireEntete = this.laboratoireLigne.getLaboratoireEntete();
         if (this.laboratoireEntete.getLabIdAssurance() == 0L && this.laboratoireEntete.getLabIdSociete() == 0L && this.laboratoireEntete.getLabIdComplementaire() == 0L && this.laboratoireEntete.getLabPecCnamgs() == 0.0F) {
            this.documentMedical = new DocumentMedical();
            this.documentMedical.setDocDate(this.laboratoireEntete.getLabDate());
            this.documentMedical.setDocNum(this.laboratoireEntete.getLabNum());
            this.documentMedical.setDocNature(74);
            this.documentMedical.setDocId(this.laboratoireLigne.getLabligId());
            this.documentMedical.setDocObs(this.laboratoireEntete.getLabSerie());
            this.documentMedical.setDocNomPatient(this.laboratoireEntete.getLabNomPatient());
            this.documentMedical.setDocIdPatient(this.laboratoireEntete.getLabIdPatient());
            this.documentMedical.setDocCivilite(this.laboratoireEntete.getLabCivilite());
            this.documentMedical.setDocFam(this.laboratoireEntete.getLabFam());
            this.documentMedical.setDocService(this.laboratoireEntete.getLabLaboratoire());
            this.documentMedical.setDocDossier(this.laboratoireEntete.getPatients().getPatDossier());
            if (this.laboratoireEntete.getLabIdAssurance() != 0L) {
               this.documentMedical.setDocPrescripteur("ASS." + this.laboratoireEntete.getLabNomAssurance());
            } else if (this.laboratoireEntete.getLabIdSociete() != 0L) {
               this.documentMedical.setDocPrescripteur("SOC." + this.laboratoireEntete.getLabNomSociete());
            } else if (this.laboratoireEntete.getLabPecCnamgs() != 0.0F) {
               this.documentMedical.setDocPrescripteur("CNAMGS");
            } else {
               this.documentMedical.setDocPrescripteur("PRIVE");
            }

            if (this.laboratoireEntete.getLabIdAssurance() == 0L && this.laboratoireEntete.getLabIdSociete() == 0L && this.laboratoireEntete.getLabIdComplementaire() == 0L && this.laboratoireEntete.getLabPecCnamgs() == 0.0F && this.laboratoireEntete.getLabRegPatient() != 0.0D) {
               this.documentMedical.setDocRegPatient(this.laboratoireEntete.getLabRegPatient());
            } else {
               this.documentMedical.setDocRegPatient(0.0D);
            }

            this.documentMedical.setDocRegTiers(this.laboratoireEntete.getLabRegTiers());
            this.documentMedical.setDocCode(this.laboratoireLigne.getLabligProduit());
            this.documentMedical.setDocLibelleNature(this.laboratoireLigne.getLabligLibelle());
            this.documentMedical.setDocQte(this.laboratoireLigne.getLabligQte());
            if (var1 && var2) {
               var7 = false;

               for(var8 = 0; var8 < this.lesBaremes.size(); ++var8) {
                  if (((Baremes)this.lesBaremes.get(var8)).getBarType() == 2 && ((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit() != null && !((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit().isEmpty() && this.documentMedical.getDocCode() != null && !this.documentMedical.getDocCode().isEmpty() && ((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit().equals(this.documentMedical.getDocCode())) {
                     this.documentMedical.setDocPu(((Baremes)this.lesBaremes.get(var8)).getBarPrix());
                     var7 = true;
                     break;
                  }
               }

               if (!var7) {
                  this.documentMedical.setDocPu(this.laboratoireLigne.getLabligPu());
               }
            } else {
               this.documentMedical.setDocPu(this.laboratoireLigne.getLabligPu());
            }

            this.documentMedical.setDocRemise(this.baremes.getBarRemise());
            this.documentMedical.setDocCom(this.utilNombre.myRoundDevise(this.documentMedical.getDocPu() * (double)this.documentMedical.getDocQte() * (double)this.baremes.getBarRemise() / 100.0D, this.structureLog.getStrdevise()));
            if (this.laboratoireEntete.getLabEtat() <= 3) {
               this.documentMedical.setDocCom(0.0D);
            }

            this.lesDetailsCommissions.add(this.documentMedical);
         }
      }

   }

   public void calculCas9(boolean var1, boolean var2, List var3, List var4, List var5) {
      int var6;
      boolean var7;
      int var8;
      for(var6 = 0; var6 < var3.size(); ++var6) {
         this.consultationActes = (ConsultationActes)var3.get(var6);
         this.consultationEnteteGene = this.consultationActes.getConsultationEnteteGene();
         if (this.consultationEnteteGene.getCsgIdAssurance() != 0L || this.consultationEnteteGene.getCsgIdSociete() != 0L || this.consultationEnteteGene.getCsgIdComplementaire() != 0L || this.consultationEnteteGene.getCsgPecCnamgs() != 0.0F) {
            this.documentMedical = new DocumentMedical();
            this.documentMedical.setDocDate(this.consultationEnteteGene.getCsgDate());
            this.documentMedical.setDocNum(this.consultationEnteteGene.getCsgNum());
            this.documentMedical.setDocNature(71);
            this.documentMedical.setDocId(this.consultationActes.getCslactId());
            this.documentMedical.setDocObs(this.consultationEnteteGene.getCsgSerie());
            this.documentMedical.setDocNomPatient(this.consultationEnteteGene.getCsgNomPatient());
            this.documentMedical.setDocIdPatient(this.consultationEnteteGene.getCsgIdPatient());
            this.documentMedical.setDocCivilite(this.consultationEnteteGene.getCsgCivilite());
            this.documentMedical.setDocFam(this.consultationEnteteGene.getCsgFam());
            this.documentMedical.setDocService(this.consultationEnteteGene.getCsgService());
            this.documentMedical.setDocDossier(this.consultationEnteteGene.getPatients().getPatDossier());
            if (this.consultationEnteteGene.getCsgIdAssurance() != 0L) {
               this.documentMedical.setDocPrescripteur("ASS." + this.consultationEnteteGene.getCsgNomAssurance());
            } else if (this.consultationEnteteGene.getCsgIdSociete() != 0L) {
               this.documentMedical.setDocPrescripteur("SOC." + this.consultationEnteteGene.getCsgNomSociete());
            } else if (this.consultationEnteteGene.getCsgPecCnamgs() != 0.0F) {
               this.documentMedical.setDocPrescripteur("CNAMGS");
            } else {
               this.documentMedical.setDocPrescripteur("PRIVE");
            }

            if (this.consultationEnteteGene.getCsgIdAssurance() == 0L && this.consultationEnteteGene.getCsgIdSociete() == 0L && this.consultationEnteteGene.getCsgIdComplementaire() == 0L && this.consultationEnteteGene.getCsgPecCnamgs() == 0.0F && this.consultationEnteteGene.getCsgRegPatient() != 0.0D) {
               this.documentMedical.setDocRegPatient(this.consultationEnteteGene.getCsgRegPatient());
            } else {
               this.documentMedical.setDocRegPatient(0.0D);
            }

            this.documentMedical.setDocRegTiers(this.consultationEnteteGene.getCsgRegTiers());
            this.documentMedical.setDocCode(this.consultationActes.getCslactProduit());
            this.documentMedical.setDocLibelleNature(this.consultationActes.getCslactLibelle());
            this.documentMedical.setDocQte(this.consultationActes.getCslactQte());
            if (var1 && var2) {
               var7 = false;

               for(var8 = 0; var8 < this.lesBaremes.size(); ++var8) {
                  if (((Baremes)this.lesBaremes.get(var8)).getBarType() == 2 && ((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit() != null && !((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit().isEmpty() && this.documentMedical.getDocCode() != null && !this.documentMedical.getDocCode().isEmpty() && ((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit().equals(this.documentMedical.getDocCode())) {
                     this.documentMedical.setDocPu(((Baremes)this.lesBaremes.get(var8)).getBarPrix());
                     var7 = true;
                     break;
                  }
               }

               if (!var7) {
                  this.documentMedical.setDocPu(this.consultationActes.getCslactPu());
               }
            } else {
               this.documentMedical.setDocPu(this.consultationActes.getCslactPu());
            }

            this.documentMedical.setDocRemise(this.baremes.getBarRemise());
            this.documentMedical.setDocCom(this.utilNombre.myRoundDevise(this.documentMedical.getDocPu() * (double)this.documentMedical.getDocQte() * (double)this.baremes.getBarRemise() / 100.0D, this.structureLog.getStrdevise()));
            if (this.consultationEnteteGene.getCsgEtat() <= 3) {
               this.documentMedical.setDocCom(0.0D);
            }

            this.lesDetailsCommissions.add(this.documentMedical);
         }
      }

      for(var6 = 0; var6 < var4.size(); ++var6) {
         this.pharmacieLigne = (PharmacieLigne)var4.get(var6);
         this.pharmacieEntete = this.pharmacieLigne.getPharmacieEntete();
         if (this.pharmacieEntete.getPhaIdAssurance() != 0L || this.pharmacieEntete.getPhaIdSociete() != 0L || this.pharmacieEntete.getPhaIdComplementaire() != 0L || this.pharmacieEntete.getPhaPecCnamgs() != 0.0F) {
            this.documentMedical = new DocumentMedical();
            this.documentMedical.setDocDate(this.pharmacieEntete.getPhaDate());
            this.documentMedical.setDocNum(this.pharmacieEntete.getPhaNum());
            this.documentMedical.setDocNature(73);
            this.documentMedical.setDocId(this.pharmacieLigne.getPhaligId());
            this.documentMedical.setDocObs(this.pharmacieEntete.getPhaSerie());
            this.documentMedical.setDocNomPatient(this.pharmacieEntete.getPhaNomPatient());
            this.documentMedical.setDocIdPatient(this.pharmacieEntete.getPhaIdPatient());
            this.documentMedical.setDocCivilite(this.pharmacieEntete.getPhaCivilite());
            this.documentMedical.setDocFam(this.pharmacieEntete.getPhaFam());
            this.documentMedical.setDocService(this.pharmacieEntete.getPhaService());
            this.documentMedical.setDocDossier(this.pharmacieEntete.getPatients().getPatDossier());
            if (this.pharmacieEntete.getPhaIdAssurance() != 0L) {
               this.documentMedical.setDocPrescripteur("ASS." + this.pharmacieEntete.getPhaNomAssurance());
            } else if (this.pharmacieEntete.getPhaIdSociete() != 0L) {
               this.documentMedical.setDocPrescripteur("SOC." + this.pharmacieEntete.getPhaNomSociete());
            } else if (this.pharmacieEntete.getPhaPecCnamgs() != 0.0F) {
               this.documentMedical.setDocPrescripteur("CNAMGS");
            } else {
               this.documentMedical.setDocPrescripteur("PRIVE");
            }

            if (this.pharmacieEntete.getPhaIdAssurance() == 0L && this.pharmacieEntete.getPhaIdSociete() == 0L && this.pharmacieEntete.getPhaIdComplementaire() == 0L && this.pharmacieEntete.getPhaPecCnamgs() == 0.0F && this.pharmacieEntete.getPhaRegPatient() != 0.0D) {
               this.documentMedical.setDocRegPatient(this.pharmacieEntete.getPhaRegPatient());
            } else {
               this.documentMedical.setDocRegPatient(0.0D);
            }

            this.documentMedical.setDocRegTiers(this.pharmacieEntete.getPhaRegTiers());
            this.documentMedical.setDocCode(this.pharmacieLigne.getPhaligProduit());
            this.documentMedical.setDocLibelleNature(this.pharmacieLigne.getPhaligLibelle());
            this.documentMedical.setDocQte(this.pharmacieLigne.getPhaligQte());
            if (var1 && var2) {
               var7 = false;

               for(var8 = 0; var8 < this.lesBaremes.size(); ++var8) {
                  if (((Baremes)this.lesBaremes.get(var8)).getBarType() == 2 && ((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit() != null && !((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit().isEmpty() && this.documentMedical.getDocCode() != null && !this.documentMedical.getDocCode().isEmpty() && ((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit().equals(this.documentMedical.getDocCode())) {
                     this.documentMedical.setDocPu(((Baremes)this.lesBaremes.get(var8)).getBarPrix());
                     var7 = true;
                     break;
                  }
               }

               if (!var7) {
                  this.documentMedical.setDocPu(this.pharmacieLigne.getPhaligPu());
               }
            } else {
               this.documentMedical.setDocPu(this.pharmacieLigne.getPhaligPu());
            }

            this.documentMedical.setDocRemise(this.baremes.getBarRemise());
            this.documentMedical.setDocCom(this.utilNombre.myRoundDevise(this.documentMedical.getDocPu() * (double)this.documentMedical.getDocQte() * (double)this.baremes.getBarRemise() / 100.0D, this.structureLog.getStrdevise()));
            if (this.pharmacieEntete.getPhaEtat() <= 3) {
               this.documentMedical.setDocCom(0.0D);
            }

            this.lesDetailsCommissions.add(this.documentMedical);
         }
      }

      for(var6 = 0; var6 < var5.size(); ++var6) {
         this.laboratoireLigne = (LaboratoireLigne)var5.get(var6);
         this.laboratoireEntete = this.laboratoireLigne.getLaboratoireEntete();
         if (this.laboratoireEntete.getLabIdAssurance() != 0L || this.laboratoireEntete.getLabIdSociete() != 0L || this.laboratoireEntete.getLabIdComplementaire() != 0L || this.laboratoireEntete.getLabPecCnamgs() != 0.0F) {
            this.documentMedical = new DocumentMedical();
            this.documentMedical.setDocDate(this.laboratoireEntete.getLabDate());
            this.documentMedical.setDocNum(this.laboratoireEntete.getLabNum());
            this.documentMedical.setDocNature(74);
            this.documentMedical.setDocId(this.laboratoireLigne.getLabligId());
            this.documentMedical.setDocObs(this.laboratoireEntete.getLabSerie());
            this.documentMedical.setDocNomPatient(this.laboratoireEntete.getLabNomPatient());
            this.documentMedical.setDocIdPatient(this.laboratoireEntete.getLabIdPatient());
            this.documentMedical.setDocCivilite(this.laboratoireEntete.getLabCivilite());
            this.documentMedical.setDocFam(this.laboratoireEntete.getLabFam());
            this.documentMedical.setDocService(this.laboratoireEntete.getLabLaboratoire());
            this.documentMedical.setDocDossier(this.laboratoireEntete.getPatients().getPatDossier());
            if (this.laboratoireEntete.getLabIdAssurance() != 0L) {
               this.documentMedical.setDocPrescripteur("ASS." + this.laboratoireEntete.getLabNomAssurance());
            } else if (this.laboratoireEntete.getLabIdSociete() != 0L) {
               this.documentMedical.setDocPrescripteur("SOC." + this.laboratoireEntete.getLabNomSociete());
            } else if (this.laboratoireEntete.getLabPecCnamgs() != 0.0F) {
               this.documentMedical.setDocPrescripteur("CNAMGS");
            } else {
               this.documentMedical.setDocPrescripteur("PRIVE");
            }

            if (this.laboratoireEntete.getLabIdAssurance() == 0L && this.laboratoireEntete.getLabIdSociete() == 0L && this.laboratoireEntete.getLabIdComplementaire() == 0L && this.laboratoireEntete.getLabPecCnamgs() == 0.0F && this.laboratoireEntete.getLabRegPatient() != 0.0D) {
               this.documentMedical.setDocRegPatient(this.laboratoireEntete.getLabRegPatient());
            } else {
               this.documentMedical.setDocRegPatient(0.0D);
            }

            this.documentMedical.setDocRegTiers(this.laboratoireEntete.getLabRegTiers());
            this.documentMedical.setDocCode(this.laboratoireLigne.getLabligProduit());
            this.documentMedical.setDocLibelleNature(this.laboratoireLigne.getLabligLibelle());
            this.documentMedical.setDocQte(this.laboratoireLigne.getLabligQte());
            if (var1 && var2) {
               var7 = false;

               for(var8 = 0; var8 < this.lesBaremes.size(); ++var8) {
                  if (((Baremes)this.lesBaremes.get(var8)).getBarType() == 2 && ((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit() != null && !((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit().isEmpty() && this.documentMedical.getDocCode() != null && !this.documentMedical.getDocCode().isEmpty() && ((Baremes)this.lesBaremes.get(var8)).getBarCodeProduit().equals(this.documentMedical.getDocCode())) {
                     this.documentMedical.setDocPu(((Baremes)this.lesBaremes.get(var8)).getBarPrix());
                     var7 = true;
                     break;
                  }
               }

               if (!var7) {
                  this.documentMedical.setDocPu(this.laboratoireLigne.getLabligPu());
               }
            } else {
               this.documentMedical.setDocPu(this.laboratoireLigne.getLabligPu());
            }

            this.documentMedical.setDocRemise(this.baremes.getBarRemise());
            this.documentMedical.setDocCom(this.utilNombre.myRoundDevise(this.documentMedical.getDocPu() * (double)this.documentMedical.getDocQte() * (double)this.baremes.getBarRemise() / 100.0D, this.structureLog.getStrdevise()));
            if (this.laboratoireEntete.getLabEtat() <= 3) {
               this.documentMedical.setDocCom(0.0D);
            }

            this.lesDetailsCommissions.add(this.documentMedical);
         }
      }

   }

   public void calculReglement(Session var1) throws NamingException {
      new ArrayList();
      List var2 = this.reglementsDao.rechercheCommissions(this.inpDu, this.inpAu, var1);
      new Users();
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            this.reglements = new Reglements();
            this.reglements = (Reglements)var2.get(var4);
            if (this.reglements.getRglCommission() == 0.0D) {
               this.reglements.setCom_num(this.reglements.getRglNum());
               this.reglements.setCom_date(this.reglements.getRglDateReg());
               this.reglements.setCom_lastDatereg((Date)null);
               this.reglements.setCom_nbJour(0L);
               this.reglements.setCom_serie(this.reglements.getRglSerie());
               this.reglements.setCom_cat("");
               this.reglements.setCom_nomTiers(this.reglements.getRglNomTiers());
               this.reglements.setCom_idTiers(this.reglements.getRglIdTiers());
               this.reglements.setCom_civilite("");
               this.reglements.setCom_nomContact(this.reglements.getRglNomContact());
               this.reglements.setCom_idContact(this.reglements.getRglIdContact());
               this.reglements.setCom_civiliteContact("");
               this.reglements.setCom_nomResponsable(this.reglements.getRglNomResponsable());
               this.reglements.setCom_idResponsable(this.reglements.getRglIdResponsable());
               this.reglements.setCom_nomCommercial(this.reglements.getRglNomCommercial());
               this.reglements.setCom_idCommercial(this.reglements.getRglIdCommercial());
               this.reglements.setCom_nomEquipe(this.reglements.getRglNomEquipe());
               this.reglements.setCom_idEquipe(this.reglements.getRglIdEquipe());
               Users var3;
               if (this.reglements.getRglIdResponsable() != 0L && this.reglements.getRglIdCommercial() == 0L && this.reglements.getRglIdEquipe() == 0L) {
                  var3 = this.userDao.selectByIdUsers(this.reglements.getRglIdResponsable(), var1);
               } else if (this.reglements.getRglIdResponsable() == 0L && this.reglements.getRglIdCommercial() != 0L && this.reglements.getRglIdEquipe() == 0L) {
                  var3 = this.userDao.selectByIdUsers(this.reglements.getRglIdCommercial(), var1);
               } else if (this.reglements.getRglIdResponsable() == 0L && this.reglements.getRglIdCommercial() == 0L && this.reglements.getRglIdEquipe() != 0L) {
                  var3 = this.userDao.selectByIdUsers(this.reglements.getRglIdEquipe(), var1);
               } else if (this.reglements.getRglIdResponsable() != 0L) {
                  var3 = this.userDao.selectByIdUsers(this.reglements.getRglIdResponsable(), var1);
               } else if (this.reglements.getRglIdCommercial() != 0L) {
                  var3 = this.userDao.selectByIdUsers(this.reglements.getRglIdCommercial(), var1);
               } else if (this.reglements.getRglIdEquipe() != 0L) {
                  var3 = this.userDao.selectByIdUsers(this.reglements.getRglIdEquipe(), var1);
               } else {
                  var3 = this.usersLog;
               }

               if (var3.getUsrCommType() != 0) {
                  this.reglements.setVar_comPourcentage(0.0F);
                  this.listDetailReglement.add(this.reglements);
               }
            }
         }
      }

   }

   public void miseAJourMedecins(Session var1) throws HibernateException, NamingException {
      boolean var2 = true;
      String var3 = "";
      if (var2) {
         if (var3 == null || var3.isEmpty()) {
            var3 = this.calculChrono.numCompose(this.inpDu, this.nature, "", var1);
         }

         this.commissionEnteteVentes = new CommissionEnteteVentes();
         int var6;
         if (!this.var_anal_activite) {
            this.commissionEnteteVentes.setComActivite("");
         } else if (this.decoupageActivite) {
            String var4 = "";
            boolean var5 = true;
            if (this.lesDecoupagesActivites.size() != 0) {
               for(var6 = 0; var6 < this.lesDecoupagesActivites.size(); ++var6) {
                  this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var6);
                  if (this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie() != 0.0D) {
                     if (var5) {
                        var4 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                        var5 = false;
                     } else {
                        var4 = var4 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     }
                  }
               }
            }

            this.commissionEnteteVentes.setComActivite(var4);
         }

         this.commissionEnteteVentes.setComIdCommercial(this.inpIdMedecin);
         this.commissionEnteteVentes.setComNomCommercial(this.inpMedecin);
         this.commissionEnteteVentes.setComIdResponsable(0L);
         this.commissionEnteteVentes.setComNomResponsable("");
         this.commissionEnteteVentes.setComIdEquipe(0L);
         this.commissionEnteteVentes.setComNomEquipe("");
         this.commissionEnteteVentes.setComAnal2("");
         this.commissionEnteteVentes.setComAnal4("");
         this.commissionEnteteVentes.setComArrondiReg(0);
         this.commissionEnteteVentes.setComConditionReg("");
         this.commissionEnteteVentes.setComDateAnnule((Date)null);
         this.commissionEnteteVentes.setComDateCreat(new Date());
         this.commissionEnteteVentes.setComDate(this.inpDate);
         this.commissionEnteteVentes.setComDateDebut(this.inpDu);
         this.commissionEnteteVentes.setComDateEcheReg((Date)null);
         this.commissionEnteteVentes.setComDateFin(this.inpAu);
         this.commissionEnteteVentes.setComDateImp((Date)null);
         this.commissionEnteteVentes.setComDateLastReg((Date)null);
         this.commissionEnteteVentes.setComDateModif((Date)null);
         this.commissionEnteteVentes.setComDateTransfert((Date)null);
         this.commissionEnteteVentes.setComDateValidite((Date)null);
         this.commissionEnteteVentes.setComDepartement("");
         this.commissionEnteteVentes.setComGele(0);
         this.commissionEnteteVentes.setComIdCreateur(this.usersLog.getUsrid());
         this.commissionEnteteVentes.setComIdModif(0L);
         this.commissionEnteteVentes.setComModeReg("");
         this.commissionEnteteVentes.setComModeleImp("");
         this.commissionEnteteVentes.setComMotifAnnule("");
         this.commissionEnteteVentes.setComNbJourReg(0);
         this.commissionEnteteVentes.setComNomCreateur(this.usersLog.getUsrNom());
         this.commissionEnteteVentes.setComNum(var3);
         this.commissionEnteteVentes.setComService("");
         this.commissionEnteteVentes.setComSite("");
         this.commissionEnteteVentes.setComSolde(0);
         this.commissionEnteteVentes.setComTotCommission(0.0D);
         this.commissionEnteteVentes.setComTotReglement(0.0D);
         this.commissionEnteteVentes.setComTypeReg(0);
         this.commissionEnteteVentes.setExerciceventes(this.exercicesVentes);
         this.verifieExistenceHabilitation(var1);
         this.commissionEnteteVentes = this.commissionEnteteVentesDao.insert(this.commissionEnteteVentes, var1);
         double var12 = 0.0D;
         if (this.lesDetailsCommissions.size() != 0) {
            this.consultationActes = new ConsultationActes();

            for(var6 = 0; var6 < this.lesDetailsCommissions.size(); ++var6) {
               this.documentMedical = (DocumentMedical)this.lesDetailsCommissions.get(var6);
               this.commissionLigneVentes = new CommissionLigneVentes();
               this.commissionLigneVentes.setComligNature(this.documentMedical.getDocNature());
               this.commissionLigneVentes.setComligIdligne(this.documentMedical.getDocId());
               this.commissionLigneVentes.setComligNum(this.documentMedical.getDocNum());
               this.commissionLigneVentes.setComligDate(this.documentMedical.getDocDate());
               this.commissionLigneVentes.setComligService(this.documentMedical.getDocService());
               this.commissionLigneVentes.setComligDateLastReg((Date)null);
               this.commissionLigneVentes.setComligNbJour(0L);
               this.commissionLigneVentes.setComligSerie(this.documentMedical.getDocObs());
               this.commissionLigneVentes.setComligCat("" + this.documentMedical.getDocFam());
               this.commissionLigneVentes.setComligNomTiers(this.documentMedical.getDocNomPatient());
               this.commissionLigneVentes.setComligIdTiers(this.documentMedical.getDocIdPatient());
               this.commissionLigneVentes.setComligCivilTiers(this.documentMedical.getDocCivilite());
               this.commissionLigneVentes.setComligNomContact(this.documentMedical.getDocDossier());
               this.commissionLigneVentes.setComligIdContact(0L);
               this.commissionLigneVentes.setComligCivilContact("");
               this.commissionLigneVentes.setComligNomResponsable("");
               this.commissionLigneVentes.setComligIdResponsable(0L);
               this.commissionLigneVentes.setComligNomCommercial("");
               this.commissionLigneVentes.setComligIdCommercial(0L);
               this.commissionLigneVentes.setComligNomEquipe(this.documentMedical.getDocPrescripteur());
               this.commissionLigneVentes.setComligIdEquipe(0L);
               this.commissionLigneVentes.setComligCode(this.documentMedical.getDocCode());
               this.commissionLigneVentes.setComligLibelle(this.documentMedical.getDocLibelleNature());
               this.commissionLigneVentes.setComligQte(this.documentMedical.getDocQte());
               this.commissionLigneVentes.setComligTotHt(this.documentMedical.getDocPu());
               this.commissionLigneVentes.setComligComPourcentage(this.documentMedical.getDocRemise());
               this.commissionLigneVentes.setComligTotCommission(this.documentMedical.getDocCom());
               this.commissionLigneVentes.setComligPayePatient(this.documentMedical.getDocRegPatient());
               this.commissionLigneVentes.setComligPayeTier(this.documentMedical.getDocRegTiers());
               if (this.commissionLigneVentes.getComligPayePatient() == 0.0D && this.commissionLigneVentes.getComligPayeTier() == 0.0D) {
                  this.commissionLigneVentes.setComligTotCommissionReel(0.0D);
               } else {
                  this.commissionLigneVentes.setComligTotCommissionReel(this.commissionLigneVentes.getComligTotCommission());
               }

               this.commissionLigneVentes.setCommissionEnteteVentes(this.commissionEnteteVentes);
               this.commissionLigneVentes = this.commissionLigneVentesDao.insertLigne(this.commissionLigneVentes, var1);
               var12 += this.commissionLigneVentes.getComligTotCommissionReel();
            }

            String var13 = "";
            float var7 = 0.0F;
            new ArrayList();
            TaxesVentesDao var9 = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
            List var8 = var9.selectActifTaxes(this.exercicesVentes.getExevteId(), var1);
            if (var8.size() != 0) {
               for(int var10 = 0; var10 < var8.size(); ++var10) {
                  if (((TaxesVentes)var8.get(var10)).getTaxvteType() == 2) {
                     var13 = ((TaxesVentes)var8.get(var10)).getTaxvteCode();
                     var7 = ((TaxesVentes)var8.get(var10)).getTaxvteTaux();
                     break;
                  }
               }
            }

            this.commissionEnteteVentes.setComTotCommission(var12);
            this.commissionEnteteVentes.setComTauxTaxe(var7);
            double var14 = this.commissionEnteteVentes.getComTotCommission() * (double)this.commissionEnteteVentes.getComTauxTaxe() / 100.0D;
            this.commissionEnteteVentes.setComTotTaxe(this.utilNombre.myRoundDevise(var14, this.structureLog.getStrdevise()));
            this.commissionEnteteVentes.setComNetPayer(this.commissionEnteteVentes.getComTotCommission() - this.commissionEnteteVentes.getComTotTaxe());
            this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes, var1);
         }
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.commissionEnteteVentes.setComEtatVal(1);
         this.commissionEnteteVentes.setComEtat(0);
         this.commissionEnteteVentes.setComDateValide((Date)null);
         return true;
      } else {
         this.commissionEnteteVentes.setComEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.commissionEnteteVentes.setComEtat(1);
               this.commissionEnteteVentes.setComDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.commissionEnteteVentes.setComEtat(0);
               this.commissionEnteteVentes.setComDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void supprimerCommission() throws HibernateException, NamingException, ParseException {
      if (this.commissionEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CommissionEnteteMedical");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.commissionEnteteVentes.getComEtat() == 0) {
               this.suppressionCommissionSuite(var1);
            }

            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.executerRequete((Session)null);
         this.visibiliteBton = false;
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
      }

   }

   public void suppressionCommissionSuite(Session var1) throws HibernateException, NamingException {
      long var2 = this.commissionEnteteVentes.getComId();
      this.commissionEnteteVentes = this.commissionEnteteVentesDao.pourParapheur(var2, var1);
      int var4;
      if (this.listDetailReglement.size() != 0) {
         for(var4 = 0; var4 < this.listDetailReglement.size(); ++var4) {
            this.reglements = (Reglements)this.listDetailReglement.get(var4);
            this.reglementsDao.delete(this.reglements, var1);
         }
      }

      this.listDetailCommission.clear();
      this.listDetailCommission = this.commissionLigneVentesDao.chargerLesLignes(this.commissionEnteteVentes, var1);
      if (this.listDetailCommission.size() != 0) {
         for(var4 = 0; var4 < this.listDetailCommission.size(); ++var4) {
            this.commissionLigneVentes = new CommissionLigneVentes();
            this.commissionLigneVentes = (CommissionLigneVentes)this.listDetailCommission.get(var4);
            this.commissionLigneVentesDao.deleteOneLigne(this.commissionLigneVentes, var1);
         }
      }

      this.commissionEnteteVentesDao.delete(this.commissionEnteteVentes, var1);
   }

   public void rechercheResponsable() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.rechercheResponsable(this.inpResponsable, this.nature);
      if (this.responsable != null) {
         if (this.responsable.getUsrid() != 0L) {
            this.calculeResponsable();
         } else {
            this.var_action = 11;
         }
      } else if (this.responsable == null) {
         this.calculeResponsable();
      }

   }

   public void recuperationResponsable() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.calculeResponsable();
      this.calculeResponsable();
   }

   public void calculeResponsable() throws JDOMException, IOException {
      if (this.responsable != null) {
         this.inpResponsable = this.responsable.getUsrPatronyme();
         this.inpIdResponsable = this.responsable.getUsrid();
      } else {
         this.inpResponsable = "";
         this.inpIdResponsable = 0L;
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleResponsable() {
      this.inpResponsable = "";
      this.inpIdResponsable = 0L;
      this.var_action = this.var_memo_action;
   }

   public void rechercheMedecin() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.rechercheCommercial(this.inpMedecin, this.nature);
      if (this.responsable != null) {
         if (this.responsable.getUsrid() != 0L) {
            this.calculeMedecin();
         } else {
            this.var_action = 17;
         }
      } else if (this.responsable == null) {
         this.calculeMedecin();
      }

   }

   public void recuperationMedecin() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.calculeCommercial();
      this.calculeMedecin();
   }

   public void calculeMedecin() throws JDOMException, IOException {
      if (this.responsable != null) {
         this.inpMedecin = this.responsable.getUsrPatronyme();
         this.inpIdMedecin = this.responsable.getUsrid();
      } else {
         this.inpMedecin = "";
         this.inpIdMedecin = 0L;
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleMedecin() {
      this.inpMedecin = "";
      this.inpIdMedecin = 0L;
      this.var_action = this.var_memo_action;
   }

   public void effaceliste() {
      this.lesAnalyses.clear();
   }

   public void executerRequeteAnalyse() throws HibernateException, NamingException {
      this.lesAnalyses.clear();
      if (this.inpAu != null && this.inpDu != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         String var2 = "";
         String var3 = "";
         String var4 = "";
         String var5 = this.utilDate.dateToStringSQLLight(this.inpDu) + " 00:00:00";
         String var6 = this.utilDate.dateToStringSQLLight(this.inpAu) + " 23:59:59";
         new ArrayList();
         Object var8 = new ArrayList();
         Object var9 = new ArrayList();
         Object var10 = new ArrayList();
         Object var11 = new ArrayList();
         Object var12 = new ArrayList();
         Object var13 = new ArrayList();
         Object var14 = new ArrayList();
         Object var15 = new ArrayList();
         Object var16 = new ArrayList();
         Object var17 = new ArrayList();
         if (this.inpType == 71 || this.inpType == 711 || this.inpType == 712 || this.inpType == 713 || this.inpType == 990 || this.inpType == 991 || this.inpType == 999) {
            var2 = "csgDate>='" + var5 + "' and csgDate<='" + var6 + "'";
            var3 = "ConsultationEnteteGene.csgDate>='" + var5 + "' and ConsultationEnteteGene.csgDate<='" + var6 + "'";
            var4 = "consultationEnteteGene.csgDate>='" + var5 + "' and consultationEnteteGene.csgDate<='" + var6 + "'";
            if (this.inpIdResponsable != 0L) {
               var2 = var2 + " and csgIdCreateur=" + this.inpIdResponsable;
               var3 = var3 + " and ConsultationEnteteGene.csgIdCreateur=" + this.inpIdResponsable;
               var4 = var4 + " and consultationEnteteGene.csgIdCreateur=" + this.inpIdResponsable;
            }

            if (!this.infirmerie) {
               if (this.inpType == 990) {
                  var2 = var2 + " and (csgIdAssurance=0 and csgIdComplementaire=0 and csgIdSociete=0 and csgPecCnamgs=0)";
                  var3 = var3 + " and (ConsultationEnteteGene.csgIdAssurance=0 and ConsultationEnteteGene.csgIdComplementaire=0 and ConsultationEnteteGene.csgIdSociete=0 and ConsultationEnteteGene.csgPecCnamgs=0)";
                  var4 = var4 + " and (ConsultationEnteteGene.csgIdAssurance=0 and ConsultationEnteteGene.csgIdComplementaire=0 and ConsultationEnteteGene.csgIdSociete=0 and ConsultationEnteteGene.csgPecCnamgs=0)";
               } else if (this.inpType == 991) {
                  var2 = var2 + " and (csgIdAssurance<>0 or csgIdComplementaire<>0 or csgIdSociete<>0 or csgPecCnamgs<>0)";
                  var3 = var3 + " and (ConsultationEnteteGene.csgIdAssurance<>0 or ConsultationEnteteGene.csgIdComplementaire<>0 or ConsultationEnteteGene.csgIdSociete<>0 or ConsultationEnteteGene.csgPecCnamgs<>0)";
                  var4 = var4 + " and (ConsultationEnteteGene.csgIdAssurance<>0 or ConsultationEnteteGene.csgIdComplementaire<>0 or ConsultationEnteteGene.csgIdSociete<>0 or ConsultationEnteteGene.csgPecCnamgs<>0)";
               }

               var2 = var2 + " and (csgEtat=5 or csgEtat=6)";
               var3 = var3 + " and (ConsultationEnteteGene.csgEtat=5 or ConsultationEnteteGene.csgEtat=6)";
               var4 = var4 + " and (consultationEnteteGene.csgEtat=5 or consultationEnteteGene.csgEtat=6)";
            }

            if (this.inpMode == 3 && (this.inpType == 71 || this.inpType == 990 || this.inpType == 991 || this.inpType == 999)) {
               var9 = this.consultationActesDao.chargerConsultationByRequete(var3, var1);
            } else if (this.inpMode == 3 && (this.inpType == 711 || this.inpType == 990 || this.inpType == 991 || this.inpType == 999)) {
               var13 = this.pharmacieLigneDao.chargerPharmacieByRequete(var4, var1);
            } else if (this.inpMode != 3 || this.inpType != 712 && this.inpType != 990 && this.inpType != 991 && this.inpType != 999) {
               if (this.inpMode == 3 && (this.inpType == 713 || this.inpType == 990 || this.inpType == 991 || this.inpType == 999)) {
                  var11 = this.consultationLaboDao.chargerConsultationByRequete(var3, var1);
               } else if (this.inpMode != 3) {
                  var8 = this.consultationEnteteGeneDao.chargerConsultationByRequete(var2, var1);
               }
            } else {
               var10 = this.consultationOrdoDao.chargerConsultationByRequete(var3, var1);
            }
         }

         if (this.inpType == 73 || this.inpType == 990 || this.inpType == 991 || this.inpType == 999) {
            var2 = "phaDate>='" + var5 + "' and phaDate<='" + var6 + "'";
            var3 = "pharmacieEntete.phaDate>='" + var5 + "' and pharmacieEntete.phaDate<='" + var6 + "'";
            if (this.inpIdResponsable != 0L) {
               var2 = var2 + " and phaIdCreateur=" + this.inpIdResponsable;
               var3 = var3 + " and pharmacieEntete.phaIdCreateur=" + this.inpIdResponsable;
            }

            if (!this.infirmerie) {
               if (this.inpType == 990) {
                  var2 = var2 + " and (phaIdAssurance=0 and phaIdComplementaire=0 and phaIdSociete=0 and phaPecCnamgs=0)";
                  var3 = var3 + " and (pharmacieEntete.phaIdAssurance=0 and pharmacieEntete.phaIdComplementaire=0 and pharmacieEntete.phaIdSociete=0 and pharmacieEntete.phaPecCnamgs=0)";
               } else if (this.inpType == 991) {
                  var2 = var2 + " and (phaIdAssurance<>0 or phaIdComplementaire<>0 or phaIdSociete<>0 or phaPecCnamgs<>0)";
                  var3 = var3 + " and (pharmacieEntete.phaIdAssurance<>0 or pharmacieEntete.phaIdComplementaire<>0 or pharmacieEntete.phaIdSociete<>0 or pharmacieEntete.phaPecCnamgs<>0)";
               }

               var2 = var2 + " and (phaEtat= 5 or phaEtat= 6)";
               var3 = var3 + " and (pharmacieEntete.phaEtat=5 or pharmacieEntete.phaEtat=6)";
            }

            if (this.inpMode == 3) {
               this.listDetailPharmacie = this.pharmacieLigneDao.chargerPharmacieByRequete(var3, var1);
            } else {
               var12 = this.pharmacieEnteteDao.chargerPharmacieByRequete(var2, var1);
            }
         }

         if (this.inpType == 74 || this.inpType == 990 || this.inpType == 991 || this.inpType == 999) {
            var2 = "labDate>='" + var5 + "' and labDate<='" + var6 + "'";
            var3 = "laboratoireEntete.labDate>='" + var5 + "' and laboratoireEntete.labDate<='" + var6 + "'";
            if (this.inpIdResponsable != 0L) {
               var2 = var2 + " and labIdCreateur=" + this.inpIdResponsable;
               var3 = var3 + " and laboratoireEntete.labIdCreateur=" + this.inpIdResponsable;
            }

            if (!this.infirmerie) {
               if (this.inpType == 990) {
                  var2 = var2 + " and (labIdAssurance=0 and labIdComplementaire=0 and labIdSociete=0 and labPecCnamgs=0)";
                  var3 = var3 + " and (laboratoireEntete.labIdAssurance=0 and laboratoireEntete.labIdComplementaire=0 and laboratoireEntete.labIdSociete=0 and laboratoireEntete.labPecCnamgs=0)";
               } else if (this.inpType == 991) {
                  var2 = var2 + " and (labIdAssurance<>0 or labIdComplementaire<>0 or labIdSociete<>0 or labPecCnamgs<>0)";
                  var3 = var3 + " and (laboratoireEntete.labIdAssurance<>0 or laboratoireEntete.labIdComplementaire<>0 or laboratoireEntete.labIdSociete<>0 or laboratoireEntete.labPecCnamgs<>0)";
               }

               var2 = var2 + " and (labEtat=5 or labEtat=6)";
               var3 = var3 + " and (laboratoireEntete.labEtat=5 or laboratoireEntete.labEtat=6)";
            }

            if (this.inpMode == 3) {
               this.listDetailLaboratoire = this.laboratoireLigneDao.chargerLaboratoireByRequete(var3, var1);
            } else {
               var14 = this.laboratoireEnteteDao.chargerLaboratoireByRequete(var2, var1);
            }
         }

         if (this.inpType == 76 || this.inpType == 990 || this.inpType == 991 || this.inpType == 999) {
            var2 = "hosDateEntree>='" + var5 + "' and hosDateEntree<='" + var6 + "'";
            var3 = "HospitalisationEntete.hosDateEntree>='" + var5 + "' and HospitalisationEntete.hosDateEntree<='" + var6 + "'";
            if (this.inpIdResponsable != 0L) {
               var2 = var2 + " and hosIdCreateur=" + this.inpIdResponsable;
               var3 = var3 + " and HospitalisationEntete.hosIdCreateur=" + this.inpIdResponsable;
            }

            if (!this.infirmerie) {
               if (this.inpType == 990) {
                  var2 = var2 + " and (hosIdAssurance=0 and hosIdComplementaire=0 and hosIdSociete=0 and hosPecCnamgs=0)";
                  var3 = var3 + " and (HospitalisationEntete.hosIdAssurance=0 and HospitalisationEntete.hosIdComplementaire=0 and HospitalisationEntete.hosIdSociete=0 and HospitalisationEntete.hosPecCnamgs=0)";
               } else if (this.inpType == 991) {
                  var2 = var2 + " and (hosIdAssurance<>0 or hosIdComplementaire<>0 or hosIdSociete<>0 or hosPecCnamgs<>0)";
                  var3 = var3 + " and (HospitalisationEntete.hosIdAssurance<>0 or HospitalisationEntete.hosIdComplementaire<>0 or HospitalisationEntete.hosIdSociete<>0 or HospitalisationEntete.hosPecCnamgs<>0)";
               }

               var2 = var2 + " and (hosEtat=5 or hosEtat=6)";
               var3 = var3 + " and (HospitalisationEntete.hosEtat=5 or HospitalisationEntete.hosEtat=6)";
            }

            if (this.inpMode == 3) {
               this.listDetailHospitalisation = this.hospitalisationActesDao.chargerActesByRequete(var3, var1);
            } else {
               var15 = this.hospitalisationEnteteDao.chargerHospitalisationByRequete(var2, var1);
            }
         }

         if (this.inpType == 78) {
            var2 = "facDate>='" + var5 + "' and facDate<='" + var6 + "'";
            var3 = "factureEnteteMedical.facDate>='" + var5 + "' and factureEnteteMedical.facDate<='" + var6 + "'";
            if (this.inpIdResponsable != 0L) {
               var2 = var2 + " and facIdCreateur=" + this.inpIdResponsable;
               var3 = var3 + " and factureEnteteMedical.facIdCreateur=" + this.inpIdResponsable;
            }

            if (this.inpMode == 3) {
               this.listDetailRefacturation = this.factureLigneMedicalDao.rechercheFactureRequete(var3, var1);
            } else {
               var16 = this.factureEnteteMedicalDao.rechercheFactureRequete(var2, var1);
            }
         }

         if (this.inpType == 181) {
            var2 = "ndbDate>='" + var5 + "' and ndbDate<='" + var6 + "'";
            var3 = "noteDebitEnteteVentes.ndbDate>='" + var5 + "' and noteDebitEnteteVentes.ndbDate<='" + var6 + "'";
            if (this.inpIdResponsable != 0L) {
               var2 = var2 + " and ndbIdCreateur=" + this.inpIdResponsable;
               var3 = var3 + " and noteDebitEnteteVentes.ndbIdCreateur=" + this.inpIdResponsable;
            }

            if (this.inpMode == 3) {
               this.listDetailFactureExterne = this.noteDebitLigneVentesDao.rechercheNoteDebitRequete(var3, var1);
            } else {
               var17 = this.noteDebitEnteteVentesDao.rechercheNoteDebitRequete(var2, var1);
            }
         }

         this.utilInitHibernate.closeSession();
         if ((this.inpType == 71 || this.inpType == 990 || this.inpType == 991 || this.inpType == 999) && this.inpMode != 3) {
            this.analyseConsultations((List)var8, (List)null, (List)null, (List)null, (List)null);
         }

         if ((this.inpType == 71 || this.inpType == 990 || this.inpType == 991 || this.inpType == 999) && this.inpMode == 3) {
            this.analyseConsultations((List)var8, (List)var9, (List)null, (List)null, (List)null);
         }

         if ((this.inpType == 711 || this.inpType == 999) && this.inpMode == 3) {
            this.analyseConsultations((List)var8, (List)null, (List)var13, (List)null, (List)null);
         }

         if ((this.inpType == 712 || this.inpType == 999) && this.inpMode == 3) {
            this.analyseConsultations((List)var8, (List)null, (List)null, (List)var10, (List)null);
         }

         if ((this.inpType == 713 || this.inpType == 999) && this.inpMode == 3) {
            this.analyseConsultations((List)var8, (List)null, (List)null, (List)null, (List)var11);
         }

         if ((this.inpType == 73 || this.inpType == 990 || this.inpType == 991 || this.inpType == 999) && this.inpMode != 3) {
            this.analysePharmacie((List)var12, (List)null);
         }

         if ((this.inpType == 73 || this.inpType == 990 || this.inpType == 991 || this.inpType == 999) && this.inpMode == 3) {
            this.analysePharmacie((List)var12, this.listDetailPharmacie);
         }

         if ((this.inpType == 74 || this.inpType == 990 || this.inpType == 991 || this.inpType == 999) && this.inpMode != 3) {
            this.analyseLaboratoires((List)var14, (List)null);
         }

         if ((this.inpType == 74 || this.inpType == 990 || this.inpType == 991 || this.inpType == 999) && this.inpMode == 3) {
            this.analyseLaboratoires((List)var14, this.listDetailLaboratoire);
         }

         if ((this.inpType == 76 || this.inpType == 990 || this.inpType == 991 || this.inpType == 999) && this.inpMode != 3) {
            this.analyseHospitalisations((List)var15, (List)null);
         }

         if ((this.inpType == 76 || this.inpType == 990 || this.inpType == 991 || this.inpType == 999) && this.inpMode == 3) {
            this.analyseHospitalisations((List)var15, this.listDetailHospitalisation);
         }

         if ((this.inpType == 78 || this.inpType == 999) && this.inpMode != 3) {
            this.analyseRefacturation((List)var16, (List)null);
         }

         if ((this.inpType == 78 || this.inpType == 999) && this.inpMode == 3) {
            this.analyseRefacturation((List)var16, this.listDetailRefacturation);
         }

         if ((this.inpType == 181 || this.inpType == 999) && this.inpMode != 3) {
            this.analyseFactureExternes((List)var17, (List)null);
         }

         if ((this.inpType == 181 || this.inpType == 999) && this.inpMode == 3) {
            this.analyseFactureExternes((List)var17, this.listDetailFactureExterne);
         }

         this.calculTotal();
      }

      this.dataModelAnalyse.setWrappedData(this.lesAnalyses);
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void analyseConsultations(List var1, List var2, List var3, List var4, List var5) {
      String var6 = "";
      float var7 = 1.0F;
      boolean var8 = false;
      this.documentEntete = new DocumentEntete();
      int var9;
      int var10;
      if (this.inpMode == 3 && this.inpType == 71) {
         var6 = "";
         var7 = 0.0F;

         for(var9 = 0; var9 < var2.size(); ++var9) {
            var6 = ((ConsultationActes)var2.get(var9)).getCslactLibelle();
            this.consultationEnteteGene = ((ConsultationActes)var2.get(var9)).getConsultationEnteteGene();
            if (var6 == null || var6.isEmpty()) {
               var6 = "Acte non défini";
            }

            var7 = ((ConsultationActes)var2.get(var9)).getCslactQte();
            var8 = false;

            for(var10 = 0; var10 < this.lesAnalyses.size(); ++var10) {
               this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var10);
               if (this.documentEntete.getDocLibelle().equals(var6)) {
                  var8 = true;
                  break;
               }
            }

            this.ligneConsultation(var8, var6, var7);
         }
      } else if (this.inpMode == 3 && this.inpType == 711) {
         var6 = "";
         var7 = 0.0F;

         for(var9 = 0; var9 < var3.size(); ++var9) {
            var6 = ((PharmacieLigne)var3.get(var9)).getPhaligLibelle();
            this.consultationEnteteGene = ((PharmacieLigne)var3.get(var9)).getConsultationEnteteGene();
            if (var6 == null || var6.isEmpty()) {
               var6 = "Produit non défini";
            }

            var7 = ((PharmacieLigne)var3.get(var9)).getPhaligQte();
            var8 = false;

            for(var10 = 0; var10 < this.lesAnalyses.size(); ++var10) {
               this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var10);
               if (this.documentEntete.getDocLibelle().equals(var6)) {
                  var8 = true;
                  break;
               }
            }

            this.ligneConsultation(var8, var6, var7);
         }
      } else if (this.inpMode == 3 && this.inpType == 712) {
         var6 = "";
         var7 = 0.0F;

         for(var9 = 0; var9 < var4.size(); ++var9) {
            var6 = ((ConsultationOrdo)var4.get(var9)).getCslordLibelle();
            this.consultationEnteteGene = ((ConsultationOrdo)var4.get(var9)).getConsultationEnteteGene();
            if (var6 == null || var6.isEmpty()) {
               var6 = "Produit non défini";
            }

            var7 = (float)((ConsultationOrdo)var4.get(var9)).getCslordQte();
            var8 = false;

            for(var10 = 0; var10 < this.lesAnalyses.size(); ++var10) {
               this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var10);
               if (this.documentEntete.getDocLibelle().equals(var6)) {
                  var8 = true;
                  break;
               }
            }

            this.ligneConsultation(var8, var6, var7);
         }
      } else if (this.inpMode == 3 && this.inpType == 713) {
         var6 = "";
         var7 = 0.0F;

         for(var9 = 0; var9 < var5.size(); ++var9) {
            var6 = ((ConsultationLabo)var5.get(var9)).getCsllabLibelle();
            this.consultationEnteteGene = ((ConsultationLabo)var5.get(var9)).getConsultationEnteteGene();
            if (var6 == null || var6.isEmpty()) {
               var6 = "Examen non défini";
            }

            var7 = 1.0F;
            var8 = false;

            for(var10 = 0; var10 < this.lesAnalyses.size(); ++var10) {
               this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var10);
               if (this.documentEntete.getDocLibelle().equals(var6)) {
                  var8 = true;
                  break;
               }
            }

            this.ligneConsultation(var8, var6, var7);
         }
      } else {
         for(var9 = 0; var9 < var1.size(); ++var9) {
            this.consultationEnteteGene = (ConsultationEnteteGene)var1.get(var9);
            var8 = false;
            if (this.lesAnalyses.size() != 0) {
               if (this.inpMode == 0) {
                  for(var10 = 0; var10 < this.lesAnalyses.size(); ++var10) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var10);
                     if (this.documentEntete.getDocIdResponsable() == this.consultationEnteteGene.getCsgIdCreateur()) {
                        var8 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 1) {
                  for(var10 = 0; var10 < this.lesAnalyses.size(); ++var10) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var10);
                     if (this.documentEntete.getDocIdCommercial() == this.consultationEnteteGene.getCsgIdMedecin()) {
                        var8 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 2) {
                  if (this.consultationEnteteGene.getCsgService() == null || this.consultationEnteteGene.getCsgService().isEmpty()) {
                     this.consultationEnteteGene.setCsgService("Service non défini");
                  }

                  for(var10 = 0; var10 < this.lesAnalyses.size(); ++var10) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var10);
                     if (this.documentEntete.getDocService().equals(this.consultationEnteteGene.getCsgService())) {
                        var8 = true;
                        break;
                     }
                  }
               } else if (this.inpMode != 4) {
                  int var11;
                  String var12;
                  if (this.inpMode == 5) {
                     var12 = "Motif de sortie non défini";

                     for(var11 = 0; var11 < this.lesAnalyses.size(); ++var11) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var11);
                        if (this.documentEntete.getDocSite() != null && !this.documentEntete.getDocSite().isEmpty() && this.documentEntete.getDocSite().equals(var12)) {
                           var8 = true;
                           break;
                        }
                     }
                  } else if (this.inpMode == 6) {
                     for(var10 = 0; var10 < this.lesAnalyses.size(); ++var10) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var10);
                        if (this.documentEntete.getDocIdEquipe() == this.consultationEnteteGene.getCsgIdPatient()) {
                           var8 = true;
                           break;
                        }
                     }
                  } else if (this.inpMode == 7) {
                     for(var10 = 0; var10 < this.lesAnalyses.size(); ++var10) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var10);
                        if (this.consultationEnteteGene.getCsgIdAssurance() != 0L && this.consultationEnteteGene.getCsgIdAssurance() == this.documentEntete.getDocIdPayeur()) {
                           var8 = true;
                           break;
                        }

                        if (this.consultationEnteteGene.getCsgIdSociete() != 0L && this.consultationEnteteGene.getCsgIdSociete() == this.documentEntete.getDocIdPayeur()) {
                           var8 = true;
                           break;
                        }

                        if (this.consultationEnteteGene.getCsgIdComplementaire() != 0L && this.consultationEnteteGene.getCsgIdComplementaire() == this.documentEntete.getDocIdPayeur()) {
                           var8 = true;
                           break;
                        }

                        if (this.consultationEnteteGene.getCsgPecCnamgs() != 0.0F && this.documentEntete.getDocIdPayeur() == -1L) {
                           var8 = true;
                           break;
                        }

                        if (this.documentEntete.getDocIdPayeur() == 999999L) {
                           var8 = true;
                           break;
                        }
                     }
                  } else if (this.inpMode == 8) {
                     var12 = "Pathologie non définie";

                     for(var11 = 0; var11 < this.lesAnalyses.size(); ++var11) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var11);
                        if (this.documentEntete.getDocBudget() != null && !this.documentEntete.getDocBudget().isEmpty() && this.documentEntete.getDocBudget().equals(var12)) {
                           var8 = true;
                           break;
                        }
                     }
                  }
               } else {
                  if (this.consultationEnteteGene.getCsgEntree() == null || this.consultationEnteteGene.getCsgEntree().isEmpty()) {
                     this.consultationEnteteGene.setCsgEntree("Motif d`entrée non défini");
                  }

                  for(var10 = 0; var10 < this.lesAnalyses.size(); ++var10) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var10);
                     if (this.documentEntete.getDocSource().equals(this.consultationEnteteGene.getCsgEntree())) {
                        var8 = true;
                        break;
                     }
                  }
               }
            }

            this.ligneConsultation(var8, var6, var7);
         }
      }

   }

   public void ligneConsultation(Boolean var1, String var2, float var3) {
      if (!var1) {
         this.documentEntete = new DocumentEntete();
         this.documentEntete.setDocIdResponsable(this.consultationEnteteGene.getCsgIdCreateur());
         this.documentEntete.setDocNomResponsable(this.consultationEnteteGene.getCsgNomCreateur());
         this.documentEntete.setDocIdCommercial(this.consultationEnteteGene.getCsgIdMedecin());
         this.documentEntete.setDocNomCommercial(this.consultationEnteteGene.getCsgMedecin());
         this.documentEntete.setDocIdEquipe(this.consultationEnteteGene.getCsgIdPatient());
         this.documentEntete.setDocNomEquipe(this.consultationEnteteGene.getCsgNomPatient());
         this.documentEntete.setDocBudget(this.consultationEnteteGene.getCsgPathologie());
         if (this.consultationEnteteGene.getCsgIdAssurance() != 0L) {
            this.documentEntete.setDocIdPayeur(this.consultationEnteteGene.getCsgIdAssurance());
            this.documentEntete.setDocNomPayeur(this.consultationEnteteGene.getCsgNomAssurance());
         } else if (this.consultationEnteteGene.getCsgIdSociete() != 0L) {
            this.documentEntete.setDocIdPayeur(this.consultationEnteteGene.getCsgIdSociete());
            this.documentEntete.setDocNomPayeur(this.consultationEnteteGene.getCsgNomSociete());
         } else if (this.consultationEnteteGene.getCsgIdComplementaire() != 0L) {
            this.documentEntete.setDocIdPayeur(this.consultationEnteteGene.getCsgIdComplementaire());
            this.documentEntete.setDocNomPayeur(this.consultationEnteteGene.getCsgNomComplemtaire());
         } else if (this.consultationEnteteGene.getCsgFondCnamgs() != 0 && this.consultationEnteteGene.getCsgPecCnamgs() != 0.0F) {
            this.documentEntete.setDocIdPayeur(-1L);
            this.documentEntete.setDocNomPayeur("CNAMGS");
         } else {
            this.documentEntete.setDocIdPayeur(0L);
            this.documentEntete.setDocNomPayeur("XX PRIVES");
         }

         this.documentEntete.setDocService(this.consultationEnteteGene.getCsgService());
         this.documentEntete.setDocSource(this.consultationEnteteGene.getCsgEntree());
         this.documentEntete.setDocLibelle(var2);
         this.documentEntete.setDocQte(var3);
         this.documentEntete.setDocTotHt(this.consultationEnteteGene.getTotalTiers());
         this.documentEntete.setDocTotTva(this.consultationEnteteGene.getTotalPatient());
         this.documentEntete.setDocTotTtc(this.consultationEnteteGene.getTotalTiers() + this.consultationEnteteGene.getTotalPatient());
         this.documentEntete.setDocTotReglement(this.consultationEnteteGene.getCsgRegPatient() + this.consultationEnteteGene.getCsgRegTiers());
         this.lesAnalyses.add(this.documentEntete);
      } else {
         this.lesAnalyses.remove(this.documentEntete);
         this.documentEntete.setDocIdResponsable(this.consultationEnteteGene.getCsgIdCreateur());
         this.documentEntete.setDocNomResponsable(this.consultationEnteteGene.getCsgNomCreateur());
         this.documentEntete.setDocIdCommercial(this.consultationEnteteGene.getCsgIdMedecin());
         this.documentEntete.setDocNomCommercial(this.consultationEnteteGene.getCsgMedecin());
         this.documentEntete.setDocIdEquipe(this.consultationEnteteGene.getCsgIdPatient());
         this.documentEntete.setDocNomEquipe(this.consultationEnteteGene.getCsgNomPatient());
         this.documentEntete.setDocBudget(this.consultationEnteteGene.getCsgPathologie());
         if (this.consultationEnteteGene.getCsgIdAssurance() != 0L) {
            this.documentEntete.setDocIdPayeur(this.consultationEnteteGene.getCsgIdAssurance());
            this.documentEntete.setDocNomPayeur(this.consultationEnteteGene.getCsgNomAssurance());
         } else if (this.consultationEnteteGene.getCsgIdSociete() != 0L) {
            this.documentEntete.setDocIdPayeur(this.consultationEnteteGene.getCsgIdSociete());
            this.documentEntete.setDocNomPayeur(this.consultationEnteteGene.getCsgNomSociete());
         } else if (this.consultationEnteteGene.getCsgIdComplementaire() != 0L) {
            this.documentEntete.setDocIdPayeur(this.consultationEnteteGene.getCsgIdComplementaire());
            this.documentEntete.setDocNomPayeur(this.consultationEnteteGene.getCsgNomComplemtaire());
         } else if (this.consultationEnteteGene.getCsgFondCnamgs() != 0 && this.consultationEnteteGene.getCsgPecCnamgs() != 0.0F) {
            this.documentEntete.setDocIdPayeur(-1L);
            this.documentEntete.setDocNomPayeur("CNAMGS");
         } else {
            this.documentEntete.setDocIdPayeur(0L);
            this.documentEntete.setDocNomPayeur("XX PRIVES");
         }

         this.documentEntete.setDocService(this.consultationEnteteGene.getCsgService());
         this.documentEntete.setDocSource(this.consultationEnteteGene.getCsgEntree());
         this.documentEntete.setDocLibelle(var2);
         this.documentEntete.setDocQte(this.documentEntete.getDocQte() + var3);
         this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.consultationEnteteGene.getTotalTiers());
         this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.consultationEnteteGene.getTotalPatient());
         this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.consultationEnteteGene.getTotalTiers() + this.consultationEnteteGene.getTotalPatient());
         this.documentEntete.setDocTotReglement(this.documentEntete.getDocTotReglement() + this.consultationEnteteGene.getCsgRegPatient() + this.consultationEnteteGene.getCsgRegTiers());
         this.lesAnalyses.add(this.documentEntete);
      }

   }

   public void analysePharmacie(List var1, List var2) {
      String var3 = "";
      float var4 = 1.0F;
      boolean var5 = false;
      this.documentEntete = new DocumentEntete();
      int var6;
      int var7;
      if (this.inpMode == 3 && this.inpType == 73) {
         var3 = "";
         var4 = 0.0F;

         for(var6 = 0; var6 < var2.size(); ++var6) {
            var3 = ((PharmacieLigne)var2.get(var6)).getPhaligLibelle();
            this.pharmacieEntete = ((PharmacieLigne)var2.get(var6)).getPharmacieEntete();
            if (var3 == null || var3.isEmpty()) {
               var3 = "Produit non défini";
            }

            var4 = ((PharmacieLigne)var2.get(var6)).getPhaligQte();
            var5 = false;

            for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
               this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
               if (this.documentEntete.getDocLibelle().equals(var3)) {
                  var5 = true;
                  break;
               }
            }

            this.lignePharmacie(var5, var3, var4);
         }
      } else {
         for(var6 = 0; var6 < var1.size(); ++var6) {
            this.pharmacieEntete = (PharmacieEntete)var1.get(var6);
            var5 = false;
            if (this.lesAnalyses.size() != 0) {
               if (this.inpMode == 0) {
                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocIdResponsable() == this.pharmacieEntete.getPhaIdCreateur()) {
                        var5 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 1) {
                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocIdCommercial() == this.pharmacieEntete.getPhaIdMedecin()) {
                        var5 = true;
                        break;
                     }
                  }
               } else if (this.inpMode != 2) {
                  if (this.inpMode == 6) {
                     for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                        if (this.documentEntete.getDocIdEquipe() == this.pharmacieEntete.getPhaIdPatient()) {
                           var5 = true;
                           break;
                        }
                     }
                  } else if (this.inpMode == 7) {
                     for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                        if (this.pharmacieEntete.getPhaIdAssurance() != 0L && this.pharmacieEntete.getPhaIdAssurance() == this.documentEntete.getDocIdPayeur()) {
                           var5 = true;
                           break;
                        }

                        if (this.pharmacieEntete.getPhaIdSociete() != 0L && this.pharmacieEntete.getPhaIdSociete() == this.documentEntete.getDocIdPayeur()) {
                           var5 = true;
                           break;
                        }

                        if (this.pharmacieEntete.getPhaIdComplementaire() != 0L && this.pharmacieEntete.getPhaIdComplementaire() == this.documentEntete.getDocIdPayeur()) {
                           var5 = true;
                           break;
                        }

                        if (this.pharmacieEntete.getPhaPecCnamgs() != 0.0F && this.documentEntete.getDocIdPayeur() == -1L) {
                           var5 = true;
                           break;
                        }

                        if (this.documentEntete.getDocIdPayeur() == 999999L) {
                           var5 = true;
                           break;
                        }
                     }
                  } else if (this.inpMode == 8) {
                     String var9 = "Pathologie non définie";

                     for(int var8 = 0; var8 < this.lesAnalyses.size(); ++var8) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var8);
                        if (this.documentEntete.getDocBudget().equals(var9)) {
                           var5 = true;
                           break;
                        }
                     }
                  }
               } else {
                  if (this.pharmacieEntete.getPhaService() == null || this.pharmacieEntete.getPhaService().isEmpty()) {
                     this.consultationEnteteGene.setCsgService("Service non défini");
                  }

                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocService().equals(this.pharmacieEntete.getPhaService())) {
                        var5 = true;
                        break;
                     }
                  }
               }
            }

            this.lignePharmacie(var5, var3, var4);
         }
      }

   }

   public void lignePharmacie(Boolean var1, String var2, float var3) {
      if (!var1) {
         this.documentEntete = new DocumentEntete();
         this.documentEntete.setDocIdResponsable(this.pharmacieEntete.getPhaIdCreateur());
         this.documentEntete.setDocNomResponsable(this.pharmacieEntete.getPhaNomCreateur());
         this.documentEntete.setDocIdCommercial(this.pharmacieEntete.getPhaIdMedecin());
         this.documentEntete.setDocNomCommercial(this.pharmacieEntete.getPhaMedecin());
         this.documentEntete.setDocIdEquipe(this.pharmacieEntete.getPhaIdPatient());
         this.documentEntete.setDocNomEquipe(this.pharmacieEntete.getPhaNomPatient());
         this.documentEntete.setDocBudget(this.pharmacieEntete.getPhaPathologie());
         if (this.pharmacieEntete.getPhaIdAssurance() != 0L) {
            this.documentEntete.setDocIdPayeur(this.pharmacieEntete.getPhaIdAssurance());
            this.documentEntete.setDocNomPayeur(this.pharmacieEntete.getPhaNomAssurance());
         } else if (this.pharmacieEntete.getPhaIdSociete() != 0L) {
            this.documentEntete.setDocIdPayeur(this.pharmacieEntete.getPhaIdSociete());
            this.documentEntete.setDocNomPayeur(this.pharmacieEntete.getPhaNomSociete());
         } else if (this.pharmacieEntete.getPhaIdComplementaire() != 0L) {
            this.documentEntete.setDocIdPayeur(this.pharmacieEntete.getPhaIdComplementaire());
            this.documentEntete.setDocNomPayeur(this.pharmacieEntete.getPhaNomComplemtaire());
         } else if (this.pharmacieEntete.getPhaFondCnamgs() != 0 && this.pharmacieEntete.getPhaPecCnamgs() != 0.0F) {
            this.documentEntete.setDocIdPayeur(-1L);
            this.documentEntete.setDocNomPayeur("CNAMGS");
         } else {
            this.documentEntete.setDocIdPayeur(0L);
            this.documentEntete.setDocNomPayeur("XX PRIVES");
         }

         this.documentEntete.setDocService(this.pharmacieEntete.getPhaService());
         this.documentEntete.setDocSource("");
         this.documentEntete.setDocLibelle(var2);
         this.documentEntete.setDocQte(var3);
         this.documentEntete.setDocTotHt(this.pharmacieEntete.getTotalTiers());
         this.documentEntete.setDocTotTva(this.pharmacieEntete.getTotalPatient());
         this.documentEntete.setDocTotTtc(this.pharmacieEntete.getTotalTiers() + this.pharmacieEntete.getTotalPatient());
         this.documentEntete.setDocTotReglement(this.pharmacieEntete.getPhaRegPatient() + this.pharmacieEntete.getPhaRegTiers());
         this.lesAnalyses.add(this.documentEntete);
      } else {
         this.lesAnalyses.remove(this.documentEntete);
         this.documentEntete.setDocIdResponsable(this.pharmacieEntete.getPhaIdCreateur());
         this.documentEntete.setDocNomResponsable(this.pharmacieEntete.getPhaNomCreateur());
         this.documentEntete.setDocIdCommercial(this.pharmacieEntete.getPhaIdMedecin());
         this.documentEntete.setDocNomCommercial(this.pharmacieEntete.getPhaMedecin());
         this.documentEntete.setDocIdEquipe(this.pharmacieEntete.getPhaIdPatient());
         this.documentEntete.setDocNomEquipe(this.pharmacieEntete.getPhaNomPatient());
         this.documentEntete.setDocBudget(this.pharmacieEntete.getPhaPathologie());
         if (this.pharmacieEntete.getPhaIdAssurance() != 0L) {
            this.documentEntete.setDocIdPayeur(this.pharmacieEntete.getPhaIdAssurance());
            this.documentEntete.setDocNomPayeur(this.pharmacieEntete.getPhaNomAssurance());
         } else if (this.pharmacieEntete.getPhaIdSociete() != 0L) {
            this.documentEntete.setDocIdPayeur(this.pharmacieEntete.getPhaIdSociete());
            this.documentEntete.setDocNomPayeur(this.pharmacieEntete.getPhaNomSociete());
         } else if (this.pharmacieEntete.getPhaIdComplementaire() != 0L) {
            this.documentEntete.setDocIdPayeur(this.pharmacieEntete.getPhaIdComplementaire());
            this.documentEntete.setDocNomPayeur(this.pharmacieEntete.getPhaNomComplemtaire());
         } else if (this.pharmacieEntete.getPhaFondCnamgs() != 0 && this.pharmacieEntete.getPhaPecCnamgs() != 0.0F) {
            this.documentEntete.setDocIdPayeur(-1L);
            this.documentEntete.setDocNomPayeur("CNAMGS");
         } else {
            this.documentEntete.setDocIdPayeur(0L);
            this.documentEntete.setDocNomPayeur("XX PRIVES");
         }

         this.documentEntete.setDocService(this.pharmacieEntete.getPhaService());
         this.documentEntete.setDocSource("");
         this.documentEntete.setDocLibelle(var2);
         this.documentEntete.setDocQte(this.documentEntete.getDocQte() + var3);
         this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.pharmacieEntete.getTotalTiers());
         this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.pharmacieEntete.getTotalPatient());
         this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.pharmacieEntete.getTotalTiers() + this.pharmacieEntete.getTotalPatient());
         this.documentEntete.setDocTotReglement(this.documentEntete.getDocTotReglement() + this.pharmacieEntete.getPhaRegPatient() + this.pharmacieEntete.getPhaRegTiers());
         this.lesAnalyses.add(this.documentEntete);
      }

   }

   public void analyseLaboratoires(List var1, List var2) {
      String var3 = "";
      float var4 = 1.0F;
      boolean var5 = false;
      this.documentEntete = new DocumentEntete();
      int var6;
      int var7;
      if (this.inpMode == 3 && this.inpType == 74) {
         var3 = "";
         var4 = 0.0F;

         for(var6 = 0; var6 < var2.size(); ++var6) {
            var3 = ((LaboratoireLigne)var2.get(var6)).getLabligLibelle();
            this.laboratoireEntete = ((LaboratoireLigne)var2.get(var6)).getLaboratoireEntete();
            if (var3 == null || var3.isEmpty()) {
               var3 = "Examen non défini";
            }

            var4 = 1.0F;
            var5 = false;

            for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
               this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
               if (this.documentEntete.getDocLibelle().equals(var3)) {
                  var5 = true;
                  break;
               }
            }

            this.ligneConsultation(var5, var3, var4);
         }
      } else {
         for(var6 = 0; var6 < var1.size(); ++var6) {
            this.laboratoireEntete = (LaboratoireEntete)var1.get(var6);
            var5 = false;
            if (this.lesAnalyses.size() != 0) {
               if (this.inpMode == 0) {
                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocIdResponsable() == this.laboratoireEntete.getLabIdCreateur()) {
                        var5 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 1) {
                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocIdCommercial() == this.laboratoireEntete.getLabIdMedecin()) {
                        var5 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 2) {
                  if (this.laboratoireEntete.getLabService() == null || this.laboratoireEntete.getLabService().isEmpty()) {
                     this.laboratoireEntete.setLabService("Service non défini");
                  }

                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocService().equals(this.laboratoireEntete.getLabService())) {
                        var5 = true;
                        break;
                     }
                  }
               } else if (this.inpMode != 4) {
                  if (this.inpMode == 6) {
                     for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                        if (this.documentEntete.getDocIdEquipe() == this.laboratoireEntete.getLabIdPatient()) {
                           var5 = true;
                           break;
                        }
                     }
                  } else if (this.inpMode == 7) {
                     for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                        if (this.laboratoireEntete.getLabIdAssurance() != 0L && this.laboratoireEntete.getLabIdAssurance() == this.documentEntete.getDocIdPayeur()) {
                           var5 = true;
                           break;
                        }

                        if (this.laboratoireEntete.getLabIdSociete() != 0L && this.laboratoireEntete.getLabIdSociete() == this.documentEntete.getDocIdPayeur()) {
                           var5 = true;
                           break;
                        }

                        if (this.laboratoireEntete.getLabIdComplementaire() != 0L && this.laboratoireEntete.getLabIdComplementaire() == this.documentEntete.getDocIdPayeur()) {
                           var5 = true;
                           break;
                        }

                        if (this.laboratoireEntete.getLabPecCnamgs() != 0.0F && this.documentEntete.getDocIdPayeur() == -1L) {
                           var5 = true;
                           break;
                        }

                        if (this.documentEntete.getDocIdPayeur() == 999999L) {
                           var5 = true;
                           break;
                        }
                     }
                  } else if (this.inpMode == 8) {
                     String var9 = "Pathologie non définie";

                     for(int var8 = 0; var8 < this.lesAnalyses.size(); ++var8) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var8);
                        if (this.documentEntete.getDocBudget().equals(var9)) {
                           var5 = true;
                           break;
                        }
                     }
                  }
               } else {
                  if (this.laboratoireEntete.getLabLaboratoire() == null || this.laboratoireEntete.getLabLaboratoire().isEmpty()) {
                     this.laboratoireEntete.setLabLaboratoire("Laboratoire non défini");
                  }

                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocSource().equals(this.laboratoireEntete.getLabLaboratoire())) {
                        var5 = true;
                        break;
                     }
                  }
               }
            }

            this.ligneLaboratoire(var5, var3, var4);
         }
      }

   }

   public void ligneLaboratoire(Boolean var1, String var2, float var3) {
      if (!var1) {
         this.documentEntete = new DocumentEntete();
         this.documentEntete.setDocIdResponsable(this.laboratoireEntete.getLabIdCreateur());
         this.documentEntete.setDocNomResponsable(this.laboratoireEntete.getLabNomCreateur());
         this.documentEntete.setDocIdCommercial(this.laboratoireEntete.getLabIdMedecin());
         this.documentEntete.setDocNomCommercial(this.laboratoireEntete.getLabMedecin());
         this.documentEntete.setDocIdEquipe(this.laboratoireEntete.getLabIdPatient());
         this.documentEntete.setDocNomEquipe(this.laboratoireEntete.getLabNomPatient());
         this.documentEntete.setDocBudget(this.laboratoireEntete.getLabPathologie());
         if (this.laboratoireEntete.getLabIdAssurance() != 0L) {
            this.documentEntete.setDocIdPayeur(this.laboratoireEntete.getLabIdAssurance());
            this.documentEntete.setDocNomPayeur(this.laboratoireEntete.getLabNomAssurance());
         } else if (this.laboratoireEntete.getLabIdSociete() != 0L) {
            this.documentEntete.setDocIdPayeur(this.laboratoireEntete.getLabIdSociete());
            this.documentEntete.setDocNomPayeur(this.laboratoireEntete.getLabNomSociete());
         } else if (this.laboratoireEntete.getLabIdComplementaire() != 0L) {
            this.documentEntete.setDocIdPayeur(this.laboratoireEntete.getLabIdComplementaire());
            this.documentEntete.setDocNomPayeur(this.laboratoireEntete.getLabNomComplemtaire());
         } else if (this.laboratoireEntete.getLabFondCnamgs() != 0 && this.laboratoireEntete.getLabPecCnamgs() != 0.0F) {
            this.documentEntete.setDocIdPayeur(-1L);
            this.documentEntete.setDocNomPayeur("CNAMGS");
         } else {
            this.documentEntete.setDocIdPayeur(0L);
            this.documentEntete.setDocNomPayeur("XX PRIVES");
         }

         this.documentEntete.setDocService(this.laboratoireEntete.getLabService());
         this.documentEntete.setDocSource(this.laboratoireEntete.getLabLaboratoire());
         this.documentEntete.setDocLibelle(var2);
         this.documentEntete.setDocQte(var3);
         this.documentEntete.setDocTotHt(this.laboratoireEntete.getTotalTiers());
         this.documentEntete.setDocTotTva(this.laboratoireEntete.getTotalPatient());
         this.documentEntete.setDocTotTtc(this.laboratoireEntete.getTotalTiers() + this.laboratoireEntete.getTotalPatient());
         this.documentEntete.setDocTotReglement(this.laboratoireEntete.getLabRegPatient() + this.laboratoireEntete.getLabRegTiers());
         this.lesAnalyses.add(this.documentEntete);
      } else {
         this.lesAnalyses.remove(this.documentEntete);
         this.documentEntete.setDocIdResponsable(this.laboratoireEntete.getLabIdCreateur());
         this.documentEntete.setDocNomResponsable(this.laboratoireEntete.getLabNomCreateur());
         this.documentEntete.setDocIdCommercial(this.laboratoireEntete.getLabIdMedecin());
         this.documentEntete.setDocNomCommercial(this.laboratoireEntete.getLabMedecin());
         this.documentEntete.setDocIdEquipe(this.laboratoireEntete.getLabIdPatient());
         this.documentEntete.setDocNomEquipe(this.laboratoireEntete.getLabNomPatient());
         this.documentEntete.setDocBudget(this.laboratoireEntete.getLabPathologie());
         if (this.laboratoireEntete.getLabIdAssurance() != 0L) {
            this.documentEntete.setDocIdPayeur(this.laboratoireEntete.getLabIdAssurance());
            this.documentEntete.setDocNomPayeur(this.laboratoireEntete.getLabNomAssurance());
         } else if (this.laboratoireEntete.getLabIdSociete() != 0L) {
            this.documentEntete.setDocIdPayeur(this.laboratoireEntete.getLabIdSociete());
            this.documentEntete.setDocNomPayeur(this.laboratoireEntete.getLabNomSociete());
         } else if (this.laboratoireEntete.getLabIdComplementaire() != 0L) {
            this.documentEntete.setDocIdPayeur(this.laboratoireEntete.getLabIdComplementaire());
            this.documentEntete.setDocNomPayeur(this.laboratoireEntete.getLabNomComplemtaire());
         } else if (this.laboratoireEntete.getLabFondCnamgs() != 0 && this.laboratoireEntete.getLabPecCnamgs() != 0.0F) {
            this.documentEntete.setDocIdPayeur(-1L);
            this.documentEntete.setDocNomPayeur("CNAMGS");
         } else {
            this.documentEntete.setDocIdPayeur(0L);
            this.documentEntete.setDocNomPayeur("XX PRIVES");
         }

         this.documentEntete.setDocService(this.laboratoireEntete.getLabService());
         this.documentEntete.setDocSource(this.laboratoireEntete.getLabLaboratoire());
         this.documentEntete.setDocLibelle(var2);
         this.documentEntete.setDocQte(this.documentEntete.getDocQte() + var3);
         this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.laboratoireEntete.getTotalTiers());
         this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.laboratoireEntete.getTotalPatient());
         this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.laboratoireEntete.getTotalTiers() + this.laboratoireEntete.getTotalPatient());
         this.documentEntete.setDocTotReglement(this.documentEntete.getDocTotReglement() + this.laboratoireEntete.getLabRegPatient() + this.laboratoireEntete.getLabRegTiers());
         this.lesAnalyses.add(this.documentEntete);
      }

   }

   public void analyseHospitalisations(List var1, List var2) {
      String var3 = "";
      float var4 = 1.0F;
      boolean var5 = false;
      this.documentEntete = new DocumentEntete();
      int var6;
      int var7;
      if (this.inpMode == 3 && this.inpType == 76) {
         var3 = "";
         var4 = 0.0F;

         for(var6 = 0; var6 < var2.size(); ++var6) {
            var3 = ((HospitalisationActes)var2.get(var6)).getHosactLibelle();
            this.hospitalisationEntete = ((HospitalisationActes)var2.get(var6)).getHospitalisationEntete();
            if (var3 == null || var3.isEmpty()) {
               var3 = "Actes non défini";
            }

            var4 = 1.0F;
            var5 = false;

            for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
               this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
               if (this.documentEntete.getDocLibelle().equals(var3)) {
                  var5 = true;
                  break;
               }
            }

            this.ligneHospitalisation(var5, var3, var4);
         }
      } else {
         for(var6 = 0; var6 < var1.size(); ++var6) {
            this.hospitalisationEntete = (HospitalisationEntete)var1.get(var6);
            var5 = false;
            if (this.lesAnalyses.size() != 0) {
               if (this.inpMode == 0) {
                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocIdResponsable() == this.hospitalisationEntete.getHosIdCreateur()) {
                        var5 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 1) {
                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocIdCommercial() == this.hospitalisationEntete.getHosIdMedecin()) {
                        var5 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 2) {
                  if (this.hospitalisationEntete.getHosService() == null || this.hospitalisationEntete.getHosService().isEmpty()) {
                     this.hospitalisationEntete.setHosService("Service non défini");
                  }

                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocService().equals(this.hospitalisationEntete.getHosService())) {
                        var5 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 4) {
                  if (this.hospitalisationEntete.getHosMotifEntree() == null || this.hospitalisationEntete.getHosMotifEntree().isEmpty()) {
                     this.hospitalisationEntete.setHosMotifEntree("Motif entrée non défini");
                  }

                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocSource().equals(this.hospitalisationEntete.getHosMotifEntree())) {
                        var5 = true;
                        break;
                     }
                  }
               } else if (this.inpMode != 5) {
                  if (this.inpMode == 6) {
                     for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                        if (this.documentEntete.getDocIdEquipe() == this.hospitalisationEntete.getHosIdPatient()) {
                           var5 = true;
                           break;
                        }
                     }
                  } else if (this.inpMode == 7) {
                     for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                        if (this.hospitalisationEntete.getHosIdAssurance() != 0L && this.hospitalisationEntete.getHosIdAssurance() == this.documentEntete.getDocIdPayeur()) {
                           var5 = true;
                           break;
                        }

                        if (this.hospitalisationEntete.getHosIdSociete() != 0L && this.hospitalisationEntete.getHosIdSociete() == this.documentEntete.getDocIdPayeur()) {
                           var5 = true;
                           break;
                        }

                        if (this.hospitalisationEntete.getHosIdComplementaire() != 0L && this.hospitalisationEntete.getHosIdComplementaire() == this.documentEntete.getDocIdPayeur()) {
                           var5 = true;
                           break;
                        }

                        if (this.hospitalisationEntete.getHosPecCnamgs() != 0.0F && this.documentEntete.getDocIdPayeur() == -1L) {
                           var5 = true;
                           break;
                        }

                        if (this.documentEntete.getDocIdPayeur() == 999999L) {
                           var5 = true;
                           break;
                        }
                     }
                  } else if (this.inpMode == 8) {
                     String var9 = "Pathologie non définie";

                     for(int var8 = 0; var8 < this.lesAnalyses.size(); ++var8) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var8);
                        if (this.documentEntete.getDocBudget().equals(var9)) {
                           var5 = true;
                           break;
                        }
                     }
                  }
               } else {
                  if (this.hospitalisationEntete.getHosMotifSortie() == null || this.hospitalisationEntete.getHosMotifSortie().isEmpty()) {
                     this.hospitalisationEntete.setHosMotifSortie("Motif sortie non défini");
                  }

                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocSite().equals(this.hospitalisationEntete.getHosMotifSortie())) {
                        var5 = true;
                        break;
                     }
                  }
               }
            }

            this.ligneHospitalisation(var5, var3, var4);
         }
      }

   }

   public void ligneHospitalisation(Boolean var1, String var2, float var3) {
      if (!var1) {
         this.documentEntete = new DocumentEntete();
         this.documentEntete.setDocIdResponsable(this.hospitalisationEntete.getHosIdCreateur());
         this.documentEntete.setDocNomResponsable(this.hospitalisationEntete.getHosNomCreateur());
         this.documentEntete.setDocIdCommercial(this.hospitalisationEntete.getHosIdMedecin());
         this.documentEntete.setDocNomCommercial(this.hospitalisationEntete.getHosMedecin());
         this.documentEntete.setDocIdEquipe(this.hospitalisationEntete.getHosIdPatient());
         this.documentEntete.setDocNomEquipe(this.hospitalisationEntete.getHosNomPatient());
         this.documentEntete.setDocBudget(this.hospitalisationEntete.getHosPathologie());
         if (this.hospitalisationEntete.getHosIdAssurance() != 0L) {
            this.documentEntete.setDocIdPayeur(this.hospitalisationEntete.getHosIdAssurance());
            this.documentEntete.setDocNomPayeur(this.hospitalisationEntete.getHosNomAssurance());
         } else if (this.hospitalisationEntete.getHosIdSociete() != 0L) {
            this.documentEntete.setDocIdPayeur(this.hospitalisationEntete.getHosIdSociete());
            this.documentEntete.setDocNomPayeur(this.hospitalisationEntete.getHosNomSociete());
         } else if (this.hospitalisationEntete.getHosIdComplementaire() != 0L) {
            this.documentEntete.setDocIdPayeur(this.hospitalisationEntete.getHosIdComplementaire());
            this.documentEntete.setDocNomPayeur(this.hospitalisationEntete.getHosNomComplemtaire());
         } else if (this.hospitalisationEntete.getHosFondCnamgs() != 0 && this.hospitalisationEntete.getHosPecCnamgs() != 0.0F) {
            this.documentEntete.setDocIdPayeur(-1L);
            this.documentEntete.setDocNomPayeur("CNAMGS");
         } else {
            this.documentEntete.setDocIdPayeur(0L);
            this.documentEntete.setDocNomPayeur("XX PRIVES");
         }

         this.documentEntete.setDocService(this.hospitalisationEntete.getHosService());
         this.documentEntete.setDocSource(this.hospitalisationEntete.getHosMotifEntree());
         this.documentEntete.setDocSite(this.hospitalisationEntete.getHosMotifSortie());
         this.documentEntete.setDocLibelle(var2);
         this.documentEntete.setDocQte(var3);
         this.documentEntete.setDocTotHt(this.hospitalisationEntete.getTotalTiers());
         this.documentEntete.setDocTotTva(this.hospitalisationEntete.getTotalPatient());
         this.documentEntete.setDocTotTtc(this.hospitalisationEntete.getTotalTiers() + this.hospitalisationEntete.getTotalPatient());
         this.documentEntete.setDocTotReglement(this.hospitalisationEntete.getHosRegPatient() + this.hospitalisationEntete.getHosRegTiers());
         this.lesAnalyses.add(this.documentEntete);
      } else {
         this.lesAnalyses.remove(this.documentEntete);
         this.documentEntete.setDocIdResponsable(this.hospitalisationEntete.getHosIdCreateur());
         this.documentEntete.setDocNomResponsable(this.hospitalisationEntete.getHosNomCreateur());
         this.documentEntete.setDocIdCommercial(this.hospitalisationEntete.getHosIdMedecin());
         this.documentEntete.setDocNomCommercial(this.hospitalisationEntete.getHosMedecin());
         this.documentEntete.setDocIdEquipe(this.hospitalisationEntete.getHosIdPatient());
         this.documentEntete.setDocNomEquipe(this.hospitalisationEntete.getHosNomPatient());
         this.documentEntete.setDocBudget(this.hospitalisationEntete.getHosPathologie());
         if (this.hospitalisationEntete.getHosIdAssurance() != 0L) {
            this.documentEntete.setDocIdPayeur(this.hospitalisationEntete.getHosIdAssurance());
            this.documentEntete.setDocNomPayeur(this.hospitalisationEntete.getHosNomAssurance());
         } else if (this.hospitalisationEntete.getHosIdSociete() != 0L) {
            this.documentEntete.setDocIdPayeur(this.hospitalisationEntete.getHosIdSociete());
            this.documentEntete.setDocNomPayeur(this.hospitalisationEntete.getHosNomSociete());
         } else if (this.hospitalisationEntete.getHosIdComplementaire() != 0L) {
            this.documentEntete.setDocIdPayeur(this.hospitalisationEntete.getHosIdComplementaire());
            this.documentEntete.setDocNomPayeur(this.hospitalisationEntete.getHosNomComplemtaire());
         } else if (this.hospitalisationEntete.getHosFondCnamgs() != 0 && this.hospitalisationEntete.getHosPecCnamgs() != 0.0F) {
            this.documentEntete.setDocIdPayeur(-1L);
            this.documentEntete.setDocNomPayeur("CNAMGS");
         } else {
            this.documentEntete.setDocIdPayeur(0L);
            this.documentEntete.setDocNomPayeur("XX PRIVES");
         }

         this.documentEntete.setDocService(this.hospitalisationEntete.getHosService());
         this.documentEntete.setDocSource(this.hospitalisationEntete.getHosMotifEntree());
         this.documentEntete.setDocSite(this.hospitalisationEntete.getHosMotifSortie());
         this.documentEntete.setDocLibelle(var2);
         this.documentEntete.setDocQte(this.documentEntete.getDocQte() + var3);
         this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.hospitalisationEntete.getTotalTiers());
         this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.hospitalisationEntete.getTotalPatient());
         this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.hospitalisationEntete.getTotalTiers() + this.hospitalisationEntete.getTotalPatient());
         this.documentEntete.setDocTotReglement(this.documentEntete.getDocTotReglement() + this.hospitalisationEntete.getHosRegPatient() + this.hospitalisationEntete.getHosRegTiers());
         this.lesAnalyses.add(this.documentEntete);
      }

   }

   public void analyseRefacturation(List var1, List var2) {
      String var3 = "";
      float var4 = 1.0F;
      boolean var5 = false;
      this.documentEntete = new DocumentEntete();
      int var6;
      int var7;
      if (this.inpMode == 3 && this.inpType == 78) {
         var3 = "";
         var4 = 0.0F;

         for(var6 = 0; var6 < var2.size(); ++var6) {
            var3 = ((FactureLigneMedical)var2.get(var6)).getFacligLibelle();
            this.factureEnteteMedical = ((FactureLigneMedical)var2.get(var6)).getFactureEnteteMedical();
            if (var3 == null || var3.isEmpty()) {
               var3 = "Examen non défini";
            }

            var4 = 1.0F;
            var5 = false;

            for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
               this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
               if (this.documentEntete.getDocLibelle().equals(var3)) {
                  var5 = true;
                  break;
               }
            }

            this.ligneRefacturation(var5, var3, var4);
         }
      } else {
         for(var6 = 0; var6 < var1.size(); ++var6) {
            this.factureEnteteMedical = (FactureEnteteMedical)var1.get(var6);
            var5 = false;
            if (this.lesAnalyses.size() != 0) {
               if (this.inpMode == 0) {
                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocIdResponsable() == this.factureEnteteMedical.getFacIdCreateur()) {
                        var5 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 1) {
                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocIdCommercial() == this.factureEnteteMedical.getFacIdCommercial()) {
                        var5 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 2) {
                  if (this.factureEnteteMedical.getFacService() == null || this.factureEnteteMedical.getFacService().isEmpty()) {
                     this.factureEnteteMedical.setFacService("Service non défini");
                  }

                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocService().equals(this.factureEnteteMedical.getFacService())) {
                        var5 = true;
                        break;
                     }
                  }
               } else if (this.inpMode != 4) {
                  if (this.inpMode == 6) {
                     for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                        if (this.documentEntete.getDocIdEquipe() == this.factureEnteteMedical.getTiers().getTieid()) {
                           var5 = true;
                           break;
                        }
                     }
                  }
               } else {
                  if (this.factureEnteteMedical.getFacContrat() == null || this.factureEnteteMedical.getFacContrat().isEmpty()) {
                     this.factureEnteteMedical.setFacContrat("Contrat non défini");
                  }

                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocSource().equals(this.factureEnteteMedical.getFacContrat())) {
                        var5 = true;
                        break;
                     }
                  }
               }
            }

            this.ligneRefacturation(var5, var3, var4);
         }
      }

   }

   public void ligneRefacturation(Boolean var1, String var2, float var3) {
      if (!var1) {
         this.documentEntete = new DocumentEntete();
         this.documentEntete.setDocIdResponsable(this.factureEnteteMedical.getFacIdCreateur());
         this.documentEntete.setDocNomResponsable(this.factureEnteteMedical.getFacNomCreateur());
         this.documentEntete.setDocIdCommercial(this.factureEnteteMedical.getFacIdCommercial());
         this.documentEntete.setDocNomCommercial(this.factureEnteteMedical.getFacNomCommercial());
         this.documentEntete.setDocIdEquipe(this.factureEnteteMedical.getTiers().getTieid());
         this.documentEntete.setDocNomEquipe(this.factureEnteteMedical.getFacNomTiers());
         this.documentEntete.setDocService(this.factureEnteteMedical.getFacService());
         this.documentEntete.setDocSource(this.factureEnteteMedical.getFacContrat());
         this.documentEntete.setDocLibelle(var2);
         this.documentEntete.setDocQte(var3);
         this.documentEntete.setDocTotHt(this.factureEnteteMedical.getFacTotHt());
         this.documentEntete.setDocTotTva(this.factureEnteteMedical.getFacTotTva());
         this.documentEntete.setDocTotTtc(this.factureEnteteMedical.getFacTotHt() + this.factureEnteteMedical.getFacTotTva());
         this.documentEntete.setDocTotReglement(this.factureEnteteMedical.getFacTotReglement());
         this.lesAnalyses.add(this.documentEntete);
      } else {
         this.lesAnalyses.remove(this.documentEntete);
         this.documentEntete.setDocIdResponsable(this.factureEnteteMedical.getFacIdCreateur());
         this.documentEntete.setDocNomResponsable(this.factureEnteteMedical.getFacNomCreateur());
         this.documentEntete.setDocIdCommercial(this.factureEnteteMedical.getFacIdCommercial());
         this.documentEntete.setDocNomCommercial(this.factureEnteteMedical.getFacNomCommercial());
         this.documentEntete.setDocIdEquipe(this.factureEnteteMedical.getTiers().getTieid());
         this.documentEntete.setDocNomEquipe(this.factureEnteteMedical.getFacNomTiers());
         this.documentEntete.setDocService(this.factureEnteteMedical.getFacService());
         this.documentEntete.setDocSource(this.factureEnteteMedical.getFacContrat());
         this.documentEntete.setDocLibelle(var2);
         this.documentEntete.setDocQte(this.documentEntete.getDocQte() + var3);
         this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.factureEnteteMedical.getFacTotHt());
         this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.factureEnteteMedical.getFacTotTva());
         this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.factureEnteteMedical.getFacTotHt() + this.factureEnteteMedical.getFacTotTva());
         this.documentEntete.setDocTotReglement(this.documentEntete.getDocTotReglement() + this.factureEnteteMedical.getFacTotReglement());
         this.lesAnalyses.add(this.documentEntete);
      }

   }

   public void analyseFactureExternes(List var1, List var2) {
      String var3 = "";
      float var4 = 1.0F;
      boolean var5 = false;
      this.documentEntete = new DocumentEntete();
      int var6;
      int var7;
      if (this.inpMode == 3 && this.inpType == 181) {
         var3 = "";
         var4 = 0.0F;

         for(var6 = 0; var6 < var2.size(); ++var6) {
            var3 = ((NoteDebitLigneVentes)var2.get(var6)).getNdbligLibelle();
            this.noteDebitEnteteVentes = ((NoteDebitLigneVentes)var2.get(var6)).getNoteDebitEnteteVentes();
            if (var3 == null || var3.isEmpty()) {
               var3 = "Examen non défini";
            }

            var4 = 1.0F;
            var5 = false;

            for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
               this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
               if (this.documentEntete.getDocLibelle().equals(var3)) {
                  var5 = true;
                  break;
               }
            }

            this.ligneFactureExternes(var5, var3, var4);
         }
      } else {
         for(var6 = 0; var6 < var1.size(); ++var6) {
            this.noteDebitEnteteVentes = (NoteDebitEnteteVentes)var1.get(var6);
            var5 = false;
            if (this.lesAnalyses.size() != 0) {
               if (this.inpMode == 0) {
                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocIdResponsable() == this.noteDebitEnteteVentes.getNdbIdCreateur()) {
                        var5 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 1) {
                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocIdCommercial() == this.noteDebitEnteteVentes.getNdbIdCommercial()) {
                        var5 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 2) {
                  if (this.laboratoireEntete.getLabService() == null || this.noteDebitEnteteVentes.getNdbService().isEmpty()) {
                     this.laboratoireEntete.setLabService("Service non défini");
                  }

                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocService().equals(this.noteDebitEnteteVentes.getNdbService())) {
                        var5 = true;
                        break;
                     }
                  }
               } else if (this.inpMode != 4) {
                  if (this.inpMode == 6) {
                     for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                        if (this.documentEntete.getDocIdEquipe() == this.noteDebitEnteteVentes.getTiers().getTieid()) {
                           var5 = true;
                           break;
                        }
                     }
                  }
               } else {
                  if (this.noteDebitEnteteVentes.getNdbContrat() == null || this.noteDebitEnteteVentes.getNdbContrat().isEmpty()) {
                     this.noteDebitEnteteVentes.setNdbContrat("Contrat non défini");
                  }

                  for(var7 = 0; var7 < this.lesAnalyses.size(); ++var7) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var7);
                     if (this.documentEntete.getDocSource().equals(this.noteDebitEnteteVentes.getNdbContrat())) {
                        var5 = true;
                        break;
                     }
                  }
               }
            }

            this.ligneFactureExternes(var5, var3, var4);
         }
      }

   }

   public void ligneFactureExternes(Boolean var1, String var2, float var3) {
      if (!var1) {
         this.documentEntete = new DocumentEntete();
         this.documentEntete.setDocIdResponsable(this.noteDebitEnteteVentes.getNdbIdCreateur());
         this.documentEntete.setDocNomResponsable(this.noteDebitEnteteVentes.getNdbNomCreateur());
         this.documentEntete.setDocIdCommercial(this.noteDebitEnteteVentes.getNdbIdCommercial());
         this.documentEntete.setDocNomCommercial(this.noteDebitEnteteVentes.getNdbNomCommercial());
         this.documentEntete.setDocIdEquipe(this.noteDebitEnteteVentes.getTiers().getTieid());
         this.documentEntete.setDocNomEquipe(this.noteDebitEnteteVentes.getNdbNomTiers());
         this.documentEntete.setDocService(this.noteDebitEnteteVentes.getNdbService());
         this.documentEntete.setDocSource(this.noteDebitEnteteVentes.getNdbContrat());
         this.documentEntete.setDocLibelle(var2);
         this.documentEntete.setDocQte(var3);
         this.documentEntete.setDocTotHt(this.noteDebitEnteteVentes.getNdbTotHt());
         this.documentEntete.setDocTotTva(this.noteDebitEnteteVentes.getNdbTotTva());
         this.documentEntete.setDocTotTtc(this.noteDebitEnteteVentes.getNdbTotHt() + this.noteDebitEnteteVentes.getNdbTotTva());
         this.documentEntete.setDocTotReglement(this.noteDebitEnteteVentes.getNdbTotReglement());
         this.lesAnalyses.add(this.documentEntete);
      } else {
         this.lesAnalyses.remove(this.documentEntete);
         this.documentEntete.setDocIdResponsable(this.noteDebitEnteteVentes.getNdbIdCreateur());
         this.documentEntete.setDocNomResponsable(this.noteDebitEnteteVentes.getNdbNomCreateur());
         this.documentEntete.setDocIdCommercial(this.noteDebitEnteteVentes.getNdbIdCommercial());
         this.documentEntete.setDocNomCommercial(this.noteDebitEnteteVentes.getNdbNomCommercial());
         this.documentEntete.setDocIdEquipe(this.noteDebitEnteteVentes.getTiers().getTieid());
         this.documentEntete.setDocNomEquipe(this.noteDebitEnteteVentes.getNdbNomTiers());
         this.documentEntete.setDocService(this.noteDebitEnteteVentes.getNdbService());
         this.documentEntete.setDocSource(this.noteDebitEnteteVentes.getNdbContrat());
         this.documentEntete.setDocLibelle(var2);
         this.documentEntete.setDocQte(this.documentEntete.getDocQte() + var3);
         this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.noteDebitEnteteVentes.getNdbTotHt());
         this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.noteDebitEnteteVentes.getNdbTotTva());
         this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.noteDebitEnteteVentes.getNdbTotHt() + this.noteDebitEnteteVentes.getNdbTotTva());
         this.documentEntete.setDocTotReglement(this.documentEntete.getDocTotReglement() + this.noteDebitEnteteVentes.getNdbTotReglement());
         this.lesAnalyses.add(this.documentEntete);
      }

   }

   public void calculTotal() {
      this.montantCommission = 0.0D;
      this.montantPatient = 0.0D;
      this.montantTiers = 0.0D;
      this.montantTotal = 0.0D;
      this.totalImputation = 0.0D;
      this.montantReglement = 0.0D;
      this.montantSolde = 0.0D;
      this.var_nb_ligne = 0;
      if (this.lesAnalyses.size() != 0) {
         int var1;
         for(var1 = 0; var1 < this.lesAnalyses.size(); ++var1) {
            this.totalImputation += (double)((DocumentEntete)this.lesAnalyses.get(var1)).getDocQte();
            this.montantCommission += ((DocumentEntete)this.lesAnalyses.get(var1)).getDocTotTtc();
            this.montantTiers += ((DocumentEntete)this.lesAnalyses.get(var1)).getDocTotHt();
            this.montantPatient += ((DocumentEntete)this.lesAnalyses.get(var1)).getDocTotTva();
            this.montantTotal += ((DocumentEntete)this.lesAnalyses.get(var1)).getDocTotTtc();
            this.montantReglement += ((DocumentEntete)this.lesAnalyses.get(var1)).getDocTotReglement();
         }

         this.montantSolde = this.montantCommission - this.montantReglement;
         this.var_nb_ligne = this.lesAnalyses.size() + 1;
         this.documentEntete = new DocumentEntete();

         for(var1 = 0; var1 < this.lesAnalyses.size(); ++var1) {
            this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var1);
            float var2 = 0.0F;
            if (this.infirmerie) {
               var2 = (float)((double)this.documentEntete.getDocQte() / this.totalImputation * 100.0D);
            } else {
               var2 = (float)(this.documentEntete.getDocTotTc() / this.montantCommission * 100.0D);
            }

            this.documentEntete.setPourcent(var2);
         }
      }

   }

   public void rechercherRapport() throws HibernateException, NamingException, ParseException {
      this.lesRapports.clear();
      Object var1 = null;
      Object var2 = null;
      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      this.lesRapports = this.rapportMedicalDao.recherche((Session)null, this.exercicesVentes.getExevteId(), this.inpEtat, this.periode, this.inpMedecin, (String)var1, (String)var2);
      this.dataModelRapport.setWrappedData(this.lesRapports);
      this.visibiliteBtonRapport = false;
   }

   public void selectionRapport() {
      if (this.dataModelRapport.isRowAvailable()) {
         this.rapportMedical = (RapportMedical)this.dataModelRapport.getRowData();
         this.visibiliteBtonRapport = true;
      }

   }

   public void ajouterRapport() {
      this.rapportMedical = new RapportMedical();
      this.rapportMedical.setRapmedDate(new Date());
      this.rapportMedical.setRapmedService(this.inpSite);
      this.visibiliteBtonRapport = false;
      this.showModalPanelRapport = true;
   }

   public void modifierRapport() {
      if (this.rapportMedical != null) {
         this.showModalPanelRapport = true;
      }

   }

   public void consulterRapport() {
      if (this.rapportMedical != null) {
         this.showModalPanelRapport = true;
      }

   }

   public void supprimerRapport() throws HibernateException, NamingException {
      if (this.rapportMedical != null) {
         this.rapportMedicalDao.delete(this.rapportMedical);
         this.lesRapports.remove(this.rapportMedical);
         this.dataModelRapport.setWrappedData(this.lesRapports);
         this.visibiliteBtonRapport = false;
      }

   }

   public void fermerRapport() {
      this.visibiliteBtonRapport = false;
      this.showModalPanelRapport = false;
   }

   public void saveRapport() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "RapportMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.rapportMedical.getRapmedIdMedecin() != 0L) {
            new Users();
            Users var3 = this.userDao.selectByIdUsers(this.rapportMedical.getRapmedIdMedecin(), var1);
            if (var3 != null) {
               this.rapportMedical.setRapmedNomMedecin(var3.getUsrPatronyme());
            } else {
               this.rapportMedical.setRapmedIdMedecin(0L);
               this.rapportMedical.setRapmedNomMedecin("");
            }
         } else {
            this.rapportMedical.setRapmedNomMedecin("");
         }

         if (this.rapportMedical.getRapmedDate() == null) {
            this.rapportMedical.setRapmedDate(new Date());
         }

         String var10 = "";
         if (this.rapportMedical.getRapmedDate().getMonth() + 1 <= 9) {
            var10 = "0" + (this.rapportMedical.getRapmedDate().getMonth() + 1);
         } else {
            var10 = "" + (this.rapportMedical.getRapmedDate().getMonth() + 1);
         }

         String var4 = "" + (this.rapportMedical.getRapmedDate().getYear() + 1900);
         this.rapportMedical.setRapmedPeriode(var10 + ":" + var4);
         if (this.rapportMedical.getRapmedId() == 0L) {
            this.rapportMedical.setRapmedDateCreat(new Date());
            this.rapportMedical.setRapmedUserCreat(this.usersLog.getUsrid());
            this.rapportMedical.setRapmedNomCreateur(this.usersLog.getUsrPatronyme());
            this.rapportMedical.setRapmedNum(this.calculChrono.numCompose(this.rapportMedical.getRapmedDate(), 180, "", var1));
            this.rapportMedical.setExerciceventes(this.exercicesVentes);
            this.rapportMedical = this.rapportMedicalDao.insert(this.rapportMedical, var1);
            this.lesRapports.add(this.rapportMedical);
            this.dataModelRapport.setWrappedData(this.lesRapports);
         } else {
            this.rapportMedical.setRapmedDateModif(new Date());
            this.rapportMedical.setRapmedUserModif(this.usersLog.getUsrid());
            this.rapportMedical.setRapmedNomModif(this.usersLog.getUsrPatronyme());
            this.rapportMedical = this.rapportMedicalDao.modif(this.rapportMedical, var1);
         }

         var2.commit();
      } catch (HibernateException var8) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.visibiliteBtonRapport = true;
      this.showModalPanelRapport = false;
   }

   public void validerRapport() throws NamingException {
      if (this.rapportMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "RapportMedical");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.rapportMedical.getRapmedEtat() == 0) {
               this.rapportMedical.setRapmedEtat(1);
               this.rapportMedical = this.rapportMedicalDao.modif(this.rapportMedical, var1);
            }

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

   public void deValiderRapport() throws NamingException {
      if (this.rapportMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "RapportMedical");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.rapportMedical.getRapmedEtat() == 1) {
               this.rapportMedical.setRapmedEtat(0);
               this.rapportMedical = this.rapportMedicalDao.modif(this.rapportMedical, var1);
            }

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

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "commission" + File.separator;
      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1, int var2) throws HibernateException, NamingException {
      String var3 = "";
      File var4;
      if (var2 == 0) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatEncours.jpg");
         if (var4.exists()) {
            var3 = "formatEncours.jpg";
         } else {
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatCommission.jpg");
            if (var4.exists()) {
               var3 = "formatCommission.jpg";
            }
         }
      } else if (var2 == 20) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatParapheur.jpg");
         if (var4.exists()) {
            var3 = "formatParapheur.jpg";
         }
      } else if (var2 == 30) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatCaisse.jpg");
         if (var4.exists()) {
            var3 = "formatCaisse.jpg";
         }
      } else {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatCommission.jpg");
         if (var4.exists()) {
            var3 = "formatCommission.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException, HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.listDetailCommission.size() != 0) {
         var1 = this.calculeDetailPatient((List)var1);
      }

      this.montant_lettre = this.utilNombre.begin(this.commissionEnteteVentes.getComNetPayer(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource((Collection)var1);
      return var2;
   }

   public List calculeDetailPatient(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CommissionEnteteMedical");
      new Users();

      for(int var4 = 0; var4 < this.listDetailCommission.size(); ++var4) {
         this.commissionLigneVentes = (CommissionLigneVentes)this.listDetailCommission.get(var4);
         this.commissionEnteteVentes = this.commissionLigneVentes.getCommissionEnteteVentes();
         this.commissionLigneVentes.setPayeTiers(0.0D);
         this.commissionLigneVentes.setPayePatient(0.0D);
         this.commissionLigneVentes.setDejaPaye(0.0D);
         this.commissionLigneVentes.setNumStat("");
         if (this.commissionEnteteVentes.getComIdCommercial() != 0L) {
            Users var3 = this.userDao.selectUserD(this.commissionEnteteVentes.getComIdCommercial(), var2);
            if (var3 != null) {
               this.commissionLigneVentes.setNumStat(var3.getUsrNumStat());
            }
         }

         if (this.commissionLigneVentes.getComligNature() == 71) {
            this.consultationActes = this.consultationActesDao.selectConsActes(this.commissionLigneVentes.getComligIdligne(), var2);
            if (this.consultationActes != null) {
               if (this.commissionLigneVentes.getComligPayePatient() != 0.0D) {
                  this.commissionLigneVentes.setPayePatient(this.consultationActes.getTotlalPatient());
               }

               if (this.commissionLigneVentes.getComligPayeTier() != 0.0D) {
                  this.commissionLigneVentes.setPayeTiers(this.consultationActes.getTotalTiers());
               }

               this.commissionLigneVentes.setDejaPaye(this.commissionLigneVentes.getComligTotVerse());
            }
         } else if (this.commissionLigneVentes.getComligNature() == 73) {
            this.pharmacieLigne = this.pharmacieLigneDao.selectConsActes(this.commissionLigneVentes.getComligIdligne(), var2);
            if (this.pharmacieLigne != null) {
               if (this.commissionLigneVentes.getComligPayePatient() != 0.0D) {
                  this.commissionLigneVentes.setPayePatient(this.pharmacieLigne.getTotlalPatient());
               }

               if (this.commissionLigneVentes.getComligPayeTier() != 0.0D) {
                  this.commissionLigneVentes.setPayeTiers(this.pharmacieLigne.getTotalTiers());
               }

               this.commissionLigneVentes.setDejaPaye(this.commissionLigneVentes.getComligTotVerse());
            }
         } else if (this.commissionLigneVentes.getComligNature() == 74) {
            this.laboratoireLigne = this.laboratoireLigneDao.selectConsActes(this.commissionLigneVentes.getComligIdligne(), var2);
            if (this.laboratoireLigne != null) {
               if (this.commissionLigneVentes.getComligPayePatient() != 0.0D) {
                  this.commissionLigneVentes.setPayePatient(this.laboratoireLigne.getTotlalPatient());
               }

               if (this.commissionLigneVentes.getComligPayeTier() != 0.0D) {
                  this.commissionLigneVentes.setPayeTiers(this.laboratoireLigne.getTotalTiers());
               }

               this.commissionLigneVentes.setDejaPaye(this.commissionLigneVentes.getComligTotVerse());
            }
         } else if (this.commissionLigneVentes.getComligNature() == 76) {
         }

         var1.add(this.commissionLigneVentes);
      }

      this.utilInitHibernate.closeSession();
      return var1;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "CommissionEnteteMedical");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.commissionEnteteVentes.getComDateImp() != null) {
            var2 = true;
         }

         this.commissionEnteteVentes.setComDateImp(new Date());
         if (this.commissionEnteteVentes.getComEtat() == 0 && this.commissionEnteteVentes.getComEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.commissionEnteteVentes.setComEtat(1);
         }

         this.commissionEnteteVentes.setComModeleImp(var1);
         this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes, var3);
         var4.commit();
      } catch (HibernateException var9) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var2;
   }

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var3 != null && !var3.isEmpty()) {
            boolean var11 = this.majDateImpression(var3);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(var3);
            var1.setEntete("Impression commission");
            var1.setMontant_lettre(this.montant_lettre);
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.commissionEnteteVentes.getComEtat()));
            var1.setDuplicata("" + var11);
            var1.setNbDecQte(this.optionMedical.getNbDecQte());
            var1.setNbDecPu(this.optionMedical.getNbDecPu());
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.commissionEnteteVentes.getComIdResponsable());
            var1.setIdCommercial(this.commissionEnteteVentes.getComIdCommercial());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.commissionEnteteVentes.getComId());
            if (this.commissionEnteteVentes.getComAnal2() != null && !this.commissionEnteteVentes.getComAnal2().isEmpty()) {
               String var12 = "";
               if (this.commissionEnteteVentes.getComAnal2().contains(":")) {
                  String[] var13 = this.commissionEnteteVentes.getComAnal2().split(":");
                  var12 = var13[0];
               } else {
                  var12 = this.commissionEnteteVentes.getComAnal2();
               }
            }

            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des commissions");
         var1.setTotauxTtc("" + this.montantCommission);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "commission" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.getNature());
         var1.setId_doc(0L);
         JRBeanCollectionDataSource var14 = new JRBeanCollectionDataSource(this.listCommission);
         var1.setjRBeanCollectionDataSource(var14);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public void initGrapheur() {
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public OptionMedical getOptionMedical() {
      return this.optionMedical;
   }

   public void setOptionMedical(OptionMedical var1) {
      this.optionMedical = var1;
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

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public ExercicesVentes getLastExoVentes() {
      return this.lastExoVentes;
   }

   public void setLastExoVentes(ExercicesVentes var1) {
      this.lastExoVentes = var1;
   }

   public Date getInpAu() {
      return this.inpAu;
   }

   public void setInpAu(Date var1) {
      this.inpAu = var1;
   }

   public Date getInpDu() {
      return this.inpDu;
   }

   public void setInpDu(Date var1) {
      this.inpDu = var1;
   }

   public int getInpNb() {
      return this.inpNb;
   }

   public void setInpNb(int var1) {
      this.inpNb = var1;
   }

   public String getInpResponsable() {
      return this.inpResponsable;
   }

   public void setInpResponsable(String var1) {
      this.inpResponsable = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
   }

   public DataModel getDatamodelCommission() {
      return this.datamodelCommission;
   }

   public void setDatamodelCommission(DataModel var1) {
      this.datamodelCommission = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public CommissionEnteteVentes getCommissionEnteteVentes() {
      return this.commissionEnteteVentes;
   }

   public void setCommissionEnteteVentes(CommissionEnteteVentes var1) {
      this.commissionEnteteVentes = var1;
   }

   public CommissionLigneVentes getCommissionLigneVentes() {
      return this.commissionLigneVentes;
   }

   public void setCommissionLigneVentes(CommissionLigneVentes var1) {
      this.commissionLigneVentes = var1;
   }

   public DataModel getDatamodelDetailCommission() {
      return this.datamodelDetailCommission;
   }

   public void setDatamodelDetailCommission(DataModel var1) {
      this.datamodelDetailCommission = var1;
   }

   public boolean isShowModalPanelAjoutCalcul() {
      return this.showModalPanelAjoutCalcul;
   }

   public void setShowModalPanelAjoutCalcul(boolean var1) {
      this.showModalPanelAjoutCalcul = var1;
   }

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public boolean isVar_acc_complement() {
      return this.var_acc_complement;
   }

   public void setVar_acc_complement(boolean var1) {
      this.var_acc_complement = var1;
   }

   public boolean isVar_acc_document() {
      return this.var_acc_document;
   }

   public void setVar_acc_document(boolean var1) {
      this.var_acc_document = var1;
   }

   public boolean isVar_acc_dre() {
      return this.var_acc_dre;
   }

   public void setVar_acc_dre(boolean var1) {
      this.var_acc_dre = var1;
   }

   public boolean isVar_acc_etat() {
      return this.var_acc_etat;
   }

   public void setVar_acc_etat(boolean var1) {
      this.var_acc_etat = var1;
   }

   public boolean isVar_acc_exoneration() {
      return this.var_acc_exoneration;
   }

   public void setVar_acc_exoneration(boolean var1) {
      this.var_acc_exoneration = var1;
   }

   public boolean isVar_acc_habilitation() {
      return this.var_acc_habilitation;
   }

   public void setVar_acc_habilitation(boolean var1) {
      this.var_acc_habilitation = var1;
   }

   public boolean isVar_acc_imputation() {
      return this.var_acc_imputation;
   }

   public void setVar_acc_imputation(boolean var1) {
      this.var_acc_imputation = var1;
   }

   public boolean isVar_acc_reglement() {
      return this.var_acc_reglement;
   }

   public void setVar_acc_reglement(boolean var1) {
      this.var_acc_reglement = var1;
   }

   public boolean isVar_acc_tracabilite() {
      return this.var_acc_tracabilite;
   }

   public void setVar_acc_tracabilite(boolean var1) {
      this.var_acc_tracabilite = var1;
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

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public String getInpActivite() {
      return this.inpActivite;
   }

   public void setInpActivite(String var1) {
      this.inpActivite = var1;
   }

   public String getInpNum() {
      return this.inpNum;
   }

   public void setInpNum(String var1) {
      this.inpNum = var1;
   }

   public String getInpService() {
      return this.inpService;
   }

   public void setInpService(String var1) {
      this.inpService = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public double getMontantCommission() {
      return this.montantCommission;
   }

   public void setMontantCommission(double var1) {
      this.montantCommission = var1;
   }

   public double getMontantReglement() {
      return this.montantReglement;
   }

   public void setMontantReglement(double var1) {
      this.montantReglement = var1;
   }

   public double getMontantSolde() {
      return this.montantSolde;
   }

   public void setMontantSolde(double var1) {
      this.montantSolde = var1;
   }

   public boolean isAfficheRecu() {
      return this.afficheRecu;
   }

   public void setAfficheRecu(boolean var1) {
      this.afficheRecu = var1;
   }

   public DataModel getDatamodelRecu() {
      return this.datamodelRecu;
   }

   public void setDatamodelRecu(DataModel var1) {
      this.datamodelRecu = var1;
   }

   public boolean isVar_affiche_dollar() {
      return this.var_affiche_dollar;
   }

   public void setVar_affiche_dollar(boolean var1) {
      this.var_affiche_dollar = var1;
   }

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
   }

   public Date getInpDate() {
      return this.inpDate;
   }

   public void setInpDate(Date var1) {
      this.inpDate = var1;
   }

   public boolean isShowModalPanelPaye() {
      return this.showModalPanelPaye;
   }

   public void setShowModalPanelPaye(boolean var1) {
      this.showModalPanelPaye = var1;
   }

   public boolean isVar_verouxModReg() {
      return this.var_verouxModReg;
   }

   public void setVar_verouxModReg(boolean var1) {
      this.var_verouxModReg = var1;
   }

   public String getVar_inputCaisse() {
      return this.var_inputCaisse;
   }

   public void setVar_inputCaisse(String var1) {
      this.var_inputCaisse = var1;
   }

   public double getMontantElmTotBonEnc() {
      return this.montantElmTotBonEnc;
   }

   public void setMontantElmTotBonEnc(double var1) {
      this.montantElmTotBonEnc = var1;
   }

   public boolean isVar_affichMontant() {
      return this.var_affichMontant;
   }

   public void setVar_affichMontant(boolean var1) {
      this.var_affichMontant = var1;
   }

   public double getVar_netAPayer() {
      return this.var_netAPayer;
   }

   public void setVar_netAPayer(double var1) {
      this.var_netAPayer = var1;
   }

   public boolean isVar_affiche_valide() {
      return this.var_affiche_valide;
   }

   public void setVar_affiche_valide(boolean var1) {
      this.var_affiche_valide = var1;
   }

   public DataModel getDatamodelPaiement() {
      return this.datamodelPaiement;
   }

   public void setDatamodelPaiement(DataModel var1) {
      this.datamodelPaiement = var1;
   }

   public DataModel getDataModelDecoupageActivtes() {
      return this.dataModelDecoupageActivtes;
   }

   public void setDataModelDecoupageActivtes(DataModel var1) {
      this.dataModelDecoupageActivtes = var1;
   }

   public boolean isDecoupageActivite() {
      return this.decoupageActivite;
   }

   public void setDecoupageActivite(boolean var1) {
      this.decoupageActivite = var1;
   }

   public List getLaColonne1Items() {
      return this.laColonne1Items;
   }

   public void setLaColonne1Items(List var1) {
      this.laColonne1Items = var1;
   }

   public List getLaColonne2Items() {
      return this.laColonne2Items;
   }

   public void setLaColonne2Items(List var1) {
      this.laColonne2Items = var1;
   }

   public List getLaColonne3Items() {
      return this.laColonne3Items;
   }

   public void setLaColonne3Items(List var1) {
      this.laColonne3Items = var1;
   }

   public boolean isVar_anal_activite() {
      return this.var_anal_activite;
   }

   public void setVar_anal_activite(boolean var1) {
      this.var_anal_activite = var1;
   }

   public String getVar_colonne1() {
      return this.var_colonne1;
   }

   public void setVar_colonne1(String var1) {
      this.var_colonne1 = var1;
   }

   public String getVar_colonne2() {
      return this.var_colonne2;
   }

   public void setVar_colonne2(String var1) {
      this.var_colonne2 = var1;
   }

   public String getVar_colonne3() {
      return this.var_colonne3;
   }

   public void setVar_colonne3(String var1) {
      this.var_colonne3 = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
   }

   public int getInpMode() {
      return this.inpMode;
   }

   public void setInpMode(int var1) {
      this.inpMode = var1;
   }

   public long getInpIdMedecin() {
      return this.inpIdMedecin;
   }

   public void setInpIdMedecin(long var1) {
      this.inpIdMedecin = var1;
   }

   public String getInpMedecin() {
      return this.inpMedecin;
   }

   public void setInpMedecin(String var1) {
      this.inpMedecin = var1;
   }

   public long getInpIdResponsable() {
      return this.inpIdResponsable;
   }

   public void setInpIdResponsable(long var1) {
      this.inpIdResponsable = var1;
   }

   public List getMesMedecinItems() {
      return this.mesMedecinItems;
   }

   public void setMesMedecinItems(List var1) {
      this.mesMedecinItems = var1;
   }

   public List getMesResponsablesItems() {
      return this.mesResponsablesItems;
   }

   public void setMesResponsablesItems(List var1) {
      this.mesResponsablesItems = var1;
   }

   public DataModel getDataModelAnalyse() {
      return this.dataModelAnalyse;
   }

   public void setDataModelAnalyse(DataModel var1) {
      this.dataModelAnalyse = var1;
   }

   public int getInpType() {
      return this.inpType;
   }

   public void setInpType(int var1) {
      this.inpType = var1;
   }

   public UIDataTable getExtDTable() {
      return this.extDTable;
   }

   public void setExtDTable(UIDataTable var1) {
      this.extDTable = var1;
   }

   public SimpleSelection getSimpleSelectionEntete() {
      return this.simpleSelectionEntete;
   }

   public void setSimpleSelectionEntete(SimpleSelection var1) {
      this.simpleSelectionEntete = var1;
   }

   public boolean isInfirmerie() {
      return this.infirmerie;
   }

   public void setInfirmerie(boolean var1) {
      this.infirmerie = var1;
   }

   public boolean isVisibiliteBtonRapport() {
      return this.visibiliteBtonRapport;
   }

   public void setVisibiliteBtonRapport(boolean var1) {
      this.visibiliteBtonRapport = var1;
   }

   public boolean isShowModalPanelRapport() {
      return this.showModalPanelRapport;
   }

   public void setShowModalPanelRapport(boolean var1) {
      this.showModalPanelRapport = var1;
   }

   public boolean isVar_acces_rapport() {
      return this.var_acces_rapport;
   }

   public void setVar_acces_rapport(boolean var1) {
      this.var_acces_rapport = var1;
   }

   public DataModel getDataModelRapport() {
      return this.dataModelRapport;
   }

   public void setDataModelRapport(DataModel var1) {
      this.dataModelRapport = var1;
   }

   public RapportMedical getRapportMedical() {
      return this.rapportMedical;
   }

   public void setRapportMedical(RapportMedical var1) {
      this.rapportMedical = var1;
   }

   public String getInpSite() {
      return this.inpSite;
   }

   public void setInpSite(String var1) {
      this.inpSite = var1;
   }

   public double getMontantPatient() {
      return this.montantPatient;
   }

   public void setMontantPatient(double var1) {
      this.montantPatient = var1;
   }

   public double getMontantTiers() {
      return this.montantTiers;
   }

   public void setMontantTiers(double var1) {
      this.montantTiers = var1;
   }

   public double getMontantTotal() {
      return this.montantTotal;
   }

   public void setMontantTotal(double var1) {
      this.montantTotal = var1;
   }

   public List getMesMedecinBaremeItems() {
      return this.mesMedecinBaremeItems;
   }

   public void setMesMedecinBaremeItems(List var1) {
      this.mesMedecinBaremeItems = var1;
   }

   public String getLabelOnglet() {
      return this.labelOnglet;
   }

   public void setLabelOnglet(String var1) {
      this.labelOnglet = var1;
   }

   public Reglements getReglements() {
      return this.reglements;
   }

   public void setReglements(Reglements var1) {
      this.reglements = var1;
   }

   public double getVar_solde() {
      return this.var_solde;
   }

   public void setVar_solde(double var1) {
      this.var_solde = var1;
   }

   public int getVarTypeReg() {
      return this.varTypeReg;
   }

   public void setVarTypeReg(int var1) {
      this.varTypeReg = var1;
   }

   public String getVar_banque_tireur() {
      return this.var_banque_tireur;
   }

   public void setVar_banque_tireur(String var1) {
      this.var_banque_tireur = var1;
   }

   public String getVar_modele_trf() {
      return this.var_modele_trf;
   }

   public void setVar_modele_trf(String var1) {
      this.var_modele_trf = var1;
   }

   public String getVar_num_cheque() {
      return this.var_num_cheque;
   }

   public void setVar_num_cheque(String var1) {
      this.var_num_cheque = var1;
   }

   public List getListCaisses() {
      return this.listCaisses;
   }

   public void setListCaisses(List var1) {
      this.listCaisses = var1;
   }

   public List getMesCaissesSeriesItems() {
      return this.mesCaissesSeriesItems;
   }

   public void setMesCaissesSeriesItems(List var1) {
      this.mesCaissesSeriesItems = var1;
   }

   public double getVar_dejaPaye() {
      return this.var_dejaPaye;
   }

   public void setVar_dejaPaye(double var1) {
      this.var_dejaPaye = var1;
   }

   public boolean isShowModalPanelHistoReglement() {
      return this.showModalPanelHistoReglement;
   }

   public void setShowModalPanelHistoReglement(boolean var1) {
      this.showModalPanelHistoReglement = var1;
   }

   public double getVar_tot_precompte() {
      return this.var_tot_precompte;
   }

   public void setVar_tot_precompte(double var1) {
      this.var_tot_precompte = var1;
   }

   public double getVar_verse() {
      return this.var_verse;
   }

   public void setVar_verse(double var1) {
      this.var_verse = var1;
   }
}
