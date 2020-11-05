package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.SelectItem;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class LectureTypeTiers implements Serializable {
   private List mesTypeTiers;
   private List mesTypeTiersItems;

   public LectureTypeTiers() throws IOException {
      this.recupereCategoriesTiers();
   }

   public void recupereCategoriesTiers() {
      this.mesTypeTiers = new ArrayList();
      this.mesTypeTiersItems = new ArrayList();

      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "Tiers.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         List var6 = var5.getChildren();
         Iterator var7 = var6.iterator();

         while(var7.hasNext()) {
            Element var8 = (Element)var7.next();
            ObjetCategories var9 = new ObjetCategories();
            var9.setLibelle_FR(var8.getChild("libelle_FR").getText());
            var9.setLibelle_SP(var8.getChild("libelle_UK").getText());
            var9.setLibelle_SP(var8.getChild("libelle_SP").getText());
            var9.setCat_FR(var8.getChild("cat_FR").getText());
            var9.setCat_UK(var8.getChild("cat_UK").getText());
            var9.setCat_SP(var8.getChild("cat_SP").getText());
            var9.setCode(var8.getChild("code").getText());
            var9.setType(var8.getChild("type").getText());
            this.mesTypeTiers.add(var9);
            this.mesTypeTiersItems.add(new SelectItem(var9.getCat_FR()));
         }

         var3.close();
      } catch (JDOMException var10) {
      } catch (IOException var11) {
      }

   }

   public List getMesTypeTiers() {
      return this.mesTypeTiers;
   }

   public void setMesTypeTiers(List var1) {
      this.mesTypeTiers = var1;
   }

   public List getMesTypeTiersItems() {
      return this.mesTypeTiersItems;
   }

   public void setMesTypeTiersItems(List var1) {
      this.mesTypeTiersItems = var1;
   }
}
