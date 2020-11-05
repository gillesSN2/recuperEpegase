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

public class LectureNatureParc implements Serializable {
   private ObjetCompte objetCompte;
   private List mesNatureParc = new ArrayList();
   private List mesNatureParcOrigine = new ArrayList();
   private List mesNatureParcUtil = new ArrayList();
   private List mesNatureParcItems;

   public LectureNatureParc(String var1) {
      this.recupereNatureParc(var1);
   }

   public void recupereNatureParc(String var1) {
      try {
         SAXBuilder var2 = new SAXBuilder();
         File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "parc" + File.separator + "configuration" + File.separator + "naturesParc.xml");
         if (!var3.exists()) {
            var3 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "NaturesFamillesProduitsParc.xml");
         }

         FileReader var4 = new FileReader(var3);
         Document var5 = var2.build(var4);
         Element var6 = var5.getRootElement();
         this.mesNatureParc = new ArrayList();
         this.mesNatureParcItems = new ArrayList();
         this.mesNatureParcUtil = new ArrayList();
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

            if (var9.length() == 4) {
               this.objetCompte.setSens("1");
            } else {
               this.objetCompte.setSens("0");
            }

            this.mesNatureParc.add(this.objetCompte);
            if (this.objetCompte.isValide()) {
               this.mesNatureParcUtil.add(this.objetCompte);
               this.mesNatureParcItems.add(new SelectItem(this.objetCompte.getCode() + ":" + this.objetCompte.getNom_FR()));
            }
         }

         if (this.mesNatureParcUtil.size() == 0 && this.mesNatureParc.size() != 0) {
            for(var8 = 0; var8 < this.mesNatureParc.size(); ++var8) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte = (ObjetCompte)this.mesNatureParc.get(var8);
               this.mesNatureParcUtil.add(this.objetCompte);
               this.mesNatureParcItems.add(new SelectItem(this.objetCompte.getCode() + ":" + this.objetCompte.getNom_FR()));
            }
         }

         var4.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

   }

   public void recupereNatureParcOrigine() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "NaturesFamillesProduitsParc.xml");
         if (var2.exists()) {
            FileReader var3 = new FileReader(var2);
            Document var4 = var1.build(var3);
            Element var5 = var4.getRootElement();
            this.mesNatureParcOrigine = new ArrayList();
            List var6 = var5.getChildren();

            for(int var7 = 0; var7 < var6.size(); ++var7) {
               this.objetCompte = new ObjetCompte();
               String var8 = ((Element)var6.get(var7)).getChild("code").getText();
               String var9 = ((Element)var6.get(var7)).getChild("nom_FR").getText();
               String var10 = ((Element)var6.get(var7)).getChild("etat").getText();
               this.objetCompte.setCode(var8);
               this.objetCompte.setNom_FR(var9);
               if (var10.equalsIgnoreCase("1")) {
                  this.objetCompte.setValide(true);
               } else {
                  this.objetCompte.setValide(false);
               }

               if (var8.length() == 4) {
                  this.objetCompte.setSens("1");
               } else {
                  this.objetCompte.setSens("0");
               }

               this.mesNatureParcOrigine.add(this.objetCompte);
            }

            var3.close();
         }
      } catch (JDOMException var11) {
      } catch (IOException var12) {
      }

   }

   public List getMesNatureParc() {
      return this.mesNatureParc;
   }

   public void setMesNatureParc(List var1) {
      this.mesNatureParc = var1;
   }

   public List getMesNatureParcItems() {
      return this.mesNatureParcItems;
   }

   public void setMesNatureParcItems(List var1) {
      this.mesNatureParcItems = var1;
   }

   public ObjetCompte getObjetCompte() {
      return this.objetCompte;
   }

   public void setObjetCompte(ObjetCompte var1) {
      this.objetCompte = var1;
   }

   public List getMesNatureParcUtil() {
      return this.mesNatureParcUtil;
   }

   public void setMesNatureParcUtil(List var1) {
      this.mesNatureParcUtil = var1;
   }

   public List getMesNatureParcOrigine() {
      return this.mesNatureParcOrigine;
   }

   public void setMesNatureParcOrigine(List var1) {
      this.mesNatureParcOrigine = var1;
   }
}
