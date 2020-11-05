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

public class LectureNatureSalarie implements Serializable {
   private ObjetCompte objetSalarie;
   private List mesNatureSalarie = new ArrayList();
   private List mesNatureSalarieItems;

   public LectureNatureSalarie() throws IOException {
      this.recupereNatureSalarie();
   }

   public void recupereNatureSalarie() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "naturesSalaries.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesNatureSalarie = new ArrayList();
         this.mesNatureSalarieItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetSalarie = new ObjetCompte();
            String var8 = ((Element)var6.get(var7)).getChild("code").getText();
            String var9 = ((Element)var6.get(var7)).getChild("nom_FR").getText();
            String var10 = ((Element)var6.get(var7)).getChild("nom_UK").getText();
            String var11 = ((Element)var6.get(var7)).getChild("nom_SP").getText();
            this.objetSalarie.setCode(var8);
            this.objetSalarie.setNom_FR(var9);
            this.objetSalarie.setNom_UK(var10);
            this.objetSalarie.setNom_SP(var11);
            this.mesNatureSalarie.add(this.objetSalarie);
            this.mesNatureSalarieItems.add(new SelectItem(this.objetSalarie.getCode() + ":" + this.objetSalarie.getNom_FR()));
         }

         var3.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

   }

   public List getMesNatureSalarie() {
      return this.mesNatureSalarie;
   }

   public void setMesNatureSalarie(List var1) {
      this.mesNatureSalarie = var1;
   }

   public List getMesNatureSalarieItems() {
      return this.mesNatureSalarieItems;
   }

   public void setMesNatureSalarieItems(List var1) {
      this.mesNatureSalarieItems = var1;
   }

   public ObjetCompte getObjetSalarie() {
      return this.objetSalarie;
   }

   public void setObjetSalarie(ObjetCompte var1) {
      this.objetSalarie = var1;
   }
}
