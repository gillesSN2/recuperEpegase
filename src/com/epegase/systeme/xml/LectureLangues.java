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

public class LectureLangues implements Serializable {
   private ObjetLangue langues;
   private List meslangues = new ArrayList();
   private List mesLanguesItems;

   public LectureLangues() {
      this.recupereLangues();
   }

   public void recupereLangues() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "langue.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.meslangues = new ArrayList();
         this.mesLanguesItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.langues = new ObjetLangue();
            Integer var8 = var7;
            String var9 = ((Element)var6.get(var7)).getChild("libelle").getText();
            String var10 = ((Element)var6.get(var7)).getChild("code").getText();
            this.langues.setIndice(var8);
            this.langues.setLibelle(var9);
            this.langues.setCode(var10);
            this.meslangues.add(this.langues);
            this.mesLanguesItems.add(new SelectItem(this.langues.getLibelle()));
         }

         var3.close();
      } catch (JDOMException var11) {
      } catch (IOException var12) {
      }

   }

   public List getMeslangues() {
      return this.meslangues;
   }

   public void setMeslangues(List var1) {
      this.meslangues = var1;
   }

   public List getMesLanguesItems() {
      return this.mesLanguesItems;
   }

   public void setMesLanguesItems(List var1) {
      this.mesLanguesItems = var1;
   }
}
