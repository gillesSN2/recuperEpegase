package com.epegase.systeme.xml;

import java.io.Serializable;

public class OptionVentes implements Serializable {
   private String affichInGlobViewCAMPAGNE;
   private String nbrJrRelanceBESOIN;
   private String nbrJrValidBESOIN;
   private String affichInTierFilBESOIN;
   private String affichInGlobViewBESOIN;
   private String nbrJrRelanceSIMUL;
   private String nbrJrValidSIMUL;
   private String affichInTierFilSIMUL;
   private String affichInGlobViewSIMUL;
   private String familleProduitSIMUL;
   private String affichInTierAffaire;
   private String affichInGlobViewAffaire;
   private String nbrJrRelanceDEVIS;
   private String nbrJrValidDEVIS;
   private String affichInTierFilDEVIS;
   private String affichInGlobViewDEVIS;
   private String validationDevisBcCOM;
   private String modeCalculDevis;
   private String nbrJrRelanceCOM;
   private String nbrJrValidCOM;
   private String affichInTierFilCOM;
   private String affichInGlobViewCOM;
   private String impressionBcBlCOM;
   private String validationBcBlCOM;
   private String generationBcFab;
   private String gestionStockBc;
   private String gestionPlafondBc;
   private String nbrJrRelanceLIV;
   private String nbrJrValidLIV;
   private String affichInTierFilLIV;
   private String affichInGlobViewLIV;
   private String gestionLivreur;
   private String nbrJrRelanceFAC;
   private String nbrJrValidFAC;
   private String affichInTierFilFAC;
   private String affichInGlobViewFAC;
   private int numBlFac;
   private String gestionPlafondFac;
   private String gestionImpressionFac;
   private String gestionNumeroFac;
   private String nbrJrRelanceNOTDEB;
   private String nbrJrValidNOTDEB;
   private String affichInTierFilNOTDEB;
   private String affichInGlobViewNOTDEB;
   private String gestionPlafondNdb;
   private String nbrJrRelanceRETOUR;
   private String nbrJrValidRETOUR;
   private String affichInTierFilRETOUR;
   private String affichInGlobViewRETOUR;
   private String nbrJrRelanceAVOIR;
   private String nbrJrValidAVOIR;
   private String affichInTierFilAVOIR;
   private String affichInGlobViewAVOIR;
   private String paiementAVOIR;
   private String modeAvoir;
   private String affichInGlobViewCh;
   private String depotChargementDefaut;
   private String affichInGlobViewCOMMISSION;
   private String facture;
   private String avoir;
   private String noteDebit;
   private String modeCommission;
   private String compteDebit;
   private String gestRegSectPdvBLC;
   private String gestActBLC;
   private String affichInTierFilBLC;
   private String affichInGlobViewBLC;
   private String gestRegSectPdvFACTC;
   private String gestActFACTC;
   private String affichInTierFilFACTC;
   private String affichInGlobViewFACTC;
   private String gestRegSectPdvTICKC;
   private String gestActTICKC;
   private String affichInTierFilTICKC;
   private String affichInGlobViewTICKC;
   private String caisseDefaut;
   private String caisseLivreur;
   private String caisseTable;
   private String caisseChambre;
   private String caisseStock;
   private String nbrCaracteresFamPRO;
   private String nbrCaracteresProPRO;
   private String modCalcProPRO;
   private String nbDecQte;
   private String nbDecPu;
   private String decrmtPriVteStock;
   private String decrmtRabais;
   private String decrmtPrsChrStock;
   private String analAuto;
   private String nbLigneMax;
   private String libProduit;
   private String responsable;
   private String produitGenerique;
   private String photosProduit;
   private String chargementListe;
   private String descriptifComplementaire;
   private String activiteEnteteLigne;
   private String dateTransformation;
   private String libelleProduit;
   private String tvaDefaut;
   private String tlvDefaut;
   private String tomDefaut;
   private String irppDefaut;
   private String produitAchat;
   private String choixStock;
   private String tracabilite;
   private String transformation;
   private String impPoids;
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
   private String axeStructure;
   private String axeSite;
   private String axeRegion;
   private String axeUsine;
   private String axeActivite;
   private String axeAgent;
   private String axeChantier;
   private String axeParc;
   private String axeMission;
   private String axeCles;
   private String axeProjet;
   private String axeDossier;
   private String chronoMatricule;
   private String affichInGlobViewINVENTAIRE;
   private String affichInGlobViewCARNET;
   private String saisieCarnet;
   private String affichInGlobViewROULAGE;
   private String saisieRoulage;
   private String affichInGlobViewROUTE;
   private String saisieRoute;
   private String affichInGlobViewEXPEDITION;
   private String saisieExpedition;

