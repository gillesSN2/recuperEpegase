package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CertificationDocument implements Serializable {
   private long cerId;
   private Date cerDateCreat;
   private long cerUserCreat;
   private int cerNature;
   private String cerNum;
   private String cerNomRapport;
   private int cerQte;
   private int cerTypeTiers;
   private Users users;
   private String libelleNature;

   public String getLibelleNature() {
      return this.libelleNature;
   }

   public void setLibelleNature(String var1) {
      this.libelleNature = var1;
   }

   public String getCerNomRapport() {
      return this.cerNomRapport;
   }

   public void setCerNomRapport(String var1) {
      this.cerNomRapport = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public Date getCerDateCreat() {
      return this.cerDateCreat;
   }

   public void setCerDateCreat(Date var1) {
      this.cerDateCreat = var1;
   }

   public long getCerId() {
      return this.cerId;
   }

   public void setCerId(long var1) {
      this.cerId = var1;
   }

   public int getCerNature() {
      return this.cerNature;
   }

   public void setCerNature(int var1) {
      this.cerNature = var1;
   }

   public String getCerNum() {
      return this.cerNum;
   }

   public void setCerNum(String var1) {
      this.cerNum = var1;
   }

   public long getCerUserCreat() {
      return this.cerUserCreat;
   }

   public void setCerUserCreat(long var1) {
      this.cerUserCreat = var1;
   }

   public int getCerQte() {
      return this.cerQte;
   }

   public void setCerQte(int var1) {
      this.cerQte = var1;
   }

   public int getCerTypeTiers() {
      return this.cerTypeTiers;
   }

   public void setCerTypeTiers(int var1) {
      this.cerTypeTiers = var1;
   }
}
