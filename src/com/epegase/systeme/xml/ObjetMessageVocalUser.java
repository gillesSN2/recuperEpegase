package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetMessageVocalUser implements Serializable {
   private String dateJour;
   private String heure;
   private String time;
   private String condit1;
   private String condit2;
   private String message;

   public String getDateJour() {
      return this.dateJour;
   }

   public void setDateJour(String var1) {
      this.dateJour = var1;
   }

   public String getHeure() {
      return this.heure;
   }

   public void setHeure(String var1) {
      this.heure = var1;
   }

   public String getMessage() {
      return this.message;
   }

   public void setMessage(String var1) {
      this.message = var1;
   }

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

   public String getTime() {
      return this.time;
   }

   public void setTime(String var1) {
      this.time = var1;
   }
}
