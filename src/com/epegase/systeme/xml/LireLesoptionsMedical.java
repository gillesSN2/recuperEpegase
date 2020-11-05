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

public class LireLesoptionsMedical implements Serializable {
   private long strId;
   private OptionMedical optionMedical;

   public OptionMedical lancer() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "medical" + File.separator + "configuration" + File.separator + "optionMedical.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.optionMedical = new OptionMedical();
         if (var5.getChildText("gestConsultGenCC") != null && !var5.getChildText("gestConsultGenCC").isEmpty()) {
            this.optionMedical.setGestConsultGenCC(var5.getChildText("gestConsultGenCC"));
         } else {
            this.optionMedical.setGestConsultGenCC("false");
         }

         if (var5.getChildText("affichInTierViewCC") != null && !var5.getChildText("affichInTierViewCC").isEmpty()) {
            this.optionMedical.setAffichInTierViewCC(var5.getChildText("affichInTierViewCC"));
         } else {
            this.optionMedical.setAffichInTierViewCC("100");
         }

         if (var5.getChildText("affichInGlobViewCC") != null && !var5.getChildText("affichInGlobViewCC").isEmpty()) {
            this.optionMedical.setAffichInGlobViewCC(var5.getChildText("affichInGlobViewCC"));
         } else {
            this.optionMedical.setAffichInGlobViewCC("100");
         }

         if (var5.getChildText("nbrJrGraceCG") != null && !var5.getChildText("nbrJrGraceCG").isEmpty()) {
            this.optionMedical.setNbrJrGraceCG(var5.getChildText("nbrJrGraceCG"));
         } else {
            this.optionMedical.setNbrJrGraceCG("0");
         }

         if (var5.getChildText("gestConsultGenCS") != null && !var5.getChildText("gestConsultGenCS").isEmpty()) {
            this.optionMedical.setGestConsultGenCS(var5.getChildText("gestConsultGenCS"));
         } else {
            this.optionMedical.setGestConsultGenCS("false");
         }

         if (var5.getChildText("affichInTierViewCS") != null && !var5.getChildText("affichInTierViewCS").isEmpty()) {
            this.optionMedical.setAffichInTierViewCS(var5.getChildText("affichInTierViewCS"));
         } else {
            this.optionMedical.setAffichInTierViewCS("100");
         }

         if (var5.getChildText("affichInGlobViewCS") != null && !var5.getChildText("affichInGlobViewCS").isEmpty()) {
            this.optionMedical.setAffichInGlobViewCS(var5.getChildText("affichInGlobViewCS"));
         } else {
            this.optionMedical.setAffichInGlobViewCS("100");
         }

         if (var5.getChildText("dent") != null && !var5.getChildText("dent").isEmpty()) {
            this.optionMedical.setDent(var5.getChildText("dent"));
         } else {
            this.optionMedical.setDent("0");
         }

         if (var5.getChildText("gestPharCP") != null && !var5.getChildText("gestPharCP").isEmpty()) {
            this.optionMedical.setGestPharCP(var5.getChildText("gestPharCP"));
         } else {
            this.optionMedical.setGestPharCP("false");
         }

         if (var5.getChildText("affichInTierViewCP") != null && !var5.getChildText("affichInTierViewCP").isEmpty()) {
            this.optionMedical.setAffichInTierViewCP(var5.getChildText("affichInTierViewCP"));
         } else {
            this.optionMedical.setAffichInTierViewCP("100");
         }

         if (var5.getChildText("affichInGlobViewCP") != null && !var5.getChildText("affichInGlobViewCP").isEmpty()) {
            this.optionMedical.setAffichInGlobViewCP(var5.getChildText("affichInGlobViewCP"));
         } else {
            this.optionMedical.setAffichInGlobViewCP("100");
         }

         if (var5.getChildText("gestLaboratoireCL") != null && !var5.getChildText("gestLaboratoireCL").isEmpty()) {
            this.optionMedical.setGestLaboratoireCL(var5.getChildText("gestLaboratoireCL"));
         } else {
            this.optionMedical.setGestLaboratoireCL("false");
         }

         if (var5.getChildText("affichInTierViewCL") != null && !var5.getChildText("affichInTierViewCL").isEmpty()) {
            this.optionMedical.setAffichInTierViewCL(var5.getChildText("affichInTierViewCL"));
         } else {
            this.optionMedical.setAffichInTierViewCL("100");
         }

