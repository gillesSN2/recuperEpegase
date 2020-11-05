package com.epegase.systeme.xml;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class LectureModulesTiers implements Serializable {
   private long strId;
   private Structure structureLog;
   private List mesTiers;

   public List chargerMesTiers(String var1, String var2) throws JDOMException, IOException {
      this.mesTiers = new ArrayList();

      try {
         SAXBuilder var3 = new SAXBuilder();
         File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "30000_" + var1 + "-" + var2 + ".xml");
         if (!var4.exists()) {
            var4 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "30000_" + var1 + ".xml");
         }

         FileReader var5 = new FileReader(var4);
         Document var6 = var3.build(var5);
         Element var7 = var6.getRootElement();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            ObjetLigneMenu var10 = new ObjetLigneMenu();
            var10.setIndice(var9);
            var10.setLibelle_FR(((Element)var8.get(var9)).getChild("libelle_FR").getText());
            var10.setLibelle_SP(((Element)var8.get(var9)).getChild("libelle_SP").getText());
            var10.setLibelle_UK(((Element)var8.get(var9)).getChild("libelle_UK").getText());
            var10.setPagemenu(((Element)var8.get(var9)).getChild("pagemenu").getText());
            var10.setCommande(((Element)var8.get(var9)).getChild("commande").getText());
            var10.setType(((Element)var8.get(var9)).getChild("type").getText());
            var10.setGenre(((Element)var8.get(var9)).getChild("genre").getText());
            var10.setAcc(Boolean.parseBoolean(((Element)var8.get(var9)).getChild("acc").getText()));
            var10.setAdd(Boolean.parseBoolean(((Element)var8.get(var9)).getChild("add").getText()));
            var10.setDup(Boolean.parseBoolean(((Element)var8.get(var9)).getChild("dup").getText()));
            var10.setMaj(Boolean.parseBoolean(((Element)var8.get(var9)).getChild("maj").getText()));
            var10.setSup(Boolean.parseBoolean(((Element)var8.get(var9)).getChild("sup").getText()));
            var10.setImp(Boolean.parseBoolean(((Element)var8.get(var9)).getChild("imp").getText()));
            var10.setClo(Boolean.parseBoolean(((Element)var8.get(var9)).getChild("clo").getText()));
            var10.setTrf(Boolean.parseBoolean(((Element)var8.get(var9)).getChild("trf").getText()));
            if (var10.isAcc()) {
               this.mesTiers.add(var10);
            }
         }

         var5.close();
      } catch (JDOMException var11) {
      } catch (IOException var12) {
      }

      return this.mesTiers;
   }

   public List chargerMesTiersAll(String var1, String var2) throws JDOMException, IOException {
      SAXBuilder var3 = new SAXBuilder();
      this.mesTiers = new ArrayList();

      try {
         Document var4 = null;
         File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + "30000_" + var1 + "-" + var2 + ".xml");
         if (var5.exists()) {
            var4 = var3.build(var5);
         } else {
            var4 = var3.build(new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "30000_" + var1 + ".xml"));
         }

         Element var6 = var4.getRootElement();
         List var7 = var6.getChildren();

         for(int var8 = 0; var8 < var7.size(); ++var8) {
            ObjetLigneMenu var9 = new ObjetLigneMenu();
            var9.setIndice(var8);
            var9.setLibelle_FR(((Element)var7.get(var8)).getChild("libelle_FR").getText());
            var9.setLibelle_SP(((Element)var7.get(var8)).getChild("libelle_SP").getText());
            var9.setLibelle_UK(((Element)var7.get(var8)).getChild("libelle_UK").getText());
            var9.setPagemenu(((Element)var7.get(var8)).getChild("pagemenu").getText());
            var9.setCommande(((Element)var7.get(var8)).getChild("commande").getText());
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
            this.mesTiers.add(var9);
         }
      } catch (JDOMException var10) {
      } catch (IOException var11) {
      }

      return this.mesTiers;
   }

   public List chargerMesTiersSt(String var1) throws JDOMException, IOException {
      SAXBuilder var2 = new SAXBuilder();
      this.mesTiers = new ArrayList();

      try {
         Document var3 = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + "30000_" + var1 + ".xml"));
         Element var4 = var3.getRootElement();
         List var5 = var4.getChildren();

         for(int var6 = 0; var6 < var5.size(); ++var6) {
            ObjetLigneMenu var7 = new ObjetLigneMenu();
            var7.setIndice(var6);
            var7.setLibelle_FR(((Element)var5.get(var6)).getChild("libelle_FR").getText());
            var7.setLibelle_SP(((Element)var5.get(var6)).getChild("libelle_SP").getText());
            var7.setLibelle_UK(((Element)var5.get(var6)).getChild("libelle_UK").getText());
            var7.setPagemenu(((Element)var5.get(var6)).getChild("pagemenu").getText());
            var7.setCommande(((Element)var5.get(var6)).getChild("commande").getText());
            var7.setType(((Element)var5.get(var6)).getChild("type").getText());
            var7.setGenre(((Element)var5.get(var6)).getChild("genre").getText());
            var7.setAcc(Boolean.parseBoolean(((Element)var5.get(var6)).getChild("acc").getText()));
            var7.setAdd(Boolean.parseBoolean(((Element)var5.get(var6)).getChild("add").getText()));
            var7.setDup(Boolean.parseBoolean(((Element)var5.get(var6)).getChild("dup").getText()));
            var7.setMaj(Boolean.parseBoolean(((Element)var5.get(var6)).getChild("maj").getText()));
            var7.setSup(Boolean.parseBoolean(((Element)var5.get(var6)).getChild("sup").getText()));
            var7.setImp(Boolean.parseBoolean(((Element)var5.get(var6)).getChild("imp").getText()));
            var7.setClo(Boolean.parseBoolean(((Element)var5.get(var6)).getChild("clo").getText()));
            var7.setTrf(Boolean.parseBoolean(((Element)var5.get(var6)).getChild("trf").getText()));
            this.mesTiers.add(var7);
         }
      } catch (JDOMException var8) {
      } catch (IOException var9) {
      }

      return this.mesTiers;
   }

   public List getMesTiers() {
      return this.mesTiers;
   }

   public void setMesTiers(List var1) {
      this.mesTiers = var1;
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
