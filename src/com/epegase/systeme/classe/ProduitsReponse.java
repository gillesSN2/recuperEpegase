package com.epegase.systeme.classe;

import java.io.Serializable;

public class ProduitsReponse implements Serializable {
   private long prorepId;
   private String prorepCode;
   private String prorepLibelle;
   private int prorepType;
   private String prorepReponse;
   private String prorepTexteModifiable;
   private int prorepOrdre;
   private String prorepQuestion;
   private int prorepResultat;
   private String prorepActionPositive;
   private String prorepActionNegative;
   private boolean prorepActionNumerique;
   private boolean prorepActionTexte;
   private String prorepCodeExamen;
   private String prorepLibelleExamen;
   private ProduitsLaboratoire produitsLaboratoire;
   private ProduitsDetail produitsDetail;
   private boolean rep_select;

   public ProduitsLaboratoire getProduitsLaboratoire() {
      return this.produitsLaboratoire;
   }

   public void setProduitsLaboratoire(ProduitsLaboratoire var1) {
      this.produitsLaboratoire = var1;
   }

   public long getProrepId() {
      return this.prorepId;
   }

   public void setProrepId(long var1) {
      this.prorepId = var1;
   }

   public int getProrepOrdre() {
      return this.prorepOrdre;
   }

   public void setProrepOrdre(int var1) {
      this.prorepOrdre = var1;
   }

   public String getProrepReponse() {
      return this.prorepReponse;
   }

   public void setProrepReponse(String var1) {
      this.prorepReponse = var1;
   }

   public int getProrepType() {
      return this.prorepType;
   }

   public void setProrepType(int var1) {
      this.prorepType = var1;
   }

   public ProduitsDetail getProduitsDetail() {
      return this.produitsDetail;
   }

   public void setProduitsDetail(ProduitsDetail var1) {
      this.produitsDetail = var1;
   }

   public String getProrepActionNegative() {
      return this.prorepActionNegative;
   }

   public void setProrepActionNegative(String var1) {
      this.prorepActionNegative = var1;
   }

   public String getProrepActionPositive() {
      return this.prorepActionPositive;
   }

   public void setProrepActionPositive(String var1) {
      this.prorepActionPositive = var1;
   }

   public String getProrepQuestion() {
      return this.prorepQuestion;
   }

   public void setProrepQuestion(String var1) {
      this.prorepQuestion = var1;
   }

   public int getProrepResultat() {
      return this.prorepResultat;
   }

   public void setProrepResultat(int var1) {
      this.prorepResultat = var1;
   }

   public String getProrepCode() {
      return this.prorepCode;
   }

   public void setProrepCode(String var1) {
      this.prorepCode = var1;
   }

   public boolean isRep_select() {
      return this.rep_select;
   }

   public void setRep_select(boolean var1) {
      this.rep_select = var1;
   }

   public String getProrepLibelle() {
      return this.prorepLibelle;
   }

   public void setProrepLibelle(String var1) {
      this.prorepLibelle = var1;
   }

   public boolean isProrepActionNumerique() {
      return this.prorepActionNumerique;
   }

   public void setProrepActionNumerique(boolean var1) {
      this.prorepActionNumerique = var1;
   }

   public String getProrepTexteModifiable() {
      return this.prorepTexteModifiable;
   }

   public void setProrepTexteModifiable(String var1) {
      this.prorepTexteModifiable = var1;
   }

   public boolean isProrepActionTexte() {
      return this.prorepActionTexte;
   }

   public void setProrepActionTexte(boolean var1) {
      this.prorepActionTexte = var1;
   }

   public String getProrepCodeExamen() {
      return this.prorepCodeExamen;
   }

   public void setProrepCodeExamen(String var1) {
      this.prorepCodeExamen = var1;
   }

   public String getProrepLibelleExamen() {
      return this.prorepLibelleExamen;
   }

   public void setProrepLibelleExamen(String var1) {
      this.prorepLibelleExamen = var1;
   }
}
