package com.epegase.systeme.formbakingbeans;

import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePot;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.Connexion;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.menu.MenuModuleHorizontalCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilJob;
import com.epegase.systeme.util.UtilMail;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.LectureFormesJuridiques;
import com.epegase.systeme.xml.LectureLangues;
import com.epegase.systeme.xml.LecturePays;
import com.epegase.systeme.xml.LireVersion;
import com.epegase.systeme.xml.Version;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;

public class FormBakingEpegase extends HttpServlet implements Serializable {
   private String urlDocument;
   private int typePlateforme;
   private MenuModuleHorizontalCtrl menuModuleHorizontalCtrl = new MenuModuleHorizontalCtrl();
   private UtilInitHibernate utilInitHibernate = new UtilInitHibernate();
   private String message = "";
   private String reponseFinale = "";
   private Connexion connexion;
   private boolean var_aff_inscription = false;
   private static HttpSession sessionUser;
   private int nbImage;
   private int dateImportante = 0;
   private String repImageStartup;
   private UtilJob utilJob;
   private List lesScreenShotCompta;
   private List lesScreenShotPaye;
   private List lesScreenShotAchats;
   private List lesScreenShotVentes;
   private List lesScreenShotStocks;
   private List lesScreenShotTresorerie;
   private List lesScreenShotImmobilier;
   private List lesScreenShotParc;
   private List lesScreenShotMedical;
   private List mesPaysItems;
   private List mesDevisesItems;
   private List mesLanguesItems;
   private List mesFormesJuridiquesItems;
   private List mesFonctionsItems;
   private StructurePot structurePot;
   private boolean validerDemande = false;
   private boolean autoReponse = false;

   public FormBakingEpegase() throws IOException, SAXException, JDOMException, InstantiationException, IllegalAccessException, NamingException, SQLException {
      this.connexion = new Connexion(this.utilInitHibernate);
      StaticModePegase.class.newInstance();
      FacesContext var1 = FacesContext.getCurrentInstance();
      HttpSession var2 = (HttpSession)var1.getExternalContext().getSession(true);
      sessionUser = var2;
      this.repImageStartup = StaticModePegase.getImageStartup();
      if (this.repImageStartup == null || this.repImageStartup.isEmpty()) {
         this.repImageStartup = "startup";
      }

   }

