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

public class LectureDevises implements Serializable {
   private ObjetDevises devises;
   private List mesDevises;
   private List mesDevisesItems;

   public LectureDevises() {
      this.recupererDevises();
   }

   public void recupererDevises() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "devises" + File.separator + "devises.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesDevises = new ArrayList();
         this.mesDevisesItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.devises = new ObjetDevises();
            Integer var8 = var7;
            String var9 = ((Element)var6.get(var7)).getChild("code").getText();
            String var10 = ((Element)var6.get(var7)).getChild("libelle1").getText();
            String var11 = ((Element)var6.get(var7)).getChild("date").getText();
            String var12 = ((Element)var6.get(var7)).getChild("taux1").getText();
            String var13 = ((Element)var6.get(var7)).getChild("taux2").getText();
            String var14 = ((Element)var6.get(var7)).getChild("format").getText();
            String var15 = ((Element)var6.get(var7)).getChild("principal").getText();
            String var16 = ((Element)var6.get(var7)).getChild("secondaire").getText();
            this.devises.setCode(var9);
            this.devises.setTaux1(var12);
            this.devises.setTaux2(var13);
            this.devises.setDate(var11);
            this.devises.setLibelle(var10);
            this.devises.setFormat(var14);
            this.devises.setPrincipal(var15);
            this.devises.setSecondaire(var16);
            this.mesDevises.add(this.devises);
            this.mesDevisesItems.add(new SelectItem(this.devises.getCode()));
         }

         var3.close();
      } catch (JDOMException var17) {
      } catch (IOException var18) {
      }

   }

   public ObjetDevises devisesRecherchee(String var1, String var2) {
      if (var1.equals("XEU")) {
         var1 = "EUR";
      }

      ObjetDevises var3 = new ObjetDevises();
      int var4;
      if (this.mesDevises.size() != 0) {
         for(var4 = 0; var4 < this.mesDevises.size(); ++var4) {
            if (var1.contentEquals(((ObjetDevises)this.mesDevises.get(var4)).getCode())) {
               var3 = (ObjetDevises)this.mesDevises.get(var4);
            }
         }
      }

      if ((var3 == null || var3.getCode() == null || var3.getCode().isEmpty()) && this.mesDevises.size() != 0) {
         for(var4 = 0; var4 < this.mesDevises.size(); ++var4) {
            if (var2.contentEquals(((ObjetDevises)this.mesDevises.get(var4)).getCode())) {
               var3 = (ObjetDevises)this.mesDevises.get(var4);
            }
         }
      }

      return var3;
   }

   public List getMesDevises() {
      return this.mesDevises;
   }

   public void setMesDevises(List var1) {
      this.mesDevises = var1;
   }

   public List getMesDevisesItems() {
      return this.mesDevisesItems;
   }

   public void setMesDevisesItems(List var1) {
      this.mesDevisesItems = var1;
   }
}
