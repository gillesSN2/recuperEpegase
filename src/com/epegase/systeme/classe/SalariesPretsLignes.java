package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class SalariesPretsLignes implements Serializable {
   private long salpreligId;
   private String salpreligNum;
   private double salpreligMontantTheo;
   private Date salpreligDateTheo;
   private double salpreligMontantReel;
   private Date salpreligDateReel;
   private String salpreligReference;
   private Date salpreligDatePaiement;
   private String salpreligCaisse;
   private SalariesPrets salariesPrets;
   private Salaries salaries;
   private double totalPret;
   private double totalRmb;
   private int nbReste;

   public int getNbReste() {
      return this.nbReste;
   }

   public void setNbReste(int var1) {
      this.nbReste = var1;
   }

   public double getTotalPret() {
      return this.totalPret;
   }

   public void setTotalPret(double var1) {
      this.totalPret = var1;
   }

   public double getTotalRmb() {
      return this.totalRmb;
   }

   public void setTotalRmb(double var1) {
      this.totalRmb = var1;
   }

   public SalariesPrets getSalariesPrets() {
      return this.salariesPrets;
   }

   public void setSalariesPrets(SalariesPrets var1) {
      this.salariesPrets = var1;
   }

   public String getSalpreligCaisse() {
      return this.salpreligCaisse;
   }

   public void setSalpreligCaisse(String var1) {
      this.salpreligCaisse = var1;
   }

   public Date getSalpreligDatePaiement() {
      return this.salpreligDatePaiement;
   }

   public void setSalpreligDatePaiement(Date var1) {
      this.salpreligDatePaiement = var1;
   }

   public Date getSalpreligDateReel() {
      return this.salpreligDateReel;
   }

   public void setSalpreligDateReel(Date var1) {
      this.salpreligDateReel = var1;
   }

   public Date getSalpreligDateTheo() {
      return this.salpreligDateTheo;
   }

   public void setSalpreligDateTheo(Date var1) {
      this.salpreligDateTheo = var1;
   }

   public long getSalpreligId() {
      return this.salpreligId;
   }

   public void setSalpreligId(long var1) {
      this.salpreligId = var1;
   }

   public double getSalpreligMontantReel() {
      return this.salpreligMontantReel;
   }

   public void setSalpreligMontantReel(double var1) {
      this.salpreligMontantReel = var1;
   }

   public double getSalpreligMontantTheo() {
      return this.salpreligMontantTheo;
   }

   public void setSalpreligMontantTheo(double var1) {
      this.salpreligMontantTheo = var1;
   }

   public String getSalpreligNum() {
      return this.salpreligNum;
   }

   public void setSalpreligNum(String var1) {
      this.salpreligNum = var1;
   }

   public String getSalpreligReference() {
      return this.salpreligReference;
   }

   public void setSalpreligReference(String var1) {
      this.salpreligReference = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }
}
