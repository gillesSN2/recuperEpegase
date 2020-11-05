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

public class LectureProvenance implements Serializable {
   private ObjetCompte objetCompte;
   private List mesProvenance = new ArrayList();
   private List mesProvenanceItems;

   public LectureProvenance() {
      this.recupereProvenance();
   }

   public void recupereProvenance() {
      this.mesProvenance = new ArrayList();
      this.mesProvenanceItems = new ArrayList();

      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "medicalProvenance.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
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
            this.mesProvenance.add(this.objetCompte);
            this.mesProvenanceItems.add(new SelectItem(this.objetCompte.getCode(), this.objetCompte.getCode() + ":" + this.objetCompte.getNom_FR()));
         }

         var3.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

   }

   public List getMesProvenance() {
      return this.mesProvenance;
   }

   public void setMesProvenance(List var1) {
      this.mesProvenance = var1;
   }

   public List getMesProvenanceItems() {
      return this.mesProvenanceItems;
   }

   public void setMesProvenanceItems(List var1) {
      this.mesProvenanceItems = var1;
   }
}
