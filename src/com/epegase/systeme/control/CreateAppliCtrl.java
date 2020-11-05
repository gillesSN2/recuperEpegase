package com.epegase.systeme.control;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.StructurePot;
import com.epegase.systeme.classe.UsersPeg;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilMail;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.LectureFormesJuridiques;
import com.epegase.systeme.xml.LectureLangues;
import com.epegase.systeme.xml.LecturePays;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UISelectOne;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.jdom.JDOMException;

public class CreateAppliCtrl implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private StructurePeg newStructure = new StructurePeg();
   private StructurePot structurePot = new StructurePot();
   private StructureDao sDao;
   private UsersPeg newUsers = new UsersPeg();
   private UserDao uDao;
   private String msage;
   private String laBase;
   private HtmlOutputText alerteMessage;
   private Module module;
   private UtilMail envoimail;
   private String existe;
   private UISelectOne selectOneMenu;
   private List mesPaysItems;
   private List mesDevisesItems;
   private List mesLanguesItems;
   private List mesFormesJuridiquesItems;
   private List mesFonctionsItems = new ArrayList();
   private String motPasse;
   private String codeSecret;
   private boolean checkboxPaye = false;
   private boolean checkboxAchats = false;
   private boolean checkboxParc = false;
   private boolean checkboxCaisse = false;
   private int choixCompta = 0;
   private int choixCommercial = 0;
   private List modulesSelect = new ArrayList();
   private List lesScreenShotCompta = new ArrayList();
   private List lesScreenShotPaye = new ArrayList();
   private List lesScreenShotAchats = new ArrayList();
   private List lesScreenShotVentes = new ArrayList();
   private List lesScreenShotStocks = new ArrayList();
   private List lesScreenShotTresorerie = new ArrayList();
   private List lesScreenShotImmobilier = new ArrayList();
   private List lesScreenShotParc = new ArrayList();
   private List lesScreenShotMedical = new ArrayList();
   private boolean validerDemande = false;
   private boolean autoReponse = false;

   public CreateAppliCtrl() throws UnknownHostException, IOException, JDOMException {
      this.mesFonctionsItems.add(new SelectItem(""));
      this.mesPaysItems = new ArrayList();
      this.mesPaysItems.add(new SelectItem(""));
      this.mesDevisesItems = new ArrayList();
      this.mesDevisesItems.add(new SelectItem(""));
      this.mesLanguesItems = new ArrayList();
      this.mesLanguesItems.add(new SelectItem(""));
      this.mesFormesJuridiquesItems = new ArrayList();
      this.mesFormesJuridiquesItems.add(new SelectItem(""));
   }

   public String CreerDemande() throws Exception {
      String var1 = "";
      var1 = "<html><head></head><body ><h:form>";
      var1 = var1 + "<table style=\"border:1px dotted green\" align=\"center\" width=\"60%\">";
      var1 = var1 + "<thead><tr><th><h1>Bienvenue sur e-P&eacute;gase!</h1></th></tr></thead>";
      var1 = var1 + "<tbody><tr><td>Bonjour<br/>Nouvelle demande d'accès: ";
      var1 = var1 + "<h2>Rappel:</h2><pstyle=\"background-color:green;color:white;font-weight:bold;width:100%\"><center>Informations sur la soci&eacute;t&eacute;</center></p>";
      var1 = var1 + "Raison sociale : &nbsp; " + this.newStructure.getStrraisonsociale() + "<br/>";
      var1 = var1 + "<br/>Pays:&nbsp; " + this.newStructure.getStrnompays();
      var1 = var1 + " sur le compte</center></p><br/>";
      var1 = var1 + "Pr&eacute;nom :&nbsp; " + this.newUsers.getUsrprenom() + "<br/>";
      var1 = var1 + "Nom :&nbsp; " + this.newUsers.getUsrnom() + "<br/>";
      var1 = var1 + "Email :&nbsp; " + this.newUsers.getUsrmail() + "<br/>";
      var1 = var1 + "Fonction :&nbsp; " + this.newUsers.getUsrfonction() + "<br/><br/>";
      var1 = var1 + "<h:outputText value=\"#{modules}\" /></h:outputText><br/>";
      var1 = var1 + "</h:column></h:dataTable>";
      var1 = var1 + "<i style=\"color:red;font-size:11px;\">Ce message vous est ";
      var1 = var1 + "envoy&eacute; automatiquement.</i></td></tr><tr><td></td></tr></tbody></table>";
      var1 = var1 + "</h:form></body></html>";
      this.envoimail = new UtilMail((Structure)null);
      this.envoimail.mailInscription(var1, "gillesdecruzel@gmail.com", "NOUVEL ACCES E-PEGASE");
      return "demande";
   }

   public void screenshot() {
      this.lesScreenShotCompta.clear();
      this.lesScreenShotCompta.add("images/screenshot/compta1.jpg");
      this.lesScreenShotCompta.add("images/screenshot/compta2.jpg");
      this.lesScreenShotCompta.add("images/screenshot/compta3.jpg");
      this.lesScreenShotCompta.add("images/screenshot/compta4.jpg");
      this.lesScreenShotCompta.add("images/screenshot/compta5.jpg");
      this.lesScreenShotCompta.add("images/screenshot/compta6.jpg");
      this.lesScreenShotPaye.clear();
      this.lesScreenShotPaye.add("images/screenshot/paye1.jpg");
      this.lesScreenShotPaye.add("images/screenshot/paye2.jpg");
      this.lesScreenShotPaye.add("images/screenshot/paye3.jpg");
      this.lesScreenShotPaye.add("images/screenshot/paye4.jpg");
      this.lesScreenShotPaye.add("images/screenshot/paye5.jpg");
      this.lesScreenShotPaye.add("images/screenshot/paye6.jpg");
      this.lesScreenShotAchats.clear();
      this.lesScreenShotAchats.add("images/screenshot/achats1.jpg");
      this.lesScreenShotAchats.add("images/screenshot/achats2.jpg");
      this.lesScreenShotAchats.add("images/screenshot/achats3.jpg");
      this.lesScreenShotAchats.add("images/screenshot/achats4.jpg");
      this.lesScreenShotAchats.add("images/screenshot/achats5.jpg");
      this.lesScreenShotAchats.add("images/screenshot/achats6.jpg");
      this.lesScreenShotVentes.clear();
      this.lesScreenShotVentes.add("images/screenshot/ventes1.jpg");
      this.lesScreenShotVentes.add("images/screenshot/ventes2.jpg");
      this.lesScreenShotVentes.add("images/screenshot/ventes3.jpg");
      this.lesScreenShotVentes.add("images/screenshot/ventes4.jpg");
      this.lesScreenShotVentes.add("images/screenshot/ventes5.jpg");
      this.lesScreenShotVentes.add("images/screenshot/ventes6.jpg");
      this.lesScreenShotStocks.clear();
      this.lesScreenShotStocks.add("images/screenshot/stocks1.jpg");
      this.lesScreenShotStocks.add("images/screenshot/stocks2.jpg");
      this.lesScreenShotStocks.add("images/screenshot/stocks3.jpg");
      this.lesScreenShotStocks.add("images/screenshot/stocks4.jpg");
      this.lesScreenShotStocks.add("images/screenshot/stocks5.jpg");
      this.lesScreenShotStocks.add("images/screenshot/stocks6.jpg");
      this.lesScreenShotImmobilier.clear();
      this.lesScreenShotImmobilier.add("images/screenshot/immobilier1.jpg");
      this.lesScreenShotImmobilier.add("images/screenshot/immobilier2.jpg");
      this.lesScreenShotImmobilier.add("images/screenshot/immobilier3.jpg");
      this.lesScreenShotImmobilier.add("images/screenshot/immobilier4.jpg");
      this.lesScreenShotImmobilier.add("images/screenshot/immobilier5.jpg");
      this.lesScreenShotImmobilier.add("images/screenshot/immobilier6.jpg");
      this.lesScreenShotTresorerie.clear();
      this.lesScreenShotTresorerie.add("images/screenshot/tresorerie1.jpg");
      this.lesScreenShotTresorerie.add("images/screenshot/tresorerie2.jpg");
      this.lesScreenShotTresorerie.add("images/screenshot/tresorerie3.jpg");
      this.lesScreenShotTresorerie.add("images/screenshot/tresorerie4.jpg");
      this.lesScreenShotTresorerie.add("images/screenshot/tresorerie5.jpg");
      this.lesScreenShotTresorerie.add("images/screenshot/tresorerie6.jpg");
      this.lesScreenShotParc.clear();
      this.lesScreenShotParc.add("images/screenshot/parc1.jpg");
      this.lesScreenShotParc.add("images/screenshot/parc2.jpg");
      this.lesScreenShotParc.add("images/screenshot/parc3.jpg");
      this.lesScreenShotParc.add("images/screenshot/parc4.jpg");
      this.lesScreenShotMedical.clear();
      this.lesScreenShotMedical.add("images/screenshot/medical1.jpg");
      this.lesScreenShotMedical.add("images/screenshot/medical2.jpg");
      this.lesScreenShotMedical.add("images/screenshot/medical3.jpg");
      this.lesScreenShotMedical.add("images/screenshot/medical4.jpg");
   }

   public void nouvelleProspection() throws HibernateException, NamingException, UnknownHostException, MalformedURLException, IOException, InstantiationException, IllegalAccessException {
      this.validerDemande = false;
      LecturePays var1 = new LecturePays();
      this.mesPaysItems = var1.getMesPaysItems();
      LectureDevises var2 = new LectureDevises();
      this.mesDevisesItems = var2.getMesDevisesItems();
      LectureLangues var3 = new LectureLangues();
      this.mesLanguesItems = var3.getMesLanguesItems();
      LectureFormesJuridiques var4 = new LectureFormesJuridiques();
      this.mesFormesJuridiquesItems = var4.getMesFormesJuridiquesItems();
      this.structurePot = new StructurePot();
      this.structurePot.setStrnompays("FRANCE");
      this.structurePot.setStrcodepays("0076");
      this.structurePot.setStrdevise("EUR");
      this.structurePot.setStrformejuridique("SARL");
      this.structurePot.setStrurl("");
   }

   public void verifDemande() {
      if (this.structurePot.getStrmail() != null && !this.structurePot.getStrmail().isEmpty() && this.structurePot.getStrmail().contains("@") && this.structurePot.getStrcontact() != null && !this.structurePot.getStrcontact().isEmpty()) {
         this.validerDemande = true;
      } else {
         this.validerDemande = false;
      }

   }

   public Long calculeIp(String var1) {
      long var2 = 0L;
      String var4 = var1.replace(".", "/");
      String[] var5 = var4.split("/");
      int var6 = Integer.parseInt(var5[0]) * 16777216;
      int var7 = Integer.parseInt(var5[1]) * 65536;
      int var8 = Integer.parseInt(var5[2]) * 256;
      int var9 = Integer.parseInt(var5[3]);
      var2 = (long)(var6 + var7 + var8 + var9);
      return var2;
   }

   public void envoieProspection() throws HibernateException, NamingException, Exception {
      this.utilInitHibernate = new UtilInitHibernate();
      StructureDao var1 = new StructureDao(this.utilInitHibernate);
      this.structurePot = var1.insertPot(this.structurePot);
      String var2 = "";
      var2 = "<html><head></head><body ><h:form>";
      var2 = var2 + "<table style=\"border:1px dotted green\" align=\"center\" width=\"60%\">";
      var2 = var2 + "<thead><tr><th><h1>Bienvenue sur e-P&eacute;gase!</h1></th></tr></thead>";
      var2 = var2 + "<tbody><tr><td>Bonjour<br/>Vous êtes interess&eacute;s par e-P&eacute;gase et nous vous en remercions.";
      var2 = var2 + "<h2>Informations sur votre soci&eacute;t&eacute;:</h2><pstyle=\"background-color:green;color:white;font-weight:bold;width:100%\">";
      if (this.structurePot.getStrraisonsociale() != null && !this.structurePot.getStrraisonsociale().isEmpty()) {
         var2 = var2 + "Raison sociale : &nbsp; " + this.structurePot.getStrraisonsociale() + "<br/>";
      }

      if (this.structurePot.getStrnompays() != null && !this.structurePot.getStrnompays().isEmpty()) {
         var2 = var2 + "<br/>Pays:&nbsp; " + this.structurePot.getStrnompays();
      }

      var2 = var2 + "Civilit&eacute; :&nbsp; " + this.structurePot.getStrcivilite() + "<br/>";
      var2 = var2 + "Nom :&nbsp; " + this.structurePot.getStrcontact() + "<br/>";
      var2 = var2 + "Email :&nbsp; " + this.structurePot.getStrmail() + "<br/>";
      if (this.structurePot.getStrfonction() != null && !this.structurePot.getStrfonction().isEmpty()) {
         var2 = var2 + "Fonction :&nbsp; " + this.structurePot.getStrfonction() + "<br/><br/>";
      } else {
         var2 = var2 + "<br/><br/>";
      }

      var2 = var2 + "<h2>Vos centres d'interets:</h2><pstyle=\"background-color:green;color:white;font-weight:bold;width:100%\">";
      if (this.structurePot.isStrmod1()) {
         var2 = var2 + "Module de la Comptabilit&eacute;<br/>";
      }

      if (this.structurePot.isStrmod2()) {
         var2 = var2 + "Module de la Paye<br/>";
      }

      if (this.structurePot.isStrmod3()) {
         var2 = var2 + "Module des Achats<br/>";
      }

      if (this.structurePot.isStrmod4()) {
         var2 = var2 + "Module des Ventes<br/>";
      }

      if (this.structurePot.isStrmod5()) {
         var2 = var2 + "Module des Stocks<br/>";
      }

      if (this.structurePot.isStrmod6()) {
         var2 = var2 + "Module Immobilier<br/>";
      }

      if (this.structurePot.isStrmod7()) {
         var2 = var2 + "Module de la tr&eacute;sorerie<br/>";
      }

      if (this.structurePot.isStrmod8()) {
         var2 = var2 + "Module du Parc<br/>";
      }

      if (this.structurePot.isStrmod9()) {
         var2 = var2 + "Module M&eacute;dical<br/>";
      }

      if (this.structurePot.getStrobservations() != null && !this.structurePot.getStrobservations().isEmpty()) {
         var2 = var2 + "Observations :&nbsp; " + this.structurePot.getStrobservations() + " <br/>";
      }

      var2 = var2 + "<br/>Nous allons traiter votre demande dans les meilleurs d&eacute;lais et vous remercions de votre confiance.<br/><br/>";
      var2 = var2 + "<i style=\"color:red;font-size:11px;\">Ce message vous est ";
      var2 = var2 + "envoy&eacute; automatiquement.</i></td></tr><tr><td></td></tr></tbody></table>";
      var2 = var2 + "</h:form></body></html>";
      this.envoimail = new UtilMail((Structure)null);
      if (this.structurePot.getStrnompays() != null && !this.structurePot.getStrnompays().isEmpty() && this.structurePot.getStrnompays().equals("MALI")) {
         this.envoimail.mailDemandeInformation(var2, "info@horus-solutions.net", "gillesdecruzel@gmail.com", "DEMANDE INFORMATONS E-PEGASE");
      } else {
         this.envoimail.mailInscription(var2, "gillesdecruzel@gmail.com", "DEMANDE INFORMATONS E-PEGASE");
      }

      var2 = "";
      var2 = "<html><head></head><body ><h:form>";
      var2 = var2 + "<table style=\"border:1px dotted green\" align=\"center\" width=\"60%\">";
      var2 = var2 + "<thead><tr><th><h1>Bienvenue sur e-P&eacute;gase!</h1></th></tr></thead>";
      var2 = var2 + "<tbody><tr><td>Bonjour<br/>Vous êtes interess&eacute;s par e-P&eacute;gase et nous vous en remercions.";
      var2 = var2 + "<h2>Informations sur votre soci&eacute;t&eacute;:</h2><pstyle=\"background-color:green;color:white;font-weight:bold;width:100%\">";
      if (this.structurePot.getStrraisonsociale() != null && !this.structurePot.getStrraisonsociale().isEmpty()) {
         var2 = var2 + "Raison sociale : &nbsp; " + this.structurePot.getStrraisonsociale() + "<br/>";
      }

      if (this.structurePot.getStrnompays() != null && !this.structurePot.getStrnompays().isEmpty()) {
         var2 = var2 + "<br/>Pays:&nbsp; " + this.structurePot.getStrnompays();
      }

      var2 = var2 + "Civilit&eacute; :&nbsp; " + this.structurePot.getStrcivilite() + "<br/>";
      var2 = var2 + "Nom :&nbsp; " + this.structurePot.getStrcontact() + "<br/>";
      var2 = var2 + "Email :&nbsp; " + this.structurePot.getStrmail() + "<br/>";
      if (this.structurePot.getStrfonction() != null && !this.structurePot.getStrfonction().isEmpty()) {
         var2 = var2 + "Fonction :&nbsp; " + this.structurePot.getStrfonction() + "<br/><br/>";
      } else {
         var2 = var2 + "<br/><br/>";
      }

      var2 = var2 + "<h2>Vos centres d'interets:</h2><pstyle=\"background-color:green;color:white;font-weight:bold;width:100%\">";
      if (this.structurePot.isStrmod1()) {
         var2 = var2 + "Module de la Comptabilit&eacute;<br/>";
      }

      if (this.structurePot.isStrmod2()) {
         var2 = var2 + "Module de la Paye<br/>";
      }

      if (this.structurePot.isStrmod3()) {
         var2 = var2 + "Module des Achats<br/>";
      }

      if (this.structurePot.isStrmod4()) {
         var2 = var2 + "Module des Ventes<br/>";
      }

      if (this.structurePot.isStrmod5()) {
         var2 = var2 + "Module des Stocks<br/>";
      }

      if (this.structurePot.isStrmod6()) {
         var2 = var2 + "Module Immobilier<br/>";
      }

      if (this.structurePot.isStrmod7()) {
         var2 = var2 + "Module de la tr&eacute;sorerie<br/>";
      }

      if (this.structurePot.isStrmod8()) {
         var2 = var2 + "Module du Parc<br/>";
      }

      if (this.structurePot.isStrmod9()) {
         var2 = var2 + "Module M&eacute;dical<br/>";
      }

      if (this.structurePot.getStrobservations() != null && !this.structurePot.getStrobservations().isEmpty()) {
         var2 = var2 + "Observations :&nbsp; " + this.structurePot.getStrobservations() + " <br/>";
      }

      var2 = var2 + "<br/>Nous allons traiter votre demande dans les meilleurs d&eacute;lais et vous remercions de votre confiance.<br/><br/>";
      var2 = var2 + "<i style=\"color:red;font-size:11px;\">Ce message vous est ";
      var2 = var2 + "envoy&eacute; automatiquement.</i></td></tr><tr><td></td></tr></tbody></table>";
      var2 = var2 + "</h:form></body></html>";
      this.envoimail = new UtilMail((Structure)null);
      this.envoimail.mailInscription(var2, this.structurePot.getStrmail(), "DEMANDE INFORMATONS E-PEGASE");
      this.structurePot = new StructurePot();
      this.validerDemande = false;
      this.autoReponse = true;
   }

   public void fermerAutoReponse() {
      this.autoReponse = false;
   }

   public String precedent() {
      return "precedent";
   }

   public Module getModule() {
      return this.module;
   }

   public void setModule(Module var1) {
      this.module = var1;
   }

   public UtilMail getEnvoimail() {
      return this.envoimail;
   }

   public void setEnvoimail(UtilMail var1) {
      this.envoimail = var1;
   }

   public UsersPeg getNewUsers() {
      return this.newUsers;
   }

   public void setNewUsers(UsersPeg var1) {
      this.newUsers = var1;
   }

   public StructurePeg getNewStructure() {
      return this.newStructure;
   }

   public void setNewStructure(StructurePeg var1) {
      this.newStructure = var1;
   }

   public String getExiste() {
      return this.existe;
   }

   public void setExiste(String var1) {
      this.existe = var1;
   }

   public String getMsage() {
      return this.msage;
   }

   public void setMsage(String var1) {
      this.msage = var1;
   }

   public HtmlOutputText getAlerteMessage() {
      return this.alerteMessage;
   }

   public void setAlerteMessage(HtmlOutputText var1) {
      this.alerteMessage = var1;
   }

   public UISelectOne getSelectOneMenu() {
      return this.selectOneMenu;
   }

   public void setSelectOneMenu(UISelectOne var1) {
      this.selectOneMenu = var1;
   }

   public String getLaBase() {
      return this.laBase;
   }

   public void setLaBase(String var1) {
      this.laBase = var1;
   }

   public boolean isCheckboxAchats() {
      return this.checkboxAchats;
   }

   public void setCheckboxAchats(boolean var1) {
      this.checkboxAchats = var1;
   }

   public boolean isCheckboxCaisse() {
      return this.checkboxCaisse;
   }

   public void setCheckboxCaisse(boolean var1) {
      this.checkboxCaisse = var1;
   }

   public boolean isCheckboxParc() {
      return this.checkboxParc;
   }

   public void setCheckboxParc(boolean var1) {
      this.checkboxParc = var1;
   }

   public boolean isCheckboxPaye() {
      return this.checkboxPaye;
   }

   public void setCheckboxPaye(boolean var1) {
      this.checkboxPaye = var1;
   }

   public int getChoixCommercial() {
      return this.choixCommercial;
   }

   public void setChoixCommercial(int var1) {
      this.choixCommercial = var1;
   }

   public int getChoixCompta() {
      return this.choixCompta;
   }

   public void setChoixCompta(int var1) {
      this.choixCompta = var1;
   }

   public List getModulesSelect() {
      return this.modulesSelect;
   }

   public void setModulesSelect(List var1) {
      this.modulesSelect = var1;
   }

   public UtilInitHibernate getutilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setutilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public StructurePot getStructurePot() {
      return this.structurePot;
   }

   public void setStructurePot(StructurePot var1) {
      this.structurePot = var1;
   }

   public boolean isValiderDemande() {
      return this.validerDemande;
   }

   public void setValiderDemande(boolean var1) {
      this.validerDemande = var1;
   }

   public List getMesDevisesItems() {
      return this.mesDevisesItems;
   }

   public void setMesDevisesItems(List var1) {
      this.mesDevisesItems = var1;
   }

   public List getMesFonctionsItems() {
      return this.mesFonctionsItems;
   }

   public void setMesFonctionsItems(List var1) {
      this.mesFonctionsItems = var1;
   }

   public List getMesFormesJuridiquesItems() {
      return this.mesFormesJuridiquesItems;
   }

   public void setMesFormesJuridiquesItems(List var1) {
      this.mesFormesJuridiquesItems = var1;
   }

   public List getMesLanguesItems() {
      return this.mesLanguesItems;
   }

   public void setMesLanguesItems(List var1) {
      this.mesLanguesItems = var1;
   }

   public List getMesPaysItems() {
      return this.mesPaysItems;
   }

   public void setMesPaysItems(List var1) {
      this.mesPaysItems = var1;
   }

   public boolean isAutoReponse() {
      return this.autoReponse;
   }

   public void setAutoReponse(boolean var1) {
      this.autoReponse = var1;
   }

   public List getLesScreenShotAchats() {
      return this.lesScreenShotAchats;
   }

   public void setLesScreenShotAchats(List var1) {
      this.lesScreenShotAchats = var1;
   }

   public List getLesScreenShotCompta() {
      return this.lesScreenShotCompta;
   }

   public void setLesScreenShotCompta(List var1) {
      this.lesScreenShotCompta = var1;
   }

   public List getLesScreenShotImmobilier() {
      return this.lesScreenShotImmobilier;
   }

   public void setLesScreenShotImmobilier(List var1) {
      this.lesScreenShotImmobilier = var1;
   }

   public List getLesScreenShotMedical() {
      return this.lesScreenShotMedical;
   }

   public void setLesScreenShotMedical(List var1) {
      this.lesScreenShotMedical = var1;
   }

   public List getLesScreenShotParc() {
      return this.lesScreenShotParc;
   }

   public void setLesScreenShotParc(List var1) {
      this.lesScreenShotParc = var1;
   }

   public List getLesScreenShotPaye() {
      return this.lesScreenShotPaye;
   }

   public void setLesScreenShotPaye(List var1) {
      this.lesScreenShotPaye = var1;
   }

   public List getLesScreenShotStocks() {
      return this.lesScreenShotStocks;
   }

   public void setLesScreenShotStocks(List var1) {
      this.lesScreenShotStocks = var1;
   }

   public List getLesScreenShotTresorerie() {
      return this.lesScreenShotTresorerie;
   }

   public void setLesScreenShotTresorerie(List var1) {
      this.lesScreenShotTresorerie = var1;
   }

   public List getLesScreenShotVentes() {
      return this.lesScreenShotVentes;
   }

   public void setLesScreenShotVentes(List var1) {
      this.lesScreenShotVentes = var1;
   }
}
