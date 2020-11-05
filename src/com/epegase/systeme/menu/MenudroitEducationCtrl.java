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

public class MenudroitEducationCtrl implements Serializable {
   private long strId;
   private int strEnteteGroupe = 0;
   private transient DataModel dataModelMenudroitEducationXmlList = new ListDataModel();

   public void chargerMenudroitEducationXml(String var1) {
      String var2 = "";
      if (this.strEnteteGroupe == 2) {
         var2 = "_ENT";
      } else {
         var2 = "";
      }

      new ArrayList();

      try {
         SAXBuilder var4 = new SAXBuilder();
         File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "80900" + var2 + "-" + var1 + ".xml");
         if (!var5.exists()) {
            var5 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "80900" + var2 + ".xml");
         }

         FileReader var6 = new FileReader(var5);
         Document var7 = var4.build(var6);
         Element var8 = var7.getRootElement();
         List var9 = var8.getChildren();
         ArrayList var3 = new ArrayList();

         for(int var10 = 0; var10 < var9.size(); ++var10) {
            ObjetLigneMenu var11 = new ObjetLigneMenu();
            var11.setIndice(var10);
            var11.setLibelle_FR(((Element)var9.get(var10)).getChild("libelle_FR").getText());
            var11.setLibelle_UK(((Element)var9.get(var10)).getChild("libelle_UK").getText());
            var11.setLibelle_SP(((Element)var9.get(var10)).getChild("libelle_SP").getText());
            var11.setCommande(((Element)var9.get(var10)).getChild("commande").getText());
            var11.setPagemenu(((Element)var9.get(var10)).getChild("pagemenu").getText());
            var11.setType(((Element)var9.get(var10)).getChild("type").getText());
            var11.setGenre(((Element)var9.get(var10)).getChild("genre").getText());
            var11.setAcc(Boolean.parseBoolean(((Element)var9.get(var10)).getChild("acc").getText()));
            var11.setAdd(Boolean.parseBoolean(((Element)var9.get(var10)).getChild("add").getText()));
            var11.setDup(Boolean.parseBoolean(((Element)var9.get(var10)).getChild("dup").getText()));
            var11.setMaj(Boolean.parseBoolean(((Element)var9.get(var10)).getChild("maj").getText()));
            var11.setSup(Boolean.parseBoolean(((Element)var9.get(var10)).getChild("sup").getText()));
            var11.setImp(Boolean.parseBoolean(((Element)var9.get(var10)).getChild("imp").getText()));
            var11.setClo(Boolean.parseBoolean(((Element)var9.get(var10)).getChild("clo").getText()));
            var11.setTrf(Boolean.parseBoolean(((Element)var9.get(var10)).getChild("trf").getText()));
            if (var11.isAcc()) {
               var3.add(var11);
            }
         }

         this.dataModelMenudroitEducationXmlList.setWrappedData(var3);
         var6.close();
      } catch (JDOMException var12) {
         var12.getMessage();
      } catch (IOException var13) {
         var13.getMessage();
      }

   }

   public DataModel getDataModelMenudroitEducationXmlList() {
      return this.dataModelMenudroitEducationXmlList;
   }

   public void setDataModelMenudroitEducationXmlList(DataModel var1) {
      this.dataModelMenudroitEducationXmlList = var1;
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
