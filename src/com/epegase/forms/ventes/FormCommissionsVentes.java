package com.epegase.forms.ventes;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.CommissionEnteteVentes;
import com.epegase.systeme.classe.CommissionLigneVentes;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.DevisLigneVentes;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.RetourEnteteVentes;
import com.epegase.systeme.classe.RetourLigneVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.CommissionEnteteVentesDao;
import com.epegase.systeme.dao.CommissionLigneVentesDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.RetourEnteteVentesDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
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
import com.epegase.systeme.xml.LectureSourcesTiers;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
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

public class FormCommissionsVentes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private List mesOnglets;
   private OptionVentes optionsVentes;
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
   private DevisEnteteVentes devisEnteteVentes;
   private DevisEnteteVentesDao devisEnteteVentesDao;
   private DevisLigneVentes devisLigneVentes;
   private DevisLigneVentesDao devisLigneVentesDao;
   private CommandeEnteteVentes commandeEnteteVentes;
   private CommandeEnteteVentesDao commandeEnteteVentesDao;
   private CommandeLigneVentes commandeLigneVentes;
   private CommandeLigneVentesDao commandeLigneVentesDao;
   private List listDetailFacture = new ArrayList();
   private FactureEnteteVentes factureEnteteVentes = new FactureEnteteVentes();
   private FactureEnteteVentesDao factureEnteteVentesDao;
   private FactureLigneVentes factureLigneVentes = new FactureLigneVentes();
   private FactureLigneVentesDao factureLigneVentesDao;
   private List listDetailAvoir = new ArrayList();
   private AvoirEnteteVentes avoirEnteteVentes = new AvoirEnteteVentes();
   private AvoirEnteteVentesDao avoirEnteteVentesDao;
   private AvoirLigneVentes avoirLigneVentes = new AvoirLigneVentes();
   private AvoirLigneVentesDao avoirLigneVentesDao;
   private List listDetailNoteDebit = new ArrayList();
   private NoteDebitEnteteVentes noteDebitEnteteVentes = new NoteDebitEnteteVentes();
   private NoteDebitEnteteVentesDao noteDebitEnteteVentesDao;
   private NoteDebitLigneVentes noteDebitLigneVentes = new NoteDebitLigneVentes();
   private NoteDebitLigneVentesDao noteDebitLigneVentesDao;
   private LivraisonEnteteVentes livraisonEnteteVentes;
   private LivraisonEnteteVentesDao livraisonEnteteVentesDao;
   private LivraisonLigneVentes livraisonLigneVentes;
   private LivraisonLigneVentesDao livraisonLigneVentesDao;
   private RetourEnteteVentes retourEnteteVentes;
   private RetourEnteteVentesDao retourEnteteVentesDao;
   private RetourLigneVentes retourLigneVentes;
   private RetourLigneVentesDao retourLigneVentesDao;
   private List listDetailReglement = new ArrayList();
   private Reglements reglements = new Reglements();
   private ReglementsDao reglementsDao;
   private Date inpDate;
   private Date inpDu;
   private Date inpAu;
   private int inpNb;
   private int inpEtat;
   private int inpType;
   private String inpPdv;
   private int inpMode;
   private String periode;
   private String inpNum;
   private String inpService;
   private String inpActivite;
   private long inpIdConseillers;
   private long inpConseillers;
   private String inpResponsable;
   private long inpIdResponsable;
   private String inpCommercial;
   private long inpIdCommercial;
   private String inpEquipe;
   private long inpIdEquipe;
   private Produits produits = new Produits();
   private ProduitsVtesDao produitsVtesDao;
   private double montantHt;
   private double montantCommission;
   private double montantReglement;
   private double montantSolde;
   private int var_nb_ligne;
   private List mesResponsablesItems;
   private List mesCommerciauxItems;
   private List mesEquipesItems;
   private List mesPdvItems;
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
   private Habilitation habilitation;
   private DocumentTraceVentesDao documentTraceVentesDao;
   private UtilParapheur utilParapheur;
   private boolean existParapheur;
   private Users responsable;
   private long var_nom_commercial;
   private boolean showModalPanelAjoutCalcul = false;
   private String montant_lettre;
   private boolean showModalPanelPrint = false;
   private BonEncaissementVente bonEncaissementVente;
   private BonEncaissementVenteDao bonEncaissementVenteDao;
   private double var_tot_bon_encaissement;
   private boolean var_affiche_dollar = false;
   private boolean var_affiche_valide = false;
   private double montantElmTotBonEnc;
   private boolean afficheRecu;
   private transient DataModel datamodelRecu;
   private boolean var_verouxModReg;
   private boolean var_affichMontant;
   private String var_inputCaisse;
   private double var_netAPayer;
   private boolean showModalPanelPaye = false;
   private boolean showModalPanelPayeMultiple = false;
   private String var_nom_client;
   private String var_num_facture;
   private String var_montant;
   private List listCommissionSelectionne;
   private transient DataModel datamodelPaiement;
   private boolean showModalPanelReglement = false;
   private List listFactureSelectionne;
   private Reglements memoReglements;
   private boolean var_affiche_banque = false;
   private String var_type_reg;
   private int varTypeReg;
   private String var_objet;
   private String var_banque_tireur;
   private String var_num_cheque;
   private List mesModesleRecus;
   private String nomRepMod;
   private double val_timbre;
   private double var_ecart_reglement;
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

   public FormCommissionsVentes() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.datamodelRecu = new ListDataModel();
      this.listCommissionSelectionne = new ArrayList();
      this.datamodelPaiement = new ListDataModel();
      this.lesDecoupagesActivites = new ArrayList();
      this.dataModelDecoupageActivtes = new ListDataModel();
      this.mesResponsablesItems = new ArrayList();
      this.mesCommerciauxItems = new ArrayList();
      this.mesEquipesItems = new ArrayList();
      this.lesAnalyses = new ArrayList();
      this.dataModelAnalyse = new ListDataModel();
      this.mesPdvItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.commissionEnteteVentesDao = new CommissionEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.commissionLigneVentesDao = new CommissionLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.responsableDao = new ResponsableDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureLigneVentesDao = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.bonEncaissementVenteDao = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteVentesDao = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitLigneVentesDao = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.avoirEnteteVentesDao = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.avoirLigneVentesDao = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.livraisonEnteteVentesDao = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.livraisonLigneVentesDao = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.retourEnteteVentesDao = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.retourLigneVentesDao = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.commandeEnteteVentesDao = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.commandeLigneVentesDao = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.devisEnteteVentesDao = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.devisLigneVentesDao = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void configVentes(Session var1) throws HibernateException, NamingException {
      if (this.structureLog.getStrtypeentreprise() == null || this.structureLog.getStrtypeentreprise().isEmpty()) {
         this.structureLog.setStrtypeentreprise("0");
      }

      if (this.optionsVentes.getDecrmtPrsChrStock() == null || this.optionsVentes.getDecrmtPrsChrStock().isEmpty()) {
         this.optionsVentes.setDecrmtPrsChrStock("0");
      }

      if (this.optionsVentes.getNbLigneMax() != null && !this.optionsVentes.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionsVentes.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.periode = this.optionsVentes.getAffichInGlobViewCOMMISSION();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
      this.usersChrono = new UsersChrono();
      this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
      this.mesEquipesItems.clear();
      new ArrayList();
      EquipesDao var3 = new EquipesDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectEquipes(var1);
      if (var2.size() != 0) {
         new Equipes();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            Equipes var4 = (Equipes)var2.get(var5);
            this.mesEquipesItems.add(new SelectItem(var4.getEquId(), var4.getEquCode() + ":" + var4.getEquNomFr()));
         }
      }

      PointDeVenteDao var6 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
      this.mesPdvItems = var6.chargerLesPointDeVenteItems(var1);
   }

   public void accesResteintUser() {
      if (this.usersLog.getUsrAffPump() == 0) {
         this.affichagePump = false;
      } else {
         this.affichagePump = true;
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
      double var8 = 0.0D;
      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      this.listCommission = this.commissionEnteteVentesDao.recherche(var1, this.exercicesVentes.getExevteId(), this.inpNum, this.inpEtat, this.periode, this.inpService, this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.inpIdResponsable, this.inpIdCommercial, this.inpActivite, (String)var2, (String)var3);
      if (this.listCommission.size() > 0) {
         new CommissionEnteteVentes();

         for(int var11 = 0; var11 < this.listCommission.size(); ++var11) {
            CommissionEnteteVentes var10 = (CommissionEnteteVentes)this.listCommission.get(var11);
            var4 += var10.getComTotHt();
            var6 += var10.getComTotCommission();
            var8 += var10.getComTotReglement();
         }

         this.var_nb_ligne = this.listCommission.size();
      }

      this.datamodelCommission.setWrappedData(this.listCommission);
      this.montantHt = var4;
      this.montantCommission = var6;
      this.montantReglement = var8;
      this.montantSolde = this.montantCommission - var8;
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
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommissionEntete");
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
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.commissionEnteteVentes.getComId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement += ((BonEncaissementVente)var2.get(var3)).getBonAPayer();
            }
         }
      }

      new ArrayList();
      List var5 = this.reglementsDao.reglementDocument(this.commissionEnteteVentes.getComId(), this.nature, var1);
      this.afficheRecu = false;
      if (var5.size() != 0) {
         this.afficheRecu = true;

         for(int var4 = 0; var4 < var5.size(); ++var4) {
            this.var_tot_bon_encaissement += ((Reglements)var5.get(var4)).getRglDepense();
         }
      }

      this.datamodelRecu.setWrappedData(var5);
      if (this.var_tot_bon_encaissement < this.commissionEnteteVentes.getComTotCommission()) {
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
         ArrayList var1 = new ArrayList();
         CommissionEnteteVentes var3;
         if (this.listCommission.size() != 0) {
            for(int var2 = 0; var2 < this.listCommission.size(); ++var2) {
               new CommissionEnteteVentes();
               var3 = (CommissionEnteteVentes)this.listCommission.get(var2);
               if (var3.isVar_select_ligne()) {
                  var1.add(var3);
               }
            }
         }

         Session var12 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommissionEntete");
         var3 = null;

         try {
            Transaction var13 = var12.beginTransaction();

            for(int var4 = 0; var4 < var1.size(); ++var4) {
               this.commissionEnteteVentes = new CommissionEnteteVentes();
               this.commissionEnteteVentes = (CommissionEnteteVentes)var1.get(var4);
               long var5 = this.commissionEnteteVentes.getComId();
               this.commissionEnteteVentes = this.commissionEnteteVentesDao.pourParapheur(var5, var12);
               if (this.commissionEnteteVentes.getComEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
                  this.commissionEnteteVentes.setComEtat(1);
                  this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes, var12);
               }
            }

            Espion var14 = new Espion();
            var14.setUsers(this.usersLog);
            var14.setEsptype(0);
            var14.setEspdtecreat(new Date());
            var14.setEspaction("Validation manuelle commission (C.) N° " + this.commissionEnteteVentes.getComNum() + " du " + this.utilDate.dateToStringSQLLight(this.commissionEnteteVentes.getComDate()));
            this.espionDao.mAJEspion(var14, var12);
            var13.commit();
         } catch (HibernateException var10) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.executerRequete((Session)null);
      }

   }

   public void deValideDocument() throws HibernateException, NamingException, ParseException {
      if (this.commissionEnteteVentes != null) {
         ArrayList var1 = new ArrayList();
         CommissionEnteteVentes var3;
         if (this.listCommission.size() != 0) {
            for(int var2 = 0; var2 < this.listCommission.size(); ++var2) {
               new CommissionEnteteVentes();
               var3 = (CommissionEnteteVentes)this.listCommission.get(var2);
               if (var3.isVar_select_ligne()) {
                  var1.add(var3);
               }
            }
         }

         Session var12 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommissionEntete");
         var3 = null;

         try {
            Transaction var13 = var12.beginTransaction();
            int var4 = 0;

            while(true) {
               if (var4 >= var1.size()) {
                  Espion var14 = new Espion();
                  var14.setUsers(this.usersLog);
                  var14.setEsptype(0);
                  var14.setEspdtecreat(new Date());
                  var14.setEspaction("Dévalidation manuelle commission (C.) N° " + this.commissionEnteteVentes.getComNum() + " du " + this.utilDate.dateToStringSQLLight(this.commissionEnteteVentes.getComDate()));
                  this.espionDao.mAJEspion(var14, var12);
                  var13.commit();
                  break;
               }

               this.commissionEnteteVentes = new CommissionEnteteVentes();
               this.commissionEnteteVentes = (CommissionEnteteVentes)var1.get(var4);
               long var5 = this.commissionEnteteVentes.getComId();
               this.commissionEnteteVentes = this.commissionEnteteVentesDao.pourParapheur(var5, var12);
               if (this.commissionEnteteVentes.getComEtat() == 1 && this.habilitation == null) {
                  this.commissionEnteteVentes.setComEtat(0);
                  this.commissionEnteteVentes.setComDateImp((Date)null);
                  this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes, var12);
               }

               ++var4;
            }
         } catch (HibernateException var10) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var10;
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
         this.bonEncaissementVente = new BonEncaissementVente();
         this.bonEncaissementVente.setBonCodeCaisse("");
         this.bonEncaissementVente.setBonLibCaisse("");
         this.bonEncaissementVente.setBonDate(new Date());
         this.var_nom_client = "";
         this.var_num_facture = "";
         this.var_montant = "";
         this.listCommissionSelectionne.clear();
         double var1 = 0.0D;
         int var3 = 0;
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");

         for(int var5 = 0; var5 < this.listCommission.size(); ++var5) {
            new CommissionEnteteVentes();
            CommissionEnteteVentes var6 = (CommissionEnteteVentes)this.listCommission.get(var5);
            if (var6.isVar_select_ligne()) {
               double var7 = 0.0D;
               new ArrayList();
               List var9 = this.bonEncaissementVenteDao.rechercheBeByDoc(var6.getComId(), this.nature, var4);
               if (var9.size() != 0) {
                  for(int var10 = 0; var10 < var9.size(); ++var10) {
                     var7 += ((BonEncaissementVente)var9.get(var10)).getBonAPayer();
                  }
               }

               if (var6.getComTotReglement() + var7 < var6.getComTotCommission()) {
                  ++var3;
                  var1 += var6.getComTotCommission() - var6.getComTotReglement() - var7;
                  this.listCommissionSelectionne.add(var6);
               }
            }
         }

         this.utilInitHibernate.closeSession();
         if (var1 != 0.0D && var3 >= 2) {
            this.var_netAPayer = var1;
            this.montantElmTotBonEnc = this.var_netAPayer;
            this.datamodelPaiement.setWrappedData(this.listCommissionSelectionne);
            this.showModalPanelPayeMultiple = true;
         } else {
            if (this.var_tot_bon_encaissement > this.commissionEnteteVentes.getComTotCommission()) {
               this.commissionEnteteVentes.setComTypeReg(4);
               this.var_verouxModReg = true;
               this.var_affichMontant = false;
               this.var_netAPayer = this.commissionEnteteVentes.getComTotCommission() - this.var_tot_bon_encaissement;
               this.verifBonEncaissement();
            } else {
               this.commissionEnteteVentes.setComTypeReg(0);
               this.var_verouxModReg = false;
               this.var_netAPayer = this.commissionEnteteVentes.getComTotCommission() - this.var_tot_bon_encaissement;
               this.verifBonEncaissement();
               this.var_affichMontant = true;
            }

            this.montantElmTotBonEnc = this.var_netAPayer;
            this.showModalPanelPaye = true;
         }
      }

   }

   public void verifBonEncaissement() {
      if (this.montantElmTotBonEnc <= this.commissionEnteteVentes.getComTotCommission() - this.var_tot_bon_encaissement) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

   }

   public void annulePaye() {
      this.showModalPanelPaye = false;
   }

   public void annulePayeMultiple() {
      this.showModalPanelPayeMultiple = false;
   }

   public void chargerModReg() {
      if (this.commissionEnteteVentes.getComTypeReg() != 4 && this.commissionEnteteVentes.getComTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      if (this.var_tot_bon_encaissement <= this.commissionEnteteVentes.getComTotCommission()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommissionEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.calculChrono.numCompose(new Date(), 29, this.factureEnteteVentes.getFacSerie(), var1);
            if (this.listCommissionSelectionne.size() > 1) {
               for(int var4 = 0; var4 < this.listCommissionSelectionne.size(); ++var4) {
                  new CommissionEnteteVentes();
                  CommissionEnteteVentes var5 = (CommissionEnteteVentes)this.listCommissionSelectionne.get(var4);
                  if (var5.isVar_select_ligne()) {
                     this.bonEncaissementVente = new BonEncaissementVente();
                     this.bonEncaissementVente.setBonDateCreat(new Date());
                     this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
                     this.bonEncaissementVente.setBonActivite(var5.getComActivite());
                     this.bonEncaissementVente.setBonSite(var5.getComSite());
                     this.bonEncaissementVente.setBonDepartement(var5.getComDepartement());
                     this.bonEncaissementVente.setBonService(var5.getComService());
                     this.bonEncaissementVente.setBonRegion("");
                     this.bonEncaissementVente.setBonSecteur("");
                     this.bonEncaissementVente.setBonPdv("");
                     this.bonEncaissementVente.setBonDateEcheReg(var5.getComDateEcheReg());
                     this.bonEncaissementVente.setBonEtat(0);
                     this.bonEncaissementVente.setBonNatRef(this.nature);
                     if (this.optionsVentes.getResponsable().equals("1")) {
                        this.bonEncaissementVente.setBonNomResponsable(var5.getComNomCommercial());
                        this.bonEncaissementVente.setBonNomContact(var5.getComNomCommercial());
                        this.bonEncaissementVente.setBonIdContact(var5.getComIdCommercial());
                     } else {
                        this.bonEncaissementVente.setBonNomResponsable(var5.getComNomResponsable());
                        this.bonEncaissementVente.setBonNomContact(var5.getComNomResponsable());
                        this.bonEncaissementVente.setBonIdContact(var5.getComIdResponsable());
                     }

                     this.bonEncaissementVente.setBonNomTiers(this.bonEncaissementVente.getBonNomResponsable());
                     this.bonEncaissementVente.setBonIdTiers(0L);
                     this.bonEncaissementVente.setBonTypeTiers(0);
                     this.bonEncaissementVente.setBonLibelle("Règlement Commission N° " + var5.getComNum());
                     this.bonEncaissementVente.setBonRef(var5.getComNum());
                     this.bonEncaissementVente.setBonIdRef(var5.getComId());
                     this.bonEncaissementVente.setBonObject("");
                     this.bonEncaissementVente.setBonObservation("");
                     this.bonEncaissementVente.setBonSerie("");
                     this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
                     this.bonEncaissementVente.setBonTotTtc(var5.getComTotCommission());
                     this.bonEncaissementVente.setBonAPayer(var5.getComTotCommission());
                     this.bonEncaissementVente.setBonTypeReg(var5.getComTypeReg());
                     this.bonEncaissementVente.setBonActif(0);
                     this.bonEncaissementVente.setBonNum(var3);
                     this.bonEncaissementVente.setBonDate(new Date());
                     this.bonEncaissementVente = this.bonEncaissementVenteDao.insert(this.bonEncaissementVente, var1);
                  }
               }
            } else {
               this.bonEncaissementVente = new BonEncaissementVente();
               this.bonEncaissementVente.setBonDateCreat(new Date());
               this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
               this.bonEncaissementVente.setBonActivite(this.commissionEnteteVentes.getComActivite());
               this.bonEncaissementVente.setBonSite(this.commissionEnteteVentes.getComSite());
               this.bonEncaissementVente.setBonDepartement(this.commissionEnteteVentes.getComDepartement());
               this.bonEncaissementVente.setBonService(this.commissionEnteteVentes.getComService());
               this.bonEncaissementVente.setBonRegion("");
               this.bonEncaissementVente.setBonSecteur("");
               this.bonEncaissementVente.setBonPdv("");
               this.bonEncaissementVente.setBonDateEcheReg(this.commissionEnteteVentes.getComDateEcheReg());
               this.bonEncaissementVente.setBonEtat(0);
               this.bonEncaissementVente.setBonNatRef(this.nature);
               if (this.optionsVentes.getResponsable().equals("1")) {
                  this.bonEncaissementVente.setBonNomResponsable(this.commissionEnteteVentes.getComNomCommercial());
                  this.bonEncaissementVente.setBonNomContact(this.commissionEnteteVentes.getComNomCommercial());
                  this.bonEncaissementVente.setBonIdContact(this.commissionEnteteVentes.getComIdCommercial());
               } else {
                  this.bonEncaissementVente.setBonNomResponsable(this.commissionEnteteVentes.getComNomResponsable());
                  this.bonEncaissementVente.setBonNomContact(this.commissionEnteteVentes.getComNomResponsable());
                  this.bonEncaissementVente.setBonIdContact(this.commissionEnteteVentes.getComIdResponsable());
               }

               this.bonEncaissementVente.setBonNomTiers(this.bonEncaissementVente.getBonNomResponsable());
               this.bonEncaissementVente.setBonIdTiers(0L);
               this.bonEncaissementVente.setBonTypeTiers(0);
               this.bonEncaissementVente.setBonLibelle("Règlement Commission N° " + this.commissionEnteteVentes.getComNum());
               this.bonEncaissementVente.setBonRef(this.commissionEnteteVentes.getComNum());
               this.bonEncaissementVente.setBonIdRef(this.commissionEnteteVentes.getComId());
               this.bonEncaissementVente.setBonObject("");
               this.bonEncaissementVente.setBonObservation("");
               this.bonEncaissementVente.setBonSerie("");
               this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
               this.bonEncaissementVente.setBonTotTtc(this.commissionEnteteVentes.getComTotCommission());
               this.bonEncaissementVente.setBonAPayer(this.montantElmTotBonEnc);
               this.bonEncaissementVente.setBonTypeReg(this.commissionEnteteVentes.getComTypeReg());
               this.bonEncaissementVente.setBonActif(0);
               this.bonEncaissementVente.setBonNum(var3);
               this.bonEncaissementVente.setBonDate(new Date());
               this.bonEncaissementVente = this.bonEncaissementVenteDao.insert(this.bonEncaissementVente, var1);
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

      this.showModalPanelPaye = false;
      this.showModalPanelPayeMultiple = false;
      this.visibiliteBton = false;
   }

   public void choixCaisse() {
      if (this.var_inputCaisse.equalsIgnoreCase("0")) {
         this.bonEncaissementVente.setBonCodeCaisse("");
         this.bonEncaissementVente.setBonLibCaisse("");
      } else {
         String[] var1 = this.var_inputCaisse.split(":");
         this.bonEncaissementVente.setBonCodeCaisse(var1[0]);
         this.bonEncaissementVente.setBonLibCaisse(var1[1]);
      }

   }

   public void ajoutCalcul() throws ParseException {
      if (this.inpNb == 0) {
         this.inpNb = 40;
      }

      if (this.inpDu == null) {
         this.inpDu = this.utilDate.datePremierJourMois(new Date());
      }

      if (this.inpAu == null) {
         this.inpAu = this.utilDate.dateDernierJourMois(new Date());
      }

      this.inpDate = new Date();
      this.inpResponsable = "";
      this.inpCommercial = "";
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
      this.listCommission.clear();
      this.listDetailFacture.clear();
      this.listDetailAvoir.clear();
      this.listDetailNoteDebit.clear();
      this.listDetailReglement.clear();
      if (this.inpNb == 0) {
         this.inpNb = 40;
      }

      if (this.inpDu == null) {
         this.inpDu = this.utilDate.datePremierJourMois(new Date());
      }

      if (this.inpAu == null) {
         this.inpAu = this.utilDate.dateDernierJourMois(new Date());
      }

      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommissionEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (!this.optionsVentes.getModeCommission().equals("1") && !this.optionsVentes.getModeCommission().equals("2")) {
            if (this.optionsVentes.getModeCommission().equals("3")) {
               this.calculReglement(var1);
            }
         } else {
            if (this.optionsVentes.getFacture().equals("true")) {
               this.calculFacture(var1);
            }

            if (this.optionsVentes.getAvoir().equals("true")) {
               this.calculAvoir(var1);
            }

            if (this.optionsVentes.getNoteDebit().equals("true")) {
               this.calculNoteDebit(var1);
            }
         }

         if (!this.var_anal_activite) {
            this.commissionEnteteVentes.setComActivite("");
         } else if (this.decoupageActivite) {
            String var3 = "";
            boolean var4 = true;
            if (this.lesDecoupagesActivites.size() != 0) {
               for(int var5 = 0; var5 < this.lesDecoupagesActivites.size(); ++var5) {
                  this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var5);
                  if (this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie() != 0.0D) {
                     if (var4) {
                        var3 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                        var4 = false;
                     } else {
                        var3 = var3 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     }
                  }
               }
            }

            this.commissionEnteteVentes.setComActivite(var3);
         }

         ArrayList var11 = new ArrayList();
         this.documentEntete = new DocumentEntete();
         int var12;
         if (this.listDetailFacture.size() != 0) {
            for(var12 = 0; var12 < this.listDetailFacture.size(); ++var12) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdCommercial(((FactureLigneVentes)this.listDetailFacture.get(var12)).getFactureEnteteVentes().getFacIdCommercial());
               this.documentEntete.setDocNomContact(((FactureLigneVentes)this.listDetailFacture.get(var12)).getFactureEnteteVentes().getFacNomCommercial());
               this.documentEntete.setDocIdResponsable(((FactureLigneVentes)this.listDetailFacture.get(var12)).getFactureEnteteVentes().getFacIdResponsable());
               this.documentEntete.setDocNomResponsable(((FactureLigneVentes)this.listDetailFacture.get(var12)).getFactureEnteteVentes().getFacNomResponsable());
               this.documentEntete.setDocIdEquipe(((FactureLigneVentes)this.listDetailFacture.get(var12)).getFactureEnteteVentes().getFacIdEquipe());
               this.documentEntete.setDocNomEquipe(((FactureLigneVentes)this.listDetailFacture.get(var12)).getFactureEnteteVentes().getFacNomEquipe());
               var11.add(this.documentEntete);
            }
         }

         if (this.listDetailAvoir.size() != 0) {
            for(var12 = 0; var12 < this.listDetailAvoir.size(); ++var12) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdCommercial(((AvoirLigneVentes)this.listDetailAvoir.get(var12)).getAvoirEnteteVentes().getAvrIdCommercial());
               this.documentEntete.setDocNomContact(((AvoirLigneVentes)this.listDetailAvoir.get(var12)).getAvoirEnteteVentes().getAvrNomCommercial());
               this.documentEntete.setDocIdResponsable(((AvoirLigneVentes)this.listDetailAvoir.get(var12)).getAvoirEnteteVentes().getAvrIdResponsable());
               this.documentEntete.setDocNomResponsable(((AvoirLigneVentes)this.listDetailAvoir.get(var12)).getAvoirEnteteVentes().getAvrNomResponsable());
               this.documentEntete.setDocIdEquipe(((AvoirLigneVentes)this.listDetailAvoir.get(var12)).getAvoirEnteteVentes().getAvrIdEquipe());
               this.documentEntete.setDocNomEquipe(((AvoirLigneVentes)this.listDetailAvoir.get(var12)).getAvoirEnteteVentes().getAvrNomEquipe());
               var11.add(this.documentEntete);
            }
         }

         if (this.listDetailNoteDebit.size() != 0) {
            for(var12 = 0; var12 < this.listDetailNoteDebit.size(); ++var12) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdCommercial(((NoteDebitLigneVentes)this.listDetailNoteDebit.get(var12)).getNoteDebitEnteteVentes().getNdbIdCommercial());
               this.documentEntete.setDocNomContact(((NoteDebitLigneVentes)this.listDetailNoteDebit.get(var12)).getNoteDebitEnteteVentes().getNdbNomCommercial());
               this.documentEntete.setDocIdResponsable(((NoteDebitLigneVentes)this.listDetailNoteDebit.get(var12)).getNoteDebitEnteteVentes().getNdbIdResponsable());
               this.documentEntete.setDocNomResponsable(((NoteDebitLigneVentes)this.listDetailNoteDebit.get(var12)).getNoteDebitEnteteVentes().getNdbNomResponsable());
               this.documentEntete.setDocIdEquipe(((NoteDebitLigneVentes)this.listDetailNoteDebit.get(var12)).getNoteDebitEnteteVentes().getNdbIdEquipe());
               this.documentEntete.setDocNomEquipe(((NoteDebitLigneVentes)this.listDetailNoteDebit.get(var12)).getNoteDebitEnteteVentes().getNdbNomEquipe());
               var11.add(this.documentEntete);
            }
         }

         if (this.listDetailReglement.size() != 0) {
            for(var12 = 0; var12 < this.listDetailReglement.size(); ++var12) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdCommercial(((Reglements)this.listDetailReglement.get(var12)).getRglIdCommercial());
               this.documentEntete.setDocNomContact(((Reglements)this.listDetailReglement.get(var12)).getRglNomCommercial());
               this.documentEntete.setDocIdResponsable(((Reglements)this.listDetailReglement.get(var12)).getRglIdResponsable());
               this.documentEntete.setDocNomResponsable(((Reglements)this.listDetailReglement.get(var12)).getRglNomResponsable());
               this.documentEntete.setDocIdEquipe(((Reglements)this.listDetailReglement.get(var12)).getRglIdEquipe());
               this.documentEntete.setDocNomEquipe(((Reglements)this.listDetailReglement.get(var12)).getRglNomEquipe());
               var11.add(this.documentEntete);
            }
         }

         if (var11.size() != 0) {
            Object var13 = new ArrayList();
            if (!this.optionsVentes.getModeCommission().equals("1") && !this.optionsVentes.getModeCommission().equals("2")) {
               if (this.optionsVentes.getModeCommission().equals("3")) {
                  var13 = this.calculListeUsersByUser(var11, (List)var13, var1);
               }
            } else {
               var13 = this.calculListeUsersByProduit(var11, (List)var13, var1);
            }

            if (((List)var13).size() != 0) {
               if (this.optionsVentes.getResponsable().equals("1")) {
                  this.miseAJourCommerciaux((List)var13, var1);
               } else {
                  this.miseAJourResponsables((List)var13, var1);
               }
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

      this.showModalPanelAjoutCalcul = false;
      this.visibiliteBton = false;
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.executerRequete((Session)null);
   }

   public void calculFacture(Session var1) throws HibernateException, NamingException, ParseException {
      new ArrayList();
      Object var3 = new ArrayList();
      String var4 = this.utilDate.dateToStringSQLLight(this.inpDu) + " 00:00:00";
      String var5 = this.utilDate.dateToStringSQLLight(this.inpAu) + " 23:59:59";
      List var2 = this.factureEnteteVentesDao.rechercheCommissions(var4, var5, var1);
      if (var2.size() != 0) {
         for(int var6 = 0; var6 < var2.size(); ++var6) {
            this.factureEnteteVentes = new FactureEnteteVentes();
            this.factureEnteteVentes = (FactureEnteteVentes)var2.get(var6);
            if (this.factureEnteteVentes.getFacDateLastReg() != null && (this.factureEnteteVentes.getFacDateLastReg().before(this.inpDate) || this.factureEnteteVentes.getFacDateLastReg().equals(this.inpDate))) {
               long var7 = (this.factureEnteteVentes.getFacDateLastReg().getTime() - this.factureEnteteVentes.getFacDate().getTime()) / 86400000L;
               if (var7 <= (long)this.inpNb) {
                  ((List)var3).clear();
                  var3 = this.factureLigneVentesDao.chargerLesLignes(this.factureEnteteVentes, var1);
                  if (((List)var3).size() != 0) {
                     for(int var9 = 0; var9 < ((List)var3).size(); ++var9) {
                        this.factureLigneVentes = new FactureLigneVentes();
                        this.factureLigneVentes = (FactureLigneVentes)((List)var3).get(var9);
                        if (this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty()) {
                           this.produits = this.produitsVtesDao.chargeProduit(this.factureLigneVentes.getFacligCode(), var1);
                           if (this.produits != null && this.factureLigneVentes.getFacligQte() != 0.0F && this.factureLigneVentes.getFacligCommission() == 0.0D) {
                              this.factureLigneVentes.setCom_num(this.factureEnteteVentes.getFacNum());
                              this.factureLigneVentes.setCom_date(this.factureEnteteVentes.getFacDate());
                              this.factureLigneVentes.setCom_lastDatereg(this.factureEnteteVentes.getFacDateLastReg());
                              this.factureLigneVentes.setCom_nbJour(var7);
                              this.factureLigneVentes.setCom_serie(this.factureEnteteVentes.getFacSerie());
                              this.factureLigneVentes.setCom_cat(this.factureEnteteVentes.getFacCat());
                              this.factureLigneVentes.setCom_nomTiers(this.factureEnteteVentes.getFacNomTiers());
                              this.factureLigneVentes.setCom_idTiers(this.factureEnteteVentes.getTiers().getTieid());
                              this.factureLigneVentes.setCom_civilite(this.factureEnteteVentes.getFacCivilTiers());
                              this.factureLigneVentes.setCom_nomContact(this.factureEnteteVentes.getFacNomContact());
                              this.factureLigneVentes.setCom_idContact(this.factureEnteteVentes.getFacIdContact());
                              this.factureLigneVentes.setCom_civiliteContact(this.factureEnteteVentes.getFacCivilContact());
                              this.factureLigneVentes.setCom_nomResponsable(this.factureEnteteVentes.getFacNomResponsable());
                              this.factureLigneVentes.setCom_idResponsable(this.factureEnteteVentes.getFacIdResponsable());
                              this.factureLigneVentes.setCom_nomCommercial(this.factureEnteteVentes.getFacNomCommercial());
                              this.factureLigneVentes.setCom_idCommercial(this.factureEnteteVentes.getFacIdCommercial());
                              this.factureLigneVentes.setCom_nomEquipe(this.factureEnteteVentes.getFacNomEquipe());
                              this.factureLigneVentes.setCom_idEquipe(this.factureEnteteVentes.getFacIdEquipe());
                              double var10;
                              if (this.produits.getProComUnite() != 0.0D && this.optionsVentes.getModeCommission().equals("1")) {
                                 this.factureLigneVentes.setVar_comUnite(this.produits.getProComUnite());
                                 var10 = (double)this.factureLigneVentes.getFacligQte() * this.factureLigneVentes.getVar_comUnite();
                                 this.factureLigneVentes.setVar_totCommission(this.utilNombre.myRoundDevise(var10, this.structureLog.getStrdevise()));
                                 this.listDetailFacture.add(this.factureLigneVentes);
                              } else if (this.produits.getProComPourcentage() != 0.0F && this.optionsVentes.getModeCommission().equals("2")) {
                                 this.factureLigneVentes.setVar_comPourcentage(this.produits.getProComPourcentage());
                                 var10 = this.factureLigneVentes.getFacligPt() * (double)this.factureLigneVentes.getVar_comPourcentage() / 100.0D;
                                 this.factureLigneVentes.setVar_totCommission(this.utilNombre.myRoundDevise(var10, this.structureLog.getStrdevise()));
                                 this.listDetailFacture.add(this.factureLigneVentes);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void calculAvoir(Session var1) throws HibernateException, NamingException, ParseException {
      new ArrayList();
      Object var3 = new ArrayList();
      List var2 = this.avoirEnteteVentesDao.rechercheCommissions(this.inpDu, this.inpAu, var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            this.avoirEnteteVentes = new AvoirEnteteVentes();
            this.avoirEnteteVentes = (AvoirEnteteVentes)var2.get(var4);
            if (this.avoirEnteteVentes.getAvrDateLastReg() != null && (this.avoirEnteteVentes.getAvrDateLastReg().before(this.inpDate) || this.avoirEnteteVentes.getAvrDateLastReg().equals(this.inpDate))) {
               long var5 = (this.avoirEnteteVentes.getAvrDateLastReg().getTime() - this.avoirEnteteVentes.getAvrDate().getTime()) / 86400000L;
               if (var5 <= (long)this.inpNb) {
                  ((List)var3).clear();
                  var3 = this.avoirLigneVentesDao.chargerLesLignes(this.avoirEnteteVentes, var1);
                  if (((List)var3).size() != 0) {
                     for(int var7 = 0; var7 < ((List)var3).size(); ++var7) {
                        this.avoirLigneVentes = new AvoirLigneVentes();
                        this.avoirLigneVentes = (AvoirLigneVentes)((List)var3).get(var7);
                        if (this.avoirLigneVentes.getAvrligCode() != null && !this.avoirLigneVentes.getAvrligCode().isEmpty()) {
                           this.produits = this.produitsVtesDao.chargeProduit(this.avoirLigneVentes.getAvrligCode(), var1);
                           if (this.produits != null && this.avoirLigneVentes.getAvrligQte() != 0.0F && this.avoirLigneVentes.getAvrligCommission() == 0.0D) {
                              this.avoirLigneVentes.setCom_num(this.avoirEnteteVentes.getAvrNum());
                              this.avoirLigneVentes.setCom_date(this.avoirEnteteVentes.getAvrDate());
                              this.avoirLigneVentes.setCom_lastDatereg(this.avoirEnteteVentes.getAvrDateLastReg());
                              this.avoirLigneVentes.setCom_nbJour(var5);
                              this.avoirLigneVentes.setCom_serie(this.avoirEnteteVentes.getAvrSerie());
                              this.avoirLigneVentes.setCom_cat(this.avoirEnteteVentes.getAvrCat());
                              this.avoirLigneVentes.setCom_nomTiers(this.avoirEnteteVentes.getAvrNomTiers());
                              this.avoirLigneVentes.setCom_idTiers(this.avoirEnteteVentes.getTiers().getTieid());
                              this.avoirLigneVentes.setCom_civilite(this.avoirEnteteVentes.getAvrCivilTiers());
                              this.avoirLigneVentes.setCom_nomContact(this.avoirEnteteVentes.getAvrNomContact());
                              this.avoirLigneVentes.setCom_idContact(this.avoirEnteteVentes.getAvrIdContact());
                              this.avoirLigneVentes.setCom_civiliteContact(this.avoirEnteteVentes.getAvrCivilContact());
                              this.avoirLigneVentes.setCom_nomResponsable(this.avoirEnteteVentes.getAvrNomResponsable());
                              this.avoirLigneVentes.setCom_idResponsable(this.avoirEnteteVentes.getAvrIdResponsable());
                              this.avoirLigneVentes.setCom_nomCommercial(this.avoirEnteteVentes.getAvrNomCommercial());
                              this.avoirLigneVentes.setCom_idCommercial(this.avoirEnteteVentes.getAvrIdCommercial());
                              this.avoirLigneVentes.setCom_nomEquipe(this.avoirEnteteVentes.getAvrNomEquipe());
                              this.avoirLigneVentes.setCom_idEquipe(this.avoirEnteteVentes.getAvrIdEquipe());
                              double var8;
                              if (this.produits.getProComUnite() != 0.0D && this.optionsVentes.getModeCommission().equals("1")) {
                                 this.avoirLigneVentes.setVar_comUnite(this.produits.getProComUnite());
                                 var8 = (double)this.avoirLigneVentes.getAvrligQte() * this.avoirLigneVentes.getVar_comUnite();
                                 this.avoirLigneVentes.setVar_totCommission(this.utilNombre.myRoundDevise(var8, this.structureLog.getStrdevise()));
                                 this.listDetailAvoir.add(this.avoirLigneVentes);
                              } else if (this.produits.getProComPourcentage() != 0.0F && this.optionsVentes.getModeCommission().equals("2")) {
                                 this.avoirLigneVentes.setVar_comPourcentage(this.produits.getProComPourcentage());
                                 var8 = this.avoirLigneVentes.getAvrligPt() * (double)this.avoirLigneVentes.getVar_comPourcentage() / 100.0D;
                                 this.avoirLigneVentes.setVar_totCommission(this.utilNombre.myRoundDevise(var8, this.structureLog.getStrdevise()));
                                 this.listDetailAvoir.add(this.avoirLigneVentes);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void calculNoteDebit(Session var1) throws HibernateException, NamingException, ParseException {
      new ArrayList();
      Object var3 = new ArrayList();
      List var2 = this.noteDebitEnteteVentesDao.rechercheCommissions(this.inpDu, this.inpAu, var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            this.noteDebitEnteteVentes = new NoteDebitEnteteVentes();
            this.noteDebitEnteteVentes = (NoteDebitEnteteVentes)var2.get(var4);
            if (this.noteDebitEnteteVentes.getNdbDateLastReg() != null && (this.noteDebitEnteteVentes.getNdbDateLastReg().before(this.inpDate) || this.noteDebitEnteteVentes.getNdbDateLastReg().equals(this.inpDate))) {
               long var5 = (this.noteDebitEnteteVentes.getNdbDateLastReg().getTime() - this.noteDebitEnteteVentes.getNdbDate().getTime()) / 86400000L;
               if (var5 <= (long)this.inpNb) {
                  ((List)var3).clear();
                  var3 = this.noteDebitLigneVentesDao.chargerLesLignes(this.noteDebitEnteteVentes, var1);
                  if (((List)var3).size() != 0) {
                     for(int var7 = 0; var7 < ((List)var3).size(); ++var7) {
                        this.noteDebitLigneVentes = new NoteDebitLigneVentes();
                        this.noteDebitLigneVentes = (NoteDebitLigneVentes)((List)var3).get(var7);
                        if (this.noteDebitLigneVentes.getNdbligCode() != null && !this.noteDebitLigneVentes.getNdbligCode().isEmpty()) {
                           this.produits = this.produitsVtesDao.chargeProduit(this.noteDebitLigneVentes.getNdbligCode(), var1);
                           if (this.produits != null && this.noteDebitLigneVentes.getNdbligQte() != 0.0F && this.noteDebitLigneVentes.getNdbligCommission() == 0.0D) {
                              this.noteDebitLigneVentes.setCom_num(this.noteDebitEnteteVentes.getNdbNum());
                              this.noteDebitLigneVentes.setCom_date(this.noteDebitEnteteVentes.getNdbDate());
                              this.noteDebitLigneVentes.setCom_lastDatereg(this.noteDebitEnteteVentes.getNdbDateLastReg());
                              this.noteDebitLigneVentes.setCom_nbJour(var5);
                              this.noteDebitLigneVentes.setCom_serie(this.noteDebitEnteteVentes.getNdbSerie());
                              this.noteDebitLigneVentes.setCom_cat(this.noteDebitEnteteVentes.getNdbCat());
                              this.noteDebitLigneVentes.setCom_nomTiers(this.noteDebitEnteteVentes.getNdbNomTiers());
                              this.noteDebitLigneVentes.setCom_idTiers(this.noteDebitEnteteVentes.getTiers().getTieid());
                              this.noteDebitLigneVentes.setCom_civilite(this.noteDebitEnteteVentes.getNdbCivilTiers());
                              this.noteDebitLigneVentes.setCom_nomContact(this.noteDebitEnteteVentes.getNdbNomContact());
                              this.noteDebitLigneVentes.setCom_idContact(this.noteDebitEnteteVentes.getNdbIdContact());
                              this.noteDebitLigneVentes.setCom_civiliteContact(this.noteDebitEnteteVentes.getNdbCivilContact());
                              this.noteDebitLigneVentes.setCom_nomResponsable(this.noteDebitEnteteVentes.getNdbNomResponsable());
                              this.noteDebitLigneVentes.setCom_idResponsable(this.noteDebitEnteteVentes.getNdbIdResponsable());
                              this.noteDebitLigneVentes.setCom_nomCommercial(this.noteDebitEnteteVentes.getNdbNomCommercial());
                              this.noteDebitLigneVentes.setCom_idCommercial(this.noteDebitEnteteVentes.getNdbIdCommercial());
                              this.noteDebitLigneVentes.setCom_nomEquipe(this.noteDebitEnteteVentes.getNdbNomEquipe());
                              this.noteDebitLigneVentes.setCom_idEquipe(this.noteDebitEnteteVentes.getNdbIdEquipe());
                              double var8;
                              if (this.produits.getProComUnite() != 0.0D && this.optionsVentes.getModeCommission().equals("1")) {
                                 this.noteDebitLigneVentes.setVar_comUnite(this.produits.getProComUnite());
                                 var8 = (double)this.noteDebitLigneVentes.getNdbligQte() * this.noteDebitLigneVentes.getVar_comUnite();
                                 this.noteDebitLigneVentes.setVar_totCommission(this.utilNombre.myRoundDevise(var8, this.structureLog.getStrdevise()));
                                 this.listDetailNoteDebit.add(this.noteDebitLigneVentes);
                              } else if (this.produits.getProComPourcentage() != 0.0F && this.optionsVentes.getModeCommission().equals("2")) {
                                 this.noteDebitLigneVentes.setVar_comPourcentage(this.produits.getProComPourcentage());
                                 var8 = this.noteDebitLigneVentes.getNdbligPt() * (double)this.noteDebitLigneVentes.getVar_comPourcentage() / 100.0D;
                                 this.noteDebitLigneVentes.setVar_totCommission(this.utilNombre.myRoundDevise(var8, this.structureLog.getStrdevise()));
                                 this.listDetailNoteDebit.add(this.noteDebitLigneVentes);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void calculReglement(Session var1) throws NamingException {
      new ArrayList();
      List var2 = this.reglementsDao.rechercheCommissions(this.inpDu, this.inpAu, var1);
      new Users();
      UserDao var4 = new UserDao(this.baseLog, this.utilInitHibernate);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            this.reglements = new Reglements();
            this.reglements = (Reglements)var2.get(var5);
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
                  var3 = var4.selectByIdUsers(this.reglements.getRglIdResponsable(), var1);
               } else if (this.reglements.getRglIdResponsable() == 0L && this.reglements.getRglIdCommercial() != 0L && this.reglements.getRglIdEquipe() == 0L) {
                  var3 = var4.selectByIdUsers(this.reglements.getRglIdCommercial(), var1);
               } else if (this.reglements.getRglIdResponsable() == 0L && this.reglements.getRglIdCommercial() == 0L && this.reglements.getRglIdEquipe() != 0L) {
                  var3 = var4.selectByIdUsers(this.reglements.getRglIdEquipe(), var1);
               } else if (this.reglements.getRglIdResponsable() != 0L) {
                  var3 = var4.selectByIdUsers(this.reglements.getRglIdResponsable(), var1);
               } else if (this.reglements.getRglIdCommercial() != 0L) {
                  var3 = var4.selectByIdUsers(this.reglements.getRglIdCommercial(), var1);
               } else if (this.reglements.getRglIdEquipe() != 0L) {
                  var3 = var4.selectByIdUsers(this.reglements.getRglIdEquipe(), var1);
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

   public List calculListeUsersByUser(List var1, List var2, Session var3) throws HibernateException, NamingException {
      new Users();
      UserDao var5 = new UserDao(this.baseLog, this.utilInitHibernate);
      Users var4;
      int var6;
      long var7;
      boolean var9;
      int var10;
      if (this.optionsVentes.getResponsable().equals("1")) {
         for(var6 = 0; var6 < var1.size(); ++var6) {
            var7 = ((DocumentEntete)var1.get(var6)).getDocIdCommercial();
            if (var7 != 0L) {
               if (var2.size() == 0) {
                  new Users();
                  var4 = var5.selectByIdUsers(var7, var3);
                  if (var4 != null && (this.inpIdCommercial == 0L || this.inpIdCommercial != 0L && this.inpIdCommercial == var4.getUsrid()) && var4.getUsrCommType() >= 3) {
                     var2.add(var4);
                  }
               } else {
                  var9 = false;

                  for(var10 = 0; var10 < var2.size(); ++var10) {
                     if (((Users)var2.get(var10)).getUsrid() == var7) {
                        var9 = true;
                        break;
                     }
                  }

                  if (!var9) {
                     new Users();
                     var4 = var5.selectByIdUsers(var7, var3);
                     if (var4 != null && (this.inpIdCommercial == 0L || this.inpIdCommercial != 0L && this.inpIdCommercial == var4.getUsrid()) && var4.getUsrCommType() >= 3) {
                        var2.add(var4);
                     }
                  }
               }
            }
         }
      } else {
         for(var6 = 0; var6 < var1.size(); ++var6) {
            var7 = ((DocumentEntete)var1.get(var6)).getDocIdResponsable();
            if (var7 != 0L) {
               if (var2.size() == 0) {
                  new Users();
                  var4 = var5.selectByIdUsers(var7, var3);
                  if (var4 != null && (this.inpIdResponsable == 0L || this.inpIdResponsable != 0L && this.inpIdResponsable == var4.getUsrid()) && var4.getUsrCommType() >= 3) {
                     var2.add(var4);
                  }
               } else {
                  var9 = false;

                  for(var10 = 0; var10 < var2.size(); ++var10) {
                     if (((Users)var2.get(var10)).getUsrid() == var7) {
                        var9 = true;
                        break;
                     }
                  }

                  if (!var9) {
                     new Users();
                     var4 = var5.selectByIdUsers(var7, var3);
                     if (var4 != null && (this.inpIdResponsable == 0L || this.inpIdResponsable != 0L && this.inpIdResponsable == var4.getUsrid()) && var4.getUsrCommType() >= 3) {
                        var2.add(var4);
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public List calculListeUsersByProduit(List var1, List var2, Session var3) throws HibernateException, NamingException {
      new Users();
      UserDao var5 = new UserDao(this.baseLog, this.utilInitHibernate);
      Users var4;
      int var6;
      long var7;
      boolean var9;
      int var10;
      if (this.optionsVentes.getResponsable().equals("1")) {
         for(var6 = 0; var6 < var1.size(); ++var6) {
            var7 = ((DocumentEntete)var1.get(var6)).getDocIdCommercial();
            if (var7 != 0L) {
               if (var2.size() == 0) {
                  new Users();
                  var4 = var5.selectByIdUsers(var7, var3);
                  if (var4 != null && (this.inpIdCommercial == 0L || this.inpIdCommercial != 0L && this.inpIdCommercial == var4.getUsrid())) {
                     var2.add(var4);
                  }
               } else {
                  var9 = false;

                  for(var10 = 0; var10 < var2.size(); ++var10) {
                     if (((Users)var2.get(var10)).getUsrid() == var7) {
                        var9 = true;
                        break;
                     }
                  }

                  if (!var9) {
                     new Users();
                     var4 = var5.selectByIdUsers(var7, var3);
                     if (var4 != null && (this.inpIdCommercial == 0L || this.inpIdCommercial != 0L && this.inpIdCommercial == var4.getUsrid())) {
                        var2.add(var4);
                     }
                  }
               }
            }
         }
      } else {
         for(var6 = 0; var6 < var1.size(); ++var6) {
            var7 = ((DocumentEntete)var1.get(var6)).getDocIdResponsable();
            if (var7 != 0L) {
               if (var2.size() == 0) {
                  new Users();
                  var4 = var5.selectByIdUsers(var7, var3);
                  if (var4 != null && (this.inpIdResponsable == 0L || this.inpIdResponsable != 0L && this.inpIdResponsable == var4.getUsrid())) {
                     var2.add(var4);
                  }
               } else {
                  var9 = false;

                  for(var10 = 0; var10 < var2.size(); ++var10) {
                     if (((Users)var2.get(var10)).getUsrid() == var7) {
                        var9 = true;
                        break;
                     }
                  }

                  if (!var9) {
                     new Users();
                     var4 = var5.selectByIdUsers(var7, var3);
                     if (var4 != null && (this.inpIdResponsable == 0L || this.inpIdResponsable != 0L && this.inpIdResponsable == var4.getUsrid())) {
                        var2.add(var4);
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public void miseAJourCommerciaux(List var1, Session var2) throws HibernateException, NamingException {
      new Users();
      if (var1.size() != 0) {
         for(int var4 = 0; var4 < var1.size(); ++var4) {
            new Users();
            Users var3 = (Users)var1.get(var4);
            String var5 = this.calculChrono.numCompose(this.inpDu, this.nature, "", var2);
            this.commissionEnteteVentes = new CommissionEnteteVentes();
            this.commissionEnteteVentes.setComIdCommercial(var3.getUsrid());
            this.commissionEnteteVentes.setComNomCommercial(var3.getUsrPatronyme());
            this.commissionEnteteVentes.setComIdResponsable(0L);
            this.commissionEnteteVentes.setComNomResponsable("");
            this.commissionEnteteVentes.setComIdEquipe(0L);
            this.commissionEnteteVentes.setComNomEquipe("");
            this.commissionEnteteVentes.setComActivite("");
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
            this.commissionEnteteVentes.setComNum(var5);
            this.commissionEnteteVentes.setComService("");
            this.commissionEnteteVentes.setComSite("");
            this.commissionEnteteVentes.setComSolde(0);
            this.commissionEnteteVentes.setComTotCommission(0.0D);
            this.commissionEnteteVentes.setComTotReglement(0.0D);
            this.commissionEnteteVentes.setComTypeReg(0);
            this.commissionEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.verifieExistenceHabilitation(var2);
            this.commissionEnteteVentes = this.commissionEnteteVentesDao.insert(this.commissionEnteteVentes, var2);
            double var6 = 0.0D;
            int var8;
            if (this.listDetailFacture.size() != 0) {
               for(var8 = 0; var8 < this.listDetailFacture.size(); ++var8) {
                  this.factureLigneVentes = new FactureLigneVentes();
                  this.factureLigneVentes = (FactureLigneVentes)this.listDetailFacture.get(var8);
                  if (this.factureLigneVentes.getFactureEnteteVentes().getFacIdCommercial() == var3.getUsrid()) {
                     this.commissionLigneVentes = new CommissionLigneVentes();
                     this.commissionLigneVentes.setComligNature(25);
                     this.commissionLigneVentes.setComligIdligne(this.factureLigneVentes.getFacligId());
                     this.commissionLigneVentes.setComligNum(this.factureLigneVentes.getCom_num());
                     this.commissionLigneVentes.setComligDate(this.factureLigneVentes.getCom_date());
                     this.commissionLigneVentes.setComligDateLastReg(this.factureLigneVentes.getCom_lastDatereg());
                     this.commissionLigneVentes.setComligNbJour(this.factureLigneVentes.getCom_nbJour());
                     this.commissionLigneVentes.setComligSerie(this.factureLigneVentes.getCom_serie());
                     this.commissionLigneVentes.setComligCat(this.factureLigneVentes.getCom_cat());
                     this.commissionLigneVentes.setComligNomTiers(this.factureLigneVentes.getCom_nomTiers());
                     this.commissionLigneVentes.setComligIdTiers(this.factureLigneVentes.getCom_idTiers());
                     this.commissionLigneVentes.setComligCivilTiers(this.factureLigneVentes.getCom_civilite());
                     this.commissionLigneVentes.setComligNomContact(this.factureLigneVentes.getCom_nomContact());
                     this.commissionLigneVentes.setComligIdContact(this.factureLigneVentes.getCom_idContact());
                     this.commissionLigneVentes.setComligCivilContact(this.factureLigneVentes.getCom_civiliteContact());
                     this.commissionLigneVentes.setComligNomResponsable(this.factureLigneVentes.getCom_nomResponsable());
                     this.commissionLigneVentes.setComligIdResponsable(this.factureLigneVentes.getCom_idResponsable());
                     this.commissionLigneVentes.setComligNomCommercial(this.factureLigneVentes.getCom_nomCommercial());
                     this.commissionLigneVentes.setComligIdCommercial(this.factureLigneVentes.getCom_idCommercial());
                     this.commissionLigneVentes.setComligNomEquipe(this.factureLigneVentes.getCom_nomEquipe());
                     this.commissionLigneVentes.setComligIdEquipe(this.factureLigneVentes.getCom_idEquipe());
                     this.commissionLigneVentes.setComligCode(this.factureLigneVentes.getFacligCode());
                     this.commissionLigneVentes.setComligLibelle(this.factureLigneVentes.getFacligLibelle());
                     this.commissionLigneVentes.setComligQte(this.factureLigneVentes.getFacligQte());
                     this.commissionLigneVentes.setComligTotHt(this.factureLigneVentes.getFacligPt());
                     this.commissionLigneVentes.setComligComUnite(this.factureLigneVentes.getVar_comUnite());
                     this.commissionLigneVentes.setComligComPourcentage(this.factureLigneVentes.getVar_comPourcentage());
                     this.commissionLigneVentes.setComligTotCommission(this.factureLigneVentes.getVar_totCommission());
                     this.commissionLigneVentes.setCommissionEnteteVentes(this.commissionEnteteVentes);
                     this.commissionLigneVentes = this.commissionLigneVentesDao.insertLigne(this.commissionLigneVentes, var2);
                     var6 += this.commissionLigneVentes.getComligTotCommission();
                     this.factureLigneVentes.setFacligCommission(this.commissionLigneVentes.getComligTotCommission());
                     this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var2);
                  }
               }

               this.commissionEnteteVentes.setComTotCommission(var6);
               this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes, var2);
            }

            if (this.listDetailAvoir.size() != 0) {
               for(var8 = 0; var8 < this.listDetailAvoir.size(); ++var8) {
                  this.avoirLigneVentes = new AvoirLigneVentes();
                  this.avoirLigneVentes = (AvoirLigneVentes)this.listDetailAvoir.get(var8);
                  if (this.avoirLigneVentes.getAvoirEnteteVentes().getAvrIdCommercial() == var3.getUsrid()) {
                     this.commissionLigneVentes = new CommissionLigneVentes();
                     this.commissionLigneVentes.setComligNature(26);
                     this.commissionLigneVentes.setComligIdligne(this.avoirLigneVentes.getAvrligId());
                     this.commissionLigneVentes.setComligNum(this.avoirLigneVentes.getCom_num());
                     this.commissionLigneVentes.setComligDate(this.avoirLigneVentes.getCom_date());
                     this.commissionLigneVentes.setComligDateLastReg(this.avoirLigneVentes.getCom_lastDatereg());
                     this.commissionLigneVentes.setComligNbJour(this.avoirLigneVentes.getCom_nbJour());
                     this.commissionLigneVentes.setComligSerie(this.avoirLigneVentes.getCom_serie());
                     this.commissionLigneVentes.setComligCat(this.avoirLigneVentes.getCom_cat());
                     this.commissionLigneVentes.setComligNomTiers(this.avoirLigneVentes.getCom_nomTiers());
                     this.commissionLigneVentes.setComligIdTiers(this.avoirLigneVentes.getCom_idTiers());
                     this.commissionLigneVentes.setComligCivilTiers(this.avoirLigneVentes.getCom_civilite());
                     this.commissionLigneVentes.setComligNomContact(this.avoirLigneVentes.getCom_nomContact());
                     this.commissionLigneVentes.setComligIdContact(this.avoirLigneVentes.getCom_idContact());
                     this.commissionLigneVentes.setComligCivilContact(this.avoirLigneVentes.getCom_civiliteContact());
                     this.commissionLigneVentes.setComligNomResponsable(this.avoirLigneVentes.getCom_nomResponsable());
                     this.commissionLigneVentes.setComligIdResponsable(this.avoirLigneVentes.getCom_idResponsable());
                     this.commissionLigneVentes.setComligNomCommercial(this.avoirLigneVentes.getCom_nomCommercial());
                     this.commissionLigneVentes.setComligIdCommercial(this.avoirLigneVentes.getCom_idCommercial());
                     this.commissionLigneVentes.setComligNomEquipe(this.avoirLigneVentes.getCom_nomEquipe());
                     this.commissionLigneVentes.setComligIdEquipe(this.avoirLigneVentes.getCom_idEquipe());
                     this.commissionLigneVentes.setComligCode(this.avoirLigneVentes.getAvrligCode());
                     this.commissionLigneVentes.setComligLibelle(this.avoirLigneVentes.getAvrligLibelle());
                     this.commissionLigneVentes.setComligQte(this.avoirLigneVentes.getAvrligQte());
                     this.commissionLigneVentes.setComligTotHt(this.avoirLigneVentes.getAvrligPt());
                     this.commissionLigneVentes.setComligComUnite(this.avoirLigneVentes.getVar_comUnite());
                     this.commissionLigneVentes.setComligComPourcentage(this.avoirLigneVentes.getVar_comPourcentage());
                     this.commissionLigneVentes.setComligTotCommission(this.avoirLigneVentes.getVar_totCommission());
                     this.commissionLigneVentes.setCommissionEnteteVentes(this.commissionEnteteVentes);
                     this.commissionLigneVentes = this.commissionLigneVentesDao.insertLigne(this.commissionLigneVentes, var2);
                     var6 += this.commissionLigneVentes.getComligTotCommission();
                     this.avoirLigneVentes.setAvrligCommission(this.commissionLigneVentes.getComligTotCommission());
                     this.avoirLigneVentes = this.avoirLigneVentesDao.modifLigne(this.avoirLigneVentes, var2);
                  }
               }

               this.commissionEnteteVentes.setComTotCommission(var6);
               this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes, var2);
            }

            if (this.listDetailNoteDebit.size() != 0) {
               for(var8 = 0; var8 < this.listDetailNoteDebit.size(); ++var8) {
                  this.noteDebitLigneVentes = new NoteDebitLigneVentes();
                  this.noteDebitLigneVentes = (NoteDebitLigneVentes)this.listDetailNoteDebit.get(var8);
                  if (this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbIdCommercial() == var3.getUsrid()) {
                     this.commissionLigneVentes = new CommissionLigneVentes();
                     this.commissionLigneVentes.setComligNature(27);
                     this.commissionLigneVentes.setComligIdligne(this.noteDebitLigneVentes.getNdbligId());
                     this.commissionLigneVentes.setComligNum(this.noteDebitLigneVentes.getCom_num());
                     this.commissionLigneVentes.setComligDate(this.noteDebitLigneVentes.getCom_date());
                     this.commissionLigneVentes.setComligDateLastReg(this.noteDebitLigneVentes.getCom_lastDatereg());
                     this.commissionLigneVentes.setComligNbJour(this.noteDebitLigneVentes.getCom_nbJour());
                     this.commissionLigneVentes.setComligSerie(this.noteDebitLigneVentes.getCom_serie());
                     this.commissionLigneVentes.setComligCat(this.noteDebitLigneVentes.getCom_cat());
                     this.commissionLigneVentes.setComligNomTiers(this.noteDebitLigneVentes.getCom_nomTiers());
                     this.commissionLigneVentes.setComligIdTiers(this.noteDebitLigneVentes.getCom_idTiers());
                     this.commissionLigneVentes.setComligCivilTiers(this.noteDebitLigneVentes.getCom_civilite());
                     this.commissionLigneVentes.setComligNomContact(this.noteDebitLigneVentes.getCom_nomContact());
                     this.commissionLigneVentes.setComligIdContact(this.noteDebitLigneVentes.getCom_idContact());
                     this.commissionLigneVentes.setComligCivilContact(this.noteDebitLigneVentes.getCom_civiliteContact());
                     this.commissionLigneVentes.setComligNomResponsable(this.noteDebitLigneVentes.getCom_nomResponsable());
                     this.commissionLigneVentes.setComligIdResponsable(this.noteDebitLigneVentes.getCom_idResponsable());
                     this.commissionLigneVentes.setComligNomCommercial(this.noteDebitLigneVentes.getCom_nomCommercial());
                     this.commissionLigneVentes.setComligIdCommercial(this.noteDebitLigneVentes.getCom_idCommercial());
                     this.commissionLigneVentes.setComligNomEquipe(this.noteDebitLigneVentes.getCom_nomEquipe());
                     this.commissionLigneVentes.setComligIdEquipe(this.noteDebitLigneVentes.getCom_idEquipe());
                     this.commissionLigneVentes.setComligCode(this.noteDebitLigneVentes.getNdbligCode());
                     this.commissionLigneVentes.setComligLibelle(this.noteDebitLigneVentes.getNdbligLibelle());
                     this.commissionLigneVentes.setComligQte(this.noteDebitLigneVentes.getNdbligQte());
                     this.commissionLigneVentes.setComligTotHt(this.noteDebitLigneVentes.getNdbligPt());
                     this.commissionLigneVentes.setComligComUnite(this.noteDebitLigneVentes.getVar_comUnite());
                     this.commissionLigneVentes.setComligComPourcentage(this.noteDebitLigneVentes.getVar_comPourcentage());
                     this.commissionLigneVentes.setComligTotCommission(this.noteDebitLigneVentes.getVar_totCommission());
                     this.commissionLigneVentes.setCommissionEnteteVentes(this.commissionEnteteVentes);
                     this.commissionLigneVentes = this.commissionLigneVentesDao.insertLigne(this.commissionLigneVentes, var2);
                     var6 += this.commissionLigneVentes.getComligTotCommission();
                     this.noteDebitLigneVentes.setNdbligCommission(this.commissionLigneVentes.getComligTotCommission());
                     this.noteDebitLigneVentes = this.noteDebitLigneVentesDao.modifLigne(this.noteDebitLigneVentes, var2);
                  }
               }

               this.commissionEnteteVentes.setComTotCommission(var6);
               this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes, var2);
            }

            if (this.listDetailReglement.size() != 0) {
               for(var8 = 0; var8 < this.listDetailReglement.size(); ++var8) {
                  this.reglements = new Reglements();
                  this.reglements = (Reglements)this.listDetailReglement.get(var8);
                  if (this.reglements.getRglIdCommercial() == var3.getUsrid() && var3.getUsrCommType() == 3 || var3.getUsrCommType() == 5) {
                     this.commissionLigneVentes = new CommissionLigneVentes();
                     this.commissionLigneVentes.setComligNature(61);
                     this.commissionLigneVentes.setComligIdligne(this.reglements.getRglId());
                     this.commissionLigneVentes.setComligNum(this.reglements.getCom_num());
                     this.commissionLigneVentes.setComligDate(this.reglements.getCom_date());
                     this.commissionLigneVentes.setComligDateLastReg(this.reglements.getCom_lastDatereg());
                     this.commissionLigneVentes.setComligNbJour(this.reglements.getCom_nbJour());
                     this.commissionLigneVentes.setComligSerie(this.reglements.getCom_serie());
                     this.commissionLigneVentes.setComligCat(this.reglements.getCom_cat());
                     this.commissionLigneVentes.setComligNomTiers(this.reglements.getCom_nomTiers());
                     this.commissionLigneVentes.setComligIdTiers(this.reglements.getCom_idTiers());
                     this.commissionLigneVentes.setComligCivilTiers(this.reglements.getCom_civilite());
                     this.commissionLigneVentes.setComligNomContact(this.reglements.getCom_nomContact());
                     this.commissionLigneVentes.setComligIdContact(this.reglements.getCom_idContact());
                     this.commissionLigneVentes.setComligCivilContact(this.reglements.getCom_civiliteContact());
                     this.commissionLigneVentes.setComligNomResponsable(this.reglements.getCom_nomResponsable());
                     this.commissionLigneVentes.setComligIdResponsable(this.reglements.getCom_idResponsable());
                     this.commissionLigneVentes.setComligNomCommercial(this.reglements.getCom_nomCommercial());
                     this.commissionLigneVentes.setComligIdCommercial(this.reglements.getCom_idCommercial());
                     this.commissionLigneVentes.setComligNomEquipe(this.reglements.getCom_nomEquipe());
                     this.commissionLigneVentes.setComligIdEquipe(this.reglements.getCom_idEquipe());
                     this.commissionLigneVentes.setComligCode(this.reglements.getRglNum());
                     this.commissionLigneVentes.setComligLibelle(this.reglements.getRglLibelle());
                     this.commissionLigneVentes.setComligQte(0.0F);
                     this.commissionLigneVentes.setComligTotHt(this.reglements.getRglRecette());
                     this.commissionLigneVentes.setComligComUnite(this.reglements.getVar_comUnite());
                     this.commissionLigneVentes.setComligComPourcentage(var3.getUsrCommPourcentage());
                     double var9 = this.utilNombre.myRoundDevise(this.reglements.getVal_recette() * (double)var3.getUsrCommPourcentage() / 100.0D, this.structureLog.getStrdevise());
                     this.commissionLigneVentes.setComligTotCommission(var9);
                     this.commissionLigneVentes.setCommissionEnteteVentes(this.commissionEnteteVentes);
                     this.commissionLigneVentes = this.commissionLigneVentesDao.insertLigne(this.commissionLigneVentes, var2);
                     var6 += this.commissionLigneVentes.getComligTotCommission();
                     this.reglements.setRglCommission(this.reglements.getRglCommission() + this.commissionLigneVentes.getComligTotCommission());
                     this.reglements = this.reglementsDao.modifierReg(this.reglements, var2);
                  }
               }

               this.commissionEnteteVentes.setComTotCommission(var6);
               this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes, var2);
            }
         }
      }

   }

   public void miseAJourResponsables(List var1, Session var2) throws HibernateException, NamingException {
      new Users();
      if (var1.size() != 0) {
         for(int var4 = 0; var4 < var1.size(); ++var4) {
            new Users();
            Users var3 = (Users)var1.get(var4);
            String var5 = this.calculChrono.numCompose(this.inpDu, this.nature, "", var2);
            this.commissionEnteteVentes = new CommissionEnteteVentes();
            this.commissionEnteteVentes.setComIdCommercial(0L);
            this.commissionEnteteVentes.setComNomCommercial("");
            this.commissionEnteteVentes.setComIdResponsable(var3.getUsrid());
            this.commissionEnteteVentes.setComNomResponsable(var3.getUsrPatronyme());
            this.commissionEnteteVentes.setComIdEquipe(0L);
            this.commissionEnteteVentes.setComNomEquipe("");
            this.commissionEnteteVentes.setComActivite("");
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
            this.commissionEnteteVentes.setComNum(var5);
            this.commissionEnteteVentes.setComService("");
            this.commissionEnteteVentes.setComSite("");
            this.commissionEnteteVentes.setComSolde(0);
            this.commissionEnteteVentes.setComTotCommission(0.0D);
            this.commissionEnteteVentes.setComTotReglement(0.0D);
            this.commissionEnteteVentes.setComTypeReg(0);
            this.commissionEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.verifieExistenceHabilitation(var2);
            this.commissionEnteteVentes = this.commissionEnteteVentesDao.insert(this.commissionEnteteVentes, var2);
            double var6 = 0.0D;
            int var8;
            if (this.listDetailFacture.size() != 0) {
               for(var8 = 0; var8 < this.listDetailFacture.size(); ++var8) {
                  this.factureLigneVentes = new FactureLigneVentes();
                  this.factureLigneVentes = (FactureLigneVentes)this.listDetailFacture.get(var8);
                  if (this.factureLigneVentes.getFactureEnteteVentes().getFacIdResponsable() == var3.getUsrid()) {
                     this.commissionLigneVentes = new CommissionLigneVentes();
                     this.commissionLigneVentes.setComligNature(25);
                     this.commissionLigneVentes.setComligIdligne(this.factureLigneVentes.getFacligId());
                     this.commissionLigneVentes.setComligNum(this.factureLigneVentes.getCom_num());
                     this.commissionLigneVentes.setComligDate(this.factureLigneVentes.getCom_date());
                     this.commissionLigneVentes.setComligDateLastReg(this.factureLigneVentes.getCom_lastDatereg());
                     this.commissionLigneVentes.setComligNbJour(this.factureLigneVentes.getCom_nbJour());
                     this.commissionLigneVentes.setComligSerie(this.factureLigneVentes.getCom_serie());
                     this.commissionLigneVentes.setComligCat(this.factureLigneVentes.getCom_cat());
                     this.commissionLigneVentes.setComligNomTiers(this.factureLigneVentes.getCom_nomTiers());
                     this.commissionLigneVentes.setComligIdTiers(this.factureLigneVentes.getCom_idTiers());
                     this.commissionLigneVentes.setComligCivilTiers(this.factureLigneVentes.getCom_civilite());
                     this.commissionLigneVentes.setComligNomContact(this.factureLigneVentes.getCom_nomContact());
                     this.commissionLigneVentes.setComligIdContact(this.factureLigneVentes.getCom_idContact());
                     this.commissionLigneVentes.setComligCivilContact(this.factureLigneVentes.getCom_civiliteContact());
                     this.commissionLigneVentes.setComligNomResponsable(this.factureLigneVentes.getCom_nomResponsable());
                     this.commissionLigneVentes.setComligIdResponsable(this.factureLigneVentes.getCom_idResponsable());
                     this.commissionLigneVentes.setComligNomCommercial(this.factureLigneVentes.getCom_nomCommercial());
                     this.commissionLigneVentes.setComligIdCommercial(this.factureLigneVentes.getCom_idCommercial());
                     this.commissionLigneVentes.setComligNomEquipe(this.factureLigneVentes.getCom_nomEquipe());
                     this.commissionLigneVentes.setComligIdEquipe(this.factureLigneVentes.getCom_idEquipe());
                     this.commissionLigneVentes.setComligCode(this.factureLigneVentes.getFacligCode());
                     this.commissionLigneVentes.setComligLibelle(this.factureLigneVentes.getFacligLibelle());
                     this.commissionLigneVentes.setComligQte(this.factureLigneVentes.getFacligQte());
                     this.commissionLigneVentes.setComligTotHt(this.factureLigneVentes.getFacligPt());
                     this.commissionLigneVentes.setComligComUnite(this.factureLigneVentes.getVar_comUnite());
                     this.commissionLigneVentes.setComligComPourcentage(this.factureLigneVentes.getVar_comPourcentage());
                     this.commissionLigneVentes.setComligTotCommission(this.factureLigneVentes.getVar_totCommission());
                     this.commissionLigneVentes.setCommissionEnteteVentes(this.commissionEnteteVentes);
                     this.commissionLigneVentes = this.commissionLigneVentesDao.insertLigne(this.commissionLigneVentes, var2);
                     var6 += this.commissionLigneVentes.getComligTotCommission();
                     this.factureLigneVentes.setFacligCommission(this.commissionLigneVentes.getComligTotCommission());
                     this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var2);
                  }
               }

               this.commissionEnteteVentes.setComTotCommission(var6);
               this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes, var2);
            }

            if (this.listDetailAvoir.size() != 0) {
               for(var8 = 0; var8 < this.listDetailAvoir.size(); ++var8) {
                  this.avoirLigneVentes = new AvoirLigneVentes();
                  this.avoirLigneVentes = (AvoirLigneVentes)this.listDetailAvoir.get(var8);
                  if (this.avoirLigneVentes.getAvoirEnteteVentes().getAvrIdResponsable() == var3.getUsrid()) {
                     this.commissionLigneVentes = new CommissionLigneVentes();
                     this.commissionLigneVentes.setComligNature(26);
                     this.commissionLigneVentes.setComligIdligne(this.avoirLigneVentes.getAvrligId());
                     this.commissionLigneVentes.setComligNum(this.avoirLigneVentes.getCom_num());
                     this.commissionLigneVentes.setComligDate(this.avoirLigneVentes.getCom_date());
                     this.commissionLigneVentes.setComligDateLastReg(this.avoirLigneVentes.getCom_lastDatereg());
                     this.commissionLigneVentes.setComligNbJour(this.avoirLigneVentes.getCom_nbJour());
                     this.commissionLigneVentes.setComligSerie(this.avoirLigneVentes.getCom_serie());
                     this.commissionLigneVentes.setComligCat(this.avoirLigneVentes.getCom_cat());
                     this.commissionLigneVentes.setComligNomTiers(this.avoirLigneVentes.getCom_nomTiers());
                     this.commissionLigneVentes.setComligIdTiers(this.avoirLigneVentes.getCom_idTiers());
                     this.commissionLigneVentes.setComligCivilTiers(this.avoirLigneVentes.getCom_civilite());
                     this.commissionLigneVentes.setComligNomContact(this.avoirLigneVentes.getCom_nomContact());
                     this.commissionLigneVentes.setComligIdContact(this.avoirLigneVentes.getCom_idContact());
                     this.commissionLigneVentes.setComligCivilContact(this.avoirLigneVentes.getCom_civiliteContact());
                     this.commissionLigneVentes.setComligNomResponsable(this.avoirLigneVentes.getCom_nomResponsable());
                     this.commissionLigneVentes.setComligIdResponsable(this.avoirLigneVentes.getCom_idResponsable());
                     this.commissionLigneVentes.setComligNomCommercial(this.avoirLigneVentes.getCom_nomCommercial());
                     this.commissionLigneVentes.setComligIdCommercial(this.avoirLigneVentes.getCom_idCommercial());
                     this.commissionLigneVentes.setComligNomEquipe(this.avoirLigneVentes.getCom_nomEquipe());
                     this.commissionLigneVentes.setComligIdEquipe(this.avoirLigneVentes.getCom_idEquipe());
                     this.commissionLigneVentes.setComligCode(this.avoirLigneVentes.getAvrligCode());
                     this.commissionLigneVentes.setComligLibelle(this.avoirLigneVentes.getAvrligLibelle());
                     this.commissionLigneVentes.setComligQte(this.avoirLigneVentes.getAvrligQte());
                     this.commissionLigneVentes.setComligTotHt(this.avoirLigneVentes.getAvrligPt());
                     this.commissionLigneVentes.setComligComUnite(this.avoirLigneVentes.getVar_comUnite());
                     this.commissionLigneVentes.setComligComPourcentage(this.avoirLigneVentes.getVar_comPourcentage());
                     this.commissionLigneVentes.setComligTotCommission(this.avoirLigneVentes.getVar_totCommission());
                     this.commissionLigneVentes.setCommissionEnteteVentes(this.commissionEnteteVentes);
                     this.commissionLigneVentes = this.commissionLigneVentesDao.insertLigne(this.commissionLigneVentes, var2);
                     var6 += this.commissionLigneVentes.getComligTotCommission();
                     this.avoirLigneVentes.setAvrligCommission(this.commissionLigneVentes.getComligTotCommission());
                     this.avoirLigneVentes = this.avoirLigneVentesDao.modifLigne(this.avoirLigneVentes, var2);
                  }
               }

               this.commissionEnteteVentes.setComTotCommission(var6);
               this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes, var2);
            }

            if (this.listDetailNoteDebit.size() != 0) {
               for(var8 = 0; var8 < this.listDetailNoteDebit.size(); ++var8) {
                  this.noteDebitLigneVentes = new NoteDebitLigneVentes();
                  this.noteDebitLigneVentes = (NoteDebitLigneVentes)this.listDetailNoteDebit.get(var8);
                  if (this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbIdResponsable() == var3.getUsrid()) {
                     this.commissionLigneVentes = new CommissionLigneVentes();
                     this.commissionLigneVentes.setComligNature(27);
                     this.commissionLigneVentes.setComligIdligne(this.noteDebitLigneVentes.getNdbligId());
                     this.commissionLigneVentes.setComligNum(this.noteDebitLigneVentes.getCom_num());
                     this.commissionLigneVentes.setComligDate(this.noteDebitLigneVentes.getCom_date());
                     this.commissionLigneVentes.setComligDateLastReg(this.noteDebitLigneVentes.getCom_lastDatereg());
                     this.commissionLigneVentes.setComligNbJour(this.noteDebitLigneVentes.getCom_nbJour());
                     this.commissionLigneVentes.setComligSerie(this.noteDebitLigneVentes.getCom_serie());
                     this.commissionLigneVentes.setComligCat(this.noteDebitLigneVentes.getCom_cat());
                     this.commissionLigneVentes.setComligNomTiers(this.noteDebitLigneVentes.getCom_nomTiers());
                     this.commissionLigneVentes.setComligIdTiers(this.noteDebitLigneVentes.getCom_idTiers());
                     this.commissionLigneVentes.setComligCivilTiers(this.noteDebitLigneVentes.getCom_civilite());
                     this.commissionLigneVentes.setComligNomContact(this.noteDebitLigneVentes.getCom_nomContact());
                     this.commissionLigneVentes.setComligIdContact(this.noteDebitLigneVentes.getCom_idContact());
                     this.commissionLigneVentes.setComligCivilContact(this.noteDebitLigneVentes.getCom_civiliteContact());
                     this.commissionLigneVentes.setComligNomResponsable(this.noteDebitLigneVentes.getCom_nomResponsable());
                     this.commissionLigneVentes.setComligIdResponsable(this.noteDebitLigneVentes.getCom_idResponsable());
                     this.commissionLigneVentes.setComligNomCommercial(this.noteDebitLigneVentes.getCom_nomCommercial());
                     this.commissionLigneVentes.setComligIdCommercial(this.noteDebitLigneVentes.getCom_idCommercial());
                     this.commissionLigneVentes.setComligNomEquipe(this.noteDebitLigneVentes.getCom_nomEquipe());
                     this.commissionLigneVentes.setComligIdEquipe(this.noteDebitLigneVentes.getCom_idEquipe());
                     this.commissionLigneVentes.setComligCode(this.noteDebitLigneVentes.getNdbligCode());
                     this.commissionLigneVentes.setComligLibelle(this.noteDebitLigneVentes.getNdbligLibelle());
                     this.commissionLigneVentes.setComligQte(this.noteDebitLigneVentes.getNdbligQte());
                     this.commissionLigneVentes.setComligTotHt(this.noteDebitLigneVentes.getNdbligPt());
                     this.commissionLigneVentes.setComligComUnite(this.noteDebitLigneVentes.getVar_comUnite());
                     this.commissionLigneVentes.setComligComPourcentage(this.noteDebitLigneVentes.getVar_comPourcentage());
                     this.commissionLigneVentes.setComligTotCommission(this.noteDebitLigneVentes.getVar_totCommission());
                     this.commissionLigneVentes.setCommissionEnteteVentes(this.commissionEnteteVentes);
                     this.commissionLigneVentes = this.commissionLigneVentesDao.insertLigne(this.commissionLigneVentes, var2);
                     var6 += this.commissionLigneVentes.getComligTotCommission();
                     this.noteDebitLigneVentes.setNdbligCommission(this.commissionLigneVentes.getComligTotCommission());
                     this.noteDebitLigneVentes = this.noteDebitLigneVentesDao.modifLigne(this.noteDebitLigneVentes, var2);
                  }
               }

               this.commissionEnteteVentes.setComTotCommission(var6);
               this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes, var2);
            }

            if (this.listDetailReglement.size() != 0) {
               for(var8 = 0; var8 < this.listDetailReglement.size(); ++var8) {
                  this.reglements = new Reglements();
                  this.reglements = (Reglements)this.listDetailReglement.get(var8);
                  if (this.reglements.getRglIdResponsable() == var3.getUsrid() && var3.getUsrCommType() == 3 || var3.getUsrCommType() == 5) {
                     this.commissionLigneVentes = new CommissionLigneVentes();
                     this.commissionLigneVentes.setComligNature(61);
                     this.commissionLigneVentes.setComligIdligne(this.reglements.getRglId());
                     this.commissionLigneVentes.setComligNum(this.reglements.getCom_num());
                     this.commissionLigneVentes.setComligDate(this.reglements.getCom_date());
                     this.commissionLigneVentes.setComligDateLastReg(this.reglements.getCom_lastDatereg());
                     this.commissionLigneVentes.setComligNbJour(this.reglements.getCom_nbJour());
                     this.commissionLigneVentes.setComligSerie(this.reglements.getCom_serie());
                     this.commissionLigneVentes.setComligCat(this.reglements.getCom_cat());
                     this.commissionLigneVentes.setComligNomTiers(this.reglements.getCom_nomTiers());
                     this.commissionLigneVentes.setComligIdTiers(this.reglements.getCom_idTiers());
                     this.commissionLigneVentes.setComligCivilTiers(this.reglements.getCom_civilite());
                     this.commissionLigneVentes.setComligNomContact(this.reglements.getCom_nomContact());
                     this.commissionLigneVentes.setComligIdContact(this.reglements.getCom_idContact());
                     this.commissionLigneVentes.setComligCivilContact(this.reglements.getCom_civiliteContact());
                     this.commissionLigneVentes.setComligNomResponsable(this.reglements.getCom_nomResponsable());
                     this.commissionLigneVentes.setComligIdResponsable(this.reglements.getCom_idResponsable());
                     this.commissionLigneVentes.setComligNomCommercial(this.reglements.getCom_nomCommercial());
                     this.commissionLigneVentes.setComligIdCommercial(this.reglements.getCom_idCommercial());
                     this.commissionLigneVentes.setComligNomEquipe(this.reglements.getCom_nomEquipe());
                     this.commissionLigneVentes.setComligIdEquipe(this.reglements.getCom_idEquipe());
                     this.commissionLigneVentes.setComligCode(this.reglements.getRglNum());
                     this.commissionLigneVentes.setComligLibelle(this.reglements.getRglLibelle());
                     this.commissionLigneVentes.setComligQte(0.0F);
                     this.commissionLigneVentes.setComligTotHt(this.reglements.getRglRecette());
                     this.commissionLigneVentes.setComligComUnite(this.reglements.getVar_comUnite());
                     this.commissionLigneVentes.setComligComPourcentage(var3.getUsrCommPourcentage());
                     double var9 = this.utilNombre.myRoundDevise(this.reglements.getVal_recette() * (double)var3.getUsrCommPourcentage() / 100.0D, this.structureLog.getStrdevise());
                     this.commissionLigneVentes.setComligTotCommission(var9);
                     this.commissionLigneVentes.setCommissionEnteteVentes(this.commissionEnteteVentes);
                     this.commissionLigneVentes = this.commissionLigneVentesDao.insertLigne(this.commissionLigneVentes, var2);
                     var6 += this.commissionLigneVentes.getComligTotCommission();
                     this.reglements.setRglCommission(this.reglements.getRglCommission() + this.commissionLigneVentes.getComligTotCommission());
                     this.reglements = this.reglementsDao.modifierReg(this.reglements, var2);
                  }
               }

               this.commissionEnteteVentes.setComTotCommission(var6);
               this.commissionEnteteVentes = this.commissionEnteteVentesDao.modif(this.commissionEnteteVentes, var2);
            }
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
         ArrayList var1 = new ArrayList();
         CommissionEnteteVentes var3;
         if (this.listCommission.size() != 0) {
            for(int var2 = 0; var2 < this.listCommission.size(); ++var2) {
               new CommissionEnteteVentes();
               var3 = (CommissionEnteteVentes)this.listCommission.get(var2);
               if (var3.isVar_select_ligne() && var3.getComEtat() == 0) {
                  var1.add(var3);
               }
            }
         }

         if (var1.size() != 0) {
            Session var15 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommissionEntete");
            var3 = null;

            try {
               Transaction var16 = var15.beginTransaction();

               for(int var4 = 0; var4 < var1.size(); ++var4) {
                  this.commissionEnteteVentes = new CommissionEnteteVentes();
                  this.commissionEnteteVentes = (CommissionEnteteVentes)var1.get(var4);
                  long var5 = this.commissionEnteteVentes.getComId();
                  this.commissionEnteteVentes = this.commissionEnteteVentesDao.pourParapheur(var5, var15);
                  new ArrayList();
                  List var7 = this.bonEncaissementVenteDao.rechercheBeByDoc(var5, this.nature, var15);
                  int var8;
                  if (var7.size() != 0) {
                     for(var8 = 0; var8 < var7.size(); ++var8) {
                        new BonEncaissementVente();
                        BonEncaissementVente var9 = (BonEncaissementVente)var7.get(var8);
                        this.bonEncaissementVenteDao.delete(var9, var15);
                     }
                  }

                  if (this.commissionEnteteVentes.getComEtat() == 0) {
                     this.listDetailCommission.clear();
                     this.listDetailCommission = this.commissionLigneVentesDao.chargerLesLignes(this.commissionEnteteVentes, var15);
                     if (this.listDetailCommission.size() != 0) {
                        for(var8 = 0; var8 < this.listDetailCommission.size(); ++var8) {
                           this.commissionLigneVentes = new CommissionLigneVentes();
                           this.commissionLigneVentes = (CommissionLigneVentes)this.listDetailCommission.get(var8);
                           if (this.commissionLigneVentes.getComligIdligne() != 0L) {
                              if (this.commissionLigneVentes.getComligNature() == 25) {
                                 this.factureLigneVentes = this.factureLigneVentesDao.chargerLaLigne(this.commissionLigneVentes.getComligIdligne(), var15);
                                 if (this.factureLigneVentes != null) {
                                    this.factureLigneVentes.setFacligCommission(0.0D);
                                    this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var15);
                                 }
                              } else if (this.commissionLigneVentes.getComligNature() == 26) {
                                 this.avoirLigneVentes = this.avoirLigneVentesDao.chargerLaLigne(this.commissionLigneVentes.getComligIdligne(), var15);
                                 if (this.avoirLigneVentes != null) {
                                    this.avoirLigneVentes.setAvrligCommission(0.0D);
                                    this.avoirLigneVentes = this.avoirLigneVentesDao.modifLigne(this.avoirLigneVentes, var15);
                                 }
                              } else if (this.commissionLigneVentes.getComligNature() == 27) {
                                 this.noteDebitLigneVentes = this.noteDebitLigneVentesDao.chargerLaLigne(this.commissionLigneVentes.getComligIdligne(), var15);
                                 if (this.noteDebitLigneVentes != null) {
                                    this.noteDebitLigneVentes.setNdbligCommission(0.0D);
                                    this.noteDebitLigneVentes = this.noteDebitLigneVentesDao.modifLigne(this.noteDebitLigneVentes, var15);
                                 }
                              } else if (this.commissionLigneVentes.getComligNature() == 61) {
                                 this.reglements = this.reglementsDao.pourParapheur(this.commissionLigneVentes.getComligIdligne(), var15);
                                 if (this.reglements != null) {
                                    this.reglements.setRglCommission(0.0D);
                                    this.reglements = this.reglementsDao.modifierReg(this.reglements, var15);
                                 }
                              }
                           }

                           this.commissionLigneVentesDao.deleteOneLigne(this.commissionLigneVentes, var15);
                        }
                     }

                     this.commissionEnteteVentesDao.delete(this.commissionEnteteVentes, var15);
                  }
               }

               var16.commit();
            } catch (HibernateException var13) {
               if (var3 != null) {
                  var3.rollback();
               }

               throw var13;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.executerRequete((Session)null);
            this.visibiliteBton = false;
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelectionEntete.clear();
         }
      }

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

   public void rechercheCommercial() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.rechercheCommercial(this.inpCommercial, this.nature);
      if (this.responsable != null) {
         if (this.responsable.getUsrid() != 0L) {
            this.calculeCommercial();
         } else {
            this.var_action = 17;
         }
      } else if (this.responsable == null) {
         this.calculeCommercial();
      }

   }

   public void recuperationCommercial() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.calculeCommercial();
      this.calculeCommercial();
   }

   public void calculeCommercial() throws JDOMException, IOException {
      if (this.responsable != null) {
         this.inpCommercial = this.responsable.getUsrPatronyme();
         this.inpIdCommercial = this.responsable.getUsrid();
      } else {
         this.inpCommercial = "";
         this.inpIdCommercial = 0L;
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleCommercial() {
      this.inpCommercial = "";
      this.inpIdCommercial = 0L;
      this.var_action = this.var_memo_action;
   }

   public void executerRequeteAnalyse() throws HibernateException, NamingException {
      this.lesAnalyses.clear();
      if (this.inpAu != null && this.inpDu != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         String var2 = "";
         String var3 = this.utilDate.dateToStringSQLLight(this.inpDu) + " 00:00:00";
         String var4 = this.utilDate.dateToStringSQLLight(this.inpAu) + " 23:59:59";
         new ArrayList();
         Object var6 = new ArrayList();
         Object var7 = new ArrayList();
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
         Object var18 = new ArrayList();
         Object var19 = new ArrayList();
         Object var20 = new ArrayList();
         String var21 = "";
         String var22;
         int var23;
         if (this.inpIdConseillers != 0L) {
            var22 = "from Responsable where (tiers.tietype=1 or tiers.tietype=2 or tiers.tietype=3) and rpbuserid=" + this.inpIdConseillers;
            List var5 = this.responsableDao.listeConseillers(var22, var1);
            if (var5.size() != 0) {
               for(var23 = 0; var23 < var5.size(); ++var23) {
                  if (var21 != null && !var21.isEmpty()) {
                     var21 = var21 + "," + ((Responsable)var5.get(var23)).getTiers().getTieid();
                  } else {
                     var21 = "" + ((Responsable)var5.get(var23)).getTiers().getTieid();
                  }
               }
            }
         } else if (this.inpType == 122 || this.inpType == 125) {
            var22 = "from Tiers where tietype=3";
            var6 = this.tiersDao.listeTiers(var22, var1);
            if (((List)var6).size() != 0) {
               for(var23 = 0; var23 < ((List)var6).size(); ++var23) {
                  if (var21 != null && !var21.isEmpty()) {
                     var21 = var21 + "," + ((Tiers)((List)var6).get(var23)).getTieid();
                  } else {
                     var21 = "" + ((Tiers)((List)var6).get(var23)).getTieid();
                  }
               }
            }
         }

         String[] var28;
         if (this.inpType == 21) {
            if (this.inpMode != 21 && this.inpMode != 22) {
               var2 = "dvsDate>='" + var3 + "' and dvsDate<='" + var4 + "'";
               if (this.inpIdConseillers != 0L) {
                  if (var21 != null && !var21.isEmpty()) {
                     var2 = var2 + " and tiers.tieid in (" + var21 + ")";
                  } else {
                     var2 = var2 + " and tiers.tieid=0";
                  }
               }

               if (this.inpIdResponsable != 0L) {
                  var2 = var2 + " and dvsIdResponsable=" + this.inpIdResponsable;
               }

               if (this.inpIdCommercial != 0L) {
                  var2 = var2 + " and dvsIdCommercial=" + this.inpIdCommercial;
               }

               if (this.inpIdEquipe != 0L) {
                  var2 = var2 + " and dvsIdEquipe=" + this.inpIdEquipe;
               }

               if (this.inpPdv != null && !this.inpPdv.isEmpty()) {
                  if (this.inpPdv.contains(":")) {
                     var28 = this.inpPdv.split(":");
                     var2 = var2 + " and dvsPdv='" + var28[0] + "'";
                  } else {
                     var2 = var2 + " and dvsPdv='" + this.inpPdv + "'";
                  }
               }

               var7 = this.devisEnteteVentesDao.rechercheDevisRequete(var2, var1);
            } else {
               var2 = "devisEnteteVentes.dvsDate>='" + var3 + "' and devisEnteteVentes.dvsDate<='" + var4 + "'";
               if (this.inpIdConseillers != 0L) {
                  if (var21 != null && !var21.isEmpty()) {
                     var2 = var2 + " and devisEnteteVentes.tiers.tieid in (" + var21 + ")";
                  } else {
                     var2 = var2 + " and devisEnteteVentes.tiers.tieid=0";
                  }
               }

               if (this.inpIdResponsable != 0L) {
                  var2 = var2 + " and devisEnteteVentes.dvsIdResponsable=" + this.inpIdResponsable;
               }

               if (this.inpIdCommercial != 0L) {
                  var2 = var2 + " and devisEnteteVentes.dvsIdCommercial=" + this.inpIdCommercial;
               }

               if (this.inpIdEquipe != 0L) {
                  var2 = var2 + " and devisEnteteVentes.dvsIdEquipe=" + this.inpIdEquipe;
               }

               if (this.inpPdv != null && !this.inpPdv.isEmpty()) {
                  if (this.inpPdv.contains(":")) {
                     var28 = this.inpPdv.split(":");
                     var2 = var2 + " and devisEnteteVentes.dvsPdv='" + var28[0] + "'";
                  } else {
                     var2 = var2 + " and devisEnteteVentes.dvsPdv='" + this.inpPdv + "'";
                  }
               }

               var14 = this.devisLigneVentesDao.rechercheDevisRequete(var2, var1);
            }
         } else if (this.inpType == 22) {
            if (this.inpMode != 21 && this.inpMode != 22) {
               var2 = "bcmDate>='" + var3 + "' and bcmDate<='" + var4 + "'";
               if (this.inpIdConseillers != 0L) {
                  if (var21 != null && !var21.isEmpty()) {
                     var2 = var2 + " and tiers.tieid in (" + var21 + ")";
                  } else {
                     var2 = var2 + " and tiers.tieid=0";
                  }
               }

               if (this.inpIdResponsable != 0L) {
                  var2 = var2 + " and bcmIdResponsable=" + this.inpIdResponsable;
               }

               if (this.inpIdCommercial != 0L) {
                  var2 = var2 + " and bcmIdCommercial=" + this.inpIdCommercial;
               }

               if (this.inpIdEquipe != 0L) {
                  var2 = var2 + " and bcmIdEquipe=" + this.inpIdEquipe;
               }

               if (this.inpPdv != null && !this.inpPdv.isEmpty()) {
                  if (this.inpPdv.contains(":")) {
                     var28 = this.inpPdv.split(":");
                     var2 = var2 + " and bcmPdv='" + var28[0] + "'";
                  } else {
                     var2 = var2 + " and bcmPdv='" + this.inpPdv + "'";
                  }
               }

               var8 = this.commandeEnteteVentesDao.rechercheCommandeRequete(var2, var1);
            } else {
               var2 = "commandeEnteteVentes.bcmDate>='" + var3 + "' and commandeEnteteVentes.bcmDate<='" + var4 + "'";
               if (this.inpIdConseillers != 0L) {
                  if (var21 != null && !var21.isEmpty()) {
                     var2 = var2 + " and commandeEnteteVentes.tiers.tieid in (" + var21 + ")";
                  } else {
                     var2 = var2 + " and commandeEnteteVentes.tiers.tieid=0";
                  }
               }

               if (this.inpIdResponsable != 0L) {
                  var2 = var2 + " and commandeEnteteVentes.bcmIdResponsable=" + this.inpIdResponsable;
               }

               if (this.inpIdCommercial != 0L) {
                  var2 = var2 + " and commandeEnteteVentes.bcmIdCommercial=" + this.inpIdCommercial;
               }

               if (this.inpIdEquipe != 0L) {
                  var2 = var2 + " and commandeEnteteVentes.bcmIdEquipe=" + this.inpIdEquipe;
               }

               if (this.inpPdv != null && !this.inpPdv.isEmpty()) {
                  if (this.inpPdv.contains(":")) {
                     var28 = this.inpPdv.split(":");
                     var2 = var2 + " and commandeEnteteVentes.bcmPdv='" + var28[0] + "'";
                  } else {
                     var2 = var2 + " and commandeEnteteVentes.bcmPdv='" + this.inpPdv + "'";
                  }
               }

               var15 = this.commandeLigneVentesDao.rechercheCommandeRequete(var2, var1);
            }
         } else if (this.inpType == 23) {
            if (this.inpMode != 21 && this.inpMode != 22) {
               var2 = "blvDate>='" + var3 + "' and blvDate<='" + var4 + "'";
               if (this.inpIdConseillers != 0L) {
                  if (var21 != null && !var21.isEmpty()) {
                     var2 = var2 + " and tiers.tieid in (" + var21 + ")";
                  } else {
                     var2 = var2 + " and tiers.tieid=0";
                  }
               }

               if (this.inpIdResponsable != 0L) {
                  var2 = var2 + " and blvIdResponsable=" + this.inpIdResponsable;
               }

               if (this.inpIdCommercial != 0L) {
                  var2 = var2 + " and blvIdCommercial=" + this.inpIdCommercial;
               }

               if (this.inpIdEquipe != 0L) {
                  var2 = var2 + " and blvIdEquipe=" + this.inpIdEquipe;
               }

               if (this.inpPdv != null && !this.inpPdv.isEmpty()) {
                  if (this.inpPdv.contains(":")) {
                     var28 = this.inpPdv.split(":");
                     var2 = var2 + " and blvPdv='" + var28[0] + "'";
                  } else {
                     var2 = var2 + " and blvPdv='" + this.inpPdv + "'";
                  }
               }

               var9 = this.livraisonEnteteVentesDao.rechercheLivraisonRequete(var2, var1);
            } else {
               var2 = "livraisonEnteteVentes.blvDate>='" + var3 + "' and livraisonEnteteVentes.blvDate<='" + var4 + "'";
               if (this.inpIdConseillers != 0L) {
                  if (var21 != null && !var21.isEmpty()) {
                     var2 = var2 + " and livraisonEnteteVentes.tiers.tieid in (" + var21 + ")";
                  } else {
                     var2 = var2 + " and livraisonEnteteVentes.tiers.tieid=0";
                  }
               }

               if (this.inpIdResponsable != 0L) {
                  var2 = var2 + " and livraisonEnteteVentes.blvIdResponsable=" + this.inpIdResponsable;
               }

               if (this.inpIdCommercial != 0L) {
                  var2 = var2 + " and livraisonEnteteVentes.blvIdCommercial=" + this.inpIdCommercial;
               }

               if (this.inpIdEquipe != 0L) {
                  var2 = var2 + " and livraisonEnteteVentes.blvIdEquipe=" + this.inpIdEquipe;
               }

               if (this.inpPdv != null && !this.inpPdv.isEmpty()) {
                  if (this.inpPdv.contains(":")) {
                     var28 = this.inpPdv.split(":");
                     var2 = var2 + " and livraisonEnteteVentes.blvPdv='" + var28[0] + "'";
                  } else {
                     var2 = var2 + " and livraisonEnteteVentes.blvPdv='" + this.inpPdv + "'";
                  }
               }

               var16 = this.livraisonLigneVentesDao.rechercheLivraisonRequete(var2, var1);
            }

            if (this.inpMode != 21 && this.inpMode != 22) {
               var2 = "brtDate>='" + var3 + "' and brtDate<='" + var4 + "'";
               if (this.inpIdConseillers != 0L) {
                  if (var21 != null && !var21.isEmpty()) {
                     var2 = var2 + " and tiers.tieid in (" + var21 + ")";
                  } else {
                     var2 = var2 + " and tiers.tieid=0";
                  }
               }

               if (this.inpIdResponsable != 0L) {
                  var2 = var2 + " and brtIdResponsable=" + this.inpIdResponsable;
               }

               if (this.inpIdCommercial != 0L) {
                  var2 = var2 + " and brtIdCommercial=" + this.inpIdCommercial;
               }

               if (this.inpIdEquipe != 0L) {
                  var2 = var2 + " and brtIdEquipe=" + this.inpIdEquipe;
               }

               if (this.inpPdv != null && !this.inpPdv.isEmpty()) {
                  if (this.inpPdv.contains(":")) {
                     var28 = this.inpPdv.split(":");
                     var2 = var2 + " and brtPdv='" + var28[0] + "'";
                  } else {
                     var2 = var2 + " and brtPdv='" + this.inpPdv + "'";
                  }
               }

               var10 = this.retourEnteteVentesDao.rechercheRetourRequete(var2, var1);
            } else {
               var2 = "retourEnteteVentes.brtDate>='" + var3 + "' and retourEnteteVentes.brtDate<='" + var4 + "'";
               if (this.inpIdConseillers != 0L) {
                  if (var21 != null && !var21.isEmpty()) {
                     var2 = var2 + " and retourEnteteVentes.tiers.tieid in (" + var21 + ")";
                  } else {
                     var2 = var2 + " and retourEnteteVentes.tiers.tieid=0";
                  }
               }

               if (this.inpIdResponsable != 0L) {
                  var2 = var2 + " and retourEnteteVentes.brtIdResponsable=" + this.inpIdResponsable;
               }

               if (this.inpIdCommercial != 0L) {
                  var2 = var2 + " and retourEnteteVentes.brtIdCommercial=" + this.inpIdCommercial;
               }

               if (this.inpIdEquipe != 0L) {
                  var2 = var2 + " and retourEnteteVentes.brtIdEquipe=" + this.inpIdEquipe;
               }

               if (this.inpPdv != null && !this.inpPdv.isEmpty()) {
                  if (this.inpPdv.contains(":")) {
                     var28 = this.inpPdv.split(":");
                     var2 = var2 + " and retourEnteteVentes.brtPdv='" + var28[0] + "'";
                  } else {
                     var2 = var2 + " and retourEnteteVentes.brtPdv='" + this.inpPdv + "'";
                  }
               }

               var17 = this.retourLigneVentesDao.rechercheRetourRequete(var2, var1);
            }
         } else if (this.inpType == 25) {
            if (this.inpMode != 21 && this.inpMode != 22) {
               var2 = "facDate>='" + var3 + "' and facDate<='" + var4 + "'";
               if (this.inpIdConseillers != 0L) {
                  if (var21 != null && !var21.isEmpty()) {
                     var2 = var2 + " and tiers.tieid in (" + var21 + ")";
                  } else {
                     var2 = var2 + " and tiers.tieid=0";
                  }
               }

               if (this.inpIdResponsable != 0L) {
                  var2 = var2 + " and facIdResponsable=" + this.inpIdResponsable;
               }

               if (this.inpIdCommercial != 0L) {
                  var2 = var2 + " and facIdCommercial=" + this.inpIdCommercial;
               }

               if (this.inpIdEquipe != 0L) {
                  var2 = var2 + " and facIdEquipe=" + this.inpIdEquipe;
               }

               if (this.inpPdv != null && !this.inpPdv.isEmpty()) {
                  if (this.inpPdv.contains(":")) {
                     var28 = this.inpPdv.split(":");
                     var2 = var2 + " and facPdv='" + var28[0] + "'";
                  } else {
                     var2 = var2 + " and facPdv='" + this.inpPdv + "'";
                  }
               }

               var11 = this.factureEnteteVentesDao.rechercheFactureRequete(var2, var1);
            } else {
               var2 = "factureEnteteVentes.facDate>='" + var3 + "' and factureEnteteVentes.facDate<='" + var4 + "'";
               if (this.inpIdConseillers != 0L) {
                  if (var21 != null && !var21.isEmpty()) {
                     var2 = var2 + " and factureEnteteVentes.tiers.tieid in (" + var21 + ")";
                  } else {
                     var2 = var2 + " and factureEnteteVentes.tiers.tieid=0";
                  }
               }

               if (this.inpIdResponsable != 0L) {
                  var2 = var2 + " and factureEnteteVentes.facIdResponsable=" + this.inpIdResponsable;
               }

               if (this.inpIdCommercial != 0L) {
                  var2 = var2 + " and factureEnteteVentes.facIdCommercial=" + this.inpIdCommercial;
               }

               if (this.inpIdEquipe != 0L) {
                  var2 = var2 + " and factureEnteteVentes.facIdEquipe=" + this.inpIdEquipe;
               }

               if (this.inpPdv != null && !this.inpPdv.isEmpty()) {
                  if (this.inpPdv.contains(":")) {
                     var28 = this.inpPdv.split(":");
                     var2 = var2 + " and factureEnteteVentes.facPdv='" + var28[0] + "'";
                  } else {
                     var2 = var2 + " and factureEnteteVentes.facPdv='" + this.inpPdv + "'";
                  }
               }

               var18 = this.factureLigneVentesDao.rechercheFactureRequete(var2, var1);
            }

            if (this.inpMode != 21 && this.inpMode != 22) {
               var2 = "ndbDate>='" + var3 + "' and ndbDate<='" + var4 + "'";
               if (this.inpIdConseillers != 0L) {
                  if (var21 != null && !var21.isEmpty()) {
                     var2 = var2 + " and tiers.tieid in (" + var21 + ")";
                  } else {
                     var2 = var2 + " and tiers.tieid=0";
                  }
               }

               if (this.inpIdResponsable != 0L) {
                  var2 = var2 + " and ndbIdResponsable=" + this.inpIdResponsable;
               }

               if (this.inpIdCommercial != 0L) {
                  var2 = var2 + " and ndbIdCommercial=" + this.inpIdCommercial;
               }

               if (this.inpIdEquipe != 0L) {
                  var2 = var2 + " and ndbIdEquipe=" + this.inpIdEquipe;
               }

               if (this.inpPdv != null && !this.inpPdv.isEmpty()) {
                  if (this.inpPdv.contains(":")) {
                     var28 = this.inpPdv.split(":");
                     var2 = var2 + " and ndbPdv='" + var28[0] + "'";
                  } else {
                     var2 = var2 + " and ndbPdv='" + this.inpPdv + "'";
                  }
               }

               var12 = this.noteDebitEnteteVentesDao.rechercheNoteDebitRequete(var2, var1);
            } else {
               var2 = "noteDebitEnteteVentes.ndbDate>='" + var3 + "' and noteDebitEnteteVentes.ndbDate<='" + var4 + "'";
               if (this.inpIdConseillers != 0L) {
                  if (var21 != null && !var21.isEmpty()) {
                     var2 = var2 + " and noteDebitEnteteVentes.tiers.tieid in (" + var21 + ")";
                  } else {
                     var2 = var2 + " and noteDebitEnteteVentes.tiers.tieid=0";
                  }
               }

               if (this.inpIdResponsable != 0L) {
                  var2 = var2 + " and noteDebitEnteteVentes.ndbIdResponsable=" + this.inpIdResponsable;
               }

               if (this.inpIdCommercial != 0L) {
                  var2 = var2 + " and noteDebitEnteteVentes.ndbIdCommercial=" + this.inpIdCommercial;
               }

               if (this.inpIdEquipe != 0L) {
                  var2 = var2 + " and noteDebitEnteteVentes.ndbIdEquipe=" + this.inpIdEquipe;
               }

               if (this.inpPdv != null && !this.inpPdv.isEmpty()) {
                  if (this.inpPdv.contains(":")) {
                     var28 = this.inpPdv.split(":");
                     var2 = var2 + " and noteDebitEnteteVentes.ndbPdv='" + var28[0] + "'";
                  } else {
                     var2 = var2 + " and noteDebitEnteteVentes.ndbPdv='" + this.inpPdv + "'";
                  }
               }

               var19 = this.noteDebitLigneVentesDao.rechercheNoteDebitRequete(var2, var1);
            }

            if (this.inpMode != 21 && this.inpMode != 22) {
               var2 = "avrDate>='" + var3 + "' and avrDate<='" + var4 + "'";
               if (this.inpIdConseillers != 0L) {
                  if (var21 != null && !var21.isEmpty()) {
                     var2 = var2 + " and tiers.tieid in (" + var21 + ")";
                  } else {
                     var2 = var2 + " and tiers.tieid=0";
                  }
               }

               if (this.inpIdResponsable != 0L) {
                  var2 = var2 + " and avrIdResponsable=" + this.inpIdResponsable;
               }

               if (this.inpIdCommercial != 0L) {
                  var2 = var2 + " and avrIdCommercial=" + this.inpIdCommercial;
               }

               if (this.inpIdEquipe != 0L) {
                  var2 = var2 + " and avrIdEquipe=" + this.inpIdEquipe;
               }

               if (this.inpPdv != null && !this.inpPdv.isEmpty()) {
                  if (this.inpPdv.contains(":")) {
                     var28 = this.inpPdv.split(":");
                     var2 = var2 + " and avrPdv='" + var28[0] + "'";
                  } else {
                     var2 = var2 + " and avrPdv='" + this.inpPdv + "'";
                  }
               }

               var13 = this.avoirEnteteVentesDao.rechercheAvoirRequete(var2, var1);
            } else {
               var2 = "avoirEnteteVentes.avrDate>='" + var3 + "' and avoirEnteteVentes.avrDate<='" + var4 + "'";
               if (this.inpIdConseillers != 0L) {
                  if (var21 != null && !var21.isEmpty()) {
                     var2 = var2 + " and avoirEnteteVentes.tiers.tieid in (" + var21 + ")";
                  } else {
                     var2 = var2 + " and avoirEnteteVentes.tiers.tieid=0";
                  }
               }

               if (this.inpIdResponsable != 0L) {
                  var2 = var2 + " and avoirEnteteVentes.avrIdResponsable=" + this.inpIdResponsable;
               }

               if (this.inpIdCommercial != 0L) {
                  var2 = var2 + " and avoirEnteteVentes.avrIdCommercial=" + this.inpIdCommercial;
               }

               if (this.inpIdEquipe != 0L) {
                  var2 = var2 + " and avoirEnteteVentes.avrIdEquipe=" + this.inpIdEquipe;
               }

               if (this.inpPdv != null && !this.inpPdv.isEmpty()) {
                  if (this.inpPdv.contains(":")) {
                     var28 = this.inpPdv.split(":");
                     var2 = var2 + " and avoirEnteteVentes.avrPdv='" + var28[0] + "'";
                  } else {
                     var2 = var2 + " and avoirEnteteVentes.avrPdv='" + this.inpPdv + "'";
                  }
               }

               var20 = this.avoirLigneVentesDao.rechercheAvoirRequete(var2, var1);
            }
         } else {
            boolean var25;
            int var26;
            int var27;
            long var29;
            if (this.inpType == 122) {
               var2 = "bcmDate>='" + var3 + "' and bcmDate<='" + var4 + "'";
               if (var21 != null && !var21.isEmpty()) {
                  var2 = var2 + " and tiers.tieid in (" + var21 + ")";
                  var8 = this.commandeEnteteVentesDao.rechercheCommandeRequete(var2, var1);
                  if (((List)var8).size() != 0 && ((List)var6).size() != 0) {
                     for(var27 = 0; var27 < ((List)var6).size(); ++var27) {
                        var29 = ((Tiers)((List)var6).get(var27)).getTieid();
                        var25 = false;

                        for(var26 = 0; var26 < ((List)var8).size(); ++var26) {
                           if (((CommandeEnteteVentes)((List)var8).get(var26)).getTiers().getTieid() == var29) {
                              var25 = true;
                              break;
                           }
                        }

                        if (!var25) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocNomTiers(((Tiers)((List)var6).get(var27)).getTieraisonsocialenom());
                           if (this.documentEntete.getDocNomTiers() != null && !this.documentEntete.getDocNomTiers().isEmpty()) {
                              if (((Tiers)((List)var6).get(var27)).getTieprenom() != null && !((Tiers)((List)var6).get(var27)).getTieprenom().isEmpty()) {
                                 this.documentEntete.setDocNomTiers(this.documentEntete.getDocNomTiers() + " " + ((Tiers)((List)var6).get(var27)).getTieprenom());
                              }

                              this.documentEntete.setDocActivite(((Tiers)((List)var6).get(var27)).getTiecategorie());
                              this.lesAnalyses.add(this.documentEntete);
                           }
                        }
                     }
                  }
               }
            } else if (this.inpType == 125) {
               var2 = "facDate>='" + var3 + "' and facDate<='" + var4 + "'";
               if (var21 != null && !var21.isEmpty()) {
                  var2 = var2 + " and tiers.tieid in (" + var21 + ")";
                  var11 = this.factureEnteteVentesDao.rechercheFactureRequete(var2, var1);
                  if (((List)var11).size() != 0 && ((List)var6).size() != 0) {
                     for(var27 = 0; var27 < ((List)var6).size(); ++var27) {
                        var29 = ((Tiers)((List)var6).get(var27)).getTieid();
                        var25 = false;

                        for(var26 = 0; var26 < ((List)var11).size(); ++var26) {
                           if (((FactureEnteteVentes)((List)var11).get(var26)).getTiers().getTieid() == var29) {
                              var25 = true;
                              break;
                           }
                        }

                        if (!var25) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocNomTiers(((Tiers)((List)var6).get(var27)).getTieraisonsocialenom());
                           if (this.documentEntete.getDocNomTiers() != null && !this.documentEntete.getDocNomTiers().isEmpty()) {
                              if (((Tiers)((List)var6).get(var27)).getTieprenom() != null && !((Tiers)((List)var6).get(var27)).getTieprenom().isEmpty()) {
                                 this.documentEntete.setDocNomTiers(this.documentEntete.getDocNomTiers() + " " + ((Tiers)((List)var6).get(var27)).getTieprenom());
                              }

                              this.documentEntete.setDocActivite(((Tiers)((List)var6).get(var27)).getTiecategorie());
                              this.lesAnalyses.add(this.documentEntete);
                           }
                        }
                     }
                  }
               }
            }
         }

         this.utilInitHibernate.closeSession();
         if (this.inpType < 100) {
            if (((List)var14).size() != 0) {
               this.analyseDevisLigne((List)var14);
            } else if (((List)var7).size() != 0) {
               this.analyseDevis((List)var7);
            }

            if (((List)var15).size() != 0) {
               this.analyseCommandeLigne((List)var15);
            } else if (((List)var8).size() != 0) {
               this.analyseCommande((List)var8);
            }

            if (((List)var16).size() != 0) {
               this.analyseLivraisonLigne((List)var16);
            } else if (((List)var9).size() != 0) {
               this.analyseLivraison((List)var9);
            }

            if (((List)var17).size() != 0) {
               this.analyseRetourLigne((List)var17);
            } else if (((List)var10).size() != 0) {
               this.analyseRetour((List)var10);
            }

            if (((List)var18).size() != 0) {
               this.analyseFactureLigne((List)var18);
            } else if (((List)var11).size() != 0) {
               this.analyseFacture((List)var11);
            }

            if (((List)var19).size() != 0) {
               this.analyseNoteDebitLigne((List)var19);
            } else if (((List)var12).size() != 0) {
               this.analyseNoteDebit((List)var12);
            }

            if (((List)var20).size() != 0) {
               this.analyseAvoirLigne((List)var20);
            } else if (((List)var13).size() != 0) {
               this.analyseAvoir((List)var13);
            }

            this.calculTotal();
         }
      }

      this.dataModelAnalyse.setWrappedData(this.lesAnalyses);
   }

   public void analyseDevisLigne(List var1) {
      if (var1.size() != 0) {
         this.documentEntete = new DocumentEntete();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.devisLigneVentes = (DevisLigneVentes)var1.get(var2);
            if (this.devisLigneVentes.getDevisEnteteVentes().getDvsPdv() != null && !this.devisLigneVentes.getDevisEnteteVentes().getDvsPdv().isEmpty()) {
               this.devisLigneVentes.getDevisEnteteVentes().setDvsPdv(this.calculeLibellePdv(this.devisLigneVentes.getDevisEnteteVentes().getDvsPdv()));
            } else {
               this.devisLigneVentes.getDevisEnteteVentes().setDvsPdv("N.S.");
            }

            if (this.devisLigneVentes.getDvsligCode() == null || this.devisLigneVentes.getDvsligCode().isEmpty()) {
               this.devisLigneVentes.setDvsligCode("PROD.LIBRE");
            }

            boolean var3 = false;
            if (this.lesAnalyses.size() != 0) {
               int var4;
               if (this.inpMode == 21) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocAnal2() != null && !this.documentEntete.getDocAnal2().isEmpty() && this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty() && this.documentEntete.getDocAnal2().equals(this.devisLigneVentes.getDvsligCode() + ":" + this.devisLigneVentes.getDvsligLibelle())) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 22) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocPdv() != null && !this.documentEntete.getDocPdv().isEmpty() && this.devisLigneVentes.getDevisEnteteVentes().getDvsPdv() != null && !this.devisLigneVentes.getDevisEnteteVentes().getDvsPdv().isEmpty() && this.documentEntete.getDocAnal2().equals(this.devisLigneVentes.getDevisEnteteVentes().getDvsPdv()) && this.documentEntete.getDocAnal2() != null && !this.documentEntete.getDocAnal2().isEmpty() && this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty() && this.documentEntete.getDocAnal2().equals(this.devisLigneVentes.getDvsligCode() + ":" + this.devisLigneVentes.getDvsligLibelle())) {
                        var3 = true;
                        break;
                     }
                  }
               }
            }

            if (!var3) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdResponsable(this.devisLigneVentes.getDevisEnteteVentes().getDvsIdResponsable());
               this.documentEntete.setDocNomResponsable(this.devisLigneVentes.getDevisEnteteVentes().getDvsNomResponsable());
               this.documentEntete.setDocIdCommercial(this.devisLigneVentes.getDevisEnteteVentes().getDvsIdCommercial());
               this.documentEntete.setDocNomCommercial(this.devisLigneVentes.getDevisEnteteVentes().getDvsNomCommercial());
               this.documentEntete.setDocIdEquipe(this.devisLigneVentes.getDevisEnteteVentes().getDvsIdEquipe());
               this.documentEntete.setDocNomEquipe(this.devisLigneVentes.getDevisEnteteVentes().getDvsNomEquipe());
               this.documentEntete.setDocSource(this.devisLigneVentes.getDevisEnteteVentes().getDvsSource());
               this.documentEntete.setDocPdv(this.devisLigneVentes.getDevisEnteteVentes().getDvsPdv());
               this.documentEntete.setDocAnal2(this.devisLigneVentes.getDvsligCode() + ":" + this.devisLigneVentes.getDvsligLibelle());
               this.documentEntete.setDocQte(this.devisLigneVentes.getDvsligQte());
               this.documentEntete.setDocTotHt(this.devisLigneVentes.getDvsligPt());
               this.documentEntete.setDocTotTva(this.devisLigneVentes.getDvsligTva());
               this.documentEntete.setDocTotTtc(this.devisLigneVentes.getDvsligTtc());
               this.documentEntete.setDocTotReglement(0.0D);
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.lesAnalyses.add(this.documentEntete);
            } else {
               this.lesAnalyses.remove(this.documentEntete);
               this.documentEntete.setDocIdResponsable(this.devisLigneVentes.getDevisEnteteVentes().getDvsIdResponsable());
               this.documentEntete.setDocNomResponsable(this.devisLigneVentes.getDevisEnteteVentes().getDvsNomResponsable());
               this.documentEntete.setDocIdCommercial(this.devisLigneVentes.getDevisEnteteVentes().getDvsIdCommercial());
               this.documentEntete.setDocNomCommercial(this.devisLigneVentes.getDevisEnteteVentes().getDvsNomCommercial());
               this.documentEntete.setDocIdEquipe(this.devisLigneVentes.getDevisEnteteVentes().getDvsIdEquipe());
               this.documentEntete.setDocNomEquipe(this.devisLigneVentes.getDevisEnteteVentes().getDvsNomEquipe());
               this.documentEntete.setDocSource(this.devisLigneVentes.getDevisEnteteVentes().getDvsSource());
               this.documentEntete.setDocPdv(this.devisLigneVentes.getDevisEnteteVentes().getDvsPdv());
               this.documentEntete.setDocAnal2(this.devisLigneVentes.getDvsligCode() + ":" + this.devisLigneVentes.getDvsligLibelle());
               this.documentEntete.setDocQte(this.documentEntete.getDocQte() + this.devisLigneVentes.getDvsligQte());
               this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.devisLigneVentes.getDvsligPt());
               this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.devisLigneVentes.getDvsligTva());
               this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.devisLigneVentes.getDvsligTtc());
               this.documentEntete.setDocTotReglement(0.0D);
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.lesAnalyses.add(this.documentEntete);
            }
         }
      }

   }

   public void analyseDevis(List var1) {
      if (var1.size() != 0) {
         this.documentEntete = new DocumentEntete();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.devisEnteteVentes = (DevisEnteteVentes)var1.get(var2);
            if (this.devisEnteteVentes.getDvsPdv() != null && !this.devisEnteteVentes.getDvsPdv().isEmpty()) {
               this.devisEnteteVentes.setDvsPdv(this.calculeLibellePdv(this.devisEnteteVentes.getDvsPdv()));
            } else {
               this.devisEnteteVentes.setDvsPdv("N.S.");
            }

            boolean var3 = false;
            if (this.lesAnalyses.size() != 0) {
               int var4;
               if (this.inpMode == 0) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdResponsable() == this.devisEnteteVentes.getDvsIdResponsable()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 1) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdCommercial() == this.devisEnteteVentes.getDvsIdCommercial()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 2) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdEquipe() == this.devisEnteteVentes.getDvsIdEquipe()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 10) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.devisEnteteVentes.getDvsSource() != null && !this.devisEnteteVentes.getDvsSource().isEmpty() && this.documentEntete.getDocSource().equals(this.devisEnteteVentes.getDvsSource())) {
                        var3 = true;
                        break;
                     }

                     if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.devisEnteteVentes.getDvsSource() == null || this.devisEnteteVentes.getDvsSource().isEmpty())) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 11) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdResponsable() == this.devisEnteteVentes.getDvsIdResponsable()) {
                        if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.devisEnteteVentes.getDvsSource() != null && !this.devisEnteteVentes.getDvsSource().isEmpty() && this.documentEntete.getDocSource().equals(this.devisEnteteVentes.getDvsSource())) {
                           var3 = true;
                           break;
                        }

                        if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.devisEnteteVentes.getDvsSource() == null || this.devisEnteteVentes.getDvsSource().isEmpty())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               } else if (this.inpMode != 12) {
                  if (this.inpMode == 13) {
                     for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                        if (this.documentEntete.getDocIdEquipe() == this.devisEnteteVentes.getDvsIdEquipe() && this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.devisEnteteVentes.getDvsSource() != null && !this.devisEnteteVentes.getDvsSource().isEmpty() && this.documentEntete.getDocSource().equals(this.devisEnteteVentes.getDvsSource())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               } else {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdCommercial() == this.devisEnteteVentes.getDvsIdCommercial()) {
                        if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.devisEnteteVentes.getDvsSource() != null && !this.devisEnteteVentes.getDvsSource().isEmpty() && this.documentEntete.getDocSource().equals(this.devisEnteteVentes.getDvsSource())) {
                           var3 = true;
                           break;
                        }

                        if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.devisEnteteVentes.getDvsSource() == null || this.devisEnteteVentes.getDvsSource().isEmpty())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               }
            }

            if (!var3) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdResponsable(this.devisEnteteVentes.getDvsIdResponsable());
               this.documentEntete.setDocNomResponsable(this.devisEnteteVentes.getDvsNomResponsable());
               this.documentEntete.setDocIdCommercial(this.devisEnteteVentes.getDvsIdCommercial());
               this.documentEntete.setDocNomCommercial(this.devisEnteteVentes.getDvsNomCommercial());
               this.documentEntete.setDocIdEquipe(this.devisEnteteVentes.getDvsIdEquipe());
               this.documentEntete.setDocNomEquipe(this.devisEnteteVentes.getDvsNomEquipe());
               this.documentEntete.setDocSource(this.devisEnteteVentes.getDvsSource());
               this.documentEntete.setDocTotHt(this.devisEnteteVentes.getDvsTotHt());
               this.documentEntete.setDocTotTva(this.devisEnteteVentes.getDvsTotTva());
               this.documentEntete.setDocTotTtc(this.devisEnteteVentes.getDvsTotTtc());
               this.documentEntete.setDocTotReglement(this.devisEnteteVentes.getDvsTotReglement());
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.documentEntete.setNbrDoc(1);
               if (this.devisEnteteVentes.getDvsEtat() == 4 || this.devisEnteteVentes.getDvsEtat() == 5) {
                  this.documentEntete.setNbrTrf(1);
               }

               this.lesAnalyses.add(this.documentEntete);
            } else {
               this.lesAnalyses.remove(this.documentEntete);
               this.documentEntete.setDocIdResponsable(this.devisEnteteVentes.getDvsIdResponsable());
               this.documentEntete.setDocNomResponsable(this.devisEnteteVentes.getDvsNomResponsable());
               this.documentEntete.setDocIdCommercial(this.devisEnteteVentes.getDvsIdCommercial());
               this.documentEntete.setDocNomCommercial(this.devisEnteteVentes.getDvsNomCommercial());
               this.documentEntete.setDocIdEquipe(this.devisEnteteVentes.getDvsIdEquipe());
               this.documentEntete.setDocNomEquipe(this.devisEnteteVentes.getDvsNomEquipe());
               this.documentEntete.setDocSource(this.devisEnteteVentes.getDvsSource());
               this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.devisEnteteVentes.getDvsTotHt());
               this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.devisEnteteVentes.getDvsTotTva());
               this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.devisEnteteVentes.getDvsTotTtc());
               this.documentEntete.setDocTotReglement(this.documentEntete.getDocTotReglement() + this.devisEnteteVentes.getDvsTotReglement());
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.documentEntete.setNbrDoc(1 + this.documentEntete.getNbrDoc());
               if (this.devisEnteteVentes.getDvsEtat() == 4 || this.devisEnteteVentes.getDvsEtat() == 5) {
                  this.documentEntete.setNbrTrf(1 + this.documentEntete.getNbrTrf());
               }

               this.lesAnalyses.add(this.documentEntete);
            }
         }
      }

   }

   public void analyseCommandeLigne(List var1) {
      if (var1.size() != 0) {
         this.documentEntete = new DocumentEntete();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.commandeLigneVentes = (CommandeLigneVentes)var1.get(var2);
            if (this.commandeLigneVentes.getCommandeEnteteVentes().getBcmPdv() != null && !this.commandeLigneVentes.getCommandeEnteteVentes().getBcmPdv().isEmpty()) {
               this.commandeLigneVentes.getCommandeEnteteVentes().setBcmPdv(this.calculeLibellePdv(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmPdv()));
            } else {
               this.commandeLigneVentes.getCommandeEnteteVentes().setBcmPdv("N.S.");
            }

            if (this.commandeLigneVentes.getBcmligCode() == null || this.commandeLigneVentes.getBcmligCode().isEmpty()) {
               this.commandeLigneVentes.setBcmligCode("PROD.LIBRE");
            }

            boolean var3 = false;
            if (this.lesAnalyses.size() != 0) {
               int var4;
               if (this.inpMode == 21) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocAnal2() != null && !this.documentEntete.getDocAnal2().isEmpty() && this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty() && this.documentEntete.getDocAnal2().equals(this.commandeLigneVentes.getBcmligCode() + ":" + this.commandeLigneVentes.getBcmligLibelle())) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 22) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocPdv() != null && !this.documentEntete.getDocPdv().isEmpty() && this.commandeLigneVentes.getCommandeEnteteVentes().getBcmPdv() != null && !this.commandeLigneVentes.getCommandeEnteteVentes().getBcmPdv().isEmpty() && this.documentEntete.getDocAnal2().equals(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmPdv()) && this.documentEntete.getDocAnal2() != null && !this.documentEntete.getDocAnal2().isEmpty() && this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty() && this.documentEntete.getDocAnal2().equals(this.commandeLigneVentes.getBcmligCode() + ":" + this.commandeLigneVentes.getBcmligLibelle())) {
                        var3 = true;
                        break;
                     }
                  }
               }
            }

            if (!var3) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdResponsable(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmIdResponsable());
               this.documentEntete.setDocNomResponsable(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNomResponsable());
               this.documentEntete.setDocIdCommercial(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmIdCommercial());
               this.documentEntete.setDocNomCommercial(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNomCommercial());
               this.documentEntete.setDocIdEquipe(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmIdEquipe());
               this.documentEntete.setDocNomEquipe(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNomEquipe());
               this.documentEntete.setDocSource(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmSource());
               this.documentEntete.setDocPdv(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmPdv());
               this.documentEntete.setDocAnal2(this.commandeLigneVentes.getBcmligCode() + ":" + this.commandeLigneVentes.getBcmligLibelle());
               this.documentEntete.setDocQte(this.commandeLigneVentes.getBcmligQte());
               this.documentEntete.setDocTotHt(this.commandeLigneVentes.getBcmligPt());
               this.documentEntete.setDocTotTva(this.commandeLigneVentes.getBcmligTva());
               this.documentEntete.setDocTotTtc(this.commandeLigneVentes.getBcmligTtc());
               this.documentEntete.setDocTotReglement(0.0D);
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.lesAnalyses.add(this.documentEntete);
            } else {
               this.lesAnalyses.remove(this.documentEntete);
               this.documentEntete.setDocIdResponsable(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmIdResponsable());
               this.documentEntete.setDocNomResponsable(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNomResponsable());
               this.documentEntete.setDocIdCommercial(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmIdCommercial());
               this.documentEntete.setDocNomCommercial(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNomCommercial());
               this.documentEntete.setDocIdEquipe(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmIdEquipe());
               this.documentEntete.setDocNomEquipe(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNomEquipe());
               this.documentEntete.setDocSource(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmSource());
               this.documentEntete.setDocPdv(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmPdv());
               this.documentEntete.setDocAnal2(this.commandeLigneVentes.getBcmligCode() + ":" + this.commandeLigneVentes.getBcmligLibelle());
               this.documentEntete.setDocQte(this.documentEntete.getDocQte() + this.commandeLigneVentes.getBcmligQte());
               this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.commandeLigneVentes.getBcmligPt());
               this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.commandeLigneVentes.getBcmligTva());
               this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.commandeLigneVentes.getBcmligTtc());
               this.documentEntete.setDocTotReglement(0.0D);
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.lesAnalyses.add(this.documentEntete);
            }
         }
      }

   }

   public void analyseCommande(List var1) {
      if (var1.size() != 0) {
         this.documentEntete = new DocumentEntete();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.commandeEnteteVentes = (CommandeEnteteVentes)var1.get(var2);
            if (this.commandeEnteteVentes.getBcmPdv() != null && !this.commandeEnteteVentes.getBcmPdv().isEmpty()) {
               this.commandeEnteteVentes.setBcmPdv(this.calculeLibellePdv(this.commandeEnteteVentes.getBcmPdv()));
            } else {
               this.commandeEnteteVentes.setBcmPdv("N.S.");
            }

            boolean var3 = false;
            if (this.lesAnalyses.size() != 0) {
               int var4;
               if (this.inpMode == 0) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdResponsable() == this.commandeEnteteVentes.getBcmIdResponsable()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 1) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdCommercial() == this.commandeEnteteVentes.getBcmIdCommercial()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 2) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdEquipe() == this.commandeEnteteVentes.getBcmIdEquipe()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 10) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.commandeEnteteVentes.getBcmSource() != null && !this.commandeEnteteVentes.getBcmSource().isEmpty() && this.documentEntete.getDocSource().equals(this.commandeEnteteVentes.getBcmSource())) {
                        var3 = true;
                        break;
                     }

                     if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.commandeEnteteVentes.getBcmSource() == null || this.commandeEnteteVentes.getBcmSource().isEmpty())) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 11) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdResponsable() == this.commandeEnteteVentes.getBcmIdResponsable()) {
                        if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.commandeEnteteVentes.getBcmSource() != null && !this.commandeEnteteVentes.getBcmSource().isEmpty() && this.documentEntete.getDocSource().equals(this.commandeEnteteVentes.getBcmSource())) {
                           var3 = true;
                           break;
                        }

                        if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.commandeEnteteVentes.getBcmSource() == null || this.commandeEnteteVentes.getBcmSource().isEmpty())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               } else if (this.inpMode != 12) {
                  if (this.inpMode == 13) {
                     for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                        if (this.documentEntete.getDocIdEquipe() == this.commandeEnteteVentes.getBcmIdEquipe() && this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.commandeEnteteVentes.getBcmSource() != null && !this.commandeEnteteVentes.getBcmSource().isEmpty() && this.documentEntete.getDocSource().equals(this.commandeEnteteVentes.getBcmSource())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               } else {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdCommercial() == this.commandeEnteteVentes.getBcmIdCommercial()) {
                        if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.commandeEnteteVentes.getBcmSource() != null && !this.commandeEnteteVentes.getBcmSource().isEmpty() && this.documentEntete.getDocSource().equals(this.commandeEnteteVentes.getBcmSource())) {
                           var3 = true;
                           break;
                        }

                        if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.commandeEnteteVentes.getBcmSource() == null || this.commandeEnteteVentes.getBcmSource().isEmpty())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               }
            }

            if (!var3) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdResponsable(this.commandeEnteteVentes.getBcmIdResponsable());
               this.documentEntete.setDocNomResponsable(this.commandeEnteteVentes.getBcmNomResponsable());
               this.documentEntete.setDocIdCommercial(this.commandeEnteteVentes.getBcmIdCommercial());
               this.documentEntete.setDocNomCommercial(this.commandeEnteteVentes.getBcmNomCommercial());
               this.documentEntete.setDocIdEquipe(this.commandeEnteteVentes.getBcmIdEquipe());
               this.documentEntete.setDocNomEquipe(this.commandeEnteteVentes.getBcmNomEquipe());
               this.documentEntete.setDocSource(this.commandeEnteteVentes.getBcmSource());
               this.documentEntete.setDocTotHt(this.commandeEnteteVentes.getBcmTotHt());
               this.documentEntete.setDocTotTva(this.commandeEnteteVentes.getBcmTotTva());
               this.documentEntete.setDocTotTtc(this.commandeEnteteVentes.getBcmTotTtc());
               this.documentEntete.setDocTotReglement(this.commandeEnteteVentes.getBcmTotReglement());
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.documentEntete.setNbrDoc(1);
               if (this.commandeEnteteVentes.getBcmEtat() == 4 || this.commandeEnteteVentes.getBcmEtat() == 5) {
                  this.documentEntete.setNbrTrf(1);
               }

               this.lesAnalyses.add(this.documentEntete);
            } else {
               this.lesAnalyses.remove(this.documentEntete);
               this.documentEntete.setDocIdResponsable(this.commandeEnteteVentes.getBcmIdResponsable());
               this.documentEntete.setDocNomResponsable(this.commandeEnteteVentes.getBcmNomResponsable());
               this.documentEntete.setDocIdCommercial(this.commandeEnteteVentes.getBcmIdCommercial());
               this.documentEntete.setDocNomCommercial(this.commandeEnteteVentes.getBcmNomCommercial());
               this.documentEntete.setDocIdEquipe(this.commandeEnteteVentes.getBcmIdEquipe());
               this.documentEntete.setDocNomEquipe(this.commandeEnteteVentes.getBcmNomEquipe());
               this.documentEntete.setDocSource(this.commandeEnteteVentes.getBcmSource());
               this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.commandeEnteteVentes.getBcmTotHt());
               this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.commandeEnteteVentes.getBcmTotTva());
               this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.commandeEnteteVentes.getBcmTotTtc());
               this.documentEntete.setDocTotReglement(this.documentEntete.getDocTotReglement() + this.commandeEnteteVentes.getBcmTotReglement());
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.documentEntete.setNbrDoc(1 + this.documentEntete.getNbrDoc());
               if (this.commandeEnteteVentes.getBcmEtat() == 4 || this.commandeEnteteVentes.getBcmEtat() == 5) {
                  this.documentEntete.setNbrTrf(1 + this.documentEntete.getNbrTrf());
               }

               this.lesAnalyses.add(this.documentEntete);
            }
         }
      }

   }

   public void analyseLivraisonLigne(List var1) {
      if (var1.size() != 0) {
         this.documentEntete = new DocumentEntete();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.livraisonLigneVentes = (LivraisonLigneVentes)var1.get(var2);
            if (this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvPdv() != null && !this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvPdv().isEmpty()) {
               this.livraisonLigneVentes.getLivraisonEnteteVentes().setBlvPdv(this.calculeLibellePdv(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvPdv()));
            } else {
               this.livraisonLigneVentes.getLivraisonEnteteVentes().setBlvPdv("N.S.");
            }

            if (this.livraisonLigneVentes.getBlvligCode() == null || this.livraisonLigneVentes.getBlvligCode().isEmpty()) {
               this.livraisonLigneVentes.setBlvligCode("PROD.LIBRE");
            }

            boolean var3 = false;
            if (this.lesAnalyses.size() != 0) {
               int var4;
               if (this.inpMode == 21) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocAnal2() != null && !this.documentEntete.getDocAnal2().isEmpty() && this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty() && this.documentEntete.getDocAnal2().equals(this.livraisonLigneVentes.getBlvligCode() + ":" + this.livraisonLigneVentes.getBlvligLibelle())) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 22) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocPdv() != null && !this.documentEntete.getDocPdv().isEmpty() && this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvPdv() != null && !this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvPdv().isEmpty() && this.documentEntete.getDocAnal2().equals(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvPdv()) && this.documentEntete.getDocAnal2() != null && !this.documentEntete.getDocAnal2().isEmpty() && this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty() && this.documentEntete.getDocAnal2().equals(this.livraisonLigneVentes.getBlvligCode() + ":" + this.livraisonLigneVentes.getBlvligLibelle())) {
                        var3 = true;
                        break;
                     }
                  }
               }
            }

            if (var3) {
               this.lesAnalyses.remove(this.documentEntete);
               this.documentEntete.setDocIdResponsable(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvIdResponsable());
               this.documentEntete.setDocNomResponsable(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvNomResponsable());
               this.documentEntete.setDocIdCommercial(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvIdCommercial());
               this.documentEntete.setDocNomCommercial(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvNomCommercial());
               this.documentEntete.setDocIdEquipe(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvIdEquipe());
               this.documentEntete.setDocNomEquipe(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvNomEquipe());
               this.documentEntete.setDocSource(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvSource());
               this.documentEntete.setDocPdv(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvPdv());
               this.documentEntete.setDocAnal2(this.livraisonLigneVentes.getBlvligCode() + ":" + this.livraisonLigneVentes.getBlvligLibelle());
               this.documentEntete.setDocQte(this.documentEntete.getDocQte() + this.livraisonLigneVentes.getBlvligQte());
               this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.livraisonLigneVentes.getBlvligPt());
               this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.livraisonLigneVentes.getBlvligTva());
               this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.livraisonLigneVentes.getBlvligTtc());
               this.documentEntete.setDocTotReglement(0.0D);
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.lesAnalyses.add(this.documentEntete);
            } else {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdResponsable(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvIdResponsable());
               this.documentEntete.setDocNomResponsable(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvNomResponsable());
               this.documentEntete.setDocIdCommercial(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvIdCommercial());
               this.documentEntete.setDocNomCommercial(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvNomCommercial());
               this.documentEntete.setDocIdEquipe(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvIdEquipe());
               this.documentEntete.setDocNomEquipe(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvNomEquipe());
               this.documentEntete.setDocSource(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvSource());
               this.documentEntete.setDocPdv(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvPdv());
               this.documentEntete.setDocAnal2(this.livraisonLigneVentes.getBlvligCode() + ":" + this.livraisonLigneVentes.getBlvligLibelle());
               this.documentEntete.setDocQte(this.livraisonLigneVentes.getBlvligQte());
               this.documentEntete.setDocTotHt(this.livraisonLigneVentes.getBlvligPt());
               this.documentEntete.setDocTotTva(this.livraisonLigneVentes.getBlvligTva());
               this.documentEntete.setDocTotTtc(this.livraisonLigneVentes.getBlvligTtc());
               this.documentEntete.setDocTotReglement(0.0D);
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.documentEntete.setNbrDoc(1);
               if (this.commandeEnteteVentes.getBcmEtat() == 4 || this.commandeEnteteVentes.getBcmEtat() == 5) {
                  this.documentEntete.setNbrTrf(1);
               }

               this.lesAnalyses.add(this.documentEntete);
            }
         }
      }

   }

   public void analyseLivraison(List var1) {
      if (var1.size() != 0) {
         this.documentEntete = new DocumentEntete();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.livraisonEnteteVentes = (LivraisonEnteteVentes)var1.get(var2);
            if (this.livraisonEnteteVentes.getBlvPdv() != null && !this.livraisonEnteteVentes.getBlvPdv().isEmpty()) {
               this.livraisonEnteteVentes.setBlvPdv(this.calculeLibellePdv(this.livraisonEnteteVentes.getBlvPdv()));
            } else {
               this.livraisonEnteteVentes.setBlvPdv("N.S.");
            }

            boolean var3 = false;
            if (this.lesAnalyses.size() != 0) {
               int var4;
               if (this.inpMode == 0) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdResponsable() == this.livraisonEnteteVentes.getBlvIdResponsable()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 1) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdCommercial() == this.livraisonEnteteVentes.getBlvIdCommercial()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 2) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdEquipe() == this.livraisonEnteteVentes.getBlvIdEquipe()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 10) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.livraisonEnteteVentes.getBlvSource() != null && !this.livraisonEnteteVentes.getBlvSource().isEmpty() && this.documentEntete.getDocSource().equals(this.livraisonEnteteVentes.getBlvSource())) {
                        var3 = true;
                        break;
                     }

                     if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.livraisonEnteteVentes.getBlvSource() == null || this.livraisonEnteteVentes.getBlvSource().isEmpty())) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 11) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdResponsable() == this.livraisonEnteteVentes.getBlvIdResponsable()) {
                        if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.livraisonEnteteVentes.getBlvSource() != null && !this.livraisonEnteteVentes.getBlvSource().isEmpty() && this.documentEntete.getDocSource().equals(this.livraisonEnteteVentes.getBlvSource())) {
                           var3 = true;
                           break;
                        }

                        if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.livraisonEnteteVentes.getBlvSource() == null || this.livraisonEnteteVentes.getBlvSource().isEmpty())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               } else if (this.inpMode != 12) {
                  if (this.inpMode == 13) {
                     for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                        if (this.documentEntete.getDocIdEquipe() == this.livraisonEnteteVentes.getBlvIdEquipe() && this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.livraisonEnteteVentes.getBlvSource() != null && !this.livraisonEnteteVentes.getBlvSource().isEmpty() && this.documentEntete.getDocSource().equals(this.livraisonEnteteVentes.getBlvSource())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               } else {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdCommercial() == this.livraisonEnteteVentes.getBlvIdCommercial()) {
                        if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.livraisonEnteteVentes.getBlvSource() != null && !this.livraisonEnteteVentes.getBlvSource().isEmpty() && this.documentEntete.getDocSource().equals(this.livraisonEnteteVentes.getBlvSource())) {
                           var3 = true;
                           break;
                        }

                        if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.livraisonEnteteVentes.getBlvSource() == null || this.livraisonEnteteVentes.getBlvSource().isEmpty())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               }
            }

            if (!var3) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdResponsable(this.livraisonEnteteVentes.getBlvIdResponsable());
               this.documentEntete.setDocNomResponsable(this.livraisonEnteteVentes.getBlvNomResponsable());
               this.documentEntete.setDocIdCommercial(this.livraisonEnteteVentes.getBlvIdCommercial());
               this.documentEntete.setDocNomCommercial(this.livraisonEnteteVentes.getBlvNomCommercial());
               this.documentEntete.setDocIdEquipe(this.livraisonEnteteVentes.getBlvIdEquipe());
               this.documentEntete.setDocNomEquipe(this.livraisonEnteteVentes.getBlvNomEquipe());
               this.documentEntete.setDocSource(this.livraisonEnteteVentes.getBlvSource());
               this.documentEntete.setDocTotHt(this.livraisonEnteteVentes.getBlvTotHt());
               this.documentEntete.setDocTotTva(this.livraisonEnteteVentes.getBlvTotTva());
               this.documentEntete.setDocTotTtc(this.livraisonEnteteVentes.getBlvTotTtc());
               this.documentEntete.setDocTotReglement(this.livraisonEnteteVentes.getBlvTotReglement());
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.documentEntete.setNbrDoc(1);
               if (this.livraisonEnteteVentes.getBlvEtat() == 4 || this.livraisonEnteteVentes.getBlvEtat() == 5) {
                  this.documentEntete.setNbrTrf(1);
               }

               this.lesAnalyses.add(this.documentEntete);
            } else {
               this.lesAnalyses.remove(this.documentEntete);
               this.documentEntete.setDocIdResponsable(this.livraisonEnteteVentes.getBlvIdResponsable());
               this.documentEntete.setDocNomResponsable(this.livraisonEnteteVentes.getBlvNomResponsable());
               this.documentEntete.setDocIdCommercial(this.livraisonEnteteVentes.getBlvIdCommercial());
               this.documentEntete.setDocNomCommercial(this.livraisonEnteteVentes.getBlvNomCommercial());
               this.documentEntete.setDocIdEquipe(this.livraisonEnteteVentes.getBlvIdEquipe());
               this.documentEntete.setDocNomEquipe(this.livraisonEnteteVentes.getBlvNomEquipe());
               this.documentEntete.setDocSource(this.livraisonEnteteVentes.getBlvSource());
               this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.livraisonEnteteVentes.getBlvTotHt());
               this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.livraisonEnteteVentes.getBlvTotTva());
               this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.livraisonEnteteVentes.getBlvTotTtc());
               this.documentEntete.setDocTotReglement(this.documentEntete.getDocTotReglement() + this.livraisonEnteteVentes.getBlvTotReglement());
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.documentEntete.setNbrDoc(1 + this.documentEntete.getNbrDoc());
               if (this.livraisonEnteteVentes.getBlvEtat() == 4 || this.livraisonEnteteVentes.getBlvEtat() == 5) {
                  this.documentEntete.setNbrTrf(1 + this.documentEntete.getNbrTrf());
               }

               this.lesAnalyses.add(this.documentEntete);
            }
         }
      }

   }

   public void analyseRetourLigne(List var1) {
      if (var1.size() != 0) {
         this.documentEntete = new DocumentEntete();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.retourLigneVentes = (RetourLigneVentes)var1.get(var2);
            if (this.retourLigneVentes.getRetourEnteteVentes().getBrtPdv() != null && !this.retourLigneVentes.getRetourEnteteVentes().getBrtPdv().isEmpty()) {
               this.retourLigneVentes.getRetourEnteteVentes().setBrtPdv(this.calculeLibellePdv(this.retourLigneVentes.getRetourEnteteVentes().getBrtPdv()));
            } else {
               this.retourLigneVentes.getRetourEnteteVentes().setBrtPdv("N.S.");
            }

            if (this.retourLigneVentes.getBrtligCode() == null || this.retourLigneVentes.getBrtligCode().isEmpty()) {
               this.retourLigneVentes.setBrtligCode("PROD.LIBRE");
            }

            boolean var3 = false;
            if (this.lesAnalyses.size() != 0) {
               int var4;
               if (this.inpMode == 21) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocAnal2() != null && !this.documentEntete.getDocAnal2().isEmpty() && this.retourLigneVentes.getBrtligCode() != null && !this.retourLigneVentes.getBrtligCode().isEmpty() && this.documentEntete.getDocAnal2().equals(this.retourLigneVentes.getBrtligCode() + ":" + this.retourLigneVentes.getBrtligLibelle())) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 22) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocPdv() != null && !this.documentEntete.getDocPdv().isEmpty() && this.retourLigneVentes.getRetourEnteteVentes().getBrtPdv() != null && !this.retourLigneVentes.getRetourEnteteVentes().getBrtPdv().isEmpty() && this.documentEntete.getDocAnal2().equals(this.retourLigneVentes.getRetourEnteteVentes().getBrtPdv()) && this.documentEntete.getDocAnal2() != null && !this.documentEntete.getDocAnal2().isEmpty() && this.retourLigneVentes.getBrtligCode() != null && !this.retourLigneVentes.getBrtligCode().isEmpty() && this.documentEntete.getDocAnal2().equals(this.retourLigneVentes.getBrtligCode() + ":" + this.retourLigneVentes.getBrtligLibelle())) {
                        var3 = true;
                        break;
                     }
                  }
               }
            }

            if (!var3) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdResponsable(this.retourLigneVentes.getRetourEnteteVentes().getBrtIdResponsable());
               this.documentEntete.setDocNomResponsable(this.retourLigneVentes.getRetourEnteteVentes().getBrtNomResponsable());
               this.documentEntete.setDocIdCommercial(this.retourLigneVentes.getRetourEnteteVentes().getBrtIdCommercial());
               this.documentEntete.setDocNomCommercial(this.retourLigneVentes.getRetourEnteteVentes().getBrtNomCommercial());
               this.documentEntete.setDocIdEquipe(this.retourLigneVentes.getRetourEnteteVentes().getBrtIdEquipe());
               this.documentEntete.setDocNomEquipe(this.retourLigneVentes.getRetourEnteteVentes().getBrtNomEquipe());
               this.documentEntete.setDocSource(this.retourLigneVentes.getRetourEnteteVentes().getBrtSource());
               this.documentEntete.setDocPdv(this.retourLigneVentes.getRetourEnteteVentes().getBrtPdv());
               this.documentEntete.setDocAnal2(this.retourLigneVentes.getBrtligCode() + ":" + this.retourLigneVentes.getBrtligLibelle());
               this.documentEntete.setDocQte(this.retourLigneVentes.getBrtligQte());
               this.documentEntete.setDocTotHt(this.retourLigneVentes.getBrtligPt());
               this.documentEntete.setDocTotTva(this.retourLigneVentes.getBrtligTva());
               this.documentEntete.setDocTotTtc(this.retourLigneVentes.getBrtligTtc());
               this.documentEntete.setDocTotReglement(0.0D);
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.lesAnalyses.add(this.documentEntete);
            } else {
               this.lesAnalyses.remove(this.documentEntete);
               this.documentEntete.setDocIdResponsable(this.retourLigneVentes.getRetourEnteteVentes().getBrtIdResponsable());
               this.documentEntete.setDocNomResponsable(this.retourLigneVentes.getRetourEnteteVentes().getBrtNomResponsable());
               this.documentEntete.setDocIdCommercial(this.retourLigneVentes.getRetourEnteteVentes().getBrtIdCommercial());
               this.documentEntete.setDocNomCommercial(this.retourLigneVentes.getRetourEnteteVentes().getBrtNomCommercial());
               this.documentEntete.setDocIdEquipe(this.retourLigneVentes.getRetourEnteteVentes().getBrtIdEquipe());
               this.documentEntete.setDocNomEquipe(this.retourLigneVentes.getRetourEnteteVentes().getBrtNomEquipe());
               this.documentEntete.setDocSource(this.retourLigneVentes.getRetourEnteteVentes().getBrtSource());
               this.documentEntete.setDocPdv(this.retourLigneVentes.getRetourEnteteVentes().getBrtPdv());
               this.documentEntete.setDocAnal2(this.retourLigneVentes.getBrtligCode() + ":" + this.retourLigneVentes.getBrtligLibelle());
               this.documentEntete.setDocQte(this.documentEntete.getDocQte() + this.retourLigneVentes.getBrtligQte());
               this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.retourLigneVentes.getBrtligPt());
               this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.retourLigneVentes.getBrtligTva());
               this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.retourLigneVentes.getBrtligTtc());
               this.documentEntete.setDocTotReglement(0.0D);
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.lesAnalyses.add(this.documentEntete);
            }
         }
      }

   }

   public void analyseRetour(List var1) {
      if (var1.size() != 0) {
         this.documentEntete = new DocumentEntete();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.retourEnteteVentes = (RetourEnteteVentes)var1.get(var2);
            if (this.retourEnteteVentes.getBrtPdv() != null && !this.retourEnteteVentes.getBrtPdv().isEmpty()) {
               this.retourEnteteVentes.setBrtPdv(this.calculeLibellePdv(this.retourEnteteVentes.getBrtPdv()));
            } else {
               this.retourEnteteVentes.setBrtPdv("N.S.");
            }

            boolean var3 = false;
            if (this.lesAnalyses.size() != 0) {
               int var4;
               if (this.inpMode == 0) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdResponsable() == this.retourEnteteVentes.getBrtIdResponsable()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 1) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdCommercial() == this.retourEnteteVentes.getBrtIdCommercial()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 2) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdEquipe() == this.retourEnteteVentes.getBrtIdEquipe()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 10) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.retourEnteteVentes.getBrtSource() != null && !this.retourEnteteVentes.getBrtSource().isEmpty() && this.documentEntete.getDocSource().equals(this.retourEnteteVentes.getBrtSource())) {
                        var3 = true;
                        break;
                     }

                     if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.retourEnteteVentes.getBrtSource() == null || this.retourEnteteVentes.getBrtSource().isEmpty())) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 11) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdResponsable() == this.retourEnteteVentes.getBrtIdResponsable()) {
                        if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.retourEnteteVentes.getBrtSource() != null && !this.retourEnteteVentes.getBrtSource().isEmpty() && this.documentEntete.getDocSource().equals(this.retourEnteteVentes.getBrtSource())) {
                           var3 = true;
                           break;
                        }

                        if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.retourEnteteVentes.getBrtSource() == null || this.retourEnteteVentes.getBrtSource().isEmpty())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               } else if (this.inpMode != 12) {
                  if (this.inpMode == 13) {
                     for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                        if (this.documentEntete.getDocIdEquipe() == this.retourEnteteVentes.getBrtIdEquipe() && this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.retourEnteteVentes.getBrtSource() != null && !this.retourEnteteVentes.getBrtSource().isEmpty() && this.documentEntete.getDocSource().equals(this.retourEnteteVentes.getBrtSource())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               } else {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdCommercial() == this.retourEnteteVentes.getBrtIdCommercial()) {
                        if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.retourEnteteVentes.getBrtSource() != null && !this.retourEnteteVentes.getBrtSource().isEmpty() && this.documentEntete.getDocSource().equals(this.retourEnteteVentes.getBrtSource())) {
                           var3 = true;
                           break;
                        }

                        if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.retourEnteteVentes.getBrtSource() == null || this.retourEnteteVentes.getBrtSource().isEmpty())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               }
            }

            if (!var3) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdResponsable(this.retourEnteteVentes.getBrtIdResponsable());
               this.documentEntete.setDocNomResponsable(this.retourEnteteVentes.getBrtNomResponsable());
               this.documentEntete.setDocIdCommercial(this.retourEnteteVentes.getBrtIdCommercial());
               this.documentEntete.setDocNomCommercial(this.retourEnteteVentes.getBrtNomCommercial());
               this.documentEntete.setDocIdEquipe(this.retourEnteteVentes.getBrtIdEquipe());
               this.documentEntete.setDocNomEquipe(this.retourEnteteVentes.getBrtNomEquipe());
               this.documentEntete.setDocSource(this.retourEnteteVentes.getBrtSource());
               this.documentEntete.setDocTotHt(this.retourEnteteVentes.getBrtTotHt());
               this.documentEntete.setDocTotTva(this.retourEnteteVentes.getBrtTotTva());
               this.documentEntete.setDocTotTtc(this.retourEnteteVentes.getBrtTotTtc());
               this.documentEntete.setDocTotReglement(this.retourEnteteVentes.getBrtTotReglement());
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.documentEntete.setNbrDoc(1);
               if (this.retourEnteteVentes.getBrtEtat() == 4 || this.retourEnteteVentes.getBrtEtat() == 5) {
                  this.documentEntete.setNbrTrf(1);
               }

               this.lesAnalyses.add(this.documentEntete);
            } else {
               this.lesAnalyses.remove(this.documentEntete);
               this.documentEntete.setDocIdResponsable(this.retourEnteteVentes.getBrtIdResponsable());
               this.documentEntete.setDocNomResponsable(this.retourEnteteVentes.getBrtNomResponsable());
               this.documentEntete.setDocIdCommercial(this.retourEnteteVentes.getBrtIdCommercial());
               this.documentEntete.setDocNomCommercial(this.retourEnteteVentes.getBrtNomCommercial());
               this.documentEntete.setDocIdEquipe(this.retourEnteteVentes.getBrtIdEquipe());
               this.documentEntete.setDocNomEquipe(this.retourEnteteVentes.getBrtNomEquipe());
               this.documentEntete.setDocSource(this.retourEnteteVentes.getBrtSource());
               this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.retourEnteteVentes.getBrtTotHt());
               this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.retourEnteteVentes.getBrtTotTva());
               this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.retourEnteteVentes.getBrtTotTtc());
               this.documentEntete.setDocTotReglement(this.documentEntete.getDocTotReglement() + this.retourEnteteVentes.getBrtTotReglement());
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.documentEntete.setNbrDoc(1 + this.documentEntete.getNbrDoc());
               if (this.retourEnteteVentes.getBrtEtat() == 4 || this.retourEnteteVentes.getBrtEtat() == 5) {
                  this.documentEntete.setNbrTrf(1 + this.documentEntete.getNbrTrf());
               }

               this.lesAnalyses.add(this.documentEntete);
            }
         }
      }

   }

   public void analyseFactureLigne(List var1) {
      if (var1.size() != 0) {
         this.documentEntete = new DocumentEntete();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.factureLigneVentes = (FactureLigneVentes)var1.get(var2);
            if (this.factureLigneVentes.getFactureEnteteVentes().getFacPdv() != null && !this.factureLigneVentes.getFactureEnteteVentes().getFacPdv().isEmpty()) {
               this.factureLigneVentes.getFactureEnteteVentes().setFacPdv(this.calculeLibellePdv(this.factureLigneVentes.getFactureEnteteVentes().getFacPdv()));
            } else {
               this.factureLigneVentes.getFactureEnteteVentes().setFacPdv("N.S.");
            }

            if (this.factureLigneVentes.getFacligCode() == null || this.factureLigneVentes.getFacligCode().isEmpty()) {
               this.factureLigneVentes.setFacligCode("PROD.LIBRE");
            }

            boolean var3 = false;
            if (this.lesAnalyses.size() != 0) {
               int var4;
               if (this.inpMode == 21) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocAnal2() != null && !this.documentEntete.getDocAnal2().isEmpty() && this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty() && this.documentEntete.getDocAnal2().equals(this.factureLigneVentes.getFacligCode() + ":" + this.factureLigneVentes.getFacligLibelle())) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 22) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocPdv() != null && !this.documentEntete.getDocPdv().isEmpty() && this.factureLigneVentes.getFactureEnteteVentes().getFacPdv() != null && !this.factureLigneVentes.getFactureEnteteVentes().getFacPdv().isEmpty() && this.documentEntete.getDocAnal2().equals(this.factureLigneVentes.getFactureEnteteVentes().getFacPdv()) && this.documentEntete.getDocAnal2() != null && !this.documentEntete.getDocAnal2().isEmpty() && this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty() && this.documentEntete.getDocAnal2().equals(this.factureLigneVentes.getFacligCode() + ":" + this.factureLigneVentes.getFacligLibelle())) {
                        var3 = true;
                        break;
                     }
                  }
               }
            }

            if (!var3) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdResponsable(this.factureLigneVentes.getFactureEnteteVentes().getFacIdResponsable());
               this.documentEntete.setDocNomResponsable(this.factureLigneVentes.getFactureEnteteVentes().getFacNomResponsable());
               this.documentEntete.setDocIdCommercial(this.factureLigneVentes.getFactureEnteteVentes().getFacIdCommercial());
               this.documentEntete.setDocNomCommercial(this.factureLigneVentes.getFactureEnteteVentes().getFacNomCommercial());
               this.documentEntete.setDocIdEquipe(this.factureLigneVentes.getFactureEnteteVentes().getFacIdEquipe());
               this.documentEntete.setDocNomEquipe(this.factureLigneVentes.getFactureEnteteVentes().getFacNomEquipe());
               this.documentEntete.setDocSource(this.factureLigneVentes.getFactureEnteteVentes().getFacSource());
               this.documentEntete.setDocPdv(this.factureLigneVentes.getFactureEnteteVentes().getFacPdv());
               this.documentEntete.setDocAnal2(this.factureLigneVentes.getFacligCode() + ":" + this.factureLigneVentes.getFacligLibelle());
               this.documentEntete.setDocQte(this.factureLigneVentes.getFacligQte());
               this.documentEntete.setDocTotHt(this.factureLigneVentes.getFacligPt());
               this.documentEntete.setDocTotTva(this.factureLigneVentes.getFacligTva());
               this.documentEntete.setDocTotTtc(this.factureLigneVentes.getFacligTtc());
               this.documentEntete.setDocTotReglement(0.0D);
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.lesAnalyses.add(this.documentEntete);
            } else {
               this.lesAnalyses.remove(this.documentEntete);
               this.documentEntete.setDocIdResponsable(this.factureLigneVentes.getFactureEnteteVentes().getFacIdResponsable());
               this.documentEntete.setDocNomResponsable(this.factureLigneVentes.getFactureEnteteVentes().getFacNomResponsable());
               this.documentEntete.setDocIdCommercial(this.factureLigneVentes.getFactureEnteteVentes().getFacIdCommercial());
               this.documentEntete.setDocNomCommercial(this.factureLigneVentes.getFactureEnteteVentes().getFacNomCommercial());
               this.documentEntete.setDocIdEquipe(this.factureLigneVentes.getFactureEnteteVentes().getFacIdEquipe());
               this.documentEntete.setDocNomEquipe(this.factureLigneVentes.getFactureEnteteVentes().getFacNomEquipe());
               this.documentEntete.setDocSource(this.factureLigneVentes.getFactureEnteteVentes().getFacSource());
               this.documentEntete.setDocPdv(this.factureLigneVentes.getFactureEnteteVentes().getFacPdv());
               this.documentEntete.setDocAnal2(this.factureLigneVentes.getFacligCode() + ":" + this.factureLigneVentes.getFacligLibelle());
               this.documentEntete.setDocQte(this.documentEntete.getDocQte() + this.factureLigneVentes.getFacligQte());
               this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.factureLigneVentes.getFacligPt());
               this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.factureLigneVentes.getFacligTva());
               this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.factureLigneVentes.getFacligTtc());
               this.documentEntete.setDocTotReglement(0.0D);
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.lesAnalyses.add(this.documentEntete);
            }
         }
      }

   }

   public void analyseFacture(List var1) {
      if (var1.size() != 0) {
         this.documentEntete = new DocumentEntete();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.factureEnteteVentes = (FactureEnteteVentes)var1.get(var2);
            if (this.factureEnteteVentes.getFacPdv() != null && !this.factureEnteteVentes.getFacPdv().isEmpty()) {
               this.factureEnteteVentes.setFacPdv(this.calculeLibellePdv(this.factureEnteteVentes.getFacPdv()));
            } else {
               this.factureEnteteVentes.setFacPdv("N.S.");
            }

            boolean var3 = false;
            if (this.lesAnalyses.size() != 0) {
               int var4;
               if (this.inpMode == 0) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdResponsable() == this.factureEnteteVentes.getFacIdResponsable()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 1) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdCommercial() == this.factureEnteteVentes.getFacIdCommercial()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 2) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdEquipe() == this.factureEnteteVentes.getFacIdEquipe()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 10) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.factureEnteteVentes.getFacSource() != null && !this.factureEnteteVentes.getFacSource().isEmpty() && this.documentEntete.getDocSource().equals(this.factureEnteteVentes.getFacSource())) {
                        var3 = true;
                        break;
                     }

                     if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.factureEnteteVentes.getFacSource() == null || this.factureEnteteVentes.getFacSource().isEmpty())) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 11) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdResponsable() == this.factureEnteteVentes.getFacIdResponsable()) {
                        if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.factureEnteteVentes.getFacSource() != null && !this.factureEnteteVentes.getFacSource().isEmpty() && this.documentEntete.getDocSource().equals(this.factureEnteteVentes.getFacSource())) {
                           var3 = true;
                           break;
                        }

                        if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.factureEnteteVentes.getFacSource() == null || this.factureEnteteVentes.getFacSource().isEmpty())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               } else if (this.inpMode == 12) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdCommercial() == this.factureEnteteVentes.getFacIdCommercial()) {
                        if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.factureEnteteVentes.getFacSource() != null && !this.factureEnteteVentes.getFacSource().isEmpty() && this.documentEntete.getDocSource().equals(this.factureEnteteVentes.getFacSource())) {
                           var3 = true;
                           break;
                        }

                        if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.factureEnteteVentes.getFacSource() == null || this.factureEnteteVentes.getFacSource().isEmpty())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               } else if (this.inpMode != 13) {
                  if (this.inpMode == 20) {
                     for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                        if (this.documentEntete.getDocPdv() != null && !this.documentEntete.getDocPdv().isEmpty() && this.factureEnteteVentes.getFacPdv() != null && !this.factureEnteteVentes.getFacPdv().isEmpty() && this.documentEntete.getDocPdv().equals(this.factureEnteteVentes.getFacPdv())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               } else {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdEquipe() == this.factureEnteteVentes.getFacIdEquipe()) {
                        if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.factureEnteteVentes.getFacSource() != null && !this.factureEnteteVentes.getFacSource().isEmpty() && this.documentEntete.getDocSource().equals(this.factureEnteteVentes.getFacSource())) {
                           var3 = true;
                           break;
                        }

                        if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.factureEnteteVentes.getFacSource() == null || this.factureEnteteVentes.getFacSource().isEmpty())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               }
            }

            if (!var3) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdResponsable(this.factureEnteteVentes.getFacIdResponsable());
               this.documentEntete.setDocNomResponsable(this.factureEnteteVentes.getFacNomResponsable());
               this.documentEntete.setDocIdCommercial(this.factureEnteteVentes.getFacIdCommercial());
               this.documentEntete.setDocNomCommercial(this.factureEnteteVentes.getFacNomCommercial());
               this.documentEntete.setDocIdEquipe(this.factureEnteteVentes.getFacIdEquipe());
               this.documentEntete.setDocNomEquipe(this.factureEnteteVentes.getFacNomEquipe());
               this.documentEntete.setDocSource(this.factureEnteteVentes.getFacSource());
               this.documentEntete.setDocPdv(this.factureEnteteVentes.getFacPdv());
               this.documentEntete.setDocTotHt(this.factureEnteteVentes.getFacTotHt());
               this.documentEntete.setDocTotTva(this.factureEnteteVentes.getFacTotTva());
               this.documentEntete.setDocTotTtc(this.factureEnteteVentes.getFacTotTtc());
               this.documentEntete.setDocTotReglement(this.factureEnteteVentes.getFacTotReglement());
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.documentEntete.setNbrDoc(1);
               if (this.factureEnteteVentes.getFacEtat() == 4 || this.factureEnteteVentes.getFacEtat() == 5) {
                  this.documentEntete.setNbrTrf(1);
               }

               this.lesAnalyses.add(this.documentEntete);
            } else {
               this.lesAnalyses.remove(this.documentEntete);
               this.documentEntete.setDocIdResponsable(this.factureEnteteVentes.getFacIdResponsable());
               this.documentEntete.setDocNomResponsable(this.factureEnteteVentes.getFacNomResponsable());
               this.documentEntete.setDocIdCommercial(this.factureEnteteVentes.getFacIdCommercial());
               this.documentEntete.setDocNomCommercial(this.factureEnteteVentes.getFacNomCommercial());
               this.documentEntete.setDocIdEquipe(this.factureEnteteVentes.getFacIdEquipe());
               this.documentEntete.setDocNomEquipe(this.factureEnteteVentes.getFacNomEquipe());
               this.documentEntete.setDocSource(this.factureEnteteVentes.getFacSource());
               this.documentEntete.setDocPdv(this.factureEnteteVentes.getFacPdv());
               this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.factureEnteteVentes.getFacTotHt());
               this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.factureEnteteVentes.getFacTotTva());
               this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.factureEnteteVentes.getFacTotTtc());
               this.documentEntete.setDocTotReglement(this.documentEntete.getDocTotReglement() + this.factureEnteteVentes.getFacTotReglement());
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.documentEntete.setNbrDoc(1 + this.documentEntete.getNbrDoc());
               if (this.factureEnteteVentes.getFacEtat() == 4 || this.factureEnteteVentes.getFacEtat() == 5) {
                  this.documentEntete.setNbrTrf(1 + this.documentEntete.getNbrTrf());
               }

               this.lesAnalyses.add(this.documentEntete);
            }
         }
      }

   }

   public void analyseNoteDebitLigne(List var1) {
      if (var1.size() != 0) {
         this.documentEntete = new DocumentEntete();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.noteDebitLigneVentes = (NoteDebitLigneVentes)var1.get(var2);
            if (this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbPdv() != null && !this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbPdv().isEmpty()) {
               this.noteDebitLigneVentes.getNoteDebitEnteteVentes().setNdbPdv(this.calculeLibellePdv(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbPdv()));
            } else {
               this.noteDebitLigneVentes.getNoteDebitEnteteVentes().setNdbPdv("N.S.");
            }

            if (this.noteDebitLigneVentes.getNdbligCode() == null || this.noteDebitLigneVentes.getNdbligCode().isEmpty()) {
               this.noteDebitLigneVentes.setNdbligCode("PROD.LIBRE");
            }

            boolean var3 = false;
            if (this.lesAnalyses.size() != 0) {
               int var4;
               if (this.inpMode == 21) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocAnal2() != null && !this.documentEntete.getDocAnal2().isEmpty() && this.noteDebitLigneVentes.getNdbligCode() != null && !this.noteDebitLigneVentes.getNdbligCode().isEmpty() && this.documentEntete.getDocAnal2().equals(this.noteDebitLigneVentes.getNdbligCode() + ":" + this.noteDebitLigneVentes.getNdbligLibelle())) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 22) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocPdv() != null && !this.documentEntete.getDocPdv().isEmpty() && this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbPdv() != null && !this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbPdv().isEmpty() && this.documentEntete.getDocAnal2().equals(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbPdv()) && this.documentEntete.getDocAnal2() != null && !this.documentEntete.getDocAnal2().isEmpty() && this.noteDebitLigneVentes.getNdbligCode() != null && !this.noteDebitLigneVentes.getNdbligCode().isEmpty() && this.documentEntete.getDocAnal2().equals(this.noteDebitLigneVentes.getNdbligCode() + ":" + this.noteDebitLigneVentes.getNdbligLibelle())) {
                        var3 = true;
                        break;
                     }
                  }
               }
            }

            if (!var3) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdResponsable(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbIdResponsable());
               this.documentEntete.setDocNomResponsable(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbNomResponsable());
               this.documentEntete.setDocIdCommercial(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbIdCommercial());
               this.documentEntete.setDocNomCommercial(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbNomCommercial());
               this.documentEntete.setDocIdEquipe(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbIdEquipe());
               this.documentEntete.setDocNomEquipe(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbNomEquipe());
               this.documentEntete.setDocSource(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbSource());
               this.documentEntete.setDocPdv(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbPdv());
               this.documentEntete.setDocAnal2(this.noteDebitLigneVentes.getNdbligCode() + ":" + this.noteDebitLigneVentes.getNdbligLibelle());
               this.documentEntete.setDocQte(this.noteDebitLigneVentes.getNdbligQte());
               this.documentEntete.setDocTotHt(this.noteDebitLigneVentes.getNdbligPt());
               this.documentEntete.setDocTotTva(this.noteDebitLigneVentes.getNdbligTva());
               this.documentEntete.setDocTotTtc(this.noteDebitLigneVentes.getNdbligTtc());
               this.documentEntete.setDocTotReglement(0.0D);
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.lesAnalyses.add(this.documentEntete);
            } else {
               this.lesAnalyses.remove(this.documentEntete);
               this.documentEntete.setDocIdResponsable(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbIdResponsable());
               this.documentEntete.setDocNomResponsable(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbNomResponsable());
               this.documentEntete.setDocIdCommercial(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbIdCommercial());
               this.documentEntete.setDocNomCommercial(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbNomCommercial());
               this.documentEntete.setDocIdEquipe(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbIdEquipe());
               this.documentEntete.setDocNomEquipe(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbNomEquipe());
               this.documentEntete.setDocSource(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbSource());
               this.documentEntete.setDocPdv(this.noteDebitLigneVentes.getNoteDebitEnteteVentes().getNdbPdv());
               this.documentEntete.setDocAnal2(this.noteDebitLigneVentes.getNdbligCode() + ":" + this.noteDebitLigneVentes.getNdbligLibelle());
               this.documentEntete.setDocQte(this.documentEntete.getDocQte() + this.noteDebitLigneVentes.getNdbligQte());
               this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.noteDebitLigneVentes.getNdbligPt());
               this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.noteDebitLigneVentes.getNdbligTva());
               this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.noteDebitLigneVentes.getNdbligTtc());
               this.documentEntete.setDocTotReglement(0.0D);
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.lesAnalyses.add(this.documentEntete);
            }
         }
      }

   }

   public void analyseNoteDebit(List var1) {
      if (var1.size() != 0) {
         this.documentEntete = new DocumentEntete();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.noteDebitEnteteVentes = (NoteDebitEnteteVentes)var1.get(var2);
            if (this.noteDebitEnteteVentes.getNdbPdv() != null && !this.noteDebitEnteteVentes.getNdbPdv().isEmpty()) {
               this.noteDebitEnteteVentes.setNdbPdv(this.calculeLibellePdv(this.noteDebitEnteteVentes.getNdbPdv()));
            } else {
               this.noteDebitEnteteVentes.setNdbPdv("N.S.");
            }

            boolean var3 = false;
            if (this.lesAnalyses.size() != 0) {
               int var4;
               if (this.inpMode == 0) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdResponsable() == this.noteDebitEnteteVentes.getNdbIdResponsable()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 1) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdCommercial() == this.noteDebitEnteteVentes.getNdbIdCommercial()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 2) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdEquipe() == this.noteDebitEnteteVentes.getNdbIdEquipe()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 10) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.noteDebitEnteteVentes.getNdbSource() != null && !this.noteDebitEnteteVentes.getNdbSource().isEmpty() && this.documentEntete.getDocSource().equals(this.noteDebitEnteteVentes.getNdbSource())) {
                        var3 = true;
                        break;
                     }

                     if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.noteDebitEnteteVentes.getNdbSource() == null || this.noteDebitEnteteVentes.getNdbSource().isEmpty())) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 11) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdResponsable() == this.noteDebitEnteteVentes.getNdbIdResponsable()) {
                        if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.noteDebitEnteteVentes.getNdbSource() != null && !this.noteDebitEnteteVentes.getNdbSource().isEmpty() && this.documentEntete.getDocSource().equals(this.noteDebitEnteteVentes.getNdbSource())) {
                           var3 = true;
                           break;
                        }

                        if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.noteDebitEnteteVentes.getNdbSource() == null || this.noteDebitEnteteVentes.getNdbSource().isEmpty())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               } else if (this.inpMode != 12) {
                  if (this.inpMode == 13) {
                     for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                        if (this.documentEntete.getDocIdEquipe() == this.noteDebitEnteteVentes.getNdbIdEquipe() && this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.noteDebitEnteteVentes.getNdbSource() != null && !this.noteDebitEnteteVentes.getNdbSource().isEmpty() && this.documentEntete.getDocSource().equals(this.noteDebitEnteteVentes.getNdbSource())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               } else {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdCommercial() == this.noteDebitEnteteVentes.getNdbIdCommercial()) {
                        if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.noteDebitEnteteVentes.getNdbSource() != null && !this.noteDebitEnteteVentes.getNdbSource().isEmpty() && this.documentEntete.getDocSource().equals(this.noteDebitEnteteVentes.getNdbSource())) {
                           var3 = true;
                           break;
                        }

                        if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.noteDebitEnteteVentes.getNdbSource() == null || this.noteDebitEnteteVentes.getNdbSource().isEmpty())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               }
            }

            if (!var3) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdResponsable(this.noteDebitEnteteVentes.getNdbIdResponsable());
               this.documentEntete.setDocNomResponsable(this.noteDebitEnteteVentes.getNdbNomResponsable());
               this.documentEntete.setDocIdCommercial(this.noteDebitEnteteVentes.getNdbIdCommercial());
               this.documentEntete.setDocNomCommercial(this.noteDebitEnteteVentes.getNdbNomCommercial());
               this.documentEntete.setDocIdEquipe(this.noteDebitEnteteVentes.getNdbIdEquipe());
               this.documentEntete.setDocNomEquipe(this.noteDebitEnteteVentes.getNdbNomEquipe());
               this.documentEntete.setDocSource(this.noteDebitEnteteVentes.getNdbSource());
               this.documentEntete.setDocTotHt(this.noteDebitEnteteVentes.getNdbTotHt());
               this.documentEntete.setDocTotTva(this.noteDebitEnteteVentes.getNdbTotTva());
               this.documentEntete.setDocTotTtc(this.noteDebitEnteteVentes.getNdbTotTtc());
               this.documentEntete.setDocTotReglement(this.noteDebitEnteteVentes.getNdbTotReglement());
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.documentEntete.setNbrDoc(1);
               if (this.noteDebitEnteteVentes.getNdbEtat() == 4 || this.noteDebitEnteteVentes.getNdbEtat() == 5) {
                  this.documentEntete.setNbrTrf(1);
               }

               this.lesAnalyses.add(this.documentEntete);
            } else {
               this.lesAnalyses.remove(this.documentEntete);
               this.documentEntete.setDocIdResponsable(this.noteDebitEnteteVentes.getNdbIdResponsable());
               this.documentEntete.setDocNomResponsable(this.noteDebitEnteteVentes.getNdbNomResponsable());
               this.documentEntete.setDocIdCommercial(this.noteDebitEnteteVentes.getNdbIdCommercial());
               this.documentEntete.setDocNomCommercial(this.noteDebitEnteteVentes.getNdbNomCommercial());
               this.documentEntete.setDocIdEquipe(this.noteDebitEnteteVentes.getNdbIdEquipe());
               this.documentEntete.setDocNomEquipe(this.noteDebitEnteteVentes.getNdbNomEquipe());
               this.documentEntete.setDocSource(this.noteDebitEnteteVentes.getNdbSource());
               this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.noteDebitEnteteVentes.getNdbTotHt());
               this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.noteDebitEnteteVentes.getNdbTotTva());
               this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.noteDebitEnteteVentes.getNdbTotTtc());
               this.documentEntete.setDocTotReglement(this.documentEntete.getDocTotReglement() + this.noteDebitEnteteVentes.getNdbTotReglement());
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.documentEntete.setNbrDoc(1 + this.documentEntete.getNbrDoc());
               if (this.noteDebitEnteteVentes.getNdbEtat() == 4 || this.noteDebitEnteteVentes.getNdbEtat() == 5) {
                  this.documentEntete.setNbrTrf(1 + this.documentEntete.getNbrTrf());
               }

               this.lesAnalyses.add(this.documentEntete);
            }
         }
      }

   }

   public void analyseAvoirLigne(List var1) {
      if (var1.size() != 0) {
         this.documentEntete = new DocumentEntete();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.avoirLigneVentes = (AvoirLigneVentes)var1.get(var2);
            if (this.avoirLigneVentes.getAvoirEnteteVentes().getAvrPdv() != null && !this.avoirLigneVentes.getAvoirEnteteVentes().getAvrPdv().isEmpty()) {
               this.avoirLigneVentes.getAvoirEnteteVentes().setAvrPdv(this.calculeLibellePdv(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrPdv()));
            } else {
               this.avoirLigneVentes.getAvoirEnteteVentes().setAvrPdv("N.S.");
            }

            if (this.avoirLigneVentes.getAvrligCode() == null || this.noteDebitLigneVentes.getNdbligCode().isEmpty()) {
               this.avoirLigneVentes.setAvrligCode("PROD.LIBRE");
            }

            this.avoirLigneVentes.setAvrligQte(this.avoirLigneVentes.getAvrligQte() * -1.0F);
            this.avoirLigneVentes.setAvrligPt(this.avoirLigneVentes.getAvrligPt() * -1.0D);
            this.avoirLigneVentes.setAvrligTva(this.avoirLigneVentes.getAvrligTva() * -1.0D);
            this.avoirLigneVentes.setAvrligTtc(this.avoirLigneVentes.getAvrligTtc() * -1.0D);
            boolean var3 = false;
            if (this.lesAnalyses.size() != 0) {
               int var4;
               if (this.inpMode == 21) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocAnal2() != null && !this.documentEntete.getDocAnal2().isEmpty() && this.avoirLigneVentes.getAvrligCode() != null && !this.avoirLigneVentes.getAvrligCode().isEmpty() && this.documentEntete.getDocAnal2().equals(this.avoirLigneVentes.getAvrligCode() + ":" + this.avoirLigneVentes.getAvrligLibelle())) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 22) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocPdv() != null && !this.documentEntete.getDocPdv().isEmpty() && this.avoirLigneVentes.getAvoirEnteteVentes().getAvrPdv() != null && !this.avoirLigneVentes.getAvoirEnteteVentes().getAvrPdv().isEmpty() && this.documentEntete.getDocAnal2().equals(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrPdv()) && this.documentEntete.getDocAnal2() != null && !this.documentEntete.getDocAnal2().isEmpty() && this.avoirLigneVentes.getAvrligCode() != null && !this.avoirLigneVentes.getAvrligCode().isEmpty() && this.documentEntete.getDocAnal2().equals(this.avoirLigneVentes.getAvrligCode() + ":" + this.avoirLigneVentes.getAvrligLibelle())) {
                        var3 = true;
                        break;
                     }
                  }
               }
            }

            if (!var3) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdResponsable(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrIdResponsable());
               this.documentEntete.setDocNomResponsable(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrNomResponsable());
               this.documentEntete.setDocIdCommercial(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrIdCommercial());
               this.documentEntete.setDocNomCommercial(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrNomCommercial());
               this.documentEntete.setDocIdEquipe(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrIdEquipe());
               this.documentEntete.setDocNomEquipe(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrNomEquipe());
               this.documentEntete.setDocSource(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrSource());
               this.documentEntete.setDocPdv(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrPdv());
               this.documentEntete.setDocAnal2(this.avoirLigneVentes.getAvrligCode() + ":" + this.avoirLigneVentes.getAvrligLibelle());
               this.documentEntete.setDocQte(this.avoirLigneVentes.getAvrligQte());
               this.documentEntete.setDocTotHt(this.avoirLigneVentes.getAvrligPt());
               this.documentEntete.setDocTotTva(this.avoirLigneVentes.getAvrligTva());
               this.documentEntete.setDocTotTtc(this.avoirLigneVentes.getAvrligTtc());
               this.documentEntete.setDocTotReglement(0.0D);
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.lesAnalyses.add(this.documentEntete);
            } else {
               this.lesAnalyses.remove(this.documentEntete);
               this.documentEntete.setDocIdResponsable(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrIdResponsable());
               this.documentEntete.setDocNomResponsable(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrNomResponsable());
               this.documentEntete.setDocIdCommercial(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrIdCommercial());
               this.documentEntete.setDocNomCommercial(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrNomCommercial());
               this.documentEntete.setDocIdEquipe(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrIdEquipe());
               this.documentEntete.setDocNomEquipe(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrNomEquipe());
               this.documentEntete.setDocSource(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrSource());
               this.documentEntete.setDocPdv(this.avoirLigneVentes.getAvoirEnteteVentes().getAvrPdv());
               this.documentEntete.setDocAnal2(this.avoirLigneVentes.getAvrligCode() + ":" + this.avoirLigneVentes.getAvrligLibelle());
               this.documentEntete.setDocQte(this.documentEntete.getDocQte() + this.avoirLigneVentes.getAvrligQte());
               this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.avoirLigneVentes.getAvrligPt());
               this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.avoirLigneVentes.getAvrligTva());
               this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.avoirLigneVentes.getAvrligTtc());
               this.documentEntete.setDocTotReglement(0.0D);
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.lesAnalyses.add(this.documentEntete);
            }
         }
      }

   }

   public void analyseAvoir(List var1) {
      if (var1.size() != 0) {
         this.documentEntete = new DocumentEntete();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.avoirEnteteVentes = (AvoirEnteteVentes)var1.get(var2);
            if (this.avoirEnteteVentes.getAvrPdv() != null && !this.avoirEnteteVentes.getAvrPdv().isEmpty()) {
               this.avoirEnteteVentes.setAvrPdv(this.calculeLibellePdv(this.avoirEnteteVentes.getAvrPdv()));
            } else {
               this.avoirEnteteVentes.setAvrPdv("N.S.");
            }

            this.avoirEnteteVentes.setAvrTotHt(this.avoirEnteteVentes.getAvrTotHt() * -1.0D);
            this.avoirEnteteVentes.setAvrTotTva(this.avoirEnteteVentes.getAvrTotTva() * -1.0D);
            this.avoirEnteteVentes.setAvrTotTtc(this.avoirEnteteVentes.getAvrTotTtc() * -1.0D);
            boolean var3 = false;
            if (this.lesAnalyses.size() != 0) {
               int var4;
               if (this.inpMode == 0) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdResponsable() == this.avoirEnteteVentes.getAvrIdResponsable()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 1) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdCommercial() == this.avoirEnteteVentes.getAvrIdCommercial()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 2) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdEquipe() == this.avoirEnteteVentes.getAvrIdEquipe()) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 10) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.avoirEnteteVentes.getAvrSource() != null && !this.avoirEnteteVentes.getAvrSource().isEmpty() && this.documentEntete.getDocSource().equals(this.avoirEnteteVentes.getAvrSource())) {
                        var3 = true;
                        break;
                     }

                     if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.avoirEnteteVentes.getAvrSource() == null || this.avoirEnteteVentes.getAvrSource().isEmpty())) {
                        var3 = true;
                        break;
                     }
                  }
               } else if (this.inpMode == 11) {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdResponsable() == this.avoirEnteteVentes.getAvrIdResponsable()) {
                        if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.avoirEnteteVentes.getAvrSource() != null && !this.avoirEnteteVentes.getAvrSource().isEmpty() && this.documentEntete.getDocSource().equals(this.avoirEnteteVentes.getAvrSource())) {
                           var3 = true;
                           break;
                        }

                        if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.avoirEnteteVentes.getAvrSource() == null || this.avoirEnteteVentes.getAvrSource().isEmpty())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               } else if (this.inpMode != 12) {
                  if (this.inpMode == 13) {
                     for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                        this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                        if (this.documentEntete.getDocIdEquipe() == this.avoirEnteteVentes.getAvrIdEquipe() && this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.avoirEnteteVentes.getAvrSource() != null && !this.avoirEnteteVentes.getAvrSource().isEmpty() && this.documentEntete.getDocSource().equals(this.avoirEnteteVentes.getAvrSource())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               } else {
                  for(var4 = 0; var4 < this.lesAnalyses.size(); ++var4) {
                     this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var4);
                     if (this.documentEntete.getDocIdCommercial() == this.avoirEnteteVentes.getAvrIdCommercial()) {
                        if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty() && this.avoirEnteteVentes.getAvrSource() != null && !this.avoirEnteteVentes.getAvrSource().isEmpty() && this.documentEntete.getDocSource().equals(this.avoirEnteteVentes.getAvrSource())) {
                           var3 = true;
                           break;
                        }

                        if ((this.documentEntete.getDocSource() == null || this.documentEntete.getDocSource().isEmpty()) && (this.avoirEnteteVentes.getAvrSource() == null || this.avoirEnteteVentes.getAvrSource().isEmpty())) {
                           var3 = true;
                           break;
                        }
                     }
                  }
               }
            }

            if (!var3) {
               this.documentEntete = new DocumentEntete();
               this.documentEntete.setDocIdResponsable(this.avoirEnteteVentes.getAvrIdResponsable());
               this.documentEntete.setDocNomResponsable(this.avoirEnteteVentes.getAvrNomResponsable());
               this.documentEntete.setDocIdCommercial(this.avoirEnteteVentes.getAvrIdCommercial());
               this.documentEntete.setDocNomCommercial(this.avoirEnteteVentes.getAvrNomCommercial());
               this.documentEntete.setDocIdEquipe(this.avoirEnteteVentes.getAvrIdEquipe());
               this.documentEntete.setDocNomEquipe(this.avoirEnteteVentes.getAvrNomEquipe());
               this.documentEntete.setDocSource(this.avoirEnteteVentes.getAvrSource());
               this.documentEntete.setDocTotHt(this.avoirEnteteVentes.getAvrTotHt());
               this.documentEntete.setDocTotTva(this.avoirEnteteVentes.getAvrTotTva());
               this.documentEntete.setDocTotTtc(this.avoirEnteteVentes.getAvrTotTtc());
               this.documentEntete.setDocTotReglement(this.avoirEnteteVentes.getAvrTotReglement());
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.documentEntete.setNbrDoc(1);
               if (this.avoirEnteteVentes.getAvrEtat() == 4 || this.avoirEnteteVentes.getAvrEtat() == 5) {
                  this.documentEntete.setNbrTrf(1);
               }

               this.lesAnalyses.add(this.documentEntete);
            } else {
               this.lesAnalyses.remove(this.documentEntete);
               this.documentEntete.setDocIdResponsable(this.avoirEnteteVentes.getAvrIdResponsable());
               this.documentEntete.setDocNomResponsable(this.avoirEnteteVentes.getAvrNomResponsable());
               this.documentEntete.setDocIdCommercial(this.avoirEnteteVentes.getAvrIdCommercial());
               this.documentEntete.setDocNomCommercial(this.avoirEnteteVentes.getAvrNomCommercial());
               this.documentEntete.setDocIdEquipe(this.avoirEnteteVentes.getAvrIdEquipe());
               this.documentEntete.setDocNomEquipe(this.avoirEnteteVentes.getAvrNomEquipe());
               this.documentEntete.setDocSource(this.avoirEnteteVentes.getAvrSource());
               this.documentEntete.setDocTotHt(this.documentEntete.getDocTotHt() + this.avoirEnteteVentes.getAvrTotHt());
               this.documentEntete.setDocTotTva(this.documentEntete.getDocTotTva() + this.avoirEnteteVentes.getAvrTotTva());
               this.documentEntete.setDocTotTtc(this.documentEntete.getDocTotTtc() + this.avoirEnteteVentes.getAvrTotTtc());
               this.documentEntete.setDocTotReglement(this.documentEntete.getDocTotReglement() + this.avoirEnteteVentes.getAvrTotReglement());
               this.documentEntete.setPourcent(0.0F);
               this.documentEntete.setValeurPoint(0.0F);
               this.documentEntete.setNbPoint(0);
               this.documentEntete.setNbrDoc(1 + this.documentEntete.getNbrDoc());
               if (this.avoirEnteteVentes.getAvrEtat() == 4 || this.avoirEnteteVentes.getAvrEtat() == 5) {
                  this.documentEntete.setNbrTrf(1 + this.documentEntete.getNbrTrf());
               }

               this.lesAnalyses.add(this.documentEntete);
            }
         }
      }

   }

   public String calculeLibellePdv(String var1) {
      String var2 = "";
      if (this.mesPdvItems.size() != 0) {
         for(int var3 = 0; var3 < this.mesPdvItems.size(); ++var3) {
            if (((SelectItem)this.mesPdvItems.get(var3)).getValue().toString().startsWith(var1)) {
               var2 = ((SelectItem)this.mesPdvItems.get(var3)).getLabel().toString();
               break;
            }
         }
      } else {
         var2 = var1;
      }

      return var2;
   }

   public void calculTotal() {
      this.montantHt = 0.0D;
      this.montantCommission = 0.0D;
      this.montantReglement = 0.0D;
      this.montantSolde = 0.0D;
      this.var_nb_ligne = 0;
      if (this.lesAnalyses.size() != 0) {
         for(int var1 = 0; var1 < this.lesAnalyses.size(); ++var1) {
            this.montantHt += ((DocumentEntete)this.lesAnalyses.get(var1)).getDocTotHt();
            this.montantCommission += ((DocumentEntete)this.lesAnalyses.get(var1)).getDocTotTtc();
            this.montantReglement += ((DocumentEntete)this.lesAnalyses.get(var1)).getDocTotReglement();
         }

         this.montantSolde = this.montantCommission - this.montantReglement;
         this.var_nb_ligne = this.lesAnalyses.size() + 1;
         LectureSourcesTiers var12 = new LectureSourcesTiers(this.structureLog.getStrid());
         new ArrayList();
         List var2 = var12.getMesSourcesTiers();
         this.documentEntete = new DocumentEntete();

         for(int var3 = 0; var3 < this.lesAnalyses.size(); ++var3) {
            this.documentEntete = (DocumentEntete)this.lesAnalyses.get(var3);
            float var4 = 0.0F;
            if (this.montantCommission != 0.0D) {
               var4 = (float)(this.documentEntete.getDocTotTtc() / this.montantCommission * 100.0D);
            }

            this.documentEntete.setPourcent(var4);
            float var5 = 0.0F;
            if (this.documentEntete.getNbrDoc() != 0) {
               double var6 = (double)this.documentEntete.getNbrTrf();
               double var8 = (double)this.documentEntete.getNbrDoc();
               double var10 = var6 / var8;
               var5 = (float)(var10 * 100.0D);
            }

            this.documentEntete.setValTrf(var5);
            float var13 = 0.0F;
            if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty()) {
               for(int var7 = 0; var7 < var2.size(); ++var7) {
                  if (((ObjetCompte)var2.get(var7)).getNom_FR().equals(this.documentEntete.getDocSource())) {
                     var13 = (float)((ObjetCompte)var2.get(var7)).getCentreId();
                     break;
                  }
               }
            }

            if (var13 == 0.0F) {
               var13 = 1.0F;
            }

            this.documentEntete.setValeurPoint(var13);
            this.documentEntete.setNbPoint((int)(this.documentEntete.getPourcent() * var13));
         }
      }

   }

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "commission" + File.separator;
      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator;
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

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      if (this.listDetailCommission.size() != 0) {
         for(int var2 = 0; var2 < this.listDetailCommission.size(); ++var2) {
            var1.add(this.listDetailCommission.get(var2));
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.commissionEnteteVentes.getComTotCommission(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var1);
      return var3;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommissionEntete");
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
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
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
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "commission" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
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

   public OptionVentes getOptionsVentes() {
      return this.optionsVentes;
   }

   public void setOptionsVentes(OptionVentes var1) {
      this.optionsVentes = var1;
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

   public String getInpCommercial() {
      return this.inpCommercial;
   }

   public void setInpCommercial(String var1) {
      this.inpCommercial = var1;
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

   public boolean isShowModalPanelPayeMultiple() {
      return this.showModalPanelPayeMultiple;
   }

   public void setShowModalPanelPayeMultiple(boolean var1) {
      this.showModalPanelPayeMultiple = var1;
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

   public BonEncaissementVente getBonEncaissementVente() {
      return this.bonEncaissementVente;
   }

   public void setBonEncaissementVente(BonEncaissementVente var1) {
      this.bonEncaissementVente = var1;
   }

   public DataModel getDatamodelPaiement() {
      return this.datamodelPaiement;
   }

   public void setDatamodelPaiement(DataModel var1) {
      this.datamodelPaiement = var1;
   }

   public List getMesModesleRecus() {
      return this.mesModesleRecus;
   }

   public void setMesModesleRecus(List var1) {
      this.mesModesleRecus = var1;
   }

   public boolean isShowModalPanelReglement() {
      return this.showModalPanelReglement;
   }

   public void setShowModalPanelReglement(boolean var1) {
      this.showModalPanelReglement = var1;
   }

   public boolean isVar_affiche_banque() {
      return this.var_affiche_banque;
   }

   public void setVar_affiche_banque(boolean var1) {
      this.var_affiche_banque = var1;
   }

   public String getVar_banque_tireur() {
      return this.var_banque_tireur;
   }

   public void setVar_banque_tireur(String var1) {
      this.var_banque_tireur = var1;
   }

   public double getVar_ecart_reglement() {
      return this.var_ecart_reglement;
   }

   public void setVar_ecart_reglement(double var1) {
      this.var_ecart_reglement = var1;
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

   public String getInpEquipe() {
      return this.inpEquipe;
   }

   public void setInpEquipe(String var1) {
      this.inpEquipe = var1;
   }

   public long getInpIdCommercial() {
      return this.inpIdCommercial;
   }

   public void setInpIdCommercial(long var1) {
      this.inpIdCommercial = var1;
   }

   public long getInpIdEquipe() {
      return this.inpIdEquipe;
   }

   public void setInpIdEquipe(long var1) {
      this.inpIdEquipe = var1;
   }

   public long getInpIdResponsable() {
      return this.inpIdResponsable;
   }

   public void setInpIdResponsable(long var1) {
      this.inpIdResponsable = var1;
   }

   public List getMesCommerciauxItems() {
      return this.mesCommerciauxItems;
   }

   public void setMesCommerciauxItems(List var1) {
      this.mesCommerciauxItems = var1;
   }

   public List getMesEquipesItems() {
      return this.mesEquipesItems;
   }

   public void setMesEquipesItems(List var1) {
      this.mesEquipesItems = var1;
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

   public long getInpConseillers() {
      return this.inpConseillers;
   }

   public void setInpConseillers(long var1) {
      this.inpConseillers = var1;
   }

   public long getInpIdConseillers() {
      return this.inpIdConseillers;
   }

   public void setInpIdConseillers(long var1) {
      this.inpIdConseillers = var1;
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

   public String getInpPdv() {
      return this.inpPdv;
   }

   public void setInpPdv(String var1) {
      this.inpPdv = var1;
   }

   public List getMesPdvItems() {
      return this.mesPdvItems;
   }

   public void setMesPdvItems(List var1) {
      this.mesPdvItems = var1;
   }

   public double getMontantHt() {
      return this.montantHt;
   }

   public void setMontantHt(double var1) {
      this.montantHt = var1;
   }
}
