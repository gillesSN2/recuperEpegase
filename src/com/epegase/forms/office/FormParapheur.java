package com.epegase.forms.office;

import com.epegase.forms.achats.FormAvoirAchats;
import com.epegase.forms.achats.FormBonDecaissementAchats;
import com.epegase.forms.achats.FormCommandeAchats;
import com.epegase.forms.achats.FormCotationAchats;
import com.epegase.forms.achats.FormDemandeAchats;
import com.epegase.forms.achats.FormFactureAchats;
import com.epegase.forms.achats.FormFraisAchats;
import com.epegase.forms.achats.FormNoteDebitAchats;
import com.epegase.forms.achats.FormReceptionAchats;
import com.epegase.forms.achats.FormRetourAchats;
import com.epegase.forms.caisse.FormBonSortieCaiss;
import com.epegase.forms.caisse.FormVirementInterne;
import com.epegase.forms.ventes.FormAvoirVentes;
import com.epegase.forms.ventes.FormBesoinVentes;
import com.epegase.forms.ventes.FormCommandeVentes;
import com.epegase.forms.ventes.FormContratVentes;
import com.epegase.forms.ventes.FormDevisVentes;
import com.epegase.forms.ventes.FormFactureInterneVentes;
import com.epegase.forms.ventes.FormFactureVentes;
import com.epegase.forms.ventes.FormLivraisonVentes;
import com.epegase.forms.ventes.FormNoteDebitVentes;
import com.epegase.forms.ventes.FormRetourVentes;
import com.epegase.forms.ventes.FormSimulContratVentes;
import com.epegase.systeme.classe.AvoirEnteteAchats;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.BesoinEnteteVentes;
import com.epegase.systeme.classe.BonDecaissementAchat;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.BonEntreCaiss;
import com.epegase.systeme.classe.BonEntreeEntete;
import com.epegase.systeme.classe.BonSortieCaiss;
import com.epegase.systeme.classe.BonSortieEntete;
import com.epegase.systeme.classe.CessionEntete;
import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.ContratEnteteVentes;
import com.epegase.systeme.classe.CotationEnteteAchats;
import com.epegase.systeme.classe.DemandeEnteteAchats;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.FabricationEnteteAchats;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureInterneEnteteVentes;
import com.epegase.systeme.classe.FraisEnteteAchats;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.InventaireEntete;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.NoteDebitEnteteAchats;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.RetourEnteteAchats;
import com.epegase.systeme.classe.RetourEnteteVentes;
import com.epegase.systeme.classe.SalariesConges;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.SalariesGrh;
import com.epegase.systeme.classe.SalariesPrets;
import com.epegase.systeme.classe.SalariesPretsLignes;
import com.epegase.systeme.classe.SimulationEnteteVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.ValorisationEnteteAchats;
import com.epegase.systeme.classe.VirementInterne;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.dao.AvoirEnteteAchatsDao;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.AvoirLigneAchatsDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BesoinEnteteVentesDao;
import com.epegase.systeme.dao.BesoinLigneVentesDao;
import com.epegase.systeme.dao.BonDecaissementAchatDao;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.BonEntreCaissDao;
import com.epegase.systeme.dao.BonEntreeEnteteDao;
import com.epegase.systeme.dao.BonEntreeLigneDao;
import com.epegase.systeme.dao.BonSortieCaissDao;
import com.epegase.systeme.dao.BonSortieEnteteDao;
import com.epegase.systeme.dao.BonSortieLigneDao;
import com.epegase.systeme.dao.CessionEnteteDao;
import com.epegase.systeme.dao.CessionLigneDao;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.CommandeLigneAchatsDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.ContratEnteteVentesDao;
import com.epegase.systeme.dao.ContratLigneVentesDao;
import com.epegase.systeme.dao.CotationEnteteAchatsDao;
import com.epegase.systeme.dao.CotationLigneAchatsDao;
import com.epegase.systeme.dao.DemandeEnteteAchatsDao;
import com.epegase.systeme.dao.DemandeLigneAchatsDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.FabricationEnteteAchatsDao;
import com.epegase.systeme.dao.FabricationLigneAchatsDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneLigneVentesDao;
import com.epegase.systeme.dao.FactureLigneAchatsDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FraisEnteteAchatsDao;
import com.epegase.systeme.dao.FraisLigneAchatsDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.InventaireEnteteDao;
import com.epegase.systeme.dao.InventaireLigneDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteAchatsDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneAchatsDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.RetourEnteteAchatsDao;
import com.epegase.systeme.dao.RetourEnteteVentesDao;
import com.epegase.systeme.dao.RetourLigneAchatsDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.SalariesCongesDao;
import com.epegase.systeme.dao.SalariesContratsDao;
import com.epegase.systeme.dao.SalariesGrhDao;
import com.epegase.systeme.dao.SalariesPretsDao;
import com.epegase.systeme.dao.SalariesPretsLignesDao;
import com.epegase.systeme.dao.SimulationEnteteVentesDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.ValorisationEnteteAchatsDao;
import com.epegase.systeme.dao.VirementInterneDao;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.LectureNaturePrets;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetDevises;
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
import org.xml.sax.SAXException;

