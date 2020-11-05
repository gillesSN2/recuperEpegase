package com.epegase.systeme.xml;

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

public class LectureSites implements Serializable {
   private ObjetSites objetSites;
   private List mesSites;
   private List mesSitesItems;

   public LectureSites(String var1) throws IOException {
      this.recupereFonctions(var1);
   }

   public void recupereFonctions(String var1) {
      this.mesSites = new ArrayList();
      this.mesSitesItems = new ArrayList();

      try {
         SAXBuilder var2 = new SAXBuilder();
         File var3 = new File(var1);
         FileReader var4 = new FileReader(var3);
         Document var5 = var2.build(var4);
         Element var6 = var5.getRootElement();
         List var7 = var6.getChildren();

         for(int var8 = 0; var8 < var7.size(); ++var8) {
            this.objetSites = new ObjetSites();
            Integer var9 = var8;
            String var10 = ((Element)var7.get(var8)).getChild("nom").getText();
            String var11 = ((Element)var7.get(var8)).getChild("url").getText();
            this.objetSites.setNom(var10);
            this.objetSites.setUrl(var11);
            this.mesSites.add(this.objetSites);
            this.mesSitesItems.add(new SelectItem(this.objetSites.getNom()));
         }

         var4.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

   }

   public List getMesSites() {
      return this.mesSites;
   }

   public void setMesSites(List var1) {
      this.mesSites = var1;
   }

   public List getMesSitesItems() {
      return this.mesSitesItems;
   }

   public void setMesSitesItems(List var1) {
      this.mesSitesItems = var1;
   }

   public ObjetSites getObjetSites() {
      return this.objetSites;
   }

   public void setObjetSites(ObjetSites var1) {
      this.objetSites = var1;
   }
}
