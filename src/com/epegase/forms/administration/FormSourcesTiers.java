package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureSourcesTiers;
import com.epegase.systeme.xml.ObjetCompte;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FormSourcesTiers implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LectureSourcesTiers lectureSourcesTiers;
   private List listeSourcesTiers;
   private ObjetCompte objetCompte;
   private boolean showModalPanelsource = false;
   private boolean afficherSource = false;
   private transient DataModel dataModelSourcesTiers = new ListDataModel();

   public FormSourcesTiers(Structure var1) {
      this.structureLog = var1;
      this.lectureSourcesTiers = new LectureSourcesTiers(this.structureLog.getStrid());
      this.listeSourcesTiers = this.lectureSourcesTiers.getMesSourcesTiers();
      this.dataModelSourcesTiers.setWrappedData(this.listeSourcesTiers);
   }

   public void selectionSource() {
      if (this.dataModelSourcesTiers.isRowAvailable()) {
         this.objetCompte = (ObjetCompte)this.dataModelSourcesTiers.getRowData();
         this.afficherSource = true;
      }

   }

   public void ajouterSource() {
      this.objetCompte = new ObjetCompte();
      this.objetCompte.setIndice(0);
      this.showModalPanelsource = true;
   }

   public void modifierSource() {
      if (this.objetCompte != null) {
         this.showModalPanelsource = true;
      }

   }

   public void suprimerSource() throws JDOMException, IOException {
      if (this.objetCompte != null) {
         this.listeSourcesTiers.remove(this.objetCompte);
         SAXBuilder var1 = new SAXBuilder();
         Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "sourceTiers.xml"));
         Element var3 = var2.getRootElement();
         this.majArborescenceXml(var3, var2);
         this.afficherSource = false;
      }

   }

   public void fermerSource() {
      this.showModalPanelsource = false;
      this.afficherSource = false;
   }

   public void validerSource() throws JDOMException, IOException {
      if (this.objetCompte.getIndice() == 0) {
         this.objetCompte.setIndice(this.listeSourcesTiers.size());
         this.listeSourcesTiers.add(this.objetCompte);
         this.dataModelSourcesTiers.setWrappedData(this.listeSourcesTiers);
      }

      SAXBuilder var1 = new SAXBuilder();
      Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "sourceTiers.xml"));
      Element var3 = var2.getRootElement();
      this.majArborescenceXml(var3, var2);
      this.showModalPanelsource = false;
   }

   public void majArborescenceXml(Element var1, Document var2) throws FileNotFoundException, IOException {
      var1 = var2.getRootElement();
      var1.removeContent();
      this.objetCompte = new ObjetCompte();

      for(int var3 = 0; var3 < this.listeSourcesTiers.size(); ++var3) {
         this.objetCompte = (ObjetCompte)this.listeSourcesTiers.get(var3);
         Element var4 = new Element("source");
         Element var5 = new Element("nom_FR");
         Element var6 = new Element("nom_UK");
         Element var7 = new Element("nom_SP");
         Element var8 = new Element("centreId");
         var5.setText(this.objetCompte.getNom_FR());
         var6.setText(this.objetCompte.getNom_UK());
         var7.setText(this.objetCompte.getNom_SP());
         var8.setText("" + this.objetCompte.getCentreId());
         var4.addContent(var5);
         var4.addContent(var6);
         var4.addContent(var7);
         var4.addContent(var8);
         var1.addContent(var4);
      }

      XMLOutputter var9 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var10 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "sourceTiers.xml");
      var9.output(var2, var10);
      var10.close();
   }

   public DataModel getDataModelSourcesTiers() {
      return this.dataModelSourcesTiers;
   }

   public void setDataModelSourcesTiers(DataModel var1) {
      this.dataModelSourcesTiers = var1;
   }

   public LectureSourcesTiers getLectureSourcesTiers() {
      return this.lectureSourcesTiers;
   }

   public void setLectureSourcesTiers(LectureSourcesTiers var1) {
      this.lectureSourcesTiers = var1;
   }

   public List getListeSourcesTiers() {
      return this.listeSourcesTiers;
   }

   public void setListeSourcesTiers(List var1) {
      this.listeSourcesTiers = var1;
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

   public ObjetCompte getObjetCompte() {
      return this.objetCompte;
   }

   public void setObjetCompte(ObjetCompte var1) {
      this.objetCompte = var1;
   }

   public boolean isShowModalPanelsource() {
      return this.showModalPanelsource;
   }

   public void setShowModalPanelsource(boolean var1) {
      this.showModalPanelsource = var1;
   }

   public boolean isAfficherSource() {
      return this.afficherSource;
   }

   public void setAfficherSource(boolean var1) {
      this.afficherSource = var1;
   }
}
