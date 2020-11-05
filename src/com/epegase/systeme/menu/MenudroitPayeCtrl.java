package com.epegase.systeme.menu;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionPaye;
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

public class MenudroitPayeCtrl implements Serializable {
   private long strId;
   private int strEnteteGroupe = 0;
   private transient DataModel dataModelMenudroitPayeXmlList = new ListDataModel();

   public void chargerMenuGauchePayeXml(String var1, Structure var2, OptionPaye var3) {
      String var4 = "";
      if (this.strEnteteGroupe == 2) {
         var4 = "_ENT";
      } else {
         var4 = "";
      }

      try {
         SAXBuilder var5 = new SAXBuilder();
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "50000" + var4 + "-" + var1 + ".xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "50000" + var4 + ".xml");
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
               if (var13.getCommande().equals("50000:03")) {
                  if (var2.getStrid() == 14L) {
                     var11.add(var13);
                  }
               } else if (var13.getCommande().equals("50000:17")) {
                  if (var3.getRubQuinzaine() != null && !var3.getRubQuinzaine().isEmpty()) {
                     var11.add(var13);
                  }
               } else {
                  var11.add(var13);
               }
            }
         }

         this.dataModelMenudroitPayeXmlList.setWrappedData(var11);
         var7.close();
      } catch (JDOMException var14) {
         var14.getMessage();
      } catch (IOException var15) {
         var15.getMessage();
      }

   }

   public void chargerMenuGauchePayeRosterXml(String var1, Structure var2, OptionPaye var3) {
      String var4 = "";
      if (this.strEnteteGroupe == 2) {
         var4 = "_ENT";
      } else {
         var4 = "";
      }

      SAXBuilder var5 = new SAXBuilder();

      try {
         Document var6 = null;
         File var7 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "50300" + var4 + "-" + var1 + ".xml");
         if (var7.exists()) {
            var6 = var5.build(var7);
         } else {
            var6 = var5.build(new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "50300" + var4 + ".xml"));
         }

         Element var8 = var6.getRootElement();
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
               if (var12.getCommande().equals("50000:17")) {
                  if (var3.getRubQuinzaine() != null && !var3.getRubQuinzaine().isEmpty()) {
                     var10.add(var12);
                  }
               } else {
                  var10.add(var12);
               }
            }
         }

         this.dataModelMenudroitPayeXmlList.setWrappedData(var10);
      } catch (JDOMException var13) {
         var13.getMessage();
      } catch (IOException var14) {
         var14.getMessage();
      }

   }

   public void chargerMenuGauchePayeTempsXml(String var1, Structure var2, OptionPaye var3) {
      String var4 = "";
      if (this.strEnteteGroupe == 2) {
         var4 = "_ENT";
      } else {
         var4 = "";
      }

      try {
         SAXBuilder var5 = new SAXBuilder();
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "50200" + var4 + "-" + var1 + ".xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "50200" + var4 + ".xml");
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
               if (var13.getCommande().equals("50000:03")) {
                  if (var2.getStrid() == 14L) {
                     var11.add(var13);
                  }
               } else if (var13.getCommande().equals("50000:17")) {
                  if (var3.getRubQuinzaine() != null && !var3.getRubQuinzaine().isEmpty()) {
                     var11.add(var13);
                  }
               } else {
                  var11.add(var13);
               }
            }
         }

         this.dataModelMenudroitPayeXmlList.setWrappedData(var11);
         var7.close();
      } catch (JDOMException var14) {
         var14.getMessage();
      } catch (IOException var15) {
         var15.getMessage();
      }

   }

   public void chargerMenuGauchePayeGuestXml(Structure var1) {
      String var2 = "";
      if (this.strEnteteGroupe == 2) {
         var2 = "_ENT";
      } else {
         var2 = "";
      }

      try {
         SAXBuilder var3 = new SAXBuilder();
         File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "50100.xml");
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
               if (var11.getCommande().equals("50000:03")) {
                  if (var1.getStrid() == 14L) {
                     var9.add(var11);
                  }
               } else {
                  var9.add(var11);
               }
            }
         }

         this.dataModelMenudroitPayeXmlList.setWrappedData(var9);
         var5.close();
      } catch (JDOMException var12) {
         var12.getMessage();
      } catch (IOException var13) {
         var13.getMessage();
      }

   }

   public DataModel getDataModelMenudroitPayeXmlList() {
      return this.dataModelMenudroitPayeXmlList;
   }

   public void setDataModelMenudroitPayeXmlList(DataModel var1) {
      this.dataModelMenudroitPayeXmlList = var1;
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
