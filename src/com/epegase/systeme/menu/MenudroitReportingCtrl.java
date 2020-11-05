package com.epegase.systeme.menu;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.xml.ObjetLigneMenu;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class MenudroitReportingCtrl implements Serializable {
   private long strId;
   private int strEnteteGroupe = 0;
   private transient DataModel dataModelMenudroitReportingXmlList = new ListDataModel();

   public void chargerMenuGaucheReportingXml(String var1, Structure var2) {
      String var3 = "";
      if (this.strEnteteGroupe == 2) {
         var3 = "_ENT";
      } else {
         var3 = "";
      }

      try {
         SAXBuilder var4 = new SAXBuilder();
         File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "91000" + var3 + "-" + var1 + ".xml");
         if (!var5.exists()) {
            var5 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "91000" + var3 + ".xml");
         }

         FileReader var6 = new FileReader(var5);
         Document var7 = var4.build(var6);
         Element var8 = var7.getRootElement();
         List var9 = var8.getChildren();
         ArrayList var10 = new ArrayList();

         for(int var11 = 0; var11 < var9.size(); ++var11) {
            ObjetLigneMenu var12 = new ObjetLigneMenu();
            var12.setIndice(var11);
            var12.setLibelle_FR(((Element)var9.get(var11)).getChild("libelle_FR").getText());
            var12.setLibelle_UK(((Element)var9.get(var11)).getChild("libelle_UK").getText());
            var12.setLibelle_SP(((Element)var9.get(var11)).getChild("libelle_SP").getText());
            var12.setCommande(((Element)var9.get(var11)).getChild("commande").getText());
            var12.setPagemenu(((Element)var9.get(var11)).getChild("pagemenu").getText());
            var12.setType(((Element)var9.get(var11)).getChild("type").getText());
            var12.setGenre(((Element)var9.get(var11)).getChild("genre").getText());
            var12.setAcc(Boolean.parseBoolean(((Element)var9.get(var11)).getChild("acc").getText()));
            var12.setAdd(Boolean.parseBoolean(((Element)var9.get(var11)).getChild("add").getText()));
            var12.setDup(Boolean.parseBoolean(((Element)var9.get(var11)).getChild("dup").getText()));
            var12.setMaj(Boolean.parseBoolean(((Element)var9.get(var11)).getChild("maj").getText()));
            var12.setSup(Boolean.parseBoolean(((Element)var9.get(var11)).getChild("sup").getText()));
            var12.setImp(Boolean.parseBoolean(((Element)var9.get(var11)).getChild("imp").getText()));
            var12.setClo(Boolean.parseBoolean(((Element)var9.get(var11)).getChild("clo").getText()));
            var12.setTrf(Boolean.parseBoolean(((Element)var9.get(var11)).getChild("trf").getText()));
            if (var12.isAcc() && this.verifModuleInstalle(var12.getType(), var2)) {
               var10.add(var12);
            }
         }

         this.dataModelMenudroitReportingXmlList.setWrappedData(var10);
         var6.close();
      } catch (JDOMException var13) {
         var13.getMessage();
      } catch (IOException var14) {
         var14.getMessage();
      }

   }

   public boolean verifModuleInstalle(String var1, Structure var2) {
      boolean var3 = false;
      if (var1 != null && !var1.isEmpty()) {
         if (var2.getStrmod1() != null && var2.getStrmod1().startsWith(var1)) {
            var3 = true;
         } else if (var2.getStrmod2() != null && var2.getStrmod2().startsWith(var1)) {
            var3 = true;
         } else if (var2.getStrmod3() != null && var2.getStrmod3().startsWith(var1)) {
            var3 = true;
         } else if (var2.getStrmod4() != null && var2.getStrmod4().startsWith(var1)) {
            var3 = true;
         } else if (var2.getStrmod5() != null && var2.getStrmod5().startsWith(var1)) {
            var3 = true;
         } else if (var2.getStrmod6() != null && var2.getStrmod6().startsWith(var1)) {
            var3 = true;
         } else if (var2.getStrmod7() != null && var2.getStrmod7().startsWith(var1)) {
            var3 = true;
         } else if (var2.getStrmod8() != null && var2.getStrmod8().startsWith(var1)) {
            var3 = true;
         } else if (var2.getStrmod9() != null && var2.getStrmod9().startsWith(var1)) {
            var3 = true;
         } else if (var2.getStrmod10() != null && var2.getStrmod10().startsWith(var1)) {
            var3 = true;
         }
      } else {
         var3 = true;
      }

      return var3;
   }

   public DataModel getDataModelMenudroitReportingXmlList() {
      return this.dataModelMenudroitReportingXmlList;
   }

   public void setDataModelMenudroitReportingXmlList(DataModel var1) {
      this.dataModelMenudroitReportingXmlList = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }

   public int getStrEnteteGroupe() {
      return this.strEnteteGroupe;
   }

   public void setStrEnteteGroupe(int var1) {
      this.strEnteteGroupe = var1;
   }
}
