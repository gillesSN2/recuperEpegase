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

public class LectureImmatriculation implements Serializable {
   private List mesImmatriculation;
   private ObjetImmatriculation immatriculation;

   public LectureImmatriculation(String var1, String var2) throws IOException {
      this.recupereImmatriculation(var1, var2);
   }

   public void recupereImmatriculation(String var1, String var2) {
      try {
         SAXBuilder var3 = new SAXBuilder();
         File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "immatriculations" + File.separator + "immat_" + var1 + ".xml");
         FileReader var5 = new FileReader(var4);
         Document var6 = var3.build(var5);
         Element var7 = var6.getRootElement();
         this.mesImmatriculation = new ArrayList();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            if (((Element)var8.get(var9)).getName().equalsIgnoreCase(var2)) {
               this.immatriculation = new ObjetImmatriculation();
               String var10 = ((Element)var8.get(var9)).getChild("impm01").getText();
               String var11 = ((Element)var8.get(var9)).getChild("impm02").getText();
               String var12 = ((Element)var8.get(var9)).getChild("impm03").getText();
               String var13 = ((Element)var8.get(var9)).getChild("impm04").getText();
               String var14 = ((Element)var8.get(var9)).getChild("impm05").getText();
               String var15 = ((Element)var8.get(var9)).getChild("impm06").getText();
               String var16 = ((Element)var8.get(var9)).getChild("impm07").getText();
               String var17 = ((Element)var8.get(var9)).getChild("impm08").getText();
               String var18 = ((Element)var8.get(var9)).getChild("impm09").getText();
               String var19 = ((Element)var8.get(var9)).getChild("impm10").getText();
               String var20 = ((Element)var8.get(var9)).getChild("impm11").getText();
               String var21 = ((Element)var8.get(var9)).getChild("impm12").getText();
               String var22 = ((Element)var8.get(var9)).getChild("impm13").getText();
               String var23 = ((Element)var8.get(var9)).getChild("impm14").getText();
               String var24 = ((Element)var8.get(var9)).getChild("impm15").getText();
               String var25 = ((Element)var8.get(var9)).getChild("impm16").getText();
               String var26 = ((Element)var8.get(var9)).getChild("impm17").getText();
               String var27 = ((Element)var8.get(var9)).getChild("impm18").getText();
               String var28 = ((Element)var8.get(var9)).getChild("impm19").getText();
               String var29 = ((Element)var8.get(var9)).getChild("impm20").getText();
               this.immatriculation.setImpm01(var10);
               this.immatriculation.setImpm02(var11);
               this.immatriculation.setImpm03(var12);
               this.immatriculation.setImpm04(var13);
               this.immatriculation.setImpm05(var14);
               this.immatriculation.setImpm06(var15);
               this.immatriculation.setImpm07(var16);
               this.immatriculation.setImpm08(var17);
               this.immatriculation.setImpm09(var18);
               this.immatriculation.setImpm10(var19);
               this.immatriculation.setImpm11(var20);
               this.immatriculation.setImpm12(var21);
               this.immatriculation.setImpm13(var22);
               this.immatriculation.setImpm14(var23);
               this.immatriculation.setImpm15(var24);
               this.immatriculation.setImpm16(var25);
               this.immatriculation.setImpm17(var26);
               this.immatriculation.setImpm18(var27);
               this.immatriculation.setImpm19(var28);
               this.immatriculation.setImpm20(var29);
               this.mesImmatriculation.add(this.immatriculation);
            }
         }

         var5.close();
      } catch (JDOMException var30) {
      } catch (IOException var31) {
      }

   }

   public List getMesImmatriculation() {
      return this.mesImmatriculation;
   }

   public void setMesImmatriculation(List var1) {
      this.mesImmatriculation = var1;
   }

   public ObjetImmatriculation getImmatriculation() {
      return this.immatriculation;
   }

   public void setImmatriculation(ObjetImmatriculation var1) {
      this.immatriculation = var1;
   }
}
