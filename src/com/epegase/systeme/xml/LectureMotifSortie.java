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

public class LectureMotifSortie implements Serializable {
   private ObjetCompte objetCompte;
   private List mesMotifsortie = new ArrayList();
   private List mesMotifSortieItems;

   public LectureMotifSortie() {
      this.recupereMotifSortie();
   }

   public void recupereMotifSortie() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "medicalMotifSortie.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesMotifsortie = new ArrayList();
         this.mesMotifSortieItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetCompte = new ObjetCompte();
            String var8 = ((Element)var6.get(var7)).getChild("code").getText();
            String var9 = ((Element)var6.get(var7)).getChild("nom_FR").getText();
            String var10 = ((Element)var6.get(var7)).getChild("nom_UK").getText();
            String var11 = ((Element)var6.get(var7)).getChild("nom_SP").getText();
            this.objetCompte.setCode(var8);
            this.objetCompte.setNom_FR(var9);
            this.objetCompte.setNom_UK(var10);
            this.objetCompte.setNom_SP(var11);
            this.mesMotifsortie.add(this.objetCompte);
            this.mesMotifSortieItems.add(new SelectItem(this.objetCompte.getCode(), this.objetCompte.getCode() + ":" + this.objetCompte.getNom_FR()));
         }

         var3.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

   }

   public List getMesMotifSortieItems() {
      return this.mesMotifSortieItems;
   }

   public void setMesMotifSortieItems(List var1) {
      this.mesMotifSortieItems = var1;
   }

   public List getMesMotifsortie() {
      return this.mesMotifsortie;
   }

   public void setMesMotifsortie(List var1) {
      this.mesMotifsortie = var1;
   }
}
