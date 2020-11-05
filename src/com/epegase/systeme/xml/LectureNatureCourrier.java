package com.epegase.systeme.xml;

import com.epegase.systeme.classe.Structure;
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

public class LectureNatureCourrier implements Serializable {
   private long strId;
   private Structure structureLog;
   private ObjetNatureCourrier objetNatureCourrier;
   private List mesNatures = new ArrayList();
   private List mesNaturesItems;

   public List chargerMesFamillesClientItems() throws JDOMException, IOException {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "naturesCourriers.xml");
         FileReader var3 = null;
         Document var4 = null;
         File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "naturesCourriers.xml");
         if (!var5.exists()) {
            new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "naturesCourriers.xml");
            var3 = new FileReader(var2);
            var4 = var1.build(var3);
            this.enregistreFmtClient(var4);
         } else {
            var3 = new FileReader(var2);
            var4 = var1.build(var3);
         }

         Element var6 = var4.getRootElement();
         this.mesNatures = new ArrayList();
         this.mesNaturesItems = new ArrayList();
         List var7 = var6.getChildren();

         for(int var8 = 0; var8 < var7.size(); ++var8) {
            this.objetNatureCourrier = new ObjetNatureCourrier();
            String var9 = ((Element)var7.get(var8)).getChild("libelle").getText();
            String var10 = ((Element)var7.get(var8)).getChild("code").getText();
            String var11 = ((Element)var7.get(var8)).getChild("codeNature").getText();
            this.objetNatureCourrier.setIndice(var8);
            this.objetNatureCourrier.setLibelle(var9);
            this.objetNatureCourrier.setCode(var10);
            this.objetNatureCourrier.setCodeNature(Integer.parseInt(var11));
            this.mesNatures.add(this.objetNatureCourrier);
            this.mesNaturesItems.add(new SelectItem(this.objetNatureCourrier.getCode() + ":" + this.objetNatureCourrier.getLibelle()));
         }
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

      return this.mesNaturesItems;
   }

   public String tarifDefaut() throws JDOMException, IOException {
      String var1 = "";
      this.chargerMesFamillesClientItems();
      if (this.mesNatures.size() != 0) {
         var1 = ((ObjetNatureCourrier)this.mesNatures.get(0)).getLibelle();
      }

      return var1;
   }

   public void enregistreFmtClient(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "naturesCourriers.xml");
      var2.output(var1, var3);
      var3.close();
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

   public List getMesNatures() {
      return this.mesNatures;
   }

   public void setMesNatures(List var1) {
      this.mesNatures = var1;
   }

   public List getMesNaturesItems() {
      return this.mesNaturesItems;
   }

   public void setMesNaturesItems(List var1) {
      this.mesNaturesItems = var1;
   }
}
