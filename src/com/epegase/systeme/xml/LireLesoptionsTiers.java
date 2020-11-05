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

public class LireLesoptionsTiers implements Serializable {
   private long strId;
   private OptionTiers optionTiers;

   public OptionTiers lancer() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "commun" + File.separator + "configuration" + File.separator + "optionTiers.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.optionTiers = new OptionTiers();
         if (var5.getChildText("gestionComm") != null && !var5.getChildText("gestionComm").isEmpty()) {
            this.optionTiers.setGestionComm(var5.getChildText("gestionComm"));
         } else {
            this.optionTiers.setGestionComm("false");
         }

         if (var5.getChildText("affFicheTiers") != null && !var5.getChildText("affFicheTiers").isEmpty()) {
            this.optionTiers.setAffFicheTiers(var5.getChildText("affFicheTiers"));
         } else {
            this.optionTiers.setAffFicheTiers("6");
         }

         if (var5.getChildText("affMessagerie") != null && !var5.getChildText("affMessagerie").isEmpty()) {
            this.optionTiers.setAffMessagerie(var5.getChildText("affMessagerie"));
         } else {
            this.optionTiers.setAffMessagerie("6");
         }

         if (var5.getChildText("affCadeaux") != null && !var5.getChildText("affCadeaux").isEmpty()) {
            this.optionTiers.setAffCadeaux(var5.getChildText("affCadeaux"));
         } else {
            this.optionTiers.setAffCadeaux("6");
         }

         if (var5.getChildText("nbLigneMaxTi") != null && !var5.getChildText("nbLigneMaxTi").isEmpty()) {
            this.optionTiers.setNbLigneMaxTi(var5.getChildText("nbLigneMaxTi"));
         } else {
            this.optionTiers.setNbLigneMaxTi("100");
         }

         if (var5.getChildText("nbLigneMaxMs") != null && !var5.getChildText("nbLigneMaxMs").isEmpty()) {
            this.optionTiers.setNbLigneMaxMs(var5.getChildText("nbLigneMaxMs"));
         } else {
            this.optionTiers.setNbLigneMaxMs("100");
         }

         if (var5.getChildText("nbLigneMaxCad") != null && !var5.getChildText("nbLigneMaxCad").isEmpty()) {
            this.optionTiers.setNbLigneMaxCad(var5.getChildText("nbLigneMaxCad"));
         } else {
            this.optionTiers.setNbLigneMaxCad("100");
         }

         if (var5.getChildText("chargementListe") != null && !var5.getChildText("chargementListe").isEmpty()) {
            this.optionTiers.setChargementListe(var5.getChildText("chargementListe"));
         } else {
            this.optionTiers.setChargementListe("0");
         }

         if (var5.getChildText("nbJoursPasses") != null && !var5.getChildText("nbJoursPasses").isEmpty()) {
            this.optionTiers.setNbJoursPasses(var5.getChildText("nbJoursPasses"));
         } else {
            this.optionTiers.setNbJoursPasses("0");
         }

         if (var5.getChildText("saisieCourrier") != null && !var5.getChildText("saisieCourrier").isEmpty()) {
            this.optionTiers.setSaisieCourrier(var5.getChildText("saisieCourrier"));
         } else {
            this.optionTiers.setSaisieCourrier("0");
         }

         if (var5.getChildText("ongletContact") != null && !var5.getChildText("ongletContact").isEmpty()) {
            this.optionTiers.setOngletContact(var5.getChildText("ongletContact"));
         } else {
            this.optionTiers.setOngletContact("0");
         }

         if (var5.getChildText("ongletColaborateur") != null && !var5.getChildText("ongletColaborateur").isEmpty()) {
            this.optionTiers.setOngletColaborateur(var5.getChildText("ongletColaborateur"));
         } else {
            this.optionTiers.setOngletColaborateur("0");
         }

         if (var5.getChildText("majTodo") != null && !var5.getChildText("majTodo").isEmpty()) {
            this.optionTiers.setMajTodo(var5.getChildText("majTodo"));
         } else {
            this.optionTiers.setMajTodo("0");
         }

         if (var5.getChildText("zoneObligatoire") != null && !var5.getChildText("zoneObligatoire").isEmpty()) {
            this.optionTiers.setZoneObligatoire(var5.getChildText("zoneObligatoire"));
         } else {
            this.optionTiers.setZoneObligatoire("0");
         }

