package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureReglementClient;
import com.epegase.systeme.xml.LectureTypeReglement;
import com.epegase.systeme.xml.ObjetReglement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FormReglementClient implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LectureReglementClient lectureReglementClient;
   private transient DataModel dataModelReglementClient = new ListDataModel();
   private boolean btnModreglement;
   private boolean afficheModePanel;
   private boolean afficheModePanelAjt;
   private ObjetReglement modeReg;
   private List modeRegList = new ArrayList();
   private List lesTypeReglements;
   private String libCode;
   private String code;
   private boolean testNbrJourArr;
   private Element racine;
   private Document document;
   private int index;
   private int numLigne;

   public FormReglementClient(String var1) throws IOException {
      LectureTypeReglement var2 = new LectureTypeReglement(var1);
      this.lesTypeReglements = var2.getMesTypeReglementItems();
   }

   public void chargerMesReglementsClt() {
      this.lectureReglementClient = new LectureReglementClient();
      this.lectureReglementClient.setStrId(this.structureLog.getStrid());
      this.lectureReglementClient.setStructureLog(this.structureLog);
      this.lectureReglementClient.recupereReglementClient();
      this.modeRegList = this.lectureReglementClient.getMesReglementClient();
      this.dataModelReglementClient.setWrappedData(this.modeRegList);
   }

   public void lanceAjouter() {
      this.modeReg = new ObjetReglement();
      this.modeReg.setDefaut("false");
      this.afficheModePanelAjt = true;
      this.afficheModePanel = false;
      this.visibleNbJArr();
   }

   public void lanceModif() {
      this.afficheModePanel = true;
      this.afficheModePanelAjt = false;
      this.visibleNbJArr();
   }

   public void closeModif() {
      this.afficheModePanelAjt = false;
      this.afficheModePanel = false;
   }

   public void calculeDefaut() throws JDOMException, IOException {
      if (this.modeRegList.size() != 0) {
         for(int var1 = 0; var1 < this.modeRegList.size(); ++var1) {
            new ObjetReglement();
            ObjetReglement var2 = (ObjetReglement)this.modeRegList.get(var1);
            if (var1 == this.numLigne) {
               var2.setDefaut("true");
            } else {
               var2.setDefaut("false");
            }

            this.modification();
         }

         this.dataModelReglementClient.setWrappedData(this.modeRegList);
      }

   }

   public void selectionLigne() {
      if (this.dataModelReglementClient != null && this.dataModelReglementClient.isRowAvailable()) {
         this.modeReg = new ObjetReglement();
         this.modeReg = (ObjetReglement)this.dataModelReglementClient.getRowData();
         this.libCode = this.modeReg.getCategories() + ":" + this.modeReg.getLibelles();
         this.code = this.modeReg.getCategories();
         this.numLigne = this.modeRegList.indexOf(this.modeReg);
         this.setBtnModreglement(true);
         this.closeModif();
      }

   }

   public void majAjout() throws JDOMException, IOException {
      this.affecterlibcode();
      this.creation();
      this.chargerMesReglementsClt();
      this.closeModif();
      this.btnModreglement = false;
   }

   public void majModif() throws JDOMException, IOException {
      this.affecterlibcode();
      this.modification();
      this.chargerMesReglementsClt();
      this.closeModif();
      this.btnModreglement = false;
   }

   public void majSup() throws JDOMException, IOException {
      this.supprimer();
      this.chargerMesReglementsClt();
      this.closeModif();
      this.btnModreglement = false;
   }

   public void creation() {
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "reglementClient.xml");
      Element var3;
      Element var4;
      Element var5;
      Element var6;
      Element var7;
      Element var8;
      Element var9;
      Element var10;
      if (var1.exists()) {
         SAXBuilder var2 = new SAXBuilder();

         try {
            this.document = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "reglementClient.xml"));
            this.racine = this.document.getRootElement();
            var3 = new Element("mode");
            this.racine.addContent(var3);
            var4 = new Element("categories");
            var3.addContent(var4);
            var4.setText(this.modeReg.getCategories());
            var5 = new Element("libelles");
            var3.addContent(var5);
            var5.setText(this.modeReg.getLibelles());
            var6 = new Element("journals");
            var3.addContent(var6);
            var6.setText(this.modeReg.getJournals());
            var7 = new Element("echeances");
            var3.addContent(var7);
            var7.setText(this.modeReg.getEcheances());
            var8 = new Element("nbjours");
            var3.addContent(var8);
            var8.setText(this.modeReg.getNbjours());
            var9 = new Element("arrondis");
            var3.addContent(var9);
            var9.setText(this.modeReg.getArrondis());
            var10 = new Element("conditions");
            var3.addContent(var10);
            var10.setText(this.modeReg.getConditions());
            Element var11 = new Element("defaut");
            var3.addContent(var11);
            var11.setText(this.modeReg.getDefaut());
            this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "reglementClient.xml");
         } catch (JDOMException var12) {
         } catch (IOException var13) {
         }
      } else {
         this.racine = new Element("reglement");
         this.document = new Document(this.racine);
         Element var14 = new Element("mode");
         this.racine.addContent(var14);
         var3 = new Element("categories");
         var14.addContent(var3);
         var3.setText(this.modeReg.getCategories());
         var4 = new Element("libelles");
         var14.addContent(var4);
         var4.setText(this.modeReg.getLibelles());
         var5 = new Element("journals");
         var14.addContent(var5);
         var5.setText(this.modeReg.getJournals());
         var6 = new Element("echeances");
         var14.addContent(var6);
         var6.setText(this.modeReg.getEcheances());
         var7 = new Element("nbjours");
         var14.addContent(var7);
         var7.setText(this.modeReg.getNbjours());
         var8 = new Element("arrondis");
         var14.addContent(var8);
         var8.setText(this.modeReg.getArrondis());
         var9 = new Element("conditions");
         var14.addContent(var9);
         var9.setText(this.modeReg.getConditions());
         var10 = new Element("defaut");
         var14.addContent(var10);
         var10.setText(this.modeReg.getDefaut());
         this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "reglementClient.xml");
      }

      this.closeModif();
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

   public void enregistreRegClient(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "reglementClient.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public void creerArborescenceXml(Element var1, Document var2) throws FileNotFoundException, IOException {
      var1 = var2.getRootElement();
      var1.removeContent();

      for(int var3 = 0; var3 < this.modeRegList.size(); ++var3) {
         this.modeReg = new ObjetReglement();
         this.modeReg = (ObjetReglement)this.modeRegList.get(var3);
         Element var4 = new Element("mode");
         Element var5 = new Element("categories");
         Element var6 = new Element("libelles");
         Element var7 = new Element("journals");
         Element var8 = new Element("echeances");
         Element var9 = new Element("nbjours");
         Element var10 = new Element("arrondis");
         Element var11 = new Element("conditions");
         Element var12 = new Element("defaut");
         var5.setText(this.modeReg.getCategories());
         var6.setText(this.modeReg.getLibelles());
         var7.setText(this.modeReg.getJournals());
         var8.setText(this.modeReg.getEcheances());
         var9.setText(this.modeReg.getNbjours());
         var10.setText(this.modeReg.getArrondis());
         var11.setText(this.modeReg.getConditions());
         var12.setText(this.modeReg.getDefaut());
         var4.addContent(var5);
         var4.addContent(var6);
         var4.addContent(var7);
         var4.addContent(var8);
         var4.addContent(var9);
         var4.addContent(var10);
         var4.addContent(var11);
         var4.addContent(var12);
         var1.addContent(var4);
      }

      this.enregistreRegClient(var2);
   }

   public void supprimer() throws JDOMException, IOException {
      SAXBuilder var1 = new SAXBuilder();
      Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "reglementClient.xml"));
      Element var3 = var2.getRootElement();
      this.modeRegList.remove(this.modeReg);
      this.creerArborescenceXml(var3, var2);
   }

   public void modification() throws JDOMException, IOException {
      SAXBuilder var1 = new SAXBuilder();
      Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "reglementClient.xml"));
      Element var3 = var2.getRootElement();
      this.creerArborescenceXml(var3, var2);
   }

   public void enregistre() throws FileNotFoundException, IOException {
      XMLOutputter var1 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var2 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "reglementClient.xml");
      var1.output(this.getDocument(), var2);
      var2.close();
   }

   public void affecterlibcode() {
      if (this.code != null && !this.code.isEmpty()) {
         for(int var1 = 0; var1 < this.lesTypeReglements.size(); ++var1) {
            String var2 = ((SelectItem)this.lesTypeReglements.get(var1)).getLabel();
            if (var2.contains(":")) {
               String[] var3 = var2.split(":");
               if (var3[0].equals(this.code)) {
                  this.modeReg.setCategories(((SelectItem)this.lesTypeReglements.get(var1)).getValue().toString());
                  this.modeReg.setLibelles(var3[1]);
                  break;
               }
            }
         }
      }

   }

   public void visibleNbJArr() {
      if (!this.getModeReg().getEcheances().equals("1") && !this.getModeReg().getEcheances().equals("2")) {
         this.setTestNbrJourArr(false);
      } else {
         this.setTestNbrJourArr(true);
      }

   }

   public LectureReglementClient getLectureReglementClient() {
      return this.lectureReglementClient;
   }

   public void setLectureReglementClient(LectureReglementClient var1) {
      this.lectureReglementClient = var1;
   }

   public DataModel getDataModelReglementClient() {
      return this.dataModelReglementClient;
   }

   public void setDataModelReglementClient(DataModel var1) {
      this.dataModelReglementClient = var1;
   }

   public boolean isAfficheModePanel() {
      return this.afficheModePanel;
   }

   public void setAfficheModePanel(boolean var1) {
      this.afficheModePanel = var1;
   }

   public boolean isBtnModreglement() {
      return this.btnModreglement;
   }

   public void setBtnModreglement(boolean var1) {
      this.btnModreglement = var1;
   }

   public ObjetReglement getModeReg() {
      return this.modeReg;
   }

   public void setModeReg(ObjetReglement var1) {
      this.modeReg = var1;
   }

   public List getLesTypeReglements() {
      return this.lesTypeReglements;
   }

   public void setLesTypeReglements(List var1) {
      this.lesTypeReglements = var1;
   }

   public String getLibCode() {
      return this.libCode;
   }

   public void setLibCode(String var1) {
      this.libCode = var1;
   }

   public boolean isTestNbrJourArr() {
      return this.testNbrJourArr;
   }

   public void setTestNbrJourArr(boolean var1) {
      this.testNbrJourArr = var1;
   }

   public Document getDocument() {
      return this.document;
   }

   public void setDocument(Document var1) {
      this.document = var1;
   }

   public int getIndex() {
      return this.index;
   }

   public void setIndex(int var1) {
      this.index = var1;
   }

   public Element getRacine() {
      return this.racine;
   }

   public void setRacine(Element var1) {
      this.racine = var1;
   }

   public List getModeRegList() {
      return this.modeRegList;
   }

   public void setModeRegList(List var1) {
      this.modeRegList = var1;
   }

   public boolean isAfficheModePanelAjt() {
      return this.afficheModePanelAjt;
   }

   public void setAfficheModePanelAjt(boolean var1) {
      this.afficheModePanelAjt = var1;
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

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
