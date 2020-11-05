package com.epegase.systeme.classe;

import java.io.Serializable;

public class ConsultationLabo implements Serializable {
   private long csllabId;
   private String csllabProduit;
   private String csllabLibelle;
   private String csllabObs;
   private ConsultationEnteteGene consultationEnteteGene;

   public ConsultationEnteteGene getConsultationEnteteGene() {
      return this.consultationEnteteGene;
   }

   public void setConsultationEnteteGene(ConsultationEnteteGene var1) {
      this.consultationEnteteGene = var1;
   }

   public long getCsllabId() {
      return this.csllabId;
   }

   public void setCsllabId(long var1) {
      this.csllabId = var1;
   }

   public String getCsllabLibelle() {
      return this.csllabLibelle;
   }

   public void setCsllabLibelle(String var1) {
      this.csllabLibelle = var1;
   }

   public String getCsllabObs() {
      return this.csllabObs;
   }

   public void setCsllabObs(String var1) {
      this.csllabObs = var1;
   }

   public String getCsllabProduit() {
      return this.csllabProduit;
   }

   public void setCsllabProduit(String var1) {
      this.csllabProduit = var1;
   }
}
