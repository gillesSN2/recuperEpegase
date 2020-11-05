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

public class LireLesoptionsVentes implements Serializable {
   private long strId;
   private OptionVentes optionsVentes;

   public OptionVentes lancer() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "ventes" + File.separator + "configuration" + File.separator + "optionVentes.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.optionsVentes = new OptionVentes();
         if (var5.getChildText("activiteEnteteLigne") != null && !var5.getChildText("activiteEnteteLigne").isEmpty()) {
            this.optionsVentes.setActiviteEnteteLigne(var5.getChildText("activiteEnteteLigne"));
         } else {
            this.optionsVentes.setActiviteEnteteLigne("0");
         }

         if (var5.getChildText("nbrJrRelanceBESOIN") != null && !var5.getChildText("nbrJrRelanceBESOIN").isEmpty()) {
            this.optionsVentes.setNbrJrRelanceBESOIN(var5.getChildText("nbrJrRelanceBESOIN"));
         } else {
            this.optionsVentes.setNbrJrRelanceBESOIN("0");
         }

         if (var5.getChildText("nbrJrValidBESOIN") != null && !var5.getChildText("nbrJrValidBESOIN").isEmpty()) {
            this.optionsVentes.setNbrJrValidBESOIN(var5.getChildText("nbrJrValidBESOIN"));
         } else {
            this.optionsVentes.setNbrJrValidBESOIN("0");
         }

         if (var5.getChildText("affichInTierFilBESOIN") != null && !var5.getChildText("affichInTierFilBESOIN").isEmpty()) {
            this.optionsVentes.setAffichInTierFilBESOIN(var5.getChildText("affichInTierFilBESOIN"));
         } else {
            this.optionsVentes.setAffichInTierFilBESOIN("100");
         }

         if (var5.getChildText("affichInGlobViewBESOIN") != null && !var5.getChildText("affichInGlobViewBESOIN").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewBESOIN(var5.getChildText("affichInGlobViewBESOIN"));
         } else {
            this.optionsVentes.setAffichInGlobViewBESOIN("100");
         }

         if (var5.getChildText("nbrJrRelanceSIMUL") != null && !var5.getChildText("nbrJrRelanceSIMUL").isEmpty()) {
            this.optionsVentes.setNbrJrRelanceSIMUL(var5.getChildText("nbrJrRelanceSIMUL"));
         } else {
            this.optionsVentes.setNbrJrRelanceSIMUL("0");
         }

         if (var5.getChildText("nbrJrValidSIMUL") != null && !var5.getChildText("nbrJrValidSIMUL").isEmpty()) {
            this.optionsVentes.setNbrJrValidSIMUL(var5.getChildText("nbrJrValidSIMUL"));
         } else {
            this.optionsVentes.setNbrJrValidSIMUL("0");
         }

         if (var5.getChildText("affichInTierFilSIMUL") != null && !var5.getChildText("affichInTierFilSIMUL").isEmpty()) {
            this.optionsVentes.setAffichInTierFilSIMUL(var5.getChildText("affichInTierFilSIMUL"));
         } else {
            this.optionsVentes.setAffichInTierFilSIMUL("100");
         }

         if (var5.getChildText("affichInGlobViewSIMUL") != null && !var5.getChildText("affichInGlobViewSIMUL").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewSIMUL(var5.getChildText("affichInGlobViewSIMUL"));
         } else {
            this.optionsVentes.setAffichInGlobViewSIMUL("100");
         }

         this.optionsVentes.setFamilleProduitSIMUL(var5.getChildText("familleProduitSIMUL"));
         if (var5.getChildText("affichInGlobViewAffaire") != null && !var5.getChildText("affichInGlobViewAffaire").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewAffaire(var5.getChildText("affichInGlobViewAffaire"));
         } else {
            this.optionsVentes.setAffichInGlobViewAffaire("0");
         }

         if (var5.getChildText("affichInTierAffaire") != null && !var5.getChildText("affichInTierAffaire").isEmpty()) {
            this.optionsVentes.setAffichInTierAffaire(var5.getChildText("affichInTierAffaire"));
         } else {
            this.optionsVentes.setAffichInTierAffaire("0");
         }

         if (var5.getChildText("nbrJrRelanceDEVIS") != null && !var5.getChildText("nbrJrRelanceDEVIS").isEmpty()) {
            this.optionsVentes.setNbrJrRelanceDEVIS(var5.getChildText("nbrJrRelanceDEVIS"));
         } else {
            this.optionsVentes.setNbrJrRelanceDEVIS("0");
         }

         if (var5.getChildText("nbrJrValidDEVIS") != null && !var5.getChildText("nbrJrValidDEVIS").isEmpty()) {
            this.optionsVentes.setNbrJrValidDEVIS(var5.getChildText("nbrJrValidDEVIS"));
         } else {
            this.optionsVentes.setNbrJrValidDEVIS("0");
         }

         if (var5.getChildText("affichInTierFilDEVIS") != null && !var5.getChildText("affichInTierFilDEVIS").isEmpty()) {
            this.optionsVentes.setAffichInTierFilDEVIS(var5.getChildText("affichInTierFilDEVIS"));
         } else {
            this.optionsVentes.setAffichInTierFilDEVIS("100");
         }

