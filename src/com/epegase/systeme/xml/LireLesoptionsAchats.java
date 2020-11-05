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

public class LireLesoptionsAchats implements Serializable {
   private long strId;
   private OptionAchats optionAchats;

   public OptionAchats lancer() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "achats" + File.separator + "configuration" + File.separator + "optionAchats.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.optionAchats = new OptionAchats();
         if (var5.getChildText("nbrJrRelanceDA") != null && !var5.getChildText("nbrJrRelanceDA").isEmpty()) {
            this.optionAchats.setNbrJrRelanceDA(var5.getChildText("nbrJrRelanceDA"));
         } else {
            this.optionAchats.setNbrJrRelanceDA("0");
         }

         if (var5.getChildText("nbrJrValidDA") != null && !var5.getChildText("nbrJrValidDA").isEmpty()) {
            this.optionAchats.setNbrJrValidDA(var5.getChildText("nbrJrValidDA"));
         } else {
            this.optionAchats.setNbrJrValidDA("0");
         }

         if (var5.getChildText("affichInTierFilDA") != null && !var5.getChildText("affichInTierFilDA").isEmpty()) {
            this.optionAchats.setAffichInTierFilDA(var5.getChildText("affichInTierFilDA"));
         } else {
            this.optionAchats.setAffichInTierFilDA("100");
         }

         if (var5.getChildText("affichInGlobViewDA") != null && !var5.getChildText("affichInGlobViewDA").isEmpty()) {
            this.optionAchats.setAffichInGlobViewDA(var5.getChildText("affichInGlobViewDA"));
         } else {
            this.optionAchats.setAffichInGlobViewDA("100");
         }

         if (var5.getChildText("nbrJrRelanceCOT") != null && !var5.getChildText("nbrJrRelanceCOT").isEmpty()) {
            this.optionAchats.setNbrJrRelanceCOT(var5.getChildText("nbrJrRelanceCOT"));
         } else {
            this.optionAchats.setNbrJrRelanceCOT("0");
         }

         if (var5.getChildText("nbrJrValidCOT") != null && !var5.getChildText("nbrJrValidCOT").isEmpty()) {
            this.optionAchats.setNbrJrValidCOT(var5.getChildText("nbrJrValidCOT"));
         } else {
            this.optionAchats.setNbrJrValidCOT("0");
         }

         if (var5.getChildText("affichInTierFilCOT") != null && !var5.getChildText("affichInTierFilCOT").isEmpty()) {
            this.optionAchats.setAffichInTierFilCOT(var5.getChildText("affichInTierFilCOT"));
         } else {
            this.optionAchats.setAffichInTierFilCOT("100");
         }

         if (var5.getChildText("affichInGlobViewCOT") != null && !var5.getChildText("affichInGlobViewCOT").isEmpty()) {
            this.optionAchats.setAffichInGlobViewCOT(var5.getChildText("affichInGlobViewCOT"));
         } else {
            this.optionAchats.setAffichInGlobViewCOT("100");
         }

         if (var5.getChildText("affichQtePoidsCOT") != null && !var5.getChildText("affichQtePoidsCOT").isEmpty()) {
            this.optionAchats.setAffichQtePoidsCOT(var5.getChildText("affichQtePoidsCOT"));
         } else {
            this.optionAchats.setAffichQtePoidsCOT("0");
         }

         this.optionAchats.setFraisPrp1(var5.getChildText("fraisPrp1"));
         this.optionAchats.setFraisPrp2(var5.getChildText("fraisPrp2"));
         this.optionAchats.setFraisPrp3(var5.getChildText("fraisPrp3"));
         if (var5.getChildText("tauxRusid") != null && !var5.getChildText("tauxRusid").isEmpty()) {
            this.optionAchats.setTauxRusid(Float.parseFloat(var5.getChildText("tauxRusid")));
         } else {
            this.optionAchats.setTauxRusid(0.0F);
         }

