package com.epegase.forms.caisse;

import com.epegase.forms.commun.FormAnalytique;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.classe.VirementInterne;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.dao.VirementInterneDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionCaisses;
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

public class FormVirementInterne implements Serializable {
   private int typeVente;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private OptionCaisses optionCaisses;
   private ExercicesCaisse selectedExo;
   private ExercicesCaisse lastExo;
   private ExercicesComptable exercicesComptable;
   private UtilNombre utilNombre = new UtilNombre();
   private UtilDate utilDate = new UtilDate();
   private List mesOnglets;
   private int var_nb_max = 100;
   private UserDao userDao;
   private String nomCreateur;
   private String nomModificateur;
   private long userResponsable;
   private TiersDao tiersDao;
   private EspionDao espionDao;
   private int inpEtat = 0;
   private Date dateDebut;
   private Date dateFin;
   private String inpService = "100";
   private List var_caisse_privee;
   private List var_caisse_publique;
   private List var_liste_groupe = new ArrayList();
   private CalculChrono calculChrono;
   private String var_compteEmetteur;
   private String var_nomBanqueEmetteur;
   private String var_nomBanquierEmetteur;
   private String var_adresseBanqueEmetteur;
   private String var_villeBanqueEmetteur;
   private String var_compteReceptteur;
   private String var_nomBanqueReceptteur;
   private String var_nomBanquierReceptteur;
   private String var_adresseBanqueReceptteur;
   private String var_villeBanqueReceptteur;
   private String var_fonctionResponsable;
   private String var_nom_createur;
   private transient DataModel datamodelVirement = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List lesVirementInternes = new ArrayList();
   private VirementInterneDao virementInterneDao;
   private VirementInterne virementInterne;
   private boolean visibiliteBton = false;
   private List listCaisses;
   private List listCaissesAutorisees = new ArrayList();
   private List listRecusAutorises = new ArrayList();
   private List mesCaissesExecutriceItems = new ArrayList();
   private String inpCaisse = "100";
   private String inputBanqEmetteur;
   private String inputBanqRecepteur;
   private List mesTypeTiers = new ArrayList();
   private boolean var_affiche_beneficiaire = false;
   private boolean var_affiche_banque = false;
   private boolean var_affiche_valide = false;
   private String var_modeReglement;
   private String inputTypReglment;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private boolean champCltVide = false;
   private boolean var_acc_descriptif = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean visibleOnglet = false;
   private boolean var_verrouCaisseExecutrice = false;
   private FormAnalytique formAnalytique;
   private List mesSecteursItems = new ArrayList();
   private List mesPdvItems = new ArrayList();
   private List mesDepartementsItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private boolean var_site;
   private boolean var_departement;
   private boolean var_service;
   private boolean var_region;
   private boolean var_secteur;
   private boolean var_pdv;
   private boolean var_activite;
   private boolean var_dossier;
   private boolean var_parc;
   private boolean var_cle;
   private boolean var_budget;
   private boolean decoupageActivite = false;
   private List laColonne1Items = new ArrayList();
   private List laColonne2Items = new ArrayList();
   private List laColonne3Items = new ArrayList();
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private EcrituresAnalytiqueCtrl ecrituresAnalytiqueCtrl;
   private List lesDecoupagesActivites = new ArrayList();
   private transient DataModel dataModelDecoupageActivtes = new ListDataModel();
   private double totalImputation;
   private double soldeImputation;
   private String requete;
   private String filtre;
   private String format = "PDF";
   private int var_choix_modele = 0;
   private String nomModeleDocument;
   private String nomModeleListe;
   private String nomRepMod;
   private boolean visibleOptionMail = false;
   private List mesModesleRecus = new ArrayList();
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private boolean affListeDoc = false;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private boolean showModalPanelPrint = false;
   private Habilitation habilitation;
   private UtilParapheur utilParapheur;
   private ParapheurDao parapheurDao;
   private Parapheur parapheur;
   private boolean projetActif;
   private List lesPostesBudgetaires = new ArrayList();

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.virementInterneDao = new VirementInterneDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
   }

   public void configCaisses(Session var1) throws HibernateException, NamingException {
      this.visibiliteBton = false;
      boolean var2 = false;
      boolean var3 = false;
      boolean var4 = false;
      this.mesTypeTiers = new ArrayList();
      boolean var5 = false;
      Object var6 = null;
      if (this.optionCaisses.getNbLigneMax() != null && !this.optionCaisses.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionCaisses.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.typeVente == 815) {
         var2 = true;
      } else {
         var2 = false;
      }

      var5 = false;
      var6 = var1.createQuery("SELECT COUNT(*) FROM ExercicesPaye").uniqueResult();
      int var10 = Integer.parseInt(var6.toString());
      if (var10 > 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var2) {
         this.mesTypeTiers.add(new SelectItem("4", "Patient"));
         this.mesTypeTiers.add(new SelectItem("1", "Fournisseur"));
         if (var4) {
            this.mesTypeTiers.add(new SelectItem("2", "Agent"));
         }

         this.mesTypeTiers.add(new SelectItem("3", "Plan comptable"));
      } else if (var3) {
         this.mesTypeTiers.add(new SelectItem("5", "Elève"));
         this.mesTypeTiers.add(new SelectItem("1", "Fournisseur"));
         if (var4) {
            this.mesTypeTiers.add(new SelectItem("2", "Agent"));
         }

         this.mesTypeTiers.add(new SelectItem("3", "Plan comptable"));
      } else {
         this.mesTypeTiers.add(new SelectItem("0", "Client"));
         this.mesTypeTiers.add(new SelectItem("1", "Fournisseur"));
         if (var4) {
            this.mesTypeTiers.add(new SelectItem("2", "Agent"));
         }

         this.mesTypeTiers.add(new SelectItem("3", "Plan comptable"));
      }

      this.inpEtat = 0;
      if (this.optionCaisses.getAxeSite().equals("true")) {
         this.var_site = true;
         this.var_departement = true;
         this.var_service = true;
      }

      if (this.optionCaisses.getAxeRegion().equals("true")) {
         this.var_region = true;
         this.var_secteur = true;
         this.var_pdv = true;
      }

      if (this.optionCaisses.getAxeActivite().equals("true")) {
         this.var_activite = true;
      } else {
         this.var_activite = false;
      }

      if (this.optionCaisses.getAxeParc().equals("true")) {
         this.var_parc = true;
      } else {
         this.var_parc = false;
      }

      if (this.optionCaisses.getAxeCles().equals("true")) {
         this.var_cle = true;
      } else {
         this.var_cle = false;
      }

      if (!this.optionCaisses.getAxeSite().equals("1") && !this.optionCaisses.getAxeSite().equals("2")) {
         this.var_dossier = false;
      } else {
         this.var_dossier = true;
      }

      this.var_budget = false;
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         this.decoupageActivite = true;
      } else {
         this.decoupageActivite = false;
      }

      this.formAnalytique = new FormAnalytique(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      this.var_caisse_privee = new ArrayList();
      this.var_caisse_publique = new ArrayList();
      new ArrayList();
      CaissesCommercialesDao var8 = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      List var7 = var8.selectActifCaisse(this.selectedExo.getExecaiId(), var1);
      int var9;
      if (var7.size() != 0) {
         for(var9 = 0; var9 < var7.size(); ++var9) {
            if (((CaissesCommerciales)var7.get(var9)).getCaiPrive() == 0) {
               this.var_caisse_publique.add(((CaissesCommerciales)var7.get(var9)).getCaiCode());
            } else if (((CaissesCommerciales)var7.get(var9)).getCaiPrive() == 1) {
               this.var_caisse_privee.add(((CaissesCommerciales)var7.get(var9)).getCaiCode());
            }
         }
      }

      this.var_caisse_publique.add("");
      this.var_caisse_publique.add((Object)null);
      this.projetActif = false;
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty() && this.structureLog.getStrmod1().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty() && this.structureLog.getStrmod2().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty() && this.structureLog.getStrmod3().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty() && this.structureLog.getStrmod4().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty() && this.structureLog.getStrmod5().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty() && this.structureLog.getStrmod6().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty() && this.structureLog.getStrmod7().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty() && this.structureLog.getStrmod8().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().isEmpty() && this.structureLog.getStrmod9().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty() && this.structureLog.getStrmod10().equals("40300")) {
         this.projetActif = true;
      }

      this.listCaissesAutorisees.clear();
      this.listRecusAutorises.clear();
      if (this.listCaisses.size() != 0) {
         for(var9 = 0; var9 < this.listCaisses.size(); ++var9) {
            if (((UsersChrono)this.listCaisses.get(var9)).getUsrchrCodeCaisse() != null && !((UsersChrono)this.listCaisses.get(var9)).getUsrchrCodeCaisse().isEmpty()) {
               if (((UsersChrono)this.listCaisses.get(var9)).getUsrchrNature() == 60) {
                  this.listCaissesAutorisees.add(((UsersChrono)this.listCaisses.get(var9)).getUsrchrCodeCaisse());
               } else if (((UsersChrono)this.listCaisses.get(var9)).getUsrchrNature() == 61) {
                  this.listRecusAutorises.add(((UsersChrono)this.listCaisses.get(var9)).getUsrchrCodeCaisse());
               }
            }
         }

         for(var9 = 0; var9 < this.listCaisses.size(); ++var9) {
            if (((UsersChrono)this.listCaisses.get(var9)).getUsrchrNature() == 60 && ((UsersChrono)this.listCaisses.get(var9)).getUsrchrCodeCaisse() != null && !((UsersChrono)this.listCaisses.get(var9)).getUsrchrCodeCaisse().isEmpty()) {
               this.mesCaissesExecutriceItems.add(new SelectItem(((UsersChrono)this.listCaisses.get(var9)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var9)).getUsrchrLib()));
            }
         }

         if (this.mesCaissesExecutriceItems.size() != 0) {
            this.inpCaisse = ((SelectItem)this.mesCaissesExecutriceItems.get(0)).getValue().toString();
         } else {
            this.inpCaisse = "100";
         }
      }

   }

   public void recupererMoisEnCours(Session var1) throws NamingException, ParseException {
      this.dateDebut = this.utilDate.datePremierJourMois(new Date());
      this.dateFin = this.utilDate.dateDernierJourMois(new Date());
      this.chargerFind(var1);
   }

   public void calculerLesDecoupagesActivites(Session var1) throws HibernateException, NamingException {
      if (this.decoupageActivite) {
         ActivitesDao var2 = new ActivitesDao(this.baseLog, this.utilInitHibernate);
         if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
            this.laColonne1Items = var2.chargerLesDecoupages(this.structureLog.getStrCode1(), var1);
         }

         if (this.structureLog.getStrCode2() != null && !this.structureLog.getStrCode2().isEmpty()) {
            this.laColonne2Items = var2.chargerLesDecoupages(this.structureLog.getStrCode2(), var1);
         }

         if (this.structureLog.getStrCode3() != null && !this.structureLog.getStrCode3().isEmpty()) {
            this.laColonne3Items = var2.chargerLesDecoupages(this.structureLog.getStrCode3(), var1);
         }
      }

   }

   public void accesResteintUser() {
      this.var_liste_groupe.clear();
      if (this.usersLog.getUsrRecus() == 2 && this.usersLog.getGroupe().getGrpLie() != null && !this.usersLog.getGroupe().getGrpLie().isEmpty()) {
         if (this.usersLog.getGroupe().getGrpLie().contains(",")) {
            this.var_liste_groupe.add(this.usersLog.getUsrCollaboration());
            String[] var1 = this.usersLog.getGroupe().getGrpLie().split(",");

            for(int var2 = 0; var2 < var1.length; ++var2) {
               this.var_liste_groupe.add(var1[var2]);
            }
         } else {
            this.var_liste_groupe.add(this.usersLog.getUsrCollaboration());
            this.var_liste_groupe.add(this.usersLog.getGroupe().getGrpLie());
         }
      }

   }

   public void accesResteintGroupe() {
   }

   public void calculeNomRep() {
      if (this.virementInterne.getVirTypeReg() != 0 && this.virementInterne.getVirTypeReg() != 11) {
         if (this.virementInterne.getVirTypeReg() != 1 && this.virementInterne.getVirTypeReg() != 10) {
            if (this.virementInterne.getVirTypeReg() == 2) {
               this.nomRepMod = "virements";
            } else if (this.virementInterne.getVirTypeReg() == 3) {
               this.nomRepMod = "traites";
            } else if (this.virementInterne.getVirTypeReg() == 4) {
               this.nomRepMod = "cartes";
            } else if (this.virementInterne.getVirTypeReg() == 5) {
               this.nomRepMod = "transferts";
            } else if (this.virementInterne.getVirTypeReg() == 6) {
               this.nomRepMod = "epaiements";
            } else if (this.virementInterne.getVirTypeReg() == 7) {
               this.nomRepMod = "credocs";
            } else if (this.virementInterne.getVirTypeReg() == 8) {
               this.nomRepMod = "factors";
            } else if (this.virementInterne.getVirTypeReg() == 9) {
               this.nomRepMod = "compenses";
            } else if (this.virementInterne.getVirTypeReg() == 12) {
               this.nomRepMod = "lettres_garantie";
            } else if (this.virementInterne.getVirTypeReg() == 13) {
               this.nomRepMod = "prelevements";
            } else if (this.virementInterne.getVirTypeReg() == 14) {
               this.nomRepMod = "alcoins";
            } else {
               this.nomRepMod = "";
            }
         } else {
            this.nomRepMod = "cheques";
         }
      } else {
         this.nomRepMod = "especes";
      }

      this.chargerModeleDocument();
   }

   public void chargerModeleDocument() {
      this.mesModesleRecus = new ArrayList();
      if (this.nomRepMod != null && !this.nomRepMod.isEmpty()) {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "bonsVirementRecu" + File.separator + this.nomRepMod;
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
                  this.mesModesleRecus.add(new SelectItem(var5));
               }
            }
         }
      }

   }

   public void razListe() {
      this.visibiliteBton = false;
      this.lesVirementInternes.clear();
      this.datamodelVirement.setWrappedData(this.lesVirementInternes);
   }

   public void chargerSecteur() throws HibernateException, NamingException {
      this.mesSecteursItems.clear();
      this.mesPdvItems.clear();
      if (this.virementInterne.getVirRegion() != null && !this.virementInterne.getVirRegion().isEmpty() && this.virementInterne.getVirRegion().contains(":")) {
         new ArrayList();
         String[] var2 = this.virementInterne.getVirRegion().split(":");
         new Region();
         RegionDao var4 = new RegionDao(this.baseLog, this.utilInitHibernate);
         Region var3 = var4.rechercheRegion(var2[0], (Session)null);
         if (var3 != null) {
            SecteurDao var5 = new SecteurDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listSecteurByRegion((Region)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesSecteursItems.add(new SelectItem(((Secteur)var1.get(var6)).getSecCode() + ":" + ((Secteur)var1.get(var6)).getSecNomFr()));
               }
            }
         }
      }

   }

   public void chargerPdv() throws HibernateException, NamingException {
      this.mesPdvItems.clear();
      if (this.virementInterne.getVirSecteur() != null && !this.virementInterne.getVirSecteur().isEmpty() && this.virementInterne.getVirSecteur().contains(":")) {
         new ArrayList();
         String[] var2 = this.virementInterne.getVirSecteur().split(":");
         new Secteur();
         SecteurDao var4 = new SecteurDao(this.baseLog, this.utilInitHibernate);
         Secteur var3 = var4.rechercheSecteur(var2[0], (Session)null);
         if (var3 != null) {
            PointDeVenteDao var5 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listPdvBySecteur((Secteur)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesPdvItems.add(new SelectItem(((PointDeVente)var1.get(var6)).getPdvCode() + ":" + ((PointDeVente)var1.get(var6)).getPdvNomFr()));
               }
            }
         }
      }

   }

   public void chargerDepartement() throws HibernateException, NamingException {
      this.mesDepartementsItems.clear();
      this.mesServicesItems.clear();
      if (this.virementInterne.getVirSite() != null && !this.virementInterne.getVirSite().isEmpty() && this.virementInterne.getVirSite().contains(":")) {
         new ArrayList();
         String[] var2 = this.virementInterne.getVirSite().split(":");
         new Site();
         SiteDao var4 = new SiteDao(this.baseLog, this.utilInitHibernate);
         Site var3 = var4.rechercheSite(var2[0], (Session)null);
         if (var3 != null) {
            DepartementDao var5 = new DepartementDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listDepartementBySit((Site)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesDepartementsItems.add(new SelectItem(((Departement)var1.get(var6)).getDepCode() + ":" + ((Departement)var1.get(var6)).getDepNomFr()));
               }
            }
         }
      }

   }

   public void chargerService() throws HibernateException, NamingException {
      this.mesServicesItems.clear();
      if (this.virementInterne.getVirDepartement() != null && !this.virementInterne.getVirDepartement().isEmpty() && this.virementInterne.getVirDepartement().contains(":")) {
         new ArrayList();
         String[] var2 = this.virementInterne.getVirDepartement().split(":");
         new Departement();
         DepartementDao var4 = new DepartementDao(this.baseLog, this.utilInitHibernate);
         Departement var3 = var4.rechercheDepartement(var2[0], (Session)null);
         if (var3 != null) {
            ServiceDao var5 = new ServiceDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listServiceByDep((Departement)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesServicesItems.add(new SelectItem(((Service)var1.get(var6)).getSerCode() + ":" + ((Service)var1.get(var6)).getSerNomFr()));
               }
            }
         }
      }

   }

   public void chargerFind(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesVirementInternes.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      String var2 = "";
      if (this.dateDebut.getDate() <= 9) {
         var2 = "0" + this.dateDebut.getDate();
      } else {
         var2 = "" + this.dateDebut.getDate();
      }

      String var3 = "";
      if (this.dateDebut.getMonth() + 1 <= 9) {
         var3 = "0" + (this.dateDebut.getMonth() + 1);
      } else {
         var3 = "" + (this.dateDebut.getMonth() + 1);
      }

      String var4 = "" + (this.dateDebut.getYear() + 1900);
      String var5 = var4 + "-" + var3 + "-" + var2;
      String var6 = "";
      if (this.dateFin.getDate() <= 9) {
         var6 = "0" + this.dateFin.getDate();
      } else {
         var6 = "" + this.dateFin.getDate();
      }

      String var7 = "";
      if (this.dateFin.getMonth() + 1 <= 9) {
         var7 = "0" + (this.dateFin.getMonth() + 1);
      } else {
         var7 = "" + (this.dateFin.getMonth() + 1);
      }

      String var8 = "" + (this.dateFin.getYear() + 1900);
      String var9 = var8 + "-" + var7 + "-" + var6;
      this.lesVirementInternes = this.virementInterneDao.selectFind(this.inpEtat, 100, this.inpService, this.listCaissesAutorisees, "100", var5, var9, this.usersLog.getUsrRecus(), this.usersLog.getUsrid(), this.usersLog.getUsrJrxReserve(), this.var_caisse_publique, this.var_liste_groupe, var1);
      this.datamodelVirement.setWrappedData(this.lesVirementInternes);
      this.virementInterne = new VirementInterne();
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
            this.virementInterne = (VirementInterne)var1.get(0);
            this.virementInterne = (VirementInterne)this.datamodelVirement.getRowData();
            this.userResponsable = this.virementInterne.getVirIdResponsable();
            if (this.virementInterne.getVirCodeCaiss() != null && !this.virementInterne.getVirCodeCaiss().isEmpty()) {
               this.inpCaisse = this.virementInterne.getVirCodeCaiss() + ":" + this.virementInterne.getVirLibCaiss();
            } else {
               this.inpCaisse = "";
            }

            if (this.virementInterne.getVirCodEmetrice() != null && !this.virementInterne.getVirCodEmetrice().isEmpty()) {
               this.inputBanqEmetteur = this.virementInterne.getVirCodEmetrice() + ":" + this.virementInterne.getVirNomEmetrice();
               this.var_affiche_banque = true;
            } else {
               this.inputBanqEmetteur = "";
               this.var_affiche_banque = false;
            }

            if (this.virementInterne.getVirCodReceptrice() != null && !this.virementInterne.getVirCodReceptrice().isEmpty()) {
               this.inputBanqRecepteur = this.virementInterne.getVirCodReceptrice() + ":" + this.virementInterne.getVirNomReceptrice();
               this.var_affiche_banque = true;
            } else {
               this.inputBanqRecepteur = "";
               this.var_affiche_banque = false;
            }

            this.var_affiche_banque = false;
            if (this.virementInterne.getVirTypeReg() != 0) {
               if (this.virementInterne.getVirTypeReg() == 1) {
                  this.var_affiche_banque = true;
               } else if (this.virementInterne.getVirTypeReg() == 2) {
                  this.var_affiche_banque = true;
               } else if (this.virementInterne.getVirTypeReg() == 3) {
                  this.var_affiche_banque = true;
               } else if (this.virementInterne.getVirTypeReg() == 4) {
                  this.var_affiche_banque = true;
               } else if (this.virementInterne.getVirTypeReg() == 5) {
                  this.var_affiche_banque = true;
               } else if (this.virementInterne.getVirTypeReg() != 6 && this.virementInterne.getVirTypeReg() != 7 && this.virementInterne.getVirTypeReg() == 8) {
               }
            }

            this.calculeNomRep();
            this.chargerUserChrono((Session)null);
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.virementInterne != null) {
         if (this.virementInterne.getVirEtat() == 0) {
            this.modifierVirement();
         } else {
            this.consulterVirement();
         }
      }

   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.virementInterne != null && this.virementInterne.getVirSerie() != null && !this.virementInterne.getVirSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.virementInterne.getVirSerie(), this.nature, this.usersLog, var1);
      }

      this.nomCreateur = "";
      this.nomModificateur = "";
      Users var2;
      if (this.virementInterne.getVirUserCreat() != 0L) {
         new Users();
         var2 = this.userDao.selectByIdUsers(this.virementInterne.getVirUserCreat(), var1);
         if (var2 != null) {
            this.nomCreateur = var2.getUsrPatronyme();
         }
      }

      if (this.virementInterne.getVirUserModif() != 0L) {
         new Users();
         var2 = this.userDao.selectByIdUsers(this.virementInterne.getVirUserModif(), var1);
         if (var2 != null) {
            this.nomModificateur = var2.getUsrPatronyme();
         }
      }

   }

   public void ajouterVirement() {
      this.nomCreateur = "";
      this.nomModificateur = "";
      this.virementInterne = new VirementInterne();
      this.virementInterne.setVirDate(new Date());
      this.virementInterne.setVirDateValeur(new Date());
      this.virementInterne.setVirNomResponsable(this.usersLog.getUsrPrenom() + " " + this.usersLog.getUsrNom());
      this.userResponsable = this.usersLog.getUsrid();
      this.virementInterne.setVirDevise(this.structureLog.getStrdevise());
      this.inpCaisse = "Sélection Caisse";
      this.virementInterne.setVirTypeReg(2);
      this.calculeNomRep();
      this.var_action = 1;
      this.var_memo_action = this.var_action;
      if (this.var_parc) {
         this.formAnalytique = new FormAnalytique(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
         this.formAnalytique.ongletAxe07();
         this.formAnalytique.utilisationAxe07();
      }

      this.lesDecoupagesActivites.clear();
      this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
      this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void modifierVirement() throws HibernateException, NamingException {
      if (this.virementInterne != null) {
         this.parapheur = new Parapheur();
         this.parapheur = this.parapheurDao.existenceParapheur(this.virementInterne.getVirId(), this.nature, (Session)null);
         if (this.parapheur == null || this.parapheur != null && this.parapheur.getPhrEtat() != 0) {
            this.var_affiche_valide = true;
            this.var_action = 2;
            this.var_memo_action = this.var_action;
         }
      }

   }

   public void consulterVirement() {
      if (this.virementInterne != null) {
         this.var_affiche_valide = false;
         this.var_action = 3;
         this.var_memo_action = this.var_action;
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "VirementInterne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.virementInterne.getVirEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
            this.virementInterne.setVirEtat(1);
            this.virementInterne = this.virementInterneDao.modif(this.virementInterne, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Validation manuelle virement (T.) N° " + this.virementInterne.getVirNum() + " du " + this.utilDate.dateToStringSQLLight(this.virementInterne.getVirDate()));
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

   public void deValideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "VirementInterne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.virementInterne.getVirEtat() == 1 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
            this.virementInterne.setVirEtat(0);
            this.virementInterne = this.virementInterneDao.modif(this.virementInterne, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Dévalidation manuelle virement (T.) N° " + this.virementInterne.getVirNum() + " du " + this.utilDate.dateToStringSQLLight(this.virementInterne.getVirDate()));
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

   public void supprimerVirement() throws HibernateException, NamingException {
      if (this.virementInterne != null) {
         this.parapheur = new Parapheur();
         this.parapheur = this.parapheurDao.existenceParapheur(this.virementInterne.getVirId(), this.nature, (Session)null);
         if (this.parapheur == null || this.parapheur != null && this.parapheur.getPhrEtat() != 0) {
            this.lesVirementInternes.remove(this.virementInterne);
            this.datamodelVirement.setWrappedData(this.lesVirementInternes);
            this.virementInterneDao.delete(this.virementInterne);
         }
      }

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void annuleSaisie() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.virementInterne.setVirEtatVal(1);
         this.virementInterne.setVirEtat(0);
         this.virementInterne.setVirDateValide((Date)null);
         return true;
      } else {
         this.virementInterne.setVirEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.virementInterne.setVirEtat(1);
               this.virementInterne.setVirDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.virementInterne.setVirEtat(0);
               this.virementInterne.setVirDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void saveVirement() throws HibernateException, NamingException, IOException, Exception {
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "VirementInterne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.userResponsable != 0L) {
            new Users();
            Users var3 = this.userDao.selectLeUserId(this.userResponsable, var1);
            if (var3 != null) {
               this.virementInterne.setVirIdResponsable(var3.getUsrid());
               this.virementInterne.setVirNomResponsable(var3.getUsrPatronyme());
            } else {
               this.virementInterne.setVirIdResponsable(0L);
               this.virementInterne.setVirNomResponsable("");
            }
         } else {
            this.virementInterne.setVirIdResponsable(0L);
            this.virementInterne.setVirNomResponsable("");
         }

         String[] var9;
         if (this.inpCaisse != null && !this.inpCaisse.isEmpty() && this.inpCaisse.contains(":")) {
            var9 = this.inpCaisse.split(":");
            this.virementInterne.setVirCodeCaiss(var9[0]);
            this.virementInterne.setVirLibCaiss(var9[1]);
         } else {
            this.virementInterne.setVirCodeCaiss((String)null);
            this.virementInterne.setVirLibCaiss((String)null);
         }

         if (this.inputBanqEmetteur != null && !this.inputBanqEmetteur.isEmpty() && this.inputBanqEmetteur.contains(":")) {
            var9 = this.inputBanqEmetteur.split(":");
            this.virementInterne.setVirCodEmetrice(var9[0]);
            this.virementInterne.setVirNomEmetrice(var9[1]);
         } else {
            this.virementInterne.setVirCodEmetrice((String)null);
            this.virementInterne.setVirNomEmetrice((String)null);
         }

         if (this.inputBanqRecepteur != null && !this.inputBanqRecepteur.isEmpty() && this.inputBanqRecepteur.contains(":")) {
            var9 = this.inputBanqRecepteur.split(":");
            this.virementInterne.setVirCodReceptrice(var9[0]);
            this.virementInterne.setVirNomReceptrice(var9[1]);
         } else {
            this.virementInterne.setVirCodReceptrice((String)null);
            this.virementInterne.setVirNomReceptrice((String)null);
         }

         this.virementInterne.setVirTypeReg(2);
         if (this.virementInterne.getVirSite() != null && this.virementInterne.getVirSite().contains("0")) {
            this.virementInterne.setVirSite("");
         }

         if (this.virementInterne.getVirDepartement() != null && this.virementInterne.getVirDepartement().contains("0")) {
            this.virementInterne.setVirDepartement("");
         }

         if (this.virementInterne.getVirService() != null && this.virementInterne.getVirService().contains("0")) {
            this.virementInterne.setVirService("");
         }

         if (this.virementInterne.getVirRegion() != null && this.virementInterne.getVirRegion().contains("0")) {
            this.virementInterne.setVirRegion("");
         }

         if (this.virementInterne.getVirSecteur() != null && this.virementInterne.getVirSecteur().contains("0")) {
            this.virementInterne.setVirSecteur("");
         }

         if (this.virementInterne.getVirPdv() != null && this.virementInterne.getVirPdv().contains("0")) {
            this.virementInterne.setVirPdv("");
         }

         if (this.virementInterne.getVirActivite() != null && this.virementInterne.getVirActivite().contains("0")) {
            this.virementInterne.setVirActivite("");
         }

         if (this.virementInterne.getVirDossier() != null && this.virementInterne.getVirDossier().contains("0")) {
            this.virementInterne.setVirDossier("");
         }

         if (this.formAnalytique != null && this.var_parc) {
            this.virementInterne.setVirParc(this.formAnalytique.calculeValeurListe07());
         } else {
            this.virementInterne.setVirParc("");
         }

         if (this.virementInterne.getVirBudget() != null && this.virementInterne.getVirBudget().contains("0")) {
            this.virementInterne.setVirBudget("");
         }

         this.virementInterne.setVirGrp(this.usersLog.getUsrCollaboration());
         String var10;
         if (this.virementInterne.getVirId() == 0L) {
            this.virementInterne.setExercicesCaisse(this.selectedExo);
            this.virementInterne.setVirNature(this.nature);
            var10 = this.calculChrono.numCompose(this.virementInterne.getVirDate(), this.nature, this.virementInterne.getVirSerie(), var1);
            this.virementInterne.setVirNum(var10);
            this.virementInterne.setVirCle(this.virementInterne.getVirNum() + ":" + this.virementInterne.getVirNature());
            this.virementInterne.setVirDateCreat(new Date());
            this.virementInterne.setVirUserCreat(this.usersLog.getUsrid());
            this.virementInterne = this.virementInterneDao.insert(this.virementInterne, var1);
            this.lesVirementInternes.add(this.virementInterne);
            this.datamodelVirement.setWrappedData(this.lesVirementInternes);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.virementInterne.setVirDateModif(new Date());
            this.virementInterne.setVirUserModif(this.usersLog.getUsrid());
            this.virementInterne = this.virementInterneDao.modif(this.virementInterne, var1);
         }

         if (this.habilitation != null && this.virementInterne.getVirMontant() > 0.0D) {
            var10 = this.utilNombre.begin(this.virementInterne.getVirMontant(), this.virementInterne.getVirDevise());
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.virementInterne.getVirId(), this.virementInterne.getVirNum(), this.virementInterne.getVirNomResponsable(), this.virementInterne.getVirDate(), this.virementInterne.getVirDevise(), this.virementInterne.getVirMontant(), this.virementInterne.getVirModeleImp(), (Tiers)null, this.calculeCheminRapport(this.baseLog, this.nomRepMod), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.structureLog.getStrformatdevise(), 0, var1);
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

      this.initImpression();
      this.var_action = 0;
   }

   public void chargerFind() throws HibernateException, NamingException, ParseException {
      this.chargerFind((Session)null);
   }

   public void choixCaisse() {
      if (this.virementInterne.getVirTypeReg() != 1 && this.virementInterne.getVirTypeReg() != 2 && this.virementInterne.getVirTypeReg() != 3 && this.virementInterne.getVirTypeReg() != 4 && this.virementInterne.getVirTypeReg() != 6 && this.virementInterne.getVirTypeReg() != 7) {
         this.var_affiche_banque = false;
         this.nomRepMod = "";
      } else {
         this.var_affiche_banque = true;
      }

      this.calculeNomRep();
   }

   public void choisirMontant() {
      if (this.virementInterne.getVirMontant() > 0.0D) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

   }

   public void choixBanqEmetteur() {
      if (this.inputBanqEmetteur != null && !this.inputBanqEmetteur.isEmpty() && this.inputBanqEmetteur.contains(":")) {
         String[] var1 = this.inputBanqEmetteur.split(":");
         this.virementInterne.setVirCodEmetrice(var1[0]);
         this.virementInterne.setVirNomEmetrice(var1[1]);
      } else {
         this.virementInterne.setVirCodEmetrice("");
         this.virementInterne.setVirNomEmetrice("");
      }

   }

   public void choixBanqRecepteur() {
      if (this.inputBanqRecepteur != null && !this.inputBanqRecepteur.isEmpty() && this.inputBanqRecepteur.contains(":")) {
         String[] var1 = this.inputBanqRecepteur.split(":");
         this.virementInterne.setVirCodReceptrice(var1[0]);
         this.virementInterne.setVirNomReceptrice(var1[1]);
      } else {
         this.virementInterne.setVirCodReceptrice("");
         this.virementInterne.setVirNomReceptrice("");
      }

   }

   public void verifEmetteur() throws HibernateException, NamingException {
      if (this.inputBanqEmetteur.contains(":")) {
         this.var_verrouCaisseExecutrice = false;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
         String[] var2 = this.inputBanqEmetteur.split(":");
         new JournauxComptables();
         JournauxComptablesDao var4 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
         JournauxComptables var3 = var4.chercherCode(var2[0], this.exercicesComptable.getExecpt_id(), var1);
         if (var3 != null && (var3.getPljNature() == 9 || var3.getPljNature() == 10)) {
            boolean var5 = false;
            String var6 = "";
            new ArrayList();
            CaissesCommercialesDao var8 = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
            List var7 = var8.selectActifCaisse(this.usersLog.getUsrJrxReserve(), var1);
            if (var7.size() != 0) {
               for(int var9 = 0; var9 < var7.size(); ++var9) {
                  if (((CaissesCommerciales)var7.get(var9)).getCaiCode().equals(var3.getPljCode())) {
                     var6 = ((CaissesCommerciales)var7.get(var9)).getCaiCode() + ":" + ((CaissesCommerciales)var7.get(var9)).getCaiNom();
                     var5 = true;
                     break;
                  }
               }
            }

            if (var5) {
               this.inpCaisse = var6;
               this.var_verrouCaisseExecutrice = true;
            }
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void verifRecepteur() throws HibernateException, NamingException {
      if (!this.var_verrouCaisseExecutrice && this.inputBanqRecepteur.contains(":")) {
         this.var_verrouCaisseExecutrice = false;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
         String[] var2 = this.inputBanqRecepteur.split(":");
         new JournauxComptables();
         JournauxComptablesDao var4 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
         JournauxComptables var3 = var4.chercherCode(var2[0], this.exercicesComptable.getExecpt_id(), var1);
         if (var3 != null && (var3.getPljNature() == 9 || var3.getPljNature() == 10)) {
            boolean var5 = false;
            String var6 = "";
            new ArrayList();
            CaissesCommercialesDao var8 = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
            List var7 = var8.selectActifCaisse(this.usersLog.getUsrJrxReserve(), var1);
            if (var7.size() != 0) {
               for(int var9 = 0; var9 < var7.size(); ++var9) {
                  if (((CaissesCommerciales)var7.get(var9)).getCaiCode().equals(var3.getPljCode())) {
                     var6 = ((CaissesCommerciales)var7.get(var9)).getCaiCode() + ":" + ((CaissesCommerciales)var7.get(var9)).getCaiNom();
                     var5 = true;
                     break;
                  }
               }
            }

            if (var5) {
               this.inpCaisse = var6;
               this.var_verrouCaisseExecutrice = true;
            }
         }

         this.utilInitHibernate.closeSession();
      }

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
         double var1 = this.utilNombre.myRoundDevise(this.virementInterne.getVirMontant() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
         this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(var1);
      }

   }

   public void controleEcartAnalytique() {
      if (this.lesDecoupagesActivites.size() != 0) {
         this.totalImputation = 0.0D;
         this.soldeImputation = 0.0D;

         for(int var1 = 0; var1 < this.lesDecoupagesActivites.size(); ++var1) {
            this.totalImputation += ((EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var1)).getEcranaMontantSaisie();
         }

         this.soldeImputation = this.virementInterne.getVirMontant() - this.totalImputation;
         if (this.soldeImputation > 0.0D) {
            this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
            this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
         }
      }

   }

   public void calculeMontantImputationVrirement() {
      if (this.var_parc) {
         this.formAnalytique.fixeMontantImputVirement07(this.virementInterne.getVirMontant());
      }

   }

   public void initImpression() {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.calculeNomRep();
      this.var_choix_modele = 0;
      this.ListeDocImp();
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
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

   public void OptionMail() {
      if (this.format.equalsIgnoreCase("MAIL")) {
         this.visibleOptionMail = true;
      } else {
         this.visibleOptionMail = false;
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

   public void ListeDocImp() {
      if (this.var_choix_modele == 0) {
         this.affListeDoc = false;
      } else {
         this.affListeDoc = true;
      }

   }

   public String calculeCheminRapport(String var1, String var2) {
      String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "bonsVirementRecu" + File.separator + var2 + File.separator;
      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1, int var2) throws HibernateException, NamingException {
      String var3 = "";
      if (var2 == 0) {
         File var4 = new File(this.calculeCheminSousRapport(var1) + "formatEncours.jpg");
         if (var4.exists()) {
            var3 = "formatEncours.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      this.virementInterne.setVar_compteEmetteur(this.var_compteEmetteur);
      this.virementInterne.setVar_nomBanqueEmetteur(this.var_nomBanqueEmetteur);
      this.virementInterne.setVar_nomBanquierEmetteur(this.var_nomBanquierEmetteur);
      this.virementInterne.setVar_adresseBanqueEmetteur(this.var_adresseBanqueEmetteur);
      this.virementInterne.setVar_villeBanqueEmetteur(this.var_villeBanqueEmetteur);
      this.virementInterne.setVar_compteReceptteur(this.var_compteReceptteur);
      this.virementInterne.setVar_nomBanqueReceptteur(this.var_nomBanqueReceptteur);
      this.virementInterne.setVar_nomBanquierReceptteur(this.var_nomBanquierReceptteur);
      this.virementInterne.setVar_adresseBanqueReceptteur(this.var_adresseBanqueReceptteur);
      this.virementInterne.setVar_villeBanqueReceptteur(this.var_villeBanqueReceptteur);
      this.virementInterne.setVar_fonctionResponsable(this.var_fonctionResponsable);
      this.virementInterne.setVar_nom_createur(this.var_nom_createur);
      var1.add(this.virementInterne);
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      return var2;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      return var2;
   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "VirementInterne");
            this.var_compteEmetteur = "";
            this.var_nomBanqueEmetteur = "";
            this.var_nomBanquierEmetteur = "";
            this.var_adresseBanqueEmetteur = "";
            this.var_villeBanqueEmetteur = "";
            this.var_compteReceptteur = "";
            this.var_nomBanqueReceptteur = "";
            this.var_nomBanquierReceptteur = "";
            this.var_adresseBanqueReceptteur = "";
            this.var_villeBanqueReceptteur = "";
            this.var_fonctionResponsable = "";
            this.var_nom_createur = "";
            JournauxComptables var2;
            JournauxComptablesDao var3;
            Tiers var4;
            if (this.virementInterne.getVirCodEmetrice() != null && !this.virementInterne.getVirCodEmetrice().isEmpty() && this.exercicesComptable != null) {
               new JournauxComptables();
               var3 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
               var2 = var3.chercherCode(this.virementInterne.getVirCodEmetrice(), this.exercicesComptable.getExecpt_id(), var1);
               if (var2 != null) {
                  new Tiers();
                  var4 = this.tiersDao.selectTierSigle(var2.getPljCodeBanque(), var1);
                  if (var4 != null) {
                     this.var_compteEmetteur = var2.getPljCodeBanque() + " " + var2.getPljCodeGuichet() + " " + var2.getPljNumeroCompte() + " " + var2.getPljCleRib();
                     this.var_nomBanqueEmetteur = var4.getTieraisonsocialenom();
                     this.var_nomBanquierEmetteur = var2.getPljCiviliteGestionnaire() + " " + var2.getPljNomGestionnaire();
                     this.var_adresseBanqueEmetteur = var4.getTieadresse();
                     this.var_villeBanqueEmetteur = var4.getTieville();
                  }
               }
            }

            if (this.virementInterne.getVirCodReceptrice() != null && !this.virementInterne.getVirCodReceptrice().isEmpty() && this.exercicesComptable != null) {
               new JournauxComptables();
               var3 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
               var2 = var3.chercherCode(this.virementInterne.getVirCodReceptrice(), this.exercicesComptable.getExecpt_id(), var1);
               if (var2 != null) {
                  new Tiers();
                  var4 = this.tiersDao.selectTierSigle(var2.getPljCodeBanque(), var1);
                  if (var4 != null) {
                     this.var_compteReceptteur = var2.getPljCodeBanque() + " " + var2.getPljCodeGuichet() + " " + var2.getPljNumeroCompte() + " " + var2.getPljCleRib();
                     this.var_nomBanqueReceptteur = var4.getTieraisonsocialenom();
                     this.var_nomBanquierReceptteur = var2.getPljCiviliteGestionnaire() + " " + var2.getPljNomGestionnaire();
                     this.var_adresseBanqueReceptteur = var4.getTieadresse();
                     this.var_villeBanqueReceptteur = var4.getTieville();
                  }
               }
            }

            Users var11;
            if (this.virementInterne.getVirIdResponsable() != 0L) {
               new Users();
               var11 = this.userDao.selectLeUserId(this.virementInterne.getVirIdResponsable(), var1);
               if (var11 != null) {
                  this.var_fonctionResponsable = var11.getUsrFonction();
               }
            }

            if (this.virementInterne.getVirUserCreat() != 0L) {
               new Users();
               var11 = this.userDao.selectLeUserId(this.virementInterne.getVirUserCreat(), var1);
               if (var11 != null) {
                  this.var_nom_createur = var11.getUsrPatronyme();
               }
            }

            var2 = null;

            try {
               Transaction var12 = var1.beginTransaction();
               this.virementInterne.setVirDateImp(new Date());
               if (this.virementInterne.getVirEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 1) {
                  this.virementInterne.setVirEtat(1);
               }

               this.virementInterne.setVirModeleImp(this.nomModeleDocument);
               this.virementInterne = this.virementInterneDao.modif(this.virementInterne, var1);
               var12.commit();
            } catch (HibernateException var8) {
               if (var2 != null) {
                  var2.rollback();
               }

               throw var8;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            String var13 = this.utilNombre.begin(this.virementInterne.getVirMontant(), this.virementInterne.getVirDevise());
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setEntete("Impression du virement");
            this.utilPrint.setMontant_lettre(var13);
            this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nomRepMod));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.virementInterne.getVirEtat()));
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des virements");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator + "bons_virement_liste" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(this.nature);
         this.utilPrint.setId_doc(0L);
         JRBeanCollectionDataSource var10 = new JRBeanCollectionDataSource(this.lesVirementInternes);
         this.utilPrint.setjRBeanCollectionDataSource(var10);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

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

   public String getInpCaisse() {
      return this.inpCaisse;
   }

   public void setInpCaisse(String var1) {
      this.inpCaisse = var1;
   }

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
   }

   public String getInpService() {
      return this.inpService;
   }

   public void setInpService(String var1) {
      this.inpService = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
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

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
   }

   public boolean isVar_affiche_valide() {
      return this.var_affiche_valide;
   }

   public void setVar_affiche_valide(boolean var1) {
      this.var_affiche_valide = var1;
   }

   public boolean isChampCltVide() {
      return this.champCltVide;
   }

   public void setChampCltVide(boolean var1) {
      this.champCltVide = var1;
   }

   public String getInputTypReglment() {
      return this.inputTypReglment;
   }

   public void setInputTypReglment(String var1) {
      this.inputTypReglment = var1;
   }

   public String getInputBanqEmetteur() {
      return this.inputBanqEmetteur;
   }

   public void setInputBanqEmetteur(String var1) {
      this.inputBanqEmetteur = var1;
   }

   public String getInputBanqRecepteur() {
      return this.inputBanqRecepteur;
   }

   public void setInputBanqRecepteur(String var1) {
      this.inputBanqRecepteur = var1;
   }

   public ExercicesCaisse getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesCaisse var1) {
      this.lastExo = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public OptionCaisses getOptionCaisses() {
      return this.optionCaisses;
   }

   public void setOptionCaisses(OptionCaisses var1) {
      this.optionCaisses = var1;
   }

   public ExercicesCaisse getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesCaisse var1) {
      this.selectedExo = var1;
   }

   public boolean isVar_acc_descriptif() {
      return this.var_acc_descriptif;
   }

   public void setVar_acc_descriptif(boolean var1) {
      this.var_acc_descriptif = var1;
   }

   public boolean isVar_affiche_banque() {
      return this.var_affiche_banque;
   }

   public void setVar_affiche_banque(boolean var1) {
      this.var_affiche_banque = var1;
   }

   public boolean isVar_affiche_beneficiaire() {
      return this.var_affiche_beneficiaire;
   }

   public void setVar_affiche_beneficiaire(boolean var1) {
      this.var_affiche_beneficiaire = var1;
   }

   public List getMesModesleRecus() {
      return this.mesModesleRecus;
   }

   public void setMesModesleRecus(List var1) {
      this.mesModesleRecus = var1;
   }

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
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

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
   }

   public List getMesTypeTiers() {
      return this.mesTypeTiers;
   }

   public void setMesTypeTiers(List var1) {
      this.mesTypeTiers = var1;
   }

   public String getVar_modeReglement() {
      return this.var_modeReglement;
   }

   public void setVar_modeReglement(String var1) {
      this.var_modeReglement = var1;
   }

   public DataModel getDatamodelVirement() {
      return this.datamodelVirement;
   }

   public void setDatamodelVirement(DataModel var1) {
      this.datamodelVirement = var1;
   }

   public VirementInterne getVirementInterne() {
      return this.virementInterne;
   }

   public void setVirementInterne(VirementInterne var1) {
      this.virementInterne = var1;
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

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public String getNomRepMod() {
      return this.nomRepMod;
   }

   public void setNomRepMod(String var1) {
      this.nomRepMod = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public ExercicesComptable getExercicesComptable() {
      return this.exercicesComptable;
   }

   public void setExercicesComptable(ExercicesComptable var1) {
      this.exercicesComptable = var1;
   }

   public boolean isVar_verrouCaisseExecutrice() {
      return this.var_verrouCaisseExecutrice;
   }

   public void setVar_verrouCaisseExecutrice(boolean var1) {
      this.var_verrouCaisseExecutrice = var1;
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

   public List getMesDepartementsItems() {
      return this.mesDepartementsItems;
   }

   public void setMesDepartementsItems(List var1) {
      this.mesDepartementsItems = var1;
   }

   public List getMesPdvItems() {
      return this.mesPdvItems;
   }

   public void setMesPdvItems(List var1) {
      this.mesPdvItems = var1;
   }

   public List getMesSecteursItems() {
      return this.mesSecteursItems;
   }

   public void setMesSecteursItems(List var1) {
      this.mesSecteursItems = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public boolean isVar_activite() {
      return this.var_activite;
   }

   public void setVar_activite(boolean var1) {
      this.var_activite = var1;
   }

   public boolean isVar_budget() {
      return this.var_budget;
   }

   public void setVar_budget(boolean var1) {
      this.var_budget = var1;
   }

   public boolean isVar_departement() {
      return this.var_departement;
   }

   public void setVar_departement(boolean var1) {
      this.var_departement = var1;
   }

   public boolean isVar_dossier() {
      return this.var_dossier;
   }

   public void setVar_dossier(boolean var1) {
      this.var_dossier = var1;
   }

   public boolean isVar_parc() {
      return this.var_parc;
   }

   public void setVar_parc(boolean var1) {
      this.var_parc = var1;
   }

   public boolean isVar_pdv() {
      return this.var_pdv;
   }

   public void setVar_pdv(boolean var1) {
      this.var_pdv = var1;
   }

   public boolean isVar_region() {
      return this.var_region;
   }

   public void setVar_region(boolean var1) {
      this.var_region = var1;
   }

   public boolean isVar_secteur() {
      return this.var_secteur;
   }

   public void setVar_secteur(boolean var1) {
      this.var_secteur = var1;
   }

   public boolean isVar_service() {
      return this.var_service;
   }

   public void setVar_service(boolean var1) {
      this.var_service = var1;
   }

   public boolean isVar_site() {
      return this.var_site;
   }

   public void setVar_site(boolean var1) {
      this.var_site = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
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

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public long getUserResponsable() {
      return this.userResponsable;
   }

   public void setUserResponsable(long var1) {
      this.userResponsable = var1;
   }

   public boolean isProjetActif() {
      return this.projetActif;
   }

   public void setProjetActif(boolean var1) {
      this.projetActif = var1;
   }

   public List getLesPostesBudgetaires() {
      return this.lesPostesBudgetaires;
   }

   public void setLesPostesBudgetaires(List var1) {
      this.lesPostesBudgetaires = var1;
   }

   public boolean isVar_cle() {
      return this.var_cle;
   }

   public void setVar_cle(boolean var1) {
      this.var_cle = var1;
   }

   public List getListCaisses() {
      return this.listCaisses;
   }

   public void setListCaisses(List var1) {
      this.listCaisses = var1;
   }

   public List getMesCaissesExecutriceItems() {
      return this.mesCaissesExecutriceItems;
   }

   public void setMesCaissesExecutriceItems(List var1) {
      this.mesCaissesExecutriceItems = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
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

   public DataModel getDataModelDecoupageActivtes() {
      return this.dataModelDecoupageActivtes;
   }

   public void setDataModelDecoupageActivtes(DataModel var1) {
      this.dataModelDecoupageActivtes = var1;
   }

   public Parapheur getParapheur() {
      return this.parapheur;
   }

   public void setParapheur(Parapheur var1) {
      this.parapheur = var1;
   }

   public double getSoldeImputation() {
      return this.soldeImputation;
   }

   public void setSoldeImputation(double var1) {
      this.soldeImputation = var1;
   }

   public boolean isDecoupageActivite() {
      return this.decoupageActivite;
   }

   public void setDecoupageActivite(boolean var1) {
      this.decoupageActivite = var1;
   }

   public double getTotalImputation() {
      return this.totalImputation;
   }

   public void setTotalImputation(double var1) {
      this.totalImputation = var1;
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

   public String getNomCreateur() {
      return this.nomCreateur;
   }

   public void setNomCreateur(String var1) {
      this.nomCreateur = var1;
   }

   public String getNomModificateur() {
      return this.nomModificateur;
   }

   public void setNomModificateur(String var1) {
      this.nomModificateur = var1;
   }

   public FormAnalytique getFormAnalytique() {
      return this.formAnalytique;
   }

   public void setFormAnalytique(FormAnalytique var1) {
      this.formAnalytique = var1;
   }
}
