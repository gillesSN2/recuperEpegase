package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class LaboratoireResultat implements Serializable {
   private long labresId;
   private String labresNum;
   private String labresCode;
   private String labresLibelle;
   private int labresType;
   private int labresOrdre;
   private double labresNumerique;
   private Date labresDate;
   private String labresImage;
   private String labresPdf;
   private String labresTexte;
   private long labresReponseAction;
   private String labresReponseUnique;
   private String labresAction;
   private String labresReponseMultiple;
   private String labresUnite;
   private float labresCoef;
   private String labresUniteConvertie;
   private String labresFourchette;
   private double labresFourchetteMin;
   private double labresFourchetteMax;
   private String labresCommentaire;
   private String labresTechnique;
   private String labresNorme;
   private long labresIdLab;
   private long labresIdPatient;
   private long labresIdProdDet;
   private String labresCategorie;
   private LaboratoireLigne laboratoireLigne;
   private String libelle_type;
   private String resultat;
   private String espaceFamille;
   private String conclusionAuto;
   private String historique;
   private String labNum;
   private Date labDate;
   private String labNumHospit;
   private String labService;
   private String labLaboratoire;
   private String labProtocole;
   private String labPathologie;
   private String labPrescripteur;
   private String labMedecin;
   private String labCivilite;
   private String labNomPatient;
   private String labNumBc;
   private Date labDateResultat;
   private Date labDatePrelevement;
   private int labLieuPrelevement;
   private String labPartenaire;
   private Date labDateRegles;
   private boolean labAnomyme;
   private String labDossier;
   private String labCommentaire;
   private String labNomResultat;
   private String labInterpretation;
   private String labInterpretationTexte;
   private String labScan;
   private Date labDateNaissance;
   private String labGenre;
   private String civiliteLaboratoire;

   public String getCiviliteLaboratoire() {
      return this.civiliteLaboratoire;
   }

   public void setCiviliteLaboratoire(String var1) {
      this.civiliteLaboratoire = var1;
   }

   public Date getLabDateNaissance() {
      return this.labDateNaissance;
   }

   public void setLabDateNaissance(Date var1) {
      this.labDateNaissance = var1;
   }

   public String getLabGenre() {
      return this.labGenre;
   }

   public void setLabGenre(String var1) {
      this.labGenre = var1;
   }

   public String getEspaceFamille() {
      if (this.labresType == 0) {
         this.espaceFamille = "font-weight:bold;text-align:center";
      } else {
         this.espaceFamille = "";
      }

      return this.espaceFamille;
   }

   public void setEspaceFamille(String var1) {
      this.espaceFamille = var1;
   }

   public String getResultat() {
      if (this.labresType == 0) {
         this.resultat = "Titre";
      } else if (this.labresType == 1) {
         if (this.labresUnite != null && !this.labresUnite.isEmpty()) {
            this.resultat = "" + this.labresNumerique + " " + this.labresUnite;
         } else {
            this.resultat = "" + this.labresNumerique;
         }
      } else if (this.labresType == 2) {
         this.resultat = "" + this.labresDate;
      } else if (this.labresType == 3) {
         if (this.labresPdf != null && !this.labresPdf.isEmpty()) {
            this.resultat = "" + this.labresPdf;
         } else {
            this.resultat = "" + this.labresImage;
         }
      } else if (this.labresType == 4) {
         this.resultat = this.labresTexte;
      } else if (this.labresType == 5) {
         this.resultat = this.labresReponseUnique;
      } else if (this.labresType == 6) {
         this.resultat = this.labresReponseUnique + " " + this.labresAction;
      } else if (this.labresType == 7) {
         this.resultat = this.labresReponseMultiple;
      } else if (this.labresType == 8) {
         this.resultat = "";
      } else if (this.labresType == 9) {
         this.resultat = this.labresTexte;
      } else if (this.labresType == 10) {
         if (this.labresTexte != null && !this.labresTexte.isEmpty()) {
            this.resultat = this.labresTexte + " POSITIF";
         } else {
            this.resultat = "NEGATIF";
         }
      } else {
         this.resultat = "???" + this.labresType;
      }

      return this.resultat;
   }

   public void setResultat(String var1) {
      this.resultat = var1;
   }

   public String getLibelle_type() {
      if (this.labresType == 0) {
         this.libelle_type = "Titre";
      } else if (this.labresType == 1) {
         this.libelle_type = "Numérique";
      } else if (this.labresType == 2) {
         this.libelle_type = "Date";
      } else if (this.labresType == 3) {
         this.libelle_type = "Image/Pdf";
      } else if (this.labresType == 4) {
         this.libelle_type = "Texte long";
      } else if (this.labresType == 5) {
         this.libelle_type = "Réponse unique";
      } else if (this.labresType == 6) {
         this.libelle_type = "Réponse unique + action";
      } else if (this.labresType == 7) {
         this.libelle_type = "Réponse multiple";
      } else if (this.labresType == 8) {
         this.libelle_type = "Liste examens";
      } else if (this.labresType == 9) {
         this.libelle_type = "Texte court";
      } else if (this.labresType == 10) {
         this.libelle_type = "Texte + Négatif/Positif";
      } else {
         this.libelle_type = "??? (" + this.labresType + ")";
      }

      return this.libelle_type;
   }

   public void setLibelle_type(String var1) {
      this.libelle_type = var1;
   }

   public LaboratoireLigne getLaboratoireLigne() {
      return this.laboratoireLigne;
   }

   public void setLaboratoireLigne(LaboratoireLigne var1) {
      this.laboratoireLigne = var1;
   }

   public float getLabresCoef() {
      return this.labresCoef;
   }

   public void setLabresCoef(float var1) {
      this.labresCoef = var1;
   }

   public String getLabresCommentaire() {
      return this.labresCommentaire;
   }

   public void setLabresCommentaire(String var1) {
      this.labresCommentaire = var1;
   }

   public Date getLabresDate() {
      return this.labresDate;
   }

   public void setLabresDate(Date var1) {
      this.labresDate = var1;
   }

   public String getLabresFourchette() {
      return this.labresFourchette;
   }

   public void setLabresFourchette(String var1) {
      this.labresFourchette = var1;
   }

   public long getLabresId() {
      return this.labresId;
   }

   public void setLabresId(long var1) {
      this.labresId = var1;
   }

   public String getLabresImage() {
      return this.labresImage;
   }

   public void setLabresImage(String var1) {
      this.labresImage = var1;
   }

   public double getLabresNumerique() {
      return this.labresNumerique;
   }

   public void setLabresNumerique(double var1) {
      this.labresNumerique = var1;
   }

   public String getLabresTexte() {
      return this.labresTexte;
   }

   public void setLabresTexte(String var1) {
      this.labresTexte = var1;
   }

   public String getLabresUnite() {
      return this.labresUnite;
   }

   public void setLabresUnite(String var1) {
      this.labresUnite = var1;
   }

   public String getLabresUniteConvertie() {
      return this.labresUniteConvertie;
   }

   public void setLabresUniteConvertie(String var1) {
      this.labresUniteConvertie = var1;
   }

   public int getLabresType() {
      return this.labresType;
   }

   public void setLabresType(int var1) {
      this.labresType = var1;
   }

   public double getLabresFourchetteMax() {
      return this.labresFourchetteMax;
   }

   public void setLabresFourchetteMax(double var1) {
      this.labresFourchetteMax = var1;
   }

   public double getLabresFourchetteMin() {
      return this.labresFourchetteMin;
   }

   public void setLabresFourchetteMin(double var1) {
      this.labresFourchetteMin = var1;
   }

   public String getLabresNorme() {
      return this.labresNorme;
   }

   public void setLabresNorme(String var1) {
      this.labresNorme = var1;
   }

   public int getLabresOrdre() {
      return this.labresOrdre;
   }

   public void setLabresOrdre(int var1) {
      this.labresOrdre = var1;
   }

   public String getLabresTechnique() {
      return this.labresTechnique;
   }

   public void setLabresTechnique(String var1) {
      this.labresTechnique = var1;
   }

   public String getLabresPdf() {
      return this.labresPdf;
   }

   public void setLabresPdf(String var1) {
      this.labresPdf = var1;
   }

   public long getLabresIdLab() {
      return this.labresIdLab;
   }

   public void setLabresIdLab(long var1) {
      this.labresIdLab = var1;
   }

   public String getLabresCode() {
      return this.labresCode;
   }

   public void setLabresCode(String var1) {
      this.labresCode = var1;
   }

   public long getLabresIdPatient() {
      return this.labresIdPatient;
   }

   public void setLabresIdPatient(long var1) {
      this.labresIdPatient = var1;
   }

   public String getLabresAction() {
      return this.labresAction;
   }

   public void setLabresAction(String var1) {
      this.labresAction = var1;
   }

   public String getLabresNum() {
      return this.labresNum;
   }

   public void setLabresNum(String var1) {
      this.labresNum = var1;
   }

   public String getLabresReponseMultiple() {
      return this.labresReponseMultiple;
   }

   public void setLabresReponseMultiple(String var1) {
      this.labresReponseMultiple = var1;
   }

   public String getLabresReponseUnique() {
      return this.labresReponseUnique;
   }

   public void setLabresReponseUnique(String var1) {
      this.labresReponseUnique = var1;
   }

   public String getLabresLibelle() {
      return this.labresLibelle;
   }

   public void setLabresLibelle(String var1) {
      this.labresLibelle = var1;
   }

   public String getLabresCategorie() {
      return this.labresCategorie;
   }

   public void setLabresCategorie(String var1) {
      this.labresCategorie = var1;
   }

   public boolean isLabAnomyme() {
      return this.labAnomyme;
   }

   public void setLabAnomyme(boolean var1) {
      this.labAnomyme = var1;
   }

   public String getLabCivilite() {
      return this.labCivilite;
   }

   public void setLabCivilite(String var1) {
      this.labCivilite = var1;
   }

   public Date getLabDate() {
      return this.labDate;
   }

   public void setLabDate(Date var1) {
      this.labDate = var1;
   }

   public Date getLabDatePrelevement() {
      return this.labDatePrelevement;
   }

   public void setLabDatePrelevement(Date var1) {
      this.labDatePrelevement = var1;
   }

   public Date getLabDateRegles() {
      return this.labDateRegles;
   }

   public void setLabDateRegles(Date var1) {
      this.labDateRegles = var1;
   }

   public Date getLabDateResultat() {
      return this.labDateResultat;
   }

   public void setLabDateResultat(Date var1) {
      this.labDateResultat = var1;
   }

   public String getLabLaboratoire() {
      return this.labLaboratoire;
   }

   public void setLabLaboratoire(String var1) {
      this.labLaboratoire = var1;
   }

   public int getLabLieuPrelevement() {
      return this.labLieuPrelevement;
   }

   public void setLabLieuPrelevement(int var1) {
      this.labLieuPrelevement = var1;
   }

   public String getLabMedecin() {
      return this.labMedecin;
   }

   public void setLabMedecin(String var1) {
      this.labMedecin = var1;
   }

   public String getLabNomPatient() {
      return this.labNomPatient;
   }

   public void setLabNomPatient(String var1) {
      this.labNomPatient = var1;
   }

   public String getLabNum() {
      return this.labNum;
   }

   public void setLabNum(String var1) {
      this.labNum = var1;
   }

   public String getLabNumBc() {
      return this.labNumBc;
   }

   public void setLabNumBc(String var1) {
      this.labNumBc = var1;
   }

   public String getLabNumHospit() {
      return this.labNumHospit;
   }

   public void setLabNumHospit(String var1) {
      this.labNumHospit = var1;
   }

   public String getLabPartenaire() {
      return this.labPartenaire;
   }

   public void setLabPartenaire(String var1) {
      this.labPartenaire = var1;
   }

   public String getLabPathologie() {
      return this.labPathologie;
   }

   public void setLabPathologie(String var1) {
      this.labPathologie = var1;
   }

   public String getLabPrescripteur() {
      return this.labPrescripteur;
   }

   public void setLabPrescripteur(String var1) {
      this.labPrescripteur = var1;
   }

   public String getLabProtocole() {
      return this.labProtocole;
   }

   public void setLabProtocole(String var1) {
      this.labProtocole = var1;
   }

   public String getLabService() {
      return this.labService;
   }

   public void setLabService(String var1) {
      this.labService = var1;
   }

   public String getLabDossier() {
      return this.labDossier;
   }

   public void setLabDossier(String var1) {
      this.labDossier = var1;
   }

   public String getLabCommentaire() {
      return this.labCommentaire;
   }

   public void setLabCommentaire(String var1) {
      this.labCommentaire = var1;
   }

   public String getLabNomResultat() {
      return this.labNomResultat;
   }

   public void setLabNomResultat(String var1) {
      this.labNomResultat = var1;
   }

   public String getLabInterpretation() {
      return this.labInterpretation;
   }

   public void setLabInterpretation(String var1) {
      this.labInterpretation = var1;
   }

   public long getLabresReponseAction() {
      return this.labresReponseAction;
   }

   public void setLabresReponseAction(long var1) {
      this.labresReponseAction = var1;
   }

   public String getConclusionAuto() {
      return this.conclusionAuto;
   }

   public void setConclusionAuto(String var1) {
      this.conclusionAuto = var1;
   }

   public String getHistorique() {
      return this.historique;
   }

   public void setHistorique(String var1) {
      this.historique = var1;
   }

   public long getLabresIdProdDet() {
      return this.labresIdProdDet;
   }

   public void setLabresIdProdDet(long var1) {
      this.labresIdProdDet = var1;
   }

   public String getLabScan() {
      return this.labScan;
   }

   public void setLabScan(String var1) {
      this.labScan = var1;
   }

   public String getLabInterpretationTexte() {
      return this.labInterpretationTexte;
   }

   public void setLabInterpretationTexte(String var1) {
      this.labInterpretationTexte = var1;
   }
}