         if (var5.getChildText("tauxReduit") != null && !var5.getChildText("tauxReduit").isEmpty()) {
            this.optionAchats.setTauxReduit(Float.parseFloat(var5.getChildText("tauxReduit")));
         } else {
            this.optionAchats.setTauxReduit(0.0F);
         }

         if (var5.getChildText("nbrJrRelanceCOM") != null && !var5.getChildText("nbrJrRelanceCOM").isEmpty()) {
            this.optionAchats.setNbrJrRelanceCOM(var5.getChildText("nbrJrRelanceCOM"));
         } else {
            this.optionAchats.setNbrJrRelanceCOM("0");
         }

         if (var5.getChildText("nbrJrValidCOM") != null && !var5.getChildText("nbrJrValidCOM").isEmpty()) {
            this.optionAchats.setNbrJrValidCOM(var5.getChildText("nbrJrValidCOM"));
         } else {
            this.optionAchats.setNbrJrValidCOM("0");
         }

         if (var5.getChildText("affichInTierFilCOM") != null && !var5.getChildText("affichInTierFilCOM").isEmpty()) {
            this.optionAchats.setAffichInTierFilCOM(var5.getChildText("affichInTierFilCOM"));
         } else {
            this.optionAchats.setAffichInTierFilCOM("100");
         }

         if (var5.getChildText("affichInGlobViewCOM") != null && !var5.getChildText("affichInGlobViewCOM").isEmpty()) {
            this.optionAchats.setAffichInGlobViewCOM(var5.getChildText("affichInGlobViewCOM"));
         } else {
            this.optionAchats.setAffichInGlobViewCOM("100");
         }

         if (var5.getChildText("affichQtePoidsCOM") != null && !var5.getChildText("affichQtePoidsCOM").isEmpty()) {
            this.optionAchats.setAffichQtePoidsCOM(var5.getChildText("affichQtePoidsCOM"));
         } else {
            this.optionAchats.setAffichQtePoidsCOM("0");
         }

         if (var5.getChildText("budgetCOM") != null && !var5.getChildText("budgetCOM").isEmpty()) {
            this.optionAchats.setBudgetCOM(var5.getChildText("budgetCOM"));
         } else {
            this.optionAchats.setBudgetCOM("0");
         }

         if (var5.getChildText("qteDejaCOM") != null && !var5.getChildText("qteDejaCOM").isEmpty()) {
            this.optionAchats.setQteDejaCOM(var5.getChildText("qteDejaCOM"));
         } else {
            this.optionAchats.setQteDejaCOM("0");
         }

         if (var5.getChildText("nbrJrRelanceREC") != null && !var5.getChildText("nbrJrRelanceREC").isEmpty()) {
            this.optionAchats.setNbrJrRelanceREC(var5.getChildText("nbrJrRelanceREC"));
         } else {
            this.optionAchats.setNbrJrRelanceREC("0");
         }

         if (var5.getChildText("nbrJrValidREC") != null && !var5.getChildText("nbrJrValidREC").isEmpty()) {
            this.optionAchats.setNbrJrValidREC(var5.getChildText("nbrJrValidREC"));
         } else {
            this.optionAchats.setNbrJrValidREC("0");
         }

         if (var5.getChildText("affichInTierFilREC") != null && !var5.getChildText("affichInTierFilREC").isEmpty()) {
            this.optionAchats.setAffichInTierFilREC(var5.getChildText("affichInTierFilREC"));
         } else {
            this.optionAchats.setAffichInTierFilREC("100");
         }

         if (var5.getChildText("affichInGlobViewREC") != null && !var5.getChildText("affichInGlobViewREC").isEmpty()) {
            this.optionAchats.setAffichInGlobViewREC(var5.getChildText("affichInGlobViewREC"));
         } else {
            this.optionAchats.setAffichInGlobViewREC("100");
         }

         if (var5.getChildText("affichQtePoidsREC") != null && !var5.getChildText("affichQtePoidsREC").isEmpty()) {
            this.optionAchats.setAffichQtePoidsREC(var5.getChildText("affichQtePoidsREC"));
         } else {
            this.optionAchats.setAffichQtePoidsREC("0");
         }

