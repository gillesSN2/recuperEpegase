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

public class MenudroitAdministrationCtrl implements Serializable {
   private long strId;
   private Structure structureLog;
   private transient DataModel dataModelMenudroitAdministrationXmlList = new ListDataModel();

   public void chargerMenuAdministrationXml(String var1, boolean var2) throws IOException {
      try {
         SAXBuilder var3 = new SAXBuilder();
         File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "00100-" + var1 + ".xml");
         if (!var4.exists()) {
            var4 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "00100.xml");
         }

         FileReader var5 = new FileReader(var4);
         Document var6 = var3.build(var5);
         Element var7 = var6.getRootElement();
         List var8 = var7.getChildren();
         ArrayList var9 = new ArrayList();

         for(int var10 = 0; var10 < var8.size(); ++var10) {
            ObjetLigneMenu var11 = new ObjetLigneMenu();
            var11.setIndice(var10);
            var11.setLibelle_FR(((Element)var8.get(var10)).getChild("libelle_FR").getText());
            var11.setLibelle_UK(((Element)var8.get(var10)).getChild("libelle_UK").getText());
            var11.setLibelle_SP(((Element)var8.get(var10)).getChild("libelle_SP").getText());
            var11.setCommande(((Element)var8.get(var10)).getChild("commande").getText());
            var11.setPagemenu(((Element)var8.get(var10)).getChild("pagemenu").getText());
            var11.setType(((Element)var8.get(var10)).getChild("type").getText());
            var11.setGenre(((Element)var8.get(var10)).getChild("genre").getText());
            var11.setAcc(Boolean.parseBoolean(((Element)var8.get(var10)).getChild("acc").getText()));
            var11.setAdd(Boolean.parseBoolean(((Element)var8.get(var10)).getChild("add").getText()));
            var11.setDup(Boolean.parseBoolean(((Element)var8.get(var10)).getChild("dup").getText()));
            var11.setMaj(Boolean.parseBoolean(((Element)var8.get(var10)).getChild("maj").getText()));
            var11.setSup(Boolean.parseBoolean(((Element)var8.get(var10)).getChild("sup").getText()));
            var11.setImp(Boolean.parseBoolean(((Element)var8.get(var10)).getChild("imp").getText()));
            var11.setClo(Boolean.parseBoolean(((Element)var8.get(var10)).getChild("clo").getText()));
            var11.setTrf(Boolean.parseBoolean(((Element)var8.get(var10)).getChild("trf").getText()));
            if (var11.isAcc()) {
               if (!var11.getCommande().equalsIgnoreCase("00100:04") && !var11.getCommande().equalsIgnoreCase("00101:04")) {
                  if (!var11.getCommande().equalsIgnoreCase("00100:16") && !var11.getCommande().equalsIgnoreCase("00101:16")) {
                     if (!var11.getCommande().equalsIgnoreCase("00100:180") && !var11.getCommande().equalsIgnoreCase("00101:180") && !var11.getCommande().equalsIgnoreCase("00100:181") && !var11.getCommande().equalsIgnoreCase("00101:181")) {
                        if (!var11.getCommande().equalsIgnoreCase("00100:19") && !var11.getCommande().equalsIgnoreCase("00101:19")) {
                           if (StaticModePegase.getInternet_actif() >= 1 && (var11.getCommande().equals("00100:13") || var11.getCommande().equals("00101:13"))) {
                              var9.add(var11);
                           } else if (StaticModePegase.getInternet_actif() != 0 || !var11.getCommande().equals("00100:13") && !var11.getCommande().equals("00101:13")) {
                              var9.add(var11);
                           }
                        } else if (this.structureLog.getStrtypeentreprise() != null && this.structureLog.getStrmaitrecabinet() >= 1 && this.structureLog.getStrmaitrecabinet() <= 9) {
                           var9.add(var11);
                        }
                     } else if (this.structureLog.getStrid() == 1L) {
                        var9.add(var11);
                     }
                  } else if (var2) {
                     var9.add(var11);
                  }
               } else if (this.structureLog.getStrtypeentreprise() != null && this.structureLog.getStrtypeentreprise().equalsIgnoreCase("2")) {
                  var9.add(var11);
               }
            }
         }

         this.dataModelMenudroitAdministrationXmlList.setWrappedData(var9);
         var5.close();
      } catch (JDOMException var12) {
         var12.getMessage();
      } catch (IOException var13) {
         var13.getMessage();
      }

   }

   public DataModel getDataModelMenudroitAdministrationXmlList() {
      return this.dataModelMenudroitAdministrationXmlList;
   }

   public void setDataModelMenudroitAdministrationXmlList(DataModel var1) {
      this.dataModelMenudroitAdministrationXmlList = var1;
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
