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

public class LectureNatureCompte implements Serializable {
   private ObjetCompte objetCompte;
   private List mesNatureCompte = new ArrayList();
   private List mesNatureCompteItems;

   public LectureNatureCompte() throws IOException {
      this.recupereNatureCompte();
   }

   public void recupereNatureCompte() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "fiscalites" + File.separator + "naturesFiscales.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesNatureCompte = new ArrayList();
         this.mesNatureCompteItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetCompte = new ObjetCompte();
            String var8 = ((Element)var6.get(var7)).getChild("code").getText();
            String var9 = ((Element)var6.get(var7)).getChild("nom_FR").getText();
            String var10 = ((Element)var6.get(var7)).getChild("nom_UK").getText();
            String var11 = ((Element)var6.get(var7)).getChild("nom_SP").getText();
            String var12 = ((Element)var6.get(var7)).getChild("sens").getText();
            this.objetCompte.setCode(var8);
            this.objetCompte.setNom_FR(var9);
            this.objetCompte.setNom_UK(var10);
            this.objetCompte.setNom_SP(var11);
            this.objetCompte.setSens(var12);
            this.mesNatureCompte.add(this.objetCompte);
            this.mesNatureCompteItems.add(new SelectItem(this.objetCompte.getCode() + ":" + this.objetCompte.getNom_FR()));
         }

         var3.close();
      } catch (JDOMException var13) {
      } catch (IOException var14) {
      }

   }

   public List getMesNatureCompte() {
      return this.mesNatureCompte;
   }

   public void setMesNatureCompte(List var1) {
      this.mesNatureCompte = var1;
   }

   public List getMesNatureCompteItems() {
      return this.mesNatureCompteItems;
   }

   public void setMesNatureCompteItems(List var1) {
      this.mesNatureCompteItems = var1;
   }
}
