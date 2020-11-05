package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.fileUtil.FileRep;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureBiens;
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
import org.xml.sax.SAXException;

public class FormNaturesBiens implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LectureNatureBiens lectureNatureBiens;
   private List listeNatureBiens;
   private transient DataModel dataModel = new ListDataModel();
   private Element racine;
   private Document document;
   private ObjetCompte objetCompte;

   public FormNaturesBiens(String var1, Structure var2) throws SAXException {
      this.baseLog = var1;
      this.structureLog = var2;
      this.lectureNatureBiens = new LectureNatureBiens(var1);
      this.listeNatureBiens = this.lectureNatureBiens.getMesNatureBiens();
      this.dataModel.setWrappedData(this.listeNatureBiens);
   }

   public void majNatureBiens() throws JDOMException, IOException {
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "immobilier" + File.separator + "configuration" + File.separator + "naturesBiens.xml");
      Element var4;
      Element var5;
      Element var6;
      Element var7;
      Element var8;
      Element var9;
      if (var1.exists()) {
         SAXBuilder var2 = new SAXBuilder();

         try {
            this.document = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "immobilier" + File.separator + "configuration" + File.separator + "naturesBiens.xml"));
            this.racine = this.document.getRootElement();
            this.racine.removeContent();

            for(int var3 = 0; var3 < this.listeNatureBiens.size(); ++var3) {
               var4 = new Element("type");
               this.racine.addContent(var4);
               var5 = new Element("code");
               var6 = new Element("nom_FR");
               var7 = new Element("etatLocation");
               var8 = new Element("etatSyndic");
               var9 = new Element("etatNegoce");
               Element var10 = new Element("etatPromoteur");
               var5.setText(((ObjetCompte)this.listeNatureBiens.get(var3)).getCode());
               var6.setText(((ObjetCompte)this.listeNatureBiens.get(var3)).getNom_FR());
               if (((ObjetCompte)this.listeNatureBiens.get(var3)).isValideLocation()) {
                  var7.setText("1");
               } else {
                  var7.setText("0");
               }

               if (((ObjetCompte)this.listeNatureBiens.get(var3)).isValideSyndic()) {
                  var8.setText("1");
               } else {
                  var8.setText("0");
               }

               if (((ObjetCompte)this.listeNatureBiens.get(var3)).isValideNegoce()) {
                  var9.setText("1");
               } else {
                  var9.setText("0");
               }

               if (((ObjetCompte)this.listeNatureBiens.get(var3)).isValidePromoteur()) {
                  var10.setText("1");
               } else {
                  var10.setText("0");
               }

               var4.addContent(var5);
               var4.addContent(var6);
               var4.addContent(var7);
               var4.addContent(var8);
               var4.addContent(var9);
               var4.addContent(var10);
            }

            this.enregistrer(StaticModePegase.getCheminContext(), this.document);
         } catch (JDOMException var11) {
         } catch (IOException var12) {
         }
      } else {
         this.racine = new Element("naturesFamillesBiens");
         this.document = new Document(this.racine);

         for(int var13 = 0; var13 < this.listeNatureBiens.size(); ++var13) {
            Element var14 = new Element("type");
            this.racine.addContent(var14);
            var4 = new Element("code");
            var5 = new Element("nom_FR");
            var6 = new Element("etatLocation");
            var7 = new Element("etatSyndic");
            var8 = new Element("etatNegoce");
            var9 = new Element("etatPromotion");
            var4.setText(((ObjetCompte)this.listeNatureBiens.get(var13)).getCode());
            var5.setText(((ObjetCompte)this.listeNatureBiens.get(var13)).getNom_FR());
            if (((ObjetCompte)this.listeNatureBiens.get(var13)).isValideLocation()) {
               var6.setText("1");
            } else {
               var6.setText("0");
            }

            if (((ObjetCompte)this.listeNatureBiens.get(var13)).isValideSyndic()) {
               var7.setText("1");
            } else {
               var7.setText("0");
            }

            if (((ObjetCompte)this.listeNatureBiens.get(var13)).isValideNegoce()) {
               var8.setText("1");
            } else {
               var8.setText("0");
            }

            if (((ObjetCompte)this.listeNatureBiens.get(var13)).isValidePromoteur()) {
               var9.setText("1");
            } else {
               var9.setText("0");
            }

            var14.addContent(var4);
            var14.addContent(var5);
            var14.addContent(var6);
            var14.addContent(var7);
            var14.addContent(var8);
            var14.addContent(var9);
         }

         this.enregistrer(StaticModePegase.getCheminContext(), this.document);
      }

   }

   public void enregistrer(String var1, Document var2) throws FileNotFoundException, IOException {
      XMLOutputter var3 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var4 = new FileOutputStream(var1 + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "immobilier" + File.separator + "configuration" + File.separator + "naturesBiens.xml");
      var3.output(this.getDocument(), var4);
      var4.close();
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "immobilier" + File.separator + "configuration" + File.separator;
         String var6 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "immobilier" + File.separator + "configuration" + File.separator;
         File var7 = new File(var5);
         File var8 = new File(var6);
         FileRep.copy(var7, var8);
      }

   }

   public DataModel getDataModel() {
      return this.dataModel;
   }

   public void setDataModel(DataModel var1) {
      this.dataModel = var1;
   }

   public LectureNatureBiens getLectureNatureBiens() {
      return this.lectureNatureBiens;
   }

   public void setLectureNatureBiens(LectureNatureBiens var1) {
      this.lectureNatureBiens = var1;
   }

   public List getListeNatureBiens() {
      return this.listeNatureBiens;
   }

   public void setListeNatureBiens(List var1) {
      this.listeNatureBiens = var1;
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
}
