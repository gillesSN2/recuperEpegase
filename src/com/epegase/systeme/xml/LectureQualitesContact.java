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

public class LectureQualitesContact implements Serializable {
   private ObjetCompte compte;
   private List mesQualites;
   private List mesQualitesItems;

   public LectureQualitesContact(int var1) throws IOException {
      this.recupereQualites(var1);
   }

   public void recupereQualites(int var1) {
      this.mesQualites = new ArrayList();
      this.mesQualitesItems = new ArrayList();
      String var2 = "";
      if (var1 == 809) {
         var2 = "qualiteContactEleve";
      } else {
         var2 = "qualiteContactPatient";
      }

      try {
         SAXBuilder var3 = new SAXBuilder();
         File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + var2 + ".xml");
         FileReader var5 = new FileReader(var4);
         Document var6 = var3.build(var5);
         Element var7 = var6.getRootElement();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.compte = new ObjetCompte();
            Integer var10 = var9;
            String var11 = ((Element)var8.get(var9)).getChild("code").getText();
            String var12 = ((Element)var8.get(var9)).getChild("nom_FR").getText();
            String var13 = ((Element)var8.get(var9)).getChild("nom_UK").getText();
            String var14 = ((Element)var8.get(var9)).getChild("nom_SP").getText();
            this.compte.setCode("");
            this.compte.setIndice(var10);
            this.compte.setCode(var11);
            this.compte.setNom_FR(var12);
            this.compte.setNom_UK(var13);
            this.compte.setNom_SP(var14);
            this.mesQualites.add(this.compte);
            this.mesQualitesItems.add(new SelectItem(this.compte.getNom_FR()));
         }

         var5.close();
      } catch (JDOMException var15) {
      } catch (IOException var16) {
      }

   }

   public List getMesQualites() {
      return this.mesQualites;
   }

   public void setMesQualites(List var1) {
      this.mesQualites = var1;
   }

   public List getMesQualitesItems() {
      return this.mesQualitesItems;
   }

   public void setMesQualitesItems(List var1) {
      this.mesQualitesItems = var1;
   }
}
