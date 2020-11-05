package com.epegase.systeme.classe;

import java.io.Serializable;

public class PegDouanesChapitre implements Serializable {
   private long douchaId;
   private String douchaZone;
   private String douchaCode;
   private String douchaLibFR;
   private String douchaLibUK;
   private String douchaLibSP;
   private PegDouanesSection pegDouanesSection;

   public PegDouanesSection getPegDouanesSection() {
      return this.pegDouanesSection;
   }

   public void setPegDouanesSection(PegDouanesSection var1) {
      this.pegDouanesSection = var1;
   }

   public String getDouchaCode() {
      return this.douchaCode;
   }

   public void setDouchaCode(String var1) {
      this.douchaCode = var1;
   }

   public long getDouchaId() {
      return this.douchaId;
   }

   public void setDouchaId(long var1) {
      this.douchaId = var1;
   }

   public String getDouchaLibFR() {
      return this.douchaLibFR;
   }

   public void setDouchaLibFR(String var1) {
      this.douchaLibFR = var1;
   }

   public String getDouchaLibSP() {
      return this.douchaLibSP;
   }

   public void setDouchaLibSP(String var1) {
      this.douchaLibSP = var1;
   }

   public String getDouchaLibUK() {
      return this.douchaLibUK;
   }

   public void setDouchaLibUK(String var1) {
      this.douchaLibUK = var1;
   }

   public String getDouchaZone() {
      return this.douchaZone;
   }

   public void setDouchaZone(String var1) {
      this.douchaZone = var1;
   }
}
