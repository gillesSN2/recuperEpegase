package com.epegase.systeme.control;

import java.io.Serializable;

public class Cle implements Serializable {
   private long cleId;
   private String clePlanAnalytiqueOrigine;
   private String cleCodeAnalytique;
   private float clePourcentageAnalytique;

   public void cle() {
   }

   public long getCleId() {
      return this.cleId;
   }

   public void setCleId(long var1) {
      this.cleId = var1;
   }

   public String getClePlanAnalytiqueOrigine() {
      return this.clePlanAnalytiqueOrigine;
   }

   public void setClePlanAnalytiqueOrigine(String var1) {
      this.clePlanAnalytiqueOrigine = var1;
   }

   public String getCleCodeAnalytique() {
      return this.cleCodeAnalytique;
   }

   public void setCleCodeAnalytique(String var1) {
      this.cleCodeAnalytique = var1;
   }

   public float getClePourcentageAnalytique() {
      return this.clePourcentageAnalytique;
   }

   public void setClePourcentageAnalytique(float var1) {
      this.clePourcentageAnalytique = var1;
   }
}
