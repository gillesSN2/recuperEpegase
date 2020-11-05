package com.epegase.forms.accueil;

import com.epegase.systeme.classe.Bal;
import com.epegase.systeme.classe.PegTicket;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersPeg;
import com.epegase.systeme.dao.BalDao;
import com.epegase.systeme.dao.PegTicketDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilMail;
import com.epegase.systeme.util.UtilPrint;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormHelpDesk {
   private int typeVente;
   private int var_action;
   private UtilInitHibernate utilInitHibernate;
   private Structure structureLog;
   private Users usersLog;
   private String baseLog;
   private String pageIndex;
   private Bal bal = new Bal();
   private BalDao balDao;
   private UserDao userDao;
   private UsersPeg usersPeg = new UsersPeg();
   private transient DataModel dataModelPegTicket = new ListDataModel();
   private List lesPegTickets = new ArrayList();
   private PegTicket pegTicket = new PegTicket();
   private PegTicketDao pegTicketDao;
   private int var_etatTicket = 0;
   private boolean var_afficheBouton = false;
   private boolean showModalPanelTicket = false;
   private boolean var_valide = false;
   private List mesIntervenantsItem = new ArrayList();
   private String format = "PDF";
   private UtilPrint utilPrint;
   private boolean showModalPanelPrint = false;

   public void InstancesDaoUtilses() {
      this.pegTicketDao = new PegTicketDao(this.utilInitHibernate);
      this.userDao = new UserDao(this.utilInitHibernate);
      this.balDao = new BalDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerIntervenants(Session var1) throws HibernateException, NamingException {
      this.mesIntervenantsItem.clear();
      new ArrayList();
      List var2 = this.userDao.selectLesUserPegStr(1L, 1, 3, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.mesIntervenantsItem.add(new SelectItem(((UsersPeg)var2.get(var3)).getUsrid(), ((UsersPeg)var2.get(var3)).getUsrnom() + " " + ((UsersPeg)var2.get(var3)).getUsrprenom()));
         }
      }

   }

   public void rechercheTicketsByStructure() throws HibernateException, NamingException {
      this.rechercheTicketsByStructure((Session)null);
   }

   public void rechercheTicketsByStructure(Session var1) throws HibernateException, NamingException {
      this.lesPegTickets = this.pegTicketDao.rechercheTicketByStructure(this.structureLog.getStrid(), this.var_etatTicket, var1);
      this.dataModelPegTicket.setWrappedData(this.lesPegTickets);
      this.pegTicket = new PegTicket();
   }

   public void selectionLigne() {
      if (this.dataModelPegTicket.isRowAvailable()) {
         this.pegTicket = (PegTicket)this.dataModelPegTicket.getRowData();
         this.var_afficheBouton = true;
      }

   }

   public void ajouterTicket() {
      this.pegTicket = new PegTicket();
      this.var_action = 1;
      this.var_valide = false;
      this.pegTicket.setPegticDate(new Date());
      this.pegTicket.setPegticType(100);
      this.pegTicket.setPegticMode(100);
      this.pegTicket.setPegticModule("100");
      this.pegTicket.setPegticIdIntervenant(0L);
      this.showModalPanelTicket = true;
   }

   public void modifierTicket() {
      if (this.pegTicket != null) {
         if (this.pegTicket.getPegticEtat() == 0) {
            this.var_action = 2;
            this.var_valide = true;
         } else {
            this.var_action = 3;
            this.var_valide = false;
         }

         this.showModalPanelTicket = true;
      }

   }

   public void supprimerTicket() throws HibernateException, NamingException {
      if (this.pegTicket != null && this.pegTicket.getPegticEtat() == 0) {
         this.lesPegTickets.remove(this.pegTicket);
         this.pegTicketDao.delete(this.pegTicket);
         this.dataModelPegTicket.setWrappedData(this.lesPegTickets);
         this.var_afficheBouton = false;
      }

   }

   public void fermerTicket() {
      this.var_afficheBouton = false;
      this.showModalPanelTicket = false;
   }

   public void validerTicket() throws HibernateException, NamingException, Exception {
      if (this.pegTicket.getPegticIdIntervenant() != 0L) {
         this.usersPeg = this.userDao.selectUserPeg(this.pegTicket.getPegticIdIntervenant());
         if (this.usersPeg != null) {
            this.pegTicket.setPegticNomIntervenant(this.usersPeg.getUsrnom() + " " + this.usersPeg.getUsrprenom());
            this.pegTicket.setPegticMailIntervenant(this.usersPeg.getUsrmail());
         } else {
            this.pegTicket.setPegticNomIntervenant("");
            this.pegTicket.setPegticMailIntervenant("");
         }
      }

      this.pegTicket.setPegticIdStructure(this.structureLog.getStrid());
      this.pegTicket.setPegticNomStructure(this.structureLog.getStrraisonsociale());
      this.pegTicket.setPegticIdUser(this.usersLog.getUsrid());
      this.pegTicket.setPegticNomUser(this.usersLog.getUsrPatronyme());
      if (this.pegTicket.getPegticId() == 0L) {
         this.pegTicket = this.pegTicketDao.insert(this.pegTicket);
         this.lesPegTickets.add(this.pegTicket);
         this.dataModelPegTicket.setWrappedData(this.lesPegTickets);
         if (this.pegTicket.getPegticMailIntervenant() != null && !this.pegTicket.getPegticMailIntervenant().isEmpty()) {
            this.recupererEmetteur();
            this.generationMailUsr();
         }
      } else {
         this.pegTicket = this.pegTicketDao.modif(this.pegTicket);
      }

      this.showModalPanelTicket = false;
   }

   public void verificationValidation() {
      if (this.pegTicket.getPegticMode() != 100 && this.pegTicket.getPegticType() != 100 && !this.pegTicket.getPegticModule().equals("100") && this.pegTicket.getPegticIdIntervenant() != 0L) {
         this.var_valide = true;
      } else {
         this.var_valide = false;
      }

   }

   public void rechercheTicketsPep() throws HibernateException, NamingException {
      this.rechercheTicketsPep((Session)null);
   }

   public void rechercheTicketsPep(Session var1) throws HibernateException, NamingException {
      this.lesPegTickets = this.pegTicketDao.rechercheTicketPep(this.var_etatTicket, var1);
      this.dataModelPegTicket.setWrappedData(this.lesPegTickets);
      this.pegTicket = new PegTicket();
   }

   public void validerReponse() throws HibernateException, NamingException, Exception {
      if (this.pegTicket != null) {
         this.pegTicket = this.pegTicketDao.reponse(this.pegTicket);
         if (this.pegTicket.getPegticMailIntervenant() != null && !this.pegTicket.getPegticMailIntervenant().isEmpty()) {
            this.recupererEmetteur();
            this.generationMailPep();
         }
      }

      this.showModalPanelTicket = false;
   }

   public void recupererEmetteur() throws HibernateException, NamingException {
      this.bal = new Bal();
      this.bal = this.balDao.chargeMailSociete(this.structureLog.getStrid(), (Session)null);
      if (this.bal == null) {
         this.bal = new Bal();
         this.bal.setBalssl(StaticModePegase.getSslEmmeteurSmp());
         this.bal.setBalsmtauthentification(StaticModePegase.getAuthentificationEmetteurSmp());
         this.bal.setBalsmtpserveur(StaticModePegase.getServeurEmetteurSmp());
         this.bal.setBalsmtpport(StaticModePegase.getPortEmetteurSmp());
         this.bal.setBaladressemail(StaticModePegase.getAdresseEmetteurSmp());
         this.bal.setBalpw(StaticModePegase.getPwEmetteurSmp());
         this.bal.setBaladressemailreponse((String)null);
      }

   }

   public void generationMailUsr() throws HibernateException, NamingException, Exception {
      if (this.bal != null) {
         String var1 = "";
         var1 = "<html><head></head><body ><h:form>";
         var1 = var1 + "<table style=\"border:1px dotted green\" align=\"center\" width=\"100%\">";
         var1 = var1 + "<thead></thead>";
         var1 = var1 + "<table><tbody><tr><td>Bonjour, " + this.usersPeg.getUsrprenom() + ", <br/>" + "<br/>";
         var1 = var1 + "Demandeur : &nbsp; " + this.usersLog.getUsrCivilite() + " " + this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom() + " (" + this.usersLog.getUsrCollaboration() + ")" + "<br/>";
         var1 = var1 + "Entreprise : &nbsp; " + this.structureLog.getStrraisonsociale() + " (" + this.structureLog.getStrnompays() + ")" + "<br/>";
         var1 = var1 + "Ticket n. : &nbsp; " + this.pegTicket.getPegticId() + "<br/>";
         var1 = var1 + "Type ticket : &nbsp; " + this.pegTicket.getLibelleType() + "<br/>";
         var1 = var1 + "Mode : &nbsp; " + this.pegTicket.getLibelleMode() + "<br/>";
         var1 = var1 + "Module : &nbsp; " + this.pegTicket.getPegticModule() + "<br/>";
         if (this.pegTicket.getPegticSousModule() != null && !this.pegTicket.getPegticSousModule().isEmpty()) {
            var1 = var1 + "Sous module : &nbsp; " + this.pegTicket.getPegticSousModule() + "<br/>";
         }

         if (this.pegTicket.getPegticEcran() != null && !this.pegTicket.getPegticEcran().isEmpty()) {
            var1 = var1 + "R&eacute;f&eacute;rence &eacute;cran : &nbsp; " + this.pegTicket.getPegticEcran() + "<br/>";
         }

         if (this.pegTicket.getPegticModele() != null && !this.pegTicket.getPegticModele().isEmpty()) {
            var1 = var1 + "R&eacute;f&eacute;rence &eacute;tat : &nbsp; " + this.pegTicket.getPegticModele() + "<br/>";
         }

         if (this.pegTicket.getPegticObject() != null && !this.pegTicket.getPegticObject().isEmpty()) {
            var1 = var1 + "Objet : &nbsp; " + this.pegTicket.getPegticObject() + "<br/>";
         }

         if (this.pegTicket.getPegticProbleme() != null && !this.pegTicket.getPegticProbleme().isEmpty()) {
            var1 = var1 + "Probl&eacute;me/Question : &nbsp; " + this.pegTicket.getPegticProbleme() + "<br/>";
         }

         if (this.pegTicket.getPegticSuggestion() != null && !this.pegTicket.getPegticSuggestion().isEmpty()) {
            var1 = var1 + "Suggestion : &nbsp; " + this.pegTicket.getPegticSuggestion() + "<br/>";
         }

         var1 = var1 + "<br/>";
         var1 = var1 + "Veuillez vous connecter &agrave; la plate forme e-P&eacute;gase avec vos identifiants afin de statuer sur cette demande.<br/><br/>";
         var1 = var1 + "Dans cette attente, veuillez agr&eacute;er, " + this.usersPeg.getUsrprenom() + ", l'expressions de mes sentiments distingu&eacute;s. " + "<br/>" + "<br/>";
         var1 = var1 + "Cordialement, <br/>" + this.usersLog.getUsrPrenom() + "." + "<br/>";
         if (this.usersLog.getUsrFonction() != null && !this.usersLog.getUsrFonction().isEmpty()) {
            var1 = var1 + this.usersLog.getUsrFonction() + "<br/>";
         }

         var1 = var1 + "<br/><i style=\"color:red;font-size:11px;\">Ce message vous est ";
         var1 = var1 + "envoy&eacute; automatiquement &agrave; partir de la plateforme de gestion e-P&eacute;gase (https://www.e-pegase.biz/epegase/).</i></td></tr><tr><td></td></tr></tbody></table>";
         if (this.bal != null && this.bal.getBalSignature() != null) {
            var1 = var1 + "<br/><br/>" + this.bal.getBalSignature();
         } else {
            var1 = var1 + "---";
         }

         var1 = var1 + "</h:form></body></html>";
         UtilMail var2 = new UtilMail(this.structureLog);
         String var3 = this.usersLog.getUsrMail();
         var2.sendMail(var1, this.usersPeg.getUsrmail(), this.bal.getBaladressemail(), "", "", var3, "TICKET N." + this.pegTicket.getPegticId(), this.bal);
      }

   }

   public void generationMailPep() throws HibernateException, NamingException, Exception {
      if (this.bal != null) {
         String var1 = "";
         var1 = "<html><head></head><body ><h:form>";
         var1 = var1 + "<table style=\"border:1px dotted green\" align=\"center\" width=\"100%\">";
         var1 = var1 + "<thead></thead>";
         var1 = var1 + "<table><tbody><tr><td>Bonjour, " + this.pegTicket.getPegticNomUser() + ", <br/>" + "<br/>";
         var1 = var1 + "R&eacute;sum&eacute; de votre probl&eacute;me/question : <br/>";
         var1 = var1 + "Entreprise : &nbsp; " + this.pegTicket.getPegticNomStructure() + "<br/>";
         var1 = var1 + "Ticket n. : &nbsp; " + this.pegTicket.getPegticId() + "<br/>";
         var1 = var1 + "Type ticket : &nbsp; " + this.pegTicket.getLibelleType() + "<br/>";
         var1 = var1 + "Mode : &nbsp; " + this.pegTicket.getLibelleMode() + "<br/>";
         var1 = var1 + "Module : &nbsp; " + this.pegTicket.getPegticModule() + "<br/>";
         if (this.pegTicket.getPegticSousModule() != null && !this.pegTicket.getPegticSousModule().isEmpty()) {
            var1 = var1 + "Sous module : &nbsp; " + this.pegTicket.getPegticSousModule() + "<br/>";
         }

         if (this.pegTicket.getPegticEcran() != null && !this.pegTicket.getPegticEcran().isEmpty()) {
            var1 = var1 + "R&eacute;f&eacute;rence &eacute;cran : &nbsp; " + this.pegTicket.getPegticEcran() + "<br/>";
         }

         if (this.pegTicket.getPegticModele() != null && !this.pegTicket.getPegticModele().isEmpty()) {
            var1 = var1 + "R&eacute;f&eacute;rence &eacute;tat : &nbsp; " + this.pegTicket.getPegticModele() + "<br/>";
         }

         if (this.pegTicket.getPegticObject() != null && !this.pegTicket.getPegticObject().isEmpty()) {
            var1 = var1 + "Objet : &nbsp; " + this.pegTicket.getPegticObject() + "<br/>";
         }

         if (this.pegTicket.getPegticProbleme() != null && !this.pegTicket.getPegticProbleme().isEmpty()) {
            var1 = var1 + "Probl&eacute;me/Question : &nbsp; " + this.pegTicket.getPegticProbleme() + "<br/>";
         }

         if (this.pegTicket.getPegticSuggestion() != null && !this.pegTicket.getPegticSuggestion().isEmpty()) {
            var1 = var1 + "Suggestion : &nbsp; " + this.pegTicket.getPegticSuggestion() + "<br/>";
         }

         var1 = var1 + "<br/>";
         var1 = var1 + "Voici la r&eacute;ponse : <br/>";
         var1 = var1 + "&nbsp;&nbsp;&nbsp; " + this.pegTicket.getPegticReponse() + "<br/>";
         var1 = var1 + "<br/>";
         var1 = var1 + "Veuillez agr&eacute;er, " + this.pegTicket.getPegticNomIntervenant() + ", l'expressions de nos sentiments distingu&eacute;s. " + "<br/>" + "<br/>";
         var1 = var1 + "Cordialement, <br/>" + this.pegTicket.getPegticNomIntervenant() + "." + "<br/>";
         var1 = var1 + "<br/><i style=\"color:red;font-size:11px;\">Ce message vous est ";
         var1 = var1 + "envoy&eacute; automatiquement &agrave; partir de la plateforme de gestion e-P&eacute;gase (https://www.e-pegase.biz/epegase/).</i></td></tr><tr><td></td></tr></tbody></table>";
         if (this.bal != null && this.bal.getBalSignature() != null) {
            var1 = var1 + "<br/><br/>" + this.bal.getBalSignature();
         } else {
            var1 = var1 + "---";
         }

         var1 = var1 + "</h:form></body></html>";
         UtilMail var2 = new UtilMail(this.structureLog);
         String var3 = this.pegTicket.getPegticMailIntervenant();
         var2.sendMail(var1, this.pegTicket.getPegticMailUser(), this.bal.getBaladressemail(), "", "", var3, "TICKET N." + this.pegTicket.getPegticId(), this.bal);
      }

   }

   public void initImpression() {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
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

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      var1.add(this.pegTicket);
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      return var2;
   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator + "PegTicketFiche";
      if (var1 != null && !var1.isEmpty()) {
         this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
         this.utilPrint.setRapport(var1);
         this.utilPrint.setEntete("Impression du ticket");
         this.utilPrint.setMontant_lettre("");
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

      this.var_action = 0;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public DataModel getDataModelPegTicket() {
      return this.dataModelPegTicket;
   }

   public void setDataModelPegTicket(DataModel var1) {
      this.dataModelPegTicket = var1;
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

   public int getVar_etatTicket() {
      return this.var_etatTicket;
   }

   public void setVar_etatTicket(int var1) {
      this.var_etatTicket = var1;
   }

   public PegTicket getPegTicket() {
      return this.pegTicket;
   }

   public void setPegTicket(PegTicket var1) {
      this.pegTicket = var1;
   }

   public boolean isVar_afficheBouton() {
      return this.var_afficheBouton;
   }

   public void setVar_afficheBouton(boolean var1) {
      this.var_afficheBouton = var1;
   }

   public boolean isShowModalPanelTicket() {
      return this.showModalPanelTicket;
   }

   public void setShowModalPanelTicket(boolean var1) {
      this.showModalPanelTicket = var1;
   }

   public boolean isVar_valide() {
      return this.var_valide;
   }

   public void setVar_valide(boolean var1) {
      this.var_valide = var1;
   }

   public List getMesIntervenantsItem() {
      return this.mesIntervenantsItem;
   }

   public void setMesIntervenantsItem(List var1) {
      this.mesIntervenantsItem = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
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
}
