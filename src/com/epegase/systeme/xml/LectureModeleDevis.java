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

public class LectureModeleDevis implements Serializable {
   private ObjetModeleFacture objetModeleFacture;
   private List lesModeles = new ArrayList();

   public LectureModeleDevis(long var1) {
      this.recupereModele(var1);
   }

   public void recupereModele(long var1) {
      try {
         SAXBuilder var3 = new SAXBuilder();
         File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "ventes" + File.separator + "configuration" + File.separator + "modeleDevis.xml");
         FileReader var5 = new FileReader(var4);
         Document var6 = var3.build(var5);
         Element var7 = var6.getRootElement();
         this.lesModeles = new ArrayList();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.objetModeleFacture = new ObjetModeleFacture();
            Integer var10 = var9;
            String var11 = ((Element)var8.get(var9)).getChild("code").getText();
            String var12 = ((Element)var8.get(var9)).getChild("famille").getText();
            String var13 = ((Element)var8.get(var9)).getChild("libelle").getText();
            String var14 = ((Element)var8.get(var9)).getChild("tva").getText();
            String var15 = ((Element)var8.get(var9)).getChild("qte").getText();
            String var16 = ((Element)var8.get(var9)).getChild("pu").getText();
            String var17 = ((Element)var8.get(var9)).getChild("abn").getText();
            String var18 = ((Element)var8.get(var9)).getChild("mode").getText();
            String var19 = ((Element)var8.get(var9)).getChild("module").getText();
            this.objetModeleFacture.setIndice(var10);
            this.objetModeleFacture.setCode(var11);
            this.objetModeleFacture.setFamille(var12);
            this.objetModeleFacture.setLibelle(var13);
            this.objetModeleFacture.setTva(var14);
            if (var15 != null && !var15.isEmpty()) {
               this.objetModeleFacture.setQte(Float.parseFloat(var15));
            } else {
               this.objetModeleFacture.setQte(0.0F);
            }

            if (var16 != null && !var16.isEmpty()) {
               this.objetModeleFacture.setPu(Double.parseDouble(var16));
            } else {
               this.objetModeleFacture.setPu(0.0D);
            }

            if (var17 != null && !var17.isEmpty()) {
               this.objetModeleFacture.setAbn(Double.parseDouble(var17));
            } else {
               this.objetModeleFacture.setAbn(0.0D);
            }

            if (var18 != null && !var18.isEmpty()) {
               this.objetModeleFacture.setMode(Integer.parseInt(var18));
            } else {
               this.objetModeleFacture.setMode(0);
            }

            this.objetModeleFacture.setModule(var19);
            this.objetModeleFacture.setSelect(false);
            this.lesModeles.add(this.objetModeleFacture);
         }

         var5.close();
      } catch (JDOMException var20) {
      } catch (IOException var21) {
      }

   }

   public List getLesModeles() {
      return this.lesModeles;
   }

   public void setLesModeles(List var1) {
      this.lesModeles = var1;
   }
}
