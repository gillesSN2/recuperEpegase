package com.epegase.systeme.classe;

import java.io.Serializable;

public class ConsultationOrdo implements Serializable {
   private long cslordId;
   private String cslordProduit;
   private String cslordLibelle;
   private String cslordDci;
   private String cslordForme;
   private String cslordPoso;
   private String cslordObs;
   private int cslordQte;
   private String cslordUnite;
   private ConsultationEnteteGene consultationEnteteGene;

   public ConsultationEnteteGene getConsultationEnteteGene() {
      return this.consultationEnteteGene;
   }

   public void setConsultationEnteteGene(ConsultationEnteteGene var1) {
      this.consultationEnteteGene = var1;
   }

   public long getCslordId() {
      return this.cslordId;
   }

   public void setCslordId(long var1) {
      this.cslordId = var1;
   }

   public String getCslordLibelle() {
      return this.cslordLibelle;
   }

   public void setCslordLibelle(String var1) {
      this.cslordLibelle = var1;
   }

   public String getCslordObs() {
      return this.cslordObs;
   }

   public void setCslordObs(String var1) {
      this.cslordObs = var1;
   }

   public String getCslordPoso() {
      return this.cslordPoso;
   }

   public void setCslordPoso(String var1) {
      this.cslordPoso = var1;
   }

   public String getCslordProduit() {
      return this.cslordProduit;
   }

   public void setCslordProduit(String var1) {
      this.cslordProduit = var1;
   }

   public String getCslordDci() {
      return this.cslordDci;
   }

   public void setCslordDci(String var1) {
      this.cslordDci = var1;
   }

   public String getCslordForme() {
      return this.cslordForme;
   }

   public void setCslordForme(String var1) {
      this.cslordForme = var1;
   }

   public int getCslordQte() {
      return this.cslordQte;
   }

   public void setCslordQte(int var1) {
      this.cslordQte = var1;
   }

   public String getCslordUnite() {
      return this.cslordUnite;
   }

   public void setCslordUnite(String var1) {
      this.cslordUnite = var1;
   }
}
