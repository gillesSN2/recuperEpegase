package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.accueil.FormAccueil;
import com.epegase.forms.accueil.FormGuest;
import com.epegase.forms.accueil.FormHelpDesk;
import com.epegase.forms.accueil.FormMonCompte;
import com.epegase.forms.accueil.FormRss;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.RdvDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.menu.MenudroitAccueilCtrl;
import com.epegase.systeme.menu.MenudroitGuestCtrl;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LecturePays;
import com.epegase.systeme.xml.LectureVillesMeteo;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.ObjetPays;
import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;

public class FormBakingBeanAccueil implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private ObjetLigneMenu menuaccueil;
   private LectureModulesOnglets lesOnglets;
   private MenudroitAccueilCtrl menudroitAccueilCtrl;
   private String affichePage;
   private UserDao userDao;
   private TiersDao tiersDao;
   private RdvDao rdvDao;
   private FormAccueil formAccueil;
   private FormMonCompte formMonCompte;
   private FormRss formRss;
   private FormHelpDesk formHelpDesk;
   private MenudroitGuestCtrl menudroitGuestCtrl;
   private FormGuest formGuest;
   private List lesStructuresPeg;

   public FormBakingBeanAccueil() throws IOException, JDOMException, SAXException, SQLException {
   }

   public void InstancesDaoUtilses() throws IOException, SAXException, JDOMException, ParseException {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.rdvDao = new RdvDao(this.baseLog, this.utilInitHibernate);
   }

   public void menuGaucheAccueil() throws JDOMException, IOException {
      if (this.menudroitAccueilCtrl == null) {
         this.menudroitAccueilCtrl = new MenudroitAccueilCtrl();
         this.menudroitAccueilCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitAccueilCtrl.chargerMenuAccueilXml(this.usersLog.getUsrCollaboration(), this.structureLog.getStrid());
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("10000", this.usersLog.getUsrCollaboration());
   }

   public void razMemoire() {
      this.formAccueil = null;
      this.formGuest = null;
      this.formHelpDesk = null;
      this.formMonCompte = null;
      this.formRss = null;
   }

   public void accueil(Session var1, String var2, int var3) throws UnknownHostException, HibernateException, NamingException, IOException, ParseException {
      this.formAccueil = new FormAccueil();
      this.formAccueil.setutilInitHibernate(this.utilInitHibernate);
      this.formAccueil.setBaseLog(this.baseLog);
      this.formAccueil.setStructureLog(this.structureLog);
      this.formAccueil.setUsersLog(this.usersLog);
      this.formAccueil.InstancesDaoUtilses();
      this.formAccueil.accueil(var1, var2, var3);
      this.formAccueil.setTypeVente(this.typeVente);
   }

   public void monCompte(Session var1) throws IOException, JDOMException, SAXException, SQLException {
      this.razMemoire();
      this.formMonCompte = new FormMonCompte();
      this.formMonCompte.setutilInitHibernate(this.utilInitHibernate);
      this.formMonCompte.setBaseLog(this.baseLog);
      this.formMonCompte.setStructureLog(this.structureLog);
      this.formMonCompte.setUsersLog(this.usersLog);
      this.formMonCompte.InstancesDaoUtilses();
      this.formMonCompte.recupererCivilitesItem();
      this.formMonCompte.recupererFonctionsItem();
      this.formMonCompte.recupererPaysItem();
      this.formMonCompte.recupererLangueItem();
      this.formMonCompte.setLesStructuresPeg(this.lesStructuresPeg);
      this.formMonCompte.affichePhoto();
      this.affichePage = "/accueil/compte.jsp";
   }

   public void gestionAccueil() throws JDOMException, IOException, SAXException, HibernateException, NamingException {
      this.razMemoire();
      this.menuaccueil = new ObjetLigneMenu();
      if (this.menudroitAccueilCtrl.getDataModelMenudroitAccueilXmlList().isRowAvailable()) {
         this.menuaccueil = (ObjetLigneMenu)this.menudroitAccueilCtrl.getDataModelMenudroitAccueilXmlList().getRowData();
         if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:01")) {
            this.affichePage = "/accueil/accueil.jsp";
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:02")) {
            this.affichePage = "/accueil/rss.jsp";
            this.lectureFlux();
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:03")) {
            this.affichePage = "/accueil/meteo.jsp";
            this.calculAccesMeteo();
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:04")) {
            this.affichePage = "/accueil/histoirePegase.jsp";
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:05")) {
            this.affichePage = "/accueil/normes.jsp";
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:06")) {
            this.affichePage = "/accueil/infos.jsp";
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:07")) {
            this.affichePage = "/accueil/googleMap.jsp";
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:08")) {
            this.affichePage = "/accueil/wikipedia.jsp";
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:09")) {
            this.affichePage = "/accueil/traficMaritime.jsp";
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:10")) {
            this.affichePage = "/accueil/traficAerien.jsp";
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:11")) {
            this.affichePage = "/accueil/devises.jsp";
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:12")) {
            this.affichePage = "/accueil/douane.jsp";
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:13")) {
            this.affichePage = "/accueil/horoscope.jsp";
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:14")) {
            this.affichePage = "/accueil/keepcool.jsp";
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:15")) {
            this.affichePage = "/accueil/helpDeskPep.jsp";
            this.helpDeskPep();
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:16")) {
            this.affichePage = "/accueil/statistiquesStite.jsp";
         } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:17")) {
            this.affichePage = "/accueil/histoireHorus.jsp";
         }
      }

   }

   public void menuGaucheGuest() throws JDOMException, IOException {
      if (this.menudroitGuestCtrl == null) {
         this.menudroitGuestCtrl = new MenudroitGuestCtrl();
         this.menudroitGuestCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("GST");
         }

         this.menudroitGuestCtrl.chargerMenuGuestXml(this.usersLog.getUsrCollaboration());
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("00300", this.usersLog.getUsrCollaboration());
   }

   public void guest(Session var1, String var2, int var3) throws UnknownHostException, HibernateException, NamingException, IOException {
      this.formGuest = new FormGuest();
      this.formGuest.setUtilInitHibernate(this.utilInitHibernate);
      this.formGuest.setBaseLog(this.baseLog);
      this.formGuest.setStructureLog(this.structureLog);
      this.formGuest.setUsersLog(this.usersLog);
      this.formGuest.InstancesDaoUtilses();
      this.formGuest.guest(var1, var2, var3);
      this.formGuest.setTypeVente(this.typeVente);
   }

   public void gestionGuest() throws JDOMException, IOException, SAXException, HibernateException, NamingException, UnknownHostException, ParseException {
      this.razMemoire();
      this.menuaccueil = new ObjetLigneMenu();
      if (this.menudroitGuestCtrl.getDataModelMenudroitGuestXmlList().isRowAvailable()) {
         this.menuaccueil = (ObjetLigneMenu)this.menudroitGuestCtrl.getDataModelMenudroitGuestXmlList().getRowData();
         if (this.menuaccueil.getLibelle_FR() != null && !this.menuaccueil.getLibelle_FR().isEmpty()) {
            if (this.menuaccueil.getCommande().equalsIgnoreCase("00300:01")) {
               this.affichePage = "/guest/guestInfo.jsp";
               this.guestInfo();
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("00300:02")) {
               this.affichePage = "/guest/guestRib.jsp";
               this.guestRib();
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("00300:03")) {
               this.affichePage = "/guest/guestCommande.jsp";
               this.guestCommande();
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("00300:04")) {
               this.affichePage = "/guest/guestFacture.jsp";
               this.guestFacture();
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("00300:05")) {
               this.affichePage = "/guest/guestReglement.jsp";
               this.guestReglement();
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("00300:06")) {
               this.affichePage = "/guest/guestCompte.jsp";
               this.guestCompte();
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:03")) {
               this.affichePage = "/accueil/meteo.jsp";
               this.calculAccesMeteo();
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:04")) {
               this.affichePage = "/accueil/histoirePegase.jsp";
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:05")) {
               this.affichePage = "/accueil/normes.jsp";
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:06")) {
               this.affichePage = "/accueil/infos.jsp";
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:07")) {
               this.affichePage = "/accueil/googleMap.jsp";
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:08")) {
               this.affichePage = "/accueil/wikipedia.jsp";
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:09")) {
               this.affichePage = "/accueil/traficMaritime.jsp";
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:10")) {
               this.affichePage = "/accueil/traficAerien.jsp";
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:11")) {
               this.affichePage = "/accueil/devises.jsp";
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:12")) {
               this.affichePage = "/accueil/douane.jsp";
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:13")) {
               this.affichePage = "/accueil/horoscope.jsp";
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:14")) {
               this.affichePage = "/accueil/keepcool.jsp";
            } else if (this.menuaccueil.getCommande().equalsIgnoreCase("10000:17")) {
               this.affichePage = "/accueil/histoireHorus.jsp";
            }
         }
      }

   }

   public void lectureFlux() throws HibernateException, NamingException {
      this.razMemoire();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      this.formRss = new FormRss();
      this.formRss.setutilInitHibernate(this.utilInitHibernate);
      this.formRss.setMaBase(this.baseLog);
      this.formRss.setStructurelog(this.structureLog);
      this.formRss.setUsers(this.usersLog);
      this.formRss.InstancesDaoUtilses();
      this.formRss.lectureFluxUser(var1);
      this.utilInitHibernate.closeSession();
   }

   public void calculAccesMeteo() throws HibernateException, NamingException {
      ObjetPays var2;
      StructureDao var3;
      if (this.structureLog.getStrisopays() == null || this.structureLog.getStrisopays().isEmpty()) {
         LecturePays var1 = new LecturePays();
         new ObjetPays();
         var2 = var1.trouvePays(this.structureLog.getStrcodepays());
         var3 = new StructureDao(this.baseLog, this.utilInitHibernate);
         this.structureLog.setStrisopays(var2.getIso());
         this.structureLog = var3.modStructure(this.structureLog);
      }

      if (this.structureLog.getStrMeteoCodeVille() == 0) {
         LectureVillesMeteo var4 = new LectureVillesMeteo();
         new ObjetPays();
         var2 = var4.trouveVilles(this.structureLog.getStrville().toUpperCase());
         if (var2 != null && var2.getIdentification() != null && !var2.getIdentification().isEmpty()) {
            var3 = new StructureDao(this.baseLog, this.utilInitHibernate);
            this.structureLog.setStrMeteoCodeVille(Integer.parseInt(var2.getIdentification()));
            this.structureLog = var3.modStructure(this.structureLog);
         }
      }

   }

   public void helpDeskPep() throws HibernateException, NamingException {
      this.razMemoire();
      Session var1 = this.utilInitHibernate.getSysteme();
      this.formHelpDesk = new FormHelpDesk();
      this.formHelpDesk.setUtilInitHibernate(this.utilInitHibernate);
      this.formHelpDesk.setBaseLog(this.baseLog);
      this.formHelpDesk.setStructureLog(this.structureLog);
      this.formHelpDesk.setUsersLog(this.usersLog);
      this.formHelpDesk.InstancesDaoUtilses();
      this.formHelpDesk.chargerIntervenants(var1);
      this.formHelpDesk.rechercheTicketsPep(var1);
      this.utilInitHibernate.closeSession();
   }

   public void guestInfo() throws UnknownHostException {
      this.formGuest = new FormGuest();
      this.formGuest.setUsersLog(this.usersLog);
      this.formGuest.setStructureLog(this.structureLog);
      this.formGuest.setBaseLog(this.baseLog);
      this.formGuest.setUtilInitHibernate(this.utilInitHibernate);
   }

   public void guestRib() {
   }

   public void guestCommande() throws UnknownHostException, ParseException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Site");
      this.formGuest = new FormGuest();
      this.formGuest.setUsersLog(this.usersLog);
      this.formGuest.setStructureLog(this.structureLog);
      this.formGuest.setBaseLog(this.baseLog);
      this.formGuest.setUtilInitHibernate(this.utilInitHibernate);
      this.formGuest.InstancesDaoUtilses();
      this.formGuest.iniCommande(var1);
      this.utilInitHibernate.closeSession();
   }

   public void guestFacture() throws UnknownHostException, ParseException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Site");
      this.formGuest = new FormGuest();
      this.formGuest.setUsersLog(this.usersLog);
      this.formGuest.setStructureLog(this.structureLog);
      this.formGuest.setBaseLog(this.baseLog);
      this.formGuest.setUtilInitHibernate(this.utilInitHibernate);
      this.formGuest.InstancesDaoUtilses();
      this.formGuest.iniFacture(var1);
      this.utilInitHibernate.closeSession();
   }

   public void guestReglement() throws UnknownHostException, ParseException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Site");
      this.formGuest = new FormGuest();
      this.formGuest.setUsersLog(this.usersLog);
      this.formGuest.setStructureLog(this.structureLog);
      this.formGuest.setBaseLog(this.baseLog);
      this.formGuest.setUtilInitHibernate(this.utilInitHibernate);
      this.formGuest.InstancesDaoUtilses();
      this.formGuest.iniReglement(var1);
      this.utilInitHibernate.closeSession();
   }

   public void guestCompte() throws UnknownHostException, ParseException, HibernateException, NamingException, IOException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Site");
      this.formGuest = new FormGuest();
      this.formGuest.setUsersLog(this.usersLog);
      this.formGuest.setStructureLog(this.structureLog);
      this.formGuest.setBaseLog(this.baseLog);
      this.formGuest.setUtilInitHibernate(this.utilInitHibernate);
      this.formGuest.InstancesDaoUtilses();
      this.formGuest.iniExtrait(var1);
      this.utilInitHibernate.closeSession();
   }

   public FormAccueil getFormAccueil() {
      return this.formAccueil;
   }

   public void setFormAccueil(FormAccueil var1) {
      this.formAccueil = var1;
   }

   public LectureModulesOnglets getLesOnglets() {
      return this.lesOnglets;
   }

   public void setLesOnglets(LectureModulesOnglets var1) {
      this.lesOnglets = var1;
   }

   public ObjetLigneMenu getMenuaccueil() {
      return this.menuaccueil;
   }

   public void setMenuaccueil(ObjetLigneMenu var1) {
      this.menuaccueil = var1;
   }

   public MenudroitAccueilCtrl getMenudroitAccueilCtrl() {
      return this.menudroitAccueilCtrl;
   }

   public void setMenudroitAccueilCtrl(MenudroitAccueilCtrl var1) {
      this.menudroitAccueilCtrl = var1;
   }

   public String getAffichePage() {
      return this.affichePage;
   }

   public void setAffichePage(String var1) {
      this.affichePage = var1;
   }

   public FormMonCompte getFormMonCompte() {
      return this.formMonCompte;
   }

   public void setFormMonCompte(FormMonCompte var1) {
      this.formMonCompte = var1;
   }

   public FormRss getFormRss() {
      return this.formRss;
   }

   public void setFormRss(FormRss var1) {
      this.formRss = var1;
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

   public UtilInitHibernate getInitHibernateSessionFactory_2() {
      return this.utilInitHibernate;
   }

   public void setutilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public MenudroitGuestCtrl getMenudroitGuestCtrl() {
      return this.menudroitGuestCtrl;
   }

   public void setMenudroitGuestCtrl(MenudroitGuestCtrl var1) {
      this.menudroitGuestCtrl = var1;
   }

   public FormGuest getFormGuest() {
      return this.formGuest;
   }

   public void setFormGuest(FormGuest var1) {
      this.formGuest = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public List getLesStructuresPeg() {
      return this.lesStructuresPeg;
   }

   public void setLesStructuresPeg(List var1) {
      this.lesStructuresPeg = var1;
   }
}
