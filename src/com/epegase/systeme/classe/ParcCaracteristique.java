package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ParcCaracteristique implements Serializable {
   private long prccarId;
   private Date prccarDateCreat;
   private Date prccarDateModif;
   private long prccarUserCreat;
   private long prccarUserModif;
   private int prccarType;
   private String prccarNature;
   private String prccarLibNature;
   private int prccarInactif;
   private int prccarOrgane;
   private String prccarLibelle;
   private Parc parc;
   private String libOrgane;

   public Parc getParc() {
      return this.parc;
   }

   public void setParc(Parc var1) {
      this.parc = var1;
   }

   public Date getPrccarDateCreat() {
      return this.prccarDateCreat;
   }

   public void setPrccarDateCreat(Date var1) {
      this.prccarDateCreat = var1;
   }

   public Date getPrccarDateModif() {
      return this.prccarDateModif;
   }

   public void setPrccarDateModif(Date var1) {
      this.prccarDateModif = var1;
   }

   public long getPrccarId() {
      return this.prccarId;
   }

   public void setPrccarId(long var1) {
      this.prccarId = var1;
   }

   public int getPrccarInactif() {
      return this.prccarInactif;
   }

   public void setPrccarInactif(int var1) {
      this.prccarInactif = var1;
   }

   public String getPrccarLibNature() {
      return this.prccarLibNature;
   }

   public void setPrccarLibNature(String var1) {
      this.prccarLibNature = var1;
   }

   public String getPrccarLibelle() {
      return this.prccarLibelle;
   }

   public void setPrccarLibelle(String var1) {
      this.prccarLibelle = var1;
   }

   public String getPrccarNature() {
      return this.prccarNature;
   }

   public void setPrccarNature(String var1) {
      this.prccarNature = var1;
   }

   public int getPrccarOrgane() {
      return this.prccarOrgane;
   }

   public void setPrccarOrgane(int var1) {
      this.prccarOrgane = var1;
   }

   public long getPrccarUserCreat() {
      return this.prccarUserCreat;
   }

   public void setPrccarUserCreat(long var1) {
      this.prccarUserCreat = var1;
   }

   public long getPrccarUserModif() {
      return this.prccarUserModif;
   }

   public void setPrccarUserModif(long var1) {
      this.prccarUserModif = var1;
   }

   public String getLibOrgane() {
      if (this.getPrccarOrgane() == 0) {
         this.libOrgane = "Organe";
      }

      if (this.getPrccarOrgane() == 1) {
         this.libOrgane = "Equipement";
      }

      if (this.getPrccarOrgane() == 2) {
         this.libOrgane = "Pneumatique";
      }

      if (this.getPrccarOrgane() == 3) {
         this.libOrgane = "Autre";
      }

      return this.libOrgane;
   }

   public void setLibOrgane(String var1) {
      this.libOrgane = var1;
   }

   public int getPrccarType() {
      return this.prccarType;
   }

   public void setPrccarType(int var1) {
      this.prccarType = var1;
   }
}
