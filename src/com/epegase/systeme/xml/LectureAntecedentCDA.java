package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
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

public class LectureAntecedentCDA implements Serializable {
   private ObjetAntedecentCDA objetAntedecentCDA;
   private List mesAntecedentCDA;
   private List mesAntecedentCDAItems;

   public LectureAntecedentCDA() throws IOException {
      this.recupereCDA();
   }

   public void recupereCDA() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "medicalCDA.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesAntecedentCDA = new ArrayList();
         this.mesAntecedentCDAItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetAntedecentCDA = new ObjetAntedecentCDA();
            Integer var8 = var7;
            String var9 = ((Element)var6.get(var7)).getChild("code").getText();
            String var10 = ((Element)var6.get(var7)).getChild("titre").getText();
            String var11 = ((Element)var6.get(var7)).getChild("libelle").getText();
            String var12 = ((Element)var6.get(var7)).getChild("niveau").getText();
            String var13 = ((Element)var6.get(var7)).getChild("action").getText();
            this.objetAntedecentCDA.setIndice(var8);
            this.objetAntedecentCDA.setCode(var9);
            this.objetAntedecentCDA.setTitre(var10);
            this.objetAntedecentCDA.setLibelle(var11);
            this.objetAntedecentCDA.setNiveau(var12);
            this.objetAntedecentCDA.setAction(var13);
            this.mesAntecedentCDA.add(this.objetAntedecentCDA);
            if (var13.equalsIgnoreCase("1")) {
               this.mesAntecedentCDAItems.add(new SelectItem(this.objetAntedecentCDA.getCode() + ":" + this.objetAntedecentCDA.getTitre()));
            }
         }

         var3.close();
      } catch (JDOMException var14) {
      } catch (IOException var15) {
      }

   }

   public List getMesAntecedentCDA() {
      return this.mesAntecedentCDA;
   }

   public void setMesAntecedentCDA(List var1) {
      this.mesAntecedentCDA = var1;
   }

   public List getMesAntecedentCDAItems() {
      return this.mesAntecedentCDAItems;
   }

   public void setMesAntecedentCDAItems(List var1) {
      this.mesAntecedentCDAItems = var1;
   }
}
