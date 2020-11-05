package com.epegase.systeme.control;

import java.io.Serializable;

public class DocumentEducation implements Serializable {
   private String docAnnee;
   private String docPeriode;
   private String docDossier;
   private String docNomEleve;
   private String docPrenomEleve;
   private String docCiviliteEleve;
   private String docCodeFiliere;
   private String docLibFiliere;
   private String docCodeMatiere;
   private String docLibMatiere;
   private String docNomProfesseur;
   private double docPoidsNote;
   private float docCoefNote;
   private int docTypeNote;
   private int docModeNote;
   private double docValNote;
   private int docNbNote;
   private double docMoyNote;
   private long docId;
   private double docNbAbsNJ;
   private double docNbAbsJ;
   private double docNbAbsEX;
   private double docNbRetNJ;
   private double docNbRetJ;
   private double docNbViolSub;
   private double docNbViolCau;
   private double docMoyClasse;
   private double docNbAbsNJClasse;
   private double docNbAbsJClasse;
   private double docNbAbsEXClasse;
   private double docNbRetNJClasse;
   private double docNbRetJClasse;
   private double docNbViolSubClasse;
   private double docNbViolCauClasse;
   private String var_lib_type;
   private String var_lib_mode;

   public String getVar_lib_mode() {
      if (this.docModeNote == 0) {
         this.var_lib_mode = "Appréciation";
      } else if (this.docModeNote == 1) {
         this.var_lib_mode = "Moyenne";
      } else if (this.docModeNote == 2) {
         this.var_lib_mode = "U.V.";
      }

      return this.var_lib_mode;
   }

   public void setVar_lib_mode(String var1) {
      this.var_lib_mode = var1;
   }

   public String getVar_lib_type() {
      if (this.docTypeNote == 0) {
         this.var_lib_mode = "N.S";
      } else if (this.docTypeNote == 1) {
         this.var_lib_mode = "Controle";
      } else if (this.docTypeNote == 2) {
         this.var_lib_mode = "Devoir";
      } else if (this.docTypeNote == 2) {
         this.var_lib_mode = "T.P.";
      } else if (this.docTypeNote == 2) {
         this.var_lib_mode = "Leçon";
      } else if (this.docTypeNote == 2) {
         this.var_lib_mode = "Autre";
      }

      return this.var_lib_type;
   }

   public void setVar_lib_type(String var1) {
      this.var_lib_type = var1;
   }

   public String getDocCodeFiliere() {
      return this.docCodeFiliere;
   }

   public void setDocCodeFiliere(String var1) {
      this.docCodeFiliere = var1;
   }

   public String getDocCodeMatiere() {
      return this.docCodeMatiere;
   }

   public void setDocCodeMatiere(String var1) {
      this.docCodeMatiere = var1;
   }

   public float getDocCoefNote() {
      return this.docCoefNote;
   }

   public void setDocCoefNote(float var1) {
      this.docCoefNote = var1;
   }

   public long getDocId() {
      return this.docId;
   }

   public void setDocId(long var1) {
      this.docId = var1;
   }

   public String getDocLibFiliere() {
      return this.docLibFiliere;
   }

   public void setDocLibFiliere(String var1) {
      this.docLibFiliere = var1;
   }

   public String getDocLibMatiere() {
      return this.docLibMatiere;
   }

   public void setDocLibMatiere(String var1) {
      this.docLibMatiere = var1;
   }

   public int getDocModeNote() {
      return this.docModeNote;
   }

   public void setDocModeNote(int var1) {
      this.docModeNote = var1;
   }

   public double getDocPoidsNote() {
      return this.docPoidsNote;
   }

   public void setDocPoidsNote(double var1) {
      this.docPoidsNote = var1;
   }

   public int getDocTypeNote() {
      return this.docTypeNote;
   }

   public void setDocTypeNote(int var1) {
      this.docTypeNote = var1;
   }

   public double getDocValNote() {
      return this.docValNote;
   }

   public void setDocValNote(double var1) {
      this.docValNote = var1;
   }

   public String getDocNomProfesseur() {
      return this.docNomProfesseur;
   }

   public void setDocNomProfesseur(String var1) {
      this.docNomProfesseur = var1;
   }