         if (var5.getChildText("affichInGlobViewDEVIS") != null && !var5.getChildText("affichInGlobViewDEVIS").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewDEVIS(var5.getChildText("affichInGlobViewDEVIS"));
         } else {
            this.optionsVentes.setAffichInGlobViewDEVIS("100");
         }

         if (var5.getChildText("validationDevisBcCOM") != null && !var5.getChildText("validationDevisBcCOM").isEmpty()) {
            this.optionsVentes.setValidationDevisBcCOM(var5.getChildText("validationDevisBcCOM"));
         } else {
            this.optionsVentes.setValidationDevisBcCOM("0");
         }

         if (var5.getChildText("modeCalculDevis") != null && !var5.getChildText("modeCalculDevis").isEmpty()) {
            this.optionsVentes.setModeCalculDevis(var5.getChildText("modeCalculDevis"));
         } else {
            this.optionsVentes.setModeCalculDevis("0");
         }

         if (var5.getChildText("nbrJrRelanceCOM") != null && !var5.getChildText("nbrJrRelanceCOM").isEmpty()) {
            this.optionsVentes.setNbrJrRelanceCOM(var5.getChildText("nbrJrRelanceCOM"));
         } else {
            this.optionsVentes.setNbrJrRelanceCOM("0");
         }

         if (var5.getChildText("nbrJrValidCOM") != null && !var5.getChildText("nbrJrValidCOM").isEmpty()) {
            this.optionsVentes.setNbrJrValidCOM(var5.getChildText("nbrJrValidCOM"));
         } else {
            this.optionsVentes.setNbrJrValidCOM("0");
         }

         if (var5.getChildText("affichInTierFilCOM") != null && !var5.getChildText("affichInTierFilCOM").isEmpty()) {
            this.optionsVentes.setAffichInTierFilCOM(var5.getChildText("affichInTierFilCOM"));
         } else {
            this.optionsVentes.setAffichInTierFilCOM("100");
         }

         if (var5.getChildText("affichInGlobViewCOM") != null && !var5.getChildText("affichInGlobViewCOM").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewCOM(var5.getChildText("affichInGlobViewCOM"));
         } else {
            this.optionsVentes.setAffichInGlobViewCOM("100");
         }

         if (var5.getChildText("impressionBcBlCOM") != null && !var5.getChildText("impressionBcBlCOM").isEmpty()) {
            this.optionsVentes.setImpressionBcBlCOM(var5.getChildText("impressionBcBlCOM"));
         } else {
            this.optionsVentes.setImpressionBcBlCOM("0");
         }

         if (var5.getChildText("validationBcBlCOM") != null && !var5.getChildText("validationBcBlCOM").isEmpty()) {
            this.optionsVentes.setValidationBcBlCOM(var5.getChildText("validationBcBlCOM"));
         } else {
            this.optionsVentes.setValidationBcBlCOM("0");
         }

         if (var5.getChildText("generationBcFab") != null && !var5.getChildText("generationBcFab").isEmpty()) {
            this.optionsVentes.setGenerationBcFab(var5.getChildText("generationBcFab"));
         } else {
            this.optionsVentes.setGenerationBcFab("0");
         }

         if (var5.getChildText("gestionStockBc") != null && !var5.getChildText("gestionStockBc").isEmpty()) {
            this.optionsVentes.setGestionStockBc(var5.getChildText("gestionStockBc"));
         } else {
            this.optionsVentes.setGestionStockBc("0");
         }

         if (var5.getChildText("gestionPlafondBc") != null && !var5.getChildText("gestionPlafondBc").isEmpty()) {
            this.optionsVentes.setGestionPlafondBc(var5.getChildText("gestionPlafondBc"));
         } else {
            this.optionsVentes.setGestionPlafondBc("0");
         }

         if (var5.getChildText("nbrJrRelanceLIV") != null && !var5.getChildText("nbrJrRelanceLIV").isEmpty()) {
            this.optionsVentes.setNbrJrRelanceLIV(var5.getChildText("nbrJrRelanceLIV"));
         } else {
            this.optionsVentes.setNbrJrRelanceLIV("0");
         }

         if (var5.getChildText("nbrJrValidLIV") != null && !var5.getChildText("nbrJrValidLIV").isEmpty()) {
            this.optionsVentes.setNbrJrValidLIV(var5.getChildText("nbrJrValidLIV"));
         } else {
            this.optionsVentes.setNbrJrValidLIV("0");
         }

         if (var5.getChildText("affichInTierFilLIV") != null && !var5.getChildText("affichInTierFilLIV").isEmpty()) {
            this.optionsVentes.setAffichInTierFilLIV(var5.getChildText("affichInTierFilLIV"));
         } else {
            this.optionsVentes.setAffichInTierFilLIV("100");
         }

         if (var5.getChildText("affichInGlobViewLIV") != null && !var5.getChildText("affichInGlobViewLIV").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewLIV(var5.getChildText("affichInGlobViewLIV"));
         } else {
            this.optionsVentes.setAffichInGlobViewLIV("100");
         }

