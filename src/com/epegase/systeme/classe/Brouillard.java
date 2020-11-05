package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Brouillard implements Serializable {
   private long bro_id;
   private long broIdOrigine;
   private String broTypeOrigine;
   private Date broDateCreat;
   private Date broDateModif;
   private long broUserCreat;
   private long broUserModif;
   private long broIdResponsable;
   private String broNomResponsable;
   private String broCode;
   private Date broDateSaisie;
   private String broPeriode;
   private int broJour = 1;
   private String broAnnee;
   private String broDeviseSaisie;
   private double broDebitSaisie;
   private double broCreditSaisie;
   private float broCoefEuro;
   private double broDebitEuro;
   private double broCreditEuro;
   private String broDevisePays;
   private float broCoefPays;
   private double broDebitPays;
   private double broCreditPays;
   private String broDeviseGrp;
   private float broCoefGrp;
   private double broDebitGrp;
   private double broCreditGrp;
   private int broCloture;
   private int broEtat;
   private String broLibelle;
   private String broPiece;
   private boolean broPj;
   private String broNumTrf;
   private long broNum;
   private String broReference1;
   private String broReference2;
   private int broNatureJrx;
   private ExercicesComptable exercicescomptable;
   private String lib_etat;

   public ExercicesComptable getExercicescomptable() {
      return this.exercicescomptable;
   }

   public void setExercicescomptable(ExercicesComptable var1) {
      this.exercicescomptable = var1;
   }

   public int getBroCloture() {
      return this.broCloture;
   }

   public void setBroCloture(int var1) {
      this.broCloture = var1;
   }

   public String getBroCode() {
      return this.broCode;
   }

   public void setBroCode(String var1) {
      this.broCode = var1;
   }

   public float getBroCoefEuro() {
      return this.broCoefEuro;
   }

   public void setBroCoefEuro(float var1) {
      this.broCoefEuro = var1;
   }

   public float getBroCoefGrp() {
      return this.broCoefGrp;
   }

   public void setBroCoefGrp(float var1) {
      this.broCoefGrp = var1;
   }

   public float getBroCoefPays() {
      return this.broCoefPays;
   }

   public void setBroCoefPays(float var1) {
      this.broCoefPays = var1;
   }

   public double getBroCreditEuro() {
      return this.broCreditEuro;
   }

   public void setBroCreditEuro(double var1) {
      this.broCreditEuro = var1;
   }

   public double getBroCreditGrp() {
      return this.broCreditGrp;
   }

   public void setBroCreditGrp(double var1) {
      this.broCreditGrp = var1;
   }

   public double getBroCreditPays() {
      return this.broCreditPays;
   }

   public void setBroCreditPays(double var1) {
      this.broCreditPays = var1;
   }

   public double getBroCreditSaisie() {
      return this.broCreditSaisie;
   }

   public void setBroCreditSaisie(double var1) {
      this.broCreditSaisie = var1;
   }

   public Date getBroDateCreat() {
      return this.broDateCreat;
   }

   public void setBroDateCreat(Date var1) {
      this.broDateCreat = var1;
   }

   public Date getBroDateModif() {
      return this.broDateModif;
   }

   public void setBroDateModif(Date var1) {
      this.broDateModif = var1;
   }

   public Date getBroDateSaisie() {
      return this.broDateSaisie;
   }

   public void setBroDateSaisie(Date var1) {
      this.broDateSaisie = var1;
   }

   public double getBroDebitEuro() {
      return this.broDebitEuro;
   }

   public void setBroDebitEuro(double var1) {
      this.broDebitEuro = var1;
   }

   public double getBroDebitGrp() {
      return this.broDebitGrp;
   }

   public void setBroDebitGrp(double var1) {
      this.broDebitGrp = var1;
   }

   public double getBroDebitPays() {
      return this.broDebitPays;
   }

   public void setBroDebitPays(double var1) {
      this.broDebitPays = var1;
   }

   public double getBroDebitSaisie() {
      return this.broDebitSaisie;
   }

   public void setBroDebitSaisie(double var1) {
      this.broDebitSaisie = var1;
   }

   public String getBroDeviseGrp() {
      return this.broDeviseGrp;
   }

   public void setBroDeviseGrp(String var1) {
      this.broDeviseGrp = var1;
   }

   public String getBroDevisePays() {
      return this.broDevisePays;
   }

   public void setBroDevisePays(String var1) {
      this.broDevisePays = var1;
   }

   public String getBroDeviseSaisie() {
      return this.broDeviseSaisie;
   }

   public void setBroDeviseSaisie(String var1) {
      this.broDeviseSaisie = var1;
   }

   public long getBro_id() {
      return this.bro_id;
   }

   public void setBro_id(long var1) {
      this.bro_id = var1;
   }

   public String getBroAnnee() {
      return this.broAnnee;
   }

   public void setBroAnnee(String var1) {
      this.broAnnee = var1;
   }

   public int getBroJour() {
      return this.broJour;
   }

   public void setBroJour(int var1) {
      this.broJour = var1;
   }

   public String getBroLibelle() {
      return this.broLibelle;
   }

   public void setBroLibelle(String var1) {
      this.broLibelle = var1;
   }

   public int getBroNatureJrx() {
      return this.broNatureJrx;
   }

   public void setBroNatureJrx(int var1) {
      this.broNatureJrx = var1;
   }

   public String getBroPeriode() {
      return this.broPeriode;
   }

   public void setBroPeriode(String var1) {
      this.broPeriode = var1;
   }

   public String getBroPiece() {
      return this.broPiece;
   }

   public void setBroPiece(String var1) {
      this.broPiece = var1;
   }

   public String getBroReference1() {
      return this.broReference1;
   }

   public void setBroReference1(String var1) {
      this.broReference1 = var1;
   }

   public String getBroReference2() {
      return this.broReference2;
   }

   public void setBroReference2(String var1) {
      this.broReference2 = var1;
   }

   public long getBroUserCreat() {
      return this.broUserCreat;
   }

   public void setBroUserCreat(long var1) {
      this.broUserCreat = var1;
   }

   public long getBroUserModif() {
      return this.broUserModif;
   }

   public void setBroUserModif(long var1) {
      this.broUserModif = var1;
   }

   public int getBroEtat() {
      return this.broEtat;
   }

   public void setBroEtat(int var1) {
      this.broEtat = var1;
   }

   public String getLib_etat() {
      if (this.broEtat == 0) {
         this.lib_etat = "E.C.";
      } else if (this.broEtat == 1) {
         this.lib_etat = "Val.";
      }

      return this.lib_etat;
   }

   public void setLib_etat(String var1) {
      this.lib_etat = var1;
   }

   public long getBroNum() {
      return this.broNum;
   }

   public void setBroNum(long var1) {
      this.broNum = var1;
   }

   public long getBroIdOrigine() {
      return this.broIdOrigine;
   }

   public void setBroIdOrigine(long var1) {
      this.broIdOrigine = var1;
   }

   public String getBroTypeOrigine() {
      return this.broTypeOrigine;
   }

   public void setBroTypeOrigine(String var1) {
      this.broTypeOrigine = var1;
   }

   public String getBroNumTrf() {
      return this.broNumTrf;
   }

   public void setBroNumTrf(String var1) {
      this.broNumTrf = var1;
   }

   public long getBroIdResponsable() {
      return this.broIdResponsable;
   }

   public void setBroIdResponsable(long var1) {
      this.broIdResponsable = var1;
   }

   public String getBroNomResponsable() {
      return this.broNomResponsable;
   }

   public void setBroNomResponsable(String var1) {
      this.broNomResponsable = var1;
   }

   public boolean isBroPj() {
      return this.broPj;
   }

   public void setBroPj(boolean var1) {
      this.broPj = var1;
   }
}
