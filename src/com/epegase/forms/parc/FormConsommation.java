package com.epegase.forms.parc;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesParc;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.ParcConsommation;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ParcConsommationDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
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

public class FormConsommation implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private int var_memo_action;
   private String pageIndex;
   private int nature;
   private OptionParcs optionParcs;
   private ExercicesParc selectedExo;
   private ExercicesParc lastExo;
   private UtilNombre utilNombre = new UtilNombre();
   private UtilDate utilDate = new UtilDate();
   private List mesOnglets;
   private int var_nb_max = 100;
   private FormRecherche formRecherche;
   private String libelleConsommation;
   private CalculChrono calculChrono;
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private EspionDao espionDao;
   private boolean var_acc_descriptif = false;
   private boolean var_acc_affectation = false;
   private boolean var_acc_etat = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private boolean var_aff_action = false;
   private boolean var_valide_parc = false;
   private boolean var_saisie_pu = false;
   private List mesNatureItems;
   private List mesServiceItems;
   private List mesFamilleItems_rec;
   private String var_immat_rec = "";
   private String var_nature_rec = "";
   private String var_famille_rec = "";
   private String var_origine_rec = "";
   private int var_type_rec = 0;
   private String var_service_rec = "";
   private String periode;
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private ParcConsommation parcConsommation;
   private ParcConsommationDao parcConsommationDao;
   private List lesConsommations = new ArrayList();
   private transient DataModel dataModelConsommations = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean var_affiche_bouton = false;
   private Parc parc;
   private ProduitsAchsDao produitsAchsDao;
   private List lesProdtuisItems = new ArrayList();
   private List lesDepotsItems = new ArrayList();
   private List lesProduits = new ArrayList();
   private ProduitsDepotDao produitsDepotDao;
   private CalculStock calculStock;
   private List mesDemandeursItems = new ArrayList();
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
   private boolean showModalPanelGraph = false;
   private int timeDecoupage;
   private int modeGraph;
   private int valQteGraph;
   private String titreGraph;
   private String sousTitreGraph;
   private String uniteGraph;
   private int nbDecGraph;
   private String deviseGraph;
   private boolean showModele;
   private List mesActivitesItems;
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

   public FormConsommation() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.calculStock = new CalculStock();
      this.lesDecoupagesActivites = new ArrayList();
      this.dataModelDecoupageActivtes = new ListDataModel();
      this.usersChrono = new UsersChrono();
   }

   public void InstancesDaoUtilses() {
      this.parcConsommationDao = new ParcConsommationDao(this.baseLog, this.utilInitHibernate);
      this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
   }

   public void initialisation(Session var1) throws HibernateException, NamingException {
      if (this.optionParcs.getNbLigneMax() != null && !this.optionParcs.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionParcs.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.var_action = 0;
      this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public void rechercherConsommation() throws HibernateException, NamingException, ParseException {
      this.rechercherConsommation((Session)null);
   }

   public void moreSearch() throws ParseException {
      if (!this.var_more_search) {
         this.var_more_search = true;
         this.periode = "100";
         String var1 = (new Date()).getYear() + 1900 + "-01-01";
         this.inpDu = this.utilDate.stringToDateSQLLight(var1);
         String var2 = (new Date()).getYear() + 1900 + "-12-31";
         this.inpAu = this.utilDate.stringToDateSQLLight(var2);
      } else {
         this.var_more_search = false;
         this.inpDu = null;
         this.inpAu = null;
      }

   }

   public void rechercherConsommation(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesConsommations.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      String var2 = "";
      String var3 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var2 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var3 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var2 = null;
         var3 = null;
      }

      this.lesConsommations = this.parcConsommationDao.rechercheParcConsommation(this.selectedExo.getExeprcId(), this.var_immat_rec, this.var_nature_rec, this.var_famille_rec, this.var_origine_rec, this.var_type_rec, this.var_service_rec, var2, var3, this.periode, var1);
      this.dataModelConsommations.setWrappedData(this.lesConsommations);
   }

   public void accesResteintGroupe() {
      this.var_acc_descriptif = false;
      this.var_acc_affectation = false;
      this.var_acc_etat = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_acc_descriptif = true;
            } else if (var1.getCode().equals("2")) {
               this.var_acc_affectation = true;
            } else if (var1.getCode().equals("3")) {
               this.var_acc_etat = true;
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

   public void autorisationAffectation() {
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

   public void autorisationEtat() {
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

   public void selectionConsommation() throws HibernateException, NamingException {
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
            this.parcConsommation = (ParcConsommation)var1.get(0);
            if (this.var_type_rec == 0) {
               this.libelleConsommation = "CARBURANT";
            } else if (this.var_type_rec == 1) {
               this.libelleConsommation = "LUBRIFIANT";
            }

            this.var_date = this.parcConsommation.getPrcconDate();
            if (this.parcConsommation.getPrcconDate().getHours() <= 9) {
               this.var_heure = "0" + this.parcConsommation.getPrcconDate().getHours();
            } else {
               this.var_heure = "" + this.parcConsommation.getPrcconDate().getHours();
            }

            if (this.parcConsommation.getPrcconDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.parcConsommation.getPrcconDate().getMinutes();
            } else {
               this.var_minute = "" + this.parcConsommation.getPrcconDate().getMinutes();
            }

            if (this.parcConsommation.getPrcconDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.parcConsommation.getPrcconDate().getSeconds();
            } else {
               this.var_seconde = "" + this.parcConsommation.getPrcconDate().getSeconds();
            }

            this.parc = this.parcConsommation.getParc();
            this.lesProdtuisItems.clear();
            this.lesProduits.clear();
            if (this.parcConsommation.getPrcconCode() != null && !this.parcConsommation.getPrcconCode().isEmpty()) {
               this.lesProdtuisItems.add(new SelectItem(this.parcConsommation.getPrcconCode(), this.parcConsommation.getPrcconLibelle()));
            } else {
               this.lesProdtuisItems.add(new SelectItem((Object)null, "Sans produit"));
            }

            this.lesDepotsItems.clear();
            if (this.parcConsommation.getPrcconDepot() != null && !this.parcConsommation.getPrcconDepot().isEmpty()) {
               this.lesDepotsItems.add(new SelectItem(this.parcConsommation.getPrcconDepot(), this.parcConsommation.getPrcconDepot()));
            } else {
               this.lesDepotsItems.add(new SelectItem((Object)null, "Sans dépôt"));
            }

            if (this.parcConsommation.getPrcconService() != null && !this.parcConsommation.getPrcconService().isEmpty()) {
               this.calculDemandeur();
            }

            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            this.var_affiche_bouton = true;
         } else {
            this.var_affiche_bouton = false;
         }
      } else {
         this.var_affiche_bouton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.parcConsommation != null) {
         if (this.parcConsommation.getPrcconEtat() == 0) {
            this.modifierConsommation();
         } else {
            this.consulterConsommation();
         }
      }

   }

   public void ajouterConsommation() throws HibernateException, NamingException {
      this.parc = new Parc();
      this.parcConsommation = new ParcConsommation();
      this.lesProdtuisItems.clear();
      this.lesProduits.clear();
      this.lesDepotsItems.clear();
      if (this.var_type_rec == 0) {
         this.libelleConsommation = "CARBURANT";
      } else if (this.var_type_rec == 1) {
         this.libelleConsommation = "LUBRIFIANT";
      }

      this.var_date = new Date();
      if ((new Date()).getHours() <= 9) {
         this.var_heure = "0" + (new Date()).getHours();
      } else {
         this.var_heure = "" + (new Date()).getHours();
      }

      if ((new Date()).getMinutes() <= 9) {
         this.var_minute = "0" + (new Date()).getMinutes();
      } else {
         this.var_minute = "" + (new Date()).getMinutes();
      }

      if ((new Date()).getSeconds() <= 9) {
         this.var_seconde = "0" + (new Date()).getSeconds();
      } else {
         this.var_seconde = "" + (new Date()).getSeconds();
      }

      this.var_saisie_pu = false;
      this.var_action = 1;
      this.var_valide_parc = false;
      this.var_aff_action = false;
      this.var_memo_action = this.var_action;
   }

   public void modifierConsommation() {
      if (this.parcConsommation != null) {
         this.var_valide_parc = true;
         this.var_aff_action = false;
         this.var_action = 2;
         this.var_memo_action = this.var_action;
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.parcConsommation != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsommationParc");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.parcConsommation.getPrcconEtat() == 0 && this.usersChrono.getUsrchrValidation() == 2) {
               this.parcConsommation.setPrcconEtat(1);
               this.parcConsommation = this.parcConsommationDao.modif(this.parcConsommation, var1);
               if (this.parcConsommation.getPrcconDepot() != null && !this.parcConsommation.getPrcconDepot().isEmpty()) {
                  this.calculStock.majConsommation(this.parcConsommation, 1, this.baseLog, var1);
               }

               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle consommation (P.) N° " + this.parcConsommation.getPrcconNum() + " du " + this.utilDate.dateToStringSQLLight(this.parcConsommation.getPrcconDate()));
               this.espionDao.mAJEspion(var3, var1);
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

   public void deValideDocument() throws HibernateException, NamingException {
      if (this.parcConsommation != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsommationParc");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.parcConsommation.getPrcconEtat() == 1) {
               this.parcConsommation.setPrcconEtat(0);
               this.parcConsommation = this.parcConsommationDao.modif(this.parcConsommation, var1);
               if (this.parcConsommation.getPrcconDepot() != null && !this.parcConsommation.getPrcconDepot().isEmpty()) {
                  this.calculStock.majConsommation(this.parcConsommation, 0, this.baseLog, var1);
               }

               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle consommation (P.) N° " + this.parcConsommation.getPrcconNum() + " du " + this.utilDate.dateToStringSQLLight(this.parcConsommation.getPrcconDate()));
               this.espionDao.mAJEspion(var3, var1);
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

   public void consulterConsommation() {
      if (this.parcConsommation != null) {
         this.var_valide_parc = false;
         this.var_aff_action = true;
         this.var_action = 3;
         this.var_memo_action = this.var_action;
      }

   }

   public void supprimerConsommation() throws HibernateException, NamingException {
      if (this.parcConsommation != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsommationParc");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.parcConsommation.getPrcconDepot() != null && !this.parcConsommation.getPrcconDepot().isEmpty() && this.parcConsommation.getPrcconCode() != null && !this.parcConsommation.getPrcconCode().isEmpty()) {
               this.calculStock.majConsommation(this.parcConsommation, 0, this.baseLog, var1);
            }

            this.parcConsommationDao.delete(this.parcConsommation);
            this.lesConsommations.remove(this.parcConsommation);
            this.dataModelConsommations.setWrappedData(this.lesConsommations);
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

      this.var_affiche_bouton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void annulerConsommation() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.var_affiche_bouton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void saveConsommation() throws HibernateException, NamingException, ParseException {
      this.parcConsommation.setPrcconType(this.var_type_rec);
      this.parcConsommation.setPrcconTypeCompteur(this.parc.getPrcCompteur());
      this.parcConsommation.setPrcconIdPompiste(this.usersLog.getUsrid());
      this.parcConsommation.setPrcconNomPompiste(this.usersLog.getUsrPatronyme());
      this.parcConsommation.setPrcconNomDemandeur("");
      int var1;
      if (this.parcConsommation.getPrcconIdDemandeur() != 0L) {
         for(var1 = 0; var1 < this.mesDemandeursItems.size(); ++var1) {
            long var2 = Long.parseLong(((SelectItem)this.mesDemandeursItems.get(var1)).getValue().toString());
            if (this.parcConsommation.getPrcconIdDemandeur() == var2) {
               this.parcConsommation.setPrcconNomDemandeur(((SelectItem)this.mesDemandeursItems.get(var1)).getLabel().toString());
               break;
            }
         }
      }

      this.parcConsommation.setPrcconLibelle("");
      if (this.parcConsommation.getPrcconCode() != null && !this.parcConsommation.getPrcconCode().isEmpty()) {
         for(var1 = 0; var1 < this.lesProdtuisItems.size(); ++var1) {
            if (this.parcConsommation.getPrcconCode().equals(((SelectItem)this.lesProdtuisItems.get(var1)).getValue().toString())) {
               this.parcConsommation.setPrcconLibelle(((SelectItem)this.lesProdtuisItems.get(var1)).getLabel().toString());
               break;
            }
         }
      }

      if (this.decoupageActivite) {
         this.parcConsommation.setPrcconActivite("");
         String var15 = "";
         boolean var16 = true;
         if (this.lesDecoupagesActivites.size() != 0) {
            for(int var3 = 0; var3 < this.lesDecoupagesActivites.size(); ++var3) {
               this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var3);
               if (this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie() != 0.0D) {
                  if (var16) {
                     var15 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     var16 = false;
                  } else {
                     var15 = var15 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                  }
               }
            }
         }

         this.parcConsommation.setPrcconActivite(var15);
      }

      this.parcConsommation.setPrcconSerie("");
      Session var18 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsommationParc");
      Transaction var17 = null;

      try {
         var17 = var18.beginTransaction();
         if (this.parcConsommation.getPrcconId() != 0L) {
            this.parcConsommation.setPrcconDateModif(new Date());
            this.parcConsommation.setPrcconIdModif(this.usersLog.getUsrid());
            this.parcConsommation = this.parcConsommationDao.modif(this.parcConsommation, var18);
         } else {
            if (this.var_date == null) {
               this.var_date = new Date();
            }

            this.parcConsommation.setPrcconDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
            String var19 = this.calculChrono.numCompose(this.parcConsommation.getPrcconDate(), this.nature, this.parcConsommation.getPrcconSerie(), var18);
            boolean var4 = false;

            while(true) {
               while(!var4) {
                  new ParcConsommation();
                  ParcConsommation var5 = this.parcConsommationDao.rechercheConsommation(var19, var18);
                  if (var5 != null) {
                     long var6 = 100000000L * this.usersLog.getUsrid();

                     for(long var8 = 0L; var8 < var6; ++var8) {
                     }

                     var19 = this.calculChrono.numCompose(this.parcConsommation.getPrcconDate(), this.nature, this.parcConsommation.getPrcconSerie(), var18);
                     var4 = false;
                  } else {
                     var4 = true;
                  }
               }

               this.parcConsommation.setExercicesParc(this.lastExo);
               this.parcConsommation.setParc(this.parc);
               this.parcConsommation.setPrcconEtat(1);
               this.parcConsommation.setPrcconEtatVal(0);
               this.parcConsommation.setPrcconDateValide((Date)null);
               this.parcConsommation.setPrcconNum(var19);
               this.parcConsommation.setPrcconDateCreat(new Date());
               this.parcConsommation.setPrcconIdCreateur(this.usersLog.getUsrid());
               this.parcConsommation = this.parcConsommationDao.insert(this.parcConsommation, var18);
               this.lesConsommations.add(this.parcConsommation);
               this.dataModelConsommations.setWrappedData(this.lesConsommations);
               this.simpleSelectionEntete.clear();
               this.extDTable = new HtmlExtendedDataTable();
               break;
            }
         }

         var17.commit();
      } catch (HibernateException var13) {
         if (var17 != null) {
            var17.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_action = 0;
   }

   public void calculdeDepot() throws HibernateException, NamingException {
      this.lesDepotsItems.clear();
      if (this.parcConsommation.getPrcconCode() != null && !this.parcConsommation.getPrcconCode().isEmpty()) {
         new ArrayList();
         List var1 = this.produitsDepotDao.selectProdDepByprod((String)this.parcConsommation.getPrcconCode(), (Session)null);
         if (var1.size() != 0) {
            for(int var2 = 0; var2 < var1.size(); ++var2) {
               this.lesDepotsItems.add(new SelectItem(((ProduitsDepot)var1.get(var2)).getDepot().getDpoCode(), ((ProduitsDepot)var1.get(var2)).getDepot().getDpoCode() + ":" + ((ProduitsDepot)var1.get(var2)).getDepot().getDpoLibelle()));
            }
         }
      }

      this.lesDepotsItems.add(new SelectItem("", "Sans dépôt"));
   }

   public void calculPu() throws HibernateException, NamingException {
      if (this.parcConsommation.getPrcconDepot() != null && !this.parcConsommation.getPrcconDepot().isEmpty()) {
         new ProduitsDepot();
         ProduitsDepot var1 = this.produitsDepotDao.produitDepByprod(this.parcConsommation.getPrcconCode(), this.parcConsommation.getPrcconDepot(), (Session)null);
         if (var1 != null) {
            if (var1.getProdepPa() != 0.0D) {
               this.parcConsommation.setPrcconPu(var1.getProdepPa());
               this.var_saisie_pu = false;
            } else {
               this.var_saisie_pu = true;
            }
         } else {
            this.var_saisie_pu = true;
         }
      } else {
         this.var_saisie_pu = false;
      }

   }

   public void calculTotal() {
      double var1 = this.utilNombre.myRoundDevise(this.parcConsommation.getPrcconPu() * (double)this.parcConsommation.getPrcconQte(), this.structureLog.getStrdevise());
      this.parcConsommation.setPrcconTotal(var1);
   }

   public void calculDemandeur() throws HibernateException, NamingException {
      this.mesDemandeursItems.clear();
      if (this.parcConsommation.getPrcconService() != null && !this.parcConsommation.getPrcconService().isEmpty()) {
         UserDao var1 = new UserDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var2 = var1.chargerLesUsersByServices(this.parcConsommation.getPrcconService(), (Session)null);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.mesDemandeursItems.add(new SelectItem(((Users)var2.get(var3)).getUsrid(), ((Users)var2.get(var3)).getUsrPatronyme()));
            }
         }
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.parcConsommation.getPrcconActivite() != null && !this.parcConsommation.getPrcconActivite().isEmpty() && this.parcConsommation.getPrcconActivite().contains(":")) {
         String[] var1 = null;
         if (!this.parcConsommation.getPrcconActivite().contains("#")) {
            var1 = this.parcConsommation.getPrcconActivite().split(":");
            if (var1.length == 7) {
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
               this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
               this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            }
         } else {
            String[] var2 = this.parcConsommation.getPrcconActivite().split("#");

            for(int var3 = 0; var3 < var2.length; ++var3) {
               var1 = var2[var3].split(":");
               if (var1.length == 7) {
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
      if (this.lesDecoupagesActivites.size() != 0) {
         for(int var1 = 0; var1 < this.lesDecoupagesActivites.size(); ++var1) {
            this.totalImputation += (double)((EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var1)).getEcranaPourcentage();
         }
      }

      this.soldeImputation = 100.0D - this.totalImputation;
      if (this.soldeImputation > 0.0D) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void rechercheParc() throws JDOMException, IOException, HibernateException, NamingException {
      this.parc = this.formRecherche.rechercheParc(this.parc.getPrcImmatriculation(), this.nature);
      if (this.parc != null) {
         if (this.parc.getPrcId() != 0L) {
            this.calculeParc();
         } else {
            this.var_action = 10;
         }
      } else if (this.parc == null) {
         this.calculeParc();
      }

   }

   public void recuperationParc() throws JDOMException, IOException, HibernateException, NamingException {
      this.parc = this.formRecherche.calculeParc();
      this.calculeParc();
   }

   public void calculeParc() throws JDOMException, IOException, HibernateException, NamingException {
      this.var_saisie_pu = false;
      this.lesProduits.clear();
      this.lesProdtuisItems.clear();
      this.lesDepotsItems.clear();
      if (this.parc != null) {
         new Produits();
         if (this.parc.getPrcAlimentation() != 0 && this.parc.getPrcAlimentation() != 1 && this.parc.getPrcAlimentation() != 2 && this.parc.getPrcAlimentation() != 3 && this.parc.getPrcAlimentation() != 4 && this.parc.getPrcAlimentation() != 5 && this.parc.getPrcAlimentation() != 6 && this.parc.getPrcAlimentation() != 7 && this.parc.getPrcAlimentation() != 8 && this.parc.getPrcAlimentation() != 9 && this.parc.getPrcAlimentation() != 10 && this.parc.getPrcAlimentation() != 11 && this.parc.getPrcAlimentation() == 12) {
         }

         if (this.var_type_rec == 0) {
            this.libelleConsommation = "CARBURANT";
            this.lesProduits = this.produitsAchsDao.chargerLesProduitsByNature("0104", this.parc.getPrcAlimentation(), (Session)null);
         } else if (this.var_type_rec == 1) {
            this.libelleConsommation = "LUBRIFIANT";
            this.lesProduits = this.produitsAchsDao.chargerLesProduitsByNature("0105", this.parc.getPrcAlimentation(), (Session)null);
         }

         if (this.lesProduits.size() != 0) {
            for(int var2 = 0; var2 < this.lesProduits.size(); ++var2) {
               Produits var1 = (Produits)this.lesProduits.get(var2);
               this.lesProdtuisItems.add(new SelectItem(var1.getProCode(), var1.getProLibClient()));
            }
         }

         if (this.lesProdtuisItems.size() == 0) {
            this.lesProdtuisItems.add(new SelectItem("", ""));
            this.lesDepotsItems.add(new SelectItem("", ""));
         } else {
            this.parcConsommation.setPrcconCode(((SelectItem)this.lesProdtuisItems.get(0)).getValue().toString());
            this.calculdeDepot();
         }

         this.var_valide_parc = true;
      } else {
         this.parc = null;
         this.parcConsommation.setPrcconCode("");
         this.parcConsommation.setPrcconDepot("");
         this.lesProdtuisItems.clear();
         this.lesProdtuisItems.add(new SelectItem("", ""));
         this.lesDepotsItems.clear();
         this.lesDepotsItems.add(new SelectItem("", ""));
         this.var_valide_parc = false;
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleParc() {
      this.parc = null;
      this.parcConsommation.setPrcconCode("");
      this.parcConsommation.setPrcconDepot("");
      this.var_action = 0;
      this.lesProduits.clear();
      this.lesProdtuisItems.clear();
      this.lesProdtuisItems.add(new SelectItem("", ""));
      this.lesDepotsItems.clear();
      this.lesDepotsItems.add(new SelectItem("", ""));
      this.var_valide_parc = false;
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

   public String calculeImageFond(String var1, int var2) throws HibernateException, NamingException {
      String var3 = "";
      File var4;
      if (var2 == 0) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatEncours.jpg");
         if (var4.exists()) {
            var3 = "formatEncours.jpg";
         } else {
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatSortie.jpg");
            if (var4.exists()) {
               var3 = "formatSortie.jpg";
            }
         }
      } else if (var2 == 1) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatSortie.jpg");
         if (var4.exists()) {
            var3 = "formatSortie.jpg";
         }
      }

      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (!this.format.equals("MAIL")) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            this.utilPrint.setNomMapping("");
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setEntete("Impression fiche consommation");
            this.utilPrint.setRequete(this.requete);
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "consommation" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.parcConsommation.getPrcconEtat()));
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setIdResponsable(0L);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setNumDoc(this.parcConsommation.getPrcconNum());
            this.utilPrint.setNature(this.nature);
            this.utilPrint.setId_doc(this.parcConsommation.getPrcconId());
            ArrayList var1 = new ArrayList();
            var1.add(this.parcConsommation);
            JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
            this.utilPrint.setjRBeanCollectionDataSource(var2);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des consommations");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "consommation" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNumDoc("");
         this.utilPrint.setNature(this.nature);
         this.utilPrint.setId_doc(0L);
         JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(this.lesConsommations);
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

   public List getMesServiceItems() {
      return this.mesServiceItems;
   }

   public void setMesServiceItems(List var1) {
      this.mesServiceItems = var1;
   }

   public DataModel getDataModelConsommations() {
      return this.dataModelConsommations;
   }

   public void setDataModelConsommations(DataModel var1) {
      this.dataModelConsommations = var1;
   }

   public ParcConsommation getParcConsommation() {
      return this.parcConsommation;
   }

   public void setParcConsommation(ParcConsommation var1) {
      this.parcConsommation = var1;
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

   public List getMesFamilleItems_rec() {
      return this.mesFamilleItems_rec;
   }

   public void setMesFamilleItems_rec(List var1) {
      this.mesFamilleItems_rec = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public boolean isVar_acc_affectation() {
      return this.var_acc_affectation;
   }

   public void setVar_acc_affectation(boolean var1) {
      this.var_acc_affectation = var1;
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

   public int getVar_type_rec() {
      return this.var_type_rec;
   }

   public void setVar_type_rec(int var1) {
      this.var_type_rec = var1;
   }

   public String getDeviseGraph() {
      return this.deviseGraph;
   }

   public void setDeviseGraph(String var1) {
      this.deviseGraph = var1;
   }

   public int getModeGraph() {
      return this.modeGraph;
   }

   public void setModeGraph(int var1) {
      this.modeGraph = var1;
   }

   public boolean isShowModalPanelGraph() {
      return this.showModalPanelGraph;
   }

   public void setShowModalPanelGraph(boolean var1) {
      this.showModalPanelGraph = var1;
   }

   public boolean isShowModele() {
      return this.showModele;
   }

   public void setShowModele(boolean var1) {
      this.showModele = var1;
   }

   public String getSousTitreGraph() {
      return this.sousTitreGraph;
   }

   public void setSousTitreGraph(String var1) {
      this.sousTitreGraph = var1;
   }

   public int getTimeDecoupage() {
      return this.timeDecoupage;
   }

   public void setTimeDecoupage(int var1) {
      this.timeDecoupage = var1;
   }

   public String getTitreGraph() {
      return this.titreGraph;
   }

   public void setTitreGraph(String var1) {
      this.titreGraph = var1;
   }

   public String getUniteGraph() {
      return this.uniteGraph;
   }

   public void setUniteGraph(String var1) {
      this.uniteGraph = var1;
   }

   public int getValQteGraph() {
      return this.valQteGraph;
   }

   public void setValQteGraph(int var1) {
      this.valQteGraph = var1;
   }

   public int getNbDecGraph() {
      return this.nbDecGraph;
   }

   public void setNbDecGraph(int var1) {
      this.nbDecGraph = var1;
   }

   public boolean isVar_aff_action() {
      return this.var_aff_action;
   }

   public void setVar_aff_action(boolean var1) {
      this.var_aff_action = var1;
   }

   public Date getVar_date() {
      return this.var_date;
   }

   public void setVar_date(Date var1) {
      this.var_date = var1;
   }

   public String getVar_heure() {
      return this.var_heure;
   }

   public void setVar_heure(String var1) {
      this.var_heure = var1;
   }

   public String getVar_minute() {
      return this.var_minute;
   }

   public void setVar_minute(String var1) {
      this.var_minute = var1;
   }

   public String getVar_seconde() {
      return this.var_seconde;
   }

   public void setVar_seconde(String var1) {
      this.var_seconde = var1;
   }

   public Parc getParc() {
      return this.parc;
   }

   public void setParc(Parc var1) {
      this.parc = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public List getLesDepotsItems() {
      return this.lesDepotsItems;
   }

   public void setLesDepotsItems(List var1) {
      this.lesDepotsItems = var1;
   }

   public List getLesProdtuisItems() {
      return this.lesProdtuisItems;
   }

   public void setLesProdtuisItems(List var1) {
      this.lesProdtuisItems = var1;
   }

   public String getLibelleConsommation() {
      return this.libelleConsommation;
   }

   public void setLibelleConsommation(String var1) {
      this.libelleConsommation = var1;
   }

   public boolean isVar_valide_parc() {
      return this.var_valide_parc;
   }

   public void setVar_valide_parc(boolean var1) {
      this.var_valide_parc = var1;
   }

   public boolean isVar_saisie_pu() {
      return this.var_saisie_pu;
   }

   public void setVar_saisie_pu(boolean var1) {
      this.var_saisie_pu = var1;
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

   public double getSoldeImputation() {
      return this.soldeImputation;
   }

   public void setSoldeImputation(double var1) {
      this.soldeImputation = var1;
   }

   public double getTotalImputation() {
      return this.totalImputation;
   }

   public void setTotalImputation(double var1) {
      this.totalImputation = var1;
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

   public List getMesActivitesItems() {
      return this.mesActivitesItems;
   }

   public void setMesActivitesItems(List var1) {
      this.mesActivitesItems = var1;
   }

   public List getMesDemandeursItems() {
      return this.mesDemandeursItems;
   }

   public void setMesDemandeursItems(List var1) {
      this.mesDemandeursItems = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
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

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }
}
