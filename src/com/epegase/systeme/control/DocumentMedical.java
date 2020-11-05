package com.epegase.systeme.control;

import java.io.Serializable;
import java.util.Date;

public class DocumentMedical implements Serializable {
   private long docId;
   private int docNature;
   private String docLibelleNature;
   private String docDossier;
   private String docDossierAssure;
   private String docNum;
   private String docFeuille;
   private String docNumBc;
   private Date docDate;
   private int docEtat;
   private long docIdCreateur;
   private String docNomCreateur;
   private long docIdPatient;
   private String docNomPatient;
   private String docCivilite;
   private long docIdMedecin;
   private String docNomMedecin;
   private long docIdSociete;
   private String docNomTiersSociete;
   private String docMatriculeSociete;
   private long docIdAssurance;
   private String docNomTiersAssurance;
   private String docContratAssurance;
   private long docIdComplementaire;
   private String docNomTiersComplementaire;
   private String docContratComplementaire;
   private String docCode;
   private String docProduit;
   private String docService;
   private double docTotFacture;
   private double docTotPatient;
   private double docTotTiers;
   private double docRegPatient;
   private double docRegTiers;
   private float docQte;
   private long docIdEmployeur;
   private String docNomEmployeur;
   private long docIdMotif;
   private long docIdSejour;
   private String docPathologie;
   private String docEntree;
   private String DocPrescripteur;
   private String docProtocole;
   private String docNomAssurePrincipal;
   private long docComplementaire;
   private long docFam;
   private int docFondCnamgs;
   private float docPecCnamgs;
   private Date docDateTransfert;
   private String docObs;
   private double docPu;
   private float docRemise;
   private double docCom;
   private boolean docBloqueRefacturation;
   private String libelleFamille;
   private String libelleEta;
   private String libelleNature;
   private String libelleFond;
   private String styleCouleur;
   private String libelleTiers;
   private String nomTiers;

   public String getNomTiers() {
      if (this.docNomTiersAssurance != null && !this.docNomTiersAssurance.isEmpty()) {
         this.nomTiers = this.docNomTiersAssurance;
      } else if (this.docNomTiersSociete != null && !this.docNomTiersSociete.isEmpty()) {
         this.nomTiers = this.docNomTiersSociete;
      } else if (this.docNomTiersComplementaire != null && !this.docNomTiersComplementaire.isEmpty()) {
         this.nomTiers = this.docNomTiersComplementaire;
      } else {
         this.nomTiers = "";
      }

      return this.nomTiers;
   }

   public void setNomTiers(String var1) {
      this.nomTiers = var1;
   }

   public String getLibelleTiers() {
      if (this.docIdAssurance != 0L) {
         this.libelleTiers = this.docNomTiersAssurance;
      } else if (this.docIdSociete != 0L) {
         this.libelleTiers = this.docNomTiersSociete;
      } else if (this.docIdComplementaire != 0L) {
         this.libelleTiers = this.docNomTiersComplementaire;
      } else {
         this.libelleTiers = "Privé";
      }

      return this.libelleTiers;
   }

   public void setLibelleTiers(String var1) {
      this.libelleTiers = var1;
   }

   public String getLibelleFond() {
      if (this.docFondCnamgs == 1) {
         this.libelleFond = "F1 CS (SP)";
      } else if (this.docFondCnamgs == 2) {
         this.libelleFond = "F2 CS (AP)";
      } else if (this.docFondCnamgs == 3) {
         this.libelleFond = "F3 CS (GEF)";
      } else if (this.docFondCnamgs == 11) {
         this.libelleFond = "F1 EX (SP)";
      } else if (this.docFondCnamgs == 12) {
         this.libelleFond = "F2 EX (AF)";
      } else if (this.docFondCnamgs == 13) {
         this.libelleFond = "F3 EX (GEF)";
      } else if (this.docFondCnamgs == 21) {
         this.libelleFond = "F1 PH (SP)";
      } else if (this.docFondCnamgs == 22) {
         this.libelleFond = "F2 PH (AF)";
      } else if (this.docFondCnamgs == 23) {
         this.libelleFond = "F3 PH (GEF)";
      } else if (this.docFondCnamgs == 31) {
         this.libelleFond = "F1 HP (SP)";
      } else if (this.docFondCnamgs == 32) {
         this.libelleFond = "F2 HP (AF)";
      } else if (this.docFondCnamgs == 33) {
         this.libelleFond = "F3 HP (GEF)";
      } else {
         this.libelleFond = "Erreur";
      }

      return this.libelleFond;
   }

   public void setLibelleFond(String var1) {
      this.libelleFond = var1;
   }

   public String getStyleCouleur() {
      if (this.docEtat != 2 && !this.docBloqueRefacturation) {
         if (this.docEtat == 3) {
            this.styleCouleur = "color:red;";
         } else if (this.docEtat == 5) {
            this.styleCouleur = "color:blue;";
         } else {
            this.styleCouleur = "color:black;";
         }
      } else {
         this.styleCouleur = "color:grey;";
      }

      return this.styleCouleur;
   }

