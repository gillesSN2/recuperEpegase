package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.ObjetNaturePret;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNaturePrets;
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
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FormNaturesPrets implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private List listeNaturePret = new ArrayList();
   private transient DataModel dataModelNaturePret = new ListDataModel();
   private ObjetNaturePret objetNaturePret = new ObjetNaturePret();
   private String lib;
   private String cod;
   private boolean btnModNature = false;
   private boolean afficheModePanelAjt;
   private boolean afficheModePanel;
   Element racine;
   Document document;

   public FormNaturesPrets() throws IOException {
   }

   public void listeNaturePrets() throws JDOMException, IOException, NamingException {
      LectureNaturePrets var1 = new LectureNaturePrets();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesNaturesPretsItems();
      this.listeNaturePret = var1.getMesNaturesPrets();
      this.dataModelNaturePret.setWrappedData(this.listeNaturePret);
   }

   public void lanceAjouter() throws HibernateException, NamingException {
      this.objetNaturePret = new ObjetNaturePret();
      this.lib = "";
      if (this.listeNaturePret.size() == 0) {
         this.cod = "0";
      } else {
         this.cod = "" + this.listeNaturePret.size();
      }

      this.afficheModePanelAjt = true;
      this.afficheModePanel = false;
   }

   public void selectionLigne() throws HibernateException, NamingException {
      if (this.dataModelNaturePret.isRowAvailable()) {
         this.objetNaturePret = (ObjetNaturePret)this.dataModelNaturePret.getRowData();
         this.btnModNature = true;
      }

   }

   public void lanceModif() throws HibernateException, NamingException {
      if (this.objetNaturePret != null) {
         this.lib = this.objetNaturePret.getLibelle();
         this.cod = this.objetNaturePret.getCode();
         this.afficheModePanel = true;
         this.afficheModePanelAjt = false;
      }

   }

   public void closeModif() {
      this.afficheModePanelAjt = false;
      this.afficheModePanel = false;
   }

   public void majAjout() throws JDOMException, IOException, NamingException {
      this.creation();
      this.listeNaturePrets();
      this.closeModif();
      this.btnModNature = false;
   }

   public void majModif() throws JDOMException, IOException, NamingException {
      this.objetNaturePret.setLibelle(this.lib);
      this.objetNaturePret.setCode(this.cod);
      this.modification();
      this.listeNaturePrets();
      this.closeModif();
      this.btnModNature = false;
   }

   public void supprimer() throws JDOMException, IOException, NamingException {
      if (this.objetNaturePret != null) {
         this.supprimerTier();
         this.listeNaturePrets();
         this.closeModif();
         this.btnModNature = false;
      }

   }

   public void creation() {
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "naturePrets.xml");
      Element var3;
      Element var4;
      if (var1.exists()) {
         SAXBuilder var2 = new SAXBuilder();

         try {
            this.document = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "naturePrets.xml"));
            this.racine = this.document.getRootElement();
            var3 = new Element("pret");
            this.racine.addContent(var3);
            var4 = new Element("libelle");
            Element var5 = new Element("code");
            var4.setText(this.lib);
            var5.setText(this.cod);
            var3.addContent(var4);
            var3.addContent(var5);
            this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "naturePrets.xml");
         } catch (JDOMException var6) {
         } catch (IOException var7) {
         }
      } else {
         this.racine = new Element("nature");
         this.document = new Document(this.racine);
         Element var8 = new Element("pret");
         this.racine.addContent(var8);
         var3 = new Element("libelle");
         var4 = new Element("code");
         var3.setText(this.lib);
         var4.setText(this.cod);
         var8.addContent(var3);
         var8.addContent(var4);
         this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "naturePrets.xml");
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
      Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "naturePrets.xml"));
      Element var3 = var2.getRootElement();
      this.listeNaturePret.remove(this.objetNaturePret);
      this.listeNaturePret.add(this.objetNaturePret);
      this.creerArborescenceXml(var3, var2);
   }

   public void creerArborescenceXml(Element var1, Document var2) throws FileNotFoundException, IOException {
      var1 = var2.getRootElement();
      var1.removeContent();

      for(int var3 = 0; var3 < this.listeNaturePret.size(); ++var3) {
         this.objetNaturePret = new ObjetNaturePret();
         this.objetNaturePret = (ObjetNaturePret)this.listeNaturePret.get(var3);
         Element var4 = new Element("pret");
         Element var5 = new Element("libelle");
         Element var6 = new Element("code");
         var5.setText(this.objetNaturePret.getLibelle());
         var6.setText(this.objetNaturePret.getCode());
         var4.addContent(var5);
         var4.addContent(var6);
         var1.addContent(var4);
      }

      this.enregistreFmtClient(var2);
   }

   public void enregistreFmtClient(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "naturePrets.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public void supprimerTier() throws JDOMException, IOException {
      SAXBuilder var1 = new SAXBuilder();
      Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "naturePrets.xml"));
      Element var3 = var2.getRootElement();
      this.listeNaturePret.remove(this.objetNaturePret);
      this.creerArborescenceXml(var3, var2);
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

   public boolean isBtnModNature() {
      return this.btnModNature;
   }

   public void setBtnModNature(boolean var1) {
      this.btnModNature = var1;
   }

   public String getCod() {
      return this.cod;
   }

   public void setCod(String var1) {
      this.cod = var1;
   }

   public DataModel getDataModelNaturePret() {
      return this.dataModelNaturePret;
   }

   public void setDataModelNaturePret(DataModel var1) {
      this.dataModelNaturePret = var1;
   }

   public List getListeNaturePret() {
      return this.listeNaturePret;
   }

   public void setListeNaturePret(List var1) {
      this.listeNaturePret = var1;
   }
}
