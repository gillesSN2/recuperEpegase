package com.epegase.forms.achats;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.CessionLigne;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.SommierEnteteAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.CessionLigneDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.SommierEnteteAchatsDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionAchats;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormSommierAchats {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private List mesOnglets;
   private OptionAchats optionAchats;
   private ExercicesAchats exercicesAchats;
   private ExercicesAchats lastExoAchats;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private UtilNombre utilNombre = new UtilNombre();
   private UtilDate utilDate = new UtilDate();
   private int var_nb_max = 100;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private SommierEnteteAchats sommierEnteteAchats = new SommierEnteteAchats();
   private SommierEnteteAchatsDao sommierEnteteAchatsDao;
   private List lesEntetesList = new ArrayList();
   private transient DataModel datamodelEntete = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean visibiliteBton = false;
   private boolean visibleOngleEntete;
   private int var_nb_ligne = 0;
   private transient DataModel dataModelFusion = new ListDataModel();
   private transient DataModel dataModelDetail = new ListDataModel();
   private ReceptionLigneAchats receptionLigneAchats;
   private ReceptionLigneAchatsDao receptionLigneAchatsDao;
   private CessionLigne cessionLigne;
   private CessionLigneDao cessionLigneDao;
   private float total_qte_recu;
   private float total_qte_sortie;
   private float solde_qte;
   private String inpSerie = "100";
   private String inpService = "100";
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpDossier = "";
   private String inpActivite = "100";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private boolean verrouDate = false;
   private boolean var_acc_document = false;
   private boolean var_acc_imputation = false;
   private boolean var_acc_complement = false;
   private boolean var_acc_verification = false;
   private boolean var_acc_habilitation = false;
   private boolean var_acc_etat = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
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

   public void InstancesDaoUtilses() {
      this.sommierEnteteAchatsDao = new SommierEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.receptionLigneAchatsDao = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.cessionLigneDao = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
   }

   public void configAchats() {
      if (this.structureLog.getStrtypeentreprise() == null || this.structureLog.getStrtypeentreprise().isEmpty()) {
         this.structureLog.setStrtypeentreprise("0");
      }

      if (!this.optionAchats.getLib1().isEmpty() && !this.optionAchats.getLib2().isEmpty() && !this.optionAchats.getLib3().isEmpty() && !this.optionAchats.getLib4().isEmpty() && !this.optionAchats.getLib5().isEmpty() && !this.optionAchats.getLib6().isEmpty() && !this.optionAchats.getLib7().isEmpty() && !this.optionAchats.getLib8().isEmpty() && !this.optionAchats.getLib9().isEmpty() && !this.optionAchats.getLib10().isEmpty()) {
         this.visibleOngleEntete = false;
      } else {
         this.visibleOngleEntete = true;
      }

      if (this.optionAchats.getNbLigneMax() != null && !this.optionAchats.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionAchats.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.periode = "100";
      this.verrouDate = false;
      this.initPage();
   }

   public void accesResteintUser() {
      this.visibiliteBton = false;
   }

   public void accesResteintGroupe() {
      this.var_acc_document = false;
      this.var_acc_imputation = false;
      this.var_acc_complement = false;
      this.var_acc_verification = false;
      this.var_acc_habilitation = false;
      this.var_acc_etat = false;
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
            } else if (var1.getCode().equals("56")) {
               this.var_acc_verification = true;
            } else if (var1.getCode().equals("57")) {
               this.var_acc_habilitation = true;
            } else if (var1.getCode().equals("58")) {
               this.var_acc_etat = true;
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
            }
         }
      }

   }

   public void autorisationFrais() throws HibernateException, NamingException {
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
            }
         }
      }

   }

   public void autorisationCalcul() {
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
            if (var1.getCode().equals("57")) {
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
            if (var1.getCode().equals("58")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void initPage() {
      this.var_action = 0;
      this.inpSerie = "100";
      this.inpService = "100";
      this.inpEtat = 0;
      this.lesEntetesList.clear();
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
         this.inpDossier = "";
         this.inpActivite = "100";
      }

   }

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException {
      this.chargeListeDetail((Session)null);
   }

   public void chargeListeDetail(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesEntetesList.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.var_nb_ligne = 0;
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

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      if (this.inpEtat != 50) {
         this.lesEntetesList = this.sommierEnteteAchatsDao.recherche(var1, this.exercicesAchats.getExeachId(), this.inpNum, this.periode, this.usersLog.getUsrid(), this.usersLog.getUsrAchats(), this.inpDossier, var2, var3);
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete = new ListDataModel();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new SommierEnteteAchats();

         for(int var5 = 0; var5 < this.lesEntetesList.size(); ++var5) {
            SommierEnteteAchats var4 = (SommierEnteteAchats)this.lesEntetesList.get(var5);
         }

         this.var_nb_ligne = this.lesEntetesList.size();
      }

      this.visibiliteBton = false;
   }

   public void selectionLigne() throws JDOMException, IOException, HibernateException, NamingException {
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
            this.sommierEnteteAchats = (SommierEnteteAchats)var1.get(0);
            this.var_date = this.sommierEnteteAchats.getSomDate();
            if (this.sommierEnteteAchats.getSomDate().getHours() <= 9) {
               this.var_heure = "0" + this.sommierEnteteAchats.getSomDate().getHours();
            } else {
               this.var_heure = "" + this.sommierEnteteAchats.getSomDate().getHours();
            }

            if (this.sommierEnteteAchats.getSomDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.sommierEnteteAchats.getSomDate().getMinutes();
            } else {
               this.var_minute = "" + this.sommierEnteteAchats.getSomDate().getMinutes();
            }

            if (this.sommierEnteteAchats.getSomDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.sommierEnteteAchats.getSomDate().getSeconds();
            } else {
               this.var_seconde = "" + this.sommierEnteteAchats.getSomDate().getSeconds();
            }

            this.format = "PDF";
            this.var_choix_modele = 0;
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.sommierEnteteAchats != null) {
         this.consultDocument();
      }

   }

   public void consultDocument() throws NamingException {
      this.total_qte_recu = 0.0F;
      new ArrayList();
      String var2 = "recligSommier='" + this.sommierEnteteAchats.getSomNum() + "' and receptionEnteteAchats.recNum='" + this.sommierEnteteAchats.getSomReception() + "'";
      List var1 = this.receptionLigneAchatsDao.rechercheReceptionRequete(var2, (Session)null);
      this.total_qte_sortie = 0.0F;
      new ArrayList();
      String var4 = "cesligSommier='" + this.sommierEnteteAchats.getSomNum() + "'";
      List var3 = this.cessionLigneDao.rechercheCessionRequete(var4, (Session)null);
      this.solde_qte = 0.0F;
      ArrayList var5 = new ArrayList();
      if (var1.size() != 0 || var3.size() != 0) {
         int var6;
         if (var1.size() != 0) {
            for(var6 = 0; var6 < var1.size(); ++var6) {
               this.receptionLigneAchats = (ReceptionLigneAchats)var1.get(var6);
               this.receptionLigneAchats.setType_doc("Entrée");
            }
         }

         if (var3.size() != 0) {
            for(var6 = 0; var6 < var3.size(); ++var6) {
               this.cessionLigne = (CessionLigne)var3.get(var6);
               this.receptionLigneAchats = new ReceptionLigneAchats();
               this.receptionLigneAchats.setRecligDepot(this.cessionLigne.getCesligDepotOrigine());
               this.receptionLigneAchats.setRecligCode(this.cessionLigne.getCesligCode());
               this.receptionLigneAchats.setRecligLibelle(this.cessionLigne.getCesligLibelle());
               this.receptionLigneAchats.setType_doc("Sortie");
               this.receptionLigneAchats.setDate_cession(this.cessionLigne.getCessionEntete().getCesDate());
               this.receptionLigneAchats.setNum_cession(this.cessionLigne.getCessionEntete().getCesNum());
               this.receptionLigneAchats.setQte_cession(this.cessionLigne.getCesligQteUtil());
               this.receptionLigneAchats.setStk_cession(this.cessionLigne.getCesligStock());
               var1.add(this.receptionLigneAchats);
            }
         }

         this.dataModelDetail.setWrappedData(var1);
         if (var1.size() != 0) {
            for(var6 = 0; var6 < var1.size(); ++var6) {
               this.receptionLigneAchats = (ReceptionLigneAchats)var1.get(var6);
               this.receptionLigneAchats.setType_doc("Entrée");
               this.receptionLigneAchats.setQte_cession(0.0F);
               var5.add(this.receptionLigneAchats);
            }
         }

         if (var3.size() != 0) {
            for(var6 = 0; var6 < var3.size(); ++var6) {
               this.cessionLigne = (CessionLigne)var3.get(var6);
               if (var1.size() == 0) {
                  this.receptionLigneAchats = new ReceptionLigneAchats();
                  this.receptionLigneAchats.setRecligDepot(this.cessionLigne.getCesligDepotOrigine());
                  this.receptionLigneAchats.setRecligCode(this.cessionLigne.getCesligCode());
                  this.receptionLigneAchats.setRecligLibelle(this.cessionLigne.getCesligLibelle());
                  this.receptionLigneAchats.setType_doc("Sortie");
                  this.receptionLigneAchats.setDate_cession(this.cessionLigne.getCessionEntete().getCesDate());
                  this.receptionLigneAchats.setNum_cession(this.cessionLigne.getCessionEntete().getCesNum());
                  this.receptionLigneAchats.setQte_cession(this.cessionLigne.getCesligQteUtil());
                  this.receptionLigneAchats.setStk_cession(this.cessionLigne.getCesligStock());
                  var5.add(this.receptionLigneAchats);
               } else {
                  boolean var7 = false;

                  for(int var8 = 0; var8 < var1.size(); ++var8) {
                     this.receptionLigneAchats = (ReceptionLigneAchats)var1.get(var8);
                     if (this.receptionLigneAchats.getRecligCode().equals(this.cessionLigne.getCesligCode())) {
                        this.receptionLigneAchats.setQte_cession(this.receptionLigneAchats.getQte_cession() + this.cessionLigne.getCesligQteUtil());
                        var7 = true;
                        break;
                     }
                  }

                  if (!var7) {
                     this.receptionLigneAchats = new ReceptionLigneAchats();
                     this.receptionLigneAchats.setRecligDepot(this.cessionLigne.getCesligDepotOrigine());
                     this.receptionLigneAchats.setRecligCode(this.cessionLigne.getCesligCode());
                     this.receptionLigneAchats.setRecligLibelle(this.cessionLigne.getCesligLibelle());
                     this.receptionLigneAchats.setType_doc("Sortie");
                     this.receptionLigneAchats.setDate_cession(this.cessionLigne.getCessionEntete().getCesDate());
                     this.receptionLigneAchats.setNum_cession(this.cessionLigne.getCessionEntete().getCesNum());
                     this.receptionLigneAchats.setQte_cession(this.cessionLigne.getCesligQteUtil());
                     this.receptionLigneAchats.setStk_cession(this.cessionLigne.getCesligStock());
                     var5.add(this.receptionLigneAchats);
                  }
               }
            }
         }

         if (var5.size() != 0) {
            for(var6 = 0; var6 < var5.size(); ++var6) {
               this.receptionLigneAchats = (ReceptionLigneAchats)var5.get(var6);
               this.total_qte_recu += this.receptionLigneAchats.getRecligQteUtil();
               this.total_qte_sortie += this.receptionLigneAchats.getQte_cession();
               this.receptionLigneAchats.setQte_solde(this.receptionLigneAchats.getRecligQteUtil() - this.receptionLigneAchats.getQte_cession());
            }
         }

         this.dataModelFusion.setWrappedData(var5);
         this.solde_qte = this.total_qte_recu - this.total_qte_sortie;
         this.var_action = 1;
      }

   }

   public void fermerDetail() {
      this.var_action = 0;
   }

   public void ouvertureLot() {
   }

   public void ouvertureSerie() {
   }

   public void ouvertureLotCession() {
   }

   public void ouvertureSerieCession() {
   }

   public void initImpression() {
      this.var_choix_modele = 0;
      this.showModalPanelPrint = false;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
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

   public int getVar_memo_action() {
      return this.var_memo_action;
   }

   public void setVar_memo_action(int var1) {
      this.var_memo_action = var1;
   }

   public String getVar_minute() {
      return this.var_minute;
   }

   public void setVar_minute(String var1) {
      this.var_minute = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public String getVar_seconde() {
      return this.var_seconde;
   }

   public void setVar_seconde(String var1) {
      this.var_seconde = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public ExercicesAchats getLastExoAchats() {
      return this.lastExoAchats;
   }

   public void setLastExoAchats(ExercicesAchats var1) {
      this.lastExoAchats = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
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

   public boolean isVar_acc_etat() {
      return this.var_acc_etat;
   }

   public void setVar_acc_etat(boolean var1) {
      this.var_acc_etat = var1;
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

   public boolean isVar_acc_verification() {
      return this.var_acc_verification;
   }

   public void setVar_acc_verification(boolean var1) {
      this.var_acc_verification = var1;
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

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }

   public boolean isVar_sup() {
      return this.var_sup;
   }

   public void setVar_sup(boolean var1) {
      this.var_sup = var1;
   }

   public boolean isVerrouDate() {
      return this.verrouDate;
   }

   public void setVerrouDate(boolean var1) {
      this.verrouDate = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public boolean isVisibleOngleEntete() {
      return this.visibleOngleEntete;
   }

   public void setVisibleOngleEntete(boolean var1) {
      this.visibleOngleEntete = var1;
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

   public DataModel getDatamodelEntete() {
      return this.datamodelEntete;
   }

   public void setDatamodelEntete(DataModel var1) {
      this.datamodelEntete = var1;
   }

   public String getFiltre() {
      return this.filtre;
   }

   public void setFiltre(String var1) {
      this.filtre = var1;
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
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

   public String getInpActivite() {
      return this.inpActivite;
   }

   public void setInpActivite(String var1) {
      this.inpActivite = var1;
   }

   public Date getInpAu() {
      return this.inpAu;
   }

   public void setInpAu(Date var1) {
      this.inpAu = var1;
   }

   public String getInpDossier() {
      return this.inpDossier;
   }

   public void setInpDossier(String var1) {
      this.inpDossier = var1;
   }

   public Date getInpDu() {
      return this.inpDu;
   }

   public void setInpDu(Date var1) {
      this.inpDu = var1;
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

   public String getInpSerie() {
      return this.inpSerie;
   }

   public void setInpSerie(String var1) {
      this.inpSerie = var1;
   }

   public String getInpService() {
      return this.inpService;
   }

   public void setInpService(String var1) {
      this.inpService = var1;
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

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public String getRequete() {
      return this.requete;
   }

   public void setRequete(String var1) {
      this.requete = var1;
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

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
   }

   public DataModel getDataModelDetail() {
      return this.dataModelDetail;
   }

   public void setDataModelDetail(DataModel var1) {
      this.dataModelDetail = var1;
   }

   public SommierEnteteAchats getSommierEnteteAchats() {
      return this.sommierEnteteAchats;
   }

   public void setSommierEnteteAchats(SommierEnteteAchats var1) {
      this.sommierEnteteAchats = var1;
   }

   public DataModel getDataModelFusion() {
      return this.dataModelFusion;
   }

   public void setDataModelFusion(DataModel var1) {
      this.dataModelFusion = var1;
   }

   public float getSolde_qte() {
      return this.solde_qte;
   }

   public void setSolde_qte(float var1) {
      this.solde_qte = var1;
   }

   public float getTotal_qte_recu() {
      return this.total_qte_recu;
   }

   public void setTotal_qte_recu(float var1) {
      this.total_qte_recu = var1;
   }

   public float getTotal_qte_sortie() {
      return this.total_qte_sortie;
   }

   public void setTotal_qte_sortie(float var1) {
      this.total_qte_sortie = var1;
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
}