         if (var5.getChildText("affichInGlobViewCL") != null && !var5.getChildText("affichInGlobViewCL").isEmpty()) {
            this.optionMedical.setAffichInGlobViewCL(var5.getChildText("affichInGlobViewCL"));
         } else {
            this.optionMedical.setAffichInGlobViewCL("100");
         }

         if (var5.getChildText("affichInGlobViewPaillasse") != null && !var5.getChildText("affichInGlobViewPaillasse").isEmpty()) {
            this.optionMedical.setAffichInGlobViewPaillasse(var5.getChildText("affichInGlobViewPaillasse"));
         } else {
            this.optionMedical.setAffichInGlobViewPaillasse("100");
         }

         if (var5.getChildText("choixLabo") != null && !var5.getChildText("choixLabo").isEmpty()) {
            this.optionMedical.setChoixLabo(var5.getChildText("choixLabo"));
         } else {
            this.optionMedical.setChoixLabo("0");
         }

         if (var5.getChildText("gestHospitalisationCH") != null && !var5.getChildText("gestHospitalisationCH").isEmpty()) {
            this.optionMedical.setGestHospitalisationCH(var5.getChildText("gestHospitalisationCH"));
         } else {
            this.optionMedical.setGestHospitalisationCH("false");
         }

         if (var5.getChildText("affichInTierViewCH") != null && !var5.getChildText("affichInTierViewCH").isEmpty()) {
            this.optionMedical.setAffichInTierViewCH(var5.getChildText("affichInTierViewCH"));
         } else {
            this.optionMedical.setAffichInTierViewCH("100");
         }

         if (var5.getChildText("affichInGlobViewCH") != null && !var5.getChildText("affichInGlobViewCH").isEmpty()) {
            this.optionMedical.setAffichInGlobViewCH(var5.getChildText("affichInGlobViewCH"));
         } else {
            this.optionMedical.setAffichInGlobViewCH("100");
         }

         if (var5.getChildText("nbrJrRelanceDEVIS") != null && !var5.getChildText("nbrJrRelanceDEVIS").isEmpty()) {
            this.optionMedical.setNbrJrRelanceDEVIS(var5.getChildText("nbrJrRelanceDEVIS"));
         } else {
            this.optionMedical.setNbrJrRelanceDEVIS("0");
         }

         if (var5.getChildText("nbrJrValidDEVIS") != null && !var5.getChildText("nbrJrValidDEVIS").isEmpty()) {
            this.optionMedical.setNbrJrValidDEVIS(var5.getChildText("nbrJrValidDEVIS"));
         } else {
            this.optionMedical.setNbrJrValidDEVIS("0");
         }

         if (var5.getChildText("affichInTierFilDEVIS") != null && !var5.getChildText("affichInTierFilDEVIS").isEmpty()) {
            this.optionMedical.setAffichInTierFilDEVIS(var5.getChildText("affichInTierFilDEVIS"));
         } else {
            this.optionMedical.setAffichInTierFilDEVIS("100");
         }

         if (var5.getChildText("affichInGlobViewDEVIS") != null && !var5.getChildText("affichInGlobViewDEVIS").isEmpty()) {
            this.optionMedical.setAffichInGlobViewDEVIS(var5.getChildText("affichInGlobViewDEVIS"));
         } else {
            this.optionMedical.setAffichInGlobViewDEVIS("100");
         }

         if (var5.getChildText("nbrJrRelanceFAC") != null && !var5.getChildText("nbrJrRelanceFAC").isEmpty()) {
            this.optionMedical.setNbrJrRelanceFAC(var5.getChildText("nbrJrRelanceFAC"));
         } else {
            this.optionMedical.setNbrJrRelanceFAC("0");
         }

         if (var5.getChildText("nbrJrValidFAC") != null && !var5.getChildText("nbrJrValidFAC").isEmpty()) {
            this.optionMedical.setNbrJrValidFAC(var5.getChildText("nbrJrValidFAC"));
         } else {
            this.optionMedical.setNbrJrValidFAC("0");
         }

         if (var5.getChildText("affichInTierFilFAC") != null && !var5.getChildText("affichInTierFilFAC").isEmpty()) {
            this.optionMedical.setAffichInTierFilFAC(var5.getChildText("affichInTierFilFAC"));
         } else {
            this.optionMedical.setAffichInTierFilFAC("100");
         }

