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

public class LectureReglementFournisseur implements Serializable {
   private long strId;
   private Structure structureLog;
   private ObjetReglement objetReglement;
   private List mesReglementFournisseur = new ArrayList();
   private List mesReglementFournisseurItems;

   public void recupereReglementFournisseur() {
      this.mesReglementFournisseur = new ArrayList();
      this.mesReglementFournisseurItems = new ArrayList();

      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "familles_tiers" + File.separator + "reglementFournisseur.xml");
         FileReader var3 = null;
         Document var4 = null;
         if (!var2.exists()) {
            var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "familles_tiers" + File.separator + "reglementFournisseur.xml");
            var3 = new FileReader(var2);
            var4 = var1.build(var3);
            this.enregistreRegFournisseur(var4);
         } else {
            var3 = new FileReader(var2);
            var4 = var1.build(var3);
         }

         Element var5 = var4.getRootElement();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetReglement = new ObjetReglement();
            String var8 = ((Element)var6.get(var7)).getChild("categories").getText();
            String var9 = ((Element)var6.get(var7)).getChild("libelles").getText();
            String var10 = ((Element)var6.get(var7)).getChild("journals").getText();
            String var11 = ((Element)var6.get(var7)).getChild("echeances").getText();
            String var12 = ((Element)var6.get(var7)).getChild("nbjours").getText();
            String var13 = ((Element)var6.get(var7)).getChild("arrondis").getText();
            String var14 = ((Element)var6.get(var7)).getChild("conditions").getText();
            String var15 = ((Element)var6.get(var7)).getChild("defaut").getText();
            this.objetReglement.setCategories(var8);
            this.objetReglement.setLibelles(var9);
            this.objetReglement.setJournals(var10);
            this.objetReglement.setEcheances(var11);
            this.objetReglement.setNbjours(var12);
            this.objetReglement.setArrondis(var13);
            this.objetReglement.setConditions(var14);
            this.objetReglement.setDefaut(var15);
            this.objetReglement.setIndice(var7);
            this.mesReglementFournisseur.add(this.objetReglement);
            this.mesReglementFournisseurItems.add(new SelectItem(this.objetReglement.getCategories() + ":" + this.objetReglement.getLibelles()));
         }

         var3.close();
      } catch (JDOMException var16) {
      } catch (IOException var17) {
      }

   }

   public void enregistreRegFournisseur(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "familles_tiers" + File.separator + "reglementFournisseur.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public List getMesReglementFournisseur() {
      return this.mesReglementFournisseur;
   }

   public void setMesReglementFournisseur(List var1) {
      this.mesReglementFournisseur = var1;
   }

   public List getMesReglementFournisseurItems() {
      return this.mesReglementFournisseurItems;
   }

   public void setMesReglementFournisseurItems(List var1) {
      this.mesReglementFournisseurItems = var1;
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
