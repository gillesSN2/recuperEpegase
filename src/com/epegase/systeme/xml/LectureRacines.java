package com.epegase.systeme.xml;

import com.epegase.systeme.classe.Structure;
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

public class LectureRacines implements Serializable {
   private Structure structureLog;
   private ObjetRacine racine;
   private List mesRacines;
   private List mesRacinesItems;
   private String selectFiscalite;

   public LectureRacines(String var1) {
      this.selectFiscalite = var1;
   }

   public void recupereRacines() {
      this.mesRacines = new ArrayList();
      this.mesRacinesItems = new ArrayList();

      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "fiscalites" + File.separator + this.selectFiscalite + File.separator + "RAC_" + this.selectFiscalite + ".xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.racine = new ObjetRacine();
            Integer var8 = var7;
            String var9 = ((Element)var6.get(var7)).getChild("code").getText();
            String var10 = ((Element)var6.get(var7)).getChild("lib_FR").getText();
            String var11 = ((Element)var6.get(var7)).getChild("lib_UK").getText();
            String var12 = ((Element)var6.get(var7)).getChild("lib_SP").getText();
            String var13 = ((Element)var6.get(var7)).getChild("nature").getText();
            String var14 = ((Element)var6.get(var7)).getChild("util").getText();
            this.racine.setCode(var9);
            this.racine.setNom_FR(var10);
            this.racine.setNom_UK(var11);
            this.racine.setNom_SP(var12);
            this.racine.setNature(var13);
            this.racine.setUtil(var14);
            this.mesRacines.add(this.racine);
            this.mesRacinesItems.add(new SelectItem(this.racine.getCode()));
         }

         var3.close();
      } catch (JDOMException var15) {
      } catch (IOException var16) {
      }

   }

   public void recupereRacinesOld() {
      this.mesRacines = new ArrayList();
      this.mesRacinesItems = new ArrayList();

      try {
         File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "fiscalites" + File.separator + this.selectFiscalite + File.separator + "RAC_" + this.selectFiscalite + ".xml");
         SAXBuilder var2 = new SAXBuilder();
         Document var3 = var2.build(var1);
         Element var4 = var3.getRootElement();
         List var5 = var4.getChildren();

         for(int var6 = 0; var6 < var5.size(); ++var6) {
            this.racine = new ObjetRacine();
            Integer var7 = var6;
            String var8 = ((Element)var5.get(var6)).getChild("code").getText();
            String var9 = ((Element)var5.get(var6)).getChild("lib_FR").getText();
            String var10 = ((Element)var5.get(var6)).getChild("lib_UK").getText();
            String var11 = ((Element)var5.get(var6)).getChild("lib_SP").getText();
            String var12 = ((Element)var5.get(var6)).getChild("nature").getText();
            String var13 = ((Element)var5.get(var6)).getChild("util").getText();
            this.racine.setCode(var8);
            this.racine.setNom_FR(var9);
            this.racine.setNom_UK(var10);
            this.racine.setNom_SP(var11);
            this.racine.setNature(var12);
            this.racine.setUtil(var13);
            this.mesRacines.add(this.racine);
            this.mesRacinesItems.add(new SelectItem(this.racine.getCode()));
         }
      } catch (JDOMException var14) {
      } catch (IOException var15) {
      }

   }

   public List getMesRacines() {
      return this.mesRacines;
   }

   public void setMesRacines(List var1) {
      this.mesRacines = var1;
   }

   public List getMesRacinesItems() {
      return this.mesRacinesItems;
   }

   public void setMesRacinesItems(List var1) {
      this.mesRacinesItems = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }
}
