package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.administration.FormActivitesCommerciales;
import com.epegase.forms.administration.FormActivitesSocietes;
import com.epegase.forms.administration.FormAntecedentCDA;
import com.epegase.forms.administration.FormAppreciations;
import com.epegase.forms.administration.FormBackupDatas;
import com.epegase.forms.administration.FormBanques;
import com.epegase.forms.administration.FormBilanSocialConfigClient;
import com.epegase.forms.administration.FormCabinet;
import com.epegase.forms.administration.FormCaissesCommerciales;
import com.epegase.forms.administration.FormCaissesOperations;
import com.epegase.forms.administration.FormCaracteristiquesParcs;
import com.epegase.forms.administration.FormCategorieExamen;
import com.epegase.forms.administration.FormCcamMedical;
import com.epegase.forms.administration.FormCentresImpots;
import com.epegase.forms.administration.FormCentresSecuriteSociale;
import com.epegase.forms.administration.FormChantiersForet;
import com.epegase.forms.administration.FormChronoAch;
import com.epegase.forms.administration.FormChronoCaisses;
import com.epegase.forms.administration.FormChronoCpta;
import com.epegase.forms.administration.FormChronoEdu;
import com.epegase.forms.administration.FormChronoFdt;
import com.epegase.forms.administration.FormChronoForet;
import com.epegase.forms.administration.FormChronoImm;
import com.epegase.forms.administration.FormChronoInt;
import com.epegase.forms.administration.FormChronoMed;
import com.epegase.forms.administration.FormChronoMef;
import com.epegase.forms.administration.FormChronoOffice;
import com.epegase.forms.administration.FormChronoParcs;
import com.epegase.forms.administration.FormChronoPaye;
import com.epegase.forms.administration.FormChronoVte;
import com.epegase.forms.administration.FormCimMedical;
import com.epegase.forms.administration.FormCivilites;
import com.epegase.forms.administration.FormClassementForet;
import com.epegase.forms.administration.FormClassementMediatheque;
import com.epegase.forms.administration.FormClassementsAgents;
import com.epegase.forms.administration.FormCmaMedical;
import com.epegase.forms.administration.FormCmdMedical;
import com.epegase.forms.administration.FormCodesEmplois;
import com.epegase.forms.administration.FormCommissionsMedecins;
import com.epegase.forms.administration.FormConditionnement;
import com.epegase.forms.administration.FormConventionsCollectives;
import com.epegase.forms.administration.FormCouleur;
import com.epegase.forms.administration.FormDepotAchats;
import com.epegase.forms.administration.FormDestinationMedical;
import com.epegase.forms.administration.FormDevises;
import com.epegase.forms.administration.FormDouanes;
import com.epegase.forms.administration.FormElementRdv;
import com.epegase.forms.administration.FormElementsInfirmerie;
import com.epegase.forms.administration.FormEquipes;
import com.epegase.forms.administration.FormEssenceForet;
import com.epegase.forms.administration.FormEtatFinancierConfigClient;
import com.epegase.forms.administration.FormExercicesAchats;
import com.epegase.forms.administration.FormExercicesCaisse;
import com.epegase.forms.administration.FormExercicesComptables;
import com.epegase.forms.administration.FormExercicesEducation;
import com.epegase.forms.administration.FormExercicesFondation;
import com.epegase.forms.administration.FormExercicesForet;
import com.epegase.forms.administration.FormExercicesImmobilier;
import com.epegase.forms.administration.FormExercicesInterim;
import com.epegase.forms.administration.FormExercicesMedical;
import com.epegase.forms.administration.FormExercicesMicrofinance;
import com.epegase.forms.administration.FormExercicesParcs;
import com.epegase.forms.administration.FormExercicesPaye;
import com.epegase.forms.administration.FormExercicesVentes;
import com.epegase.forms.administration.FormFamilleClient;
import com.epegase.forms.administration.FormFamilleFournisseur;
import com.epegase.forms.administration.FormFamilleParcs;
import com.epegase.forms.administration.FormFamilleProduitsAchats;
import com.epegase.forms.administration.FormFamilleProduitsVentes;
import com.epegase.forms.administration.FormFeuilleCalcul;
import com.epegase.forms.administration.FormFilieres;
import com.epegase.forms.administration.FormFonctions;
import com.epegase.forms.administration.FormFormesJuridiques;
import com.epegase.forms.administration.FormFormulesAchats;
import com.epegase.forms.administration.FormFormulesVentes;
import com.epegase.forms.administration.FormFraisTheoAchats;
import com.epegase.forms.administration.FormGestionRepertoire;
import com.epegase.forms.administration.FormGroupe;
import com.epegase.forms.administration.FormHabilitation;
import com.epegase.forms.administration.FormIncoterm;
import com.epegase.forms.administration.FormInfoSysteme;
import com.epegase.forms.administration.FormJournauxComptables;
import com.epegase.forms.administration.FormLettreMedical;
import com.epegase.forms.administration.FormLocalisationImmobilisation;
import com.epegase.forms.administration.FormLocalisationSalarie;
import com.epegase.forms.administration.FormMarques;
import com.epegase.forms.administration.FormModelesCourriersPaye;
import com.epegase.forms.administration.FormModelesCourriersVentes;
import com.epegase.forms.administration.FormModelesDevisVentes;
import com.epegase.forms.administration.FormModelesEcritures;
import com.epegase.forms.administration.FormMotifEntreeMedical;
import com.epegase.forms.administration.FormMotifEntreeParc;
import com.epegase.forms.administration.FormMotifSortieMedical;
import com.epegase.forms.administration.FormMotifentreeConsultMedical;
import com.epegase.forms.administration.FormNaturesAffaires;
import com.epegase.forms.administration.FormNaturesBiens;
import com.epegase.forms.administration.FormNaturesComptes;
import com.epegase.forms.administration.FormNaturesCourrier;
import com.epegase.forms.administration.FormNaturesDemande;
import com.epegase.forms.administration.FormNaturesFamillesProduitsAchats;
import com.epegase.forms.administration.FormNaturesFamillesProduitsMedical;
import com.epegase.forms.administration.FormNaturesFamillesProduitsParcs;
import com.epegase.forms.administration.FormNaturesFamillesProduitsVentes;
import com.epegase.forms.administration.FormNaturesInterim;
import com.epegase.forms.administration.FormNaturesJournaux;
import com.epegase.forms.administration.FormNaturesManifest;
import com.epegase.forms.administration.FormNaturesMissions;
import com.epegase.forms.administration.FormNaturesPrets;
import com.epegase.forms.administration.FormNaturesRH;
import com.epegase.forms.administration.FormNaturesRdv;
import com.epegase.forms.administration.FormNaturesSalarie;
import com.epegase.forms.administration.FormNgapMedical;
import com.epegase.forms.administration.FormNiveauxEmplois;
import com.epegase.forms.administration.FormOptionComptabilite;
import com.epegase.forms.administration.FormOptionsAchats;
import com.epegase.forms.administration.FormOptionsCaisse;
import com.epegase.forms.administration.FormOptionsMedical;
import com.epegase.forms.administration.FormOptionsOffice;
import com.epegase.forms.administration.FormOptionsParc;
import com.epegase.forms.administration.FormOptionsPaye;
import com.epegase.forms.administration.FormOptionsStocks;
import com.epegase.forms.administration.FormOptionsVentes;
import com.epegase.forms.administration.FormOrganisationAdministrative;
import com.epegase.forms.administration.FormOrganisationCommerciale;
import com.epegase.forms.administration.FormOrganisationProduction;
import com.epegase.forms.administration.FormPathologieMedical;
import com.epegase.forms.administration.FormPays;
import com.epegase.forms.administration.FormPlanComptable;
import com.epegase.forms.administration.FormPlanPaye;
import com.epegase.forms.administration.FormPlanProjets;
import com.epegase.forms.administration.FormPlanningAvicultureAchats;
import com.epegase.forms.administration.FormPlansAnalytiques;
import com.epegase.forms.administration.FormPlansBudgetaires;
import com.epegase.forms.administration.FormPlansTresorerie;
import com.epegase.forms.administration.FormProcessAchats;
import com.epegase.forms.administration.FormProduitsMedicamment;
import com.epegase.forms.administration.FormProtocoleMedical;
import com.epegase.forms.administration.FormProvenanceMedical;
import com.epegase.forms.administration.FormPublicationProduits;
import com.epegase.forms.administration.FormRacines;
import com.epegase.forms.administration.FormReglementClient;
import com.epegase.forms.administration.FormReglementFournisseur;
import com.epegase.forms.administration.FormSourcesTiers;
import com.epegase.forms.administration.FormSpecialitesMedical;
import com.epegase.forms.administration.FormStructureEntete;
import com.epegase.forms.administration.FormSuiviLivraisonVentes;
import com.epegase.forms.administration.FormTache;
import com.epegase.forms.administration.FormTaxesAchat;
import com.epegase.forms.administration.FormTaxesVentes;
import com.epegase.forms.administration.FormTiersTechnique;
import com.epegase.forms.administration.FormTransitLieuVentes;
import com.epegase.forms.administration.FormTransitPortVentes;
import com.epegase.forms.administration.FormTypeReglement;
import com.epegase.forms.administration.FormTypeTiers;
import com.epegase.forms.administration.FormUnite;
import com.epegase.forms.administration.FormUsers;
import com.epegase.forms.commun.FormConfigImprDocument;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.ventes.FormProduitsVtes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.Module;
import com.epegase.systeme.dao.BalDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesParcsDao;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.fileUtil.FileRep;
import com.epegase.systeme.menu.MenuListe;
import com.epegase.systeme.menu.MenuModule;
import com.epegase.systeme.menu.MenudroitAdministrationCtrl;
import com.epegase.systeme.menu.MenudroitCoAdministrationCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.utilitaires.FormUtilitaires;
import com.epegase.systeme.xml.LectureFormesJuridiques;
import com.epegase.systeme.xml.LectureImmatriculation;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LectureTypesSocietes;
import com.epegase.systeme.xml.LectureZonesCommerciales;
import com.epegase.systeme.xml.LectureZonesFiscales;
import com.epegase.systeme.xml.LireLesoptionsAchats;
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.LireLesoptionsCompta;
import com.epegase.systeme.xml.LireLesoptionsMedical;
import com.epegase.systeme.xml.LireLesoptionsParcs;
import com.epegase.systeme.xml.LireLesoptionsPaye;
import com.epegase.systeme.xml.LireLesoptionsStocks;
import com.epegase.systeme.xml.LireLesoptionsTiers;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetImmatriculation;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionCaisses;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionMedical;
import com.epegase.systeme.xml.OptionParcs;
import com.epegase.systeme.xml.OptionPaye;
import com.epegase.systeme.xml.OptionStocks;
import com.epegase.systeme.xml.OptionTiers;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
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
import org.jdom.JDOMException;
import org.xml.sax.SAXException;

public class FormBakingBeanAdministration implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private MenuListe menuAdministration;
   private ObjetLigneMenu menuadministration;
   private LectureModulesOnglets lesOnglets;
   private MenudroitAdministrationCtrl menudroitAdministrationCtrl;
   private MenudroitCoAdministrationCtrl menudroitCoAdministrationCtrl;
   private String affichePage;
   private UserDao userDao;
   private EspionDao espionDao;
   private FormGroupe formGroupe;
   private MenuModule menuModule = new MenuModule();
   private FormRecherche formRecherche;
   private List mesPeriodesItems = new ArrayList();
   private EtatDocument etatDocument = new EtatDocument();
   private LectureZonesCommerciales zoneCommerciale;
   private LectureZonesFiscales zonesFiscales;
   private LectureFormesJuridiques formJuridique;
   private LectureTypesSocietes typeSociete;
   private FormStructureEntete formStructureEntete;
   private BalDao balDao;
   private transient ListDataModel datamodelBal;
   private String lienPanel = "";
   private LectureZonesFiscales zoneFiscales;
   private FormOrganisationAdministrative formOrganisationAdministrative;
   private FormOrganisationCommerciale formOrganisationCommerciale;
   private FormOrganisationProduction formOrganisationProduction;
   private FormActivitesCommerciales formActivitesCommerciales;
   private FormEquipes formEquipes;
   private FormInfoSysteme formInfoSysteme;
   private String nomStructureEnCours;
   private FormUsers formUsers;
   private boolean ongCompta;
   private String libelleMod;
   private boolean ongPay;
   private boolean ongParc;
   private boolean ongAchat;
   private int ongSuiviCom;
   private String CodeMod;
   private boolean ongCaisse;
   private transient DataModel dataModelMenuHorizontal;
   private String mods;
   private transient DataModel dataModelModuleParam;
   private String choixModule = "";
   private long selectedExo = 0L;
   private int taille = 0;
   private String choixLigne;
   private FormCouleur formCouleur;
   private FormIncoterm formIncoterm;
   private FormMarques formMarques;
   private FormConditionnement formConditionnement;
   private FormUnite formUnite;
   private FormDouanes formDouanes;
   private FormConfigImprDocument formConfigImprDocument;
   private FormDevises formDevises;
   private FormAppreciations formAppreciations;
   private FormCivilites formCivilites;
   private FormSourcesTiers formSourcesTiers;
   private FormTypeTiers formCategoriesTiers;
   private FormFonctions formFonctions;
   private FormFormesJuridiques formFormesJuridiques;
   private FormPays formPays;
   private FormFamilleClient formFamilleClient;
   private FormTache formTache;
   private OptionTiers optionTiers;
   private FormFamilleFournisseur formFamilleFournisseur;
   private FormReglementClient formReglementClient;
   private FormReglementFournisseur formReglementFournisseur;
   private FormTypeReglement formTypeReglement;
   private FormActivitesSocietes formActivitesSocietes;
   private FormTiersTechnique formTiersTechnique;
   private FormBanques formBanques;
   private FormOptionsOffice formOptionTiers;
   private FormChronoOffice formChronoOffice;
   private FormGestionRepertoire formGestionRepertoire;
   private FormNaturesCourrier formNaturesCourrier;
   private FormNaturesAffaires formNaturesAffaires;
   private FormElementRdv formElementRdv;
   private FormNaturesRdv formNaturesRdv;
   private ExercicesAchatsDao exercicesAchatsDao;
   private FormExercicesAchats formExercicesAchats;
   private OptionAchats optionAchats;
   private OptionStocks optionStocks;
   private FormDepotAchats formDepotAchats;
   private FormChronoAch formChronoAch;
   private FormTaxesAchat formTaxesAchat;
   private FormNaturesFamillesProduitsAchats formNatProdAchats;
   private FormFamilleProduitsAchats formFamilleProdAchats;
   private FormFormulesAchats formFormulesAchats;
   private FormOptionsAchats formOptionsAchats;
   private FormOptionsStocks formOptionsStocks;
   private FormFraisTheoAchats formFraisTheoAchats;
   private FormProcessAchats formProcessAchats;
   private FormPlanningAvicultureAchats formPlanningAvicultureAchats;
   private ExercicesVentesDao exercicesVentesDao;
   private FormExercicesVentes formExercicesVentes;
   private OptionVentes optionsVentes;
   private FormChronoVte formChronoVte;
   private FormTaxesVentes formTaxesVentes;
   private FormNaturesFamillesProduitsVentes formNaturesFamillesProduits;
   private FormFamilleProduitsVentes formFamillesProduitsVentes;
   private FormSuiviLivraisonVentes formSuiviLivraisonVentes;
   private FormFormulesVentes formFormulesVentes;
   private FormProduitsVtes formProduitsVtes;
   private FormOptionsVentes formOptionsVentes;
   private FormPublicationProduits formPublicationProduits;
   private FormModelesCourriersVentes formModelesCourriersVentes;
   private FormNaturesMissions formNaturesMissions;
   private FormModelesDevisVentes formModelesDevisVentes;
   private FormExercicesMedical formExercicesMedical;
   private OptionMedical optionMedical;
   private FormChronoMed formChronoMed;
   private FormProtocoleMedical formProtocoleMedical;
   private FormNaturesFamillesProduitsMedical formNaturesFamillesProduitsMedical;
   private FormLettreMedical formLettreMedical;
   private FormMotifEntreeMedical formMotifEntreeMedical;
   private FormMotifSortieMedical formMotifSortieMedical;
   private FormProvenanceMedical formProvenanceMedical;
   private FormDestinationMedical formDestinationMedical;
   private FormCategorieExamen formCategorieExamen;
   private FormSpecialitesMedical formSpecialitesMedical;
   private FormCmdMedical formCmdMedical;
   private FormNgapMedical formNgapMedical;
   private FormCimMedical formCimMedical;
   private FormCcamMedical formCcamMedical;
   private FormCmaMedical formCmaMedical;
   private FormOptionsMedical formOptionsMedical;
   private FormAntecedentCDA formAntecedentCDA;
   private FormPathologieMedical formPathologieMedical;
   private FormMotifentreeConsultMedical formMotifentreeConsultMedical;
   private FormProduitsMedicamment formMedicamment;
   private FormCommissionsMedecins formCommissionsMedecins;
   private FormElementsInfirmerie formElementsInfirmerie;
   private ExercicesCaisseDao exercicesCaisseDao;
   private FormExercicesCaisse formExercicesCaisse;
   private OptionCaisses optionCaisses;
   private FormCaissesCommerciales formCaissesCommerciales;
   private FormChronoCaisses formChronoCaisses;
   private FormOptionsCaisse formOptionsCaisse;
   private FormCaissesOperations formCaissesOperations;
   private ExercicesComptableDao exercicesComptableDao;
   private FormExercicesComptables formExercicesComptables;
   private FormOptionComptabilite formOptionComptabilite;
   private FormPlanComptable formPlanComptable;
   private FormRacines formRacines;
   private OptionComptabilite optionComptabilite;
   private FormNaturesComptes formNaturesCompte;
   private FormNaturesJournaux formNaturesJournaux;
   private FormChronoCpta formChronoCpta;
   private FormJournauxComptables formJournauxComptables;
   private FormPlansBudgetaires formPlansBudgetaires;
   private FormPlansAnalytiques formPlansAnalytiques;
   private FormEtatFinancierConfigClient formEtatFinancierConfigClient;
   private FormPlanProjets formPlanProjets;
   private FormPlansTresorerie formPlansTresorerie;
   private FormLocalisationImmobilisation formLocalisationImmobilisation;
   private FormModelesEcritures formModelesEcritures;
   private ExercicesParcsDao exercicesParcsDao;
   private FormExercicesParcs formExercicesParcs;
   private FormOptionsParc formOptionsParc;
   private OptionParcs optionParcs;
   private FormChronoParcs formChronoParcs;
   private FormNaturesFamillesProduitsParcs formNaturesFamillesProduitsParcs;
   private FormFamilleParcs formFamilleParcs;
   private FormCaracteristiquesParcs formCaracteristiquesParcs;
   private FormMotifEntreeParc formMotifEntreeParc;
   private FormNaturesManifest formNaturesManifest;
   private ExercicesPayeDao exercicesPayeDao;
   private FormExercicesPaye formExercicesPaye;
   private FormOptionsPaye formOptionsPaye;
   private OptionPaye optionPaye;
   private FormChronoPaye formChronoPaye;
   private FormNaturesSalarie formNaturesSalarie;
   private FormCentresImpots formCentresImpots;
   private FormCentresSecuriteSociale formCentresSecuriteSociale;
   private FormClassementsAgents formClassementsAgents;
   private FormNiveauxEmplois formNiveauxEmplois;
   private FormCodesEmplois formCodesEmplois;
   private FormConventionsCollectives formConventionsCollectives;
   private FormModelesCourriersPaye formModelesCourriersPaye;
   private FormPlanPaye formPlanPaye;
   private FormFeuilleCalcul formFeuilleCalcul;
   private FormBilanSocialConfigClient formBilanSocialConfigClient;
   private FormLocalisationSalarie formLocalisationSalarie;
   private FormNaturesPrets formNaturesPrets;
   private FormNaturesRH formNaturesRH;
   private FormExercicesImmobilier formExercicesImmobilier;
   private FormChronoImm formChronoImm;
   private FormNaturesBiens formNaturesBiens;
   private FormExercicesInterim formExercicesInterim;
   private FormNaturesInterim formNaturesInterim;
   private FormChronoInt formChronoInt;
   private FormExercicesEducation formExercicesEducation;
   private FormChronoEdu formChronoEdu;
   private FormFilieres formFilieres;
   private FormClassementMediatheque formClassementMediatheque;
   private FormExercicesMicrofinance formExercicesMicrofinance;
   private FormChronoMef formChronoMef;
   private FormExercicesFondation formExercicesFondation;
   private FormChronoFdt formChronoFdt;
   private FormNaturesDemande formNaturesDemande;
   private FormExercicesForet formExercicesForet;
   private FormChronoForet formChronoForet;
   private FormEssenceForet formEssenceForet;
   private FormClassementForet formClassementForet;
   private FormChantiersForet formChantiersForet;
   private FormCabinet formCabinet;
   private FormTransitLieuVentes formTransitLieuVentes;
   private FormTransitPortVentes formTransitPortVentes;
   private List mesJournauxComptables = new ArrayList();
   private FormHabilitation formHabilitation;
   private int var_currentValue;
   private String var_info;
   private boolean var_showBarProg = false;
   private FormBackupDatas formBackupDatas;
   private FormUtilitaires formUtilitaires;
   private String format;
   private UtilPrint utilPrint;
   private List lesStructuresPeg;

   public FormBakingBeanAdministration() throws IOException, JDOMException, ParseException {
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void InstancesDaoUtilses() throws IOException, SAXException, JDOMException, ParseException {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.exercicesAchatsDao = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.exercicesVentesDao = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesCaisseDao = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
      this.exercicesComptableDao = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      this.exercicesParcsDao = new ExercicesParcsDao(this.baseLog, this.utilInitHibernate);
   }

   public void menuGaucheAdministration() throws JDOMException, IOException {
      if (this.menudroitAdministrationCtrl == null) {
         this.menudroitAdministrationCtrl = new MenudroitAdministrationCtrl();
         this.menudroitAdministrationCtrl.setStrId(this.structureLog.getStrid());
         this.menudroitAdministrationCtrl.setStructureLog(this.structureLog);
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         boolean var1 = this.verifModuleInstalle("40300");
         this.menudroitAdministrationCtrl.chargerMenuAdministrationXml(this.usersLog.getUsrCollaboration(), var1);
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("00100", this.usersLog.getUsrCollaboration());
   }

   public void menuGaucheCoAdministration() throws JDOMException, IOException {
      if (this.menudroitCoAdministrationCtrl == null) {
         this.menudroitCoAdministrationCtrl = new MenudroitCoAdministrationCtrl();
         this.menudroitCoAdministrationCtrl.setBaseLog(this.baseLog);
         this.menudroitCoAdministrationCtrl.setStructureLog(this.structureLog);
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         boolean var1 = this.verifModuleInstalle("40300");
         this.menudroitCoAdministrationCtrl.chargerMenuCoAdministrationXml(this.usersLog.getUsrid(), var1);
      }

   }

   public void razMemoire() {
      this.formActivitesCommerciales = null;
      this.formActivitesSocietes = null;
      this.formAntecedentCDA = null;
      this.formAppreciations = null;
      this.formBackupDatas = null;
      this.formCabinet = null;
      this.formCaissesCommerciales = null;
      this.formCaissesOperations = null;
      this.formCaracteristiquesParcs = null;
      this.formCategoriesTiers = null;
      this.formCcamMedical = null;
      this.formCentresImpots = null;
      this.formChronoAch = null;
      this.formChronoCaisses = null;
      this.formChronoCpta = null;
      this.formChronoEdu = null;
      this.formChronoImm = null;
      this.formChronoInt = null;
      this.formChronoMed = null;
      this.formChronoOffice = null;
      this.formChronoParcs = null;
      this.formChronoPaye = null;
      this.formChronoVte = null;
      this.formCimMedical = null;
      this.formCivilites = null;
      this.formClassementsAgents = null;
      this.formCmaMedical = null;
      this.formCmdMedical = null;
      this.formConditionnement = null;
      this.formConfigImprDocument = null;
      this.formConventionsCollectives = null;
      this.formCouleur = null;
      this.formDepotAchats = null;
      this.formDestinationMedical = null;
      this.formDevises = null;
      this.formDouanes = null;
      this.formEquipes = null;
      this.formEtatFinancierConfigClient = null;
      this.formFamilleClient = null;
      this.formFamilleFournisseur = null;
      this.formFamilleParcs = null;
      this.formFamilleProdAchats = null;
      this.formFamillesProduitsVentes = null;
      this.formFeuilleCalcul = null;
      this.formFonctions = null;
      this.formFormesJuridiques = null;
      this.formFormulesAchats = null;
      this.formFormulesVentes = null;
      this.formFraisTheoAchats = null;
      this.formGestionRepertoire = null;
      this.formGroupe = null;
      this.formHabilitation = null;
      this.formIncoterm = null;
      this.formInfoSysteme = null;
      this.formJournauxComptables = null;
      this.formJuridique = null;
      this.formLettreMedical = null;
      this.formMarques = null;
      this.formMedicamment = null;
      this.formModelesCourriersPaye = null;
      this.formModelesCourriersVentes = null;
      this.formMotifEntreeMedical = null;
      this.formMotifEntreeParc = null;
      this.formMotifSortieMedical = null;
      this.formMotifentreeConsultMedical = null;
      this.formNatProdAchats = null;
      this.formNaturesBiens = null;
      this.formNaturesCompte = null;
      this.formNaturesFamillesProduits = null;
      this.formNaturesFamillesProduitsMedical = null;
      this.formNaturesFamillesProduitsParcs = null;
      this.formNaturesInterim = null;
      this.formNaturesJournaux = null;
      this.formNaturesSalarie = null;
      this.formNgapMedical = null;
      this.formNiveauxEmplois = null;
      this.formOptionComptabilite = null;
      this.formOptionTiers = null;
      this.formOptionsAchats = null;
      this.formOptionsCaisse = null;
      this.formOptionsMedical = null;
      this.formOptionsParc = null;
      this.formOptionsPaye = null;
      this.formOptionsStocks = null;
      this.formOptionsVentes = null;
      this.formOrganisationAdministrative = null;
      this.formOrganisationCommerciale = null;
      this.formOrganisationProduction = null;
      this.formPathologieMedical = null;
      this.formPays = null;
      this.formPlanComptable = null;
      this.formPlanPaye = null;
      this.formPlanProjets = null;
      this.formPlansAnalytiques = null;
      this.formPlansBudgetaires = null;
      this.formPlansTresorerie = null;
      this.formProcessAchats = null;
      this.formProduitsVtes = null;
      this.formProtocoleMedical = null;
      this.formProvenanceMedical = null;
      this.formPublicationProduits = null;
      this.formRacines = null;
      this.formReglementClient = null;
      this.formReglementFournisseur = null;
      this.formSourcesTiers = null;
      this.formSpecialitesMedical = null;
      this.formStructureEntete = null;
      this.formSuiviLivraisonVentes = null;
      this.formTache = null;
      this.formTaxesAchat = null;
      this.formTaxesVentes = null;
      this.formTiersTechnique = null;
      this.formTypeReglement = null;
      this.formUnite = null;
      this.formUsers = null;
      this.formUtilitaires = null;
   }

   public void gestionAdministration(String var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, SQLException, ClassNotFoundException, ParseException {
      this.razMemoire();
      this.nomStructureEnCours = this.structureLog.getStrraisonsociale();
      this.urlExplorateur = var1;
      this.menuadministration = new ObjetLigneMenu();
      if (this.menudroitAdministrationCtrl.getDataModelMenudroitAdministrationXmlList().isRowAvailable()) {
         this.menuadministration = (ObjetLigneMenu)this.menudroitAdministrationCtrl.getDataModelMenudroitAdministrationXmlList().getRowData();
         if (this.menuadministration.getLibelle_FR() != null && !this.menuadministration.getLibelle_FR().isEmpty()) {
            if (this.menuadministration.getCommande().equalsIgnoreCase("00100:01")) {
               this.affichePage = "/administration/entetesociete.jsp";
               this.menuEnteteSociete();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:02")) {
               this.affichePage = "/administration/organisationadministrative.jsp";
               this.menuOrganisationAdministrative();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:03")) {
               if (this.typeVente == 813) {
                  this.affichePage = "/administration/organisationcommercialeComplete.jsp";
               } else {
                  this.affichePage = "/administration/organisationcommerciale.jsp";
               }

               this.menuOrganisationCommerciale();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:04")) {
               this.affichePage = "/administration/organisationproduction.jsp";
               this.menuOrganisationProduction();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:05")) {
               this.affichePage = "/administration/activitescommerciales.jsp";
               this.menuActivitesCommerciales();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:16")) {
               this.affichePage = "/administration/projets.jsp";
               this.menuProjets();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:15")) {
               this.affichePage = "/administration/equipes.jsp";
               this.menuEquipes();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:06")) {
               this.affichePage = "/administration/groupe.jsp";
               this.menuGroupe();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:07")) {
               this.affichePage = "/administration/utilisateurInit.jsp";
               this.menuUtilisateurs();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:070")) {
               this.affichePage = "/administration/imputationsUsersInit.jsp";
               this.menuImputationUsers();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:08")) {
               this.affichePage = "/administration/infosysteme.jsp";
               this.menuInfoSys();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:09")) {
               this.affichePage = "/administration/administration.jsp";
               this.choixModule = "";
               this.selectedExo = 0L;
               this.taille = 0;
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:10")) {
               this.affichePage = "/administration/backupDatas.jsp";
               this.menuBackupData();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:14")) {
               this.affichePage = "/administration/scripts.jsp";
               this.menuScript();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:11")) {
               this.affichePage = "/administration/antivirus.jsp";
               this.menuAntivirus();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:12")) {
               this.affichePage = "/utilitaires/utilitairesMaintenances.jsp";
               this.menuUtilitaires();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:13")) {
               this.affichePage = "/administration/testInternet.jsp";
               this.menuBandePassante();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:130")) {
               this.affichePage = "/administration/testInfoPc.jsp";
               this.menuIofoPC();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:17")) {
               this.affichePage = "/administration/testJava.jsp";
               this.menuJava();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:180")) {
               this.affichePage = "/administration/configurationTiers.jsp";
               this.menuConfigurationTiers();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:181")) {
               this.affichePage = "/administration/codageMD5.jsp";
               this.menuCodageMD5();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:18")) {
               this.affichePage = "/administration/teleAssistance.jsp";
               this.menuTeleAssistance();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:19")) {
               this.affichePage = "/administration/cabinet.jsp";
               this.menuCabinet();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:20")) {
               this.affichePage = "/administration/imagesStartup.jsp";
               this.menuImageStartup();
            }
         }
      }

   }

   public void gestionCoAdministration(String var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, SQLException, ParseException, ParseException, ClassNotFoundException, MalformedURLException, ClassNotFoundException, groovyjarjarcommonscli.ParseException {
      this.razMemoire();
      Module var2 = new Module();
      this.choixModule = "moduleLigne";
      this.affichePage = "/administration/administration.jsp";
      this.menuadministration = new ObjetLigneMenu();
      if (this.menudroitCoAdministrationCtrl.getDataModelMenudroitCoAdministrationXmlList().isRowAvailable()) {
         this.menuadministration = (ObjetLigneMenu)this.menudroitCoAdministrationCtrl.getDataModelMenudroitCoAdministrationXmlList().getRowData();
         if (this.menuadministration.getLibelle_FR() != null && !this.menuadministration.getLibelle_FR().isEmpty()) {
            if (this.menuadministration.getCommande().equalsIgnoreCase("00101:01")) {
               this.affichePage = "/administration/entetesociete.jsp";
               this.menuEnteteSociete();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:02")) {
               this.affichePage = "/administration/organisationadministrative.jsp";
               this.menuOrganisationAdministrative();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:03")) {
               this.affichePage = "/administration/organisationcommerciale.jsp";
               this.menuOrganisationCommerciale();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:04")) {
               this.affichePage = "/administration/organisationproduction.jsp";
               this.menuOrganisationProduction();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:05")) {
               this.affichePage = "/administration/activitescommerciales.jsp";
               this.menuActivitesCommerciales();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:16")) {
               this.affichePage = "/administration/projets.jsp";
               this.menuProjets();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:15")) {
               this.affichePage = "/administration/equipes.jsp";
               this.menuEquipes();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:06")) {
               this.affichePage = "/administration/groupe.jsp";
               this.menuGroupe();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:07")) {
               this.affichePage = "/administration/utilisateurInit.jsp";
               this.menuUtilisateurs();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:070")) {
               this.affichePage = "/administration/imputationsUsersInit.jsp";
               this.menuImputationUsers();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:08")) {
               this.affichePage = "/administration/infosysteme.jsp";
               this.menuInfoSys();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:09")) {
               this.affichePage = "/administration/administration.jsp";
               this.choixModule = "";
               this.selectedExo = 0L;
               this.taille = 0;
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:10")) {
               this.affichePage = "/administration/backupDatas.jsp";
               this.menuBackupData();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:14")) {
               this.affichePage = "/administration/scripts.jsp";
               this.menuScript();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:11")) {
               this.affichePage = "/administration/antivirus.jsp";
               this.menuAntivirus();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:12")) {
               this.affichePage = "/utilitaires/utilitairesMaintenances.jsp";
               this.menuUtilitaires();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:13")) {
               this.affichePage = "/administration/testInternet.jsp";
               this.menuBandePassante();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:130")) {
               this.affichePage = "/administration/testInfoPc.jsp";
               this.menuIofoPC();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:17")) {
               this.affichePage = "/administration/testJava.jsp";
               this.menuJava();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:180")) {
               this.affichePage = "/administration/configurationTiers.jsp";
               this.menuConfigurationTiers();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00100:181")) {
               this.affichePage = "/administration/codageMD5.jsp";
               this.menuCodageMD5();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:19")) {
               this.affichePage = "/administration/cabinet.jsp";
               this.menuCabinet();
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:20")) {
               var2.setIndice(6L);
               this.aiguillageComptaSoc(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:21")) {
               var2.setIndice(7L);
               this.aiguillageComptaSoc(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:22")) {
               var2.setIndice(8L);
               this.aiguillageComptaSoc(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:23")) {
               var2.setIndice(9L);
               this.aiguillageComptaSoc(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:24")) {
               var2.setIndice(10L);
               this.aiguillageComptaSoc(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:28")) {
               var2.setIndice(11L);
               this.aiguillageComptaSoc(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:25")) {
               var2.setIndice(13L);
               this.aiguillageComptaSoc(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:26")) {
               var2.setIndice(2L);
               this.aiguillageComptaSoc(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:27")) {
               var2.setIndice(0L);
               this.aiguillageComptaSoc(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:30")) {
               var2.setIndice(5L);
               this.aiguillageVentes(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:31")) {
               var2.setIndice(6L);
               this.aiguillageVentes(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:32")) {
               var2.setIndice(7L);
               this.aiguillageVentes(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:33")) {
               var2.setIndice(10L);
               this.aiguillageVentes(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:34")) {
               var2.setIndice(13L);
               this.aiguillageVentes(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:35")) {
               var2.setIndice(14L);
               this.aiguillageVentes(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:36")) {
               var2.setIndice(2L);
               this.aiguillageVentes(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:37")) {
               var2.setIndice(18L);
               this.aiguillageVentes(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:38")) {
               var2.setIndice(0L);
               this.aiguillageVentes(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:40")) {
               var2.setIndice(4L);
               this.aiguillageAchats(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:41")) {
               var2.setIndice(6L);
               this.aiguillageAchats(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:42")) {
               var2.setIndice(10L);
               this.aiguillageAchats(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:43")) {
               var2.setIndice(12L);
               this.aiguillageAchats(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:44")) {
               var2.setIndice(3L);
               this.aiguillageAchats(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:45")) {
               var2.setIndice(24L);
               this.aiguillageAchats(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:46")) {
               var2.setIndice(0L);
               this.aiguillageAchats(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:50")) {
               var2.setIndice(3L);
               this.aiguillageCaisse(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:51")) {
               var2.setIndice(2L);
               this.aiguillageCaisse(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:52")) {
               var2.setIndice(10L);
               this.aiguillageCaisse(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:53")) {
               var2.setIndice(0L);
               this.aiguillageCaisse(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:60")) {
               var2.setIndice(4L);
               this.aiguillageParc(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:61")) {
               var2.setIndice(6L);
               this.aiguillageParc(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:62")) {
               var2.setIndice(5L);
               this.aiguillageParc(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:63")) {
               var2.setIndice(2L);
               this.aiguillageParc(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:64")) {
               var2.setIndice(0L);
               this.aiguillageParc(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:70")) {
               var2.setIndice(0L);
               this.aiguillagePaye(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:71")) {
               var2.setIndice(2L);
               this.aiguillagePaye(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:72")) {
               var2.setIndice(4L);
               this.aiguillagePaye(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:73")) {
               var2.setIndice(5L);
               this.aiguillagePaye(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:74")) {
               var2.setIndice(6L);
               this.aiguillagePaye(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:75")) {
               var2.setIndice(7L);
               this.aiguillagePaye(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:76")) {
               var2.setIndice(10L);
               this.aiguillagePaye(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:77")) {
               var2.setIndice(13L);
               this.aiguillageAchats(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:78")) {
               var2.setIndice(14L);
               this.aiguillageAchats(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:79")) {
               var2.setIndice(15L);
               this.aiguillageAchats(var2);
            } else if (this.menuadministration.getCommande().equalsIgnoreCase("00101:80")) {
               var2.setIndice(16L);
               this.aiguillageAchats(var2);
            }
         }
      }

   }

   public void menuEnteteSociete() throws JDOMException, IOException, HibernateException, NamingException, SQLException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Structure");
      this.formStructureEntete = new FormStructureEntete();
      this.formStructureEntete.setUtilInitHibernate(this.utilInitHibernate);
      this.formStructureEntete.setBaseLog(this.baseLog);
      this.formStructureEntete.setStructureLog(this.structureLog);
      this.formStructureEntete.setUsersLog(this.usersLog);
      this.formStructureEntete.InstancesDaoUtilses();
      this.formStructureEntete.chargerLesBanques(var1);
      this.formStructureEntete.chargerlesBal(var1);
      new ObjetImmatriculation();
      LectureImmatriculation var3 = new LectureImmatriculation(this.structureLog.getStrcodepays(), "pmoral");
      ObjetImmatriculation var2 = var3.getImmatriculation();
      this.formStructureEntete.setPmoral(var2);
      this.zoneFiscales = new LectureZonesFiscales();
      this.zoneCommerciale = new LectureZonesCommerciales();
      this.formJuridique = new LectureFormesJuridiques();
      this.typeSociete = new LectureTypesSocietes();
      this.formStructureEntete.setLesStructuresPeg(this.lesStructuresPeg);
      this.utilInitHibernate.closeSession();
      this.mAJEspion("Modification entête société");
   }

   public void menuOrganisationAdministrative() throws HibernateException, NamingException {
      this.choixLigne = "organisationAdministrative";
      this.formOrganisationAdministrative = new FormOrganisationAdministrative();
      this.formOrganisationAdministrative.setutilInitHibernate(this.utilInitHibernate);
      this.formOrganisationAdministrative.setBaseLog(this.baseLog);
      this.formOrganisationAdministrative.setStructureLog(this.structureLog);
      this.formOrganisationAdministrative.setUsersLog(this.usersLog);
      this.formOrganisationAdministrative.InstancesDaoUtilses();
      this.formOrganisationAdministrative.lesSites();
      this.mAJEspion("Accès gestion Organisation administrative");
   }

   public void menuOrganisationCommerciale() throws HibernateException, NamingException {
      this.choixLigne = "organisationCommerciale";
      this.formOrganisationCommerciale = new FormOrganisationCommerciale();
      this.formOrganisationCommerciale.setutilInitHibernate(this.utilInitHibernate);
      this.formOrganisationCommerciale.setBaseLog(this.baseLog);
      this.formOrganisationCommerciale.setStructureLog(this.structureLog);
      this.formOrganisationCommerciale.setUsersLog(this.usersLog);
      this.formOrganisationCommerciale.InstancesDaoUtilses();
      this.formOrganisationCommerciale.lesRegions();
      if (this.typeVente == 813) {
         this.mAJEspion("Accès gestion Polit-buro");
      } else {
         this.mAJEspion("Accès gestion Organisation commerciale");
      }

   }

   public void menuOrganisationProduction() throws HibernateException, NamingException {
      this.choixLigne = "organisationProduction";
      this.formOrganisationProduction = new FormOrganisationProduction();
      this.formOrganisationProduction.setutilInitHibernate(this.utilInitHibernate);
      this.formOrganisationProduction.setBaseLog(this.baseLog);
      this.formOrganisationProduction.setStructureLog(this.structureLog);
      this.formOrganisationProduction.setUsersLog(this.usersLog);
      this.formOrganisationProduction.InstancesDaoUtilses();
      this.formOrganisationProduction.lesSites();
      this.mAJEspion("Accès gestion Organisation production");
   }

   public void menuActivitesCommerciales() throws HibernateException, NamingException {
      this.choixLigne = "activitesCommerciales";
      this.formActivitesCommerciales = new FormActivitesCommerciales();
      this.formActivitesCommerciales.setutilInitHibernate(this.utilInitHibernate);
      this.formActivitesCommerciales.setBaseLog(this.baseLog);
      this.formActivitesCommerciales.setStructureLog(this.structureLog);
      this.formActivitesCommerciales.setUsersLog(this.usersLog);
      this.formActivitesCommerciales.InstancesDaoUtilses();
      this.formActivitesCommerciales.lesActivites();
      this.mAJEspion("Accès gestion Activités sociétés");
   }

   public void menuProjets() throws HibernateException, NamingException {
      this.choixLigne = "projets";
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Projets");
      this.formPlanProjets = new FormPlanProjets();
      this.formPlanProjets.setutilInitHibernate(this.utilInitHibernate);
      this.formPlanProjets.setBaseLog(this.baseLog);
      this.formPlanProjets.setStructureLog(this.structureLog);
      this.formPlanProjets.setUsersLog(this.usersLog);
      this.formPlanProjets.InstancesDaoUtilses();
      this.formPlanProjets.lesProjets(var1);
      this.utilInitHibernate.closeSession();
      this.mAJEspion("Accès gestion projets");
   }

   public void menuEquipes() throws HibernateException, NamingException, ParseException {
      this.choixLigne = "equipes";
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Equipes");
      this.formEquipes = new FormEquipes();
      this.formEquipes.setutilInitHibernate(this.utilInitHibernate);
      this.formEquipes.setBaseLog(this.baseLog);
      this.formEquipes.setStructureLog(this.structureLog);
      this.formEquipes.setUsersLog(this.usersLog);
      this.formEquipes.InstancesDaoUtilses();
      this.formEquipes.lesEquipes(var1);
      this.utilInitHibernate.closeSession();
      this.mAJEspion("Accès gestion Equipes sociétés");
   }

   public void menuGroupe() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.choixLigne = "groupe";
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
      this.formGroupe = new FormGroupe();
      this.formGroupe.setutilInitHibernate(this.utilInitHibernate);
      this.formGroupe.setBaseLog(this.baseLog);
      this.formGroupe.setStructureLog(this.structureLog);
      this.formGroupe.setUsersLog(this.usersLog);
      this.formGroupe.InstancesDaoUtilses();
      this.formGroupe.lesGroupes(var1);
      this.formGroupe.setLesStructuresPeg(this.lesStructuresPeg);
      LireLesoptionsVentes var2 = new LireLesoptionsVentes();
      var2.setStrId(this.structureLog.getStrid());
      this.optionsVentes = new OptionVentes();
      this.optionsVentes = var2.lancer();
      this.formGroupe.chargerLesChronoAch(var1);
      this.formGroupe.chargerLesChronoCaisse(var1);
      this.formGroupe.chargerLesChronoMedical(var1);
      this.formGroupe.chargerLesChronoOff(var1);
      this.formGroupe.chargerLesChronoPaye(var1);
      this.formGroupe.chargerLesChronoVte(var1);
      this.formGroupe.chargerLesDepots(var1);
      this.utilInitHibernate.closeSession();
      this.mAJEspion("Accès gestion des groupes");
   }

   public void mesMessageriesGroupes() throws JDOMException, IOException, HibernateException, NamingException {
      this.formGroupe.chargerlesBal();
      this.affichePage = "/administration/groupebal.jsp";
   }

   public void retourLigneGroupe() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.affichePage = "/administration/groupe.jsp";
      this.menuGroupe();
   }

   public void menuUtilisateurs() throws JDOMException, IOException, HibernateException, NamingException {
      this.choixLigne = "users";
      this.formUsers = new FormUsers();
      this.formUsers.setutilInitHibernate(this.utilInitHibernate);
      this.formUsers.setBaseLog(this.baseLog);
      this.formUsers.setStructureLog(this.structureLog);
      this.formUsers.setUsersLog(this.usersLog);
      this.formUsers.InstancesDaoUtilses();
      this.formUsers.chargerUtilisateurs();
      this.formUsers.setLesStructuresPeg(this.lesStructuresPeg);
      this.controleOnglet();
      LireLesoptionsCaisses var1 = new LireLesoptionsCaisses();
      var1.setStrId(this.structureLog.getStrid());
      this.optionCaisses = var1.lancer();
      this.mAJEspion("Accès gestion des utilisateurs");
   }

   public void menuImputationUsers() throws JDOMException, IOException, HibernateException, NamingException {
      this.choixLigne = "groupe";
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
      this.formGroupe = new FormGroupe();
      this.formGroupe.setutilInitHibernate(this.utilInitHibernate);
      this.formGroupe.setBaseLog(this.baseLog);
      this.formGroupe.setStructureLog(this.structureLog);
      this.formGroupe.setUsersLog(this.usersLog);
      this.formGroupe.InstancesDaoUtilses();
      this.formGroupe.lesGroupes(var1);
      this.controleOnglet();
      this.mAJEspion("Accès gestion des imputations utilisateurs");
   }

   public void menuInfoSys() throws JDOMException, IOException, HibernateException, NamingException, SQLException, ClassNotFoundException, SAXException {
      this.formInfoSysteme = new FormInfoSysteme();
      this.formInfoSysteme.setutilInitHibernate(this.utilInitHibernate);
      this.formInfoSysteme.setBaseLog(this.baseLog);
      this.formInfoSysteme.setStructureLog(this.structureLog);
      this.formInfoSysteme.setUsersLog(this.usersLog);
      this.formInfoSysteme.setTypeVente(this.typeVente);
      if (this.structureLog.getStrmaitrecabinet() >= 1 && this.structureLog.getStrmaitrecabinet() <= 5) {
         this.var_showBarProg = true;
         this.var_currentValue = 0;
         this.var_info = "Chargement des structures en cours...";
         UtilNombre var1 = new UtilNombre();
         new ArrayList();
         this.formCabinet = new FormCabinet();
         this.formCabinet.setutilInitHibernate(this.utilInitHibernate);
         this.formCabinet.setBaseLog(this.baseLog);
         this.formCabinet.setStructureLog(this.structureLog);
         this.formCabinet.setUsersLog(this.usersLog);
         this.formCabinet.InstancesDaoUtilses();
         this.formCabinet.initCabinet();
         List var2 = this.formCabinet.chargerSociete();
         this.var_info = "Informations Systemes: " + this.baseLog + " (base maitre)";
         this.formInfoSysteme.changeStructure(this.baseLog, 1);
         if (var2.size() != 0) {
            new StructurePeg();

            for(int var4 = 0; var4 < var2.size(); ++var4) {
               StructurePeg var3 = (StructurePeg)var2.get(var4);
               this.nomStructureEnCours = "structure" + var3.getStrId();
               if (var4 != 0) {
                  double var5 = (double)var2.size();
                  double var7 = var1.myRound(var5 / (double)var4, 4);
                  double var9 = var1.myRound(100.0D / var7, 2);
                  this.var_currentValue = (int)var9;
               }

               this.var_info = "Informations Systemes: " + this.nomStructureEnCours + "  soit " + (var4 + 1) + "/" + var2.size();
               this.formInfoSysteme.changeStructure(this.nomStructureEnCours, this.structureLog.getStrmajcabinet());
               if (this.structureLog.getStrmajcabinet() == 2) {
                  String var11 = StaticModePegase.getCheminContext();
                  File var6 = new File(var11 + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression");
                  if (var6.exists()) {
                     File var12 = new File(var11 + File.separator + "clients" + File.separator + this.nomStructureEnCours + File.separator + "impression");
                     if (var12.exists()) {
                        var12.delete();
                     }

                     FileRep.copy(var6, var12);
                  }
               }
            }
         }

         this.nomStructureEnCours = this.baseLog;
         this.var_showBarProg = false;
      } else {
         this.formInfoSysteme.chargerListeTable(true, 1);
      }

      this.mAJEspion("Informations systèmes");
   }

   public void menuBackupData() throws HibernateException, NamingException, MalformedURLException, IOException, SQLException, ClassNotFoundException, SAXException {
      UtilDate var1 = new UtilDate();
      this.formBackupDatas = new FormBackupDatas(this.utilInitHibernate, var1);
      this.formBackupDatas.setBaseLog(this.baseLog);
      this.formBackupDatas.setStructureLog(this.structureLog);
      this.formBackupDatas.setUsersLog(this.usersLog);
      this.formBackupDatas.chargerListeSauvegarde(this.urlExplorateur);
      this.formBackupDatas.chargerListeSousDossier((Session)null);
      this.mAJEspion("Backup Datas");
   }

   public void menuScript() throws HibernateException, HibernateException, NamingException {
      UtilDate var1 = new UtilDate();
      this.formBackupDatas = new FormBackupDatas(this.utilInitHibernate, var1);
      this.formBackupDatas.setBaseLog(this.baseLog);
      this.formBackupDatas.setStructureLog(this.structureLog);
      this.formBackupDatas.setUsersLog(this.usersLog);
      this.formBackupDatas.chergerlesStructures();
      this.formBackupDatas.chargerListeScripts();
      this.mAJEspion("Scripts");
   }

   public void menuAntivirus() throws JDOMException, IOException, HibernateException, NamingException {
      this.mAJEspion("Quick scan BitDfender");
   }

   public void menuUtilitaires() throws JDOMException, IOException, ParseException, SAXException, HibernateException, NamingException {
      this.choixLigne = "moduleUtilitaires";
      this.formUtilitaires = new FormUtilitaires();
      this.formUtilitaires.setutilInitHibernate(this.utilInitHibernate);
      this.formUtilitaires.setBaseLog(this.baseLog);
      this.formUtilitaires.setStructureLog(this.structureLog);
      this.formUtilitaires.setUsersLog(this.usersLog);
      this.formUtilitaires.InstancesDaoUtilses();
      this.formUtilitaires.menuUtilitaires();
      this.formUtilitaires.setFormRecherche(this.formRecherche);
      this.formUtilitaires.setTypeVente(this.typeVente);
      this.mAJEspion("Accès utilitaires et maintenances");
   }

   public boolean verifModuleInstalle(String var1) {
      boolean var2 = false;
      if (this.structureLog.getStrmod1() != null && this.structureLog.getStrmod1().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod2() != null && this.structureLog.getStrmod2().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod3() != null && this.structureLog.getStrmod3().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod4() != null && this.structureLog.getStrmod4().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod5() != null && this.structureLog.getStrmod5().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod6() != null && this.structureLog.getStrmod6().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod7() != null && this.structureLog.getStrmod7().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod8() != null && this.structureLog.getStrmod8().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod9() != null && this.structureLog.getStrmod9().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod10() != null && this.structureLog.getStrmod10().startsWith(var1)) {
         var2 = true;
      }

      return var2;
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

   public void menuBandePassante() throws JDOMException, IOException, HibernateException, NamingException {
      this.mAJEspion("Test bande passante");
   }

   public void menuIofoPC() throws JDOMException, IOException, HibernateException, NamingException {
      this.mAJEspion("Test info PC");
   }

   public void menuJava() throws JDOMException, IOException, HibernateException, NamingException {
      this.mAJEspion("Test Java");
   }

   public void menuTeleAssistance() throws JDOMException, IOException, HibernateException, NamingException {
      this.mAJEspion("Télé-assistance");
   }

   public void menuCabinet() throws JDOMException, IOException, SAXException, HibernateException, NamingException {
      this.choixLigne = "cabinet";
      this.formCabinet = new FormCabinet();
      this.formCabinet.setutilInitHibernate(this.utilInitHibernate);
      this.formCabinet.setBaseLog(this.baseLog);
      this.formCabinet.setStructureLog(this.structureLog);
      this.formCabinet.setUsersLog(this.usersLog);
      this.formCabinet.InstancesDaoUtilses();
      this.formCabinet.initCabinet();
      this.formCabinet.chargerSociete();
      this.mAJEspion("Accès gestion des configuration cabinet");
   }

   public void menuImageStartup() throws JDOMException, IOException, SAXException, HibernateException, NamingException {
      UtilDate var1 = new UtilDate();
      this.choixLigne = "imagesStartup";
      this.formBackupDatas = new FormBackupDatas(this.utilInitHibernate, var1);
      this.formBackupDatas.setBaseLog(this.baseLog);
      this.formBackupDatas.setStructureLog(this.structureLog);
      this.formBackupDatas.setUsersLog(this.usersLog);
      this.formBackupDatas.initImageStartup();
      this.mAJEspion("Accès gestion des images startup");
   }

   public void menuConfigurationTiers() throws HibernateException, NamingException {
      this.formTiersTechnique = new FormTiersTechnique();
      this.formTiersTechnique.setutilInitHibernate(this.utilInitHibernate);
      this.formTiersTechnique.setBaseLog(this.baseLog);
      this.formTiersTechnique.setStructureLog(this.structureLog);
      this.formTiersTechnique.setUsersLog(this.usersLog);
      this.formTiersTechnique.instanceDaoUtilises();
      this.formTiersTechnique.chargerListeConfigurations();
      this.mAJEspion("TiersTechnique");
   }

   public void menuCodageMD5() throws HibernateException, NamingException {
      this.formTiersTechnique = new FormTiersTechnique();
      this.formTiersTechnique.setutilInitHibernate(this.utilInitHibernate);
      this.formTiersTechnique.setBaseLog(this.baseLog);
      this.formTiersTechnique.setStructureLog(this.structureLog);
      this.formTiersTechnique.setUsersLog(this.usersLog);
      this.formTiersTechnique.instanceDaoUtilises();
      this.mAJEspion("CodageMD5");
   }

   public void controleOnglet() {
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().equals("")) {
         this.calculeOngletModule(this.structureLog.getStrmod1());
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().equals("")) {
         this.calculeOngletModule(this.structureLog.getStrmod2());
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().equals("")) {
         this.calculeOngletModule(this.structureLog.getStrmod2());
      }

      if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().equals("")) {
         this.calculeOngletModule(this.structureLog.getStrmod3());
      }

      if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().equals("")) {
         this.calculeOngletModule(this.structureLog.getStrmod4());
      }

      if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().equals("")) {
         this.calculeOngletModule(this.structureLog.getStrmod5());
      }

      if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().equals("")) {
         this.calculeOngletModule(this.structureLog.getStrmod6());
      }

      if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().equals("")) {
         this.calculeOngletModule(this.structureLog.getStrmod7());
      }

      if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().equals("")) {
         this.calculeOngletModule(this.structureLog.getStrmod8());
      }

      if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().equals("")) {
         this.calculeOngletModule(this.structureLog.getStrmod9());
      }

      if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().equals("")) {
         this.calculeOngletModule(this.structureLog.getStrmod10());
      }

   }

   public String calculeOngletModule(String var1) {
      if (var1.equalsIgnoreCase("40100")) {
         this.ongCompta = true;
         this.libelleMod = "Comptabilité Libérale";
      } else if (var1.equalsIgnoreCase("40200")) {
         this.ongCompta = true;
         this.libelleMod = "Comptabilité Société";
      } else if (var1.equalsIgnoreCase("40300")) {
         this.ongCompta = true;
         this.libelleMod = "Comptabilité Projet";
      } else if (!var1.equalsIgnoreCase("50000") && !var1.equalsIgnoreCase("50200") && !var1.equalsIgnoreCase("50300")) {
         if (!var1.equalsIgnoreCase("60000") && !var1.equalsIgnoreCase("60010") && !var1.equalsIgnoreCase("60020")) {
            if (var1.equalsIgnoreCase("70000")) {
               this.ongParc = true;
               this.libelleMod = "Parcs";
            } else if (var1.equalsIgnoreCase("80100")) {
               this.ongSuiviCom = 1;
               this.CodeMod = "80100";
               this.libelleMod = "Suivi Commercial Standard";
            } else if (var1.equalsIgnoreCase("80200")) {
               this.ongSuiviCom = 2;
               this.CodeMod = "80200";
               this.libelleMod = "Suivi Commercial + Comptoir";
            } else if (var1.equalsIgnoreCase("80300")) {
               this.ongSuiviCom = 3;
               this.CodeMod = "80300";
               this.libelleMod = "Fondation";
            } else if (var1.equalsIgnoreCase("80400")) {
               this.ongSuiviCom = 4;
               this.CodeMod = "80400";
               this.libelleMod = "Gestion Intérim";
            } else if (var1.equalsIgnoreCase("80500")) {
               this.ongSuiviCom = 5;
               this.CodeMod = "80500";
               this.libelleMod = "Gestion Cabinet";
            } else if (var1.equalsIgnoreCase("80600")) {
               this.ongSuiviCom = 6;
               this.CodeMod = "80600";
               this.libelleMod = "Gestion Transport";
            } else if (var1.equalsIgnoreCase("80700")) {
               this.ongSuiviCom = 7;
               this.CodeMod = "80700";
               this.libelleMod = "Gestion Micro finance";
            } else if (var1.equalsIgnoreCase("80800")) {
               this.ongSuiviCom = 8;
               this.CodeMod = "80800";
               this.libelleMod = "Gestion du Change Monétaire";
            } else if (var1.equalsIgnoreCase("80900")) {
               this.ongSuiviCom = 9;
               this.CodeMod = "80900";
               this.libelleMod = "Gestion Education";
            } else if (var1.equalsIgnoreCase("81000")) {
               this.ongSuiviCom = 10;
               this.CodeMod = "81000";
               this.libelleMod = "Gestion des ventes à crédit";
            } else if (var1.equalsIgnoreCase("81100")) {
               this.ongSuiviCom = 11;
               this.CodeMod = "81100";
               this.libelleMod = "Gestion des Pêcheries";
            } else if (var1.equalsIgnoreCase("81200")) {
               this.ongSuiviCom = 12;
               this.CodeMod = "81200";
               this.libelleMod = "Gestion des Temples";
            } else if (var1.equalsIgnoreCase("81300")) {
               this.ongSuiviCom = 13;
               this.CodeMod = "81300";
               this.libelleMod = "Gestion des PABX";
            } else if (var1.equalsIgnoreCase("81400")) {
               this.ongSuiviCom = 14;
               this.CodeMod = "81400";
               this.libelleMod = "Gestion Forestière";
            } else if (var1.equalsIgnoreCase("81500")) {
               this.ongSuiviCom = 15;
               this.CodeMod = "81500";
               this.libelleMod = "Infirmerie";
            } else if (var1.equalsIgnoreCase("81510")) {
               this.ongSuiviCom = 15;
               this.CodeMod = "81510";
               this.libelleMod = "Cabinet Médical";
            } else if (var1.equalsIgnoreCase("81520")) {
               this.ongSuiviCom = 15;
               this.CodeMod = "81520";
               this.libelleMod = "Laboratoire";
            } else if (var1.equalsIgnoreCase("81530")) {
               this.ongSuiviCom = 15;
               this.CodeMod = "81530";
               this.libelleMod = "Pharmacie";
            } else if (var1.equalsIgnoreCase("81540")) {
               this.ongSuiviCom = 15;
               this.CodeMod = "81540";
               this.libelleMod = "Clinique";
            } else if (var1.equalsIgnoreCase("81550")) {
               this.ongSuiviCom = 15;
               this.CodeMod = "81550";
               this.libelleMod = "Hopital";
            } else if (!var1.equalsIgnoreCase("81600") && !var1.equalsIgnoreCase("81610") && !var1.equalsIgnoreCase("81620")) {
               if (var1.equalsIgnoreCase("81700")) {
                  this.ongSuiviCom = 17;
                  this.CodeMod = "81700";
                  this.libelleMod = "Gestion Hotellerie";
               } else if (var1.equalsIgnoreCase("90000")) {
                  this.ongCaisse = true;
                  this.libelleMod = "Caisse décentralisée";
               }
            } else {
               this.ongSuiviCom = 16;
               this.CodeMod = "81600";
               this.libelleMod = "Gestion Immobilière";
            }
         } else {
            this.ongAchat = true;
            this.libelleMod = "Achats";
         }
      } else {
         this.ongPay = true;
         this.libelleMod = "Paye";
      }

      return this.libelleMod;
   }

   public void mAJEspion(String var1) throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var2 = new Espion();
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         var2.setEspdtecreat(new Date());
         var2.setUsers(this.usersLog);
         var2.setEspaction(var1);
         var2.setEsptype(0);
         this.espionDao.mAJEspion(var2, var3);
         var4.commit();
      } catch (HibernateException var9) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void journauxComptables() throws HibernateException, NamingException {
      this.mesJournauxComptables.clear();
      long var1 = 0L;
      new ExercicesComptable();
      ExercicesComptable var3 = this.exercicesComptableDao.recupererLastExo((Session)null);
      if (var3 != null) {
         var1 = var3.getExecpt_id();
         JournauxComptablesDao var4 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
         this.mesJournauxComptables = var4.mesjournauxActifsItems(var1, "", 0, (Session)null);
      }

   }

   public void journauxTresorerie() throws HibernateException, NamingException {
      this.mesJournauxComptables.clear();
      long var1 = 0L;
      new ExercicesComptable();
      ExercicesComptable var3 = this.exercicesComptableDao.recupererLastExo((Session)null);
      if (var3 != null) {
         var1 = var3.getExecpt_id();
         JournauxComptablesDao var4 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var5 = var4.mesjournauxTresorerieActifs(var1, "", 0, (Session)null);
         if (var5.size() != 0) {
            for(int var6 = 0; var6 < var5.size(); ++var6) {
               new JournauxComptables();
               JournauxComptables var7 = (JournauxComptables)var5.get(var6);
               this.mesJournauxComptables.add(new SelectItem(var7.getPljCode(), var7.getPljCode() + ":" + var7.getPljLibelleFr()));
            }
         }
      }

   }

   public void aiguillageParametre() throws NamingException, ParseException, IOException, JDOMException {
      this.choixModule = "module";
      this.selectedExo = 0L;
      this.taille = 0;
      if (this.dataModelMenuHorizontal.isRowAvailable()) {
         this.menuModule = (MenuModule)this.dataModelMenuHorizontal.getRowData();
         this.mods = this.menuModule.getLibelle();
         MenuListe var1 = new MenuListe();
         this.dataModelModuleParam = new ListDataModel();
         if (this.menuModule.getCode() != 10000) {
            if (this.menuModule.getCode() == 20000) {
               this.dataModelModuleParam = var1.menuOffice();
            } else if (this.menuModule.getCode() == 30000) {
               this.dataModelModuleParam = var1.menuTiers();
            } else if (this.menuModule.getCode() == 40100) {
               this.dataModelModuleParam = var1.menuComptaLib();
               this.selectedExo = this.exercicesComptableDao.recupererLastExo((Session)null).getExecpt_id();
               if (this.selectedExo == 0L) {
                  this.taille = 1;
               }
            } else if (this.menuModule.getCode() != 40200 && this.menuModule.getCode() != 40300) {
               if (this.menuModule.getCode() != 50000 && this.menuModule.getCode() != 50100 && this.menuModule.getCode() != 50300) {
                  if (this.menuModule.getCode() == 50200) {
                     this.dataModelModuleParam = var1.menuTemps();
                     this.selectedExo = this.exercicesPayeDao.recupererLastExo((Session)null).getExepayId();
                     if (this.selectedExo == 0L) {
                        this.taille = 8;
                     }
                  } else if (this.menuModule.getCode() != 60000 && this.menuModule.getCode() != 60010 && this.menuModule.getCode() != 60020) {
                     if (this.menuModule.getCode() == 70000) {
                        this.dataModelModuleParam = var1.menuParcs();
                        this.selectedExo = this.exercicesParcsDao.recupererLastExo((Session)null).getExeprcId();
                        if (this.selectedExo == 0L) {
                           this.taille = 6;
                        }
                     } else if (this.menuModule.getCode() != 80100 && this.menuModule.getCode() != 81000) {
                        if (this.menuModule.getCode() == 80200) {
                           this.dataModelModuleParam = var1.menuVentesCpt();
                           this.selectedExo = this.exercicesVentesDao.recupererLastExo((Session)null).getExevteId();
                           if (this.selectedExo == 0L) {
                              this.taille = 3;
                           }
                        } else if (this.menuModule.getCode() == 80300) {
                           this.dataModelModuleParam = var1.menuFondation();
                           this.selectedExo = this.exercicesVentesDao.recupererLastExo((Session)null).getExevteId();
                           if (this.selectedExo == 0L) {
                              this.taille = 13;
                           }
                        } else if (this.menuModule.getCode() == 80400) {
                           this.dataModelModuleParam = var1.menuInterim();
                           this.selectedExo = this.exercicesVentesDao.recupererLastExo((Session)null).getExevteId();
                           if (this.selectedExo == 0L) {
                              this.taille = 11;
                           }
                        } else if (this.menuModule.getCode() == 80500) {
                           this.dataModelModuleParam = var1.menuCabinet();
                           this.selectedExo = this.exercicesVentesDao.recupererLastExo((Session)null).getExevteId();
                           if (this.selectedExo == 0L) {
                              this.taille = 3;
                           }
                        } else if (this.menuModule.getCode() == 80600) {
                           this.dataModelModuleParam = var1.menuTransit();
                           this.selectedExo = this.exercicesVentesDao.recupererLastExo((Session)null).getExevteId();
                           if (this.selectedExo == 0L) {
                              this.taille = 3;
                           }
                        } else if (this.menuModule.getCode() == 80700) {
                           this.dataModelModuleParam = var1.menuMicroFinance();
                           this.selectedExo = this.exercicesVentesDao.recupererLastExo((Session)null).getExevteId();
                           if (this.selectedExo == 0L) {
                              this.taille = 12;
                           }
                        } else if (this.menuModule.getCode() == 80800) {
                           this.dataModelModuleParam = var1.menuChange();
                        } else if (this.menuModule.getCode() == 80900) {
                           this.dataModelModuleParam = var1.menuEducation();
                           this.selectedExo = this.exercicesVentesDao.recupererLastExo((Session)null).getExevteId();
                           if (this.selectedExo == 0L) {
                              this.taille = 9;
                           }
                        } else if (this.menuModule.getCode() == 81100) {
                           this.dataModelModuleParam = var1.menuPecherie();
                        } else if (this.menuModule.getCode() == 81200) {
                           this.dataModelModuleParam = var1.menuTemples();
                           this.selectedExo = this.exercicesVentesDao.recupererLastExo((Session)null).getExevteId();
                           if (this.selectedExo == 0L) {
                              this.taille = 13;
                           }
                        } else if (this.menuModule.getCode() == 81300) {
                           this.dataModelModuleParam = var1.menuPartiPolitique();
                           this.selectedExo = this.exercicesVentesDao.recupererLastExo((Session)null).getExevteId();
                           if (this.selectedExo == 0L) {
                              this.taille = 14;
                           }
                        } else if (this.menuModule.getCode() == 81400) {
                           this.dataModelModuleParam = var1.menuForet();
                           this.selectedExo = this.exercicesVentesDao.recupererLastExo((Session)null).getExevteId();
                           if (this.selectedExo == 0L) {
                              this.taille = 15;
                           }
                        } else if (this.menuModule.getCode() != 81500 && this.menuModule.getCode() != 81510 && this.menuModule.getCode() != 81520 && this.menuModule.getCode() != 81530 && this.menuModule.getCode() != 81540 && this.menuModule.getCode() != 81550) {
                           if (this.menuModule.getCode() != 81600 && this.menuModule.getCode() != 81610 && this.menuModule.getCode() != 81620 && this.menuModule.getCode() != 81630 && this.menuModule.getCode() != 81640) {
                              if (this.menuModule.getCode() == 81700) {
                                 this.dataModelModuleParam = var1.menuRestaurant();
                              } else if (this.menuModule.getCode() == 81710) {
                                 this.dataModelModuleParam = var1.menuHotelerie();
                              } else if (this.menuModule.getCode() == 90000) {
                                 this.dataModelModuleParam = var1.menuCaisse();
                                 this.selectedExo = this.exercicesCaisseDao.recupererLastExo((Session)null).getExecaiId();
                                 if (this.selectedExo == 0L) {
                                    this.taille = 7;
                                 }
                              } else if (this.menuModule.getCode() == 91000) {
                              }
                           } else {
                              this.dataModelModuleParam = var1.menuImmobilier();
                              this.selectedExo = this.exercicesVentesDao.recupererLastExo((Session)null).getExevteId();
                              if (this.selectedExo == 0L) {
                                 this.taille = 10;
                              }
                           }
                        } else {
                           this.dataModelModuleParam = var1.menuMedical(this.structureLog);
                           this.selectedExo = this.exercicesVentesDao.recupererLastExo((Session)null).getExevteId();
                           if (this.selectedExo == 0L) {
                              this.taille = 4;
                           }
                        }
                     } else {
                        this.dataModelModuleParam = var1.menuVentes();
                        this.selectedExo = this.exercicesVentesDao.recupererLastExo((Session)null).getExevteId();
                        if (this.selectedExo == 0L) {
                           this.taille = 3;
                        }
                     }
                  } else {
                     byte var2 = 0;
                     if (this.menuModule.getCode() == 60020) {
                        var2 = 2;
                     }

                     this.dataModelModuleParam = var1.menuAchats(this.structureLog, var2);
                     this.selectedExo = this.exercicesAchatsDao.recupererLastExo((Session)null).getExeachId();
                     if (this.selectedExo == 0L) {
                        this.taille = 2;
                     }
                  }
               } else {
                  this.dataModelModuleParam = var1.menuPaye();
                  this.selectedExo = this.exercicesPayeDao.recupererLastExo((Session)null).getExepayId();
                  if (this.selectedExo == 0L) {
                     this.taille = 8;
                  }
               }
            } else {
               this.dataModelModuleParam = var1.menuComptaSoc();
               this.selectedExo = this.exercicesComptableDao.recupererLastExo((Session)null).getExecpt_id();
               if (this.selectedExo == 0L) {
                  this.taille = 1;
               }
            }
         }
      }

   }

   public void aiguillageLigneParam() throws SAXException, IOException, JDOMException, NamingException, HibernateException, ParseException {
      if (this.dataModelModuleParam.isRowAvailable()) {
         new Module();
         Module var1 = (Module)this.dataModelModuleParam.getRowData();
         this.choixModule = "moduleLigne";
         if (this.menuModule.getCode() == 20000) {
            this.aiguillageOffice(var1);
         } else if (this.menuModule.getCode() == 30000) {
            this.aiguillagetiers(var1);
         } else if (this.menuModule.getCode() != 40100) {
            if (this.menuModule.getCode() != 40200 && this.menuModule.getCode() != 40300) {
               if (this.menuModule.getCode() != 50000 && this.menuModule.getCode() != 50100 && this.menuModule.getCode() != 50300) {
                  if (this.menuModule.getCode() == 50200) {
                     this.aiguillageTemps(var1);
                  } else if (this.menuModule.getCode() != 60000 && this.menuModule.getCode() != 60010 && this.menuModule.getCode() != 60020) {
                     if (this.menuModule.getCode() == 70000) {
                        this.aiguillageParc(var1);
                     } else if (this.menuModule.getCode() != 80100 && this.menuModule.getCode() != 81000) {
                        if (this.menuModule.getCode() == 80200) {
                           this.aiguillageVentesTicket(var1);
                        } else if (this.menuModule.getCode() == 80300) {
                           this.aiguillageFondation(var1);
                        } else if (this.menuModule.getCode() == 80400) {
                           this.aiguillageVentesInterim(var1);
                        } else if (this.menuModule.getCode() == 80500) {
                           this.aiguillageCabinet(var1);
                        } else if (this.menuModule.getCode() == 80600) {
                           this.aiguillageTransit(var1);
                        } else if (this.menuModule.getCode() == 80700) {
                           this.aiguillageMicrofinance(var1);
                        } else if (this.menuModule.getCode() != 80800) {
                           if (this.menuModule.getCode() == 80900) {
                              this.aiguillageEducation(var1);
                           } else if (this.menuModule.getCode() != 81100 && this.menuModule.getCode() != 81200 && this.menuModule.getCode() != 81300) {
                              if (this.menuModule.getCode() == 81400) {
                                 this.aiguillageForet(var1);
                              } else if (this.menuModule.getCode() != 81500 && this.menuModule.getCode() != 81510 && this.menuModule.getCode() != 81520 && this.menuModule.getCode() != 81530 && this.menuModule.getCode() != 81540 && this.menuModule.getCode() != 81550) {
                                 if (this.menuModule.getCode() != 81600 && this.menuModule.getCode() != 81610 && this.menuModule.getCode() != 81620 && this.menuModule.getCode() != 81630 && this.menuModule.getCode() != 81640) {
                                    if (this.menuModule.getCode() == 81700) {
                                       this.aiguillageRestaurant(var1);
                                    } else if (this.menuModule.getCode() == 81710) {
                                       this.aiguillageHotelerie(var1);
                                    } else if (this.menuModule.getCode() == 90000) {
                                       this.aiguillageCaisse(var1);
                                    } else if (this.menuModule.getCode() == 91000) {
                                    }
                                 } else {
                                    this.aiguillageImmobilier(var1);
                                 }
                              } else {
                                 this.aiguillageMedical(var1);
                              }
                           }
                        }
                     } else {
                        this.aiguillageVentes(var1);
                     }
                  } else {
                     this.aiguillageAchats(var1);
                  }
               } else {
                  this.aiguillagePaye(var1);
               }
            } else {
               this.aiguillageComptaSoc(var1);
            }
         }

         this.mAJEspion(this.choixModule + " : " + this.choixLigne);
      }

   }

   public void aiguillageOffice(Module var1) throws IOException, HibernateException, NamingException, JDOMException, SAXException {
      String var3;
      File var5;
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "commun" + File.separator;
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "commun" + File.separator;
         File var4 = new File(var2);
         var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsTiers var7 = new LireLesoptionsTiers();
      var7.setStrId(this.structureLog.getStrid());
      this.optionTiers = new OptionTiers();
      this.optionTiers = var7.lancer();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "optionsOffice";
         this.formOptionTiers = new FormOptionsOffice();
         this.formOptionTiers.setutilInitHibernate(this.utilInitHibernate);
         this.formOptionTiers.setLabase(this.baseLog);
         this.formOptionTiers.setUserlog(this.usersLog);
         this.formOptionTiers.setOptionTiers(this.optionTiers);
         this.formOptionTiers.setStructureLog(this.structureLog);
         this.formOptionTiers.initOption();
         this.formOptionTiers.chargerLesRepImpAchats();
         this.formOptionTiers.chargerLesRepImpStocks();
         this.formOptionTiers.chargerLesRepImpVentes();
         this.formOptionTiers.chargerLesRepImpTreso();
      } else {
         Session var8;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "chronosOffice";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Site");
            this.formChronoOffice = new FormChronoOffice();
            this.formChronoOffice.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoOffice.setBaseLog(this.baseLog);
            this.formChronoOffice.setStructureLog(this.structureLog);
            this.formChronoOffice.setUsersLog(this.usersLog);
            this.formChronoOffice.InstancesDaoUtilses();
            this.formChronoOffice.calculeMesModes();
            this.formChronoOffice.lesChronos(var8);
            this.utilInitHibernate.closeSession();
            this.formChronoOffice.menuGroupeListesociete();
         } else {
            String var9;
            if (var1.getIndice() == 2L) {
               this.choixLigne = "gestionRepertoire";
               var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Accueil");
               this.formGestionRepertoire = new FormGestionRepertoire();
               this.formGestionRepertoire.setUtilInitHibernate(this.utilInitHibernate);
               this.formGestionRepertoire.setBaseLog(this.baseLog);
               this.formGestionRepertoire.setStructureLog(this.structureLog);
               this.formGestionRepertoire.setUsersLog(this.usersLog);
               this.formGestionRepertoire.InstancesDaoUtilses();
               this.formGestionRepertoire.setNiveau(0);
               this.formGestionRepertoire.setNomRepertoire("Internes");
               this.formGestionRepertoire.chargerGroupe(var8);
               var9 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "commun" + File.separator + "accueil";
               this.formGestionRepertoire.lectureDossierAccueil(var9);
               this.utilInitHibernate.closeSession();
            } else if (var1.getIndice() == 3L) {
               this.choixLigne = "naturesCourrier";
               this.formNaturesCourrier = new FormNaturesCourrier();
               this.formNaturesCourrier.setutilInitHibernate(this.utilInitHibernate);
               this.formNaturesCourrier.setBaseLog(this.baseLog);
               this.formNaturesCourrier.setStructureLog(this.structureLog);
               this.formNaturesCourrier.setUsersLog(this.usersLog);
               this.formNaturesCourrier.listeNaturesCourrier();
            } else if (var1.getIndice() == 4L) {
               this.choixLigne = "naturesAffaire";
               this.formNaturesAffaires = new FormNaturesAffaires();
               this.formNaturesAffaires.setutilInitHibernate(this.utilInitHibernate);
               this.formNaturesAffaires.setBaseLog(this.baseLog);
               this.formNaturesAffaires.setStructureLog(this.structureLog);
               this.formNaturesAffaires.setUsersLog(this.usersLog);
               this.formNaturesAffaires.listeNaturesCourrier();
            } else if (var1.getIndice() == 5L) {
               if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
                  var3 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "parc" + File.separator;
                  var9 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator;
                  var5 = new File(var3);
                  File var6 = new File(var9);
                  if (var5.exists()) {
                     FileRep.copy(var5, var6);
                  }
               }

               this.choixLigne = "naturesRdv";
               this.formNaturesRdv = new FormNaturesRdv(this.baseLog, this.structureLog);
               this.formNaturesRdv.setutilInitHibernate(this.utilInitHibernate);
            } else if (var1.getIndice() == 6L) {
               this.choixLigne = "sujetRdv";
               this.formElementRdv = new FormElementRdv();
               this.formElementRdv.setutilInitHibernate(this.utilInitHibernate);
               this.formElementRdv.setBaseLog(this.baseLog);
               this.formElementRdv.setStructureLog(this.structureLog);
               this.formElementRdv.setUsersLog(this.usersLog);
               this.formElementRdv.listeSujetRdv();
            } else if (var1.getIndice() == 7L) {
               this.choixLigne = "lieuxRdv";
               this.formElementRdv = new FormElementRdv();
               this.formElementRdv.setutilInitHibernate(this.utilInitHibernate);
               this.formElementRdv.setBaseLog(this.baseLog);
               this.formElementRdv.setStructureLog(this.structureLog);
               this.formElementRdv.setUsersLog(this.usersLog);
               this.formElementRdv.listeLieuxRdv();
            } else if (var1.getIndice() == 8L) {
               this.choixLigne = "budgetRdv";
               this.formElementRdv = new FormElementRdv();
               this.formElementRdv.setutilInitHibernate(this.utilInitHibernate);
               this.formElementRdv.setBaseLog(this.baseLog);
               this.formElementRdv.setStructureLog(this.structureLog);
               this.formElementRdv.setUsersLog(this.usersLog);
               this.formElementRdv.listeBudgetRdv();
            } else if (var1.getIndice() == 9L) {
               this.choixLigne = "apportRdv";
               this.formElementRdv = new FormElementRdv();
               this.formElementRdv.setutilInitHibernate(this.utilInitHibernate);
               this.formElementRdv.setBaseLog(this.baseLog);
               this.formElementRdv.setStructureLog(this.structureLog);
               this.formElementRdv.setUsersLog(this.usersLog);
               this.formElementRdv.listeApportRdv();
            } else if (var1.getIndice() == 10L) {
               this.choixLigne = "modeFinRdv";
               this.formElementRdv = new FormElementRdv();
               this.formElementRdv.setutilInitHibernate(this.utilInitHibernate);
               this.formElementRdv.setBaseLog(this.baseLog);
               this.formElementRdv.setStructureLog(this.structureLog);
               this.formElementRdv.setUsersLog(this.usersLog);
               this.formElementRdv.listeModefinRdv();
            } else if (var1.getIndice() == 11L) {
               this.choixLigne = "delaisRdv";
               this.formElementRdv = new FormElementRdv();
               this.formElementRdv.setutilInitHibernate(this.utilInitHibernate);
               this.formElementRdv.setBaseLog(this.baseLog);
               this.formElementRdv.setStructureLog(this.structureLog);
               this.formElementRdv.setUsersLog(this.usersLog);
               this.formElementRdv.listeDelaisRdv();
            } else if (var1.getIndice() == 12L) {
               this.choixLigne = "actionRdv";
               this.formElementRdv = new FormElementRdv();
               this.formElementRdv.setutilInitHibernate(this.utilInitHibernate);
               this.formElementRdv.setBaseLog(this.baseLog);
               this.formElementRdv.setStructureLog(this.structureLog);
               this.formElementRdv.setUsersLog(this.usersLog);
               this.formElementRdv.listeActionRdv();
            } else if (var1.getIndice() == 13L) {
               this.choixLigne = "conclusionRdv";
               this.formElementRdv = new FormElementRdv();
               this.formElementRdv.setutilInitHibernate(this.utilInitHibernate);
               this.formElementRdv.setBaseLog(this.baseLog);
               this.formElementRdv.setStructureLog(this.structureLog);
               this.formElementRdv.setUsersLog(this.usersLog);
               this.formElementRdv.listeConclusionRdv();
            }
         }
      }

   }

   public void aiguillagetiers(Module var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException {
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "commun" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "commun" + File.separator;
         File var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      if (var1.getIndice() == 0L) {
         this.choixLigne = "chronosTiers";
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Site");
         this.formChronoOffice = new FormChronoOffice();
         this.formChronoOffice.setutilInitHibernate(this.utilInitHibernate);
         this.formChronoOffice.setBaseLog(this.baseLog);
         this.formChronoOffice.setStructureLog(this.structureLog);
         this.formChronoOffice.setUsersLog(this.usersLog);
         this.formChronoOffice.InstancesDaoUtilses();
         this.formChronoOffice.calculeMesModes();
         this.formChronoOffice.lesChronosTiers(var6);
         this.utilInitHibernate.closeSession();
         this.formChronoOffice.menuGroupeListesociete();
      } else if (var1.getIndice() == 1L) {
         this.choixLigne = "devises";
         this.formDevises = new FormDevises();
         this.formDevises.setutilInitHibernate(this.utilInitHibernate);
         this.formDevises.setBaseLog(this.baseLog);
         this.formDevises.setStructureLog(this.structureLog);
         this.formDevises.setUsersLog(this.usersLog);
         this.formDevises.InstancesUtilisees();
         this.formDevises.listeDevisesChoisies();
      } else if (var1.getIndice() == 2L) {
         this.choixLigne = "familleClient";
         this.formFamilleClient = new FormFamilleClient();
         this.formFamilleClient.setutilInitHibernate(this.utilInitHibernate);
         this.formFamilleClient.setBaseLog(this.baseLog);
         this.formFamilleClient.setStructureLog(this.structureLog);
         this.formFamilleClient.setUsersLog(this.usersLog);
         this.formFamilleClient.listeFamilleClient();
      } else if (var1.getIndice() == 3L) {
         this.choixLigne = "familleFournisseur";
         this.formFamilleFournisseur = new FormFamilleFournisseur();
         this.formFamilleFournisseur.setutilInitHibernate(this.utilInitHibernate);
         this.formFamilleFournisseur.setBaseLog(this.baseLog);
         this.formFamilleFournisseur.setStructureLog(this.structureLog);
         this.formFamilleFournisseur.setUsersLog(this.usersLog);
         this.formFamilleFournisseur.listeFamilleFournisseur();
      } else if (var1.getIndice() == 4L) {
         this.choixLigne = "typeReglement";
         this.formTypeReglement = new FormTypeReglement(this.baseLog);
         this.formTypeReglement.setutilInitHibernate(this.utilInitHibernate);
         this.formTypeReglement.setBaseLog(this.baseLog);
         this.formTypeReglement.setStructureLog(this.structureLog);
         this.formTypeReglement.setUsersLog(this.usersLog);
      } else if (var1.getIndice() == 5L) {
         this.choixLigne = "reglementClient";
         this.formReglementClient = new FormReglementClient(this.baseLog);
         this.formReglementClient.setutilInitHibernate(this.utilInitHibernate);
         this.formReglementClient.setBaseLog(this.baseLog);
         this.formReglementClient.setStructureLog(this.structureLog);
         this.formReglementClient.setUsersLog(this.usersLog);
         this.formReglementClient.chargerMesReglementsClt();
      } else if (var1.getIndice() == 6L) {
         this.choixLigne = "reglementFournisseur";
         this.formReglementFournisseur = new FormReglementFournisseur(this.baseLog);
         this.formReglementFournisseur.setutilInitHibernate(this.utilInitHibernate);
         this.formReglementFournisseur.setBaseLog(this.baseLog);
         this.formReglementFournisseur.setStructureLog(this.structureLog);
         this.formReglementFournisseur.setUsersLog(this.usersLog);
         this.formReglementFournisseur.chargerMesReglementsFrn();
      } else if (var1.getIndice() == 7L) {
         this.choixLigne = "appreciations";
         this.formAppreciations = new FormAppreciations();
         this.formAppreciations.setutilInitHibernate(this.utilInitHibernate);
      } else if (var1.getIndice() == 8L) {
         this.choixLigne = "civilites";
         this.formCivilites = new FormCivilites();
         this.formCivilites.setutilInitHibernate(this.utilInitHibernate);
         this.formCivilites.setBaseLog(this.baseLog);
         this.formCivilites.setStructureLog(this.structureLog);
         this.formCivilites.setUsersLog(this.usersLog);
      } else if (var1.getIndice() == 9L) {
         this.choixLigne = "sources";
         this.formSourcesTiers = new FormSourcesTiers(this.structureLog);
         this.formSourcesTiers.setutilInitHibernate(this.utilInitHibernate);
         this.formSourcesTiers.setBaseLog(this.baseLog);
         this.formSourcesTiers.setStructureLog(this.structureLog);
         this.formSourcesTiers.setUsersLog(this.usersLog);
      } else if (var1.getIndice() == 10L) {
         this.choixLigne = "categorietiers";
         this.formCategoriesTiers = new FormTypeTiers();
         this.formCategoriesTiers.setutilInitHibernate(this.utilInitHibernate);
         this.formCategoriesTiers.setBaseLog(this.baseLog);
         this.formCategoriesTiers.setStructureLog(this.structureLog);
         this.formCategoriesTiers.setUsersLog(this.usersLog);
      } else if (var1.getIndice() == 11L) {
         this.choixLigne = "activitestiers";
         this.formActivitesSocietes = new FormActivitesSocietes();
         this.formActivitesSocietes.setutilInitHibernate(this.utilInitHibernate);
         this.formActivitesSocietes.setBaseLog(this.baseLog);
         this.formActivitesSocietes.setStructureLog(this.structureLog);
         this.formActivitesSocietes.setUsersLog(this.usersLog);
         this.formActivitesSocietes.InstancesDaoUtilses();
         this.formActivitesSocietes.lesMetiers();
      } else if (var1.getIndice() == 12L) {
         this.choixLigne = "fonctions";
         this.formFonctions = new FormFonctions(this.usersLog);
         this.formFonctions.setutilInitHibernate(this.utilInitHibernate);
         this.formFonctions.setBaseLog(this.baseLog);
         this.formFonctions.setStructureLog(this.structureLog);
         this.formFonctions.setUsersLog(this.usersLog);
      } else if (var1.getIndice() == 13L) {
         this.choixLigne = "formesjuridiques";
         this.formFormesJuridiques = new FormFormesJuridiques();
         this.formFormesJuridiques.setutilInitHibernate(this.utilInitHibernate);
         this.formFormesJuridiques.setBaseLog(this.baseLog);
         this.formFormesJuridiques.setStructureLog(this.structureLog);
         this.formFormesJuridiques.setUsersLog(this.usersLog);
      } else if (var1.getIndice() == 14L) {
         this.choixLigne = "pays";
         this.formPays = new FormPays();
         this.formPays.setutilInitHibernate(this.utilInitHibernate);
         this.formPays.setBaseLog(this.baseLog);
         this.formPays.setStructureLog(this.structureLog);
         this.formPays.setUsersLog(this.usersLog);
      } else if (var1.getIndice() == 15L) {
         this.choixLigne = "banques";
         this.formBanques = new FormBanques();
         this.formBanques.setutilInitHibernate(this.utilInitHibernate);
         this.formBanques.setBaseLog(this.baseLog);
         this.formBanques.setStructureLog(this.structureLog);
         this.formBanques.setUsersLog(this.usersLog);
         this.formBanques.listeBanques();
      } else if (var1.getIndice() == 16L) {
         this.choixLigne = "centreInteret";
         this.formElementRdv = new FormElementRdv();
         this.formElementRdv.setutilInitHibernate(this.utilInitHibernate);
         this.formElementRdv.setBaseLog(this.baseLog);
         this.formElementRdv.setStructureLog(this.structureLog);
         this.formElementRdv.setUsersLog(this.usersLog);
         this.formElementRdv.listeCentreInteret();
      }

   }

   public void creationExerciceCompta() throws IOException, JDOMException, ParseException {
      this.choixModule = "moduleLigne";
      this.choixLigne = "exercicesCompta";
      this.formExercicesComptables = new FormExercicesComptables();
      this.formExercicesComptables.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesComptables.setBaseLog(this.baseLog);
      this.formExercicesComptables.setStructureLog(this.structureLog);
      this.formExercicesComptables.setUsersLog(this.usersLog);
      this.formExercicesComptables.InstancesDaoUtilses();
      this.formExercicesComptables.chargerDate();
   }

   public void miseAJourCreationCompta() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      this.taille = 0;
      this.formExercicesComptables.enregistrerExercicesCompta();
      this.selectedExo = this.formExercicesComptables.recupererLastExo((Session)null).getExecpt_id();
   }

   public void aiguillageComptaSoc(Module var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException {
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "compta" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "compta" + File.separator;
         File var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsCompta var8 = new LireLesoptionsCompta(this.structureLog);
      var8.setStrId(this.structureLog.getStrid());
      this.optionComptabilite = new OptionComptabilite();
      this.optionComptabilite = var8.lancer();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesCompta";
         this.formExercicesComptables = new FormExercicesComptables();
         this.formExercicesComptables.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesComptables.setBaseLog(this.baseLog);
         this.formExercicesComptables.setStructureLog(this.structureLog);
         this.formExercicesComptables.setUsersLog(this.usersLog);
         this.formExercicesComptables.InstancesDaoUtilses();
         this.formExercicesComptables.chargerLesExo();
      } else {
         Session var9;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsCompta";
            var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
            this.formOptionComptabilite = new FormOptionComptabilite();
            this.formOptionComptabilite.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionComptabilite.setBaseLog(this.baseLog);
            this.formOptionComptabilite.setStructureLog(this.structureLog);
            this.formOptionComptabilite.setUsersLog(this.usersLog);
            this.formOptionComptabilite.setOptionComptabilite(this.optionComptabilite);
            this.formOptionComptabilite.setMesClassesAnalytiques(var8.getMesClassesAnalytiques());
            this.formOptionComptabilite.setMesClassesBudgets(var8.getMesClassesBudgets());
            this.formOptionComptabilite.setMesCentralisations(var8.getMesCentralisations());
            boolean var10 = false;
            Object var12 = var9.createQuery("SELECT COUNT(*) FROM PlanComptable").uniqueResult();
            int var11 = Integer.parseInt(var12.toString());
            if (var11 > 0) {
               this.formOptionComptabilite.setGriserNbrCarNumCpte(true);
            } else {
               this.formOptionComptabilite.setGriserNbrCarNumCpte(false);
            }

            var10 = false;
            Object var6 = var9.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
            var11 = Integer.parseInt(var6.toString());
            if (var11 > 0) {
               this.formOptionComptabilite.setMajOptionAchats(true);
            } else {
               this.formOptionComptabilite.setMajOptionAchats(false);
            }

            Object var7 = var9.createQuery("SELECT COUNT(*) FROM ExercicesVentes").uniqueResult();
            var11 = Integer.parseInt(var7.toString());
            if (var11 > 0) {
               this.formOptionComptabilite.setMajOptionVentes(true);
            } else {
               this.formOptionComptabilite.setMajOptionVentes(false);
            }

            if (this.typeVente == 815) {
               this.formOptionComptabilite.setMajOptionMedical(true);
            } else {
               this.formOptionComptabilite.setMajOptionMedical(false);
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosCompta";
            var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoCpta = new FormChronoCpta();
            this.formChronoCpta.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoCpta.setBaseLog(this.baseLog);
            this.formChronoCpta.setStructureLog(this.structureLog);
            this.formChronoCpta.setUsersLog(this.usersLog);
            this.formChronoCpta.InstancesDaoUtilses();
            this.formChronoCpta.setSelectedExo(this.exercicesComptableDao.recupererLastExo(var9));
            this.formChronoCpta.calculeMesModes();
            this.formChronoCpta.lesChronos(var9);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "natureComptesCompta";
            this.formNaturesCompte = new FormNaturesComptes();
            this.formNaturesCompte.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesCompte.setBaseLog(this.baseLog);
            this.formNaturesCompte.setStructureLog(this.structureLog);
            this.formNaturesCompte.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "natureJournauxCompta";
            this.formNaturesJournaux = new FormNaturesJournaux();
            this.formNaturesJournaux.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesJournaux.setBaseLog(this.baseLog);
            this.formNaturesJournaux.setStructureLog(this.structureLog);
            this.formNaturesJournaux.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 5L) {
            if (this.structureLog.getStrzonefiscale() != null && !this.structureLog.getStrzonefiscale().isEmpty()) {
               this.choixLigne = "racinesCompta";
               var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Racines");
               this.formRacines = new FormRacines();
               this.formRacines.setutilInitHibernate(this.utilInitHibernate);
               this.formRacines.setBaseLog(this.baseLog);
               this.formRacines.setStructureLog(this.structureLog);
               this.formRacines.setUsersLog(this.usersLog);
               this.formRacines.InstancesDaoUtilses();
               this.formRacines.setSelectedExo(this.exercicesComptableDao.recupererLastExo(var9));
               this.formRacines.chargerMesracines(var9);
               this.utilInitHibernate.closeSession();
            } else {
               StaticModePegase.setTexte_message("Il manque l'information Zone fiscale dans l'entête de la société...");
               StaticModePegase.setAffiche_message(true);
               this.choixModule = "module";
               this.choixLigne = "";
               this.taille = 0;
            }
         } else if (var1.getIndice() == 6L) {
            if (this.structureLog.getStrzonefiscale() != null && !this.structureLog.getStrzonefiscale().isEmpty()) {
               this.choixLigne = "planComptablesCompta";
               this.formPlanComptable = new FormPlanComptable();
               this.formPlanComptable.setutilInitHibernate(this.utilInitHibernate);
               this.formPlanComptable.setBaseLog(this.baseLog);
               this.formPlanComptable.setStructureLog(this.structureLog);
               this.formPlanComptable.setUsersLog(this.usersLog);
               this.formPlanComptable.InstancesDaoUtilses();
               this.formPlanComptable.setNombrCaracter(Integer.parseInt(this.optionComptabilite.getNbcr()));
               this.formPlanComptable.chargerNatureCompte();
               this.formPlanComptable.chargerMesracines();
               this.formPlanComptable.testeFiscalite();
               var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
               this.formPlanComptable.setExoLast(this.exercicesComptableDao.recupererLastExo(var9));
               this.formPlanComptable.chargerPlanComtable(0, var9);
               this.formPlanComptable.chargerLesCles(var9);
               this.utilInitHibernate.closeSession();
            } else {
               StaticModePegase.setTexte_message("Il manque l'information Zone fiscale dans l'entête de la société...");
               StaticModePegase.setAffiche_message(true);
               this.choixModule = "module";
               this.choixLigne = "";
               this.taille = 0;
            }
         } else if (var1.getIndice() == 7L) {
            if (this.structureLog.getStrzonefiscale() != null && !this.structureLog.getStrzonefiscale().isEmpty()) {
               this.choixLigne = "journauxComptablesCompta";
               var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
               this.formJournauxComptables = new FormJournauxComptables();
               this.formJournauxComptables.setutilInitHibernate(this.utilInitHibernate);
               this.formJournauxComptables.setBaseLog(this.baseLog);
               this.formJournauxComptables.setStructureLog(this.structureLog);
               this.formJournauxComptables.setUsersLog(this.usersLog);
               this.formJournauxComptables.InstancesDaoUtilses();
               this.formJournauxComptables.setDevisePays(this.structureLog.getStrdevise());
               this.formJournauxComptables.setLastExercice(this.exercicesComptableDao.recupererLastExo(var9));
               this.formJournauxComptables.setExoSelectionne(this.exercicesComptableDao.recupererLastExo(var9));
               this.formJournauxComptables.chargerMesracines();
               this.formJournauxComptables.chargerLesJournauxComptables(var9);
               this.utilInitHibernate.closeSession();
            } else {
               StaticModePegase.setTexte_message("Il manque l'information Zone fiscale dans l'entête de la société...");
               StaticModePegase.setAffiche_message(true);
               this.choixModule = "module";
               this.choixLigne = "";
               this.taille = 0;
            }
         } else if (var1.getIndice() == 8L) {
            this.choixLigne = "localisationImmobilisation";
            var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
            this.formLocalisationImmobilisation = new FormLocalisationImmobilisation();
            this.formLocalisationImmobilisation.setutilInitHibernate(this.utilInitHibernate);
            this.formLocalisationImmobilisation.setBaseLog(this.baseLog);
            this.formLocalisationImmobilisation.setStructureLog(this.structureLog);
            this.formLocalisationImmobilisation.setUsersLog(this.usersLog);
            this.formLocalisationImmobilisation.InstancesDaoUtilses();
            this.formLocalisationImmobilisation.chargeLocalisationImmobilisation(var9);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 9L) {
            this.choixLigne = "modelesEcritures";
            var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
            this.formModelesEcritures = new FormModelesEcritures();
            this.formModelesEcritures.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesEcritures.setBaseLog(this.baseLog);
            this.formModelesEcritures.setStructureLog(this.structureLog);
            this.formModelesEcritures.setUsersLog(this.usersLog);
            this.formModelesEcritures.InstancesDaoUtilses();
            this.formModelesEcritures.setLastExercice(this.exercicesComptableDao.recupererLastExo(var9));
            this.formModelesEcritures.chargeModeles(var9);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 10L) {
            this.choixLigne = "planAnalytiqueCompta";
            var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansAnalytiques");
            this.formPlansAnalytiques = new FormPlansAnalytiques();
            this.formPlansAnalytiques.setutilInitHibernate(this.utilInitHibernate);
            this.formPlansAnalytiques.setBaseLog(this.baseLog);
            this.formPlansAnalytiques.setStructureLog(this.structureLog);
            this.formPlansAnalytiques.setUsersLog(this.usersLog);
            this.formPlansAnalytiques.InstancesDaoUtilses();
            this.formPlansAnalytiques.setLastExercice(this.exercicesComptableDao.recupererLastExo(var9));
            this.formPlansAnalytiques.setExoSelectionne(this.exercicesComptableDao.recupererLastExo(var9));
            this.formPlansAnalytiques.calculAnnee();
            this.formPlansAnalytiques.recupererAxesAnalytiques();
            this.formPlansAnalytiques.listeDevise(var9);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "planBudgetairesCompta";
            var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansBudgetaires");
            this.formPlansBudgetaires = new FormPlansBudgetaires();
            this.formPlansBudgetaires.setutilInitHibernate(this.utilInitHibernate);
            this.formPlansBudgetaires.setBaseLog(this.baseLog);
            this.formPlansBudgetaires.setStructureLog(this.structureLog);
            this.formPlansBudgetaires.setUsersLog(this.usersLog);
            this.formPlansBudgetaires.InstancesDaoUtilses();
            this.formPlansBudgetaires.setChoixBudget(0);
            this.formPlansBudgetaires.setLastExercice(this.exercicesComptableDao.recupererLastExo(var9));
            this.formPlansBudgetaires.setExoSelectionne(this.exercicesComptableDao.recupererLastExo(var9));
            this.formPlansBudgetaires.calculAnnee(var9);
            this.formPlansBudgetaires.calculActivites(var9);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 12L) {
            this.choixLigne = "planTresorerieCompta";
            var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Projets");
            this.formPlansTresorerie = new FormPlansTresorerie();
            this.formPlansTresorerie.setutilInitHibernate(this.utilInitHibernate);
            this.formPlansTresorerie.setBaseLog(this.baseLog);
            this.formPlansTresorerie.setStructureLog(this.structureLog);
            this.formPlansTresorerie.setUsersLog(this.usersLog);
            this.formPlansTresorerie.InstancesDaoUtilses();
            this.formPlansTresorerie.setLastExercice(this.exercicesComptableDao.recupererLastExo(var9));
            this.formPlansTresorerie.setExoSelectionne(this.exercicesComptableDao.recupererLastExo(var9));
            this.formPlansTresorerie.setOptionComptabilite(this.optionComptabilite);
            this.formPlansTresorerie.calculAnnee();
            this.formPlansTresorerie.setFormRecherche(this.formRecherche);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 13L) {
            if (this.structureLog.getStrzonefiscale() != null && !this.structureLog.getStrzonefiscale().isEmpty()) {
               this.choixLigne = "etatFianciersCompta";
               this.formEtatFinancierConfigClient = new FormEtatFinancierConfigClient();
               this.formEtatFinancierConfigClient.setutilInitHibernate(this.utilInitHibernate);
               this.formEtatFinancierConfigClient.setBaseLog(this.baseLog);
               this.formEtatFinancierConfigClient.setStructureLog(this.structureLog);
               this.formEtatFinancierConfigClient.setUsersLog(this.usersLog);
               this.formEtatFinancierConfigClient.InstancesDaoUtilses();
               this.formEtatFinancierConfigClient.setNature(0);
               this.formEtatFinancierConfigClient.chargerMesracines();
               this.formEtatFinancierConfigClient.chargerMesTabNom((Session)null);
            } else {
               StaticModePegase.setTexte_message("Il manque l'information Zone fiscale dans l'entête de la société...");
               StaticModePegase.setAffiche_message(true);
               this.choixModule = "module";
               this.choixLigne = "";
               this.taille = 0;
            }
         } else if (var1.getIndice() == 14L) {
            this.choixLigne = "impCompta";
            if (this.rechercheModule(40300)) {
               this.formConfigImprDocument = new FormConfigImprDocument();
               this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
               this.formConfigImprDocument.setBaseLog(this.baseLog);
               this.formConfigImprDocument.setStructureLog(this.structureLog);
               this.formConfigImprDocument.setUsersLog(this.usersLog);
               this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_projet");
               this.formConfigImprDocument.setVar_acces_rapport_ligne("");
               this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport");
               this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DE COMPTABILITE PROJET");
               this.formConfigImprDocument.chargerLesRepertoires();
               this.formConfigImprDocument.chargerSousRapport();
               this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
               this.formConfigImprDocument.setCodeModule("compta" + File.separator + "compta_projet");
            } else {
               this.formConfigImprDocument = new FormConfigImprDocument();
               this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
               this.formConfigImprDocument.setBaseLog(this.baseLog);
               this.formConfigImprDocument.setStructureLog(this.structureLog);
               this.formConfigImprDocument.setUsersLog(this.usersLog);
               this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene");
               this.formConfigImprDocument.setVar_acces_rapport_ligne("");
               this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport");
               this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DE COMPTABILITE GENERALE");
               this.formConfigImprDocument.chargerLesRepertoires();
               this.formConfigImprDocument.chargerSousRapport();
               this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
               this.formConfigImprDocument.setCodeModule("compta" + File.separator + "compta_gene");
            }
         } else if (var1.getIndice() == 15L) {
            this.choixLigne = "impCompta";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_ana");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DE COMPTABILITE ANALYTIQUE");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("compta" + File.separator + "compta_ana");
         } else if (var1.getIndice() == 16L) {
            this.choixLigne = "impCompta";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DE COMPTABILITE DES AMORTISSEMENTS,BUDGETS, BALANCES INTERACTIVES, LOYERS, TRANSFERTS");
            this.formConfigImprDocument.chargerLesRepertoires("amortissement,budget,compta_interactif,loyer,transfert");
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("compta");
         }
      }

   }

   public void creationExerciceAchat() throws IOException, JDOMException, ParseException {
      this.choixModule = "moduleLigne";
      this.choixLigne = "exercicesAchats";
      this.formExercicesAchats = new FormExercicesAchats();
      this.formExercicesAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesAchats.setBaseLog(this.baseLog);
      this.formExercicesAchats.setStructureLog(this.structureLog);
      this.formExercicesAchats.setUsersLog(this.usersLog);
      this.formExercicesAchats.InstancesDaoUtilses();
      this.formExercicesAchats.chargerDate();
   }

   public void miseAJourCreationAchat() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      this.taille = 0;
      this.formExercicesAchats.enregistrerExercicesAchats();
      this.selectedExo = this.formExercicesAchats.recupererLastExo((Session)null).getExeachId();
   }

   public void aiguillageAchats(Module var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "achats" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "achats" + File.separator;
         File var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsAchats var14 = new LireLesoptionsAchats();
      var14.setStrId(this.structureLog.getStrid());
      this.optionAchats = new OptionAchats();
      this.optionAchats = var14.lancer();
      LireLesoptionsStocks var15 = new LireLesoptionsStocks();
      var15.setStrId(this.structureLog.getStrid());
      this.optionStocks = new OptionStocks();
      this.optionStocks = var15.lancer();
      LireLesoptionsVentes var16 = new LireLesoptionsVentes();
      var16.setStrId(this.structureLog.getStrid());
      this.optionsVentes = new OptionVentes();
      this.optionsVentes = var16.lancer();
      this.journauxComptables();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesAchats";
         this.formExercicesAchats = new FormExercicesAchats();
         this.formExercicesAchats.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesAchats.setBaseLog(this.baseLog);
         this.formExercicesAchats.setStructureLog(this.structureLog);
         this.formExercicesAchats.setUsersLog(this.usersLog);
         this.formExercicesAchats.InstancesDaoUtilses();
         this.formExercicesAchats.chargerLesExo();
      } else {
         Session var17;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsAchats";
            var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsAchats");
            this.formOptionsAchats = new FormOptionsAchats();
            this.formOptionsAchats.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsAchats.setBaseLog(this.baseLog);
            this.formOptionsAchats.setStructureLog(this.structureLog);
            this.formOptionsAchats.setUsersLog(this.usersLog);
            this.formOptionsAchats.setExercicesAchats(this.exercicesAchatsDao.recupererLastExo(var17));
            this.formOptionsAchats.calculeTvaItems(var17);
            this.formOptionsAchats.setOptionAchats(this.optionAchats);
            this.formOptionsAchats.calculeLibEntete();
            boolean var6 = false;
            Object var7 = var17.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var18 = Integer.parseInt(var7.toString());
            if (var18 > 0) {
               this.formOptionsAchats.setGriseAnalytique(true);
               this.formOptionsAchats.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsAchats.setGriseAnalytique(false);
               this.formOptionsAchats.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            Object var8 = var17.createQuery("SELECT COUNT(*) FROM ExercicesVentes").uniqueResult();
            var18 = Integer.parseInt(var8.toString());
            if (var18 > 0) {
               this.formOptionsAchats.setMajOptionVentes(true);
            } else {
               this.formOptionsAchats.setMajOptionVentes(false);
            }

            if (this.typeVente == 815) {
               this.formOptionsAchats.setMajOptionMedical(true);
            } else {
               this.formOptionsAchats.setMajOptionMedical(false);
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "optionsStocks";
            this.formOptionsStocks = new FormOptionsStocks();
            this.formOptionsStocks.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsStocks.setBaseLog(this.baseLog);
            this.formOptionsStocks.setStructureLog(this.structureLog);
            this.formOptionsStocks.setUsersLog(this.usersLog);
            this.formOptionsStocks.setOptionStocks(this.optionStocks);
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "chronosAchats";
            var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoAch = new FormChronoAch();
            this.formChronoAch.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoAch.setBaseLog(this.baseLog);
            this.formChronoAch.setStructureLog(this.structureLog);
            this.formChronoAch.setUsersLog(this.usersLog);
            this.formChronoAch.InstancesDaoUtilses();
            this.formChronoAch.setExercicesAchats(this.exercicesAchatsDao.recupererLastExo(var17));
            this.formChronoAch.calculeMesModes();
            this.formChronoAch.lesChronos(var17);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "depotsAchats";
            var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "DepotAchats");
            this.formDepotAchats = new FormDepotAchats();
            this.formDepotAchats.setutilInitHibernate(this.utilInitHibernate);
            this.formDepotAchats.setBaseLog(this.baseLog);
            this.formDepotAchats.setStructureLog(this.structureLog);
            this.formDepotAchats.setUsersLog(this.usersLog);
            this.formDepotAchats.instanceDaoUtilises();
            this.formDepotAchats.setExoachIdSelect(this.exercicesAchatsDao.recupererLastExo(var17).getExeachId());
            this.formDepotAchats.chargerDepotAchat(var17);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 5L) {
            this.choixLigne = "taxesAchats";
            var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesAchats");
            this.formTaxesAchat = new FormTaxesAchat();
            this.formTaxesAchat.setutilInitHibernate(this.utilInitHibernate);
            this.formTaxesAchat.setBaseLog(this.baseLog);
            this.formTaxesAchat.setStructureLog(this.structureLog);
            this.formTaxesAchat.setUsersLog(this.usersLog);
            this.formTaxesAchat.InstancesDaoUtilses();
            this.formTaxesAchat.setExoachSelect(this.exercicesAchatsDao.recupererLastExo(var17));
            this.formTaxesAchat.lesTaxesAchats(var17);
            this.formTaxesAchat.recupererComptesItem(var17);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 6L) {
            this.choixLigne = "positionTarifaire";
            var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "DouanesPosition");
            this.formDouanes = new FormDouanes();
            this.formDouanes.setutilInitHibernate(this.utilInitHibernate);
            this.formDouanes.setBaseLog(this.baseLog);
            this.formDouanes.setStructureLog(this.structureLog);
            this.formDouanes.setUsersLog(this.usersLog);
            this.formDouanes.InstancesDaoUtilses();
            this.formDouanes.lesChapitres(var17);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 7L) {
            this.choixLigne = "naturesAchats";
            this.formNatProdAchats = new FormNaturesFamillesProduitsAchats();
            this.formNatProdAchats.setutilInitHibernate(this.utilInitHibernate);
            this.formNatProdAchats.setBaseLog(this.baseLog);
            this.formNatProdAchats.setStructureLog(this.structureLog);
            this.formNatProdAchats.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 8L) {
            this.choixLigne = "marques";
            var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "Marques");
            this.formMarques = new FormMarques();
            this.formMarques.setutilInitHibernate(this.utilInitHibernate);
            this.formMarques.setBaseLog(this.baseLog);
            this.formMarques.setStructureLog(this.structureLog);
            this.formMarques.setUsersLog(this.usersLog);
            this.formMarques.InstancesDaoUtilses();
            this.formMarques.lesMarques(var17);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 9L) {
            this.choixLigne = "couleur";
            var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "Couleur");
            this.formCouleur = new FormCouleur();
            this.formCouleur.setutilInitHibernate(this.utilInitHibernate);
            this.formCouleur.setBaseLog(this.baseLog);
            this.formCouleur.setStructureLog(this.structureLog);
            this.formCouleur.setUsersLog(this.usersLog);
            this.formCouleur.InstancesDaoUtilses();
            this.formCouleur.lesCouleurs(var17);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 10L) {
            this.choixLigne = "famillesAchats";
            var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsAchats");
            Transaction var19 = null;

            try {
               var19 = var17.beginTransaction();
               this.formFamilleProdAchats = new FormFamilleProduitsAchats();
               this.formFamilleProdAchats.setutilInitHibernate(this.utilInitHibernate);
               this.formFamilleProdAchats.setBaseLog(this.baseLog);
               this.formFamilleProdAchats.setStructureLog(this.structureLog);
               this.formFamilleProdAchats.setUsersLog(this.usersLog);
               this.formFamilleProdAchats.InstancesDaoUtilses();
               this.formFamilleProdAchats.setExercicesAchats(this.exercicesAchatsDao.recupererLastExo(var17));
               this.formFamilleProdAchats.lesFamillesProduitsAchats(var17);
               var19.commit();
            } catch (HibernateException var12) {
               if (var19 != null) {
                  var19.rollback();
               }

               throw var12;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "incoterm";
            this.formIncoterm = new FormIncoterm();
            this.formIncoterm.setutilInitHibernate(this.utilInitHibernate);
            this.formIncoterm.setBaseLog(this.baseLog);
            this.formIncoterm.setStructureLog(this.structureLog);
            this.formIncoterm.setUsersLog(this.usersLog);
            this.formIncoterm.chargerLesIncoterms();
         } else if (var1.getIndice() == 12L) {
            this.choixLigne = "formulesAchats";
            var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesAchats");
            this.formFormulesAchats = new FormFormulesAchats();
            this.formFormulesAchats.setutilInitHibernate(this.utilInitHibernate);
            this.formFormulesAchats.setBaseLog(this.baseLog);
            this.formFormulesAchats.setStructureLog(this.structureLog);
            this.formFormulesAchats.setUsersLog(this.usersLog);
            this.formFormulesAchats.InstancesDaoUtilses();
            this.formFormulesAchats.setExoachSelect(this.exercicesAchatsDao.recupererLastExo(var17));
            this.formFormulesAchats.lesFormulesAchats(var17);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 13L) {
            this.choixLigne = "unites";
            var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
            this.formUnite = new FormUnite();
            this.formUnite.setutilInitHibernate(this.utilInitHibernate);
            this.formUnite.setBaseLog(this.baseLog);
            this.formUnite.setStructureLog(this.structureLog);
            this.formUnite.setUsersLog(this.usersLog);
            this.formUnite.instanceDaoUtilises();
            this.formUnite.chargerUnite(var17);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 14L) {
            this.choixLigne = "conditionnements";
            var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
            this.formConditionnement = new FormConditionnement();
            this.formConditionnement.setutilInitHibernate(this.utilInitHibernate);
            this.formConditionnement.setBaseLog(this.baseLog);
            this.formConditionnement.setStructureLog(this.structureLog);
            this.formConditionnement.setUsersLog(this.usersLog);
            this.formConditionnement.instanceDaoUtilises();
            this.formConditionnement.chargerUnite(var17);
            this.formConditionnement.chargerConditionnement(var17);
            this.utilInitHibernate.closeSession();
         } else if (this.structureLog.getStrtypeentreprise().equals("2") && var1.getIndice() == 15L) {
            this.choixLigne = "processAchats";
            var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
            this.formProcessAchats = new FormProcessAchats();
            this.formProcessAchats.setutilInitHibernate(this.utilInitHibernate);
            this.formProcessAchats.setBaseLog(this.baseLog);
            this.formProcessAchats.setStructureLog(this.structureLog);
            this.formProcessAchats.setUsersLog(this.usersLog);
            this.formProcessAchats.InstancesDaoUtilses();
            this.formProcessAchats.chargerProcess(var17);
            this.utilInitHibernate.closeSession();
         } else if (!this.structureLog.getStrtypeentreprise().equals("2") && var1.getIndice() == 15L || this.structureLog.getStrtypeentreprise().equals("2") && var1.getIndice() == 16L) {
            this.choixLigne = "fraisTheoAchats";
            var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisTheoAchats");
            this.formFraisTheoAchats = new FormFraisTheoAchats();
            this.formFraisTheoAchats.setutilInitHibernate(this.utilInitHibernate);
            this.formFraisTheoAchats.setBaseLog(this.baseLog);
            this.formFraisTheoAchats.setStructureLog(this.structureLog);
            this.formFraisTheoAchats.setUsersLog(this.usersLog);
            this.formFraisTheoAchats.InstancesDaoUtilses();
            this.formFraisTheoAchats.chargerFeuille(var17);
            this.utilInitHibernate.closeSession();
         } else if ((this.structureLog.getStrtypeentreprise().equals("2") || var1.getIndice() != 16L) && (!this.structureLog.getStrtypeentreprise().equals("2") || var1.getIndice() != 17L)) {
            if (!this.structureLog.getStrtypeentreprise().equals("2") && var1.getIndice() == 17L || this.structureLog.getStrtypeentreprise().equals("2") && var1.getIndice() == 18L) {
               this.choixLigne = "impFournisseursAchats";
               this.formConfigImprDocument = new FormConfigImprDocument();
               this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
               this.formConfigImprDocument.setBaseLog(this.baseLog);
               this.formConfigImprDocument.setStructureLog(this.structureLog);
               this.formConfigImprDocument.setUsersLog(this.usersLog);
               this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "fournisseur");
               this.formConfigImprDocument.setVar_acces_rapport_ligne(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "produits");
               this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport");
               this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS RELATIVES AUX FOURNISSEURS");
               this.formConfigImprDocument.chargerLesRepertoires();
               this.formConfigImprDocument.chargerSousRapport();
               this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
               this.formConfigImprDocument.setCodeModule("achats" + File.separator + "fournisseur");
            } else if (!this.structureLog.getStrtypeentreprise().equals("2") && var1.getIndice() == 18L || this.structureLog.getStrtypeentreprise().equals("2") && var1.getIndice() == 19L) {
               this.choixLigne = "impFournisseursAchats";
               this.formConfigImprDocument = new FormConfigImprDocument();
               this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
               this.formConfigImprDocument.setBaseLog(this.baseLog);
               this.formConfigImprDocument.setStructureLog(this.structureLog);
               this.formConfigImprDocument.setUsersLog(this.usersLog);
               this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document");
               this.formConfigImprDocument.setVar_acces_rapport_ligne("");
               this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport");
               this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS AUX FOURNISSEURS");
               this.formConfigImprDocument.chargerLesRepertoires();
               this.formConfigImprDocument.chargerSousRapport();
               this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
               this.formConfigImprDocument.setCodeModule("achats" + File.separator + "document");
            } else if ((!this.structureLog.getStrtypeentreprise().equals("2") || var1.getIndice() != 19L) && (!this.structureLog.getStrtypeentreprise().equals("2") || var1.getIndice() != 20L)) {
               if ((this.structureLog.getStrtypeentreprise().equals("2") || var1.getIndice() != 20L) && (!this.structureLog.getStrtypeentreprise().equals("2") || var1.getIndice() != 21L)) {
                  if ((!this.structureLog.getStrtypeentreprise().equals("2") || var1.getIndice() != 21L) && (!this.structureLog.getStrtypeentreprise().equals("2") || var1.getIndice() != 22L)) {
                     if (!this.structureLog.getStrtypeentreprise().equals("2") && var1.getIndice() == 22L || this.structureLog.getStrtypeentreprise().equals("2") && var1.getIndice() == 23L) {
                        this.choixLigne = "impFournisseursAchats";
                        this.formConfigImprDocument = new FormConfigImprDocument();
                        this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
                        this.formConfigImprDocument.setBaseLog(this.baseLog);
                        this.formConfigImprDocument.setStructureLog(this.structureLog);
                        this.formConfigImprDocument.setUsersLog(this.usersLog);
                        this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "liste");
                        this.formConfigImprDocument.setVar_acces_rapport_ligne("");
                        this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "sous_rapport");
                        this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DE DOCUMENTS STOCKS");
                        this.formConfigImprDocument.chargerLesRepertoires();
                        this.formConfigImprDocument.chargerSousRapport();
                        this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
                        this.formConfigImprDocument.setCodeModule("achats" + File.separator + "liste");
                     } else if ((this.structureLog.getStrtypeentreprise().equals("2") || var1.getIndice() != 23L) && (!this.structureLog.getStrtypeentreprise().equals("2") || var1.getIndice() != 24L)) {
                        if (!this.structureLog.getStrtypeentreprise().equals("2") && var1.getIndice() == 24L || this.structureLog.getStrtypeentreprise().equals("2") && var1.getIndice() == 25L) {
                           this.choixLigne = "PlanningAvicultureAchats";
                           var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanningAvicultureAchats");
                           this.formPlanningAvicultureAchats = new FormPlanningAvicultureAchats();
                           this.formPlanningAvicultureAchats.setutilInitHibernate(this.utilInitHibernate);
                           this.formPlanningAvicultureAchats.setBaseLog(this.baseLog);
                           this.formPlanningAvicultureAchats.setStructureLog(this.structureLog);
                           this.formPlanningAvicultureAchats.setUsersLog(this.usersLog);
                           this.formPlanningAvicultureAchats.InstancesDaoUtilses();
                           this.formPlanningAvicultureAchats.chargerPlanning(var17);
                           this.utilInitHibernate.closeSession();
                        }
                     } else {
                        this.choixLigne = "habilitationsAchats";
                        var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
                        this.formHabilitation = new FormHabilitation();
                        this.formHabilitation.setutilInitHibernate(this.utilInitHibernate);
                        this.formHabilitation.setBaseLog(this.baseLog);
                        this.formHabilitation.setStructureLog(this.structureLog);
                        this.formHabilitation.setUsersLog(this.usersLog);
                        this.formHabilitation.InstancesDaoUtilses();
                        this.formHabilitation.lesHabilitationsAchats(var17);
                        this.utilInitHibernate.closeSession();
                     }
                  } else {
                     this.choixLigne = "impFournisseursAchats";
                     this.formConfigImprDocument = new FormConfigImprDocument();
                     this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
                     this.formConfigImprDocument.setBaseLog(this.baseLog);
                     this.formConfigImprDocument.setStructureLog(this.structureLog);
                     this.formConfigImprDocument.setUsersLog(this.usersLog);
                     this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document");
                     this.formConfigImprDocument.setVar_acces_rapport_ligne("");
                     this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "sous_rapport");
                     this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS STOCKS");
                     this.formConfigImprDocument.chargerLesRepertoires();
                     this.formConfigImprDocument.chargerSousRapport();
                     this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
                     this.formConfigImprDocument.setCodeModule("achats" + File.separator + "document");
                  }
               } else {
                  this.choixLigne = "impFournisseursAchats";
                  this.formConfigImprDocument = new FormConfigImprDocument();
                  this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
                  this.formConfigImprDocument.setBaseLog(this.baseLog);
                  this.formConfigImprDocument.setStructureLog(this.structureLog);
                  this.formConfigImprDocument.setUsersLog(this.usersLog);
                  this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "produit");
                  this.formConfigImprDocument.setVar_acces_rapport_ligne("");
                  this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "sous_rapport");
                  this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS RELATIVES AUX STOCKS");
                  this.formConfigImprDocument.chargerLesRepertoires();
                  this.formConfigImprDocument.chargerSousRapport();
                  this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
                  this.formConfigImprDocument.setCodeModule("achats" + File.separator + "stock");
               }
            } else {
               this.choixLigne = "impFournisseursAchats";
               this.formConfigImprDocument = new FormConfigImprDocument();
               this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
               this.formConfigImprDocument.setBaseLog(this.baseLog);
               this.formConfigImprDocument.setStructureLog(this.structureLog);
               this.formConfigImprDocument.setUsersLog(this.usersLog);
               this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste");
               this.formConfigImprDocument.setVar_acces_rapport_ligne("");
               this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport");
               this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES DOCUMENTS FOURNISSEURS");
               this.formConfigImprDocument.chargerLesRepertoires();
               this.formConfigImprDocument.chargerSousRapport();
               this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
               this.formConfigImprDocument.setCodeModule("achats" + File.separator + "liste");
            }
         } else {
            this.choixLigne = "planBudgetairesAchats";
            var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansBudgetaires");
            this.formPlansBudgetaires = new FormPlansBudgetaires();
            this.formPlansBudgetaires.setutilInitHibernate(this.utilInitHibernate);
            this.formPlansBudgetaires.setBaseLog(this.baseLog);
            this.formPlansBudgetaires.setStructureLog(this.structureLog);
            this.formPlansBudgetaires.setUsersLog(this.usersLog);
            this.formPlansBudgetaires.InstancesDaoUtilses();
            this.formPlansBudgetaires.setChoixBudget(1);
            this.formPlansBudgetaires.setLastExercice(this.exercicesComptableDao.recupererLastExo(var17));
            this.formPlansBudgetaires.setExoSelectionne(this.exercicesComptableDao.recupererLastExo(var17));
            this.formPlansBudgetaires.calculAnnee(var17);
            this.formPlansBudgetaires.calculActivites(var17);
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void creationExerciceVente() throws IOException, JDOMException, ParseException {
      this.choixModule = "moduleLigne";
      this.choixLigne = "exercicesVentes";
      this.formExercicesVentes = new FormExercicesVentes();
      this.formExercicesVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesVentes.setBaseLog(this.baseLog);
      this.formExercicesVentes.setStructureLog(this.structureLog);
      this.formExercicesVentes.setUsersLog(this.usersLog);
      this.formExercicesVentes.InstancesDaoUtilses();
      this.formExercicesVentes.chargerDate();
   }

   public void miseAJourCreationVente() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      this.taille = 0;
      this.formExercicesVentes.enregistrerExercicesVentes();
      this.selectedExo = this.formExercicesVentes.recupererLastExo((Session)null).getExevteId();
   }

   public void creationExerciceInterim() throws IOException, JDOMException, ParseException {
      this.choixModule = "moduleLigne";
      this.choixLigne = "exercicesInterim";
      this.formExercicesInterim = new FormExercicesInterim();
      this.formExercicesInterim.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesInterim.setBaseLog(this.baseLog);
      this.formExercicesInterim.setStructureLog(this.structureLog);
      this.formExercicesInterim.setUsersLog(this.usersLog);
      this.formExercicesInterim.InstancesDaoUtilses();
      this.formExercicesInterim.chargerDate();
   }

   public void miseAJourCreationInterim() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      this.taille = 0;
      this.formExercicesInterim.enregistrerExercicesVentes();
      this.selectedExo = this.formExercicesInterim.recupererLastExo((Session)null).getExevteId();
   }

   public void aiguillageVentes(Module var1) throws IOException, JDOMException, SAXException, NamingException, ParseException {
      File var4;
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "ventes" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator;
         var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsVentes var12 = new LireLesoptionsVentes();
      var12.setStrId(this.structureLog.getStrid());
      this.optionsVentes = new OptionVentes();
      this.optionsVentes = var12.lancer();
      this.journauxComptables();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesVentes";
         this.formExercicesVentes = new FormExercicesVentes();
         this.formExercicesVentes.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesVentes.setBaseLog(this.baseLog);
         this.formExercicesVentes.setStructureLog(this.structureLog);
         this.formExercicesVentes.setUsersLog(this.usersLog);
         this.formExercicesVentes.InstancesDaoUtilses();
         this.formExercicesVentes.chargerLesExo();
      } else {
         Session var13;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            this.formOptionsVentes = new FormOptionsVentes(this.structureLog);
            this.formOptionsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsVentes.setBaseLog(this.baseLog);
            this.formOptionsVentes.setStructureLog(this.structureLog);
            this.formOptionsVentes.setUsersLog(this.usersLog);
            this.formOptionsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
            this.formOptionsVentes.setOptionVentes(this.optionsVentes);
            this.formOptionsVentes.chargerFamilleVente(var13);
            this.formOptionsVentes.calculeDepotItems(var13);
            this.formOptionsVentes.calculeTvaItems(var13);
            this.formOptionsVentes.calculeLibEntete();
            boolean var14 = false;
            Object var16 = var13.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var15 = Integer.parseInt(var16.toString());
            if (var15 > 0) {
               this.formOptionsVentes.setGriseAnalytique(true);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsVentes.setGriseAnalytique(false);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            Object var6 = var13.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
            var15 = Integer.parseInt(var6.toString());
            if (var15 > 0) {
               this.formOptionsVentes.setGriseProduit(true);
               this.formOptionsVentes.setObsProduit("Les zones produits sont verrouillées car elles sont pilotées par les achats...");
            } else {
               this.formOptionsVentes.setGriseProduit(false);
               this.formOptionsVentes.setObsProduit("Les zones produits sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoVte = new FormChronoVte();
            this.formChronoVte.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoVte.setBaseLog(this.baseLog);
            this.formChronoVte.setStructureLog(this.structureLog);
            this.formChronoVte.setUsersLog(this.usersLog);
            this.formChronoVte.InstancesDaoUtilses();
            this.formChronoVte.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
            this.formChronoVte.calculeMesModes();
            this.formChronoVte.lesChronos(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "taxesVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
            this.formTaxesVentes = new FormTaxesVentes();
            this.formTaxesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formTaxesVentes.setBaseLog(this.baseLog);
            this.formTaxesVentes.setStructureLog(this.structureLog);
            this.formTaxesVentes.setUsersLog(this.usersLog);
            this.formTaxesVentes.InstancesDaoUtilses();
            this.formTaxesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formTaxesVentes.lesTaxesVentes(var13);
            this.formTaxesVentes.recupererComptesItem(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "naturesVentes";
            this.formNaturesFamillesProduits = new FormNaturesFamillesProduitsVentes();
            this.formNaturesFamillesProduits.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesFamillesProduits.setBaseLog(this.baseLog);
            this.formNaturesFamillesProduits.setStructureLog(this.structureLog);
            this.formNaturesFamillesProduits.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 5L) {
            this.choixLigne = "marques";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Marques");
            this.formMarques = new FormMarques();
            this.formMarques.setutilInitHibernate(this.utilInitHibernate);
            this.formMarques.setBaseLog(this.baseLog);
            this.formMarques.setStructureLog(this.structureLog);
            this.formMarques.setUsersLog(this.usersLog);
            this.formMarques.InstancesDaoUtilses();
            this.formMarques.lesMarques(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 6L) {
            this.choixLigne = "couleur";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Couleur");
            this.formCouleur = new FormCouleur();
            this.formCouleur.setutilInitHibernate(this.utilInitHibernate);
            this.formCouleur.setBaseLog(this.baseLog);
            this.formCouleur.setStructureLog(this.structureLog);
            this.formCouleur.setUsersLog(this.usersLog);
            this.formCouleur.InstancesDaoUtilses();
            this.formCouleur.lesCouleurs(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 7L) {
            this.choixLigne = "famillesVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            var4 = null;

            try {
               Transaction var17 = var13.beginTransaction();
               this.formFamillesProduitsVentes = new FormFamilleProduitsVentes();
               this.formFamillesProduitsVentes.setutilInitHibernate(this.utilInitHibernate);
               this.formFamillesProduitsVentes.setBaseLog(this.baseLog);
               this.formFamillesProduitsVentes.setStructureLog(this.structureLog);
               this.formFamillesProduitsVentes.setUsersLog(this.usersLog);
               this.formFamillesProduitsVentes.InstancesDaoUtilses();
               this.formFamillesProduitsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
               this.formFamillesProduitsVentes.elementsBase(80, var13);
               this.formFamillesProduitsVentes.lesFamillesProduitsVentes(var13);
               var17.commit();
            } catch (HibernateException var10) {
               if (var4 != null) {
                  var4.rollback();
               }

               throw var10;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else if (var1.getIndice() == 8L) {
            this.choixLigne = "suiviLivraisonVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviLivraisonVentes");
            this.formSuiviLivraisonVentes = new FormSuiviLivraisonVentes();
            this.formSuiviLivraisonVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formSuiviLivraisonVentes.setBaseLog(this.baseLog);
            this.formSuiviLivraisonVentes.setStructureLog(this.structureLog);
            this.formSuiviLivraisonVentes.setUsersLog(this.usersLog);
            this.formSuiviLivraisonVentes.InstancesDaoUtilses();
            this.formSuiviLivraisonVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formSuiviLivraisonVentes.lesSuiviLivraisonVentes(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 9L) {
            this.choixLigne = "incoterm";
            this.formIncoterm = new FormIncoterm();
            this.formIncoterm.setutilInitHibernate(this.utilInitHibernate);
            this.formIncoterm.setBaseLog(this.baseLog);
            this.formIncoterm.setStructureLog(this.structureLog);
            this.formIncoterm.setUsersLog(this.usersLog);
            this.formIncoterm.chargerLesIncoterms();
         } else if (var1.getIndice() == 10L) {
            this.choixLigne = "formulesVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesVentes");
            this.formFormulesVentes = new FormFormulesVentes();
            this.formFormulesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formFormulesVentes.setBaseLog(this.baseLog);
            this.formFormulesVentes.setStructureLog(this.structureLog);
            this.formFormulesVentes.setUsersLog(this.usersLog);
            this.formFormulesVentes.InstancesDaoUtilses();
            this.formFormulesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formFormulesVentes.lesFormulesVentes(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "unites";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
            this.formUnite = new FormUnite();
            this.formUnite.setutilInitHibernate(this.utilInitHibernate);
            this.formUnite.setBaseLog(this.baseLog);
            this.formUnite.setStructureLog(this.structureLog);
            this.formUnite.setUsersLog(this.usersLog);
            this.formUnite.instanceDaoUtilises();
            this.formUnite.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formUnite.chargerUnite(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 12L) {
            this.choixLigne = "conditionnements";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
            this.formConditionnement = new FormConditionnement();
            this.formConditionnement.setutilInitHibernate(this.utilInitHibernate);
            this.formConditionnement.setBaseLog(this.baseLog);
            this.formConditionnement.setStructureLog(this.structureLog);
            this.formConditionnement.setUsersLog(this.usersLog);
            this.formConditionnement.instanceDaoUtilises();
            this.formConditionnement.chargerUnite(var13);
            this.formConditionnement.chargerConditionnement(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 13L) {
            this.choixLigne = "modeleVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(0, var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 14L) {
            this.choixLigne = "modeleContrats";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(1, var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 15L) {
            this.choixLigne = "modeleDevis";
            this.formModelesDevisVentes = new FormModelesDevisVentes();
            this.formModelesDevisVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesDevisVentes.setBaseLog(this.baseLog);
            this.formModelesDevisVentes.setStructureLog(this.structureLog);
            this.formModelesDevisVentes.setUsersLog(this.usersLog);
            this.formModelesDevisVentes.listeModele();
         } else if (var1.getIndice() == 16L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "client");
            this.formConfigImprDocument.setVar_acces_rapport_ligne(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS RELATIVES AUX CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "client");
         } else if (var1.getIndice() == 17L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "document");
         } else if (var1.getIndice() == 18L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "liste");
         } else if (var1.getIndice() == 19L) {
            this.choixLigne = "habilitationsVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
            this.formHabilitation = new FormHabilitation();
            this.formHabilitation.setutilInitHibernate(this.utilInitHibernate);
            this.formHabilitation.setBaseLog(this.baseLog);
            this.formHabilitation.setStructureLog(this.structureLog);
            this.formHabilitation.setUsersLog(this.usersLog);
            this.formHabilitation.InstancesDaoUtilses();
            this.formHabilitation.lesHabilitationsVentes(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 20L) {
            this.choixLigne = "epublicationVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommVte");
            this.formPublicationProduits = new FormPublicationProduits();
            this.formPublicationProduits.setutilInitHibernate(this.utilInitHibernate);
            this.formPublicationProduits.setBaseLog(this.baseLog);
            this.formPublicationProduits.setStructureLog(this.structureLog);
            this.formPublicationProduits.setUsersLog(this.usersLog);
            this.formPublicationProduits.instanceDaoUtilises();
            this.formPublicationProduits.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
            this.formPublicationProduits.setOptionsVentes(this.optionsVentes);
            this.formPublicationProduits.recupererOptions();
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void aiguillageVentesTicket(Module var1) throws IOException, JDOMException, SAXException, NamingException, ParseException {
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "ventes" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator;
         File var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsVentes var7 = new LireLesoptionsVentes();
      var7.setStrId(this.structureLog.getStrid());
      this.optionsVentes = new OptionVentes();
      this.optionsVentes = var7.lancer();
      this.journauxComptables();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesVentes";
         this.formExercicesVentes = new FormExercicesVentes();
         this.formExercicesVentes.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesVentes.setBaseLog(this.baseLog);
         this.formExercicesVentes.setStructureLog(this.structureLog);
         this.formExercicesVentes.setUsersLog(this.usersLog);
         this.formExercicesVentes.InstancesDaoUtilses();
         this.formExercicesVentes.chargerLesExo();
      } else {
         Session var8;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            this.formOptionsVentes = new FormOptionsVentes(this.structureLog);
            this.formOptionsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsVentes.setBaseLog(this.baseLog);
            this.formOptionsVentes.setStructureLog(this.structureLog);
            this.formOptionsVentes.setUsersLog(this.usersLog);
            this.formOptionsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var8));
            this.formOptionsVentes.setOptionVentes(this.optionsVentes);
            this.formOptionsVentes.chargerFamilleVente(var8);
            this.formOptionsVentes.calculeDepotItems(var8);
            this.formOptionsVentes.calculeCaisseItems(var8);
            this.formOptionsVentes.calculeLibEntete();
            boolean var9 = false;
            Object var11 = var8.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var10 = Integer.parseInt(var11.toString());
            if (var10 > 0) {
               this.formOptionsVentes.setGriseAnalytique(true);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsVentes.setGriseAnalytique(false);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            Object var6 = var8.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
            var10 = Integer.parseInt(var6.toString());
            if (var10 > 0) {
               this.formOptionsVentes.setGriseProduit(true);
               this.formOptionsVentes.setObsProduit("Les zones produits sont verrouillées car elles sont pilotées par les achats...");
            } else {
               this.formOptionsVentes.setGriseProduit(false);
               this.formOptionsVentes.setObsProduit("Les zones produits sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosVentesTicket";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoVte = new FormChronoVte();
            this.formChronoVte.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoVte.setBaseLog(this.baseLog);
            this.formChronoVte.setStructureLog(this.structureLog);
            this.formChronoVte.setUsersLog(this.usersLog);
            this.formChronoVte.InstancesDaoUtilses();
            this.formChronoVte.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var8));
            this.formChronoVte.calculeMesModes();
            this.formChronoVte.lesChronos(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "taxesVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
            this.formTaxesVentes = new FormTaxesVentes();
            this.formTaxesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formTaxesVentes.setBaseLog(this.baseLog);
            this.formTaxesVentes.setStructureLog(this.structureLog);
            this.formTaxesVentes.setUsersLog(this.usersLog);
            this.formTaxesVentes.InstancesDaoUtilses();
            this.formTaxesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var8));
            this.formTaxesVentes.lesTaxesVentes(var8);
            this.formTaxesVentes.recupererComptesItem(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "naturesVentes";
            this.formNaturesFamillesProduits = new FormNaturesFamillesProduitsVentes();
            this.formNaturesFamillesProduits.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesFamillesProduits.setBaseLog(this.baseLog);
            this.formNaturesFamillesProduits.setStructureLog(this.structureLog);
            this.formNaturesFamillesProduits.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 5L) {
            this.choixLigne = "marques";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Marques");
            this.formMarques = new FormMarques();
            this.formMarques.setutilInitHibernate(this.utilInitHibernate);
            this.formMarques.setBaseLog(this.baseLog);
            this.formMarques.setStructureLog(this.structureLog);
            this.formMarques.setUsersLog(this.usersLog);
            this.formMarques.InstancesDaoUtilses();
            this.formMarques.lesMarques(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 6L) {
            this.choixLigne = "couleur";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Couleur");
            this.formCouleur = new FormCouleur();
            this.formCouleur.setutilInitHibernate(this.utilInitHibernate);
            this.formCouleur.setBaseLog(this.baseLog);
            this.formCouleur.setStructureLog(this.structureLog);
            this.formCouleur.setUsersLog(this.usersLog);
            this.formCouleur.InstancesDaoUtilses();
            this.formCouleur.lesCouleurs(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 7L) {
            this.choixLigne = "famillesVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            this.formFamillesProduitsVentes = new FormFamilleProduitsVentes();
            this.formFamillesProduitsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formFamillesProduitsVentes.setBaseLog(this.baseLog);
            this.formFamillesProduitsVentes.setStructureLog(this.structureLog);
            this.formFamillesProduitsVentes.setUsersLog(this.usersLog);
            this.formFamillesProduitsVentes.InstancesDaoUtilses();
            this.formFamillesProduitsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var8));
            this.formFamillesProduitsVentes.elementsBase(80, var8);
            this.formFamillesProduitsVentes.lesFamillesProduitsVentes(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 8L) {
            this.choixLigne = "suiviLivraisonVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviLivraisonVentes");
            this.formSuiviLivraisonVentes = new FormSuiviLivraisonVentes();
            this.formSuiviLivraisonVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formSuiviLivraisonVentes.setBaseLog(this.baseLog);
            this.formSuiviLivraisonVentes.setStructureLog(this.structureLog);
            this.formSuiviLivraisonVentes.setUsersLog(this.usersLog);
            this.formSuiviLivraisonVentes.InstancesDaoUtilses();
            this.formSuiviLivraisonVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var8));
            this.formSuiviLivraisonVentes.lesSuiviLivraisonVentes(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 9L) {
            this.choixLigne = "incoterm";
            this.formIncoterm = new FormIncoterm();
            this.formIncoterm.setutilInitHibernate(this.utilInitHibernate);
            this.formIncoterm.setBaseLog(this.baseLog);
            this.formIncoterm.setStructureLog(this.structureLog);
            this.formIncoterm.setUsersLog(this.usersLog);
            this.formIncoterm.chargerLesIncoterms();
         } else if (var1.getIndice() == 10L) {
            this.choixLigne = "formulesVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesVentes");
            this.formFormulesVentes = new FormFormulesVentes();
            this.formFormulesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formFormulesVentes.setBaseLog(this.baseLog);
            this.formFormulesVentes.setStructureLog(this.structureLog);
            this.formFormulesVentes.setUsersLog(this.usersLog);
            this.formFormulesVentes.InstancesDaoUtilses();
            this.formFormulesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var8));
            this.formFormulesVentes.lesFormulesVentes(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "unites";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
            this.formUnite = new FormUnite();
            this.formUnite.setutilInitHibernate(this.utilInitHibernate);
            this.formUnite.setBaseLog(this.baseLog);
            this.formUnite.setStructureLog(this.structureLog);
            this.formUnite.setUsersLog(this.usersLog);
            this.formUnite.instanceDaoUtilises();
            this.formUnite.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var8));
            this.formUnite.chargerUnite(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 12L) {
            this.choixLigne = "conditionnements";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
            this.formConditionnement = new FormConditionnement();
            this.formConditionnement.setutilInitHibernate(this.utilInitHibernate);
            this.formConditionnement.setBaseLog(this.baseLog);
            this.formConditionnement.setStructureLog(this.structureLog);
            this.formConditionnement.setUsersLog(this.usersLog);
            this.formConditionnement.instanceDaoUtilises();
            this.formConditionnement.chargerUnite(var8);
            this.formConditionnement.chargerConditionnement(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 13L) {
            this.choixLigne = "modeleVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(0, var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 14L) {
            this.choixLigne = "modeleContrats";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(1, var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 15L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "client");
            this.formConfigImprDocument.setVar_acces_rapport_ligne(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS RELATIVES AUX CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "client");
         } else if (var1.getIndice() == 16L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "document");
         } else if (var1.getIndice() == 17L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "liste");
         } else if (var1.getIndice() == 18L) {
            this.choixLigne = "habilitationsVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
            this.formHabilitation = new FormHabilitation();
            this.formHabilitation.setutilInitHibernate(this.utilInitHibernate);
            this.formHabilitation.setBaseLog(this.baseLog);
            this.formHabilitation.setStructureLog(this.structureLog);
            this.formHabilitation.setUsersLog(this.usersLog);
            this.formHabilitation.InstancesDaoUtilses();
            this.formHabilitation.lesHabilitationsVentes(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 19L) {
            this.choixLigne = "epublicationVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommVte");
            this.formPublicationProduits = new FormPublicationProduits();
            this.formPublicationProduits.setutilInitHibernate(this.utilInitHibernate);
            this.formPublicationProduits.setBaseLog(this.baseLog);
            this.formPublicationProduits.setStructureLog(this.structureLog);
            this.formPublicationProduits.setUsersLog(this.usersLog);
            this.formPublicationProduits.instanceDaoUtilises();
            this.formPublicationProduits.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var8));
            this.formPublicationProduits.setOptionsVentes(this.optionsVentes);
            this.formPublicationProduits.recupererOptions();
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void aiguillageVentesInterim(Module var1) throws IOException, JDOMException, SAXException, NamingException, ParseException {
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "ventes" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator;
         File var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsVentes var7 = new LireLesoptionsVentes();
      var7.setStrId(this.structureLog.getStrid());
      this.optionsVentes = new OptionVentes();
      this.optionsVentes = var7.lancer();
      this.journauxComptables();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesInterim";
         this.formExercicesInterim = new FormExercicesInterim();
         this.formExercicesInterim.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesInterim.setBaseLog(this.baseLog);
         this.formExercicesInterim.setStructureLog(this.structureLog);
         this.formExercicesInterim.setUsersLog(this.usersLog);
         this.formExercicesInterim.InstancesDaoUtilses();
         this.formExercicesInterim.chargerLesExo();
      } else {
         Session var8;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsInterim";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            this.formOptionsVentes = new FormOptionsVentes(this.structureLog);
            this.formOptionsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsVentes.setBaseLog(this.baseLog);
            this.formOptionsVentes.setStructureLog(this.structureLog);
            this.formOptionsVentes.setUsersLog(this.usersLog);
            this.formOptionsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var8));
            this.formOptionsVentes.setOptionVentes(this.optionsVentes);
            this.formOptionsVentes.chargerFamilleVente(var8);
            this.formOptionsVentes.calculeDepotItems(var8);
            this.formOptionsVentes.calculeTvaItems(var8);
            this.formOptionsVentes.calculeLibEntete();
            boolean var9 = false;
            Object var11 = var8.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var10 = Integer.parseInt(var11.toString());
            if (var10 > 0) {
               this.formOptionsVentes.setGriseAnalytique(true);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsVentes.setGriseAnalytique(false);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            Object var6 = var8.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
            var10 = Integer.parseInt(var6.toString());
            if (var10 > 0) {
               this.formOptionsVentes.setGriseProduit(true);
               this.formOptionsVentes.setObsProduit("Les zones produits sont verrouillées car elles sont pilotées par les achats...");
            } else {
               this.formOptionsVentes.setGriseProduit(false);
               this.formOptionsVentes.setObsProduit("Les zones produits sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosInterim";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoInt = new FormChronoInt();
            this.formChronoInt.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoInt.setBaseLog(this.baseLog);
            this.formChronoInt.setStructureLog(this.structureLog);
            this.formChronoInt.setUsersLog(this.usersLog);
            this.formChronoInt.InstancesDaoUtilses();
            this.formChronoInt.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var8));
            this.formChronoInt.calculeMesModes();
            this.formChronoInt.lesChronos(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "taxesVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
            this.formTaxesVentes = new FormTaxesVentes();
            this.formTaxesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formTaxesVentes.setBaseLog(this.baseLog);
            this.formTaxesVentes.setStructureLog(this.structureLog);
            this.formTaxesVentes.setUsersLog(this.usersLog);
            this.formTaxesVentes.InstancesDaoUtilses();
            this.formTaxesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var8));
            this.formTaxesVentes.lesTaxesVentes(var8);
            this.formTaxesVentes.recupererComptesItem(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "naturesInterim";
            this.formNaturesInterim = new FormNaturesInterim();
            this.formNaturesInterim.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesInterim.setBaseLog(this.baseLog);
            this.formNaturesInterim.setStructureLog(this.structureLog);
            this.formNaturesInterim.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 5L) {
            this.choixLigne = "famillesVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            this.formFamillesProduitsVentes = new FormFamilleProduitsVentes();
            this.formFamillesProduitsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formFamillesProduitsVentes.setBaseLog(this.baseLog);
            this.formFamillesProduitsVentes.setStructureLog(this.structureLog);
            this.formFamillesProduitsVentes.setUsersLog(this.usersLog);
            this.formFamillesProduitsVentes.InstancesDaoUtilses();
            this.formFamillesProduitsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var8));
            this.formFamillesProduitsVentes.elementsBase(80, var8);
            this.formFamillesProduitsVentes.lesFamillesProduitsVentes(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 6L) {
            this.choixLigne = "incoterm";
            this.formIncoterm = new FormIncoterm();
            this.formIncoterm.setutilInitHibernate(this.utilInitHibernate);
            this.formIncoterm.setBaseLog(this.baseLog);
            this.formIncoterm.setStructureLog(this.structureLog);
            this.formIncoterm.setUsersLog(this.usersLog);
            this.formIncoterm.chargerLesIncoterms();
         } else if (var1.getIndice() == 7L) {
            this.choixLigne = "formulesVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesVentes");
            this.formFormulesVentes = new FormFormulesVentes();
            this.formFormulesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formFormulesVentes.setBaseLog(this.baseLog);
            this.formFormulesVentes.setStructureLog(this.structureLog);
            this.formFormulesVentes.setUsersLog(this.usersLog);
            this.formFormulesVentes.InstancesDaoUtilses();
            this.formFormulesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var8));
            this.formFormulesVentes.lesFormulesVentes(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 8L) {
            this.choixLigne = "modeleVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(0, var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 9L) {
            this.choixLigne = "modeleContrats";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(1, var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 10L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "client");
            this.formConfigImprDocument.setVar_acces_rapport_ligne(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS RELATIVES AUX CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "client");
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "document");
         } else if (var1.getIndice() == 12L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "liste");
         } else if (var1.getIndice() == 13L) {
            this.choixLigne = "habilitationsVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
            this.formHabilitation = new FormHabilitation();
            this.formHabilitation.setutilInitHibernate(this.utilInitHibernate);
            this.formHabilitation.setBaseLog(this.baseLog);
            this.formHabilitation.setStructureLog(this.structureLog);
            this.formHabilitation.setUsersLog(this.usersLog);
            this.formHabilitation.InstancesDaoUtilses();
            this.formHabilitation.lesHabilitationsVentes(var8);
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void aiguillageTransit(Module var1) throws IOException, JDOMException, SAXException, NamingException, ParseException {
      File var4;
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "ventes" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator;
         var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsVentes var12 = new LireLesoptionsVentes();
      var12.setStrId(this.structureLog.getStrid());
      this.optionsVentes = new OptionVentes();
      this.optionsVentes = var12.lancer();
      this.journauxComptables();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesVentes";
         this.formExercicesVentes = new FormExercicesVentes();
         this.formExercicesVentes.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesVentes.setBaseLog(this.baseLog);
         this.formExercicesVentes.setStructureLog(this.structureLog);
         this.formExercicesVentes.setUsersLog(this.usersLog);
         this.formExercicesVentes.InstancesDaoUtilses();
         this.formExercicesVentes.chargerLesExo();
      } else {
         Session var13;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            this.formOptionsVentes = new FormOptionsVentes(this.structureLog);
            this.formOptionsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsVentes.setBaseLog(this.baseLog);
            this.formOptionsVentes.setStructureLog(this.structureLog);
            this.formOptionsVentes.setUsersLog(this.usersLog);
            this.formOptionsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
            this.formOptionsVentes.setOptionVentes(this.optionsVentes);
            this.formOptionsVentes.chargerFamilleVente(var13);
            this.formOptionsVentes.calculeDepotItems(var13);
            this.formOptionsVentes.calculeTvaItems(var13);
            this.formOptionsVentes.calculeLibEntete();
            boolean var14 = false;
            Object var16 = var13.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var15 = Integer.parseInt(var16.toString());
            if (var15 > 0) {
               this.formOptionsVentes.setGriseAnalytique(true);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsVentes.setGriseAnalytique(false);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            Object var6 = var13.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
            var15 = Integer.parseInt(var6.toString());
            if (var15 > 0) {
               this.formOptionsVentes.setGriseProduit(true);
               this.formOptionsVentes.setObsProduit("Les zones produits sont verrouillées car elles sont pilotées par les achats...");
            } else {
               this.formOptionsVentes.setGriseProduit(false);
               this.formOptionsVentes.setObsProduit("Les zones produits sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosVentesTransit";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoVte = new FormChronoVte();
            this.formChronoVte.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoVte.setBaseLog(this.baseLog);
            this.formChronoVte.setStructureLog(this.structureLog);
            this.formChronoVte.setUsersLog(this.usersLog);
            this.formChronoVte.InstancesDaoUtilses();
            this.formChronoVte.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
            this.formChronoVte.calculeMesModes();
            this.formChronoVte.lesChronos(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "taxesVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
            this.formTaxesVentes = new FormTaxesVentes();
            this.formTaxesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formTaxesVentes.setBaseLog(this.baseLog);
            this.formTaxesVentes.setStructureLog(this.structureLog);
            this.formTaxesVentes.setUsersLog(this.usersLog);
            this.formTaxesVentes.InstancesDaoUtilses();
            this.formTaxesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formTaxesVentes.lesTaxesVentes(var13);
            this.formTaxesVentes.recupererComptesItem(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "naturesVentes";
            this.formNaturesFamillesProduits = new FormNaturesFamillesProduitsVentes();
            this.formNaturesFamillesProduits.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesFamillesProduits.setBaseLog(this.baseLog);
            this.formNaturesFamillesProduits.setStructureLog(this.structureLog);
            this.formNaturesFamillesProduits.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 5L) {
            this.choixLigne = "famillesVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            var4 = null;

            try {
               Transaction var17 = var13.beginTransaction();
               this.formFamillesProduitsVentes = new FormFamilleProduitsVentes();
               this.formFamillesProduitsVentes.setutilInitHibernate(this.utilInitHibernate);
               this.formFamillesProduitsVentes.setBaseLog(this.baseLog);
               this.formFamillesProduitsVentes.setStructureLog(this.structureLog);
               this.formFamillesProduitsVentes.setUsersLog(this.usersLog);
               this.formFamillesProduitsVentes.InstancesDaoUtilses();
               this.formFamillesProduitsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
               this.formFamillesProduitsVentes.elementsBase(80, var13);
               this.formFamillesProduitsVentes.lesFamillesProduitsVentes(var13);
               var17.commit();
            } catch (HibernateException var10) {
               if (var4 != null) {
                  var4.rollback();
               }

               throw var10;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else if (var1.getIndice() == 6L) {
            this.choixLigne = "suiviLivraisonVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviLivraisonVentes");
            this.formSuiviLivraisonVentes = new FormSuiviLivraisonVentes();
            this.formSuiviLivraisonVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formSuiviLivraisonVentes.setBaseLog(this.baseLog);
            this.formSuiviLivraisonVentes.setStructureLog(this.structureLog);
            this.formSuiviLivraisonVentes.setUsersLog(this.usersLog);
            this.formSuiviLivraisonVentes.InstancesDaoUtilses();
            this.formSuiviLivraisonVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formSuiviLivraisonVentes.lesSuiviLivraisonVentes(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 7L) {
            this.choixLigne = "incoterm";
            this.formIncoterm = new FormIncoterm();
            this.formIncoterm.setutilInitHibernate(this.utilInitHibernate);
            this.formIncoterm.setBaseLog(this.baseLog);
            this.formIncoterm.setStructureLog(this.structureLog);
            this.formIncoterm.setUsersLog(this.usersLog);
            this.formIncoterm.chargerLesIncoterms();
         } else if (var1.getIndice() == 8L) {
            this.choixLigne = "formulesVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesVentes");
            this.formFormulesVentes = new FormFormulesVentes();
            this.formFormulesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formFormulesVentes.setBaseLog(this.baseLog);
            this.formFormulesVentes.setStructureLog(this.structureLog);
            this.formFormulesVentes.setUsersLog(this.usersLog);
            this.formFormulesVentes.InstancesDaoUtilses();
            this.formFormulesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formFormulesVentes.lesFormulesVentes(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 9L) {
            this.choixLigne = "unites";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
            this.formUnite = new FormUnite();
            this.formUnite.setutilInitHibernate(this.utilInitHibernate);
            this.formUnite.setBaseLog(this.baseLog);
            this.formUnite.setStructureLog(this.structureLog);
            this.formUnite.setUsersLog(this.usersLog);
            this.formUnite.instanceDaoUtilises();
            this.formUnite.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formUnite.chargerUnite(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 10L) {
            this.choixLigne = "conditionnements";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
            this.formConditionnement = new FormConditionnement();
            this.formConditionnement.setutilInitHibernate(this.utilInitHibernate);
            this.formConditionnement.setBaseLog(this.baseLog);
            this.formConditionnement.setStructureLog(this.structureLog);
            this.formConditionnement.setUsersLog(this.usersLog);
            this.formConditionnement.instanceDaoUtilises();
            this.formConditionnement.chargerUnite(var13);
            this.formConditionnement.chargerConditionnement(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "modeleVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(0, var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 12L) {
            this.choixLigne = "modeleContrats";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(1, var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 13L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "client");
            this.formConfigImprDocument.setVar_acces_rapport_ligne(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS RELATIVES AUX CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "client");
         } else if (var1.getIndice() == 14L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "document");
         } else if (var1.getIndice() == 15L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "liste");
         } else if (var1.getIndice() == 16L) {
            this.choixLigne = "habilitationsVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
            this.formHabilitation = new FormHabilitation();
            this.formHabilitation.setutilInitHibernate(this.utilInitHibernate);
            this.formHabilitation.setBaseLog(this.baseLog);
            this.formHabilitation.setStructureLog(this.structureLog);
            this.formHabilitation.setUsersLog(this.usersLog);
            this.formHabilitation.InstancesDaoUtilses();
            this.formHabilitation.lesHabilitationsVentes(var13);
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void aiguillageRestaurant(Module var1) throws IOException, JDOMException, SAXException, NamingException, ParseException {
      File var4;
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "ventes" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator;
         var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsVentes var12 = new LireLesoptionsVentes();
      var12.setStrId(this.structureLog.getStrid());
      this.optionsVentes = new OptionVentes();
      this.optionsVentes = var12.lancer();
      this.journauxComptables();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesVentes";
         this.formExercicesVentes = new FormExercicesVentes();
         this.formExercicesVentes.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesVentes.setBaseLog(this.baseLog);
         this.formExercicesVentes.setStructureLog(this.structureLog);
         this.formExercicesVentes.setUsersLog(this.usersLog);
         this.formExercicesVentes.InstancesDaoUtilses();
         this.formExercicesVentes.chargerLesExo();
      } else {
         Session var13;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            this.formOptionsVentes = new FormOptionsVentes(this.structureLog);
            this.formOptionsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsVentes.setBaseLog(this.baseLog);
            this.formOptionsVentes.setStructureLog(this.structureLog);
            this.formOptionsVentes.setUsersLog(this.usersLog);
            this.formOptionsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
            this.formOptionsVentes.setOptionVentes(this.optionsVentes);
            this.formOptionsVentes.chargerFamilleVente(var13);
            this.formOptionsVentes.calculeDepotItems(var13);
            this.formOptionsVentes.calculeTvaItems(var13);
            this.formOptionsVentes.calculeLibEntete();
            boolean var14 = false;
            Object var16 = var13.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var15 = Integer.parseInt(var16.toString());
            if (var15 > 0) {
               this.formOptionsVentes.setGriseAnalytique(true);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsVentes.setGriseAnalytique(false);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            Object var6 = var13.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
            var15 = Integer.parseInt(var6.toString());
            if (var15 > 0) {
               this.formOptionsVentes.setGriseProduit(true);
               this.formOptionsVentes.setObsProduit("Les zones produits sont verrouillées car elles sont pilotées par les achats...");
            } else {
               this.formOptionsVentes.setGriseProduit(false);
               this.formOptionsVentes.setObsProduit("Les zones produits sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoVte = new FormChronoVte();
            this.formChronoVte.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoVte.setBaseLog(this.baseLog);
            this.formChronoVte.setStructureLog(this.structureLog);
            this.formChronoVte.setUsersLog(this.usersLog);
            this.formChronoVte.InstancesDaoUtilses();
            this.formChronoVte.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
            this.formChronoVte.calculeMesModes();
            this.formChronoVte.lesChronos(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "taxesVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
            this.formTaxesVentes = new FormTaxesVentes();
            this.formTaxesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formTaxesVentes.setBaseLog(this.baseLog);
            this.formTaxesVentes.setStructureLog(this.structureLog);
            this.formTaxesVentes.setUsersLog(this.usersLog);
            this.formTaxesVentes.InstancesDaoUtilses();
            this.formTaxesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formTaxesVentes.lesTaxesVentes(var13);
            this.formTaxesVentes.recupererComptesItem(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "naturesVentes";
            this.formNaturesFamillesProduits = new FormNaturesFamillesProduitsVentes();
            this.formNaturesFamillesProduits.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesFamillesProduits.setBaseLog(this.baseLog);
            this.formNaturesFamillesProduits.setStructureLog(this.structureLog);
            this.formNaturesFamillesProduits.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 5L) {
            this.choixLigne = "famillesVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            var4 = null;

            try {
               Transaction var17 = var13.beginTransaction();
               this.formFamillesProduitsVentes = new FormFamilleProduitsVentes();
               this.formFamillesProduitsVentes.setutilInitHibernate(this.utilInitHibernate);
               this.formFamillesProduitsVentes.setBaseLog(this.baseLog);
               this.formFamillesProduitsVentes.setStructureLog(this.structureLog);
               this.formFamillesProduitsVentes.setUsersLog(this.usersLog);
               this.formFamillesProduitsVentes.InstancesDaoUtilses();
               this.formFamillesProduitsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
               this.formFamillesProduitsVentes.elementsBase(80, var13);
               this.formFamillesProduitsVentes.lesFamillesProduitsVentes(var13);
               var17.commit();
            } catch (HibernateException var10) {
               if (var4 != null) {
                  var4.rollback();
               }

               throw var10;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else if (var1.getIndice() == 6L) {
            this.choixLigne = "formulesVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesVentes");
            this.formFormulesVentes = new FormFormulesVentes();
            this.formFormulesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formFormulesVentes.setBaseLog(this.baseLog);
            this.formFormulesVentes.setStructureLog(this.structureLog);
            this.formFormulesVentes.setUsersLog(this.usersLog);
            this.formFormulesVentes.InstancesDaoUtilses();
            this.formFormulesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formFormulesVentes.lesFormulesVentes(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 7L) {
            this.choixLigne = "unites";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
            this.formUnite = new FormUnite();
            this.formUnite.setutilInitHibernate(this.utilInitHibernate);
            this.formUnite.setBaseLog(this.baseLog);
            this.formUnite.setStructureLog(this.structureLog);
            this.formUnite.setUsersLog(this.usersLog);
            this.formUnite.instanceDaoUtilises();
            this.formUnite.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formUnite.chargerUnite(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 8L) {
            this.choixLigne = "conditionnements";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
            this.formConditionnement = new FormConditionnement();
            this.formConditionnement.setutilInitHibernate(this.utilInitHibernate);
            this.formConditionnement.setBaseLog(this.baseLog);
            this.formConditionnement.setStructureLog(this.structureLog);
            this.formConditionnement.setUsersLog(this.usersLog);
            this.formConditionnement.instanceDaoUtilises();
            this.formConditionnement.chargerUnite(var13);
            this.formConditionnement.chargerConditionnement(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 9L) {
            this.choixLigne = "modeleVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(0, var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 10L) {
            this.choixLigne = "modeleContrats";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(1, var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "client");
            this.formConfigImprDocument.setVar_acces_rapport_ligne(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS RELATIVES AUX CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "client");
         } else if (var1.getIndice() == 12L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "document");
         } else if (var1.getIndice() == 13L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "liste");
         } else if (var1.getIndice() == 14L) {
            this.choixLigne = "habilitationsVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
            this.formHabilitation = new FormHabilitation();
            this.formHabilitation.setutilInitHibernate(this.utilInitHibernate);
            this.formHabilitation.setBaseLog(this.baseLog);
            this.formHabilitation.setStructureLog(this.structureLog);
            this.formHabilitation.setUsersLog(this.usersLog);
            this.formHabilitation.InstancesDaoUtilses();
            this.formHabilitation.lesHabilitationsVentes(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 15L) {
            this.choixLigne = "epublicationVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommVte");
            this.formPublicationProduits = new FormPublicationProduits();
            this.formPublicationProduits.setutilInitHibernate(this.utilInitHibernate);
            this.formPublicationProduits.setBaseLog(this.baseLog);
            this.formPublicationProduits.setStructureLog(this.structureLog);
            this.formPublicationProduits.setUsersLog(this.usersLog);
            this.formPublicationProduits.instanceDaoUtilises();
            this.formPublicationProduits.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
            this.formPublicationProduits.setOptionsVentes(this.optionsVentes);
            this.formPublicationProduits.recupererOptions();
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void aiguillageHotelerie(Module var1) throws IOException, JDOMException, SAXException, NamingException, ParseException {
      File var4;
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "ventes" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator;
         var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsVentes var12 = new LireLesoptionsVentes();
      var12.setStrId(this.structureLog.getStrid());
      this.optionsVentes = new OptionVentes();
      this.optionsVentes = var12.lancer();
      this.journauxComptables();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesVentes";
         this.formExercicesVentes = new FormExercicesVentes();
         this.formExercicesVentes.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesVentes.setBaseLog(this.baseLog);
         this.formExercicesVentes.setStructureLog(this.structureLog);
         this.formExercicesVentes.setUsersLog(this.usersLog);
         this.formExercicesVentes.InstancesDaoUtilses();
         this.formExercicesVentes.chargerLesExo();
      } else {
         Session var13;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            this.formOptionsVentes = new FormOptionsVentes(this.structureLog);
            this.formOptionsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsVentes.setBaseLog(this.baseLog);
            this.formOptionsVentes.setStructureLog(this.structureLog);
            this.formOptionsVentes.setUsersLog(this.usersLog);
            this.formOptionsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
            this.formOptionsVentes.setOptionVentes(this.optionsVentes);
            this.formOptionsVentes.chargerFamilleVente(var13);
            this.formOptionsVentes.calculeDepotItems(var13);
            this.formOptionsVentes.calculeTvaItems(var13);
            this.formOptionsVentes.calculeLibEntete();
            boolean var14 = false;
            Object var16 = var13.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var15 = Integer.parseInt(var16.toString());
            if (var15 > 0) {
               this.formOptionsVentes.setGriseAnalytique(true);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsVentes.setGriseAnalytique(false);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            Object var6 = var13.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
            var15 = Integer.parseInt(var6.toString());
            if (var15 > 0) {
               this.formOptionsVentes.setGriseProduit(true);
               this.formOptionsVentes.setObsProduit("Les zones produits sont verrouillées car elles sont pilotées par les achats...");
            } else {
               this.formOptionsVentes.setGriseProduit(false);
               this.formOptionsVentes.setObsProduit("Les zones produits sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoVte = new FormChronoVte();
            this.formChronoVte.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoVte.setBaseLog(this.baseLog);
            this.formChronoVte.setStructureLog(this.structureLog);
            this.formChronoVte.setUsersLog(this.usersLog);
            this.formChronoVte.InstancesDaoUtilses();
            this.formChronoVte.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
            this.formChronoVte.calculeMesModes();
            this.formChronoVte.lesChronos(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "taxesVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
            this.formTaxesVentes = new FormTaxesVentes();
            this.formTaxesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formTaxesVentes.setBaseLog(this.baseLog);
            this.formTaxesVentes.setStructureLog(this.structureLog);
            this.formTaxesVentes.setUsersLog(this.usersLog);
            this.formTaxesVentes.InstancesDaoUtilses();
            this.formTaxesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formTaxesVentes.lesTaxesVentes(var13);
            this.formTaxesVentes.recupererComptesItem(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "naturesVentes";
            this.formNaturesFamillesProduits = new FormNaturesFamillesProduitsVentes();
            this.formNaturesFamillesProduits.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesFamillesProduits.setBaseLog(this.baseLog);
            this.formNaturesFamillesProduits.setStructureLog(this.structureLog);
            this.formNaturesFamillesProduits.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 5L) {
            this.choixLigne = "famillesVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            var4 = null;

            try {
               Transaction var17 = var13.beginTransaction();
               this.formFamillesProduitsVentes = new FormFamilleProduitsVentes();
               this.formFamillesProduitsVentes.setutilInitHibernate(this.utilInitHibernate);
               this.formFamillesProduitsVentes.setBaseLog(this.baseLog);
               this.formFamillesProduitsVentes.setStructureLog(this.structureLog);
               this.formFamillesProduitsVentes.setUsersLog(this.usersLog);
               this.formFamillesProduitsVentes.InstancesDaoUtilses();
               this.formFamillesProduitsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
               this.formFamillesProduitsVentes.elementsBase(80, var13);
               this.formFamillesProduitsVentes.lesFamillesProduitsVentes(var13);
               var17.commit();
            } catch (HibernateException var10) {
               if (var4 != null) {
                  var4.rollback();
               }

               throw var10;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else if (var1.getIndice() == 6L) {
            this.choixLigne = "formulesVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesVentes");
            this.formFormulesVentes = new FormFormulesVentes();
            this.formFormulesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formFormulesVentes.setBaseLog(this.baseLog);
            this.formFormulesVentes.setStructureLog(this.structureLog);
            this.formFormulesVentes.setUsersLog(this.usersLog);
            this.formFormulesVentes.InstancesDaoUtilses();
            this.formFormulesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formFormulesVentes.lesFormulesVentes(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 7L) {
            this.choixLigne = "unites";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
            this.formUnite = new FormUnite();
            this.formUnite.setutilInitHibernate(this.utilInitHibernate);
            this.formUnite.setBaseLog(this.baseLog);
            this.formUnite.setStructureLog(this.structureLog);
            this.formUnite.setUsersLog(this.usersLog);
            this.formUnite.instanceDaoUtilises();
            this.formUnite.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formUnite.chargerUnite(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 8L) {
            this.choixLigne = "conditionnements";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
            this.formConditionnement = new FormConditionnement();
            this.formConditionnement.setutilInitHibernate(this.utilInitHibernate);
            this.formConditionnement.setBaseLog(this.baseLog);
            this.formConditionnement.setStructureLog(this.structureLog);
            this.formConditionnement.setUsersLog(this.usersLog);
            this.formConditionnement.instanceDaoUtilises();
            this.formConditionnement.chargerUnite(var13);
            this.formConditionnement.chargerConditionnement(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 9L) {
            this.choixLigne = "modeleVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(0, var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 10L) {
            this.choixLigne = "modeleContrats";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(1, var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "client");
            this.formConfigImprDocument.setVar_acces_rapport_ligne(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS RELATIVES AUX CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "client");
         } else if (var1.getIndice() == 12L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "document");
         } else if (var1.getIndice() == 13L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "liste");
         } else if (var1.getIndice() == 14L) {
            this.choixLigne = "habilitationsVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
            this.formHabilitation = new FormHabilitation();
            this.formHabilitation.setutilInitHibernate(this.utilInitHibernate);
            this.formHabilitation.setBaseLog(this.baseLog);
            this.formHabilitation.setStructureLog(this.structureLog);
            this.formHabilitation.setUsersLog(this.usersLog);
            this.formHabilitation.InstancesDaoUtilses();
            this.formHabilitation.lesHabilitationsVentes(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 15L) {
            this.choixLigne = "epublicationVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommVte");
            this.formPublicationProduits = new FormPublicationProduits();
            this.formPublicationProduits.setutilInitHibernate(this.utilInitHibernate);
            this.formPublicationProduits.setBaseLog(this.baseLog);
            this.formPublicationProduits.setStructureLog(this.structureLog);
            this.formPublicationProduits.setUsersLog(this.usersLog);
            this.formPublicationProduits.instanceDaoUtilises();
            this.formPublicationProduits.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
            this.formPublicationProduits.setOptionsVentes(this.optionsVentes);
            this.formPublicationProduits.recupererOptions();
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void aiguillageCabinet(Module var1) throws IOException, JDOMException, SAXException, NamingException, ParseException {
      File var4;
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "ventes" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator;
         var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsVentes var12 = new LireLesoptionsVentes();
      var12.setStrId(this.structureLog.getStrid());
      this.optionsVentes = new OptionVentes();
      this.optionsVentes = var12.lancer();
      this.journauxComptables();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesVentes";
         this.formExercicesVentes = new FormExercicesVentes();
         this.formExercicesVentes.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesVentes.setBaseLog(this.baseLog);
         this.formExercicesVentes.setStructureLog(this.structureLog);
         this.formExercicesVentes.setUsersLog(this.usersLog);
         this.formExercicesVentes.InstancesDaoUtilses();
         this.formExercicesVentes.chargerLesExo();
      } else {
         Session var13;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsVentesCabinet";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            this.formOptionsVentes = new FormOptionsVentes(this.structureLog);
            this.formOptionsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsVentes.setBaseLog(this.baseLog);
            this.formOptionsVentes.setStructureLog(this.structureLog);
            this.formOptionsVentes.setUsersLog(this.usersLog);
            this.formOptionsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
            this.formOptionsVentes.setOptionVentes(this.optionsVentes);
            this.formOptionsVentes.chargerFamilleVente(var13);
            this.formOptionsVentes.calculeDepotItems(var13);
            this.formOptionsVentes.calculeTvaItems(var13);
            this.formOptionsVentes.calculeLibEntete();
            boolean var14 = false;
            Object var16 = var13.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var15 = Integer.parseInt(var16.toString());
            if (var15 > 0) {
               this.formOptionsVentes.setGriseAnalytique(true);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsVentes.setGriseAnalytique(false);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            Object var6 = var13.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
            var15 = Integer.parseInt(var6.toString());
            if (var15 > 0) {
               this.formOptionsVentes.setGriseProduit(true);
               this.formOptionsVentes.setObsProduit("Les zones produits sont verrouillées car elles sont pilotées par les achats...");
            } else {
               this.formOptionsVentes.setGriseProduit(false);
               this.formOptionsVentes.setObsProduit("Les zones produits sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosVentesCabinet";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoVte = new FormChronoVte();
            this.formChronoVte.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoVte.setBaseLog(this.baseLog);
            this.formChronoVte.setStructureLog(this.structureLog);
            this.formChronoVte.setUsersLog(this.usersLog);
            this.formChronoVte.InstancesDaoUtilses();
            this.formChronoVte.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
            this.formChronoVte.calculeMesModes();
            this.formChronoVte.lesChronos(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "taxesVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
            this.formTaxesVentes = new FormTaxesVentes();
            this.formTaxesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formTaxesVentes.setBaseLog(this.baseLog);
            this.formTaxesVentes.setStructureLog(this.structureLog);
            this.formTaxesVentes.setUsersLog(this.usersLog);
            this.formTaxesVentes.InstancesDaoUtilses();
            this.formTaxesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formTaxesVentes.lesTaxesVentes(var13);
            this.formTaxesVentes.recupererComptesItem(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "natureMissions";
            this.formNaturesMissions = new FormNaturesMissions();
            this.formNaturesMissions.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesMissions.setBaseLog(this.baseLog);
            this.formNaturesMissions.setStructureLog(this.structureLog);
            this.formNaturesMissions.setUsersLog(this.usersLog);
            this.formNaturesMissions.listeNatureMission();
         } else if (var1.getIndice() == 5L) {
            this.choixLigne = "naturesVentes";
            this.formNaturesFamillesProduits = new FormNaturesFamillesProduitsVentes();
            this.formNaturesFamillesProduits.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesFamillesProduits.setBaseLog(this.baseLog);
            this.formNaturesFamillesProduits.setStructureLog(this.structureLog);
            this.formNaturesFamillesProduits.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 6L) {
            this.choixLigne = "famillesVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            var4 = null;

            try {
               Transaction var17 = var13.beginTransaction();
               this.formFamillesProduitsVentes = new FormFamilleProduitsVentes();
               this.formFamillesProduitsVentes.setutilInitHibernate(this.utilInitHibernate);
               this.formFamillesProduitsVentes.setBaseLog(this.baseLog);
               this.formFamillesProduitsVentes.setStructureLog(this.structureLog);
               this.formFamillesProduitsVentes.setUsersLog(this.usersLog);
               this.formFamillesProduitsVentes.InstancesDaoUtilses();
               this.formFamillesProduitsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
               this.formFamillesProduitsVentes.elementsBase(80, var13);
               this.formFamillesProduitsVentes.lesFamillesProduitsVentes(var13);
               var17.commit();
            } catch (HibernateException var10) {
               if (var4 != null) {
                  var4.rollback();
               }

               throw var10;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else if (var1.getIndice() == 7L) {
            this.choixLigne = "formulesVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesVentes");
            this.formFormulesVentes = new FormFormulesVentes();
            this.formFormulesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formFormulesVentes.setBaseLog(this.baseLog);
            this.formFormulesVentes.setStructureLog(this.structureLog);
            this.formFormulesVentes.setUsersLog(this.usersLog);
            this.formFormulesVentes.InstancesDaoUtilses();
            this.formFormulesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var13));
            this.formFormulesVentes.lesFormulesVentes(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 8L) {
            this.choixLigne = "modeleVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(0, var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 9L) {
            this.choixLigne = "modeleContrats";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(1, var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 10L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "client");
            this.formConfigImprDocument.setVar_acces_rapport_ligne(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS RELATIVES AUX CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "client");
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "document");
         } else if (var1.getIndice() == 12L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "liste");
         } else if (var1.getIndice() == 13L) {
            this.choixLigne = "habilitationsVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
            this.formHabilitation = new FormHabilitation();
            this.formHabilitation.setutilInitHibernate(this.utilInitHibernate);
            this.formHabilitation.setBaseLog(this.baseLog);
            this.formHabilitation.setStructureLog(this.structureLog);
            this.formHabilitation.setUsersLog(this.usersLog);
            this.formHabilitation.InstancesDaoUtilses();
            this.formHabilitation.lesHabilitationsVentes(var13);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 14L) {
            this.choixLigne = "epublicationVentes";
            var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommVte");
            this.formPublicationProduits = new FormPublicationProduits();
            this.formPublicationProduits.setutilInitHibernate(this.utilInitHibernate);
            this.formPublicationProduits.setBaseLog(this.baseLog);
            this.formPublicationProduits.setStructureLog(this.structureLog);
            this.formPublicationProduits.setUsersLog(this.usersLog);
            this.formPublicationProduits.instanceDaoUtilises();
            this.formPublicationProduits.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var13));
            this.formPublicationProduits.setOptionsVentes(this.optionsVentes);
            this.formPublicationProduits.recupererOptions();
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void creationExerciceCaisse() throws IOException, JDOMException, ParseException {
      this.choixModule = "moduleLigne";
      this.choixLigne = "exercicesCaisse";
      this.formExercicesCaisse = new FormExercicesCaisse();
      this.formExercicesCaisse.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesCaisse.setBaseLog(this.baseLog);
      this.formExercicesCaisse.setStructureLog(this.structureLog);
      this.formExercicesCaisse.setUsersLog(this.usersLog);
      this.formExercicesCaisse.InstancesDaoUtilses();
      this.formExercicesCaisse.chargerDate();
   }

   public void miseAJourCreationCaisse() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      this.taille = 0;
      this.formExercicesCaisse.enregistrerexercicesCaisse();
      this.selectedExo = this.formExercicesCaisse.recupererLastExo((Session)null).getExecaiId();
   }

   public void aiguillageCaisse(Module var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException, ParseException, ParseException {
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "caisses" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "caisses" + File.separator;
         File var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsCaisses var6 = new LireLesoptionsCaisses();
      var6.setStrId(this.structureLog.getStrid());
      this.optionCaisses = new OptionCaisses();
      this.optionCaisses = var6.lancer();
      this.journauxComptables();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesCaisse";
         this.formExercicesCaisse = new FormExercicesCaisse();
         this.formExercicesCaisse.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesCaisse.setBaseLog(this.baseLog);
         this.formExercicesCaisse.setStructureLog(this.structureLog);
         this.formExercicesCaisse.setUsersLog(this.usersLog);
         this.formExercicesCaisse.InstancesDaoUtilses();
         this.formExercicesCaisse.chargerLesExo();
      } else {
         Session var7;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsCaisse";
            var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formOptionsCaisse = new FormOptionsCaisse();
            this.formOptionsCaisse.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsCaisse.setBaseLog(this.baseLog);
            this.formOptionsCaisse.setStructureLog(this.structureLog);
            this.formOptionsCaisse.setUsersLog(this.usersLog);
            this.formOptionsCaisse.setOptionCaisses(this.optionCaisses);
            this.formOptionsCaisse.initlisteImp();
            this.formOptionsCaisse.calculeLibEntete();
            boolean var8 = false;
            Object var10 = var7.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var9 = Integer.parseInt(var10.toString());
            if (var9 > 0) {
               this.formOptionsCaisse.setGriseAnalytique(true);
               this.formOptionsCaisse.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsCaisse.setGriseAnalytique(false);
               this.formOptionsCaisse.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "listeOperations";
            var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
            this.formCaissesOperations = new FormCaissesOperations();
            this.formCaissesOperations.setutilInitHibernate(this.utilInitHibernate);
            this.formCaissesOperations.setBaseLog(this.baseLog);
            this.formCaissesOperations.setStructureLog(this.structureLog);
            this.formCaissesOperations.setUsersLog(this.usersLog);
            this.formCaissesOperations.InstancesDaoUtilses();
            this.formCaissesOperations.setExocaiSelect(this.exercicesCaisseDao.recupererLastExo(var7));
            this.formCaissesOperations.setExerciceComptable(this.exercicesComptableDao.recupererLastExo(var7));
            this.formCaissesOperations.chargerlesCaisses(var7);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "listeCaisse";
            var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
            this.formCaissesCommerciales = new FormCaissesCommerciales();
            this.formCaissesCommerciales.setutilInitHibernate(this.utilInitHibernate);
            this.formCaissesCommerciales.setBaseLog(this.baseLog);
            this.formCaissesCommerciales.setStructureLog(this.structureLog);
            this.formCaissesCommerciales.setUsersLog(this.usersLog);
            this.formCaissesCommerciales.InstancesDaoUtilses();
            this.formCaissesCommerciales.setExocaiSelect(this.exercicesCaisseDao.recupererLastExo(var7));
            this.formCaissesCommerciales.setExerciceComptable(this.exercicesComptableDao.recupererLastExo(var7));
            this.formCaissesCommerciales.chargerTypeReglement();
            this.formCaissesCommerciales.chargerLesChronosItems(var7);
            this.formCaissesCommerciales.chargerLesJrCaisse(var7);
            this.formCaissesCommerciales.chargerLesComptes(var7);
            this.formCaissesCommerciales.chargerLesProjets(var7);
            this.formCaissesCommerciales.lesCaisses(var7);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "chronosCaisse";
            var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
            this.formChronoCaisses = new FormChronoCaisses();
            this.formChronoCaisses.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoCaisses.setBaseLog(this.baseLog);
            this.formChronoCaisses.setStructureLog(this.structureLog);
            this.formChronoCaisses.setUsersLog(this.usersLog);
            this.formChronoCaisses.InstancesDaoUtilses();
            this.formChronoCaisses.setExercicesCaisse(this.exercicesCaisseDao.recupererLastExo(var7));
            this.formChronoCaisses.calculeMesModes();
            this.formChronoCaisses.setOptionCaisses(this.optionCaisses);
            this.formChronoCaisses.lesChronos(var7);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 5L) {
            this.choixLigne = "impCaisse";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "bonsEntreeRecu");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES RECUS DES BONS D'ENTREE");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("caisses" + File.separator + "bonsEntreeRecu");
         } else if (var1.getIndice() == 6L) {
            this.choixLigne = "impCaisse";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "bonsSortieRecu");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES RECUS DES BONS DE SORTIE");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("caisses" + File.separator + "bonsSortieRecu");
         } else if (var1.getIndice() == 7L) {
            this.choixLigne = "impCaisse";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "bonsVirementRecu");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES RECUS DES VIREMENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("caisses" + File.separator + "bonsVirementRecu");
         } else if (var1.getIndice() == 8L) {
            this.choixLigne = "impCaisse";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES RECUS DES DOCUMENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("caisses" + File.separator + "documentsRecu");
         } else if (var1.getIndice() == 9L) {
            this.choixLigne = "impCaisse";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES RECUS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("caisses" + File.separator + "liste");
         } else if (var1.getIndice() == 10L) {
            this.choixLigne = "impCaisse";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "operation");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES OPERATIONS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("caisses" + File.separator + "operation");
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "habilitationsCaisse";
            var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
            this.formHabilitation = new FormHabilitation();
            this.formHabilitation.setutilInitHibernate(this.utilInitHibernate);
            this.formHabilitation.setBaseLog(this.baseLog);
            this.formHabilitation.setStructureLog(this.structureLog);
            this.formHabilitation.setUsersLog(this.usersLog);
            this.formHabilitation.InstancesDaoUtilses();
            this.formHabilitation.lesHabilitationsCaisse(var7);
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void creationExerciceMedical() throws IOException, JDOMException, ParseException {
      this.choixModule = "moduleLigne";
      this.choixLigne = "exercicesMedical";
      this.formExercicesMedical = new FormExercicesMedical();
      this.formExercicesMedical.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesMedical.setBaseLog(this.baseLog);
      this.formExercicesMedical.setStructureLog(this.structureLog);
      this.formExercicesMedical.setUsersLog(this.usersLog);
      this.formExercicesMedical.InstancesDaoUtilses();
      this.formExercicesMedical.chargerDate();
   }

   public void miseAJourCreationMedical() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      this.taille = 0;
      this.formExercicesMedical.enregistrerExercicesVentes();
      this.selectedExo = this.formExercicesMedical.recupererLastExo((Session)null).getExevteId();
   }

   public void aiguillageMedical(Module var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "medical" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "medical" + File.separator;
         File var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsMedical var6 = new LireLesoptionsMedical();
      var6.setStrId(this.structureLog.getStrid());
      this.optionMedical = new OptionMedical();
      this.optionMedical = var6.lancer();
      this.journauxComptables();
      if (this.rechercheModule(81500)) {
         this.aiguillageMedicalInfirmerie(var1);
      } else {
         this.aiguillageMedicalHopital(var1);
      }

   }

   public void aiguillageMedicalInfirmerie(Module var1) throws IOException, JDOMException, HibernateException, NamingException, SAXException, ParseException {
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesMedical";
         this.formExercicesMedical = new FormExercicesMedical();
         this.formExercicesMedical.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesMedical.setBaseLog(this.baseLog);
         this.formExercicesMedical.setStructureLog(this.structureLog);
         this.formExercicesMedical.setUsersLog(this.usersLog);
         this.formExercicesMedical.InstancesDaoUtilses();
         this.formExercicesMedical.chargerLesExo();
      } else {
         Session var2;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formOptionsMedical = new FormOptionsMedical();
            this.formOptionsMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsMedical.setBaseLog(this.baseLog);
            this.formOptionsMedical.setStructureLog(this.structureLog);
            this.formOptionsMedical.setUsersLog(this.usersLog);
            this.formOptionsMedical.setOptionMedical(this.optionMedical);
            this.formOptionsMedical.initOption();
            boolean var3 = false;
            Object var4 = var2.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var6 = Integer.parseInt(var4.toString());
            if (var6 > 0) {
               this.formOptionsMedical.setGriseAnalytique(true);
               this.formOptionsMedical.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsMedical.setGriseAnalytique(false);
               this.formOptionsMedical.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            Object var5 = var2.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
            var6 = Integer.parseInt(var5.toString());
            if (var6 > 0) {
               this.formOptionsMedical.setGriseProduit(true);
               this.formOptionsMedical.setObsProduit("Les zones produits sont verrouillées car elles sont pilotées par les achats...");
            } else {
               this.formOptionsMedical.setGriseProduit(false);
               this.formOptionsMedical.setObsProduit("Les zones produits sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoMed = new FormChronoMed();
            this.formChronoMed.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoMed.setBaseLog(this.baseLog);
            this.formChronoMed.setStructureLog(this.structureLog);
            this.formChronoMed.setUsersLog(this.usersLog);
            this.formChronoMed.InstancesDaoUtilses();
            this.formChronoMed.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var2));
            this.formChronoMed.calculeMesModes();
            this.formChronoMed.lesChronos(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "protocolesMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProtocoleMedical");
            this.formProtocoleMedical = new FormProtocoleMedical();
            this.formProtocoleMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formProtocoleMedical.setBaseLog(this.baseLog);
            this.formProtocoleMedical.setStructureLog(this.structureLog);
            this.formProtocoleMedical.setUsersLog(this.usersLog);
            this.formProtocoleMedical.instanceDaoUtilises();
            this.formProtocoleMedical.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var2));
            this.formProtocoleMedical.chargerProtocoleMedical(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "antecedentMedical";
            this.formAntecedentCDA = new FormAntecedentCDA();
            this.formAntecedentCDA.setutilInitHibernate(this.utilInitHibernate);
            this.formAntecedentCDA.setBaseLog(this.baseLog);
            this.formAntecedentCDA.setStructureLog(this.structureLog);
            this.formAntecedentCDA.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 5L) {
            this.choixLigne = "taxesMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
            this.formTaxesVentes = new FormTaxesVentes();
            this.formTaxesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formTaxesVentes.setBaseLog(this.baseLog);
            this.formTaxesVentes.setStructureLog(this.structureLog);
            this.formTaxesVentes.setUsersLog(this.usersLog);
            this.formTaxesVentes.InstancesDaoUtilses();
            this.formTaxesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var2));
            this.formTaxesVentes.lesTaxesVentes(var2);
            this.formTaxesVentes.recupererComptesItem(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 6L) {
            this.choixLigne = "naturesMedical";
            this.formNaturesFamillesProduitsMedical = new FormNaturesFamillesProduitsMedical();
            this.formNaturesFamillesProduitsMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesFamillesProduitsMedical.setBaseLog(this.baseLog);
            this.formNaturesFamillesProduitsMedical.setStructureLog(this.structureLog);
            this.formNaturesFamillesProduitsMedical.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 7L) {
            this.choixLigne = "famillesMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsMedical");
            this.formFamillesProduitsVentes = new FormFamilleProduitsVentes();
            this.formFamillesProduitsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formFamillesProduitsVentes.setBaseLog(this.baseLog);
            this.formFamillesProduitsVentes.setStructureLog(this.structureLog);
            this.formFamillesProduitsVentes.setUsersLog(this.usersLog);
            this.formFamillesProduitsVentes.InstancesDaoUtilses();
            this.formFamillesProduitsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var2));
            this.formFamillesProduitsVentes.elementsBase(85, var2);
            this.formFamillesProduitsVentes.lesFamillesProduitsVentes(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 8L) {
            this.choixLigne = "lettresMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "LettreMedical");
            this.formLettreMedical = new FormLettreMedical();
            this.formLettreMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formLettreMedical.setBaseLog(this.baseLog);
            this.formLettreMedical.setStructureLog(this.structureLog);
            this.formLettreMedical.setUsersLog(this.usersLog);
            this.formLettreMedical.instanceDaoUtilises();
            this.formLettreMedical.setExomedIdSelect(this.exercicesVentesDao.recupererLastExo(var2).getExevteId());
            this.formLettreMedical.chargerLettreMedical(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 9L) {
            this.choixLigne = "pathologieMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "PathologieMedical");
            this.formPathologieMedical = new FormPathologieMedical();
            this.formPathologieMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formPathologieMedical.setBaseLog(this.baseLog);
            this.formPathologieMedical.setStructureLog(this.structureLog);
            this.formPathologieMedical.setUsersLog(this.usersLog);
            this.formPathologieMedical.instanceDaoUtilises();
            this.formPathologieMedical.setExomedIdSelect(this.exercicesVentesDao.recupererLastExo(var2).getExevteId());
            this.formPathologieMedical.chargerPathologieMedical(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 10L) {
            this.choixLigne = "elementsInfirmerieMedical";
            this.formElementsInfirmerie = new FormElementsInfirmerie();
            this.formElementsInfirmerie.setutilInitHibernate(this.utilInitHibernate);
            this.formElementsInfirmerie.setBaseLog(this.baseLog);
            this.formElementsInfirmerie.setStructureLog(this.structureLog);
            this.formElementsInfirmerie.setUsersLog(this.usersLog);
            this.formElementsInfirmerie.setType(1);
            this.formElementsInfirmerie.setLibelleType("Liste des Vaccins".toUpperCase());
            this.formElementsInfirmerie.chargermedicalElments();
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "elementsInfirmerieMedical";
            this.formElementsInfirmerie = new FormElementsInfirmerie();
            this.formElementsInfirmerie.setutilInitHibernate(this.utilInitHibernate);
            this.formElementsInfirmerie.setBaseLog(this.baseLog);
            this.formElementsInfirmerie.setStructureLog(this.structureLog);
            this.formElementsInfirmerie.setUsersLog(this.usersLog);
            this.formElementsInfirmerie.setType(2);
            this.formElementsInfirmerie.setLibelleType("Liste des Examens Audiométriques".toUpperCase());
            this.formElementsInfirmerie.chargermedicalElments();
         } else if (var1.getIndice() == 12L) {
            this.choixLigne = "elementsInfirmerieMedical";
            this.formElementsInfirmerie = new FormElementsInfirmerie();
            this.formElementsInfirmerie.setutilInitHibernate(this.utilInitHibernate);
            this.formElementsInfirmerie.setBaseLog(this.baseLog);
            this.formElementsInfirmerie.setStructureLog(this.structureLog);
            this.formElementsInfirmerie.setUsersLog(this.usersLog);
            this.formElementsInfirmerie.setType(3);
            this.formElementsInfirmerie.setLibelleType("Liste des Examens V.M.E.".toUpperCase());
            this.formElementsInfirmerie.chargermedicalElments();
         } else if (var1.getIndice() == 13L) {
            this.choixLigne = "elementsInfirmerieMedical";
            this.formElementsInfirmerie = new FormElementsInfirmerie();
            this.formElementsInfirmerie.setutilInitHibernate(this.utilInitHibernate);
            this.formElementsInfirmerie.setBaseLog(this.baseLog);
            this.formElementsInfirmerie.setStructureLog(this.structureLog);
            this.formElementsInfirmerie.setUsersLog(this.usersLog);
            this.formElementsInfirmerie.setType(4);
            this.formElementsInfirmerie.setLibelleType("Liste des Examens V.M.A.".toUpperCase());
            this.formElementsInfirmerie.chargermedicalElments();
         } else if (var1.getIndice() == 14L) {
            this.choixLigne = "elementsInfirmerieMedical";
            this.formElementsInfirmerie = new FormElementsInfirmerie();
            this.formElementsInfirmerie.setutilInitHibernate(this.utilInitHibernate);
            this.formElementsInfirmerie.setBaseLog(this.baseLog);
            this.formElementsInfirmerie.setStructureLog(this.structureLog);
            this.formElementsInfirmerie.setUsersLog(this.usersLog);
            this.formElementsInfirmerie.setType(5);
            this.formElementsInfirmerie.setLibelleType("Liste des Examens I.D.R.".toUpperCase());
            this.formElementsInfirmerie.chargermedicalElments();
         } else if (var1.getIndice() == 15L) {
            this.choixLigne = "motifEntreeConsultMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "MotifEntreeMedical");
            this.formMotifentreeConsultMedical = new FormMotifentreeConsultMedical();
            this.formMotifentreeConsultMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formMotifentreeConsultMedical.setBaseLog(this.baseLog);
            this.formMotifentreeConsultMedical.setStructureLog(this.structureLog);
            this.formMotifentreeConsultMedical.setUsersLog(this.usersLog);
            this.formMotifentreeConsultMedical.instanceDaoUtilises();
            this.formMotifentreeConsultMedical.setExomedIdSelect(this.exercicesVentesDao.recupererLastExo(var2).getExevteId());
            this.formMotifentreeConsultMedical.chargerMotifEntreeConsultMedical(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 16L) {
            this.choixLigne = "cimMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CimMedical");
            this.formCimMedical = new FormCimMedical();
            this.formCimMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formCimMedical.setBaseLog(this.baseLog);
            this.formCimMedical.setStructureLog(this.structureLog);
            this.formCimMedical.setUsersLog(this.usersLog);
            this.formCimMedical.InstancesDaoUtilses();
            this.formCimMedical.chargerListCimMedical(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 17L) {
            this.choixLigne = "medicamment";
            this.formMedicamment = new FormProduitsMedicamment();
            this.formMedicamment.setutilInitHibernate(this.utilInitHibernate);
            this.formMedicamment.setBaseLog(this.baseLog);
            this.formMedicamment.setStructureLog(this.structureLog);
            this.formMedicamment.setUsersLog(this.usersLog);
            this.formMedicamment.instanceDaoUtilises();
         } else if (var1.getIndice() == 18L) {
            this.choixLigne = "impMedical";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "patient");
            this.formConfigImprDocument.setVar_acces_rapport_ligne(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "produit");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS RELETIVES AUX PATIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("medical" + File.separator + "patient");
         } else if (var1.getIndice() == 19L) {
            this.choixLigne = "impMedical";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS MEDICAUX");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("medical" + File.separator + "document");
         } else if (var1.getIndice() == 20L) {
            this.choixLigne = "impMedical";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES DOCUMENTS MEDICAUX");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("medical" + File.separator + "liste");
         } else if (var1.getIndice() == 21L) {
            this.choixLigne = "habilitationsMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
            this.formHabilitation = new FormHabilitation();
            this.formHabilitation.setutilInitHibernate(this.utilInitHibernate);
            this.formHabilitation.setBaseLog(this.baseLog);
            this.formHabilitation.setStructureLog(this.structureLog);
            this.formHabilitation.setUsersLog(this.usersLog);
            this.formHabilitation.InstancesDaoUtilses();
            this.formHabilitation.lesHabilitationsMedical(var2);
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void aiguillageMedicalHopital(Module var1) throws IOException, JDOMException, HibernateException, NamingException, SAXException, ParseException {
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesMedical";
         this.formExercicesMedical = new FormExercicesMedical();
         this.formExercicesMedical.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesMedical.setBaseLog(this.baseLog);
         this.formExercicesMedical.setStructureLog(this.structureLog);
         this.formExercicesMedical.setUsersLog(this.usersLog);
         this.formExercicesMedical.InstancesDaoUtilses();
         this.formExercicesMedical.chargerLesExo();
      } else {
         Session var2;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formOptionsMedical = new FormOptionsMedical();
            this.formOptionsMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsMedical.setBaseLog(this.baseLog);
            this.formOptionsMedical.setStructureLog(this.structureLog);
            this.formOptionsMedical.setUsersLog(this.usersLog);
            this.formOptionsMedical.setOptionMedical(this.optionMedical);
            this.formOptionsMedical.initOption();
            boolean var3 = false;
            Object var4 = var2.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var6 = Integer.parseInt(var4.toString());
            if (var6 > 0) {
               this.formOptionsMedical.setGriseAnalytique(true);
               this.formOptionsMedical.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsMedical.setGriseAnalytique(false);
               this.formOptionsMedical.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            Object var5 = var2.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
            var6 = Integer.parseInt(var5.toString());
            if (var6 > 0) {
               this.formOptionsMedical.setGriseProduit(true);
               this.formOptionsMedical.setObsProduit("Les zones produits sont verrouillées car elles sont pilotées par les achats...");
            } else {
               this.formOptionsMedical.setGriseProduit(false);
               this.formOptionsMedical.setObsProduit("Les zones produits sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoMed = new FormChronoMed();
            this.formChronoMed.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoMed.setBaseLog(this.baseLog);
            this.formChronoMed.setStructureLog(this.structureLog);
            this.formChronoMed.setUsersLog(this.usersLog);
            this.formChronoMed.InstancesDaoUtilses();
            this.formChronoMed.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var2));
            this.formChronoMed.calculeMesModes();
            this.formChronoMed.lesChronos(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "protocolesMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProtocoleMedical");
            this.formProtocoleMedical = new FormProtocoleMedical();
            this.formProtocoleMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formProtocoleMedical.setBaseLog(this.baseLog);
            this.formProtocoleMedical.setStructureLog(this.structureLog);
            this.formProtocoleMedical.setUsersLog(this.usersLog);
            this.formProtocoleMedical.instanceDaoUtilises();
            this.formProtocoleMedical.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var2));
            this.formProtocoleMedical.chargerProtocoleMedical(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "antecedentMedical";
            this.formAntecedentCDA = new FormAntecedentCDA();
            this.formAntecedentCDA.setutilInitHibernate(this.utilInitHibernate);
            this.formAntecedentCDA.setBaseLog(this.baseLog);
            this.formAntecedentCDA.setStructureLog(this.structureLog);
            this.formAntecedentCDA.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 5L) {
            this.choixLigne = "taxesMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
            this.formTaxesVentes = new FormTaxesVentes();
            this.formTaxesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formTaxesVentes.setBaseLog(this.baseLog);
            this.formTaxesVentes.setStructureLog(this.structureLog);
            this.formTaxesVentes.setUsersLog(this.usersLog);
            this.formTaxesVentes.InstancesDaoUtilses();
            this.formTaxesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var2));
            this.formTaxesVentes.lesTaxesVentes(var2);
            this.formTaxesVentes.recupererComptesItem(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 6L) {
            this.choixLigne = "naturesMedical";
            this.formNaturesFamillesProduitsMedical = new FormNaturesFamillesProduitsMedical();
            this.formNaturesFamillesProduitsMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesFamillesProduitsMedical.setBaseLog(this.baseLog);
            this.formNaturesFamillesProduitsMedical.setStructureLog(this.structureLog);
            this.formNaturesFamillesProduitsMedical.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 7L) {
            this.choixLigne = "famillesMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsMedical");
            this.formFamillesProduitsVentes = new FormFamilleProduitsVentes();
            this.formFamillesProduitsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formFamillesProduitsVentes.setBaseLog(this.baseLog);
            this.formFamillesProduitsVentes.setStructureLog(this.structureLog);
            this.formFamillesProduitsVentes.setUsersLog(this.usersLog);
            this.formFamillesProduitsVentes.InstancesDaoUtilses();
            this.formFamillesProduitsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var2));
            this.formFamillesProduitsVentes.elementsBase(85, var2);
            this.formFamillesProduitsVentes.lesFamillesProduitsVentes(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 8L) {
            this.choixLigne = "lettresMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "LettreMedical");
            this.formLettreMedical = new FormLettreMedical();
            this.formLettreMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formLettreMedical.setBaseLog(this.baseLog);
            this.formLettreMedical.setStructureLog(this.structureLog);
            this.formLettreMedical.setUsersLog(this.usersLog);
            this.formLettreMedical.instanceDaoUtilises();
            this.formLettreMedical.setExomedIdSelect(this.exercicesVentesDao.recupererLastExo(var2).getExevteId());
            this.formLettreMedical.chargerLettreMedical(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 9L) {
            this.choixLigne = "pathologieMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "PathologieMedical");
            this.formPathologieMedical = new FormPathologieMedical();
            this.formPathologieMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formPathologieMedical.setBaseLog(this.baseLog);
            this.formPathologieMedical.setStructureLog(this.structureLog);
            this.formPathologieMedical.setUsersLog(this.usersLog);
            this.formPathologieMedical.instanceDaoUtilises();
            this.formPathologieMedical.setExomedIdSelect(this.exercicesVentesDao.recupererLastExo(var2).getExevteId());
            this.formPathologieMedical.chargerPathologieMedical(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 10L) {
            this.choixLigne = "motifEntreeConsultMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "MotifEntreeMedical");
            this.formMotifentreeConsultMedical = new FormMotifentreeConsultMedical();
            this.formMotifentreeConsultMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formMotifentreeConsultMedical.setBaseLog(this.baseLog);
            this.formMotifentreeConsultMedical.setStructureLog(this.structureLog);
            this.formMotifentreeConsultMedical.setUsersLog(this.usersLog);
            this.formMotifentreeConsultMedical.instanceDaoUtilises();
            this.formMotifentreeConsultMedical.setExomedIdSelect(this.exercicesVentesDao.recupererLastExo(var2).getExevteId());
            this.formMotifentreeConsultMedical.chargerMotifEntreeConsultMedical(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "motifEntreeMedical";
            this.formMotifEntreeMedical = new FormMotifEntreeMedical();
            this.formMotifEntreeMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formMotifEntreeMedical.setBaseLog(this.baseLog);
            this.formMotifEntreeMedical.setStructureLog(this.structureLog);
            this.formMotifEntreeMedical.setUsersLog(this.usersLog);
            this.formMotifEntreeMedical.chargerMedicalmotifEntree();
         } else if (var1.getIndice() == 12L) {
            this.choixLigne = "provenancesMedical";
            this.formProvenanceMedical = new FormProvenanceMedical();
            this.formProvenanceMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formProvenanceMedical.setBaseLog(this.baseLog);
            this.formProvenanceMedical.setStructureLog(this.structureLog);
            this.formProvenanceMedical.setUsersLog(this.usersLog);
            this.formProvenanceMedical.chargermedicalProvenance();
         } else if (var1.getIndice() == 13L) {
            this.choixLigne = "motifSortieMedical";
            this.formMotifSortieMedical = new FormMotifSortieMedical();
            this.formMotifSortieMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formMotifSortieMedical.setBaseLog(this.baseLog);
            this.formMotifSortieMedical.setStructureLog(this.structureLog);
            this.formMotifSortieMedical.setUsersLog(this.usersLog);
            this.formMotifSortieMedical.chargerMedicalmotifSortie();
         } else if (var1.getIndice() == 14L) {
            this.choixLigne = "destinationsMedical";
            this.formDestinationMedical = new FormDestinationMedical();
            this.formDestinationMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formDestinationMedical.setBaseLog(this.baseLog);
            this.formDestinationMedical.setStructureLog(this.structureLog);
            this.formDestinationMedical.setUsersLog(this.usersLog);
            this.formDestinationMedical.chargermedicalDestination();
         } else if (var1.getIndice() == 15L) {
            this.choixLigne = "specialitesdical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SpecialitesMedical");
            this.formSpecialitesMedical = new FormSpecialitesMedical();
            this.formSpecialitesMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formSpecialitesMedical.setBaseLog(this.baseLog);
            this.formSpecialitesMedical.setStructureLog(this.structureLog);
            this.formSpecialitesMedical.setUsersLog(this.usersLog);
            this.formSpecialitesMedical.InstancesDaoUtilses();
            this.formSpecialitesMedical.getListSpecialitesMedical(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 16L) {
            this.choixLigne = "categorieExamens";
            this.formCategorieExamen = new FormCategorieExamen();
            this.formCategorieExamen.setutilInitHibernate(this.utilInitHibernate);
            this.formCategorieExamen.setBaseLog(this.baseLog);
            this.formCategorieExamen.setStructureLog(this.structureLog);
            this.formCategorieExamen.setUsersLog(this.usersLog);
            this.formCategorieExamen.chargerCategorieExamen();
         } else if (var1.getIndice() == 17L) {
            this.choixLigne = "cmdMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CmdMedical");
            this.formCmdMedical = new FormCmdMedical();
            this.formCmdMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formCmdMedical.setBaseLog(this.baseLog);
            this.formCmdMedical.setStructureLog(this.structureLog);
            this.formCmdMedical.setUsersLog(this.usersLog);
            this.formCmdMedical.InstancesDaoUtilses();
            this.formCmdMedical.chargerListCmdMedical(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 18L) {
            this.choixLigne = "cimMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CimMedical");
            this.formCimMedical = new FormCimMedical();
            this.formCimMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formCimMedical.setBaseLog(this.baseLog);
            this.formCimMedical.setStructureLog(this.structureLog);
            this.formCimMedical.setUsersLog(this.usersLog);
            this.formCimMedical.InstancesDaoUtilses();
            this.formCimMedical.chargerListCimMedical(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 19L) {
            this.choixLigne = "ccamMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CcamMedical");
            this.formCcamMedical = new FormCcamMedical();
            this.formCcamMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formCcamMedical.setBaseLog(this.baseLog);
            this.formCcamMedical.setStructureLog(this.structureLog);
            this.formCcamMedical.setUsersLog(this.usersLog);
            this.formCcamMedical.InstancesDaoUtilses();
            this.formCcamMedical.chargerListCcamMedical(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 20L) {
            this.choixLigne = "ngapMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CcamMedical");
            this.formNgapMedical = new FormNgapMedical();
            this.formNgapMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formNgapMedical.setBaseLog(this.baseLog);
            this.formNgapMedical.setStructureLog(this.structureLog);
            this.formNgapMedical.setUsersLog(this.usersLog);
            this.formNgapMedical.InstancesDaoUtilses();
            this.formNgapMedical.chargerListNgapMedical(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 21L) {
            this.choixLigne = "camMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CmaMedical");
            this.formCmaMedical = new FormCmaMedical();
            this.formCmaMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formCmaMedical.setBaseLog(this.baseLog);
            this.formCmaMedical.setStructureLog(this.structureLog);
            this.formCmaMedical.setUsersLog(this.usersLog);
            this.formCmaMedical.InstancesDaoUtilses();
            this.formCmaMedical.chargerListCmaMedical(var2);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 22L) {
            this.choixLigne = "medicamment";
            this.formMedicamment = new FormProduitsMedicamment();
            this.formMedicamment.setutilInitHibernate(this.utilInitHibernate);
            this.formMedicamment.setBaseLog(this.baseLog);
            this.formMedicamment.setStructureLog(this.structureLog);
            this.formMedicamment.setUsersLog(this.usersLog);
            this.formMedicamment.instanceDaoUtilises();
         } else if (var1.getIndice() == 23L) {
            this.choixLigne = "commissionsMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Baremes");
            this.formCommissionsMedecins = new FormCommissionsMedecins();
            this.formCommissionsMedecins.setutilInitHibernate(this.utilInitHibernate);
            this.formCommissionsMedecins.setBaseLog(this.baseLog);
            this.formCommissionsMedecins.setStructureLog(this.structureLog);
            this.formCommissionsMedecins.setUsersLog(this.usersLog);
            this.formCommissionsMedecins.InstancesDaoUtilses();
            this.formCommissionsMedecins.lesMedecins(var2);
            this.formCommissionsMedecins.lesFamillesProduits(var2);
            this.formCommissionsMedecins.setFormRecherche(this.formRecherche);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 24L) {
            this.choixLigne = "impMedical";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "patient");
            this.formConfigImprDocument.setVar_acces_rapport_ligne(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "produit");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS RELETIVES AUX PATIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("medical" + File.separator + "patient");
         } else if (var1.getIndice() == 25L) {
            this.choixLigne = "impMedical";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS MEDICAUX");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("medical" + File.separator + "document");
         } else if (var1.getIndice() == 26L) {
            this.choixLigne = "impMedical";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES DOCUMENTS MEDICAUX");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("medical" + File.separator + "liste");
         } else if (var1.getIndice() == 27L) {
            this.choixLigne = "habilitationsMedical";
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
            this.formHabilitation = new FormHabilitation();
            this.formHabilitation.setutilInitHibernate(this.utilInitHibernate);
            this.formHabilitation.setBaseLog(this.baseLog);
            this.formHabilitation.setStructureLog(this.structureLog);
            this.formHabilitation.setUsersLog(this.usersLog);
            this.formHabilitation.InstancesDaoUtilses();
            this.formHabilitation.lesHabilitationsMedical(var2);
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void creationExerciceParc() throws IOException, JDOMException, ParseException {
      this.choixModule = "moduleLigne";
      this.choixLigne = "exercicesParc";
      this.formExercicesParcs = new FormExercicesParcs();
      this.formExercicesParcs.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesParcs.setBaseLog(this.baseLog);
      this.formExercicesParcs.setStructureLog(this.structureLog);
      this.formExercicesParcs.setUsersLog(this.usersLog);
      this.formExercicesParcs.InstancesDaoUtilses();
      this.formExercicesParcs.chargerDate();
   }

   public void miseAJourCreationParc() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      this.taille = 0;
      this.formExercicesParcs.enregistrerExercicesParcs();
      this.selectedExo = this.formExercicesParcs.recupererLastExo((Session)null).getExeprcId();
   }

   public void aiguillageParc(Module var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      String var3;
      File var5;
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "parc" + File.separator;
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "parc" + File.separator;
         File var4 = new File(var2);
         var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsParcs var7 = new LireLesoptionsParcs();
      var7.setStrId(this.structureLog.getStrid());
      this.optionParcs = new OptionParcs();
      this.optionParcs = var7.lancer();
      this.journauxComptables();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesParc";
         this.formExercicesParcs = new FormExercicesParcs();
         this.formExercicesParcs.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesParcs.setBaseLog(this.baseLog);
         this.formExercicesParcs.setStructureLog(this.structureLog);
         this.formExercicesParcs.setUsersLog(this.usersLog);
         this.formExercicesParcs.InstancesDaoUtilses();
         this.formExercicesParcs.chargerLesExo();
      } else {
         Session var8;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsParc";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
            this.formOptionsParc = new FormOptionsParc();
            this.formOptionsParc.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsParc.setBaseLog(this.baseLog);
            this.formOptionsParc.setStructureLog(this.structureLog);
            this.formOptionsParc.setExercicesParc(this.exercicesParcsDao.recupererLastExo(var8));
            this.formOptionsParc.calculeTvaItems(var8);
            this.formOptionsParc.setUsersLog(this.usersLog);
            this.formOptionsParc.setOptionParcs(this.optionParcs);
            this.formOptionsParc.calculeLibEntete();
            boolean var9 = false;
            Object var11 = var8.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var10 = Integer.parseInt(var11.toString());
            if (var10 > 0) {
               this.formOptionsParc.setGriseAnalytique(true);
               this.formOptionsParc.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsParc.setGriseAnalytique(false);
               this.formOptionsParc.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            Object var6 = var8.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
            var10 = Integer.parseInt(var6.toString());
            if (var10 > 0) {
               this.formOptionsParc.setGriseProduit(true);
               this.formOptionsParc.setObsProduit("Les zones produits sont verrouillées car elles sont pilotées par les achats...");
            } else {
               this.formOptionsParc.setGriseProduit(false);
               this.formOptionsParc.setObsProduit("Les zones produits sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosParc";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoParcs = new FormChronoParcs();
            this.formChronoParcs.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoParcs.setBaseLog(this.baseLog);
            this.formChronoParcs.setStructureLog(this.structureLog);
            this.formChronoParcs.setUsersLog(this.usersLog);
            this.formChronoParcs.InstancesDaoUtilses();
            this.formChronoParcs.setExercicesParc(this.exercicesParcsDao.recupererLastExo(var8));
            this.formChronoParcs.calculeMesModes();
            this.formChronoParcs.lesChronos(var8);
            this.utilInitHibernate.closeSession();
         } else {
            String var12;
            File var13;
            if (var1.getIndice() == 3L) {
               if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
                  var3 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "parc" + File.separator;
                  var12 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "parc" + File.separator;
                  var5 = new File(var3);
                  var13 = new File(var12);
                  if (var5.exists()) {
                     FileRep.copy(var5, var13);
                  }
               }

               this.choixLigne = "naturesParc";
               this.formNaturesFamillesProduitsParcs = new FormNaturesFamillesProduitsParcs(this.baseLog, this.structureLog);
               this.formNaturesFamillesProduitsParcs.setutilInitHibernate(this.utilInitHibernate);
            } else if (var1.getIndice() == 4L) {
               this.choixLigne = "famillesParc";
               this.formFamilleParcs = new FormFamilleParcs(this.baseLog);
               this.formFamilleParcs.setutilInitHibernate(this.utilInitHibernate);
               this.formFamilleParcs.setBaseLog(this.baseLog);
               this.formFamilleParcs.setStructureLog(this.structureLog);
               this.formFamilleParcs.setUsersLog(this.usersLog);
               this.formFamilleParcs.InstancesDaoUtilses();
               this.formFamilleParcs.chargerLesNatures();
            } else if (var1.getIndice() == 5L) {
               this.choixLigne = "caracteristiquesParc";
               var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamilleParc");
               this.formCaracteristiquesParcs = new FormCaracteristiquesParcs();
               this.formCaracteristiquesParcs.setutilInitHibernate(this.utilInitHibernate);
               this.formCaracteristiquesParcs.setBaseLog(this.baseLog);
               this.formCaracteristiquesParcs.setStructureLog(this.structureLog);
               this.formCaracteristiquesParcs.setUsersLog(this.usersLog);
               this.formCaracteristiquesParcs.InstancesDaoUtilses();
               this.formCaracteristiquesParcs.chargerLesFamilles(var8);
               this.utilInitHibernate.closeSession();
            } else if (var1.getIndice() == 6L) {
               this.choixLigne = "motifEntreeParc";
               var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "MotifEntreeParc");
               this.formMotifEntreeParc = new FormMotifEntreeParc();
               this.formMotifEntreeParc.setutilInitHibernate(this.utilInitHibernate);
               this.formMotifEntreeParc.setBaseLog(this.baseLog);
               this.formMotifEntreeParc.setStructureLog(this.structureLog);
               this.formMotifEntreeParc.setUsersLog(this.usersLog);
               this.formMotifEntreeParc.instanceDaoUtilises();
               this.formMotifEntreeParc.chargerMotifs(var8);
               this.utilInitHibernate.closeSession();
            } else if (var1.getIndice() == 7L) {
               this.choixLigne = "transitPortVentes";
               var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
               this.formTransitPortVentes = new FormTransitPortVentes();
               this.formTransitPortVentes.setUtilInitHibernate(this.utilInitHibernate);
               this.formTransitPortVentes.setBaseLog(this.baseLog);
               this.formTransitPortVentes.setStructureLog(this.structureLog);
               this.formTransitPortVentes.setUsersLog(this.usersLog);
               this.formTransitPortVentes.InstancesDaoUtilses();
               this.formTransitPortVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var8));
               this.formTransitPortVentes.lesTransitPortVentes(var8);
               this.utilInitHibernate.closeSession();
            } else if (var1.getIndice() == 8L) {
               this.choixLigne = "transitLieuVentes";
               var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
               this.formTransitLieuVentes = new FormTransitLieuVentes();
               this.formTransitLieuVentes.setUtilInitHibernate(this.utilInitHibernate);
               this.formTransitLieuVentes.setBaseLog(this.baseLog);
               this.formTransitLieuVentes.setStructureLog(this.structureLog);
               this.formTransitLieuVentes.setUsersLog(this.usersLog);
               this.formTransitLieuVentes.InstancesDaoUtilses();
               this.formTransitLieuVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var8));
               this.formTransitLieuVentes.lesTransitLieuVentes(var8);
               this.utilInitHibernate.closeSession();
            } else if (var1.getIndice() == 9L) {
               if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
                  var3 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "parc" + File.separator;
                  var12 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "parc" + File.separator;
                  var5 = new File(var3);
                  var13 = new File(var12);
                  if (var5.exists()) {
                     FileRep.copy(var5, var13);
                  }
               }

               this.choixLigne = "naturesManifest";
               this.formNaturesManifest = new FormNaturesManifest(this.baseLog, this.structureLog);
               this.formNaturesManifest.setutilInitHibernate(this.utilInitHibernate);
            } else if (var1.getIndice() == 10L) {
               this.choixLigne = "impParc";
               this.formConfigImprDocument = new FormConfigImprDocument();
               this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
               this.formConfigImprDocument.setBaseLog(this.baseLog);
               this.formConfigImprDocument.setStructureLog(this.structureLog);
               this.formConfigImprDocument.setUsersLog(this.usersLog);
               this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document");
               this.formConfigImprDocument.setVar_acces_rapport_ligne("");
               this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "sous_rapport");
               this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS DES PARCS");
               this.formConfigImprDocument.chargerLesRepertoires();
               this.formConfigImprDocument.chargerSousRapport();
               this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
               this.formConfigImprDocument.setCodeModule("parc" + File.separator + "document");
            } else if (var1.getIndice() == 11L) {
               this.choixLigne = "impParc";
               this.formConfigImprDocument = new FormConfigImprDocument();
               this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
               this.formConfigImprDocument.setBaseLog(this.baseLog);
               this.formConfigImprDocument.setStructureLog(this.structureLog);
               this.formConfigImprDocument.setUsersLog(this.usersLog);
               this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste");
               this.formConfigImprDocument.setVar_acces_rapport_ligne("");
               this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "sous_rapport");
               this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTE DES DOCUMENTS DES PARCS");
               this.formConfigImprDocument.chargerLesRepertoires();
               this.formConfigImprDocument.chargerSousRapport();
               this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
               this.formConfigImprDocument.setCodeModule("parc" + File.separator + "liste");
            }
         }
      }

   }

   public void creationExercicePaye() throws IOException, JDOMException, ParseException, HibernateException, NamingException {
      this.choixModule = "moduleLigne";
      this.choixLigne = "exercicesPaye";
      this.formExercicesPaye = new FormExercicesPaye();
      this.formExercicesPaye.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesPaye.setBaseLog(this.baseLog);
      this.formExercicesPaye.setStructureLog(this.structureLog);
      this.formExercicesPaye.setUsersLog(this.usersLog);
      this.formExercicesPaye.InstancesDaoUtilses();
      this.formExercicesPaye.chargerDate();
   }

   public void miseAJourCreationPaye() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      this.taille = 0;
      this.formExercicesPaye.enregistrerExercicesPaye();
      this.selectedExo = this.formExercicesPaye.recupererLastExo((Session)null).getExepayId();
   }

   public void aiguillagePaye(Module var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      String var3;
      File var5;
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "paye" + File.separator;
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator;
         File var4 = new File(var2);
         var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsPaye var7 = new LireLesoptionsPaye();
      var7.setStrId(this.structureLog.getStrid());
      this.optionPaye = new OptionPaye();
      this.optionPaye = var7.lancer();
      this.journauxComptables();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesPaye";
         this.formExercicesPaye = new FormExercicesPaye();
         this.formExercicesPaye.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesPaye.setBaseLog(this.baseLog);
         this.formExercicesPaye.setStructureLog(this.structureLog);
         this.formExercicesPaye.setUsersLog(this.usersLog);
         this.formExercicesPaye.InstancesDaoUtilses();
         this.formExercicesPaye.chargerLesExo();
      } else {
         Session var8;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsPaye";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
            this.formOptionsPaye = new FormOptionsPaye();
            this.formOptionsPaye.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsPaye.setBaseLog(this.baseLog);
            this.formOptionsPaye.setStructureLog(this.structureLog);
            this.formOptionsPaye.setUsersLog(this.usersLog);
            this.formOptionsPaye.setOptionPaye(this.optionPaye);
            this.formOptionsPaye.chargerRubriques(var8);
            boolean var9 = false;
            Object var11 = var8.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var10 = Integer.parseInt(var11.toString());
            if (var10 > 0) {
               this.formOptionsPaye.setGriseAnalytique(true);
               this.formOptionsPaye.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsPaye.setGriseAnalytique(false);
               this.formOptionsPaye.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            Object var6 = var8.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
            var10 = Integer.parseInt(var6.toString());
            if (var10 > 0) {
               this.formOptionsPaye.setGriseProduit(true);
               this.formOptionsPaye.setObsProduit("Les zones produits sont verrouillées car elles sont pilotées par les achats...");
            } else {
               this.formOptionsPaye.setGriseProduit(false);
               this.formOptionsPaye.setObsProduit("Les zones produits sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosPaye";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoPaye = new FormChronoPaye();
            this.formChronoPaye.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoPaye.setBaseLog(this.baseLog);
            this.formChronoPaye.setStructureLog(this.structureLog);
            this.formChronoPaye.setUsersLog(this.usersLog);
            this.formChronoPaye.InstancesDaoUtilses();
            this.formChronoPaye.setExercicesPaye(this.exercicesPayeDao.recupererLastExo(var8));
            this.formChronoPaye.calculeMesModes();
            this.formChronoPaye.lesChronos(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "naturesSalarie";
            this.formNaturesSalarie = new FormNaturesSalarie();
            this.formNaturesSalarie.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesSalarie.setBaseLog(this.baseLog);
            this.formNaturesSalarie.setStructureLog(this.structureLog);
            this.formNaturesSalarie.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "centresimpots";
            this.formCentresImpots = new FormCentresImpots();
            this.formCentresImpots.setutilInitHibernate(this.utilInitHibernate);
            this.formCentresImpots.setBaseLog(this.baseLog);
            this.formCentresImpots.setStructureLog(this.structureLog);
            this.formCentresImpots.setUsersLog(this.usersLog);
            this.formCentresImpots.InstancesDaoUtilses();
            this.formCentresImpots.chargerLesCentresImpots();
         } else if (var1.getIndice() == 5L) {
            this.choixLigne = "centressecuritesociale";
            this.formCentresSecuriteSociale = new FormCentresSecuriteSociale();
            this.formCentresSecuriteSociale.setutilInitHibernate(this.utilInitHibernate);
            this.formCentresSecuriteSociale.setBaseLog(this.baseLog);
            this.formCentresSecuriteSociale.setStructureLog(this.structureLog);
            this.formCentresSecuriteSociale.setUsersLog(this.usersLog);
            this.formCentresSecuriteSociale.InstancesDaoUtilses();
            this.formCentresSecuriteSociale.chargerLesCentresImpots();
         } else if (var1.getIndice() == 6L) {
            this.choixLigne = "classementagents";
            this.formClassementsAgents = new FormClassementsAgents();
            this.formClassementsAgents.setutilInitHibernate(this.utilInitHibernate);
            this.formClassementsAgents.setBaseLog(this.baseLog);
            this.formClassementsAgents.setStructureLog(this.structureLog);
            this.formClassementsAgents.setUsersLog(this.usersLog);
            this.formClassementsAgents.chargerLesClassements();
         } else if (var1.getIndice() == 7L) {
            this.choixLigne = "niveauxemplois";
            this.formNiveauxEmplois = new FormNiveauxEmplois();
            this.formNiveauxEmplois.setutilInitHibernate(this.utilInitHibernate);
            this.formNiveauxEmplois.setBaseLog(this.baseLog);
            this.formNiveauxEmplois.setStructureLog(this.structureLog);
            this.formNiveauxEmplois.setUsersLog(this.usersLog);
            this.formNiveauxEmplois.chargerLesNiveaux();
         } else if (var1.getIndice() == 8L) {
            this.choixLigne = "codesemplois";
            this.formCodesEmplois = new FormCodesEmplois();
            this.formCodesEmplois.setutilInitHibernate(this.utilInitHibernate);
            this.formCodesEmplois.setBaseLog(this.baseLog);
            this.formCodesEmplois.setStructureLog(this.structureLog);
            this.formCodesEmplois.setUsersLog(this.usersLog);
            this.formCodesEmplois.chargerLesCodes();
         } else if (var1.getIndice() == 9L) {
            if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
               var3 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "paye" + File.separator;
               String var12 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator;
               var5 = new File(var3);
               File var13 = new File(var12);
               if (var5.exists()) {
                  FileRep.copy(var5, var13);
               }
            }

            this.choixLigne = "conventionscollectives";
            this.formConventionsCollectives = new FormConventionsCollectives();
            this.formConventionsCollectives.setutilInitHibernate(this.utilInitHibernate);
            this.formConventionsCollectives.setBaseLog(this.baseLog);
            this.formConventionsCollectives.setStructureLog(this.structureLog);
            this.formConventionsCollectives.setUsersLog(this.usersLog);
            this.formConventionsCollectives.chargerConventions();
         } else if (var1.getIndice() == 10L) {
            this.choixLigne = "planPaye";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
            this.formPlanPaye = new FormPlanPaye();
            this.formPlanPaye.setUtilInitHibernate(this.utilInitHibernate);
            this.formPlanPaye.setBaseLog(this.baseLog);
            this.formPlanPaye.setStructureLog(this.structureLog);
            this.formPlanPaye.setUsersLog(this.usersLog);
            this.formPlanPaye.InstancesDaoUtilses();
            this.formPlanPaye.setSelectedExo(this.exercicesPayeDao.recupererLastExo(var8));
            this.formPlanPaye.setOptionPaye(this.optionPaye);
            this.formPlanPaye.initPlanPaye(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "feuilleCalcul";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
            this.formFeuilleCalcul = new FormFeuilleCalcul();
            this.formFeuilleCalcul.setUtilInitHibernate(this.utilInitHibernate);
            this.formFeuilleCalcul.setBaseLog(this.baseLog);
            this.formFeuilleCalcul.setStructureLog(this.structureLog);
            this.formFeuilleCalcul.setUsersLog(this.usersLog);
            this.formFeuilleCalcul.InstancesDaoUtilses();
            this.formFeuilleCalcul.setExercicesPaye(this.exercicesPayeDao.recupererLastExo(var8));
            this.formFeuilleCalcul.setExercicesComptable(this.exercicesComptableDao.recupererLastExo(var8));
            this.formFeuilleCalcul.setOptionPaye(this.optionPaye);
            this.formFeuilleCalcul.initFeuilleCalcul(var8);
            this.formFeuilleCalcul.chargerFeuilleCalcul(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 12L) {
            this.choixLigne = "natureRH";
            this.formNaturesRH = new FormNaturesRH();
            this.formNaturesRH.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesRH.setBaseLog(this.baseLog);
            this.formNaturesRH.setStructureLog(this.structureLog);
            this.formNaturesRH.setUsersLog(this.usersLog);
            this.formNaturesRH.chargerNatureRH();
         } else if (var1.getIndice() == 13L) {
            this.choixLigne = "modelePaye";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersPaye = new FormModelesCourriersPaye();
            this.formModelesCourriersPaye.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersPaye.setBaseLog(this.baseLog);
            this.formModelesCourriersPaye.setStructureLog(this.structureLog);
            this.formModelesCourriersPaye.setUsersLog(this.usersLog);
            this.formModelesCourriersPaye.InstancesDaoUtilses();
            this.formModelesCourriersPaye.lesModeles(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 14L) {
            this.choixLigne = "localisationSalarie";
            this.formLocalisationSalarie = new FormLocalisationSalarie();
            this.formLocalisationSalarie.setutilInitHibernate(this.utilInitHibernate);
            this.formLocalisationSalarie.setBaseLog(this.baseLog);
            this.formLocalisationSalarie.setStructureLog(this.structureLog);
            this.formLocalisationSalarie.setUsersLog(this.usersLog);
            this.formLocalisationSalarie.InstancesDaoUtilses();
            this.formLocalisationSalarie.chargeLocalisationSalarie((Session)null);
         } else if (var1.getIndice() == 15L) {
            this.choixLigne = "naturePrets";
            this.formNaturesPrets = new FormNaturesPrets();
            this.formNaturesPrets.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesPrets.setBaseLog(this.baseLog);
            this.formNaturesPrets.setStructureLog(this.structureLog);
            this.formNaturesPrets.setUsersLog(this.usersLog);
            this.formNaturesPrets.listeNaturePrets();
         } else if (var1.getIndice() == 16L) {
            this.choixLigne = "etatBilanSocial";
            this.formBilanSocialConfigClient = new FormBilanSocialConfigClient();
            this.formBilanSocialConfigClient.setutilInitHibernate(this.utilInitHibernate);
            this.formBilanSocialConfigClient.setBaseLog(this.baseLog);
            this.formBilanSocialConfigClient.setStructureLog(this.structureLog);
            this.formBilanSocialConfigClient.setUsersLog(this.usersLog);
            this.formBilanSocialConfigClient.InstancesDaoUtilses();
            this.formBilanSocialConfigClient.setNature(10);
            this.formBilanSocialConfigClient.setTabliszone(this.structureLog.getStrbilansocial());
            this.formBilanSocialConfigClient.chargerMesTabNom((Session)null);
         } else if (var1.getIndice() == 17L) {
            this.choixLigne = "impPaye";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS DES AGENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("paye" + File.separator + "document");
         } else if (var1.getIndice() == 18L) {
            this.choixLigne = "impPaye";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES DOCUMENTS DES AGENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("paye" + File.separator + "liste");
         } else if (var1.getIndice() == 19L) {
            this.choixLigne = "habilitationsPaye";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
            this.formHabilitation = new FormHabilitation();
            this.formHabilitation.setutilInitHibernate(this.utilInitHibernate);
            this.formHabilitation.setBaseLog(this.baseLog);
            this.formHabilitation.setStructureLog(this.structureLog);
            this.formHabilitation.setUsersLog(this.usersLog);
            this.formHabilitation.InstancesDaoUtilses();
            this.formHabilitation.lesHabilitationsPaye(var8);
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void aiguillageTemps(Module var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "paye" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator;
         File var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsPaye var6 = new LireLesoptionsPaye();
      var6.setStrId(this.structureLog.getStrid());
      this.optionPaye = new OptionPaye();
      this.optionPaye = var6.lancer();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "taches";
         this.formTache = new FormTache();
         this.formTache.setutilInitHibernate(this.utilInitHibernate);
         this.formTache.setBaseLog(this.baseLog);
         this.formTache.setStructureLog(this.structureLog);
         this.formTache.setUsersLog(this.usersLog);
         this.formTache.InstancesDaoUtilses();
         this.formTache.chargerlesTaches();
      }

   }

   public void creationExerciceImmobilier() throws IOException, JDOMException, ParseException {
      this.choixModule = "moduleLigne";
      this.choixLigne = "exercicesImmobilier";
      this.formExercicesImmobilier = new FormExercicesImmobilier();
      this.formExercicesImmobilier.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesImmobilier.setBaseLog(this.baseLog);
      this.formExercicesImmobilier.setStructureLog(this.structureLog);
      this.formExercicesImmobilier.setUsersLog(this.usersLog);
      this.formExercicesImmobilier.InstancesDaoUtilses();
      this.formExercicesImmobilier.chargerDate();
   }

   public void miseAJourCreationImmobilier() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      this.taille = 0;
      this.formExercicesImmobilier.enregistrerExercicesVentes();
      this.selectedExo = this.formExercicesImmobilier.recupererLastExo((Session)null).getExevteId();
   }

   public void aiguillageImmobilier(Module var1) throws IOException, JDOMException, SAXException, NamingException, ParseException {
      String var3;
      File var5;
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "immobilier" + File.separator;
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "immobilier" + File.separator;
         File var4 = new File(var2);
         var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsVentes var7 = new LireLesoptionsVentes();
      var7.setStrId(this.structureLog.getStrid());
      this.optionsVentes = new OptionVentes();
      this.optionsVentes = var7.lancer();
      this.journauxComptables();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesImmobilier";
         this.formExercicesImmobilier = new FormExercicesImmobilier();
         this.formExercicesImmobilier.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesImmobilier.setBaseLog(this.baseLog);
         this.formExercicesImmobilier.setStructureLog(this.structureLog);
         this.formExercicesImmobilier.setUsersLog(this.usersLog);
         this.formExercicesImmobilier.InstancesDaoUtilses();
         this.formExercicesImmobilier.chargerLesExo();
      } else {
         Session var8;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsImmobilier";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            this.formOptionsVentes = new FormOptionsVentes(this.structureLog);
            this.formOptionsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsVentes.setBaseLog(this.baseLog);
            this.formOptionsVentes.setStructureLog(this.structureLog);
            this.formOptionsVentes.setUsersLog(this.usersLog);
            this.formOptionsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var8));
            this.formOptionsVentes.setOptionVentes(this.optionsVentes);
            this.formOptionsVentes.chargerFamilleVente(var8);
            this.formOptionsVentes.calculeDepotItems(var8);
            this.formOptionsVentes.calculeTvaItems(var8);
            this.formOptionsVentes.calculeLibEntete();
            boolean var9 = false;
            Object var11 = var8.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var10 = Integer.parseInt(var11.toString());
            if (var10 > 0) {
               this.formOptionsVentes.setGriseAnalytique(true);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsVentes.setGriseAnalytique(false);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            Object var6 = var8.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
            var10 = Integer.parseInt(var6.toString());
            if (var10 > 0) {
               this.formOptionsVentes.setGriseProduit(true);
               this.formOptionsVentes.setObsProduit("Les zones produits sont verrouillées car elles sont pilotées par les achats...");
            } else {
               this.formOptionsVentes.setGriseProduit(false);
               this.formOptionsVentes.setObsProduit("Les zones produits sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosImmobilier";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoImm = new FormChronoImm();
            this.formChronoImm.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoImm.setBaseLog(this.baseLog);
            this.formChronoImm.setStructureLog(this.structureLog);
            this.formChronoImm.setUsersLog(this.usersLog);
            this.formChronoImm.InstancesDaoUtilses();
            this.formChronoImm.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var8));
            this.formChronoImm.calculeMesModes();
            this.formChronoImm.lesChronos(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
               var3 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "immobilier" + File.separator;
               String var12 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "immobilier" + File.separator;
               var5 = new File(var3);
               File var13 = new File(var12);
               if (var5.exists()) {
                  FileRep.copy(var5, var13);
               }
            }

            this.choixLigne = "naturesBiens";
            this.formNaturesBiens = new FormNaturesBiens(this.baseLog, this.structureLog);
            this.formNaturesBiens.setutilInitHibernate(this.utilInitHibernate);
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "taxesVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
            this.formTaxesVentes = new FormTaxesVentes();
            this.formTaxesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formTaxesVentes.setBaseLog(this.baseLog);
            this.formTaxesVentes.setStructureLog(this.structureLog);
            this.formTaxesVentes.setUsersLog(this.usersLog);
            this.formTaxesVentes.InstancesDaoUtilses();
            this.formTaxesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var8));
            this.formTaxesVentes.lesTaxesVentes(var8);
            this.formTaxesVentes.recupererComptesItem(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 5L) {
            this.choixLigne = "naturesVentes";
            this.formNaturesFamillesProduits = new FormNaturesFamillesProduitsVentes();
            this.formNaturesFamillesProduits.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesFamillesProduits.setBaseLog(this.baseLog);
            this.formNaturesFamillesProduits.setStructureLog(this.structureLog);
            this.formNaturesFamillesProduits.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 6L) {
            this.choixLigne = "famillesVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            this.formFamillesProduitsVentes = new FormFamilleProduitsVentes();
            this.formFamillesProduitsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formFamillesProduitsVentes.setBaseLog(this.baseLog);
            this.formFamillesProduitsVentes.setStructureLog(this.structureLog);
            this.formFamillesProduitsVentes.setUsersLog(this.usersLog);
            this.formFamillesProduitsVentes.InstancesDaoUtilses();
            this.formFamillesProduitsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var8));
            this.formFamillesProduitsVentes.elementsBase(86, var8);
            this.formFamillesProduitsVentes.lesFamillesProduitsVentes(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 7L) {
            this.choixLigne = "formulesVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesVentes");
            this.formFormulesVentes = new FormFormulesVentes();
            this.formFormulesVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formFormulesVentes.setBaseLog(this.baseLog);
            this.formFormulesVentes.setStructureLog(this.structureLog);
            this.formFormulesVentes.setUsersLog(this.usersLog);
            this.formFormulesVentes.InstancesDaoUtilses();
            this.formFormulesVentes.setExovteSelect(this.exercicesVentesDao.recupererLastExo(var8));
            this.formFormulesVentes.lesFormulesVentes(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 8L) {
            this.choixLigne = "modeleVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(0, var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 9L) {
            this.choixLigne = "modeleContrats";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
            this.formModelesCourriersVentes = new FormModelesCourriersVentes();
            this.formModelesCourriersVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formModelesCourriersVentes.setBaseLog(this.baseLog);
            this.formModelesCourriersVentes.setStructureLog(this.structureLog);
            this.formModelesCourriersVentes.setUsersLog(this.usersLog);
            this.formModelesCourriersVentes.InstancesDaoUtilses();
            this.formModelesCourriersVentes.lesModeles(1, var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 10L) {
            this.choixLigne = "impClientsImmobilier";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "client");
            this.formConfigImprDocument.setVar_acces_rapport_ligne(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "produits");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS RELATIVES AUX CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "client");
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "impClientsImmobilier";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "document");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "client");
         } else if (var1.getIndice() == 12L) {
            this.choixLigne = "impClientsImmobilier";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "liste");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
            this.formConfigImprDocument.setCodePays(this.structureLog.getStrcodepays());
            this.formConfigImprDocument.setCodeModule("ventes" + File.separator + "liste");
         } else if (var1.getIndice() == 13L) {
            this.choixLigne = "habilitationsVentes";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
            this.formHabilitation = new FormHabilitation();
            this.formHabilitation.setutilInitHibernate(this.utilInitHibernate);
            this.formHabilitation.setBaseLog(this.baseLog);
            this.formHabilitation.setStructureLog(this.structureLog);
            this.formHabilitation.setUsersLog(this.usersLog);
            this.formHabilitation.InstancesDaoUtilses();
            this.formHabilitation.lesHabilitationsImmobilier(var8);
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void creationExerciceEducation() throws IOException, JDOMException, ParseException {
      this.choixModule = "moduleLigne";
      this.choixLigne = "exercicesEducation";
      this.formExercicesEducation = new FormExercicesEducation();
      this.formExercicesEducation.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesEducation.setBaseLog(this.baseLog);
      this.formExercicesEducation.setStructureLog(this.structureLog);
      this.formExercicesEducation.setUsersLog(this.usersLog);
      this.formExercicesEducation.InstancesDaoUtilses();
      this.formExercicesEducation.chargerDate();
   }

   public void miseAJourCreationEducation() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      this.taille = 0;
      this.formExercicesEducation.enregistrerExercicesVentes();
      this.selectedExo = this.formExercicesEducation.recupererLastExo((Session)null).getExevteId();
   }

   public void aiguillageEducation(Module var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "education" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "education" + File.separator;
         File var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsVentes var7 = new LireLesoptionsVentes();
      var7.setStrId(this.structureLog.getStrid());
      this.optionsVentes = new OptionVentes();
      this.optionsVentes = var7.lancer();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesEducation";
         this.formExercicesEducation = new FormExercicesEducation();
         this.formExercicesEducation.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesEducation.setBaseLog(this.baseLog);
         this.formExercicesEducation.setStructureLog(this.structureLog);
         this.formExercicesEducation.setUsersLog(this.usersLog);
         this.formExercicesEducation.InstancesDaoUtilses();
         this.formExercicesEducation.chargerLesExo();
      } else {
         Session var8;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsEducation";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formOptionsVentes = new FormOptionsVentes(this.structureLog);
            this.formOptionsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsVentes.setBaseLog(this.baseLog);
            this.formOptionsVentes.setStructureLog(this.structureLog);
            this.formOptionsVentes.setUsersLog(this.usersLog);
            this.formOptionsVentes.setOptionVentes(this.optionsVentes);
            boolean var9 = false;
            Object var11 = var8.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var10 = Integer.parseInt(var11.toString());
            if (var10 > 0) {
               this.formOptionsVentes.setGriseAnalytique(true);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsVentes.setGriseAnalytique(false);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            Object var6 = var8.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
            var10 = Integer.parseInt(var6.toString());
            if (var10 > 0) {
               this.formOptionsVentes.setGriseProduit(true);
               this.formOptionsVentes.setObsProduit("Les zones produits sont verrouillées car elles sont pilotées par les achats...");
            } else {
               this.formOptionsVentes.setGriseProduit(false);
               this.formOptionsVentes.setObsProduit("Les zones produits sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosEducation";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoEdu = new FormChronoEdu();
            this.formChronoEdu.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoEdu.setBaseLog(this.baseLog);
            this.formChronoEdu.setStructureLog(this.structureLog);
            this.formChronoEdu.setUsersLog(this.usersLog);
            this.formChronoEdu.InstancesDaoUtilses();
            this.formChronoEdu.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var8));
            this.formChronoEdu.calculeMesModes();
            this.formChronoEdu.lesChronos(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "filieresEducation";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "FilieresEducation");
            this.formFilieres = new FormFilieres();
            this.formFilieres.setutilInitHibernate(this.utilInitHibernate);
            this.formFilieres.setBaseLog(this.baseLog);
            this.formFilieres.setStructureLog(this.structureLog);
            this.formFilieres.setUsersLog(this.usersLog);
            this.formFilieres.InstancesDaoUtilses();
            this.formFilieres.lesFilieres(var8);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "classementMediatheque";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "classementMediatheque");
            this.formClassementMediatheque = new FormClassementMediatheque();
            this.formClassementMediatheque.setutilInitHibernate(this.utilInitHibernate);
            this.formClassementMediatheque.setBaseLog(this.baseLog);
            this.formClassementMediatheque.setStructureLog(this.structureLog);
            this.formClassementMediatheque.setUsersLog(this.usersLog);
            this.formClassementMediatheque.InstancesDaoUtilses();
            this.formClassementMediatheque.lesClassementMediatheque(var8);
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void creationExerciceMicrofinance() throws IOException, JDOMException, ParseException {
      this.choixModule = "moduleLigne";
      this.choixLigne = "exercicesMicrofinance";
      this.formExercicesMicrofinance = new FormExercicesMicrofinance();
      this.formExercicesMicrofinance.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesMicrofinance.setBaseLog(this.baseLog);
      this.formExercicesMicrofinance.setStructureLog(this.structureLog);
      this.formExercicesMicrofinance.setUsersLog(this.usersLog);
      this.formExercicesMicrofinance.InstancesDaoUtilses();
      this.formExercicesMicrofinance.chargerDate();
   }

   public void miseAJourCreationMicrofinance() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      this.taille = 0;
      this.formExercicesMicrofinance.enregistrerExercicesVentes();
      this.selectedExo = this.formExercicesMicrofinance.recupererLastExo((Session)null).getExevteId();
   }

   public void aiguillageMicrofinance(Module var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException {
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "microfinance" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "microfinance" + File.separator;
         File var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsVentes var7 = new LireLesoptionsVentes();
      var7.setStrId(this.structureLog.getStrid());
      this.optionsVentes = new OptionVentes();
      this.optionsVentes = var7.lancer();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesMicrofinance";
         this.formExercicesMicrofinance = new FormExercicesMicrofinance();
         this.formExercicesMicrofinance.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesMicrofinance.setBaseLog(this.baseLog);
         this.formExercicesMicrofinance.setStructureLog(this.structureLog);
         this.formExercicesMicrofinance.setUsersLog(this.usersLog);
         this.formExercicesMicrofinance.InstancesDaoUtilses();
         this.formExercicesMicrofinance.chargerLesExo();
      } else {
         Session var8;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsMicrofinance";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formOptionsVentes = new FormOptionsVentes(this.structureLog);
            this.formOptionsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsVentes.setBaseLog(this.baseLog);
            this.formOptionsVentes.setStructureLog(this.structureLog);
            this.formOptionsVentes.setUsersLog(this.usersLog);
            this.formOptionsVentes.setOptionVentes(this.optionsVentes);
            boolean var9 = false;
            Object var11 = var8.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var10 = Integer.parseInt(var11.toString());
            if (var10 > 0) {
               this.formOptionsVentes.setGriseAnalytique(true);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsVentes.setGriseAnalytique(false);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            Object var6 = var8.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
            var10 = Integer.parseInt(var6.toString());
            if (var10 > 0) {
               this.formOptionsVentes.setGriseProduit(true);
               this.formOptionsVentes.setObsProduit("Les zones produits sont verrouillées car elles sont pilotées par les achats...");
            } else {
               this.formOptionsVentes.setGriseProduit(false);
               this.formOptionsVentes.setObsProduit("Les zones produits sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosMicrofinance";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoMef = new FormChronoMef();
            this.formChronoMef.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoMef.setBaseLog(this.baseLog);
            this.formChronoMef.setStructureLog(this.structureLog);
            this.formChronoMef.setUsersLog(this.usersLog);
            this.formChronoMef.InstancesDaoUtilses();
            this.formChronoMef.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var8));
            this.formChronoMef.calculeMesModes();
            this.formChronoMef.lesChronos(var8);
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void creationExerciceFondation() throws IOException, JDOMException, ParseException {
      this.choixModule = "moduleLigne";
      this.choixLigne = "exercicesFondation";
      this.formExercicesFondation = new FormExercicesFondation();
      this.formExercicesFondation.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesFondation.setBaseLog(this.baseLog);
      this.formExercicesFondation.setStructureLog(this.structureLog);
      this.formExercicesFondation.setUsersLog(this.usersLog);
      this.formExercicesFondation.InstancesDaoUtilses();
      this.formExercicesFondation.chargerDate();
   }

   public void miseAJourCreationFondation() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      this.taille = 0;
      this.formExercicesFondation.enregistrerExercicesVentes();
      this.selectedExo = this.formExercicesFondation.recupererLastExo((Session)null).getExevteId();
   }

   public void aiguillageFondation(Module var1) throws IOException, JDOMException, SAXException, NamingException, ParseException {
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "fondation" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "fondation" + File.separator;
         File var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsVentes var6 = new LireLesoptionsVentes();
      var6.setStrId(this.structureLog.getStrid());
      this.optionsVentes = new OptionVentes();
      this.optionsVentes = var6.lancer();
      this.journauxComptables();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesFondation";
         this.formExercicesFondation = new FormExercicesFondation();
         this.formExercicesFondation.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesFondation.setBaseLog(this.baseLog);
         this.formExercicesFondation.setStructureLog(this.structureLog);
         this.formExercicesFondation.setUsersLog(this.usersLog);
         this.formExercicesFondation.InstancesDaoUtilses();
         this.formExercicesFondation.chargerLesExo();
      } else {
         Session var7;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsFondation";
            var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            this.formOptionsVentes = new FormOptionsVentes(this.structureLog);
            this.formOptionsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsVentes.setBaseLog(this.baseLog);
            this.formOptionsVentes.setStructureLog(this.structureLog);
            this.formOptionsVentes.setUsersLog(this.usersLog);
            this.formOptionsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var7));
            this.formOptionsVentes.setOptionVentes(this.optionsVentes);
            this.formOptionsVentes.chargerFamilleVente(var7);
            this.formOptionsVentes.calculeTvaItems(var7);
            this.formOptionsVentes.calculeLibEntete();
            boolean var8 = false;
            Object var10 = var7.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var9 = Integer.parseInt(var10.toString());
            if (var9 > 0) {
               this.formOptionsVentes.setGriseAnalytique(true);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsVentes.setGriseAnalytique(false);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosFondation";
            var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoFdt = new FormChronoFdt();
            this.formChronoFdt.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoFdt.setBaseLog(this.baseLog);
            this.formChronoFdt.setStructureLog(this.structureLog);
            this.formChronoFdt.setUsersLog(this.usersLog);
            this.formChronoFdt.InstancesDaoUtilses();
            this.formChronoFdt.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var7));
            this.formChronoFdt.calculeMesModes();
            this.formChronoFdt.lesChronos(var7);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "natureDemande";
            this.formNaturesDemande = new FormNaturesDemande();
            this.formNaturesDemande.setutilInitHibernate(this.utilInitHibernate);
            this.formNaturesDemande.setBaseLog(this.baseLog);
            this.formNaturesDemande.setStructureLog(this.structureLog);
            this.formNaturesDemande.setUsersLog(this.usersLog);
         } else if (var1.getIndice() == 10L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "client");
            this.formConfigImprDocument.setVar_acces_rapport_ligne(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS RELATIVES AUX CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
         } else if (var1.getIndice() == 12L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
         } else if (var1.getIndice() == 13L) {
            this.choixLigne = "habilitationsVentes";
            var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
            this.formHabilitation = new FormHabilitation();
            this.formHabilitation.setutilInitHibernate(this.utilInitHibernate);
            this.formHabilitation.setBaseLog(this.baseLog);
            this.formHabilitation.setStructureLog(this.structureLog);
            this.formHabilitation.setUsersLog(this.usersLog);
            this.formHabilitation.InstancesDaoUtilses();
            this.formHabilitation.lesHabilitationsVentes(var7);
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void creationExerciceForet() throws IOException, JDOMException, ParseException {
      this.choixModule = "moduleLigne";
      this.choixLigne = "exercicesForet";
      this.formExercicesForet = new FormExercicesForet();
      this.formExercicesForet.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesForet.setBaseLog(this.baseLog);
      this.formExercicesForet.setStructureLog(this.structureLog);
      this.formExercicesForet.setUsersLog(this.usersLog);
      this.formExercicesForet.InstancesDaoUtilses();
      this.formExercicesForet.chargerDate();
   }

   public void miseAJourCreationForet() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      this.taille = 0;
      this.formExercicesForet.enregistrerExercicesVentes();
      this.selectedExo = this.formExercicesForet.recupererLastExo((Session)null).getExevteId();
   }

   public void aiguillageForet(Module var1) throws IOException, JDOMException, SAXException, NamingException, ParseException {
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var2 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "foret" + File.separator;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator;
         File var4 = new File(var2);
         File var5 = new File(var3);
         if (var4.exists()) {
            FileRep.copy(var4, var5);
         }
      }

      LireLesoptionsVentes var6 = new LireLesoptionsVentes();
      var6.setStrId(this.structureLog.getStrid());
      this.optionsVentes = new OptionVentes();
      this.optionsVentes = var6.lancer();
      this.journauxComptables();
      if (var1.getIndice() == 0L) {
         this.choixLigne = "exercicesForet";
         this.formExercicesForet = new FormExercicesForet();
         this.formExercicesForet.setutilInitHibernate(this.utilInitHibernate);
         this.formExercicesForet.setBaseLog(this.baseLog);
         this.formExercicesForet.setStructureLog(this.structureLog);
         this.formExercicesForet.setUsersLog(this.usersLog);
         this.formExercicesForet.InstancesDaoUtilses();
         this.formExercicesForet.chargerLesExo();
      } else {
         Session var7;
         if (var1.getIndice() == 1L) {
            this.choixLigne = "optionsForet";
            var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
            this.formOptionsVentes = new FormOptionsVentes(this.structureLog);
            this.formOptionsVentes.setutilInitHibernate(this.utilInitHibernate);
            this.formOptionsVentes.setBaseLog(this.baseLog);
            this.formOptionsVentes.setStructureLog(this.structureLog);
            this.formOptionsVentes.setUsersLog(this.usersLog);
            this.formOptionsVentes.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var7));
            this.formOptionsVentes.setOptionVentes(this.optionsVentes);
            this.formOptionsVentes.chargerFamilleVente(var7);
            this.formOptionsVentes.calculeTvaItems(var7);
            this.formOptionsVentes.calculeLibEntete();
            boolean var8 = false;
            Object var10 = var7.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
            int var9 = Integer.parseInt(var10.toString());
            if (var9 > 0) {
               this.formOptionsVentes.setGriseAnalytique(true);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont verrouillées car elles sont pilotées par la comptabilité...");
            } else {
               this.formOptionsVentes.setGriseAnalytique(false);
               this.formOptionsVentes.setObsAnalytique("Les zones analytiques sont autonomes...");
            }

            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 2L) {
            this.choixLigne = "chronosForet";
            var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.formChronoForet = new FormChronoForet();
            this.formChronoForet.setutilInitHibernate(this.utilInitHibernate);
            this.formChronoForet.setBaseLog(this.baseLog);
            this.formChronoForet.setStructureLog(this.structureLog);
            this.formChronoForet.setUsersLog(this.usersLog);
            this.formChronoForet.InstancesDaoUtilses();
            this.formChronoForet.setExercicesVentes(this.exercicesVentesDao.recupererLastExo(var7));
            this.formChronoForet.calculeMesModes();
            this.formChronoForet.lesChronos(var7);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 3L) {
            this.choixLigne = "essencesForet";
            this.formEssenceForet = new FormEssenceForet();
            this.formEssenceForet.setutilInitHibernate(this.utilInitHibernate);
            this.formEssenceForet.setBaseLog(this.baseLog);
            this.formEssenceForet.setStructureLog(this.structureLog);
            this.formEssenceForet.setUsersLog(this.usersLog);
            this.formEssenceForet.listeEssence();
         } else if (var1.getIndice() == 4L) {
            this.choixLigne = "classementsForet";
            this.formClassementForet = new FormClassementForet();
            this.formClassementForet.setutilInitHibernate(this.utilInitHibernate);
            this.formClassementForet.setBaseLog(this.baseLog);
            this.formClassementForet.setStructureLog(this.structureLog);
            this.formClassementForet.setUsersLog(this.usersLog);
            this.formClassementForet.listeClassement();
         } else if (var1.getIndice() == 5L) {
            this.choixLigne = "chantiersForet";
            var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
            this.formChantiersForet = new FormChantiersForet();
            this.formChantiersForet.setUtilInitHibernate(this.utilInitHibernate);
            this.formChantiersForet.setBaseLog(this.baseLog);
            this.formChantiersForet.setStructureLog(this.structureLog);
            this.formChantiersForet.setUsersLog(this.usersLog);
            this.formChantiersForet.InstancesDaoUtilses();
            this.formChantiersForet.lesChantiers(var7);
            this.utilInitHibernate.closeSession();
         } else if (var1.getIndice() == 11L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
         } else if (var1.getIndice() == 12L) {
            this.choixLigne = "impClientsVentes";
            this.formConfigImprDocument = new FormConfigImprDocument();
            this.formConfigImprDocument.setutilInitHibernate(this.utilInitHibernate);
            this.formConfigImprDocument.setBaseLog(this.baseLog);
            this.formConfigImprDocument.setStructureLog(this.structureLog);
            this.formConfigImprDocument.setUsersLog(this.usersLog);
            this.formConfigImprDocument.setVar_acces_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste");
            this.formConfigImprDocument.setVar_acces_rapport_ligne("");
            this.formConfigImprDocument.setVar_acces_sous_rapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport");
            this.formConfigImprDocument.setVar_nom_ecran("CONFIGURATION AVANCEE DES IMPRESSIONS DES LISTES DES DOCUMENTS CLIENTS");
            this.formConfigImprDocument.chargerLesRepertoires();
            this.formConfigImprDocument.chargerSousRapport();
         } else if (var1.getIndice() == 13L) {
            this.choixLigne = "habilitationsVentes";
            var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
            this.formHabilitation = new FormHabilitation();
            this.formHabilitation.setutilInitHibernate(this.utilInitHibernate);
            this.formHabilitation.setBaseLog(this.baseLog);
            this.formHabilitation.setStructureLog(this.structureLog);
            this.formHabilitation.setUsersLog(this.usersLog);
            this.formHabilitation.InstancesDaoUtilses();
            this.formHabilitation.lesHabilitationsVentes(var7);
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void retourAiguillage() {
      this.choixModule = "";
      this.selectedExo = 0L;
      this.taille = 0;
   }

   public void retourLigne() {
      if (this.usersLog.getUsrSysteme() == 1) {
         this.choixModule = "coadmin";
         this.choixLigne = "";
         this.taille = 0;
         this.affichePage = "/administration/Vide.jsp";
      } else {
         this.choixModule = "module";
         this.choixLigne = "";
         this.taille = 0;
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

   public void imprimer() throws JRException, IOException, SQLException, ClassNotFoundException, Exception {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilPrint.setBaseLog(this.baseLog);
      this.utilPrint.setStructureLog(this.structureLog);
      this.utilPrint.setUsersLog(this.usersLog);
      this.utilPrint.setFormat(this.format);
      this.utilPrint.setTiersSelectionne((Tiers)null);
      ArrayList var1 = new ArrayList();
      JRBeanCollectionDataSource var2 = null;
      if (this.choixLigne.equals("activitesCommerciales")) {
         this.utilPrint.setRapport("PanActivites");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Liste des Activités");
         var2 = new JRBeanCollectionDataSource(this.formActivitesCommerciales.getActivitesList());
      } else if (this.choixLigne.equals("equipes")) {
         this.utilPrint.setRapport("PanEquipes");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Liste des Equipes");
         var2 = new JRBeanCollectionDataSource(this.formEquipes.getEquipesList());
      } else if (this.choixLigne.equals("activitestiers")) {
         this.utilPrint.setRapport("ListeMetiers");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete(this.formActivitesSocietes.getEntete());
         var2 = new JRBeanCollectionDataSource(this.formActivitesSocietes.getMetiersList());
      } else if (this.choixLigne.equals("antecedentMedical")) {
         this.utilPrint.setRapport("AntecedentCDA");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
         this.utilPrint.setEntete("Antécédents médicaux");
         var2 = new JRBeanCollectionDataSource(this.formAntecedentCDA.getListeAntecedentCDA());
      } else if (this.choixLigne.equals("appreciations")) {
         this.utilPrint.setRapport("Appreciations");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
         this.utilPrint.setEntete("Liste des appréciations");
         var2 = new JRBeanCollectionDataSource(this.formAppreciations.getListeAppreciations());
      } else if (this.choixLigne.equals("cabinet")) {
         var2 = new JRBeanCollectionDataSource((Collection)null);
      } else if (this.choixLigne.equals("listeCaisse")) {
         this.utilPrint.setRapport("CaissesCommerciales");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Liste des caisses");
         var2 = new JRBeanCollectionDataSource(this.formCaissesCommerciales.getCaisseList());
      } else if (this.choixLigne.equals("listeOperations")) {
         this.utilPrint.setRapport("CaissesOperations");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Liste des opérations de caisses");
         var2 = new JRBeanCollectionDataSource(this.formCaissesOperations.getOperationsList());
      } else if (this.choixLigne.equals("ccamMedical")) {
         this.utilPrint.setRapport("CcamMedical");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Codification Commune des actes médicaux (CCAM)");
         this.utilPrint.setRequete("requete");
         var2 = new JRBeanCollectionDataSource(var1);
      } else if (this.choixLigne.equals("centresimpots")) {
         if (this.structureLog.getStrNumRetraiteMultiple() == 1) {
            this.utilPrint.setRapport("CentresImpotsMultiple");
            this.utilPrint.setJournal(this.formCentresImpots.getObjetImmatriculation().getImpm03());
         } else {
            this.utilPrint.setRapport("CentresImpots");
         }

         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
         this.utilPrint.setEntete("Liste des centres d'impôts");
         var2 = new JRBeanCollectionDataSource(this.formCentresSecuriteSociale.getListeCentresImpots());
      } else if (this.choixLigne.equals("centressecuritesociale")) {
         if (this.structureLog.getStrNumSecuMultiple() == 1) {
            this.utilPrint.setRapport("CentresSecuriteSocialeMultiple");
            this.utilPrint.setJournal(this.formCentresSecuriteSociale.getObjetImmatriculation().getImpm05());
         } else {
            this.utilPrint.setRapport("CentresSecuriteSociale");
         }

         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
         this.utilPrint.setEntete("Liste des centres de Sécurités Sociales");
         var2 = new JRBeanCollectionDataSource(this.formCentresSecuriteSociale.getListeCentresImpots());
      } else if (this.choixLigne.equals("chronosAchats")) {
         this.utilPrint.setRapport("ChronoAchats");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Liste des chronos des achats");
         var2 = new JRBeanCollectionDataSource(this.formChronoAch.getChronoList());
      } else if (this.choixLigne.equals("chronosCaisse")) {
         this.utilPrint.setRapport("ChronoCaisses");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Liste des chronos des caisse");
         var2 = new JRBeanCollectionDataSource(this.formChronoCaisses.getChronoList());
      } else if (this.choixLigne.equals("chronosCompta")) {
         this.utilPrint.setRapport("ChronoComptabilite");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Liste des chronos de la comptabilité");
         var2 = new JRBeanCollectionDataSource(this.formChronoCpta.getChronoList());
      } else if (this.choixLigne.equals("chronosMedical")) {
         this.utilPrint.setRapport("ChronoMedical");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Liste des chronos du Medical");
         var2 = new JRBeanCollectionDataSource(this.formChronoMed.getChronoList());
      } else if (this.choixLigne.equals("chronosTiers")) {
         this.utilPrint.setRapport("ChronoTiers");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Liste des chronos des Tiers");
         var2 = new JRBeanCollectionDataSource(this.formChronoOffice.getChronoList());
      } else if (this.choixLigne.equals("chronosOffice")) {
         this.utilPrint.setRapport("ChronoOffice");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Liste des chronos de l'office");
         var2 = new JRBeanCollectionDataSource(this.formChronoOffice.getChronoList());
      } else if (this.choixLigne.equals("chronosParc")) {
         this.utilPrint.setRapport("ChronoParc");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Liste des chronos des Parcs");
         var2 = new JRBeanCollectionDataSource(this.formChronoParcs.getChronoList());
      } else if (this.choixLigne.equals("chronosPaye")) {
         this.utilPrint.setRapport("ChronoPaye");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Liste des chronos de la paye et R.H.");
         var2 = new JRBeanCollectionDataSource(this.formChronoPaye.getChronoList());
      } else if (!this.choixLigne.equals("chronosVentes") && !this.choixLigne.equals("chronosVentesTransit") && !this.choixLigne.equals("chronosVentesTicket") && !this.choixLigne.equals("chronosVentesCabinet")) {
         if (this.choixLigne.equals("cimMedical")) {
            this.utilPrint.setRapport("CimMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Classification internationnales des maladies (CIM)");
            this.utilPrint.setRequete("requete");
            var2 = new JRBeanCollectionDataSource(var1);
         } else if (this.choixLigne.equals("civilites")) {
            this.utilPrint.setRapport("ListeCivilite");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
            this.utilPrint.setEntete("Liste des civilités");
            var2 = new JRBeanCollectionDataSource(this.formCivilites.getListeCivilites());
         } else if (this.choixLigne.equals("classementagents")) {
            this.utilPrint.setRapport("ClassementsAgents");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
            this.utilPrint.setEntete("Liste des classements des agents");
            var2 = new JRBeanCollectionDataSource(this.formClassementsAgents.getListeClassements());
         } else if (this.choixLigne.equals("camMedical")) {
            this.utilPrint.setRapport("CmaMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Complication ou Morbidité Associée (CMA)");
            var2 = new JRBeanCollectionDataSource(this.formCmaMedical.getListCmaMedical());
         } else if (this.choixLigne.equals("cmdMedical")) {
            this.utilPrint.setRapport("CmdMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des Catégories majeures de diagnostiques");
            this.utilPrint.setRequete("requete");
            var2 = new JRBeanCollectionDataSource(var1);
         } else if (this.choixLigne.equals("commissionsMedical")) {
            this.utilPrint.setRapport("CommissionsMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Commissions des médecins");
            this.utilPrint.setFiltre(this.formCommissionsMedecins.getVar_medecin());
            var2 = new JRBeanCollectionDataSource(this.formCommissionsMedecins.getBaremesList());
         } else if (this.choixLigne.equals("conditionnements")) {
            this.utilPrint.setRapport("ProduitsCondition");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des conditionnements des produits");
            var2 = new JRBeanCollectionDataSource(this.formConditionnement.getLesConditionnement());
         } else if (this.choixLigne.equals("couleur")) {
            this.utilPrint.setRapport("Couleur");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des couleurs");
            var2 = new JRBeanCollectionDataSource(this.formCouleur.getCouleurList());
         } else if (this.choixLigne.equals("depotsAchats")) {
            this.utilPrint.setRapport("DepotAchats");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des depots");
            var2 = new JRBeanCollectionDataSource(this.formDepotAchats.getLesDepotAchats());
         } else if (this.choixLigne.equals("destinationsMedical")) {
            this.utilPrint.setRapport("DestinationsMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setEntete("Nature des destinations médicales");
            var2 = new JRBeanCollectionDataSource(this.formDestinationMedical.getListeDestination());
         } else if (this.choixLigne.equals("categorieExamens")) {
            this.utilPrint.setRapport("CategorieExamens");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setEntete("Catégories des examens de laboratoire");
            var2 = new JRBeanCollectionDataSource(this.formCategorieExamen.getListeCategorie());
         } else if (this.choixLigne.equals("devises")) {
            this.utilPrint.setRapport("ListeDevises");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
            this.utilPrint.setEntete("Liste des devises");
            var2 = new JRBeanCollectionDataSource(this.formDevises.getListeDevises());
         } else if (this.choixLigne.equals("positionTarifaire")) {
            this.utilPrint.setRapport("DouanesPosition");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des positions tarifaires");
            var2 = new JRBeanCollectionDataSource(this.formDouanes.getPositionList());
         } else if (this.choixLigne.equals("etatFianciersCompta")) {
            this.utilPrint.setRapport("Etat_Financier_str");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Structure des Etats financiers");
            this.utilPrint.setFiltre(this.formEtatFinancierConfigClient.getFiltre());
            this.utilPrint.setRequete(this.formEtatFinancierConfigClient.getRequete());
            var2 = new JRBeanCollectionDataSource(var1);
         } else if (this.choixLigne.equals("tableauBordCompta")) {
            this.utilPrint.setRapport("Tableau_Bord");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Tableau de bord et reporting");
            this.utilPrint.setFiltre(this.formEtatFinancierConfigClient.getFiltre());
            this.utilPrint.setRequete(this.formEtatFinancierConfigClient.getRequete());
            var2 = new JRBeanCollectionDataSource(var1);
         } else if (this.choixLigne.equals("familleClient")) {
            this.utilPrint.setRapport("FamilleClients");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
            this.utilPrint.setEntete("Liste des familles de clients");
            var2 = new JRBeanCollectionDataSource(this.formFamilleClient.getListeFamilleTiers());
         } else if (this.choixLigne.equals("natureMissions")) {
            this.utilPrint.setRapport("NatureMissions");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator);
            this.utilPrint.setEntete("Liste des natures de missions");
            var2 = new JRBeanCollectionDataSource(this.formNaturesMissions.getListeNAtureMissions());
         } else if (this.choixLigne.equals("familleFournisseur")) {
            this.utilPrint.setRapport("FamilleFournisseurs");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
            this.utilPrint.setEntete("Liste des familles de fournisseurs");
            var2 = new JRBeanCollectionDataSource(this.formFamilleFournisseur.getListeFamilleTiers());
         } else if (this.choixLigne.equals("famillesParc")) {
            this.utilPrint.setRapport("FamilleProduitParc");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des familles des produits des parcs");
            var2 = new JRBeanCollectionDataSource(var1);
            String var3 = "famprc2_id<>0";
            this.utilPrint.setRequete(var3);
         } else if (this.choixLigne.equals("famillesAchats")) {
            this.utilPrint.setRapport("FamilleProduitAchats");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des familles des produits de achats");
            var2 = new JRBeanCollectionDataSource(this.formFamilleProdAchats.getFamillesProduitsAchatsList());
         } else if (this.choixLigne.equals("famillesMedical")) {
            this.utilPrint.setRapport("FamilleProduitMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des familles des produits médicaux");
            var2 = new JRBeanCollectionDataSource(this.formFamillesProduitsVentes.getFamillesProduitsVentesList());
         } else if (this.choixLigne.equals("famillesVentes")) {
            this.utilPrint.setRapport("FamilleProduitVentes");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des familles des produits de ventes");
            var2 = new JRBeanCollectionDataSource(this.formFamillesProduitsVentes.getFamillesProduitsVentesList());
         } else if (this.choixLigne.equals("feuilleCalcul")) {
            this.utilPrint.setRapport("FeuilleCalcul");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
            this.utilPrint.setCheminSousrapport("");
            this.utilPrint.setEntete("Liste des feulles Calcul");
            var2 = new JRBeanCollectionDataSource(this.formFeuilleCalcul.getLesFeuillesCalcul());
         } else if (this.choixLigne.equals("fonctions")) {
            this.utilPrint.setRapport("ListeFonctions");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
            this.utilPrint.setEntete("Liste des fonctions des utilisateurs");
            var2 = new JRBeanCollectionDataSource(this.formFonctions.getListeFonctions());
         } else if (this.choixLigne.equals("formesjuridiques")) {
            this.utilPrint.setRapport("ListeFormeJuridique");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
            this.utilPrint.setEntete("Liste des formes juridiques");
            var2 = new JRBeanCollectionDataSource(this.formFormesJuridiques.getListeFormesJuridiques());
         } else if (this.choixLigne.equals("formulesAchats")) {
            this.utilPrint.setRapport("FormuleAchats");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des formules de achats");
            var2 = new JRBeanCollectionDataSource(this.formFormulesAchats.getFormulesAchatsList());
         } else if (this.choixLigne.equals("fraisTheoAchats")) {
            this.utilPrint.setRapport("FraisTheoAchats");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des calculs des frais sur achat");
            var2 = new JRBeanCollectionDataSource(this.formFraisTheoAchats.getFraisEnteteList());
         } else if (this.choixLigne.equals("formulesVentes")) {
            this.utilPrint.setRapport("FormuleVentes");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des formules de ventes");
            var2 = new JRBeanCollectionDataSource(this.formFormulesVentes.getFormulesVentesList());
         } else if (this.choixLigne.equals("transitPortVentes")) {
            this.utilPrint.setRapport("TransitPortVentes");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des ports");
            var2 = new JRBeanCollectionDataSource(this.formTransitPortVentes.getTransitPortVentesList());
         } else if (this.choixLigne.equals("transitLieuVentes")) {
            this.utilPrint.setRapport("TransitLieuVentes");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des lieux");
            var2 = new JRBeanCollectionDataSource(this.formTransitLieuVentes.getTransitLieuVentesList());
         } else if (this.choixLigne.equals("fraisTheoAchats")) {
            this.utilPrint.setRapport("FormuleVentes");
            this.utilPrint.setRapport("FeuilleFrais");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des feuilles de frais");
            var2 = new JRBeanCollectionDataSource(this.formFraisTheoAchats.getFraisLigneList());
         } else if (this.choixLigne.equals("habilitationsAchats")) {
            this.utilPrint.setRapport("Habilitations");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des habilitations des achats");
            var2 = new JRBeanCollectionDataSource(this.formHabilitation.getHabilitationList());
         } else if (this.choixLigne.equals("habilitationsCaisse")) {
            this.utilPrint.setRapport("Habilitations");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des habilitations des ventes");
            var2 = new JRBeanCollectionDataSource(this.formHabilitation.getHabilitationList());
         } else if (this.choixLigne.equals("habilitationsMedical")) {
            this.utilPrint.setRapport("Habilitations");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des habilitations du médical");
            var2 = new JRBeanCollectionDataSource(this.formHabilitation.getHabilitationList());
         } else if (this.choixLigne.equals("habilitationsPaye")) {
            this.utilPrint.setRapport("Habilitations");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des habilitations des payes");
            var2 = new JRBeanCollectionDataSource(this.formHabilitation.getHabilitationList());
         } else if (this.choixLigne.equals("habilitationsVentes")) {
            this.utilPrint.setRapport("Habilitations");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des habilitations des ventes");
            var2 = new JRBeanCollectionDataSource(this.formHabilitation.getHabilitationList());
         } else if (this.choixLigne.equals("incoterm")) {
            this.utilPrint.setRapport("Incoterms");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setCheminSousrapport("");
            this.utilPrint.setEntete("Liste des incoterms");
            var2 = new JRBeanCollectionDataSource(this.formIncoterm.getLesIncoterm());
         } else if (this.choixLigne.equals("journauxComptablesCompta")) {
            this.utilPrint.setRapport("JournauxComptables");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Journaux comptables");
            var2 = new JRBeanCollectionDataSource(this.formJournauxComptables.getLesjournauxComptables());
         } else if (this.choixLigne.equals("localisationImmobilisation")) {
            this.utilPrint.setRapport("LocalisationImmobilisation");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Localisation immobilisation");
            var2 = new JRBeanCollectionDataSource(this.formLocalisationImmobilisation.getLocalisationImmobilisationList());
         } else if (this.choixLigne.equals("lettresMedical")) {
            this.utilPrint.setRapport("LettreMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des lettres médicales");
            var2 = new JRBeanCollectionDataSource(this.formLettreMedical.getLesLettreMedical());
         } else if (this.choixLigne.equals("marques")) {
            this.utilPrint.setRapport("Marques");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des marques");
            var2 = new JRBeanCollectionDataSource(this.formMarques.getMarquesList());
         } else if (this.choixLigne.equals("modelePaye")) {
            this.utilPrint.setRapport("ModelesCourriers");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des modèles de courriers R.H.");
            var2 = new JRBeanCollectionDataSource(this.formModelesCourriersPaye.getLesModelesCourriers());
         } else if (this.choixLigne.equals("localisationSalarie")) {
            this.utilPrint.setRapport("LocalisationSalarie");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des localisations des salariés");
            var2 = new JRBeanCollectionDataSource(this.formLocalisationSalarie.getLocalisationSalarieList());
         } else if (this.choixLigne.equals("etatBilanSocial")) {
            this.utilPrint.setRapport("Bilan_social_str");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Structure du bilan social");
            this.utilPrint.setFiltre(this.formBilanSocialConfigClient.getFiltre());
            this.utilPrint.setRequete(this.formBilanSocialConfigClient.getRequete());
            var2 = new JRBeanCollectionDataSource(var1);
         } else if (this.choixLigne.equals("modeleVentes")) {
            this.utilPrint.setRapport("ModelesVentes");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des modèles des documents commerciaux");
            var2 = new JRBeanCollectionDataSource(this.formModelesCourriersVentes.getLesModelesCourriers());
         } else if (this.choixLigne.equals("modeleContrats")) {
            this.utilPrint.setRapport("ModelesContrats");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des modèles de contrats commerciaux");
            var2 = new JRBeanCollectionDataSource(this.formModelesCourriersVentes.getLesModelesCourriers());
         } else if (this.choixLigne.equals("motifEntreeMedical")) {
            this.utilPrint.setRapport("MotifEntreeMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setEntete("Nature des motifs d'entrée médicaux");
            var2 = new JRBeanCollectionDataSource(this.formMotifEntreeMedical.getListeMotif());
         } else if (this.choixLigne.equals("motifEntreeParc")) {
            this.utilPrint.setRapport("MotifsEntreeParc");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des motifs d'entrée des parcs");
            var2 = new JRBeanCollectionDataSource(this.formMotifEntreeParc.getLesMotifEntree());
         } else if (this.choixLigne.equals("motifSortieMedical")) {
            this.utilPrint.setRapport("MotifSortieMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setEntete("Nature des motifs de sortie médicaux");
            var2 = new JRBeanCollectionDataSource(this.formMotifSortieMedical.getListMotif());
         } else if (this.choixLigne.equals("motifEntreeConsultMedical")) {
            this.utilPrint.setRapport("MotifEntreeConsultMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des motis d'entrée médicales");
            var2 = new JRBeanCollectionDataSource(this.formMotifentreeConsultMedical.getLesMotifEntreeMedical());
         } else if (this.choixLigne.equals("natureComptesCompta")) {
            this.utilPrint.setRapport("NaturesComptables");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
            this.utilPrint.setEntete("Nature des comptes");
            var2 = new JRBeanCollectionDataSource(this.formNaturesCompte.getListeNatureCompte());
         } else if (this.choixLigne.equals("naturesAchats")) {
            this.utilPrint.setRapport("NatureFamilleProduitAchats");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setEntete("Nature des familles de produits achats");
            var2 = new JRBeanCollectionDataSource(this.formNatProdAchats.getListeNatureAchats());
         } else if (this.choixLigne.equals("naturesMedical")) {
            this.utilPrint.setRapport("NatureFamilleProduitMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setEntete("Nature des familles de produits médicaux");
            var2 = new JRBeanCollectionDataSource(this.formNaturesFamillesProduitsMedical.getListeNatureMedical());
         } else if (this.choixLigne.equals("naturesParc")) {
            this.utilPrint.setRapport("NatureFamilleProduitParc");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator);
            this.utilPrint.setEntete("Nature des familles de produits parc");
            var2 = new JRBeanCollectionDataSource(this.formNaturesFamillesProduitsParcs.getListeNatureParc());
         } else if (this.choixLigne.equals("naturesManifest")) {
            this.utilPrint.setRapport("NatureManifest");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator);
            this.utilPrint.setEntete("Nature des manifests");
            var2 = new JRBeanCollectionDataSource(this.formNaturesManifest.getListeNatureManifest());
         } else if (this.choixLigne.equals("naturesVentes")) {
            this.utilPrint.setRapport("NatureFamilleProduitVentes");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator);
            this.utilPrint.setEntete("Nature des familles de produits ventes");
            var2 = new JRBeanCollectionDataSource(this.formNaturesFamillesProduits.getListeNatureVentes());
         } else if (this.choixLigne.equals("natureJournauxCompta")) {
            this.utilPrint.setRapport("NaturesJournaux");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
            this.utilPrint.setEntete("Nature des Journaux Comptables");
            var2 = new JRBeanCollectionDataSource(this.formNaturesJournaux.getListeNatureJournaux());
         } else if (this.choixLigne.equals("naturesSalarie")) {
            this.utilPrint.setRapport("NaturesSalaries");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
            this.utilPrint.setEntete("Natures des salaries");
            var2 = new JRBeanCollectionDataSource(this.formNaturesSalarie.getListeNatureSalarie());
         } else if (this.choixLigne.equals("niveauxemplois")) {
            this.utilPrint.setRapport("NiveauxEmplois");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
            this.utilPrint.setEntete("Liste des niveaux d'emplois");
            var2 = new JRBeanCollectionDataSource(this.formNiveauxEmplois.getListeNiveauxEmplois());
         } else if (this.choixLigne.equals("codesemplois")) {
            this.utilPrint.setRapport("CodesEmplois");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
            this.utilPrint.setEntete("Liste des codes d'emplois");
            var2 = new JRBeanCollectionDataSource(this.formCodesEmplois.getListeCodesEmplois());
         } else if (this.choixLigne.equals("naturePrets")) {
            this.utilPrint.setRapport("NaturesPrets");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
            this.utilPrint.setEntete("Liste des natures de prêts");
            var2 = new JRBeanCollectionDataSource(this.formNaturesPrets.getListeNaturePret());
         } else if (this.choixLigne.equals("natureRH")) {
            this.utilPrint.setRapport("NaturesRH");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
            this.utilPrint.setEntete("Liste des natures des éléments R.H.");
            var2 = new JRBeanCollectionDataSource(this.formNaturesRH.getListeNature());
         } else if (this.choixLigne.equals("naturesRdv")) {
            this.utilPrint.setRapport("NaturesRDV");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator);
            this.utilPrint.setEntete("Liste des natures des RDV");
            var2 = new JRBeanCollectionDataSource(this.formNaturesRdv.getListeNatureRdv());
         } else if (this.choixLigne.equals("organisationAdministrative")) {
            this.utilPrint.setRapport("PanSitDepSev");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Organisation Administrative");
            this.utilPrint.setFiltre("Sites/Départements/Services");
            this.utilPrint.setRequete("requete");
            var2 = new JRBeanCollectionDataSource(var1);
         } else if (this.choixLigne.equals("organisationCommerciale")) {
            this.utilPrint.setRapport("PanRegSecPdv");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Organisation Commerciale");
            this.utilPrint.setFiltre("Regions/Secteurs/Points de ventes");
            this.utilPrint.setRequete("requete");
            var2 = new JRBeanCollectionDataSource(var1);
         } else if (this.choixLigne.equals("organisationProduction")) {
            this.utilPrint.setRapport("PanSitLigAte");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Organisation Production");
            this.utilPrint.setFiltre("Sites/Lignes/Ateliers");
            this.utilPrint.setRequete("requete");
            var2 = new JRBeanCollectionDataSource(var1);
         } else if (this.choixLigne.equals("pathologieMedical")) {
            this.utilPrint.setRapport("PathologieMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des types de pathologies médicales");
            var2 = new JRBeanCollectionDataSource(this.formPathologieMedical.getLesPathologieMedical());
         } else if (this.choixLigne.equals("pays")) {
            this.utilPrint.setRapport("ListePays");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
            this.utilPrint.setCheminSousrapport("");
            this.utilPrint.setEntete("Liste des pays");
            var2 = new JRBeanCollectionDataSource(this.formPays.getListePays());
         } else if (this.choixLigne.equals("banques")) {
            this.utilPrint.setRapport("ListeBanques");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
            this.utilPrint.setCheminSousrapport("");
            this.utilPrint.setEntete("Liste des banques");
            var2 = new JRBeanCollectionDataSource(this.formBanques.getListeBanques());
         } else if (this.choixLigne.equals("planComptablesCompta")) {
            this.utilPrint.setRapport("PlanComptable");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Plan comptable");
            this.utilPrint.setFiltre(this.formPlanComptable.getFiltre());
            var2 = new JRBeanCollectionDataSource(this.formPlanComptable.getMaListe());
         } else if (this.choixLigne.equals("planPaye")) {
            this.utilPrint.setRapport("PlanPaye");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
            this.utilPrint.setEntete("Liste du plan de paye");
            var2 = new JRBeanCollectionDataSource(this.formPlanPaye.getLesPlansPaye());
         } else if (this.choixLigne.equals("planAnalytiqueCompta")) {
            this.utilPrint.setRapport("PlanAnalytique");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Plan analytique");
            var2 = new JRBeanCollectionDataSource(this.formPlansAnalytiques.getLesPlansAnalytiques());
         } else if (this.choixLigne.equals("projets")) {
            this.utilPrint.setRapport("PlanProjets");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Plan des projets");
            var2 = new JRBeanCollectionDataSource(this.formPlanProjets.getProjetsList());
         } else if (this.choixLigne.equals("planBudgetairesCompta")) {
            this.utilPrint.setRapport("PlanBudgetaire");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete(this.formPlansBudgetaires.getEntete());
            this.utilPrint.setFiltre(this.formPlansBudgetaires.getFiltre());
            this.utilPrint.setRequete(this.formPlansBudgetaires.getRequete());
            var2 = new JRBeanCollectionDataSource(var1);
         } else if (this.choixLigne.equals("planTresorerieCompta")) {
            this.utilPrint.setRapport("PlanTresorerie");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
            var2 = new JRBeanCollectionDataSource(this.formPlansTresorerie.getLesPlansTresorerie());
         } else if (this.choixLigne.equals("medicamment")) {
            this.utilPrint.setRapport("MedicammentPublic");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des médicamments (Le Mayité)");
            var2 = new JRBeanCollectionDataSource(this.formMedicamment.getLesMedicamments());
         } else if (this.choixLigne.equals("protocolesMedical")) {
            this.utilPrint.setRapport("ProtocoleMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des protocoles médicaux");
            var2 = new JRBeanCollectionDataSource(this.formProtocoleMedical.getLesProtocoleMedical());
         } else if (this.choixLigne.equals("provenancesMedical")) {
            this.utilPrint.setRapport("ProvenancesMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setEntete("Nature des provenances médicales");
            var2 = new JRBeanCollectionDataSource(this.formProvenanceMedical.getListProvenance());
         } else if (this.choixLigne.equals("elementsInfirmerieMedical")) {
            this.utilPrint.setRapport("ElementsInfirmerieMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setEntete(this.formElementsInfirmerie.getLibelleType());
            var2 = new JRBeanCollectionDataSource(this.formElementsInfirmerie.getListElements());
         } else if (this.choixLigne.equals("epublicationVentes")) {
            this.utilPrint.setRapport("PublicationsProduits");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des publications des produits");
            var2 = new JRBeanCollectionDataSource(this.formPublicationProduits.getLesProduits());
         } else if (this.choixLigne.equals("racinesCompta")) {
            this.utilPrint.setRapport("RacinesComptables");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
            this.utilPrint.setEntete("Racines Comptables");
            var2 = new JRBeanCollectionDataSource(this.formRacines.getLesfiscalites());
         } else if (this.choixLigne.equals("reglementClient")) {
            this.utilPrint.setRapport("ReglementClients");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
            this.utilPrint.setEntete("Liste des règlements clients");
            var2 = new JRBeanCollectionDataSource(this.formReglementClient.getModeRegList());
         } else if (this.choixLigne.equals("reglementFournisseur")) {
            this.utilPrint.setRapport("ReglementFournisseurs");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
            this.utilPrint.setEntete("Liste des règlements fournisseurs");
            var2 = new JRBeanCollectionDataSource(this.formReglementFournisseur.getModeRegList());
         } else if (this.choixLigne.equals("sources")) {
            this.utilPrint.setRapport("ListeSourceTiers");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
            this.utilPrint.setEntete("Liste des sources des tiers");
            var2 = new JRBeanCollectionDataSource(this.formSourcesTiers.getListeSourcesTiers());
         } else if (this.choixLigne.equals("specialitesdical")) {
            this.utilPrint.setRapport("SpecialiteMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des spécialités médicales");
            var2 = new JRBeanCollectionDataSource(this.formSpecialitesMedical.getSpecialitesMedicalList());
         } else if (this.choixLigne.equals("suiviLivraisonVentes")) {
            this.utilPrint.setRapport("SuivisCmdVentes");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des suivis des livraisons des ventes");
            var2 = new JRBeanCollectionDataSource(this.formSuiviLivraisonVentes.getSuiviLivraisonVentesList());
         } else if (this.choixLigne.equals("taches")) {
            this.utilPrint.setRapport("ListeTaches");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
            this.utilPrint.setEntete("Liste des taches");
            var2 = new JRBeanCollectionDataSource(this.formTache.getListeTaches());
         } else if (this.choixLigne.equals("taxesAchats")) {
            this.utilPrint.setRapport("TaxesAchats");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des taxes achats");
            var2 = new JRBeanCollectionDataSource(this.formTaxesAchat.getTaxesAchatsList());
         } else if (this.choixLigne.equals("taxesMedical")) {
            this.utilPrint.setRapport("TaxesMedical");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des taxes medical");
            var2 = new JRBeanCollectionDataSource(this.formTaxesVentes.getTaxesVentesList());
         } else if (this.choixLigne.equals("taxesVentes")) {
            this.utilPrint.setRapport("TaxesVentes");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des taxes ventes");
            var2 = new JRBeanCollectionDataSource(this.formTaxesVentes.getTaxesVentesList());
         } else if (this.choixLigne.equals("typeReglement")) {
            this.utilPrint.setRapport("TypesReglements");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
            this.utilPrint.setEntete("Types de règlement par défaut");
            var2 = new JRBeanCollectionDataSource(this.formTypeReglement.getListeTypeReglement());
         } else if (this.choixLigne.equals("categorietiers")) {
            this.utilPrint.setRapport("CategorieTiers");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
            this.utilPrint.setEntete("Liste des types des tiers");
            var2 = new JRBeanCollectionDataSource(this.formCategoriesTiers.getListeCategoriesTiers());
         } else if (this.choixLigne.equals("unites")) {
            this.utilPrint.setRapport("ProduitsUnite");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des unités des produits");
            var2 = new JRBeanCollectionDataSource(this.formUnite.getLesUnite());
         } else if (this.choixLigne.equals("processAchats")) {
            this.utilPrint.setRapport("ProcessAchat");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des process");
            var2 = new JRBeanCollectionDataSource(this.formProcessAchats.getProcessEnteteList());
         } else if (this.choixLigne.equals("planBudgetairesAchats")) {
            this.utilPrint.setRapport("PlanBudgetaireAchats");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete(this.formPlansBudgetaires.getEntete());
            this.utilPrint.setFiltre(this.formPlansBudgetaires.getFiltre());
            this.utilPrint.setRequete(this.formPlansBudgetaires.getRequete());
            var2 = new JRBeanCollectionDataSource(var1);
         } else if (this.choixLigne.equals("filieresEducation")) {
            this.utilPrint.setRapport("FilieresEducation");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des filières de l`éducation");
            var2 = new JRBeanCollectionDataSource(this.formFilieres.getLesFilieres());
         } else if (this.choixLigne.equals("users")) {
            this.utilPrint.setRapport("Utilisateurs");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des utilisateurs");
            if (this.formUsers.getTypeSelectionne() == 0) {
               var2 = new JRBeanCollectionDataSource(this.formUsers.getLesActifs());
            } else if (this.formUsers.getTypeSelectionne() == 1) {
               var2 = new JRBeanCollectionDataSource(this.formUsers.getLesCoAdm());
            } else if (this.formUsers.getTypeSelectionne() == 2) {
               var2 = new JRBeanCollectionDataSource(this.formUsers.getLesAdm());
            } else if (this.formUsers.getTypeSelectionne() == 3) {
               var2 = new JRBeanCollectionDataSource(this.formUsers.getLesGuest());
            } else if (this.formUsers.getTypeSelectionne() == 4) {
               var2 = new JRBeanCollectionDataSource(this.formUsers.getLesInactif());
            }
         } else if (this.choixLigne.equals("naturesBiens")) {
            this.utilPrint.setRapport("NatureBiens");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator);
            this.utilPrint.setEntete("Nature des biens");
            var2 = new JRBeanCollectionDataSource(this.formNaturesBiens.getListeNatureBiens());
         } else if (this.choixLigne.equals("naturesInterim")) {
            this.utilPrint.setRapport("NatureInterim");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "interim" + File.separator);
            this.utilPrint.setEntete("Nature de l'interim");
            var2 = new JRBeanCollectionDataSource(this.formNaturesInterim.getListeNatureVentes());
         } else if (this.choixLigne.equals("naturesCourrier")) {
            this.utilPrint.setRapport("NaturesCourrier");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator);
            this.utilPrint.setEntete("Liste des natures des courriers");
            var2 = new JRBeanCollectionDataSource(this.formNaturesCourrier.getListeNature());
         } else if (this.choixLigne.equals("naturesAffaire")) {
            this.utilPrint.setRapport("NaturesAffaires");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator);
            this.utilPrint.setEntete("Liste des natures des porte-feuilles d`affaire");
            var2 = new JRBeanCollectionDataSource(this.formNaturesAffaires.getListeNature());
         } else if (this.choixLigne.equals("sujetRdv")) {
            this.utilPrint.setRapport("SujetRdv");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator);
            this.utilPrint.setEntete("Liste des sujets des RDV");
            var2 = new JRBeanCollectionDataSource(this.formElementRdv.getListeElement());
         } else if (this.choixLigne.equals("lieuxRdv")) {
            this.utilPrint.setRapport("LieuxRdv");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator);
            this.utilPrint.setEntete("Liste des lieux des RDV");
            var2 = new JRBeanCollectionDataSource(this.formElementRdv.getListeElement());
         } else if (this.choixLigne.equals("budgetRdv")) {
            this.utilPrint.setRapport("BudgetRdv");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator);
            this.utilPrint.setEntete("Liste des budgets des RDV");
            var2 = new JRBeanCollectionDataSource(this.formElementRdv.getListeElement());
         } else if (this.choixLigne.equals("apportRdv")) {
            this.utilPrint.setRapport("ApportRdv");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator);
            this.utilPrint.setEntete("Liste des apports des RDV");
            var2 = new JRBeanCollectionDataSource(this.formElementRdv.getListeElement());
         } else if (this.choixLigne.equals("modeFinRdv")) {
            this.utilPrint.setRapport("ModeFinRdv");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator);
            this.utilPrint.setEntete("Liste des modes de financements des RDV");
            var2 = new JRBeanCollectionDataSource(this.formElementRdv.getListeElement());
         } else if (this.choixLigne.equals("delaisRdv")) {
            this.utilPrint.setRapport("DelaisRdv");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator);
            this.utilPrint.setEntete("Liste des délais d`exécution des RDV");
            var2 = new JRBeanCollectionDataSource(this.formElementRdv.getListeElement());
         } else if (this.choixLigne.equals("actionRdv")) {
            this.utilPrint.setRapport("ActionRdv");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator);
            this.utilPrint.setEntete("Liste des prochaines actions des RDV");
            var2 = new JRBeanCollectionDataSource(this.formElementRdv.getListeElement());
         } else if (this.choixLigne.equals("conclusionRdv")) {
            this.utilPrint.setRapport("ConclusionRdv");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator);
            this.utilPrint.setEntete("Liste des conclusions des RDV");
            var2 = new JRBeanCollectionDataSource(this.formElementRdv.getListeElement());
         } else if (this.choixLigne.equals("centreInteret")) {
            this.utilPrint.setRapport("CentreInteret");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
            this.utilPrint.setEntete("Liste des centres d`intérêts");
            var2 = new JRBeanCollectionDataSource(this.formElementRdv.getListeElement());
         } else if (this.choixLigne.equals("classementMediatheque")) {
            this.utilPrint.setRapport("ClassementMediatheque");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator);
            this.utilPrint.setEntete("Classement des documents");
            var2 = new JRBeanCollectionDataSource(this.formClassementMediatheque.getListeComplete());
         } else if (this.choixLigne.equals("natureDemande")) {
            this.utilPrint.setRapport("NaturesDemandes");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "fondation" + File.separator);
            this.utilPrint.setEntete("Nature des demandes");
            var2 = new JRBeanCollectionDataSource(this.formNaturesDemande.getListeNatureDemande());
         } else if (this.choixLigne.equals("chronosForet")) {
            this.utilPrint.setRapport("ChronoForet");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Liste des chronos de la Forêt");
            var2 = new JRBeanCollectionDataSource(this.formChronoForet.getChronoList());
         } else if (this.choixLigne.equals("essencesForet")) {
            this.utilPrint.setRapport("EssencesForet");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator);
            this.utilPrint.setEntete("Liste des essences de la forêt");
            var2 = new JRBeanCollectionDataSource(this.formEssenceForet.getListeElement());
         } else if (this.choixLigne.equals("classementsForet")) {
            this.utilPrint.setRapport("ClassementsForet");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator);
            this.utilPrint.setEntete("Liste des classements des bois");
            var2 = new JRBeanCollectionDataSource(this.formClassementForet.getListeElement());
         } else if (this.choixLigne.equals("chantiersForet")) {
            this.utilPrint.setRapport("ChantiersForet");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator);
            this.utilPrint.setEntete("Liste des chantiers des bois");
            var2 = new JRBeanCollectionDataSource(this.formChantiersForet.getLesChantiers());
         } else if (this.choixLigne.equals("modeleDevis")) {
            this.utilPrint.setRapport("ModelesDevis");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator);
            this.utilPrint.setEntete("Liste des modèles des devis");
            var2 = new JRBeanCollectionDataSource(this.formModelesDevisVentes.getListeElement());
         }
      } else {
         this.utilPrint.setRapport("ChronoVentes");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Liste des chronos des ventes");
         var2 = new JRBeanCollectionDataSource(this.formChronoVte.getChronoList());
      }

      if (var2.getData().size() != 0) {
         this.utilPrint.setjRBeanCollectionDataSource(var2);
         this.utilPrint.imprimeRapport();
      } else if (this.utilPrint.getRequete() != null && !this.utilPrint.getRequete().isEmpty()) {
         this.utilPrint.setjRBeanCollectionDataSource(var2);
         this.utilPrint.imprimeRapport();
      }

   }

   public LectureModulesOnglets getLesOnglets() {
      return this.lesOnglets;
   }

   public void setLesOnglets(LectureModulesOnglets var1) {
      this.lesOnglets = var1;
   }

   public MenuListe getMenuAdministration() {
      return this.menuAdministration;
   }

   public void setMenuAdministration(MenuListe var1) {
      this.menuAdministration = var1;
   }

   public ObjetLigneMenu getMenuadministration() {
      return this.menuadministration;
   }

   public void setMenuadministration(ObjetLigneMenu var1) {
      this.menuadministration = var1;
   }

   public MenudroitAdministrationCtrl getMenudroitAdministrationCtrl() {
      return this.menudroitAdministrationCtrl;
   }

   public void setMenudroitAdministrationCtrl(MenudroitAdministrationCtrl var1) {
      this.menudroitAdministrationCtrl = var1;
   }

   public String getAffichePage() {
      return this.affichePage;
   }

   public void setAffichePage(String var1) {
      this.affichePage = var1;
   }

   public LectureFormesJuridiques getFormJuridique() {
      return this.formJuridique;
   }

   public void setFormJuridique(LectureFormesJuridiques var1) {
      this.formJuridique = var1;
   }

   public FormStructureEntete getFormStructureEntete() {
      return this.formStructureEntete;
   }

   public void setFormStructureEntete(FormStructureEntete var1) {
      this.formStructureEntete = var1;
   }

   public LectureTypesSocietes getTypeSociete() {
      return this.typeSociete;
   }

   public void setTypeSociete(LectureTypesSocietes var1) {
      this.typeSociete = var1;
   }

   public LectureZonesCommerciales getZoneCommerciale() {
      return this.zoneCommerciale;
   }

   public void setZoneCommerciale(LectureZonesCommerciales var1) {
      this.zoneCommerciale = var1;
   }

   public ListDataModel getDatamodelBal() {
      return this.datamodelBal;
   }

   public void setDatamodelBal(ListDataModel var1) {
      this.datamodelBal = var1;
   }

   public String getLienPanel() {
      return this.lienPanel;
   }

   public void setLienPanel(String var1) {
      this.lienPanel = var1;
   }

   public FormInfoSysteme getFormInfoSysteme() {
      return this.formInfoSysteme;
   }

   public void setFormInfoSysteme(FormInfoSysteme var1) {
      this.formInfoSysteme = var1;
   }

   public LectureZonesFiscales getZoneFiscales() {
      return this.zoneFiscales;
   }

   public void setZoneFiscales(LectureZonesFiscales var1) {
      this.zoneFiscales = var1;
   }

   public FormUsers getFormUsers() {
      return this.formUsers;
   }

   public void setFormUsers(FormUsers var1) {
      this.formUsers = var1;
   }

   public String getCodeMod() {
      return this.CodeMod;
   }

   public void setCodeMod(String var1) {
      this.CodeMod = var1;
   }

   public String getLibelleMod() {
      return this.libelleMod;
   }

   public void setLibelleMod(String var1) {
      this.libelleMod = var1;
   }

   public boolean isOngAchat() {
      return this.ongAchat;
   }

   public void setOngAchat(boolean var1) {
      this.ongAchat = var1;
   }

   public boolean isOngCaisse() {
      return this.ongCaisse;
   }

   public void setOngCaisse(boolean var1) {
      this.ongCaisse = var1;
   }

   public boolean isOngCompta() {
      return this.ongCompta;
   }

   public void setOngCompta(boolean var1) {
      this.ongCompta = var1;
   }

   public boolean isOngParc() {
      return this.ongParc;
   }

   public void setOngParc(boolean var1) {
      this.ongParc = var1;
   }

   public boolean isOngPay() {
      return this.ongPay;
   }

   public void setOngPay(boolean var1) {
      this.ongPay = var1;
   }

   public int getOngSuiviCom() {
      return this.ongSuiviCom;
   }

   public void setOngSuiviCom(int var1) {
      this.ongSuiviCom = var1;
   }

   public DataModel getDataModelMenuHorizontal() {
      return this.dataModelMenuHorizontal;
   }

   public void setDataModelMenuHorizontal(DataModel var1) {
      this.dataModelMenuHorizontal = var1;
   }

   public String getMods() {
      return this.mods;
   }

   public void setMods(String var1) {
      this.mods = var1;
   }

   public DataModel getDataModelModuleParam() {
      return this.dataModelModuleParam;
   }

   public void setDataModelModuleParam(DataModel var1) {
      this.dataModelModuleParam = var1;
   }

   public String getChoixModule() {
      return this.choixModule;
   }

   public void setChoixModule(String var1) {
      this.choixModule = var1;
   }

   public long getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(long var1) {
      this.selectedExo = var1;
   }

   public int getTaille() {
      return this.taille;
   }

   public void setTaille(int var1) {
      this.taille = var1;
   }

   public String getChoixLigne() {
      return this.choixLigne;
   }

   public void setChoixLigne(String var1) {
      this.choixLigne = var1;
   }

   public FormDevises getFormDevises() {
      return this.formDevises;
   }

   public void setFormDevises(FormDevises var1) {
      this.formDevises = var1;
   }

   public FormAppreciations getFormAppreciations() {
      return this.formAppreciations;
   }

   public void setFormAppreciations(FormAppreciations var1) {
      this.formAppreciations = var1;
   }

   public FormCivilites getFormCivilites() {
      return this.formCivilites;
   }

   public void setFormCivilites(FormCivilites var1) {
      this.formCivilites = var1;
   }

   public FormSourcesTiers getFormSourcesTiers() {
      return this.formSourcesTiers;
   }

   public void setFormSourcesTiers(FormSourcesTiers var1) {
      this.formSourcesTiers = var1;
   }

   public FormTypeTiers getFormCategoriesTiers() {
      return this.formCategoriesTiers;
   }

   public void setFormCategoriesTiers(FormTypeTiers var1) {
      this.formCategoriesTiers = var1;
   }

   public FormFonctions getFormFonctions() {
      return this.formFonctions;
   }

   public void setFormFonctions(FormFonctions var1) {
      this.formFonctions = var1;
   }

   public FormFormesJuridiques getFormFormesJuridiques() {
      return this.formFormesJuridiques;
   }

   public void setFormFormesJuridiques(FormFormesJuridiques var1) {
      this.formFormesJuridiques = var1;
   }

   public FormPays getFormPays() {
      return this.formPays;
   }

   public void setFormPays(FormPays var1) {
      this.formPays = var1;
   }

   public FormFamilleClient getFormFamilleClient() {
      return this.formFamilleClient;
   }

   public void setFormFamilleClient(FormFamilleClient var1) {
      this.formFamilleClient = var1;
   }

   public FormOptionsOffice getFormOptionTiers() {
      return this.formOptionTiers;
   }

   public void setFormOptionTiers(FormOptionsOffice var1) {
      this.formOptionTiers = var1;
   }

   public FormTache getFormTache() {
      return this.formTache;
   }

   public void setFormTache(FormTache var1) {
      this.formTache = var1;
   }

   public FormExercicesAchats getFormExercicesAchats() {
      return this.formExercicesAchats;
   }

   public void setFormExercicesAchats(FormExercicesAchats var1) {
      this.formExercicesAchats = var1;
   }

   public LectureZonesFiscales getZonesFiscales() {
      return this.zonesFiscales;
   }

   public void setZonesFiscales(LectureZonesFiscales var1) {
      this.zonesFiscales = var1;
   }

   public FormDepotAchats getFormDepotAchats() {
      return this.formDepotAchats;
   }

   public void setFormDepotAchats(FormDepotAchats var1) {
      this.formDepotAchats = var1;
   }

   public FormChronoAch getFormChronoAch() {
      return this.formChronoAch;
   }

   public void setFormChronoAch(FormChronoAch var1) {
      this.formChronoAch = var1;
   }

   public FormTaxesAchat getFormTaxesAchat() {
      return this.formTaxesAchat;
   }

   public void setFormTaxesAchat(FormTaxesAchat var1) {
      this.formTaxesAchat = var1;
   }

   public FormNaturesFamillesProduitsAchats getFormNatProdAchats() {
      return this.formNatProdAchats;
   }

   public void setFormNatProdAchats(FormNaturesFamillesProduitsAchats var1) {
      this.formNatProdAchats = var1;
   }

   public FormFamilleProduitsAchats getFormFamilleProdAchats() {
      return this.formFamilleProdAchats;
   }

   public void setFormFamilleProdAchats(FormFamilleProduitsAchats var1) {
      this.formFamilleProdAchats = var1;
   }

   public FormFormulesAchats getFormFormulesAchats() {
      return this.formFormulesAchats;
   }

   public void setFormFormulesAchats(FormFormulesAchats var1) {
      this.formFormulesAchats = var1;
   }

   public FormUnite getFormUnite() {
      return this.formUnite;
   }

   public void setFormUnite(FormUnite var1) {
      this.formUnite = var1;
   }

   public FormConditionnement getFormConditionnement() {
      return this.formConditionnement;
   }

   public void setFormConditionnement(FormConditionnement var1) {
      this.formConditionnement = var1;
   }

   public FormExercicesVentes getFormExercicesVentes() {
      return this.formExercicesVentes;
   }

   public void setFormExercicesVentes(FormExercicesVentes var1) {
      this.formExercicesVentes = var1;
   }

   public FormChronoVte getFormChronoVte() {
      return this.formChronoVte;
   }

   public void setFormChronoVte(FormChronoVte var1) {
      this.formChronoVte = var1;
   }

   public FormNaturesFamillesProduitsVentes getFormNaturesFamillesProduits() {
      return this.formNaturesFamillesProduits;
   }

   public void setFormNaturesFamillesProduits(FormNaturesFamillesProduitsVentes var1) {
      this.formNaturesFamillesProduits = var1;
   }

   public FormTaxesVentes getFormTaxesVentes() {
      return this.formTaxesVentes;
   }

   public void setFormTaxesVentes(FormTaxesVentes var1) {
      this.formTaxesVentes = var1;
   }

   public FormFamilleProduitsVentes getFormFamillesProduitsVentes() {
      return this.formFamillesProduitsVentes;
   }

   public void setFormFamillesProduitsVentes(FormFamilleProduitsVentes var1) {
      this.formFamillesProduitsVentes = var1;
   }

   public FormSuiviLivraisonVentes getFormSuiviLivraisonVentes() {
      return this.formSuiviLivraisonVentes;
   }

   public void setFormSuiviLivraisonVentes(FormSuiviLivraisonVentes var1) {
      this.formSuiviLivraisonVentes = var1;
   }

   public FormFormulesVentes getFormFormulesVentes() {
      return this.formFormulesVentes;
   }

   public void setFormFormulesVentes(FormFormulesVentes var1) {
      this.formFormulesVentes = var1;
   }

   public FormProduitsVtes getFormProduitsVtes() {
      return this.formProduitsVtes;
   }

   public void setFormProduitsVtes(FormProduitsVtes var1) {
      this.formProduitsVtes = var1;
   }

   public FormExercicesMedical getFormExercicesMedical() {
      return this.formExercicesMedical;
   }

   public void setFormExercicesMedical(FormExercicesMedical var1) {
      this.formExercicesMedical = var1;
   }

   public FormCcamMedical getFormCcamMedical() {
      return this.formCcamMedical;
   }

   public void setFormCcamMedical(FormCcamMedical var1) {
      this.formCcamMedical = var1;
   }

   public FormChronoMed getFormChronoMed() {
      return this.formChronoMed;
   }

   public void setFormChronoMed(FormChronoMed var1) {
      this.formChronoMed = var1;
   }

   public FormCimMedical getFormCimMedical() {
      return this.formCimMedical;
   }

   public void setFormCimMedical(FormCimMedical var1) {
      this.formCimMedical = var1;
   }

   public FormCmaMedical getFormCmaMedical() {
      return this.formCmaMedical;
   }

   public void setFormCmaMedical(FormCmaMedical var1) {
      this.formCmaMedical = var1;
   }

   public FormCmdMedical getFormCmdMedical() {
      return this.formCmdMedical;
   }

   public void setFormCmdMedical(FormCmdMedical var1) {
      this.formCmdMedical = var1;
   }

   public FormDestinationMedical getFormDestinationMedical() {
      return this.formDestinationMedical;
   }

   public void setFormDestinationMedical(FormDestinationMedical var1) {
      this.formDestinationMedical = var1;
   }

   public FormLettreMedical getFormLettreMedical() {
      return this.formLettreMedical;
   }

   public void setFormLettreMedical(FormLettreMedical var1) {
      this.formLettreMedical = var1;
   }

   public FormMotifEntreeMedical getFormMotifEntreeMedical() {
      return this.formMotifEntreeMedical;
   }

   public void setFormMotifEntreeMedical(FormMotifEntreeMedical var1) {
      this.formMotifEntreeMedical = var1;
   }

   public FormMotifSortieMedical getFormMotifSortieMedical() {
      return this.formMotifSortieMedical;
   }

   public void setFormMotifSortieMedical(FormMotifSortieMedical var1) {
      this.formMotifSortieMedical = var1;
   }

   public FormNaturesFamillesProduitsMedical getFormNaturesFamillesProduitsMedical() {
      return this.formNaturesFamillesProduitsMedical;
   }

   public void setFormNaturesFamillesProduitsMedical(FormNaturesFamillesProduitsMedical var1) {
      this.formNaturesFamillesProduitsMedical = var1;
   }

   public FormProtocoleMedical getFormProtocoleMedical() {
      return this.formProtocoleMedical;
   }

   public void setFormProtocoleMedical(FormProtocoleMedical var1) {
      this.formProtocoleMedical = var1;
   }

   public FormProvenanceMedical getFormProvenanceMedical() {
      return this.formProvenanceMedical;
   }

   public void setFormProvenanceMedical(FormProvenanceMedical var1) {
      this.formProvenanceMedical = var1;
   }

   public FormSpecialitesMedical getFormSpecialitesMedical() {
      return this.formSpecialitesMedical;
   }

   public void setFormSpecialitesMedical(FormSpecialitesMedical var1) {
      this.formSpecialitesMedical = var1;
   }

   public FormCaissesCommerciales getFormCaissesCommerciales() {
      return this.formCaissesCommerciales;
   }

   public void setFormCaissesCommerciales(FormCaissesCommerciales var1) {
      this.formCaissesCommerciales = var1;
   }

   public FormChronoCaisses getFormChronoCaisses() {
      return this.formChronoCaisses;
   }

   public void setFormChronoCaisses(FormChronoCaisses var1) {
      this.formChronoCaisses = var1;
   }

   public FormExercicesCaisse getFormExercicesCaisse() {
      return this.formExercicesCaisse;
   }

   public void setFormExercicesCaisse(FormExercicesCaisse var1) {
      this.formExercicesCaisse = var1;
   }

   public FormExercicesComptables getFormExercicesComptables() {
      return this.formExercicesComptables;
   }

   public void setFormExercicesComptables(FormExercicesComptables var1) {
      this.formExercicesComptables = var1;
   }

   public FormOptionComptabilite getFormOptionComptabilite() {
      return this.formOptionComptabilite;
   }

   public void setFormOptionComptabilite(FormOptionComptabilite var1) {
      this.formOptionComptabilite = var1;
   }

   public FormPlanComptable getFormPlanComptable() {
      return this.formPlanComptable;
   }

   public void setFormPlanComptable(FormPlanComptable var1) {
      this.formPlanComptable = var1;
   }

   public FormRacines getFormRacines() {
      return this.formRacines;
   }

   public void setFormRacines(FormRacines var1) {
      this.formRacines = var1;
   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public FormNaturesComptes getFormNaturesCompte() {
      return this.formNaturesCompte;
   }

   public void setFormNaturesCompte(FormNaturesComptes var1) {
      this.formNaturesCompte = var1;
   }

   public FormNaturesJournaux getFormNaturesJournaux() {
      return this.formNaturesJournaux;
   }

   public void setFormNaturesJournaux(FormNaturesJournaux var1) {
      this.formNaturesJournaux = var1;
   }

   public FormChronoCpta getFormChronoCpta() {
      return this.formChronoCpta;
   }

   public void setFormChronoCpta(FormChronoCpta var1) {
      this.formChronoCpta = var1;
   }

   public FormOptionsAchats getFormOptionsAchats() {
      return this.formOptionsAchats;
   }

   public void setFormOptionsAchats(FormOptionsAchats var1) {
      this.formOptionsAchats = var1;
   }

   public FormOptionsVentes getFormOptionsVentes() {
      return this.formOptionsVentes;
   }

   public void setFormOptionsVentes(FormOptionsVentes var1) {
      this.formOptionsVentes = var1;
   }

   public FormOptionsMedical getFormOptionsMedical() {
      return this.formOptionsMedical;
   }

   public void setFormOptionsMedical(FormOptionsMedical var1) {
      this.formOptionsMedical = var1;
   }

   public FormOptionsCaisse getFormOptionsCaisse() {
      return this.formOptionsCaisse;
   }

   public void setFormOptionsCaisse(FormOptionsCaisse var1) {
      this.formOptionsCaisse = var1;
   }

   public FormFamilleFournisseur getFormFamilleFournisseur() {
      return this.formFamilleFournisseur;
   }

   public void setFormFamilleFournisseur(FormFamilleFournisseur var1) {
      this.formFamilleFournisseur = var1;
   }

   public FormReglementClient getFormReglementClient() {
      return this.formReglementClient;
   }

   public void setFormReglementClient(FormReglementClient var1) {
      this.formReglementClient = var1;
   }

   public FormReglementFournisseur getFormReglementFournisseur() {
      return this.formReglementFournisseur;
   }

   public void setFormReglementFournisseur(FormReglementFournisseur var1) {
      this.formReglementFournisseur = var1;
   }

   public FormJournauxComptables getFormJournauxComptables() {
      return this.formJournauxComptables;
   }

   public void setFormJournauxComptables(FormJournauxComptables var1) {
      this.formJournauxComptables = var1;
   }

   public FormOrganisationAdministrative getFormOrganisationAdministrative() {
      return this.formOrganisationAdministrative;
   }

   public void setFormOrganisationAdministrative(FormOrganisationAdministrative var1) {
      this.formOrganisationAdministrative = var1;
   }

   public FormActivitesCommerciales getFormActivitesCommerciales() {
      return this.formActivitesCommerciales;
   }

   public void setFormActivitesCommerciales(FormActivitesCommerciales var1) {
      this.formActivitesCommerciales = var1;
   }

   public FormOrganisationCommerciale getFormOrganisationCommerciale() {
      return this.formOrganisationCommerciale;
   }

   public void setFormOrganisationCommerciale(FormOrganisationCommerciale var1) {
      this.formOrganisationCommerciale = var1;
   }

   public FormGroupe getFormGroupe() {
      return this.formGroupe;
   }

   public void setFormGroupe(FormGroupe var1) {
      this.formGroupe = var1;
   }

   public FormAntecedentCDA getFormAntecedentCDA() {
      return this.formAntecedentCDA;
   }

   public void setFormAntecedentCDA(FormAntecedentCDA var1) {
      this.formAntecedentCDA = var1;
   }

   public FormPathologieMedical getFormPathologieMedical() {
      return this.formPathologieMedical;
   }

   public void setFormPathologieMedical(FormPathologieMedical var1) {
      this.formPathologieMedical = var1;
   }

   public FormMotifentreeConsultMedical getFormMotifentreeConsultMedical() {
      return this.formMotifentreeConsultMedical;
   }

   public void setFormMotifentreeConsultMedical(FormMotifentreeConsultMedical var1) {
      this.formMotifentreeConsultMedical = var1;
   }

   public FormProduitsMedicamment getFormMedicamment() {
      return this.formMedicamment;
   }

   public void setFormMedicamment(FormProduitsMedicamment var1) {
      this.formMedicamment = var1;
   }

   public FormPlansBudgetaires getFormPlansBudgetaires() {
      return this.formPlansBudgetaires;
   }

   public void setFormPlansBudgetaires(FormPlansBudgetaires var1) {
      this.formPlansBudgetaires = var1;
   }

   public FormPlansAnalytiques getFormPlansAnalytiques() {
      return this.formPlansAnalytiques;
   }

   public void setFormPlansAnalytiques(FormPlansAnalytiques var1) {
      this.formPlansAnalytiques = var1;
   }

   public FormOrganisationProduction getFormOrganisationProduction() {
      return this.formOrganisationProduction;
   }

   public void setFormOrganisationProduction(FormOrganisationProduction var1) {
      this.formOrganisationProduction = var1;
   }

   public FormEtatFinancierConfigClient getFormEtatFinancierConfigClient() {
      return this.formEtatFinancierConfigClient;
   }

   public void setFormEtatFinancierConfigClient(FormEtatFinancierConfigClient var1) {
      this.formEtatFinancierConfigClient = var1;
   }

   public FormExercicesParcs getFormExercicesParcs() {
      return this.formExercicesParcs;
   }

   public void setFormExercicesParcs(FormExercicesParcs var1) {
      this.formExercicesParcs = var1;
   }

   public FormOptionsParc getFormOptionsParc() {
      return this.formOptionsParc;
   }

   public void setFormOptionsParc(FormOptionsParc var1) {
      this.formOptionsParc = var1;
   }

   public FormChronoParcs getFormChronoParcs() {
      return this.formChronoParcs;
   }

   public void setFormChronoParcs(FormChronoParcs var1) {
      this.formChronoParcs = var1;
   }

   public FormNaturesFamillesProduitsParcs getFormNaturesFamillesProduitsParcs() {
      return this.formNaturesFamillesProduitsParcs;
   }

   public void setFormNaturesFamillesProduitsParcs(FormNaturesFamillesProduitsParcs var1) {
      this.formNaturesFamillesProduitsParcs = var1;
   }

   public FormFamilleParcs getFormFamilleParcs() {
      return this.formFamilleParcs;
   }

   public void setFormFamilleParcs(FormFamilleParcs var1) {
      this.formFamilleParcs = var1;
   }

   public FormChronoPaye getFormChronoPaye() {
      return this.formChronoPaye;
   }

   public void setFormChronoPaye(FormChronoPaye var1) {
      this.formChronoPaye = var1;
   }

   public FormExercicesPaye getFormExercicesPaye() {
      return this.formExercicesPaye;
   }

   public void setFormExercicesPaye(FormExercicesPaye var1) {
      this.formExercicesPaye = var1;
   }

   public FormOptionsPaye getFormOptionsPaye() {
      return this.formOptionsPaye;
   }

   public void setFormOptionsPaye(FormOptionsPaye var1) {
      this.formOptionsPaye = var1;
   }

   public FormNaturesSalarie getFormNaturesSalarie() {
      return this.formNaturesSalarie;
   }

   public void setFormNaturesSalarie(FormNaturesSalarie var1) {
      this.formNaturesSalarie = var1;
   }

   public FormCaracteristiquesParcs getFormCaracteristiquesParcs() {
      return this.formCaracteristiquesParcs;
   }

   public void setFormCaracteristiquesParcs(FormCaracteristiquesParcs var1) {
      this.formCaracteristiquesParcs = var1;
   }

   public FormTypeReglement getFormTypeReglement() {
      return this.formTypeReglement;
   }

   public void setFormTypeReglement(FormTypeReglement var1) {
      this.formTypeReglement = var1;
   }

   public FormPublicationProduits getFormPublicationProduits() {
      return this.formPublicationProduits;
   }

   public void setFormPublicationProduits(FormPublicationProduits var1) {
      this.formPublicationProduits = var1;
   }

   public FormCentresImpots getFormCentresImpots() {
      return this.formCentresImpots;
   }

   public void setFormCentresImpots(FormCentresImpots var1) {
      this.formCentresImpots = var1;
   }

   public FormClassementsAgents getFormClassementsAgents() {
      return this.formClassementsAgents;
   }

   public void setFormClassementsAgents(FormClassementsAgents var1) {
      this.formClassementsAgents = var1;
   }

   public FormNiveauxEmplois getFormNiveauxEmplois() {
      return this.formNiveauxEmplois;
   }

   public void setFormNiveauxEmplois(FormNiveauxEmplois var1) {
      this.formNiveauxEmplois = var1;
   }

   public FormConventionsCollectives getFormConventionsCollectives() {
      return this.formConventionsCollectives;
   }

   public void setFormConventionsCollectives(FormConventionsCollectives var1) {
      this.formConventionsCollectives = var1;
   }

   public FormModelesCourriersPaye getFormModelesCourriersPaye() {
      return this.formModelesCourriersPaye;
   }

   public void setFormModelesCourriersPaye(FormModelesCourriersPaye var1) {
      this.formModelesCourriersPaye = var1;
   }

   public FormModelesCourriersVentes getFormModelesCourriersVentes() {
      return this.formModelesCourriersVentes;
   }

   public void setFormModelesCourriersVentes(FormModelesCourriersVentes var1) {
      this.formModelesCourriersVentes = var1;
   }

   public FormChronoOffice getFormChronoOffice() {
      return this.formChronoOffice;
   }

   public void setFormChronoOffice(FormChronoOffice var1) {
      this.formChronoOffice = var1;
   }

   public FormOptionsStocks getFormOptionsStocks() {
      return this.formOptionsStocks;
   }

   public void setFormOptionsStocks(FormOptionsStocks var1) {
      this.formOptionsStocks = var1;
   }

   public FormMotifEntreeParc getFormMotifEntreeParc() {
      return this.formMotifEntreeParc;
   }

   public void setFormMotifEntreeParc(FormMotifEntreeParc var1) {
      this.formMotifEntreeParc = var1;
   }

   public List getMesJournauxComptables() {
      return this.mesJournauxComptables;
   }

   public void setMesJournauxComptables(List var1) {
      this.mesJournauxComptables = var1;
   }

   public FormCabinet getFormCabinet() {
      return this.formCabinet;
   }

   public void setFormCabinet(FormCabinet var1) {
      this.formCabinet = var1;
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

   public boolean isVar_showBarProg() {
      return this.var_showBarProg;
   }

   public void setVar_showBarProg(boolean var1) {
      this.var_showBarProg = var1;
   }

   public FormHabilitation getFormHabilitation() {
      return this.formHabilitation;
   }

   public void setFormHabilitation(FormHabilitation var1) {
      this.formHabilitation = var1;
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

   public UtilInitHibernate getInitHibernateSessionFactory_2() {
      return this.utilInitHibernate;
   }

   public void setutilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public MenuModule getMenuModule() {
      return this.menuModule;
   }

   public void setMenuModule(MenuModule var1) {
      this.menuModule = var1;
   }

   public FormActivitesSocietes getFormActivitesSocietes() {
      return this.formActivitesSocietes;
   }

   public void setFormActivitesSocietes(FormActivitesSocietes var1) {
      this.formActivitesSocietes = var1;
   }

   public FormFraisTheoAchats getFormFraisTheoAchats() {
      return this.formFraisTheoAchats;
   }

   public void setFormFraisTheoAchats(FormFraisTheoAchats var1) {
      this.formFraisTheoAchats = var1;
   }

   public MenudroitCoAdministrationCtrl getMenudroitCoAdministrationCtrl() {
      return this.menudroitCoAdministrationCtrl;
   }

   public void setMenudroitCoAdministrationCtrl(MenudroitCoAdministrationCtrl var1) {
      this.menudroitCoAdministrationCtrl = var1;
   }

   public FormGestionRepertoire getFormGestionRepertoire() {
      return this.formGestionRepertoire;
   }

   public void setFormGestionRepertoire(FormGestionRepertoire var1) {
      this.formGestionRepertoire = var1;
   }

   public FormPlanPaye getFormPlanPaye() {
      return this.formPlanPaye;
   }

   public void setFormPlanPaye(FormPlanPaye var1) {
      this.formPlanPaye = var1;
   }

   public FormFeuilleCalcul getFormFeuilleCalcul() {
      return this.formFeuilleCalcul;
   }

   public void setFormFeuilleCalcul(FormFeuilleCalcul var1) {
      this.formFeuilleCalcul = var1;
   }

   public FormCouleur getFormCouleur() {
      return this.formCouleur;
   }

   public void setFormCouleur(FormCouleur var1) {
      this.formCouleur = var1;
   }

   public FormDouanes getFormDouanes() {
      return this.formDouanes;
   }

   public void setFormDouanes(FormDouanes var1) {
      this.formDouanes = var1;
   }

   public FormIncoterm getFormIncoterm() {
      return this.formIncoterm;
   }

   public void setFormIncoterm(FormIncoterm var1) {
      this.formIncoterm = var1;
   }

   public FormMarques getFormMarques() {
      return this.formMarques;
   }

   public void setFormMarques(FormMarques var1) {
      this.formMarques = var1;
   }

   public OptionCaisses getOptionCaisses() {
      return this.optionCaisses;
   }

   public void setOptionCaisses(OptionCaisses var1) {
      this.optionCaisses = var1;
   }

   public FormCaissesOperations getFormCaissesOperations() {
      return this.formCaissesOperations;
   }

   public void setFormCaissesOperations(FormCaissesOperations var1) {
      this.formCaissesOperations = var1;
   }

   public FormEquipes getFormEquipes() {
      return this.formEquipes;
   }

   public void setFormEquipes(FormEquipes var1) {
      this.formEquipes = var1;
   }

   public FormBackupDatas getFormBackupDatas() {
      return this.formBackupDatas;
   }

   public void setFormBackupDatas(FormBackupDatas var1) {
      this.formBackupDatas = var1;
   }

   public FormPlanProjets getFormPlanProjets() {
      return this.formPlanProjets;
   }

   public void setFormPlanProjets(FormPlanProjets var1) {
      this.formPlanProjets = var1;
   }

   public FormPlansTresorerie getFormPlansTresorerie() {
      return this.formPlansTresorerie;
   }

   public void setFormPlansTresorerie(FormPlansTresorerie var1) {
      this.formPlansTresorerie = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public FormExercicesEducation getFormExercicesEducation() {
      return this.formExercicesEducation;
   }

   public void setFormExercicesEducation(FormExercicesEducation var1) {
      this.formExercicesEducation = var1;
   }

   public FormChronoEdu getFormChronoEdu() {
      return this.formChronoEdu;
   }

   public void setFormChronoEdu(FormChronoEdu var1) {
      this.formChronoEdu = var1;
   }

   public FormProcessAchats getFormProcessAchats() {
      return this.formProcessAchats;
   }

   public void setFormProcessAchats(FormProcessAchats var1) {
      this.formProcessAchats = var1;
   }

   public FormTiersTechnique getFormTiersTechnique() {
      return this.formTiersTechnique;
   }

   public void setFormTiersTechnique(FormTiersTechnique var1) {
      this.formTiersTechnique = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public String getNomStructureEnCours() {
      return this.nomStructureEnCours;
   }

   public void setNomStructureEnCours(String var1) {
      this.nomStructureEnCours = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public FormNgapMedical getFormNgapMedical() {
      return this.formNgapMedical;
   }

   public void setFormNgapMedical(FormNgapMedical var1) {
      this.formNgapMedical = var1;
   }

   public FormExercicesImmobilier getFormExercicesImmobilier() {
      return this.formExercicesImmobilier;
   }

   public void setFormExercicesImmobilier(FormExercicesImmobilier var1) {
      this.formExercicesImmobilier = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public FormChronoImm getFormChronoImm() {
      return this.formChronoImm;
   }

   public void setFormChronoImm(FormChronoImm var1) {
      this.formChronoImm = var1;
   }

   public FormNaturesBiens getFormNaturesBiens() {
      return this.formNaturesBiens;
   }

   public void setFormNaturesBiens(FormNaturesBiens var1) {
      this.formNaturesBiens = var1;
   }

   public FormNaturesInterim getFormNaturesInterim() {
      return this.formNaturesInterim;
   }

   public void setFormNaturesInterim(FormNaturesInterim var1) {
      this.formNaturesInterim = var1;
   }

   public FormExercicesInterim getFormExercicesInterim() {
      return this.formExercicesInterim;
   }

   public void setFormExercicesInterim(FormExercicesInterim var1) {
      this.formExercicesInterim = var1;
   }

   public FormChronoInt getFormChronoInt() {
      return this.formChronoInt;
   }

   public void setFormChronoInt(FormChronoInt var1) {
      this.formChronoInt = var1;
   }

   public FormBilanSocialConfigClient getFormBilanSocialConfigClient() {
      return this.formBilanSocialConfigClient;
   }

   public void setFormBilanSocialConfigClient(FormBilanSocialConfigClient var1) {
      this.formBilanSocialConfigClient = var1;
   }

   public FormUtilitaires getFormUtilitaires() {
      return this.formUtilitaires;
   }

   public void setFormUtilitaires(FormUtilitaires var1) {
      this.formUtilitaires = var1;
   }

   public FormLocalisationImmobilisation getFormLocalisationImmobilisation() {
      return this.formLocalisationImmobilisation;
   }

   public void setFormLocalisationImmobilisation(FormLocalisationImmobilisation var1) {
      this.formLocalisationImmobilisation = var1;
   }

   public FormBanques getFormBanques() {
      return this.formBanques;
   }

   public void setFormBanques(FormBanques var1) {
      this.formBanques = var1;
   }

   public FormCommissionsMedecins getFormCommissionsMedecins() {
      return this.formCommissionsMedecins;
   }

   public void setFormCommissionsMedecins(FormCommissionsMedecins var1) {
      this.formCommissionsMedecins = var1;
   }

   public OptionVentes getOptionsVentes() {
      return this.optionsVentes;
   }

   public void setOptionsVentes(OptionVentes var1) {
      this.optionsVentes = var1;
   }

   public FormPlanningAvicultureAchats getFormPlanningAvicultureAchats() {
      return this.formPlanningAvicultureAchats;
   }

   public void setFormPlanningAvicultureAchats(FormPlanningAvicultureAchats var1) {
      this.formPlanningAvicultureAchats = var1;
   }

   public FormLocalisationSalarie getFormLocalisationSalarie() {
      return this.formLocalisationSalarie;
   }

   public void setFormLocalisationSalarie(FormLocalisationSalarie var1) {
      this.formLocalisationSalarie = var1;
   }

   public FormElementsInfirmerie getFormElementsInfirmerie() {
      return this.formElementsInfirmerie;
   }

   public void setFormElementsInfirmerie(FormElementsInfirmerie var1) {
      this.formElementsInfirmerie = var1;
   }

   public FormCategorieExamen getFormCategorieExamen() {
      return this.formCategorieExamen;
   }

   public void setFormCategorieExamen(FormCategorieExamen var1) {
      this.formCategorieExamen = var1;
   }

   public FormChronoMef getFormChronoMef() {
      return this.formChronoMef;
   }

   public void setFormChronoMef(FormChronoMef var1) {
      this.formChronoMef = var1;
   }

   public FormExercicesMicrofinance getFormExercicesMicrofinance() {
      return this.formExercicesMicrofinance;
   }

   public void setFormExercicesMicrofinance(FormExercicesMicrofinance var1) {
      this.formExercicesMicrofinance = var1;
   }

   public FormFilieres getFormFilieres() {
      return this.formFilieres;
   }

   public void setFormFilieres(FormFilieres var1) {
      this.formFilieres = var1;
   }

   public FormNaturesCourrier getFormNaturesCourrier() {
      return this.formNaturesCourrier;
   }

   public void setFormNaturesCourrier(FormNaturesCourrier var1) {
      this.formNaturesCourrier = var1;
   }

   public FormClassementMediatheque getFormClassementMediatheque() {
      return this.formClassementMediatheque;
   }

   public void setFormClassementMediatheque(FormClassementMediatheque var1) {
      this.formClassementMediatheque = var1;
   }

   public FormCentresSecuriteSociale getFormCentresSecuriteSociale() {
      return this.formCentresSecuriteSociale;
   }

   public void setFormCentresSecuriteSociale(FormCentresSecuriteSociale var1) {
      this.formCentresSecuriteSociale = var1;
   }

   public FormNaturesAffaires getFormNaturesAffaires() {
      return this.formNaturesAffaires;
   }

   public void setFormNaturesAffaires(FormNaturesAffaires var1) {
      this.formNaturesAffaires = var1;
   }

   public FormNaturesPrets getFormNaturesPrets() {
      return this.formNaturesPrets;
   }

   public void setFormNaturesPrets(FormNaturesPrets var1) {
      this.formNaturesPrets = var1;
   }

   public FormExercicesFondation getFormExercicesFondation() {
      return this.formExercicesFondation;
   }

   public void setFormExercicesFondation(FormExercicesFondation var1) {
      this.formExercicesFondation = var1;
   }

   public FormChronoFdt getFormChronoFdt() {
      return this.formChronoFdt;
   }

   public void setFormChronoFdt(FormChronoFdt var1) {
      this.formChronoFdt = var1;
   }

   public FormNaturesDemande getFormNaturesDemande() {
      return this.formNaturesDemande;
   }

   public void setFormNaturesDemande(FormNaturesDemande var1) {
      this.formNaturesDemande = var1;
   }

   public List getLesStructuresPeg() {
      return this.lesStructuresPeg;
   }

   public void setLesStructuresPeg(List var1) {
      this.lesStructuresPeg = var1;
   }

   public FormNaturesRH getFormNaturesRH() {
      return this.formNaturesRH;
   }

   public void setFormNaturesRH(FormNaturesRH var1) {
      this.formNaturesRH = var1;
   }

   public FormTransitLieuVentes getFormTransitLieuVentes() {
      return this.formTransitLieuVentes;
   }

   public void setFormTransitLieuVentes(FormTransitLieuVentes var1) {
      this.formTransitLieuVentes = var1;
   }

   public FormTransitPortVentes getFormTransitPortVentes() {
      return this.formTransitPortVentes;
   }

   public void setFormTransitPortVentes(FormTransitPortVentes var1) {
      this.formTransitPortVentes = var1;
   }

   public FormNaturesMissions getFormNaturesMissions() {
      return this.formNaturesMissions;
   }

   public void setFormNaturesMissions(FormNaturesMissions var1) {
      this.formNaturesMissions = var1;
   }

   public FormNaturesManifest getFormNaturesManifest() {
      return this.formNaturesManifest;
   }

   public void setFormNaturesManifest(FormNaturesManifest var1) {
      this.formNaturesManifest = var1;
   }

   public FormCodesEmplois getFormCodesEmplois() {
      return this.formCodesEmplois;
   }

   public void setFormCodesEmplois(FormCodesEmplois var1) {
      this.formCodesEmplois = var1;
   }

   public FormElementRdv getFormElementRdv() {
      return this.formElementRdv;
   }

   public void setFormElementRdv(FormElementRdv var1) {
      this.formElementRdv = var1;
   }

   public FormChronoForet getFormChronoForet() {
      return this.formChronoForet;
   }

   public void setFormChronoForet(FormChronoForet var1) {
      this.formChronoForet = var1;
   }

   public FormEssenceForet getFormEssenceForet() {
      return this.formEssenceForet;
   }

   public void setFormEssenceForet(FormEssenceForet var1) {
      this.formEssenceForet = var1;
   }

   public FormClassementForet getFormClassementForet() {
      return this.formClassementForet;
   }

   public void setFormClassementForet(FormClassementForet var1) {
      this.formClassementForet = var1;
   }

   public FormChantiersForet getFormChantiersForet() {
      return this.formChantiersForet;
   }

   public void setFormChantiersForet(FormChantiersForet var1) {
      this.formChantiersForet = var1;
   }

   public FormExercicesForet getFormExercicesForet() {
      return this.formExercicesForet;
   }

   public void setFormExercicesForet(FormExercicesForet var1) {
      this.formExercicesForet = var1;
   }

   public FormModelesDevisVentes getFormModelesDevisVentes() {
      return this.formModelesDevisVentes;
   }

   public void setFormModelesDevisVentes(FormModelesDevisVentes var1) {
      this.formModelesDevisVentes = var1;
   }

   public FormNaturesRdv getFormNaturesRdv() {
      return this.formNaturesRdv;
   }

   public void setFormNaturesRdv(FormNaturesRdv var1) {
      this.formNaturesRdv = var1;
   }

   public FormModelesEcritures getFormModelesEcritures() {
      return this.formModelesEcritures;
   }

   public void setFormModelesEcritures(FormModelesEcritures var1) {
      this.formModelesEcritures = var1;
   }

   public FormConfigImprDocument getFormConfigImprDocument() {
      return this.formConfigImprDocument;
   }

   public void setFormConfigImprDocument(FormConfigImprDocument var1) {
      this.formConfigImprDocument = var1;
   }
}
