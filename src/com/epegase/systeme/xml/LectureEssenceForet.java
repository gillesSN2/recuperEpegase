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

public class LectureEssenceForet implements Serializable {
   private long strId;
   private Structure structureLog;
   private ObjetEssenceForet objetEssenceForet;
   private List mesElements = new ArrayList();
   private List mesElementsItems;

   public List chargerEssences() throws JDOMException, IOException {
      try {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "foret" + File.separator + "configuration" + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         SAXBuilder var3 = new SAXBuilder();
         Document var4 = null;
         FileReader var5 = null;
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "foret" + File.separator + "configuration" + File.separator + "essences.xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "foret" + File.separator + "configuration" + File.separator + "essences.xml");
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
            this.enregistreEssences(var4);
         } else {
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
         }

         Element var7 = var4.getRootElement();
         this.mesElements = new ArrayList();
         this.mesElementsItems = new ArrayList();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.objetEssenceForet = new ObjetEssenceForet();
            String var10 = ((Element)var8.get(var9)).getChild("libelle").getText();
            String var11 = ((Element)var8.get(var9)).getChild("code").getText();
            String var12 = ((Element)var8.get(var9)).getChild("atibt").getText();
            String var13 = ((Element)var8.get(var9)).getChild("octra").getText();
            String var14 = ((Element)var8.get(var9)).getChild("export").getText();
            String var15 = ((Element)var8.get(var9)).getChild("martelage").getText();
            this.objetEssenceForet.setIndice(var9);
            this.objetEssenceForet.setCode(var11);
            this.objetEssenceForet.setLibelle(var10);
            if (var12 != null && !var12.isEmpty()) {
               this.objetEssenceForet.setAtibt(Float.parseFloat(var12));
            } else {
               this.objetEssenceForet.setAtibt(0.0F);
            }

            if (var13 != null && !var13.isEmpty()) {
               this.objetEssenceForet.setOctra(Float.parseFloat(var13));
            } else {
               this.objetEssenceForet.setOctra(0.0F);
            }

            if (var14 != null && !var14.isEmpty()) {
               this.objetEssenceForet.setExport(Float.parseFloat(var14));
            } else {
               this.objetEssenceForet.setExport(0.0F);
            }

            if (var15 != null && !var15.isEmpty()) {
               this.objetEssenceForet.setMartelage(Integer.parseInt(var15));
            } else {
               this.objetEssenceForet.setMartelage(0);
            }

            String var16 = ((Element)var8.get(var9)).getChild("prx_plage_01").getText();
            String var17 = ((Element)var8.get(var9)).getChild("prx_cession_01").getText();
            String var18 = ((Element)var8.get(var9)).getChild("val_douane_01").getText();
            if (var16 != null && !var16.isEmpty()) {
               this.objetEssenceForet.setPrx_plage_01(Double.parseDouble(var16));
            } else {
               this.objetEssenceForet.setPrx_plage_01(0.0D);
            }

            if (var17 != null && !var17.isEmpty()) {
               this.objetEssenceForet.setPrx_cession_01(Double.parseDouble(var17));
            } else {
               this.objetEssenceForet.setPrx_cession_01(0.0D);
            }

            if (var18 != null && !var18.isEmpty()) {
               this.objetEssenceForet.setVal_douane_01(Double.parseDouble(var18));
            } else {
               this.objetEssenceForet.setVal_douane_01(0.0D);
            }

            String var19 = ((Element)var8.get(var9)).getChild("prx_plage_02").getText();
            String var20 = ((Element)var8.get(var9)).getChild("prx_cession_02").getText();
            String var21 = ((Element)var8.get(var9)).getChild("val_douane_02").getText();
            if (var19 != null && !var19.isEmpty()) {
               this.objetEssenceForet.setPrx_plage_02(Double.parseDouble(var19));
            } else {
               this.objetEssenceForet.setPrx_plage_02(0.0D);
            }

            if (var20 != null && !var20.isEmpty()) {
               this.objetEssenceForet.setPrx_cession_02(Double.parseDouble(var20));
            } else {
               this.objetEssenceForet.setPrx_cession_02(0.0D);
            }

            if (var21 != null && !var21.isEmpty()) {
               this.objetEssenceForet.setVal_douane_02(Double.parseDouble(var21));
            } else {
               this.objetEssenceForet.setVal_douane_02(0.0D);
            }

            String var22 = ((Element)var8.get(var9)).getChild("prx_plage_03").getText();
            String var23 = ((Element)var8.get(var9)).getChild("prx_cession_03").getText();
            String var24 = ((Element)var8.get(var9)).getChild("val_douane_03").getText();
            if (var22 != null && !var22.isEmpty()) {
               this.objetEssenceForet.setPrx_plage_03(Double.parseDouble(var22));
            } else {
               this.objetEssenceForet.setPrx_plage_03(0.0D);
            }

            if (var23 != null && !var23.isEmpty()) {
               this.objetEssenceForet.setPrx_cession_03(Double.parseDouble(var23));
            } else {
               this.objetEssenceForet.setPrx_cession_03(0.0D);
            }

            if (var24 != null && !var24.isEmpty()) {
               this.objetEssenceForet.setVal_douane_03(Double.parseDouble(var24));
            } else {
               this.objetEssenceForet.setVal_douane_03(0.0D);
            }

            String var25 = ((Element)var8.get(var9)).getChild("prx_plage_04").getText();
            String var26 = ((Element)var8.get(var9)).getChild("prx_cession_04").getText();
            String var27 = ((Element)var8.get(var9)).getChild("val_douane_04").getText();
            if (var25 != null && !var25.isEmpty()) {
               this.objetEssenceForet.setPrx_plage_04(Double.parseDouble(var25));
            } else {
               this.objetEssenceForet.setPrx_plage_04(0.0D);
            }

            if (var26 != null && !var26.isEmpty()) {
               this.objetEssenceForet.setPrx_cession_04(Double.parseDouble(var26));
            } else {
               this.objetEssenceForet.setPrx_cession_04(0.0D);
            }

            if (var27 != null && !var27.isEmpty()) {
               this.objetEssenceForet.setVal_douane_04(Double.parseDouble(var27));
            } else {
               this.objetEssenceForet.setVal_douane_04(0.0D);
            }

            String var28 = ((Element)var8.get(var9)).getChild("prx_plage_05").getText();
            String var29 = ((Element)var8.get(var9)).getChild("prx_cession_05").getText();
            String var30 = ((Element)var8.get(var9)).getChild("val_douane_05").getText();
            if (var28 != null && !var28.isEmpty()) {
               this.objetEssenceForet.setPrx_plage_05(Double.parseDouble(var28));
            } else {
               this.objetEssenceForet.setPrx_plage_05(0.0D);
            }

            if (var29 != null && !var29.isEmpty()) {
               this.objetEssenceForet.setPrx_cession_05(Double.parseDouble(var29));
            } else {
               this.objetEssenceForet.setPrx_cession_05(0.0D);
            }

            if (var30 != null && !var30.isEmpty()) {
               this.objetEssenceForet.setVal_douane_05(Double.parseDouble(var30));
            } else {
               this.objetEssenceForet.setVal_douane_05(0.0D);
            }

            String var31 = ((Element)var8.get(var9)).getChild("prx_plage_06").getText();
            String var32 = ((Element)var8.get(var9)).getChild("prx_cession_06").getText();
            String var33 = ((Element)var8.get(var9)).getChild("val_douane_06").getText();
            if (var31 != null && !var31.isEmpty()) {
               this.objetEssenceForet.setPrx_plage_06(Double.parseDouble(var31));
            } else {
               this.objetEssenceForet.setPrx_plage_06(0.0D);
            }

            if (var32 != null && !var32.isEmpty()) {
               this.objetEssenceForet.setPrx_cession_06(Double.parseDouble(var32));
            } else {
               this.objetEssenceForet.setPrx_cession_06(0.0D);
            }

            if (var33 != null && !var33.isEmpty()) {
               this.objetEssenceForet.setVal_douane_06(Double.parseDouble(var33));
            } else {
               this.objetEssenceForet.setVal_douane_06(0.0D);
            }

            String var34 = ((Element)var8.get(var9)).getChild("prx_plage_07").getText();
            String var35 = ((Element)var8.get(var9)).getChild("prx_cession_07").getText();
            String var36 = ((Element)var8.get(var9)).getChild("val_douane_07").getText();
            if (var34 != null && !var34.isEmpty()) {
               this.objetEssenceForet.setPrx_plage_07(Double.parseDouble(var34));
            } else {
               this.objetEssenceForet.setPrx_plage_07(0.0D);
            }

            if (var35 != null && !var35.isEmpty()) {
               this.objetEssenceForet.setPrx_cession_07(Double.parseDouble(var35));
            } else {
               this.objetEssenceForet.setPrx_cession_07(0.0D);
            }

            if (var36 != null && !var36.isEmpty()) {
               this.objetEssenceForet.setVal_douane_07(Double.parseDouble(var36));
            } else {
               this.objetEssenceForet.setVal_douane_07(0.0D);
            }

            String var37 = ((Element)var8.get(var9)).getChild("prx_plage_08").getText();
            String var38 = ((Element)var8.get(var9)).getChild("prx_cession_08").getText();
            String var39 = ((Element)var8.get(var9)).getChild("val_douane_08").getText();
            if (var37 != null && !var37.isEmpty()) {
               this.objetEssenceForet.setPrx_plage_08(Double.parseDouble(var37));
            } else {
               this.objetEssenceForet.setPrx_plage_08(0.0D);
            }

            if (var38 != null && !var38.isEmpty()) {
               this.objetEssenceForet.setPrx_cession_08(Double.parseDouble(var38));
            } else {
               this.objetEssenceForet.setPrx_cession_08(0.0D);
            }

            if (var39 != null && !var39.isEmpty()) {
               this.objetEssenceForet.setVal_douane_08(Double.parseDouble(var39));
            } else {
               this.objetEssenceForet.setVal_douane_08(0.0D);
            }

            String var40 = ((Element)var8.get(var9)).getChild("prx_plage_09").getText();
            String var41 = ((Element)var8.get(var9)).getChild("prx_cession_09").getText();
            String var42 = ((Element)var8.get(var9)).getChild("val_douane_09").getText();
            if (var40 != null && !var40.isEmpty()) {
               this.objetEssenceForet.setPrx_plage_09(Double.parseDouble(var40));
            } else {
               this.objetEssenceForet.setPrx_plage_09(0.0D);
            }

            if (var41 != null && !var41.isEmpty()) {
               this.objetEssenceForet.setPrx_cession_09(Double.parseDouble(var41));
            } else {
               this.objetEssenceForet.setPrx_cession_09(0.0D);
            }

            if (var42 != null && !var42.isEmpty()) {
               this.objetEssenceForet.setVal_douane_09(Double.parseDouble(var42));
            } else {
               this.objetEssenceForet.setVal_douane_09(0.0D);
            }

            String var43 = ((Element)var8.get(var9)).getChild("prx_plage_10").getText();
            String var44 = ((Element)var8.get(var9)).getChild("prx_cession_10").getText();
            String var45 = ((Element)var8.get(var9)).getChild("val_douane_10").getText();
            if (var43 != null && !var43.isEmpty()) {
               this.objetEssenceForet.setPrx_plage_10(Double.parseDouble(var43));
            } else {
               this.objetEssenceForet.setPrx_plage_10(0.0D);
            }

            if (var44 != null && !var44.isEmpty()) {
               this.objetEssenceForet.setPrx_cession_10(Double.parseDouble(var44));
            } else {
               this.objetEssenceForet.setPrx_cession_10(0.0D);
            }

            if (var45 != null && !var45.isEmpty()) {
               this.objetEssenceForet.setVal_douane_10(Double.parseDouble(var45));
            } else {
               this.objetEssenceForet.setVal_douane_10(0.0D);
            }

            String var46 = ((Element)var8.get(var9)).getChild("prx_plage_11").getText();
            String var47 = ((Element)var8.get(var9)).getChild("prx_cession_11").getText();
            String var48 = ((Element)var8.get(var9)).getChild("val_douane_11").getText();
            if (var46 != null && !var46.isEmpty()) {
               this.objetEssenceForet.setPrx_plage_11(Double.parseDouble(var46));
            } else {
               this.objetEssenceForet.setPrx_plage_11(0.0D);
            }

            if (var47 != null && !var47.isEmpty()) {
               this.objetEssenceForet.setPrx_cession_11(Double.parseDouble(var47));
            } else {
               this.objetEssenceForet.setPrx_cession_11(0.0D);
            }

            if (var48 != null && !var48.isEmpty()) {
               this.objetEssenceForet.setVal_douane_11(Double.parseDouble(var48));
            } else {
               this.objetEssenceForet.setVal_douane_11(0.0D);
            }

            String var49 = ((Element)var8.get(var9)).getChild("prx_plage_12").getText();
            String var50 = ((Element)var8.get(var9)).getChild("prx_cession_12").getText();
            String var51 = ((Element)var8.get(var9)).getChild("val_douane_12").getText();
            if (var49 != null && !var49.isEmpty()) {
               this.objetEssenceForet.setPrx_plage_12(Double.parseDouble(var49));
            } else {
               this.objetEssenceForet.setPrx_plage_12(0.0D);
            }

            if (var50 != null && !var50.isEmpty()) {
               this.objetEssenceForet.setPrx_cession_12(Double.parseDouble(var50));
            } else {
               this.objetEssenceForet.setPrx_cession_12(0.0D);
            }

            if (var51 != null && !var51.isEmpty()) {
               this.objetEssenceForet.setVal_douane_12(Double.parseDouble(var51));
            } else {
               this.objetEssenceForet.setVal_douane_12(0.0D);
            }

            this.mesElements.add(this.objetEssenceForet);
            this.mesElementsItems.add(new SelectItem(this.objetEssenceForet.getCode(), this.objetEssenceForet.getLibelle()));
         }

         var5.close();
      } catch (JDOMException var52) {
      } catch (IOException var53) {
      }

      return this.mesElementsItems;
   }

   public void enregistreEssences(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "foret" + File.separator + "configuration" + File.separator + "essences.xml");
      var2.output(var1, var3);
      var3.close();
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

   public List getMesElements() {
      return this.mesElements;
   }

   public void setMesElements(List var1) {
      this.mesElements = var1;
   }

   public List getMesElementsItems() {
      return this.mesElementsItems;
   }

   public void setMesElementsItems(List var1) {
      this.mesElementsItems = var1;
   }
}
