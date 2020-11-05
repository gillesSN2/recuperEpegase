package com.epegase.systeme.classe;

import java.io.Serializable;

public class FeuilleCalculRubrique implements Serializable {
   private long feurub_id;
   private boolean feurubActif;
   private String feurubFeuille;
   private String feurubCode;
   private boolean feurubColA;
   private boolean feurubColB;
   private boolean feurubColC;
   private boolean feurubColD;
   private boolean feurubColE;
   private boolean feurubColARaz;
   private boolean feurubColBRaz;
   private boolean feurubColCRaz;
   private boolean feurubColDRaz;
   private boolean feurubColERaz;
   private boolean feurubVariableA;
   private boolean feurubVariableB;
   private boolean feurubVariableC;
   private boolean feurubVariableD;
   private boolean feurubVariableE;
   private String feurubCompte;
   private FeuilleCalcul feuilleCalcul;
   private PlanPaye planPaye;
   private String formuleA;
   private String formuleB;
   private String formuleC;
   private String formuleD;
   private String formuleE;
   private boolean select;
   private String couleurImpot;

   public String getCouleurImpot() {
      if (this.feurubCode != null && !this.feurubCode.isEmpty()) {
         int var1 = Integer.parseInt(this.feurubCode);
         if (var1 >= 109500 && var1 <= 109559) {
            this.couleurImpot = "color:magenta";
         } else if (var1 >= 109560 && var1 <= 109599) {
            this.couleurImpot = "color:blue";
         } else {
            this.couleurImpot = "color:black";
         }
      } else {
         this.couleurImpot = "color:black";
      }

      return this.couleurImpot;
   }

   public void setCouleurImpot(String var1) {
      this.couleurImpot = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public FeuilleCalcul getFeuilleCalcul() {
      return this.feuilleCalcul;
   }

   public void setFeuilleCalcul(FeuilleCalcul var1) {
      this.feuilleCalcul = var1;
   }

   public PlanPaye getPlanPaye() {
      return this.planPaye;
   }

   public void setPlanPaye(PlanPaye var1) {
      this.planPaye = var1;
   }

   public boolean isFeurubColA() {
      return this.feurubColA;
   }

   public void setFeurubColA(boolean var1) {
      this.feurubColA = var1;
   }

   public boolean isFeurubColARaz() {
      return this.feurubColARaz;
   }

   public void setFeurubColARaz(boolean var1) {
      this.feurubColARaz = var1;
   }

   public boolean isFeurubColB() {
      return this.feurubColB;
   }

   public void setFeurubColB(boolean var1) {
      this.feurubColB = var1;
   }

   public boolean isFeurubColBRaz() {
      return this.feurubColBRaz;
   }

   public void setFeurubColBRaz(boolean var1) {
      this.feurubColBRaz = var1;
   }

   public boolean isFeurubColC() {
      return this.feurubColC;
   }

   public void setFeurubColC(boolean var1) {
      this.feurubColC = var1;
   }

   public boolean isFeurubColCRaz() {
      return this.feurubColCRaz;
   }

   public void setFeurubColCRaz(boolean var1) {
      this.feurubColCRaz = var1;
   }

   public boolean isFeurubColD() {
      return this.feurubColD;
   }

   public void setFeurubColD(boolean var1) {
      this.feurubColD = var1;
   }

   public boolean isFeurubColDRaz() {
      return this.feurubColDRaz;
   }

   public void setFeurubColDRaz(boolean var1) {
      this.feurubColDRaz = var1;
   }

   public boolean isFeurubColE() {
      return this.feurubColE;
   }

   public void setFeurubColE(boolean var1) {
      this.feurubColE = var1;
   }

   public boolean isFeurubColERaz() {
      return this.feurubColERaz;
   }

   public void setFeurubColERaz(boolean var1) {
      this.feurubColERaz = var1;
   }

   public String getFeurubCompte() {
      return this.feurubCompte;
   }

   public void setFeurubCompte(String var1) {
      this.feurubCompte = var1;
   }

   public long getFeurub_id() {
      return this.feurub_id;
   }

   public void setFeurub_id(long var1) {
      this.feurub_id = var1;
   }

   public String getFeurubCode() {
      return this.feurubCode;
   }

   public void setFeurubCode(String var1) {
      this.feurubCode = var1;
   }

   public boolean isFeurubActif() {
      return this.feurubActif;
   }

   public void setFeurubActif(boolean var1) {
      this.feurubActif = var1;
   }

   public boolean isFeurubVariableA() {
      return this.feurubVariableA;
   }

   public void setFeurubVariableA(boolean var1) {
      this.feurubVariableA = var1;
   }

   public boolean isFeurubVariableB() {
      return this.feurubVariableB;
   }

   public void setFeurubVariableB(boolean var1) {
      this.feurubVariableB = var1;
   }

   public boolean isFeurubVariableC() {
      return this.feurubVariableC;
   }

   public void setFeurubVariableC(boolean var1) {
      this.feurubVariableC = var1;
   }

   public boolean isFeurubVariableD() {
      return this.feurubVariableD;
   }

   public void setFeurubVariableD(boolean var1) {
      this.feurubVariableD = var1;
   }

   public boolean isFeurubVariableE() {
      return this.feurubVariableE;
   }

   public void setFeurubVariableE(boolean var1) {
      this.feurubVariableE = var1;
   }

   public String getFormuleA() {
      return this.formuleA;
   }

   public void setFormuleA(String var1) {
      this.formuleA = var1;
   }

   public String getFormuleB() {
      return this.formuleB;
   }

   public void setFormuleB(String var1) {
      this.formuleB = var1;
   }

   public String getFormuleC() {
      return this.formuleC;
   }

   public void setFormuleC(String var1) {
      this.formuleC = var1;
   }

   public String getFormuleD() {
      return this.formuleD;
   }

   public void setFormuleD(String var1) {
      this.formuleD = var1;
   }

   public String getFormuleE() {
      return this.formuleE;
   }

   public void setFormuleE(String var1) {
      this.formuleE = var1;
   }

   public String getFeurubFeuille() {
      return this.feurubFeuille;
   }

   public void setFeurubFeuille(String var1) {
      this.feurubFeuille = var1;
   }
}
