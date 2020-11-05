package com.epegase.systeme.menu;

import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionComptabilite;
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

public class MenudroitComptabiliteCtrl implements Serializable {
   private long strId;
   private int strEnteteGroupe = 0;
   private transient DataModel dataModelMenudroitComptabiliteXmlList = new ListDataModel();

   public void chargerMenudroitComptabiliteXml(String var1, String var2, OptionComptabilite var3) throws IOException {
      String var4 = "";
      if (this.strEnteteGroupe == 2) {
         var4 = "_ENT";
      } else {
         var4 = "";
      }

      try {
         SAXBuilder var5 = new SAXBuilder();
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + var2 + var4 + "-" + var1 + ".xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + var2 + var4 + ".xml");
         }

         FileReader var7 = new FileReader(var6);
         Document var8 = var5.build(var7);
         Element var9 = var8.getRootElement();
         List var10 = var9.getChildren();
         ArrayList var11 = new ArrayList();

         for(int var12 = 0; var12 < var10.size(); ++var12) {
            ObjetLigneMenu var13 = new ObjetLigneMenu();
            var13.setIndice(var12);
            var13.setLibelle_FR(((Element)var10.get(var12)).getChild("libelle_FR").getText());
            var13.setLibelle_UK(((Element)var10.get(var12)).getChild("libelle_UK").getText());
            var13.setLibelle_SP(((Element)var10.get(var12)).getChild("libelle_SP").getText());
            var13.setCommande(((Element)var10.get(var12)).getChild("commande").getText());
            var13.setPagemenu(((Element)var10.get(var12)).getChild("pagemenu").getText());
            var13.setType(((Element)var10.get(var12)).getChild("type").getText());
            var13.setGenre(((Element)var10.get(var12)).getChild("genre").getText());
            var13.setAcc(Boolean.parseBoolean(((Element)var10.get(var12)).getChild("acc").getText()));
            var13.setAdd(Boolean.parseBoolean(((Element)var10.get(var12)).getChild("add").getText()));
            var13.setDup(Boolean.parseBoolean(((Element)var10.get(var12)).getChild("dup").getText()));
            var13.setMaj(Boolean.parseBoolean(((Element)var10.get(var12)).getChild("maj").getText()));
            var13.setSup(Boolean.parseBoolean(((Element)var10.get(var12)).getChild("sup").getText()));
            var13.setImp(Boolean.parseBoolean(((Element)var10.get(var12)).getChild("imp").getText()));
            var13.setClo(Boolean.parseBoolean(((Element)var10.get(var12)).getChild("clo").getText()));
            var13.setTrf(Boolean.parseBoolean(((Element)var10.get(var12)).getChild("trf").getText()));
            if (var13.isAcc()) {
               if (!var13.getCommande().equalsIgnoreCase("40000:15") && !var13.getCommande().equalsIgnoreCase("40000:18") && !var13.getCommande().equalsIgnoreCase("40000:91")) {
                  var11.add(var13);
               } else if (var3.getAnalytique().equalsIgnoreCase("true")) {
                  var11.add(var13);
               }
            }
         }

         this.dataModelMenudroitComptabiliteXmlList.setWrappedData(var11);
         var7.close();
      } catch (JDOMException var14) {
         var14.getMessage();
      } catch (IOException var15) {
         var15.getMessage();
      }

   }

   public DataModel getDataModelMenudroitComptabiliteXmlList() {
      return this.dataModelMenudroitComptabiliteXmlList;
   }

   public void setDataModelMenudroitComptabiliteXmlList(DataModel var1) {
      this.dataModelMenudroitComptabiliteXmlList = var1;
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