         if (var5.getChildText("gestionLivreur") != null && !var5.getChildText("gestionLivreur").isEmpty()) {
            this.optionsVentes.setGestionLivreur(var5.getChildText("gestionLivreur"));
         } else {
            this.optionsVentes.setGestionLivreur("0");
         }

         if (var5.getChildText("nbrJrRelanceFAC") != null && !var5.getChildText("nbrJrRelanceFAC").isEmpty()) {
            this.optionsVentes.setNbrJrRelanceFAC(var5.getChildText("nbrJrRelanceFAC"));
         } else {
            this.optionsVentes.setNbrJrRelanceFAC("0");
         }

         if (var5.getChildText("nbrJrValidFAC") != null && !var5.getChildText("nbrJrValidFAC").isEmpty()) {
            this.optionsVentes.setNbrJrValidFAC(var5.getChildText("nbrJrValidFAC"));
         } else {
            this.optionsVentes.setNbrJrValidFAC("0");
         }

         if (var5.getChildText("affichInTierFilFAC") != null && !var5.getChildText("affichInTierFilFAC").isEmpty()) {
            this.optionsVentes.setAffichInTierFilFAC(var5.getChildText("affichInTierFilFAC"));
         } else {
            this.optionsVentes.setAffichInTierFilFAC("100");
         }

         if (var5.getChildText("affichInGlobViewFAC") != null && !var5.getChildText("affichInGlobViewFAC").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewFAC(var5.getChildText("affichInGlobViewFAC"));
         } else {
            this.optionsVentes.setAffichInGlobViewFAC("100");
         }

         if (var5.getChildText("numBlFac") != null && !var5.getChildText("numBlFac").isEmpty()) {
            this.optionsVentes.setNumBlFac(Integer.parseInt(var5.getChildText("numBlFac")));
         } else {
            this.optionsVentes.setNumBlFac(0);
         }

         if (var5.getChildText("gestionPlafondFac") != null && !var5.getChildText("gestionPlafondFac").isEmpty()) {
            this.optionsVentes.setGestionPlafondFac(var5.getChildText("gestionPlafondFac"));
         } else {
            this.optionsVentes.setGestionPlafondFac("0");
         }

         if (var5.getChildText("gestionImpressionFac") != null && !var5.getChildText("gestionImpressionFac").isEmpty()) {
            this.optionsVentes.setGestionImpressionFac(var5.getChildText("gestionImpressionFac"));
         } else {
            this.optionsVentes.setGestionImpressionFac("0");
         }

         if (var5.getChildText("gestionNumeroFac") != null && !var5.getChildText("gestionNumeroFac").isEmpty()) {
            this.optionsVentes.setGestionNumeroFac(var5.getChildText("gestionNumeroFac"));
         } else {
            this.optionsVentes.setGestionNumeroFac("0");
         }

         if (var5.getChildText("nbrJrRelanceNOTDEB") != null && !var5.getChildText("nbrJrRelanceNOTDEB").isEmpty()) {
            this.optionsVentes.setNbrJrRelanceNOTDEB(var5.getChildText("nbrJrRelanceNOTDEB"));
         } else {
            this.optionsVentes.setNbrJrRelanceNOTDEB("0");
         }

         if (var5.getChildText("nbrJrValidNOTDEB") != null && !var5.getChildText("nbrJrValidNOTDEB").isEmpty()) {
            this.optionsVentes.setNbrJrValidNOTDEB(var5.getChildText("nbrJrValidNOTDEB"));
         } else {
            this.optionsVentes.setNbrJrValidNOTDEB("0");
         }

         if (var5.getChildText("affichInTierFilNOTDEB") != null && !var5.getChildText("affichInTierFilNOTDEB").isEmpty()) {
            this.optionsVentes.setAffichInTierFilNOTDEB(var5.getChildText("affichInTierFilNOTDEB"));
         } else {
            this.optionsVentes.setAffichInTierFilNOTDEB("100");
         }

         if (var5.getChildText("affichInGlobViewNOTDEB") != null && !var5.getChildText("affichInGlobViewNOTDEB").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewNOTDEB(var5.getChildText("affichInGlobViewNOTDEB"));
         } else {
            this.optionsVentes.setAffichInGlobViewNOTDEB("100");
         }

         if (var5.getChildText("gestionPlafondNdb") != null && !var5.getChildText("gestionPlafondNdb").isEmpty()) {
            this.optionsVentes.setGestionPlafondNdb(var5.getChildText("gestionPlafondNdb"));
         } else {
            this.optionsVentes.setGestionPlafondNdb("0");
         }

         if (var5.getChildText("nbrJrRelanceRETOUR") != null && !var5.getChildText("nbrJrRelanceRETOUR").isEmpty()) {
            this.optionsVentes.setNbrJrRelanceRETOUR(var5.getChildText("nbrJrRelanceRETOUR"));
         } else {
            this.optionsVentes.setNbrJrRelanceRETOUR("0");
         }

         if (var5.getChildText("nbrJrValidRETOUR") != null && !var5.getChildText("nbrJrValidRETOUR").isEmpty()) {
            this.optionsVentes.setNbrJrValidRETOUR(var5.getChildText("nbrJrValidRETOUR"));
         } else {
            this.optionsVentes.setNbrJrValidRETOUR("0");
         }

