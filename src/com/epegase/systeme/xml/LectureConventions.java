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

public class LectureConventions implements Serializable {
   private long strId;
   private Structure structureLog;
   private ObjetConvention objetConvention;
   private List mesConventions;
   private List mesConventionsUtils;
   private List mesConventionsItems;

   public void recuperePaye() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "paye" + File.separator + "configuration" + File.separator + "conv_" + this.structureLog.getStrcodepays() + ".xml");
         if (!var2.exists()) {
            var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "grillesConventions" + File.separator + "conv_" + this.structureLog.getStrcodepays() + ".xml");
         }

         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesConventions = new ArrayList();
         this.mesConventionsItems = new ArrayList();
         this.mesConventionsUtils = new ArrayList();
         List var6 = var5.getChildren();

         int var7;
         for(var7 = 0; var7 < var6.size(); ++var7) {
            this.objetConvention = new ObjetConvention();
            String var8 = ((Element)var6.get(var7)).getChild("code").getText();
            String var9 = ((Element)var6.get(var7)).getChild("lib_FR").getText();
            String var10 = ((Element)var6.get(var7)).getChild("lib_UK").getText();
            String var11 = ((Element)var6.get(var7)).getChild("lib_SP").getText();
            String var12 = ((Element)var6.get(var7)).getChild("heure_mois").getText();
            String var13 = ((Element)var6.get(var7)).getChild("heure_semaine").getText();
            String var14 = ((Element)var6.get(var7)).getChild("date_maj").getText();
            String var15 = ((Element)var6.get(var7)).getChild("tranche1").getText();
            String var16 = ((Element)var6.get(var7)).getChild("tranche2").getText();
            String var17 = ((Element)var6.get(var7)).getChild("tranche3").getText();
            String var18 = ((Element)var6.get(var7)).getChild("tranche4").getText();
            String var19 = ((Element)var6.get(var7)).getChild("tranche5").getText();
            String var20 = ((Element)var6.get(var7)).getChild("inactif").getText();
            String var21 = "0";
            if (((Element)var6.get(var7)).getChildren().size() == 14) {
               var21 = ((Element)var6.get(var7)).getChild("at").getText();
            }

            this.objetConvention.setCode(var8);
            this.objetConvention.setLib_FR(var9);
            this.objetConvention.setLib_UK(var10);
            this.objetConvention.setLib_SP(var11);
            this.objetConvention.setHeure_mois(Float.parseFloat(var12));
            this.objetConvention.setHeure_semaine(Float.parseFloat(var13));
            this.objetConvention.setDate_maj(var14);
            this.objetConvention.setAt(Float.parseFloat(var21));
            this.objetConvention.setTranche1(Float.parseFloat(var15));
            this.objetConvention.setTranche2(Float.parseFloat(var16));
            this.objetConvention.setTranche3(Float.parseFloat(var17));
            this.objetConvention.setTranche4(Float.parseFloat(var18));
            this.objetConvention.setTranche5(Float.parseFloat(var19));
            this.objetConvention.setInactif(var20);
            if (var20.equalsIgnoreCase("1")) {
               this.objetConvention.setValide(true);
            } else {
               this.objetConvention.setValide(false);
            }

            this.mesConventions.add(this.objetConvention);
            if (this.objetConvention.isValide()) {
               this.mesConventionsUtils.add(this.objetConvention);
               this.mesConventionsItems.add(new SelectItem(this.objetConvention.getCode() + ":" + this.objetConvention.getLib_FR()));
            }
         }

         if (this.mesConventionsUtils.size() == 0 && this.mesConventions.size() != 0) {
            for(var7 = 0; var7 < this.mesConventions.size(); ++var7) {
               this.objetConvention = new ObjetConvention();
               this.objetConvention = (ObjetConvention)this.mesConventions.get(var7);
               this.mesConventionsUtils.add(this.objetConvention);
               this.mesConventionsItems.add(new SelectItem(this.objetConvention.getCode() + ":" + this.objetConvention.getLib_FR()));
            }
         }

         if (this.mesConventionsItems == null) {
            this.mesConventionsItems = new ArrayList();
         }

         var3.close();
      } catch (JDOMException var22) {
      } catch (IOException var23) {
      }

   }

   public List getMesConventions() {
      return this.mesConventions;
   }

   public void setMesConventions(List var1) {
      this.mesConventions = var1;
   }

   public List getMesConventionsItems() {
      return this.mesConventionsItems;
   }

   public void setMesConventionsItems(List var1) {
      this.mesConventionsItems = var1;
   }

   public List getMesConventionsUtils() {
      return this.mesConventionsUtils;
   }

   public void setMesConventionsUtils(List var1) {
      this.mesConventionsUtils = var1;
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
