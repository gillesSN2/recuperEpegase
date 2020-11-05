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

public class LectureFonctions implements Serializable {
   private ObjetCompte compte;
   private List mesFonctions;
   private List mesfonctionsItems;

   public LectureFonctions(String var1) throws IOException {
      this.recupereFonctions(var1);
   }

   public void recupereFonctions(String var1) {
      try {
         SAXBuilder var2 = new SAXBuilder();
         File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "fonctions.xml");
         FileReader var4 = new FileReader(var3);
         Document var5 = var2.build(var4);
         Element var6 = var5.getRootElement();
         this.mesFonctions = new ArrayList();
         this.mesfonctionsItems = new ArrayList();
         List var7 = var6.getChildren();

         for(int var8 = 0; var8 < var7.size(); ++var8) {
            this.compte = new ObjetCompte();
            Integer var9 = var8;
            String var10 = ((Element)var7.get(var8)).getChild("code").getText();
            String var11 = "";
            String var12 = "";
            String var13 = "";
            if (var1 == null || !var1.equals("Madame") && !var1.equals("Mademoiselle") && !var1.equals("Madam") && !var1.equals("Miss") && !var1.equals("Seniora") && !var1.equals("Seniorita")) {
               var11 = ((Element)var7.get(var8)).getChild("nom_FR").getText();
               var12 = ((Element)var7.get(var8)).getChild("nom_UK").getText();
               var13 = ((Element)var7.get(var8)).getChild("nom_SP").getText();
            } else {
               var11 = ((Element)var7.get(var8)).getChild("nom_FR_femme").getText();
               var12 = ((Element)var7.get(var8)).getChild("nom_UK_femme").getText();
               var13 = ((Element)var7.get(var8)).getChild("nom_SP_femme").getText();
            }

            this.compte.setCode("");
            this.compte.setIndice(var9);
            this.compte.setCode(var10);
            this.compte.setNom_FR(var11);
            this.compte.setNom_UK(var12);
            this.compte.setNom_SP(var13);
            this.mesFonctions.add(this.compte);
            this.mesfonctionsItems.add(new SelectItem(this.compte.getNom_FR()));
         }

         var4.close();
      } catch (JDOMException var14) {
      } catch (IOException var15) {
      }

   }

   public List getMesFonctions() {
      return this.mesFonctions;
   }

   public void setMesFonctions(List var1) {
      this.mesFonctions = var1;
   }

   public List getMesfonctionsItems() {
      return this.mesfonctionsItems;
   }

   public void setMesfonctionsItems(List var1) {
      this.mesfonctionsItems = var1;
   }
}
