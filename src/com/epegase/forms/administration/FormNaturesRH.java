package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureRH;
import com.epegase.systeme.xml.ObjetCompte;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FormNaturesRH implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private Element racine;
   private Document document;
   private LectureNatureRH lectureNatureRH;
   private ObjetCompte objetCompte;
   private List listeNature = new ArrayList();
   private transient DataModel dataModelNature = new ListDataModel();

   public void chargerNatureRH() {
      this.lectureNatureRH = new LectureNatureRH();
      this.lectureNatureRH.setStrId(this.structureLog.getStrid());
      this.lectureNatureRH.setStructureLog(this.structureLog);
      this.lectureNatureRH.recuperePaye();
      this.listeNature = this.lectureNatureRH.getMesNatureRh();
      this.dataModelNature.setWrappedData(this.listeNature);
   }

   public void majNatureRh() throws FileNotFoundException, IOException {
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "natureRH.xml");
      Element var4;
      Element var5;
      Element var6;
      Element var7;
      if (var1.exists()) {
         SAXBuilder var2 = new SAXBuilder();

         try {
            this.document = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "natureRH.xml"));
            this.racine = this.document.getRootElement();
            this.racine.removeContent();

            for(int var3 = 0; var3 < this.listeNature.size(); ++var3) {
               var4 = new Element("rh");
               this.racine.addContent(var4);
               var5 = new Element("libelle");
               var6 = new Element("code");
               var7 = new Element("chrono");
               Element var8 = new Element("inactif");
               var5.setText(((ObjetCompte)this.listeNature.get(var3)).getNom_FR());
               var6.setText(((ObjetCompte)this.listeNature.get(var3)).getCode());
               var7.setText(((ObjetCompte)this.listeNature.get(var3)).getLot());
               if (((ObjetCompte)this.listeNature.get(var3)).isValide()) {
                  var8.setText("1");
               } else {
                  var8.setText("0");
               }

               var4.addContent(var5);
               var4.addContent(var6);
               var4.addContent(var7);
               var4.addContent(var8);
            }

            this.enregistrer(StaticModePegase.getCheminContext(), this.document);
         } catch (JDOMException var9) {
         } catch (IOException var10) {
         }
      } else {
         this.racine = new Element("nature");
         this.document = new Document(this.racine);

         for(int var11 = 0; var11 < this.listeNature.size(); ++var11) {
            Element var12 = new Element("rh");
            this.racine.addContent(var12);
            var4 = new Element("libelle");
            var5 = new Element("code");
            var6 = new Element("chrono");
            var7 = new Element("inactif");
            var4.setText(((ObjetCompte)this.listeNature.get(var11)).getNom_FR());
            var5.setText(((ObjetCompte)this.listeNature.get(var11)).getCode());
            var6.setText(((ObjetCompte)this.listeNature.get(var11)).getLot());
            if (((ObjetCompte)this.listeNature.get(var11)).isValide()) {
               var7.setText("1");
            } else {
               var7.setText("0");
            }

            var12.addContent(var4);
            var12.addContent(var5);
            var12.addContent(var6);
            var12.addContent(var7);
         }

         this.enregistrer(StaticModePegase.getCheminContext(), this.document);
      }

   }

   public void enregistrer(String var1, Document var2) throws FileNotFoundException, IOException {
      XMLOutputter var3 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var4 = new FileOutputStream(var1 + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "natureRH.xml");
      var3.output(this.getDocument(), var4);
      var4.close();
   }

   public void allSelect() throws FileNotFoundException, IOException {
      for(int var1 = 0; var1 < this.listeNature.size(); ++var1) {
         this.objetCompte = (ObjetCompte)this.listeNature.get(var1);
         this.objetCompte.setValide(true);
      }

   }

   public void allDeSelect() {
      for(int var1 = 0; var1 < this.listeNature.size(); ++var1) {
         this.objetCompte = (ObjetCompte)this.listeNature.get(var1);
         this.objetCompte.setValide(false);
      }

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

   public DataModel getDataModelNature() {
      return this.dataModelNature;
   }

   public void setDataModelNature(DataModel var1) {
      this.dataModelNature = var1;
   }

   public LectureNatureRH getLectureNatureRH() {
      return this.lectureNatureRH;
   }

   public void setLectureNatureRH(LectureNatureRH var1) {
      this.lectureNatureRH = var1;
   }

   public List getListeNature() {
      return this.listeNature;
   }

   public void setListeNature(List var1) {
      this.listeNature = var1;
   }
}
