package com.epegase.forms.office;

import com.epegase.forms.tiers.FormTiers;
import com.epegase.systeme.classe.Bal;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.Groupe;
import com.epegase.systeme.classe.Mails;
import com.epegase.systeme.classe.MailsLu;
import com.epegase.systeme.classe.MailsPj;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.ObjetMail;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.BalDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.dao.GroupeDao;
import com.epegase.systeme.dao.MailsDao;
import com.epegase.systeme.dao.MailsLusDao;
import com.epegase.systeme.dao.MailsPJDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.PatientsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.fileUtil.FileUploadBean;
import com.epegase.systeme.fileUtil.OwnerFile;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilMail;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.LectureNatureCourrier;
import com.epegase.systeme.xml.ObjetNatureCourrier;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormMessagerie implements Serializable {
   private int typeVente;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private String pageIndex;
   private int var_nb_max = 100;
   private CalculChrono calculChrono;
   private String typeDocument;
   private UtilTdt utilTdt = new UtilTdt();
   private int typeTiers;
   private UtilDate utilDate = new UtilDate();
   private transient DataModel dataModelUsers = new ListDataModel();
   private List lesUsers = new ArrayList();
   private boolean showModalPanelTiers = false;
   private transient DataModel datamodelTiers = new ListDataModel();
   private List lesTiers = new ArrayList();
   private Tiers tiers;
   private TiersDao tiersDao;
   private FormTiers formTiers;
   private List lesContacts = new ArrayList();
   private List lesContactsMemo = new ArrayList();
   private ContactDao contactDao;
   private transient DataModel dataModelContacts = new ListDataModel();
   private List lesDestinatairesItems = new ArrayList();
   private boolean tiersDivers = false;
   private boolean gestionPatient;
   private boolean showModalPanelPatients = false;
   private transient DataModel datamodelPatients = new ListDataModel();
   private List lesPatients = new ArrayList();
   private Patients patients;
   private PatientsDao patientsDao;
   private boolean gestionAgent;
   private boolean showModalPanelAgents = false;
   private transient DataModel datamodelAgents = new ListDataModel();
   private List lesAgents = new ArrayList();
   private Salaries salaries;
   private SalariesDao salariesDao;
   private Mails mails = new Mails();
   private MailsDao mailsDao;
   private List lesMails = new ArrayList();
   private transient DataModel dataModelLesMails = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean disableBouton = true;
   private boolean disableBoutonEnregistrer = true;
   private boolean autreMail = true;
   private UtilDownload utilDownload = new UtilDownload();
   private String pj;
   private MailsPj mailsPj = new MailsPj();
   private MailsPJDao mailsPJDao;
   private List lesmailsPJ = new ArrayList();
   private transient DataModel dataModelLesPJ = new ListDataModel();
   private String fichierMine;
   private URL fichierUrl;
   private String urlExplorateur;
   private boolean showModalPanelPj = false;
   private boolean showModalPanelAjoutFile = false;
   private UploadedFile uploadedFile;
   private String nomFichier;
   private boolean viewerPdf = false;
   private boolean fichier = false;
   private MailsLu mailsLu = new MailsLu();
   private MailsLusDao mailsLusDao;
   private List lesmailsLU = new ArrayList();
   private transient DataModel dataModelLesmailsLus = new ListDataModel();
   private long var_users;
   private String var_emetteur;
   private String var_nature;
   private String var_activite_rec;
   private String var_service_rec;
   private int priorite = 99;
   private int periode = 99;
   private int lecture = 0;
   private int sens = 99;
   private String filtre1 = "";
   private String filtre2 = "";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private List mesActivitesRecItem = new ArrayList();
   private List mesServicesRecItems = new ArrayList();
   private List mesActivitesItem = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private List mesModelesItem = new ArrayList();
   private List mesNaturesItem = new ArrayList();
   private ServiceDao serviceDao;
   private ActivitesDao activitesDao;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private String requete;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private boolean visibleOptionMail = false;
   private int var_choix_modele;
   private String nomModeleDocument;
   private String nomModeleListe;
   private boolean affListeDoc = false;
   private boolean showModalPanelPrint = false;
   private List documentImpressionItems = new ArrayList();
   private List mailImpressionItems = new ArrayList();
   private List listeImpressionItems = new ArrayList();
   private boolean var_showBarProg = false;
   private int var_currentValue;
   private String var_infos;
   private UtilMail utilMail;
   private List lesMailsRejettes = new ArrayList();
   private transient DataModel dataModelMailRejets = new ListDataModel();
   private boolean mailsRejets = false;
   private boolean showModalPanelRejets = false;
   private ObjetMail objetMail = new ObjetMail();
   private boolean var_affFicPdf;
   private String urlphotoProd;
   private boolean existPdfFile;
   private String fileName;
   private String pdfFileName;
   private UploadedFile uploadedPDFFile;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private int typeFichier;
   private String ongletVisu;
   private boolean modeGroupe;
   private List lesStructures = new ArrayList();
   private List mesStructuresItems = new ArrayList();
   private long var_structure;
   private UserDao userDao;

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.mailsDao = new MailsDao(this.baseLog, this.utilInitHibernate);
      this.mailsPJDao = new MailsPJDao(this.baseLog, this.utilInitHibernate);
      this.mailsLusDao = new MailsLusDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.patientsDao = new PatientsDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
   }

   public void initMsg(Session var1) throws HibernateException, NamingException, JDOMException, IOException {
      if (this.typeVente == 815) {
         this.gestionPatient = true;
      } else {
         this.gestionPatient = false;
      }

      this.mesNaturesItem.clear();
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCourriers" + File.separator;
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      String var4 = "from Users where usrMail<>'' and usrMail is not null and usrEtat=1";
      this.lesUsers = this.userDao.chargerByRequete(var4, var1);
      this.dataModelUsers.setWrappedData(this.lesUsers);
      if (this.structureLog.getStrmaitrecabinet() == 2) {
         this.modeGroupe = true;
      } else {
         this.modeGroupe = false;
      }

   }

   public void menuGroupeListesociete() throws HibernateException, NamingException {
      this.lesStructures.clear();
      this.mesStructuresItems.clear();
      this.var_structure = 0L;
      if (this.modeGroupe) {
         new ArrayList();
         if (this.structureLog.getStrmaitrecabinet() != 0) {
            Session var2 = this.utilInitHibernate.getLoginEpegase();
            Query var3 = var2.createQuery("from StructurePeg where strId=:idStr").setLong("idStr", this.structureLog.getStrid());
            List var1 = var3.list();
            if (var1.size() != 0) {
               long var4 = ((StructurePeg)var1.get(0)).getCabinetPeg().getCabId();
               if (var4 != 0L) {
                  var3 = var2.createQuery("from StructurePeg where cabinetPeg.cabId=:idCab and strmaitrecabinet=0)").setLong("idCab", var4);
                  this.lesStructures = var3.list();

                  for(int var6 = 0; var6 < this.lesStructures.size(); ++var6) {
                     this.mesStructuresItems.add(new SelectItem(((StructurePeg)this.lesStructures.get(var6)).getStrId(), ((StructurePeg)this.lesStructures.get(var6)).getStrraisonsociale()));
                  }
               }
            }

            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void calculeActivitesServicesUsed() throws HibernateException, NamingException {
      this.calculeActivitesServicesUsed((Session)null);
   }

   public void calculeActivitesServicesUsed(Session var1) throws HibernateException, NamingException {
      this.mesActivitesRecItem.clear();
      this.mesActivitesRecItem = this.mailsDao.MailsExtractionActivites(var1);
      this.mesServicesRecItems.clear();
      this.mesServicesRecItems = this.mailsDao.MailsExtractionServices(var1);
   }

   public boolean rechercheModule(int var1) {
      boolean var2 = false;
      ArrayList var3 = new ArrayList();
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
         var3.add(this.structureLog.getStrmod1());
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
         var3.add(this.structureLog.getStrmod2());
      }

      if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
         var3.add(this.structureLog.getStrmod3());
      }

      if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
         var3.add(this.structureLog.getStrmod4());
      }

      if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
         var3.add(this.structureLog.getStrmod5());
      }

      if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
         var3.add(this.structureLog.getStrmod6());
      }

      if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
         var3.add(this.structureLog.getStrmod7());
      }

      if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod8());
      }

      if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod9());
      }

      if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
         var3.add(this.structureLog.getStrmod10());
      }

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         String var5 = "" + var1;
         if (var5.contentEquals((CharSequence)var3.get(var4))) {
            var2 = true;
         }
      }

      return var2;
   }

   public void moreSearch() throws ParseException {
      if (!this.var_more_search) {
         this.var_more_search = true;
         this.periode = 99;
         String var1 = (new Date()).getYear() + 1900 + "-01-01";
         this.inpDu = this.utilDate.stringToDateSQLLight(var1);
         String var2 = (new Date()).getYear() + 1900 + "-12-31";
         this.inpAu = this.utilDate.stringToDateSQLLight(var2);
      } else {
         this.var_more_search = false;
         this.periode = 99;
         this.inpDu = null;
         this.inpAu = null;
      }

   }

   public void executerRequete() throws HibernateException, NamingException, ParseException {
      this.executerRequete((Session)null);
   }

   public void executerRequete(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesMails.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.requete = "from Mails where maiId!=0 ";
      if (this.usersLog.getUsrAccesMail() == 0) {
         this.requete = this.requete + " and (maiGrp='" + this.usersLog.getUsrCollaboration() + "'" + " or maiUsr=" + this.usersLog.getUsrid() + ")";
      }

      if (this.filtre1 != null && !this.filtre1.equals("")) {
         this.requete = this.requete + " and (maiTiersRs like'%" + this.filtre1 + "%' or maiDestinataire like" + "'%" + this.filtre1 + "%' or maiPatientNom like '%" + this.filtre1 + "%' or maiAgentNom like '%" + this.filtre1 + "%')";
      }

      if (this.filtre2 != null && !this.filtre2.equals("")) {
         this.requete = this.requete + " and (maiObjet like'%" + this.filtre2 + "%' or maiCorps like" + "'%" + this.filtre2 + "%')";
      }

      if (this.var_emetteur != null && !this.var_emetteur.equalsIgnoreCase("99")) {
         this.requete = this.requete + " and maiEmetteur='" + this.var_emetteur + "'";
      }

      if (this.priorite != 99) {
         this.requete = this.requete + " and maiPriorite=" + this.priorite;
      }

      if (this.var_nature != null && !this.var_nature.isEmpty()) {
         this.requete = this.requete + " and maiNature='" + this.var_nature + "'";
      }

      if (this.var_activite_rec != null && !this.var_activite_rec.isEmpty()) {
         this.requete = this.requete + " and maiActivite='" + this.var_activite_rec + "'";
      }

      if (this.var_service_rec != null && !this.var_service_rec.isEmpty()) {
         this.requete = this.requete + " and maiService='" + this.var_service_rec + "'";
      }

      if (this.sens != 99) {
         this.requete = this.requete + " and maiSens=" + this.sens;
      }

      if (this.periode != 99) {
         Date var2 = new Date();
         int var3 = var2.getYear() + 1900;
         SimpleDateFormat var4 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
         String var5;
         String var6;
         if (this.periode == 0) {
            var5 = this.utilDate.dateToStringSQLLight(this.inpDu) + " 00:00:00";
            var6 = this.utilDate.dateToStringSQLLight(this.inpAu) + " 23:59:59";
            this.requete = this.requete + " and maiDateCreation>='" + var5 + "' and maiDateCreation<='" + var6 + "'";
         }

         if (this.periode == 1) {
            Date var13 = null;
            Date var14 = null;
            Calendar var7 = Calendar.getInstance();
            var7.setTime(var2);
            String var8 = "" + var7.getTime();
            if (var8.contains("Mon")) {
               var13 = var7.getTime();
               var7.add(7, 6);
               var14 = var7.getTime();
            }

            if (var8.contains("Tue")) {
               var7.add(7, -1);
               var13 = var7.getTime();
               var7.add(7, 6);
               var14 = var7.getTime();
            }

            if (var8.contains("Wed")) {
               var7.add(7, -2);
               var13 = var7.getTime();
               var7.add(7, 6);
               var14 = var7.getTime();
            }

            if (var8.contains("Thu")) {
               var7.add(7, -3);
               var13 = var7.getTime();
               var7.add(7, 6);
               var14 = var7.getTime();
            }

            if (var8.contains("Fri")) {
               var7.add(7, -4);
               var13 = var7.getTime();
               var7.add(7, 6);
               var14 = var7.getTime();
            }

            if (var8.contains("Sat")) {
               var7.add(7, -5);
               var13 = var7.getTime();
               var7.add(7, 6);
               var14 = var7.getTime();
            }

            if (var8.contains("Sun")) {
               var7.add(7, -6);
               var13 = var7.getTime();
               var7.add(7, 6);
               var14 = var7.getTime();
            }

            String var9 = var4.format(var13) + " 00:00:00";
            String var10 = var4.format(var14) + " 23:59:59";
            this.requete = this.requete + " and maiDateCreation>='" + var9 + "'" + " and maiDateCreation<=" + "'" + var10 + "'";
         } else if (this.periode == 2) {
            var5 = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(new Date())) + " 00:00:00";
            var6 = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(new Date())) + " 23:59:59";
            this.requete = this.requete + " and maiDateCreation>='" + var5 + "'" + " and maiDateCreation<=" + "'" + var6 + "'";
         } else if (this.periode == 3) {
            int var16 = var2.getMonth() + 1;
            var6 = null;
            String var15 = null;
            if (var16 >= 1 && var16 <= 3) {
               var6 = var3 + "-" + "01-" + "01 00:00:00";
               var15 = var3 + "-" + "03-" + "31 23:59:59";
            }

            if (var16 >= 4 && var16 <= 6) {
               var6 = var3 + "-" + "04-" + "01 00:00:00";
               var15 = var3 + "-" + "06-" + "30 23:59:59";
            }

            if (var16 >= 7 && var16 <= 9) {
               var6 = var3 + "-" + "07-" + "01 00:00:00";
               var15 = var3 + "-" + "09-" + "30 23:59:59";
            }

            if (var16 >= 10 && var16 <= 12) {
               var6 = var3 + "-" + "10-" + "01 00:00:00";
               var15 = var3 + "-" + "12-" + "31 23:59:59";
            }

            this.requete = this.requete + " and maiDateCreation>='" + var6 + "'" + " and maiDateCreation<=" + "'" + var15 + "'";
         } else if (this.periode == 4) {
            var5 = var3 + "-" + "01-" + "01 00:00:00";
            var6 = var3 + "-" + "12-" + "31 23:59:59";
            this.requete = this.requete + " and maiDateCreation>='" + var5 + "'" + " and maiDateCreation<=" + "'" + var6 + "'";
         }
      } else if (this.inpDu != null && this.inpAu != null) {
         String var11 = this.utilDate.dateToStringSQLLight(this.inpDu) + " 00:00:00";
         String var12 = this.utilDate.dateToStringSQLLight(this.inpAu) + " 23:59:59";
         this.requete = this.requete + " and maiDateCreation>='" + var11 + "' and maiDateCreation<='" + var12 + "'";
      }

      if (this.var_users != 0L) {
         this.requete = this.requete + " and (maiUserCreation=" + this.var_users + " or maiUserModif=" + this.var_users + ")";
      }

      if (this.modeGroupe && this.var_structure != 0L) {
         this.requete = this.requete + " and  (MaiListeStructure like '%" + this.var_structure + "%')";
      }

      if (this.lecture != 99) {
         if (this.lecture == 0) {
            this.requete = this.requete + " and maiId not in(select mails from MailsLu as ml where users=" + this.usersLog.getUsrid() + ")";
         }

         if (this.lecture == 1) {
            this.requete = this.requete + " and maiId in(select mails from MailsLu as ml where users=" + this.usersLog.getUsrid() + ")";
         }
      }

      this.lesmailsPJ.clear();
      this.lesmailsLU.clear();
      this.lesContacts.clear();
      this.lesMails = this.mailsDao.selectLestiersMesMails(this.requete, var1);
      this.dataModelLesMails.setWrappedData(this.lesMails);
      this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
      this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
      this.dataModelContacts.setWrappedData(this.lesContacts);
      this.mails = new Mails();
      this.mailsLu = new MailsLu();
      this.mailsPj = new MailsPj();
   }

   public void executerRequeteTiers() throws HibernateException, NamingException, ParseException {
      this.requete = "from Mails where maiTiersId= " + this.tiers.getTieid();
      if (this.filtre2 != null && !this.filtre2.equals("")) {
         this.requete = this.requete + " and (maiObjet like'%" + this.filtre2 + "%' or maiCorps like" + "'%" + this.filtre2 + "%')";
      }

      if (this.priorite != 99) {
         this.requete = this.requete + " and maiPriorite=" + this.priorite;
      }

      if (this.sens != 99) {
         this.requete = this.requete + " and maiSens=" + this.sens;
      }

      if (this.periode != 99) {
         Date var1 = new Date();
         int var2 = var1.getYear() + 1900;
         SimpleDateFormat var3 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
         String var4 = var3.format(var1);
         if (this.periode == 0) {
            this.requete = this.requete + " and maiDateCreation='" + var4 + "'";
         }

         String var9;
         if (this.periode == 1) {
            Date var5 = null;
            Date var6 = null;
            Calendar var7 = Calendar.getInstance();
            var7.setTime(var1);
            String var8 = "" + var7.getTime();
            if (var8.contains("Mon")) {
               var5 = var7.getTime();
               var7.add(7, 6);
               var6 = var7.getTime();
            }

            if (var8.contains("Tue")) {
               var7.add(7, -1);
               var5 = var7.getTime();
               var7.add(7, 6);
               var6 = var7.getTime();
            }

            if (var8.contains("Wed")) {
               var7.add(7, -2);
               var5 = var7.getTime();
               var7.add(7, 6);
               var6 = var7.getTime();
            }

            if (var8.contains("Thu")) {
               var7.add(7, -3);
               var5 = var7.getTime();
               var7.add(7, 6);
               var6 = var7.getTime();
            }

            if (var8.contains("Fri")) {
               var7.add(7, -4);
               var5 = var7.getTime();
               var7.add(7, 6);
               var6 = var7.getTime();
            }

            if (var8.contains("Sat")) {
               var7.add(7, -5);
               var5 = var7.getTime();
               var7.add(7, 6);
               var6 = var7.getTime();
            }

            if (var8.contains("Sun")) {
               var7.add(7, -6);
               var5 = var7.getTime();
               var7.add(7, 6);
               var6 = var7.getTime();
            }

            var9 = var3.format(var5);
            String var10 = var3.format(var6);
            this.requete = this.requete + " and maiDateCreation>='" + var9 + "'" + " and maiDateCreation<=" + "'" + var10 + "'";
         } else {
            String var16;
            if (this.periode == 2) {
               Calendar var17 = Calendar.getInstance();
               var17.setTime(var1);
               var17.add(2, 1);
               SimpleDateFormat var21 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
               var16 = var21.format(var17.getTime());
               String[] var18 = var16.split("/");
               var9 = "01/" + var18[1] + "/" + var18[2];
               SimpleDateFormat var23 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
               Date var11 = var23.parse(var9);
               Calendar var12 = Calendar.getInstance();
               var12.setTime(var11);
               var12.add(2, -1);
               Date var13 = var12.getTime();
               var12.add(2, 1);
               var12.add(5, -1);
               Date var14 = var12.getTime();
               String var15 = var3.format(var14);
               this.requete = this.requete + " and maiDateCreation='" + var15 + "'";
            } else {
               String var22;
               if (this.periode == 3) {
                  int var19 = var1.getMonth() + 1;
                  var22 = null;
                  var16 = null;
                  if (var19 >= 1 && var19 <= 3) {
                     var22 = var2 + "/" + "01/" + "01/";
                     var16 = var2 + "/" + "03/" + "31/";
                  }

                  if (var19 >= 4 && var19 <= 6) {
                     var22 = var2 + "/" + "04/" + "01/";
                     var16 = var2 + "/" + "06/" + "30/";
                  }

                  if (var19 >= 7 && var19 <= 9) {
                     var22 = var2 + "/" + "07/" + "01/";
                     var16 = var2 + "/" + "09/" + "30/";
                  }

                  if (var19 >= 10 && var19 <= 12) {
                     var22 = var2 + "/" + "10/" + "01/";
                     var16 = var2 + "/" + "12/" + "31/";
                  }

                  this.requete = this.requete + " and maiDateCreation>='" + var22 + "'" + " and maiDateCreation<=" + "'" + var16 + "'";
               } else if (this.periode == 4) {
                  String var20 = var2 + "/" + "01/" + "01/";
                  var22 = var2 + "/" + "12/" + "31/";
                  this.requete = this.requete + " and maiDateCreation>='" + var20 + "'" + " and maiDateCreation<=" + "'" + var22 + "'";
               }
            }
         }
      }

      this.lesMails.clear();
      this.lesmailsPJ.clear();
      this.lesmailsLU.clear();
      this.lesContacts.clear();
      this.lesMails = this.mailsDao.selectLestiersMesMails(this.requete, (Session)null);
      this.dataModelLesMails.setWrappedData(this.lesMails);
      this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
      this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
      this.dataModelContacts.setWrappedData(this.lesContacts);
      this.mails = new Mails();
      this.mailsLu = new MailsLu();
      this.mailsPj = new MailsPj();
   }

   public void executerRequeteUsers() throws HibernateException, NamingException, ParseException {
      this.requete = "from Mails where (maiUsr=" + this.usersLog.getUsrid() + " or maiUserCreation=" + this.usersLog.getUsrid() + " or maiUserModif=" + this.usersLog.getUsrid() + ")";
      if (this.filtre2 != null && !this.filtre2.equals("")) {
         this.requete = this.requete + " and (maiObjet like'%" + this.filtre2 + "%' or maiCorps like" + "'%" + this.filtre2 + "%')";
      }

      if (this.priorite != 99) {
         this.requete = this.requete + " and maiPriorite=" + this.priorite;
      }

      if (this.sens != 99) {
         this.requete = this.requete + " and maiSens=" + this.sens;
      }

      if (this.periode != 99) {
         Date var1 = new Date();
         int var2 = var1.getYear() + 1900;
         SimpleDateFormat var3 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
         String var4 = var3.format(var1);
         if (this.periode == 0) {
            this.requete = this.requete + " and maiDateCreation='" + var4 + "'";
         }

         String var9;
         if (this.periode == 1) {
            Date var5 = null;
            Date var6 = null;
            Calendar var7 = Calendar.getInstance();
            var7.setTime(var1);
            String var8 = "" + var7.getTime();
            if (var8.contains("Mon")) {
               var5 = var7.getTime();
               var7.add(7, 6);
               var6 = var7.getTime();
            }

            if (var8.contains("Tue")) {
               var7.add(7, -1);
               var5 = var7.getTime();
               var7.add(7, 6);
               var6 = var7.getTime();
            }

            if (var8.contains("Wed")) {
               var7.add(7, -2);
               var5 = var7.getTime();
               var7.add(7, 6);
               var6 = var7.getTime();
            }

            if (var8.contains("Thu")) {
               var7.add(7, -3);
               var5 = var7.getTime();
               var7.add(7, 6);
               var6 = var7.getTime();
            }

            if (var8.contains("Fri")) {
               var7.add(7, -4);
               var5 = var7.getTime();
               var7.add(7, 6);
               var6 = var7.getTime();
            }

            if (var8.contains("Sat")) {
               var7.add(7, -5);
               var5 = var7.getTime();
               var7.add(7, 6);
               var6 = var7.getTime();
            }

            if (var8.contains("Sun")) {
               var7.add(7, -6);
               var5 = var7.getTime();
               var7.add(7, 6);
               var6 = var7.getTime();
            }

            var9 = var3.format(var5);
            String var10 = var3.format(var6);
            this.requete = this.requete + " and maiDateCreation>='" + var9 + "'" + " and maiDateCreation<=" + "'" + var10 + "'";
         } else {
            String var16;
            if (this.periode == 2) {
               Calendar var17 = Calendar.getInstance();
               var17.setTime(var1);
               var17.add(2, 1);
               SimpleDateFormat var21 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
               var16 = var21.format(var17.getTime());
               String[] var18 = var16.split("/");
               var9 = "01/" + var18[1] + "/" + var18[2];
               SimpleDateFormat var23 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
               Date var11 = var23.parse(var9);
               Calendar var12 = Calendar.getInstance();
               var12.setTime(var11);
               var12.add(2, -1);
               Date var13 = var12.getTime();
               var12.add(2, 1);
               var12.add(5, -1);
               Date var14 = var12.getTime();
               String var15 = var3.format(var14);
               this.requete = this.requete + " and maiDateCreation='" + var15 + "'";
            } else {
               String var22;
               if (this.periode == 3) {
                  int var19 = var1.getMonth() + 1;
                  var22 = null;
                  var16 = null;
                  if (var19 >= 1 && var19 <= 3) {
                     var22 = var2 + "/" + "01/" + "01/";
                     var16 = var2 + "/" + "03/" + "31/";
                  }

                  if (var19 >= 4 && var19 <= 6) {
                     var22 = var2 + "/" + "04/" + "01/";
                     var16 = var2 + "/" + "06/" + "30/";
                  }

                  if (var19 >= 7 && var19 <= 9) {
                     var22 = var2 + "/" + "07/" + "01/";
                     var16 = var2 + "/" + "09/" + "30/";
                  }

                  if (var19 >= 10 && var19 <= 12) {
                     var22 = var2 + "/" + "10/" + "01/";
                     var16 = var2 + "/" + "12/" + "31/";
                  }

                  this.requete = this.requete + " and maiDateCreation>='" + var22 + "'" + " and maiDateCreation<=" + "'" + var16 + "'";
               } else if (this.periode == 4) {
                  String var20 = var2 + "/" + "01/" + "01/";
                  var22 = var2 + "/" + "12/" + "31/";
                  this.requete = this.requete + " and maiDateCreation>='" + var20 + "'" + " and maiDateCreation<=" + "'" + var22 + "'";
               }
            }
         }
      }

      this.lesMails.clear();
      this.lesmailsPJ.clear();
      this.lesmailsLU.clear();
      this.lesContacts.clear();
      this.lesMails = this.mailsDao.selectLestiersMesMails(this.requete, (Session)null);
      this.dataModelLesMails.setWrappedData(this.lesMails);
      this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
      this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
      this.dataModelContacts.setWrappedData(this.lesContacts);
      this.mails = new Mails();
      this.mailsLu = new MailsLu();
      this.mailsPj = new MailsPj();
   }

   public void chargerlesmodelesDocumentsImpressions() throws HibernateException, NamingException {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "document";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.documentImpressionItems.clear();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            String var5 = var3[var4];
            if (var5.endsWith(".jasper")) {
               String var6 = var5.substring(0, var5.indexOf("."));
               this.documentImpressionItems.add(new SelectItem(var6));
            }
         }
      }

   }

   public void chargerlesmodelesMailsImpressions() throws HibernateException, NamingException {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "messagerie";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.mailImpressionItems.clear();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            String var5 = var3[var4];
            if (var5.endsWith(".jasper")) {
               String var6 = var5.substring(0, var5.indexOf("."));
               this.mailImpressionItems.add(new SelectItem(var6));
            }
         }
      }

   }

   public void chargerlesmodelesListesImpressions() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "liste" + File.separator + "messagerie";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems.clear();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            String var5 = var3[var4];
            if (var5.endsWith(".jasper")) {
               String var6 = var5.substring(0, var5.indexOf("."));
               this.listeImpressionItems.add(new SelectItem(var6));
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

   public void calculeStructureChoisie() throws HibernateException, NamingException {
      if (this.var_structure != 0L) {
         String var1 = "structure" + this.var_structure;
         Session var2 = this.utilInitHibernate.getOpenSession(var1, "Analytique");
         this.lesUsers.clear();
         String var3 = "from Users where usrMail<>'' and usrMail is not null and usrEtat=1";
         this.lesUsers = this.userDao.chargerByRequete(var3, var2);
         this.dataModelUsers.setWrappedData(this.lesUsers);
         this.mesServicesItems.clear();
         this.mesServicesItems = this.serviceDao.chargerLesServicesItems(0, false, var2);
         this.mesActivitesItem.clear();
         this.mesActivitesItem = this.activitesDao.chargerLesActivites(var2);
         this.utilInitHibernate.closeSession();
      }

   }

   public void selectionMail() throws HibernateException, NamingException, IOException, SQLException {
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
            this.mails = (Mails)var1.get(0);
            Session var18 = this.utilInitHibernate.getOpenSession(this.baseLog, "Mail");
            this.tiersDivers = false;
            if (this.mails.getMaiCorps() != null && !this.mails.getMaiCorps().isEmpty() && this.mails.getMaiCorps().length() > 10) {
               this.ongletVisu = "tabCorps";
            } else {
               this.ongletVisu = "tabEntete";
            }

            if (this.mails.getMaiTiersId() != 0L) {
               this.tiers = this.tiersDao.selectTierD(this.mails.getMaiTiersId(), var18);
               this.patients = null;
               this.salaries = null;
               this.typeTiers = 0;
               if (this.tiers.getTiecategorie().equalsIgnoreCase("Client Divers")) {
                  this.tiersDivers = true;
               } else {
                  this.tiersDivers = false;
               }
            } else if (this.mails.getMaiPatientId() != 0L) {
               this.patients = this.patientsDao.selectPatientsD(this.mails.getMaiPatientId(), var18);
               this.tiers = null;
               this.salaries = null;
               this.typeTiers = 1;
            } else if (this.mails.getMaiAgentId() != 0L) {
               this.salaries = this.salariesDao.chercherIdSalaries(this.mails.getMaiAgentId(), var18);
               this.tiers = null;
               this.patients = null;
               this.typeTiers = 2;
            }

            this.lesmailsPJ.clear();
            this.lesmailsLU.clear();
            if (this.mails.getMaiType() != 0) {
               this.affichePhotoProduit();
            } else {
               this.lesmailsPJ = this.mailsPJDao.chargerMailsPJ(this.mails, var18);
               this.lesmailsLU = this.mailsLusDao.MailsLus(this.mails, var18);
               if (this.mails.getMaiSens() == 1000 && this.mails.getMaiCorps() != null && !this.mails.getMaiCorps().isEmpty() && this.mails.getMaiCorps().contains("quoted-printable")) {
                  String[] var4 = this.mails.getMaiCorps().split("quoted-printable");
                  int var5 = var4.length - 1;
                  this.mails.setMaiCorps(var4[var5]);
                  if (this.mails.getMaiCorps().contains("so-8859-1")) {
                     String[] var6 = this.mails.getMaiCorps().split("so-8859-1");
                     this.mails.setMaiCorps(var6[1]);
                     String var7 = this.mails.getMaiCorps();
                     boolean var8 = false;
                     int var9 = 0;
                     boolean var10 = false;
                     int var11 = 0;
                     int var12 = 0;

                     while(true) {
                        if (var12 >= var7.length()) {
                           this.mails.setMaiCorps(var7);
                           break;
                        }

                        int var13 = var12 + 1;
                        if (var7.substring(var12, var13).equals("=")) {
                           var9 = var12;
                           var8 = true;
                           var11 = 0;
                        } else if (var8) {
                           ++var11;
                           if (var7.substring(var12, var13).equals(" ") || var7.substring(var12, var13).equals("0") || var7.substring(var12, var13).equals("8") || var7.substring(var12, var13).equals("9") || var7.substring(var12, var13).equals("A")) {
                              String var14 = var7.substring(var9, var13);
                              String var15 = var7.substring(1, var9);
                              String var16 = var7.substring(var13, var7.length());
                              String var17 = "";
                              if (var14.equals("= ")) {
                                 var17 = "";
                              } else if (var14.equals("=E0")) {
                                 var17 = "à";
                              } else if (var14.equals("=E8")) {
                                 var17 = "è";
                              } else if (var14.equals("=E9")) {
                                 var17 = "é";
                              } else if (var14.equals("=EA")) {
                                 var17 = "e";
                              }

                              var7 = var15 + var17 + var16;
                              var8 = false;
                           }
                        }

                        ++var12;
                     }
                  }
               }
            }

            this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
            this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.mails != null && this.mails.getMaiSens() == 4) {
         this.modifierDocument();
      }

   }

   public void effaceRecherche() throws JDOMException, IOException {
      this.mails = new Mails();
      this.lesMails.clear();
      this.dataModelLesMails.setWrappedData(this.lesContacts);
      this.mailsLu = new MailsLu();
      this.mailsPj = new MailsPj();
      this.lesmailsLU.clear();
      this.lesmailsPJ.clear();
      this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
      this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
      LectureNatureCourrier var1 = new LectureNatureCourrier();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesFamillesClientItems();
      new ArrayList();
      List var2 = var1.getMesNatures();
      new ObjetNatureCourrier();
      ObjetNatureCourrier var3;
      int var4;
      if (this.sens != 99) {
         if (var2.size() != 0) {
            for(var4 = 0; var4 < var2.size(); ++var4) {
               var3 = (ObjetNatureCourrier)var2.get(var4);
               if (var3.getCodeNature() == this.sens) {
                  this.mesNaturesItem.add(new SelectItem(var3.getCode() + ":" + var3.getLibelle()));
               }
            }
         }
      } else if (var2.size() != 0) {
         for(var4 = 0; var4 < var2.size(); ++var4) {
            var3 = (ObjetNatureCourrier)var2.get(var4);
            this.mesNaturesItem.add(new SelectItem(var3.getCode() + ":" + var3.getLibelle()));
         }
      }

      if (this.mesNaturesItem == null) {
         this.mesNaturesItem = new ArrayList();
      }

   }

   public void envoyerRecevoir() throws HibernateException, NamingException, ParseException {
      this.var_showBarProg = true;
      this.var_currentValue = 0;
      this.var_infos = "Connexion en cours...";
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      BalDao var2 = new BalDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      ArrayList var4 = new ArrayList();
      List var3 = var2.selectBalUserLogActif(this.usersLog.getUsrid(), var1);
      int var5;
      if (var3.size() != 0) {
         for(var5 = 0; var5 < var3.size(); ++var5) {
            var4.add(var3.get(var5));
         }
      }

      var3 = var2.selectBalGrpLogActif(this.usersLog.getUsrCollaboration(), var1);
      if (var3.size() != 0) {
         for(var5 = 0; var5 < var3.size(); ++var5) {
            var4.add(var3.get(var5));
         }
      }

      var3 = var2.selectBalLogActif(this.structureLog.getStrid(), var1);
      if (var3.size() != 0) {
         for(var5 = 0; var5 < var3.size(); ++var5) {
            var4.add(var3.get(var5));
         }
      }

      new ArrayList();
      List var27 = this.contactDao.selectContactsEmail(var1);
      new ArrayList();
      List var6 = this.tiersDao.selectTiersEmail(var1);
      this.utilInitHibernate.closeSession();
      this.lesMails.clear();
      if (var4.size() != 0) {
         new Bal();
         this.objetMail = new ObjetMail();
         this.utilMail = new UtilMail(this.structureLog);
         this.lesMailsRejettes.clear();
         new ArrayList();

         for(int var9 = 0; var9 < var4.size(); ++var9) {
            Bal var7 = (Bal)var4.get(var9);
            this.utilMail.lectureBal(var7, this.baseLog, var27, var6);
            List var8 = this.utilMail.getLesMailsAcceptes();
            this.lesMailsRejettes = this.utilMail.getLesMailsRejetes();
            this.dataModelMailRejets.setWrappedData(this.lesMailsRejettes);
            if (this.lesMailsRejettes.size() != 0) {
               this.mailsRejets = true;
            } else {
               this.mailsRejets = false;
            }

            if (var8.size() != 0) {
               String var10 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "mails" + File.separator + "reception" + File.separator;
               File var11 = new File(var10);
               if (!var11.exists()) {
                  var11.mkdir();
               }

               ArrayList var12 = new ArrayList();
               String var13 = "";
               var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Mail");
               Transaction var14 = null;

               try {
                  var14 = var1.beginTransaction();
                  new Mails();

                  for(int var16 = 0; var16 < var8.size(); ++var16) {
                     this.objetMail = (ObjetMail)var8.get(var16);
                     new Mails();
                     String var17 = "" + this.objetMail.getMailNumero();
                     Mails var15 = this.mailsDao.rechercheMails(var17, var1);
                     if (var15 == null) {
                        this.mails = new Mails();
                        this.mails.setMaiNum("" + this.objetMail.getMailNumero());
                        this.mails.setMaiCorps(this.objetMail.getMailContent());
                        this.mails.setMaiDestinataire(this.objetMail.getMailDestinataire());
                        this.mails.setMaiCc(this.objetMail.getMailDestinataireCC());
                        this.mails.setMaiCci(this.objetMail.getMailDestinataireCCI());
                        this.mails.setMaiEmetteur(this.objetMail.getMailExpediteur());
                        this.mails.setMaiObjet(this.objetMail.getMailSujet());
                        this.mails.setMaiDateCreation(this.objetMail.getMailDateEnvoie());
                        this.mails.setMaiDateModif(this.objetMail.getMailDateRecue());
                        this.mails.setMaiTaille(this.objetMail.getMailSize());
                        this.mails.setMaiSens(1);
                        this.mails.setMaiType(0);
                        if (this.objetMail.isMailPj()) {
                           this.mails.setMaiPj(1);
                        } else {
                           this.mails.setMaiPj(0);
                        }

                        this.mails.setMaiAgentId(this.objetMail.getMaiIdContact());
                        this.mails.setMaiAgentNom(this.objetMail.getMaiNomContact());
                        this.mails.setMaiTiersId(this.objetMail.getMaiIdTiers());
                        this.mails.setMaiTiersRs(this.objetMail.getMaiRaisonSociale());
                        this.mails = this.mailsDao.insertMail(this.mails, var1);
                        var1.flush();
                        if (this.mails.getMaiPj() == 1) {
                           var12.clear();
                           String var18 = this.mails.getMaiNum() + ":";
                           String[] var19 = var11.list();
                           int var20;
                           if (var19 != null) {
                              var19 = this.triAlphabetique(var19, var19.length);

                              for(var20 = 0; var20 < var19.length; ++var20) {
                                 String var21 = var19[var20];
                                 if (var21.startsWith(var18)) {
                                    var12.add(var21);
                                 }
                              }
                           }

                           if (var12.size() != 0) {
                              for(var20 = 0; var20 < var12.size(); ++var20) {
                                 this.mailsPj = new MailsPj();
                                 this.mailsPj.setMails(this.mails);
                                 this.mailsPj.setMalpjAcces(((String)var12.get(var20)).toString());
                                 this.mailsPj = this.mailsPJDao.insertMailPj(this.mailsPj, var1);
                              }
                           }
                        }
                     }
                  }

                  var14.commit();
               } catch (HibernateException var25) {
                  if (var14 != null) {
                     var14.rollback();
                  }

                  throw var25;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            }
         }
      }

      this.executerRequete();
      this.var_showBarProg = false;
   }

   public void selectionMailRejet() {
      if (this.dataModelMailRejets.isRowAvailable()) {
         this.objetMail = (ObjetMail)this.dataModelMailRejets.getRowData();
      }

   }

   public void ouvrirMailRejets() {
      if (this.lesMailsRejettes.size() != 0) {
         this.showModalPanelRejets = true;
      } else {
         this.showModalPanelRejets = false;
      }

   }

   public void fermerMailRejets() {
      this.showModalPanelRejets = false;
   }

   public void nouveauMail() throws HibernateException, NamingException {
      if (this.structureLog.getStrmaitrecabinet() == 2) {
         this.mesActivitesItem.clear();
         this.mesServicesItems.clear();
      } else {
         if (this.mesActivitesItem.size() == 0) {
            this.mesActivitesItem = this.activitesDao.chargerLesActivites((Session)null);
         }

         if (this.mesServicesItems.size() == 0) {
            this.mesServicesItems = this.serviceDao.chargerLesServicesItems(0, false, (Session)null);
         }
      }

      this.tiersDivers = false;
      this.lesContacts.clear();
      this.dataModelContacts.setWrappedData(this.lesContacts);
      this.lesmailsLU.clear();
      this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
      this.lesmailsPJ.clear();
      this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
      this.mails = new Mails();
      this.mailsLu = new MailsLu();
      this.mailsPj = new MailsPj();
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      if (this.formTiers == null) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
         this.mails.setMaiTiersRs("");
         this.mails.setMaiTiersId(0L);
      } else {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.tiers, "");
         this.mails.setMaiTiersRs(this.tiers.getTieraisonsocialenom());
         this.mails.setMaiTiersId(this.tiers.getTieid());
         this.chargerMailsTiers((Session)null);
      }

      this.mails.setMaiType(0);
      this.mails.setMaiSens(0);
      this.mails.setMaiDateCreation(new Date());
      if (this.formTiers == null) {
         this.var_action = 1;
      } else {
         this.formTiers.setVar_action(10);
      }

      this.typeDocument = "Mail";
      this.calculAutreMail();
   }

   public void nouveauCourrierEnvoi() throws HibernateException, NamingException {
      if (this.structureLog.getStrmaitrecabinet() == 2) {
         this.mesActivitesItem.clear();
         this.mesServicesItems.clear();
      } else {
         if (this.mesActivitesItem.size() == 0) {
            this.mesActivitesItem = this.activitesDao.chargerLesActivites((Session)null);
         }

         if (this.mesServicesItems.size() == 0) {
            this.mesServicesItems = this.serviceDao.chargerLesServicesItems(0, false, (Session)null);
         }
      }

      this.tiersDivers = false;
      this.lesContacts.clear();
      this.dataModelContacts.setWrappedData(this.lesContacts);
      this.lesmailsLU.clear();
      this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
      this.lesmailsPJ.clear();
      this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
      this.mails = new Mails();
      this.mailsLu = new MailsLu();
      this.mailsPj = new MailsPj();
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      if (this.formTiers == null) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
         this.mails.setMaiTiersRs("");
         this.mails.setMaiTiersId(0L);
      } else {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.tiers, "");
         this.mails.setMaiTiersRs(this.tiers.getTieraisonsocialenom());
         this.mails.setMaiTiersId(this.tiers.getTieid());
      }

      this.mails.setMaiType(1);
      this.mails.setMaiSens(this.sens);
      this.mails.setMaiDateCreation(new Date());
      if (this.formTiers == null) {
         this.var_action = 1;
      } else {
         this.formTiers.setVar_action(10);
      }

      if (this.sens == 125) {
         this.typeDocument = "Courrier interne ENVOI";
      } else {
         this.typeDocument = "Courrier ENVOI";
      }

      this.calculAutreMail();
   }

   public void nouveauCourrierRecu() throws HibernateException, NamingException {
      if (this.structureLog.getStrmaitrecabinet() == 2) {
         this.mesActivitesItem.clear();
         this.mesServicesItems.clear();
      } else {
         if (this.mesActivitesItem.size() == 0) {
            this.mesActivitesItem = this.activitesDao.chargerLesActivites((Session)null);
         }

         if (this.mesServicesItems.size() == 0) {
            this.mesServicesItems = this.serviceDao.chargerLesServicesItems(0, false, (Session)null);
         }
      }

      this.tiersDivers = false;
      this.lesContacts.clear();
      this.dataModelContacts.setWrappedData(this.lesContacts);
      this.lesmailsLU.clear();
      this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
      this.lesmailsPJ.clear();
      this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
      this.mails = new Mails();
      this.mailsLu = new MailsLu();
      this.mailsPj = new MailsPj();
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      if (this.formTiers == null) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
         this.mails.setMaiTiersRs("");
         this.mails.setMaiTiersId(0L);
      } else {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.tiers, "");
         this.mails.setMaiTiersRs(this.tiers.getTieraisonsocialenom());
         this.mails.setMaiTiersId(this.tiers.getTieid());
      }

      this.mails.setMaiType(1);
      this.mails.setMaiSens(this.sens);
      this.mails.setMaiDateCreation(new Date());
      if (this.formTiers == null) {
         this.var_action = 1;
      } else {
         this.formTiers.setVar_action(10);
      }

      if (this.sens == 125) {
         this.typeDocument = "Courrier interne RECU";
      } else {
         this.typeDocument = "Courrier RECU";
      }

      this.calculAutreMail();
   }

   public void modifierDocument() throws HibernateException, NamingException {
      if (this.mails != null) {
         this.mails.setMaiType(1);
         if (this.formTiers == null) {
            this.var_action = 2;
         } else {
            this.formTiers.setVar_action(11);
         }

         if (this.mails.getMaiType() == 0) {
            this.autreMail = false;
            this.typeDocument = "Mail";
         } else {
            this.autreMail = true;
            this.typeDocument = "Courrier";
         }

         this.chargerContactTiers();
      }

   }

   public void chargerContactTiers() throws HibernateException, NamingException {
      this.lesContacts.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
      if (this.mails.getMaiTiersId() != 0L) {
         new Contacts();
         this.tiers = this.tiersDao.selectTierD(this.mails.getMaiTiersId(), var1);
         if (this.tiers != null) {
            this.chargerMailsTiers(var1);
            if (this.lesContacts.size() != 0 && this.mails.getMaiDestinataire() != null && !this.mails.getMaiDestinataire().isEmpty()) {
               String[] var3 = null;
               Contacts var2;
               if (!this.mails.getMaiDestinataire().contains("#")) {
                  int var4;
                  if (this.mails.getMaiDestinataire().contains(":")) {
                     var3 = this.mails.getMaiDestinataire().split(":");

                     for(var4 = 0; var4 < this.lesContacts.size(); ++var4) {
                        var2 = (Contacts)this.lesContacts.get(var4);
                        if (var2.getConpatronyme().equals(var3[0])) {
                           var2.setSelect(true);
                        }
                     }
                  } else {
                     for(var4 = 0; var4 < this.lesContacts.size(); ++var4) {
                        var2 = (Contacts)this.lesContacts.get(var4);
                        if (var2.getConpatronyme().equals(this.mails.getMaiDestinataire())) {
                           var2.setSelect(true);
                        }
                     }
                  }
               } else {
                  String[] var7 = this.mails.getMaiDestinataire().split("#");

                  for(int var5 = 0; var5 < var7.length; ++var5) {
                     var3 = var7[var5].split(":");

                     for(int var6 = 0; var6 < this.lesContacts.size(); ++var6) {
                        var2 = (Contacts)this.lesContacts.get(var6);
                        if (var2.getConpatronyme().equals(var3[0])) {
                           var2.setSelect(true);
                        }
                     }
                  }
               }
            }
         }
      }

      this.dataModelContacts.setWrappedData(this.lesContacts);
      this.calculAutreMail();
      this.utilInitHibernate.closeSession();
   }

   public void annuleNouveauMail() {
      if (this.formTiers == null) {
         this.tiers = new Tiers();
         this.var_action = 0;
      } else {
         this.formTiers.setVar_action(5);
      }

      this.mails = new Mails();
      this.mailsLu = new MailsLu();
      this.mailsPj = new MailsPj();
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void saveDocument() throws HibernateException, NamingException {
      this.mails.setMaiCc((String)null);
      String var1;
      if (this.lesContacts.size() != 0) {
         var1 = "";
         boolean var2 = true;
         new Contacts();

         for(int var4 = 0; var4 < this.lesContacts.size(); ++var4) {
            Contacts var3 = (Contacts)this.lesContacts.get(var4);
            if (var3.isSelect()) {
               if (var2) {
                  var2 = false;
                  var1 = var3.getConpatronyme() + ":" + var3.getMailCumul();
               } else {
                  var1 = var1 + "#" + var3.getConpatronyme() + ":" + var3.getMailCumul();
               }
            }
         }

         this.mails.setMaiCc(var1);
      }

      if (this.mails.getMaiNature() != null && !this.mails.getMaiNature().isEmpty() && this.mails.getMaiNature().contains(":")) {
         String[] var5 = this.mails.getMaiNature().split(":");
         this.mails.setMaiCodeNature(var5[0]);
      } else {
         this.mails.setMaiCodeNature("");
         this.mails.setMaiNature("");
      }

      if (this.mails.getMaiId() == 0L) {
         if (this.mails.getMaiDateCreation() == null) {
            this.mails.setMaiDateCreation(new Date());
         }

         var1 = "";
         if (this.mails.getMaiSens() != 0 && this.mails.getMaiSens() != 3) {
            if (this.mails.getMaiSens() != 1 && this.mails.getMaiSens() != 4) {
               if (this.mails.getMaiSens() == 125) {
                  var1 = this.calculChrono.numCompose(this.mails.getMaiDateCreation(), 125, "", (Session)null);
               } else if (this.mails.getMaiSens() == 126) {
                  var1 = this.calculChrono.numCompose(this.mails.getMaiDateCreation(), 126, "", (Session)null);
               } else {
                  var1 = this.calculChrono.numCompose(this.mails.getMaiDateCreation(), 4, "", (Session)null);
               }
            } else {
               var1 = this.calculChrono.numCompose(this.mails.getMaiDateCreation(), 3, "", (Session)null);
            }
         } else {
            var1 = this.calculChrono.numCompose(this.mails.getMaiDateCreation(), 2, "", (Session)null);
         }

         if (var1 != null && !var1.isEmpty()) {
            this.mails.setMaiNum(var1);
         } else {
            long var6 = this.mailsDao.selectLastNum((Session)null);
            this.mails.setMaiNum("" + var6);
         }

         this.mails.setMaiUserCreation(this.usersLog.getUsrid());
         this.mails.setMaiTiersId(this.tiers.getTieid());
         this.mails = this.mailsDao.insertMail(this.mails);
         this.lesMails.add(this.mails);
         this.dataModelLesMails.setWrappedData(this.lesMails);
         this.simpleSelectionEntete.clear();
         this.extDTable = new HtmlExtendedDataTable();
      } else {
         this.mails.setMaiDateModif(new Date());
         this.mails.setMaiUserModif(this.usersLog.getUsrid());
         this.mails = this.mailsDao.modifMail(this.mails);
      }

      this.formTiers.setVar_action(5);
   }

   public void saveBrouillon() throws Exception {
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Mail");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         Bal var4 = new Bal();
         if (this.utilPrint == null) {
            this.utilPrint = new UtilPrint(this.utilInitHibernate);
         }

         var4 = this.utilPrint.recupererEmetteur(this.mails.getMaiEmetteur(), var4, this.baseLog, var2);
         this.majMail(this.mails.getMaiCorps(), var4, this.mails.getMaiEmetteur(), var2);
         if (this.lesmailsPJ.size() != 0) {
            new ArrayList();
            FileUploadBean var6 = new FileUploadBean();
            List var5 = this.convert(var6.getFiles());

            for(int var7 = 0; var7 < var5.size(); ++var7) {
               File var8 = (File)var5.get(var7);
               this.mailsPj.setMalpjAcces(var8.getName());
               this.mailsPj.setMails(this.mails);
               this.mailsPJDao.insertMailPj(this.mailsPj);
            }
         }

         var3.commit();
      } catch (HibernateException var12) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var12;
      } finally {
         var1 = true;
         this.utilInitHibernate.closeSession();
      }

      if (var1) {
         this.listeDiffusion();
      }

      this.var_action = 0;
      this.mails = new Mails();
      this.mailsLu = new MailsLu();
      this.mailsPj = new MailsPj();
      this.lesmailsLU.clear();
      this.lesmailsPJ.clear();
      this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
      this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
   }

   public void listeDiffusion() throws HibernateException, NamingException, IOException, Exception {
      if (this.modeGroupe && this.lesStructures.size() != 0 && this.mails != null && this.mails.getMaiNum() != null && !this.mails.getMaiNum().isEmpty()) {
         long var1 = 0L;
         if (this.mails.getMaiTiersId() != 0L) {
            new Tiers();
            Tiers var3 = this.tiersDao.selectTierD(this.mails.getMaiTiersId());
            if (var3 != null) {
               var1 = var3.getTieidold();
            }
         }

         if (this.var_structure != 0L) {
            new Mails();
            String var4 = "structure" + this.var_structure;
            Session var5 = this.utilInitHibernate.getOpenSession(var4, "Mail");
            Transaction var6 = null;

            try {
               var6 = var5.beginTransaction();
               Mails var17 = this.mailsDao.rechercheMails(this.mails.getMaiNum(), var5);
               if (var17 == null) {
                  var17 = new Mails();
                  var17.setMaiActivite(this.mails.getMaiActivite());
                  var17.setMaiAgentId(this.mails.getMaiAgentId());
                  var17.setMaiAgentNom(this.mails.getMaiAgentNom());
                  var17.setMaiCc(this.mails.getMaiCc());
                  var17.setMaiCci(this.mails.getMaiCci());
                  var17.setMaiCorps(this.mails.getMaiCorps());
                  var17.setMaiDateCreation(this.mails.getMaiDateCreation());
                  var17.setMaiDateModif(this.mails.getMaiDateModif());
                  var17.setMaiDestinataire(this.mails.getMaiDestinataire());
                  var17.setMaiEmetteur(this.mails.getMaiEmetteur());
                  var17.setMaiErreur(this.mails.isMaiErreur());
                  var17.setMaiGrp(this.mails.getMaiGrp());
                  var17.setMaiListeStructure(this.mails.getMaiListeStructure());
                  var17.setMaiListeIdUser(this.mails.getMaiListeIdUser());
                  var17.setMaiListeNomUser(this.mails.getMaiListeNomUser());
                  var17.setMaiModele(this.mails.getMaiModele());
                  var17.setMaiNature(this.mails.getMaiNature());
                  var17.setMaiNosRef(this.mails.getMaiNosRef());
                  var17.setMaiNum(this.mails.getMaiNum());
                  var17.setMaiObjet(this.mails.getMaiObjet());
                  var17.setMaiPatientId(this.mails.getMaiPatientId());
                  var17.setMaiPatientNom(this.mails.getMaiPatientNom());
                  var17.setMaiPj(this.mails.getMaiPj());
                  var17.setMaiPriorite(this.mails.getMaiPriorite());
                  var17.setMaiScanCourrier(this.mails.getMaiScanCourrier());
                  var17.setMaiSens(this.mails.getMaiSens());
                  var17.setMaiSensOld(this.mails.getMaiSensOld());
                  var17.setMaiService(this.mails.getMaiService());
                  var17.setMaiStatut(this.mails.getMaiStatut());
                  var17.setMaiStr(this.mails.getMaiStr());
                  var17.setMaiTaille(this.mails.getMaiTaille());
                  var17.setMaiTiersId(var1);
                  var17.setMaiTiersRs(this.mails.getMaiTiersRs());
                  var17.setMaiType(this.mails.getMaiType());
                  var17.setMaiUserCreation(this.mails.getMaiUserCreation());
                  var17.setMaiUserModif(this.mails.getMaiUserModif());
                  var17.setMaiUsr(this.mails.getMaiUsr());
                  var17.setMaiVosRef(this.mails.getMaiVosRef());
                  var17 = this.mailsDao.insertMail(this.mails, var5);
                  if (var17.getMaiScanCourrier() != null && !var17.getMaiScanCourrier().isEmpty()) {
                     String var7 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCourriers" + File.separator + var17.getMaiScanCourrier();
                     String var8 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.var_structure + File.separator + "photos" + File.separator + "scanCourriers" + File.separator + var17.getMaiScanCourrier();
                     File var9 = new File(var7);
                     File var10 = new File(var8);
                     this.utilDownload.copy(var9, var10, true);
                  }
               }

               var6.commit();
            } catch (HibernateException var14) {
               if (var6 != null) {
                  var6.rollback();
               }

               throw var14;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      if (this.lesUsers.size() != 0 && this.lesUsers.size() != 0) {
         String var16 = "";
         boolean var2 = true;
         new Users();

         for(int var18 = 0; var18 < this.lesUsers.size(); ++var18) {
            Users var19 = (Users)this.lesUsers.get(var18);
            if (var19.getUsrMail() != null && !var19.getUsrMail().isEmpty() && var19.isSelectUser()) {
               if (var2) {
                  var2 = false;
                  var16 = var19.getUsrPatronyme() + ":" + var19.getUsrMail();
               } else {
                  var16 = var16 + "#" + var19.getUsrPatronyme() + ":" + var19.getUsrMail();
               }
            }
         }

         if (var16 != null && !var16.isEmpty()) {
            this.generationMailInvitation(var16);
         }
      }

   }

   public void generationMailInvitation(String var1) throws Exception {
      if (StaticModePegase.getInternet_actif() >= 1 && var1 != null && !var1.isEmpty()) {
         this.utilMail = new UtilMail(this.structureLog);
         String var2 = "";
         var2 = this.utilMail.envoieMailCourrier(this.structureLog, this.usersLog, this.mails, var1, this.utilDate, this.var_structure);
         if (var2 != null && !var2.isEmpty()) {
            this.mails = this.mailsDao.rechercheMails(this.mails.getMaiId(), (Session)null);
            if (this.mails != null) {
               this.mails.setMaiStatut(var2);
               this.mails.setMaiErreur(true);
               this.mails = this.mailsDao.modifMail(this.mails);
            }
         }
      }

   }

   public void repondreUnique() throws HibernateException, NamingException {
      if (this.mails != null && this.tiers != null) {
         new Mails();
         Mails var1 = this.mails;
         this.lesContacts.clear();
         this.dataModelContacts.setWrappedData(this.lesContacts);
         this.lesmailsLU.clear();
         this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
         this.lesmailsPJ.clear();
         this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
         this.mails = new Mails();
         this.mailsLu = new MailsLu();
         this.mailsPj = new MailsPj();
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.tiers, "");
         this.mails.setMaiTiersRs(this.tiers.getTieraisonsocialenom());
         this.mails.setMaiTiersId(this.tiers.getTieid());
         this.chargerMailsTiers((Session)null);
         if (this.lesContacts.size() != 0) {
            String var2 = "";
            if (var1.getMaiEmetteur() != null && !var1.getMaiEmetteur().isEmpty()) {
               if (var1.getMaiEmetteur().contains(":")) {
                  String[] var3 = var1.getMaiEmetteur().split(":");
                  var2 = var3[1];
               } else {
                  var2 = var1.getMaiEmetteur();
               }
            }

            for(int var4 = 0; var4 < this.lesContacts.size(); ++var4) {
               if (var2.contains(((Contacts)this.lesContacts.get(var4)).getMailCumul())) {
                  ((Contacts)this.lesContacts.get(var4)).setSelect(true);
                  break;
               }
            }
         }

         this.mails.setMaiType(0);
         this.mails.setMaiSens(0);
         this.mails.setMaiActivite(var1.getMaiActivite());
         this.mails.setMaiCc((String)null);
         this.mails.setMaiCci(this.calculerAdresseCC_CCI(var1.getMaiCci(), (List)null));
         this.mails.setMaiCorps(var1.getMaiCorps());
         this.mails.setMaiObjet(var1.getMaiObjet());
         this.mails.setMaiPriorite(var1.getMaiPriorite());
         this.mails.setMaiService(var1.getMaiService());
         this.mails.setMaiNosRef(var1.getMaiNosRef());
         this.mails.setMaiVosRef(var1.getMaiVosRef());
         if (this.formTiers == null) {
            this.var_action = 1;
         } else {
            this.formTiers.setVar_action(10);
         }

         this.typeDocument = "Mail";
         this.calculAutreMail();
      }

   }

   public void repondreTous() throws HibernateException, NamingException {
      if (this.mails != null && this.tiers != null) {
         new Mails();
         Mails var1 = this.mails;
         this.lesContacts.clear();
         this.dataModelContacts.setWrappedData(this.lesContacts);
         this.lesmailsLU.clear();
         this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
         this.lesmailsPJ.clear();
         this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
         this.mails = new Mails();
         this.mailsLu = new MailsLu();
         this.mailsPj = new MailsPj();
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.tiers, "");
         this.mails.setMaiTiersRs(this.tiers.getTieraisonsocialenom());
         this.mails.setMaiTiersId(this.tiers.getTieid());
         this.chargerMailsTiers((Session)null);
         if (this.lesContacts.size() != 0) {
            String var2 = "";
            if (var1.getMaiEmetteur() != null && !var1.getMaiEmetteur().isEmpty()) {
               if (var1.getMaiEmetteur().contains(":")) {
                  String[] var3 = var1.getMaiEmetteur().split(":");
                  var2 = var3[1];
               } else {
                  var2 = var1.getMaiEmetteur();
               }
            }

            for(int var4 = 0; var4 < this.lesContacts.size(); ++var4) {
               if (var2.contains(((Contacts)this.lesContacts.get(var4)).getMailCumul())) {
                  ((Contacts)this.lesContacts.get(var4)).setSelect(true);
                  break;
               }
            }
         }

         this.mails.setMaiType(0);
         this.mails.setMaiSens(0);
         this.mails.setMaiActivite(var1.getMaiActivite());
         this.mails.setMaiCc(this.calculerAdresseCC_CCI(var1.getMaiCc(), this.lesContacts));
         this.mails.setMaiCci(this.calculerAdresseCC_CCI(var1.getMaiCci(), this.lesContacts));
         this.mails.setMaiCorps(var1.getMaiCorps());
         this.mails.setMaiObjet(var1.getMaiObjet());
         this.mails.setMaiPriorite(var1.getMaiPriorite());
         this.mails.setMaiService(var1.getMaiService());
         this.mails.setMaiNosRef(var1.getMaiNosRef());
         this.mails.setMaiVosRef(var1.getMaiVosRef());
         if (this.formTiers == null) {
            this.var_action = 1;
         } else {
            this.formTiers.setVar_action(10);
         }

         this.typeDocument = "Mail";
         this.calculAutreMail();
      }

   }

   public void transfererMail() throws HibernateException, NamingException {
      if (this.mails != null && this.tiers != null) {
         new Mails();
         Mails var1 = this.mails;
         this.lesContacts.clear();
         this.dataModelContacts.setWrappedData(this.lesContacts);
         this.lesmailsLU.clear();
         this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
         this.lesmailsPJ.clear();
         this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
         this.mails = new Mails();
         this.mailsLu = new MailsLu();
         this.mailsPj = new MailsPj();
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.tiers, "");
         this.mails.setMaiTiersRs(this.tiers.getTieraisonsocialenom());
         this.mails.setMaiTiersId(this.tiers.getTieid());
         this.chargerMailsTiers((Session)null);
         if (this.lesContacts.size() != 0) {
            String var2 = "";
            if (var1.getMaiEmetteur() != null && !var1.getMaiEmetteur().isEmpty()) {
               if (var1.getMaiEmetteur().contains(":")) {
                  String[] var3 = var1.getMaiEmetteur().split(":");
                  var2 = var3[1];
               } else {
                  var2 = var1.getMaiEmetteur();
               }
            }

            for(int var4 = 0; var4 < this.lesContacts.size(); ++var4) {
               if (var2.contains(((Contacts)this.lesContacts.get(var4)).getMailCumul())) {
                  ((Contacts)this.lesContacts.get(var4)).setSelect(true);
                  break;
               }
            }
         }

         this.mails.setMaiType(0);
         this.mails.setMaiSens(0);
         this.mails.setMaiActivite(var1.getMaiActivite());
         this.mails.setMaiCc(this.calculerAdresseCC_CCI(var1.getMaiCc(), this.lesContacts));
         this.mails.setMaiCci(this.calculerAdresseCC_CCI(var1.getMaiCci(), this.lesContacts));
         this.mails.setMaiCorps(var1.getMaiCorps());
         this.mails.setMaiObjet(var1.getMaiObjet());
         this.mails.setMaiPriorite(var1.getMaiPriorite());
         this.mails.setMaiService(var1.getMaiService());
         this.mails.setMaiNosRef(var1.getMaiNosRef());
         this.mails.setMaiVosRef(var1.getMaiVosRef());
         if (this.formTiers == null) {
            this.var_action = 1;
         } else {
            this.formTiers.setVar_action(10);
         }

         this.typeDocument = "Mail";
         this.calculAutreMail();
      }

   }

   public void renvoyerMail() throws Exception {
      if (this.mails != null) {
         Bal var1 = new Bal();
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         var1 = this.utilPrint.recupererEmetteur(this.mails.getMaiEmetteur(), var1, this.baseLog, (Session)null);
         Object var2 = new ArrayList();
         if (this.lesmailsPJ.size() != 0) {
            FileUploadBean var3 = new FileUploadBean();
            var2 = this.convert(var3.getFiles());
         }

         UtilMail var6 = new UtilMail(this.structureLog);
         String var4 = "";
         if (this.usersLog.getUsrMailCopie() == 1) {
            var4 = this.usersLog.getUsrMail();
         }

         String var5 = "";
         if (this.lesmailsPJ.size() != 0) {
            var5 = var6.sendMail(this.mails.getMaiCorps(), this.mails.getMaiDestinataire(), this.mails.getMaiCc(), this.mails.getMaiCci(), this.mails.getMaiEmetteur(), var4, this.mails.getMaiObjet(), var1, (List)var2);
         } else {
            var5 = var6.sendMail(this.mails.getMaiCorps(), this.mails.getMaiDestinataire(), this.mails.getMaiCc(), this.mails.getMaiCci(), this.mails.getMaiEmetteur(), var4, this.mails.getMaiObjet(), var1);
         }

         if (var5 != null && !var5.isEmpty()) {
            this.mails.setMaiStatut(var5);
            this.mails.setMaiErreur(true);
            this.mails = this.mailsDao.modifMail(this.mails);
         } else {
            this.mails.setMaiStatut("");
            this.mails.setMaiErreur(false);
            this.mails = this.mailsDao.modifMail(this.mails);
         }
      }

   }

   public String calculerAdresseCC_CCI(String var1, List var2) {
      String var3 = "";
      boolean var4 = false;
      if (var1 != null && !var1.isEmpty()) {
         String[] var5;
         int var6;
         if (!var1.contains("#")) {
            if (var1.contains(":")) {
               var5 = var3.split(":");
               if (var2 != null && var2.size() != 0) {
                  for(var6 = 0; var6 < var2.size(); ++var6) {
                     if (var5[1].contains(((Contacts)var2.get(var6)).getMailCumul())) {
                        ((Contacts)var2.get(var6)).setSelect(true);
                        var4 = true;
                        break;
                     }
                  }
               }

               if (!var4) {
                  var3 = var5[1];
               }
            } else {
               if (var2 != null && var2.size() != 0) {
                  for(int var9 = 0; var9 < var2.size(); ++var9) {
                     if (var1.contains(((Contacts)var2.get(var9)).getMailCumul())) {
                        ((Contacts)var2.get(var9)).setSelect(true);
                        var4 = true;
                        break;
                     }
                  }
               }

               if (!var4) {
                  var3 = var1;
               }
            }
         } else {
            var5 = var1.split("#");

            for(var6 = 0; var6 < var5.length; ++var6) {
               if (var5[var6].contains(":")) {
                  String[] var10 = var5[var6].split(":");
                  if (var2 != null && var2.size() != 0) {
                     for(int var8 = 0; var8 < var2.size(); ++var8) {
                        if (var10[1].contains(((Contacts)var2.get(var8)).getMailCumul())) {
                           ((Contacts)var2.get(var8)).setSelect(true);
                           var4 = true;
                           break;
                        }
                     }
                  }

                  if (!var4) {
                     if (var3 != null && !var3.isEmpty()) {
                        var3 = var3 + "," + var10[1];
                     } else {
                        var3 = var10[1];
                     }
                  }
               } else {
                  if (var2 != null && var2.size() != 0) {
                     for(int var7 = 0; var7 < var2.size(); ++var7) {
                        if (var5[var6].contains(((Contacts)var2.get(var7)).getMailCumul())) {
                           ((Contacts)var2.get(var7)).setSelect(true);
                           var4 = true;
                           break;
                        }
                     }
                  }

                  if (!var4) {
                     if (var3 != null && !var3.isEmpty()) {
                        var3 = var3 + "," + var5[var6];
                     } else {
                        var3 = var5[var6];
                     }
                  }
               }
            }
         }
      }

      return var3;
   }

   public void supprimerMail() throws HibernateException, NamingException {
      if (this.mails != null) {
         if (this.mails.getMaiSens() != 5 && this.mails.getMaiSens() != 6) {
            this.mails.setMaiSensOld(this.mails.getMaiSens());
            this.mails.setMaiSens(5);
            this.mails = this.mailsDao.modifMail(this.mails);
         } else {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Mail");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               this.deleteMailPJ();
               this.mailsPJDao.deleteMailPj(this.lesmailsPJ, var1);
               this.mailsLusDao.deleteMailLus(this.lesmailsLU, var1);
               this.mailsDao.deleteMail(this.mails, var1);
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

         this.lesMails.remove(this.mails);
         this.dataModelLesMails.setWrappedData(this.lesMails);
         this.lesmailsLU.clear();
         this.lesmailsPJ.clear();
         this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
         this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
         this.mails = new Mails();
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
      }

   }

   public void deleteMailPJ() {
      for(int var1 = 0; var1 < this.lesmailsPJ.size(); ++var1) {
         new MailsPj();
         MailsPj var2 = (MailsPj)this.lesmailsPJ.get(var1);
         String var3 = var2.getMalpjAcces();
         File var4;
         if (this.mails.getMaiSensOld() == 0) {
            var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "mails" + File.separator + "envoi" + File.separator + var3);
            if (var4.exists()) {
               var4.delete();
            }
         } else {
            var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "mails" + File.separator + "reception" + File.separator + var3);
            if (var4.exists()) {
               var4.delete();
            }
         }
      }

   }

   public void marquerLuNonLu() throws HibernateException, NamingException, ParseException, IOException, SQLException {
      if (this.mails == null) {
         this.selectionMail();
      }

      if (this.mails != null) {
         new MailsLu();
         MailsLu var1 = this.mailsLusDao.MailsLusExiste(this.mails.getMaiId(), this.usersLog.getUsrid(), (Session)null);
         if (var1 == null) {
            this.mailsLu = new MailsLu();
            this.mailsLu.setMalluDateLecture(new Date());
            this.mailsLu.setMails(this.mails);
            this.mailsLu.setUsers(this.usersLog);
            this.mailsLu.setMalluUser(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.mailsLu = this.mailsLusDao.insertMail(this.mailsLu);
         } else {
            this.mailsLusDao.deleteMailLus(this.mails.getMaiId(), this.usersLog.getUsrid());
         }

         this.lesMails.remove(this.mails);
         this.dataModelLesMails.setWrappedData(this.lesMails);
         this.lesmailsLU.clear();
         this.lesmailsPJ.clear();
         this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
         this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
         this.mails = new Mails();
      }

   }

   public void marquerLuNonLuTout() throws HibernateException, NamingException, ParseException {
      if (this.lesMails.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Mail");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            int var3 = 0;

            while(true) {
               if (var3 >= this.lesMails.size()) {
                  var2.commit();
                  break;
               }

               this.mails = (Mails)this.lesMails.get(var3);
               if (this.mails.getMaiType() == 0) {
                  new MailsLu();
                  MailsLu var4 = this.mailsLusDao.MailsLusExiste(this.mails.getMaiId(), this.usersLog.getUsrid(), var1);
                  if (var4 == null) {
                     this.mailsLu = new MailsLu();
                     this.mailsLu.setMalluDateLecture(new Date());
                     this.mailsLu.setMails(this.mails);
                     this.mailsLu.setUsers(this.usersLog);
                     this.mailsLu.setMalluUser(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
                     this.mailsLu = this.mailsLusDao.insertMail(this.mailsLu);
                  } else {
                     this.mailsLusDao.deleteMailLus(this.mails.getMaiId(), this.usersLog.getUsrid(), var1);
                  }
               }

               ++var3;
            }
         } catch (HibernateException var8) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var8;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.executerRequete();
      }

   }

   public void marquerSpam() throws HibernateException, NamingException, ParseException, IOException, SQLException {
      if (this.mails == null) {
         this.selectionMail();
      }

      if (this.mails != null) {
         if (this.mails.getMaiSens() == 1) {
            this.mails.setMaiSens(6);
         } else {
            this.mails.setMaiSens(1);
         }

         this.mails = this.mailsDao.modifMail(this.mails);
         this.lesMails.remove(this.mails);
         this.dataModelLesMails.setWrappedData(this.lesMails);
         this.lesmailsLU.clear();
         this.lesmailsPJ.clear();
         this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
         this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
         this.mails = new Mails();
      }

   }

   public void reactiverMail() throws HibernateException, NamingException, IOException, SQLException {
      if (this.mails == null) {
         this.selectionMail();
      }

      if (this.mails != null) {
         if (this.mails.getMaiSens() == 5) {
            this.mails.setMaiSens(this.mails.getMaiSensOld());
         } else if (this.mails.getMaiSens() == 6) {
            this.mails.setMaiSens(this.mails.getMaiSensOld());
         }

         this.mails = this.mailsDao.modifMail(this.mails);
         this.lesMails.remove(this.mails);
         this.dataModelLesMails.setWrappedData(this.lesMails);
         this.lesmailsLU.clear();
         this.lesmailsPJ.clear();
         this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
         this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
         this.mails = new Mails();
      }

   }

   public void voirPj() throws MalformedURLException, IOException {
      if (this.dataModelLesPJ.isRowAvailable()) {
         this.mailsPj = (MailsPj)this.dataModelLesPJ.getRowData();
         if (this.mailsPj.getMalpjAcces() != null && !this.mailsPj.getMalpjAcces().isEmpty()) {
            String var1 = "";
            if (this.mails.getMaiSens() == 0) {
               var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "mails" + File.separator + "envoi" + File.separator + this.mailsPj.getMalpjAcces();
            } else if (this.mails.getMaiSens() == 1) {
               var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "mails" + File.separator + "reception" + File.separator + this.mailsPj.getMalpjAcces();
            } else if (this.mails.getMaiSens() == 2) {
               var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "mails" + File.separator + "brouillon" + File.separator + this.mailsPj.getMalpjAcces();
            } else if (this.mails.getMaiSens() == 3) {
               var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "mails" + File.separator + "corbeille" + File.separator + this.mailsPj.getMalpjAcces();
            }

            this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
            this.fichierMine = this.utilDownload.calculeTypeMine(this.mailsPj.getMalpjAcces());
            this.showModalPanelPj = true;
         }
      }

   }

   public void fermerVisuPj() {
      this.showModalPanelPj = false;
   }

   public void calculAutreMail() {
      if (this.lesContacts.size() != 0) {
         this.autreMail = false;
      } else {
         this.autreMail = true;
      }

      if (this.sens != 125 && this.sens != 126) {
         this.gestionAgent = false;
      } else if (this.rechercheModule(50000)) {
         this.gestionAgent = true;
      } else {
         this.gestionAgent = false;
      }

      this.testValidation();
   }

   public void testValidation() {
      if (this.tiers == null && this.patients == null && this.salaries == null) {
         this.disableBouton = true;
      } else if (this.mails.getMaiDestinataire() != null && this.mails.getMaiDestinataire().contains("@")) {
         this.disableBouton = false;
      } else {
         this.disableBouton = true;
         if (this.lesContacts.size() != 0) {
            for(int var1 = 0; var1 < this.lesContacts.size(); ++var1) {
               if (((Contacts)this.lesContacts.get(var1)).isSelect()) {
                  this.disableBouton = false;
                  break;
               }
            }
         }
      }

      if (this.tiers == null && this.patients == null && this.salaries == null) {
         this.disableBoutonEnregistrer = true;
      } else {
         this.disableBoutonEnregistrer = false;
      }

   }

   public void majMailNote() throws HibernateException, NamingException {
      if (this.dataModelLesmailsLus.isRowAvailable()) {
         new MailsLu();
         MailsLu var1 = (MailsLu)this.dataModelLesmailsLus.getRowData();
         this.mailsLusDao.modifMail(var1);
      }

   }

   public void envoyerMail() throws Exception {
      Object var1 = new ArrayList();
      Bal var2 = new Bal();
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Mail");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         var2 = this.utilPrint.recupererEmetteur(this.mails.getMaiEmetteur(), var2, this.baseLog, var3);
         this.mails.setMaiCorps(this.creerCorpMessage(var2));
         this.mails = this.majMail(this.mails.getMaiCorps(), var2, this.mails.getMaiEmetteur(), var3);
         if (this.lesmailsPJ.size() != 0) {
            FileUploadBean var5 = new FileUploadBean();
            var1 = this.convert(var5.getFiles());

            for(int var6 = 0; var6 < ((List)var1).size(); ++var6) {
               File var7 = (File)((List)var1).get(var6);
               this.mailsPj.setMalpjAcces(var7.getName());
               this.mailsPj.setMails(this.mails);
               this.mailsPJDao.insertMailPj(this.mailsPj);
            }
         }

         var4.commit();
      } catch (HibernateException var11) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      UtilMail var13 = new UtilMail(this.structureLog);
      String var14 = "";
      if (this.usersLog.getUsrMailCopie() == 1) {
         var14 = this.usersLog.getUsrMail();
      }

      String var15 = "";
      if (this.lesmailsPJ.size() != 0) {
         var15 = var13.sendMail(this.mails.getMaiCorps(), this.mails.getMaiDestinataire(), this.mails.getMaiCc(), this.mails.getMaiCci(), this.mails.getMaiEmetteur(), var14, this.mails.getMaiObjet(), var2, (List)var1);
      } else {
         var15 = var13.sendMail(this.mails.getMaiCorps(), this.mails.getMaiDestinataire(), this.mails.getMaiCc(), this.mails.getMaiCci(), this.mails.getMaiEmetteur(), var14, this.mails.getMaiObjet(), var2);
      }

      if (var15 != null && !var15.isEmpty()) {
         this.mails.setMaiStatut(var15);
         this.mails.setMaiErreur(true);
         this.mails = this.mailsDao.modifMail(this.mails);
      }

      if (this.formTiers == null) {
         this.var_action = 0;
      } else {
         this.formTiers.setVar_action(5);
      }

      this.mails = new Mails();
      this.mailsLu = new MailsLu();
      this.mailsPj = new MailsPj();
      this.lesmailsLU.clear();
      this.lesmailsPJ.clear();
      this.dataModelLesmailsLus.setWrappedData(this.lesmailsLU);
      this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
   }

   public List convert(List var1) throws IOException, JDOMException {
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 < var1.size(); ++var3) {
         OwnerFile var4 = (OwnerFile)var1.get(var3);
         File var5 = this.creerLesFichiersjointes(var4.getName(), var4.getData());
         var2.add(var5);
      }

      return var2;
   }

   public File creerLesFichiersjointes(String var1, byte[] var2) throws IOException, JDOMException {
      FacesContext var3 = FacesContext.getCurrentInstance();
      File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "mails" + File.separator + "envoi" + File.separator + var1);

      try {
         this.utilDownload.write(var4, var2);
      } catch (IOException var6) {
         var6.printStackTrace();
      }

      return var4;
   }

   public void ajouterPj() {
      this.mailsPj = new MailsPj();
      this.showModalPanelAjoutFile = true;
   }

   public void supprimerPj() throws IOException {
      if (this.mailsPj != null) {
         this.lesmailsPJ.remove(this.mailsPj);
         this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
      }

   }

   public void validerPj() {
      if (this.mailsPj != null) {
         this.mailsPj.setMalpjAcces(this.nomFichier);
         this.lesmailsPJ.add(this.mailsPj);
         this.dataModelLesPJ.setWrappedData(this.lesmailsPJ);
      }

   }

   public String creerCorpMessage(Bal var1) {
      String var2 = "";
      var2 = "<html><head></head><body>";
      var2 = var2 + this.mails.getMaiCorps();
      var2 = var2 + "<p style=\"color:red;font-weight:bold;font-size:8px;\">Ce message vous est envoy&eacute; partir de la plateforme de gestion e-P&eacute;gase (https://www.e-pegase.biz).</p>";
      var2 = var2 + "<p>";
      if (var1 != null && var1.getBalSignature() != null) {
         var2 = var2 + "---";
         var2 = var2 + var1.getBalSignature();
      } else {
         var2 = var2 + "---";
      }

      var2 = var2 + "</p>";
      var2 = var2 + "</body></html>";
      return var2;
   }

   public Mails majMail(String var1, Bal var2, String var3, Session var4) throws HibernateException, NamingException {
      this.mails.setMaiCc((String)null);
      String var5 = "";
      int var8;
      if (this.lesContacts.size() != 0) {
         boolean var6 = true;
         new Contacts();

         for(var8 = 0; var8 < this.lesContacts.size(); ++var8) {
            Contacts var7 = (Contacts)this.lesContacts.get(var8);
            if (var7.isSelect()) {
               if (var6) {
                  var6 = false;
                  var5 = var7.getConpatronyme() + ":" + var7.getConmail1();
               } else {
                  var5 = var5 + "#" + var7.getConpatronyme() + ":" + var7.getConmail1();
               }
            }
         }
      }

      this.mails.setMaiCc(var5);
      if (this.lesmailsPJ.size() != 0) {
         this.mails.setMaiPj(1);
      } else {
         this.mails.setMaiPj(0);
      }

      if (this.modeGroupe) {
         this.mails.setMaiListeStructure("" + this.var_structure);
      } else {
         this.mails.setMaiListeStructure("");
      }

      if (this.lesUsers.size() != 0) {
         String var11 = "";
         String var12 = "";

         for(var8 = 0; var8 < this.lesUsers.size(); ++var8) {
            if (((Users)this.lesUsers.get(var8)).isSelectUser()) {
               if (var11 != null && !var11.isEmpty()) {
                  var11 = var11 + "," + ((Users)this.lesUsers.get(var8)).getUsrid();
               } else {
                  var11 = "" + ((Users)this.lesUsers.get(var8)).getUsrid();
               }

               if (var12 != null && !var12.isEmpty()) {
                  var12 = var12 + "," + ((Users)this.lesUsers.get(var8)).getUsrPatronyme();
               } else {
                  var12 = "" + ((Users)this.lesUsers.get(var8)).getUsrPatronyme();
               }
            }
         }

         this.mails.setMaiListeIdUser(var11);
         this.mails.setMaiListeNomUser(var12);
      } else {
         this.mails.setMaiListeIdUser("");
         this.mails.setMaiListeNomUser("");
      }

      if (this.mails.getMaiNature() != null && !this.mails.getMaiNature().isEmpty() && this.mails.getMaiNature().contains(":")) {
         String[] var13 = this.mails.getMaiNature().split(":");
         this.mails.setMaiCodeNature(var13[0]);
      } else {
         this.mails.setMaiCodeNature("");
         this.mails.setMaiNature("");
      }

      if (this.mails.getMaiId() == 0L) {
         this.mails.setMaiStr(var2.getBalStructure());
         this.mails.setMaiGrp(var2.getBalGroupe());
         this.mails.setMaiUsr(var2.getBalUser());
         if (this.mails.getMaiDateCreation() == null) {
            this.mails.setMaiDateCreation(new Date());
         }

         this.mails.setMaiUserCreation(this.usersLog.getUsrid());
         long var14 = Long.parseLong(this.mails.getMaiListeStructure());
         String var15 = "";
         if (var14 != 0L) {
            if (this.mails.getMaiSens() != 0 && this.mails.getMaiSens() != 3) {
               if (this.mails.getMaiSens() != 1 && this.mails.getMaiSens() != 4) {
                  if (this.mails.getMaiSens() == 125) {
                     var15 = this.calculChrono.numComposeOffice(this.mails.getMaiDateCreation(), 125, "", var14, var4);
                  } else if (this.mails.getMaiSens() == 126) {
                     var15 = this.calculChrono.numComposeOffice(this.mails.getMaiDateCreation(), 126, "", var14, var4);
                  } else {
                     var15 = this.calculChrono.numComposeOffice(this.mails.getMaiDateCreation(), 4, "", var14, var4);
                  }
               } else {
                  var15 = this.calculChrono.numComposeOffice(this.mails.getMaiDateCreation(), 3, "", var14, var4);
               }
            } else {
               var15 = this.calculChrono.numComposeOffice(this.mails.getMaiDateCreation(), 2, "", var14, var4);
            }
         } else if (this.mails.getMaiSens() != 0 && this.mails.getMaiSens() != 3) {
            if (this.mails.getMaiSens() != 1 && this.mails.getMaiSens() != 4) {
               if (this.mails.getMaiSens() == 125) {
                  var15 = this.calculChrono.numCompose(this.mails.getMaiDateCreation(), 125, "", var4);
               } else if (this.mails.getMaiSens() == 126) {
                  var15 = this.calculChrono.numCompose(this.mails.getMaiDateCreation(), 126, "", var4);
               } else {
                  var15 = this.calculChrono.numCompose(this.mails.getMaiDateCreation(), 4, "", var4);
               }
            } else {
               var15 = this.calculChrono.numCompose(this.mails.getMaiDateCreation(), 3, "", var4);
            }
         } else {
            var15 = this.calculChrono.numCompose(this.mails.getMaiDateCreation(), 2, "", var4);
         }

         if (var15 != null && !var15.isEmpty()) {
            this.mails.setMaiNum(var15);
         } else {
            long var9 = this.mailsDao.selectLastNum(var4);
            this.mails.setMaiNum("" + var9);
         }

         this.mailsDao.insertMail(this.mails, var4);
         this.lesMails.add(this.mails);
         this.dataModelLesMails.setWrappedData(this.lesMails);
         this.simpleSelectionEntete.clear();
         this.extDTable = new HtmlExtendedDataTable();
      } else {
         this.mails.setMaiDateModif(new Date());
         this.mails.setMaiUserModif(this.usersLog.getUsrid());
         this.mailsDao.modifMail(this.mails, var4);
      }

      return this.mails;
   }

   public void calculeModele() throws HibernateException, NamingException {
      if (this.mails.getMaiModele() != null && !this.mails.getMaiModele().isEmpty()) {
         new ModelesCourriers();
         ModelesCourriersDao var2 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var1 = var2.rechercheModeles(this.mails.getMaiModele(), (Session)null);
         if (var1 != null && this.tiers != null) {
            this.mails.setMaiCorps(this.utilTdt.analyseTexteCommercial(var1.getModTexte(), this.usersLog, this.structureLog, this.tiers));
         }
      }

   }

   public void annulerDocument() {
      this.showModalPanelAjoutFile = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void rechercheTiers() throws HibernateException, NamingException {
      this.lesTiers.clear();
      if (this.mails.getMaiTiersRs() != null && !this.mails.getMaiTiersRs().isEmpty()) {
         if (this.var_structure != 0L) {
            this.lesTiers = this.tiersDao.verifTiers(this.var_structure, this.usersLog, "", this.mails.getMaiTiersRs(), (Session)null);
         } else {
            this.lesTiers = this.tiersDao.verifTiers(this.usersLog, "", this.mails.getMaiTiersRs(), (Session)null);
         }

         if (this.lesTiers.size() != 0) {
            if (this.structureLog.getStrmaitrecabinet() == 2) {
               for(int var1 = 0; var1 < this.lesTiers.size(); ++var1) {
                  this.tiers = (Tiers)this.lesTiers.get(var1);
                  if (this.tiers.getTieidgroupe() == 0L) {
                     this.tiers.setNomGroupe("");
                  } else if (this.lesStructures.size() == 0) {
                     this.tiers.setNomGroupe("" + this.tiers.getTieidgroupe());
                  } else {
                     this.tiers.setNomGroupe("");

                     for(int var2 = 0; var2 < this.lesStructures.size(); ++var2) {
                        if (((StructurePeg)this.lesStructures.get(var2)).getStrId() == this.tiers.getTieidgroupe()) {
                           this.tiers.setNomGroupe(((StructurePeg)this.lesStructures.get(var2)).getStrsigle());
                           break;
                        }
                     }

                     if (this.tiers.getNomGroupe() == null || this.tiers.getNomGroupe().isEmpty()) {
                        this.tiers.setNomGroupe("" + this.tiers.getTieidgroupe());
                     }
                  }
               }
            }

            this.datamodelTiers.setWrappedData(this.lesTiers);
            this.showModalPanelTiers = true;
         } else {
            this.tiers = null;
            this.mails.setMaiTiersRs("");
            this.mails.setMaiTiersId(0L);
            this.mails.setMaiDestinataire("");
         }
      }

   }

   public void selectionTiers() {
      if (this.datamodelTiers.isRowAvailable()) {
         this.tiers = (Tiers)this.datamodelTiers.getRowData();
      }

   }

   public void calculeTiers() throws HibernateException, NamingException {
      if (this.lesTiers.size() != 0) {
         if (this.tiers != null) {
            this.mails.setMaiTiersRs(this.tiers.getTieraisonsocialenom());
            this.mails.setMaiTiersId(this.tiers.getTieid());
            if (this.tiers.getTiecategorie().equalsIgnoreCase("Client Divers")) {
               this.tiersDivers = true;
            } else {
               this.tiersDivers = false;
            }

            this.chargerMailsTiers((Session)null);
         } else {
            this.tiers = null;
            this.tiersDivers = false;
            this.mails.setMaiTiersRs("");
            this.mails.setMaiTiersId(0L);
            this.mails.setMaiDestinataire("");
            this.lesContacts.clear();
            this.dataModelContacts.setWrappedData(this.lesContacts);
         }
      } else {
         this.tiers = null;
         this.tiersDivers = false;
         this.mails.setMaiTiersRs("");
         this.mails.setMaiTiersId(0L);
         this.mails.setMaiDestinataire("");
         this.lesContacts.clear();
         this.dataModelContacts.setWrappedData(this.lesContacts);
      }

      this.calculAutreMail();
      this.testValidation();
      this.showModalPanelTiers = false;
   }

   public void annuleTiers() {
      this.tiers = null;
      this.mails.setMaiTiersRs("");
      this.mails.setMaiTiersId(0L);
      this.mails.setMaiDestinataire("");
      this.lesContacts.clear();
      this.dataModelContacts.setWrappedData(this.lesContacts);
      this.testValidation();
      this.showModalPanelTiers = false;
   }

   public void chargerMailsTiers(Session var1) throws HibernateException, NamingException {
      this.lesContactsMemo.clear();
      this.lesDestinatairesItems.clear();
      if (this.mails.getMaiType() == 0) {
         this.lesContactsMemo = this.contactDao.listContactByTiersMail(this.tiers, var1);
         Contacts var2;
         if (this.tiers.getTiemail1() != null && !this.tiers.getTiemail1().isEmpty() && this.tiers.getTiemail1().contains("@")) {
            var2 = new Contacts();
            var2.setConpatronyme(this.tiers.getTieraisonsocialenom() + "(1)");
            var2.setConmail1(this.tiers.getTiemail1());
            this.lesContactsMemo.add(var2);
         }

         if (this.tiers.getTiemail2() != null && !this.tiers.getTiemail2().isEmpty() && this.tiers.getTiemail2().contains("@")) {
            var2 = new Contacts();
            var2.setConpatronyme(this.tiers.getTieraisonsocialenom() + "(2)");
            var2.setConmail1(this.tiers.getTiemail2());
            this.lesContactsMemo.add(var2);
         }

         if (this.tiers.getTiemail3() != null && !this.tiers.getTiemail3().isEmpty() && this.tiers.getTiemail3().contains("@")) {
            var2 = new Contacts();
            var2.setConpatronyme(this.tiers.getTieraisonsocialenom() + "(3)");
            var2.setConmail1(this.tiers.getTiemail3());
            this.lesContactsMemo.add(var2);
         }

         if (this.tiers.getTiemail4() != null && !this.tiers.getTiemail4().isEmpty() && this.tiers.getTiemail4().contains("@")) {
            var2 = new Contacts();
            var2.setConpatronyme(this.tiers.getTieraisonsocialenom() + "(4)");
            var2.setConmail1(this.tiers.getTiemail4());
            this.lesContactsMemo.add(var2);
         }

         if (this.tiers.getTiemail5() != null && !this.tiers.getTiemail5().isEmpty() && this.tiers.getTiemail5().contains("@")) {
            var2 = new Contacts();
            var2.setConpatronyme(this.tiers.getTieraisonsocialenom() + "(5)");
            var2.setConmail1(this.tiers.getTiemail5());
            this.lesContactsMemo.add(var2);
         }

         if (this.lesContactsMemo.size() != 0) {
            new Contacts();

            for(int var3 = 0; var3 < this.lesContactsMemo.size(); ++var3) {
               var2 = (Contacts)this.lesContactsMemo.get(var3);
               if (var2.getConmail1() != null && !var2.getConmail1().isEmpty() && var2.getConmail1().contains("@")) {
                  if (var2.getConpatronyme() != null && !var2.getConpatronyme().isEmpty()) {
                     this.lesDestinatairesItems.add(new SelectItem(var2.getConmail1(), var2.getConpatronyme() + ":" + var2.getConmail1()));
                  } else {
                     this.lesDestinatairesItems.add(new SelectItem(var2.getConmail1(), var2.getConmail1()));
                  }
               }

               if (var2.getConmail2() != null && !var2.getConmail2().isEmpty() && var2.getConmail2().contains("@")) {
                  if (var2.getConpatronyme() != null && !var2.getConpatronyme().isEmpty()) {
                     this.lesDestinatairesItems.add(new SelectItem(var2.getConmail2(), var2.getConpatronyme() + ":" + var2.getConmail1()));
                  } else {
                     this.lesDestinatairesItems.add(new SelectItem(var2.getConmail2(), var2.getConmail1()));
                  }
               }

               if (var2.getConmail3() != null && !var2.getConmail3().isEmpty() && var2.getConmail3().contains("@")) {
                  if (var2.getConpatronyme() != null && !var2.getConpatronyme().isEmpty()) {
                     this.lesDestinatairesItems.add(new SelectItem(var2.getConmail3(), var2.getConpatronyme() + ":" + var2.getConmail1()));
                  } else {
                     this.lesDestinatairesItems.add(new SelectItem(var2.getConmail3(), var2.getConmail1()));
                  }
               }

               if (var2.getConmail4() != null && !var2.getConmail4().isEmpty() && var2.getConmail4().contains("@")) {
                  if (var2.getConpatronyme() != null && !var2.getConpatronyme().isEmpty()) {
                     this.lesDestinatairesItems.add(new SelectItem(var2.getConmail4(), var2.getConpatronyme() + ":" + var2.getConmail1()));
                  } else {
                     this.lesDestinatairesItems.add(new SelectItem(var2.getConmail4(), var2.getConmail1()));
                  }
               }

               if (var2.getConmail5() != null && !var2.getConmail5().isEmpty() && var2.getConmail5().contains("@")) {
                  if (var2.getConpatronyme() != null && !var2.getConpatronyme().isEmpty()) {
                     this.lesDestinatairesItems.add(new SelectItem(var2.getConmail5(), var2.getConpatronyme() + ":" + var2.getConmail1()));
                  } else {
                     this.lesDestinatairesItems.add(new SelectItem(var2.getConmail5(), var2.getConmail1()));
                  }
               }
            }

            if (this.lesDestinatairesItems.size() != 0) {
               this.mails.setMaiDestinataire(((SelectItem)this.lesDestinatairesItems.get(0)).getValue().toString());
            } else {
               this.mails.setMaiDestinataire("");
            }
         } else {
            this.mails.setMaiDestinataire("");
         }
      }

      this.calculeContactFinal();
      this.calculAutreMail();
   }

   public void calculeContactFinal() {
      this.lesContacts.clear();
      if (this.lesDestinatairesItems.size() != 0) {
         String var1 = this.mails.getMaiDestinataire();

         for(int var2 = 0; var2 < this.lesContactsMemo.size(); ++var2) {
            if (!((Contacts)this.lesContactsMemo.get(var2)).getConmail1().equals(var1)) {
               this.lesContacts.add(this.lesContactsMemo.get(var2));
            }
         }
      } else {
         for(int var3 = 0; var3 < this.lesContactsMemo.size(); ++var3) {
            this.lesContacts.add(this.lesContactsMemo.get(var3));
         }
      }

      this.dataModelContacts.setWrappedData(this.lesContacts);
   }

   public void recherchePatients() throws HibernateException, NamingException {
      this.lesPatients.clear();
      if (this.mails.getMaiPatientNom() != null && !this.mails.getMaiPatientNom().isEmpty()) {
         this.lesPatients = this.patientsDao.chargerlesPatients(this.mails.getMaiPatientNom(), (Session)null);
         if (this.lesPatients.size() != 0) {
            this.datamodelPatients.setWrappedData(this.lesPatients);
            this.showModalPanelPatients = true;
         } else {
            this.patients = null;
            this.mails.setMaiPatientNom("");
            this.mails.setMaiPatientId(0L);
            this.mails.setMaiDestinataire("");
         }
      }

   }

   public void selectionPatients() {
      if (this.datamodelPatients.isRowAvailable()) {
         this.patients = (Patients)this.datamodelPatients.getRowData();
      }

   }

   public void calculePatients() throws HibernateException, NamingException {
      if (this.lesPatients.size() != 0) {
         if (this.patients != null) {
            this.mails.setMaiPatientNom(this.patients.getPatNom() + " " + this.patients.getPatPrenom());
            this.mails.setMaiPatientId(this.patients.getPatId());
         } else {
            this.patients = null;
            this.mails.setMaiPatientNom("");
            this.mails.setMaiPatientId(0L);
            this.mails.setMaiDestinataire("");
         }
      } else {
         this.patients = null;
         this.mails.setMaiPatientNom("");
         this.mails.setMaiPatientId(0L);
         this.mails.setMaiDestinataire("");
      }

      this.utilPrint.chargerLesBalEmtteursPatient(this.baseLog, this.structureLog, this.usersLog, this.patients);
      this.calculAutreMail();
      this.testValidation();
      this.showModalPanelPatients = false;
   }

   public void annulePatients() {
      this.patients = null;
      this.mails.setMaiPatientNom("");
      this.mails.setMaiPatientId(0L);
      this.mails.setMaiDestinataire("");
      this.testValidation();
      this.showModalPanelPatients = false;
   }

   public void rechercheAgents() throws HibernateException, NamingException {
      this.lesAgents.clear();
      if (this.mails.getMaiAgentNom() != null && !this.mails.getMaiAgentNom().isEmpty()) {
         if (this.var_structure != 0L) {
            this.lesAgents = this.salariesDao.chargerlesSalariesActif(this.var_structure, this.mails.getMaiAgentNom(), (Session)null);
         } else {
            this.lesAgents = this.salariesDao.chargerlesSalariesActif(this.mails.getMaiAgentNom(), (Session)null);
         }

         if (this.lesAgents.size() != 0) {
            if (this.structureLog.getStrmaitrecabinet() == 2) {
               for(int var1 = 0; var1 < this.lesAgents.size(); ++var1) {
                  this.salaries = (Salaries)this.lesAgents.get(var1);
                  if (this.salaries.getSalIdGroupe() == 0L) {
                     this.salaries.setNomGroupe("");
                  } else if (this.lesStructures.size() == 0) {
                     this.salaries.setNomGroupe("" + this.salaries.getSalIdGroupe());
                  } else {
                     this.salaries.setNomGroupe("");

                     for(int var2 = 0; var2 < this.lesStructures.size(); ++var2) {
                        if (((StructurePeg)this.lesStructures.get(var2)).getStrId() == this.salaries.getSalIdGroupe()) {
                           this.salaries.setNomGroupe(((StructurePeg)this.lesStructures.get(var2)).getStrsigle());
                           break;
                        }
                     }

                     if (this.salaries.getNomGroupe() == null || this.salaries.getNomGroupe().isEmpty()) {
                        this.salaries.setNomGroupe("" + this.salaries.getSalIdGroupe());
                     }
                  }
               }
            }

            this.datamodelAgents.setWrappedData(this.lesAgents);
            this.showModalPanelAgents = true;
         } else {
            this.salaries = null;
            this.mails.setMaiAgentNom("");
            this.mails.setMaiAgentId(0L);
            this.mails.setMaiDestinataire("");
         }
      }

   }

   public void selectionAgents() {
      if (this.datamodelAgents.isRowAvailable()) {
         this.salaries = (Salaries)this.datamodelAgents.getRowData();
      }

   }

   public void calculeAgents() throws HibernateException, NamingException {
      if (this.lesAgents.size() != 0) {
         if (this.salaries != null) {
            this.mails.setMaiAgentNom(this.salaries.getPatronyme());
            this.mails.setMaiAgentId(this.salaries.getSalId());
         } else {
            this.salaries = null;
            this.mails.setMaiAgentNom("");
            this.mails.setMaiAgentId(0L);
            this.mails.setMaiDestinataire("");
         }
      } else {
         this.salaries = null;
         this.mails.setMaiAgentNom("");
         this.mails.setMaiAgentId(0L);
         this.mails.setMaiDestinataire("");
      }

      this.utilPrint.chargerLesBalEmtteursSalaries(this.baseLog, this.structureLog, this.usersLog, this.salaries);
      this.calculAutreMail();
      this.testValidation();
      this.showModalPanelAgents = false;
   }

   public void annuleAgents() {
      this.salaries = null;
      this.mails.setMaiAgentNom("");
      this.mails.setMaiAgentId(0L);
      this.mails.setMaiDestinataire("");
      this.testValidation();
      this.showModalPanelAgents = false;
   }

   public void affichePhotoProduit() throws IOException, SQLException {
      if (this.mails.getMaiScanCourrier() != null) {
         if (!this.mails.getMaiScanCourrier().endsWith(".pdf") && !this.mails.getMaiScanCourrier().endsWith(".PDF")) {
            this.urlphotoProd = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCourriers" + File.separator + this.mails.getMaiScanCourrier();
            this.typeFichier = 0;
         } else {
            String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCourriers" + File.separator;
            this.fichierUrl = this.utilDownload.convertirFichierUtl(var1 + this.mails.getMaiScanCourrier(), this.urlExplorateur);
            this.fichierMine = this.utilDownload.calculeTypeMine(this.mails.getMaiScanCourrier());
            this.typeFichier = 1;
         }

         this.ongletVisu = "tabScan";
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

   public void ajoutPhoto() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.mails.getMaiId() == 0L) {
         if (this.mails.getMaiDateCreation() == null) {
            this.mails.setMaiDateCreation(new Date());
         }

         this.mails.setMaiUserCreation(this.usersLog.getUsrid());
         this.mails.setMaiType(1);
         this.mails.setMaiSens(this.sens);
         this.mails.setMaiPriorite(this.priorite);
         this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
         String var1 = "";
         if (this.mails.getMaiSens() != 0 && this.mails.getMaiSens() != 3) {
            if (this.mails.getMaiSens() != 1 && this.mails.getMaiSens() != 4) {
               if (this.mails.getMaiSens() == 125) {
                  var1 = this.calculChrono.numCompose(this.mails.getMaiDateCreation(), 125, "", (Session)null);
               } else if (this.mails.getMaiSens() == 126) {
                  var1 = this.calculChrono.numCompose(this.mails.getMaiDateCreation(), 126, "", (Session)null);
               } else {
                  var1 = this.calculChrono.numCompose(this.mails.getMaiDateCreation(), 4, "", (Session)null);
               }
            } else {
               var1 = this.calculChrono.numCompose(this.mails.getMaiDateCreation(), 3, "", (Session)null);
            }
         } else {
            var1 = this.calculChrono.numCompose(this.mails.getMaiDateCreation(), 2, "", (Session)null);
         }

         this.mails.setMaiNum(var1);
         this.mails = this.mailsDao.insertMail(this.mails);
         this.lesMails.add(this.mails);
         this.dataModelLesMails.setWrappedData(this.lesMails);
      }

      if (this.mails.getMaiId() != 0L) {
         FacesContext var6 = FacesContext.getCurrentInstance();

         try {
            if (this.uploadedFile != null) {
               String var2;
               if (this.mails.getMaiScanCourrier() != null && !this.mails.getMaiScanCourrier().isEmpty()) {
                  var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCourriers" + File.separator + this.mails.getMaiScanCourrier();
                  File var3 = new File(var2);
                  if (var3.exists()) {
                     var3.delete();
                  }
               }

               var2 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
               String var7 = var2.substring(var2.indexOf(".") + 1).toLowerCase();
               var2 = this.mails.getMaiId() + "." + var7;
               File var4 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCourriers" + File.separator), var2);
               this.utilDownload.write(var4, this.uploadedFile.getInputStream());
               this.fileName = var2;
               var6.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
               this.mails.setMaiScanCourrier(var2);
               this.mails.setMaiPj(1);
               this.urlphotoProd = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCourriers" + File.separator + this.mails.getMaiScanCourrier();
            }
         } catch (IOException var5) {
            this.mails.setMaiScanCourrier(this.fileName);
            this.mails.setMaiPj(0);
            var6.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var5.printStackTrace();
         }
      }

   }

   public void reInitPhoto() throws HibernateException, NamingException, IOException, SQLException {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCourriers" + File.separator + this.mails.getMaiScanCourrier();
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      this.affichePhotoProduit();
      this.mails.setMaiScanCourrier((String)null);
      this.mails.setMaiPj(0);
      this.mailsDao.modifMail(this.mails);
   }

   public void synchroniserTiers() throws HibernateException, NamingException {
      if (this.lesStructures.size() != 0) {
         new ExercicesPaye();
         ExercicesPayeDao var2 = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
         ExercicesPaye var1 = var2.recupererLastExo((Session)null);
         this.salariesDao = null;
         this.tiers = new Tiers();
         this.salaries = new Salaries();
         Users var3 = new Users();

         for(int var4 = 0; var4 < this.lesStructures.size(); ++var4) {
            String var5 = "structure" + ((StructurePeg)this.lesStructures.get(var4)).getStrId();
            Session var6 = this.utilInitHibernate.getOpenSession(var5, "Salarie");
            new ArrayList();
            this.userDao = new UserDao(var5, this.utilInitHibernate);
            String var8 = "from Users where usrid>0 and usrMail is not null and usrMail<>'' and usrEtat = 1";
            List var7 = this.userDao.listeUsers(var8, var6);
            new ArrayList();
            this.tiersDao = new TiersDao(var5, this.utilInitHibernate);
            String var10 = "from Tiers where tieid>0";
            List var9 = this.tiersDao.listeTiers(var10, var6);
            String var11 = "";
            Object var12 = new ArrayList();
            if (var1 != null) {
               this.salariesDao = new SalariesDao(var5, this.utilInitHibernate);
               var11 = "from Salaries where salId>0";
               var12 = this.salariesDao.listeSalaries(var11, var6);
            }

            this.utilInitHibernate.closeSession();
            var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var13 = null;

            try {
               var13 = var6.beginTransaction();
               new Groupe();
               GroupeDao var15 = new GroupeDao(var5, this.utilInitHibernate);
               new ArrayList();
               this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
               var8 = "from Users where usrid>0 and usrMail is not null and usrMail<>'' ";
               List var16 = this.userDao.listeUsers(var8, var6);

               int var19;
               for(int var17 = 0; var17 < var7.size(); ++var17) {
                  boolean var18 = false;

                  for(var19 = 0; var19 < var16.size(); ++var19) {
                     if (((Users)var7.get(var17)).getUsrMail().equals(((Users)var16.get(var19)).getUsrMail())) {
                        var3 = (Users)var16.get(var19);
                        var18 = true;
                        break;
                     }
                  }

                  if (!var18) {
                     new Users();
                     var3 = (Users)var7.get(var17);
                     Groupe var14 = var15.groupeByCode(((Users)var7.get(var17)).getGroupe().getGrpCode(), var6);
                     if (var14 == null) {
                        var14 = var15.groupeByCode("ADM", var6);
                     }

                     var3.setGroupe(var14);
                     var3 = this.userDao.insert(var3, var6);
                     var16.add(var3);
                  } else if (var3 != null) {
                     var3 = this.synchronisationUsers(var3, (Users)var7.get(var17));
                     var3 = this.userDao.modUser(var3, var6);
                  }
               }

               new ArrayList();
               this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
               var10 = "from Tiers where tieidgroupe=" + ((StructurePeg)this.lesStructures.get(var4)).getStrId();
               List var27 = this.tiersDao.listeTiers(var10, var6);

               for(int var28 = 0; var28 < var9.size(); ++var28) {
                  boolean var29 = false;

                  for(int var20 = 0; var20 < var27.size(); ++var20) {
                     if (((Tiers)var9.get(var28)).getTieid() == ((Tiers)var27.get(var20)).getTieidold()) {
                        this.tiers = (Tiers)var27.get(var20);
                        var29 = true;
                        break;
                     }
                  }

                  if (!var29) {
                     this.tiers = new Tiers();
                     this.tiers = (Tiers)var9.get(var28);
                     this.tiers.setTieidgroupe(((StructurePeg)this.lesStructures.get(var4)).getStrId());
                     this.tiers.setTieidold(((Tiers)var9.get(var28)).getTieid());
                     this.tiers = this.tiersDao.insert(this.tiers, var6);
                  } else {
                     this.tiers = this.synchronisationTiers(this.tiers, (Tiers)var9.get(var28));
                     this.tiers.setTieidgroupe(((StructurePeg)this.lesStructures.get(var4)).getStrId());
                     this.tiers.setTieidold(((Tiers)var9.get(var28)).getTieid());
                     this.tiers = this.tiersDao.modif(this.tiers, var6);
                  }
               }

               if (var1 != null) {
                  new ArrayList();
                  this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
                  var11 = "from Salaries where salIdGroupe=" + ((StructurePeg)this.lesStructures.get(var4)).getStrId();
                  List var30 = this.salariesDao.listeSalaries(var11, var6);

                  for(var19 = 0; var19 < ((List)var12).size(); ++var19) {
                     boolean var31 = false;

                     for(int var21 = 0; var21 < var30.size(); ++var21) {
                        if (((Salaries)((List)var12).get(var19)).getSalId() == ((Salaries)var30.get(var21)).getSalIdOld()) {
                           this.salaries = (Salaries)var30.get(var21);
                           var31 = true;
                           break;
                        }
                     }

                     if (!var31) {
                        this.salaries = new Salaries();
                        this.salaries = (Salaries)((List)var12).get(var19);
                        this.salaries.setSalIdGroupe(((StructurePeg)this.lesStructures.get(var4)).getStrId());
                        this.salaries.setSalIdOld(((Salaries)((List)var12).get(var19)).getSalId());
                        this.salaries.setExercicesPaye(var1);
                        this.salaries = this.salariesDao.insert(this.salaries, var6);
                     } else {
                        this.salaries = this.synchronisationSalaries(this.salaries, (Salaries)((List)var12).get(var19));
                        this.salaries.setSalIdGroupe(((StructurePeg)this.lesStructures.get(var4)).getStrId());
                        this.salaries.setSalIdOld(((Salaries)((List)var12).get(var19)).getSalId());
                        this.salaries = this.salariesDao.modif(this.salaries, var6);
                     }
                  }
               }

               var13.commit();
            } catch (HibernateException var25) {
               if (var13 != null) {
                  var13.rollback();
               }

               throw var25;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

   }

   public Tiers synchronisationTiers(Tiers var1, Tiers var2) {
      var1.setTieAssujettissement(var2.getTieAssujettissement());
      var1.setTieactivite1(var2.getTieactivite1());
      var1.setTieactivite2(var2.getTieactivite2());
      var1.setTieadresse(var2.getTieadresse());
      var1.setTieadressebanque(var2.getTieadressebanque());
      var1.setTieadresseemployeur(var2.getTieadresseemployeur());
      var1.setTieanniversaire(var2.getTieanniversaire());
      var1.setTieanniversairedeces(var2.getTieanniversairedeces());
      var1.setTieanniversairemariage(var2.getTieanniversairemariage());
      var1.setTieaol(var2.getTieaol());
      var1.setTieascensseur(var2.getTieascensseur());
      var1.setTieassurt1(var2.getTieassurt1());
      var1.setTieassurt2(var2.getTieassurt2());
      var1.setTieassurt3(var2.getTieassurt3());
      var1.setTiebatiment(var2.getTiebatiment());
      var1.setTiebnq1(var2.getTiebnq1());
      var1.setTiebnq2(var2.getTiebnq2());
      var1.setTiebnq3(var2.getTiebnq3());
      var1.setTiebnq4(var2.getTiebnq4());
      var1.setTiebnq5(var2.getTiebnq5());
      var1.setTiebnq6(var2.getTiebnq6());
      var1.setTiebnq7(var2.getTiebnq7());
      var1.setTiebp(var2.getTiebp());
      var1.setTiebpemployeur(var2.getTiebpemployeur());
      var1.setTieburfax(var2.getTieburfax());
      var1.setTieburtel1(var2.getTieburtel1());
      var1.setTieburtel2(var2.getTieburtel2());
      var1.setTieburtel3(var2.getTieburtel3());
      var1.setTiecapatente(var2.getTiecapatente());
      var1.setTiecategorie(var2.getTiecategorie());
      var1.setTiecedex(var2.getTiecedex());
      var1.setTiecel1(var2.getTiecel1());
      var1.setTiecel2(var2.getTiecel2());
      var1.setTiecel3(var2.getTiecel3());
      var1.setTiechequeinterdit(var2.getTiechequeinterdit());
      var1.setTiecidate(var2.getTiecidate());
      var1.setTiecilieu(var2.getTiecilieu());
      var1.setTiecinum(var2.getTiecinum());
      var1.setTiecivilite(var2.getTiecivilite());
      var1.setTieclebanque(var2.getTieclebanque());
      var1.setTiecodepays(var2.getTiecodepays());
      var1.setTiecoefpvmedical(var2.getTiecoefpvmedical());
      var1.setTiecommune(var2.getTiecommune());
      var1.setTiecompte0(var2.getTiecompte0());
      var1.setTiecompte1(var2.getTiecompte1());
      var1.setTiecompte2(var2.getTiecompte2());
      var1.setTiecompte3(var2.getTiecompte3());
      var1.setTiecompte4(var2.getTiecompte4());
      var1.setTiecompteEtat(var2.getTiecompteEtat());
      var1.setTiecompteSage(var2.getTiecompteSage());
      var1.setTiecomptebanque(var2.getTiecomptebanque());
      var1.setTiecomptebloque(var2.getTiecomptebloque());
      var1.setTieconditionreg(var2.getTieconditionreg());
      var1.setTieconventiongele(var2.isTieconventiongele());
      var1.setTieDeclarationTva(var2.getTieDeclarationTva());
      var1.setTieDteDocument1(var2.getTieDteDocument1());
      var1.setTieDteDocument2(var2.getTieDteDocument2());
      var1.setTieDteDocument3(var2.getTieDteDocument3());
      var1.setTieDteDocument4(var2.getTieDteDocument4());
      var1.setTieDteDocument5(var2.getTieDteDocument5());
      var1.setTieDteDocument6(var2.getTieDteDocument6());
      var1.setTieDteDocument7(var2.getTieDteDocument7());
      var1.setTieDteRegement(var2.getTieDteRegement());
      var1.setTiedatecreat(var2.getTiedatecreat());
      var1.setTiedatedeces(var2.getTiedatedeces());
      var1.setTiedatemariage(var2.getTiedatemariage());
      var1.setTiedatemodif(var2.getTiedatemodif());
      var1.setTiedatenaissance(var2.getTiedatenaissance());
      var1.setTiedepart(var2.getTiedepart());
      var1.setTiedepot(var2.getTiedepot());
      var1.setTiedepotavance(var2.getTiedepotavance());
      var1.setTiedevise(var2.getTiedevise());
      var1.setTieemployeur(var2.getTieemployeur());
      var1.setTieepoux(var2.getTieepoux());
      var1.setTieescompte(var2.getTieescompte());
      var1.setTieetage(var2.getTieetage());
      var1.setTieetat(var2.getTieetat());
      var1.setTieexodouane(var2.getTieexodouane());
      var1.setTieexotva(var2.getTieexotva());
      var1.setTieFormatDevise(var2.getTieFormatDevise());
      var1.setTiefacpr(var2.getTiefacpr());
      var1.setTiefiscal(var2.getTiefiscal());
      var1.setTiegenre(var2.getTiegenre());
      var1.setTieguichetbanque(var2.getTieguichetbanque());
      var1.setTiehabitation(var2.getTiehabitation());
      var1.setTieIdStructure(var2.getTieIdStructure());
      var1.setTieiban(var2.getTieiban());
      var1.setTieilot(var2.getTieilot());
      var1.setTiejournalreg(var2.getTiejournalreg());
      var1.setTielangue(var2.getTielangue());
      var1.setTielettregarantie(var2.isTielettregarantie());
      var1.setTielieunaissance(var2.getTielieunaissance());
      var1.setTielot(var2.getTielot());
      var1.setTiemail1(var2.getTiemail1());
      var1.setTiemail2(var2.getTiemail2());
      var1.setTiemail3(var2.getTiemail3());
      var1.setTiemail4(var2.getTiemail4());
      var1.setTiemail5(var2.getTiemail5());
      var1.setTiemodecom(var2.getTiemodecom());
      var1.setTiemodereg(var2.getTiemodereg());
      var1.setTiemotifgele(var2.getTiemotifgele());
      var1.setTiemsn(var2.getTiemsn());
      var1.setTienbarrondi(var2.getTienbarrondi());
      var1.setTienbcharge(var2.getTienbcharge());
      var1.setTienbecheance(var2.getTienbecheance());
      var1.setTienbenf(var2.getTienbenf());
      var1.setTienbincident(var2.getTienbincident());
      var1.setTieniveauetude(var2.getTieniveauetude());
      var1.setTienombanque(var2.getTienombanque());
      var1.setTienomfamille(var2.getTienomfamille());
      var1.setTienomjf(var2.getTienomjf());
      var1.setTienommere(var2.getTienommere());
      var1.setTienompays(var2.getTienompays());
      var1.setTienompere(var2.getTienompere());
      var1.setTienoteauto(var2.getTienoteauto());
      var1.setTienoteman(var2.getTienoteman());
      var1.setTienouse1(var2.getTienouse1());
      var1.setTienouse2(var2.getTienouse2());
      var1.setTienum1(var2.getTienum1());
      var1.setTienum2(var2.getTienum2());
      var1.setTienum3(var2.getTienum3());
      var1.setTienum4(var2.getTienum4());
      var1.setTienum5(var2.getTienum5());
      var1.setTienum6(var2.getTienum6());
      var1.setTienum7(var2.getTienum7());
      var1.setTienum8(var2.getTienum8());
      var1.setTienum9(var2.getTienum9());
      var1.setTienum10(var2.getTienum10());
      var1.setTienum11(var2.getTienum11());
      var1.setTienum12(var2.getTienum12());
      var1.setTienum13(var2.getTienum13());
      var1.setTienum14(var2.getTienum14());
      var1.setTienum15(var2.getTienum15());
      var1.setTienum16(var2.getTienum16());
      var1.setTienum17(var2.getTienum17());
      var1.setTienum18(var2.getTienum18());
      var1.setTienum19(var2.getTienum19());
      var1.setTienum20(var2.getTienum20());
      var1.setTienumbanque(var2.getTienumbanque());
      var1.setTieobservations(var2.getTieobservations());
      var1.setTiePhoto(var2.getTiePhoto());
      var1.setTiepdv(var2.getTiepdv());
      var1.setTieplafond(var2.getTieplafond());
      var1.setTieplafpatente(var2.getTieplafpatente());
      var1.setTieporte(var2.getTieporte());
      var1.setTieprenom(var2.getTieprenom());
      var1.setTieprofession(var2.getTieprofession());
      var1.setTiequartier(var2.getTiequartier());
      var1.setTieraisonsocialenom(var2.getTieraisonsocialenom());
      var1.setTieregion(var2.getTieregion());
      var1.setTierue(var2.getTierue());
      var1.setTiesecteur(var2.getTiesecteur());
      var1.setTieserie(var2.getTieserie());
      var1.setTiesexe(var2.getTiesexe());
      var1.setTiesigle(var2.getTiesigle());
      var1.setTiesitfam(var2.getTiesitfam());
      var1.setTieskype(var2.getTieskype());
      var1.setTiesource(var2.getTiesource());
      var1.setTiesurnom(var2.getTiesurnom());
      var1.setTiesurveille(var2.getTiesurveille());
      var1.setTieswift(var2.getTieswift());
      var1.setTietauxcom(var2.getTietauxcom());
      var1.setTieteldom(var2.getTieteldom());
      var1.setTietelemployeur(var2.getTietelemployeur());
      var1.setTietelex(var2.getTietelex());
      var1.setTietelvoiture(var2.getTietelvoiture());
      var1.setTietransfertCpte(var2.getTietransfertCpte());
      var1.setTietype(var2.getTietype());
      var1.setTietypeadresse(var2.getTietypeadresse());
      var1.setTietypereg(var2.getTietypereg());
      var1.setTieusercreat(var2.getTieusercreat());
      var1.setTieusermodif(var2.getTieusermodif());
      var1.setTieville(var2.getTieville());
      var1.setTievilleemployeur(var2.getTievilleemployeur());
      var1.setTievisibilite(var2.getTievisibilite());
      var1.setTievisibiliteGrp(var2.getTievisibiliteGrp());
      var1.setTievisibiliteUser(var2.getTievisibiliteUser());
      var1.setTieweb(var2.getTieweb());
      var1.setTieyahoo(var2.getTieyahoo());
      var1.setTiezone(var2.getTiezone());
      return var1;
   }

   public Salaries synchronisationSalaries(Salaries var1, Salaries var2) {
      var1.setSalActivite(var2.getSalActivite());
      var1.setSalAdresse(var2.getSalAdresse());
      var1.setSalAnniversaire(var2.getSalAnniversaire());
      var1.setSalAol(var2.getSalAol());
      var1.setSalApprobInsp(var2.getSalApprobInsp());
      var1.setSalAscensseur(var2.getSalAscensseur());
      var1.setSalBatiment(var2.getSalBatiment());
      var1.setSalBp(var2.getSalBp());
      var1.setSalBudget(var2.getSalBudget());
      var1.setSalCel1(var2.getSalCel1());
      var1.setSalCel2(var2.getSalCel2());
      var1.setSalCel3(var2.getSalCel3());
      var1.setSalCentresImpots(var2.getSalCentresImpots());
      var1.setSalCivilite(var2.getSalCivilite());
      var1.setSalClasseRecrut(var2.getSalClasseRecrut());
      var1.setSalClassement(var2.getSalClassement());
      var1.setSalCleAnal1(var2.getSalCleAnal1());
      var1.setSalCleAnal2(var2.getSalCleAnal2());
      var1.setSalCleBanque(var2.getSalCleBanque());
      var1.setSalCodeEmploi(var2.getSalCodeEmploi());
      var1.setSalCodeNaissance(var2.getSalCodeNaissance());
      var1.setSalCommune(var2.getSalCommune());
      var1.setSalCompteAcompte(var2.getSalCompteAcompte());
      var1.setSalCompteAvance(var2.getSalCompteAvance());
      var1.setSalCompteBanque(var2.getSalCompteBanque());
      var1.setSalCompteMembre(var2.getSalCompteMembre());
      var1.setSalCompteNet(var2.getSalCompteNet());
      var1.setSalConjointEmployeurAdresse(var2.getSalConjointEmployeurAdresse());
      var1.setSalConjointEmployeurBp(var2.getSalConjointEmployeurBp());
      var1.setSalConjointEmployeurFonction(var2.getSalConjointEmployeurFonction());
      var1.setSalConjointEmployeurNom(var2.getSalConjointEmployeurNom());
      var1.setSalConjointEmployeurTel(var2.getSalConjointEmployeurTel());
      var1.setSalConjointEmployeurVille(var2.getSalConjointEmployeurVille());
      var1.setSalConjointNomJf(var2.getSalConjointNomJf());
      var1.setSalConjointNomPrenom(var2.getSalConjointNomPrenom());
      var1.setSalConjointNumFiscal(var2.getSalConjointNumFiscal());
      var1.setSalConvention(var2.getSalConvention());
      var1.setSalCoprsApp(var2.getSalCoprsApp());
      var1.setSalDateAllocataire(var2.getSalDateAllocataire());
      var1.setSalDateAmo(var2.getSalDateAmo());
      var1.setSalDateCi(var2.getSalDateCi());
      var1.setSalDateCnamgs(var2.getSalDateCnamgs());
      var1.setSalDateConcubinage(var2.getSalDateConcubinage());
      var1.setSalDateCreat(var2.getSalDateCreat());
      var1.setSalDateDivorce(var2.getSalDateDivorce());
      var1.setSalDateEntree(var2.getSalDateEntree());
      var1.setSalDateEntreePays(var2.getSalDateEntreePays());
      var1.setSalDateImpot(var2.getSalDateImpot());
      var1.setSalDateMarie(var2.getSalDateMarie());
      var1.setSalDateModif(var2.getSalDateModif());
      var1.setSalDateNaissance(var2.getSalDateNaissance());
      var1.setSalDatePacs(var2.getSalDatePacs());
      var1.setSalDateRetraite(var2.getSalDateRetraite());
      var1.setSalDateSecu(var2.getSalDateSecu());
      var1.setSalDateSortie(var2.getSalDateSortie());
      var1.setSalDateVeuf(var2.getSalDateVeuf());
      var1.setSalDelivreCi(var2.getSalDelivreCi());
      var1.setSalDeparte(var2.getSalDeparte());
      var1.setSalDepartement(var2.getSalDepartement());
      var1.setSalDispoAu(var2.getSalDispoAu());
      var1.setSalDispoDu(var2.getSalDispoDu());
      var1.setSalDisponible(var2.getSalDisponible());
      var1.setSalDocument(var2.getSalDocument());
      var1.setSalDomAct1(var2.isSalDomAct1());
      var1.setSalDomAct2(var2.isSalDomAct2());
      var1.setSalDomAct3(var2.isSalDomAct3());
      var1.setSalDomAct4(var2.isSalDomAct4());
      var1.setSalDomAct5(var2.isSalDomAct5());
      var1.setSalDomAct6(var2.isSalDomAct6());
      var1.setSalDomAct7(var2.isSalDomAct7());
      var1.setSalDomAct8(var2.isSalDomAct8());
      var1.setSalDomAct9(var2.isSalDomAct9());
      var1.setSalDomAct10(var2.isSalDomAct10());
      var1.setSalDomAct11(var2.isSalDomAct11());
      var1.setSalDomAct12(var2.isSalDomAct12());
      var1.setSalDomAct13(var2.isSalDomAct13());
      var1.setSalDomAct14(var2.isSalDomAct14());
      var1.setSalDomAct15(var2.isSalDomAct15());
      var1.setSalDomAct16(var2.isSalDomAct16());
      var1.setSalDomAct17(var2.isSalDomAct17());
      var1.setSalDomAct18(var2.isSalDomAct18());
      var1.setSalDomAct19(var2.isSalDomAct19());
      var1.setSalDomAct20(var2.isSalDomAct20());
      var1.setSalDomAct21(var2.isSalDomAct21());
      var1.setSalDomAct22(var2.isSalDomAct22());
      var1.setSalDomAct23(var2.isSalDomAct23());
      var1.setSalDomAct24(var2.isSalDomAct24());
      var1.setSalDomAct25(var2.isSalDomAct25());
      var1.setSalDomAct26(var2.isSalDomAct26());
      var1.setSalDomAct27(var2.isSalDomAct27());
      var1.setSalDomAct28(var2.isSalDomAct28());
      var1.setSalDomAct29(var2.isSalDomAct29());
      var1.setSalDomAct30(var2.isSalDomAct30());
      var1.setSalDureeJour(var2.getSalDureeJour());
      var1.setSalEscalier(var2.getSalEscalier());
      var1.setSalEtage(var2.getSalEtage());
      var1.setSalEtat(var2.getSalEtat());
      var1.setSalEthnie(var2.getSalEthnie());
      var1.setSalFeuille(var2.getSalFeuille());
      var1.setSalFonction(var2.getSalFonction());
      var1.setSalFrEcrire(var2.getSalFrEcrire());
      var1.setSalFrLire(var2.getSalFrLire());
      var1.setSalFrParler(var2.getSalFrParler());
      var1.setSalGenre(var2.getSalGenre());
      var1.setSalGrade(var2.getSalGrade());
      var1.setSalGrille(var2.getSalGrille());
      var1.setSalGuichetBanque(var2.getSalGuichetBanque());
      var1.setSalIban(var2.getSalIban());
      var1.setSalIdTiers(var2.getSalIdTiers());
      var1.setSalIlot(var2.getSalIlot());
      var1.setSalLangue(var2.getSalLangue());
      var1.setSalLibCentresImpots(var2.getSalLibCentresImpots());
      var1.setSalLibClassement(var2.getSalLibClassement());
      var1.setSalLibCleAnal1(var2.getSalLibCleAnal1());
      var1.setSalLibCleAnal2(var2.getSalLibCleAnal2());
      var1.setSalLibConvention(var2.getSalLibConvention());
      var1.setSalLibGrille(var2.getSalLibGrille());
      var1.setSalLibNivEmploi(var2.getSalLibNivEmploi());
      var1.setSalLibService(var2.getSalLibService());
      var1.setSalLieuCi(var2.getSalLieuCi());
      var1.setSalLieuNaissance(var2.getSalLieuNaissance());
      var1.setSalLocEcrire(var2.getSalLocEcrire());
      var1.setSalLocLire(var2.getSalLocLire());
      var1.setSalLocParler(var2.getSalLocParler());
      var1.setSalLocalisation(var2.getSalLocalisation());
      var1.setSalLot(var2.getSalLot());
      var1.setSalAdresse(var2.getSalAdresse());
      var1.setSalMail1(var2.getSalMail1());
      var1.setSalMatricule(var2.getSalMatricule());
      var1.setSalMere(var2.getSalMere());
      var1.setSalMiseRelation(var2.isSalMiseRelation());
      var1.setSalMobile(var2.getSalMobile());
      var1.setSalMobileSauf(var2.getSalMobileSauf());
      var1.setSalModeReglement(var2.getSalModeReglement());
      var1.setSalMotifSortie(var2.getSalMotifSortie());
      var1.setSalMsn(var2.getSalMsn());
      var1.setSalNationnalite(var2.getSalNationnalite());
      var1.setSalNature(var2.getSalNature());
      var1.setSalNbAnnee(var2.getSalNbAnnee());
      var1.setSalNbEnfant(var2.getSalNbEnfant());
      var1.setSalNbFemme(var2.getSalNbFemme());
      var1.setSalNbJourCp(var2.getSalNbJourCp());
      var1.setSalNbJourTr(var2.getSalNbJourTr());
      var1.setSalNbPartFiscal(var2.getSalNbPartFiscal());
      var1.setSalNbPartTrimf(var2.getSalNbPartTrimf());
      var1.setSalNivEmploi(var2.getSalNivEmploi());
      var1.setSalNom(var2.getSalNom());
      var1.setSalNomJf(var2.getSalNomJf());
      var1.setSalNomTiers(var2.getSalNomTiers());
      var1.setSalNompays(var2.getSalNompays());
      var1.setSalNumAllocataire(var2.getSalNumAllocataire());
      var1.setSalNumAmo(var2.getSalNumAmo());
      var1.setSalNumBanque(var2.getSalNumBanque());
      var1.setSalNumCi(var2.getSalNumCi());
      var1.setSalNumCnamgs(var2.getSalNumCnamgs());
      var1.setSalNumFiscal(var2.getSalNumFiscal());
      var1.setSalNumRetraite(var2.getSalNumRetraite());
      var1.setSalNumSecu(var2.getSalNumSecu());
      var1.setSalObservation(var2.getSalObservation());
      var1.setSalParc(var2.getSalParc());
      var1.setSalPaysNaissance(var2.getSalPaysNaissance());
      var1.setSalPere(var2.getSalPere());
      var1.setSalPhoto(var2.getSalPhoto());
      var1.setSalPorte(var2.getSalPorte());
      var1.setSalPrenom(var2.getSalPrenom());
      var1.setSalProfession(var2.getSalProfession());
      var1.setSalProtege(var2.getSalProtege());
      var1.setSalQuartier(var2.getSalQuartier());
      var1.setSalRue(var2.getSalRue());
      var1.setSalService(var2.getSalService());
      var1.setSalServiceMil(var2.isSalServiceMil());
      var1.setSalSitFamille(var2.getSalSitFamille());
      var1.setSalSite(var2.getSalSite());
      var1.setSalSkype(var2.getSalSkype());
      var1.setSalSwift(var2.getSalSwift());
      var1.setSalTelBur(var2.getSalTelBur());
      var1.setSalTelDom(var2.getSalTelDom());
      var1.setSalUsEcrire(var2.getSalUsEcrire());
      var1.setSalUsLire(var2.getSalUsLire());
      var1.setSalUsParler(var2.getSalUsParler());
      var1.setSalUserCreat(var2.getSalUserCreat());
      var1.setSalUserModif(var2.getSalUserModif());
      var1.setSalVille(var2.getSalVille());
      var1.setSalVisaEnreg(var2.getSalVisaEnreg());
      var1.setSalYahoo(var2.getSalYahoo());
      var1.setSalZone(var2.getSalZone());
      return var1;
   }

   public Users synchronisationUsers(Users var1, Users var2) {
      var1.setUsrAccesBrouillard(var2.getUsrAccesBrouillard());
      var1.setUsrAccesCorrection(var2.getUsrAccesCorrection());
      var1.setUsrAccesMail(var2.getUsrAccesMail());
      var1.setUsrAchLibelle(var2.getUsrAchLibelle());
      var1.setUsrAchPump(var2.getUsrAchPump());
      var1.setUsrAchats(var2.getUsrAchats());
      var1.setUsrAcheteur(var2.getUsrAcheteur());
      var1.setUsrAdresse(var2.getUsrAdresse());
      var1.setUsrAffPlancher(var2.getUsrAffPlancher());
      var1.setUsrAffPump(var2.getUsrAffPump());
      var1.setUsrAffPvMarche(var2.getUsrAffPvMarche());
      var1.setUsrAnniversaire(var2.getUsrAnniversaire());
      var1.setUsrAol(var2.getUsrAol());
      var1.setUsrAssistant(var2.getUsrAssistant());
      var1.setUsrBaseCopie(var2.getUsrBaseCopie());
      var1.setUsrBp(var2.getUsrBp());
      var1.setUsrCaissier(var2.getUsrCaissier());
      var1.setUsrCaissierAnnule(var2.getUsrCaissierAnnule());
      var1.setUsrCaissierDelete(var2.getUsrCaissierDelete());
      var1.setUsrCaissierDepense(var2.getUsrCaissierDepense());
      var1.setUsrCaissierModif(var2.getUsrCaissierModif());
      var1.setUsrCaissierRecette(var2.getUsrCaissierRecette());
      var1.setUsrCaissierService(var2.getUsrCaissierService());
      var1.setUsrCaissierTransfert(var2.getUsrCaissierTransfert());
      var1.setUsrCel1(var2.getUsrCel1());
      var1.setUsrCel2(var2.getUsrCel2());
      var1.setUsrCel3(var2.getUsrCel3());
      var1.setUsrChange(var2.getUsrChange());
      var1.setUsrChgDosAchat(var2.getUsrChgDosAchat());
      var1.setUsrCivilite(var2.getUsrCivilite());
      var1.setUsrCollaboration(var2.getUsrCollaboration());
      var1.setUsrCommAchats(var2.getUsrCommAchats());
      var1.setUsrCommPourcentage(var2.getUsrCommPourcentage());
      var1.setUsrCommType(var2.getUsrCommType());
      var1.setUsrCommVentes(var2.getUsrCommVentes());
      var1.setUsrCompte(var2.getUsrCompte());
      var1.setUsrConfigListe(var2.getUsrConfigListe());
      var1.setUsrConnexion(var2.getUsrConnexion());
      var1.setUsrCptActivite(var2.isUsrCptActivite());
      var1.setUsrCptAgent(var2.isUsrCptAgent());
      var1.setUsrCptChantier(var2.isUsrCptChantier());
      var1.setUsrCptCles(var2.isUsrCptCles());
      var1.setUsrCptDossier(var2.isUsrCptDossier());
      var1.setUsrCptInterdit(var2.getUsrCptInterdit());
      var1.setUsrCptMission(var2.isUsrCptMission());
      var1.setUsrCptParc(var2.isUsrCptParc());
      var1.setUsrCptProjet(var2.isUsrCptProjet());
      var1.setUsrCptRegion(var2.isUsrCptRegion());
      var1.setUsrCptSite(var2.isUsrCptSite());
      var1.setUsrCptStructure(var2.isUsrCptStructure());
      var1.setUsrCptUsine(var2.isUsrCptUsine());
      var1.setUsrDateAch(var2.getUsrDateAch());
      var1.setUsrDateCai(var2.getUsrDateCai());
      var1.setUsrDateCreat(var2.getUsrDateCreat());
      var1.setUsrDateDebutIndisponibilite(var2.getUsrDateDebutIndisponibilite());
      var1.setUsrDateFinIndisponibilite(var2.getUsrDateFinIndisponibilite());
      var1.setUsrDateLivre(var2.getUsrDateLivre());
      var1.setUsrDateMed(var2.getUsrDateMed());
      var1.setUsrDateModif(var2.getUsrDateModif());
      var1.setUsrDateNaissance(var2.getUsrDateNaissance());
      var1.setUsrDatePrc(var2.getUsrDatePrc());
      var1.setUsrDateStk(var2.getUsrDateStk());
      var1.setUsrDateVte(var2.getUsrDateVte());
      var1.setUsrDemandeurAchats(var2.getUsrDemandeurAchats());
      var1.setUsrDepartement(var2.getUsrDepartement());
      var1.setUsrDepotSel(var2.getUsrDepotSel());
      var1.setUsrEtat(0);
      var1.setUsrFactureCaisse(var2.getUsrFactureCaisse());
      var1.setUsrFactureDeCaisse(var2.getUsrFactureDeCaisse());
      var1.setUsrFeuilleInterdite(var2.getUsrFeuilleInterdite());
      var1.setUsrFonction(var2.getUsrFonction());
      var1.setUsrIdEquipe(var2.getUsrIdEquipe());
      var1.setUsrIdSalarieGuest(var2.getUsrIdSalarieGuest());
      var1.setUsrIdTiersGuest(var2.getUsrIdTiersGuest());
      var1.setUsrImputCai(var2.getUsrImputCai());
      var1.setUsrInitiale(var2.getUsrInitiale());
      var1.setUsrJrxInterdit(var2.getUsrJrxInterdit());
      var1.setUsrJrxReserve(var2.getUsrJrxReserve());
      var1.setUsrLangue(var2.getUsrLangue());
      var1.setUsrLibelleCai(var2.getUsrLibelleCai());
      var1.setUsrLissage(var2.getUsrLissage());
      var1.setUsrLogin(var2.getUsrLogin());
      var1.setUsrMail(var2.getUsrMail());
      var1.setUsrMailCopie(var2.getUsrMailCopie());
      var1.setUsrMailParapheur(var2.getUsrMailParapheur());
      var1.setUsrMedical(var2.getUsrMedical());
      var1.setUsrMedicalAvoir(var2.getUsrMedicalAvoir());
      var1.setUsrMetier(var2.getUsrMetier());
      var1.setUsrMf(var2.getUsrMf());
      var1.setUsrModifLiasse(var2.getUsrModifLiasse());
      var1.setUsrModifSerieAch(var2.getUsrModifSerieAch());
      var1.setUsrModifSerieVte(var2.getUsrModifSerieVte());
      var1.setUsrMontantCai(var2.getUsrMontantCai());
      var1.setUsrMsn(var2.getUsrMsn());
      var1.setUsrMyLifeChat(var2.isUsrMyLifeChat());
      var1.setUsrNom(var2.getUsrNom());
      var1.setUsrNomBaseCopie(var2.getUsrNomBaseCopie());
      var1.setUsrNomEquipe(var2.getUsrNomEquipe());
      var1.setUsrNomPays(var2.getUsrNomPays());
      var1.setUsrNomSalarieGuest(var2.getUsrNomSalarieGuest());
      var1.setUsrNomTiersGuest(var2.getUsrNomTiersGuest());
      var1.setUsrParcAlerte(var2.getUsrParcAlerte());
      var1.setUsrPatronyme(var2.getUsrPatronyme());
      var1.setUsrPayPointage(var2.getUsrPayPointage());
      var1.setUsrPaye(var2.getUsrPaye());
      var1.setUsrPayeAlerte(var2.getUsrPayeAlerte());
      var1.setUsrPayeBulletin(var2.getUsrPayeBulletin());
      var1.setUsrPayeContrat(var2.getUsrPayeContrat());
      var1.setUsrPayeService(var2.getUsrPayeService());
      var1.setUsrPhoto(var2.getUsrPhoto());
      var1.setUsrPlanning(var2.getUsrPlanning());
      var1.setUsrPlanningService(var2.getUsrPlanningService());
      var1.setUsrPr(var2.getUsrPr());
      var1.setUsrPrenom(var2.getUsrPrenom());
      var1.setUsrProdService(var2.getUsrProdService());
      var1.setUsrProdServiceAch(var2.getUsrProdServiceAch());
      var1.setUsrPv(var2.getUsrPv());
      var1.setUsrPwEspaceClient(var2.getUsrPwEspaceClient());
      var1.setUsrRecus(var2.getUsrRecus());
      var1.setUsrRecusJour(var2.getUsrRecusJour());
      var1.setUsrRespAchats(var2.getUsrRespAchats());
      var1.setUsrRespCaissier(var2.getUsrRespCaissier());
      var1.setUsrResponsableVentes(var2.getUsrResponsableVentes());
      var1.setUsrSansHabilitation(var2.getUsrSansHabilitation());
      var1.setUsrService(var2.getUsrService());
      var1.setUsrSignature(var2.getUsrSignature());
      var1.setUsrSignatureAchats(var2.getUsrSignatureAchats());
      var1.setUsrSignatureCaisse(var2.getUsrSignatureCaisse());
      var1.setUsrSignatureCompta(var2.getUsrSignatureCompta());
      var1.setUsrSignatureEducation(var2.getUsrSignatureEducation());
      var1.setUsrSignatureMedical(var2.getUsrSignatureMedical());
      var1.setUsrSignatureMicroFinance(var2.getUsrSignatureMicroFinance());
      var1.setUsrSignatureOffice(var2.getUsrSignatureOffice());
      var1.setUsrSignatureParc(var2.getUsrSignatureParc());
      var1.setUsrSignaturePaye(var2.getUsrSignaturePaye());
      var1.setUsrSignatureVentes(var2.getUsrSignatureVentes());
      var1.setUsrSite(var2.getUsrSite());
      var1.setUsrSkype(var2.getUsrSkype());
      var1.setUsrSpecialite(var2.getUsrSpecialite());
      var1.setUsrStartup(var2.getUsrStartup());
      var1.setUsrSysteme(var2.getUsrSysteme());
      var1.setUsrTelBureau(var2.getUsrTelBureau());
      var1.setUsrTelDomicile(var2.getUsrTelDomicile());
      var1.setUsrTemplates(var2.getUsrTemplates());
      var1.setUsrThemes(var2.getUsrThemes());
      var1.setUsrTiers(var2.getUsrTiers());
      var1.setUsrTiersCai(var2.getUsrTiersCai());
      var1.setUsrUserCreat(var2.getUsrUserCreat());
      var1.setUsrUserModif(var2.getUsrUserModif());
      var1.setUsrVendeur(var2.getUsrVendeur());
      var1.setUsrVentes(var2.getUsrVentes());
      var1.setUsrVerPaAch(var2.getUsrVerPaAch());
      var1.setUsrVerPv(var2.getUsrVerPv());
      var1.setUsrVerRabais(var2.getUsrVerRabais());
      var1.setUsrVerRabaisAch(var2.getUsrVerRabaisAch());
      var1.setUsrVerRemise(var2.getUsrVerRemise());
      var1.setUsrVerRemiseAch(var2.getUsrVerRemiseAch());
      var1.setUsrVille(var2.getUsrVille());
      var1.setUsrVteCtrAlerte(var2.getUsrVteCtrAlerte());
      var1.setUsrVteLibelle(var2.getUsrVteLibelle());
      var1.setUsrVteTotaux(var2.getUsrVteTotaux());
      var1.setUsrYahoo(var2.getUsrYahoo());
      return var1;
   }

   public void imprimerMail() throws HibernateException, NamingException {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.tiers, "");
      this.chargerlesmodelesDocumentsImpressions();
      this.chargerlesmodelesMailsImpressions();
      this.chargerlesmodelesListesImpressions();
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
      } else if (this.var_choix_modele == 1) {
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
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimer();
      }

   }

   public void envoieMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.tiers, "");
         if (this.utilPrint.getLesbalEmetteursItems().size() != 0 && this.utilPrint.getLesbalDestinatairesItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public String calculeCheminRapport(String var1) {
      String var2 = "";
      if (this.mails.getMaiType() == 0) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "messagerie" + File.separator;
      } else {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "document" + File.separator;
      }

      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      File var3 = new File(this.calculeCheminSousRapport(var1) + "formatTiers.jpg");
      if (var3.exists()) {
         var2 = "formatTiers.jpg";
      }

      return var2;
   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      JRBeanCollectionDataSource var2;
      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            this.requete = " cmm_mails.`mai_id`=" + this.mails.getMaiId();
            this.utilPrint.setSource("");
            this.utilPrint.setRecordPath("");
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setRequete(this.requete);
            this.utilPrint.setFiltre("");
            this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setEntete("Impression mail/courrier");
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setImageFondPage(this.calculeImageFond(this.baseLog));
            this.utilPrint.setIdResponsable(0L);
            this.utilPrint.setTiersSelectionne(this.tiers);
            ArrayList var1 = new ArrayList();
            var2 = new JRBeanCollectionDataSource(var1);
            this.utilPrint.setjRBeanCollectionDataSource(var2);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.var_choix_modele == 1 && this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setSource("");
         this.utilPrint.setRecordPath("");
         this.utilPrint.setRapport(this.nomModeleListe);
         if (this.sens == 0) {
            this.utilPrint.setEntete("Impression de la liste des mails envoyés");
         } else if (this.sens == 1) {
            this.utilPrint.setEntete("Impression de la liste des mails reçus");
         } else if (this.sens == 2) {
            this.utilPrint.setEntete("Impression de la liste des mails brouillons");
         } else if (this.sens == 3) {
            this.utilPrint.setEntete("Impression de la liste des courriers envoyés");
         } else if (this.sens == 4) {
            this.utilPrint.setEntete("Impression de la liste des courriers reçus");
         } else if (this.sens == 5) {
            this.utilPrint.setEntete("Impression de la liste des éléments de la corbeille");
         } else if (this.sens == 125) {
            this.utilPrint.setEntete("Impression de la liste des courriers internes envoyés");
         } else if (this.sens == 126) {
            this.utilPrint.setEntete("Impression de la liste des courriers internes reçus");
         } else {
            this.utilPrint.setEntete("Impression de la liste de tous les éléments");
         }

         if (this.inpDu != null && this.inpAu != null) {
            this.utilPrint.setFiltre("Du " + this.utilDate.dateToStringFrLg(this.inpDu) + " Au " + this.utilDate.dateToStringFrLg(this.inpAu));
         } else if (this.periode == 0) {
            this.utilPrint.setFiltre("Jour en cours");
         } else if (this.periode == 1) {
            this.utilPrint.setFiltre("Semaine en cours");
         } else if (this.periode == 2) {
            this.utilPrint.setFiltre("Mois en cours");
         } else if (this.periode == 3) {
            this.utilPrint.setFiltre("Trimestre en cours");
         } else if (this.periode == 4) {
            this.utilPrint.setFiltre("Semestre en cours");
         } else if (this.periode == 5) {
            this.utilPrint.setFiltre("Année en cours");
         }

         if (this.lecture == 0) {
            this.utilPrint.setFiltre(this.utilPrint.getFiltre() + " Non Lus");
         } else if (this.lecture == 1) {
            this.utilPrint.setFiltre(this.utilPrint.getFiltre() + " Lus");
         }

         if (this.var_nature != null && !this.var_nature.isEmpty()) {
            this.utilPrint.setFiltre(this.utilPrint.getFiltre() + " Nature:" + this.var_nature);
         }

         String var5;
         if (this.var_structure != 0L) {
            var5 = "";

            for(int var6 = 0; var6 < this.mesStructuresItems.size(); ++var6) {
               if (Long.parseLong(((SelectItem)this.mesStructuresItems.get(var6)).getValue().toString()) == this.var_structure) {
                  var5 = ((SelectItem)this.mesStructuresItems.get(var6)).getLabel().toString();
                  break;
               }
            }

            this.utilPrint.setFiltre(this.utilPrint.getFiltre() + " Str:" + var5);
         }

         var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "liste" + File.separator + "messagerie" + File.separator;
         this.utilPrint.setCheminRapport(var5);
         this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setImageFondPage(this.calculeImageFond(this.baseLog));
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         if (this.lesMails.size() != 0) {
            Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            new Users();

            for(int var4 = 0; var4 < this.lesMails.size(); ++var4) {
               this.mails = (Mails)this.lesMails.get(var4);
               if (this.mails.getMaiUserCreation() != 0L) {
                  Users var3 = this.userDao.selectByIdUsers(this.mails.getMaiUserCreation(), var7);
                  if (var3 != null) {
                     this.mails.setNomCreateur(var3.getUsrPatronyme());
                  }
               }
            }

            this.utilInitHibernate.closeSession();
         }

         var2 = new JRBeanCollectionDataSource(this.lesMails);
         this.utilPrint.setjRBeanCollectionDataSource(var2);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public List getLesMails() {
      return this.lesMails;
   }

   public void setLesMails(List var1) {
      this.lesMails = var1;
   }

   public int getPeriode() {
      return this.periode;
   }

   public void setPeriode(int var1) {
      this.periode = var1;
   }

   public int getPriorite() {
      return this.priorite;
   }

   public void setPriorite(int var1) {
      this.priorite = var1;
   }

   public int getLecture() {
      return this.lecture;
   }

   public void setLecture(int var1) {
      this.lecture = var1;
   }

   public DataModel getDataModelLesMails() {
      return this.dataModelLesMails;
   }

   public void setDataModelLesMails(DataModel var1) {
      this.dataModelLesMails = var1;
   }

   public String getPj() {
      return this.pj;
   }

   public void setPj(String var1) {
      this.pj = var1;
   }

   public String getFiltre1() {
      return this.filtre1;
   }

   public void setFiltre1(String var1) {
      this.filtre1 = var1;
   }

   public String getFiltre2() {
      return this.filtre2;
   }

   public void setFiltre2(String var1) {
      this.filtre2 = var1;
   }

   public int getSens() {
      return this.sens;
   }

   public void setSens(int var1) {
      this.sens = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public Mails getMails() {
      return this.mails;
   }

   public void setMails(Mails var1) {
      this.mails = var1;
   }

   public DataModel getDataModelLesmailsLus() {
      return this.dataModelLesmailsLus;
   }

   public void setDataModelLesmailsLus(DataModel var1) {
      this.dataModelLesmailsLus = var1;
   }

   public DataModel getDataModelLesPJ() {
      return this.dataModelLesPJ;
   }

   public void setDataModelLesPJ(DataModel var1) {
      this.dataModelLesPJ = var1;
   }

   public MailsPj getMailsPj() {
      return this.mailsPj;
   }

   public void setMailsPj(MailsPj var1) {
      this.mailsPj = var1;
   }

   public boolean isDisableBouton() {
      return this.disableBouton;
   }

   public void setDisableBouton(boolean var1) {
      this.disableBouton = var1;
   }

   public boolean isAutreMail() {
      return this.autreMail;
   }

   public void setAutreMail(boolean var1) {
      this.autreMail = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public String getVar_emetteur() {
      return this.var_emetteur;
   }

   public void setVar_emetteur(String var1) {
      this.var_emetteur = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
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

   public DataModel getDatamodelPatients() {
      return this.datamodelPatients;
   }

   public void setDatamodelPatients(DataModel var1) {
      this.datamodelPatients = var1;
   }

   public DataModel getDatamodelTiers() {
      return this.datamodelTiers;
   }

   public void setDatamodelTiers(DataModel var1) {
      this.datamodelTiers = var1;
   }

   public Patients getPatients() {
      return this.patients;
   }

   public void setPatients(Patients var1) {
      this.patients = var1;
   }

   public boolean isShowModalPanelPatients() {
      return this.showModalPanelPatients;
   }

   public void setShowModalPanelPatients(boolean var1) {
      this.showModalPanelPatients = var1;
   }

   public boolean isShowModalPanelTiers() {
      return this.showModalPanelTiers;
   }

   public void setShowModalPanelTiers(boolean var1) {
      this.showModalPanelTiers = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public boolean isGestionPatient() {
      return this.gestionPatient;
   }

   public void setGestionPatient(boolean var1) {
      this.gestionPatient = var1;
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

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public boolean isShowModalPanelPj() {
      return this.showModalPanelPj;
   }

   public void setShowModalPanelPj(boolean var1) {
      this.showModalPanelPj = var1;
   }

   public FormTiers getFormTiers() {
      return this.formTiers;
   }

   public void setFormTiers(FormTiers var1) {
      this.formTiers = var1;
   }

   public List getMesActivitesItem() {
      return this.mesActivitesItem;
   }

   public void setMesActivitesItem(List var1) {
      this.mesActivitesItem = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public List getMesModelesItem() {
      return this.mesModelesItem;
   }

   public void setMesModelesItem(List var1) {
      this.mesModelesItem = var1;
   }

   public boolean isDisableBoutonEnregistrer() {
      return this.disableBoutonEnregistrer;
   }

   public void setDisableBoutonEnregistrer(boolean var1) {
      this.disableBoutonEnregistrer = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
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

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
   }

   public List getDocumentImpressionItems() {
      return this.documentImpressionItems;
   }

   public void setDocumentImpressionItems(List var1) {
      this.documentImpressionItems = var1;
   }

   public List getListeImpressionItems() {
      return this.listeImpressionItems;
   }

   public void setListeImpressionItems(List var1) {
      this.listeImpressionItems = var1;
   }

   public List getMailImpressionItems() {
      return this.mailImpressionItems;
   }

   public void setMailImpressionItems(List var1) {
      this.mailImpressionItems = var1;
   }

   public String getTypeDocument() {
      return this.typeDocument;
   }

   public void setTypeDocument(String var1) {
      this.typeDocument = var1;
   }

   public DataModel getDataModelContacts() {
      return this.dataModelContacts;
   }

   public void setDataModelContacts(DataModel var1) {
      this.dataModelContacts = var1;
   }

   public int getVar_currentValue() {
      return this.var_currentValue;
   }

   public void setVar_currentValue(int var1) {
      this.var_currentValue = var1;
   }

   public String getVar_infos() {
      return this.var_infos;
   }

   public void setVar_infos(String var1) {
      this.var_infos = var1;
   }

   public boolean isVar_showBarProg() {
      return this.var_showBarProg;
   }

   public void setVar_showBarProg(boolean var1) {
      this.var_showBarProg = var1;
   }

   public UtilMail getUtilMail() {
      return this.utilMail;
   }

   public void setUtilMail(UtilMail var1) {
      this.utilMail = var1;
   }

   public List getLesDestinatairesItems() {
      return this.lesDestinatairesItems;
   }

   public void setLesDestinatairesItems(List var1) {
      this.lesDestinatairesItems = var1;
   }

   public boolean isShowModalPanelAjoutFile() {
      return this.showModalPanelAjoutFile;
   }

   public void setShowModalPanelAjoutFile(boolean var1) {
      this.showModalPanelAjoutFile = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public String getNomFichier() {
      return this.nomFichier;
   }

   public void setNomFichier(String var1) {
      this.nomFichier = var1;
   }

   public boolean isViewerPdf() {
      return this.viewerPdf;
   }

   public void setViewerPdf(boolean var1) {
      this.viewerPdf = var1;
   }

   public boolean isFichier() {
      return this.fichier;
   }

   public void setFichier(boolean var1) {
      this.fichier = var1;
   }

   public boolean isMailsRejets() {
      return this.mailsRejets;
   }

   public void setMailsRejets(boolean var1) {
      this.mailsRejets = var1;
   }

   public DataModel getDataModelMailRejets() {
      return this.dataModelMailRejets;
   }

   public void setDataModelMailRejets(DataModel var1) {
      this.dataModelMailRejets = var1;
   }

   public boolean isShowModalPanelRejets() {
      return this.showModalPanelRejets;
   }

   public void setShowModalPanelRejets(boolean var1) {
      this.showModalPanelRejets = var1;
   }

   public ObjetMail getObjetMail() {
      return this.objetMail;
   }

   public void setObjetMail(ObjetMail var1) {
      this.objetMail = var1;
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

   public List getMesNaturesItem() {
      return this.mesNaturesItem;
   }

   public void setMesNaturesItem(List var1) {
      this.mesNaturesItem = var1;
   }

   public String getVar_nature() {
      return this.var_nature;
   }

   public void setVar_nature(String var1) {
      this.var_nature = var1;
   }

   public DataModel getDatamodelAgents() {
      return this.datamodelAgents;
   }

   public void setDatamodelAgents(DataModel var1) {
      this.datamodelAgents = var1;
   }

   public boolean isShowModalPanelAgents() {
      return this.showModalPanelAgents;
   }

   public void setShowModalPanelAgents(boolean var1) {
      this.showModalPanelAgents = var1;
   }

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public String getPdfFileName() {
      return this.pdfFileName;
   }

   public void setPdfFileName(String var1) {
      this.pdfFileName = var1;
   }

   public UploadedFile getUploadedPDFFile() {
      return this.uploadedPDFFile;
   }

   public void setUploadedPDFFile(UploadedFile var1) {
      this.uploadedPDFFile = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public boolean isVar_affFicPdf() {
      return this.var_affFicPdf;
   }

   public void setVar_affFicPdf(boolean var1) {
      this.var_affFicPdf = var1;
   }

   public boolean isGestionAgent() {
      return this.gestionAgent;
   }

   public void setGestionAgent(boolean var1) {
      this.gestionAgent = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public int getTypeFichier() {
      return this.typeFichier;
   }

   public void setTypeFichier(int var1) {
      this.typeFichier = var1;
   }

   public int getTypeTiers() {
      return this.typeTiers;
   }

   public void setTypeTiers(int var1) {
      this.typeTiers = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
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

   public long getVar_users() {
      return this.var_users;
   }

   public void setVar_users(long var1) {
      this.var_users = var1;
   }

   public List getMesStructuresItems() {
      return this.mesStructuresItems;
   }

   public void setMesStructuresItems(List var1) {
      this.mesStructuresItems = var1;
   }

   public boolean isModeGroupe() {
      return this.modeGroupe;
   }

   public void setModeGroupe(boolean var1) {
      this.modeGroupe = var1;
   }

   public long getVar_structure() {
      return this.var_structure;
   }

   public void setVar_structure(long var1) {
      this.var_structure = var1;
   }

   public DataModel getDataModelUsers() {
      return this.dataModelUsers;
   }

   public void setDataModelUsers(DataModel var1) {
      this.dataModelUsers = var1;
   }

   public List getMesActivitesRecItem() {
      return this.mesActivitesRecItem;
   }

   public void setMesActivitesRecItem(List var1) {
      this.mesActivitesRecItem = var1;
   }

   public List getMesServicesRecItems() {
      return this.mesServicesRecItems;
   }

   public void setMesServicesRecItems(List var1) {
      this.mesServicesRecItems = var1;
   }

   public String getVar_activite_rec() {
      return this.var_activite_rec;
   }

   public void setVar_activite_rec(String var1) {
      this.var_activite_rec = var1;
   }

   public String getVar_service_rec() {
      return this.var_service_rec;
   }

   public void setVar_service_rec(String var1) {
      this.var_service_rec = var1;
   }

   public boolean isTiersDivers() {
      return this.tiersDivers;
   }

   public void setTiersDivers(boolean var1) {
      this.tiersDivers = var1;
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

   public String getOngletVisu() {
      return this.ongletVisu;
   }

   public void setOngletVisu(String var1) {
      this.ongletVisu = var1;
   }
}