   public String connection() throws Exception {
      String pageToRedirect = "home";

      try {
         String retourConnexion = this.connexion.connection(this.menuModuleHorizontalCtrl.isRw());
         if (retourConnexion.equals("connexion")) {
            if (this.connexion.getBaseData() != null && !this.connexion.getBaseData().isEmpty()) {
               if (this.connexion.getStructurelog() != null) {
                  Session var3 = this.utilInitHibernate.getOpenSession(this.connexion.getBaseData(), "Accueil");
                  this.menuModuleHorizontalCtrl.setutilInitHibernate(this.utilInitHibernate);
                  this.menuModuleHorizontalCtrl.setBaseLog(this.connexion.getBaseData());
                  this.menuModuleHorizontalCtrl.setStructureLog(this.connexion.getStructurelog());
                  this.menuModuleHorizontalCtrl.setUsersLog(this.connexion.getUserslog());
                  this.menuModuleHorizontalCtrl.setVar_societe_cabinet(this.connexion.getVar_societe_cabinet());
                  this.menuModuleHorizontalCtrl.setVar_memo_id_master(this.connexion.getVar_memo_id_master());
                  this.menuModuleHorizontalCtrl.setVar_memo_nom_master(this.connexion.getVar_memo_nom_master());
                  this.menuModuleHorizontalCtrl.setVar_memo_id_user(this.connexion.getVar_memo_id_user());
                  this.menuModuleHorizontalCtrl.setVar_invisible(this.connexion.isVar_invisible());
                  this.menuModuleHorizontalCtrl.recupererModule(var3);
                  this.menuModuleHorizontalCtrl.setListeSocieteCabinet(this.connexion.getListeSocieteCabinet());
                  this.menuModuleHorizontalCtrl.calculBaseCopie(var3);
                  this.menuModuleHorizontalCtrl.calculHeures();
                  this.menuModuleHorizontalCtrl.collaborateursItems(var3);
                  this.menuModuleHorizontalCtrl.tachesItems(var3);
                  if (this.connexion.getUserslog().getGroupe().getGrpModuleGuest() != 1 && this.connexion.getUserslog().getUsrIdTiersGuest() == 0L) {
                     this.menuModuleHorizontalCtrl.accueil(var3, this.urlDocument, this.typePlateforme, true);
                  } else {
                     this.menuModuleHorizontalCtrl.guest(var3, this.urlDocument, this.typePlateforme);
                  }

                  if (StaticModePegase.getInternet_actif() != 0 && this.menuModuleHorizontalCtrl.getUsersLog().getUsrAssistant() != 0) {
                     this.menuModuleHorizontalCtrl.chargerListeMessage();
                     this.menuModuleHorizontalCtrl.messageVocal();
                  }

                  this.utilInitHibernate.closeSession();
                  this.menuModuleHorizontalCtrl.chargerScripts();
                  if (this.connexion.getStructurelog().getStrappDropbox() != null && !this.connexion.getStructurelog().getStrappDropbox().isEmpty() && !this.connexion.getStructurelog().getStrappDropbox().equals("0") && this.menuModuleHorizontalCtrl.getLesScripts().size() != 0) {
                     this.utilJob = new UtilJob();
                     this.utilJob.setMenuModuleHorizontalCtrl(this.menuModuleHorizontalCtrl);
                     this.utilJob.RepetAction();
                  }

                  pageToRedirect = "connexion";
               } else {
                  if (sessionUser != null) {
                     sessionUser.invalidate();
                  }

                  pageToRedirect = "home";
                  StaticModePegase.setReponseFinale(pageToRedirect);
               }
            } else {
               if (sessionUser != null) {
                  sessionUser.invalidate();
               }

               pageToRedirect = "home";
               StaticModePegase.setReponseFinale(pageToRedirect);
            }
         } else if (!retourConnexion.equals("public")) {
            if (sessionUser != null) {
               sessionUser.invalidate();
            }

            pageToRedirect = "home";
            StaticModePegase.setReponseFinale(retourConnexion);
         }
      } catch (Exception var7) {
         if (sessionUser != null) {
            sessionUser.invalidate();
         }

         pageToRedirect = "home";
         StaticModePegase.setReponseFinale(pageToRedirect);
         throw var7;
      } finally {
         ;
      }

      if (!pageToRedirect.equals("connexion") && !pageToRedirect.equals("public")) {
         pageToRedirect = "erreur";
      }

      return pageToRedirect;
   }

   public void deconnection() throws Exception {
      if (this.menuModuleHorizontalCtrl != null && !this.menuModuleHorizontalCtrl.isVar_invisible() && this.menuModuleHorizontalCtrl.isRw()) {
         EspionDao var1 = new EspionDao(this.menuModuleHorizontalCtrl.getBaseLog(), this.utilInitHibernate);
         Espion var2 = new Espion();
         var2.setEspdtecreat(new Date());
         var2.setUsers(this.menuModuleHorizontalCtrl.getUsersLog());
         var2.setEspaction("Logout");
         var2.setEsptype(1);
         var1.mAJEspion(var2);
      }

      try {
         if (sessionUser != null) {
            sessionUser.invalidate();
         }
      } catch (Exception var6) {
         throw var6;
      } finally {
         sessionUser = null;
      }

      this.menuModuleHorizontalCtrl = new MenuModuleHorizontalCtrl();
      this.utilInitHibernate = new UtilInitHibernate();
      this.connexion = new Connexion(this.utilInitHibernate);
   }

   public String connectionEnTantQue(Structure var1, Users var2, int var3, long var4, String var6, long var7, List var9) throws Exception {
      String var10 = "home";

      try {
         Session var11 = this.utilInitHibernate.getOpenSession(this.connexion.getBaseData(), "Accueil");
         this.menuModuleHorizontalCtrl.setutilInitHibernate(this.utilInitHibernate);
         String var12 = "structure" + var1.getStrid();
         this.menuModuleHorizontalCtrl.setBaseLog(var12);
         this.menuModuleHorizontalCtrl.setStructureLog(var1);
         this.menuModuleHorizontalCtrl.setUsersLog(var2);
         this.menuModuleHorizontalCtrl.setVar_societe_cabinet(var3);
         this.menuModuleHorizontalCtrl.setVar_memo_id_master(var4);
         this.menuModuleHorizontalCtrl.setVar_memo_nom_master(var6);
         this.menuModuleHorizontalCtrl.setVar_memo_id_user(var7);
         this.menuModuleHorizontalCtrl.setVar_invisible(true);
         this.menuModuleHorizontalCtrl.recupererModule(var11);
         this.menuModuleHorizontalCtrl.setListeSocieteCabinet(var9);
         this.menuModuleHorizontalCtrl.calculBaseCopie(var11);
         this.menuModuleHorizontalCtrl.calculHeures();
         this.menuModuleHorizontalCtrl.collaborateursItems(var11);
         this.menuModuleHorizontalCtrl.tachesItems(var11);
         if (var2.getGroupe().getGrpModuleGuest() != 1 && var2.getUsrIdTiersGuest() == 0L) {
            this.menuModuleHorizontalCtrl.accueil(var11, this.urlDocument, this.typePlateforme, true);
         } else {
            this.menuModuleHorizontalCtrl.guest(var11, this.urlDocument, this.typePlateforme);
         }

         this.utilInitHibernate.closeSession();
         var10 = "connexion";
      } catch (Exception var16) {
         if (sessionUser != null) {
            sessionUser.invalidate();
         }

         throw var16;
      } finally {
         ;
      }

      if (!var10.equals("connexion")) {
         var10 = "erreur";
      }

      return var10;
   }

