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

public class LectureNatureMedical implements Serializable {
   private ObjetCompte objetCompte;
   private List mesNatureMedical = new ArrayList();
   private List mesNatureMedicalItems;

   public LectureNatureMedical() {
      this.recupereNatureMedical();
   }

   public void recupereNatureMedical() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "NaturesFamillesProduitsMedical.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesNatureMedical = new ArrayList();
         this.mesNatureMedicalItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetCompte = new ObjetCompte();
            String var8 = ((Element)var6.get(var7)).getChild("code").getText();
            String var9 = ((Element)var6.get(var7)).getChild("nom_FR").getText();
            String var10 = ((Element)var6.get(var7)).getChild("etat").getText();
            this.objetCompte.setCode(var8);
            this.objetCompte.setNom_FR(var9);
            this.objetCompte.setNom_UK(var10);
            this.mesNatureMedical.add(this.objetCompte);
            this.mesNatureMedicalItems.add(new SelectItem(this.objetCompte.getCode() + ":" + this.objetCompte.getNom_FR()));
         }

         var3.close();
      } catch (JDOMException var11) {
      } catch (IOException var12) {
      }

   }

   public List getMesNatureMedical() {
      return this.mesNatureMedical;
   }

   public void setMesNatureMedical(List var1) {
      this.mesNatureMedical = var1;
   }

   public List getMesNatureMedicalItems() {
      return this.mesNatureMedicalItems;
   }

   public void setMesNatureMedicalItems(List var1) {
      this.mesNatureMedicalItems = var1;
   }
}
