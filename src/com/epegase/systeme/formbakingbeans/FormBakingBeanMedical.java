package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.administration.FormExercicesMedical;
import com.epegase.forms.commun.FormDocumentsOfficiels;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.medical.FormBonEncaissementMedical;
import com.epegase.forms.medical.FormCommissionsMedicales;
import com.epegase.forms.medical.FormConsultationGene;
import com.epegase.forms.medical.FormDevisMedical;
import com.epegase.forms.medical.FormHospitalisation;
import com.epegase.forms.medical.FormImpressionMedicales;
import com.epegase.forms.medical.FormLaboratoire;
import com.epegase.forms.medical.FormNoteDebitMedical;
import com.epegase.forms.medical.FormPharmacie;
import com.epegase.forms.medical.FormProduitsMedical;
import com.epegase.forms.medical.FormRefacturation;
import com.epegase.forms.medical.FormTransfertMedical;
import com.epegase.forms.office.FormPlanning;
import com.epegase.forms.tiers.FormPatients;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ConsultationActes;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.ConsultationReglement;
import com.epegase.systeme.classe.DevisEnteteMedical;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.LaboratoireEntete;
import com.epegase.systeme.classe.LaboratoireLigne;
import com.epegase.systeme.classe.LaboratoireReglement;
import com.epegase.systeme.classe.MotifEntreeMedical;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.PharmacieLigne;
import com.epegase.systeme.classe.PharmacieReglement;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.classe.UsersFavoris;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.FileCtrl;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ConsultationActesDao;
import com.epegase.systeme.dao.ConsultationEnteteGeneDao;
import com.epegase.systeme.dao.ConsultationReglementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DevisEnteteMedicalDao;
import com.epegase.systeme.dao.DevisLigneMedicalDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.ElevesDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.HospitalisationEnteteDao;
import com.epegase.systeme.dao.LaboratoireEnteteDao;
import com.epegase.systeme.dao.LaboratoireLigneDao;
import com.epegase.systeme.dao.LaboratoireReglementDao;
import com.epegase.systeme.dao.LettreMedicalDao;
import com.epegase.systeme.dao.MarquesDao;
import com.epegase.systeme.dao.MotifEntreeMedicalDao;
import com.epegase.systeme.dao.PathologieMedicalDao;
import com.epegase.systeme.dao.PharmacieEnteteDao;
import com.epegase.systeme.dao.PharmacieLigneDao;
import com.epegase.systeme.dao.PharmacieReglementDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.ProtocoleMedicalDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.SpecialitesMedicalDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UniteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.dao.UsersFavorisDao;
import com.epegase.systeme.menu.MenudroitMedicalCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureAntecedentCDA;
import com.epegase.systeme.xml.LectureCategorieTiers;
import com.epegase.systeme.xml.LectureConfigListeEntete;
import com.epegase.systeme.xml.LectureConfigListeLigne;
import com.epegase.systeme.xml.LectureFamillesClients;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LectureNatureMedical;
import com.epegase.systeme.xml.LectureReglementClient;
import com.epegase.systeme.xml.LireLesoptionsMedical;
import com.epegase.systeme.xml.LireLesoptionsTiers;
import com.epegase.systeme.xml.ObjetCategories;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionConfigListe;
import com.epegase.systeme.xml.OptionMedical;
import com.epegase.systeme.xml.OptionTiers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
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
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import org.xml.sax.SAXException;

