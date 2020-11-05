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

public class LectureCategorieExamen implements Serializable {
   private ObjetCompte objetCompte;
   private List mesCategories = new ArrayList();
   private List mesCategoriesItems;

   public LectureCategorieExamen() {
      this.recupereCategorie();
   }

   public void recupereCategorie() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "medicalCategorieExamen.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesCategories = new ArrayList();
         this.mesCategoriesItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetCompte = new ObjetCompte();
            String var8 = ((Element)var6.get(var7)).getChild("nom_FR").getText();
            String var9 = ((Element)var6.get(var7)).getChild("nom_UK").getText();
            String var10 = ((Element)var6.get(var7)).getChild("nom_SP").getText();
            this.objetCompte.setNom_FR(var8);
            this.objetCompte.setNom_UK(var9);
            this.objetCompte.setNom_SP(var10);
            this.mesCategories.add(this.objetCompte);
            this.mesCategoriesItems.add(new SelectItem(this.objetCompte.getNom_FR()));
         }

         var3.close();
      } catch (JDOMException var11) {
      } catch (IOException var12) {
      }

   }

   public List getMesCategories() {
      return this.mesCategories;
   }

   public void setMesCategories(List var1) {
      this.mesCategories = var1;
   }

   public List getMesCategoriesItems() {
      return this.mesCategoriesItems;
   }

   public void setMesCategoriesItems(List var1) {
      this.mesCategoriesItems = var1;
   }
}
