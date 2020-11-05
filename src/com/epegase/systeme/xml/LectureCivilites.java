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

public class LectureCivilites implements Serializable {
   private ObjetCompte compte;
   private List mesCivilites;
   private List mesCivilitesItems;

   public LectureCivilites(int var1) throws IOException {
      if (var1 == 1) {
         this.recupereCivilitesMedicale();
      } else {
         this.recupereCivilitesEntreprise();
      }

   }

   public void recupereCivilitesEntreprise() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "civilite.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesCivilites = new ArrayList();
         this.mesCivilitesItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.compte = new ObjetCompte();
            Integer var8 = var7;
            String var9 = ((Element)var6.get(var7)).getChild("code").getText();
            String var10 = ((Element)var6.get(var7)).getChild("nom_FR").getText();
            String var11 = ((Element)var6.get(var7)).getChild("nom_UK").getText();
            String var12 = ((Element)var6.get(var7)).getChild("nom_SP").getText();
            String var13 = ((Element)var6.get(var7)).getChild("sexe").getText();
            String var14 = ((Element)var6.get(var7)).getChild("type").getText();
            this.compte.setCode(var9);
            this.compte.setIndice(var8);
            this.compte.setNom_FR(var10);
            this.compte.setNom_UK(var11);
            this.compte.setNom_SP(var12);
            this.compte.setSens(var13);
            this.compte.setType(var14);
            if (this.compte.getType() != null && !this.compte.getType().equals("2")) {
               this.mesCivilites.add(this.compte);
               this.mesCivilitesItems.add(new SelectItem(this.compte.getNom_FR()));
            }
         }

         if (this.mesCivilitesItems == null || this.mesCivilitesItems.size() == 0) {
            this.mesCivilitesItems.add(new SelectItem(""));
         }

         var3.close();
      } catch (JDOMException var15) {
      } catch (IOException var16) {
      }

   }

   public void recupereCivilitesMedicale() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "civilite.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesCivilites = new ArrayList();
         this.mesCivilitesItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.compte = new ObjetCompte();
            Integer var8 = var7;
            String var9 = ((Element)var6.get(var7)).getChild("code").getText();
            String var10 = ((Element)var6.get(var7)).getChild("nom_FR").getText();
            String var11 = ((Element)var6.get(var7)).getChild("nom_UK").getText();
            String var12 = ((Element)var6.get(var7)).getChild("nom_SP").getText();
            String var13 = ((Element)var6.get(var7)).getChild("sexe").getText();
            this.compte.setCode(var9);
            this.compte.setIndice(var8);
            this.compte.setNom_FR(var10);
            this.compte.setNom_UK(var11);
            this.compte.setNom_SP(var12);
            this.compte.setSens(var13);
            this.mesCivilites.add(this.compte);
            this.mesCivilitesItems.add(new SelectItem(this.compte.getNom_FR()));
         }

         var3.close();
      } catch (JDOMException var14) {
      } catch (IOException var15) {
      }

   }

   public List getMesCivilites() {
      return this.mesCivilites;
   }

   public void setMesCivilites(List var1) {
      this.mesCivilites = var1;
   }

   public List getMesCivilitesItems() {
      return this.mesCivilitesItems;
   }

   public void setMesCivilitesItems(List var1) {
      this.mesCivilitesItems = var1;
   }
}
