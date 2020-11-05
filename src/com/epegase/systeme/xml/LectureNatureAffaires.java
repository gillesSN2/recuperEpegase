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

public class LectureNatureAffaires implements Serializable {
   private long strId;
   private Structure structureLog;
   private ObjetNatureAffaires objetNatureAffaires;
   private List mesNatures = new ArrayList();
   private List mesNaturesItems;

   public List chargerMesNaturesAffaires() throws JDOMException, IOException {
      try {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         SAXBuilder var3 = new SAXBuilder();
         Document var4 = null;
         FileReader var5 = null;
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "naturesAffaires.xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "naturesAffaires.xml");
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
            this.enregistreFmtClient(var4);
         } else {
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
         }

         Element var7 = var4.getRootElement();
         this.mesNatures = new ArrayList();
         this.mesNaturesItems = new ArrayList();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.objetNatureAffaires = new ObjetNatureAffaires();
            String var10 = ((Element)var8.get(var9)).getChild("libelle").getText();
            String var11 = ((Element)var8.get(var9)).getChild("code").getText();
            String var12 = ((Element)var8.get(var9)).getChild("analytique").getText();
            this.objetNatureAffaires.setIndice(var9);
            this.objetNatureAffaires.setLibelle(var10);
            this.objetNatureAffaires.setCode(var11);
            this.objetNatureAffaires.setAnalytique(var12);
            this.mesNatures.add(this.objetNatureAffaires);
            this.mesNaturesItems.add(new SelectItem(this.objetNatureAffaires.getCode() + ":" + this.objetNatureAffaires.getLibelle()));
         }

         var5.close();
      } catch (JDOMException var13) {
      } catch (IOException var14) {
      }

      return this.mesNaturesItems;
   }

   public void enregistreFmtClient(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "naturesAffaires.xml");
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
