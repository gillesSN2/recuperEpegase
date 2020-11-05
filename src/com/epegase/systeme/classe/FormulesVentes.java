package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FormulesVentes implements Serializable {
   private long forvteId;
   private Date forvteDateCreation;
   private Date forvteDateModif;
   private long forvteUserCreation;
   private long forvteUserModif;
   private String forvteLibelleFr;
   private String forvteLibelleUk;
   private String forvteLibelleSp;
   private String forvteDetailFr;
   private String forvteDetailUk;
   private String forvteDetailSp;
   private ExercicesVentes exerciceventes;
   private int forvteInactif;
   private String etat;
   private boolean afficheImag;

   public String getEtat() {
      if (this.forvteInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.forvteInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.forvteInactif != 1 && this.forvteInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public int getForvteInactif() {
      return this.forvteInactif;
   }

   public void setForvteInactif(int var1) {
      this.forvteInactif = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public Date getForvteDateCreation() {
      return this.forvteDateCreation;
   }

   public void setForvteDateCreation(Date var1) {
      this.forvteDateCreation = var1;
   }

   public Date getForvteDateModif() {
      return this.forvteDateModif;
   }

   public void setForvteDateModif(Date var1) {
      this.forvteDateModif = var1;
   }

   public long getForvteId() {
      return this.forvteId;
   }

   public void setForvteId(long var1) {
      this.forvteId = var1;
   }

   public String getForvteLibelleFr() {
      return this.forvteLibelleFr;
   }

   public void setForvteLibelleFr(String var1) {
      this.forvteLibelleFr = var1;
   }

   public String getForvteLibelleSp() {
      return this.forvteLibelleSp;
   }

   public void setForvteLibelleSp(String var1) {
      this.forvteLibelleSp = var1;
   }

   public String getForvteLibelleUk() {
      return this.forvteLibelleUk;
   }

   public void setForvteLibelleUk(String var1) {
      this.forvteLibelleUk = var1;
   }

   public long getForvteUserCreation() {
      return this.forvteUserCreation;
   }

   public void setForvteUserCreation(long var1) {
      this.forvteUserCreation = var1;
   }

   public long getForvteUserModif() {
      return this.forvteUserModif;
   }

   public void setForvteUserModif(long var1) {
      this.forvteUserModif = var1;
   }

   public String getForvteDetailFr() {
      return this.forvteDetailFr;
   }

   public void setForvteDetailFr(String var1) {
      this.forvteDetailFr = var1;
   }

   public String getForvteDetailSp() {
      return this.forvteDetailSp;
   }

   public void setForvteDetailSp(String var1) {
      this.forvteDetailSp = var1;
   }

   public String getForvteDetailUk() {
      return this.forvteDetailUk;
   }

   public void setForvteDetailUk(String var1) {
      this.forvteDetailUk = var1;
   }
}
