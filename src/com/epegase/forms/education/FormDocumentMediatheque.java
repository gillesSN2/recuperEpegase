package com.epegase.forms.education;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.DocumentMediatheque;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.ClassementMediathequeDao;
import com.epegase.systeme.dao.DocumentMediathequeDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionVentes;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
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
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormDocumentMediatheque implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
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
   private int var_nb_ligne;
   private String adresseYoutube;
   private transient DataModel datamodelDocument = new ListDataModel();
   private List listDocument = new ArrayList();
   private DocumentMediatheque documentMediatheque = new DocumentMediatheque();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private DocumentMediathequeDao documentMediathequeDao;
   private boolean visibiliteBton = false;
   private boolean showModalPanelDocument = false;
   private List mesClasseItems;
   private List mesDivisionItems;
   private List mesTypeItems;
   private List mesSupportItems;
   private List mesContenantItems;
   private ClassementMediathequeDao classementMediathequeDao;
   private boolean var_more_search = false;
   private String inpClasse;
   private String inpDivision;
   private String inpType;
   private String inpSupport;
   private String inpContenant;
   private List inpMesClasseItems;
   private List inpMesDivisionItems;
   private List inpMesTypeItems = new ArrayList();
   private List inpMesSupportItems = new ArrayList();
   private List inpMesContenantItems = new ArrayList();
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
   private boolean showModalPanelPrint = false;
   private UtilDownload utilDownload;
   private String urlphotoProd;
   private String fileName;
   private UploadedFile uploadedFile;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private boolean showModalPanelScan = false;
   private int typeFichier;
   private String fichierMine;
   private URL fichierUrl;
   private String urlExplorateur;

   public FormDocumentMediatheque() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.mesClasseItems = new ArrayList();
      this.mesDivisionItems = new ArrayList();
      this.mesTypeItems = new ArrayList();
      this.mesSupportItems = new ArrayList();
      this.mesContenantItems = new ArrayList();
      this.inpMesClasseItems = new ArrayList();
      this.inpMesDivisionItems = new ArrayList();
      this.utilDownload = new UtilDownload();
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.documentMediathequeDao = new DocumentMediathequeDao(this.baseLog, this.utilInitHibernate);
      this.classementMediathequeDao = new ClassementMediathequeDao(this.baseLog, this.utilInitHibernate);
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

      this.inpMesClasseItems = this.documentMediathequeDao.chargerLesClasses(var1);
      this.inpMesDivisionItems = this.documentMediathequeDao.chargerLesDivisions(var1);
      this.inpMesTypeItems = this.documentMediathequeDao.chargerLesTypes(var1);
      this.inpMesSupportItems = this.documentMediathequeDao.chargerLesSupports(var1);
      this.inpMesContenantItems = this.documentMediathequeDao.chargerLesContenants(var1);
      this.mesClasseItems = this.classementMediathequeDao.chargerLesClasses(0, var1);
      this.mesDivisionItems.clear();
      this.mesTypeItems = this.classementMediathequeDao.chargerLesClasses(1, var1);
      this.mesSupportItems = this.classementMediathequeDao.chargerLesClasses(2, var1);
      this.mesContenantItems.clear();
      this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
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

   public void chargeDivision() throws HibernateException, NamingException {
      this.chargeDivision((Session)null);
   }

   public void chargeDivision(Session var1) throws HibernateException, NamingException {
      this.documentMediatheque.setDocmedCode("");
      this.mesDivisionItems.clear();
      if (this.documentMediatheque.getDocmedClasse() != null && !this.documentMediatheque.getDocmedClasse().isEmpty()) {
         this.mesDivisionItems = this.classementMediathequeDao.chargerLesDivisions(this.documentMediatheque.getDocmedClasse(), var1);
      }

   }

   public void calculeClassement() {
      if (this.documentMediatheque.getDocmedDivision() != null && !this.documentMediatheque.getDocmedDivision().isEmpty()) {
         String[] var1 = this.documentMediatheque.getDocmedDivision().split(":");
         this.documentMediatheque.setDocmedCode(var1[0]);
      }

   }

   public void chargeContenant() throws HibernateException, NamingException {
      this.adresseYoutube = null;
      this.documentMediatheque.setDocmedadresseYoutube((String)null);
      this.documentMediatheque.setDocmedadresseInternet((String)null);
      this.documentMediatheque.setDocmedScan((String)null);
      this.chargeContenant((Session)null);
   }

   public void chargeContenant(Session var1) throws HibernateException, NamingException {
      this.mesContenantItems.clear();
      if (this.documentMediatheque.getDocmedSupport() != null && !this.documentMediatheque.getDocmedSupport().isEmpty()) {
         this.mesContenantItems = this.classementMediathequeDao.chargerLesContenants(this.documentMediatheque.getDocmedSupport(), var1);
      }

   }

   public void calculeContenant() {
      if (this.documentMediatheque.getDocmedContenant() == null && !this.documentMediatheque.getDocmedContenant().isEmpty()) {
         if (this.documentMediatheque.getDocmedContenant().startsWith("FIC")) {
            if (!this.documentMediatheque.getDocmedContenant().endsWith("pdf") && !this.documentMediatheque.getDocmedContenant().endsWith("PDF")) {
               this.typeFichier = 0;
            } else {
               this.typeFichier = 1;
            }
         } else if (this.documentMediatheque.getDocmedContenant().startsWith("MP3")) {
            this.typeFichier = 3;
         } else if (this.documentMediatheque.getDocmedContenant().startsWith("MP4")) {
            this.typeFichier = 4;
         } else {
            this.typeFichier = 99;
         }
      }

   }

   public void calculeYoutube() {
      this.adresseYoutube = null;
      if (this.documentMediatheque.getDocmedadresseYoutube() != null && !this.documentMediatheque.getDocmedadresseYoutube().isEmpty()) {
         String[] var1 = this.documentMediatheque.getDocmedadresseYoutube().split("=");
         this.adresseYoutube = var1[1];
      }

   }

   public void moreSearch() throws ParseException {
      if (!this.var_more_search) {
         this.var_more_search = true;
      } else {
         this.var_more_search = false;
      }

   }

   public void executerRequete() throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.executerRequete((Session)null);
   }

   public void executerRequete(Session var1) throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.listDocument.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.var_nb_ligne = 0;
      this.listDocument = this.documentMediathequeDao.recherche(var1, this.inpClasse, this.inpDivision, this.inpSupport, this.inpContenant, this.inpType);
      if (this.listDocument.size() > 0) {
         this.var_nb_ligne = this.listDocument.size();
      } else {
         this.var_nb_ligne = 0;
      }

      this.datamodelDocument.setWrappedData(this.listDocument);
      this.visibiliteBton = false;
   }

   public void selectionLigne() throws HibernateException, NamingException, IOException, SQLException {
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
            this.documentMediatheque = (DocumentMediatheque)var1.get(0);
            this.calculeYoutube();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "ClassementMediatheque");
            this.chargeDivision(var4);
            this.chargeContenant(var4);
            this.affichePhotoProduit();
            this.utilInitHibernate.closeSession();
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.documentMediatheque != null) {
         this.consultDocument();
      }

   }

   public void ajouterDocument() {
      this.documentMediatheque = new DocumentMediatheque();
      this.var_action = 1;
      this.var_memo_action = this.var_action;
   }

   public void modifierDocument() {
      if (this.documentMediatheque != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
      }

   }

   public void consultDocument() {
      if (this.documentMediatheque != null) {
         this.var_action = 3;
         this.var_memo_action = this.var_action;
      }

   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.documentMediatheque != null) {
         this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
      }

   }

   public void annuleDocument() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void saveDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ClassementMediatheque");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.documentMediatheque.getDocmedId() == 0L) {
            this.documentMediatheque.setDocmedUserCreat(this.usersLog.getUsrid());
            this.documentMediatheque.setDocmedDateCreat(new Date());
            this.documentMediatheque.setDocmedNum(this.calculChrono.numCompose(new Date(), this.nature, "", var1));
            this.documentMediatheque = this.documentMediathequeDao.insert(this.documentMediatheque, var1);
            this.listDocument.add(this.documentMediatheque);
            this.datamodelDocument.setWrappedData(this.listDocument);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.documentMediatheque.setDocmedUserModif(this.usersLog.getUsrid());
            this.documentMediatheque.setDocmedDateModif(new Date());
            this.documentMediatheque = this.documentMediathequeDao.modif(this.documentMediatheque, var1);
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

      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void valideDocument() throws HibernateException, NamingException, ParseException {
      if (this.documentMediatheque != null) {
      }

   }

   public void deValideDocument() throws HibernateException, NamingException, ParseException {
      if (this.documentMediatheque != null) {
      }

   }

   public void affichePhotoProduit() throws IOException, SQLException {
      if (this.documentMediatheque.getDocmedScan() != null) {
         if (!this.documentMediatheque.getDocmedScan().endsWith(".pdf") && !this.documentMediatheque.getDocmedScan().endsWith(".PDF")) {
            this.urlphotoProd = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "mediatheque" + File.separator + this.documentMediatheque.getDocmedScan();
            this.typeFichier = 0;
         } else {
            String var1 = "epegase" + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "mediatheque" + File.separator;
            this.fichierUrl = this.utilDownload.convertirFichierUtl(var1 + this.documentMediatheque.getDocmedScan(), this.urlExplorateur);
            this.fichierMine = this.utilDownload.calculeTypeMine(this.documentMediatheque.getDocmedScan());
            this.typeFichier = 1;
         }
      } else {
         this.urlphotoProd = null;
      }

   }

   private static void close(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            var2.printStackTrace();
         }
      }

   }

   public void ajoutPhoto() throws IOException, JDOMException, HibernateException, NamingException, SQLException {
      if (this.documentMediatheque.getDocmedId() == 0L || this.documentMediatheque.getDocmedNum() == null || this.documentMediatheque.getDocmedNum().isEmpty()) {
         this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
         String var1 = this.calculChrono.numCompose(new Date(), 101, (String)null, (Session)null);
         this.documentMediatheque.setDocmedNum(var1);
         this.documentMediatheque.setDocmedDateCreat(new Date());
         this.documentMediatheque.setDocmedUserCreat(this.usersLog.getUsrid());
         this.documentMediatheque = this.documentMediathequeDao.insert(this.documentMediatheque);
         this.listDocument.add(this.documentMediatheque);
         this.datamodelDocument.setWrappedData(this.listDocument);
      }

      if (this.documentMediatheque.getDocmedNum() != null && !this.documentMediatheque.getDocmedNum().isEmpty()) {
         FacesContext var7 = FacesContext.getCurrentInstance();

         try {
            if (this.uploadedFile != null) {
               String var2;
               if (this.documentMediatheque.getDocmedScan() != null && !this.documentMediatheque.getDocmedScan().isEmpty()) {
                  var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "mediatheque" + File.separator + this.documentMediatheque.getDocmedScan();
                  File var3 = new File(var2);
                  if (var3.exists()) {
                     var3.delete();
                  }
               }

               var2 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
               String var8 = var2.substring(var2.indexOf(".") + 1);
               String var4 = "";
               if (this.documentMediatheque.getDocmedNum().contains("/")) {
                  String[] var5 = this.documentMediatheque.getDocmedNum().split("/");
                  var4 = var5[0];
               } else {
                  var4 = this.documentMediatheque.getDocmedNum();
               }

               var2 = var4 + "." + var8;
               File var9 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "mediatheque" + File.separator), var2);
               this.utilDownload.write(var9, this.uploadedFile.getInputStream());
               this.fileName = var2;
               var7.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
               this.documentMediatheque.setDocmedScan(var2);
               this.affichePhotoProduit();
            }
         } catch (IOException var6) {
            this.documentMediatheque.setDocmedScan(this.fileName);
            var7.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var6.printStackTrace();
         }
      }

   }

   public void reInitPhoto() throws HibernateException, NamingException, IOException, SQLException {
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "mediatheque") + File.separator + this.documentMediatheque.getDocmedScan();
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      this.affichePhotoProduit();
      this.documentMediatheque.setDocmedScan((String)null);
      this.documentMediathequeDao.modif(this.documentMediatheque);
   }

   public void afficherScan() throws HibernateException, NamingException, IOException, SQLException {
      if (this.datamodelDocument.isRowAvailable()) {
         this.documentMediatheque = (DocumentMediatheque)this.datamodelDocument.getRowData();
         this.affichePhotoProduit();
      }

      if (this.documentMediatheque != null && this.documentMediatheque.getDocmedScan() != null && !this.documentMediatheque.getDocmedScan().isEmpty()) {
         this.showModalPanelScan = true;
      }

   }

   public void fermerScan() {
      this.showModalPanelScan = false;
   }

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator + "mediatheque" + File.separator;
      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      File var3 = new File(this.calculeCheminSousRapport(var1) + "formatDocumentMediatheque.jpg");
      if (var3.exists()) {
         var2 = "formatDocumentMediatheque.jpg";
      }

      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      if (this.documentMediatheque != null) {
         var1.add(this.documentMediatheque);
      }

      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      return var2;
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
            var1.setEntete("Impression document médiatheque");
            var1.setMontant_lettre("");
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
            var1.setDuplicata("" + var11);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(0L);
            var1.setIdCommercial(0L);
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.documentMediatheque.getDocmedId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des documents");
         var1.setTotauxTtc("");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste" + File.separator + "mediatheque" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.getNature());
         var1.setId_doc(0L);
         JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(this.listDocument);
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

   public DataModel getDatamodelDocument() {
      return this.datamodelDocument;
   }

   public void setDatamodelDocument(DataModel var1) {
      this.datamodelDocument = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public DocumentMediatheque getDocumentMediatheque() {
      return this.documentMediatheque;
   }

   public void setDocumentMediatheque(DocumentMediatheque var1) {
      this.documentMediatheque = var1;
   }

   public boolean isShowModalPanelDocument() {
      return this.showModalPanelDocument;
   }

   public void setShowModalPanelDocument(boolean var1) {
      this.showModalPanelDocument = var1;
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

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public String getInpContenant() {
      return this.inpContenant;
   }

   public void setInpContenant(String var1) {
      this.inpContenant = var1;
   }

   public String getInpClasse() {
      return this.inpClasse;
   }

   public void setInpClasse(String var1) {
      this.inpClasse = var1;
   }

   public String getInpDivision() {
      return this.inpDivision;
   }

   public void setInpDivision(String var1) {
      this.inpDivision = var1;
   }

   public String getInpSupport() {
      return this.inpSupport;
   }

   public void setInpSupport(String var1) {
      this.inpSupport = var1;
   }

   public String getInpType() {
      return this.inpType;
   }

   public void setInpType(String var1) {
      this.inpType = var1;
   }

   public List getMesContenantItems() {
      return this.mesContenantItems;
   }

   public void setMesContenantItems(List var1) {
      this.mesContenantItems = var1;
   }

   public List getMesSupportItems() {
      return this.mesSupportItems;
   }

   public void setMesSupportItems(List var1) {
      this.mesSupportItems = var1;
   }

   public List getMesTypeItems() {
      return this.mesTypeItems;
   }

   public void setMesTypeItems(List var1) {
      this.mesTypeItems = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }

   public List getInpMesContenantItems() {
      return this.inpMesContenantItems;
   }

   public void setInpMesContenantItems(List var1) {
      this.inpMesContenantItems = var1;
   }

   public List getInpMesSupportItems() {
      return this.inpMesSupportItems;
   }

   public void setInpMesSupportItems(List var1) {
      this.inpMesSupportItems = var1;
   }

   public List getInpMesTypeItems() {
      return this.inpMesTypeItems;
   }

   public void setInpMesTypeItems(List var1) {
      this.inpMesTypeItems = var1;
   }

   public List getInpMesClasseItems() {
      return this.inpMesClasseItems;
   }

   public void setInpMesClasseItems(List var1) {
      this.inpMesClasseItems = var1;
   }

   public List getInpMesDivisionItems() {
      return this.inpMesDivisionItems;
   }

   public void setInpMesDivisionItems(List var1) {
      this.inpMesDivisionItems = var1;
   }

   public List getMesClasseItems() {
      return this.mesClasseItems;
   }

   public void setMesClasseItems(List var1) {
      this.mesClasseItems = var1;
   }

   public List getMesDivisionItems() {
      return this.mesDivisionItems;
   }

   public void setMesDivisionItems(List var1) {
      this.mesDivisionItems = var1;
   }

   public String getAdresseYoutube() {
      return this.adresseYoutube;
   }

   public void setAdresseYoutube(String var1) {
      this.adresseYoutube = var1;
   }

   public String getFichierMine() {
      return this.fichierMine;
   }

   public void setFichierMine(String var1) {
      this.fichierMine = var1;
   }

   public URL getFichierUrl() {
      return this.fichierUrl;
   }

   public void setFichierUrl(URL var1) {
      this.fichierUrl = var1;
   }

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public boolean isShowModalPanelScan() {
      return this.showModalPanelScan;
   }

   public void setShowModalPanelScan(boolean var1) {
      this.showModalPanelScan = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public int getTypeFichier() {
      return this.typeFichier;
   }

   public void setTypeFichier(int var1) {
      this.typeFichier = var1;
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
}
