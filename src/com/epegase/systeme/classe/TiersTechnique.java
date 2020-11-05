package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class TiersTechnique implements Serializable {
   private long tietecId;
   private Date tietecDateCreat;
   private Date tietecDateModif;
   private long tietecUserCreat;
   private long tietecUserModif;
   private int tietecEtat;
   private int tietecType;
   private String tietecService;
   private String tietecLogin;
   private String tietecPw;
   private String tietecAdresse;
   private Tiers tiers;
   private String libelle;

   public String getLibelle() {
      if (this.tietecType == 0) {
         this.libelle = "Identification";
      }

      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public Date getTietecDateCreat() {
      return this.tietecDateCreat;
   }

   public void setTietecDateCreat(Date var1) {
      this.tietecDateCreat = var1;
   }

   public Date getTietecDateModif() {
      return this.tietecDateModif;
   }

   public void setTietecDateModif(Date var1) {
      this.tietecDateModif = var1;
   }

   public int getTietecEtat() {
      return this.tietecEtat;
   }

   public void setTietecEtat(int var1) {
      this.tietecEtat = var1;
   }

   public long getTietecId() {
      return this.tietecId;
   }

   public void setTietecId(long var1) {
      this.tietecId = var1;
   }

   public String getTietecLogin() {
      return this.tietecLogin;
   }

   public void setTietecLogin(String var1) {
      this.tietecLogin = var1;
   }

   public String getTietecPw() {
      return this.tietecPw;
   }

   public void setTietecPw(String var1) {
      this.tietecPw = var1;
   }

   public String getTietecService() {
      return this.tietecService;
   }

   public void setTietecService(String var1) {
      this.tietecService = var1;
   }

   public int getTietecType() {
      return this.tietecType;
   }

   public void setTietecType(int var1) {
      this.tietecType = var1;
   }

   public long getTietecUserCreat() {
      return this.tietecUserCreat;
   }

   public void setTietecUserCreat(long var1) {
      this.tietecUserCreat = var1;
   }

   public long getTietecUserModif() {
      return this.tietecUserModif;
   }

   public void setTietecUserModif(long var1) {
      this.tietecUserModif = var1;
   }

   public String getTietecAdresse() {
      return this.tietecAdresse;
   }

   public void setTietecAdresse(String var1) {
      this.tietecAdresse = var1;
   }
}
