package com.epegase.forms.ventes;

import com.epegase.forms.administration.FormPlanComptable;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.DevisLigneVentes;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureInterneEnteteVentes;
import com.epegase.systeme.classe.FactureInterneLigneVentes;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.TicketEnteteVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.TransfertVentes;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneLigneVentesDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TicketEnteteVentesDao;
import com.epegase.systeme.dao.TicketLigneVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilExcel;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.LectureFamillesClients;
import com.epegase.systeme.xml.OptionVentes;
import groovyjarjarcommonscli.ParseException;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;

public class FormTransfertVentes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionVentes optionsVentes;
   private ExercicesVentes exercicesVentes;
   private EspionDao espionDao;
   private int var_nb_max;
   private String pageIndex;
   private int nature;
   private FormRecherche formRecherche;
   private JournauxComptables journauxComptables = new JournauxComptables();
   private JournauxComptablesDao journauxComptablesDao;
   private Chrono chrono = new Chrono();
   private ChronoDao chronoDao;
   private Tiers tiers;
   private TiersDao tiersDao;
   private DevisEnteteVentes devisEnteteVentes;
   private DevisEnteteVentesDao devisEnteteVentesDao;
   private DevisLigneVentes devisLigneVentes;
   private DevisLigneVentesDao devisLigneVentesDao;
   private CommandeEnteteVentes commandeEnteteVentes = new CommandeEnteteVentes();
   private CommandeEnteteVentesDao commandeEnteteVentesDao;
   private CommandeLigneVentes commandeLigneVentes = new CommandeLigneVentes();
   private CommandeLigneVentesDao commandeLigneVentesDao;
   private LivraisonEnteteVentes livraisonEnteteVentes;
   private LivraisonEnteteVentesDao livraisonEnteteVentesDao;
   private LivraisonLigneVentes livraisonLigneVentes;
   private LivraisonLigneVentesDao livraisonLigneVentesDao;
   private FactureEnteteVentes factureEnteteVentes = new FactureEnteteVentes();
   private FactureEnteteVentesDao factureEnteteVentesDao;
   private FactureLigneVentes factureLigneVentes = new FactureLigneVentes();
   private FactureLigneVentesDao factureLigneVentesDao;
   private FactureInterneEnteteVentes factureInterneEnteteVentes;
   private FactureInterneEnteteVentesDao factureInterneEnteteVentesDao;
   private FactureInterneLigneVentes factureInterneLigneVentes;
   private FactureInterneLigneVentesDao factureInterneLigneVentesDao;
   private AvoirEnteteVentes avoirEnteteVentes = new AvoirEnteteVentes();
   private AvoirEnteteVentesDao avoirEnteteVentesDao;
   private AvoirLigneVentes avoirLigneVentes = new AvoirLigneVentes();
   private AvoirLigneVentesDao avoirLigneVentesDao;
   private NoteDebitEnteteVentes noteDebitEnteteVentes = new NoteDebitEnteteVentes();
   private NoteDebitEnteteVentesDao noteDebitEnteteVentesDao;
   private NoteDebitLigneVentes noteDebitLigneVentes = new NoteDebitLigneVentes();
   private NoteDebitLigneVentesDao noteDebitLigneVentesDao;
   private TicketEnteteVentesDao ticketEnteteVentesDao;
   private TicketLigneVentesDao ticketLigneVentesDao;
   private TaxesVentes taxesVentes;
   private TaxesVentesDao taxesVentesDao;
   private Date inpDu;
   private Date inpAu;
   private String inpPieceDeb;
   private String inpPieceFin;
   private boolean inpDocNonTrf = false;
   private UtilDate utilDate = new UtilDate();
   private transient DataModel datamodelDocument = new ListDataModel();
   private List listDocument = new ArrayList();
   private boolean var_affiche_bouton = false;
   private int var_choix_importation;
   private boolean importSage;
   private boolean variableExcel;
   private List lesTransfertVentes;
   private TransfertVentes transfertVentes;
   private Chrono chronoTransfert;
   private int balance = 0;
   private int var_currentValue = 0;
   private boolean var_showBarProgMaj = false;
   private String var_info;
   private String messageErreur;
   private List lesErreurs = new ArrayList();
   private String rub01 = "";
   private String rub02 = "";
   private String rub03 = "";
   private String rub04 = "";
   private String rub05 = "";
   private String rub06 = "";
   private String rub07 = "";
   private String rub08 = "";
   private String rub09 = "";
   private String rub10 = "";
   private String rub11 = "";
   private String rub12 = "";
   private String rub13 = "";
   private String rub14 = "";
   private String rub15 = "";
   private String rub16 = "";
   private String rub17 = "";
   private String rub18 = "";
   private String rub19 = "";
   private String rub20 = "";
   private String rub21 = "";
   private String rub22 = "";
   private String rub23 = "";
   private String rub24 = "";
   private String rub25 = "";
   private String rub26 = "";
   private String rub27 = "";
   private String rub28 = "";
   private String rub29 = "";
   private String rub30 = "";
   private String rub31 = "";
   private String rub32 = "";
   private String rub33 = "";
   private String rub34 = "";
   private String rub35 = "";
   private String rub36 = "";
   private String rub37 = "";
   private String rub38 = "";
   private String rub39 = "";
   private String rub40 = "";
   private FamillesProduitsAchats famillesProduitsAchats;
   private FamillesProduitsAchatsDao famillesProduitsAchatsDao;
   private FamillesProduitsVentes famillesProduitsVentes;
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   private DepotAchatsDao depotAchatsDao;
   private DepotAchats depotAchats;
   private UtilNombre utilNombre = new UtilNombre();
   private Produits produits;
   private ProduitsAchsDao produitsAchsDao;
   private ProduitsDepot produitsDepot;
   private ProduitsDepotDao produitsDepotDao;
   private ProduitsTarif produitsTarif;
   private ProduitsTarifDao produitsTarifDao;
   private Baremes baremes;
   private BaremesDao baremesDao;
   private PlansAnalytiques plansAnalytiques;
   private PlansAnalytiquesDao plansAnalytiquesDao;
   private ProduitsFournisseur produitsFournisseur;
   private ProduitsFournisseurDao produitsFournisseurDao;
   private transient DataModel dataModelChampProduit = new ListDataModel();
   private transient DataModel dataModelChampProduitDepot = new ListDataModel();
   private transient DataModel dataModelChampProduitTarif = new ListDataModel();
   private transient DataModel dataModelChampBareme = new ListDataModel();
   private List mesFamillesClientsItems = new ArrayList();
   private UtilTdt utilTdt = new UtilTdt();
   private int choixRacine;
   private String selecFiscalite;

   public void InstancesDaoUtilses() {
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.commandeEnteteVentesDao = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.commandeLigneVentesDao = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.livraisonEnteteVentesDao = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.livraisonLigneVentesDao = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureLigneVentesDao = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.avoirEnteteVentesDao = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.avoirLigneVentesDao = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteVentesDao = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitLigneVentesDao = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureInterneEnteteVentesDao = new FactureInterneEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureInterneLigneVentesDao = new FactureInterneLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.ticketEnteteVentesDao = new TicketEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.ticketLigneVentesDao = new TicketLigneVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void init() throws HibernateException, NamingException {
      if (this.optionsVentes.getNbLigneMax() != null && !this.optionsVentes.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionsVentes.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && (this.choixRacine == 2 || this.choixRacine == 0)) {
         this.choixRacine = 1;
         this.selecFiscalite = this.structureLog.getStrzonefiscale();
      } else if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && this.choixRacine == 1) {
         this.choixRacine = 2;
         this.selecFiscalite = this.structureLog.getStrzonefiscale2();
      } else {
         this.choixRacine = 0;
         this.selecFiscalite = this.structureLog.getStrzonefiscale();
      }

   }

   public void initImportation() throws HibernateException, NamingException {
      this.dataModelChampProduit.setWrappedData(this.utilTdt.rubriqueProduits(this.utilInitHibernate, this.baseLog));
      this.dataModelChampProduitDepot.setWrappedData(this.utilTdt.rubriqueProduitsDepots(this.utilInitHibernate, this.baseLog));
      this.dataModelChampProduitTarif.setWrappedData(this.utilTdt.rubriqueProduitsTarifs(this.utilInitHibernate, this.baseLog));
      this.dataModelChampBareme.setWrappedData(this.utilTdt.rubriqueBaremes(this.utilInitHibernate, this.baseLog));
   }

   public void executerRequete() throws HibernateException, NamingException, IOException {
      this.listDocument.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      String var2 = "";
      String var3 = "";
      if (this.inpDu != null && this.inpAu != null) {
         var2 = this.utilDate.dateToStringSQLLight(this.inpDu);
         var3 = this.utilDate.dateToStringSQLLight(this.inpAu);
         var2 = var2 + " 00:00:00";
         var3 = var3 + " 23:59:59";
      }

      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      boolean var9 = false;
      boolean var10 = false;
      new ArrayList();
      List var11 = this.chronoDao.selectListVente(1, var1);
      if (var11.size() != 0) {
         for(int var12 = 0; var12 < var11.size(); ++var12) {
            if (((Chrono)var11.get(var12)).getChrNature() == 22 && ((Chrono)var11.get(var12)).getChrJournal() != null && !((Chrono)var11.get(var12)).getChrJournal().isEmpty()) {
               var4 = true;
            } else if (((Chrono)var11.get(var12)).getChrNature() == 23 && ((Chrono)var11.get(var12)).getChrJournal() != null && !((Chrono)var11.get(var12)).getChrJournal().isEmpty()) {
               var5 = true;
            } else if (((Chrono)var11.get(var12)).getChrNature() == 25 && ((Chrono)var11.get(var12)).getChrJournal() != null && !((Chrono)var11.get(var12)).getChrJournal().isEmpty()) {
               var6 = true;
            } else if (((Chrono)var11.get(var12)).getChrNature() == 26 && ((Chrono)var11.get(var12)).getChrJournal() != null && !((Chrono)var11.get(var12)).getChrJournal().isEmpty()) {
               var7 = true;
            } else if (((Chrono)var11.get(var12)).getChrNature() == 27 && ((Chrono)var11.get(var12)).getChrJournal() != null && !((Chrono)var11.get(var12)).getChrJournal().isEmpty()) {
               var8 = true;
            } else if (((Chrono)var11.get(var12)).getChrNature() == 142 && ((Chrono)var11.get(var12)).getChrJournal() != null && !((Chrono)var11.get(var12)).getChrJournal().isEmpty()) {
               var9 = true;
            } else if (((Chrono)var11.get(var12)).getChrNature() == 6 && ((Chrono)var11.get(var12)).getChrJournal() != null && !((Chrono)var11.get(var12)).getChrJournal().isEmpty()) {
               var10 = true;
            }
         }
      }

      int var13;
      DocumentEntete var14;
      List var15;
      if (var4) {
         new ArrayList();
         var15 = this.commandeEnteteVentesDao.rechercheCommandeATransfererCompta(this.optionsVentes.getTransfertDocument(), this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
         if (var15.size() != 0) {
            for(var13 = 0; var13 < var15.size(); ++var13) {
               var14 = new DocumentEntete();
               var14.setDocNature(22);
               var14.setDocId(((CommandeEnteteVentes)var15.get(var13)).getBcmId());
               var14.setDocDate(((CommandeEnteteVentes)var15.get(var13)).getBcmDate());
               var14.setDocNum(((CommandeEnteteVentes)var15.get(var13)).getBcmNum());
               var14.setDocSerie(((CommandeEnteteVentes)var15.get(var13)).getBcmSerie());
               if (((CommandeEnteteVentes)var15.get(var13)).getBcmDiversTiers() == 99) {
                  var14.setDocNomTiers(((CommandeEnteteVentes)var15.get(var13)).getBcmDiversNom());
               } else {
                  var14.setDocNomTiers(((CommandeEnteteVentes)var15.get(var13)).getBcmNomTiers());
               }

               var14.setDocTotHt(((CommandeEnteteVentes)var15.get(var13)).getBcmTotHt());
               var14.setDocTotTva(((CommandeEnteteVentes)var15.get(var13)).getBcmTotTva());
               var14.setDocTotTc(((CommandeEnteteVentes)var15.get(var13)).getBcmTotTc());
               var14.setDocTotTtc(((CommandeEnteteVentes)var15.get(var13)).getBcmTotTtc());
               var14.setNumComptetier(((CommandeEnteteVentes)var15.get(var13)).getTiers().getTiecompte0());
               var14.setDocIdCommercial(((CommandeEnteteVentes)var15.get(var13)).getTiers().getTieid());
               var14.setDocNomTiers(((CommandeEnteteVentes)var15.get(var13)).getTiers().getTieraisonsocialenom());
               var14.setDocSelect(true);
               this.listDocument.add(var14);
            }
         }
      }

      if (var5) {
         new ArrayList();
         var15 = this.livraisonEnteteVentesDao.rechercheLivraisonATransfererCompta(this.optionsVentes.getTransfertDocument(), this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
         if (var15.size() != 0) {
            for(var13 = 0; var13 < var15.size(); ++var13) {
               var14 = new DocumentEntete();
               var14.setDocNature(23);
               var14.setDocId(((LivraisonEnteteVentes)var15.get(var13)).getBlvId());
               var14.setDocDate(((LivraisonEnteteVentes)var15.get(var13)).getBlvDate());
               var14.setDocNum(((LivraisonEnteteVentes)var15.get(var13)).getBlvNum());
               var14.setDocSerie(((LivraisonEnteteVentes)var15.get(var13)).getBlvSerie());
               if (((LivraisonEnteteVentes)var15.get(var13)).getBlvDiversTiers() == 99) {
                  var14.setDocNomTiers(((LivraisonEnteteVentes)var15.get(var13)).getBlvDiversNom());
               } else {
                  var14.setDocNomTiers(((LivraisonEnteteVentes)var15.get(var13)).getBlvNomTiers());
               }

               var14.setDocTotHt(((LivraisonEnteteVentes)var15.get(var13)).getBlvTotHt());
               var14.setDocTotTva(((LivraisonEnteteVentes)var15.get(var13)).getBlvTotTva());
               var14.setDocTotTc(((LivraisonEnteteVentes)var15.get(var13)).getBlvTotTc());
               var14.setDocTotTtc(((LivraisonEnteteVentes)var15.get(var13)).getBlvTotTtc());
               var14.setNumComptetier(((LivraisonEnteteVentes)var15.get(var13)).getTiers().getTiecompte0());
               var14.setDocIdCommercial(((LivraisonEnteteVentes)var15.get(var13)).getTiers().getTieid());
               var14.setDocNomTiers(((LivraisonEnteteVentes)var15.get(var13)).getTiers().getTieraisonsocialenom());
               var14.setDocSelect(true);
               this.listDocument.add(var14);
            }
         }
      }

      if (var6) {
         new ArrayList();
         var15 = this.factureEnteteVentesDao.rechercheFactureATransfererCompta(this.optionsVentes.getTransfertDocument(), this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
         if (var15.size() != 0) {
            for(var13 = 0; var13 < var15.size(); ++var13) {
               if (((FactureEnteteVentes)var15.get(var13)).getFacEtat() != 8) {
                  var14 = new DocumentEntete();
                  var14.setDocNature(25);
                  var14.setDocId(((FactureEnteteVentes)var15.get(var13)).getFacId());
                  var14.setDocDate(((FactureEnteteVentes)var15.get(var13)).getFacDate());
                  var14.setDocNum(((FactureEnteteVentes)var15.get(var13)).getFacNum());
                  var14.setDocSerie(((FactureEnteteVentes)var15.get(var13)).getFacSerie());
                  if (((FactureEnteteVentes)var15.get(var13)).getFacDiversTiers() == 99) {
                     var14.setDocNomTiers(((FactureEnteteVentes)var15.get(var13)).getFacDiversNom());
                  } else {
                     var14.setDocNomTiers(((FactureEnteteVentes)var15.get(var13)).getFacNomTiers());
                  }

                  var14.setDocTotHt(((FactureEnteteVentes)var15.get(var13)).getFacTotHt());
                  var14.setDocTotTva(((FactureEnteteVentes)var15.get(var13)).getFacTotTva());
                  var14.setDocTotTc(((FactureEnteteVentes)var15.get(var13)).getFacTotTc());
                  var14.setDocTotTtc(((FactureEnteteVentes)var15.get(var13)).getFacTotTtc());
                  var14.setNumComptetier(((FactureEnteteVentes)var15.get(var13)).getTiers().getTiecompte0());
                  var14.setDocIdCommercial(((FactureEnteteVentes)var15.get(var13)).getTiers().getTieid());
                  var14.setDocNomTiers(((FactureEnteteVentes)var15.get(var13)).getTiers().getTieraisonsocialenom());
                  var14.setDocSelect(true);
                  this.listDocument.add(var14);
               }
            }
         }
      }

      if (var7) {
         new ArrayList();
         var15 = this.avoirEnteteVentesDao.rechercheAvoirATransfererCompta(this.optionsVentes.getTransfertDocument(), this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
         if (var15.size() != 0) {
            for(var13 = 0; var13 < var15.size(); ++var13) {
               var14 = new DocumentEntete();
               var14.setDocNature(26);
               var14.setDocId(((AvoirEnteteVentes)var15.get(var13)).getAvrId());
               var14.setDocDate(((AvoirEnteteVentes)var15.get(var13)).getAvrDate());
               var14.setDocNum(((AvoirEnteteVentes)var15.get(var13)).getAvrNum());
               var14.setDocSerie(((AvoirEnteteVentes)var15.get(var13)).getAvrSerie());
               if (((AvoirEnteteVentes)var15.get(var13)).getAvrDiversTiers() == 99) {
                  var14.setDocNomTiers(((AvoirEnteteVentes)var15.get(var13)).getAvrDiversNom());
               } else {
                  var14.setDocNomTiers(((AvoirEnteteVentes)var15.get(var13)).getAvrNomTiers());
               }

               var14.setDocTotHt(((AvoirEnteteVentes)var15.get(var13)).getAvrTotHt() * -1.0D);
               var14.setDocTotTva(((AvoirEnteteVentes)var15.get(var13)).getAvrTotTva() * -1.0D);
               var14.setDocTotTc(((AvoirEnteteVentes)var15.get(var13)).getAvrTotTc() * -1.0D);
               var14.setDocTotTtc(((AvoirEnteteVentes)var15.get(var13)).getAvrTotTtc() * -1.0D);
               var14.setNumComptetier(((AvoirEnteteVentes)var15.get(var13)).getTiers().getTiecompte0());
               var14.setDocIdCommercial(((AvoirEnteteVentes)var15.get(var13)).getTiers().getTieid());
               var14.setDocNomTiers(((AvoirEnteteVentes)var15.get(var13)).getTiers().getTieraisonsocialenom());
               var14.setDocSelect(true);
               this.listDocument.add(var14);
            }
         }
      }

      if (var8) {
         new ArrayList();
         var15 = this.noteDebitEnteteVentesDao.rechercheNoteDebitATransfererCompta(this.optionsVentes.getTransfertDocument(), this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
         if (var15.size() != 0) {
            for(var13 = 0; var13 < var15.size(); ++var13) {
               var14 = new DocumentEntete();
               var14.setDocNature(27);
               var14.setDocId(((NoteDebitEnteteVentes)var15.get(var13)).getNdbId());
               var14.setDocDate(((NoteDebitEnteteVentes)var15.get(var13)).getNdbDate());
               var14.setDocNum(((NoteDebitEnteteVentes)var15.get(var13)).getNdbNum());
               var14.setDocSerie(((NoteDebitEnteteVentes)var15.get(var13)).getNdbSerie());
               if (((NoteDebitEnteteVentes)var15.get(var13)).getNdbDiversTiers() == 99) {
                  var14.setDocNomTiers(((NoteDebitEnteteVentes)var15.get(var13)).getNdbDiversNom());
               } else {
                  var14.setDocNomTiers(((NoteDebitEnteteVentes)var15.get(var13)).getNdbNomTiers());
               }

               var14.setDocTotHt(((NoteDebitEnteteVentes)var15.get(var13)).getNdbTotHt());
               var14.setDocTotTva(((NoteDebitEnteteVentes)var15.get(var13)).getNdbTotTva());
               var14.setDocTotTc(((NoteDebitEnteteVentes)var15.get(var13)).getNdbTotTc());
               var14.setDocTotTtc(((NoteDebitEnteteVentes)var15.get(var13)).getNdbTotTtc());
               var14.setNumComptetier(((NoteDebitEnteteVentes)var15.get(var13)).getTiers().getTiecompte0());
               var14.setDocIdCommercial(((NoteDebitEnteteVentes)var15.get(var13)).getTiers().getTieid());
               var14.setDocNomTiers(((NoteDebitEnteteVentes)var15.get(var13)).getTiers().getTieraisonsocialenom());
               var14.setDocSelect(true);
               this.listDocument.add(var14);
            }
         }
      }

      if (var9) {
         new ArrayList();
         var15 = this.factureInterneEnteteVentesDao.rechercheFactureInterneATransfererCompta(this.optionsVentes.getTransfertDocument(), this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
         if (var15.size() != 0) {
            for(var13 = 0; var13 < var15.size(); ++var13) {
               var14 = new DocumentEntete();
               var14.setDocNature(142);
               var14.setDocId(((FactureInterneEnteteVentes)var15.get(var13)).getFitId());
               var14.setDocDate(((FactureInterneEnteteVentes)var15.get(var13)).getFitDate());
               var14.setDocNum(((FactureInterneEnteteVentes)var15.get(var13)).getFitNum());
               var14.setDocSerie(((FactureInterneEnteteVentes)var15.get(var13)).getFitSerie());
               if (((FactureInterneEnteteVentes)var15.get(var13)).getFitDiversTiers() == 99) {
                  var14.setDocNomTiers(((FactureInterneEnteteVentes)var15.get(var13)).getFitDiversNom());
               } else {
                  var14.setDocNomTiers(((FactureInterneEnteteVentes)var15.get(var13)).getFitNomTiers());
               }

               var14.setDocTotHt(((FactureInterneEnteteVentes)var15.get(var13)).getFitTotHt());
               var14.setDocTotTva(((FactureInterneEnteteVentes)var15.get(var13)).getFitTotTva());
               var14.setDocTotTc(((FactureInterneEnteteVentes)var15.get(var13)).getFitTotTc());
               var14.setDocTotTtc(((FactureInterneEnteteVentes)var15.get(var13)).getFitTotTtc());
               var14.setNumComptetier(((FactureInterneEnteteVentes)var15.get(var13)).getTiers().getTiecompte0());
               var14.setDocIdCommercial(((FactureInterneEnteteVentes)var15.get(var13)).getTiers().getTieid());
               var14.setDocNomTiers(((FactureInterneEnteteVentes)var15.get(var13)).getTiers().getTieraisonsocialenom());
               var14.setDocSelect(true);
               this.listDocument.add(var14);
            }
         }
      }

      if (var10) {
         new ArrayList();
         var15 = this.ticketEnteteVentesDao.rechercheTicketATransfererCompta(this.optionsVentes.getTransfertDocument(), this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
         if (var15.size() != 0) {
            for(var13 = 0; var13 < var15.size(); ++var13) {
               if (((TicketEnteteVentes)var15.get(var13)).getTicEtat() != 8) {
                  var14 = new DocumentEntete();
                  var14.setDocNature(6);
                  var14.setDocId(((TicketEnteteVentes)var15.get(var13)).getTicId());
                  var14.setDocDate(((TicketEnteteVentes)var15.get(var13)).getTicDate());
                  var14.setDocNum(((TicketEnteteVentes)var15.get(var13)).getTicNum());
                  var14.setDocSerie("");
                  var14.setDocNomTiers(((TicketEnteteVentes)var15.get(var13)).getTicNomTiers());
                  var14.setDocTotHt(((TicketEnteteVentes)var15.get(var13)).getTicTotalHt());
                  var14.setDocTotTva(((TicketEnteteVentes)var15.get(var13)).getTicTotalTva());
                  var14.setDocTotTc(((TicketEnteteVentes)var15.get(var13)).getTicTotalTc());
                  var14.setDocTotTtc(((TicketEnteteVentes)var15.get(var13)).getTicTotalTtc());
                  var14.setNumComptetier(((TicketEnteteVentes)var15.get(var13)).getTiers().getTiecompte0());
                  var14.setDocIdCommercial(((TicketEnteteVentes)var15.get(var13)).getTiers().getTieid());
                  var14.setDocNomTiers(((TicketEnteteVentes)var15.get(var13)).getTiers().getTieraisonsocialenom());
                  var14.setDocSelect(true);
                  this.listDocument.add(var14);
               }
            }
         }
      }

      this.utilInitHibernate.closeSession();
      this.verificationCompte();
      this.datamodelDocument.setWrappedData(this.listDocument);
      if (this.listDocument.size() != 0) {
         this.var_affiche_bouton = true;
      } else {
         this.var_affiche_bouton = false;
      }

   }

   public void verificationCompte() throws HibernateException, NamingException, IOException {
      if (this.listDocument.size() != 0) {
         FormPlanComptable var1 = new FormPlanComptable();
         var1.setStructureLog(this.structureLog);
         var1.setBaseLog(this.baseLog);
         var1.setUsersLog(this.usersLog);
         var1.InstancesDaoUtilses();
         new DocumentEntete();
         new DocumentEntete();
         new PlanComptable();
         this.tiers = new Tiers();
         this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
         Transaction var6 = null;

         try {
            var6 = var5.beginTransaction();

            for(int var7 = 0; var7 < this.listDocument.size(); ++var7) {
               DocumentEntete var2 = (DocumentEntete)this.listDocument.get(var7);
               boolean var8 = false;
               if (var2.getNumComptetier() != null && !var2.getNumComptetier().isEmpty()) {
                  if (var2.getNumComptetier().contains("XXXX")) {
                     var8 = true;
                  }
               } else {
                  var8 = true;
               }

               if (var8) {
                  PlanComptable var4 = var1.creationAuto(this.selecFiscalite, "41110", var2.getDocNomTiers(), var5);
                  if (var4 != null) {
                     var2.setNumComptetier(var4.getPlcCompte());
                     this.tiers = this.tiersDao.selectTierD(var2.getDocIdCommercial(), var5);
                     if (this.tiers != null) {
                        this.tiers.setTiecompte0(var4.getPlcCompte());
                        this.tiersDao.modif(this.tiers, var5);

                        for(int var9 = var7; var9 < this.listDocument.size(); ++var9) {
                           DocumentEntete var3 = (DocumentEntete)this.listDocument.get(var9);
                           if (var2.getDocIdCommercial() == var3.getDocIdCommercial()) {
                              var3.setNumComptetier(var4.getPlcCompte());
                           }
                        }
                     }
                  }
               }
            }

            var6.commit();
         } catch (HibernateException var13) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var13;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void selectionLigne() {
      if (this.datamodelDocument.isRowAvailable()) {
      }

   }

   public void selectionAll() {
      if (this.listDocument.size() != 0) {
         for(int var1 = 0; var1 < this.listDocument.size(); ++var1) {
            new DocumentEntete();
            DocumentEntete var2 = (DocumentEntete)this.listDocument.get(var1);
            var2.setDocSelect(true);
         }

         this.datamodelDocument.setWrappedData(this.listDocument);
      }

   }

   public void deSelectionAll() {
      if (this.listDocument.size() != 0) {
         for(int var1 = 0; var1 < this.listDocument.size(); ++var1) {
            new DocumentEntete();
            DocumentEntete var2 = (DocumentEntete)this.listDocument.get(var1);
            var2.setDocSelect(false);
         }

         this.datamodelDocument.setWrappedData(this.listDocument);
      }

   }

   public void transfertImport(List var1) throws HibernateException, NamingException, ParseException, java.text.ParseException {
      boolean var2 = false;
      this.importSage = false;
      this.variableExcel = false;
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.lesTransfertVentes = new ArrayList();
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            String var4 = (String)var1.get(var3);
            if (var4.toString().contains(".xls:") || var4.toString().contains(".xlsx:") || var4.toString().contains(".XLS:") || var4.toString().contains(".XLSX:")) {
               this.variableExcel = true;
               String[] var8 = var4.split(":");
               this.importExcel(var8[1]);
               break;
            }

            if (var4 != null && !var4.isEmpty() && var4.startsWith("#FLG")) {
               this.importSage = true;
            }

            boolean var5 = false;
            String[] var6 = null;
            if (!this.variableExcel && var4 != null && !var4.isEmpty() && var4.contains(",")) {
               var6 = var4.split(",");
               int var7 = var6.length;
            } else {
               var5 = true;
            }
         }
      }

   }

   public void importExcel(String var1) throws HibernateException, NamingException {
      byte var2 = 0;
      UtilExcel var3 = new UtilExcel();
      File var4 = new File(var1);
      new ArrayList();
      List var5 = var3.lectureFichierVentes(var4);
      if (var5.size() != 0) {
         for(int var6 = 0; var6 < var5.size(); ++var6) {
            this.transfertVentes = (TransfertVentes)var5.get(var6);
            if ((this.transfertVentes.getTrfPeriode() == null || this.transfertVentes.getTrfPeriode().isEmpty()) && this.transfertVentes.getTrfColT00() != null && !this.transfertVentes.getTrfColT00().isEmpty() && !this.transfertVentes.getTrfColT00().equals("0")) {
               var2 = 6;
               this.lesTransfertVentes.add(this.transfertVentes);
            }
         }
      }

      this.datamodelDocument.setWrappedData(this.lesTransfertVentes);
      if (var2 == 6) {
         this.balance = 6;
      }

      this.var_affiche_bouton = true;
   }

   public double conversionTN(String var1) {
      double var2 = 0.0D;
      if (var1 != null && !var1.isEmpty()) {
         boolean var4 = false;
         String var5 = "";
         if (",".contains(var1)) {
            var1 = var1.replace(",", ".");
         } else if ("%".contains(var1)) {
            var1 = var1.replace("%", "");
         }

         for(int var6 = 0; var6 < var1.length(); ++var6) {
            var5 = (String)var1.subSequence(var6, var6 + 1);
            if (!"0123456789.".contains(var5)) {
               var4 = true;
               break;
            }
         }

         if (!var4) {
            var2 = Double.parseDouble(var1);
         }
      }

      return var2;
   }

   public String testImportLibre() {
      String var1 = "";
      if (this.lesTransfertVentes.size() != 0) {
         this.transfertVentes = (TransfertVentes)this.lesTransfertVentes.get(0);
         if (!this.transfertVentes.getTrfColT00().startsWith("produit") && !this.transfertVentes.getTrfColT00().startsWith("pro_") && !this.transfertVentes.getTrfColT00().startsWith("protar_") && !this.transfertVentes.getTrfColT00().startsWith("prodep_") && !this.transfertVentes.getTrfColT00().startsWith("profou_") && !this.transfertVentes.getTrfColT00().startsWith("bar_")) {
            if (!this.transfertVentes.getTrfColT00().startsWith("dvs_") && !this.transfertVentes.getTrfColT00().startsWith("dvslig_")) {
               if (!this.transfertVentes.getTrfColT00().startsWith("bcm_") && !this.transfertVentes.getTrfColT00().startsWith("bcmlig_")) {
                  if (!this.transfertVentes.getTrfColT00().startsWith("blv_") && !this.transfertVentes.getTrfColT00().startsWith("blvlig_")) {
                     if (!this.transfertVentes.getTrfColT00().startsWith("brt_") && !this.transfertVentes.getTrfColT00().startsWith("brtlig_")) {
                        if (!this.transfertVentes.getTrfColT00().startsWith("fac_") && !this.transfertVentes.getTrfColT00().startsWith("faclig_")) {
                           if (!this.transfertVentes.getTrfColT00().startsWith("fit_") && !this.transfertVentes.getTrfColT00().startsWith("fitlig_")) {
                              if (!this.transfertVentes.getTrfColT00().startsWith("ndb_") && !this.transfertVentes.getTrfColT00().startsWith("ndblig_")) {
                                 if (this.transfertVentes.getTrfColT00().startsWith("avr_") || this.transfertVentes.getTrfColT00().startsWith("avrlig_")) {
                                    var1 = "AVOIRS";
                                 }
                              } else {
                                 var1 = "NOTESDEDEBIT";
                              }
                           } else {
                              var1 = "FACTURESINTERNES";
                           }
                        } else {
                           var1 = "FACTURES";
                        }
                     } else {
                        var1 = "RETOURS";
                     }
                  } else {
                     var1 = "LIVRAISONS";
                  }
               } else {
                  var1 = "COMMANDES";
               }
            } else {
               var1 = "DEVIS";
            }
         } else {
            var1 = "PRODUITS";
         }
      } else {
         var1 = "VIDE";
      }

      return var1;
   }

   public void importProduitLibre() throws HibernateException, NamingException, java.text.ParseException, JDOMException, IOException {
      this.lesErreurs.clear();
      if (this.lesTransfertVentes.size() != 0) {
         this.var_showBarProgMaj = true;
         this.var_currentValue = 0;
         this.var_info = "Chargement des elements de base...";
         boolean var1 = false;
         this.depotAchatsDao = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         this.depotAchats = new DepotAchats();
         this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
         this.famillesProduitsAchats = new FamillesProduitsAchats();
         this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
         this.famillesProduitsVentes = new FamillesProduitsVentes();
         this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         this.produits = new Produits();
         this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
         this.produitsDepot = new ProduitsDepot();
         this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
         this.produitsTarif = new ProduitsTarif();
         this.baremesDao = new BaremesDao(this.baseLog, this.utilInitHibernate);
         this.baremes = new Baremes();
         this.produitsFournisseur = new ProduitsFournisseur();
         this.produitsFournisseurDao = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
         this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
         this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.plansAnalytiques = new PlansAnalytiques();
         LectureFamillesClients var2 = new LectureFamillesClients();
         var2.setStrId(this.structureLog.getStrid());
         var2.setStructureLog(this.structureLog);
         this.mesFamillesClientsItems = var2.chargerMesFamillesClientItems();
         String var3 = "";
         String var4 = "";
         String var5 = "";
         String var6 = "";
         String var7 = "";
         String var8 = "";
         String var9 = "";
         String var10 = "";
         String var11 = "";
         String var12 = "";
         String var13 = "";
         String var14 = "";
         String var15 = "";
         String var16 = "";
         String var17 = "";
         String var18 = "";
         String var19 = "";
         String var20 = "";
         String var21 = "";
         String var22 = "";
         String var23 = "";
         String var24 = "";
         String var25 = "";
         String var26 = "";
         String var27 = "";
         String var28 = "";
         String var29 = "";
         String var30 = "";
         String var31 = "";
         String var32 = "";
         String var33 = "";
         String var34 = "";
         String var35 = "";
         String var36 = "";
         String var37 = "";
         String var38 = "";
         String var39 = "";
         String var40 = "";
         String var41 = "";
         String var42 = "";
         String var43 = "";
         String var44 = "";
         String var45 = "";
         Session var46 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         Transaction var47 = null;

         try {
            var47 = var46.beginTransaction();
            var46.setFlushMode(FlushMode.MANUAL);

            for(int var48 = 0; var48 < this.lesTransfertVentes.size(); ++var48) {
               this.transfertVentes = (TransfertVentes)this.lesTransfertVentes.get(var48);
               this.var_info = "Element " + var48 + " - Nb elements : " + this.lesTransfertVentes.size();
               if (var48 != 0) {
                  double var49 = (double)this.lesTransfertVentes.size();
                  double var51 = this.utilNombre.myRound(var49 / (double)var48, 4);
                  double var53 = this.utilNombre.myRound(100.0D / var51, 2);
                  this.var_currentValue = (int)var53;
               }

               if (var48 == 0) {
                  var5 = this.transfertVentes.getTrfColT00();
                  var6 = this.transfertVentes.getTrfColT01();
                  var7 = this.transfertVentes.getTrfColT02();
                  var8 = this.transfertVentes.getTrfColT03();
                  var9 = this.transfertVentes.getTrfColT04();
                  var10 = this.transfertVentes.getTrfColT05();
                  var11 = this.transfertVentes.getTrfColT06();
                  var12 = this.transfertVentes.getTrfColT07();
                  var13 = this.transfertVentes.getTrfColT08();
                  var14 = this.transfertVentes.getTrfColT09();
                  var15 = this.transfertVentes.getTrfColT10();
                  var16 = this.transfertVentes.getTrfColT11();
                  var17 = this.transfertVentes.getTrfColT12();
                  var18 = this.transfertVentes.getTrfColT13();
                  var19 = this.transfertVentes.getTrfColT14();
                  var20 = this.transfertVentes.getTrfColT15();
                  var21 = this.transfertVentes.getTrfColT16();
                  var22 = this.transfertVentes.getTrfColT17();
                  var23 = this.transfertVentes.getTrfColT18();
                  var24 = this.transfertVentes.getTrfColT19();
                  var25 = this.transfertVentes.getTrfColT20();
                  var26 = this.transfertVentes.getTrfColT21();
                  var27 = this.transfertVentes.getTrfColT22();
                  var28 = this.transfertVentes.getTrfColT23();
                  var29 = this.transfertVentes.getTrfColT24();
                  var30 = this.transfertVentes.getTrfColT25();
                  var31 = this.transfertVentes.getTrfColT26();
                  var32 = this.transfertVentes.getTrfColT27();
                  var33 = this.transfertVentes.getTrfColT28();
                  var34 = this.transfertVentes.getTrfColT29();
                  var35 = this.transfertVentes.getTrfColT30();
                  var36 = this.transfertVentes.getTrfColT31();
                  var37 = this.transfertVentes.getTrfColT32();
                  var38 = this.transfertVentes.getTrfColT33();
                  var39 = this.transfertVentes.getTrfColT34();
                  var40 = this.transfertVentes.getTrfColT35();
                  var41 = this.transfertVentes.getTrfColT36();
                  var42 = this.transfertVentes.getTrfColT37();
                  var43 = this.transfertVentes.getTrfColT38();
                  var44 = this.transfertVentes.getTrfColT39();
                  var45 = this.transfertVentes.getTrfColT40();
               } else {
                  boolean var60 = false;
                  if (var5.contains("ana_code_complet")) {
                     var60 = this.recherhceAnalytique(this.transfertVentes.getTrfColT00(), var46);
                     this.produits = null;
                  } else {
                     var60 = this.recherhceProduit(this.transfertVentes.getTrfColT00(), this.transfertVentes.getTrfColT01(), var46);
                     this.plansAnalytiques = null;
                  }

                  String var50;
                  if (this.produits == null) {
                     if (this.plansAnalytiques != null && var5.contains("ana_code_complet")) {
                        if (var6 != null && !var6.isEmpty()) {
                           this.calculeRubPlanAnalytique(var6, this.transfertVentes.getTrfColT01(), var46);
                        }

                        if (var7 != null && !var7.isEmpty()) {
                           this.calculeRubPlanAnalytique(var7, this.transfertVentes.getTrfColT02(), var46);
                        }

                        if (var8 != null && !var8.isEmpty()) {
                           this.calculeRubPlanAnalytique(var8, this.transfertVentes.getTrfColT03(), var46);
                        }

                        if (var9 != null && !var9.isEmpty()) {
                           this.calculeRubPlanAnalytique(var9, this.transfertVentes.getTrfColT04(), var46);
                        }

                        if (var10 != null && !var10.isEmpty()) {
                           this.calculeRubPlanAnalytique(var10, this.transfertVentes.getTrfColT05(), var46);
                        }

                        if (var11 != null && !var11.isEmpty()) {
                           this.calculeRubPlanAnalytique(var11, this.transfertVentes.getTrfColT06(), var46);
                        }

                        if (var12 != null && !var12.isEmpty()) {
                           this.calculeRubPlanAnalytique(var12, this.transfertVentes.getTrfColT07(), var46);
                        }

                        if (var13 != null && !var13.isEmpty()) {
                           this.calculeRubPlanAnalytique(var13, this.transfertVentes.getTrfColT08(), var46);
                        }

                        if (var14 != null && !var14.isEmpty()) {
                           this.calculeRubPlanAnalytique(var14, this.transfertVentes.getTrfColT09(), var46);
                        }

                        if (var15 != null && !var15.isEmpty()) {
                           this.calculeRubPlanAnalytique(var15, this.transfertVentes.getTrfColT10(), var46);
                        }

                        if (var16 != null && !var16.isEmpty()) {
                           this.calculeRubPlanAnalytique(var16, this.transfertVentes.getTrfColT11(), var46);
                        }

                        if (var17 != null && !var17.isEmpty()) {
                           this.calculeRubPlanAnalytique(var17, this.transfertVentes.getTrfColT12(), var46);
                        }

                        if (var18 != null && !var18.isEmpty()) {
                           this.calculeRubPlanAnalytique(var18, this.transfertVentes.getTrfColT13(), var46);
                        }

                        if (var19 != null && !var19.isEmpty()) {
                           this.calculeRubPlanAnalytique(var19, this.transfertVentes.getTrfColT14(), var46);
                        }

                        if (var20 != null && !var20.isEmpty()) {
                           this.calculeRubPlanAnalytique(var20, this.transfertVentes.getTrfColT15(), var46);
                        }

                        if (var21 != null && !var21.isEmpty()) {
                           this.calculeRubPlanAnalytique(var21, this.transfertVentes.getTrfColT16(), var46);
                        }

                        if (var22 != null && !var22.isEmpty()) {
                           this.calculeRubPlanAnalytique(var22, this.transfertVentes.getTrfColT17(), var46);
                        }

                        if (var23 != null && !var23.isEmpty()) {
                           this.calculeRubPlanAnalytique(var23, this.transfertVentes.getTrfColT18(), var46);
                        }

                        if (var24 != null && !var24.isEmpty()) {
                           this.calculeRubPlanAnalytique(var24, this.transfertVentes.getTrfColT19(), var46);
                        }

                        if (var25 != null && !var25.isEmpty()) {
                           this.calculeRubPlanAnalytique(var25, this.transfertVentes.getTrfColT20(), var46);
                        }

                        if (var26 != null && !var26.isEmpty()) {
                           this.calculeRubPlanAnalytique(var26, this.transfertVentes.getTrfColT21(), var46);
                        }

                        if (var27 != null && !var27.isEmpty()) {
                           this.calculeRubPlanAnalytique(var27, this.transfertVentes.getTrfColT22(), var46);
                        }

                        if (var28 != null && !var28.isEmpty()) {
                           this.calculeRubPlanAnalytique(var28, this.transfertVentes.getTrfColT23(), var46);
                        }

                        if (var29 != null && !var29.isEmpty()) {
                           this.calculeRubPlanAnalytique(var29, this.transfertVentes.getTrfColT24(), var46);
                        }

                        if (var30 != null && !var30.isEmpty()) {
                           this.calculeRubPlanAnalytique(var30, this.transfertVentes.getTrfColT25(), var46);
                        }

                        if (var31 != null && !var31.isEmpty()) {
                           this.calculeRubPlanAnalytique(var31, this.transfertVentes.getTrfColT26(), var46);
                        }

                        if (var32 != null && !var32.isEmpty()) {
                           this.calculeRubPlanAnalytique(var32, this.transfertVentes.getTrfColT27(), var46);
                        }

                        if (var33 != null && !var33.isEmpty()) {
                           this.calculeRubPlanAnalytique(var33, this.transfertVentes.getTrfColT28(), var46);
                        }

                        if (var34 != null && !var34.isEmpty()) {
                           this.calculeRubPlanAnalytique(var34, this.transfertVentes.getTrfColT29(), var46);
                        }

                        if (var35 != null && !var35.isEmpty()) {
                           this.calculeRubPlanAnalytique(var35, this.transfertVentes.getTrfColT30(), var46);
                        }

                        if (var36 != null && !var36.isEmpty()) {
                           this.calculeRubPlanAnalytique(var36, this.transfertVentes.getTrfColT31(), var46);
                        }

                        if (var37 != null && !var37.isEmpty()) {
                           this.calculeRubPlanAnalytique(var37, this.transfertVentes.getTrfColT32(), var46);
                        }

                        if (var38 != null && !var38.isEmpty()) {
                           this.calculeRubPlanAnalytique(var38, this.transfertVentes.getTrfColT33(), var46);
                        }

                        if (var39 != null && !var39.isEmpty()) {
                           this.calculeRubPlanAnalytique(var39, this.transfertVentes.getTrfColT34(), var46);
                        }

                        if (var40 != null && !var40.isEmpty()) {
                           this.calculeRubPlanAnalytique(var40, this.transfertVentes.getTrfColT35(), var46);
                        }

                        if (var41 != null && !var41.isEmpty()) {
                           this.calculeRubPlanAnalytique(var41, this.transfertVentes.getTrfColT36(), var46);
                        }

                        if (var42 != null && !var42.isEmpty()) {
                           this.calculeRubPlanAnalytique(var42, this.transfertVentes.getTrfColT37(), var46);
                        }

                        if (var43 != null && !var43.isEmpty()) {
                           this.calculeRubPlanAnalytique(var43, this.transfertVentes.getTrfColT38(), var46);
                        }

                        if (var44 != null && !var44.isEmpty()) {
                           this.calculeRubPlanAnalytique(var44, this.transfertVentes.getTrfColT39(), var46);
                        }

                        if (var45 != null && !var45.isEmpty()) {
                           this.calculeRubPlanAnalytique(var45, this.transfertVentes.getTrfColT40(), var46);
                        }

                        if (!var60) {
                           if (this.plansAnalytiques.getAnaAffaireDateDemande() != null) {
                              var50 = "" + (this.plansAnalytiques.getAnaAffaireDateDemande().getYear() + 1900);
                              this.plansAnalytiques.setAnaAnnee(var50);
                           }

                           if (this.plansAnalytiques.getAnaNature() != null && !this.plansAnalytiques.getAnaNature().isEmpty() && this.plansAnalytiques.getAnaNature().equals("10")) {
                              this.plansAnalytiques.setAnaTiersObs(this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode());
                           }

                           this.plansAnalytiques.setAnaDateCreat(new Date());
                           this.plansAnalytiques.setAnaUserCreat(this.usersLog.getUsrid());
                           this.plansAnalytiques = this.plansAnalytiquesDao.insert(this.plansAnalytiques, var46);
                        } else {
                           if (this.plansAnalytiques.getAnaAffaireDateDemande() != null) {
                              var50 = "" + (this.plansAnalytiques.getAnaAffaireDateDemande().getYear() + 1900);
                              this.plansAnalytiques.setAnaAnnee(var50);
                           }

                           if (this.plansAnalytiques.getAnaNature() != null && !this.plansAnalytiques.getAnaNature().isEmpty() && this.plansAnalytiques.getAnaNature().equals("10")) {
                              this.plansAnalytiques.setAnaTiersObs(this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode());
                           }

                           this.plansAnalytiques.setAnaDateModif(new Date());
                           this.plansAnalytiques.setAnaUserModif(this.usersLog.getUsrid());
                           this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques, var46);
                        }

                        var46.flush();
                     }
                  } else {
                     this.produitsDepot = null;
                     this.produitsTarif = null;
                     this.produitsFournisseur = null;
                     var50 = "";
                     if (var7 != null && !var7.isEmpty()) {
                        var50 = var7;
                     } else {
                        var50 = var6;
                     }

                     if (var50.contains("pro_")) {
                        if (var6 != null && !var6.isEmpty()) {
                           this.calculeRubProduit(var6, this.transfertVentes.getTrfColT01(), var46);
                        }

                        if (var7 != null && !var7.isEmpty()) {
                           this.calculeRubProduit(var7, this.transfertVentes.getTrfColT02(), var46);
                        }

                        if (var8 != null && !var8.isEmpty()) {
                           this.calculeRubProduit(var8, this.transfertVentes.getTrfColT03(), var46);
                        }

                        if (var9 != null && !var9.isEmpty()) {
                           this.calculeRubProduit(var9, this.transfertVentes.getTrfColT04(), var46);
                        }

                        if (var10 != null && !var10.isEmpty()) {
                           this.calculeRubProduit(var10, this.transfertVentes.getTrfColT05(), var46);
                        }

                        if (var11 != null && !var11.isEmpty()) {
                           this.calculeRubProduit(var11, this.transfertVentes.getTrfColT06(), var46);
                        }

                        if (var12 != null && !var12.isEmpty()) {
                           this.calculeRubProduit(var12, this.transfertVentes.getTrfColT07(), var46);
                        }

                        if (var13 != null && !var13.isEmpty()) {
                           this.calculeRubProduit(var13, this.transfertVentes.getTrfColT08(), var46);
                        }

                        if (var14 != null && !var14.isEmpty()) {
                           this.calculeRubProduit(var14, this.transfertVentes.getTrfColT09(), var46);
                        }

                        if (var15 != null && !var15.isEmpty()) {
                           this.calculeRubProduit(var15, this.transfertVentes.getTrfColT10(), var46);
                        }

                        if (var16 != null && !var16.isEmpty()) {
                           this.calculeRubProduit(var16, this.transfertVentes.getTrfColT11(), var46);
                        }

                        if (var17 != null && !var17.isEmpty()) {
                           this.calculeRubProduit(var17, this.transfertVentes.getTrfColT12(), var46);
                        }

                        if (var18 != null && !var18.isEmpty()) {
                           this.calculeRubProduit(var18, this.transfertVentes.getTrfColT13(), var46);
                        }

                        if (var19 != null && !var19.isEmpty()) {
                           this.calculeRubProduit(var19, this.transfertVentes.getTrfColT14(), var46);
                        }

                        if (var20 != null && !var20.isEmpty()) {
                           this.calculeRubProduit(var20, this.transfertVentes.getTrfColT15(), var46);
                        }

                        if (var21 != null && !var21.isEmpty()) {
                           this.calculeRubProduit(var21, this.transfertVentes.getTrfColT16(), var46);
                        }

                        if (var22 != null && !var22.isEmpty()) {
                           this.calculeRubProduit(var22, this.transfertVentes.getTrfColT17(), var46);
                        }

                        if (var23 != null && !var23.isEmpty()) {
                           this.calculeRubProduit(var23, this.transfertVentes.getTrfColT18(), var46);
                        }

                        if (var24 != null && !var24.isEmpty()) {
                           this.calculeRubProduit(var24, this.transfertVentes.getTrfColT19(), var46);
                        }

                        if (var25 != null && !var25.isEmpty()) {
                           this.calculeRubProduit(var25, this.transfertVentes.getTrfColT20(), var46);
                        }

                        if (var26 != null && !var26.isEmpty()) {
                           this.calculeRubProduit(var26, this.transfertVentes.getTrfColT21(), var46);
                        }

                        if (var27 != null && !var27.isEmpty()) {
                           this.calculeRubProduit(var27, this.transfertVentes.getTrfColT22(), var46);
                        }

                        if (var28 != null && !var28.isEmpty()) {
                           this.calculeRubProduit(var28, this.transfertVentes.getTrfColT23(), var46);
                        }

                        if (var29 != null && !var29.isEmpty()) {
                           this.calculeRubProduit(var29, this.transfertVentes.getTrfColT24(), var46);
                        }

                        if (var30 != null && !var30.isEmpty()) {
                           this.calculeRubProduit(var30, this.transfertVentes.getTrfColT25(), var46);
                        }

                        if (var31 != null && !var31.isEmpty()) {
                           this.calculeRubProduit(var31, this.transfertVentes.getTrfColT26(), var46);
                        }

                        if (var32 != null && !var32.isEmpty()) {
                           this.calculeRubProduit(var32, this.transfertVentes.getTrfColT27(), var46);
                        }

                        if (var33 != null && !var33.isEmpty()) {
                           this.calculeRubProduit(var33, this.transfertVentes.getTrfColT28(), var46);
                        }

                        if (var34 != null && !var34.isEmpty()) {
                           this.calculeRubProduit(var34, this.transfertVentes.getTrfColT29(), var46);
                        }

                        if (var35 != null && !var35.isEmpty()) {
                           this.calculeRubProduit(var35, this.transfertVentes.getTrfColT30(), var46);
                        }

                        if (var36 != null && !var36.isEmpty()) {
                           this.calculeRubProduit(var36, this.transfertVentes.getTrfColT31(), var46);
                        }

                        if (var37 != null && !var37.isEmpty()) {
                           this.calculeRubProduit(var37, this.transfertVentes.getTrfColT32(), var46);
                        }

                        if (var38 != null && !var38.isEmpty()) {
                           this.calculeRubProduit(var38, this.transfertVentes.getTrfColT33(), var46);
                        }

                        if (var39 != null && !var39.isEmpty()) {
                           this.calculeRubProduit(var39, this.transfertVentes.getTrfColT34(), var46);
                        }

                        if (var40 != null && !var40.isEmpty()) {
                           this.calculeRubProduit(var40, this.transfertVentes.getTrfColT35(), var46);
                        }

                        if (var41 != null && !var41.isEmpty()) {
                           this.calculeRubProduit(var41, this.transfertVentes.getTrfColT36(), var46);
                        }

                        if (var42 != null && !var42.isEmpty()) {
                           this.calculeRubProduit(var42, this.transfertVentes.getTrfColT37(), var46);
                        }

                        if (var43 != null && !var43.isEmpty()) {
                           this.calculeRubProduit(var43, this.transfertVentes.getTrfColT38(), var46);
                        }

                        if (var44 != null && !var44.isEmpty()) {
                           this.calculeRubProduit(var44, this.transfertVentes.getTrfColT39(), var46);
                        }

                        if (var45 != null && !var45.isEmpty()) {
                           this.calculeRubProduit(var45, this.transfertVentes.getTrfColT40(), var46);
                        }

                        if (!var60) {
                           this.produits.setProDateCreat(new Date());
                           this.produits.setProUserCreat(this.usersLog.getUsrid());
                           this.produits = this.produitsAchsDao.insert(this.produits, var46);
                        } else {
                           this.produits.setProDateModif(new Date());
                           this.produits.setProUserModif(this.usersLog.getUsrid());
                           this.produits = this.produitsAchsDao.modif(this.produits, var46);
                        }

                        var46.flush();
                     } else if (!var60 && var50.contains("prodep_")) {
                        this.transfertVentes.setTrfNomFeuille("le produit " + this.transfertVentes.getTrfColT00() + " n`existe pas.");
                        this.lesErreurs.add(this.transfertVentes);
                     } else {
                        boolean var61;
                        List var62;
                        byte var63;
                        if (var60 && var50.contains("prodep_")) {
                           var61 = false;
                           this.depotAchats = null;
                           if (this.transfertVentes.getTrfColT01() != null && !this.transfertVentes.getTrfColT01().isEmpty()) {
                              this.depotAchats = this.depotAchatsDao.trouveDepot(this.transfertVentes.getTrfColT01(), var46);
                           }

                           if (this.depotAchats != null) {
                              new ArrayList();
                              var62 = this.produitsDepotDao.produitDepByprodList(this.produits.getProCode(), this.transfertVentes.getTrfColT01(), var46);
                              if (var62.size() != 0) {
                                 var63 = 0;
                                 if (var63 < var62.size()) {
                                    this.produitsDepot = (ProduitsDepot)var62.get(var63);
                                    var61 = true;
                                 }
                              }

                              if (!var61) {
                                 this.produitsDepot = new ProduitsDepot();
                              }

                              if (var6 != null && !var6.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var6, this.transfertVentes.getTrfColT01(), var46);
                              }

                              if (var7 != null && !var7.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var7, this.transfertVentes.getTrfColT02(), var46);
                              }

                              if (var8 != null && !var8.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var8, this.transfertVentes.getTrfColT03(), var46);
                              }

                              if (var9 != null && !var9.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var9, this.transfertVentes.getTrfColT04(), var46);
                              }

                              if (var10 != null && !var10.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var10, this.transfertVentes.getTrfColT05(), var46);
                              }

                              if (var11 != null && !var11.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var11, this.transfertVentes.getTrfColT06(), var46);
                              }

                              if (var12 != null && !var12.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var12, this.transfertVentes.getTrfColT07(), var46);
                              }

                              if (var13 != null && !var13.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var13, this.transfertVentes.getTrfColT08(), var46);
                              }

                              if (var14 != null && !var14.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var14, this.transfertVentes.getTrfColT09(), var46);
                              }

                              if (var15 != null && !var15.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var15, this.transfertVentes.getTrfColT10(), var46);
                              }

                              if (var16 != null && !var16.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var16, this.transfertVentes.getTrfColT11(), var46);
                              }

                              if (var17 != null && !var17.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var17, this.transfertVentes.getTrfColT12(), var46);
                              }

                              if (var18 != null && !var18.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var18, this.transfertVentes.getTrfColT13(), var46);
                              }

                              if (var19 != null && !var19.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var19, this.transfertVentes.getTrfColT14(), var46);
                              }

                              if (var20 != null && !var20.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var20, this.transfertVentes.getTrfColT15(), var46);
                              }

                              if (var21 != null && !var21.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var21, this.transfertVentes.getTrfColT16(), var46);
                              }

                              if (var22 != null && !var22.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var22, this.transfertVentes.getTrfColT17(), var46);
                              }

                              if (var23 != null && !var23.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var23, this.transfertVentes.getTrfColT18(), var46);
                              }

                              if (var24 != null && !var24.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var24, this.transfertVentes.getTrfColT19(), var46);
                              }

                              if (var25 != null && !var25.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var25, this.transfertVentes.getTrfColT20(), var46);
                              }

                              if (var26 != null && !var26.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var26, this.transfertVentes.getTrfColT21(), var46);
                              }

                              if (var27 != null && !var27.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var27, this.transfertVentes.getTrfColT22(), var46);
                              }

                              if (var28 != null && !var28.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var28, this.transfertVentes.getTrfColT23(), var46);
                              }

                              if (var29 != null && !var29.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var29, this.transfertVentes.getTrfColT24(), var46);
                              }

                              if (var30 != null && !var30.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var30, this.transfertVentes.getTrfColT25(), var46);
                              }

                              if (var31 != null && !var31.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var31, this.transfertVentes.getTrfColT26(), var46);
                              }

                              if (var32 != null && !var32.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var32, this.transfertVentes.getTrfColT27(), var46);
                              }

                              if (var33 != null && !var33.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var33, this.transfertVentes.getTrfColT28(), var46);
                              }

                              if (var34 != null && !var34.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var34, this.transfertVentes.getTrfColT29(), var46);
                              }

                              if (var35 != null && !var35.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var35, this.transfertVentes.getTrfColT30(), var46);
                              }

                              if (var36 != null && !var36.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var36, this.transfertVentes.getTrfColT31(), var46);
                              }

                              if (var37 != null && !var37.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var37, this.transfertVentes.getTrfColT32(), var46);
                              }

                              if (var38 != null && !var38.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var38, this.transfertVentes.getTrfColT33(), var46);
                              }

                              if (var39 != null && !var39.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var39, this.transfertVentes.getTrfColT34(), var46);
                              }

                              if (var40 != null && !var40.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var40, this.transfertVentes.getTrfColT35(), var46);
                              }

                              if (var41 != null && !var41.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var41, this.transfertVentes.getTrfColT36(), var46);
                              }

                              if (var42 != null && !var42.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var42, this.transfertVentes.getTrfColT37(), var46);
                              }

                              if (var43 != null && !var43.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var43, this.transfertVentes.getTrfColT38(), var46);
                              }

                              if (var44 != null && !var44.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var44, this.transfertVentes.getTrfColT39(), var46);
                              }

                              if (var45 != null && !var45.isEmpty()) {
                                 var61 = this.calculeRubProduitDepot(var45, this.transfertVentes.getTrfColT40(), var46);
                              }

                              if (!var61) {
                                 this.produitsDepot.setDepot(this.depotAchats);
                                 this.produitsDepot.setProduits(this.produits);
                                 this.produitsDepot.setProdepCle(this.depotAchats.getDpoCode() + ":" + this.produits.getProCode());
                                 this.produitsDepot.setProdepCle2(this.produitsDepot.getProdepGroupe() + ":" + this.produits.getProCode());
                                 this.produitsDepot = this.produitsDepotDao.insert(this.produitsDepot, var46);
                              } else {
                                 this.produitsDepot.setDepot(this.depotAchats);
                                 this.produitsDepot.setProduits(this.produits);
                                 this.produitsDepot.setProdepCle(this.depotAchats.getDpoCode() + ":" + this.produits.getProCode());
                                 this.produitsDepot.setProdepCle2(this.produitsDepot.getProdepGroupe() + ":" + this.produits.getProCode());
                                 this.produitsDepot = this.produitsDepotDao.modif(this.produitsDepot, var46);
                              }

                              var46.flush();
                           } else {
                              this.transfertVentes.setTrfNomFeuille("Le dépot " + this.transfertVentes.getTrfColT01());
                              this.lesErreurs.add(this.transfertVentes);
                           }
                        } else if (!var60 && var50.contains("protar_")) {
                           this.transfertVentes.setTrfNomFeuille("le produit " + this.transfertVentes.getTrfColT00() + " n`existe pas.");
                           this.lesErreurs.add(this.transfertVentes);
                        } else if (var60 && var50.contains("protar_")) {
                           var61 = false;
                           new ArrayList();
                           var62 = this.produitsTarifDao.selectProdTarifByprod(this.produits, var46);
                           if (var62.size() != 0) {
                              for(int var64 = 0; var64 < var62.size(); ++var64) {
                                 if (this.transfertVentes.getTrfColT01() != null && !this.transfertVentes.getTrfColT01().isEmpty() && ((ProduitsTarif)var62.get(var64)).getProtarOrdre() == this.conversionInteger(this.transfertVentes.getTrfColT01())) {
                                    this.produitsTarif = (ProduitsTarif)var62.get(var64);
                                    var61 = true;
                                    break;
                                 }
                              }
                           }

                           if (!var61) {
                              this.produitsTarif = new ProduitsTarif();
                           }

                           if (var6 != null && !var6.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var6, this.transfertVentes.getTrfColT01(), var46);
                           }

                           if (var7 != null && !var7.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var7, this.transfertVentes.getTrfColT02(), var46);
                           }

                           if (var8 != null && !var8.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var8, this.transfertVentes.getTrfColT03(), var46);
                           }

                           if (var9 != null && !var9.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var9, this.transfertVentes.getTrfColT04(), var46);
                           }

                           if (var10 != null && !var10.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var10, this.transfertVentes.getTrfColT05(), var46);
                           }

                           if (var11 != null && !var11.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var11, this.transfertVentes.getTrfColT06(), var46);
                           }

                           if (var12 != null && !var12.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var12, this.transfertVentes.getTrfColT07(), var46);
                           }

                           if (var13 != null && !var13.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var13, this.transfertVentes.getTrfColT08(), var46);
                           }

                           if (var14 != null && !var14.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var14, this.transfertVentes.getTrfColT09(), var46);
                           }

                           if (var15 != null && !var15.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var15, this.transfertVentes.getTrfColT10(), var46);
                           }

                           if (var16 != null && !var16.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var16, this.transfertVentes.getTrfColT11(), var46);
                           }

                           if (var17 != null && !var17.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var17, this.transfertVentes.getTrfColT12(), var46);
                           }

                           if (var18 != null && !var18.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var18, this.transfertVentes.getTrfColT13(), var46);
                           }

                           if (var19 != null && !var19.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var19, this.transfertVentes.getTrfColT14(), var46);
                           }

                           if (var20 != null && !var20.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var20, this.transfertVentes.getTrfColT15(), var46);
                           }

                           if (var21 != null && !var21.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var21, this.transfertVentes.getTrfColT16(), var46);
                           }

                           if (var22 != null && !var22.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var22, this.transfertVentes.getTrfColT17(), var46);
                           }

                           if (var23 != null && !var23.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var23, this.transfertVentes.getTrfColT18(), var46);
                           }

                           if (var24 != null && !var24.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var24, this.transfertVentes.getTrfColT19(), var46);
                           }

                           if (var25 != null && !var25.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var25, this.transfertVentes.getTrfColT20(), var46);
                           }

                           if (var26 != null && !var26.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var26, this.transfertVentes.getTrfColT21(), var46);
                           }

                           if (var27 != null && !var27.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var27, this.transfertVentes.getTrfColT22(), var46);
                           }

                           if (var28 != null && !var28.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var28, this.transfertVentes.getTrfColT23(), var46);
                           }

                           if (var29 != null && !var29.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var29, this.transfertVentes.getTrfColT24(), var46);
                           }

                           if (var30 != null && !var30.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var30, this.transfertVentes.getTrfColT25(), var46);
                           }

                           if (var31 != null && !var31.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var31, this.transfertVentes.getTrfColT26(), var46);
                           }

                           if (var32 != null && !var32.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var32, this.transfertVentes.getTrfColT27(), var46);
                           }

                           if (var33 != null && !var33.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var33, this.transfertVentes.getTrfColT28(), var46);
                           }

                           if (var34 != null && !var34.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var34, this.transfertVentes.getTrfColT29(), var46);
                           }

                           if (var35 != null && !var35.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var35, this.transfertVentes.getTrfColT30(), var46);
                           }

                           if (var36 != null && !var36.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var36, this.transfertVentes.getTrfColT31(), var46);
                           }

                           if (var37 != null && !var37.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var37, this.transfertVentes.getTrfColT32(), var46);
                           }

                           if (var38 != null && !var38.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var38, this.transfertVentes.getTrfColT33(), var46);
                           }

                           if (var39 != null && !var39.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var39, this.transfertVentes.getTrfColT34(), var46);
                           }

                           if (var40 != null && !var40.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var40, this.transfertVentes.getTrfColT35(), var46);
                           }

                           if (var41 != null && !var41.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var41, this.transfertVentes.getTrfColT36(), var46);
                           }

                           if (var42 != null && !var42.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var42, this.transfertVentes.getTrfColT37(), var46);
                           }

                           if (var43 != null && !var43.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var43, this.transfertVentes.getTrfColT38(), var46);
                           }

                           if (var44 != null && !var44.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var44, this.transfertVentes.getTrfColT39(), var46);
                           }

                           if (var45 != null && !var45.isEmpty()) {
                              var61 = this.calculeRubProduitTarif(var45, this.transfertVentes.getTrfColT40(), var46);
                           }

                           if (this.produitsTarif.getProtarOrdre() != 99999) {
                              if (!var61) {
                                 this.produitsTarif.setUnite((Unite)null);
                                 this.produitsTarif.setProduits(this.produits);
                                 this.produitsTarif = this.produitsTarifDao.insert(this.produitsTarif, var46);
                              } else {
                                 this.produitsTarif.setUnite((Unite)null);
                                 this.produitsTarif.setProduits(this.produits);
                                 this.produitsTarif = this.produitsTarifDao.modif(this.produitsTarif, var46);
                              }
                           }

                           var46.flush();
                        } else if (!var60 && var50.contains("bar_")) {
                           this.transfertVentes.setTrfNomFeuille("le produit " + this.transfertVentes.getTrfColT00() + " n`existe pas.");
                           this.lesErreurs.add(this.transfertVentes);
                        } else if (var60 && var50.contains("bar_")) {
                           var61 = false;
                           new ArrayList();
                           var62 = this.baremesDao.listBaremesByProduits(this.transfertVentes.getTrfColT00(), var46);
                           if (var62.size() != 0) {
                              var63 = 0;
                              if (var63 < var62.size()) {
                                 this.baremes = (Baremes)var62.get(var63);
                                 var61 = true;
                              }
                           }

                           if (!var61) {
                              this.baremes = new Baremes();
                           }

                           if (var6 != null && !var6.isEmpty()) {
                              var61 = this.calculeRubBareme(var6, this.transfertVentes.getTrfColT01(), var46);
                           }

                           if (var7 != null && !var7.isEmpty()) {
                              var61 = this.calculeRubBareme(var7, this.transfertVentes.getTrfColT02(), var46);
                           }

                           if (var8 != null && !var8.isEmpty()) {
                              var61 = this.calculeRubBareme(var8, this.transfertVentes.getTrfColT03(), var46);
                           }

                           if (var9 != null && !var9.isEmpty()) {
                              var61 = this.calculeRubBareme(var9, this.transfertVentes.getTrfColT04(), var46);
                           }

                           if (var10 != null && !var10.isEmpty()) {
                              var61 = this.calculeRubBareme(var10, this.transfertVentes.getTrfColT05(), var46);
                           }

                           if (var11 != null && !var11.isEmpty()) {
                              var61 = this.calculeRubBareme(var11, this.transfertVentes.getTrfColT06(), var46);
                           }

                           if (var12 != null && !var12.isEmpty()) {
                              var61 = this.calculeRubBareme(var12, this.transfertVentes.getTrfColT07(), var46);
                           }

                           if (var13 != null && !var13.isEmpty()) {
                              var61 = this.calculeRubBareme(var13, this.transfertVentes.getTrfColT08(), var46);
                           }

                           if (var14 != null && !var14.isEmpty()) {
                              var61 = this.calculeRubBareme(var14, this.transfertVentes.getTrfColT09(), var46);
                           }

                           if (var15 != null && !var15.isEmpty()) {
                              var61 = this.calculeRubBareme(var15, this.transfertVentes.getTrfColT10(), var46);
                           }

                           if (var16 != null && !var16.isEmpty()) {
                              var61 = this.calculeRubBareme(var16, this.transfertVentes.getTrfColT11(), var46);
                           }

                           if (var17 != null && !var17.isEmpty()) {
                              var61 = this.calculeRubBareme(var17, this.transfertVentes.getTrfColT12(), var46);
                           }

                           if (var18 != null && !var18.isEmpty()) {
                              var61 = this.calculeRubBareme(var18, this.transfertVentes.getTrfColT13(), var46);
                           }

                           if (var19 != null && !var19.isEmpty()) {
                              var61 = this.calculeRubBareme(var19, this.transfertVentes.getTrfColT14(), var46);
                           }

                           if (var20 != null && !var20.isEmpty()) {
                              var61 = this.calculeRubBareme(var20, this.transfertVentes.getTrfColT15(), var46);
                           }

                           if (var21 != null && !var21.isEmpty()) {
                              var61 = this.calculeRubBareme(var21, this.transfertVentes.getTrfColT16(), var46);
                           }

                           if (var22 != null && !var22.isEmpty()) {
                              var61 = this.calculeRubBareme(var22, this.transfertVentes.getTrfColT17(), var46);
                           }

                           if (var23 != null && !var23.isEmpty()) {
                              var61 = this.calculeRubBareme(var23, this.transfertVentes.getTrfColT18(), var46);
                           }

                           if (var24 != null && !var24.isEmpty()) {
                              var61 = this.calculeRubBareme(var24, this.transfertVentes.getTrfColT19(), var46);
                           }

                           if (var25 != null && !var25.isEmpty()) {
                              var61 = this.calculeRubBareme(var25, this.transfertVentes.getTrfColT20(), var46);
                           }

                           if (var26 != null && !var26.isEmpty()) {
                              var61 = this.calculeRubBareme(var26, this.transfertVentes.getTrfColT21(), var46);
                           }

                           if (var27 != null && !var27.isEmpty()) {
                              var61 = this.calculeRubBareme(var27, this.transfertVentes.getTrfColT22(), var46);
                           }

                           if (var28 != null && !var28.isEmpty()) {
                              var61 = this.calculeRubBareme(var28, this.transfertVentes.getTrfColT23(), var46);
                           }

                           if (var29 != null && !var29.isEmpty()) {
                              var61 = this.calculeRubBareme(var29, this.transfertVentes.getTrfColT24(), var46);
                           }

                           if (var30 != null && !var30.isEmpty()) {
                              var61 = this.calculeRubBareme(var30, this.transfertVentes.getTrfColT25(), var46);
                           }

                           if (var31 != null && !var31.isEmpty()) {
                              var61 = this.calculeRubBareme(var31, this.transfertVentes.getTrfColT26(), var46);
                           }

                           if (var32 != null && !var32.isEmpty()) {
                              var61 = this.calculeRubBareme(var32, this.transfertVentes.getTrfColT27(), var46);
                           }

                           if (var33 != null && !var33.isEmpty()) {
                              var61 = this.calculeRubBareme(var33, this.transfertVentes.getTrfColT28(), var46);
                           }

                           if (var34 != null && !var34.isEmpty()) {
                              var61 = this.calculeRubBareme(var34, this.transfertVentes.getTrfColT29(), var46);
                           }

                           if (var35 != null && !var35.isEmpty()) {
                              var61 = this.calculeRubBareme(var35, this.transfertVentes.getTrfColT30(), var46);
                           }

                           if (var36 != null && !var36.isEmpty()) {
                              var61 = this.calculeRubBareme(var36, this.transfertVentes.getTrfColT31(), var46);
                           }

                           if (var37 != null && !var37.isEmpty()) {
                              var61 = this.calculeRubBareme(var37, this.transfertVentes.getTrfColT32(), var46);
                           }

                           if (var38 != null && !var38.isEmpty()) {
                              var61 = this.calculeRubBareme(var38, this.transfertVentes.getTrfColT33(), var46);
                           }

                           if (var39 != null && !var39.isEmpty()) {
                              var61 = this.calculeRubBareme(var39, this.transfertVentes.getTrfColT34(), var46);
                           }

                           if (var40 != null && !var40.isEmpty()) {
                              var61 = this.calculeRubBareme(var40, this.transfertVentes.getTrfColT35(), var46);
                           }

                           if (var41 != null && !var41.isEmpty()) {
                              var61 = this.calculeRubBareme(var41, this.transfertVentes.getTrfColT36(), var46);
                           }

                           if (var42 != null && !var42.isEmpty()) {
                              var61 = this.calculeRubBareme(var42, this.transfertVentes.getTrfColT37(), var46);
                           }

                           if (var43 != null && !var43.isEmpty()) {
                              var61 = this.calculeRubBareme(var43, this.transfertVentes.getTrfColT38(), var46);
                           }

                           if (var44 != null && !var44.isEmpty()) {
                              var61 = this.calculeRubBareme(var44, this.transfertVentes.getTrfColT39(), var46);
                           }

                           if (var45 != null && !var45.isEmpty()) {
                              var61 = this.calculeRubBareme(var45, this.transfertVentes.getTrfColT40(), var46);
                           }

                           if (this.baremes.getBarOrdreTarif() != 99999) {
                              if (!var61) {
                                 this.baremes.setBarDateCreat(new Date());
                                 this.baremes.setBarUserCreat(this.usersLog.getUsrid());
                                 this.baremes.setBarCodeProduit(this.produits.getProCode());
                                 this.baremes.setBarLibelleProduit(this.produits.getProLibClient());
                                 if (this.baremes.getBarIdTiers() != 0L) {
                                    this.baremes.setBarType(0);
                                 } else if (this.baremes.getBarCategorieTiers() != null && !this.baremes.getBarCategorieTiers().isEmpty()) {
                                    this.baremes.setBarType(1);
                                 } else if (this.baremes.getBarCodeProduit() != null && !this.baremes.getBarCodeProduit().isEmpty()) {
                                    this.baremes.setBarType(2);
                                 } else if (this.baremes.getBarCodeVte() != null && !this.baremes.getBarCodeVte().isEmpty()) {
                                    this.baremes.setBarType(3);
                                 }

                                 this.baremes = this.baremesDao.insert(this.baremes, var46);
                              } else {
                                 this.baremes.setBarDateModif(new Date());
                                 this.baremes.setBarUserModif(this.usersLog.getUsrid());
                                 this.baremes.setBarCodeProduit(this.produits.getProCode());
                                 this.baremes.setBarLibelleProduit(this.produits.getProLibClient());
                                 if (this.baremes.getBarIdTiers() != 0L) {
                                    this.baremes.setBarType(0);
                                 } else if (this.baremes.getBarCategorieTiers() != null && !this.baremes.getBarCategorieTiers().isEmpty()) {
                                    this.baremes.setBarType(1);
                                 } else if (this.baremes.getBarCodeProduit() != null && !this.baremes.getBarCodeProduit().isEmpty()) {
                                    this.baremes.setBarType(2);
                                 } else if (this.baremes.getBarCodeVte() != null && !this.baremes.getBarCodeVte().isEmpty()) {
                                    this.baremes.setBarType(3);
                                 }

                                 this.baremes = this.baremesDao.modif(this.baremes, var46);
                              }
                           }

                           var46.flush();
                        } else if (var60 && var50.contains("profou_")) {
                           var61 = false;
                           this.tiers = null;
                           if (this.transfertVentes.getTrfColT01() != null && !this.transfertVentes.getTrfColT01().isEmpty() && var48 >= 1) {
                              long var52 = this.conversionLong(this.transfertVentes.getTrfColT01());
                              this.tiers = this.tiersDao.selectTierD(var52, var46);
                           }

                           if (this.tiers != null && this.produits != null) {
                              this.produitsFournisseur = this.produitsFournisseurDao.selectProdFourByprodFic(this.produits, this.tiers, var46);
                              if (this.produitsFournisseur != null) {
                                 var61 = true;
                              }

                              if (!var61) {
                                 this.produitsFournisseur = new ProduitsFournisseur();
                              }

                              if (var6 != null && !var6.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var6, this.transfertVentes.getTrfColT01(), var46);
                              }

                              if (var7 != null && !var7.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var7, this.transfertVentes.getTrfColT02(), var46);
                              }

                              if (var8 != null && !var8.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var8, this.transfertVentes.getTrfColT03(), var46);
                              }

                              if (var9 != null && !var9.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var9, this.transfertVentes.getTrfColT04(), var46);
                              }

                              if (var10 != null && !var10.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var10, this.transfertVentes.getTrfColT05(), var46);
                              }

                              if (var11 != null && !var11.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var11, this.transfertVentes.getTrfColT06(), var46);
                              }

                              if (var12 != null && !var12.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var12, this.transfertVentes.getTrfColT07(), var46);
                              }

                              if (var13 != null && !var13.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var13, this.transfertVentes.getTrfColT08(), var46);
                              }

                              if (var14 != null && !var14.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var14, this.transfertVentes.getTrfColT09(), var46);
                              }

                              if (var15 != null && !var15.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var15, this.transfertVentes.getTrfColT10(), var46);
                              }

                              if (var16 != null && !var16.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var16, this.transfertVentes.getTrfColT11(), var46);
                              }

                              if (var17 != null && !var17.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var17, this.transfertVentes.getTrfColT12(), var46);
                              }

                              if (var18 != null && !var18.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var18, this.transfertVentes.getTrfColT13(), var46);
                              }

                              if (var19 != null && !var19.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var19, this.transfertVentes.getTrfColT14(), var46);
                              }

                              if (var20 != null && !var20.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var20, this.transfertVentes.getTrfColT15(), var46);
                              }

                              if (var21 != null && !var21.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var21, this.transfertVentes.getTrfColT16(), var46);
                              }

                              if (var22 != null && !var22.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var22, this.transfertVentes.getTrfColT17(), var46);
                              }

                              if (var23 != null && !var23.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var23, this.transfertVentes.getTrfColT18(), var46);
                              }

                              if (var24 != null && !var24.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var24, this.transfertVentes.getTrfColT19(), var46);
                              }

                              if (var25 != null && !var25.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var25, this.transfertVentes.getTrfColT20(), var46);
                              }

                              if (var26 != null && !var26.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var26, this.transfertVentes.getTrfColT21(), var46);
                              }

                              if (var27 != null && !var27.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var27, this.transfertVentes.getTrfColT22(), var46);
                              }

                              if (var28 != null && !var28.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var28, this.transfertVentes.getTrfColT23(), var46);
                              }

                              if (var29 != null && !var29.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var29, this.transfertVentes.getTrfColT24(), var46);
                              }

                              if (var30 != null && !var30.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var30, this.transfertVentes.getTrfColT25(), var46);
                              }

                              if (var31 != null && !var31.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var31, this.transfertVentes.getTrfColT26(), var46);
                              }

                              if (var32 != null && !var32.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var32, this.transfertVentes.getTrfColT27(), var46);
                              }

                              if (var33 != null && !var33.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var33, this.transfertVentes.getTrfColT28(), var46);
                              }

                              if (var34 != null && !var34.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var34, this.transfertVentes.getTrfColT29(), var46);
                              }

                              if (var35 != null && !var35.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var35, this.transfertVentes.getTrfColT30(), var46);
                              }

                              if (var36 != null && !var36.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var36, this.transfertVentes.getTrfColT31(), var46);
                              }

                              if (var37 != null && !var37.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var37, this.transfertVentes.getTrfColT32(), var46);
                              }

                              if (var38 != null && !var38.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var38, this.transfertVentes.getTrfColT33(), var46);
                              }

                              if (var39 != null && !var39.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var39, this.transfertVentes.getTrfColT34(), var46);
                              }

                              if (var40 != null && !var40.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var40, this.transfertVentes.getTrfColT35(), var46);
                              }

                              if (var41 != null && !var41.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var41, this.transfertVentes.getTrfColT36(), var46);
                              }

                              if (var42 != null && !var42.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var42, this.transfertVentes.getTrfColT37(), var46);
                              }

                              if (var43 != null && !var43.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var43, this.transfertVentes.getTrfColT38(), var46);
                              }

                              if (var44 != null && !var44.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var44, this.transfertVentes.getTrfColT39(), var46);
                              }

                              if (var45 != null && !var45.isEmpty()) {
                                 var61 = this.calculeRubProduitFournisseur(var45, this.transfertVentes.getTrfColT40(), var46);
                              }

                              if (var61) {
                                 this.produitsFournisseur.setTiers(this.tiers);
                                 this.produitsFournisseur.setProduits(this.produits);
                                 this.produitsFournisseur = this.produitsFournisseurDao.modif(this.produitsFournisseur, var46);
                              }

                              var46.flush();
                           } else {
                              if (this.tiers == null) {
                                 this.transfertVentes.setTrfNomFeuille("Le fournisseur " + this.transfertVentes.getTrfColT01());
                                 this.lesErreurs.add(this.transfertVentes);
                              }

                              if (this.produits == null) {
                                 this.transfertVentes.setTrfNomFeuille("Le produit " + this.transfertVentes.getTrfColT02());
                                 this.lesErreurs.add(this.transfertVentes);
                              }
                           }
                        }
                     }
                  }
               }
            }

            var47.commit();
         } catch (HibernateException var58) {
            if (var47 != null) {
               var47.rollback();
            }

            throw var58;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.datamodelDocument.setWrappedData(this.lesErreurs);
         this.var_affiche_bouton = false;
         this.balance = 2;
         this.var_showBarProgMaj = false;
      }

   }

   public boolean recherhceProduit(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      String var5 = "";
      if (var1.contains(".")) {
         int var6 = var1.indexOf(".");
         var5 = var1.substring(0, var6);
      } else {
         var5 = var1;
      }

      this.produits = this.produitsAchsDao.chargeToutProduit(var5, var3);
      if (this.produits == null) {
         this.produits = new Produits();
         this.produits.setProCode(var5);
         var4 = false;
      } else {
         var4 = true;
      }

      return var4;
   }

   public void importDevisLibre() throws HibernateException, NamingException, java.text.ParseException, JDOMException, IOException {
      this.lesErreurs.clear();
      if (this.lesTransfertVentes.size() != 0) {
         this.var_showBarProgMaj = true;
         this.var_currentValue = 0;
         this.var_info = "Chargement des elements de base...";
         boolean var1 = false;
         this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
         this.famillesProduitsAchats = new FamillesProduitsAchats();
         this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
         this.famillesProduitsVentes = new FamillesProduitsVentes();
         this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         this.produits = new Produits();
         this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
         this.produitsDepot = new ProduitsDepot();
         LectureFamillesClients var2 = new LectureFamillesClients();
         var2.setStrId(this.structureLog.getStrid());
         var2.setStructureLog(this.structureLog);
         this.mesFamillesClientsItems = var2.chargerMesFamillesClientItems();
         this.devisEnteteVentes = new DevisEnteteVentes();
         this.devisEnteteVentesDao = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         this.devisLigneVentes = new DevisLigneVentes();
         this.devisLigneVentesDao = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
         this.taxesVentes = new TaxesVentes();
         this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
         this.tiers = new Tiers();
         this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
         String var3 = "";
         String var4 = "";
         String var5 = "";
         String var6 = "";
         String var7 = "";
         String var8 = "";
         String var9 = "";
         String var10 = "";
         String var11 = "";
         String var12 = "";
         String var13 = "";
         String var14 = "";
         String var15 = "";
         String var16 = "";
         String var17 = "";
         String var18 = "";
         String var19 = "";
         String var20 = "";
         String var21 = "";
         String var22 = "";
         String var23 = "";
         String var24 = "";
         String var25 = "";
         String var26 = "";
         String var27 = "";
         String var28 = "";
         String var29 = "";
         String var30 = "";
         String var31 = "";
         String var32 = "";
         String var33 = "";
         String var34 = "";
         String var35 = "";
         String var36 = "";
         String var37 = "";
         String var38 = "";
         String var39 = "";
         String var40 = "";
         String var41 = "";
         String var42 = "";
         String var43 = "";
         String var44 = "";
         String var45 = "";
         Session var46 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
         Transaction var47 = null;

         try {
            var47 = var46.beginTransaction();
            var46.setFlushMode(FlushMode.MANUAL);

            for(int var48 = 0; var48 < this.lesTransfertVentes.size(); ++var48) {
               this.transfertVentes = (TransfertVentes)this.lesTransfertVentes.get(var48);
               this.var_info = "Element " + var48 + " - Nb elements : " + this.lesTransfertVentes.size();
               double var51;
               double var53;
               if (var48 != 0) {
                  double var49 = (double)this.lesTransfertVentes.size();
                  var51 = this.utilNombre.myRound(var49 / (double)var48, 4);
                  var53 = this.utilNombre.myRound(100.0D / var51, 2);
                  this.var_currentValue = (int)var53;
               }

               if (var48 == 0) {
                  var5 = this.transfertVentes.getTrfColT00();
                  var6 = this.transfertVentes.getTrfColT01();
                  var7 = this.transfertVentes.getTrfColT02();
                  var8 = this.transfertVentes.getTrfColT03();
                  var9 = this.transfertVentes.getTrfColT04();
                  var10 = this.transfertVentes.getTrfColT05();
                  var11 = this.transfertVentes.getTrfColT06();
                  var12 = this.transfertVentes.getTrfColT07();
                  var13 = this.transfertVentes.getTrfColT08();
                  var14 = this.transfertVentes.getTrfColT09();
                  var15 = this.transfertVentes.getTrfColT10();
                  var16 = this.transfertVentes.getTrfColT11();
                  var17 = this.transfertVentes.getTrfColT12();
                  var18 = this.transfertVentes.getTrfColT13();
                  var19 = this.transfertVentes.getTrfColT14();
                  var20 = this.transfertVentes.getTrfColT15();
                  var21 = this.transfertVentes.getTrfColT16();
                  var22 = this.transfertVentes.getTrfColT17();
                  var23 = this.transfertVentes.getTrfColT18();
                  var24 = this.transfertVentes.getTrfColT19();
                  var25 = this.transfertVentes.getTrfColT20();
                  var26 = this.transfertVentes.getTrfColT21();
                  var27 = this.transfertVentes.getTrfColT22();
                  var28 = this.transfertVentes.getTrfColT23();
                  var29 = this.transfertVentes.getTrfColT24();
                  var30 = this.transfertVentes.getTrfColT25();
                  var31 = this.transfertVentes.getTrfColT26();
                  var32 = this.transfertVentes.getTrfColT27();
                  var33 = this.transfertVentes.getTrfColT28();
                  var34 = this.transfertVentes.getTrfColT29();
                  var35 = this.transfertVentes.getTrfColT30();
                  var36 = this.transfertVentes.getTrfColT31();
                  var37 = this.transfertVentes.getTrfColT32();
                  var38 = this.transfertVentes.getTrfColT33();
                  var39 = this.transfertVentes.getTrfColT34();
                  var40 = this.transfertVentes.getTrfColT35();
                  var41 = this.transfertVentes.getTrfColT36();
                  var42 = this.transfertVentes.getTrfColT37();
                  var43 = this.transfertVentes.getTrfColT38();
                  var44 = this.transfertVentes.getTrfColT39();
                  var45 = this.transfertVentes.getTrfColT40();
               } else {
                  this.devisEnteteVentes = null;
                  this.devisLigneVentes = null;
                  if (var5.contains("dvs_")) {
                     if (var6.contains("tie_id")) {
                        this.recherhceClient(this.transfertVentes.getTrfColT01(), var46);
                     }

                     if (this.tiers == null) {
                        this.transfertVentes.setTrfNomFeuille("le client " + this.transfertVentes.getTrfColT01() + " n`existe pas.");
                        this.lesErreurs.add(this.transfertVentes);
                     } else {
                        if (var5 != null && !var5.isEmpty()) {
                           this.calculeRubDevisEntete(var5, this.transfertVentes.getTrfColT00(), var46);
                        }

                        if (var7 != null && !var7.isEmpty()) {
                           this.calculeRubDevisEntete(var7, this.transfertVentes.getTrfColT02(), var46);
                        }

                        if (var8 != null && !var8.isEmpty()) {
                           this.calculeRubDevisEntete(var8, this.transfertVentes.getTrfColT03(), var46);
                        }

                        if (var9 != null && !var9.isEmpty()) {
                           this.calculeRubDevisEntete(var9, this.transfertVentes.getTrfColT04(), var46);
                        }

                        if (var10 != null && !var10.isEmpty()) {
                           this.calculeRubDevisEntete(var10, this.transfertVentes.getTrfColT05(), var46);
                        }

                        if (var11 != null && !var11.isEmpty()) {
                           this.calculeRubDevisEntete(var11, this.transfertVentes.getTrfColT06(), var46);
                        }

                        if (var12 != null && !var12.isEmpty()) {
                           this.calculeRubDevisEntete(var12, this.transfertVentes.getTrfColT07(), var46);
                        }

                        if (var13 != null && !var13.isEmpty()) {
                           this.calculeRubDevisEntete(var13, this.transfertVentes.getTrfColT08(), var46);
                        }

                        if (var14 != null && !var14.isEmpty()) {
                           this.calculeRubDevisEntete(var14, this.transfertVentes.getTrfColT09(), var46);
                        }

                        if (var15 != null && !var15.isEmpty()) {
                           this.calculeRubDevisEntete(var15, this.transfertVentes.getTrfColT10(), var46);
                        }

                        if (var16 != null && !var16.isEmpty()) {
                           this.calculeRubDevisEntete(var16, this.transfertVentes.getTrfColT11(), var46);
                        }

                        if (var17 != null && !var17.isEmpty()) {
                           this.calculeRubDevisEntete(var17, this.transfertVentes.getTrfColT12(), var46);
                        }

                        if (var18 != null && !var18.isEmpty()) {
                           this.calculeRubDevisEntete(var18, this.transfertVentes.getTrfColT13(), var46);
                        }

                        if (var19 != null && !var19.isEmpty()) {
                           this.calculeRubDevisEntete(var19, this.transfertVentes.getTrfColT14(), var46);
                        }

                        if (var20 != null && !var20.isEmpty()) {
                           this.calculeRubDevisEntete(var20, this.transfertVentes.getTrfColT15(), var46);
                        }

                        if (var21 != null && !var21.isEmpty()) {
                           this.calculeRubDevisEntete(var21, this.transfertVentes.getTrfColT16(), var46);
                        }

                        if (var22 != null && !var22.isEmpty()) {
                           this.calculeRubDevisEntete(var22, this.transfertVentes.getTrfColT17(), var46);
                        }

                        if (var23 != null && !var23.isEmpty()) {
                           this.calculeRubDevisEntete(var23, this.transfertVentes.getTrfColT18(), var46);
                        }

                        if (var24 != null && !var24.isEmpty()) {
                           this.calculeRubDevisEntete(var24, this.transfertVentes.getTrfColT19(), var46);
                        }

                        if (var25 != null && !var25.isEmpty()) {
                           this.calculeRubDevisEntete(var25, this.transfertVentes.getTrfColT20(), var46);
                        }

                        if (var26 != null && !var26.isEmpty()) {
                           this.calculeRubDevisEntete(var26, this.transfertVentes.getTrfColT21(), var46);
                        }

                        if (var27 != null && !var27.isEmpty()) {
                           this.calculeRubDevisEntete(var27, this.transfertVentes.getTrfColT22(), var46);
                        }

                        if (var28 != null && !var28.isEmpty()) {
                           this.calculeRubDevisEntete(var28, this.transfertVentes.getTrfColT23(), var46);
                        }

                        if (var29 != null && !var29.isEmpty()) {
                           this.calculeRubDevisEntete(var29, this.transfertVentes.getTrfColT24(), var46);
                        }

                        if (var30 != null && !var30.isEmpty()) {
                           this.calculeRubDevisEntete(var30, this.transfertVentes.getTrfColT25(), var46);
                        }

                        if (var31 != null && !var31.isEmpty()) {
                           this.calculeRubDevisEntete(var31, this.transfertVentes.getTrfColT26(), var46);
                        }

                        if (var32 != null && !var32.isEmpty()) {
                           this.calculeRubDevisEntete(var32, this.transfertVentes.getTrfColT27(), var46);
                        }

                        if (var33 != null && !var33.isEmpty()) {
                           this.calculeRubDevisEntete(var33, this.transfertVentes.getTrfColT28(), var46);
                        }

                        if (var34 != null && !var34.isEmpty()) {
                           this.calculeRubDevisEntete(var34, this.transfertVentes.getTrfColT29(), var46);
                        }

                        if (var35 != null && !var35.isEmpty()) {
                           this.calculeRubDevisEntete(var35, this.transfertVentes.getTrfColT30(), var46);
                        }

                        if (var36 != null && !var36.isEmpty()) {
                           this.calculeRubDevisEntete(var36, this.transfertVentes.getTrfColT31(), var46);
                        }

                        if (var37 != null && !var37.isEmpty()) {
                           this.calculeRubDevisEntete(var37, this.transfertVentes.getTrfColT32(), var46);
                        }

                        if (var38 != null && !var38.isEmpty()) {
                           this.calculeRubDevisEntete(var38, this.transfertVentes.getTrfColT33(), var46);
                        }

                        if (var39 != null && !var39.isEmpty()) {
                           this.calculeRubDevisEntete(var39, this.transfertVentes.getTrfColT34(), var46);
                        }

                        if (var40 != null && !var40.isEmpty()) {
                           this.calculeRubDevisEntete(var40, this.transfertVentes.getTrfColT35(), var46);
                        }

                        if (var41 != null && !var41.isEmpty()) {
                           this.calculeRubDevisEntete(var41, this.transfertVentes.getTrfColT36(), var46);
                        }

                        if (var42 != null && !var42.isEmpty()) {
                           this.calculeRubDevisEntete(var42, this.transfertVentes.getTrfColT37(), var46);
                        }

                        if (var43 != null && !var43.isEmpty()) {
                           this.calculeRubDevisEntete(var43, this.transfertVentes.getTrfColT38(), var46);
                        }

                        if (var44 != null && !var44.isEmpty()) {
                           this.calculeRubDevisEntete(var44, this.transfertVentes.getTrfColT39(), var46);
                        }

                        if (var45 != null && !var45.isEmpty()) {
                           this.calculeRubDevisEntete(var45, this.transfertVentes.getTrfColT40(), var46);
                        }

                        if (this.devisEnteteVentes.getDvsId() == 0L) {
                           this.devisEnteteVentes.setExerciceventes(this.exercicesVentes);
                           this.devisEnteteVentes.setUsers(this.usersLog);
                           this.devisEnteteVentes.setTiers(this.tiers);
                           this.devisEnteteVentes.setDvsCivilTiers(this.tiers.getTiecivilite());
                           this.devisEnteteVentes.setDvsCat(this.tiers.getTiecategorie());
                           this.devisEnteteVentes.setDvsExoDouane(this.tiers.getTieexodouane());
                           this.devisEnteteVentes.setDvsExoTva(this.tiers.getTieexotva());
                           this.devisEnteteVentes.setDvsNomTiers(this.tiers.getTieraisonsocialenom());
                           if (this.devisEnteteVentes.getDvsDevise() == null || this.devisEnteteVentes.getDvsDevise().isEmpty()) {
                              this.devisEnteteVentes.setDvsDevise(this.structureLog.getStrdevise());
                           }

                           if (this.devisEnteteVentes.getDvsSerie() == null || this.devisEnteteVentes.getDvsSerie().isEmpty()) {
                              this.devisEnteteVentes.setDvsSerie("A");
                           }

                           this.devisEnteteVentes = this.devisEnteteVentesDao.insert(this.devisEnteteVentes, var46);
                        } else {
                           this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var46);
                           this.devisLigneVentesDao.deleteAllLigne(this.devisEnteteVentes, var46);
                        }

                        var46.flush();
                     }
                  } else if (var5.contains("dvslig_")) {
                     this.devisEnteteVentes = null;
                     String var50 = "";
                     if (this.transfertVentes.getTrfColT01() != null && !this.transfertVentes.getTrfColT01().isEmpty()) {
                        var50 = this.enlevePoint(this.transfertVentes.getTrfColT01()).toUpperCase();
                        this.devisEnteteVentes = this.devisEnteteVentesDao.pourParapheurByNum(var50, (String)null, var46);
                     }

                     if (this.devisEnteteVentes != null) {
                        this.devisLigneVentes = new DevisLigneVentes();
                        if (var5 != null && !var5.isEmpty()) {
                           this.calculeRubDevisLigne(var5, this.transfertVentes.getTrfColT00(), var46);
                        }

                        if (var7 != null && !var7.isEmpty()) {
                           this.calculeRubDevisLigne(var7, this.transfertVentes.getTrfColT02(), var46);
                        }

                        if (var8 != null && !var8.isEmpty()) {
                           this.calculeRubDevisLigne(var8, this.transfertVentes.getTrfColT03(), var46);
                        }

                        if (var9 != null && !var9.isEmpty()) {
                           this.calculeRubDevisLigne(var9, this.transfertVentes.getTrfColT04(), var46);
                        }

                        if (var10 != null && !var10.isEmpty()) {
                           this.calculeRubDevisLigne(var10, this.transfertVentes.getTrfColT05(), var46);
                        }

                        if (var11 != null && !var11.isEmpty()) {
                           this.calculeRubDevisLigne(var11, this.transfertVentes.getTrfColT06(), var46);
                        }

                        if (var12 != null && !var12.isEmpty()) {
                           this.calculeRubDevisLigne(var12, this.transfertVentes.getTrfColT07(), var46);
                        }

                        if (var13 != null && !var13.isEmpty()) {
                           this.calculeRubDevisLigne(var13, this.transfertVentes.getTrfColT08(), var46);
                        }

                        if (var14 != null && !var14.isEmpty()) {
                           this.calculeRubDevisLigne(var14, this.transfertVentes.getTrfColT09(), var46);
                        }

                        if (var15 != null && !var15.isEmpty()) {
                           this.calculeRubDevisLigne(var15, this.transfertVentes.getTrfColT10(), var46);
                        }

                        if (var16 != null && !var16.isEmpty()) {
                           this.calculeRubDevisLigne(var16, this.transfertVentes.getTrfColT11(), var46);
                        }

                        if (var17 != null && !var17.isEmpty()) {
                           this.calculeRubDevisLigne(var17, this.transfertVentes.getTrfColT12(), var46);
                        }

                        if (var18 != null && !var18.isEmpty()) {
                           this.calculeRubDevisLigne(var18, this.transfertVentes.getTrfColT13(), var46);
                        }

                        if (var19 != null && !var19.isEmpty()) {
                           this.calculeRubDevisLigne(var19, this.transfertVentes.getTrfColT14(), var46);
                        }

                        if (var20 != null && !var20.isEmpty()) {
                           this.calculeRubDevisLigne(var20, this.transfertVentes.getTrfColT15(), var46);
                        }

                        if (var21 != null && !var21.isEmpty()) {
                           this.calculeRubDevisLigne(var21, this.transfertVentes.getTrfColT16(), var46);
                        }

                        if (var22 != null && !var22.isEmpty()) {
                           this.calculeRubDevisLigne(var22, this.transfertVentes.getTrfColT17(), var46);
                        }

                        if (var23 != null && !var23.isEmpty()) {
                           this.calculeRubDevisLigne(var23, this.transfertVentes.getTrfColT18(), var46);
                        }

                        if (var24 != null && !var24.isEmpty()) {
                           this.calculeRubDevisLigne(var24, this.transfertVentes.getTrfColT19(), var46);
                        }

                        if (var25 != null && !var25.isEmpty()) {
                           this.calculeRubDevisLigne(var25, this.transfertVentes.getTrfColT20(), var46);
                        }

                        if (var26 != null && !var26.isEmpty()) {
                           this.calculeRubDevisLigne(var26, this.transfertVentes.getTrfColT21(), var46);
                        }

                        if (var27 != null && !var27.isEmpty()) {
                           this.calculeRubDevisLigne(var27, this.transfertVentes.getTrfColT22(), var46);
                        }

                        if (var28 != null && !var28.isEmpty()) {
                           this.calculeRubDevisLigne(var28, this.transfertVentes.getTrfColT23(), var46);
                        }

                        if (var29 != null && !var29.isEmpty()) {
                           this.calculeRubDevisLigne(var29, this.transfertVentes.getTrfColT24(), var46);
                        }

                        if (var30 != null && !var30.isEmpty()) {
                           this.calculeRubDevisLigne(var30, this.transfertVentes.getTrfColT25(), var46);
                        }

                        if (var31 != null && !var31.isEmpty()) {
                           this.calculeRubDevisLigne(var31, this.transfertVentes.getTrfColT26(), var46);
                        }

                        if (var32 != null && !var32.isEmpty()) {
                           this.calculeRubDevisLigne(var32, this.transfertVentes.getTrfColT27(), var46);
                        }

                        if (var33 != null && !var33.isEmpty()) {
                           this.calculeRubDevisLigne(var33, this.transfertVentes.getTrfColT28(), var46);
                        }

                        if (var34 != null && !var34.isEmpty()) {
                           this.calculeRubDevisLigne(var34, this.transfertVentes.getTrfColT29(), var46);
                        }

                        if (var35 != null && !var35.isEmpty()) {
                           this.calculeRubDevisLigne(var35, this.transfertVentes.getTrfColT30(), var46);
                        }

                        if (var36 != null && !var36.isEmpty()) {
                           this.calculeRubDevisLigne(var36, this.transfertVentes.getTrfColT31(), var46);
                        }

                        if (var37 != null && !var37.isEmpty()) {
                           this.calculeRubDevisLigne(var37, this.transfertVentes.getTrfColT32(), var46);
                        }

                        if (var38 != null && !var38.isEmpty()) {
                           this.calculeRubDevisLigne(var38, this.transfertVentes.getTrfColT33(), var46);
                        }

                        if (var39 != null && !var39.isEmpty()) {
                           this.calculeRubDevisLigne(var39, this.transfertVentes.getTrfColT34(), var46);
                        }

                        if (var40 != null && !var40.isEmpty()) {
                           this.calculeRubDevisLigne(var40, this.transfertVentes.getTrfColT35(), var46);
                        }

                        if (var41 != null && !var41.isEmpty()) {
                           this.calculeRubDevisLigne(var41, this.transfertVentes.getTrfColT36(), var46);
                        }

                        if (var42 != null && !var42.isEmpty()) {
                           this.calculeRubDevisLigne(var42, this.transfertVentes.getTrfColT37(), var46);
                        }

                        if (var43 != null && !var43.isEmpty()) {
                           this.calculeRubDevisLigne(var43, this.transfertVentes.getTrfColT38(), var46);
                        }

                        if (var44 != null && !var44.isEmpty()) {
                           this.calculeRubDevisLigne(var44, this.transfertVentes.getTrfColT39(), var46);
                        }

                        if (var45 != null && !var45.isEmpty()) {
                           this.calculeRubDevisLigne(var45, this.transfertVentes.getTrfColT40(), var46);
                        }

                        this.devisLigneVentes.setDevisEnteteVentes(this.devisEnteteVentes);
                        if (this.devisLigneVentes.getDvsligTauxRemise() != 0.0F) {
                           var51 = this.utilNombre.myRoundDevise(this.devisLigneVentes.getDvsligPu() * (double)this.devisLigneVentes.getDvsligTauxRemise() / 100.0D, this.devisEnteteVentes.getDvsDevise());
                           this.devisLigneVentes.setDvsligPuRem(this.devisLigneVentes.getDvsligPu() - var51);
                        } else {
                           this.devisLigneVentes.setDvsligPuRem(this.devisLigneVentes.getDvsligPu());
                        }

                        var51 = this.utilNombre.myRoundDevise(this.devisLigneVentes.getDvsligPuRem() * (double)this.devisLigneVentes.getDvsligQte(), this.devisEnteteVentes.getDvsDevise());
                        this.devisLigneVentes.setDvsligPt(var51);
                        if (this.devisLigneVentes.getDvsligTauxTaxe() != 0.0F) {
                           var53 = this.utilNombre.myRoundDevise(this.devisLigneVentes.getDvsligPt() * (double)this.devisLigneVentes.getDvsligTauxTaxe() / 100.0D, this.devisEnteteVentes.getDvsDevise());
                           this.devisLigneVentes.setDvsligTva(var53);
                        } else {
                           this.devisLigneVentes.setDvsligTva(0.0D);
                        }

                        this.devisLigneVentes.setDvsligTtc(this.devisLigneVentes.getDvsligPt() + this.devisLigneVentes.getDvsligTva());
                        this.devisLigneVentes = this.devisLigneVentesDao.insertLigne(this.devisLigneVentes, var46);
                        var46.flush();
                     } else {
                        this.transfertVentes.setTrfNomFeuille("le devis " + var50 + " n`existe pas.");
                        this.lesErreurs.add(this.transfertVentes);
                     }
                  }
               }
            }

            var47.commit();
         } catch (HibernateException var58) {
            if (var47 != null) {
               var47.rollback();
            }

            throw var58;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.datamodelDocument.setWrappedData(this.lesErreurs);
         this.var_affiche_bouton = false;
         this.balance = 2;
         this.var_showBarProgMaj = false;
      }

   }

   public void importCommandeLibre() throws HibernateException, NamingException, java.text.ParseException, JDOMException, IOException {
      this.lesErreurs.clear();
      if (this.lesTransfertVentes.size() != 0) {
         this.var_showBarProgMaj = true;
         this.var_currentValue = 0;
         this.var_info = "Chargement des elements de base...";
         boolean var1 = false;
         this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
         this.famillesProduitsAchats = new FamillesProduitsAchats();
         this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
         this.famillesProduitsVentes = new FamillesProduitsVentes();
         this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         this.produits = new Produits();
         this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
         this.produitsDepot = new ProduitsDepot();
         LectureFamillesClients var2 = new LectureFamillesClients();
         var2.setStrId(this.structureLog.getStrid());
         var2.setStructureLog(this.structureLog);
         this.mesFamillesClientsItems = var2.chargerMesFamillesClientItems();
         this.commandeEnteteVentes = new CommandeEnteteVentes();
         this.commandeEnteteVentesDao = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         this.commandeLigneVentes = new CommandeLigneVentes();
         this.commandeLigneVentesDao = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
         this.taxesVentes = new TaxesVentes();
         this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
         this.tiers = new Tiers();
         this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
         String var3 = "";
         String var4 = "";
         String var5 = "";
         String var6 = "";
         String var7 = "";
         String var8 = "";
         String var9 = "";
         String var10 = "";
         String var11 = "";
         String var12 = "";
         String var13 = "";
         String var14 = "";
         String var15 = "";
         String var16 = "";
         String var17 = "";
         String var18 = "";
         String var19 = "";
         String var20 = "";
         String var21 = "";
         String var22 = "";
         String var23 = "";
         String var24 = "";
         String var25 = "";
         String var26 = "";
         String var27 = "";
         String var28 = "";
         String var29 = "";
         String var30 = "";
         String var31 = "";
         String var32 = "";
         String var33 = "";
         String var34 = "";
         String var35 = "";
         String var36 = "";
         String var37 = "";
         String var38 = "";
         String var39 = "";
         String var40 = "";
         String var41 = "";
         String var42 = "";
         String var43 = "";
         String var44 = "";
         String var45 = "";
         Session var46 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
         Transaction var47 = null;

         try {
            var47 = var46.beginTransaction();
            var46.setFlushMode(FlushMode.MANUAL);

            for(int var48 = 0; var48 < this.lesTransfertVentes.size(); ++var48) {
               this.transfertVentes = (TransfertVentes)this.lesTransfertVentes.get(var48);
               this.var_info = "Element " + var48 + " - Nb elements : " + this.lesTransfertVentes.size();
               double var51;
               double var53;
               if (var48 != 0) {
                  double var49 = (double)this.lesTransfertVentes.size();
                  var51 = this.utilNombre.myRound(var49 / (double)var48, 4);
                  var53 = this.utilNombre.myRound(100.0D / var51, 2);
                  this.var_currentValue = (int)var53;
               }

               if (var48 == 0) {
                  var5 = this.transfertVentes.getTrfColT00();
                  var6 = this.transfertVentes.getTrfColT01();
                  var7 = this.transfertVentes.getTrfColT02();
                  var8 = this.transfertVentes.getTrfColT03();
                  var9 = this.transfertVentes.getTrfColT04();
                  var10 = this.transfertVentes.getTrfColT05();
                  var11 = this.transfertVentes.getTrfColT06();
                  var12 = this.transfertVentes.getTrfColT07();
                  var13 = this.transfertVentes.getTrfColT08();
                  var14 = this.transfertVentes.getTrfColT09();
                  var15 = this.transfertVentes.getTrfColT10();
                  var16 = this.transfertVentes.getTrfColT11();
                  var17 = this.transfertVentes.getTrfColT12();
                  var18 = this.transfertVentes.getTrfColT13();
                  var19 = this.transfertVentes.getTrfColT14();
                  var20 = this.transfertVentes.getTrfColT15();
                  var21 = this.transfertVentes.getTrfColT16();
                  var22 = this.transfertVentes.getTrfColT17();
                  var23 = this.transfertVentes.getTrfColT18();
                  var24 = this.transfertVentes.getTrfColT19();
                  var25 = this.transfertVentes.getTrfColT20();
                  var26 = this.transfertVentes.getTrfColT21();
                  var27 = this.transfertVentes.getTrfColT22();
                  var28 = this.transfertVentes.getTrfColT23();
                  var29 = this.transfertVentes.getTrfColT24();
                  var30 = this.transfertVentes.getTrfColT25();
                  var31 = this.transfertVentes.getTrfColT26();
                  var32 = this.transfertVentes.getTrfColT27();
                  var33 = this.transfertVentes.getTrfColT28();
                  var34 = this.transfertVentes.getTrfColT29();
                  var35 = this.transfertVentes.getTrfColT30();
                  var36 = this.transfertVentes.getTrfColT31();
                  var37 = this.transfertVentes.getTrfColT32();
                  var38 = this.transfertVentes.getTrfColT33();
                  var39 = this.transfertVentes.getTrfColT34();
                  var40 = this.transfertVentes.getTrfColT35();
                  var41 = this.transfertVentes.getTrfColT36();
                  var42 = this.transfertVentes.getTrfColT37();
                  var43 = this.transfertVentes.getTrfColT38();
                  var44 = this.transfertVentes.getTrfColT39();
                  var45 = this.transfertVentes.getTrfColT40();
               } else {
                  this.commandeEnteteVentes = null;
                  this.commandeLigneVentes = null;
                  if (var5.contains("bcm_")) {
                     if (var6.contains("tie_id")) {
                        this.recherhceClient(this.transfertVentes.getTrfColT01(), var46);
                     }

                     if (this.tiers == null) {
                        this.transfertVentes.setTrfNomFeuille("le client " + this.transfertVentes.getTrfColT01() + " n`existe pas.");
                        this.lesErreurs.add(this.transfertVentes);
                     } else {
                        if (var5 != null && !var5.isEmpty()) {
                           this.calculeRubCommandeEntete(var5, this.transfertVentes.getTrfColT00(), var46);
                        }

                        if (var7 != null && !var7.isEmpty()) {
                           this.calculeRubCommandeEntete(var7, this.transfertVentes.getTrfColT02(), var46);
                        }

                        if (var8 != null && !var8.isEmpty()) {
                           this.calculeRubCommandeEntete(var8, this.transfertVentes.getTrfColT03(), var46);
                        }

                        if (var9 != null && !var9.isEmpty()) {
                           this.calculeRubCommandeEntete(var9, this.transfertVentes.getTrfColT04(), var46);
                        }

                        if (var10 != null && !var10.isEmpty()) {
                           this.calculeRubCommandeEntete(var10, this.transfertVentes.getTrfColT05(), var46);
                        }

                        if (var11 != null && !var11.isEmpty()) {
                           this.calculeRubCommandeEntete(var11, this.transfertVentes.getTrfColT06(), var46);
                        }

                        if (var12 != null && !var12.isEmpty()) {
                           this.calculeRubCommandeEntete(var12, this.transfertVentes.getTrfColT07(), var46);
                        }

                        if (var13 != null && !var13.isEmpty()) {
                           this.calculeRubCommandeEntete(var13, this.transfertVentes.getTrfColT08(), var46);
                        }

                        if (var14 != null && !var14.isEmpty()) {
                           this.calculeRubCommandeEntete(var14, this.transfertVentes.getTrfColT09(), var46);
                        }

                        if (var15 != null && !var15.isEmpty()) {
                           this.calculeRubCommandeEntete(var15, this.transfertVentes.getTrfColT10(), var46);
                        }

                        if (var16 != null && !var16.isEmpty()) {
                           this.calculeRubCommandeEntete(var16, this.transfertVentes.getTrfColT11(), var46);
                        }

                        if (var17 != null && !var17.isEmpty()) {
                           this.calculeRubCommandeEntete(var17, this.transfertVentes.getTrfColT12(), var46);
                        }

                        if (var18 != null && !var18.isEmpty()) {
                           this.calculeRubCommandeEntete(var18, this.transfertVentes.getTrfColT13(), var46);
                        }

                        if (var19 != null && !var19.isEmpty()) {
                           this.calculeRubCommandeEntete(var19, this.transfertVentes.getTrfColT14(), var46);
                        }

                        if (var20 != null && !var20.isEmpty()) {
                           this.calculeRubCommandeEntete(var20, this.transfertVentes.getTrfColT15(), var46);
                        }

                        if (var21 != null && !var21.isEmpty()) {
                           this.calculeRubCommandeEntete(var21, this.transfertVentes.getTrfColT16(), var46);
                        }

                        if (var22 != null && !var22.isEmpty()) {
                           this.calculeRubCommandeEntete(var22, this.transfertVentes.getTrfColT17(), var46);
                        }

                        if (var23 != null && !var23.isEmpty()) {
                           this.calculeRubCommandeEntete(var23, this.transfertVentes.getTrfColT18(), var46);
                        }

                        if (var24 != null && !var24.isEmpty()) {
                           this.calculeRubCommandeEntete(var24, this.transfertVentes.getTrfColT19(), var46);
                        }

                        if (var25 != null && !var25.isEmpty()) {
                           this.calculeRubCommandeEntete(var25, this.transfertVentes.getTrfColT20(), var46);
                        }

                        if (var26 != null && !var26.isEmpty()) {
                           this.calculeRubCommandeEntete(var26, this.transfertVentes.getTrfColT21(), var46);
                        }

                        if (var27 != null && !var27.isEmpty()) {
                           this.calculeRubCommandeEntete(var27, this.transfertVentes.getTrfColT22(), var46);
                        }

                        if (var28 != null && !var28.isEmpty()) {
                           this.calculeRubCommandeEntete(var28, this.transfertVentes.getTrfColT23(), var46);
                        }

                        if (var29 != null && !var29.isEmpty()) {
                           this.calculeRubCommandeEntete(var29, this.transfertVentes.getTrfColT24(), var46);
                        }

                        if (var30 != null && !var30.isEmpty()) {
                           this.calculeRubCommandeEntete(var30, this.transfertVentes.getTrfColT25(), var46);
                        }

                        if (var31 != null && !var31.isEmpty()) {
                           this.calculeRubCommandeEntete(var31, this.transfertVentes.getTrfColT26(), var46);
                        }

                        if (var32 != null && !var32.isEmpty()) {
                           this.calculeRubCommandeEntete(var32, this.transfertVentes.getTrfColT27(), var46);
                        }

                        if (var33 != null && !var33.isEmpty()) {
                           this.calculeRubCommandeEntete(var33, this.transfertVentes.getTrfColT28(), var46);
                        }

                        if (var34 != null && !var34.isEmpty()) {
                           this.calculeRubCommandeEntete(var34, this.transfertVentes.getTrfColT29(), var46);
                        }

                        if (var35 != null && !var35.isEmpty()) {
                           this.calculeRubCommandeEntete(var35, this.transfertVentes.getTrfColT30(), var46);
                        }

                        if (var36 != null && !var36.isEmpty()) {
                           this.calculeRubCommandeEntete(var36, this.transfertVentes.getTrfColT31(), var46);
                        }

                        if (var37 != null && !var37.isEmpty()) {
                           this.calculeRubCommandeEntete(var37, this.transfertVentes.getTrfColT32(), var46);
                        }

                        if (var38 != null && !var38.isEmpty()) {
                           this.calculeRubCommandeEntete(var38, this.transfertVentes.getTrfColT33(), var46);
                        }

                        if (var39 != null && !var39.isEmpty()) {
                           this.calculeRubCommandeEntete(var39, this.transfertVentes.getTrfColT34(), var46);
                        }

                        if (var40 != null && !var40.isEmpty()) {
                           this.calculeRubCommandeEntete(var40, this.transfertVentes.getTrfColT35(), var46);
                        }

                        if (var41 != null && !var41.isEmpty()) {
                           this.calculeRubCommandeEntete(var41, this.transfertVentes.getTrfColT36(), var46);
                        }

                        if (var42 != null && !var42.isEmpty()) {
                           this.calculeRubCommandeEntete(var42, this.transfertVentes.getTrfColT37(), var46);
                        }

                        if (var43 != null && !var43.isEmpty()) {
                           this.calculeRubCommandeEntete(var43, this.transfertVentes.getTrfColT38(), var46);
                        }

                        if (var44 != null && !var44.isEmpty()) {
                           this.calculeRubCommandeEntete(var44, this.transfertVentes.getTrfColT39(), var46);
                        }

                        if (var45 != null && !var45.isEmpty()) {
                           this.calculeRubCommandeEntete(var45, this.transfertVentes.getTrfColT40(), var46);
                        }

                        if (this.commandeEnteteVentes.getBcmId() == 0L) {
                           this.commandeEnteteVentes.setExerciceventes(this.exercicesVentes);
                           this.commandeEnteteVentes.setUsers(this.usersLog);
                           this.commandeEnteteVentes.setTiers(this.tiers);
                           this.commandeEnteteVentes.setBcmCivilTiers(this.tiers.getTiecivilite());
                           this.commandeEnteteVentes.setBcmCat(this.tiers.getTiecategorie());
                           this.commandeEnteteVentes.setBcmExoDouane(this.tiers.getTieexodouane());
                           this.commandeEnteteVentes.setBcmExoTva(this.tiers.getTieexotva());
                           this.commandeEnteteVentes.setBcmNomTiers(this.tiers.getTieraisonsocialenom());
                           if (this.commandeEnteteVentes.getBcmDevise() == null || this.commandeEnteteVentes.getBcmDevise().isEmpty()) {
                              this.commandeEnteteVentes.setBcmDevise(this.structureLog.getStrdevise());
                           }

                           if (this.commandeEnteteVentes.getBcmSerie() == null || this.commandeEnteteVentes.getBcmSerie().isEmpty()) {
                              this.commandeEnteteVentes.setBcmSerie("A");
                           }

                           this.commandeEnteteVentes = this.commandeEnteteVentesDao.insert(this.commandeEnteteVentes, var46);
                        } else {
                           this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var46);
                           this.commandeLigneVentesDao.deleteAllLigne(this.commandeEnteteVentes, var46);
                        }

                        var46.flush();
                     }
                  } else if (var5.contains("bcmlig_")) {
                     this.commandeEnteteVentes = null;
                     String var50 = "";
                     if (this.transfertVentes.getTrfColT01() != null && !this.transfertVentes.getTrfColT01().isEmpty()) {
                        var50 = this.enlevePoint(this.transfertVentes.getTrfColT01()).toUpperCase();
                        this.commandeEnteteVentes = this.commandeEnteteVentesDao.pourParapheurByNum(var50, (String)null, var46);
                     }

                     if (this.commandeEnteteVentes != null) {
                        this.commandeLigneVentes = new CommandeLigneVentes();
                        if (var5 != null && !var5.isEmpty()) {
                           this.calculeRubCommandeLigne(var5, this.transfertVentes.getTrfColT00(), var46);
                        }

                        if (var7 != null && !var7.isEmpty()) {
                           this.calculeRubCommandeLigne(var7, this.transfertVentes.getTrfColT02(), var46);
                        }

                        if (var8 != null && !var8.isEmpty()) {
                           this.calculeRubCommandeLigne(var8, this.transfertVentes.getTrfColT03(), var46);
                        }

                        if (var9 != null && !var9.isEmpty()) {
                           this.calculeRubCommandeLigne(var9, this.transfertVentes.getTrfColT04(), var46);
                        }

                        if (var10 != null && !var10.isEmpty()) {
                           this.calculeRubCommandeLigne(var10, this.transfertVentes.getTrfColT05(), var46);
                        }

                        if (var11 != null && !var11.isEmpty()) {
                           this.calculeRubCommandeLigne(var11, this.transfertVentes.getTrfColT06(), var46);
                        }

                        if (var12 != null && !var12.isEmpty()) {
                           this.calculeRubCommandeLigne(var12, this.transfertVentes.getTrfColT07(), var46);
                        }

                        if (var13 != null && !var13.isEmpty()) {
                           this.calculeRubCommandeLigne(var13, this.transfertVentes.getTrfColT08(), var46);
                        }

                        if (var14 != null && !var14.isEmpty()) {
                           this.calculeRubCommandeLigne(var14, this.transfertVentes.getTrfColT09(), var46);
                        }

                        if (var15 != null && !var15.isEmpty()) {
                           this.calculeRubCommandeLigne(var15, this.transfertVentes.getTrfColT10(), var46);
                        }

                        if (var16 != null && !var16.isEmpty()) {
                           this.calculeRubCommandeLigne(var16, this.transfertVentes.getTrfColT11(), var46);
                        }

                        if (var17 != null && !var17.isEmpty()) {
                           this.calculeRubCommandeLigne(var17, this.transfertVentes.getTrfColT12(), var46);
                        }

                        if (var18 != null && !var18.isEmpty()) {
                           this.calculeRubCommandeLigne(var18, this.transfertVentes.getTrfColT13(), var46);
                        }

                        if (var19 != null && !var19.isEmpty()) {
                           this.calculeRubCommandeLigne(var19, this.transfertVentes.getTrfColT14(), var46);
                        }

                        if (var20 != null && !var20.isEmpty()) {
                           this.calculeRubCommandeLigne(var20, this.transfertVentes.getTrfColT15(), var46);
                        }

                        if (var21 != null && !var21.isEmpty()) {
                           this.calculeRubCommandeLigne(var21, this.transfertVentes.getTrfColT16(), var46);
                        }

                        if (var22 != null && !var22.isEmpty()) {
                           this.calculeRubCommandeLigne(var22, this.transfertVentes.getTrfColT17(), var46);
                        }

                        if (var23 != null && !var23.isEmpty()) {
                           this.calculeRubCommandeLigne(var23, this.transfertVentes.getTrfColT18(), var46);
                        }

                        if (var24 != null && !var24.isEmpty()) {
                           this.calculeRubCommandeLigne(var24, this.transfertVentes.getTrfColT19(), var46);
                        }

                        if (var25 != null && !var25.isEmpty()) {
                           this.calculeRubCommandeLigne(var25, this.transfertVentes.getTrfColT20(), var46);
                        }

                        if (var26 != null && !var26.isEmpty()) {
                           this.calculeRubCommandeLigne(var26, this.transfertVentes.getTrfColT21(), var46);
                        }

                        if (var27 != null && !var27.isEmpty()) {
                           this.calculeRubCommandeLigne(var27, this.transfertVentes.getTrfColT22(), var46);
                        }

                        if (var28 != null && !var28.isEmpty()) {
                           this.calculeRubCommandeLigne(var28, this.transfertVentes.getTrfColT23(), var46);
                        }

                        if (var29 != null && !var29.isEmpty()) {
                           this.calculeRubCommandeLigne(var29, this.transfertVentes.getTrfColT24(), var46);
                        }

                        if (var30 != null && !var30.isEmpty()) {
                           this.calculeRubCommandeLigne(var30, this.transfertVentes.getTrfColT25(), var46);
                        }

                        if (var31 != null && !var31.isEmpty()) {
                           this.calculeRubCommandeLigne(var31, this.transfertVentes.getTrfColT26(), var46);
                        }

                        if (var32 != null && !var32.isEmpty()) {
                           this.calculeRubCommandeLigne(var32, this.transfertVentes.getTrfColT27(), var46);
                        }

                        if (var33 != null && !var33.isEmpty()) {
                           this.calculeRubCommandeLigne(var33, this.transfertVentes.getTrfColT28(), var46);
                        }

                        if (var34 != null && !var34.isEmpty()) {
                           this.calculeRubCommandeLigne(var34, this.transfertVentes.getTrfColT29(), var46);
                        }

                        if (var35 != null && !var35.isEmpty()) {
                           this.calculeRubCommandeLigne(var35, this.transfertVentes.getTrfColT30(), var46);
                        }

                        if (var36 != null && !var36.isEmpty()) {
                           this.calculeRubCommandeLigne(var36, this.transfertVentes.getTrfColT31(), var46);
                        }

                        if (var37 != null && !var37.isEmpty()) {
                           this.calculeRubCommandeLigne(var37, this.transfertVentes.getTrfColT32(), var46);
                        }

                        if (var38 != null && !var38.isEmpty()) {
                           this.calculeRubCommandeLigne(var38, this.transfertVentes.getTrfColT33(), var46);
                        }

                        if (var39 != null && !var39.isEmpty()) {
                           this.calculeRubCommandeLigne(var39, this.transfertVentes.getTrfColT34(), var46);
                        }

                        if (var40 != null && !var40.isEmpty()) {
                           this.calculeRubCommandeLigne(var40, this.transfertVentes.getTrfColT35(), var46);
                        }

                        if (var41 != null && !var41.isEmpty()) {
                           this.calculeRubCommandeLigne(var41, this.transfertVentes.getTrfColT36(), var46);
                        }

                        if (var42 != null && !var42.isEmpty()) {
                           this.calculeRubCommandeLigne(var42, this.transfertVentes.getTrfColT37(), var46);
                        }

                        if (var43 != null && !var43.isEmpty()) {
                           this.calculeRubCommandeLigne(var43, this.transfertVentes.getTrfColT38(), var46);
                        }

                        if (var44 != null && !var44.isEmpty()) {
                           this.calculeRubCommandeLigne(var44, this.transfertVentes.getTrfColT39(), var46);
                        }

                        if (var45 != null && !var45.isEmpty()) {
                           this.calculeRubCommandeLigne(var45, this.transfertVentes.getTrfColT40(), var46);
                        }

                        this.commandeLigneVentes.setCommandeEnteteVentes(this.commandeEnteteVentes);
                        this.commandeLigneVentes.setBcmligEntStock(this.commandeEnteteVentes.getBcmStock());
                        if (this.commandeLigneVentes.getBcmligTauxRemise() != 0.0F) {
                           var51 = this.utilNombre.myRoundDevise(this.commandeLigneVentes.getBcmligPu() * (double)this.commandeLigneVentes.getBcmligTauxRemise() / 100.0D, this.commandeEnteteVentes.getBcmDevise());
                           this.commandeLigneVentes.setBcmligPuRem(this.commandeLigneVentes.getBcmligPu() - var51);
                        } else {
                           this.commandeLigneVentes.setBcmligPuRem(this.commandeLigneVentes.getBcmligPu());
                        }

                        var51 = this.utilNombre.myRoundDevise(this.commandeLigneVentes.getBcmligPuRem() * (double)this.commandeLigneVentes.getBcmligQte(), this.commandeEnteteVentes.getBcmDevise());
                        this.commandeLigneVentes.setBcmligPt(var51);
                        if (this.commandeLigneVentes.getBcmligTauxTaxe() != 0.0F) {
                           var53 = this.utilNombre.myRoundDevise(this.commandeLigneVentes.getBcmligPt() * (double)this.commandeLigneVentes.getBcmligTauxTaxe() / 100.0D, this.commandeEnteteVentes.getBcmDevise());
                           this.commandeLigneVentes.setBcmligTva(var53);
                        } else {
                           this.commandeLigneVentes.setBcmligTva(0.0D);
                        }

                        this.commandeLigneVentes.setBcmligTtc(this.commandeLigneVentes.getBcmligPt() + this.commandeLigneVentes.getBcmligTva());
                        this.commandeLigneVentes = this.commandeLigneVentesDao.insertLigne(this.commandeLigneVentes, var46);
                        var46.flush();
                     } else {
                        this.transfertVentes.setTrfNomFeuille("la commande " + var50 + " n`existe pas.");
                        this.lesErreurs.add(this.transfertVentes);
                     }
                  }
               }
            }

            var47.commit();
         } catch (HibernateException var58) {
            if (var47 != null) {
               var47.rollback();
            }

            throw var58;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.datamodelDocument.setWrappedData(this.lesErreurs);
         this.var_affiche_bouton = false;
         this.balance = 2;
         this.var_showBarProgMaj = false;
      }

   }

   public void importLivraisonLibre() throws HibernateException, NamingException, java.text.ParseException, JDOMException, IOException {
      this.lesErreurs.clear();
      if (this.lesTransfertVentes.size() != 0) {
         this.var_showBarProgMaj = true;
         this.var_currentValue = 0;
         this.var_info = "Chargement des elements de base...";
         boolean var1 = false;
         this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
         this.famillesProduitsAchats = new FamillesProduitsAchats();
         this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
         this.famillesProduitsVentes = new FamillesProduitsVentes();
         this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         this.produits = new Produits();
         this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
         this.produitsDepot = new ProduitsDepot();
         LectureFamillesClients var2 = new LectureFamillesClients();
         var2.setStrId(this.structureLog.getStrid());
         var2.setStructureLog(this.structureLog);
         this.mesFamillesClientsItems = var2.chargerMesFamillesClientItems();
         this.livraisonEnteteVentes = new LivraisonEnteteVentes();
         this.livraisonEnteteVentesDao = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         this.livraisonLigneVentes = new LivraisonLigneVentes();
         this.livraisonLigneVentesDao = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
         this.taxesVentes = new TaxesVentes();
         this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
         this.tiers = new Tiers();
         this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
         String var3 = "";
         String var4 = "";
         String var5 = "";
         String var6 = "";
         String var7 = "";
         String var8 = "";
         String var9 = "";
         String var10 = "";
         String var11 = "";
         String var12 = "";
         String var13 = "";
         String var14 = "";
         String var15 = "";
         String var16 = "";
         String var17 = "";
         String var18 = "";
         String var19 = "";
         String var20 = "";
         String var21 = "";
         String var22 = "";
         String var23 = "";
         String var24 = "";
         String var25 = "";
         String var26 = "";
         String var27 = "";
         String var28 = "";
         String var29 = "";
         String var30 = "";
         String var31 = "";
         String var32 = "";
         String var33 = "";
         String var34 = "";
         String var35 = "";
         String var36 = "";
         String var37 = "";
         String var38 = "";
         String var39 = "";
         String var40 = "";
         String var41 = "";
         String var42 = "";
         String var43 = "";
         String var44 = "";
         String var45 = "";
         Session var46 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEnteteLight");
         Transaction var47 = null;

         try {
            var47 = var46.beginTransaction();
            var46.setFlushMode(FlushMode.MANUAL);

            for(int var48 = 0; var48 < this.lesTransfertVentes.size(); ++var48) {
               this.transfertVentes = (TransfertVentes)this.lesTransfertVentes.get(var48);
               this.var_info = "Element " + var48 + " - Nb elements : " + this.lesTransfertVentes.size();
               double var51;
               double var53;
               if (var48 != 0) {
                  double var49 = (double)this.lesTransfertVentes.size();
                  var51 = this.utilNombre.myRound(var49 / (double)var48, 4);
                  var53 = this.utilNombre.myRound(100.0D / var51, 2);
                  this.var_currentValue = (int)var53;
               }

               if (var48 == 0) {
                  var5 = this.transfertVentes.getTrfColT00();
                  var6 = this.transfertVentes.getTrfColT01();
                  var7 = this.transfertVentes.getTrfColT02();
                  var8 = this.transfertVentes.getTrfColT03();
                  var9 = this.transfertVentes.getTrfColT04();
                  var10 = this.transfertVentes.getTrfColT05();
                  var11 = this.transfertVentes.getTrfColT06();
                  var12 = this.transfertVentes.getTrfColT07();
                  var13 = this.transfertVentes.getTrfColT08();
                  var14 = this.transfertVentes.getTrfColT09();
                  var15 = this.transfertVentes.getTrfColT10();
                  var16 = this.transfertVentes.getTrfColT11();
                  var17 = this.transfertVentes.getTrfColT12();
                  var18 = this.transfertVentes.getTrfColT13();
                  var19 = this.transfertVentes.getTrfColT14();
                  var20 = this.transfertVentes.getTrfColT15();
                  var21 = this.transfertVentes.getTrfColT16();
                  var22 = this.transfertVentes.getTrfColT17();
                  var23 = this.transfertVentes.getTrfColT18();
                  var24 = this.transfertVentes.getTrfColT19();
                  var25 = this.transfertVentes.getTrfColT20();
                  var26 = this.transfertVentes.getTrfColT21();
                  var27 = this.transfertVentes.getTrfColT22();
                  var28 = this.transfertVentes.getTrfColT23();
                  var29 = this.transfertVentes.getTrfColT24();
                  var30 = this.transfertVentes.getTrfColT25();
                  var31 = this.transfertVentes.getTrfColT26();
                  var32 = this.transfertVentes.getTrfColT27();
                  var33 = this.transfertVentes.getTrfColT28();
                  var34 = this.transfertVentes.getTrfColT29();
                  var35 = this.transfertVentes.getTrfColT30();
                  var36 = this.transfertVentes.getTrfColT31();
                  var37 = this.transfertVentes.getTrfColT32();
                  var38 = this.transfertVentes.getTrfColT33();
                  var39 = this.transfertVentes.getTrfColT34();
                  var40 = this.transfertVentes.getTrfColT35();
                  var41 = this.transfertVentes.getTrfColT36();
                  var42 = this.transfertVentes.getTrfColT37();
                  var43 = this.transfertVentes.getTrfColT38();
                  var44 = this.transfertVentes.getTrfColT39();
                  var45 = this.transfertVentes.getTrfColT40();
               } else {
                  this.commandeEnteteVentes = null;
                  this.commandeLigneVentes = null;
                  if (var5.contains("blv_")) {
                     if (var6.contains("tie_id")) {
                        this.recherhceClient(this.transfertVentes.getTrfColT01(), var46);
                     }

                     if (this.tiers == null) {
                        this.transfertVentes.setTrfNomFeuille("le client " + this.transfertVentes.getTrfColT01() + " n`existe pas.");
                        this.lesErreurs.add(this.transfertVentes);
                     } else {
                        if (var5 != null && !var5.isEmpty()) {
                           this.calculeRubLivraisonEntete(var5, this.transfertVentes.getTrfColT00(), var46);
                        }

                        if (var7 != null && !var7.isEmpty()) {
                           this.calculeRubLivraisonEntete(var7, this.transfertVentes.getTrfColT02(), var46);
                        }

                        if (var8 != null && !var8.isEmpty()) {
                           this.calculeRubLivraisonEntete(var8, this.transfertVentes.getTrfColT03(), var46);
                        }

                        if (var9 != null && !var9.isEmpty()) {
                           this.calculeRubLivraisonEntete(var9, this.transfertVentes.getTrfColT04(), var46);
                        }

                        if (var10 != null && !var10.isEmpty()) {
                           this.calculeRubLivraisonEntete(var10, this.transfertVentes.getTrfColT05(), var46);
                        }

                        if (var11 != null && !var11.isEmpty()) {
                           this.calculeRubLivraisonEntete(var11, this.transfertVentes.getTrfColT06(), var46);
                        }

                        if (var12 != null && !var12.isEmpty()) {
                           this.calculeRubLivraisonEntete(var12, this.transfertVentes.getTrfColT07(), var46);
                        }

                        if (var13 != null && !var13.isEmpty()) {
                           this.calculeRubLivraisonEntete(var13, this.transfertVentes.getTrfColT08(), var46);
                        }

                        if (var14 != null && !var14.isEmpty()) {
                           this.calculeRubLivraisonEntete(var14, this.transfertVentes.getTrfColT09(), var46);
                        }

                        if (var15 != null && !var15.isEmpty()) {
                           this.calculeRubLivraisonEntete(var15, this.transfertVentes.getTrfColT10(), var46);
                        }

                        if (var16 != null && !var16.isEmpty()) {
                           this.calculeRubLivraisonEntete(var16, this.transfertVentes.getTrfColT11(), var46);
                        }

                        if (var17 != null && !var17.isEmpty()) {
                           this.calculeRubLivraisonEntete(var17, this.transfertVentes.getTrfColT12(), var46);
                        }

                        if (var18 != null && !var18.isEmpty()) {
                           this.calculeRubLivraisonEntete(var18, this.transfertVentes.getTrfColT13(), var46);
                        }

                        if (var19 != null && !var19.isEmpty()) {
                           this.calculeRubLivraisonEntete(var19, this.transfertVentes.getTrfColT14(), var46);
                        }

                        if (var20 != null && !var20.isEmpty()) {
                           this.calculeRubLivraisonEntete(var20, this.transfertVentes.getTrfColT15(), var46);
                        }

                        if (var21 != null && !var21.isEmpty()) {
                           this.calculeRubLivraisonEntete(var21, this.transfertVentes.getTrfColT16(), var46);
                        }

                        if (var22 != null && !var22.isEmpty()) {
                           this.calculeRubLivraisonEntete(var22, this.transfertVentes.getTrfColT17(), var46);
                        }

                        if (var23 != null && !var23.isEmpty()) {
                           this.calculeRubLivraisonEntete(var23, this.transfertVentes.getTrfColT18(), var46);
                        }

                        if (var24 != null && !var24.isEmpty()) {
                           this.calculeRubLivraisonEntete(var24, this.transfertVentes.getTrfColT19(), var46);
                        }

                        if (var25 != null && !var25.isEmpty()) {
                           this.calculeRubLivraisonEntete(var25, this.transfertVentes.getTrfColT20(), var46);
                        }

                        if (var26 != null && !var26.isEmpty()) {
                           this.calculeRubLivraisonEntete(var26, this.transfertVentes.getTrfColT21(), var46);
                        }

                        if (var27 != null && !var27.isEmpty()) {
                           this.calculeRubLivraisonEntete(var27, this.transfertVentes.getTrfColT22(), var46);
                        }

                        if (var28 != null && !var28.isEmpty()) {
                           this.calculeRubLivraisonEntete(var28, this.transfertVentes.getTrfColT23(), var46);
                        }

                        if (var29 != null && !var29.isEmpty()) {
                           this.calculeRubLivraisonEntete(var29, this.transfertVentes.getTrfColT24(), var46);
                        }

                        if (var30 != null && !var30.isEmpty()) {
                           this.calculeRubLivraisonEntete(var30, this.transfertVentes.getTrfColT25(), var46);
                        }

                        if (var31 != null && !var31.isEmpty()) {
                           this.calculeRubLivraisonEntete(var31, this.transfertVentes.getTrfColT26(), var46);
                        }

                        if (var32 != null && !var32.isEmpty()) {
                           this.calculeRubLivraisonEntete(var32, this.transfertVentes.getTrfColT27(), var46);
                        }

                        if (var33 != null && !var33.isEmpty()) {
                           this.calculeRubLivraisonEntete(var33, this.transfertVentes.getTrfColT28(), var46);
                        }

                        if (var34 != null && !var34.isEmpty()) {
                           this.calculeRubLivraisonEntete(var34, this.transfertVentes.getTrfColT29(), var46);
                        }

                        if (var35 != null && !var35.isEmpty()) {
                           this.calculeRubLivraisonEntete(var35, this.transfertVentes.getTrfColT30(), var46);
                        }

                        if (var36 != null && !var36.isEmpty()) {
                           this.calculeRubLivraisonEntete(var36, this.transfertVentes.getTrfColT31(), var46);
                        }

                        if (var37 != null && !var37.isEmpty()) {
                           this.calculeRubLivraisonEntete(var37, this.transfertVentes.getTrfColT32(), var46);
                        }

                        if (var38 != null && !var38.isEmpty()) {
                           this.calculeRubLivraisonEntete(var38, this.transfertVentes.getTrfColT33(), var46);
                        }

                        if (var39 != null && !var39.isEmpty()) {
                           this.calculeRubLivraisonEntete(var39, this.transfertVentes.getTrfColT34(), var46);
                        }

                        if (var40 != null && !var40.isEmpty()) {
                           this.calculeRubLivraisonEntete(var40, this.transfertVentes.getTrfColT35(), var46);
                        }

                        if (var41 != null && !var41.isEmpty()) {
                           this.calculeRubLivraisonEntete(var41, this.transfertVentes.getTrfColT36(), var46);
                        }

                        if (var42 != null && !var42.isEmpty()) {
                           this.calculeRubLivraisonEntete(var42, this.transfertVentes.getTrfColT37(), var46);
                        }

                        if (var43 != null && !var43.isEmpty()) {
                           this.calculeRubLivraisonEntete(var43, this.transfertVentes.getTrfColT38(), var46);
                        }

                        if (var44 != null && !var44.isEmpty()) {
                           this.calculeRubLivraisonEntete(var44, this.transfertVentes.getTrfColT39(), var46);
                        }

                        if (var45 != null && !var45.isEmpty()) {
                           this.calculeRubLivraisonEntete(var45, this.transfertVentes.getTrfColT40(), var46);
                        }

                        if (this.livraisonEnteteVentes.getBlvId() == 0L) {
                           this.livraisonEnteteVentes.setExerciceventes(this.exercicesVentes);
                           this.livraisonEnteteVentes.setUsers(this.usersLog);
                           this.livraisonEnteteVentes.setTiers(this.tiers);
                           this.livraisonEnteteVentes.setBlvCivilTiers(this.tiers.getTiecivilite());
                           this.livraisonEnteteVentes.setBlvCat(this.tiers.getTiecategorie());
                           this.livraisonEnteteVentes.setBlvExoDouane(this.tiers.getTieexodouane());
                           this.livraisonEnteteVentes.setBlvExoTva(this.tiers.getTieexotva());
                           this.livraisonEnteteVentes.setBlvNomTiers(this.tiers.getTieraisonsocialenom());
                           if (this.livraisonEnteteVentes.getBlvDevise() == null || this.livraisonEnteteVentes.getBlvDevise().isEmpty()) {
                              this.livraisonEnteteVentes.setBlvDevise(this.structureLog.getStrdevise());
                           }

                           if (this.livraisonEnteteVentes.getBlvSerie() == null || this.livraisonEnteteVentes.getBlvSerie().isEmpty()) {
                              this.livraisonEnteteVentes.setBlvSerie("A");
                           }

                           this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.insert(this.livraisonEnteteVentes, var46);
                        } else {
                           this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var46);
                           this.livraisonLigneVentesDao.deleteAllLigne(this.livraisonEnteteVentes, var46);
                        }

                        var46.flush();
                     }
                  } else if (var5.contains("blvlig_")) {
                     this.livraisonEnteteVentes = null;
                     String var50 = "";
                     if (this.transfertVentes.getTrfColT01() != null && !this.transfertVentes.getTrfColT01().isEmpty()) {
                        var50 = this.enlevePoint(this.transfertVentes.getTrfColT01()).toUpperCase();
                        this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.pourParapheurByNum(var50, (String)null, var46);
                     }

                     if (this.livraisonEnteteVentes != null) {
                        this.livraisonLigneVentes = new LivraisonLigneVentes();
                        if (var5 != null && !var5.isEmpty()) {
                           this.calculeRubLivraisonLigne(var5, this.transfertVentes.getTrfColT00(), var46);
                        }

                        if (var7 != null && !var7.isEmpty()) {
                           this.calculeRubLivraisonLigne(var7, this.transfertVentes.getTrfColT02(), var46);
                        }

                        if (var8 != null && !var8.isEmpty()) {
                           this.calculeRubLivraisonLigne(var8, this.transfertVentes.getTrfColT03(), var46);
                        }

                        if (var9 != null && !var9.isEmpty()) {
                           this.calculeRubLivraisonLigne(var9, this.transfertVentes.getTrfColT04(), var46);
                        }

                        if (var10 != null && !var10.isEmpty()) {
                           this.calculeRubLivraisonLigne(var10, this.transfertVentes.getTrfColT05(), var46);
                        }

                        if (var11 != null && !var11.isEmpty()) {
                           this.calculeRubLivraisonLigne(var11, this.transfertVentes.getTrfColT06(), var46);
                        }

                        if (var12 != null && !var12.isEmpty()) {
                           this.calculeRubLivraisonLigne(var12, this.transfertVentes.getTrfColT07(), var46);
                        }

                        if (var13 != null && !var13.isEmpty()) {
                           this.calculeRubLivraisonLigne(var13, this.transfertVentes.getTrfColT08(), var46);
                        }

                        if (var14 != null && !var14.isEmpty()) {
                           this.calculeRubLivraisonLigne(var14, this.transfertVentes.getTrfColT09(), var46);
                        }

                        if (var15 != null && !var15.isEmpty()) {
                           this.calculeRubLivraisonLigne(var15, this.transfertVentes.getTrfColT10(), var46);
                        }

                        if (var16 != null && !var16.isEmpty()) {
                           this.calculeRubLivraisonLigne(var16, this.transfertVentes.getTrfColT11(), var46);
                        }

                        if (var17 != null && !var17.isEmpty()) {
                           this.calculeRubLivraisonLigne(var17, this.transfertVentes.getTrfColT12(), var46);
                        }

                        if (var18 != null && !var18.isEmpty()) {
                           this.calculeRubLivraisonLigne(var18, this.transfertVentes.getTrfColT13(), var46);
                        }

                        if (var19 != null && !var19.isEmpty()) {
                           this.calculeRubLivraisonLigne(var19, this.transfertVentes.getTrfColT14(), var46);
                        }

                        if (var20 != null && !var20.isEmpty()) {
                           this.calculeRubLivraisonLigne(var20, this.transfertVentes.getTrfColT15(), var46);
                        }

                        if (var21 != null && !var21.isEmpty()) {
                           this.calculeRubLivraisonLigne(var21, this.transfertVentes.getTrfColT16(), var46);
                        }

                        if (var22 != null && !var22.isEmpty()) {
                           this.calculeRubLivraisonLigne(var22, this.transfertVentes.getTrfColT17(), var46);
                        }

                        if (var23 != null && !var23.isEmpty()) {
                           this.calculeRubLivraisonLigne(var23, this.transfertVentes.getTrfColT18(), var46);
                        }

                        if (var24 != null && !var24.isEmpty()) {
                           this.calculeRubLivraisonLigne(var24, this.transfertVentes.getTrfColT19(), var46);
                        }

                        if (var25 != null && !var25.isEmpty()) {
                           this.calculeRubLivraisonLigne(var25, this.transfertVentes.getTrfColT20(), var46);
                        }

                        if (var26 != null && !var26.isEmpty()) {
                           this.calculeRubLivraisonLigne(var26, this.transfertVentes.getTrfColT21(), var46);
                        }

                        if (var27 != null && !var27.isEmpty()) {
                           this.calculeRubLivraisonLigne(var27, this.transfertVentes.getTrfColT22(), var46);
                        }

                        if (var28 != null && !var28.isEmpty()) {
                           this.calculeRubLivraisonLigne(var28, this.transfertVentes.getTrfColT23(), var46);
                        }

                        if (var29 != null && !var29.isEmpty()) {
                           this.calculeRubLivraisonLigne(var29, this.transfertVentes.getTrfColT24(), var46);
                        }

                        if (var30 != null && !var30.isEmpty()) {
                           this.calculeRubLivraisonLigne(var30, this.transfertVentes.getTrfColT25(), var46);
                        }

                        if (var31 != null && !var31.isEmpty()) {
                           this.calculeRubLivraisonLigne(var31, this.transfertVentes.getTrfColT26(), var46);
                        }

                        if (var32 != null && !var32.isEmpty()) {
                           this.calculeRubLivraisonLigne(var32, this.transfertVentes.getTrfColT27(), var46);
                        }

                        if (var33 != null && !var33.isEmpty()) {
                           this.calculeRubLivraisonLigne(var33, this.transfertVentes.getTrfColT28(), var46);
                        }

                        if (var34 != null && !var34.isEmpty()) {
                           this.calculeRubLivraisonLigne(var34, this.transfertVentes.getTrfColT29(), var46);
                        }

                        if (var35 != null && !var35.isEmpty()) {
                           this.calculeRubLivraisonLigne(var35, this.transfertVentes.getTrfColT30(), var46);
                        }

                        if (var36 != null && !var36.isEmpty()) {
                           this.calculeRubLivraisonLigne(var36, this.transfertVentes.getTrfColT31(), var46);
                        }

                        if (var37 != null && !var37.isEmpty()) {
                           this.calculeRubLivraisonLigne(var37, this.transfertVentes.getTrfColT32(), var46);
                        }

                        if (var38 != null && !var38.isEmpty()) {
                           this.calculeRubLivraisonLigne(var38, this.transfertVentes.getTrfColT33(), var46);
                        }

                        if (var39 != null && !var39.isEmpty()) {
                           this.calculeRubLivraisonLigne(var39, this.transfertVentes.getTrfColT34(), var46);
                        }

                        if (var40 != null && !var40.isEmpty()) {
                           this.calculeRubLivraisonLigne(var40, this.transfertVentes.getTrfColT35(), var46);
                        }

                        if (var41 != null && !var41.isEmpty()) {
                           this.calculeRubLivraisonLigne(var41, this.transfertVentes.getTrfColT36(), var46);
                        }

                        if (var42 != null && !var42.isEmpty()) {
                           this.calculeRubLivraisonLigne(var42, this.transfertVentes.getTrfColT37(), var46);
                        }

                        if (var43 != null && !var43.isEmpty()) {
                           this.calculeRubLivraisonLigne(var43, this.transfertVentes.getTrfColT38(), var46);
                        }

                        if (var44 != null && !var44.isEmpty()) {
                           this.calculeRubLivraisonLigne(var44, this.transfertVentes.getTrfColT39(), var46);
                        }

                        if (var45 != null && !var45.isEmpty()) {
                           this.calculeRubLivraisonLigne(var45, this.transfertVentes.getTrfColT40(), var46);
                        }

                        this.livraisonLigneVentes.setLivraisonEnteteVentes(this.livraisonEnteteVentes);
                        this.livraisonLigneVentes.setBlvligEntStock(this.livraisonEnteteVentes.getBlvStock());
                        if (this.livraisonLigneVentes.getBlvligTauxRemise() != 0.0F) {
                           var51 = this.utilNombre.myRoundDevise(this.livraisonLigneVentes.getBlvligPu() * (double)this.livraisonLigneVentes.getBlvligTauxRemise() / 100.0D, this.livraisonEnteteVentes.getBlvDevise());
                           this.livraisonLigneVentes.setBlvligPuRem(this.livraisonLigneVentes.getBlvligPu() - var51);
                        } else {
                           this.livraisonLigneVentes.setBlvligPuRem(this.livraisonLigneVentes.getBlvligPu());
                        }

                        var51 = this.utilNombre.myRoundDevise(this.livraisonLigneVentes.getBlvligPuRem() * (double)this.livraisonLigneVentes.getBlvligQte(), this.livraisonEnteteVentes.getBlvDevise());
                        this.livraisonLigneVentes.setBlvligPt(var51);
                        if (this.livraisonLigneVentes.getBlvligTauxTaxe() != 0.0F) {
                           var53 = this.utilNombre.myRoundDevise(this.livraisonLigneVentes.getBlvligPt() * (double)this.livraisonLigneVentes.getBlvligTauxTaxe() / 100.0D, this.livraisonEnteteVentes.getBlvDevise());
                           this.livraisonLigneVentes.setBlvligTva(var53);
                        } else {
                           this.livraisonLigneVentes.setBlvligTva(0.0D);
                        }

                        this.livraisonLigneVentes.setBlvligTtc(this.livraisonLigneVentes.getBlvligPt() + this.livraisonLigneVentes.getBlvligTva());
                        this.livraisonLigneVentes = this.livraisonLigneVentesDao.insert(this.livraisonLigneVentes, var46);
                        var46.flush();
                     } else {
                        this.transfertVentes.setTrfNomFeuille("la livraison " + var50 + " n`existe pas.");
                        this.lesErreurs.add(this.transfertVentes);
                     }
                  }
               }
            }

            var47.commit();
         } catch (HibernateException var58) {
            if (var47 != null) {
               var47.rollback();
            }

            throw var58;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.datamodelDocument.setWrappedData(this.lesErreurs);
         this.var_affiche_bouton = false;
         this.balance = 2;
         this.var_showBarProgMaj = false;
      }

   }

   public void importFactureLibre() throws HibernateException, NamingException, java.text.ParseException, JDOMException, IOException {
      this.lesErreurs.clear();
      if (this.lesTransfertVentes.size() != 0) {
         this.var_showBarProgMaj = true;
         this.var_currentValue = 0;
         this.var_info = "Chargement des elements de base...";
         boolean var1 = false;
         this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
         this.famillesProduitsAchats = new FamillesProduitsAchats();
         this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
         this.famillesProduitsVentes = new FamillesProduitsVentes();
         this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         this.produits = new Produits();
         this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
         this.produitsDepot = new ProduitsDepot();
         LectureFamillesClients var2 = new LectureFamillesClients();
         var2.setStrId(this.structureLog.getStrid());
         var2.setStructureLog(this.structureLog);
         this.mesFamillesClientsItems = var2.chargerMesFamillesClientItems();
         this.factureEnteteVentes = new FactureEnteteVentes();
         this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         this.factureLigneVentes = new FactureLigneVentes();
         this.factureLigneVentesDao = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
         this.taxesVentes = new TaxesVentes();
         this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
         this.tiers = new Tiers();
         this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
         String var3 = "";
         String var4 = "";
         String var5 = "";
         String var6 = "";
         String var7 = "";
         String var8 = "";
         String var9 = "";
         String var10 = "";
         String var11 = "";
         String var12 = "";
         String var13 = "";
         String var14 = "";
         String var15 = "";
         String var16 = "";
         String var17 = "";
         String var18 = "";
         String var19 = "";
         String var20 = "";
         String var21 = "";
         String var22 = "";
         String var23 = "";
         String var24 = "";
         String var25 = "";
         String var26 = "";
         String var27 = "";
         String var28 = "";
         String var29 = "";
         String var30 = "";
         String var31 = "";
         String var32 = "";
         String var33 = "";
         String var34 = "";
         String var35 = "";
         String var36 = "";
         String var37 = "";
         String var38 = "";
         String var39 = "";
         String var40 = "";
         String var41 = "";
         String var42 = "";
         String var43 = "";
         String var44 = "";
         String var45 = "";
         Session var46 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         Transaction var47 = null;

         try {
            var47 = var46.beginTransaction();
            var46.setFlushMode(FlushMode.MANUAL);

            for(int var48 = 0; var48 < this.lesTransfertVentes.size(); ++var48) {
               this.transfertVentes = (TransfertVentes)this.lesTransfertVentes.get(var48);
               this.var_info = "Element " + var48 + " - Nb elements : " + this.lesTransfertVentes.size();
               double var51;
               double var53;
               if (var48 != 0) {
                  double var49 = (double)this.lesTransfertVentes.size();
                  var51 = this.utilNombre.myRound(var49 / (double)var48, 4);
                  var53 = this.utilNombre.myRound(100.0D / var51, 2);
                  this.var_currentValue = (int)var53;
               }

               if (var48 == 0) {
                  var5 = this.transfertVentes.getTrfColT00();
                  var6 = this.transfertVentes.getTrfColT01();
                  var7 = this.transfertVentes.getTrfColT02();
                  var8 = this.transfertVentes.getTrfColT03();
                  var9 = this.transfertVentes.getTrfColT04();
                  var10 = this.transfertVentes.getTrfColT05();
                  var11 = this.transfertVentes.getTrfColT06();
                  var12 = this.transfertVentes.getTrfColT07();
                  var13 = this.transfertVentes.getTrfColT08();
                  var14 = this.transfertVentes.getTrfColT09();
                  var15 = this.transfertVentes.getTrfColT10();
                  var16 = this.transfertVentes.getTrfColT11();
                  var17 = this.transfertVentes.getTrfColT12();
                  var18 = this.transfertVentes.getTrfColT13();
                  var19 = this.transfertVentes.getTrfColT14();
                  var20 = this.transfertVentes.getTrfColT15();
                  var21 = this.transfertVentes.getTrfColT16();
                  var22 = this.transfertVentes.getTrfColT17();
                  var23 = this.transfertVentes.getTrfColT18();
                  var24 = this.transfertVentes.getTrfColT19();
                  var25 = this.transfertVentes.getTrfColT20();
                  var26 = this.transfertVentes.getTrfColT21();
                  var27 = this.transfertVentes.getTrfColT22();
                  var28 = this.transfertVentes.getTrfColT23();
                  var29 = this.transfertVentes.getTrfColT24();
                  var30 = this.transfertVentes.getTrfColT25();
                  var31 = this.transfertVentes.getTrfColT26();
                  var32 = this.transfertVentes.getTrfColT27();
                  var33 = this.transfertVentes.getTrfColT28();
                  var34 = this.transfertVentes.getTrfColT29();
                  var35 = this.transfertVentes.getTrfColT30();
                  var36 = this.transfertVentes.getTrfColT31();
                  var37 = this.transfertVentes.getTrfColT32();
                  var38 = this.transfertVentes.getTrfColT33();
                  var39 = this.transfertVentes.getTrfColT34();
                  var40 = this.transfertVentes.getTrfColT35();
                  var41 = this.transfertVentes.getTrfColT36();
                  var42 = this.transfertVentes.getTrfColT37();
                  var43 = this.transfertVentes.getTrfColT38();
                  var44 = this.transfertVentes.getTrfColT39();
                  var45 = this.transfertVentes.getTrfColT40();
               } else {
                  this.factureEnteteVentes = null;
                  this.factureLigneVentes = null;
                  if (var5.contains("fac_")) {
                     if (var6.contains("tie_id")) {
                        this.recherhceClient(this.transfertVentes.getTrfColT01(), var46);
                     }

                     if (this.tiers == null) {
                        this.transfertVentes.setTrfNomFeuille("le client " + this.transfertVentes.getTrfColT01() + " n`existe pas.");
                        this.lesErreurs.add(this.transfertVentes);
                     } else {
                        if (var5 != null && !var5.isEmpty()) {
                           this.calculeRubFactureEntete(var5, this.transfertVentes.getTrfColT00(), var46);
                        }

                        if (var7 != null && !var7.isEmpty()) {
                           this.calculeRubFactureEntete(var7, this.transfertVentes.getTrfColT02(), var46);
                        }

                        if (var8 != null && !var8.isEmpty()) {
                           this.calculeRubFactureEntete(var8, this.transfertVentes.getTrfColT03(), var46);
                        }

                        if (var9 != null && !var9.isEmpty()) {
                           this.calculeRubFactureEntete(var9, this.transfertVentes.getTrfColT04(), var46);
                        }

                        if (var10 != null && !var10.isEmpty()) {
                           this.calculeRubFactureEntete(var10, this.transfertVentes.getTrfColT05(), var46);
                        }

                        if (var11 != null && !var11.isEmpty()) {
                           this.calculeRubFactureEntete(var11, this.transfertVentes.getTrfColT06(), var46);
                        }

                        if (var12 != null && !var12.isEmpty()) {
                           this.calculeRubFactureEntete(var12, this.transfertVentes.getTrfColT07(), var46);
                        }

                        if (var13 != null && !var13.isEmpty()) {
                           this.calculeRubFactureEntete(var13, this.transfertVentes.getTrfColT08(), var46);
                        }

                        if (var14 != null && !var14.isEmpty()) {
                           this.calculeRubFactureEntete(var14, this.transfertVentes.getTrfColT09(), var46);
                        }

                        if (var15 != null && !var15.isEmpty()) {
                           this.calculeRubFactureEntete(var15, this.transfertVentes.getTrfColT10(), var46);
                        }

                        if (var16 != null && !var16.isEmpty()) {
                           this.calculeRubFactureEntete(var16, this.transfertVentes.getTrfColT11(), var46);
                        }

                        if (var17 != null && !var17.isEmpty()) {
                           this.calculeRubFactureEntete(var17, this.transfertVentes.getTrfColT12(), var46);
                        }

                        if (var18 != null && !var18.isEmpty()) {
                           this.calculeRubFactureEntete(var18, this.transfertVentes.getTrfColT13(), var46);
                        }

                        if (var19 != null && !var19.isEmpty()) {
                           this.calculeRubFactureEntete(var19, this.transfertVentes.getTrfColT14(), var46);
                        }

                        if (var20 != null && !var20.isEmpty()) {
                           this.calculeRubFactureEntete(var20, this.transfertVentes.getTrfColT15(), var46);
                        }

                        if (var21 != null && !var21.isEmpty()) {
                           this.calculeRubFactureEntete(var21, this.transfertVentes.getTrfColT16(), var46);
                        }

                        if (var22 != null && !var22.isEmpty()) {
                           this.calculeRubFactureEntete(var22, this.transfertVentes.getTrfColT17(), var46);
                        }

                        if (var23 != null && !var23.isEmpty()) {
                           this.calculeRubFactureEntete(var23, this.transfertVentes.getTrfColT18(), var46);
                        }

                        if (var24 != null && !var24.isEmpty()) {
                           this.calculeRubFactureEntete(var24, this.transfertVentes.getTrfColT19(), var46);
                        }

                        if (var25 != null && !var25.isEmpty()) {
                           this.calculeRubFactureEntete(var25, this.transfertVentes.getTrfColT20(), var46);
                        }

                        if (var26 != null && !var26.isEmpty()) {
                           this.calculeRubFactureEntete(var26, this.transfertVentes.getTrfColT21(), var46);
                        }

                        if (var27 != null && !var27.isEmpty()) {
                           this.calculeRubFactureEntete(var27, this.transfertVentes.getTrfColT22(), var46);
                        }

                        if (var28 != null && !var28.isEmpty()) {
                           this.calculeRubFactureEntete(var28, this.transfertVentes.getTrfColT23(), var46);
                        }

                        if (var29 != null && !var29.isEmpty()) {
                           this.calculeRubFactureEntete(var29, this.transfertVentes.getTrfColT24(), var46);
                        }

                        if (var30 != null && !var30.isEmpty()) {
                           this.calculeRubFactureEntete(var30, this.transfertVentes.getTrfColT25(), var46);
                        }

                        if (var31 != null && !var31.isEmpty()) {
                           this.calculeRubFactureEntete(var31, this.transfertVentes.getTrfColT26(), var46);
                        }

                        if (var32 != null && !var32.isEmpty()) {
                           this.calculeRubFactureEntete(var32, this.transfertVentes.getTrfColT27(), var46);
                        }

                        if (var33 != null && !var33.isEmpty()) {
                           this.calculeRubFactureEntete(var33, this.transfertVentes.getTrfColT28(), var46);
                        }

                        if (var34 != null && !var34.isEmpty()) {
                           this.calculeRubFactureEntete(var34, this.transfertVentes.getTrfColT29(), var46);
                        }

                        if (var35 != null && !var35.isEmpty()) {
                           this.calculeRubFactureEntete(var35, this.transfertVentes.getTrfColT30(), var46);
                        }

                        if (var36 != null && !var36.isEmpty()) {
                           this.calculeRubFactureEntete(var36, this.transfertVentes.getTrfColT31(), var46);
                        }

                        if (var37 != null && !var37.isEmpty()) {
                           this.calculeRubFactureEntete(var37, this.transfertVentes.getTrfColT32(), var46);
                        }

                        if (var38 != null && !var38.isEmpty()) {
                           this.calculeRubFactureEntete(var38, this.transfertVentes.getTrfColT33(), var46);
                        }

                        if (var39 != null && !var39.isEmpty()) {
                           this.calculeRubFactureEntete(var39, this.transfertVentes.getTrfColT34(), var46);
                        }

                        if (var40 != null && !var40.isEmpty()) {
                           this.calculeRubFactureEntete(var40, this.transfertVentes.getTrfColT35(), var46);
                        }

                        if (var41 != null && !var41.isEmpty()) {
                           this.calculeRubFactureEntete(var41, this.transfertVentes.getTrfColT36(), var46);
                        }

                        if (var42 != null && !var42.isEmpty()) {
                           this.calculeRubFactureEntete(var42, this.transfertVentes.getTrfColT37(), var46);
                        }

                        if (var43 != null && !var43.isEmpty()) {
                           this.calculeRubFactureEntete(var43, this.transfertVentes.getTrfColT38(), var46);
                        }

                        if (var44 != null && !var44.isEmpty()) {
                           this.calculeRubFactureEntete(var44, this.transfertVentes.getTrfColT39(), var46);
                        }

                        if (var45 != null && !var45.isEmpty()) {
                           this.calculeRubFactureEntete(var45, this.transfertVentes.getTrfColT40(), var46);
                        }

                        if (this.factureEnteteVentes.getFacId() == 0L) {
                           this.factureEnteteVentes.setExerciceventes(this.exercicesVentes);
                           this.factureEnteteVentes.setUsers(this.usersLog);
                           this.factureEnteteVentes.setTiers(this.tiers);
                           this.factureEnteteVentes.setFacCivilTiers(this.tiers.getTiecivilite());
                           this.factureEnteteVentes.setFacCat(this.tiers.getTiecategorie());
                           this.factureEnteteVentes.setFacExoDouane(this.tiers.getTieexodouane());
                           this.factureEnteteVentes.setFacExoTva(this.tiers.getTieexotva());
                           this.factureEnteteVentes.setFacNomTiers(this.tiers.getTieraisonsocialenom());
                           if (this.factureEnteteVentes.getFacDevise() == null || this.factureEnteteVentes.getFacDevise().isEmpty()) {
                              this.factureEnteteVentes.setFacDevise(this.structureLog.getStrdevise());
                           }

                           if (this.factureEnteteVentes.getFacSerie() == null || this.factureEnteteVentes.getFacSerie().isEmpty()) {
                              this.factureEnteteVentes.setFacSerie("A");
                           }

                           this.factureEnteteVentes = this.factureEnteteVentesDao.insert(this.factureEnteteVentes, var46);
                        } else {
                           this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var46);
                           this.factureLigneVentesDao.deleteAllLigne(this.factureEnteteVentes, var46);
                        }

                        var46.flush();
                     }
                  } else if (var5.contains("faclig_")) {
                     this.factureEnteteVentes = null;
                     String var50 = "";
                     if (this.transfertVentes.getTrfColT01() != null && !this.transfertVentes.getTrfColT01().isEmpty()) {
                        var50 = this.enlevePoint(this.transfertVentes.getTrfColT01()).toUpperCase();
                        this.factureEnteteVentes = this.factureEnteteVentesDao.pourParapheur(var50, (String)null, var46);
                     }

                     if (this.factureEnteteVentes != null) {
                        this.factureLigneVentes = new FactureLigneVentes();
                        if (var5 != null && !var5.isEmpty()) {
                           this.calculeRubFactureLigne(var5, this.transfertVentes.getTrfColT00(), var46);
                        }

                        if (var7 != null && !var7.isEmpty()) {
                           this.calculeRubFactureLigne(var7, this.transfertVentes.getTrfColT02(), var46);
                        }

                        if (var8 != null && !var8.isEmpty()) {
                           this.calculeRubFactureLigne(var8, this.transfertVentes.getTrfColT03(), var46);
                        }

                        if (var9 != null && !var9.isEmpty()) {
                           this.calculeRubFactureLigne(var9, this.transfertVentes.getTrfColT04(), var46);
                        }

                        if (var10 != null && !var10.isEmpty()) {
                           this.calculeRubFactureLigne(var10, this.transfertVentes.getTrfColT05(), var46);
                        }

                        if (var11 != null && !var11.isEmpty()) {
                           this.calculeRubFactureLigne(var11, this.transfertVentes.getTrfColT06(), var46);
                        }

                        if (var12 != null && !var12.isEmpty()) {
                           this.calculeRubFactureLigne(var12, this.transfertVentes.getTrfColT07(), var46);
                        }

                        if (var13 != null && !var13.isEmpty()) {
                           this.calculeRubFactureLigne(var13, this.transfertVentes.getTrfColT08(), var46);
                        }

                        if (var14 != null && !var14.isEmpty()) {
                           this.calculeRubFactureLigne(var14, this.transfertVentes.getTrfColT09(), var46);
                        }

                        if (var15 != null && !var15.isEmpty()) {
                           this.calculeRubFactureLigne(var15, this.transfertVentes.getTrfColT10(), var46);
                        }

                        if (var16 != null && !var16.isEmpty()) {
                           this.calculeRubFactureLigne(var16, this.transfertVentes.getTrfColT11(), var46);
                        }

                        if (var17 != null && !var17.isEmpty()) {
                           this.calculeRubFactureLigne(var17, this.transfertVentes.getTrfColT12(), var46);
                        }

                        if (var18 != null && !var18.isEmpty()) {
                           this.calculeRubFactureLigne(var18, this.transfertVentes.getTrfColT13(), var46);
                        }

                        if (var19 != null && !var19.isEmpty()) {
                           this.calculeRubFactureLigne(var19, this.transfertVentes.getTrfColT14(), var46);
                        }

                        if (var20 != null && !var20.isEmpty()) {
                           this.calculeRubFactureLigne(var20, this.transfertVentes.getTrfColT15(), var46);
                        }

                        if (var21 != null && !var21.isEmpty()) {
                           this.calculeRubFactureLigne(var21, this.transfertVentes.getTrfColT16(), var46);
                        }

                        if (var22 != null && !var22.isEmpty()) {
                           this.calculeRubFactureLigne(var22, this.transfertVentes.getTrfColT17(), var46);
                        }

                        if (var23 != null && !var23.isEmpty()) {
                           this.calculeRubFactureLigne(var23, this.transfertVentes.getTrfColT18(), var46);
                        }

                        if (var24 != null && !var24.isEmpty()) {
                           this.calculeRubFactureLigne(var24, this.transfertVentes.getTrfColT19(), var46);
                        }

                        if (var25 != null && !var25.isEmpty()) {
                           this.calculeRubFactureLigne(var25, this.transfertVentes.getTrfColT20(), var46);
                        }

                        if (var26 != null && !var26.isEmpty()) {
                           this.calculeRubFactureLigne(var26, this.transfertVentes.getTrfColT21(), var46);
                        }

                        if (var27 != null && !var27.isEmpty()) {
                           this.calculeRubFactureLigne(var27, this.transfertVentes.getTrfColT22(), var46);
                        }

                        if (var28 != null && !var28.isEmpty()) {
                           this.calculeRubFactureLigne(var28, this.transfertVentes.getTrfColT23(), var46);
                        }

                        if (var29 != null && !var29.isEmpty()) {
                           this.calculeRubFactureLigne(var29, this.transfertVentes.getTrfColT24(), var46);
                        }

                        if (var30 != null && !var30.isEmpty()) {
                           this.calculeRubFactureLigne(var30, this.transfertVentes.getTrfColT25(), var46);
                        }

                        if (var31 != null && !var31.isEmpty()) {
                           this.calculeRubFactureLigne(var31, this.transfertVentes.getTrfColT26(), var46);
                        }

                        if (var32 != null && !var32.isEmpty()) {
                           this.calculeRubFactureLigne(var32, this.transfertVentes.getTrfColT27(), var46);
                        }

                        if (var33 != null && !var33.isEmpty()) {
                           this.calculeRubFactureLigne(var33, this.transfertVentes.getTrfColT28(), var46);
                        }

                        if (var34 != null && !var34.isEmpty()) {
                           this.calculeRubFactureLigne(var34, this.transfertVentes.getTrfColT29(), var46);
                        }

                        if (var35 != null && !var35.isEmpty()) {
                           this.calculeRubFactureLigne(var35, this.transfertVentes.getTrfColT30(), var46);
                        }

                        if (var36 != null && !var36.isEmpty()) {
                           this.calculeRubFactureLigne(var36, this.transfertVentes.getTrfColT31(), var46);
                        }

                        if (var37 != null && !var37.isEmpty()) {
                           this.calculeRubFactureLigne(var37, this.transfertVentes.getTrfColT32(), var46);
                        }

                        if (var38 != null && !var38.isEmpty()) {
                           this.calculeRubFactureLigne(var38, this.transfertVentes.getTrfColT33(), var46);
                        }

                        if (var39 != null && !var39.isEmpty()) {
                           this.calculeRubFactureLigne(var39, this.transfertVentes.getTrfColT34(), var46);
                        }

                        if (var40 != null && !var40.isEmpty()) {
                           this.calculeRubFactureLigne(var40, this.transfertVentes.getTrfColT35(), var46);
                        }

                        if (var41 != null && !var41.isEmpty()) {
                           this.calculeRubFactureLigne(var41, this.transfertVentes.getTrfColT36(), var46);
                        }

                        if (var42 != null && !var42.isEmpty()) {
                           this.calculeRubFactureLigne(var42, this.transfertVentes.getTrfColT37(), var46);
                        }

                        if (var43 != null && !var43.isEmpty()) {
                           this.calculeRubFactureLigne(var43, this.transfertVentes.getTrfColT38(), var46);
                        }

                        if (var44 != null && !var44.isEmpty()) {
                           this.calculeRubFactureLigne(var44, this.transfertVentes.getTrfColT39(), var46);
                        }

                        if (var45 != null && !var45.isEmpty()) {
                           this.calculeRubFactureLigne(var45, this.transfertVentes.getTrfColT40(), var46);
                        }

                        this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
                        this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
                        if (this.factureLigneVentes.getFacligTauxRemise() != 0.0F) {
                           var51 = this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligPu() * (double)this.factureLigneVentes.getFacligTauxRemise() / 100.0D, this.factureEnteteVentes.getFacDevise());
                           this.factureLigneVentes.setFacligPuRem(this.factureLigneVentes.getFacligPu() - var51);
                        } else {
                           this.factureLigneVentes.setFacligPuRem(this.factureLigneVentes.getFacligPu());
                        }

                        var51 = this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligPuRem() * (double)this.factureLigneVentes.getFacligQte(), this.factureEnteteVentes.getFacDevise());
                        this.factureLigneVentes.setFacligPt(var51);
                        if (this.factureLigneVentes.getFacligTauxTaxe() != 0.0F) {
                           var53 = this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligPt() * (double)this.factureLigneVentes.getFacligTauxTaxe() / 100.0D, this.factureEnteteVentes.getFacDevise());
                           this.factureLigneVentes.setFacligTva(var53);
                        } else {
                           this.factureLigneVentes.setFacligTva(0.0D);
                        }

                        this.factureLigneVentes.setFacligTtc(this.factureLigneVentes.getFacligPt() + this.factureLigneVentes.getFacligTva());
                        this.factureLigneVentes = this.factureLigneVentesDao.insertLigne(this.factureLigneVentes, var46);
                        var46.flush();
                     } else {
                        this.transfertVentes.setTrfNomFeuille("la facture " + var50 + " n`existe pas.");
                        this.lesErreurs.add(this.transfertVentes);
                     }
                  }
               }
            }

            var47.commit();
         } catch (HibernateException var58) {
            if (var47 != null) {
               var47.rollback();
            }

            throw var58;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.datamodelDocument.setWrappedData(this.lesErreurs);
         this.var_affiche_bouton = false;
         this.balance = 2;
         this.var_showBarProgMaj = false;
      }

   }

   public boolean recherhceClient(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      long var4 = this.conversionLong(var1);
      this.tiers = this.tiersDao.selectTierOlD(var4, var2);
      if (this.tiers == null) {
         this.tiers = this.tiersDao.selectTierD(var4, var2);
         if (this.tiers == null) {
            var3 = false;
         } else {
            var3 = true;
         }
      } else {
         var3 = true;
      }

      return var3;
   }

   public boolean recherhceAnalytique(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      this.plansAnalytiques = this.plansAnalytiquesDao.rechercheAffaire(var1, var2);
      if (this.plansAnalytiques == null) {
         this.plansAnalytiques = new PlansAnalytiques();
         this.plansAnalytiques.setAnaCodeComplet(var1);
         this.plansAnalytiques.setAnaNature("XXXXX");
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   public String enlevePoint(String var1) {
      String var2 = "";
      if (var1 != null && !var1.isEmpty() && var1.contains(".0")) {
         int var3 = var1.indexOf(".0");
         var2 = var1.substring(0, var3);
      } else {
         var2 = var1;
      }

      if (var2 != null && !var2.isEmpty()) {
         var2 = var2.replace("'", "`");
      }

      return var2;
   }

   public int conversionInteger(String var1) {
      String var2 = "";
      int var3 = 0;
      if (var1 != null && !var1.isEmpty()) {
         var1 = var1.replace("%", "");
         var1 = var1.replace(",", ".");
         int var4;
         if (var1.contains(".0")) {
            var4 = var1.indexOf(".0");
            var2 = var1.substring(0, var4);
         } else if (var1.contains(".")) {
            var4 = var1.indexOf(".");
            var2 = var1.substring(0, var4);
         } else {
            var2 = var1;
         }

         var3 = Integer.parseInt(var2);
      }

      return var3;
   }

   public double conversionDouble(String var1) {
      double var2 = 0.0D;
      if (var1 != null && !var1.isEmpty()) {
         var1 = var1.replace("%", "");
         var1 = var1.replace(",", ".");
         var2 = Double.parseDouble(var1);
      }

      return var2;
   }

   public Boolean conversionBoolean(String var1) {
      boolean var2 = false;
      if (var1 != null && !var1.isEmpty() && (var1.equals("1") || var1.equals("true") || var1.equals("TRUE"))) {
         var2 = true;
      }

      return var2;
   }

   public long conversionLong(String var1) {
      String var2 = "";
      long var3 = 0L;
      if (var1 != null && !var1.isEmpty()) {
         var1 = var1.replace("%", "");
         var1 = var1.replace(",", ".");
         if (var1.contains(".0")) {
            int var5 = var1.indexOf(".0");
            var2 = var1.substring(0, var5);
         } else {
            var2 = var1;
         }

         var3 = Long.parseLong(var2);
      }

      return var3;
   }

   public Date conversionDate(String var1) throws java.text.ParseException {
      Date var2 = null;
      if (var1 != null && !var1.isEmpty()) {
         if (!var1.contains("-") && !var1.contains("/")) {
            int var7 = this.conversionInteger(var1);
            if (var7 >= 10000 && var7 <= 60000) {
               GregorianCalendar var8 = new GregorianCalendar(1900, 0, 1);
               var8.add(5, var7 - 2);
               var2 = var8.getTime();
            } else {
               var2 = null;
            }
         } else if (var1.substring(4, 4).equals("-")) {
            String[] var3 = var1.split("-");
            String var4 = var3[2];
            String var5 = var3[1];
            String var6 = var3[0];
            var2 = this.utilDate.stringToDateSQLLight(var4 + "-" + var5 + "-" + var6);
         } else if (var1.length() == 10) {
            var2 = this.utilDate.stringToDateSQLLight(var1);
         } else {
            var2 = this.utilDate.stringToDateFrLg(var1);
         }
      } else {
         var2 = null;
      }

      return var2;
   }

   public void calculeRubProduit(String var1, String var2, Session var3) throws java.text.ParseException, HibernateException, NamingException {
      this.messageErreur = "";
      if (var1.equalsIgnoreCase("pro_code")) {
         if (var2 != null && !var2.isEmpty()) {
            this.produits.setProCode(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("pro_code_option")) {
         this.produits.setProCodeOption(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("pro_lib_client")) {
         if (var2 != null && !var2.isEmpty()) {
            this.produits.setProLibClient(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("pro_lib_tech")) {
         if (var2 != null && !var2.isEmpty()) {
            this.produits.setProLibTech(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("pro_descrip")) {
         this.produits.setProDescrip(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("pro_imp_desciption")) {
         this.produits.setProImpDesciption(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("pro_barre")) {
         if (var2 != null && !var2.isEmpty()) {
            this.produits.setProBarre(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("pro_ach_code")) {
         this.verifFamilleAchat(var2, var3);
      } else if (var1.equalsIgnoreCase("pro_ach_lib")) {
         if (var2 != null && !var2.isEmpty()) {
            this.produits.setProAchLib(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("pro_ach_douane")) {
         this.produits.setProAchDouane(this.enlevePoint(var2).toUpperCase());
      } else if (var1.equalsIgnoreCase("pro_ach_tva")) {
         if (var2 != null && !var2.isEmpty()) {
            this.produits.setProAchTva(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("pro_ach_cpte_loc")) {
         if (var2 != null && !var2.isEmpty()) {
            this.produits.setProAchCpteLoc(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("pro_ach_cpte_z")) {
         if (var2 != null && !var2.isEmpty()) {
            this.produits.setProAchCpteZ(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("pro_ach_cpte_hz")) {
         if (var2 != null && !var2.isEmpty()) {
            this.produits.setProAchCpteHz(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("pro_ach_cpte_ch")) {
         if (var2 != null && !var2.isEmpty()) {
            this.produits.setProAchCpteCh(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("pro_ach_cpte_st")) {
         if (var2 != null && !var2.isEmpty()) {
            this.produits.setProAchCpteSt(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("pro_ach_cpte_ec")) {
         if (var2 != null && !var2.isEmpty()) {
            this.produits.setProAchCpteEc(this.enlevePoint(var2).toUpperCase());
         }
      } else if (!var1.equalsIgnoreCase("pro_ach_nat")) {
         if (var1.equalsIgnoreCase("pro_depot_ach")) {
            this.produits.setProDepotAch(this.verifDepot(var2, var3));
         } else if (var1.equalsIgnoreCase("pro_depot_prd")) {
            this.produits.setProDepotPrd(this.verifDepot(var2, var3));
         } else if (var1.equalsIgnoreCase("pro_vte_code")) {
            this.verifFamilleVente(var2, var3);
         } else if (var1.equalsIgnoreCase("pro_vte_lib")) {
            if (var2 != null && !var2.isEmpty()) {
               this.produits.setProVteLib(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("pro_vte_douane")) {
            if (var2 != null && !var2.isEmpty()) {
               this.produits.setProVteDouane(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("pro_vte_tva")) {
            if (var2 != null && !var2.isEmpty()) {
               this.produits.setProVteTva(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("pro_vte_cpte_loc")) {
            if (var2 != null && !var2.isEmpty()) {
               this.produits.setProVteCpteLoc(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("pro_vte_cpte_n_tx")) {
            if (var2 != null && !var2.isEmpty()) {
               this.produits.setProVteCpteNTx(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("pro_vte_cpte_z")) {
            if (var2 != null && !var2.isEmpty()) {
               this.produits.setProVteCpteZ(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("pro_vte_cpte_hz")) {
            if (var2 != null && !var2.isEmpty()) {
               this.produits.setProVteCpteHz(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("pro_vte_cpte_pr")) {
            if (var2 != null && !var2.isEmpty()) {
               this.produits.setProVteCptePr(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("pro_vte_cpte_st")) {
            if (var2 != null && !var2.isEmpty()) {
               this.produits.setProVteCpteSt(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("pro_vte_cpte_ca")) {
            if (var2 != null && !var2.isEmpty()) {
               this.produits.setProVteCpteCa(this.enlevePoint(var2).toUpperCase());
            }
         } else if (!var1.equalsIgnoreCase("pro_vte_nat")) {
            if (var1.equalsIgnoreCase("pro_depot_vte")) {
               this.produits.setProDepotVte(this.verifDepot(var2, var3));
            } else if (var1.equalsIgnoreCase("pro_stock")) {
               this.produits.setProStock(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_condition1")) {
               this.produits.setProCondition1(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_condition2")) {
               this.produits.setProCondition2(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_condition3")) {
               this.produits.setProCondition3(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_condition4")) {
               this.produits.setProCondition4(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_condition5")) {
               this.produits.setProCondition5(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_activite")) {
               this.produits.setProActivite(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_cle1")) {
               this.produits.setProCle1(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_cle2")) {
               this.produits.setProCle2(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_promo")) {
               this.produits.setProPromo(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_lettre")) {
               this.produits.setProLettre(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_longueur")) {
               this.produits.setProLongueur((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_largeur")) {
               this.produits.setProLargeur((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_epaisseur")) {
               this.produits.setProEpaisseur((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_volume")) {
               this.produits.setProVolume((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_poids_brut")) {
               this.produits.setProPoidsBrut((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_poids_net")) {
               this.produits.setProPoidsNet((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_poids_tare")) {
               this.produits.setProPoidsTare((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_diam_int")) {
               this.produits.setProDiamInt((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_diam_ext")) {
               this.produits.setProDiamExt((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_densite")) {
               this.produits.setProDensite((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_pression")) {
               this.produits.setProPression((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_etat")) {
               this.produits.setProEtat(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_nb_unite")) {
               this.produits.setProNbUnite((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_nb_unite_cnamgs")) {
               this.produits.setProNbUniteCnamgs((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_usage")) {
               this.produits.setProUsage(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_def_pump")) {
               this.produits.setProDefPump(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_def_dte_pump")) {
               this.produits.setProDefDtePump(this.conversionDate(var2));
            } else if (var1.equalsIgnoreCase("pro_grp_inv")) {
               this.produits.setProGrpInv(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_mode")) {
               this.produits.setProMode(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_marque")) {
               this.produits.setProMarque(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_couleur")) {
               this.produits.setProCouleur(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_constructeur")) {
               this.produits.setProConstructeur(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_code_lie")) {
               this.produits.setProCodeLie(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_qte_lie")) {
               this.produits.setProQteLie((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_inactif")) {
               this.produits.setProInactif(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_photo")) {
               this.produits.setProPhoto(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_photo_taille")) {
               this.produits.setProPhotoTaille(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_pdf")) {
               this.produits.setProPdf(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_formule")) {
               this.produits.setProFormule(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_public")) {
               this.produits.setProPublic(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_date_public")) {
               this.produits.setProPublic(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_energie")) {
               this.produits.setProPublic(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_nb_porte")) {
               this.produits.setProPublic(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_boite_vitesse")) {
               this.produits.setProPublic(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_puissance")) {
               this.produits.setProPublic(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_cylindree")) {
               this.produits.setProPublic(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_genre")) {
               this.produits.setProPublic(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_carrosserie")) {
               this.produits.setProPublic(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_nb_place")) {
               this.produits.setProNbPlace(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_puissance_din")) {
               this.produits.setProPuissanceDin(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_remise")) {
               this.produits.setProRemise(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_prc_ht")) {
               this.produits.setProPrcHt((double)this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_prc_exop")) {
               this.produits.setProPrcExoP((double)this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_prc_exot")) {
               this.produits.setProPrcExoT(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_prg_ht")) {
               this.produits.setProPrgHt(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_prg_exop")) {
               this.produits.setProPrcExoP(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_prg_exot")) {
               this.produits.setProPrgExoT(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_pa")) {
               this.produits.setProPA(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_fret")) {
               this.produits.setProFret(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_assurance")) {
               this.produits.setProAssurance(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_devise")) {
               this.produits.setProDevise(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_coef_devise")) {
               this.produits.setProCoefDevise((float)this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_caf")) {
               this.produits.setProCaf(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_qte_stock")) {
               this.produits.setProQteStock((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_qte_cmd_fournisseur")) {
               this.produits.setProQteCmdFournisseur((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_qte_cmd_client")) {
               this.produits.setProQteCmdClient((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_com_unite")) {
               this.produits.setProComUnite(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_com_pourcentage")) {
               this.produits.setProComPourcentage((float)this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("pro_process")) {
               this.produits.setProProcess(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_modele_pr")) {
               this.produits.setProModelePr(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("pro_avec_service")) {
               this.produits.setProAvecService(this.conversionBoolean(var2));
            } else if (var1.equalsIgnoreCase("pro_pec_bilan")) {
               this.produits.setProPecBilan(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("pro_majoration")) {
               this.produits.setProMajoration(this.conversionInteger(var2));
            } else {
               this.messageErreur = "La rubrique " + var1 + " n`existe pas...";
            }
         }
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertVentes.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertVentes);
      }

   }

   public boolean calculeRubProduitDepot(String var1, String var2, Session var3) throws HibernateException, NamingException, java.text.ParseException {
      boolean var4 = false;
      this.messageErreur = "";
      if (var1.equalsIgnoreCase("depot.dpo_code")) {
         this.verifDepot(var2, var3);
      } else if (var1.equalsIgnoreCase("prodep_unite")) {
         this.produitsDepot.setProdepUnite(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("prodep_echelle")) {
         this.produitsDepot.setProdepEchelle(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("prodep_qte_mini")) {
         this.produitsDepot.setProdepQteMini((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("prodep_qte_maxi")) {
         this.produitsDepot.setProdepQteMaxi((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("prodep_qte_conso")) {
         this.produitsDepot.setProdepQteConso((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("prodep_coef_pr")) {
         this.produitsDepot.setProdepCoefPr((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("prodep_pa")) {
         this.produitsDepot.setProdepPa(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("prodep_pr")) {
         this.produitsDepot.setProdepPr(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("prodep_pr_kg")) {
         this.produitsDepot.setProdepPrKg(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("prodep_pump")) {
         this.produitsDepot.setProdepPump(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("prodep_date_inv")) {
         this.produitsDepot.setProdepDateInv(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("prodep_date_entree")) {
         this.produitsDepot.setProdepDateEntree(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("prodep_date_sortie")) {
         this.produitsDepot.setProdepDateSortie(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("prodep_date_prod")) {
         this.produitsDepot.setProdepDateProd(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("prodep_qte_cmd_ach")) {
         this.produitsDepot.setProdepQteCmdAch((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("prodep_qte_cmd_vte")) {
         this.produitsDepot.setProdepQteCmdVte((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("prodep_qte_att_ach")) {
         this.produitsDepot.setProdepQteAttAch((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("prodep_qte_att_vte")) {
         this.produitsDepot.setProdepQteAttVte((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("prodep_qte_stk")) {
         this.produitsDepot.setProdepQteStk((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("prodep_qte_inv")) {
         this.produitsDepot.setProdepQteInv((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("prodep_localisation")) {
         this.produitsDepot.setProdepLocalisation(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("prodep_casier")) {
         this.produitsDepot.setProdepCasier(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("prodep_groupe")) {
         this.produitsDepot.setProdepGroupe(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("prodep_cle")) {
         this.produitsDepot.setProdepCle(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("prodep_cle2")) {
         this.produitsDepot.setProdepCle2(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("prodep_inactif")) {
         this.produitsDepot.setProdepInactif(this.conversionInteger(var2));
      } else {
         this.messageErreur = "La rubrique " + var1 + " n`existe pas...";
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertVentes.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertVentes);
      }

      return var4;
   }

   public boolean calculeRubProduitTarif(String var1, String var2, Session var3) throws HibernateException, NamingException, java.text.ParseException {
      boolean var4 = false;
      this.messageErreur = "";
      boolean var5 = false;
      if (var1.equalsIgnoreCase("protar_coef")) {
         this.produitsTarif.setProtarCoef((float)this.conversionDouble(var2));
      } else if (!var1.equalsIgnoreCase("protar_client")) {
         if (var1.equalsIgnoreCase("protar_ordre")) {
            this.produitsTarif.setProtarOrdre(99999);
            this.produitsTarif.setProtarClient("ERREUR");
            int var7 = this.conversionInteger(var2);
            if (this.mesFamillesClientsItems.size() != 0) {
               for(int var6 = 0; var6 < this.mesFamillesClientsItems.size(); ++var6) {
                  if (var7 == var6) {
                     this.produitsTarif.setProtarOrdre(var6);
                     this.produitsTarif.setProtarClient(((SelectItem)this.mesFamillesClientsItems.get(var6)).getValue().toString());
                     break;
                  }
               }
            }

            if (this.produitsTarif.getProtarOrdre() == 99999) {
               this.messageErreur = "La famille de tiers " + var7 + " n`existe pas...";
            }
         } else if (var1.equalsIgnoreCase("protar_lettre")) {
            this.produitsTarif.setProtarLettre(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("protar_nb")) {
            this.produitsTarif.setProtarNb((float)this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("protar_nb_cnamgs")) {
            this.produitsTarif.setProtarNbCnamgs((float)this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("protar_valeur")) {
            this.produitsTarif.setProtarValeur(this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("protar_valeur_cnamgs")) {
            this.produitsTarif.setProtarPvCnamgs(this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("protar_pv")) {
            this.produitsTarif.setProtarPv(this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("protar_pv_cnamgs")) {
            this.produitsTarif.setProtarPvCnamgs(this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("protar_condit")) {
            this.produitsTarif.setProtarCondit(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("protar_unite")) {
            this.produitsTarif.setProtarUnite(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("protar_inactif")) {
            this.produitsTarif.setProtarInactif(this.conversionInteger(var2));
         } else if (var1.equalsIgnoreCase("protar_exo_tva")) {
            this.produitsTarif.setProtarExoTva(this.conversionBoolean(var2));
         } else if (var1.equalsIgnoreCase("protar_exo_dd")) {
            this.produitsTarif.setProtarExoDd(this.conversionBoolean(var2));
         } else if (var1.equalsIgnoreCase("protar_taux_tva")) {
            this.produitsTarif.setProtarTauxTva((float)this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("protar_pv_marche")) {
            this.produitsTarif.setProtarPvMarche((double)((float)this.conversionDouble(var2)));
         } else if (var1.equalsIgnoreCase("protar_pv_cc1")) {
            this.produitsTarif.setProtarPvCc1(this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("protar_pv_cc2")) {
            this.produitsTarif.setProtarPvCc2(this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("protar_pv_cc3")) {
            this.produitsTarif.setProtarPvCc3(this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("protar_date_marche")) {
            this.produitsTarif.setProtarDateMarche(this.conversionDate(var2));
         } else if (var1.equalsIgnoreCase("protar_date_cc1")) {
            this.produitsTarif.setProtarDateCc1(this.conversionDate(var2));
         } else if (var1.equalsIgnoreCase("protar_date_cc2")) {
            this.produitsTarif.setProtarDateCc2(this.conversionDate(var2));
         } else if (var1.equalsIgnoreCase("protar_date_cc3")) {
            this.produitsTarif.setProtarDateCc3(this.conversionDate(var2));
         } else if (var1.equalsIgnoreCase("protar_nom_cc1")) {
            this.produitsTarif.setProtarNomCc1(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("protar_nom_cc2")) {
            this.produitsTarif.setProtarNomCc2(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("protar_nom_cc3")) {
            this.produitsTarif.setProtarNomCc3(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("protar_tarif_qte")) {
            this.produitsTarif.setProtarTarifQte(this.enlevePoint(var2));
         } else {
            this.messageErreur = "La rubrique " + var1 + " n`existe pas...";
         }
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertVentes.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertVentes);
      }

      return var4;
   }

   public boolean calculeRubBareme(String var1, String var2, Session var3) throws HibernateException, NamingException, java.text.ParseException {
      boolean var4 = false;
      this.messageErreur = "";
      boolean var5 = false;
      if (var1.equalsIgnoreCase("bar_code")) {
         this.baremes.setBarCode(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("bar_nom_FR")) {
         this.baremes.setBarNomFr(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("bar_nom_UK")) {
         this.baremes.setBarNomUk(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("bar_nom_SP")) {
         this.baremes.setBarNomSp(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("bar_inactif")) {
         this.baremes.setBarInactif(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bar_options")) {
         this.baremes.setBarOptions(this.conversionInteger(var2));
      } else if (!var1.equalsIgnoreCase("bar_type")) {
         if (var1.equalsIgnoreCase("bar_id_tiers")) {
            this.baremes.setBarIdTiers(this.conversionLong(var2));
         } else if (var1.equalsIgnoreCase("bar_id_medecin")) {
            this.baremes.setBarIdMedecin(this.conversionLong(var2));
         } else if (var1.equalsIgnoreCase("bar_nom_tiers")) {
            this.baremes.setBarIdMedecin(this.conversionLong(var2));
         } else if (!var1.equalsIgnoreCase("bar_categorie_tiers")) {
            if (var1.equalsIgnoreCase("bar_ordre_tarif")) {
               this.baremes.setBarOrdreTarif(99999);
               this.baremes.setBarCategorieTiers("ERREUR");
               int var7 = this.conversionInteger(var2);
               if (this.mesFamillesClientsItems.size() != 0) {
                  for(int var6 = 0; var6 < this.mesFamillesClientsItems.size(); ++var6) {
                     if (var7 == var6) {
                        this.baremes.setBarOrdreTarif(var6);
                        this.baremes.setBarCategorieTiers(((SelectItem)this.mesFamillesClientsItems.get(var6)).getValue().toString());
                        break;
                     }
                  }
               }

               if (this.baremes.getBarOrdreTarif() == 99999) {
                  this.messageErreur = "La famille de tiers " + var7 + " n`existe pas...";
               }
            } else if (!var1.equalsIgnoreCase("bar_code_produit") && !var1.equalsIgnoreCase("bar_libelle_produit") && !var1.equalsIgnoreCase("bar_code_vte") && !var1.equalsIgnoreCase("bar_libelle_vte")) {
               if (var1.equalsIgnoreCase("bar_date_debut")) {
                  this.baremes.setBarDateDebut(this.conversionDate(var2));
               } else if (var1.equalsIgnoreCase("bar_date_fin")) {
                  this.baremes.setBarDateFin(this.conversionDate(var2));
               } else if (var1.equalsIgnoreCase("bar_remise")) {
                  this.baremes.setBarRemise((float)this.conversionDouble(var2));
               } else if (var1.equalsIgnoreCase("bar_rabais")) {
                  this.baremes.setBarRabais(this.conversionDouble(var2));
               } else if (var1.equalsIgnoreCase("bar_prix")) {
                  this.baremes.setBarPrix(this.conversionDouble(var2));
               } else {
                  this.messageErreur = "La rubrique " + var1 + " n`existe pas...";
               }
            }
         }
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertVentes.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertVentes);
      }

      return var4;
   }

   public boolean calculeRubProduitFournisseur(String var1, String var2, Session var3) throws HibernateException, NamingException, java.text.ParseException {
      boolean var4 = false;
      this.messageErreur = "";
      if (!var1.equalsIgnoreCase("produits.pro_code") && !var1.equalsIgnoreCase("tiers.tie_id")) {
         if (var1.equalsIgnoreCase("profou_ref")) {
            this.produitsFournisseur.setProfouRef(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("profou_lib")) {
            this.produitsFournisseur.setProfouLib(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("profou_pa")) {
            this.produitsFournisseur.setProfouPa(this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("profou_devise")) {
            this.produitsFournisseur.setProfouDevise(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("profou_taux_devise")) {
            this.produitsFournisseur.setProfouTauxDevise((float)this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("profou_format")) {
            this.produitsFournisseur.setProfouFormat(this.conversionInteger(var2));
         } else if (var1.equalsIgnoreCase("profou_coef_euro")) {
            this.produitsFournisseur.setProfouCoefEuro((float)this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("profou_coef_local")) {
            this.produitsFournisseur.setProfouCoefLocal((float)this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("profou_pa_local")) {
            this.produitsFournisseur.setProfouPaLocal(this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("profou_pa_euro")) {
            this.produitsFournisseur.setProfouPaEuro(this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("profou_date")) {
            this.produitsFournisseur.setProfouDate(this.conversionDate(var2));
         } else if (var1.equalsIgnoreCase("profou_condition1")) {
            this.produitsFournisseur.setProfouCondition1(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("profou_condition2")) {
            this.produitsFournisseur.setProfouCondition2(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("profou_condition3")) {
            this.produitsFournisseur.setProfouCondition3(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("profou_condition4")) {
            this.produitsFournisseur.setProfouCondition4(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("profou_condition5")) {
            this.produitsFournisseur.setProfouCondition5(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("profou_inactif")) {
            this.produitsFournisseur.setProfouInactif(this.conversionInteger(var2));
         } else {
            this.messageErreur = "La rubrique " + var1 + " n`existe pas...";
         }
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertVentes.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertVentes);
      }

      return var4;
   }

   public void calculeRubPlanAnalytique(String var1, String var2, Session var3) throws java.text.ParseException {
      this.messageErreur = "";
      if (var1.equalsIgnoreCase("ana_date_creat")) {
         this.plansAnalytiques.setAnaDateCreat(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("ana_date_modif")) {
         this.plansAnalytiques.setAnaDateModif(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("ana_user_creat")) {
         this.plansAnalytiques.setAnaUserCreat(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("ana_user_modif")) {
         this.plansAnalytiques.setAnaUserModif(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("ana_annee")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaAnnee(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_nature")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaNature(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_ordre")) {
         this.plansAnalytiques.setAnaOrdre(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_code")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaCode(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_nom_FR")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaNomFr(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_nom_UK")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaNomUk(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_nom_SP")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaNomSp(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_inactif")) {
         this.plansAnalytiques.setAnaInactif(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_nature_repartition")) {
         this.plansAnalytiques.setAnaNatureRepartition(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_annee_debut")) {
         this.plansAnalytiques.setAnaAnneeDebut(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_annee_fin")) {
         this.plansAnalytiques.setAnaAnneeFin(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_type_dossier")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTypeDossier(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_type_devise")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTypeDevise(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_type_taux_devise")) {
         this.plansAnalytiques.setAnaTypeTauxDevise((float)this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_type_exo_tva")) {
         this.plansAnalytiques.setAnaTypeExoTva(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("ana_type_exo_douane")) {
         this.plansAnalytiques.setAnaTypeExoDouane(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("ana_mission_debut")) {
         this.plansAnalytiques.setAnaMissionDebut(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("ana_mission_fin")) {
         this.plansAnalytiques.setAnaMissionFin(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("ana_mission_proprietaire")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaMissionProprietaire(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_mission_lettre_cmd")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaMissionLettreCmd(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_mission_chef")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaMissionChef(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_mission_cout_theorique")) {
         this.plansAnalytiques.setAnaMissionCoutTheorique(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("ana_mission_etat")) {
         this.plansAnalytiques.setAnaMissionEtat(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_tiers_civilite")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTiersCivilite(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_tiers_telephone")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTiersTelephone(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("anaTiers_fax")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTiersFax(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_tiers_adresse")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTiersAdresse(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_tiers_bp")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTiersBp(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_tiers_mail")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTiersMail(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_tiers_ville")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTiersVille(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_tiers_Pdv")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTiersPdv(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_tiers_secteur")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTiersSecteur(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_tiers_region")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTiersRegion(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_tiers_appreciaiton")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTiersAppreciation(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_tiers_nom_pays")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTiersNompays(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_tiers_devise")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTiersdevise(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_tiers_format_devise")) {
         this.plansAnalytiques.setAnaTiersFormatDevise(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_tiers_source")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTierssource(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_tiers_langue")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTierslangue(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_tiers_obs")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTiersObs(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_tiers_regroupe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaTiersRegroupe(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_vte")) {
         this.plansAnalytiques.setAnaVte(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("ana_ach")) {
         this.plansAnalytiques.setAnaAch(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("ana_prd")) {
         this.plansAnalytiques.setAnaPrd(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("ana_frg")) {
         this.plansAnalytiques.setAnaFrg(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("ana_inv")) {
         this.plansAnalytiques.setAnaInv(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("ana_tva")) {
         this.plansAnalytiques.setAnaTva(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("ana_tax")) {
         this.plansAnalytiques.setAnaTax(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("ana_sal")) {
         this.plansAnalytiques.setAnaSal(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("ana_str")) {
         this.plansAnalytiques.setAnaStr(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("ana_id_tiers")) {
         this.plansAnalytiques.setAnaIdTiers(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("ana_affaires_service")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaAffaireService(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_affaire_etat")) {
         this.plansAnalytiques.setAnaAffaireEtat(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_affaires_agent")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaAffaireAgent(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_affaire_theo")) {
         this.plansAnalytiques.setAnaAffaireTheo(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("ana_affaire_reel")) {
         this.plansAnalytiques.setAnaAffaireReel(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("ana_affaire_marge_theo")) {
         this.plansAnalytiques.setAnaAffaireMargeTheo(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("ana_affaire_marge_reel")) {
         this.plansAnalytiques.setAnaAffaireMargeReel(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("ana_affaires_conctact")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaAffaireContact(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_date_information")) {
         this.plansAnalytiques.setAnaDateInformation(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("ana_date_rdv")) {
         this.plansAnalytiques.setAnaDateRdv(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("ana_affaires_cout_reel")) {
         this.plansAnalytiques.setAnaAffaireCoutReel(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("ana_affaires_nb_jour_retard")) {
         this.plansAnalytiques.setAnaAffaireNbJourRetard(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_affaires_mode")) {
         this.plansAnalytiques.setAnaAffaireMode(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_affaires_id_client")) {
         this.plansAnalytiques.setAnaAffaireIdClient(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("ana_affaires_nom_client")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaAffaireNomClient(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_affaires_civilite_client")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaAffaireCiviliteClient(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_affaires_cat_client")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaAffaireCatClient(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("anaAffaire_exo_tva")) {
         this.plansAnalytiques.setAnaAffaireExoTva(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("anaAffaire_exo_douane")) {
         this.plansAnalytiques.setAnaAffaireExoDouane(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_affaires_id_contact")) {
         this.plansAnalytiques.setAnaAffaireIdContact(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("ana_affaires_nom_contact")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaAffaireNomContact(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_affaires_civilite_contact")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaAffaireCiviliteContact(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_affaires_id_responsable")) {
         this.plansAnalytiques.setAnaAffaireIdResponsable(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("ana_affaires_nom_responsable")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaAffaireNomResponsable(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_affaires_civilite_responsable")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaAffaireCiviliteResponsable(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_affaires_id_commercial")) {
         this.plansAnalytiques.setAnaAffaireIdCommercial(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("ana_affaires_nom_commercial")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaAffaireNomCommercial(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_affaires_civilite_commercial")) {
         if (var2 != null && !var2.isEmpty()) {
            this.plansAnalytiques.setAnaAffaireCiviliteCommercial(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("ana_affaires_date_demande")) {
         this.plansAnalytiques.setAnaAffaireDateDemande(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("ana_affaires_date_limite")) {
         this.plansAnalytiques.setAnaAffaireDatelimite(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("ana_lot_etat")) {
         this.plansAnalytiques.setAnaLotEtat(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_affaire_avion")) {
         this.plansAnalytiques.setAnaAffaireAvion(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_affaire_bateau")) {
         this.plansAnalytiques.setAnaAffaireBateau(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_affaire_express")) {
         this.plansAnalytiques.setAnaAffaireExpress(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_affaire_route")) {
         this.plansAnalytiques.setAnaAffaireRoute(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_affaire_reachem1")) {
         this.plansAnalytiques.setAnaAffaireReachem1(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_affaire_reachem2")) {
         this.plansAnalytiques.setAnaAffaireReachem2(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("ana_affaire_reachem3")) {
         this.plansAnalytiques.setAnaAffaireReachem3(this.conversionInteger(var2));
      } else {
         this.messageErreur = "La rubrique " + var1 + " n`existe pas...";
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertVentes.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertVentes);
      }

   }

   public void calculeRubCommandeEntete(String var1, String var2, Session var3) throws java.text.ParseException, HibernateException, NamingException {
      this.messageErreur = "";
      if (var1.equalsIgnoreCase("bcm_date_creat")) {
         this.commandeEnteteVentes.setBcmDateCreat(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_date_modif")) {
         this.commandeEnteteVentes.setBcmDateModif(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_id_createur")) {
         this.commandeEnteteVentes.setBcmIdCreateur(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("bcm_nom_createur")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmNomCreateur(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_id_modif")) {
         this.commandeEnteteVentes.setBcmIdModif(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("bcm_nom_modif")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmNomModif(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_date")) {
         this.commandeEnteteVentes.setBcmDate(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_num")) {
         if (var2 != null && !var2.isEmpty()) {
            String var4 = this.enlevePoint(var2).toUpperCase();
            this.commandeEnteteVentes = this.commandeEnteteVentesDao.selectByNum(var3, var4);
            if (this.commandeEnteteVentes == null) {
               this.commandeEnteteVentes = new CommandeEnteteVentes();
               this.commandeEnteteVentes.setBcmNum(var4);
            } else {
               this.commandeEnteteVentes.setBcmNum(var4);
            }
         }
      } else if (var1.equalsIgnoreCase("bcm_nom_equipe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmNomEquipe(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_id_equipe")) {
         this.commandeEnteteVentes.setBcmIdEquipe(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("bcm_nom_responsable")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmNomResponsable(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_id_responsable")) {
         this.commandeEnteteVentes.setBcmIdResponsable(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("bcm_nom_commercial")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmNomCommercial(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_id_commercial")) {
         this.commandeEnteteVentes.setBcmIdCommercial(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("bcm_nom_tiers")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmNomTiers(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_civil_tiers")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmCivilTiers(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_tiers_regroupe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmTiersRegroupe(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_id_contact")) {
         this.commandeEnteteVentes.setBcmIdContact(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("bcm_nom_contact")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmNomContact(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_civil_contact")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmCivilContact(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_serie")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmSerie(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_exo_tva")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmExoTva(this.conversionInteger(var2));
         }
      } else if (var1.equalsIgnoreCase("bcm_exo_douane")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmExoDouane(this.conversionInteger(var2));
         }
      } else if (var1.equalsIgnoreCase("bcm_suivi")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmSuivi(this.conversionInteger(var2));
         }
      } else if (var1.equalsIgnoreCase("bcm_cat")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmCat(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_devise")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmDevise(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_object")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmObject(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_observation")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmObservation(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_budget")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmBudget(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_taux_remise")) {
         this.commandeEnteteVentes.setBcmTauxRemise((float)this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("bcm_tot_ht")) {
         this.commandeEnteteVentes.setBcmTotHt(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcm_tot_remise")) {
         this.commandeEnteteVentes.setBcmTotRemise(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcm_tot_rabais")) {
         this.commandeEnteteVentes.setBcmTotRabais(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcm_tot_tva")) {
         this.commandeEnteteVentes.setBcmTotTva(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcm_taux_tc")) {
         this.commandeEnteteVentes.setBcmTauxTc((float)this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("bcm_tot_tc")) {
         this.commandeEnteteVentes.setBcmTotTc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcm_tot_ttc")) {
         this.commandeEnteteVentes.setBcmTotTtc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcm_tot_reglement")) {
         this.commandeEnteteVentes.setBcmTotReglement(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcm_tot_livre")) {
         this.commandeEnteteVentes.setBcmTotLivre(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcm_tot_timbre")) {
         this.commandeEnteteVentes.setBcmTotTimbre(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcm_solde")) {
         this.commandeEnteteVentes.setBcmSolde(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_banque")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmBanque(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_type_reg")) {
         this.commandeEnteteVentes.setBcmTypeReg(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_mode_reg")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmModeReg(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_echeance_reliquat")) {
         this.commandeEnteteVentes.setBcmEcheanceReliquat(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_motif_rejet_credit")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmMotifRejetCredit(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_nb_jour_reg")) {
         this.commandeEnteteVentes.setBcmNbJourReg(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_arrondi_reg")) {
         this.commandeEnteteVentes.setBcmArrondiReg(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_condition_reg")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmConditionReg(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_date_eche_reg")) {
         this.commandeEnteteVentes.setBcmDateEcheReg(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_date_last_reg")) {
         this.commandeEnteteVentes.setBcmDateLastReg(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_journal_reg")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmJournalReg(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_contener")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmContener(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_activite")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmActivite(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_site")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmSite(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_departement")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmDepartement(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_service")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmService(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_region")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmRegion(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_secteur")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmSecteur(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_pdv")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmPdv(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_anal2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmAnal2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_anal4")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmAnal4(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_affaire")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmAffaire(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_info1")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmInfo1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_info2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmInfo2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_info3")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmInfo3(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_info4")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmInfo4(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_info5")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmInfo5(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_info6")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmInfo1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_info7")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmInfo7(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_info8")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmInfo8(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_info9")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmInfo9(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_info10")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmInfo10(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_formule1")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmFormule1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_formule2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmFormule2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_annexe1")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmAnnexe1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_annexe2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmAnnexe2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_contrat")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmContrat(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_incoterm")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmIncoterm(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_lieu_livraison")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmLieuLivraison(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_date_livraison")) {
         this.commandeEnteteVentes.setBcmDateLivraison(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_compteur_report")) {
         this.commandeEnteteVentes.setBcmCompteurReport(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_info_livraison")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmInfoLivraison(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_mode_livraison")) {
         this.commandeEnteteVentes.setBcmModeLivraison(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_horaire_livraison")) {
         this.commandeEnteteVentes.setBcmHoraireLivraison(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_heure_livraison")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmHeureLivraison(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_contact_livraison")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmContactLivraison(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_telephone_livraison")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmTelephoneLivraison(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_etat_livraison")) {
         this.commandeEnteteVentes.setBcmEtatLivraison(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_observation_livraison")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmObservationLivraison(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_date_imp")) {
         this.commandeEnteteVentes.setBcmDateImp(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_modele_imp")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmModeleImp(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_garde")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmGarde(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_etat_val")) {
         this.commandeEnteteVentes.setBcmEtatVal(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_gele")) {
         this.commandeEnteteVentes.setBcmGele(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_etat")) {
         this.commandeEnteteVentes.setBcmEtat(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_date_validite")) {
         this.commandeEnteteVentes.setBcmDateValidite(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_date_relance")) {
         this.commandeEnteteVentes.setBcmDateRelance(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_date_valide")) {
         this.commandeEnteteVentes.setBcmDateValide(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_pos_signature")) {
         this.commandeEnteteVentes.setBcmPosSignature(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_date_transforme")) {
         this.commandeEnteteVentes.setBcmDateTransforme(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_type_transforme")) {
         this.commandeEnteteVentes.setBcmTypeTransforme(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_date_annule")) {
         this.commandeEnteteVentes.setBcmDateAnnule(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_motif_annule")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmMotifAnnule(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_niveau")) {
         this.commandeEnteteVentes.setBcmNiveau(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_preparateur")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmPreparateur(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_conseil")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmConseil(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_date_transfert")) {
         this.commandeEnteteVentes.setBcmDateTransfert(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_num_trf")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmNumTrf(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_factor_nom")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmFactorNom(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_factor_id")) {
         this.commandeEnteteVentes.setBcmFactorId(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("bcm_factor_etat")) {
         this.commandeEnteteVentes.setBcmFactorEtat(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_phase")) {
         this.commandeEnteteVentes.setBcmPhase(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_divers_tiers")) {
         this.commandeEnteteVentes.setBcmDiversTiers(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_divers_nom")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmDiversNom(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_divers_adresse")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmDiversAdresse(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_divers_ville")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmDiversVille(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_divers_tel")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmDiversTel(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_divers_mail")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmDiversMail(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_source")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmSource(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_stock")) {
         this.commandeEnteteVentes.setBcmStock(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcm_pj")) {
         this.commandeEnteteVentes.setBcmPj(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("bcm_ristourne_bloquee")) {
         this.commandeEnteteVentes.setBcmRistourneBloquee(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("bcm_num_client")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeEnteteVentes.setBcmNumClient(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcm_date_client")) {
         this.commandeEnteteVentes.setBcmDateClient(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_poids")) {
         this.commandeEnteteVentes.setBcmPoids((float)this.conversionDouble(var2));
      } else {
         this.messageErreur = "La rubrique " + var1 + " n`existe pas...";
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertVentes.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertVentes);
      }

   }

   public void calculeRubDevisEntete(String var1, String var2, Session var3) throws java.text.ParseException, HibernateException, NamingException {
      this.messageErreur = "";
      if (var1.equalsIgnoreCase("dvs_date_creat")) {
         this.devisEnteteVentes.setDvsDateCreat(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("dvs_date_modif")) {
         this.devisEnteteVentes.setDvsDateModif(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("dvs_id_createur")) {
         this.devisEnteteVentes.setDvsIdCreateur(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("dvs_nom_createur")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsNomCreateur(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_id_modif")) {
         this.devisEnteteVentes.setDvsIdModif(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("dvs_nom_modif")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsNomModif(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_date")) {
         this.devisEnteteVentes.setDvsDate(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("dvs_num")) {
         if (var2 != null && !var2.isEmpty()) {
            String var4 = this.enlevePoint(var2).toUpperCase();
            this.devisEnteteVentes = this.devisEnteteVentesDao.selectByNum(var3, var4);
            if (this.devisEnteteVentes == null) {
               this.devisEnteteVentes = new DevisEnteteVentes();
               this.devisEnteteVentes.setDvsNum(var4);
            } else {
               this.devisEnteteVentes.setDvsNum(var4);
            }
         }
      } else if (var1.equalsIgnoreCase("dvs_nom_equipe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsNomEquipe(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_id_equipe")) {
         this.devisEnteteVentes.setDvsIdEquipe(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("dvs_nom_responsable")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsNomResponsable(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_id_responsable")) {
         this.devisEnteteVentes.setDvsIdResponsable(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("dvs_nom_commercial")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsNomCommercial(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_id_commercial")) {
         this.devisEnteteVentes.setDvsIdCommercial(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("dvs_nom_tiers")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsNomTiers(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_civil_tiers")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsCivilTiers(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_tiers_regroupe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsTiersRegroupe(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_id_contact")) {
         this.devisEnteteVentes.setDvsIdContact(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("dvs_nom_contact")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsNomContact(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_civil_contact")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsCivilContact(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_serie")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsSerie(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_exo_tva")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsExoTva(this.conversionInteger(var2));
         }
      } else if (var1.equalsIgnoreCase("dvs_exo_douane")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsExoDouane(this.conversionInteger(var2));
         }
      } else if (var1.equalsIgnoreCase("dvs_suivi")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsSuivi(this.conversionInteger(var2));
         }
      } else if (var1.equalsIgnoreCase("dvs_cat")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsCat(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_devise")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsDevise(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_object")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsObject(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_observation")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsObservation(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_taux_remise")) {
         this.devisEnteteVentes.setDvsTauxRemise((float)this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("dvs_tot_ht")) {
         this.devisEnteteVentes.setDvsTotHt(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvs_tot_remise")) {
         this.devisEnteteVentes.setDvsTotRemise(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvs_tot_rabais")) {
         this.devisEnteteVentes.setDvsTotRabais(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvs_tot_tva")) {
         this.devisEnteteVentes.setDvsTotTva(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvs_taux_tc")) {
         this.devisEnteteVentes.setDvsTauxTc((float)this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("dvs_tot_tc")) {
         this.devisEnteteVentes.setDvsTotTc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvs_tot_ttc")) {
         this.devisEnteteVentes.setDvsTotTtc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvs_tot_reglement")) {
         this.devisEnteteVentes.setDvsTotReglement(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvs_solde")) {
         this.devisEnteteVentes.setDvsSolde(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvs_banque")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsBanque(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_type_reg")) {
         this.devisEnteteVentes.setDvsTypeReg(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvs_mode_reg")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsModeReg(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_echeance_reliquat")) {
         this.devisEnteteVentes.setDvsEcheanceReliquat(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("dvs_motif_rejet_credit")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsMotifRejetCredit(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_nb_jour_reg")) {
         this.devisEnteteVentes.setDvsNbJourReg(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvs_arrondi_reg")) {
         this.devisEnteteVentes.setDvsArrondiReg(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvs_condition_reg")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsConditionReg(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_date_eche_reg")) {
         this.devisEnteteVentes.setDvsDateEcheReg(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("dvs_contener")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsContener(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_activite")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsActivite(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_site")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsSite(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_departement")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsDepartement(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_service")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsService(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_region")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsRegion(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_secteur")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsSecteur(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_pdv")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsPdv(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_anal2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsAnal2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_anal4")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsAnal4(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_affaire")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsAffaire(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_info1")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsInfo1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_info2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsInfo2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_info3")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsInfo3(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_info4")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsInfo4(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_info5")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsInfo5(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_info6")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsInfo1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_info7")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsInfo7(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_info8")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsInfo8(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_info9")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsInfo9(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_info10")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsInfo10(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_formule1")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsFormule1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_formule2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsFormule2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_annexe1")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsAnnexe1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_annexe2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsAnnexe2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_contrat")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsContrat(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_incoterm")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsIncoterm(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_lieu_livraison")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsLieuLivraison(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_date_livraison")) {
         this.devisEnteteVentes.setDvsDateLivraison(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("dvs_date_imp")) {
         this.devisEnteteVentes.setDvsDateImp(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("dvs_modele_imp")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsModeleImp(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_garde")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsGarde(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_etat_val")) {
         this.devisEnteteVentes.setDvsEtatVal(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvs_gele")) {
         this.devisEnteteVentes.setDvsGele(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvs_etat")) {
         this.devisEnteteVentes.setDvsEtat(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvs_date_validite")) {
         this.devisEnteteVentes.setDvsDateValidite(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("dvs_date_relance")) {
         this.devisEnteteVentes.setDvsDateRelance(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("bcm_date_valide")) {
         this.devisEnteteVentes.setDvsDateValide(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("dvs_pos_signature")) {
         this.devisEnteteVentes.setDvsPosSignature(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvs_date_transforme")) {
         this.devisEnteteVentes.setDvsDateTransforme(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("dvs_type_transforme")) {
         this.devisEnteteVentes.setDvsTypeTransforme(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvs_date_annule")) {
         this.devisEnteteVentes.setDvsDateAnnule(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("dvs_motif_annule")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsMotifAnnule(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_factor_nom")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsFactorNom(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_factor_id")) {
         this.devisEnteteVentes.setDvsFactorId(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("dvs_factor_etat")) {
         this.devisEnteteVentes.setDvsFactorEtat(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvs_divers_tiers")) {
         this.devisEnteteVentes.setDvsDiversTiers(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvs_divers_nom")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsDiversNom(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_divers_adresse")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsDiversAdresse(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_divers_ville")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsDiversVille(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_divers_tel")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsDiversTel(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_divers_mail")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsDiversMail(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_source")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisEnteteVentes.setDvsSource(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvs_poids")) {
         this.devisEnteteVentes.setDvsPoids((float)this.conversionLong(var2));
      } else {
         this.messageErreur = "La rubrique " + var1 + " n`existe pas...";
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertVentes.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertVentes);
      }

   }

   public void calculeRubCommandeLigne(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.messageErreur = "";
      if (var1.equalsIgnoreCase("bcmlig_ordre")) {
         this.commandeLigneVentes.setBcmligOrdre(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_id_dvs")) {
         this.commandeLigneVentes.setBcmligIdDvs(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_code")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeLigneVentes.setBcmligCode(this.enlevePoint(var2).toUpperCase());
            this.produits = this.produitsAchsDao.chargeToutProduit(this.commandeLigneVentes.getBcmligCode(), var3);
            if (this.produits != null) {
               this.commandeLigneVentes.setBcmligFamille(this.produits.getProVteCode());
               this.commandeLigneVentes.setBcmligLibelle(this.produits.getProLibClient());
               this.commandeLigneVentes.setBcmligLong(this.produits.getProLongueur());
               this.commandeLigneVentes.setBcmligLarg(this.produits.getProLargeur());
               this.commandeLigneVentes.setBcmligHaut(this.produits.getProEpaisseur());
               this.commandeLigneVentes.setBcmligDiam(this.produits.getProDiamExt());
               this.commandeLigneVentes.setBcmligVolume(this.produits.getProVolume());
               this.commandeLigneVentes.setBcmligPoidsNet(this.produits.getProPoidsNet());
               this.commandeLigneVentes.setBcmligPoidsBrut(this.produits.getProPoidsBrut());
               this.commandeLigneVentes.setBcmligNb(this.produits.getProNbUnite());
            }
         }
      } else if (var1.equalsIgnoreCase("bcmlig_process")) {
         this.commandeLigneVentes.setBcmligProcess(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_famille")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeLigneVentes.setBcmligFamille(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcmlig_libelle")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeLigneVentes.setBcmligLibelle(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcmlig_complement")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeLigneVentes.setBcmligComplement(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcmlig_reference")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeLigneVentes.setBcmligReference(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcmlig_taxe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeLigneVentes.setBcmligTaxe(this.enlevePoint(var2).toUpperCase());
            this.taxesVentes = this.taxesVentesDao.selectTva((long)this.nature, this.commandeLigneVentes.getBcmligTaxe(), var3);
            if (this.taxesVentes != null) {
               this.commandeLigneVentes.setBcmligTauxTaxe(this.taxesVentes.getTaxvteTaux());
            }
         }
      } else if (var1.equalsIgnoreCase("bcmlig_taux_taxe")) {
         this.commandeLigneVentes.setBcmligTauxTaxe((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_unite")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeLigneVentes.setBcmligUnite(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcmlig_condition")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeLigneVentes.setBcmligCondition(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcmlig_description")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeLigneVentes.setBcmligDescription(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcmlig_echelle")) {
         this.commandeLigneVentes.setBcmligEchelle(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_qte")) {
         this.commandeLigneVentes.setBcmligQte((float)this.conversionDouble(var2));
         this.commandeLigneVentes.setBcmligQteUtil((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_long")) {
         this.commandeLigneVentes.setBcmligLong((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_larg")) {
         this.commandeLigneVentes.setBcmligLarg((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_haut")) {
         this.commandeLigneVentes.setBcmligHaut((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_diam")) {
         this.commandeLigneVentes.setBcmligDiam((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_nb")) {
         this.commandeLigneVentes.setBcmligNb((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_poidsNet")) {
         this.commandeLigneVentes.setBcmligPoidsNet((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_poidsBrut")) {
         this.commandeLigneVentes.setBcmligPoidsBrut((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_volume")) {
         this.commandeLigneVentes.setBcmligVolume((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_depot")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeLigneVentes.setBcmligDepot(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcmlig_stock")) {
         this.commandeLigneVentes.setBcmligStock(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_qte_util")) {
         this.commandeLigneVentes.setBcmligQteUtil((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_qte_stock")) {
         this.commandeLigneVentes.setBcmligQteStock((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_devise")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeLigneVentes.setBcmligDevise(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcmlig_pu")) {
         this.commandeLigneVentes.setBcmligPu((double)((float)this.conversionDouble(var2)));
      } else if (var1.equalsIgnoreCase("bcmlig_taux_remise")) {
         this.commandeLigneVentes.setBcmligTauxRemise((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_rabais")) {
         this.commandeLigneVentes.setBcmligRabais(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_pu_rem")) {
         this.commandeLigneVentes.setBcmligPuRem(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_pu_ttc")) {
         this.commandeLigneVentes.setBcmligPuTtc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_pu_rem_ttc")) {
         this.commandeLigneVentes.setBcmligPuRemTtc((double)((float)this.conversionLong(var2)));
      } else if (var1.equalsIgnoreCase("bcmlig_pt")) {
         this.commandeLigneVentes.setBcmligPt(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_tva")) {
         this.commandeLigneVentes.setBcmligTva(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_tc")) {
         this.commandeLigneVentes.setBcmligTc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_ttc")) {
         this.commandeLigneVentes.setBcmligTtc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_pump")) {
         this.commandeLigneVentes.setBcmligPump(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_qte_livree")) {
         this.commandeLigneVentes.setBcmligQteLivree((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_groupe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.commandeLigneVentes.setBcmligGroupe(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("bcmlig_mode_groupe")) {
         this.commandeLigneVentes.setBcmligModeGroupe(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("bcmlig_ent_stock")) {
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertVentes.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertVentes);
      }

   }

   public void calculeRubDevisLigne(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.messageErreur = "";
      if (var1.equalsIgnoreCase("dvslig_ordre")) {
         this.devisLigneVentes.setDvsligOrdre(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvslig_code")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisLigneVentes.setDvsligCode(this.enlevePoint(var2).toUpperCase());
            this.produits = this.produitsAchsDao.chargeToutProduit(this.devisLigneVentes.getDvsligCode(), var3);
            if (this.produits != null) {
               this.devisLigneVentes.setDvsligFamille(this.produits.getProVteCode());
               this.devisLigneVentes.setDvsligLibelle(this.produits.getProLibClient());
               this.devisLigneVentes.setDvsligLong(this.produits.getProLongueur());
               this.devisLigneVentes.setDvsligLarg(this.produits.getProLargeur());
               this.devisLigneVentes.setDvsligHaut(this.produits.getProEpaisseur());
               this.devisLigneVentes.setDvsligDiam(this.produits.getProDiamExt());
               this.devisLigneVentes.setDvsligVolume(this.produits.getProVolume());
               this.devisLigneVentes.setDvsligPoidsNet(this.produits.getProPoidsNet());
               this.devisLigneVentes.setDvsligPoidsBrut(this.produits.getProPoidsBrut());
               this.devisLigneVentes.setDvsligNb(this.produits.getProNbUnite());
            }
         }
      } else if (var1.equalsIgnoreCase("dvslig_process")) {
         this.devisLigneVentes.setDvsligProcess(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvslig_famille")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisLigneVentes.setDvsligFamille(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvslig_libelle")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisLigneVentes.setDvsligLibelle(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvslig_complement")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisLigneVentes.setDvsligComplement(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvslig_reference")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisLigneVentes.setDvsligReference(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvslig_taxe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisLigneVentes.setDvsligTaxe(this.enlevePoint(var2).toUpperCase());
            this.taxesVentes = this.taxesVentesDao.selectTva((long)this.nature, this.devisLigneVentes.getDvsligTaxe(), var3);
            if (this.taxesVentes != null) {
               this.devisLigneVentes.setDvsligTauxTaxe(this.taxesVentes.getTaxvteTaux());
            }
         }
      } else if (var1.equalsIgnoreCase("dvslig_taux_taxe")) {
         this.devisLigneVentes.setDvsligTauxTaxe((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_unite")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisLigneVentes.setDvsligUnite(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvslig_condition")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisLigneVentes.setDvsligCondition(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvslig_description")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisLigneVentes.setDvsligDescription(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvslig_echelle")) {
         this.devisLigneVentes.setDvsligEchelle(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvslig_qte")) {
         this.devisLigneVentes.setDvsligQte((float)this.conversionDouble(var2));
         this.devisLigneVentes.setDvsligQteUtil((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_long")) {
         this.devisLigneVentes.setDvsligLong((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_larg")) {
         this.devisLigneVentes.setDvsligLarg((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_haut")) {
         this.devisLigneVentes.setDvsligHaut((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_diam")) {
         this.devisLigneVentes.setDvsligDiam((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_nb")) {
         this.devisLigneVentes.setDvsligNb((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_poidsNet")) {
         this.devisLigneVentes.setDvsligPoidsNet((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_poidsBrut")) {
         this.devisLigneVentes.setDvsligPoidsBrut((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_volume")) {
         this.devisLigneVentes.setDvsligVolume((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_depot")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisLigneVentes.setDvsligDepot(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvslig_stock")) {
         this.devisLigneVentes.setDvsligStock(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvslig_qte_util")) {
         this.devisLigneVentes.setDvsligQteUtil((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_devise")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisLigneVentes.setDvsligDevise(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvslig_pu")) {
         this.devisLigneVentes.setDvsligPu((double)((float)this.conversionDouble(var2)));
      } else if (var1.equalsIgnoreCase("dvslig_taux_remise")) {
         this.devisLigneVentes.setDvsligTauxRemise((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_rabais")) {
         this.devisLigneVentes.setDvsligRabais(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_pu_rem")) {
         this.devisLigneVentes.setDvsligPuRem(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_pu_ttc")) {
         this.devisLigneVentes.setDvsligPuTtc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_pu_rem_ttc")) {
         this.devisLigneVentes.setDvsligPuRemTtc((double)((float)this.conversionLong(var2)));
      } else if (var1.equalsIgnoreCase("dvslig_pt")) {
         this.devisLigneVentes.setDvsligPt(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_tva")) {
         this.devisLigneVentes.setDvsligTva(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_tc")) {
         this.devisLigneVentes.setDvsligTc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_ttc")) {
         this.devisLigneVentes.setDvsligTtc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_pump")) {
         this.devisLigneVentes.setDvsligPump(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("dvslig_groupe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.devisLigneVentes.setDvsligGroupe(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("dvslig_mode_groupe")) {
         this.devisLigneVentes.setDvsligModeGroupe(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("dvslig_ent_stock")) {
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertVentes.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertVentes);
      }

   }

   public void calculeRubLivraisonEntete(String var1, String var2, Session var3) throws java.text.ParseException, HibernateException, NamingException {
      this.messageErreur = "";
      if (var1.equalsIgnoreCase("blv_date_creat")) {
         this.livraisonEnteteVentes.setBlvDateCreat(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("blv_date_modif")) {
         this.livraisonEnteteVentes.setBlvDateModif(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("blv_id_createur")) {
         this.livraisonEnteteVentes.setBlvIdCreateur(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("blv_nom_createur")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvNomCreateur(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_id_modif")) {
         this.livraisonEnteteVentes.setBlvIdModif(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("blv_nom_modif")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvNomModif(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_date")) {
         this.livraisonEnteteVentes.setBlvDate(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("blv_num")) {
         if (var2 != null && !var2.isEmpty()) {
            String var4 = this.enlevePoint(var2).toUpperCase();
            this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.pourParapheurByNum(var4, (String)null, var3);
            if (this.livraisonEnteteVentes == null) {
               this.livraisonEnteteVentes = new LivraisonEnteteVentes();
               this.livraisonEnteteVentes.setBlvNum(var4);
            } else {
               this.livraisonEnteteVentes.setBlvNum(var4);
            }
         }
      } else if (var1.equalsIgnoreCase("blvo_num_facture")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvNumFacture(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_nom_equipe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvNomEquipe(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_id_equipe")) {
         this.livraisonEnteteVentes.setBlvIdEquipe(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("blv_nom_responsable")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvNomResponsable(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_id_responsable")) {
         this.livraisonEnteteVentes.setBlvIdResponsable(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("blv_nom_commercial")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvNomCommercial(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_id_commercial")) {
         this.livraisonEnteteVentes.setBlvIdCommercial(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("blv_nom_tiers")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvNomTiers(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_civil_tiers")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvCivilTiers(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_tiers_regroupe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvTiersRegroupe(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_id_contact")) {
         this.livraisonEnteteVentes.setBlvIdContact(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("blv_nom_contact")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvNomContact(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_civil_contact")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvCivilContact(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_serie")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvSerie(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_exo_tva")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvExoTva(this.conversionInteger(var2));
         }
      } else if (var1.equalsIgnoreCase("blv_exo_douane")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvExoDouane(this.conversionInteger(var2));
         }
      } else if (var1.equalsIgnoreCase("blv_cat")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvCat(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_devise")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvDevise(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_object")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvObject(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_observation")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvObservation(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_budget")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvBudget(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_taux_remise")) {
         this.livraisonEnteteVentes.setBlvTauxRemise((float)this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("blv_tot_ht")) {
         this.livraisonEnteteVentes.setBlvTotHt(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blv_tot_remise")) {
         this.livraisonEnteteVentes.setBlvTotRemise(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blv_tot_rabais")) {
         this.livraisonEnteteVentes.setBlvTotRabais(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blv_tot_tva")) {
         this.livraisonEnteteVentes.setBlvTotTva(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blv_taux_tc")) {
         this.livraisonEnteteVentes.setBlvTauxTc((float)this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("blv_tot_tc")) {
         this.livraisonEnteteVentes.setBlvTotTc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blv_tot_ttc")) {
         this.livraisonEnteteVentes.setBlvTotTtc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blv_tot_reglement")) {
         this.livraisonEnteteVentes.setBlvTotReglement(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blv_tot_timbre")) {
         this.livraisonEnteteVentes.setBlvTotTimbre(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blv_solde")) {
         this.livraisonEnteteVentes.setBlvSolde(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blv_banque")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvBanque(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_type_reg")) {
         this.livraisonEnteteVentes.setBlvTypeReg(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blv_mode_reg")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvModeReg(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_echeance_reliquat")) {
         this.livraisonEnteteVentes.setBlvEcheanceReliquat(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("blv_motif_rejet_credit")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvMotifRejetCredit(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_nb_jour_reg")) {
         this.livraisonEnteteVentes.setBlvNbJourReg(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blv_arrondi_reg")) {
         this.livraisonEnteteVentes.setBlvArrondiReg(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blv_condition_reg")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvConditionReg(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_date_eche_reg")) {
         this.livraisonEnteteVentes.setBlvDateEcheReg(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("blv_date_last_reg")) {
         this.livraisonEnteteVentes.setBlvDateLastReg(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("blv_journal_reg")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvJournalReg(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_contener")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvContener(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_activite")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvActivite(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_site")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvSite(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_departement")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvDepartement(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_service")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvService(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_region")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvRegion(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_secteur")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvSecteur(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_pdv")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvPdv(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_anal2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvAnal2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_anal4")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvAnal4(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_affaire")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvAffaire(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_info1")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvInfo1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_info2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvInfo2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_info3")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvInfo3(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_info4")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvInfo4(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_info5")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvInfo5(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_info6")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvInfo1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_info7")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvInfo7(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_info8")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvInfo8(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_info9")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvInfo9(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_info10")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvInfo10(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_formule1")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvFormule1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_formule2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvFormule2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_annexe1")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvAnnexe1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_annexe2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvAnnexe2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_contrat")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvContrat(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_incoterm")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvIncoterm(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_lieu_livraison")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvLieuLivraison(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_date_livraison")) {
         this.livraisonEnteteVentes.setBlvDateLivraison(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("blv_info_livraison")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvInfoLivraison(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_date_imp")) {
         this.livraisonEnteteVentes.setBlvDateImp(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("blv_modele_imp")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvModeleImp(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_garde")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvGarde(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_etat_val")) {
         this.livraisonEnteteVentes.setBlvEtatVal(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blv_gele")) {
         this.livraisonEnteteVentes.setBlvGele(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blv_etat")) {
         this.livraisonEnteteVentes.setBlvEtat(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blv_date_validite")) {
         this.livraisonEnteteVentes.setBlvDateValidite(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("blv_date_relance")) {
         this.livraisonEnteteVentes.setBlvDateRelance(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("blv_date_valide")) {
         this.livraisonEnteteVentes.setBlvDateValide(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("blv_pos_signature")) {
         this.livraisonEnteteVentes.setBlvPosSignature(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blv_date_transforme")) {
         this.livraisonEnteteVentes.setBlvDateTransforme(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("blv_type_transforme")) {
         this.livraisonEnteteVentes.setBlvTypeTransforme(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blv_date_annule")) {
         this.livraisonEnteteVentes.setBlvDateAnnule(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("blv_motif_annule")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvMotifAnnule(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_date_transfert")) {
         this.livraisonEnteteVentes.setBlvDateTransfert(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("blv_num_trf")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvNumTrf(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_factor_nom")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvFactorNom(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_factor_id")) {
         this.livraisonEnteteVentes.setBlvFactorId(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("blv_factor_etat")) {
         this.livraisonEnteteVentes.setBlvFactorEtat(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blv_divers_tiers")) {
         this.livraisonEnteteVentes.setBlvDiversTiers(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blv_divers_nom")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvDiversNom(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_divers_adresse")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvDiversAdresse(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_divers_ville")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvDiversVille(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_divers_tel")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvDiversTel(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_divers_mail")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvDiversMail(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_source")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvSource(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_stock")) {
         this.livraisonEnteteVentes.setBlvStock(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blv_pj")) {
         this.livraisonEnteteVentes.setBlvPj(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("blv_ristourne_bloquee")) {
         this.livraisonEnteteVentes.setBlvRistourneBloquee(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("blv_num_client")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonEnteteVentes.setBlvNumClient(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blv_date_client")) {
         this.livraisonEnteteVentes.setBlvDateClient(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("blv_poids")) {
         this.livraisonEnteteVentes.setBlvPoids((float)this.conversionDouble(var2));
      } else {
         this.messageErreur = "La rubrique " + var1 + " n`existe pas...";
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertVentes.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertVentes);
      }

   }

   public void calculeRubLivraisonLigne(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.messageErreur = "";
      if (var1.equalsIgnoreCase("blvlig_ordre")) {
         this.livraisonLigneVentes.setBlvligOrdre(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blvlig_id_dvs")) {
         this.livraisonLigneVentes.setBlvligIdDvs(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("blvlig_code")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonLigneVentes.setBlvligCode(this.enlevePoint(var2).toUpperCase());
            this.produits = this.produitsAchsDao.chargeToutProduit(this.livraisonLigneVentes.getBlvligCode(), var3);
            if (this.produits != null) {
               this.livraisonLigneVentes.setBlvligFamille(this.produits.getProVteCode());
               this.livraisonLigneVentes.setBlvligLibelle(this.produits.getProLibClient());
               this.livraisonLigneVentes.setBlvligLong(this.produits.getProLongueur());
               this.livraisonLigneVentes.setBlvligLarg(this.produits.getProLargeur());
               this.livraisonLigneVentes.setBlvligHaut(this.produits.getProEpaisseur());
               this.livraisonLigneVentes.setBlvligDiam(this.produits.getProDiamExt());
               this.livraisonLigneVentes.setBlvligVolume(this.produits.getProVolume());
               this.livraisonLigneVentes.setBlvligPoidsNet(this.produits.getProPoidsNet());
               this.livraisonLigneVentes.setBlvligPoidsBrut(this.produits.getProPoidsBrut());
               this.livraisonLigneVentes.setBlvligNb(this.produits.getProNbUnite());
            }
         }
      } else if (var1.equalsIgnoreCase("blvlig_process")) {
         this.livraisonLigneVentes.setBlvligProcess(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blvlig_famille")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonLigneVentes.setBlvligFamille(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blvlig_libelle")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonLigneVentes.setBlvligLibelle(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blvlig_complement")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonLigneVentes.setBlvligComplement(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blvlig_reference")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonLigneVentes.setBlvligReference(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blvlig_taxe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonLigneVentes.setBlvligTaxe(this.enlevePoint(var2).toUpperCase());
            this.taxesVentes = this.taxesVentesDao.selectTva((long)this.nature, this.livraisonLigneVentes.getBlvligTaxe(), var3);
            if (this.taxesVentes != null) {
               this.livraisonLigneVentes.setBlvligTauxTaxe(this.taxesVentes.getTaxvteTaux());
            }
         }
      } else if (var1.equalsIgnoreCase("blvlig_taux_taxe")) {
         this.livraisonLigneVentes.setBlvligTauxTaxe((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_unite")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonLigneVentes.setBlvligUnite(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blvlig_condition")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonLigneVentes.setBlvligCondition(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blvlig_description")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonLigneVentes.setBlvligDescription(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blvlig_echelle")) {
         this.livraisonLigneVentes.setBlvligEchelle(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blvlig_qte")) {
         this.livraisonLigneVentes.setBlvligQte((float)this.conversionDouble(var2));
         this.livraisonLigneVentes.setBlvligQteUtil((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_long")) {
         this.livraisonLigneVentes.setBlvligLong((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_larg")) {
         this.livraisonLigneVentes.setBlvligLarg((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_haut")) {
         this.livraisonLigneVentes.setBlvligHaut((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_diam")) {
         this.livraisonLigneVentes.setBlvligDiam((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_nb")) {
         this.livraisonLigneVentes.setBlvligNb((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_poidsNet")) {
         this.livraisonLigneVentes.setBlvligPoidsNet((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_poidsBrut")) {
         this.livraisonLigneVentes.setBlvligPoidsBrut((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_volume")) {
         this.livraisonLigneVentes.setBlvligVolume((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_depot")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonLigneVentes.setBlvligDepot(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blvlig_stock")) {
         this.livraisonLigneVentes.setBlvligStock(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blvlig_qte_util")) {
         this.livraisonLigneVentes.setBlvligQteUtil((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_qte_stock")) {
         this.livraisonLigneVentes.setBlvligQteStock((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_devise")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonLigneVentes.setBlvligDevise(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blvlig_pu")) {
         this.livraisonLigneVentes.setBlvligPu((double)((float)this.conversionDouble(var2)));
      } else if (var1.equalsIgnoreCase("blvlig_taux_remise")) {
         this.livraisonLigneVentes.setBlvligTauxRemise((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_rabais")) {
         this.livraisonLigneVentes.setBlvligRabais(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_pu_rem")) {
         this.livraisonLigneVentes.setBlvligPuRem(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_pu_ttc")) {
         this.livraisonLigneVentes.setBlvligPuTtc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_pu_rem_ttc")) {
         this.livraisonLigneVentes.setBlvligPuRemTtc((double)((float)this.conversionLong(var2)));
      } else if (var1.equalsIgnoreCase("blvlig_pt")) {
         this.livraisonLigneVentes.setBlvligPt(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_tva")) {
         this.livraisonLigneVentes.setBlvligTva(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_tc")) {
         this.livraisonLigneVentes.setBlvligTc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_ttc")) {
         this.livraisonLigneVentes.setBlvligTtc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_pump")) {
         this.livraisonLigneVentes.setBlvligPump(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("blvlig_groupe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.livraisonLigneVentes.setBlvligGroupe(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("blvlig_mode_groupe")) {
         this.livraisonLigneVentes.setBlvligModeGroupe(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("blvlig_ent_stock")) {
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertVentes.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertVentes);
      }

   }

   public void calculeRubFactureEntete(String var1, String var2, Session var3) throws java.text.ParseException, HibernateException, NamingException {
      this.messageErreur = "";
      if (var1.equalsIgnoreCase("fac_date_creat")) {
         this.factureEnteteVentes.setFacDateCreat(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("fac_date_modif")) {
         this.factureEnteteVentes.setFacDateModif(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("fac_id_createur")) {
         this.factureEnteteVentes.setFacIdCreateur(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("fac_nom_createur")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacNomCreateur(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_id_modif")) {
         this.factureEnteteVentes.setFacIdModif(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("fac_nom_modif")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacNomModif(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_date")) {
         this.factureEnteteVentes.setFacDate(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("fac_num")) {
         if (var2 != null && !var2.isEmpty()) {
            String var4 = this.enlevePoint(var2).toUpperCase();
            this.factureEnteteVentes = this.factureEnteteVentesDao.pourParapheur(var4, (String)null, var3);
            if (this.factureEnteteVentes == null) {
               this.factureEnteteVentes = new FactureEnteteVentes();
               this.factureEnteteVentes.setFacNum(var4);
            } else {
               this.factureEnteteVentes.setFacNum(var4);
            }
         }
      } else if (var1.equalsIgnoreCase("fac_nom_equipe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacNomEquipe(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_id_equipe")) {
         this.factureEnteteVentes.setFacIdEquipe(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("fac_nom_responsable")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacNomResponsable(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_id_responsable")) {
         this.factureEnteteVentes.setFacIdResponsable(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("fac_nom_commercial")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacNomCommercial(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_id_commercial")) {
         this.factureEnteteVentes.setFacIdCommercial(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("fac_nom_tiers")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacNomTiers(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_civil_tiers")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacCivilTiers(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_tiers_regroupe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacTiersRegroupe(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_id_contact")) {
         this.factureEnteteVentes.setFacIdContact(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("fac_nom_contact")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacNomContact(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_civil_contact")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacCivilContact(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_serie")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacSerie(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_exo_tva")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacExoTva(this.conversionInteger(var2));
         }
      } else if (var1.equalsIgnoreCase("fac_exo_douane")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacExoDouane(this.conversionInteger(var2));
         }
      } else if (var1.equalsIgnoreCase("fac_cat")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacCat(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_devise")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacDevise(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_object")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacObject(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_observation")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacObservation(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_budget")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacBudget(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_taux_remise")) {
         this.factureEnteteVentes.setFacTauxRemise((float)this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("fac_tot_ht")) {
         this.factureEnteteVentes.setFacTotHt(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("fac_tot_remise")) {
         this.factureEnteteVentes.setFacTotRemise(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("fac_tot_rabais")) {
         this.factureEnteteVentes.setFacTotRabais(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("fac_tot_tva")) {
         this.factureEnteteVentes.setFacTotTva(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("fac_taux_tc")) {
         this.factureEnteteVentes.setFacTauxTc((float)this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("fac_tot_tc")) {
         this.factureEnteteVentes.setFacTotTc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("fac_tot_ttc")) {
         this.factureEnteteVentes.setFacTotTtc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("fac_tot_reglement")) {
         this.factureEnteteVentes.setFacTotReglement(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("fac_tot_timbre")) {
         this.factureEnteteVentes.setFacTotTimbre(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("fac_solde")) {
         this.factureEnteteVentes.setFacSolde(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("fac_banque")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacBanque(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_type_reg")) {
         this.factureEnteteVentes.setFacTypeReg(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("fac_mode_reg")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacModeReg(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_echeance_reliquat")) {
         this.factureEnteteVentes.setFacEcheanceReliquat(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("fac_motif_rejet_credit")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacMotifRejetCredit(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_nb_jour_reg")) {
         this.factureEnteteVentes.setFacNbJourReg(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("fac_arrondi_reg")) {
         this.factureEnteteVentes.setFacArrondiReg(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("fac_condition_reg")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacConditionReg(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_date_eche_reg")) {
         this.factureEnteteVentes.setFacDateEcheReg(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("fac_date_last_reg")) {
         this.factureEnteteVentes.setFacDateLastReg(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("fac_journal_reg")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacJournalReg(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_contener")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacContener(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_activite")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacActivite(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_site")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacSite(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_departement")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacDepartement(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_service")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacService(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_region")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacRegion(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_secteur")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacSecteur(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_pdv")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacPdv(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_anal2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacAnal2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_anal4")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacAnal4(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_affaire")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacAffaire(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_info1")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacInfo1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_info2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacInfo2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_info3")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacInfo3(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_info4")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacInfo4(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_info5")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacInfo5(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_info6")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacInfo1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_info7")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacInfo7(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_info8")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacInfo8(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_info9")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacInfo9(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_info10")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacInfo10(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_formule1")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacFormule1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_formule2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacFormule2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_annexe1")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacAnnexe1(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_annexe2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacAnnexe2(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_contrat")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacContrat(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_incoterm")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacIncoterm(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_lieu_livraison")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacLieuLivraison(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_date_livraison")) {
         this.factureEnteteVentes.setFacDateLivraison(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("fac_info_livraison")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacInfoLivraison(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_date_imp")) {
         this.factureEnteteVentes.setFacDateImp(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("fac_modele_imp")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacModeleImp(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_garde")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacGarde(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_etat_val")) {
         this.factureEnteteVentes.setFacEtatVal(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("fac_gele")) {
         this.factureEnteteVentes.setFacGele(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("fac_etat")) {
         this.factureEnteteVentes.setFacEtat(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("fac_date_validite")) {
         this.factureEnteteVentes.setFacDateValidite(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("fac_date_relance")) {
         this.factureEnteteVentes.setFacDateRelance(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("fac_date_valide")) {
         this.factureEnteteVentes.setFacDateValide(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("fac_pos_signature")) {
         this.factureEnteteVentes.setFacPosSignature(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("fac_date_transforme")) {
         this.factureEnteteVentes.setFacDateTransforme(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("fac_type_transforme")) {
         this.factureEnteteVentes.setFacTypeTransforme(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("fac_date_annule")) {
         this.factureEnteteVentes.setFacDateAnnule(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("fac_motif_annule")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacMotifAnnule(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_date_transfert")) {
         this.factureEnteteVentes.setFacDateTransfert(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("fac_num_trf")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacNumTrf(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_factor_nom")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacFactorNom(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_factor_id")) {
         this.factureEnteteVentes.setFacFactorId(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("fac_factor_etat")) {
         this.factureEnteteVentes.setFacFactorEtat(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("fac_divers_tiers")) {
         this.factureEnteteVentes.setFacDiversTiers(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("fac_divers_nom")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacDiversNom(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_divers_adresse")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacDiversAdresse(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_divers_ville")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacDiversVille(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_divers_tel")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacDiversTel(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_divers_mail")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacDiversMail(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_source")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacSource(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_stock")) {
         this.factureEnteteVentes.setFacStock(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("fac_ristourne_bloquee")) {
         this.factureEnteteVentes.setFacRistourneBloquee(this.conversionBoolean(var2));
      } else if (var1.equalsIgnoreCase("fac_num_client")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureEnteteVentes.setFacNumClient(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("fac_date_client")) {
         this.factureEnteteVentes.setFacDateClient(this.conversionDate(var2));
      } else if (var1.equalsIgnoreCase("fac_poids")) {
         this.factureEnteteVentes.setFacPoids((float)this.conversionDouble(var2));
      } else {
         this.messageErreur = "La rubrique " + var1 + " n`existe pas...";
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertVentes.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertVentes);
      }

   }

   public void calculeRubFactureLigne(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.messageErreur = "";
      if (var1.equalsIgnoreCase("faclig_ordre")) {
         this.factureLigneVentes.setFacligOrdre(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("faclig_id_dvs")) {
         this.factureLigneVentes.setFacligIdDvs(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("faclig_code")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureLigneVentes.setFacligCode(this.enlevePoint(var2).toUpperCase());
            this.produits = this.produitsAchsDao.chargeToutProduit(this.factureLigneVentes.getFacligCode(), var3);
            if (this.produits != null) {
               this.factureLigneVentes.setFacligFamille(this.produits.getProVteCode());
               this.factureLigneVentes.setFacligLibelle(this.produits.getProLibClient());
               this.factureLigneVentes.setFacligLong(this.produits.getProLongueur());
               this.factureLigneVentes.setFacligLarg(this.produits.getProLargeur());
               this.factureLigneVentes.setFacligHaut(this.produits.getProEpaisseur());
               this.factureLigneVentes.setFacligDiam(this.produits.getProDiamExt());
               this.factureLigneVentes.setFacligVolume(this.produits.getProVolume());
               this.factureLigneVentes.setFacligPoidsNet(this.produits.getProPoidsNet());
               this.factureLigneVentes.setFacligPoidsBrut(this.produits.getProPoidsBrut());
               this.factureLigneVentes.setFacligNb(this.produits.getProNbUnite());
            }
         }
      } else if (var1.equalsIgnoreCase("faclig_famille")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureLigneVentes.setFacligFamille(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("faclig_libelle")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureLigneVentes.setFacligLibelle(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("faclig_complement")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureLigneVentes.setFacligComplement(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("faclig_reference")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureLigneVentes.setFacligReference(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("faclig_taxe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureLigneVentes.setFacligTaxe(this.enlevePoint(var2).toUpperCase());
            this.taxesVentes = this.taxesVentesDao.selectTva((long)this.nature, this.factureLigneVentes.getFacligTaxe(), var3);
            if (this.taxesVentes != null) {
               this.factureLigneVentes.setFacligTauxTaxe(this.taxesVentes.getTaxvteTaux());
            }
         }
      } else if (var1.equalsIgnoreCase("faclig_taux_taxe")) {
         this.factureLigneVentes.setFacligTauxTaxe((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_unite")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureLigneVentes.setFacligUnite(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("faclig_condition")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureLigneVentes.setFacligCondition(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("faclig_description")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureLigneVentes.setFacligDescription(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("faclig_echelle")) {
         this.factureLigneVentes.setFacligEchelle(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("faclig_qte")) {
         this.factureLigneVentes.setFacligQte((float)this.conversionDouble(var2));
         this.factureLigneVentes.setFacligQteUtil((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_long")) {
         this.factureLigneVentes.setFacligLong((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_larg")) {
         this.factureLigneVentes.setFacligLarg((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_haut")) {
         this.factureLigneVentes.setFacligHaut((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_diam")) {
         this.factureLigneVentes.setFacligDiam((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_nb")) {
         this.factureLigneVentes.setFacligNb((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_poidsNet")) {
         this.factureLigneVentes.setFacligPoidsNet((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_poidsBrut")) {
         this.factureLigneVentes.setFacligPoidsBrut((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_volume")) {
         this.factureLigneVentes.setFacligVolume((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_depot")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureLigneVentes.setFacligDepot(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("faclig_stock")) {
         this.factureLigneVentes.setFacligStock(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("faclig_qte_util")) {
         this.factureLigneVentes.setFacligQteUtil((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_qte_stock")) {
         this.factureLigneVentes.setFacligQteStock((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_devise")) {
         if (var2 != null && !var2.isEmpty()) {
            this.factureLigneVentes.setFacligDevise(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("faclig_pu")) {
         this.factureLigneVentes.setFacligPu((double)((float)this.conversionDouble(var2)));
      } else if (var1.equalsIgnoreCase("faclig_taux_remise")) {
         this.factureLigneVentes.setFacligTauxRemise((float)this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_rabais")) {
         this.factureLigneVentes.setFacligRabais(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_pu_rem")) {
         this.factureLigneVentes.setFacligPuRem(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_pu_ttc")) {
         this.factureLigneVentes.setFacligPuTtc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_pu_rem_ttc")) {
         this.factureLigneVentes.setFacligPuRemTtc((double)((float)this.conversionLong(var2)));
      } else if (var1.equalsIgnoreCase("faclig_pt")) {
         this.factureLigneVentes.setFacligPt(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_tva")) {
         this.factureLigneVentes.setFacligTva(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_tc")) {
         this.factureLigneVentes.setFacligTc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_ttc")) {
         this.factureLigneVentes.setFacligTtc(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_pump")) {
         this.factureLigneVentes.setFacligPump(this.conversionDouble(var2));
      } else if (var1.equalsIgnoreCase("faclig_mode_groupe")) {
         this.factureLigneVentes.setFacligModeGroupe(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("faclig_ent_stock")) {
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertVentes.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertVentes);
      }

   }

   public void verifFamilleAchat(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(0L, var3, var2);
         if (this.famillesProduitsAchats != null) {
            this.produits.setProAchCode(var3);
            this.produits.setProStock(this.famillesProduitsAchats.getFamachStock());
            this.produits.setProAchLib(this.famillesProduitsAchats.getFamachLibelleFr());
            this.produits.setProAchNat(this.famillesProduitsAchats.getFamachNature());
            this.produits.setProAchCpteCh(this.famillesProduitsAchats.getFamachCompteCharge());
            this.produits.setProAchCpteEc(this.famillesProduitsAchats.getFamachCompteEncours());
            this.produits.setProAchCpteHz(this.famillesProduitsAchats.getFamachCompteExterieur());
            this.produits.setProAchCpteLoc(this.famillesProduitsAchats.getFamachCompteLocal());
            this.produits.setProAchCpteSt(this.famillesProduitsAchats.getFamachCompteStock());
            this.produits.setProAchCpteZ(this.famillesProduitsAchats.getFamachCompteZone());
            this.produits.setProAchDouane(this.famillesProduitsAchats.getFamachDouane());
            this.produits.setProAchTva(this.famillesProduitsAchats.getFamachTaxe());
         } else {
            this.produits.setProStock(0);
            this.produits.setProAchCode("");
            this.produits.setProAchLib("");
            this.produits.setProAchNat("");
            this.produits.setProAchCpteCh("");
            this.produits.setProAchCpteEc("");
            this.produits.setProAchCpteHz("");
            this.produits.setProAchCpteLoc("");
            this.produits.setProAchCpteSt("");
            this.produits.setProAchCpteZ("");
            this.produits.setProAchDouane("");
            this.produits.setProAchTva("");
            this.messageErreur = "La famille achat " + var3 + " du produit " + this.produits.getProCode() + " n`existe pas....";
         }
      } else {
         this.produits.setProStock(0);
         this.produits.setProAchCode("");
         this.produits.setProAchLib("");
         this.produits.setProAchNat("");
         this.produits.setProAchCpteCh("");
         this.produits.setProAchCpteEc("");
         this.produits.setProAchCpteHz("");
         this.produits.setProAchCpteLoc("");
         this.produits.setProAchCpteSt("");
         this.produits.setProAchCpteZ("");
         this.produits.setProAchDouane("");
         this.produits.setProAchTva("");
      }

   }

   public void verifFamilleVente(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(0L, var3, var2);
         if (this.famillesProduitsVentes != null) {
            this.produits.setProVteCode(var3);
            this.produits.setProStock(this.famillesProduitsVentes.getFamvteStock());
            this.produits.setProVteLib(this.famillesProduitsVentes.getFamvteLibelleFr());
            this.produits.setProVteNat(this.famillesProduitsVentes.getFamvteNature());
            this.produits.setProVteCpteCa(this.famillesProduitsVentes.getFamvteCompteCaisse());
            this.produits.setProVteCpteHz(this.famillesProduitsVentes.getFamvteCompteExterieur());
            this.produits.setProVteCpteLoc(this.famillesProduitsVentes.getFamvteCompteLocal());
            this.produits.setProVteCpteNTx(this.famillesProduitsVentes.getFamvteCompteNonTaxable());
            this.produits.setProVteCptePr(this.famillesProduitsVentes.getFamvteCompteProduit());
            this.produits.setProVteCpteSt(this.famillesProduitsVentes.getFamvteCompteStock());
            this.produits.setProVteCpteZ(this.famillesProduitsVentes.getFamvteCompteZone());
            this.produits.setProVteDouane(this.famillesProduitsVentes.getFamvteDouane());
            this.produits.setProVteTva(this.famillesProduitsVentes.getFamvteTaxe());
         } else {
            this.produits.setProStock(0);
            this.produits.setProVteCode("");
            this.produits.setProVteLib("");
            this.produits.setProVteNat("");
            this.produits.setProVteCpteCa("");
            this.produits.setProVteCpteHz("");
            this.produits.setProVteCpteLoc("");
            this.produits.setProVteCpteNTx("");
            this.produits.setProVteCptePr("");
            this.produits.setProVteCpteSt("");
            this.produits.setProVteCpteZ("");
            this.produits.setProVteDouane("");
            this.produits.setProVteTva("");
            this.messageErreur = "La famille vente " + var3 + " du produit " + this.produits.getProCode() + " n`existe pas....";
         }
      } else {
         this.produits.setProStock(0);
         this.produits.setProVteCode("");
         this.produits.setProVteLib("");
         this.produits.setProVteNat("");
         this.produits.setProVteCpteCa("");
         this.produits.setProVteCpteHz("");
         this.produits.setProVteCpteLoc("");
         this.produits.setProVteCpteNTx("");
         this.produits.setProVteCptePr("");
         this.produits.setProVteCpteSt("");
         this.produits.setProVteCpteZ("");
         this.produits.setProVteDouane("");
         this.produits.setProVteTva("");
      }

   }

   public String verifDepot(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = "";
      String var4 = this.enlevePoint(var1);
      if (var4 != null && !var4.isEmpty()) {
         var4 = var4.toUpperCase();
         this.depotAchats = this.depotAchatsDao.trouveDepot(var4, var2);
         if (this.depotAchats != null) {
            var3 = var4;
         } else {
            var3 = "";
            this.messageErreur = "Le depot " + var4 + " du produit " + this.produits.getProCode() + " n`existe pas....";
         }
      } else {
         var3 = "";
      }

      return var3;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public OptionVentes getOptionsVentes() {
      return this.optionsVentes;
   }

   public void setOptionsVentes(OptionVentes var1) {
      this.optionsVentes = var1;
   }

   public DataModel getDatamodelDocument() {
      return this.datamodelDocument;
   }

   public void setDatamodelDocument(DataModel var1) {
      this.datamodelDocument = var1;
   }

   public Date getInpAu() {
      return this.inpAu;
   }

   public void setInpAu(Date var1) {
      this.inpAu = var1;
   }

   public boolean isInpDocNonTrf() {
      return this.inpDocNonTrf;
   }

   public void setInpDocNonTrf(boolean var1) {
      this.inpDocNonTrf = var1;
   }

   public Date getInpDu() {
      return this.inpDu;
   }

   public void setInpDu(Date var1) {
      this.inpDu = var1;
   }

   public String getInpPieceDeb() {
      return this.inpPieceDeb;
   }

   public void setInpPieceDeb(String var1) {
      this.inpPieceDeb = var1;
   }

   public String getInpPieceFin() {
      return this.inpPieceFin;
   }

   public void setInpPieceFin(String var1) {
      this.inpPieceFin = var1;
   }

   public List getListDocument() {
      return this.listDocument;
   }

   public void setListDocument(List var1) {
      this.listDocument = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
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

   public int getBalance() {
      return this.balance;
   }

   public void setBalance(int var1) {
      this.balance = var1;
   }

   public int getVar_choix_importation() {
      return this.var_choix_importation;
   }

   public void setVar_choix_importation(int var1) {
      this.var_choix_importation = var1;
   }

   public int getVar_currentValue() {
      return this.var_currentValue;
   }

   public void setVar_currentValue(int var1) {
      this.var_currentValue = var1;
   }

   public String getVar_info() {
      return this.var_info;
   }

   public void setVar_info(String var1) {
      this.var_info = var1;
   }

   public boolean isVar_showBarProgMaj() {
      return this.var_showBarProgMaj;
   }

   public void setVar_showBarProgMaj(boolean var1) {
      this.var_showBarProgMaj = var1;
   }

   public DataModel getDataModelChampProduit() {
      return this.dataModelChampProduit;
   }

   public void setDataModelChampProduit(DataModel var1) {
      this.dataModelChampProduit = var1;
   }

   public DataModel getDataModelChampBareme() {
      return this.dataModelChampBareme;
   }

   public void setDataModelChampBareme(DataModel var1) {
      this.dataModelChampBareme = var1;
   }

   public DataModel getDataModelChampProduitDepot() {
      return this.dataModelChampProduitDepot;
   }

   public void setDataModelChampProduitDepot(DataModel var1) {
      this.dataModelChampProduitDepot = var1;
   }

   public DataModel getDataModelChampProduitTarif() {
      return this.dataModelChampProduitTarif;
   }

   public void setDataModelChampProduitTarif(DataModel var1) {
      this.dataModelChampProduitTarif = var1;
   }
}
