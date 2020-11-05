package com.epegase.forms.achats;

import com.epegase.systeme.classe.BonDecaissementAchat;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.BonDecaissementAchatDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.ObjetDevises;
import com.epegase.systeme.xml.OptionAchats;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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

public class FormBonDecaissementAchats implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action = 0;
   private String pageIndex;
   private ExercicesAchats exercicesAchats;
   private OptionAchats optionAchats;
   private int var_nb_max = 100;
   private UsersChrono usersChrono;
   private transient DataModel datamodelEncaiss = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List lesBonDecaissementAchat = new ArrayList();
   private BonDecaissementAchatDao bonDecaissementAchatDao;
   private BonDecaissementAchat bonDecaissementAchat;
   private double montantAPayer;
   private boolean var_affiche_valide = false;
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
   private UtilNombre utilNombre = new UtilNombre();
   private boolean showModalPanelPrint = false;

   public void InstancesDaoUtilses() {
      this.bonDecaissementAchatDao = new BonDecaissementAchatDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerFind() throws HibernateException, NamingException {
      this.chargerFind((Session)null);
   }

   public void chargerFind(Session var1) throws HibernateException, NamingException {
      if (this.dateDebut == null) {
         this.dateDebut = this.exercicesAchats.getExeachDateDebut();
      }

      if (this.dateFin == null) {
         this.dateFin = this.exercicesAchats.getExeachDateFin();
      }

      this.lesBonDecaissementAchat.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      if (this.optionAchats.getNbLigneMax() != null && !this.optionAchats.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionAchats.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.inpEtat == 0) {
         this.lesBonDecaissementAchat = this.bonDecaissementAchatDao.selectNonPayer(var1);
      } else if (this.inpEtat == 1) {
         this.lesBonDecaissementAchat = this.bonDecaissementAchatDao.selectExecuter(this.dateDebut, this.dateFin, var1);
      } else if (this.inpEtat == 2) {
         this.lesBonDecaissementAchat = this.bonDecaissementAchatDao.selectAnnuler(this.dateDebut, this.dateFin, var1);
      }

      this.datamodelEncaiss.setWrappedData(this.lesBonDecaissementAchat);
      this.var_nb_ligne = this.lesBonDecaissementAchat.size();
      this.montantRecette = 0.0D;
      if (this.lesBonDecaissementAchat.size() != 0) {
         for(int var2 = 0; var2 < this.lesBonDecaissementAchat.size(); ++var2) {
            this.montantRecette += ((BonDecaissementAchat)this.lesBonDecaissementAchat.get(var2)).getBonAPayer();
         }
      }

      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
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
            this.bonDecaissementAchat = (BonDecaissementAchat)var1.get(0);
            this.montantAPayer = this.bonDecaissementAchat.getBonAPayer();
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.bonDecaissementAchat != null) {
         if (this.bonDecaissementAchat.getBonEtat() == 0) {
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

   public void modifierBon() {
      if (this.bonDecaissementAchat != null) {
         this.montantAPayer = this.bonDecaissementAchat.getBonAPayer();
         this.var_affiche_valide = true;
         this.var_action = 1;
      }

   }

   public void deleteBonEncaissement() throws HibernateException, NamingException {
      if (this.bonDecaissementAchat != null) {
         String var1 = this.bonDecaissementAchat.getBonNum();
         String var2 = this.utilDate.dateToStringFr(this.bonDecaissementAchat.getBonDate());
         this.lesBonDecaissementAchat.remove(this.bonDecaissementAchat);
         this.datamodelEncaiss.setWrappedData(this.lesBonDecaissementAchat);
         this.bonDecaissementAchatDao.delete(this.bonDecaissementAchat);
         this.var_nb_ligne = this.lesBonDecaissementAchat.size();
         this.montantRecette = 0.0D;
         if (this.lesBonDecaissementAchat.size() != 0) {
            for(int var3 = 0; var3 < this.lesBonDecaissementAchat.size(); ++var3) {
               this.montantRecette += ((BonDecaissementAchat)this.lesBonDecaissementAchat.get(var3)).getBonAPayer();
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
         var5.setEspaction("Suppression bon décaissement N° " + var1 + " du " + var2);
         var4.mAJEspion(var5);
      }

   }

   public void annulerBon() {
      if (this.bonDecaissementAchat != null) {
         this.showModalPanelAnnuler = true;
      }

   }

   public void fermerAnnulerBon() {
      this.showModalPanelAnnuler = false;
   }

   public void validerAnnulerBon() throws HibernateException, NamingException {
      if (this.bonDecaissementAchat != null) {
         String var1 = this.bonDecaissementAchat.getBonNum();
         String var2 = this.utilDate.dateToStringFr(this.bonDecaissementAchat.getBonDate());
         this.lesBonDecaissementAchat.remove(this.bonDecaissementAchat);
         this.datamodelEncaiss.setWrappedData(this.lesBonDecaissementAchat);
         this.bonDecaissementAchat.setBonDateAnnule(new Date());
         this.bonDecaissementAchat.setBonUserAnnule(this.usersLog.getUsrid());
         this.bonDecaissementAchat.setBonEtat(2);
         this.bonDecaissementAchat = this.bonDecaissementAchatDao.ModifBon(this.bonDecaissementAchat);
         this.var_nb_ligne = this.lesBonDecaissementAchat.size();
         this.montantRecette = 0.0D;
         if (this.lesBonDecaissementAchat.size() != 0) {
            for(int var3 = 0; var3 < this.lesBonDecaissementAchat.size(); ++var3) {
               this.montantRecette += ((BonDecaissementAchat)this.lesBonDecaissementAchat.get(var3)).getBonAPayer();
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
         var5.setEspaction("Annulation bon décaissement N° " + var1 + " du " + var2);
         var4.mAJEspion(var5);
      }

      this.showModalPanelAnnuler = false;
   }

   public void consultBonEncaissement() {
      if (this.bonDecaissementAchat != null) {
         this.var_affiche_valide = false;
         this.var_action = 3;
      }

   }

   public void controleMontant() {
      if (this.montantAPayer <= this.bonDecaissementAchat.getBonTotTtc()) {
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
      if (this.bonDecaissementAchat != null) {
         this.bonDecaissementAchat.setBonAPayer(this.montantAPayer);
         this.bonDecaissementAchat = this.bonDecaissementAchatDao.ModifBon(this.bonDecaissementAchat);
         this.var_action = 0;
      }

   }

   public void initImpression() throws IOException {
      this.showModalPanelPrint = true;
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
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && this.impDestinataire != null && !this.impDestinataire.isEmpty()) {
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
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "bon_decaissement" + File.separator;
      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      var1.add(this.bonDecaissementAchat);
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      return var2;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      return var2;
   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (!this.format.equals("MAIL")) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            String var1 = this.utilNombre.begin(this.bonDecaissementAchat.getBonAPayer(), this.bonDecaissementAchat.getBonDevise());
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setEntete("Impression du bon de décaissement en cours");
            this.utilPrint.setMontant_lettre(var1);
            this.utilPrint.setCheminRapport(this.calculeCheminRapport(this.baseLog));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport(this.baseLog));
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des bons de décaissement");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "bon_decaissement" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(0);
         this.utilPrint.setId_doc(0L);
         JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(this.lesBonDecaissementAchat);
         this.utilPrint.setjRBeanCollectionDataSource(var2);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public BonDecaissementAchat getBonDecaissementAchat() {
      return this.bonDecaissementAchat;
   }

   public void setBonDecaissementAchat(BonDecaissementAchat var1) {
      this.bonDecaissementAchat = var1;
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

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
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

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
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
