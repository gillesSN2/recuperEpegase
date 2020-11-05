package com.epegase.systeme.control;

import java.io.Serializable;

public class ObjetPlanPaye implements Serializable {
   private String code;
   private String libelle;
   private boolean select;
   private float pourcentage;
   private String formule;
   private int nature;

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public String getFormule() {
      return this.formule;
   }

   public void setFormule(String var1) {
      this.formule = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }

   public float getPourcentage() {
      return this.pourcentage;
   }

   public void setPourcentage(float var1) {
      this.pourcentage = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }
}
