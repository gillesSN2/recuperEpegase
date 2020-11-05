package com.epegase.systeme.control;

import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.CotationEnteteAchats;
import com.epegase.systeme.classe.CotationLigneAchats;
import com.epegase.systeme.classe.Devise;
import com.epegase.systeme.classe.DouanesPosition;
import com.epegase.systeme.classe.FraisTheoAchats;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsFrais;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.CotationEnteteAchatsDao;
import com.epegase.systeme.dao.CotationLigneAchatsDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.DouanesPositionDao;
import com.epegase.systeme.dao.FraisTheoAchatsDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsFraisDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.LectureTarifTransit;
import com.epegase.systeme.xml.ObjetDevises;
import com.epegase.systeme.xml.ObjetTarifTransit;
import com.epegase.systeme.xml.OptionAchats;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
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

public class CalculPrp implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int nature;
   private OptionAchats optionAchats;
   private String montant_lettre;
   private UtilNombre utilNombre = new UtilNombre();
   private int var_format_devise;
   private float var_coef_devise;
   private List listeDetailFrais = new ArrayList();
   private transient DataModel dataModelDetailFrais = new ListDataModel();
   private ProduitsFrais produitsFrais;
   private boolean showModalPanelSimulation = false;
   private String var_modele_simulation;
   private List mesSimulationItems = new ArrayList();
   private Date var_date_simulation;
   private double var_montant_initial;
   private double var_pa_local;
   private double var_fret_local;
   private boolean var_ajout;
   private double var_pa;
   private String var_devise;
   private double var_fret;
   private double var_assurance;
   private double var_assurance_local;
   private boolean var_enregistre;
   private int var_exo_douane;
   private int var_exo_tva;
   private float var_coef_prp;
   private boolean affiche_devise;
   private boolean masquerFomrule;
   private boolean masquerColonneIntemediaire;
   private List lesVariablesSaisir = new ArrayList();
   private transient DataModel dataModelVariables = new ListDataModel();
   private boolean affichageListeVariable;
   private ObjetTable objetTable = new ObjetTable();
   private double pvPropose;
   private FraisTheoAchats fraisTheoAchats;
   private FraisTheoAchatsDao fraisTheoAchatsDao;
   private ProduitsFraisDao produitsFraisDao;
   private CotationEnteteAchats cotationEnteteAchats;
   private CotationEnteteAchatsDao cotationEnteteAchatsDao;
   private CommandeEnteteAchats commandeEnteteAchats;
   private CommandeEnteteAchatsDao commandeEnteteAchatsDao;
   private Produits produits;
   private ProduitsAchsDao produitsAchsDao;
   private UtilPrint utilPrint;
   private List lesmodelesImpressions = new ArrayList();
   private boolean affMail = false;
   private String nomModeleDocument;
   private String format = "PDF";
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private boolean visibleOptionMail = false;
   private boolean showModalPanelPrint = false;
   private String chaineTransitaire;
   private String chaineTransporteur;
   private int var_cateorie;
   private String var_mode;
   private int var_nature;
   private long var_id_transporteur;
   private String var_nom_transorteur;
   private long var_id_transitaire;
   private String var_nom_transitaire;
   private List listeDetailFraisTranstaire = new ArrayList();
   private transient DataModel dataModelDetailFraisTransitaire = new ListDataModel();
   private List listeDetailFraisTransporteur = new ArrayList();
   private transient DataModel dataModelDetailFraisTransporteur = new ListDataModel();
   private List lesLignesListCotations;
   private transient DataModel dataModelDetailFraisDouanes = new ListDataModel();
   private int typeListe;
   private List lesDevises = new ArrayList();
   private DeviseDao deviseDao;

   public void InstancesDaoUtilses() {
      this.fraisTheoAchatsDao = new FraisTheoAchatsDao(this.baseLog, this.utilInitHibernate);
      this.cotationEnteteAchatsDao = new CotationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.commandeEnteteAchatsDao = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsFraisDao = new ProduitsFraisDao(this.baseLog, this.utilInitHibernate);
      this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.deviseDao = new DeviseDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerDevise(Session var1) throws HibernateException, NamingException {
      this.lesDevises = this.deviseDao.chargerLesDevises(var1);
   }

   public float calculTauxDevise(String var1) throws HibernateException, NamingException {
      float var2 = 1.0F;
      if (this.lesDevises.size() != 0) {
         for(int var3 = 0; var3 < this.lesDevises.size(); ++var3) {
            if (((Devise)this.lesDevises.get(var3)).getDevCode().equals(var1)) {
               var2 = ((Devise)this.lesDevises.get(var3)).getDevTaux1();
            }
         }
      }

      return var2;
   }

   public void calculDevise() throws HibernateException, NamingException {
      this.calculDevise((Session)null);
   }

   public void calculDevise(Session var1) throws HibernateException, NamingException {
      ObjetDevises var2;
      LectureDevises var3;
      Devise var4;
      float var5;
      float var6;
      float var7;
      float var8;
      if (this.nature == 11) {
         if (this.cotationEnteteAchats.getCotDevise() != null && !this.cotationEnteteAchats.getCotDevise().isEmpty()) {
            this.cotationEnteteAchats.setCotDevise(this.var_devise);
            this.var_format_devise = this.utilNombre.formatDevise(this.cotationEnteteAchats.getCotDevise());
            if (this.cotationEnteteAchats.getCotDevise().equals(this.structureLog.getStrdevise())) {
               this.cotationEnteteAchats.setCotCoefDevise(1.0F);
            } else {
               new ObjetDevises();
               var3 = new LectureDevises();
               new Devise();
               var4 = this.deviseDao.chargerLesDevises(this.cotationEnteteAchats.getCotDevise(), var1);
               if (var4 != null) {
                  var5 = var4.getDevTaux1();
                  var6 = var4.getDevTaux2();
                  if (var5 == 0.0F && var6 == 0.0F) {
                     var2 = var3.devisesRecherchee(this.structureLog.getStrdevise(), this.structureLog.getStrdevise());
                     var7 = Float.parseFloat(var2.getTaux1());
                     var8 = Float.parseFloat(var2.getTaux2());
                     this.cotationEnteteAchats.setCotCoefDevise(var7 * var8);
                  } else if (var5 != 0.0F) {
                     this.cotationEnteteAchats.setCotCoefDevise(var5);
                  } else if (var6 != 0.0F) {
                     this.cotationEnteteAchats.setCotCoefDevise(var6);
                  }
               } else {
                  this.cotationEnteteAchats.setCotCoefDevise(1.0F);
               }
            }

            this.var_coef_devise = this.cotationEnteteAchats.getCotCoefDevise();
         }
      } else if (this.nature == 12) {
         if (this.commandeEnteteAchats.getCmdDevise() != null && !this.commandeEnteteAchats.getCmdDevise().isEmpty()) {
            this.commandeEnteteAchats.setCmdDevise(this.var_devise);
            this.var_format_devise = this.utilNombre.formatDevise(this.commandeEnteteAchats.getCmdDevise());
            if (this.commandeEnteteAchats.getCmdDevise().equals(this.structureLog.getStrdevise())) {
               this.commandeEnteteAchats.setCmdCoefDevise(1.0F);
            } else {
               new ObjetDevises();
               var3 = new LectureDevises();
               new Devise();
               var4 = this.deviseDao.chargerLesDevises(this.commandeEnteteAchats.getCmdDevise(), var1);
               if (var4 != null) {
                  var5 = var4.getDevTaux1();
                  var6 = var4.getDevTaux2();
                  if (var5 == 0.0F && var6 == 0.0F) {
                     var2 = var3.devisesRecherchee(this.structureLog.getStrdevise(), this.structureLog.getStrdevise());
                     var7 = Float.parseFloat(var2.getTaux1());
                     var8 = Float.parseFloat(var2.getTaux2());
                     this.commandeEnteteAchats.setCmdCoefDevise(var7 * var8);
                  } else if (var5 != 0.0F) {
                     this.commandeEnteteAchats.setCmdCoefDevise(var5);
                  } else if (var6 != 0.0F) {
                     this.commandeEnteteAchats.setCmdCoefDevise(var6);
                  }
               } else {
                  this.commandeEnteteAchats.setCmdCoefDevise(1.0F);
               }
            }

            this.var_coef_devise = this.commandeEnteteAchats.getCmdCoefDevise();
         }
      } else if (this.nature == 500) {
      }

   }

   public void initChargerSimulation() throws HibernateException, NamingException {
      this.listeDetailFrais.clear();
      if (this.nature == 11) {
         this.listeDetailFrais = this.produitsFraisDao.chargeDetailSimulationCot(this.cotationEnteteAchats.getCotId(), (Session)null);
         this.var_devise = this.cotationEnteteAchats.getCotDevise();
         this.commandeEnteteAchats = null;
         this.produits = null;
      } else if (this.nature == 12) {
         this.listeDetailFrais = this.produitsFraisDao.chargeDetailSimulationCmd(this.commandeEnteteAchats.getCmdId(), (Session)null);
         this.var_devise = this.commandeEnteteAchats.getCmdDevise();
         this.cotationEnteteAchats = null;
         this.produits = null;
      } else if (this.nature == 500) {
         this.listeDetailFrais = this.produitsFraisDao.chargeDetailSimulationPrd(this.produits.getProId(), (Session)null);
         this.var_devise = this.structureLog.getStrdevise();
         this.commandeEnteteAchats = null;
         this.cotationEnteteAchats = null;
      }

      this.dataModelDetailFrais.setWrappedData(this.listeDetailFrais);
      this.produitsFrais = null;
      this.var_montant_initial = 0.0D;
      this.masquerFomrule = false;
      this.masquerColonneIntemediaire = false;
      this.var_exo_douane = 0;
      this.var_exo_tva = 0;
   }

   public void masquerAfficherFormules() {
      if (!this.masquerFomrule) {
         this.masquerFomrule = true;
      } else {
         this.masquerFomrule = false;
      }

   }

   public void masquerAfficherColonnes() {
      if (!this.masquerColonneIntemediaire) {
         this.masquerColonneIntemediaire = true;
      } else {
         this.masquerColonneIntemediaire = false;
      }

   }

   public void ajouerSimulation() throws HibernateException, NamingException {
      if (this.nature == 500 && this.produits != null) {
         this.mesSimulationItems.clear();
         this.mesSimulationItems = this.fraisTheoAchatsDao.chargerFraisEnteteItem(0, (Session)null);
         this.produitsFrais = new ProduitsFrais();
         this.var_date_simulation = new Date();
         this.var_devise = this.structureLog.getStrdevise();
         this.var_coef_devise = 1.0F;
         this.var_pa = this.produits.getPa();
         this.var_pa_local = 0.0D;
         this.var_fret = 0.0D;
         this.var_fret_local = 0.0D;
         this.var_assurance = 0.0D;
         this.var_assurance_local = 0.0D;
         this.var_montant_initial = 0.0D;
         this.var_cateorie = 0;
         this.var_id_transitaire = 0L;
         this.var_id_transporteur = 0L;
         this.var_mode = "";
         this.var_nature = 0;
         this.var_nom_transitaire = "";
         this.var_nom_transorteur = "";
         this.var_exo_tva = 0;
         this.var_exo_douane = 0;
         this.var_modele_simulation = this.produits.getProModelePr();
         this.afficheDevise();
         this.calculInit();
         this.var_ajout = true;
         this.var_enregistre = true;
         this.showModalPanelSimulation = true;
      } else if (this.nature == 11 && this.cotationEnteteAchats != null) {
         this.mesSimulationItems.clear();
         this.mesSimulationItems = this.fraisTheoAchatsDao.chargerFraisEnteteItem(1, (Session)null);
         this.produitsFrais = new ProduitsFrais();
         this.var_date_simulation = new Date();
         this.var_devise = this.cotationEnteteAchats.getCotDevise();
         this.var_coef_devise = this.cotationEnteteAchats.getCotCoefDevise();
         this.var_pa = this.cotationEnteteAchats.getCotTotHt();
         this.var_pa_local = 0.0D;
         this.var_fret = 0.0D;
         this.var_fret_local = 0.0D;
         this.var_assurance = 0.0D;
         this.var_assurance_local = 0.0D;
         this.var_montant_initial = 0.0D;
         this.var_cateorie = 0;
         this.var_id_transitaire = 0L;
         this.var_id_transporteur = 0L;
         this.var_mode = "";
         this.var_nature = 0;
         this.var_nom_transitaire = "";
         this.var_nom_transorteur = "";
         this.var_exo_tva = 0;
         this.var_exo_douane = 0;
         this.var_modele_simulation = this.cotationEnteteAchats.getCotModelePr();
         this.afficheDevise();
         this.calculInit();
         this.var_ajout = true;
         this.var_enregistre = true;
         this.showModalPanelSimulation = true;
      } else if (this.nature == 12 && this.commandeEnteteAchats != null) {
         this.mesSimulationItems.clear();
         this.mesSimulationItems = this.fraisTheoAchatsDao.chargerFraisEnteteItem(2, (Session)null);
         this.produitsFrais = new ProduitsFrais();
         this.var_date_simulation = new Date();
         this.var_devise = this.commandeEnteteAchats.getCmdDevise();
         this.var_coef_devise = this.commandeEnteteAchats.getCmdCoefDevise();
         this.var_pa = this.commandeEnteteAchats.getCmdTotHt();
         this.var_pa_local = 0.0D;
         this.var_fret = 0.0D;
         this.var_fret_local = 0.0D;
         this.var_assurance = 0.0D;
         this.var_assurance_local = 0.0D;
         this.var_montant_initial = 0.0D;
         this.var_cateorie = 0;
         this.var_id_transitaire = 0L;
         this.var_id_transporteur = 0L;
         this.var_mode = "";
         this.var_nature = 0;
         this.var_nom_transitaire = "";
         this.var_nom_transorteur = "";
         this.var_exo_tva = 0;
         this.var_exo_douane = 0;
         this.var_modele_simulation = this.commandeEnteteAchats.getCmdModelePr();
         this.afficheDevise();
         this.calculInit();
         this.var_ajout = true;
         this.var_enregistre = true;
         this.showModalPanelSimulation = true;
      }

   }

   public void afficheDevise() throws HibernateException, NamingException {
      this.calculDevise();
      if (this.nature == 11) {
         if (this.cotationEnteteAchats.getCotDevise().equals(this.structureLog.getStrdevise())) {
            this.affiche_devise = false;
         } else {
            this.affiche_devise = true;
         }
      } else if (this.nature == 12) {
         if (this.commandeEnteteAchats.getCmdDevise().equals(this.structureLog.getStrdevise())) {
            this.affiche_devise = false;
         } else {
            this.affiche_devise = true;
         }
      } else if (this.nature == 500) {
         this.affiche_devise = true;
      }

   }

   public void calculInit() throws HibernateException, NamingException {
      if (this.var_coef_devise == 0.0F) {
         this.var_coef_devise = 1.0F;
      }

      double var1 = this.utilNombre.myRoundDevise(this.var_pa * (double)this.var_coef_devise, this.structureLog.getStrdevise());
      double var3 = this.utilNombre.myRoundDevise(this.var_fret * (double)this.var_coef_devise, this.structureLog.getStrdevise());
      double var5 = this.utilNombre.myRoundDevise(this.var_assurance * (double)this.var_coef_devise, this.structureLog.getStrdevise());
      double var7 = this.utilNombre.myRoundDevise(var1 + var3 + var5, this.structureLog.getStrdevise());
      this.var_pa_local = var1;
      this.var_fret_local = var3;
      this.var_assurance_local = var5;
      this.var_montant_initial = var7;
      this.lesVariablesSaisir.clear();
      new ArrayList();
      int var10;
      if (this.var_modele_simulation != null && !this.var_modele_simulation.isEmpty()) {
         List var9 = this.fraisTheoAchatsDao.chargerFraisLignes(this.var_modele_simulation, "", 99, (Session)null);
         if (var9.size() != 0) {
            this.fraisTheoAchats = new FraisTheoAchats();

            for(var10 = 0; var10 < var9.size(); ++var10) {
               this.fraisTheoAchats = (FraisTheoAchats)var9.get(var10);
               if (this.fraisTheoAchats.getFstFormuleA() != null && !this.fraisTheoAchats.getFstFormuleA().isEmpty() && this.fraisTheoAchats.getFstFormuleA().equals("VAR()")) {
                  this.objetTable = new ObjetTable();
                  this.objetTable.setColumn_code(this.fraisTheoAchats.getFstCode());
                  this.objetTable.setColumn_name(this.fraisTheoAchats.getFstNomFr());
                  this.objetTable.setColumn_type("A");
                  this.objetTable.setColumn_pr(0.0D);
                  this.lesVariablesSaisir.add(this.objetTable);
               }

               if (this.fraisTheoAchats.getFstFormuleB() != null && !this.fraisTheoAchats.getFstFormuleB().isEmpty() && this.fraisTheoAchats.getFstFormuleB().equals("VAR()")) {
                  this.objetTable = new ObjetTable();
                  this.objetTable.setColumn_code(this.fraisTheoAchats.getFstCode());
                  this.objetTable.setColumn_name(this.fraisTheoAchats.getFstNomFr());
                  this.objetTable.setColumn_type("B");
                  this.objetTable.setColumn_pr(0.0D);
                  this.lesVariablesSaisir.add(this.objetTable);
               }

               if (this.fraisTheoAchats.getFstFormuleC() != null && !this.fraisTheoAchats.getFstFormuleC().isEmpty() && this.fraisTheoAchats.getFstFormuleC().equals("VAR()")) {
                  this.objetTable = new ObjetTable();
                  this.objetTable.setColumn_code(this.fraisTheoAchats.getFstCode());
                  this.objetTable.setColumn_name(this.fraisTheoAchats.getFstNomFr());
                  this.objetTable.setColumn_type("C");
                  this.objetTable.setColumn_pr(0.0D);
                  this.lesVariablesSaisir.add(this.objetTable);
               }

               if (this.fraisTheoAchats.getFstFormuleD() != null && !this.fraisTheoAchats.getFstFormuleD().isEmpty() && this.fraisTheoAchats.getFstFormuleD().equals("VAR()")) {
                  this.objetTable = new ObjetTable();
                  this.objetTable.setColumn_code(this.fraisTheoAchats.getFstCode());
                  this.objetTable.setColumn_name(this.fraisTheoAchats.getFstNomFr());
                  this.objetTable.setColumn_type("D");
                  this.objetTable.setColumn_pr(0.0D);
                  this.lesVariablesSaisir.add(this.objetTable);
               }

               if (this.fraisTheoAchats.getFstFormuleE() != null && !this.fraisTheoAchats.getFstFormuleE().isEmpty() && this.fraisTheoAchats.getFstFormuleE().equals("VAR()")) {
                  this.objetTable = new ObjetTable();
                  this.objetTable.setColumn_code(this.fraisTheoAchats.getFstCode());
                  this.objetTable.setColumn_name(this.fraisTheoAchats.getFstNomFr());
                  this.objetTable.setColumn_type("E");
                  this.objetTable.setColumn_pr(0.0D);
                  this.lesVariablesSaisir.add(this.objetTable);
               }
            }
         }
      }

      this.dataModelVariables.setWrappedData(this.lesVariablesSaisir);
      if (this.lesVariablesSaisir.size() != 0) {
         if (this.listeDetailFrais.size() != 0) {
            this.objetTable = new ObjetTable();

            for(var10 = 0; var10 < this.lesVariablesSaisir.size(); ++var10) {
               this.objetTable = (ObjetTable)this.lesVariablesSaisir.get(var10);
               this.objetTable.setExo_douane(this.produitsFrais.getProfrsExoDouane());
               this.var_exo_douane = this.produitsFrais.getProfrsExoDouane();
               this.objetTable.setExo_tva(this.produitsFrais.getProfrsExoTva());
               this.var_exo_tva = this.produitsFrais.getProfrsExoTva();
               this.objetTable.setCoef_prp(this.produitsFrais.getProfrsCoefPrp());
               this.var_coef_prp = this.produitsFrais.getProfrsCoefPrp();

               for(int var11 = 0; var11 < this.listeDetailFrais.size(); ++var11) {
                  this.produitsFrais = (ProduitsFrais)this.listeDetailFrais.get(var11);
                  if (this.produitsFrais.getProfrsCode().equals(this.objetTable.getColumn_code())) {
                     if (this.objetTable.getColumn_type().equals("A")) {
                        this.objetTable.setColumn_pr(this.produitsFrais.getProfrsValA());
                     } else if (this.objetTable.getColumn_type().equals("B")) {
                        this.objetTable.setColumn_pr(this.produitsFrais.getProfrsValB());
                     } else if (this.objetTable.getColumn_type().equals("C")) {
                        this.objetTable.setColumn_pr(this.produitsFrais.getProfrsValC());
                     } else if (this.objetTable.getColumn_type().equals("D")) {
                        this.objetTable.setColumn_pr(this.produitsFrais.getProfrsValD());
                     } else if (this.objetTable.getColumn_type().equals("E")) {
                        this.objetTable.setColumn_pr(this.produitsFrais.getProfrsValE());
                     }
                     break;
                  }
               }
            }
         }

         this.affichageListeVariable = true;
      } else {
         this.affichageListeVariable = false;
      }

   }

   public void chargerPRP(Session var1) throws HibernateException, NamingException {
      this.chargerDevise(var1);
      double var2 = 0.0D;
      this.listeDetailFraisTransporteur.clear();
      this.listeDetailFraisTranstaire.clear();
      new ArrayList();
      List var4 = this.produitsFraisDao.chargeDetailSimulationCotTiers(this.cotationEnteteAchats.getCotId(), var1);
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            this.produitsFrais = (ProduitsFrais)var4.get(var5);
            var2 += this.produitsFrais.getProfrsValELocal();
            if (this.produitsFrais.getProfrsIdTransporteur() != 0L && this.produitsFrais.getProfrsIdTransporteur() == this.cotationEnteteAchats.getCotIdTransporteur()) {
               this.listeDetailFraisTransporteur.add(this.produitsFrais);
            } else if (this.produitsFrais.getProfrsIdTransitaire() != 0L && this.produitsFrais.getProfrsIdTransitaire() == this.cotationEnteteAchats.getCotIdTansitaire()) {
               this.listeDetailFraisTranstaire.add(this.produitsFrais);
            }
         }
      }

      this.dataModelDetailFraisTransporteur.setWrappedData(this.listeDetailFraisTransporteur);
      this.dataModelDetailFraisTransitaire.setWrappedData(this.listeDetailFraisTranstaire);
   }

   public void initChargerPartTransporteur() throws HibernateException, NamingException {
      this.chargerDevise((Session)null);
      this.var_coef_devise = this.cotationEnteteAchats.getCotCoefDevise();
      if (this.var_coef_devise == 0.0F) {
         this.var_coef_devise = 1.0F;
      }

      if (this.cotationEnteteAchats.getCotIdTransporteur() != 0L && this.chaineTransporteur != null && !this.chaineTransporteur.isEmpty() && this.chaineTransporteur.contains(":")) {
         String[] var1 = this.chaineTransporteur.split(":");
         this.var_id_transitaire = 0L;
         this.var_id_transporteur = this.cotationEnteteAchats.getCotIdTransporteur();
         this.var_cateorie = 0;
         this.var_nom_transitaire = "";
         this.var_nom_transorteur = var1[0];
         String var2 = var1[1];
         if (var2.equalsIgnoreCase("avion")) {
            this.var_nature = 0;
         } else if (var2.equalsIgnoreCase("bateau")) {
            this.var_nature = 1;
         } else if (var2.equalsIgnoreCase("express")) {
            this.var_nature = 2;
         } else if (var2.equalsIgnoreCase("route")) {
            this.var_nature = 3;
         } else if (var2.equalsIgnoreCase("train")) {
            this.var_nature = 4;
         } else {
            this.var_nature = 99;
         }

         this.var_mode = var1[2];
      } else {
         this.var_id_transitaire = 0L;
         this.var_id_transporteur = 0L;
         this.var_cateorie = 0;
         this.var_mode = "";
         this.var_nature = 0;
         this.var_nom_transitaire = "";
         this.var_nom_transorteur = "";
      }

      this.var_pa = this.cotationEnteteAchats.getCotTotHt();
      this.var_fret = 0.0D;
      this.var_assurance = 0.0D;
      this.var_pa_local = 0.0D;
      this.var_fret_local = 0.0D;
      this.var_assurance_local = 0.0D;
      this.var_montant_initial = 0.0D;
      this.var_exo_tva = this.cotationEnteteAchats.getCotExoTva();
      this.var_exo_douane = this.cotationEnteteAchats.getCotExoDouane();
      this.lesVariablesSaisir.clear();
      this.listeDetailFraisTransporteur.clear();
      new ArrayList();
      List var3 = this.fraisTheoAchatsDao.chargerFraisLignes(this.var_id_transporteur, this.var_mode, this.var_nature, (Session)null);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            this.fraisTheoAchats = (FraisTheoAchats)var3.get(var4);
            this.produitsFrais = new ProduitsFrais();
            this.produitsFrais.setProfrsAffaire(this.cotationEnteteAchats.getCotAnal4());
            this.produitsFrais.setProfrsCaf(0.0D);
            this.produitsFrais.setProfrsCategorie(this.fraisTheoAchats.getFstCategorie());
            this.produitsFrais.setProfrsCmd("");
            this.produitsFrais.setProfrsRubrique(this.fraisTheoAchats.getFstRubrique());
            this.produitsFrais.setProfrsCode(this.fraisTheoAchats.getFstCode());
            this.produitsFrais.setProfrsCoefDevise(0.0F);
            this.produitsFrais.setProfrsCoefPrp(0.0F);
            this.produitsFrais.setProfrsColType(this.fraisTheoAchats.getFstColType());
            this.produitsFrais.setProfrsCot(this.cotationEnteteAchats.getCotNum());
            this.produitsFrais.setProfrsDate(this.cotationEnteteAchats.getCotDate());
            this.produitsFrais.setProfrsDecimalA(this.fraisTheoAchats.getFstDecimalA());
            this.produitsFrais.setProfrsDecimalB(this.fraisTheoAchats.getFstDecimalB());
            this.produitsFrais.setProfrsDecimalC(this.fraisTheoAchats.getFstDecimalC());
            this.produitsFrais.setProfrsDecimalD(this.fraisTheoAchats.getFstDecimalD());
            this.produitsFrais.setProfrsDecimalE(this.fraisTheoAchats.getFstDecimalE());
            this.produitsFrais.setProfrsDecimalF(this.fraisTheoAchats.getFstDecimalF());
            if (this.fraisTheoAchats.getFstDevise() != null && !this.fraisTheoAchats.getFstDevise().isEmpty()) {
               this.produitsFrais.setProfrsDevise(this.fraisTheoAchats.getFstDevise());
            } else {
               this.produitsFrais.setProfrsDevise(this.cotationEnteteAchats.getCotDevise());
            }

            this.produitsFrais.setProfrsExoDouane(this.cotationEnteteAchats.getCotExoDouane());
            this.produitsFrais.setProfrsExoTva(this.cotationEnteteAchats.getCotExoTva());
            this.produitsFrais.setProfrsFeuille(this.fraisTheoAchats.getFstFeuille());
            this.produitsFrais.setProfrsFormuleA(this.fraisTheoAchats.getFstFormuleA());
            this.produitsFrais.setProfrsFormuleB(this.fraisTheoAchats.getFstFormuleB());
            this.produitsFrais.setProfrsFormuleC(this.fraisTheoAchats.getFstFormuleC());
            this.produitsFrais.setProfrsFormuleD(this.fraisTheoAchats.getFstFormuleD());
            this.produitsFrais.setProfrsFormuleE(this.fraisTheoAchats.getFstFormuleE());
            this.produitsFrais.setProfrsFormuleF(this.fraisTheoAchats.getFstFormuleF());
            this.produitsFrais.setProfrsIdCmd(0L);
            this.produitsFrais.setProfrsIdCot(this.cotationEnteteAchats.getCotId());
            this.produitsFrais.setProfrsIdPro(0L);
            this.produitsFrais.setProfrsIdTransitaire(0L);
            this.produitsFrais.setProfrsIdTransporteur(this.cotationEnteteAchats.getCotIdTransporteur());
            this.produitsFrais.setProfrsLibelle(this.fraisTheoAchats.getFstNomFr());
            this.produitsFrais.setProfrsMode(this.fraisTheoAchats.getFstMode());
            this.produitsFrais.setProfrsNature(this.fraisTheoAchats.getFstNature());
            this.produitsFrais.setProfrsNomTransitaire("");
            this.produitsFrais.setProfrsNomTransporteur(this.fraisTheoAchats.getFstFeuille());
            this.produitsFrais.setProfrsNum("");
            this.produitsFrais.setProfrsOrdre(this.fraisTheoAchats.getFstOrdre());
            this.produitsFrais.setProfrsPA(0.0D);
            this.produitsFrais.setProfrsProduit("");
            this.produitsFrais.setProfrsReponse(this.fraisTheoAchats.getFstReponse());
            this.produitsFrais.setProfrsRubrique(this.fraisTheoAchats.getFstRubrique());
            this.produitsFrais.setProfrsTranche(this.fraisTheoAchats.getFstTranche());
            this.produitsFrais.setProfrsTrancheA(this.fraisTheoAchats.getFstTrancheA());
            this.produitsFrais.setProfrsTrancheB(this.fraisTheoAchats.getFstTrancheB());
            this.produitsFrais.setProfrsTrancheC(this.fraisTheoAchats.getFstTrancheC());
            this.produitsFrais.setProfrsTrancheD(this.fraisTheoAchats.getFstTrancheD());
            this.produitsFrais.setProfrsTrancheE(this.fraisTheoAchats.getFstTrancheE());
            this.produitsFrais.setProfrsTrancheF(this.fraisTheoAchats.getFstTrancheF());
            this.produitsFrais.setProfrsType(this.fraisTheoAchats.getFstType());
            this.produitsFrais.setProfrsValA(0.0D);
            this.produitsFrais.setProfrsValB(0.0D);
            this.produitsFrais.setProfrsValC(0.0D);
            this.produitsFrais.setProfrsValD(0.0D);
            this.produitsFrais.setProfrsValE(0.0D);
            this.produitsFrais.setProfrsValF(0.0D);
            this.listeDetailFraisTransporteur.add(this.produitsFrais);
         }
      }

      if (this.dataModelDetailFraisTransporteur == null) {
         this.dataModelDetailFraisTransporteur = new ListDataModel();
      }

      this.dataModelDetailFraisTransporteur.setWrappedData(this.listeDetailFraisTransporteur);
   }

   public void calculPartTransporteur() throws HibernateException, NamingException {
      if (this.listeDetailFraisTransporteur.size() != 0) {
         this.listeDetailFrais.clear();

         int var1;
         for(var1 = 0; var1 < this.listeDetailFraisTransporteur.size(); ++var1) {
            this.listeDetailFrais.add(this.listeDetailFraisTransporteur.get(var1));
         }

         this.typeListe = 1;
         this.calculeSimulation();
         this.listeDetailFraisTransporteur.clear();

         for(var1 = 0; var1 < this.listeDetailFrais.size(); ++var1) {
            this.listeDetailFraisTransporteur.add(this.listeDetailFrais.get(var1));
         }

         this.dataModelDetailFraisTransporteur.setWrappedData(this.listeDetailFraisTransporteur);
      }

   }

   public void initChargerPartTransitaire() throws HibernateException, NamingException {
      this.chargerDevise((Session)null);
      this.var_coef_devise = this.cotationEnteteAchats.getCotCoefDevise();
      if (this.var_coef_devise == 0.0F) {
         this.var_coef_devise = 1.0F;
      }

      if (this.cotationEnteteAchats.getCotIdTansitaire() != 0L && this.chaineTransitaire != null && !this.chaineTransitaire.isEmpty() && this.chaineTransitaire.contains(":")) {
         String[] var1 = this.chaineTransitaire.split(":");
         this.var_id_transitaire = this.cotationEnteteAchats.getCotIdTansitaire();
         this.var_id_transporteur = 0L;
         this.var_cateorie = 0;
         this.var_nom_transitaire = var1[0];
         this.var_nom_transorteur = "";
         String var2 = var1[1];
         if (var2.equalsIgnoreCase("avion")) {
            this.var_nature = 0;
         } else if (var2.equalsIgnoreCase("bateau")) {
            this.var_nature = 1;
         } else if (var2.equalsIgnoreCase("express")) {
            this.var_nature = 2;
         } else if (var2.equalsIgnoreCase("route")) {
            this.var_nature = 3;
         } else if (var2.equalsIgnoreCase("train")) {
            this.var_nature = 4;
         } else {
            this.var_nature = 99;
         }

         this.var_mode = var1[2];
      } else {
         this.var_id_transitaire = 0L;
         this.var_id_transporteur = 0L;
         this.var_cateorie = 0;
         this.var_mode = "";
         this.var_nature = 0;
         this.var_nom_transitaire = "";
         this.var_nom_transorteur = "";
      }

      this.var_pa = this.cotationEnteteAchats.getCotTotHt();
      this.var_fret = 0.0D;
      this.var_assurance = 0.0D;
      this.var_pa_local = 0.0D;
      this.var_fret_local = 0.0D;
      this.var_assurance_local = 0.0D;
      this.var_montant_initial = 0.0D;
      this.var_exo_tva = this.cotationEnteteAchats.getCotExoTva();
      this.var_exo_douane = this.cotationEnteteAchats.getCotExoDouane();
      this.lesVariablesSaisir.clear();
      this.listeDetailFraisTranstaire.clear();
      new ArrayList();
      List var3 = this.fraisTheoAchatsDao.chargerFraisLignes(this.var_id_transitaire, this.var_mode, this.var_nature, (Session)null);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            this.fraisTheoAchats = (FraisTheoAchats)var3.get(var4);
            this.produitsFrais = new ProduitsFrais();
            this.produitsFrais.setProfrsAffaire(this.cotationEnteteAchats.getCotAnal4());
            this.produitsFrais.setProfrsCaf(0.0D);
            this.produitsFrais.setProfrsCategorie(this.fraisTheoAchats.getFstCategorie());
            this.produitsFrais.setProfrsCmd("");
            this.produitsFrais.setProfrsCode(this.fraisTheoAchats.getFstCode());
            this.produitsFrais.setProfrsCoefDevise(0.0F);
            this.produitsFrais.setProfrsCoefPrp(0.0F);
            this.produitsFrais.setProfrsColType(this.fraisTheoAchats.getFstColType());
            this.produitsFrais.setProfrsCot(this.cotationEnteteAchats.getCotNum());
            this.produitsFrais.setProfrsDate(this.cotationEnteteAchats.getCotDate());
            this.produitsFrais.setProfrsDecimalA(this.fraisTheoAchats.getFstDecimalA());
            this.produitsFrais.setProfrsDecimalB(this.fraisTheoAchats.getFstDecimalB());
            this.produitsFrais.setProfrsDecimalC(this.fraisTheoAchats.getFstDecimalC());
            this.produitsFrais.setProfrsDecimalD(this.fraisTheoAchats.getFstDecimalD());
            this.produitsFrais.setProfrsDecimalE(this.fraisTheoAchats.getFstDecimalE());
            this.produitsFrais.setProfrsDecimalF(this.fraisTheoAchats.getFstDecimalF());
            if (this.fraisTheoAchats.getFstDevise() != null && !this.fraisTheoAchats.getFstDevise().isEmpty()) {
               this.produitsFrais.setProfrsDevise(this.fraisTheoAchats.getFstDevise());
            } else {
               this.produitsFrais.setProfrsDevise(this.cotationEnteteAchats.getCotDevise());
            }

            this.produitsFrais.setProfrsExoDouane(this.cotationEnteteAchats.getCotExoDouane());
            this.produitsFrais.setProfrsExoTva(this.cotationEnteteAchats.getCotExoTva());
            this.produitsFrais.setProfrsFeuille(this.fraisTheoAchats.getFstFeuille());
            this.produitsFrais.setProfrsFormuleA(this.fraisTheoAchats.getFstFormuleA());
            this.produitsFrais.setProfrsFormuleB(this.fraisTheoAchats.getFstFormuleB());
            this.produitsFrais.setProfrsFormuleC(this.fraisTheoAchats.getFstFormuleC());
            this.produitsFrais.setProfrsFormuleD(this.fraisTheoAchats.getFstFormuleD());
            this.produitsFrais.setProfrsFormuleE(this.fraisTheoAchats.getFstFormuleE());
            this.produitsFrais.setProfrsFormuleF(this.fraisTheoAchats.getFstFormuleF());
            this.produitsFrais.setProfrsFret(0.0D);
            this.produitsFrais.setProfrsIdCmd(0L);
            this.produitsFrais.setProfrsIdCot(this.cotationEnteteAchats.getCotId());
            this.produitsFrais.setProfrsIdPro(0L);
            this.produitsFrais.setProfrsIdTransitaire(this.cotationEnteteAchats.getCotIdTansitaire());
            this.produitsFrais.setProfrsIdTransporteur(0L);
            this.produitsFrais.setProfrsLibelle(this.fraisTheoAchats.getFstNomFr());
            this.produitsFrais.setProfrsMode(this.fraisTheoAchats.getFstMode());
            this.produitsFrais.setProfrsNature(this.fraisTheoAchats.getFstNature());
            this.produitsFrais.setProfrsNomTransitaire(this.fraisTheoAchats.getFstFeuille());
            this.produitsFrais.setProfrsNomTransporteur("");
            this.produitsFrais.setProfrsNum("");
            this.produitsFrais.setProfrsOrdre(this.fraisTheoAchats.getFstOrdre());
            this.produitsFrais.setProfrsPA(0.0D);
            this.produitsFrais.setProfrsProduit("");
            this.produitsFrais.setProfrsReponse(this.fraisTheoAchats.getFstReponse());
            this.produitsFrais.setProfrsRubrique(this.fraisTheoAchats.getFstRubrique());
            this.produitsFrais.setProfrsTranche(this.fraisTheoAchats.getFstTranche());
            this.produitsFrais.setProfrsTrancheA(this.fraisTheoAchats.getFstTrancheA());
            this.produitsFrais.setProfrsTrancheB(this.fraisTheoAchats.getFstTrancheB());
            this.produitsFrais.setProfrsTrancheC(this.fraisTheoAchats.getFstTrancheC());
            this.produitsFrais.setProfrsTrancheD(this.fraisTheoAchats.getFstTrancheD());
            this.produitsFrais.setProfrsTrancheE(this.fraisTheoAchats.getFstTrancheE());
            this.produitsFrais.setProfrsTrancheF(this.fraisTheoAchats.getFstTrancheF());
            this.produitsFrais.setProfrsType(this.fraisTheoAchats.getFstType());
            this.produitsFrais.setProfrsValA(0.0D);
            this.produitsFrais.setProfrsValB(0.0D);
            this.produitsFrais.setProfrsValC(0.0D);
            this.produitsFrais.setProfrsValD(0.0D);
            this.produitsFrais.setProfrsValE(0.0D);
            this.produitsFrais.setProfrsValF(0.0D);
            this.listeDetailFraisTranstaire.add(this.produitsFrais);
         }
      }

      if (this.dataModelDetailFraisTransitaire == null) {
         this.dataModelDetailFraisTransitaire = new ListDataModel();
      }

      this.dataModelDetailFraisTransitaire.setWrappedData(this.listeDetailFraisTranstaire);
   }

   public void calculPartTransitaire() throws HibernateException, NamingException {
      if (this.listeDetailFraisTranstaire.size() != 0) {
         this.listeDetailFrais.clear();

         int var1;
         for(var1 = 0; var1 < this.listeDetailFraisTranstaire.size(); ++var1) {
            this.listeDetailFrais.add(this.listeDetailFraisTranstaire.get(var1));
         }

         this.typeListe = 2;
         this.calculeSimulation();
         this.listeDetailFraisTranstaire.clear();

         for(var1 = 0; var1 < this.listeDetailFrais.size(); ++var1) {
            this.listeDetailFraisTranstaire.add(this.listeDetailFrais.get(var1));
         }

         this.dataModelDetailFraisTransitaire.setWrappedData(this.listeDetailFraisTranstaire);
      }

   }

   public void initChargerPartDouane(OptionAchats var1) throws HibernateException, NamingException {
      double var4;
      if (this.lesLignesListCotations.size() != 0 && this.cotationEnteteAchats.getCotType() == 0) {
         this.optionAchats = var1;
         new DouanesPosition();
         DouanesPositionDao var3 = new DouanesPositionDao(this.baseLog, this.utilInitHibernate);
         var4 = this.cotationEnteteAchats.getCotTotHt() * (double)this.cotationEnteteAchats.getCotCoefDevise();
         double var15 = this.calculeCaf();
         new CotationLigneAchats();

         for(int var9 = 0; var9 < this.lesLignesListCotations.size(); ++var9) {
            CotationLigneAchats var16 = (CotationLigneAchats)this.lesLignesListCotations.get(var9);
            if (var16.getCotligPt() != 0.0D) {
               double var10 = var16.getCotligPt() * (double)this.cotationEnteteAchats.getCotCoefDevise() / var4;
               var16.setCotligCaf(var15 * var10);
               double var12 = var16.getCotligCaf();
               if (var16.getCotligPosTarifaire() != null && !var16.getCotligPosTarifaire().isEmpty()) {
                  DouanesPosition var14;
                  if (this.cotationEnteteAchats.getCotExoDouane() == 0) {
                     var14 = var3.trouverPosition(this.structureLog.getStrzonecommerciale(), var16.getCotligPosTarifaire(), (Session)null);
                     if (var14 != null) {
                        var16.setCotligT1(var12 * (double)var14.getDouposDd() / 100.0D);
                        var16.setCotligT3(var12 * (double)var14.getDouposRs() / 100.0D);
                        var16.setCotligT5(var12 * (double)var14.getDouposTva() / 100.0D);
                        var16.setCotligT10(var12 * (double)var14.getDouposPcs() / 100.0D);
                        var16.setCotligT30(var12 * (double)var14.getDouposAd() / 100.0D);
                        var16.setCotligT31(var12 * (double)var14.getDouposDa() / 100.0D);
                        var16.setCotligT46(var12 * (double)var14.getDoupos46() / 100.0D);
                        var16.setCotligT53(var12 * (double)var14.getDoupos53() / 100.0D);
                     } else {
                        var16.setCotligT1(0.0D);
                        var16.setCotligT3(0.0D);
                        var16.setCotligT5(0.0D);
                        var16.setCotligT10(0.0D);
                        var16.setCotligT30(0.0D);
                        var16.setCotligT31(0.0D);
                        var16.setCotligT46(0.0D);
                        var16.setCotligT53(0.0D);
                     }
                  } else if (this.cotationEnteteAchats.getCotExoDouane() == 1) {
                     var16.setCotligT1(0.0D);
                     var16.setCotligT3(0.0D);
                     var16.setCotligT5(0.0D);
                     var16.setCotligT10(0.0D);
                     var16.setCotligT30(0.0D);
                     var16.setCotligT31(0.0D);
                     var16.setCotligT46(0.0D);
                     var16.setCotligT53(0.0D);
                  } else if (this.cotationEnteteAchats.getCotExoDouane() == 2) {
                     var14 = var3.trouverPosition(this.structureLog.getStrzonecommerciale(), var16.getCotligPosTarifaire(), (Session)null);
                     if (var14 != null) {
                        var16.setCotligT1(var12 * (double)this.optionAchats.getTauxReduit() / 100.0D);
                        var16.setCotligT3(var12 * (double)var14.getDouposRs() / 100.0D);
                        var16.setCotligT5(var12 * (double)var14.getDouposTva() / 100.0D);
                        var16.setCotligT10(var12 * (double)var14.getDouposPcs() / 100.0D);
                        var16.setCotligT30(var12 * (double)var14.getDouposAd() / 100.0D);
                        var16.setCotligT31(var12 * (double)var14.getDouposDa() / 100.0D);
                        var16.setCotligT46(var12 * (double)var14.getDoupos46() / 100.0D);
                        var16.setCotligT53(var12 * (double)var14.getDoupos53() / 100.0D);
                     } else {
                        var16.setCotligT1(0.0D);
                        var16.setCotligT3(0.0D);
                        var16.setCotligT5(0.0D);
                        var16.setCotligT10(0.0D);
                        var16.setCotligT30(0.0D);
                        var16.setCotligT31(0.0D);
                        var16.setCotligT46(0.0D);
                        var16.setCotligT53(0.0D);
                     }
                  }
               } else {
                  var16.setCotligT1(0.0D);
                  var16.setCotligT3(0.0D);
                  var16.setCotligT5(0.0D);
                  var16.setCotligT10(0.0D);
                  var16.setCotligT30(0.0D);
                  var16.setCotligT31(0.0D);
                  var16.setCotligT46(0.0D);
                  var16.setCotligT53(0.0D);
               }

               if (this.optionAchats.getTauxRusid() != 0.0F) {
                  var16.setCotligRusid(var12 * (double)this.optionAchats.getTauxRusid() / 100.0D);
               } else {
                  var16.setCotligRusid(0.0D);
               }
            }
         }

         this.dataModelDetailFraisDouanes.setWrappedData(this.lesLignesListCotations);
      } else {
         double var2;
         CotationLigneAchats var6;
         int var7;
         double var8;
         if (this.lesLignesListCotations.size() != 0 && this.cotationEnteteAchats.getCotType() == 1) {
            var2 = this.cotationEnteteAchats.getCotTotHt() * (double)this.cotationEnteteAchats.getCotCoefDevise();
            var4 = this.calculeCaf();
            new CotationLigneAchats();

            for(var7 = 0; var7 < this.lesLignesListCotations.size(); ++var7) {
               var6 = (CotationLigneAchats)this.lesLignesListCotations.get(var7);
               if (var6.getCotligPt() != 0.0D) {
                  var8 = var6.getCotligPt() * (double)this.cotationEnteteAchats.getCotCoefDevise() / var2;
                  var6.setCotligCaf(var4 * var8);
                  var6.setCotligT1(0.0D);
                  var6.setCotligT3(0.0D);
                  var6.setCotligT5(0.0D);
                  var6.setCotligT10(0.0D);
                  var6.setCotligT30(0.0D);
                  var6.setCotligT31(0.0D);
                  var6.setCotligT46(0.0D);
                  var6.setCotligT53(0.0D);
                  var6.setCotligRusid(0.0D);
               }
            }

            this.dataModelDetailFraisDouanes.setWrappedData(this.lesLignesListCotations);
         } else if (this.lesLignesListCotations.size() != 0 && this.cotationEnteteAchats.getCotType() == 2) {
            this.cotationEnteteAchats.setCotCoefDevise(1.0F);
            var2 = this.cotationEnteteAchats.getCotTotHt() * (double)this.cotationEnteteAchats.getCotCoefDevise();
            var4 = this.calculeCaf();
            new CotationLigneAchats();

            for(var7 = 0; var7 < this.lesLignesListCotations.size(); ++var7) {
               var6 = (CotationLigneAchats)this.lesLignesListCotations.get(var7);
               if (var6.getCotligPt() != 0.0D) {
                  var8 = var6.getCotligPt() * (double)this.cotationEnteteAchats.getCotCoefDevise() / var2;
                  var6.setCotligCaf(var4 * var8);
                  var6.setCotligT1(0.0D);
                  var6.setCotligT3(0.0D);
                  var6.setCotligT5(0.0D);
                  var6.setCotligT10(0.0D);
                  var6.setCotligT30(0.0D);
                  var6.setCotligT31(0.0D);
                  var6.setCotligT46(0.0D);
                  var6.setCotligT53(0.0D);
                  var6.setCotligRusid(0.0D);
               }
            }

            this.dataModelDetailFraisDouanes.setWrappedData(this.lesLignesListCotations);
         }
      }

   }

   public void validerSimulationTiersCotation(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      this.supprimerSimulationTiersCotation(var1);
      String var4 = this.produitsFraisDao.rechercheDernier(var1);
      ProduitsFrais var5;
      int var6;
      if (this.listeDetailFraisTransporteur.size() != 0) {
         new ProduitsFrais();

         for(var6 = 0; var6 < this.listeDetailFraisTransporteur.size(); ++var6) {
            var5 = (ProduitsFrais)this.listeDetailFraisTransporteur.get(var6);
            var5.setProfrsNum(var4);
            var5.setProfrsOrdre(var6);
            this.produitsFraisDao.insert(var5, var1);
         }
      }

      if (this.listeDetailFraisTranstaire.size() != 0) {
         new ProduitsFrais();

         for(var6 = 0; var6 < this.listeDetailFraisTranstaire.size(); ++var6) {
            var5 = (ProduitsFrais)this.listeDetailFraisTranstaire.get(var6);
            var5.setProfrsNum(var4);
            var5.setProfrsOrdre(var6);
            this.produitsFraisDao.insert(var5, var1);
         }
      }

      if (this.lesLignesListCotations.size() != 0) {
         CotationLigneAchatsDao var8 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         new CotationLigneAchats();

         for(int var7 = 0; var7 < this.lesLignesListCotations.size(); ++var7) {
            CotationLigneAchats var9 = (CotationLigneAchats)this.lesLignesListCotations.get(var7);
            var8.modifLigne(var9, var1);
         }
      }

      this.calculPV(var1);
   }

   public void validerSimulation() throws HibernateException, NamingException {
      if (this.var_modele_simulation != null && !this.var_modele_simulation.isEmpty()) {
         this.supprimerSimulation();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.listeDetailFrais.clear();
            new ArrayList();
            List var3 = this.fraisTheoAchatsDao.chargerFraisLignes(this.var_modele_simulation, "", 99, var1);
            String var4 = "";
            if (var3.size() != 0) {
               var4 = this.produitsFraisDao.rechercheDernier(var1);
               new FraisTheoAchats();

               int var6;
               for(var6 = 0; var6 < var3.size(); ++var6) {
                  ProduitsFrais var7 = new ProduitsFrais();
                  FraisTheoAchats var5 = (FraisTheoAchats)var3.get(var6);
                  var7.setProfrsNum(var4);
                  var7.setProfrsDate(this.var_date_simulation);
                  var7.setProfrsDevise(this.var_devise);
                  var7.setProfrsCoefDevise(this.var_coef_devise);
                  var7.setProfrsPA(this.var_pa);
                  var7.setProfrsFret(this.var_fret);
                  var7.setProfrsAssurance(this.var_assurance);
                  var7.setProfrsCaf(this.var_montant_initial);
                  var7.setProfrsFeuille(this.var_modele_simulation);
                  var7.setProfrsCategorie(this.var_cateorie);
                  var7.setProfrsMode(this.var_mode);
                  var7.setProfrsNature(this.var_nature);
                  var7.setProfrsIdTransporteur(this.var_id_transporteur);
                  var7.setProfrsNomTransporteur(this.var_nom_transorteur);
                  var7.setProfrsIdTransitaire(this.var_id_transitaire);
                  var7.setProfrsNomTransitaire(this.var_nom_transitaire);
                  var7.setProfrsType(var5.getFstType());
                  var7.setProfrsColType(var5.getFstColType());
                  var7.setProfrsOrdre(var6);
                  var7.setProfrsCode(var5.getFstCode());
                  var7.setProfrsLibelle(var5.getFstNomFr());
                  var7.setProfrsExoDouane(this.var_exo_douane);
                  var7.setProfrsExoTva(this.var_exo_tva);
                  var7.setProfrsCoefPrp(this.var_coef_prp);
                  if (this.nature == 11) {
                     var7.setProfrsCot(this.cotationEnteteAchats.getCotNum());
                     var7.setProfrsIdCot(this.cotationEnteteAchats.getCotId());
                     var7.setProfrsAffaire(this.cotationEnteteAchats.getCotAnal4());
                     var7.setProfrsCmd("");
                     var7.setProfrsIdCmd(0L);
                     var7.setProfrsProduit("");
                     var7.setProfrsIdPro(0L);
                  } else if (this.nature == 12) {
                     var7.setProfrsCot("");
                     var7.setProfrsIdCot(0L);
                     var7.setProfrsCmd(this.commandeEnteteAchats.getCmdNum());
                     var7.setProfrsIdCmd(this.commandeEnteteAchats.getCmdId());
                     var7.setProfrsAffaire(this.commandeEnteteAchats.getCmdAnal4());
                     var7.setProfrsProduit("");
                     var7.setProfrsIdPro(0L);
                  } else if (this.nature == 500) {
                     var7.setProfrsCot("");
                     var7.setProfrsIdCot(0L);
                     var7.setProfrsAffaire("");
                     var7.setProfrsCmd("");
                     var7.setProfrsIdCmd(0L);
                     var7.setProfrsProduit(this.produits.getProCode());
                     var7.setProfrsIdPro(this.produits.getProId());
                  }

                  var7.setProfrsTranche(var5.getFstTranche());
                  var7.setProfrsFormuleA(var5.getFstFormuleA());
                  var7.setProfrsFormuleB(var5.getFstFormuleB());
                  var7.setProfrsFormuleC(var5.getFstFormuleC());
                  var7.setProfrsFormuleD(var5.getFstFormuleD());
                  var7.setProfrsFormuleE(var5.getFstFormuleE());
                  var7.setProfrsFormuleF(var5.getFstFormuleF());
                  var7.setProfrsValA(0.0D);
                  var7.setProfrsValB(0.0D);
                  var7.setProfrsValC(0.0D);
                  var7.setProfrsValD(0.0D);
                  var7.setProfrsValE(0.0D);
                  var7.setProfrsValF(0.0D);
                  var7.setProfrsDecimalA(var5.getFstDecimalA());
                  var7.setProfrsDecimalB(var5.getFstDecimalB());
                  var7.setProfrsDecimalC(var5.getFstDecimalC());
                  var7.setProfrsDecimalD(var5.getFstDecimalD());
                  var7.setProfrsDecimalE(var5.getFstDecimalE());
                  var7.setProfrsDecimalF(var5.getFstDecimalF());
                  var7.setProfrsTranche(var5.getFstTranche());
                  var7.setProfrsTrancheA(var5.getFstTrancheA());
                  var7.setProfrsTrancheB(var5.getFstTrancheB());
                  var7.setProfrsTrancheC(var5.getFstTrancheC());
                  var7.setProfrsTrancheD(var5.getFstTrancheD());
                  var7.setProfrsTrancheE(var5.getFstTrancheE());
                  var7.setProfrsTrancheF(var5.getFstTrancheF());
                  if (this.lesVariablesSaisir.size() != 0) {
                     for(int var8 = 0; var8 < this.lesVariablesSaisir.size(); ++var8) {
                        if (var7.getProfrsCode() != null && !var7.getProfrsCode().isEmpty() && var7.getProfrsCode().equals(((ObjetTable)this.lesVariablesSaisir.get(var8)).getColumn_code()) && ((ObjetTable)this.lesVariablesSaisir.get(var8)).getColumn_type() != null && !((ObjetTable)this.lesVariablesSaisir.get(var8)).getColumn_type().isEmpty()) {
                           if (((ObjetTable)this.lesVariablesSaisir.get(var8)).getColumn_type().equals("A")) {
                              var7.setProfrsValA(((ObjetTable)this.lesVariablesSaisir.get(var8)).getColumn_pr());
                           } else if (((ObjetTable)this.lesVariablesSaisir.get(var8)).getColumn_type().equals("B")) {
                              var7.setProfrsValB(((ObjetTable)this.lesVariablesSaisir.get(var8)).getColumn_pr());
                           } else if (((ObjetTable)this.lesVariablesSaisir.get(var8)).getColumn_type().equals("C")) {
                              var7.setProfrsValC(((ObjetTable)this.lesVariablesSaisir.get(var8)).getColumn_pr());
                           } else if (((ObjetTable)this.lesVariablesSaisir.get(var8)).getColumn_type().equals("D")) {
                              var7.setProfrsValD(((ObjetTable)this.lesVariablesSaisir.get(var8)).getColumn_pr());
                           } else if (((ObjetTable)this.lesVariablesSaisir.get(var8)).getColumn_type().equals("E")) {
                              var7.setProfrsValE(((ObjetTable)this.lesVariablesSaisir.get(var8)).getColumn_pr());
                           }
                           break;
                        }
                     }
                  }

                  this.listeDetailFrais.add(var7);
               }

               this.dataModelDetailFrais.setWrappedData(this.listeDetailFrais);
               this.calculeSimulation();
               if (this.listeDetailFrais.size() != 0 && this.var_montant_initial != 0.0D && this.var_enregistre) {
                  for(var6 = 0; var6 < this.listeDetailFrais.size(); ++var6) {
                     this.produitsFrais = (ProduitsFrais)this.listeDetailFrais.get(var6);
                     this.produitsFrais = this.produitsFraisDao.insert(this.produitsFrais, var1);
                  }
               }

               if (this.nature == 11) {
                  this.cotationEnteteAchats = this.cotationEnteteAchatsDao.pourParapheur(this.cotationEnteteAchats.getCotId(), var1);
                  if (this.cotationEnteteAchats != null) {
                     this.cotationEnteteAchats.setCotModelePr(this.var_modele_simulation);
                     this.cotationEnteteAchats = this.cotationEnteteAchatsDao.modif(this.cotationEnteteAchats, var1);
                  }
               } else if (this.nature == 12) {
                  this.commandeEnteteAchats = this.commandeEnteteAchatsDao.pourParapheur(this.commandeEnteteAchats.getCmdId(), var1);
                  if (this.commandeEnteteAchats != null) {
                     this.commandeEnteteAchats.setCmdModelePr(this.var_modele_simulation);
                     this.commandeEnteteAchats = this.commandeEnteteAchatsDao.modif(this.commandeEnteteAchats, var1);
                  }
               } else if (this.nature == 500) {
                  this.produits = this.produitsAchsDao.chargeProduit(this.produits.getProId(), var1);
                  if (this.produits != null) {
                     this.produits.setProModelePr(this.var_modele_simulation);
                     this.produits = this.produitsAchsDao.modif(this.produits, var1);
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var12) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.showModalPanelSimulation = false;
   }

   public void selectionLigneVariable() {
      if (this.dataModelVariables.isRowAvailable()) {
         this.objetTable = (ObjetTable)this.dataModelVariables.getRowData();
      }

   }

   public void calculeSimulation() throws HibernateException, NamingException {
      int var1;
      if (this.nature == 11) {
         if (this.cotationEnteteAchats.getCotCoefDevise() == 0.0F) {
            for(var1 = 0; var1 < this.lesDevises.size(); ++var1) {
               if (((Devise)this.lesDevises.get(var1)).getDevCode().equals(this.cotationEnteteAchats.getCotDevise())) {
                  this.cotationEnteteAchats.setCotCoefDevise(((Devise)this.lesDevises.get(var1)).getDevTaux1());
                  break;
               }
            }
         }

         if (this.cotationEnteteAchats.getCotCoefDevise() == 0.0F) {
            this.cotationEnteteAchats.setCotCoefDevise(1.0F);
         }
      } else if (this.nature == 12) {
         if (this.commandeEnteteAchats.getCmdCoefDevise() == 0.0F) {
            for(var1 = 0; var1 < this.lesDevises.size(); ++var1) {
               if (((Devise)this.lesDevises.get(var1)).getDevCode().equals(this.commandeEnteteAchats.getCmdDevise())) {
                  this.commandeEnteteAchats.setCmdCoefDevise(((Devise)this.lesDevises.get(var1)).getDevTaux1());
                  break;
               }
            }
         }

         if (this.commandeEnteteAchats.getCmdCoefDevise() == 0.0F) {
            this.commandeEnteteAchats.setCmdCoefDevise(1.0F);
         }
      } else if (this.nature == 500) {
      }

      if (this.listeDetailFrais.size() != 0) {
         for(var1 = 0; var1 < this.listeDetailFrais.size(); ++var1) {
            this.produitsFrais = (ProduitsFrais)this.listeDetailFrais.get(var1);
            if (this.produitsFrais.getProfrsFormuleA() != null && !this.produitsFrais.getProfrsFormuleA().isEmpty()) {
               this.produitsFrais.setProfrsValA(this.analyseSimultation(this.produitsFrais.getProfrsCode(), "A", this.produitsFrais.getProfrsFormuleA()));
            }

            if (this.produitsFrais.getProfrsFormuleB() != null && !this.produitsFrais.getProfrsFormuleB().isEmpty()) {
               this.produitsFrais.setProfrsValB(this.analyseSimultation(this.produitsFrais.getProfrsCode(), "B", this.produitsFrais.getProfrsFormuleB()));
            }

            if (this.produitsFrais.getProfrsFormuleC() != null && !this.produitsFrais.getProfrsFormuleC().isEmpty()) {
               this.produitsFrais.setProfrsValC(this.analyseSimultation(this.produitsFrais.getProfrsCode(), "C", this.produitsFrais.getProfrsFormuleC()));
            }

            if (this.produitsFrais.getProfrsFormuleD() != null && !this.produitsFrais.getProfrsFormuleD().isEmpty()) {
               this.produitsFrais.setProfrsValD(this.analyseSimultation(this.produitsFrais.getProfrsCode(), "D", this.produitsFrais.getProfrsFormuleD()));
            }

            if (this.produitsFrais.getProfrsFormuleE() != null && !this.produitsFrais.getProfrsFormuleE().isEmpty()) {
               this.produitsFrais.setProfrsValD(this.analyseSimultation(this.produitsFrais.getProfrsCode(), "E", this.produitsFrais.getProfrsFormuleE()));
            }

            if (this.produitsFrais.getProfrsFormuleF() != null && !this.produitsFrais.getProfrsFormuleF().isEmpty()) {
               this.produitsFrais.setProfrsValD(this.analyseSimultation(this.produitsFrais.getProfrsCode(), "F", this.produitsFrais.getProfrsFormuleF()));
            }

            if (this.produitsFrais.getProfrsRubrique() != null && !this.produitsFrais.getProfrsRubrique().isEmpty()) {
               if (this.produitsFrais.getProfrsRubrique().equalsIgnoreCase("profrsPA")) {
                  this.produitsFrais.setProfrsPA(this.produitsFrais.getProfrsValELocal());
               } else if (this.produitsFrais.getProfrsRubrique().equalsIgnoreCase("profrsFret")) {
                  this.produitsFrais.setProfrsFret(this.produitsFrais.getProfrsValELocal());
                  this.cotationEnteteAchats.setCotTotFret(this.produitsFrais.getProfrsValELocal());
               } else if (this.produitsFrais.getProfrsRubrique().equalsIgnoreCase("profrsAssurance")) {
                  this.produitsFrais.setProfrsAssurance(this.produitsFrais.getProfrsValELocal());
                  this.cotationEnteteAchats.setCotTotAssurance(this.produitsFrais.getProfrsValELocal());
               } else if (this.produitsFrais.getProfrsRubrique().equalsIgnoreCase("profrsFob")) {
                  this.produitsFrais.setProfrsFob(this.produitsFrais.getProfrsValELocal());
                  this.cotationEnteteAchats.setCotTotFob(this.produitsFrais.getProfrsValELocal());
               }
            }

            if (this.produitsFrais.getProfrsReponse() == 1) {
               this.produitsFrais.setProfrsValD(0.0D);
            }

            if (this.produitsFrais.getProfrsValD() == 0.0D) {
               if (this.produitsFrais.getProfrsReponse() != 2) {
                  this.produitsFrais.setProfrsValELocal(0.0D);
               }
            } else {
               if (this.produitsFrais.getProfrsDevise() == null || this.produitsFrais.getProfrsDevise().isEmpty()) {
                  this.produitsFrais.setProfrsDevise(this.cotationEnteteAchats.getCotDevise());
               }

               if (this.produitsFrais.getProfrsDevise().equals(this.structureLog.getStrdevise())) {
                  this.produitsFrais.setProfrsValELocal(this.produitsFrais.getProfrsValD());
               } else {
                  this.produitsFrais.setProfrsCoefDevise(this.calculTauxDevise(this.produitsFrais.getProfrsDevise()));
                  if (this.produitsFrais.getProfrsCoefDevise() == 0.0F) {
                     this.produitsFrais.setProfrsCoefDevise(1.0F);
                  }

                  this.produitsFrais.setProfrsValELocal(this.produitsFrais.getProfrsValD() * (double)this.produitsFrais.getProfrsCoefDevise());
               }
            }
         }
      }

   }

   public double analyseSimultation(String var1, String var2, String var3) throws HibernateException, NamingException {
      var3 = this.filtreCaracteres(var3);
      double var4 = 0.0D;
      if (this.cotationEnteteAchats != null && var3.equals("COT(DEVISE_TAUX)")) {
         var4 = (double)this.cotationEnteteAchats.getCotCoefDevise();
      } else if (this.cotationEnteteAchats != null && var3.equals("COT(PRP_DEVISE_TAUX)")) {
         var4 = (double)this.var_coef_devise;
      } else if (this.cotationEnteteAchats != null && var3.equals("COT(POIDS)")) {
         var4 = (double)this.cotationEnteteAchats.getCotTotPoidsBrut();
      } else if (this.cotationEnteteAchats != null && var3.equals("COT(QUANTITE)")) {
         var4 = (double)this.cotationEnteteAchats.getCotTotQte();
      } else if (this.commandeEnteteAchats != null && var3.equals("CMD(TOTAL_DEVISE)")) {
         var4 = this.commandeEnteteAchats.getCmdTotTtc();
      } else if (this.commandeEnteteAchats != null && var3.equals("CMD(DEVISE_TAUX)")) {
         var4 = (double)this.commandeEnteteAchats.getCmdCoefDevise();
      } else if (this.cotationEnteteAchats != null && var3.equals("CMD(PRP_DEVISE_TAUX)")) {
         var4 = (double)this.var_coef_devise;
      } else if (this.commandeEnteteAchats != null && var3.equals("CMD(POIDS)")) {
         var4 = (double)this.commandeEnteteAchats.getCmdTotPoidsBrut();
      } else if (this.commandeEnteteAchats != null && var3.equals("CMD(QUANTITE)")) {
         var4 = (double)this.commandeEnteteAchats.getCmdTotQte();
      } else if (this.commandeEnteteAchats != null && var3.equals("CMD(TOTAL_LOCAL)")) {
         var4 = this.var_pa_local;
      } else if (this.commandeEnteteAchats != null && var3.equals("CMD(FRET_LOCAL)")) {
         var4 = this.var_fret_local;
      } else if (this.commandeEnteteAchats != null && var3.equals("CMD(ASSURANCE_LOCAL)")) {
         var4 = this.var_assurance_local;
      } else if (this.commandeEnteteAchats != null && var3.equals("CMD(CAF_LOCAL)")) {
         var4 = this.var_montant_initial;
      } else if (this.commandeEnteteAchats != null && var3.equals("CMD(CAF_LOCAL)")) {
         var4 = this.var_montant_initial;
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(HT)")) {
         var4 = this.cotationEnteteAchats.getCotTotHt();
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(DEVISE_TAUX)")) {
         var4 = (double)this.cotationEnteteAchats.getCotCoefDevise();
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(QUANTITE)")) {
         var4 = (double)this.cotationEnteteAchats.getCotTotQte();
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(POIDS_KG)")) {
         var4 = (double)(this.cotationEnteteAchats.getCotTotPoidsBrut() * 1000.0F);
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(POIDS_T)")) {
         var4 = (double)this.cotationEnteteAchats.getCotTotPoidsBrut();
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(VOLUME)")) {
         var4 = (double)this.cotationEnteteAchats.getCotTotVolume();
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(UNITE_PAYANTE)")) {
         var4 = this.calculeUnitePayante();
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(SORTIE_USINE)")) {
         var4 = this.calculeSortieUsine();
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(CONTENER)")) {
         var4 = (double)((float)this.cotationEnteteAchats.getCotContener());
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(NB_CONTENER)")) {
         var4 = (double)((float)this.cotationEnteteAchats.getCotNbContener());
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(NB_BL)")) {
         var4 = (double)((float)this.cotationEnteteAchats.getCotNbBl());
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(NB_DECLARATION)")) {
         var4 = (double)((float)this.cotationEnteteAchats.getCotNbDeclaration());
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(NB_DOSSIER)")) {
         var4 = (double)((float)this.cotationEnteteAchats.getCotNbDossier());
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(NB_EXPEDITION)")) {
         var4 = (double)((float)this.cotationEnteteAchats.getCotNbExpedition());
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(FOB)")) {
         var4 = (double)((float)this.cotationEnteteAchats.getCotTotFob());
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(FRET)")) {
         var4 = (double)((float)this.cotationEnteteAchats.getCotTotFret());
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(ASSURANCE)")) {
         var4 = this.cotationEnteteAchats.getCotTotAssurance();
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(ZONE)")) {
         var4 = (double)this.cotationEnteteAchats.getCotZone();
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(CAF)")) {
         var4 = this.calculeCaf();
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(FRS1)")) {
         var4 = this.calculeFrs1();
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(FRS2)")) {
         var4 = this.calculeFrs2();
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(FRS3)")) {
         var4 = this.calculeFrs3();
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(T1-DDI)")) {
         var4 = this.calculeDouanes("T1");
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(T3-TCI)")) {
         var4 = this.calculeDouanes("T3");
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(T10-CCI)")) {
         var4 = this.calculeDouanes("T10");
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(T30-OAD)")) {
         var4 = this.calculeDouanes("T30");
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(T5-TVA)")) {
         var4 = this.calculeDouanes("T5");
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(T31-CSS)")) {
         var4 = this.calculeDouanes("T31");
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(DOUANES)")) {
         var4 = this.calculeDouanes("XX");
      } else if (this.cotationEnteteAchats != null && var3.equals("DOC(FRET_DHL)")) {
         var4 = this.calculeFretDHL(this.produitsFrais.getProfrsValA());
      } else if (this.cotationEnteteAchats != null && var3.equals("TOT(DEBOURS)")) {
         var4 = this.calculTotDebours(var2);
      } else if (this.cotationEnteteAchats != null && var3.equals("TOT(DOUANES)")) {
         var4 = this.calculTotDouanes(var2);
      } else if (this.cotationEnteteAchats != null && var3.equals("TOT(PRESTATIONS)")) {
         var4 = this.calculTotPrestations(var2);
      } else if (this.cotationEnteteAchats != null && var3.equals("TOT(AUTRES_FRAIS)")) {
         var4 = this.calculTotAutresFrais(var2);
      } else {
         if (var3.startsWith("SI(")) {
            var4 = this.analyseSi(var1, var2, var3);
         } else if (var3.startsWith("TRANCHE(")) {
            var4 = this.analyseTranche(var1, var2, var3);
         } else if (var3.contains("TOT(") || var3.contains("VAL(") || var3.contains("RUB(") || var3.contains("VAR(") || var3.contains("+") || var3.contains("-") || var3.contains("*") || var3.contains("/")) {
            var4 = this.analyseOperateur(var1, var2, var3);
         }

         if (this.produitsFrais.getProfrsFormuleE() != null && !this.produitsFrais.getProfrsFormuleE().isEmpty() && var2.equals("E")) {
            if (var4 > this.produitsFrais.getProfrsValD()) {
               var2 = "D";
            } else {
               var2 = "D";
               var4 = this.produitsFrais.getProfrsValD();
            }
         }

         if (this.produitsFrais.getProfrsFormuleF() != null && !this.produitsFrais.getProfrsFormuleF().isEmpty() && var2.equals("F")) {
            if (var4 < this.produitsFrais.getProfrsValD()) {
               var2 = "D";
            } else {
               var2 = "D";
               var4 = this.produitsFrais.getProfrsValD();
            }
         }
      }

      var4 = this.mefDevise(var4, var2);
      return var4;
   }

   public double analyseRUB(String var1, String var2) {
      double var3 = 0.0D;
      if (this.listeDetailFrais.size() != 0) {
         for(int var5 = 0; var5 < this.listeDetailFrais.size(); ++var5) {
            if (((ProduitsFrais)this.listeDetailFrais.get(var5)).getProfrsCode().equals(var1) && var2.equals("A")) {
               var3 = ((ProduitsFrais)this.listeDetailFrais.get(var5)).getProfrsValA();
               break;
            }

            if (((ProduitsFrais)this.listeDetailFrais.get(var5)).getProfrsCode().equals(var1) && var2.equals("B")) {
               var3 = ((ProduitsFrais)this.listeDetailFrais.get(var5)).getProfrsValB();
               break;
            }

            if (((ProduitsFrais)this.listeDetailFrais.get(var5)).getProfrsCode().equals(var1) && var2.equals("C")) {
               var3 = ((ProduitsFrais)this.listeDetailFrais.get(var5)).getProfrsValC();
               break;
            }

            if (((ProduitsFrais)this.listeDetailFrais.get(var5)).getProfrsCode().equals(var1) && var2.equals("D")) {
               var3 = ((ProduitsFrais)this.listeDetailFrais.get(var5)).getProfrsValD();
               break;
            }

            if (((ProduitsFrais)this.listeDetailFrais.get(var5)).getProfrsCode().equals(var1) && var2.equals("E")) {
               var3 = ((ProduitsFrais)this.listeDetailFrais.get(var5)).getProfrsValE();
               break;
            }

            if (((ProduitsFrais)this.listeDetailFrais.get(var5)).getProfrsCode().equals(var1) && var2.equals("F")) {
               var3 = ((ProduitsFrais)this.listeDetailFrais.get(var5)).getProfrsValF();
               break;
            }
         }
      }

      return var3;
   }

   public double analyseRUB(String var1) {
      double var2 = 0.0D;
      if (this.produitsFrais != null) {
         if (var1.equals("A")) {
            var2 = this.produitsFrais.getProfrsValA();
         } else if (var1.equals("B")) {
            var2 = this.produitsFrais.getProfrsValB();
         } else if (var1.equals("C")) {
            var2 = this.produitsFrais.getProfrsValC();
         } else if (var1.equals("D")) {
            var2 = this.produitsFrais.getProfrsValD();
         } else if (var1.equals("E")) {
            var2 = this.produitsFrais.getProfrsValE();
         } else if (var1.equals("F")) {
            var2 = this.produitsFrais.getProfrsValF();
         }
      }

      return var2;
   }

   public double analyseTOT(String var1, String var2, String var3) {
      double var4 = 0.0D;
      if (this.listeDetailFrais.size() != 0) {
         boolean var6 = false;

         for(int var7 = 0; var7 < this.listeDetailFrais.size(); ++var7) {
            if (((ProduitsFrais)this.listeDetailFrais.get(var7)).getProfrsCode().equals(var2)) {
               var6 = true;
            }

            if (var6) {
               if (var1.equals("A")) {
                  var4 += ((ProduitsFrais)this.listeDetailFrais.get(var7)).getProfrsValA();
               } else if (var1.equals("B")) {
                  var4 += ((ProduitsFrais)this.listeDetailFrais.get(var7)).getProfrsValB();
               } else if (var1.equals("C")) {
                  var4 += ((ProduitsFrais)this.listeDetailFrais.get(var7)).getProfrsValC();
               } else if (var1.equals("D")) {
                  var4 += ((ProduitsFrais)this.listeDetailFrais.get(var7)).getProfrsValD();
               } else if (var1.equals("E")) {
                  var4 += ((ProduitsFrais)this.listeDetailFrais.get(var7)).getProfrsValD();
               } else if (var1.equals("F")) {
                  var4 += ((ProduitsFrais)this.listeDetailFrais.get(var7)).getProfrsValD();
               }
            }

            if (((ProduitsFrais)this.listeDetailFrais.get(var7)).getProfrsCode().equals(var3)) {
               var6 = false;
            }
         }
      }

      return var4;
   }

   public double analyseVar(String var1, String var2) {
      double var3 = 0.0D;
      if (this.lesVariablesSaisir.size() != 0) {
         for(int var5 = 0; var5 < this.lesVariablesSaisir.size(); ++var5) {
            this.objetTable = (ObjetTable)this.lesVariablesSaisir.get(var5);
            if (this.objetTable.getColumn_code().equals(var1) && this.objetTable.getColumn_type().equals(var2) && var2.equals("A")) {
               var3 = this.objetTable.getColumn_pr();
               break;
            }

            if (this.objetTable.getColumn_code().equals(var1) && this.objetTable.getColumn_type().equals(var2) && var2.equals("B")) {
               var3 = this.objetTable.getColumn_pr();
               break;
            }

            if (this.objetTable.getColumn_code().equals(var1) && this.objetTable.getColumn_type().equals(var2) && var2.equals("C")) {
               var3 = this.objetTable.getColumn_pr();
               break;
            }

            if (this.objetTable.getColumn_code().equals(var1) && this.objetTable.getColumn_type().equals(var2) && var2.equals("D")) {
               var3 = this.objetTable.getColumn_pr();
               break;
            }

            if (this.objetTable.getColumn_code().equals(var1) && this.objetTable.getColumn_type().equals(var2) && var2.equals("E")) {
               var3 = this.objetTable.getColumn_pr();
               break;
            }

            if (this.objetTable.getColumn_code().equals(var1) && this.objetTable.getColumn_type().equals(var2) && var2.equals("F")) {
               var3 = this.objetTable.getColumn_pr();
               break;
            }
         }
      }

      return var3;
   }

   public double analyseTranche(String var1, String var2, String var3) {
      double var4 = 0.0D;
      double var6 = 0.0D;
      if (var3.equals("TRANCHE(A)")) {
         var6 = this.produitsFrais.getProfrsValA();
      } else if (var3.equals("TRANCHE(B)")) {
         var6 = this.produitsFrais.getProfrsValB();
      } else if (var3.equals("TRANCHE(C)")) {
         var6 = this.produitsFrais.getProfrsValC();
      } else if (var3.equals("TRANCHE(D)")) {
         var6 = this.produitsFrais.getProfrsValD();
      } else if (var3.equals("TRANCHE(E)")) {
         var6 = this.produitsFrais.getProfrsValE();
      } else if (var3.equals("TRANCHE(F)")) {
         var6 = this.produitsFrais.getProfrsValF();
      }

      String var8 = "";
      if (var2.equals("A")) {
         var8 = this.produitsFrais.getProfrsTrancheA();
      } else if (var2.equals("B")) {
         var8 = this.produitsFrais.getProfrsTrancheB();
      } else if (var2.equals("C")) {
         var8 = this.produitsFrais.getProfrsTrancheC();
      } else if (var2.equals("D")) {
         var8 = this.produitsFrais.getProfrsTrancheD();
      } else if (var2.equals("E")) {
         var8 = this.produitsFrais.getProfrsTrancheE();
      } else if (var2.equals("F")) {
         var8 = this.produitsFrais.getProfrsTrancheF();
      }

      if (var8 != null && !var8.isEmpty()) {
         ArrayList var9 = new ArrayList();
         new ObjetTarif();
         ObjetTarif var10;
         String[] var11;
         if (!var8.contains("#")) {
            var10 = new ObjetTarif();
            var11 = var8.split(":");
            var10.setQteDebut(Float.parseFloat(var11[0]));
            var10.setQteFin(Float.parseFloat(var11[1]));
            var10.setPrix(Double.parseDouble(var11[2]));
            var9.add(var10);
         } else {
            var11 = var8.split("#");
            int var12 = var11.length;

            for(int var13 = 0; var13 < var12; ++var13) {
               String[] var14 = var11[var13].split(":");
               var10 = new ObjetTarif();
               var10.setQteDebut(Float.parseFloat(var14[0]));
               var10.setQteFin(Float.parseFloat(var14[1]));
               var10.setPrix(Double.parseDouble(var14[2]));
               var9.add(var10);
            }
         }

         if (var9.size() != 0) {
            for(int var15 = 0; var15 < var9.size(); ++var15) {
               var10 = (ObjetTarif)var9.get(var15);
               if (var6 >= (double)var10.getQteDebut() && var6 <= (double)var10.getQteFin()) {
                  var4 = var10.getPrix();
                  break;
               }
            }
         }
      } else if (var2.equals("A")) {
         var4 = this.produitsFrais.getProfrsValA();
      } else if (var2.equals("B")) {
         var4 = this.produitsFrais.getProfrsValB();
      } else if (var2.equals("C")) {
         var4 = this.produitsFrais.getProfrsValC();
      } else if (var2.equals("D")) {
         var4 = this.produitsFrais.getProfrsValD();
      } else if (var2.equals("E")) {
         var4 = this.produitsFrais.getProfrsValE();
      } else if (var2.equals("F")) {
         var4 = this.produitsFrais.getProfrsValF();
      }

      return var4;
   }

   public double analyseOperateur(String var1, String var2, String var3) {
      double var4 = 0.0D;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      var3 = var3 + "#";
      String var9 = "+";

      for(int var10 = 0; var10 < var3.length(); ++var10) {
         String var11 = var3.substring(var7, var7 + 1);
         if (var8 != 0 && var11 != null && !var11.isEmpty() && (var11.equals("+") || var11.equals("-") || var11.equals("*") || var11.equals("/")) && !var11.equals("#")) {
            String var12 = var11;
            var11 = var9;
            var9 = var12;
         } else if (var8 == 0 && var11 != null && !var11.isEmpty() && (var11.equals("+") || var11.equals("-") || var11.equals("*") || var11.equals("/")) && !var11.equals("#")) {
            var9 = var11;
         }

         double var14;
         if (var11 != null && !var11.isEmpty() && var11.equals("+") || var11 != null && !var11.isEmpty() && var11.equals("#") && var9.equals("+") && var3.length() - 1 >= var10) {
            var7 = var10;
            var14 = this.calculeCas(var1, var2, var3, var6, var10);
            if (var8 == 0) {
               var4 = var14;
            } else {
               var4 += var14;
            }

            ++var8;
            var6 = var10 + 1;
         } else if ((var11 == null || var11.isEmpty() || !var11.equals("-")) && (var11 == null || var11.isEmpty() || !var11.equals("#") || !var9.equals("-") || var3.length() - 1 < var10)) {
            if (var11 != null && !var11.isEmpty() && var11.equals("*") || var11 != null && !var11.isEmpty() && var11.equals("#") && var9.equals("*") && var3.length() - 1 >= var10) {
               var7 = var10;
               var14 = this.calculeCas(var1, var2, var3, var6, var10);
               if (var8 == 0) {
                  var4 = var14;
               } else {
                  var4 *= var14;
               }

               ++var8;
               var6 = var10 + 1;
            } else if (var11 != null && !var11.isEmpty() && var11.equals("/") || var11 != null && !var11.isEmpty() && var11.equals("#") && var9.equals("/") && var3.length() - 1 >= var10) {
               var7 = var10;
               var14 = this.calculeCas(var1, var2, var3, var6, var10);
               if (var8 == 0) {
                  var4 = var14;
               } else if (var14 != 0.0D && var4 != 0.0D) {
                  var4 /= var14;
               } else {
                  var4 = 0.0D;
               }

               ++var8;
               var6 = var10 + 1;
            }
         } else {
            var7 = var10;
            var14 = this.calculeCas(var1, var2, var3, var6, var10);
            if (var8 == 0) {
               var4 = var14;
            } else {
               var4 -= var14;
            }

            ++var8;
            var6 = var10 + 1;
         }

         ++var7;
      }

      return var4;
   }

   public double calculeCas(String var1, String var2, String var3, int var4, int var5) {
      double var6 = 0.0D;
      String var8 = var3.substring(var4, var5);
      if (var8.contains("VAR(")) {
         if (var2.equals("A")) {
            var6 = this.produitsFrais.getProfrsValA();
         } else if (var2.equals("B")) {
            var6 = this.produitsFrais.getProfrsValB();
         } else if (var2.equals("C")) {
            var6 = this.produitsFrais.getProfrsValC();
         } else if (var2.equals("D")) {
            var6 = this.produitsFrais.getProfrsValD();
         } else if (var2.equals("E")) {
            var6 = this.produitsFrais.getProfrsValE();
         } else if (var2.equals("F")) {
            var6 = this.produitsFrais.getProfrsValF();
         }
      } else {
         String var9;
         if (var8.contains("VAL(")) {
            var9 = var8.substring(4, var8.length() - 1);
            if (var9 == null || var9.isEmpty()) {
               var9 = "0";
            }

            var6 = Double.parseDouble(var9);
         } else {
            String[] var10;
            if (var8.contains("RUB(")) {
               var9 = var8.substring(4, var8.length() - 1);
               if (var9 != null && !var9.isEmpty() && var9.contains(":")) {
                  var10 = var9.split(":");
                  var6 = this.analyseRUB(var10[0], var10[1]);
               } else if (var9 != null && !var9.isEmpty() && !var9.contains(":")) {
                  var6 = this.analyseRUB(var9);
               } else {
                  var6 = 0.0D;
               }
            } else if (var3.contains("TOT(")) {
               var9 = var8.substring(4, var8.length() - 1);
               if (var9 != null && !var9.isEmpty() && var9.contains(":")) {
                  var10 = var9.split(":");
                  var6 = this.analyseTOT(var10[0], var10[1], var10[2]);
               } else {
                  var6 = 0.0D;
               }
            }
         }
      }

      return var6;
   }

   public double calculeDouanes(String var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.lesLignesListCotations.size() != 0) {
         if (this.cotationEnteteAchats.getCotCoefDevise() == 0.0F) {
            this.cotationEnteteAchats.setCotCoefDevise(1.0F);
         }

         double var4 = this.calculeCaf();
         new DouanesPosition();
         DouanesPositionDao var7 = new DouanesPositionDao(this.baseLog, this.utilInitHibernate);
         new CotationLigneAchats();

         for(int var9 = 0; var9 < this.lesLignesListCotations.size(); ++var9) {
            CotationLigneAchats var8 = (CotationLigneAchats)this.lesLignesListCotations.get(var9);
            if (var8.getCotligPosTarifaire() != null && !var8.getCotligPosTarifaire().isEmpty()) {
               DouanesPosition var6 = var7.trouverPosition(this.structureLog.getStrzonecommerciale(), var8.getCotligPosTarifaire(), (Session)null);
               if (var6 != null) {
                  if (this.cotationEnteteAchats.getCotExoDouane() == 0) {
                     if (var6.getDouposDd() != 0.0F && (var1.equals("T1") || var1.equals("XX"))) {
                        var2 += var4 * (double)var6.getDouposDd() / 100.0D;
                     }

                     if (var6.getDouposRs() != 0.0F && (var1.equals("T3") || var1.equals("XX"))) {
                        var2 += var4 * (double)var6.getDouposRs() / 100.0D;
                     }

                     if (var6.getDouposPcs() != 0.0F && (var1.equals("T10") || var1.equals("XX"))) {
                        var2 += var4 * (double)var6.getDouposPcs() / 100.0D;
                     }

                     if (var6.getDouposAd() != 0.0F && (var1.equals("T30") || var1.equals("XX"))) {
                        var2 += var4 * (double)var6.getDouposAd() / 100.0D;
                     }

                     if (var6.getDouposTva() != 0.0F && (var1.equals("T5") || var1.equals("XX"))) {
                        var2 += var4 * (double)var6.getDouposTva() / 100.0D;
                     }

                     if (var6.getDouposDa() != 0.0F && (var1.equals("T31") || var1.equals("XX"))) {
                        var2 += var4 * (double)var6.getDouposDa() / 100.0D;
                     }
                  } else if (this.cotationEnteteAchats.getCotExoDouane() != 1 && this.cotationEnteteAchats.getCotExoDouane() == 2 && var6.getDouposDd() != 0.0F && (var1.equals("T1") || var1.equals("XX"))) {
                     var2 += var4 * (double)this.optionAchats.getTauxReduit() / 100.0D;
                  }

                  if (this.optionAchats.getTauxRusid() != 0.0F) {
                     var2 += var4 * (double)this.optionAchats.getTauxRusid() / 100.0D;
                  }
               }
            }
         }
      }

      return var2;
   }

   public double calculeFretDHL(double var1) {
      double var3 = 0.0D;
      String var5 = "tarifTransitDHL.xml";
      new ObjetTarifTransit();
      new ArrayList();
      LectureTarifTransit var8 = new LectureTarifTransit(this.baseLog, var5);
      List var7 = var8.getMesTarifsTransits();
      if (var7 != null && var7.size() != 0) {
         double var9 = 0.0D;
         double var11 = 0.0D;
         double var13 = 0.0D;

         ObjetTarifTransit var6;
         for(int var15 = 0; var15 < var7.size(); ++var15) {
            var6 = (ObjetTarifTransit)var7.get(var15);
            if (var6.getKg() == 999999.0D) {
               if (this.cotationEnteteAchats.getCotZone() == 1) {
                  var9 = var6.getZone1();
               } else if (this.cotationEnteteAchats.getCotZone() == 2) {
                  var9 = var6.getZone2();
               } else if (this.cotationEnteteAchats.getCotZone() == 3) {
                  var9 = var6.getZone3();
               } else if (this.cotationEnteteAchats.getCotZone() == 4) {
                  var9 = var6.getZone4();
               } else if (this.cotationEnteteAchats.getCotZone() == 5) {
                  var9 = var6.getZone5();
               } else if (this.cotationEnteteAchats.getCotZone() == 6) {
                  var9 = var6.getZone6();
               } else if (this.cotationEnteteAchats.getCotZone() == 7) {
                  var9 = var6.getZone7();
               } else if (this.cotationEnteteAchats.getCotZone() == 8) {
                  var9 = var6.getZone8();
               }
            } else {
               var11 = var6.getKg();
               if (this.cotationEnteteAchats.getCotZone() == 1) {
                  var13 = var6.getZone1();
               } else if (this.cotationEnteteAchats.getCotZone() == 2) {
                  var13 = var6.getZone2();
               } else if (this.cotationEnteteAchats.getCotZone() == 3) {
                  var13 = var6.getZone3();
               } else if (this.cotationEnteteAchats.getCotZone() == 4) {
                  var13 = var6.getZone4();
               } else if (this.cotationEnteteAchats.getCotZone() == 5) {
                  var13 = var6.getZone5();
               } else if (this.cotationEnteteAchats.getCotZone() == 6) {
                  var13 = var6.getZone6();
               } else if (this.cotationEnteteAchats.getCotZone() == 7) {
                  var13 = var6.getZone7();
               } else if (this.cotationEnteteAchats.getCotZone() == 8) {
                  var13 = var6.getZone8();
               }
            }
         }

         double var20 = 0.0D;

         for(int var17 = 0; var17 < var7.size(); ++var17) {
            var6 = (ObjetTarifTransit)var7.get(var17);
            if (this.cotationEnteteAchats.getCotZone() == 1) {
               var20 = var6.getZone1();
            } else if (this.cotationEnteteAchats.getCotZone() == 2) {
               var20 = var6.getZone2();
            } else if (this.cotationEnteteAchats.getCotZone() == 3) {
               var20 = var6.getZone3();
            } else if (this.cotationEnteteAchats.getCotZone() == 4) {
               var20 = var6.getZone4();
            } else if (this.cotationEnteteAchats.getCotZone() == 5) {
               var20 = var6.getZone5();
            } else if (this.cotationEnteteAchats.getCotZone() == 6) {
               var20 = var6.getZone6();
            } else if (this.cotationEnteteAchats.getCotZone() == 7) {
               var20 = var6.getZone7();
            } else if (this.cotationEnteteAchats.getCotZone() == 8) {
               var20 = var6.getZone8();
            }

            if (var1 >= var6.getKg() && var1 <= var6.getKg()) {
               if (this.cotationEnteteAchats.getCotZone() == 1) {
                  var3 = var6.getZone1();
               } else if (this.cotationEnteteAchats.getCotZone() == 2) {
                  var3 = var6.getZone2();
               } else if (this.cotationEnteteAchats.getCotZone() == 3) {
                  var3 = var6.getZone3();
               } else if (this.cotationEnteteAchats.getCotZone() == 4) {
                  var3 = var6.getZone4();
               } else if (this.cotationEnteteAchats.getCotZone() == 5) {
                  var3 = var6.getZone5();
               } else if (this.cotationEnteteAchats.getCotZone() == 6) {
                  var3 = var6.getZone6();
               } else if (this.cotationEnteteAchats.getCotZone() == 7) {
                  var3 = var6.getZone7();
               } else if (this.cotationEnteteAchats.getCotZone() == 8) {
                  var3 = var6.getZone8();
               }
               break;
            }

            if (var1 > var11 && var9 != 0.0D && var20 != 0.0D && var3 == 0.0D) {
               double var18 = (var1 - var11) / 2.0D;
               var3 = var9 * var18 + var13;
            }
         }
      }

      return var3;
   }

   public double calculeUnitePayante() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      boolean var5 = false;
      if (this.cotationEnteteAchats.getCotModeTransport() == 2) {
         var3 = (double)(this.cotationEnteteAchats.getCotTotVolume() / 5.0F);
         var5 = true;
      } else if (this.cotationEnteteAchats.getCotModeTransport() == 0) {
         var3 = (double)(this.cotationEnteteAchats.getCotTotVolume() / 6.0F);
         var5 = true;
      } else {
         var3 = (double)this.cotationEnteteAchats.getCotTotVolume();
         var5 = false;
      }

      if (var5) {
         if (var3 >= (double)this.cotationEnteteAchats.getCotTotPoidsBrut()) {
            var1 = var3 * 1000.0D;
            this.cotationEnteteAchats.setCotUnitePayante("kgr");
         } else {
            var1 = (double)(this.cotationEnteteAchats.getCotTotPoidsBrut() * 1000.0F);
            this.cotationEnteteAchats.setCotUnitePayante("kgr");
         }
      } else if (var3 >= (double)this.cotationEnteteAchats.getCotTotPoidsBrut()) {
         var1 = (double)this.cotationEnteteAchats.getCotTotVolume();
         this.cotationEnteteAchats.setCotUnitePayante("m3");
      } else {
         var1 = (double)this.cotationEnteteAchats.getCotTotPoidsBrut();
         this.cotationEnteteAchats.setCotUnitePayante("T");
      }

      int var6 = (int)var1;
      if (var6 <= 0) {
         var1 = 1.0D;
      } else {
         double var7;
         if (this.cotationEnteteAchats.getCotModeTransport() == 1) {
            var7 = var1 - (double)var6;
            if (var7 != 0.0D) {
               var1 = (double)(var6 + 1);
            } else {
               var1 = this.utilNombre.myRound(var1, 4);
            }
         } else if (this.cotationEnteteAchats.getCotModeTransport() == 2) {
            var7 = var1 - (double)var6;
            if (var7 > 0.0D && var7 < 5.0D) {
               var1 = (double)var6 + 0.5D;
            } else {
               var1 = (double)(var6 + 1);
            }
         } else {
            var6 = (int)this.utilNombre.myRound(var1, 4);
            if (var6 <= 0) {
               var1 = 1.0D;
            } else {
               var1 = this.utilNombre.myRound(var1, 4);
            }
         }
      }

      return var1;
   }

   public double calculeSortieUsine() {
      double var1 = this.cotationEnteteAchats.getCotTotHt() + this.cotationEnteteAchats.getCotTransportUsine() + this.cotationEnteteAchats.getCotTotComplement() + this.cotationEnteteAchats.getCotTotEmballage() + this.cotationEnteteAchats.getCotTotCertificat() + this.cotationEnteteAchats.getCotTotCertificatConf();
      return var1;
   }

   public double calculeCaf() {
      double var1 = 0.0D;
      var1 = (this.cotationEnteteAchats.getCotTotHt() + this.cotationEnteteAchats.getCotTransportUsine() + this.cotationEnteteAchats.getCotTotComplement() + this.cotationEnteteAchats.getCotTotEmballage() + this.cotationEnteteAchats.getCotTotCertificat() + this.cotationEnteteAchats.getCotTotCertificatConf()) * (double)this.cotationEnteteAchats.getCotCoefDevise();
      double var3 = 0.0D;

      for(int var5 = 0; var5 < this.listeDetailFraisTransporteur.size(); ++var5) {
         var3 += ((ProduitsFrais)this.listeDetailFraisTransporteur.get(var5)).getProfrsValELocal();
      }

      double var7 = var1 + var3;
      return var7;
   }

   public double calculTotDebours(String var1) {
      double var2 = 0.0D;
      int var4;
      if (this.typeListe == 1) {
         for(var4 = 0; var4 < this.listeDetailFraisTransporteur.size(); ++var4) {
            if (((ProduitsFrais)this.listeDetailFraisTransporteur.get(var4)).getProfrsCategorie() == 2) {
               var2 += ((ProduitsFrais)this.listeDetailFraisTransporteur.get(var4)).getProfrsValD();
            }
         }
      } else if (this.typeListe == 2) {
         for(var4 = 0; var4 < this.listeDetailFraisTranstaire.size(); ++var4) {
            if (((ProduitsFrais)this.listeDetailFraisTranstaire.get(var4)).getProfrsCategorie() == 2) {
               var2 += ((ProduitsFrais)this.listeDetailFraisTranstaire.get(var4)).getProfrsValELocal();
            }
         }
      }

      return var2;
   }

   public double calculTotDouanes(String var1) {
      double var2 = 0.0D;
      int var4;
      if (this.typeListe == 1) {
         for(var4 = 0; var4 < this.listeDetailFraisTransporteur.size(); ++var4) {
            if (((ProduitsFrais)this.listeDetailFraisTransporteur.get(var4)).getProfrsCategorie() == 1) {
               var2 += ((ProduitsFrais)this.listeDetailFraisTransporteur.get(var4)).getProfrsValD();
            }
         }
      } else if (this.typeListe == 2) {
         for(var4 = 0; var4 < this.listeDetailFraisTranstaire.size(); ++var4) {
            if (((ProduitsFrais)this.listeDetailFraisTranstaire.get(var4)).getProfrsCategorie() == 1) {
               var2 += ((ProduitsFrais)this.listeDetailFraisTranstaire.get(var4)).getProfrsValELocal();
            }
         }
      }

      return var2;
   }

   public double calculTotPrestations(String var1) {
      double var2 = 0.0D;
      int var4;
      if (this.typeListe == 1) {
         for(var4 = 0; var4 < this.listeDetailFraisTransporteur.size(); ++var4) {
            if (((ProduitsFrais)this.listeDetailFraisTransporteur.get(var4)).getProfrsCategorie() == 3) {
               var2 += ((ProduitsFrais)this.listeDetailFraisTransporteur.get(var4)).getProfrsValD();
            }
         }
      } else if (this.typeListe == 2) {
         for(var4 = 0; var4 < this.listeDetailFraisTranstaire.size(); ++var4) {
            if (((ProduitsFrais)this.listeDetailFraisTranstaire.get(var4)).getProfrsCategorie() == 3) {
               var2 += ((ProduitsFrais)this.listeDetailFraisTranstaire.get(var4)).getProfrsValELocal();
            }
         }
      }

      return var2;
   }

   public double calculTotAutresFrais(String var1) {
      double var2 = 0.0D;
      int var4;
      if (this.typeListe == 1) {
         for(var4 = 0; var4 < this.listeDetailFraisTransporteur.size(); ++var4) {
            if (((ProduitsFrais)this.listeDetailFraisTransporteur.get(var4)).getProfrsCategorie() == 4) {
               var2 += ((ProduitsFrais)this.listeDetailFraisTransporteur.get(var4)).getProfrsValD();
            }
         }
      } else if (this.typeListe == 2) {
         for(var4 = 0; var4 < this.listeDetailFraisTranstaire.size(); ++var4) {
            if (((ProduitsFrais)this.listeDetailFraisTranstaire.get(var4)).getProfrsCategorie() == 4) {
               var2 += ((ProduitsFrais)this.listeDetailFraisTranstaire.get(var4)).getProfrsValELocal();
            }
         }
      }

      return var2;
   }

   public double calculeFrs1() {
      double var1 = 0.0D;
      if (this.cotationEnteteAchats.getCotReachem1() == 1) {
         this.produitsFrais.getProfrsValD();
      }

      return var1;
   }

   public double calculeFrs2() {
      double var1 = 0.0D;
      if (this.cotationEnteteAchats.getCotReachem2() == 1) {
         this.produitsFrais.getProfrsValD();
      }

      return var1;
   }

   public double calculeFrs3() {
      double var1 = 0.0D;
      if (this.cotationEnteteAchats.getCotReachem3() == 1) {
         this.produitsFrais.getProfrsValD();
      }

      return var1;
   }

   public String filtreCaracteres(String var1) {
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3 = (String)var1.subSequence(var4, var4 + 1);
         if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz:=+-*/.,;_1234567890()|<>".contains(var3)) {
            var2 = var2 + var3.toUpperCase();
         }
      }

      return var2;
   }

   public double mefDevise(double var1, String var3) {
      if (var3.equals("A")) {
         var1 = this.utilNombre.myRound(var1, this.produitsFrais.getProfrsDecimalA());
      } else if (var3.equals("B")) {
         var1 = this.utilNombre.myRound(var1, this.produitsFrais.getProfrsDecimalB());
      } else if (var3.equals("C")) {
         var1 = this.utilNombre.myRound(var1, this.produitsFrais.getProfrsDecimalC());
      } else if (var3.equals("D")) {
         var1 = this.utilNombre.myRound(var1, this.produitsFrais.getProfrsDecimalD());
      } else if (var3.equals("E")) {
         var1 = this.utilNombre.myRound(var1, this.produitsFrais.getProfrsDecimalE());
      } else if (var3.equals("F")) {
         var1 = this.utilNombre.myRound(var1, this.produitsFrais.getProfrsDecimalF());
      }

      return var1;
   }

   public double analyseSi(String var1, String var2, String var3) {
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      double var10 = 0.0D;
      double var12 = 0.0D;
      byte var14 = 0;
      String[] var16;
      String[] var17;
      String[] var18;
      String var26;
      if (!var3.contains(";")) {
         String[] var15 = var3.split(":");
         if (var15[0].contains("=")) {
            var14 = 0;
            var16 = var15[0].split("=");
            if (var16[0].contains(":")) {
               var17 = var16[0].substring(3, var16[0].length() - 1).split(":");
               var6 = this.analyseRUB(var17[0], var17[1]);
            } else if (var16[0].contains("DOC(CONTENER)")) {
               var6 = (double)this.cotationEnteteAchats.getCotContener();
            }

            if (!var16[1].contains("VAL")) {
               if (var16[1].contains("RUB") && var16[1].contains(":")) {
                  var26 = var16[1].substring(4, var16[1].length() - 1);
                  var18 = var26.split(":");
                  var8 = this.analyseRUB(var18[0], var18[1]);
               } else if (var16[1].contains("RUB") && !var16[1].contains(":")) {
                  var26 = var16[1].substring(4, var16[1].length() - 1);
                  var8 = this.analyseRUB(var26);
               }
            } else {
               var26 = var16[1].substring(4, var16[1].length() - 1);
               if (var26 == null || var26.isEmpty()) {
                  var26 = "0";
               }

               var8 = Double.parseDouble(var26);
            }
         } else if (var15[0].contains("<")) {
            var14 = 1;
            var16 = var15[0].split("<");
            if (var16[0].contains(":")) {
               var17 = var16[0].substring(3, var16[0].length() - 1).split(":");
               var6 = this.analyseRUB(var17[0], var17[1]);
            } else if (var16[0].contains("DOC(CONTENER)")) {
               var6 = (double)this.cotationEnteteAchats.getCotContener();
            }

            if (!var16[1].contains("VAL")) {
               if (var16[1].contains("RUB") && var16[1].contains(":")) {
                  var26 = var16[1].substring(4, var16[1].length() - 1);
                  var18 = var26.split(":");
                  var8 = this.analyseRUB(var18[0], var18[1]);
               } else if (var16[1].contains("RUB") && !var16[1].contains(":")) {
                  var26 = var16[1].substring(4, var16[1].length() - 1);
                  var8 = this.analyseRUB(var26);
               }
            } else {
               var26 = var16[1].substring(4, var16[1].length() - 1);
               if (var26 == null || var26.isEmpty()) {
                  var26 = "0";
               }

               var8 = Double.parseDouble(var26);
            }
         } else if (var15[0].contains(">")) {
            var14 = 2;
            var16 = var15[0].split(">");
            if (var16[0].contains(":")) {
               var17 = var16[0].substring(3, var16[0].length() - 1).split(":");
               var6 = this.analyseRUB(var17[0], var17[1]);
            } else if (var16[0].contains("DOC(CONTENER)")) {
               var6 = (double)this.cotationEnteteAchats.getCotContener();
            }

            if (!var16[1].contains("VAL")) {
               if (var16[1].contains("RUB") && var16[1].contains(":")) {
                  var26 = var16[1].substring(4, var16[1].length() - 1);
                  var18 = var26.split(":");
                  var8 = this.analyseRUB(var18[0], var18[1]);
               } else if (var16[1].contains("RUB") && !var16[1].contains(":")) {
                  var26 = var16[1].substring(4, var16[1].length() - 1);
                  var8 = this.analyseRUB(var26);
               }
            } else {
               var26 = var16[1].substring(4, var16[1].length() - 1);
               if (var26 == null || var26.isEmpty()) {
                  var26 = "0";
               }

               var8 = Double.parseDouble(var26);
            }
         }

         if (var15[1].contains("|")) {
            var16 = var15[1].split("|");
            if (var16[0].contains("VAL")) {
               var26 = var16[0].substring(4, var16[0].length() - 1);
               if (var26 == null || var26.isEmpty()) {
                  var26 = "0";
               }

               var10 = Double.parseDouble(var26);
            } else if (var16[1].contains("RUB") && var16[1].contains(":")) {
               var26 = var16[0].substring(4, var16[0].length() - 1);
               var18 = var26.split(":");
               var10 = this.analyseRUB(var18[0], var18[1]);
            } else if (var16[1].contains("RUB") && !var16[1].contains(":")) {
               var26 = var16[1].substring(4, var16[1].length() - 1);
               var10 = this.analyseRUB(var26);
            }

            if (!var16[1].contains("VAL")) {
               if (var16[1].contains("RUB") && var16[1].contains(":")) {
                  var26 = var16[1].substring(4, var16[1].length() - 1);
                  var18 = var26.split(":");
                  var12 = this.analyseRUB(var18[0], var18[1]);
               } else if (var16[1].contains("RUB") && !var16[1].contains(":")) {
                  var26 = var16[1].substring(4, var16[1].length() - 1);
                  var12 = this.analyseRUB(var26);
               }
            } else {
               var26 = var16[1].substring(4, var16[1].length() - 1);
               if (var26 == null || var26.isEmpty()) {
                  var26 = "0";
               }

               var12 = Double.parseDouble(var26);
            }
         }

         if (var14 == 0) {
            if (var6 == var8) {
               var4 = var10;
            } else {
               var4 = var12;
            }
         } else if (var14 == 1) {
            if (var6 < var8) {
               var4 = var10;
            } else {
               var4 = var12;
            }
         } else if (var14 == 2) {
            if (var6 > var8) {
               var4 = var10;
            } else {
               var4 = var12;
            }
         }
      } else if (var3.contains(";")) {
         String var25 = var3.substring(3, var3.length() - 1);
         var16 = var25.split(";");
         if (var16[0].contains("=") || var16[0].contains("<") || var16[0].contains(">")) {
            var14 = 0;
            var17 = null;
            if (var16[0].contains("=")) {
               var17 = var16[0].split("=");
               var14 = 0;
            } else if (var16[0].contains("<")) {
               var17 = var16[0].split("<");
               var14 = 1;
            } else if (var16[0].contains(">")) {
               var17 = var16[0].split(">");
               var14 = 2;
            }

            if (var17[0].contains(":")) {
               var18 = var17[0].substring(4, var17[0].length() - 1).split(":");
               var6 = this.analyseRUB(var18[0], var18[1]);
            }

            String var27;
            if (!var17[1].contains("VAL")) {
               if (var17[1].contains("RUB") && var17[1].contains(":")) {
                  var27 = var17[1].substring(4, var17[1].length() - 1);
                  String[] var19 = var27.split(":");
                  var8 = this.analyseRUB(var19[0], var19[1]);
               }
            } else {
               var27 = var17[1].substring(4, var17[1].length() - 1);
               if (var27 == null || var27.isEmpty()) {
                  var27 = "0";
               }

               var8 = Double.parseDouble(var27);
            }
         }

         var26 = var16[1];
         double var28 = 0.0D;
         String var20;
         if (var26.contains("VAR(")) {
            var28 = this.analyseVar(var1, var2);
         } else if (!var26.contains("VAL(")) {
            String[] var21;
            if (var26.contains("RUB(")) {
               var20 = var26.substring(4, var26.length() - 1);
               if (var20 != null && !var20.isEmpty() && var20.contains(":")) {
                  var21 = var20.split(":");
                  var28 = this.analyseRUB(var21[0], var21[1]);
               } else if (var20 != null && !var20.isEmpty() && !var20.contains(":")) {
                  var28 = this.analyseRUB(var20);
               } else {
                  var28 = 0.0D;
               }
            } else if (var3.contains("TOT(")) {
               var20 = var26.substring(4, var26.length() - 1);
               if (var20 != null && !var20.isEmpty() && var20.contains(":")) {
                  var21 = var20.split(":");
                  var28 = this.analyseTOT(var21[0], var21[1], var21[2]);
               } else {
                  var28 = 0.0D;
               }
            }
         } else {
            var20 = var26.substring(4, var26.length() - 1);
            if (var20 == null || var20.isEmpty()) {
               var20 = "0";
            }

            var28 = Double.parseDouble(var20);
         }

         var20 = var16[2];
         double var29 = 0.0D;
         if (var20.contains("VAR(")) {
            var29 = this.analyseVar(var1, var2);
         } else {
            String var23;
            if (!var20.contains("VAL(")) {
               String[] var24;
               if (var20.contains("RUB(")) {
                  var23 = var20.substring(4, var20.length() - 1);
                  if (var23 != null && !var23.isEmpty() && var23.contains(":")) {
                     var24 = var23.split(":");
                     var29 = this.analyseRUB(var24[0], var24[1]);
                  } else if (var23 != null && !var23.isEmpty() && !var23.contains(":")) {
                     var29 = this.analyseRUB(var23);
                  } else {
                     var29 = 0.0D;
                  }
               } else if (var3.contains("TOT(")) {
                  var23 = var20.substring(4, var20.length() - 1);
                  if (var23 != null && !var23.isEmpty() && var23.contains(":")) {
                     var24 = var23.split(":");
                     var29 = this.analyseTOT(var24[0], var24[1], var24[2]);
                  } else {
                     var29 = 0.0D;
                  }
               }
            } else {
               var23 = var20.substring(4, var20.length() - 1);
               if (var23 == null || var23.isEmpty()) {
                  var23 = "0";
               }

               var29 = Double.parseDouble(var23);
            }
         }

         if (var14 == 0) {
            if (var6 == var8) {
               var4 = var28;
            } else {
               var4 = var29;
            }
         } else if (var14 == 1) {
            if (var6 < var8) {
               var4 = var28;
            } else {
               var4 = var29;
            }
         } else if (var14 == 2) {
            if (var6 > var8) {
               var4 = var28;
            } else {
               var4 = var29;
            }
         }
      }

      return var4;
   }

   public void supprimerSimulationTiersCotation(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      List var2 = this.produitsFraisDao.chargeDetailSimulationCotTiers(this.cotationEnteteAchats.getCotId(), var1);
      if (var2.size() != 0) {
         new ProduitsFrais();

         for(int var4 = 0; var4 < var2.size(); ++var4) {
            ProduitsFrais var3 = (ProduitsFrais)var2.get(var4);
            this.produitsFraisDao.delete(var3, var1);
         }
      }

   }

   public void supprimerSimulation() throws HibernateException, NamingException {
      if (this.listeDetailFrais.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new ProduitsFrais();

            for(int var4 = 0; var4 < this.listeDetailFrais.size(); ++var4) {
               ProduitsFrais var3 = (ProduitsFrais)this.listeDetailFrais.get(var4);
               var3 = this.produitsFraisDao.recherParapheur(var3.getProfrsId(), var1);
               if (var3 != null) {
                  this.produitsFraisDao.delete(var3, var1);
               }
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
      }

   }

   public void closeSimulation() {
      this.showModalPanelSimulation = false;
   }

   public void calculPV() throws HibernateException, NamingException {
      this.calculPV((Session)null);
   }

   public void calculPV(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CotationEnteteLight");
         var2 = true;
      }

      this.cotationEnteteAchats.setCotTotPoidsTaxable((float)this.calculeUnitePayante());
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;

      int var11;
      for(var11 = 0; var11 < this.lesLignesListCotations.size(); ++var11) {
         var5 += ((CotationLigneAchats)this.lesLignesListCotations.get(var11)).getCotligCaf();
         var7 = var7 + ((CotationLigneAchats)this.lesLignesListCotations.get(var11)).getCotligT1() + ((CotationLigneAchats)this.lesLignesListCotations.get(var11)).getCotligT10() + ((CotationLigneAchats)this.lesLignesListCotations.get(var11)).getCotligT3() + ((CotationLigneAchats)this.lesLignesListCotations.get(var11)).getCotligT30() + ((CotationLigneAchats)this.lesLignesListCotations.get(var11)).getCotligT31() + ((CotationLigneAchats)this.lesLignesListCotations.get(var11)).getCotligT46() + ((CotationLigneAchats)this.lesLignesListCotations.get(var11)).getCotligT53() + ((CotationLigneAchats)this.lesLignesListCotations.get(var11)).getCotligRusid();
      }

      for(var11 = 0; var11 < this.listeDetailFraisTranstaire.size(); ++var11) {
         var9 += ((ProduitsFrais)this.listeDetailFraisTranstaire.get(var11)).getProfrsValELocal();
      }

      var3 = var5 + var7 + var9;
      this.cotationEnteteAchats.setCotTotPRP(var3);
      if (this.cotationEnteteAchats.getCotDevise() == null || this.cotationEnteteAchats.getCotDevise().isEmpty()) {
         this.cotationEnteteAchats.setCotDevise(this.structureLog.getStrdevise());
      }

      this.cotationEnteteAchats.setCotCoefDevise(this.calculTauxDevise(this.cotationEnteteAchats.getCotDevise()));
      if (this.cotationEnteteAchats.getCotCoefDevise() == 0.0F) {
         this.cotationEnteteAchats.setCotCoefDevise(1.0F);
      }

      double var24 = this.cotationEnteteAchats.getCotTotHt() * (double)this.cotationEnteteAchats.getCotCoefDevise();
      float var13 = (float)(this.cotationEnteteAchats.getCotTotPRP() / var24);
      this.cotationEnteteAchats.setCotCoefPRP(var13);
      double var14 = 0.0D;
      if (this.pvPropose == 0.0D) {
         this.pvPropose = this.cotationEnteteAchats.getCotTotTVente();
      }

      if (this.lesLignesListCotations.size() != 0) {
         CotationLigneAchatsDao var16 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         new CotationLigneAchats();

         for(int var18 = 0; var18 < this.lesLignesListCotations.size(); ++var18) {
            CotationLigneAchats var17 = (CotationLigneAchats)this.lesLignesListCotations.get(var18);
            float var19 = (float)(var17.getCotligPt() / this.cotationEnteteAchats.getCotTotHt());
            double var20 = var9 * (double)var19;
            var17.setCotligFrais(var17.getCotligT1() + var17.getCotligT10() + var17.getCotligT3() + var17.getCotligT30() + var17.getCotligT31() + var17.getCotligT46() + var17.getCotligT53() + var17.getCotligRusid() + var20);
            var17.setCotligPr(var17.getCotligCaf() + var17.getCotligFrais());
            double var22 = (var17.getCotligCaf() + var17.getCotligFrais()) * (double)(1.0F + this.cotationEnteteAchats.getCotCoefMarge() / 100.0F);
            var17.setCotligPv(var22);
            var17.setCotligPvPropose(this.pvPropose * (double)var19);
            var14 += var22;
            var16.modifLigne(var17, var1);
         }
      }

      this.cotationEnteteAchats.setCotTotTVente(var14);
      this.cotationEnteteAchats.setCotTotTVentePropose(this.pvPropose);
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

   }

   public double calculPRFinal() throws HibernateException, NamingException {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;

      int var9;
      for(var9 = 0; var9 < this.lesLignesListCotations.size(); ++var9) {
         var3 += ((CotationLigneAchats)this.lesLignesListCotations.get(var9)).getCotligCaf();
         var5 = var5 + ((CotationLigneAchats)this.lesLignesListCotations.get(var9)).getCotligT1() + ((CotationLigneAchats)this.lesLignesListCotations.get(var9)).getCotligT10() + ((CotationLigneAchats)this.lesLignesListCotations.get(var9)).getCotligT3() + ((CotationLigneAchats)this.lesLignesListCotations.get(var9)).getCotligT30() + ((CotationLigneAchats)this.lesLignesListCotations.get(var9)).getCotligT31() + ((CotationLigneAchats)this.lesLignesListCotations.get(var9)).getCotligT46() + ((CotationLigneAchats)this.lesLignesListCotations.get(var9)).getCotligT53() + ((CotationLigneAchats)this.lesLignesListCotations.get(var9)).getCotligRusid();
      }

      for(var9 = 0; var9 < this.listeDetailFraisTranstaire.size(); ++var9) {
         var7 += ((ProduitsFrais)this.listeDetailFraisTranstaire.get(var9)).getProfrsValELocal();
      }

      var1 = var3 + var5 + var7;
      this.cotationEnteteAchats.setCotTotPRP(var1);
      return var1;
   }

   public double calculPVFinal() throws HibernateException, NamingException {
      double var1 = 0.0D;
      if (this.lesLignesListCotations.size() != 0) {
         new CotationLigneAchats();

         for(int var4 = 0; var4 < this.lesLignesListCotations.size(); ++var4) {
            CotationLigneAchats var3 = (CotationLigneAchats)this.lesLignesListCotations.get(var4);
            var1 += var3.getCotligPv();
         }
      }

      this.cotationEnteteAchats.setCotTotTVente(var1);
      return var1;
   }

   public double calculPVFinalPropose() throws HibernateException, NamingException {
      double var1 = 0.0D;
      if (this.lesLignesListCotations.size() != 0) {
         new CotationLigneAchats();

         for(int var4 = 0; var4 < this.lesLignesListCotations.size(); ++var4) {
            CotationLigneAchats var3 = (CotationLigneAchats)this.lesLignesListCotations.get(var4);
            var1 += var3.getCotligPvPropose();
         }
      }

      this.cotationEnteteAchats.setCotTotTVentePropose(var1);
      return var1;
   }

   public void calculListeLigne() {
      this.dataModelDetailFraisDouanes.setWrappedData(this.lesLignesListCotations);
   }

   public void initImpression() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.visibleOptionMail = false;
      this.affMail = false;
      this.recupererModeleDocument();
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

   public void recupererModeleDocument() {
      this.lesmodelesImpressions = new ArrayList();
      String var1 = "";
      if (this.nature == 11) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "prp" + File.separator + "cotation" + File.separator;
      } else if (this.nature == 12) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "prp" + File.separator + "commande" + File.separator;
      } else if (this.nature == 500) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "prp" + File.separator + "produit" + File.separator;
      }

      if (var1 != null && !var1.isEmpty()) {
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         String[] var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.lesmodelesImpressions.add(new SelectItem(var5));
               }
            }
         }
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

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleDocument);
         String var1 = "";
         if (this.nature == 11) {
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "prp" + File.separator + "cotation" + File.separator);
            this.utilPrint.setEntete("Impression PRP sur Cotation");
            this.utilPrint.setFiltre("Cotation N°: " + this.cotationEnteteAchats.getCotNum() + " - Fournisseur: " + this.cotationEnteteAchats.getCotNomTiers());
            this.utilPrint.setNomMapping("ProduitsAchs");
            var1 = "cot_id = " + this.cotationEnteteAchats.getCotId();
            this.utilPrint.setCompte(this.cotationEnteteAchats.getCotModelePr());
         } else if (this.nature == 12) {
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "prp" + File.separator + "commande" + File.separator);
            this.utilPrint.setEntete("Impression PRP sur Commande");
            this.utilPrint.setFiltre("Commnde N°: " + this.commandeEnteteAchats.getCmdNum() + " - Fournisseur: " + this.commandeEnteteAchats.getCmdNomTiers());
            this.utilPrint.setNomMapping("ProduitsAchs");
            var1 = "cmd_id = " + this.commandeEnteteAchats.getCmdId();
            this.utilPrint.setCompte(this.commandeEnteteAchats.getCmdModelePr());
         } else if (this.nature == 500) {
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "prp" + File.separator + "produit" + File.separator);
            this.utilPrint.setEntete("Impression PRP sur Produit");
            this.utilPrint.setFiltre("Produit N°: " + this.produits.getProCode() + ": " + this.produits.getProLibClient());
         }

         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setRequete(var1);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         ArrayList var2 = new ArrayList();
         JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var2);
         this.utilPrint.setjRBeanCollectionDataSource(var3);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public List imprimerPRP(PlansAnalytiques var1, Session var2) throws HibernateException, NamingException {
      ArrayList var3 = new ArrayList();
      new CotationLigneAchats();
      String var5 = "";
      CotationLigneAchats var4;
      if (this.cotationEnteteAchats.getCotType() == 0) {
         new DouanesPosition();
         DouanesPositionDao var7 = new DouanesPositionDao(this.baseLog, this.utilInitHibernate);
         int var8;
         if (this.cotationEnteteAchats.getCotExoDouane() != 0) {
            if (this.cotationEnteteAchats.getCotExoDouane() == 1) {
               var5 = "EXONERE DE DOUANES";
            } else if (this.cotationEnteteAchats.getCotExoDouane() == 2) {
               var5 = "TAUX REDUIS DE DOUANES";
            }
         } else {
            for(var8 = 0; var8 < this.lesLignesListCotations.size(); ++var8) {
               var4 = (CotationLigneAchats)this.lesLignesListCotations.get(var8);
               if (var4.getCotligPosTarifaire() != null && !var4.getCotligPosTarifaire().isEmpty() && this.structureLog.getStrzonecommerciale() != null && !this.structureLog.getStrzonecommerciale().isEmpty()) {
                  DouanesPosition var6 = var7.trouverPosition(this.structureLog.getStrzonecommerciale(), var4.getCotligPosTarifaire(), var2);
                  if (var6 != null) {
                     if (var5 != null && !var5.isEmpty()) {
                        if (!var5.contains(var4.getCotligPosTarifaire())) {
                           var5 = var5 + "\n" + var4.getCotligPosTarifaire() + "   dd=" + var6.getDouposDd();
                        }
                     } else {
                        var5 = var4.getCotligPosTarifaire() + "   dd=" + var6.getDouposDd();
                     }
                  }
               }
            }
         }

         if (this.listeDetailFraisTransporteur.size() != 0) {
            for(var8 = 0; var8 < this.listeDetailFraisTransporteur.size(); ++var8) {
               this.produitsFrais = (ProduitsFrais)this.listeDetailFraisTransporteur.get(var8);
               var4 = new CotationLigneAchats();
               this.cotationEnteteAchats.setNomCommercial(var1.getAnaAffaireNomCommercial());
               this.cotationEnteteAchats.setNomResponsable(var1.getAnaAffaireNomResponsable());
               this.cotationEnteteAchats.setNomClient(var1.getAnaAffaireNomClient());
               this.cotationEnteteAchats.setNomContactClient(var1.getAnaAffaireNomContact());
               this.cotationEnteteAchats.setSource(var1.getAnaTierssource());
               this.cotationEnteteAchats.setPosition(var5);
               var4.setCotationEnteteAchats(this.cotationEnteteAchats);
               var4.setCotligStock(0);
               var4.setCotligLibelle(this.produitsFrais.getProfrsLibelle());
               var4.setCotligDevise(this.produitsFrais.getProfrsDevise());
               var4.setCotligPr(this.produitsFrais.getProfrsValD());
               var4.setCotligPu(this.produitsFrais.getProfrsValELocal());
               var3.add(var4);
            }
         }

         double var24 = 0.0D;
         double var10 = 0.0D;
         double var12 = 0.0D;
         double var14 = 0.0D;
         double var16 = 0.0D;
         double var18 = 0.0D;
         double var20 = 0.0D;

         int var22;
         for(var22 = 0; var22 < this.lesLignesListCotations.size(); ++var22) {
            var4 = (CotationLigneAchats)this.lesLignesListCotations.get(var22);
            var24 += var4.getCotligT1();
            var10 += var4.getCotligT3();
            var12 += var4.getCotligT5();
            var14 += var4.getCotligT10();
            var16 += var4.getCotligT30();
            var18 += var4.getCotligT31();
            var20 += var4.getCotligRusid();
         }

         var4 = new CotationLigneAchats();
         this.cotationEnteteAchats.setNomCommercial(var1.getAnaAffaireNomCommercial());
         this.cotationEnteteAchats.setNomResponsable(var1.getAnaAffaireNomResponsable());
         this.cotationEnteteAchats.setNomClient(var1.getAnaAffaireNomClient());
         this.cotationEnteteAchats.setNomContactClient(var1.getAnaAffaireNomContact());
         this.cotationEnteteAchats.setSource(var1.getAnaTierssource());
         this.cotationEnteteAchats.setPosition(var5);
         var4.setCotationEnteteAchats(this.cotationEnteteAchats);
         var4.setCotligStock(1);
         if (this.structureLog.getStrzonecommerciale().equals("CEMAC")) {
            var4.setCotligLibelle("Droit de Douane (DDI)");
         } else {
            var4.setCotligLibelle("Droit de Douane (T1)");
         }

         var4.setCotligDevise(this.structureLog.getStrdevise());
         var4.setCotligPr(0.0D);
         var4.setCotligPu(var24);
         var3.add(var4);
         var4 = new CotationLigneAchats();
         this.cotationEnteteAchats.setNomCommercial(var1.getAnaAffaireNomCommercial());
         this.cotationEnteteAchats.setNomResponsable(var1.getAnaAffaireNomResponsable());
         this.cotationEnteteAchats.setNomClient(var1.getAnaAffaireNomClient());
         this.cotationEnteteAchats.setNomContactClient(var1.getAnaAffaireNomContact());
         this.cotationEnteteAchats.setSource(var1.getAnaTierssource());
         this.cotationEnteteAchats.setPosition(var5);
         var4.setCotationEnteteAchats(this.cotationEnteteAchats);
         var4.setCotligStock(1);
         if (this.structureLog.getStrzonecommerciale().equals("CEMAC")) {
            var4.setCotligLibelle("T.V.A.");
         } else {
            var4.setCotligLibelle("T.V.A. (T5)");
         }

         var4.setCotligDevise(this.structureLog.getStrdevise());
         var4.setCotligPr(var12);
         var4.setCotligPu(0.0D);
         var3.add(var4);
         var4 = new CotationLigneAchats();
         this.cotationEnteteAchats.setNomCommercial(var1.getAnaAffaireNomCommercial());
         this.cotationEnteteAchats.setNomResponsable(var1.getAnaAffaireNomResponsable());
         this.cotationEnteteAchats.setNomClient(var1.getAnaAffaireNomClient());
         this.cotationEnteteAchats.setNomContactClient(var1.getAnaAffaireNomContact());
         this.cotationEnteteAchats.setSource(var1.getAnaTierssource());
         this.cotationEnteteAchats.setPosition(var5);
         var4.setCotationEnteteAchats(this.cotationEnteteAchats);
         var4.setCotligStock(1);
         if (this.structureLog.getStrzonecommerciale().equals("CEMAC")) {
            var4.setCotligLibelle("Taxe communautaire d'intégration (TCI)");
         } else {
            var4.setCotligLibelle("Taxe statistique (T3)");
         }

         var4.setCotligDevise(this.structureLog.getStrdevise());
         var4.setCotligPr(0.0D);
         var4.setCotligPu(var10);
         var3.add(var4);
         var4 = new CotationLigneAchats();
         this.cotationEnteteAchats.setNomCommercial(var1.getAnaAffaireNomCommercial());
         this.cotationEnteteAchats.setNomResponsable(var1.getAnaAffaireNomResponsable());
         this.cotationEnteteAchats.setNomClient(var1.getAnaAffaireNomClient());
         this.cotationEnteteAchats.setNomContactClient(var1.getAnaAffaireNomContact());
         this.cotationEnteteAchats.setSource(var1.getAnaTierssource());
         this.cotationEnteteAchats.setPosition(var5);
         var4.setCotationEnteteAchats(this.cotationEnteteAchats);
         var4.setCotligStock(1);
         if (this.structureLog.getStrzonecommerciale().equals("CEMAC")) {
            var4.setCotligLibelle("Contribution communautaire d'intégration (CCI)");
         } else {
            var4.setCotligLibelle("COSEC (T10)");
         }

         var4.setCotligDevise(this.structureLog.getStrdevise());
         var4.setCotligPr(0.0D);
         var4.setCotligPu(var14);
         var3.add(var4);
         var4 = new CotationLigneAchats();
         this.cotationEnteteAchats.setNomCommercial(var1.getAnaAffaireNomCommercial());
         this.cotationEnteteAchats.setNomResponsable(var1.getAnaAffaireNomResponsable());
         this.cotationEnteteAchats.setNomClient(var1.getAnaAffaireNomClient());
         this.cotationEnteteAchats.setNomContactClient(var1.getAnaAffaireNomContact());
         this.cotationEnteteAchats.setSource(var1.getAnaTierssource());
         this.cotationEnteteAchats.setPosition(var5);
         var4.setCotationEnteteAchats(this.cotationEnteteAchats);
         var4.setCotligStock(1);
         if (this.structureLog.getStrzonecommerciale().equals("CEMAC")) {
            var4.setCotligLibelle("Taxe de financement OHADA (OAD)");
         } else {
            var4.setCotligLibelle("Prélèvement UEMOA (T30)");
         }

         var4.setCotligDevise(this.structureLog.getStrdevise());
         var4.setCotligPr(0.0D);
         var4.setCotligPu(var16);
         var3.add(var4);
         var4 = new CotationLigneAchats();
         this.cotationEnteteAchats.setNomCommercial(var1.getAnaAffaireNomCommercial());
         this.cotationEnteteAchats.setNomResponsable(var1.getAnaAffaireNomResponsable());
         this.cotationEnteteAchats.setNomClient(var1.getAnaAffaireNomClient());
         this.cotationEnteteAchats.setNomContactClient(var1.getAnaAffaireNomContact());
         this.cotationEnteteAchats.setSource(var1.getAnaTierssource());
         this.cotationEnteteAchats.setPosition(var5);
         var4.setCotationEnteteAchats(this.cotationEnteteAchats);
         var4.setCotligStock(1);
         if (this.structureLog.getStrzonecommerciale().equals("CEMAC")) {
            var4.setCotligLibelle("Contribution spéciale de solidarité (CSS)");
         } else {
            var4.setCotligLibelle("Centimes additionnels CEDEAO (T31)");
         }

         var4.setCotligDevise(this.structureLog.getStrdevise());
         var4.setCotligPr(0.0D);
         var4.setCotligPu(var18);
         var3.add(var4);
         if (this.structureLog.getStrzonecommerciale().equals("CEMAC")) {
            var4 = new CotationLigneAchats();
            this.cotationEnteteAchats.setNomCommercial(var1.getAnaAffaireNomCommercial());
            this.cotationEnteteAchats.setNomResponsable(var1.getAnaAffaireNomResponsable());
            this.cotationEnteteAchats.setNomClient(var1.getAnaAffaireNomClient());
            this.cotationEnteteAchats.setNomContactClient(var1.getAnaAffaireNomContact());
            this.cotationEnteteAchats.setSource(var1.getAnaTierssource());
            this.cotationEnteteAchats.setPosition(var5);
            var4.setCotationEnteteAchats(this.cotationEnteteAchats);
            var4.setCotligStock(1);
            var4.setCotligLibelle("RUSID");
            var4.setCotligDevise(this.structureLog.getStrdevise());
            var4.setCotligPr(0.0D);
            var4.setCotligPu(var20);
            var3.add(var4);
         }

         if (this.listeDetailFraisTranstaire.size() != 0) {
            for(var22 = 0; var22 < this.listeDetailFraisTranstaire.size(); ++var22) {
               this.produitsFrais = (ProduitsFrais)this.listeDetailFraisTranstaire.get(var22);
               var4 = new CotationLigneAchats();
               this.cotationEnteteAchats.setNomCommercial(var1.getAnaAffaireNomCommercial());
               this.cotationEnteteAchats.setNomResponsable(var1.getAnaAffaireNomResponsable());
               this.cotationEnteteAchats.setNomClient(var1.getAnaAffaireNomClient());
               this.cotationEnteteAchats.setNomContactClient(var1.getAnaAffaireNomContact());
               this.cotationEnteteAchats.setSource(var1.getAnaTierssource());
               this.cotationEnteteAchats.setPosition(var5);
               var4.setCotationEnteteAchats(this.cotationEnteteAchats);
               var4.setCotligStock(2);
               var4.setCotligLibelle(this.produitsFrais.getProfrsLibelle());
               var4.setCotligDevise(this.produitsFrais.getProfrsDevise());
               var4.setCotligPr(this.produitsFrais.getProfrsValD());
               var4.setCotligPu(this.produitsFrais.getProfrsValELocal());
               var3.add(var4);
            }
         }
      }

      for(int var23 = 0; var23 < this.lesLignesListCotations.size(); ++var23) {
         var4 = (CotationLigneAchats)this.lesLignesListCotations.get(var23);
         this.cotationEnteteAchats.setNomCommercial(var1.getAnaAffaireNomCommercial());
         this.cotationEnteteAchats.setNomResponsable(var1.getAnaAffaireNomResponsable());
         this.cotationEnteteAchats.setNomClient(var1.getAnaAffaireNomClient());
         this.cotationEnteteAchats.setNomContactClient(var1.getAnaAffaireNomContact());
         this.cotationEnteteAchats.setSource(var1.getAnaTierssource());
         this.cotationEnteteAchats.setPosition(var5);
         var4.setCotationEnteteAchats(this.cotationEnteteAchats);
         var4.setCotligStock(3);
         var4.setCotligPr(var4.getCotligPr());
         var4.setCotligPu(var4.getCotligPv());
         var4.setCotligDevise(this.structureLog.getStrdevise());
         var3.add(var4);
      }

      return var3;
   }

   public boolean isAffichageListeVariable() {
      return this.affichageListeVariable;
   }

   public void setAffichageListeVariable(boolean var1) {
      this.affichageListeVariable = var1;
   }

   public boolean isAffiche_devise() {
      return this.affiche_devise;
   }

   public void setAffiche_devise(boolean var1) {
      this.affiche_devise = var1;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public DataModel getDataModelDetailFrais() {
      return this.dataModelDetailFrais;
   }

   public void setDataModelDetailFrais(DataModel var1) {
      this.dataModelDetailFrais = var1;
   }

   public DataModel getDataModelVariables() {
      return this.dataModelVariables;
   }

   public void setDataModelVariables(DataModel var1) {
      this.dataModelVariables = var1;
   }

   public boolean isMasquerColonneIntemediaire() {
      return this.masquerColonneIntemediaire;
   }

   public void setMasquerColonneIntemediaire(boolean var1) {
      this.masquerColonneIntemediaire = var1;
   }

   public boolean isMasquerFomrule() {
      return this.masquerFomrule;
   }

   public void setMasquerFomrule(boolean var1) {
      this.masquerFomrule = var1;
   }

   public List getMesSimulationItems() {
      return this.mesSimulationItems;
   }

   public void setMesSimulationItems(List var1) {
      this.mesSimulationItems = var1;
   }

   public boolean isShowModalPanelSimulation() {
      return this.showModalPanelSimulation;
   }

   public void setShowModalPanelSimulation(boolean var1) {
      this.showModalPanelSimulation = var1;
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

   public double getVar_assurance() {
      return this.var_assurance;
   }

   public void setVar_assurance(double var1) {
      this.var_assurance = var1;
   }

   public double getVar_assurance_local() {
      return this.var_assurance_local;
   }

   public void setVar_assurance_local(double var1) {
      this.var_assurance_local = var1;
   }

   public float getVar_coef_devise() {
      return this.var_coef_devise;
   }

   public void setVar_coef_devise(float var1) {
      this.var_coef_devise = var1;
   }

   public Date getVar_date_simulation() {
      return this.var_date_simulation;
   }

   public void setVar_date_simulation(Date var1) {
      this.var_date_simulation = var1;
   }

   public String getVar_devise() {
      return this.var_devise;
   }

   public void setVar_devise(String var1) {
      this.var_devise = var1;
   }

   public int getVar_format_devise() {
      return this.var_format_devise;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public double getVar_fret() {
      return this.var_fret;
   }

   public void setVar_fret(double var1) {
      this.var_fret = var1;
   }

   public double getVar_fret_local() {
      return this.var_fret_local;
   }

   public void setVar_fret_local(double var1) {
      this.var_fret_local = var1;
   }

   public String getVar_modele_simulation() {
      return this.var_modele_simulation;
   }

   public void setVar_modele_simulation(String var1) {
      this.var_modele_simulation = var1;
   }

   public double getVar_montant_initial() {
      return this.var_montant_initial;
   }

   public void setVar_montant_initial(double var1) {
      this.var_montant_initial = var1;
   }

   public double getVar_pa() {
      return this.var_pa;
   }

   public void setVar_pa(double var1) {
      this.var_pa = var1;
   }

   public double getVar_pa_local() {
      return this.var_pa_local;
   }

   public void setVar_pa_local(double var1) {
      this.var_pa_local = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public CommandeEnteteAchats getCommandeEnteteAchats() {
      return this.commandeEnteteAchats;
   }

   public void setCommandeEnteteAchats(CommandeEnteteAchats var1) {
      this.commandeEnteteAchats = var1;
   }

   public CotationEnteteAchats getCotationEnteteAchats() {
      return this.cotationEnteteAchats;
   }

   public void setCotationEnteteAchats(CotationEnteteAchats var1) {
      this.cotationEnteteAchats = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public String getMontant_lettre() {
      return this.montant_lettre;
   }

   public void setMontant_lettre(String var1) {
      this.montant_lettre = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
   }

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
   }

   public String getImpDestinataire() {
      return this.impDestinataire;
   }

   public void setImpDestinataire(String var1) {
      this.impDestinataire = var1;
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

   public String getImpEmetteur() {
      return this.impEmetteur;
   }

   public void setImpEmetteur(String var1) {
      this.impEmetteur = var1;
   }

   public List getLesmodelesImpressions() {
      return this.lesmodelesImpressions;
   }

   public void setLesmodelesImpressions(List var1) {
      this.lesmodelesImpressions = var1;
   }

   public String getNomModeleDocument() {
      return this.nomModeleDocument;
   }

   public void setNomModeleDocument(String var1) {
      this.nomModeleDocument = var1;
   }

   public int getVar_cateorie() {
      return this.var_cateorie;
   }

   public void setVar_cateorie(int var1) {
      this.var_cateorie = var1;
   }

   public int getVar_exo_douane() {
      return this.var_exo_douane;
   }

   public void setVar_exo_douane(int var1) {
      this.var_exo_douane = var1;
   }

   public long getVar_id_transitaire() {
      return this.var_id_transitaire;
   }

   public void setVar_id_transitaire(long var1) {
      this.var_id_transitaire = var1;
   }

   public long getVar_id_transporteur() {
      return this.var_id_transporteur;
   }

   public void setVar_id_transporteur(long var1) {
      this.var_id_transporteur = var1;
   }

   public String getVar_mode() {
      return this.var_mode;
   }

   public void setVar_mode(String var1) {
      this.var_mode = var1;
   }

   public int getVar_nature() {
      return this.var_nature;
   }

   public void setVar_nature(int var1) {
      this.var_nature = var1;
   }

   public String getVar_nom_transitaire() {
      return this.var_nom_transitaire;
   }

   public void setVar_nom_transitaire(String var1) {
      this.var_nom_transitaire = var1;
   }

   public String getVar_nom_transorteur() {
      return this.var_nom_transorteur;
   }

   public void setVar_nom_transorteur(String var1) {
      this.var_nom_transorteur = var1;
   }

   public int getVar_exo_tva() {
      return this.var_exo_tva;
   }

   public void setVar_exo_tva(int var1) {
      this.var_exo_tva = var1;
   }

   public float getVar_coef_prp() {
      return this.var_coef_prp;
   }

   public void setVar_coef_prp(float var1) {
      this.var_coef_prp = var1;
   }

   public String getChaineTransitaire() {
      return this.chaineTransitaire;
   }

   public void setChaineTransitaire(String var1) {
      this.chaineTransitaire = var1;
   }

   public String getChaineTransporteur() {
      return this.chaineTransporteur;
   }

   public void setChaineTransporteur(String var1) {
      this.chaineTransporteur = var1;
   }

   public DataModel getDataModelDetailFraisTransitaire() {
      return this.dataModelDetailFraisTransitaire;
   }

   public void setDataModelDetailFraisTransitaire(DataModel var1) {
      this.dataModelDetailFraisTransitaire = var1;
   }

   public DataModel getDataModelDetailFraisTransporteur() {
      return this.dataModelDetailFraisTransporteur;
   }

   public void setDataModelDetailFraisTransporteur(DataModel var1) {
      this.dataModelDetailFraisTransporteur = var1;
   }

   public List getListeDetailFraisTransporteur() {
      return this.listeDetailFraisTransporteur;
   }

   public void setListeDetailFraisTransporteur(List var1) {
      this.listeDetailFraisTransporteur = var1;
   }

   public List getListeDetailFraisTranstaire() {
      return this.listeDetailFraisTranstaire;
   }

   public void setListeDetailFraisTranstaire(List var1) {
      this.listeDetailFraisTranstaire = var1;
   }

   public List getLesLignesListCotations() {
      return this.lesLignesListCotations;
   }

   public void setLesLignesListCotations(List var1) {
      this.lesLignesListCotations = var1;
   }

   public DataModel getDataModelDetailFraisDouanes() {
      return this.dataModelDetailFraisDouanes;
   }

   public void setDataModelDetailFraisDouanes(DataModel var1) {
      this.dataModelDetailFraisDouanes = var1;
   }

   public double getPvPropose() {
      return this.pvPropose;
   }

   public void setPvPropose(double var1) {
      this.pvPropose = var1;
   }
}
