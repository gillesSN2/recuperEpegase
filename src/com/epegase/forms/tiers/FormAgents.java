package com.epegase.forms.tiers;

import com.epegase.forms.office.FormMessagerie;
import com.epegase.systeme.classe.AvoirLigneAchats;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.CommandeLigneAchats;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.CotationLigneAchats;
import com.epegase.systeme.classe.DevisLigneVentes;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureLigneAchats;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FraisLigneAchats;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.NoteDebitLigneAchats;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Rdv;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.RetourLigneAchats;
import com.epegase.systeme.classe.RetourLigneVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Taches;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.dao.AvoirLigneAchatsDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.CommandeLigneAchatsDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.CotationLigneAchatsDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FactureLigneAchatsDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FraisLigneAchatsDao;
import com.epegase.systeme.dao.GroupeDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneAchatsDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.RdvDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.RetourLigneAchatsDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TachesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilGoogleMap;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilSms;
import com.epegase.systeme.xml.LectureNatureRdv;
import com.epegase.systeme.xml.LireLesoptionsTiers;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionTiers;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
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

public class FormAgents implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionTiers optionTiers;
   private int var_action;
   private String pageIndex;
   private ObjetLigneMenu ligneMenu;
   private Users users;
   private UserDao userDao;
   private List userList = new ArrayList();
   private ExercicesVentes exercicesVentes;
   private ExercicesAchats exercicesAchats;
   private transient DataModel dataModelUser = new ListDataModel();
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
   private List mesNaturesRdvItems = new ArrayList();
   private String nomRec;
   private String groupeRec;
   private String fonctionRec;
   private String serviceRec;
   private List groupeItems = new ArrayList();
   private List serviceItems = new ArrayList();
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
   private boolean showModalPanelRdv = false;
   private transient DataModel dataModelPlanning;
   private List lesPlanning;
   private Rdv newRdv;
   private int typeRdv;
   private String selectedUserdest;
   private boolean testRdv = false;
   private List mesTachesItem;
   private String choixTache;
   private int choixRdv;
   private FormMessagerie formMessagerie;
   private boolean showModalPanelMessagerie = false;
   private DocumentEntete documentEntete;
   private transient DataModel dataModelDocuments;
   private List lesDocumentsDetail;
   private transient DataModel dataModelDocumentsEntete;
   private List lesDocumentsEntete;
   private int choixDocument;
   private String choixProduit;
   private String choixFamilles;
   private Date dateDebut;
   private Date dateFin;
   private List mesFamilles;
   private float var_qte;
   private double var_total;
   private double var_reglement;
   private double var_solde;
   private double caHt;
   private int nbDoc;
   private double caMoyen;
   private int sansSources;
   private double caTrf;
   private int nbTrf;
   private float tauxTrf;
   private int nbJour;
   private double caJour;
   private float tauxJour;
   private int nbProduit;
   private double prixMoyen;
   private double caTiers;
   private int nbTiers;
   private float tauxTiers;
   private boolean showModalPanelSms = false;
   private String numeroMobile;
   private String messageSms;
   private List lesConseillers = new ArrayList();
   private List lesTiers = new ArrayList();
   private transient DataModel dataModelListeTiers = new ListDataModel();
   private TiersDao tiersDao;
   private ResponsableDao responsableDao;
   private boolean showModalPanelListeTiers = false;
   private List mesConseillersItems = new ArrayList();
   private long idConseiller;

   public FormAgents() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.responsableDao = new ResponsableDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererOptionsTiers(Session var1) throws NamingException {
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
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesVentes = var2.recupererLastExo(var1);
      this.exercicesAchats = new ExercicesAchats();
      ExercicesAchatsDao var3 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.exercicesAchats = var3.recupererLastExo(var1);
      this.mesNaturesRdvItems.clear();
      LectureNatureRdv var4 = new LectureNatureRdv(this.baseLog);
      new ArrayList();
      List var5 = var4.getMesNatureRdvUtil();

      for(int var6 = 0; var6 < var5.size(); ++var6) {
         if (((ObjetCompte)var5.get(var6)).isValide()) {
            this.mesNaturesRdvItems.add(new SelectItem(((ObjetCompte)var5.get(var6)).getCode(), ((ObjetCompte)var5.get(var6)).getCode() + ":" + ((ObjetCompte)var5.get(var6)).getNom_FR()));
         }
      }

      if (this.mesNaturesRdvItems == null || this.mesNaturesRdvItems.size() == 0) {
         this.mesNaturesRdvItems.add(new SelectItem("1", "1:Rdv (défaut)"));
      }

   }

   public void chargerGroupes(Session var1) throws IOException, HibernateException, NamingException {
      this.groupeItems.clear();
      GroupeDao var2 = new GroupeDao(this.baseLog, this.utilInitHibernate);
      this.groupeItems = var2.selectGroupeItems(var1);
   }

   public void chargerServices(Session var1) throws HibernateException, NamingException {
      this.serviceItems.clear();
      ServiceDao var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.serviceItems = var2.chargerLesServicesItems(0, false, var1);
   }

   public void annuleSaisie() {
      this.var_action = 0;
      this.afficheButtOption = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void chargerLesAgents() throws HibernateException, NamingException {
      this.rechercherAgents();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.userList = this.userDao.chargerByRequete(this.rechercherAgents(), (Session)null);
      this.dataModelUser.setWrappedData(this.userList);
      this.afficheButtOption = false;
   }

   public String rechercherAgents() {
      String var1 = "from Users where usrSysteme<=3  and usrEtat=1";
      if (this.nomRec != null && !this.nomRec.isEmpty()) {
         var1 = var1 + " and usrNom LIKE" + "'" + this.nomRec + "%'";
      }

      if (!this.groupeRec.equals("100")) {
         var1 = var1 + " and usrCollaboration='" + this.groupeRec + "'";
      }

      if (this.fonctionRec != null && !this.fonctionRec.isEmpty()) {
         if (this.fonctionRec.equals("VENDEURS")) {
            var1 = var1 + " and usrVendeur=1";
         } else if (this.fonctionRec.equals("CAISSIERS")) {
            var1 = var1 + " and usrCaissier>=1";
         } else if (this.fonctionRec.equals("SIGNATAIRES")) {
            var1 = var1 + " and usrSignatureOffice=1 or usrSignatureCompta=1 or usrSignaturePaye=1 or usrSignatureParc=1 or usrSignatureAchats=1 or usrSignatureVentes=1";
         } else if (!this.fonctionRec.equals("100")) {
            var1 = var1 + " and usrFonction='" + this.fonctionRec + "'";
         }
      }

      if (!this.serviceRec.equals("100")) {
         var1 = var1 + " and usrService='" + this.serviceRec + "'";
      }

      return var1;
   }

   public void consulterAgents() {
      this.var_action = 3;
   }

   public void selectionAgents() {
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
            this.users = (Users)var1.get(0);
            this.afficheButtOption = true;
         } else {
            this.afficheButtOption = false;
         }
      } else {
         this.afficheButtOption = false;
      }

   }

   public void visualisationAgents() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.users != null) {
         this.consulterAgents();
      }

   }

   public void googleMap() throws IOException, URISyntaxException {
      UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
      this.uri = var1.calculMap((String)null, this.users.getUsrAdresse(), this.users.getUsrVille(), this.users.getUsrNomPays());
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
         this.var_action = 6;
      }

   }

   public void retourDocuments() {
      this.var_action = 0;
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

      if (this.choixDocument == 11) {
         this.cotationAchats(var2, var3, (Session)null);
      } else if (this.choixDocument == 12) {
         this.commandeAchats(var2, var3, (Session)null);
      } else if (this.choixDocument == 13) {
         this.receptionAchats(var2, var3, (Session)null);
      } else if (this.choixDocument == 14) {
         this.retourAchats(var2, var3, (Session)null);
      } else if (this.choixDocument == 15) {
         this.factureAchats(var2, var3, (Session)null);
         this.avoirAchats(var2, var3, (Session)null);
         this.noteDebitAchats(var2, var3, (Session)null);
         this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
         this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
      } else if (this.choixDocument == 18) {
         this.fraisAchats(var2, var3, (Session)null);
      } else if (this.choixDocument == 21) {
         this.devisVentes(var2, var3, (Session)null);
      } else if (this.choixDocument == 22) {
         this.commandeVentes(var2, var3, (Session)null);
      } else if (this.choixDocument == 23) {
         this.livraisonVentes(var2, var3, (Session)null);
      } else if (this.choixDocument == 24) {
         this.retourVentes(var2, var3, (Session)null);
      } else if (this.choixDocument == 25) {
         this.factureVentes(var2, var3, 0, (Session)null);
         this.avoirVentes(var2, var3, (Session)null);
         this.noteDebitVentes(var2, var3, 0, (Session)null);
         this.var_solde = this.var_total - this.var_reglement;
         this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
         this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
      } else if (this.choixDocument == 251) {
         this.factureVentes(var2, var3, 1, (Session)null);
         this.avoirVentes(var2, var3, (Session)null);
         this.noteDebitVentes(var2, var3, 0, (Session)null);
         this.var_solde = this.var_total - this.var_reglement;
         this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
         this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
      }

      this.calculStatistique();
   }

   public void cotationAchats(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      CotationLigneAchatsDao var5 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerLesMvtsUsers(this.usersLog, var1, var2, (Session)null);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new CotationLigneAchats();
            CotationLigneAchats var7 = (CotationLigneAchats)var4.get(var6);
            DocumentEntete var8 = new DocumentEntete();
            Stock var9 = new Stock();
            var9.setStk_lib_type("Cotation");
            var9.setStkFamille(var7.getCotligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var9.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var7.getCotligCode().startsWith(this.choixProduit))) {
               boolean var10 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var11 = 0; var11 < this.lesDocumentsEntete.size(); ++var11) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var11)).getDocNum().equals(var7.getCotationEnteteAchats().getCotNum())) {
                        var10 = true;
                        break;
                     }
                  }
               } else {
                  var10 = false;
               }

               if (!var10) {
                  var8.setVar_lib_nat("Cotation");
                  var8.setDocEtat(var7.getCotationEnteteAchats().getCotEtat());
                  var8.setDocIdCreateur(var7.getCotationEnteteAchats().getTiers().getTieid());
                  var8.setDocDate(var7.getCotationEnteteAchats().getCotDate());
                  var8.setDocNum(var7.getCotationEnteteAchats().getCotNum());
                  var8.setDocNomTiers(var7.getCotationEnteteAchats().getCotNomTiers());
                  var8.setDocObject(var7.getCotationEnteteAchats().getCotObject());
                  var8.setDocSource("");
                  var8.setDocNomContact(var7.getCotationEnteteAchats().getCotNomContact());
                  var8.setDocNomCaissier("");
                  var8.setDocNomResponsable(var7.getCotationEnteteAchats().getCotNomResponsable());
                  var8.setDocTotHt(var7.getCotationEnteteAchats().getCotTotHt());
                  var8.setDocTotTva(var7.getCotationEnteteAchats().getCotTotTva());
                  var8.setDocTotTtc(var7.getCotationEnteteAchats().getCotTotTtc());
                  var8.setDocTotReglement(0.0D);
                  var8.setDocAPayer(0.0D);
                  this.var_total += var8.getDocTotTtc();
                  this.var_reglement += var8.getDocTotReglement();
                  this.lesDocumentsEntete.add(var8);
               }

               var9.setStk_date_mvt(var7.getCotationEnteteAchats().getCotDate());
               var9.setStk_numero(var7.getCotationEnteteAchats().getCotNum());
               var9.setStk_code_produit(var7.getCotligCode());
               var9.setStkLibelle(var7.getCotligLibelle());
               var9.setStk_code_depot("");
               var9.setStkPuRem(var7.getCotligPuRem());
               var9.setStk_pump(var7.getCotligPump());
               var9.setStk_qte_progress(var7.getCotligQte());
               var9.setStkPt(var7.getCotligPt());
               this.var_qte += var9.getStk_qte_progress();
               this.lesDocumentsDetail.add(var9);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void commandeAchats(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      CommandeLigneAchatsDao var5 = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerLesMvtsUsers(this.usersLog, var1, var2, (Session)null);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new CommandeLigneAchats();
            CommandeLigneAchats var7 = (CommandeLigneAchats)var4.get(var6);
            DocumentEntete var8 = new DocumentEntete();
            Stock var9 = new Stock();
            var9.setStk_lib_type("Commande");
            var9.setStkFamille(var7.getCmdligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var9.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var7.getCmdligCode().startsWith(this.choixProduit))) {
               boolean var10 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var11 = 0; var11 < this.lesDocumentsEntete.size(); ++var11) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var11)).getDocNum().equals(var7.getCommandeEnteteAchats().getCmdNum())) {
                        var10 = true;
                        break;
                     }
                  }
               } else {
                  var10 = false;
               }

               if (!var10) {
                  var8.setVar_lib_nat("Commande");
                  var8.setDocEtat(var7.getCommandeEnteteAchats().getCmdEtat());
                  var8.setDocIdCreateur(var7.getCommandeEnteteAchats().getTiers().getTieid());
                  var8.setDocDate(var7.getCommandeEnteteAchats().getCmdDate());
                  var8.setDocNum(var7.getCommandeEnteteAchats().getCmdNum());
                  var8.setDocNomTiers(var7.getCommandeEnteteAchats().getCmdNomTiers());
                  var8.setDocObject(var7.getCommandeEnteteAchats().getCmdObject());
                  var8.setDocSource("");
                  var8.setDocNomContact(var7.getCommandeEnteteAchats().getCmdNomContact());
                  var8.setDocNomCaissier("");
                  var8.setDocNomResponsable(var7.getCommandeEnteteAchats().getCmdNomResponsable());
                  var8.setDocTotHt(var7.getCommandeEnteteAchats().getCmdTotHt());
                  var8.setDocTotTva(var7.getCommandeEnteteAchats().getCmdTotTva());
                  var8.setDocTotTtc(var7.getCommandeEnteteAchats().getCmdTotTtc());
                  var8.setDocTotReglement(0.0D);
                  var8.setDocAPayer(0.0D);
                  this.var_total += var8.getDocTotTtc();
                  this.var_reglement += var8.getDocTotReglement();
                  this.lesDocumentsEntete.add(var8);
               }

               var9.setStk_date_mvt(var7.getCommandeEnteteAchats().getCmdDate());
               var9.setStk_numero(var7.getCommandeEnteteAchats().getCmdNum());
               var9.setStk_code_produit(var7.getCmdligCode());
               var9.setStkLibelle(var7.getCmdligLibelle());
               var9.setStk_code_depot(var7.getCmdligDepot());
               var9.setStkPuRem(var7.getCmdligPuRem());
               var9.setStk_pump(var7.getCmdligPump());
               var9.setStk_qte_progress(var7.getCmdligQte());
               var9.setStkPt(var7.getCmdligPt());
               this.var_qte += var9.getStk_qte_progress();
               this.lesDocumentsDetail.add(var9);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void receptionAchats(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      ReceptionLigneAchatsDao var5 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerLesMvtsUsers(this.usersLog, var1, var2, (Session)null);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new ReceptionLigneAchats();
            ReceptionLigneAchats var7 = (ReceptionLigneAchats)var4.get(var6);
            DocumentEntete var8 = new DocumentEntete();
            Stock var9 = new Stock();
            var9.setStk_lib_type("Réception");
            var9.setStkFamille(var7.getRecligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var9.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var7.getRecligCode().startsWith(this.choixProduit))) {
               boolean var10 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var11 = 0; var11 < this.lesDocumentsEntete.size(); ++var11) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var11)).getDocNum().equals(var7.getReceptionEnteteAchats().getRecNum())) {
                        var10 = true;
                        break;
                     }
                  }
               } else {
                  var10 = false;
               }

               if (!var10) {
                  var8.setVar_lib_nat("Réception");
                  var8.setDocEtat(var7.getReceptionEnteteAchats().getRecEtat());
                  var8.setDocIdCreateur(var7.getReceptionEnteteAchats().getTiers().getTieid());
                  var8.setDocDate(var7.getReceptionEnteteAchats().getRecDate());
                  var8.setDocNum(var7.getReceptionEnteteAchats().getRecNum());
                  var8.setDocNomTiers(var7.getReceptionEnteteAchats().getRecNomTiers());
                  var8.setDocObject(var7.getReceptionEnteteAchats().getRecObject());
                  var8.setDocSource("");
                  var8.setDocNomContact(var7.getReceptionEnteteAchats().getRecNomContact());
                  var8.setDocNomCaissier("");
                  var8.setDocNomResponsable(var7.getReceptionEnteteAchats().getRecNomResponsable());
                  var8.setDocTotHt(var7.getReceptionEnteteAchats().getRecTotHt());
                  var8.setDocTotTva(var7.getReceptionEnteteAchats().getRecTotTva());
                  var8.setDocTotTtc(var7.getReceptionEnteteAchats().getRecTotTtc());
                  var8.setDocTotReglement(0.0D);
                  var8.setDocAPayer(0.0D);
                  this.var_total += var8.getDocTotTtc();
                  this.var_reglement += var8.getDocTotReglement();
                  this.lesDocumentsEntete.add(var8);
               }

               var9.setStk_date_mvt(var7.getReceptionEnteteAchats().getRecDate());
               var9.setStk_numero(var7.getReceptionEnteteAchats().getRecNum());
               var9.setStk_code_produit(var7.getRecligCode());
               var9.setStkLibelle(var7.getRecligLibelle());
               var9.setStk_code_depot(var7.getRecligDepot());
               var9.setStkPuRem(var7.getRecligPuRem());
               var9.setStk_pump(var7.getRecligPump());
               var9.setStk_qte_progress(var7.getRecligQte());
               var9.setStkPt(var7.getRecligPt());
               this.var_qte += var9.getStk_qte_progress();
               this.lesDocumentsDetail.add(var9);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void retourAchats(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      RetourLigneAchatsDao var5 = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerLesMvtsUsers(this.usersLog, var1, var2, (Session)null);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new RetourLigneAchats();
            RetourLigneAchats var7 = (RetourLigneAchats)var4.get(var6);
            DocumentEntete var8 = new DocumentEntete();
            Stock var9 = new Stock();
            var9.setStk_lib_type("Retour");
            var9.setStkFamille(var7.getBrfligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var9.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var7.getBrfligCode().startsWith(this.choixProduit))) {
               boolean var10 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var11 = 0; var11 < this.lesDocumentsEntete.size(); ++var11) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var11)).getDocNum().equals(var7.getRetourEnteteAchats().getBrfNum())) {
                        var10 = true;
                        break;
                     }
                  }
               } else {
                  var10 = false;
               }

               if (!var10) {
                  var8.setVar_lib_nat("Retour");
                  var8.setDocEtat(var7.getRetourEnteteAchats().getBrfEtat());
                  var8.setDocIdCreateur(var7.getRetourEnteteAchats().getTiers().getTieid());
                  var8.setDocDate(var7.getRetourEnteteAchats().getBrfDate());
                  var8.setDocNum(var7.getRetourEnteteAchats().getBrfNum());
                  var8.setDocNomTiers(var7.getRetourEnteteAchats().getBrfNomTiers());
                  var8.setDocObject(var7.getRetourEnteteAchats().getBrfObject());
                  var8.setDocSource("");
                  var8.setDocNomContact(var7.getRetourEnteteAchats().getBrfNomContact());
                  var8.setDocNomCaissier("");
                  var8.setDocNomResponsable(var7.getRetourEnteteAchats().getBrfNomResponsable());
                  var8.setDocTotHt(var7.getRetourEnteteAchats().getBrfTotHt());
                  var8.setDocTotTva(var7.getRetourEnteteAchats().getBrfTotTva());
                  var8.setDocTotTtc(var7.getRetourEnteteAchats().getBrfTotTtc());
                  var8.setDocTotReglement(0.0D);
                  var8.setDocAPayer(0.0D);
                  this.var_total += var8.getDocTotTtc();
                  this.var_reglement += var8.getDocTotReglement();
                  this.lesDocumentsEntete.add(var8);
               }

               var9.setStk_date_mvt(var7.getRetourEnteteAchats().getBrfDate());
               var9.setStk_numero(var7.getRetourEnteteAchats().getBrfNum());
               var9.setStk_code_produit(var7.getBrfligCode());
               var9.setStkLibelle(var7.getBrfligLibelle());
               var9.setStk_code_depot(var7.getBrfligDepot());
               var9.setStkPuRem(var7.getBrfligPuRem());
               var9.setStk_pump(var7.getBrfligPump());
               var9.setStk_qte_progress(var7.getBrfligQte());
               var9.setStkPt(var7.getBrfligPt());
               this.var_qte += var9.getStk_qte_progress();
               this.lesDocumentsDetail.add(var9);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void noteDebitAchats(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      NoteDebitLigneAchatsDao var5 = new NoteDebitLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerLesMvtsUsers(this.usersLog, var1, var2, (Session)null);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new NoteDebitLigneAchats();
            NoteDebitLigneAchats var7 = (NoteDebitLigneAchats)var4.get(var6);
            DocumentEntete var8 = new DocumentEntete();
            Stock var9 = new Stock();
            var9.setStk_lib_type("NoteDebit");
            var9.setStkFamille(var7.getNdfligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var9.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var7.getNdfligCode().startsWith(this.choixProduit))) {
               boolean var10 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var11 = 0; var11 < this.lesDocumentsEntete.size(); ++var11) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var11)).getDocNum().equals(var7.getNoteDebitEnteteAchats().getNdfNum())) {
                        var10 = true;
                        break;
                     }
                  }
               } else {
                  var10 = false;
               }

               if (!var10) {
                  var8.setVar_lib_nat("Note débit");
                  var8.setDocEtat(var7.getNoteDebitEnteteAchats().getNdfEtat());
                  var8.setDocIdCreateur(var7.getNoteDebitEnteteAchats().getTiers().getTieid());
                  var8.setDocDate(var7.getNoteDebitEnteteAchats().getNdfDate());
                  var8.setDocNum(var7.getNoteDebitEnteteAchats().getNdfNum());
                  var8.setDocNomTiers(var7.getNoteDebitEnteteAchats().getNdfNomTiers());
                  var8.setDocObject(var7.getNoteDebitEnteteAchats().getNdfObject());
                  var8.setDocSource("");
                  var8.setDocNomContact(var7.getNoteDebitEnteteAchats().getNdfNomContact());
                  var8.setDocNomCaissier("");
                  var8.setDocNomResponsable(var7.getNoteDebitEnteteAchats().getNdfNomResponsable());
                  var8.setDocTotHt(var7.getNoteDebitEnteteAchats().getNdfTotHt());
                  var8.setDocTotTva(var7.getNoteDebitEnteteAchats().getNdfTotTva());
                  var8.setDocTotTtc(var7.getNoteDebitEnteteAchats().getNdfTotTtc());
                  var8.setDocTotReglement(var7.getNoteDebitEnteteAchats().getNdfTotReglement());
                  var8.setDocAPayer(var7.getNoteDebitEnteteAchats().getNdfTotTtc() - var7.getNoteDebitEnteteAchats().getNdfTotReglement());
                  this.var_total += var8.getDocTotTtc();
                  this.var_reglement += var8.getDocTotReglement();
                  this.lesDocumentsEntete.add(var8);
               }

               var9.setStk_date_mvt(var7.getNoteDebitEnteteAchats().getNdfDate());
               var9.setStk_numero(var7.getNoteDebitEnteteAchats().getNdfNum());
               var9.setStk_code_produit(var7.getNdfligCode());
               var9.setStkLibelle(var7.getNdfligLibelle());
               var9.setStk_code_depot("");
               var9.setStkPuRem(var7.getNdfligPuRem());
               var9.setStk_pump(var7.getNdfligPump());
               var9.setStk_qte_progress(var7.getNdfligQte());
               var9.setStkPt(var7.getNdfligPt());
               this.var_qte += var9.getStk_qte_progress();
               this.lesDocumentsDetail.add(var9);
            }
         }
      }

   }

   public void factureAchats(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      FactureLigneAchatsDao var5 = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerLesMvtsUsers(this.usersLog, var1, var2, (Session)null);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new FactureLigneAchats();
            FactureLigneAchats var7 = (FactureLigneAchats)var4.get(var6);
            DocumentEntete var8 = new DocumentEntete();
            Stock var9 = new Stock();
            var9.setStk_lib_type("Facture");
            var9.setStkFamille(var7.getFcfligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var9.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var7.getFcfligCode().startsWith(this.choixProduit))) {
               boolean var10 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var11 = 0; var11 < this.lesDocumentsEntete.size(); ++var11) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var11)).getDocNum().equals(var7.getFactureEnteteAchats().getFcfNum())) {
                        var10 = true;
                        break;
                     }
                  }
               } else {
                  var10 = false;
               }

               if (!var10) {
                  var8.setVar_lib_nat("Facture");
                  var8.setDocEtat(var7.getFactureEnteteAchats().getFcfEtat());
                  var8.setDocIdCreateur(var7.getFactureEnteteAchats().getTiers().getTieid());
                  var8.setDocDate(var7.getFactureEnteteAchats().getFcfDate());
                  var8.setDocNum(var7.getFactureEnteteAchats().getFcfNum());
                  var8.setDocNomTiers(var7.getFactureEnteteAchats().getFcfNomTiers());
                  var8.setDocObject(var7.getFactureEnteteAchats().getFcfObject());
                  var8.setDocSource("");
                  var8.setDocNomContact(var7.getFactureEnteteAchats().getFcfNomContact());
                  var8.setDocNomCaissier("");
                  var8.setDocNomResponsable(var7.getFactureEnteteAchats().getFcfNomResponsable());
                  var8.setDocTotHt(var7.getFactureEnteteAchats().getFcfTotHt());
                  var8.setDocTotTva(var7.getFactureEnteteAchats().getFcfTotTva());
                  var8.setDocTotTtc(var7.getFactureEnteteAchats().getFcfTotTtc());
                  var8.setDocTotReglement(var7.getFactureEnteteAchats().getFcfTotReglement());
                  var8.setDocAPayer(var7.getFactureEnteteAchats().getFcfTotTtc() - var7.getFactureEnteteAchats().getFcfTotReglement());
                  this.var_total += var8.getDocTotTtc();
                  this.var_reglement += var8.getDocTotReglement();
                  this.lesDocumentsEntete.add(var8);
               }

               var9.setStk_date_mvt(var7.getFactureEnteteAchats().getFcfDate());
               var9.setStk_numero(var7.getFactureEnteteAchats().getFcfNum());
               var9.setStk_code_produit(var7.getFcfligCode());
               var9.setStkLibelle(var7.getFcfligLibelle());
               var9.setStk_code_depot(var7.getFcfligDepot());
               var9.setStkPuRem(var7.getFcfligPuRem());
               var9.setStk_pump(var7.getFcfligPump());
               var9.setStk_qte_progress(var7.getFcfligQte());
               var9.setStkPt(var7.getFcfligPt());
               this.var_qte += var9.getStk_qte_progress();
               this.lesDocumentsDetail.add(var9);
            }
         }
      }

   }

   public void avoirAchats(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      AvoirLigneAchatsDao var5 = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerLesMvtsUsers(this.usersLog, var1, var2, (Session)null);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new AvoirLigneAchats();
            AvoirLigneAchats var7 = (AvoirLigneAchats)var4.get(var6);
            DocumentEntete var8 = new DocumentEntete();
            Stock var9 = new Stock();
            var9.setStk_lib_type("Avoir");
            var9.setStkFamille(var7.getAvfligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var9.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var7.getAvfligCode().startsWith(this.choixProduit))) {
               boolean var10 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var11 = 0; var11 < this.lesDocumentsEntete.size(); ++var11) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var11)).getDocNum().equals(var7.getAvoirEnteteAchats().getAvfNum())) {
                        var10 = true;
                        break;
                     }
                  }
               } else {
                  var10 = false;
               }

               if (!var10) {
                  var8.setVar_lib_nat("Avoir");
                  var8.setDocEtat(var7.getAvoirEnteteAchats().getAvfEtat());
                  var8.setDocIdCreateur(var7.getAvoirEnteteAchats().getTiers().getTieid());
                  var8.setDocDate(var7.getAvoirEnteteAchats().getAvfDate());
                  var8.setDocNum(var7.getAvoirEnteteAchats().getAvfNum());
                  var8.setDocNomTiers(var7.getAvoirEnteteAchats().getAvfNomTiers());
                  var8.setDocObject(var7.getAvoirEnteteAchats().getAvfObject());
                  var8.setDocSource("");
                  var8.setDocNomContact(var7.getAvoirEnteteAchats().getAvfNomContact());
                  var8.setDocNomCaissier("");
                  var8.setDocNomResponsable(var7.getAvoirEnteteAchats().getAvfNomResponsable());
                  var8.setDocTotHt(var7.getAvoirEnteteAchats().getAvfTotHt() * -1.0D);
                  var8.setDocTotTva(var7.getAvoirEnteteAchats().getAvfTotTva() * -1.0D);
                  var8.setDocTotTtc(var7.getAvoirEnteteAchats().getAvfTotTtc() * -1.0D);
                  var8.setDocTotReglement(0.0D);
                  var8.setDocAPayer(0.0D);
                  this.var_total += var8.getDocTotTtc();
                  this.var_reglement += var8.getDocTotReglement();
                  this.lesDocumentsEntete.add(var8);
               }

               var9.setStk_date_mvt(var7.getAvoirEnteteAchats().getAvfDate());
               var9.setStk_numero(var7.getAvoirEnteteAchats().getAvfNum());
               var9.setStk_code_produit(var7.getAvfligCode());
               var9.setStkLibelle(var7.getAvfligLibelle());
               var9.setStk_code_depot("");
               var9.setStkPuRem(var7.getAvfligPuRem() * -1.0D);
               var9.setStk_pump(var7.getAvfligPump() * -1.0D);
               var9.setStk_qte_progress(var7.getAvfligQte() * -1.0F);
               var9.setStkPt(var7.getAvfligPt() * -1.0D);
               this.var_qte += var9.getStk_qte_progress();
               this.lesDocumentsDetail.add(var9);
            }
         }
      }

   }

   public void fraisAchats(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      FraisLigneAchatsDao var5 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerLesMvtsUsers(this.usersLog, var1, var2, (Session)null);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new FraisLigneAchats();
            FraisLigneAchats var7 = (FraisLigneAchats)var4.get(var6);
            DocumentEntete var8 = new DocumentEntete();
            Stock var9 = new Stock();
            var9.setStk_lib_type("Frais");
            var9.setStkFamille(var7.getFsfligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var9.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var7.getFsfligCode().startsWith(this.choixProduit))) {
               boolean var10 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var11 = 0; var11 < this.lesDocumentsEntete.size(); ++var11) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var11)).getDocNum().equals(var7.getFraisEnteteAchats().getFsfNum())) {
                        var10 = true;
                        break;
                     }
                  }
               } else {
                  var10 = false;
               }

               if (!var10) {
                  var8.setVar_lib_nat("Frais");
                  var8.setDocEtat(var7.getFraisEnteteAchats().getFsfEtat());
                  var8.setDocIdCreateur(var7.getFraisEnteteAchats().getTiers().getTieid());
                  var8.setDocDate(var7.getFraisEnteteAchats().getFsfDate());
                  var8.setDocNum(var7.getFraisEnteteAchats().getFsfNum());
                  var8.setDocNomTiers(var7.getFraisEnteteAchats().getFsfNomTiers());
                  var8.setDocObject(var7.getFraisEnteteAchats().getFsfObject());
                  var8.setDocSource("");
                  var8.setDocNomContact(var7.getFraisEnteteAchats().getFsfNomContact());
                  var8.setDocNomCaissier("");
                  var8.setDocNomResponsable(var7.getFraisEnteteAchats().getFsfNomResponsable());
                  var8.setDocTotHt(var7.getFraisEnteteAchats().getFsfTotHt());
                  var8.setDocTotTva(var7.getFraisEnteteAchats().getFsfTotTva());
                  var8.setDocTotTtc(var7.getFraisEnteteAchats().getFsfTotTtc());
                  var8.setDocTotReglement(var7.getFraisEnteteAchats().getFsfTotReglement());
                  var8.setDocAPayer(var7.getFraisEnteteAchats().getFsfTotTtc() - var7.getFraisEnteteAchats().getFsfTotReglement());
                  this.var_total += var8.getDocTotTtc();
                  this.var_reglement += var8.getDocTotReglement();
                  this.lesDocumentsEntete.add(var8);
               }

               var9.setStk_date_mvt(var7.getFraisEnteteAchats().getFsfDate());
               var9.setStk_numero(var7.getFraisEnteteAchats().getFsfNum());
               var9.setStk_code_produit(var7.getFsfligCode());
               var9.setStkLibelle(var7.getFsfligLibelle());
               var9.setStk_code_depot("");
               var9.setStkPuRem(var7.getFsfligPuRem());
               var9.setStk_pump(var7.getFsfligPump());
               var9.setStk_qte_progress(var7.getFsfligQte());
               var9.setStkPt(var7.getFsfligPt());
               this.var_qte += var9.getStk_qte_progress();
               this.lesDocumentsDetail.add(var9);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void devisVentes(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      DevisLigneVentesDao var5 = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerLesMvtsUsers(this.usersLog, var1, var2, (Session)null);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new DevisLigneVentes();
            DevisLigneVentes var7 = (DevisLigneVentes)var4.get(var6);
            DocumentEntete var8 = new DocumentEntete();
            Stock var9 = new Stock();
            var9.setStk_lib_type("Devis");
            var9.setStkFamille(var7.getDvsligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var9.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var7.getDvsligCode().startsWith(this.choixProduit))) {
               boolean var10 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var11 = 0; var11 < this.lesDocumentsEntete.size(); ++var11) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var11)).getDocNum().equals(var7.getDevisEnteteVentes().getDvsNum())) {
                        var10 = true;
                        break;
                     }
                  }
               } else {
                  var10 = false;
               }

               if (!var10) {
                  var8.setVar_lib_nat("Devis");
                  var8.setDocEtat(var7.getDevisEnteteVentes().getDvsEtat());
                  var8.setDocIdCreateur(var7.getDevisEnteteVentes().getTiers().getTieid());
                  var8.setDocDate(var7.getDevisEnteteVentes().getDvsDate());
                  var8.setDocNum(var7.getDevisEnteteVentes().getDvsNum());
                  var8.setDocNomTiers(var7.getDevisEnteteVentes().getDvsNomTiers());
                  var8.setDocObject(var7.getDevisEnteteVentes().getDvsObject());
                  var8.setDocSource(var7.getDevisEnteteVentes().getDvsSource());
                  var8.setDocNomContact(var7.getDevisEnteteVentes().getDvsNomContact());
                  var8.setDocNomCaissier(var7.getDevisEnteteVentes().getDvsNomCommercial());
                  var8.setDocNomResponsable(var7.getDevisEnteteVentes().getDvsNomResponsable());
                  var8.setDocTotHt(var7.getDevisEnteteVentes().getDvsTotHt());
                  var8.setDocTotTva(var7.getDevisEnteteVentes().getDvsTotTva());
                  var8.setDocTotTtc(var7.getDevisEnteteVentes().getDvsTotTtc());
                  var8.setDocTotReglement(0.0D);
                  var8.setDocAPayer(0.0D);
                  this.var_total += var8.getDocTotTtc();
                  this.var_reglement += var8.getDocTotReglement();
                  this.lesDocumentsEntete.add(var8);
               }

               var9.setStk_date_mvt(var7.getDevisEnteteVentes().getDvsDate());
               var9.setStk_numero(var7.getDevisEnteteVentes().getDvsNum());
               var9.setStk_code_produit(var7.getDvsligCode());
               var9.setStkLibelle(var7.getDvsligLibelle());
               var9.setStk_code_depot(var7.getDvsligDepot());
               var9.setStkPuRem(var7.getDvsligPuRem());
               var9.setStk_pump(var7.getDvsligPump());
               var9.setStk_qte_progress(var7.getDvsligQte());
               var9.setStkPt(var7.getDvsligPt());
               this.var_qte += var9.getStk_qte_progress();
               this.lesDocumentsDetail.add(var9);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void commandeVentes(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      CommandeLigneVentesDao var5 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerLesMvtsUsers(this.usersLog, var1, var2, (Session)null);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new CommandeLigneVentes();
            CommandeLigneVentes var7 = (CommandeLigneVentes)var4.get(var6);
            DocumentEntete var8 = new DocumentEntete();
            Stock var9 = new Stock();
            var9.setStk_lib_type("Commande");
            var9.setStkFamille(var7.getBcmligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var9.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var7.getBcmligCode().startsWith(this.choixProduit))) {
               boolean var10 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var11 = 0; var11 < this.lesDocumentsEntete.size(); ++var11) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var11)).getDocNum().equals(var7.getCommandeEnteteVentes().getBcmNum())) {
                        var10 = true;
                        break;
                     }
                  }
               } else {
                  var10 = false;
               }

               if (!var10) {
                  var8.setVar_lib_nat("Commande");
                  var8.setDocEtat(var7.getCommandeEnteteVentes().getBcmEtat());
                  var8.setDocIdCreateur(var7.getCommandeEnteteVentes().getTiers().getTieid());
                  var8.setDocDate(var7.getCommandeEnteteVentes().getBcmDate());
                  var8.setDocNum(var7.getCommandeEnteteVentes().getBcmNum());
                  var8.setDocNomTiers(var7.getCommandeEnteteVentes().getBcmNomTiers());
                  var8.setDocObject(var7.getCommandeEnteteVentes().getBcmObject());
                  var8.setDocSource(var7.getCommandeEnteteVentes().getBcmSource());
                  var8.setDocNomContact(var7.getCommandeEnteteVentes().getBcmNomContact());
                  var8.setDocNomCaissier(var7.getCommandeEnteteVentes().getBcmNomCommercial());
                  var8.setDocNomResponsable(var7.getCommandeEnteteVentes().getBcmNomResponsable());
                  var8.setDocTotHt(var7.getCommandeEnteteVentes().getBcmTotHt());
                  var8.setDocTotTva(var7.getCommandeEnteteVentes().getBcmTotTva());
                  var8.setDocTotTtc(var7.getCommandeEnteteVentes().getBcmTotTtc());
                  var8.setDocTotReglement(0.0D);
                  var8.setDocAPayer(0.0D);
                  this.var_total += var8.getDocTotTtc();
                  this.var_reglement += var8.getDocTotReglement();
                  this.lesDocumentsEntete.add(var8);
               }

               var9.setStk_date_mvt(var7.getCommandeEnteteVentes().getBcmDate());
               var9.setStk_numero(var7.getCommandeEnteteVentes().getBcmNum());
               var9.setStk_code_produit(var7.getBcmligCode());
               var9.setStkLibelle(var7.getBcmligLibelle());
               var9.setStk_code_depot(var7.getBcmligDepot());
               var9.setStkPuRem(var7.getBcmligPuRem());
               var9.setStk_pump(var7.getBcmligPump());
               var9.setStk_qte_progress(var7.getBcmligQte());
               var9.setStkPt(var7.getBcmligPt());
               this.var_qte += var9.getStk_qte_progress();
               this.lesDocumentsDetail.add(var9);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void livraisonVentes(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      LivraisonLigneVentesDao var5 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerLesMvtsUsers(this.usersLog, var1, var2, (Session)null);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new LivraisonLigneVentes();
            LivraisonLigneVentes var7 = (LivraisonLigneVentes)var4.get(var6);
            DocumentEntete var8 = new DocumentEntete();
            Stock var9 = new Stock();
            var9.setStk_lib_type("Livraison");
            var9.setStkFamille(var7.getBlvligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var9.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var7.getBlvligCode().startsWith(this.choixProduit))) {
               boolean var10 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var11 = 0; var11 < this.lesDocumentsEntete.size(); ++var11) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var11)).getDocNum().equals(var7.getLivraisonEnteteVentes().getBlvNum())) {
                        var10 = true;
                        break;
                     }
                  }
               } else {
                  var10 = false;
               }

               if (!var10) {
                  var8.setVar_lib_nat("Livraison");
                  var8.setDocEtat(var7.getLivraisonEnteteVentes().getBlvEtat());
                  var8.setDocIdCreateur(var7.getLivraisonEnteteVentes().getTiers().getTieid());
                  var8.setDocDate(var7.getLivraisonEnteteVentes().getBlvDate());
                  var8.setDocNum(var7.getLivraisonEnteteVentes().getBlvNum());
                  var8.setDocNomTiers(var7.getLivraisonEnteteVentes().getBlvNomTiers());
                  var8.setDocObject(var7.getLivraisonEnteteVentes().getBlvObject());
                  var8.setDocSource(var7.getLivraisonEnteteVentes().getBlvSource());
                  var8.setDocNomContact(var7.getLivraisonEnteteVentes().getBlvNomContact());
                  var8.setDocNomCaissier(var7.getLivraisonEnteteVentes().getBlvNomCommercial());
                  var8.setDocNomResponsable(var7.getLivraisonEnteteVentes().getBlvNomResponsable());
                  var8.setDocTotHt(var7.getLivraisonEnteteVentes().getBlvTotHt());
                  var8.setDocTotTva(var7.getLivraisonEnteteVentes().getBlvTotTva());
                  var8.setDocTotTtc(var7.getLivraisonEnteteVentes().getBlvTotTtc());
                  var8.setDocTotReglement(0.0D);
                  var8.setDocAPayer(0.0D);
                  this.var_total += var8.getDocTotTtc();
                  this.var_reglement += var8.getDocTotReglement();
                  this.lesDocumentsEntete.add(var8);
               }

               var9.setStk_date_mvt(var7.getLivraisonEnteteVentes().getBlvDate());
               var9.setStk_numero(var7.getLivraisonEnteteVentes().getBlvNum());
               var9.setStk_code_produit(var7.getBlvligCode());
               var9.setStkLibelle(var7.getBlvligLibelle());
               var9.setStk_code_depot(var7.getBlvligDepot());
               var9.setStkPuRem(var7.getBlvligPuRem());
               var9.setStk_pump(var7.getBlvligPump());
               var9.setStk_qte_progress(var7.getBlvligQte());
               var9.setStkPt(var7.getBlvligPt());
               this.var_qte += var9.getStk_qte_progress();
               this.lesDocumentsDetail.add(var9);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void retourVentes(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      RetourLigneVentesDao var5 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerLesMvtsUsers(this.usersLog, var1, var2, (Session)null);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new RetourLigneVentes();
            RetourLigneVentes var7 = (RetourLigneVentes)var4.get(var6);
            DocumentEntete var8 = new DocumentEntete();
            Stock var9 = new Stock();
            var9.setStk_lib_type("Retour");
            var9.setStkFamille(var7.getBrtligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var9.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var7.getBrtligCode().startsWith(this.choixProduit))) {
               boolean var10 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var11 = 0; var11 < this.lesDocumentsEntete.size(); ++var11) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var11)).getDocNum().equals(var7.getRetourEnteteVentes().getBrtNum())) {
                        var10 = true;
                        break;
                     }
                  }
               } else {
                  var10 = false;
               }

               if (!var10) {
                  var8.setVar_lib_nat("Retour");
                  var8.setDocEtat(var7.getRetourEnteteVentes().getBrtEtat());
                  var8.setDocIdCreateur(var7.getRetourEnteteVentes().getTiers().getTieid());
                  var8.setDocDate(var7.getRetourEnteteVentes().getBrtDate());
                  var8.setDocNum(var7.getRetourEnteteVentes().getBrtNum());
                  var8.setDocNomTiers(var7.getRetourEnteteVentes().getBrtNomTiers());
                  var8.setDocObject(var7.getRetourEnteteVentes().getBrtObject());
                  var8.setDocSource(var7.getRetourEnteteVentes().getBrtSource());
                  var8.setDocNomContact(var7.getRetourEnteteVentes().getBrtNomContact());
                  var8.setDocNomCaissier(var7.getRetourEnteteVentes().getBrtNomCommercial());
                  var8.setDocNomResponsable(var7.getRetourEnteteVentes().getBrtNomResponsable());
                  var8.setDocTotHt(var7.getRetourEnteteVentes().getBrtTotHt());
                  var8.setDocTotTva(var7.getRetourEnteteVentes().getBrtTotTva());
                  var8.setDocTotTtc(var7.getRetourEnteteVentes().getBrtTotTtc());
                  var8.setDocTotReglement(0.0D);
                  var8.setDocAPayer(0.0D);
                  this.var_total += var8.getDocTotTtc();
                  this.var_reglement += var8.getDocTotReglement();
                  this.lesDocumentsEntete.add(var8);
               }

               var9.setStk_date_mvt(var7.getRetourEnteteVentes().getBrtDate());
               var9.setStk_numero(var7.getRetourEnteteVentes().getBrtNum());
               var9.setStk_code_produit(var7.getBrtligCode());
               var9.setStkLibelle(var7.getBrtligLibelle());
               var9.setStk_code_depot(var7.getBrtligDepot());
               var9.setStkPuRem(var7.getBrtligPuRem());
               var9.setStk_pump(var7.getBrtligPump());
               var9.setStk_qte_progress(var7.getBrtligQte());
               var9.setStkPt(var7.getBrtligPt());
               this.var_qte += var9.getStk_qte_progress();
               this.lesDocumentsDetail.add(var9);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void factureVentes(String var1, String var2, int var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      FactureLigneVentesDao var6 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var5 = var6.chargerLesMvtsUsers(this.usersLog, var1, var2, (Session)null);
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            new FactureLigneVentes();
            FactureLigneVentes var8 = (FactureLigneVentes)var5.get(var7);
            if (var3 == 0 || var3 == 1 && var8.getFactureEnteteVentes().getFacSolde() == 0) {
               DocumentEntete var9 = new DocumentEntete();
               Stock var10 = new Stock();
               var10.setStk_lib_type("Facture");
               var10.setStkFamille(var8.getFacligFamille());
               if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var10.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var8.getFacligCode().startsWith(this.choixProduit))) {
                  boolean var11 = false;
                  if (this.lesDocumentsEntete.size() != 0) {
                     for(int var12 = 0; var12 < this.lesDocumentsEntete.size(); ++var12) {
                        if (((DocumentEntete)this.lesDocumentsEntete.get(var12)).getDocNum().equals(var8.getFactureEnteteVentes().getFacNum())) {
                           var11 = true;
                           break;
                        }
                     }
                  } else {
                     var11 = false;
                  }

                  if (!var11) {
                     var9.setVar_lib_nat("Facture");
                     var9.setDocEtat(var8.getFactureEnteteVentes().getFacEtat());
                     var9.setDocIdCreateur(var8.getFactureEnteteVentes().getTiers().getTieid());
                     var9.setDocDate(var8.getFactureEnteteVentes().getFacDate());
                     var9.setDocNum(var8.getFactureEnteteVentes().getFacNum());
                     var9.setDocNomTiers(var8.getFactureEnteteVentes().getFacNomTiers());
                     var9.setDocObject(var8.getFactureEnteteVentes().getFacObject());
                     var9.setDocSource(var8.getFactureEnteteVentes().getFacSource());
                     var9.setDocNomContact(var8.getFactureEnteteVentes().getFacNomContact());
                     var9.setDocNomCaissier(var8.getFactureEnteteVentes().getFacNomCommercial());
                     var9.setDocNomResponsable(var8.getFactureEnteteVentes().getFacNomResponsable());
                     var9.setDocTotHt(var8.getFactureEnteteVentes().getFacTotHt());
                     var9.setDocTotTva(var8.getFactureEnteteVentes().getFacTotTva());
                     var9.setDocTotTtc(var8.getFactureEnteteVentes().getFacTotTtc());
                     var9.setDocTotReglement(var8.getFactureEnteteVentes().getFacTotReglement());
                     var9.setDocAPayer(var8.getFactureEnteteVentes().getFacTotTtc() - var8.getFactureEnteteVentes().getFacTotReglement());
                     this.var_total += var9.getDocTotTtc();
                     this.var_reglement += var9.getDocTotReglement();
                     this.lesDocumentsEntete.add(var9);
                  }

                  var10.setStk_date_mvt(var8.getFactureEnteteVentes().getFacDate());
                  var10.setStk_numero(var8.getFactureEnteteVentes().getFacNum());
                  var10.setStk_code_produit(var8.getFacligCode());
                  var10.setStkLibelle(var8.getFacligLibelle());
                  var10.setStk_code_depot(var8.getFacligDepot());
                  var10.setStkPuRem(var8.getFacligPuRem());
                  var10.setStk_pump(var8.getFacligPump());
                  var10.setStk_qte_progress(var8.getFacligQte());
                  var10.setStkPt(var8.getFacligPt());
                  this.var_qte += var10.getStk_qte_progress();
                  this.lesDocumentsDetail.add(var10);
               }
            }
         }
      }

   }

   public void noteDebitVentes(String var1, String var2, int var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      NoteDebitLigneVentesDao var6 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var5 = var6.chargerLesMvtsUsers(this.usersLog, var1, var2, (Session)null);
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            new NoteDebitLigneVentes();
            NoteDebitLigneVentes var8 = (NoteDebitLigneVentes)var5.get(var7);
            if (var3 == 0 || var3 == 1 && var8.getNoteDebitEnteteVentes().getNdbSolde() == 0) {
               DocumentEntete var9 = new DocumentEntete();
               Stock var10 = new Stock();
               var10.setStk_lib_type("NoteDebit");
               var10.setStkFamille(var8.getNdbligFamille());
               if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var10.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var8.getNdbligCode().startsWith(this.choixProduit))) {
                  boolean var11 = false;
                  if (this.lesDocumentsEntete.size() != 0) {
                     for(int var12 = 0; var12 < this.lesDocumentsEntete.size(); ++var12) {
                        if (((DocumentEntete)this.lesDocumentsEntete.get(var12)).getDocNum().equals(var8.getNoteDebitEnteteVentes().getNdbNum())) {
                           var11 = true;
                           break;
                        }
                     }
                  } else {
                     var11 = false;
                  }

                  if (!var11) {
                     var9.setVar_lib_nat("NoteDebit");
                     var9.setDocEtat(var8.getNoteDebitEnteteVentes().getNdbEtat());
                     var9.setDocIdCreateur(var8.getNoteDebitEnteteVentes().getTiers().getTieid());
                     var9.setDocDate(var8.getNoteDebitEnteteVentes().getNdbDate());
                     var9.setDocNum(var8.getNoteDebitEnteteVentes().getNdbNum());
                     var9.setDocNomTiers(var8.getNoteDebitEnteteVentes().getNdbNomTiers());
                     var9.setDocObject(var8.getNoteDebitEnteteVentes().getNdbObject());
                     var9.setDocSource(var8.getNoteDebitEnteteVentes().getNdbSource());
                     var9.setDocNomContact(var8.getNoteDebitEnteteVentes().getNdbNomContact());
                     var9.setDocNomCaissier(var8.getNoteDebitEnteteVentes().getNdbNomCommercial());
                     var9.setDocNomResponsable(var8.getNoteDebitEnteteVentes().getNdbNomResponsable());
                     var9.setDocTotHt(var8.getNoteDebitEnteteVentes().getNdbTotHt());
                     var9.setDocTotTva(var8.getNoteDebitEnteteVentes().getNdbTotTva());
                     var9.setDocTotTtc(var8.getNoteDebitEnteteVentes().getNdbTotTtc());
                     var9.setDocTotReglement(var8.getNoteDebitEnteteVentes().getNdbTotReglement());
                     var9.setDocAPayer(var8.getNoteDebitEnteteVentes().getNdbTotTtc() - var8.getNoteDebitEnteteVentes().getNdbTotReglement());
                     this.var_total += var9.getDocTotTtc();
                     this.var_reglement += var9.getDocTotReglement();
                     this.lesDocumentsEntete.add(var9);
                  }

                  var10.setStk_date_mvt(var8.getNoteDebitEnteteVentes().getNdbDate());
                  var10.setStk_numero(var8.getNoteDebitEnteteVentes().getNdbNum());
                  var10.setStk_code_produit(var8.getNdbligCode());
                  var10.setStkLibelle(var8.getNdbligLibelle());
                  var10.setStk_code_depot(var8.getNdbligDepot());
                  var10.setStkPuRem(var8.getNdbligPuRem());
                  var10.setStk_pump(var8.getNdbligPump());
                  var10.setStk_qte_progress(var8.getNdbligQte());
                  var10.setStkPt(var8.getNdbligPt());
                  this.var_qte += var10.getStk_qte_progress();
                  this.lesDocumentsDetail.add(var10);
               }
            }
         }
      }

   }

   public void avoirVentes(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      AvoirLigneVentesDao var5 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerLesMvtsUsers(this.usersLog, var1, var2, (Session)null);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new AvoirLigneVentes();
            AvoirLigneVentes var7 = (AvoirLigneVentes)var4.get(var6);
            DocumentEntete var8 = new DocumentEntete();
            Stock var9 = new Stock();
            var9.setStk_lib_type("Avoir");
            var9.setStkFamille(var7.getAvrligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var9.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var7.getAvrligCode().startsWith(this.choixProduit))) {
               boolean var10 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var11 = 0; var11 < this.lesDocumentsEntete.size(); ++var11) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var11)).getDocNum().equals(var7.getAvoirEnteteVentes().getAvrNum())) {
                        var10 = true;
                        break;
                     }
                  }
               } else {
                  var10 = false;
               }

               if (!var10) {
                  var8.setVar_lib_nat("Avoir");
                  var8.setDocEtat(var7.getAvoirEnteteVentes().getAvrEtat());
                  var8.setDocIdCreateur(var7.getAvoirEnteteVentes().getTiers().getTieid());
                  var8.setDocDate(var7.getAvoirEnteteVentes().getAvrDate());
                  var8.setDocNum(var7.getAvoirEnteteVentes().getAvrNum());
                  var8.setDocNomTiers(var7.getAvoirEnteteVentes().getAvrNomTiers());
                  var8.setDocIdCreateur(var7.getAvoirEnteteVentes().getTiers().getTieid());
                  var8.setDocObject(var7.getAvoirEnteteVentes().getAvrObject());
                  var8.setDocSource(var7.getAvoirEnteteVentes().getAvrSource());
                  var8.setDocNomContact(var7.getAvoirEnteteVentes().getAvrNomContact());
                  var8.setDocNomCaissier(var7.getAvoirEnteteVentes().getAvrNomCommercial());
                  var8.setDocNomResponsable(var7.getAvoirEnteteVentes().getAvrNomResponsable());
                  var8.setDocTotHt(var7.getAvoirEnteteVentes().getAvrTotHt() * -1.0D);
                  var8.setDocTotTva(var7.getAvoirEnteteVentes().getAvrTotTva() * -1.0D);
                  var8.setDocTotTtc(var7.getAvoirEnteteVentes().getAvrTotTtc() * -1.0D);
                  var8.setDocTotReglement(0.0D);
                  var8.setDocAPayer(0.0D);
                  this.var_total += var8.getDocTotTtc();
                  this.var_reglement += var8.getDocTotReglement();
                  this.lesDocumentsEntete.add(var8);
               }

               var9.setStk_date_mvt(var7.getAvoirEnteteVentes().getAvrDate());
               var9.setStk_numero(var7.getAvoirEnteteVentes().getAvrNum());
               var9.setStk_code_produit(var7.getAvrligCode());
               var9.setStkLibelle(var7.getAvrligLibelle());
               var9.setStk_code_depot(var7.getAvrligDepot());
               var9.setStkPuRem(var7.getAvrligPuRem() * -1.0D);
               var9.setStk_pump(var7.getAvrligPump() * -1.0D);
               var9.setStk_qte_progress(var7.getAvrligQte() * -1.0F);
               var9.setStkPt(var7.getAvrligPt() * -1.0D);
               this.var_qte += var9.getStk_qte_progress();
               this.lesDocumentsDetail.add(var9);
            }
         }
      }

   }

   public void selectionDocument() {
      if (this.dataModelDocumentsEntete.isRowAvailable()) {
         this.documentEntete = (DocumentEntete)this.dataModelDocumentsEntete.getRowData();
      }

   }

   public void calculStatistique() {
      this.caHt = 0.0D;
      this.nbDoc = 0;
      this.caMoyen = 0.0D;
      this.sansSources = 0;
      this.caTrf = 0.0D;
      this.nbTrf = 0;
      this.tauxTrf = 0.0F;
      this.nbJour = (int)this.calculNbjours();
      this.caJour = 0.0D;
      this.tauxJour = 0.0F;
      this.nbProduit = 0;
      this.prixMoyen = 0.0D;
      this.caTiers = 0.0D;
      this.nbTiers = 0;
      this.tauxTiers = 0.0F;
      if (this.choixDocument != 60) {
         ArrayList var1;
         int var2;
         boolean var3;
         int var4;
         if (this.lesDocumentsEntete.size() != 0) {
            var1 = new ArrayList();
            var2 = 0;

            while(true) {
               if (var2 >= this.lesDocumentsEntete.size()) {
                  for(var2 = 0; var2 < this.lesDocumentsEntete.size(); ++var2) {
                     this.caHt += ((DocumentEntete)this.lesDocumentsEntete.get(var2)).getDocTotHt();
                     ++this.nbDoc;
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var2)).getDocSource() == null || ((DocumentEntete)this.lesDocumentsEntete.get(var2)).getDocSource().isEmpty()) {
                        ++this.sansSources;
                     }

                     if (((DocumentEntete)this.lesDocumentsEntete.get(var2)).getDocEtat() == 4 || ((DocumentEntete)this.lesDocumentsEntete.get(var2)).getDocEtat() == 5) {
                        this.caTrf += ((DocumentEntete)this.lesDocumentsEntete.get(var2)).getDocTotHt();
                        ++this.nbTrf;
                     }
                  }

                  this.caMoyen = this.caHt / (double)this.nbDoc;
                  this.tauxTrf = (float)this.nbTrf / (float)this.nbDoc * 100.0F;
                  this.caJour = this.caHt / (double)this.nbJour;
                  this.tauxJour = (float)(this.caJour / this.caHt) * 100.0F;
                  if (var1.size() == 0) {
                     break;
                  }

                  for(var2 = 0; var2 < var1.size(); ++var2) {
                     ++this.nbTiers;
                  }

                  this.caTiers = (double)((float)(this.caHt / (double)this.nbTiers));
                  this.tauxTiers = (float)(this.caTiers / this.caHt * 100.0D);
                  break;
               }

               var3 = false;
               if (var1.size() != 0) {
                  for(var4 = 0; var4 < var1.size(); ++var4) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var2)).getDocIdCreateur() == ((DocumentEntete)var1.get(var4)).getDocIdCreateur()) {
                        var3 = true;
                        break;
                     }
                  }
               }

               if (!var3) {
                  var1.add(this.lesDocumentsEntete.get(var2));
               }

               ++var2;
            }
         }

         if (this.lesDocumentsDetail.size() != 0) {
            var1 = new ArrayList();

            for(var2 = 0; var2 < this.lesDocumentsDetail.size(); ++var2) {
               var3 = false;
               if (var1.size() != 0) {
                  for(var4 = 0; var4 < var1.size(); ++var4) {
                     if (((Stock)this.lesDocumentsDetail.get(var2)).getStk_code_produit() != null && !((Stock)this.lesDocumentsDetail.get(var2)).getStk_code_produit().isEmpty()) {
                        if (((Stock)this.lesDocumentsDetail.get(var2)).getStk_code_produit().equals(((Stock)var1.get(var4)).getStk_code_produit())) {
                           var3 = true;
                           break;
                        }
                     } else if (((Stock)this.lesDocumentsDetail.get(var2)).getStk_code_produit() == null || ((Stock)this.lesDocumentsDetail.get(var2)).getStk_code_produit().isEmpty()) {
                        var3 = true;
                        break;
                     }
                  }
               }

               if (!var3) {
                  var1.add(this.lesDocumentsDetail.get(var2));
               }
            }

            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  ++this.nbProduit;
               }

               this.prixMoyen = (double)((float)(this.caHt / (double)this.nbProduit));
            }
         }
      }

   }

   public long calculNbjours() {
      byte var1 = 1;
      byte var2 = 12;
      boolean var3 = false;
      boolean var4 = false;
      long var5 = 0L;
      long var7 = 0L;
      Calendar var9 = Calendar.getInstance();
      Calendar var10 = Calendar.getInstance();
      Calendar var11 = Calendar.getInstance();
      var9.setTime(this.dateDebut);
      var10.setTime(this.dateFin);
      int var14 = 0;

      while(true) {
         do {
            if (!var9.before(var10)) {
               int var13 = var14 / var2;
               var14 -= var13 * var2;
               var11 = Calendar.getInstance();
               var11.setTime(this.dateDebut);
               var11.add(1, var13);
               var11.add(2, var14);
               var5 = (var10.getTimeInMillis() - var11.getTimeInMillis()) / 86400000L;
               var7 = var7 + var5 + 1L;
               int var12 = (int)(var7 / 7L);
               var7 -= (long)var12;
               return var7;
            }

            var9.add(2, var1);
         } while(!var9.before(var10) && !var9.equals(var10));

         var7 += (long)var9.getActualMaximum(5);
         ++var14;
      }
   }

   public void accesPlanning() throws HibernateException, NamingException {
      this.newRdv = new Rdv();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Office");
      this.lesPlanning = new ArrayList();
      this.dataModelPlanning = new ListDataModel();
      this.mesTachesItem = new ArrayList();
      TachesDao var2 = new TachesDao(this.baseLog, this.utilInitHibernate);
      this.mesTachesItem = var2.selectTachesActifItem(var1);
      this.choixRdv = 99;
      RdvDao var3 = new RdvDao(this.baseLog, this.utilInitHibernate);
      List var4 = var3.chargerRdvUser(this.choixRdv, this.users.getUsrid(), var1);
      this.dataModelPlanning.setWrappedData(var4);
      this.var_action = 4;
      this.utilInitHibernate.closeSession();
      this.showModalPanelRdv = false;
   }

   public void retourPlanning() {
      this.var_action = 0;
   }

   public void rechercherLesRdv() throws HibernateException, NamingException {
      RdvDao var1 = new RdvDao(this.baseLog, this.utilInitHibernate);
      List var2 = var1.chargerRdvUser(this.choixRdv, this.users.getUsrid(), (Session)null);
      this.dataModelPlanning.setWrappedData(var2);
   }

   public void selectionRDV() {
      if (this.dataModelPlanning.isRowAvailable()) {
         this.newRdv = (Rdv)this.dataModelPlanning.getRowData();
         this.testRdv = true;
      }

   }

   public void ajouterRdv() {
      this.newRdv = new Rdv();
      this.choixTache = "";
      this.showModalPanelRdv = true;
   }

   public void modifierRdv() throws HibernateException, NamingException {
      if (this.newRdv.getRdvTache() != null && !this.newRdv.getRdvTache().isEmpty()) {
         TachesDao var1 = new TachesDao(this.baseLog, this.utilInitHibernate);
         new Taches();
         Taches var2 = var1.rechercheTache(this.newRdv.getRdvTache(), (Session)null);
         if (var2 != null) {
            this.choixTache = var2.getTacCode() + ":" + var2.getTacNomFr();
         }

         this.showModalPanelRdv = true;
      }

   }

   public void deleteRdv() throws HibernateException, NamingException {
      RdvDao var1 = new RdvDao(this.baseLog, this.utilInitHibernate);
      var1.delRdv(this.newRdv.getRdvId());
      this.rechercherLesRdv();
      this.testRdv = false;
   }

   public void choixTypeRdv() {
      if (this.newRdv.getRdvNature() != 0 && this.newRdv.getRdvNature() != 6) {
         if (this.newRdv.getRdvNature() == 2) {
            this.typeRdv = 2;
         } else if (this.newRdv.getRdvNature() == 9) {
            this.typeRdv = 9;
         } else {
            this.typeRdv = 0;
         }
      } else {
         this.typeRdv = 1;
      }

   }

   public void saveRdv() throws HibernateException, NamingException {
      RdvDao var1 = new RdvDao(this.baseLog, this.utilInitHibernate);
      this.newRdv.setRdvTieIdDe(0L);
      this.newRdv.setRdvNomTiers("");
      this.newRdv.setUsers(this.usersLog);
      this.newRdv.setRdvEtat(0);
      if (!this.selectedUserdest.equals("0")) {
         this.newRdv.setRdvUsrDe(Long.parseLong(this.selectedUserdest));
         this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
         this.newRdv.setRdvNomUsers(this.userDao.selectUserD(Long.parseLong(this.selectedUserdest), (Session)null).getUsrPatronyme());
      } else {
         this.newRdv.setRdvUsrDe(0L);
         this.newRdv.setRdvNomUsers("");
      }

      if (this.choixTache != null && this.choixTache.contains(":")) {
         String[] var2 = this.choixTache.split(":");
         this.newRdv.setRdvTache(var2[0]);
         TachesDao var3 = new TachesDao(this.baseLog, this.utilInitHibernate);
         new Taches();
         Taches var4 = var3.rechercheTache(var2[0], (Session)null);
         if (var4 != null) {
            this.newRdv.setRdvTache(var4.getTacCode());
            this.newRdv.setRdvTachePr(var4.getTacValPr());
            this.newRdv.setRdvTachePv(var4.getTacValPr());
         } else {
            this.newRdv.setRdvTache("");
            this.newRdv.setRdvTachePr(0.0F);
            this.newRdv.setRdvTachePv(0.0F);
         }
      } else {
         this.newRdv.setRdvTache("");
         this.newRdv.setRdvTachePr(0.0F);
         this.newRdv.setRdvTachePv(0.0F);
      }

      if (this.newRdv.getRdvId() == 0L) {
         this.newRdv.setRdvDateCreation(new Date());
         this.newRdv = var1.insert(this.newRdv);
         this.lesPlanning.add(this.newRdv);
         this.dataModelPlanning.setWrappedData(this.lesPlanning);
      } else {
         this.newRdv = var1.modif(this.newRdv);
      }

      this.testRdv = false;
      this.showModalPanelRdv = false;
   }

   public void annuleRdv() {
      this.testRdv = false;
      this.showModalPanelRdv = false;
   }

   public void accesMail() throws HibernateException, NamingException, ParseException {
      this.formMessagerie = new FormMessagerie();
      this.formMessagerie.setutilInitHibernate(this.utilInitHibernate);
      this.formMessagerie.setStructureLog(this.structureLog);
      this.formMessagerie.setBaseLog(this.baseLog);
      this.formMessagerie.setUsersLog(this.usersLog);
      this.formMessagerie.InstancesDaoUtilses();
      this.formMessagerie.setTiers((Tiers)null);
      this.formMessagerie.setPatients((Patients)null);
      this.formMessagerie.executerRequeteUsers();
      this.var_action = 5;
      this.showModalPanelMessagerie = false;
   }

   public void retourMessagerie() {
      this.var_action = 0;
   }

   public void envoiSmsZ1() {
      if (this.users.getUsrCel1() != null && !this.users.getUsrCel1().isEmpty()) {
         this.numeroMobile = this.users.getUsrCel1();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void envoiSmsZ2() {
      if (this.users.getUsrCel2() != null && !this.users.getUsrCel2().isEmpty()) {
         this.numeroMobile = this.users.getUsrCel2();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void envoiSmsZ3() {
      if (this.users.getUsrCel3() != null && !this.users.getUsrCel3().isEmpty()) {
         this.numeroMobile = this.users.getUsrCel3();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void fermerSms() {
      this.showModalPanelSms = false;
   }

   public void valideEnvoiSms() throws IOException, HibernateException, NamingException, SQLException {
      UtilSms var1 = new UtilSms(this.utilInitHibernate, this.structureLog, this.usersLog, this.baseLog);
      var1.sendSmsOne(this.messageSms, this.numeroMobile, this.users.getUsrPatronyme(), this.users.getUsrCivilite(), this.users.getUsrid(), (String)null, 0L, 1);
      this.showModalPanelSms = false;
   }

   public void listeTiers() throws HibernateException, NamingException {
      this.mesConseillersItems.clear();
      this.mesConseillersItems = this.userDao.chargerLesCommerciauxItems((Session)null);
      this.lesConseillers.clear();
      this.lesTiers.clear();
      this.lesConseillers = this.responsableDao.chargerLesResponsables(this.users.getUsrid(), (Session)null);
      if (this.lesConseillers.size() != 0) {
         new Responsable();
         new Tiers();

         for(int var3 = 0; var3 < this.lesConseillers.size(); ++var3) {
            Responsable var1 = (Responsable)this.lesConseillers.get(var3);
            Tiers var2 = var1.getTiers();
            var2.setIdConseiller(var1.getRpbid());
            this.lesTiers.add(var2);
         }
      }

      this.dataModelListeTiers.setWrappedData(this.lesTiers);
      this.showModalPanelListeTiers = true;
   }

   public void fermerTiers() {
      this.showModalPanelListeTiers = false;
   }

   public void toutSelectionner() {
      if (this.lesTiers.size() != 0) {
         for(int var1 = 0; var1 < this.lesTiers.size(); ++var1) {
            ((Tiers)this.lesTiers.get(var1)).setSelectionTiers(true);
         }

         this.dataModelListeTiers.setWrappedData(this.lesTiers);
      }

   }

   public void rienSelectionner() {
      if (this.lesTiers.size() != 0) {
         for(int var1 = 0; var1 < this.lesTiers.size(); ++var1) {
            ((Tiers)this.lesTiers.get(var1)).setSelectionTiers(false);
         }

         this.dataModelListeTiers.setWrappedData(this.lesTiers);
      }

   }

   public void duppliquerVers() throws HibernateException, NamingException {
      if (this.lesTiers.size() != 0 && this.idConseiller != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new Users();
            Users var3 = this.userDao.selectLeUserId(this.idConseiller, var1);
            if (var3 != null) {
               new Tiers();
               new Responsable();
               new Responsable();

               for(int var7 = 0; var7 < this.lesTiers.size(); ++var7) {
                  Tiers var4 = (Tiers)this.lesTiers.get(var7);
                  if (var4.isSelectionTiers() && var4.getIdConseiller() != 0L) {
                     Responsable var6 = this.responsableDao.pourParapheur(var4.getIdConseiller(), var1);
                     if (var6 != null) {
                        Responsable var5 = new Responsable();
                        var5.setRpbdatecreat(new Date());
                        var5.setRpbdatedebut(new Date());
                        var5.setTiers(var4);
                        var5.setRpbuserid(this.idConseiller);
                        var5.setRpbcivilite(var3.getUsrCivilite());
                        var5.setRpbnom(var3.getUsrNom());
                        var5.setRpbprenom(var3.getUsrPrenom());
                        var5.setRpbcategorie(var3.getUsrFonction());
                        var5.setRpbdatemodif(new Date());
                        this.responsableDao.insert(var5, var1);
                     }
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var11) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.showModalPanelListeTiers = false;
   }

   public void envoyerVers() throws HibernateException, NamingException {
      if (this.lesTiers.size() != 0 && this.idConseiller != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new Users();
            Users var3 = this.userDao.selectLeUserId(this.idConseiller, var1);
            if (var3 != null) {
               new Tiers();
               new Responsable();

               for(int var6 = 0; var6 < this.lesTiers.size(); ++var6) {
                  Tiers var4 = (Tiers)this.lesTiers.get(var6);
                  if (var4.isSelectionTiers() && var4.getIdConseiller() != 0L) {
                     Responsable var5 = this.responsableDao.pourParapheur(var4.getIdConseiller(), var1);
                     if (var5 != null) {
                        var5.setRpbuserid(this.idConseiller);
                        var5.setRpbcivilite(var3.getUsrCivilite());
                        var5.setRpbnom(var3.getUsrNom());
                        var5.setRpbprenom(var3.getUsrPrenom());
                        var5.setRpbcategorie(var3.getUsrFonction());
                        var5.setRpbdatemodif(new Date());
                        this.responsableDao.modif(var5, var1);
                     }
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var10) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.showModalPanelListeTiers = false;
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
            this.requete = " cmm_users.`usr_id`='" + this.users.getUsrid() + "'";
            this.utilPrint.setSource("");
            this.utilPrint.setRecordPath("");
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setRequete(this.requete);
            this.utilPrint.setFiltre("");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "agent" + File.separator + "document" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "agent" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Impression agent");
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
         this.utilPrint.setEntete("Impression de la liste des agents");
         this.utilPrint.setRequete("");
         this.utilPrint.setFiltre("");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "agent" + File.separator + "liste" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "agent" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(this.userList);
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
      this.users = new Users();
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

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public ObjetLigneMenu getLigneMenu() {
      return this.ligneMenu;
   }

   public void setLigneMenu(ObjetLigneMenu var1) {
      this.ligneMenu = var1;
   }

   public DataModel getDataModelUser() {
      return this.dataModelUser;
   }

   public void setDataModelUser(DataModel var1) {
      this.dataModelUser = var1;
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

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
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

   public String getFonctionRec() {
      return this.fonctionRec;
   }

   public void setFonctionRec(String var1) {
      this.fonctionRec = var1;
   }

   public String getGroupeRec() {
      return this.groupeRec;
   }

   public void setGroupeRec(String var1) {
      this.groupeRec = var1;
   }

   public String getNomRec() {
      return this.nomRec;
   }

   public void setNomRec(String var1) {
      this.nomRec = var1;
   }

   public String getServiceRec() {
      return this.serviceRec;
   }

   public void setServiceRec(String var1) {
      this.serviceRec = var1;
   }

   public List getGroupeItems() {
      return this.groupeItems;
   }

   public void setGroupeItems(List var1) {
      this.groupeItems = var1;
   }

   public List getServiceItems() {
      return this.serviceItems;
   }

   public void setServiceItems(List var1) {
      this.serviceItems = var1;
   }

   public int getChoixDocument() {
      return this.choixDocument;
   }

   public void setChoixDocument(int var1) {
      this.choixDocument = var1;
   }

   public DataModel getDataModelDocuments() {
      return this.dataModelDocuments;
   }

   public void setDataModelDocuments(DataModel var1) {
      this.dataModelDocuments = var1;
   }

   public DataModel getDataModelPlanning() {
      return this.dataModelPlanning;
   }

   public void setDataModelPlanning(DataModel var1) {
      this.dataModelPlanning = var1;
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

   public FormMessagerie getFormMessagerie() {
      return this.formMessagerie;
   }

   public void setFormMessagerie(FormMessagerie var1) {
      this.formMessagerie = var1;
   }

   public List getMesFamilles() {
      return this.mesFamilles;
   }

   public void setMesFamilles(List var1) {
      this.mesFamilles = var1;
   }

   public List getMesTachesItem() {
      return this.mesTachesItem;
   }

   public void setMesTachesItem(List var1) {
      this.mesTachesItem = var1;
   }

   public Rdv getNewRdv() {
      return this.newRdv;
   }

   public void setNewRdv(Rdv var1) {
      this.newRdv = var1;
   }

   public boolean isShowModalPanelMessagerie() {
      return this.showModalPanelMessagerie;
   }

   public void setShowModalPanelMessagerie(boolean var1) {
      this.showModalPanelMessagerie = var1;
   }

   public boolean isShowModalPanelRdv() {
      return this.showModalPanelRdv;
   }

   public void setShowModalPanelRdv(boolean var1) {
      this.showModalPanelRdv = var1;
   }

   public String getChoixFamilles() {
      return this.choixFamilles;
   }

   public void setChoixFamilles(String var1) {
      this.choixFamilles = var1;
   }

   public float getVar_qte() {
      return this.var_qte;
   }

   public void setVar_qte(float var1) {
      this.var_qte = var1;
   }

   public double getVar_total() {
      return this.var_total;
   }

   public void setVar_total(double var1) {
      this.var_total = var1;
   }

   public int getChoixRdv() {
      return this.choixRdv;
   }

   public void setChoixRdv(int var1) {
      this.choixRdv = var1;
   }

   public String getChoixTache() {
      return this.choixTache;
   }

   public void setChoixTache(String var1) {
      this.choixTache = var1;
   }

   public boolean isTestRdv() {
      return this.testRdv;
   }

   public void setTestRdv(boolean var1) {
      this.testRdv = var1;
   }

   public int getTypeRdv() {
      return this.typeRdv;
   }

   public void setTypeRdv(int var1) {
      this.typeRdv = var1;
   }

   public DataModel getDataModelDocumentsEntete() {
      return this.dataModelDocumentsEntete;
   }

   public void setDataModelDocumentsEntete(DataModel var1) {
      this.dataModelDocumentsEntete = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public String getMessageSms() {
      return this.messageSms;
   }

   public void setMessageSms(String var1) {
      this.messageSms = var1;
   }

   public String getNumeroMobile() {
      return this.numeroMobile;
   }

   public void setNumeroMobile(String var1) {
      this.numeroMobile = var1;
   }

   public boolean isShowModalPanelSms() {
      return this.showModalPanelSms;
   }

   public void setShowModalPanelSms(boolean var1) {
      this.showModalPanelSms = var1;
   }

   public String getChoixProduit() {
      return this.choixProduit;
   }

   public void setChoixProduit(String var1) {
      this.choixProduit = var1;
   }

   public double getCaHt() {
      return this.caHt;
   }

   public void setCaHt(double var1) {
      this.caHt = var1;
   }

   public double getCaJour() {
      return this.caJour;
   }

   public void setCaJour(double var1) {
      this.caJour = var1;
   }

   public double getCaMoyen() {
      return this.caMoyen;
   }

   public void setCaMoyen(double var1) {
      this.caMoyen = var1;
   }

   public double getCaTiers() {
      return this.caTiers;
   }

   public void setCaTiers(double var1) {
      this.caTiers = var1;
   }

   public double getCaTrf() {
      return this.caTrf;
   }

   public void setCaTrf(double var1) {
      this.caTrf = var1;
   }

   public int getNbDoc() {
      return this.nbDoc;
   }

   public void setNbDoc(int var1) {
      this.nbDoc = var1;
   }

   public int getNbJour() {
      return this.nbJour;
   }

   public void setNbJour(int var1) {
      this.nbJour = var1;
   }

   public int getNbProduit() {
      return this.nbProduit;
   }

   public void setNbProduit(int var1) {
      this.nbProduit = var1;
   }

   public int getNbTiers() {
      return this.nbTiers;
   }

   public void setNbTiers(int var1) {
      this.nbTiers = var1;
   }

   public int getNbTrf() {
      return this.nbTrf;
   }

   public void setNbTrf(int var1) {
      this.nbTrf = var1;
   }

   public double getPrixMoyen() {
      return this.prixMoyen;
   }

   public void setPrixMoyen(double var1) {
      this.prixMoyen = var1;
   }

   public int getSansSources() {
      return this.sansSources;
   }

   public void setSansSources(int var1) {
      this.sansSources = var1;
   }

   public float getTauxJour() {
      return this.tauxJour;
   }

   public void setTauxJour(float var1) {
      this.tauxJour = var1;
   }

   public float getTauxTiers() {
      return this.tauxTiers;
   }

   public void setTauxTiers(float var1) {
      this.tauxTiers = var1;
   }

   public float getTauxTrf() {
      return this.tauxTrf;
   }

   public void setTauxTrf(float var1) {
      this.tauxTrf = var1;
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

   public List getMesNaturesRdvItems() {
      return this.mesNaturesRdvItems;
   }

   public void setMesNaturesRdvItems(List var1) {
      this.mesNaturesRdvItems = var1;
   }

   public boolean isShowModalPanelListeTiers() {
      return this.showModalPanelListeTiers;
   }

   public void setShowModalPanelListeTiers(boolean var1) {
      this.showModalPanelListeTiers = var1;
   }

   public DataModel getDataModelListeTiers() {
      return this.dataModelListeTiers;
   }

   public void setDataModelListeTiers(DataModel var1) {
      this.dataModelListeTiers = var1;
   }

   public List getMesConseillersItems() {
      return this.mesConseillersItems;
   }

   public void setMesConseillersItems(List var1) {
      this.mesConseillersItems = var1;
   }

   public long getIdConseiller() {
      return this.idConseiller;
   }

   public void setIdConseiller(long var1) {
      this.idConseiller = var1;
   }
}