         if (var5.getChildText("affichInGlobViewFAC") != null && !var5.getChildText("affichInGlobViewFAC").isEmpty()) {
            this.optionMedical.setAffichInGlobViewFAC(var5.getChildText("affichInGlobViewFAC"));
         } else {
            this.optionMedical.setAffichInGlobViewFAC("100");
         }

         if (var5.getChildText("decrmtPriVteStock") != null && !var5.getChildText("decrmtPriVteStock").isEmpty()) {
            this.optionMedical.setDecrmtPriVteStock(var5.getChildText("decrmtPriVteStock"));
         } else {
            this.optionMedical.setDecrmtPriVteStock("1");
         }

         if (var5.getChildText("modeRefacturation") != null && !var5.getChildText("modeRefacturation").isEmpty()) {
            this.optionMedical.setModeRefacturation(var5.getChildText("modeRefacturation"));
         } else {
            this.optionMedical.setModeRefacturation("0");
         }

         if (var5.getChildText("nbrJrRelanceNOTDEB") != null && !var5.getChildText("nbrJrRelanceNOTDEB").isEmpty()) {
            this.optionMedical.setNbrJrRelanceNOTDEB(var5.getChildText("nbrJrRelanceNOTDEB"));
         } else {
            this.optionMedical.setNbrJrRelanceNOTDEB("0");
         }

         if (var5.getChildText("nbrJrValidNOTDEB") != null && !var5.getChildText("nbrJrValidNOTDEB").isEmpty()) {
            this.optionMedical.setNbrJrValidNOTDEB(var5.getChildText("nbrJrValidNOTDEB"));
         } else {
            this.optionMedical.setNbrJrValidNOTDEB("0");
         }

         if (var5.getChildText("affichInTierFilNOTDEB") != null && !var5.getChildText("affichInTierFilNOTDEB").isEmpty()) {
            this.optionMedical.setAffichInTierFilNOTDEB(var5.getChildText("affichInTierFilNOTDEB"));
         } else {
            this.optionMedical.setAffichInTierFilNOTDEB("100");
         }

         if (var5.getChildText("affichInGlobViewNOTDEB") != null && !var5.getChildText("affichInGlobViewNOTDEB").isEmpty()) {
            this.optionMedical.setAffichInGlobViewNOTDEB(var5.getChildText("affichInGlobViewNOTDEB"));
         } else {
            this.optionMedical.setAffichInGlobViewNOTDEB("100");
         }

         if (var5.getChildText("gestionPlafondNdb") != null && !var5.getChildText("gestionPlafondNdb").isEmpty()) {
            this.optionMedical.setGestionPlafondNdb(var5.getChildText("gestionPlafondNdb"));
         } else {
            this.optionMedical.setGestionPlafondNdb("0");
         }

         if (var5.getChildText("nbrJrRelanceAVOIR") != null && !var5.getChildText("nbrJrRelanceAVOIR").isEmpty()) {
            this.optionMedical.setNbrJrRelanceAVOIR(var5.getChildText("nbrJrRelanceAVOIR"));
         } else {
            this.optionMedical.setNbrJrRelanceAVOIR("0");
         }

         if (var5.getChildText("nbrJrValidAVOIR") != null && !var5.getChildText("nbrJrValidAVOIR").isEmpty()) {
            this.optionMedical.setNbrJrValidAVOIR(var5.getChildText("nbrJrValidAVOIR"));
         } else {
            this.optionMedical.setNbrJrValidAVOIR("0");
         }

         if (var5.getChildText("affichInTierFilAVOIR") != null && !var5.getChildText("affichInTierFilAVOIR").isEmpty()) {
            this.optionMedical.setAffichInTierFilAVOIR(var5.getChildText("affichInTierFilAVOIR"));
         } else {
            this.optionMedical.setAffichInTierFilAVOIR("100");
         }

         if (var5.getChildText("affichInGlobViewAVOIR") != null && !var5.getChildText("affichInGlobViewAVOIR").isEmpty()) {
            this.optionMedical.setAffichInGlobViewAVOIR(var5.getChildText("affichInGlobViewAVOIR"));
         } else {
            this.optionMedical.setAffichInGlobViewAVOIR("100");
         }