         if (var5.getChildText("reacheminementREC") != null && !var5.getChildText("reacheminementREC").isEmpty()) {
            this.optionAchats.setReacheminementREC(var5.getChildText("reacheminementREC"));
         } else {
            this.optionAchats.setReacheminementREC("0");
         }

         if (var5.getChildText("modeCifCfrREC") != null && !var5.getChildText("modeCifCfrREC").isEmpty()) {
            this.optionAchats.setModeCifCfrREC(var5.getChildText("modeCifCfrREC"));
         } else {
            this.optionAchats.setModeCifCfrREC("0");
         }

         if (var5.getChildText("numeroReception") != null && !var5.getChildText("numeroReception").isEmpty()) {
            this.optionAchats.setNumeroReception(var5.getChildText("numeroReception"));
         } else {
            this.optionAchats.setNumeroReception("0");
         }

         if (var5.getChildText("nbrJrRelanceFAC") != null && !var5.getChildText("nbrJrRelanceFAC").isEmpty()) {
            this.optionAchats.setNbrJrRelanceFAC(var5.getChildText("nbrJrRelanceFAC"));
         } else {
            this.optionAchats.setNbrJrRelanceFAC("0");
         }

         if (var5.getChildText("nbrJrValidFAC") != null && !var5.getChildText("nbrJrValidFAC").isEmpty()) {
            this.optionAchats.setNbrJrValidFAC(var5.getChildText("nbrJrValidFAC"));
         } else {
            this.optionAchats.setNbrJrValidFAC("0");
         }

         if (var5.getChildText("affichInTierFilFAC") != null && !var5.getChildText("affichInTierFilFAC").isEmpty()) {
            this.optionAchats.setAffichInTierFilFAC(var5.getChildText("affichInTierFilFAC"));
         } else {
            this.optionAchats.setAffichInTierFilFAC("100");
         }

         if (var5.getChildText("affichInGlobViewFAC") != null && !var5.getChildText("affichInGlobViewFAC").isEmpty()) {
            this.optionAchats.setAffichInGlobViewFAC(var5.getChildText("affichInGlobViewFAC"));
         } else {
            this.optionAchats.setAffichInGlobViewFAC("100");
         }

         if (var5.getChildText("modeCifCfrFAC") != null && !var5.getChildText("modeCifCfrFAC").isEmpty()) {
            this.optionAchats.setModeCifCfrFAC(var5.getChildText("modeCifCfrFAC"));
         } else {
            this.optionAchats.setModeCifCfrFAC("0");
         }

         this.optionAchats.setCompteFretFAC(var5.getChildText("compteFretFAC"));
         this.optionAchats.setCompteAssuranceFAC(var5.getChildText("compteAssuranceFAC"));
         if (var5.getChildText("nbrJrRelanceNOTDEB") != null && !var5.getChildText("nbrJrRelanceNOTDEB").isEmpty()) {
            this.optionAchats.setNbrJrRelanceNOTDEB(var5.getChildText("nbrJrRelanceNOTDEB"));
         } else {
            this.optionAchats.setNbrJrRelanceNOTDEB("0");
         }

         if (var5.getChildText("nbrJrValidNOTDEB") != null && !var5.getChildText("nbrJrValidNOTDEB").isEmpty()) {
            this.optionAchats.setNbrJrValidNOTDEB(var5.getChildText("nbrJrValidNOTDEB"));
         } else {
            this.optionAchats.setNbrJrValidNOTDEB("0");
         }

         if (var5.getChildText("affichInTierFilNOTDEB") != null && !var5.getChildText("affichInTierFilNOTDEB").isEmpty()) {
            this.optionAchats.setAffichInTierFilNOTDEB(var5.getChildText("affichInTierFilNOTDEB"));
         } else {
            this.optionAchats.setAffichInTierFilNOTDEB("100");
         }

         if (var5.getChildText("affichInGlobViewNOTDEB") != null && !var5.getChildText("affichInGlobViewNOTDEB").isEmpty()) {
            this.optionAchats.setAffichInGlobViewNOTDEB(var5.getChildText("affichInGlobViewNOTDEB"));
         } else {
            this.optionAchats.setAffichInGlobViewNOTDEB("100");
         }

