package com.epegase.systeme.xml;

import java.io.Serializable;

public class OptionMedical implements Serializable {
   private String gestPharCP;
   private String affichInTierViewCP;
   private String affichInGlobViewCP;
   private String gestConsultGenCC;
   private String affichInTierViewCC;
   private String affichInGlobViewCC;
   private String nbrJrGraceCG;
   private String gestConsultGenCS;
   private String affichInTierViewCS;
   private String affichInGlobViewCS;
   private String dent;
   private String gestLaboratoireCL;
   private String affichInTierViewCL;
   private String affichInGlobViewCL;
   private String affichInGlobViewPaillasse;
   private String choixLabo;
   private String gestHospitalisationCH;
   private String affichInTierViewCH;
   private String affichInGlobViewCH;
   private String nbrJrRelanceDEVIS;
   private String nbrJrValidDEVIS;
   private String affichInTierFilDEVIS;
   private String affichInGlobViewDEVIS;
   private String nbrJrRelanceFAC;
   private String nbrJrValidFAC;
   private String affichInTierFilFAC;
   private String affichInGlobViewFAC;
   private String modeRefacturation;
   private String nbrJrRelanceNOTDEB;
   private String nbrJrValidNOTDEB;
   private String affichInTierFilNOTDEB;
   private String affichInGlobViewNOTDEB;
   private String gestionPlafondNdb;
   private String nbrJrRelanceAVOIR;
   private String nbrJrValidAVOIR;
   private String affichInTierFilAVOIR;
   private String affichInGlobViewAVOIR;
   private String decrmtPriVteStock = "1";
   private String cnamgs;
   private String nbrCtrsFamOP;
   private String nbrCtrsProOP;
   private String modCalcOP;
   private String nbLigneMax;
   private String actePerso;
   private String acteCcam;
   private String acteNgap;
   private String nbDecQte;
   private String nbDecPu;
   private String anneeFinBebe;
   private String anneeDebutEnfant;
   private String anneeFinEnfant;
   private String anneeDebutAdo;
   private String anneeFinAdo;
   private String anneeDebutAdulte;
   private String anneeFinAdulte;
   private String anneeDebutSenior;
   private String serviceCG;
   private String serviceCS;
   private String serviceLB;
   private String servicePH;
   private String medecinCG;
   private String medecinCS;
   private String medecinLB;
   private String medecinPH;
   private String medecinHP;
   private String coefMajoration;
   private String tarifSociete;
   private String tvaDefaut;
   private String descriptifComplementaire;
   private String affichInGlobViewCOMMISSION;
   private String modeCommission;
   private String compteDebit;
   private String chargementListe;
   private String comptePatient;
   private String compteProduit;
   private String compteCNAMGSAP;
   private String compteCNAMGSSP;
   private String compteCNAMGSGEF;
   private String lib1ENTETE;
   private String lib2ENTETE;
   private String lib3ENTETE;
   private String lib4ENTETE;
   private String lib5ENTETE;
   private String lib6ENTETE;
   private String lib7ENTETE;
   private String lib8ENTETE;
   private String lib9ENTETE;
   private String lib10ENTETE;
   private String transfertDocument;
   private String zoneRef1;
   private String zoneRef2;
   private String zoneLibelle;
   private String zoneLibelleSuite;
   private String zoneRef1Serie;
   private String zoneRef2Serie;

   public String getAffichInGlobViewCC() {
      return this.affichInGlobViewCC;
   }

   public void setAffichInGlobViewCC(String var1) {
      this.affichInGlobViewCC = var1;
   }

   public String getAffichInGlobViewCH() {
      return this.affichInGlobViewCH;
   }

   public void setAffichInGlobViewCH(String var1) {
      this.affichInGlobViewCH = var1;
   }

   public String getAffichInGlobViewCL() {
      return this.affichInGlobViewCL;
   }

   public void setAffichInGlobViewCL(String var1) {
      this.affichInGlobViewCL = var1;
   }

   public String getAffichInGlobViewCP() {
      return this.affichInGlobViewCP;
   }

   public void setAffichInGlobViewCP(String var1) {
      this.affichInGlobViewCP = var1;
   }

