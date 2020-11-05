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

public class LectureNatureBiens implements Serializable {
   private ObjetCompte objetCompte;
   private List mesNatureBiens = new ArrayList();
   private List mesNatureBiensUtil = new ArrayList();
   private List mesNatureBiensItems;

   public LectureNatureBiens(String var1) {
      this.recupereNatureBiens(var1);
   }

   public void recupereNatureBiens(String var1) {
      try {
         SAXBuilder var2 = new SAXBuilder();
         File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "immobilier" + File.separator + "configuration" + File.separator + "naturesBiens.xml");
         if (!var3.exists()) {
            var3 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "NaturesFamillesBiens.xml");
         }

         FileReader var4 = new FileReader(var3);
         Document var5 = var2.build(var4);
         Element var6 = var5.getRootElement();
         this.mesNatureBiens = new ArrayList();
         this.mesNatureBiensItems = new ArrayList();
         this.mesNatureBiensUtil = new ArrayList();
         List var7 = var6.getChildren();

         int var8;
         for(var8 = 0; var8 < var7.size(); ++var8) {
            this.objetCompte = new ObjetCompte();
            String var9 = ((Element)var7.get(var8)).getChild("code").getText();
            String var10 = ((Element)var7.get(var8)).getChild("nom_FR").getText();
            String var11 = ((Element)var7.get(var8)).getChild("etatLocation").getText();
            String var12 = ((Element)var7.get(var8)).getChild("etatSyndic").getText();
            String var13 = ((Element)var7.get(var8)).getChild("etatNegoce").getText();
            String var14 = ((Element)var7.get(var8)).getChild("etatPromoteur").getText();
            this.objetCompte.setCode(var9);
            this.objetCompte.setNom_FR(var10);
            if (var11.equalsIgnoreCase("1")) {
               this.objetCompte.setValideLocation(true);
            } else {
               this.objetCompte.setValideLocation(false);
            }

            if (var12.equalsIgnoreCase("1")) {
               this.objetCompte.setValideSyndic(true);
            } else {
               this.objetCompte.setValideSyndic(false);
            }

            if (var13.equalsIgnoreCase("1")) {
               this.objetCompte.setValideNegoce(true);
            } else {
               this.objetCompte.setValideNegoce(false);
            }

            if (var14.equalsIgnoreCase("1")) {
               this.objetCompte.setValidePromoteur(true);
            } else {
               this.objetCompte.setValidePromoteur(false);
            }

            this.objetCompte.setSens("1");
            this.mesNatureBiens.add(this.objetCompte);
            if (this.objetCompte.isValide()) {
               this.mesNatureBiensUtil.add(this.objetCompte);
               this.mesNatureBiensItems.add(new SelectItem(this.objetCompte.getCode() + ":" + this.objetCompte.getNom_FR()));
            }
         }

         if (this.mesNatureBiensUtil.size() == 0 && this.mesNatureBiens.size() != 0) {
            for(var8 = 0; var8 < this.mesNatureBiens.size(); ++var8) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte = (ObjetCompte)this.mesNatureBiens.get(var8);
               this.mesNatureBiensUtil.add(this.objetCompte);
               this.mesNatureBiensItems.add(new SelectItem(this.objetCompte.getCode() + ":" + this.objetCompte.getNom_FR()));
            }
         }

         var4.close();
      } catch (JDOMException var15) {
      } catch (IOException var16) {
      }

   }

   public List getMesNatureBiens() {
      return this.mesNatureBiens;
   }

   public void setMesNatureBiens(List var1) {
      this.mesNatureBiens = var1;
   }

   public List getMesNatureBiensItems() {
      return this.mesNatureBiensItems;
   }

   public void setMesNatureBiensItems(List var1) {
      this.mesNatureBiensItems = var1;
   }

   public List getMesNatureBiensUtil() {
      return this.mesNatureBiensUtil;
   }

   public void setMesNatureBiensUtil(List var1) {
      this.mesNatureBiensUtil = var1;
   }

   public ObjetCompte getObjetCompte() {
      return this.objetCompte;
   }

   public void setObjetCompte(ObjetCompte var1) {
      this.objetCompte = var1;
   }
}