public class FormBakingBeanMedical implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private FormRecherche formRecherche;
   private FormPatients formPatients;
   private MenudroitMedicalCtrl menudroitMedicalCtrl;
   private ObjetLigneMenu menumedical;
   private ObjetLigneMenu menumedicalMemo = new ObjetLigneMenu();
   private LectureModulesOnglets lesOnglets;
   private int nature;
   private OptionMedical optionMedical;
   private OptionTiers optionTiers;
   private Habilitation habilitation;
   private ExercicesVentes exoselectionne = new ExercicesVentes();
   private ExercicesVentes lastExoMedical = new ExercicesVentes();
   private ExercicesComptable lastExoCompta;
   private ExercicesAchats lastExoAchats;
   private long leIdExo;
   private int var_timbre;
   private boolean var_marque_util = false;
   private List mesEtatsItems = new ArrayList();
   private List mesPeriodesItems = new ArrayList();
   private EtatDocument etatDocument = new EtatDocument();
   private boolean var_affiche_service;
   private boolean var_affiche_pathologie;
   private boolean var_affiche_prescipteur;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private Chrono chrono = new Chrono();
   private ChronoDao chronoDao;
   private String messageAlerte;
   private boolean infirmerie;
   private long var_memo_id_master;
   private FormExercicesMedical formExercicesMedical;
   private FormProduitsMedical formProduitsMedical;
   private FormPlanning formPlanning;
   private FormConsultationGene formConsultationGene;
   private FormPharmacie formPharmacie;
   private FormLaboratoire formLaboratoire;
   private FormHospitalisation formHospitalisation;
   private FormImpressionMedicales formImpressionMedicales;
   private FormTransfertMedical formTransfertMedical;
   private FormDevisMedical formDevisMedical;
   private FormRefacturation formRefacturation;
   private FormBonEncaissementMedical formBonEncaissementMedical;
   private FormNoteDebitMedical formNoteDebitMedical;
   private FormCommissionsMedicales formCommissionsMedicales;
   private List mesdevisesItem;
   private List documentImpressionItems;
   private List listeImpressionItems;
   private List listeImpressionMvtsItems;
   private List lesFamilleClientsListe;
   private List mesFamilleClientsItems;
   private List lesModeReglementClientsListe;
   private List mesTypeReglements;
   private List mesSerieUserItem;
   private List mesActivitesItems;
   private List mesServicesItems;
   private List mesLaboratoiresItems;
   private List mesPharmaciesItems;
   private List mesMarquesItems;
   private List mesBudgetsItems;
   private List mesFormulesItems;
   private List mesUnitesItems;
   private List mesConditionnementsItems;
   private List listCaisses;
   private List mesBanquesItems;
   private List mesTaxesItems;
   private List mesNaturesItems;
   private List mesFamillesAchatsItems;
   private List mesFamillesAchatsUtilItems;
   private List mesFamillesVentesItems;
   private List mesFamillesVentesUtilItems;
   private List mesFamillesActesItems;
   private List mesFamillesMedocItems;
   private List mesDepotItems;
   private List mesCompteProduitsItems;
   private List mesCompteStocksItems;
   private List mesCompteVteLocItems;
   private List mesCompteVteZItems;
   private List mesCompteVteHzItems;
   private List mesRegionsItems;
   private List mesSecteursItems;
   private List mesPdvItems;
   private List mesSitesItems;
   private List mesDepartementsItems;
   private List mesServices2Items;
   private List mesCommerciauxItems;
   private List mesMedecinsItems;
   private List mesCreateursItems;
   private List mesLettresItems;
   private List mesMotifEntreeItems;
   private List lesMotifEntree;
   private List mesPathologieItems;
   private List mesProtocoleItems;
   private List mesAntecedentItems;
   private List mesCategoriesItems;
   private List lesCategoriesListe;
   private List mesPrescripteurItems;
   private String listeDepotUser;
   private String var_tarif1;
   private String var_tarif2;
   private String var_tarif3;
   private String var_tarif4;
   private String var_tarif5;
   private String var_tarif6;
   private String var_tarif7;
   private String var_tarif8;
   private String var_tarif9;
   private String var_tarif10;
   private boolean var_aff_tarif1;
   private boolean var_aff_tarif2;
   private boolean var_aff_tarif3;
   private boolean var_aff_tarif4;
   private boolean var_aff_tarif5;
   private boolean var_aff_tarif6;
   private boolean var_aff_tarif7;
   private boolean var_aff_tarif8;
   private boolean var_aff_tarif9;
   private boolean var_aff_tarif10;
   private Patients patientsEnCours;
   private FormDocumentsOfficiels formDocumentsOfficiels;
   private FileCtrl fileCtrl;
   private ArrayList listFiles;
   private UploadItem item;
   private int uploadsAvailable = 1;
   private String numRecup;
   private LectureModeleAutorise lectureModeleAutorise;
   private List lesModelesAutorises;
   private String configListeEntete;
   private String configListeLigne;
   private List lesDocumentsImpayes;
   private transient DataModel dataModelDocument;
   private Date dateDebut;
   private Date dateFin;
   private int inpEtat;
   private double totalEntete;
   private double totalLigne;
   private double reglActe;
   private double reglCaisse;

   public FormBakingBeanMedical() throws IOException, ParseException {
   }

   public void instanceOptionMedical() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererExercices(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      this.leIdExo = this.exoselectionne.getExevteId();
      this.lastExoMedical = var2.recupererLastExo(var1);
      ExercicesComptableDao var3 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.lastExoCompta = var3.recupererLastExo(var1);
      ExercicesAchatsDao var4 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.lastExoAchats = var4.recupererLastExo(var1);
   }

   public void recupererLeIdExo() throws HibernateException, NamingException {
      this.recupererLeIdExo((Session)null);
   }

   public ExercicesVentes recupererLeIdExo(Session var1) throws NamingException {
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      if (this.leIdExo != 0L) {
         this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      } else {
         this.exoselectionne = var2.recupererLastExo(var1);
      }

      this.leIdExo = this.exoselectionne.getExevteId();
      return this.exoselectionne;
   }

   public List getLesExerciceMedical(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      this.formExercicesMedical = new FormExercicesMedical();
      this.formExercicesMedical.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesMedical.setBaseLog(this.baseLog);
      this.formExercicesMedical.setStructureLog(this.structureLog);
      this.formExercicesMedical.setUsersLog(this.usersLog);
      this.formExercicesMedical.InstancesDaoUtilses();
      return this.formExercicesMedical.recupererLesexercices(var1);
   }

   public void menuGaucheMedical(int var1) throws JDOMException, IOException {
      if (this.menudroitMedicalCtrl == null) {
         this.menudroitMedicalCtrl = new MenudroitMedicalCtrl();
         this.menudroitMedicalCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitMedicalCtrl.chargerMenudroitMedicalXml(this.usersLog.getUsrCollaboration(), var1);
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("" + var1, this.usersLog.getUsrCollaboration());
   }

   public void razMemoire() {
      this.formConsultationGene = null;
      this.formHospitalisation = null;
      this.formImpressionMedicales = null;
      this.formLaboratoire = null;
      this.formPharmacie = null;
      this.formPlanning = null;
      this.formProduitsMedical = null;
      this.formTransfertMedical = null;
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

   public void gestionMedical() throws JDOMException, IOException, NamingException, HibernateException, ParseException, SAXException {
      this.menumedical = new ObjetLigneMenu();
      if (this.menudroitMedicalCtrl.getDataModelMenudroitMedicalXmlList().isRowAvailable()) {
         this.menumedical = (ObjetLigneMenu)this.menudroitMedicalCtrl.getDataModelMenudroitMedicalXmlList().getRowData();
         if (this.menumedical.getLibelle_FR() != null && !this.menumedical.getLibelle_FR().isEmpty()) {
            this.menumedicalMemo = this.menumedical;
            this.aiguillageMedical();
         }
      }

   }

   public void gestionMedicalFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, ParseException {
      this.menumedical = var1;
      this.menumedicalMemo = this.menumedical;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         int var2 = Integer.parseInt(this.typeVente + "00");
         this.menuGaucheMedical(var2);
      }

      this.aiguillageMedical();
      if (var1.getPagemenu().equals("CGENE")) {
         this.formConsultationGene.setVar_action(1);
         this.formConsultationGene.setPatients(this.patientsEnCours);
         this.formConsultationGene.setVar_consultation_directe(true);
         this.formConsultationGene.setVar_acc_acte(true);
         this.formConsultationGene.setVar_acc_anamese(true);
         this.formConsultationGene.setVar_acc_antecedent(true);
         this.formConsultationGene.setVar_acc_descriptif(true);
         this.formConsultationGene.setVar_acc_etat(true);
         this.formConsultationGene.setVar_acc_examClinique(true);
         this.formConsultationGene.setVar_acc_examComplementaire(true);
         this.formConsultationGene.setVar_acc_facture(true);
         this.formConsultationGene.setVar_acc_historique(true);
         this.formConsultationGene.setVar_acc_medicament(true);
         this.formConsultationGene.setVar_acc_reglement(true);
         this.formConsultationGene.accesResteintUser();
         this.formConsultationGene.ajoutDocument();
         this.formConsultationGene.verifValideConsultation();
      } else if (var1.getPagemenu().equals("PHARMACIE")) {
         this.formPharmacie.setVar_action(1);
         this.formPharmacie.setPatients(this.patientsEnCours);
         this.formPharmacie.setVar_consultation_directe(true);
         this.formPharmacie.setVar_acc_acte(true);
         this.formPharmacie.setVar_acc_anamese(true);
         this.formPharmacie.setVar_acc_antecedent(true);
         this.formPharmacie.setVar_acc_descriptif(true);
         this.formPharmacie.setVar_acc_etat(true);
         this.formPharmacie.setVar_acc_examClinique(true);
         this.formPharmacie.setVar_acc_examComplementaire(true);
         this.formPharmacie.setVar_acc_facture(true);
         this.formPharmacie.setVar_acc_historique(true);
         this.formPharmacie.setVar_acc_medicament(true);
         this.formPharmacie.setVar_acc_reglement(true);
         this.formPharmacie.accesResteintUser();
         this.formPharmacie.ajoutDocument();
         this.formPharmacie.verifValidePharmacie();
      } else if (var1.getPagemenu().equals("LABORATOIRE")) {
         this.formLaboratoire.setVar_action(1);
         this.formLaboratoire.setPatients(this.patientsEnCours);
         this.formLaboratoire.setVar_consultation_directe(true);
         this.formLaboratoire.setVar_acc_acte(true);
         this.formLaboratoire.setVar_acc_anamese(true);
         this.formLaboratoire.setVar_acc_antecedent(true);
         this.formLaboratoire.setVar_acc_descriptif(true);
         this.formLaboratoire.setVar_acc_etat(true);
         this.formLaboratoire.setVar_acc_examClinique(true);
         this.formLaboratoire.setVar_acc_examComplementaire(true);
         this.formLaboratoire.setVar_acc_facture(true);
         this.formLaboratoire.setVar_acc_historique(true);
         this.formLaboratoire.setVar_acc_medicament(true);
         this.formLaboratoire.setVar_acc_reglement(true);
         this.formLaboratoire.accesResteintUser();
         this.formLaboratoire.ajoutDocument();
         this.formLaboratoire.verifValideLaboratoire();
      } else if (var1.getPagemenu().equals("HOSPITALISATION")) {
         this.formHospitalisation.setVar_action(1);
         this.formHospitalisation.setPatients(this.patientsEnCours);
         this.formHospitalisation.setVar_consultation_directe(true);
         this.formHospitalisation.setVar_acc_sejour(true);
         this.formHospitalisation.setVar_acc_acte(true);
         this.formHospitalisation.setVar_acc_anamese(true);
         this.formHospitalisation.setVar_acc_antecedent(true);
         this.formHospitalisation.setVar_acc_entree(true);
         this.formHospitalisation.setVar_acc_etat(true);
         this.formHospitalisation.setVar_acc_examComplementaire(true);
         this.formHospitalisation.setVar_acc_historique(true);
         this.formHospitalisation.setVar_acc_medicament(true);
         this.formHospitalisation.setVar_acc_prestation(true);
         this.formHospitalisation.setVar_acc_reglement(true);
         this.formHospitalisation.accesResteintUser();
         this.formHospitalisation.ajoutDocument();
      }

   }

   public void aiguillageMedical() throws JDOMException, IOException, NamingException, HibernateException, ParseException, SAXException {
      if (this.lastExoMedical.getExevteId() != this.exoselectionne.getExevteId()) {
         this.menumedical.setAdd(false);
         this.menumedical.setMaj(false);
         this.menumedical.setSup(false);
         this.menumedical.setDup(false);
         this.menumedical.setClo(false);
         this.menumedical.setTrf(false);
         this.menumedical.setImp(true);
      } else {
         this.menumedical.setAdd(this.menumedicalMemo.isAdd());
         this.menumedical.setMaj(this.menumedicalMemo.isMaj());
         this.menumedical.setSup(this.menumedicalMemo.isSup());
         this.menumedical.setDup(this.menumedicalMemo.isDup());
         this.menumedical.setClo(this.menumedicalMemo.isClo());
         this.menumedical.setTrf(this.menumedicalMemo.isTrf());
         this.menumedical.setImp(this.menumedicalMemo.isImp());
      }

      this.razMemoire();
      if (this.menumedical.getCommande().equalsIgnoreCase("81500:00")) {
         this.nature = 700;
         this.affichePage = "/medical/ProduitsInit.jsp";
         this.menuProduitMedical();
      } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:034")) {
         this.nature = 70;
         this.affichePage = "/tiers/tiersPatientInit.jsp";
         this.menuPatient();
      } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:01")) {
         this.nature = 701;
         this.affichePage = "/medical/AcceuilPatient.jsp";
         this.menuAcceuil();
      } else {
         Session var1;
         String var2;
         if (this.menumedical.getCommande().equalsIgnoreCase("81500:02")) {
            this.nature = 71;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/medical/ConsultationGeneInit.jsp";
                  this.menuConsultationGene(var1);
               } else {
                  this.affichePage = "/medical/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/medical/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:03")) {
            this.nature = 72;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/medical/ConsultationSpeInit.jsp";
                  this.menuConsultationGene(var1);
               } else {
                  this.affichePage = "/medical/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/medical/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:04")) {
            this.nature = 73;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/medical/PharmacieInit.jsp";
                  this.menuPharmacie(var1);
               } else {
                  this.affichePage = "/medical/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/medical/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:05")) {
            this.nature = 74;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/medical/LaboratoireInit.jsp";
                  this.menuLaboratoire(var1);
               } else {
                  this.affichePage = "/medical/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/medical/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:06")) {
            this.nature = 741;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, 74, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), 74, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/medical/PaillasseInit.jsp";
                  this.menuPaillasse(var1);
               } else {
                  this.affichePage = "/medical/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/medical/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:07")) {
            this.nature = 76;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/medical/HospitalisationInit.jsp";
                  this.menuHospitalisation(var1);
               } else {
                  this.affichePage = "/medical/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/medical/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:08")) {
            this.nature = 77;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/medical/DevisInit.jsp";
                  this.menuDevis(var1);
               } else {
                  this.affichePage = "/medical/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/medical/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:12")) {
            this.nature = 78;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/medical/CtrlfacturationInit.jsp";
                  this.menuCtrlfacturation(var1);
               } else {
                  this.affichePage = "/medical/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/medical/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:09")) {
            this.nature = 78;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/medical/RefacturationInit.jsp";
                  this.menuRefacturation(var1);
               } else {
                  this.affichePage = "/medical/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/medical/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:13")) {
            this.nature = 182;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/medical/RecapitulatifInit.jsp";
                  this.menuRecapitulatif(var1);
               } else {
                  this.affichePage = "/medical/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/medical/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:11")) {
            this.nature = 181;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/medical/FacturationExterneInit.jsp";
                  this.menuFacturationExterne(var1);
               } else {
                  this.affichePage = "/medical/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/medical/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:10")) {
            this.nature = 79;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/medical/BonEncaissementInit.jsp";
                  this.menuBonEncaissement();
               } else {
                  this.affichePage = "/medical/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/medical/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:90")) {
            this.affichePage = "/medical/ImpressionMedicale.jsp";
            this.menuImpressionMedicale();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:91")) {
            this.nature = 7;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CommissionEnteteMedical");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/medical/CommissionsInit.jsp";
                  this.menuCommissionsMedicales(var1);
               } else {
                  this.affichePage = "/medical/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/medical/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:94")) {
            this.affichePage = "/medical/NettoyageQuotidien.jsp";
            this.menuNettoyageQuotidien();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:95")) {
            this.affichePage = "/medical/LiaisonPayeMedicale.jsp";
            this.menuLiaisonPaye();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:97")) {
            this.affichePage = "/commun/documentsOfficiels.jsp";
            this.nature = 150;
            this.menuDocuentsOfficiels();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:98")) {
            this.affichePage = "/medical/TransfertMedical.jsp";
            this.menuTransfertMedical();
         } else if (this.menumedical.getCommande().equalsIgnoreCase("81500:99")) {
            this.affichePage = "/medical/SelectionExercicesMedical.jsp";
            this.menuSelectionExercicesMedical();
         }
      }

   }

   public void menuProduitMedical() throws JDOMException, IOException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsMedic");
      this.formProduitsMedical = new FormProduitsMedical();
      this.formProduitsMedical.setutilInitHibernate(this.utilInitHibernate);
      this.formProduitsMedical.setBaseLog(this.baseLog);
      this.formProduitsMedical.setStructureLog(this.structureLog);
      this.formProduitsMedical.setUsersLog(this.usersLog);
      this.formProduitsMedical.instanceDaoUtilises();
      this.formProduitsMedical.setVar_memo_id_master(this.var_memo_id_master);
      this.formProduitsMedical.setExercicesVentes(this.exoselectionne);
      this.formProduitsMedical.setLastexoMed(this.lastExoMedical);
      this.formProduitsMedical.setLastexoCompta(this.lastExoCompta);
      this.formProduitsMedical.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formProduitsMedical.setOptionsMedical(this.optionMedical);
      this.formProduitsMedical.recupererOptions(var1);
      this.formProduitsMedical.accesResteintGroupe();
      this.recupererLesItemsProd(var1);
      this.formProduitsMedical.setLesPecclients(this.lesCategoriesListe);
      this.formProduitsMedical.recupererFamilleProduitVentesItem(var1);
      this.formProduitsMedical.setVar_tarif1(this.var_tarif1);
      this.formProduitsMedical.setVar_tarif2(this.var_tarif2);
      this.formProduitsMedical.setVar_tarif3(this.var_tarif3);
      this.formProduitsMedical.setVar_tarif4(this.var_tarif4);
      this.formProduitsMedical.setVar_tarif5(this.var_tarif5);
      this.utilInitHibernate.closeSession();
   }

   public void menuPatient() throws HibernateException, NamingException {
   }

   public void menuAcceuil() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
      this.formPlanning = new FormPlanning();
      this.formPlanning.setutilInitHibernate(this.utilInitHibernate);
      this.formPlanning.setBaseLog(this.baseLog);
      this.formPlanning.setStructureLog(this.structureLog);
      this.formPlanning.setUsersLog(this.usersLog);
      this.formPlanning.InstancesDaoUtilses();
      this.recupererLesItemsDoc(var1);
      this.formPlanning.setOptionTiers(this.optionTiers);
      this.formPlanning.initRdvPatient(var1);
      if (this.optionMedical.getChargementListe() != null && !this.optionMedical.getChargementListe().isEmpty() && this.optionMedical.getChargementListe().equals("1")) {
         this.formPlanning.chargerLesRdvByJour(this.usersLog);
      }

      this.utilInitHibernate.closeSession();
   }

   public void menuConsultationGene(Session var1) throws JDOMException, IOException, NamingException, HibernateException, ParseException {
      this.formConsultationGene = new FormConsultationGene();
      this.formConsultationGene.setutilInitHibernate(this.utilInitHibernate);
      this.formConsultationGene.setBaseLog(this.baseLog);
      this.formConsultationGene.setStructureLog(this.structureLog);
      this.formConsultationGene.setUsersLog(this.usersLog);
      this.formConsultationGene.instanceDaoUtilises();
      this.formConsultationGene.setNature(this.nature);
      this.formConsultationGene.setExercicesVentes(this.exoselectionne);
      this.formConsultationGene.setLastExoMedical(this.lastExoMedical);
      this.formConsultationGene.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formConsultationGene.setOptionMedical(this.optionMedical);
      this.formConsultationGene.setMesTaxesMedicalItems(this.mesTaxesItems);
      this.formConsultationGene.setVar_timbre(this.var_timbre);
      this.formConsultationGene.setLesCategoriesList(this.lesCategoriesListe);
      this.formConsultationGene.setVar_consultation_directe(false);
      this.formConsultationGene.configMedical();
      this.formConsultationGene.accesResteintUser();
      this.formConsultationGene.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.recupererFamilleProduitVentesItem(var1);
      this.formConsultationGene.setLesMotifEntree(this.lesMotifEntree);
      this.formConsultationGene.setListCaisses(this.listCaisses);
      this.formConsultationGene.setHabilitation(this.habilitation);
      this.formConsultationGene.setUrlExplorateur(this.urlExplorateur);
      this.formConsultationGene.setVar_affiche_pathologie(this.var_affiche_pathologie);
      this.formConsultationGene.setVar_affiche_prescipteur(this.var_affiche_prescipteur);
      this.formConsultationGene.setVar_affiche_service(this.var_affiche_service);
      this.formPatients.verifInfirmerie();
      this.formConsultationGene.setFormPatients(this.formPatients);
      this.formConsultationGene.setVerrouDepotUser(this.listeDepotUser);
      this.formConsultationGene.setFormRecherche(this.formRecherche);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if ((this.menumedical.getPagemenu() == null || this.menumedical.getPagemenu().isEmpty()) && this.optionMedical.getChargementListe() != null && !this.optionMedical.getChargementListe().isEmpty() && this.optionMedical.getChargementListe().equals("1")) {
         if (this.mesSerieUserItem.size() != 0) {
            this.formConsultationGene.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         }

         this.formConsultationGene.chargeListeDetail(var1);
      }

   }

   public void menuPharmacie(Session var1) throws JDOMException, IOException, NamingException, HibernateException, ParseException {
      this.formPharmacie = new FormPharmacie();
      this.formPharmacie.setutilInitHibernate(this.utilInitHibernate);
      this.formPharmacie.setBaseLog(this.baseLog);
      this.formPharmacie.setStructureLog(this.structureLog);
      this.formPharmacie.setUsersLog(this.usersLog);
      this.formPharmacie.instanceDaoUtilises();
      this.formPharmacie.setNature(this.nature);
      this.formPharmacie.setExercicesVentes(this.exoselectionne);
      this.formPharmacie.setLastExoMedical(this.lastExoMedical);
      this.formPharmacie.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formPharmacie.setOptionMedical(this.optionMedical);
      this.formPharmacie.setMesTaxesMedicalItems(this.mesTaxesItems);
      this.formPharmacie.setVar_timbre(this.var_timbre);
      this.formPharmacie.setLesCategoriesList(this.lesCategoriesListe);
      this.formPharmacie.configMedical(var1);
      this.formPharmacie.accesResteintUser();
      this.formPharmacie.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.recupererFamilleProduitVentesItem(var1);
      this.formPharmacie.setListCaisses(this.listCaisses);
      this.formPharmacie.setHabilitation(this.habilitation);
      this.formPharmacie.setMesPharmaciesItems(this.mesPharmaciesItems);
      this.formPharmacie.setVar_affiche_pathologie(this.var_affiche_pathologie);
      this.formPharmacie.setVar_affiche_prescipteur(this.var_affiche_prescipteur);
      this.formPharmacie.setVar_affiche_service(this.var_affiche_service);
      this.formPharmacie.setFormPatients(this.formPatients);
      this.formPharmacie.setVerrouDepotUser(this.listeDepotUser);
      this.formPharmacie.setFormRecherche(this.formRecherche);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionMedical.getChargementListe() != null && !this.optionMedical.getChargementListe().isEmpty() && this.optionMedical.getChargementListe().equals("1")) {
         if (this.mesSerieUserItem.size() != 0) {
            this.formPharmacie.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         }

         this.formPharmacie.chargeListeDetail(var1);
      }

   }

   public void menuLaboratoire(Session var1) throws JDOMException, IOException, NamingException, HibernateException, ParseException {
      this.formLaboratoire = new FormLaboratoire();
      this.formLaboratoire.setutilInitHibernate(this.utilInitHibernate);
      this.formLaboratoire.setBaseLog(this.baseLog);
      this.formLaboratoire.setStructureLog(this.structureLog);
      this.formLaboratoire.setUsersLog(this.usersLog);
      this.formLaboratoire.instanceDaoUtilises();
      this.formLaboratoire.setNature(this.nature);
      this.formLaboratoire.setExercicesVentes(this.exoselectionne);
      this.formLaboratoire.setLastExoMedical(this.lastExoMedical);
      this.formLaboratoire.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formLaboratoire.setOptionMedical(this.optionMedical);
      this.formLaboratoire.setMesTaxesMedicalItems(this.mesTaxesItems);
      this.formLaboratoire.setVar_timbre(this.var_timbre);
      this.formLaboratoire.setLesCategoriesList(this.lesCategoriesListe);
      this.formLaboratoire.configMedical();
      this.formLaboratoire.accesResteintUser();
      this.formLaboratoire.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.recupererFamilleProduitVentesItem(var1);
      this.recupererLesMedecinsItem(var1);
      this.formLaboratoire.setLesMotifEntree(this.lesMotifEntree);
      this.formLaboratoire.setListCaisses(this.listCaisses);
      this.formLaboratoire.setHabilitation(this.habilitation);
      this.formLaboratoire.setUrlExplorateur(this.urlExplorateur);
      this.formLaboratoire.setVar_affiche_pathologie(this.var_affiche_pathologie);
      this.formLaboratoire.setVar_affiche_prescipteur(true);
      this.formLaboratoire.setVar_affiche_service(this.var_affiche_service);
      this.formLaboratoire.setFormPatients(this.formPatients);
      this.formLaboratoire.setVerrouDepotUser(this.listeDepotUser);
      this.formLaboratoire.setFormRecherche(this.formRecherche);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionMedical.getChargementListe() != null && !this.optionMedical.getChargementListe().isEmpty() && this.optionMedical.getChargementListe().equals("1")) {
         if (this.mesSerieUserItem.size() != 0) {
            this.formLaboratoire.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         }

         this.formLaboratoire.chargeListeDetail(var1);
      }

   }

   public void menuPaillasse(Session var1) throws JDOMException, IOException, NamingException, HibernateException, ParseException {
      this.formLaboratoire = new FormLaboratoire();
      this.formLaboratoire.setutilInitHibernate(this.utilInitHibernate);
      this.formLaboratoire.setBaseLog(this.baseLog);
      this.formLaboratoire.setStructureLog(this.structureLog);
      this.formLaboratoire.setUsersLog(this.usersLog);
      this.formLaboratoire.instanceDaoUtilises();
      this.formLaboratoire.setNature(this.nature);
      this.formLaboratoire.setExercicesVentes(this.exoselectionne);
      this.formLaboratoire.setLastExoMedical(this.lastExoMedical);
      this.formLaboratoire.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formLaboratoire.setOptionMedical(this.optionMedical);
      this.formLaboratoire.setMesTaxesMedicalItems(this.mesTaxesItems);
      this.formLaboratoire.setVar_timbre(this.var_timbre);
      this.formLaboratoire.setLesCategoriesList(this.lesCategoriesListe);
      this.formLaboratoire.configMedical();
      this.formLaboratoire.accesResteintUser();
      this.formLaboratoire.accesResteintGroupe();
      this.formLaboratoire.initPaillasse(var1);
      this.recupererLesItemsDoc(var1);
      this.recupererFamilleProduitVentesItem(var1);
      this.recupererLesMedecinsItem(var1);
      this.formLaboratoire.setLesMotifEntree(this.lesMotifEntree);
      this.formLaboratoire.setHabilitation(this.habilitation);
      this.formLaboratoire.setUrlExplorateur(this.urlExplorateur);
      this.formLaboratoire.setVar_affiche_pathologie(this.var_affiche_pathologie);
      this.formLaboratoire.setVar_affiche_prescipteur(true);
      this.formLaboratoire.setVar_affiche_service(this.var_affiche_service);
      this.formLaboratoire.setFormPatients(this.formPatients);
      this.formLaboratoire.setVerrouDepotUser(this.listeDepotUser);
      this.formLaboratoire.setFormRecherche(this.formRecherche);
      this.formLaboratoire.setInpEtat(11);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuHospitalisation(Session var1) throws JDOMException, IOException, NamingException, HibernateException, ParseException {
      this.formHospitalisation = new FormHospitalisation();
      this.formHospitalisation.setutilInitHibernate(this.utilInitHibernate);
      this.formHospitalisation.setBaseLog(this.baseLog);
      this.formHospitalisation.setStructureLog(this.structureLog);
      this.formHospitalisation.setUsersLog(this.usersLog);
      this.formHospitalisation.instanceDaoUtilises();
      this.formHospitalisation.setNature(this.nature);
      this.formHospitalisation.setExercicesVentes(this.exoselectionne);
      this.formHospitalisation.setLastExoMedical(this.lastExoMedical);
      this.formHospitalisation.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formHospitalisation.setOptionMedical(this.optionMedical);
      this.formHospitalisation.setMesTaxesMedicalItems(this.mesTaxesItems);
      this.formHospitalisation.setVar_timbre(this.var_timbre);
      this.formHospitalisation.setLesCategoriesList(this.lesCategoriesListe);
      this.formHospitalisation.configMedical();
      this.formHospitalisation.accesResteintUser();
      this.formHospitalisation.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.recupererFamilleProduitVentesItem(var1);
      this.formHospitalisation.setListCaisses(this.listCaisses);
      this.formHospitalisation.setHabilitation(this.habilitation);
      this.formHospitalisation.setUrlExplorateur(this.urlExplorateur);
      this.formHospitalisation.recupererHospitItem(var1);
      this.formHospitalisation.setVar_affiche_pathologie(this.var_affiche_pathologie);
      this.formHospitalisation.setVar_affiche_prescipteur(this.var_affiche_prescipteur);
      this.formHospitalisation.setVar_affiche_service(this.var_affiche_service);
      this.formHospitalisation.setFormPatients(this.formPatients);
      this.formHospitalisation.setVerrouDepotUser(this.listeDepotUser);
      this.formHospitalisation.setFormRecherche(this.formRecherche);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionMedical.getChargementListe() != null && !this.optionMedical.getChargementListe().isEmpty() && this.optionMedical.getChargementListe().equals("1")) {
         if (this.mesSerieUserItem.size() != 0) {
            this.formHospitalisation.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         }

         this.formHospitalisation.chargeListeDetail(var1);
      }

   }

   public void menuBonEncaissement() throws JDOMException, IOException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
      this.formBonEncaissementMedical = new FormBonEncaissementMedical();
      this.formBonEncaissementMedical.setutilInitHibernate(this.utilInitHibernate);
      this.formBonEncaissementMedical.setBaseLog(this.baseLog);
      this.formBonEncaissementMedical.setStructureLog(this.structureLog);
      this.formBonEncaissementMedical.setUsersLog(this.usersLog);
      this.formBonEncaissementMedical.InstancesDaoUtilses();
      this.formBonEncaissementMedical.setExercicesVentes(this.exoselectionne);
      this.formBonEncaissementMedical.setOptionMedical(this.optionMedical);
      this.formBonEncaissementMedical.setNature(this.nature);
      this.formBonEncaissementMedical.setUsersChrono(this.usersChrono);
      this.formBonEncaissementMedical.chargerFind(var1);
      this.recupererLesItemsDoc(var1);
      this.utilInitHibernate.closeSession();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuDevis(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formDevisMedical = new FormDevisMedical();
      this.formDevisMedical.setutilInitHibernate(this.utilInitHibernate);
      this.formDevisMedical.setBaseLog(this.baseLog);
      this.formDevisMedical.setStructureLog(this.structureLog);
      this.formDevisMedical.setUsersLog(this.usersLog);
      this.formDevisMedical.instanceDaoUtilises();
      this.formDevisMedical.setNature(this.nature);
      this.formDevisMedical.setExercicesVentes(this.exoselectionne);
      this.formDevisMedical.setLastExoMedical(this.lastExoMedical);
      this.formDevisMedical.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formDevisMedical.setOptionMedical(this.optionMedical);
      this.formDevisMedical.setMesTaxesMedicalItems(this.mesTaxesItems);
      this.formDevisMedical.setVar_timbre(this.var_timbre);
      this.formDevisMedical.setLesCategoriesList(this.lesCategoriesListe);
      this.formDevisMedical.configMedical();
      this.formDevisMedical.accesResteintUser();
      this.formDevisMedical.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.recupererFamilleProduitVentesItem(var1);
      this.formDevisMedical.setHabilitation(this.habilitation);
      this.formDevisMedical.setVar_affiche_pathologie(this.var_affiche_pathologie);
      this.formDevisMedical.setVar_affiche_prescipteur(this.var_affiche_prescipteur);
      this.formDevisMedical.setVar_affiche_service(this.var_affiche_service);
      this.formDevisMedical.setFormPatients(this.formPatients);
      this.formDevisMedical.setVerrouDepotUser(this.listeDepotUser);
      this.formDevisMedical.setFormRecherche(this.formRecherche);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionMedical.getChargementListe() != null && !this.optionMedical.getChargementListe().isEmpty() && this.optionMedical.getChargementListe().equals("1")) {
         if (this.mesSerieUserItem.size() != 0) {
            this.formDevisMedical.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         }

         this.formDevisMedical.chargeListeDetail(var1);
      }

   }

   public void menuCtrlfacturation(Session var1) throws JDOMException, IOException, NamingException, HibernateException, ParseException, SAXException {
      this.formRefacturation = new FormRefacturation();
      this.formRefacturation.setutilInitHibernate(this.utilInitHibernate);
      this.formRefacturation.setBaseLog(this.baseLog);
      this.formRefacturation.setStructureLog(this.structureLog);
      this.formRefacturation.setUsersLog(this.usersLog);
      this.formRefacturation.InstancesDaoUtilses();
      this.formRefacturation.setNature(this.nature);
      this.formRefacturation.setExercicesVentes(this.exoselectionne);
      this.formRefacturation.setLastExoVentes(this.lastExoMedical);
      this.formRefacturation.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formRefacturation.setOptionMedical(this.optionMedical);
      this.formRefacturation.setVar_timbre(this.var_timbre);
      this.formRefacturation.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formRefacturation.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formRefacturation.configVentes();
      this.formRefacturation.accesResteintUser();
      this.formRefacturation.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formRefacturation.setHabilitation(this.habilitation);
      this.formRefacturation.setFormRecherche(this.formRecherche);
      this.formRefacturation.setMesSerieUserItem(this.mesSerieUserItem);
      this.formRefacturation.setListCaisses(this.listCaisses);
      this.formRefacturation.listeTiersPayeur();
      this.formRefacturation.setTypeVente(this.typeVente);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuRefacturation(Session var1) throws JDOMException, IOException, NamingException, HibernateException, ParseException, SAXException {
      this.formRefacturation = new FormRefacturation();
      this.formRefacturation.setutilInitHibernate(this.utilInitHibernate);
      this.formRefacturation.setBaseLog(this.baseLog);
      this.formRefacturation.setStructureLog(this.structureLog);
      this.formRefacturation.setUsersLog(this.usersLog);
      this.formRefacturation.InstancesDaoUtilses();
      this.formRefacturation.setNature(this.nature);
      this.formRefacturation.setExercicesVentes(this.exoselectionne);
      this.formRefacturation.setLastExoVentes(this.lastExoMedical);
      this.formRefacturation.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formRefacturation.setOptionMedical(this.optionMedical);
      this.formRefacturation.setVar_timbre(this.var_timbre);
      this.formRefacturation.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formRefacturation.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formRefacturation.configVentes();
      this.formRefacturation.accesResteintUser();
      this.formRefacturation.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formRefacturation.setHabilitation(this.habilitation);
      this.formRefacturation.setFormRecherche(this.formRecherche);
      this.formRefacturation.setMesSerieUserItem(this.mesSerieUserItem);
      this.formRefacturation.setListCaisses(this.listCaisses);
      this.formRefacturation.setTypeVente(this.typeVente);
      this.formRefacturation.setFondsCnamgs(99);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionMedical.getChargementListe() != null && !this.optionMedical.getChargementListe().isEmpty() && this.optionMedical.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formRefacturation.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formRefacturation.chargeListeDetail(var1);
      }

   }

   public void menuRecapitulatif(Session var1) throws JDOMException, IOException, NamingException, HibernateException, ParseException, SAXException {
      this.formRefacturation = new FormRefacturation();
      this.formRefacturation.setutilInitHibernate(this.utilInitHibernate);
      this.formRefacturation.setBaseLog(this.baseLog);
      this.formRefacturation.setStructureLog(this.structureLog);
      this.formRefacturation.setUsersLog(this.usersLog);
      this.formRefacturation.InstancesDaoUtilses();
      this.formRefacturation.setNature(this.nature);
      this.formRefacturation.setExercicesVentes(this.exoselectionne);
      this.formRefacturation.setLastExoVentes(this.lastExoMedical);
      this.formRefacturation.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formRefacturation.setOptionMedical(this.optionMedical);
      this.formRefacturation.setVar_timbre(this.var_timbre);
      this.formRefacturation.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formRefacturation.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formRefacturation.configVentes();
      this.formRefacturation.accesResteintUser();
      this.formRefacturation.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formRefacturation.setHabilitation(this.habilitation);
      this.formRefacturation.setFormRecherche(this.formRecherche);
      this.formRefacturation.setMesSerieUserItem(this.mesSerieUserItem);
      this.formRefacturation.setListCaisses(this.listCaisses);
      this.formRefacturation.setTypeVente(this.typeVente);
      this.formRefacturation.setFondsCnamgs(99);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionMedical.getChargementListe() != null && !this.optionMedical.getChargementListe().isEmpty() && this.optionMedical.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formRefacturation.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formRefacturation.chargeListeRecapitulatif(var1);
      }

   }

   public void menuFacturationExterne(Session var1) throws JDOMException, IOException, NamingException, HibernateException, ParseException, SAXException {
      this.formNoteDebitMedical = new FormNoteDebitMedical();
      this.formNoteDebitMedical.setutilInitHibernate(this.utilInitHibernate);
      this.formNoteDebitMedical.setBaseLog(this.baseLog);
      this.formNoteDebitMedical.setStructureLog(this.structureLog);
      this.formNoteDebitMedical.setUsersLog(this.usersLog);
      this.formNoteDebitMedical.InstancesDaoUtilses();
      this.formNoteDebitMedical.setNature(this.nature);
      this.formNoteDebitMedical.setExercicesVentes(this.exoselectionne);
      this.formNoteDebitMedical.setLastExoVentes(this.lastExoMedical);
      this.formNoteDebitMedical.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formNoteDebitMedical.setOptionMedical(this.optionMedical);
      this.formNoteDebitMedical.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formNoteDebitMedical.setMesUnitesItems(this.mesUnitesItems);
      this.formNoteDebitMedical.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formNoteDebitMedical.setVar_timbre(this.var_timbre);
      this.formNoteDebitMedical.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formNoteDebitMedical.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formNoteDebitMedical.configVentes();
      this.formNoteDebitMedical.accesResteintUser();
      this.formNoteDebitMedical.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formNoteDebitMedical.setHabilitation(this.habilitation);
      this.formNoteDebitMedical.setFormRecherche(this.formRecherche);
      this.formNoteDebitMedical.setMesSerieUserItem(this.mesSerieUserItem);
      this.formNoteDebitMedical.setListCaisses(this.listCaisses);
      this.formNoteDebitMedical.setTypeVente(this.typeVente);
      this.formNoteDebitMedical.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionMedical.getChargementListe() != null && !this.optionMedical.getChargementListe().isEmpty() && this.optionMedical.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formNoteDebitMedical.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formNoteDebitMedical.executerRequete(var1);
      }

   }

   public void menuImpressionMedicale() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
      this.formImpressionMedicales = new FormImpressionMedicales();
      this.formImpressionMedicales.setutilInitHibernate(this.utilInitHibernate);
      this.formImpressionMedicales.setBaseLog(this.baseLog);
      this.formImpressionMedicales.setStructureLog(this.structureLog);
      this.formImpressionMedicales.setUsersLog(this.usersLog);
      this.formImpressionMedicales.InstancesDaoUtilses();
      this.formImpressionMedicales.setExoSelectionne(this.exoselectionne);
      this.formImpressionMedicales.setOptionMedical(this.optionMedical);
      this.formImpressionMedicales.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionMedicales.chargerLesRepImpMedical(var1);
      this.recupererLesItemsImpression(var1);
      this.recupererFamilleProduitVentesItem(var1);
      this.formImpressionMedicales.setMesServicesItems(this.mesServices2Items);
      this.formImpressionMedicales.setMesMedecinsItems(this.mesCommerciauxItems);
      this.formImpressionMedicales.initImpression();
      this.formImpressionMedicales.chargerPeriodes();
      this.utilInitHibernate.closeSession();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuCommissionsMedicales(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException {
      this.formCommissionsMedicales = new FormCommissionsMedicales();
      this.formCommissionsMedicales.setUtilInitHibernate(this.utilInitHibernate);
      this.formCommissionsMedicales.setBaseLog(this.baseLog);
      this.formCommissionsMedicales.setStructureLog(this.structureLog);
      this.formCommissionsMedicales.setUsersLog(this.usersLog);
      this.formCommissionsMedicales.InstancesDaoUtilses();
      this.formCommissionsMedicales.setNature(this.nature);
      this.formCommissionsMedicales.setExercicesVentes(this.exoselectionne);
      this.formCommissionsMedicales.setLastExoVentes(this.lastExoMedical);
      this.formCommissionsMedicales.setOptionMedical(this.optionMedical);
      this.formCommissionsMedicales.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formCommissionsMedicales.configVentes(var1);
      this.formCommissionsMedicales.accesResteintUser(var1);
      this.formCommissionsMedicales.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formCommissionsMedicales.setHabilitation(this.habilitation);
      this.formCommissionsMedicales.setFormRecherche(this.formRecherche);
      this.recupererLesMedecinsItem(var1);
      this.formCommissionsMedicales.setMesResponsablesItems(this.mesCreateursItems);
      this.formCommissionsMedicales.setMesMedecinItems(this.mesCommerciauxItems);
      this.formCommissionsMedicales.setListCaisses(this.listCaisses);
      this.infirmerie = this.rechercheModule(81500);
      this.formCommissionsMedicales.setInfirmerie(this.infirmerie);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuDocuentsOfficiels() throws IOException, HibernateException, NamingException {
      this.formDocumentsOfficiels.ouvrirDocument();
   }

   public void menuTransfertMedical() throws IOException, JDOMException {
      this.formTransfertMedical = new FormTransfertMedical();
      this.formTransfertMedical.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertMedical.setBaseLog(this.baseLog);
      this.formTransfertMedical.setStructureLog(this.structureLog);
      this.formTransfertMedical.setUsersLog(this.usersLog);
      this.formTransfertMedical.InstancesDaoUtilses();
      this.formTransfertMedical.setExercicesVentes(this.exoselectionne);
      this.formTransfertMedical.setOptionMedical(this.optionMedical);
      this.formTransfertMedical.init();
   }

   public void menuLiaisonPaye() {
      this.formTransfertMedical = new FormTransfertMedical();
      this.formTransfertMedical.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertMedical.setBaseLog(this.baseLog);
      this.formTransfertMedical.setStructureLog(this.structureLog);
      this.formTransfertMedical.setUsersLog(this.usersLog);
      this.formTransfertMedical.InstancesDaoUtilses();
      this.formTransfertMedical.setExercicesVentes(this.exoselectionne);
      this.formTransfertMedical.setOptionMedical(this.optionMedical);
      this.formTransfertMedical.liaisonPaye();
      this.listFiles = new ArrayList();
      this.uploadsAvailable = 1;
   }

   public void menuSelectionExercicesMedical() throws IOException, JDOMException, NamingException {
      this.formExercicesMedical = new FormExercicesMedical();
      this.formExercicesMedical.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesMedical.setBaseLog(this.baseLog);
      this.formExercicesMedical.setStructureLog(this.structureLog);
      this.formExercicesMedical.setUsersLog(this.usersLog);
      this.formExercicesMedical.InstancesDaoUtilses();
      this.leIdExo = this.exoselectionne.getExevteId();
      this.formExercicesMedical.setLesexercicesVentes(this.formExercicesMedical.recupererLesexercices((Session)null));
   }

   public void menuNettoyageQuotidien() throws HibernateException, NamingException {
      this.lesDocumentsImpayes = new ArrayList();
      this.dataModelDocument = new ListDataModel();
      this.dateDebut = new Date();
      this.dateFin = this.dateDebut;
      this.inpEtat = 100;
      this.dataModelDocument.setWrappedData(this.lesDocumentsImpayes);
      this.chargerNettoyage();
   }

   public void chargerNettoyage() throws HibernateException, NamingException {
      this.lesDocumentsImpayes.clear();
      UtilDate var1 = new UtilDate();
      String var2 = var1.dateToStringSQLLight(this.dateDebut) + " 00:00:00";
      String var3 = var1.dateToStringSQLLight(this.dateFin) + " 23:23:59";
      this.totalEntete = 0.0D;
      this.totalLigne = 0.0D;
      this.reglActe = 0.0D;
      this.reglCaisse = 0.0D;
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
      if (this.inpEtat == 10) {
         this.procedureControleFacture(var2, var3, var4);
      } else if (this.inpEtat == 11) {
         this.procedureControleRecu(var2, var3, var4);
      } else {
         this.procedureNettoyage(var2, var3, var4);
      }

      this.utilInitHibernate.closeSession();
      this.dataModelDocument.setWrappedData(this.lesDocumentsImpayes);
   }

   public void procedureControleFacture(String var1, String var2, Session var3) throws HibernateException, NamingException {
      String var4 = "";
      new ArrayList();
      ReglementsDao var6 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      ConsultationActesDao var8 = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      ConsultationReglementDao var10 = new ConsultationReglementDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      ConsultationEnteteGeneDao var12 = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      var4 = "csgDate >='" + var1 + "' and csgDate<='" + var2 + "'";
      List var11 = var12.chargerConsultationByRequete(var4, var3);
      List var5;
      if (var11.size() != 0) {
         new ConsultationEnteteGene();
         new DocumentEntete();

         for(int var15 = 0; var15 < var11.size(); ++var15) {
            ConsultationEnteteGene var13 = (ConsultationEnteteGene)var11.get(var15);
            DocumentEntete var14 = new DocumentEntete();
            var14.setDocNature(71);
            var14.setVar_lib_nat("Consultation");
            var14.setDocEtat(var13.getCsgEtat());
            if (var13.getCsgEtat() == 0) {
               var14.setDocLibelleEtat("E.C.");
            } else if (var13.getCsgEtat() == 1) {
               var14.setDocLibelleEtat("Val.");
            } else if (var13.getCsgEtat() == 2) {
               var14.setDocLibelleEtat("Gel.");
            } else if (var13.getCsgEtat() == 3) {
               var14.setDocLibelleEtat("Ann.");
            }

            var14.setDocId(var13.getCsgId());
            var14.setDocDate(var13.getCsgDate());
            var14.setDocNum(var13.getCsgNum());
            var14.setDocNomTiers(var13.getCsgNomPatient());
            var14.setDocBudget(var13.getPatients().getPatDossier());
            var14.setDocService(var13.getCsgService());
            var14.setDocTotTtc(var13.getCsgTotPatient());
            double var16 = 0.0D;
            List var7 = var8.selectConsActesByConsEnt(var13, var3);

            for(int var18 = 0; var18 < var7.size(); ++var18) {
               var16 += ((ConsultationActes)var7.get(var18)).getCslactPatientHt();
            }

            var14.setDocTotTc(var16);
            double var39 = 0.0D;
            List var9 = var10.selectReglementByEnt(var13, var3);

            for(int var20 = 0; var20 < var9.size(); ++var20) {
               var39 += ((ConsultationReglement)var9.get(var20)).getCsgregPatient();
            }

            var14.setDocTotTva(var39);
            double var42 = 0.0D;
            var5 = var6.reglementDocument(var13.getCsgId(), 71, var3);

            for(int var22 = 0; var22 < var5.size(); ++var22) {
               var42 += ((Reglements)var5.get(var22)).getRglRecette();
            }

            var14.setDocTotReglement(var42);
            if (var14.getDocTotTtc() == var14.getDocTotTc() && var14.getDocTotTva() == var14.getDocTotReglement()) {
               var14.setDocSelect(false);
            } else {
               var14.setDocSelect(true);
            }

            this.lesDocumentsImpayes.add(var14);
         }
      }

      new ArrayList();
      PharmacieLigneDao var36 = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      PharmacieReglementDao var38 = new PharmacieReglementDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      PharmacieEnteteDao var40 = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
      var4 = "phaDate >='" + var1 + "' and phaDate<='" + var2 + "'";
      List var17 = var40.chargerPharmacieByRequete(var4, var3);
      if (var17.size() != 0) {
         new PharmacieEntete();
         new DocumentEntete();

         for(int var21 = 0; var21 < var17.size(); ++var21) {
            PharmacieEntete var19 = (PharmacieEntete)var17.get(var21);
            DocumentEntete var43 = new DocumentEntete();
            var43.setDocNature(73);
            var43.setVar_lib_nat("Pharmacie");
            var43.setDocEtat(var19.getPhaEtat());
            if (var19.getPhaEtat() == 0) {
               var43.setDocLibelleEtat("E.C.");
            } else if (var19.getPhaEtat() == 1) {
               var43.setDocLibelleEtat("Val.");
            } else if (var19.getPhaEtat() == 2) {
               var43.setDocLibelleEtat("Gel.");
            } else if (var19.getPhaEtat() == 3) {
               var43.setDocLibelleEtat("Ann.");
            }

            var43.setDocId(var19.getPhaId());
            var43.setDocDate(var19.getPhaDate());
            var43.setDocNum(var19.getPhaNum());
            var43.setDocNomTiers(var19.getPhaNomPatient());
            var43.setDocBudget(var19.getPatients().getPatDossier());
            var43.setDocService(var19.getPhaService());
            var43.setDocTotTtc(var19.getPhaTotPatient());
            double var46 = 0.0D;
            List var35 = var36.selectConsActesByConsEnt(var19, var3);

            for(int var24 = 0; var24 < var35.size(); ++var24) {
               var46 += ((PharmacieLigne)var35.get(var24)).getPhaligPatientHt();
            }

            var43.setDocTotTc(var46);
            double var48 = 0.0D;
            List var37 = var38.selectReglementByEnt(var19, var3);

            for(int var26 = 0; var26 < var37.size(); ++var26) {
               var48 += ((PharmacieReglement)var37.get(var26)).getPharegPatient();
            }

            var43.setDocTotTva(var48);
            double var51 = 0.0D;
            var5 = var6.reglementDocument(var19.getPhaId(), 73, var3);

            for(int var28 = 0; var28 < var5.size(); ++var28) {
               var51 += ((Reglements)var5.get(var28)).getRglRecette();
            }

            var43.setDocTotReglement(var51);
            if (var43.getDocTotTtc() == var43.getDocTotTc() && var43.getDocTotTva() == var43.getDocTotReglement()) {
               var43.setDocSelect(false);
            } else {
               var43.setDocSelect(true);
            }

            this.lesDocumentsImpayes.add(var43);
         }
      }

      new ArrayList();
      LaboratoireLigneDao var44 = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      LaboratoireReglementDao var47 = new LaboratoireReglementDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      LaboratoireEnteteDao var49 = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      var4 = "labDate >='" + var1 + "' and labDate<='" + var2 + "'";
      List var23 = var49.chargerLaboratoireByRequete(var4, var3);
      if (var23.size() != 0) {
         new LaboratoireEntete();
         new DocumentEntete();

         for(int var27 = 0; var27 < var23.size(); ++var27) {
            LaboratoireEntete var25 = (LaboratoireEntete)var23.get(var27);
            DocumentEntete var52 = new DocumentEntete();
            var52.setDocNature(74);
            var52.setVar_lib_nat("Laboratoire");
            var52.setDocEtat(var25.getLabEtat());
            if (var25.getLabEtat() == 0) {
               var52.setDocLibelleEtat("E.C.");
            } else if (var25.getLabEtat() == 1) {
               var52.setDocLibelleEtat("Val.");
            } else if (var25.getLabEtat() == 2) {
               var52.setDocLibelleEtat("Gel.");
            } else if (var25.getLabEtat() == 3) {
               var52.setDocLibelleEtat("Ann.");
            }

            var52.setDocId(var25.getLabId());
            var52.setDocDate(var25.getLabDate());
            var52.setDocNum(var25.getLabNum());
            var52.setDocNomTiers(var25.getLabNomPatient());
            var52.setDocBudget(var25.getPatients().getPatDossier());
            var52.setDocService(var25.getLabService());
            var52.setDocTotTtc(var25.getLabTotPatient());
            double var53 = 0.0D;
            List var41 = var44.selectConsActesByConsEnt(var25, var3);

            for(int var30 = 0; var30 < var41.size(); ++var30) {
               var53 += ((LaboratoireLigne)var41.get(var30)).getLabligPatientHt();
            }

            var52.setDocTotTc(var53);
            double var54 = 0.0D;
            List var45 = var47.selectReglementByEnt(var25, var3);

            for(int var32 = 0; var32 < var45.size(); ++var32) {
               var54 += ((LaboratoireReglement)var45.get(var32)).getLabregPatient();
            }

            var52.setDocTotTva(var54);
            double var55 = 0.0D;
            var5 = var6.reglementDocument(var25.getLabId(), 74, var3);

            for(int var34 = 0; var34 < var5.size(); ++var34) {
               var55 += ((Reglements)var5.get(var34)).getRglRecette();
            }

            var52.setDocTotReglement(var55);
            if (var52.getDocTotTtc() == var52.getDocTotTc() && var52.getDocTotTva() == var52.getDocTotReglement()) {
               var52.setDocSelect(false);
            } else {
               var52.setDocSelect(true);
            }

            this.lesDocumentsImpayes.add(var52);
         }
      }

      for(int var50 = 0; var50 < this.lesDocumentsImpayes.size(); ++var50) {
         if (((DocumentEntete)this.lesDocumentsImpayes.get(var50)).getDocEtat() == 1) {
            this.totalEntete += ((DocumentEntete)this.lesDocumentsImpayes.get(var50)).getDocTotTtc();
            this.totalLigne += ((DocumentEntete)this.lesDocumentsImpayes.get(var50)).getDocTotTc();
            this.reglActe += ((DocumentEntete)this.lesDocumentsImpayes.get(var50)).getDocTotTva();
            this.reglCaisse += ((DocumentEntete)this.lesDocumentsImpayes.get(var50)).getDocTotReglement();
         }
      }

   }

   public void procedureControleRecu(String var1, String var2, Session var3) throws HibernateException, NamingException {
      String var4 = "";
      new DocumentEntete();
      new ConsultationEnteteGene();
      new PharmacieEntete();
      new LaboratoireEntete();
      ConsultationEnteteGeneDao var9 = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      PharmacieEnteteDao var10 = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
      LaboratoireEnteteDao var11 = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      ReglementsDao var13 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      List var12 = var13.rechercheRecus(var1, var2, var3);
      if (var12.size() != 0) {
         new Reglements();

         for(int var15 = 0; var15 < var12.size(); ++var15) {
            Reglements var14 = (Reglements)var12.get(var15);
            DocumentEntete var5;
            if (var14.getRglNatureDoc() == 71) {
               ConsultationEnteteGene var6 = var9.selectById(var14.getRglIdDocument(), var3);
               if (var6 == null || var6 != null && var6.getCsgEtat() != 1) {
                  var5 = new DocumentEntete();
                  var5.setDocNature(71);
                  var5.setVar_lib_nat("Consultation");
                  var5.setDocEtat(9);
                  var5.setDocLibelleEtat("");
                  var5.setDocId(var14.getRglIdDocument());
                  var5.setDocDate(var14.getRglDateReg());
                  var5.setDocNum(var14.getRglDocument());
                  var5.setDocNomTiers(var14.getRglNomTiers());
                  var5.setDocBudget(var14.getRglNum());
                  var5.setDocService(var14.getRglService());
                  var5.setDocTotTtc(0.0D);
                  var5.setDocTotTc(0.0D);
                  var5.setDocTotTva(0.0D);
                  var5.setDocTotReglement(var14.getRglRecette());
                  var5.setDocSelect(false);
                  this.lesDocumentsImpayes.add(var5);
               }
            } else if (var14.getRglNatureDoc() == 73) {
               PharmacieEntete var7 = var10.selectById(var14.getRglIdDocument(), var3);
               if (var7 == null || var7 != null && var7.getPhaEtat() != 1) {
                  var5 = new DocumentEntete();
                  var5.setDocNature(73);
                  var5.setVar_lib_nat("Pharmacie");
                  var5.setDocEtat(9);
                  var5.setDocLibelleEtat("");
                  var5.setDocId(var14.getRglIdDocument());
                  var5.setDocDate(var14.getRglDateReg());
                  var5.setDocNum(var14.getRglDocument());
                  var5.setDocNomTiers(var14.getRglNomTiers());
                  var5.setDocBudget(var14.getRglNum());
                  var5.setDocService(var14.getRglService());
                  var5.setDocTotTtc(0.0D);
                  var5.setDocTotTc(0.0D);
                  var5.setDocTotTva(0.0D);
                  var5.setDocTotReglement(var14.getRglRecette());
                  var5.setDocSelect(false);
                  this.lesDocumentsImpayes.add(var5);
               }
            } else if (var14.getRglNatureDoc() == 74) {
               LaboratoireEntete var8 = var11.selectById(var14.getRglIdDocument(), var3);
               if (var8 == null || var8 != null && var8.getLabEtat() != 1) {
                  var5 = new DocumentEntete();
                  var5.setDocNature(74);
                  var5.setVar_lib_nat("Laboratoire");
                  var5.setDocEtat(9);
                  var5.setDocLibelleEtat("");
                  var5.setDocId(var14.getRglIdDocument());
                  var5.setDocDate(var14.getRglDateReg());
                  var5.setDocNum(var14.getRglDocument());
                  var5.setDocNomTiers(var14.getRglNomTiers());
                  var5.setDocBudget(var14.getRglNum());
                  var5.setDocService(var14.getRglService());
                  var5.setDocTotTtc(0.0D);
                  var5.setDocTotTc(0.0D);
                  var5.setDocTotTva(0.0D);
                  var5.setDocTotReglement(var14.getRglRecette());
                  var5.setDocSelect(false);
                  this.lesDocumentsImpayes.add(var5);
               }
            }
         }
      }

      for(int var16 = 0; var16 < this.lesDocumentsImpayes.size(); ++var16) {
         if (((DocumentEntete)this.lesDocumentsImpayes.get(var16)).getDocEtat() == 1) {
            this.totalEntete += ((DocumentEntete)this.lesDocumentsImpayes.get(var16)).getDocTotTtc();
            this.totalLigne += ((DocumentEntete)this.lesDocumentsImpayes.get(var16)).getDocTotTc();
            this.reglActe += ((DocumentEntete)this.lesDocumentsImpayes.get(var16)).getDocTotTva();
            this.reglCaisse += ((DocumentEntete)this.lesDocumentsImpayes.get(var16)).getDocTotReglement();
         }
      }

   }

   public void procedureNettoyage(String var1, String var2, Session var3) throws HibernateException, NamingException {
      String var4 = "";
      new ArrayList();
      ConsultationEnteteGeneDao var6 = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      var4 = "csgDate >='" + var1 + "' and csgDate<='" + var2 + "' and (csgTotPatient<>csgRegPatient or csgEtat = 0)";
      List var5 = var6.chargerConsultationByRequete(var4, var3);
      if (var5.size() != 0) {
         new ConsultationEnteteGene();
         new DocumentEntete();

         for(int var9 = 0; var9 < var5.size(); ++var9) {
            ConsultationEnteteGene var7 = (ConsultationEnteteGene)var5.get(var9);
            if ((var7.getCsgTotPatient() != var7.getCsgRegPatient() || var7.getCsgEtat() == 0) && (this.inpEtat == 100 && var7.getCsgEtat() <= 2 || this.inpEtat != 100 && this.inpEtat == var7.getCsgEtat())) {
               DocumentEntete var8 = new DocumentEntete();
               var8.setDocNature(71);
               var8.setVar_lib_nat("Consultation");
               if (var7.getCsgRegPatient() == 0.0D) {
                  var8.setDocSelect(true);
               } else {
                  var8.setDocSelect(false);
               }

               var8.setDocEtat(var7.getCsgEtat());
               if (var7.getCsgEtat() == 0) {
                  var8.setDocLibelleEtat("E.C.");
               } else if (var7.getCsgEtat() == 1) {
                  var8.setDocLibelleEtat("Val.");
               } else if (var7.getCsgEtat() == 2) {
                  var8.setDocLibelleEtat("Gel.");
               } else if (var7.getCsgEtat() == 3) {
                  var8.setDocLibelleEtat("Ann.");
               }

               var8.setDocId(var7.getCsgId());
               var8.setDocDate(var7.getCsgDate());
               var8.setDocNum(var7.getCsgNum());
               var8.setDocNomTiers(var7.getCsgNomPatient());
               var8.setDocBudget(var7.getPatients().getPatDossier());
               var8.setDocService(var7.getCsgService());
               var8.setDocTotTtc(var7.getCsgTotPatient());
               var8.setDocTotReglement(var7.getCsgRegPatient());
               this.lesDocumentsImpayes.add(var8);
            }
         }
      }

      new ArrayList();
      PharmacieEnteteDao var19 = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
      var4 = "phaDate >='" + var1 + "' and phaDate<='" + var2 + "' and (phaTotPatient<>phaRegPatient or phaEtat = 0)";
      List var18 = var19.chargerPharmacieByRequete(var4, var3);
      if (var18.size() != 0) {
         new PharmacieEntete();
         new DocumentEntete();

         for(int var11 = 0; var11 < var18.size(); ++var11) {
            PharmacieEntete var20 = (PharmacieEntete)var18.get(var11);
            if ((var20.getPhaTotPatient() != var20.getPhaRegPatient() || var20.getPhaEtat() == 0) && (this.inpEtat == 100 && var20.getPhaEtat() <= 2 || this.inpEtat != 100 && this.inpEtat == var20.getPhaEtat())) {
               DocumentEntete var10 = new DocumentEntete();
               var10.setDocNature(73);
               var10.setVar_lib_nat("Pharmacie");
               if (var20.getPhaRegPatient() == 0.0D) {
                  var10.setDocSelect(true);
               } else {
                  var10.setDocSelect(false);
               }

               var10.setDocEtat(var20.getPhaEtat());
               if (var20.getPhaEtat() == 0) {
                  var10.setDocLibelleEtat("E.C.");
               } else if (var20.getPhaEtat() == 1) {
                  var10.setDocLibelleEtat("Val.");
               } else if (var20.getPhaEtat() == 2) {
                  var10.setDocLibelleEtat("Gel.");
               } else if (var20.getPhaEtat() == 3) {
                  var10.setDocLibelleEtat("Ann.");
               }

               var10.setDocId(var20.getPhaId());
               var10.setDocDate(var20.getPhaDate());
               var10.setDocNum(var20.getPhaNum());
               var10.setDocNomTiers(var20.getPhaNomPatient());
               var10.setDocBudget(var20.getPatients().getPatDossier());
               var10.setDocService(var20.getPhaService());
               var10.setDocTotTtc(var20.getPhaTotPatient());
               var10.setDocTotReglement(var20.getPhaRegPatient());
               this.lesDocumentsImpayes.add(var10);
            }
         }
      }

      new ArrayList();
      LaboratoireEnteteDao var22 = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      var4 = "labDate >='" + var1 + "' and labDate<='" + var2 + "' and (labTotPatient<>labRegPatient or labEtat = 0)";
      List var21 = var22.chargerLaboratoireByRequete(var4, var3);
      if (var21.size() != 0) {
         new LaboratoireEntete();
         new DocumentEntete();

         for(int var13 = 0; var13 < var21.size(); ++var13) {
            LaboratoireEntete var23 = (LaboratoireEntete)var21.get(var13);
            if ((var23.getLabTotPatient() != var23.getLabRegPatient() || var23.getLabEtat() == 0) && (this.inpEtat == 100 && var23.getLabEtat() <= 2 || this.inpEtat != 100 && this.inpEtat == var23.getLabEtat())) {
               DocumentEntete var12 = new DocumentEntete();
               var12.setDocNature(74);
               var12.setVar_lib_nat("Laboratoire");
               if (var23.getLabRegPatient() == 0.0D) {
                  var12.setDocSelect(true);
               } else {
                  var12.setDocSelect(false);
               }

               var12.setDocEtat(var23.getLabEtat());
               if (var23.getLabEtat() == 0) {
                  var12.setDocLibelleEtat("E.C.");
               } else if (var23.getLabEtat() == 1) {
                  var12.setDocLibelleEtat("Val.");
               } else if (var23.getLabEtat() == 2) {
                  var12.setDocLibelleEtat("Gel.");
               } else if (var23.getLabEtat() == 3) {
                  var12.setDocLibelleEtat("Ann.");
               }

               var12.setDocId(var23.getLabId());
               var12.setDocDate(var23.getLabDate());
               var12.setDocNum(var23.getLabNum());
               var12.setDocNomTiers(var23.getLabNomPatient());
               var12.setDocBudget(var23.getPatients().getPatDossier());
               var12.setDocService(var23.getLabService());
               var12.setDocTotTtc(var23.getLabTotPatient());
               var12.setDocTotReglement(var23.getLabRegPatient());
               this.lesDocumentsImpayes.add(var12);
            }
         }
      }

      new ArrayList();
      DevisEnteteMedicalDao var25 = new DevisEnteteMedicalDao(this.baseLog, this.utilInitHibernate);
      var4 = "dvsDate >='" + var1 + "' and dvsDate<='" + var2 + "' and labEtat = 0";
      List var24 = var25.chargerDevisByRequete(var4, var3);
      if (var24.size() != 0) {
         new DevisEnteteMedical();
         new DocumentEntete();

         for(int var15 = 0; var15 < var24.size(); ++var15) {
            DevisEnteteMedical var26 = (DevisEnteteMedical)var24.get(var15);
            if ((var26.getDvsTotPatient() != var26.getDvsRegPatient() || var26.getDvsEtat() == 0) && (this.inpEtat == 100 && var26.getDvsEtat() <= 2 || this.inpEtat != 100 && this.inpEtat == var26.getDvsEtat())) {
               DocumentEntete var14 = new DocumentEntete();
               var14.setDocNature(77);
               var14.setVar_lib_nat("DevisEnteteMedical");
               if (var26.getDvsRegPatient() == 0.0D) {
                  var14.setDocSelect(true);
               } else {
                  var14.setDocSelect(false);
               }

               var14.setDocEtat(var26.getDvsEtat());
               if (var26.getDvsEtat() == 0) {
                  var14.setDocLibelleEtat("E.C.");
               } else if (var26.getDvsEtat() == 1) {
                  var14.setDocLibelleEtat("Val.");
               } else if (var26.getDvsEtat() == 2) {
                  var14.setDocLibelleEtat("Gel.");
               } else if (var26.getDvsEtat() == 3) {
                  var14.setDocLibelleEtat("Ann.");
               }

               var14.setDocId(var26.getDvsId());
               var14.setDocDate(var26.getDvsDate());
               var14.setDocNum(var26.getDvsNum());
               var14.setDocNomTiers(var26.getDvsNomPatient());
               var14.setDocBudget(var26.getPatients().getPatDossier());
               var14.setDocService(var26.getDvsService());
               var14.setDocTotTtc(var26.getDvsTotPatient());
               var14.setDocTotReglement(var26.getDvsRegPatient());
               this.lesDocumentsImpayes.add(var14);
            }
         }
      }

      new ArrayList();
      BonEncaissementVenteDao var28 = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
      List var27 = var28.selectNonPayerMedic(0, var3);
      if (var27.size() != 0) {
         new BonEncaissementVente();
         new DocumentEntete();

         for(int var17 = 0; var17 < var27.size(); ++var17) {
            BonEncaissementVente var29 = (BonEncaissementVente)var27.get(var17);
            if (var29.getBonDate().compareTo(this.dateDebut) >= 0 && var29.getBonDate().compareTo(this.dateFin) <= 0) {
               DocumentEntete var16 = new DocumentEntete();
               var16.setDocNature(0);
               var16.setVar_lib_nat("Bon Encaissement");
               var16.setDocSelect(true);
               if (var29.getBonEtat() == 0) {
                  var16.setDocLibelleEtat("E.C.");
               } else if (var29.getBonEtat() == 1) {
                  var16.setDocLibelleEtat("Val.");
               } else if (var29.getBonEtat() == 2) {
                  var16.setDocLibelleEtat("Gel.");
               } else if (var29.getBonEtat() == 3) {
                  var16.setDocLibelleEtat("Ann.");
               }

               var16.setDocId(var29.getBonId());
               var16.setDocDate(var29.getBonDate());
               var16.setDocNum(var29.getBonNum());
               var16.setDocNomTiers(var29.getBonNomTiers());
               var16.setDocBudget("");
               var16.setDocService(var29.getBonService());
               var16.setDocTotTtc(var29.getBonAPayer());
               var16.setDocTotReglement(0.0D);
               this.lesDocumentsImpayes.add(var16);
            }
         }
      }

   }

   public void selectionAll() {
      if (this.lesDocumentsImpayes.size() != 0) {
         new DocumentEntete();

         for(int var2 = 0; var2 < this.lesDocumentsImpayes.size(); ++var2) {
            DocumentEntete var1 = (DocumentEntete)this.lesDocumentsImpayes.get(var2);
            var1.setDocSelect(true);
         }

         this.dataModelDocument.setWrappedData(this.lesDocumentsImpayes);
      }

   }

   public void deSelectionAll() {
      if (this.lesDocumentsImpayes.size() != 0) {
         new DocumentEntete();

         for(int var2 = 0; var2 < this.lesDocumentsImpayes.size(); ++var2) {
            DocumentEntete var1 = (DocumentEntete)this.lesDocumentsImpayes.get(var2);
            var1.setDocSelect(false);
         }

         this.dataModelDocument.setWrappedData(this.lesDocumentsImpayes);
      }

   }

   public void applicationNettoyage() throws HibernateException, NamingException {
      if (this.lesDocumentsImpayes.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            ConsultationEnteteGeneDao var3 = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
            new ConsultationEnteteGene();
            ConsultationActesDao var5 = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
            new ConsultationActes();
            new ArrayList();
            PharmacieEnteteDao var8 = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
            new PharmacieEntete();
            PharmacieLigneDao var10 = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
            new PharmacieLigne();
            new ArrayList();
            LaboratoireEnteteDao var13 = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
            new LaboratoireEntete();
            LaboratoireLigneDao var15 = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
            new LaboratoireLigne();
            new ArrayList();
            new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
            new HospitalisationEntete();
            DevisLigneMedicalDao var20 = new DevisLigneMedicalDao(this.baseLog, this.utilInitHibernate);
            DevisEnteteMedicalDao var21 = new DevisEnteteMedicalDao(this.baseLog, this.utilInitHibernate);
            new DevisEnteteMedical();
            BonEncaissementVenteDao var23 = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
            new BonEncaissementVente();
            new DocumentEntete();
            double var26 = 0.0D;
            double var28 = 0.0D;
            double var30 = 0.0D;
            double var32 = 0.0D;
            double var34 = 0.0D;
            double var36 = 0.0D;
            double var38 = 0.0D;
            double var40 = 0.0D;
            int var42 = 0;

            while(true) {
               if (var42 >= this.lesDocumentsImpayes.size()) {
                  var2.commit();
                  break;
               }

               DocumentEntete var25 = (DocumentEntete)this.lesDocumentsImpayes.get(var42);
               if (!var25.isDocSelect() && var25.getDocEtat() == 0) {
                  var25.setDocSelect(true);
               }

               ConsultationEnteteGene var4;
               PharmacieEntete var9;
               LaboratoireEntete var14;
               if (var25.isDocSelect() && var25.getDocTotReglement() == 0.0D) {
                  if (var25.getDocNature() == 71) {
                     var4 = var3.selectById(var25.getDocId(), var1);
                     if (var4 != null) {
                        var4.setCsgEtat(3);
                        var3.modif(var4, var1);
                     }
                  } else if (var25.getDocNature() == 73) {
                     var9 = var8.selectById(var25.getDocId(), var1);
                     if (var9 != null) {
                        var9.setPhaEtat(3);
                        var8.modif(var9, var1);
                     }
                  } else if (var25.getDocNature() == 74) {
                     var14 = var13.selectById(var25.getDocId(), var1);
                     if (var14 != null) {
                        var14.setLabEtat(3);
                        var13.modif(var14, var1);
                     }
                  } else if (var25.getDocNature() == 77) {
                     DevisEnteteMedical var22 = var21.selectById(var25.getDocId(), var1);
                     if (var22 != null) {
                        var20.deleteAllLigne(var22, var1);
                        var21.delete(var22, var1);
                     }
                  } else if (var25.getDocNature() == 0) {
                     BonEncaissementVente var24 = var23.selectById(var25.getDocId(), var1);
                     if (var24 != null) {
                        var23.delete(var24, var1);
                     }
                  }
               } else if (var25.isDocSelect() && var25.getDocTotReglement() != 0.0D && var25.getDocTotTtc() != 0.0D && var25.getDocTotReglement() == var25.getDocTotTtc()) {
                  if (var25.getDocNature() == 71) {
                     var4 = var3.selectById(var25.getDocId(), var1);
                     if (var4 != null) {
                        var4.setCsgEtat(1);
                        var3.modif(var4, var1);
                     }
                  } else if (var25.getDocNature() == 73) {
                     var9 = var8.selectById(var25.getDocId(), var1);
                     if (var9 != null) {
                        var9.setPhaEtat(1);
                        var8.modif(var9, var1);
                     }
                  } else if (var25.getDocNature() == 74) {
                     var14 = var13.selectById(var25.getDocId(), var1);
                     if (var14 != null) {
                        var14.setLabEtat(1);
                        var13.modif(var14, var1);
                     }
                  }
               } else if (var25.isDocSelect() && var25.getDocTotReglement() != 0.0D && var25.getDocTotTtc() != 0.0D && var25.getDocTotReglement() != var25.getDocTotTtc()) {
                  int var43;
                  if (var25.getDocNature() == 71) {
                     var4 = var3.selectById(var25.getDocId(), var1);
                     if (var4 != null) {
                        var26 = 0.0D;
                        var28 = 0.0D;
                        var30 = 0.0D;
                        var32 = 0.0D;
                        var34 = 0.0D;
                        var36 = 0.0D;
                        var38 = 0.0D;
                        var40 = 0.0D;
                        List var7 = var5.selectConsActesByConsEnt(var4, var1);
                        if (var7.size() != 0) {
                           for(var43 = 0; var43 < var7.size(); ++var43) {
                              ConsultationActes var6 = (ConsultationActes)var7.get(var43);
                              if (var6.getCslactPatientHt() != 0.0D && var6.getCslactRegPatient() < var6.getCslactPatientHt() + var6.getCslactPatientTaxe()) {
                                 var6.setCslactPatientHt(var6.getCslactRegPatient());
                                 if (var6.getCslactRegPatient() == 0.0D) {
                                    var6.setCslactPatientHt(0.0D);
                                    var6.setCslactPatientTaxe(0.0D);
                                    var6.setCslactAssuranceHt(0.0D);
                                    var6.setCslactAssuranceTaxe(0.0D);
                                    var6.setCslactComplementaireHt(0.0D);
                                    var6.setCslactComplementaireTaxe(0.0D);
                                    var6.setCslactSocieteHt(0.0D);
                                    var6.setCslactSocieteTaxe(0.0D);
                                    var6.setCslactQte(0.0F);
                                 }

                                 var6 = var5.modif(var6, var1);
                              }

                              var26 += var6.getCslactPatientHt();
                              var28 += var6.getCslactPatientTaxe();
                              var30 += var6.getCslactAssuranceHt();
                              var32 += var6.getCslactAssuranceTaxe();
                              var34 += var6.getCslactComplementaireHt();
                              var36 += var6.getCslactComplementaireTaxe();
                              var38 += var6.getCslactSocieteHt();
                              var40 += var6.getCslactSocieteTaxe();
                           }

                           var4.setCsgTotPatient(var26);
                           var4.setCsgTotTaxePatient(var28);
                           var4.setCsgTotAssurance(var30);
                           var4.setCsgTotTaxeAssurance(var32);
                           var4.setCsgTotComplmentaire(var34);
                           var4.setCsgTotTaxeComplementaire(var36);
                           var4.setCsgTotSociete(var38);
                           var4.setCsgTotTaxeSociete(var40);
                           var3.modif(var4, var1);
                        }
                     }
                  } else if (var25.getDocNature() == 73) {
                     var9 = var8.selectById(var25.getDocId(), var1);
                     if (var9 != null) {
                        var26 = 0.0D;
                        var28 = 0.0D;
                        var30 = 0.0D;
                        var32 = 0.0D;
                        var34 = 0.0D;
                        var36 = 0.0D;
                        var38 = 0.0D;
                        var40 = 0.0D;
                        List var12 = var10.selectConsActesByConsEnt(var9, var1);
                        if (var12.size() != 0) {
                           for(var43 = 0; var43 < var12.size(); ++var43) {
                              PharmacieLigne var11 = (PharmacieLigne)var12.get(var43);
                              if (var11.getPhaligPatientHt() != 0.0D && var11.getPhaligRegPatient() < var11.getPhaligPatientHt() + var11.getPhaligPatientTaxe()) {
                                 var11.setPhaligPatientHt(var11.getPhaligRegPatient());
                                 if (var11.getPhaligRegPatient() == 0.0D) {
                                    var11.setPhaligPatientHt(0.0D);
                                    var11.setPhaligPatientTaxe(0.0D);
                                    var11.setPhaligAssuranceHt(0.0D);
                                    var11.setPhaligAssuranceTaxe(0.0D);
                                    var11.setPhaligComplementaireHt(0.0D);
                                    var11.setPhaligComplementaireTaxe(0.0D);
                                    var11.setPhaligSocieteHt(0.0D);
                                    var11.setPhaligSocieteTaxe(0.0D);
                                    var11.setPhaligQte(0.0F);
                                 }

                                 var11 = var10.modif(var11, var1);
                              }

                              var26 += var11.getPhaligPatientHt();
                              var28 += var11.getPhaligPatientTaxe();
                              var30 += var11.getPhaligAssuranceHt();
                              var32 += var11.getPhaligAssuranceTaxe();
                              var34 += var11.getPhaligComplementaireHt();
                              var36 += var11.getPhaligComplementaireTaxe();
                              var38 += var11.getPhaligSocieteHt();
                              var40 += var11.getPhaligSocieteTaxe();
                           }

                           var9.setPhaTotPatient(var26);
                           var9.setPhaTotTaxePatient(var28);
                           var9.setPhaTotAssurance(var30);
                           var9.setPhaTotTaxeAssurance(var32);
                           var9.setPhaTotComplmentaire(var34);
                           var9.setPhaTotTaxeComplementaire(var36);
                           var9.setPhaTotSociete(var38);
                           var9.setPhaTotTaxeSociete(var40);
                           var8.modif(var9, var1);
                        }
                     }
                  } else if (var25.getDocNature() == 74) {
                     var14 = var13.selectById(var25.getDocId(), var1);
                     if (var14 != null) {
                        var26 = 0.0D;
                        var28 = 0.0D;
                        var30 = 0.0D;
                        var32 = 0.0D;
                        var34 = 0.0D;
                        var36 = 0.0D;
                        var38 = 0.0D;
                        var40 = 0.0D;
                        List var17 = var15.selectConsActesByConsEnt(var14, var1);
                        if (var17.size() != 0) {
                           for(var43 = 0; var43 < var17.size(); ++var43) {
                              LaboratoireLigne var16 = (LaboratoireLigne)var17.get(var43);
                              if (var16.getLabligPatientHt() != 0.0D && var16.getLabligRegPatient() < var16.getLabligPatientHt() + var16.getLabligPatientTaxe()) {
                                 var16.setLabligPatientHt(var16.getLabligRegPatient());
                                 if (var16.getLabligRegPatient() == 0.0D) {
                                    var16.setLabligPatientHt(0.0D);
                                    var16.setLabligPatientTaxe(0.0D);
                                    var16.setLabligAssuranceHt(0.0D);
                                    var16.setLabligAssuranceTaxe(0.0D);
                                    var16.setLabligComplementaireHt(0.0D);
                                    var16.setLabligComplementaireTaxe(0.0D);
                                    var16.setLabligSocieteHt(0.0D);
                                    var16.setLabligSocieteTaxe(0.0D);
                                    var16.setLabligQte(0.0F);
                                 }

                                 var16 = var15.modif(var16, var1);
                              }

                              var26 += var16.getLabligPatientHt();
                              var28 += var16.getLabligPatientTaxe();
                              var30 += var16.getLabligAssuranceHt();
                              var32 += var16.getLabligAssuranceTaxe();
                              var34 += var16.getLabligComplementaireHt();
                              var36 += var16.getLabligComplementaireTaxe();
                              var38 += var16.getLabligSocieteHt();
                              var40 += var16.getLabligSocieteTaxe();
                           }

                           var14.setLabTotPatient(var26);
                           var14.setLabTotTaxePatient(var28);
                           var14.setLabTotAssurance(var30);
                           var14.setLabTotTaxeAssurance(var32);
                           var14.setLabTotComplmentaire(var34);
                           var14.setLabTotTaxeComplementaire(var36);
                           var14.setLabTotSociete(var38);
                           var14.setLabTotTaxeSociete(var40);
                           var13.modif(var14, var1);
                        }
                     }
                  }
               }

               ++var42;
            }
         } catch (HibernateException var47) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var47;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.chargerNettoyage();
      }

   }

   public void recupererTousLesItems(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererOptionsMedical();
      this.recupererOptionsTiers();
      this.recupererModelesAutorises();
      this.recupererDevisesItem(var1);
      this.recupererServiceItem(var1);
      this.recupererLesSiteItem(var1);
      this.recupererLesRegionItem(var1);
      this.recupererBudgetItem(var1);
      this.recupererLettreItem(var1);
      this.recupererConditionnementItem(var1);
      this.recupererActiviteItem(var1);
      this.recupererBanquesItem(var1);
      this.recupererTypesReglementsItem();
      this.recupererCaisses(var1);
      this.recupererNatureItem();
      this.recupererPecItem();
      this.recupererPathologieItem(var1);
      this.recupererMotifEntreeItem(var1);
      this.recupererProtocoleItem(var1);
      this.recupererTaxeItem(var1);
      this.recupererPrescripteurItem(var1);
      this.recupererAntecedentItem();
      this.recupererLesCreateurItem(var1);
      this.recupererFamillesClientItem();
   }

   public void recupererLesItemsImpression(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererServiceItem(var1);
      this.recupererDepotItem(var1, 0);
      this.recupererLesCreateurItem(var1);
      this.recupererLesMedecinsItem(var1);
   }

   public void recupererLesItemsProd(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererFamilleProduitAchatsUtilItem(var1);
      this.recupererFamilleProduitVentesItem(var1);
      this.recupererDepotItem(var1, 0);
      this.recupererUniteItem(var1);
      this.chargerMesCompte(var1);
      this.recupererLesMarquesItem(var1);
      this.recupererModeleFicheProduit();
      this.recupererModeleListeProduit();
      this.recupererModeleListeMouvements();
   }

   public void recupererLesItemsDoc(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererSerieUserItem(var1);
      this.recupererModeleDocument();
      this.recupererHabilitation(var1);
      this.recupererModeleListe();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void recupererHabilitation(Session var1) throws HibernateException, NamingException {
      this.habilitation = new Habilitation();
      if (this.usersLog.getUsrSansHabilitation() == 0) {
         HabilitationDao var2 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
         this.habilitation = var2.existenceHabilitation(74, var1);
      } else {
         this.habilitation = null;
      }

   }

   public void recupererLesMarquesItem(Session var1) throws HibernateException, NamingException {
      this.mesMarquesItems = new ArrayList();
      MarquesDao var2 = new MarquesDao(this.baseLog, this.utilInitHibernate);
      this.mesMarquesItems = var2.chargerLesMarques(var1);
      if (this.mesMarquesItems.size() != 0) {
         this.var_marque_util = true;
      } else {
         this.var_marque_util = false;
      }

   }

   public void recupererLesMedecinsItem(Session var1) throws HibernateException, NamingException {
      UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
      this.mesCommerciauxItems = new ArrayList();
      this.mesMedecinsItems = new ArrayList();
      new ArrayList();
      List var3 = var2.chargerLesMedecins(var1);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            Users var5 = (Users)var3.get(var4);
            if ((var5.getUsrFonction() != null && !var5.getUsrFonction().isEmpty() && var5.getUsrFonction().contains("Professeur") || var5.getUsrFonction().contains("Médecin")) && var5.getUsrPatronyme() != null && !var5.getUsrPatronyme().isEmpty()) {
               this.mesCommerciauxItems.add(new SelectItem(var5.getUsrid(), var5.getUsrPatronyme() + ":" + var5.getUsrMetier()));
               this.mesMedecinsItems.add(new SelectItem(var5.getUsrPatronyme()));
            }
         }
      }

   }

   public void recupererLesCreateurItem(Session var1) throws HibernateException, NamingException {
      this.mesCreateursItems = new ArrayList();
      UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var3 = var2.chargerLesCommerciaux(var1);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            this.mesCreateursItems.add(new SelectItem(((Users)var3.get(var4)).getUsrid(), ((Users)var3.get(var4)).getUsrNom() + ":" + ((Users)var3.get(var4)).getUsrPrenom()));
         }
      }

   }

   public void recupererDepotItem(Session var1, int var2) throws NamingException {
      this.listeDepotUser = "";
      if (this.usersLog.getUsrDepotSel() == 1) {
         UsersFavorisDao var3 = new UsersFavorisDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var4 = var3.chargerUsersDepot(this.usersLog, var1);
         if (var4.size() != 0) {
            for(int var5 = 0; var5 < var4.size(); ++var5) {
               if (this.listeDepotUser != null && !this.listeDepotUser.isEmpty()) {
                  this.listeDepotUser = this.listeDepotUser + "," + ((UsersFavoris)var4.get(var5)).getUsrfavLogin();
               } else {
                  this.listeDepotUser = ((UsersFavoris)var4.get(var5)).getUsrfavLogin();
               }
            }
         }
      }

      this.mesDepotItems = new ArrayList();
      if (this.lastExoAchats != null) {
         DepotAchatsDao var6 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrProdServiceAch() == 1) {
            if (this.listeDepotUser != null && !this.listeDepotUser.isEmpty()) {
               this.mesDepotItems = var6.selectActifDepotUsersItems(var2, this.usersLog.getUsrService(), this.listeDepotUser, var1);
            } else {
               this.mesDepotItems = var6.selectActifDepotItems(var2, this.usersLog.getUsrService(), var1);
            }
         } else if (this.listeDepotUser != null && !this.listeDepotUser.isEmpty()) {
            this.mesDepotItems = var6.selectActifDepotUsersItems(var2, this.listeDepotUser, var1);
         } else {
            this.mesDepotItems = var6.selectActifDepotItems(var2, var1);
         }
      }

   }

   public void chargerMesCompte(Session var1) throws NamingException {
      this.mesCompteProduitsItems = new ArrayList();
      this.mesCompteStocksItems = new ArrayList();
      this.mesCompteVteLocItems = new ArrayList();
      this.mesCompteVteZItems = new ArrayList();
      this.mesCompteVteHzItems = new ArrayList();
      if (this.lastExoCompta != null && this.lastExoCompta.getExecpt_id() != 0L) {
         String var2 = this.structureLog.getStrzonefiscale();
         if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
            long var3 = (long)(this.lastExoCompta.getExecptDateDebut().getYear() + 1900);
            long var5 = (long)(this.lastExoCompta.getExecptDateFin().getYear() + 1900);
            if (this.structureLog.getStrdatefiscale2() != null && var3 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var5 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
               var2 = this.structureLog.getStrzonefiscale2();
            } else if (this.structureLog.getStrdatefiscale2() != null && var3 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var5 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
               var2 = this.structureLog.getStrzonefiscale();
            } else {
               var2 = null;
            }
         }

         PlanComptableDao var7 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
         String var4 = "";
         var4 = "(17)";
         this.mesCompteProduitsItems = var7.chargerPlanCmptItems(var2, this.lastExoCompta.getExecpt_id(), var4, 0, var1);
         this.mesCompteVteLocItems = this.mesCompteProduitsItems;
         this.mesCompteVteZItems = this.mesCompteProduitsItems;
         this.mesCompteVteHzItems = this.mesCompteProduitsItems;
         var4 = "(5,16)";
         this.mesCompteStocksItems = var7.chargerPlanCmptItems(var2, this.lastExoCompta.getExecpt_id(), var4, 0, var1);
      }

   }

   public void recupererOptionsMedical() {
      this.optionMedical = new OptionMedical();
      LireLesoptionsMedical var1 = new LireLesoptionsMedical();
      var1.setStrId(this.structureLog.getStrid());
      var1.lancer();
      this.optionMedical = var1.lancer();
   }

   public void recupererOptionsTiers() {
      this.optionTiers = new OptionTiers();
      LireLesoptionsTiers var1 = new LireLesoptionsTiers();
      var1.setStrId(this.structureLog.getStrid());
      var1.lancer();
      this.optionTiers = var1.lancer();
   }

   public void recupererModelesAutorises() {
      this.lesModelesAutorises = new ArrayList();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "medical" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "medical" + File.separator + "configuration" + File.separator + this.usersLog.getGroupe().getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.lesModelesAutorises = this.lectureModeleAutorise.getLesModelesAutorises();
      }

   }

   public void recupererDevisesItem(Session var1) throws HibernateException, NamingException {
      this.mesdevisesItem = new ArrayList();
      DeviseDao var2 = new DeviseDao(this.baseLog, this.utilInitHibernate);
      this.mesdevisesItem = var2.chargerLesDevisesUtiliseesItem(this.structureLog, var1);
   }

   public void recupererServiceItem(Session var1) throws HibernateException, NamingException {
      this.mesServicesItems = new ArrayList();
      SpecialitesMedicalDao var2 = new SpecialitesMedicalDao(this.baseLog, this.utilInitHibernate);
      if (this.usersLog.getUsrProdService() == 1 && this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty()) {
         this.mesServicesItems.add(new SelectItem(this.usersLog.getUsrService()));
      } else {
         this.mesServicesItems = var2.chargerLesServicesMedicauxItems(1, 0, var1);
         if (this.mesServicesItems.size() > 1) {
            this.var_affiche_service = true;
         } else {
            this.var_affiche_service = false;
         }
      }

      this.mesLaboratoiresItems = new ArrayList();
      this.mesLaboratoiresItems = var2.chargerLesLaboratoiresItems(1, var1);
      this.mesPharmaciesItems = new ArrayList();
      this.mesPharmaciesItems = var2.chargerLesPharmaciesItems(1, var1);
      this.mesServices2Items = new ArrayList();
      this.mesServices2Items = var2.chargerLesServicesItems(1, var1);
   }

   public void recupererActiviteItem(Session var1) throws HibernateException, NamingException {
      this.mesActivitesItems = new ArrayList();
      ActivitesDao var2 = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.mesActivitesItems = var2.chargerLesActivites(var1);
   }

   public void recupererBudgetItem(Session var1) throws HibernateException, NamingException {
      this.mesBudgetsItems = new ArrayList();
      BudgetDao var2 = new BudgetDao(this.baseLog, this.utilInitHibernate);
      this.mesBudgetsItems = var2.selectAllBudget(this.exoselectionne.getExevteId(), var1);
   }

   public void recupererLettreItem(Session var1) throws HibernateException, NamingException {
      this.mesLettresItems = new ArrayList();
      LettreMedicalDao var2 = new LettreMedicalDao(this.baseLog, this.utilInitHibernate);
      this.mesLettresItems = var2.selectActifLettreItem(this.exoselectionne.getExevteId(), var1);
   }

   public void recupererLesRegionItem(Session var1) throws HibernateException, NamingException {
      this.mesRegionsItems = new ArrayList();
      RegionDao var2 = new RegionDao(this.baseLog, this.utilInitHibernate);
      this.mesRegionsItems = var2.chargerLesRegionItems(var1);
   }

   public void recupererLesSiteItem(Session var1) throws HibernateException, NamingException {
      this.mesSitesItems = new ArrayList();
      SiteDao var2 = new SiteDao(this.baseLog, this.utilInitHibernate);
      this.mesSitesItems = var2.chargerLesSitesItems(var1);
   }

   public void recupererConditionnementItem(Session var1) throws HibernateException, NamingException {
      this.mesConditionnementsItems = new ArrayList();
      ConditionnementDao var2 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
      this.mesConditionnementsItems = var2.chargerLesConditionnements(var1);
   }

   public void recupererUniteItem(Session var1) throws HibernateException, NamingException {
      this.mesUnitesItems = new ArrayList();
      UniteDao var2 = new UniteDao(this.baseLog, this.utilInitHibernate);
      this.mesUnitesItems = var2.chargerLesUnitesItems(var1);
   }

   public void recupererBanquesItem(Session var1) throws HibernateException, NamingException {
      this.mesBanquesItems = new ArrayList();
      ContactDao var2 = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.mesBanquesItems = var2.chargerLesContactsBqItems(var1);
   }

   public void recupererFamillesClientItem() throws JDOMException, IOException {
      LectureFamillesClients var1 = new LectureFamillesClients();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesFamillesClientItems();
      this.mesFamilleClientsItems = var1.getMesFamillesClientsItems();
      this.lesFamilleClientsListe = var1.getMesFamillesClients();
      this.var_tarif1 = "";
      this.var_tarif2 = "";
      this.var_tarif3 = "";
      this.var_tarif4 = "";
      this.var_tarif5 = "";
      this.var_tarif6 = "";
      this.var_tarif7 = "";
      this.var_tarif8 = "";
      this.var_tarif9 = "";
      this.var_tarif10 = "";
      this.var_aff_tarif1 = false;
      this.var_aff_tarif2 = false;
      this.var_aff_tarif3 = false;
      this.var_aff_tarif4 = false;
      this.var_aff_tarif5 = false;
      this.var_aff_tarif6 = false;
      this.var_aff_tarif7 = false;
      this.var_aff_tarif8 = false;
      this.var_aff_tarif9 = false;
      this.var_aff_tarif10 = false;

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
         } else if (var2 == 5) {
            this.var_tarif6 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(5)).getLibelle();
            this.var_aff_tarif6 = true;
         } else if (var2 == 6) {
            this.var_tarif7 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(6)).getLibelle();
            this.var_aff_tarif7 = true;
         } else if (var2 == 7) {
            this.var_tarif8 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(7)).getLibelle();
            this.var_aff_tarif8 = true;
         } else if (var2 == 8) {
            this.var_tarif9 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(8)).getLibelle();
            this.var_aff_tarif9 = true;
         } else if (var2 == 9) {
            this.var_tarif10 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(9)).getLibelle();
            this.var_aff_tarif10 = true;
         }
      }

   }

   public void recupererCaisses(Session var1) throws HibernateException, NamingException {
      this.listCaisses = new ArrayList();
      new ArrayList();
      List var2 = this.usersChronoDao.selectListCaisseByUser(this.usersLog, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if ((((UsersChrono)var2.get(var3)).getUsrchrNature() == 60 || ((UsersChrono)var2.get(var3)).getUsrchrNature() == 61) && ((UsersChrono)var2.get(var3)).getUsrchrCodeCaisse() != null && !((UsersChrono)var2.get(var3)).getUsrchrCodeCaisse().isEmpty()) {
               String var4 = ((UsersChrono)var2.get(var3)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)var2.get(var3)).getUsrchrLib();
               this.listCaisses.add(var2.get(var3));
            }
         }
      }

   }

   public void recupererTypesReglementsItem() throws JDOMException, IOException {
      LectureReglementClient var1 = new LectureReglementClient();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.recupereReglementClient();
      this.mesTypeReglements = var1.getMesReglementClientItems();
      this.lesModeReglementClientsListe = var1.getMesReglementClient();
   }

   public void recupererNatureItem() throws IOException {
      this.mesNaturesItems = new ArrayList();
      LectureNatureMedical var1 = new LectureNatureMedical();
      this.mesNaturesItems = var1.getMesNatureMedicalItems();
   }

   public void recupererPecItem() throws IOException {
      this.mesCategoriesItems = new ArrayList();
      this.lesCategoriesListe = new ArrayList();
      LectureCategorieTiers var1 = new LectureCategorieTiers("034");
      this.mesCategoriesItems = var1.getMesCategoriesTiersItems();
      if (this.optionMedical.getTarifSociete().equals("2")) {
         this.mesCategoriesItems.add(new SelectItem(-2, "Société"));
      }

      if (this.structureLog.getStrcodepays().equals("0077")) {
         this.mesCategoriesItems.add(new SelectItem(-4, "CNAMGS"));
      }

      this.lesCategoriesListe = var1.getMesCategoriesTiers();
      ObjetCategories var2;
      if (this.optionMedical.getTarifSociete().equals("2")) {
         var2 = new ObjetCategories();
         var2.setCode("-2");
         var2.setLibelle_FR("Société");
         var2.setCoef(1.0F);
         this.lesCategoriesListe.add(var2);
      }

      if (this.structureLog.getStrcodepays().equals("0077")) {
         var2 = new ObjetCategories();
         var2.setCode("-4");
         var2.setLibelle_FR("CNAMGS");
         var2.setCoef(1.0F);
         this.lesCategoriesListe.add(var2);
      }

      this.var_tarif1 = "";
      this.var_tarif2 = "";
      this.var_tarif3 = "";
      this.var_tarif4 = "";
      this.var_tarif5 = "";
      this.var_tarif6 = "";
      this.var_tarif7 = "";
      this.var_tarif8 = "";
      this.var_tarif9 = "";
      this.var_tarif10 = "";
      this.var_aff_tarif1 = false;
      this.var_aff_tarif2 = false;
      this.var_aff_tarif3 = false;
      this.var_aff_tarif4 = false;
      this.var_aff_tarif5 = false;
      this.var_aff_tarif6 = false;
      this.var_aff_tarif7 = false;
      this.var_aff_tarif8 = false;
      this.var_aff_tarif9 = false;
      this.var_aff_tarif10 = false;

      for(int var3 = 0; var3 < this.lesCategoriesListe.size(); ++var3) {
         if (var3 == 0) {
            this.var_tarif1 = ((ObjetCategories)this.lesCategoriesListe.get(0)).getLibelle_FR();
            this.var_aff_tarif1 = true;
         } else if (var3 == 1) {
            this.var_tarif2 = ((ObjetCategories)this.lesCategoriesListe.get(1)).getLibelle_FR();
            this.var_aff_tarif2 = true;
         } else if (var3 == 2) {
            this.var_tarif3 = ((ObjetCategories)this.lesCategoriesListe.get(2)).getLibelle_FR();
            this.var_aff_tarif3 = true;
         } else if (var3 == 3) {
            this.var_tarif4 = ((ObjetCategories)this.lesCategoriesListe.get(3)).getLibelle_FR();
            this.var_aff_tarif4 = true;
         } else if (var3 == 4) {
            this.var_tarif5 = ((ObjetCategories)this.lesCategoriesListe.get(4)).getLibelle_FR();
            this.var_aff_tarif5 = true;
         } else if (var3 == 5) {
            this.var_tarif6 = ((ObjetCategories)this.lesCategoriesListe.get(5)).getLibelle_FR();
            this.var_aff_tarif6 = true;
         } else if (var3 == 6) {
            this.var_tarif7 = ((ObjetCategories)this.lesCategoriesListe.get(6)).getLibelle_FR();
            this.var_aff_tarif7 = true;
         } else if (var3 == 7) {
            this.var_tarif8 = ((ObjetCategories)this.lesCategoriesListe.get(7)).getLibelle_FR();
            this.var_aff_tarif8 = true;
         } else if (var3 == 8) {
            this.var_tarif9 = ((ObjetCategories)this.lesCategoriesListe.get(8)).getLibelle_FR();
            this.var_aff_tarif9 = true;
         } else if (var3 == 9) {
            this.var_tarif10 = ((ObjetCategories)this.lesCategoriesListe.get(9)).getLibelle_FR();
            this.var_aff_tarif10 = true;
         }
      }

   }

   public void recupererSerieUserItem(Session var1) throws HibernateException, NamingException {
      this.mesSerieUserItem = new ArrayList();
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      List var2 = this.usersChronoDao.selectListByUserNat(this.usersLog, this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (this.usersLog.getUsrJrxReserve() == 1) {
               if (((UsersChrono)var2.get(var3)).getUsrchrPrive() == 0) {
                  this.mesSerieUserItem.add(new SelectItem(((UsersChrono)var2.get(var3)).getUsrchrSerie()));
               }
            } else {
               this.mesSerieUserItem.add(new SelectItem(((UsersChrono)var2.get(var3)).getUsrchrSerie()));
            }
         }

         if (this.mesSerieUserItem.size() >= 2) {
            String var5 = "";

            for(int var4 = 0; var4 < this.mesSerieUserItem.size(); ++var4) {
               if (var5 != null && !var5.isEmpty()) {
                  var5 = var5 + "," + ((SelectItem)this.mesSerieUserItem.get(var4)).getValue().toString();
               } else {
                  var5 = ((SelectItem)this.mesSerieUserItem.get(var4)).getValue().toString();
               }
            }

            this.mesSerieUserItem.add(new SelectItem(var5, "Toutes séries"));
         }
      }

   }

   public void recupererMotifEntreeItem(Session var1) throws HibernateException, NamingException {
      this.lesMotifEntree = new ArrayList();
      this.mesMotifEntreeItems = new ArrayList();
      MotifEntreeMedicalDao var2 = new MotifEntreeMedicalDao(this.baseLog, this.utilInitHibernate);
      this.lesMotifEntree = var2.selectActifMotifentree(this.lastExoMedical.getExevteId(), var1);
      if (this.lesMotifEntree.size() != 0) {
         new MotifEntreeMedical();

         for(int var4 = 0; var4 < this.lesMotifEntree.size(); ++var4) {
            MotifEntreeMedical var3 = (MotifEntreeMedical)this.lesMotifEntree.get(var4);
            this.mesMotifEntreeItems.add(new SelectItem(var3.getMteCode() + ":" + var3.getMteLibelle()));
         }
      }

   }

   public void recupererPathologieItem(Session var1) throws HibernateException, NamingException {
      this.mesPathologieItems = new ArrayList();
      PathologieMedicalDao var2 = new PathologieMedicalDao(this.baseLog, this.utilInitHibernate);
      this.mesPathologieItems = var2.selectActifPathologieItems(this.lastExoMedical.getExevteId(), var1);
      if (this.mesPathologieItems.size() > 1) {
         this.var_affiche_pathologie = true;
      } else {
         this.var_affiche_pathologie = false;
      }

   }

   public void recupererProtocoleItem(Session var1) throws HibernateException, NamingException {
      this.mesProtocoleItems = new ArrayList();
      ProtocoleMedicalDao var2 = new ProtocoleMedicalDao(this.baseLog, this.utilInitHibernate);
      this.mesProtocoleItems = var2.selectActifProtocoleItems(this.lastExoMedical.getExevteId(), var1);
   }

   public void recupererAntecedentItem() throws IOException {
      this.mesAntecedentItems = new ArrayList();
      LectureAntecedentCDA var1 = new LectureAntecedentCDA();
      this.mesAntecedentItems = var1.getMesAntecedentCDAItems();
   }

   public void recupererTaxeItem(Session var1) throws HibernateException, NamingException {
      this.mesTaxesItems = new ArrayList();
      TaxesVentesDao var2 = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.mesTaxesItems = var2.selectActifTaxesItems(this.lastExoMedical.getExevteId(), var1);
   }

   public void recupererPrescripteurItem(Session var1) throws HibernateException, NamingException {
      this.mesPrescripteurItems = new ArrayList();
      TiersDao var2 = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.mesPrescripteurItems = var2.chargerLesPrescripteurItems(var1);
      if (this.mesPrescripteurItems.size() > 1) {
         this.var_affiche_prescipteur = true;
      } else {
         this.var_affiche_prescipteur = false;
      }

   }

   public void recupererFamilleProduitAchatsUtilItem(Session var1) throws HibernateException, NamingException {
      this.mesFamillesAchatsItems = new ArrayList();
      this.mesFamillesAchatsUtilItems = new ArrayList();
      new ExercicesAchats();
      ExercicesAchatsDao var3 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      ExercicesAchats var2 = var3.recupererLastExo(var1);
      if (var2 != null) {
         FamillesProduitsAchatsDao var4 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
         this.mesFamillesAchatsItems = var4.chargerFamilleProduitAchatsFamItems(var2.getExeachId(), var1);
         if (this.mesFamillesAchatsItems.size() == 0) {
            this.mesFamillesAchatsItems = var4.chargerFamilleProduitAchatsUtilItems(var2.getExeachId(), var1);
            this.mesFamillesAchatsUtilItems = this.mesFamillesAchatsItems;
         } else {
            this.mesFamillesAchatsUtilItems = var4.chargerFamilleProduitAchatsUtilItems(var2.getExeachId(), var1);
         }
      }

   }

   public void recupererFamilleProduitVentesItem(Session var1) throws HibernateException, NamingException {
      FamillesProduitsVentesDao var2 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.mesFamillesVentesItems = new ArrayList();
      this.mesFamillesVentesUtilItems = new ArrayList();
      this.mesFamillesVentesItems = var2.chargerFamilleProduitVentesItems(this.exoselectionne.getExevteId(), var1);
      if (this.mesFamillesVentesItems.size() == 0) {
         this.mesFamillesVentesItems = var2.chargerFamilleProduitVentesUtilItems(this.lastExoMedical.getExevteId(), var1);
         this.mesFamillesVentesUtilItems = this.mesFamillesVentesItems;
      } else {
         this.mesFamillesVentesUtilItems = var2.chargerFamilleProduitVentesUtilItems(this.lastExoMedical.getExevteId(), var1);
      }

      this.mesFamillesActesItems = new ArrayList();
      this.mesFamillesActesItems = var2.chargerFamilleProduitActesItems(this.exoselectionne.getExevteId(), var1);
      this.mesFamillesMedocItems = new ArrayList();
      this.mesFamillesMedocItems = var2.chargerFamilleProduitMedocItems(this.exoselectionne.getExevteId(), var1);
   }

   public void recupererModeleFicheProduit() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "produit" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.documentImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4];
               if (this.verificationAutorisation(var5)) {
                  String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.documentImpressionItems.add(new SelectItem(var6));
               }
            }
         }
      }

   }

   public void recupererModeleListeProduit() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "produit" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4];
               if (this.verificationAutorisation(var5)) {
                  String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.listeImpressionItems.add(new SelectItem(var6));
               }
            }
         }
      }

   }

   public void recupererModeleListeMouvements() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "mouvement" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionMvtsItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4];
               if (this.verificationAutorisation(var5)) {
                  String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.listeImpressionMvtsItems.add(new SelectItem(var6));
               }
            }
         }
      }

   }

   public void recupererModeleDocument() {
      String var1 = "";
      if (this.nature == 7) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "commission" + File.separator;
      } else if (this.nature != 70) {
         if (this.nature == 71) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "consultationGene" + File.separator;
         } else if (this.nature == 72) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "consultationSpe" + File.separator;
         } else if (this.nature == 73) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "pharmacie" + File.separator;
         } else if (this.nature == 74) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "laboratoire" + File.separator;
         } else if (this.nature == 741) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "paillasse" + File.separator;
         } else if (this.nature == 76) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "hospitalisation" + File.separator;
         } else if (this.nature == 77) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "devis" + File.separator;
         } else if (this.nature == 78) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "refacturation" + File.separator;
         } else if (this.nature == 79) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "bon_encaissement" + File.separator;
         } else if (this.nature == 181) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "note_debit" + File.separator;
         } else if (this.nature == 182) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "recapitulatif" + File.separator;
         }
      }

      if (this.nature == 7 || this.nature >= 71 && this.nature <= 79 || this.nature == 181 || this.nature == 182 || this.nature == 741) {
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         this.documentImpressionItems = new ArrayList();
         String[] var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  String var5 = var3[var4];
                  if (this.verificationAutorisation(var5)) {
                     String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                     this.documentImpressionItems.add(new SelectItem(var6));
                  }
               }
            }
         }
      }

   }

   public void recupererModeleListe() {
      String var1 = "";
      if (this.nature == 7) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "commission" + File.separator;
      } else if (this.nature != 70) {
         if (this.nature == 71) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "consultationGene" + File.separator;
         } else if (this.nature == 72) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "consultationSpe" + File.separator;
         } else if (this.nature == 73) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "pharmacie" + File.separator;
         } else if (this.nature == 74) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "laboratoire" + File.separator;
         } else if (this.nature == 741) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "paillasse" + File.separator;
         } else if (this.nature == 76) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "hospitalisation" + File.separator;
         } else if (this.nature == 77) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "devis" + File.separator;
         } else if (this.nature == 78) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "refacturation" + File.separator;
         } else if (this.nature == 79) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "bon_encaissement" + File.separator;
         } else if (this.nature == 181) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "note_debit" + File.separator;
         } else if (this.nature == 182) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "recapitulatif" + File.separator;
         }
      }

      if (this.nature == 7 || this.nature >= 71 && this.nature <= 79 || this.nature == 181 || this.nature == 182 || this.nature == 741) {
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         this.listeImpressionItems = new ArrayList();
         String[] var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  String var5 = var3[var4];
                  if (this.verificationAutorisation(var5)) {
                     String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                     this.listeImpressionItems.add(new SelectItem(var6));
                  }
               }
            }
         }
      }

   }

   public boolean verificationAutorisation(String var1) {
      boolean var2 = false;
      if (this.lesModelesAutorises != null && this.lesModelesAutorises.size() != 0) {
         for(int var3 = 0; var3 < this.lesModelesAutorises.size(); ++var3) {
            if (((String)this.lesModelesAutorises.get(var3)).toString().toLowerCase().contains(var1.toLowerCase())) {
               var2 = true;
               break;
            }
         }
      } else {
         var2 = true;
      }

      return var2;
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

   public void recupererConfigListeLigne() throws IOException {
      LectureConfigListeLigne var1 = new LectureConfigListeLigne();
      var1.recupereFonctions(this.structureLog.getStrid(), this.nature, "");
      this.configListeLigne = var1.getConfigListeLigne();
   }

   public void memoriseConfigListeLigne() throws IOException {
      LectureConfigListeLigne var1 = new LectureConfigListeLigne();
      String var2 = var1.calculeFichierConfig(this.structureLog.getStrid(), this.nature, "");
      if (var2 != null && !var2.isEmpty()) {
         Element var3 = new Element("configuration");
         Document var4 = new Document(var3);
         var3.removeContent();
         OptionConfigListe var5 = new OptionConfigListe();
         var5.setConfiguration(this.configListeLigne);
         Element var6 = new Element("configListe");
         var3.addContent(var6);
         var6.setText(var5.getConfiguration());
         XMLOutputter var7 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var8 = new FileOutputStream(StaticModePegase.getCheminContext() + var2);
         var7.output(var4, var8);
         var8.close();
      }

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

   public void listener(UploadEvent var1) throws NamingException, HibernateException, ParseException {
      this.item = var1.getUploadItem();
      this.fileCtrl = new FileCtrl();
      this.fileCtrl.setLength(this.item.getFileSize());
      this.fileCtrl.setName(this.item.getFileName());
      this.fileCtrl.setChemin(this.item.getFile().getPath().toString());
      this.fileCtrl.setData(this.item.getData());
      this.listFiles.add(this.fileCtrl);
      --this.uploadsAvailable;
      this.importationFichier();
   }

   public void importationFichier() throws NamingException, HibernateException, ParseException {
      try {
         ArrayList var1 = new ArrayList();
         if (this.listFiles.size() != 0) {
            for(int var2 = 0; var2 < this.listFiles.size(); ++var2) {
               this.fileCtrl = (FileCtrl)this.listFiles.get(var2);
               File var3 = new File(this.fileCtrl.getChemin());
               new Salaries();
               if (var3.exists()) {
                  FileReader var5 = new FileReader(var3);
                  BufferedReader var6 = new BufferedReader(var5);

                  for(String var7 = var6.readLine(); var7 != null; var7 = var6.readLine()) {
                     if (var7.contains("\"")) {
                        char[] var8 = var7.toCharArray();
                        String var9 = "";

                        for(int var10 = 0; var10 < var8.length; ++var10) {
                           if (var8[var10] != '"') {
                              var9 = var9 + var8[var10];
                           }
                        }

                        var7 = var9;
                     }

                     if (var7.contains("'")) {
                        var7.replace("'", "`");
                     }

                     Salaries var4 = new Salaries();
                     var4.setSalActivite(var7);
                     var1.add(var4);
                  }

                  var6.close();
                  var5.close();
                  var3.delete();
               }
            }
         }

         if (var1.size() != 0) {
            this.preparationTransfertSalariesImport(var1);
         }
      } catch (IOException var11) {
         var11.printStackTrace();
      }

   }

   public void importFtp() {
   }

   public void importPayeePegase() throws HibernateException, NamingException, IOException, ParseException {
      new ArrayList();
      SalariesDao var2 = new SalariesDao(this.baseLog, this.utilInitHibernate);
      List var1 = var2.chargerlesSalariesTous((Session)null);
      if (var1.size() != 0) {
         this.preparationTransfertSalariesImport(var1);
      }

   }

   public void importEducationPegase() throws HibernateException, NamingException, IOException, ParseException {
      new ArrayList();
      ElevesDao var2 = new ElevesDao(this.baseLog, this.utilInitHibernate);
      List var1 = var2.chargerlesEleves("*", (Session)null);
      if (var1.size() != 0) {
         this.preparationTransfertEevesImport(var1);
      }

   }

   public void preparationTransfertSalariesImport(List var1) throws IOException, NamingException, HibernateException, ParseException {
      this.formTransfertMedical = new FormTransfertMedical();
      this.formTransfertMedical.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertMedical.setBaseLog(this.baseLog);
      this.formTransfertMedical.setStructureLog(this.structureLog);
      this.formTransfertMedical.setUsersLog(this.usersLog);
      this.formTransfertMedical.InstancesDaoUtilses();
      this.formTransfertMedical.setOptionMedical(this.optionMedical);
      this.formTransfertMedical.setExercicesVentes(this.exoselectionne);
      this.formTransfertMedical.transfertSalariesImport(var1);
      this.affichePage = "/medical/TransfertMedical.jsp";
   }

   public void preparationTransfertEevesImport(List var1) throws IOException, NamingException, HibernateException, ParseException {
      this.formTransfertMedical = new FormTransfertMedical();
      this.formTransfertMedical.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertMedical.setBaseLog(this.baseLog);
      this.formTransfertMedical.setStructureLog(this.structureLog);
      this.formTransfertMedical.setUsersLog(this.usersLog);
      this.formTransfertMedical.InstancesDaoUtilses();
      this.formTransfertMedical.setOptionMedical(this.optionMedical);
      this.formTransfertMedical.setExercicesVentes(this.exoselectionne);
      this.formTransfertMedical.transfertElevesImport(var1);
      this.affichePage = "/medical/TransfertMedical.jsp";
   }

   public FormExercicesMedical getFormExercicesMedical() {
      return this.formExercicesMedical;
   }

   public void setFormExercicesMedical(FormExercicesMedical var1) {
      this.formExercicesMedical = var1;
   }

   public LectureModulesOnglets getLesOnglets() {
      return this.lesOnglets;
   }

   public void setLesOnglets(LectureModulesOnglets var1) {
      this.lesOnglets = var1;
   }

   public MenudroitMedicalCtrl getMenudroitMedicalCtrl() {
      return this.menudroitMedicalCtrl;
   }

   public void setMenudroitMedicalCtrl(MenudroitMedicalCtrl var1) {
      this.menudroitMedicalCtrl = var1;
   }

   public ObjetLigneMenu getMenumedical() {
      return this.menumedical;
   }

   public void setMenumedical(ObjetLigneMenu var1) {
      this.menumedical = var1;
   }

   public String getAffichePage() {
      return this.affichePage;
   }

   public void setAffichePage(String var1) {
      this.affichePage = var1;
   }

   public FormProduitsMedical getFormProduitsMedical() {
      return this.formProduitsMedical;
   }

   public void setFormProduitsMedical(FormProduitsMedical var1) {
      this.formProduitsMedical = var1;
   }

   public FormConsultationGene getFormConsultationGene() {
      return this.formConsultationGene;
   }

   public void setFormConsultationGene(FormConsultationGene var1) {
      this.formConsultationGene = var1;
   }

   public long getLeIdExo() {
      return this.leIdExo;
   }

   public void setLeIdExo(long var1) {
      this.leIdExo = var1;
   }

   public ExercicesVentes getExoselectionne() {
      return this.exoselectionne;
   }

   public void setExoselectionne(ExercicesVentes var1) {
      this.exoselectionne = var1;
   }

   public ExercicesVentes getLastExoMedical() {
      return this.lastExoMedical;
   }

   public void setLastExoMedical(ExercicesVentes var1) {
      this.lastExoMedical = var1;
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

   public List getMesActivitesItems() {
      return this.mesActivitesItems;
   }

   public void setMesActivitesItems(List var1) {
      this.mesActivitesItems = var1;
   }

   public List getMesAntecedentItems() {
      return this.mesAntecedentItems;
   }

   public void setMesAntecedentItems(List var1) {
      this.mesAntecedentItems = var1;
   }

   public List getMesBanquesItems() {
      return this.mesBanquesItems;
   }

   public void setMesBanquesItems(List var1) {
      this.mesBanquesItems = var1;
   }

   public List getMesBudgetsItems() {
      return this.mesBudgetsItems;
   }

   public void setMesBudgetsItems(List var1) {
      this.mesBudgetsItems = var1;
   }

   public List getMesCommerciauxItems() {
      return this.mesCommerciauxItems;
   }

   public void setMesCommerciauxItems(List var1) {
      this.mesCommerciauxItems = var1;
   }

   public List getMesCompteProduitsItems() {
      return this.mesCompteProduitsItems;
   }

   public void setMesCompteProduitsItems(List var1) {
      this.mesCompteProduitsItems = var1;
   }

   public List getMesCompteStocksItems() {
      return this.mesCompteStocksItems;
   }

   public void setMesCompteStocksItems(List var1) {
      this.mesCompteStocksItems = var1;
   }

   public List getMesCompteVteHzItems() {
      return this.mesCompteVteHzItems;
   }

   public void setMesCompteVteHzItems(List var1) {
      this.mesCompteVteHzItems = var1;
   }

   public List getMesCompteVteLocItems() {
      return this.mesCompteVteLocItems;
   }

   public void setMesCompteVteLocItems(List var1) {
      this.mesCompteVteLocItems = var1;
   }

   public List getMesCompteVteZItems() {
      return this.mesCompteVteZItems;
   }

   public void setMesCompteVteZItems(List var1) {
      this.mesCompteVteZItems = var1;
   }

   public List getMesConditionnementsItems() {
      return this.mesConditionnementsItems;
   }

   public void setMesConditionnementsItems(List var1) {
      this.mesConditionnementsItems = var1;
   }

   public List getMesCreateursItems() {
      return this.mesCreateursItems;
   }

   public void setMesCreateursItems(List var1) {
      this.mesCreateursItems = var1;
   }

   public List getMesDepartementsItems() {
      return this.mesDepartementsItems;
   }

   public void setMesDepartementsItems(List var1) {
      this.mesDepartementsItems = var1;
   }

   public List getMesDepotItems() {
      return this.mesDepotItems;
   }

   public void setMesDepotItems(List var1) {
      this.mesDepotItems = var1;
   }

   public List getMesFamillesVentesItems() {
      return this.mesFamillesVentesItems;
   }

   public void setMesFamillesVentesItems(List var1) {
      this.mesFamillesVentesItems = var1;
   }

   public List getMesFormulesItems() {
      return this.mesFormulesItems;
   }

   public void setMesFormulesItems(List var1) {
      this.mesFormulesItems = var1;
   }

   public List getMesLettresItems() {
      return this.mesLettresItems;
   }

   public void setMesLettresItems(List var1) {
      this.mesLettresItems = var1;
   }

   public List getMesMarquesItems() {
      return this.mesMarquesItems;
   }

   public void setMesMarquesItems(List var1) {
      this.mesMarquesItems = var1;
   }

   public List getMesMotifEntreeItems() {
      return this.mesMotifEntreeItems;
   }

   public void setMesMotifEntreeItems(List var1) {
      this.mesMotifEntreeItems = var1;
   }

   public List getMesNaturesItems() {
      return this.mesNaturesItems;
   }

   public void setMesNaturesItems(List var1) {
      this.mesNaturesItems = var1;
   }

   public List getMesPathologieItems() {
      return this.mesPathologieItems;
   }

   public void setMesPathologieItems(List var1) {
      this.mesPathologieItems = var1;
   }

   public List getMesPdvItems() {
      return this.mesPdvItems;
   }

   public void setMesPdvItems(List var1) {
      this.mesPdvItems = var1;
   }

   public List getMesCategoriesItems() {
      return this.mesCategoriesItems;
   }

   public void setMesCategoriesItems(List var1) {
      this.mesCategoriesItems = var1;
   }

   public List getMesPrescripteurItems() {
      return this.mesPrescripteurItems;
   }

   public void setMesPrescripteurItems(List var1) {
      this.mesPrescripteurItems = var1;
   }

   public List getMesProtocoleItems() {
      return this.mesProtocoleItems;
   }

   public void setMesProtocoleItems(List var1) {
      this.mesProtocoleItems = var1;
   }

   public List getMesRegionsItems() {
      return this.mesRegionsItems;
   }

   public void setMesRegionsItems(List var1) {
      this.mesRegionsItems = var1;
   }

   public List getMesSecteursItems() {
      return this.mesSecteursItems;
   }

   public void setMesSecteursItems(List var1) {
      this.mesSecteursItems = var1;
   }

   public List getMesSerieUserItem() {
      return this.mesSerieUserItem;
   }

   public void setMesSerieUserItem(List var1) {
      this.mesSerieUserItem = var1;
   }

   public List getMesServices2Items() {
      return this.mesServices2Items;
   }

   public void setMesServices2Items(List var1) {
      this.mesServices2Items = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public List getMesSitesItems() {
      return this.mesSitesItems;
   }

   public void setMesSitesItems(List var1) {
      this.mesSitesItems = var1;
   }

   public List getMesTaxesItems() {
      return this.mesTaxesItems;
   }

   public void setMesTaxesItems(List var1) {
      this.mesTaxesItems = var1;
   }

   public List getMesTypeReglements() {
      return this.mesTypeReglements;
   }

   public void setMesTypeReglements(List var1) {
      this.mesTypeReglements = var1;
   }

   public List getMesUnitesItems() {
      return this.mesUnitesItems;
   }

   public void setMesUnitesItems(List var1) {
      this.mesUnitesItems = var1;
   }

   public List getMesdevisesItem() {
      return this.mesdevisesItem;
   }

   public void setMesdevisesItem(List var1) {
      this.mesdevisesItem = var1;
   }

   public List getDocumentImpressionItems() {
      return this.documentImpressionItems;
   }

   public void setDocumentImpressionItems(List var1) {
      this.documentImpressionItems = var1;
   }

   public List getListeImpressionItems() {
      return this.listeImpressionItems;
   }

   public void setListeImpressionItems(List var1) {
      this.listeImpressionItems = var1;
   }

   public List getListeImpressionMvtsItems() {
      return this.listeImpressionMvtsItems;
   }

   public void setListeImpressionMvtsItems(List var1) {
      this.listeImpressionMvtsItems = var1;
   }

   public String getMessageAlerte() {
      return this.messageAlerte;
   }

   public void setMessageAlerte(String var1) {
      this.messageAlerte = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public List getMesEtatsItems() {
      return this.mesEtatsItems;
   }

   public void setMesEtatsItems(List var1) {
      this.mesEtatsItems = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public FormImpressionMedicales getFormImpressionMedicales() {
      return this.formImpressionMedicales;
   }

   public void setFormImpressionMedicales(FormImpressionMedicales var1) {
      this.formImpressionMedicales = var1;
   }

   public List getMesFamillesActesItems() {
      return this.mesFamillesActesItems;
   }

   public void setMesFamillesActesItems(List var1) {
      this.mesFamillesActesItems = var1;
   }

   public List getMesFamillesMedocItems() {
      return this.mesFamillesMedocItems;
   }

   public void setMesFamillesMedocItems(List var1) {
      this.mesFamillesMedocItems = var1;
   }

   public FormPlanning getFormPlanning() {
      return this.formPlanning;
   }

   public void setFormPlanning(FormPlanning var1) {
      this.formPlanning = var1;
   }

   public FormHospitalisation getFormHospitalisation() {
      return this.formHospitalisation;
   }

   public void setFormHospitalisation(FormHospitalisation var1) {
      this.formHospitalisation = var1;
   }

   public FormLaboratoire getFormLaboratoire() {
      return this.formLaboratoire;
   }

   public void setFormLaboratoire(FormLaboratoire var1) {
      this.formLaboratoire = var1;
   }

   public List getMesLaboratoiresItems() {
      return this.mesLaboratoiresItems;
   }

   public void setMesLaboratoiresItems(List var1) {
      this.mesLaboratoiresItems = var1;
   }

   public FormPharmacie getFormPharmacie() {
      return this.formPharmacie;
   }

   public void setFormPharmacie(FormPharmacie var1) {
      this.formPharmacie = var1;
   }

   public List getMesPharmaciesItems() {
      return this.mesPharmaciesItems;
   }

   public void setMesPharmaciesItems(List var1) {
      this.mesPharmaciesItems = var1;
   }

   public List getMesFamillesVentesUtilItems() {
      return this.mesFamillesVentesUtilItems;
   }

   public void setMesFamillesVentesUtilItems(List var1) {
      this.mesFamillesVentesUtilItems = var1;
   }

   public FormTransfertMedical getFormTransfertMedical() {
      return this.formTransfertMedical;
   }

   public void setFormTransfertMedical(FormTransfertMedical var1) {
      this.formTransfertMedical = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public Patients getPatientsEnCours() {
      return this.patientsEnCours;
   }

   public void setPatientsEnCours(Patients var1) {
      this.patientsEnCours = var1;
   }

   public FormRefacturation getFormRefacturation() {
      return this.formRefacturation;
   }

   public void setFormRefacturation(FormRefacturation var1) {
      this.formRefacturation = var1;
   }

   public FormDevisMedical getFormDevisMedical() {
      return this.formDevisMedical;
   }

   public void setFormDevisMedical(FormDevisMedical var1) {
      this.formDevisMedical = var1;
   }

   public FormBonEncaissementMedical getFormBonEncaissementMedical() {
      return this.formBonEncaissementMedical;
   }

   public void setFormBonEncaissementMedical(FormBonEncaissementMedical var1) {
      this.formBonEncaissementMedical = var1;
   }

   public FormPatients getFormPatients() {
      return this.formPatients;
   }

   public void setFormPatients(FormPatients var1) {
      this.formPatients = var1;
   }

   public FormDocumentsOfficiels getFormDocumentsOfficiels() {
      return this.formDocumentsOfficiels;
   }

   public void setFormDocumentsOfficiels(FormDocumentsOfficiels var1) {
      this.formDocumentsOfficiels = var1;
   }

   public List getMesFamilleClientsItems() {
      return this.mesFamilleClientsItems;
   }

   public void setMesFamilleClientsItems(List var1) {
      this.mesFamilleClientsItems = var1;
   }

   public List getMesFamillesAchatsItems() {
      return this.mesFamillesAchatsItems;
   }

   public void setMesFamillesAchatsItems(List var1) {
      this.mesFamillesAchatsItems = var1;
   }

   public List getMesFamillesAchatsUtilItems() {
      return this.mesFamillesAchatsUtilItems;
   }

   public void setMesFamillesAchatsUtilItems(List var1) {
      this.mesFamillesAchatsUtilItems = var1;
   }

   public int getUploadsAvailable() {
      return this.uploadsAvailable;
   }

   public void setUploadsAvailable(int var1) {
      this.uploadsAvailable = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public String getConfigListeEntete() {
      return this.configListeEntete;
   }

   public void setConfigListeEntete(String var1) {
      this.configListeEntete = var1;
   }

   public String getConfigListeLigne() {
      return this.configListeLigne;
   }

   public void setConfigListeLigne(String var1) {
      this.configListeLigne = var1;
   }

   public FormCommissionsMedicales getFormCommissionsMedicales() {
      return this.formCommissionsMedicales;
   }

   public void setFormCommissionsMedicales(FormCommissionsMedicales var1) {
      this.formCommissionsMedicales = var1;
   }

   public boolean isInfirmerie() {
      return this.infirmerie;
   }

   public void setInfirmerie(boolean var1) {
      this.infirmerie = var1;
   }

   public FormNoteDebitMedical getFormNoteDebitMedical() {
      return this.formNoteDebitMedical;
   }

   public void setFormNoteDebitMedical(FormNoteDebitMedical var1) {
      this.formNoteDebitMedical = var1;
   }

   public DataModel getDataModelDocument() {
      return this.dataModelDocument;
   }

   public void setDataModelDocument(DataModel var1) {
      this.dataModelDocument = var1;
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

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
   }

   public double getReglActe() {
      return this.reglActe;
   }

   public void setReglActe(double var1) {
      this.reglActe = var1;
   }

   public double getReglCaisse() {
      return this.reglCaisse;
   }

   public void setReglCaisse(double var1) {
      this.reglCaisse = var1;
   }

   public double getTotalEntete() {
      return this.totalEntete;
   }

   public void setTotalEntete(double var1) {
      this.totalEntete = var1;
   }

   public double getTotalLigne() {
      return this.totalLigne;
   }

   public void setTotalLigne(double var1) {
      this.totalLigne = var1;
   }

   public List getMesMedecinsItems() {
      return this.mesMedecinsItems;
   }

   public void setMesMedecinsItems(List var1) {
      this.mesMedecinsItems = var1;
   }

   public long getVar_memo_id_master() {
      return this.var_memo_id_master;
   }

   public void setVar_memo_id_master(long var1) {
      this.var_memo_id_master = var1;
   }
}
