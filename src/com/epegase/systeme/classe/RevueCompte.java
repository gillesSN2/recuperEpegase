package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class RevueCompte implements Serializable {
   private long revcpt_id;
   private Date revcptDateCreat;
   private Date revcptDateModif;
   private long revcptUserCreat;
   private long revcptUserModif;
   private String revcptZone;
   private String revcptCompte;
   private String revcptLibelle;
   private String revcpObs;
   private ExercicesComptable exercicesComptable;

   public ExercicesComptable getExercicesComptable() {
      return this.exercicesComptable;
   }

   public void setExercicesComptable(ExercicesComptable var1) {
      this.exercicesComptable = var1;
   }

   public String getRevcpObs() {
      return this.revcpObs;
   }

   public void setRevcpObs(String var1) {
      this.revcpObs = var1;
   }

   public String getRevcptCompte() {
      return this.revcptCompte;
   }

   public void setRevcptCompte(String var1) {
      this.revcptCompte = var1;
   }

   public Date getRevcptDateCreat() {
      return this.revcptDateCreat;
   }

   public void setRevcptDateCreat(Date var1) {
      this.revcptDateCreat = var1;
   }

   public Date getRevcptDateModif() {
      return this.revcptDateModif;
   }

   public void setRevcptDateModif(Date var1) {
      this.revcptDateModif = var1;
   }

   public long getRevcpt_id() {
      return this.revcpt_id;
   }

   public void setRevcpt_id(long var1) {
      this.revcpt_id = var1;
   }

   public String getRevcptLibelle() {
      return this.revcptLibelle;
   }

   public void setRevcptLibelle(String var1) {
      this.revcptLibelle = var1;
   }

   public long getRevcptUserCreat() {
      return this.revcptUserCreat;
   }

   public void setRevcptUserCreat(long var1) {
      this.revcptUserCreat = var1;
   }

   public long getRevcptUserModif() {
      return this.revcptUserModif;
   }

   public void setRevcptUserModif(long var1) {
      this.revcptUserModif = var1;
   }

   public String getRevcptZone() {
      return this.revcptZone;
   }

   public void setRevcptZone(String var1) {
      this.revcptZone = var1;
   }
}
