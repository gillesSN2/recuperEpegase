package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
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

public class LectureNatureJournaux implements Serializable {
   private ObjetCompte objetCompte;
   private List mesNatureJournaux = new ArrayList();
   private List mesNatureJournauxItems;

   public LectureNatureJournaux() throws IOException {
      this.recupereNatureJournaux();
   }

   public void recupereNatureJournaux() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "fiscalites" + File.separator + "naturesJournaux.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.mesNatureJournaux = new ArrayList();
         this.mesNatureJournauxItems = new ArrayList();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.objetCompte = new ObjetCompte();
            String var8 = ((Element)var6.get(var7)).getChild("code").getText();
            String var9 = ((Element)var6.get(var7)).getChild("nom_FR").getText();
            String var10 = ((Element)var6.get(var7)).getChild("nom_UK").getText();
            String var11 = ((Element)var6.get(var7)).getChild("nom_SP").getText();
            this.objetCompte.setCode(var8);
            this.objetCompte.setNom_FR(var9);
            this.objetCompte.setNom_UK(var10);
            this.objetCompte.setNom_SP(var11);
            this.mesNatureJournaux.add(this.objetCompte);
            this.mesNatureJournauxItems.add(new SelectItem(this.objetCompte));
         }

         var3.close();
      } catch (JDOMException var12) {
      } catch (IOException var13) {
      }

   }

   public List getMesNatureJournaux() {
      return this.mesNatureJournaux;
   }

   public void setMesNatureJournaux(List var1) {
      this.mesNatureJournaux = var1;
   }

   public List getMesNatureJournauxItems() {
      return this.mesNatureJournauxItems;
   }

   public void setMesNatureJournauxItems(List var1) {
      this.mesNatureJournauxItems = var1;
   }
}
