package com.epegase.systeme.classe;

import java.io.Serializable;

public class FeuilleCalculFormule implements Serializable {
   private long feurubfor_id;
   private String feurubforFeuille;
   private String feurubforCode;
   private String feurubforColonne;
   private String feurubforFormule;
   private FeuilleCalculRubrique feuilleCalculRubrique;
   private FeuilleCalcul feuilleCalcul;

   public FeuilleCalculRubrique getFeuilleCalculRubrique() {
      return this.feuilleCalculRubrique;
   }

   public void setFeuilleCalculRubrique(FeuilleCalculRubrique var1) {
      this.feuilleCalculRubrique = var1;
   }

   public String getFeurubforCode() {
      return this.feurubforCode;
   }

   public void setFeurubforCode(String var1) {
      this.feurubforCode = var1;
   }

   public String getFeurubforColonne() {
      return this.feurubforColonne;
   }

   public void setFeurubforColonne(String var1) {
      this.feurubforColonne = var1;
   }

   public String getFeurubforFormule() {
      return this.feurubforFormule;
   }

   public void setFeurubforFormule(String var1) {
      this.feurubforFormule = var1;
   }

   public long getFeurubfor_id() {
      return this.feurubfor_id;
   }

   public void setFeurubfor_id(long var1) {
      this.feurubfor_id = var1;
   }

   public FeuilleCalcul getFeuilleCalcul() {
      return this.feuilleCalcul;
   }

   public void setFeuilleCalcul(FeuilleCalcul var1) {
      this.feuilleCalcul = var1;
   }

   public String getFeurubforFeuille() {
      return this.feurubforFeuille;
   }

   public void setFeurubforFeuille(String var1) {
      this.feurubforFeuille = var1;
   }
}
