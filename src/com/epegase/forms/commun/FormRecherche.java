package com.epegase.forms.commun;

import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienTravauxEntete;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.Devise;
import com.epegase.systeme.classe.Eleves;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.PlansTresorerie;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.Racines;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.SommierEnteteAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Taches;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.ValorisationEnteteAchats;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.BienDao;
import com.epegase.systeme.dao.BienTravauxEnteteDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.ElevesDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PatientsDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PlansTresorerieDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.RacinesDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.SalariesContratsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SommierEnteteAchatsDao;
import com.epegase.systeme.dao.TachesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.ValorisationEnteteAchatsDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.xml.LectureAppreciations;
import com.epegase.systeme.xml.LectureCategorieTiers;
import com.epegase.systeme.xml.LectureCivilites;
import com.epegase.systeme.xml.LectureConfigListeEntete;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.LectureFamillesClients;
import com.epegase.systeme.xml.LectureLangues;
import com.epegase.systeme.xml.LectureMessageVocalUser;
import com.epegase.systeme.xml.LectureNatureCompte;
import com.epegase.systeme.xml.LecturePays;
import com.epegase.systeme.xml.ObjetDevises;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetMessageVocalUser;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionConfigListe;
import com.epegase.systeme.xml.OptionMedical;
import com.epegase.systeme.xml.OptionParcs;
import com.epegase.systeme.xml.OptionVentes;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;
import org.springframework.context.annotation.Scope;

