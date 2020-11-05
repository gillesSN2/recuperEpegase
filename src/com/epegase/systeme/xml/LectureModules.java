package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class LectureModules implements Serializable {
   private List mesModules = new ArrayList();
   private Document document;
   private Element racine;

   public LectureModules() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "modules.xml");
         FileReader var3 = new FileReader(var2);
         this.document = var1.build(var3);
         this.racine = this.document.getRootElement();
         this.recupereModules();
         var3.close();
      } catch (JDOMException var4) {
      } catch (IOException var5) {
      }

   }

   public void recupereModules() {
      List var1 = this.racine.getChildren("niveau1");

      ObjetModuleNiveauFirst var4;
      for(Iterator var2 = var1.iterator(); var2.hasNext(); this.mesModules.add(var4)) {
         Element var3 = (Element)var2.next();
         var4 = new ObjetModuleNiveauFirst();
         var4.setLibelle1_FR(var3.getChild("libelle1_FR").getText());
         var4.setLibelle1_UK(var3.getChild("libelle1_UK").getText());
         var4.setLibelle1_SP(var3.getChild("libelle1_SP").getText());
         var4.setMenu1_FR(var3.getChild("menu1_FR").getText());
         var4.setMenu1_UK(var3.getChild("menu1_UK").getText());
         var4.setMenu1_SP(var3.getChild("menu1_SP").getText());
         var4.setInfo1_FR(var3.getChild("info1_FR").getText());
         var4.setInfo1_UK(var3.getChild("info1_UK").getText());
         var4.setInfo1_SP(var3.getChild("info1_SP").getText());
         var4.setCode1(var3.getChild("code1").getText());
         var4.setType1(var3.getChild("type1").getText());
         var4.setValeur1(var3.getChild("valeur1").getText());
         var4.setModif1(var3.getChild("modif1").getText());
         var4.setDesactif1(var3.getChild("desactif1").getText());
         if (var3.getChildren("niveau2").toString() != null) {
            List var5 = var3.getChildren("niveau2");
            Iterator var6 = var5.iterator();

            while(var6.hasNext()) {
               Element var7 = (Element)var6.next();
               ObjetModuleNiveauSecond var8 = new ObjetModuleNiveauSecond();
               var8.setLibelle2_FR(var7.getChild("libelle2_FR").getText());
               var8.setLibelle2_UK(var7.getChild("libelle2_UK").getText());
               var8.setLibelle2_SP(var7.getChild("libelle2_SP").getText());
               var8.setMenu2_FR(var7.getChild("menu2_FR").getText());
               var8.setMenu2_UK(var7.getChild("menu2_UK").getText());
               var8.setMenu2_SP(var7.getChild("menu2_SP").getText());
               var8.setInfo2_FR(var7.getChild("info2_FR").getText());
               var8.setInfo2_UK(var7.getChild("info2_UK").getText());
               var8.setInfo2_SP(var7.getChild("info2_SP").getText());
               var8.setCode2(var7.getChild("code2").getText());
               var8.setType2(var7.getChild("type2").getText());
               var8.setValeur2(var7.getChild("valeur2").getText());
               var8.setModif2(var7.getChild("modif2").getText());
               var8.setDesactif2(var7.getChild("desactif2").getText());
               var4.getNiveauSecond().add(var8);
            }
         }
      }

      for(Iterator var9 = this.mesModules.iterator(); var9.hasNext(); var4 = (ObjetModuleNiveauFirst)var9.next()) {
      }

   }

   public List getMesModules() {
      return this.mesModules;
   }

   public void setMesModules(List var1) {
      this.mesModules = var1;
   }

   public Element getRacine() {
      return this.racine;
   }

   public void setRacine(Element var1) {
      this.racine = var1;
   }

   public String getLibelleModule(String var1) {
      System.out.println("champs +++" + var1);
      Iterator var2 = this.mesModules.iterator();
      String var3 = "";

      while(var2.hasNext()) {
         ObjetModuleNiveauFirst var4 = (ObjetModuleNiveauFirst)var2.next();
         if (var4.getCode1().equals(var1)) {
            var3 = var4.getLibelle1_FR();
            break;
         }

         Iterator var5 = var4.getNiveauSecond().iterator();

         while(var5.hasNext()) {
            ObjetModuleNiveauSecond var6 = (ObjetModuleNiveauSecond)var5.next();
            if (var6.getCode2().equals(var1)) {
               var3 = var6.getLibelle2_FR();
               break;
            }
         }
      }

      return var3;
   }
}
