package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetMessageVocalCommun implements Serializable {
   private int heureDebut;
   private int heureFin;
   private String condit1;
   private String condit2;
   private String message;

   public String getCondit1() {
      return this.condit1;
   }

   public void setCondit1(String var1) {
      this.condit1 = var1;
   }

   public String getCondit2() {
      return this.condit2;
   }

   public void setCondit2(String var1) {
      this.condit2 = var1;
   }

   public int getHeureDebut() {
      return this.heureDebut;
   }

   public void setHeureDebut(int var1) {
      this.heureDebut = var1;
   }

   public int getHeureFin() {
      return this.heureFin;
   }

   public void setHeureFin(int var1) {
      this.heureFin = var1;
   }

   public String getMessage() {
      return this.message;
   }

   public void setMessage(String var1) {
      this.message = var1;
   }
}
