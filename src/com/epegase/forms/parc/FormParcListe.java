package com.epegase.forms.parc;

import com.epegase.systeme.classe.Amortissements;
import com.epegase.systeme.classe.Caracteristique;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesParc;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.FamillesParc1;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.ParcAffectation;
import com.epegase.systeme.classe.ParcCaracteristique;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.AmortissementsDao;
import com.epegase.systeme.dao.CaracteristiqueDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.dao.FamillesParc1Dao;
import com.epegase.systeme.dao.FamillesParc2Dao;
import com.epegase.systeme.dao.ParcAffectationDao;
import com.epegase.systeme.dao.ParcCaracteristiqueDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionParcs;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormParcListe implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private String pageIndex;
   private int nature;
   private OptionParcs optionParcs;
   private ExercicesParc selectedExo;
   private ExercicesParc lastExo;
   private UtilNombre utilNombre;
   private UtilDate utilDate;
   private List mesOnglets;
   private int var_nb_max = 100;
   private boolean var_acc_descriptif = false;
   private boolean var_acc_photo = false;
   private boolean var_acc_affectation = false;
   private boolean var_acc_comptabilite = false;
   private boolean var_acc_etat = false;
   private boolean var_acc_caracteristique = false;
   private boolean var_acc_inventaire = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private List mesNatureItems = new ArrayList();
   private List mesServiceItems;
   private List mesFamilleItems_rec;
   private String var_immat_rec = "";
   private String var_nature_rec = "";
   private String var_famille_rec = "";
   private String var_origine_rec = "";
   private String var_mode_rec = "";
   private String var_service_rec = "";
   private Parc parc;
   private ParcDao parcDao;
   private List lesParcs = new ArrayList();
   private transient DataModel datamodelParc = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean var_affiche_bouton = false;
   private UtilTdt utilTdt = new UtilTdt();
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private boolean affListeDoc = false;
   private String requete;
   private String filtre;
   private String format = "PDF";
   private int var_choix_modele = 0;
   private String nomModeleListe;
   private String nomModeleDocument;
   private String impEmetteur;
   private String impDestinataire;
   private boolean showModalPanelPrint = false;
   private List mesFamilleItems = new ArrayList();
   private List mesSousFamilleItems = new ArrayList();
   private int var_infoNature;
   private int var_moteur;
   private int var_essence;
   private String var_nature = "";
   private int type_nature;
   private String var_famille = "";
   private String var_sousFamille = "";
   private boolean var_valide_parc = false;
   private boolean var_presence_compta = false;
   private boolean showModalPanelImmobilisation = false;
   private transient DataModel datamodelImmobilisation = new ListDataModel();
   private List lesImmobilisation = new ArrayList();
   private AmortissementsDao amortissementsDao;
   private Amortissements amortissements = new Amortissements();
   private UtilDownload utilDownload;
   private UploadedFile uploadedFile;
   private String fileName;
   private String urlphotoProd;
   private ParcAffectation parcAffectation = new ParcAffectation();
   private ParcAffectationDao parcAffectationDao;
   private List lesAffectations = new ArrayList();
   private transient DataModel datamodelAffectation = new ListDataModel();
   private boolean showModalPanelAffectation = false;
   private boolean var_affiche_affectation = false;
   private boolean var_affiche_valide_affectation = false;
   private Salaries salaries;
   private SalariesDao salariesDao;
   private List lesSalaries = new ArrayList();
   private transient DataModel datamodelSalaries = new ListDataModel();
   private boolean showModalPanelSalaries = false;
   private ParcAffectation parcImputation = new ParcAffectation();
   private List lesImputations = new ArrayList();
   private transient DataModel datamodelImputation = new ListDataModel();
   private boolean showModalPanelImputation = false;
   private boolean var_affiche_imputation = false;
   private boolean var_affiche_valide_imputation = false;
   private Service service;
   private ServiceDao serviceDao;
   private List lesServices = new ArrayList();
   private transient DataModel datamodelServices = new ListDataModel();
   private boolean showModalPanelServices = false;
   private Tiers tiers;
   private TiersDao tiersDao;
   private List lesTiers = new ArrayList();
   private transient DataModel datamodelTiers = new ListDataModel();
   private boolean showModalPanelTiers = false;
   private ParcAffectation parcProprietaire = new ParcAffectation();
   private List lesProprietaires = new ArrayList();
   private transient DataModel datamodelProprietaire = new ListDataModel();
   private boolean showModalPanelProprietaire = false;
   private boolean var_affiche_proprietaire = false;
   private boolean var_affiche_valide_proprietaire = false;
   private Caracteristique caracteristique = new Caracteristique();
   private CaracteristiqueDao caracteristiqueDao;
   private List lesCaracteristiques = new ArrayList();
   private transient DataModel dataModelCaracteristiques = new ListDataModel();
   private ParcCaracteristique parcCaracteristique = new ParcCaracteristique();
   private ParcCaracteristiqueDao parcCaracteristiqueDao;
   private List lesParcCaracteristiques;
   private transient DataModel dataModelParcCaracteristiques;
   private Caracteristique inventaire = new Caracteristique();
   private List lesInventaires = new ArrayList();
   private transient DataModel dataModelInventaires = new ListDataModel();
   private ParcCaracteristique parcInventaire = new ParcCaracteristique();
   private List lesParcInventaires = new ArrayList();
   private transient DataModel dataModelParcInventaires = new ListDataModel();

   public FormParcListe() {
      this.lesParcInventaires = new ArrayList();
      this.dataModelParcInventaires = new ListDataModel();
      this.utilDownload = new UtilDownload();
   }

   public void InstancesDaoUtilses() {
      this.parcDao = new ParcDao(this.baseLog, this.utilInitHibernate);
      this.amortissementsDao = new AmortissementsDao(this.baseLog, this.utilInitHibernate);
      this.parcAffectationDao = new ParcAffectationDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.caracteristiqueDao = new CaracteristiqueDao(this.baseLog, this.utilInitHibernate);
      this.parcCaracteristiqueDao = new ParcCaracteristiqueDao(this.baseLog, this.utilInitHibernate);
   }

   public void initialisation(Session var1) {
      boolean var2 = false;
      Object var3 = var1.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
      int var4 = Integer.parseInt(var3.toString());
      if (var4 > 0) {
         this.var_presence_compta = true;
      } else {
         this.var_presence_compta = false;
      }

      if (this.optionParcs.getNbLigneMax() != null && !this.optionParcs.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionParcs.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public void rechercherParc() throws HibernateException, NamingException {
      this.rechercherParc((Session)null);
   }

   public void rechercherParc(Session var1) throws HibernateException, NamingException {
      this.lesParcs.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.lesParcs = this.parcDao.rechercheParc(this.var_immat_rec, this.var_nature_rec, this.var_famille_rec, this.var_origine_rec, this.var_mode_rec, this.var_service_rec, var1);
      this.datamodelParc.setWrappedData(this.lesParcs);
   }

   public void accesResteintGroupe() {
      this.var_acc_descriptif = false;
      this.var_acc_photo = false;
      this.var_acc_affectation = false;
      this.var_acc_comptabilite = false;
      this.var_acc_etat = false;
      this.var_acc_caracteristique = false;
      this.var_acc_inventaire = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_acc_descriptif = true;
            } else if (var1.getCode().equals("2")) {
               this.var_acc_photo = true;
            } else if (var1.getCode().equals("3")) {
               this.var_acc_affectation = true;
            } else if (var1.getCode().equals("4")) {
               this.var_acc_comptabilite = true;
            } else if (var1.getCode().equals("5")) {
               this.var_acc_etat = true;
            } else if (var1.getCode().equals("6")) {
               this.var_acc_caracteristique = true;
            } else if (var1.getCode().equals("7")) {
               this.var_acc_inventaire = true;
            }
         }
      }

   }

   public void autorisationDescription() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationPhoto() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("2")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationAffectation() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("3")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationComptabilite() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("4")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
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
            if (var1.getCode().equals("5")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationCaracteristique() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("6")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationInventaire() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("7")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void selectionParc() throws HibernateException, NamingException {
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
            this.parc = (Parc)var1.get(0);
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaracteristiqueParc");
            this.var_nature = this.parc.getPrcNature() + ":" + this.parc.getPrcLibNature();
            if (this.parc.getPrcFamille() != null && !this.parc.getPrcFamille().isEmpty()) {
               this.var_famille = this.parc.getPrcFamille() + ":" + this.parc.getPrcLibFamille();
            } else {
               this.var_famille = "";
            }

            if (this.parc.getPrcSousFamille() != null && !this.parc.getPrcSousFamille().isEmpty()) {
               this.var_sousFamille = this.parc.getPrcSousFamille() + ":" + this.parc.getPrcLibSousFamille();
            } else {
               this.var_sousFamille = "";
            }

            if (this.parc.getPrcPhoto() != null) {
               this.urlphotoProd = this.baseLog + "/photos/parc/photo/" + this.parc.getPrcPhoto();
            } else {
               this.urlphotoProd = "";
            }

            this.type_nature = this.parc.getPrcNature();
            this.calculeNature(var4);
            this.calculeEssence();
            this.lesAffectations = new ArrayList();
            this.lesAffectations = this.parcAffectationDao.rechercheAffectation(this.parc, 0, var4);
            this.datamodelAffectation.setWrappedData(this.lesAffectations);
            this.lesImputations = new ArrayList();
            this.lesImputations = this.parcAffectationDao.rechercheAffectation(this.parc, 1, var4);
            this.datamodelImputation.setWrappedData(this.lesImputations);
            this.lesProprietaires = new ArrayList();
            this.lesProprietaires = this.parcAffectationDao.rechercheAffectation(this.parc, 2, var4);
            this.datamodelProprietaire.setWrappedData(this.lesProprietaires);
            if (this.parc.getPrcIdImmobilisation() != 0L) {
               this.amortissements = this.amortissementsDao.trouverImmobilisation(this.parc.getPrcIdImmobilisation(), var4);
            } else {
               this.amortissements = null;
            }

            this.lesCaracteristiques = this.caracteristiqueDao.selectCaracteristiques(this.parc.getPrcFamille(), this.parc.getPrcSousFamille(), var4);
            this.dataModelCaracteristiques.setWrappedData(this.lesCaracteristiques);
            this.lesParcCaracteristiques = this.parcCaracteristiqueDao.rechercheCaracteristique(this.parc, 0, var4);
            this.dataModelCaracteristiques.setWrappedData(this.lesParcCaracteristiques);
            this.lesInventaires = this.caracteristiqueDao.selectInventaires(this.parc.getPrcFamille(), this.parc.getPrcSousFamille(), var4);
            this.dataModelInventaires.setWrappedData(this.lesInventaires);
            this.lesParcInventaires = this.parcCaracteristiqueDao.rechercheCaracteristique(this.parc, 1, var4);
            this.dataModelInventaires.setWrappedData(this.lesParcInventaires);
            this.utilInitHibernate.closeSession();
            this.var_affiche_bouton = true;
         } else {
            this.var_affiche_bouton = false;
         }
      } else {
         this.var_affiche_bouton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.parc != null) {
         this.consulterParc();
      }

   }

   public void ajouterParc() {
      this.parc = new Parc();
      this.var_action = 1;
   }

   public void modifierParc() {
      if (this.parc != null) {
         this.var_action = 2;
      }

   }

   public void consulterParc() {
      if (this.parc != null) {
         this.var_action = 3;
      }

   }

   public void supprimerParc() {
      if (this.parc != null) {
      }

      this.var_affiche_bouton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void annulerParc() {
      this.var_action = 0;
      this.var_affiche_bouton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void saveParc() throws HibernateException, NamingException {
      String[] var1;
      if (this.var_nature.contains(":")) {
         var1 = this.var_nature.split(":");
         this.parc.setPrcNature(Integer.parseInt(var1[0]));
         this.parc.setPrcLibNature(var1[1]);
      } else {
         this.parc.setPrcNature(0);
         this.parc.setPrcLibNature("");
      }

      if (this.var_famille != null && !this.var_famille.isEmpty() && this.var_famille.contains(":")) {
         var1 = this.var_famille.split(":");
         this.parc.setPrcFamille(var1[0]);
         this.parc.setPrcLibFamille(var1[1]);
      } else {
         this.parc.setPrcFamille("");
         this.parc.setPrcLibFamille("");
      }

      if (this.var_sousFamille != null && !this.var_sousFamille.isEmpty() && this.var_sousFamille.contains(":")) {
         var1 = this.var_sousFamille.split(":");
         this.parc.setPrcSousFamille(var1[0]);
         this.parc.setPrcLibSousFamille(var1[1]);
      } else {
         this.parc.setPrcSousFamille("");
         this.parc.setPrcLibSousFamille("");
      }

      String var3 = "";
      if (this.parc.getPrcDateAchat() != null) {
         DateFormat var2 = DateFormat.getDateInstance(3);
         var3 = var2.format(this.parc.getPrcDateAchat()).substring(0, 5);
      }

      this.parc.setPrcAnniversaire(var3);
      if (this.parc.getPrcId() == 0L) {
         this.parc.setPrcDateCreat(new Date());
         this.parc.setPrcUserCreat(this.usersLog.getUsrid());
         this.parc = this.parcDao.insert(this.parc);
         this.lesParcs.add(this.parc);
         this.datamodelParc.setWrappedData(this.lesParcs);
         this.var_action = 2;
         this.simpleSelectionEntete.clear();
         this.extDTable = new HtmlExtendedDataTable();
      } else {
         this.parc.setPrcDateModif(new Date());
         this.parc.setPrcUserModif(this.usersLog.getUsrid());
         this.parc = this.parcDao.modif(this.parc);
         this.var_action = 0;
         this.var_affiche_bouton = true;
      }

   }

   public void calculeNature() throws HibernateException, NamingException {
      this.calculeNature((Session)null);
   }

   public void calculeNature(Session var1) throws HibernateException, NamingException {
      if (this.var_nature.contains(":")) {
         String[] var2 = this.var_nature.split(":");
         this.type_nature = Integer.parseInt(var2[0]);
         int var3 = Integer.parseInt(var2[0]);
         if (var3 >= 1701 && var3 <= 1709) {
            this.var_infoNature = 1;
            if (var3 >= 1701 && var3 <= 1702) {
               this.var_moteur = 0;
            } else {
               this.var_moteur = 1;
            }
         } else if (var3 >= 1711 && var3 <= 1719) {
            this.var_infoNature = 2;
         } else if (var3 >= 1721 && var3 <= 1729) {
            this.var_infoNature = 3;
         } else if (var3 >= 1731 && var3 <= 1739) {
            this.var_infoNature = 4;
         } else if (var3 >= 1741 && var3 <= 1749) {
            this.var_infoNature = 5;
         } else if (var3 >= 1751 && var3 <= 1759) {
            this.var_infoNature = 6;
         } else if (var3 >= 1761 && var3 <= 1769) {
            this.var_infoNature = 7;
         } else if (var3 >= 1771 && var3 <= 1779) {
            this.var_infoNature = 8;
         } else if (var3 >= 1781 && var3 <= 1789) {
            this.var_infoNature = 9;
         } else if (var3 >= 1791 && var3 <= 1799) {
            this.var_infoNature = 10;
         } else if (var3 >= 1801 && var3 <= 1809) {
            this.var_infoNature = 11;
         } else if (var3 >= 1811 && var3 <= 1819) {
            this.var_infoNature = 12;
         }

         this.calculeFamille(var1);
         this.var_valide_parc = true;
      } else {
         this.var_valide_parc = false;
      }

   }

   public void calculeFamille(Session var1) throws HibernateException, NamingException {
      this.mesFamilleItems.clear();
      if (this.var_nature.contains(":")) {
         String[] var2 = this.var_nature.split(":");
         FamillesParc1Dao var3 = new FamillesParc1Dao(this.baseLog, this.utilInitHibernate);
         this.mesFamilleItems = var3.chargerLesFamilles(var2[0], var1);
      }

   }

   public void calculeSousFamille() throws HibernateException, NamingException {
      this.mesSousFamilleItems.clear();
      if (this.var_famille != null && !this.var_famille.isEmpty() && this.var_famille.contains(":")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamilleParc");
         String[] var2 = this.var_famille.split(":");
         new FamillesParc1();
         FamillesParc1Dao var4 = new FamillesParc1Dao(this.baseLog, this.utilInitHibernate);
         FamillesParc1 var3 = var4.rechercheFamille(var2[0], var1);
         if (var3 != null) {
            FamillesParc2Dao var5 = new FamillesParc2Dao(this.baseLog, this.utilInitHibernate);
            this.mesSousFamilleItems = var5.chargerLesSousFamilles(var3, var1);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void calculeEssence() {
      if (this.parc.getPrcAlimentation() == 1) {
         this.var_essence = 1;
      } else {
         this.var_essence = 0;
      }

   }

   public void rechercheImmobilisation() throws HibernateException, NamingException {
      this.showModalPanelImmobilisation = true;
      this.lesImmobilisation = new ArrayList();
      this.datamodelImmobilisation = new ListDataModel();
      if (this.parc.getPrcImmobilisation() != 0L) {
         ExercicesComptableDao var1 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
         new ExercicesComptable();
         ExercicesComptable var2 = var1.recupererLastExo((Session)null);
         if (var2 != null) {
            this.lesImmobilisation = this.amortissementsDao.chargerlesImmobilisations(this.parc.getPrcNature(), this.parc.getPrcImmobilisation(), (Session)null);
         }
      }

      this.datamodelImmobilisation.setWrappedData(this.lesImmobilisation);
   }

   public void selectionImmobilisation() {
      if (this.datamodelImmobilisation.isRowAvailable()) {
         this.amortissements = (Amortissements)this.datamodelImmobilisation.getRowData();
      }

   }

   public void valideImmobilisation() throws ParseException {
      if (this.lesImmobilisation.size() != 0) {
         if (this.amortissements != null) {
            this.parc.setPrcIdImmobilisation(this.amortissements.getAmoId());
            this.parc.setPrcImmobilisation(this.amortissements.getAmoNum());
            this.parc.setPrcDateAchat(this.amortissements.getAmoDateAchat());
            this.parc.setPrcPrixAchat(this.amortissements.getAmoValeurAchat());
            this.parc.setPrcPrixCession(this.amortissements.getAmoValeurCession());
         } else {
            this.amortissements = null;
            this.parc.setPrcIdImmobilisation(0L);
            this.parc.setPrcImmobilisation(0L);
            this.parc.setPrcDateAchat((Date)null);
            this.parc.setPrcPrixAchat(0.0D);
            this.parc.setPrcPrixCession(0.0D);
         }
      } else {
         this.amortissements = null;
         this.parc.setPrcIdImmobilisation(0L);
         this.parc.setPrcImmobilisation(0L);
         this.parc.setPrcDateAchat((Date)null);
         this.parc.setPrcPrixAchat(0.0D);
         this.parc.setPrcPrixCession(0.0D);
      }

      this.showModalPanelImmobilisation = false;
   }

   public void annuleImmobilisation() {
      this.amortissements = null;
      this.parc.setPrcIdImmobilisation(0L);
      this.parc.setPrcImmobilisation(0L);
      this.parc.setPrcDateAchat((Date)null);
      this.parc.setPrcPrixAchat(0.0D);
      this.parc.setPrcPrixCession(0.0D);
      this.showModalPanelImmobilisation = false;
   }

   public void ajoutPhoto() throws IOException, JDOMException, HibernateException, NamingException {
      FacesContext var1 = FacesContext.getCurrentInstance();

      try {
         if (this.uploadedFile != null) {
            String var2 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            String var3 = var2.substring(var2.indexOf(".") + 1);
            var2 = this.parc.getPrcId() + "." + var3;
            File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "parc" + File.separator + "photo" + File.separator + var2);
            boolean var5 = var4.delete();
            File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "parc" + File.separator + "photo" + File.separator), var2);
            this.utilDownload.write(var6, this.uploadedFile.getInputStream());
            this.fileName = var2;
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.parc.setPrcPhoto(var2);
            this.parcDao.modif(this.parc);
            this.urlphotoProd = "structure" + this.structureLog.getStrid() + "/photos/parc/photo/" + this.parc.getPrcPhoto();
         }
      } catch (IOException var7) {
         var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
         var7.printStackTrace();
      }

   }

   public void reInitPhoto() throws HibernateException, NamingException {
      String var1 = "";
      int var2 = this.parc.getPrcPhoto().lastIndexOf(46);
      if (0 < var2 && var2 <= this.parc.getPrcPhoto().length() - 2) {
         var1 = "." + this.parc.getPrcPhoto().substring(var2 + 1);
      }

      String var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "parc" + File.separator + "photo") + File.separator + this.parc.getPrcId() + var1;
      File var4 = new File(var3);
      if (var4.exists()) {
         var4.delete();
      }

      this.parc.setPrcPhoto((String)null);
      this.parcDao.modif(this.parc);
   }

   public void selectionAffectation() {
      if (this.datamodelAffectation.isRowAvailable()) {
         this.parcAffectation = (ParcAffectation)this.datamodelAffectation.getRowData();
         this.var_affiche_affectation = true;
      }

   }

   public void ajouterAffectation() {
      this.parcAffectation = new ParcAffectation();
      this.var_affiche_valide_affectation = false;
      this.showModalPanelAffectation = true;
   }

   public void modifierAffectation() {
      if (this.parcAffectation != null) {
         this.var_affiche_valide_affectation = true;
         this.showModalPanelAffectation = true;
      }

   }

   public void supprimerAffectation() throws HibernateException, NamingException {
      if (this.parcAffectation != null) {
         this.lesAffectations.remove(this.parcAffectation);
         this.datamodelAffectation.setWrappedData(this.lesAffectations);
         this.parcAffectationDao.delete(this.parcAffectation);
         this.var_affiche_affectation = false;
      }

   }

   public void annuleAffectation() {
      this.showModalPanelAffectation = false;
      this.var_affiche_affectation = false;
   }

   public void saveAffectation() throws HibernateException, NamingException {
      if (this.parcAffectation.getPrcaffId() == 0L) {
         this.parcAffectation.setParc(this.parc);
         this.parcAffectation.setPrcaffDateCreat(new Date());
         this.parcAffectation.setPrcaffUserCreat(this.usersLog.getUsrid());
         this.parcAffectation.setPrcaffType(0);
         this.parcAffectation = this.parcAffectationDao.insert(this.parcAffectation);
         this.lesAffectations.add(this.parcAffectation);
         this.datamodelAffectation.setWrappedData(this.lesAffectations);
         this.parc.setPrcMatSalarie(this.parcAffectation.getPrcaffMatSalarie());
         this.parc.setPrcNomSalarie(this.parcAffectation.getPrcaffNomSalarie());
         this.parc.setPrcPrenomSalarie(this.parcAffectation.getPrcaffPrenomSalarie());
         this.parc = this.parcDao.modif(this.parc);
      } else {
         this.parcAffectation.setPrcaffDateModif(new Date());
         this.parcAffectation.setPrcaffUserModif(this.usersLog.getUsrid());
         this.parcAffectation = this.parcAffectationDao.modif(this.parcAffectation);
      }

      this.showModalPanelAffectation = false;
      this.var_affiche_affectation = true;
   }

   public void rechercheSalarie() throws HibernateException, NamingException {
      this.lesSalaries = new ArrayList();
      if (this.parcAffectation.getPrcaffMatSalarie() != null && !this.parcAffectation.getPrcaffMatSalarie().isEmpty()) {
         ExercicesPayeDao var1 = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
         new ExercicesPaye();
         ExercicesPaye var2 = var1.recupererLastExo((Session)null);
         if (var2 != null) {
            this.lesSalaries = this.salariesDao.chargerlesSalariesActif(this.parcAffectation.getPrcaffMatSalarie(), (Session)null);
            this.datamodelSalaries.setWrappedData(this.lesSalaries);
            this.showModalPanelSalaries = true;
         }
      }

   }

   public void selectionSalarie() {
      if (this.datamodelSalaries.isRowAvailable()) {
         this.salaries = (Salaries)this.datamodelSalaries.getRowData();
      }

   }

   public void valideSalarie() throws ParseException {
      if (this.lesSalaries.size() != 0) {
         if (this.salaries != null) {
            this.parcAffectation.setPrcaffMatSalarie(this.salaries.getSalMatricule());
            this.parcAffectation.setPrcaffNomSalarie(this.salaries.getSalNom());
            this.parcAffectation.setPrcaffPrenomSalarie(this.salaries.getSalPrenom());
            this.var_affiche_valide_affectation = true;
         } else {
            this.salaries = null;
            this.parcAffectation.setPrcaffMatSalarie("");
            this.parcAffectation.setPrcaffNomSalarie("");
            this.parcAffectation.setPrcaffPrenomSalarie("");
            this.var_affiche_valide_affectation = false;
         }
      } else {
         this.salaries = null;
         this.parcAffectation.setPrcaffMatSalarie("");
         this.parcAffectation.setPrcaffNomSalarie("");
         this.parcAffectation.setPrcaffPrenomSalarie("");
         this.var_affiche_valide_affectation = false;
      }

      this.showModalPanelSalaries = false;
   }

   public void annuleSalarie() {
      this.salaries = null;
      this.parcAffectation.setPrcaffMatSalarie("");
      this.parcAffectation.setPrcaffNomSalarie("");
      this.parcAffectation.setPrcaffPrenomSalarie("");
      this.showModalPanelSalaries = false;
   }

   public void selectionImputation() {
      if (this.datamodelImputation.isRowAvailable()) {
         this.parcImputation = (ParcAffectation)this.datamodelImputation.getRowData();
         this.var_affiche_imputation = true;
      }

   }

   public void ajouterImputation() {
      this.parcImputation = new ParcAffectation();
      this.var_affiche_valide_imputation = false;
      this.showModalPanelImputation = true;
   }

   public void modifierImputation() {
      if (this.parcImputation != null) {
         this.var_affiche_valide_imputation = true;
         this.showModalPanelImputation = true;
      }

   }

   public void supprimerImputation() throws HibernateException, NamingException {
      if (this.parcImputation != null) {
         this.lesImputations.remove(this.parcImputation);
         this.datamodelImputation.setWrappedData(this.lesImputations);
         this.parcAffectationDao.delete(this.parcImputation);
         this.var_affiche_imputation = false;
      }

   }

   public void annuleImputation() {
      this.showModalPanelImputation = false;
      this.var_affiche_imputation = false;
   }

   public void saveImputation() throws HibernateException, NamingException {
      if (this.parcImputation.getPrcaffId() == 0L) {
         this.parcImputation.setParc(this.parc);
         this.parcImputation.setPrcaffDateCreat(new Date());
         this.parcImputation.setPrcaffUserCreat(this.usersLog.getUsrid());
         this.parcImputation.setPrcaffType(1);
         this.parcImputation = this.parcAffectationDao.insert(this.parcImputation);
         this.lesImputations.add(this.parcImputation);
         this.datamodelImputation.setWrappedData(this.lesImputations);
         this.parc.setPrcService(this.parcImputation.getPrcaffService());
         this.parc.setPrcLibService(this.parcImputation.getPrcaffLibService());
         this.parc = this.parcDao.modif(this.parc);
      } else {
         this.parcImputation.setPrcaffDateModif(new Date());
         this.parcImputation.setPrcaffUserModif(this.usersLog.getUsrid());
         this.parcImputation = this.parcAffectationDao.modif(this.parcImputation);
      }

      this.showModalPanelImputation = false;
      this.var_affiche_imputation = true;
   }

   public void rechercheService() throws HibernateException, NamingException {
      this.lesServices = new ArrayList();
      if (this.parcImputation.getPrcaffService() != null && !this.parcImputation.getPrcaffService().isEmpty()) {
         this.lesServices = this.serviceDao.chargerlesServices(this.parcImputation.getPrcaffService(), (Session)null);
         this.datamodelServices.setWrappedData(this.lesServices);
         this.showModalPanelServices = true;
      }

   }

   public void selectionService() {
      if (this.datamodelServices.isRowAvailable()) {
         this.service = (Service)this.datamodelServices.getRowData();
         this.var_affiche_valide_imputation = true;
      }

   }

   public void valideService() throws ParseException {
      if (this.lesServices.size() != 0) {
         if (this.service != null) {
            this.parcImputation.setPrcaffService(this.service.getSerCode());
            this.parcImputation.setPrcaffLibService(this.service.getSerNomFr());
            this.var_affiche_valide_imputation = true;
         } else {
            this.service = null;
            this.parcImputation.setPrcaffService("");
            this.parcImputation.setPrcaffLibService("");
            this.var_affiche_valide_imputation = false;
         }
      } else {
         this.service = null;
         this.parcImputation.setPrcaffService("");
         this.parcImputation.setPrcaffLibService("");
         this.var_affiche_valide_imputation = false;
      }

      this.showModalPanelServices = false;
   }

   public void annuleService() {
      this.service = null;
      this.parcImputation.setPrcaffService("");
      this.parcImputation.setPrcaffLibService("");
      this.showModalPanelServices = false;
   }

   public void selectionProprietaire() {
      if (this.datamodelProprietaire.isRowAvailable()) {
         this.parcProprietaire = (ParcAffectation)this.datamodelProprietaire.getRowData();
         this.var_affiche_proprietaire = true;
      }

   }

   public void ajouterProprietaire() {
      this.parcProprietaire = new ParcAffectation();
      this.var_affiche_valide_proprietaire = false;
      this.showModalPanelProprietaire = true;
   }

   public void modifierProprietaire() {
      if (this.parcProprietaire != null) {
         this.var_affiche_valide_proprietaire = true;
         this.showModalPanelProprietaire = true;
      }

   }

   public void supprimerProprietaire() throws HibernateException, NamingException {
      if (this.parcProprietaire != null) {
         this.lesProprietaires.remove(this.parcProprietaire);
         this.datamodelProprietaire.setWrappedData(this.lesProprietaires);
         this.parcAffectationDao.delete(this.parcProprietaire);
         this.var_affiche_proprietaire = false;
      }

   }

   public void annuleProprietaire() {
      this.showModalPanelProprietaire = false;
      this.var_affiche_proprietaire = false;
   }

   public void saveProprietaire() throws HibernateException, NamingException {
      if (this.parcProprietaire.getPrcaffId() == 0L) {
         this.parcProprietaire.setParc(this.parc);
         this.parcProprietaire.setPrcaffDateCreat(new Date());
         this.parcProprietaire.setPrcaffUserCreat(this.usersLog.getUsrid());
         this.parcProprietaire.setPrcaffType(2);
         this.parcProprietaire = this.parcAffectationDao.insert(this.parcProprietaire);
         this.lesProprietaires.add(this.parcProprietaire);
         this.datamodelProprietaire.setWrappedData(this.lesProprietaires);
         this.parc.setPrcIdTiers(this.parcProprietaire.getPrcaffIdTiers());
         this.parc.setPrcNomTiers(this.parcProprietaire.getPrcaffNomTiers());
         this.parc.setPrcContact(this.parcProprietaire.getPrcaffContactTiers());
         this.parc.setPrcTel(this.parcProprietaire.getPrcaffTelTiers());
         this.parc = this.parcDao.modif(this.parc);
      } else {
         this.parcProprietaire.setPrcaffDateModif(new Date());
         this.parcProprietaire.setPrcaffUserModif(this.usersLog.getUsrid());
         this.parcProprietaire = this.parcAffectationDao.modif(this.parcProprietaire);
      }

      this.showModalPanelProprietaire = false;
      this.var_affiche_proprietaire = true;
   }

   public void rechercheTiers() throws HibernateException, NamingException {
      this.lesTiers = new ArrayList();
      if (this.parcProprietaire.getPrcaffNomTiers() != null && !this.parcProprietaire.getPrcaffNomTiers().isEmpty()) {
         this.lesTiers = this.tiersDao.verifTiers(this.usersLog, "(3)", this.parcProprietaire.getPrcaffNomTiers(), (Session)null);
         this.datamodelTiers.setWrappedData(this.lesTiers);
         this.showModalPanelTiers = true;
      }

   }

   public void selectionTiers() {
      if (this.datamodelTiers.isRowAvailable()) {
         this.tiers = (Tiers)this.datamodelTiers.getRowData();
         this.var_affiche_valide_proprietaire = true;
      }

   }

   public void valideTiers() throws ParseException {
      if (this.lesTiers.size() != 0) {
         if (this.tiers != null) {
            this.parcProprietaire.setPrcaffIdTiers(this.tiers.getTieid());
            this.parcProprietaire.setPrcaffNomTiers(this.tiers.getTieraisonsocialenom());
            this.parcProprietaire.setPrcaffContactTiers("");
            this.parcProprietaire.setPrcaffTelTiers(this.tiers.getTieburtel1());
            this.parcProprietaire.setPrcaffAdresseTiers(this.tiers.getTieadresse());
            this.parcProprietaire.setPrcaffVilleTiers(this.tiers.getTieville());
            this.var_affiche_valide_imputation = true;
         } else {
            this.tiers = null;
            this.parcProprietaire.setPrcaffIdTiers(0L);
            this.parcProprietaire.setPrcaffNomTiers("");
            this.parcProprietaire.setPrcaffContactTiers("");
            this.parcProprietaire.setPrcaffTelTiers("");
            this.parcProprietaire.setPrcaffAdresseTiers("");
            this.parcProprietaire.setPrcaffVilleTiers("");
            this.var_affiche_valide_proprietaire = false;
         }
      } else {
         this.tiers = null;
         this.parcProprietaire.setPrcaffIdTiers(0L);
         this.parcProprietaire.setPrcaffNomTiers("");
         this.parcProprietaire.setPrcaffContactTiers("");
         this.parcProprietaire.setPrcaffTelTiers("");
         this.parcProprietaire.setPrcaffAdresseTiers("");
         this.parcProprietaire.setPrcaffVilleTiers("");
         this.var_affiche_valide_proprietaire = false;
      }

      this.showModalPanelTiers = false;
   }

   public void annuleTiers() {
      this.tiers = null;
      this.parcProprietaire.setPrcaffIdTiers(0L);
      this.parcProprietaire.setPrcaffNomTiers("");
      this.parcProprietaire.setPrcaffContactTiers("");
      this.parcProprietaire.setPrcaffTelTiers("");
      this.parcProprietaire.setPrcaffAdresseTiers("");
      this.parcProprietaire.setPrcaffVilleTiers("");
      this.var_affiche_valide_proprietaire = false;
      this.showModalPanelTiers = false;
   }

   public void selectionInventaire() {
   }

   public void initImpression() {
      this.var_choix_modele = 0;
      this.nomModeleDocument = "";
      this.affMail = false;
      this.listeDocImp();
      this.showModalPanelPrint = true;
   }

   public void listeDocImp() {
      if (this.var_choix_modele == 0) {
         this.affListeDoc = false;
      } else {
         this.affListeDoc = true;
      }

   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
   }

   public void envoieMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
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
      this.affMail = false;
      this.format = "PRT";
      this.imprimer();
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimer();
   }

   public void imprimerXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimer();
   }

   public void imprimerDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimer();
   }

   public void imprimerHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimer();
   }

   public void imprimerXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimer();
   }

   public void imprimerMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && this.impDestinataire != null && !this.impDestinataire.isEmpty()) {
         this.format = "MAIL";
         this.imprimer();
      }

   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (!this.format.equals("MAIL")) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            this.requete = " cmm_parc.`prc_id`='" + this.parc.getPrcId() + "'";
            this.utilPrint.setNomMapping("Parc");
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setEntete("Impression fiche parc");
            this.utilPrint.setRequete(this.requete);
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "parc" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setIdResponsable(0L);
            this.utilPrint.setTiersSelectionne(this.tiers);
            this.utilPrint.setNature(this.nature);
            this.utilPrint.setId_doc(this.parc.getPrcId());
            ArrayList var1 = new ArrayList();
            JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
            this.utilPrint.setjRBeanCollectionDataSource(var2);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des parcs");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "parc" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(this.nature);
         this.utilPrint.setId_doc(0L);
         JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(this.lesParcs);
         this.utilPrint.setjRBeanCollectionDataSource(var3);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public ExercicesParc getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesParc var1) {
      this.lastExo = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public OptionParcs getOptionParcs() {
      return this.optionParcs;
   }

   public void setOptionParcs(OptionParcs var1) {
      this.optionParcs = var1;
   }

   public ExercicesParc getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesParc var1) {
      this.selectedExo = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public List getMesNatureItems() {
      return this.mesNatureItems;
   }

   public void setMesNatureItems(List var1) {
      this.mesNatureItems = var1;
   }

   public List getMesFamilleItems() {
      return this.mesFamilleItems;
   }

   public void setMesFamilleItems(List var1) {
      this.mesFamilleItems = var1;
   }

   public List getMesServiceItems() {
      return this.mesServiceItems;
   }

   public void setMesServiceItems(List var1) {
      this.mesServiceItems = var1;
   }

   public DataModel getDatamodelParc() {
      return this.datamodelParc;
   }

   public void setDatamodelParc(DataModel var1) {
      this.datamodelParc = var1;
   }

   public List getLesParcs() {
      return this.lesParcs;
   }

   public void setLesParcs(List var1) {
      this.lesParcs = var1;
   }

   public Parc getParc() {
      return this.parc;
   }

   public void setParc(Parc var1) {
      this.parc = var1;
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

   public String getRequete() {
      return this.requete;
   }

   public void setRequete(String var1) {
      this.requete = var1;
   }

   public UtilNombre getUtilNombre() {
      return this.utilNombre;
   }

   public void setUtilNombre(UtilNombre var1) {
      this.utilNombre = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public UtilDate getUtilDate() {
      return this.utilDate;
   }

   public void setUtilDate(UtilDate var1) {
      this.utilDate = var1;
   }

   public String getVar_famille() {
      return this.var_famille;
   }

   public void setVar_famille(String var1) {
      this.var_famille = var1;
   }

   public String getVar_nature() {
      return this.var_nature;
   }

   public void setVar_nature(String var1) {
      this.var_nature = var1;
   }

   public List getMesSousFamilleItems() {
      return this.mesSousFamilleItems;
   }

   public void setMesSousFamilleItems(List var1) {
      this.mesSousFamilleItems = var1;
   }

   public int getVar_infoNature() {
      return this.var_infoNature;
   }

   public void setVar_infoNature(int var1) {
      this.var_infoNature = var1;
   }

   public String getVar_sousFamille() {
      return this.var_sousFamille;
   }

   public void setVar_sousFamille(String var1) {
      this.var_sousFamille = var1;
   }

   public int getVar_essence() {
      return this.var_essence;
   }

   public void setVar_essence(int var1) {
      this.var_essence = var1;
   }

   public String getVar_famille_rec() {
      return this.var_famille_rec;
   }

   public void setVar_famille_rec(String var1) {
      this.var_famille_rec = var1;
   }

   public String getVar_immat_rec() {
      return this.var_immat_rec;
   }

   public void setVar_immat_rec(String var1) {
      this.var_immat_rec = var1;
   }

   public String getVar_mode_rec() {
      return this.var_mode_rec;
   }

   public void setVar_mode_rec(String var1) {
      this.var_mode_rec = var1;
   }

   public String getVar_nature_rec() {
      return this.var_nature_rec;
   }

   public void setVar_nature_rec(String var1) {
      this.var_nature_rec = var1;
   }

   public String getVar_origine_rec() {
      return this.var_origine_rec;
   }

   public void setVar_origine_rec(String var1) {
      this.var_origine_rec = var1;
   }

   public String getVar_service_rec() {
      return this.var_service_rec;
   }

   public void setVar_service_rec(String var1) {
      this.var_service_rec = var1;
   }

   public int getVar_moteur() {
      return this.var_moteur;
   }

   public void setVar_moteur(int var1) {
      this.var_moteur = var1;
   }

   public boolean isVar_valide_parc() {
      return this.var_valide_parc;
   }

   public void setVar_valide_parc(boolean var1) {
      this.var_valide_parc = var1;
   }

   public List getMesFamilleItems_rec() {
      return this.mesFamilleItems_rec;
   }

   public void setMesFamilleItems_rec(List var1) {
      this.mesFamilleItems_rec = var1;
   }

   public Amortissements getAmortissements() {
      return this.amortissements;
   }

   public void setAmortissements(Amortissements var1) {
      this.amortissements = var1;
   }

   public DataModel getDatamodelImmobilisation() {
      return this.datamodelImmobilisation;
   }

   public void setDatamodelImmobilisation(DataModel var1) {
      this.datamodelImmobilisation = var1;
   }

   public List getLesImmobilisation() {
      return this.lesImmobilisation;
   }

   public void setLesImmobilisation(List var1) {
      this.lesImmobilisation = var1;
   }

   public boolean isShowModalPanelImmobilisation() {
      return this.showModalPanelImmobilisation;
   }

   public void setShowModalPanelImmobilisation(boolean var1) {
      this.showModalPanelImmobilisation = var1;
   }

   public boolean isVar_presence_compta() {
      return this.var_presence_compta;
   }

   public void setVar_presence_compta(boolean var1) {
      this.var_presence_compta = var1;
   }

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public boolean isVar_acc_affectation() {
      return this.var_acc_affectation;
   }

   public void setVar_acc_affectation(boolean var1) {
      this.var_acc_affectation = var1;
   }

   public boolean isVar_acc_caracteristique() {
      return this.var_acc_caracteristique;
   }

   public void setVar_acc_caracteristique(boolean var1) {
      this.var_acc_caracteristique = var1;
   }

   public boolean isVar_acc_comptabilite() {
      return this.var_acc_comptabilite;
   }

   public void setVar_acc_comptabilite(boolean var1) {
      this.var_acc_comptabilite = var1;
   }

   public boolean isVar_acc_descriptif() {
      return this.var_acc_descriptif;
   }

   public void setVar_acc_descriptif(boolean var1) {
      this.var_acc_descriptif = var1;
   }

   public boolean isVar_acc_etat() {
      return this.var_acc_etat;
   }

   public void setVar_acc_etat(boolean var1) {
      this.var_acc_etat = var1;
   }

   public boolean isVar_acc_inventaire() {
      return this.var_acc_inventaire;
   }

   public void setVar_acc_inventaire(boolean var1) {
      this.var_acc_inventaire = var1;
   }

   public boolean isVar_acc_photo() {
      return this.var_acc_photo;
   }

   public void setVar_acc_photo(boolean var1) {
      this.var_acc_photo = var1;
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

   public DataModel getDatamodelAffectation() {
      return this.datamodelAffectation;
   }

   public void setDatamodelAffectation(DataModel var1) {
      this.datamodelAffectation = var1;
   }

   public DataModel getDatamodelImputation() {
      return this.datamodelImputation;
   }

   public void setDatamodelImputation(DataModel var1) {
      this.datamodelImputation = var1;
   }

   public List getLesAffectations() {
      return this.lesAffectations;
   }

   public void setLesAffectations(List var1) {
      this.lesAffectations = var1;
   }

   public List getLesImputations() {
      return this.lesImputations;
   }

   public void setLesImputations(List var1) {
      this.lesImputations = var1;
   }

   public ParcAffectation getParcAffectation() {
      return this.parcAffectation;
   }

   public void setParcAffectation(ParcAffectation var1) {
      this.parcAffectation = var1;
   }

   public DataModel getDatamodelSalaries() {
      return this.datamodelSalaries;
   }

   public void setDatamodelSalaries(DataModel var1) {
      this.datamodelSalaries = var1;
   }

   public DataModel getDatamodelServices() {
      return this.datamodelServices;
   }

   public void setDatamodelServices(DataModel var1) {
      this.datamodelServices = var1;
   }

   public List getLesSalaries() {
      return this.lesSalaries;
   }

   public void setLesSalaries(List var1) {
      this.lesSalaries = var1;
   }

   public List getLesServices() {
      return this.lesServices;
   }

   public void setLesServices(List var1) {
      this.lesServices = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public Service getService() {
      return this.service;
   }

   public void setService(Service var1) {
      this.service = var1;
   }

   public boolean isShowModalPanelAffectation() {
      return this.showModalPanelAffectation;
   }

   public void setShowModalPanelAffectation(boolean var1) {
      this.showModalPanelAffectation = var1;
   }

   public boolean isShowModalPanelImputation() {
      return this.showModalPanelImputation;
   }

   public void setShowModalPanelImputation(boolean var1) {
      this.showModalPanelImputation = var1;
   }

   public boolean isShowModalPanelSalaries() {
      return this.showModalPanelSalaries;
   }

   public void setShowModalPanelSalaries(boolean var1) {
      this.showModalPanelSalaries = var1;
   }

   public boolean isShowModalPanelServices() {
      return this.showModalPanelServices;
   }

   public void setShowModalPanelServices(boolean var1) {
      this.showModalPanelServices = var1;
   }

   public ParcAffectation getParcImputation() {
      return this.parcImputation;
   }

   public void setParcImputation(ParcAffectation var1) {
      this.parcImputation = var1;
   }

   public boolean isVar_affiche_affectation() {
      return this.var_affiche_affectation;
   }

   public void setVar_affiche_affectation(boolean var1) {
      this.var_affiche_affectation = var1;
   }

   public boolean isVar_affiche_imputation() {
      return this.var_affiche_imputation;
   }

   public void setVar_affiche_imputation(boolean var1) {
      this.var_affiche_imputation = var1;
   }

   public boolean isVar_affiche_valide_affectation() {
      return this.var_affiche_valide_affectation;
   }

   public void setVar_affiche_valide_affectation(boolean var1) {
      this.var_affiche_valide_affectation = var1;
   }

   public boolean isVar_affiche_valide_imputation() {
      return this.var_affiche_valide_imputation;
   }

   public void setVar_affiche_valide_imputation(boolean var1) {
      this.var_affiche_valide_imputation = var1;
   }

   public Caracteristique getCaracteristique() {
      return this.caracteristique;
   }

   public void setCaracteristique(Caracteristique var1) {
      this.caracteristique = var1;
   }

   public DataModel getDataModelCaracteristiques() {
      return this.dataModelCaracteristiques;
   }

   public void setDataModelCaracteristiques(DataModel var1) {
      this.dataModelCaracteristiques = var1;
   }

   public DataModel getDataModelInventaires() {
      return this.dataModelInventaires;
   }

   public void setDataModelInventaires(DataModel var1) {
      this.dataModelInventaires = var1;
   }

   public DataModel getDataModelParcCaracteristiques() {
      return this.dataModelParcCaracteristiques;
   }

   public void setDataModelParcCaracteristiques(DataModel var1) {
      this.dataModelParcCaracteristiques = var1;
   }

   public DataModel getDataModelParcInventaires() {
      return this.dataModelParcInventaires;
   }

   public void setDataModelParcInventaires(DataModel var1) {
      this.dataModelParcInventaires = var1;
   }

   public Caracteristique getInventaire() {
      return this.inventaire;
   }

   public void setInventaire(Caracteristique var1) {
      this.inventaire = var1;
   }

   public List getLesCaracteristiques() {
      return this.lesCaracteristiques;
   }

   public void setLesCaracteristiques(List var1) {
      this.lesCaracteristiques = var1;
   }

   public List getLesInventaires() {
      return this.lesInventaires;
   }

   public void setLesInventaires(List var1) {
      this.lesInventaires = var1;
   }

   public List getLesParcCaracteristiques() {
      return this.lesParcCaracteristiques;
   }

   public void setLesParcCaracteristiques(List var1) {
      this.lesParcCaracteristiques = var1;
   }

   public List getLesParcInventaires() {
      return this.lesParcInventaires;
   }

   public void setLesParcInventaires(List var1) {
      this.lesParcInventaires = var1;
   }

   public ParcCaracteristique getParcCaracteristique() {
      return this.parcCaracteristique;
   }

   public void setParcCaracteristique(ParcCaracteristique var1) {
      this.parcCaracteristique = var1;
   }

   public ParcCaracteristique getParcInventaire() {
      return this.parcInventaire;
   }

   public void setParcInventaire(ParcCaracteristique var1) {
      this.parcInventaire = var1;
   }

   public DataModel getDatamodelProprietaire() {
      return this.datamodelProprietaire;
   }

   public void setDatamodelProprietaire(DataModel var1) {
      this.datamodelProprietaire = var1;
   }

   public DataModel getDatamodelTiers() {
      return this.datamodelTiers;
   }

   public void setDatamodelTiers(DataModel var1) {
      this.datamodelTiers = var1;
   }

   public boolean isShowModalPanelProprietaire() {
      return this.showModalPanelProprietaire;
   }

   public void setShowModalPanelProprietaire(boolean var1) {
      this.showModalPanelProprietaire = var1;
   }

   public boolean isShowModalPanelTiers() {
      return this.showModalPanelTiers;
   }

   public void setShowModalPanelTiers(boolean var1) {
      this.showModalPanelTiers = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public boolean isVar_affiche_proprietaire() {
      return this.var_affiche_proprietaire;
   }

   public void setVar_affiche_proprietaire(boolean var1) {
      this.var_affiche_proprietaire = var1;
   }

   public boolean isVar_affiche_valide_proprietaire() {
      return this.var_affiche_valide_proprietaire;
   }

   public void setVar_affiche_valide_proprietaire(boolean var1) {
      this.var_affiche_valide_proprietaire = var1;
   }

   public ParcAffectation getParcProprietaire() {
      return this.parcProprietaire;
   }

   public void setParcProprietaire(ParcAffectation var1) {
      this.parcProprietaire = var1;
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

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
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

   public int getType_nature() {
      return this.type_nature;
   }

   public void setType_nature(int var1) {
      this.type_nature = var1;
   }
}
