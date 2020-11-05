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

public class LectureTypeReglement implements Serializable {
   private ObjetCompte objetCompte;
   private List mesTypeReglement = new ArrayList();
   private List mesTypeReglementUtil = new ArrayList();
   private List mesTypeReglementItems;

   public LectureTypeReglement(String var1) {
      this.recupereTypeReglement(var1);
   }

   public void recupereTypeReglement(String var1) {
      this.mesTypeReglement = new ArrayList();
      this.mesTypeReglementUtil = new ArrayList();
      this.mesTypeReglementItems = new ArrayList();

      try {
         SAXBuilder var2 = new SAXBuilder();
         File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "commun" + File.separator + "configuration" + File.separator + "typeReglementsUtils.xml");
         if (!var3.exists()) {
            var3 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "typeReglements.xml");
         }

         FileReader var4 = new FileReader(var3);
         Document var5 = var2.build(var4);
         Element var6 = var5.getRootElement();
         List var7 = var6.getChildren();

         int var8;
         for(var8 = 0; var8 < var7.size(); ++var8) {
            this.objetCompte = new ObjetCompte();
            String var9 = ((Element)var7.get(var8)).getChild("etat").getText();
            String var10 = ((Element)var7.get(var8)).getChild("code").getText();
            String var11 = ((Element)var7.get(var8)).getChild("nom_FR").getText();
            this.objetCompte.setSens(var9);
            this.objetCompte.setCode(var10);
            this.objetCompte.setNom_FR(var11);
            if (var9.equalsIgnoreCase("1")) {
               this.objetCompte.setValide(true);
            } else {
               this.objetCompte.setValide(false);
            }

            this.mesTypeReglement.add(this.objetCompte);
            if (this.objetCompte.isValide()) {
               this.mesTypeReglementUtil.add(this.objetCompte);
               this.mesTypeReglementItems.add(new SelectItem(Integer.parseInt(this.objetCompte.getCode()), this.objetCompte.getCode() + ":" + this.objetCompte.getNom_FR()));
            }
         }

         if (this.mesTypeReglementUtil.size() == 0 && this.mesTypeReglement.size() != 0) {
            for(var8 = 0; var8 < this.mesTypeReglement.size(); ++var8) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte = (ObjetCompte)this.mesTypeReglement.get(var8);
               this.mesTypeReglementUtil.add(this.objetCompte);
               this.mesTypeReglementItems.add(new SelectItem(Integer.parseInt(this.objetCompte.getCode()), this.objetCompte.getCode() + ":" + this.objetCompte.getNom_FR()));
            }
         }

         var4.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

   }

   public List getMesTypeReglement() {
      return this.mesTypeReglement;
   }

   public void setMesTypeReglement(List var1) {
      this.mesTypeReglement = var1;
   }

   public List getMesTypeReglementItems() {
      return this.mesTypeReglementItems;
   }

   public void setMesTypeReglementItems(List var1) {
      this.mesTypeReglementItems = var1;
   }
}
