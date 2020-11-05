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

public class MenudroitAchatsCtrl implements Serializable {
   private long strId;
   private int strEnteteGroupe = 0;
   private transient DataModel dataModelMenudroitAchatsXmlList = new ListDataModel();

   public void chargerMenudroitAchatsXml(String var1, String var2, boolean var3) {
      String var4 = "";
      if (this.strEnteteGroupe == 2) {
         var4 = "_ENT";
      } else {
         var4 = "";
      }

      try {
         SAXBuilder var5 = new SAXBuilder();
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "60000" + var4 + "-" + var1 + ".xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "60000" + var4 + ".xml");
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
               if (!var13.getCommande().equals("60000:11") && !var13.getCommande().equals("60010:11") && !var13.getCommande().equals("60020:11")) {
                  if (!var13.getCommande().equals("60000:19") && !var13.getCommande().equals("60010:19") && !var13.getCommande().equals("60020:19")) {
                     var11.add(var13);
                  } else if (var3) {
                     var11.add(var13);
                  }
               } else if (var2.equals("1")) {
                  var11.add(var13);
               }
            }
         }

         this.dataModelMenudroitAchatsXmlList.setWrappedData(var11);
         var7.close();
      } catch (JDOMException var14) {
         var14.getMessage();
      } catch (IOException var15) {
         var15.getMessage();
      }

   }

   public void chargerMenudroitAchatsGroupeXml(String var1, String var2, boolean var3) {
      String var4 = "";
      if (this.strEnteteGroupe == 2) {
         var4 = "_ENT";
      } else {
         var4 = "";
      }

      try {
         SAXBuilder var5 = new SAXBuilder();
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "60001" + var4 + "-" + var1 + ".xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "60001" + var4 + ".xml");
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
               if (!var13.getCommande().equals("60000:11") && !var13.getCommande().equals("60010:11") && !var13.getCommande().equals("60020:11")) {
                  if (!var13.getCommande().equals("60000:19") && !var13.getCommande().equals("60010:19") && !var13.getCommande().equals("60020:19")) {
                     var11.add(var13);
                  } else if (var3) {
                     var11.add(var13);
                  }
               } else if (var2.equals("1")) {
                  var11.add(var13);
               }
            }
         }

         this.dataModelMenudroitAchatsXmlList.setWrappedData(var11);
         var7.close();
      } catch (JDOMException var14) {
         var14.getMessage();
      } catch (IOException var15) {
         var15.getMessage();
      }

   }

   public void chargerMenudroitAchatsPapierXml(String var1, boolean var2) {
      String var3 = "";
      if (this.strEnteteGroupe == 2) {
         var3 = "_ENT";
      } else {
         var3 = "";
      }

      try {
         SAXBuilder var4 = new SAXBuilder();
         File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "60010" + var3 + "-" + var1 + ".xml");
         if (!var5.exists()) {
            var5 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "60010" + var3 + ".xml");
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
            if (var12.isAcc()) {
               if (!var12.getCommande().equals("60000:19") && !var12.getCommande().equals("60010:19") && !var12.getCommande().equals("60020:19")) {
                  var10.add(var12);
               } else if (var2) {
                  var10.add(var12);
               }
            }
         }

         this.dataModelMenudroitAchatsXmlList.setWrappedData(var10);
         var6.close();
      } catch (JDOMException var13) {
         var13.getMessage();
      } catch (IOException var14) {
         var14.getMessage();
      }

   }

   public void chargerMenudroitAchatsPouletXml(String var1, boolean var2) {
      String var3 = "";
      if (this.strEnteteGroupe == 2) {
         var3 = "_ENT";
      } else {
         var3 = "";
      }

      try {
         SAXBuilder var4 = new SAXBuilder();
         File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "60020" + var3 + "-" + var1 + ".xml");
         if (!var5.exists()) {
            var5 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "60020" + var3 + ".xml");
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
            if (var12.isAcc()) {
               if (!var12.getCommande().equals("60000:19") && !var12.getCommande().equals("60010:19") && !var12.getCommande().equals("60020:19")) {
                  var10.add(var12);
               } else if (var2) {
                  var10.add(var12);
               }
            }
         }

         this.dataModelMenudroitAchatsXmlList.setWrappedData(var10);
         var6.close();
      } catch (JDOMException var13) {
         var13.getMessage();
      } catch (IOException var14) {
         var14.getMessage();
      }

   }

   public DataModel getDataModelMenudroitAchatsXmlList() {
      return this.dataModelMenudroitAchatsXmlList;
   }

   public void setDataModelMenudroitAchatsXmlList(DataModel var1) {
      this.dataModelMenudroitAchatsXmlList = var1;
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
