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

public class LireLesoptionsCaisses implements Serializable {
   private long strId;
   private OptionCaisses optionsCaisses;

   public OptionCaisses lancer() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "caisses" + File.separator + "configuration" + File.separator + "optionsCaisses.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.optionsCaisses = new OptionCaisses();
         if (var5.getChildText("affichInGlobViewCAISSE") != null && !var5.getChildText("affichInGlobViewCAISSE").isEmpty()) {
            this.optionsCaisses.setAffichInGlobViewCAISSE(var5.getChildText("affichInGlobViewCAISSE"));
         } else {
            this.optionsCaisses.setAffichInGlobViewCAISSE("100");
         }

         if (var5.getChildText("affichInGlobViewRECU") != null && !var5.getChildText("affichInGlobViewRECU").isEmpty()) {
            this.optionsCaisses.setAffichInGlobViewRECU(var5.getChildText("affichInGlobViewRECU"));
         } else {
            this.optionsCaisses.setAffichInGlobViewRECU("100");
         }

         if (var5.getChildText("affichInGlobViewSorti") != null && !var5.getChildText("affichInGlobViewSorti").isEmpty()) {
            this.optionsCaisses.setAffichInGlobViewSorti(var5.getChildText("affichInGlobViewSorti"));
         } else {
            this.optionsCaisses.setAffichInGlobViewSorti("100");
         }

         if (var5.getChildText("affichInGlobViewEntre") != null && !var5.getChildText("affichInGlobViewEntre").isEmpty()) {
            this.optionsCaisses.setAffichInGlobViewEntre(var5.getChildText("affichInGlobViewEntre"));
         } else {
            this.optionsCaisses.setAffichInGlobViewEntre("100");
         }

         if (var5.getChildText("affichInGlobViewVirment") != null && !var5.getChildText("affichInGlobViewVirment").isEmpty()) {
            this.optionsCaisses.setAffichInGlobViewVirment(var5.getChildText("affichInGlobViewVirment"));
         } else {
            this.optionsCaisses.setAffichInGlobViewVirment("100");
         }

         if (var5.getChildText("affichInGlobViewPayment") != null && !var5.getChildText("affichInGlobViewPayment").isEmpty()) {
            this.optionsCaisses.setAffichInGlobViewPayment(var5.getChildText("affichInGlobViewPayment"));
         } else {
            this.optionsCaisses.setAffichInGlobViewPayment("100");
         }

         if (var5.getChildText("nbLigneMax") != null && !var5.getChildText("nbLigneMax").isEmpty()) {
            this.optionsCaisses.setNbLigneMax(var5.getChildText("nbLigneMax"));
         } else {
            this.optionsCaisses.setNbLigneMax("100");
         }

         if (var5.getChildText("saisieRecette") != null && !var5.getChildText("saisieRecette").isEmpty()) {
            this.optionsCaisses.setSaisieRecette(var5.getChildText("saisieRecette"));
         } else {
            this.optionsCaisses.setSaisieRecette("false");
         }

         if (var5.getChildText("saisieDepense") != null && !var5.getChildText("saisieDepense").isEmpty()) {
            this.optionsCaisses.setSaisieDepense(var5.getChildText("saisieDepense"));
         } else {
            this.optionsCaisses.setSaisieDepense("false");
         }

         if (var5.getChildText("saisieTransfert") != null && !var5.getChildText("saisieTransfert").isEmpty()) {
            this.optionsCaisses.setSaisieTransfert(var5.getChildText("saisieTransfert"));
         } else {
            this.optionsCaisses.setSaisieTransfert("false");
         }

         if (var5.getChildText("saisieRegularisation") != null && !var5.getChildText("saisieRegularisation").isEmpty()) {
            this.optionsCaisses.setSaisieRegularisation(var5.getChildText("saisieRegularisation"));
         } else {
            this.optionsCaisses.setSaisieRegularisation("false");
         }

         if (var5.getChildText("saisieAnnulation") != null && !var5.getChildText("saisieAnnulation").isEmpty()) {
            this.optionsCaisses.setSaisieAnnulation(var5.getChildText("saisieAnnulation"));
         } else {
            this.optionsCaisses.setSaisieAnnulation("false");
         }

         if (var5.getChildText("saisieSuppression") != null && !var5.getChildText("saisieSuppression").isEmpty()) {
            this.optionsCaisses.setSaisieSuppression(var5.getChildText("saisieSuppression"));
         } else {
            this.optionsCaisses.setSaisieSuppression("false");
         }

