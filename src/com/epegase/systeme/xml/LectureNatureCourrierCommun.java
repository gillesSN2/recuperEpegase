package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class LectureNatureCourrierCommun implements Serializable {
   private ObjetNatureCourrier objetNatureCourrier;
   private List mesNatures = new ArrayList();

   public void chargerMesFamillesClientItems() throws JDOMException, IOException {
      try {
         File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "naturesCourriers.xml");
         if (var1.exists()) {
            SAXBuilder var2 = new SAXBuilder();
            FileReader var3 = new FileReader(var1);
            Document var4 = var2.build(var3);
            Element var5 = var4.getRootElement();
            this.mesNatures = new ArrayList();
            List var6 = var5.getChildren();

            for(int var7 = 0; var7 < var6.size(); ++var7) {
               this.objetNatureCourrier = new ObjetNatureCourrier();
               String var8 = ((Element)var6.get(var7)).getChild("libelle").getText();
               String var9 = ((Element)var6.get(var7)).getChild("code").getText();
               String var10 = ((Element)var6.get(var7)).getChild("codeNature").getText();
               this.objetNatureCourrier.setIndice(var7);
               this.objetNatureCourrier.setLibelle(var8);
               this.objetNatureCourrier.setCode(var9);
               this.objetNatureCourrier.setCodeNature(Integer.parseInt(var10));
               this.mesNatures.add(this.objetNatureCourrier);
            }

            var3.close();
         } else {
            this.mesNatures.clear();
         }
      } catch (JDOMException var11) {
      } catch (IOException var12) {
      }

   }

   public List getMesNatures() {
      return this.mesNatures;
   }

   public void setMesNatures(List var1) {
      this.mesNatures = var1;
   }
}
