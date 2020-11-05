package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ElevesNote implements Serializable {
   private long elenotId;
   private Date elenotDateCreat;
   private Date elenotDateModif;
   private long elenotIdCreateur;
   private long elenotIdModif;
   private String elenotAnnee;
   private Date elenotDate;
   private String elenotNum;
   private String elenotMatiere;
   private String elenotFiliere;
   private int elenotType;
   private int elenotEtatVal;
   private int elenotEtat;
   private Date elenotDateValide;
   private String elenotNomProfesseur;
   private long elenotIdProfesseur;
   private int elenotMode;
   private double elenotValMax;
   private double elenotCoef;
   private double elenotValNote;
   private double elenotPoidsNote;
   private String elenotValAppreciation;
   private double elenotValUv;
   private double elenotPoidsUv;
   private String elenotObservation;
   private String elenotScan;
   private Date elenotDateAnnule;
   private String elenotMotifAnnule;
   private int elenotExcluMoy;
   private Eleves eleves;
   private ExercicesVentes exercicesVentes;
   private FilieresEducation filieresEducation;
   private FilieresMatieres filieresMatieres;
   private String libelleType;
   private String libelleEtat;
   private String libelleMode;
   private String scanner;

   public String getScanner() {
      if (this.elenotScan != null && !this.elenotScan.isEmpty()) {
         this.scanner = "/images/mail_pj.png";
      } else {
         this.scanner = null;
      }

      return this.scanner;
   }

   public void setScanner(String var1) {
      this.scanner = var1;
   }

   public String getLibelleMode() {
      if (this.elenotMode == 0) {
         this.libelleMode = "Appréciation";
      } else if (this.elenotMode == 1) {
         this.libelleMode = "Moyenne";
      } else if (this.elenotMode == 2) {
         this.libelleMode = "U.V.";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public String getLibelleEtat() {
      if (this.elenotEtat == 0) {
         this.libelleEtat = "E.C.";
      } else if (this.elenotEtat == 1) {
         this.libelleEtat = "Val.";
      } else if (this.elenotEtat == 2) {
         this.libelleEtat = "Annulé";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public String getLibelleType() {
      if (this.elenotType == 0) {
         this.libelleType = "N.S.";
      } else if (this.elenotType == 1) {
         this.libelleType = "Contrôle";
      } else if (this.elenotType == 2) {
         this.libelleType = "Devoir";
      } else if (this.elenotType == 3) {
         this.libelleType = "T.P.";
      } else if (this.elenotType == 4) {
         this.libelleType = "Leçon";
      } else if (this.elenotType == 5) {
         this.libelleType = "Autre";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
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

   public String getElenotAnnee() {
      return this.elenotAnnee;
   }

   public void setElenotAnnee(String var1) {
      this.elenotAnnee = var1;
   }

   public Date getElenotDate() {
      return this.elenotDate;
   }

   public void setElenotDate(Date var1) {
      this.elenotDate = var1;
   }

   public Date getElenotDateCreat() {
      return this.elenotDateCreat;
   }

   public void setElenotDateCreat(Date var1) {
      this.elenotDateCreat = var1;
   }

   public Date getElenotDateModif() {
      return this.elenotDateModif;
   }

   public void setElenotDateModif(Date var1) {
      this.elenotDateModif = var1;
   }

   public Date getElenotDateValide() {
      return this.elenotDateValide;
   }

   public void setElenotDateValide(Date var1) {
      this.elenotDateValide = var1;
   }

   public int getElenotEtat() {
      return this.elenotEtat;
   }

   public void setElenotEtat(int var1) {
      this.elenotEtat = var1;
   }

   public String getElenotFiliere() {
      return this.elenotFiliere;
   }

   public void setElenotFiliere(String var1) {
      this.elenotFiliere = var1;
   }

   public long getElenotId() {
      return this.elenotId;
   }

   public void setElenotId(long var1) {
      this.elenotId = var1;
   }

   public long getElenotIdCreateur() {
      return this.elenotIdCreateur;
   }

   public void setElenotIdCreateur(long var1) {
      this.elenotIdCreateur = var1;
   }

   public long getElenotIdModif() {
      return this.elenotIdModif;
   }

   public void setElenotIdModif(long var1) {
      this.elenotIdModif = var1;
   }

   public long getElenotIdProfesseur() {
      return this.elenotIdProfesseur;
   }

   public void setElenotIdProfesseur(long var1) {
      this.elenotIdProfesseur = var1;
   }

   public String getElenotMatiere() {
      return this.elenotMatiere;
   }

   public void setElenotMatiere(String var1) {
      this.elenotMatiere = var1;
   }

   public int getElenotMode() {
      return this.elenotMode;
   }

   public void setElenotMode(int var1) {
      this.elenotMode = var1;
   }

   public String getElenotNomProfesseur() {
      return this.elenotNomProfesseur;
   }

   public void setElenotNomProfesseur(String var1) {
      this.elenotNomProfesseur = var1;
   }

   public String getElenotNum() {
      return this.elenotNum;
   }

   public void setElenotNum(String var1) {
      this.elenotNum = var1;
   }

   public int getElenotType() {
      return this.elenotType;
   }

   public void setElenotType(int var1) {
      this.elenotType = var1;
   }

   public double getElenotValNote() {
      return this.elenotValNote;
   }

   public void setElenotValNote(double var1) {
      this.elenotValNote = var1;
   }

   public String getElenotObservation() {
      return this.elenotObservation;
   }

   public void setElenotObservation(String var1) {
      this.elenotObservation = var1;
   }

   public String getElenotValAppreciation() {
      return this.elenotValAppreciation;
   }

   public void setElenotValAppreciation(String var1) {
      this.elenotValAppreciation = var1;
   }

   public double getElenotValMax() {
      return this.elenotValMax;
   }

   public void setElenotValMax(double var1) {
      this.elenotValMax = var1;
   }

   public double getElenotValUv() {
      return this.elenotValUv;
   }

   public void setElenotValUv(double var1) {
      this.elenotValUv = var1;
   }

   public double getElenotCoef() {
      return this.elenotCoef;
   }

   public void setElenotCoef(double var1) {
      this.elenotCoef = var1;
   }

   public double getElenotPoidsNote() {
      return this.elenotPoidsNote;
   }

   public void setElenotPoidsNote(double var1) {
      this.elenotPoidsNote = var1;
   }

   public double getElenotPoidsUv() {
      return this.elenotPoidsUv;
   }

   public void setElenotPoidsUv(double var1) {
      this.elenotPoidsUv = var1;
   }

   public Date getElenotDateAnnule() {
      return this.elenotDateAnnule;
   }

   public void setElenotDateAnnule(Date var1) {
      this.elenotDateAnnule = var1;
   }

   public int getElenotEtatVal() {
      return this.elenotEtatVal;
   }

   public void setElenotEtatVal(int var1) {
      this.elenotEtatVal = var1;
   }

   public String getElenotMotifAnnule() {
      return this.elenotMotifAnnule;
   }

   public void setElenotMotifAnnule(String var1) {
      this.elenotMotifAnnule = var1;
   }

   public String getElenotScan() {
      return this.elenotScan;
   }

   public void setElenotScan(String var1) {
      this.elenotScan = var1;
   }

   public int getElenotExcluMoy() {
      return this.elenotExcluMoy;
   }

   public void setElenotExcluMoy(int var1) {
      this.elenotExcluMoy = var1;
   }
}