         this.optionsCaisses.setModeleClotJour(var5.getChildText("modeleClotJour"));
         this.optionsCaisses.setMailClotJour(var5.getChildText("mailClotJour"));
         this.optionsCaisses.setModeleClotMois(var5.getChildText("modeleClotMois"));
         this.optionsCaisses.setMailClotMois(var5.getChildText("mailClotMois"));
         if (var5.getChildText("execution") != null && !var5.getChildText("execution").isEmpty()) {
            this.optionsCaisses.setExecution(var5.getChildText("execution"));
         } else {
            this.optionsCaisses.setExecution("0");
         }

         if (var5.getChildText("chronoReglement") != null && !var5.getChildText("chronoReglement").isEmpty()) {
            this.optionsCaisses.setChronoReglement(var5.getChildText("chronoReglement"));
         } else {
            this.optionsCaisses.setChronoReglement("0");
         }

         if (var5.getChildText("blocageCompte") != null && !var5.getChildText("blocageCompte").isEmpty()) {
            this.optionsCaisses.setBlocageCompte(var5.getChildText("blocageCompte"));
         } else {
            this.optionsCaisses.setBlocageCompte("0");
         }

         if (var5.getChildText("accesJournaux") != null && !var5.getChildText("accesJournaux").isEmpty()) {
            this.optionsCaisses.setAccesJournaux(var5.getChildText("accesJournaux"));
         } else {
            this.optionsCaisses.setAccesJournaux("0");
         }

         if (var5.getChildText("bonDecaissement") != null && !var5.getChildText("bonDecaissement").isEmpty()) {
            this.optionsCaisses.setBonDecaissement(var5.getChildText("bonDecaissement"));
         } else {
            this.optionsCaisses.setBonDecaissement("0");
         }

         if (var5.getChildText("bonEncaissement") != null && !var5.getChildText("bonEncaissement").isEmpty()) {
            this.optionsCaisses.setBonEncaissement(var5.getChildText("bonEncaissement"));
         } else {
            this.optionsCaisses.setBonEncaissement("0");
         }

         if (var5.getChildText("dateSuppression") != null && !var5.getChildText("dateSuppression").isEmpty()) {
            this.optionsCaisses.setDateSuppression(var5.getChildText("dateSuppression"));
         } else {
            this.optionsCaisses.setDateSuppression("0");
         }

         this.optionsCaisses.setB1(var5.getChildText("b1"));
         this.optionsCaisses.setB2(var5.getChildText("b2"));
         this.optionsCaisses.setB3(var5.getChildText("b3"));
         this.optionsCaisses.setB4(var5.getChildText("b4"));
         this.optionsCaisses.setB5(var5.getChildText("b5"));
         this.optionsCaisses.setB6(var5.getChildText("b6"));
         this.optionsCaisses.setB7(var5.getChildText("b7"));
         this.optionsCaisses.setB8(var5.getChildText("b8"));
         this.optionsCaisses.setB9(var5.getChildText("b9"));
         this.optionsCaisses.setB10(var5.getChildText("b10"));
         this.optionsCaisses.setP1(var5.getChildText("p1"));
         this.optionsCaisses.setP2(var5.getChildText("p2"));
         this.optionsCaisses.setP3(var5.getChildText("p3"));
         this.optionsCaisses.setP4(var5.getChildText("p4"));
         this.optionsCaisses.setP5(var5.getChildText("p5"));
         this.optionsCaisses.setP6(var5.getChildText("p6"));
         this.optionsCaisses.setP7(var5.getChildText("p7"));
         this.optionsCaisses.setP8(var5.getChildText("p8"));
         this.optionsCaisses.setP9(var5.getChildText("p9"));
         this.optionsCaisses.setP10(var5.getChildText("p10"));
         if (var5.getChildText("zoneRef1") != null && !var5.getChildText("zoneRef1").isEmpty()) {
            this.optionsCaisses.setZoneRef1(var5.getChildText("zoneRef1"));
         } else {
            this.optionsCaisses.setZoneRef1("0");
         }

         if (var5.getChildText("zoneRef2") != null && !var5.getChildText("zoneRef2").isEmpty()) {
            this.optionsCaisses.setZoneRef2(var5.getChildText("zoneRef2"));
         } else {
            this.optionsCaisses.setZoneRef2("1");
         }

         if (var5.getChildText("zoneLibelle") != null && !var5.getChildText("zoneLibelle").isEmpty()) {
            this.optionsCaisses.setZoneLibelle(var5.getChildText("zoneLibelle"));
         } else {
            this.optionsCaisses.setZoneLibelle("0");
         }

         if (var5.getChildText("zoneRef1Serie") != null && !var5.getChildText("zoneRef1Serie").isEmpty()) {
            this.optionsCaisses.setZoneRef1Serie(var5.getChildText("zoneRef1Serie"));
         } else {
            this.optionsCaisses.setZoneRef1Serie("0");
         }

