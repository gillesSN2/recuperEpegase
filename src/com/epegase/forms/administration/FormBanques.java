package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureBanque;
import com.epegase.systeme.xml.ObjetBanque;
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

public class FormBanques implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private List listeBanques = new ArrayList();
   private transient DataModel dataModelBanques = new ListDataModel();
   private LectureBanque lectureBanque;
   private ObjetBanque objetBanque;
   private boolean btnModBanque = false;
   private String code;
   private String libelle;
   private String swift;
   private String iban;
   private boolean afficheModePanelAjt;
   private boolean afficheModePanel;
   Element racine;
   Document document;

   public FormBanques() throws IOException {
   }

   public void listeBanques() throws JDOMException, IOException {
      this.lectureBanque = new LectureBanque();
      this.lectureBanque.setStrId(this.structureLog.getStrid());
      this.lectureBanque.setStructureLog(this.structureLog);
      this.lectureBanque.recupereBanque();
      this.listeBanques = this.lectureBanque.getLesBanques();
      this.dataModelBanques.setWrappedData(this.listeBanques);
   }

   public void lanceAjouter() throws HibernateException, NamingException {
      this.objetBanque = new ObjetBanque();
      this.code = "";
      this.libelle = "";
      this.swift = "";
      this.iban = "";
      this.afficheModePanelAjt = true;
      this.afficheModePanel = false;
   }

   public void selectionLigne() {
      if (this.dataModelBanques.isRowAvailable()) {
         this.objetBanque = new ObjetBanque();
         this.objetBanque = (ObjetBanque)this.dataModelBanques.getRowData();
         this.code = this.objetBanque.getCode();
         this.libelle = this.objetBanque.getLibelle();
         this.swift = this.objetBanque.getSwift();
         this.iban = this.objetBanque.getIban();
         this.btnModBanque = true;
      }

   }

   public void lanceModif() throws HibernateException, NamingException {
      if (this.objetBanque != null) {
         this.afficheModePanel = true;
         this.afficheModePanelAjt = false;
      }

   }

   public void closeModif() {
      this.afficheModePanelAjt = false;
      this.afficheModePanel = false;
   }

   public void majAjout() throws JDOMException, IOException {
      this.creation();
      this.listeBanques();
      this.closeModif();
      this.btnModBanque = false;
   }

   public void majModif() throws JDOMException, IOException {
      this.objetBanque.setCode(this.code.toUpperCase());
      this.objetBanque.setLibelle(this.libelle.toUpperCase());
      this.objetBanque.setSwift(this.swift.toUpperCase());
      this.objetBanque.setIban(this.iban.toUpperCase());
      this.modification();
      this.listeBanques();
      this.closeModif();
      this.btnModBanque = false;
   }

   public void supprimer() throws JDOMException, IOException {
      if (this.objetBanque != null) {
         this.supprimerBanque();
         this.listeBanques();
         this.closeModif();
         this.btnModBanque = false;
      }

   }

   public void creation() {
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "banques.xml");
      Element var3;
      Element var4;
      Element var5;
      Element var6;
      if (var1.exists()) {
         SAXBuilder var2 = new SAXBuilder();

         try {
            this.document = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "banques.xml"));
            this.racine = this.document.getRootElement();
            var3 = new Element("bnq");
            this.racine.addContent(var3);
            var4 = new Element("code");
            var5 = new Element("libelle");
            var6 = new Element("swift");
            Element var7 = new Element("iban");
            var4.setText(this.code.toUpperCase());
            var5.setText(this.libelle.toUpperCase());
            var6.setText(this.swift.toUpperCase());
            var7.setText(this.iban.toUpperCase());
            var3.addContent(var4);
            var3.addContent(var5);
            var3.addContent(var6);
            var3.addContent(var7);
            this.enregistre(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "banques.xml");
         } catch (JDOMException var8) {
         } catch (IOException var9) {
         }
      } else {
         this.racine = new Element("banque");
         this.document = new Document(this.racine);
         Element var10 = new Element("bnq");
         this.racine.addContent(var10);
         var3 = new Element("code");
         var4 = new Element("libelle");
         var5 = new Element("swift");
         var6 = new Element("iban");
         var3.setText(this.code.toUpperCase());
         var4.setText(this.libelle.toUpperCase());
         var5.setText(this.swift.toUpperCase());
         var6.setText(this.iban.toUpperCase());
         var10.addContent(var3);
         var10.addContent(var4);
         var10.addContent(var5);
         var10.addContent(var6);
         this.enregistre(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "banques.xml");
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
      if (this.objetBanque != null) {
         SAXBuilder var1 = new SAXBuilder();
         Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "banques.xml"));
         Element var3 = var2.getRootElement();
         this.creerArborescenceXml(var3, var2);
      }

   }

   public void creerArborescenceXml(Element var1, Document var2) throws FileNotFoundException, IOException {
      var1 = var2.getRootElement();
      var1.removeContent();

      for(int var3 = 0; var3 < this.listeBanques.size(); ++var3) {
         this.objetBanque = (ObjetBanque)this.listeBanques.get(var3);
         Element var4;
         Element var5;
         Element var6;
         Element var7;
         Element var8;
         if (this.objetBanque.getCode().equalsIgnoreCase(this.code)) {
            var4 = new Element("bnq");
            var5 = new Element("code");
            var6 = new Element("libelle");
            var7 = new Element("swift");
            var8 = new Element("iban");
            var5.setText(this.code.toUpperCase());
            var6.setText(this.libelle.toUpperCase());
            var7.setText(this.swift.toUpperCase());
            var8.setText(this.iban.toUpperCase());
            var4.addContent(var5);
            var4.addContent(var6);
            var4.addContent(var7);
            var4.addContent(var8);
            var1.addContent(var4);
         } else {
            var4 = new Element("bnq");
            var5 = new Element("code");
            var6 = new Element("libelle");
            var7 = new Element("swift");
            var8 = new Element("iban");
            var5.setText(this.objetBanque.getCode());
            var6.setText(this.objetBanque.getLibelle());
            var7.setText(this.objetBanque.getSwift());
            var8.setText(this.objetBanque.getIban());
            var4.addContent(var5);
            var4.addContent(var6);
            var4.addContent(var7);
            var4.addContent(var8);
            var1.addContent(var4);
         }
      }

      this.enregistreBanque(var2);
   }

   public void enregistreBanque(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "banques.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public void supprimerBanque() throws JDOMException, IOException {
      SAXBuilder var1 = new SAXBuilder();
      Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "banques.xml"));
      Element var3 = var2.getRootElement();
      this.listeBanques.remove(this.objetBanque.getIndice());
      this.creerArborescenceXml(var3, var2);
   }

   public DataModel getDataModelBanques() {
      return this.dataModelBanques;
   }

   public void setDataModelBanques(DataModel var1) {
      this.dataModelBanques = var1;
   }

   public List getListeBanques() {
      return this.listeBanques;
   }

   public void setListeBanques(List var1) {
      this.listeBanques = var1;
   }

   public ObjetBanque getObjetBanque() {
      return this.objetBanque;
   }

   public void setObjetBanque(ObjetBanque var1) {
      this.objetBanque = var1;
   }

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public String getIban() {
      return this.iban;
   }

   public void setIban(String var1) {
      this.iban = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }

   public String getSwift() {
      return this.swift;
   }

   public void setSwift(String var1) {
      this.swift = var1;
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

   public boolean isBtnModBanque() {
      return this.btnModBanque;
   }

   public void setBtnModBanque(boolean var1) {
      this.btnModBanque = var1;
   }
}