   public String getAffichInGlobViewAVOIR() {
      return this.affichInGlobViewAVOIR;
   }

   public void setAffichInGlobViewAVOIR(String var1) {
      this.affichInGlobViewAVOIR = var1;
   }

   public String getAffichInGlobViewBESOIN() {
      return this.affichInGlobViewBESOIN;
   }

   public void setAffichInGlobViewBESOIN(String var1) {
      this.affichInGlobViewBESOIN = var1;
   }

   public String getAffichInGlobViewBLC() {
      return this.affichInGlobViewBLC;
   }

   public void setAffichInGlobViewBLC(String var1) {
      this.affichInGlobViewBLC = var1;
   }

   public String getAffichInGlobViewCOM() {
      return this.affichInGlobViewCOM;
   }

   public void setAffichInGlobViewCOM(String var1) {
      this.affichInGlobViewCOM = var1;
   }

   public String getAffichInGlobViewCh() {
      return this.affichInGlobViewCh;
   }

   public void setAffichInGlobViewCh(String var1) {
      this.affichInGlobViewCh = var1;
   }

   public String getAffichInGlobViewDEVIS() {
      return this.affichInGlobViewDEVIS;
   }

   public void setAffichInGlobViewDEVIS(String var1) {
      this.affichInGlobViewDEVIS = var1;
   }

   public String getAffichInGlobViewFAC() {
      return this.affichInGlobViewFAC;
   }

   public void setAffichInGlobViewFAC(String var1) {
      this.affichInGlobViewFAC = var1;
   }

   public String getAffichInGlobViewFACTC() {
      return this.affichInGlobViewFACTC;
   }

   public void setAffichInGlobViewFACTC(String var1) {
      this.affichInGlobViewFACTC = var1;
   }

   public String getAffichInGlobViewLIV() {
      return this.affichInGlobViewLIV;
   }

   public void setAffichInGlobViewLIV(String var1) {
      this.affichInGlobViewLIV = var1;
   }

   public String getAffichInGlobViewNOTDEB() {
      return this.affichInGlobViewNOTDEB;
   }

   public void setAffichInGlobViewNOTDEB(String var1) {
      this.affichInGlobViewNOTDEB = var1;
   }

   public String getAffichInGlobViewRETOUR() {
      return this.affichInGlobViewRETOUR;
   }

   public void setAffichInGlobViewRETOUR(String var1) {
      this.affichInGlobViewRETOUR = var1;
   }

   public String getAffichInGlobViewTICKC() {
      return this.affichInGlobViewTICKC;
   }

   public void setAffichInGlobViewTICKC(String var1) {
      this.affichInGlobViewTICKC = var1;
   }

   public String getAffichInTierFilAVOIR() {
      return this.affichInTierFilAVOIR;
   }

   public void setAffichInTierFilAVOIR(String var1) {
      this.affichInTierFilAVOIR = var1;
   }

   public String getAffichInTierFilBESOIN() {
      return this.affichInTierFilBESOIN;
   }

   public void setAffichInTierFilBESOIN(String var1) {
      this.affichInTierFilBESOIN = var1;
   }

   public String getAffichInTierFilBLC() {
      return this.affichInTierFilBLC;
   }

   public void setAffichInTierFilBLC(String var1) {
      this.affichInTierFilBLC = var1;
   }

   public String getAffichInTierFilCOM() {
      return this.affichInTierFilCOM;
   }

   public void setAffichInTierFilCOM(String var1) {
      this.affichInTierFilCOM = var1;
   }

   public String getAffichInTierFilDEVIS() {
      return this.affichInTierFilDEVIS;
   }

   public void setAffichInTierFilDEVIS(String var1) {
      this.affichInTierFilDEVIS = var1;
   }

   public String getAffichInTierFilFAC() {
      return this.affichInTierFilFAC;
   }

   public void setAffichInTierFilFAC(String var1) {
      this.affichInTierFilFAC = var1;
   }

   public String getAffichInTierFilFACTC() {
      return this.affichInTierFilFACTC;
   }

