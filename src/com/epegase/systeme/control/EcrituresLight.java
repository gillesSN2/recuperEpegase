package com.epegase.systeme.control;

import java.io.Serializable;
import java.util.Date;

public class EcrituresLight implements Serializable {
   private long ecr_id;
   private String ecrCode;
   private Date ecrDateSaisie;
   private String ecrPeriode;
   private String ecrAnnee;
   private String ecrCompte;
   private String ecrLibCompte;
   private int ecrNature;
   private int ecrNatureJrx;
   private String ecrDeviseSaisie;
   private String ecrDeviseGrp;
   private String ecrDevisePays;
   private double ecrDebitSaisie;
   private double ecrCreditSaisie;
   private String ecrLettrage;
   private String ecrPointage;
   private String ecrRapprochement;
   private int ecrCloture;
   private Date ecrDateEcheance;
   private Date ecrDateValeurTheo;
   private String ecrLibelle;
   private String ecrPiece;
   private String ecrReference1;
   private String ecrReference2;
   private String ecrTreso;
   private boolean select = false;
   private boolean nbrEcrLettrage = false;
   private int ecrEtat;
   private String lib_etat;

   public int getEcrCloture() {
      return this.ecrCloture;
   }

   public void setEcrCloture(int var1) {
      this.ecrCloture = var1;
   }

   public String getEcrCode() {
      return this.ecrCode;
   }

   public void setEcrCode(String var1) {
      this.ecrCode = var1;
   }

   public String getEcrCompte() {
      return this.ecrCompte;
   }

   public void setEcrCompte(String var1) {
      this.ecrCompte = var1;
   }

   public double getEcrCreditSaisie() {
      return this.ecrCreditSaisie;
   }

   public void setEcrCreditSaisie(double var1) {
      this.ecrCreditSaisie = var1;
   }

   public Date getEcrDateEcheance() {
      return this.ecrDateEcheance;
   }

   public void setEcrDateEcheance(Date var1) {
      this.ecrDateEcheance = var1;
   }

   public Date getEcrDateSaisie() {
      return this.ecrDateSaisie;
   }

   public void setEcrDateSaisie(Date var1) {
      this.ecrDateSaisie = var1;
   }

   public Date getEcrDateValeurTheo() {
      return this.ecrDateValeurTheo;
   }

   public void setEcrDateValeurTheo(Date var1) {
      this.ecrDateValeurTheo = var1;
   }

   public double getEcrDebitSaisie() {
      return this.ecrDebitSaisie;
   }

   public void setEcrDebitSaisie(double var1) {
      this.ecrDebitSaisie = var1;
   }

   public String getEcrDeviseSaisie() {
      return this.ecrDeviseSaisie;
   }

   public void setEcrDeviseSaisie(String var1) {
      this.ecrDeviseSaisie = var1;
   }

   public String getEcrLettrage() {
      return this.ecrLettrage;
   }

   public void setEcrLettrage(String var1) {
      this.ecrLettrage = var1;
   }

   public String getEcrLibCompte() {
      return this.ecrLibCompte;
   }

   public void setEcrLibCompte(String var1) {
      this.ecrLibCompte = var1;
   }

   public String getEcrLibelle() {
      return this.ecrLibelle;
   }

   public void setEcrLibelle(String var1) {
      this.ecrLibelle = var1;
   }

   public int getEcrNature() {
      return this.ecrNature;
   }

   public void setEcrNature(int var1) {
      this.ecrNature = var1;
   }

   public String getEcrPeriode() {
      return this.ecrPeriode;
   }

   public void setEcrPeriode(String var1) {
      this.ecrPeriode = var1;
   }

   public String getEcrPiece() {
      return this.ecrPiece;
   }

   public void setEcrPiece(String var1) {
      this.ecrPiece = var1;
   }

   public String getEcrPointage() {
      return this.ecrPointage;
   }

   public void setEcrPointage(String var1) {
      this.ecrPointage = var1;
   }

   public String getEcrRapprochement() {
      return this.ecrRapprochement;
   }

   public void setEcrRapprochement(String var1) {
      this.ecrRapprochement = var1;
   }

   public String getEcrReference1() {
      return this.ecrReference1;
   }

   public void setEcrReference1(String var1) {
      this.ecrReference1 = var1;
   }

   public String getEcrReference2() {
      return this.ecrReference2;
   }

   public void setEcrReference2(String var1) {
      this.ecrReference2 = var1;
   }

   public String getEcrTreso() {
      return this.ecrTreso;
   }

   public void setEcrTreso(String var1) {
      this.ecrTreso = var1;
   }

   public boolean isNbrEcrLettrage() {
      this.nbrEcrLettrage = false;
      if (this.getEcrLettrage() != null && !this.getEcrLettrage().isEmpty()) {
         this.nbrEcrLettrage = true;
      }

      return this.nbrEcrLettrage;
   }

   public void setNbrEcrLettrage(boolean var1) {
      this.nbrEcrLettrage = var1;
   }

   public long getEcr_id() {
      return this.ecr_id;
   }

   public void setEcr_id(long var1) {
      this.ecr_id = var1;
   }

   public String getLib_etat() {
      if (this.ecrEtat == 0) {
         this.lib_etat = "E.C.";
      } else if (this.ecrEtat == 1) {
         this.lib_etat = "Val.";
      }

      return this.lib_etat;
   }

   public void setLib_etat(String var1) {
      this.lib_etat = var1;
   }

   public int getEcrEtat() {
      return this.ecrEtat;
   }

   public void setEcrEtat(int var1) {
      this.ecrEtat = var1;
   }

   public String getEcrAnnee() {
      return this.ecrAnnee;
   }

   public void setEcrAnnee(String var1) {
      this.ecrAnnee = var1;
   }

   public int getEcrNatureJrx() {
      return this.ecrNatureJrx;
   }

   public void setEcrNatureJrx(int var1) {
      this.ecrNatureJrx = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public String getEcrDeviseGrp() {
      return this.ecrDeviseGrp;
   }

   public void setEcrDeviseGrp(String var1) {
      this.ecrDeviseGrp = var1;
   }

   public String getEcrDevisePays() {
      return this.ecrDevisePays;
   }

   public void setEcrDevisePays(String var1) {
      this.ecrDevisePays = var1;
   }
}
