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

public class LectureTypesSocietes implements Serializable {
   private ObjetCompte compte;
   private List mesTypesSocietes;
   private List mesTypesSocietesItems;

   public LectureTypesSocietes() {
      this.recuperesTypesSocietes();
   }

   public void recuperesTypesSocietes() {
      this.mesTypesSocietes = new ArrayList();
      this.mesTypesSocietesItems = new ArrayList();

      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "typesSocietes.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.compte = new ObjetCompte();
            Integer var8 = var7;
            String var9 = ((Element)var6.get(var7)).getChild("code").getText();
            String var10 = ((Element)var6.get(var7)).getChild("nom_FR").getText();
            String var11 = ((Element)var6.get(var7)).getChild("nom_UK").getText();
            String var12 = ((Element)var6.get(var7)).getChild("nom_SP").getText();
            String var13 = ((Element)var6.get(var7)).getChild("etat").getText();
            this.compte.setIndice(var8);
            this.compte.setCode(var9);
            this.compte.setNom_FR(var10);
            this.compte.setNom_UK(var11);
            this.compte.setNom_SP(var12);
            this.compte.setSens(var13);
            this.mesTypesSocietes.add(this.compte);
            this.mesTypesSocietesItems.add(new SelectItem(this.compte.getCode(), this.compte.getNom_FR()));
         }

         var3.close();
      } catch (JDOMException var14) {
      } catch (IOException var15) {
      }

   }

   public List getMesTypesSocietes() {
      return this.mesTypesSocietes;
   }

   public void setMesTypesSocietes(List var1) {
      this.mesTypesSocietes = var1;
   }

   public List getMesTypesSocietesItems() {
      return this.mesTypesSocietesItems;
   }

   public void setMesTypesSocietesItems(List var1) {
      this.mesTypesSocietesItems = var1;
   }
}