   public void setAffichInTierFilFACTC(String var1) {
      this.affichInTierFilFACTC = var1;
   }

   public String getAffichInTierFilLIV() {
      return this.affichInTierFilLIV;
   }

   public void setAffichInTierFilLIV(String var1) {
      this.affichInTierFilLIV = var1;
   }

   public String getAffichInTierFilNOTDEB() {
      return this.affichInTierFilNOTDEB;
   }

   public void setAffichInTierFilNOTDEB(String var1) {
      this.affichInTierFilNOTDEB = var1;
   }

   public String getAffichInTierFilRETOUR() {
      return this.affichInTierFilRETOUR;
   }

   public void setAffichInTierFilRETOUR(String var1) {
      this.affichInTierFilRETOUR = var1;
   }

   public String getAffichInTierFilTICKC() {
      return this.affichInTierFilTICKC;
   }

   public void setAffichInTierFilTICKC(String var1) {
      this.affichInTierFilTICKC = var1;
   }

   public String getDecrmtPriVteStock() {
      return this.decrmtPriVteStock;
   }

   public void setDecrmtPriVteStock(String var1) {
      this.decrmtPriVteStock = var1;
   }

   public String getDecrmtPrsChrStock() {
      return this.decrmtPrsChrStock;
   }

   public void setDecrmtPrsChrStock(String var1) {
      this.decrmtPrsChrStock = var1;
   }

   public String getDecrmtRabais() {
      return this.decrmtRabais;
   }

   public void setDecrmtRabais(String var1) {
      this.decrmtRabais = var1;
   }

   public String getGestActBLC() {
      return this.gestActBLC;
   }

   public void setGestActBLC(String var1) {
      this.gestActBLC = var1;
   }

   public String getGestActFACTC() {
      return this.gestActFACTC;
   }

   public void setGestActFACTC(String var1) {
      this.gestActFACTC = var1;
   }

   public String getGestActTICKC() {
      return this.gestActTICKC;
   }

   public void setGestActTICKC(String var1) {
      this.gestActTICKC = var1;
   }

   public String getGestRegSectPdvBLC() {
      return this.gestRegSectPdvBLC;
   }

   public void setGestRegSectPdvBLC(String var1) {
      this.gestRegSectPdvBLC = var1;
   }

   public String getGestRegSectPdvFACTC() {
      return this.gestRegSectPdvFACTC;
   }

   public void setGestRegSectPdvFACTC(String var1) {
      this.gestRegSectPdvFACTC = var1;
   }

   public String getGestRegSectPdvTICKC() {
      return this.gestRegSectPdvTICKC;
   }

