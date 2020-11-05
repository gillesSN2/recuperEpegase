package com.epegase.systeme.classe;

import java.io.Serializable;

public class CmaMedical implements Serializable {
   private long cmaId;
   private String cmaCode;
   private String cmaLibelleFr;
   private String cmaLibelleUk;
   private String cmaLibelleSp;
   private int cmaCma;
   private int cmaCmas;
   private int cmaCmasnt;
   private String etat;
   private boolean inactifcma;
   private boolean inactifcmas;
   private boolean inactifcmasnt;

   public boolean isInactifcmas() {
      if (this.cmaCmas == 1) {
         this.inactifcmas = true;
      } else {
         this.inactifcmas = false;
      }

      return this.inactifcmas;
   }

   public void setInactifcmas(boolean var1) {
      this.inactifcmas = var1;
   }

   public boolean isInactifcmasnt() {
      if (this.cmaCmasnt == 1) {
         this.inactifcmasnt = true;
      } else {
         this.inactifcmasnt = false;
      }

      return this.inactifcmasnt;
   }

   public void setInactifcmasnt(boolean var1) {
      this.inactifcmasnt = var1;
   }

   public String getEtat() {
      this.etat = "/images/valider.png";
      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactifcma() {
      if (this.cmaCma == 1) {
         this.inactifcma = true;
      } else {
         this.inactifcma = false;
      }

      return this.inactifcma;
   }

   public void setInactifcma(boolean var1) {
      this.inactifcma = var1;
   }

   public int getCmaCma() {
      return this.cmaCma;
   }

   public void setCmaCma(int var1) {
      this.cmaCma = var1;
   }

   public int getCmaCmas() {
      return this.cmaCmas;
   }

   public void setCmaCmas(int var1) {
      this.cmaCmas = var1;
   }

   public int getCmaCmasnt() {
      return this.cmaCmasnt;
   }

   public void setCmaCmasnt(int var1) {
      this.cmaCmasnt = var1;
   }

   public String getCmaCode() {
      return this.cmaCode;
   }

   public void setCmaCode(String var1) {
      this.cmaCode = var1;
   }

   public long getCmaId() {
      return this.cmaId;
   }

   public void setCmaId(long var1) {
      this.cmaId = var1;
   }

   public String getCmaLibelleFr() {
      return this.cmaLibelleFr;
   }

   public void setCmaLibelleFr(String var1) {
      this.cmaLibelleFr = var1;
   }

   public String getCmaLibelleSp() {
      return this.cmaLibelleSp;
   }

   public void setCmaLibelleSp(String var1) {
      this.cmaLibelleSp = var1;
   }

   public String getCmaLibelleUk() {
      return this.cmaLibelleUk;
   }

   public void setCmaLibelleUk(String var1) {
      this.cmaLibelleUk = var1;
   }
}