public class FormParapheur implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private Users usersDestinataire;
   private UserDao usersDao;
   private List lesUsers;
   private CalculStock calculStock = new CalculStock();
   private String pageIndex;
   private Parapheur parapheur = new Parapheur();
   private ParapheurDao parapheurDao;
   private Habilitation habilitation = new Habilitation();
   private HabilitationDao habilitationDao;
   private List parapheurList;
   private transient DataModel datamodelParapheur;
   private UIDataTable extDTable;
   private SimpleSelection simpleSelectionEntete;
   private List mesUsersIndisponiblesItems;
   private boolean absent = false;
   private boolean present = false;
   private boolean verifieDateIndispo = false;
   private int etatRqt = 0;
   private int var_etat;
   private boolean showModalPanelIndisponibilite = false;
   private boolean showModalPanelVisualisation = false;
   private boolean showModalPanelNotation = false;
   private boolean showModalPanelReponse = false;
   private String noter;
   private String var_statut;
   private boolean var_affiche_bouton = false;
   private boolean verifValidite = false;
   private DocumentEntete documentEntete;
   private Stock stock;
   private transient DataModel datamodelStock;
   private List stockList;
   private int numeroEncCours;
   private UtilDate utilDate;
   private Date dateDebut;
   private Date dateFin;
   private boolean var_col01;
   private boolean var_col02;
   private boolean var_col03;
   private boolean var_col04;
   private boolean var_col05;
   private boolean var_col06;
   private boolean var_col07;
   private UtilNombre chiffreEnLettre = new UtilNombre();
   private String libelledevis;
   private LectureDevises lectureFluxDevises;
   private double solde = 0.0D;
   private String arreteSomme = "";
   private boolean htTtc = false;
   private String affichageTotttc = "";
   private List mesFamillesClients;
   private List mesExoTvaClients;
   private String affActivite = "";
   private String affBudget = "";
   private String affSite = "";
   private String affDepartement = "";
   private String affRegion = "";
   private String affSecteur = "";
   private String affPdv = "";
   private String affAnal2 = "";
   private String affAnal4 = "";
   private String affService = "";
   private String format = "PDF";
   private UtilPrint utilPrint;
   private UtilNombre utilNombre;
   private String requete;
   private String montant_lettre;
   private boolean showModalPanelPrint = false;

   public FormParapheur() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilNombre = new UtilNombre();
      this.parapheurList = new ArrayList();
      this.datamodelParapheur = new ListDataModel();
      this.simpleSelectionEntete = new SimpleSelection();
      this.extDTable = new HtmlExtendedDataTable();
      this.lesUsers = new ArrayList();
      this.mesUsersIndisponiblesItems = new ArrayList();
      this.mesFamillesClients = new ArrayList();
      this.mesExoTvaClients = new ArrayList();
      this.usersDestinataire = new Users();
      this.utilDate = new UtilDate();
   }

   public void InstancesDaoUtilses() {
      this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
      this.habilitationDao = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
   }

   public void initDate() throws ParseException {
      this.dateDebut = this.utilDate.datePremierJourMois(new Date());
      this.dateFin = this.utilDate.dateDernierJourMois(new Date());
   }

   public void lesParapheurs() throws HibernateException, NamingException {
      this.lesParapheurs((Session)null);
   }

   public void lesParapheurs(Session var1) throws HibernateException, NamingException {
      this.parapheurList.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      if (this.getEtatRqt() == 0) {
         this.parapheurList = this.parapheurDao.selectList(this.usersLog.getUsrid(), this.getEtatRqt(), var1);
      } else {
         this.parapheurList = this.parapheurDao.selectList(this.usersLog.getUsrid(), this.getEtatRqt(), this.dateDebut, this.dateFin, var1);
      }

      this.datamodelParapheur.setWrappedData(this.parapheurList);
      this.var_affiche_bouton = false;
   }

   public void selectionParapheur() {
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
            this.parapheur = (Parapheur)var1.get(0);
            this.numeroEncCours = this.parapheur.getPhrPosition();
            this.var_affiche_bouton = true;
         } else {
            this.var_affiche_bouton = false;
         }
      } else {
         this.var_affiche_bouton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.parapheur != null) {
         this.panalVisualisation();
      }

   }

   public void panalVisualisation() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.parapheur != null) {
         this.docVisualiser();
      }

   }

   public void annuleVisualisation() {
      this.showModalPanelVisualisation = false;
   }

   public void modifierParapheurValider() throws IOException {
      if (this.parapheur != null) {
         this.var_etat = 1;
         this.verificationStatut();
         this.var_statut = "VALIDATION";
         this.showModalPanelNotation = true;
      }

   }

   public void modifierParapheurGeler() {
      if (this.parapheur != null) {
         this.var_etat = 2;
         this.verificationStatut();
         this.var_statut = "MISE EN ATTENTE (GELER)";
         this.showModalPanelNotation = true;
      }

   }

   public void modifierParapheurCorrection() {
      if (this.parapheur != null) {
         this.var_etat = 3;
         this.verificationStatut();
         this.var_statut = "REJET (CORRECTION)";
         this.showModalPanelNotation = true;
      }

   }

   public void modifierParapheurRejeter() {
      if (this.parapheur != null) {
         this.var_etat = 5;
         this.verificationStatut();
         this.var_statut = "REJET (ANNULER)";
         this.showModalPanelNotation = true;
      }

   }

   public void verificationStatut() {
      if (this.numeroEncCours == 1 && this.parapheur.getPhrUser1Id() != 0L) {
         this.parapheur.setPhrUser1Etat(this.var_etat);
         this.noter = this.parapheur.getPhrUser1Explication();
         this.var_col01 = this.parapheur.isPhrUser1Col01();
         this.var_col02 = this.parapheur.isPhrUser1Col02();
         this.var_col03 = this.parapheur.isPhrUser1Col03();
         this.var_col04 = this.parapheur.isPhrUser1Col04();
         this.var_col05 = this.parapheur.isPhrUser1Col05();
         this.var_col06 = this.parapheur.isPhrUser1Col06();
         this.var_col07 = this.parapheur.isPhrUser1Col07();
      } else if (this.numeroEncCours == 2 && this.parapheur.getPhrUser2Id() != 0L) {
         this.parapheur.setPhrUser2Etat(this.var_etat);
         this.noter = this.parapheur.getPhrUser2Explication();
         this.var_col01 = this.parapheur.isPhrUser2Col01();
         this.var_col02 = this.parapheur.isPhrUser2Col02();
         this.var_col03 = this.parapheur.isPhrUser2Col03();
         this.var_col04 = this.parapheur.isPhrUser2Col04();
         this.var_col05 = this.parapheur.isPhrUser2Col05();
         this.var_col06 = this.parapheur.isPhrUser2Col06();
         this.var_col07 = this.parapheur.isPhrUser2Col07();
      } else if (this.numeroEncCours == 3 && this.parapheur.getPhrUser3Id() != 0L) {
         this.parapheur.setPhrUser3Etat(this.var_etat);
         this.noter = this.parapheur.getPhrUser3Explication();
         this.var_col01 = this.parapheur.isPhrUser3Col01();
         this.var_col02 = this.parapheur.isPhrUser3Col02();
         this.var_col03 = this.parapheur.isPhrUser3Col03();
         this.var_col04 = this.parapheur.isPhrUser3Col04();
         this.var_col05 = this.parapheur.isPhrUser3Col05();
         this.var_col06 = this.parapheur.isPhrUser3Col06();
         this.var_col07 = this.parapheur.isPhrUser3Col07();
      } else if (this.numeroEncCours == 4 && this.parapheur.getPhrUser4Id() != 0L) {
         this.parapheur.setPhrUser4Etat(this.var_etat);
         this.noter = this.parapheur.getPhrUser4Explication();
         this.var_col01 = this.parapheur.isPhrUser4Col01();
         this.var_col02 = this.parapheur.isPhrUser4Col02();
         this.var_col03 = this.parapheur.isPhrUser4Col03();
         this.var_col04 = this.parapheur.isPhrUser4Col04();
         this.var_col05 = this.parapheur.isPhrUser4Col05();
         this.var_col06 = this.parapheur.isPhrUser4Col06();
         this.var_col07 = this.parapheur.isPhrUser4Col07();
      } else if (this.numeroEncCours == 5 && this.parapheur.getPhrUser5Id() != 0L) {
         this.parapheur.setPhrUser5Etat(this.var_etat);
         this.noter = this.parapheur.getPhrUser5Explication();
         this.var_col01 = this.parapheur.isPhrUser5Col01();
         this.var_col02 = this.parapheur.isPhrUser5Col02();
         this.var_col03 = this.parapheur.isPhrUser5Col03();
         this.var_col04 = this.parapheur.isPhrUser5Col04();
         this.var_col05 = this.parapheur.isPhrUser5Col05();
         this.var_col06 = this.parapheur.isPhrUser5Col06();
         this.var_col07 = this.parapheur.isPhrUser5Col07();
      } else if (this.numeroEncCours == 6 && this.parapheur.getPhrUser6Id() != 0L) {
         this.parapheur.setPhrUser6Etat(this.var_etat);
         this.noter = this.parapheur.getPhrUser6Explication();
         this.var_col01 = this.parapheur.isPhrUser6Col01();
         this.var_col02 = this.parapheur.isPhrUser6Col02();
         this.var_col03 = this.parapheur.isPhrUser6Col03();
         this.var_col04 = this.parapheur.isPhrUser6Col04();
         this.var_col05 = this.parapheur.isPhrUser6Col05();
         this.var_col06 = this.parapheur.isPhrUser6Col06();
         this.var_col07 = this.parapheur.isPhrUser6Col07();
      }

   }

   public void annulerParapheur() {
      this.showModalPanelNotation = false;
   }

   public void voirReponses() {
      if (this.parapheur != null) {
         this.showModalPanelReponse = true;
      }

   }

   public void annulerReponses() {
      this.showModalPanelReponse = false;
   }

   public void saveParapheur() throws HibernateException, NamingException, Exception {
      if (this.parapheur != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parapheur");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.parapheur.getPhrNombre() == 0) {
               this.parapheur.setPhrNombre(1);
            }

            if (this.numeroEncCours == 1 && this.parapheur.getPhrUser1Id() != 0L) {
               this.parapheur.setPhrUser1Explication(this.noter);
               this.parapheur.setPhrUser1DteRep(new Date());
               this.parapheur.setPhrUser1Etat(this.var_etat);
               this.parapheur.setPhrUser1Col01(this.var_col01);
               this.parapheur.setPhrUser1Col02(this.var_col02);
               this.parapheur.setPhrUser1Col03(this.var_col03);
               this.parapheur.setPhrUser1Col04(this.var_col04);
               this.parapheur.setPhrUser1Col05(this.var_col05);
               this.parapheur.setPhrUser1Col06(this.var_col06);
               this.parapheur.setPhrUser1Col07(this.var_col07);
            } else if (this.numeroEncCours == 2 && this.parapheur.getPhrUser2Id() != 0L) {
               this.parapheur.setPhrUser2Explication(this.noter);
               this.parapheur.setPhrUser2DteRep(new Date());
               this.parapheur.setPhrUser2Etat(this.var_etat);
               this.parapheur.setPhrUser2Col01(this.var_col01);
               this.parapheur.setPhrUser2Col02(this.var_col02);
               this.parapheur.setPhrUser2Col03(this.var_col03);
               this.parapheur.setPhrUser2Col04(this.var_col04);
               this.parapheur.setPhrUser2Col05(this.var_col05);
               this.parapheur.setPhrUser2Col06(this.var_col06);
               this.parapheur.setPhrUser2Col07(this.var_col07);
            } else if (this.numeroEncCours == 3 && this.parapheur.getPhrUser3Id() != 0L) {
               this.parapheur.setPhrUser3Explication(this.noter);
               this.parapheur.setPhrUser3DteRep(new Date());
               this.parapheur.setPhrUser3Etat(this.var_etat);
               this.parapheur.setPhrUser3Col01(this.var_col01);
               this.parapheur.setPhrUser3Col02(this.var_col02);
               this.parapheur.setPhrUser3Col03(this.var_col03);
               this.parapheur.setPhrUser3Col04(this.var_col04);
               this.parapheur.setPhrUser3Col05(this.var_col05);
               this.parapheur.setPhrUser3Col06(this.var_col06);
               this.parapheur.setPhrUser3Col07(this.var_col07);
            } else if (this.numeroEncCours == 4 && this.parapheur.getPhrUser4Id() != 0L) {
               this.parapheur.setPhrUser4Explication(this.noter);
               this.parapheur.setPhrUser4DteRep(new Date());
               this.parapheur.setPhrUser4Etat(this.var_etat);
               this.parapheur.setPhrUser4Col01(this.var_col01);
               this.parapheur.setPhrUser4Col02(this.var_col02);
               this.parapheur.setPhrUser4Col03(this.var_col03);
               this.parapheur.setPhrUser4Col04(this.var_col04);
               this.parapheur.setPhrUser4Col05(this.var_col05);
               this.parapheur.setPhrUser4Col06(this.var_col06);
               this.parapheur.setPhrUser4Col07(this.var_col07);
            } else if (this.numeroEncCours == 5 && this.parapheur.getPhrUser5Id() != 0L) {
               this.parapheur.setPhrUser5Explication(this.noter);
               this.parapheur.setPhrUser5DteRep(new Date());
               this.parapheur.setPhrUser5Etat(this.var_etat);
               this.parapheur.setPhrUser5Col01(this.var_col01);
               this.parapheur.setPhrUser5Col02(this.var_col02);
               this.parapheur.setPhrUser5Col03(this.var_col03);
               this.parapheur.setPhrUser5Col04(this.var_col04);
               this.parapheur.setPhrUser5Col05(this.var_col05);
               this.parapheur.setPhrUser5Col06(this.var_col06);
               this.parapheur.setPhrUser5Col07(this.var_col07);
            } else if (this.numeroEncCours == 6 && this.parapheur.getPhrUser6Id() != 0L) {
               this.parapheur.setPhrUser6Explication(this.noter);
               this.parapheur.setPhrUser6DteRep(new Date());
               this.parapheur.setPhrUser6Etat(this.var_etat);
               this.parapheur.setPhrUser6Col01(this.var_col01);
               this.parapheur.setPhrUser6Col02(this.var_col02);
               this.parapheur.setPhrUser6Col03(this.var_col03);
               this.parapheur.setPhrUser6Col04(this.var_col04);
               this.parapheur.setPhrUser6Col05(this.var_col05);
               this.parapheur.setPhrUser6Col06(this.var_col06);
               this.parapheur.setPhrUser6Col07(this.var_col07);
            }

            this.parapheur = this.parapheurDao.modif(this.parapheur, var1);
            var2.commit();
         } catch (HibernateException var8) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var8;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         String var3 = this.majDocOriginal();
         if (this.numeroEncCours == 1 && this.parapheur.getPhrUser1Etat() == 1 || this.numeroEncCours == 2 && this.parapheur.getPhrUser2Etat() == 1 || this.numeroEncCours == 3 && this.parapheur.getPhrUser3Etat() == 1 || this.numeroEncCours == 4 && this.parapheur.getPhrUser4Etat() == 1 || this.numeroEncCours == 5 && this.parapheur.getPhrUser5Etat() == 1 || this.numeroEncCours == 6 && this.parapheur.getPhrUser6Etat() == 1) {
            this.signataireSuivant();
         } else if ((this.numeroEncCours != 1 || this.parapheur.getPhrUser1Etat() != 2) && (this.numeroEncCours != 2 || this.parapheur.getPhrUser2Etat() != 2) && (this.numeroEncCours != 3 || this.parapheur.getPhrUser3Etat() != 2) && (this.numeroEncCours != 4 || this.parapheur.getPhrUser4Etat() != 2) && (this.numeroEncCours != 5 || this.parapheur.getPhrUser5Etat() != 2) && (this.numeroEncCours != 6 || this.parapheur.getPhrUser6Etat() != 2) && (this.numeroEncCours != 1 || this.parapheur.getPhrUser1Etat() != 3) && (this.numeroEncCours != 2 || this.parapheur.getPhrUser2Etat() != 3) && (this.numeroEncCours != 3 || this.parapheur.getPhrUser3Etat() != 3) && (this.numeroEncCours != 4 || this.parapheur.getPhrUser4Etat() != 3) && (this.numeroEncCours != 5 || this.parapheur.getPhrUser5Etat() != 3) && (this.numeroEncCours != 6 || this.parapheur.getPhrUser6Etat() != 3) && (this.numeroEncCours != 1 || this.parapheur.getPhrUser1Etat() != 4) && (this.numeroEncCours != 2 || this.parapheur.getPhrUser2Etat() != 4) && (this.numeroEncCours != 3 || this.parapheur.getPhrUser3Etat() != 4) && (this.numeroEncCours != 4 || this.parapheur.getPhrUser4Etat() != 4) && (this.numeroEncCours != 5 || this.parapheur.getPhrUser5Etat() != 4) && this.numeroEncCours == 6 && this.parapheur.getPhrUser6Etat() == 4) {
         }

         if (this.var_etat == 3 && StaticModePegase.getInternet_actif() != 0 && var3 != null && !var3.isEmpty()) {
            this.utilPrint = new UtilPrint(this.utilInitHibernate);
            ArrayList var4 = new ArrayList();
            var4.add(this.parapheur);
            JRBeanCollectionDataSource var5 = new JRBeanCollectionDataSource(var4);
            this.utilPrint.setjRBeanCollectionDataSource(var5);
            this.utilPrint.setRapport("correctif_document");
            this.utilPrint.setEntete("Correctif document");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "parapheur" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setImageFondPage("");
            this.utilPrint.setFormat("MAIL");
            this.utilPrint.setEmetteur("infos@e-pegase.biz");
            this.utilPrint.setDestinataire(var3);
            this.utilPrint.setDestinataireCC("");
            this.utilPrint.setDestinataireCCI("");
            this.utilPrint.setIdResponsable(0L);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setNature(4);
            this.utilPrint.setId_doc(this.parapheur.getPhrId());
            this.utilPrint.setParc((Parc)null);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      }

      this.lesParapheurs((Session)null);
      this.showModalPanelNotation = false;
   }

   public void signataireSuivant() throws HibernateException, NamingException, Exception {
      if (this.parapheur.getPhrPosition() < this.parapheur.getPhrNombre()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parapheur");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            int var3 = this.numeroEncCours + 1;
            this.parapheur.setPhrPosition(var3);
            this.habilitation = this.habilitationDao.existenceHabilitation(this.parapheur.getPhrNature(), var1);
            if (this.habilitation != null) {
               if (this.parapheur.getPhrPosition() == 2 && this.habilitation.getHabUser2Id() != 0L) {
                  this.parapheur.setPhrUser2Cat(this.habilitation.getHabUser2Cat());
                  this.usersDestinataire = this.usersDao.selectByIdUsers(this.habilitation.getHabUser2Id(), var1);
                  if (this.usersDestinataire != null) {
                     if (this.habilitation.getHabRemplace2Id() != 0L && this.usersDestinataire.getUsrDateDebutIndisponibilite() != null && this.usersDestinataire.getUsrDateFinIndisponibilite() != null && this.parapheur.getPhrDate().compareTo(this.usersDestinataire.getUsrDateDebutIndisponibilite()) >= 0 && this.parapheur.getPhrDate().compareTo(this.usersDestinataire.getUsrDateFinIndisponibilite()) <= 0) {
                        this.parapheur.setPhrUser2Id(this.habilitation.getHabRemplace2Id());
                        this.parapheur.setPhrUser2Nom(this.habilitation.getHabRemplace2Nom());
                     } else {
                        this.parapheur.setPhrUser2Id(this.habilitation.getHabUser2Id());
                        this.parapheur.setPhrUser2Nom(this.habilitation.getHabUser2Nom());
                     }
                  }
               }

               if (this.parapheur.getPhrPosition() == 3 && this.habilitation.getHabUser3Id() != 0L) {
                  this.parapheur.setPhrUser3Cat(this.habilitation.getHabUser3Cat());
                  this.usersDestinataire = this.usersDao.selectByIdUsers(this.habilitation.getHabUser3Id(), var1);
                  if (this.usersDestinataire != null) {
                     if (this.habilitation.getHabRemplace3Id() != 0L && this.usersDestinataire.getUsrDateDebutIndisponibilite() != null && this.usersDestinataire.getUsrDateFinIndisponibilite() != null && this.parapheur.getPhrDate().compareTo(this.usersDestinataire.getUsrDateDebutIndisponibilite()) >= 0 && this.parapheur.getPhrDate().compareTo(this.usersDestinataire.getUsrDateFinIndisponibilite()) <= 0) {
                        this.parapheur.setPhrUser3Id(this.habilitation.getHabRemplace3Id());
                        this.parapheur.setPhrUser3Nom(this.habilitation.getHabRemplace3Nom());
                     } else {
                        this.parapheur.setPhrUser3Id(this.habilitation.getHabUser3Id());
                        this.parapheur.setPhrUser3Nom(this.habilitation.getHabUser3Nom());
                     }
                  }
               }

               if (this.parapheur.getPhrPosition() == 4 && this.habilitation.getHabUser4Id() != 0L) {
                  this.usersDestinataire = this.usersDao.selectByIdUsers(this.habilitation.getHabUser4Id(), var1);
                  if (this.usersDestinataire != null) {
                     if (this.habilitation.getHabRemplace4Id() != 0L && this.usersDestinataire.getUsrDateDebutIndisponibilite() != null && this.usersDestinataire.getUsrDateFinIndisponibilite() != null && this.parapheur.getPhrDate().compareTo(this.usersDestinataire.getUsrDateDebutIndisponibilite()) >= 0 && this.parapheur.getPhrDate().compareTo(this.usersDestinataire.getUsrDateFinIndisponibilite()) <= 0) {
                        this.parapheur.setPhrUser4Id(this.habilitation.getHabRemplace4Id());
                        this.parapheur.setPhrUser4Nom(this.habilitation.getHabRemplace4Nom());
                     } else {
                        this.parapheur.setPhrUser4Id(this.habilitation.getHabUser4Id());
                        this.parapheur.setPhrUser4Nom(this.habilitation.getHabUser4Nom());
                     }
                  }
               }

               if (this.parapheur.getPhrPosition() == 5 && this.habilitation.getHabUser5Id() != 0L) {
                  this.usersDestinataire = this.usersDao.selectByIdUsers(this.habilitation.getHabUser5Id(), var1);
                  if (this.usersDestinataire != null) {
                     if (this.habilitation.getHabRemplace5Id() != 0L && this.usersDestinataire.getUsrDateDebutIndisponibilite() != null && this.usersDestinataire.getUsrDateFinIndisponibilite() != null && this.parapheur.getPhrDate().compareTo(this.usersDestinataire.getUsrDateDebutIndisponibilite()) >= 0 && this.parapheur.getPhrDate().compareTo(this.usersDestinataire.getUsrDateFinIndisponibilite()) <= 0) {
                        this.parapheur.setPhrUser5Id(this.habilitation.getHabRemplace5Id());
                        this.parapheur.setPhrUser5Nom(this.habilitation.getHabRemplace5Nom());
                     } else {
                        this.parapheur.setPhrUser5Id(this.habilitation.getHabUser5Id());
                        this.parapheur.setPhrUser5Nom(this.habilitation.getHabUser5Nom());
                     }
                  }
               }

               if (this.parapheur.getPhrPosition() == 6 && this.habilitation.getHabUser6Id() != 0L) {
                  this.usersDestinataire = this.usersDao.selectByIdUsers(this.habilitation.getHabUser6Id(), var1);
                  if (this.usersDestinataire != null) {
                     if (this.habilitation.getHabRemplace6Id() != 0L && this.usersDestinataire.getUsrDateDebutIndisponibilite() != null && this.usersDestinataire.getUsrDateFinIndisponibilite() != null && this.parapheur.getPhrDate().compareTo(this.usersDestinataire.getUsrDateDebutIndisponibilite()) >= 0 && this.parapheur.getPhrDate().compareTo(this.usersDestinataire.getUsrDateFinIndisponibilite()) <= 0) {
                        this.parapheur.setPhrUser6Id(this.habilitation.getHabRemplace6Id());
                        this.parapheur.setPhrUser6Nom(this.habilitation.getHabRemplace6Nom());
                     } else {
                        this.parapheur.setPhrUser6Id(this.habilitation.getHabUser6Id());
                        this.parapheur.setPhrUser6Nom(this.habilitation.getHabUser6Nom());
                     }
                  }
               }

               if (this.parapheur.getPhrId() == 0L) {
                  this.parapheur = this.parapheurDao.insert(this.parapheur, var1);
               } else {
                  this.parapheur = this.parapheurDao.modif(this.parapheur, var1);
               }
            }

            this.parapheur = this.parapheurDao.modif(this.parapheur, var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (this.habilitation.getHabMailBloque() == 0 && StaticModePegase.getInternet_actif() != 0) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parapheur");
            UtilParapheur var9 = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
            var9.recupererEmetteur(var1);
            Tiers var4 = new Tiers();
            var9.generationMail(this.parapheur.getPhrNature(), this.parapheur.getPhrDocId(), this.parapheur.getPhrNum(), this.habilitation.getHabUser1Id(), this.parapheur.getPhrModeleImp(), (File)null, (Tiers)var4, var1);
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public int calculEtatFinal() {
      boolean var1 = false;
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      if (this.parapheur.getPhrUser1Cat() == 2) {
         if (this.parapheur.getPhrUser1Etat() == 0) {
            ++var3;
         } else if (this.parapheur.getPhrUser1Etat() == 1) {
            ++var4;
         } else if (this.parapheur.getPhrUser1Etat() == 2) {
            ++var6;
         } else if (this.parapheur.getPhrUser1Etat() == 6) {
            ++var5;
         } else if (this.parapheur.getPhrUser1Etat() == 7) {
            ++var7;
         }
      } else {
         ++var2;
      }

      if (this.parapheur.getPhrUser2Cat() == 2) {
         if (this.parapheur.getPhrUser2Etat() == 0) {
            ++var3;
         } else if (this.parapheur.getPhrUser2Etat() == 1) {
            ++var4;
         } else if (this.parapheur.getPhrUser2Etat() == 2) {
            ++var6;
         } else if (this.parapheur.getPhrUser2Etat() == 6) {
            ++var5;
         } else if (this.parapheur.getPhrUser2Etat() == 7) {
            ++var7;
         }
      } else {
         ++var2;
      }

      if (this.parapheur.getPhrUser3Cat() == 2) {
         if (this.parapheur.getPhrUser3Etat() == 0) {
            ++var3;
         } else if (this.parapheur.getPhrUser3Etat() == 1) {
            ++var4;
         } else if (this.parapheur.getPhrUser3Etat() == 2) {
            ++var6;
         } else if (this.parapheur.getPhrUser3Etat() == 6) {
            ++var5;
         } else if (this.parapheur.getPhrUser3Etat() == 7) {
            ++var7;
         }
      } else {
         ++var2;
      }

      if (this.parapheur.getPhrUser4Cat() == 2) {
         if (this.parapheur.getPhrUser4Etat() == 0) {
            ++var3;
         } else if (this.parapheur.getPhrUser4Etat() == 1) {
            ++var4;
         } else if (this.parapheur.getPhrUser4Etat() == 2) {
            ++var6;
         } else if (this.parapheur.getPhrUser4Etat() == 6) {
            ++var5;
         } else if (this.parapheur.getPhrUser4Etat() == 7) {
            ++var7;
         }
      } else {
         ++var2;
      }

      if (this.parapheur.getPhrUser5Cat() == 2) {
         if (this.parapheur.getPhrUser5Etat() == 0) {
            ++var3;
         } else if (this.parapheur.getPhrUser5Etat() == 1) {
            ++var4;
         } else if (this.parapheur.getPhrUser5Etat() == 2) {
            ++var6;
         } else if (this.parapheur.getPhrUser5Etat() == 6) {
            ++var5;
         } else if (this.parapheur.getPhrUser5Etat() == 7) {
            ++var7;
         }
      } else {
         ++var2;
      }

      if (this.parapheur.getPhrUser6Cat() == 2) {
         if (this.parapheur.getPhrUser6Etat() == 0) {
            ++var3;
         } else if (this.parapheur.getPhrUser6Etat() == 1) {
            ++var4;
         } else if (this.parapheur.getPhrUser6Etat() == 2) {
            ++var6;
         } else if (this.parapheur.getPhrUser6Etat() == 6) {
            ++var5;
         } else if (this.parapheur.getPhrUser6Etat() == 7) {
            ++var7;
         }
      } else {
         ++var2;
      }

      byte var8;
      if (var7 != 0) {
         var8 = 7;
      } else if (var5 != 0) {
         var8 = 6;
      } else if (var6 != 0) {
         var8 = 2;
      } else if (var4 != 0) {
         if (var4 != this.parapheur.getPhrNombre() && this.parapheur.getPhrNombre() != 0) {
            var8 = 0;
         } else {
            var8 = 1;
         }
      } else {
         var8 = 0;
      }

      return var8;
   }

   public String majDocOriginal() throws HibernateException, NamingException, JDOMException, IOException {
      String var1 = "";
      int var2 = this.parapheur.getPhrNature();
      if (var2 == 10) {
         var1 = this.majAchatsDa();
      } else if (var2 == 11) {
         var1 = this.majAchatsCotation();
      } else if (var2 == 12) {
         var1 = this.majAchatsCommande();
      } else if (var2 == 13) {
         var1 = this.majAchatsReception();
      } else if (var2 == 14) {
         var1 = this.majAchatsRetour();
      } else if (var2 == 15) {
         var1 = this.majAchatsFacture();
      } else if (var2 == 16) {
         var1 = this.majAchatsAvoir();
      } else if (var2 == 17) {
         var1 = this.majAchatsNoteDebit();
      } else if (var2 == 18) {
         var1 = this.majAchatsFrais();
      } else if (var2 == 19) {
         var1 = this.majBonDecaissement();
      } else if (var2 == 8) {
         var1 = this.majVentesSimulation();
      } else if (var2 == 20) {
         var1 = this.majVentesBesoin();
      } else if (var2 == 21) {
         var1 = this.majVentesDevis();
      } else if (var2 == 22) {
         var1 = this.majVentesCommande();
      } else if (var2 == 23) {
         var1 = this.majVentesLivraison();
      } else if (var2 == 24) {
         var1 = this.majVentesRetour();
      } else if (var2 == 25) {
         var1 = this.majVentesFacture();
      } else if (var2 == 26) {
         var1 = this.majVentesAvoir();
      } else if (var2 == 27) {
         var1 = this.majVentesNoteDebit();
      } else if (var2 == 29) {
         var1 = this.majBonEncaissement();
      } else if (var2 == 30) {
         var1 = this.majStockInventaire();
      } else if (var2 == 31) {
         var1 = this.majStockEntree();
      } else if (var2 == 32) {
         var1 = this.majStockSortie();
      } else if (var2 == 33) {
         var1 = this.majStockCession();
      } else if (var2 == 34) {
         var1 = this.majStockProduction();
      } else if (var2 == 62) {
         var1 = this.majCaisseBonSortie();
      } else if (var2 == 63) {
         var1 = this.majCaisseBonEntree();
      } else if (var2 == 64) {
         var1 = this.majCaisseBonVirement();
      } else if (var2 == 82) {
         this.majPayeContrat();
      } else if (var2 == 83) {
         this.majPayeAttestation();
      } else if (var2 == 84) {
         this.majPayeCursus();
      } else if (var2 == 85) {
         this.majPayeCertificat();
      } else if (var2 == 86) {
         this.majPayeCorrespondance();
      } else if (var2 == 87) {
         this.majPayePret();
      } else if (var2 == 88) {
         this.majPayeConges();
      } else if (var2 == 89) {
         this.majPayeAbsence();
      }

      return var1;
   }

   public String majAchatsDa() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new DemandeEnteteAchats();
         DemandeEnteteAchatsDao var5 = new DemandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         DemandeEnteteAchats var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getDemIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getDemIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setDemPosSignature(this.parapheur.getPhrPosition());
            if (var4.getDemPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setDemEtat(this.calculEtatFinal());
               var4.setDemDateValide(new Date());
            } else {
               var4.setDemEtat(this.calculEtatFinal());
               var4.setDemDateValide((Date)null);
            }

            var5.modif(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majAchatsCotation() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CotationsEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new CotationEnteteAchats();
         CotationEnteteAchatsDao var5 = new CotationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         CotationEnteteAchats var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getCotIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getCotIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setCotPosSignature(this.parapheur.getPhrPosition());
            if (var4.getCotPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setCotEtat(this.calculEtatFinal());
               var4.setCotDateValide(new Date());
            } else {
               var4.setCotEtat(this.calculEtatFinal());
               var4.setCotDateValide((Date)null);
            }

            var5.modif(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majAchatsCommande() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CommandeEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new CommandeEnteteAchats();
         CommandeEnteteAchatsDao var5 = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         CommandeEnteteAchats var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getCmdIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getCmdIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setCmdPosSignature(this.parapheur.getPhrPosition());
            if (var4.getCmdPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setCmdEtat(this.calculEtatFinal());
               var4.setCmdDateValide(new Date());
            } else {
               var4.setCmdEtat(this.calculEtatFinal());
               var4.setCmdDateValide((Date)null);
            }

            var5.modif(var4, var2);
            if (var4.getCmdAnal4() != null && !var4.getCmdAnal4().isEmpty()) {
               new ValorisationEnteteAchats();
               ValorisationEnteteAchatsDao var7 = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               ValorisationEnteteAchats var13 = var7.rechercheByDossier(var4.getCmdAnal4(), var2);
               if (var13 != null) {
                  var4.setCmdValo(var13.getValNum());
                  var5.modif(var4, var2);
               }
            }

            var3.commit();
         }
      } catch (HibernateException var11) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majAchatsReception() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new ReceptionEnteteAchats();
         ReceptionEnteteAchatsDao var5 = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         ReceptionEnteteAchats var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getRecIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getRecIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setRecPosSignature(this.parapheur.getPhrPosition());
            if (var4.getRecPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setRecEtat(this.calculEtatFinal());
               var4.setRecDateValide(new Date());
            } else {
               var4.setRecEtat(this.calculEtatFinal());
               var4.setRecDateValide((Date)null);
            }

            var5.modif(var4, var2);
            if (var4.getRecAnal4() != null && !var4.getRecAnal4().isEmpty()) {
               new ValorisationEnteteAchats();
               ValorisationEnteteAchatsDao var7 = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               ValorisationEnteteAchats var13 = var7.rechercheByDossier(var4.getRecAnal4(), var2);
               if (var13 != null) {
                  var4.setRecValo(var13.getValNum());
                  var4 = var5.modif(var4, var2);
               }
            }

            if (var4.getRecEtat() == 1) {
               new ArrayList();
               ReceptionLigneAchatsDao var15 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               List var14 = var15.chargerLesLignes(var4, var2);
               if (var14.size() != 0) {
                  this.calculStock.majReceptionAchatsVAL(var14, 1, this.baseLog, var2);
               }
            }

            var3.commit();
         }
      } catch (HibernateException var11) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majAchatsRetour() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "RetourLigne");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new RetourEnteteAchats();
         RetourEnteteAchatsDao var5 = new RetourEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         RetourEnteteAchats var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getBrfIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getBrfIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setBrfPosSignature(this.parapheur.getPhrPosition());
            if (var4.getBrfPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setBrfEtat(this.calculEtatFinal());
               var4.setBrfDateValide(new Date());
            } else {
               var4.setBrfEtat(this.calculEtatFinal());
               var4.setBrfDateValide((Date)null);
            }

            var5.modif(var4, var2);
            if (var4.getBrfAnal4() != null && !var4.getBrfAnal4().isEmpty()) {
               new ValorisationEnteteAchats();
               ValorisationEnteteAchatsDao var7 = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               ValorisationEnteteAchats var13 = var7.rechercheByDossier(var4.getBrfAnal4(), var2);
               if (var13 != null) {
                  var4.setBrfValo(var13.getValNum());
                  var4 = var5.modif(var4, var2);
               }
            }

            if (var4.getBrfEtat() == 1) {
               new ArrayList();
               RetourLigneAchatsDao var15 = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               List var14 = var15.chargerLesLignes(var4, var2);
               if (var14.size() != 0) {
                  this.calculStock.majRetourAchatsVAL(var14, 1, this.baseLog, var2);
               }
            }

            var3.commit();
         }
      } catch (HibernateException var11) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majAchatsFacture() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new FactureEnteteAchats();
         FactureEnteteAchatsDao var5 = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         FactureEnteteAchats var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getFcfIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getFcfIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setFcfPosSignature(this.parapheur.getPhrPosition());
            if (var4.getFcfPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setFcfEtat(this.calculEtatFinal());
               var4.setFcfDateValide(new Date());
            } else {
               var4.setFcfEtat(this.calculEtatFinal());
               var4.setFcfDateValide((Date)null);
            }

            var5.modif(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majAchatsAvoir() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new AvoirEnteteAchats();
         AvoirEnteteAchatsDao var5 = new AvoirEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         AvoirEnteteAchats var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getAvfIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getAvfIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setAvfPosSignature(this.parapheur.getPhrPosition());
            if (var4.getAvfPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setAvfEtat(this.calculEtatFinal());
               var4.setAvfDateValide(new Date());
            } else {
               var4.setAvfEtat(this.calculEtatFinal());
               var4.setAvfDateValide((Date)null);
            }

            var5.modif(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majAchatsNoteDebit() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "NoteDebitEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new NoteDebitEnteteAchats();
         NoteDebitEnteteAchatsDao var5 = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         NoteDebitEnteteAchats var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getNdfIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getNdfIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setNdfPosSignature(this.parapheur.getPhrPosition());
            if (var4.getNdfPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setNdfEtat(this.calculEtatFinal());
               var4.setNdfDateValide(new Date());
            } else {
               var4.setNdfEtat(this.calculEtatFinal());
               var4.setNdfDateValide((Date)null);
            }

            var5.modif(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majAchatsFrais() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new FraisEnteteAchats();
         FraisEnteteAchatsDao var5 = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         FraisEnteteAchats var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getFsfIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getFsfIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setFsfPosSignature(this.parapheur.getPhrPosition());
            if (var4.getFsfPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setFsfEtat(this.calculEtatFinal());
               var4.setFsfDateValide(new Date());
            } else {
               var4.setFsfEtat(this.calculEtatFinal());
               var4.setFsfDateValide((Date)null);
            }

            var5.modif(var4, var2);
            if (var4.getFsfAnal4() != null && !var4.getFsfAnal4().isEmpty()) {
               new ValorisationEnteteAchats();
               ValorisationEnteteAchatsDao var7 = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               ValorisationEnteteAchats var13 = var7.rechercheByDossier(var4.getFsfAnal4(), var2);
               if (var13 != null) {
                  var4.setFsfValo(var13.getValNum());
                  var5.modif(var4, var2);
               }
            }

            var3.commit();
         }
      } catch (HibernateException var11) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majBonDecaissement() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonDecaissementAchat");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new BonDecaissementAchat();
         BonDecaissementAchatDao var5 = new BonDecaissementAchatDao(this.baseLog, this.utilInitHibernate);
         BonDecaissementAchat var4 = var5.selectById(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getBonIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getBonIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setBonPosSignature(this.parapheur.getPhrPosition());
            if (var4.getBonPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setBonActif(0);
            } else {
               var4.setBonActif(1);
            }

            var5.ModifBon(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majVentesSimulation() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SimulEnteteLight");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new SimulationEnteteVentes();
         SimulationEnteteVentesDao var5 = new SimulationEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         SimulationEnteteVentes var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            Users var6;
            if (var4.getSimcrtIdCommercial() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getSimcrtIdCommercial(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            } else if (var4.getSimcrtIdResponsable() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getSimcrtIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setSimcrtPosSignature(this.parapheur.getPhrPosition());
            if (var4.getSimcrtPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setSimcrtEtat(this.calculEtatFinal());
               var4.setSimcrtDateValide(new Date());
            } else {
               var4.setSimcrtEtat(this.calculEtatFinal());
               var4.setSimcrtDateValide((Date)null);
            }

            var5.modif(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majVentesBesoin() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new BesoinEnteteVentes();
         BesoinEnteteVentesDao var5 = new BesoinEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         BesoinEnteteVentes var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            Users var6;
            if (var4.getBesIdCommercial() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getBesIdCommercial(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            } else if (var4.getBesIdResponsable() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getBesIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setBesPosSignature(this.parapheur.getPhrPosition());
            if (var4.getBesPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setBesEtat(this.calculEtatFinal());
               var4.setBesDateValide(new Date());
            } else {
               var4.setBesEtat(this.calculEtatFinal());
               var4.setBesDateValide((Date)null);
            }

            var5.modif(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majVentesDevis() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new DevisEnteteVentes();
         DevisEnteteVentesDao var5 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         DevisEnteteVentes var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            Users var6;
            if (var4.getDvsIdCommercial() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getDvsIdCommercial(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            } else if (var4.getDvsIdResponsable() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getDvsIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setDvsPosSignature(this.parapheur.getPhrPosition());
            if (var4.getDvsPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setDvsEtat(this.calculEtatFinal());
               var4.setDvsDateValide(new Date());
            } else {
               var4.setDvsEtat(this.calculEtatFinal());
               var4.setDvsDateValide((Date)null);
            }

            var5.modif(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majVentesCommande() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new CommandeEnteteVentes();
         CommandeEnteteVentesDao var5 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         CommandeEnteteVentes var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            Users var6;
            if (var4.getBcmIdCommercial() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getBcmIdCommercial(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            } else if (var4.getBcmIdResponsable() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getBcmIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setBcmPosSignature(this.parapheur.getPhrPosition());
            if (var4.getBcmPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setBcmEtat(this.calculEtatFinal());
               var4.setBcmDateValide(new Date());
            } else {
               var4.setBcmEtat(this.calculEtatFinal());
               var4.setBcmDateValide((Date)null);
            }

            var5.modif(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majVentesLivraison() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new LivraisonEnteteVentes();
         LivraisonEnteteVentesDao var5 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         LivraisonEnteteVentes var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            Users var6;
            if (var4.getBlvIdCommercial() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getBlvIdCommercial(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            } else if (var4.getBlvIdResponsable() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getBlvIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setBlvPosSignature(this.parapheur.getPhrPosition());
            if (var4.getBlvPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setBlvEtat(this.calculEtatFinal());
               var4.setBlvDateValide(new Date());
            } else {
               var4.setBlvEtat(this.calculEtatFinal());
               var4.setBlvDateValide((Date)null);
            }

            var5.modif(var4, var2);
            if (var4.getBlvEtat() == 1) {
               new ArrayList();
               LivraisonLigneVentesDao var7 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
               List var13 = var7.chargerLesLignes(var4, var2);
               if (var13.size() != 0) {
               }
            }

            var3.commit();
         }
      } catch (HibernateException var11) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majVentesRetour() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new RetourEnteteVentes();
         RetourEnteteVentesDao var5 = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         RetourEnteteVentes var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            Users var6;
            if (var4.getBrtIdCommercial() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getBrtIdCommercial(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            } else if (var4.getBrtIdResponsable() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getBrtIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setBrtPosSignature(this.parapheur.getPhrPosition());
            if (var4.getBrtPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setBrtEtat(this.calculEtatFinal());
               var4.setBrtDateValide(new Date());
            } else {
               var4.setBrtEtat(this.calculEtatFinal());
               var4.setBrtDateValide((Date)null);
            }

            var5.modif(var4, var2);
            if (var4.getBrtEtat() == 1) {
               new ArrayList();
               RetourLigneVentesDao var7 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
               List var13 = var7.chargerLesLignes(var4, var2);
               if (var13.size() != 0) {
                  this.calculStock.majRetourVentesVAL(var13, this.baseLog, var2);
               }
            }

            var3.commit();
         }
      } catch (HibernateException var11) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majVentesFacture() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new FactureEnteteVentes();
         FactureEnteteVentesDao var5 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         FactureEnteteVentes var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            Users var6;
            if (var4.getFacIdCommercial() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getFacIdCommercial(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            } else if (var4.getFacIdResponsable() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getFacIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setFacPosSignature(this.parapheur.getPhrPosition());
            if (var4.getFacPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setFacEtat(this.calculEtatFinal());
               var4.setFacDateValide(new Date());
            } else {
               var4.setFacEtat(this.calculEtatFinal());
               var4.setFacDateValide((Date)null);
            }

            var5.modif(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majVentesAvoir() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new AvoirEnteteVentes();
         AvoirEnteteVentesDao var5 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         AvoirEnteteVentes var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            Users var6;
            if (var4.getAvrIdCommercial() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getAvrIdCommercial(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            } else if (var4.getAvrIdResponsable() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getAvrIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setAvrPosSignature(this.parapheur.getPhrPosition());
            if (var4.getAvrPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setAvrEtat(this.calculEtatFinal());
               var4.setAvrDateValide(new Date());
            } else {
               var4.setAvrEtat(this.calculEtatFinal());
               var4.setAvrDateValide((Date)null);
            }

            var5.modif(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majVentesNoteDebit() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new NoteDebitEnteteVentes();
         NoteDebitEnteteVentesDao var5 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         NoteDebitEnteteVentes var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            Users var6;
            if (var4.getNdbIdCommercial() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getNdbIdCommercial(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            } else if (var4.getNdbIdResponsable() != 0L) {
               new Users();
               var6 = this.usersDao.selectByIdUsers(var4.getNdbIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setNdbPosSignature(this.parapheur.getPhrPosition());
            if (var4.getNdbPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setNdbEtat(this.calculEtatFinal());
               var4.setNdbDateValide(new Date());
            } else {
               var4.setNdbEtat(this.calculEtatFinal());
               var4.setNdbDateValide((Date)null);
            }

            var5.modif(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majBonEncaissement() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new BonEncaissementVente();
         BonEncaissementVenteDao var5 = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
         BonEncaissementVente var4 = var5.selectById(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getBonIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getBonIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setBonPosSignature(this.parapheur.getPhrPosition());
            if (var4.getBonPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setBonActif(0);
            } else {
               var4.setBonActif(1);
            }

            var5.ModifBon(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majStockInventaire() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireLigne");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new InventaireEntete();
         InventaireEnteteDao var5 = new InventaireEnteteDao(this.baseLog, this.utilInitHibernate);
         InventaireEntete var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getInvIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getInvIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setInvPosSignature(this.parapheur.getPhrPosition());
            if (var4.getInvPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setInvEtat(this.calculEtatFinal());
               var4.setInvDateValide(new Date());
            } else {
               var4.setInvEtat(this.calculEtatFinal());
               var4.setInvDateValide((Date)null);
            }

            var5.modif(var4, var2);
            if (var4.getInvEtat() == 1) {
               new ArrayList();
               InventaireLigneDao var7 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
               List var13 = var7.chargerLesLignes(var4, var2);
               if (var13.size() != 0) {
                  this.calculStock.majInventaire(var13, 1, this.baseLog, var2);
               }
            }

            var3.commit();
         }
      } catch (HibernateException var11) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majStockEntree() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeLigne");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new BonEntreeEntete();
         BonEntreeEnteteDao var5 = new BonEntreeEnteteDao(this.baseLog, this.utilInitHibernate);
         BonEntreeEntete var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getBinIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getBinIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setBinPosSignature(this.parapheur.getPhrPosition());
            if (var4.getBinPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setBinEtat(this.calculEtatFinal());
               var4.setBinDateValide(new Date());
            } else {
               var4.setBinEtat(this.calculEtatFinal());
               var4.setBinDateValide((Date)null);
            }

            var5.modif(var4, var2);
            if (var4.getBinEtat() == 1) {
               new ArrayList();
               BonEntreeLigneDao var7 = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
               List var13 = var7.chargerLesLignes(var4, var2);
               if (var13.size() != 0) {
                  this.calculStock.majBonEntree((List)var13, 1, this.baseLog, var2);
               }
            }

            var3.commit();
         }
      } catch (HibernateException var11) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majStockSortie() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonSortieLigne");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new BonSortieEntete();
         BonSortieEnteteDao var5 = new BonSortieEnteteDao(this.baseLog, this.utilInitHibernate);
         BonSortieEntete var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getBouIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getBouIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setBouPosSignature(this.parapheur.getPhrPosition());
            if (var4.getBouPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setBouEtat(this.calculEtatFinal());
               var4.setBouDateValide(new Date());
            } else {
               var4.setBouEtat(this.calculEtatFinal());
               var4.setBouDateValide((Date)null);
            }

            var5.modif(var4, var2);
            if (var4.getBouEtat() == 1) {
               new ArrayList();
               BonSortieLigneDao var7 = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
               List var13 = var7.chargerLesLignes(var4, var2);
               if (var13.size() != 0) {
                  this.calculStock.majBonSortie(var13, 1, this.baseLog, var2);
               }
            }

            var3.commit();
         }
      } catch (HibernateException var11) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majStockCession() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CessionLigne");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new CessionEntete();
         CessionEnteteDao var5 = new CessionEnteteDao(this.baseLog, this.utilInitHibernate);
         CessionEntete var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getCesIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getCesIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setCesPosSignature(this.parapheur.getPhrPosition());
            if (var4.getCesPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setCesEtat(this.calculEtatFinal());
               var4.setCesDateValide(new Date());
            } else {
               var4.setCesEtat(this.calculEtatFinal());
               var4.setCesDateValide((Date)null);
            }

            var5.modif(var4, var2);
            if (var4.getCesEtat() == 1) {
               new ArrayList();
               CessionLigneDao var7 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
               List var13 = var7.chargerLesLignes(var4, var2);
               if (var13.size() != 0) {
                  this.calculStock.majCession(var13, 1, this.baseLog, var2);
               }
            }

            var3.commit();
         }
      } catch (HibernateException var11) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majStockProduction() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new FabricationEnteteAchats();
         FabricationEnteteAchatsDao var5 = new FabricationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         FabricationEnteteAchats var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getFabIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getFabIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setFabPosSignature(this.parapheur.getPhrPosition());
            if (var4.getFabPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setFabEtat(this.calculEtatFinal());
               var4.setFabDateValide(new Date());
            } else {
               var4.setFabEtat(this.calculEtatFinal());
               var4.setFabDateValide((Date)null);
            }

            var5.modif(var4, var2);
            if (var4.getFabEtat() == 1) {
               new ArrayList();
               FabricationLigneAchatsDao var7 = new FabricationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               List var13 = var7.chargerLesLignes(var4, var2);
               if (var13.size() != 0) {
                  this.calculStock.majFabrication((List)var13, 1, this.baseLog, var2);
               }
            }

            var3.commit();
         }
      } catch (HibernateException var11) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majCaisseBonSortie() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonSortieCaiss");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new BonSortieCaiss();
         BonSortieCaissDao var5 = new BonSortieCaissDao(this.baseLog, this.utilInitHibernate);
         BonSortieCaiss var4 = var5.selectById(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getSortIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getSortIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setSortPosSignature(this.parapheur.getPhrPosition());
            if (var4.getSortPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setSortEtat(this.calculEtatFinal());
               var4.setSortDateValide(new Date());
            } else {
               var4.setSortEtat(this.calculEtatFinal());
               var4.setSortDateValide((Date)null);
            }

            var5.modif(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majCaisseBonEntree() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeCaiss");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new BonEntreCaiss();
         BonEntreCaissDao var5 = new BonEntreCaissDao(this.baseLog, this.utilInitHibernate);
         BonEntreCaiss var4 = var5.selectById(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getEntrIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getEntrIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setEntrPosSignature(this.parapheur.getPhrPosition());
            if (var4.getEntrPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setEntrEtat(this.calculEtatFinal());
               var4.setEntrDateValide(new Date());
            } else {
               var4.setEntrEtat(this.calculEtatFinal());
               var4.setEntrDateValide((Date)null);
            }

            var5.modif(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public String majCaisseBonVirement() throws HibernateException, NamingException {
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "VirementInterne");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new VirementInterne();
         VirementInterneDao var5 = new VirementInterneDao(this.baseLog, this.utilInitHibernate);
         VirementInterne var4 = var5.selectById(this.parapheur.getPhrDocId(), var2);
         if (var4 != null) {
            if (var4.getVirIdResponsable() != 0L) {
               new Users();
               Users var6 = this.usersDao.selectByIdUsers(var4.getVirIdResponsable(), var2);
               if (var6 != null && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty()) {
                  var1 = var6.getUsrMail();
               }
            }

            var4.setVirPosSignature(this.parapheur.getPhrPosition());
            if (var4.getVirPosSignature() >= this.parapheur.getPhrNombre()) {
               var4.setVirEtat(this.calculEtatFinal());
               var4.setVirDateValide(new Date());
            } else {
               var4.setVirEtat(this.calculEtatFinal());
               var4.setVirDateValide((Date)null);
            }

            var5.modif(var4, var2);
            var3.commit();
         }
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public void majPayeContrat() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         new SalariesContrats();
         SalariesContratsDao var4 = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
         SalariesContrats var3 = var4.pourParapheur(this.parapheur.getPhrDocId(), var1);
         if (var3 != null) {
            var3.setSalconPosSignature(this.parapheur.getPhrPosition());
            if (var3.getSalconPosSignature() >= this.parapheur.getPhrNombre()) {
               var3.setSalconEtat(this.calculEtatFinal());
               var3.setSalconDateValide(new Date());
               String var5 = "";
               if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
                  String var6 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + this.baseLog + "/photos/Users/" + this.usersLog.getUsrSignature();
                  var5 = var3.getSalconTexte() + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var6 + " alt=" + "signature /></p>";
                  var3.setSalconTexte(var5);
               }
            } else {
               var3.setSalconEtat(this.calculEtatFinal());
               var3.setSalconDateValide((Date)null);
            }

            var4.modif(var3, var1);
            var2.commit();
         }
      } catch (HibernateException var10) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void majPayeAttestation() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         new SalariesGrh();
         SalariesGrhDao var4 = new SalariesGrhDao(this.baseLog, this.utilInitHibernate);
         SalariesGrh var3 = var4.pourParapheur(this.parapheur.getPhrDocId(), var1);
         if (var3 != null) {
            var3.setSalgrhPosSignature(this.parapheur.getPhrPosition());
            if (var3.getSalgrhPosSignature() >= this.parapheur.getPhrNombre()) {
               var3.setSalgrhEtat(this.calculEtatFinal());
               var3.setSalgrhDateValide(new Date());
               String var5 = "";
               if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
                  String var6 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
                  var5 = var3.getSalgrhTexte() + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var6 + " alt=" + "signature /></p>";
                  var3.setSalgrhTexte(var5);
               }
            } else {
               var3.setSalgrhEtat(this.calculEtatFinal());
               var3.setSalgrhDateValide((Date)null);
            }

            var4.modif(var3, var1);
            var2.commit();
         }
      } catch (HibernateException var10) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void majPayeCursus() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         new SalariesGrh();
         SalariesGrhDao var4 = new SalariesGrhDao(this.baseLog, this.utilInitHibernate);
         SalariesGrh var3 = var4.pourParapheur(this.parapheur.getPhrDocId(), var1);
         if (var3 != null) {
            var3.setSalgrhPosSignature(this.parapheur.getPhrPosition());
            if (var3.getSalgrhPosSignature() >= this.parapheur.getPhrNombre()) {
               var3.setSalgrhEtat(this.calculEtatFinal());
               var3.setSalgrhDateValide(new Date());
               String var5 = "";
               if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
                  String var6 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
                  var5 = var3.getSalgrhTexte() + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var6 + " alt=" + "signature /></p>";
                  var3.setSalgrhTexte(var5);
               }
            } else {
               var3.setSalgrhEtat(this.calculEtatFinal());
               var3.setSalgrhDateValide((Date)null);
            }

            var4.modif(var3, var1);
            var2.commit();
         }
      } catch (HibernateException var10) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void majPayeCertificat() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         new SalariesGrh();
         SalariesGrhDao var4 = new SalariesGrhDao(this.baseLog, this.utilInitHibernate);
         SalariesGrh var3 = var4.pourParapheur(this.parapheur.getPhrDocId(), var1);
         if (var3 != null) {
            var3.setSalgrhPosSignature(this.parapheur.getPhrPosition());
            if (var3.getSalgrhPosSignature() >= this.parapheur.getPhrNombre()) {
               var3.setSalgrhEtat(this.calculEtatFinal());
               var3.setSalgrhDateValide(new Date());
               String var5 = "";
               if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
                  String var6 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
                  var5 = var3.getSalgrhTexte() + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var6 + " alt=" + "signature /></p>";
                  var3.setSalgrhTexte(var5);
               }
            } else {
               var3.setSalgrhEtat(this.calculEtatFinal());
               var3.setSalgrhDateValide((Date)null);
            }

            var4.modif(var3, var1);
            var2.commit();
         }
      } catch (HibernateException var10) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void majPayeCorrespondance() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         new SalariesGrh();
         SalariesGrhDao var4 = new SalariesGrhDao(this.baseLog, this.utilInitHibernate);
         SalariesGrh var3 = var4.pourParapheur(this.parapheur.getPhrDocId(), var1);
         if (var3 != null) {
            var3.setSalgrhPosSignature(this.parapheur.getPhrPosition());
            if (var3.getSalgrhPosSignature() >= this.parapheur.getPhrNombre()) {
               var3.setSalgrhEtat(this.calculEtatFinal());
               var3.setSalgrhDateValide(new Date());
               String var5 = "";
               if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
                  String var6 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
                  var5 = var3.getSalgrhTexte() + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var6 + " alt=" + "signature /></p>";
                  var3.setSalgrhTexte(var5);
               }
            } else {
               var3.setSalgrhEtat(this.calculEtatFinal());
               var3.setSalgrhDateValide((Date)null);
            }

            var4.modif(var3, var1);
            var2.commit();
         }
      } catch (HibernateException var10) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void majPayePret() throws HibernateException, NamingException, JDOMException, IOException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         LectureNaturePrets var3 = new LectureNaturePrets();
         var3.setStrId(this.structureLog.getStrid());
         var3.setStructureLog(this.structureLog);
         List var4 = var3.chargerMesNaturesPretsItems();
         new SalariesPrets(var4);
         SalariesPretsDao var6 = new SalariesPretsDao(this.baseLog, this.utilInitHibernate);
         SalariesPrets var5 = var6.pourParapheur(this.parapheur.getPhrDocId(), var1);
         if (var5 != null) {
            var5.setSalprePosSignature(this.parapheur.getPhrPosition());
            if (var5.getSalprePosSignature() >= this.parapheur.getPhrNombre()) {
               var5.setSalpreEtat(this.calculEtatFinal());
               var5.setSalpreDateValide(new Date());
            } else {
               var5.setSalpreEtat(this.calculEtatFinal());
               var5.setSalpreDateValide((Date)null);
            }

            var6.modif(var5, var1);
            var2.commit();
         }
      } catch (HibernateException var10) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void majPayeConges() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         new SalariesConges();
         SalariesCongesDao var4 = new SalariesCongesDao(this.baseLog, this.utilInitHibernate);
         SalariesConges var3 = var4.pourParapheur(this.parapheur.getPhrDocId(), var1);
         if (var3 != null) {
            var3.setSalcngPosSignature(this.parapheur.getPhrPosition());
            if (var3.getSalcngPosSignature() >= this.parapheur.getPhrNombre()) {
               var3.setSalcngEtat(this.calculEtatFinal());
               var3.setSalcngDateValide(new Date());
            } else {
               var3.setSalcngEtat(this.calculEtatFinal());
               var3.setSalcngDateValide((Date)null);
            }

            var4.modif(var3, var1);
            var2.commit();
         }
      } catch (HibernateException var8) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void majPayeAbsence() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         new SalariesConges();
         SalariesCongesDao var4 = new SalariesCongesDao(this.baseLog, this.utilInitHibernate);
         SalariesConges var3 = var4.pourParapheur(this.parapheur.getPhrDocId(), var1);
         if (var3 != null) {
            var3.setSalcngPosSignature(this.parapheur.getPhrPosition());
            if (var3.getSalcngPosSignature() >= this.parapheur.getPhrNombre()) {
               var3.setSalcngEtat(this.calculEtatFinal());
               var3.setSalcngDateValide(new Date());
            } else {
               var3.setSalcngEtat(this.calculEtatFinal());
               var3.setSalcngDateValide((Date)null);
            }

            var4.modif(var3, var1);
            var2.commit();
         }
      } catch (HibernateException var8) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void lesIndisponibles(Session var1) throws HibernateException, NamingException {
      this.mesUsersIndisponiblesItems.clear();
      this.lesUsers = this.usersDao.chargerLesUsersIndisponibles(var1);
      if (this.lesUsers.size() != 0) {
         for(int var2 = 0; var2 < this.lesUsers.size(); ++var2) {
            if (((Users)this.lesUsers.get(var2)).getUsrDateDebutIndisponibilite() != null && ((Users)this.lesUsers.get(var2)).getUsrDateFinIndisponibilite() != null) {
               this.mesUsersIndisponiblesItems.add(new SelectItem(((Users)this.lesUsers.get(var2)).getUsrid(), ((Users)this.lesUsers.get(var2)).getUsrPatronyme() + " absent du " + this.utilDate.dateToStringFrLg(((Users)this.lesUsers.get(var2)).getUsrDateDebutIndisponibilite()) + " au " + this.utilDate.dateToStringFrLg(((Users)this.lesUsers.get(var2)).getUsrDateFinIndisponibilite())));
            }
         }
      }

   }

   public void modifAbsence() {
      this.showModalPanelIndisponibilite = true;
   }

   public void fermerAbsence() {
      this.showModalPanelIndisponibilite = false;
   }

   public void validerAbsence() throws HibernateException, NamingException {
      this.usersLog = this.usersDao.modUser(this.usersLog);
      this.lesIndisponibles((Session)null);
      this.showModalPanelIndisponibilite = false;
   }

   public ObjetDevises LeLibDevise(String var1) throws IOException {
      this.lectureFluxDevises = new LectureDevises();
      return this.lectureFluxDevises.devisesRecherchee(var1, this.structureLog.getStrdevise());
   }

   public void docVisualiser() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      int var1 = this.parapheur.getPhrNature();
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilPrint.setBaseLog(this.baseLog);
      this.utilPrint.setStructureLog(this.structureLog);
      this.utilPrint.setUsersLog(this.usersLog);
      if (var1 == 10) {
         this.visualiserDemandeAchat();
      } else if (var1 == 11) {
         this.visualiserCotationAchat();
      } else if (var1 == 12) {
         this.visualiserCommandeAchat();
      } else if (var1 == 13) {
         this.visualiserReceptionAchat();
      } else if (var1 == 14) {
         this.visualiserRetourAchat();
      } else if (var1 == 15) {
         this.visualiserFactureAchat();
      } else if (var1 == 16) {
         this.visualiserAvoirAchat();
      } else if (var1 == 17) {
         this.visualiserNoteDebitAchat();
      } else if (var1 == 18) {
         this.visualiserFraisAchat();
      } else if (var1 == 19) {
         this.visualiserBonDecaissement();
      } else if (var1 == 8) {
         this.visualiserSimulationVentes();
      } else if (var1 == 20) {
         this.visualiserBesoinVentes();
      } else if (var1 == 21) {
         this.visualiserDevisVentes();
      } else if (var1 == 22) {
         this.visualiserCommandeVentes();
      } else if (var1 == 23) {
         this.visualiserLivraisonVentes();
      } else if (var1 == 24) {
         this.visualiserRetourVentes();
      } else if (var1 == 25) {
         this.visualiserFactureVentes();
      } else if (var1 == 26) {
         this.visualiserAvoirVentes();
      } else if (var1 == 27) {
         this.visualiserNoteDebitVentes();
      } else if (var1 == 140) {
         this.visualiserContratVentes();
      } else if (var1 == 142) {
         this.visualiserFactureInterneVentes();
      } else if (var1 != 28 && var1 != 29 && var1 != 30 && var1 != 31 && var1 != 40 && var1 != 41 && var1 != 42 && var1 != 43 && var1 != 44 && var1 != 45) {
         if (var1 == 62) {
            this.visualiserBonSortieCaisse();
         } else if (var1 == 64) {
            this.visualiserVirementCaisse();
         } else if (var1 == 82) {
            this.visualiserContrat();
         } else if (var1 == 83) {
            this.visualiserDocumentRh();
         } else if (var1 == 84) {
            this.visualiserDocumentRh();
         } else if (var1 == 85) {
            this.visualiserDocumentRh();
         } else if (var1 == 86) {
            this.visualiserDocumentRh();
         } else if (var1 == 87) {
            this.visualiserPret();
         } else if (var1 == 88) {
            this.visualiserConges();
         } else if (var1 == 89) {
            this.visualiserAbsences();
         }
      }

   }

   public String calculeEtatDefaut(int var1, String var2) {
      String var3 = "";
      String var4 = "";
      if (var1 == 10) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "da" + File.separator;
      } else if (var1 == 11) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "cotation" + File.separator;
      } else if (var1 == 12) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "commande" + File.separator;
      } else if (var1 == 13) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "reception" + File.separator;
      } else if (var1 == 14) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "retour" + File.separator;
      } else if (var1 == 15) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "facture" + File.separator;
      } else if (var1 == 16) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "avoir" + File.separator;
      } else if (var1 == 17) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      } else if (var1 == 18) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "frais" + File.separator;
      } else if (var1 == 19) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "bon_decaissement" + File.separator;
      } else if (var1 == 35) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "valorisation" + File.separator;
      } else if (var1 == 30) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "inventaire" + File.separator;
      } else if (var1 == 31) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "bon_entree" + File.separator;
      } else if (var1 == 32) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "bon_sortie" + File.separator;
      } else if (var1 == 33) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "cession" + File.separator;
      } else if (var1 == 34) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "production" + File.separator;
      } else if (var1 == 35) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "valorisation" + File.separator;
      } else if (var1 == 36) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "sommier" + File.separator;
      } else if (var1 == 6) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "ticket" + File.separator;
      } else if (var1 == 7) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "commission" + File.separator;
      } else if (var1 == 8) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "simulation" + File.separator;
      } else if (var1 == 9) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "contrat" + File.separator;
      } else if (var1 == 20) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "besoin" + File.separator;
      } else if (var1 == 21) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "devis" + File.separator;
      } else if (var1 == 22) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "commande" + File.separator;
      } else if (var1 == 23) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "livraison" + File.separator;
      } else if (var1 == 24) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "retour" + File.separator;
      } else if (var1 == 25) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "facture" + File.separator;
      } else if (var1 == 26) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "avoir" + File.separator;
      } else if (var1 == 27) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      } else if (var1 == 28) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "chargement" + File.separator;
      } else if (var1 == 29) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "bon_encaissement" + File.separator;
      } else if (var1 == 140) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "contratVente" + File.separator;
      } else if (var1 == 141) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "campagne" + File.separator;
      } else if (var1 == 142) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "facture_interne" + File.separator;
      }

      File var5 = new File(var4);
      if (!var5.exists()) {
         var5.mkdir();
      }

      String[] var6 = var5.list();
      if (var6 != null) {
         var6 = this.triAlphabetique(var6, var6.length);

         int var7;
         String var8;
         for(var7 = 0; var7 < var6.length; ++var7) {
            if (var6[var7].endsWith("jasper")) {
               var8 = var6[var7].substring(0, var6[var7].indexOf("."));
               if (var2 == null || var2.isEmpty()) {
                  var3 = var8;
                  break;
               }

               if (var8.equals(var2)) {
                  var3 = var8;
                  break;
               }
            }
         }

         if (var3 == null || var3.isEmpty()) {
            for(var7 = 0; var7 < var6.length; ++var7) {
               if (var6[var7].endsWith("jasper")) {
                  var8 = var6[var7].substring(0, var6[var7].indexOf("."));
                  var3 = var8;
                  break;
               }
            }
         }
      }

      return var3;
   }

   public String[] triAlphabetique(String[] var1, int var2) {
      int var3 = var2;
      boolean var4;
      if (var2 != 0) {
         do {
            var4 = false;

            for(int var5 = 0; var5 < var3 - 1; ++var5) {
               if (var1[var5].compareToIgnoreCase(var1[var5 + 1]) > 0) {
                  this.echanger(var1, var5, var5 + 1);
                  var4 = true;
               }
            }

            --var3;
         } while(var4);
      }

      return var1;
   }

   public void echanger(String[] var1, int var2, int var3) {
      String var4 = var1[var2];
      var1[var2] = var1[var3];
      var1[var3] = var4;
   }

   public void visualiserDemandeAchat() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormDemandeAchats var1 = new FormDemandeAchats();
      new DemandeEnteteAchats();
      DemandeEnteteAchatsDao var3 = new DemandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      DemandeEnteteAchats var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getDemModeleImp() == null || var2.getDemModeleImp().isEmpty()) {
            var2.setDemModeleImp(this.calculeEtatDefaut(10, ""));
         }

         if (var2.getDemModeleImp() != null && !var2.getDemModeleImp().isEmpty()) {
            DemandeLigneAchatsDao var4 = new DemandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getDemTotTtc() + var2.getDemTotTc(), this.structureLog.getStrdevise());
               this.utilPrint.setRapport(var2.getDemModeleImp());
               this.utilPrint.setEntete("Impression demande achat");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 10));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getDemEtat()));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getDemIdResponsable());
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getDemId());
               if (var2.getDemAnal2() != null && !var2.getDemAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getDemAnal2().contains(":")) {
                     String[] var8 = var2.getDemAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getDemAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserCotationAchat() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormCotationAchats var1 = new FormCotationAchats();
      new CotationEnteteAchats();
      CotationEnteteAchatsDao var3 = new CotationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      CotationEnteteAchats var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getCotModeleImp() == null || var2.getCotModeleImp().isEmpty()) {
            var2.setCotModeleImp(this.calculeEtatDefaut(11, ""));
         }

         if (var2.getCotModeleImp() != null && !var2.getCotModeleImp().isEmpty()) {
            CotationLigneAchatsDao var4 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getCotTotTtc() + var2.getCotTotTc(), var2.getCotDevise());
               this.utilPrint.setRapport(var2.getCotModeleImp());
               this.utilPrint.setEntete("Impression cotation");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 11));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getCotEtat()));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getCotIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getCotId());
               if (var2.getCotAnal2() != null && !var2.getCotAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getCotAnal2().contains(":")) {
                     String[] var8 = var2.getCotAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getCotAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserCommandeAchat() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormCommandeAchats var1 = new FormCommandeAchats();
      new CommandeEnteteAchats();
      CommandeEnteteAchatsDao var3 = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      CommandeEnteteAchats var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getCmdModeleImp() == null || var2.getCmdModeleImp().isEmpty()) {
            var2.setCmdModeleImp(this.calculeEtatDefaut(12, ""));
         }

         if (var2.getCmdModeleImp() != null && !var2.getCmdModeleImp().isEmpty()) {
            CommandeLigneAchatsDao var4 = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getCmdTotTtc() + var2.getCmdTotTc(), var2.getCmdDevise());
               this.utilPrint.setRapport(var2.getCmdModeleImp());
               this.utilPrint.setEntete("Impression commande");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 12));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getCmdEtat()));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getCmdIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getCmdId());
               if (var2.getCmdAnal2() != null && !var2.getCmdAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getCmdAnal2().contains(":")) {
                     String[] var8 = var2.getCmdAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getCmdAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserReceptionAchat() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormReceptionAchats var1 = new FormReceptionAchats();
      new ReceptionEnteteAchats();
      ReceptionEnteteAchatsDao var3 = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      ReceptionEnteteAchats var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getRecModeleImp() == null || var2.getRecModeleImp().isEmpty()) {
            var2.setRecModeleImp(this.calculeEtatDefaut(13, ""));
         }

         if (var2.getRecModeleImp() != null && !var2.getRecModeleImp().isEmpty()) {
            ReceptionLigneAchatsDao var4 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes((ReceptionEnteteAchats)var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getRecTotTtc() + var2.getRecTotTc(), var2.getRecDevise());
               this.utilPrint.setRapport(var2.getRecModeleImp());
               this.utilPrint.setEntete("Impression réception");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 13));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getRecEtat()));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getRecIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getRecId());
               if (var2.getRecAnal2() != null && !var2.getRecAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getRecAnal2().contains(":")) {
                     String[] var8 = var2.getRecAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getRecAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserRetourAchat() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormRetourAchats var1 = new FormRetourAchats();
      new RetourEnteteAchats();
      RetourEnteteAchatsDao var3 = new RetourEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      RetourEnteteAchats var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getBrfModeleImp() == null || var2.getBrfModeleImp().isEmpty()) {
            var2.setBrfModeleImp(this.calculeEtatDefaut(14, ""));
         }

         if (var2.getBrfModeleImp() != null && !var2.getBrfModeleImp().isEmpty()) {
            RetourLigneAchatsDao var4 = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getBrfTotTtc() + var2.getBrfTotTc(), var2.getBrfDevise());
               this.utilPrint.setRapport(var2.getBrfModeleImp());
               this.utilPrint.setEntete("Impression retour");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 14));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getBrfEtat()));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getBrfIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getBrfId());
               if (var2.getBrfAnal2() != null && !var2.getBrfAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getBrfAnal2().contains(":")) {
                     String[] var8 = var2.getBrfAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getBrfAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserFactureAchat() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormFactureAchats var1 = new FormFactureAchats();
      new FactureEnteteAchats();
      FactureEnteteAchatsDao var3 = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      FactureEnteteAchats var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getFcfModeleImp() == null || var2.getFcfModeleImp().isEmpty()) {
            var2.setFcfModeleImp(this.calculeEtatDefaut(15, ""));
         }

         if (var2.getFcfModeleImp() != null && !var2.getFcfModeleImp().isEmpty()) {
            FactureLigneAchatsDao var4 = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getFcfTotTtc() + var2.getFcfTotTc(), var2.getFcfDevise());
               this.utilPrint.setRapport(var2.getFcfModeleImp());
               this.utilPrint.setEntete("Impression facture");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 15));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getFcfEtat()));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getFcfIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getFcfId());
               if (var2.getFcfAnal2() != null && !var2.getFcfAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getFcfAnal2().contains(":")) {
                     String[] var8 = var2.getFcfAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getFcfAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserAvoirAchat() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormAvoirAchats var1 = new FormAvoirAchats();
      new AvoirEnteteAchats();
      AvoirEnteteAchatsDao var3 = new AvoirEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      AvoirEnteteAchats var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getAvfModeleImp() == null || var2.getAvfModeleImp().isEmpty()) {
            var2.setAvfModeleImp(this.calculeEtatDefaut(16, ""));
         }

         if (var2.getAvfModeleImp() != null && !var2.getAvfModeleImp().isEmpty()) {
            AvoirLigneAchatsDao var4 = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getAvfTotTtc() + var2.getAvfTotTc(), var2.getAvfDevise());
               this.utilPrint.setRapport(var2.getAvfModeleImp());
               this.utilPrint.setEntete("Impression avoir");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 16));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getAvfEtat()));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getAvfIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getAvfId());
               if (var2.getAvfAnal2() != null && !var2.getAvfAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getAvfAnal2().contains(":")) {
                     String[] var8 = var2.getAvfAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getAvfAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserNoteDebitAchat() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormNoteDebitAchats var1 = new FormNoteDebitAchats();
      new NoteDebitEnteteAchats();
      NoteDebitEnteteAchatsDao var3 = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      NoteDebitEnteteAchats var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getNdfModeleImp() == null || var2.getNdfModeleImp().isEmpty()) {
            var2.setNdfModeleImp(this.calculeEtatDefaut(17, ""));
         }

         if (var2.getNdfModeleImp() != null && !var2.getNdfModeleImp().isEmpty()) {
            NoteDebitLigneAchatsDao var4 = new NoteDebitLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getNdfTotTtc() + var2.getNdfTotTc(), var2.getNdfDevise());
               this.utilPrint.setRapport(var2.getNdfModeleImp());
               this.utilPrint.setEntete("Impression note de Debit");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 17));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getNdfEtat()));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getNdfIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getNdfId());
               if (var2.getNdfAnal2() != null && !var2.getNdfAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getNdfAnal2().contains(":")) {
                     String[] var8 = var2.getNdfAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getNdfAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserFraisAchat() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormFraisAchats var1 = new FormFraisAchats();
      new FraisEnteteAchats();
      FraisEnteteAchatsDao var3 = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      FraisEnteteAchats var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getFsfModeleImp() == null || var2.getFsfModeleImp().isEmpty()) {
            var2.setFsfModeleImp(this.calculeEtatDefaut(18, ""));
         }

         if (var2.getFsfModeleImp() != null && !var2.getFsfModeleImp().isEmpty()) {
            FraisLigneAchatsDao var4 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getFsfTotTtc() + var2.getFsfTotTc(), var2.getFsfDevise());
               this.utilPrint.setRapport(var2.getFsfModeleImp());
               this.utilPrint.setEntete("Impression frais");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getFsfEtat()));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getFsfIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getFsfId());
               if (var2.getFsfAnal2() != null && !var2.getFsfAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getFsfAnal2().contains(":")) {
                     String[] var8 = var2.getFsfAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getFsfAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserBonDecaissement() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormBonDecaissementAchats var1 = new FormBonDecaissementAchats();
      new BonDecaissementAchat();
      BonDecaissementAchatDao var3 = new BonDecaissementAchatDao(this.baseLog, this.utilInitHibernate);
      BonDecaissementAchat var2 = var3.selectById(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null && var2.getBonModeleImp() != null && !var2.getBonModeleImp().isEmpty()) {
         ArrayList var4 = new ArrayList();
         var4.add(var2);
         JRBeanCollectionDataSource var5 = new JRBeanCollectionDataSource(var4);
         this.utilPrint.setjRBeanCollectionDataSource(var5);
         this.montant_lettre = this.utilNombre.begin(var2.getBonAPayer(), var2.getBonDevise());
         this.utilPrint.setRapport(var2.getBonModeleImp());
         this.utilPrint.setEntete("Impression du bon de décaissement en cours");
         this.utilPrint.setMontant_lettre(this.montant_lettre);
         this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid()));
         this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setIdResponsable(var2.getBonUserCreat());
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(this.parapheur.getPhrNature());
         this.utilPrint.setId_doc(var2.getBonId());
         this.utilPrint.imprimeRapport();
      }

   }

   public void visualiserSimulationVentes() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormSimulContratVentes var1 = new FormSimulContratVentes();
      new SimulationEnteteVentes();
      SimulationEnteteVentesDao var3 = new SimulationEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      SimulationEnteteVentes var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getSimcrtModeleImp() == null || var2.getSimcrtModeleImp().isEmpty()) {
            var2.setSimcrtModeleImp(this.calculeEtatDefaut(8, ""));
         }

         if (var2.getSimcrtModeleImp() != null && !var2.getSimcrtModeleImp().isEmpty()) {
            new Produits();
            ProduitsVtesDao var5 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
            Produits var4 = var5.chargeProduit(var2.getSimcrtCode(), (Session)null);
            if (var4.getProPhoto() != null && !var4.getProPhoto().isEmpty()) {
               var2.setVar_photo(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator + var4.getProPhoto());
            } else {
               var2.setVar_photo((String)null);
            }

            var2.setVar_descriptif(var4.getProDescrip());
            var2.setVar_suite((String)null);
            var2.setVar_condition((String)null);
            ArrayList var6 = new ArrayList();
            var6.add(var2);
            JRBeanCollectionDataSource var7 = new JRBeanCollectionDataSource(var6);
            this.utilPrint.setjRBeanCollectionDataSource(var7);
            this.montant_lettre = this.utilNombre.begin(var2.getSimcrtTotTtc() + var2.getSimcrtTotTc(), var2.getSimcrtDevise());
            this.utilPrint.setRapport(var2.getSimcrtModeleImp());
            this.utilPrint.setEntete("Impression simulation");
            this.utilPrint.setMontant_lettre(this.montant_lettre);
            this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
            this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
            this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getSimcrtEtat()));
            this.utilPrint.setDuplicata("true");
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setIdResponsable(var2.getSimcrtIdResponsable());
            this.utilPrint.setTiersSelectionne(var2.getTiers());
            this.utilPrint.setNature(this.parapheur.getPhrNature());
            this.utilPrint.setId_doc(var2.getSimcrtId());
            if (var2.getSimcrtAnal2() != null && !var2.getSimcrtAnal2().isEmpty()) {
               String var8 = "";
               if (var2.getSimcrtAnal2().contains(":")) {
                  String[] var9 = var2.getSimcrtAnal2().split(":");
                  var8 = var9[0];
               } else {
                  var8 = var2.getSimcrtAnal2();
               }

               new Parc();
               ParcDao var10 = new ParcDao(this.baseLog, this.utilInitHibernate);
               Parc var11 = var10.rechercheParc(var8, (Session)null);
               if (var11 != null) {
                  this.utilPrint.setParc(var11);
               } else {
                  this.utilPrint.setParc((Parc)null);
               }
            } else {
               this.utilPrint.setParc((Parc)null);
            }

            this.utilPrint.imprimeRapport();
         }
      }

   }

   public void visualiserBesoinVentes() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormBesoinVentes var1 = new FormBesoinVentes();
      new BesoinEnteteVentes();
      BesoinEnteteVentesDao var3 = new BesoinEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      BesoinEnteteVentes var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getBesModeleImp() == null || var2.getBesModeleImp().isEmpty()) {
            var2.setBesModeleImp(this.calculeEtatDefaut(20, ""));
         }

         if (var2.getBesModeleImp() != null && !var2.getBesModeleImp().isEmpty()) {
            BesoinLigneVentesDao var4 = new BesoinLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getBesTotTtc() + var2.getBesTotTc(), var2.getBesDevise());
               this.utilPrint.setRapport(var2.getBesModeleImp());
               this.utilPrint.setEntete("Impression besoin");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 20));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getBesEtat()));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getBesIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getBesId());
               if (var2.getBesAnal2() != null && !var2.getBesAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getBesAnal2().contains(":")) {
                     String[] var8 = var2.getBesAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getBesAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserDevisVentes() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormDevisVentes var1 = new FormDevisVentes();
      var1.setBaseLog(this.baseLog);
      var1.setStructureLog(this.structureLog);
      var1.setUsersLog(this.usersLog);
      var1.setutilInitHibernate(this.utilInitHibernate);
      LireLesoptionsVentes var2 = new LireLesoptionsVentes();
      var2.setStrId(this.structureLog.getStrid());
      new DevisEnteteVentes();
      DevisEnteteVentesDao var4 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      DevisEnteteVentes var3 = var4.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var3 != null) {
         if (var3.getDvsModeleImp() == null || var3.getDvsModeleImp().isEmpty()) {
            var3.setDvsModeleImp(this.calculeEtatDefaut(21, ""));
         }

         if (var3.getDvsModeleImp() != null && !var3.getDvsModeleImp().isEmpty()) {
            var1.setDevisEnteteVentes(var3);
            var1.setTiers(var3.getTiers());
            var1.setOptionsVentes(var2.lancer());
            var1.setUtilNombre(this.utilNombre);
            DevisLigneVentesDao var5 = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var6 = var5.chargerLesLignes(var3, (Session)null);
            if (var6.size() != 0) {
               var1.setLesLignesList(var6);
               var1.majDateImpression(var3.getDvsModeleImp(), "PDF");
               this.utilPrint.setjRBeanCollectionDataSource(var1.calculeImpressionCommun());
               this.montant_lettre = this.utilNombre.begin(var3.getDvsTotTtc() + var3.getDvsTotTc(), var3.getDvsDevise());
               this.utilPrint.setRapport(var3.getDvsModeleImp());
               this.utilPrint.setEntete("Impression devis");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               if ((this.utilPrint.getPageGarde() == null || this.utilPrint.getPageGarde().isEmpty()) && (this.utilPrint.getAnnexe1() == null || this.utilPrint.getAnnexe1().isEmpty()) && (this.utilPrint.getAnnexe2() == null || this.utilPrint.getAnnexe2().isEmpty())) {
                  this.utilPrint.setRapport(var3.getDvsModeleImp());
                  this.utilPrint.setRapportEncapsule((String)null);
               } else {
                  this.utilPrint.setRapport("pageGarde");
                  this.utilPrint.setRapportEncapsule(var3.getDvsModeleImp());
               }

               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 21));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var3.getDvsEtat()));
               this.utilPrint.setDuplicata("true");
               if (!var3.getDvsDevise().equals("XOF") && !var3.getDvsDevise().equals("XAF")) {
                  if (var3.getDvsDevise().equals("EUR")) {
                     this.utilPrint.setNbCar(1);
                  } else {
                     this.utilPrint.setNbCar(0);
                  }
               } else {
                  this.utilPrint.setNbCar(2);
               }

               this.utilPrint.setTaux(1.0F);
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var3.getDvsIdResponsable());
               this.utilPrint.setTiersSelectionne(var3.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var3.getDvsId());
               if (var3.getDvsAnal2() != null && !var3.getDvsAnal2().isEmpty()) {
                  String var7 = "";
                  if (var3.getDvsAnal2().contains(":")) {
                     String[] var8 = var3.getDvsAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var3.getDvsAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserCommandeVentes() throws IOException, SAXException, JDOMException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormCommandeVentes var1 = new FormCommandeVentes();
      new CommandeEnteteVentes();
      CommandeEnteteVentesDao var3 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      CommandeEnteteVentes var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getBcmModeleImp() == null || var2.getBcmModeleImp().isEmpty()) {
            var2.setBcmModeleImp(this.calculeEtatDefaut(22, ""));
         }

         if (var2.getBcmModeleImp() != null && !var2.getBcmModeleImp().isEmpty()) {
            CommandeLigneVentesDao var4 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getBcmTotTtc() + var2.getBcmTotTc(), var2.getBcmDevise());
               this.utilPrint.setRapport(var2.getBcmModeleImp());
               this.utilPrint.setEntete("Impression commande");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 22));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getBcmEtat()));
               this.utilPrint.setDuplicata("true");
               if (!var2.getBcmDevise().equals("XOF") && !var2.getBcmDevise().equals("XAF")) {
                  if (var2.getBcmDevise().equals("EUR")) {
                     this.utilPrint.setNbCar(1);
                  } else {
                     this.utilPrint.setNbCar(0);
                  }
               } else {
                  this.utilPrint.setNbCar(2);
               }

               this.utilPrint.setTaux(1.0F);
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getBcmIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getBcmId());
               if (var2.getBcmAnal2() != null && !var2.getBcmAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getBcmAnal2().contains(":")) {
                     String[] var8 = var2.getBcmAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getBcmAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserLivraisonVentes() throws IOException, SAXException, JDOMException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormLivraisonVentes var1 = new FormLivraisonVentes();
      new LivraisonEnteteVentes();
      LivraisonEnteteVentesDao var3 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      LivraisonEnteteVentes var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getBlvModeleImp() == null || var2.getBlvModeleImp().isEmpty()) {
            var2.setBlvModeleImp(this.calculeEtatDefaut(23, ""));
         }

         if (var2.getBlvModeleImp() != null && !var2.getBlvModeleImp().isEmpty()) {
            LivraisonLigneVentesDao var4 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getBlvTotTtc() + var2.getBlvTotTc(), var2.getBlvDevise());
               this.utilPrint.setRapport(var2.getBlvModeleImp());
               this.utilPrint.setEntete("Impression BL");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 23));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getBlvEtat()));
               this.utilPrint.setDuplicata("true");
               if (!var2.getBlvDevise().equals("XOF") && !var2.getBlvDevise().equals("XAF")) {
                  if (var2.getBlvDevise().equals("EUR")) {
                     this.utilPrint.setNbCar(1);
                  } else {
                     this.utilPrint.setNbCar(0);
                  }
               } else {
                  this.utilPrint.setNbCar(2);
               }

               this.utilPrint.setTaux(1.0F);
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getBlvIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getBlvId());
               if (var2.getBlvAnal2() != null && !var2.getBlvAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getBlvAnal2().contains(":")) {
                     String[] var8 = var2.getBlvAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getBlvAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserRetourVentes() throws IOException, SAXException, JDOMException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormRetourVentes var1 = new FormRetourVentes();
      new RetourEnteteVentes();
      RetourEnteteVentesDao var3 = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      RetourEnteteVentes var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getBrtModeleImp() == null || var2.getBrtModeleImp().isEmpty()) {
            var2.setBrtModeleImp(this.calculeEtatDefaut(24, ""));
         }

         if (var2.getBrtModeleImp() != null && !var2.getBrtModeleImp().isEmpty()) {
            RetourLigneVentesDao var4 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getBrtTotTtc() + var2.getBrtTotTc(), var2.getBrtDevise());
               this.utilPrint.setRapport(var2.getBrtModeleImp());
               this.utilPrint.setEntete("Impression Retour");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 24));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getBrtEtat()));
               this.utilPrint.setDuplicata("true");
               if (!var2.getBrtDevise().equals("XOF") && !var2.getBrtDevise().equals("XAF")) {
                  if (var2.getBrtDevise().equals("EUR")) {
                     this.utilPrint.setNbCar(1);
                  } else {
                     this.utilPrint.setNbCar(0);
                  }
               } else {
                  this.utilPrint.setNbCar(2);
               }

               this.utilPrint.setTaux(1.0F);
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getBrtIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getBrtId());
               if (var2.getBrtAnal2() != null && !var2.getBrtAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getBrtAnal2().contains(":")) {
                     String[] var8 = var2.getBrtAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getBrtAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserFactureVentes() throws IOException, SAXException, JDOMException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormFactureVentes var1 = new FormFactureVentes();
      new FactureEnteteVentes();
      FactureEnteteVentesDao var3 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      FactureEnteteVentes var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getFacModeleImp() == null || var2.getFacModeleImp().isEmpty()) {
            var2.setFacModeleImp(this.calculeEtatDefaut(25, ""));
         }

         if (var2.getFacModeleImp() != null && !var2.getFacModeleImp().isEmpty()) {
            FactureLigneVentesDao var4 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getFacTotTtc() + var2.getFacTotTc(), var2.getFacDevise());
               this.utilPrint.setRapport(var2.getFacModeleImp());
               this.utilPrint.setEntete("Impression facture");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 25));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getFacEtat()));
               this.utilPrint.setDuplicata("true");
               if (!var2.getFacDevise().equals("XOF") && !var2.getFacDevise().equals("XAF")) {
                  if (var2.getFacDevise().equals("EUR")) {
                     this.utilPrint.setNbCar(1);
                  } else {
                     this.utilPrint.setNbCar(0);
                  }
               } else {
                  this.utilPrint.setNbCar(2);
               }

               this.utilPrint.setTaux(1.0F);
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getFacIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getFacId());
               if (var2.getFacAnal2() != null && !var2.getFacAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getFacAnal2().contains(":")) {
                     String[] var8 = var2.getFacAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getFacAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserAvoirVentes() throws IOException, SAXException, JDOMException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormAvoirVentes var1 = new FormAvoirVentes();
      new AvoirEnteteVentes();
      AvoirEnteteVentesDao var3 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      AvoirEnteteVentes var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getAvrModeleImp() == null || var2.getAvrModeleImp().isEmpty()) {
            var2.setAvrModeleImp(this.calculeEtatDefaut(26, ""));
         }

         if (var2.getAvrModeleImp() != null && !var2.getAvrModeleImp().isEmpty()) {
            AvoirLigneVentesDao var4 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getAvrTotTtc() + var2.getAvrTotTc(), var2.getAvrDevise());
               this.utilPrint.setRapport(var2.getAvrModeleImp());
               this.utilPrint.setEntete("Impression avoir");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 26));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getAvrEtat()));
               this.utilPrint.setDuplicata("true");
               if (!var2.getAvrDevise().equals("XOF") && !var2.getAvrDevise().equals("XAF")) {
                  if (var2.getAvrDevise().equals("EUR")) {
                     this.utilPrint.setNbCar(1);
                  } else {
                     this.utilPrint.setNbCar(0);
                  }
               } else {
                  this.utilPrint.setNbCar(2);
               }

               this.utilPrint.setTaux(1.0F);
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getAvrIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getAvrId());
               if (var2.getAvrAnal2() != null && !var2.getAvrAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getAvrAnal2().contains(":")) {
                     String[] var8 = var2.getAvrAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getAvrAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserNoteDebitVentes() throws IOException, SAXException, JDOMException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormNoteDebitVentes var1 = new FormNoteDebitVentes();
      new NoteDebitEnteteVentes();
      NoteDebitEnteteVentesDao var3 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      NoteDebitEnteteVentes var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getNdbModeleImp() == null || var2.getNdbModeleImp().isEmpty()) {
            var2.setNdbModeleImp(this.calculeEtatDefaut(27, ""));
         }

         if (var2.getNdbModeleImp() != null && !var2.getNdbModeleImp().isEmpty()) {
            NoteDebitLigneVentesDao var4 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getNdbTotTtc() + var2.getNdbTotTc(), var2.getNdbDevise());
               this.utilPrint.setRapport(var2.getNdbModeleImp());
               this.utilPrint.setEntete("Impression note de débit");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 27));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getNdbEtat()));
               this.utilPrint.setDuplicata("true");
               if (!var2.getNdbDevise().equals("XOF") && !var2.getNdbDevise().equals("XAF")) {
                  if (var2.getNdbDevise().equals("EUR")) {
                     this.utilPrint.setNbCar(1);
                  } else {
                     this.utilPrint.setNbCar(0);
                  }
               } else {
                  this.utilPrint.setNbCar(2);
               }

               this.utilPrint.setTaux(1.0F);
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getNdbIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getNdbId());
               if (var2.getNdbAnal2() != null && !var2.getNdbAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getNdbAnal2().contains(":")) {
                     String[] var8 = var2.getNdbAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getNdbAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserContratVentes() throws IOException, SAXException, JDOMException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormContratVentes var1 = new FormContratVentes();
      new ContratEnteteVentes();
      ContratEnteteVentesDao var3 = new ContratEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      ContratEnteteVentes var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getCrtModeleImp() == null || var2.getCrtModeleImp().isEmpty()) {
            var2.setCrtModeleImp(this.calculeEtatDefaut(140, ""));
         }

         if (var2.getCrtModeleImp() != null && !var2.getCrtModeleImp().isEmpty()) {
            ContratLigneVentesDao var4 = new ContratLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getCrtTotTtc() + var2.getCrtTotTc(), var2.getCrtDevise());
               this.utilPrint.setRapport(var2.getCrtModeleImp());
               this.utilPrint.setEntete("Impression contrat vente");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setPageGarde("");
               this.utilPrint.setAnnexe1("");
               this.utilPrint.setAnnexe2("");
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getCrtEtat()));
               this.utilPrint.setDuplicata("true");
               if (!var2.getCrtDevise().equals("XOF") && !var2.getCrtDevise().equals("XAF")) {
                  if (var2.getCrtDevise().equals("EUR")) {
                     this.utilPrint.setNbCar(1);
                  } else {
                     this.utilPrint.setNbCar(0);
                  }
               } else {
                  this.utilPrint.setNbCar(2);
               }

               this.utilPrint.setTaux(1.0F);
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getCrtIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getCrtId());
               if (var2.getCrtAnal2() != null && !var2.getCrtAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getCrtAnal2().contains(":")) {
                     String[] var8 = var2.getCrtAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getCrtAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserFactureInterneVentes() throws IOException, SAXException, JDOMException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormFactureInterneVentes var1 = new FormFactureInterneVentes();
      new FactureInterneEnteteVentes();
      FactureInterneEnteteVentesDao var3 = new FactureInterneEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      FactureInterneEnteteVentes var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null) {
         if (var2.getFitModeleImp() == null || var2.getFitModeleImp().isEmpty()) {
            var2.setFitModeleImp(this.calculeEtatDefaut(142, ""));
         }

         if (var2.getFitModeleImp() != null && !var2.getFitModeleImp().isEmpty()) {
            FactureInterneLigneVentesDao var4 = new FactureInterneLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               this.montant_lettre = this.utilNombre.begin(var2.getFitTotTtc() + var2.getFitTotTc(), var2.getFitDevise());
               this.utilPrint.setRapport(var2.getFitModeleImp());
               this.utilPrint.setEntete("Impression facture interne");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 142));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), var2.getFitEtat()));
               this.utilPrint.setDuplicata("true");
               if (!var2.getFitDevise().equals("XOF") && !var2.getFitDevise().equals("XAF")) {
                  if (var2.getFitDevise().equals("EUR")) {
                     this.utilPrint.setNbCar(1);
                  } else {
                     this.utilPrint.setNbCar(0);
                  }
               } else {
                  this.utilPrint.setNbCar(2);
               }

               this.utilPrint.setTaux(1.0F);
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdResponsable(var2.getFitIdResponsable());
               this.utilPrint.setTiersSelectionne(var2.getTiers());
               this.utilPrint.setNature(this.parapheur.getPhrNature());
               this.utilPrint.setId_doc(var2.getFitId());
               if (var2.getFitAnal2() != null && !var2.getFitAnal2().isEmpty()) {
                  String var7 = "";
                  if (var2.getFitAnal2().contains(":")) {
                     String[] var8 = var2.getFitAnal2().split(":");
                     var7 = var8[0];
                  } else {
                     var7 = var2.getFitAnal2();
                  }

                  new Parc();
                  ParcDao var9 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var10 = var9.rechercheParc(var7, (Session)null);
                  if (var10 != null) {
                     this.utilPrint.setParc(var10);
                  } else {
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  this.utilPrint.setParc((Parc)null);
               }

               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visualiserBonSortieCaisse() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormBonSortieCaiss var1 = new FormBonSortieCaiss();
      new BonSortieCaiss();
      BonSortieCaissDao var3 = new BonSortieCaissDao(this.baseLog, this.utilInitHibernate);
      BonSortieCaiss var2 = var3.selectById(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null && var2.getSortModeleImp() != null && !var2.getSortModeleImp().isEmpty()) {
         ArrayList var4 = new ArrayList();
         var4.add(var2);
         JRBeanCollectionDataSource var5 = new JRBeanCollectionDataSource(var4);
         this.utilPrint.setjRBeanCollectionDataSource(var5);
         this.montant_lettre = this.utilNombre.begin(var2.getSortMontant(), var2.getSortDevise());
         this.utilPrint.setRapport(var2.getSortModeleImp());
         this.utilPrint.setEntete("Impression du bon de sortie");
         this.utilPrint.setMontant_lettre(this.montant_lettre);
         String var6 = "";
         if (var2.getSortTypeReg() != 0 && var2.getSortTypeReg() != 11) {
            if (var2.getSortTypeReg() != 1 && var2.getSortTypeReg() != 10) {
               if (var2.getSortTypeReg() == 2) {
                  var6 = "virements";
               } else if (var2.getSortTypeReg() == 3) {
                  var6 = "traites";
               } else if (var2.getSortTypeReg() == 4) {
                  var6 = "cartes";
               } else if (var2.getSortTypeReg() == 5) {
                  var6 = "transferts";
               } else if (var2.getSortTypeReg() == 6) {
                  var6 = "epaiements";
               } else if (var2.getSortTypeReg() == 7) {
                  var6 = "credocs";
               } else if (var2.getSortTypeReg() == 8) {
                  var6 = "factors";
               } else if (var2.getSortTypeReg() == 9) {
                  var6 = "compenses";
               } else if (var2.getSortTypeReg() == 12) {
                  var6 = "lettres_garantie";
               } else if (var2.getSortTypeReg() == 13) {
                  var6 = "prelevements";
               } else if (var2.getSortTypeReg() == 14) {
                  var6 = "alcoins";
               } else {
                  var6 = "";
               }
            } else {
               var6 = "cheques";
            }
         } else {
            var6 = "especes";
         }

         this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), var6));
         this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setIdResponsable(var2.getSortUserCreat());
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(this.parapheur.getPhrNature());
         this.utilPrint.setId_doc(var2.getSortId());
         this.utilPrint.imprimeRapport();
      }

   }

   public void visualiserVirementCaisse() throws IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      FormVirementInterne var1 = new FormVirementInterne();
      new VirementInterne();
      VirementInterneDao var3 = new VirementInterneDao(this.baseLog, this.utilInitHibernate);
      VirementInterne var2 = var3.selectById(this.parapheur.getPhrDocId(), (Session)null);
      if (var2 != null && var2.getVirModeleImp() != null && !var2.getVirModeleImp().isEmpty()) {
         ArrayList var4 = new ArrayList();
         var4.add(var2);
         JRBeanCollectionDataSource var5 = new JRBeanCollectionDataSource(var4);
         this.utilPrint.setjRBeanCollectionDataSource(var5);
         this.montant_lettre = this.utilNombre.begin(var2.getVirMontant(), var2.getVirDevise());
         this.utilPrint.setRapport(var2.getVirModeleImp());
         this.utilPrint.setEntete("Impression du virement");
         this.utilPrint.setMontant_lettre(this.montant_lettre);
         String var6 = "";
         if (var2.getVirTypeReg() != 0 && var2.getVirTypeReg() != 11) {
            if (var2.getVirTypeReg() != 1 && var2.getVirTypeReg() != 10) {
               if (var2.getVirTypeReg() == 2) {
                  var6 = "virements";
               } else if (var2.getVirTypeReg() == 3) {
                  var6 = "traites";
               } else if (var2.getVirTypeReg() == 4) {
                  var6 = "cartes";
               } else if (var2.getVirTypeReg() == 5) {
                  var6 = "transferts";
               } else if (var2.getVirTypeReg() == 6) {
                  var6 = "epaiements";
               } else if (var2.getVirTypeReg() == 7) {
                  var6 = "credocs";
               } else if (var2.getVirTypeReg() == 8) {
                  var6 = "factors";
               } else if (var2.getVirTypeReg() == 9) {
                  var6 = "compenses";
               } else if (var2.getVirTypeReg() == 12) {
                  var6 = "lettres_garantie";
               } else if (var2.getVirTypeReg() == 13) {
                  var6 = "prelevements";
               } else if (var2.getVirTypeReg() == 14) {
                  var6 = "alcoins";
               } else {
                  var6 = "";
               }
            } else {
               var6 = "cheques";
            }
         } else {
            var6 = "especes";
         }

         this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), var6));
         this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setIdResponsable(var2.getVirUserCreat());
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(this.parapheur.getPhrNature());
         this.utilPrint.setId_doc(var2.getVirId());
         this.utilPrint.setjRBeanCollectionDataSource(var1.calculeImpressionCommun());
         this.utilPrint.imprimeRapport();
      }

   }

   public void visualiserContrat() throws IOException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      this.documentEntete = new DocumentEntete();
      new SalariesContrats();
      SalariesContratsDao var3 = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      SalariesContrats var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), var1);
      if (var2 != null) {
         this.documentEntete.setDocNum(var2.getSalconNum());
         this.documentEntete.setDocNomResponsable(var2.getSalconNomRepresentant());
         this.documentEntete.setDocService(var2.getSalconService());
         this.documentEntete.setDocSite(var2.getSalconSite());
         this.documentEntete.setDocNomContact(var2.getSalaries().getSalMatricule());
         this.documentEntete.setDocNomTiers(var2.getSalaries().getSalNom() + " " + var2.getSalaries().getSalPrenom());
         this.documentEntete.setDocConditionReg(var2.getLib_nature());
         this.documentEntete.setDocObject(var2.getSalconLibConvention() + " " + var2.getSalconGrille());
         this.documentEntete.setDocDateEcheReg(var2.getSalconDateDebut());
         this.documentEntete.setDocActivite(var2.getSalconActivite());
         this.documentEntete.setDocBudget(var2.getSalconBudget());
         this.documentEntete.setDocAnal2(var2.getSalconParc());
         this.documentEntete.setDocNumDocument(var2.getSalconTexte());
      }

      this.utilInitHibernate.closeSession();
   }

   public void visualiserDocumentRh() throws IOException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      this.documentEntete = new DocumentEntete();
      new SalariesGrh();
      SalariesGrhDao var3 = new SalariesGrhDao(this.baseLog, this.utilInitHibernate);
      SalariesGrh var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), var1);
      if (var2 != null) {
         this.documentEntete.setDocNum(var2.getSalgrhNum());
         this.documentEntete.setDocNomResponsable(var2.getSalgrhResponsable());
         this.documentEntete.setDocService(var2.getSalgrhService());
         this.documentEntete.setDocNomContact(var2.getSalaries().getSalMatricule());
         this.documentEntete.setDocNomTiers(var2.getSalaries().getSalNom() + " " + var2.getSalaries().getSalPrenom());
         this.documentEntete.setDocConditionReg(var2.getLib_nature());
         this.documentEntete.setDocObject(var2.getSalgrhObjet());
         this.documentEntete.setDocDateEcheReg(var2.getSalgrhDate());
         this.documentEntete.setDocActivite(var2.getSalgrhActivite());
         this.documentEntete.setDocNumDocument(var2.getSalgrhTexte());
      }

      this.utilInitHibernate.closeSession();
   }

   public void visualiserPret() throws IOException, HibernateException, NamingException, JDOMException {
      LectureNaturePrets var1 = new LectureNaturePrets();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      List var2 = var1.chargerMesNaturesPretsItems();
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      this.documentEntete = new DocumentEntete();
      new SalariesPrets(var2);
      SalariesPretsDao var5 = new SalariesPretsDao(this.baseLog, this.utilInitHibernate);
      SalariesPrets var4 = var5.pourParapheur(this.parapheur.getPhrDocId(), var3);
      if (var4 != null) {
         new ArrayList();
         SalariesPretsLignesDao var7 = new SalariesPretsLignesDao(this.baseLog, this.utilInitHibernate);
         List var6 = var7.chargerlesPretsLignes(var4, var3);
         this.stockList = new ArrayList();
         this.datamodelStock = new ListDataModel();
         if (var6.size() > 0) {
            for(int var8 = 0; var8 < var6.size(); ++var8) {
               this.stock = new Stock();
               this.stock.setStkFamille("" + ((SalariesPretsLignes)var6.get(var8)).getSalpreligDateTheo());
               this.stock.setStkTtc(((SalariesPretsLignes)var6.get(var8)).getSalpreligMontantTheo());
               this.stock.setStkLibelle("" + ((SalariesPretsLignes)var6.get(var8)).getSalpreligDateReel());
               this.stock.setStkTva(((SalariesPretsLignes)var6.get(var8)).getSalpreligMontantReel());
               this.stock.setStkReference(((SalariesPretsLignes)var6.get(var8)).getSalpreligReference());
               this.stock.setStk_code_produit(((SalariesPretsLignes)var6.get(var8)).getSalpreligCaisse());
               this.stock.setStkUnite("" + ((SalariesPretsLignes)var6.get(var8)).getSalpreligDatePaiement());
               this.stockList.add(this.stock);
            }
         }

         this.datamodelStock.setWrappedData(this.stockList);
         this.documentEntete.setDocNum(var4.getSalpreNum());
         this.documentEntete.setDocNomResponsable(var4.getSalpreResponsable());
         this.documentEntete.setDocService(var4.getSalpreService());
         this.documentEntete.setDocNomContact(var4.getSalaries().getSalMatricule());
         this.documentEntete.setDocNomTiers(var4.getSalaries().getSalNom() + " " + var4.getSalaries().getSalPrenom());
         this.documentEntete.setDocTotTtc(var4.getSalpreMontant());
         this.documentEntete.setDocTypeReg(var4.getSalpreEcheance());
         this.documentEntete.setDocConditionReg(var4.getLib_nature());
         this.documentEntete.setDocObject(var4.getSalpreObjet());
         this.documentEntete.setDocDateEcheReg(var4.getSalpreDateDebut());
      }

      this.utilInitHibernate.closeSession();
   }

   public void visualiserConges() throws IOException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      this.documentEntete = new DocumentEntete();
      new SalariesConges();
      SalariesCongesDao var3 = new SalariesCongesDao(this.baseLog, this.utilInitHibernate);
      SalariesConges var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), var1);
      if (var2 != null) {
         this.documentEntete.setDocNomResponsable(var2.getSalcngResponsable());
         this.documentEntete.setDocService(var2.getSalcngLieu());
         this.documentEntete.setDocNomContact(var2.getSalaries().getSalMatricule());
         this.documentEntete.setDocNomTiers(var2.getSalaries().getSalNom() + " " + var2.getSalaries().getSalPrenom());
         this.documentEntete.setDocConditionReg(var2.getLib_nature());
         this.documentEntete.setDocObject(var2.getSalcngObjet());
         this.documentEntete.setDocDateEcheReg(var2.getSalcngDateDebut());
         this.documentEntete.setDocDateRelance(var2.getSalcngDateFin());
      }

      this.utilInitHibernate.closeSession();
   }

   public void visualiserAbsences() throws IOException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      this.documentEntete = new DocumentEntete();
      new SalariesConges();
      SalariesCongesDao var3 = new SalariesCongesDao(this.baseLog, this.utilInitHibernate);
      SalariesConges var2 = var3.pourParapheur(this.parapheur.getPhrDocId(), var1);
      if (var2 != null) {
         this.documentEntete.setDocNomResponsable(var2.getSalcngResponsable());
         this.documentEntete.setDocNomContact(var2.getSalaries().getSalMatricule());
         this.documentEntete.setDocNomTiers(var2.getSalaries().getSalNom() + " " + var2.getSalaries().getSalPrenom());
         this.documentEntete.setDocConditionReg(var2.getLib_nature());
         this.documentEntete.setDocObject(var2.getSalcngObjet());
         this.documentEntete.setDocDateEcheReg(var2.getSalcngDateDebut());
         this.documentEntete.setDocDateRelance(var2.getSalcngDateFin());
      }

      this.utilInitHibernate.closeSession();
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public DataModel getDatamodelParapheur() {
      return this.datamodelParapheur;
   }

   public void setDatamodelParapheur(DataModel var1) {
      this.datamodelParapheur = var1;
   }

   public int getEtatRqt() {
      return this.etatRqt;
   }

   public void setEtatRqt(int var1) {
      this.etatRqt = var1;
   }

   public Parapheur getParapheur() {
      return this.parapheur;
   }

   public void setParapheur(Parapheur var1) {
      this.parapheur = var1;
   }

   public boolean isShowModalPanelVisualisation() {
      return this.showModalPanelVisualisation;
   }

   public void setShowModalPanelVisualisation(boolean var1) {
      this.showModalPanelVisualisation = var1;
   }

   public boolean isVerifValidite() {
      return this.verifValidite;
   }

   public void setVerifValidite(boolean var1) {
      this.verifValidite = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public DocumentEntete getDocumentEntete() {
      return this.documentEntete;
   }

   public void setDocumentEntete(DocumentEntete var1) {
      this.documentEntete = var1;
   }

   public Stock getStock() {
      return this.stock;
   }

   public void setStock(Stock var1) {
      this.stock = var1;
   }

   public String getMontant_lettre() {
      return this.montant_lettre;
   }

   public void setMontant_lettre(String var1) {
      this.montant_lettre = var1;
   }

   public String getLibelledevis() {
      return this.libelledevis;
   }

   public void setLibelledevis(String var1) {
      this.libelledevis = var1;
   }

   public double getSolde() {
      return this.solde;
   }

   public void setSolde(double var1) {
      this.solde = var1;
   }

   public boolean isHtTtc() {
      return this.htTtc;
   }

   public void setHtTtc(boolean var1) {
      this.htTtc = var1;
   }

   public List getStockList() {
      return this.stockList;
   }

   public void setStockList(List var1) {
      this.stockList = var1;
   }

   public List getMesFamillesClients() {
      return this.mesFamillesClients;
   }

   public void setMesFamillesClients(List var1) {
      this.mesFamillesClients = var1;
   }

   public List getMesExoTvaClients() {
      return this.mesExoTvaClients;
   }

   public void setMesExoTvaClients(List var1) {
      this.mesExoTvaClients = var1;
   }

   public String getAffichageTotttc() {
      return this.affichageTotttc;
   }

   public void setAffichageTotttc(String var1) {
      this.affichageTotttc = var1;
   }

   public DataModel getDatamodelStock() {
      return this.datamodelStock;
   }

   public void setDatamodelStock(DataModel var1) {
      this.datamodelStock = var1;
   }

   public String getAffActivite() {
      return this.affActivite;
   }

   public void setAffActivite(String var1) {
      this.affActivite = var1;
   }

   public String getAffAnal2() {
      return this.affAnal2;
   }

   public void setAffAnal2(String var1) {
      this.affAnal2 = var1;
   }

   public String getAffAnal4() {
      return this.affAnal4;
   }

   public void setAffAnal4(String var1) {
      this.affAnal4 = var1;
   }

   public String getAffBudget() {
      return this.affBudget;
   }

   public void setAffBudget(String var1) {
      this.affBudget = var1;
   }

   public String getAffPdv() {
      return this.affPdv;
   }

   public void setAffPdv(String var1) {
      this.affPdv = var1;
   }

   public String getAffDepartement() {
      return this.affDepartement;
   }

   public void setAffDepartement(String var1) {
      this.affDepartement = var1;
   }

   public String getAffRegion() {
      return this.affRegion;
   }

   public void setAffRegion(String var1) {
      this.affRegion = var1;
   }

   public String getAffSecteur() {
      return this.affSecteur;
   }

   public void setAffSecteur(String var1) {
      this.affSecteur = var1;
   }

   public String getAffService() {
      return this.affService;
   }

   public void setAffService(String var1) {
      this.affService = var1;
   }

   public String getAffSite() {
      return this.affSite;
   }

   public void setAffSite(String var1) {
      this.affSite = var1;
   }

   public String getArreteSomme() {
      return this.arreteSomme;
   }

   public void setArreteSomme(String var1) {
      this.arreteSomme = var1;
   }

   public List getLesUsers() {
      return this.lesUsers;
   }

   public void setLesUsers(List var1) {
      this.lesUsers = var1;
   }

   public List getMesUsersIndisponiblesItems() {
      return this.mesUsersIndisponiblesItems;
   }

   public void setMesUsersIndisponiblesItems(List var1) {
      this.mesUsersIndisponiblesItems = var1;
   }

   public boolean isShowModalPanelIndisponibilite() {
      return this.showModalPanelIndisponibilite;
   }

   public void setShowModalPanelIndisponibilite(boolean var1) {
      this.showModalPanelIndisponibilite = var1;
   }

   public boolean isAbsent() {
      return this.absent;
   }

   public void setAbsent(boolean var1) {
      this.absent = var1;
   }

   public boolean isPresent() {
      return this.present;
   }

   public void setPresent(boolean var1) {
      this.present = var1;
   }

   public boolean isVerifieDateIndispo() {
      return this.verifieDateIndispo;
   }

   public void setVerifieDateIndispo(boolean var1) {
      this.verifieDateIndispo = var1;
   }

   public String getNoter() {
      return this.noter;
   }

   public void setNoter(String var1) {
      this.noter = var1;
   }

   public boolean isShowModalPanelNotation() {
      return this.showModalPanelNotation;
   }

   public void setShowModalPanelNotation(boolean var1) {
      this.showModalPanelNotation = var1;
   }

   public int getVar_etat() {
      return this.var_etat;
   }

   public void setVar_etat(int var1) {
      this.var_etat = var1;
   }

   public String getVar_statut() {
      return this.var_statut;
   }

   public void setVar_statut(String var1) {
      this.var_statut = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public int getNumeroEncCours() {
      return this.numeroEncCours;
   }

   public void setNumeroEncCours(int var1) {
      this.numeroEncCours = var1;
   }

   public boolean isShowModalPanelReponse() {
      return this.showModalPanelReponse;
   }

   public void setShowModalPanelReponse(boolean var1) {
      this.showModalPanelReponse = var1;
   }

   public Date getDateDebut() {
      return this.dateDebut;
   }

   public void setDateDebut(Date var1) {
      this.dateDebut = var1;
   }

   public Date getDateFin() {
      return this.dateFin;
   }

   public void setDateFin(Date var1) {
      this.dateFin = var1;
   }

   public boolean isVar_col01() {
      return this.var_col01;
   }

   public void setVar_col01(boolean var1) {
      this.var_col01 = var1;
   }

   public boolean isVar_col02() {
      return this.var_col02;
   }

   public void setVar_col02(boolean var1) {
      this.var_col02 = var1;
   }

   public boolean isVar_col03() {
      return this.var_col03;
   }

   public void setVar_col03(boolean var1) {
      this.var_col03 = var1;
   }

   public boolean isVar_col04() {
      return this.var_col04;
   }

   public void setVar_col04(boolean var1) {
      this.var_col04 = var1;
   }

   public boolean isVar_col05() {
      return this.var_col05;
   }

   public void setVar_col05(boolean var1) {
      this.var_col05 = var1;
   }

   public boolean isVar_col06() {
      return this.var_col06;
   }

   public void setVar_col06(boolean var1) {
      this.var_col06 = var1;
   }

   public boolean isVar_col07() {
      return this.var_col07;
   }

   public void setVar_col07(boolean var1) {
      this.var_col07 = var1;
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
}