   public void setGestRegSectPdvTICKC(String var1) {
      this.gestRegSectPdvTICKC = var1;
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

   public String getModCalcProPRO() {
      return this.modCalcProPRO;
   }

   public void setModCalcProPRO(String var1) {
      this.modCalcProPRO = var1;
   }

   public String getNbrCaracteresFamPRO() {
      return this.nbrCaracteresFamPRO;
   }

   public void setNbrCaracteresFamPRO(String var1) {
      this.nbrCaracteresFamPRO = var1;
   }

   public String getNbrCaracteresProPRO() {
      return this.nbrCaracteresProPRO;
   }

   public void setNbrCaracteresProPRO(String var1) {
      this.nbrCaracteresProPRO = var1;
   }

   public String getNbrJrRelanceAVOIR() {
      return this.nbrJrRelanceAVOIR;
   }

   public void setNbrJrRelanceAVOIR(String var1) {
      this.nbrJrRelanceAVOIR = var1;
   }

   public String getNbrJrRelanceBESOIN() {
      return this.nbrJrRelanceBESOIN;
   }

   public void setNbrJrRelanceBESOIN(String var1) {
      this.nbrJrRelanceBESOIN = var1;
   }

   public String getNbrJrRelanceCOM() {
      return this.nbrJrRelanceCOM;
   }

   public void setNbrJrRelanceCOM(String var1) {
      this.nbrJrRelanceCOM = var1;
   }

   public String getNbrJrRelanceDEVIS() {
      return this.nbrJrRelanceDEVIS;
   }

   public void setNbrJrRelanceDEVIS(String var1) {
      this.nbrJrRelanceDEVIS = var1;
   }

   public String getNbrJrRelanceFAC() {
      return this.nbrJrRelanceFAC;
   }

   public void setNbrJrRelanceFAC(String var1) {
      this.nbrJrRelanceFAC = var1;
   }

   public String getNbrJrRelanceLIV() {
      return this.nbrJrRelanceLIV;
   }

   public void setNbrJrRelanceLIV(String var1) {
      this.nbrJrRelanceLIV = var1;
   }

   public String getNbrJrRelanceNOTDEB() {
      return this.nbrJrRelanceNOTDEB;
   }

   public void setNbrJrRelanceNOTDEB(String var1) {
      this.nbrJrRelanceNOTDEB = var1;
   }

   public String getNbrJrRelanceRETOUR() {
      return this.nbrJrRelanceRETOUR;
   }

   public void setNbrJrRelanceRETOUR(String var1) {
      this.nbrJrRelanceRETOUR = var1;
   }

   public String getNbrJrValidAVOIR() {
      return this.nbrJrValidAVOIR;
   }

   public void setNbrJrValidAVOIR(String var1) {
      this.nbrJrValidAVOIR = var1;
   }

   public String getNbrJrValidBESOIN() {
      return this.nbrJrValidBESOIN;
   }

   public void setNbrJrValidBESOIN(String var1) {
      this.nbrJrValidBESOIN = var1;
   }

   public String getNbrJrValidCOM() {
      return this.nbrJrValidCOM;
   }

   public void setNbrJrValidCOM(String var1) {
      this.nbrJrValidCOM = var1;
   }

   public String getNbrJrValidDEVIS() {
      return this.nbrJrValidDEVIS;
   }

   public void setNbrJrValidDEVIS(String var1) {
      this.nbrJrValidDEVIS = var1;
   }

   public String getNbrJrValidFAC() {
      return this.nbrJrValidFAC;
   }

   public void setNbrJrValidFAC(String var1) {
      this.nbrJrValidFAC = var1;
   }

   public String getNbrJrValidLIV() {
      return this.nbrJrValidLIV;
   }

   public void setNbrJrValidLIV(String var1) {
      this.nbrJrValidLIV = var1;
   }

   public String getNbrJrValidNOTDEB() {
      return this.nbrJrValidNOTDEB;
   }

   public void setNbrJrValidNOTDEB(String var1) {
      this.nbrJrValidNOTDEB = var1;
   }

   public String getNbrJrValidRETOUR() {
      return this.nbrJrValidRETOUR;
   }

   public void setNbrJrValidRETOUR(String var1) {
      this.nbrJrValidRETOUR = var1;
   }

   public String getAnalAuto() {
      return this.analAuto;
   }

   public void setAnalAuto(String var1) {
      this.analAuto = var1;
   }

   public String getNbLigneMax() {
      return this.nbLigneMax;
   }

   public void setNbLigneMax(String var1) {
      this.nbLigneMax = var1;
   }

   public String getGestionLivreur() {
      return this.gestionLivreur;
   }

   public void setGestionLivreur(String var1) {
      this.gestionLivreur = var1;
   }

   public String getLibProduit() {
      return this.libProduit;
   }

   public void setLibProduit(String var1) {
      this.libProduit = var1;
   }

   public String getAffichInGlobViewSIMUL() {
      return this.affichInGlobViewSIMUL;
   }

   public void setAffichInGlobViewSIMUL(String var1) {
      this.affichInGlobViewSIMUL = var1;
   }

   public String getAffichInTierFilSIMUL() {
      return this.affichInTierFilSIMUL;
   }

   public void setAffichInTierFilSIMUL(String var1) {
      this.affichInTierFilSIMUL = var1;
   }

   public String getFamilleProduitSIMUL() {
      return this.familleProduitSIMUL;
   }

   public void setFamilleProduitSIMUL(String var1) {
      this.familleProduitSIMUL = var1;
   }

   public String getNbrJrRelanceSIMUL() {
      return this.nbrJrRelanceSIMUL;
   }

   public void setNbrJrRelanceSIMUL(String var1) {
      this.nbrJrRelanceSIMUL = var1;
   }

   public String getNbrJrValidSIMUL() {
      return this.nbrJrValidSIMUL;
   }

   public void setNbrJrValidSIMUL(String var1) {
      this.nbrJrValidSIMUL = var1;
   }

   public String getNbDecPu() {
      return this.nbDecPu;
   }

   public void setNbDecPu(String var1) {
      this.nbDecPu = var1;
   }

   public String getDepotChargementDefaut() {
      return this.depotChargementDefaut;
   }

   public void setDepotChargementDefaut(String var1) {
      this.depotChargementDefaut = var1;
   }

   public String getNbDecQte() {
      return this.nbDecQte;
   }

   public void setNbDecQte(String var1) {
      this.nbDecQte = var1;
   }

   public String getResponsable() {
      return this.responsable;
   }

   public void setResponsable(String var1) {
      this.responsable = var1;
   }

   public String getProduitGenerique() {
      return this.produitGenerique;
   }

   public void setProduitGenerique(String var1) {
      this.produitGenerique = var1;
   }

   public String getAffichInGlobViewCOMMISSION() {
      return this.affichInGlobViewCOMMISSION;
   }

   public void setAffichInGlobViewCOMMISSION(String var1) {
      this.affichInGlobViewCOMMISSION = var1;
   }

   public String getAvoir() {
      return this.avoir;
   }

   public void setAvoir(String var1) {
      this.avoir = var1;
   }

   public String getFacture() {
      return this.facture;
   }

   public void setFacture(String var1) {
      this.facture = var1;
   }

   public String getModeCommission() {
      return this.modeCommission;
   }

   public void setModeCommission(String var1) {
      this.modeCommission = var1;
   }

   public String getNoteDebit() {
      return this.noteDebit;
   }

   public void setNoteDebit(String var1) {
      this.noteDebit = var1;
   }

   public String getCompteDebit() {
      return this.compteDebit;
   }

   public void setCompteDebit(String var1) {
      this.compteDebit = var1;
   }

   public String getCaisseDefaut() {
      return this.caisseDefaut;
   }

   public void setCaisseDefaut(String var1) {
      this.caisseDefaut = var1;
   }

   public String getChargementListe() {
      return this.chargementListe;
   }

   public void setChargementListe(String var1) {
      this.chargementListe = var1;
   }

   public String getZoneLibelle() {
      return this.zoneLibelle;
   }

   public void setZoneLibelle(String var1) {
      this.zoneLibelle = var1;
   }

   public String getZoneRef1() {
      return this.zoneRef1;
   }

   public void setZoneRef1(String var1) {
      this.zoneRef1 = var1;
   }

   public String getZoneRef2() {
      return this.zoneRef2;
   }

   public void setZoneRef2(String var1) {
      this.zoneRef2 = var1;
   }

   public String getZoneLibelleSuite() {
      return this.zoneLibelleSuite;
   }

   public void setZoneLibelleSuite(String var1) {
      this.zoneLibelleSuite = var1;
   }

   public String getTransfertDocument() {
      return this.transfertDocument;
   }

   public void setTransfertDocument(String var1) {
      this.transfertDocument = var1;
   }

   public String getDescriptifComplementaire() {
      return this.descriptifComplementaire;
   }

   public void setDescriptifComplementaire(String var1) {
      this.descriptifComplementaire = var1;
   }

   public String getPaiementAVOIR() {
      return this.paiementAVOIR;
   }

   public void setPaiementAVOIR(String var1) {
      this.paiementAVOIR = var1;
   }

   public String getImpressionBcBlCOM() {
      return this.impressionBcBlCOM;
   }

   public void setImpressionBcBlCOM(String var1) {
      this.impressionBcBlCOM = var1;
   }

   public int getNumBlFac() {
      return this.numBlFac;
   }

   public void setNumBlFac(int var1) {
      this.numBlFac = var1;
   }

   public String getActiviteEnteteLigne() {
      return this.activiteEnteteLigne;
   }

   public void setActiviteEnteteLigne(String var1) {
      this.activiteEnteteLigne = var1;
   }

   public String getDateTransformation() {
      return this.dateTransformation;
   }

   public void setDateTransformation(String var1) {
      this.dateTransformation = var1;
   }

   public String getLibelleProduit() {
      return this.libelleProduit;
   }

   public void setLibelleProduit(String var1) {
      this.libelleProduit = var1;
   }

   public String getTvaDefaut() {
      return this.tvaDefaut;
   }

   public void setTvaDefaut(String var1) {
      this.tvaDefaut = var1;
   }

   public String getProduitAchat() {
      return this.produitAchat;
   }

   public void setProduitAchat(String var1) {
      this.produitAchat = var1;
   }

   public String getAffichInGlobViewCAMPAGNE() {
      return this.affichInGlobViewCAMPAGNE;
   }

   public void setAffichInGlobViewCAMPAGNE(String var1) {
      this.affichInGlobViewCAMPAGNE = var1;
   }

   public String getTlvDefaut() {
      return this.tlvDefaut;
   }

   public void setTlvDefaut(String var1) {
      this.tlvDefaut = var1;
   }

   public String getTomDefaut() {
      return this.tomDefaut;
   }

   public void setTomDefaut(String var1) {
      this.tomDefaut = var1;
   }

   public String getIrppDefaut() {
      return this.irppDefaut;
   }

   public void setIrppDefaut(String var1) {
      this.irppDefaut = var1;
   }

   public String getPhotosProduit() {
      return this.photosProduit;
   }

   public void setPhotosProduit(String var1) {
      this.photosProduit = var1;
   }

   public String getChoixStock() {
      return this.choixStock;
   }

   public void setChoixStock(String var1) {
      this.choixStock = var1;
   }

   public String getValidationBcBlCOM() {
      return this.validationBcBlCOM;
   }

   public void setValidationBcBlCOM(String var1) {
      this.validationBcBlCOM = var1;
   }

   public String getGenerationBcFab() {
      return this.generationBcFab;
   }

   public void setGenerationBcFab(String var1) {
      this.generationBcFab = var1;
   }

   public String getCaisseStock() {
      return this.caisseStock;
   }

   public void setCaisseStock(String var1) {
      this.caisseStock = var1;
   }

   public String getCaisseChambre() {
      return this.caisseChambre;
   }

   public void setCaisseChambre(String var1) {
      this.caisseChambre = var1;
   }

   public String getCaisseLivreur() {
      return this.caisseLivreur;
   }

   public void setCaisseLivreur(String var1) {
      this.caisseLivreur = var1;
   }

   public String getCaisseTable() {
      return this.caisseTable;
   }

   public void setCaisseTable(String var1) {
      this.caisseTable = var1;
   }

   public String getGestionStockBc() {
      return this.gestionStockBc;
   }

   public void setGestionStockBc(String var1) {
      this.gestionStockBc = var1;
   }

   public String getValidationDevisBcCOM() {
      return this.validationDevisBcCOM;
   }

   public void setValidationDevisBcCOM(String var1) {
      this.validationDevisBcCOM = var1;
   }

   public String getAxeActivite() {
      return this.axeActivite;
   }

   public void setAxeActivite(String var1) {
      this.axeActivite = var1;
   }

   public String getAxeAgent() {
      return this.axeAgent;
   }

   public void setAxeAgent(String var1) {
      this.axeAgent = var1;
   }

   public String getAxeChantier() {
      return this.axeChantier;
   }

   public void setAxeChantier(String var1) {
      this.axeChantier = var1;
   }

   public String getAxeCles() {
      return this.axeCles;
   }

   public void setAxeCles(String var1) {
      this.axeCles = var1;
   }

   public String getAxeDossier() {
      return this.axeDossier;
   }

   public void setAxeDossier(String var1) {
      this.axeDossier = var1;
   }

   public String getAxeMission() {
      return this.axeMission;
   }

   public void setAxeMission(String var1) {
      this.axeMission = var1;
   }

   public String getAxeParc() {
      return this.axeParc;
   }

   public void setAxeParc(String var1) {
      this.axeParc = var1;
   }

   public String getAxeProjet() {
      return this.axeProjet;
   }

   public void setAxeProjet(String var1) {
      this.axeProjet = var1;
   }

   public String getAxeRegion() {
      return this.axeRegion;
   }

   public void setAxeRegion(String var1) {
      this.axeRegion = var1;
   }

   public String getAxeSite() {
      return this.axeSite;
   }

   public void setAxeSite(String var1) {
      this.axeSite = var1;
   }

   public String getAxeStructure() {
      return this.axeStructure;
   }

   public void setAxeStructure(String var1) {
      this.axeStructure = var1;
   }

   public String getAxeUsine() {
      return this.axeUsine;
   }

   public void setAxeUsine(String var1) {
      this.axeUsine = var1;
   }

   public String getZoneRef1Serie() {
      return this.zoneRef1Serie;
   }

   public void setZoneRef1Serie(String var1) {
      this.zoneRef1Serie = var1;
   }

   public String getZoneRef2Serie() {
      return this.zoneRef2Serie;
   }

   public void setZoneRef2Serie(String var1) {
      this.zoneRef2Serie = var1;
   }

   public String getGestionPlafondBc() {
      return this.gestionPlafondBc;
   }

   public void setGestionPlafondBc(String var1) {
      this.gestionPlafondBc = var1;
   }

   public String getGestionPlafondFac() {
      return this.gestionPlafondFac;
   }

   public void setGestionPlafondFac(String var1) {
      this.gestionPlafondFac = var1;
   }

   public String getGestionPlafondNdb() {
      return this.gestionPlafondNdb;
   }

   public void setGestionPlafondNdb(String var1) {
      this.gestionPlafondNdb = var1;
   }

   public String getTracabilite() {
      return this.tracabilite;
   }

   public void setTracabilite(String var1) {
      this.tracabilite = var1;
   }

   public String getChronoMatricule() {
      return this.chronoMatricule;
   }

   public void setChronoMatricule(String var1) {
      this.chronoMatricule = var1;
   }

   public String getModeCalculDevis() {
      return this.modeCalculDevis;
   }

   public void setModeCalculDevis(String var1) {
      this.modeCalculDevis = var1;
   }

   public String getAffichInGlobViewAffaire() {
      return this.affichInGlobViewAffaire;
   }

   public void setAffichInGlobViewAffaire(String var1) {
      this.affichInGlobViewAffaire = var1;
   }

   public String getAffichInTierAffaire() {
      return this.affichInTierAffaire;
   }

   public void setAffichInTierAffaire(String var1) {
      this.affichInTierAffaire = var1;
   }

   public String getTransformation() {
      return this.transformation;
   }

   public void setTransformation(String var1) {
      this.transformation = var1;
   }

   public String getImpPoids() {
      return this.impPoids;
   }

   public void setImpPoids(String var1) {
      this.impPoids = var1;
   }

   public String getModeAvoir() {
      return this.modeAvoir;
   }

   public void setModeAvoir(String var1) {
      this.modeAvoir = var1;
   }

   public String getGestionImpressionFac() {
      return this.gestionImpressionFac;
   }

   public void setGestionImpressionFac(String var1) {
      this.gestionImpressionFac = var1;
   }

   public String getGestionNumeroFac() {
      return this.gestionNumeroFac;
   }

   public void setGestionNumeroFac(String var1) {
      this.gestionNumeroFac = var1;
   }

   public String getAffichInGlobViewCARNET() {
      return this.affichInGlobViewCARNET;
   }

   public void setAffichInGlobViewCARNET(String var1) {
      this.affichInGlobViewCARNET = var1;
   }

   public String getAffichInGlobViewINVENTAIRE() {
      return this.affichInGlobViewINVENTAIRE;
   }

   public void setAffichInGlobViewINVENTAIRE(String var1) {
      this.affichInGlobViewINVENTAIRE = var1;
   }

   public String getSaisieCarnet() {
      return this.saisieCarnet;
   }

   public void setSaisieCarnet(String var1) {
      this.saisieCarnet = var1;
   }

   public String getAffichInGlobViewEXPEDITION() {
      return this.affichInGlobViewEXPEDITION;
   }

   public void setAffichInGlobViewEXPEDITION(String var1) {
      this.affichInGlobViewEXPEDITION = var1;
   }

   public String getAffichInGlobViewROULAGE() {
      return this.affichInGlobViewROULAGE;
   }

   public void setAffichInGlobViewROULAGE(String var1) {
      this.affichInGlobViewROULAGE = var1;
   }

   public String getAffichInGlobViewROUTE() {
      return this.affichInGlobViewROUTE;
   }

   public void setAffichInGlobViewROUTE(String var1) {
      this.affichInGlobViewROUTE = var1;
   }

   public String getSaisieExpedition() {
      return this.saisieExpedition;
   }

   public void setSaisieExpedition(String var1) {
      this.saisieExpedition = var1;
   }

   public String getSaisieRoulage() {
      return this.saisieRoulage;
   }

   public void setSaisieRoulage(String var1) {
      this.saisieRoulage = var1;
   }

   public String getSaisieRoute() {
      return this.saisieRoute;
   }

   public void setSaisieRoute(String var1) {
      this.saisieRoute = var1;
   }
}
