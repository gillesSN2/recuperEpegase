package com.epegase.systeme.classe;

import java.io.Serializable;

public class Devise implements Serializable {
   private int devId;
   private String devCode;
   private String devLibelle;
   private String devFormat;
   private float devTaux1;
   private float devTaux2;
   private Structure structure;

   public String getDevCode() {
      return this.devCode;
   }

   public void setDevCode(String var1) {
      this.devCode = var1;
   }

   public Structure getStructure() {
      return this.structure;
   }

   public void setStructure(Structure var1) {
      this.structure = var1;
   }

   public int getDevId() {
      return this.devId;
   }

   public void setDevId(int var1) {
      this.devId = var1;
   }

   public String getDevFormat() {
      return this.devFormat;
   }

   public void setDevFormat(String var1) {
      this.devFormat = var1;
   }

   public String getDevLibelle() {
      return this.devLibelle;
   }

   public void setDevLibelle(String var1) {
      this.devLibelle = var1;
   }

   public float getDevTaux1() {
      return this.devTaux1;
   }

   public void setDevTaux1(float var1) {
      this.devTaux1 = var1;
   }

   public float getDevTaux2() {
      return this.devTaux2;
   }

   public void setDevTaux2(float var1) {
      this.devTaux2 = var1;
   }
}