         if (var5.getChildText("affichInTierFilRETOUR") != null && !var5.getChildText("affichInTierFilRETOUR").isEmpty()) {
            this.optionsVentes.setAffichInTierFilRETOUR(var5.getChildText("affichInTierFilRETOUR"));
         } else {
            this.optionsVentes.setAffichInTierFilRETOUR("100");
         }

         if (var5.getChildText("affichInGlobViewRETOUR") != null && !var5.getChildText("affichInGlobViewRETOUR").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewRETOUR(var5.getChildText("affichInGlobViewRETOUR"));
         } else {
            this.optionsVentes.setAffichInGlobViewRETOUR("100");
         }

         if (var5.getChildText("nbrJrRelanceAVOIR") != null && !var5.getChildText("nbrJrRelanceAVOIR").isEmpty()) {
            this.optionsVentes.setNbrJrRelanceAVOIR(var5.getChildText("nbrJrRelanceAVOIR"));
         } else {
            this.optionsVentes.setNbrJrRelanceAVOIR("0");
         }

         if (var5.getChildText("nbrJrValidAVOIR") != null && !var5.getChildText("nbrJrValidAVOIR").isEmpty()) {
            this.optionsVentes.setNbrJrValidAVOIR(var5.getChildText("nbrJrValidAVOIR"));
         } else {
            this.optionsVentes.setNbrJrValidAVOIR("0");
         }

         if (var5.getChildText("affichInTierFilAVOIR") != null && !var5.getChildText("affichInTierFilAVOIR").isEmpty()) {
            this.optionsVentes.setAffichInTierFilAVOIR(var5.getChildText("affichInTierFilAVOIR"));
         } else {
            this.optionsVentes.setAffichInTierFilAVOIR("100");
         }

         if (var5.getChildText("affichInGlobViewAVOIR") != null && !var5.getChildText("affichInGlobViewAVOIR").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewAVOIR(var5.getChildText("affichInGlobViewAVOIR"));
         } else {
            this.optionsVentes.setAffichInGlobViewAVOIR("100");
         }

         if (var5.getChildText("paiementAVOIR") != null && !var5.getChildText("paiementAVOIR").isEmpty()) {
            this.optionsVentes.setPaiementAVOIR(var5.getChildText("paiementAVOIR"));
         } else {
            this.optionsVentes.setPaiementAVOIR("0");
         }

         if (var5.getChildText("modeAvoir") != null && !var5.getChildText("modeAvoir").isEmpty()) {
            this.optionsVentes.setModeAvoir(var5.getChildText("modeAvoir"));
         } else {
            this.optionsVentes.setModeAvoir("0");
         }

         if (var5.getChildText("affichInGlobViewCh") != null && !var5.getChildText("affichInGlobViewCh").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewCh(var5.getChildText("affichInGlobViewCh"));
         } else {
            this.optionsVentes.setAffichInGlobViewCh("0");
         }

         this.optionsVentes.setDepotChargementDefaut(var5.getChildText("depotChargementDefaut"));
         if (var5.getChildText("affichInGlobViewCOMMISSION") != null && !var5.getChildText("affichInGlobViewCOMMISSION").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewCOMMISSION(var5.getChildText("affichInGlobViewCOMMISSION"));
         } else {
            this.optionsVentes.setAffichInGlobViewCOMMISSION("100");
         }

         if (var5.getChildText("facture") != null && !var5.getChildText("facture").isEmpty()) {
            this.optionsVentes.setFacture(var5.getChildText("facture"));
         } else {
            this.optionsVentes.setFacture("false");
         }

         if (var5.getChildText("avoir") != null && !var5.getChildText("avoir").isEmpty()) {
            this.optionsVentes.setAvoir(var5.getChildText("avoir"));
         } else {
            this.optionsVentes.setAvoir("false");
         }

         if (var5.getChildText("noteDebit") != null && !var5.getChildText("noteDebit").isEmpty()) {
            this.optionsVentes.setNoteDebit(var5.getChildText("noteDebit"));
         } else {
            this.optionsVentes.setNoteDebit("false");
         }

         this.optionsVentes.setModeCommission(var5.getChildText("modeCommission"));
         this.optionsVentes.setCompteDebit(var5.getChildText("compteDebit"));
         if (var5.getChildText("gestRegSectPdvBLC") != null && !var5.getChildText("gestRegSectPdvBLC").isEmpty()) {
            this.optionsVentes.setGestRegSectPdvBLC(var5.getChildText("gestRegSectPdvBLC"));
         } else {
            this.optionsVentes.setGestRegSectPdvBLC("false");
         }

         if (var5.getChildText("gestActBLC") != null && !var5.getChildText("gestActBLC").isEmpty()) {
            this.optionsVentes.setGestActBLC(var5.getChildText("gestActBLC"));
         } else {
            this.optionsVentes.setGestActBLC("false");
         }

         if (var5.getChildText("affichInTierFilBLC") != null && !var5.getChildText("affichInTierFilBLC").isEmpty()) {
            this.optionsVentes.setAffichInTierFilBLC(var5.getChildText("affichInTierFilBLC"));
         } else {
            this.optionsVentes.setAffichInTierFilBLC("100");
         }

