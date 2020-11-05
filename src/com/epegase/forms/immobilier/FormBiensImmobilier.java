package com.epegase.forms.immobilier;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienHistorique;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.BlocImmeuble;
import com.epegase.systeme.dao.BienBailDao;
import com.epegase.systeme.dao.BienDao;
import com.epegase.systeme.dao.BienGeranceLigneDao;
import com.epegase.systeme.dao.BienHistoriqueDao;
import com.epegase.systeme.dao.BienTravauxEnteteDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilGoogleMap;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LecturePays;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.ObjetPays;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;

public class FormBiensImmobilier implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private boolean var_aff_action = false;
   private int nature;
   private int categorieModule;
   private int categorieReelle;
   private String nomOngletActif;
   private String libelleCategorie;
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
   private boolean var_acc_villa;
   private boolean var_acc_appartement;
   private boolean var_acc_immeuble;
   private boolean var_acc_bureau;
   private boolean var_acc_commerce;
   private boolean var_acc_garage;
   private boolean var_acc_hanger;
   private boolean var_acc_usine;
   private boolean var_acc_box;
   private boolean var_acc_terrain;
   private boolean var_acc_chambre;
   private boolean showModalPanelTransfert = false;
   private int var_imput_cat;
   private transient DataModel datamodelVilla = new ListDataModel();
   private transient DataModel datamodelAppartement = new ListDataModel();
   private transient DataModel datamodelImmeuble = new ListDataModel();
   private transient DataModel datamodelBureau = new ListDataModel();
   private transient DataModel datamodelCommerce = new ListDataModel();
   private transient DataModel datamodelGarage = new ListDataModel();
   private transient DataModel datamodelHangar = new ListDataModel();
   private transient DataModel datamodelUsine = new ListDataModel();
   private transient DataModel datamodelBox = new ListDataModel();
   private transient DataModel datamodelTerrain = new ListDataModel();
   private transient DataModel datamodelChambre = new ListDataModel();
   private transient DataModel datamodelDetailAppartement = new ListDataModel();
   private transient DataModel datamodelDetailBureau;
   private transient DataModel datamodelDetailParking;
   private List listVilla = new ArrayList();
   private List listAppartement = new ArrayList();
   private List listImmeuble = new ArrayList();
   private List listBureau = new ArrayList();
   private List listCommerce = new ArrayList();
   private List listGarage = new ArrayList();
   private List listHangar = new ArrayList();
   private List listUsine = new ArrayList();
   private List listBox = new ArrayList();
   private List listTerrain = new ArrayList();
   private List listChambre = new ArrayList();
   private List lesImmeublesItems = new ArrayList();
   private Bien bien = new Bien();
   private BienDao bienDao;
   private boolean visibiliteBton = false;
   private Tiers tiers;
   private TiersDao tiersDao;
   private boolean var_aff_detail_tiers = false;
   private boolean var_valide_doc = false;
   private boolean var_code_unique = false;
   private int selctionTypeBien = 0;
   private String var_activeTab = "tabVilla";
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
   private int etat = 9;
   private Users responsable;
   private long var_nom_commercial;
   private boolean showModalPanelPrint = false;
   private String montant_lettre;
   private boolean showModalGoogleMap = false;
   private URI uri;
   private List lesPhotos;
   private transient DataModel dataModelPhotos;
   private boolean showModalPanelPhoto = false;
   private boolean var_affiche_photo = false;
   private String accesPhoto;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private UploadedFile uploadedFile;
   private UtilDownload utilDownload;
   private int numLignePhoto;
   private List lesBaux;
   private transient DataModel dataModelBaux;
   private BienBailDao bienBailDao;
   private List lesGerances;
   private transient DataModel dataModelGerance;
   private BienGeranceLigneDao bienGeranceLigneDao;
   private List lesTravaux;
   private transient DataModel dataModelTravaux;
   private BienTravauxEnteteDao bienTravauxEnteteDao;
   private boolean showModalPanelMessage = false;
   private String texteMessage;
   private BlocImmeuble blocImmeuble;
   private List lesBlocs;
   private transient DataModel dataModelBlocs;
   private boolean showModalPanelAppartement = false;
   private boolean showModalPanelBureau = false;
   private boolean showModalPanelParking = false;
   private Bien bienAppartement;
   private Bien bienBureau;
   private Bien bienParking;
   private boolean visibiliteBtonAppart = false;
   private boolean visibiliteBtonBureau = false;
   private boolean visibiliteBtonPrking = false;
   private List mesBlocsItems;
   private List lesDetailsApartement;
   private List lesDetailsBureau;
   private List lesDetailsParking;
   private String fileName;
   private String urlphotoAgent;
   private UploadedFile uploadedPDFFile;
   private String pdfFileName;
   private String fichierMine;
   private URL fichierUrl;
   private String urlExplorateur;
   private transient DataModel dataModelDocumnts;
   private List lesDocuments;
   private String nomRepertoire;
   private boolean showModalPanelPj = false;
   private boolean showModalPanelAjoutFile = false;
   private String nomDocument;
   private transient DataModel dataModelHistorique;
   private List lesHistoriques;
   private BienHistorique bienHistorique;
   private BienHistoriqueDao bienHistoriqueDao;
   private boolean showModalPanelHistorique = false;
   private Tiers tiersNew;
   private Tiers tiersOld;
   private boolean visibleHistorique = false;
   private List mesProprietaires;

   public FormBiensImmobilier() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.lesPhotos = new ArrayList();
      this.dataModelPhotos = new ListDataModel();
      this.utilDownload = new UtilDownload();
      this.lesBaux = new ArrayList();
      this.dataModelBaux = new ListDataModel();
      this.lesGerances = new ArrayList();
      this.dataModelGerance = new ListDataModel();
      this.lesTravaux = new ArrayList();
      this.dataModelTravaux = new ListDataModel();
      this.lesBlocs = new ArrayList();
      this.dataModelBlocs = new ListDataModel();
      this.mesBlocsItems = new ArrayList();
      this.lesDetailsApartement = new ArrayList();
      this.lesDetailsBureau = new ArrayList();
      this.lesDetailsParking = new ArrayList();
      this.dataModelDocumnts = new ListDataModel();
      this.lesDocuments = new ArrayList();
      this.dataModelHistorique = new ListDataModel();
      this.lesHistoriques = new ArrayList();
      this.mesProprietaires = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.bienDao = new BienDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.bienBailDao = new BienBailDao(this.baseLog, this.utilInitHibernate);
      this.bienGeranceLigneDao = new BienGeranceLigneDao(this.baseLog, this.utilInitHibernate);
      this.bienTravauxEnteteDao = new BienTravauxEnteteDao(this.baseLog, this.utilInitHibernate);
      this.bienHistoriqueDao = new BienHistoriqueDao(this.baseLog, this.utilInitHibernate);
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

      this.usersChrono = new UsersChrono();
      this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
      this.showModalPanelAppartement = false;
      if (this.categorieModule == 0) {
         this.libelleCategorie = "LOCATION";
      } else if (this.categorieModule == 1) {
         this.libelleCategorie = "SYNDIC";
         this.selctionTypeBien = 2;
         this.var_activeTab = "tabImmeuble";
      } else if (this.categorieModule == 2) {
         this.libelleCategorie = "NEGOCE";
      } else if (this.categorieModule == 3) {
         this.libelleCategorie = "PROMOTEUR";
      }

   }

   public void accesResteintUser() {
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

   public void googleMap() throws IOException, URISyntaxException {
      if (this.bien != null) {
         UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
         this.uri = var1.calculMap(this.bien.getBieRue(), this.bien.getBieAdresse(), this.bien.getBieVille(), this.bien.getBieNomPays());
         this.showModalGoogleMap = true;
      }

   }

   public void annuleGoogleMap() {
      this.showModalGoogleMap = false;
   }

   public void selectionPays() {
      if (this.bien.getBieNomPays() != null && !this.bien.getBieNomPays().isEmpty()) {
         this.bien.setBieCodePays("");
         LecturePays var1 = new LecturePays();
         if (var1.getMespays().size() != 0) {
            for(int var2 = 0; var2 < var1.getMespays().size(); ++var2) {
               if (((ObjetPays)var1.getMespays().get(var2)).getNom_FR().equalsIgnoreCase(this.bien.getBieNomPays())) {
                  this.bien.setBieCodePays(((ObjetPays)var1.getMespays().get(var2)).getIdentification());
                  break;
               }
            }
         }
      }

   }

   public void chargerBiens() throws HibernateException, NamingException {
      this.chargerBiens((Session)null);
   }

   public void chargerBiens(Session var1) throws HibernateException, NamingException {
      this.listVilla.clear();
      this.listAppartement.clear();
      this.listImmeuble.clear();
      this.listBureau.clear();
      this.listCommerce.clear();
      this.listGarage.clear();
      this.listHangar.clear();
      this.listUsine.clear();
      this.listBox.clear();
      this.listTerrain.clear();
      this.listChambre.clear();
      if (this.etat != 9) {
         new ArrayList();
         List var2 = this.bienDao.chargeBien(this.categorieModule, this.etat, var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.bien = (Bien)var2.get(var3);
               if (this.bien.getBieType() == 0) {
                  this.listVilla.add(this.bien);
               } else if (this.bien.getBieType() == 1) {
                  this.listAppartement.add(this.bien);
               } else if (this.bien.getBieType() == 2) {
                  this.listImmeuble.add(this.bien);
               } else if (this.bien.getBieType() == 3) {
                  this.listBureau.add(this.bien);
               } else if (this.bien.getBieType() == 4) {
                  this.listCommerce.add(this.bien);
               } else if (this.bien.getBieType() == 5) {
                  this.listGarage.add(this.bien);
               } else if (this.bien.getBieType() == 6) {
                  this.listHangar.add(this.bien);
               } else if (this.bien.getBieType() == 7) {
                  this.listUsine.add(this.bien);
               } else if (this.bien.getBieType() == 8) {
                  this.listBox.add(this.bien);
               } else if (this.bien.getBieType() == 9) {
                  this.listTerrain.add(this.bien);
               } else if (this.bien.getBieType() == 10) {
                  this.listChambre.add(this.bien);
               }
            }
         }
      }

      this.datamodelVilla.setWrappedData(this.listVilla);
      this.datamodelAppartement.setWrappedData(this.listAppartement);
      this.datamodelImmeuble.setWrappedData(this.listImmeuble);
      this.datamodelBureau.setWrappedData(this.listBureau);
      this.datamodelCommerce.setWrappedData(this.listCommerce);
      this.datamodelGarage.setWrappedData(this.listGarage);
      this.datamodelHangar.setWrappedData(this.listHangar);
      this.datamodelUsine.setWrappedData(this.listUsine);
      this.datamodelBox.setWrappedData(this.listBox);
      this.datamodelTerrain.setWrappedData(this.listTerrain);
      this.datamodelChambre.setWrappedData(this.listChambre);
   }

   public void clickVilla() {
      this.selctionTypeBien = 0;
      this.var_activeTab = "tabVilla";
   }

   public void clickAppartement() {
      this.selctionTypeBien = 1;
      this.var_activeTab = "tabAppartement";
   }

   public void clickImmeuble() {
      this.selctionTypeBien = 2;
      this.var_activeTab = "tabImmeuble";
   }

   public void clickBureau() {
      this.selctionTypeBien = 3;
      this.var_activeTab = "tabBureau";
   }

   public void clickCommerce() {
      this.selctionTypeBien = 4;
      this.var_activeTab = "tabCommerce";
   }

   public void clickGarage() {
      this.selctionTypeBien = 5;
      this.var_activeTab = "tabGarage";
   }

   public void clickHangar() {
      this.selctionTypeBien = 6;
      this.var_activeTab = "tabHangar";
   }

   public void clickUsine() {
      this.selctionTypeBien = 7;
      this.var_activeTab = "tabUsine";
   }

   public void clickBox() {
      this.selctionTypeBien = 8;
      this.var_activeTab = "tabBox";
   }

   public void clickTerrain() {
      this.selctionTypeBien = 9;
      this.var_activeTab = "tabTerrain";
   }

   public void clickChambre() {
      this.selctionTypeBien = 10;
      this.var_activeTab = "tabChambre";
   }

   public void selectionLigne() throws HibernateException, NamingException, IOException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      this.datamodelDetailAppartement = new ListDataModel();
      this.datamodelDetailBureau = new ListDataModel();
      this.datamodelDetailParking = new ListDataModel();
      this.visibiliteBtonAppart = false;
      this.visibiliteBtonBureau = false;
      this.visibiliteBtonPrking = false;
      if (this.selctionTypeBien == 0 && this.datamodelVilla.isRowAvailable()) {
         this.bien = (Bien)this.datamodelVilla.getRowData();
      } else {
         List var2;
         int var3;
         if (this.selctionTypeBien == 1 && this.datamodelAppartement.isRowAvailable()) {
            this.bien = (Bien)this.datamodelAppartement.getRowData();
            new ArrayList();
            var2 = this.bienDao.chargeBienByType(0, 2, var1);
            if (var2.size() != 0) {
               for(var3 = 0; var3 < var2.size(); ++var3) {
                  this.lesImmeublesItems.add(new SelectItem(((Bien)var2.get(var3)).getBieId(), ((Bien)var2.get(var3)).getBieNum() + ":" + ((Bien)var2.get(var3)).getBieNom()));
               }
            }
         } else if (this.selctionTypeBien == 2 && this.datamodelImmeuble.isRowAvailable()) {
            this.bien = (Bien)this.datamodelImmeuble.getRowData();
            this.chargerLesBlocs();
            this.mesBlocsItems.clear();
            if (this.lesBlocs.size() != 0) {
               for(int var4 = 0; var4 < this.lesBlocs.size(); ++var4) {
                  this.blocImmeuble = (BlocImmeuble)this.lesBlocs.get(var4);
                  this.mesBlocsItems.add(new SelectItem(this.blocImmeuble.getCode()));
               }
            } else {
               this.mesBlocsItems.add(new SelectItem(""));
            }

            this.nomOngletActif = "tabIdentification";
            this.lesDetailsApartement.clear();
            this.lesDetailsBureau.clear();
            this.lesDetailsParking.clear();
            new ArrayList();
            var2 = this.bienDao.chargeBienDetail(this.bien.getBieId(), var1);
            if (var2.size() != 0) {
               for(var3 = 0; var3 < var2.size(); ++var3) {
                  if (((Bien)var2.get(var3)).getBieType() == 3) {
                     this.lesDetailsBureau.add(var2.get(var3));
                  } else if (((Bien)var2.get(var3)).getBieType() == 5) {
                     this.lesDetailsParking.add(var2.get(var3));
                  } else {
                     this.lesDetailsApartement.add(var2.get(var3));
                  }
               }
            }

            this.datamodelDetailAppartement.setWrappedData(this.lesDetailsApartement);
            this.datamodelDetailBureau.setWrappedData(this.lesDetailsBureau);
            this.datamodelDetailParking.setWrappedData(this.lesDetailsParking);
            this.chargerLesBlocs();
         } else if (this.selctionTypeBien == 3 && this.datamodelBureau.isRowAvailable()) {
            this.bien = (Bien)this.datamodelBureau.getRowData();
            new ArrayList();
            var2 = this.bienDao.chargeBienByType(0, 2, var1);
            if (var2.size() != 0) {
               for(var3 = 0; var3 < var2.size(); ++var3) {
                  this.lesImmeublesItems.add(new SelectItem(((Bien)var2.get(var3)).getBieId(), ((Bien)var2.get(var3)).getBieNum() + ":" + ((Bien)var2.get(var3)).getBieNom()));
               }
            }
         } else if (this.selctionTypeBien == 4 && this.datamodelCommerce.isRowAvailable()) {
            this.bien = (Bien)this.datamodelCommerce.getRowData();
         } else if (this.selctionTypeBien == 5 && this.datamodelGarage.isRowAvailable()) {
            this.bien = (Bien)this.datamodelGarage.getRowData();
         } else if (this.selctionTypeBien == 6 && this.datamodelHangar.isRowAvailable()) {
            this.bien = (Bien)this.datamodelHangar.getRowData();
         } else if (this.selctionTypeBien == 7 && this.datamodelUsine.isRowAvailable()) {
            this.bien = (Bien)this.datamodelUsine.getRowData();
         } else if (this.selctionTypeBien == 8 && this.datamodelBox.isRowAvailable()) {
            this.bien = (Bien)this.datamodelBox.getRowData();
         } else if (this.selctionTypeBien == 9 && this.datamodelTerrain.isRowAvailable()) {
            this.bien = (Bien)this.datamodelTerrain.getRowData();
         } else if (this.selctionTypeBien == 10 && this.datamodelChambre.isRowAvailable()) {
            this.bien = (Bien)this.datamodelChambre.getRowData();
            new ArrayList();
            var2 = this.bienDao.chargeBienByType(0, 2, var1);
            if (var2.size() != 0) {
               for(var3 = 0; var3 < var2.size(); ++var3) {
                  this.lesImmeublesItems.add(new SelectItem(((Bien)var2.get(var3)).getBieId(), ((Bien)var2.get(var3)).getBieNum() + ":" + ((Bien)var2.get(var3)).getBieNom()));
               }
            }
         }
      }

      if (this.bien != null) {
         this.chargerPhotoScan();
         this.chargerDocumentScan();
         this.chargerBaux(var1);
         this.chargerGerances(var1);
         this.chargerTravaux(var1);
         if (this.bien.getTiers() != null) {
            this.tiers = this.bien.getTiers();
            this.var_aff_detail_tiers = true;
         } else {
            this.tiers = null;
            this.var_aff_detail_tiers = false;
         }
      }

      this.utilInitHibernate.closeSession();
      this.visibiliteBton = true;
      this.var_affiche_photo = false;
   }

   public void chargerPhotoScan() throws IOException {
      String var1 = "";
      var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "biens" + File.separator;
      this.categorieReelle = this.bien.getBieCategorie();
      this.lesPhotos.clear();
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      String var3 = this.bien.getBieNum().replace("/", "_");
      String[] var4 = var2.list();
      if (var4 != null) {
         for(int var5 = 0; var5 < var4.length; ++var5) {
            if (var4[var5].startsWith(var3)) {
               this.lesPhotos.add("structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "biens" + File.separator + var4[var5]);
            }
         }
      }

      this.dataModelPhotos.setWrappedData(this.lesPhotos);
   }

   public void chargerDocumentScan() throws IOException {
      this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "biensDocuments" + File.separator;
      this.lesDocuments.clear();
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         File var1 = new File(this.nomRepertoire);
         if (!var1.exists()) {
            var1.mkdir();
         }

         String var2 = this.bien.getBieNum().replace("/", "_");
         String[] var3 = var1.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if ((var3[var4].endsWith(".pdf") || var3[var4].endsWith(".PDF")) && var3[var4].startsWith(var2)) {
                  this.lesDocuments.add(var3[var4]);
               }
            }
         }
      }

      this.dataModelDocumnts.setWrappedData(this.lesDocuments);
   }

   public void chargerGerances(Session var1) throws HibernateException, NamingException {
      this.lesGerances.clear();
      this.lesGerances = this.bienGeranceLigneDao.chargerDetail(this.bien, var1);
      this.dataModelGerance.setWrappedData(this.lesGerances);
   }

   public void chargerBaux(Session var1) throws HibernateException, NamingException {
      this.lesBaux.clear();
      this.lesBaux = this.bienBailDao.chargerBauxByBien(this.bien, var1);
      this.dataModelBaux.setWrappedData(this.lesBaux);
   }

   public void chargerTravaux(Session var1) throws HibernateException, NamingException {
      this.lesTravaux.clear();
      this.lesTravaux = this.bienTravauxEnteteDao.chargerTravauxByBien(this.bien, var1);
      this.dataModelTravaux.setWrappedData(this.lesTravaux);
   }

   public void ajouterBien() throws HibernateException, NamingException {
      this.lesBlocs.clear();
      this.dataModelBlocs.setWrappedData(this.lesBlocs);
      this.lesBaux.clear();
      this.dataModelBaux.setWrappedData(this.lesBaux);
      this.lesGerances.clear();
      this.dataModelGerance.setWrappedData(this.lesGerances);
      this.lesTravaux.clear();
      this.dataModelTravaux.setWrappedData(this.lesTravaux);
      this.lesPhotos.clear();
      this.dataModelPhotos.setWrappedData(this.lesPhotos);
      this.bien = new Bien();
      this.bienAppartement = null;
      this.tiers = new Tiers();
      this.categorieReelle = this.categorieModule;
      this.bien.setBieNomPays(this.structureLog.getStrnompays());
      this.bien.setBieCodePays(this.structureLog.getStrcodepays());
      this.lesImmeublesItems.clear();
      if (this.structureLog.getNomVille() != null && !this.structureLog.getNomVille().isEmpty()) {
         this.bien.setBieVille(this.structureLog.getNomVille());
      }

      if (this.selctionTypeBien == 0) {
         this.var_action = 1;
      } else {
         List var1;
         int var2;
         if (this.selctionTypeBien == 1) {
            this.var_action = 2;
            new ArrayList();
            var1 = this.bienDao.chargeBienByType(0, 2, (Session)null);
            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.lesImmeublesItems.add(new SelectItem(((Bien)var1.get(var2)).getBieId(), ((Bien)var1.get(var2)).getBieNum() + ":" + ((Bien)var1.get(var2)).getBieNom()));
               }
            }
         } else if (this.selctionTypeBien == 2) {
            this.var_action = 3;
         } else if (this.selctionTypeBien == 3) {
            this.var_action = 4;
            new ArrayList();
            var1 = this.bienDao.chargeBienByType(0, 2, (Session)null);
            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.lesImmeublesItems.add(new SelectItem(((Bien)var1.get(var2)).getBieId(), ((Bien)var1.get(var2)).getBieNum() + ":" + ((Bien)var1.get(var2)).getBieNom()));
               }
            }
         } else if (this.selctionTypeBien == 4) {
            this.var_action = 5;
         } else if (this.selctionTypeBien == 5) {
            this.var_action = 6;
         } else if (this.selctionTypeBien == 6) {
            this.var_action = 7;
         } else if (this.selctionTypeBien == 7) {
            this.var_action = 8;
         } else if (this.selctionTypeBien == 8) {
            this.var_action = 9;
         } else if (this.selctionTypeBien == 9) {
            this.var_action = 10;
         } else if (this.selctionTypeBien == 10) {
            this.var_action = 11;
            new ArrayList();
            var1 = this.bienDao.chargeBienByType(0, 2, (Session)null);
            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.lesImmeublesItems.add(new SelectItem(((Bien)var1.get(var2)).getBieId(), ((Bien)var1.get(var2)).getBieNum() + ":" + ((Bien)var1.get(var2)).getBieNom()));
               }
            }
         }
      }

      this.var_aff_detail_tiers = false;
      this.var_aff_action = false;
      this.var_affiche_photo = false;
      this.var_memo_action = this.var_action;
   }

   public void modifierBien() {
      if (this.bien != null) {
         this.bienAppartement = null;
         if (this.selctionTypeBien == 0) {
            this.var_action = 1;
         } else if (this.selctionTypeBien == 1) {
            this.var_action = 2;
         } else if (this.selctionTypeBien == 2) {
            this.var_action = 3;
         } else if (this.selctionTypeBien == 3) {
            this.var_action = 4;
         } else if (this.selctionTypeBien == 4) {
            this.var_action = 5;
         } else if (this.selctionTypeBien == 5) {
            this.var_action = 6;
         } else if (this.selctionTypeBien == 6) {
            this.var_action = 7;
         } else if (this.selctionTypeBien == 7) {
            this.var_action = 8;
         } else if (this.selctionTypeBien == 8) {
            this.var_action = 9;
         } else if (this.selctionTypeBien == 9) {
            this.var_action = 10;
         } else if (this.selctionTypeBien == 10) {
            this.var_action = 11;
         }

         this.var_aff_detail_tiers = true;
         this.var_aff_action = true;
         this.var_valide_doc = true;
         this.var_memo_action = this.var_action;
      }

   }

   public void consulterBien() {
      if (this.bien != null) {
         this.bienAppartement = null;
         if (this.selctionTypeBien == 0) {
            this.var_action = 21;
         } else if (this.selctionTypeBien == 1) {
            this.var_action = 22;
         } else if (this.selctionTypeBien == 2) {
            this.var_action = 23;
         } else if (this.selctionTypeBien == 3) {
            this.var_action = 24;
         } else if (this.selctionTypeBien == 4) {
            this.var_action = 25;
         } else if (this.selctionTypeBien == 5) {
            this.var_action = 26;
         } else if (this.selctionTypeBien == 6) {
            this.var_action = 27;
         } else if (this.selctionTypeBien == 7) {
            this.var_action = 28;
         } else if (this.selctionTypeBien == 8) {
            this.var_action = 29;
         } else if (this.selctionTypeBien == 9) {
            this.var_action = 30;
         } else if (this.selctionTypeBien == 10) {
            this.var_action = 31;
         }

         this.var_aff_detail_tiers = true;
         this.var_aff_action = true;
         this.var_valide_doc = false;
         this.var_memo_action = this.var_action;
      }

   }

   public void supprimerBien() throws HibernateException, NamingException {
      if (this.bien != null) {
         boolean var1 = false;
         if (this.lesBaux.size() == 0 && this.lesGerances.size() == 0 && this.lesTravaux.size() == 0) {
            var1 = true;
         }

         if (var1) {
            Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
            Transaction var3 = null;

            try {
               var3 = var2.beginTransaction();
               String var4 = this.bien.getBieNum() + ":" + this.bien.getBieNom();
               this.bienDao.delete(this.bien, var2);
               if (this.selctionTypeBien == 0) {
                  this.listVilla.remove(this.bien);
                  this.datamodelVilla.setWrappedData(this.listVilla);
               } else if (this.selctionTypeBien == 1) {
                  this.listAppartement.remove(this.bien);
                  this.datamodelAppartement.setWrappedData(this.listAppartement);
               } else if (this.selctionTypeBien == 2) {
                  this.listImmeuble.remove(this.bien);
                  this.datamodelImmeuble.setWrappedData(this.listImmeuble);
               } else if (this.selctionTypeBien == 3) {
                  this.listBureau.remove(this.bien);
                  this.datamodelBureau.setWrappedData(this.listBureau);
               } else if (this.selctionTypeBien == 4) {
                  this.listCommerce.remove(this.bien);
                  this.datamodelCommerce.setWrappedData(this.listCommerce);
               } else if (this.selctionTypeBien == 5) {
                  this.listGarage.remove(this.bien);
                  this.datamodelGarage.setWrappedData(this.listGarage);
               } else if (this.selctionTypeBien == 6) {
                  this.listHangar.remove(this.bien);
                  this.datamodelHangar.setWrappedData(this.listHangar);
               } else if (this.selctionTypeBien == 7) {
                  this.listUsine.remove(this.bien);
                  this.datamodelUsine.setWrappedData(this.listUsine);
               } else if (this.selctionTypeBien == 8) {
                  this.listBox.remove(this.bien);
                  this.datamodelBox.setWrappedData(this.listBox);
               } else if (this.selctionTypeBien == 9) {
                  this.listTerrain.remove(this.bien);
                  this.datamodelTerrain.setWrappedData(this.listTerrain);
               } else if (this.selctionTypeBien == 10) {
                  this.listChambre.remove(this.bien);
                  this.datamodelChambre.setWrappedData(this.listChambre);
               }

               Espion var5 = new Espion();
               var5.setUsers(this.usersLog);
               var5.setEsptype(0);
               var5.setEspdtecreat(new Date());
               var5.setEspaction("Suppression Bien N° " + var4);
               this.espionDao.mAJEspion(var5, var2);
               var3.commit();
            } catch (HibernateException var9) {
               if (var3 != null) {
                  var3.rollback();
               }

               throw var9;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else {
            this.showModalPanelMessage = true;
            this.texteMessage = "Ce bien possède des informations (Baux, Gérance, Travaux, Factures) connectés. La suppresion est impossible...";
         }
      }

   }

   public void fermerMessage() {
      this.showModalPanelMessage = false;
   }

   public void annulerBien() {
      if (this.showModalPanelAppartement) {
         this.showModalPanelAppartement = false;
         this.var_action = this.var_memo_action;
         this.nomOngletActif = "tabDetailAppar";
      } else if (this.showModalPanelBureau) {
         this.showModalPanelBureau = false;
         this.var_action = this.var_memo_action;
         this.nomOngletActif = "tabDetailBur";
      } else if (this.showModalPanelParking) {
         this.showModalPanelParking = false;
         this.var_action = this.var_memo_action;
         this.nomOngletActif = "tabDetailGar";
      } else {
         this.var_action = 0;
         this.var_memo_action = this.var_action;
      }

   }

   public void validerBien() throws HibernateException, NamingException {
      if (this.showModalPanelAppartement) {
         this.validerAppartementViaImmeuble();
      } else if (this.showModalPanelBureau) {
         this.validerBureauViaImmeuble();
      } else if (this.showModalPanelParking) {
         this.validerParkingViaImmeuble();
      } else {
         this.validerBienDirect();
      }

   }

   public void validerBienDirect() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.bien.isBieCopropriete()) {
            this.tiers = null;
            this.bien.setBieNomTiers((String)null);
         } else if (this.tiers != null && this.tiers.getTieid() != 0L) {
            this.bien.setTiers(this.tiers);
         } else {
            this.bien.setTiers((Tiers)null);
         }

         this.bien.setBieCategorie(this.categorieReelle);
         this.bien.setBieType(this.selctionTypeBien);
         if (this.bien.getBieNom() == null || this.bien.getBieNom().isEmpty()) {
            if (this.selctionTypeBien == 0) {
               this.bien.setBieNom("Villa");
            } else if (this.selctionTypeBien == 1) {
               this.bien.setBieNom("Appartement");
            } else if (this.selctionTypeBien == 2) {
               this.bien.setBieNom("Immeuble");
            } else if (this.selctionTypeBien == 3) {
               this.bien.setBieNom("Bureau");
            } else if (this.selctionTypeBien == 4) {
               this.bien.setBieNom("Commerce");
            } else if (this.selctionTypeBien == 5) {
               this.bien.setBieNom("Garage");
            } else if (this.selctionTypeBien == 6) {
               this.bien.setBieNom("Hangar");
            } else if (this.selctionTypeBien == 7) {
               this.bien.setBieNom("Usine");
            } else if (this.selctionTypeBien == 8) {
               this.bien.setBieNom("Box");
            } else if (this.selctionTypeBien == 9) {
               this.bien.setBieNom("Terrain");
            } else if (this.selctionTypeBien == 10) {
               this.bien.setBieNom("Chambre");
            }
         }

         if (this.selctionTypeBien == 2) {
            if (this.bien.isBieCopropriete()) {
               this.bien.setBieNomTiers((String)null);
               this.bien.setTiers((Tiers)null);
            }

            int var4;
            if (this.bien.getBieNbLocaux() != 0 && this.lesBlocs.size() != 0) {
               String var3 = "";

               for(var4 = 0; var4 < this.lesBlocs.size(); ++var4) {
                  this.blocImmeuble = (BlocImmeuble)this.lesBlocs.get(var4);
                  if (var3 != null && !var3.isEmpty()) {
                     var3 = var3 + "#" + this.blocImmeuble.getIndice() + ":" + this.blocImmeuble.getCode() + ":" + this.blocImmeuble.getMillieme();
                  } else {
                     var3 = this.blocImmeuble.getIndice() + ":" + this.blocImmeuble.getCode() + ":" + this.blocImmeuble.getMillieme();
                  }
               }

               this.bien.setBieListeLocaux(var3);
            } else {
               this.bien.setBieListeLocaux("");
            }

            int var10 = 0;
            if (this.lesDetailsApartement.size() != 0) {
               for(var4 = 0; var4 < this.lesDetailsApartement.size(); ++var4) {
                  var10 += ((Bien)this.lesDetailsApartement.get(var4)).getBieMillieme();
               }
            }

            if (this.lesDetailsBureau.size() != 0) {
               for(var4 = 0; var4 < this.lesDetailsBureau.size(); ++var4) {
                  var10 += ((Bien)this.lesDetailsBureau.get(var4)).getBieMillieme();
               }
            }

            if (this.lesDetailsParking.size() != 0) {
               for(var4 = 0; var4 < this.lesDetailsParking.size(); ++var4) {
                  var10 += ((Bien)this.lesDetailsParking.get(var4)).getBieMillieme();
               }
            }

            this.bien.setBieMillieme(var10);
         } else {
            this.bien.setBieListeLocaux("");
            this.bien.setBieMillieme(0);
         }

         if (this.bien.getBieId() != 0L) {
            this.bien.setBieDateModif(new Date());
            this.bien.setBieUserModif(this.usersLog.getUsrid());
            this.bien = this.bienDao.modif(this.bien, var1);
         } else {
            if (this.bien.getBieNum() == null || this.bien.getBieNum().isEmpty()) {
               this.bien.setBieNum(this.calculChrono.numCompose(new Date(), this.nature, "", var1));
            }

            this.bien.setBieDateCreat(new Date());
            this.bien.setBieUserCreat(this.usersLog.getUsrid());
            this.bien = this.bienDao.insert(this.bien, var1);
            if (this.selctionTypeBien == 0) {
               this.listVilla.add(this.bien);
               this.datamodelVilla.setWrappedData(this.listVilla);
            } else if (this.selctionTypeBien == 1) {
               this.listAppartement.add(this.bien);
               this.datamodelAppartement.setWrappedData(this.listAppartement);
            } else if (this.selctionTypeBien == 2) {
               this.listImmeuble.add(this.bien);
               this.datamodelImmeuble.setWrappedData(this.listImmeuble);
            } else if (this.selctionTypeBien == 3) {
               this.listBureau.add(this.bien);
               this.datamodelBureau.setWrappedData(this.listBureau);
            } else if (this.selctionTypeBien == 4) {
               this.listCommerce.add(this.bien);
               this.datamodelCommerce.setWrappedData(this.listCommerce);
            } else if (this.selctionTypeBien == 5) {
               this.listGarage.add(this.bien);
               this.datamodelGarage.setWrappedData(this.listGarage);
            } else if (this.selctionTypeBien == 6) {
               this.listHangar.add(this.bien);
               this.datamodelHangar.setWrappedData(this.listHangar);
            } else if (this.selctionTypeBien == 7) {
               this.listUsine.add(this.bien);
               this.datamodelUsine.setWrappedData(this.listUsine);
            } else if (this.selctionTypeBien == 8) {
               this.listBox.add(this.bien);
               this.datamodelBox.setWrappedData(this.listBox);
            } else if (this.selctionTypeBien == 9) {
               this.listTerrain.add(this.bien);
               this.datamodelTerrain.setWrappedData(this.listTerrain);
            } else if (this.selctionTypeBien == 10) {
               this.listChambre.add(this.bien);
               this.datamodelChambre.setWrappedData(this.listChambre);
            }
         }

         if (this.etat == 0) {
            if (this.bien.getBieGestion() == 1) {
               if (this.selctionTypeBien == 0) {
                  this.listVilla.remove(this.bien);
                  this.datamodelVilla.setWrappedData(this.listVilla);
               } else if (this.selctionTypeBien == 1) {
                  this.listAppartement.remove(this.bien);
                  this.datamodelAppartement.setWrappedData(this.listAppartement);
               } else if (this.selctionTypeBien == 2) {
                  this.listImmeuble.remove(this.bien);
                  this.datamodelImmeuble.setWrappedData(this.listImmeuble);
               } else if (this.selctionTypeBien == 3) {
                  this.listBureau.remove(this.bien);
                  this.datamodelBureau.setWrappedData(this.listBureau);
               } else if (this.selctionTypeBien == 4) {
                  this.listCommerce.remove(this.bien);
                  this.datamodelCommerce.setWrappedData(this.listCommerce);
               } else if (this.selctionTypeBien == 5) {
                  this.listGarage.remove(this.bien);
                  this.datamodelGarage.setWrappedData(this.listGarage);
               } else if (this.selctionTypeBien == 6) {
                  this.listHangar.remove(this.bien);
                  this.datamodelHangar.setWrappedData(this.listHangar);
               } else if (this.selctionTypeBien == 7) {
                  this.listUsine.remove(this.bien);
                  this.datamodelUsine.setWrappedData(this.listUsine);
               } else if (this.selctionTypeBien == 8) {
                  this.listBox.remove(this.bien);
                  this.datamodelBox.setWrappedData(this.listBox);
               } else if (this.selctionTypeBien == 9) {
                  this.listTerrain.remove(this.bien);
                  this.datamodelTerrain.setWrappedData(this.listTerrain);
               } else if (this.selctionTypeBien == 10) {
                  this.listChambre.remove(this.bien);
                  this.datamodelChambre.setWrappedData(this.listChambre);
               }

               this.visibiliteBton = false;
            }
         } else if (this.etat == 1 && this.bien.getBieGestion() == 0) {
            if (this.selctionTypeBien == 0) {
               this.listVilla.remove(this.bien);
               this.datamodelVilla.setWrappedData(this.listVilla);
            } else if (this.selctionTypeBien == 1) {
               this.listAppartement.remove(this.bien);
               this.datamodelAppartement.setWrappedData(this.listAppartement);
            } else if (this.selctionTypeBien == 2) {
               this.listImmeuble.remove(this.bien);
               this.datamodelImmeuble.setWrappedData(this.listImmeuble);
            } else if (this.selctionTypeBien == 3) {
               this.listBureau.remove(this.bien);
               this.datamodelBureau.setWrappedData(this.listBureau);
            } else if (this.selctionTypeBien == 4) {
               this.listCommerce.remove(this.bien);
               this.datamodelCommerce.setWrappedData(this.listCommerce);
            } else if (this.selctionTypeBien == 5) {
               this.listGarage.remove(this.bien);
               this.datamodelGarage.setWrappedData(this.listGarage);
            } else if (this.selctionTypeBien == 6) {
               this.listHangar.remove(this.bien);
               this.datamodelHangar.setWrappedData(this.listHangar);
            } else if (this.selctionTypeBien == 7) {
               this.listUsine.remove(this.bien);
               this.datamodelUsine.setWrappedData(this.listUsine);
            } else if (this.selctionTypeBien == 8) {
               this.listBox.remove(this.bien);
               this.datamodelBox.setWrappedData(this.listBox);
            } else if (this.selctionTypeBien == 9) {
               this.listTerrain.remove(this.bien);
               this.datamodelTerrain.setWrappedData(this.listTerrain);
            } else if (this.selctionTypeBien == 10) {
               this.listChambre.remove(this.bien);
               this.datamodelChambre.setWrappedData(this.listChambre);
            }

            this.visibiliteBton = false;
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

      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void validerAppartementViaImmeuble() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.tiers != null && this.tiers.getTieid() != 0L) {
            this.bienAppartement.setTiers(this.tiers);
            this.bienAppartement.setBieNomTiers(this.tiers.getPatronyme());
         } else {
            this.bienAppartement.setTiers((Tiers)null);
            this.bienAppartement.setBieNomTiers("");
         }

         this.bienAppartement.setBieCategorie(1);
         this.bienAppartement.setBieType(1);
         this.bienAppartement.setBieNom("Appartement");
         this.bienAppartement.setBieNbLocaux(0);
         this.bienAppartement.setBieListeLocaux("");
         this.bienAppartement.setBieIdGroupe(this.bien.getBieId());
         this.bienAppartement.setBieGroupe(this.bien.getBieGroupe());
         this.bienAppartement.setBieNomGroupe(this.bien.getBieNomGroupe());
         int var3 = this.recalculmillieme();
         if (this.bienAppartement.getBieId() == 0L) {
            if (this.bienAppartement.getBieNum() == null || this.bienAppartement.getBieNum().isEmpty()) {
               this.bienAppartement.setBieNum(this.calculChrono.numCompose(new Date(), this.nature, "", var1));
            }

            this.bienAppartement.setBieDateCreat(new Date());
            this.bienAppartement.setBieUserCreat(this.usersLog.getUsrid());
            this.bienAppartement = this.bienDao.insert(this.bienAppartement, var1);
            this.lesDetailsApartement.add(this.bienAppartement);
            this.datamodelDetailAppartement.setWrappedData(this.lesDetailsApartement);
         } else {
            this.bienAppartement.setBieDateModif(new Date());
            this.bienAppartement.setBieUserModif(this.usersLog.getUsrid());
            this.bienAppartement = this.bienDao.modif(this.bienAppartement, var1);
         }

         String var4 = this.recalculBloc(var3);
         this.bien.setBieListeLocaux(var4);
         this.bien = this.bienDao.modif(this.bien, var1);
         var2.commit();
      } catch (HibernateException var8) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_action = 23;
      this.var_memo_action = this.var_action;
      this.showModalPanelAppartement = false;
   }

   public void validerBureauViaImmeuble() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.tiers != null && this.tiers.getTieid() != 0L) {
            this.bienBureau.setTiers(this.tiers);
            this.bienBureau.setBieNomTiers(this.tiers.getPatronyme());
         } else {
            this.bienBureau.setTiers((Tiers)null);
            this.bienBureau.setBieNomTiers("");
         }

         this.bienBureau.setBieCategorie(3);
         this.bienBureau.setBieType(3);
         this.bienBureau.setBieNom("Bureau");
         this.bienBureau.setBieNbLocaux(0);
         this.bienBureau.setBieListeLocaux("");
         this.bienBureau.setBieIdGroupe(this.bien.getBieId());
         this.bienBureau.setBieGroupe(this.bien.getBieGroupe());
         this.bienBureau.setBieNomGroupe(this.bien.getBieNomGroupe());
         int var3 = this.recalculmillieme();
         if (this.bienBureau.getBieId() == 0L) {
            if (this.bienBureau.getBieNum() == null || this.bienBureau.getBieNum().isEmpty()) {
               this.bienBureau.setBieNum(this.calculChrono.numCompose(new Date(), this.nature, "", var1));
            }

            this.bienBureau.setBieDateCreat(new Date());
            this.bienBureau.setBieUserCreat(this.usersLog.getUsrid());
            this.bienBureau = this.bienDao.insert(this.bienBureau, var1);
            this.lesDetailsBureau.add(this.bienBureau);
            this.datamodelDetailBureau.setWrappedData(this.lesDetailsBureau);
         } else {
            this.bienBureau.setBieDateModif(new Date());
            this.bienBureau.setBieUserModif(this.usersLog.getUsrid());
            this.bienBureau = this.bienDao.modif(this.bienBureau, var1);
         }

         String var4 = this.recalculBloc(var3);
         this.bien.setBieListeLocaux(var4);
         this.bien = this.bienDao.modif(this.bien, var1);
         var2.commit();
      } catch (HibernateException var8) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_action = 23;
      this.var_memo_action = this.var_action;
      this.showModalPanelBureau = false;
   }

   public void validerParkingViaImmeuble() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.tiers != null && this.tiers.getTieid() != 0L) {
            this.bienParking.setTiers(this.tiers);
            this.bienParking.setBieNomTiers(this.tiers.getPatronyme());
         } else {
            this.bienParking.setTiers((Tiers)null);
            this.bienParking.setBieNomTiers("");
         }

         this.bienParking.setBieCategorie(5);
         this.bienParking.setBieType(5);
         this.bienParking.setBieNom("Garage");
         this.bienParking.setBieNbLocaux(0);
         this.bienParking.setBieListeLocaux("");
         this.bienParking.setBieIdGroupe(this.bien.getBieId());
         this.bienParking.setBieGroupe(this.bien.getBieGroupe());
         this.bienParking.setBieNomGroupe(this.bien.getBieNomGroupe());
         int var3 = this.recalculmillieme();
         if (this.bienParking.getBieId() == 0L) {
            if (this.bienParking.getBieNum() == null || this.bienParking.getBieNum().isEmpty()) {
               this.bienParking.setBieNum(this.calculChrono.numCompose(new Date(), this.nature, "", var1));
            }

            this.bienParking.setBieDateCreat(new Date());
            this.bienParking.setBieUserCreat(this.usersLog.getUsrid());
            this.bienParking = this.bienDao.insert(this.bienParking, var1);
            this.lesDetailsParking.add(this.bienParking);
            this.datamodelDetailParking.setWrappedData(this.lesDetailsParking);
         } else {
            this.bienParking.setBieDateModif(new Date());
            this.bienParking.setBieUserModif(this.usersLog.getUsrid());
            this.bienParking = this.bienDao.modif(this.bienParking, var1);
         }

         String var4 = this.recalculBloc(var3);
         this.bien.setBieListeLocaux(var4);
         this.bien = this.bienDao.modif(this.bien, var1);
         var2.commit();
      } catch (HibernateException var8) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_action = 23;
      this.var_memo_action = this.var_action;
      this.showModalPanelParking = false;
   }

   public void calculImmeuble() throws HibernateException, NamingException {
      if (this.bien.getBieIdGroupe() != 0L) {
         new Bien();
         Bien var1 = this.bienDao.logBienId(this.bien.getBieIdGroupe(), (Session)null);
         if (var1 != null) {
            this.bien.setBieAdresse(var1.getBieAdresse());
            this.bien.setBieCodePays(var1.getBieCodePays());
            this.bien.setBieCommune(var1.getBieCommune());
            this.bien.setBieDepart(var1.getBieDepart());
            this.bien.setBieGestion(var1.getBieGestion());
            this.bien.setBieGroupe(var1.getBieNum());
            this.bien.setBieGardien(var1.getBieGardien());
            this.bien.setBieGroupElectrogene(var1.getBieGroupElectrogene());
            this.bien.setBieIdGroupe(var1.getBieId());
            this.bien.setBieIlot(var1.getBieIlot());
            this.bien.setBieJardin(var1.getBieJardin());
            this.bien.setBieLot(var1.getBieLot());
            this.bien.setBieNomGroupe(var1.getBieNom());
            this.bien.setBieAdresse(var1.getBieAdresse());
            this.bien.setBieParking(var1.getBieParking());
            this.bien.setBieNbParking(var1.getBieNbParking());
            this.bien.setBiePiscine(var1.getBiePiscine());
            this.bien.setBieQuartier(var1.getBieQuartier());
            this.bien.setBieRue(var1.getBieRue());
            this.bien.setBieVille(var1.getBieVille());
            this.bien.setBieZone(var1.getBieZone());
            this.bien.setBieCopropriete(var1.isBieCopropriete());
            if (var1.isBieCopropriete()) {
               this.bien.setTiers((Tiers)null);
               this.bien.setBieNomTiers((String)null);
               this.var_aff_detail_tiers = false;
            } else {
               this.bien.setTiers(var1.getTiers());
               this.bien.setBieNomTiers(var1.getBieNomTiers());
               this.var_aff_detail_tiers = true;
            }

            this.chargerLesBlocs();
            this.mesBlocsItems.clear();
            if (this.lesBlocs.size() != 0) {
               for(int var2 = 0; var2 < this.lesBlocs.size(); ++var2) {
                  this.blocImmeuble = (BlocImmeuble)this.lesBlocs.get(var2);
                  this.mesBlocsItems.add(new SelectItem(this.blocImmeuble.getCode()));
               }
            } else {
               this.mesBlocsItems.add(new SelectItem(""));
            }
         } else {
            this.bien.setBieAdresse("");
            this.bien.setBieCodePays("");
            this.bien.setBieCommune("");
            this.bien.setBieDepart("");
            this.bien.setBieGestion(0);
            this.bien.setBieGroupe("");
            this.bien.setBieGardien(0);
            this.bien.setBieGroupElectrogene(0);
            this.bien.setBieIdGroupe(0L);
            this.bien.setBieIlot("");
            this.bien.setBieJardin(0);
            this.bien.setBieLot("");
            this.bien.setBieNomGroupe("");
            this.bien.setBieAdresse("");
            this.bien.setBieParking(0);
            this.bien.setBieNbParking(0);
            this.bien.setBiePiscine(0);
            this.bien.setBieQuartier("");
            this.bien.setBieRue("");
            this.bien.setBieVille("");
            this.bien.setBieZone("");
            this.bien.setBieCopropriete(false);
            this.bien.setTiers((Tiers)null);
            this.bien.setBieNomTiers((String)null);
            this.mesBlocsItems.clear();
            this.mesBlocsItems.add(new SelectItem(""));
            this.var_aff_detail_tiers = false;
         }
      } else {
         this.bien.setBieAdresse("");
         this.bien.setBieCodePays("");
         this.bien.setBieCommune("");
         this.bien.setBieDepart("");
         this.bien.setBieGestion(0);
         this.bien.setBieGroupe("");
         this.bien.setBieGardien(0);
         this.bien.setBieGroupElectrogene(0);
         this.bien.setBieIdGroupe(0L);
         this.bien.setBieIlot("");
         this.bien.setBieJardin(0);
         this.bien.setBieLot("");
         this.bien.setBieNomGroupe("");
         this.bien.setBieAdresse("");
         this.bien.setBieParking(0);
         this.bien.setBieNbParking(0);
         this.bien.setBiePiscine(0);
         this.bien.setBieQuartier("");
         this.bien.setBieRue("");
         this.bien.setBieVille("");
         this.bien.setBieZone("");
         this.bien.setBieCopropriete(false);
         this.bien.setTiers((Tiers)null);
         this.bien.setBieNomTiers((String)null);
         this.mesBlocsItems.clear();
         this.mesBlocsItems.add(new SelectItem(""));
         this.var_aff_detail_tiers = false;
      }

   }

   public void calculBail() {
   }

   public void transfertBien() {
      if (this.bien != null) {
         this.var_imput_cat = this.bien.getBieCategorie();
         this.showModalPanelTransfert = true;
      }

   }

   public void fermerTransfert() {
      this.visibiliteBton = false;
      this.showModalPanelTransfert = false;
   }

   public void validerTransfert() throws HibernateException, NamingException {
      if (this.bien != null) {
         this.bien.setBieCategorie(this.var_imput_cat);
         this.bien = this.bienDao.modif(this.bien);
         if (this.bien.getBieCategorie() != this.categorieModule) {
            this.chargerBiens();
         }

         this.visibiliteBton = false;
         this.showModalPanelTransfert = false;
      }

   }

   public void uniciteCodeBien() throws HibernateException, NamingException {
      this.var_code_unique = this.bienDao.logMailExiste(this.bien.getBieNum(), (Session)null);
      if (this.var_code_unique) {
         this.bien.setBieNum("");
      }

      this.controleSaisie();
   }

   public void chargerLesBlocs() {
      if (this.bien != null) {
         this.lesBlocs.clear();
         if (this.bien.getBieType() == 2 && this.bien.getBieListeLocaux() != null && !this.bien.getBieListeLocaux().isEmpty()) {
            String[] var1;
            if (!this.bien.getBieListeLocaux().contains("#")) {
               if (this.bien.getBieListeLocaux().contains(":")) {
                  var1 = this.bien.getBieListeLocaux().split(":");
                  this.blocImmeuble = new BlocImmeuble();
                  this.blocImmeuble.setIndice((long)Integer.parseInt(var1[0]));
                  this.blocImmeuble.setCode(var1[1]);
                  this.blocImmeuble.setMillieme(Integer.parseInt(var1[2]));
                  this.lesBlocs.add(this.blocImmeuble);
               }
            } else if (this.bien.getBieListeLocaux().contains(":")) {
               var1 = this.bien.getBieListeLocaux().split("#");
               int var2 = var1.length;

               for(int var3 = 0; var3 < var2; ++var3) {
                  String[] var4 = var1[var3].split(":");
                  this.blocImmeuble = new BlocImmeuble();
                  this.blocImmeuble.setIndice((long)Integer.parseInt(var4[0]));
                  this.blocImmeuble.setCode(var4[1]);
                  this.blocImmeuble.setMillieme(Integer.parseInt(var4[2]));
                  this.lesBlocs.add(this.blocImmeuble);
               }
            }
         }

         this.dataModelBlocs.setWrappedData(this.lesBlocs);
      }

   }

   public void selectionnerBloc() {
      if (this.dataModelBlocs.isRowAvailable()) {
         this.blocImmeuble = (BlocImmeuble)this.dataModelBlocs.getRowData();
      }

   }

   public void calculeNbBloc() {
      if (this.bien.getBieNbLocaux() != 0) {
         int var1;
         if (this.lesBlocs.size() == 0) {
            for(var1 = 0; var1 < this.bien.getBieNbLocaux(); ++var1) {
               this.blocImmeuble = new BlocImmeuble();
               this.blocImmeuble.setIndice((long)(this.lesBlocs.size() + 1));
               this.lesBlocs.add(this.blocImmeuble);
            }
         } else {
            int var2;
            if (this.bien.getBieNbLocaux() > this.lesBlocs.size()) {
               var1 = this.bien.getBieNbLocaux() - (this.lesBlocs.size() + 1);

               for(var2 = 0; var2 < var1; ++var2) {
                  this.blocImmeuble = new BlocImmeuble();
                  this.blocImmeuble.setIndice((long)(this.lesBlocs.size() + 1));
                  this.lesBlocs.add(this.blocImmeuble);
               }

               this.blocImmeuble = new BlocImmeuble();
               this.blocImmeuble.setIndice((long)(this.lesBlocs.size() + 1));
               this.lesBlocs.add(this.blocImmeuble);
            } else {
               ArrayList var3 = new ArrayList();

               for(var2 = 0; var2 < this.bien.getBieNbLocaux(); ++var2) {
                  this.blocImmeuble = (BlocImmeuble)this.lesBlocs.get(var2);
                  var3.add(this.blocImmeuble);
               }

               this.lesBlocs.clear();

               for(var2 = 0; var2 < var3.size(); ++var2) {
                  this.blocImmeuble = (BlocImmeuble)var3.get(var2);
                  this.lesBlocs.add(this.blocImmeuble);
               }
            }
         }
      } else {
         this.lesBlocs.clear();
      }

      this.dataModelBlocs.setWrappedData(this.lesBlocs);
   }

   public void selectionAppartmeent() {
      if (this.datamodelDetailAppartement.isRowAvailable()) {
         this.bienAppartement = (Bien)this.datamodelDetailAppartement.getRowData();
         this.tiers = this.bienAppartement.getTiers();
         this.visibiliteBtonAppart = true;
         this.visibiliteBtonBureau = false;
         this.visibiliteBtonPrking = false;
      }

   }

   public void ajouterAppartement() {
      this.lesImmeublesItems.clear();
      this.lesImmeublesItems.add(new SelectItem(this.bien.getBieId(), this.bien.getBieNum() + ":" + this.bien.getBieNom()));
      this.bienAppartement = new Bien();
      this.bienAppartement.setBieIdGroupe(this.bien.getBieId());
      this.bienAppartement.setBieGroupe(this.bien.getBieNum());
      if (this.bien.isBieCopropriete()) {
         this.bienAppartement.setTiers((Tiers)null);
         this.bienAppartement.setBieTiers((String)null);
         this.bienAppartement.setBieCivilTiers((String)null);
      } else {
         this.bienAppartement.setTiers(this.tiers);
         this.bienAppartement.setBieTiers(this.tiers.getPatronyme());
         this.bienAppartement.setBieCivilTiers(this.tiers.getTiecivilite());
      }

      this.bienAppartement.setBieJardin(this.bien.getBieJardin());
      this.bienAppartement.setBieParking(this.bien.getBieParking());
      this.bienAppartement.setBieGardien(this.bien.getBieGardien());
      this.bienAppartement.setBiePiscine(this.bien.getBiePiscine());
      this.bienAppartement.setBieGroupElectrogene(this.bien.getBieGroupElectrogene());
      this.showModalPanelAppartement = true;
      this.var_memo_action = this.var_action;
      this.var_aff_detail_tiers = false;
      this.var_action = 12;
   }

   public void modifierAppartement() {
      if (this.bienAppartement != null) {
         this.lesImmeublesItems.clear();
         this.lesImmeublesItems.add(new SelectItem(this.bien.getBieId(), this.bien.getBieNum() + ":" + this.bien.getBieNom()));
         this.bienAppartement.setBieJardin(this.bien.getBieJardin());
         this.bienAppartement.setBieParking(this.bien.getBieParking());
         this.bienAppartement.setBieGardien(this.bien.getBieGardien());
         this.bienAppartement.setBiePiscine(this.bien.getBiePiscine());
         this.bienAppartement.setBieGroupElectrogene(this.bien.getBieGroupElectrogene());
         this.showModalPanelAppartement = true;
         this.var_memo_action = this.var_action;
         if (this.tiers != null) {
            this.var_aff_detail_tiers = true;
         } else {
            this.var_aff_detail_tiers = false;
         }

         this.var_action = 12;
      }

   }

   public void supprimerAppartement() throws HibernateException, NamingException {
      if (this.bienAppartement != null) {
         this.bienDao.delete(this.bienAppartement);
         this.lesDetailsApartement.remove(this.bienAppartement);
         this.datamodelDetailAppartement.setWrappedData(this.lesDetailsApartement);
         this.tiers = null;
         int var1 = this.recalculmillieme();
         String var2 = this.recalculBloc(var1);
         this.bien.setBieListeLocaux(var2);
         this.bien = this.bienDao.modif(this.bien);
         this.visibiliteBtonAppart = false;
      }

   }

   public void selectionBureau() {
      if (this.datamodelDetailBureau.isRowAvailable()) {
         this.bienBureau = (Bien)this.datamodelDetailBureau.getRowData();
         this.tiers = this.bienBureau.getTiers();
         this.visibiliteBtonBureau = true;
         this.visibiliteBtonAppart = false;
         this.visibiliteBtonPrking = false;
      }

   }

   public void ajouterBureau() {
      this.lesImmeublesItems.clear();
      this.lesImmeublesItems.add(new SelectItem(this.bien.getBieId(), this.bien.getBieNum() + ":" + this.bien.getBieNom()));
      this.bienBureau = new Bien();
      this.bienBureau.setBieIdGroupe(this.bien.getBieId());
      this.bienBureau.setBieGroupe(this.bien.getBieNum());
      if (this.bien.isBieCopropriete()) {
         this.bienBureau.setTiers((Tiers)null);
         this.bienBureau.setBieTiers((String)null);
         this.bienBureau.setBieCivilTiers((String)null);
      } else {
         this.bienBureau.setTiers(this.tiers);
         this.bienBureau.setBieTiers(this.tiers.getPatronyme());
         this.bienBureau.setBieCivilTiers(this.tiers.getTiecivilite());
      }

      this.bienBureau.setBieJardin(this.bien.getBieJardin());
      this.bienBureau.setBieParking(this.bien.getBieParking());
      this.bienBureau.setBieGardien(this.bien.getBieGardien());
      this.bienBureau.setBiePiscine(this.bien.getBiePiscine());
      this.bienBureau.setBieGroupElectrogene(this.bien.getBieGroupElectrogene());
      this.showModalPanelBureau = true;
      this.var_memo_action = this.var_action;
      this.var_aff_detail_tiers = false;
      this.var_action = 17;
   }

   public void modifierBureau() {
      if (this.bienBureau != null) {
         this.lesImmeublesItems.clear();
         this.lesImmeublesItems.add(new SelectItem(this.bien.getBieId(), this.bien.getBieNum() + ":" + this.bien.getBieNom()));
         this.bienBureau.setBieJardin(this.bien.getBieJardin());
         this.bienBureau.setBieParking(this.bien.getBieParking());
         this.bienBureau.setBieGardien(this.bien.getBieGardien());
         this.bienBureau.setBiePiscine(this.bien.getBiePiscine());
         this.bienBureau.setBieGroupElectrogene(this.bien.getBieGroupElectrogene());
         this.showModalPanelBureau = true;
         this.var_memo_action = this.var_action;
         if (this.tiers != null) {
            this.var_aff_detail_tiers = true;
         } else {
            this.var_aff_detail_tiers = false;
         }

         this.var_action = 17;
      }

   }

   public void supprimerBureau() throws HibernateException, NamingException {
      if (this.bienBureau != null) {
         this.bienDao.delete(this.bienBureau);
         this.lesDetailsBureau.remove(this.bienBureau);
         this.datamodelDetailBureau.setWrappedData(this.lesDetailsBureau);
         this.tiers = null;
         int var1 = this.recalculmillieme();
         String var2 = this.recalculBloc(var1);
         this.bien.setBieListeLocaux(var2);
         this.bien = this.bienDao.modif(this.bien);
         this.visibiliteBtonAppart = false;
      }

   }

   public void selectionGarage() {
      if (this.datamodelDetailParking.isRowAvailable()) {
         this.bienParking = (Bien)this.datamodelDetailParking.getRowData();
         this.tiers = this.bienParking.getTiers();
         this.visibiliteBtonPrking = true;
         this.visibiliteBtonAppart = false;
         this.visibiliteBtonBureau = false;
      }

   }

   public void ajouterGarage() {
      this.lesImmeublesItems.clear();
      this.lesImmeublesItems.add(new SelectItem(this.bien.getBieId(), this.bien.getBieNum() + ":" + this.bien.getBieNom()));
      this.bienParking = new Bien();
      this.bienParking.setBieIdGroupe(this.bien.getBieId());
      this.bienParking.setBieGroupe(this.bien.getBieNum());
      if (this.bien.isBieCopropriete()) {
         this.bienParking.setTiers((Tiers)null);
         this.bienParking.setBieTiers((String)null);
         this.bienParking.setBieCivilTiers((String)null);
      } else {
         this.bienParking.setTiers(this.tiers);
         this.bienParking.setBieTiers(this.tiers.getPatronyme());
         this.bienParking.setBieCivilTiers(this.tiers.getTiecivilite());
      }

      this.bienParking.setBieJardin(this.bien.getBieJardin());
      this.bienParking.setBieParking(this.bien.getBieParking());
      this.bienParking.setBieGardien(this.bien.getBieGardien());
      this.bienParking.setBiePiscine(this.bien.getBiePiscine());
      this.bienParking.setBieGroupElectrogene(this.bien.getBieGroupElectrogene());
      this.showModalPanelParking = true;
      this.var_memo_action = this.var_action;
      this.var_aff_detail_tiers = false;
      this.var_action = 18;
   }

   public void modifierGarage() {
      if (this.bienParking != null) {
         this.lesImmeublesItems.clear();
         this.lesImmeublesItems.add(new SelectItem(this.bien.getBieId(), this.bien.getBieNum() + ":" + this.bien.getBieNom()));
         this.bienParking.setBieJardin(this.bien.getBieJardin());
         this.bienParking.setBieParking(this.bien.getBieParking());
         this.bienParking.setBieGardien(this.bien.getBieGardien());
         this.bienParking.setBiePiscine(this.bien.getBiePiscine());
         this.bienParking.setBieGroupElectrogene(this.bien.getBieGroupElectrogene());
         this.showModalPanelParking = true;
         this.var_memo_action = this.var_action;
         if (this.tiers != null) {
            this.var_aff_detail_tiers = true;
         } else {
            this.var_aff_detail_tiers = false;
         }

         this.var_action = 18;
      }

   }

   public void supprimerGarage() throws HibernateException, NamingException {
      if (this.bienParking != null) {
         this.bienDao.delete(this.bienParking);
         this.lesDetailsParking.remove(this.bienParking);
         this.datamodelDetailParking.setWrappedData(this.lesDetailsParking);
         this.tiers = null;
         int var1 = this.recalculmillieme();
         String var2 = this.recalculBloc(var1);
         this.bien.setBieListeLocaux(var2);
         this.bien = this.bienDao.modif(this.bien);
         this.visibiliteBtonAppart = false;
      }

   }

   public int recalculmillieme() {
      int var1 = 0;
      int var2;
      if (this.lesDetailsApartement.size() != 0) {
         for(var2 = 0; var2 < this.lesDetailsApartement.size(); ++var2) {
            var1 += ((Bien)this.lesDetailsApartement.get(var2)).getBieMillieme();
         }
      }

      if (this.lesDetailsBureau.size() != 0) {
         for(var2 = 0; var2 < this.lesDetailsBureau.size(); ++var2) {
            var1 += ((Bien)this.lesDetailsBureau.get(var2)).getBieMillieme();
         }
      }

      if (this.lesDetailsParking.size() != 0) {
         for(var2 = 0; var2 < this.lesDetailsParking.size(); ++var2) {
            var1 += ((Bien)this.lesDetailsParking.get(var2)).getBieMillieme();
         }
      }

      return var1;
   }

   public String recalculBloc(int var1) {
      this.bien.setBieMillieme(var1);
      String var2 = "";
      if (this.lesBlocs.size() != 0) {
         this.blocImmeuble = new BlocImmeuble();

         int var3;
         for(var3 = 0; var3 < this.lesBlocs.size(); ++var3) {
            this.blocImmeuble = (BlocImmeuble)this.lesBlocs.get(var3);
            String var4 = this.blocImmeuble.getCode();
            if (var4 != null && !var4.isEmpty()) {
               int var5 = 0;
               int var6;
               if (this.lesDetailsApartement.size() != 0) {
                  for(var6 = 0; var6 < this.lesDetailsApartement.size(); ++var6) {
                     if (((Bien)this.lesDetailsApartement.get(var6)).getBieCodeBloc() != null && !((Bien)this.lesDetailsApartement.get(var6)).getBieCodeBloc().isEmpty() && ((Bien)this.lesDetailsApartement.get(var6)).getBieCodeBloc().equals(var4)) {
                        var5 += ((Bien)this.lesDetailsApartement.get(var6)).getBieMillieme();
                     }
                  }
               }

               if (this.lesDetailsBureau.size() != 0) {
                  for(var6 = 0; var6 < this.lesDetailsBureau.size(); ++var6) {
                     if (((Bien)this.lesDetailsBureau.get(var6)).getBieCodeBloc() != null && !((Bien)this.lesDetailsBureau.get(var6)).getBieCodeBloc().isEmpty() && ((Bien)this.lesDetailsBureau.get(var6)).getBieCodeBloc().equals(var4)) {
                        var5 += ((Bien)this.lesDetailsBureau.get(var6)).getBieMillieme();
                     }
                  }
               }

               if (this.lesDetailsParking.size() != 0) {
                  for(var6 = 0; var6 < this.lesDetailsParking.size(); ++var6) {
                     if (((Bien)this.lesDetailsParking.get(var6)).getBieCodeBloc() != null && !((Bien)this.lesDetailsParking.get(var6)).getBieCodeBloc().isEmpty() && ((Bien)this.lesDetailsParking.get(var6)).getBieCodeBloc().equals(var4)) {
                        var5 += ((Bien)this.lesDetailsParking.get(var6)).getBieMillieme();
                     }
                  }
               }

               this.blocImmeuble.setMillieme(var5);
            }
         }

         for(var3 = 0; var3 < this.lesBlocs.size(); ++var3) {
            this.blocImmeuble = (BlocImmeuble)this.lesBlocs.get(var3);
            if (var2 != null && !var2.isEmpty()) {
               var2 = var2 + "#" + this.blocImmeuble.getIndice() + ":" + this.blocImmeuble.getCode() + ":" + this.blocImmeuble.getMillieme();
            } else {
               var2 = this.blocImmeuble.getIndice() + ":" + this.blocImmeuble.getCode() + ":" + this.blocImmeuble.getMillieme();
            }
         }
      }

      return var2;
   }

   public void historiqueProprietaire() throws HibernateException, NamingException {
      this.lesHistoriques.clear();
      if (this.visibiliteBtonAppart) {
         this.lesHistoriques = this.bienHistoriqueDao.chargerHistoriqueByBien(this.bienAppartement, (Session)null);
      } else if (this.visibiliteBtonBureau) {
         this.lesHistoriques = this.bienHistoriqueDao.chargerHistoriqueByBien(this.bienBureau, (Session)null);
      } else if (this.visibiliteBtonPrking) {
         this.lesHistoriques = this.bienHistoriqueDao.chargerHistoriqueByBien(this.bienParking, (Session)null);
      } else {
         this.lesHistoriques = this.bienHistoriqueDao.chargerHistoriqueByBien(this.bien, (Session)null);
      }

      this.dataModelHistorique.setWrappedData(this.lesHistoriques);
      this.var_memo_action = this.var_action;
      this.visibleHistorique = false;
      this.var_action = 40;
   }

   public void selectionnerHistorique() throws HibernateException, NamingException {
      if (this.dataModelHistorique.isRowAvailable()) {
         this.bienHistorique = (BienHistorique)this.dataModelHistorique.getRowData();
         this.tiersNew = this.bienHistorique.getTiers();
         if (this.bienHistorique.getBiehisIdOldProprietaire() != 0L) {
            this.tiersOld = this.tiersDao.selectTierD(this.bienHistorique.getBiehisIdOldProprietaire());
            if (this.tiersOld == null) {
               this.tiersOld = this.tiers;
            }
         } else {
            this.tiersOld = this.tiers;
         }

         this.visibleHistorique = true;
         this.chargerProprietaire();
      }

   }

   public void chargerProprietaire() throws HibernateException, NamingException {
      if (this.mesProprietaires.size() == 0) {
         this.mesProprietaires = this.tiersDao.chargerLesProprietairesItems((Session)null);
      }

   }

   public void ajouterHistorique() throws HibernateException, NamingException {
      if (this.bien != null) {
         this.bienHistorique = new BienHistorique();
         this.tiersNew = new Tiers();
         this.tiersOld = this.tiers;
         this.chargerProprietaire();
         this.showModalPanelHistorique = true;
      }

   }

   public void modifierHistorique() {
      if (this.bienHistorique != null) {
         this.showModalPanelHistorique = true;
      }

   }

   public void supprimerHistorique() throws HibernateException, NamingException {
      if (this.bienHistorique != null) {
         if (this.visibiliteBtonAppart) {
            this.bienAppartement.setBieNomTiers(this.tiersOld.getPatronyme());
            this.bienAppartement.setBieCivilTiers(this.tiersOld.getTiecivilite());
            this.bienAppartement.setBieTiers(this.tiersOld.getTiesigle());
            this.bienAppartement.setTiers(this.tiersOld);
            this.bienAppartement = this.bienDao.modif(this.bienAppartement);
         } else if (this.visibiliteBtonBureau) {
            this.bienBureau.setBieNomTiers(this.tiersOld.getPatronyme());
            this.bienBureau.setBieCivilTiers(this.tiersOld.getTiecivilite());
            this.bienBureau.setBieTiers(this.tiersOld.getTiesigle());
            this.bienBureau.setTiers(this.tiersOld);
            this.bienBureau = this.bienDao.modif(this.bienBureau);
         } else if (this.visibiliteBtonPrking) {
            this.bienParking.setBieNomTiers(this.tiersOld.getPatronyme());
            this.bienParking.setBieCivilTiers(this.tiersOld.getTiecivilite());
            this.bienParking.setBieTiers(this.tiersOld.getTiesigle());
            this.bienParking.setTiers(this.tiersOld);
            this.bienParking = this.bienDao.modif(this.bienParking);
         } else {
            this.bien.setBieNomTiers(this.tiersOld.getPatronyme());
            this.bien.setBieCivilTiers(this.tiersOld.getTiecivilite());
            this.bien.setBieTiers(this.tiersOld.getTiesigle());
            this.bien.setTiers(this.tiersOld);
            this.bien = this.bienDao.modif(this.bien);
         }

         this.bienHistoriqueDao.delete(this.bienHistorique);
         this.lesHistoriques.remove(this.bienHistorique);
         this.dataModelHistorique.setWrappedData(this.lesHistoriques);
         this.visibleHistorique = false;
      }

   }

   public void fermerHsitorique() {
      this.visibleHistorique = false;
      this.showModalPanelHistorique = false;
   }

   public void validerHsitorique() throws HibernateException, NamingException {
      if (this.tiersNew != null) {
         this.tiersNew = this.tiersDao.selectTierD(this.bienHistorique.getBiehisIdNewProprietaire());
         if (this.tiersNew != null) {
            this.bienHistorique.setBien(this.bien);
            this.bienHistorique.setTiers(this.tiersNew);
            this.bienHistorique.setBiehisIdNewProprietaire(this.tiersNew.getTieid());
            this.bienHistorique.setBiehisCivilNewProprietaire(this.tiersNew.getTiecivilite());
            if (this.tiersNew.getTieprenom() != null && !this.tiersNew.getTieprenom().isEmpty()) {
               this.bienHistorique.setBiehisNomNewProprietaire(this.tiersNew.getTieraisonsocialenom() + " " + this.tiersNew.getTieprenom());
            } else {
               this.bienHistorique.setBiehisNomNewProprietaire(this.tiersNew.getTieraisonsocialenom());
            }

            this.bienHistorique.setBiehisNewProprietaire(this.tiersNew.getTiesigle());
            this.bienHistorique.setBiehisIdOldProprietaire(this.tiersOld.getTieid());
            this.bienHistorique.setBiehisCivilOldProprietaire(this.tiersOld.getTiecivilite());
            if (this.tiersOld.getTieprenom() != null && !this.tiersOld.getTieprenom().isEmpty()) {
               this.bienHistorique.setBiehisNomOldProprietaire(this.tiersOld.getTieraisonsocialenom() + " " + this.tiersOld.getTieprenom());
            } else {
               this.bienHistorique.setBiehisNomOldProprietaire(this.tiersOld.getTieraisonsocialenom());
            }

            this.bienHistorique.setBiehisOldProprietaire(this.tiersOld.getTiesigle());
            if (this.bienHistorique.getBiehisId() == 0L) {
               this.bienHistorique.setBiehisDateCreat(new Date());
               this.bienHistorique.setBiehisUserCreat(this.usersLog.getUsrid());
               this.bienHistorique = this.bienHistoriqueDao.insert(this.bienHistorique);
               this.lesHistoriques.add(this.bienHistorique);
               this.dataModelHistorique.setWrappedData(this.lesHistoriques);
            } else {
               this.bienHistorique.setBiehisDateModif(new Date());
               this.bienHistorique.setBiehisUserModif(this.usersLog.getUsrid());
               this.bienHistorique = this.bienHistoriqueDao.modif(this.bienHistorique);
            }

            if (this.visibiliteBtonAppart) {
               this.bienAppartement.setTiers(this.tiersNew);
               this.bienAppartement.setBieNomTiers(this.tiersNew.getPatronyme());
               this.bienAppartement.setBieCivilTiers(this.tiersNew.getTiecivilite());
               this.bienAppartement.setBieTiers(this.tiersNew.getTiesigle());
               this.bienAppartement = this.bienDao.modif(this.bienAppartement);
            } else if (this.visibiliteBtonBureau) {
               this.bienBureau.setTiers(this.tiersNew);
               this.bienBureau.setBieNomTiers(this.tiersNew.getPatronyme());
               this.bienBureau.setBieCivilTiers(this.tiersNew.getTiecivilite());
               this.bienBureau.setBieTiers(this.tiersNew.getTiesigle());
               this.bienBureau = this.bienDao.modif(this.bienBureau);
            } else if (this.visibiliteBtonPrking) {
               this.bienParking.setTiers(this.tiersNew);
               this.bienParking.setBieNomTiers(this.tiersNew.getPatronyme());
               this.bienParking.setBieCivilTiers(this.tiersNew.getTiecivilite());
               this.bienParking.setBieTiers(this.tiersNew.getTiesigle());
               this.bienParking = this.bienDao.modif(this.bienParking);
            } else {
               this.bien.setTiers(this.tiersNew);
               this.bien.setBieNomTiers(this.tiersNew.getPatronyme());
               this.bien.setBieCivilTiers(this.tiersNew.getTiecivilite());
               this.bien.setBieTiers(this.tiersNew.getTiesigle());
               this.bien = this.bienDao.modif(this.bien);
            }
         }
      }

      this.showModalPanelHistorique = false;
      this.visibleHistorique = true;
   }

   public void retourHistorique() {
      this.var_action = this.var_memo_action;
   }

   public void rechercheProprietaire() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.showModalPanelAppartement) {
         this.tiers = this.formRecherche.rechercheTiers(0, this.bienAppartement.getBieNomTiers(), this.nature);
         if (this.tiers != null) {
            if (this.tiers.getTieid() != 0L) {
               this.calculeTiers();
            } else {
               this.var_memo_action = this.var_action;
               this.var_action = 15;
            }
         } else if (this.tiers == null) {
            this.calculeTiers();
         }
      } else if (this.showModalPanelBureau) {
         this.tiers = this.formRecherche.rechercheTiers(0, this.bienBureau.getBieNomTiers(), this.nature);
         if (this.tiers != null) {
            if (this.tiers.getTieid() != 0L) {
               this.calculeTiers();
            } else {
               this.var_memo_action = this.var_action;
               this.var_action = 15;
            }
         } else if (this.tiers == null) {
            this.calculeTiers();
         }
      } else if (this.showModalPanelParking) {
         this.tiers = this.formRecherche.rechercheTiers(0, this.bienParking.getBieNomTiers(), this.nature);
         if (this.tiers != null) {
            if (this.tiers.getTieid() != 0L) {
               this.calculeTiers();
            } else {
               this.var_memo_action = this.var_action;
               this.var_action = 15;
            }
         } else if (this.tiers == null) {
            this.calculeTiers();
         }
      } else {
         this.tiers = this.formRecherche.rechercheTiers(0, this.bien.getBieNomTiers(), this.nature);
         if (this.tiers != null) {
            if (this.tiers.getTieid() != 0L) {
               this.calculeTiers();
            } else {
               this.var_memo_action = this.var_action;
               this.var_action = 15;
            }
         } else if (this.tiers == null) {
            this.calculeTiers();
         }
      }

   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException {
      this.tiers = this.formRecherche.rechercheTiers(3, this.bien.getBieNomTiers(), this.nature);
      if (this.tiers != null) {
         if (this.tiers.getTieid() != 0L) {
            this.calculeTiers();
         } else {
            this.var_action = 15;
         }
      } else if (this.tiers == null) {
         this.calculeTiers();
      }

   }

   public void recuperationTiers() throws JDOMException, IOException, HibernateException, NamingException {
      this.tiers = this.formRecherche.calculeTiers();
      this.calculeTiers();
   }

   public void calculeTiers() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.tiers != null) {
         String var1;
         if (this.showModalPanelAppartement) {
            this.bienAppartement.setTiers(this.tiers);
            var1 = "";
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               var1 = this.tiers.getTieraisonsocialenom();
               this.bienAppartement.setBieCivilTiers("");
            } else {
               var1 = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               this.bienAppartement.setBieCivilTiers(this.bien.getTiers().getTiecivilite());
            }

            this.bienAppartement.setBieNomTiers(var1);
         } else if (this.showModalPanelBureau) {
            this.bienBureau.setTiers(this.tiers);
            var1 = "";
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               var1 = this.tiers.getTieraisonsocialenom();
               this.bienBureau.setBieCivilTiers("");
            } else {
               var1 = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               this.bienBureau.setBieCivilTiers(this.bien.getTiers().getTiecivilite());
            }

            this.bienBureau.setBieNomTiers(var1);
         } else if (this.showModalPanelParking) {
            this.bienParking.setTiers(this.tiers);
            var1 = "";
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               var1 = this.tiers.getTieraisonsocialenom();
               this.bienParking.setBieCivilTiers("");
            } else {
               var1 = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               this.bienParking.setBieCivilTiers(this.bien.getTiers().getTiecivilite());
            }

            this.bienParking.setBieNomTiers(var1);
         } else {
            this.bien.setTiers(this.tiers);
            var1 = "";
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               var1 = this.tiers.getTieraisonsocialenom();
               this.bien.setBieCivilTiers("");
            } else {
               var1 = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               this.bien.setBieCivilTiers(this.bien.getTiers().getTiecivilite());
            }

            this.bien.setBieNomTiers(var1);
         }
      } else {
         this.annuleTiers();
      }

      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void annuleTiers() {
      this.tiers = null;
      if (this.showModalPanelAppartement) {
         this.bienAppartement.setTiers(this.tiers);
         this.bienAppartement.setBieNomTiers("");
         this.bienAppartement.setBieCivilTiers("");
      } else if (this.showModalPanelBureau) {
         this.bienBureau.setTiers(this.tiers);
         this.bienBureau.setBieNomTiers("");
         this.bienBureau.setBieCivilTiers("");
      } else if (this.showModalPanelParking) {
         this.bienParking.setTiers(this.tiers);
         this.bienParking.setBieNomTiers("");
         this.bienParking.setBieCivilTiers("");
      } else {
         this.bien.setTiers(this.tiers);
         this.bien.setBieNomTiers("");
         this.bien.setBieCivilTiers("");
      }

      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void controleSaisie() {
      if (this.categorieModule == 3) {
         if (this.showModalPanelAppartement) {
            if (this.bienAppartement.getBieNum() != null && !this.bienAppartement.getBieNum().isEmpty()) {
               this.var_valide_doc = true;
            } else {
               this.var_valide_doc = false;
            }
         } else if (this.showModalPanelBureau) {
            if (this.bienBureau.getBieNum() != null && !this.bienBureau.getBieNum().isEmpty()) {
               this.var_valide_doc = true;
            } else {
               this.var_valide_doc = false;
            }
         } else if (this.showModalPanelParking) {
            if (this.bienParking.getBieNum() != null && !this.bienParking.getBieNum().isEmpty()) {
               this.var_valide_doc = true;
            } else {
               this.var_valide_doc = false;
            }
         } else if (this.bien.getBieNum() != null && !this.bien.getBieNum().isEmpty()) {
            this.var_valide_doc = true;
         } else {
            this.var_valide_doc = false;
         }
      } else if (this.showModalPanelAppartement) {
         if (!this.bienAppartement.getBieNomTiers().equals("") && this.tiers.getTieid() != 0L) {
            this.var_aff_detail_tiers = true;
            if (!this.var_code_unique) {
               this.var_valide_doc = true;
            } else {
               this.var_valide_doc = false;
            }
         } else {
            this.var_valide_doc = false;
            this.var_aff_detail_tiers = false;
         }
      } else if (this.showModalPanelBureau) {
         if (!this.bienBureau.getBieNomTiers().equals("") && this.tiers.getTieid() != 0L) {
            this.var_aff_detail_tiers = true;
            if (!this.var_code_unique) {
               this.var_valide_doc = true;
            } else {
               this.var_valide_doc = false;
            }
         } else {
            this.var_valide_doc = false;
            this.var_aff_detail_tiers = false;
         }
      } else if (this.showModalPanelParking) {
         if (!this.bienParking.getBieNomTiers().equals("") && this.tiers.getTieid() != 0L) {
            this.var_aff_detail_tiers = true;
            if (!this.var_code_unique) {
               this.var_valide_doc = true;
            } else {
               this.var_valide_doc = false;
            }
         } else {
            this.var_valide_doc = false;
            this.var_aff_detail_tiers = false;
         }
      } else if (!this.bien.isBieCopropriete()) {
         if (!this.bien.getBieNomTiers().equals("") && this.tiers.getTieid() != 0L) {
            if (!this.var_code_unique) {
               this.var_valide_doc = true;
            } else {
               this.var_valide_doc = false;
            }

            this.var_aff_detail_tiers = false;
         } else {
            this.var_valide_doc = false;
            this.var_aff_detail_tiers = false;
         }
      } else if (!this.var_code_unique) {
         this.var_valide_doc = true;
      } else {
         this.var_valide_doc = false;
      }

   }

   public void detailTiers() {
      this.formRecherche.setNature(this.nature);
      this.var_action = 16;
   }

   public void annuleDetailTiers() {
      this.var_action = this.var_memo_action;
   }

   public void modifTiers() {
      this.var_aff_detail_tiers = false;
   }

   public void selectionPhoto() {
      if (this.dataModelPhotos.isRowAvailable()) {
         this.accesPhoto = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + (String)this.dataModelPhotos.getRowData();
         int var1 = 0;
         if (this.lesPhotos.size() != 0) {
            for(int var2 = 0; var2 < this.lesPhotos.size(); ++var2) {
               if (this.dataModelPhotos.getRowData().toString().equals(((String)this.lesPhotos.get(var2)).toString())) {
                  var1 = var2;
                  break;
               }
            }
         }

         this.numLignePhoto = var1;
         this.var_affiche_photo = true;
      }

   }

   public void ajouterPhoto() {
      if (this.bien != null) {
         this.accesPhoto = "";
         this.showModalPanelPhoto = true;
      }

   }

   public void fermerPhoto() {
      this.accesPhoto = "";
      this.showModalPanelPhoto = false;
   }

   public void validerPhoto() {
      if (this.bien != null) {
         FacesContext var1 = FacesContext.getCurrentInstance();

         try {
            if (this.uploadedFile != null) {
               int var2 = 0;
               if (this.lesPhotos.size() != 0) {
                  var2 = this.lesPhotos.size();
               }

               String var3 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
               String var4 = var3.substring(var3.indexOf(".") + 1);
               var3 = this.bien.getBieNum() + "_" + var2 + "." + var4;
               File var5 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "biens" + File.separator), var3);
               this.utilDownload.write(var5, this.uploadedFile.getInputStream());
               var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
               this.lesPhotos.add("structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "biens" + File.separator + var3);
               this.dataModelPhotos.setWrappedData(this.lesPhotos);
            }
         } catch (IOException var6) {
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var6.printStackTrace();
         }
      }

      this.showModalPanelPhoto = false;
   }

   public void supprimerPhoto() {
      if (this.accesPhoto != null && !this.accesPhoto.isEmpty()) {
         File var1 = new File(this.accesPhoto);
         if (var1.exists()) {
            var1.delete();
         }

         this.lesPhotos.remove(this.numLignePhoto);
         this.dataModelPhotos.setWrappedData(this.lesPhotos);
         this.var_affiche_photo = false;
      }

   }

   public void ajouterDocumentScan() {
      this.uploadedPDFFile = null;
      if (this.utilDownload == null) {
         this.utilDownload = new UtilDownload();
      }

      this.nomDocument = "";
      this.showModalPanelAjoutFile = true;
   }

   public void annulerDocumentScan() {
      this.showModalPanelAjoutFile = false;
   }

   public void validerDocumentScan() {
      if (this.bien != null && this.uploadedPDFFile != null && this.nomDocument != null && !this.nomDocument.isEmpty()) {
         File var1 = new File(this.nomRepertoire + this.bien.getBieNum());
         if (var1.exists()) {
            var1.delete();
         }

         FacesContext var2 = FacesContext.getCurrentInstance();

         try {
            if (this.utilDownload == null) {
               this.utilDownload = new UtilDownload();
            }

            String var3 = this.utilDownload.trimFilePath(this.uploadedPDFFile.getName().trim());
            String var4 = var3.substring(var3.indexOf(".") + 1);
            if (this.nomDocument != null && !this.nomDocument.isEmpty()) {
               var3 = this.bien.getBieNum().replace("/", "_") + "_" + this.filtreCaracteres(this.nomDocument) + "." + var4;
            } else {
               var3 = this.bien.getBieNum().replace("/", "_") + "." + var4;
            }

            File var5 = this.utilDownload.uniqueFile(new File(this.nomRepertoire), var3);
            this.utilDownload.write(var5, this.uploadedPDFFile.getInputStream());
            this.pdfFileName = var3;
            this.lesDocuments.add(this.pdfFileName);
            this.dataModelDocumnts.setWrappedData(this.lesDocuments);
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
         } catch (IOException var6) {
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var6.printStackTrace();
         }
      }

      this.showModalPanelAjoutFile = false;
   }

   public String filtreCaracteres(String var1) {
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3 = (String)var1.subSequence(var4, var4 + 1);
         if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz:=,1234567890".contains(var3)) {
            var2 = var2 + var3.toUpperCase();
         } else if (var3.equals(" ")) {
            var2 = var2 + "_";
         }
      }

      return var2;
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

   public void lectureDoc() throws MalformedURLException, IOException {
      if (this.dataModelDocumnts.isRowAvailable()) {
         String var1 = (String)this.dataModelDocumnts.getRowData();
         if (var1.endsWith(".pdf")) {
            this.nomDocument = var1;
            String var2 = this.nomRepertoire + var1;
            if (var2 != null && !var2.isEmpty()) {
               this.consulterDocumentScan(var2);
            }
         }
      }

   }

   public void consulterDocumentScan(String var1) throws MalformedURLException, IOException {
      if (var1 != null && !var1.isEmpty()) {
         this.utilDownload = new UtilDownload();
         this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(var1);
         this.showModalPanelPj = true;
      }

   }

   public void fermerVisuDocumentScan() {
      this.showModalPanelPj = false;
   }

   public void supprimerDocumentScan() {
      if (this.nomDocument != null && !this.nomDocument.isEmpty() && this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         String var1 = this.nomRepertoire + this.nomDocument;
         File var2 = new File(var1);
         var2.delete();
         this.lesDocuments.remove(this.nomDocument);
         this.dataModelDocumnts.setWrappedData(this.lesDocuments);
         this.showModalPanelPj = false;
      }

   }

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentCommun" + File.separator + "bien" + File.separator;
      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      File var3 = new File(this.calculeCheminSousRapport(var1) + "formatBien.jpg");
      if (var3.exists()) {
         var2 = "formatBien.jpg";
      }

      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      this.montant_lettre = this.utilNombre.begin(this.bien.getBieBaseLoyer(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.lesDetailsApartement);
      return var1;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      return var2;
   }

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var3 != null && !var3.isEmpty()) {
            boolean var11 = this.majDateImpression(var3);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(var3);
            var1.setEntete("Impression bien:" + this.bien.getBieNum() + " " + this.bien.getBieNom());
            var1.setPageGarde((String)null);
            var1.setAnnexe1((String)null);
            var1.setAnnexe2((String)null);
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
            var1.setDuplicata("" + var11);
            var1.setInfoOrigineDoc((String)null);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setMontant_lettre(this.montant_lettre);
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(0L);
            var1.setIdCommercial(0L);
            var1.setTiersSelectionne(this.bien.getTiers());
            var1.setNumDoc(this.bien.getBieNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.bien.getBieId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var2 == 1 && var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setTotauxHt("");
         var1.setTotauxTaxe("");
         var1.setTotauxTtc("");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeCommun" + File.separator + "bien" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.nature);
         var1.setId_doc(0L);
         JRBeanCollectionDataSource var12 = null;
         if (this.etat == 0) {
            var1.setFiltre("Biens gérés par l'agence (Biens libres)");
         } else if (this.etat == 1) {
            var1.setFiltre("Biens gérés par l'agence (Biens occupés)");
         } else if (this.etat == 2) {
            var1.setFiltre("Biens gérés par l'agence (Tous les Biens)");
         } else if (this.etat == 8) {
            var1.setFiltre("Biens plus gérés par l'agence");
         } else {
            var1.setFiltre("???");
         }

         if (this.selctionTypeBien == 0) {
            var1.setEntete("Impression de la liste des villas");
            var12 = new JRBeanCollectionDataSource(this.listVilla);
         } else if (this.selctionTypeBien == 1) {
            var1.setEntete("Impression de la liste des appartements");
            var12 = new JRBeanCollectionDataSource(this.listAppartement);
         } else if (this.selctionTypeBien == 2) {
            var1.setEntete("Impression de la liste des immeubles");
            var12 = new JRBeanCollectionDataSource(this.listImmeuble);
         } else if (this.selctionTypeBien == 3) {
            var1.setEntete("Impression de la liste des bureaux");
            var12 = new JRBeanCollectionDataSource(this.listBureau);
         } else if (this.selctionTypeBien == 4) {
            var1.setEntete("Impression de la liste des commerces");
            var12 = new JRBeanCollectionDataSource(this.listCommerce);
         } else if (this.selctionTypeBien == 5) {
            var1.setEntete("Impression de la liste des garages");
            var12 = new JRBeanCollectionDataSource(this.listGarage);
         } else if (this.selctionTypeBien == 6) {
            var1.setEntete("Impression de la liste des hangars");
            var12 = new JRBeanCollectionDataSource(this.listHangar);
         } else if (this.selctionTypeBien == 7) {
            var1.setEntete("Impression de la liste des biens");
            var12 = new JRBeanCollectionDataSource(this.listUsine);
         } else if (this.selctionTypeBien == 8) {
            var1.setEntete("Impression de la liste des box");
            var12 = new JRBeanCollectionDataSource(this.listBox);
         } else if (this.selctionTypeBien == 9) {
            var1.setEntete("Impression de la liste des terrains");
            var12 = new JRBeanCollectionDataSource(this.listTerrain);
         } else if (this.selctionTypeBien == 10) {
            var1.setEntete("Impression de la liste des chambres");
            var12 = new JRBeanCollectionDataSource(this.listChambre);
         }

         var1.setjRBeanCollectionDataSource(var12);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public void initGrapheur() {
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
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

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
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

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public Bien getBien() {
      return this.bien;
   }

   public void setBien(Bien var1) {
      this.bien = var1;
   }

   public DataModel getDatamodelAppartement() {
      return this.datamodelAppartement;
   }

   public void setDatamodelAppartement(DataModel var1) {
      this.datamodelAppartement = var1;
   }

   public DataModel getDatamodelBox() {
      return this.datamodelBox;
   }

   public void setDatamodelBox(DataModel var1) {
      this.datamodelBox = var1;
   }

   public DataModel getDatamodelBureau() {
      return this.datamodelBureau;
   }

   public void setDatamodelBureau(DataModel var1) {
      this.datamodelBureau = var1;
   }

   public DataModel getDatamodelCommerce() {
      return this.datamodelCommerce;
   }

   public void setDatamodelCommerce(DataModel var1) {
      this.datamodelCommerce = var1;
   }

   public DataModel getDatamodelGarage() {
      return this.datamodelGarage;
   }

   public void setDatamodelGarage(DataModel var1) {
      this.datamodelGarage = var1;
   }

   public DataModel getDatamodelHangar() {
      return this.datamodelHangar;
   }

   public void setDatamodelHangar(DataModel var1) {
      this.datamodelHangar = var1;
   }

   public DataModel getDatamodelImmeuble() {
      return this.datamodelImmeuble;
   }

   public void setDatamodelImmeuble(DataModel var1) {
      this.datamodelImmeuble = var1;
   }

   public DataModel getDatamodelTerrain() {
      return this.datamodelTerrain;
   }

   public void setDatamodelTerrain(DataModel var1) {
      this.datamodelTerrain = var1;
   }

   public DataModel getDatamodelUsine() {
      return this.datamodelUsine;
   }

   public void setDatamodelUsine(DataModel var1) {
      this.datamodelUsine = var1;
   }

   public DataModel getDatamodelVilla() {
      return this.datamodelVilla;
   }

   public void setDatamodelVilla(DataModel var1) {
      this.datamodelVilla = var1;
   }

   public boolean isVar_acc_appartement() {
      return this.var_acc_appartement;
   }

   public void setVar_acc_appartement(boolean var1) {
      this.var_acc_appartement = var1;
   }

   public boolean isVar_acc_box() {
      return this.var_acc_box;
   }

   public void setVar_acc_box(boolean var1) {
      this.var_acc_box = var1;
   }

   public boolean isVar_acc_bureau() {
      return this.var_acc_bureau;
   }

   public void setVar_acc_bureau(boolean var1) {
      this.var_acc_bureau = var1;
   }

   public boolean isVar_acc_commerce() {
      return this.var_acc_commerce;
   }

   public void setVar_acc_commerce(boolean var1) {
      this.var_acc_commerce = var1;
   }

   public boolean isVar_acc_garage() {
      return this.var_acc_garage;
   }

   public void setVar_acc_garage(boolean var1) {
      this.var_acc_garage = var1;
   }

   public boolean isVar_acc_hanger() {
      return this.var_acc_hanger;
   }

   public void setVar_acc_hanger(boolean var1) {
      this.var_acc_hanger = var1;
   }

   public boolean isVar_acc_immeuble() {
      return this.var_acc_immeuble;
   }

   public void setVar_acc_immeuble(boolean var1) {
      this.var_acc_immeuble = var1;
   }

   public boolean isVar_acc_terrain() {
      return this.var_acc_terrain;
   }

   public void setVar_acc_terrain(boolean var1) {
      this.var_acc_terrain = var1;
   }

   public boolean isVar_acc_usine() {
      return this.var_acc_usine;
   }

   public void setVar_acc_usine(boolean var1) {
      this.var_acc_usine = var1;
   }

   public boolean isVar_acc_villa() {
      return this.var_acc_villa;
   }

   public void setVar_acc_villa(boolean var1) {
      this.var_acc_villa = var1;
   }

   public boolean isShowModalGoogleMap() {
      return this.showModalGoogleMap;
   }

   public void setShowModalGoogleMap(boolean var1) {
      this.showModalGoogleMap = var1;
   }

   public boolean isVar_aff_action() {
      return this.var_aff_action;
   }

   public void setVar_aff_action(boolean var1) {
      this.var_aff_action = var1;
   }

   public boolean isVar_aff_detail_tiers() {
      return this.var_aff_detail_tiers;
   }

   public void setVar_aff_detail_tiers(boolean var1) {
      this.var_aff_detail_tiers = var1;
   }

   public boolean isVar_valide_doc() {
      return this.var_valide_doc;
   }

   public void setVar_valide_doc(boolean var1) {
      this.var_valide_doc = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public List getLesImmeublesItems() {
      return this.lesImmeublesItems;
   }

   public void setLesImmeublesItems(List var1) {
      this.lesImmeublesItems = var1;
   }

   public String getVar_activeTab() {
      return this.var_activeTab;
   }

   public void setVar_activeTab(String var1) {
      this.var_activeTab = var1;
   }

   public int getCategorieModule() {
      return this.categorieModule;
   }

   public void setCategorieModule(int var1) {
      this.categorieModule = var1;
   }

   public int getCategorieReelle() {
      return this.categorieReelle;
   }

   public void setCategorieReelle(int var1) {
      this.categorieReelle = var1;
   }

   public String getLibelleCategorie() {
      return this.libelleCategorie;
   }

   public void setLibelleCategorie(String var1) {
      this.libelleCategorie = var1;
   }

   public boolean isShowModalPanelTransfert() {
      return this.showModalPanelTransfert;
   }

   public void setShowModalPanelTransfert(boolean var1) {
      this.showModalPanelTransfert = var1;
   }

   public int getVar_imput_cat() {
      return this.var_imput_cat;
   }

   public void setVar_imput_cat(int var1) {
      this.var_imput_cat = var1;
   }

   public int getEtat() {
      return this.etat;
   }

   public void setEtat(int var1) {
      this.etat = var1;
   }

   public URI getUri() {
      return this.uri;
   }

   public void setUri(URI var1) {
      this.uri = var1;
   }

   public DataModel getDataModelPhotos() {
      return this.dataModelPhotos;
   }

   public void setDataModelPhotos(DataModel var1) {
      this.dataModelPhotos = var1;
   }

   public boolean isShowModalPanelPhoto() {
      return this.showModalPanelPhoto;
   }

   public void setShowModalPanelPhoto(boolean var1) {
      this.showModalPanelPhoto = var1;
   }

   public boolean isVar_affiche_photo() {
      return this.var_affiche_photo;
   }

   public void setVar_affiche_photo(boolean var1) {
      this.var_affiche_photo = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public DataModel getDataModelBaux() {
      return this.dataModelBaux;
   }

   public void setDataModelBaux(DataModel var1) {
      this.dataModelBaux = var1;
   }

   public DataModel getDataModelGerance() {
      return this.dataModelGerance;
   }

   public void setDataModelGerance(DataModel var1) {
      this.dataModelGerance = var1;
   }

   public DataModel getDataModelTravaux() {
      return this.dataModelTravaux;
   }

   public void setDataModelTravaux(DataModel var1) {
      this.dataModelTravaux = var1;
   }

   public boolean isShowModalPanelMessage() {
      return this.showModalPanelMessage;
   }

   public void setShowModalPanelMessage(boolean var1) {
      this.showModalPanelMessage = var1;
   }

   public String getTexteMessage() {
      return this.texteMessage;
   }

   public void setTexteMessage(String var1) {
      this.texteMessage = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public DataModel getDatamodelChambre() {
      return this.datamodelChambre;
   }

   public void setDatamodelChambre(DataModel var1) {
      this.datamodelChambre = var1;
   }

   public boolean isVar_acc_chambre() {
      return this.var_acc_chambre;
   }

   public void setVar_acc_chambre(boolean var1) {
      this.var_acc_chambre = var1;
   }

   public DataModel getDatamodelDetailAppartement() {
      return this.datamodelDetailAppartement;
   }

   public void setDatamodelDetailAppartement(DataModel var1) {
      this.datamodelDetailAppartement = var1;
   }

   public DataModel getDatamodelDetailBureau() {
      return this.datamodelDetailBureau;
   }

   public void setDatamodelDetailBureau(DataModel var1) {
      this.datamodelDetailBureau = var1;
   }

   public DataModel getDatamodelDetailParking() {
      return this.datamodelDetailParking;
   }

   public void setDatamodelDetailParking(DataModel var1) {
      this.datamodelDetailParking = var1;
   }

   public BlocImmeuble getBlocImmeuble() {
      return this.blocImmeuble;
   }

   public void setBlocImmeuble(BlocImmeuble var1) {
      this.blocImmeuble = var1;
   }

   public DataModel getDataModelBlocs() {
      return this.dataModelBlocs;
   }

   public void setDataModelBlocs(DataModel var1) {
      this.dataModelBlocs = var1;
   }

   public boolean isShowModalPanelAppartement() {
      return this.showModalPanelAppartement;
   }

   public void setShowModalPanelAppartement(boolean var1) {
      this.showModalPanelAppartement = var1;
   }

   public boolean isVisibiliteBtonAppart() {
      return this.visibiliteBtonAppart;
   }

   public void setVisibiliteBtonAppart(boolean var1) {
      this.visibiliteBtonAppart = var1;
   }

   public List getMesBlocsItems() {
      return this.mesBlocsItems;
   }

   public void setMesBlocsItems(List var1) {
      this.mesBlocsItems = var1;
   }

   public Bien getBienAppartement() {
      return this.bienAppartement;
   }

   public void setBienAppartement(Bien var1) {
      this.bienAppartement = var1;
   }

   public boolean isVar_code_unique() {
      return this.var_code_unique;
   }

   public void setVar_code_unique(boolean var1) {
      this.var_code_unique = var1;
   }

   public Bien getBienBureau() {
      return this.bienBureau;
   }

   public void setBienBureau(Bien var1) {
      this.bienBureau = var1;
   }

   public Bien getBienParking() {
      return this.bienParking;
   }

   public void setBienParking(Bien var1) {
      this.bienParking = var1;
   }

   public boolean isShowModalPanelBureau() {
      return this.showModalPanelBureau;
   }

   public void setShowModalPanelBureau(boolean var1) {
      this.showModalPanelBureau = var1;
   }

   public boolean isShowModalPanelParking() {
      return this.showModalPanelParking;
   }

   public void setShowModalPanelParking(boolean var1) {
      this.showModalPanelParking = var1;
   }

   public boolean isVisibiliteBtonBureau() {
      return this.visibiliteBtonBureau;
   }

   public void setVisibiliteBtonBureau(boolean var1) {
      this.visibiliteBtonBureau = var1;
   }

   public boolean isVisibiliteBtonPrking() {
      return this.visibiliteBtonPrking;
   }

   public void setVisibiliteBtonPrking(boolean var1) {
      this.visibiliteBtonPrking = var1;
   }

   public String getNomOngletActif() {
      return this.nomOngletActif;
   }

   public void setNomOngletActif(String var1) {
      this.nomOngletActif = var1;
   }

   public DataModel getDataModelDocumnts() {
      return this.dataModelDocumnts;
   }

   public void setDataModelDocumnts(DataModel var1) {
      this.dataModelDocumnts = var1;
   }

   public String getFichierMine() {
      return this.fichierMine;
   }

   public void setFichierMine(String var1) {
      this.fichierMine = var1;
   }

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public String getNomDocument() {
      return this.nomDocument;
   }

   public void setNomDocument(String var1) {
      this.nomDocument = var1;
   }

   public String getNomRepertoire() {
      return this.nomRepertoire;
   }

   public void setNomRepertoire(String var1) {
      this.nomRepertoire = var1;
   }

   public String getPdfFileName() {
      return this.pdfFileName;
   }

   public void setPdfFileName(String var1) {
      this.pdfFileName = var1;
   }

   public boolean isShowModalPanelAjoutFile() {
      return this.showModalPanelAjoutFile;
   }

   public void setShowModalPanelAjoutFile(boolean var1) {
      this.showModalPanelAjoutFile = var1;
   }

   public boolean isShowModalPanelPj() {
      return this.showModalPanelPj;
   }

   public void setShowModalPanelPj(boolean var1) {
      this.showModalPanelPj = var1;
   }

   public UploadedFile getUploadedPDFFile() {
      return this.uploadedPDFFile;
   }

   public void setUploadedPDFFile(UploadedFile var1) {
      this.uploadedPDFFile = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public URL getFichierUrl() {
      return this.fichierUrl;
   }

   public void setFichierUrl(URL var1) {
      this.fichierUrl = var1;
   }

   public BienHistorique getBienHistorique() {
      return this.bienHistorique;
   }

   public void setBienHistorique(BienHistorique var1) {
      this.bienHistorique = var1;
   }

   public DataModel getDataModelHistorique() {
      return this.dataModelHistorique;
   }

   public void setDataModelHistorique(DataModel var1) {
      this.dataModelHistorique = var1;
   }

   public boolean isShowModalPanelHistorique() {
      return this.showModalPanelHistorique;
   }

   public void setShowModalPanelHistorique(boolean var1) {
      this.showModalPanelHistorique = var1;
   }

   public boolean isVisibleHistorique() {
      return this.visibleHistorique;
   }

   public void setVisibleHistorique(boolean var1) {
      this.visibleHistorique = var1;
   }

   public List getMesProprietaires() {
      return this.mesProprietaires;
   }

   public void setMesProprietaires(List var1) {
      this.mesProprietaires = var1;
   }
}