@Scope("Request")
public class FormRecherche implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int nature;
   private UIDataTable extDTable;
   private SimpleSelection simpleSelection;
   private boolean showModalPanelMessage = false;
   private String messageTexte;
   private Tiers tiers;
   private transient DataModel datamodelTiers;
   private TiersDao tiersDao;
   private boolean selectTiers = false;
   private boolean var_typeTiers;
   private boolean showModalPanelAjoutTiers = false;
   private int typeTiers;
   private List mesCategoriesItems;
   private boolean var_tiersDivers = false;
   private String genre;
   private Patients patients;
   private transient DataModel datamodelPatients;
   private PatientsDao patientsDao;
   private boolean selectPatients = false;
   private boolean var_typePatients;
   private Eleves eleves;
   private transient DataModel datamodelEleves;
   private ElevesDao elevesDao;
   private boolean selectEleves = false;
   private boolean var_typeEleves;
   private PlansAnalytiques plansAnalytiques;
   private transient DataModel datamodelDestinataire;
   private PlansAnalytiquesDao plansAnalytiquesDao;
   private boolean selectDestinataire = false;
   private Users responsable;
   private transient DataModel datamodelResponsable;
   private UserDao usersDao;
   private boolean selectResponsable = false;
   private Contacts contacts;
   private List lesContacts;
   private transient DataModel datamodelContact;
   private ContactDao contactDao;
   private List mesCivilitesItems;
   private List mesLangueItems;
   private List mesPaysItems;
   private List mesAppreciationsItems;
   private boolean showModalPanelContact = false;
   private Produits produits;
   private Produits produitsDuppliquer;
   private List lesProduits;
   private transient DataModel datamodelProduits;
   private ProduitsAchsDao produitsAchsDao;
   private ProduitsVtesDao produitsVtesDao;
   private boolean selectProduits = false;
   private boolean showModalPanelDupProduit = false;
   private String urlphotoProd;
   private String urlIpProd;
   private boolean produitExiste = false;
   private String var_tarif1;
   private String var_tarif2;
   private String var_tarif3;
   private String var_tarif4;
   private String var_tarif5;
   private boolean var_aff_tarif1;
   private boolean var_aff_tarif2;
   private boolean var_aff_tarif3;
   private boolean var_aff_tarif4;
   private boolean var_aff_tarif5;
   private ProduitsTarif produitsTarif;
   private ProduitsTarifDao produitsTarifDao;
   private ProduitsDepotDao produitsDepotDao;
   private List lesFamilleClientsListe;
   private OptionVentes optionVentes;
   private OptionMedical optionMedical;
   private boolean verouxCod = false;
   private boolean existCod = false;
   private PlansAnalytiques dossier;
   private List lesDossiers;
   private transient DataModel datamodelDossier;
   private boolean selectDossier = false;
   private boolean showModalPanelAddDossier = false;
   private String annee;
   private Date dateDossier;
   private boolean dossierExiste = false;
   private ExercicesAchats exercicesAchats;
   private String serie;
   private List mesdevisesItem;
   private String devise;
   private boolean selectChantier = false;
   private Activites activite;
   private List lesActivites;
   private transient DataModel datamodelActivites;
   private boolean selectActivites = false;
   private ActivitesDao activitesDao;
   private OptionParcs optionParcs;
   private Parc parc;
   private ParcDao parcDao;
   private List lesParcs;
   private transient DataModel datamodelParc;
   private boolean selectParc = false;
   private PlanComptable planComptable;
   private PlanComptableDao planComptableDao;
   private List lesPlanComptable;
   private transient DataModel datamodelPlanComptable;
   private boolean selectPlanComptable = false;
   private List mesNatureCompteItem;
   private int nombrCaracter;
   private List mesRacineCompteItem;
   private boolean showModalPanelCreationCompte = false;
   private String maNature;
   private String maRacine;
   private int nbcarmax;
   private String racinecle;
   private boolean existeCopteDeja;
   private String partieCompte;
   private ExercicesComptable exercicesComptable;
   private OptionComptabilite optionComptabilite;
   private Salaries salaries;
   private transient DataModel datamodelSalaries;
   private SalariesDao salariesDao;
   private boolean selectSalaries = false;
   private boolean var_typeSalaries;
   private SalariesContrats salariesContrats;
   private transient DataModel datamodelSalariesContrats;
   private SalariesContratsDao salariesContratsDao;
   private boolean selectSalariesContrat = false;
   private boolean var_typeSalariesContrat;
   private Reglements reglements;
   private ReglementsDao reglementsDao;
   private List lesReglements;
   private transient DataModel datamodelReglements;
   private boolean selectReglements = false;
   private PlansTresorerie plansTresorerie;
   private PlansTresorerieDao plansTresorerieDao;
   private List lesBudgetTresorerie;
   private transient DataModel datamodelBudgetTresorerie;
   private boolean selectBudgetTresorerie = false;
   private boolean projetPresent = false;
   private SommierEnteteAchats sommierEnteteAchats;
   private SommierEnteteAchatsDao sommierEnteteAchatsDao;
   private List lesSommiers;
   private transient DataModel datamodelSommiers;
   private boolean selectSommier = false;
   private Bien bien;
   private BienDao bienDao;
   private List lesBiens;
   private transient DataModel datamodelBiens;
   private boolean selectBien = false;
   private BienTravauxEntete bienTravauxEntete;
   private BienTravauxEnteteDao bienTravauxEnteteDao;
   private List lesTravauxImmobilier;
   private transient DataModel datamodelTravauxImmobilier;
   private boolean selectTravauxImmobilier = false;
   private Taches taches;
   private TachesDao tachesDao;
   private List lesTaches;
   private transient DataModel datamodelTaches;
   private boolean selectTaches = false;
   private int choixRacine;
   private String selecFiscalite;
   private String configListeEntete;

   public FormRecherche(String var1, Structure var2, Users var3, UtilInitHibernate var4) {
      this.baseLog = var1;
      this.structureLog = var2;
      this.usersLog = var3;
      this.utilInitHibernate = var4;
      this.datamodelTiers = new ListDataModel();
      this.datamodelPatients = new ListDataModel();
      this.datamodelEleves = new ListDataModel();
      this.datamodelDestinataire = new ListDataModel();
      this.datamodelResponsable = new ListDataModel();
      this.datamodelProduits = new ListDataModel();
      this.datamodelDossier = new ListDataModel();
      this.datamodelParc = new ListDataModel();
      this.datamodelContact = new ListDataModel();
      this.datamodelPlanComptable = new ListDataModel();
      this.datamodelSalaries = new ListDataModel();
      this.datamodelSalariesContrats = new ListDataModel();
      this.datamodelReglements = new ListDataModel();
      this.datamodelBudgetTresorerie = new ListDataModel();
      this.datamodelSommiers = new ListDataModel();
      this.datamodelBiens = new ListDataModel();
      this.datamodelActivites = new ListDataModel();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelection = new SimpleSelection();
      this.mesCategoriesItems = new ArrayList();
      this.mesCivilitesItems = new ArrayList();
      this.mesPaysItems = new ArrayList();
   }

   public void recupererConfigListeEntete() throws IOException {
      LectureConfigListeEntete var1 = new LectureConfigListeEntete();
      var1.recupereFonctions(this.structureLog.getStrid(), this.nature, "");
      this.configListeEntete = var1.getConfigListeEntete();
   }

   public void memoriseConfigListeEntete() throws IOException {
      LectureConfigListeEntete var1 = new LectureConfigListeEntete();
      String var2 = var1.calculeFichierConfig(this.structureLog.getStrid(), this.nature, "");
      if (var2 != null && !var2.isEmpty()) {
         Element var3 = new Element("configuration");
         Document var4 = new Document(var3);
         var3.removeContent();
         OptionConfigListe var5 = new OptionConfigListe();
         var5.setConfiguration(this.configListeEntete);
         Element var6 = new Element("configListe");
         var3.addContent(var6);
         var6.setText(var5.getConfiguration());
         XMLOutputter var7 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var8 = new FileOutputStream(StaticModePegase.getCheminContext() + var2);
         var7.output(var4, var8);
         var8.close();
      }

   }

   public Tiers rechercheTiers(int var1, String var2, int var3) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var3;
      this.selectTiers = false;
      if (var2 != null && !var2.isEmpty()) {
         new ArrayList();
         String var5 = "";
         if (var1 == 0) {
            var5 = "(0)";
         } else if (var1 == 3) {
            var5 = "(1,2,3)";
         } else if (var1 == 9) {
            var5 = "(0,1,2,3)";
         }

         this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
         List var4 = this.tiersDao.verifTiers(this.usersLog, var5, var2, (Session)null);
         if (var4.size() == 1) {
            this.tiers = (Tiers)var4.get(0);
            this.calculeTypeTiers();
         } else if (var4.size() > 1) {
            this.datamodelTiers.setWrappedData(var4);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.tiers = new Tiers();
         } else {
            this.tiers = this.annuleTiers();
         }
      } else {
         this.tiers = this.annuleTiers();
      }

      return this.tiers;
   }

   public Tiers rechercheTiers(int var1, String var2, int var3, String var4) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var3;
      this.selectTiers = false;
      if (var2 != null && !var2.isEmpty()) {
         Object var5 = new ArrayList();
         String var6 = "";
         this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
         if (var1 == 0) {
            var6 = "(0)";
            if (var4 != null && !var4.isEmpty()) {
               var5 = this.tiersDao.chargeTierFournissseurCategorie(this.usersLog, var6, var2, var4, (Session)null);
            } else {
               var5 = this.tiersDao.verifTiers(this.usersLog, var6, var2, (Session)null);
            }
         } else if (var1 == 3) {
            var6 = "(2,3)";
            if (var4 != null && !var4.isEmpty()) {
               var5 = this.tiersDao.chargeTierClientCategorie(this.usersLog, var6, var2, var4, (Session)null);
            } else {
               var5 = this.tiersDao.verifTiers(this.usersLog, var6, var2, (Session)null);
            }
         }

         if (((List)var5).size() == 1) {
            this.tiers = (Tiers)((List)var5).get(0);
            this.calculeTypeTiers();
         } else if (((List)var5).size() > 1) {
            this.datamodelTiers.setWrappedData(var5);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.tiers = new Tiers();
         } else {
            this.tiers = this.annuleTiers();
         }
      } else {
         this.tiers = this.annuleTiers();
      }

      return this.tiers;
   }

   public Tiers rechercheTiers(String var1, Date var2) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.selectTiers = false;
      if (var1 != null && !var1.isEmpty()) {
         this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
         this.tiers = this.tiersDao.chargerTiersByCompte(var1);
         if (this.tiers != null) {
            this.calculDateEchéance(var2);
         } else {
            this.tiers = this.annuleTiers();
         }
      } else {
         this.tiers = this.annuleTiers();
      }

      return this.tiers;
   }

   public Tiers rechercheTiersTreso(int var1, String var2, int var3) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.nature = var3;
      this.selectTiers = false;
      if (var2 != null && !var2.isEmpty()) {
         Object var4 = new ArrayList();
         String var5 = "";
         if (var1 == 0) {
            var5 = "(2,3)";
            this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
            var4 = this.tiersDao.verifTiers(this.usersLog, var5, var2, (Session)null);
         } else if (var1 == 1) {
            var5 = "(0)";
            this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
            var4 = this.tiersDao.verifTiers(this.usersLog, var5, var2, (Session)null);
         } else {
            List var8;
            int var9;
            Tiers var10;
            if (var1 == 2) {
               new ExercicesPaye();
               ExercicesPayeDao var16 = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
               ExercicesPaye var14 = var16.recupererLastExo((Session)null);
               if (var14 != null) {
                  this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
                  new ArrayList();
                  var8 = this.salariesDao.chargerlesSalariesActif(var2, (Session)null);
                  if (var8.size() != 0) {
                     for(var9 = 0; var9 < var8.size(); ++var9) {
                        var10 = new Tiers();
                        Salaries var20 = (Salaries)var8.get(var9);
                        var10.setTieid(var20.getSalId());
                        var10.setTiecategorie("Salarié");
                        var10.setTiecompte0("");
                        var10.setTieraisonsocialenom(var20.getSalNom());
                        var10.setTieprenom(var20.getSalPrenom());
                        var10.setTiecivilite(var20.getSalCivilite());
                        ((List)var4).add(var10);
                     }
                  }
               }
            } else if (var1 == 3) {
               ExercicesComptableDao var13 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
               new ExercicesComptable();
               ExercicesComptable var15 = var13.recupererLastExo((Session)null);
               if (var15 != null) {
                  new ArrayList();
                  this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
                  this.selecFiscalite = this.structureLog.getStrzonefiscale();
                  if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
                     long var17 = (long)(var15.getExecptDateDebut().getYear() + 1900);
                     long var18 = (long)(var15.getExecptDateFin().getYear() + 1900);
                     if (this.structureLog.getStrdatefiscale2() != null && var17 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var18 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
                        this.selecFiscalite = this.structureLog.getStrzonefiscale2();
                     } else if (this.structureLog.getStrdatefiscale2() != null && var17 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var18 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
                        this.selecFiscalite = this.structureLog.getStrzonefiscale();
                     } else {
                        this.selecFiscalite = null;
                     }
                  }

                  var8 = this.planComptableDao.chargerListPlanByListNat(this.selecFiscalite, (Session)null, var15, "", var2);
                  if (var8.size() > 0) {
                     for(var9 = 0; var9 < var8.size(); ++var9) {
                        var10 = new Tiers();
                        PlanComptable var19 = (PlanComptable)var8.get(var9);
                        var10.setTieid(0L);
                        var10.setTiecategorie("Plan comptable");
                        var10.setTiecompte0(var19.getPlcCompte());
                        var10.setTieraisonsocialenom(var19.getPlcLibelleCpteFR());
                        var10.setTieprenom("");
                        var10.setTiecivilite("");
                        ((List)var4).add(var10);
                     }
                  }
               }
            } else if (var1 == 4) {
               new ExercicesVentes();
               ExercicesVentesDao var7 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
               ExercicesVentes var6 = var7.recupererLastExo((Session)null);
               if (var6 != null) {
                  new ArrayList();
                  this.patientsDao = new PatientsDao(this.baseLog, this.utilInitHibernate);
                  var8 = this.patientsDao.chargerlesPatients(var2, (Session)null);
                  if (var8.size() != 0) {
                     for(var9 = 0; var9 < var8.size(); ++var9) {
                        var10 = new Tiers();
                        Patients var11 = (Patients)var8.get(var9);
                        var10.setTieid(var11.getPatId());
                        var10.setTiecategorie("Patient");
                        var10.setTiecompte0("");
                        var10.setTieraisonsocialenom(var11.getPatNom());
                        var10.setTieprenom(var11.getPatPrenom());
                        var10.setTiecivilite(var11.getPatCivilite());
                        ((List)var4).add(var10);
                     }
                  }
               }
            } else if (var1 == 5) {
            }
         }

         if (((List)var4).size() == 1) {
            this.datamodelTiers.setWrappedData(var4);
            this.extDTable = new HtmlExtendedDataTable();
            if (this.simpleSelection == null) {
               this.simpleSelection = new SimpleSelection();
            }

            this.simpleSelection.clear();
            this.tiers = new Tiers();
         } else if (((List)var4).size() > 1) {
            this.datamodelTiers.setWrappedData(var4);
            this.extDTable = new HtmlExtendedDataTable();
            if (this.simpleSelection == null) {
               this.simpleSelection = new SimpleSelection();
            }

            this.simpleSelection.clear();
            this.tiers = new Tiers();
         } else {
            this.tiers = this.annuleTiers();
         }
      } else {
         this.tiers = this.annuleTiers();
      }

      return this.tiers;
   }

   public void rechercheTiers(Tiers var1, int var2) {
      this.nature = var2;
      this.tiers = var1;
      this.calculeTypeTiers();
   }

   public void selectionligneTiers() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.tiers = (Tiers)var1.get(0);
            this.calculeTypeTiers();
            this.selectTiers = true;
         } else {
            this.selectTiers = false;
         }
      } else {
         this.selectTiers = false;
      }

   }

   public void calculeTypeTiers() {
      if (this.tiers != null) {
         if (this.tiers.getTiegenre() == null || this.tiers.getTiegenre().isEmpty() || !this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037") && !this.tiers.getTiegenre().equalsIgnoreCase("070") && !this.tiers.getTiegenre().equalsIgnoreCase("080")) {
            this.var_typeTiers = true;
         } else {
            this.var_typeTiers = false;
         }
      } else {
         this.var_typeTiers = true;
      }

   }

   public Tiers annuleTiers() {
      this.tiers = null;
      return this.tiers;
   }

   public Tiers calculeTiers() {
      this.calculeTypeTiers();
      return this.tiers;
   }

   public Date calculDateEchéance(Date var1) throws NamingException, ParseException {
      Date var2 = new Date();
      if (this.tiers != null) {
         int var3 = this.tiers.getTietypereg();
         int var4 = this.tiers.getTienbecheance();
         int var5 = this.tiers.getTienbarrondi();
         UtilDate var6 = new UtilDate();
         var2 = var6.CalculDateEcheance(var1, var3, var4, var5);
      }

      return var2;
   }

   public void ajoutTiers() throws IOException {
      this.tiers = new Tiers();
      this.tiers.setTiecodepays(this.structureLog.getStrcodepays());
      this.tiers.setTienompays(this.structureLog.getStrnompays());
      this.typeTiers = 0;
      this.calculCategorieTiers();
   }

   public void calculCategorieTiers() throws IOException {
      this.genre = "";
      LecturePays var1 = new LecturePays();
      this.mesPaysItems = var1.getMesPaysItems();
      if (this.typeTiers == 0) {
         LectureCivilites var2 = new LectureCivilites(0);
         this.mesCivilitesItems = var2.getMesCivilitesItems();
         LectureCategorieTiers var3;
         if (this.nature >= 10 && this.nature <= 19) {
            this.genre = "000";
            var3 = new LectureCategorieTiers(this.genre);
            this.mesCategoriesItems = var3.getMesCategoriesTiersItems();
         } else {
            if (this.rechercheModule(816)) {
               this.genre = "070";
            } else {
               this.genre = "030";
            }

            var3 = new LectureCategorieTiers(this.genre);
            this.mesCategoriesItems = var3.getMesCategoriesTiersItems();
         }
      } else {
         this.mesCivilitesItems.clear();
         this.mesCivilitesItems.add(new SelectItem(""));
         LectureCategorieTiers var4;
         if (this.nature >= 10 && this.nature <= 19) {
            this.genre = "001";
            var4 = new LectureCategorieTiers(this.genre);
            this.mesCategoriesItems = var4.getMesCategoriesTiersItems();
         } else {
            if (this.rechercheModule(816)) {
               this.genre = "071";
            } else {
               this.genre = "031";
            }

            var4 = new LectureCategorieTiers(this.genre);
            this.mesCategoriesItems = var4.getMesCategoriesTiersItems();
         }
      }

      this.showModalPanelAjoutTiers = true;
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
         if (var5.startsWith((String)var3.get(var4))) {
            var2 = true;
         }
      }

      return var2;
   }

   public void calculeGenre() {
      if (this.tiers.getTiecivilite() != null && !this.tiers.getTiecivilite().isEmpty()) {
         if (this.tiers.getTiecivilite() == null || this.tiers.getTiecivilite().isEmpty() || !this.tiers.getTiecivilite().equals("Madame") && !this.tiers.getTiecivilite().equals("Mademoiselle")) {
            this.tiers.setTiesexe(1);
         } else {
            this.tiers.setTiesexe(0);
         }
      } else {
         this.tiers.setTiesexe(1);
         this.tiers.setTiecivilite("");
      }

   }

   public void calculTiersdivers() {
      if (this.tiers.getTiecategorie() == null || this.tiers.getTiecategorie().isEmpty() || !this.tiers.getTiecategorie().equalsIgnoreCase("Client Divers") && !this.tiers.getTiecategorie().equalsIgnoreCase("Demandeur Divers") && !this.tiers.getTiecategorie().equalsIgnoreCase("Fournisseur Divers")) {
         this.var_tiersDivers = false;
      } else {
         this.var_tiersDivers = true;
      }

   }

   public void annuleAjoutTiers() {
      this.showModalPanelAjoutTiers = false;
   }

   public void valideAjoutTiers() throws HibernateException, NamingException {
      if (this.tiers != null) {
         this.tiers.setTiedatecreat(new Date());
         this.tiers.setTieusercreat(this.usersLog.getUsrid());
         this.tiers.setPointDeVente((PointDeVente)null);
         this.tiers.setRegion((Region)null);
         this.tiers.setSecteur((Secteur)null);
         this.tiers.setTiegenre(this.genre);
         if (this.genre.equals("001") || this.genre.equals("071") || this.genre.equals("031")) {
            this.tiers.setTiecivilite((String)null);
         }

         if (this.nature >= 10 && this.nature <= 19) {
            this.tiers.setTietype("0");
         } else {
            this.tiers.setTietype("3");
         }

         this.tiers = this.tiersDao.insert(this.tiers);
         ArrayList var1 = new ArrayList();
         var1.add(this.tiers);
         this.datamodelTiers.setWrappedData(var1);
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelection = new SimpleSelection();
         this.simpleSelection.clear();
         this.tiers = new Tiers();
      }

      this.showModalPanelAjoutTiers = false;
   }

   public PlansAnalytiques rechercheDestinataire(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectDestinataire = false;
      if (var1 != null && !var1.isEmpty()) {
         new ArrayList();
         this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         List var3 = this.plansAnalytiquesDao.selectAnal("7", var1, "", this.nature, (Session)null);
         if (var3.size() == 1) {
            this.plansAnalytiques = (PlansAnalytiques)var3.get(0);
         } else if (var3.size() > 1) {
            this.datamodelDestinataire.setWrappedData(var3);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.plansAnalytiques = new PlansAnalytiques();
         } else {
            this.plansAnalytiques = this.annuleDestinataire();
         }
      } else {
         this.plansAnalytiques = this.annuleDestinataire();
      }

      return this.plansAnalytiques;
   }

   public void selectionDestinataire() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.plansAnalytiques = (PlansAnalytiques)var1.get(0);
            this.selectDestinataire = true;
         } else {
            this.selectDestinataire = false;
         }
      } else {
         this.selectDestinataire = false;
      }

   }

   public PlansAnalytiques annuleDestinataire() {
      this.plansAnalytiques = null;
      return this.plansAnalytiques;
   }

   public PlansAnalytiques calculeDestinataire() throws JDOMException, IOException {
      return this.plansAnalytiques;
   }

   public PlansAnalytiques rechercheDestinataire(PlansAnalytiques var1, PlansAnalytiquesDao var2, String var3, Session var4) throws HibernateException, NamingException {
      if (var3 != null && !var3.isEmpty()) {
         if (var2 == null) {
            var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         }

         var1 = var2.rechercheDestinataire(var3, var4);
      } else {
         var1 = null;
      }

      return var1;
   }

   public Users rechercheResponsable(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      String var3 = "";
      if (this.nature >= 1 && this.nature <= 6) {
         var3 = "Office";
      } else if (this.nature == 7) {
         var3 = "***";
      } else if (this.nature >= 50 && this.nature <= 59) {
         var3 = "Compta";
      } else if (this.nature >= 80 && this.nature <= 89) {
         var3 = "Paye";
      } else if ((this.nature < 10 || this.nature > 19) && (this.nature < 30 || this.nature > 39)) {
         if ((this.nature < 20 || this.nature > 29) && this.nature != 8) {
            if (this.nature >= 40 && this.nature <= 49) {
               var3 = "Parc";
            } else if (this.nature >= 60 && this.nature <= 69) {
               var3 = "Caisse";
            } else if (this.nature >= 70 && this.nature <= 79) {
               var3 = "Medical";
            }
         } else {
            var3 = "Ventes";
         }
      } else {
         var3 = "Achats";
      }

      this.selectResponsable = false;
      if (var1 != null && !var1.isEmpty()) {
         new ArrayList();
         this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
         List var4 = this.usersDao.verifResponsable(var1, var3, (Session)null);
         if (var4.size() == 1) {
            this.responsable = (Users)var4.get(0);
            this.calculeResponsable();
         } else if (var4.size() > 1) {
            this.datamodelResponsable.setWrappedData(var4);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.responsable = new Users();
         } else {
            this.responsable = this.annuleResponsable();
         }
      } else {
         this.responsable = this.annuleResponsable();
      }

      return this.responsable;
   }

   public void selectionResponsable() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.responsable = (Users)var1.get(0);
            this.selectResponsable = true;
         } else {
            this.selectResponsable = false;
         }
      } else {
         this.selectResponsable = false;
      }

   }

   public Users annuleResponsable() {
      this.responsable = null;
      return this.responsable;
   }

   public Users calculeResponsable() throws JDOMException, IOException {
      return this.responsable;
   }

   public Users rechercheCommercial(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectResponsable = false;
      if (var1 != null && !var1.isEmpty()) {
         new ArrayList();
         this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
         List var3 = this.usersDao.verifCommercial(var1, (Session)null);
         if (var3.size() == 1) {
            this.responsable = (Users)var3.get(0);
            this.calculeResponsable();
         } else if (var3.size() > 1) {
            this.datamodelResponsable.setWrappedData(var3);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.responsable = new Users();
         } else {
            this.responsable = this.annuleCommercial();
         }
      } else {
         this.responsable = this.annuleCommercial();
      }

      return this.responsable;
   }

   public void selectionCommercial() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.responsable = (Users)var1.get(0);
            this.selectResponsable = true;
         } else {
            this.selectResponsable = false;
         }
      } else {
         this.selectResponsable = false;
      }

   }

   public Users annuleCommercial() {
      this.responsable = null;
      return this.responsable;
   }

   public Users calculeCommercial() throws JDOMException, IOException {
      return this.responsable;
   }

   public Users rechercheUtilisateur(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectResponsable = false;
      if (var1 != null && !var1.isEmpty()) {
         new ArrayList();
         this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
         List var3 = this.usersDao.chargerUserActif(var1, (Session)null);
         if (var3.size() == 1) {
            this.responsable = (Users)var3.get(0);
            this.calculeUtilisateur();
         } else if (var3.size() > 1) {
            this.datamodelResponsable.setWrappedData(var3);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.responsable = new Users();
         } else {
            this.responsable = this.annuleUtilisateur();
         }
      } else {
         this.responsable = this.annuleUtilisateur();
      }

      return this.responsable;
   }

   public void selectionUtilisateur() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.responsable = (Users)var1.get(0);
            this.selectResponsable = true;
         } else {
            this.selectResponsable = false;
         }
      } else {
         this.selectResponsable = false;
      }

   }

   public Users annuleUtilisateur() {
      this.responsable = null;
      return this.responsable;
   }

   public Users calculeUtilisateur() throws JDOMException, IOException {
      return this.responsable;
   }

   public Contacts rechercheContacts(Tiers var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.tiers = var1;
      if (this.tiers != null) {
         this.recupererCivilitesItem();
         this.recupererLangueItem();
         this.recupererPaysItem();
         this.recupererAppreciationItem();
         this.lesContacts = new ArrayList();
         this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
         this.lesContacts = this.contactDao.listContactByTiers(this.tiers, (Session)null);
         this.datamodelContact.setWrappedData(this.lesContacts);
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelection = new SimpleSelection();
         this.simpleSelection.clear();
         this.contacts = new Contacts();
      } else {
         this.contacts = null;
      }

      return this.contacts;
   }

   public Contacts rechercheContacts(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectResponsable = false;
      if (var1 != null && !var1.isEmpty()) {
         this.lesContacts = new ArrayList();
         this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
         this.lesContacts = this.contactDao.listContactByNom(var1, (Session)null);
         this.datamodelContact.setWrappedData(this.lesContacts);
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelection = new SimpleSelection();
         this.simpleSelection.clear();
         this.contacts = new Contacts();
      } else {
         this.contacts = null;
      }

      return this.contacts;
   }

   public Contacts calculeContacts() {
      return this.contacts;
   }

   public void selectionContact() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.contacts = (Contacts)var1.get(0);
            this.selectResponsable = true;
         } else {
            this.selectResponsable = false;
         }
      } else {
         this.selectResponsable = false;
      }

   }

   public void ajouterContact() {
      this.contacts = new Contacts();
      this.contacts.setConnompays(this.tiers.getTienompays());
      this.showModalPanelContact = true;
   }

   public void modifierContact() {
      if (this.contacts != null) {
         this.showModalPanelContact = true;
      }

   }

   public void supprimerContact() throws HibernateException, NamingException {
      if (this.contacts != null) {
         this.lesContacts.remove(this.contacts);
         this.datamodelContact.setWrappedData(this.lesContacts);
         this.contactDao.delete(this.contacts);
         this.contacts = new Contacts();
      }

   }

   public void annulerContact() {
      this.showModalPanelContact = false;
   }

   public void validerContact() throws HibernateException, NamingException {
      String var1 = "";
      if (this.contacts.getCondatenaissance() != null) {
         DateFormat var2 = DateFormat.getDateInstance(3);
         var1 = var2.format(this.contacts.getCondatenaissance()).substring(0, 5);
      }

      this.contacts.setConanniversaire(var1);
      if (this.contacts.getConprenom() != null && !this.contacts.getConprenom().isEmpty()) {
         this.contacts.setConpatronyme(this.contacts.getConnom() + " " + this.contacts.getConprenom());
      } else {
         this.contacts.setConpatronyme(this.contacts.getConnom());
      }

      if (this.contacts.getConid() == 0L) {
         this.contacts.setTiers(this.tiers);
         this.contacts.setCondatecreat(new Date());
         this.contacts.setConusercreat(this.usersLog.getUsrid());
         this.contacts = this.contactDao.insert(this.contacts);
         this.lesContacts.clear();
         this.lesContacts.add(this.contacts);
         this.datamodelContact.setWrappedData(this.lesContacts);
      } else {
         this.contacts.setCondatemodif(new Date());
         this.contacts.setConusermodif(this.usersLog.getUsrid());
         this.contacts = this.contactDao.modif(this.contacts);
      }

      this.showModalPanelContact = false;
   }

   public Contacts annuleContacproduitsTarift() {
      this.contacts = null;
      return this.contacts;
   }

   public List calculeContactItems() throws JDOMException, IOException {
      ArrayList var1 = new ArrayList();
      if (this.lesContacts.size() != 0) {
         for(int var2 = 0; var2 < this.lesContacts.size(); ++var2) {
            Contacts var3 = (Contacts)this.lesContacts.get(var2);
            if (var3.getConpatronyme() != null && !var3.getConpatronyme().isEmpty()) {
               var1.add(new SelectItem(var3.getConid(), var3.getConpatronyme()));
            } else if (var3.getConservice() != null && !var3.getConservice().isEmpty()) {
               var1.add(new SelectItem(var3.getConid(), var3.getConservice()));
            }
         }
      }

      return var1;
   }

   public void recupererCivilitesItem() throws IOException {
      this.mesCivilitesItems = new ArrayList();
      LectureCivilites var1 = new LectureCivilites(0);
      this.mesCivilitesItems = var1.getMesCivilitesItems();
   }

   public void recupererLangueItem() throws IOException {
      this.mesLangueItems = new ArrayList();
      LectureLangues var1 = new LectureLangues();
      this.mesLangueItems = var1.getMesLanguesItems();
   }

   public void recupererPaysItem() throws IOException {
      this.mesPaysItems = new ArrayList();
      LecturePays var1 = new LecturePays();
      this.mesPaysItems = var1.getMesPaysItems();
   }

   public void recupererAppreciationItem() throws IOException {
      this.mesAppreciationsItems = new ArrayList();
      LectureAppreciations var1 = new LectureAppreciations();
      this.mesAppreciationsItems = var1.getMesAppreciationItems();
   }

   public Produits rechercheProduitAchat(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectProduits = false;
      this.showModalPanelDupProduit = false;
      this.lesProduits = new ArrayList();
      if (var1 != null && !var1.isEmpty()) {
         this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         this.lesProduits = this.produitsAchsDao.verifProduits(var1, (Session)null);
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.calculeProduit();
         } else if (this.lesProduits.size() > 1) {
            this.recupererConfigListeEntete();
            this.datamodelProduits.setWrappedData(this.lesProduits);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.produits = new Produits();
         } else {
            this.produits = this.annuleProduit();
         }
      } else {
         this.produits = this.annuleProduit();
      }

      return this.produits;
   }

   public Produits rechercheProduitAchat(String var1, String var2, String var3, int var4) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var4;
      this.selectProduits = false;
      this.showModalPanelDupProduit = false;
      this.lesProduits = new ArrayList();
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
      if (var2 != null && !var2.isEmpty() && var1 != null && !var1.isEmpty()) {
         String var6 = "";
         if (var1.contains(":")) {
            String[] var7 = var1.split(":");
            var6 = var7[0];
         } else {
            var6 = var1;
         }

         new DepotAchats();
         DepotAchatsDao var8 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         DepotAchats var12 = var8.trouveDepot(var6, var5);
         if (var12 != null) {
            new ArrayList();
            this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
            List var9 = this.produitsDepotDao.selectProdDepByDepAchs(var2, var3, var12, var5);
            if (var9.size() == 1) {
               this.produits = ((ProduitsDepot)var9.get(0)).getProduits();
               if (this.produits.getProStock() != 0 && this.produits.getProMode() != 5) {
                  this.calculeProduit();
               }
            } else if (var9.size() > 1) {
               for(int var10 = 0; var10 < var9.size(); ++var10) {
                  new ProduitsDepot();
                  ProduitsDepot var11 = (ProduitsDepot)var9.get(var10);
                  if (var11.getProduits().getProStock() != 0 && var11.getProduits().getProMode() != 5) {
                     this.lesProduits.add(var11.getProduits());
                  }
               }

               this.recupererConfigListeEntete();
               this.datamodelProduits.setWrappedData(this.lesProduits);
               this.extDTable = new HtmlExtendedDataTable();
               this.simpleSelection = new SimpleSelection();
               this.simpleSelection.clear();
               this.produits = new Produits();
            } else {
               this.produits = this.annuleProduit();
            }
         } else {
            this.produits = this.annuleProduit();
         }
      } else {
         this.produits = this.annuleProduit();
      }

      this.utilInitHibernate.closeSession();
      return this.produits;
   }

   public Produits rechercheProduitFraisAchat(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectProduits = false;
      this.showModalPanelDupProduit = false;
      this.lesProduits = new ArrayList();
      if (var1 != null && !var1.isEmpty()) {
         this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         this.lesProduits = this.produitsAchsDao.verifProduitsFrais(var1, (Session)null);
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.calculeProduit();
         } else if (this.lesProduits.size() > 1) {
            this.recupererConfigListeEntete();
            this.datamodelProduits.setWrappedData(this.lesProduits);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.produits = new Produits();
         } else {
            this.produits = this.annuleProduit();
         }
      } else {
         this.produits = this.annuleProduit();
      }

      return this.produits;
   }

   public Produits rechercheProduitFraisVentes(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectProduits = false;
      this.showModalPanelDupProduit = false;
      this.lesProduits = new ArrayList();
      if (var1 != null && !var1.isEmpty()) {
         this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         this.lesProduits = this.produitsVtesDao.verifProduitsFrais(var1, (Session)null);
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.calculeProduit();
         } else if (this.lesProduits.size() > 1) {
            this.recupererConfigListeEntete();
            this.datamodelProduits.setWrappedData(this.lesProduits);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.produits = new Produits();
         } else {
            this.produits = this.annuleProduit();
         }
      } else {
         this.produits = this.annuleProduit();
      }

      return this.produits;
   }

   public void recupererFamillesClientItem() throws JDOMException, IOException {
      LectureFamillesClients var1 = new LectureFamillesClients();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesFamillesClientItems();
      this.lesFamilleClientsListe = var1.getMesFamillesClients();
      this.var_tarif1 = "";
      this.var_tarif2 = "";
      this.var_tarif3 = "";
      this.var_tarif4 = "";
      this.var_tarif5 = "";
      this.var_aff_tarif1 = false;
      this.var_aff_tarif2 = false;
      this.var_aff_tarif3 = false;
      this.var_aff_tarif4 = false;
      this.var_aff_tarif5 = false;

      for(int var2 = 0; var2 < this.lesFamilleClientsListe.size(); ++var2) {
         if (var2 == 0) {
            this.var_tarif1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(0)).getLibelle();
            this.var_aff_tarif1 = true;
         } else if (var2 == 1) {
            this.var_tarif2 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(1)).getLibelle();
            this.var_aff_tarif2 = true;
         } else if (var2 == 2) {
            this.var_tarif3 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(2)).getLibelle();
            this.var_aff_tarif3 = true;
         } else if (var2 == 3) {
            this.var_tarif4 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(3)).getLibelle();
            this.var_aff_tarif4 = true;
         } else if (var2 == 4) {
            this.var_tarif5 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(4)).getLibelle();
            this.var_aff_tarif5 = true;
         }
      }

   }

   public Produits rechercheProduitVente(String var1, int var2, OptionVentes var3) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectProduits = false;
      this.optionVentes = var3;
      this.showModalPanelDupProduit = false;
      this.lesProduits = new ArrayList();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      if (var1 != null && !var1.isEmpty()) {
         this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         this.lesProduits = this.produitsVtesDao.verifProduits(var1, var4);
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.calculeProduit();
         } else if (this.lesProduits.size() > 1) {
            if (this.lesProduits.size() != 0) {
               this.recupererFamillesClientItem();
               UtilNombre var5 = new UtilNombre();
               new ArrayList();
               this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
               this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
               int var7 = 0;

               while(true) {
                  float var8;
                  float var9;
                  float var10;
                  int var11;
                  if (var7 >= this.lesProduits.size()) {
                     if (this.produits.getProStock() == 0) {
                        break;
                     }

                     new ArrayList();
                     this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
                     List var13 = this.produitsDepotDao.selectProdDepByprod(this.produits, var4);
                     if (var13.size() == 0) {
                        this.produits.setProQteCmdClient(0.0F);
                        this.produits.setProQteCmdFournisseur(0.0F);
                        this.produits.setProQteStock(0.0F);
                        break;
                     }

                     var8 = 0.0F;
                     var9 = 0.0F;
                     var10 = 0.0F;

                     for(var11 = 0; var11 < var13.size(); ++var11) {
                        var8 += ((ProduitsDepot)var13.get(var11)).getProdepQteCmdVte();
                        var9 += ((ProduitsDepot)var13.get(var11)).getProdepQteCmdAch();
                        var10 += ((ProduitsDepot)var13.get(var11)).getProdepQteStk();
                     }

                     this.produits.setProQteCmdClient(var8);
                     this.produits.setProQteCmdFournisseur(var9);
                     this.produits.setProQteStock(var10);
                     break;
                  }

                  this.produits = new Produits();
                  this.produits = (Produits)this.lesProduits.get(var7);
                  var8 = 0.0F;
                  var9 = 0.0F;
                  var10 = 0.0F;
                  List var6 = this.produitsDepotDao.selectProdDepByprod(this.produits, var4);
                  if (var6.size() != 0) {
                     for(var11 = 0; var11 < var6.size(); ++var11) {
                        var8 += ((ProduitsDepot)var6.get(var11)).getProdepQteCmdVte();
                        var9 += ((ProduitsDepot)var6.get(var11)).getProdepQteCmdAch();
                        var10 += ((ProduitsDepot)var6.get(var11)).getProdepQteStk();
                     }
                  }

                  this.produits.setProQteCmdClient(var8);
                  this.produits.setProQteCmdFournisseur(var9);
                  this.produits.setProQteStock(var10);
                  double var14;
                  if (this.var_aff_tarif1 && this.var_tarif1 != null && !this.var_tarif1.isEmpty()) {
                     this.produitsTarif = new ProduitsTarif();
                     this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif1, var4);
                     if (this.produitsTarif != null) {
                        var14 = 0.0D;
                        if (!this.produitsTarif.isProtarExoTva()) {
                           var14 = var5.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                           this.produits.setPv1(var14);
                        } else {
                           var14 = this.produitsTarif.getProtarPv();
                           this.produits.setPv1(var14);
                        }
                     }
                  }

                  if (this.var_aff_tarif2 && this.var_tarif2 != null && !this.var_tarif2.isEmpty()) {
                     this.produitsTarif = new ProduitsTarif();
                     this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif2, var4);
                     if (this.produitsTarif != null) {
                        var14 = 0.0D;
                        if (!this.produitsTarif.isProtarExoTva()) {
                           var14 = var5.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                           this.produits.setPv2(var14);
                        } else {
                           var14 = this.produitsTarif.getProtarPv();
                           this.produits.setPv2(var14);
                        }
                     }
                  }

                  if (this.var_aff_tarif3 && this.var_tarif3 != null && !this.var_tarif3.isEmpty()) {
                     this.produitsTarif = new ProduitsTarif();
                     this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif3, var4);
                     if (this.produitsTarif != null) {
                        var14 = 0.0D;
                        if (!this.produitsTarif.isProtarExoTva()) {
                           var14 = var5.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                           this.produits.setPv3(var14);
                        } else {
                           var14 = this.produitsTarif.getProtarPv();
                           this.produits.setPv3(var14);
                        }
                     }
                  }

                  if (this.var_aff_tarif4 && this.var_tarif4 != null && !this.var_tarif4.isEmpty()) {
                     this.produitsTarif = new ProduitsTarif();
                     this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif4, var4);
                     if (this.produitsTarif != null) {
                        var14 = 0.0D;
                        if (!this.produitsTarif.isProtarExoTva()) {
                           var14 = var5.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                           this.produits.setPv4(var14);
                        } else {
                           var14 = this.produitsTarif.getProtarPv();
                           this.produits.setPv4(var14);
                        }
                     }
                  }

                  if (this.var_aff_tarif5 && this.var_tarif5 != null && !this.var_tarif5.isEmpty()) {
                     this.produitsTarif = new ProduitsTarif();
                     this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif5, var4);
                     if (this.produitsTarif != null) {
                        var14 = 0.0D;
                        if (!this.produitsTarif.isProtarExoTva()) {
                           var14 = var5.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                           this.produits.setPv5(var14);
                        } else {
                           var14 = this.produitsTarif.getProtarPv();
                           this.produits.setPv4(var14);
                        }
                     }
                  }

                  ++var7;
               }
            }

            this.recupererConfigListeEntete();
            this.datamodelProduits.setWrappedData(this.lesProduits);
            this.extDTable = new HtmlExtendedDataTable();
            if (this.simpleSelection == null) {
               this.simpleSelection = new SimpleSelection();
            }

            this.simpleSelection.clear();
            this.produits = new Produits();
         } else {
            this.produits = this.annuleProduit();
         }
      } else {
         this.produits = this.annuleProduit();
      }

      this.utilInitHibernate.closeSession();
      return this.produits;
   }

   public Produits rechercheProduitTout(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectProduits = false;
      this.showModalPanelDupProduit = false;
      this.lesProduits = new ArrayList();
      if (var1 != null && !var1.isEmpty()) {
         this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         this.lesProduits = this.produitsAchsDao.chargerTousProduitsAchatsVentes(var1, (Session)null);
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.calculeProduit();
         } else if (this.lesProduits.size() > 1) {
            this.recupererConfigListeEntete();
            this.datamodelProduits.setWrappedData(this.lesProduits);
            this.extDTable = new HtmlExtendedDataTable();
            if (this.simpleSelection == null) {
               this.simpleSelection = new SimpleSelection();
            }

            this.simpleSelection.clear();
            this.produits = new Produits();
         } else {
            this.produits = this.annuleProduit();
         }
      } else {
         this.produits = this.annuleProduit();
      }

      return this.produits;
   }

   public Produits rechercheProduitMedical(String var1, int var2, OptionMedical var3) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectProduits = false;
      this.optionMedical = var3;
      this.showModalPanelDupProduit = false;
      this.lesProduits = new ArrayList();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      if (var1 != null && !var1.isEmpty()) {
         this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         this.lesProduits = this.produitsVtesDao.verifProduits(var1, var4);
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.calculeProduit();
         } else if (this.lesProduits.size() > 1) {
            if (this.lesProduits.size() != 0) {
               this.recupererFamillesClientItem();
               UtilNombre var5 = new UtilNombre();
               new ArrayList();
               this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
               this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
               int var7 = 0;

               while(true) {
                  float var8;
                  float var9;
                  float var10;
                  int var11;
                  if (var7 >= this.lesProduits.size()) {
                     if (this.produits.getProStock() == 0) {
                        break;
                     }

                     new ArrayList();
                     this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
                     List var13 = this.produitsDepotDao.selectProdDepByprod(this.produits, var4);
                     if (var13.size() == 0) {
                        this.produits.setProQteCmdClient(0.0F);
                        this.produits.setProQteCmdFournisseur(0.0F);
                        this.produits.setProQteStock(0.0F);
                        break;
                     }

                     var8 = 0.0F;
                     var9 = 0.0F;
                     var10 = 0.0F;

                     for(var11 = 0; var11 < var13.size(); ++var11) {
                        var8 += ((ProduitsDepot)var13.get(var11)).getProdepQteCmdVte();
                        var9 += ((ProduitsDepot)var13.get(var11)).getProdepQteCmdAch();
                        var10 += ((ProduitsDepot)var13.get(var11)).getProdepQteStk();
                     }

                     this.produits.setProQteCmdClient(var8);
                     this.produits.setProQteCmdFournisseur(var9);
                     this.produits.setProQteStock(var10);
                     break;
                  }

                  this.produits = new Produits();
                  this.produits = (Produits)this.lesProduits.get(var7);
                  var8 = 0.0F;
                  var9 = 0.0F;
                  var10 = 0.0F;
                  List var6 = this.produitsDepotDao.selectProdDepByprod(this.produits, var4);
                  if (var6.size() != 0) {
                     for(var11 = 0; var11 < var6.size(); ++var11) {
                        var8 += ((ProduitsDepot)var6.get(var11)).getProdepQteCmdVte();
                        var9 += ((ProduitsDepot)var6.get(var11)).getProdepQteCmdAch();
                        var10 += ((ProduitsDepot)var6.get(var11)).getProdepQteStk();
                     }
                  }

                  this.produits.setProQteCmdClient(var8);
                  this.produits.setProQteCmdFournisseur(var9);
                  this.produits.setProQteStock(var10);
                  double var14;
                  if (this.var_aff_tarif1 && this.var_tarif1 != null && !this.var_tarif1.isEmpty()) {
                     this.produitsTarif = new ProduitsTarif();
                     this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif1, var4);
                     if (this.produitsTarif != null) {
                        var14 = 0.0D;
                        if (!this.produitsTarif.isProtarExoTva()) {
                           var14 = var5.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                           this.produits.setPv1(var14);
                        } else {
                           var14 = this.produitsTarif.getProtarPv();
                           this.produits.setPv1(var14);
                        }
                     }
                  }

                  if (this.var_aff_tarif2 && this.var_tarif2 != null && !this.var_tarif2.isEmpty()) {
                     this.produitsTarif = new ProduitsTarif();
                     this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif2, var4);
                     if (this.produitsTarif != null) {
                        var14 = 0.0D;
                        if (!this.produitsTarif.isProtarExoTva()) {
                           var14 = var5.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                           this.produits.setPv2(var14);
                        } else {
                           var14 = this.produitsTarif.getProtarPv();
                           this.produits.setPv2(var14);
                        }
                     }
                  }

                  if (this.var_aff_tarif3 && this.var_tarif3 != null && !this.var_tarif3.isEmpty()) {
                     this.produitsTarif = new ProduitsTarif();
                     this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif3, var4);
                     if (this.produitsTarif != null) {
                        var14 = 0.0D;
                        if (!this.produitsTarif.isProtarExoTva()) {
                           var14 = var5.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                           this.produits.setPv3(var14);
                        } else {
                           var14 = this.produitsTarif.getProtarPv();
                           this.produits.setPv3(var14);
                        }
                     }
                  }

                  if (this.var_aff_tarif4 && this.var_tarif4 != null && !this.var_tarif4.isEmpty()) {
                     this.produitsTarif = new ProduitsTarif();
                     this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif4, var4);
                     if (this.produitsTarif != null) {
                        var14 = 0.0D;
                        if (!this.produitsTarif.isProtarExoTva()) {
                           var14 = var5.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                           this.produits.setPv4(var14);
                        } else {
                           var14 = this.produitsTarif.getProtarPv();
                           this.produits.setPv4(var14);
                        }
                     }
                  }

                  if (this.var_aff_tarif5 && this.var_tarif5 != null && !this.var_tarif5.isEmpty()) {
                     this.produitsTarif = new ProduitsTarif();
                     this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif5, var4);
                     if (this.produitsTarif != null) {
                        var14 = 0.0D;
                        if (!this.produitsTarif.isProtarExoTva()) {
                           var14 = var5.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                           this.produits.setPv5(var14);
                        } else {
                           var14 = this.produitsTarif.getProtarPv();
                           this.produits.setPv4(var14);
                        }
                     }
                  }

                  ++var7;
               }
            }

            this.recupererConfigListeEntete();
            this.datamodelProduits.setWrappedData(this.lesProduits);
            this.extDTable = new HtmlExtendedDataTable();
            if (this.simpleSelection == null) {
               this.simpleSelection = new SimpleSelection();
            }

            this.simpleSelection.clear();
            this.produits = new Produits();
         } else {
            this.produits = this.annuleProduit();
         }
      } else {
         this.produits = this.annuleProduit();
      }

      this.utilInitHibernate.closeSession();
      return this.produits;
   }

   public Produits rechercheProduitParc(String var1, int var2, OptionParcs var3) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectProduits = false;
      this.optionParcs = var3;
      this.showModalPanelDupProduit = false;
      this.lesProduits = new ArrayList();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      if (var1 != null && !var1.isEmpty()) {
         this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         this.lesProduits = this.produitsVtesDao.verifProduitsParc(var1, var4);
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.calculeProduit();
         } else if (this.lesProduits.size() > 1) {
            if (this.lesProduits.size() != 0) {
               this.recupererFamillesClientItem();
               UtilNombre var5 = new UtilNombre();
               new ArrayList();
               this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
               this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
               int var7 = 0;

               while(true) {
                  float var8;
                  float var9;
                  float var10;
                  int var11;
                  if (var7 >= this.lesProduits.size()) {
                     if (this.produits.getProStock() == 0) {
                        break;
                     }

                     new ArrayList();
                     this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
                     List var13 = this.produitsDepotDao.selectProdDepByprod(this.produits, var4);
                     if (var13.size() == 0) {
                        this.produits.setProQteCmdClient(0.0F);
                        this.produits.setProQteCmdFournisseur(0.0F);
                        this.produits.setProQteStock(0.0F);
                        break;
                     }

                     var8 = 0.0F;
                     var9 = 0.0F;
                     var10 = 0.0F;

                     for(var11 = 0; var11 < var13.size(); ++var11) {
                        var8 += ((ProduitsDepot)var13.get(var11)).getProdepQteCmdVte();
                        var9 += ((ProduitsDepot)var13.get(var11)).getProdepQteCmdAch();
                        var10 += ((ProduitsDepot)var13.get(var11)).getProdepQteStk();
                     }

                     this.produits.setProQteCmdClient(var8);
                     this.produits.setProQteCmdFournisseur(var9);
                     this.produits.setProQteStock(var10);
                     break;
                  }

                  this.produits = new Produits();
                  this.produits = (Produits)this.lesProduits.get(var7);
                  var8 = 0.0F;
                  var9 = 0.0F;
                  var10 = 0.0F;
                  List var6 = this.produitsDepotDao.selectProdDepByprod(this.produits, var4);
                  if (var6.size() != 0) {
                     for(var11 = 0; var11 < var6.size(); ++var11) {
                        var8 += ((ProduitsDepot)var6.get(var11)).getProdepQteCmdVte();
                        var9 += ((ProduitsDepot)var6.get(var11)).getProdepQteCmdAch();
                        var10 += ((ProduitsDepot)var6.get(var11)).getProdepQteStk();
                     }
                  }

                  this.produits.setProQteCmdClient(var8);
                  this.produits.setProQteCmdFournisseur(var9);
                  this.produits.setProQteStock(var10);
                  double var14;
                  if (this.var_aff_tarif1 && this.var_tarif1 != null && !this.var_tarif1.isEmpty()) {
                     this.produitsTarif = new ProduitsTarif();
                     this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif1, var4);
                     if (this.produitsTarif != null) {
                        var14 = 0.0D;
                        if (!this.produitsTarif.isProtarExoTva()) {
                           var14 = var5.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                           this.produits.setPv1(var14);
                        } else {
                           var14 = this.produitsTarif.getProtarPv();
                           this.produits.setPv1(var14);
                        }
                     }
                  }

                  if (this.var_aff_tarif2 && this.var_tarif2 != null && !this.var_tarif2.isEmpty()) {
                     this.produitsTarif = new ProduitsTarif();
                     this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif2, var4);
                     if (this.produitsTarif != null) {
                        var14 = 0.0D;
                        if (!this.produitsTarif.isProtarExoTva()) {
                           var14 = var5.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                           this.produits.setPv2(var14);
                        } else {
                           var14 = this.produitsTarif.getProtarPv();
                           this.produits.setPv2(var14);
                        }
                     }
                  }

                  if (this.var_aff_tarif3 && this.var_tarif3 != null && !this.var_tarif3.isEmpty()) {
                     this.produitsTarif = new ProduitsTarif();
                     this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif3, var4);
                     if (this.produitsTarif != null) {
                        var14 = 0.0D;
                        if (!this.produitsTarif.isProtarExoTva()) {
                           var14 = var5.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                           this.produits.setPv3(var14);
                        } else {
                           var14 = this.produitsTarif.getProtarPv();
                           this.produits.setPv3(var14);
                        }
                     }
                  }

                  if (this.var_aff_tarif4 && this.var_tarif4 != null && !this.var_tarif4.isEmpty()) {
                     this.produitsTarif = new ProduitsTarif();
                     this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif4, var4);
                     if (this.produitsTarif != null) {
                        var14 = 0.0D;
                        if (!this.produitsTarif.isProtarExoTva()) {
                           var14 = var5.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                           this.produits.setPv4(var14);
                        } else {
                           var14 = this.produitsTarif.getProtarPv();
                           this.produits.setPv4(var14);
                        }
                     }
                  }

                  if (this.var_aff_tarif5 && this.var_tarif5 != null && !this.var_tarif5.isEmpty()) {
                     this.produitsTarif = new ProduitsTarif();
                     this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif5, var4);
                     if (this.produitsTarif != null) {
                        var14 = 0.0D;
                        if (!this.produitsTarif.isProtarExoTva()) {
                           var14 = var5.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                           this.produits.setPv5(var14);
                        } else {
                           var14 = this.produitsTarif.getProtarPv();
                           this.produits.setPv4(var14);
                        }
                     }
                  }

                  ++var7;
               }
            }

            this.recupererConfigListeEntete();
            this.datamodelProduits.setWrappedData(this.lesProduits);
            this.extDTable = new HtmlExtendedDataTable();
            if (this.simpleSelection == null) {
               this.simpleSelection = new SimpleSelection();
            }

            this.simpleSelection.clear();
            this.produits = new Produits();
         } else {
            this.produits = this.annuleProduit();
         }
      } else {
         this.produits = this.annuleProduit();
      }

      this.utilInitHibernate.closeSession();
      return this.produits;
   }

   public Produits rechercheProduitVenteHorsGenerique(String var1, int var2, OptionVentes var3) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectProduits = false;
      this.optionVentes = var3;
      this.showModalPanelDupProduit = false;
      this.lesProduits = new ArrayList();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      if (var1 != null && !var1.isEmpty()) {
         this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         this.lesProduits = this.produitsVtesDao.verifProduitsHorsGenerique(var1, var4);
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.calculeProduit();
         } else if (this.lesProduits.size() > 1) {
            this.calculePv(var4);
            this.recupererConfigListeEntete();
            this.datamodelProduits.setWrappedData(this.lesProduits);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.produits = new Produits();
         } else {
            this.produits = this.annuleProduit();
         }
      } else {
         this.produits = this.annuleProduit();
      }

      this.utilInitHibernate.closeSession();
      return this.produits;
   }

   public Produits rechercheProduitVenteHorsGenerique(String var1, int var2, OptionMedical var3) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectProduits = false;
      this.optionMedical = var3;
      this.showModalPanelDupProduit = false;
      this.lesProduits = new ArrayList();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      if (var1 != null && !var1.isEmpty()) {
         this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         this.lesProduits = this.produitsVtesDao.verifProduitsMedicaux(var1, "1110", var4);
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.calculeProduit();
         } else if (this.lesProduits.size() > 1) {
            this.calculePv(var4);
            this.recupererConfigListeEntete();
            this.datamodelProduits.setWrappedData(this.lesProduits);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.produits = new Produits();
         } else {
            this.produits = this.annuleProduit();
         }
      } else {
         this.produits = this.annuleProduit();
      }

      this.utilInitHibernate.closeSession();
      return this.produits;
   }

   public Produits rechercheProduitVenteHorsGenerique(String var1, String var2, int var3, OptionVentes var4) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var3;
      this.selectProduits = false;
      this.optionVentes = var4;
      this.showModalPanelDupProduit = false;
      this.lesProduits = new ArrayList();
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      if (var2 != null && !var2.isEmpty() && var1 != null && !var1.isEmpty() && var1.contains(":")) {
         String[] var6 = var1.split(":");
         new DepotAchats();
         DepotAchatsDao var8 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         DepotAchats var7 = var8.trouveDepot(var6[0], var5);
         if (var7 != null) {
            new ArrayList();
            this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
            List var9 = this.produitsDepotDao.selectProdDepByDepVtes(var2, var7, var5);
            if (var9.size() == 1) {
               this.produits = ((ProduitsDepot)var9.get(0)).getProduits();
               this.calculeProduit();
            } else if (var9.size() > 1) {
               for(int var10 = 0; var10 < var9.size(); ++var10) {
                  new ProduitsDepot();
                  ProduitsDepot var11 = (ProduitsDepot)var9.get(var10);
                  this.lesProduits.add(var11.getProduits());
               }

               this.calculePv(var5);
               this.recupererConfigListeEntete();
               this.datamodelProduits.setWrappedData(this.lesProduits);
               this.extDTable = new HtmlExtendedDataTable();
               this.simpleSelection = new SimpleSelection();
               this.simpleSelection.clear();
               this.produits = new Produits();
            } else {
               this.produits = this.annuleProduit();
            }
         } else {
            this.produits = this.annuleProduit();
         }
      } else {
         this.produits = this.annuleProduit();
      }

      this.utilInitHibernate.closeSession();
      return this.produits;
   }

   public Produits rechercheProduitsListe(List var1, String var2, int var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, String var9, String var10, String var11, String var12, String var13, OptionVentes var14) throws HibernateException, NamingException, IOException {
      this.nature = var3;
      this.selectProduits = false;
      this.optionVentes = var14;
      this.var_aff_tarif1 = var4;
      this.var_aff_tarif2 = var5;
      this.var_aff_tarif3 = var6;
      this.var_aff_tarif4 = var7;
      this.var_aff_tarif5 = var8;
      this.var_tarif1 = var9;
      this.var_tarif2 = var10;
      this.var_tarif3 = var11;
      this.var_tarif4 = var12;
      this.var_tarif5 = var13;
      this.showModalPanelDupProduit = false;
      this.lesProduits = new ArrayList();
      if (var2.equals("*")) {
         var2 = "";
      } else {
         var2 = var2.toUpperCase();
      }

      if (var1.size() != 0) {
         for(int var15 = 0; var15 < var1.size(); ++var15) {
            this.produits = (Produits)var1.get(var15);
            if (var2 != null && !var2.isEmpty()) {
               if (this.produits.getProCode().toUpperCase().startsWith(var2) || this.produits.getProLibClient().toUpperCase().startsWith(var2)) {
                  this.lesProduits.add(this.produits);
               }
            } else {
               this.lesProduits.add(this.produits);
            }
         }
      }

      if (this.lesProduits.size() != 0) {
         this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
         Session var22 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");

         for(int var16 = 0; var16 < this.lesProduits.size(); ++var16) {
            this.produits = (Produits)this.lesProduits.get(var16);
            if (this.produits.getProStock() != 0) {
               new ArrayList();
               List var17 = this.produitsDepotDao.selectProdDepByprod(this.produits, var22);
               if (var17.size() == 0) {
                  this.produits.setProQteCmdClient(0.0F);
                  this.produits.setProQteCmdFournisseur(0.0F);
                  this.produits.setProQteStock(0.0F);
               } else {
                  float var18 = 0.0F;
                  float var19 = 0.0F;
                  float var20 = 0.0F;

                  for(int var21 = 0; var21 < var17.size(); ++var21) {
                     var18 += ((ProduitsDepot)var17.get(var21)).getProdepQteCmdVte();
                     var19 += ((ProduitsDepot)var17.get(var21)).getProdepQteCmdAch();
                     var20 += ((ProduitsDepot)var17.get(var21)).getProdepQteStk();
                  }

                  this.produits.setProQteCmdClient(var18);
                  this.produits.setProQteCmdFournisseur(var19);
                  this.produits.setProQteStock(var20);
               }
            }
         }

         this.utilInitHibernate.closeSession();
         this.recupererConfigListeEntete();
         this.datamodelProduits.setWrappedData(this.lesProduits);
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelection = new SimpleSelection();
         this.simpleSelection.clear();
         this.produits = new Produits();
      } else {
         this.produits = this.annuleProduit();
      }

      return this.produits;
   }

   public void calculePv(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      if (this.lesProduits.size() != 0) {
         this.recupererFamillesClientItem();
         UtilNombre var2 = new UtilNombre();
         this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);

         for(int var3 = 0; var3 < this.lesProduits.size(); ++var3) {
            this.produits = new Produits();
            this.produits = (Produits)this.lesProduits.get(var3);
            double var4;
            if (this.var_aff_tarif1 && this.var_tarif1 != null && !this.var_tarif1.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif1, var1);
               if (this.produitsTarif != null) {
                  var4 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var4 = var2.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv1(var4);
                  } else {
                     var4 = this.produitsTarif.getProtarPv();
                     this.produits.setPv1(var4);
                  }
               }
            }

            if (this.var_aff_tarif2 && this.var_tarif2 != null && !this.var_tarif2.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif2, var1);
               if (this.produitsTarif != null) {
                  var4 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var4 = var2.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv2(var4);
                  } else {
                     var4 = this.produitsTarif.getProtarPv();
                     this.produits.setPv2(var4);
                  }
               }
            }

            if (this.var_aff_tarif3 && this.var_tarif3 != null && !this.var_tarif3.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif3, var1);
               if (this.produitsTarif != null) {
                  var4 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var4 = var2.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv3(var4);
                  } else {
                     var4 = this.produitsTarif.getProtarPv();
                     this.produits.setPv3(var4);
                  }
               }
            }

            if (this.var_aff_tarif4 && this.var_tarif4 != null && !this.var_tarif4.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif4, var1);
               if (this.produitsTarif != null) {
                  var4 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var4 = var2.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv4(var4);
                  } else {
                     var4 = this.produitsTarif.getProtarPv();
                     this.produits.setPv4(var4);
                  }
               }
            }

            if (this.var_aff_tarif5 && this.var_tarif5 != null && !this.var_tarif5.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif5, var1);
               if (this.produitsTarif != null) {
                  var4 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var4 = var2.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv5(var4);
                  } else {
                     var4 = this.produitsTarif.getProtarPv();
                     this.produits.setPv4(var4);
                  }
               }
            }

            if (this.produits.getProStock() != 0) {
               new ArrayList();
               this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
               List var9 = this.produitsDepotDao.selectProdDepByprod(this.produits, var1);
               if (var9.size() == 0) {
                  this.produits.setProQteCmdClient(0.0F);
                  this.produits.setProQteCmdFournisseur(0.0F);
                  this.produits.setProQteStock(0.0F);
               } else {
                  float var5 = 0.0F;
                  float var6 = 0.0F;
                  float var7 = 0.0F;

                  for(int var8 = 0; var8 < var9.size(); ++var8) {
                     var5 += ((ProduitsDepot)var9.get(var8)).getProdepQteCmdVte();
                     var6 += ((ProduitsDepot)var9.get(var8)).getProdepQteCmdAch();
                     var7 += ((ProduitsDepot)var9.get(var8)).getProdepQteStk();
                  }

                  this.produits.setProQteCmdClient(var5);
                  this.produits.setProQteCmdFournisseur(var6);
                  this.produits.setProQteStock(var7);
               }
            }
         }
      }

   }

   public void selectionProduit() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.produits = (Produits)var1.get(0);
            this.produitsDuppliquer = this.produits;
            this.selectProduits = true;
         } else {
            this.selectProduits = false;
         }
      } else {
         this.selectProduits = false;
      }

   }

   public Produits annuleProduit() {
      this.produits = null;
      return this.produits;
   }

   public Produits calculeProduit() throws JDOMException, IOException {
      return this.produits;
   }

   public void duppliquerProduit() throws HibernateException, NamingException {
      if (this.produits != null) {
         this.produits = new Produits();
         int var1 = Integer.parseInt(this.optionVentes.getNbrCaracteresProPRO());
         String var2 = this.produitsDuppliquer.getProVteCode() + ":" + this.produitsDuppliquer.getProVteLib();
         long var3 = 0L;
         if (this.optionVentes.getModCalcProPRO().equalsIgnoreCase("0")) {
            this.verouxCod = false;
         } else if (this.optionVentes.getModCalcProPRO().equalsIgnoreCase("1")) {
            this.verouxCod = false;
         } else {
            CalculChrono var5;
            String var6;
            if (this.optionVentes.getModCalcProPRO().equalsIgnoreCase("2")) {
               this.verouxCod = true;
               this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
               var3 = this.produitsAchsDao.lastProduit((Session)null, 2);
               var5 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               var6 = var5.numero(var1, var3);
               this.produits.setProCode(var6);
               this.verifCode(var1);
            } else if (this.optionVentes.getModCalcProPRO().equalsIgnoreCase("3")) {
               this.verouxCod = true;
               this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
               var3 = this.produitsAchsDao.lastProduit((Session)null, 3);
               var5 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               var6 = var5.numero(var1, var3);
               this.produits.setProCode(var6);
               this.verifCode(var1);
            } else if (this.optionVentes.getModCalcProPRO().equalsIgnoreCase("4")) {
               this.verouxCod = true;
               this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
               var3 = this.produitsAchsDao.lastProduit((Session)null, 4);
               var5 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               var6 = var5.numero(var1, var3);
               this.produits.setProCode(var6);
               this.verifCode(var1);
            } else {
               String var7;
               String[] var8;
               CalculChrono var9;
               if (this.optionVentes.getModCalcProPRO().equalsIgnoreCase("5")) {
                  this.verouxCod = true;
                  if (var2.contains(":")) {
                     var8 = var2.split(":");
                     this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
                     var3 = this.produitsAchsDao.lastProduitByIdAch(var8[0], (Session)null);
                     var9 = new CalculChrono(this.baseLog, this.utilInitHibernate);
                     var7 = var9.numero(var1, var3);
                     this.produits.setProCode(var8[0] + "-" + var7);
                     this.verifCode(var1);
                  }
               } else if (this.optionVentes.getModCalcProPRO().equalsIgnoreCase("6")) {
                  this.verouxCod = true;
                  if (var2.contains(":")) {
                     var8 = var2.split(":");
                     this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
                     var3 = this.produitsAchsDao.nbProduitByFamilleVte(var8[0], (Session)null);
                     var9 = new CalculChrono(this.baseLog, this.utilInitHibernate);
                     var7 = var9.numero(var1, var3);
                     this.produits.setProCode(var8[0] + "-" + var7);
                     this.verifCode(var1);
                  }
               } else if (this.optionVentes.getModCalcProPRO().equalsIgnoreCase("7")) {
                  this.verouxCod = true;
                  if (var2.contains(":")) {
                     var8 = var2.split(":");
                     this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
                     var3 = this.produitsAchsDao.lastProduitByFamilleAch(var8[0], (Session)null);
                     var9 = new CalculChrono(this.baseLog, this.utilInitHibernate);
                     var7 = var9.numero(var1, var3);
                     this.produits.setProCode(var8[0] + "-" + var7);
                     this.verifCode(var1);
                  }
               }
            }
         }

         this.produitExiste = true;
         this.showModalPanelDupProduit = true;
      }

   }

   public void verifCode(int var1) throws HibernateException, NamingException {
      if (this.produits.getProCode() != null && !this.produits.getProCode().isEmpty()) {
         if (!this.optionVentes.getModCalcProPRO().equalsIgnoreCase("0")) {
            if (this.optionVentes.getModCalcProPRO().equalsIgnoreCase("1")) {
               CalculChrono var2 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               String var3 = var2.numero(var1, this.produits.getProCode());
               this.produits.setProCode(var3);
            } else if (!this.optionVentes.getModCalcProPRO().equalsIgnoreCase("2") && !this.optionVentes.getModCalcProPRO().equalsIgnoreCase("3") && !this.optionVentes.getModCalcProPRO().equalsIgnoreCase("4") && !this.optionVentes.getModCalcProPRO().equalsIgnoreCase("5") && !this.optionVentes.getModCalcProPRO().equalsIgnoreCase("6") && this.optionVentes.getModCalcProPRO().equalsIgnoreCase("7")) {
            }
         }

         boolean var4 = false;
         var4 = this.produitsAchsDao.existCode(this.produits.getProCode(), (Session)null);
         if (!var4) {
            this.existCod = true;
         } else {
            this.existCod = false;
         }
      } else {
         this.existCod = false;
      }

   }

   public void annuleDuppliquerProduit() {
      this.showModalPanelDupProduit = false;
   }

   public void testUniciteProduit() throws HibernateException, NamingException {
      this.produitExiste = this.produitsAchsDao.existCode(this.produits.getProCode(), (Session)null);
   }

   public void valideDuppliquerProduit() throws HibernateException, NamingException, IOException {
      this.produits.setProAchCode(this.produitsDuppliquer.getProAchCode());
      this.produits.setProAchCpteCh(this.produitsDuppliquer.getProAchCpteCh());
      this.produits.setProAchCpteHz(this.produitsDuppliquer.getProAchCpteHz());
      this.produits.setProAchCpteLoc(this.produitsDuppliquer.getProAchCpteLoc());
      this.produits.setProAchCpteSt(this.produitsDuppliquer.getProAchCpteSt());
      this.produits.setProAchDouane(this.produitsDuppliquer.getProAchDouane());
      this.produits.setProAchLib(this.produitsDuppliquer.getProAchLib());
      this.produits.setProAchNat(this.produitsDuppliquer.getProAchNat());
      this.produits.setProAchTva(this.produitsDuppliquer.getProAchTva());
      this.produits.setProVteCode(this.produitsDuppliquer.getProVteCode());
      this.produits.setProVteCpteCa(this.produitsDuppliquer.getProVteCpteCa());
      this.produits.setProVteCpteHz(this.produitsDuppliquer.getProVteCpteHz());
      this.produits.setProVteCpteLoc(this.produitsDuppliquer.getProVteCpteLoc());
      this.produits.setProVteCpteSt(this.produitsDuppliquer.getProVteCpteSt());
      this.produits.setProVteCpteNTx(this.produitsDuppliquer.getProVteCpteNTx());
      this.produits.setProVteCptePr(this.produitsDuppliquer.getProVteCptePr());
      this.produits.setProVteCpteZ(this.produitsDuppliquer.getProVteCpteZ());
      this.produits.setProVteDouane(this.produitsDuppliquer.getProVteDouane());
      this.produits.setProVteLib(this.produitsDuppliquer.getProVteLib());
      this.produits.setProVteNat(this.produitsDuppliquer.getProVteNat());
      this.produits.setProVteTva(this.produitsDuppliquer.getProVteTva());
      this.produits.setProActivite(this.produitsDuppliquer.getProActivite());
      this.produits.setProAssurance(this.produitsDuppliquer.getProAssurance());
      this.produits.setProBarre(this.produitsDuppliquer.getProBarre());
      this.produits.setProBoiteVitesse(this.produitsDuppliquer.getProBoiteVitesse());
      this.produits.setProCaf(this.produitsDuppliquer.getProCaf());
      this.produits.setProCarrosserie(this.produitsDuppliquer.getProCarrosserie());
      this.produits.setProCle1(this.produitsDuppliquer.getProCle1());
      this.produits.setProCle2(this.produitsDuppliquer.getProCle2());
      this.produits.setProCodeLie(this.produitsDuppliquer.getProCodeLie());
      this.produits.setProCodeOption(this.produitsDuppliquer.getProCodeOption());
      this.produits.setProCondition1(this.produitsDuppliquer.getProCondition1());
      this.produits.setProCondition2(this.produitsDuppliquer.getProCondition2());
      this.produits.setProCondition3(this.produitsDuppliquer.getProCondition3());
      this.produits.setProCondition4(this.produitsDuppliquer.getProCondition4());
      this.produits.setProCondition5(this.produitsDuppliquer.getProCondition5());
      this.produits.setProConstructeur(this.produitsDuppliquer.getProConstructeur());
      this.produits.setProCouleur(this.produitsDuppliquer.getProCouleur());
      this.produits.setProCylindree(this.produitsDuppliquer.getProCylindree());
      this.produits.setProDateCreat(new Date());
      this.produits.setProDateModif((Date)null);
      this.produits.setProDatePublic(this.produitsDuppliquer.getProDatePublic());
      this.produits.setProDefDtePump(this.produitsDuppliquer.getProDefDtePump());
      this.produits.setProDensite(this.produitsDuppliquer.getProDensite());
      this.produits.setProDepotAch(this.produitsDuppliquer.getProDepotAch());
      this.produits.setProDepotPrd(this.produitsDuppliquer.getProDepotPrd());
      this.produits.setProDepotVte(this.produitsDuppliquer.getProDepotVte());
      this.produits.setProDevise(this.produitsDuppliquer.getProDevise());
      this.produits.setProDiamExt(this.produitsDuppliquer.getProDiamExt());
      this.produits.setProDiamInt(this.produitsDuppliquer.getProDiamInt());
      this.produits.setProEnergie(this.produitsDuppliquer.getProEnergie());
      this.produits.setProEpaisseur(this.produitsDuppliquer.getProEpaisseur());
      this.produits.setProEtat(this.produitsDuppliquer.getProEtat());
      this.produits.setProFormule(this.produitsDuppliquer.getProFormule());
      this.produits.setProFret(this.produitsDuppliquer.getProFret());
      this.produits.setProGenre(this.produitsDuppliquer.getProGenre());
      this.produits.setProGrpInv(this.produitsDuppliquer.getProGrpInv());
      this.produits.setProImpDesciption(this.produitsDuppliquer.getProImpDesciption());
      this.produits.setProInactif(this.produitsDuppliquer.getProInactif());
      this.produits.setProLargeur(this.produitsDuppliquer.getProLargeur());
      this.produits.setProLettre(this.produitsDuppliquer.getProLettre());
      this.produits.setProLongueur(this.produitsDuppliquer.getProLongueur());
      this.produits.setProMarque(this.produitsDuppliquer.getProMarque());
      this.produits.setProMode(this.produitsDuppliquer.getProMode());
      this.produits.setProNbPlace(this.produitsDuppliquer.getProNbPlace());
      this.produits.setProNbPorte(this.produitsDuppliquer.getProNbPorte());
      this.produits.setProNbUnite(this.produitsDuppliquer.getProNbUnite());
      this.produits.setProPA(this.produitsDuppliquer.getProPA());
      this.produits.setProPdf("");
      this.produits.setProPhoto("");
      this.produits.setProPoidsBrut(this.produitsDuppliquer.getProPoidsBrut());
      this.produits.setProPoidsNet(this.produitsDuppliquer.getProPoidsNet());
      this.produits.setProPoidsTare(this.produitsDuppliquer.getProPoidsTare());
      this.produits.setProPrcExoP(this.produitsDuppliquer.getProPrcExoP());
      this.produits.setProPrcExoT(this.produitsDuppliquer.getProPrcExoT());
      this.produits.setProPrcHt(this.produitsDuppliquer.getProPrcHt());
      this.produits.setProPression(this.produitsDuppliquer.getProPression());
      this.produits.setProPrgExoP(this.produitsDuppliquer.getProPrgExoP());
      this.produits.setProPrgExoT(this.produitsDuppliquer.getProPrgExoT());
      this.produits.setProPrgHt(this.produitsDuppliquer.getProPrgHt());
      this.produits.setProPromo(this.produitsDuppliquer.getProPromo());
      this.produits.setProPublic(this.produitsDuppliquer.getProPublic());
      this.produits.setProPuissance(this.produitsDuppliquer.getProPuissance());
      this.produits.setProPuissanceDin(this.produitsDuppliquer.getProPuissanceDin());
      this.produits.setProQteCmdClient(0.0F);
      this.produits.setProQteCmdFournisseur(0.0F);
      this.produits.setProQteLie(0.0F);
      this.produits.setProQteStock(0.0F);
      this.produits.setProRemise(this.produitsDuppliquer.getProRemise());
      this.produits.setProStock(this.produitsDuppliquer.getProStock());
      this.produits.setProUserCreat(this.usersLog.getUsrid());
      this.produits.setProUserModif(0L);
      this.produits.setProVolume(this.produitsDuppliquer.getProVolume());
      this.produits = this.produitsAchsDao.insert(this.produits);
      this.lesProduits.clear();
      this.lesProduits.add(this.produits);
      this.recupererConfigListeEntete();
      this.datamodelProduits.setWrappedData(this.lesProduits);
      this.showModalPanelDupProduit = false;
   }

   public Activites rechercheActivites(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectActivites = false;
      this.lesActivites = new ArrayList();
      if (var1 != null && !var1.isEmpty()) {
         this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
         this.lesActivites = this.activitesDao.selectActivitesByCode(var1, (Session)null);
         if (this.lesActivites.size() == 1 && !var1.equals("*")) {
            this.activite = (Activites)this.lesActivites.get(0);
         } else if (this.lesActivites.size() >= 1) {
            this.datamodelActivites.setWrappedData(this.lesActivites);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.activite = new Activites();
         } else {
            this.datamodelActivites.setWrappedData(this.lesActivites);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.activite = new Activites();
         }
      } else {
         this.activite = new Activites();
      }

      return this.activite;
   }

   public void selectionActivite() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.activite = (Activites)var1.get(0);
            this.selectActivites = true;
         } else {
            this.selectActivites = false;
         }
      } else {
         this.selectActivites = false;
      }

   }

   public Activites annuleActivite() {
      this.activite = null;
      return this.activite;
   }

   public Activites calculeActivite() throws JDOMException, IOException {
      return this.activite;
   }

   public PlansAnalytiques rechercheChantiers(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectChantier = false;
      this.lesDossiers = new ArrayList();
      if (var1 != null && !var1.isEmpty()) {
         this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.lesDossiers = this.plansAnalytiquesDao.selectAnal("7", var1, "", this.nature, (Session)null);
         if (this.lesDossiers.size() == 1 && !var1.equals("*")) {
            this.plansAnalytiques = (PlansAnalytiques)this.lesDossiers.get(0);
         } else if (this.lesDossiers.size() >= 1) {
            this.datamodelDossier.setWrappedData(this.lesDossiers);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.plansAnalytiques = new PlansAnalytiques();
         } else {
            this.datamodelDossier.setWrappedData(this.lesDossiers);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.plansAnalytiques = new PlansAnalytiques();
         }
      } else {
         this.plansAnalytiques = new PlansAnalytiques();
      }

      return this.plansAnalytiques;
   }

   public void selectionChantier() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.plansAnalytiques = (PlansAnalytiques)var1.get(0);
            this.selectChantier = true;
         } else {
            this.selectChantier = false;
         }
      } else {
         this.selectChantier = false;
      }

   }

   public PlansAnalytiques annuleChantier() {
      this.plansAnalytiques = null;
      return this.plansAnalytiques;
   }

   public PlansAnalytiques calculeChantier() throws JDOMException, IOException {
      return this.plansAnalytiques;
   }

   public PlansAnalytiques rechercheDossier(String var1, String var2, int var3, Date var4, ExercicesAchats var5, String var6, String var7) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var3;
      this.annee = var2;
      this.dateDossier = var4;
      this.exercicesAchats = var5;
      this.serie = var6;
      this.devise = var7;
      this.selectDossier = false;
      this.lesDossiers = new ArrayList();
      this.mesdevisesItem = new ArrayList();
      DeviseDao var8 = new DeviseDao(this.baseLog, this.utilInitHibernate);
      this.mesdevisesItem = var8.chargerLesDevisesUtiliseesItem(this.structureLog, (Session)null);
      if (var1 != null && !var1.isEmpty()) {
         this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.lesDossiers = this.plansAnalytiquesDao.selectAnal("6", var1, "", this.nature, (Session)null);
         if (this.lesDossiers.size() == 1 && !var1.equals("*")) {
            this.dossier = (PlansAnalytiques)this.lesDossiers.get(0);
         } else if (this.lesDossiers.size() >= 1) {
            this.datamodelDossier.setWrappedData(this.lesDossiers);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.dossier = new PlansAnalytiques();
         } else {
            this.datamodelDossier.setWrappedData(this.lesDossiers);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.dossier = new PlansAnalytiques();
         }
      } else {
         this.dossier = this.annuleDossier();
      }

      return this.dossier;
   }

   public void selectionDossier() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.dossier = (PlansAnalytiques)var1.get(0);
            this.selectDossier = true;
         } else {
            this.selectDossier = false;
         }
      } else {
         this.selectDossier = false;
      }

   }

   public PlansAnalytiques annuleDossier() {
      this.dossier = null;
      return this.dossier;
   }

   public PlansAnalytiques calculeDossier() throws JDOMException, IOException {
      return this.dossier;
   }

   public void ajouterDossier() throws HibernateException, NamingException {
      this.dossier = new PlansAnalytiques();
      this.dossier.setAnaAnnee(this.annee);
      this.dossier.setAnaTypeDevise(this.devise);
      this.calculDevise();
      this.dossierExiste = true;
      this.showModalPanelAddDossier = true;
   }

   public void annulerDossier() {
      this.showModalPanelAddDossier = false;
   }

   public void testUniciteDossier() throws HibernateException, NamingException {
      this.dossierExiste = this.plansAnalytiquesDao.existCode("6", this.dossier.getAnaCode(), (Session)null);
   }

   public void validerDossier() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansAnalytiques");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.dossier.setAnaNature("6");
         this.dossier.setAnaDateCreat(new Date());
         this.dossier.setAnaUserCreat(this.usersLog.getUsrid());
         this.dossier.setAnaAnnee(this.annee);
         this.dossier.setAnaAch(true);
         this.dossier.setAnaFrg(false);
         this.dossier.setAnaInv(false);
         this.dossier.setAnaPrd(false);
         this.dossier.setAnaSal(false);
         this.dossier.setAnaTax(false);
         this.dossier.setAnaTva(false);
         this.dossier.setAnaVte(false);
         this.dossier = this.plansAnalytiquesDao.insert(this.dossier, var1);
         CalculChrono var3 = new CalculChrono(this.baseLog, this.utilInitHibernate);
         ValorisationEnteteAchats var4 = new ValorisationEnteteAchats();
         ValorisationEnteteAchatsDao var5 = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         var4.setValSerie(this.serie);
         var4.setValDate(this.dateDossier);
         if (var4.getValSerie() != null && !var4.getValSerie().equalsIgnoreCase("X") && !var4.getValSerie().isEmpty()) {
            String var13 = var3.numCompose(var4.getValDate(), 35, var4.getValSerie(), var1);
            var4.setValNum(var13);
         } else {
            long var6 = var5.selectLastNum(var1);
            var4.setValNum("" + var6);
         }

         var4.setValDossierTransit(this.dossier.getAnaCode());
         var4.setValDateCreat(new Date());
         var4.setValObjet(this.dossier.getAnaNomFr());
         var4.setValMode(Integer.parseInt(this.dossier.getAnaTypeDossier()));
         var4.setUsers(this.usersLog);
         var4.setValIdResponsable(this.usersLog.getUsrid());
         var4.setValNomCreateur(this.usersLog.getUsrPatronyme());
         var4.setValNomResponsable(this.usersLog.getUsrPatronyme());
         var4.setValDevise(this.dossier.getAnaTypeDevise());
         var4.setValCoefDeviseDouane(this.dossier.getAnaTypeTauxDevise());
         var4.setValExoTva(this.dossier.isAnaTypeExoTva());
         var4.setValExoDouane(this.dossier.isAnaTypeExoDouane());
         var4.setExercicesAchats(this.exercicesAchats);
         var5.insert(var4, var1);
         var2.commit();
      } catch (HibernateException var11) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.lesDossiers.add(this.dossier);
      this.datamodelDossier.setWrappedData(this.lesDossiers);
      this.showModalPanelAddDossier = false;
   }

   public void calculDevise() throws HibernateException, NamingException {
      this.dossier.setAnaTypeTauxDevise(0.0F);
      this.calculDevise((Session)null);
   }

   public void calculDevise(Session var1) throws HibernateException, NamingException {
      if (this.dossier.getAnaTypeDevise() != null) {
         if (this.dossier.getAnaTypeTauxDevise() == 0.0F) {
            if (this.dossier.getAnaTypeDevise().equals(this.structureLog.getStrdevise())) {
               this.dossier.setAnaTypeTauxDevise(1.0F);
            } else {
               new ObjetDevises();
               LectureDevises var3 = new LectureDevises();
               new Devise();
               DeviseDao var5 = new DeviseDao(this.baseLog, this.utilInitHibernate);
               Devise var4 = var5.chargerLesDevises(this.dossier.getAnaTypeDevise(), var1);
               ObjetDevises var2;
               float var6;
               float var7;
               float var8;
               float var9;
               if (var4 != null) {
                  var6 = var4.getDevTaux1();
                  var7 = var4.getDevTaux2();
                  var2 = var3.devisesRecherchee(this.structureLog.getStrdevise(), this.structureLog.getStrdevise());
                  var8 = Float.parseFloat(var2.getTaux1());
                  var9 = Float.parseFloat(var2.getTaux2());
                  this.dossier.setAnaTypeTauxDevise(var6 * var9);
               }

               if (this.dossier.getAnaTypeTauxDevise() == 0.0F) {
                  var2 = var3.devisesRecherchee(this.dossier.getAnaTypeDevise(), this.structureLog.getStrdevise());
                  var6 = Float.parseFloat(var2.getTaux1());
                  var7 = Float.parseFloat(var2.getTaux2());
                  var2 = var3.devisesRecherchee(this.structureLog.getStrdevise(), this.structureLog.getStrdevise());
                  var8 = Float.parseFloat(var2.getTaux1());
                  var9 = Float.parseFloat(var2.getTaux2());
                  this.dossier.setAnaTypeTauxDevise(var6 * var9);
               }
            }
         }
      } else {
         this.dossier.setAnaTypeTauxDevise(1.0F);
      }

   }

   public PlansAnalytiques rechercheAffaire(String var1, String var2, int var3, Date var4, ExercicesAchats var5, String var6, String var7) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var3;
      this.annee = var2;
      this.dateDossier = var4;
      this.exercicesAchats = var5;
      this.serie = var6;
      this.devise = var7;
      this.selectDossier = false;
      this.lesDossiers = new ArrayList();
      this.mesdevisesItem = new ArrayList();
      DeviseDao var8 = new DeviseDao(this.baseLog, this.utilInitHibernate);
      this.mesdevisesItem = var8.chargerLesDevisesUtiliseesItem(this.structureLog, (Session)null);
      if (var1 != null && !var1.isEmpty()) {
         this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.lesDossiers = this.plansAnalytiquesDao.selectAnal("10", var1, "", this.nature, (Session)null);
         if (this.lesDossiers.size() == 1 && !var1.equals("*")) {
            this.dossier = (PlansAnalytiques)this.lesDossiers.get(0);
         } else if (this.lesDossiers.size() >= 1) {
            this.datamodelDossier.setWrappedData(this.lesDossiers);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.dossier = new PlansAnalytiques();
         } else {
            this.datamodelDossier.setWrappedData(this.lesDossiers);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.dossier = new PlansAnalytiques();
         }
      } else {
         this.dossier = this.annuleDossier();
      }

      return this.dossier;
   }

   public Parc rechercheParc(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectParc = false;
      if (var1 != null && !var1.isEmpty()) {
         this.lesParcs = new ArrayList();
         this.parcDao = new ParcDao(this.baseLog, this.utilInitHibernate);
         this.lesParcs = this.parcDao.selectParc(var1, (Session)null);
         if (this.lesParcs.size() == 1) {
            this.parc = (Parc)this.lesParcs.get(0);
            this.calculeParc();
         } else if (this.lesParcs.size() > 1) {
            this.datamodelParc.setWrappedData(this.lesParcs);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.parc = new Parc();
         } else {
            this.parc = this.annuleParc();
         }
      } else {
         this.parc = this.annuleParc();
      }

      return this.parc;
   }

   public void selectionParc() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.parc = (Parc)var1.get(0);
            this.selectParc = true;
         } else {
            this.selectParc = false;
         }
      } else {
         this.selectParc = false;
      }

   }

   public Parc annuleParc() {
      this.parc = null;
      return this.parc;
   }

   public Parc calculeParc() throws JDOMException, IOException {
      return this.parc;
   }

   public PlanComptable recherchePlanComptable(String var1, String var2, int var3, ExercicesComptable var4, int var5, String var6, OptionComptabilite var7) throws JDOMException, IOException, HibernateException, NamingException {
      this.selecFiscalite = var1;
      this.nature = var3;
      this.exercicesComptable = var4;
      this.optionComptabilite = var7;
      this.selectPlanComptable = false;
      if (var2 != null && !var2.isEmpty()) {
         this.lesPlanComptable = new ArrayList();
         this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
         this.lesPlanComptable = this.planComptableDao.chargeNumCpte(this.selecFiscalite, var2, this.exercicesComptable.getExecpt_id(), var5, var6, (Session)null);
         if (this.lesPlanComptable.size() == 1) {
            this.planComptable = (PlanComptable)this.lesPlanComptable.get(0);
            this.calculePlanComptable();
         } else if (this.lesPlanComptable.size() > 1) {
            this.datamodelPlanComptable.setWrappedData(this.lesPlanComptable);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.planComptable = new PlanComptable();
         } else {
            this.planComptable = this.annulePlanComptable();
         }
      } else {
         this.planComptable = this.annulePlanComptable();
      }

      return this.planComptable;
   }

   public PlanComptable rechercheCompte(String var1, long var2) throws HibernateException, NamingException {
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.planComptable = this.planComptableDao.trouveCompte(this.selecFiscalite, var2, var1, (Session)null);
      return this.planComptable;
   }

   public PlanComptable rechercheCompte(String var1, long var2, Session var4) throws HibernateException, NamingException {
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.planComptable = this.planComptableDao.trouveCompte(this.selecFiscalite, var2, var1, var4);
      return this.planComptable;
   }

   public void selectionPlanComptable() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.planComptable = (PlanComptable)var1.get(0);
            this.selectPlanComptable = true;
         } else {
            this.selectPlanComptable = false;
         }
      } else {
         this.selectPlanComptable = false;
      }

   }

   public PlanComptable annulePlanComptable() {
      this.planComptable = null;
      return this.planComptable;
   }

   public PlanComptable calculePlanComptable() throws JDOMException, IOException {
      return this.planComptable;
   }

   public void ajouterCompte() throws IOException {
      this.mesNatureCompteItem = new ArrayList();
      this.nombrCaracter = Integer.parseInt(this.optionComptabilite.getNbcr());
      LectureNatureCompte var1 = new LectureNatureCompte();
      this.mesNatureCompteItem = var1.getMesNatureCompteItems();
      this.mesRacineCompteItem = new ArrayList();
      this.maNature = "0";
      this.racinecle = "";
      this.showModalPanelCreationCompte = true;
   }

   public void chargeRacineCompte() throws HibernateException, NamingException {
      this.mesRacineCompteItem = new ArrayList();
      if (this.maNature.contains(":")) {
         String[] var1 = this.maNature.split(":");
         new ArrayList();
         RacinesDao var3 = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
         List var2 = var3.rechercherListeRacine(this.selecFiscalite, var1[0], (Session)null);
         if (var2.size() != 0) {
            for(int var4 = 0; var4 < var2.size(); ++var4) {
               new Racines();
               Racines var5 = (Racines)var2.get(var4);
               String var6 = var5.getRacCode() + ":" + var5.getRacLibelleFr();
               this.mesRacineCompteItem.add(new SelectItem(var6));
            }
         }
      }

   }

   public void calculeCompte() throws HibernateException, NamingException, IOException {
      if (this.maRacine.contains(":")) {
         this.nbcarmax = 0;
         String[] var1 = this.maNature.split(":");
         if (var1.length == 2) {
            String[] var2 = this.maRacine.split(":");
            this.racinecle = var2[0];
            RacinesDao var3 = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
            new Racines();
            Racines var4 = var3.rechercherCodeRacine(this.selecFiscalite, this.racinecle, (Session)null);
            if (var4 != null) {
               this.planComptable = new PlanComptable();
               this.planComptable.setPlcFiscalite(this.selecFiscalite);
               this.planComptable.setPlcNature(Integer.parseInt(var1[0]));
               this.planComptable.setPlcLibelleNatureSP(var1[1]);
               this.planComptable.setPlcCodeRacine(this.racinecle);
               this.planComptable.setPlcLibelleRacineFR(var4.getRacLibelleFr());
               this.planComptable.setPlcLibelleRacineSP(var4.getRacLibelleSp());
               this.planComptable.setPlcLibelleRacineUK(var4.getRacLibelleSp());
               this.planComptable.setPlcSens(0);
               if (var4.getRacUtil().equalsIgnoreCase("1")) {
                  this.existeCopteDeja = true;
                  this.planComptable.setPlcTauxTaxe(var4.getRactaux());
                  this.planComptable.setPlcLibelleCpteFR(var4.getRacLibelleFr());
                  this.planComptable.setPlcLibelleCpteSP(var4.getRacLibelleSp());
                  this.planComptable.setPlcLibelleCpteUK(var4.getRacLibelleUk());
                  this.partieCompte = "" + this.calculeProchainNum(var4.getRacCode());
                  this.partieCompte = this.getComplementutil(this.partieCompte, var4.getRacCode());
                  this.planComptable.setPlcCompte(var4.getRacCode().concat(this.partieCompte));
                  this.valideCreationCompte();
                  int var5 = this.racinecle.length();
                  this.nbcarmax = this.nombrCaracter - var5;
               } else {
                  this.existeCopteDeja = true;
               }
            }
         }
      }

   }

   public int calculeProchainNum(String var1) throws HibernateException, NamingException, IOException {
      int var2 = 0;
      if (this.optionComptabilite.getCalculCompte().equals("0")) {
         var2 = this.planComptableDao.calculeNbCompte(this.selecFiscalite, var1, this.exercicesComptable.getExecpt_id(), (Session)null) + 1;
      } else if (this.optionComptabilite.getCalculCompte().equals("1")) {
         new ArrayList();
         List var3 = this.planComptableDao.chargeNumCpte(this.selecFiscalite, var1, 0L, 0, (String)null, (Session)null);
         if (var3.size() != 0) {
            int var4 = var3.size() - 1;
            String var5 = ((PlanComptable)var3.get(var4)).getPlcCompte();
            String var6 = var5.substring(var1.length(), 10);
            if (this.estUnEntier(var6)) {
               var2 = Integer.parseInt(var6) + 1;
            } else {
               var2 = this.planComptableDao.calculeNbCompte(this.selecFiscalite, var1, this.exercicesComptable.getExecpt_id(), (Session)null) + 1;
            }
         }
      }

      return var2;
   }

   public boolean estUnEntier(String var1) {
      try {
         Integer.parseInt(var1);
         return true;
      } catch (NumberFormatException var3) {
         return false;
      }
   }

   public String getComplementutil(String var1, String var2) {
      String var3 = var2.concat(var1);
      int var4 = this.nombrCaracter - var3.length();
      String var5 = "";
      if (var4 > 0) {
         String[] var6 = new String[var4];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[var7] = "0";
            var5 = var5 + var6[var7];
         }

         var5 = var5 + var1;
      } else {
         var5 = var1;
      }

      return var5;
   }

   public void valideCreationCompte() throws HibernateException, NamingException {
      this.planComptable.setPlcCompte(this.racinecle + this.partieCompte);
      this.existeCopteDeja = true;
      if (this.planComptable.getPlcCompte() != null && !this.planComptable.getPlcCompte().isEmpty()) {
         this.existeCopteDeja = this.planComptableDao.existeCompte(this.selecFiscalite, this.planComptable.getPlcCompte(), this.exercicesComptable.getExecpt_id(), (Session)null);
      }

   }

   public void saveCompte() throws HibernateException, NamingException {
      this.planComptable.setExercicesComptable(this.exercicesComptable);
      this.planComptable.setPlcDateCreat(new Date());
      this.planComptable.setPlcUserCreat(this.usersLog.getUsrid());
      this.planComptable.setPlcFiscalite(this.selecFiscalite);
      this.planComptable.setPlcRanDetaille(true);
      this.planComptable.setPlcLibelleCpteUK("");
      this.planComptable.setPlcLibelleCpteSP("");
      String[] var1 = this.maNature.split(":");
      this.planComptable.setPlcNature(Integer.parseInt(var1[0]));
      this.planComptable.setPlcLibelleNatureFR(var1[1]);
      this.planComptable.setPlcLibelleNatureUK("");
      this.planComptable.setPlcLibelleNatureSP("");
      String[] var2 = this.maRacine.split(":");
      this.planComptable.setPlcCodeRacine(var2[0]);
      this.planComptable.setPlcLibelleRacineFR(var2[1]);
      this.planComptable.setPlcLibelleRacineUK("");
      this.planComptable.setPlcLibelleRacineSP("");
      this.planComptable.setPlcLibre(this.partieCompte);
      this.planComptableDao.insert(this.planComptable);
      this.lesPlanComptable.add(this.planComptable);
      this.datamodelPlanComptable.setWrappedData(this.lesPlanComptable);
      if (this.planComptable.getPlcNature() == 6 || this.planComptable.getPlcNature() == 7) {
         this.tiers = new Tiers();
         this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
         this.tiers = this.tiersDao.chargerTiersByCompte(this.planComptable.getPlcCompte());
         if (this.tiers == null) {
            this.tiers = new Tiers();
            this.tiers.setTiecompte0(this.planComptable.getPlcCompte());
            this.tiers.setTieraisonsocialenom(this.planComptable.getPlcLibelleCpteFR());
            this.tiers.setTiecivilite("Autre");
            this.tiers.setTienompays(this.structureLog.getStrnompays());
            this.tiers.setTiecodepays(this.structureLog.getStrcodepays());
            this.tiers.setTiedevise(this.structureLog.getStrdevise());
            this.tiers.setTieFormatDevise(this.structureLog.getStrformatdevise());
            this.tiers.setTielangue(this.structureLog.getStrlangue());
            this.tiers.setTiedatecreat(new Date());
            this.tiers.setTieusercreat(this.usersLog.getUsrid());
            if (this.planComptable.getPlcNature() == 6) {
               this.tiers.setTietype("0");
               this.tiers.setTiegenre("001");
               this.tiers.setTiecategorie("Fournisseur");
               this.tiers = this.tiersDao.insert(this.tiers);
            } else if (this.planComptable.getPlcNature() == 7) {
               this.tiers.setTietype("3");
               this.tiers.setTiegenre("031");
               this.tiers.setTiecategorie("Client Société");
               this.tiers = this.tiersDao.insert(this.tiers);
            }
         }
      }

      this.showModalPanelCreationCompte = false;
   }

   public void annuleCreationCompte() {
      this.showModalPanelCreationCompte = false;
   }

   public void selectCompte() {
      if (this.partieCompte.contains(":")) {
         this.existeCopteDeja = false;
      } else {
         this.existeCopteDeja = true;
      }

   }

   public PlansTresorerie rechercheBudgetTresorerie(String var1, String var2, String var3, int var4, ExercicesComptable var5, OptionComptabilite var6) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.projetPresent = false;
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty() && this.structureLog.getStrmod1().equals("40300")) {
         this.projetPresent = true;
      } else if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty() && this.structureLog.getStrmod2().equals("40300")) {
         this.projetPresent = true;
      } else if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty() && this.structureLog.getStrmod3().equals("40300")) {
         this.projetPresent = true;
      } else if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty() && this.structureLog.getStrmod4().equals("40300")) {
         this.projetPresent = true;
      } else if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty() && this.structureLog.getStrmod5().equals("40300")) {
         this.projetPresent = true;
      } else if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty() && this.structureLog.getStrmod6().equals("40300")) {
         this.projetPresent = true;
      } else if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty() && this.structureLog.getStrmod7().equals("40300")) {
         this.projetPresent = true;
      } else if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty() && this.structureLog.getStrmod8().equals("40300")) {
         this.projetPresent = true;
      } else if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().isEmpty() && this.structureLog.getStrmod9().equals("40300")) {
         this.projetPresent = true;
      } else if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty() && this.structureLog.getStrmod10().equals("40300")) {
         this.projetPresent = true;
      }

      this.nature = var4;
      this.exercicesComptable = var5;
      this.optionComptabilite = var6;
      this.selectPlanComptable = false;
      if (var2 != null && !var2.isEmpty()) {
         this.lesBudgetTresorerie = new ArrayList();
         this.plansTresorerieDao = new PlansTresorerieDao(this.baseLog, this.utilInitHibernate);
         if (var5 != null) {
            this.lesBudgetTresorerie = this.plansTresorerieDao.chargerLesBudgetTresorerie(var1, var5.getExecpt_id(), var2, var3, this.usersLog.getUsrid(), this.projetPresent, (Session)null);
         } else {
            this.lesBudgetTresorerie = this.plansTresorerieDao.chargerLesBudgetTresorerie(var1, 0L, var2, var3, this.usersLog.getUsrid(), this.projetPresent, (Session)null);
         }

         if (this.lesBudgetTresorerie.size() == 1) {
            this.plansTresorerie = (PlansTresorerie)this.lesBudgetTresorerie.get(0);
            this.calculePlanComptable();
         } else if (this.lesBudgetTresorerie.size() > 1) {
            this.datamodelBudgetTresorerie.setWrappedData(this.lesBudgetTresorerie);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.plansTresorerie = new PlansTresorerie();
         } else {
            this.plansTresorerie = this.annuleBudgetTresorerie();
         }
      } else {
         this.plansTresorerie = this.annuleBudgetTresorerie();
      }

      return this.plansTresorerie;
   }

   public PlansTresorerie rechercheBudgetTresorerie(String var1, String var2, long var3) throws HibernateException, NamingException {
      this.plansTresorerieDao = new PlansTresorerieDao(this.baseLog, this.utilInitHibernate);
      this.plansTresorerie = this.plansTresorerieDao.chargerLesPlansTresorerie(var3, this.annee, var2, var1, (Session)null);
      return this.plansTresorerie;
   }

   public void selectionBudgetTresorerie() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.plansTresorerie = (PlansTresorerie)var1.get(0);
            if (this.plansTresorerie.getTreType() <= 1) {
               this.selectBudgetTresorerie = true;
            } else {
               this.selectBudgetTresorerie = false;
            }
         } else {
            this.selectBudgetTresorerie = false;
         }
      } else {
         this.selectBudgetTresorerie = false;
      }

   }

   public PlansTresorerie annuleBudgetTresorerie() {
      this.plansTresorerie = null;
      return this.plansTresorerie;
   }

   public PlansTresorerie calculeBudgetTresorerie() throws JDOMException, IOException {
      return this.plansTresorerie;
   }

   public Reglements rechercheChequesClient(String var1, int var2, ExercicesCaisse var3) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectReglements = false;
      if (var1 != null && !var1.isEmpty()) {
         this.lesReglements = new ArrayList();
         this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         this.lesReglements = this.reglementsDao.chargeChequeClient(var1, var3.getExecaiId(), (Session)null);
         if (this.lesReglements.size() == 1) {
            this.reglements = (Reglements)this.lesReglements.get(0);
            this.calculeCheque();
         } else if (this.lesReglements.size() > 1) {
            this.datamodelReglements.setWrappedData(this.lesReglements);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.reglements = new Reglements();
         } else {
            this.reglements = this.annuleCheque();
         }
      } else {
         this.reglements = this.annuleCheque();
      }

      return this.reglements;
   }

   public void selectionCheque() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.reglements = (Reglements)var1.get(0);
            this.selectReglements = true;
         } else {
            this.selectReglements = false;
         }
      } else {
         this.selectReglements = false;
      }

   }

   public Reglements annuleCheque() {
      this.reglements = null;
      return this.reglements;
   }

   public Reglements calculeCheque() throws JDOMException, IOException {
      return this.reglements;
   }

   public Salaries rechercheSalarie(String var1, int var2, int var3, long var4) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectSalaries = false;
      if (var1 != null && !var1.isEmpty()) {
         new ArrayList();
         this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
         List var6;
         if ((var2 != 813 || var3 != 83) && var3 != 85 && var3 != 86) {
            var6 = this.salariesDao.chargerlesSalariesActif(var1, (Session)null);
         } else {
            var6 = this.salariesDao.chargerlesSalariesTous(var1, (Session)null);
         }

         if (var6.size() == 1) {
            this.salaries = (Salaries)var6.get(0);
            this.calculeSalarie();
         } else if (var6.size() > 1) {
            this.datamodelSalaries.setWrappedData(var6);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.salaries = new Salaries();
         } else {
            this.salaries = this.annuleSalarie();
         }
      } else {
         this.salaries = this.annuleSalarie();
      }

      return this.salaries;
   }

   public Salaries rechercheSalarie(String var1, int var2, long var3) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectSalaries = false;
      if (var1 != null && !var1.isEmpty()) {
         new ArrayList();
         this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
         List var5 = this.salariesDao.chargerlesSalariesActif(var1, (Session)null);
         if (var5.size() == 1) {
            this.salaries = (Salaries)var5.get(0);
            this.calculeSalarie();
         } else if (var5.size() > 1) {
            this.datamodelSalaries.setWrappedData(var5);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.salaries = new Salaries();
         } else {
            this.salaries = this.annuleSalarie();
         }
      } else {
         this.salaries = this.annuleSalarie();
      }

      return this.salaries;
   }

   public void selectionSalarie() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.salaries = (Salaries)var1.get(0);
            this.selectSalaries = true;
         } else {
            this.selectSalaries = false;
         }
      } else {
         this.selectSalaries = false;
      }

   }

   public Salaries annuleSalarie() {
      this.salaries = null;
      return this.salaries;
   }

   public Salaries calculeSalarie() throws JDOMException, IOException {
      return this.salaries;
   }

   public SalariesContrats rechercheSalarieContrat(String var1, int var2, long var3) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectSalariesContrat = false;
      if (var1 != null && !var1.isEmpty()) {
         new ArrayList();
         this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
         List var5 = this.salariesContratsDao.chargerlesContratsSalaries(var1, (Session)null);
         if (var5.size() == 1) {
            this.salariesContrats = (SalariesContrats)var5.get(0);
            this.calculeSalarieContrat();
         } else if (var5.size() > 1) {
            this.datamodelSalariesContrats.setWrappedData(var5);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.salariesContrats = new SalariesContrats();
         } else {
            this.salariesContrats = this.annuleSalarieContrat();
         }
      } else {
         this.salariesContrats = this.annuleSalarieContrat();
      }

      return this.salariesContrats;
   }

   public void selectionSalarieContrat() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.salariesContrats = (SalariesContrats)var1.get(0);
            this.selectSalariesContrat = true;
         } else {
            this.selectSalariesContrat = false;
         }
      } else {
         this.selectSalariesContrat = false;
      }

   }

   public SalariesContrats annuleSalarieContrat() {
      this.salariesContrats = null;
      return this.salariesContrats;
   }

   public SalariesContrats calculeSalarieContrat() throws JDOMException, IOException {
      return this.salariesContrats;
   }

   public SommierEnteteAchats rechercheSommiers(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectSommier = false;
      if (var1 != null && !var1.isEmpty()) {
         this.lesSommiers = new ArrayList();
         this.sommierEnteteAchatsDao = new SommierEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         this.lesSommiers = this.sommierEnteteAchatsDao.listBySommierActif(var1, (Session)null);
         if (this.lesSommiers.size() == 1) {
            this.sommierEnteteAchats = (SommierEnteteAchats)this.lesSommiers.get(0);
            this.calculeSommiers();
         } else if (this.lesSommiers.size() > 1) {
            this.datamodelSommiers.setWrappedData(this.lesSommiers);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.sommierEnteteAchats = new SommierEnteteAchats();
         } else {
            this.sommierEnteteAchats = this.annuleSommiers();
         }
      } else {
         this.sommierEnteteAchats = this.annuleSommiers();
      }

      return this.sommierEnteteAchats;
   }

   public void selectionSommiers() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.sommierEnteteAchats = (SommierEnteteAchats)var1.get(0);
            this.selectSommier = true;
         } else {
            this.selectSommier = false;
         }
      } else {
         this.selectSommier = false;
      }

   }

   public SommierEnteteAchats annuleSommiers() {
      this.sommierEnteteAchats = null;
      return this.sommierEnteteAchats;
   }

   public SommierEnteteAchats calculeSommiers() throws JDOMException, IOException {
      return this.sommierEnteteAchats;
   }

   public Bien rechercheBiens(String var1, int var2, int var3) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectBien = false;
      if (var1 != null && !var1.isEmpty()) {
         this.lesBiens = new ArrayList();
         if (this.bienDao == null) {
            this.bienDao = new BienDao(this.baseLog, this.utilInitHibernate);
         }

         this.bienDao = new BienDao(this.baseLog, this.utilInitHibernate);
         this.lesBiens = this.bienDao.chargeBien(var3, 0, var1, (Session)null);
         if (this.lesBiens.size() == 1) {
            this.bien = (Bien)this.lesBiens.get(0);
            this.calculeBiens();
         } else if (this.lesBiens.size() > 1) {
            this.datamodelBiens.setWrappedData(this.lesBiens);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.bien = new Bien();
         } else {
            this.bien = this.annuleBiens();
         }
      } else {
         this.bien = this.annuleBiens();
      }

      return this.bien;
   }

   public void selectionBiens() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.bien = (Bien)var1.get(0);
            this.selectBien = true;
         } else {
            this.selectBien = false;
         }
      } else {
         this.selectBien = false;
      }

   }

   public Bien annuleBiens() {
      this.bien = null;
      return this.bien;
   }

   public Bien calculeBiens() throws JDOMException, IOException {
      return this.bien;
   }

   public BienTravauxEntete rechercheTravauxImmobilier(String var1, int var2, int var3) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectTravauxImmobilier = false;
      if (var1 != null && !var1.isEmpty()) {
         this.lesTravauxImmobilier = new ArrayList();
         this.bienTravauxEnteteDao = new BienTravauxEnteteDao(this.baseLog, this.utilInitHibernate);
         this.lesTravauxImmobilier = this.bienTravauxEnteteDao.chargeTravaux(var3, 0, var1, (Session)null);
         if (this.lesTravauxImmobilier.size() == 1) {
            this.bienTravauxEntete = (BienTravauxEntete)this.lesTravauxImmobilier.get(0);
            this.calculeTravauxImmobilier();
         } else if (this.lesTravauxImmobilier.size() > 1) {
            this.datamodelTravauxImmobilier.setWrappedData(this.lesTravauxImmobilier);
            if (this.extDTable == null) {
               this.extDTable = new HtmlExtendedDataTable();
            }

            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.bienTravauxEntete = new BienTravauxEntete();
         } else {
            this.bienTravauxEntete = this.annuleTravauxImmobilier();
         }
      } else {
         this.bienTravauxEntete = this.annuleTravauxImmobilier();
      }

      return this.bienTravauxEntete;
   }

   public void selectionTravauxImobilier() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.bienTravauxEntete = (BienTravauxEntete)var1.get(0);
            this.selectTravauxImmobilier = true;
         } else {
            this.selectTravauxImmobilier = false;
         }
      } else {
         this.selectTravauxImmobilier = false;
      }

   }

   public BienTravauxEntete annuleTravauxImmobilier() {
      this.bienTravauxEntete = null;
      return this.bienTravauxEntete;
   }

   public BienTravauxEntete calculeTravauxImmobilier() throws JDOMException, IOException {
      return this.bienTravauxEntete;
   }

   public Taches rechercheTaches(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectTaches = false;
      if (var1 != null && !var1.isEmpty()) {
         this.lesTaches = new ArrayList();
         this.tachesDao = new TachesDao(this.baseLog, this.utilInitHibernate);
         this.lesTaches = this.tachesDao.selectTachesActif(var1, (Session)null);
         if (this.lesTaches.size() == 1) {
            this.taches = (Taches)this.lesTaches.get(0);
            this.calculeTaches();
         } else if (this.lesTaches.size() > 1) {
            this.datamodelTaches.setWrappedData(this.lesTaches);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.taches = new Taches();
         } else {
            this.taches = this.annuleTaches();
         }
      } else {
         this.taches = this.annuleTaches();
      }

      return this.taches;
   }

   public void selectionTaches() throws JDOMException, IOException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.taches = (Taches)var1.get(0);
            this.selectTaches = true;
         } else {
            this.selectTaches = false;
         }
      } else {
         this.selectTaches = false;
      }

   }

   public Taches annuleTaches() {
      this.taches = null;
      return this.taches;
   }

   public Taches calculeTaches() throws JDOMException, IOException {
      return this.taches;
   }

   public Patients recherchePatients(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectPatients = false;
      if (var1 != null && !var1.isEmpty()) {
         new ArrayList();
         this.patientsDao = new PatientsDao(this.baseLog, this.utilInitHibernate);
         List var3 = this.patientsDao.chargerlesPatients(var1, (Session)null);
         if (var3.size() == 1) {
            this.patients = (Patients)var3.get(0);
            this.calculeTypeTiers();
         } else if (var3.size() > 1) {
            this.datamodelPatients.setWrappedData(var3);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.patients = new Patients();
         } else {
            this.patients = this.annulePatients();
         }
      } else {
         this.patients = this.annulePatients();
      }

      return this.patients;
   }

   public void selectionlignePatients() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.patients = (Patients)var1.get(0);
            this.calculeTypeTiers();
            this.selectTiers = true;
         } else {
            this.selectTiers = false;
         }
      } else {
         this.selectTiers = false;
      }

   }

   public Patients annulePatients() {
      this.patients = null;
      return this.patients;
   }

   public Patients calculePatients() {
      return this.patients;
   }

   public Eleves rechercheEleves(String var1, int var2) throws JDOMException, IOException, HibernateException, NamingException {
      this.nature = var2;
      this.selectEleves = false;
      if (var1 != null && !var1.isEmpty()) {
         new ArrayList();
         this.elevesDao = new ElevesDao(this.baseLog, this.utilInitHibernate);
         List var3 = this.elevesDao.chargerlesEleves(var1, (Session)null);
         if (var3.size() == 1) {
            this.eleves = (Eleves)var3.get(0);
         } else if (var3.size() > 1) {
            this.datamodelEleves.setWrappedData(var3);
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelection = new SimpleSelection();
            this.simpleSelection.clear();
            this.eleves = new Eleves();
         } else {
            this.eleves = this.annuleEleves();
         }
      } else {
         this.eleves = this.annuleEleves();
      }

      return this.eleves;
   }

   public void selectionligneEleves() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelection.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.eleves = (Eleves)var1.get(0);
            this.calculeTypeTiers();
            this.selectEleves = true;
         } else {
            this.selectEleves = false;
         }
      } else {
         this.selectEleves = false;
      }

   }

   public Eleves annuleEleves() {
      this.eleves = null;
      return this.eleves;
   }

   public Eleves calculeEleves() {
      return this.eleves;
   }

   public String getMessageTexte() throws IOException, JDOMException {
      if (this.usersLog != null && this.structureLog != null && StaticModePegase.getInternet_actif() != 0 && this.usersLog.getUsrAssistant() != 0) {
         LectureMessageVocalUser var1 = new LectureMessageVocalUser();
         new ArrayList();
         String var3 = "" + (new Date()).getHours();
         String var4 = "";
         if ((new Date()).getHours() <= 9) {
            var4 = "0" + (new Date()).getHours();
         } else {
            var4 = "" + (new Date()).getHours();
         }

         if ((new Date()).getMinutes() <= 9) {
            var4 = var4 + ":0" + (new Date()).getMinutes();
         } else {
            var4 = var4 + ":" + (new Date()).getMinutes();
         }

         UtilDate var5 = new UtilDate();
         String var6 = var5.dateToStringSQLLight(new Date());
         var1.recupererMessageVocalUser(this.structureLog.getStrid(), this.usersLog.getUsrid(), var6);
         List var2 = var1.getLesMessagesVaocauxUsers();
         boolean var7 = false;
         if (var2.size() != 0) {
            for(int var8 = 0; var8 < var2.size(); ++var8) {
               if (((ObjetMessageVocalUser)var2.get(var8)).getTime().equals(var4) && ((ObjetMessageVocalUser)var2.get(var8)).getCondit1().equals("Alerte") && ((ObjetMessageVocalUser)var2.get(var8)).getMessage().equals(this.messageTexte)) {
                  var7 = true;
                  break;
               }
            }
         }

         if (!var7) {
            var1.ecritureMessageUser(this.structureLog.getStrid(), this.usersLog.getUsrid(), "Alerte", "", var6, var3, var4, this.messageTexte, var2);
         }
      }

      return this.messageTexte;
   }

   public void setMessageTexte(String var1) {
      this.messageTexte = var1;
   }

   public void fermerMessage() {
      this.showModalPanelMessage = false;
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public DataModel getDatamodelTiers() {
      return this.datamodelTiers;
   }

   public void setDatamodelTiers(DataModel var1) {
      this.datamodelTiers = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public boolean isSelectTiers() {
      return this.selectTiers;
   }

   public void setSelectTiers(boolean var1) {
      this.selectTiers = var1;
   }

   public DataModel getDatamodelDestinataire() {
      return this.datamodelDestinataire;
   }

   public void setDatamodelDestinataire(DataModel var1) {
      this.datamodelDestinataire = var1;
   }

   public boolean isSelectDestinataire() {
      return this.selectDestinataire;
   }

   public void setSelectDestinataire(boolean var1) {
      this.selectDestinataire = var1;
   }

   public PlansAnalytiques getPlansAnalytiques() {
      return this.plansAnalytiques;
   }

   public void setPlansAnalytiques(PlansAnalytiques var1) {
      this.plansAnalytiques = var1;
   }

   public DataModel getDatamodelResponsable() {
      return this.datamodelResponsable;
   }

   public void setDatamodelResponsable(DataModel var1) {
      this.datamodelResponsable = var1;
   }

   public Users getResponsable() {
      return this.responsable;
   }

   public void setResponsable(Users var1) {
      this.responsable = var1;
   }

   public boolean isSelectResponsable() {
      return this.selectResponsable;
   }

   public void setSelectResponsable(boolean var1) {
      this.selectResponsable = var1;
   }

   public boolean isVar_typeTiers() {
      return this.var_typeTiers;
   }

   public void setVar_typeTiers(boolean var1) {
      this.var_typeTiers = var1;
   }

   public DataModel getDatamodelProduits() {
      return this.datamodelProduits;
   }

   public void setDatamodelProduits(DataModel var1) {
      this.datamodelProduits = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public boolean isSelectProduits() {
      return this.selectProduits;
   }

   public void setSelectProduits(boolean var1) {
      this.selectProduits = var1;
   }

   public boolean isShowModalPanelDupProduit() {
      return this.showModalPanelDupProduit;
   }

   public void setShowModalPanelDupProduit(boolean var1) {
      this.showModalPanelDupProduit = var1;
   }

   public Produits getProduitsDuppliquer() {
      return this.produitsDuppliquer;
   }

   public void setProduitsDuppliquer(Produits var1) {
      this.produitsDuppliquer = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public DataModel getDatamodelDossier() {
      return this.datamodelDossier;
   }

   public void setDatamodelDossier(DataModel var1) {
      this.datamodelDossier = var1;
   }

   public PlansAnalytiques getDossier() {
      return this.dossier;
   }

   public void setDossier(PlansAnalytiques var1) {
      this.dossier = var1;
   }

   public boolean isSelectDossier() {
      return this.selectDossier;
   }

   public void setSelectDossier(boolean var1) {
      this.selectDossier = var1;
   }

   public boolean isShowModalPanelAddDossier() {
      return this.showModalPanelAddDossier;
   }

   public void setShowModalPanelAddDossier(boolean var1) {
      this.showModalPanelAddDossier = var1;
   }

   public boolean isDossierExiste() {
      return this.dossierExiste;
   }

   public void setDossierExiste(boolean var1) {
      this.dossierExiste = var1;
   }

   public boolean isProduitExiste() {
      return this.produitExiste;
   }

   public void setProduitExiste(boolean var1) {
      this.produitExiste = var1;
   }

   public Contacts getContacts() {
      return this.contacts;
   }

   public void setContacts(Contacts var1) {
      this.contacts = var1;
   }

   public DataModel getDatamodelContact() {
      return this.datamodelContact;
   }

   public void setDatamodelContact(DataModel var1) {
      this.datamodelContact = var1;
   }

   public List getMesAppreciationsItems() {
      return this.mesAppreciationsItems;
   }

   public void setMesAppreciationsItems(List var1) {
      this.mesAppreciationsItems = var1;
   }

   public List getMesCivilitesItems() {
      return this.mesCivilitesItems;
   }

   public void setMesCivilitesItems(List var1) {
      this.mesCivilitesItems = var1;
   }

   public List getMesLangueItems() {
      return this.mesLangueItems;
   }

   public void setMesLangueItems(List var1) {
      this.mesLangueItems = var1;
   }

   public List getMesPaysItems() {
      return this.mesPaysItems;
   }

   public void setMesPaysItems(List var1) {
      this.mesPaysItems = var1;
   }

   public boolean isShowModalPanelContact() {
      return this.showModalPanelContact;
   }

   public void setShowModalPanelContact(boolean var1) {
      this.showModalPanelContact = var1;
   }

   public boolean isVar_aff_tarif1() {
      return this.var_aff_tarif1;
   }

   public void setVar_aff_tarif1(boolean var1) {
      this.var_aff_tarif1 = var1;
   }

   public boolean isVar_aff_tarif2() {
      return this.var_aff_tarif2;
   }

   public void setVar_aff_tarif2(boolean var1) {
      this.var_aff_tarif2 = var1;
   }

   public boolean isVar_aff_tarif3() {
      return this.var_aff_tarif3;
   }

   public void setVar_aff_tarif3(boolean var1) {
      this.var_aff_tarif3 = var1;
   }

   public boolean isVar_aff_tarif4() {
      return this.var_aff_tarif4;
   }

   public void setVar_aff_tarif4(boolean var1) {
      this.var_aff_tarif4 = var1;
   }

   public boolean isVar_aff_tarif5() {
      return this.var_aff_tarif5;
   }

   public void setVar_aff_tarif5(boolean var1) {
      this.var_aff_tarif5 = var1;
   }

   public String getVar_tarif1() {
      return this.var_tarif1;
   }

   public void setVar_tarif1(String var1) {
      this.var_tarif1 = var1;
   }

   public String getVar_tarif2() {
      return this.var_tarif2;
   }

   public void setVar_tarif2(String var1) {
      this.var_tarif2 = var1;
   }

   public String getVar_tarif3() {
      return this.var_tarif3;
   }

   public void setVar_tarif3(String var1) {
      this.var_tarif3 = var1;
   }

   public String getVar_tarif4() {
      return this.var_tarif4;
   }

   public void setVar_tarif4(String var1) {
      this.var_tarif4 = var1;
   }

   public String getVar_tarif5() {
      return this.var_tarif5;
   }

   public void setVar_tarif5(String var1) {
      this.var_tarif5 = var1;
   }

   public DataModel getDatamodelPlanComptable() {
      return this.datamodelPlanComptable;
   }

   public void setDatamodelPlanComptable(DataModel var1) {
      this.datamodelPlanComptable = var1;
   }

   public boolean isSelectPlanComptable() {
      return this.selectPlanComptable;
   }

   public void setSelectPlanComptable(boolean var1) {
      this.selectPlanComptable = var1;
   }

   public boolean isShowModalPanelCreationCompte() {
      return this.showModalPanelCreationCompte;
   }

   public void setShowModalPanelCreationCompte(boolean var1) {
      this.showModalPanelCreationCompte = var1;
   }

   public List getMesNatureCompteItem() {
      return this.mesNatureCompteItem;
   }

   public void setMesNatureCompteItem(List var1) {
      this.mesNatureCompteItem = var1;
   }

   public List getMesRacineCompteItem() {
      return this.mesRacineCompteItem;
   }

   public void setMesRacineCompteItem(List var1) {
      this.mesRacineCompteItem = var1;
   }

   public String getMaNature() {
      return this.maNature;
   }

   public void setMaNature(String var1) {
      this.maNature = var1;
   }

   public String getMaRacine() {
      return this.maRacine;
   }

   public void setMaRacine(String var1) {
      this.maRacine = var1;
   }

   public String getPartieCompte() {
      return this.partieCompte;
   }

   public void setPartieCompte(String var1) {
      this.partieCompte = var1;
   }

   public String getRacinecle() {
      return this.racinecle;
   }

   public void setRacinecle(String var1) {
      this.racinecle = var1;
   }

   public PlanComptable getPlanComptable() {
      return this.planComptable;
   }

   public void setPlanComptable(PlanComptable var1) {
      this.planComptable = var1;
   }

   public int getNbcarmax() {
      return this.nbcarmax;
   }

   public void setNbcarmax(int var1) {
      this.nbcarmax = var1;
   }

   public int getNombrCaracter() {
      return this.nombrCaracter;
   }

   public void setNombrCaracter(int var1) {
      this.nombrCaracter = var1;
   }

   public boolean isExisteCopteDeja() {
      return this.existeCopteDeja;
   }

   public void setExisteCopteDeja(boolean var1) {
      this.existeCopteDeja = var1;
   }

   public DataModel getDatamodelParc() {
      return this.datamodelParc;
   }

   public void setDatamodelParc(DataModel var1) {
      this.datamodelParc = var1;
   }

   public DataModel getDatamodelSalaries() {
      return this.datamodelSalaries;
   }

   public void setDatamodelSalaries(DataModel var1) {
      this.datamodelSalaries = var1;
   }

   public DataModel getDatamodelReglements() {
      return this.datamodelReglements;
   }

   public void setDatamodelReglements(DataModel var1) {
      this.datamodelReglements = var1;
   }

   public boolean isSelectReglements() {
      return this.selectReglements;
   }

   public void setSelectReglements(boolean var1) {
      this.selectReglements = var1;
   }

   public OptionVentes getOptionVentes() {
      return this.optionVentes;
   }

   public void setOptionVentes(OptionVentes var1) {
      this.optionVentes = var1;
   }

   public DataModel getDatamodelBudgetTresorerie() {
      return this.datamodelBudgetTresorerie;
   }

   public void setDatamodelBudgetTresorerie(DataModel var1) {
      this.datamodelBudgetTresorerie = var1;
   }

   public boolean isSelectBudgetTresorerie() {
      return this.selectBudgetTresorerie;
   }

   public void setSelectBudgetTresorerie(boolean var1) {
      this.selectBudgetTresorerie = var1;
   }

   public boolean isSelectParc() {
      return this.selectParc;
   }

   public void setSelectParc(boolean var1) {
      this.selectParc = var1;
   }

   public boolean isSelectSalaries() {
      return this.selectSalaries;
   }

   public void setSelectSalaries(boolean var1) {
      this.selectSalaries = var1;
   }

   public DataModel getDatamodelSommiers() {
      return this.datamodelSommiers;
   }

   public void setDatamodelSommiers(DataModel var1) {
      this.datamodelSommiers = var1;
   }

   public boolean isSelectSommier() {
      return this.selectSommier;
   }

   public void setSelectSommier(boolean var1) {
      this.selectSommier = var1;
   }

   public boolean isProjetPresent() {
      return this.projetPresent;
   }

   public void setProjetPresent(boolean var1) {
      this.projetPresent = var1;
   }

   public List getMesdevisesItem() {
      return this.mesdevisesItem;
   }

   public void setMesdevisesItem(List var1) {
      this.mesdevisesItem = var1;
   }

   public DataModel getDatamodelSalariesContrats() {
      return this.datamodelSalariesContrats;
   }

   public void setDatamodelSalariesContrats(DataModel var1) {
      this.datamodelSalariesContrats = var1;
   }

   public boolean isSelectSalariesContrat() {
      return this.selectSalariesContrat;
   }

   public void setSelectSalariesContrat(boolean var1) {
      this.selectSalariesContrat = var1;
   }

   public DataModel getDatamodelBiens() {
      return this.datamodelBiens;
   }

   public void setDatamodelBiens(DataModel var1) {
      this.datamodelBiens = var1;
   }

   public boolean isSelectBien() {
      return this.selectBien;
   }

   public void setSelectBien(boolean var1) {
      this.selectBien = var1;
   }

   public Bien getBien() {
      return this.bien;
   }

   public void setBien(Bien var1) {
      this.bien = var1;
   }

   public DataModel getDatamodelTaches() {
      return this.datamodelTaches;
   }

   public void setDatamodelTaches(DataModel var1) {
      this.datamodelTaches = var1;
   }

   public boolean isSelectTaches() {
      return this.selectTaches;
   }

   public void setSelectTaches(boolean var1) {
      this.selectTaches = var1;
   }

   public Taches getTaches() {
      return this.taches;
   }

   public void setTaches(Taches var1) {
      this.taches = var1;
   }

   public boolean isSelectTravauxImmobilier() {
      return this.selectTravauxImmobilier;
   }

   public void setSelectTravauxImmobilier(boolean var1) {
      this.selectTravauxImmobilier = var1;
   }

   public DataModel getDatamodelPatients() {
      return this.datamodelPatients;
   }

   public void setDatamodelPatients(DataModel var1) {
      this.datamodelPatients = var1;
   }

   public DataModel getDatamodelTravauxImmobilier() {
      return this.datamodelTravauxImmobilier;
   }

   public void setDatamodelTravauxImmobilier(DataModel var1) {
      this.datamodelTravauxImmobilier = var1;
   }

   public Patients getPatients() {
      return this.patients;
   }

   public void setPatients(Patients var1) {
      this.patients = var1;
   }

   public OptionMedical getOptionMedical() {
      return this.optionMedical;
   }

   public void setOptionMedical(OptionMedical var1) {
      this.optionMedical = var1;
   }

   public UIDataTable getExtDTable() {
      return this.extDTable;
   }

   public void setExtDTable(UIDataTable var1) {
      this.extDTable = var1;
   }

   public SimpleSelection getSimpleSelection() {
      return this.simpleSelection;
   }

   public void setSimpleSelection(SimpleSelection var1) {
      this.simpleSelection = var1;
   }

   public boolean isShowModalPanelMessage() {
      return this.showModalPanelMessage;
   }

   public void setShowModalPanelMessage(boolean var1) {
      this.showModalPanelMessage = var1;
   }

   public String getConfigListeEntete() {
      return this.configListeEntete;
   }

   public void setConfigListeEntete(String var1) {
      this.configListeEntete = var1;
   }

   public DataModel getDatamodelEleves() {
      return this.datamodelEleves;
   }

   public void setDatamodelEleves(DataModel var1) {
      this.datamodelEleves = var1;
   }

   public boolean isSelectEleves() {
      return this.selectEleves;
   }

   public void setSelectEleves(boolean var1) {
      this.selectEleves = var1;
   }

   public boolean isSelectPatients() {
      return this.selectPatients;
   }

   public void setSelectPatients(boolean var1) {
      this.selectPatients = var1;
   }

   public DataModel getDatamodelActivites() {
      return this.datamodelActivites;
   }

   public void setDatamodelActivites(DataModel var1) {
      this.datamodelActivites = var1;
   }

   public boolean isSelectActivites() {
      return this.selectActivites;
   }

   public void setSelectActivites(boolean var1) {
      this.selectActivites = var1;
   }

   public boolean isSelectChantier() {
      return this.selectChantier;
   }

   public void setSelectChantier(boolean var1) {
      this.selectChantier = var1;
   }

   public List getLesPlanComptable() {
      return this.lesPlanComptable;
   }

   public void setLesPlanComptable(List var1) {
      this.lesPlanComptable = var1;
   }

   public boolean isShowModalPanelAjoutTiers() {
      return this.showModalPanelAjoutTiers;
   }

   public void setShowModalPanelAjoutTiers(boolean var1) {
      this.showModalPanelAjoutTiers = var1;
   }

   public int getTypeTiers() {
      return this.typeTiers;
   }

   public void setTypeTiers(int var1) {
      this.typeTiers = var1;
   }

   public List getMesCategoriesItems() {
      return this.mesCategoriesItems;
   }

   public void setMesCategoriesItems(List var1) {
      this.mesCategoriesItems = var1;
   }

   public boolean isVar_tiersDivers() {
      return this.var_tiersDivers;
   }

   public void setVar_tiersDivers(boolean var1) {
      this.var_tiersDivers = var1;
   }

   public boolean isExistCod() {
      return this.existCod;
   }

   public void setExistCod(boolean var1) {
      this.existCod = var1;
   }

   public boolean isVerouxCod() {
      return this.verouxCod;
   }

   public void setVerouxCod(boolean var1) {
      this.verouxCod = var1;
   }
}
