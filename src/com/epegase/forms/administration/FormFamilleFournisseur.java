package com.epegase.forms.administration;

import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureFamillesFournisseurs;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FormFamilleFournisseur implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private List listeFamilleTiers;
   private transient DataModel dataModelSourcesTiers = new ListDataModel();
   private transient DataModel dataModelFournisseur = new ListDataModel();
   private ObjetFamilleTiers objetFamilleTiers;
   private boolean btnModFournisseur = false;
   private String lib;
   private int exoT;
   private int exoD;
   private String ser;
   private String etat = "";
   private Chrono chrono;
   private ChronoDao chronoDao;
   private List lesChronosClt;
   private List lesChronosItemsFrn = new ArrayList();
   private boolean afficheModePanelAjt;
   private boolean afficheModePanel;
   Element racine;
   Document document;

   public FormFamilleFournisseur() throws IOException {
   }

   public void listeFamilleFournisseur() throws JDOMException, IOException {
      LectureFamillesFournisseurs var1 = new LectureFamillesFournisseurs();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesFamillesFournisseurItems();
      this.listeFamilleTiers = var1.getMesFamillesFournisseurs();
      this.dataModelFournisseur.setWrappedData(this.listeFamilleTiers);
   }

   public void lanceAjouter() throws HibernateException, NamingException {
      this.objetFamilleTiers = new ObjetFamilleTiers();
      this.lib = "";
      this.ser = "";
      this.exoT = 0;
      this.exoD = 0;
      this.recupererChronoItemFrn();
      this.afficheModePanelAjt = true;
      this.afficheModePanel = false;
   }

   public void selectionLigne() {
      if (this.dataModelFournisseur.isRowAvailable()) {
         this.objetFamilleTiers = new ObjetFamilleTiers();
         this.objetFamilleTiers = (ObjetFamilleTiers)this.dataModelFournisseur.getRowData();
         this.btnModFournisseur = true;
      }

   }

   public void lanceModif() throws HibernateException, NamingException {
      this.lib = this.objetFamilleTiers.getLibelle();
      if (!this.objetFamilleTiers.getExoTva().contentEquals("true") && !this.objetFamilleTiers.getExoTva().contentEquals("1")) {
         if (!this.objetFamilleTiers.getExoTva().contentEquals("false") && !this.objetFamilleTiers.getExoTva().contentEquals("0")) {
            this.exoT = 2;
         } else {
            this.exoT = 0;
         }
      } else {
         this.exoT = 1;
      }

      if (!this.objetFamilleTiers.getExoDouane().contentEquals("true") && !this.objetFamilleTiers.getExoDouane().contentEquals("1")) {
         if (!this.objetFamilleTiers.getExoDouane().contentEquals("false") && !this.objetFamilleTiers.getExoDouane().contentEquals("0")) {
            this.exoD = 2;
         } else {
            this.exoD = 0;
         }
      } else {
         this.exoD = 1;
      }

      this.ser = this.objetFamilleTiers.getSerie();
      this.recupererChronoItemFrn();
      this.afficheModePanel = true;
      this.afficheModePanelAjt = false;
   }

   public void closeModif() {
      this.afficheModePanelAjt = false;
      this.afficheModePanel = false;
   }

   public void recupererChronoItemFrn() throws HibernateException, NamingException {
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.lesChronosItemsFrn = new ArrayList();
      this.lesChronosItemsFrn = this.chronoDao.selectListFournisseurItem((Session)null);
   }

   public void majAjout() throws JDOMException, IOException {
      this.creation();
      this.listeFamilleFournisseur();
      this.closeModif();
      this.btnModFournisseur = false;
   }

   public void majModif() throws JDOMException, IOException {
      this.objetFamilleTiers.setLibelle(this.lib);
      this.objetFamilleTiers.setExoTva("" + this.exoT);
      this.objetFamilleTiers.setExoDouane("" + this.exoD);
      this.objetFamilleTiers.setSerie(this.ser);
      this.modification();
      this.listeFamilleFournisseur();
      this.closeModif();
      this.btnModFournisseur = false;
   }

   public void supprimer() throws JDOMException, IOException {
      this.supprimerTier();
      this.listeFamilleFournisseur();
      this.closeModif();
      this.btnModFournisseur = false;
   }

   public void creation() {
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "fournisseurs.xml");
      Element var3;
      Element var4;
      Element var5;
      Element var6;
      if (var1.exists()) {
         SAXBuilder var2 = new SAXBuilder();

         try {
            this.document = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "fournisseurs.xml"));
            this.racine = this.document.getRootElement();
            var3 = new Element("fournisseurs");
            this.racine.addContent(var3);
            var4 = new Element("libelle");
            var5 = new Element("exoTva");
            var6 = new Element("exoDouane");
            Element var7 = new Element("serie");
            var4.setText(this.lib);
            var5.setText("" + this.exoT);
            var6.setText("" + this.exoD);
            var7.setText(this.ser);
            var3.addContent(var4);
            var3.addContent(var5);
            var3.addContent(var6);
            var3.addContent(var7);
            this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "fournisseurs.xml");
         } catch (JDOMException var8) {
         } catch (IOException var9) {
         }
      } else {
         this.racine = new Element("famille");
         this.document = new Document(this.racine);
         Element var10 = new Element("fournisseurs");
         this.racine.addContent(var10);
         var3 = new Element("libelle");
         var4 = new Element("exoTva");
         var5 = new Element("exoDouane");
         var6 = new Element("serie");
         var3.setText(this.lib);
         var4.setText("" + this.exoT);
         var5.setText("" + this.exoD);
         var6.setText(this.ser);
         var10.addContent(var3);
         var10.addContent(var4);
         var10.addContent(var5);
         var10.addContent(var6);
         this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "fournisseurs.xml");
      }

   }

   public void enregistre(String var1) {
      try {
         XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var3 = new FileOutputStream(var1);
         var2.output(this.document, var3);
         var3.close();
      } catch (IOException var4) {
      }

   }

   public void modification() throws JDOMException, IOException {
      SAXBuilder var1 = new SAXBuilder();
      Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "fournisseurs.xml"));
      Element var3 = var2.getRootElement();
      this.listeFamilleTiers.remove(this.objetFamilleTiers.getIndice());
      this.listeFamilleTiers.add(this.objetFamilleTiers.getIndice(), this.objetFamilleTiers);
      this.creerArborescenceXml(var3, var2);
   }

   public void creerArborescenceXml(Element var1, Document var2) throws FileNotFoundException, IOException {
      var1 = var2.getRootElement();
      var1.removeContent();

      for(int var3 = 0; var3 < this.listeFamilleTiers.size(); ++var3) {
         this.objetFamilleTiers = new ObjetFamilleTiers();
         this.objetFamilleTiers = (ObjetFamilleTiers)this.listeFamilleTiers.get(var3);
         Element var4 = new Element("fournisseurs");
         Element var5 = new Element("libelle");
         Element var6 = new Element("exoTva");
         Element var7 = new Element("exoDouane");
         Element var8 = new Element("serie");
         var5.setText(this.objetFamilleTiers.getLibelle());
         if (!this.objetFamilleTiers.getExoTva().equalsIgnoreCase("true") && !this.objetFamilleTiers.getExoTva().equalsIgnoreCase("1")) {
            if (this.objetFamilleTiers.getExoTva().equalsIgnoreCase("2")) {
               var6.setText("2");
            } else {
               var6.setText("0");
            }
         } else {
            var6.setText("1");
         }

         if (!this.objetFamilleTiers.getExoDouane().equalsIgnoreCase("true") && !this.objetFamilleTiers.getExoDouane().equalsIgnoreCase("1")) {
            var7.setText("0");
         } else {
            var7.setText("1");
         }

         var8.setText(this.objetFamilleTiers.getSerie());
         var4.addContent(var5);
         var4.addContent(var6);
         var4.addContent(var7);
         var4.addContent(var8);
         var1.addContent(var4);
      }

      this.enregistreFmtFournisseur(var2);
   }

   public void enregistreFmtFournisseur(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "fournisseurs.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public void supprimerTier() throws JDOMException, IOException {
      SAXBuilder var1 = new SAXBuilder();
      Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "fournisseurs.xml"));
      Element var3 = var2.getRootElement();
      this.listeFamilleTiers.remove(this.objetFamilleTiers.getIndice());
      this.creerArborescenceXml(var3, var2);
   }

   public DataModel getDataModelSourcesTiers() {
      return this.dataModelSourcesTiers;
   }

   public void setDataModelSourcesTiers(DataModel var1) {
      this.dataModelSourcesTiers = var1;
   }

   public boolean isBtnModFournisseur() {
      return this.btnModFournisseur;
   }

   public void setBtnModFournisseur(boolean var1) {
      this.btnModFournisseur = var1;
   }

   public DataModel getDataModelFournisseur() {
      return this.dataModelFournisseur;
   }

   public void setDataModelFournisseur(DataModel var1) {
      this.dataModelFournisseur = var1;
   }

   public Document getDocument() {
      return this.document;
   }

   public void setDocument(Document var1) {
      this.document = var1;
   }

   public List getLesChronosItemsFrn() {
      return this.lesChronosItemsFrn;
   }

   public void setLesChronosItemsFrn(List var1) {
      this.lesChronosItemsFrn = var1;
   }

   public Element getRacine() {
      return this.racine;
   }

   public void setRacine(Element var1) {
      this.racine = var1;
   }

   public List getListeFamilleTiers() {
      return this.listeFamilleTiers;
   }

   public void setListeFamilleTiers(List var1) {
      this.listeFamilleTiers = var1;
   }

   public ObjetFamilleTiers getObjetFamilleTiers() {
      return this.objetFamilleTiers;
   }

   public void setObjetFamilleTiers(ObjetFamilleTiers var1) {
      this.objetFamilleTiers = var1;
   }

   public String getEtat() {
      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public int getExoD() {
      return this.exoD;
   }

   public void setExoD(int var1) {
      this.exoD = var1;
   }

   public int getExoT() {
      return this.exoT;
   }

   public void setExoT(int var1) {
      this.exoT = var1;
   }

   public String getLib() {
      return this.lib;
   }

   public void setLib(String var1) {
      this.lib = var1;
   }

   public String getSer() {
      return this.ser;
   }

   public void setSer(String var1) {
      this.ser = var1;
   }

   public boolean isAfficheModePanel() {
      return this.afficheModePanel;
   }

   public void setAfficheModePanel(boolean var1) {
      this.afficheModePanel = var1;
   }

   public boolean isAfficheModePanelAjt() {
      return this.afficheModePanelAjt;
   }

   public void setAfficheModePanelAjt(boolean var1) {
      this.afficheModePanelAjt = var1;
   }

   public List getLesChronosClt() {
      return this.lesChronosClt;
   }

   public void setLesChronosClt(List var1) {
      this.lesChronosClt = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
