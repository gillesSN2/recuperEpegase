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

public class LectureDent implements Serializable {
   private ObjetDent objetDent;
   private List mesElements = new ArrayList();
   private List mesElementsItems;

   public LectureDent(int var1, int var2) {
      this.lectureDentFDI(var1, var2);
   }

   public void lectureDentFDI(int var1, int var2) {
      try {
         SAXBuilder var3 = new SAXBuilder();
         this.mesElements = new ArrayList();
         this.mesElementsItems = new ArrayList();
         if (var1 >= 1 && var1 <= 2) {
            String var4 = "";
            if (var1 == 1) {
               var4 = "medicalDent_FDI";
            } else if (var1 == 2) {
               var4 = "medicalDent_US";
            } else if (var1 == 2) {
               var4 = "medicalDent_PALMER";
            }

            File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + var4 + ".xml");
            FileReader var6 = new FileReader(var5);
            Document var7 = var3.build(var6);
            Element var8 = var7.getRootElement();
            List var9 = var8.getChildren();

            for(int var10 = 0; var10 < var9.size(); ++var10) {
               this.objetDent = new ObjetDent();
               String var11 = ((Element)var9.get(var10)).getChild("code").getText();
               String var12 = ((Element)var9.get(var10)).getChild("nom_FR").getText();
               String var13 = ((Element)var9.get(var10)).getChild("type").getText();
               this.objetDent.setCode(var11);
               this.objetDent.setNom_FR(var12);
               this.objetDent.setType(var13);
               if (var2 == 0 && var13.equals("0")) {
                  this.mesElements.add(this.objetDent);
                  this.mesElementsItems.add(new SelectItem(this.objetDent.getCode(), this.objetDent.getCode() + ":" + this.objetDent.getNom_FR()));
               } else if (var2 == 1 && var13.equals("1")) {
                  this.mesElements.add(this.objetDent);
                  this.mesElementsItems.add(new SelectItem(this.objetDent.getCode(), this.objetDent.getCode() + ":" + this.objetDent.getNom_FR()));
               }
            }

            var6.close();
         }
      } catch (JDOMException var14) {
      } catch (IOException var15) {
      }

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
