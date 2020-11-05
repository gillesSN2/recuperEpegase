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

public class LectureModulesOnglets implements Serializable {
   private long strId;
   private Structure structureLog;
   private List mesOnglets;

   public List chargerMesOnglets(String var1) throws JDOMException, IOException {
      this.mesOnglets = new ArrayList();

      try {
         SAXBuilder var2 = new SAXBuilder();
         File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + var1 + "_ONG.xml");
         if (!var3.exists()) {
            var3 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + var1 + "_ONG.xml");
         }

         FileReader var4 = new FileReader(var3);
         Document var5 = var2.build(var4);
         Element var6 = var5.getRootElement();
         List var7 = var6.getChildren();

         for(int var8 = 0; var8 < var7.size(); ++var8) {
            ObjetLigneOnglet var9 = new ObjetLigneOnglet();
            var9.setIndice(var8);
            var9.setLibelle(((Element)var7.get(var8)).getChild("libelle").getText());
            var9.setCode(((Element)var7.get(var8)).getChild("code").getText());
            var9.setAcc(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("acc").getText()));
            var9.setAdd(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("add").getText()));
            var9.setMaj(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("maj").getText()));
            var9.setSup(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("sup").getText()));
            var9.setImp(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("imp").getText()));
            if (var9.isAcc()) {
               this.mesOnglets.add(var9);
            }
         }

         var4.close();
      } catch (JDOMException var10) {
      } catch (IOException var11) {
      }

      return this.mesOnglets;
   }

   public List chargerMesOnglets(String var1, String var2) throws JDOMException, IOException {
      this.mesOnglets = new ArrayList();

      try {
         SAXBuilder var3 = new SAXBuilder();
         File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + var1 + "-" + var2 + "_ONG.xml");
         if (!var4.exists()) {
            var4 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + var1 + "_ONG.xml");
         }

         FileReader var5 = new FileReader(var4);
         Document var6 = var3.build(var5);
         Element var7 = var6.getRootElement();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            ObjetLigneOnglet var10 = new ObjetLigneOnglet();
            var10.setIndice(var9);
            var10.setLibelle(((Element)var8.get(var9)).getChild("libelle").getText());
            var10.setCode(((Element)var8.get(var9)).getChild("code").getText());
            var10.setAcc(Boolean.parseBoolean(((Element)var8.get(var9)).getChild("acc").getText()));
            var10.setAdd(Boolean.parseBoolean(((Element)var8.get(var9)).getChild("add").getText()));
            var10.setMaj(Boolean.parseBoolean(((Element)var8.get(var9)).getChild("maj").getText()));
            var10.setSup(Boolean.parseBoolean(((Element)var8.get(var9)).getChild("sup").getText()));
            var10.setImp(Boolean.parseBoolean(((Element)var8.get(var9)).getChild("imp").getText()));
            if (var10.isAcc()) {
               this.mesOnglets.add(var10);
            }
         }

         var5.close();
      } catch (JDOMException var11) {
      } catch (IOException var12) {
      }

      return this.mesOnglets;
   }

   public List chargerMesOngletsAll(String var1, String var2) throws JDOMException, IOException {
      SAXBuilder var3 = new SAXBuilder();
      this.mesOnglets = new ArrayList();

      try {
         Document var4 = null;
         File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "menu_defaut" + File.separator + var1 + "-" + var2 + "_ONG.xml");
         if (var5.exists()) {
            var4 = var3.build(var5);
         } else {
            var4 = var3.build(new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "menu_defaut" + File.separator + var1 + "_ONG.xml"));
         }

         Element var6 = var4.getRootElement();
         List var7 = var6.getChildren();

         for(int var8 = 0; var8 < var7.size(); ++var8) {
            ObjetLigneOnglet var9 = new ObjetLigneOnglet();
            var9.setIndice(var8);
            var9.setLibelle(((Element)var7.get(var8)).getChild("libelle").getText());
            var9.setCode(((Element)var7.get(var8)).getChild("code").getText());
            var9.setAcc(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("acc").getText()));
            var9.setAdd(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("add").getText()));
            var9.setMaj(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("maj").getText()));
            var9.setSup(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("sup").getText()));
            var9.setImp(Boolean.parseBoolean(((Element)var7.get(var8)).getChild("imp").getText()));
            this.mesOnglets.add(var9);
         }
      } catch (JDOMException var10) {
      } catch (IOException var11) {
      }

      return this.mesOnglets;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
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
