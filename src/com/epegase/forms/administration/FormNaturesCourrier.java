package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureCourrier;
import com.epegase.systeme.xml.LectureNatureCourrierCommun;
import com.epegase.systeme.xml.ObjetNatureCourrier;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FormNaturesCourrier implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private List listeNature = new ArrayList();
   private transient DataModel dataModelNature = new ListDataModel();
   private ObjetNatureCourrier objetNatureCourrier;
   private boolean btnModClient = false;
   private String lib;
   private String cod;
   private int codNat;
   private boolean afficheModePanelAjt;
   private boolean afficheModePanel;
   Element racine;
   Document document;
   private boolean afficheAjDefaut = false;

   public FormNaturesCourrier() throws IOException {
   }

   public void listeNaturesCourrier() throws JDOMException, IOException {
      LectureNatureCourrier var1 = new LectureNatureCourrier();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesFamillesClientItems();
      this.listeNature = var1.getMesNatures();
      this.dataModelNature.setWrappedData(this.listeNature);
      if (this.listeNature.size() > 0) {
         this.afficheAjDefaut = false;
      } else {
         this.afficheAjDefaut = true;
      }

      this.btnModClient = false;
   }

   public void defaultAdd() throws HibernateException, NamingException, ParseException, JDOMException, IOException {
      LectureNatureCourrierCommun var1 = new LectureNatureCourrierCommun();
      var1.chargerMesFamillesClientItems();
      new ArrayList();
      List var2 = var1.getMesNatures();
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.lib = ((ObjetNatureCourrier)var2.get(var3)).getLibelle();
            this.cod = ((ObjetNatureCourrier)var2.get(var3)).getCode();
            this.codNat = ((ObjetNatureCourrier)var2.get(var3)).getCodeNature();
            this.creation();
         }

         this.listeNaturesCourrier();
      }

      this.afficheAjDefaut = false;
   }

   public void lanceAjouter() throws HibernateException, NamingException {
      this.objetNatureCourrier = new ObjetNatureCourrier();
      this.lib = "";
      this.cod = "";
      this.codNat = 0;
      this.afficheModePanelAjt = true;
      this.afficheModePanel = false;
   }

   public void selectionLigne() {
      if (this.dataModelNature.isRowAvailable()) {
         this.objetNatureCourrier = (ObjetNatureCourrier)this.dataModelNature.getRowData();
         this.btnModClient = true;
      }

   }

   public void lanceModif() throws HibernateException, NamingException {
      this.lib = this.objetNatureCourrier.getLibelle();
      this.cod = this.objetNatureCourrier.getCode();
      this.codNat = this.objetNatureCourrier.getCodeNature();
      this.afficheModePanel = true;
      this.afficheModePanelAjt = false;
   }

   public void closeModif() {
      this.afficheModePanelAjt = false;
      this.afficheModePanel = false;
   }

   public void majAjout() throws JDOMException, IOException {
      this.creation();
      this.listeNaturesCourrier();
      this.closeModif();
      this.btnModClient = false;
      this.afficheAjDefaut = true;
   }

   public void majModif() throws JDOMException, IOException {
      if (this.objetNatureCourrier != null) {
         this.objetNatureCourrier.setLibelle(this.lib);
         this.objetNatureCourrier.setCode(this.cod);
         this.objetNatureCourrier.setCodeNature(this.codNat);
         this.modification();
         this.listeNaturesCourrier();
         this.closeModif();
      }

      this.btnModClient = false;
   }

   public void supprimer() throws JDOMException, IOException {
      if (this.objetNatureCourrier != null) {
         this.supprimerTier();
         this.listeNaturesCourrier();
         this.closeModif();
      }

      this.btnModClient = false;
   }

   public void creation() {
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "naturesCourriers.xml");
      Element var3;
      Element var4;
      Element var5;
      if (var1.exists()) {
         SAXBuilder var2 = new SAXBuilder();

         try {
            this.document = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "naturesCourriers.xml"));
            this.racine = this.document.getRootElement();
            var3 = new Element("natures");
            this.racine.addContent(var3);
            var4 = new Element("libelle");
            var4.setText(this.lib);
            var3.addContent(var4);
            var5 = new Element("code");
            var5.setText(this.cod);
            var3.addContent(var5);
            Element var6 = new Element("codeNature");
            var6.setText("" + this.codNat);
            var3.addContent(var6);
            this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "naturesCourriers.xml");
         } catch (JDOMException var7) {
         } catch (IOException var8) {
         }
      } else {
         this.racine = new Element("naturesCourriers");
         this.document = new Document(this.racine);
         Element var9 = new Element("natures");
         this.racine.addContent(var9);
         var3 = new Element("libelle");
         var3.setText(this.lib);
         var9.addContent(var3);
         var4 = new Element("code");
         var4.setText(this.cod);
         var9.addContent(var4);
         var5 = new Element("codeNature");
         var5.setText("" + this.codNat);
         var9.addContent(var5);
         this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "naturesCourriers.xml");
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
      Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "naturesCourriers.xml"));
      Element var3 = var2.getRootElement();
      this.listeNature.remove(this.objetNatureCourrier.getIndice());
      this.listeNature.add(this.objetNatureCourrier.getIndice(), this.objetNatureCourrier);
      this.creerArborescenceXml(var3, var2);
   }

   public void creerArborescenceXml(Element var1, Document var2) throws FileNotFoundException, IOException {
      var1 = var2.getRootElement();
      var1.removeContent();

      for(int var3 = 0; var3 < this.listeNature.size(); ++var3) {
         this.objetNatureCourrier = (ObjetNatureCourrier)this.listeNature.get(var3);
         Element var4 = new Element("natures");
         Element var5 = new Element("libelle");
         Element var6 = new Element("code");
         Element var7 = new Element("codeNature");
         var5.setText(this.objetNatureCourrier.getLibelle());
         var4.addContent(var5);
         var6.setText(this.objetNatureCourrier.getCode());
         var4.addContent(var6);
         var7.setText("" + this.objetNatureCourrier.getCodeNature());
         var4.addContent(var7);
         var1.addContent(var4);
      }

      this.enregistreFmtClient(var2);
   }

   public void enregistreFmtClient(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "naturesCourriers.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public void supprimerTier() throws JDOMException, IOException {
      SAXBuilder var1 = new SAXBuilder();
      Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "naturesCourriers.xml"));
      Element var3 = var2.getRootElement();
      this.listeNature.remove(this.objetNatureCourrier.getIndice());
      this.creerArborescenceXml(var3, var2);
   }

   public DataModel getDataModelNature() {
      return this.dataModelNature;
   }

   public void setDataModelNature(DataModel var1) {
      this.dataModelNature = var1;
   }

   public boolean isBtnModClient() {
      return this.btnModClient;
   }

   public void setBtnModClient(boolean var1) {
      this.btnModClient = var1;
   }

   public List getListeNature() {
      return this.listeNature;
   }

   public void setListeNature(List var1) {
      this.listeNature = var1;
   }

   public String getLib() {
      return this.lib;
   }

   public void setLib(String var1) {
      this.lib = var1;
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

   public Document getDocument() {
      return this.document;
   }

   public void setDocument(Document var1) {
      this.document = var1;
   }

   public Element getRacine() {
      return this.racine;
   }

   public void setRacine(Element var1) {
      this.racine = var1;
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

   public String getCod() {
      return this.cod;
   }

   public void setCod(String var1) {
      this.cod = var1;
   }

   public int getCodNat() {
      return this.codNat;
   }

   public void setCodNat(int var1) {
      this.codNat = var1;
   }

   public ObjetNatureCourrier getObjetNatureCourrier() {
      return this.objetNatureCourrier;
   }

   public void setObjetNatureCourrier(ObjetNatureCourrier var1) {
      this.objetNatureCourrier = var1;
   }

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public boolean isAfficheAjDefaut() {
      return this.afficheAjDefaut;
   }

   public void setAfficheAjDefaut(boolean var1) {
      this.afficheAjDefaut = var1;
   }
}
