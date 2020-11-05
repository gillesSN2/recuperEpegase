package com.epegase.systeme.util;

import com.epegase.systeme.classe.Bal;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.UserDao;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.fill.JRFileVirtualizer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;

@Scope("request")
public class UtilParapheur implements Serializable {
   private Structure structureLog;
   private Users usersLog;
   private String baseLog;
   private UtilInitHibernate utilInitHibernate;
   private Parapheur parapheur;
   private ParapheurDao parapheurDao;
   private UserDao usersDao;
   private Bal bal;
   private Users usersDestinataire;
   private UtilDate utilDate = new UtilDate();

   public UtilParapheur(UtilInitHibernate var1, Structure var2, String var3, Users var4) {
      this.utilInitHibernate = var1;
      this.baseLog = var3;
      this.structureLog = var2;
      this.usersLog = var4;
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
   }

   public void majParapheur(int var1, Habilitation var2, long var3, String var5, String var6, Date var7, String var8, double var9, String var11, Tiers var12, String var13, String var14, JRBeanCollectionDataSource var15, String var16, int var17, int var18, Session var19) throws HibernateException, NamingException, Exception {
      if (var2 != null) {
         boolean var20 = false;
         if (var19 == null) {
            var19 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parapheur");
            var20 = true;
         }

         this.parapheur = new Parapheur();
         this.parapheur = this.parapheurDao.existenceParapheur(var3, var1, var19);
         if (this.parapheur == null || this.parapheur != null) {
            if (this.parapheur == null) {
               this.parapheur = new Parapheur();
            }

            this.parapheur.setPhrNature(var1);
            this.parapheur.setPhrNatureOrigine(var1);
            this.parapheur.setPhrDocId(var3);
            this.parapheur.setPhrNum(var5);
            this.parapheur.setPhrNomTiers(var6);
            this.parapheur.setPhrDate(var7);
            this.parapheur.setPhrMontant(var9);
            this.parapheur.setPhrModeleImp(var11);
            this.parapheur.setPhrMode(var2.getHabMode());
            if (var2.getHabNombre() == 0) {
               var2.setHabNombre(1);
            }

            this.parapheur.setPhrNombre(var2.getHabNombre());
            this.parapheur.setPhrPosition(1);
            this.parapheur.setPhrUser1Cat(var2.getHabUser1Cat());
            this.usersDestinataire = this.usersDao.selectByIdUsers(var2.getHabUser1Id(), var19);
            if (this.usersDestinataire != null) {
               if (var2.getHabRemplace1Id() != 0L && this.usersDestinataire.getUsrDateDebutIndisponibilite() != null && this.usersDestinataire.getUsrDateFinIndisponibilite() != null && var7.compareTo(this.usersDestinataire.getUsrDateDebutIndisponibilite()) >= 0 && var7.compareTo(this.usersDestinataire.getUsrDateFinIndisponibilite()) <= 0) {
                  this.parapheur.setPhrUser1Id(var2.getHabRemplace1Id());
                  this.parapheur.setPhrUser1Nom(var2.getHabRemplace1Nom());
               } else {
                  this.parapheur.setPhrUser1Id(var2.getHabUser1Id());
                  this.parapheur.setPhrUser1Nom(var2.getHabUser1Nom());
               }
            }

            this.parapheur.setPhrUser2Id(0L);
            this.parapheur.setPhrUser3Id(0L);
            this.parapheur.setPhrUser4Id(0L);
            this.parapheur.setPhrUser5Id(0L);
            this.parapheur.setPhrUser6Id(0L);
            this.parapheur.setPhrUser2Cat(0);
            this.parapheur.setPhrUser3Cat(0);
            this.parapheur.setPhrUser4Cat(0);
            this.parapheur.setPhrUser5Cat(0);
            this.parapheur.setPhrUser6Cat(0);
            this.parapheur.setPhrUser2Nom("");
            this.parapheur.setPhrUser3Nom("");
            this.parapheur.setPhrUser4Nom("");
            this.parapheur.setPhrUser5Nom("");
            this.parapheur.setPhrUser6Nom("");
            this.parapheur.setPhrUser1Etat(0);
            this.parapheur.setPhrUser2Etat(0);
            this.parapheur.setPhrUser3Etat(0);
            this.parapheur.setPhrUser4Etat(0);
            this.parapheur.setPhrUser5Etat(0);
            this.parapheur.setPhrUser6Etat(0);
            if (this.parapheur.getPhrUser1DteRep() != null && this.parapheur.getPhrUser1Explication() != null && !this.parapheur.getPhrUser1Explication().isEmpty()) {
               this.parapheur.setPhrUser1MemoExplication(this.parapheur.getPhrUser1MemoExplication() + this.utilDate.dateToStringFr(this.parapheur.getPhrUser1DteRep()) + " " + this.parapheur.getPhrUser1Explication() + "\n");
            }

            if (this.parapheur.getPhrUser2DteRep() != null && this.parapheur.getPhrUser2Explication() != null && !this.parapheur.getPhrUser2Explication().isEmpty()) {
               this.parapheur.setPhrUser2MemoExplication(this.parapheur.getPhrUser2MemoExplication() + this.utilDate.dateToStringFr(this.parapheur.getPhrUser2DteRep()) + " " + this.parapheur.getPhrUser2Explication() + "\n");
            }

            if (this.parapheur.getPhrUser3DteRep() != null && this.parapheur.getPhrUser3Explication() != null && !this.parapheur.getPhrUser3Explication().isEmpty()) {
               this.parapheur.setPhrUser3MemoExplication(this.parapheur.getPhrUser3MemoExplication() + this.utilDate.dateToStringFr(this.parapheur.getPhrUser3DteRep()) + " " + this.parapheur.getPhrUser3Explication() + "\n");
            }

            if (this.parapheur.getPhrUser4DteRep() != null && this.parapheur.getPhrUser4Explication() != null && !this.parapheur.getPhrUser4Explication().isEmpty()) {
               this.parapheur.setPhrUser4MemoExplication(this.parapheur.getPhrUser4MemoExplication() + this.utilDate.dateToStringFr(this.parapheur.getPhrUser4DteRep()) + " " + this.parapheur.getPhrUser4Explication() + "\n");
            }

            if (this.parapheur.getPhrUser5DteRep() != null && this.parapheur.getPhrUser5Explication() != null && !this.parapheur.getPhrUser5Explication().isEmpty()) {
               this.parapheur.setPhrUser5MemoExplication(this.parapheur.getPhrUser5MemoExplication() + this.utilDate.dateToStringFr(this.parapheur.getPhrUser5DteRep()) + " " + this.parapheur.getPhrUser5Explication() + "\n");
            }

            if (this.parapheur.getPhrUser6DteRep() != null && this.parapheur.getPhrUser6Explication() != null && !this.parapheur.getPhrUser6Explication().isEmpty()) {
               this.parapheur.setPhrUser6MemoExplication(this.parapheur.getPhrUser6MemoExplication() + this.utilDate.dateToStringFr(this.parapheur.getPhrUser6DteRep()) + " " + this.parapheur.getPhrUser6Explication() + "\n");
            }

            this.parapheur.setPhrUser1DteRep((Date)null);
            this.parapheur.setPhrUser2DteRep((Date)null);
            this.parapheur.setPhrUser3DteRep((Date)null);
            this.parapheur.setPhrUser4DteRep((Date)null);
            this.parapheur.setPhrUser5DteRep((Date)null);
            this.parapheur.setPhrUser6DteRep((Date)null);
            this.parapheur.setPhrUser1Explication("");
            this.parapheur.setPhrUser2Explication("");
            this.parapheur.setPhrUser3Explication("");
            this.parapheur.setPhrUser4Explication("");
            this.parapheur.setPhrUser5Explication("");
            this.parapheur.setPhrUser6Explication("");
            if (this.parapheur.getPhrId() == 0L) {
               this.parapheur = this.parapheurDao.insert(this.parapheur, var19);
            } else {
               this.parapheur = this.parapheurDao.modif(this.parapheur, var19);
            }
         }

         if (var2.getHabMailBloque() == 0 && StaticModePegase.getInternet_actif() != 0 && var11 != null && !var11.isEmpty() && var13 != null && !var13.isEmpty()) {
            File var21 = null;
            if (var18 == 0) {
               var18 = 1;
            }

            UtilNombre var22 = new UtilNombre();
            if (var8 == null || var8.isEmpty()) {
               var8 = this.structureLog.getStrdevise();
            }

            String var23 = var22.begin(var9, var8);
            var21 = this.creationPj(var3, var11, var23, var12, var13, var14, var15, var16, var17, (float)var18, var19);
            this.recupererEmetteur(var19);
            this.generationMail(var1, var3, var5, var2.getHabUser1Id(), var11, var21, var12, var19);
         }

         if (var20) {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public File creationPj(long var1, String var3, String var4, Tiers var5, String var6, String var7, JRBeanCollectionDataSource var8, String var9, int var10, float var11, Session var12) throws SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      File var13 = null;
      if (var3 != null && !var3.isEmpty()) {
         Object var14 = null;
         JasperPrint var15 = null;
         new ByteArrayOutputStream();
         Object var17 = null;
         HashMap var18 = new HashMap();
         File var19 = new File(StaticModePegase.getCheminContext());
         String var20 = "" + var19.getAbsoluteFile();
         String var21 = var20 + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "entete" + File.separator;
         String var22 = var20 + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "Users" + File.separator;
         Map var26 = this.Structure(var18, var7, var8, var4, var21, var22, var9, var10, var11, var12);
         var15 = JasperFillManager.fillReport(var6 + var3 + ".jasper", var26, var8);
         FacesContext var23 = FacesContext.getCurrentInstance();
         HttpServletResponse var24 = (HttpServletResponse)var23.getExternalContext().getResponse();
         String var25 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "mails" + File.separator + "envoi" + File.separator;
         if (var1 != 0L) {
            var13 = new File(var25 + var3 + "(" + var1 + ")" + ".pdf");
            if (var13.exists()) {
               var13.delete();
            }

            JasperExportManager.exportReportToPdfFile(var15, var25 + var3 + "(" + var1 + ")" + ".pdf");
         } else {
            var13 = new File(var25 + var3 + ".pdf");
            if (var13.exists()) {
               var13.delete();
            }

            JasperExportManager.exportReportToPdfFile(var15, var25 + var3 + ".pdf");
         }
      }

      return var13;
   }

   public File creationPj(long var1, String var3, String var4, Patients var5, String var6, String var7, JRBeanCollectionDataSource var8, String var9, int var10, float var11, Session var12) throws SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      File var13 = null;
      if (var3 != null && !var3.isEmpty()) {
         Object var14 = null;
         JasperPrint var15 = null;
         new ByteArrayOutputStream();
         Object var17 = null;
         HashMap var18 = new HashMap();
         File var19 = new File(StaticModePegase.getCheminContext());
         String var20 = "" + var19.getAbsoluteFile();
         String var21 = var20 + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "entete" + File.separator;
         String var22 = var20 + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "Users" + File.separator;
         Map var26 = this.Structure(var18, var7, var8, var4, var21, var22, var9, var10, var11, var12);
         var15 = JasperFillManager.fillReport(var6 + var3 + ".jasper", var26, var8);
         FacesContext var23 = FacesContext.getCurrentInstance();
         HttpServletResponse var24 = (HttpServletResponse)var23.getExternalContext().getResponse();
         String var25 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "mails" + File.separator + "envoi" + File.separator;
         if (var1 != 0L) {
            var13 = new File(var25 + var3 + "(" + var1 + ")" + ".pdf");
            if (var13.exists()) {
               var13.delete();
            }

            JasperExportManager.exportReportToPdfFile(var15, var25 + var3 + "(" + var1 + ")" + ".pdf");
         } else {
            var13 = new File(var25 + var3 + ".pdf");
            if (var13.exists()) {
               var13.delete();
            }

            JasperExportManager.exportReportToPdfFile(var15, var25 + var3 + ".pdf");
         }
      }

      return var13;
   }

   public void recupererEmetteur(Session var1) throws HibernateException, NamingException {
      this.bal = new Bal();
      this.bal = new Bal();
      this.bal.setBalssl(StaticModePegase.getSslEmmeteurSmp());
      this.bal.setBalsmtauthentification(StaticModePegase.getAuthentificationEmetteurSmp());
      this.bal.setBalsmtpserveur(StaticModePegase.getServeurEmetteurSmp());
      this.bal.setBalsmtpport(StaticModePegase.getPortEmetteurSmp());
      this.bal.setBaladressemail(StaticModePegase.getAdresseEmetteurSmp());
      this.bal.setBalpw(StaticModePegase.getPwEmetteurSmp());
      this.bal.setBaladressemailreponse((String)null);
   }

   public void generationMail(int var1, long var2, String var4, long var5, String var7, File var8, Tiers var9, Session var10) throws HibernateException, NamingException, Exception {
      if (this.bal != null) {
         new Users();
         Users var11 = this.usersDao.selectByIdUsers(var5, var10);
         if (var11 != null && var11.getUsrMailParapheur() == 0) {
            if (var11.getUsrMail() != null && !var11.getUsrMail().isEmpty() && var11.getUsrMail().contains("@")) {
               this.bal.setBaladressemailreponse(var11.getUsrMail());
            }

            String var12 = "";
            var12 = "<html><head></head><body ><h:form>";
            var12 = var12 + "<table style=\"border:1px dotted green\" align=\"center\" width=\"100%\">";
            var12 = var12 + "<thead></thead>";
            String var13 = "";
            var13 = var11.getUsrCivilite();
            if (var13.equals("")) {
               var13 = "Madame, Monsieur";
            }

            var12 = var12 + "<table><tbody><tr><td>Bonjour, " + var13 + ", <br/>" + "<br/>";
            var12 = var12 + "Demandeur : &nbsp; " + this.usersLog.getUsrCivilite() + " " + this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom() + " (" + this.usersLog.getUsrCollaboration() + ")" + "<br/>";
            var12 = var12 + "Type de document : &nbsp; " + var7 + ".pdf" + "<br/>";
            var12 = var12 + "N° de document : &nbsp; " + var4 + "<br/>";
            if (var9 != null) {
               var12 = var12 + "Tiers concerné : &nbsp; " + var9.getTieraisonsocialenom() + "<br/>" + "<br/>";
            }

            var12 = var12 + "Veuillez vous connecter &agrave; la plate forme e-P&eacute;gase avec vos identifiants afin de statuer sur cette demande.<br/><br/>";
            var12 = var12 + "Dans cette attente, veuillez agr&eacute;er, " + var13 + ", l'expressions de mes sentiments distingu&eacute;s. " + "<br/>" + "<br/>";
            var12 = var12 + "Cordialement, <br/>" + this.usersLog.getUsrPrenom() + "." + "<br/>";
            if (this.usersLog.getUsrFonction() != null && !this.usersLog.getUsrFonction().isEmpty()) {
               var12 = var12 + this.usersLog.getUsrFonction() + "<br/>";
            }

            var12 = var12 + "<br/><i style=\"color:red;font-size:11px;\">Ce message vous est ";
            var12 = var12 + "envoy&eacute; automatiquement &agrave; partir de la plateforme de gestion e-P&eacute;gase (https://www.e-pegase.biz/epegase/).</i></td></tr><tr><td></td></tr></tbody></table>";
            if (this.bal != null && this.bal.getBalSignature() != null) {
               var12 = var12 + "<br/><br/>" + this.bal.getBalSignature();
            } else {
               var12 = var12 + "---";
            }

            var12 = var12 + "</h:form></body></html>";
            UtilMail var14 = new UtilMail(this.structureLog);
            ArrayList var15 = new ArrayList();
            if (var8 != null) {
               var15.add(var8);
            }

            String var16 = "";
            var14.sendMail(var12, var11.getUsrMail(), this.bal.getBaladressemail(), "", "", var16, "DOCUMENT A VALIDER", this.bal, var15);
         }
      }

   }

   public void generationMail(int var1, long var2, String var4, long var5, String var7, File var8, Patients var9, Session var10) throws HibernateException, NamingException, Exception {
      if (this.bal != null) {
         new Users();
         Users var11 = this.usersDao.selectByIdUsers(var5, var10);
         if (var11 != null && var11.getUsrMailParapheur() == 0) {
            if (var11.getUsrMail() != null && !var11.getUsrMail().isEmpty() && var11.getUsrMail().contains("@")) {
               this.bal.setBaladressemailreponse(var11.getUsrMail());
            }

            String var12 = "";
            var12 = "<html><head></head><body ><h:form>";
            var12 = var12 + "<table style=\"border:1px dotted green\" align=\"center\" width=\"100%\">";
            var12 = var12 + "<thead></thead>";
            String var13 = "";
            var13 = var11.getUsrCivilite();
            if (var13.equals("")) {
               var13 = "Madame, Monsieur";
            }

            var12 = var12 + "<table><tbody><tr><td>Bonjour, " + var13 + ", <br/>" + "<br/>";
            var12 = var12 + "Demandeur : &nbsp; " + this.usersLog.getUsrCivilite() + " " + this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom() + " (" + this.usersLog.getUsrCollaboration() + ")" + "<br/>";
            var12 = var12 + "Type de document : &nbsp; " + var7 + ".pdf" + "<br/>";
            var12 = var12 + "N° de document : &nbsp; " + var4 + "<br/>";
            if (var9 != null) {
               var12 = var12 + "Patient concerné : &nbsp; " + var9.getPatronyme() + "<br/>" + "<br/>";
            }

            var12 = var12 + "Veuillez vous connecter &agrave; la plate forme e-P&eacute;gase avec vos identifiants afin de statuer sur cette demande.<br/><br/>";
            var12 = var12 + "Dans cette attente, veuillez agr&eacute;er, " + var13 + ", l'expressions de mes sentiments distingu&eacute;s. " + "<br/>" + "<br/>";
            var12 = var12 + "Cordialement, <br/>" + this.usersLog.getUsrPrenom() + "." + "<br/>";
            if (this.usersLog.getUsrFonction() != null && !this.usersLog.getUsrFonction().isEmpty()) {
               var12 = var12 + this.usersLog.getUsrFonction() + "<br/>";
            }

            var12 = var12 + "<br/><i style=\"color:red;font-size:11px;\">Ce message vous est ";
            var12 = var12 + "envoy&eacute; automatiquement &agrave; partir de la plateforme de gestion e-P&eacute;gase (https://www.e-pegase.biz/epegase/).</i></td></tr><tr><td></td></tr></tbody></table>";
            if (this.bal != null && this.bal.getBalSignature() != null) {
               var12 = var12 + "<br/><br/>" + this.bal.getBalSignature();
            } else {
               var12 = var12 + "---";
            }

            var12 = var12 + "</h:form></body></html>";
            UtilMail var14 = new UtilMail(this.structureLog);
            ArrayList var15 = new ArrayList();
            if (var8 != null) {
               var15.add(var8);
            }

            String var16 = "";
            var14.sendMail(var12, var11.getUsrMail(), this.bal.getBaladressemail(), "", "", var16, "DOCUMENT A VALIDER", this.bal, var15);
         }
      }

   }

   public Map Structure(Map var1, String var2, JRBeanCollectionDataSource var3, String var4, String var5, String var6, String var7, int var8, float var9, Session var10) throws HibernateException, NamingException {
      var1.put("IS_IGNORE_PAGINATION", false);
      var1.put("version", StaticModePegase.getCompil_version().subSequence(0, 4));
      JRFileVirtualizer var11 = new JRFileVirtualizer(1000, System.getProperty("user.dir"));
      var1.put("REPORT_VIRTUALIZER", var11);
      var1.put("SUBREPORT_DIR", var2);
      var1.put("entete", this.structureLog.getStrraisonsociale());
      var1.put("filtre", "");
      var1.put("exercice", "");
      var1.put("dateDeb", "");
      var1.put("dateFin", "");
      var1.put("dateDebUk", "");
      var1.put("dateFinUk", "");
      var1.put("journal", "");
      var1.put("compte", "");
      var1.put("requete", "");
      var1.put("nbst", var8);
      var1.put("taux", var9);
      var1.put("page_init", "");
      var1.put("etat_init", "");
      var1.put("montant_lettre", var4);
      var1.put("totauxHt", "0");
      var1.put("totauxTaxe", "0");
      var1.put("totauxTtc", "0");
      var1.put("pageGarde", "");
      var1.put("annexe1", "");
      var1.put("annexe2", "");
      var1.put("valeur1", "");
      var1.put("valeur2", "");
      var1.put("listeJava", var3);
      var1.put("parcChassis", var7);
      var1.put("id", this.structureLog.getStrid());
      var1.put("date_creation", this.structureLog.getStrdtecreat());
      var1.put("date_modification", this.structureLog.getStrdtemodif());
      var1.put("user_creation", this.structureLog.getStrusercreat());
      var1.put("user_modification", this.structureLog.getStrusermodif());
      var1.put("etat", this.structureLog.getStretat());
      var1.put("mode", this.structureLog.getStrmode());
      var1.put("societe", this.structureLog.getStrraisonsociale());
      var1.put("sigle", this.structureLog.getStrsigle());
      var1.put("nom_pays", this.structureLog.getStrnompays());
      var1.put("code_pays", this.structureLog.getStrcodepays());
      var1.put("devise", this.structureLog.getStrdevise());
      var1.put("formatDevise", this.structureLog.getStrformatdevise());
      var1.put("langue", this.structureLog.getStrlangue());
      var1.put("zone_fiscale", this.structureLog.getStrzonefiscale());
      var1.put("zone_commerciale", this.structureLog.getStrzonecommerciale());
      var1.put("format_date", this.structureLog.getStrformatdate());
      var1.put("format_heure", this.structureLog.getStrformatheure());
      var1.put("heure_debut", this.structureLog.getStrHrDeb() + ":" + this.structureLog.getStrMnDeb());
      var1.put("heure_fin", this.structureLog.getStrHrFin() + ":" + this.structureLog.getStrMnFin());
      var1.put("pas_horaire", this.structureLog.getStrHrPas() + ":" + this.structureLog.getStrMnPas());
      var1.put("forme_juridique", this.structureLog.getStrformejuridique());
      var1.put("type_entreprise", this.structureLog.getStrtypeentreprise());
      var1.put("adresse", this.structureLog.getStradresse());
      var1.put("rue", this.structureLog.getStrrue());
      var1.put("lot", this.structureLog.getStrlot());
      var1.put("porte", this.structureLog.getStrporte());
      var1.put("quartier", this.structureLog.getStrquartier());
      var1.put("ville", this.structureLog.getStrville());
      var1.put("commune", this.structureLog.getStrcommune());
      var1.put("departement", this.structureLog.getStrdepartement());
      var1.put("zone", this.structureLog.getStrzone());
      var1.put("batiment", this.structureLog.getStrbatiment());
      var1.put("etage", this.structureLog.getStretage());
      var1.put("boite_postale", this.structureLog.getStrbp());
      var1.put("cedex", this.structureLog.getStrcedex());
      var1.put("telephone_1", this.structureLog.getStrtel1());
      var1.put("telephone_2", this.structureLog.getStrtel2());
      var1.put("telephone_3", this.structureLog.getStrtel3());
      var1.put("fax", this.structureLog.getStrfax());
      var1.put("telex", this.structureLog.getStrtelex());
      var1.put("site_web", this.structureLog.getStrsitewzb());
      var1.put("repertoire", this.structureLog.getStrrepertoire());
      var1.put("identification_1", this.structureLog.getStrnum1());
      var1.put("identification_2", this.structureLog.getStrnum2());
      var1.put("identification_3", this.structureLog.getStrnum3());
      var1.put("identification_4", this.structureLog.getStrnum4());
      var1.put("identification_5", this.structureLog.getStrnum5());
      var1.put("identification_6", this.structureLog.getStrnum6());
      var1.put("identification_7", this.structureLog.getStrnum7());
      var1.put("identification_8", this.structureLog.getStrnum8());
      var1.put("identification_9", this.structureLog.getStrnum9());
      var1.put("identification_10", this.structureLog.getStrnum10());
      var1.put("identification_11", this.structureLog.getStrnum11());
      var1.put("identification_12", this.structureLog.getStrnum12());
      var1.put("identification_13", this.structureLog.getStrnum13());
      var1.put("identification_14", this.structureLog.getStrnum14());
      var1.put("identification_15", this.structureLog.getStrnum15());
      var1.put("identification_16", this.structureLog.getStrnum16());
      var1.put("identification_17", this.structureLog.getStrnum17());
      var1.put("identification_18", this.structureLog.getStrnum18());
      var1.put("identification_19", this.structureLog.getStrnum19());
      var1.put("identification_20", this.structureLog.getStrnum20());
      if (this.structureLog.getStrLogo1() != null && !this.structureLog.getStrLogo1().isEmpty()) {
         var1.put("logo_1", var5 + this.structureLog.getStrLogo1());
      } else {
         var1.put("logo_1", (Object)null);
      }

      if (this.structureLog.getStrLogo2() != null && !this.structureLog.getStrLogo2().isEmpty()) {
         var1.put("logo_2", var5 + this.structureLog.getStrLogo2());
      } else {
         var1.put("logo_2", (Object)null);
      }

      if (this.structureLog.getStrLogo3() != null && !this.structureLog.getStrLogo3().isEmpty()) {
         var1.put("logo_3", var5 + this.structureLog.getStrLogo3());
      } else {
         var1.put("logo_3", (Object)null);
      }

      if (this.structureLog.getStrLogo4() != null && !this.structureLog.getStrLogo4().isEmpty()) {
         var1.put("logo_4", var5 + this.structureLog.getStrLogo4());
      } else {
         var1.put("logo_4", (Object)null);
      }

      var1.put("mails", this.usersLog.getUsrMail());
      var1.put("banques", this.banquesStructure(var10));
      var1.put("signe_nom", this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      var1.put("signe_fonction", this.usersLog.getUsrFonction());
      var1.put("signe_civilite", this.usersLog.getUsrCivilite());
      if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
         var1.put("signe_signature", var6 + this.usersLog.getUsrSignature());
      } else {
         var1.put("signe_signature", (Object)null);
      }

      var1.put("signe_mail", this.usersLog.getUsrMail());
      return var1;
   }

   public String banquesStructure(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      ContactDao var3 = new ContactDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var4 = var3.chargerLesContactsBq(var1);
      if (var4.size() > 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            new Contacts();
            Contacts var6 = (Contacts)var4.get(var5);
            if (var6.getConiban() != null && !var6.getConiban().isEmpty()) {
               var2 = var6.getTiers().getTieraisonsocialenom() + " N° Compte : " + var6.getConnumbanque() + " " + var6.getConguichetbanque() + " " + var6.getConcomptebanque() + ":" + var6.getConclebanque() + " IBAN " + var6.getConiban();
            } else {
               var2 = var6.getTiers().getTieraisonsocialenom() + " N° Compte : " + var6.getConnumbanque() + " " + var6.getConguichetbanque() + " " + var6.getConcomptebanque() + ":" + var6.getConclebanque();
            }
         }
      }

      return var2;
   }

   public void supprimerParapheur(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parapheur");
         var5 = true;
      }

      Parapheur var6 = this.parapheurDao.existenceParapheur(var1, var3, var4);
      if (var6 != null) {
         this.parapheurDao.delete(var6, var4);
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

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

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public Parapheur getParapheur() {
      return this.parapheur;
   }

   public void setParapheur(Parapheur var1) {
      this.parapheur = var1;
   }
}