         if (var5.getChildText("nbrJrRelanceRETOUR") != null && !var5.getChildText("nbrJrRelanceRETOUR").isEmpty()) {
            this.optionAchats.setNbrJrRelanceRETOUR(var5.getChildText("nbrJrRelanceRETOUR"));
         } else {
            this.optionAchats.setNbrJrRelanceRETOUR("0");
         }

         if (var5.getChildText("nbrJrValidRETOUR") != null && var5.getChildText("nbrJrValidRETOUR").isEmpty()) {
            this.optionAchats.setNbrJrValidRETOUR(var5.getChildText("nbrJrValidRETOUR"));
         } else {
            this.optionAchats.setNbrJrValidRETOUR("0");
         }

         if (var5.getChildText("affichInTierFilRETOUR") != null && !var5.getChildText("affichInTierFilRETOUR").isEmpty()) {
            this.optionAchats.setAffichInTierFilRETOUR(var5.getChildText("affichInTierFilRETOUR"));
         } else {
            this.optionAchats.setAffichInTierFilRETOUR("100");
         }

         if (var5.getChildText("affichInGlobViewRETOUR") != null && !var5.getChildText("affichInGlobViewRETOUR").isEmpty()) {
            this.optionAchats.setAffichInGlobViewRETOUR(var5.getChildText("affichInGlobViewRETOUR"));
         } else {
            this.optionAchats.setAffichInGlobViewRETOUR("100");
         }

         if (var5.getChildText("nbrJrRelanceAVOIR") != null && !var5.getChildText("nbrJrRelanceAVOIR").isEmpty()) {
            this.optionAchats.setNbrJrRelanceAVOIR(var5.getChildText("nbrJrRelanceAVOIR"));
         } else {
            this.optionAchats.setNbrJrRelanceAVOIR("0");
         }

         if (var5.getChildText("nbrJrValidAVOIR") != null && !var5.getChildText("nbrJrValidAVOIR").isEmpty()) {
            this.optionAchats.setNbrJrValidAVOIR(var5.getChildText("nbrJrValidAVOIR"));
         } else {
            this.optionAchats.setNbrJrValidAVOIR("0");
         }

         if (var5.getChildText("affichInTierFilAVOIR") != null && !var5.getChildText("affichInTierFilAVOIR").isEmpty()) {
            this.optionAchats.setAffichInTierFilAVOIR(var5.getChildText("affichInTierFilAVOIR"));
         } else {
            this.optionAchats.setAffichInTierFilAVOIR("100");
         }

         if (var5.getChildText("affichInGlobViewAVOIR") != null && !var5.getChildText("affichInGlobViewAVOIR").isEmpty()) {
            this.optionAchats.setAffichInGlobViewAVOIR(var5.getChildText("affichInGlobViewAVOIR"));
         } else {
            this.optionAchats.setAffichInGlobViewAVOIR("100");
         }

         if (var5.getChildText("nbrJrRelanceFRA") != null && !var5.getChildText("nbrJrRelanceFRA").isEmpty()) {
            this.optionAchats.setNbrJrRelanceFRA(var5.getChildText("nbrJrRelanceFRA"));
         } else {
            this.optionAchats.setNbrJrRelanceFRA("0");
         }

         if (var5.getChildText("nbrJrValidFRA") != null && !var5.getChildText("nbrJrValidFRA").isEmpty()) {
            this.optionAchats.setNbrJrValidFRA(var5.getChildText("nbrJrValidFRA"));
         } else {
            this.optionAchats.setNbrJrValidFRA("0");
         }

         if (var5.getChildText("affichInTierFilFRA") != null && !var5.getChildText("affichInTierFilFRA").isEmpty()) {
            this.optionAchats.setAffichInTierFilFRA(var5.getChildText("affichInTierFilFRA"));
         } else {
            this.optionAchats.setAffichInTierFilFRA("100");
         }