   public String getAffichInGlobViewCS() {
      return this.affichInGlobViewCS;
   }

   public void setAffichInGlobViewCS(String var1) {
      this.affichInGlobViewCS = var1;
   }

   public String getAffichInTierViewCC() {
      return this.affichInTierViewCC;
   }

   public void setAffichInTierViewCC(String var1) {
      this.affichInTierViewCC = var1;
   }

   public String getAffichInTierViewCH() {
      return this.affichInTierViewCH;
   }

   public void setAffichInTierViewCH(String var1) {
      this.affichInTierViewCH = var1;
   }

   public String getAffichInTierViewCL() {
      return this.affichInTierViewCL;
   }

   public void setAffichInTierViewCL(String var1) {
      this.affichInTierViewCL = var1;
   }

   public String getAffichInTierViewCP() {
      return this.affichInTierViewCP;
   }

   public void setAffichInTierViewCP(String var1) {
      this.affichInTierViewCP = var1;
   }

   public String getAffichInTierViewCS() {
      return this.affichInTierViewCS;
   }

   public void setAffichInTierViewCS(String var1) {
      this.affichInTierViewCS = var1;
   }

   public String getGestConsultGenCC() {
      return this.gestConsultGenCC;
   }

   public void setGestConsultGenCC(String var1) {
      this.gestConsultGenCC = var1;
   }

   public String getGestConsultGenCS() {
      return this.gestConsultGenCS;
   }

   public void setGestConsultGenCS(String var1) {
      this.gestConsultGenCS = var1;
   }

   public String getGestHospitalisationCH() {
      return this.gestHospitalisationCH;
   }

   public void setGestHospitalisationCH(String var1) {
      this.gestHospitalisationCH = var1;
   }

   public String getGestLaboratoireCL() {
      return this.gestLaboratoireCL;
   }

   public void setGestLaboratoireCL(String var1) {
      this.gestLaboratoireCL = var1;
   }

   public String getGestPharCP() {
      return this.gestPharCP;
   }

   public void setGestPharCP(String var1) {
      this.gestPharCP = var1;
   }

   public String getModCalcOP() {
      return this.modCalcOP;
   }

   public void setModCalcOP(String var1) {
      this.modCalcOP = var1;
   }

   public String getNbrCtrsFamOP() {
      return this.nbrCtrsFamOP;
   }

   public void setNbrCtrsFamOP(String var1) {
      this.nbrCtrsFamOP = var1;
   }

   public String getNbrCtrsProOP() {
      return this.nbrCtrsProOP;
   }

   public void setNbrCtrsProOP(String var1) {
      this.nbrCtrsProOP = var1;
   }

   public String getLib10ENTETE() {
      return this.lib10ENTETE;
   }

   public void setLib10ENTETE(String var1) {
      this.lib10ENTETE = var1;
   }

   public String getLib1ENTETE() {
      return this.lib1ENTETE;
   }

   public void setLib1ENTETE(String var1) {
      this.lib1ENTETE = var1;
   }

   public String getLib2ENTETE() {
      return this.lib2ENTETE;
   }

   public void setLib2ENTETE(String var1) {
      this.lib2ENTETE = var1;
   }

   public String getLib3ENTETE() {
      return this.lib3ENTETE;
   }

   public void setLib3ENTETE(String var1) {
      this.lib3ENTETE = var1;
   }

   public String getLib4ENTETE() {
      return this.lib4ENTETE;
   }

   public void setLib4ENTETE(String var1) {
      this.lib4ENTETE = var1;
   }

   public String getLib5ENTETE() {
      return this.lib5ENTETE;
   }

   public void setLib5ENTETE(String var1) {
      this.lib5ENTETE = var1;
   }

   public String getLib6ENTETE() {
      return this.lib6ENTETE;
   }

   public void setLib6ENTETE(String var1) {
      this.lib6ENTETE = var1;
   }

   public String getLib7ENTETE() {
      return this.lib7ENTETE;
   }

   public void setLib7ENTETE(String var1) {
      this.lib7ENTETE = var1;
   }

   public String getLib8ENTETE() {
      return this.lib8ENTETE;
   }

