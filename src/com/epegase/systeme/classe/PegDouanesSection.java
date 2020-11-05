package com.epegase.systeme.classe;

import java.io.Serializable;

public class PegDouanesSection implements Serializable {
   private long dousecId;
   private String dousecZone;
   private String dousecCode;
   private String dousecLibFR;
   private String dousecLibUK;
   private String dousecLibSP;

   public String getDousecCode() {
      return this.dousecCode;
   }

   public void setDousecCode(String var1) {
      this.dousecCode = var1;
   }

   public long getDousecId() {
      return this.dousecId;
   }

   public void setDousecId(long var1) {
      this.dousecId = var1;
   }

   public String getDousecLibFR() {
      return this.dousecLibFR;
   }

   public void setDousecLibFR(String var1) {
      this.dousecLibFR = var1;
   }

   public String getDousecLibSP() {
      return this.dousecLibSP;
   }

   public void setDousecLibSP(String var1) {
      this.dousecLibSP = var1;
   }

   public String getDousecLibUK() {
      return this.dousecLibUK;
   }

   public void setDousecLibUK(String var1) {
      this.dousecLibUK = var1;
   }

   public String getDousecZone() {
      return this.dousecZone;
   }

   public void setDousecZone(String var1) {
      this.dousecZone = var1;
   }
}
