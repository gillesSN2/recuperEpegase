package com.epegase.systeme.classe;

import java.io.Serializable;

public class CmdMedical implements Serializable {
   private long cmdId;
   private String cmdFamCode;
   private String cmdFamLibelleFr;
   private String cmdFamLibelleUk;
   private String cmdFamLibelleSp;
   private String cmdDetCode;
   private String cmdDetLibelleFr;
   private String cmdDetLibelleUk;
   private String cmdDetLibelleSp;
   private int cmdDetType;

   public String getCmdDetCode() {
      return this.cmdDetCode;
   }

   public void setCmdDetCode(String var1) {
      this.cmdDetCode = var1;
   }

   public String getCmdDetLibelleFr() {
      return this.cmdDetLibelleFr;
   }

   public void setCmdDetLibelleFr(String var1) {
      this.cmdDetLibelleFr = var1;
   }

   public String getCmdDetLibelleSp() {
      return this.cmdDetLibelleSp;
   }

   public void setCmdDetLibelleSp(String var1) {
      this.cmdDetLibelleSp = var1;
   }

   public String getCmdDetLibelleUk() {
      return this.cmdDetLibelleUk;
   }

   public void setCmdDetLibelleUk(String var1) {
      this.cmdDetLibelleUk = var1;
   }

   public int getCmdDetType() {
      return this.cmdDetType;
   }

   public void setCmdDetType(int var1) {
      this.cmdDetType = var1;
   }

   public String getCmdFamCode() {
      return this.cmdFamCode;
   }

   public void setCmdFamCode(String var1) {
      this.cmdFamCode = var1;
   }

   public String getCmdFamLibelleFr() {
      return this.cmdFamLibelleFr;
   }

   public void setCmdFamLibelleFr(String var1) {
      this.cmdFamLibelleFr = var1;
   }

   public String getCmdFamLibelleSp() {
      return this.cmdFamLibelleSp;
   }

   public void setCmdFamLibelleSp(String var1) {
      this.cmdFamLibelleSp = var1;
   }

   public String getCmdFamLibelleUk() {
      return this.cmdFamLibelleUk;
   }

   public void setCmdFamLibelleUk(String var1) {
      this.cmdFamLibelleUk = var1;
   }

   public long getCmdId() {
      return this.cmdId;
   }

   public void setCmdId(long var1) {
      this.cmdId = var1;
   }
}