   public void setLib8ENTETE(String var1) {
      this.lib8ENTETE = var1;
   }

   public String getLib9ENTETE() {
      return this.lib9ENTETE;
   }

   public void setLib9ENTETE(String var1) {
      this.lib9ENTETE = var1;
   }

   public String getNbLigneMax() {
      return this.nbLigneMax;
   }

   public void setNbLigneMax(String var1) {
      this.nbLigneMax = var1;
   }

   public String getChargementListe() {
      return this.chargementListe;
   }

   public void setChargementListe(String var1) {
      this.chargementListe = var1;
   }

   public String getActeCcam() {
      return this.acteCcam;
   }

   public void setActeCcam(String var1) {
      this.acteCcam = var1;
   }

   public String getActeNgap() {
      return this.acteNgap;
   }

   public void setActeNgap(String var1) {
      this.acteNgap = var1;
   }

   public String getActePerso() {
      return this.actePerso;
   }

   public void setActePerso(String var1) {
      this.actePerso = var1;
   }

   public String getComptePatient() {
      return this.comptePatient;
   }

   public void setComptePatient(String var1) {
      this.comptePatient = var1;
   }

   public String getCnamgs() {
      return this.cnamgs;
   }

   public void setCnamgs(String var1) {
      this.cnamgs = var1;
   }

   public String getAffichInGlobViewDEVIS() {
      return this.affichInGlobViewDEVIS;
   }

   public void setAffichInGlobViewDEVIS(String var1) {
      this.affichInGlobViewDEVIS = var1;
   }

   public String getAffichInTierFilDEVIS() {
      return this.affichInTierFilDEVIS;
   }

   public void setAffichInTierFilDEVIS(String var1) {
      this.affichInTierFilDEVIS = var1;
   }

   public String getNbDecPu() {
      return this.nbDecPu;
   }

   public void setNbDecPu(String var1) {
      this.nbDecPu = var1;
   }

   public String getNbDecQte() {
      return this.nbDecQte;
   }

   public void setNbDecQte(String var1) {
      this.nbDecQte = var1;
   }

   public String getNbrJrRelanceDEVIS() {
      return this.nbrJrRelanceDEVIS;
   }

   public void setNbrJrRelanceDEVIS(String var1) {
      this.nbrJrRelanceDEVIS = var1;
   }

   public String getNbrJrValidDEVIS() {
      return this.nbrJrValidDEVIS;
   }

   public void setNbrJrValidDEVIS(String var1) {
      this.nbrJrValidDEVIS = var1;
   }

   public String getAffichInGlobViewFAC() {
      return this.affichInGlobViewFAC;
   }

   public void setAffichInGlobViewFAC(String var1) {
      this.affichInGlobViewFAC = var1;
   }

   public String getAffichInTierFilFAC() {
      return this.affichInTierFilFAC;
   }

   public void setAffichInTierFilFAC(String var1) {
      this.affichInTierFilFAC = var1;
   }

   public String getNbrJrRelanceFAC() {
      return this.nbrJrRelanceFAC;
   }

   public void setNbrJrRelanceFAC(String var1) {
      this.nbrJrRelanceFAC = var1;
   }

   public String getNbrJrValidFAC() {
      return this.nbrJrValidFAC;
   }

   public void setNbrJrValidFAC(String var1) {
      this.nbrJrValidFAC = var1;
   }

   public String getAffichInGlobViewAVOIR() {
      return this.affichInGlobViewAVOIR;
   }

   public void setAffichInGlobViewAVOIR(String var1) {
      this.affichInGlobViewAVOIR = var1;
   }

   public String getAffichInTierFilAVOIR() {
      return this.affichInTierFilAVOIR;
   }

   public void setAffichInTierFilAVOIR(String var1) {
      this.affichInTierFilAVOIR = var1;
   }

   public String getNbrJrRelanceAVOIR() {
      return this.nbrJrRelanceAVOIR;
   }

   public void setNbrJrRelanceAVOIR(String var1) {
      this.nbrJrRelanceAVOIR = var1;
   }

   public String getNbrJrValidAVOIR() {
      return this.nbrJrValidAVOIR;
   }

   public void setNbrJrValidAVOIR(String var1) {
      this.nbrJrValidAVOIR = var1;
   }

