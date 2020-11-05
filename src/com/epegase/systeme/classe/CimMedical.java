package com.epegase.systeme.classe;

import java.io.Serializable;

public class CimMedical implements Serializable {
   private long cimId;
   private String cimCodeCmd;
   private String cimLibCmd;
   private String cimCode;
   private String cimLibelleFR;
   private String cimLibelleUK;
   private String cimLibelleSP;

   public String getCimCodeCmd() {
      return this.cimCodeCmd;
   }

   public void setCimCodeCmd(String var1) {
      this.cimCodeCmd = var1;
   }

   public long getCimId() {
      return this.cimId;
   }

   public void setCimId(long var1) {
      this.cimId = var1;
   }

   public String getCimLibCmd() {
      return this.cimLibCmd;
   }

   public void setCimLibCmd(String var1) {
      this.cimLibCmd = var1;
   }

   public String getCimLibelleFR() {
      return this.cimLibelleFR;
   }

   public void setCimLibelleFR(String var1) {
      this.cimLibelleFR = var1;
   }

   public String getCimLibelleSP() {
      return this.cimLibelleSP;
   }

   public void setCimLibelleSP(String var1) {
      this.cimLibelleSP = var1;
   }

   public String getCimLibelleUK() {
      return this.cimLibelleUK;
   }

   public void setCimLibelleUK(String var1) {
      this.cimLibelleUK = var1;
   }

   public String getCimCode() {
      return this.cimCode;
   }

   public void setCimCode(String var1) {
      this.cimCode = var1;
   }
}
