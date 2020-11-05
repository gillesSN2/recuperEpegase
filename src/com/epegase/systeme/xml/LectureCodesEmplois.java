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

public class LectureCodesEmplois implements Serializable {
   private long strId;
   private Structure structureLog;
   private ObjetCompte objetPaye;
   private List mesCodesEmplois;
   private List mesCodesEmploisItems;

   public void recuperePaye() {
      this.mesCodesEmplois = new ArrayList();
      this.mesCodesEmploisItems = new ArrayList();

      try {
         File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "codesEmplois" + File.separator + "cod_" + this.structureLog.getStrcodepays() + ".xml");
         if (var1.exists()) {
            SAXBuilder var2 = new SAXBuilder();
            FileReader var3 = new FileReader(var1);
            Document var4 = var2.build(var3);
            Element var5 = var4.getRootElement();
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
               this.mesCodesEmplois.add(this.objetPaye);
               this.mesCodesEmploisItems.add(new SelectItem(this.objetPaye.getCode(), this.objetPaye.getCode() + ":" + this.objetPaye.getNom_FR()));
            }

            var3.close();
         }
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

   }

   public List getMesCodesEmplois() {
      return this.mesCodesEmplois;
   }

   public void setMesCodesEmplois(List var1) {
      this.mesCodesEmplois = var1;
   }

   public List getMesCodesEmploisItems() {
      return this.mesCodesEmploisItems;
   }

   public void setMesCodesEmploisItems(List var1) {
      this.mesCodesEmploisItems = var1;
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