         if (var5.getChildText("affichInGlobViewBLC") != null && !var5.getChildText("affichInGlobViewBLC").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewBLC(var5.getChildText("affichInGlobViewBLC"));
         } else {
            this.optionsVentes.setAffichInGlobViewBLC("100");
         }

         if (var5.getChildText("gestRegSectPdvFACTC") != null && !var5.getChildText("gestRegSectPdvFACTC").isEmpty()) {
            this.optionsVentes.setGestRegSectPdvFACTC(var5.getChildText("gestRegSectPdvFACTC"));
         } else {
            this.optionsVentes.setGestRegSectPdvFACTC("false");
         }

         if (var5.getChildText("gestActFACTC") != null && var5.getChildText("gestActFACTC").isEmpty()) {
            this.optionsVentes.setGestActFACTC(var5.getChildText("gestActFACTC"));
         } else {
            this.optionsVentes.setGestActFACTC("false");
         }

         if (var5.getChildText("affichInTierFilFACTC") != null && !var5.getChildText("affichInTierFilFACTC").isEmpty()) {
            this.optionsVentes.setAffichInTierFilFACTC(var5.getChildText("affichInTierFilFACTC"));
         } else {
            this.optionsVentes.setAffichInTierFilFACTC("100");
         }

         if (var5.getChildText("affichInGlobViewFACTC") != null && !var5.getChildText("affichInGlobViewFACTC").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewFACTC(var5.getChildText("affichInGlobViewFACTC"));
         } else {
            this.optionsVentes.setAffichInGlobViewFACTC("100");
         }

         if (var5.getChildText("gestRegSectPdvTICKC") != null && !var5.getChildText("gestRegSectPdvTICKC").isEmpty()) {
            this.optionsVentes.setGestRegSectPdvTICKC(var5.getChildText("gestRegSectPdvTICKC"));
         } else {
            this.optionsVentes.setGestRegSectPdvTICKC("false");
         }

         if (var5.getChildText("gestActTICKC") != null && !var5.getChildText("gestActTICKC").isEmpty()) {
            this.optionsVentes.setGestActTICKC(var5.getChildText("gestActTICKC"));
         } else {
            this.optionsVentes.setGestActTICKC("false");
         }

         if (var5.getChildText("affichInTierFilTICKC") != null && !var5.getChildText("affichInTierFilTICKC").isEmpty()) {
            this.optionsVentes.setAffichInTierFilTICKC(var5.getChildText("affichInTierFilTICKC"));
         } else {
            this.optionsVentes.setAffichInTierFilTICKC("100");
         }

         if (var5.getChildText("affichInGlobViewTICKC") != null && !var5.getChildText("affichInGlobViewTICKC").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewTICKC(var5.getChildText("affichInGlobViewTICKC"));
         } else {
            this.optionsVentes.setAffichInGlobViewTICKC("100");
         }

         this.optionsVentes.setCaisseDefaut(var5.getChildText("caisseDefaut"));
         if (var5.getChildText("caisseLivreur") != null && !var5.getChildText("caisseLivreur").isEmpty()) {
            this.optionsVentes.setCaisseLivreur(var5.getChildText("caisseLivreur"));
         } else {
            this.optionsVentes.setCaisseLivreur("0");
         }

         if (var5.getChildText("caisseTable") != null && !var5.getChildText("caisseTable").isEmpty()) {
            this.optionsVentes.setCaisseTable(var5.getChildText("caisseTable"));
         } else {
            this.optionsVentes.setCaisseTable("0");
         }

         if (var5.getChildText("caisseChambre") != null && !var5.getChildText("caisseChambre").isEmpty()) {
            this.optionsVentes.setCaisseChambre(var5.getChildText("caisseChambre"));
         } else {
            this.optionsVentes.setCaisseChambre("0");
         }

         if (var5.getChildText("caisseStock") != null && !var5.getChildText("caisseStock").isEmpty()) {
            this.optionsVentes.setCaisseStock(var5.getChildText("caisseStock"));
         } else {
            this.optionsVentes.setCaisseStock("0");
         }

         if (var5.getChildText("nbrCaracteresFamPRO") != null && !var5.getChildText("nbrCaracteresFamPRO").isEmpty()) {
            this.optionsVentes.setNbrCaracteresFamPRO(var5.getChildText("nbrCaracteresFamPRO"));
         } else {
            this.optionsVentes.setNbrCaracteresFamPRO("1");
         }

         if (var5.getChildText("nbrCaracteresProPRO") != null && !var5.getChildText("nbrCaracteresProPRO").isEmpty()) {
            this.optionsVentes.setNbrCaracteresProPRO(var5.getChildText("nbrCaracteresProPRO"));
         } else {
            this.optionsVentes.setNbrCaracteresProPRO("1");
         }

         if (var5.getChildText("modCalcProPRO") != null && !var5.getChildText("modCalcProPRO").isEmpty()) {
            this.optionsVentes.setModCalcProPRO(var5.getChildText("modCalcProPRO"));
         } else {
            this.optionsVentes.setModCalcProPRO("0");
         }

