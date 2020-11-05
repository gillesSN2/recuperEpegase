package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Responsable implements Serializable {
   private long rpbid;
   private Date rpbdatecreat;
   private Date rpbdatemodif;
   private long rpbusercreat;
   private long rpbusermodif;
   private int rpbetat;
   private long rpbuserid;
   private String rpbnom;
   private String rpbprenom;
   private String rpbcategorie;
   private String rpbcivilite;
   private Date rpbdatedebut;
   private Date rpbdatefin;
   private int rpbdefaut;
   private Tiers tiers;

   public String getRpbcategorie() {
      return this.rpbcategorie;
   }

   public void setRpbcategorie(String var1) {
      this.rpbcategorie = var1;
   }

   public String getRpbcivilite() {
      return this.rpbcivilite;
   }

   public void setRpbcivilite(String var1) {
      this.rpbcivilite = var1;
   }

   public Date getRpbdatecreat() {
      return this.rpbdatecreat;
   }

   public void setRpbdatecreat(Date var1) {
      this.rpbdatecreat = var1;
   }

   public Date getRpbdatedebut() {
      return this.rpbdatedebut;
   }

   public void setRpbdatedebut(Date var1) {
      this.rpbdatedebut = var1;
   }

   public Date getRpbdatefin() {
      return this.rpbdatefin;
   }

   public void setRpbdatefin(Date var1) {
      this.rpbdatefin = var1;
   }

   public Date getRpbdatemodif() {
      return this.rpbdatemodif;
   }

   public void setRpbdatemodif(Date var1) {
      this.rpbdatemodif = var1;
   }

   public int getRpbetat() {
      return this.rpbetat;
   }

   public void setRpbetat(int var1) {
      this.rpbetat = var1;
   }

   public long getRpbid() {
      return this.rpbid;
   }

   public void setRpbid(long var1) {
      this.rpbid = var1;
   }

   public String getRpbnom() {
      return this.rpbnom;
   }

   public void setRpbnom(String var1) {
      this.rpbnom = var1;
   }

   public String getRpbprenom() {
      return this.rpbprenom;
   }

   public void setRpbprenom(String var1) {
      this.rpbprenom = var1;
   }

   public long getRpbusercreat() {
      return this.rpbusercreat;
   }

   public void setRpbusercreat(long var1) {
      this.rpbusercreat = var1;
   }

   public long getRpbuserid() {
      return this.rpbuserid;
   }

   public void setRpbuserid(long var1) {
      this.rpbuserid = var1;
   }

   public long getRpbusermodif() {
      return this.rpbusermodif;
   }

   public void setRpbusermodif(long var1) {
      this.rpbusermodif = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public int getRpbdefaut() {
      return this.rpbdefaut;
   }

   public void setRpbdefaut(int var1) {
      this.rpbdefaut = var1;
   }
}
