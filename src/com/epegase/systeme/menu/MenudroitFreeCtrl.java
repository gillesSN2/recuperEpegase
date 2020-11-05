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

public class MenudroitFreeCtrl implements Serializable {
   private long strId;
   private transient DataModel dataModelMenudroitFreeXmlList = new ListDataModel();

   public void chargerMenudroitFreeXml(String var1) {
      try {
         SAXBuilder var2 = new SAXBuilder();
         File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "10500-" + var1 + ".xml");
         if (!var3.exists()) {
            var3 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "10500.xml");
         }

         FileReader var4 = new FileReader(var3);
         Document var5 = var2.build(var4);
         Element var6 = var5.getRootElement();
         List var7 = var6.getChildren();
         ArrayList var8 = new ArrayList();

         for(int var9 = 0; var9 < var7.size(); ++var9) {
            ObjetLigneMenu var10 = new ObjetLigneMenu();
            var10.setIndice(var9);
            var10.setLibelle_FR(((Element)var7.get(var9)).getChild("libelle_FR").getText());
            var10.setLibelle_UK(((Element)var7.get(var9)).getChild("libelle_UK").getText());
            var10.setLibelle_SP(((Element)var7.get(var9)).getChild("libelle_SP").getText());
            var10.setCommande(((Element)var7.get(var9)).getChild("commande").getText());
            var10.setPagemenu(((Element)var7.get(var9)).getChild("pagemenu").getText());
            var10.setType(((Element)var7.get(var9)).getChild("type").getText());
            var10.setGenre(((Element)var7.get(var9)).getChild("genre").getText());
            var10.setAcc(Boolean.parseBoolean(((Element)var7.get(var9)).getChild("acc").getText()));
            var10.setAdd(Boolean.parseBoolean(((Element)var7.get(var9)).getChild("add").getText()));
            var10.setDup(Boolean.parseBoolean(((Element)var7.get(var9)).getChild("dup").getText()));
            var10.setMaj(Boolean.parseBoolean(((Element)var7.get(var9)).getChild("maj").getText()));
            var10.setSup(Boolean.parseBoolean(((Element)var7.get(var9)).getChild("sup").getText()));
            var10.setImp(Boolean.parseBoolean(((Element)var7.get(var9)).getChild("imp").getText()));
            var10.setClo(Boolean.parseBoolean(((Element)var7.get(var9)).getChild("clo").getText()));
            var10.setTrf(Boolean.parseBoolean(((Element)var7.get(var9)).getChild("trf").getText()));
            if (var10.isAcc()) {
               var8.add(var10);
            }
         }

         this.dataModelMenudroitFreeXmlList.setWrappedData(var8);
         var4.close();
      } catch (JDOMException var11) {
         var11.getMessage();
      } catch (IOException var12) {
         var12.getMessage();
      }

   }

   public DataModel getDataModelMenudroitFreeXmlList() {
      return this.dataModelMenudroitFreeXmlList;
   }

   public void setDataModelMenudroitFreeXmlList(DataModel var1) {
      this.dataModelMenudroitFreeXmlList = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }
}