   public void setStyleCouleur(String var1) {
      this.styleCouleur = var1;
   }

   public String getLibelleNature() {
      if (this.docNature == 71) {
         this.libelleNature = "Consultation";
      } else if (this.docNature == 73) {
         this.libelleNature = "Pharmacie";
      } else if (this.docNature == 74) {
         this.libelleNature = "Laboratoire";
      } else if (this.docNature == 76) {
         this.libelleNature = "Hospitalidation";
      } else {
         this.libelleNature = this.docNature + " ???";
      }

      return this.libelleNature;
   }

   public void setLibelleNature(String var1) {
      this.libelleNature = var1;
   }

   public String getLibelleFamille() {
      if (this.docFam == 0L) {
         this.libelleFamille = "Non Assuré";
      } else if (this.docFam == -1L) {
         this.libelleFamille = "Cas Social";
      } else if (this.docFam == -2L) {
         this.libelleFamille = "Etat";
      } else {
         this.libelleFamille = "Assuré";
      }

      return this.libelleFamille;
   }

   public void setLibelleFamille(String var1) {
      this.libelleFamille = var1;
   }

   public String getLibelleEta() {
      if (this.docEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.docEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.docEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.docEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.docEtat == 4) {
         this.libelleEta = "Cloture.";
      } else if (this.docEtat == 5) {
         this.libelleEta = "Ctrl.";
      } else if (this.docEtat == 6) {
         this.libelleEta = "Refact.Std";
      } else if (this.docEtat == 7) {
         this.libelleEta = "Refact.Cpl";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getDocCode() {
      return this.docCode;
   }

   public void setDocCode(String var1) {
      this.docCode = var1;
   }

   public long getDocId() {
      return this.docId;
   }

   public void setDocId(long var1) {
      this.docId = var1;
   }

   public long getDocIdCreateur() {
      return this.docIdCreateur;
   }

   public void setDocIdCreateur(long var1) {
      this.docIdCreateur = var1;
   }

   public String getDocLibelleNature() {
      return this.docLibelleNature;
   }

   public void setDocLibelleNature(String var1) {
      this.docLibelleNature = var1;
   }

   public int getDocNature() {
      return this.docNature;
   }

   public void setDocNature(int var1) {
      this.docNature = var1;
   }

   public String getDocNomCreateur() {
      return this.docNomCreateur;
   }

   public void setDocNomCreateur(String var1) {
      this.docNomCreateur = var1;
   }

   public String getDocNomPatient() {
      return this.docNomPatient;
   }

   public void setDocNomPatient(String var1) {
      this.docNomPatient = var1;
   }

   public String getDocNum() {
      return this.docNum;
   }

   public void setDocNum(String var1) {
      this.docNum = var1;
   }

   public String getDocProduit() {
      return this.docProduit;
   }

   public void setDocProduit(String var1) {
      this.docProduit = var1;
   }

   public float getDocQte() {
      return this.docQte;
   }

   public void setDocQte(float var1) {
      this.docQte = var1;
   }

   public double getDocRegPatient() {
      return this.docRegPatient;
   }

   public void setDocRegPatient(double var1) {
      this.docRegPatient = var1;
   }

   public double getDocRegTiers() {
      return this.docRegTiers;
   }

   public void setDocRegTiers(double var1) {
      this.docRegTiers = var1;
   }

   public String getDocService() {
      return this.docService;
   }

   public void setDocService(String var1) {
      this.docService = var1;
   }

   public double getDocTotPatient() {
      return this.docTotPatient;
   }

   public void setDocTotPatient(double var1) {
      this.docTotPatient = var1;
   }

   public double getDocTotTiers() {
      return this.docTotTiers;
   }

   public void setDocTotTiers(double var1) {
      this.docTotTiers = var1;
   }

   public Date getDocDate() {
      return this.docDate;
   }

   public void setDocDate(Date var1) {
      this.docDate = var1;
   }

   public String getDocNomMedecin() {
      return this.docNomMedecin;
   }

   public void setDocNomMedecin(String var1) {
      this.docNomMedecin = var1;
   }

   public String getDocNomTiersAssurance() {
      return this.docNomTiersAssurance;
   }

   public void setDocNomTiersAssurance(String var1) {
      this.docNomTiersAssurance = var1;
   }

   public String getDocNomTiersComplementaire() {
      return this.docNomTiersComplementaire;
   }

   public void setDocNomTiersComplementaire(String var1) {
      this.docNomTiersComplementaire = var1;
   }

   public String getDocNomTiersSociete() {
      return this.docNomTiersSociete;
   }

   public void setDocNomTiersSociete(String var1) {
      this.docNomTiersSociete = var1;
   }

   public long getDocIdAssurance() {
      return this.docIdAssurance;
   }

   public void setDocIdAssurance(long var1) {
      this.docIdAssurance = var1;
   }

   public long getDocIdComplementaire() {
      return this.docIdComplementaire;
   }

   public void setDocIdComplementaire(long var1) {
      this.docIdComplementaire = var1;
   }

   public long getDocIdMedecin() {
      return this.docIdMedecin;
   }

   public void setDocIdMedecin(long var1) {
      this.docIdMedecin = var1;
   }

   public long getDocIdPatient() {
      return this.docIdPatient;
   }

   public void setDocIdPatient(long var1) {
      this.docIdPatient = var1;
   }

   public long getDocIdSociete() {
      return this.docIdSociete;
   }

   public void setDocIdSociete(long var1) {
      this.docIdSociete = var1;
   }

   public long getDocIdEmployeur() {
      return this.docIdEmployeur;
   }

   public void setDocIdEmployeur(long var1) {
      this.docIdEmployeur = var1;
   }

   public long getDocIdMotif() {
      return this.docIdMotif;
   }

   public void setDocIdMotif(long var1) {
      this.docIdMotif = var1;
   }

   public long getDocIdSejour() {
      return this.docIdSejour;
   }

   public void setDocIdSejour(long var1) {
      this.docIdSejour = var1;
   }

   public String getDocNomEmployeur() {
      return this.docNomEmployeur;
   }

   public void setDocNomEmployeur(String var1) {
      this.docNomEmployeur = var1;
   }

   public String getDocNumBc() {
      return this.docNumBc;
   }

   public void setDocNumBc(String var1) {
      this.docNumBc = var1;
   }

   public long getDocComplementaire() {
      return this.docComplementaire;
   }

   public void setDocComplementaire(long var1) {
      this.docComplementaire = var1;
   }

   public long getDocFam() {
      return this.docFam;
   }

   public void setDocFam(long var1) {
      this.docFam = var1;
   }

   public int getDocFondCnamgs() {
      return this.docFondCnamgs;
   }

   public void setDocFondCnamgs(int var1) {
      this.docFondCnamgs = var1;
   }

   public String getDocPathologie() {
      return this.docPathologie;
   }

   public void setDocPathologie(String var1) {
      this.docPathologie = var1;
   }

   public float getDocPecCnamgs() {
      return this.docPecCnamgs;
   }

   public void setDocPecCnamgs(float var1) {
      this.docPecCnamgs = var1;
   }

   public String getDocProtocole() {
      return this.docProtocole;
   }

   public void setDocProtocole(String var1) {
      this.docProtocole = var1;
   }

   public String getDocPrescripteur() {
      return this.DocPrescripteur;
   }

   public void setDocPrescripteur(String var1) {
      this.DocPrescripteur = var1;
   }

   public String getDocNomAssurePrincipal() {
      return this.docNomAssurePrincipal;
   }

   public void setDocNomAssurePrincipal(String var1) {
      this.docNomAssurePrincipal = var1;
   }

   public String getDocDossier() {
      return this.docDossier;
   }

   public void setDocDossier(String var1) {
      this.docDossier = var1;
   }

   public int getDocEtat() {
      return this.docEtat;
   }

   public void setDocEtat(int var1) {
      this.docEtat = var1;
   }

   public String getDocCivilite() {
      return this.docCivilite;
   }

   public void setDocCivilite(String var1) {
      this.docCivilite = var1;
   }

   public String getDocEntree() {
      return this.docEntree;
   }

   public void setDocEntree(String var1) {
      this.docEntree = var1;
   }

   public Date getDocDateTransfert() {
      return this.docDateTransfert;
   }

   public void setDocDateTransfert(Date var1) {
      this.docDateTransfert = var1;
   }

   public boolean isDocBloqueRefacturation() {
      return this.docBloqueRefacturation;
   }

   public void setDocBloqueRefacturation(boolean var1) {
      this.docBloqueRefacturation = var1;
   }

   public String getDocContratAssurance() {
      return this.docContratAssurance;
   }

   public void setDocContratAssurance(String var1) {
      this.docContratAssurance = var1;
   }

   public String getDocContratComplementaire() {
      return this.docContratComplementaire;
   }

   public void setDocContratComplementaire(String var1) {
      this.docContratComplementaire = var1;
   }

   public String getDocMatriculeSociete() {
      return this.docMatriculeSociete;
   }

   public void setDocMatriculeSociete(String var1) {
      this.docMatriculeSociete = var1;
   }

   public String getDocFeuille() {
      return this.docFeuille;
   }

   public void setDocFeuille(String var1) {
      this.docFeuille = var1;
   }

   public double getDocTotFacture() {
      return this.docTotFacture;
   }

   public void setDocTotFacture(double var1) {
      this.docTotFacture = var1;
   }

   public String getDocObs() {
      return this.docObs;
   }

   public void setDocObs(String var1) {
      this.docObs = var1;
   }

   public double getDocPu() {
      return this.docPu;
   }

   public void setDocPu(double var1) {
      this.docPu = var1;
   }

   public float getDocRemise() {
      return this.docRemise;
   }

   public void setDocRemise(float var1) {
      this.docRemise = var1;
   }

   public double getDocCom() {
      return this.docCom;
   }

   public void setDocCom(double var1) {
      this.docCom = var1;
   }

   public String getDocDossierAssure() {
      return this.docDossierAssure;
   }

   public void setDocDossierAssure(String var1) {
      this.docDossierAssure = var1;
   }
}