   public boolean isVar_aff_inscription() throws UnknownHostException {
      if (StaticModePegase.getInternet_actif() == 2 && StaticModePegase.getUrlIp().equals(StaticModePegase.getIpServeur())) {
         this.var_aff_inscription = true;
      } else {
         this.var_aff_inscription = false;
      }

      return this.var_aff_inscription;
   }

   public void setVar_aff_inscription(boolean var1) {
      this.var_aff_inscription = var1;
   }

   public void connecionEraser() throws Exception {
      this.connexion.connecionEraser();
      if (sessionUser != null) {
         sessionUser.invalidate();
      }

      sessionUser = null;
      this.menuModuleHorizontalCtrl = new MenuModuleHorizontalCtrl();
      this.utilInitHibernate = new UtilInitHibernate();
      this.connexion = new Connexion(this.utilInitHibernate);
   }

   public void screenshot() {
      this.lesScreenShotCompta = new ArrayList();
      this.lesScreenShotCompta.add("images/screenshot/compta1.jpg");
      this.lesScreenShotCompta.add("images/screenshot/compta2.jpg");
      this.lesScreenShotCompta.add("images/screenshot/compta3.jpg");
      this.lesScreenShotCompta.add("images/screenshot/compta4.jpg");
      this.lesScreenShotCompta.add("images/screenshot/compta5.jpg");
      this.lesScreenShotCompta.add("images/screenshot/compta6.jpg");
      this.lesScreenShotPaye = new ArrayList();
      this.lesScreenShotPaye.add("images/screenshot/paye1.jpg");
      this.lesScreenShotPaye.add("images/screenshot/paye2.jpg");
      this.lesScreenShotPaye.add("images/screenshot/paye3.jpg");
      this.lesScreenShotPaye.add("images/screenshot/paye4.jpg");
      this.lesScreenShotPaye.add("images/screenshot/paye5.jpg");
      this.lesScreenShotPaye.add("images/screenshot/paye6.jpg");
      this.lesScreenShotAchats = new ArrayList();
      this.lesScreenShotAchats.add("images/screenshot/achats1.jpg");
      this.lesScreenShotAchats.add("images/screenshot/achats2.jpg");
      this.lesScreenShotAchats.add("images/screenshot/achats3.jpg");
      this.lesScreenShotAchats.add("images/screenshot/achats4.jpg");
      this.lesScreenShotAchats.add("images/screenshot/achats5.jpg");
      this.lesScreenShotAchats.add("images/screenshot/achats6.jpg");
      this.lesScreenShotVentes = new ArrayList();
      this.lesScreenShotVentes.add("images/screenshot/ventes1.jpg");
      this.lesScreenShotVentes.add("images/screenshot/ventes2.jpg");
      this.lesScreenShotVentes.add("images/screenshot/ventes3.jpg");
      this.lesScreenShotVentes.add("images/screenshot/ventes4.jpg");
      this.lesScreenShotVentes.add("images/screenshot/ventes5.jpg");
      this.lesScreenShotVentes.add("images/screenshot/ventes6.jpg");
      this.lesScreenShotStocks = new ArrayList();
      this.lesScreenShotStocks.add("images/screenshot/stocks1.jpg");
      this.lesScreenShotStocks.add("images/screenshot/stocks2.jpg");
      this.lesScreenShotStocks.add("images/screenshot/stocks3.jpg");
      this.lesScreenShotStocks.add("images/screenshot/stocks4.jpg");
      this.lesScreenShotStocks.add("images/screenshot/stocks5.jpg");
      this.lesScreenShotStocks.add("images/screenshot/stocks6.jpg");
      this.lesScreenShotImmobilier = new ArrayList();
      this.lesScreenShotImmobilier.add("images/screenshot/immobilier1.jpg");
      this.lesScreenShotImmobilier.add("images/screenshot/immobilier2.jpg");
      this.lesScreenShotImmobilier.add("images/screenshot/immobilier3.jpg");
      this.lesScreenShotImmobilier.add("images/screenshot/immobilier4.jpg");
      this.lesScreenShotImmobilier.add("images/screenshot/immobilier5.jpg");
      this.lesScreenShotImmobilier.add("images/screenshot/immobilier6.jpg");
      this.lesScreenShotTresorerie = new ArrayList();
      this.lesScreenShotTresorerie.add("images/screenshot/tresorerie1.jpg");
      this.lesScreenShotTresorerie.add("images/screenshot/tresorerie2.jpg");
      this.lesScreenShotTresorerie.add("images/screenshot/tresorerie3.jpg");
      this.lesScreenShotTresorerie.add("images/screenshot/tresorerie4.jpg");
      this.lesScreenShotTresorerie.add("images/screenshot/tresorerie5.jpg");
      this.lesScreenShotTresorerie.add("images/screenshot/tresorerie6.jpg");
      this.lesScreenShotParc = new ArrayList();
      this.lesScreenShotParc.add("images/screenshot/parc1.jpg");
      this.lesScreenShotParc.add("images/screenshot/parc2.jpg");
      this.lesScreenShotParc.add("images/screenshot/parc3.jpg");
      this.lesScreenShotParc.add("images/screenshot/parc4.jpg");
      this.lesScreenShotMedical = new ArrayList();
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
      UtilMail var3 = new UtilMail((Structure)null);
      if (this.structurePot.getStrnompays() != null && !this.structurePot.getStrnompays().isEmpty() && this.structurePot.getStrnompays().equals("MALI")) {
         var3.mailDemandeInformation(var2, "info@horus-solutions.net", "gillesdecruzel@gmail.com", "DEMANDE INFORMATONS E-PEGASE");
      } else {
         var3.mailInscription(var2, "gillesdecruzel@gmail.com", "DEMANDE INFORMATONS E-PEGASE");
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
      var3 = new UtilMail((Structure)null);
      var3.mailInscription(var2, this.structurePot.getStrmail(), "DEMANDE INFORMATONS E-PEGASE");
      this.structurePot = new StructurePot();
      this.validerDemande = false;
      this.autoReponse = true;
   }

   public void fermerAutoReponse() {
      this.autoReponse = false;
   }

   public String getMessage() {
      return this.message;
   }

   public void setMessage(String var1) {
      this.message = var1;
   }

   public Connexion getConnexion() {
      return this.connexion;
   }

   public void setConnexion(Connexion var1) {
      this.connexion = var1;
   }

   public MenuModuleHorizontalCtrl getMenuModuleHorizontalCtrl() {
      return this.menuModuleHorizontalCtrl;
   }

   public void setMenuModuleHorizontalCtrl(MenuModuleHorizontalCtrl var1) {
      this.menuModuleHorizontalCtrl = var1;
   }

   public static HttpSession getSessionUser() {
      return sessionUser;
   }

   public static void setSessionUser(HttpSession var0) {
      sessionUser = var0;
   }

   public String getUrlDocument() {
      if (this.urlDocument == null || this.urlDocument.isEmpty()) {
         this.urlDocument = StaticModePegase.getUrlProtocole() + "://" + StaticModePegase.getUrlHost() + ":" + StaticModePegase.getUrlPort() + "/";
      }

      this.menuModuleHorizontalCtrl.setUrlDocument(this.urlDocument);
      return this.urlDocument;
   }

   public void setUrlDocument(String var1) {
      this.urlDocument = var1;
   }

   public int getTypePlateforme() {
      return this.typePlateforme;
   }

   public void setTypePlateforme(int var1) {
      this.typePlateforme = var1;
   }

   public int getNbImage() {
      new Version();
      LireVersion var2 = new LireVersion();
      Version var1 = var2.lancer();
      String var3 = "";
      if (var1.getVersion_imageStartup() != null && !var1.getVersion_imageStartup().isEmpty()) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "web" + File.separator + "images" + File.separator + var1.getVersion_imageStartup() + File.separator;
         StaticModePegase.setImageStartup(var1.getVersion_imageStartup());
      } else {
         var3 = StaticModePegase.getCheminContext() + File.separator + "web" + File.separator + "images" + File.separator + "startup" + File.separator;
         StaticModePegase.setImageStartup("startup");
      }

      File var4 = new File(var3);
      if (!var4.exists()) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "web" + File.separator + "images" + File.separator + "startup" + File.separator;
         var4 = new File(var3);
      }

