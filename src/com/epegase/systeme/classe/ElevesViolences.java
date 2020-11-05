package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ElevesViolences implements Serializable {
   private long elevioId;
   private Date elevioDateCreat;
   private Date elevioDateModif;
   private long elevioIdCreateur;
   private long elevioIdModif;
   private String elevioAnnee;
   private Date elevioDate;
   private String elevioNum;
   private String elevioMatiere;
   private String elevioFiliere;
   private int elevioTypeSubi;
   private int elevioTypeCause;
   private int elevioEtat;
   private Date elevioDateValide;
   private int elevioEtatVal;
   private String elevioNomProfesseur;
   private long elevioIdProfesseur;
   private String elevioObservation;
   private String elevioScan;
   private Date elevioDateAnnule;
   private String elevioMotifAnnule;
   private Eleves eleves;
   private ExercicesVentes exercicesVentes;
   private FilieresEducation filieresEducation;
   private FilieresMatieres filieresMatieres;
   private String libelleTypeSubi;
   private String libelleTypeCause;
   private String libelleEtat;
   private String scanner;

   public String getScanner() {
      if (this.elevioScan != null && !this.elevioScan.isEmpty()) {
         this.scanner = "/images/mail_pj.png";
      } else {
         this.scanner = null;
      }

      return this.scanner;
   }

   public void setScanner(String var1) {
      this.scanner = var1;
   }

   public String getLibelleEtat() {
      if (this.elevioEtat == 0) {
         this.libelleEtat = "E.C.";
      } else if (this.elevioEtat == 1) {
         this.libelleEtat = "Val.";
      } else if (this.elevioEtat == 2) {
         this.libelleEtat = "Annulé";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public String getLibelleTypeCause() {
      if (this.elevioTypeCause == 0) {
         this.libelleTypeCause = "Présent(e)";
      } else if (this.elevioTypeCause == 1) {
         this.libelleTypeCause = "Ne fait pas parti(e) du groupe";
      } else if (this.elevioTypeCause == 2) {
         this.libelleTypeCause = "Retard justifié";
      } else if (this.elevioTypeCause == 3) {
         this.libelleTypeCause = "Retard non justifié";
      } else if (this.elevioTypeCause == 4) {
         this.libelleTypeCause = "Absence justifiée";
      } else if (this.elevioTypeCause == 5) {
         this.libelleTypeCause = "Absence non justifiée";
      } else if (this.elevioTypeCause == 6) {
         this.libelleTypeCause = "Absence pour exclusion";
      }

      return this.libelleTypeCause;
   }

   public void setLibelleTypeCause(String var1) {
      this.libelleTypeCause = var1;
   }

   public String getLibelleTypeSubi() {
      if (this.elevioTypeSubi == 0) {
         this.libelleTypeSubi = "Présent(e)";
      } else if (this.elevioTypeSubi == 1) {
         this.libelleTypeSubi = "Ne fait pas parti(e) du groupe";
      } else if (this.elevioTypeSubi == 2) {
         this.libelleTypeSubi = "Retard justifié";
      } else if (this.elevioTypeSubi == 3) {
         this.libelleTypeSubi = "Retard non justifié";
      } else if (this.elevioTypeSubi == 4) {
         this.libelleTypeSubi = "Absence justifiée";
      } else if (this.elevioTypeSubi == 5) {
         this.libelleTypeSubi = "Absence non justifiée";
      } else if (this.elevioTypeSubi == 6) {
         this.libelleTypeSubi = "Absence pour exclusion";
      }

      return this.libelleTypeSubi;
   }

   public void setLibelleTypeSubi(String var1) {
      this.libelleTypeSubi = var1;
   }

   public Eleves getEleves() {
      return this.eleves;
   }

   public void setEleves(Eleves var1) {
      this.eleves = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public FilieresEducation getFilieresEducation() {
      return this.filieresEducation;
   }

   public void setFilieresEducation(FilieresEducation var1) {
      this.filieresEducation = var1;
   }

   public FilieresMatieres getFilieresMatieres() {
      return this.filieresMatieres;
   }

   public void setFilieresMatieres(FilieresMatieres var1) {
      this.filieresMatieres = var1;
   }

   public String getElevioAnnee() {
      return this.elevioAnnee;
   }

   public void setElevioAnnee(String var1) {
      this.elevioAnnee = var1;
   }

   public Date getElevioDate() {
      return this.elevioDate;
   }

   public void setElevioDate(Date var1) {
      this.elevioDate = var1;
   }

   public Date getElevioDateAnnule() {
      return this.elevioDateAnnule;
   }

   public void setElevioDateAnnule(Date var1) {
      this.elevioDateAnnule = var1;
   }

   public Date getElevioDateCreat() {
      return this.elevioDateCreat;
   }

   public void setElevioDateCreat(Date var1) {
      this.elevioDateCreat = var1;
   }

   public Date getElevioDateModif() {
      return this.elevioDateModif;
   }

   public void setElevioDateModif(Date var1) {
      this.elevioDateModif = var1;
   }

   public Date getElevioDateValide() {
      return this.elevioDateValide;
   }

   public void setElevioDateValide(Date var1) {
      this.elevioDateValide = var1;
   }

   public int getElevioEtat() {
      return this.elevioEtat;
   }

   public void setElevioEtat(int var1) {
      this.elevioEtat = var1;
   }

   public int getElevioEtatVal() {
      return this.elevioEtatVal;
   }

   public void setElevioEtatVal(int var1) {
      this.elevioEtatVal = var1;
   }

   public String getElevioFiliere() {
      return this.elevioFiliere;
   }

   public void setElevioFiliere(String var1) {
      this.elevioFiliere = var1;
   }

   public long getElevioId() {
      return this.elevioId;
   }

   public void setElevioId(long var1) {
      this.elevioId = var1;
   }

   public long getElevioIdCreateur() {
      return this.elevioIdCreateur;
   }

   public void setElevioIdCreateur(long var1) {
      this.elevioIdCreateur = var1;
   }

   public long getElevioIdModif() {
      return this.elevioIdModif;
   }

   public void setElevioIdModif(long var1) {
      this.elevioIdModif = var1;
   }

   public long getElevioIdProfesseur() {
      return this.elevioIdProfesseur;
   }

   public void setElevioIdProfesseur(long var1) {
      this.elevioIdProfesseur = var1;
   }

   public String getElevioMatiere() {
      return this.elevioMatiere;
   }

   public void setElevioMatiere(String var1) {
      this.elevioMatiere = var1;
   }

   public String getElevioMotifAnnule() {
      return this.elevioMotifAnnule;
   }

   public void setElevioMotifAnnule(String var1) {
      this.elevioMotifAnnule = var1;
   }

   public String getElevioNomProfesseur() {
      return this.elevioNomProfesseur;
   }

   public void setElevioNomProfesseur(String var1) {
      this.elevioNomProfesseur = var1;
   }

   public String getElevioNum() {
      return this.elevioNum;
   }

   public void setElevioNum(String var1) {
      this.elevioNum = var1;
   }

   public String getElevioObservation() {
      return this.elevioObservation;
   }

   public void setElevioObservation(String var1) {
      this.elevioObservation = var1;
   }

   public String getElevioScan() {
      return this.elevioScan;
   }

   public void setElevioScan(String var1) {
      this.elevioScan = var1;
   }

   public int getElevioTypeCause() {
      return this.elevioTypeCause;
   }

   public void setElevioTypeCause(int var1) {
      this.elevioTypeCause = var1;
   }

   public int getElevioTypeSubi() {
      return this.elevioTypeSubi;
   }

   public void setElevioTypeSubi(int var1) {
      this.elevioTypeSubi = var1;
   }
}