         if (var5.getChildText("affichInGlobViewFRA") != null && !var5.getChildText("affichInGlobViewFRA").isEmpty()) {
            this.optionAchats.setAffichInGlobViewFRA(var5.getChildText("affichInGlobViewFRA"));
         } else {
            this.optionAchats.setAffichInGlobViewFRA("0");
         }

         if (var5.getChildText("chargerFRA") != null && !var5.getChildText("chargerFRA").isEmpty()) {
            this.optionAchats.setChargerFRA(var5.getChildText("chargerFRA"));
         } else {
            this.optionAchats.setChargerFRA("0");
         }

         if (var5.getChildText("affichInGlobViewAffaire") != null && !var5.getChildText("affichInGlobViewAffaire").isEmpty()) {
            this.optionAchats.setAffichInGlobViewAffaire(var5.getChildText("affichInGlobViewAffaire"));
         } else {
            this.optionAchats.setAffichInGlobViewAffaire("0");
         }

         if (var5.getChildText("affichInTierAffaire") != null && !var5.getChildText("affichInTierAffaire").isEmpty()) {
            this.optionAchats.setAffichInTierAffaire(var5.getChildText("affichInTierAffaire"));
         } else {
            this.optionAchats.setAffichInTierAffaire("0");
         }

         if (var5.getChildText("nbrCtrsFamProd") != null && !var5.getChildText("nbrCtrsFamProd").isEmpty()) {
            this.optionAchats.setNbrCtrsFamProd(var5.getChildText("nbrCtrsFamProd"));
         } else {
            this.optionAchats.setNbrCtrsFamProd("3");
         }

         if (var5.getChildText("nbrCtrsProProd") != null && !var5.getChildText("nbrCtrsProProd").isEmpty()) {
            this.optionAchats.setNbrCtrsProProd(var5.getChildText("nbrCtrsProProd"));
         } else {
            this.optionAchats.setNbrCtrsProProd("3");
         }

         if (var5.getChildText("modCalcProd") != null && !var5.getChildText("modCalcProd").isEmpty()) {
            this.optionAchats.setModCalcProd(var5.getChildText("modCalcProd"));
         } else {
            this.optionAchats.setModCalcProd("0");
         }

         if (var5.getChildText("decrmtRabais") != null && !var5.getChildText("decrmtRabais").isEmpty()) {
            this.optionAchats.setDecrmtRabais(var5.getChildText("decrmtRabais"));
         } else {
            this.optionAchats.setDecrmtRabais("0");
         }

         if (var5.getChildText("modCoefPr") != null && !var5.getChildText("modCoefPr").isEmpty()) {
            this.optionAchats.setModCoefPr(var5.getChildText("modCoefPr"));
         } else {
            this.optionAchats.setModCoefPr("0");
         }

         if (var5.getChildText("modCalcPr") != null && !var5.getChildText("modCalcPr").isEmpty()) {
            this.optionAchats.setModCalcPr(var5.getChildText("modCalcPr"));
         } else {
            this.optionAchats.setModCalcPr("0");
         }

         if (var5.getChildText("modCalcPump") != null && !var5.getChildText("modCalcPump").isEmpty()) {
            this.optionAchats.setModCalcPump(var5.getChildText("modCalcPump"));
         } else {
            this.optionAchats.setModCalcPump("0");
         }

         if (var5.getChildText("modDepPump") != null && !var5.getChildText("modDepPump").isEmpty()) {
            this.optionAchats.setModDepPump(var5.getChildText("modDepPump"));
         } else {
            this.optionAchats.setModDepPump("0");
         }

         if (var5.getChildText("modValoPvProd") != null && !var5.getChildText("modValoPvProd").isEmpty()) {
            this.optionAchats.setModValoPvProd(var5.getChildText("modValoPvProd"));
         } else {
            this.optionAchats.setModValoPvProd("0");
         }

         if (var5.getChildText("modValoFret") != null && !var5.getChildText("modValoFret").isEmpty()) {
            this.optionAchats.setModValoFret(var5.getChildText("modValoFret"));
         } else {
            this.optionAchats.setModValoFret("0");
         }

