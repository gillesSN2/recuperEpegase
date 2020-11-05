package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ElevesAppels implements Serializable {
   private long eleappId;
   private Date eleappDateCreat;
   private Date eleappDateModif;
   private long eleappIdCreateur;
   private long eleappIdModif;
   private String eleappAnnee;
   private Date eleappDate;
   private String eleappNum;
   private String eleappMatiere;
   private String eleappFiliere;
   private int eleappType;
   private int eleappEtat;
   private Date eleappDateValide;
   private int eleappEtatVal;
   private String eleappNomProfesseur;
   private long eleappIdProfesseur;
   private String eleappObservation;
   private String eleappScan;
   private Date eleappDateAnnule;
   private String eleappMotifAnnule;
   private Eleves eleves;
   private ExercicesVentes exercicesVentes;
   private FilieresEducation filieresEducation;
   private FilieresMatieres filieresMatieres;
   private String libelleType;
   private String libelleEtat;
   private String scanner;

   public String getScanner() {
      if (this.eleappScan != null && !this.eleappScan.isEmpty()) {
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
      if (this.eleappEtat == 0) {
         this.libelleEtat = "E.C.";
      } else if (this.eleappEtat == 1) {
         this.libelleEtat = "Val.";
      } else if (this.eleappEtat == 2) {
         this.libelleEtat = "Annulé";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public String getLibelleType() {
      if (this.eleappType == 0) {
         this.libelleType = "Présent(e)";
      } else if (this.eleappType == 1) {
         this.libelleType = "Ne fait pas parti(e) du groupe";
      } else if (this.eleappType == 2) {
         this.libelleType = "Retard justifié";
      } else if (this.eleappType == 3) {
         this.libelleType = "Retard non justifié";
      } else if (this.eleappType == 4) {
         this.libelleType = "Absence justifiée";
      } else if (this.eleappType == 5) {
         this.libelleType = "Absence non justifiée";
      } else if (this.eleappType == 6) {
         this.libelleType = "Absence pour exclusion";
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

   public String getEleappAnnee() {
      return this.eleappAnnee;
   }

   public void setEleappAnnee(String var1) {
      this.eleappAnnee = var1;
   }

   public Date getEleappDate() {
      return this.eleappDate;
   }

   public void setEleappDate(Date var1) {
      this.eleappDate = var1;
   }

   public Date getEleappDateCreat() {
      return this.eleappDateCreat;
   }

   public void setEleappDateCreat(Date var1) {
      this.eleappDateCreat = var1;
   }

   public Date getEleappDateModif() {
      return this.eleappDateModif;
   }

   public void setEleappDateModif(Date var1) {
      this.eleappDateModif = var1;
   }

   public Date getEleappDateValide() {
      return this.eleappDateValide;
   }

   public void setEleappDateValide(Date var1) {
      this.eleappDateValide = var1;
   }

   public int getEleappEtat() {
      return this.eleappEtat;
   }

   public void setEleappEtat(int var1) {
      this.eleappEtat = var1;
   }

   public String getEleappFiliere() {
      return this.eleappFiliere;
   }

   public void setEleappFiliere(String var1) {
      this.eleappFiliere = var1;
   }

   public long getEleappId() {
      return this.eleappId;
   }

   public void setEleappId(long var1) {
      this.eleappId = var1;
   }

   public long getEleappIdCreateur() {
      return this.eleappIdCreateur;
   }

   public void setEleappIdCreateur(long var1) {
      this.eleappIdCreateur = var1;
   }

   public long getEleappIdModif() {
      return this.eleappIdModif;
   }

   public void setEleappIdModif(long var1) {
      this.eleappIdModif = var1;
   }

   public long getEleappIdProfesseur() {
      return this.eleappIdProfesseur;
   }

   public void setEleappIdProfesseur(long var1) {
      this.eleappIdProfesseur = var1;
   }

   public String getEleappMatiere() {
      return this.eleappMatiere;
   }

   public void setEleappMatiere(String var1) {
      this.eleappMatiere = var1;
   }

   public String getEleappNomProfesseur() {
      return this.eleappNomProfesseur;
   }

   public void setEleappNomProfesseur(String var1) {
      this.eleappNomProfesseur = var1;
   }

   public String getEleappNum() {
      return this.eleappNum;
   }

   public void setEleappNum(String var1) {
      this.eleappNum = var1;
   }

   public String getEleappObservation() {
      return this.eleappObservation;
   }

   public void setEleappObservation(String var1) {
      this.eleappObservation = var1;
   }

   public int getEleappType() {
      return this.eleappType;
   }

   public void setEleappType(int var1) {
      this.eleappType = var1;
   }

   public String getEleappScan() {
      return this.eleappScan;
   }

   public void setEleappScan(String var1) {
      this.eleappScan = var1;
   }

   public Date getEleappDateAnnule() {
      return this.eleappDateAnnule;
   }

   public void setEleappDateAnnule(Date var1) {
      this.eleappDateAnnule = var1;
   }

   public String getEleappMotifAnnule() {
      return this.eleappMotifAnnule;
   }

   public void setEleappMotifAnnule(String var1) {
      this.eleappMotifAnnule = var1;
   }

   public int getEleappEtatVal() {
      return this.eleappEtatVal;
   }

   public void setEleappEtatVal(int var1) {
      this.eleappEtatVal = var1;
   }
}
