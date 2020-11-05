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

public class LectureNatureRH implements Serializable {
   private long strId;
   private Structure structureLog;
   private ObjetCompte objetCompte;
   private List mesNatureRh;
   private List mesNatureRhUtils;
   private List mesNatureRhUtilsItems;

   public void recuperePaye() {
      this.mesNatureRh = new ArrayList();
      this.mesNatureRhUtilsItems = new ArrayList();
      this.mesNatureRhUtils = new ArrayList();

      try {
         File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "paye" + File.separator + "configuration" + File.separator + "natureRH.xml");
         if (!var1.exists()) {
            var1 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "natureRH.xml");
         }

         if (var1.exists()) {
            SAXBuilder var2 = new SAXBuilder();
            FileReader var3 = new FileReader(var1);
            Document var4 = var2.build(var3);
            Element var5 = var4.getRootElement();
            List var6 = var5.getChildren();

            int var7;
            for(var7 = 0; var7 < var6.size(); ++var7) {
               this.objetCompte = new ObjetCompte();
               String var8 = ((Element)var6.get(var7)).getChild("libelle").getText();
               String var9 = ((Element)var6.get(var7)).getChild("code").getText();
               String var10 = ((Element)var6.get(var7)).getChild("chrono").getText();
               String var11 = ((Element)var6.get(var7)).getChild("inactif").getText();
               this.objetCompte.setCode(var9);
               this.objetCompte.setNom_FR(var8);
               this.objetCompte.setLot(var10);
               if (var11.equals("1")) {
                  this.objetCompte.setValide(true);
               } else {
                  this.objetCompte.setValide(false);
               }

               this.mesNatureRh.add(this.objetCompte);
               if (this.objetCompte.isValide()) {
                  this.mesNatureRhUtils.add(this.objetCompte);
               }
            }

            if (this.mesNatureRhUtils.size() == 0 && this.mesNatureRh.size() != 0) {
               for(var7 = 0; var7 < this.mesNatureRh.size(); ++var7) {
                  this.objetCompte = new ObjetCompte();
                  this.objetCompte = (ObjetCompte)this.mesNatureRh.get(var7);
                  this.mesNatureRhUtils.add(this.objetCompte);
                  this.mesNatureRhUtilsItems.add(new SelectItem(this.objetCompte.getCode(), this.objetCompte.getNom_FR()));
               }
            }

            var3.close();
         }

         if (this.mesNatureRhUtilsItems == null) {
            this.mesNatureRhUtilsItems = new ArrayList();
         }
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

   }

   public List getMesNatureRh() {
      return this.mesNatureRh;
   }

   public void setMesNatureRh(List var1) {
      this.mesNatureRh = var1;
   }

   public List getMesNatureRhUtils() {
      return this.mesNatureRhUtils;
   }

   public void setMesNatureRhUtils(List var1) {
      this.mesNatureRhUtils = var1;
   }

   public List getMesNatureRhUtilsItems() {
      return this.mesNatureRhUtilsItems;
   }

   public void setMesNatureRhUtilsItems(List var1) {
      this.mesNatureRhUtilsItems = var1;
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
