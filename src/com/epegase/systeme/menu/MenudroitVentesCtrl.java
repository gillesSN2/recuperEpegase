package com.epegase.systeme.menu;

import com.epegase.systeme.classe.Groupe;
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

public class MenudroitVentesCtrl implements Serializable {
   private long strId;
   private int strEnteteGroupe = 0;
   private transient DataModel dataModelMenudroitVentesXmlList = new ListDataModel();

   public void chargerMenudroitVentesXml(Groupe var1, long var2, int var4, Users var5, boolean var6, boolean var7) {
      String var8 = "";
      if (this.strEnteteGroupe == 2) {
         var8 = "_ENT";
      } else {
         var8 = "";
      }

      try {
         SAXBuilder var9 = new SAXBuilder();
         File var10 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "80100" + var8 + "-" + var1.getGrpCode() + ".xml");
         if (!var10.exists()) {
            var10 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "80100" + var8 + ".xml");
         }

         FileReader var11 = new FileReader(var10);
         Document var12 = var9.build(var11);
         Element var13 = var12.getRootElement();
         List var14 = var13.getChildren();
         ArrayList var15 = new ArrayList();

         for(int var16 = 0; var16 < var14.size(); ++var16) {
            ObjetLigneMenu var17 = new ObjetLigneMenu();
            var17.setIndice(var16);
            var17.setLibelle_FR(((Element)var14.get(var16)).getChild("libelle_FR").getText());
            var17.setLibelle_UK(((Element)var14.get(var16)).getChild("libelle_UK").getText());
            var17.setLibelle_SP(((Element)var14.get(var16)).getChild("libelle_SP").getText());
            var17.setCommande(((Element)var14.get(var16)).getChild("commande").getText());
            var17.setPagemenu(((Element)var14.get(var16)).getChild("pagemenu").getText());
            var17.setType(((Element)var14.get(var16)).getChild("type").getText());
            var17.setGenre(((Element)var14.get(var16)).getChild("genre").getText());
            var17.setAcc(Boolean.parseBoolean(((Element)var14.get(var16)).getChild("acc").getText()));
            var17.setAdd(Boolean.parseBoolean(((Element)var14.get(var16)).getChild("add").getText()));
            var17.setDup(Boolean.parseBoolean(((Element)var14.get(var16)).getChild("dup").getText()));
            var17.setMaj(Boolean.parseBoolean(((Element)var14.get(var16)).getChild("maj").getText()));
            var17.setSup(Boolean.parseBoolean(((Element)var14.get(var16)).getChild("sup").getText()));
            var17.setImp(Boolean.parseBoolean(((Element)var14.get(var16)).getChild("imp").getText()));
            var17.setClo(Boolean.parseBoolean(((Element)var14.get(var16)).getChild("clo").getText()));
            var17.setTrf(Boolean.parseBoolean(((Element)var14.get(var16)).getChild("trf").getText()));
            if (var17.isAcc()) {
               if (var1.getGrpModuleVte() == 2) {
                  if (var17.getCommande().equals("80100:00")) {
                     var15.add(var17);
                  } else if (var17.getCommande().equals("80100:04")) {
                     var15.add(var17);
                  }
               } else if (var2 == 20L) {
                  if (var17.getCommande().equals("80100:16")) {
                     if (var5.getUsrJrxReserve() == 0 && var5.getUsrLissage() == 1) {
                        var15.add(var17);
                     }
                  } else if (var17.getCommande().equals("80100:08")) {
                     if (!var7) {
                        var15.add(var17);
                     }
                  } else {
                     var15.add(var17);
                  }
               } else if (!var17.getCommande().equals("80100:12")) {
                  if (var17.getCommande().equals("80100:16")) {
                     if (var5.getUsrJrxReserve() == 0 && var5.getUsrLissage() == 1) {
                        var15.add(var17);
                     }
                  } else if (var17.getCommande().equals("80100:19")) {
                     if (var6) {
                        var15.add(var17);
                     }
                  } else if (var17.getCommande().equals("80100:20")) {
                     if (var4 == 2 || var4 == 12) {
                        var15.add(var17);
                     }
                  } else if (var17.getCommande().equals("80100:08")) {
                     if (!var7) {
                        var15.add(var17);
                     }
                  } else {
                     var15.add(var17);
                  }
               }
            }
         }