         if (var5.getChildText("affichInGlobViewCOMMISSION") != null && !var5.getChildText("affichInGlobViewCOMMISSION").isEmpty()) {
            this.optionMedical.setAffichInGlobViewCOMMISSION(var5.getChildText("affichInGlobViewCOMMISSION"));
         } else {
            this.optionMedical.setAffichInGlobViewCOMMISSION("100");
         }

         if (var5.getChildText("modeCommission") != null && !var5.getChildText("modeCommission").isEmpty()) {
            this.optionMedical.setModeCommission(var5.getChildText("modeCommission"));
         } else {
            this.optionMedical.setModeCommission("0");
         }

         this.optionMedical.setCompteDebit(var5.getChildText("compteDebit"));
         if (var5.getChildText("cnamgs") != null && !var5.getChildText("cnamgs").isEmpty()) {
            this.optionMedical.setCnamgs(var5.getChildText("cnamgs"));
         } else {
            this.optionMedical.setCnamgs("0");
         }

         if (var5.getChildText("nbrCtrsFamOP") != null && !var5.getChildText("nbrCtrsFamOP").isEmpty()) {
            this.optionMedical.setNbrCtrsFamOP(var5.getChildText("nbrCtrsFamOP"));
         } else {
            this.optionMedical.setNbrCtrsFamOP("3");
         }

         if (var5.getChildText("nbrCtrsProOP") != null && !var5.getChildText("nbrCtrsProOP").isEmpty()) {
            this.optionMedical.setNbrCtrsProOP(var5.getChildText("nbrCtrsProOP"));
         } else {
            this.optionMedical.setNbrCtrsProOP("3");
         }

         if (var5.getChildText("modCalcOP") != null && !var5.getChildText("modCalcOP").isEmpty()) {
            this.optionMedical.setModCalcOP(var5.getChildText("modCalcOP"));
         } else {
            this.optionMedical.setModCalcOP("0");
         }

         if (var5.getChildText("nbLigneMax") != null && !var5.getChildText("nbLigneMax").isEmpty()) {
            this.optionMedical.setNbLigneMax(var5.getChildText("nbLigneMax"));
         } else {
            this.optionMedical.setNbLigneMax("100");
         }

         this.optionMedical.setChargementListe(var5.getChildText("chargementListe"));
         if (var5.getChildText("actePerso") != null && !var5.getChildText("actePerso").isEmpty()) {
            this.optionMedical.setActePerso(var5.getChildText("actePerso"));
         } else {
            this.optionMedical.setActePerso("false");
         }

         if (var5.getChildText("acteCcam") != null && !var5.getChildText("acteCcam").isEmpty()) {
            this.optionMedical.setActeCcam(var5.getChildText("acteCcam"));
         } else {
            this.optionMedical.setActeCcam("false");
         }

         if (var5.getChildText("acteNgap") != null && !var5.getChildText("acteNgap").isEmpty()) {
            this.optionMedical.setActeNgap(var5.getChildText("acteNgap"));
         } else {
            this.optionMedical.setActeNgap("false");
         }

         this.optionMedical.setComptePatient(var5.getChildText("comptePatient"));
         this.optionMedical.setCompteProduit(var5.getChildText("compteProduit"));
         this.optionMedical.setCompteCNAMGSAP(var5.getChildText("compteCNAMGSAP"));
         this.optionMedical.setCompteCNAMGSSP(var5.getChildText("compteCNAMGSSP"));
         this.optionMedical.setCompteCNAMGSGEF(var5.getChildText("compteCNAMGSGEF"));
         if (var5.getChildText("nbDecQte") != null && !var5.getChildText("nbDecQte").isEmpty()) {
            this.optionMedical.setNbDecQte(var5.getChildText("nbDecQte"));
         } else {
            this.optionMedical.setNbDecQte("0");
         }

         if (var5.getChildText("nbDecPu") != null && !var5.getChildText("nbDecPu").isEmpty()) {
            this.optionMedical.setNbDecPu(var5.getChildText("nbDecPu"));
         } else {
            this.optionMedical.setNbDecPu("0");
         }

         if (var5.getChildText("anneeFinBebe") != null && !var5.getChildText("anneeFinBebe").isEmpty()) {
            this.optionMedical.setAnneeFinBebe(var5.getChildText("anneeFinBebe"));
         } else {
            this.optionMedical.setAnneeFinBebe("0");
         }

