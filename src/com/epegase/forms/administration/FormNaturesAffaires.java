package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureAffaires;
import com.epegase.systeme.xml.ObjetNatureAffaires;
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

public class FormNaturesAffaires implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private List listeNature = new ArrayList();
   private transient DataModel dataModelNature = new ListDataModel();
   private ObjetNatureAffaires objetNatureAffaires;
   private boolean btnModClient = false;
   private String lib;
   private String cod;
   private String anal;
   private boolean afficheModePanelAjt;
   private boolean afficheModePanel;
   Element racine;
   Document document;

   public FormNaturesAffaires() throws IOException {
   }

   public void listeNaturesCourrier() throws JDOMException, IOException {
      LectureNatureAffaires var1 = new LectureNatureAffaires();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesNaturesAffaires();
      this.listeNature = var1.getMesNatures();
      this.dataModelNature.setWrappedData(this.listeNature);
   }

   public void lanceAjouter() throws HibernateException, NamingException {
      this.objetNatureAffaires = new ObjetNatureAffaires();
      this.lib = "";
      this.cod = "";
      this.anal = "";
      this.afficheModePanelAjt = true;
      this.afficheModePanel = false;
   }

   public void selectionLigne() {
      if (this.dataModelNature.isRowAvailable()) {
         this.objetNatureAffaires = (ObjetNatureAffaires)this.dataModelNature.getRowData();
         this.btnModClient = true;
      }

   }

   public void lanceModif() throws HibernateException, NamingException {
      this.lib = this.objetNatureAffaires.getLibelle();
      this.cod = this.objetNatureAffaires.getCode();
      this.anal = this.objetNatureAffaires.getAnalytique();
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
   }

   public void majModif() throws JDOMException, IOException {
      this.objetNatureAffaires.setLibelle(this.lib);
      this.objetNatureAffaires.setCode(this.cod);
      this.objetNatureAffaires.setAnalytique(this.anal);
      this.modification();
      this.listeNaturesCourrier();
      this.closeModif();
      this.btnModClient = false;
   }

   public void supprimer() throws JDOMException, IOException {
      this.supprimerTier();
      this.listeNaturesCourrier();
      this.closeModif();
      this.btnModClient = false;
   }

   public void creation() {
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "configuration" + File.separator + "naturesAffaires.xml");
      Element var3;
      Element var4;
      Element var5;
      if (var1.exists()) {
         SAXBuilder var2 = new SAXBuilder();

         try {
            this.document = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "configuration" + File.separator + "naturesAffaires.xml"));
            this.racine = this.document.getRootElement();
            var3 = new Element("natures");
            this.racine.addContent(var3);
            var4 = new Element("code");
            var4.setText(this.cod);
            var3.addContent(var4);
            var5 = new Element("libelle");
            var5.setText(this.lib);
            var3.addContent(var5);
            Element var6 = new Element("analytique");
            var6.setText(this.anal);
            var3.addContent(var6);
            this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "configuration" + File.separator + "naturesAffaires.xml");
         } catch (JDOMException var7) {
         } catch (IOException var8) {
         }
      } else {
         this.racine = new Element("naturesAffaires");
         this.document = new Document(this.racine);
         Element var9 = new Element("natures");
         this.racine.addContent(var9);
         var3 = new Element("code");
         var3.setText(this.cod);
         var9.addContent(var3);
         var4 = new Element("libelle");
         var4.setText(this.lib);
         var9.addContent(var4);
         var5 = new Element("analytique");
         var5.setText(this.anal);
         var9.addContent(var5);
         this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "configuration" + File.separator + "naturesAffaires.xml");
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
      Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "configuration" + File.separator + "naturesAffaires.xml"));
      Element var3 = var2.getRootElement();
      this.listeNature.remove(this.objetNatureAffaires.getIndice());
      this.listeNature.add(this.objetNatureAffaires.getIndice(), this.objetNatureAffaires);
      this.creerArborescenceXml(var3, var2);
   }

   public void creerArborescenceXml(Element var1, Document var2) throws FileNotFoundException, IOException {
      var1 = var2.getRootElement();
      var1.removeContent();

      for(int var3 = 0; var3 < this.listeNature.size(); ++var3) {
         this.objetNatureAffaires = (ObjetNatureAffaires)this.listeNature.get(var3);
         Element var4 = new Element("natures");
         Element var5 = new Element("code");
         var5.setText(this.objetNatureAffaires.getCode());
         var4.addContent(var5);
         Element var6 = new Element("libelle");
         var6.setText(this.objetNatureAffaires.getLibelle());
         var4.addContent(var6);
         Element var7 = new Element("analytique");
         var7.setText(this.objetNatureAffaires.getAnalytique());
         var4.addContent(var7);
         var1.addContent(var4);
      }

      this.enregistreFmtClient(var2);
   }

   public void enregistreFmtClient(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "configuration" + File.separator + "naturesAffaires.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public void supprimerTier() throws JDOMException, IOException {
      SAXBuilder var1 = new SAXBuilder();
      Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "configuration" + File.separator + "naturesAffaires.xml"));
      Element var3 = var2.getRootElement();
      this.listeNature.remove(this.objetNatureAffaires.getIndice());
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

   public String getAnal() {
      return this.anal;
   }

   public void setAnal(String var1) {
      this.anal = var1;
   }
}
