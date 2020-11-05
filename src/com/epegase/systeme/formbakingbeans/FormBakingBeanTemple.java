package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.administration.FormExercicesVentes;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.menu.MenudroitTempleCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureConfigListeEntete;
import com.epegase.systeme.xml.LectureConfigListeLigne;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionConfigListe;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.SAXException;

public class FormBakingBeanTemple implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private FormRecherche formRecherche;
   private MenudroitTempleCtrl menudroitTempleCtrl;
   private ObjetLigneMenu menutemple;
   private ObjetLigneMenu menutempleMemo = new ObjetLigneMenu();
   private LectureModulesOnglets lesOnglets;
   private List mesEtatsItems = new ArrayList();
   private List mesPeriodesItems = new ArrayList();
   private EtatDocument etatDocument = new EtatDocument();
   private int nature;
   private OptionVentes optionVentes;
   private Habilitation habilitation;
   private ExercicesVentes exoselectionne = new ExercicesVentes();
   private ExercicesVentes lastExercice = new ExercicesVentes();
   private long leIdExo;
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private Chrono chrono;
   private ChronoDao chronoDao;
   private String messageAlerte;
   private FormExercicesVentes formExercicesVentes;
   private List documentImpressionItems;
   private List listeImpressionItems;
   private LectureModeleAutorise lectureModeleAutorise;
   private List lesModelesAutorises;
   private String configListeEntete;
   private String configListeLigne;

   public FormBakingBeanTemple() throws IOException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererExercices(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      this.leIdExo = this.exoselectionne.getExevteId();
      this.lastExercice = var2.recupererLastExo(var1);
   }

   public void recupererLeIdExo() throws HibernateException, NamingException {
      this.recupererLeIdExo((Session)null);
   }

   public ExercicesVentes recupererLeIdExo(Session var1) throws NamingException {
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      if (this.leIdExo != 0L) {
         this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      } else {
         this.exoselectionne = var2.recupererLastExo(var1);
      }

      this.leIdExo = this.exoselectionne.getExevteId();
      return this.exoselectionne;
   }

   public List getLesExercicVentes(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      this.formExercicesVentes = new FormExercicesVentes();
      this.formExercicesVentes.InstancesDaoUtilses();
      return this.formExercicesVentes.recupererLesexercices(var1);
   }

   public void menuGaucheTemple() throws JDOMException, IOException {
      if (this.menudroitTempleCtrl == null) {
         this.menudroitTempleCtrl = new MenudroitTempleCtrl();
         this.menudroitTempleCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitTempleCtrl.chargerMenuGaucheParcsXml(this.usersLog.getUsrCollaboration());
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("81200", this.usersLog.getUsrCollaboration());
   }

   public void gestionTemple() throws JDOMException, IOException, NamingException, HibernateException, ParseException {
      this.menutemple = new ObjetLigneMenu();
      if (this.menudroitTempleCtrl.getDataModelMenudroitTempleXmlList().isRowAvailable()) {
         this.menutemple = (ObjetLigneMenu)this.menudroitTempleCtrl.getDataModelMenudroitTempleXmlList().getRowData();
         if (this.menutemple.getLibelle_FR() != null && !this.menutemple.getLibelle_FR().isEmpty()) {
            this.menutempleMemo = this.menutemple;
            this.aiguillageTemple();
         }
      }

   }

   public void razMemoire() {
   }

   public void gestionTempleFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, ParseException {
      this.menutemple = var1;
      this.menutempleMemo = this.menutemple;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         this.menuGaucheTemple();
      }

      this.aiguillageTemple();
   }

   public void aiguillageTemple() throws JDOMException, IOException, NamingException, HibernateException, ParseException {
      if (this.lastExercice.getExevteId() != this.exoselectionne.getExevteId()) {
         this.menutemple.setAdd(false);
         this.menutemple.setMaj(false);
         this.menutemple.setSup(false);
         this.menutemple.setDup(false);
         this.menutemple.setClo(false);
         this.menutemple.setTrf(false);
         this.menutemple.setImp(true);
      } else {
         this.menutemple.setAdd(this.menutempleMemo.isAdd());
         this.menutemple.setMaj(this.menutempleMemo.isMaj());
         this.menutemple.setSup(this.menutempleMemo.isSup());
         this.menutemple.setDup(this.menutempleMemo.isDup());
         this.menutemple.setClo(this.menutempleMemo.isClo());
         this.menutemple.setTrf(this.menutempleMemo.isTrf());
         this.menutemple.setImp(this.menutempleMemo.isImp());
      }

      this.razMemoire();
      if (this.menutemple.getCommande().equalsIgnoreCase("81200:01")) {
         this.affichePage = "/parc/ParcListeInit.jsp";
      } else if (this.menutemple.getCommande().equalsIgnoreCase("81200:06")) {
         this.nature = 44;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LocalisationParc");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            String var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/parc/LocalisationGpsInit.jsp";
            } else {
               this.affichePage = "/parc/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/parc/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menutemple.getCommande().equalsIgnoreCase("81200:90")) {
         this.affichePage = "/parc/ImpressionParc.jsp";
         this.menuImpressionTemple();
      } else if (this.menutemple.getCommande().equalsIgnoreCase("81200:99")) {
         this.affichePage = "/parc/SelectionExercicesParc.jsp";
         this.menuSelectionExercicesTemple();
      }

   }

   public void menuListeTemple() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc");
      this.utilInitHibernate.closeSession();
   }

   public void menuImpressionTemple() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc");
      this.utilInitHibernate.closeSession();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuSelectionExercicesTemple() throws IOException, JDOMException, NamingException {
      this.formExercicesVentes = new FormExercicesVentes();
      this.formExercicesVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesVentes.setBaseLog(this.baseLog);
      this.formExercicesVentes.setStructureLog(this.structureLog);
      this.formExercicesVentes.setUsersLog(this.usersLog);
      this.formExercicesVentes.InstancesDaoUtilses();
      this.leIdExo = this.exoselectionne.getExevteId();
      this.formExercicesVentes.setLesexercicesVentes(this.formExercicesVentes.recupererLesexercices((Session)null));
   }

   public void recupererTousLesItems(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererModelesAutorises();
      this.recupererModeleFicheProduit();
      this.recupererModeleListeProduit();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void recupererLesItemsImpression(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
   }

   public void recupererOptionsVentes() {
   }

   public void recupererModelesAutorises() {
      this.lesModelesAutorises = new ArrayList();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "temple" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "temple" + File.separator + "configuration" + File.separator + this.usersLog.getGroupe().getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.lesModelesAutorises = this.lectureModeleAutorise.getLesModelesAutorises();
      }

   }

   public void recupererModeleFicheProduit() {
      String var1 = "";
      if (this.nature == 40) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "transport_personnel" + File.separator;
      } else if (this.nature == 41) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "transport_materiel" + File.separator;
      } else if (this.nature == 42) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "travaux_public" + File.separator;
      } else if (this.nature == 43) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "location" + File.separator;
      } else if (this.nature == 44) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "localisation" + File.separator;
      } else if (this.nature == 45) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "consommation" + File.separator;
      } else if (this.nature == 46) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "or" + File.separator;
      } else {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "parc" + File.separator;
      }

      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.documentImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4];
               if (this.verificationAutorisation(var5)) {
                  String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.documentImpressionItems.add(new SelectItem(var6));
               }
            }
         }
      }

   }

   public void recupererModeleListeProduit() {
      String var1 = "";
      if (this.nature == 40) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "transport_personnel" + File.separator;
      } else if (this.nature == 41) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "transport_materiel" + File.separator;
      } else if (this.nature == 42) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "travaux_public" + File.separator;
      } else if (this.nature == 43) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "location" + File.separator;
      } else if (this.nature == 44) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "localisation" + File.separator;
      } else if (this.nature == 45) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "consommation" + File.separator;
      } else if (this.nature == 46) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "or" + File.separator;
      } else {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "parc" + File.separator;
      }

      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4];
               if (this.verificationAutorisation(var5)) {
                  String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.listeImpressionItems.add(new SelectItem(var6));
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

   public void recupererConfigListeEntete() throws IOException {
      LectureConfigListeEntete var1 = new LectureConfigListeEntete();
      var1.recupereFonctions(this.structureLog.getStrid(), this.nature, "");
      this.configListeEntete = var1.getConfigListeEntete();
   }

   public void memoriseConfigListeEntete() throws IOException {
      LectureConfigListeEntete var1 = new LectureConfigListeEntete();
      String var2 = var1.calculeFichierConfig(this.structureLog.getStrid(), this.nature, "");
      if (var2 != null && !var2.isEmpty()) {
         Element var3 = new Element("configuration");
         Document var4 = new Document(var3);
         var3.removeContent();
         OptionConfigListe var5 = new OptionConfigListe();
         var5.setConfiguration(this.configListeEntete);
         Element var6 = new Element("configListe");
         var3.addContent(var6);
         var6.setText(var5.getConfiguration());
         XMLOutputter var7 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var8 = new FileOutputStream(StaticModePegase.getCheminContext() + var2);
         var7.output(var4, var8);
         var8.close();
      }

   }

   public void recupererConfigListeLigne() throws IOException {
      LectureConfigListeLigne var1 = new LectureConfigListeLigne();
      var1.recupereFonctions(this.structureLog.getStrid(), this.nature, "");
      this.configListeLigne = var1.getConfigListeLigne();
   }

   public void memoriseConfigListeLigne() throws IOException {
      LectureConfigListeLigne var1 = new LectureConfigListeLigne();
      String var2 = var1.calculeFichierConfig(this.structureLog.getStrid(), this.nature, "");
      if (var2 != null && !var2.isEmpty()) {
         Element var3 = new Element("configuration");
         Document var4 = new Document(var3);
         var3.removeContent();
         OptionConfigListe var5 = new OptionConfigListe();
         var5.setConfiguration(this.configListeLigne);
         Element var6 = new Element("configListe");
         var3.addContent(var6);
         var6.setText(var5.getConfiguration());
         XMLOutputter var7 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var8 = new FileOutputStream(StaticModePegase.getCheminContext() + var2);
         var7.output(var4, var8);
         var8.close();
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

   public FormExercicesVentes getFormExercicesVentes() {
      return this.formExercicesVentes;
   }

   public void setFormExercicesVentes(FormExercicesVentes var1) {
      this.formExercicesVentes = var1;
   }

   public ExercicesVentes getExoselectionne() {
      return this.exoselectionne;
   }

   public void setExoselectionne(ExercicesVentes var1) {
      this.exoselectionne = var1;
   }

   public ExercicesVentes getLastExercice() {
      return this.lastExercice;
   }

   public void setLastExercice(ExercicesVentes var1) {
      this.lastExercice = var1;
   }

   public String getAffichePage() {
      return this.affichePage;
   }

   public void setAffichePage(String var1) {
      this.affichePage = var1;
   }

   public LectureModulesOnglets getLesOnglets() {
      return this.lesOnglets;
   }

   public void setLesOnglets(LectureModulesOnglets var1) {
      this.lesOnglets = var1;
   }

   public MenudroitTempleCtrl getMenudroitTempleCtrl() {
      return this.menudroitTempleCtrl;
   }

   public void setMenudroitTempleCtrl(MenudroitTempleCtrl var1) {
      this.menudroitTempleCtrl = var1;
   }

   public ObjetLigneMenu getMenutemple() {
      return this.menutemple;
   }

   public void setMenutemple(ObjetLigneMenu var1) {
      this.menutemple = var1;
   }

   public OptionVentes getOptionVentes() {
      return this.optionVentes;
   }

   public void setOptionVentes(OptionVentes var1) {
      this.optionVentes = var1;
   }

   public long getLeIdExo() {
      return this.leIdExo;
   }

   public void setLeIdExo(long var1) {
      this.leIdExo = var1;
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

   public String getMessageAlerte() {
      return this.messageAlerte;
   }

   public void setMessageAlerte(String var1) {
      this.messageAlerte = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
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

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public String getConfigListeEntete() {
      return this.configListeEntete;
   }

   public void setConfigListeEntete(String var1) {
      this.configListeEntete = var1;
   }

   public String getConfigListeLigne() {
      return this.configListeLigne;
   }

   public void setConfigListeLigne(String var1) {
      this.configListeLigne = var1;
   }
}
