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

public class LectureCentresImpots implements Serializable {
   private Structure structureLog;
   private ObjetCompte objetPaye;
   private List mesCentresImpots;
   private List mesCentresImpotsItems;

   public void recuperePaye() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "cent_" + this.structureLog.getStrcodepays() + ".xml");
         if (!var2.exists()) {
            var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "centresImpots" + File.separator + "cent_" + this.structureLog.getStrcodepays() + ".xml");
         }

         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesCentresImpots = new ArrayList();
         this.mesCentresImpotsItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetPaye = new ObjetCompte();
            String var8 = ((Element)var6.get(var7)).getChild("code").getText();
            String var9 = ((Element)var6.get(var7)).getChild("lib_FR").getText();
            String var10 = ((Element)var6.get(var7)).getChild("lib_UK").getText();
            String var11 = ((Element)var6.get(var7)).getChild("lib_SP").getText();
            this.objetPaye.setCode(var8);
            this.objetPaye.setNom_FR(var9);
            this.objetPaye.setNom_UK(var10);
            this.objetPaye.setNom_SP(var11);
            this.mesCentresImpots.add(this.objetPaye);
            this.mesCentresImpotsItems.add(new SelectItem(this.objetPaye.getCode() + ":" + this.objetPaye.getNom_FR()));
         }

         var3.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

   }

   public List getMesCentresImpots() {
      return this.mesCentresImpots;
   }

   public void setMesCentresImpots(List var1) {
      this.mesCentresImpots = var1;
   }

   public List getMesCentresImpotsItems() {
      return this.mesCentresImpotsItems;
   }

   public void setMesCentresImpotsItems(List var1) {
      this.mesCentresImpotsItems = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }
}
