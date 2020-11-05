package com.epegase.forms.comptabilite;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Brouillard;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresModeles;
import com.epegase.systeme.classe.EcrituresModelesLignes;
import com.epegase.systeme.classe.EcrituresNotes;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EcrituresModelesDao;
import com.epegase.systeme.dao.EcrituresModelesLignesDao;
import com.epegase.systeme.dao.EcrituresNotesDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilGoogleMap;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;

public class FormNotesExternes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private String pageIndex;
   private int nature;
   private EcrituresNotesDao ecrituresNotesDao;
   private int var_nb_max = 100;
   private OptionComptabilite optionComptabilite;
   private ExercicesComptable selectedExo;
   private ExercicesComptable lastExo;
   private PlanComptableDao planComptableDao;
   private EcrituresNotes ecrituresNotes = new EcrituresNotes();
   private ChronoDao chronoDao;
   private Chrono chrono;
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();
   private CalculChrono calculChrono;
   private transient DataModel dataModelLesNotes = new ListDataModel();
   private List lesNotes = new ArrayList();
   private boolean testAffModif;
   private SiteDao siteDao;
   private List lesdepartements = new ArrayList();
   private List lesServices = new ArrayList();
   private DepartementDao departementDao;
   private ServiceDao serviceDao;
   private RegionDao regionDao;
   private List lesSecteur = new ArrayList();
   private SecteurDao secteurDao;
   private List lesPointDeVente = new ArrayList();
   private PointDeVenteDao pointDeVenteDao;
   private List lesActivite;
   private PlansAnalytiquesDao analytiqueDao;
   private String activite;
   private String site;
   private String dept;
   private String service;
   private String region;
   private String secteur;
   private String pdv;
   private String dossier;
   private String mission;
   private String parc;
   private String agent;
   private String cle1;
   private String budget;
   private String inpNum;
   private int inpEtat = 0;
   private int inpType = 100;
   private int inpCategorie = 100;
   private int periode = 100;
   private boolean testactivite = false;
   private boolean testsite = false;
   private boolean testdept = false;
   private boolean testservice = false;
   private boolean testreg = false;
   private boolean testsecteur = false;
   private boolean testPVD = false;
   private int testDossier;
   private boolean testMission = false;
   private boolean testParc = false;
   private boolean testAgent = false;
   private String nomCreateur;
   private String nomModif;
   private List mesEtatsItems;
   private List mesPeriodesItems;
   private List mesModelesItems;
   private List lesModeles;
   private EcrituresModelesDao ecrituresModelesDao;
   private EcrituresModelesLignesDao ecrituresModelesLignesDao;
   private FormRecherche formRecherche;
   private Ecritures ecritures;
   private EcrituresDao ecrituresDao;
   private List lesEcritures;
   private transient DataModel dataModelLesEcritures;
   private JournauxComptables journauxComptables;
   private JournauxComptablesDao journauxComptablesDao;
   private PlanComptable planComptable;
   private List lesModelsimpression = new ArrayList();
   private boolean showModalPanelPrint = false;
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
   private List lesModelesAutorises;
   private int choixRacine;
   private String selecFiscalite;
   private URI uri;
   private String coordonnees;
   private String origine;
   private String legende;
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

   public FormNotesExternes() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.lesDecoupagesActivites = new ArrayList();
      this.dataModelDecoupageActivtes = new ListDataModel();
      this.utilDownload = new UtilDownload();
      this.mesEtatsItems = new ArrayList();
      this.mesPeriodesItems = new ArrayList();
      this.mesModelesItems = new ArrayList();
      this.lesModeles = new ArrayList();
      this.lesEcritures = new ArrayList();
      this.dataModelLesEcritures = new ListDataModel();
   }

   public void InstancesDaoUtilses() {
      this.siteDao = new SiteDao(this.baseLog, this.utilInitHibernate);
      this.departementDao = new DepartementDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.regionDao = new RegionDao(this.baseLog, this.utilInitHibernate);
      this.secteurDao = new SecteurDao(this.baseLog, this.utilInitHibernate);
      this.pointDeVenteDao = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresNotesDao = new EcrituresNotesDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresModelesDao = new EcrituresModelesDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresModelesLignesDao = new EcrituresModelesLignesDao(this.baseLog, this.utilInitHibernate);
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
   }

   public void initAnalytique() {
      if (this.optionComptabilite.getNbLigneMaxLo() != null && !this.optionComptabilite.getNbLigneMaxLo().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionComptabilite.getNbLigneMaxLo());
      } else {
         this.var_nb_max = 100;
      }

      this.testactivite = this.structureLog.isStrActivite();
      if (this.structureLog.isStrSite()) {
         this.testsite = true;
         this.testdept = true;
         this.testservice = true;
      }

      if (this.structureLog.isStrRegion()) {
         this.testreg = true;
         this.testsecteur = true;
         this.testPVD = true;
      }

      this.testDossier = this.structureLog.getStrDossier();
      this.testMission = false;
      this.testParc = this.structureLog.isStrParc();
      this.testAgent = this.structureLog.isStrAgent();
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanFacture") + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      EtatDocument var3 = new EtatDocument();
      this.mesEtatsItems = var3.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = var3.calculelistePeriodeItems();
   }

   public void chargerLesNotes(Session var1) throws HibernateException, NamingException {
      this.lesNotes = this.ecrituresNotesDao.chargerNotes(0, 9, var1);
      this.dataModelLesNotes.setWrappedData(this.lesNotes);
      this.selecFiscalite = this.structureLog.getStrzonefiscale();
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
         long var2 = (long)(this.selectedExo.getExecptDateDebut().getYear() + 1900);
         long var4 = (long)(this.selectedExo.getExecptDateFin().getYear() + 1900);
         if (this.structureLog.getStrdatefiscale2() != null && var2 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var4 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
            this.selecFiscalite = this.structureLog.getStrzonefiscale2();
         } else if (this.structureLog.getStrdatefiscale2() != null && var2 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var4 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
            this.selecFiscalite = this.structureLog.getStrzonefiscale();
         } else {
            this.selecFiscalite = null;
         }
      }

      this.mesModelesItems.clear();
      this.lesModeles = this.ecrituresModelesDao.selectModelesByNature(2, var1);
      if (this.lesModeles.size() != 0) {
         for(int var6 = 0; var6 < this.lesModeles.size(); ++var6) {
            this.mesModelesItems.add(new SelectItem(((EcrituresModeles)this.lesModeles.get(var6)).getModCode(), ((EcrituresModeles)this.lesModeles.get(var6)).getModCode() + ":" + ((EcrituresModeles)this.lesModeles.get(var6)).getModLibelle()));
         }
      }

   }

   public void recherche() throws HibernateException, NamingException, ParseException {
      this.lesNotes = this.ecrituresNotesDao.recherche((Session)null, this.inpNum, this.inpEtat, this.inpType, this.inpCategorie, "" + this.periode, (String)null, (String)null);
      this.dataModelLesNotes.setWrappedData(this.lesNotes);
   }

   public void caluleMapRdv() throws URISyntaxException {
      if (this.ecrituresNotes != null) {
         UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
         this.coordonnees = var1.calculPointMapBoxNote(this.ecrituresNotes);
         this.origine = this.ecrituresNotes.getEcrnotLongitude() + "," + this.ecrituresNotes.getEcrnotLatitude();
      }

   }

   public void affichePhotoProduit() throws IOException, SQLException {
      if (this.ecrituresNotes.getEcrnotScanFacture() != null) {
         if (!this.ecrituresNotes.getEcrnotScanFacture().endsWith(".pdf") && !this.ecrituresNotes.getEcrnotScanFacture().endsWith(".PDF")) {
            this.urlphotoProd = "structure" + this.structureLog.getStrid() + "/photos/scanFacture/" + this.ecrituresNotes.getEcrnotScanFacture();
            this.typeFichier = 0;
         } else {
            String var1 = "epegase" + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanFacture" + File.separator;
            this.fichierUrl = this.utilDownload.convertirFichierUtl(var1 + this.ecrituresNotes.getEcrnotScanFacture(), this.urlExplorateur);
            this.fichierMine = this.utilDownload.calculeTypeMine(this.ecrituresNotes.getEcrnotScanFacture());
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

   public void ajoutPhoto() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      if (this.ecrituresNotes.getEcrnotId() == 0L) {
         this.saveNotes();
         this.var_action = 2;
      }

      if (this.ecrituresNotes.getEcrnotId() != 0L) {
         FacesContext var1 = FacesContext.getCurrentInstance();

         try {
            if (this.uploadedFile != null) {
               String var2;
               if (this.ecrituresNotes.getEcrnotScanFacture() != null && !this.ecrituresNotes.getEcrnotScanFacture().isEmpty()) {
                  var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanFacture") + File.separator + this.ecrituresNotes.getEcrnotScanFacture();
                  File var3 = new File(var2);
                  if (var3.exists()) {
                     var3.delete();
                  }
               }

               var2 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
               String var6 = var2.substring(var2.indexOf(".") + 1);
               var2 = this.ecrituresNotes.getEcrnotId() + "." + var6;
               File var4 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanFacture" + File.separator), var2);
               this.utilDownload.write(var4, this.uploadedFile.getInputStream());
               this.fileName = var2;
               var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
               this.ecrituresNotes.setEcrnotScanFacture(var2);
               this.urlphotoProd = "structure" + this.structureLog.getStrid() + "/photos/scanFacture/" + this.ecrituresNotes.getEcrnotScanFacture();
            }
         } catch (IOException var5) {
            this.ecrituresNotes.setEcrnotScanFacture(this.fileName);
            this.ecrituresNotes.setEcrnotPj(true);
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var5.printStackTrace();
         }
      }

   }

   public void reInitPhoto() throws HibernateException, NamingException, IOException, SQLException {
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanFacture") + File.separator + this.ecrituresNotes.getEcrnotScanFacture();
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      this.affichePhotoProduit();
      this.ecrituresNotes.setEcrnotScanFacture((String)null);
      this.ecrituresNotes.setEcrnotPj(false);
      this.ecrituresNotes = this.ecrituresNotesDao.modif(this.ecrituresNotes);
   }

   public void afficherScan() throws HibernateException, NamingException, IOException, SQLException {
      if (this.dataModelLesNotes.isRowAvailable()) {
         this.ecrituresNotes = (EcrituresNotes)this.dataModelLesNotes.getRowData();
         this.affichePhotoProduit();
      }

      if (this.ecrituresNotes != null && this.ecrituresNotes.getEcrnotScanFacture() != null && !this.ecrituresNotes.getEcrnotScanFacture().isEmpty()) {
         this.showModalPanelScan = true;
      }

   }

   public void fermerScan() {
      this.showModalPanelScan = false;
   }

   public void calculeEcritureTheo() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      String var1 = "";
      boolean var2 = false;
      double var3 = 0.0D;
      double var5 = 0.0D;
      if (this.lesEcritures.size() != 0) {
         for(int var7 = 0; var7 < this.lesEcritures.size(); ++var7) {
            var1 = ((Ecritures)this.lesEcritures.get(var7)).getEcrPiece();
            if (((Ecritures)this.lesEcritures.get(var7)).getEcrDebitSaisie() != 0.0D) {
               var3 += ((Ecritures)this.lesEcritures.get(var7)).getEcrDebitSaisie();
            } else {
               var5 += ((Ecritures)this.lesEcritures.get(var7)).getEcrCreditSaisie();
            }
         }

         if (this.ecrituresNotes.getEcrnotMontant() != var3 || this.ecrituresNotes.getEcrnotMontant() != var5) {
            Session var27 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
            Transaction var8 = null;

            try {
               var8 = var27.beginTransaction();
               this.ecrituresDao.removeSelectedEC2(this.lesEcritures, 20, var27);
               var8.commit();
            } catch (HibernateException var23) {
               if (var8 != null) {
                  var8.rollback();
               }

               throw var23;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.lesEcritures.clear();
            this.dataModelLesEcritures.setWrappedData(this.lesEcritures);
            var2 = true;
         }
      } else {
         var2 = true;
      }

      if (this.ecrituresNotes != null && this.lesModeles.size() != 0 && var2) {
         EcrituresModeles var28 = new EcrituresModeles();

         for(int var29 = 0; var29 < this.lesModeles.size(); ++var29) {
            if (((EcrituresModeles)this.lesModeles.get(var29)).getModNature() == this.ecrituresNotes.getEcrnotCategorie()) {
               var28 = (EcrituresModeles)this.lesModeles.get(var29);
               break;
            }
         }

         Session var30 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var9 = null;

         try {
            var9 = var30.beginTransaction();
            if (this.ecrituresNotes.getEcrnotId() == 0L) {
               this.majNotes(var30);
            }

            String var10 = "";
            if (var1 != null && !var1.isEmpty()) {
               var10 = var1;
            } else {
               new Chrono();
               Chrono var11 = this.chronoDao.chronoByNatAndJournalPeriode(53, var28.getModJournal(), "" + (this.ecrituresNotes.getEcrnotDate().getYear() + 1900), var30);
               if (var11 != null) {
                  long var12 = 0L;
                  var12 = this.enregitrerNumeroPiece(var11, var30);
                  var10 = this.calculChrono.formattageChrono(var11, var12, var28.getModJournal(), "", this.ecrituresNotes.getEcrnotDate());
               } else {
                  var10 = "";
               }
            }

            new EcrituresModelesLignes();
            new ArrayList();
            List var32 = this.ecrituresModelesLignesDao.selectModelesLignes(var28, var30);
            if (var32.size() != 0) {
               for(int var13 = 0; var13 < var32.size(); ++var13) {
                  EcrituresModelesLignes var31 = (EcrituresModelesLignes)var32.get(var13);
                  var28 = var31.getEcrituresModeles();
                  this.saveLigneEcriture(var28, var31, var10, var30);
               }

               this.dataModelLesEcritures.setWrappedData(this.lesEcritures);
            }

            var9.commit();
         } catch (HibernateException var25) {
            if (var9 != null) {
               var9.rollback();
            }

            throw var25;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public long enregitrerNumeroPiece(Chrono var1, Session var2) throws HibernateException, NamingException {
      long var3 = 0L;
      if (var1.getChrMode() == 0) {
         var1.setChrNumAn(var1.getChrNumAn() + 1L);
         var3 = var1.getChrNumAn();
      } else if (var1.getChrMode() == 1) {
         String var5 = "";
         if (this.ecrituresNotes.getEcrnotDate().getMonth() + 1 <= 9) {
            var5 = "0" + (this.ecrituresNotes.getEcrnotDate().getMonth() + 1);
         } else {
            var5 = "" + (this.ecrituresNotes.getEcrnotDate().getMonth() + 1);
         }

         if (var5.equalsIgnoreCase("01")) {
            var1.setChrNum01(var1.getChrNum01() + 1L);
            var3 = var1.getChrNum01();
         } else if (var5.equalsIgnoreCase("02")) {
            var1.setChrNum02(var1.getChrNum02() + 1L);
            var3 = var1.getChrNum02();
         } else if (var5.equalsIgnoreCase("03")) {
            var1.setChrNum03(var1.getChrNum03() + 1L);
            var3 = var1.getChrNum03();
         } else if (var5.equalsIgnoreCase("04")) {
            var1.setChrNum04(var1.getChrNum04() + 1L);
            var3 = var1.getChrNum04();
         } else if (var5.equalsIgnoreCase("05")) {
            var1.setChrNum05(var1.getChrNum05() + 1L);
            var3 = var1.getChrNum05();
         } else if (var5.equalsIgnoreCase("06")) {
            var1.setChrNum06(var1.getChrNum06() + 1L);
            var3 = var1.getChrNum06();
         } else if (var5.equalsIgnoreCase("07")) {
            var1.setChrNum07(var1.getChrNum07() + 1L);
            var3 = var1.getChrNum07();
         } else if (var5.equalsIgnoreCase("08")) {
            var1.setChrNum08(var1.getChrNum08() + 1L);
            var3 = var1.getChrNum08();
         } else if (var5.equalsIgnoreCase("09")) {
            var1.setChrNum09(var1.getChrNum09() + 1L);
            var3 = var1.getChrNum09();
         } else if (var5.equalsIgnoreCase("10")) {
            var1.setChrNum10(var1.getChrNum10() + 1L);
            var3 = var1.getChrNum10();
         } else if (var5.equalsIgnoreCase("11")) {
            var1.setChrNum11(var1.getChrNum11() + 1L);
            var3 = var1.getChrNum11();
         } else if (var5.equalsIgnoreCase("12")) {
            var1.setChrNum12(var1.getChrNum12() + 1L);
            var3 = var1.getChrNum12();
         }
      } else if (var1.getChrMode() == 2) {
         var1.setChrNum(var1.getChrNum() + 1L);
         var3 = var1.getChrNum();
      }

      this.chronoDao.modifierChrono(var1, var2);
      return var3;
   }

   public void saveLigneEcriture(EcrituresModeles var1, EcrituresModelesLignes var2, String var3, Session var4) throws NamingException, JDOMException, IOException, ParseException {
      this.ecritures = new Ecritures();
      this.ecritures.setEcrCode(var1.getModJournal());
      this.journauxComptables = this.journauxComptablesDao.chercherCode(this.ecritures.getEcrCode(), 0L, var4);
      if (this.journauxComptables != null) {
         this.ecritures.setEcrNatureJrx(this.journauxComptables.getPljNature());
         this.ecritures.setEcrReserve(this.journauxComptables.getPljReserve());
         String var5 = "" + (this.ecrituresNotes.getEcrnotDate().getYear() + 1900);
         String var6 = "";
         if (this.ecrituresNotes.getEcrnotDate().getMonth() + 1 <= 9) {
            var6 = "0" + (this.ecrituresNotes.getEcrnotDate().getMonth() + 1);
         } else {
            var6 = "" + (this.ecrituresNotes.getEcrnotDate().getMonth() + 1);
         }

         String var7 = "";
         if (this.ecrituresNotes.getEcrnotDate().getDate() <= 9) {
            var7 = "0" + this.ecrituresNotes.getEcrnotDate().getDate();
         } else {
            var7 = "" + this.ecrituresNotes.getEcrnotDate().getDate();
         }

         this.ecritures.setEcrAnnee(var5);
         this.ecritures.setEcrDateSaisie(this.ecrituresNotes.getEcrnotDate());
         this.ecritures.setEcrEtat(0);
         this.ecritures.setEcrJour(this.ecrituresNotes.getEcrnotDate().getDate());
         this.ecritures.setEcrPeriode(var6 + ":" + var5);
         this.ecritures.setEcrPiece(var3);
         this.ecritures.setEcrCompte(var2.getModligCompte());
         this.ecritures.setEcrLibCompte(var2.getModligLibelle());
         this.planComptable = this.planComptableDao.chercherCompte(this.selecFiscalite, var2.getModligCompte(), this.selectedExo.getExecpt_id(), var4);
         if (this.planComptable != null) {
            this.ecritures.setEcrNature(this.planComptable.getPlcNature());
         } else {
            this.ecritures.setEcrNature(0);
         }

         this.ecritures.setEcrClasse(this.ecritures.getEcrCompte().substring(0, 1));
         this.ecritures.setEcrLibelle(this.ecrituresNotes.getEcrnotLibelle());
         this.ecritures.setEcrReference1(this.ecrituresNotes.getEcrnotPiece());
         this.ecritures.setEcrReference2("");
         this.ecritures.setEcrCle1(this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode());
         this.ecritures.setEcrCle2(this.ecritures.getEcrCode() + ":" + var5 + ":" + var6 + ":" + var7);
         this.ecritures.setEcrOrdre(0L);
         double var8 = 0.0D;
         if (var2.getModligCalcul() == 0) {
            var8 = this.ecrituresNotes.getEcrnotMontant();
         } else if (var2.getModligCalcul() == 1 && var2.getModligTaux() != 0.0F) {
            var8 = this.utilNombre.myRoundDevise(this.ecrituresNotes.getEcrnotMontant() * (double)var2.getModligTaux() / 100.0D, this.structureLog.getStrdevise());
         } else if (var2.getModligCalcul() == 2 && var2.getModligTaux() != 0.0F) {
            var8 = this.utilNombre.myRoundDevise(this.ecrituresNotes.getEcrnotMontant() - this.ecrituresNotes.getEcrnotMontant() / (double)(1.0F + (var2.getModligTaux() + var2.getModligTc()) / 100.0F), this.structureLog.getStrdevise());
         } else if (var2.getModligCalcul() == 3 && var2.getModligTaux() != 0.0F) {
            var8 = this.utilNombre.myRoundDevise(this.ecrituresNotes.getEcrnotMontant() * (double)var2.getModligTaux() / 100.0D, this.structureLog.getStrdevise());
         } else if (var2.getModligCalcul() == 4 && var2.getModligTaux() != 0.0F) {
            var8 = this.utilNombre.myRoundDevise(this.ecrituresNotes.getEcrnotMontant() - this.ecrituresNotes.getEcrnotMontant() / (double)(1.0F + (var2.getModligTaux() + var2.getModligTc()) / 100.0F), this.structureLog.getStrdevise());
         } else if (var2.getModligCalcul() == 5) {
            var8 = this.utilNombre.myRoundDevise(this.ecrituresNotes.getEcrnotMontant() * (double)var2.getModligTc() / 100.0D, this.structureLog.getStrdevise());
         } else if (var2.getModligCalcul() == 6) {
            var8 = this.utilNombre.myRoundDevise(this.ecrituresNotes.getEcrnotMontant() - this.ecrituresNotes.getEcrnotMontant() / (double)(1.0F + (var2.getModligTaux() + var2.getModligTc()) / 100.0F), this.structureLog.getStrdevise());
         } else if (var2.getModligCalcul() == 7) {
            var8 = this.utilNombre.myRoundDevise(this.ecrituresNotes.getEcrnotMontant() / (double)(1.0F + (var2.getModligTaux() + var2.getModligTc()) / 100.0F), this.structureLog.getStrdevise());
         } else if (var2.getModligCalcul() == 8) {
            double var10 = this.utilNombre.myRoundDevise(this.ecrituresNotes.getEcrnotMontant() * (double)var2.getModligTaux() / 100.0D, this.structureLog.getStrdevise());
            double var12 = this.utilNombre.myRoundDevise(this.ecrituresNotes.getEcrnotMontant() * (double)var2.getModligTc() / 100.0D, this.structureLog.getStrdevise());
            var8 = var10 + var12;
         }

         if (var2.getModligSens() == 0) {
            this.ecritures.setEcrDebitSaisie(var8);
            this.ecritures.setEcrCreditSaisie(0.0D);
         } else {
            this.ecritures.setEcrDebitSaisie(0.0D);
            this.ecritures.setEcrCreditSaisie(var8);
         }

         this.ecritures.setEcrDeviseSaisie(this.structureLog.getStrdevise());
         this.ecritures.setEcrCoefEuro(this.utilNombre.deviseTaux1(this.ecritures.getEcrDeviseSaisie(), this.ecritures.getEcrDateSaisie()));
         this.ecritures.setEcrDebitEuro(this.utilNombre.myRoundFormat(this.ecritures.getEcrDebitSaisie() * (double)this.ecritures.getEcrCoefEuro(), 1));
         this.ecritures.setEcrCreditEuro(this.utilNombre.myRoundFormat(this.ecritures.getEcrCreditSaisie() * (double)this.ecritures.getEcrCoefEuro(), 1));
         this.ecritures.setEcrDevisePays(this.structureLog.getStrdevise());
         if (this.ecritures.getEcrDevisePays().equalsIgnoreCase(this.ecritures.getEcrDeviseSaisie())) {
            this.ecritures.setEcrCoefPays(1.0F);
            this.ecritures.setEcrDebitPays(this.ecritures.getEcrDebitSaisie());
            this.ecritures.setEcrCreditPays(this.ecritures.getEcrCreditSaisie());
         } else {
            this.ecritures.setEcrCoefPays(this.utilNombre.deviseTaux2(this.ecritures.getEcrDevisePays(), this.ecritures.getEcrDateSaisie()));
            this.ecritures.setEcrDebitPays(this.utilNombre.myRoundDevise(this.ecritures.getEcrDebitSaisie() * (double)this.ecritures.getEcrCoefPays(), this.ecritures.getEcrDevisePays()));
            this.ecritures.setEcrCreditPays(this.utilNombre.myRoundDevise(this.ecritures.getEcrCreditSaisie() * (double)this.ecritures.getEcrCoefPays(), this.ecritures.getEcrDevisePays()));
         }

         this.ecritures.setEcrDeviseGrp(this.structureLog.getStrdevise());
         this.ecritures.setEcrCoefGrp(1.0F);
         this.ecritures.setEcrDebitGrp(this.ecritures.getEcrDebitSaisie());
         this.ecritures.setEcrCreditGrp(this.ecritures.getEcrCreditSaisie());
         this.ecritures.setEcrIdOrigine(this.ecrituresNotes.getEcrnotId());
         this.ecritures.setEcrTypeOrigine("57");
         if (this.ecritures.getEcr_id() == 0L) {
            this.ecritures.setEcrDateCreat(new Date());
            this.ecritures.setEcrUserCreat(this.usersLog.getUsrid());
            this.ecritures.setExercicesComptable(this.selectedExo);
            this.ecritures.setBrouillard((Brouillard)null);
            this.ecritures = this.ecrituresDao.insertNoteExterne(this.ecritures, var4);
            this.lesEcritures.add(this.ecritures);
         } else {
            this.ecritures = this.ecrituresDao.modifNoteExterne(this.ecritures, var4);
         }
      }

   }

   public void ajoutNotes() throws HibernateException, NamingException {
      this.ecrituresNotes = new EcrituresNotes();
      this.lesdepartements = new ArrayList();
      this.lesServices = new ArrayList();
      this.lesSecteur = new ArrayList();
      this.lesPointDeVente = new ArrayList();
      this.ecrituresNotes.setEcrnotDate(new Date());
      this.verifExitChrono();
      this.activite = "";
      this.site = "";
      this.dept = "";
      this.service = "";
      this.region = "";
      this.secteur = "";
      this.pdv = "";
      this.dossier = "";
      this.mission = "";
      this.parc = "";
      this.agent = "";
      this.cle1 = "";
      if (this.decoupageActivite) {
         this.lesDecoupagesActivites.clear();
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

      this.lesEcritures.clear();
      this.dataModelLesEcritures.setWrappedData(this.lesEcritures);
      this.var_action = 1;
   }

   public void selectionNotes() throws HibernateException, NamingException, IOException, SQLException {
      if (this.dataModelLesNotes.isRowAvailable()) {
         this.ecrituresNotes = (EcrituresNotes)this.dataModelLesNotes.getRowData();
         this.lesdepartements = new ArrayList();
         this.lesServices = new ArrayList();
         this.lesSecteur = new ArrayList();
         this.lesPointDeVente = new ArrayList();
         this.afficherScan();
         this.chargerEcritures();
      }

   }

   public void chargerEcritures() throws HibernateException, NamingException {
      this.lesEcritures.clear();
      this.lesEcritures = this.ecrituresDao.ChargerLesEcrituresOrigine(this.ecrituresNotes.getEcrnotId(), "57", this.selectedExo.getExecpt_id(), (Session)null);
      this.dataModelLesEcritures.setWrappedData(this.lesEcritures);
   }

   public void modifNotes() throws HibernateException, NamingException {
      if (this.ecrituresNotes != null) {
         this.var_action = 2;
      }

   }

   public void consultNotes() throws HibernateException, NamingException {
      if (this.ecrituresNotes != null) {
         this.var_action = 3;
      }

   }

   public void removeSelectedNotes() throws HibernateException, NamingException {
      if (this.ecrituresNotes != null) {
         if (this.ecrituresNotes.getEcrnotScanFacture() != null && !this.ecrituresNotes.getEcrnotScanFacture().isEmpty()) {
            String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanFacture") + File.separator + this.ecrituresNotes.getEcrnotScanFacture();
            File var2 = new File(var1);
            if (var2.exists()) {
               var2.delete();
            }
         }

         this.ecrituresNotesDao.delete(this.ecrituresNotes);
         this.lesNotes.remove(this.ecrituresNotes);
      }

   }

   public void annulerSaisie() {
      this.var_action = 0;
   }

   public void saveNotes() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      boolean var1 = true;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresNotes");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var1 = this.majNotes(var2);
         if (var1) {
            var3.commit();
         }
      } catch (HibernateException var8) {
         var1 = false;
         if (var3 != null) {
            var3.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var1) {
         this.calculeEcritureTheo();
         if (this.var_action == 1) {
            this.var_action = 2;
         } else {
            this.var_action = 0;
         }
      } else {
         this.var_action = 0;
      }

   }

   public boolean majNotes(Session var1) throws HibernateException, NamingException {
      if (this.ecrituresNotes.getEcrnotDate() == null) {
         this.ecrituresNotes.setEcrnotDate(new Date());
      }

      this.ecrituresNotes.setEcrnotAnnee("" + (this.ecrituresNotes.getEcrnotDate().getYear() + 1900));
      String var2 = "";
      if (this.ecrituresNotes.getEcrnotDate().getMonth() + 1 <= 9) {
         var2 = "0" + (this.ecrituresNotes.getEcrnotDate().getMonth() + 1);
      } else {
         var2 = "" + (this.ecrituresNotes.getEcrnotDate().getMonth() + 1);
      }

      this.ecrituresNotes.setEcrnotPeriode(var2 + ":" + this.ecrituresNotes.getEcrnotAnnee());
      String var3 = "";
      if (this.ecrituresNotes.getEcrnotNum() == null || this.ecrituresNotes.getEcrnotNum().isEmpty()) {
         var3 = this.calculChrono.numCompose(this.ecrituresNotes.getEcrnotDate(), this.nature, (String)null, var1);
         this.ecrituresNotes.setEcrnotNum(var3);
      }

      if (var3 != null && !var3.isEmpty()) {
         if (this.ecrituresNotes.getEcrnotScanFacture() != null && !this.ecrituresNotes.getEcrnotScanFacture().isEmpty()) {
            this.ecrituresNotes.setEcrnotPj(true);
         } else {
            this.ecrituresNotes.setEcrnotPj(false);
         }

         if (this.ecrituresNotes.getEcrnotId() == 0L) {
            this.ecrituresNotes.setEcrnotDateCreat(new Date());
            this.ecrituresNotes.setEcrnotUserCreat(this.usersLog.getUsrid());
            this.ecrituresNotes.setUsers(this.usersLog);
            this.ecrituresNotes = this.ecrituresNotesDao.insert(this.ecrituresNotes, var1);
            this.lesNotes.add(this.ecrituresNotes);
            this.dataModelLesNotes.setWrappedData(this.lesNotes);
         } else {
            this.ecrituresNotes.setEcrnotDateModif(new Date());
            this.ecrituresNotes.setEcrnotUserModif(this.usersLog.getUsrid());
            this.ecrituresNotes = this.ecrituresNotesDao.modif(this.ecrituresNotes, var1);
         }

         return true;
      } else {
         String var4 = "Le chrono Note Externe n`existe pas. Veuille le créer dans la gestion des chronos comptables...";
         this.formRecherche.setMessageTexte(var4);
         this.formRecherche.setShowModalPanelMessage(true);
         return false;
      }
   }

   public void caluleEtat() throws HibernateException, NamingException {
      if (this.ecrituresNotes != null) {
         this.nomCreateur = "";
         this.nomModif = "";
         UserDao var1 = new UserDao(this.baseLog, this.utilInitHibernate);
         Users var2;
         if (this.ecrituresNotes.getEcrnotUserCreat() != 0L) {
            new Users();
            var2 = var1.selectUserD(this.ecrituresNotes.getEcrnotUserCreat(), (Session)null);
            if (var2 != null) {
               this.nomCreateur = var2.getUsrPatronyme();
            } else {
               this.nomCreateur = "Inconnu";
            }
         }

         if (this.ecrituresNotes.getEcrnotUserModif() != 0L) {
            new Users();
            var2 = var1.selectUserD(this.ecrituresNotes.getEcrnotUserModif(), (Session)null);
            if (var2 != null) {
               this.nomModif = var2.getUsrPatronyme();
            } else {
               this.nomModif = "inconnu";
            }
         }
      }

   }

   public void verifExitChrono() throws HibernateException, NamingException {
      this.chrono = new Chrono();
      this.chrono = this.chronoDao.chronoByNat(this.nature, (Session)null);
   }

   public String numCompose(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.enregitrerNumero(var1);
      var2 = this.calculChrono.formattageChrono(this.chrono, "", "", this.ecrituresNotes.getEcrnotDate());
      return var2;
   }

   public void enregitrerNumero(Session var1) throws HibernateException, NamingException {
      this.chrono.setChrNum(this.chrono.getChrNum() + 1L);
      this.chronoDao.modifierChrono(this.chrono, var1);
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

   public void chargerLesModelesImpresion() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "loyer";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.lesModelsimpression = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            String var5 = var3[var4];
            if (var5.endsWith("jasper")) {
               String var6 = var3[var4];
               if (this.verificationAutorisation(var6)) {
                  int var7 = var5.indexOf(".");
                  var5 = var5.substring(0, var7);
                  this.lesModelsimpression.add(new SelectItem(var5));
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

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "loyer" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         var1.setEntete("Impression Loyer");
         var1.setNomMapping("Loyer");
         String var11 = "";
         String var12 = "";
         String var13 = "";
         var1.setVar_nom_col1(var12);
         var1.setVar_nom_col2(var13);
         var1.setRequete(var11);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setTiersSelectionne((Tiers)null);
         ArrayList var14 = new ArrayList();
         JRBeanCollectionDataSource var15 = new JRBeanCollectionDataSource(var14);
         var1.setjRBeanCollectionDataSource(var15);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public String refreshSite() {
      return null;
   }

   public ExercicesComptable getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesComptable var1) {
      this.lastExo = var1;
   }

   public ExercicesComptable getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesComptable var1) {
      this.selectedExo = var1;
   }

   public boolean isTestAffModif() {
      return this.testAffModif;
   }

   public void setTestAffModif(boolean var1) {
      this.testAffModif = var1;
   }

   public List getLesServices() {
      return this.lesServices;
   }

   public void setLesServices(List var1) {
      this.lesServices = var1;
   }

   public List getLesdepartements() {
      return this.lesdepartements;
   }

   public void setLesdepartements(List var1) {
      this.lesdepartements = var1;
   }

   public List getLesSecteur() {
      return this.lesSecteur;
   }

   public void setLesSecteur(List var1) {
      this.lesSecteur = var1;
   }

   public List getLesPointDeVente() {
      return this.lesPointDeVente;
   }

   public void setLesPointDeVente(List var1) {
      this.lesPointDeVente = var1;
   }

   public String getBudget() {
      return this.budget;
   }

   public void setBudget(String var1) {
      this.budget = var1;
   }

   public String getDept() {
      return this.dept;
   }

   public String getCle1() {
      return this.cle1;
   }

   public void setCle1(String var1) {
      this.cle1 = var1;
   }

   public String getDossier() {
      return this.dossier;
   }

   public void setDossier(String var1) {
      this.dossier = var1;
   }

   public String getMission() {
      return this.mission;
   }

   public void setMission(String var1) {
      this.mission = var1;
   }

   public String getParc() {
      return this.parc;
   }

   public void setParc(String var1) {
      this.parc = var1;
   }

   public void setDept(String var1) {
      this.dept = var1;
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

   public List getLesModelsimpression() {
      return this.lesModelsimpression;
   }

   public void setLesModelsimpression(List var1) {
      this.lesModelsimpression = var1;
   }

   public SecteurDao getSecteurDao() {
      return this.secteurDao;
   }

   public void setSecteurDao(SecteurDao var1) {
      this.secteurDao = var1;
   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public List getLesActivite() {
      return this.lesActivite;
   }

   public void setLesActivite(List var1) {
      this.lesActivite = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public Chrono getChrono() {
      return this.chrono;
   }

   public void setChrono(Chrono var1) {
      this.chrono = var1;
   }

   public CalculChrono getCalculChrono() {
      return this.calculChrono;
   }

   public void setCalculChrono(CalculChrono var1) {
      this.calculChrono = var1;
   }

   public int getTestDossier() {
      return this.testDossier;
   }

   public void setTestDossier(int var1) {
      this.testDossier = var1;
   }

   public boolean isTestMission() {
      return this.testMission;
   }

   public void setTestMission(boolean var1) {
      this.testMission = var1;
   }

   public boolean isTestPVD() {
      return this.testPVD;
   }

   public void setTestPVD(boolean var1) {
      this.testPVD = var1;
   }

   public boolean isTestParc() {
      return this.testParc;
   }

   public void setTestParc(boolean var1) {
      this.testParc = var1;
   }

   public boolean isTestdept() {
      return this.testdept;
   }

   public void setTestdept(boolean var1) {
      this.testdept = var1;
   }

   public boolean isTestreg() {
      return this.testreg;
   }

   public void setTestreg(boolean var1) {
      this.testreg = var1;
   }

   public boolean isTestsecteur() {
      return this.testsecteur;
   }

   public void setTestsecteur(boolean var1) {
      this.testsecteur = var1;
   }

   public boolean isTestservice() {
      return this.testservice;
   }

   public void setTestservice(boolean var1) {
      this.testservice = var1;
   }

   public boolean isTestsite() {
      return this.testsite;
   }

   public void setTestsite(boolean var1) {
      this.testsite = var1;
   }

   public UtilDate getUtilDate() {
      return this.utilDate;
   }

   public void setUtilDate(UtilDate var1) {
      this.utilDate = var1;
   }

   public boolean isTestAgent() {
      return this.testAgent;
   }

   public void setTestAgent(boolean var1) {
      this.testAgent = var1;
   }

   public boolean isTestactivite() {
      return this.testactivite;
   }

   public void setTestactivite(boolean var1) {
      this.testactivite = var1;
   }

   public String getActivite() {
      return this.activite;
   }

   public void setActivite(String var1) {
      this.activite = var1;
   }

   public String getAgent() {
      return this.agent;
   }

   public void setAgent(String var1) {
      this.agent = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }

   public int getChoixRacine() {
      return this.choixRacine;
   }

   public void setChoixRacine(int var1) {
      this.choixRacine = var1;
   }

   public DataModel getDataModelLesNotes() {
      return this.dataModelLesNotes;
   }

   public void setDataModelLesNotes(DataModel var1) {
      this.dataModelLesNotes = var1;
   }

   public EcrituresNotes getEcrituresNotes() {
      return this.ecrituresNotes;
   }

   public void setEcrituresNotes(EcrituresNotes var1) {
      this.ecrituresNotes = var1;
   }

   public String getSelecFiscalite() {
      return this.selecFiscalite;
   }

   public void setSelecFiscalite(String var1) {
      this.selecFiscalite = var1;
   }

   public String getCoordonnees() {
      return this.coordonnees;
   }

   public void setCoordonnees(String var1) {
      this.coordonnees = var1;
   }

   public String getLegende() {
      return this.legende;
   }

   public void setLegende(String var1) {
      this.legende = var1;
   }

   public String getOrigine() {
      return this.origine;
   }

   public void setOrigine(String var1) {
      this.origine = var1;
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

   public int getTypeFichier() {
      return this.typeFichier;
   }

   public void setTypeFichier(int var1) {
      this.typeFichier = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public URI getUri() {
      return this.uri;
   }

   public void setUri(URI var1) {
      this.uri = var1;
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

   public String getNomCreateur() {
      return this.nomCreateur;
   }

   public void setNomCreateur(String var1) {
      this.nomCreateur = var1;
   }

   public String getNomModif() {
      return this.nomModif;
   }

   public void setNomModif(String var1) {
      this.nomModif = var1;
   }

   public int getInpCategorie() {
      return this.inpCategorie;
   }

   public void setInpCategorie(int var1) {
      this.inpCategorie = var1;
   }

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
   }

   public String getInpNum() {
      return this.inpNum;
   }

   public void setInpNum(String var1) {
      this.inpNum = var1;
   }

   public int getInpType() {
      return this.inpType;
   }

   public void setInpType(int var1) {
      this.inpType = var1;
   }

   public int getPeriode() {
      return this.periode;
   }

   public void setPeriode(int var1) {
      this.periode = var1;
   }

   public List getMesEtatsItems() {
      return this.mesEtatsItems;
   }

   public void setMesEtatsItems(List var1) {
      this.mesEtatsItems = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public DataModel getDataModelLesEcritures() {
      return this.dataModelLesEcritures;
   }

   public void setDataModelLesEcritures(DataModel var1) {
      this.dataModelLesEcritures = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }
}
