package com.epegase.systeme.xml;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.control.ObjetNaturePret;
import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class LectureNaturePrets implements Serializable {
   private long strId;
   private Structure structureLog;
   private ObjetNaturePret objetNaturePret;
   private List mesNaturesPrets = new ArrayList();
   private List mesNaturesPretsItems;

   public List chargerMesNaturesPretsItems() throws JDOMException, IOException {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "paye" + File.separator + "configuration" + File.separator + "naturePrets.xml");
         FileReader var3 = null;
         Document var4 = null;
         Element var5;
         if (!var2.exists()) {
            var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "naturePrets.xml");
            if (!var2.exists()) {
               var5 = new Element("nature");
               var4 = new Document(var5);
               Element var6 = new Element("pret");
               var5.addContent(var6);
               Element var7 = new Element("libelle");
               Element var8 = new Element("code");
               var7.setText("Non Renseigné");
               var8.setText("0");
               var6.addContent(var7);
               var6.addContent(var8);
               var6 = new Element("pret");
               var5.addContent(var6);
               var7 = new Element("libelle");
               var8 = new Element("code");
               var7.setText("Avances Exceptionnelles");
               var8.setText("1");
               var6.addContent(var7);
               var6.addContent(var8);
               var6 = new Element("pret");
               var5.addContent(var6);
               var7 = new Element("libelle");
               var8 = new Element("code");
               var7.setText("Soins médicaux");
               var8.setText("2");
               var6.addContent(var7);
               var6.addContent(var8);
               var6 = new Element("pret");
               var5.addContent(var6);
               var7 = new Element("libelle");
               var8 = new Element("code");
               var7.setText("Cessions");
               var8.setText("3");
               var6.addContent(var7);
               var6.addContent(var8);
               var6 = new Element("pret");
               var5.addContent(var6);
               var7 = new Element("libelle");
               var8 = new Element("code");
               var7.setText("Traites");
               var8.setText("4");
               var6.addContent(var7);
               var6.addContent(var8);
               var6 = new Element("pret");
               var5.addContent(var6);
               var7 = new Element("libelle");
               var8 = new Element("code");
               var7.setText("Familliaux");
               var8.setText("5");
               var6.addContent(var7);
               var6.addContent(var8);
               var6 = new Element("pret");
               var5.addContent(var6);
               var7 = new Element("libelle");
               var8 = new Element("code");
               var7.setText("Religieux");
               var8.setText("6");
               var6.addContent(var7);
               var6.addContent(var8);
               var6 = new Element("pret");
               var5.addContent(var6);
               var7 = new Element("libelle");
               var8 = new Element("code");
               var7.setText("Avances Etalées");
               var8.setText("7");
               var6.addContent(var7);
               var6.addContent(var8);
               this.enregistreFmtConfiguration(var4);
               var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "naturePrets.xml");
            }

            var3 = new FileReader(var2);
            var4 = var1.build(var3);
            this.enregistreFmtClient(var4);
         } else {
            var3 = new FileReader(var2);
            var4 = var1.build(var3);
         }

         var5 = var4.getRootElement();
         this.mesNaturesPrets = new ArrayList();
         this.mesNaturesPretsItems = new ArrayList();
         List var12 = var5.getChildren();

         for(int var13 = 0; var13 < var12.size(); ++var13) {
            this.objetNaturePret = new ObjetNaturePret();
            String var14 = ((Element)var12.get(var13)).getChild("libelle").getText();
            String var9 = ((Element)var12.get(var13)).getChild("code").getText();
            this.objetNaturePret.setLibelle(var14);
            this.objetNaturePret.setCode(var9);
            this.mesNaturesPrets.add(this.objetNaturePret);
            this.mesNaturesPretsItems.add(new SelectItem(this.objetNaturePret.getCode(), this.objetNaturePret.getLibelle()));
         }

         var3.close();
      } catch (JDOMException var10) {
      } catch (IOException var11) {
      }

      return this.mesNaturesPretsItems;
   }

   public void enregistreFmtConfiguration(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "naturePrets.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public void enregistreFmtClient(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "paye" + File.separator + "configuration" + File.separator + "naturePrets.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public List getMesNaturesPrets() {
      return this.mesNaturesPrets;
   }

   public void setMesNaturesPrets(List var1) {
      this.mesNaturesPrets = var1;
   }

   public List getMesNaturesPretsItems() {
      return this.mesNaturesPretsItems;
   }

   public void setMesNaturesPretsItems(List var1) {
      this.mesNaturesPretsItems = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }
}
