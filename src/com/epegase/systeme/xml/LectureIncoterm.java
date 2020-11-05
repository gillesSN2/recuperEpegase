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

public class LectureIncoterm implements Serializable {
   private ObjetIncoterm objetIncoterm;
   private List mesIncoterm = new ArrayList();
   private List mesIncotermItems;
   private List mesIncotermActifsItems;

   public LectureIncoterm() {
      this.recupereIncoterm();
   }

   public void recupereIncoterm() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commercial" + File.separator + "Incoterms.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesIncoterm = new ArrayList();
         this.mesIncotermItems = new ArrayList();
         this.mesIncotermActifsItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetIncoterm = new ObjetIncoterm();
            String var8 = ((Element)var6.get(var7)).getChild("groupe").getText();
            String var9 = ((Element)var6.get(var7)).getChild("code").getText();
            String var10 = ((Element)var6.get(var7)).getChild("libelle").getText();
            String var11 = ((Element)var6.get(var7)).getChild("nom").getText();
            String var12 = ((Element)var6.get(var7)).getChild("etat").getText();
            this.objetIncoterm.setGroupe(var8);
            this.objetIncoterm.setCode(var9);
            this.objetIncoterm.setLibelle(var10);
            this.objetIncoterm.setNom(var11);
            this.objetIncoterm.setEtat(var12);
            this.mesIncoterm.add(this.objetIncoterm);
            this.mesIncotermItems.add(new SelectItem(this.objetIncoterm.getCode()));
            if (this.objetIncoterm.getEtat().equals("0")) {
               this.mesIncotermActifsItems.add(new SelectItem(this.objetIncoterm.getCode()));
            }
         }

         var3.close();
      } catch (JDOMException var13) {
      } catch (IOException var14) {
      }

   }

   public List getMesIncoterm() {
      return this.mesIncoterm;
   }

   public void setMesIncoterm(List var1) {
      this.mesIncoterm = var1;
   }

   public List getMesIncotermItems() {
      return this.mesIncotermItems;
   }

   public void setMesIncotermItems(List var1) {
      this.mesIncotermItems = var1;
   }

   public List getMesIncotermActifsItems() {
      return this.mesIncotermActifsItems;
   }

   public void setMesIncotermActifsItems(List var1) {
      this.mesIncotermActifsItems = var1;
   }
}
