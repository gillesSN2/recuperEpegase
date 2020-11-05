package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class EcrituresAnterieur implements Serializable {
   private long ecrant_id;
   private String ecrantCle1;
   private String ecrantCode;
   private Date ecrantDate;
   private String ecrantPeriode;
   private String ecrantAnnee;
   private double ecrantDebitSaisie;
   private double ecrantCreditSaisie;
   private String ecrantRapprochement;
   private Date ecrantDteRapprochement;
   private int ecrantCloture;
   private String ecrantLibelle;
   private String ecrantPiece;
   private String ecrantReference1;
   private String ecrantReference2;
   private int ecrantType;
   private ExercicesComptable exercicesComptable;

   public String getEcrantAnnee() {
      return this.ecrantAnnee;
   }

   public void setEcrantAnnee(String var1) {
      this.ecrantAnnee = var1;
   }

   public String getEcrantCle1() {
      return this.ecrantCle1;
   }

   public void setEcrantCle1(String var1) {
      this.ecrantCle1 = var1;
   }

   public int getEcrantCloture() {
      return this.ecrantCloture;
   }

   public void setEcrantCloture(int var1) {
      this.ecrantCloture = var1;
   }

   public String getEcrantCode() {
      return this.ecrantCode;
   }

   public void setEcrantCode(String var1) {
      this.ecrantCode = var1;
   }

   public double getEcrantCreditSaisie() {
      return this.ecrantCreditSaisie;
   }

   public void setEcrantCreditSaisie(double var1) {
      this.ecrantCreditSaisie = var1;
   }

   public double getEcrantDebitSaisie() {
      return this.ecrantDebitSaisie;
   }

   public void setEcrantDebitSaisie(double var1) {
      this.ecrantDebitSaisie = var1;
   }

   public String getEcrantLibelle() {
      return this.ecrantLibelle;
   }

   public void setEcrantLibelle(String var1) {
      this.ecrantLibelle = var1;
   }

   public String getEcrantPeriode() {
      return this.ecrantPeriode;
   }

   public void setEcrantPeriode(String var1) {
      this.ecrantPeriode = var1;
   }

   public String getEcrantPiece() {
      return this.ecrantPiece;
   }

   public void setEcrantPiece(String var1) {
      this.ecrantPiece = var1;
   }

   public String getEcrantRapprochement() {
      return this.ecrantRapprochement;
   }

   public void setEcrantRapprochement(String var1) {
      this.ecrantRapprochement = var1;
   }

   public String getEcrantReference1() {
      return this.ecrantReference1;
   }

   public void setEcrantReference1(String var1) {
      this.ecrantReference1 = var1;
   }

   public String getEcrantReference2() {
      return this.ecrantReference2;
   }

   public void setEcrantReference2(String var1) {
      this.ecrantReference2 = var1;
   }

   public long getEcrant_id() {
      return this.ecrant_id;
   }

   public void setEcrant_id(long var1) {
      this.ecrant_id = var1;
   }

   public ExercicesComptable getExercicesComptable() {
      return this.exercicesComptable;
   }

   public void setExercicesComptable(ExercicesComptable var1) {
      this.exercicesComptable = var1;
   }

   public Date getEcrantDate() {
      return this.ecrantDate;
   }

   public void setEcrantDate(Date var1) {
      this.ecrantDate = var1;
   }

   public int getEcrantType() {
      return this.ecrantType;
   }

   public void setEcrantType(int var1) {
      this.ecrantType = var1;
   }

   public Date getEcrantDteRapprochement() {
      return this.ecrantDteRapprochement;
   }

   public void setEcrantDteRapprochement(Date var1) {
      this.ecrantDteRapprochement = var1;
   }
}
