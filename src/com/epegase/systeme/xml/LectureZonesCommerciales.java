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

public class LectureZonesCommerciales implements Serializable {
   private ObjetCompte compte;
   private List mesZonesCommerciales;
   private List mesZonesCommercialesItems;

   public LectureZonesCommerciales() {
      this.recupereZonesCommerciales();
   }

   public void recupereZonesCommerciales() {
      this.mesZonesCommerciales = new ArrayList();
      this.mesZonesCommercialesItems = new ArrayList();

      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "zoneCommerciale.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.compte = new ObjetCompte();
            Integer var8 = var7;
            String var9 = ((Element)var6.get(var7)).getChild("code").getText();
            this.compte.setCode("");
            this.compte.setIndice(var8);
            this.compte.setCode(var9);
            this.mesZonesCommerciales.add(this.compte);
            this.mesZonesCommercialesItems.add(new SelectItem(this.compte.getCode()));
         }

         var3.close();
      } catch (JDOMException var10) {
      } catch (IOException var11) {
      }

   }

   public List getMesZonesCommerciales() {
      return this.mesZonesCommerciales;
   }

   public void setMesZonesCommerciales(List var1) {
      this.mesZonesCommerciales = var1;
   }

   public List getMesZonesCommercialesItems() {
      return this.mesZonesCommercialesItems;
   }

   public void setMesZonesCommercialesItems(List var1) {
      this.mesZonesCommercialesItems = var1;
   }
}
