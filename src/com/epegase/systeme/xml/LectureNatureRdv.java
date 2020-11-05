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

public class LectureNatureRdv implements Serializable {
   private ObjetCompte objetCompte;
   private List mesNatureRdv = new ArrayList();
   private List mesNatureRdvOrigine = new ArrayList();
   private List mesNatureRdvUtil = new ArrayList();
   private List mesNatureRdvItems;

   public LectureNatureRdv(String var1) {
      this.recupereNatureRdv(var1);
   }

   public void recupereNatureRdv(String var1) {
      try {
         SAXBuilder var2 = new SAXBuilder();
         File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "office" + File.separator + "configuration" + File.separator + "naturesRdv.xml");
         if (!var3.exists()) {
            var3 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "NaturesRdv.xml");
         }

         FileReader var4 = new FileReader(var3);
         Document var5 = var2.build(var4);
         Element var6 = var5.getRootElement();
         this.mesNatureRdv = new ArrayList();
         this.mesNatureRdvItems = new ArrayList();
         this.mesNatureRdvUtil = new ArrayList();
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

            this.mesNatureRdv.add(this.objetCompte);
            if (this.objetCompte.isValide()) {
               this.mesNatureRdvUtil.add(this.objetCompte);
               this.mesNatureRdvItems.add(new SelectItem(this.objetCompte.getCode() + ":" + this.objetCompte.getNom_FR()));
            }
         }

         if (this.mesNatureRdvUtil.size() == 0 && this.mesNatureRdv.size() != 0) {
            for(var8 = 0; var8 < this.mesNatureRdv.size(); ++var8) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte = (ObjetCompte)this.mesNatureRdv.get(var8);
               this.mesNatureRdvUtil.add(this.objetCompte);
               this.mesNatureRdvItems.add(new SelectItem(this.objetCompte.getCode() + ":" + this.objetCompte.getNom_FR()));
            }
         }

         var4.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

   }

   public void recupereNatureRdvOrigine() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "NaturesRdv.xml");
         if (var2.exists()) {
            FileReader var3 = new FileReader(var2);
            Document var4 = var1.build(var3);
            Element var5 = var4.getRootElement();
            this.mesNatureRdvOrigine = new ArrayList();
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

               this.mesNatureRdvOrigine.add(this.objetCompte);
            }

            var3.close();
         }
      } catch (JDOMException var11) {
      } catch (IOException var12) {
      }

   }

   public List getMesNatureRdv() {
      return this.mesNatureRdv;
   }

   public void setMesNatureRdv(List var1) {
      this.mesNatureRdv = var1;
   }

   public List getMesNatureRdvItems() {
      return this.mesNatureRdvItems;
   }

   public void setMesNatureRdvItems(List var1) {
      this.mesNatureRdvItems = var1;
   }

   public List getMesNatureRdvOrigine() {
      return this.mesNatureRdvOrigine;
   }

   public void setMesNatureRdvOrigine(List var1) {
      this.mesNatureRdvOrigine = var1;
   }

   public List getMesNatureRdvUtil() {
      return this.mesNatureRdvUtil;
   }

   public void setMesNatureRdvUtil(List var1) {
      this.mesNatureRdvUtil = var1;
   }

   public ObjetCompte getObjetCompte() {
      return this.objetCompte;
   }

   public void setObjetCompte(ObjetCompte var1) {
      this.objetCompte = var1;
   }
}
