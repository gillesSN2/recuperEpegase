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

public class LectureDevisModeReglement implements Serializable {
   private ObjetCompte objetCompte;
   private List mesElements = new ArrayList();
   private List mesElementsItems;

   public LectureDevisModeReglement(long var1) {
      this.recupereModeReglement(var1);
   }

   public void recupereModeReglement(long var1) {
      try {
         SAXBuilder var3 = new SAXBuilder();
         boolean var4 = false;
         File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "ventes" + File.separator + "configuration" + File.separator + "devisModeReglement.xml");
         if (var5.exists()) {
            var4 = true;
         }

         if (var4) {
            FileReader var6 = new FileReader(var5);
            Document var7 = var3.build(var6);
            Element var8 = var7.getRootElement();
            this.mesElements = new ArrayList();
            this.mesElementsItems = new ArrayList();
            List var9 = var8.getChildren();

            for(int var10 = 0; var10 < var9.size(); ++var10) {
               this.objetCompte = new ObjetCompte();
               String var11 = ((Element)var9.get(var10)).getChild("code").getText();
               String var12 = ((Element)var9.get(var10)).getChild("nom_FR").getText();
               this.objetCompte.setCode(var11);
               this.objetCompte.setNom_FR(var12);
               this.mesElements.add(this.objetCompte);
               this.mesElementsItems.add(new SelectItem(this.objetCompte.getNom_FR()));
            }

            var6.close();
         }
      } catch (JDOMException var13) {
      } catch (IOException var14) {
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
