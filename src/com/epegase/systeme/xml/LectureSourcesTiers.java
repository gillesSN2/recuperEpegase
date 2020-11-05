package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDownload;
import java.io.File;
import java.io.FileNotFoundException;
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

public class LectureSourcesTiers implements Serializable {
   private ObjetCompte compte;
   private List mesSourcesTiers;
   private List mesSourcesTiersItems;

   public LectureSourcesTiers(long var1) {
      this.recupereSourcesTiers(var1);
   }

   public void recupereSourcesTiers(long var1) {
      this.mesSourcesTiers = new ArrayList();
      this.mesSourcesTiersItems = new ArrayList();

      try {
         SAXBuilder var3 = new SAXBuilder();
         File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "familles_tiers" + File.separator + "sourceTiers.xml");
         FileReader var5 = null;
         Document var6 = null;
         if (!var4.exists()) {
            this.enregistreSourceClient(var4, var1);
            var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "familles_tiers" + File.separator + "sourceTiers.xml");
            var5 = new FileReader(var4);
            var6 = var3.build(var5);
         } else {
            var5 = new FileReader(var4);
            var6 = var3.build(var5);
         }

         Element var7 = var6.getRootElement();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.compte = new ObjetCompte();
            Integer var10 = var9;
            String var11 = ((Element)var8.get(var9)).getChild("nom_FR").getText();
            String var12 = ((Element)var8.get(var9)).getChild("nom_UK").getText();
            String var13 = ((Element)var8.get(var9)).getChild("nom_SP").getText();
            long var14 = 0L;
            if (((Element)var8.get(var9)).getChildText("centreId") != null) {
               String var16 = ((Element)var8.get(var9)).getChild("centreId").getText();
               if (var16 != null && !var16.isEmpty()) {
                  var14 = Long.parseLong(var16);
               } else {
                  var14 = 0L;
               }
            }

            this.compte.setCode("");
            this.compte.setIndice(var10);
            this.compte.setNom_FR(var11);
            this.compte.setNom_UK(var12);
            this.compte.setNom_SP(var13);
            this.compte.setCentreId(var14);
            this.mesSourcesTiers.add(this.compte);
            this.mesSourcesTiersItems.add(new SelectItem(this.compte.getNom_FR()));
         }

         var5.close();
      } catch (JDOMException var17) {
      } catch (IOException var18) {
      }

   }

   public void enregistreSourceClient(File var1, long var2) throws FileNotFoundException, IOException {
      UtilDownload var4 = new UtilDownload();
      File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "sourceTiers.xml");
      var4.copy(var5, var1, true);
   }

   public List getMesSourcesTiers() {
      return this.mesSourcesTiers;
   }

   public void setMesSourcesTiers(List var1) {
      this.mesSourcesTiers = var1;
   }

   public List getMesSourcesTiersItems() {
      return this.mesSourcesTiersItems;
   }

   public void setMesSourcesTiersItems(List var1) {
      this.mesSourcesTiersItems = var1;
   }
}