         if (var5.getChildText("nbDecQte") != null && !var5.getChildText("nbDecQte").isEmpty()) {
            this.optionsVentes.setNbDecQte(var5.getChildText("nbDecQte"));
         } else {
            this.optionsVentes.setNbDecQte("0");
         }

         if (var5.getChildText("nbDecPu") != null && !var5.getChildText("nbDecPu").isEmpty()) {
            this.optionsVentes.setNbDecPu(var5.getChildText("nbDecPu"));
         } else {
            this.optionsVentes.setNbDecPu("0");
         }

         if (var5.getChildText("decrmtPriVteStock") != null && !var5.getChildText("decrmtPriVteStock").isEmpty()) {
            this.optionsVentes.setDecrmtPriVteStock(var5.getChildText("decrmtPriVteStock"));
         } else {
            this.optionsVentes.setDecrmtPriVteStock("1");
         }

         if (var5.getChildText("decrmtRabais") != null && !var5.getChildText("decrmtRabais").isEmpty()) {
            this.optionsVentes.setDecrmtRabais(var5.getChildText("decrmtRabais"));
         } else {
            this.optionsVentes.setDecrmtRabais("0");
         }

         if (var5.getChildText("decrmtPrsChrStock") != null && !var5.getChildText("decrmtPrsChrStock").isEmpty()) {
            this.optionsVentes.setDecrmtPrsChrStock(var5.getChildText("decrmtPrsChrStock"));
         } else {
            this.optionsVentes.setDecrmtPrsChrStock("1");
         }

         if (var5.getChildText("analAuto") != null && !var5.getChildText("analAuto").isEmpty()) {
            this.optionsVentes.setAnalAuto(var5.getChildText("analAuto"));
         } else {
            this.optionsVentes.setAnalAuto("0");
         }

         if (var5.getChildText("nbLigneMax") != null && !var5.getChildText("nbLigneMax").isEmpty()) {
            this.optionsVentes.setNbLigneMax(var5.getChildText("nbLigneMax"));
         } else {
            this.optionsVentes.setNbLigneMax("100");
         }

         if (var5.getChildText("libProduit") != null && !var5.getChildText("libProduit").isEmpty()) {
            this.optionsVentes.setLibProduit(var5.getChildText("libProduit"));
         } else {
            this.optionsVentes.setLibProduit("1");
         }

         if (var5.getChildText("responsable") != null && !var5.getChildText("responsable").isEmpty()) {
            this.optionsVentes.setResponsable(var5.getChildText("responsable"));
         } else {
            this.optionsVentes.setResponsable("0");
         }

         if (var5.getChildText("produitGenerique") != null && !var5.getChildText("produitGenerique").isEmpty()) {
            this.optionsVentes.setProduitGenerique(var5.getChildText("produitGenerique"));
         } else {
            this.optionsVentes.setProduitGenerique("0");
         }

         if (var5.getChildText("photosProduit") != null && !var5.getChildText("photosProduit").isEmpty()) {
            this.optionsVentes.setPhotosProduit(var5.getChildText("photosProduit"));
         } else {
            this.optionsVentes.setPhotosProduit("0");
         }

         if (var5.getChildText("chargementListe") != null && !var5.getChildText("chargementListe").isEmpty()) {
            this.optionsVentes.setChargementListe(var5.getChildText("chargementListe"));
         } else {
            this.optionsVentes.setChargementListe("0");
         }

         if (var5.getChildText("descriptifComplementaire") != null && !var5.getChildText("descriptifComplementaire").isEmpty()) {
            this.optionsVentes.setDescriptifComplementaire(var5.getChildText("descriptifComplementaire"));
         } else {
            this.optionsVentes.setDescriptifComplementaire("0");
         }

         if (var5.getChildText("dateTransformation") != null && !var5.getChildText("dateTransformation").isEmpty()) {
            this.optionsVentes.setDateTransformation(var5.getChildText("dateTransformation"));
         } else {
            this.optionsVentes.setDateTransformation("0");
         }

         if (var5.getChildText("libelleProduit") != null && !var5.getChildText("libelleProduit").isEmpty()) {
            this.optionsVentes.setLibelleProduit(var5.getChildText("libelleProduit"));
         } else {
            this.optionsVentes.setLibelleProduit("0");
         }

         this.optionsVentes.setTvaDefaut(var5.getChildText("tvaDefaut"));
         this.optionsVentes.setTlvDefaut(var5.getChildText("tlvDefaut"));
         this.optionsVentes.setTomDefaut(var5.getChildText("tomDefaut"));
         this.optionsVentes.setIrppDefaut(var5.getChildText("irppDefaut"));
         if (var5.getChildText("produitAchat") != null && !var5.getChildText("produitAchat").isEmpty()) {
            this.optionsVentes.setProduitAchat(var5.getChildText("produitAchat"));
         } else {
            this.optionsVentes.setProduitAchat("0");
         }

         if (var5.getChildText("choixStock") != null && !var5.getChildText("choixStock").isEmpty()) {
            this.optionsVentes.setChoixStock(var5.getChildText("choixStock"));
         } else {
            this.optionsVentes.setChoixStock("0");
         }

