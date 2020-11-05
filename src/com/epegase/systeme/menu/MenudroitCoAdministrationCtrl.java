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

public class MenudroitCoAdministrationCtrl implements Serializable {
   private String baseLog;
   private Structure structureLog;
   private transient DataModel dataModelMenudroitCoAdministrationXmlList = new ListDataModel();
   private List listLigneMenusGlobal;
   private List listLigneMenusUser;

   public void chargerMenuCoAdministrationGlobalXml(boolean var1) throws IOException {
      try {
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "00101.xml");
         if (var2.exists()) {
            SAXBuilder var3 = new SAXBuilder();
            FileReader var4 = new FileReader(var2);
            Document var5 = var3.build(var4);
            Element var6 = var5.getRootElement();
            List var7 = var6.getChildren();
            this.listLigneMenusGlobal = new ArrayList();

            for(int var8 = 0; var8 < var7.size(); ++var8) {
               ObjetLigneMenu var9 = new ObjetLigneMenu();
               var9.setIndice(var8);
               var9.setLibelle_FR(((Element)var7.get(var8)).getChild("libelle_FR").getText());
               var9.setLibelle_UK(((Element)var7.get(var8)).getChild("libelle_UK").getText());
               var9.setLibelle_SP(((Element)var7.get(var8)).getChild("libelle_SP").getText());
               var9.setCommande(((Element)var7.get(var8)).getChild("commande").getText());
               var9.setPagemenu(((Element)var7.get(var8)).getChild("pagemenu").getText());
               var9.setType(((Element)var7.get(var8)).getChild("type").getText());
               var9.setGenre(((Element)var7.get(var8)).getChild("genre").getText());
               var9.setAcc(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("acc").getText()));
               var9.setAdd(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("add").getText()));
               var9.setDup(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("dup").getText()));
               var9.setMaj(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("maj").getText()));
               var9.setSup(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("sup").getText()));
               var9.setImp(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("imp").getText()));
               var9.setClo(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("clo").getText()));
               var9.setTrf(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("trf").getText()));
               if (var9.isAcc()) {
                  if (!var9.getCommande().equalsIgnoreCase("00100:04") && !var9.getCommande().equalsIgnoreCase("00101:04")) {
                     if (!var9.getCommande().equalsIgnoreCase("00100:16") && !var9.getCommande().equalsIgnoreCase("00101:16")) {
                        if (!var9.getCommande().equalsIgnoreCase("00100:180") && !var9.getCommande().equalsIgnoreCase("00101:180") && !var9.getCommande().equalsIgnoreCase("00100:181") && !var9.getCommande().equalsIgnoreCase("00101:181")) {
                           if (!var9.getCommande().equalsIgnoreCase("00100:19") && !var9.getCommande().equalsIgnoreCase("00101:19")) {
                              if (StaticModePegase.getInternet_actif() >= 1 && (var9.getCommande().equals("00100:13") || var9.getCommande().equals("00101:13"))) {
                                 this.listLigneMenusGlobal.add(var9);
                              } else if (StaticModePegase.getInternet_actif() != 0 || !var9.getCommande().equals("00100:13") && !var9.getCommande().equals("00101:13")) {
                                 this.listLigneMenusGlobal.add(var9);
                              }
                           } else if (this.structureLog.getStrtypeentreprise() != null && this.structureLog.getStrmaitrecabinet() != 0) {
                              this.listLigneMenusGlobal.add(var9);
                           }
                        } else if (this.structureLog.getStrid() == 1L) {
                           this.listLigneMenusGlobal.add(var9);
                        }
                     } else if (var1) {
                        this.listLigneMenusGlobal.add(var9);
                     }
                  } else if (this.structureLog.getStrtypeentreprise() != null && this.structureLog.getStrtypeentreprise().equalsIgnoreCase("2")) {
                     this.listLigneMenusGlobal.add(var9);
                  }
               }
            }

            var4.close();
         }
      } catch (JDOMException var10) {
         var10.getMessage();
      } catch (IOException var11) {
         var11.getMessage();
      }

   }

   public void chargerMenuCoAdministrationXml(long var1, boolean var3) throws IOException {
      try {
         File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "menu_defaut" + File.separator + "00101-" + var1 + ".xml");
         if (var4.exists()) {
            SAXBuilder var5 = new SAXBuilder();
            FileReader var6 = new FileReader(var4);
            Document var7 = var5.build(var6);
            Element var8 = var7.getRootElement();
            List var9 = var8.getChildren();
            this.listLigneMenusUser = new ArrayList();

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
                  if (var11.getCommande().equalsIgnoreCase("00101:04")) {
                     if (this.structureLog.getStrtypeentreprise() != null && this.structureLog.getStrtypeentreprise().equalsIgnoreCase("2")) {
                        this.listLigneMenusUser.add(var11);
                     }
                  } else if (var11.getCommande().equalsIgnoreCase("00101:16")) {
                     if (var3) {
                        this.listLigneMenusUser.add(var11);
                     }
                  } else if (StaticModePegase.getInternet_actif() >= 1 && var11.getCommande().equals("00101:13")) {
                     this.listLigneMenusUser.add(var11);
                  } else if (StaticModePegase.getInternet_actif() != 0 || !var11.getCommande().equals("00101:13")) {
                     this.listLigneMenusUser.add(var11);
                  }
               }
            }

            this.dataModelMenudroitCoAdministrationXmlList.setWrappedData(this.listLigneMenusUser);
            var6.close();
         }
      } catch (JDOMException var12) {
         var12.getMessage();
      } catch (IOException var13) {
         var13.getMessage();
      }

   }

   public DataModel getDataModelMenudroitCoAdministrationXmlList() {
      return this.dataModelMenudroitCoAdministrationXmlList;
   }

   public void setDataModelMenudroitCoAdministrationXmlList(DataModel var1) {
      this.dataModelMenudroitCoAdministrationXmlList = var1;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }

   public List getListLigneMenusGlobal() {
      return this.listLigneMenusGlobal;
   }

   public void setListLigneMenusGlobal(List var1) {
      this.listLigneMenusGlobal = var1;
   }

   public List getListLigneMenusUser() {
      return this.listLigneMenusUser;
   }

   public void setListLigneMenusUser(List var1) {
      this.listLigneMenusUser = var1;
   }
}
