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

public class LectureSuffixeProduction implements Serializable {
   private ObjetSuffixeProduction objetSuffixeProduction;
   private List mesSuffixes;
   private List mesSuffixesItems;

   public LectureSuffixeProduction() throws IOException {
      this.recupereSuffixes();
   }

   public void recupereSuffixes() {
      this.mesSuffixes = new ArrayList();
      this.mesSuffixesItems = new ArrayList();

      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "suffixeProduction.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetSuffixeProduction = new ObjetSuffixeProduction();
            Integer var8 = var7;
            String var9 = ((Element)var6.get(var7)).getChild("nom").getText();
            String var10 = ((Element)var6.get(var7)).getChild("code").getText();
            this.objetSuffixeProduction.setNom(var9);
            this.objetSuffixeProduction.setCode(var10);
            this.mesSuffixes.add(this.objetSuffixeProduction);
            this.mesSuffixesItems.add(new SelectItem(this.objetSuffixeProduction.getCode(), this.objetSuffixeProduction.getCode() + ":" + this.objetSuffixeProduction.getNom()));
         }

         var3.close();
      } catch (JDOMException var11) {
      } catch (IOException var12) {
      }

   }

   public List getMesSuffixes() {
      return this.mesSuffixes;
   }

   public void setMesSuffixes(List var1) {
      this.mesSuffixes = var1;
   }

   public List getMesSuffixesItems() {
      return this.mesSuffixesItems;
   }

   public void setMesSuffixesItems(List var1) {
      this.mesSuffixesItems = var1;
   }
}
