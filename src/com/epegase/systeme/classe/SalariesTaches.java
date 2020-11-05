package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class SalariesTaches implements Serializable {
   private long saltacId;
   private Date saltacDateCreat;
   private Date saltacDateModif;
   private long saltacUserCreat;
   private long saltacUserModif;
   private String saltacMission;
   private String saltacCode;
   private String saltacLib;
   private Integer saltacInactif;
   private float saltacValPr;
   private float saltacValPv;
   private Salaries salaries;

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public String getSaltacCode() {
      return this.saltacCode;
   }

   public void setSaltacCode(String var1) {
      this.saltacCode = var1;
   }

   public Date getSaltacDateCreat() {
      return this.saltacDateCreat;
   }

   public void setSaltacDateCreat(Date var1) {
      this.saltacDateCreat = var1;
   }

   public Date getSaltacDateModif() {
      return this.saltacDateModif;
   }

   public void setSaltacDateModif(Date var1) {
      this.saltacDateModif = var1;
   }

   public long getSaltacId() {
      return this.saltacId;
   }

   public void setSaltacId(long var1) {
      this.saltacId = var1;
   }

   public Integer getSaltacInactif() {
      return this.saltacInactif;
   }

   public void setSaltacInactif(Integer var1) {
      this.saltacInactif = var1;
   }

   public String getSaltacLib() {
      return this.saltacLib;
   }

   public void setSaltacLib(String var1) {
      this.saltacLib = var1;
   }

   public long getSaltacUserCreat() {
      return this.saltacUserCreat;
   }

   public void setSaltacUserCreat(long var1) {
      this.saltacUserCreat = var1;
   }

   public long getSaltacUserModif() {
      return this.saltacUserModif;
   }

   public void setSaltacUserModif(long var1) {
      this.saltacUserModif = var1;
   }

   public float getSaltacValPr() {
      return this.saltacValPr;
   }

   public void setSaltacValPr(float var1) {
      this.saltacValPr = var1;
   }

   public float getSaltacValPv() {
      return this.saltacValPv;
   }

   public void setSaltacValPv(float var1) {
      this.saltacValPv = var1;
   }

   public String getSaltacMission() {
      return this.saltacMission;
   }

   public void setSaltacMission(String var1) {
      this.saltacMission = var1;
   }
}
