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

public class LectureManifest implements Serializable {
   private ObjetCompte objetCompte;
   private List mesNatureManifest = new ArrayList();
   private List mesNatureManifestUtil = new ArrayList();
   private List mesNatureManifestItems;

   public LectureManifest(String var1) {
      this.recupereNatureManifest(var1);
   }

   public void recupereNatureManifest(String var1) {
      try {
         SAXBuilder var2 = new SAXBuilder();
         File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "parc" + File.separator + "configuration" + File.separator + "naturesManifest.xml");
         if (!var3.exists()) {
            var3 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "NaturesManifest.xml");
         }

         FileReader var4 = new FileReader(var3);
         Document var5 = var2.build(var4);
         Element var6 = var5.getRootElement();
         this.mesNatureManifest = new ArrayList();
         this.mesNatureManifestItems = new ArrayList();
         this.mesNatureManifestUtil = new ArrayList();
         List var7 = var6.getChildren();

         int var8;
         for(var8 = 0; var8 < var7.size(); ++var8) {
            this.objetCompte = new ObjetCompte();
            String var9 = ((Element)var7.get(var8)).getChild("code").getText();
            String var10 = ((Element)var7.get(var8)).getChild("nom_FR").getText();
            String var11 = ((Element)var7.get(var8)).getChild("etat").getText();
            this.objetCompte.setCode(var9);
            this.objetCompte.setNom_FR(var10);
            if (var11.equalsIgnoreCase("1")) {
               this.objetCompte.setValide(true);
            } else {
               this.objetCompte.setValide(false);
            }

            this.mesNatureManifest.add(this.objetCompte);
            if (this.objetCompte.isValide()) {
               this.mesNatureManifestUtil.add(this.objetCompte);
               this.mesNatureManifestItems.add(new SelectItem(this.objetCompte.getCode(), this.objetCompte.getCode() + ":" + this.objetCompte.getNom_FR()));
            }
         }

         if (this.mesNatureManifestUtil.size() == 0 && this.mesNatureManifest.size() != 0) {
            for(var8 = 0; var8 < this.mesNatureManifest.size(); ++var8) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte = (ObjetCompte)this.mesNatureManifest.get(var8);
               this.mesNatureManifestUtil.add(this.objetCompte);
               this.mesNatureManifestItems.add(new SelectItem(this.objetCompte.getCode(), this.objetCompte.getCode() + ":" + this.objetCompte.getNom_FR()));
            }
         }

         var4.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

   }

   public ObjetCompte getObjetCompte() {
      return this.objetCompte;
   }

   public void setObjetCompte(ObjetCompte var1) {
      this.objetCompte = var1;
   }

   public List getMesNatureManifest() {
      return this.mesNatureManifest;
   }

   public void setMesNatureManifest(List var1) {
      this.mesNatureManifest = var1;
   }

   public List getMesNatureManifestItems() {
      return this.mesNatureManifestItems;
   }

   public void setMesNatureManifestItems(List var1) {
      this.mesNatureManifestItems = var1;
   }

   public List getMesNatureManifestUtil() {
      return this.mesNatureManifestUtil;
   }

   public void setMesNatureManifestUtil(List var1) {
      this.mesNatureManifestUtil = var1;
   }
}