         if (var5.getChildText("tracabilite") != null && !var5.getChildText("tracabilite").isEmpty()) {
            this.optionsVentes.setTracabilite(var5.getChildText("tracabilite"));
         } else {
            this.optionsVentes.setTracabilite("0");
         }

         if (var5.getChildText("transformation") != null && !var5.getChildText("transformation").isEmpty()) {
            this.optionsVentes.setTransformation(var5.getChildText("transformation"));
         } else {
            this.optionsVentes.setTransformation("0");
         }

         if (var5.getChildText("impPoids") != null && !var5.getChildText("impPoids").isEmpty()) {
            this.optionsVentes.setImpPoids(var5.getChildText("impPoids"));
         } else {
            this.optionsVentes.setImpPoids("0");
         }

         this.optionsVentes.setLib1ENTETE(var5.getChildText("lib1ENTETE"));
         this.optionsVentes.setLib2ENTETE(var5.getChildText("lib2ENTETE"));
         this.optionsVentes.setLib3ENTETE(var5.getChildText("lib3ENTETE"));
         this.optionsVentes.setLib4ENTETE(var5.getChildText("lib4ENTETE"));
         this.optionsVentes.setLib5ENTETE(var5.getChildText("lib5ENTETE"));
         this.optionsVentes.setLib6ENTETE(var5.getChildText("lib6ENTETE"));
         this.optionsVentes.setLib7ENTETE(var5.getChildText("lib7ENTETE"));
         this.optionsVentes.setLib8ENTETE(var5.getChildText("lib8ENTETE"));
         this.optionsVentes.setLib9ENTETE(var5.getChildText("lib9ENTETE"));
         this.optionsVentes.setLib10ENTETE(var5.getChildText("lib10ENTETE"));
         if (var5.getChildText("transfertDocument") != null && !var5.getChildText("transfertDocument").isEmpty()) {
            this.optionsVentes.setTransfertDocument(var5.getChildText("transfertDocument"));
         } else {
            this.optionsVentes.setTransfertDocument("0");
         }

         if (var5.getChildText("zoneRef1") != null && !var5.getChildText("zoneRef1").isEmpty()) {
            this.optionsVentes.setZoneRef1(var5.getChildText("zoneRef1"));
         } else {
            this.optionsVentes.setZoneRef1("0");
         }

         if (var5.getChildText("zoneRef2") != null && !var5.getChildText("zoneRef2").isEmpty()) {
            this.optionsVentes.setZoneRef2(var5.getChildText("zoneRef2"));
         } else {
            this.optionsVentes.setZoneRef2("1");
         }

         if (var5.getChildText("zoneLibelle") != null && !var5.getChildText("zoneLibelle").isEmpty()) {
            this.optionsVentes.setZoneLibelle(var5.getChildText("zoneLibelle"));
         } else {
            this.optionsVentes.setZoneLibelle("0");
         }

         if (var5.getChildText("zoneLibelleSuite") != null && !var5.getChildText("zoneLibelleSuite").isEmpty()) {
            this.optionsVentes.setZoneLibelleSuite(var5.getChildText("zoneLibelleSuite"));
         } else {
            this.optionsVentes.setZoneLibelleSuite("0");
         }

         if (var5.getChildText("zoneRef1Serie") != null && !var5.getChildText("zoneRef1Serie").isEmpty()) {
            this.optionsVentes.setZoneRef1Serie(var5.getChildText("zoneRef1Serie"));
         } else {
            this.optionsVentes.setZoneRef1Serie("0");
         }

         if (var5.getChildText("zoneRef2Serie") != null && !var5.getChildText("zoneRef2Serie").isEmpty()) {
            this.optionsVentes.setZoneRef2Serie(var5.getChildText("zoneRef2Serie"));
         } else {
            this.optionsVentes.setZoneRef2Serie("0");
         }

         if (var5.getChildText("axeStructure") != null && !var5.getChildText("axeStructure").isEmpty()) {
            this.optionsVentes.setAxeStructure(var5.getChildText("axeStructure"));
         } else {
            this.optionsVentes.setAxeStructure("false");
         }

         if (var5.getChildText("axeSite") != null && !var5.getChildText("axeSite").isEmpty()) {
            this.optionsVentes.setAxeSite(var5.getChildText("axeSite"));
         } else {
            this.optionsVentes.setAxeSite("false");
         }

         if (var5.getChildText("axeRegion") != null && !var5.getChildText("axeRegion").isEmpty()) {
            this.optionsVentes.setAxeRegion(var5.getChildText("axeRegion"));
         } else {
            this.optionsVentes.setAxeRegion("false");
         }

         if (var5.getChildText("axeUsine") != null && !var5.getChildText("axeUsine").isEmpty()) {
            this.optionsVentes.setAxeUsine(var5.getChildText("axeUsine"));
         } else {
            this.optionsVentes.setAxeUsine("false");
         }

         if (var5.getChildText("axeActivite") != null && !var5.getChildText("axeActivite").isEmpty()) {
            this.optionsVentes.setAxeActivite(var5.getChildText("axeActivite"));
         } else {
            this.optionsVentes.setAxeActivite("false");
         }

