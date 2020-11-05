package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.fileUtil.FileRep;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureParc;
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
import org.xml.sax.SAXException;

public class FormNaturesFamillesProduitsParcs implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LectureNatureParc lectureNatureParc;
   private List listeNatureParc;
   private transient DataModel dataModel = new ListDataModel();
   private Element racine;
   private Document document;
   private ObjetCompte objetCompte;

   public FormNaturesFamillesProduitsParcs(String var1, Structure var2) throws SAXException {
      this.baseLog = var1;
      this.structureLog = var2;
      this.lectureNatureParc = new LectureNatureParc(this.baseLog);
      this.listeNatureParc = this.lectureNatureParc.getMesNatureParc();
      this.dataModel.setWrappedData(this.listeNatureParc);
   }

   public void majNatureParc() throws JDOMException, IOException {
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "parc" + File.separator + "configuration" + File.separator + "naturesParc.xml");
      Element var4;
      Element var5;
      Element var6;
      if (var1.exists()) {
         SAXBuilder var2 = new SAXBuilder();

         try {
            this.document = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "parc" + File.separator + "configuration" + File.separator + "naturesParc.xml"));
            this.racine = this.document.getRootElement();
            this.racine.removeContent();

            for(int var3 = 0; var3 < this.listeNatureParc.size(); ++var3) {
               var4 = new Element("type");
               this.racine.addContent(var4);
               var5 = new Element("code");
               var6 = new Element("nom_FR");
               Element var7 = new Element("etat");
               var5.setText(((ObjetCompte)this.listeNatureParc.get(var3)).getCode());
               var6.setText(((ObjetCompte)this.listeNatureParc.get(var3)).getNom_FR());
               if (((ObjetCompte)this.listeNatureParc.get(var3)).isValide()) {
                  var7.setText("1");
               } else {
                  var7.setText("0");
               }

               var4.addContent(var5);
               var4.addContent(var6);
               var4.addContent(var7);
            }

            this.enregistrer(StaticModePegase.getCheminContext(), this.document);
         } catch (JDOMException var8) {
         } catch (IOException var9) {
         }
      } else {
         this.racine = new Element("naturesFamillesProduits");
         this.document = new Document(this.racine);

         for(int var10 = 0; var10 < this.listeNatureParc.size(); ++var10) {
            Element var11 = new Element("type");
            this.racine.addContent(var11);
            var4 = new Element("code");
            var5 = new Element("nom_FR");
            var6 = new Element("etat");
            var4.setText(((ObjetCompte)this.listeNatureParc.get(var10)).getCode());
            var5.setText(((ObjetCompte)this.listeNatureParc.get(var10)).getNom_FR());
            if (((ObjetCompte)this.listeNatureParc.get(var10)).isValide()) {
               var6.setText("1");
            } else {
               var6.setText("0");
            }

            var11.addContent(var4);
            var11.addContent(var5);
            var11.addContent(var6);
         }

         this.enregistrer(StaticModePegase.getCheminContext(), this.document);
      }

   }

   public void enregistrer(String var1, Document var2) throws FileNotFoundException, IOException {
      XMLOutputter var3 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var4 = new FileOutputStream(var1 + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "parc" + File.separator + "configuration" + File.separator + "naturesParc.xml");
      var3.output(this.getDocument(), var4);
      var4.close();
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "parc" + File.separator + "configuration" + File.separator;
         String var6 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "parc" + File.separator + "configuration" + File.separator;
         File var7 = new File(var5);
         File var8 = new File(var6);
         FileRep.copy(var7, var8);
      }

   }

   public void actualiserListe() {
      new ArrayList();
      this.lectureNatureParc.recupereNatureParcOrigine();
      List var1 = this.lectureNatureParc.getMesNatureParcOrigine();
      if (var1.size() != 0) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            boolean var3 = false;
            String var4 = ((ObjetCompte)var1.get(var2)).getCode();

            for(int var5 = 0; var5 < this.listeNatureParc.size(); ++var5) {
               if (var4.equals(((ObjetCompte)this.listeNatureParc.get(var5)).getCode())) {
                  var3 = true;
                  break;
               }
            }

            if (!var3) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setCode(((ObjetCompte)var1.get(var2)).getCode());
               this.objetCompte.setNom_FR(((ObjetCompte)var1.get(var2)).getNom_FR());
               if (this.objetCompte.getCode().length() == 4) {
                  this.objetCompte.setSens("1");
               } else {
                  this.objetCompte.setSens("0");
               }

               this.listeNatureParc.add(this.objetCompte);
            }
         }

         this.dataModel.setWrappedData(this.listeNatureParc);
      }

   }

   public DataModel getDataModel() {
      return this.dataModel;
   }

   public void setDataModel(DataModel var1) {
      this.dataModel = var1;
   }

   public LectureNatureParc getLectureNatureParc() {
      return this.lectureNatureParc;
   }

   public void setLectureNatureParc(LectureNatureParc var1) {
      this.lectureNatureParc = var1;
   }

   public List getListeNatureParc() {
      return this.listeNatureParc;
   }

   public void setListeNatureParc(List var1) {
      this.listeNatureParc = var1;
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
