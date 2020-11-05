package com.epegase.systeme.control;

import java.io.Serializable;

public class ObjetBaseReference implements Serializable {
   private String codeRubrique;
   private String calculReference;
   private double valeurBaseReference;

   public String getCodeRubrique() {
      return this.codeRubrique;
   }

   public void setCodeRubrique(String var1) {
      this.codeRubrique = var1;
   }

   public double getValeurBaseReference() {
      return this.valeurBaseReference;
   }

   public void setValeurBaseReference(double var1) {
      this.valeurBaseReference = var1;
   }

   public String getCalculReference() {
      return this.calculReference;
   }

   public void setCalculReference(String var1) {
      this.calculReference = var1;
   }
}