         if (var5.getChildText("axeAgent") != null && !var5.getChildText("axeAgent").isEmpty()) {
            this.optionsVentes.setAxeAgent(var5.getChildText("axeAgent"));
         } else {
            this.optionsVentes.setAxeAgent("false");
         }

         if (var5.getChildText("axeChantier") != null && !var5.getChildText("axeChantier").isEmpty()) {
            this.optionsVentes.setAxeChantier(var5.getChildText("axeChantier"));
         } else {
            this.optionsVentes.setAxeChantier("false");
         }

         if (var5.getChildText("axeParc") != null && !var5.getChildText("axeParc").isEmpty()) {
            this.optionsVentes.setAxeParc(var5.getChildText("axeParc"));
         } else {
            this.optionsVentes.setAxeParc("false");
         }

         if (var5.getChildText("axeMission") != null && !var5.getChildText("axeMission").isEmpty()) {
            this.optionsVentes.setAxeMission(var5.getChildText("axeMission"));
         } else {
            this.optionsVentes.setAxeMission("false");
         }

         if (var5.getChildText("axeCles") != null && !var5.getChildText("axeCles").isEmpty()) {
            this.optionsVentes.setAxeCles(var5.getChildText("axeCles"));
         } else {
            this.optionsVentes.setAxeCles("false");
         }

         if (var5.getChildText("axeProjet") != null && !var5.getChildText("axeProjet").isEmpty()) {
            this.optionsVentes.setAxeProjet(var5.getChildText("axeProjet"));
         } else {
            this.optionsVentes.setAxeProjet("false");
         }

         if (var5.getChildText("axeDossier") != null && !var5.getChildText("axeDossier").isEmpty()) {
            this.optionsVentes.setAxeDossier(var5.getChildText("axeDossier"));
         } else {
            this.optionsVentes.setAxeDossier("0");
         }

         if (var5.getChildText("chronoMatricule") != null && !var5.getChildText("chronoMatricule").isEmpty()) {
            this.optionsVentes.setChronoMatricule(var5.getChildText("chronoMatricule"));
         } else {
            this.optionsVentes.setChronoMatricule("0");
         }

         if (var5.getChildText("affichInGlobViewINVENTAIRE") != null && !var5.getChildText("affichInGlobViewINVENTAIRE").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewINVENTAIRE(var5.getChildText("affichInGlobViewINVENTAIRE"));
         } else {
            this.optionsVentes.setAffichInGlobViewINVENTAIRE("100");
         }

         if (var5.getChildText("affichInGlobViewCARNET") != null && !var5.getChildText("affichInGlobViewCARNET").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewCARNET(var5.getChildText("affichInGlobViewCARNET"));
         } else {
            this.optionsVentes.setAffichInGlobViewCARNET("100");
         }

         if (var5.getChildText("saisieCarnet") != null && !var5.getChildText("saisieCarnet").isEmpty()) {
            this.optionsVentes.setSaisieCarnet(var5.getChildText("saisieCarnet"));
         } else {
            this.optionsVentes.setSaisieCarnet("0");
         }

         if (var5.getChildText("affichInGlobViewROULAGE") != null && !var5.getChildText("affichInGlobViewROULAGE").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewROULAGE(var5.getChildText("affichInGlobViewROULAGE"));
         } else {
            this.optionsVentes.setAffichInGlobViewROULAGE("100");
         }

         if (var5.getChildText("saisieRoulage") != null && !var5.getChildText("saisieRoulage").isEmpty()) {
            this.optionsVentes.setSaisieRoulage(var5.getChildText("saisieRoulage"));
         } else {
            this.optionsVentes.setSaisieRoulage("0");
         }

         if (var5.getChildText("affichInGlobViewROUTE") != null && !var5.getChildText("affichInGlobViewROUTE").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewROUTE(var5.getChildText("affichInGlobViewROUTE"));
         } else {
            this.optionsVentes.setAffichInGlobViewROUTE("100");
         }

         if (var5.getChildText("saisieRoute") != null && !var5.getChildText("saisieRoute").isEmpty()) {
            this.optionsVentes.setSaisieRoute(var5.getChildText("saisieRoute"));
         } else {
            this.optionsVentes.setSaisieRoute("0");
         }

         if (var5.getChildText("affichInGlobViewEXPEDITION") != null && !var5.getChildText("affichInGlobViewEXPEDITION").isEmpty()) {
            this.optionsVentes.setAffichInGlobViewEXPEDITION(var5.getChildText("affichInGlobViewEXPEDITION"));
         } else {
            this.optionsVentes.setAffichInGlobViewEXPEDITION("100");
         }

         if (var5.getChildText("saisieExpedition") != null && !var5.getChildText("saisieExpedition").isEmpty()) {
            this.optionsVentes.setSaisieExpedition(var5.getChildText("saisieExpedition"));
         } else {
            this.optionsVentes.setSaisieExpedition("0");
         }

         var3.close();
      } catch (JDOMException var6) {
      } catch (IOException var7) {
      }

      return this.optionsVentes;
   }

   public OptionVentes getOptionsVentes() {
      return this.optionsVentes;
   }

   public void setOptionsVentes(OptionVentes var1) {
      this.optionsVentes = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }
}
