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

public class LectureDestinationForet implements Serializable {
   private long strId;
   private Structure structureLog;
   private ObjetEssenceForet objetEssenceForet;
   private List mesElements = new ArrayList();
   private List mesElementsItems;

   public List chargerClassements() throws JDOMException, IOException {
      try {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "foret" + File.separator + "configuration" + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         SAXBuilder var3 = new SAXBuilder();
         Document var4 = null;
         FileReader var5 = null;
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "foret" + File.separator + "configuration" + File.separator + "classements.xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "foret" + File.separator + "configuration" + File.separator + "classements.xml");
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
            this.enregistreClassements(var4);
         } else {
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
         }

         Element var7 = var4.getRootElement();
         this.mesElements = new ArrayList();
         this.mesElementsItems = new ArrayList();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.objetEssenceForet = new ObjetEssenceForet();
            String var10 = ((Element)var8.get(var9)).getChild("libelle").getText();
            String var11 = ((Element)var8.get(var9)).getChild("code").getText();
            this.objetEssenceForet.setIndice(var9);
            this.objetEssenceForet.setCode(var11);
            this.objetEssenceForet.setLibelle(var10);
            this.mesElements.add(this.objetEssenceForet);
            this.mesElementsItems.add(new SelectItem(this.objetEssenceForet.getLibelle()));
         }

         var5.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

      return this.mesElementsItems;
   }

   public void enregistreClassements(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "foret" + File.separator + "configuration" + File.separator + "classements.xml");
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

   public List getMesElements() {
      return this.mesElements;
   }

   public void setMesElements(List var1) {
      this.mesElements = var1;
   }

   public List getMesElementsItems() {
      return this.mesElementsItems;
   }

   public void setMesElementsItems(List var1) {
      this.mesElementsItems = var1;
   }
}
