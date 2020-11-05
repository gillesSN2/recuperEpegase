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

public class LectureInfirmerieTuberTest implements Serializable {
   private ObjetCompte objetCompte;
   private List mesElements = new ArrayList();
   private List mesElementsItems;

   public LectureInfirmerieTuberTest() {
      this.recupereVaccin();
   }

   public void recupereVaccin() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "medicalTubertest.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesElements = new ArrayList();
         this.mesElementsItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetCompte = new ObjetCompte();
            String var8 = ((Element)var6.get(var7)).getChild("code").getText();
            String var9 = ((Element)var6.get(var7)).getChild("nom_FR").getText();
            String var10 = ((Element)var6.get(var7)).getChild("nom_UK").getText();
            String var11 = ((Element)var6.get(var7)).getChild("nom_SP").getText();
            this.objetCompte.setCode(var8);
            this.objetCompte.setNom_FR(var9);
            this.objetCompte.setNom_UK(var10);
            this.objetCompte.setNom_SP(var11);
            this.mesElements.add(this.objetCompte);
            this.mesElementsItems.add(new SelectItem(this.objetCompte.getCode(), this.objetCompte.getCode() + ":" + this.objetCompte.getNom_FR()));
         }

         var3.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
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
