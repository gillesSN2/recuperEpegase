package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BienBudgetEntete implements Serializable {
   private long biebudentId;
   private Date biebudentDateCreat;
   private Date biebudentDateModif;
   private long biebudentUserCreat;
   private long biebudentUserModif;
   private String biebudentNum;
   private int biebudentAnnee;
   private String biebudentObjet;
   private int biebudentMode;
   private Date biebudentDateDebut;
   private Date biebudentDateFin;
   private double biebudentResteAnterieur;
   private double biebudentTotal;
   private int biebudentEtat;
   private Date biebudentDateApprobation;
   private double biebudentDepenses;
   private double biebudentDepensesNonImpute;
   private double biebudentEcart;
   private float biebudentRealisation;
   private Date biebudentDateImp;
   private String biebudentModeleImp;
   private double biebudentHonoraire;
   private long biebudentIdCoproprietaire;
   private String biebudentNomCoproprietaire;
   private Bien bien;
   private String libelleEtat;
   private String libelleMode;

   public Bien getBien() {
      return this.bien;
   }

   public void setBien(Bien var1) {
      this.bien = var1;
   }

   public String getLibelleMode() {
      if (this.biebudentMode == 0) {
         this.libelleMode = "Normal";
      } else if (this.biebudentMode == 1) {
         this.libelleMode = "Exceptionnel";
      } else if (this.biebudentMode == 2) {
         this.libelleMode = "Fond roulement";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public String getLibelleEtat() {
      if (this.biebudentEtat == 0) {
         this.libelleEtat = "En cours";
      } else if (this.biebudentEtat == 1) {
         this.libelleEtat = "Validé";
      } else if (this.biebudentEtat == 2) {
         this.libelleEtat = "Gelé";
      } else if (this.biebudentEtat == 3) {
         this.libelleEtat = "Annulé";
      } else if (this.biebudentEtat == 4) {
         this.libelleEtat = "Terminé";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public int getBiebudentAnnee() {
      return this.biebudentAnnee;
   }

   public void setBiebudentAnnee(int var1) {
      this.biebudentAnnee = var1;
   }

   public Date getBiebudentDateApprobation() {
      return this.biebudentDateApprobation;
   }

   public void setBiebudentDateApprobation(Date var1) {
      this.biebudentDateApprobation = var1;
   }

   public Date getBiebudentDateCreat() {
      return this.biebudentDateCreat;
   }

   public void setBiebudentDateCreat(Date var1) {
      this.biebudentDateCreat = var1;
   }

   public Date getBiebudentDateDebut() {
      return this.biebudentDateDebut;
   }

   public void setBiebudentDateDebut(Date var1) {
      this.biebudentDateDebut = var1;
   }

   public Date getBiebudentDateFin() {
      return this.biebudentDateFin;
   }

   public void setBiebudentDateFin(Date var1) {
      this.biebudentDateFin = var1;
   }

   public Date getBiebudentDateModif() {
      return this.biebudentDateModif;
   }

   public void setBiebudentDateModif(Date var1) {
      this.biebudentDateModif = var1;
   }

   public double getBiebudentDepenses() {
      return this.biebudentDepenses;
   }

   public void setBiebudentDepenses(double var1) {
      this.biebudentDepenses = var1;
   }

   public double getBiebudentEcart() {
      return this.biebudentEcart;
   }

   public void setBiebudentEcart(double var1) {
      this.biebudentEcart = var1;
   }

   public int getBiebudentEtat() {
      return this.biebudentEtat;
   }

   public void setBiebudentEtat(int var1) {
      this.biebudentEtat = var1;
   }

   public float getBiebudentRealisation() {
      return this.biebudentRealisation;
   }

   public void setBiebudentRealisation(float var1) {
      this.biebudentRealisation = var1;
   }

   public double getBiebudentTotal() {
      return this.biebudentTotal;
   }

   public void setBiebudentTotal(double var1) {
      this.biebudentTotal = var1;
   }

   public long getBiebudentUserCreat() {
      return this.biebudentUserCreat;
   }

   public void setBiebudentUserCreat(long var1) {
      this.biebudentUserCreat = var1;
   }

   public long getBiebudentUserModif() {
      return this.biebudentUserModif;
   }

   public void setBiebudentUserModif(long var1) {
      this.biebudentUserModif = var1;
   }

   public long getBiebudentId() {
      return this.biebudentId;
   }

   public void setBiebudentId(long var1) {
      this.biebudentId = var1;
   }

   public String getBiebudentNum() {
      return this.biebudentNum;
   }

   public void setBiebudentNum(String var1) {
      this.biebudentNum = var1;
   }

   public Date getBiebudentDateImp() {
      return this.biebudentDateImp;
   }

   public void setBiebudentDateImp(Date var1) {
      this.biebudentDateImp = var1;
   }

   public String getBiebudentModeleImp() {
      return this.biebudentModeleImp;
   }

   public void setBiebudentModeleImp(String var1) {
      this.biebudentModeleImp = var1;
   }

   public double getBiebudentResteAnterieur() {
      return this.biebudentResteAnterieur;
   }

   public void setBiebudentResteAnterieur(double var1) {
      this.biebudentResteAnterieur = var1;
   }

   public double getBiebudentDepensesNonImpute() {
      return this.biebudentDepensesNonImpute;
   }

   public void setBiebudentDepensesNonImpute(double var1) {
      this.biebudentDepensesNonImpute = var1;
   }

   public int getBiebudentMode() {
      return this.biebudentMode;
   }

   public void setBiebudentMode(int var1) {
      this.biebudentMode = var1;
   }

   public String getBiebudentObjet() {
      return this.biebudentObjet;
   }

   public void setBiebudentObjet(String var1) {
      this.biebudentObjet = var1;
   }

   public long getBiebudentIdCoproprietaire() {
      return this.biebudentIdCoproprietaire;
   }

   public void setBiebudentIdCoproprietaire(long var1) {
      this.biebudentIdCoproprietaire = var1;
   }

   public String getBiebudentNomCoproprietaire() {
      return this.biebudentNomCoproprietaire;
   }

   public void setBiebudentNomCoproprietaire(String var1) {
      this.biebudentNomCoproprietaire = var1;
   }

   public double getBiebudentHonoraire() {
      return this.biebudentHonoraire;
   }

   public void setBiebudentHonoraire(double var1) {
      this.biebudentHonoraire = var1;
   }
}
