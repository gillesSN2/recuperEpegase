package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class SuiviLivraisonVentes implements Serializable {
   private long suivteId;
   private Date suivteDateCreation;
   private Date suivteDateModif;
   private long suivteUserCreation;
   private long suivteUserModif;
   private String suivteCode;
   private String suivteLibelleFr;
   private String suivteLibelleUk;
   private String suivteLibelleSp;
   private boolean suivteMaritime;
   private boolean suivteAerien;
   private boolean suivteExpress;
   private boolean suivteRoute;
   private boolean suivteAutreTransit;
   private int suivteInactif;
   private ExercicesVentes exerciceventes;
   private boolean afficheImag;
   private String etat;

   public String getEtat() {
      if (this.suivteInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.suivteInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.suivteInactif != 1 && this.suivteInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public int getSuivteInactif() {
      return this.suivteInactif;
   }

   public void setSuivteInactif(int var1) {
      this.suivteInactif = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public boolean isSuivteAerien() {
      return this.suivteAerien;
   }

   public void setSuivteAerien(boolean var1) {
      this.suivteAerien = var1;
   }

   public boolean isSuivteAutreTransit() {
      return this.suivteAutreTransit;
   }

   public void setSuivteAutreTransit(boolean var1) {
      this.suivteAutreTransit = var1;
   }

   public String getSuivteCode() {
      if (this.suivteCode != null && !this.suivteCode.isEmpty()) {
         this.suivteCode = this.suivteCode.toUpperCase();
      }

      return this.suivteCode;
   }

   public void setSuivteCode(String var1) {
      this.suivteCode = var1;
   }

   public Date getSuivteDateCreation() {
      return this.suivteDateCreation;
   }

   public void setSuivteDateCreation(Date var1) {
      this.suivteDateCreation = var1;
   }

   public Date getSuivteDateModif() {
      return this.suivteDateModif;
   }

   public void setSuivteDateModif(Date var1) {
      this.suivteDateModif = var1;
   }

   public boolean isSuivteExpress() {
      return this.suivteExpress;
   }

   public void setSuivteExpress(boolean var1) {
      this.suivteExpress = var1;
   }

   public long getSuivteId() {
      return this.suivteId;
   }

   public void setSuivteId(long var1) {
      this.suivteId = var1;
   }

   public String getSuivteLibelleFr() {
      if (this.suivteLibelleFr != null && !this.suivteLibelleFr.isEmpty()) {
         this.suivteLibelleFr = this.suivteLibelleFr.toUpperCase();
      }

      return this.suivteLibelleFr;
   }

   public void setSuivteLibelleFr(String var1) {
      this.suivteLibelleFr = var1;
   }

   public String getSuivteLibelleSp() {
      return this.suivteLibelleSp;
   }

   public void setSuivteLibelleSp(String var1) {
      this.suivteLibelleSp = var1;
   }

   public String getSuivteLibelleUk() {
      return this.suivteLibelleUk;
   }

   public void setSuivteLibelleUk(String var1) {
      this.suivteLibelleUk = var1;
   }

   public boolean isSuivteMaritime() {
      return this.suivteMaritime;
   }

   public void setSuivteMaritime(boolean var1) {
      this.suivteMaritime = var1;
   }

   public boolean isSuivteRoute() {
      return this.suivteRoute;
   }

   public void setSuivteRoute(boolean var1) {
      this.suivteRoute = var1;
   }

   public long getSuivteUserCreation() {
      return this.suivteUserCreation;
   }

   public void setSuivteUserCreation(long var1) {
      this.suivteUserCreation = var1;
   }

   public long getSuivteUserModif() {
      return this.suivteUserModif;
   }

   public void setSuivteUserModif(long var1) {
      this.suivteUserModif = var1;
   }
}