         if (var5.getChildText("anneeDebutEnfant") != null && !var5.getChildText("anneeDebutEnfant").isEmpty()) {
            this.optionMedical.setAnneeDebutEnfant(var5.getChildText("anneeDebutEnfant"));
         } else {
            this.optionMedical.setAnneeDebutEnfant("0");
         }

         if (var5.getChildText("anneeFinEnfant") != null && !var5.getChildText("anneeFinEnfant").isEmpty()) {
            this.optionMedical.setAnneeFinEnfant(var5.getChildText("anneeFinEnfant"));
         } else {
            this.optionMedical.setAnneeFinEnfant("0");
         }

         if (var5.getChildText("anneeDebutAdo") != null && !var5.getChildText("anneeDebutAdo").isEmpty()) {
            this.optionMedical.setAnneeDebutAdo(var5.getChildText("anneeDebutAdo"));
         } else {
            this.optionMedical.setAnneeDebutAdo("0");
         }

         if (var5.getChildText("anneeFinAdo") != null && !var5.getChildText("anneeFinAdo").isEmpty()) {
            this.optionMedical.setAnneeFinAdo(var5.getChildText("anneeFinAdo"));
         } else {
            this.optionMedical.setAnneeFinAdo("0");
         }

         if (var5.getChildText("anneeDebutAdulte") != null && !var5.getChildText("anneeDebutAdulte").isEmpty()) {
            this.optionMedical.setAnneeDebutAdulte(var5.getChildText("anneeDebutAdulte"));
         } else {
            this.optionMedical.setAnneeDebutAdulte("0");
         }

         if (var5.getChildText("anneeFinAdulte") != null && !var5.getChildText("anneeFinAdulte").isEmpty()) {
            this.optionMedical.setAnneeFinAdulte(var5.getChildText("anneeFinAdulte"));
         } else {
            this.optionMedical.setAnneeFinAdulte("0");
         }

         if (var5.getChildText("anneeDebutSenior") != null && !var5.getChildText("anneeDebutSenior").isEmpty()) {
            this.optionMedical.setAnneeDebutSenior(var5.getChildText("anneeDebutSenior"));
         } else {
            this.optionMedical.setAnneeDebutSenior("0");
         }

         if (var5.getChildText("serviceCG") != null && !var5.getChildText("serviceCG").isEmpty()) {
            this.optionMedical.setServiceCG(var5.getChildText("serviceCG"));
         } else {
            this.optionMedical.setServiceCG("0");
         }

         if (var5.getChildText("serviceCS") != null && !var5.getChildText("serviceCS").isEmpty()) {
            this.optionMedical.setServiceCS(var5.getChildText("serviceCS"));
         } else {
            this.optionMedical.setServiceCS("0");
         }

         if (var5.getChildText("serviceLB") != null && !var5.getChildText("serviceLB").isEmpty()) {
            this.optionMedical.setServiceLB(var5.getChildText("serviceLB"));
         } else {
            this.optionMedical.setServiceLB("0");
         }

         if (var5.getChildText("servicePH") != null && !var5.getChildText("servicePH").isEmpty()) {
            this.optionMedical.setServicePH(var5.getChildText("servicePH"));
         } else {
            this.optionMedical.setServicePH("0");
         }

         if (var5.getChildText("medecinCG") != null && !var5.getChildText("medecinCG").isEmpty()) {
            this.optionMedical.setMedecinCG(var5.getChildText("medecinCG"));
         } else {
            this.optionMedical.setMedecinCG("0");
         }

         if (var5.getChildText("medecinCS") != null && !var5.getChildText("medecinCS").isEmpty()) {
            this.optionMedical.setMedecinCS(var5.getChildText("medecinCS"));
         } else {
            this.optionMedical.setMedecinCS("0");
         }

         if (var5.getChildText("medecinLB") != null && !var5.getChildText("medecinLB").isEmpty()) {
            this.optionMedical.setMedecinLB(var5.getChildText("medecinLB"));
         } else {
            this.optionMedical.setMedecinLB("0");
         }

         if (var5.getChildText("medecinPH") != null && !var5.getChildText("medecinPH").isEmpty()) {
            this.optionMedical.setMedecinPH(var5.getChildText("medecinPH"));
         } else {
            this.optionMedical.setMedecinPH("0");
         }

