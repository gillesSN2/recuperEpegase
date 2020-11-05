package com.epegase.forms.immobilier;

import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.ObjetDevises;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormBonEncaissementImmobilier implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action = 0;
   private String pageIndex;
   private ExercicesVentes exercicesVentes;
   private OptionVentes optionsVentes;
   private int var_nb_max = 100;
   private int nature;
   private UsersChrono usersChrono;
   private transient DataModel datamodelEncaiss = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List lesBonEncaissementVente = new ArrayList();
   private BonEncaissementVenteDao bonEncaissementVenteDao;
   private BonEncaissementVente bonEncaissementVente;
   private double montantAPayer;
   private boolean var_affiche_valide = false;
   private List listFacture = new ArrayList();
   private transient DataModel datamodelTransfert = new ListDataModel();
   private FactureEnteteVentesDao factureEnteteVentesDao;
   private boolean showModalPanelAnnuler = false;
   private int inpEtat = 0;
   private Date dateDebut;
   private Date dateFin;
   private UtilDate utilDate = new UtilDate();
   private String requete;
   private String filtre;
   private String format = "PDF";
   private int var_nb_ligne;
   private double montantRecette = 0.0D;
   private boolean visibiliteBton = false;
   private boolean afficheAPayer;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private boolean affListeDoc = false;
   private int var_choix_modele = 0;
   private String nomModeleListe;
   private String nomModeleDocument;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private UtilNombre utilNombre = new UtilNombre();
   private boolean showModalPanelPrint = false;

   public void InstancesDaoUtilses() {
      this.bonEncaissementVenteDao = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerFind() throws HibernateException, NamingException {
      this.chargerFind((Session)null);
   }

   public void chargerFind(Session var1) throws HibernateException, NamingException {
      if (this.dateDebut == null) {
         this.dateDebut = this.exercicesVentes.getExevteDateDebut();
      }

      if (this.dateFin == null) {
         this.dateFin = this.exercicesVentes.getExevteDateFin();
      }

      this.lesBonEncaissementVente.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      if (this.optionsVentes.getNbLigneMax() != null && !this.optionsVentes.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionsVentes.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.inpEtat == 0) {
         this.lesBonEncaissementVente = this.bonEncaissementVenteDao.selectNonPayer(this.nature, var1);
      } else if (this.inpEtat == 1) {
         this.lesBonEncaissementVente = this.bonEncaissementVenteDao.selectExecuter(this.dateDebut, this.dateFin, var1);
      } else if (this.inpEtat == 2) {
         this.lesBonEncaissementVente = this.bonEncaissementVenteDao.selectAnnuler(this.dateDebut, this.dateFin, var1);
      }

      this.datamodelEncaiss.setWrappedData(this.lesBonEncaissementVente);
      this.var_nb_ligne = this.lesBonEncaissementVente.size();
      this.montantRecette = 0.0D;
      if (this.lesBonEncaissementVente.size() != 0) {
         for(int var2 = 0; var2 < this.lesBonEncaissementVente.size(); ++var2) {
            this.montantRecette += ((BonEncaissementVente)this.lesBonEncaissementVente.get(var2)).getBonAPayer();
         }
      }

   }

   public void selectionLigne() {
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
            this.bonEncaissementVente = (BonEncaissementVente)var1.get(0);
            this.montantAPayer = this.bonEncaissementVente.getBonAPayer();
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.bonEncaissementVente != null) {
         if (this.bonEncaissementVente.getBonEtat() == 0) {
            this.modifierBon();
         } else {
            this.consultBonEncaissement();
         }
      }

   }

   public ObjetDevises calculerLibelleDevise(String var1) throws IOException {
      LectureDevises var2 = new LectureDevises();
      new ArrayList();
      List var3 = var2.getMesDevises();
      ObjetDevises var4 = new ObjetDevises();
      if (var3.size() != 0) {
         for(int var5 = 0; var5 < var3.size(); ++var5) {
            if (((ObjetDevises)var3.get(var5)).getCode().equalsIgnoreCase(var1)) {
               var4 = (ObjetDevises)var3.get(var5);
               break;
            }
         }
      }

      return var4;
   }

   public void modifierBon() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null) {
         this.montantAPayer = this.bonEncaissementVente.getBonAPayer();
         this.var_affiche_valide = true;
         if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty()) {
            this.listeFacture();
            this.var_action = 11;
         } else {
            this.var_action = 1;
         }
      }

   }

   public void consultBonEncaissement() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null) {
         this.var_affiche_valide = false;
         if (this.bonEncaissementVente.getBonClient() != null && !this.bonEncaissementVente.getBonClient().isEmpty()) {
            this.listeFacture();
            this.var_action = 13;
         } else {
            this.var_action = 3;
         }
      }

   }

   public void listeFacture() throws HibernateException, NamingException {
      this.listFacture.clear();
      if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty() && this.bonEncaissementVente.getBonFacture().contains(":")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEntete");
         int var2 = this.regexOccur(this.bonEncaissementVente.getBonFacture(), Pattern.quote(":"));
         if (var2 != 0) {
            String[] var3 = this.bonEncaissementVente.getBonFacture().split(":");

            for(int var4 = 0; var4 < var2; ++var4) {
               new FactureEnteteVentes();
               FactureEnteteVentes var5 = this.factureEnteteVentesDao.pourParapheur(var3[var4], var1);
               if (var5 != null && var5.getFacNum() != null && !var5.getFacNum().isEmpty()) {
                  this.listFacture.add(var5);
               }
            }

            this.datamodelTransfert.setWrappedData(this.listFacture);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public int regexOccur(String var1, String var2) {
      Matcher var3 = Pattern.compile(var2).matcher(var1);

      int var4;
      for(var4 = 0; var3.find(); ++var4) {
      }

      return var4;
   }

   public void deleteBonEncaissement() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null) {
         String var1 = this.bonEncaissementVente.getBonNum();
         String var2 = this.utilDate.dateToStringFr(this.bonEncaissementVente.getBonDate());
         this.lesBonEncaissementVente.remove(this.bonEncaissementVente);
         this.datamodelEncaiss.setWrappedData(this.lesBonEncaissementVente);
         this.bonEncaissementVenteDao.delete(this.bonEncaissementVente);
         this.var_nb_ligne = this.lesBonEncaissementVente.size();
         this.montantRecette = 0.0D;
         if (this.lesBonEncaissementVente.size() != 0) {
            for(int var3 = 0; var3 < this.lesBonEncaissementVente.size(); ++var3) {
               this.montantRecette += ((BonEncaissementVente)this.lesBonEncaissementVente.get(var3)).getBonAPayer();
            }
         }

         this.visibiliteBton = false;
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
         Espion var5 = new Espion();
         EspionDao var4 = new EspionDao(this.baseLog, this.utilInitHibernate);
         var5.setUsers(this.usersLog);
         var5.setEsptype(0);
         var5.setEspdtecreat(new Date());
         var5.setEspaction("Suppression bon encaissement N° " + var1 + " du " + var2);
         var4.mAJEspion(var5);
      }

   }

   public void annulerBonEncaissement() {
      if (this.bonEncaissementVente != null) {
         this.showModalPanelAnnuler = true;
      }

   }

   public void fermerAnnulerBon() {
      this.showModalPanelAnnuler = false;
   }

   public void validerAnnulerBon() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null) {
         String var1 = this.bonEncaissementVente.getBonNum();
         String var2 = this.utilDate.dateToStringFr(this.bonEncaissementVente.getBonDate());
         this.lesBonEncaissementVente.remove(this.bonEncaissementVente);
         this.datamodelEncaiss.setWrappedData(this.lesBonEncaissementVente);
         this.bonEncaissementVente.setBonDateAnnule(new Date());
         this.bonEncaissementVente.setBonUserAnnule(this.usersLog.getUsrid());
         this.bonEncaissementVente.setBonEtat(2);
         this.bonEncaissementVente = this.bonEncaissementVenteDao.ModifBon(this.bonEncaissementVente);
         this.var_nb_ligne = this.lesBonEncaissementVente.size();
         this.montantRecette = 0.0D;
         if (this.lesBonEncaissementVente.size() != 0) {
            for(int var3 = 0; var3 < this.lesBonEncaissementVente.size(); ++var3) {
               this.montantRecette += ((BonEncaissementVente)this.lesBonEncaissementVente.get(var3)).getBonAPayer();
            }
         }

         this.visibiliteBton = false;
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
         Espion var5 = new Espion();
         EspionDao var4 = new EspionDao(this.baseLog, this.utilInitHibernate);
         var5.setUsers(this.usersLog);
         var5.setEsptype(0);
         var5.setEspdtecreat(new Date());
         var5.setEspaction("Annulation bon encaissement N° " + var1 + " du " + var2);
         var4.mAJEspion(var5);
      }

      this.showModalPanelAnnuler = false;
   }

   public void controleMontant() {
      if (this.montantAPayer <= this.bonEncaissementVente.getBonTotTtc()) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

   }

   public void annule() {
      this.var_action = 0;
      this.visibiliteBton = false;
   }

   public void save() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null) {
         this.bonEncaissementVente.setBonAPayer(this.montantAPayer);
         this.bonEncaissementVente = this.bonEncaissementVenteDao.ModifBon(this.bonEncaissementVente);
         this.var_action = 0;
      }

   }

   public void initImpression() throws IOException {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.affMail = false;
      this.var_choix_modele = 0;
      this.ListeDocImp();
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
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

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "bon_encaissement" + File.separator;
      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      var1.add(this.bonEncaissementVente);
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
            this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            String var1 = this.calculerLibelleDevise(this.bonEncaissementVente.getBonDevise()).getLibelle();
            String var2 = this.utilNombre.begin(this.bonEncaissementVente.getBonAPayer(), this.bonEncaissementVente.getBonDevise());
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setEntete("Impression du bon d'encaissement en cours");
            this.utilPrint.setMontant_lettre(var2);
            this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setIdResponsable(0L);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des bons d'encaissement");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "bon_encaissement" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(0);
         this.utilPrint.setId_doc(0L);
         JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(this.lesBonEncaissementVente);
         this.utilPrint.setjRBeanCollectionDataSource(var3);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public BonEncaissementVente getBonEncaissementVente() {
      return this.bonEncaissementVente;
   }

   public void setBonEncaissementVente(BonEncaissementVente var1) {
      this.bonEncaissementVente = var1;
   }

   public DataModel getDatamodelEncaiss() {
      return this.datamodelEncaiss;
   }

   public void setDatamodelEncaiss(DataModel var1) {
      this.datamodelEncaiss = var1;
   }

   public boolean isAfficheAPayer() {
      return this.afficheAPayer;
   }

   public void setAfficheAPayer(boolean var1) {
      this.afficheAPayer = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public double getMontantRecette() {
      return this.montantRecette;
   }

   public void setMontantRecette(double var1) {
      this.montantRecette = var1;
   }

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVar_affiche_valide() {
      return this.var_affiche_valide;
   }

   public void setVar_affiche_valide(boolean var1) {
      this.var_affiche_valide = var1;
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

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public double getMontantAPayer() {
      return this.montantAPayer;
   }

   public void setMontantAPayer(double var1) {
      this.montantAPayer = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public OptionVentes getOptionsVentes() {
      return this.optionsVentes;
   }

   public void setOptionsVentes(OptionVentes var1) {
      this.optionsVentes = var1;
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

   public DataModel getDatamodelTransfert() {
      return this.datamodelTransfert;
   }

   public void setDatamodelTransfert(DataModel var1) {
      this.datamodelTransfert = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
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

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
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

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }
}
