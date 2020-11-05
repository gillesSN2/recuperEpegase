package com.epegase.systeme.xml;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class LectureBanque implements Serializable {
   private long strId;
   private Structure structureLog;
   private ObjetBanque objetBanque;
   private List lesBanques = new ArrayList();
   private List mesBanquesItems = new ArrayList();

   public void recupereBanque() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         Document var2 = null;
         FileReader var3 = null;
         File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "banques.xml");
         if (!var4.exists()) {
            var4 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "banques.xml");
            var3 = new FileReader(var4);
            var2 = var1.build(var3);
            this.enregistreBanque(var2);
         } else {
            var3 = new FileReader(var4);
            var2 = var1.build(var3);
         }

         Element var5 = var2.getRootElement();
         this.lesBanques = new ArrayList();
         this.mesBanquesItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetBanque = new ObjetBanque();
            String var8 = ((Element)var6.get(var7)).getChild("code").getText();
            String var9 = ((Element)var6.get(var7)).getChild("libelle").getText();
            String var10 = ((Element)var6.get(var7)).getChild("swift").getText();
            String var11 = ((Element)var6.get(var7)).getChild("iban").getText();
            this.objetBanque.setCode(var8);
            this.objetBanque.setLibelle(var9);
            this.objetBanque.setSwift(var10);
            this.objetBanque.setIban(var11);
            this.lesBanques.add(this.objetBanque);
            this.mesBanquesItems.add(new SelectItem(this.objetBanque.getCode() + ":" + this.objetBanque.getLibelle()));
         }

         var3.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

   }

   public void enregistreBanque(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "banques.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public List getLesBanques() {
      return this.lesBanques;
   }

   public void setLesBanques(List var1) {
      this.lesBanques = var1;
   }

   public List getMesBanquesItems() {
      return this.mesBanquesItems;
   }

   public void setMesBanquesItems(List var1) {
      this.mesBanquesItems = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }
}
