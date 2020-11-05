package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class SalariesCapitalisation implements Serializable {
   private long salcapId;
   private Date salcapDateCreat;
   private Date salcapDateModif;
   private long salcapUserCreat;
   private long salcapUserModif;
   private String salcapContrat;
   private double salcapInitial;
   private double salcapMontant;
   private String salcapRubVersement;
   private String salcapRubSpontanee;
   private String salcapRubRetrait;
   private int salcapEtat;
   private Date salcapDateValide;
   private Date salcapDateImp;
   private Salaries salaries;

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public Date getSalcapDateCreat() {
      return this.salcapDateCreat;
   }

   public void setSalcapDateCreat(Date var1) {
      this.salcapDateCreat = var1;
   }

   public Date getSalcapDateImp() {
      return this.salcapDateImp;
   }

   public void setSalcapDateImp(Date var1) {
      this.salcapDateImp = var1;
   }

   public Date getSalcapDateModif() {
      return this.salcapDateModif;
   }

   public void setSalcapDateModif(Date var1) {
      this.salcapDateModif = var1;
   }

   public Date getSalcapDateValide() {
      return this.salcapDateValide;
   }

   public void setSalcapDateValide(Date var1) {
      this.salcapDateValide = var1;
   }

   public int getSalcapEtat() {
      return this.salcapEtat;
   }

   public void setSalcapEtat(int var1) {
      this.salcapEtat = var1;
   }

   public long getSalcapId() {
      return this.salcapId;
   }

   public void setSalcapId(long var1) {
      this.salcapId = var1;
   }

   public double getSalcapInitial() {
      return this.salcapInitial;
   }

   public void setSalcapInitial(double var1) {
      this.salcapInitial = var1;
   }

   public String getSalcapRubRetrait() {
      return this.salcapRubRetrait;
   }

   public void setSalcapRubRetrait(String var1) {
      this.salcapRubRetrait = var1;
   }

   public String getSalcapRubSpontanee() {
      return this.salcapRubSpontanee;
   }

   public void setSalcapRubSpontanee(String var1) {
      this.salcapRubSpontanee = var1;
   }

   public String getSalcapRubVersement() {
      return this.salcapRubVersement;
   }

   public void setSalcapRubVersement(String var1) {
      this.salcapRubVersement = var1;
   }

   public long getSalcapUserCreat() {
      return this.salcapUserCreat;
   }

   public void setSalcapUserCreat(long var1) {
      this.salcapUserCreat = var1;
   }

   public long getSalcapUserModif() {
      return this.salcapUserModif;
   }

   public void setSalcapUserModif(long var1) {
      this.salcapUserModif = var1;
   }

   public double getSalcapMontant() {
      return this.salcapMontant;
   }

   public void setSalcapMontant(double var1) {
      this.salcapMontant = var1;
   }

   public String getSalcapContrat() {
      return this.salcapContrat;
   }

   public void setSalcapContrat(String var1) {
      this.salcapContrat = var1;
   }
}
