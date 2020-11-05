package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureModeleDevis;
import com.epegase.systeme.xml.ObjetModeleFacture;
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

public class FormModelesDevisVentes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private List listeElement = new ArrayList();
   private transient DataModel dataModelElement = new ListDataModel();
   private ObjetModeleFacture objetModeleDevis;
   private boolean btnModClient = false;
   private String lib;
   private String cod;
   private String fam;
   private String tax;
   private double qte;
   private double pu;
   private double abn;
   private int mode;
   private String modul;
   private boolean afficheModePanelAjt;
   private boolean afficheModePanel;
   Element racine;
   Document document;

   public FormModelesDevisVentes() throws IOException {
   }

   public void listeModele() throws JDOMException, IOException {
      LectureModeleDevis var1 = new LectureModeleDevis(this.structureLog.getStrid());
      this.listeElement = var1.getLesModeles();
      this.dataModelElement.setWrappedData(this.listeElement);
   }

   public void lanceAjouter() throws HibernateException, NamingException {
      this.objetModeleDevis = new ObjetModeleFacture();
      this.lib = "";
      this.cod = "";
      this.fam = "";
      this.tax = "";
      this.mode = 0;
      this.modul = "";
      this.qte = 0.0D;
      this.pu = 0.0D;
      this.abn = 0.0D;
      this.afficheModePanelAjt = true;
      this.afficheModePanel = false;
   }

   public void selectionLigne() {
      if (this.dataModelElement.isRowAvailable()) {
         this.objetModeleDevis = (ObjetModeleFacture)this.dataModelElement.getRowData();
         this.cod = this.objetModeleDevis.getCode();
         this.lib = this.objetModeleDevis.getLibelle();
         this.fam = this.objetModeleDevis.getFamille();
         this.tax = this.objetModeleDevis.getTva();
         this.mode = this.objetModeleDevis.getMode();
         this.modul = this.objetModeleDevis.getModule();
         this.qte = (double)this.objetModeleDevis.getQte();
         this.pu = this.objetModeleDevis.getPu();
         this.abn = this.objetModeleDevis.getAbn();
         this.btnModClient = true;
      }

   }

   public void lanceModif() throws HibernateException, NamingException {
      this.cod = this.objetModeleDevis.getCode();
      this.lib = this.objetModeleDevis.getLibelle();
      this.fam = this.objetModeleDevis.getFamille();
      this.tax = this.objetModeleDevis.getTva();
      this.mode = this.objetModeleDevis.getMode();
      this.modul = this.objetModeleDevis.getModule();
      this.qte = (double)this.objetModeleDevis.getQte();
      this.pu = this.objetModeleDevis.getPu();
      this.abn = this.objetModeleDevis.getAbn();
      this.afficheModePanel = true;
      this.afficheModePanelAjt = false;
   }

   public void closeModif() {
      this.afficheModePanelAjt = false;
      this.afficheModePanel = false;
   }

   public void majAjout() throws JDOMException, IOException {
      this.creation("modeleDevis");
      this.listeModele();
      this.closeModif();
      this.btnModClient = false;
   }

   public void majModif() throws JDOMException, IOException {
      this.objetModeleDevis.setLibelle(this.lib);
      this.objetModeleDevis.setCode(this.cod);
      this.objetModeleDevis.setFamille(this.fam);
      this.objetModeleDevis.setTva(this.tax);
      this.objetModeleDevis.setMode(this.mode);
      this.objetModeleDevis.setModule(this.modul);
      this.objetModeleDevis.setQte((float)this.qte);
      this.objetModeleDevis.setPu(this.pu);
      this.objetModeleDevis.setAbn(this.abn);
      this.modification("modeleDevis");
      this.listeModele();
      this.closeModif();
      this.btnModClient = false;
   }

   public void supprimer() throws JDOMException, IOException {
      this.supprimer("modeleDevis");
      this.listeModele();
      this.closeModif();
      this.btnModClient = false;
   }

   public void creation(String var1) {
      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator + "configuration" + File.separator + var1 + ".xml");
      Element var4;
      Element var5;
      Element var6;
      Element var7;
      Element var8;
      Element var11;
      Element var12;
      if (var2.exists()) {
         SAXBuilder var3 = new SAXBuilder();

         try {
            this.document = var3.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator + "configuration" + File.separator + var1 + ".xml"));
            this.racine = this.document.getRootElement();
            var4 = new Element("devis");
            this.racine.addContent(var4);
            var5 = new Element("code");
            var5.setText(this.cod);
            var4.addContent(var5);
            var6 = new Element("libelle");
            var6.setText(this.lib);
            var4.addContent(var6);
            var7 = new Element("famille");
            var6.setText(this.fam);
            var4.addContent(var7);
            var8 = new Element("tva");
            var6.setText(this.tax);
            var4.addContent(var8);
            Element var9 = new Element("mode");
            var6.setText("" + this.mode);
            var4.addContent(var9);
            new Element("module");
            var6.setText(this.modul);
            var4.addContent(var9);
            var11 = new Element("qte");
            var6.setText("" + this.qte);
            var4.addContent(var11);
            var12 = new Element("pu");
            var6.setText("" + this.pu);
            var4.addContent(var12);
            Element var13 = new Element("abn");
            var6.setText("" + this.abn);
            var4.addContent(var13);
            this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator + "configuration" + File.separator + var1 + ".xml");
         } catch (JDOMException var14) {
         } catch (IOException var15) {
         }
      } else {
         this.racine = new Element("modele");
         this.document = new Document(this.racine);
         Element var16 = new Element("devis");
         this.racine.addContent(var16);
         var4 = new Element("code");
         var4.setText(this.cod);
         var16.addContent(var4);
         var5 = new Element("libelle");
         var5.setText(this.lib);
         var16.addContent(var5);
         var6 = new Element("famille");
         var5.setText(this.fam);
         var16.addContent(var6);
         var7 = new Element("tva");
         var5.setText(this.tax);
         var16.addContent(var7);
         var8 = new Element("mode");
         var5.setText("" + this.mode);
         var16.addContent(var8);
         new Element("module");
         var5.setText(this.modul);
         var16.addContent(var8);
         Element var10 = new Element("qte");
         var5.setText("" + this.qte);
         var16.addContent(var10);
         var11 = new Element("pu");
         var5.setText("" + this.pu);
         var16.addContent(var11);
         var12 = new Element("abn");
         var5.setText("" + this.abn);
         var16.addContent(var12);
         this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator + "configuration" + File.separator + var1 + ".xml");
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
      Document var3 = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator + "configuration" + File.separator + var1 + ".xml"));
      Element var4 = var3.getRootElement();
      this.listeElement.remove(this.objetModeleDevis);
      this.listeElement.add(this.objetModeleDevis.getIndice(), this.objetModeleDevis);
      this.creerArborescenceXml(var4, var3, var1);
   }

   public void creerArborescenceXml(Element var1, Document var2, String var3) throws FileNotFoundException, IOException {
      var1 = var2.getRootElement();
      var1.removeContent();

      for(int var4 = 0; var4 < this.listeElement.size(); ++var4) {
         this.objetModeleDevis = (ObjetModeleFacture)this.listeElement.get(var4);
         Element var5 = new Element("devis");
         Element var6 = new Element("code");
         var6.setText(this.cod);
         var5.addContent(var6);
         Element var7 = new Element("libelle");
         var7.setText(this.lib);
         var5.addContent(var7);
         Element var8 = new Element("famille");
         var7.setText(this.fam);
         var5.addContent(var8);
         Element var9 = new Element("tva");
         var7.setText(this.tax);
         var5.addContent(var9);
         Element var10 = new Element("mode");
         var7.setText("" + this.mode);
         var5.addContent(var10);
         new Element("module");
         var7.setText(this.modul);
         var5.addContent(var10);
         Element var12 = new Element("qte");
         var7.setText("" + this.qte);
         var5.addContent(var12);
         Element var13 = new Element("pu");
         var7.setText("" + this.pu);
         var5.addContent(var13);
         Element var14 = new Element("abn");
         var7.setText("" + this.abn);
         var5.addContent(var14);
         var1.addContent(var5);
      }

      this.enregistreFmtClient(var2, var3);
   }

   public void enregistreFmtClient(Document var1, String var2) throws FileNotFoundException, IOException {
      XMLOutputter var3 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var4 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator + "configuration" + File.separator + var2 + ".xml");
      var3.output(var1, var4);
      var4.close();
   }

   public void supprimer(String var1) throws JDOMException, IOException {
      SAXBuilder var2 = new SAXBuilder();
      Document var3 = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator + "configuration" + File.separator + var1 + ".xml"));
      Element var4 = var3.getRootElement();
      this.listeElement.remove(this.objetModeleDevis);
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

   public double getAbn() {
      return this.abn;
   }

   public void setAbn(double var1) {
      this.abn = var1;
   }

   public String getFam() {
      return this.fam;
   }

   public void setFam(String var1) {
      this.fam = var1;
   }

   public int getMode() {
      return this.mode;
   }

   public void setMode(int var1) {
      this.mode = var1;
   }

   public String getModul() {
      return this.modul;
   }

   public void setModul(String var1) {
      this.modul = var1;
   }

   public double getPu() {
      return this.pu;
   }

   public void setPu(double var1) {
      this.pu = var1;
   }

   public double getQte() {
      return this.qte;
   }

   public void setQte(double var1) {
      this.qte = var1;
   }

   public String getTax() {
      return this.tax;
   }

   public void setTax(String var1) {
      this.tax = var1;
   }
}
