package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureClassementForet;
import com.epegase.systeme.xml.ObjetEssenceForet;
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

public class FormClassementForet implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private List listeElement = new ArrayList();
   private transient DataModel dataModelElement = new ListDataModel();
   private ObjetEssenceForet objetEssenceForet;
   private boolean btnModClient = false;
   private String lib;
   private String cod;
   private boolean afficheModePanelAjt;
   private boolean afficheModePanel;
   Element racine;
   Document document;

   public FormClassementForet() throws IOException {
   }

   public void listeClassement() throws JDOMException, IOException {
      LectureClassementForet var1 = new LectureClassementForet();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerClassements();
      this.listeElement = var1.getMesElements();
      this.dataModelElement.setWrappedData(this.listeElement);
   }

   public void lanceAjouter() throws HibernateException, NamingException {
      this.objetEssenceForet = new ObjetEssenceForet();
      this.lib = "";
      this.cod = "";
      this.afficheModePanelAjt = true;
      this.afficheModePanel = false;
   }

   public void selectionLigne() {
      if (this.dataModelElement.isRowAvailable()) {
         this.objetEssenceForet = (ObjetEssenceForet)this.dataModelElement.getRowData();
         this.lib = this.objetEssenceForet.getCode();
         this.cod = this.objetEssenceForet.getLibelle();
         this.btnModClient = true;
      }

   }

   public void lanceModif() throws HibernateException, NamingException {
      this.lib = this.objetEssenceForet.getLibelle();
      this.cod = this.objetEssenceForet.getCode();
      this.afficheModePanel = true;
      this.afficheModePanelAjt = false;
   }

   public void closeModif() {
      this.afficheModePanelAjt = false;
      this.afficheModePanel = false;
   }

   public void majAjout() throws JDOMException, IOException {
      this.creation("classements");
      this.listeClassement();
      this.closeModif();
      this.btnModClient = false;
   }

   public void majModif() throws JDOMException, IOException {
      this.objetEssenceForet.setLibelle(this.lib);
      this.objetEssenceForet.setCode(this.cod);
      this.modification("classements");
      this.listeClassement();
      this.closeModif();
      this.btnModClient = false;
   }

   public void supprimer() throws JDOMException, IOException {
      this.supprimer("classements");
      this.listeClassement();
      this.closeModif();
      this.btnModClient = false;
   }

   public void creation(String var1) {
      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator + "configuration" + File.separator + var1 + ".xml");
      Element var4;
      Element var5;
      if (var2.exists()) {
         SAXBuilder var3 = new SAXBuilder();

         try {
            this.document = var3.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator + "configuration" + File.separator + var1 + ".xml"));
            this.racine = this.document.getRootElement();
            var4 = new Element("classement");
            this.racine.addContent(var4);
            var5 = new Element("code");
            var5.setText(this.cod);
            var4.addContent(var5);
            Element var6 = new Element("libelle");
            var6.setText(this.lib);
            var4.addContent(var6);
            this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator + "configuration" + File.separator + var1 + ".xml");
         } catch (JDOMException var7) {
         } catch (IOException var8) {
         }
      } else {
         this.racine = new Element("classements");
         this.document = new Document(this.racine);
         Element var9 = new Element("classement");
         this.racine.addContent(var9);
         var4 = new Element("code");
         var4.setText(this.cod);
         var9.addContent(var4);
         var5 = new Element("libelle");
         var5.setText(this.lib);
         var9.addContent(var5);
         this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator + "configuration" + File.separator + var1 + ".xml");
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

   public void modification(String var1) throws JDOMException, IOException {
      SAXBuilder var2 = new SAXBuilder();
      Document var3 = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator + "configuration" + File.separator + var1 + ".xml"));
      Element var4 = var3.getRootElement();
      this.listeElement.remove(this.objetEssenceForet.getIndice());
      this.listeElement.add(this.objetEssenceForet.getIndice(), this.objetEssenceForet);
      this.creerArborescenceXml(var4, var3, var1);
   }

   public void creerArborescenceXml(Element var1, Document var2, String var3) throws FileNotFoundException, IOException {
      var1 = var2.getRootElement();
      var1.removeContent();

      for(int var4 = 0; var4 < this.listeElement.size(); ++var4) {
         this.objetEssenceForet = (ObjetEssenceForet)this.listeElement.get(var4);
         Element var5 = new Element("classement");
         Element var6 = new Element("code");
         var6.setText(this.cod);
         var5.addContent(var6);
         Element var7 = new Element("libelle");
         var7.setText(this.lib);
         var5.addContent(var7);
         var1.addContent(var5);
      }

      this.enregistreFmtClient(var2, var3);
   }

   public void enregistreFmtClient(Document var1, String var2) throws FileNotFoundException, IOException {
      XMLOutputter var3 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var4 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator + "configuration" + File.separator + var2 + ".xml");
      var3.output(var1, var4);
      var4.close();
   }

   public void supprimer(String var1) throws JDOMException, IOException {
      SAXBuilder var2 = new SAXBuilder();
      Document var3 = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator + "configuration" + File.separator + var1 + ".xml"));
      Element var4 = var3.getRootElement();
      this.listeElement.remove(this.objetEssenceForet.getIndice());
      this.creerArborescenceXml(var4, var3, var1);
   }

   public DataModel getDataModelElement() {
      return this.dataModelElement;
   }

   public void setDataModelElement(DataModel var1) {
      this.dataModelElement = var1;
   }

   public boolean isBtnModClient() {
      return this.btnModClient;
   }

   public void setBtnModClient(boolean var1) {
      this.btnModClient = var1;
   }

   public List getListeElement() {
      return this.listeElement;
   }

   public void setListeElement(List var1) {
      this.listeElement = var1;
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
}