         this.optionTiers.setLib1(var5.getChildText("lib1"));
         this.optionTiers.setLib2(var5.getChildText("lib2"));
         this.optionTiers.setLib3(var5.getChildText("lib3"));
         this.optionTiers.setLib4(var5.getChildText("lib4"));
         this.optionTiers.setLib5(var5.getChildText("lib5"));
         this.optionTiers.setLib6(var5.getChildText("lib6"));
         this.optionTiers.setLib7(var5.getChildText("lib7"));
         this.optionTiers.setLib8(var5.getChildText("lib8"));
         this.optionTiers.setLib9(var5.getChildText("lib9"));
         this.optionTiers.setLib10(var5.getChildText("lib10"));
         this.optionTiers.setModeleAch1(var5.getChildText("modeleAch1"));
         this.optionTiers.setModeleAch2(var5.getChildText("modeleAch2"));
         this.optionTiers.setModeleAch3(var5.getChildText("modeleAch3"));
         this.optionTiers.setModeleAch4(var5.getChildText("modeleAch4"));
         this.optionTiers.setModeleAch5(var5.getChildText("modeleAch5"));
         this.optionTiers.setModeleAch6(var5.getChildText("modeleAch6"));
         this.optionTiers.setModeleAch7(var5.getChildText("modeleAch7"));
         this.optionTiers.setModeleAch8(var5.getChildText("modeleAch8"));
         this.optionTiers.setModeleAch9(var5.getChildText("modeleAch9"));
         this.optionTiers.setModeleAch10(var5.getChildText("modeleAch10"));
         this.optionTiers.setModeleStk1(var5.getChildText("modeleStk1"));
         this.optionTiers.setModeleStk2(var5.getChildText("modeleStk2"));
         this.optionTiers.setModeleStk3(var5.getChildText("modeleStk3"));
         this.optionTiers.setModeleStk4(var5.getChildText("modeleStk4"));
         this.optionTiers.setModeleStk5(var5.getChildText("modeleStk5"));
         this.optionTiers.setModeleStk6(var5.getChildText("modeleStk6"));
         this.optionTiers.setModeleStk7(var5.getChildText("modeleStk7"));
         this.optionTiers.setModeleStk8(var5.getChildText("modeleStk8"));
         this.optionTiers.setModeleStk9(var5.getChildText("modeleStk9"));
         this.optionTiers.setModeleStk10(var5.getChildText("modeleStk10"));
         this.optionTiers.setModeleVte1(var5.getChildText("modeleVte1"));
         this.optionTiers.setModeleVte2(var5.getChildText("modeleVte2"));
         this.optionTiers.setModeleVte3(var5.getChildText("modeleVte3"));
         this.optionTiers.setModeleVte4(var5.getChildText("modeleVte4"));
         this.optionTiers.setModeleVte5(var5.getChildText("modeleVte5"));
         this.optionTiers.setModeleVte6(var5.getChildText("modeleVte6"));
         this.optionTiers.setModeleVte7(var5.getChildText("modeleVte7"));
         this.optionTiers.setModeleVte8(var5.getChildText("modeleVte8"));
         this.optionTiers.setModeleVte9(var5.getChildText("modeleVte9"));
         this.optionTiers.setModeleVte10(var5.getChildText("modeleVte10"));
         this.optionTiers.setModeleTre1(var5.getChildText("modeleTre1"));
         this.optionTiers.setModeleTre2(var5.getChildText("modeleTre2"));
         this.optionTiers.setModeleTre3(var5.getChildText("modeleTre3"));
         this.optionTiers.setModeleTre4(var5.getChildText("modeleTre4"));
         this.optionTiers.setModeleTre5(var5.getChildText("modeleTre5"));
         this.optionTiers.setLibAch1(var5.getChildText("libAch1"));
         this.optionTiers.setLibAch2(var5.getChildText("libAch2"));
         this.optionTiers.setLibAch3(var5.getChildText("libAch3"));
         this.optionTiers.setLibAch4(var5.getChildText("libAch4"));
         this.optionTiers.setLibAch5(var5.getChildText("libAch5"));
         this.optionTiers.setLibAch6(var5.getChildText("libAch6"));
         this.optionTiers.setLibAch7(var5.getChildText("libAch7"));
         this.optionTiers.setLibAch8(var5.getChildText("libAch8"));
         this.optionTiers.setLibAch9(var5.getChildText("libAch9"));
         this.optionTiers.setLibAch10(var5.getChildText("libAch10"));
         this.optionTiers.setLibStk1(var5.getChildText("libStk1"));
         this.optionTiers.setLibStk2(var5.getChildText("libStk2"));
         this.optionTiers.setLibStk3(var5.getChildText("libStk3"));
         this.optionTiers.setLibStk4(var5.getChildText("libStk4"));
         this.optionTiers.setLibStk5(var5.getChildText("libStk5"));
         this.optionTiers.setLibStk6(var5.getChildText("libStk6"));
         this.optionTiers.setLibStk7(var5.getChildText("libStk7"));
         this.optionTiers.setLibStk8(var5.getChildText("libStk8"));
         this.optionTiers.setLibStk9(var5.getChildText("libStk9"));
         this.optionTiers.setLibStk10(var5.getChildText("libStk10"));
         this.optionTiers.setLibVte1(var5.getChildText("libVte1"));
         this.optionTiers.setLibVte2(var5.getChildText("libVte2"));
         this.optionTiers.setLibVte3(var5.getChildText("libVte3"));
         this.optionTiers.setLibVte4(var5.getChildText("libVte4"));
         this.optionTiers.setLibVte5(var5.getChildText("libVte5"));
         this.optionTiers.setLibVte6(var5.getChildText("libVte6"));
         this.optionTiers.setLibVte7(var5.getChildText("libVte7"));
         this.optionTiers.setLibVte8(var5.getChildText("libVte8"));
         this.optionTiers.setLibVte9(var5.getChildText("libVte9"));
         this.optionTiers.setLibVte10(var5.getChildText("libVte10"));
         this.optionTiers.setLibTre1(var5.getChildText("libTre1"));
         this.optionTiers.setLibTre2(var5.getChildText("libTre2"));
         this.optionTiers.setLibTre3(var5.getChildText("libTre3"));
         this.optionTiers.setLibTre4(var5.getChildText("libTre4"));
         this.optionTiers.setLibTre5(var5.getChildText("libTre5"));
         var3.close();
      } catch (JDOMException var6) {
      } catch (IOException var7) {
      }

      return this.optionTiers;
   }

   public OptionTiers getOptionTiers() {
      return this.optionTiers;
   }

   public void setOptionTiers(OptionTiers var1) {
      this.optionTiers = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }
}
