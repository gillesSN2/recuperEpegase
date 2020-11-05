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

public class MenudroitAccueilCtrl implements Serializable {
   private long strId;
   private transient DataModel dataModelMenudroitAccueilXmlList = new ListDataModel();

   public void chargerMenuAccueilXml(String var1, long var2) throws IOException {
      try {
         SAXBuilder var4 = new SAXBuilder();
         File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + var2 + File.separator + "menu_defaut" + File.separator + "10000-" + var1 + ".xml");
         if (!var5.exists()) {
            var5 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "10000.xml");
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
            if (var2 != 1L && var12.getCommande().equals("10000:15")) {
               var12.setAcc(false);
            }

            if (var12.isAcc()) {
               if (StaticModePegase.getInternet_actif() < 1 || !var12.getCommande().equals("10000:02") && !var12.getCommande().equals("10000:03") && !var12.getCommande().equals("10000:06") && !var12.getCommande().equals("10000:07") && !var12.getCommande().equals("10000:08") && !var12.getCommande().equals("10000:09") && !var12.getCommande().equals("10000:10") && !var12.getCommande().equals("10000:11") && !var12.getCommande().equals("10000:12") && !var12.getCommande().equals("10000:13") && !var12.getCommande().equals("10000:14") && !var12.getCommande().equals("10000:15") && !var12.getCommande().equals("10000:16")) {
                  if (StaticModePegase.getInternet_actif() != 0 || !var12.getCommande().equals("10000:02") && !var12.getCommande().equals("10000:03") && !var12.getCommande().equals("10000:06") && !var12.getCommande().equals("10000:07") && !var12.getCommande().equals("10000:08") && !var12.getCommande().equals("10000:09") && !var12.getCommande().equals("10000:10") && !var12.getCommande().equals("10000:11") && !var12.getCommande().equals("10000:12") && !var12.getCommande().equals("10000:13") && !var12.getCommande().equals("10000:14") && !var12.getCommande().equals("10000:15") && !var12.getCommande().equals("10000:16")) {
                     var10.add(var12);
                  }
               } else if (var2 == 1L && var12.getCommande().equals("10000:16")) {
                  var10.add(var12);
               } else if (var2 == 1L || !var12.getCommande().equals("10000:16")) {
                  var10.add(var12);
               }
            }
         }

         this.dataModelMenudroitAccueilXmlList.setWrappedData(var10);
         var6.close();
      } catch (JDOMException var13) {
         var13.getMessage();
      } catch (IOException var14) {
         var14.getMessage();
      }

   }

   public DataModel getDataModelMenudroitAccueilXmlList() {
      return this.dataModelMenudroitAccueilXmlList;
   }

   public void setDataModelMenudroitAccueilXmlList(DataModel var1) {
      this.dataModelMenudroitAccueilXmlList = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }
}
