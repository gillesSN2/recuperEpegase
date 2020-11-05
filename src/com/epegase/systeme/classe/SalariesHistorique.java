package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class SalariesHistorique implements Serializable {
   private long salhisId;
   private String salhisContrat;
   private String salhisCode;
   private String salhisLibelle;
   private Date salhisDate;
   private double salhisValeurColE;
   private Salaries salaries;
   private ExercicesPaye exercicesPaye;

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public String getSalhisCode() {
      return this.salhisCode;
   }

   public void setSalhisCode(String var1) {
      this.salhisCode = var1;
   }

   public String getSalhisLibelle() {
      return this.salhisLibelle;
   }

   public void setSalhisLibelle(String var1) {
      this.salhisLibelle = var1;
   }

   public String getSalhisContrat() {
      return this.salhisContrat;
   }

   public void setSalhisContrat(String var1) {
      this.salhisContrat = var1;
   }

   public long getSalhisId() {
      return this.salhisId;
   }

   public void setSalhisId(long var1) {
      this.salhisId = var1;
   }

   public Date getSalhisDate() {
      return this.salhisDate;
   }

   public void setSalhisDate(Date var1) {
      this.salhisDate = var1;
   }

   public double getSalhisValeurColE() {
      return this.salhisValeurColE;
   }

   public void setSalhisValeurColE(double var1) {
      this.salhisValeurColE = var1;
   }
}