   public double getDocMoyNote() {
      return this.docMoyNote;
   }

   public void setDocMoyNote(double var1) {
      this.docMoyNote = var1;
   }

   public int getDocNbNote() {
      return this.docNbNote;
   }

   public void setDocNbNote(int var1) {
      this.docNbNote = var1;
   }

   public double getDocMoyClasse() {
      return this.docMoyClasse;
   }

   public void setDocMoyClasse(double var1) {
      this.docMoyClasse = var1;
   }

   public double getDocNbAbsEX() {
      return this.docNbAbsEX;
   }

   public void setDocNbAbsEX(double var1) {
      this.docNbAbsEX = var1;
   }

   public double getDocNbAbsJ() {
      return this.docNbAbsJ;
   }

   public void setDocNbAbsJ(double var1) {
      this.docNbAbsJ = var1;
   }

   public double getDocNbAbsNJ() {
      return this.docNbAbsNJ;
   }

   public void setDocNbAbsNJ(double var1) {
      this.docNbAbsNJ = var1;
   }

   public double getDocNbRetJ() {
      return this.docNbRetJ;
   }

   public void setDocNbRetJ(double var1) {
      this.docNbRetJ = var1;
   }

   public double getDocNbRetNJ() {
      return this.docNbRetNJ;
   }

   public void setDocNbRetNJ(double var1) {
      this.docNbRetNJ = var1;
   }

   public double getDocNbViolCau() {
      return this.docNbViolCau;
   }

   public void setDocNbViolCau(double var1) {
      this.docNbViolCau = var1;
   }

   public double getDocNbViolSub() {
      return this.docNbViolSub;
   }

   public void setDocNbViolSub(double var1) {
      this.docNbViolSub = var1;
   }

   public double getDocNbAbsEXClasse() {
      return this.docNbAbsEXClasse;
   }

   public void setDocNbAbsEXClasse(double var1) {
      this.docNbAbsEXClasse = var1;
   }

   public double getDocNbAbsJClasse() {
      return this.docNbAbsJClasse;
   }

   public void setDocNbAbsJClasse(double var1) {
      this.docNbAbsJClasse = var1;
   }

   public double getDocNbAbsNJClasse() {
      return this.docNbAbsNJClasse;
   }

   public void setDocNbAbsNJClasse(double var1) {
      this.docNbAbsNJClasse = var1;
   }

   public double getDocNbRetJClasse() {
      return this.docNbRetJClasse;
   }

   public void setDocNbRetJClasse(double var1) {
      this.docNbRetJClasse = var1;
   }

   public double getDocNbRetNJClasse() {
      return this.docNbRetNJClasse;
   }

   public void setDocNbRetNJClasse(double var1) {
      this.docNbRetNJClasse = var1;
   }

   public double getDocNbViolCauClasse() {
      return this.docNbViolCauClasse;
   }

   public void setDocNbViolCauClasse(double var1) {
      this.docNbViolCauClasse = var1;
   }

   public double getDocNbViolSubClasse() {
      return this.docNbViolSubClasse;
   }

   public void setDocNbViolSubClasse(double var1) {
      this.docNbViolSubClasse = var1;
   }

   public String getDocCiviliteEleve() {
      return this.docCiviliteEleve;
   }

   public void setDocCiviliteEleve(String var1) {
      this.docCiviliteEleve = var1;
   }

   public String getDocDossier() {
      return this.docDossier;
   }

   public void setDocDossier(String var1) {
      this.docDossier = var1;
   }

   public String getDocNomEleve() {
      return this.docNomEleve;
   }

   public void setDocNomEleve(String var1) {
      this.docNomEleve = var1;
   }

   public String getDocPrenomEleve() {
      return this.docPrenomEleve;
   }

   public void setDocPrenomEleve(String var1) {
      this.docPrenomEleve = var1;
   }

   public String getDocAnnee() {
      return this.docAnnee;
   }

   public void setDocAnnee(String var1) {
      this.docAnnee = var1;
   }

   public String getDocPeriode() {
      return this.docPeriode;
   }

   public void setDocPeriode(String var1) {
      this.docPeriode = var1;
   }
}