         if (var5.getChildText("medecinHP") != null && !var5.getChildText("medecinHP").isEmpty()) {
            this.optionMedical.setMedecinHP(var5.getChildText("medecinHP"));
         } else {
            this.optionMedical.setMedecinHP("0");
         }

         if (var5.getChildText("coefMajoration") != null && !var5.getChildText("coefMajoration").isEmpty()) {
            this.optionMedical.setCoefMajoration(var5.getChildText("coefMajoration"));
         } else {
            this.optionMedical.setCoefMajoration("0");
         }

         if (var5.getChildText("tarifSociete") != null && !var5.getChildText("tarifSociete").isEmpty()) {
            this.optionMedical.setTarifSociete(var5.getChildText("tarifSociete"));
         } else {
            this.optionMedical.setTarifSociete("0");
         }

         this.optionMedical.setTvaDefaut(var5.getChildText("tvaDefaut"));
         this.optionMedical.setLib1ENTETE(var5.getChildText("lib1ENTETE"));
         this.optionMedical.setLib2ENTETE(var5.getChildText("lib2ENTETE"));
         this.optionMedical.setLib3ENTETE(var5.getChildText("lib3ENTETE"));
         this.optionMedical.setLib4ENTETE(var5.getChildText("lib4ENTETE"));
         this.optionMedical.setLib5ENTETE(var5.getChildText("lib5ENTETE"));
         this.optionMedical.setLib6ENTETE(var5.getChildText("lib6ENTETE"));
         this.optionMedical.setLib7ENTETE(var5.getChildText("lib7ENTETE"));
         this.optionMedical.setLib8ENTETE(var5.getChildText("lib8ENTETE"));
         this.optionMedical.setLib9ENTETE(var5.getChildText("lib9ENTETE"));
         this.optionMedical.setLib10ENTETE(var5.getChildText("lib10ENTETE"));
         if (var5.getChildText("transfertDocument") != null && !var5.getChildText("transfertDocument").isEmpty()) {
            this.optionMedical.setTransfertDocument(var5.getChildText("transfertDocument"));
         } else {
            this.optionMedical.setTransfertDocument("0");
         }

         if (var5.getChildText("zoneRef1") != null && !var5.getChildText("zoneRef1").isEmpty()) {
            this.optionMedical.setZoneRef1(var5.getChildText("zoneRef1"));
         } else {
            this.optionMedical.setZoneRef1("0");
         }

         if (var5.getChildText("zoneRef2") != null && !var5.getChildText("zoneRef2").isEmpty()) {
            this.optionMedical.setZoneRef2(var5.getChildText("zoneRef2"));
         } else {
            this.optionMedical.setZoneRef2("1");
         }

         if (var5.getChildText("zoneLibelle") != null && !var5.getChildText("zoneLibelle").isEmpty()) {
            this.optionMedical.setZoneLibelle(var5.getChildText("zoneLibelle"));
         } else {
            this.optionMedical.setZoneLibelle("0");
         }

         if (var5.getChildText("zoneLibelleSuite") != null && !var5.getChildText("zoneLibelleSuite").isEmpty()) {
            this.optionMedical.setZoneLibelleSuite(var5.getChildText("zoneLibelleSuite"));
         } else {
            this.optionMedical.setZoneLibelleSuite("0");
         }

         if (var5.getChildText("zoneRef1Serie") != null && !var5.getChildText("zoneRef1Serie").isEmpty()) {
            this.optionMedical.setZoneRef1Serie(var5.getChildText("zoneRef1Serie"));
         } else {
            this.optionMedical.setZoneRef1Serie("0");
         }

         if (var5.getChildText("zoneRef2Serie") != null && !var5.getChildText("zoneRef2Serie").isEmpty()) {
            this.optionMedical.setZoneRef2Serie(var5.getChildText("zoneRef2Serie"));
         } else {
            this.optionMedical.setZoneRef2Serie("0");
         }

         var3.close();
      } catch (JDOMException var6) {
      } catch (IOException var7) {
      }

      return this.optionMedical;
   }

   public OptionMedical getOptionMedical() {
      return this.optionMedical;
   }

   public void setOptionMedical(OptionMedical var1) {
      this.optionMedical = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }
}