         if (var5.getChildText("analAuto") != null && !var5.getChildText("analAuto").isEmpty()) {
            this.optionAchats.setAnalAuto(var5.getChildText("analAuto"));
         } else {
            this.optionAchats.setAnalAuto("0");
         }

         if (var5.getChildText("nbLigneMax") != null && !var5.getChildText("nbLigneMax").isEmpty()) {
            this.optionAchats.setNbLigneMax(var5.getChildText("nbLigneMax"));
         } else {
            this.optionAchats.setNbLigneMax("100");
         }

         if (var5.getChildText("nbDecQte") != null && !var5.getChildText("nbDecQte").isEmpty()) {
            this.optionAchats.setNbDecQte(var5.getChildText("nbDecQte"));
         } else {
            this.optionAchats.setNbDecQte("0");
         }

         if (var5.getChildText("nbDecPu") != null && !var5.getChildText("nbDecPu").isEmpty()) {
            this.optionAchats.setNbDecPu(var5.getChildText("nbDecPu"));
         } else {
            this.optionAchats.setNbDecPu("0");
         }

         if (var5.getChildText("trfCompta") != null && !var5.getChildText("trfCompta").isEmpty()) {
            this.optionAchats.setTrfCompta(var5.getChildText("trfCompta"));
         } else {
            this.optionAchats.setTrfCompta("0");
         }

         if (var5.getChildText("chargementListe") != null && !var5.getChildText("chargementListe").isEmpty()) {
            this.optionAchats.setChargementListe(var5.getChildText("chargementListe"));
         } else {
            this.optionAchats.setChargementListe("0");
         }

         if (var5.getChildText("activiteEnteteLigne") != null && !var5.getChildText("activiteEnteteLigne").isEmpty()) {
            this.optionAchats.setActiviteEnteteLigne(var5.getChildText("activiteEnteteLigne"));
         } else {
            this.optionAchats.setActiviteEnteteLigne("0");
         }

         if (var5.getChildText("descriptifComplementaire") != null && !var5.getChildText("descriptifComplementaire").isEmpty()) {
            this.optionAchats.setDescriptifComplementaire(var5.getChildText("descriptifComplementaire"));
         } else {
            this.optionAchats.setDescriptifComplementaire("0");
         }

         if (var5.getChildText("dateTransformation") != null && !var5.getChildText("dateTransformation").isEmpty()) {
            this.optionAchats.setDateTransformation(var5.getChildText("dateTransformation"));
         } else {
            this.optionAchats.setDateTransformation("0");
         }

         if (var5.getChildText("photosProduit") != null && !var5.getChildText("photosProduit").isEmpty()) {
            this.optionAchats.setPhotosProduit(var5.getChildText("photosProduit"));
         } else {
            this.optionAchats.setPhotosProduit("0");
         }

         if (var5.getChildText("choixStock") != null && !var5.getChildText("choixStock").isEmpty()) {
            this.optionAchats.setChoixStock(var5.getChildText("choixStock"));
         } else {
            this.optionAchats.setChoixStock("0");
         }

         this.optionAchats.setTvaDefaut(var5.getChildText("tvaDefaut"));
         if (var5.getChildText("paiementAVOIR") != null && !var5.getChildText("paiementAVOIR").isEmpty()) {
            this.optionAchats.setPaiementAVOIR(var5.getChildText("paiementAVOIR"));
         } else {
            this.optionAchats.setPaiementAVOIR("0");
         }

         if (var5.getChildText("transformation") != null && !var5.getChildText("transformation").isEmpty()) {
            this.optionAchats.setTransformation(var5.getChildText("transformation"));
         } else {
            this.optionAchats.setTransformation("0");
         }

         if (var5.getChildText("depotStock") != null && !var5.getChildText("depotStock").isEmpty()) {
            this.optionAchats.setDepotStock(var5.getChildText("depotStock"));
         } else {
            this.optionAchats.setDepotStock("0");
         }

