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

public class LectureModeleFacture implements Serializable {
   private ObjetModeleFacture objetModeleFacture;
   private List lesModeles = new ArrayList();

   public LectureModeleFacture(long var1, String var3) {
      this.recupereModele(var1, var3);
   }

   public void recupereModele(long var1, String var3) {
      if (var3 == null || var3.isEmpty()) {
         var3 = "defaut";
      }

      try {
         SAXBuilder var4 = new SAXBuilder();
         File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "ventes" + File.separator + "configuration" + File.separator + "modeleFacture_" + var3 + ".xml");
         FileReader var6 = new FileReader(var5);
         Document var7 = var4.build(var6);
         Element var8 = var7.getRootElement();
         this.lesModeles = new ArrayList();
         List var9 = var8.getChildren();

         for(int var10 = 0; var10 < var9.size(); ++var10) {
            this.objetModeleFacture = new ObjetModeleFacture();
            Integer var11 = var10;
            String var12 = ((Element)var9.get(var10)).getChild("code").getText();
            String var13 = ((Element)var9.get(var10)).getChild("libelle").getText();
            String var14 = ((Element)var9.get(var10)).getChild("tva").getText();
            String var15 = ((Element)var9.get(var10)).getChild("qte").getText();
            String var16 = ((Element)var9.get(var10)).getChild("pu").getText();
            this.objetModeleFacture.setIndice(var11);
            this.objetModeleFacture.setCode(var12);
            this.objetModeleFacture.setLibelle(var13);
            this.objetModeleFacture.setTva(var14);
            this.objetModeleFacture.setQte(Float.parseFloat(var15));
            this.objetModeleFacture.setPu(Double.parseDouble(var16));
            this.lesModeles.add(this.objetModeleFacture);
         }

         var6.close();
      } catch (JDOMException var17) {
      } catch (IOException var18) {
      }

   }

   public List getLesModeles() {
      return this.lesModeles;
   }

   public void setLesModeles(List var1) {
      this.lesModeles = var1;
   }
}
