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

public class LectureNatureMissions implements Serializable {
   private long strId;
   private Structure structureLog;
   private ObjetNatureMissions objetNatureMissions;
   private List lesNaturesMissions = new ArrayList();
   private List mesNaturesMissionsItems;

   public List chargerMesFamillesClientItems() throws JDOMException, IOException {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "ventes" + File.separator + "configuration" + File.separator + "naturesMissions.xml");
         FileReader var3 = null;
         Document var4 = null;
         if (!var2.exists()) {
            var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "ventes" + File.separator + "configuration" + File.separator + "naturesMissions.xml");
            var3 = new FileReader(var2);
            var4 = var1.build(var3);
            this.enregistreFmtClient(var4);
         } else {
            var3 = new FileReader(var2);
            var4 = var1.build(var3);
         }

         Element var5 = var4.getRootElement();
         this.lesNaturesMissions = new ArrayList();
         this.mesNaturesMissionsItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetNatureMissions = new ObjetNatureMissions();
            String var8 = ((Element)var6.get(var7)).getChild("code").getText();
            String var9 = ((Element)var6.get(var7)).getChild("libelle").getText();
            this.objetNatureMissions.setIndice(var7);
            this.objetNatureMissions.setCode(var8);
            this.objetNatureMissions.setLibelle(var9);
            this.lesNaturesMissions.add(this.objetNatureMissions);
            this.mesNaturesMissionsItems.add(new SelectItem(this.objetNatureMissions.getCode() + ":" + this.objetNatureMissions.getLibelle()));
         }

         var3.close();
      } catch (JDOMException var10) {
      } catch (IOException var11) {
      }

      return this.mesNaturesMissionsItems;
   }

   public void enregistreFmtClient(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "ventes" + File.separator + "configuration" + File.separator + "naturesMissions.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public List getLesNaturesMissions() {
      return this.lesNaturesMissions;
   }

   public void setLesNaturesMissions(List var1) {
      this.lesNaturesMissions = var1;
   }

   public List getMesNaturesMissionsItems() {
      return this.mesNaturesMissionsItems;
   }

   public void setMesNaturesMissionsItems(List var1) {
      this.mesNaturesMissionsItems = var1;
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
