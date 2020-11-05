package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class LectureConfigListeLigne implements Serializable {
   String configListeLigne;

   public LectureConfigListeLigne() throws IOException {
   }

   public void recupereFonctions(long var1, int var3, String var4) {
      this.configListeLigne = "";

      try {
         SAXBuilder var5 = new SAXBuilder();
         File var6 = new File(StaticModePegase.getCheminContext() + this.calculeFichierConfig(var1, var3, var4));
         if (var6.exists()) {
            FileReader var7 = new FileReader(var6);
            Document var8 = var5.build(var7);
            Element var9 = var8.getRootElement();
            List var10 = var9.getChildren();
            if (var10.size() != 0 && ((Element)var10.get(0)).getContent().size() != 0) {
               this.configListeLigne = ((Element)var10.get(0)).getContent(0).getValue().toString();
            }

            var7.close();
         }
      } catch (JDOMException var11) {
      } catch (IOException var12) {
      }

   }

   public String calculeFichierConfig(long var1, int var3, String var4) {
      String var5 = "";
      if (var3 == 0) {
         var5 = File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "familles_tiers" + File.separator + "nature_" + var3 + "_" + var4 + "_entete.xml";
      } else if ((var3 < 10 || var3 > 19) && (var3 < 30 || var3 > 39) && var3 != 500) {
         if (var3 >= 60 && var3 <= 69) {
            var5 = File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "caisses" + File.separator + "configuration" + File.separator + "nature_" + var3 + "_ligne.xml";
         } else if ((var3 < 50 || var3 > 59) && (var3 < 530 || var3 > 549)) {
            if (var3 >= 100 && var3 <= 109) {
               var5 = File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "education" + File.separator + "configuration" + File.separator + "nature_" + var3 + "_ligne.xml";
            } else if ((var3 < 2 || var3 > 5) && (var3 < 120 || var3 > 129)) {
               if ((var3 < 70 || var3 > 79) && var3 != 700 && var3 != 701) {
                  if (var3 >= 40 && var3 <= 49) {
                     var5 = File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "parc" + File.separator + "configuration" + File.separator + "nature_" + var3 + "_ligne.xml";
                  } else if (var3 >= 80 && var3 <= 99) {
                     var5 = File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "paye" + File.separator + "configuration" + File.separator + "nature_" + var3 + "_ligne.xml";
                  } else if ((var3 < 6 || var3 > 9) && (var3 < 20 || var3 > 29) && (var3 < 140 || var3 > 149) && var3 != 600) {
                     if (var3 >= 150 && var3 <= 179) {
                        var5 = File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "immobilier" + File.separator + "configuration" + File.separator + "nature_" + var3 + "_ligne.xml";
                     } else if (var3 >= 200 && var3 <= 209) {
                        var5 = File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "immobilier" + File.separator + "configuration" + File.separator + "nature_" + var3 + "_ligne.xml";
                     }
                  } else {
                     var5 = File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "ventes" + File.separator + "configuration" + File.separator + "nature_" + var3 + "_ligne.xml";
                  }
               } else {
                  var5 = File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "medical" + File.separator + "configuration" + File.separator + "nature_" + var3 + "_ligne.xml";
               }
            } else {
               var5 = File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "office" + File.separator + "configuration" + File.separator + "nature_" + var3 + "_ligne.xml";
            }
         } else {
            var5 = File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "compta" + File.separator + "configuration" + File.separator + "nature_" + var3 + "_ligne.xml";
         }
      } else {
         var5 = File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "achats" + File.separator + "configuration" + File.separator + "nature_" + var3 + "_ligne.xml";
      }

      return var5;
   }

   public String getConfigListeLigne() {
      return this.configListeLigne;
   }

   public void setConfigListeLigne(String var1) {
      this.configListeLigne = var1;
   }
}