         if (var5.getChildText("zoneRef2Serie") != null && !var5.getChildText("zoneRef2Serie").isEmpty()) {
            this.optionsCaisses.setZoneRef2Serie(var5.getChildText("zoneRef2Serie"));
         } else {
            this.optionsCaisses.setZoneRef2Serie("0");
         }

         this.optionsCaisses.setLib1ENTETE(var5.getChildText("lib1ENTETE"));
         this.optionsCaisses.setLib2ENTETE(var5.getChildText("lib2ENTETE"));
         this.optionsCaisses.setLib3ENTETE(var5.getChildText("lib3ENTETE"));
         this.optionsCaisses.setLib4ENTETE(var5.getChildText("lib4ENTETE"));
         this.optionsCaisses.setLib5ENTETE(var5.getChildText("lib5ENTETE"));
         this.optionsCaisses.setLib6ENTETE(var5.getChildText("lib6ENTETE"));
         this.optionsCaisses.setLib7ENTETE(var5.getChildText("lib7ENTETE"));
         this.optionsCaisses.setLib8ENTETE(var5.getChildText("lib8ENTETE"));
         this.optionsCaisses.setLib9ENTETE(var5.getChildText("lib9ENTETE"));
         this.optionsCaisses.setLib10ENTETE(var5.getChildText("lib10ENTETE"));
         if (var5.getChildText("axeStructure") != null && !var5.getChildText("axeStructure").isEmpty()) {
            this.optionsCaisses.setAxeStructure(var5.getChildText("axeStructure"));
         } else {
            this.optionsCaisses.setAxeStructure("false");
         }

         if (var5.getChildText("axeSite") != null && !var5.getChildText("axeSite").isEmpty()) {
            this.optionsCaisses.setAxeSite(var5.getChildText("axeSite"));
         } else {
            this.optionsCaisses.setAxeSite("false");
         }

         if (var5.getChildText("axeRegion") != null && !var5.getChildText("axeRegion").isEmpty()) {
            this.optionsCaisses.setAxeRegion(var5.getChildText("axeRegion"));
         } else {
            this.optionsCaisses.setAxeRegion("false");
         }

         if (var5.getChildText("axeUsine") != null && !var5.getChildText("axeUsine").isEmpty()) {
            this.optionsCaisses.setAxeUsine(var5.getChildText("axeUsine"));
         } else {
            this.optionsCaisses.setAxeUsine("false");
         }

         if (var5.getChildText("axeActivite") != null && !var5.getChildText("axeActivite").isEmpty()) {
            this.optionsCaisses.setAxeActivite(var5.getChildText("axeActivite"));
         } else {
            this.optionsCaisses.setAxeActivite("false");
         }

         if (var5.getChildText("axeAgent") != null && !var5.getChildText("axeAgent").isEmpty()) {
            this.optionsCaisses.setAxeAgent(var5.getChildText("axeAgent"));
         } else {
            this.optionsCaisses.setAxeAgent("false");
         }

         if (var5.getChildText("axeChantier") != null && !var5.getChildText("axeChantier").isEmpty()) {
            this.optionsCaisses.setAxeChantier(var5.getChildText("axeChantier"));
         } else {
            this.optionsCaisses.setAxeChantier("false");
         }

         if (var5.getChildText("axeParc") != null && !var5.getChildText("axeParc").isEmpty()) {
            this.optionsCaisses.setAxeParc(var5.getChildText("axeParc"));
         } else {
            this.optionsCaisses.setAxeParc("false");
         }

         if (var5.getChildText("axeMission") != null && !var5.getChildText("axeMission").isEmpty()) {
            this.optionsCaisses.setAxeMission(var5.getChildText("axeMission"));
         } else {
            this.optionsCaisses.setAxeMission("false");
         }

         if (var5.getChildText("axeCles") != null && !var5.getChildText("axeCles").isEmpty()) {
            this.optionsCaisses.setAxeCles(var5.getChildText("axeCles"));
         } else {
            this.optionsCaisses.setAxeCles("false");
         }

         if (var5.getChildText("axeProjet") != null && !var5.getChildText("axeProjet").isEmpty()) {
            this.optionsCaisses.setAxeProjet(var5.getChildText("axeProjet"));
         } else {
            this.optionsCaisses.setAxeProjet("false");
         }

         if (var5.getChildText("axeDossier") != null && !var5.getChildText("axeDossier").isEmpty()) {
            this.optionsCaisses.setAxeDossier(var5.getChildText("axeDossier"));
         } else {
            this.optionsCaisses.setAxeDossier("false");
         }

         var3.close();
      } catch (JDOMException var6) {
      } catch (IOException var7) {
      }

      return this.optionsCaisses;
   }

   public OptionCaisses getOptionsCaisses() {
      return this.optionsCaisses;
   }

   public void setOptionsCaisses(OptionCaisses var1) {
      this.optionsCaisses = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }
}
