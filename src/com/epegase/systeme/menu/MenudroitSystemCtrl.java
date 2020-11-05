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

public class MenudroitSystemCtrl implements Serializable {
   private transient DataModel dataModelMenudroitSystemeXmlList = new ListDataModel();
   private String labase;

   public void chargerMenudroitSystemXml() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "00000.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         List var6 = var5.getChildren();
         ArrayList var7 = new ArrayList();

         for(int var8 = 0; var8 < var6.size(); ++var8) {
            ObjetLigneMenu var9 = new ObjetLigneMenu();
            var9.setIndice(var8);
            var9.setLibelle_FR(((Element)var6.get(var8)).getChild("libelle_FR").getText());
            var9.setLibelle_UK(((Element)var6.get(var8)).getChild("libelle_UK").getText());
            var9.setLibelle_SP(((Element)var6.get(var8)).getChild("libelle_SP").getText());
            var9.setCommande(((Element)var6.get(var8)).getChild("commande").getText());
            var9.setPagemenu(((Element)var6.get(var8)).getChild("pagemenu").getText());
            var9.setType(((Element)var6.get(var8)).getChild("type").getText());
            var9.setGenre(((Element)var6.get(var8)).getChild("genre").getText());
            var9.setAcc(Boolean.parseBoolean(((Element)var6.get(var8)).getChild("acc").getText()));
            var9.setAdd(Boolean.parseBoolean(((Element)var6.get(var8)).getChild("add").getText()));
            var9.setDup(Boolean.parseBoolean(((Element)var6.get(var8)).getChild("dup").getText()));
            var9.setMaj(Boolean.parseBoolean(((Element)var6.get(var8)).getChild("maj").getText()));
            var9.setSup(Boolean.parseBoolean(((Element)var6.get(var8)).getChild("sup").getText()));
            var9.setImp(Boolean.parseBoolean(((Element)var6.get(var8)).getChild("imp").getText()));
            var9.setClo(Boolean.parseBoolean(((Element)var6.get(var8)).getChild("clo").getText()));
            var9.setTrf(Boolean.parseBoolean(((Element)var6.get(var8)).getChild("trf").getText()));
            if (var9.isAcc()) {
               var7.add(var9);
            }
         }

         this.dataModelMenudroitSystemeXmlList.setWrappedData(var7);
         var3.close();
      } catch (JDOMException var10) {
         var10.getMessage();
      } catch (IOException var11) {
         var11.getMessage();
      }

   }

   public DataModel getDataModelMenudroitSystemeXmlList() {
      return this.dataModelMenudroitSystemeXmlList;
   }

   public void setDataModelMenudroitSystemeXmlList(DataModel var1) {
      this.dataModelMenudroitSystemeXmlList = var1;
   }

   public String getLabase() {
      return this.labase;
   }

   public void setLabase(String var1) {
      this.labase = var1;
   }
}