         this.dataModelMenudroitVentesXmlList.setWrappedData(var15);
         var11.close();
      } catch (JDOMException var18) {
         var18.getMessage();
      } catch (IOException var19) {
         var19.getMessage();
      }

   }

   public void chargerMenudroitVentesTicketXml(Groupe var1, long var2, int var4, Users var5, boolean var6) {
      String var7 = "";
      if (this.strEnteteGroupe == 2) {
         var7 = "_ENT";
      } else {
         var7 = "";
      }

      try {
         SAXBuilder var8 = new SAXBuilder();
         File var9 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "80200" + var7 + "-" + var1.getGrpCode() + ".xml");
         if (!var9.exists()) {
            var9 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "80200" + var7 + ".xml");
         }

         FileReader var10 = new FileReader(var9);
         Document var11 = var8.build(var10);
         Element var12 = var11.getRootElement();
         List var13 = var12.getChildren();
         ArrayList var14 = new ArrayList();

         for(int var15 = 0; var15 < var13.size(); ++var15) {
            ObjetLigneMenu var16 = new ObjetLigneMenu();
            var16.setIndice(var15);
            var16.setLibelle_FR(((Element)var13.get(var15)).getChild("libelle_FR").getText());
            var16.setLibelle_UK(((Element)var13.get(var15)).getChild("libelle_UK").getText());
            var16.setLibelle_SP(((Element)var13.get(var15)).getChild("libelle_SP").getText());
            var16.setCommande(((Element)var13.get(var15)).getChild("commande").getText());
            var16.setPagemenu(((Element)var13.get(var15)).getChild("pagemenu").getText());
            var16.setType(((Element)var13.get(var15)).getChild("type").getText());
            var16.setGenre(((Element)var13.get(var15)).getChild("genre").getText());
            var16.setAcc(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("acc").getText()));
            var16.setAdd(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("add").getText()));
            var16.setDup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("dup").getText()));
            var16.setMaj(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("maj").getText()));
            var16.setSup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("sup").getText()));
            var16.setImp(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("imp").getText()));
            var16.setClo(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("clo").getText()));
            var16.setTrf(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("trf").getText()));
            if (var16.isAcc()) {
               if (var1.getGrpModuleVte() == 2) {
                  if (var16.getCommande().equals("80100:00")) {
                     var14.add(var16);
                  } else if (var16.getCommande().equals("80100:04")) {
                     var14.add(var16);
                  }
               } else if (var2 == 20L) {
                  if (var16.getCommande().equals("80100:16")) {
                     if (var5.getUsrJrxReserve() == 0 && var5.getUsrLissage() == 1) {
                        var14.add(var16);
                     }
                  } else {
                     var14.add(var16);
                  }
               } else if (!var16.getCommande().equals("80100:12")) {
                  if (var16.getCommande().equals("80100:16")) {
                     if (var5.getUsrJrxReserve() == 0 && var5.getUsrLissage() == 1) {
                        var14.add(var16);
                     }
                  } else if (var16.getCommande().equals("80100:19")) {
                     if (var6) {
                        var14.add(var16);
                     }
                  } else if (var16.getCommande().equals("80100:20")) {
                     if (var4 == 2 || var4 == 12) {
                        var14.add(var16);
                     }
                  } else {
                     var14.add(var16);
                  }
               }
            }
         }

         this.dataModelMenudroitVentesXmlList.setWrappedData(var14);
         var10.close();
      } catch (JDOMException var17) {
         var17.getMessage();
      } catch (IOException var18) {
         var18.getMessage();
      }

   }

   public void chargerMenudroitVentesInterimXml(Groupe var1, long var2, int var4, Users var5, boolean var6) {
      String var7 = "";
      if (this.strEnteteGroupe == 2) {
         var7 = "_ENT";
      } else {
         var7 = "";
      }

      try {
         SAXBuilder var8 = new SAXBuilder();
         File var9 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "80400" + var7 + "-" + var1.getGrpCode() + ".xml");
         if (!var9.exists()) {
            var9 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "80400" + var7 + ".xml");
         }

         FileReader var10 = new FileReader(var9);
         Document var11 = var8.build(var10);
         Element var12 = var11.getRootElement();
         List var13 = var12.getChildren();
         ArrayList var14 = new ArrayList();

         for(int var15 = 0; var15 < var13.size(); ++var15) {
            ObjetLigneMenu var16 = new ObjetLigneMenu();
            var16.setIndice(var15);
            var16.setLibelle_FR(((Element)var13.get(var15)).getChild("libelle_FR").getText());
            var16.setLibelle_UK(((Element)var13.get(var15)).getChild("libelle_UK").getText());
            var16.setLibelle_SP(((Element)var13.get(var15)).getChild("libelle_SP").getText());
            var16.setCommande(((Element)var13.get(var15)).getChild("commande").getText());
            var16.setPagemenu(((Element)var13.get(var15)).getChild("pagemenu").getText());
            var16.setType(((Element)var13.get(var15)).getChild("type").getText());
            var16.setGenre(((Element)var13.get(var15)).getChild("genre").getText());
            var16.setAcc(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("acc").getText()));
            var16.setAdd(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("add").getText()));
            var16.setDup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("dup").getText()));
            var16.setMaj(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("maj").getText()));
            var16.setSup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("sup").getText()));
            var16.setImp(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("imp").getText()));
            var16.setClo(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("clo").getText()));
            var16.setTrf(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("trf").getText()));
            if (var16.isAcc()) {
               if (var1.getGrpModuleVte() == 2) {
                  if (var16.getCommande().equals("80100:00")) {
                     var14.add(var16);
                  } else if (var16.getCommande().equals("80100:04")) {
                     var14.add(var16);
                  }
               } else if (var2 == 20L) {
                  if (var16.getCommande().equals("80100:16")) {
                     if (var5.getUsrJrxReserve() == 0 && var5.getUsrLissage() == 1) {
                        var14.add(var16);
                     }
                  } else {
                     var14.add(var16);
                  }
               } else if (!var16.getCommande().equals("80100:12")) {
                  if (var16.getCommande().equals("80100:16")) {
                     if (var5.getUsrJrxReserve() == 0 && var5.getUsrLissage() == 1) {
                        var14.add(var16);
                     }
                  } else if (var16.getCommande().equals("80100:19")) {
                     if (var6) {
                        var14.add(var16);
                     }
                  } else if (var16.getCommande().equals("80100:20")) {
                     if (var4 == 2 || var4 == 12) {
                        var14.add(var16);
                     }
                  } else {
                     var14.add(var16);
                  }
               }
            }
         }

         this.dataModelMenudroitVentesXmlList.setWrappedData(var14);
         var10.close();
      } catch (JDOMException var17) {
         var17.getMessage();
      } catch (IOException var18) {
         var18.getMessage();
      }

   }

   public void chargerMenudroitVentesCabinetXml(Groupe var1, long var2, int var4, Users var5, boolean var6) {
      String var7 = "";
      if (this.strEnteteGroupe == 2) {
         var7 = "_ENT";
      } else {
         var7 = "";
      }

      try {
         SAXBuilder var8 = new SAXBuilder();
         File var9 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "80500" + var7 + "-" + var1.getGrpCode() + ".xml");
         if (!var9.exists()) {
            var9 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "80500" + var7 + ".xml");
         }

         FileReader var10 = new FileReader(var9);
         Document var11 = var8.build(var10);
         Element var12 = var11.getRootElement();
         List var13 = var12.getChildren();
         ArrayList var14 = new ArrayList();

         for(int var15 = 0; var15 < var13.size(); ++var15) {
            ObjetLigneMenu var16 = new ObjetLigneMenu();
            var16.setIndice(var15);
            var16.setLibelle_FR(((Element)var13.get(var15)).getChild("libelle_FR").getText());
            var16.setLibelle_UK(((Element)var13.get(var15)).getChild("libelle_UK").getText());
            var16.setLibelle_SP(((Element)var13.get(var15)).getChild("libelle_SP").getText());
            var16.setCommande(((Element)var13.get(var15)).getChild("commande").getText());
            var16.setPagemenu(((Element)var13.get(var15)).getChild("pagemenu").getText());
            var16.setType(((Element)var13.get(var15)).getChild("type").getText());
            var16.setGenre(((Element)var13.get(var15)).getChild("genre").getText());
            var16.setAcc(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("acc").getText()));
            var16.setAdd(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("add").getText()));
            var16.setDup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("dup").getText()));
            var16.setMaj(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("maj").getText()));
            var16.setSup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("sup").getText()));
            var16.setImp(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("imp").getText()));
            var16.setClo(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("clo").getText()));
            var16.setTrf(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("trf").getText()));
            if (var16.isAcc()) {
               if (var1.getGrpModuleVte() == 2) {
                  if (var16.getCommande().equals("80100:00")) {
                     var14.add(var16);
                  } else if (var16.getCommande().equals("80100:04")) {
                     var14.add(var16);
                  }
               } else if (var2 == 20L) {
                  if (var16.getCommande().equals("80100:16")) {
                     if (var5.getUsrJrxReserve() == 0 && var5.getUsrLissage() == 1) {
                        var14.add(var16);
                     }
                  } else {
                     var14.add(var16);
                  }
               } else if (!var16.getCommande().equals("80100:12")) {
                  if (var16.getCommande().equals("80100:16")) {
                     if (var5.getUsrJrxReserve() == 0 && var5.getUsrLissage() == 1) {
                        var14.add(var16);
                     }
                  } else if (var16.getCommande().equals("80100:19")) {
                     if (var6) {
                        var14.add(var16);
                     }
                  } else if (var16.getCommande().equals("80100:20")) {
                     if (var4 == 2 || var4 == 12) {
                        var14.add(var16);
                     }
                  } else {
                     var14.add(var16);
                  }
               }
            }
         }

         this.dataModelMenudroitVentesXmlList.setWrappedData(var14);
         var10.close();
      } catch (JDOMException var17) {
         var17.getMessage();
      } catch (IOException var18) {
         var18.getMessage();
      }

   }

   public void chargerMenudroitTransitXml(Groupe var1, long var2, int var4, Users var5, boolean var6) {
      String var7 = "";
      if (this.strEnteteGroupe == 2) {
         var7 = "_ENT";
      } else {
         var7 = "";
      }

      try {
         SAXBuilder var8 = new SAXBuilder();
         File var9 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "80600" + var7 + "-" + var1.getGrpCode() + ".xml");
         if (!var9.exists()) {
            var9 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "80600" + var7 + ".xml");
         }

         FileReader var10 = new FileReader(var9);
         Document var11 = var8.build(var10);
         Element var12 = var11.getRootElement();
         List var13 = var12.getChildren();
         ArrayList var14 = new ArrayList();

         for(int var15 = 0; var15 < var13.size(); ++var15) {
            ObjetLigneMenu var16 = new ObjetLigneMenu();
            var16.setIndice(var15);
            var16.setLibelle_FR(((Element)var13.get(var15)).getChild("libelle_FR").getText());
            var16.setLibelle_UK(((Element)var13.get(var15)).getChild("libelle_UK").getText());
            var16.setLibelle_SP(((Element)var13.get(var15)).getChild("libelle_SP").getText());
            var16.setCommande(((Element)var13.get(var15)).getChild("commande").getText());
            var16.setPagemenu(((Element)var13.get(var15)).getChild("pagemenu").getText());
            var16.setType(((Element)var13.get(var15)).getChild("type").getText());
            var16.setGenre(((Element)var13.get(var15)).getChild("genre").getText());
            var16.setAcc(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("acc").getText()));
            var16.setAdd(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("add").getText()));
            var16.setDup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("dup").getText()));
            var16.setMaj(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("maj").getText()));
            var16.setSup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("sup").getText()));
            var16.setImp(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("imp").getText()));
            var16.setClo(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("clo").getText()));
            var16.setTrf(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("trf").getText()));
            if (var16.isAcc()) {
               if (var1.getGrpModuleVte() == 2) {
                  if (var16.getCommande().equals("80100:00")) {
                     var14.add(var16);
                  } else if (var16.getCommande().equals("80100:04")) {
                     var14.add(var16);
                  }
               } else if (var2 == 20L) {
                  if (var16.getCommande().equals("80100:16")) {
                     if (var5.getUsrJrxReserve() == 0 && var5.getUsrLissage() == 1) {
                        var14.add(var16);
                     }
                  } else {
                     var14.add(var16);
                  }
               } else if (!var16.getCommande().equals("80100:12")) {
                  if (var16.getCommande().equals("80100:16")) {
                     if (var5.getUsrJrxReserve() == 0 && var5.getUsrLissage() == 1) {
                        var14.add(var16);
                     }
                  } else if (var16.getCommande().equals("80100:19")) {
                     if (var6) {
                        var14.add(var16);
                     }
                  } else if (var16.getCommande().equals("80100:20")) {
                     if (var4 == 2 || var4 == 12) {
                        var14.add(var16);
                     }
                  } else {
                     var14.add(var16);
                  }
               }
            }
         }

         this.dataModelMenudroitVentesXmlList.setWrappedData(var14);
         var10.close();
      } catch (JDOMException var17) {
         var17.getMessage();
      } catch (IOException var18) {
         var18.getMessage();
      }

   }

   public void chargerMenudroitRestaurantXml(Groupe var1, long var2, int var4, Users var5, boolean var6) {
      String var7 = "";
      if (this.strEnteteGroupe == 2) {
         var7 = "_ENT";
      } else {
         var7 = "";
      }

      try {
         SAXBuilder var8 = new SAXBuilder();
         File var9 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "81700" + var7 + "-" + var1.getGrpCode() + ".xml");
         if (!var9.exists()) {
            var9 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "81700" + var7 + ".xml");
         }

         FileReader var10 = new FileReader(var9);
         Document var11 = var8.build(var10);
         Element var12 = var11.getRootElement();
         List var13 = var12.getChildren();
         ArrayList var14 = new ArrayList();

         for(int var15 = 0; var15 < var13.size(); ++var15) {
            ObjetLigneMenu var16 = new ObjetLigneMenu();
            var16.setIndice(var15);
            var16.setLibelle_FR(((Element)var13.get(var15)).getChild("libelle_FR").getText());
            var16.setLibelle_UK(((Element)var13.get(var15)).getChild("libelle_UK").getText());
            var16.setLibelle_SP(((Element)var13.get(var15)).getChild("libelle_SP").getText());
            var16.setCommande(((Element)var13.get(var15)).getChild("commande").getText());
            var16.setPagemenu(((Element)var13.get(var15)).getChild("pagemenu").getText());
            var16.setType(((Element)var13.get(var15)).getChild("type").getText());
            var16.setGenre(((Element)var13.get(var15)).getChild("genre").getText());
            var16.setAcc(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("acc").getText()));
            var16.setAdd(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("add").getText()));
            var16.setDup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("dup").getText()));
            var16.setMaj(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("maj").getText()));
            var16.setSup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("sup").getText()));
            var16.setImp(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("imp").getText()));
            var16.setClo(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("clo").getText()));
            var16.setTrf(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("trf").getText()));
            if (var16.isAcc()) {
               if (var1.getGrpModuleVte() == 2) {
                  if (var16.getCommande().equals("80100:00")) {
                     var14.add(var16);
                  } else if (var16.getCommande().equals("80100:04")) {
                     var14.add(var16);
                  }
               } else if (var2 == 20L) {
                  if (var16.getCommande().equals("80100:16")) {
                     if (var5.getUsrJrxReserve() == 0 && var5.getUsrLissage() == 1) {
                        var14.add(var16);
                     }
                  } else {
                     var14.add(var16);
                  }
               } else if (!var16.getCommande().equals("80100:12")) {
                  if (var16.getCommande().equals("80100:16")) {
                     if (var5.getUsrJrxReserve() == 0 && var5.getUsrLissage() == 1) {
                        var14.add(var16);
                     }
                  } else if (var16.getCommande().equals("80100:19")) {
                     if (var6) {
                        var14.add(var16);
                     }
                  } else if (var16.getCommande().equals("80100:20")) {
                     if (var4 == 2 || var4 == 12) {
                        var14.add(var16);
                     }
                  } else {
                     var14.add(var16);
                  }
               }
            }
         }

         this.dataModelMenudroitVentesXmlList.setWrappedData(var14);
         var10.close();
      } catch (JDOMException var17) {
         var17.getMessage();
      } catch (IOException var18) {
         var18.getMessage();
      }

   }

   public void chargerMenudroitHotelerieXml(Groupe var1, long var2, int var4, Users var5, boolean var6) {
      String var7 = "";
      if (this.strEnteteGroupe == 2) {
         var7 = "_ENT";
      } else {
         var7 = "";
      }

      try {
         SAXBuilder var8 = new SAXBuilder();
         File var9 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "87110" + var7 + "-" + var1.getGrpCode() + ".xml");
         if (!var9.exists()) {
            var9 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "87110" + var7 + ".xml");
         }

         FileReader var10 = new FileReader(var9);
         Document var11 = var8.build(var10);
         Element var12 = var11.getRootElement();
         List var13 = var12.getChildren();
         ArrayList var14 = new ArrayList();

         for(int var15 = 0; var15 < var13.size(); ++var15) {
            ObjetLigneMenu var16 = new ObjetLigneMenu();
            var16.setIndice(var15);
            var16.setLibelle_FR(((Element)var13.get(var15)).getChild("libelle_FR").getText());
            var16.setLibelle_UK(((Element)var13.get(var15)).getChild("libelle_UK").getText());
            var16.setLibelle_SP(((Element)var13.get(var15)).getChild("libelle_SP").getText());
            var16.setCommande(((Element)var13.get(var15)).getChild("commande").getText());
            var16.setPagemenu(((Element)var13.get(var15)).getChild("pagemenu").getText());
            var16.setType(((Element)var13.get(var15)).getChild("type").getText());
            var16.setGenre(((Element)var13.get(var15)).getChild("genre").getText());
            var16.setAcc(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("acc").getText()));
            var16.setAdd(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("add").getText()));
            var16.setDup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("dup").getText()));
            var16.setMaj(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("maj").getText()));
            var16.setSup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("sup").getText()));
            var16.setImp(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("imp").getText()));
            var16.setClo(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("clo").getText()));
            var16.setTrf(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("trf").getText()));
            if (var16.isAcc()) {
               if (var1.getGrpModuleVte() == 2) {
                  if (var16.getCommande().equals("80100:00")) {
                     var14.add(var16);
                  } else if (var16.getCommande().equals("80100:04")) {
                     var14.add(var16);
                  }
               } else if (var2 == 20L) {
                  if (var16.getCommande().equals("80100:16")) {
                     if (var5.getUsrJrxReserve() == 0 && var5.getUsrLissage() == 1) {
                        var14.add(var16);
                     }
                  } else {
                     var14.add(var16);
                  }
               } else if (!var16.getCommande().equals("80100:12")) {
                  if (var16.getCommande().equals("80100:16")) {
                     if (var5.getUsrJrxReserve() == 0 && var5.getUsrLissage() == 1) {
                        var14.add(var16);
                     }
                  } else if (var16.getCommande().equals("80100:19")) {
                     if (var6) {
                        var14.add(var16);
                     }
                  } else if (var16.getCommande().equals("80100:20")) {
                     if (var4 == 2 || var4 == 12) {
                        var14.add(var16);
                     }
                  } else {
                     var14.add(var16);
                  }
               }
            }
         }

         this.dataModelMenudroitVentesXmlList.setWrappedData(var14);
         var10.close();
      } catch (JDOMException var17) {
         var17.getMessage();
      } catch (IOException var18) {
         var18.getMessage();
      }

   }

   public void chargerMenudroitFondationXml(Groupe var1, long var2, int var4, Users var5, boolean var6) {
      String var7 = "";
      if (this.strEnteteGroupe == 2) {
         var7 = "_ENT";
      } else {
         var7 = "";
      }

      try {
         SAXBuilder var8 = new SAXBuilder();
         File var9 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "80300" + var7 + "-" + var1.getGrpCode() + ".xml");
         if (!var9.exists()) {
            var9 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "80300" + var7 + ".xml");
         }

         FileReader var10 = new FileReader(var9);
         Document var11 = var8.build(var10);
         Element var12 = var11.getRootElement();
         List var13 = var12.getChildren();
         ArrayList var14 = new ArrayList();

         for(int var15 = 0; var15 < var13.size(); ++var15) {
            ObjetLigneMenu var16 = new ObjetLigneMenu();
            var16.setIndice(var15);
            var16.setLibelle_FR(((Element)var13.get(var15)).getChild("libelle_FR").getText());
            var16.setLibelle_UK(((Element)var13.get(var15)).getChild("libelle_UK").getText());
            var16.setLibelle_SP(((Element)var13.get(var15)).getChild("libelle_SP").getText());
            var16.setCommande(((Element)var13.get(var15)).getChild("commande").getText());
            var16.setPagemenu(((Element)var13.get(var15)).getChild("pagemenu").getText());
            var16.setType(((Element)var13.get(var15)).getChild("type").getText());
            var16.setGenre(((Element)var13.get(var15)).getChild("genre").getText());
            var16.setAcc(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("acc").getText()));
            var16.setAdd(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("add").getText()));
            var16.setDup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("dup").getText()));
            var16.setMaj(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("maj").getText()));
            var16.setSup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("sup").getText()));
            var16.setImp(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("imp").getText()));
            var16.setClo(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("clo").getText()));
            var16.setTrf(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("trf").getText()));
            if (var16.isAcc()) {
               var14.add(var16);
            }
         }

         this.dataModelMenudroitVentesXmlList.setWrappedData(var14);
         var10.close();
      } catch (JDOMException var17) {
         var17.getMessage();
      } catch (IOException var18) {
         var18.getMessage();
      }

   }

   public void chargerMenudroitAbonnementXml(Groupe var1, long var2, int var4, Users var5, boolean var6) {
      String var7 = "";
      if (this.strEnteteGroupe == 2) {
         var7 = "_ENT";
      } else {
         var7 = "";
      }

      try {
         SAXBuilder var8 = new SAXBuilder();
         File var9 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "81000" + var7 + "-" + var1.getGrpCode() + ".xml");
         if (!var9.exists()) {
            var9 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "81000" + var7 + ".xml");
         }

         FileReader var10 = new FileReader(var9);
         Document var11 = var8.build(var10);
         Element var12 = var11.getRootElement();
         List var13 = var12.getChildren();
         ArrayList var14 = new ArrayList();

         for(int var15 = 0; var15 < var13.size(); ++var15) {
            ObjetLigneMenu var16 = new ObjetLigneMenu();
            var16.setIndice(var15);
            var16.setLibelle_FR(((Element)var13.get(var15)).getChild("libelle_FR").getText());
            var16.setLibelle_UK(((Element)var13.get(var15)).getChild("libelle_UK").getText());
            var16.setLibelle_SP(((Element)var13.get(var15)).getChild("libelle_SP").getText());
            var16.setCommande(((Element)var13.get(var15)).getChild("commande").getText());
            var16.setPagemenu(((Element)var13.get(var15)).getChild("pagemenu").getText());
            var16.setType(((Element)var13.get(var15)).getChild("type").getText());
            var16.setGenre(((Element)var13.get(var15)).getChild("genre").getText());
            var16.setAcc(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("acc").getText()));
            var16.setAdd(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("add").getText()));
            var16.setDup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("dup").getText()));
            var16.setMaj(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("maj").getText()));
            var16.setSup(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("sup").getText()));
            var16.setImp(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("imp").getText()));
            var16.setClo(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("clo").getText()));
            var16.setTrf(Boolean.parseBoolean(((Element)var13.get(var15)).getChild("trf").getText()));
            if (var16.isAcc()) {
               var14.add(var16);
            }
         }

         this.dataModelMenudroitVentesXmlList.setWrappedData(var14);
         var10.close();
      } catch (JDOMException var17) {
         var17.getMessage();
      } catch (IOException var18) {
         var18.getMessage();
      }

   }

   public DataModel getDataModelMenudroitVentesXmlList() {
      return this.dataModelMenudroitVentesXmlList;
   }

   public void setDataModelMenudroitVentesXmlList(DataModel var1) {
      this.dataModelMenudroitVentesXmlList = var1;
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
