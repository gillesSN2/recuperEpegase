package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class LireLesoptionsStocks implements Serializable {
   private long strId;
   private OptionStocks optionStocks;

   public OptionStocks lancer() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "achats" + File.separator + "configuration" + File.separator + "optionStocks.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.optionStocks = new OptionStocks();
         if (var5.getChildText("affichInGlobViewINV") != null && !var5.getChildText("affichInGlobViewINV").isEmpty()) {
            this.optionStocks.setAffichInGlobViewINV(var5.getChildText("affichInGlobViewINV"));
         } else {
            this.optionStocks.setAffichInGlobViewINV("100");
         }

         if (var5.getChildText("affichInGlobViewBIN") != null && !var5.getChildText("affichInGlobViewBIN").isEmpty()) {
            this.optionStocks.setAffichInGlobViewBIN(var5.getChildText("affichInGlobViewBIN"));
         } else {
            this.optionStocks.setAffichInGlobViewBIN("100");
         }

         if (var5.getChildText("affichInGlobViewBOUT") == null) {
            this.optionStocks.setAffichInGlobViewBOUT("100");
         } else {
            this.optionStocks.setAffichInGlobViewBOUT(var5.getChildText("affichInGlobViewBOUT"));
         }

         if (var5.getChildText("affichInGlobViewCES") != null && !var5.getChildText("affichInGlobViewCES").isEmpty()) {
            this.optionStocks.setAffichInGlobViewCES(var5.getChildText("affichInGlobViewCES"));
         } else {
            this.optionStocks.setAffichInGlobViewCES("100");
         }

         if (var5.getChildText("affichInGlobViewPRD") != null && !var5.getChildText("affichInGlobViewPRD").isEmpty()) {
            this.optionStocks.setAffichInGlobViewPRD(var5.getChildText("affichInGlobViewPRD"));
         } else {
            this.optionStocks.setAffichInGlobViewPRD("100");
         }

         if (var5.getChildText("affichInGlobViewREX") != null && !var5.getChildText("affichInGlobViewREX").isEmpty()) {
            this.optionStocks.setAffichInGlobViewREX(var5.getChildText("affichInGlobViewREX"));
         } else {
            this.optionStocks.setAffichInGlobViewREX("100");
         }

         this.optionStocks.setLib1(var5.getChildText("lib1"));
         this.optionStocks.setLib2(var5.getChildText("lib2"));
         this.optionStocks.setLib3(var5.getChildText("lib3"));
         this.optionStocks.setLib4(var5.getChildText("lib4"));
         this.optionStocks.setLib5(var5.getChildText("lib5"));
         this.optionStocks.setLib6(var5.getChildText("lib6"));
         this.optionStocks.setLib7(var5.getChildText("lib7"));
         this.optionStocks.setLib8(var5.getChildText("lib8"));
         this.optionStocks.setLib9(var5.getChildText("lib9"));
         this.optionStocks.setLib10(var5.getChildText("lib10"));
         if (var5.getChildText("nbLigneMax") != null && !var5.getChildText("nbLigneMax").isEmpty()) {
            this.optionStocks.setNbLigneMax(var5.getChildText("nbLigneMax"));
         } else {
            this.optionStocks.setNbLigneMax("100");
         }

         if (var5.getChildText("stockNegatif") != null && !var5.getChildText("stockNegatif").isEmpty()) {
            this.optionStocks.setStockNegatif(var5.getChildText("stockNegatif"));
         } else {
            this.optionStocks.setStockNegatif("0");
         }

         if (var5.getChildText("demandeurRapporteur") != null && !var5.getChildText("demandeurRapporteur").isEmpty()) {
            this.optionStocks.setDemandeurRapporteur(var5.getChildText("demandeurRapporteur"));
         } else {
            this.optionStocks.setDemandeurRapporteur("0");
         }

         if (var5.getChildText("choixStock") != null && !var5.getChildText("choixStock").isEmpty()) {
            this.optionStocks.setChoixStock(var5.getChildText("choixStock"));
         } else {
            this.optionStocks.setChoixStock("0");
         }

         if (var5.getChildText("nbDecQteProd") != null && !var5.getChildText("nbDecQteProd").isEmpty()) {
            this.optionStocks.setNbDecQteProd(var5.getChildText("nbDecQteProd"));
         } else {
            this.optionStocks.setNbDecQteProd("0");
         }

         var3.close();
      } catch (JDOMException var6) {
      } catch (IOException var7) {
      }

      return this.optionStocks;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }
}