         if (var5.getChildText("modeCalculDevis") != null && !var5.getChildText("modeCalculDevis").isEmpty()) {
            this.optionAchats.setModeCalculDevis(var5.getChildText("modeCalculDevis"));
         } else {
            this.optionAchats.setModeCalculDevis("0");
         }

         if (var5.getChildText("modLibelleProd") != null && !var5.getChildText("modLibelleProd").isEmpty()) {
            this.optionAchats.setModLibelleProd(var5.getChildText("modLibelleProd"));
         } else {
            this.optionAchats.setModLibelleProd("0");
         }

         this.optionAchats.setLib1(var5.getChildText("libelle1"));
         this.optionAchats.setLib2(var5.getChildText("libelle2"));
         this.optionAchats.setLib3(var5.getChildText("libelle3"));
         this.optionAchats.setLib4(var5.getChildText("libelle4"));
         this.optionAchats.setLib5(var5.getChildText("libelle5"));
         this.optionAchats.setLib6(var5.getChildText("libelle6"));
         this.optionAchats.setLib7(var5.getChildText("libelle7"));
         this.optionAchats.setLib8(var5.getChildText("libelle8"));
         this.optionAchats.setLib9(var5.getChildText("libelle9"));
         this.optionAchats.setLib10(var5.getChildText("libelle10"));
         this.optionAchats.setSerie1(var5.getChildText("serie1"));
         this.optionAchats.setSerie2(var5.getChildText("serie2"));
         this.optionAchats.setSerie3(var5.getChildText("serie3"));
         this.optionAchats.setSerie4(var5.getChildText("serie4"));
         this.optionAchats.setSerie5(var5.getChildText("serie5"));
         this.optionAchats.setSerie6(var5.getChildText("serie6"));
         this.optionAchats.setSerie7(var5.getChildText("serie7"));
         this.optionAchats.setSerie8(var5.getChildText("serie8"));
         this.optionAchats.setSerie9(var5.getChildText("serie9"));
         this.optionAchats.setSerie10(var5.getChildText("serie10"));
         this.optionAchats.setSerie11(var5.getChildText("serie11"));
         this.optionAchats.setSerie12(var5.getChildText("serie12"));
         this.optionAchats.setSerie13(var5.getChildText("serie13"));
         this.optionAchats.setSerie14(var5.getChildText("serie14"));
         this.optionAchats.setSerie15(var5.getChildText("serie15"));
         this.optionAchats.setSerie16(var5.getChildText("serie16"));
         this.optionAchats.setSerie17(var5.getChildText("serie17"));
         this.optionAchats.setSerie18(var5.getChildText("serie18"));
         this.optionAchats.setSerie19(var5.getChildText("serie19"));
         this.optionAchats.setSerie20(var5.getChildText("serie20"));
         if (var5.getChildText("zoneRef1") != null && !var5.getChildText("zoneRef1").isEmpty()) {
            this.optionAchats.setZoneRef1(var5.getChildText("zoneRef1"));
         } else {
            this.optionAchats.setZoneRef1("0");
         }

         if (var5.getChildText("zoneRef2") != null && !var5.getChildText("zoneRef2").isEmpty()) {
            this.optionAchats.setZoneRef2(var5.getChildText("zoneRef2"));
         } else {
            this.optionAchats.setZoneRef2("1");
         }

         if (var5.getChildText("zoneLibelle") != null && !var5.getChildText("zoneLibelle").isEmpty()) {
            this.optionAchats.setZoneLibelle(var5.getChildText("zoneLibelle"));
         } else {
            this.optionAchats.setZoneLibelle("0");
         }

         if (var5.getChildText("zoneLibelleSuite") != null && !var5.getChildText("zoneLibelleSuite").isEmpty()) {
            this.optionAchats.setZoneLibelleSuite(var5.getChildText("zoneLibelleSuite"));
         } else {
            this.optionAchats.setZoneLibelleSuite("0");
         }

