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

public class LectureTache implements Serializable {
   private ObjetCompte compte;
   private List mesTaches;
   private List mesTachesItems;

   public LectureTache() {
      this.recupereTaches();
   }

   public void recupereTaches() {
      this.mesTaches = new ArrayList();
      this.mesTachesItems = new ArrayList();

      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "taches.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.compte = new ObjetCompte();
            String var8 = ((Element)var6.get(var7)).getChild("mission").getText();
            String var9 = ((Element)var6.get(var7)).getChild("code").getText();
            String var10 = ((Element)var6.get(var7)).getChild("libelle").getText();
            this.compte.setType(var8);
            this.compte.setCode(var9);
            this.compte.setNom_FR(var10);
            this.mesTaches.add(this.compte);
            this.mesTachesItems.add(new SelectItem(this.compte.getCode() + ":" + this.compte.getNom_FR()));
         }

         var3.close();
      } catch (JDOMException var11) {
      } catch (IOException var12) {
      }

   }

   public List getMesTaches() {
      return this.mesTaches;
   }

   public void setMesTaches(List var1) {
      this.mesTaches = var1;
   }

   public List getMesTachesItems() {
      return this.mesTachesItems;
   }

   public void setMesTachesItems(List var1) {
      this.mesTachesItems = var1;
   }
}
