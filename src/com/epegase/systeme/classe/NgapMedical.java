package com.epegase.systeme.classe;

import java.io.Serializable;

public class NgapMedical implements Serializable {
   private long ngaId;
   private String ngaFamCode;
   private String ngaFamLibelleFr;
   private String ngaFamLibelleUk;
   private String ngaFamLibelleSp;
   private String ngaDetCode;
   private String ngaDetLibelleFr;
   private String ngaDetLibelleUk;
   private String ngaDetLibelleSp;
   private int ngaDetType;

   public String getNgaDetCode() {
      return this.ngaDetCode;
   }

   public void setNgaDetCode(String var1) {
      this.ngaDetCode = var1;
   }

   public String getNgaDetLibelleFr() {
      return this.ngaDetLibelleFr;
   }

   public void setNgaDetLibelleFr(String var1) {
      this.ngaDetLibelleFr = var1;
   }

   public String getNgaDetLibelleSp() {
      return this.ngaDetLibelleSp;
   }

   public void setNgaDetLibelleSp(String var1) {
      this.ngaDetLibelleSp = var1;
   }

   public String getNgaDetLibelleUk() {
      return this.ngaDetLibelleUk;
   }

   public void setNgaDetLibelleUk(String var1) {
      this.ngaDetLibelleUk = var1;
   }

   public int getNgaDetType() {
      return this.ngaDetType;
   }

   public void setNgaDetType(int var1) {
      this.ngaDetType = var1;
   }

   public String getNgaFamCode() {
      return this.ngaFamCode;
   }

   public void setNgaFamCode(String var1) {
      this.ngaFamCode = var1;
   }

   public String getNgaFamLibelleFr() {
      return this.ngaFamLibelleFr;
   }

   public void setNgaFamLibelleFr(String var1) {
      this.ngaFamLibelleFr = var1;
   }

   public String getNgaFamLibelleSp() {
      return this.ngaFamLibelleSp;
   }

   public void setNgaFamLibelleSp(String var1) {
      this.ngaFamLibelleSp = var1;
   }

   public String getNgaFamLibelleUk() {
      return this.ngaFamLibelleUk;
   }

   public void setNgaFamLibelleUk(String var1) {
      this.ngaFamLibelleUk = var1;
   }

   public long getNgaId() {
      return this.ngaId;
   }

   public void setNgaId(long var1) {
      this.ngaId = var1;
   }
}
