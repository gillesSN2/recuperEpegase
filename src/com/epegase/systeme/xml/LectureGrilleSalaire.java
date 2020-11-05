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

public class LectureGrilleSalaire implements Serializable {
   private long strId;
   private Structure structureLog;
   private ObjetGrilleSalaire objetGrilleSalaire;
   private List mesGrillesSalaires;
   private List mesGrillesSalairesItems;

   public boolean recuperePaye(String var1) {
      boolean var2 = false;

      try {
         SAXBuilder var3 = new SAXBuilder();
         File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "paye" + File.separator + "configuration" + File.separator + "gril_" + this.structureLog.getStrcodepays() + "_" + var1 + ".xml");
         if (!var4.exists()) {
            var4 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "grillesConventions" + File.separator + "gril_" + this.structureLog.getStrcodepays() + "_" + var1 + ".xml");
         } else {
            var2 = true;
         }

         FileReader var5 = new FileReader(var4);
         Document var6 = var3.build(var5);
         Element var7 = var6.getRootElement();
         this.mesGrillesSalaires = new ArrayList();
         this.mesGrillesSalairesItems = new ArrayList();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.objetGrilleSalaire = new ObjetGrilleSalaire();
            String var10 = ((Element)var8.get(var9)).getChild("code").getText();
            String var11 = ((Element)var8.get(var9)).getChild("lib_FR").getText();
            String var12 = ((Element)var8.get(var9)).getChild("lib_UK").getText();
            String var13 = ((Element)var8.get(var9)).getChild("lib_SP").getText();
            String var14 = ((Element)var8.get(var9)).getChild("val_mois").getText();
            String var15 = ((Element)var8.get(var9)).getChild("val_heure").getText();
            String var16 = ((Element)var8.get(var9)).getChild("niveau").getText();
            String var17 = ((Element)var8.get(var9)).getChild("rendement").getText();
            String var18 = ((Element)var8.get(var9)).getChild("responsabilite").getText();
            String var19 = ((Element)var8.get(var9)).getChild("fonction").getText();
            String var20 = ((Element)var8.get(var9)).getChild("caisse").getText();
            String var21 = ((Element)var8.get(var9)).getChild("transport").getText();
            String var22 = ((Element)var8.get(var9)).getChild("telephone").getText();
            String var23 = ((Element)var8.get(var9)).getChild("logement").getText();
            String var24 = ((Element)var8.get(var9)).getChild("eau").getText();
            String var25 = ((Element)var8.get(var9)).getChild("electricite").getText();
            this.objetGrilleSalaire.setCode(var10);
            if (var11 == null || var11.isEmpty()) {
               var11 = "n.d.";
            }

            if (var12 == null || var12.isEmpty()) {
               var12 = "n.d.";
            }

            if (var13 == null || var13.isEmpty()) {
               var13 = "n.d.";
            }

            this.objetGrilleSalaire.setLib_FR(var11);
            this.objetGrilleSalaire.setLib_UK(var12);
            this.objetGrilleSalaire.setLib_SP(var13);
            this.objetGrilleSalaire.setVal_mois(Float.parseFloat(var14));
            this.objetGrilleSalaire.setVal_heure(Float.parseFloat(var15));
            this.objetGrilleSalaire.setNiveau(var16);
            this.objetGrilleSalaire.setRendement(Double.parseDouble(var17));
            this.objetGrilleSalaire.setResponsabilite(Double.parseDouble(var18));
            this.objetGrilleSalaire.setFonction(Double.parseDouble(var19));
            this.objetGrilleSalaire.setCaisse(Double.parseDouble(var20));
            this.objetGrilleSalaire.setTransport(Double.parseDouble(var21));
            this.objetGrilleSalaire.setTelephone(Double.parseDouble(var22));
            this.objetGrilleSalaire.setLogement(Double.parseDouble(var23));
            this.objetGrilleSalaire.setEau(Double.parseDouble(var24));
            this.objetGrilleSalaire.setElectricite(Double.parseDouble(var25));
            this.mesGrillesSalaires.add(this.objetGrilleSalaire);
            this.mesGrillesSalairesItems.add(new SelectItem(this.objetGrilleSalaire.getCode() + ":" + this.objetGrilleSalaire.getLib_FR()));
         }

         var5.close();
      } catch (JDOMException var26) {
      } catch (IOException var27) {
      }

      return var2;
   }

   public List getMesGrillesSalaires() {
      return this.mesGrillesSalaires;
   }

   public void setMesGrillesSalaires(List var1) {
      this.mesGrillesSalaires = var1;
   }

   public List getMesGrillesSalairesItems() {
      return this.mesGrillesSalairesItems;
   }

   public void setMesGrillesSalairesItems(List var1) {
      this.mesGrillesSalairesItems = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }
}
