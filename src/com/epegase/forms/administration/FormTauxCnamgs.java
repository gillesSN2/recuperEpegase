package com.epegase.forms.administration;



import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureTauxCnamgs;
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
import org.jdom.Content;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FormTauxCnamgs implements Serializable {
  private UtilInitHibernate utilInitHibernate;
  
  private String baseLog;
  
  private Structure structureLog;
  
  private Users usersLog;
  
  private String pageIndex;
  
  private List<ObjetFamilleTiers> listeTauxCnamgs = new ArrayList<ObjetFamilleTiers>();
  
  private transient DataModel dataModelTauxCnamgs = (DataModel)new ListDataModel();
  
  private ObjetFamilleTiers objetFamilleTiers;
  
  private boolean btnModClient = false;
  
  private String lib;
  
  private int taux;
  
  private boolean afficheModePanelAjt;
  
  private boolean afficheModePanel;
  
  Element racine;
  
  Document document;
  
  public void listeTauxCnamgs() throws JDOMException, IOException, NamingException {
    LectureTauxCnamgs lectureTauxCnamgs = new LectureTauxCnamgs();
    lectureTauxCnamgs.setStrId(this.structureLog.getStrid());
    lectureTauxCnamgs.setStructureLog(this.structureLog);
    lectureTauxCnamgs.chargerMesTauxCnamgsItems();
    this.listeTauxCnamgs = lectureTauxCnamgs.getMesTauxCnamgs();
    this.dataModelTauxCnamgs.setWrappedData(this.listeTauxCnamgs);
  }
  
  public void lanceAjouter() throws HibernateException, NamingException {
    this.objetFamilleTiers = new ObjetFamilleTiers();
    this.lib = "";
    this.taux = 0;
    this.afficheModePanelAjt = true;
    this.afficheModePanel = false;
  }
  
  public void selectionLigne() throws HibernateException, NamingException {
    if (this.dataModelTauxCnamgs.isRowAvailable()) {
      this.objetFamilleTiers = new ObjetFamilleTiers();
      this.objetFamilleTiers = (ObjetFamilleTiers)this.dataModelTauxCnamgs.getRowData();
      this.btnModClient = true;
    } 
  }
  
  public void lanceModif() throws HibernateException, NamingException {
    this.lib = this.objetFamilleTiers.getLibelle();
    this.taux = this.objetFamilleTiers.getTauxCnamgs();
    this.afficheModePanel = true;
    this.afficheModePanelAjt = false;
  }
  
  public void closeModif() {
    this.afficheModePanelAjt = false;
    this.afficheModePanel = false;
  }
  
  public void majAjout() throws JDOMException, IOException, NamingException {
    creation();
    listeTauxCnamgs();
    closeModif();
    this.btnModClient = false;
  }
  
  public void majModif() throws JDOMException, IOException, NamingException {
    this.objetFamilleTiers.setLibelle(this.lib);
    this.objetFamilleTiers.setTauxCnamgs(this.taux);
    modification();
    listeTauxCnamgs();
    closeModif();
    this.btnModClient = false;
  }
  
  public void supprimer() throws JDOMException, IOException, NamingException {
    supprimerTier();
    listeTauxCnamgs();
    closeModif();
    this.btnModClient = false;
  }
  
  public void creation() {
    File file = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "medical" + File.separator + "configuration" + File.separator + "tauxCnamgs.xml");
    if (file.exists() == true) {
      SAXBuilder sAXBuilder = new SAXBuilder();
      try {
        this.document = sAXBuilder.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "medical" + File.separator + "configuration" + File.separator + "tauxCnamgs.xml"));
        this.racine = this.document.getRootElement();
        Element element1 = new Element("cnamgs");
        this.racine.addContent((Content)element1);
        Element element2 = new Element("libelle");
        Element element3 = new Element("tauxCmangs");
        element2.setText(this.lib);
        element3.setText("" + this.taux);
        element1.addContent((Content)element2);
        element1.addContent((Content)element3);
        enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "medical" + File.separator + "configuration" + File.separator + "tauxCnamgs.xml");
      } catch (JDOMException jDOMException) {
      
      } catch (IOException iOException) {}
    } else {
      this.racine = new Element("famille");
      this.document = new Document(this.racine);
      Element element1 = new Element("cnamgs");
      this.racine.addContent((Content)element1);
      Element element2 = new Element("libelle");
      Element element3 = new Element("tauxCmangs");
      element2.setText(this.lib);
      element3.setText("" + this.taux);
      element1.addContent((Content)element2);
      element1.addContent((Content)element3);
      enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "medical" + File.separator + "configuration" + File.separator + "tauxCnamgs.xml");
    } 
  }
  
  public void enregistre(String paramString) {
    try {
      XMLOutputter xMLOutputter = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream fileOutputStream = new FileOutputStream(paramString);
      xMLOutputter.output(this.document, fileOutputStream);
      fileOutputStream.close();
    } catch (IOException iOException) {}
  }
  
  public void modification() throws JDOMException, IOException {
    SAXBuilder sAXBuilder = new SAXBuilder();
    Document document = sAXBuilder.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "medical" + File.separator + "configuration" + File.separator + "tauxCnamgs.xml"));
    Element element = document.getRootElement();
    this.listeTauxCnamgs.remove(this.objetFamilleTiers.getIndice());
    this.listeTauxCnamgs.add(this.objetFamilleTiers.getIndice(), this.objetFamilleTiers);
    creerArborescenceXml(element, document);
  }
  
  public void creerArborescenceXml(Element paramElement, Document paramDocument) throws FileNotFoundException, IOException {
    paramElement = paramDocument.getRootElement();
    paramElement.removeContent();
    for (byte b = 0; b < this.listeTauxCnamgs.size(); b++) {
      this.objetFamilleTiers = new ObjetFamilleTiers();
      this.objetFamilleTiers = this.listeTauxCnamgs.get(b);
      Element element1 = new Element("cnamgs");
      Element element2 = new Element("libelle");
      Element element3 = new Element("tauxCmangs");
      element2.setText(this.objetFamilleTiers.getLibelle());
      element1.addContent((Content)element2);
      element1.addContent((Content)element3);
      paramElement.addContent((Content)element1);
    } 
    enregistreFmtClient(paramDocument);
  }
  
  public void enregistreFmtClient(Document paramDocument) throws FileNotFoundException, IOException {
    XMLOutputter xMLOutputter = new XMLOutputter(Format.getPrettyFormat());
    FileOutputStream fileOutputStream = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "medical" + File.separator + "configuration" + File.separator + "tauxCnamgs.xml");
    xMLOutputter.output(paramDocument, fileOutputStream);
    fileOutputStream.close();
  }
  
  public void supprimerTier() throws JDOMException, IOException {
    SAXBuilder sAXBuilder = new SAXBuilder();
    Document document = sAXBuilder.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "medical" + File.separator + "configuration" + File.separator + "tauxCnamgs.xml"));
    Element element = document.getRootElement();
    this.listeTauxCnamgs.remove(this.objetFamilleTiers.getIndice());
    creerArborescenceXml(element, document);
  }
  
  public boolean isBtnModClient() {
    return this.btnModClient;
  }
  
  public void setBtnModClient(boolean paramBoolean) {
    this.btnModClient = paramBoolean;
  }
  
  public DataModel getDataModelTauxCnamgs() {
    return this.dataModelTauxCnamgs;
  }
  
  public void setDataModelTauxCnamgs(DataModel paramDataModel) {
    this.dataModelTauxCnamgs = paramDataModel;
  }
  
  public ObjetFamilleTiers getObjetFamilleTiers() {
    return this.objetFamilleTiers;
  }
  
  public void setObjetFamilleTiers(ObjetFamilleTiers paramObjetFamilleTiers) {
    this.objetFamilleTiers = paramObjetFamilleTiers;
  }
  
  public String getLib() {
    return this.lib;
  }
  
  public void setLib(String paramString) {
    this.lib = paramString;
  }
  
  public int getTaux() {
    return this.taux;
  }
  
  public void setTaux(int paramInt) {
    this.taux = paramInt;
  }
  
  public boolean isAfficheModePanel() {
    return this.afficheModePanel;
  }
  
  public void setAfficheModePanel(boolean paramBoolean) {
    this.afficheModePanel = paramBoolean;
  }
  
  public boolean isAfficheModePanelAjt() {
    return this.afficheModePanelAjt;
  }
  
  public void setAfficheModePanelAjt(boolean paramBoolean) {
    this.afficheModePanelAjt = paramBoolean;
  }
  
  public Document getDocument() {
    return this.document;
  }
  
  public void setDocument(Document paramDocument) {
    this.document = paramDocument;
  }
  
  public Element getRacine() {
    return this.racine;
  }
  
  public void setRacine(Element paramElement) {
    this.racine = paramElement;
  }
  
  public String getBaseLog() {
    return this.baseLog;
  }
  
  public void setBaseLog(String paramString) {
    this.baseLog = paramString;
  }
  
  public Structure getStructureLog() {
    return this.structureLog;
  }
  
  public void setStructureLog(Structure paramStructure) {
    this.structureLog = paramStructure;
  }
  
  public Users getUsersLog() {
    return this.usersLog;
  }
  
  public void setUsersLog(Users paramUsers) {
    this.usersLog = paramUsers;
  }
  
  public UtilInitHibernate getutilInitHibernate() {
    return this.utilInitHibernate;
  }
  
  public void setutilInitHibernate(UtilInitHibernate paramUtilInitHibernate) {
    this.utilInitHibernate = paramUtilInitHibernate;
  }
  
  public String getPageIndex() {
    return this.pageIndex;
  }
  
  public void setPageIndex(String paramString) {
    this.pageIndex = paramString;
  }
  
  public List<ObjetFamilleTiers> getListeTauxCnamgs() {
    return this.listeTauxCnamgs;
  }
  
  public void setListeTauxCnamgs(List<ObjetFamilleTiers> paramList) {
    this.listeTauxCnamgs = paramList;
  }
}
