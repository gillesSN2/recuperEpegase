package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class LectureTarifTransit implements Serializable {
   private ObjetTarifTransit objetTarifTransit;
   private List mesTarifsTransits;

   public LectureTarifTransit(String var1, String var2) {
      this.LancerLecture(var1, var2);
   }

   public void LancerLecture(String var1, String var2) {
      try {
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "achats" + File.separator + "tarifTransit" + File.separator;
         File var4 = new File(var3);
         if (!var4.exists()) {
            var4.mkdir();
         }

         File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "achats" + File.separator + "tarifTransit" + File.separator + var2);
         if (var5.exists()) {
            SAXBuilder var6 = new SAXBuilder();
            FileReader var7 = new FileReader(var5);
            Document var8 = var6.build(var7);
            Element var9 = var8.getRootElement();
            this.mesTarifsTransits = new ArrayList();
            List var10 = var9.getChildren();

            for(int var11 = 0; var11 < var10.size(); ++var11) {
               this.objetTarifTransit = new ObjetTarifTransit();
               Integer var12 = var11;
               double var13 = Double.parseDouble(((Element)var10.get(var11)).getChild("Data0").getText());
               double var15 = Double.parseDouble(((Element)var10.get(var11)).getChild("Data1").getText());
               double var17 = Double.parseDouble(((Element)var10.get(var11)).getChild("Data2").getText());
               double var19 = Double.parseDouble(((Element)var10.get(var11)).getChild("Data3").getText());
               double var21 = Double.parseDouble(((Element)var10.get(var11)).getChild("Data4").getText());
               double var23 = Double.parseDouble(((Element)var10.get(var11)).getChild("Data5").getText());
               double var25 = Double.parseDouble(((Element)var10.get(var11)).getChild("Data6").getText());
               double var27 = Double.parseDouble(((Element)var10.get(var11)).getChild("Data7").getText());
               double var29 = Double.parseDouble(((Element)var10.get(var11)).getChild("Data8").getText());
               this.objetTarifTransit.setIndice(var12);
               this.objetTarifTransit.setKg(var13);
               this.objetTarifTransit.setZone1(var15);
               this.objetTarifTransit.setZone2(var17);
               this.objetTarifTransit.setZone3(var19);
               this.objetTarifTransit.setZone4(var21);
               this.objetTarifTransit.setZone5(var23);
               this.objetTarifTransit.setZone6(var25);
               this.objetTarifTransit.setZone7(var27);
               this.objetTarifTransit.setZone8(var29);
               this.mesTarifsTransits.add(this.objetTarifTransit);
            }

            var7.close();
         } else {
            this.mesTarifsTransits = new ArrayList();
         }
      } catch (JDOMException var31) {
      } catch (IOException var32) {
      }

   }

   public List getMesTarifsTransits() {
      return this.mesTarifsTransits;
   }

   public void setMesTarifsTransits(List var1) {
      this.mesTarifsTransits = var1;
   }
}
