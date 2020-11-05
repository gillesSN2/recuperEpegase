package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CabinetPeg implements Serializable {
   private long cabId;
   private Date cabDteCreat;
   private String cabEntite;
   private int cabNature;
   private int cabEtat;
   private String libetat;
   private String libmode;

   public String getLibetat() {
      if (this.cabEtat == 0) {
         this.libetat = "En cours";
      } else if (this.cabEtat == 1) {
         this.libetat = "Terminé";
      } else if (this.cabEtat == 2) {
         this.libetat = "Litige";
      } else if (this.cabEtat == 3) {
         this.libetat = "Abandonné";
      }

      return this.libetat;
   }

   public void setLibetat(String var1) {
      this.libetat = var1;
   }

   public String getLibmode() {
      if (this.cabNature == 0) {
         this.libmode = "???";
      } else if (this.cabNature == 1) {
         this.libmode = "Cabinet";
      } else if (this.cabNature == 2) {
         this.libmode = "Groupe";
      } else if (this.cabNature == 3) {
         this.libmode = "Franchise";
      } else if (this.cabNature == 4) {
         this.libmode = "Centre de Formation";
      } else if (this.cabNature == 5) {
         this.libmode = "Distributeur";
      }

      return this.libmode;
   }

   public void setLibmode(String var1) {
      this.libmode = var1;
   }

   public String getCabEntite() {
      return this.cabEntite;
   }

   public void setCabEntite(String var1) {
      this.cabEntite = var1;
   }

   public long getCabId() {
      return this.cabId;
   }

   public void setCabId(long var1) {
      this.cabId = var1;
   }

   public int getCabNature() {
      return this.cabNature;
   }

   public void setCabNature(int var1) {
      this.cabNature = var1;
   }

   public int getCabEtat() {
      return this.cabEtat;
   }

   public void setCabEtat(int var1) {
      this.cabEtat = var1;
   }

   public Date getCabDteCreat() {
      return this.cabDteCreat;
   }

   public void setCabDteCreat(Date var1) {
      this.cabDteCreat = var1;
   }
}
