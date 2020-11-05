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

public class LectureNatureDemande implements Serializable {
   private ObjetCompte objetDemande;
   private List mesNatureDemande = new ArrayList();
   private List mesNatureDemandeItems;

   public LectureNatureDemande() throws IOException {
      this.recupereNatureDemande();
   }

   public void recupereNatureDemande() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "naturesDemande.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesNatureDemande = new ArrayList();
         this.mesNatureDemandeItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetDemande = new ObjetCompte();
            String var8 = ((Element)var6.get(var7)).getChild("code").getText();
            String var9 = ((Element)var6.get(var7)).getChild("nom_FR").getText();
            String var10 = ((Element)var6.get(var7)).getChild("nom_UK").getText();
            String var11 = ((Element)var6.get(var7)).getChild("nom_SP").getText();
            String var12 = ((Element)var6.get(var7)).getChild("sens").getText();
            this.objetDemande.setCode(var8);
            this.objetDemande.setNom_FR(var9);
            this.objetDemande.setNom_UK(var10);
            this.objetDemande.setNom_SP(var11);
            this.objetDemande.setSens(var12);
            this.mesNatureDemande.add(this.objetDemande);
            this.mesNatureDemandeItems.add(new SelectItem(this.objetDemande.getCode(), this.objetDemande.getNom_FR()));
         }

         var3.close();
      } catch (JDOMException var13) {
      } catch (IOException var14) {
      }

   }

   public List getMesNatureDemande() {
      return this.mesNatureDemande;
   }

   public void setMesNatureDemande(List var1) {
      this.mesNatureDemande = var1;
   }

   public List getMesNatureDemandeItems() {
      return this.mesNatureDemandeItems;
   }

   public void setMesNatureDemandeItems(List var1) {
      this.mesNatureDemandeItems = var1;
   }
}