      String[] var5 = var4.list();
      boolean var6 = false;
      int var7;
      if (var5 == null) {
         var7 = 1;
      } else {
         var7 = var5.length - 1;
         if (var1.getVersion_imageStartup() != null && !var1.getVersion_imageStartup().isEmpty()) {
            if (var1.getVersion_imageStartup().equals("startup")) {
               var7 -= 2;
            }
         } else {
            var7 -= 2;
         }

         if (var7 <= 0) {
            var7 = 1;
         }
      }

      this.nbImage = (int)Math.floor(Math.random() * (double)var7);
      return this.nbImage;
   }

   public void setNbImage(int var1) {
      this.nbImage = var1;
   }

   public int getDateImportante() {
      if ((new Date()).getMonth() + 1 == 1) {
         this.dateImportante = 1;
      } else if ((new Date()).getMonth() + 1 == 2 && (new Date()).getDate() == 14) {
         this.dateImportante = 2;
      } else if ((new Date()).getMonth() + 1 == 3 && (new Date()).getDate() == 8) {
         this.dateImportante = 3;
      } else if ((new Date()).getMonth() + 1 == 4 && (new Date()).getDate() == 4) {
         this.dateImportante = 8;
      } else if ((new Date()).getMonth() + 1 == 4 && (new Date()).getDate() == 17) {
         this.dateImportante = 17;
      } else if ((new Date()).getMonth() + 1 == 5 && (new Date()).getDate() == 1) {
         this.dateImportante = 11;
      } else if ((new Date()).getMonth() + 1 == 5 && (new Date()).getDate() == 26) {
         this.dateImportante = 4;
      } else if ((new Date()).getMonth() + 1 == 6 && (new Date()).getDate() == 16) {
         this.dateImportante = 5;
      } else if ((new Date()).getMonth() + 1 == 6 && (new Date()).getDate() == 23) {
         this.dateImportante = 16;
      } else if ((new Date()).getMonth() + 1 == 7 && (new Date()).getDate() == 7) {
         this.dateImportante = 10;
      } else if ((new Date()).getMonth() + 1 == 7 && (new Date()).getDate() == 14) {
         this.dateImportante = 6;
      } else if ((new Date()).getMonth() + 1 == 7 && (new Date()).getDate() == 31) {
         this.dateImportante = 15;
      } else if ((new Date()).getMonth() + 1 == 8 && (new Date()).getDate() == 15) {
         this.dateImportante = 12;
      } else if ((new Date()).getMonth() + 1 == 8 && (new Date()).getDate() == 17) {
         this.dateImportante = 7;
      } else if ((new Date()).getMonth() + 1 == 9 && (new Date()).getDate() == 22) {
         this.dateImportante = 9;
      } else if ((new Date()).getMonth() + 1 == 11 && (new Date()).getDate() == 1) {
         this.dateImportante = 13;
      } else if ((new Date()).getMonth() + 1 == 11 && (new Date()).getDate() == 25) {
         this.dateImportante = 18;
      } else if ((new Date()).getMonth() + 1 == 12 && (new Date()).getDate() == 25) {
         this.dateImportante = 14;
      } else {
         this.dateImportante = 0;
      }

      return this.dateImportante;
   }

   public void setDateImportante(int var1) {
      this.dateImportante = var1;
   }

   public String getRepImageStartup() {
      if (StaticModePegase.getImageStartup() != null && !StaticModePegase.getImageStartup().isEmpty()) {
         this.repImageStartup = StaticModePegase.getImageStartup();
      } else {
         this.repImageStartup = "startup";
      }

      return this.repImageStartup;
   }

   public void setRepImageStartup(String var1) {
      this.repImageStartup = var1;
   }

   public String getReponseFinale() {
      this.reponseFinale = StaticModePegase.getReponseFinale();
      return this.reponseFinale;
   }

   public void setReponseFinale(String var1) {
      this.reponseFinale = var1;
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
}
