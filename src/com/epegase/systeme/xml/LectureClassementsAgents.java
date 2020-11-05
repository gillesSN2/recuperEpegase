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

public class LectureClassementsAgents implements Serializable {
   private Structure structureLog;
   private ObjetCompte objetPaye;
   private List mesClassements;
   private List mesClassementsItems;

   public void recuperePaye() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "classements" + File.separator + "clas_" + this.structureLog.getStrcodepays() + ".xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesClassements = new ArrayList();
         this.mesClassementsItems = new ArrayList();
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
            this.mesClassements.add(this.objetPaye);
            this.mesClassementsItems.add(new SelectItem(this.objetPaye.getCode() + ":" + this.objetPaye.getNom_FR()));
         }

         var3.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

   }

   public List getMesClassements() {
      return this.mesClassements;
   }

   public void setMesClassements(List var1) {
      this.mesClassements = var1;
   }

   public List getMesClassementsItems() {
      return this.mesClassementsItems;
   }

   public void setMesClassementsItems(List var1) {
      this.mesClassementsItems = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }
}