   public String getDecrmtPriVteStock() {
      return this.decrmtPriVteStock;
   }

   public void setDecrmtPriVteStock(String var1) {
      this.decrmtPriVteStock = var1;
   }

   public String getAnneeDebutAdo() {
      return this.anneeDebutAdo;
   }

   public void setAnneeDebutAdo(String var1) {
      this.anneeDebutAdo = var1;
   }

   public String getAnneeDebutEnfant() {
      return this.anneeDebutEnfant;
   }

   public void setAnneeDebutEnfant(String var1) {
      this.anneeDebutEnfant = var1;
   }

   public String getAnneeFinAdo() {
      return this.anneeFinAdo;
   }

   public void setAnneeFinAdo(String var1) {
      this.anneeFinAdo = var1;
   }

   public String getAnneeFinBebe() {
      return this.anneeFinBebe;
   }

   public void setAnneeFinBebe(String var1) {
      this.anneeFinBebe = var1;
   }

   public String getAnneeFinEnfant() {
      return this.anneeFinEnfant;
   }

   public void setAnneeFinEnfant(String var1) {
      this.anneeFinEnfant = var1;
   }

   public String getAnneeDebutAdulte() {
      return this.anneeDebutAdulte;
   }

   public void setAnneeDebutAdulte(String var1) {
      this.anneeDebutAdulte = var1;
   }

   public String getAnneeDebutSenior() {
      return this.anneeDebutSenior;
   }

   public void setAnneeDebutSenior(String var1) {
      this.anneeDebutSenior = var1;
   }

   public String getAnneeFinAdulte() {
      return this.anneeFinAdulte;
   }

   public void setAnneeFinAdulte(String var1) {
      this.anneeFinAdulte = var1;
   }

   public String getMedecinCG() {
      return this.medecinCG;
   }

   public void setMedecinCG(String var1) {
      this.medecinCG = var1;
   }

   public String getMedecinCS() {
      return this.medecinCS;
   }

   public void setMedecinCS(String var1) {
      this.medecinCS = var1;
   }

   public String getMedecinHP() {
      return this.medecinHP;
   }

   public void setMedecinHP(String var1) {
      this.medecinHP = var1;
   }

   public String getMedecinLB() {
      return this.medecinLB;
   }

   public void setMedecinLB(String var1) {
      this.medecinLB = var1;
   }

   public String getMedecinPH() {
      return this.medecinPH;
   }

   public void setMedecinPH(String var1) {
      this.medecinPH = var1;
   }

   public String getServiceCG() {
      return this.serviceCG;
   }

   public void setServiceCG(String var1) {
      this.serviceCG = var1;
   }

   public String getServiceCS() {
      return this.serviceCS;
   }

   public void setServiceCS(String var1) {
      this.serviceCS = var1;
   }

   public String getServiceLB() {
      return this.serviceLB;
   }

   public void setServiceLB(String var1) {
      this.serviceLB = var1;
   }

   public String getServicePH() {
      return this.servicePH;
   }

   public void setServicePH(String var1) {
      this.servicePH = var1;
   }

   public String getCoefMajoration() {
      return this.coefMajoration;
   }

   public void setCoefMajoration(String var1) {
      this.coefMajoration = var1;
   }

   public String getTransfertDocument() {
      return this.transfertDocument;
   }

   public void setTransfertDocument(String var1) {
      this.transfertDocument = var1;
   }

   public String getZoneLibelle() {
      return this.zoneLibelle;
   }

   public void setZoneLibelle(String var1) {
      this.zoneLibelle = var1;
   }

   public String getZoneLibelleSuite() {
      return this.zoneLibelleSuite;
   }

   public void setZoneLibelleSuite(String var1) {
      this.zoneLibelleSuite = var1;
   }

   public String getZoneRef1() {
      return this.zoneRef1;
   }

   public void setZoneRef1(String var1) {
      this.zoneRef1 = var1;
   }

   public String getZoneRef1Serie() {
      return this.zoneRef1Serie;
   }

   public void setZoneRef1Serie(String var1) {
      this.zoneRef1Serie = var1;
   }

