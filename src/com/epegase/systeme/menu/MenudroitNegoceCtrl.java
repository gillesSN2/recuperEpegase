package com.epegase.systeme.menu;

import com.epegase.systeme.classe.Users;
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

public class MenudroitNegoceCtrl implements Serializable {
   private long strId;
   private int strEnteteGroupe = 0;
   private transient DataModel dataModelMenudroitNegoceXmlList = new ListDataModel();

   public void chargerMenudroitNegoceXml(String var1, long var2, Users var4) {
      String var5 = "";
      if (this.strEnteteGroupe == 2) {
         var5 = "_ENT";
      } else {
         var5 = "";
      }

      try {
         SAXBuilder var6 = new SAXBuilder();
         File var7 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "81620" + var5 + "-" + var1 + ".xml");
         if (!var7.exists()) {
            var7 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "81620" + var5 + ".xml");
         }

         FileReader var8 = new FileReader(var7);
         Document var9 = var6.build(var8);
         Element var10 = var9.getRootElement();
         List var11 = var10.getChildren();
         ArrayList var12 = new ArrayList();

         for(int var13 = 0; var13 < var11.size(); ++var13) {
            ObjetLigneMenu var14 = new ObjetLigneMenu();
            var14.setIndice(var13);
            var14.setLibelle_FR(((Element)var11.get(var13)).getChild("libelle_FR").getText());
            var14.setLibelle_UK(((Element)var11.get(var13)).getChild("libelle_UK").getText());
            var14.setLibelle_SP(((Element)var11.get(var13)).getChild("libelle_SP").getText());
            var14.setCommande(((Element)var11.get(var13)).getChild("commande").getText());
            var14.setPagemenu(((Element)var11.get(var13)).getChild("pagemenu").getText());
            var14.setType(((Element)var11.get(var13)).getChild("type").getText());
            var14.setGenre(((Element)var11.get(var13)).getChild("genre").getText());
            var14.setAcc(Boolean.parseBoolean(((Element)var11.get(var13)).getChild("acc").getText()));
            var14.setAdd(Boolean.parseBoolean(((Element)var11.get(var13)).getChild("add").getText()));
            var14.setDup(Boolean.parseBoolean(((Element)var11.get(var13)).getChild("dup").getText()));
            var14.setMaj(Boolean.parseBoolean(((Element)var11.get(var13)).getChild("maj").getText()));
            var14.setSup(Boolean.parseBoolean(((Element)var11.get(var13)).getChild("sup").getText()));
            var14.setImp(Boolean.parseBoolean(((Element)var11.get(var13)).getChild("imp").getText()));
            var14.setClo(Boolean.parseBoolean(((Element)var11.get(var13)).getChild("clo").getText()));
            var14.setTrf(Boolean.parseBoolean(((Element)var11.get(var13)).getChild("trf").getText()));
            if (var14.isAcc()) {
               var12.add(var14);
            }
         }

         this.dataModelMenudroitNegoceXmlList.setWrappedData(var12);
         var8.close();
      } catch (JDOMException var15) {
         var15.getMessage();
      } catch (IOException var16) {
         var16.getMessage();
      }

   }

   public DataModel getDataModelMenudroitNegoceXmlList() {
      return this.dataModelMenudroitNegoceXmlList;
   }

   public void setDataModelMenudroitNegoceXmlList(DataModel var1) {
      this.dataModelMenudroitNegoceXmlList = var1;
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
