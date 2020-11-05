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

public class LectureFamillesFournisseurs implements Serializable {
   private long strId;
   private Structure structureLog;
   private ObjetFamilleTiers objetFamilleTiers;
   private List mesFamillesFournisseurs = new ArrayList();
   private List mesFamillesFournisseursItems;

   public List chargerMesFamillesFournisseurItems() throws JDOMException, IOException {
      try {
         SAXBuilder var1 = new SAXBuilder();
         Document var2 = null;
         FileReader var3 = null;
         File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "familles_tiers" + File.separator + "fournisseurs.xml");
         if (!var4.exists()) {
            var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "familles_tiers" + File.separator + "fournisseurs.xml");
            var3 = new FileReader(var4);
            var2 = var1.build(var3);
            this.enregistreFmtFournisseur(var2);
         } else {
            var3 = new FileReader(var4);
            var2 = var1.build(var3);
         }

         Element var5 = var2.getRootElement();
         this.mesFamillesFournisseurs = new ArrayList();
         this.mesFamillesFournisseursItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetFamilleTiers = new ObjetFamilleTiers();
            String var8 = ((Element)var6.get(var7)).getChild("libelle").getText();
            String var9 = ((Element)var6.get(var7)).getChild("exoTva").getText();
            String var10 = ((Element)var6.get(var7)).getChild("exoDouane").getText();
            String var11 = ((Element)var6.get(var7)).getChild("serie").getText();
            this.objetFamilleTiers.setIndice(var7);
            this.objetFamilleTiers.setLibelle(var8);
            this.objetFamilleTiers.setExoTva(var9);
            this.objetFamilleTiers.setExoDouane(var10);
            this.objetFamilleTiers.setSerie(var11);
            this.mesFamillesFournisseurs.add(this.objetFamilleTiers);
            this.mesFamillesFournisseursItems.add(new SelectItem(this.objetFamilleTiers.getLibelle()));
         }

         var3.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

      return this.mesFamillesFournisseursItems;
   }

   public void enregistreFmtFournisseur(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "familles_tiers" + File.separator + "fournisseur.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public List getMesFamillesFournisseurs() {
      return this.mesFamillesFournisseurs;
   }

   public void setMesFamillesFournisseurs(List var1) {
      this.mesFamillesFournisseurs = var1;
   }

   public List getMesFamillesFournisseursItems() {
      return this.mesFamillesFournisseursItems;
   }

   public void setMesFamillesFournisseursItems(List var1) {
      this.mesFamillesFournisseursItems = var1;
   }

   public ObjetFamilleTiers getObjetFamilleTiers() {
      return this.objetFamilleTiers;
   }

   public void setObjetFamilleTiers(ObjetFamilleTiers var1) {
      this.objetFamilleTiers = var1;
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
