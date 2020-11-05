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

public class LectureCategorieTiers implements Serializable {
   private List mesCategoriesTiers;
   private List mesCategoriesTiersItems;

   public LectureCategorieTiers(String var1) throws IOException {
      this.recupereCategoriesTiers(var1);
   }

   public void recupereCategoriesTiers(String var1) {
      this.mesCategoriesTiers = new ArrayList();
      this.mesCategoriesTiersItems = new ArrayList();
      if (var1 != null && !var1.isEmpty()) {
         try {
            SAXBuilder var2 = new SAXBuilder();
            File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + var1 + "_FR.xml");
            FileReader var4 = new FileReader(var3);
            Document var5 = var2.build(var4);
            Element var6 = var5.getRootElement();
            List var7 = var6.getChildren();

            for(int var8 = 0; var8 < var7.size(); ++var8) {
               ObjetCategories var9 = new ObjetCategories();
               String var10 = ((Element)var7.get(var8)).getChild("libelle").getText();
               String var11 = ((Element)var7.get(var8)).getChild("code").getText();
               var9.setCode(var11);
               var9.setLibelle_FR(var10);
               if (!var1.equals("034")) {
                  this.mesCategoriesTiers.add(var9);
                  this.mesCategoriesTiersItems.add(new SelectItem(var9.getLibelle_FR()));
               } else {
                  String var12 = ((Element)var7.get(var8)).getChild("coef").getText();
                  if (var12 == null || var12.isEmpty()) {
                     var12 = "1";
                  }

                  var9.setCoef(Float.parseFloat(var12));
                  this.mesCategoriesTiers.add(var9);
                  this.mesCategoriesTiersItems.add(new SelectItem(var9.getCode(), var9.getLibelle_FR()));
               }
            }

            var4.close();
         } catch (JDOMException var13) {
         } catch (IOException var14) {
         }
      }

   }

   public List getMesCategoriesTiers() {
      return this.mesCategoriesTiers;
   }

   public void setMesCategoriesTiers(List var1) {
      this.mesCategoriesTiers = var1;
   }

   public List getMesCategoriesTiersItems() {
      return this.mesCategoriesTiersItems;
   }

   public void setMesCategoriesTiersItems(List var1) {
      this.mesCategoriesTiersItems = var1;
   }
}