   public String getZoneRef2() {
      return this.zoneRef2;
   }

   public void setZoneRef2(String var1) {
      this.zoneRef2 = var1;
   }

   public String getZoneRef2Serie() {
      return this.zoneRef2Serie;
   }

   public void setZoneRef2Serie(String var1) {
      this.zoneRef2Serie = var1;
   }

   public String getChoixLabo() {
      return this.choixLabo;
   }

   public void setChoixLabo(String var1) {
      this.choixLabo = var1;
   }

   public String getTarifSociete() {
      return this.tarifSociete;
   }

   public void setTarifSociete(String var1) {
      this.tarifSociete = var1;
   }

   public String getAffichInGlobViewCOMMISSION() {
      return this.affichInGlobViewCOMMISSION;
   }

   public void setAffichInGlobViewCOMMISSION(String var1) {
      this.affichInGlobViewCOMMISSION = var1;
   }

   public String getCompteDebit() {
      return this.compteDebit;
   }

   public void setCompteDebit(String var1) {
      this.compteDebit = var1;
   }

   public String getModeCommission() {
      return this.modeCommission;
   }

   public void setModeCommission(String var1) {
      this.modeCommission = var1;
   }

   public String getAffichInGlobViewNOTDEB() {
      return this.affichInGlobViewNOTDEB;
   }

   public void setAffichInGlobViewNOTDEB(String var1) {
      this.affichInGlobViewNOTDEB = var1;
   }

   public String getAffichInTierFilNOTDEB() {
      return this.affichInTierFilNOTDEB;
   }

   public void setAffichInTierFilNOTDEB(String var1) {
      this.affichInTierFilNOTDEB = var1;
   }

   public String getGestionPlafondNdb() {
      return this.gestionPlafondNdb;
   }

   public void setGestionPlafondNdb(String var1) {
      this.gestionPlafondNdb = var1;
   }

   public String getNbrJrRelanceNOTDEB() {
      return this.nbrJrRelanceNOTDEB;
   }

   public void setNbrJrRelanceNOTDEB(String var1) {
      this.nbrJrRelanceNOTDEB = var1;
   }

   public String getNbrJrValidNOTDEB() {
      return this.nbrJrValidNOTDEB;
   }

   public void setNbrJrValidNOTDEB(String var1) {
      this.nbrJrValidNOTDEB = var1;
   }

   public String getTvaDefaut() {
      return this.tvaDefaut;
   }

   public void setTvaDefaut(String var1) {
      this.tvaDefaut = var1;
   }

   public String getModeRefacturation() {
      return this.modeRefacturation;
   }

   public void setModeRefacturation(String var1) {
      this.modeRefacturation = var1;
   }

   public String getDescriptifComplementaire() {
      return this.descriptifComplementaire;
   }

   public void setDescriptifComplementaire(String var1) {
      this.descriptifComplementaire = var1;
   }

   public String getAffichInGlobViewPaillasse() {
      return this.affichInGlobViewPaillasse;
   }

   public void setAffichInGlobViewPaillasse(String var1) {
      this.affichInGlobViewPaillasse = var1;
   }

   public String getCompteProduit() {
      return this.compteProduit;
   }

   public void setCompteProduit(String var1) {
      this.compteProduit = var1;
   }

   public String getCompteCNAMGSAP() {
      return this.compteCNAMGSAP;
   }

   public void setCompteCNAMGSAP(String var1) {
      this.compteCNAMGSAP = var1;
   }

   public String getCompteCNAMGSGEF() {
      return this.compteCNAMGSGEF;
   }

   public void setCompteCNAMGSGEF(String var1) {
      this.compteCNAMGSGEF = var1;
   }

   public String getCompteCNAMGSSP() {
      return this.compteCNAMGSSP;
   }

   public void setCompteCNAMGSSP(String var1) {
      this.compteCNAMGSSP = var1;
   }

   public String getNbrJrGraceCG() {
      return this.nbrJrGraceCG;
   }

   public void setNbrJrGraceCG(String var1) {
      this.nbrJrGraceCG = var1;
   }

   public String getDent() {
      return this.dent;
   }

   public void setDent(String var1) {
      this.dent = var1;
   }
}
