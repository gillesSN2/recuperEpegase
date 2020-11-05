package com.epegase.forms.tiers;

import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.DevisLigneVentes;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.RetourLigneVentes;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilGoogleMap;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LireLesoptionsTiers;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionTiers;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
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

public class FormDestinataires implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionTiers optionTiers;
   private int var_action;
   private int var_memo_action;
   private String pageIndex;
   private ObjetLigneMenu ligneMenu;
   private PlansAnalytiques destinataires;
   private PlansAnalytiquesDao destinatairesDao;
   private List destinatairesList = new ArrayList();
   private ExercicesVentes exercicesVentes;
   private transient DataModel dataModelDestinataire = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private LireLesoptionsTiers lireLesOptionsTiers;
   private String valImp = "false";
   private boolean afficheButtOption = false;
   private boolean showModalPanelAjt;
   private boolean showModalPanelMod;
   private boolean doublon = false;
   private URI uri;
   private boolean showModalGoogleMap = false;
   private int var_nb_max = 100;
   private List mesPdvItems;
   private String nom;
   private String ville;
   private String pdv;
   private String appreciation;
   private String source;
   private List mesReglementClientItem;
   private List lesReglementsClient;
   private UtilPrint utilPrint;
   private List lesmodelesImpressions = new ArrayList();
   private boolean affMail = false;
   private String nomModeleDocument;
   private String nomModeleListe;
   private String format = "PDF";
   private String requete;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private boolean visibleOptionMail = false;
   private int var_choix_modele;
   private boolean affListeDoc = false;
   private boolean showModalPanelPrint = false;
   private String codeAgence;
   private OptionVentes optionVentes;
   private DocumentEntete documentEntete;
   private transient DataModel dataModelDocuments;
   private List lesDocumentsDetail;
   private transient DataModel dataModelDocumentsEntete;
   private List lesDocumentsEntete;
   private int choixDocument;
   private String choixFamilles;
   private Date dateDebut;
   private Date dateFin;
   private String choixProduit;
   private List mesFamilles;
   private float var_qte;
   private double var_total;
   private double var_reglement;
   private double var_solde;

   public FormDestinataires() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.destinatairesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererOptionsTiers() throws NamingException {
      this.lireLesOptionsTiers = new LireLesoptionsTiers();
      this.lireLesOptionsTiers.setStrId(this.structureLog.getStrid());
      this.lireLesOptionsTiers.lancer();
      this.optionTiers = this.lireLesOptionsTiers.getOptionTiers();
      if (this.optionTiers.getNbLigneMaxTi() != null && !this.optionTiers.getNbLigneMaxTi().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionTiers.getNbLigneMaxTi());
      } else {
         this.var_nb_max = 100;
      }

      this.exercicesVentes = new ExercicesVentes();
      ExercicesVentesDao var1 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesVentes = var1.recupererLastExo((Session)null);
      LireLesoptionsVentes var2 = new LireLesoptionsVentes();
      var2.setStrId(this.structureLog.getStrid());
      this.optionVentes = var2.lancer();
   }

   public void annuleSaisie() {
      this.var_action = 0;
      this.afficheButtOption = false;
      this.var_memo_action = this.var_action;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void chargerLesDestinataires() throws HibernateException, NamingException {
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.destinatairesList = this.destinatairesDao.rechercheDestinataire(this.nom, this.ville, this.appreciation, this.source, "7", (Session)null);
      if (this.destinatairesList.size() != 0) {
         for(int var1 = 0; var1 < this.destinatairesList.size(); ++var1) {
            this.destinataires = (PlansAnalytiques)this.destinatairesList.get(var1);
            if (this.destinataires.getAnaTiersPdv() != null && !this.destinataires.getAnaTiersPdv().isEmpty() && this.mesPdvItems.size() != 0) {
               for(int var2 = 0; var2 < this.mesPdvItems.size(); ++var2) {
                  String[] var3 = ((SelectItem)this.mesPdvItems.get(var2)).getValue().toString().split(":");
                  if (var3[0].equals(this.destinataires.getAnaTiersPdv())) {
                     this.destinataires.setLibellePdv(var3[1]);
                  }
               }
            }
         }
      }

      this.dataModelDestinataire.setWrappedData(this.destinatairesList);
      this.afficheButtOption = false;
   }

   public void selectionDestinataire() throws HibernateException, NamingException {
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
            this.destinataires = (PlansAnalytiques)var1.get(0);
            if (this.destinataires.getAnaTiersPdv() != null && !this.destinataires.getAnaTiersPdv().isEmpty()) {
               this.codeAgence = this.destinataires.getAnaTiersPdv() + ":" + this.destinataires.getLibellePdv();
            } else {
               this.codeAgence = "";
            }

            this.afficheButtOption = true;
         } else {
            this.afficheButtOption = false;
         }
      } else {
         this.afficheButtOption = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.destinataires != null) {
         this.consulterDestinataire();
      }

   }

   public void ajouterDestinataire() {
      this.var_action = 1;
      this.destinataires = new PlansAnalytiques();
      this.destinataires.setAnaTiersNompays(this.structureLog.getStrnompays());
      this.destinataires.setAnaTiersdevise(this.structureLog.getStrdevise());
      this.codeAgence = "";
   }

   public void modifierDestinataire() {
      this.var_action = 2;
   }

   public void consulterDestinataire() {
      this.var_action = 3;
   }

   public void saveDestinataires() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
      if (!this.destinataires.getAnaTiersdevise().equalsIgnoreCase("XOF") && !this.destinataires.getAnaTiersdevise().equalsIgnoreCase("XAF")) {
         if (!this.destinataires.getAnaTiersdevise().equalsIgnoreCase("EUR") && !this.destinataires.getAnaTiersdevise().equalsIgnoreCase("CHF")) {
            this.destinataires.setAnaTiersFormatDevise(0);
         } else {
            this.destinataires.setAnaTiersFormatDevise(2);
         }
      } else {
         this.destinataires.setAnaTiersFormatDevise(1);
      }

      this.destinataires.setAnaTiersPdv("");
      this.destinataires.setAnaTiersSecteur("");
      this.destinataires.setAnaTiersRegion("");
      this.destinataires.setLibellePdv("");
      String[] var2;
      if (this.codeAgence != null && !this.codeAgence.isEmpty() && this.codeAgence.contains(":")) {
         var2 = this.codeAgence.split(":");
         this.destinataires.setAnaTiersPdv(var2[0]);
         this.destinataires.setLibellePdv(var2[1]);
         new PointDeVente();
         PointDeVenteDao var4 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
         PointDeVente var3 = var4.recherchePdv(this.destinataires.getAnaTiersPdv(), var1);
         if (var3 != null) {
            this.destinataires.setAnaTiersSecteur(var3.getSecteur().getSecCode());
            new Secteur();
            SecteurDao var6 = new SecteurDao(this.baseLog, this.utilInitHibernate);
            Secteur var5 = var6.rechercheSecteur(this.destinataires.getAnaTiersSecteur(), var1);
            if (var5 != null) {
               this.destinataires.setAnaTiersRegion(var5.getRegion().getRegCode());
            }
         }
      }

      this.destinataires.setAnaNature("7");
      var2 = null;

      try {
         Transaction var12 = var1.beginTransaction();
         if (this.destinataires.getAnaId() == 0L) {
            this.destinataires.setAnaDateCreat(new Date());
            this.destinataires.setAnaUserCreat(this.usersLog.getUsrid());
            this.destinataires = this.destinatairesDao.insert(this.destinataires, var1);
            this.destinatairesList.add(this.destinataires);
            this.dataModelDestinataire.setWrappedData(this.destinatairesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.destinataires.setAnaDateModif(new Date());
            this.destinataires.setAnaUserModif(this.usersLog.getUsrid());
            this.destinataires = this.destinatairesDao.modif(this.destinataires, var1);
         }

         var12.commit();
      } catch (HibernateException var10) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_action = 0;
   }

   public void supprimerDestinataires() throws HibernateException, NamingException {
      if (this.destinataires != null) {
         this.destinatairesDao.delete(this.destinataires);
         this.destinatairesList.remove(this.destinataires);
         this.dataModelDestinataire.setWrappedData(this.destinatairesList);
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
      }

   }

   public void googleMap() throws IOException, URISyntaxException {
      UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
      this.uri = var1.calculMap((String)null, this.destinataires.getAnaTiersAdresse(), this.destinataires.getAnaTiersVille(), this.destinataires.getAnaTiersNompays());
      this.showModalGoogleMap = true;
   }

   public void annuleGoogleMap() {
      this.showModalGoogleMap = false;
   }

   public void accesDocuments() throws HibernateException, NamingException, ParseException {
      this.mesFamilles = new ArrayList();
      ExercicesVentesDao var1 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesVentes = var1.recupererLastExo((Session)null);
      if (this.exercicesVentes != null) {
         FamillesProduitsVentesDao var2 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
         this.mesFamilles = var2.chargerFamilleProduitVentesUtilItems(this.exercicesVentes.getExevteId(), (Session)null);
         this.lesDocumentsDetail = new ArrayList();
         this.dataModelDocuments = new ListDataModel();
         this.lesDocumentsEntete = new ArrayList();
         this.dataModelDocumentsEntete = new ListDataModel();
         this.choixDocument = 99;
         this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
         this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
         UtilDate var3 = new UtilDate();
         String var4 = (new Date()).getYear() + 1900 + "-01-01";
         this.dateDebut = var3.stringToDateSQLLight(var4);
         this.dateFin = new Date();
         this.var_action = 7;
         this.var_memo_action = this.var_action;
      }

   }

   public void retourDocuments() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void rechercherLesDocuments() throws HibernateException, NamingException, ParseException {
      this.lesDocumentsDetail.clear();
      this.lesDocumentsEntete.clear();
      this.var_qte = 0.0F;
      this.var_total = 0.0D;
      this.var_reglement = 0.0D;
      this.var_solde = 0.0D;
      UtilDate var1 = new UtilDate();
      String var2 = var1.dateToStringSQLLight(this.dateDebut) + " 00:00:00";
      String var3 = var1.dateToStringSQLLight(this.dateFin) + " 23:59:59";
      String var4 = "";
      if (this.choixFamilles.equals("0")) {
         var4 = "0";
      } else if (this.choixFamilles.contains(":")) {
         String[] var5 = this.choixFamilles.split(":");
         var4 = var5[0];
      }

      int var7;
      DocumentEntete var9;
      Stock var10;
      boolean var11;
      int var12;
      List var17;
      if (this.choixDocument == 21) {
         new ArrayList();
         DevisLigneVentesDao var6 = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
         var17 = var6.chargerLesMvtsDestinataires(this.destinataires.getAnaNomFr(), var2, var3, (Session)null);
         if (var17.size() != 0) {
            for(var7 = 0; var7 < var17.size(); ++var7) {
               new DevisLigneVentes();
               DevisLigneVentes var8 = (DevisLigneVentes)var17.get(var7);
               var9 = new DocumentEntete();
               var10 = new Stock();
               var10.setStk_lib_type("Devis");
               var10.setStkFamille(var8.getDvsligFamille());
               if ((var4.equals("0") || var4.equals(var10.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var8.getDvsligCode().startsWith(this.choixProduit))) {
                  var11 = false;
                  if (this.lesDocumentsEntete.size() != 0) {
                     for(var12 = 0; var12 < this.lesDocumentsEntete.size(); ++var12) {
                        if (((DocumentEntete)this.lesDocumentsEntete.get(var12)).getDocNum().equals(var8.getDevisEnteteVentes().getDvsNum())) {
                           var11 = true;
                           break;
                        }
                     }
                  } else {
                     var11 = false;
                  }

                  if (!var11) {
                     var9.setVar_lib_nat("Devis");
                     var9.setDocDate(var8.getDevisEnteteVentes().getDvsDate());
                     var9.setDocNum(var8.getDevisEnteteVentes().getDvsNum());
                     var9.setDocNomTiers(var8.getDevisEnteteVentes().getDvsNomTiers());
                     var9.setDocObject(var8.getDevisEnteteVentes().getDvsObject());
                     var9.setDocNomContact(var8.getDevisEnteteVentes().getDvsNomContact());
                     var9.setDocNomCaissier(var8.getDevisEnteteVentes().getDvsNomCommercial());
                     var9.setDocNomResponsable(var8.getDevisEnteteVentes().getDvsNomResponsable());
                     var9.setDocTotHt(var8.getDevisEnteteVentes().getDvsTotHt());
                     var9.setDocTotTva(var8.getDevisEnteteVentes().getDvsTotTva());
                     var9.setDocTotTtc(var8.getDevisEnteteVentes().getDvsTotTtc());
                     var9.setDocTotReglement(0.0D);
                     var9.setDocAPayer(0.0D);
                     this.var_total += var9.getDocTotTtc();
                     this.var_reglement += var9.getDocTotReglement();
                     this.lesDocumentsEntete.add(var9);
                  }

                  var10.setStk_date_mvt(var8.getDevisEnteteVentes().getDvsDate());
                  var10.setStk_numero(var8.getDevisEnteteVentes().getDvsNum());
                  var10.setStk_code_produit(var8.getDvsligCode());
                  var10.setStkLibelle(var8.getDvsligLibelle());
                  var10.setStk_code_depot(var8.getDvsligDepot());
                  var10.setStkPuRem(var8.getDvsligPuRem());
                  var10.setStk_pump(var8.getDvsligPump());
                  var10.setStk_qte_progress(var8.getDvsligQte());
                  var10.setStkPt(var8.getDvsligPt());
                  this.var_qte += var10.getStk_qte_progress();
                  this.lesDocumentsDetail.add(var10);
               }
            }
         }

         this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
         this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
      } else if (this.choixDocument == 22) {
         new ArrayList();
         CommandeLigneVentesDao var18 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
         var17 = var18.chargerLesMvtsDestinataires(this.destinataires.getAnaNomFr(), var2, var3, (Session)null);
         if (var17.size() != 0) {
            for(var7 = 0; var7 < var17.size(); ++var7) {
               new CommandeLigneVentes();
               CommandeLigneVentes var24 = (CommandeLigneVentes)var17.get(var7);
               var9 = new DocumentEntete();
               var10 = new Stock();
               var10.setStk_lib_type("Commande");
               var10.setStkFamille(var24.getBcmligFamille());
               if ((var4.equals("0") || var4.equals(var10.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var24.getBcmligCode().startsWith(this.choixProduit))) {
                  var11 = false;
                  if (this.lesDocumentsEntete.size() != 0) {
                     for(var12 = 0; var12 < this.lesDocumentsEntete.size(); ++var12) {
                        if (((DocumentEntete)this.lesDocumentsEntete.get(var12)).getDocNum().equals(var24.getCommandeEnteteVentes().getBcmNum())) {
                           var11 = true;
                           break;
                        }
                     }
                  } else {
                     var11 = false;
                  }

                  if (!var11) {
                     var9.setVar_lib_nat("Commande");
                     var9.setDocDate(var24.getCommandeEnteteVentes().getBcmDate());
                     var9.setDocNum(var24.getCommandeEnteteVentes().getBcmNum());
                     var9.setDocNomTiers(var24.getCommandeEnteteVentes().getBcmNomTiers());
                     var9.setDocObject(var24.getCommandeEnteteVentes().getBcmObject());
                     var9.setDocNomContact(var24.getCommandeEnteteVentes().getBcmNomContact());
                     var9.setDocNomCaissier(var24.getCommandeEnteteVentes().getBcmNomCommercial());
                     var9.setDocNomResponsable(var24.getCommandeEnteteVentes().getBcmNomResponsable());
                     var9.setDocTotHt(var24.getCommandeEnteteVentes().getBcmTotHt());
                     var9.setDocTotTva(var24.getCommandeEnteteVentes().getBcmTotTva());
                     var9.setDocTotTtc(var24.getCommandeEnteteVentes().getBcmTotTtc());
                     var9.setDocTotReglement(0.0D);
                     var9.setDocAPayer(0.0D);
                     this.var_total += var9.getDocTotTtc();
                     this.var_reglement += var9.getDocTotReglement();
                     this.lesDocumentsEntete.add(var9);
                  }

                  var10.setStk_date_mvt(var24.getCommandeEnteteVentes().getBcmDate());
                  var10.setStk_numero(var24.getCommandeEnteteVentes().getBcmNum());
                  var10.setStk_code_produit(var24.getBcmligCode());
                  var10.setStkLibelle(var24.getBcmligLibelle());
                  var10.setStk_code_depot(var24.getBcmligDepot());
                  var10.setStkPuRem(var24.getBcmligPuRem());
                  var10.setStk_pump(var24.getBcmligPump());
                  var10.setStk_qte_progress(var24.getBcmligQte());
                  var10.setStkPt(var24.getBcmligPt());
                  this.var_qte += var10.getStk_qte_progress();
                  this.lesDocumentsDetail.add(var10);
               }
            }
         }

         this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
         this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
      } else if (this.choixDocument == 23) {
         new ArrayList();
         LivraisonLigneVentesDao var19 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
         var17 = var19.chargerLesMvtsDestinataires(this.destinataires.getAnaNomFr(), var2, var3, (Session)null);
         if (var17.size() != 0) {
            for(var7 = 0; var7 < var17.size(); ++var7) {
               new LivraisonLigneVentes();
               LivraisonLigneVentes var25 = (LivraisonLigneVentes)var17.get(var7);
               var9 = new DocumentEntete();
               var10 = new Stock();
               var10.setStk_lib_type("Livraison");
               var10.setStkFamille(var25.getBlvligFamille());
               if ((var4.equals("0") || var4.equals(var10.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var25.getBlvligCode().startsWith(this.choixProduit))) {
                  var11 = false;
                  if (this.lesDocumentsEntete.size() != 0) {
                     for(var12 = 0; var12 < this.lesDocumentsEntete.size(); ++var12) {
                        if (((DocumentEntete)this.lesDocumentsEntete.get(var12)).getDocNum().equals(var25.getLivraisonEnteteVentes().getBlvNum())) {
                           var11 = true;
                           break;
                        }
                     }
                  } else {
                     var11 = false;
                  }

                  if (!var11) {
                     var9.setVar_lib_nat("Livraison");
                     var9.setDocDate(var25.getLivraisonEnteteVentes().getBlvDate());
                     var9.setDocNum(var25.getLivraisonEnteteVentes().getBlvNum());
                     var9.setDocNomTiers(var25.getLivraisonEnteteVentes().getBlvNomTiers());
                     var9.setDocObject(var25.getLivraisonEnteteVentes().getBlvObject());
                     var9.setDocNomContact(var25.getLivraisonEnteteVentes().getBlvNomContact());
                     var9.setDocNomCaissier(var25.getLivraisonEnteteVentes().getBlvNomCommercial());
                     var9.setDocNomResponsable(var25.getLivraisonEnteteVentes().getBlvNomResponsable());
                     var9.setDocTotHt(var25.getLivraisonEnteteVentes().getBlvTotHt());
                     var9.setDocTotTva(var25.getLivraisonEnteteVentes().getBlvTotTva());
                     var9.setDocTotTtc(var25.getLivraisonEnteteVentes().getBlvTotTtc());
                     var9.setDocTotReglement(0.0D);
                     var9.setDocAPayer(0.0D);
                     this.var_total += var9.getDocTotTtc();
                     this.var_reglement += var9.getDocTotReglement();
                     this.lesDocumentsEntete.add(var9);
                  }

                  var10.setStk_date_mvt(var25.getLivraisonEnteteVentes().getBlvDate());
                  var10.setStk_numero(var25.getLivraisonEnteteVentes().getBlvNum());
                  var10.setStk_code_produit(var25.getBlvligCode());
                  var10.setStkLibelle(var25.getBlvligLibelle());
                  var10.setStk_code_depot(var25.getBlvligDepot());
                  var10.setStkPuRem(var25.getBlvligPuRem());
                  var10.setStk_pump(var25.getBlvligPump());
                  var10.setStk_qte_progress(var25.getBlvligQte());
                  var10.setStkPt(var25.getBlvligPt());
                  this.var_qte += var10.getStk_qte_progress();
                  this.lesDocumentsDetail.add(var10);
               }
            }
         }

         this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
         this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
      } else if (this.choixDocument == 24) {
         new ArrayList();
         RetourLigneVentesDao var20 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
         var17 = var20.chargerLesMvtsDestinataires(this.destinataires.getAnaNomFr(), var2, var3, (Session)null);
         if (var17.size() != 0) {
            for(var7 = 0; var7 < var17.size(); ++var7) {
               new RetourLigneVentes();
               RetourLigneVentes var26 = (RetourLigneVentes)var17.get(var7);
               var9 = new DocumentEntete();
               var10 = new Stock();
               var10.setStk_lib_type("Retour");
               var10.setStkFamille(var26.getBrtligFamille());
               if ((var4.equals("0") || var4.equals(var10.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var26.getBrtligCode().startsWith(this.choixProduit))) {
                  var11 = false;
                  if (this.lesDocumentsEntete.size() != 0) {
                     for(var12 = 0; var12 < this.lesDocumentsEntete.size(); ++var12) {
                        if (((DocumentEntete)this.lesDocumentsEntete.get(var12)).getDocNum().equals(var26.getRetourEnteteVentes().getBrtNum())) {
                           var11 = true;
                           break;
                        }
                     }
                  } else {
                     var11 = false;
                  }

                  if (!var11) {
                     var9.setVar_lib_nat("Retour");
                     var9.setDocDate(var26.getRetourEnteteVentes().getBrtDate());
                     var9.setDocNum(var26.getRetourEnteteVentes().getBrtNum());
                     var9.setDocNomTiers(var26.getRetourEnteteVentes().getBrtNomTiers());
                     var9.setDocObject(var26.getRetourEnteteVentes().getBrtObject());
                     var9.setDocNomContact(var26.getRetourEnteteVentes().getBrtNomContact());
                     var9.setDocNomCaissier(var26.getRetourEnteteVentes().getBrtNomCommercial());
                     var9.setDocNomResponsable(var26.getRetourEnteteVentes().getBrtNomResponsable());
                     var9.setDocTotHt(var26.getRetourEnteteVentes().getBrtTotHt());
                     var9.setDocTotTva(var26.getRetourEnteteVentes().getBrtTotTva());
                     var9.setDocTotTtc(var26.getRetourEnteteVentes().getBrtTotTtc());
                     var9.setDocTotReglement(0.0D);
                     var9.setDocAPayer(0.0D);
                     this.var_total += var9.getDocTotTtc();
                     this.var_reglement += var9.getDocTotReglement();
                     this.lesDocumentsEntete.add(var9);
                  }

                  var10.setStk_date_mvt(var26.getRetourEnteteVentes().getBrtDate());
                  var10.setStk_numero(var26.getRetourEnteteVentes().getBrtNum());
                  var10.setStk_code_produit(var26.getBrtligCode());
                  var10.setStkLibelle(var26.getBrtligLibelle());
                  var10.setStk_code_depot(var26.getBrtligDepot());
                  var10.setStkPuRem(var26.getBrtligPuRem());
                  var10.setStk_pump(var26.getBrtligPump());
                  var10.setStk_qte_progress(var26.getBrtligQte());
                  var10.setStkPt(var26.getBrtligPt());
                  this.var_qte += var10.getStk_qte_progress();
                  this.lesDocumentsDetail.add(var10);
               }
            }
         }

         this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
         this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
      } else {
         boolean var13;
         int var14;
         boolean var15;
         int var16;
         FactureLigneVentesDao var21;
         FactureLigneVentes var27;
         AvoirLigneVentesDao var28;
         List var29;
         int var31;
         List var32;
         AvoirLigneVentes var33;
         NoteDebitLigneVentesDao var34;
         DocumentEntete var37;
         Stock var38;
         Stock var39;
         NoteDebitLigneVentes var40;
         DocumentEntete var42;
         int var43;
         if (this.choixDocument == 25) {
            new ArrayList();
            var21 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
            var17 = var21.chargerLesMvtsDestinataires(this.destinataires.getAnaNomFr(), var2, var3, (Session)null);
            if (var17.size() != 0) {
               for(var7 = 0; var7 < var17.size(); ++var7) {
                  new FactureLigneVentes();
                  var27 = (FactureLigneVentes)var17.get(var7);
                  var9 = new DocumentEntete();
                  var10 = new Stock();
                  var10.setStk_lib_type("Facture");
                  var10.setStkFamille(var27.getFacligFamille());
                  if ((var4.equals("0") || var4.equals(var10.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var27.getFacligCode().startsWith(this.choixProduit))) {
                     var11 = false;
                     if (this.lesDocumentsEntete.size() != 0) {
                        for(var12 = 0; var12 < this.lesDocumentsEntete.size(); ++var12) {
                           if (((DocumentEntete)this.lesDocumentsEntete.get(var12)).getDocNum().equals(var27.getFactureEnteteVentes().getFacNum())) {
                              var11 = true;
                              break;
                           }
                        }
                     } else {
                        var11 = false;
                     }

                     if (!var11) {
                        var9.setVar_lib_nat("Facture");
                        var9.setDocDate(var27.getFactureEnteteVentes().getFacDate());
                        var9.setDocNum(var27.getFactureEnteteVentes().getFacNum());
                        var9.setDocNomTiers(var27.getFactureEnteteVentes().getFacNomTiers());
                        var9.setDocObject(var27.getFactureEnteteVentes().getFacObject());
                        var9.setDocNomContact(var27.getFactureEnteteVentes().getFacNomContact());
                        var9.setDocNomCaissier(var27.getFactureEnteteVentes().getFacNomCommercial());
                        var9.setDocNomResponsable(var27.getFactureEnteteVentes().getFacNomResponsable());
                        var9.setDocTotHt(var27.getFactureEnteteVentes().getFacTotHt());
                        var9.setDocTotTva(var27.getFactureEnteteVentes().getFacTotTva());
                        var9.setDocTotTtc(var27.getFactureEnteteVentes().getFacTotTtc());
                        var9.setDocTotReglement(var27.getFactureEnteteVentes().getFacTotReglement());
                        var9.setDocAPayer(var27.getFactureEnteteVentes().getFacTotTtc() - var27.getFactureEnteteVentes().getFacTotReglement());
                        this.var_total += var9.getDocTotTtc();
                        this.var_reglement += var9.getDocTotReglement();
                        this.lesDocumentsEntete.add(var9);
                     }

                     var10.setStk_date_mvt(var27.getFactureEnteteVentes().getFacDate());
                     var10.setStk_numero(var27.getFactureEnteteVentes().getFacNum());
                     var10.setStk_code_produit(var27.getFacligCode());
                     var10.setStkLibelle(var27.getFacligLibelle());
                     var10.setStk_code_depot(var27.getFacligDepot());
                     var10.setStkPuRem(var27.getFacligPuRem());
                     var10.setStk_pump(var27.getFacligPump());
                     var10.setStk_qte_progress(var27.getFacligQte());
                     var10.setStkPt(var27.getFacligPt());
                     this.var_qte += var10.getStk_qte_progress();
                     this.lesDocumentsDetail.add(var10);
                  }
               }
            }

            new ArrayList();
            var28 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
            var29 = var28.chargerLesMvtsDestinataires(this.destinataires.getAnaNomFr(), var2, var3, (Session)null);
            if (var29.size() != 0) {
               for(var31 = 0; var31 < var29.size(); ++var31) {
                  new AvoirLigneVentes();
                  var33 = (AvoirLigneVentes)var29.get(var31);
                  var42 = new DocumentEntete();
                  var39 = new Stock();
                  var39.setStk_lib_type("Avoir");
                  var39.setStkFamille(var33.getAvrligFamille());
                  if ((var4.equals("0") || var4.equals(var39.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var33.getAvrligCode().startsWith(this.choixProduit))) {
                     var13 = false;
                     if (this.lesDocumentsEntete.size() != 0) {
                        for(var14 = 0; var14 < this.lesDocumentsEntete.size(); ++var14) {
                           if (((DocumentEntete)this.lesDocumentsEntete.get(var14)).getDocNum().equals(var33.getAvoirEnteteVentes().getAvrNum())) {
                              var13 = true;
                              break;
                           }
                        }
                     } else {
                        var13 = false;
                     }

                     if (!var13) {
                        var42.setVar_lib_nat("Avoir");
                        var42.setDocDate(var33.getAvoirEnteteVentes().getAvrDate());
                        var42.setDocNum(var33.getAvoirEnteteVentes().getAvrNum());
                        var42.setDocNomTiers(var33.getAvoirEnteteVentes().getAvrNomTiers());
                        var42.setDocObject(var33.getAvoirEnteteVentes().getAvrObject());
                        var42.setDocNomContact(var33.getAvoirEnteteVentes().getAvrNomContact());
                        var42.setDocNomCaissier(var33.getAvoirEnteteVentes().getAvrNomCommercial());
                        var42.setDocNomResponsable(var33.getAvoirEnteteVentes().getAvrNomResponsable());
                        var42.setDocTotHt(var33.getAvoirEnteteVentes().getAvrTotHt() * -1.0D);
                        var42.setDocTotTva(var33.getAvoirEnteteVentes().getAvrTotTva() * -1.0D);
                        var42.setDocTotTtc(var33.getAvoirEnteteVentes().getAvrTotTtc() * -1.0D);
                        var42.setDocTotReglement(0.0D);
                        var42.setDocAPayer(0.0D);
                        this.var_total += var42.getDocTotTtc();
                        this.var_reglement += var42.getDocTotReglement();
                        this.lesDocumentsEntete.add(var42);
                     }

                     var39.setStk_date_mvt(var33.getAvoirEnteteVentes().getAvrDate());
                     var39.setStk_numero(var33.getAvoirEnteteVentes().getAvrNum());
                     var39.setStk_code_produit(var33.getAvrligCode());
                     var39.setStkLibelle(var33.getAvrligLibelle());
                     var39.setStk_code_depot(var33.getAvrligDepot());
                     var39.setStkPuRem(var33.getAvrligPuRem() * -1.0D);
                     var39.setStk_pump(var33.getAvrligPump() * -1.0D);
                     var39.setStk_qte_progress(var33.getAvrligQte() * -1.0F);
                     var39.setStkPt(var33.getAvrligPt() * -1.0D);
                     this.var_qte += var39.getStk_qte_progress();
                     this.lesDocumentsDetail.add(var39);
                  }
               }
            }

            new ArrayList();
            var34 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
            var32 = var34.chargerLesMvtsDestinataires(this.destinataires.getAnaNomFr(), var2, var3, (Session)null);
            if (var32.size() != 0) {
               for(var43 = 0; var43 < var32.size(); ++var43) {
                  new NoteDebitLigneVentes();
                  var40 = (NoteDebitLigneVentes)var32.get(var43);
                  var37 = new DocumentEntete();
                  var38 = new Stock();
                  var38.setStk_lib_type("NoteDebit");
                  var38.setStkFamille(var40.getNdbligFamille());
                  if ((var4.equals("0") || var4.equals(var38.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var40.getNdbligCode().startsWith(this.choixProduit))) {
                     var15 = false;
                     if (this.lesDocumentsEntete.size() != 0) {
                        for(var16 = 0; var16 < this.lesDocumentsEntete.size(); ++var16) {
                           if (((DocumentEntete)this.lesDocumentsEntete.get(var16)).getDocNum().equals(var40.getNoteDebitEnteteVentes().getNdbNum())) {
                              var15 = true;
                              break;
                           }
                        }
                     } else {
                        var15 = false;
                     }

                     if (!var15) {
                        var37.setVar_lib_nat("NoteDebit");
                        var37.setDocDate(var40.getNoteDebitEnteteVentes().getNdbDate());
                        var37.setDocNum(var40.getNoteDebitEnteteVentes().getNdbNum());
                        var37.setDocNomTiers(var40.getNoteDebitEnteteVentes().getNdbNomTiers());
                        var37.setDocObject(var40.getNoteDebitEnteteVentes().getNdbObject());
                        var37.setDocNomContact(var40.getNoteDebitEnteteVentes().getNdbNomContact());
                        var37.setDocNomCaissier(var40.getNoteDebitEnteteVentes().getNdbNomCommercial());
                        var37.setDocNomResponsable(var40.getNoteDebitEnteteVentes().getNdbNomResponsable());
                        var37.setDocTotHt(var40.getNoteDebitEnteteVentes().getNdbTotHt());
                        var37.setDocTotTva(var40.getNoteDebitEnteteVentes().getNdbTotTva());
                        var37.setDocTotTtc(var40.getNoteDebitEnteteVentes().getNdbTotTtc());
                        var37.setDocTotReglement(var40.getNoteDebitEnteteVentes().getNdbTotReglement());
                        var37.setDocAPayer(var40.getNoteDebitEnteteVentes().getNdbTotTtc() - var40.getNoteDebitEnteteVentes().getNdbTotReglement());
                        this.var_total += var37.getDocTotTtc();
                        this.var_reglement += var37.getDocTotReglement();
                        this.lesDocumentsEntete.add(var37);
                     }

                     var38.setStk_date_mvt(var40.getNoteDebitEnteteVentes().getNdbDate());
                     var38.setStk_numero(var40.getNoteDebitEnteteVentes().getNdbNum());
                     var38.setStk_code_produit(var40.getNdbligCode());
                     var38.setStkLibelle(var40.getNdbligLibelle());
                     var38.setStk_code_depot(var40.getNdbligDepot());
                     var38.setStkPuRem(var40.getNdbligPuRem());
                     var38.setStk_pump(var40.getNdbligPump());
                     var38.setStk_qte_progress(var40.getNdbligQte());
                     var38.setStkPt(var40.getNdbligPt());
                     this.var_qte += var38.getStk_qte_progress();
                     this.lesDocumentsDetail.add(var38);
                  }
               }
            }

            this.var_solde = this.var_total - this.var_reglement;
            this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
            this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
         } else if (this.choixDocument == 251) {
            new ArrayList();
            var21 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
            var17 = var21.chargerLesMvtsDestinataires(this.destinataires.getAnaNomFr(), var2, var3, (Session)null);
            if (var17.size() != 0) {
               for(var7 = 0; var7 < var17.size(); ++var7) {
                  new FactureLigneVentes();
                  var27 = (FactureLigneVentes)var17.get(var7);
                  if (var27.getFactureEnteteVentes().getFacSolde() == 0) {
                     var9 = new DocumentEntete();
                     var10 = new Stock();
                     var10.setStk_lib_type("Facture");
                     var10.setStkFamille(var27.getFacligFamille());
                     if ((var4.equals("0") || var4.equals(var10.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var27.getFacligCode().startsWith(this.choixProduit))) {
                        var11 = false;
                        if (this.lesDocumentsEntete.size() != 0) {
                           for(var12 = 0; var12 < this.lesDocumentsEntete.size(); ++var12) {
                              if (((DocumentEntete)this.lesDocumentsEntete.get(var12)).getDocNum().equals(var27.getFactureEnteteVentes().getFacNum())) {
                                 var11 = true;
                                 break;
                              }
                           }
                        } else {
                           var11 = false;
                        }

                        if (!var11) {
                           var9.setVar_lib_nat("Facture");
                           var9.setDocDate(var27.getFactureEnteteVentes().getFacDate());
                           var9.setDocNum(var27.getFactureEnteteVentes().getFacNum());
                           var9.setDocNomTiers(var27.getFactureEnteteVentes().getFacNomTiers());
                           var9.setDocObject(var27.getFactureEnteteVentes().getFacObject());
                           var9.setDocNomContact(var27.getFactureEnteteVentes().getFacNomContact());
                           var9.setDocNomCaissier(var27.getFactureEnteteVentes().getFacNomCommercial());
                           var9.setDocNomResponsable(var27.getFactureEnteteVentes().getFacNomResponsable());
                           var9.setDocTotHt(var27.getFactureEnteteVentes().getFacTotHt());
                           var9.setDocTotTva(var27.getFactureEnteteVentes().getFacTotTva());
                           var9.setDocTotTtc(var27.getFactureEnteteVentes().getFacTotTtc());
                           var9.setDocTotReglement(var27.getFactureEnteteVentes().getFacTotReglement());
                           var9.setDocAPayer(var27.getFactureEnteteVentes().getFacTotTtc() - var27.getFactureEnteteVentes().getFacTotReglement());
                           this.var_total += var9.getDocTotTtc();
                           this.var_reglement += var9.getDocTotReglement();
                           this.lesDocumentsEntete.add(var9);
                        }

                        var10.setStk_date_mvt(var27.getFactureEnteteVentes().getFacDate());
                        var10.setStk_numero(var27.getFactureEnteteVentes().getFacNum());
                        var10.setStk_code_produit(var27.getFacligCode());
                        var10.setStkLibelle(var27.getFacligLibelle());
                        var10.setStk_code_depot(var27.getFacligDepot());
                        var10.setStkPuRem(var27.getFacligPuRem());
                        var10.setStk_pump(var27.getFacligPump());
                        var10.setStk_qte_progress(var27.getFacligQte());
                        var10.setStkPt(var27.getFacligPt());
                        this.var_qte += var10.getStk_qte_progress();
                        this.lesDocumentsDetail.add(var10);
                     }
                  }
               }
            }

            new ArrayList();
            var28 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
            var29 = var28.chargerLesMvtsDestinataires(this.destinataires.getAnaNomFr(), var2, var3, (Session)null);
            if (var29.size() != 0) {
               for(var31 = 0; var31 < var29.size(); ++var31) {
                  new AvoirLigneVentes();
                  var33 = (AvoirLigneVentes)var29.get(var31);
                  var42 = new DocumentEntete();
                  var39 = new Stock();
                  var39.setStk_lib_type("Avoir");
                  var39.setStkFamille(var33.getAvrligFamille());
                  if ((var4.equals("0") || var4.equals(var39.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var33.getAvrligCode().startsWith(this.choixProduit))) {
                     var13 = false;
                     if (this.lesDocumentsEntete.size() != 0) {
                        for(var14 = 0; var14 < this.lesDocumentsEntete.size(); ++var14) {
                           if (((DocumentEntete)this.lesDocumentsEntete.get(var14)).getDocNum().equals(var33.getAvoirEnteteVentes().getAvrNum())) {
                              var13 = true;
                              break;
                           }
                        }
                     } else {
                        var13 = false;
                     }

                     if (!var13) {
                        var42.setVar_lib_nat("Avoir");
                        var42.setDocDate(var33.getAvoirEnteteVentes().getAvrDate());
                        var42.setDocNum(var33.getAvoirEnteteVentes().getAvrNum());
                        var42.setDocNomTiers(var33.getAvoirEnteteVentes().getAvrNomTiers());
                        var42.setDocObject(var33.getAvoirEnteteVentes().getAvrObject());
                        var42.setDocNomContact(var33.getAvoirEnteteVentes().getAvrNomContact());
                        var42.setDocNomCaissier(var33.getAvoirEnteteVentes().getAvrNomCommercial());
                        var42.setDocNomResponsable(var33.getAvoirEnteteVentes().getAvrNomResponsable());
                        var42.setDocTotHt(var33.getAvoirEnteteVentes().getAvrTotHt() * -1.0D);
                        var42.setDocTotTva(var33.getAvoirEnteteVentes().getAvrTotTva() * -1.0D);
                        var42.setDocTotTtc(var33.getAvoirEnteteVentes().getAvrTotTtc() * -1.0D);
                        var42.setDocTotReglement(0.0D);
                        var42.setDocAPayer(0.0D);
                        this.var_total += var42.getDocTotTtc();
                        this.var_reglement += var42.getDocTotReglement();
                        this.lesDocumentsEntete.add(var42);
                     }

                     var39.setStk_date_mvt(var33.getAvoirEnteteVentes().getAvrDate());
                     var39.setStk_numero(var33.getAvoirEnteteVentes().getAvrNum());
                     var39.setStk_code_produit(var33.getAvrligCode());
                     var39.setStkLibelle(var33.getAvrligLibelle());
                     var39.setStk_code_depot(var33.getAvrligDepot());
                     var39.setStkPuRem(var33.getAvrligPuRem() * -1.0D);
                     var39.setStk_pump(var33.getAvrligPump() * -1.0D);
                     var39.setStk_qte_progress(var33.getAvrligQte() * -1.0F);
                     var39.setStkPt(var33.getAvrligPt() * -1.0D);
                     this.var_qte += var39.getStk_qte_progress();
                     this.lesDocumentsDetail.add(var39);
                  }
               }
            }

            new ArrayList();
            var34 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
            var32 = var34.chargerLesMvtsDestinataires(this.destinataires.getAnaNomFr(), var2, var3, (Session)null);
            if (var32.size() != 0) {
               for(var43 = 0; var43 < var32.size(); ++var43) {
                  new NoteDebitLigneVentes();
                  var40 = (NoteDebitLigneVentes)var32.get(var43);
                  if (var40.getNoteDebitEnteteVentes().getNdbSolde() == 0) {
                     var37 = new DocumentEntete();
                     var38 = new Stock();
                     var38.setStk_lib_type("NoteDebit");
                     var38.setStkFamille(var40.getNdbligFamille());
                     if ((var4.equals("0") || var4.equals(var38.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var40.getNdbligCode().startsWith(this.choixProduit))) {
                        var15 = false;
                        if (this.lesDocumentsEntete.size() != 0) {
                           for(var16 = 0; var16 < this.lesDocumentsEntete.size(); ++var16) {
                              if (((DocumentEntete)this.lesDocumentsEntete.get(var16)).getDocNum().equals(var40.getNoteDebitEnteteVentes().getNdbNum())) {
                                 var15 = true;
                                 break;
                              }
                           }
                        } else {
                           var15 = false;
                        }

                        if (!var15) {
                           var37.setVar_lib_nat("NoteDebit");
                           var37.setDocDate(var40.getNoteDebitEnteteVentes().getNdbDate());
                           var37.setDocNum(var40.getNoteDebitEnteteVentes().getNdbNum());
                           var37.setDocNomTiers(var40.getNoteDebitEnteteVentes().getNdbNomTiers());
                           var37.setDocObject(var40.getNoteDebitEnteteVentes().getNdbObject());
                           var37.setDocNomContact(var40.getNoteDebitEnteteVentes().getNdbNomContact());
                           var37.setDocNomCaissier(var40.getNoteDebitEnteteVentes().getNdbNomCommercial());
                           var37.setDocNomResponsable(var40.getNoteDebitEnteteVentes().getNdbNomResponsable());
                           var37.setDocTotHt(var40.getNoteDebitEnteteVentes().getNdbTotHt());
                           var37.setDocTotTva(var40.getNoteDebitEnteteVentes().getNdbTotTva());
                           var37.setDocTotTtc(var40.getNoteDebitEnteteVentes().getNdbTotTtc());
                           var37.setDocTotReglement(var40.getNoteDebitEnteteVentes().getNdbTotReglement());
                           var37.setDocAPayer(var40.getNoteDebitEnteteVentes().getNdbTotTtc() - var40.getNoteDebitEnteteVentes().getNdbTotReglement());
                           this.var_total += var37.getDocTotTtc();
                           this.var_reglement += var37.getDocTotReglement();
                           this.lesDocumentsEntete.add(var37);
                        }

                        var38.setStk_date_mvt(var40.getNoteDebitEnteteVentes().getNdbDate());
                        var38.setStk_numero(var40.getNoteDebitEnteteVentes().getNdbNum());
                        var38.setStk_code_produit(var40.getNdbligCode());
                        var38.setStkLibelle(var40.getNdbligLibelle());
                        var38.setStk_code_depot(var40.getNdbligDepot());
                        var38.setStkPuRem(var40.getNdbligPuRem());
                        var38.setStk_pump(var40.getNdbligPump());
                        var38.setStk_qte_progress(var40.getNdbligQte());
                        var38.setStkPt(var40.getNdbligPt());
                        this.var_qte += var38.getStk_qte_progress();
                        this.lesDocumentsDetail.add(var38);
                     }
                  }
               }
            }

            this.var_solde = this.var_total - this.var_reglement;
            this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
            this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
         } else if (this.choixDocument == 60) {
            String var22 = var1.dateToStringSQLLight(this.dateDebut);
            String var23 = var1.dateToStringSQLLight(this.dateFin);
            new ArrayList();
            ReglementsDao var30 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
            var29 = var30.rechercheHistoDestinataires(this.destinataires.getAnaNomFr(), var22, var23, (Session)null);
            if (var29.size() != 0) {
               for(var31 = 0; var31 < var29.size(); ++var31) {
                  new Reglements();
                  Reglements var35 = (Reglements)var29.get(var31);
                  var42 = new DocumentEntete();
                  var42.setVar_lib_nat("Règlement");
                  var42.setDocDate(var35.getRglDateReg());
                  var42.setDocNum(var35.getRglNum());
                  var42.setDocNomTiers(var35.getRglNomTiers());
                  var42.setDocObject(var35.getRglObjet());
                  var42.setDocNomContact(var35.getVar_lib_nat());
                  var42.setDocNomCaissier(var35.getRglDocument());
                  String var41 = "";
                  if (var35.getRglTypeReg() == 1) {
                     var41 = "Chq N° " + var35.getRglNumChqBdx() + " " + var35.getRglBanqueTireur();
                  } else {
                     var41 = var35.getRglLibTypReg();
                  }

                  var42.setDocNomResponsable(var35.getLibelleOperation() + " " + var41);
                  var42.setDocTotHt(0.0D);
                  var42.setDocTotTva(0.0D);
                  var42.setDocTotTtc(0.0D);
                  var42.setDocTotReglement(var35.getRglRecette());
                  var42.setDocAPayer(0.0D);
                  this.var_total += var42.getDocTotTtc();
                  this.var_reglement += var42.getDocTotReglement();
                  this.lesDocumentsEntete.add(var42);
               }
            }

            new ArrayList();
            AvoirLigneVentesDao var36 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
            var32 = var36.chargerLesMvtsDestinataires(this.destinataires.getAnaNomFr(), var2, var3, (Session)null);
            if (var32.size() != 0) {
               for(var43 = 0; var43 < var32.size(); ++var43) {
                  new AvoirLigneVentes();
                  AvoirLigneVentes var44 = (AvoirLigneVentes)var32.get(var43);
                  var37 = new DocumentEntete();
                  var38 = new Stock();
                  var38.setStk_lib_type("Avoir");
                  var38.setStkFamille(var44.getAvrligFamille());
                  if ((var4.equals("0") || var4.equals(var38.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var44.getAvrligCode().startsWith(this.choixProduit))) {
                     var15 = false;
                     if (this.lesDocumentsEntete.size() != 0) {
                        for(var16 = 0; var16 < this.lesDocumentsEntete.size(); ++var16) {
                           if (((DocumentEntete)this.lesDocumentsEntete.get(var16)).getDocNum().equals(var44.getAvoirEnteteVentes().getAvrNum())) {
                              var15 = true;
                              break;
                           }
                        }
                     } else {
                        var15 = false;
                     }

                     if (!var15) {
                        var37.setVar_lib_nat("Avoir");
                        var37.setDocDate(var44.getAvoirEnteteVentes().getAvrDate());
                        var37.setDocNum(var44.getAvoirEnteteVentes().getAvrNum());
                        var37.setDocNomTiers(var44.getAvoirEnteteVentes().getAvrNomTiers());
                        var37.setDocObject(var44.getAvoirEnteteVentes().getAvrObject());
                        var37.setDocNomContact(var44.getAvoirEnteteVentes().getAvrNomContact());
                        var37.setDocNomCaissier(var44.getAvoirEnteteVentes().getAvrNomCommercial());
                        var37.setDocNomResponsable(var44.getAvoirEnteteVentes().getAvrNomResponsable());
                        var37.setDocTotHt(var44.getAvoirEnteteVentes().getAvrTotHt() * -1.0D);
                        var37.setDocTotTva(var44.getAvoirEnteteVentes().getAvrTotTva() * -1.0D);
                        var37.setDocTotTtc(var44.getAvoirEnteteVentes().getAvrTotTtc() * -1.0D);
                        var37.setDocTotReglement(0.0D);
                        var37.setDocAPayer(0.0D);
                        this.var_total += var37.getDocTotTtc();
                        this.var_reglement += var37.getDocTotReglement();
                        this.lesDocumentsEntete.add(var37);
                     }

                     var38.setStk_date_mvt(var44.getAvoirEnteteVentes().getAvrDate());
                     var38.setStk_numero(var44.getAvoirEnteteVentes().getAvrNum());
                     var38.setStk_code_produit(var44.getAvrligCode());
                     var38.setStkLibelle(var44.getAvrligLibelle());
                     var38.setStk_code_depot(var44.getAvrligDepot());
                     var38.setStkPuRem(var44.getAvrligPuRem() * -1.0D);
                     var38.setStk_pump(var44.getAvrligPump() * -1.0D);
                     var38.setStk_qte_progress(var44.getAvrligQte() * -1.0F);
                     var38.setStkPt(var44.getAvrligPt() * -1.0D);
                     this.var_qte += var38.getStk_qte_progress();
                     this.lesDocumentsDetail.add(var38);
                  }
               }
            }

            this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
            this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
         }
      }

   }

   public void selectionDocument() {
      if (this.dataModelDocumentsEntete.isRowAvailable()) {
         this.documentEntete = (DocumentEntete)this.dataModelDocumentsEntete.getRowData();
      }

   }

   public void initImpression() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.var_choix_modele = 0;
      this.visibleOptionMail = false;
      this.affMail = false;
      this.listeDocImp();
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
   }

   public void listeDocImp() {
      if (this.var_choix_modele == 0) {
         this.affListeDoc = false;
      } else {
         this.affListeDoc = true;
      }

   }

   public void OptionMail() {
      if (this.format.equalsIgnoreCase("MAIL")) {
         this.visibleOptionMail = true;
      } else {
         this.visibleOptionMail = false;
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
      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            this.requete = " cmm_plananalytique.`ana_id`='" + this.destinataires.getAnaId() + "'";
            this.utilPrint.setSource("");
            this.utilPrint.setRecordPath("");
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setRequete(this.requete);
            this.utilPrint.setFiltre("");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "destinataire" + File.separator + "document" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "destinataire" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Impression destinataire");
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setIdResponsable(0L);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            ArrayList var1 = new ArrayList();
            JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
            this.utilPrint.setjRBeanCollectionDataSource(var2);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setSource("");
         this.utilPrint.setRecordPath("");
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des destinataires");
         this.utilPrint.setRequete("");
         this.utilPrint.setFiltre("");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "destinataire" + File.separator + "liste" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "destinataire" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(this.destinatairesList);
         this.utilPrint.setjRBeanCollectionDataSource(var3);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public boolean isDoublon() {
      return this.doublon;
   }

   public void setDoublon(boolean var1) {
      this.doublon = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isShowModalPanelAjt() {
      return this.showModalPanelAjt;
   }

   public void setShowModalPanelAjt(boolean var1) {
      this.showModalPanelAjt = var1;
   }

   public boolean isShowModalPanelMod() {
      return this.showModalPanelMod;
   }

   public void setShowModalPanelMod(boolean var1) {
      this.showModalPanelMod = var1;
   }

   public void visibleAjt() {
      this.destinataires = new PlansAnalytiques();
      this.setShowModalPanelAjt(true);
   }

   public void visibleMod() {
      this.setShowModalPanelMod(true);
   }

   public String getValImp() {
      return this.valImp;
   }

   public void setValImp(String var1) {
      this.valImp = var1;
   }

   public boolean isAfficheButtOption() {
      return this.afficheButtOption;
   }

   public void setAfficheButtOption(boolean var1) {
      this.afficheButtOption = var1;
   }

   public String getAppreciation() {
      return this.appreciation;
   }

   public void setAppreciation(String var1) {
      this.appreciation = var1;
   }

   public String getNom() {
      return this.nom;
   }

   public void setNom(String var1) {
      this.nom = var1;
   }

   public String getPdv() {
      return this.pdv;
   }

   public void setPdv(String var1) {
      this.pdv = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public String getVille() {
      return this.ville;
   }

   public void setVille(String var1) {
      this.ville = var1;
   }

   public ObjetLigneMenu getLigneMenu() {
      return this.ligneMenu;
   }

   public void setLigneMenu(ObjetLigneMenu var1) {
      this.ligneMenu = var1;
   }

   public List getMesReglementClientItem() {
      return this.mesReglementClientItem;
   }

   public void setMesReglementClientItem(List var1) {
      this.mesReglementClientItem = var1;
   }

   public DataModel getDataModelDestinataire() {
      return this.dataModelDestinataire;
   }

   public void setDataModelDestinataire(DataModel var1) {
      this.dataModelDestinataire = var1;
   }

   public List getLesmodelesImpressions() {
      return this.lesmodelesImpressions;
   }

   public void setLesmodelesImpressions(List var1) {
      this.lesmodelesImpressions = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public PlansAnalytiques getDestinataires() {
      return this.destinataires;
   }

   public void setDestinataires(PlansAnalytiques var1) {
      this.destinataires = var1;
   }

   public List getLesReglementsClient() {
      return this.lesReglementsClient;
   }

   public void setLesReglementsClient(List var1) {
      this.lesReglementsClient = var1;
   }

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
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

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public boolean isShowModalGoogleMap() {
      return this.showModalGoogleMap;
   }

   public void setShowModalGoogleMap(boolean var1) {
      this.showModalGoogleMap = var1;
   }

   public URI getUri() {
      return this.uri;
   }

   public void setUri(URI var1) {
      this.uri = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public OptionTiers getOptionTiers() {
      return this.optionTiers;
   }

   public void setOptionTiers(OptionTiers var1) {
      this.optionTiers = var1;
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

   public int getChoixDocument() {
      return this.choixDocument;
   }

   public void setChoixDocument(int var1) {
      this.choixDocument = var1;
   }

   public String getChoixFamilles() {
      return this.choixFamilles;
   }

   public void setChoixFamilles(String var1) {
      this.choixFamilles = var1;
   }

   public String getChoixProduit() {
      return this.choixProduit;
   }

   public void setChoixProduit(String var1) {
      this.choixProduit = var1;
   }

   public DataModel getDataModelDocuments() {
      return this.dataModelDocuments;
   }

   public void setDataModelDocuments(DataModel var1) {
      this.dataModelDocuments = var1;
   }

   public DataModel getDataModelDocumentsEntete() {
      return this.dataModelDocumentsEntete;
   }

   public void setDataModelDocumentsEntete(DataModel var1) {
      this.dataModelDocumentsEntete = var1;
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

   public DocumentEntete getDocumentEntete() {
      return this.documentEntete;
   }

   public void setDocumentEntete(DocumentEntete var1) {
      this.documentEntete = var1;
   }

   public List getMesFamilles() {
      return this.mesFamilles;
   }

   public void setMesFamilles(List var1) {
      this.mesFamilles = var1;
   }

   public float getVar_qte() {
      return this.var_qte;
   }

   public void setVar_qte(float var1) {
      this.var_qte = var1;
   }

   public double getVar_reglement() {
      return this.var_reglement;
   }

   public void setVar_reglement(double var1) {
      this.var_reglement = var1;
   }

   public double getVar_solde() {
      return this.var_solde;
   }

   public void setVar_solde(double var1) {
      this.var_solde = var1;
   }

   public double getVar_total() {
      return this.var_total;
   }

   public void setVar_total(double var1) {
      this.var_total = var1;
   }

   public String getSource() {
      return this.source;
   }

   public void setSource(String var1) {
      this.source = var1;
   }

   public OptionVentes getOptionVentes() {
      return this.optionVentes;
   }

   public void setOptionVentes(OptionVentes var1) {
      this.optionVentes = var1;
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

   public String getCodeAgence() {
      return this.codeAgence;
   }

   public void setCodeAgence(String var1) {
      this.codeAgence = var1;
   }

   public List getMesPdvItems() {
      return this.mesPdvItems;
   }

   public void setMesPdvItems(List var1) {
      this.mesPdvItems = var1;
   }
}
