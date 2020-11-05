package com.epegase.systeme.menu;

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

public class MenudroitMedicalCtrl implements Serializable {
   private long strId;
   private int strEnteteGroupe = 0;
   private transient DataModel dataModelMenudroitMedicalXmlList = new ListDataModel();

   public void chargerMenudroitMedicalXml(String var1, int var2) {
      String var3 = "";
      if (this.strEnteteGroupe == 2) {
         var3 = "_ENT";
      } else {
         var3 = "";
      }

      if (var2 == 0) {
         var2 = 81550;
      }

      new ArrayList();

      try {
         SAXBuilder var5 = new SAXBuilder();
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + var2 + var3 + "-" + var1 + ".xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + var2 + var3 + ".xml");
         }

         FileReader var7 = new FileReader(var6);
         Document var8 = var5.build(var7);
         Element var9 = var8.getRootElement();
         List var10 = var9.getChildren();
         ArrayList var4 = new ArrayList();

         for(int var11 = 0; var11 < var10.size(); ++var11) {
            ObjetLigneMenu var12 = new ObjetLigneMenu();
            var12.setIndice(var11);
            var12.setLibelle_FR(((Element)var10.get(var11)).getChild("libelle_FR").getText());
            var12.setLibelle_UK(((Element)var10.get(var11)).getChild("libelle_UK").getText());
            var12.setLibelle_SP(((Element)var10.get(var11)).getChild("libelle_SP").getText());
            var12.setCommande(((Element)var10.get(var11)).getChild("commande").getText());
            var12.setPagemenu(((Element)var10.get(var11)).getChild("pagemenu").getText());
            var12.setType(((Element)var10.get(var11)).getChild("type").getText());
            var12.setGenre(((Element)var10.get(var11)).getChild("genre").getText());
            var12.setAcc(Boolean.parseBoolean(((Element)var10.get(var11)).getChild("acc").getText()));
            var12.setAdd(Boolean.parseBoolean(((Element)var10.get(var11)).getChild("add").getText()));
            var12.setDup(Boolean.parseBoolean(((Element)var10.get(var11)).getChild("dup").getText()));
            var12.setMaj(Boolean.parseBoolean(((Element)var10.get(var11)).getChild("maj").getText()));
            var12.setSup(Boolean.parseBoolean(((Element)var10.get(var11)).getChild("sup").getText()));
            var12.setImp(Boolean.parseBoolean(((Element)var10.get(var11)).getChild("imp").getText()));
            var12.setClo(Boolean.parseBoolean(((Element)var10.get(var11)).getChild("clo").getText()));
            var12.setTrf(Boolean.parseBoolean(((Element)var10.get(var11)).getChild("trf").getText()));
            if (var12.isAcc()) {
               var4.add(var12);
            }
         }

         this.dataModelMenudroitMedicalXmlList.setWrappedData(var4);
         var7.close();
      } catch (JDOMException var13) {
         var13.getMessage();
      } catch (IOException var14) {
         var14.getMessage();
      }

   }

   public DataModel getDataModelMenudroitMedicalXmlList() {
      return this.dataModelMenudroitMedicalXmlList;
   }

   public void setDataModelMenudroitMedicalXmlList(DataModel var1) {
      this.dataModelMenudroitMedicalXmlList = var1;
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
