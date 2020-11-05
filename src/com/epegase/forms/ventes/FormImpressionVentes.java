package com.epegase.forms.ventes;

import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.BonEntreeEntete;
import com.epegase.systeme.classe.BonEntreeLigne;
import com.epegase.systeme.classe.BonSortieEntete;
import com.epegase.systeme.classe.BonSortieLigne;
import com.epegase.systeme.classe.CessionEntete;
import com.epegase.systeme.classe.CessionLigne;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.DevisLigneVentes;
import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.RetourEnteteVentes;
import com.epegase.systeme.classe.RetourLigneVentes;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BonEntreeEnteteDao;
import com.epegase.systeme.dao.BonEntreeLigneDao;
import com.epegase.systeme.dao.BonSortieEnteteDao;
import com.epegase.systeme.dao.BonSortieLigneDao;
import com.epegase.systeme.dao.CessionEnteteDao;
import com.epegase.systeme.dao.CessionLigneDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.LivraisonLivreeVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.RetourEnteteVentesDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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

public class FormImpressionVentes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private ExercicesVentes exoSelectionne;
   private OptionVentes optionVentes;
   private UtilDate utilDate;
   private List lesRepImpression = new ArrayList();
   private transient DataModel dataModelImpgen = new ListDataModel();
   private List lesFichImpression = new ArrayList();
   private transient DataModel dataModelImpgenFichier = new ListDataModel();
   private boolean testafficheLigne = false;
   private boolean testafficheDocument = false;
   private UsersChronoDao usersChronoDao;
   private int nature;
   private String nomRepertoire;
   private String nomEtat = "";
   private List listDocument;
   private List listReliquat;
   private List listReliquatCmd;
   private List listBCPaiementCash;
   private List listProduits;
   private String periode;
   private List mesPeriodesItems = new ArrayList();
   private Date filtreDateDebut;
   private Date filtreDateFin;
   private String nomTiers;
   private String nomSigle;
   private String nomDestinataire;
   private String nomGroupe;
   private String region;
   private String secteur;
   private String pdv;
   private String site;
   private String departement;
   private String service;
   private String produitDebut;
   private String produitFin;
   private String parc;
   private String activite;
   private String dossier;
   private String serie;
   private String etat;
   private String categorie;
   private String commercial;
   private String responsable;
   private String createur;
   private String source;
   private String famille;
   private String depot;
   private String marque;
   private String var_entete;
   private String var_filtre;
   private String var_requete;
   private boolean var_devis;
   private boolean var_bc;
   private boolean var_bl;
   private boolean var_br;
   private boolean var_facture;
   private boolean var_noteDebit;
   private boolean var_avoir;
   private boolean var_bs;
   private boolean var_be;
   private boolean var_cessionOut;
   private boolean var_cessionIn;
   private List mesGroupes = new ArrayList();
   private List mesSeriesItems = new ArrayList();
   private List mesEtatsItems = new ArrayList();
   private List mesSecteursItems = new ArrayList();
   private List mesPdvItems = new ArrayList();
   private List mesDepartementsItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private List mesMarquesItems = new ArrayList();
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier;
   private boolean var_anal_affaire;
   private boolean var_anal_parc = false;
   private boolean var_anal_site = false;
   private boolean var_anal_departement = false;
   private boolean var_anal_service = false;
   private boolean var_anal_region = false;
   private boolean var_anal_secteur = false;
   private boolean var_anal_pdv = false;
   private boolean var_anal_agent = false;
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private boolean var_affiche_impression = false;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private String impEmetteur;
   private boolean var_ctrl_imp = false;
   private boolean showModalPanelTiers;
   private transient DataModel datamodelTiers = new ListDataModel();
   private Tiers tiers;
   private boolean showModalPanelDestinataire;
   private transient DataModel datamodelDestinataire = new ListDataModel();
   private PlansAnalytiques plansAnalytiques;
   private boolean showModalPanelProduits;
   private transient DataModel datamodelProduits = new ListDataModel();
   private Produits produits;
   private boolean var_produit_choix = false;
   private boolean moduleParc = false;
   private boolean showModalPanelParc;
   private transient DataModel datamodelParc = new ListDataModel();
   private Parc parcObj;
   private String m0DteDeb;
   private String m0DteFin;
   private String m30DteDeb;
   private String m30DteFin;
   private String m60DteDeb;
   private String m60DteFin;
   private String m90DteDeb;
   private String m90DteFin;
   private String m120DteDeb;
   private LivraisonEnteteVentes livraisonEnteteVentes;
   private LivraisonLigneVentes livraisonLigneVentes;
   private LivraisonEnteteVentesDao livraisonEnteteVentesDao;
   private LivraisonLigneVentesDao livraisonLigneVentesDao;
   private CommandeLigneVentes commandeLigneVentes;
   private DocumentTraceVentes documentTraceVentes;
   private List lesTracabilites;
   private List lesLivraisons;
   private List lesLivraisonsTmp;
   private List lesTiers;
   private int nbJours = 0;
   private List lesModelesAutorises;
   private List lesLignesFacture;

   public FormImpressionVentes() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilDate = new UtilDate();
   }

   public void InstancesDaoUtilses() {
   }

   public void chargerLesRepImpVentes(Session var1) throws HibernateException, NamingException {
      this.lesRepImpression.clear();
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "client";
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      String[] var4 = var3.list();
      int var5;
      if (var4 != null) {
         var4 = this.triAlphabetique(var4, var4.length);

         for(var5 = 0; var5 < var4.length; ++var5) {
            if (!var4[var5].equalsIgnoreCase(".svn") && !var4[var5].equalsIgnoreCase("index.html")) {
               String var6 = "";
               var6 = var4[var5].toUpperCase();
               boolean var7 = this.calculeVisible(var6, var1);
               if (var7) {
                  this.lesRepImpression.add(var6);
               }
            }
         }
      }

      var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits";
      var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      var4 = var3.list();
      if (var4 != null) {
         var4 = this.triAlphabetique(var4, var4.length);

         for(var5 = 0; var5 < var4.length; ++var5) {
            if (!var4[var5].equalsIgnoreCase(".svn")) {
               this.nomRepertoire = "";
               this.nomRepertoire = var4[var5].toUpperCase();
               boolean var8 = this.calculeVisible(this.nomRepertoire, var1);
               if (var8) {
                  this.lesRepImpression.add(this.nomRepertoire);
               }
            }
         }
      }

      this.dataModelImpgen.setWrappedData(this.lesRepImpression);
      this.chargerGroupeDestinataire(var1);
      this.chargerMarquesParc(var1);
   }

   public boolean calculeVisible(String var1, Session var2) {
      boolean var3 = false;
      int var4 = 0;
      if (var1 != null && !var1.isEmpty()) {
         Object var5;
         if (var1.contains("_AVOIR")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM AvoirEnteteVentes").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (var1.contains("_BESOIN")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM BesoinEnteteVentes").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (var1.contains("_CAMPAGNE")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM CampagneEnteteVentes").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (var1.contains("_CHARGEMENT")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM ChargementEntete").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (!var1.contains("_COMMANDE") && !var1.contains("_BCAGEE")) {
            if (var1.contains("_DEVIS")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM DevisEnteteVentes").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (!var1.contains("_FACTURE") && !var1.contains("_BALANCEAGEE") && !var1.contains("_ECHEANCIER") && !var1.contains("COMMISSION")) {
               if (var1.contains("_LIVRAISON")) {
                  var5 = var2.createQuery("SELECT COUNT(*) FROM LivraisonEnteteVentes").uniqueResult();
                  var4 = Integer.parseInt(var5.toString());
               } else if (var1.contains("_NOTE_DE_DEBIT")) {
                  var5 = var2.createQuery("SELECT COUNT(*) FROM NoteDebitEnteteVentes").uniqueResult();
                  var4 = Integer.parseInt(var5.toString());
               } else if (var1.contains("_RETOUR")) {
                  var5 = var2.createQuery("SELECT COUNT(*) FROM RetourEnteteVentes").uniqueResult();
                  var4 = Integer.parseInt(var5.toString());
               } else if (var1.contains("_SIMULATION")) {
                  var5 = var2.createQuery("SELECT COUNT(*) FROM SimulationEnteteVentes").uniqueResult();
                  var4 = Integer.parseInt(var5.toString());
               } else if (var1.contains("_TICKET")) {
                  var5 = var2.createQuery("SELECT COUNT(*) FROM TicketEnteteVentes").uniqueResult();
                  var4 = Integer.parseInt(var5.toString());
               } else if (var1.contains("PRODUIT")) {
                  var4 = 1;
               } else if (var1.contains("_SYNTHESE") || var1.contains("COMPARATIF")) {
                  var4 = 1;
               }
            } else {
               var5 = var2.createQuery("SELECT COUNT(*) FROM FactureEnteteVentes").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            }
         } else {
            var5 = var2.createQuery("SELECT COUNT(*) FROM CommandeEnteteVentes").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         }
      }

      if (var4 != 0) {
         var3 = true;
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

   public void calculeAnalytique() {
      this.var_anal_activite = false;
      this.var_anal_site = false;
      this.var_anal_departement = false;
      this.var_anal_service = false;
      this.var_anal_region = false;
      this.var_anal_secteur = false;
      this.var_anal_pdv = false;
      this.var_anal_dossier = false;
      this.var_anal_affaire = false;
      this.var_anal_parc = false;
      this.var_anal_agent = false;
      if (this.optionVentes.getAxeActivite().equals("true")) {
         this.var_anal_activite = true;
      }

      if (this.optionVentes.getAxeSite().equals("true")) {
         this.var_anal_site = true;
         this.var_anal_departement = true;
         this.var_anal_service = true;
      }

      if (this.optionVentes.getAxeRegion().equals("true")) {
         this.var_anal_region = true;
         this.var_anal_secteur = true;
         this.var_anal_pdv = true;
      }

      if (this.optionVentes.getAxeDossier().equals("1")) {
         this.var_anal_dossier = true;
      } else if (this.optionVentes.getAxeDossier().equals("2")) {
         this.var_anal_affaire = true;
      } else if (this.optionVentes.getAxeDossier().equals("3")) {
         this.var_anal_dossier = true;
      }

      if (this.optionVentes.getAxeParc().equals("true")) {
         this.var_anal_parc = true;
      }

      if (this.optionVentes.getAxeAgent().equals("true")) {
         this.var_anal_agent = true;
      }

   }

   public void chargerSecteur() throws HibernateException, NamingException {
      this.mesSecteursItems.clear();
      this.mesPdvItems.clear();
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         new ArrayList();
         String[] var2 = this.region.split(":");
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
      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         new ArrayList();
         String[] var2 = this.secteur.split(":");
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
      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         new ArrayList();
         String[] var2 = this.site.split(":");
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
      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         new ArrayList();
         String[] var2 = this.departement.split(":");
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

   public void chargerGroupeDestinataire(Session var1) throws HibernateException, NamingException {
      this.nomGroupe = "";
      this.mesGroupes.clear();
      if (this.structureLog.getStrtypeContact() == 2) {
         PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.mesGroupes = var2.chargerLesGroupes(var1);
      }

   }

   public void chargerMarquesParc(Session var1) throws HibernateException, NamingException {
      this.marque = "";
      this.mesMarquesItems.clear();
      this.moduleParc = false;
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty() && this.structureLog.getStrmod1().equals("70000")) {
         this.moduleParc = true;
      } else if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty() && this.structureLog.getStrmod2().equals("70000")) {
         this.moduleParc = true;
      } else if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty() && this.structureLog.getStrmod3().equals("70000")) {
         this.moduleParc = true;
      } else if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty() && this.structureLog.getStrmod4().equals("70000")) {
         this.moduleParc = true;
      } else if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty() && this.structureLog.getStrmod5().equals("70000")) {
         this.moduleParc = true;
      } else if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty() && this.structureLog.getStrmod6().equals("70000")) {
         this.moduleParc = true;
      } else if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty() && this.structureLog.getStrmod7().equals("70000")) {
         this.moduleParc = true;
      } else if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty() && this.structureLog.getStrmod8().equals("70000")) {
         this.moduleParc = true;
      } else if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().isEmpty() && this.structureLog.getStrmod9().equals("70000")) {
         this.moduleParc = true;
      } else if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty() && this.structureLog.getStrmod10().equals("70000")) {
         this.moduleParc = true;
      }

      if (this.moduleParc) {
         ParcDao var2 = new ParcDao(this.baseLog, this.utilInitHibernate);
         this.mesMarquesItems = var2.chargerLesMarques(var1);
      }

   }

   public void recupererNomrep() throws HibernateException, NamingException {
      this.testafficheLigne = false;
      this.testafficheDocument = false;
      if (this.dataModelImpgen.isRowAvailable()) {
         this.nomRepertoire = (String)this.dataModelImpgen.getRowData();
         this.nomRepertoire = this.nomRepertoire.toLowerCase();
         this.nomEtat = "";
         if (this.nomRepertoire.contains("ticket")) {
            this.nature = 6;
         } else if (this.nomRepertoire.contains("commission")) {
            this.nature = 7;
         } else if (this.nomRepertoire.contains("besoin")) {
            this.nature = 20;
         } else if (this.nomRepertoire.contains("devis")) {
            this.nature = 21;
         } else if (!this.nomRepertoire.contains("commande") && !this.nomRepertoire.contains("bcagee")) {
            if (this.nomRepertoire.contains("livraison")) {
               this.nature = 23;
            } else if (this.nomRepertoire.contains("retour")) {
               this.nature = 24;
            } else if (!this.nomRepertoire.contains("facture") && !this.nomRepertoire.contains("balanceagee") && !this.nomRepertoire.contains("echeancier") && !this.nomRepertoire.contains("commission")) {
               if (this.nomRepertoire.contains("avoir")) {
                  this.nature = 26;
               } else if (this.nomRepertoire.contains("note_de_debit")) {
                  this.nature = 27;
               } else if (this.nomRepertoire.contains("chargement")) {
                  this.nature = 28;
               } else {
                  this.nature = 0;
               }
            } else {
               this.nature = 25;
            }
         } else {
            this.nature = 22;
         }

         if (this.nomRepertoire.contains("_synthese")) {
            this.testafficheDocument = true;
         }

         this.lesFichImpression.clear();
         String var1 = null;
         if (this.nomRepertoire.contains("ligne_")) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits" + File.separator + this.nomRepertoire;
            this.testafficheLigne = true;
         } else {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "client" + File.separator + this.nomRepertoire;
            this.testafficheLigne = false;
         }

         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         String[] var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  String var5 = var3[var4];
                  if (this.verificationAutorisation(var5)) {
                     String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                     this.lesFichImpression.add(var6);
                  }
               }
            }
         }

         this.dataModelImpgenFichier.setWrappedData(this.lesFichImpression);
         this.var_affiche_impression = true;
         this.mesEtatsItems.clear();
         EtatDocument var7 = new EtatDocument();
         this.mesEtatsItems = var7.calculelisteEtatsItems(this.nature, Integer.parseInt(this.optionVentes.getPaiementAVOIR()));
         this.mesSeriesItems.clear();
         this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
         List var8 = this.usersChronoDao.selectListByUserNat(this.usersLog, this.nature, (Session)null);
         if (var8.size() != 0) {
            for(int var9 = 0; var9 < var8.size(); ++var9) {
               if (this.usersLog.getUsrJrxReserve() == 1) {
                  if (((UsersChrono)var8.get(var9)).getUsrchrPrive() == 0) {
                     this.mesSeriesItems.add(new SelectItem(((UsersChrono)var8.get(var9)).getUsrchrSerie()));
                  }
               } else {
                  this.mesSeriesItems.add(new SelectItem(((UsersChrono)var8.get(var9)).getUsrchrSerie()));
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

   public void recupererNomfich() throws ParseException {
      if (this.dataModelImpgenFichier.isRowAvailable()) {
         this.nomEtat = (String)this.dataModelImpgenFichier.getRowData();
         this.filtreDateDebut = this.exoSelectionne.getExevteDateDebut();
         this.filtreDateFin = this.exoSelectionne.getExevteDateFin();
         this.var_affiche_impression = true;
         this.calculeDates();
      }

   }

   public List getMesTiersItems() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 < var1.size(); ++var3) {
         var2.add(new SelectItem(((Tiers)var1.get(var3)).getTieid(), ((Tiers)var1.get(var3)).getTieprenom()));
      }

      return var2;
   }

   public void rechercheTiers() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         String var2 = "(2,3)";
         TiersDao var3 = new TiersDao(this.baseLog, this.utilInitHibernate);
         var1 = var3.verifTiers(this.usersLog, var2, this.nomTiers, (Session)null);
         this.showModalPanelTiers = true;
      }

      this.datamodelTiers.setWrappedData(var1);
   }

   public void selectionligneTiers() throws JDOMException, IOException {
      if (this.datamodelTiers.isRowAvailable()) {
         this.tiers = (Tiers)this.datamodelTiers.getRowData();
      }

   }

   public void calculeTiers() throws JDOMException, IOException {
      if (this.tiers == null) {
         this.selectionligneTiers();
      }

      if (this.tiers != null) {
         this.nomTiers = this.tiers.getTieraisonsocialenom();
      } else {
         this.tiers = null;
         this.nomTiers = "";
      }

      this.showModalPanelTiers = false;
   }

   public void annuleTiers() {
      this.tiers = null;
      this.nomTiers = "";
      this.showModalPanelTiers = false;
   }

   public void rechercheDestinataire() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectAnal("7", this.nomDestinataire, "", this.nature, (Session)null);
         this.showModalPanelDestinataire = true;
      }

      this.datamodelDestinataire.setWrappedData(var1);
   }

   public void selectionligneDestinataire() throws JDOMException, IOException {
      if (this.datamodelDestinataire.isRowAvailable()) {
         this.plansAnalytiques = (PlansAnalytiques)this.datamodelDestinataire.getRowData();
      }

   }

   public void calculeDestinataire() throws JDOMException, IOException {
      if (this.plansAnalytiques == null) {
         this.selectionligneDestinataire();
      }

      if (this.plansAnalytiques != null) {
         this.nomDestinataire = this.plansAnalytiques.getAnaNomFr();
      } else {
         this.plansAnalytiques = null;
         this.nomDestinataire = "";
      }

      this.showModalPanelDestinataire = false;
   }

   public void annuleDestinataire() {
      this.plansAnalytiques = null;
      this.nomDestinataire = "";
      this.showModalPanelDestinataire = false;
   }

   public void rechercheProduitsDebut() throws HibernateException, NamingException {
      new ArrayList();
      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         ProduitsVtesDao var2 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         List var1 = var2.verifProduits(this.produitDebut, (Session)null);
         this.datamodelProduits.setWrappedData(var1);
         this.var_produit_choix = false;
         this.showModalPanelProduits = true;
      }

   }

   public void rechercheProduitsFin() throws HibernateException, NamingException {
      new ArrayList();
      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         ProduitsVtesDao var2 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         List var1 = var2.verifProduits(this.produitFin, (Session)null);
         this.datamodelProduits.setWrappedData(var1);
         this.var_produit_choix = true;
         this.showModalPanelProduits = true;
      }

   }

   public void selectionProduits() throws JDOMException, IOException {
      if (this.datamodelProduits.isRowAvailable()) {
         this.produits = (Produits)this.datamodelProduits.getRowData();
      }

   }

   public void calculeProduits() throws JDOMException, IOException {
      if (this.produits == null) {
         this.selectionProduits();
      }

      if (this.produits != null) {
         if (!this.var_produit_choix) {
            this.produitDebut = this.produits.getProCode();
         } else {
            this.produitFin = this.produits.getProCode();
         }
      } else {
         this.produits = null;
         if (!this.var_produit_choix) {
            this.produitDebut = "";
         } else {
            this.produitFin = "";
         }
      }

      this.showModalPanelProduits = false;
   }

   public void annuleProduits() {
      this.produits = null;
      if (!this.var_produit_choix) {
         this.produitDebut = "";
      } else {
         this.produitFin = "";
      }

      this.showModalPanelProduits = false;
   }

   public void rechercheParc() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.parc != null && !this.parc.isEmpty()) {
         ParcDao var2 = new ParcDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.rechercheParc(this.parc, "", "", "100", "100", "", (Session)null);
         this.showModalPanelParc = true;
      }

      this.datamodelParc.setWrappedData(var1);
   }

   public void selectionParc() throws JDOMException, IOException {
      if (this.datamodelParc.isRowAvailable()) {
         this.parcObj = (Parc)this.datamodelParc.getRowData();
      }

   }

   public void calculeParc() throws JDOMException, IOException {
      if (this.parcObj != null) {
         this.parc = this.parcObj.getPrcImmatriculation();
      } else {
         this.parcObj = null;
         this.parc = "";
      }

      this.showModalPanelParc = false;
   }

   public void annuleParc() {
      this.parcObj = null;
      this.parc = "";
      this.showModalPanelParc = false;
   }

   public void chargerPeriodes() throws ParseException {
      this.mesPeriodesItems.clear();
      this.mesPeriodesItems.add(new SelectItem(""));
      Date var1 = this.exoSelectionne.getExevteDateDebut();
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(var1);
      Date var3 = this.exoSelectionne.getExevteDateFin();
      GregorianCalendar var4 = new GregorianCalendar();
      var4.setTime(var3);
      var2.add(2, -1);
      var4.add(2, -1);
      String var5 = null;

      while(var2.compareTo(var4) < 0) {
         var2.add(2, 1);
         Date var6 = var2.getTime();
         var5 = this.formatPeriode(var6);
         this.mesPeriodesItems.add(new SelectItem(var5));
      }

      this.mesPeriodesItems.add(new SelectItem("1er trimestre"));
      this.mesPeriodesItems.add(new SelectItem("2eme trimestre"));
      this.mesPeriodesItems.add(new SelectItem("3eme trimestre"));
      this.mesPeriodesItems.add(new SelectItem("4eme trimestre"));
      this.mesPeriodesItems.add(new SelectItem("1er semestre"));
      this.mesPeriodesItems.add(new SelectItem("2eme semestre"));
      this.mesPeriodesItems.add(new SelectItem("Annuel"));
      this.filtreDateDebut = var1;
      this.filtreDateFin = var3;
   }

   public String formatPeriode(Date var1) {
      SimpleDateFormat var2 = new SimpleDateFormat("dd-MM-yyyy");
      var2.format(var1);
      String var3 = "" + var2.format(var1);
      String[] var4 = var3.split("-");
      String var5 = var4[0];
      String var6 = var4[1];
      String var7 = var4[2];
      String var8 = var6 + ":" + var7;
      return var8;
   }

   public void calculeDates() throws ParseException {
      if (this.periode != null && !this.periode.isEmpty()) {
         if (this.periode.contains(":")) {
            String[] var1 = this.periode.split(":");
            String var2 = var1[0];
            String var3 = var1[1];
            this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var3 + "-" + var2 + "-" + "01");
            this.filtreDateFin = this.utilDate.dateDernierJourMois(this.filtreDateDebut);
         } else {
            int var4 = (new Date()).getYear() + 1900;
            if (this.periode.equals("1er trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "03" + "-" + "31");
            } else if (this.periode.equals("2eme trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "04" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "06" + "-" + "30");
            } else if (this.periode.equals("3eme trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "07" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "09" + "-" + "30");
            } else if (this.periode.equals("4eme trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "10" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            } else if (this.periode.equals("1er semestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "06" + "-" + "30");
            } else if (this.periode.equals("2eme semestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "07" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            } else if (this.periode.equals("Annuel")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            }
         }
      }

   }

   public void initImpression() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.affMail = false;
      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         this.decoupageActivite = true;
      } else {
         this.decoupageActivite = false;
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

   public void imprimerCSV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "CSV";
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
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty() && this.nomEtat != null && !this.nomEtat.isEmpty()) {
         this.var_ctrl_imp = true;
         this.listDocument = new ArrayList();
         this.listReliquat = new ArrayList();
         this.listReliquatCmd = new ArrayList();
         this.listBCPaiementCash = new ArrayList();
         this.listProduits = new ArrayList();
         this.lesTiers = new ArrayList();
         this.calculeRequete();
         this.utilPrint.setRapport(this.nomEtat);
         if (this.nomRepertoire.contains("ligne_")) {
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits" + File.separator + this.nomRepertoire + File.separator);
         } else {
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "client" + File.separator + this.nomRepertoire + File.separator);
         }

         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
         if (this.var_entete != null && !this.var_entete.isEmpty()) {
            this.utilPrint.setEntete(this.var_entete.replace("_", " "));
         } else {
            this.utilPrint.setEntete("");
         }

         if (this.var_filtre != null && !this.var_filtre.isEmpty()) {
            this.utilPrint.setFiltre(this.var_filtre.replace("_", " "));
         } else {
            this.utilPrint.setFiltre("");
         }

         JRBeanCollectionDataSource var1;
         if (this.nomRepertoire.contains("_synthese")) {
            this.utilPrint.setRequete("");
            var1 = new JRBeanCollectionDataSource(this.listDocument);
            this.utilPrint.setjRBeanCollectionDataSource(var1);
         } else if (this.nomEtat.contains("Reliquat")) {
            this.utilPrint.setRequete("");
            var1 = new JRBeanCollectionDataSource(this.listReliquat);
            this.utilPrint.setjRBeanCollectionDataSource(var1);
         } else if (this.nomEtat.contains("CommandePaiementCash")) {
            this.utilPrint.setFiltre("Analyse paiements Cash");
            this.utilPrint.setRequete("");
            var1 = new JRBeanCollectionDataSource(this.listBCPaiementCash);
            this.utilPrint.setjRBeanCollectionDataSource(var1);
         } else if (!this.nomEtat.contains("ProduitResteALivrer") && !this.nomEtat.contains("ProduitResteALivrerDetaille")) {
            if (this.nomRepertoire.equals("produit")) {
               this.utilPrint.setFiltre("Controle produit");
               this.utilPrint.setRequete("");
               var1 = new JRBeanCollectionDataSource(this.listProduits);
               this.utilPrint.setjRBeanCollectionDataSource(var1);
            } else if (this.nomEtat.contains("comparatif_SoldeBcCompta")) {
               this.utilPrint.setFiltre("Comparatif solde BC/solde compta.");
               this.utilPrint.setRequete("");
               var1 = new JRBeanCollectionDataSource(this.lesTiers);
               this.utilPrint.setjRBeanCollectionDataSource(var1);
            } else if (this.nomEtat.contains("comparatif_Bl_Facture")) {
               this.utilPrint.setFiltre("Comparatif BL avec Factures");
               this.utilPrint.setRequete("");
               var1 = new JRBeanCollectionDataSource(this.lesLivraisonsTmp);
               this.utilPrint.setjRBeanCollectionDataSource(var1);
            } else if (this.nomEtat.contains("DepotVente")) {
               this.utilPrint.setFiltre("Analyse des ventes des produits en Dépot/Vente");
               this.utilPrint.setRequete("");
               var1 = new JRBeanCollectionDataSource(this.lesLignesFacture);
               this.utilPrint.setjRBeanCollectionDataSource(var1);
            } else {
               this.utilPrint.setRequete(this.var_requete);
               ArrayList var3 = new ArrayList();
               JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var3);
               this.utilPrint.setjRBeanCollectionDataSource(var2);
            }
         } else {
            this.utilPrint.setFiltre("Calcul reste à livrer");
            this.utilPrint.setRequete("");
            var1 = new JRBeanCollectionDataSource(this.listReliquatCmd);
            this.utilPrint.setjRBeanCollectionDataSource(var1);
         }

         if (this.etat != null && !this.etat.isEmpty()) {
            this.utilPrint.setEtat_init(Integer.parseInt(this.etat));
         } else {
            this.utilPrint.setEtat_init(1);
         }

         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.setAnnexe1(this.utilDate.dateToStringSQL(this.filtreDateFin));
         this.utilPrint.setM0DteDeb(this.m0DteDeb);
         this.utilPrint.setM0DteFin(this.m0DteFin);
         this.utilPrint.setM30DteDeb(this.m30DteDeb);
         this.utilPrint.setM30DteFin(this.m30DteFin);
         this.utilPrint.setM60DteDeb(this.m60DteDeb);
         this.utilPrint.setM60DteFin(this.m60DteFin);
         this.utilPrint.setM90DteDeb(this.m90DteDeb);
         this.utilPrint.setM90DteFin(this.m90DteFin);
         this.utilPrint.setM120DteDeb(this.m120DteDeb);
         this.utilPrint.setNbCar(this.nbJours);
         this.utilPrint.setDateDeb(this.filtreDateDebut);
         this.utilPrint.setDateFin(this.filtreDateFin);
         this.utilPrint.imprimeRapport();
         this.var_ctrl_imp = false;
      }

   }

   public void calculeRequete() throws HibernateException, NamingException, ParseException {
      this.var_entete = "";
      this.var_filtre = "";
      this.var_requete = "";
      String var1 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var2 = var1.substring(6, 10) + "-" + var1.substring(3, 5) + "-" + var1.substring(0, 2) + " 00:00:00";
      String var3 = this.utilDate.dateToStringFr(this.filtreDateFin);
      String var4 = var3.substring(6, 10) + "-" + var3.substring(3, 5) + "-" + var3.substring(0, 2) + " 23:59:59";
      String var5 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var6 = this.utilDate.dateToStringFr(this.filtreDateFin);
      if (this.nomRepertoire.equalsIgnoreCase("comparatif")) {
         if (this.nomEtat.contains("comparatif_SoldeBcCompta")) {
            this.rechercheComparatif1(var5, var6, var2, var4);
         } else if (this.nomEtat.contains("comparatif_Bl_Facture")) {
            this.rechercheComparatif2(var5, var6, var2, var4);
         }
      } else if (this.nomRepertoire.equalsIgnoreCase("entete_commission")) {
         this.rechercheCommissionSql(var5, var6, var2, var4);
      } else if (this.nomRepertoire.equalsIgnoreCase("entete_balanceagee")) {
         this.rechercheBalanceAgeeSql(var5, var6, var2, var4);
      } else if (this.nomRepertoire.equalsIgnoreCase("entete_bcagee")) {
         this.rechercheBcAgeeSql(var5, var6, var2, var4);
      } else if (this.nomRepertoire.equalsIgnoreCase("entete_echeancier")) {
         this.rechercheEcheancierSql(var5, var6, var2, var4);
      } else if (!this.nomRepertoire.equalsIgnoreCase("entete_ticket") && !this.nomRepertoire.equalsIgnoreCase("ligne_ticket")) {
         if (!this.nomRepertoire.equalsIgnoreCase("entete_besoin") && !this.nomRepertoire.equalsIgnoreCase("ligne_besoin")) {
            if (!this.nomRepertoire.equalsIgnoreCase("entete_devis") && !this.nomRepertoire.equalsIgnoreCase("ligne_devis")) {
               if (!this.nomRepertoire.equalsIgnoreCase("entete_commande") && !this.nomRepertoire.equalsIgnoreCase("ligne_commande")) {
                  if (!this.nomRepertoire.equalsIgnoreCase("entete_livraison") && !this.nomRepertoire.equalsIgnoreCase("ligne_livraison")) {
                     if (!this.nomRepertoire.equalsIgnoreCase("entete_retour") && !this.nomRepertoire.equalsIgnoreCase("ligne_retour")) {
                        if (!this.nomRepertoire.equalsIgnoreCase("entete_facture") && !this.nomRepertoire.equalsIgnoreCase("ligne_facture")) {
                           if (!this.nomRepertoire.equalsIgnoreCase("entete_avoir") && !this.nomRepertoire.equalsIgnoreCase("ligne_avoir")) {
                              if (!this.nomRepertoire.equalsIgnoreCase("entete_note_de_debit") && !this.nomRepertoire.equalsIgnoreCase("ligne_note_de_debit")) {
                                 if (!this.nomRepertoire.equalsIgnoreCase("entete_synthese") && !this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
                                    if (this.nomRepertoire.equalsIgnoreCase("produit")) {
                                       this.rechercheProduitSql();
                                    }
                                 } else {
                                    this.rechercheSynthese(var5, var6, var2, var4);
                                    if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
                                       this.var_entete = "Synthèse du " + var5 + " au " + var6 + " Série : Toutes";
                                    } else {
                                       this.var_entete = "Synthèse du " + var5 + " au " + var6 + " Série : " + this.serie;
                                    }

                                    this.var_filtre = "";
                                    if (this.var_devis) {
                                       this.var_filtre = this.var_filtre + "Devis, ";
                                    }

                                    if (this.var_bc) {
                                       this.var_filtre = this.var_filtre + "B.C, ";
                                    }

                                    if (this.var_bl) {
                                       this.var_filtre = this.var_filtre + "B.L, ";
                                    }

                                    if (this.var_br) {
                                       this.var_filtre = this.var_filtre + "B.R, ";
                                    }

                                    if (this.var_facture) {
                                       this.var_filtre = this.var_filtre + "Facture, ";
                                    }

                                    if (this.var_noteDebit) {
                                       this.var_filtre = this.var_filtre + "N.D.B., ";
                                    }

                                    if (this.var_avoir) {
                                       this.var_filtre = this.var_filtre + "Avoir, ";
                                    }

                                    if (this.var_bs) {
                                       this.var_filtre = this.var_filtre + "B.S, ";
                                    }

                                    if (this.var_be) {
                                       this.var_filtre = this.var_filtre + "B.E, ";
                                    }

                                    if (this.var_cessionIn) {
                                       this.var_filtre = this.var_filtre + "C.E, ";
                                    }

                                    if (this.var_cessionOut) {
                                       this.var_filtre = this.var_filtre + "C.S, ";
                                    }

                                    if (this.var_filtre != null && !this.var_filtre.isEmpty()) {
                                       this.var_filtre = "(" + this.var_filtre + ") ";
                                    }

                                    if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
                                       this.var_filtre = this.var_filtre + " Activité = " + this.activite;
                                    } else {
                                       this.activite = "";
                                    }

                                    if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
                                       this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
                                    } else {
                                       this.var_colonne1 = "";
                                    }

                                    if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
                                       this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
                                    } else {
                                       this.var_colonne2 = "";
                                    }

                                    if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
                                       this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
                                    } else {
                                       this.var_colonne3 = "";
                                    }

                                    if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
                                       this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
                                    } else {
                                       this.dossier = "";
                                    }

                                    if (this.parc != null && !this.parc.isEmpty()) {
                                       this.var_filtre = this.var_filtre + " Parc = " + this.parc;
                                    } else {
                                       this.parc = "";
                                    }

                                    if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
                                       this.var_filtre = this.var_filtre + " Site = " + this.site;
                                    } else {
                                       this.site = "";
                                    }

                                    if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
                                       this.var_filtre = this.var_filtre + " Département = " + this.departement;
                                    } else {
                                       this.departement = "";
                                    }

                                    if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
                                       this.var_filtre = this.var_filtre + " Service = " + this.service;
                                    } else {
                                       this.service = "";
                                    }

                                    if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
                                       this.var_filtre = this.var_filtre + " Région = " + this.region;
                                    } else {
                                       this.region = "";
                                    }

                                    if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
                                       this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
                                    } else {
                                       this.secteur = "";
                                    }

                                    if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
                                       this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
                                    } else {
                                       this.pdv = "";
                                    }

                                    if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
                                       this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
                                    } else {
                                       this.categorie = "";
                                    }

                                    if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
                                       this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
                                    } else {
                                       this.produitDebut = "";
                                    }

                                    if (this.produitFin != null && !this.produitFin.isEmpty()) {
                                       this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
                                    } else {
                                       this.produitFin = "";
                                    }

                                    if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
                                       this.var_filtre = this.var_filtre + " famille = " + this.famille;
                                    } else {
                                       this.famille = "";
                                    }
                                 }
                              } else {
                                 this.rechercheNoteDebitSql(var5, var6, var2, var4);
                              }
                           } else {
                              this.rechercheAvoirSql(var5, var6, var2, var4);
                           }
                        } else if (this.nomEtat.contains("DepotVente")) {
                           this.rechercheFactureHql(var5, var6, var2, var4);
                        } else {
                           this.rechercheFactureSql(var5, var6, var2, var4);
                        }
                     } else {
                        this.rechercheRetourSql(var5, var6, var2, var4);
                     }
                  } else if (this.nomEtat.contains("Reliquat")) {
                     this.rechercheLivraisonHql(var5, var6, var2, var4);
                  } else {
                     this.rechercheLivraisonSql(var5, var6, var2, var4);
                  }
               } else if (this.nomEtat.contains("CommandePaiementCash")) {
                  this.rechercheCommandeSql(var5, var6, var2, var4, this.filtreDateDebut, this.filtreDateFin);
               } else if (!this.nomEtat.contains("ProduitResteALivrerDetaille") && !this.nomEtat.contains("ProduitResteALivrer")) {
                  this.rechercheCommandeSql(var5, var6, var2, var4, this.filtreDateDebut, this.filtreDateFin);
               } else {
                  this.rechercheCommandeHql(var5, var6, var2, var4);
               }
            } else {
               this.rechercheDevisSql(var5, var6, var2, var4);
            }
         } else {
            this.rechercheBesoinSql(var5, var6, var2, var4);
         }
      } else {
         this.rechercheTicketSql(var5, var6, var2, var4);
      }

   }

   public void rechercheComparatif1(String var1, String var2, String var3, String var4) throws HibernateException, NamingException, ParseException {
      String var5 = this.utilDate.dateToStringSQLLight(this.filtreDateFin);
      this.var_entete = "Comparatif solde BC/Compta client au " + var2;
      this.var_filtre = "";
      this.var_requete = "from Tiers where tie_id > 0 and tie_type=3 ";
      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and tie_raison_sociale_nom='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
         }
      }

      if (this.nomSigle != null && !this.nomSigle.isEmpty()) {
         this.var_filtre = this.var_filtre + " Sigle/Appartenance = " + this.nomSigle;
         this.var_requete = this.var_requete + " and tie_sigle like '" + this.nomSigle + "%'";
      }

      this.var_requete = this.var_requete + " order by tie_raison_sociale_nom ";
      String var6 = "";
      Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      TiersDao var8 = new TiersDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var9 = var8.listeTiers(this.var_requete, var7);
      if (var9.size() != 0) {
         new ArrayList();
         CommandeLigneVentesDao var11 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         CommandeEnteteVentesDao var13 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         var6 = var6 + "(bcm_etat=1 or bcm_etat=4 or bcm_etat=5) and bcm_solde=0 and bcm_date<='" + var4 + "'";
         List var12 = var13.rechercheCommandeRequete(var6, var7);
         new ArrayList();
         var6 = "(bcm_etat=1 or bcm_etat=4) and bcm_date<='" + var4 + "'";
         List var14 = var13.rechercheCommandeRequete(var6, var7);
         new ArrayList();
         this.livraisonEnteteVentesDao = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         var6 = "blv_etat = 1 and blv_date<='" + var4 + "'";
         List var15 = this.livraisonEnteteVentesDao.rechercheLivraisonRequete(var6, var7);
         new ArrayList();
         FactureEnteteVentesDao var17 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         var6 = "fac_date_transfert=null and fac_date<='" + var4 + "'";
         List var16 = var17.rechercheFactureRequete(var6, var7);
         new ArrayList();
         NoteDebitEnteteVentesDao var19 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         var6 = "((ndb_etat=1 or ndb_etat=4 or ndb_etat=5) and ndb_solde=0) or (ndb_date_transfert=null) and ndb_date<='" + var4 + "'";
         List var18 = var19.rechercheNoteDebitRequete(var6, var7);
         new ArrayList();
         AvoirEnteteVentesDao var21 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         var6 = "avr_date_transfert=null and avr_date<='" + var4 + "'";
         List var20 = var21.rechercheAvoirRequete(var6, var7);
         new ArrayList();
         ReglementsDao var23 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         var6 = "rgl_date_transfert=null and rgl_trf=0 and rgl_nature_doc=22 and rgl_date_reg<='" + var5 + "'";
         List var22 = var23.rechercheReglementsRequete(var6, var7);
         Object var24 = new ArrayList();
         new ExercicesComptable();
         ExercicesComptableDao var26 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
         ExercicesComptable var25 = var26.recupererLastExo(var7);
         if (var25 != null) {
            EcrituresDao var27 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
            var6 = "ecr_date_saisie>='" + var25.getExecptDateDebut() + "' and ecr_date_saisie<='" + var5 + "'";
            var24 = var27.ChargerLesEcrituresRecherche(var6, var7);
         }

         this.tiers = new Tiers();

         for(int var55 = 0; var55 < var9.size(); ++var55) {
            this.tiers = (Tiers)var9.get(var55);
            if (this.tiers.getTiecompte0() != null && !this.tiers.getTiecompte0().isEmpty() && this.tiers.getTiecompte0().startsWith("41")) {
               double var28 = 0.0D;
               if (var12.size() != 0) {
                  for(int var30 = 0; var30 < var12.size(); ++var30) {
                     if (((CommandeEnteteVentes)var12.get(var30)).getTiers().getTieid() == this.tiers.getTieid()) {
                        var28 += ((CommandeEnteteVentes)var12.get(var30)).getBcmTotTtc() - ((CommandeEnteteVentes)var12.get(var30)).getBcmTotReglement();
                     }
                  }
               }

               double var56 = 0.0D;
               if (var14.size() != 0) {
                  for(int var32 = 0; var32 < var14.size(); ++var32) {
                     if (((CommandeEnteteVentes)var14.get(var32)).getTiers().getTieid() == this.tiers.getTieid()) {
                        List var10 = var11.chargerLesLignes((CommandeEnteteVentes)var14.get(var32), var7);
                        if (var10.size() != 0) {
                           for(int var33 = 0; var33 < var10.size(); ++var33) {
                              var56 += (double)(((CommandeLigneVentes)var10.get(var33)).getBcmligQte() - ((CommandeLigneVentes)var10.get(var33)).getBcmligQteLivree()) * ((CommandeLigneVentes)var10.get(var33)).getBcmligPuTtc();
                           }
                        }
                     }
                  }
               }

               double var57 = 0.0D;
               if (var15.size() != 0) {
                  for(int var34 = 0; var34 < var15.size(); ++var34) {
                     if (((LivraisonEnteteVentes)var15.get(var34)).getTiers().getTieid() == this.tiers.getTieid()) {
                        var57 += ((LivraisonEnteteVentes)var15.get(var34)).getBlvTotTtc() - ((LivraisonEnteteVentes)var15.get(var34)).getBlvTotReglement();
                     }
                  }
               }

               double var58 = 0.0D;
               if (var16.size() != 0) {
                  for(int var36 = 0; var36 < var16.size(); ++var36) {
                     if (((FactureEnteteVentes)var16.get(var36)).getTiers().getTieid() == this.tiers.getTieid()) {
                        var58 += ((FactureEnteteVentes)var16.get(var36)).getFacTotTtc() - ((FactureEnteteVentes)var16.get(var36)).getFacTotReglement();
                     }
                  }
               }

               double var59 = 0.0D;
               if (var18.size() != 0) {
                  for(int var38 = 0; var38 < var18.size(); ++var38) {
                     if (((NoteDebitEnteteVentes)var18.get(var38)).getTiers().getTieid() == this.tiers.getTieid()) {
                        if (((NoteDebitEnteteVentes)var18.get(var38)).getNdbDateTransfert() == null) {
                           var59 += ((NoteDebitEnteteVentes)var18.get(var38)).getNdbTotTtc() - ((NoteDebitEnteteVentes)var18.get(var38)).getNdbTotReglement();
                        }

                        if ((((NoteDebitEnteteVentes)var18.get(var38)).getNdbEtat() == 1 || ((NoteDebitEnteteVentes)var18.get(var38)).getNdbEtat() == 4 || ((NoteDebitEnteteVentes)var18.get(var38)).getNdbEtat() == 5) && ((NoteDebitEnteteVentes)var18.get(var38)).getNdbSolde() == 0) {
                           var28 += ((NoteDebitEnteteVentes)var18.get(var38)).getNdbTotTtc() - ((NoteDebitEnteteVentes)var18.get(var38)).getNdbTotReglement();
                        }
                     }
                  }
               }

               double var60 = 0.0D;
               if (var20.size() != 0) {
                  for(int var40 = 0; var40 < var20.size(); ++var40) {
                     if (((AvoirEnteteVentes)var20.get(var40)).getTiers().getTieid() == this.tiers.getTieid()) {
                        var60 += ((AvoirEnteteVentes)var20.get(var40)).getAvrTotTtc();
                     }
                  }
               }

               double var61 = 0.0D;
               if (var22.size() != 0) {
                  for(int var42 = 0; var42 < var22.size(); ++var42) {
                     if (((Reglements)var22.get(var42)).getRglIdTiers() == this.tiers.getTieid()) {
                        var61 += ((Reglements)var22.get(var42)).getRglRecette();
                     }
                  }
               }

               double var62 = 0.0D;
               double var44 = 0.0D;
               double var46 = 0.0D;
               double var48 = 0.0D;
               boolean var50 = false;
               if (((List)var24).size() != 0) {
                  for(int var51 = 0; var51 < ((List)var24).size(); ++var51) {
                     if (((Ecritures)((List)var24).get(var51)).getEcrCompte().equals(this.tiers.getTiecompte0())) {
                        var62 += ((Ecritures)((List)var24).get(var51)).getEcrDebitPays();
                        var44 += ((Ecritures)((List)var24).get(var51)).getEcrCreditPays();
                     }

                     if (this.tiers.getTiecompte3() != null && !this.tiers.getTiecompte3().isEmpty() && ((Ecritures)((List)var24).get(var51)).getEcrCompte().equals(this.tiers.getTiecompte3())) {
                        var50 = true;
                        var62 += ((Ecritures)((List)var24).get(var51)).getEcrDebitPays();
                        var44 += ((Ecritures)((List)var24).get(var51)).getEcrCreditPays();
                     }
                  }

                  if (var62 > var44) {
                     var46 = var62 - var44;
                     var48 = 0.0D;
                  } else {
                     var48 = var44 - var62;
                     var46 = 0.0D;
                  }
               }

               if (var50) {
                  this.tiers.setTiecompte0(this.tiers.getTiecompte3());
               }

               this.tiers.setBcNonSolde(var28);
               this.tiers.setBcNonlivre(var56);
               this.tiers.setBlNonTrf(var57);
               this.tiers.setFacNonTrf(var58);
               this.tiers.setNdbNonTrf(var59);
               this.tiers.setAvoirNonTrf(var60);
               this.tiers.setReglementNonTrf(var61);
               this.tiers.setTotDebit(var46);
               this.tiers.setTotCredit(var48);
               double var63 = 0.0D;
               double var53 = 0.0D;
               if (var46 != 0.0D && var48 == 0.0D) {
                  var53 = var46 + var59 + var56 + var57 + var58 - var60 - var61;
               } else {
                  var53 = var48 - var59 - var56 - var57 - var58 + var60 + var61;
               }

               if (var46 != 0.0D && var48 == 0.0D) {
                  var63 = var28 - Math.abs(var53);
               } else {
                  var63 = var28 - Math.abs(var53);
               }

               this.tiers.setEcart(var63);
               if (var28 != 0.0D || var56 != 0.0D || var57 != 0.0D || var58 != 0.0D || var59 != 0.0D || var60 != 0.0D || var61 != 0.0D || var46 != 0.0D || var48 != 0.0D || var63 != 0.0D) {
                  this.lesTiers.add(this.tiers);
               }
            }
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void rechercheComparatif2(String var1, String var2, String var3, String var4) throws HibernateException, NamingException, ParseException {
      this.lesLivraisonsTmp = new ArrayList();
      this.var_entete = "Comparatif Bl/Facture client du " + var1 + " au " + var2;
      this.var_filtre = "";
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      this.livraisonLigneVentesDao = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
      FactureLigneVentesDao var6 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ArrayList();
      List var7 = this.livraisonLigneVentesDao.chargerLesLignes(var3, var4, var5);
      if (var7.size() != 0) {
         String var9 = "";

         for(int var10 = 0; var10 < var7.size(); ++var10) {
            if (var9 != null && !var9.isEmpty()) {
               var9 = var9 + "," + ((LivraisonLigneVentes)var7.get(var10)).getBlvligId();
            } else {
               var9 = "" + ((LivraisonLigneVentes)var7.get(var10)).getBlvligId();
            }
         }

         String var15 = "facligIdBlv in (" + var9 + ")";
         List var8 = var6.rechercheFactureRequete(var15, var5);

         for(int var11 = 0; var11 < var7.size(); ++var11) {
            this.livraisonLigneVentes = (LivraisonLigneVentes)var7.get(var11);
            if (this.livraisonLigneVentes.getBlvligQte() != 0.0F) {
               if (var8.size() == 0) {
                  this.livraisonLigneVentes.setVar_qteReliquat(0.0F);
                  this.lesLivraisonsTmp.add(this.livraisonLigneVentes);
               } else {
                  float var12 = 0.0F;
                  boolean var13 = false;

                  for(int var14 = 0; var14 < var8.size(); ++var14) {
                     if (((FactureLigneVentes)var8.get(var14)).getFacligIdBlv() == this.livraisonLigneVentes.getBlvligId() && ((FactureLigneVentes)var8.get(var14)).getFacligCode() != null && !((FactureLigneVentes)var8.get(var14)).getFacligCode().isEmpty() && ((FactureLigneVentes)var8.get(var14)).getFacligCode().equals(this.livraisonLigneVentes.getBlvligCode())) {
                        var12 += ((FactureLigneVentes)var8.get(var14)).getFacligQte();
                        var13 = true;
                     }
                  }

                  if (this.livraisonLigneVentes.getBlvligQte() != var12 || !var13) {
                     this.livraisonLigneVentes.setVar_qteReliquat(var12);
                     this.lesLivraisonsTmp.add(this.livraisonLigneVentes);
                  }
               }
            }
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void rechercheCommissionSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException, ParseException {
      this.var_entete = "Calcul Commissions du " + var1 + " au " + var2;
      this.var_filtre = "";
      String var5 = this.utilDate.dateToStringSQLLight(this.filtreDateDebut);
      String var6 = this.utilDate.dateToStringSQLLight(this.filtreDateFin);
      this.var_requete = "(rglDateReg >='" + var5 + "' and rglDateReg <='" + var6 + "' and rglNatureDoc=25 and rglIdDocument<>0) group by rglIdDocument order by rglIdDocument";
      new ArrayList();
      new FactureEnteteVentes();
      FactureEnteteVentesDao var9 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      ReglementsDao var10 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      String var11 = "";
      Session var12 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var13 = null;

      try {
         var13 = var12.beginTransaction();
         List var7 = var10.rechercheReglementsRequete(this.var_requete, var12);
         if (var7.size() != 0) {
            for(int var14 = 0; var14 < var7.size(); ++var14) {
               if (((Reglements)var7.get(var14)).getRglIdDocument() != 0L) {
                  if (var11 != null && !var11.isEmpty()) {
                     var11 = var11 + "," + ((Reglements)var7.get(var14)).getRglIdDocument();
                  } else {
                     var11 = "" + ((Reglements)var7.get(var14)).getRglIdDocument();
                  }

                  long var15 = ((Reglements)var7.get(var14)).getRglIdDocument();
                  FactureEnteteVentes var8 = var9.pourParapheur(var15, var12);
                  if (var8 != null) {
                     var8.setFacDateTmpReg(((Reglements)var7.get(var14)).getRglDateReg());
                     var9.modif(var8, var12);
                  }
               }
            }
         }

         var13.commit();
      } catch (HibernateException var20) {
         if (var13 != null) {
            var13.rollback();
         }

         throw var20;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_requete = "";
      if (this.nbJours == 0) {
         this.nbJours = 1;
      }

      if (var11 != null && !var11.isEmpty()) {
         if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
            this.var_requete = "vte_facture_entete.fac_id in (" + var11 + ")";
         } else {
            this.var_entete = this.var_entete + " Série : " + this.serie;
            this.var_requete = "vte_facture_entete.fac_id in (" + var11 + ") and fac_serie='" + this.serie + "'";
         }
      } else {
         this.var_requete = "vte_facture_entete.fac_id = 0";
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and fac_nom_tiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (fac_tiers_regroupe is not null or fac_tiers_regroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and fac_tiers_regroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.nomSigle != null && !this.nomSigle.isEmpty()) {
         this.var_filtre = this.var_filtre + " Sigle/Appartenance = " + this.nomSigle;
         this.var_requete = this.var_requete + " and cmm_tiers.tie_sigle like '" + this.nomSigle + "%'";
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         if (this.structureLog.getStrtypeContact() == 2) {
            this.var_filtre = this.var_filtre + " Destinataire = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and fac_nom_contact='" + this.nomDestinataire + "'";
         } else {
            this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and fac_nom_contact like '" + this.nomDestinataire + "%'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and fac_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and fac_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and fac_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and fac_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and fac_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and fac_anal2 like '" + this.parc + "%'";
      }

      if (this.marque != null && !this.marque.isEmpty()) {
         this.var_filtre = this.var_filtre + " Marque = " + this.marque;
         this.var_requete = this.var_requete + " and fac_anal2 like '%" + this.marque + "%'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and fac_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and fac_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and fac_service='" + this.service + "'";
      }

      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         this.var_requete = this.var_requete + " and fac_region='" + this.region + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         this.var_requete = this.var_requete + " and fac_secteur='" + this.secteur + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         this.var_requete = this.var_requete + " and fac_pdv='" + this.pdv + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and fac_cat='" + this.categorie + "'";
      }

      UserDao var22;
      String var23;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var22 = new UserDao(this.baseLog, this.utilInitHibernate);
         var23 = var22.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var23;
         this.var_requete = this.var_requete + " and fac_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var22 = new UserDao(this.baseLog, this.utilInitHibernate);
         var23 = var22.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var23;
         this.var_requete = this.var_requete + " and fac_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var22 = new UserDao(this.baseLog, this.utilInitHibernate);
         var23 = var22.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var23;
         this.var_requete = this.var_requete + " and fac_id_createur=" + this.createur;
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and fac_source='" + this.source + "'";
      }

      this.var_requete = this.var_requete + " and faclig_code<>'-'";
      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
         this.var_requete = this.var_requete + " and faclig_code>='" + this.produitDebut + "'";
      }

      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
         this.var_requete = this.var_requete + " and faclig_code<='" + this.produitFin + "'";
      }

      String[] var24;
      if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
         this.var_filtre = this.var_filtre + " famille = " + this.famille;
         var24 = this.famille.split(":");
         this.var_requete = this.var_requete + " and faclig_famille like '" + var24[0] + "%'";
      }

      if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
         this.var_filtre = this.var_filtre + " dépôt = " + this.depot;
         var24 = this.depot.split(":");
         this.var_requete = this.var_requete + " and faclig_depot='" + var24[0] + "'";
      }

   }

   public void rechercheBalanceAgeeSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException, ParseException {
      this.m0DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(this.filtreDateFin)) + " 00:00:00";
      this.m0DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(this.filtreDateFin)) + " 23:59:59";
      Date var5 = this.utilDate.dateMoisPrecedent(this.filtreDateFin);
      this.m30DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var5)) + " 00:00:00";
      this.m30DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(var5)) + " 23:59:59";
      Date var6 = this.utilDate.dateMoisPrecedent(var5);
      this.m60DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var6)) + " 00:00:00";
      this.m60DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(var6)) + " 23:59:59";
      Date var7 = this.utilDate.dateMoisPrecedent(var6);
      this.m90DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var7)) + " 00:00:00";
      this.m90DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(var7)) + " 23:59:59";
      Date var8 = this.utilDate.dateMoisPrecedent(var7);
      this.m120DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var8)) + " 00:00:00";
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Balance Agée client au " + var2;
         this.var_requete = "fac_date_eche_reg<='" + this.exoSelectionne.getExevteDateFin() + "'";
      } else {
         this.var_entete = "Balance Agée client au " + var2 + " Série : " + this.serie;
         this.var_requete = "fac_date_eche_reg<='" + this.exoSelectionne.getExevteDateFin() + "' and fac_serie='" + this.serie + "'";
      }

      this.var_filtre = this.var_filtre + " Etat = Non Soldé";
      this.var_requete = this.var_requete + " and fac_solde=0";
      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and fac_nom_tiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (fac_tiers_regroupe is not null or fac_tiers_regroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and fac_tiers_regroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.nomSigle != null && !this.nomSigle.isEmpty()) {
         this.var_filtre = this.var_filtre + " Sigle/Appartenance = " + this.nomSigle;
         this.var_requete = this.var_requete + " and cmm_tiers.tie_sigle like '" + this.nomSigle + "%'";
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         if (this.structureLog.getStrtypeContact() == 2) {
            this.var_filtre = this.var_filtre + " Destinataire = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and fac_nom_contact='" + this.nomDestinataire + "'";
         } else {
            this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and fac_nom_contact like '" + this.nomDestinataire + "%'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and fac_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and fac_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and fac_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and fac_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and fac_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and fac_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and fac_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and fac_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and fac_service='" + this.service + "'";
      }

      String[] var9;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var9 = this.region.split(":");
         this.var_requete = this.var_requete + " and fac_region='" + var9[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var9 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and fac_secteur='" + var9[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var9 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and fac_pdv='" + var9[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and fac_cat='" + this.categorie + "'";
      }

      String var10;
      UserDao var11;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var11 = new UserDao(this.baseLog, this.utilInitHibernate);
         var10 = var11.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var10;
         this.var_requete = this.var_requete + " and fac_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var11 = new UserDao(this.baseLog, this.utilInitHibernate);
         var10 = var11.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var10;
         this.var_requete = this.var_requete + " and fac_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var11 = new UserDao(this.baseLog, this.utilInitHibernate);
         var10 = var11.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var10;
         this.var_requete = this.var_requete + " and fac_id_createur=" + this.createur;
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and fac_source='" + this.source + "'";
      }

   }

   public void rechercheBcAgeeSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException, ParseException {
      this.m0DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(this.filtreDateFin)) + " 00:00:00";
      this.m0DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(this.filtreDateFin)) + " 23:59:59";
      Date var5 = this.utilDate.dateMoisPrecedent(this.filtreDateFin);
      this.m30DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var5)) + " 00:00:00";
      this.m30DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(var5)) + " 23:59:59";
      Date var6 = this.utilDate.dateMoisPrecedent(var5);
      this.m60DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var6)) + " 00:00:00";
      this.m60DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(var6)) + " 23:59:59";
      Date var7 = this.utilDate.dateMoisPrecedent(var6);
      this.m90DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var7)) + " 00:00:00";
      this.m90DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(var7)) + " 23:59:59";
      Date var8 = this.utilDate.dateMoisPrecedent(var7);
      this.m120DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var8)) + " 00:00:00";
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "BC Agée client au " + var2;
         this.var_requete = "bcm_date_eche_reg<='" + this.exoSelectionne.getExevteDateFin() + "'";
      } else {
         this.var_entete = "BC Agée client au " + var2 + " Série : " + this.serie;
         this.var_requete = "bcm_date_eche_reg<='" + this.exoSelectionne.getExevteDateFin() + "' and bcm_serie='" + this.serie + "'";
      }

      this.var_filtre = this.var_filtre + " Etat = Non Soldé";
      this.var_requete = this.var_requete + " and bcm_solde=0";
      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and bcm_nom_tiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (fac_tiers_regroupe is not null or fac_tiers_regroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and fac_tiers_regroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.nomSigle != null && !this.nomSigle.isEmpty()) {
         this.var_filtre = this.var_filtre + " Sigle/Appartenance = " + this.nomSigle;
         this.var_requete = this.var_requete + " and cmm_tiers.tie_sigle like '" + this.nomSigle + "%'";
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         if (this.structureLog.getStrtypeContact() == 2) {
            this.var_filtre = this.var_filtre + " Destinataire = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and bcm_nom_contact='" + this.nomDestinataire + "'";
         } else {
            this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and bcm_nom_contact like '" + this.nomDestinataire + "%'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and bcm_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and bcm_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and bcm_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and bcm_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and bcm_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and bcm_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and bcm_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and bcm_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and bcm_service='" + this.service + "'";
      }

      String[] var9;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var9 = this.region.split(":");
         this.var_requete = this.var_requete + " and bcm_region='" + var9[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var9 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and bcm_secteur='" + var9[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var9 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and bcm_pdv='" + var9[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and bcm_cat='" + this.categorie + "'";
      }

      String var10;
      UserDao var11;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var11 = new UserDao(this.baseLog, this.utilInitHibernate);
         var10 = var11.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var10;
         this.var_requete = this.var_requete + " and bcm_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var11 = new UserDao(this.baseLog, this.utilInitHibernate);
         var10 = var11.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var10;
         this.var_requete = this.var_requete + " and bcm_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var11 = new UserDao(this.baseLog, this.utilInitHibernate);
         var10 = var11.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var10;
         this.var_requete = this.var_requete + " and bcm_id_createur=" + this.createur;
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and bcm_source='" + this.source + "'";
      }

   }

   public void rechercheEcheancierSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Balance Agée client au " + var2;
         this.var_requete = "fac_date_eche_reg<='" + this.exoSelectionne.getExevteDateFin() + "'";
      } else {
         this.var_entete = "Balance Agée client au " + var2 + " Série : " + this.serie;
         this.var_requete = "fac_date_eche_reg<='" + this.exoSelectionne.getExevteDateFin() + "' and fac_serie='" + this.serie + "'";
      }

      this.var_filtre = this.var_filtre + " Etat = Non Soldé";
      this.var_requete = this.var_requete + " and fac_solde=0";
      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and fac_nom_tiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (fac_tiers_regroupe is not null or fac_tiers_regroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and fac_tiers_regroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.nomSigle != null && !this.nomSigle.isEmpty()) {
         this.var_filtre = this.var_filtre + " Sigle/Appartenance = " + this.nomSigle;
         this.var_requete = this.var_requete + " and cmm_tiers.tie_sigle like '" + this.nomSigle + "%'";
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         if (this.structureLog.getStrtypeContact() == 2) {
            this.var_filtre = this.var_filtre + " Destinataire = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and fac_nom_contact='" + this.nomDestinataire + "'";
         } else {
            this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and fac_nom_contact like '" + this.nomDestinataire + "%'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and fac_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and fac_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and fac_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and fac_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and fac_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and fac_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and fac_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and fac_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and fac_service='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and fac_region='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and fac_secteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and fac_pdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and fac_cat='" + this.categorie + "'";
      }

      String var6;
      UserDao var7;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and fac_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var6;
         this.var_requete = this.var_requete + " and fac_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and fac_id_createur=" + this.createur;
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and fac_source='" + this.source + "'";
      }

   }

   public void rechercheBesoinSql(String var1, String var2, String var3, String var4) {
   }

   public void rechercheTicketSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      this.var_entete = "Liste des Tickets du " + var1 + " au " + var2;
      this.var_requete = "tic_date>='" + var3 + "' and tic_date<='" + var4 + "'";
      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and tic_nom_tiers='" + this.nomTiers + "'";
      }

      if (this.nomSigle != null && !this.nomSigle.isEmpty()) {
         this.var_filtre = this.var_filtre + " Sigle/Appartenance = " + this.nomSigle;
         this.var_requete = this.var_requete + " and cmm_tiers.tie_sigle like '" + this.nomSigle + "%'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and tic_service='" + this.service + "'";
      }

      UserDao var5;
      String var6;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var5 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var5.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and tic_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var5 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var5.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var6;
         this.var_requete = this.var_requete + " and tic_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var5 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var5.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and tic_id_createur=" + this.createur;
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_ticket")) {
         if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
            this.var_filtre = this.var_filtre + " Activité = " + this.activite;
            this.var_requete = this.var_requete + " and ticlig_activite='" + this.activite + "'";
         }

         if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
            this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
            this.var_requete = this.var_requete + " and ticlig_activite like '%" + this.var_colonne1 + "%'";
         }

         if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
            this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
            this.var_requete = this.var_requete + " and ticlig_activite like '%" + this.var_colonne2 + "%'";
         }

         if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
            this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
            this.var_requete = this.var_requete + " and ticlig_activite like '%" + this.var_colonne3 + "%'";
         }

         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and ticlig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and ticlig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            String[] var7 = this.famille.split(":");
            this.var_requete = this.var_requete + " and ticlig_famille like'" + var7[0] + "%'";
         }
      }

   }

   public void rechercheDevisSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Devis du " + var1 + " au " + var2;
         this.var_requete = "dvs_date>='" + var3 + "' and dvs_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Devis du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "dvs_date>='" + var3 + "' and dvs_date<='" + var4 + "' and dvs_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("101")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and dvs_etat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and dvs_etat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and dvs_etat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and dvs_etat=" + var5;
         } else if (var5 == 4) {
            this.var_filtre = this.var_filtre + " Etat = Transformation patielle";
            this.var_requete = this.var_requete + " and dvs_etat=" + var5;
         } else if (var5 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Transformation totale";
            this.var_requete = this.var_requete + " and dvs_etat=" + var5;
         } else if (var5 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Relancé";
            this.var_requete = this.var_requete + " and dvs_date_relance!=null";
         } else if (var5 == 12) {
            this.var_filtre = this.var_filtre + " Etat = Promotion";
            this.var_requete = this.var_requete + " and dvs_tot_ht=0";
         } else if (var5 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and dvs_solde=0";
         } else if (var5 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and dvs_solde=1";
         } else if (var5 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and dvs_exo_tva=1";
         }
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and dvs_nom_tier='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (dvs_tiers_regroupe is not null or dvs_tiers_regroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and dvs_tiers_regroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.nomSigle != null && !this.nomSigle.isEmpty()) {
         this.var_filtre = this.var_filtre + " Sigle/Appartenance = " + this.nomSigle;
         this.var_requete = this.var_requete + " and cmm_tiers.tie_sigle like '" + this.nomSigle + "%'";
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         if (this.structureLog.getStrtypeContact() == 2) {
            this.var_filtre = this.var_filtre + " Destinataire = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and dvs_nom_contact='" + this.nomDestinataire + "'";
         } else {
            this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and dvs_nom_contact like '" + this.nomDestinataire + "%'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and dvs_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and dvs_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and dvs_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and dvs_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and dvs_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and dvs_anal2 like '" + this.parc + "%'";
      }

      if (this.marque != null && !this.marque.isEmpty()) {
         this.var_filtre = this.var_filtre + " Marque = " + this.marque;
         this.var_requete = this.var_requete + " and dvs_anal2 like '%" + this.marque + "%'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and dvs_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and dvs_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and dvs_service='" + this.service + "'";
      }

      String[] var7;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var7 = this.region.split(":");
         this.var_requete = this.var_requete + " and dvs_region='" + var7[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var7 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and dvs_secteur='" + var7[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var7 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and dvs_pdv='" + var7[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and dvs_cat='" + this.categorie + "'";
      }

      String var6;
      UserDao var8;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and dvs_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var6;
         this.var_requete = this.var_requete + " and dvs_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and dvs_id_createur=" + this.createur;
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and dvs_source='" + this.source + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_devis")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and dvslig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and dvslig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var7 = this.famille.split(":");
            this.var_requete = this.var_requete + " and dvslig_famille like'" + var7[0] + "%'";
         }
      }

   }

   public void rechercheDevisHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Devis du " + var1 + " au " + var2;
         this.var_requete = "devisEnteteVentes.dvsDate>='" + var3 + "' and devisEnteteVentes.dvsDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Devis du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "devisEnteteVentes.dvsDate>='" + var3 + "' and devisEnteteVentes.dvsDate<='" + var4 + "' and devisEnteteVentes.dvsSerie='" + this.serie + "'";
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsNomTiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (devisEnteteVentes.dvsTiersRegroupe is not null or devisEnteteVentes.dvsTiersRegroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and devisEnteteVentes.dvsTiersRegroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsAnal2 like '" + this.parc + "%'";
      }

      if (this.marque != null && !this.marque.isEmpty()) {
         this.var_filtre = this.var_filtre + " Marque = " + this.marque;
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsAnal2 like '%" + this.marque + "%'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsCat='" + this.categorie + "'";
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and devisEnteteVentes.dvsSource='" + this.source + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_devis") || this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and dvsligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and dvsligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and dvsligFamille like'" + var5[0] + "%'";
         }
      }

   }

   public void rechercheCommandeSql(String var1, String var2, String var3, String var4, Date var5, Date var6) throws HibernateException, NamingException, ParseException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         if (this.nomEtat.contains("Carnet")) {
            this.var_entete = "CARNET DE COMMANDES du " + var1 + " AU " + var2;
            this.var_requete = "bcm_date_livraison>='" + var5 + "' and bcm_date_livraison<='" + var6 + "'";
         } else {
            this.var_entete = "Liste des BC. du " + var1 + " au " + var2;
            this.var_requete = "bcm_date>='" + var3 + "' and bcm_date<='" + var4 + "'";
         }
      } else if (this.nomEtat.contains("Carnet")) {
         this.var_entete = "CARNET DE COMMANDES du " + var1 + " AU " + var2;
         this.var_requete = "bcm_date_livraison>='" + var3 + "' and bcm_date_livraison<='" + var4 + "' and bcm_serie='" + this.serie + "'";
      } else {
         this.var_entete = "Liste des BC. du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "bcm_date>='" + var3 + "' and bcm_date<='" + var4 + "' and bcm_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("101")) {
         int var7 = Integer.parseInt(this.etat);
         if (var7 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and bcm_etat=" + var7;
         } else if (var7 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and bcm_etat=" + var7;
         } else if (var7 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and bcm_etat=" + var7;
         } else if (var7 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and bcm_etat=" + var7;
         } else if (var7 == 4) {
            this.var_filtre = this.var_filtre + " Etat = Transformation patielle";
            this.var_requete = this.var_requete + " and bcm_etat=" + var7;
         } else if (var7 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Transformation totale";
            this.var_requete = this.var_requete + " and bcm_etat=" + var7;
         } else if (var7 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Relancé";
            this.var_requete = this.var_requete + " and bcm_date_relance!=null";
         } else if (var7 == 12) {
            this.var_filtre = this.var_filtre + " Etat = Promotion";
            this.var_requete = this.var_requete + " and bcm_tot_ht=0";
         } else if (var7 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and bcm_tot_reglement=0 and bcm_solde=0 ";
         } else if (var7 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and bcm_solde=1";
         } else if (var7 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and bcm_exo_tva=1";
         } else if (var7 == 16) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and bcm_tot_reglement<>0 and bcm_solde=0";
         } else if (var7 == 21) {
            this.var_filtre = this.var_filtre + " Phase Validée et initiale";
            this.var_requete = this.var_requete + " and bcmPhase=0";
         } else if (var7 == 22) {
            this.var_filtre = this.var_filtre + " Phase Validée et en cours";
            this.var_requete = this.var_requete + " and bcmPhase=1";
         } else if (var7 == 23) {
            this.var_filtre = this.var_filtre + " Phase Validée et finale";
            this.var_requete = this.var_requete + " and bcmPhase=2";
         } else if (var7 == 24) {
            this.var_filtre = this.var_filtre + " Priorite : basse";
            this.var_requete = this.var_requete + " and bcm_niveau=0";
         } else if (var7 == 25) {
            this.var_filtre = this.var_filtre + " Priorite : normale";
            this.var_requete = this.var_requete + " and bcm_niveau=1";
         } else if (var7 == 26) {
            this.var_filtre = this.var_filtre + " Priorité : urgente";
            this.var_requete = this.var_requete + " and bcm_niveau=2";
         } else if (var7 == 27) {
            this.var_filtre = this.var_filtre + " Priorité : maximale";
            this.var_requete = this.var_requete + " and bcm_niveau=3";
         } else if (var7 == 28) {
            this.var_filtre = this.var_filtre + " En cours + validée + livraison partielle + non payée";
            this.var_requete = this.var_requete + " and (bcm_etat=0 or bcm_etat=1 or bcm_etat=4) and bcm_solde=0";
         } else if (var7 == 29) {
            this.var_filtre = this.var_filtre + " Validée + livraison partielle";
            this.var_requete = this.var_requete + " and (bcm_etat=1 or bcm_etat=4)";
         } else if (this.nomEtat.contains("Carnet")) {
            this.var_filtre = this.var_filtre + " Carnet de commande Complet";
         }
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and bcm_nom_tiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (bcm_tiers_regroupe is not null and bcm_tiers_regroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and bcm_tiers_regroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.nomSigle != null && !this.nomSigle.isEmpty()) {
         this.var_filtre = this.var_filtre + " Sigle/Appartenance = " + this.nomSigle;
         this.var_requete = this.var_requete + " and cmm_tiers.tie_sigle like '" + this.nomSigle + "%'";
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         if (this.structureLog.getStrtypeContact() == 2) {
            this.var_filtre = this.var_filtre + " Destinataire = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and bcm_nom_contact='" + this.nomDestinataire + "'";
         } else {
            this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and bcm_nom_contact like '" + this.nomDestinataire + "%'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and bcm_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and bcm_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and bcm_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and bcm_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and bcm_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and bcm_anal2 like '" + this.parc + "%'";
      }

      if (this.marque != null && !this.marque.isEmpty()) {
         this.var_filtre = this.var_filtre + " Marque = " + this.marque;
         this.var_requete = this.var_requete + " and bcm_anal2 like '%" + this.marque + "%'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and bcm_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and bcm_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and bcm_service='" + this.service + "'";
      }

      String[] var18;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var18 = this.region.split(":");
         this.var_requete = this.var_requete + " and bcm_region='" + var18[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var18 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and bcm_secteur='" + var18[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var18 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and bcm_pdv='" + var18[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and bcm_cat='" + this.categorie + "'";
      }

      String var8;
      UserDao var19;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var19 = new UserDao(this.baseLog, this.utilInitHibernate);
         var8 = var19.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var8;
         this.var_requete = this.var_requete + " and bcm_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var19 = new UserDao(this.baseLog, this.utilInitHibernate);
         var8 = var19.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var8;
         this.var_requete = this.var_requete + " and bcm_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var19 = new UserDao(this.baseLog, this.utilInitHibernate);
         var8 = var19.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var8;
         this.var_requete = this.var_requete + " and bcm_id_createur=" + this.createur;
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and bcm_source='" + this.source + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_commande")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and bcmlig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and bcmlig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var18 = this.famille.split(":");
            this.var_requete = this.var_requete + " and bcmlig_famille like'" + var18[0] + "%'";
         }
      }

      if (this.nomEtat.contains("CommandePaiementCash")) {
         Session var21 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
         this.listBCPaiementCash.clear();
         new ArrayList();
         CommandeEnteteVentesDao var9 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         ReglementsDao var10 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var20 = var9.rechercheCommandeRequete(this.var_requete, var21);
         if (var20.size() != 0) {
            new CommandeEnteteVentes();

            for(int var13 = 0; var13 < var20.size(); ++var13) {
               CommandeEnteteVentes var12 = (CommandeEnteteVentes)var20.get(var13);
               if (var12.getBcmIdContact() == 0L && var12.getBcmNomContact() != null && !var12.getBcmNomContact().isEmpty()) {
                  double var14 = 0.0D;
                  String var16 = "rglDateReg>='" + this.utilDate.dateToStringSQLLight(this.filtreDateDebut) + "' and rglDateReg<='" + this.utilDate.dateToStringSQLLight(this.filtreDateFin) + "' and rglNatureDoc = 22 and rglIdDocument = " + var12.getBcmId();
                  List var11 = var10.rechercheReglementsRequete(var16, var21);
                  if (var11.size() != 0) {
                     for(int var17 = 0; var17 < var11.size(); ++var17) {
                        var14 += ((Reglements)var11.get(var17)).getRglRecette() - ((Reglements)var11.get(var17)).getRglDepense();
                     }
                  }

                  var12.setBcmNomContact(var12.getBcmTiersRegroupe());
                  if (var12.getBcmTiersRegroupe() == null || var12.getBcmTiersRegroupe().isEmpty()) {
                     var12.setBcmNomContact("ERREUR N° " + var12.getBcmNum());
                  }

                  var12.setBcmTotReglement(var14);
                  this.listBCPaiementCash.add(var12);
               }
            }
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void rechercheCommandeHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des BC du " + var1 + " au " + var2;
         this.var_requete = "commandeEnteteVentes.bcmDate>='" + var3 + "' and commandeEnteteVentes.bcmDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des BC du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "commandeEnteteVentes.bcmDate>='" + var3 + "' and commandeEnteteVentes.bcmDate<='" + var4 + "' and commandeEnteteVentes.bcmSerie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("101")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmEtat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmEtat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmEtat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmEtat=" + var5;
         } else if (var5 == 4) {
            this.var_filtre = this.var_filtre + " Etat = Transformation patielle";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmEtat=" + var5;
         } else if (var5 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Transformation totale";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmEtat=" + var5;
         } else if (var5 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Relancé";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmDateRelance!=null";
         } else if (var5 == 12) {
            this.var_filtre = this.var_filtre + " Etat = Promotion";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmTotHt=0";
         } else if (var5 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmTotReglement=0 and commandeEnteteVentes.bcmSolde=0 ";
         } else if (var5 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmSolde=1";
         } else if (var5 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmExoTva=1";
         } else if (var5 == 16) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmTotReglement<>0 and commandeEnteteVentes.bcmSolde=0";
         } else if (var5 == 21) {
            this.var_filtre = this.var_filtre + " Phase Validée et initiale";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmPhase=0";
         } else if (var5 == 22) {
            this.var_filtre = this.var_filtre + " Phase Validée et en cours";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmPhase=1";
         } else if (var5 == 23) {
            this.var_filtre = this.var_filtre + " Phase Validée et finale";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmPhase=2";
         } else if (var5 == 24) {
            this.var_filtre = this.var_filtre + " Priorite : basse";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmNiveau=0";
         } else if (var5 == 25) {
            this.var_filtre = this.var_filtre + " Priorite : normale";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmNiveau=1";
         } else if (var5 == 26) {
            this.var_filtre = this.var_filtre + " Priorité : urgente";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmNiveau=2";
         } else if (var5 == 27) {
            this.var_filtre = this.var_filtre + " Priorité : maximale";
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmNiveau=3";
         } else if (var5 == 28) {
            this.var_filtre = this.var_filtre + " En cours + validée + livraison partielle + non payée";
            this.var_requete = this.var_requete + " and (commandeEnteteVentes.bcmEtat=0 or commandeEnteteVentes.bcmEtat=1 or commandeEnteteVentes.bcmEtat=4) and commandeEnteteVentes.bcmSolde=0";
         } else if (var5 == 29) {
            this.var_filtre = this.var_filtre + " Validée + livraison partielle";
            this.var_requete = this.var_requete + " and (commandeEnteteVentes.bcmEtat=1 or commandeEnteteVentes.bcmEtat=4)";
         }
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmNomTiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (commandeEnteteVentes.bcmTiersRegroupe is not null or commandeEnteteVentes.bcmTiersRegroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmTiersRegroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmAnal2 like '" + this.parc + "%'";
      }

      if (this.marque != null && !this.marque.isEmpty()) {
         this.var_filtre = this.var_filtre + " Marque = " + this.marque;
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmAnal2 like '%" + this.marque + "%'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmService='" + this.service + "'";
      }

      String[] var12;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var12 = this.region.split(":");
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmRegion='" + var12[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var12 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmSecteur='" + var12[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var12 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmPdv='" + var12[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmCat='" + this.categorie + "'";
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmSource='" + this.source + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_commande") || this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and bcmligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and bcmligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var12 = this.famille.split(":");
            this.var_requete = this.var_requete + " and bcmligFamille like'" + var12[0] + "%'";
         }
      }

      if (this.nomEtat.contains("ProduitResteALivrer") || this.nomEtat.contains("ProduitResteALivrerDetaille")) {
         Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         this.listReliquatCmd.clear();
         new ArrayList();
         CommandeLigneVentesDao var7 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
         DocumentTraceVentesDao var8 = new DocumentTraceVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         this.lesTracabilites = new ArrayList();
         this.lesLivraisons = new ArrayList();
         this.lesLivraisonsTmp = new ArrayList();
         this.livraisonEnteteVentes = new LivraisonEnteteVentes();
         this.livraisonLigneVentes = new LivraisonLigneVentes();
         this.livraisonEnteteVentesDao = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         this.livraisonLigneVentesDao = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
         this.commandeLigneVentes = new CommandeLigneVentes();
         new CommandeEnteteVentes();
         this.documentTraceVentes = new DocumentTraceVentes();
         List var6 = var7.rechercheCommandeRequete(this.var_requete, var13);
         if (var6.size() != 0) {
            for(int var11 = 0; var11 < var6.size(); ++var11) {
               this.commandeLigneVentes = (CommandeLigneVentes)var6.get(var11);
               CommandeEnteteVentes var10 = this.commandeLigneVentes.getCommandeEnteteVentes();
               List var9 = var8.chargerLesDocumentsTrace(var10.getBcmId(), 22, var13);
               this.miseAJourReliquat(var10, this.commandeLigneVentes, var9, var13);
            }
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void miseAJourReliquat(CommandeEnteteVentes var1, CommandeLigneVentes var2, List var3, Session var4) throws HibernateException, NamingException {
      if (var1 != null) {
         this.lesTracabilites.clear();
         int var5;
         if (var3.size() != 0) {
            for(var5 = 0; var5 < var3.size(); ++var5) {
               this.documentTraceVentes = (DocumentTraceVentes)var3.get(var5);
               if (this.documentTraceVentes.getDoctraDstType() == 23) {
                  this.lesTracabilites.add(this.documentTraceVentes);
               }
            }
         }

         if (this.lesTracabilites.size() != 0) {
            this.lesLivraisons.clear();
            this.lesLivraisonsTmp.clear();

            for(var5 = 0; var5 < this.lesTracabilites.size(); ++var5) {
               this.documentTraceVentes = (DocumentTraceVentes)this.lesTracabilites.get(var5);
               this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.pourParapheur(this.documentTraceVentes.getDoctraDstId(), var4);
               if (this.livraisonEnteteVentes != null) {
                  this.lesLivraisonsTmp = this.livraisonLigneVentesDao.chargerLesLignes(this.livraisonEnteteVentes, var4);
                  if (this.lesLivraisonsTmp.size() != 0) {
                     for(int var6 = 0; var6 < this.lesLivraisonsTmp.size(); ++var6) {
                        this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLivraisonsTmp.get(var6);
                        if (this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty() && this.livraisonLigneVentes.getBlvligDepot() != null && !this.livraisonLigneVentes.getBlvligDepot().isEmpty()) {
                           this.lesLivraisons.add(this.livraisonLigneVentes);
                        }
                     }
                  }
               }
            }

            if (this.lesLivraisons.size() != 0) {
               float var8 = 0.0F;
               String var9 = "";

               for(int var7 = 0; var7 < this.lesLivraisons.size(); ++var7) {
                  this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLivraisons.get(var7);
                  if (this.livraisonLigneVentes.getBlvligIdBcm() == var2.getBcmligId()) {
                     var8 += this.livraisonLigneVentes.getBlvligQteUtil();
                     var9 = var9 + this.livraisonEnteteVentes.getBlvNum() + " ";
                  } else if ((this.structureLog.getStrid() >= 42L && this.structureLog.getStrid() <= 45L || this.structureLog.getStrid() == 53L) && this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty() && var2.getBcmligCode() != null && !var2.getBcmligCode().isEmpty() && this.livraisonLigneVentes.getBlvligCode().equals(var2.getBcmligCode())) {
                     var8 += this.livraisonLigneVentes.getBlvligQteUtil();
                     var9 = var9 + this.livraisonEnteteVentes.getBlvNum() + " ";
                  }
               }

               if (var2.getBcmligCode() != null && !var2.getBcmligCode().isEmpty() && var2.getBcmligDepot() != null && !var2.getBcmligDepot().isEmpty()) {
                  var2.setBcmligQte(var2.getBcmligQteUtil());
                  var2.setBcmligQteLivree(var8);
                  var2.setBcmligDescription("" + this.utilDate.dateToStringFr(this.livraisonEnteteVentes.getBlvDate()));
                  var2.setBcmligDepot("BL N° " + var9);
                  var2.setBcmligReference(var1.getBcmNum());
                  if (var2.getBcmligQte() != var2.getBcmligQteLivree()) {
                     this.listReliquatCmd.add(var2);
                  }
               }
            }
         } else {
            var2.setBcmligQteLivree(0.0F);
            var2.setBcmligReference(var1.getBcmNum());
            if (var2.getBcmligCode() != null && !var2.getBcmligCode().isEmpty() && var2.getBcmligDepot() != null && !var2.getBcmligDepot().isEmpty()) {
               this.listReliquatCmd.add(var2);
            }
         }
      }

   }

   public void rechercheLivraisonSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Livraisons du " + var1 + " au " + var2;
         this.var_requete = "blv_date>='" + var3 + "' and blv_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Livraisons du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "blv_date>='" + var3 + "' and blv_date<='" + var4 + "' and blv_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("101")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and blv_etat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and blv_etat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and blv_etat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and blv_etat=" + var5;
         } else if (var5 == 4) {
            this.var_filtre = this.var_filtre + " Etat = Facturation patielle";
            this.var_requete = this.var_requete + " and blv_etat=" + var5;
         } else if (var5 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Facturation totale";
            this.var_requete = this.var_requete + " and blv_etat=" + var5;
         } else if (var5 == 30) {
            this.var_filtre = this.var_filtre + " Etat = BL non livré";
            this.var_requete = this.var_requete + " and blv_livree_etat = 0";
         } else if (var5 == 31) {
            this.var_filtre = this.var_filtre + " Etat = BL livré partiellement";
            this.var_requete = this.var_requete + " and blv_livree_etat = 1";
         } else if (var5 == 32) {
            this.var_filtre = this.var_filtre + " Etat = BL livré totalement";
            this.var_requete = this.var_requete + " and blv_livree_etat = 2";
         } else if (var5 == 33) {
            this.var_filtre = this.var_filtre + " Etat = BL validée et non facturée";
            this.var_requete = this.var_requete + " and blv_etat = 1";
         }
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and blv_nom_tiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (blv_tiers_regroupe is not null or blv_tiers_regroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and blv_tiers_regroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.nomSigle != null && !this.nomSigle.isEmpty()) {
         this.var_filtre = this.var_filtre + " Sigle/Appartenance = " + this.nomSigle;
         this.var_requete = this.var_requete + " and cmm_tiers.tie_sigle like '" + this.nomSigle + "%'";
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         if (this.structureLog.getStrtypeContact() == 2) {
            this.var_filtre = this.var_filtre + " Destinataire = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and blv_nom_contact='" + this.nomDestinataire + "'";
         } else {
            this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and blv_nom_contact like '" + this.nomDestinataire + "%'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and blv_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and blv_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and blv_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and blv_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and blv_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and blv_anal2 like '" + this.parc + "%'";
      }

      if (this.marque != null && !this.marque.isEmpty()) {
         this.var_filtre = this.var_filtre + " MArque = " + this.marque;
         this.var_requete = this.var_requete + " and blv_anal2 like '%" + this.marque + "%'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and blv_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and blv_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and blv_service='" + this.service + "'";
      }

      String[] var7;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var7 = this.region.split(":");
         this.var_requete = this.var_requete + " and blv_region='" + var7[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var7 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and blv_secteur='" + var7[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var7 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and blv_pdv='" + var7[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and blv_cat='" + this.categorie + "'";
      }

      String var6;
      UserDao var8;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and blv_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var6;
         this.var_requete = this.var_requete + " and blv_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and blv_id_createur=" + this.createur;
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and blv_source='" + this.source + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_livraison")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and blvlig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and blvlig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var7 = this.famille.split(":");
            this.var_requete = this.var_requete + " and blvlig_famille like'" + var7[0] + "%'";
         }

         if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
            this.var_filtre = this.var_filtre + " dépôt = " + this.depot;
            var7 = this.depot.split(":");
            this.var_requete = this.var_requete + " and blvlig_depot='" + var7[0] + "'";
         }
      }

   }

   public void rechercheLivraisonHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Livraisons du " + var1 + " au " + var2;
         this.var_requete = "livraisonEnteteVentes.blvDate>='" + var3 + "' and livraisonEnteteVentes.blvDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Livraisons du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "livraisonEnteteVentes.blvDate>='" + var3 + "' and livraisonEnteteVentes.blvDate<='" + var4 + "' and livraisonEnteteVentes.blvSerie='" + this.serie + "'";
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvNomTiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (livraisonEnteteVentes.blvTiersRegroupe is not null or livraisonEnteteVentes.blvTiersRegroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and bcm_tiers_regroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvAnal2 like '" + this.parc + "%'";
      }

      if (this.marque != null && !this.marque.isEmpty()) {
         this.var_filtre = this.var_filtre + " Marque = " + this.marque;
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvAnal2 like '%" + this.marque + "%'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvCat='" + this.categorie + "'";
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvSource='" + this.source + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_livraison") || this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and blvligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and blvligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and blvligFamille like'" + var5[0] + "%'";
         }

         if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
            this.var_filtre = this.var_filtre + " dépôt = " + this.depot;
            var5 = this.depot.split(":");
            this.var_requete = this.var_requete + " and blvligDepot='" + var5[0] + "'";
         }
      }

      if (this.nomEtat.contains("Reliquat")) {
         Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         this.listReliquat.clear();
         this.livraisonLigneVentesDao = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
         LivraisonLivreeVentesDao var6 = new LivraisonLivreeVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var7 = this.livraisonLigneVentesDao.rechercheLivraisonRequete(this.var_requete, var10);
         if (var7.size() != 0) {
            for(int var8 = 0; var8 < var7.size(); ++var8) {
               this.livraisonLigneVentes = (LivraisonLigneVentes)var7.get(var8);
               float var9 = var6.chargerLesLignesLivree(this.livraisonLigneVentes, var10);
               this.livraisonLigneVentes.setVar_qteDejaLiv(var9);
               this.livraisonLigneVentes.setVar_qteReliquat(this.livraisonLigneVentes.getBlvligQte() - this.livraisonLigneVentes.getVar_qteDejaLiv());
               this.listReliquat.add(this.livraisonLigneVentes);
            }
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void rechercheRetourSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Retours du " + var1 + " au " + var2;
         this.var_requete = "brt_date>='" + var3 + "' and brt_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Retours du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "brt_date>='" + var3 + "' and brt_date<='" + var4 + "' and brt_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("101")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and brt_etat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and brt_etat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and brt_etat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and brt_etat=" + var5;
         } else if (var5 == 4) {
            this.var_filtre = this.var_filtre + " Etat = Transformation patielle";
            this.var_requete = this.var_requete + " and brt_etat=" + var5;
         } else if (var5 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Transformation totale";
            this.var_requete = this.var_requete + " and brt_etat=" + var5;
         }
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and brt_nom_tiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (brt_tiers_regroupe is not null or brt_tiers_regroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and brt_tiers_regroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.nomSigle != null && !this.nomSigle.isEmpty()) {
         this.var_filtre = this.var_filtre + " Sigle/Appartenance = " + this.nomSigle;
         this.var_requete = this.var_requete + " and cmm_tiers.tie_sigle like '" + this.nomSigle + "%'";
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         if (this.structureLog.getStrtypeContact() == 2) {
            this.var_filtre = this.var_filtre + " Destinataire = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and brt_nom_contact='" + this.nomDestinataire + "'";
         } else {
            this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and brt_nom_contact like '" + this.nomDestinataire + "%'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and brt_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and brt_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and brt_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and brt_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and brt_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and brt_anal2 like '" + this.parc + "%'";
      }

      if (this.marque != null && !this.marque.isEmpty()) {
         this.var_filtre = this.var_filtre + " Marque = " + this.marque;
         this.var_requete = this.var_requete + " and brt_anal2 like '%" + this.marque + "%'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and brt_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and brt_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and brt_service='" + this.service + "'";
      }

      String[] var7;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var7 = this.region.split(":");
         this.var_requete = this.var_requete + " and brt_region='" + var7[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var7 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and brt_secteur='" + var7[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var7 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and brt_pdv='" + var7[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and brt_cat='" + this.categorie + "'";
      }

      String var6;
      UserDao var8;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and brt_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var6;
         this.var_requete = this.var_requete + " and brt_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and brt_id_createur=" + this.createur;
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and brt_source='" + this.source + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_retour")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and brtlig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and brtlig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var7 = this.famille.split(":");
            this.var_requete = this.var_requete + " and brtlig_famille like'" + var7[0] + "%'";
         }
      }

   }

   public void rechercheRetourHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Retours du " + var1 + " au " + var2;
         this.var_requete = "retourEnteteVentes.brtDate>='" + var3 + "' and retourEnteteVentes.brtDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Retours du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "retourEnteteVentes.brtDate>='" + var3 + "' and retourEnteteVentes.brtDate<='" + var4 + "' and retourEnteteVentes.brtSerie='" + this.serie + "'";
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtNomTiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (retourEnteteVentes.brtTiersRegroupe is not null or retourEnteteVentes.brtTiersRegroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and retourEnteteVentes.brtTiersRegroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtAnal2 like '" + this.parc + "%'";
      }

      if (this.marque != null && !this.marque.isEmpty()) {
         this.var_filtre = this.var_filtre + " Marque = " + this.marque;
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtAnal2 like '%" + this.marque + "%'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtCat='" + this.categorie + "'";
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and retourEnteteVentes.brtSource='" + this.source + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_retour") || this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and brtligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and brtligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and brtligFamille like'" + var5[0] + "%'";
         }
      }

   }

   public void rechercheFactureSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Factures du " + var1 + " au " + var2;
         this.var_requete = "fac_date>='" + var3 + "' and fac_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Factures du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "fac_date>='" + var3 + "' and fac_date<='" + var4 + "' and fac_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("101")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and fac_etat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and fac_etat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and fac_etat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and fac_etat=" + var5;
         } else if (var5 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Relancé";
            this.var_requete = this.var_requete + " and fac_date_relance!=null";
         } else if (var5 == 12) {
            this.var_filtre = this.var_filtre + " Etat = Promotion";
            this.var_requete = this.var_requete + " and fac_tot_ht=0";
         } else if (var5 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and fac_solde=0";
         } else if (var5 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and fac_solde=1";
         } else if (var5 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and fac_exo_tva=1";
         } else if (var5 == 16) {
            this.var_filtre = this.var_filtre + " Etat = Attente de visa";
            this.var_requete = this.var_requete + " and fac_date_visa=null";
         } else if (var5 == 17) {
            this.var_filtre = this.var_filtre + " Trf = Transféré en compta";
            this.var_requete = this.var_requete + " and fac_date_transfert!=null";
         } else if (var5 == 18) {
            this.var_filtre = this.var_filtre + " Trf = Non transféré en compta";
            this.var_requete = this.var_requete + " and fac_date_transfert=null";
         }
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and fac_nom_tiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (fac_tiers_regroupe is not null or fac_tiers_regroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and fac_tiers_regroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.nomSigle != null && !this.nomSigle.isEmpty()) {
         this.var_filtre = this.var_filtre + " Sigle/Appartenance = " + this.nomSigle;
         this.var_requete = this.var_requete + " and cmm_tiers.tie_sigle like '" + this.nomSigle + "%'";
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         if (this.structureLog.getStrtypeContact() == 2) {
            this.var_filtre = this.var_filtre + " Destinataire = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and fac_nom_contact='" + this.nomDestinataire + "'";
         } else {
            this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and fac_nom_contact like '" + this.nomDestinataire + "%'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and fac_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and fac_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and fac_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and fac_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and fac_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and fac_anal2 like '" + this.parc + "%'";
      }

      if (this.marque != null && !this.marque.isEmpty()) {
         this.var_filtre = this.var_filtre + " Marque = " + this.marque;
         this.var_requete = this.var_requete + " and fac_anal2 like '%" + this.marque + "%'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and fac_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and fac_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and fac_service='" + this.service + "'";
      }

      String[] var7;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var7 = this.region.split(":");
         this.var_requete = this.var_requete + " and fac_region='" + var7[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var7 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and fac_secteur='" + var7[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var7 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and fac_pdv='" + var7[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and fac_cat='" + this.categorie + "'";
      }

      String var6;
      UserDao var8;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and fac_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var6;
         this.var_requete = this.var_requete + " and fac_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and fac_id_createur=" + this.createur;
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and fac_source='" + this.source + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_facture")) {
         this.var_requete = this.var_requete + " and faclig_code<>'-'";
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and faclig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and faclig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var7 = this.famille.split(":");
            this.var_requete = this.var_requete + " and faclig_famille like '" + var7[0] + "%'";
         }

         if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
            this.var_filtre = this.var_filtre + " dépôt = " + this.depot;
            var7 = this.depot.split(":");
            this.var_requete = this.var_requete + " and faclig_depot='" + var7[0] + "'";
         }
      }

   }

   public void rechercheFactureHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Factures du " + var1 + " au " + var2;
         this.var_requete = "factureEnteteVentes.facDate>='" + var3 + "' and factureEnteteVentes.facDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Factures du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "factureEnteteVentes.facDate>='" + var3 + "' and factureEnteteVentes.facDate<='" + var4 + "' and factureEnteteVentes.facSerie='" + this.serie + "'";
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and factureEnteteVentes.facNomTiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (factureEnteteVentes.facTiersTegroupe is not null or factureEnteteVentes.facTiersRegroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and factureEnteteVentes.facTiersRegroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and factureEnteteVentes.facActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and factureEnteteVentes.facActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and factureEnteteVentes.facActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and factureEnteteVentes.facActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and factureEnteteVentes.facAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and factureEnteteVentes.facAnal2 like '" + this.parc + "%'";
      }

      if (this.marque != null && !this.marque.isEmpty()) {
         this.var_filtre = this.var_filtre + " Marque = " + this.marque;
         this.var_requete = this.var_requete + " and factureEnteteVentes.facAnal2 like '%" + this.marque + "%'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and factureEnteteVentes.facSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and factureEnteteVentes.facDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and factureEnteteVentes.facService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and factureEnteteVentes.facRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and factureEnteteVentes.facSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and factureEnteteVentes.facPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and factureEnteteVentes.facCat='" + this.categorie + "'";
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and factureEnteteVentes.facSource='" + this.source + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_facture") || this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and facligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and facligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and facligFamille like'" + var5[0] + "%'";
         }

         if (this.nomEtat.contains("DepotVente")) {
            this.lesLignesFacture = new ArrayList();
            new ArrayList();
            ProduitsFournisseurDao var6 = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
            List var12 = var6.selectAllProduitsFour();
            new ArrayList();
            FactureLigneVentesDao var8 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
            List var7 = var8.rechercheFactureRequete(this.var_requete, (Session)null);
            if (var7.size() != 0 && var12.size() != 0) {
               new FactureLigneVentes();

               for(int var10 = 0; var10 < var7.size(); ++var10) {
                  FactureLigneVentes var9 = (FactureLigneVentes)var7.get(var10);
                  if (var9.getFacligCode() != null && !var9.getFacligCode().isEmpty()) {
                     for(int var11 = 0; var11 < var12.size(); ++var11) {
                        if (var9.getFacligCode().equals(((ProduitsFournisseur)var12.get(var11)).getProduits().getProCode()) && ((ProduitsFournisseur)var12.get(var11)).getTiers().getTienomfamille() != null && !((ProduitsFournisseur)var12.get(var11)).getTiers().getTienomfamille().isEmpty() && ((ProduitsFournisseur)var12.get(var11)).getTiers().getTienomfamille().equalsIgnoreCase("Depot/vente")) {
                           var9.setCom_nomTiers(((ProduitsFournisseur)var12.get(var11)).getTiers().getTieraisonsocialenom());
                           this.lesLignesFacture.add(var9);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void rechercheAvoirSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Avoirs du " + var1 + " au " + var2;
         this.var_requete = "avr_date>='" + var3 + "' and avr_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Avoirs du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "avr_date>='" + var3 + "' and avr_date<='" + var4 + "' and avr_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("101")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and avr_etat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and avr_etat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and avr_etat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and avr_etat=" + var5;
         } else if (var5 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Relancé";
            this.var_requete = this.var_requete + " and avr_date_relance!=null";
         } else if (var5 == 12) {
            this.var_filtre = this.var_filtre + " Etat = Promotion";
            this.var_requete = this.var_requete + " and avr_tot_ht=0";
         } else if (var5 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and avr_solde=0";
         } else if (var5 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and avr_solde=1";
         } else if (var5 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and avr_exo_tva=1";
         } else if (var5 == 16) {
            this.var_filtre = this.var_filtre + " Etat = Attente de visa";
            this.var_requete = this.var_requete + " and avr_date_visa=null";
         } else if (var5 == 17) {
            this.var_filtre = this.var_filtre + " Trf = Transféré en compta";
            this.var_requete = this.var_requete + " and avr_date_transfert!=null";
         } else if (var5 == 18) {
            this.var_filtre = this.var_filtre + " Trf = Non transféré en compta";
            this.var_requete = this.var_requete + " and avr_date_transfert=null";
         }
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and avr_nom_tiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (avr_tiers_regroupe is not null or avr_tiers_regroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and avr_tiers_regroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.nomSigle != null && !this.nomSigle.isEmpty()) {
         this.var_filtre = this.var_filtre + " Sigle/Appartenance = " + this.nomSigle;
         this.var_requete = this.var_requete + " and cmm_tiers.tie_sigle like '" + this.nomSigle + "%'";
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         if (this.structureLog.getStrtypeContact() == 2) {
            this.var_filtre = this.var_filtre + " Destinataire = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and avr_nom_contact='" + this.nomDestinataire + "'";
         } else {
            this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and avr_nom_contact like '" + this.nomDestinataire + "%'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and avr_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and avr_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and avr_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and avr_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and avr_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and avr_anal2 like '" + this.parc + "%'";
      }

      if (this.marque != null && !this.marque.isEmpty()) {
         this.var_filtre = this.var_filtre + " Marque = " + this.marque;
         this.var_requete = this.var_requete + " and avr_anal2 like '%" + this.marque + "%'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and avr_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and avr_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and avr_service='" + this.service + "'";
      }

      String[] var7;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var7 = this.region.split(":");
         this.var_requete = this.var_requete + " and avr_region='" + var7[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var7 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and avr_secteur='" + var7[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var7 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and avr_pdv='" + var7[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and avr_cat='" + this.categorie + "'";
      }

      String var6;
      UserDao var8;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and avr_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var6;
         this.var_requete = this.var_requete + " and avr_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and avr_id_createur=" + this.createur;
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and avr_source='" + this.source + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_avoir")) {
         this.var_requete = this.var_requete + " and avrlig_code<>'-'";
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and avrlig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and avrlig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var7 = this.famille.split(":");
            this.var_requete = this.var_requete + " and avrlig_famille like '" + var7[0] + "%'";
         }
      }

   }

   public void rechercheAvoirHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Avoirs du " + var1 + " au " + var2;
         this.var_requete = "avoirEnteteVentes.avrDate>='" + var3 + "' and avoirEnteteVentes.avrDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Avoirs du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "avoirEnteteVentes.avrDate>='" + var3 + "' and avoirEnteteVentes.avrDate<='" + var4 + "' and avoirEnteteVentes.avrSerie='" + this.serie + "'";
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrNomTiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (avoirEnteteVentes.avrTiersRegroupe is not null or avoirEnteteVentes.avrTiersRegroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and avoirEnteteVentes.avrTiersRegroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrAnal2 like '" + this.parc + "%'";
      }

      if (this.marque != null && !this.marque.isEmpty()) {
         this.var_filtre = this.var_filtre + " Marque = " + this.marque;
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrAnal2 like '%" + this.marque + "%'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrCat='" + this.categorie + "'";
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and avoirEnteteVentes.avrSource='" + this.source + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_avoir") || this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and avrligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and avrligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and avrligFamille like'" + var5[0] + "%'";
         }
      }

   }

   public void rechercheNoteDebitSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Notes de débit du " + var1 + " au " + var2;
         this.var_requete = "ndb_date>='" + var3 + "' and ndb_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Notes de débit du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "ndb_date>='" + var3 + "' and ndb_date<='" + var4 + "' and ndb_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("101")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and ndb_etat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and ndb_etat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and ndb_etat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and ndb_etat=" + var5;
         } else if (var5 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Relancé";
            this.var_requete = this.var_requete + " and ndb_date_relance!=null";
         } else if (var5 == 12) {
            this.var_filtre = this.var_filtre + " Etat = Promotion";
            this.var_requete = this.var_requete + " and ndb_tot_ht=0";
         } else if (var5 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and ndb_solde=0";
         } else if (var5 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and ndb_solde=1";
         } else if (var5 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and ndb_exo_tva=1";
         } else if (var5 == 16) {
            this.var_filtre = this.var_filtre + " Etat = Attente de visa";
            this.var_requete = this.var_requete + " and ndb_date_visa=null";
         } else if (var5 == 17) {
            this.var_filtre = this.var_filtre + " Trf = Transféré en compta";
            this.var_requete = this.var_requete + " and ndb_date_transfert!=null";
         } else if (var5 == 18) {
            this.var_filtre = this.var_filtre + " Trf = Non transféré en compta";
            this.var_requete = this.var_requete + " and ndb_date_transfert=null";
         }
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and ndb_nom_tiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (ndb_tiers_regroupe is not null or ndb_tiers_regroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and ndb_tiers_regroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.nomSigle != null && !this.nomSigle.isEmpty()) {
         this.var_filtre = this.var_filtre + " Sigle/Appartenance = " + this.nomSigle;
         this.var_requete = this.var_requete + " and cmm_tiers.tie_sigle like '" + this.nomSigle + "%'";
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         if (this.structureLog.getStrtypeContact() == 2) {
            this.var_filtre = this.var_filtre + " Destinataire = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and ndb_nom_contact='" + this.nomDestinataire + "'";
         } else {
            this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and ndb_nom_contact like '" + this.nomDestinataire + "%'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and ndb_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and ndb_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and ndb_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and ndb_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and ndb_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and ndb_anal2 like '" + this.parc + "%'";
      }

      if (this.marque != null && !this.marque.isEmpty()) {
         this.var_filtre = this.var_filtre + " Marque = " + this.marque;
         this.var_requete = this.var_requete + " and ndb_anal2 like '%" + this.marque + "%'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and ndb_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and ndb_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and ndb_service='" + this.service + "'";
      }

      String[] var7;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var7 = this.region.split(":");
         this.var_requete = this.var_requete + " and ndb_region='" + var7[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var7 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and ndb_secteur='" + var7[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var7 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and ndb_pdv='" + var7[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and ndb_cat='" + this.categorie + "'";
      }

      String var6;
      UserDao var8;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and ndb_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var6;
         this.var_requete = this.var_requete + " and ndb_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and ndb_id_createur=" + this.createur;
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and ndb_source='" + this.source + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_note_de_debit")) {
         this.var_requete = this.var_requete + " and ndblig_code<>'-'";
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and ndblig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and ndblig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var7 = this.famille.split(":");
            this.var_requete = this.var_requete + " and ndblig_famille like '" + var7[0] + "%'";
         }

         if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
            this.var_filtre = this.var_filtre + " dépôt = " + this.depot;
            var7 = this.depot.split(":");
            this.var_requete = this.var_requete + " and ndblig_depot='" + var7[0] + "'";
         }
      }

   }

   public void rechercheNoteDebitHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Note de débit du " + var1 + " au " + var2;
         this.var_requete = "noteDebitEnteteVentes.ndbDate>='" + var3 + "' and noteDebitEnteteVentes.ndbDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Notes de débit du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "noteDebitEnteteVentes.ndbDate>='" + var3 + "' and noteDebitEnteteVentes.ndbDate<='" + var4 + "' and noteDebitEnteteVentes.ndbSerie='" + this.serie + "'";
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbNomTiers='" + this.nomTiers + "'";
      }

      if (this.nomGroupe != null && !this.nomGroupe.isEmpty()) {
         if (this.nomGroupe.contains("*")) {
            this.var_filtre = this.var_filtre + " Tous les Groupes";
            this.var_requete = this.var_requete + " and (noteDebitEnteteVentes.ndbTiersRegroupe is not null or noteDebitEnteteVentes.ndbTiersRegroupe<>'')";
         } else {
            this.var_filtre = this.var_filtre + " Groupe = " + this.nomGroupe;
            this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbTiersRegroupe='" + this.nomGroupe + "'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbAnal2 like '" + this.parc + "%'";
      }

      if (this.marque != null && !this.marque.isEmpty()) {
         this.var_filtre = this.var_filtre + " Marque = " + this.marque;
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbAnal2 like '%" + this.marque + "%'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbCat='" + this.categorie + "'";
      }

      if (this.source != null && !this.source.isEmpty() && this.source.contains(":")) {
         this.var_filtre = this.var_filtre + " Source = " + this.source;
         this.var_requete = this.var_requete + " and noteDebitEnteteVentes.ndbSource='" + this.source + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_avoir") || this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and ndbligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and ndbligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and ndbligFamille like'" + var5[0] + "%'";
         }
      }

   }

   public void rechercheBEntreeSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Bons d'entree du " + var1 + " au " + var2;
         this.var_requete = "bin_date>='" + var3 + "' and bin_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Bons d'entrée du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "bin_date>='" + var3 + "' and bin_date<='" + var4 + "' and bin_serie='" + this.serie + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and bin_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and bin_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and bin_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and bin_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and bin_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and bin_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and bin_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and bin_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and bin_service='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and bin_region='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and bin_secteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and bin_pdv='" + var5[0] + "'";
      }

      String var6;
      UserDao var7;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and bin_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var6;
         this.var_requete = this.var_requete + " and bin_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and bin_id_createur=" + this.createur;
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_note_de_debit")) {
         this.var_requete = this.var_requete + " and binlig_code<>'-'";
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and binlig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and binlig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and binlig_famille like '" + var5[0] + "%'";
         }

         if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
            this.var_filtre = this.var_filtre + " dépôt = " + this.depot;
            var5 = this.depot.split(":");
            this.var_requete = this.var_requete + " and binlig_depot='" + var5[0] + "'";
         }
      }

   }

   public void rechercheBEntreeHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Bons d'entrée du " + var1 + " au " + var2;
         this.var_requete = "bonEntreeEntete.binDate>='" + var3 + "' and bonEntreeEntete.binDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Bons d'entrée du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "bonEntreeEntete.binDate>='" + var3 + "' and bonEntreeEntete.binDate<='" + var4 + "' and bonEntreeEntete.binSerie='" + this.serie + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and bonEntreeEntete.binActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and bonEntreeEntete.binActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and bonEntreeEntete.binActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and bonEntreeEntete.binActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and bonEntreeEntete.binAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and bonEntreeEntete.binAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and bonEntreeEntete.binSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and bonEntreeEntete.binDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and bonEntreeEntete.binService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and bonEntreeEntete.binRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and bonEntreeEntete.binSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and bonEntreeEntete.binPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and bonEntreeEntete.binCat='" + this.categorie + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and binligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and binligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and binligFamille like'" + var5[0] + "%'";
         }
      }

   }

   public void rechercheBSortieSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Bons de sortie du " + var1 + " au " + var2;
         this.var_requete = "bou_date>='" + var3 + "' and bou_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Bons de sortie du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "bou_date>='" + var3 + "' and bou_date<='" + var4 + "' and bou_serie='" + this.serie + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and bou_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and bou_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and bou_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and bou_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and bou_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and bou_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and bou_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and bou_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and bou_service='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and bou_region='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and bou_secteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and bou_pdv='" + var5[0] + "'";
      }

      String var6;
      UserDao var7;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and bou_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var6;
         this.var_requete = this.var_requete + " and bou_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and bou_id_createur=" + this.createur;
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_note_de_debit")) {
         this.var_requete = this.var_requete + " and boulig_code<>'-'";
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and boulig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and boulig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and boulig_famille like '" + var5[0] + "%'";
         }

         if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
            this.var_filtre = this.var_filtre + " dépôt = " + this.depot;
            var5 = this.depot.split(":");
            this.var_requete = this.var_requete + " and boulig_depot='" + var5[0] + "'";
         }
      }

   }

   public void rechercheBSortieHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Bons de sortie du " + var1 + " au " + var2;
         this.var_requete = "bonSortieEntete.bouDate>='" + var3 + "' and bonSortieEntete.bouDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Bons de sortie du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "bonSortieEntete.bouDate>='" + var3 + "' and bonSortieEntete.bouDate<='" + var4 + "' and bonSortieEntete.bouSerie='" + this.serie + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and bonSortieEntete.bouActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and bonSortieEntete.bouActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and bonSortieEntete.bouActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and bonSortieEntete.bouActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and bonSortieEntete.bouAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and bonSortieEntete.bouAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and bonSortieEntete.bouSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and bonSortieEntete.bouDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and bonSortieEntete.bouService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and bonSortieEntete.bouRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and bonSortieEntete.bouSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and bonSortieEntete.bouPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and bonSortieEntete.bouCat='" + this.categorie + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and bouligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and bouligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and bouligFamille like'" + var5[0] + "%'";
         }
      }

   }

   public void rechercheCessionOutSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Cessions du " + var1 + " au " + var2;
         this.var_requete = "ces_date>='" + var3 + "' and ces_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Cessions du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "ces_date>='" + var3 + "' and ces_date<='" + var4 + "' and ces_serie='" + this.serie + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and ces_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and ces_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and ces_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and ces_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and ces_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and ces_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and ces_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and ces_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and ces_service='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and ces_region='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and ces_secteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and ces_pdv='" + var5[0] + "'";
      }

      String var6;
      UserDao var7;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and ces_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var6;
         this.var_requete = this.var_requete + " and ces_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and ces_id_createur=" + this.createur;
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_note_de_debit")) {
         this.var_requete = this.var_requete + " and ceslig_code<>'-'";
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and ceslig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and ceslig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and ceslig_famille like '" + var5[0] + "%'";
         }

         if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
            this.var_filtre = this.var_filtre + " dépôt = " + this.depot;
            var5 = this.depot.split(":");
            this.var_requete = this.var_requete + " and ceslig_depot_origine='" + var5[0] + "'";
         }
      }

   }

   public void rechercheCessionOutHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Cssions du " + var1 + " au " + var2;
         this.var_requete = "cessionEntete.cesDate>='" + var3 + "' and cessionEntete.cesDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Cessions du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "cessionEntete.cesDate>='" + var3 + "' and cessionEntete.cesDate<='" + var4 + "' and cessionEntete.cesSerie='" + this.serie + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and cessionEntete.cesActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and cessionEntete.cesActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and cessionEntete.cesActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and cessionEntete.cesActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and cessionEntete.cesAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and cessionEntete.cesAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and cessionEntete.cesSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and cessionEntete.cesDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and cessionEntete.cesService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and cessionEntete.cesRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and cessionEntete.cesSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and cessionEntete.cesPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and cessionEntete.cesCat='" + this.categorie + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and cesligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and cesligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and cesligFamille like'" + var5[0] + "%'";
         }
      }

   }

   public void rechercheCessionInSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Cessions du " + var1 + " au " + var2;
         this.var_requete = "ces_date>='" + var3 + "' and ces_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Cessions du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "ces_date>='" + var3 + "' and ces_date<='" + var4 + "' and ces_serie='" + this.serie + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and ces_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and ces_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and ces_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and ces_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and ces_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and ces_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and ces_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and ces_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and ces_service='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and ces_region='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and ces_secteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and ces_pdv='" + var5[0] + "'";
      }

      String var6;
      UserDao var7;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and ces_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var6;
         this.var_requete = this.var_requete + " and ces_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and ces_id_createur=" + this.createur;
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_note_de_debit")) {
         this.var_requete = this.var_requete + " and ceslig_code<>'-'";
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and ceslig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and ceslig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and ceslig_famille like '" + var5[0] + "%'";
         }

         if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
            this.var_filtre = this.var_filtre + " dépôt = " + this.depot;
            var5 = this.depot.split(":");
            this.var_requete = this.var_requete + " and ceslig_depot_destination='" + var5[0] + "'";
         }
      }

   }

   public void rechercheCessionInHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Cessions du " + var1 + " au " + var2;
         this.var_requete = "cessionEntete.cesDate>='" + var3 + "' and cessionEntete.cesDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Cessions du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "cessionEntete.cesDate>='" + var3 + "' and cessionEntete.cesDate<='" + var4 + "' and cessionEntete.cesSerie='" + this.serie + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and cessionEntete.cesActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and cessionEntete.cesActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and cessionEntete.cesActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and cessionEntete.cesActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and cessionEntete.cesAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and cessionEntete.cesAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and cessionEntete.cesSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and cessionEntete.cesDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and cessionEntete.cesService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and cessionEntete.cesRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and cessionEntete.cesSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and cessionEntete.cesPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and cessionEntete.cesCat='" + this.categorie + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and cesligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and cesligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and cesligFamille like'" + var5[0] + "%'";
         }
      }

   }

   public String calculPeriode(Date var1) {
      String var2 = "";
      String var3 = "";
      if (var1.getDay() <= 9) {
         var3 = "0" + var1.getDay();
      } else {
         var3 = "" + var1.getDay();
      }

      String var4 = "";
      if (var1.getMonth() + 1 <= 9) {
         var4 = "0" + (var1.getMonth() + 1);
      } else {
         var4 = "" + (var1.getMonth() + 1);
      }

      if (this.filtreDateDebut.getMonth() == this.filtreDateFin.getMonth()) {
         var2 = var3 + ":" + var4;
      } else {
         var2 = var4;
      }

      return var2;
   }

   public void rechercheSynthese(String var1, String var2, String var3, String var4) throws NamingException, HibernateException, ParseException {
      this.listDocument = new ArrayList();
      double var5 = 0.0D;
      if (this.var_devis) {
         List var7;
         int var10;
         Stock var11;
         if (this.nomRepertoire.contains("ligne_")) {
            this.rechercheDevisHql(var1, var2, var3, var4);
            new ArrayList();
            DevisLigneVentesDao var8 = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
            var7 = var8.rechercheDevisRequete(this.var_requete, (Session)null);
            if (var7.size() != 0) {
               new DevisLigneVentes();

               for(var10 = 0; var10 < var7.size(); ++var10) {
                  var11 = new Stock();
                  DevisLigneVentes var9 = (DevisLigneVentes)var7.get(var10);
                  var11.setStk_type(21);
                  var11.setStk_date_mvt(var9.getDevisEnteteVentes().getDvsDate());
                  var11.setStk_divers(var9.getDevisEnteteVentes().getDvsNum());
                  var11.setStk_numero(this.calculPeriode(var9.getDevisEnteteVentes().getDvsDate()));
                  if (var9.getDevisEnteteVentes().getDvsDiversTiers() == 99) {
                     var11.setStk_tiers(var9.getDevisEnteteVentes().getDvsDiversNom());
                  } else {
                     var11.setStk_tiers(var9.getDevisEnteteVentes().getDvsNomTiers());
                  }

                  if (var9.getDevisEnteteVentes().getDvsNomCommercial() != null && !var9.getDevisEnteteVentes().getDvsNomCommercial().isEmpty()) {
                     var11.setStk_commercial(var9.getDevisEnteteVentes().getDvsNomCommercial());
                  } else {
                     var11.setStk_commercial(var9.getDevisEnteteVentes().getDvsNomResponsable());
                  }

                  var11.setStk_pv(var9.getDvsligPuRem());
                  var11.setStkPt(var9.getDvsligPt());
                  var11.setStkTva(var9.getDvsligTva());
                  var11.setStkTtc(var9.getDvsligTtc());
                  var11.setStk_pump(var9.getDvsligPump());
                  var11.setStk_pa(var11.getStkPt() - var11.getStk_pump() * (double)var9.getDvsligQte());
                  var11.setStk_qte_in(0.0F);
                  var11.setStk_qte_out(var9.getDvsligQte());
                  var11.setStk_qte(var9.getDvsligQteUtil());
                  var11.setStk_code_produit(var9.getDvsligCode());
                  var11.setStkLibelle(var9.getDvsligLibelle());
                  var11.setStkFamille(var9.getDvsligFamille());
                  var11.setStk_code_depot(var9.getDvsligDepot());
                  var11.setStk_etat("" + var9.getDevisEnteteVentes().getDvsEtat());
                  var5 += var11.getStkPt();
                  this.listDocument.add(var11);
               }
            }
         } else {
            new ArrayList();
            this.rechercheDevisSql(var1, var2, var3, var4);
            DevisEnteteVentesDao var35 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            var7 = var35.rechercheDevisRequete(this.var_requete, (Session)null);
            if (var7.size() != 0) {
               new DevisEnteteVentes();

               for(var10 = 0; var10 < var7.size(); ++var10) {
                  var11 = new Stock();
                  DevisEnteteVentes var36 = (DevisEnteteVentes)var7.get(var10);
                  var11.setStk_type(21);
                  var11.setStk_date_mvt(var36.getDvsDate());
                  var11.setStk_divers(var36.getDvsNum());
                  var11.setStk_numero(this.calculPeriode(var36.getDvsDate()));
                  if (var36.getDvsDiversTiers() == 99) {
                     var11.setStk_tiers(var36.getDvsDiversNom());
                  } else {
                     var11.setStk_tiers(var36.getDvsNomTiers());
                  }

                  if (var36.getDvsNomCommercial() != null && !var36.getDvsNomCommercial().isEmpty()) {
                     var11.setStk_commercial(var36.getDvsNomCommercial());
                  } else {
                     var11.setStk_commercial(var36.getDvsNomResponsable());
                  }

                  var11.setStkPt(var36.getDvsTotHt());
                  var11.setStkTva(var36.getDvsTotTva());
                  var11.setStkTtc(var36.getDvsTotTtc());
                  var11.setStkRabais(var36.getDvsTotReglement());
                  var11.setStk_etat("" + var36.getDvsEtat());
                  var11.setStkFamille(var36.getDvsActivite());
                  var11.setStk_code_produit(var36.getDvsCat());
                  var5 += var11.getStkPt();
                  this.listDocument.add(var11);
               }
            }
         }
      }

      double var34 = 0.0D;
      if (this.var_bc) {
         int var12;
         Stock var13;
         List var37;
         if (this.nomRepertoire.contains("ligne_")) {
            this.rechercheCommandeHql(var1, var2, var3, var4);
            new ArrayList();
            CommandeLigneVentesDao var39 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
            var37 = var39.rechercheCommandeRequete(this.var_requete, (Session)null);
            if (var37.size() != 0) {
               new CommandeLigneVentes();

               for(var12 = 0; var12 < var37.size(); ++var12) {
                  var13 = new Stock();
                  CommandeLigneVentes var41 = (CommandeLigneVentes)var37.get(var12);
                  var13.setStk_type(22);
                  var13.setStk_date_mvt(var41.getCommandeEnteteVentes().getBcmDate());
                  var13.setStk_divers(var41.getCommandeEnteteVentes().getBcmNum());
                  var13.setStk_numero(this.calculPeriode(var41.getCommandeEnteteVentes().getBcmDate()));
                  if (var41.getCommandeEnteteVentes().getBcmDiversTiers() == 99) {
                     var13.setStk_tiers(var41.getCommandeEnteteVentes().getBcmDiversNom());
                  } else {
                     var13.setStk_tiers(var41.getCommandeEnteteVentes().getBcmNomTiers());
                  }

                  if (var41.getCommandeEnteteVentes().getBcmNomCommercial() != null && !var41.getCommandeEnteteVentes().getBcmNomCommercial().isEmpty()) {
                     var13.setStk_commercial(var41.getCommandeEnteteVentes().getBcmNomCommercial());
                  } else {
                     var13.setStk_commercial(var41.getCommandeEnteteVentes().getBcmNomResponsable());
                  }

                  var13.setStk_pv(var41.getBcmligPuRem());
                  var13.setStkPt(var41.getBcmligPt());
                  var13.setStkTva(var41.getBcmligTva());
                  var13.setStkTtc(var41.getBcmligTtc());
                  var13.setStk_pump(var41.getBcmligPump());
                  var13.setStk_pa(var13.getStkPt() - var13.getStk_pump() * (double)var41.getBcmligQte());
                  var13.setStk_qte_in(0.0F);
                  var13.setStk_qte_out(var41.getBcmligQte());
                  var13.setStk_qte(var41.getBcmligQteUtil());
                  var13.setStk_code_produit(var41.getBcmligCode());
                  var13.setStkLibelle(var41.getBcmligLibelle());
                  var13.setStkFamille(var41.getBcmligFamille());
                  var13.setStk_code_depot(var41.getBcmligDepot());
                  var13.setStk_etat("" + var41.getCommandeEnteteVentes().getBcmEtat());
                  var34 += var13.getStkPt();
                  this.listDocument.add(var13);
               }
            }
         } else {
            this.rechercheCommandeSql(var1, var2, var3, var4, this.filtreDateDebut, this.filtreDateFin);
            new ArrayList();
            CommandeEnteteVentesDao var40 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            var37 = var40.rechercheCommandeRequete(this.var_requete, (Session)null);
            if (var37.size() != 0) {
               new CommandeEnteteVentes();

               for(var12 = 0; var12 < var37.size(); ++var12) {
                  var13 = new Stock();
                  CommandeEnteteVentes var42 = (CommandeEnteteVentes)var37.get(var12);
                  var13.setStk_type(22);
                  var13.setStk_date_mvt(var42.getBcmDate());
                  var13.setStk_divers(var42.getBcmNum());
                  var13.setStk_numero(this.calculPeriode(var42.getBcmDate()));
                  if (var42.getBcmDiversTiers() == 99) {
                     var13.setStk_tiers(var42.getBcmDiversNom());
                  } else {
                     var13.setStk_tiers(var42.getBcmNomTiers());
                  }

                  if (var42.getBcmNomCommercial() != null && !var42.getBcmNomCommercial().isEmpty()) {
                     var13.setStk_commercial(var42.getBcmNomCommercial());
                  } else {
                     var13.setStk_commercial(var42.getBcmNomResponsable());
                  }

                  var13.setStkPt(var42.getBcmTotHt());
                  var13.setStkTva(var42.getBcmTotTva());
                  var13.setStkTtc(var42.getBcmTotTtc());
                  var13.setStkRabais(var42.getBcmTotReglement());
                  var13.setStk_etat("" + var42.getBcmEtat());
                  var13.setStkFamille(var42.getBcmActivite());
                  var13.setStk_code_produit(var42.getBcmCat());
                  var34 += var13.getStkPt();
                  this.listDocument.add(var13);
               }
            }
         }
      }

      double var38 = 0.0D;
      double var43 = 0.0D;
      if (this.var_bl) {
         int var15;
         Stock var16;
         List var44;
         if (this.nomRepertoire.contains("ligne_")) {
            this.rechercheLivraisonHql(var1, var2, var3, var4);
            new ArrayList();
            this.livraisonLigneVentesDao = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
            var44 = this.livraisonLigneVentesDao.rechercheLivraisonRequete(this.var_requete, (Session)null);
            if (var44.size() != 0) {
               new LivraisonLigneVentes();

               for(var15 = 0; var15 < var44.size(); ++var15) {
                  var16 = new Stock();
                  LivraisonLigneVentes var14 = (LivraisonLigneVentes)var44.get(var15);
                  var16.setStk_type(23);
                  var16.setStk_date_mvt(var14.getLivraisonEnteteVentes().getBlvDate());
                  var16.setStk_divers(var14.getLivraisonEnteteVentes().getBlvNum());
                  var16.setStk_numero(this.calculPeriode(var14.getLivraisonEnteteVentes().getBlvDate()));
                  if (var14.getLivraisonEnteteVentes().getBlvDiversTiers() == 99) {
                     var16.setStk_tiers(var14.getLivraisonEnteteVentes().getBlvDiversNom());
                  } else {
                     var16.setStk_tiers(var14.getLivraisonEnteteVentes().getBlvNomTiers());
                  }

                  if (var14.getLivraisonEnteteVentes().getBlvNomCommercial() != null && !var14.getLivraisonEnteteVentes().getBlvNomCommercial().isEmpty()) {
                     var16.setStk_commercial(var14.getLivraisonEnteteVentes().getBlvNomCommercial());
                  } else {
                     var16.setStk_commercial(var14.getLivraisonEnteteVentes().getBlvNomResponsable());
                  }

                  var16.setStk_pv(var14.getBlvligPuRem());
                  var16.setStkPt(var14.getBlvligPt());
                  var16.setStkTva(var14.getBlvligTva());
                  var16.setStkTtc(var14.getBlvligTtc());
                  var16.setStk_pump(var14.getBlvligPump());
                  var16.setStk_pa(var16.getStkPt() - var16.getStk_pump() * (double)var14.getBlvligQte());
                  var16.setStk_qte_in(0.0F);
                  var16.setStk_qte_out(var14.getBlvligQte());
                  var16.setStk_qte(var14.getBlvligQteUtil());
                  var16.setStk_code_produit(var14.getBlvligCode());
                  var16.setStkLibelle(var14.getBlvligLibelle());
                  var16.setStkFamille(var14.getBlvligFamille());
                  var16.setStk_code_depot(var14.getBlvligDepot());
                  var16.setStk_etat("" + var14.getLivraisonEnteteVentes().getBlvEtat());
                  if (!var16.getStk_etat().equals("0") && !var16.getStk_etat().equals("1") && !var16.getStk_etat().equals("2") && !var16.getStk_etat().equals("3")) {
                     var43 += var16.getStkPt();
                  } else {
                     var38 += var16.getStkPt();
                  }

                  this.listDocument.add(var16);
               }
            }
         } else {
            new ArrayList();
            this.rechercheLivraisonSql(var1, var2, var3, var4);
            this.livraisonEnteteVentesDao = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            var44 = this.livraisonEnteteVentesDao.rechercheLivraisonRequete(this.var_requete, (Session)null);
            if (var44.size() != 0) {
               new LivraisonEnteteVentes();

               for(var15 = 0; var15 < var44.size(); ++var15) {
                  var16 = new Stock();
                  LivraisonEnteteVentes var46 = (LivraisonEnteteVentes)var44.get(var15);
                  var16.setStk_type(23);
                  var16.setStk_date_mvt(var46.getBlvDate());
                  var16.setStk_divers(var46.getBlvNum());
                  var16.setStk_numero(this.calculPeriode(var46.getBlvDate()));
                  if (var46.getBlvDiversTiers() == 99) {
                     var16.setStk_tiers(var46.getBlvDiversNom());
                  } else {
                     var16.setStk_tiers(var46.getBlvNomTiers());
                  }

                  if (var46.getBlvNomCommercial() != null && !var46.getBlvNomCommercial().isEmpty()) {
                     var16.setStk_commercial(var46.getBlvNomCommercial());
                  } else {
                     var16.setStk_commercial(var46.getBlvNomResponsable());
                  }

                  var16.setStkPt(var46.getBlvTotHt());
                  var16.setStkTva(var46.getBlvTotTva());
                  var16.setStkTtc(var46.getBlvTotTtc());
                  var16.setStkRabais(var46.getBlvTotReglement());
                  var16.setStk_etat("" + var46.getBlvEtat());
                  var16.setStkFamille(var46.getBlvActivite());
                  var16.setStk_code_produit(var46.getBlvCat());
                  if (!var16.getStk_etat().equals("0") && !var16.getStk_etat().equals("1") && !var16.getStk_etat().equals("2") && !var16.getStk_etat().equals("3")) {
                     var43 += var16.getStkPt();
                  } else {
                     var38 += var16.getStkPt();
                  }

                  this.listDocument.add(var16);
               }
            }
         }
      }

      double var45 = 0.0D;
      if (this.var_br) {
         int var18;
         Stock var19;
         List var47;
         if (this.nomRepertoire.contains("ligne_")) {
            this.rechercheRetourHql(var1, var2, var3, var4);
            new ArrayList();
            RetourLigneVentesDao var48 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
            var47 = var48.rechercheRetourRequete(this.var_requete, (Session)null);
            if (var47.size() != 0) {
               new RetourLigneVentes();

               for(var18 = 0; var18 < var47.size(); ++var18) {
                  var19 = new Stock();
                  RetourLigneVentes var17 = (RetourLigneVentes)var47.get(var18);
                  var19.setStk_type(24);
                  var19.setStk_date_mvt(var17.getRetourEnteteVentes().getBrtDate());
                  var19.setStk_divers(var17.getRetourEnteteVentes().getBrtNum());
                  var19.setStk_numero(this.calculPeriode(var17.getRetourEnteteVentes().getBrtDate()));
                  if (var17.getRetourEnteteVentes().getBrtDiversTiers() == 99) {
                     var19.setStk_tiers(var17.getRetourEnteteVentes().getBrtDiversNom());
                  } else {
                     var19.setStk_tiers(var17.getRetourEnteteVentes().getBrtNomTiers());
                  }

                  if (var17.getRetourEnteteVentes().getBrtNomCommercial() != null && !var17.getRetourEnteteVentes().getBrtNomCommercial().isEmpty()) {
                     var19.setStk_commercial(var17.getRetourEnteteVentes().getBrtNomCommercial());
                  } else {
                     var19.setStk_commercial(var17.getRetourEnteteVentes().getBrtNomResponsable());
                  }

                  var19.setStk_pv(var17.getBrtligPuRem() * -1.0D);
                  var19.setStkPt(var17.getBrtligPt() * -1.0D);
                  var19.setStkTva(var17.getBrtligTva() * -1.0D);
                  var19.setStkTtc(var17.getBrtligTtc() * -1.0D);
                  var19.setStk_pump(var17.getBrtligPump() * -1.0D);
                  var19.setStk_pa(var19.getStk_pv() - var19.getStk_pump() * (double)var17.getBrtligQte());
                  var19.setStk_qte_in(0.0F);
                  var19.setStk_qte_out(var17.getBrtligQte() * -1.0F);
                  var19.setStk_qte(var17.getBrtligQteUtil() * -1.0F);
                  var19.setStk_code_produit(var17.getBrtligCode());
                  var19.setStkLibelle(var17.getBrtligLibelle());
                  var19.setStkFamille(var17.getBrtligFamille());
                  var19.setStk_code_depot(var17.getBrtligDepot());
                  var19.setStk_etat("" + var17.getRetourEnteteVentes().getBrtEtat());
                  var45 += var19.getStkPt();
                  this.listDocument.add(var19);
               }
            }
         } else {
            new ArrayList();
            this.rechercheRetourSql(var1, var2, var3, var4);
            RetourEnteteVentesDao var50 = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            var47 = var50.rechercheRetourRequete(this.var_requete, (Session)null);
            if (var47.size() != 0) {
               new RetourEnteteVentes();

               for(var18 = 0; var18 < var47.size(); ++var18) {
                  var19 = new Stock();
                  RetourEnteteVentes var51 = (RetourEnteteVentes)var47.get(var18);
                  var19.setStk_type(24);
                  var19.setStk_date_mvt(var51.getBrtDate());
                  var19.setStk_divers(var51.getBrtNum());
                  var19.setStk_numero(this.calculPeriode(var51.getBrtDate()));
                  if (var51.getBrtDiversTiers() == 99) {
                     var19.setStk_tiers(var51.getBrtDiversNom());
                  } else {
                     var19.setStk_tiers(var51.getBrtNomTiers());
                  }

                  if (var51.getBrtNomCommercial() != null && !var51.getBrtNomCommercial().isEmpty()) {
                     var19.setStk_commercial(var51.getBrtNomCommercial());
                  } else {
                     var19.setStk_commercial(var51.getBrtNomResponsable());
                  }

                  var19.setStkPt(var51.getBrtTotHt() * -1.0D);
                  var19.setStkTva(var51.getBrtTotTva() * -1.0D);
                  var19.setStkTtc(var51.getBrtTotTtc() * -1.0D);
                  var19.setStkRabais(var51.getBrtTotReglement());
                  var19.setStk_etat("" + var51.getBrtEtat());
                  var19.setStkFamille(var51.getBrtActivite());
                  var19.setStk_code_produit(var51.getBrtCat());
                  var45 += var19.getStkPt();
                  this.listDocument.add(var19);
               }
            }
         }
      }

      double var49 = 0.0D;
      if (this.var_facture) {
         int var20;
         Stock var21;
         List var52;
         if (this.nomRepertoire.contains("ligne_")) {
            this.rechercheFactureHql(var1, var2, var3, var4);
            new ArrayList();
            FactureLigneVentesDao var54 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
            var52 = var54.rechercheFactureRequete(this.var_requete, (Session)null);
            if (var52.size() != 0) {
               new FactureLigneVentes();

               for(var20 = 0; var20 < var52.size(); ++var20) {
                  var21 = new Stock();
                  FactureLigneVentes var56 = (FactureLigneVentes)var52.get(var20);
                  var21.setStk_type(25);
                  var21.setStk_date_mvt(var56.getFactureEnteteVentes().getFacDate());
                  var21.setStk_divers(var56.getFactureEnteteVentes().getFacNum());
                  var21.setStk_numero(this.calculPeriode(var56.getFactureEnteteVentes().getFacDate()));
                  if (var56.getFactureEnteteVentes().getFacDiversTiers() == 99) {
                     var21.setStk_tiers(var56.getFactureEnteteVentes().getFacDiversNom());
                  } else {
                     var21.setStk_tiers(var56.getFactureEnteteVentes().getFacNomTiers());
                  }

                  if (var56.getFactureEnteteVentes().getFacNomCommercial() != null && !var56.getFactureEnteteVentes().getFacNomCommercial().isEmpty()) {
                     var21.setStk_commercial(var56.getFactureEnteteVentes().getFacNomCommercial());
                  } else {
                     var21.setStk_commercial(var56.getFactureEnteteVentes().getFacNomResponsable());
                  }

                  var21.setStk_pv(var56.getFacligPuRem());
                  var21.setStkPt(var56.getFacligPt());
                  var21.setStkTva(var56.getFacligTva());
                  var21.setStkTtc(var56.getFacligTtc());
                  var21.setStk_pump(var56.getFacligPump());
                  var21.setStk_pa(var21.getStkPt() - var21.getStk_pump() * (double)var56.getFacligQte());
                  var21.setStk_qte_in(0.0F);
                  var21.setStk_qte_out(var56.getFacligQte());
                  var21.setStk_qte(var56.getFacligQteUtil());
                  var21.setStk_code_produit(var56.getFacligCode());
                  var21.setStkLibelle(var56.getFacligLibelle());
                  var21.setStkFamille(var56.getFacligFamille());
                  var21.setStk_code_depot(var56.getFacligDepot());
                  var21.setStk_etat("" + var56.getFactureEnteteVentes().getFacEtat());
                  var49 += var21.getStkPt();
                  this.listDocument.add(var21);
               }
            }
         } else {
            new ArrayList();
            this.rechercheFactureSql(var1, var2, var3, var4);
            FactureEnteteVentesDao var55 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            var52 = var55.rechercheFactureRequete(this.var_requete, (Session)null);
            if (var52.size() != 0) {
               new FactureEnteteVentes();

               for(var20 = 0; var20 < var52.size(); ++var20) {
                  var21 = new Stock();
                  FactureEnteteVentes var57 = (FactureEnteteVentes)var52.get(var20);
                  var21.setStk_type(25);
                  var21.setStk_date_mvt(var57.getFacDate());
                  var21.setStk_divers(var57.getFacNum());
                  var21.setStk_numero(this.calculPeriode(var57.getFacDate()));
                  if (var57.getFacDiversTiers() == 99) {
                     var21.setStk_tiers(var57.getFacDiversNom());
                  } else {
                     var21.setStk_tiers(var57.getFacNomTiers());
                  }

                  if (var57.getFacNomCommercial() != null && !var57.getFacNomCommercial().isEmpty()) {
                     var21.setStk_commercial(var57.getFacNomCommercial());
                  } else {
                     var21.setStk_commercial(var57.getFacNomResponsable());
                  }

                  var21.setStkPt(var57.getFacTotHt());
                  var21.setStkTva(var57.getFacTotTva());
                  var21.setStkTtc(var57.getFacTotTtc());
                  var21.setStkRabais(var57.getFacTotReglement());
                  var21.setStk_etat("" + var57.getFacEtat());
                  var21.setStkFamille(var57.getFacActivite());
                  var21.setStk_code_produit(var57.getFacCat());
                  var21.setStkLibelle(var57.getTiers().getTieadresse());
                  if (var57.getTiers().getTiebp() != null && !var57.getTiers().getTiebp().isEmpty()) {
                     var21.setStk_code_depot(var57.getTiers().getTiebp());
                  }

                  if (var57.getTiers().getTieville() != null && !var57.getTiers().getTieville().isEmpty()) {
                     var21.setStk_code_depot(var21.getStk_code_depot() + " " + var57.getTiers().getTieville());
                  }

                  var49 += var21.getStkPt();
                  this.listDocument.add(var21);
               }
            }
         }
      }

      double var53 = 0.0D;
      if (this.var_avoir) {
         int var22;
         Stock var23;
         List var58;
         if (this.nomRepertoire.contains("ligne_")) {
            this.rechercheAvoirHql(var1, var2, var3, var4);
            new ArrayList();
            AvoirLigneVentesDao var60 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
            var58 = var60.rechercheAvoirRequete(this.var_requete, (Session)null);
            if (var58.size() != 0) {
               new AvoirLigneVentes();

               for(var22 = 0; var22 < var58.size(); ++var22) {
                  var23 = new Stock();
                  AvoirLigneVentes var62 = (AvoirLigneVentes)var58.get(var22);
                  var23.setStk_type(26);
                  var23.setStk_date_mvt(var62.getAvoirEnteteVentes().getAvrDate());
                  var23.setStk_divers(var62.getAvoirEnteteVentes().getAvrNum());
                  var23.setStk_numero(this.calculPeriode(var62.getAvoirEnteteVentes().getAvrDate()));
                  if (var62.getAvoirEnteteVentes().getAvrDiversTiers() == 99) {
                     var23.setStk_tiers(var62.getAvoirEnteteVentes().getAvrDiversNom());
                  } else {
                     var23.setStk_tiers(var62.getAvoirEnteteVentes().getAvrNomTiers());
                  }

                  if (var62.getAvoirEnteteVentes().getAvrNomCommercial() != null && !var62.getAvoirEnteteVentes().getAvrNomCommercial().isEmpty()) {
                     var23.setStk_commercial(var62.getAvoirEnteteVentes().getAvrNomCommercial());
                  } else {
                     var23.setStk_commercial(var62.getAvoirEnteteVentes().getAvrNomResponsable());
                  }

                  var23.setStk_pv(var62.getAvrligPuRem() * -1.0D);
                  var23.setStkPt(var62.getAvrligPt() * -1.0D);
                  var23.setStkTva(var62.getAvrligTva() * -1.0D);
                  var23.setStkTtc(var62.getAvrligTtc() * -1.0D);
                  var23.setStk_pump(var62.getAvrligPump() * -1.0D);
                  var23.setStk_pa(var23.getStk_pv() - var23.getStk_pump() * (double)var62.getAvrligQte());
                  var23.setStk_qte_in(0.0F);
                  var23.setStk_qte_out(var62.getAvrligQte() * -1.0F);
                  var23.setStk_qte(var62.getAvrligQteUtil() * -1.0F);
                  var23.setStk_code_produit(var62.getAvrligCode());
                  var23.setStkLibelle(var62.getAvrligLibelle());
                  var23.setStkFamille(var62.getAvrligFamille());
                  var23.setStk_code_depot(var62.getAvrligDepot());
                  var23.setStk_etat("" + var62.getAvoirEnteteVentes().getAvrEtat());
                  var53 += var23.getStkPt();
                  this.listDocument.add(var23);
               }
            }
         } else {
            new ArrayList();
            this.rechercheAvoirSql(var1, var2, var3, var4);
            AvoirEnteteVentesDao var61 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            var58 = var61.rechercheAvoirRequete(this.var_requete, (Session)null);
            if (var58.size() != 0) {
               new AvoirEnteteVentes();

               for(var22 = 0; var22 < var58.size(); ++var22) {
                  var23 = new Stock();
                  AvoirEnteteVentes var63 = (AvoirEnteteVentes)var58.get(var22);
                  var23.setStk_type(26);
                  var23.setStk_date_mvt(var63.getAvrDate());
                  var23.setStk_divers(var63.getAvrNum());
                  var23.setStk_numero(this.calculPeriode(var63.getAvrDate()));
                  if (var63.getAvrDiversTiers() == 99) {
                     var23.setStk_tiers(var63.getAvrDiversNom());
                  } else {
                     var23.setStk_tiers(var63.getAvrNomTiers());
                  }

                  if (var63.getAvrNomCommercial() != null && !var63.getAvrNomCommercial().isEmpty()) {
                     var23.setStk_commercial(var63.getAvrNomCommercial());
                  } else {
                     var23.setStk_commercial(var63.getAvrNomResponsable());
                  }

                  var23.setStkPt(var63.getAvrTotHt() * -1.0D);
                  var23.setStkTva(var63.getAvrTotTva() * -1.0D);
                  var23.setStkTtc(var63.getAvrTotTtc() * -1.0D);
                  var23.setStkRabais(var63.getAvrTotReglement());
                  var23.setStk_etat("" + var63.getAvrEtat());
                  var23.setStkFamille(var63.getAvrActivite());
                  var23.setStk_code_produit(var63.getAvrCat());
                  var23.setStkLibelle(var63.getTiers().getTieadresse());
                  if (var63.getTiers().getTiebp() != null && !var63.getTiers().getTiebp().isEmpty()) {
                     var23.setStk_code_depot(var63.getTiers().getTiebp());
                  }

                  if (var63.getTiers().getTieville() != null && !var63.getTiers().getTieville().isEmpty()) {
                     var23.setStk_code_depot(var23.getStk_code_depot() + " " + var63.getTiers().getTieville());
                  }

                  var53 += var23.getStkPt();
                  this.listDocument.add(var23);
               }
            }
         }
      }

      double var59 = 0.0D;
      if (this.var_noteDebit) {
         int var24;
         Stock var25;
         List var64;
         if (this.nomRepertoire.contains("ligne_")) {
            this.rechercheNoteDebitHql(var1, var2, var3, var4);
            new ArrayList();
            NoteDebitLigneVentesDao var66 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
            var64 = var66.rechercheNoteDebitRequete(this.var_requete, (Session)null);
            if (var64.size() != 0) {
               new NoteDebitLigneVentes();

               for(var24 = 0; var24 < var64.size(); ++var24) {
                  var25 = new Stock();
                  NoteDebitLigneVentes var68 = (NoteDebitLigneVentes)var64.get(var24);
                  var25.setStk_type(27);
                  var25.setStk_date_mvt(var68.getNoteDebitEnteteVentes().getNdbDate());
                  var25.setStk_divers(var68.getNoteDebitEnteteVentes().getNdbNum());
                  var25.setStk_numero(this.calculPeriode(var68.getNoteDebitEnteteVentes().getNdbDate()));
                  if (var68.getNoteDebitEnteteVentes().getNdbDiversTiers() == 99) {
                     var25.setStk_tiers(var68.getNoteDebitEnteteVentes().getNdbDiversNom());
                  } else {
                     var25.setStk_tiers(var68.getNoteDebitEnteteVentes().getNdbNomTiers());
                  }

                  if (var68.getNoteDebitEnteteVentes().getNdbNomCommercial() != null && !var68.getNoteDebitEnteteVentes().getNdbNomCommercial().isEmpty()) {
                     var25.setStk_commercial(var68.getNoteDebitEnteteVentes().getNdbNomCommercial());
                  } else {
                     var25.setStk_commercial(var68.getNoteDebitEnteteVentes().getNdbNomResponsable());
                  }

                  var25.setStk_pv(var68.getNdbligPuRem());
                  var25.setStkPt(var68.getNdbligPt());
                  var25.setStkTva(var68.getNdbligTva());
                  var25.setStkTtc(var68.getNdbligTtc());
                  var25.setStk_pump(var68.getNdbligPump());
                  var25.setStk_pa(var25.getStkPt() - var25.getStk_pump() * (double)var68.getNdbligQte());
                  var25.setStk_qte_in(0.0F);
                  var25.setStk_qte_out(var68.getNdbligQte());
                  var25.setStk_qte(var68.getNdbligQteUtil());
                  var25.setStk_code_produit(var68.getNdbligCode());
                  var25.setStkLibelle(var68.getNdbligLibelle());
                  var25.setStkFamille(var68.getNdbligFamille());
                  var25.setStk_code_depot(var68.getNdbligDepot());
                  var25.setStk_etat("" + var68.getNoteDebitEnteteVentes().getNdbEtat());
                  var59 += var25.getStkPt();
                  this.listDocument.add(var25);
               }
            }
         } else {
            new ArrayList();
            this.rechercheNoteDebitSql(var1, var2, var3, var4);
            NoteDebitEnteteVentesDao var67 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            var64 = var67.rechercheNoteDebitRequete(this.var_requete, (Session)null);
            if (var64.size() != 0) {
               new NoteDebitEnteteVentes();

               for(var24 = 0; var24 < var64.size(); ++var24) {
                  var25 = new Stock();
                  NoteDebitEnteteVentes var69 = (NoteDebitEnteteVentes)var64.get(var24);
                  var25.setStk_type(27);
                  var25.setStk_date_mvt(var69.getNdbDate());
                  var25.setStk_divers(var69.getNdbNum());
                  var25.setStk_numero(this.calculPeriode(var69.getNdbDate()));
                  if (var69.getNdbDiversTiers() == 99) {
                     var25.setStk_tiers(var69.getNdbDiversNom());
                  } else {
                     var25.setStk_tiers(var69.getNdbNomTiers());
                  }

                  if (var69.getNdbNomCommercial() != null && !var69.getNdbNomCommercial().isEmpty()) {
                     var25.setStk_commercial(var69.getNdbNomCommercial());
                  } else {
                     var25.setStk_commercial(var69.getNdbNomResponsable());
                  }

                  var25.setStkPt(var69.getNdbTotHt());
                  var25.setStkTva(var69.getNdbTotTva());
                  var25.setStkTtc(var69.getNdbTotTtc());
                  var25.setStkRabais(var69.getNdbTotReglement());
                  var25.setStk_etat("" + var69.getNdbEtat());
                  var25.setStkFamille(var69.getNdbActivite());
                  var25.setStk_code_produit(var69.getNdbCat());
                  var25.setStkLibelle(var69.getTiers().getTieadresse());
                  if (var69.getTiers().getTiebp() != null && !var69.getTiers().getTiebp().isEmpty()) {
                     var25.setStk_code_depot(var69.getTiers().getTiebp());
                  }

                  if (var69.getTiers().getTieville() != null && !var69.getTiers().getTieville().isEmpty()) {
                     var25.setStk_code_depot(var25.getStk_code_depot() + " " + var69.getTiers().getTieville());
                  }

                  var59 += var25.getStkPt();
                  this.listDocument.add(var25);
               }
            }
         }
      }

      double var65 = 0.0D;
      if (this.var_be) {
         int var26;
         Stock var27;
         List var70;
         if (this.nomRepertoire.contains("ligne_")) {
            this.rechercheBEntreeHql(var1, var2, var3, var4);
            new ArrayList();
            BonEntreeLigneDao var72 = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
            var70 = var72.rechercheBEntreeRequete(this.var_requete, (Session)null);
            if (var70.size() != 0) {
               new BonEntreeLigne();

               for(var26 = 0; var26 < var70.size(); ++var26) {
                  var27 = new Stock();
                  BonEntreeLigne var74 = (BonEntreeLigne)var70.get(var26);
                  var27.setStk_type(31);
                  var27.setStk_date_mvt(var74.getBonEntreeEntete().getBinDate());
                  var27.setStk_divers(var74.getBonEntreeEntete().getBinNum());
                  var27.setStk_numero(this.calculPeriode(var74.getBonEntreeEntete().getBinDate()));
                  var27.setStk_tiers("");
                  var27.setStk_commercial(var74.getBonEntreeEntete().getBinNomResponsable());
                  var27.setStk_pv(var74.getBinligPump());
                  var27.setStkTva(0.0D);
                  var27.setStkPt(var74.getBinligPump());
                  var27.setStkTtc(0.0D);
                  var27.setStk_pump(var74.getBinligPump());
                  var27.setStk_pa(0.0D);
                  var27.setStk_qte_in(var74.getBinligQte());
                  var27.setStk_qte_out(0.0F);
                  var27.setStk_qte(var74.getBinligQteUtil());
                  var27.setStk_code_produit(var74.getBinligCode());
                  var27.setStkLibelle(var74.getBinligLibelle());
                  var27.setStkFamille(var74.getBinligFamille());
                  var27.setStk_code_depot(var74.getBonEntreeEntete().getBinDepot());
                  var27.setStk_etat("" + var74.getBonEntreeEntete().getBinEtat());
                  var65 += var27.getStkPt();
                  this.listDocument.add(var27);
               }
            }
         } else {
            new ArrayList();
            this.rechercheBEntreeSql(var1, var2, var3, var4);
            BonEntreeEnteteDao var73 = new BonEntreeEnteteDao(this.baseLog, this.utilInitHibernate);
            var70 = var73.rechercheBonEntreeRequete(this.var_requete, (Session)null);
            if (var70.size() != 0) {
               new BonEntreeEntete();

               for(var26 = 0; var26 < var70.size(); ++var26) {
                  var27 = new Stock();
                  BonEntreeEntete var75 = (BonEntreeEntete)var70.get(var26);
                  var27.setStk_type(31);
                  var27.setStk_date_mvt(var75.getBinDate());
                  var27.setStk_divers(var75.getBinNum());
                  var27.setStk_numero(this.calculPeriode(var75.getBinDate()));
                  var27.setStk_tiers("");
                  var27.setStk_commercial(var75.getBinNomResponsable());
                  var27.setStkPt(var75.getBinTotPump());
                  var27.setStkTva(0.0D);
                  var27.setStkTtc(0.0D);
                  var27.setStkRabais(0.0D);
                  var27.setStk_etat("" + var75.getBinEtat());
                  var27.setStkFamille(var75.getBinActivite());
                  var27.setStk_code_produit("");
                  var65 += var27.getStkPt();
                  this.listDocument.add(var27);
               }
            }
         }
      }

      double var71 = 0.0D;
      if (this.var_bs) {
         int var28;
         Stock var29;
         List var76;
         if (this.nomRepertoire.contains("ligne_")) {
            this.rechercheBSortieHql(var1, var2, var3, var4);
            new ArrayList();
            BonSortieLigneDao var78 = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
            var76 = var78.rechercheBonSortieRequete(this.var_requete, (Session)null);
            if (var76.size() != 0) {
               new BonSortieLigne();

               for(var28 = 0; var28 < var76.size(); ++var28) {
                  var29 = new Stock();
                  BonSortieLigne var80 = (BonSortieLigne)var76.get(var28);
                  var29.setStk_type(32);
                  var29.setStk_date_mvt(var80.getBonSortieEntete().getBouDate());
                  var29.setStk_divers(var80.getBonSortieEntete().getBouNum());
                  var29.setStk_numero(this.calculPeriode(var80.getBonSortieEntete().getBouDate()));
                  var29.setStk_tiers("");
                  var29.setStk_commercial(var80.getBonSortieEntete().getBouNomResponsable());
                  var29.setStk_pv(var80.getBouligPump());
                  var29.setStkTva(0.0D);
                  var29.setStkPt(var80.getBouligPump());
                  var29.setStkTtc(0.0D);
                  var29.setStk_pump(var80.getBouligPump());
                  var29.setStk_pa(0.0D);
                  var29.setStk_qte_in(0.0F);
                  var29.setStk_qte_out(var80.getBouligQte());
                  var29.setStk_qte(var80.getBouligQteUtil());
                  var29.setStk_code_produit(var80.getBouligCode());
                  var29.setStkLibelle(var80.getBouligLibelle());
                  var29.setStkFamille(var80.getBouligFamille());
                  var29.setStk_code_depot(var80.getBonSortieEntete().getBouDepot());
                  var29.setStk_etat("" + var80.getBonSortieEntete().getBouEtat());
                  var71 += var29.getStkPt();
                  this.listDocument.add(var29);
               }
            }
         } else {
            new ArrayList();
            this.rechercheBSortieSql(var1, var2, var3, var4);
            BonSortieEnteteDao var79 = new BonSortieEnteteDao(this.baseLog, this.utilInitHibernate);
            var76 = var79.rechercheBsRequete(this.var_requete, (Session)null);
            if (var76.size() != 0) {
               new BonSortieEntete();

               for(var28 = 0; var28 < var76.size(); ++var28) {
                  var29 = new Stock();
                  BonSortieEntete var81 = (BonSortieEntete)var76.get(var28);
                  var29.setStk_type(32);
                  var29.setStk_date_mvt(var81.getBouDate());
                  var29.setStk_divers(var81.getBouNum());
                  var29.setStk_numero(this.calculPeriode(var81.getBouDate()));
                  var29.setStk_tiers("");
                  var29.setStk_commercial(var81.getBouNomResponsable());
                  var29.setStkPt(var81.getBouTotPump());
                  var29.setStkTva(0.0D);
                  var29.setStkTtc(0.0D);
                  var29.setStkRabais(0.0D);
                  var29.setStk_etat("" + var81.getBouEtat());
                  var29.setStkFamille(var81.getBouActivite());
                  var29.setStk_code_produit("");
                  var71 += var29.getStkPt();
                  this.listDocument.add(var29);
               }
            }
         }
      }

      double var77 = 0.0D;
      if (this.var_cessionOut) {
         int var30;
         Stock var31;
         List var82;
         if (this.nomRepertoire.contains("ligne_")) {
            this.rechercheCessionOutHql(var1, var2, var3, var4);
            new ArrayList();
            CessionLigneDao var84 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
            var82 = var84.rechercheCessionRequete(this.var_requete, (Session)null);
            if (var82.size() != 0) {
               new CessionLigne();

               for(var30 = 0; var30 < var82.size(); ++var30) {
                  var31 = new Stock();
                  CessionLigne var86 = (CessionLigne)var82.get(var30);
                  var31.setStk_type(33);
                  var31.setStk_date_mvt(var86.getCessionEntete().getCesDate());
                  var31.setStk_divers(var86.getCessionEntete().getCesNum());
                  var31.setStk_numero(this.calculPeriode(var86.getCessionEntete().getCesDate()));
                  var31.setStk_tiers("");
                  var31.setStk_commercial(var86.getCessionEntete().getCesNomResponsable());
                  var31.setStk_pv(var86.getCesligPump());
                  var31.setStkTva(0.0D);
                  var31.setStkPt(var86.getCesligPump());
                  var31.setStkTtc(0.0D);
                  var31.setStk_pump(var86.getCesligPump());
                  var31.setStk_pa(0.0D);
                  var31.setStk_qte_in(0.0F);
                  var31.setStk_qte_out(var86.getCesligQte());
                  var31.setStk_qte(var86.getCesligQteUtil());
                  var31.setStk_code_produit(var86.getCesligCode());
                  var31.setStkLibelle(var86.getCesligLibelle());
                  var31.setStkFamille(var86.getCesligFamille());
                  var31.setStk_code_depot(var86.getCessionEntete().getCesDepotOrigine());
                  var31.setStk_etat("" + var86.getCessionEntete().getCesEtat());
                  var77 += var31.getStkPt();
                  this.listDocument.add(var31);
               }
            }
         } else {
            new ArrayList();
            this.rechercheCessionOutSql(var1, var2, var3, var4);
            CessionEnteteDao var85 = new CessionEnteteDao(this.baseLog, this.utilInitHibernate);
            var82 = var85.rechercheCessionRequete(this.var_requete, (Session)null);
            if (var82.size() != 0) {
               new CessionEntete();

               for(var30 = 0; var30 < var82.size(); ++var30) {
                  var31 = new Stock();
                  CessionEntete var87 = (CessionEntete)var82.get(var30);
                  var31.setStk_type(33);
                  var31.setStk_date_mvt(var87.getCesDate());
                  var31.setStk_divers(var87.getCesNum());
                  var31.setStk_numero(this.calculPeriode(var87.getCesDate()));
                  var31.setStk_tiers("");
                  var31.setStk_commercial(var87.getCesNomResponsable());
                  var31.setStkPt(var87.getCesTotPump());
                  var31.setStkTva(0.0D);
                  var31.setStkTtc(0.0D);
                  var31.setStkRabais(0.0D);
                  var31.setStk_etat("" + var87.getCesEtat());
                  var31.setStkFamille(var87.getCesActivite());
                  var31.setStk_code_produit("");
                  var77 += var31.getStkPt();
                  this.listDocument.add(var31);
               }
            }
         }
      }

      double var83 = 0.0D;
      if (this.var_cessionIn) {
         int var32;
         Stock var33;
         List var88;
         if (this.nomRepertoire.contains("ligne_")) {
            this.rechercheCessionInHql(var1, var2, var3, var4);
            new ArrayList();
            CessionLigneDao var89 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
            var88 = var89.rechercheCessionRequete(this.var_requete, (Session)null);
            if (var88.size() != 0) {
               new CessionLigne();

               for(var32 = 0; var32 < var88.size(); ++var32) {
                  var33 = new Stock();
                  CessionLigne var91 = (CessionLigne)var88.get(var32);
                  var33.setStk_type(33);
                  var33.setStk_date_mvt(var91.getCessionEntete().getCesDate());
                  var33.setStk_divers(var91.getCessionEntete().getCesNum());
                  var33.setStk_numero(this.calculPeriode(var91.getCessionEntete().getCesDate()));
                  var33.setStk_tiers("");
                  var33.setStk_commercial(var91.getCessionEntete().getCesNomResponsable());
                  var33.setStk_pv(var91.getCesligPump());
                  var33.setStkTva(0.0D);
                  var33.setStkPt(var91.getCesligPump());
                  var33.setStkTtc(0.0D);
                  var33.setStk_pump(var91.getCesligPump());
                  var33.setStk_pa(0.0D);
                  var33.setStk_qte_in(var91.getCesligQte());
                  var33.setStk_qte_out(0.0F);
                  var33.setStk_qte(var91.getCesligQteUtil());
                  var33.setStk_code_produit(var91.getCesligCode());
                  var33.setStkLibelle(var91.getCesligLibelle());
                  var33.setStkFamille(var91.getCesligFamille());
                  var33.setStk_code_depot(var91.getCessionEntete().getCesDepotOrigine());
                  var33.setStk_etat("" + var91.getCessionEntete().getCesEtat());
                  var83 += var33.getStkPt();
                  this.listDocument.add(var33);
               }
            }
         } else {
            new ArrayList();
            this.rechercheCessionInSql(var1, var2, var3, var4);
            CessionEnteteDao var90 = new CessionEnteteDao(this.baseLog, this.utilInitHibernate);
            var88 = var90.rechercheCessionRequete(this.var_requete, (Session)null);
            if (var88.size() != 0) {
               new CessionEntete();

               for(var32 = 0; var32 < var88.size(); ++var32) {
                  var33 = new Stock();
                  CessionEntete var92 = (CessionEntete)var88.get(var32);
                  var33.setStk_type(33);
                  var33.setStk_date_mvt(var92.getCesDate());
                  var33.setStk_divers(var92.getCesNum());
                  var33.setStk_numero(this.calculPeriode(var92.getCesDate()));
                  var33.setStk_tiers("");
                  var33.setStk_commercial(var92.getCesNomResponsable());
                  var33.setStkPt(var92.getCesTotPump());
                  var33.setStkTva(0.0D);
                  var33.setStkTtc(0.0D);
                  var33.setStkRabais(0.0D);
                  var33.setStk_etat("" + var92.getCesEtat());
                  var33.setStkFamille(var92.getCesActivite());
                  var33.setStk_code_produit("");
                  var83 += var33.getStkPt();
                  this.listDocument.add(var33);
               }
            }
         }
      }

   }

   public void rechercheProduitSql() throws HibernateException, NamingException {
      this.var_entete = "Controle des produits VENTES";
      this.var_requete = "";
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      new ArrayList();
      new ExercicesVentes();
      ExercicesVentesDao var4 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      ExercicesVentes var3 = var4.recupererLastExo(var1);
      if (var3 != null) {
         new FamillesProduitsVentes();
         FamillesProduitsVentesDao var6 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
         ProduitsVtesDao var7 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         List var2 = var7.selectAllProduits(var1);
         if (var2.size() != 0) {
            for(int var8 = 0; var8 < var2.size(); ++var8) {
               this.produits = (Produits)var2.get(var8);
               if (this.produits.getProCode() == null || this.produits.getProCode().isEmpty()) {
                  this.produits.setCommentaire("Absence du code produit");
                  this.listProduits.add(this.produits);
               }

               if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
                  if (this.produits.getProVteNat().equals("0000")) {
                     this.produits.setCommentaire("Nature vente erronée");
                     this.listProduits.add(this.produits);
                  }
               } else {
                  this.produits.setCommentaire("Absence de la nature vente");
                  this.listProduits.add(this.produits);
               }

               if (this.produits.getProVteCode() == null && this.produits.getProVteCode().isEmpty()) {
                  this.produits.setCommentaire("Absence de la famille vente");
                  this.listProduits.add(this.produits);
               } else {
                  FamillesProduitsVentes var5 = var6.rechercheFamilleByProd(var3.getExevteId(), this.produits, var1);
                  if (var5 == null) {
                     this.produits.setCommentaire("Famille vente introuvable");
                     this.listProduits.add(this.produits);
                  }
               }
            }
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public ExercicesVentes getExoSelectionne() {
      return this.exoSelectionne;
   }

   public void setExoSelectionne(ExercicesVentes var1) {
      this.exoSelectionne = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isTestafficheLigne() {
      return this.testafficheLigne;
   }

   public void setTestafficheLigne(boolean var1) {
      this.testafficheLigne = var1;
   }

   public DataModel getDataModelImpgenFichier() {
      return this.dataModelImpgenFichier;
   }

   public void setDataModelImpgenFichier(DataModel var1) {
      this.dataModelImpgenFichier = var1;
   }

   public DataModel getDataModelImpgen() {
      return this.dataModelImpgen;
   }

   public void setDataModelImpgen(DataModel var1) {
      this.dataModelImpgen = var1;
   }

   public OptionVentes getOptionVentes() {
      return this.optionVentes;
   }

   public void setOptionVentes(OptionVentes var1) {
      this.optionVentes = var1;
   }

   public List getMesDepartementsItems() {
      return this.mesDepartementsItems;
   }

   public void setMesDepartementsItems(List var1) {
      this.mesDepartementsItems = var1;
   }

   public List getMesEtatsItems() {
      return this.mesEtatsItems;
   }

   public void setMesEtatsItems(List var1) {
      this.mesEtatsItems = var1;
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

   public List getMesSeriesItems() {
      return this.mesSeriesItems;
   }

   public void setMesSeriesItems(List var1) {
      this.mesSeriesItems = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public boolean isVar_affiche_impression() {
      return this.var_affiche_impression;
   }

   public void setVar_affiche_impression(boolean var1) {
      this.var_affiche_impression = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public DataModel getDatamodelTiers() {
      return this.datamodelTiers;
   }

   public void setDatamodelTiers(DataModel var1) {
      this.datamodelTiers = var1;
   }

   public boolean isShowModalPanelTiers() {
      return this.showModalPanelTiers;
   }

   public void setShowModalPanelTiers(boolean var1) {
      this.showModalPanelTiers = var1;
   }

   public DataModel getDatamodelProduits() {
      return this.datamodelProduits;
   }

   public void setDatamodelProduits(DataModel var1) {
      this.datamodelProduits = var1;
   }

   public boolean isShowModalPanelProduits() {
      return this.showModalPanelProduits;
   }

   public void setShowModalPanelProduits(boolean var1) {
      this.showModalPanelProduits = var1;
   }

   public boolean isVar_anal_activite() {
      return this.var_anal_activite;
   }

   public void setVar_anal_activite(boolean var1) {
      this.var_anal_activite = var1;
   }

   public boolean isVar_anal_departement() {
      return this.var_anal_departement;
   }

   public void setVar_anal_departement(boolean var1) {
      this.var_anal_departement = var1;
   }

   public boolean isVar_anal_agent() {
      return this.var_anal_agent;
   }

   public void setVar_anal_agent(boolean var1) {
      this.var_anal_agent = var1;
   }

   public boolean isVar_anal_dossier() {
      return this.var_anal_dossier;
   }

   public void setVar_anal_dossier(boolean var1) {
      this.var_anal_dossier = var1;
   }

   public boolean isVar_anal_parc() {
      return this.var_anal_parc;
   }

   public void setVar_anal_parc(boolean var1) {
      this.var_anal_parc = var1;
   }

   public boolean isVar_anal_pdv() {
      return this.var_anal_pdv;
   }

   public void setVar_anal_pdv(boolean var1) {
      this.var_anal_pdv = var1;
   }

   public boolean isVar_anal_region() {
      return this.var_anal_region;
   }

   public void setVar_anal_region(boolean var1) {
      this.var_anal_region = var1;
   }

   public boolean isVar_anal_secteur() {
      return this.var_anal_secteur;
   }

   public void setVar_anal_secteur(boolean var1) {
      this.var_anal_secteur = var1;
   }

   public boolean isVar_anal_service() {
      return this.var_anal_service;
   }

   public void setVar_anal_service(boolean var1) {
      this.var_anal_service = var1;
   }

   public boolean isVar_anal_site() {
      return this.var_anal_site;
   }

   public void setVar_anal_site(boolean var1) {
      this.var_anal_site = var1;
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

   public DataModel getDatamodelDestinataire() {
      return this.datamodelDestinataire;
   }

   public void setDatamodelDestinataire(DataModel var1) {
      this.datamodelDestinataire = var1;
   }

   public boolean isShowModalPanelDestinataire() {
      return this.showModalPanelDestinataire;
   }

   public void setShowModalPanelDestinataire(boolean var1) {
      this.showModalPanelDestinataire = var1;
   }

   public DataModel getDatamodelParc() {
      return this.datamodelParc;
   }

   public void setDatamodelParc(DataModel var1) {
      this.datamodelParc = var1;
   }

   public boolean isShowModalPanelParc() {
      return this.showModalPanelParc;
   }

   public void setShowModalPanelParc(boolean var1) {
      this.showModalPanelParc = var1;
   }

   public String getActivite() {
      return this.activite;
   }

   public void setActivite(String var1) {
      this.activite = var1;
   }

   public String getCategorie() {
      return this.categorie;
   }

   public void setCategorie(String var1) {
      this.categorie = var1;
   }

   public String getCommercial() {
      return this.commercial;
   }

   public void setCommercial(String var1) {
      this.commercial = var1;
   }

   public String getCreateur() {
      return this.createur;
   }

   public void setCreateur(String var1) {
      this.createur = var1;
   }

   public String getDepartement() {
      return this.departement;
   }

   public void setDepartement(String var1) {
      this.departement = var1;
   }

   public String getDepot() {
      return this.depot;
   }

   public void setDepot(String var1) {
      this.depot = var1;
   }

   public String getDossier() {
      return this.dossier;
   }

   public void setDossier(String var1) {
      this.dossier = var1;
   }

   public String getEtat() {
      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public String getFamille() {
      return this.famille;
   }

   public void setFamille(String var1) {
      this.famille = var1;
   }

   public Date getFiltreDateDebut() {
      return this.filtreDateDebut;
   }

   public void setFiltreDateDebut(Date var1) {
      this.filtreDateDebut = var1;
   }

   public Date getFiltreDateFin() {
      return this.filtreDateFin;
   }

   public void setFiltreDateFin(Date var1) {
      this.filtreDateFin = var1;
   }

   public String getNomDestinataire() {
      return this.nomDestinataire;
   }

   public void setNomDestinataire(String var1) {
      this.nomDestinataire = var1;
   }

   public String getNomEtat() {
      return this.nomEtat;
   }

   public void setNomEtat(String var1) {
      this.nomEtat = var1;
   }

   public String getParc() {
      return this.parc;
   }

   public void setParc(String var1) {
      this.parc = var1;
   }

   public String getNomTiers() {
      return this.nomTiers;
   }

   public void setNomTiers(String var1) {
      this.nomTiers = var1;
   }

   public String getPdv() {
      return this.pdv;
   }

   public void setPdv(String var1) {
      this.pdv = var1;
   }

   public String getRegion() {
      return this.region;
   }

   public void setRegion(String var1) {
      this.region = var1;
   }

   public String getSecteur() {
      return this.secteur;
   }

   public void setSecteur(String var1) {
      this.secteur = var1;
   }

   public String getSerie() {
      return this.serie;
   }

   public void setSerie(String var1) {
      this.serie = var1;
   }

   public String getService() {
      return this.service;
   }

   public void setService(String var1) {
      this.service = var1;
   }

   public String getSite() {
      return this.site;
   }

   public void setSite(String var1) {
      this.site = var1;
   }

   public String getNomRepertoire() {
      return this.nomRepertoire;
   }

   public void setNomRepertoire(String var1) {
      this.nomRepertoire = var1;
   }

   public String getNomSigle() {
      return this.nomSigle;
   }

   public void setNomSigle(String var1) {
      this.nomSigle = var1;
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

   public String getProduitDebut() {
      return this.produitDebut;
   }

   public void setProduitDebut(String var1) {
      this.produitDebut = var1;
   }

   public String getProduitFin() {
      return this.produitFin;
   }

   public void setProduitFin(String var1) {
      this.produitFin = var1;
   }

   public boolean isTestafficheDocument() {
      return this.testafficheDocument;
   }

   public void setTestafficheDocument(boolean var1) {
      this.testafficheDocument = var1;
   }

   public boolean isVar_avoir() {
      return this.var_avoir;
   }

   public void setVar_avoir(boolean var1) {
      this.var_avoir = var1;
   }

   public boolean isVar_bc() {
      return this.var_bc;
   }

   public void setVar_bc(boolean var1) {
      this.var_bc = var1;
   }

   public boolean isVar_bl() {
      return this.var_bl;
   }

   public void setVar_bl(boolean var1) {
      this.var_bl = var1;
   }

   public boolean isVar_br() {
      return this.var_br;
   }

   public void setVar_br(boolean var1) {
      this.var_br = var1;
   }

   public boolean isVar_devis() {
      return this.var_devis;
   }

   public void setVar_devis(boolean var1) {
      this.var_devis = var1;
   }

   public boolean isVar_facture() {
      return this.var_facture;
   }

   public void setVar_facture(boolean var1) {
      this.var_facture = var1;
   }

   public boolean isVar_noteDebit() {
      return this.var_noteDebit;
   }

   public void setVar_noteDebit(boolean var1) {
      this.var_noteDebit = var1;
   }

   public boolean isVar_bs() {
      return this.var_bs;
   }

   public void setVar_bs(boolean var1) {
      this.var_bs = var1;
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

   public String getResponsable() {
      return this.responsable;
   }

   public void setResponsable(String var1) {
      this.responsable = var1;
   }

   public boolean isVar_be() {
      return this.var_be;
   }

   public void setVar_be(boolean var1) {
      this.var_be = var1;
   }

   public boolean isVar_cessionIn() {
      return this.var_cessionIn;
   }

   public void setVar_cessionIn(boolean var1) {
      this.var_cessionIn = var1;
   }

   public boolean isVar_cessionOut() {
      return this.var_cessionOut;
   }

   public void setVar_cessionOut(boolean var1) {
      this.var_cessionOut = var1;
   }

   public String getVar_entete() {
      return this.var_entete;
   }

   public void setVar_entete(String var1) {
      this.var_entete = var1;
   }

   public String getVar_filtre() {
      return this.var_filtre;
   }

   public void setVar_filtre(String var1) {
      this.var_filtre = var1;
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
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

   public boolean isDecoupageActivite() {
      return this.decoupageActivite;
   }

   public void setDecoupageActivite(boolean var1) {
      this.decoupageActivite = var1;
   }

   public String getNomGroupe() {
      return this.nomGroupe;
   }

   public void setNomGroupe(String var1) {
      this.nomGroupe = var1;
   }

   public List getMesGroupes() {
      return this.mesGroupes;
   }

   public void setMesGroupes(List var1) {
      this.mesGroupes = var1;
   }

   public String getSource() {
      return this.source;
   }

   public void setSource(String var1) {
      this.source = var1;
   }

   public List getMesMarquesItems() {
      return this.mesMarquesItems;
   }

   public void setMesMarquesItems(List var1) {
      this.mesMarquesItems = var1;
   }

   public String getMarque() {
      return this.marque;
   }

   public void setMarque(String var1) {
      this.marque = var1;
   }

   public boolean isModuleParc() {
      return this.moduleParc;
   }

   public void setModuleParc(boolean var1) {
      this.moduleParc = var1;
   }

   public int getNbJours() {
      return this.nbJours;
   }

   public void setNbJours(int var1) {
      this.nbJours = var1;
   }

   public boolean isVar_anal_affaire() {
      return this.var_anal_affaire;
   }

   public void setVar_anal_affaire(boolean var1) {
      this.var_anal_affaire = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }
}
