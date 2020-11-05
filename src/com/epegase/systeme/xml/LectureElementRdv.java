package com.epegase.systeme.xml;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class LectureElementRdv implements Serializable {
   private long strId;
   private Structure structureLog;
   private ObjetElementRdv objetElementRdv;
   private List mesElements = new ArrayList();
   private List mesElementsItems;

   public List chargerMesSujetRdv() throws JDOMException, IOException {
      this.mesElements = new ArrayList();
      this.mesElementsItems = new ArrayList();

      try {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         SAXBuilder var3 = new SAXBuilder();
         Document var4 = null;
         FileReader var5 = null;
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "sujetRdv.xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "sujetRdv.xml");
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
            this.enregistreSujetRdv(var4);
         } else {
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
         }

         Element var7 = var4.getRootElement();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.objetElementRdv = new ObjetElementRdv();
            String var10 = ((Element)var8.get(var9)).getChild("libelle").getText();
            String var11 = ((Element)var8.get(var9)).getChild("code").getText();
            this.objetElementRdv.setIndice(var9);
            this.objetElementRdv.setLibelle(var10);
            this.objetElementRdv.setCode(var11);
            this.mesElements.add(this.objetElementRdv);
            this.mesElementsItems.add(new SelectItem(this.objetElementRdv.getLibelle()));
         }

         var5.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

      return this.mesElementsItems;
   }

   public void enregistreSujetRdv(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "sujetRdv.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public List chargerMesLieuxRdv() throws JDOMException, IOException {
      this.mesElements = new ArrayList();
      this.mesElementsItems = new ArrayList();

      try {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         SAXBuilder var3 = new SAXBuilder();
         Document var4 = null;
         FileReader var5 = null;
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "lieuxRdv.xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "lieuxRdv.xml");
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
            this.enregistreLieuxRdv(var4);
         } else {
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
         }

         Element var7 = var4.getRootElement();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.objetElementRdv = new ObjetElementRdv();
            String var10 = ((Element)var8.get(var9)).getChild("libelle").getText();
            String var11 = ((Element)var8.get(var9)).getChild("code").getText();
            this.objetElementRdv.setIndice(var9);
            this.objetElementRdv.setLibelle(var10);
            this.objetElementRdv.setCode(var11);
            this.mesElements.add(this.objetElementRdv);
            this.mesElementsItems.add(new SelectItem(this.objetElementRdv.getLibelle()));
         }

         var5.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

      return this.mesElementsItems;
   }

   public void enregistreLieuxRdv(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "lieuxRdv.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public List chargerMesBudgetRdv() throws JDOMException, IOException {
      this.mesElements = new ArrayList();
      this.mesElementsItems = new ArrayList();

      try {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         SAXBuilder var3 = new SAXBuilder();
         Document var4 = null;
         FileReader var5 = null;
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "bugetRdv.xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "budgetRdv.xml");
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
            this.enregistreBudgetRdv(var4);
         } else {
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
         }

         Element var7 = var4.getRootElement();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.objetElementRdv = new ObjetElementRdv();
            String var10 = ((Element)var8.get(var9)).getChild("libelle").getText();
            String var11 = ((Element)var8.get(var9)).getChild("code").getText();
            this.objetElementRdv.setIndice(var9);
            this.objetElementRdv.setLibelle(var10);
            this.objetElementRdv.setCode(var11);
            this.mesElements.add(this.objetElementRdv);
            this.mesElementsItems.add(new SelectItem(this.objetElementRdv.getLibelle()));
         }

         var5.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

      return this.mesElementsItems;
   }

   public void enregistreBudgetRdv(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "budgetRdv.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public List chargerMesApportRdv() throws JDOMException, IOException {
      this.mesElements = new ArrayList();
      this.mesElementsItems = new ArrayList();

      try {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         SAXBuilder var3 = new SAXBuilder();
         Document var4 = null;
         FileReader var5 = null;
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "apportRdv.xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "apportRdv.xml");
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
            this.enregistreApportRdv(var4);
         } else {
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
         }

         Element var7 = var4.getRootElement();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.objetElementRdv = new ObjetElementRdv();
            String var10 = ((Element)var8.get(var9)).getChild("libelle").getText();
            String var11 = ((Element)var8.get(var9)).getChild("code").getText();
            this.objetElementRdv.setIndice(var9);
            this.objetElementRdv.setLibelle(var10);
            this.objetElementRdv.setCode(var11);
            this.mesElements.add(this.objetElementRdv);
            this.mesElementsItems.add(new SelectItem(this.objetElementRdv.getLibelle()));
         }

         var5.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

      return this.mesElementsItems;
   }

   public void enregistreApportRdv(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "apportRdv.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public List chargerMesModeFinRdv() throws JDOMException, IOException {
      this.mesElements = new ArrayList();
      this.mesElementsItems = new ArrayList();

      try {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         SAXBuilder var3 = new SAXBuilder();
         Document var4 = null;
         FileReader var5 = null;
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "modefinRdv.xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "modeFinRdv.xml");
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
            this.enregistreModeFinRdv(var4);
         } else {
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
         }

         Element var7 = var4.getRootElement();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.objetElementRdv = new ObjetElementRdv();
            String var10 = ((Element)var8.get(var9)).getChild("libelle").getText();
            String var11 = ((Element)var8.get(var9)).getChild("code").getText();
            this.objetElementRdv.setIndice(var9);
            this.objetElementRdv.setLibelle(var10);
            this.objetElementRdv.setCode(var11);
            this.mesElements.add(this.objetElementRdv);
            this.mesElementsItems.add(new SelectItem(this.objetElementRdv.getLibelle()));
         }

         var5.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

      return this.mesElementsItems;
   }

   public void enregistreModeFinRdv(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "modeFinRdv.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public List chargerMesDelaisRdv() throws JDOMException, IOException {
      this.mesElements = new ArrayList();
      this.mesElementsItems = new ArrayList();

      try {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         SAXBuilder var3 = new SAXBuilder();
         Document var4 = null;
         FileReader var5 = null;
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "delaisRdv.xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "delaisRdv.xml");
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
            this.enregistreDelaisRdv(var4);
         } else {
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
         }

         Element var7 = var4.getRootElement();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.objetElementRdv = new ObjetElementRdv();
            String var10 = ((Element)var8.get(var9)).getChild("libelle").getText();
            String var11 = ((Element)var8.get(var9)).getChild("code").getText();
            this.objetElementRdv.setIndice(var9);
            this.objetElementRdv.setLibelle(var10);
            this.objetElementRdv.setCode(var11);
            this.mesElements.add(this.objetElementRdv);
            this.mesElementsItems.add(new SelectItem(this.objetElementRdv.getLibelle()));
         }

         var5.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

      return this.mesElementsItems;
   }

   public void enregistreDelaisRdv(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "delaisRdv.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public List chargerMesActionRdv() throws JDOMException, IOException {
      this.mesElements = new ArrayList();
      this.mesElementsItems = new ArrayList();

      try {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         SAXBuilder var3 = new SAXBuilder();
         Document var4 = null;
         FileReader var5 = null;
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "actionRdv.xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "actionRdv.xml");
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
            this.enregistreActionRdv(var4);
         } else {
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
         }

         Element var7 = var4.getRootElement();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.objetElementRdv = new ObjetElementRdv();
            String var10 = ((Element)var8.get(var9)).getChild("libelle").getText();
            String var11 = ((Element)var8.get(var9)).getChild("code").getText();
            this.objetElementRdv.setIndice(var9);
            this.objetElementRdv.setLibelle(var10);
            this.objetElementRdv.setCode(var11);
            this.mesElements.add(this.objetElementRdv);
            this.mesElementsItems.add(new SelectItem(this.objetElementRdv.getLibelle()));
         }

         var5.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

      return this.mesElementsItems;
   }

   public void enregistreActionRdv(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "actionRdv.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public List chargerMesConclusionRdv() throws JDOMException, IOException {
      this.mesElements = new ArrayList();
      this.mesElementsItems = new ArrayList();

      try {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         SAXBuilder var3 = new SAXBuilder();
         Document var4 = null;
         FileReader var5 = null;
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "conclusionRdv.xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "conclusionRdv.xml");
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
            this.enregistreConclusionRdv(var4);
         } else {
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
         }

         Element var7 = var4.getRootElement();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.objetElementRdv = new ObjetElementRdv();
            String var10 = ((Element)var8.get(var9)).getChild("libelle").getText();
            String var11 = ((Element)var8.get(var9)).getChild("code").getText();
            this.objetElementRdv.setIndice(var9);
            this.objetElementRdv.setLibelle(var10);
            this.objetElementRdv.setCode(var11);
            this.mesElements.add(this.objetElementRdv);
            this.mesElementsItems.add(new SelectItem(this.objetElementRdv.getLibelle()));
         }

         var5.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

      return this.mesElementsItems;
   }

   public void enregistreConclusionRdv(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "conclusionRdv.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public List chargerMesCentreInteret() throws JDOMException, IOException {
      this.mesElements = new ArrayList();
      this.mesElementsItems = new ArrayList();

      try {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         SAXBuilder var3 = new SAXBuilder();
         Document var4 = null;
         FileReader var5 = null;
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "centreInteret.xml");
         if (!var6.exists()) {
            var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "centreInteret.xml");
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
            this.enregistreConclusionRdv(var4);
         } else {
            var5 = new FileReader(var6);
            var4 = var3.build(var5);
         }

         Element var7 = var4.getRootElement();
         List var8 = var7.getChildren();

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.objetElementRdv = new ObjetElementRdv();
            String var10 = ((Element)var8.get(var9)).getChild("libelle").getText();
            String var11 = ((Element)var8.get(var9)).getChild("code").getText();
            this.objetElementRdv.setIndice(var9);
            this.objetElementRdv.setLibelle(var10);
            this.objetElementRdv.setCode(var11);
            this.mesElements.add(this.objetElementRdv);
            this.mesElementsItems.add(new SelectItem(this.objetElementRdv.getLibelle()));
         }

         var5.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

      return this.mesElementsItems;
   }

   public void enregistreCentreInteret(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "office" + File.separator + "configuration" + File.separator + "centreInteret.xml");
      var2.output(var1, var3);
      var3.close();
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

   public List getMesElements() {
      return this.mesElements;
   }

   public void setMesElements(List var1) {
      this.mesElements = var1;
   }

   public List getMesElementsItems() {
      return this.mesElementsItems;
   }

   public void setMesElementsItems(List var1) {
      this.mesElementsItems = var1;
   }
}
