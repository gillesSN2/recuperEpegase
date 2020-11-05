package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class LireLesoptionsParcs implements Serializable {
   private long strId;
   private OptionParcs optionParcs;

   public OptionParcs lancer() {
      if (this.optionParcs == null) {
         this.optionParcs = new OptionParcs();
      }

      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "parc" + File.separator + "configuration" + File.separator + "optionsParc.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.optionParcs.setType(var5.getChildText("type"));
         this.optionParcs.setAffichageTransPersonnel(var5.getChildText("affichageTransPersonnel"));
         this.optionParcs.setAffichageTransMateriel(var5.getChildText("affichageTransMateriel"));
         this.optionParcs.setAffichageTPParc(var5.getChildText("affichageTPParc"));
         this.optionParcs.setAffichageLocParc(var5.getChildText("affichageLocParc"));
         this.optionParcs.setAffichageGPSParc(var5.getChildText("affichageGPSParc"));
         this.optionParcs.setAffichageConParc(var5.getChildText("affichageConParc"));
         this.optionParcs.setAffichageORParc(var5.getChildText("affichageORParc"));
         if (var5.getChildText("libProduit") != null && !var5.getChildText("libProduit").isEmpty()) {
            this.optionParcs.setLibProduit(var5.getChildText("libProduit"));
         } else {
            this.optionParcs.setLibProduit("0");
         }

         if (var5.getChildText("libelleProduit") != null && !var5.getChildText("libelleProduit").isEmpty()) {
            this.optionParcs.setLibelleProduit(var5.getChildText("libelleProduit"));
         } else {
            this.optionParcs.setLibelleProduit("0");
         }

         this.optionParcs.setTvaDefaut(var5.getChildText("tvaDefaut"));
         if (var5.getChildText("decrmtPriVteStock") != null && !var5.getChildText("decrmtPriVteStock").isEmpty()) {
            this.optionParcs.setDecrmtPriVteStock(var5.getChildText("decrmtPriVteStock"));
         } else {
            this.optionParcs.setDecrmtPriVteStock("0");
         }

         this.optionParcs.setTvaDefaut(var5.getChildText("tvaDefaut"));
         if (var5.getChildText("decrmtRabais") != null && !var5.getChildText("decrmtRabais").isEmpty()) {
            this.optionParcs.setDecrmtRabais(var5.getChildText("decrmtRabais"));
         } else {
            this.optionParcs.setDecrmtRabais("0");
         }

         if (var5.getChildText("choixStock") != null && !var5.getChildText("choixStock").isEmpty()) {
            this.optionParcs.setChoixStock(var5.getChildText("choixStock"));
         } else {
            this.optionParcs.setChoixStock("0");
         }

         if (var5.getChildText("nbDecPu") != null && !var5.getChildText("nbDecPu").isEmpty()) {
            this.optionParcs.setNbDecPu(var5.getChildText("nbDecPu"));
         } else {
            this.optionParcs.setNbDecPu("0");
         }

         if (var5.getChildText("affichInGlobViewMANIFESTE") != null && !var5.getChildText("affichInGlobViewMANIFESTE").isEmpty()) {
            this.optionParcs.setAffichInGlobViewMANIFESTE(var5.getChildText("affichInGlobViewMANIFESTE"));
         } else {
            this.optionParcs.setAffichInGlobViewMANIFESTE("0");
         }

         if (var5.getChildText("ajoutMANIFESTE") != null && !var5.getChildText("ajoutMANIFESTE").isEmpty()) {
            this.optionParcs.setAjoutMANIFESTE(var5.getChildText("ajoutMANIFESTE"));
         } else {
            this.optionParcs.setAjoutMANIFESTE("0");
         }

         if (var5.getChildText("contenerMANIFEST") != null && !var5.getChildText("contenerMANIFEST").isEmpty()) {
            this.optionParcs.setContenerMANIFEST(var5.getChildText("contenerMANIFEST"));
         } else {
            this.optionParcs.setContenerMANIFEST("0");
         }

         if (var5.getChildText("chauffeurMANIFEST") != null && !var5.getChildText("chauffeurMANIFEST").isEmpty()) {
            this.optionParcs.setChauffeurMANIFEST(var5.getChildText("chauffeurMANIFEST"));
         } else {
            this.optionParcs.setChauffeurMANIFEST("0");
         }

         if (var5.getChildText("produitMANIFEST") != null && !var5.getChildText("produitMANIFEST").isEmpty()) {
            this.optionParcs.setProduitMANIFEST(var5.getChildText("produitMANIFEST"));
         } else {
            this.optionParcs.setProduitMANIFEST("0");
         }

         if (var5.getChildText("minimumMANIFEST") != null && !var5.getChildText("minimumMANIFEST").isEmpty()) {
            this.optionParcs.setMinimumMANIFEST(var5.getChildText("minimumMANIFEST"));
         } else {
            this.optionParcs.setMinimumMANIFEST("0");
         }

         if (var5.getChildText("libelleMANIFEST") != null && !var5.getChildText("libelleMANIFEST").isEmpty()) {
            this.optionParcs.setLibelleMANIFEST(var5.getChildText("libelleMANIFEST"));
         } else {
            this.optionParcs.setLibelleMANIFEST("Manifeste");
         }

         this.optionParcs.setLib1ENTETE(var5.getChildText("lib1ENTETE"));
         this.optionParcs.setLib2ENTETE(var5.getChildText("lib2ENTETE"));
         this.optionParcs.setLib3ENTETE(var5.getChildText("lib3ENTETE"));
         this.optionParcs.setLib4ENTETE(var5.getChildText("lib4ENTETE"));
         this.optionParcs.setLib5ENTETE(var5.getChildText("lib5ENTETE"));
         this.optionParcs.setLib6ENTETE(var5.getChildText("lib6ENTETE"));
         this.optionParcs.setLib7ENTETE(var5.getChildText("lib7ENTETE"));
         this.optionParcs.setLib8ENTETE(var5.getChildText("lib8ENTETE"));
         this.optionParcs.setLib9ENTETE(var5.getChildText("lib9ENTETE"));
         this.optionParcs.setLib10ENTETE(var5.getChildText("lib10ENTETE"));
         if (var5.getChildText("type") != null && !var5.getChildText("type").isEmpty()) {
            this.optionParcs.setType(var5.getChildText("type"));
         } else {
            this.optionParcs.setType("0");
         }

         if (var5.getChildText("nbLigneMax") != null && !var5.getChildText("nbLigneMax").isEmpty()) {
            this.optionParcs.setNbLigneMax(var5.getChildText("nbLigneMax"));
         } else {
            this.optionParcs.setNbLigneMax("100");
         }

         if (var5.getChildText("chargementListe") != null && !var5.getChildText("chargementListe").isEmpty()) {
            this.optionParcs.setChargementListe(var5.getChildText("chargementListe"));
         } else {
            this.optionParcs.setChargementListe("0");
         }

         var3.close();
      } catch (JDOMException var6) {
      } catch (IOException var7) {
      }

      return this.optionParcs;
   }

   public OptionParcs getOptionParcs() {
      return this.optionParcs;
   }

   public void setOptionParcs(OptionParcs var1) {
      this.optionParcs = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }
}