         if (var5.getChildText("zoneRef1Serie") != null && !var5.getChildText("zoneRef1Serie").isEmpty()) {
            this.optionAchats.setZoneRef1Serie(var5.getChildText("zoneRef1Serie"));
         } else {
            this.optionAchats.setZoneRef1Serie("0");
         }

         if (var5.getChildText("zoneRef2Serie") != null && !var5.getChildText("zoneRef2Serie").isEmpty()) {
            this.optionAchats.setZoneRef2Serie(var5.getChildText("zoneRef2Serie"));
         } else {
            this.optionAchats.setZoneRef2Serie("0");
         }

         if (var5.getChildText("transfertDocument") != null && !var5.getChildText("transfertDocument").isEmpty()) {
            this.optionAchats.setTransfertDocument(var5.getChildText("transfertDocument"));
         } else {
            this.optionAchats.setTransfertDocument("0");
         }

         if (var5.getChildText("axeStructure") != null && !var5.getChildText("axeStructure").isEmpty()) {
            this.optionAchats.setAxeStructure(var5.getChildText("axeStructure"));
         } else {
            this.optionAchats.setAxeStructure("false");
         }

         if (var5.getChildText("axeSite") != null && !var5.getChildText("axeSite").isEmpty()) {
            this.optionAchats.setAxeSite(var5.getChildText("axeSite"));
         } else {
            this.optionAchats.setAxeSite("false");
         }

         if (var5.getChildText("axeRegion") != null && !var5.getChildText("axeRegion").isEmpty()) {
            this.optionAchats.setAxeRegion(var5.getChildText("axeRegion"));
         } else {
            this.optionAchats.setAxeRegion("false");
         }

         if (var5.getChildText("axeUsine") != null && !var5.getChildText("axeUsine").isEmpty()) {
            this.optionAchats.setAxeUsine(var5.getChildText("axeUsine"));
         } else {
            this.optionAchats.setAxeUsine("false");
         }

         if (var5.getChildText("axeActivite") != null && !var5.getChildText("axeActivite").isEmpty()) {
            this.optionAchats.setAxeActivite(var5.getChildText("axeActivite"));
         } else {
            this.optionAchats.setAxeActivite("false");
         }

         if (var5.getChildText("axeAgent") != null && !var5.getChildText("axeAgent").isEmpty()) {
            this.optionAchats.setAxeAgent(var5.getChildText("axeAgent"));
         } else {
            this.optionAchats.setAxeAgent("false");
         }

         if (var5.getChildText("axeChantier") != null && !var5.getChildText("axeChantier").isEmpty()) {
            this.optionAchats.setAxeChantier(var5.getChildText("axeChantier"));
         } else {
            this.optionAchats.setAxeChantier("false");
         }

         if (var5.getChildText("axeParc") != null && !var5.getChildText("axeParc").isEmpty()) {
            this.optionAchats.setAxeParc(var5.getChildText("axeParc"));
         } else {
            this.optionAchats.setAxeParc("false");
         }

         if (var5.getChildText("axeMission") != null && !var5.getChildText("axeMission").isEmpty()) {
            this.optionAchats.setAxeMission(var5.getChildText("axeMission"));
         } else {
            this.optionAchats.setAxeMission("false");
         }

         if (var5.getChildText("axeCles") != null && !var5.getChildText("axeCles").isEmpty()) {
            this.optionAchats.setAxeCles(var5.getChildText("axeCles"));
         } else {
            this.optionAchats.setAxeCles("false");
         }

         if (var5.getChildText("axeProjet") != null && !var5.getChildText("axeProjet").isEmpty()) {
            this.optionAchats.setAxeProjet(var5.getChildText("axeProjet"));
         } else {
            this.optionAchats.setAxeProjet("false");
         }

         if (var5.getChildText("axeDossier") != null && !var5.getChildText("axeDossier").isEmpty()) {
            this.optionAchats.setAxeDossier(var5.getChildText("axeDossier"));
         } else {
            this.optionAchats.setAxeDossier("0");
         }

         var3.close();
      } catch (JDOMException var6) {
      } catch (IOException var7) {
      }

      return this.optionAchats;
   }

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }
}
