package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class SalariesVariables implements Serializable {
   private long salvarId;
   private String salvarContrat;
   private String salvarCode;
   private String salvarFeuille;
   private String salvarPeriode;
   private Date salvarJour;
   private double salvarValeurColA;
   private double salvarValeurColB;
   private double salvarValeurColC;
   private double salvarValeurColD;
   private double salvarValeurColE;
   private boolean salvarVariableA;
   private boolean salvarVariableB;
   private boolean salvarVariableC;
   private boolean salvarVariableD;
   private boolean salvarVariableE;
   private Salaries salaries;
   private PlanPaye planPaye;
   private boolean griseVariableA;
   private boolean griseVariableB;
   private boolean griseVariableC;
   private boolean griseVariableD;
   private boolean griseVariableE;

   public PlanPaye getPlanPaye() {
      return this.planPaye;
   }

   public void setPlanPaye(PlanPaye var1) {
      this.planPaye = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public String getSalvarCode() {
      return this.salvarCode;
   }

   public void setSalvarCode(String var1) {
      this.salvarCode = var1;
   }

   public long getSalvarId() {
      return this.salvarId;
   }

   public void setSalvarId(long var1) {
      this.salvarId = var1;
   }

   public String getSalvarPeriode() {
      return this.salvarPeriode;
   }

   public void setSalvarPeriode(String var1) {
      this.salvarPeriode = var1;
   }

   public double getSalvarValeurColA() {
      return this.salvarValeurColA;
   }

   public void setSalvarValeurColA(double var1) {
      this.salvarValeurColA = var1;
   }

   public double getSalvarValeurColB() {
      return this.salvarValeurColB;
   }

   public void setSalvarValeurColB(double var1) {
      this.salvarValeurColB = var1;
   }

   public double getSalvarValeurColC() {
      return this.salvarValeurColC;
   }

   public void setSalvarValeurColC(double var1) {
      this.salvarValeurColC = var1;
   }

   public double getSalvarValeurColD() {
      return this.salvarValeurColD;
   }

   public void setSalvarValeurColD(double var1) {
      this.salvarValeurColD = var1;
   }

   public double getSalvarValeurColE() {
      return this.salvarValeurColE;
   }

   public void setSalvarValeurColE(double var1) {
      this.salvarValeurColE = var1;
   }

   public boolean isSalvarVariableA() {
      return this.salvarVariableA;
   }

   public void setSalvarVariableA(boolean var1) {
      this.salvarVariableA = var1;
   }

   public boolean isSalvarVariableB() {
      return this.salvarVariableB;
   }

   public void setSalvarVariableB(boolean var1) {
      this.salvarVariableB = var1;
   }

   public boolean isSalvarVariableC() {
      return this.salvarVariableC;
   }

   public void setSalvarVariableC(boolean var1) {
      this.salvarVariableC = var1;
   }

   public boolean isSalvarVariableD() {
      return this.salvarVariableD;
   }

   public void setSalvarVariableD(boolean var1) {
      this.salvarVariableD = var1;
   }

   public boolean isSalvarVariableE() {
      return this.salvarVariableE;
   }

   public void setSalvarVariableE(boolean var1) {
      this.salvarVariableE = var1;
   }

   public String getSalvarFeuille() {
      return this.salvarFeuille;
   }

   public void setSalvarFeuille(String var1) {
      this.salvarFeuille = var1;
   }

   public String getSalvarContrat() {
      return this.salvarContrat;
   }

   public void setSalvarContrat(String var1) {
      this.salvarContrat = var1;
   }

   public Date getSalvarJour() {
      return this.salvarJour;
   }

   public void setSalvarJour(Date var1) {
      this.salvarJour = var1;
   }

   public boolean isGriseVariableA() {
      return this.griseVariableA;
   }

   public void setGriseVariableA(boolean var1) {
      this.griseVariableA = var1;
   }

   public boolean isGriseVariableB() {
      return this.griseVariableB;
   }

   public void setGriseVariableB(boolean var1) {
      this.griseVariableB = var1;
   }

   public boolean isGriseVariableC() {
      return this.griseVariableC;
   }

   public void setGriseVariableC(boolean var1) {
      this.griseVariableC = var1;
   }

   public boolean isGriseVariableD() {
      return this.griseVariableD;
   }

   public void setGriseVariableD(boolean var1) {
      this.griseVariableD = var1;
   }

   public boolean isGriseVariableE() {
      return this.griseVariableE;
   }

   public void setGriseVariableE(boolean var1) {
      this.griseVariableE = var1;
   }
}
