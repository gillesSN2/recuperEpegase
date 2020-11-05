package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class AmortissementInv implements Serializable {
   private Long amoinvId;
   private Date amoinvDateCreat;
   private Date amoinvDateModif;
   private long amoinvUserCreat;
   private long amoinvUserModif;
   private int amoinvEtat;
   private String amoinvObs;
   private String amoinvPhoto;
   private double amoinvLongitude;
   private double amoinvLatitude;
   private Amortissements amortissements;
   private String libelleEtat;
   private String libelleAgent;

   public String getLibelleAgent() {
      return this.libelleAgent;
   }

   public void setLibelleAgent(String var1) {
      this.libelleAgent = var1;
   }

   public String getLibelleEtat() {
      if (this.amoinvEtat == 0) {
         this.libelleEtat = "OK";
      } else if (this.amoinvEtat == 1) {
         this.libelleEtat = "Abimé";
      } else if (this.amoinvEtat == 2) {
         this.libelleEtat = "H.S.";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public Date getAmoinvDateCreat() {
      return this.amoinvDateCreat;
   }

   public void setAmoinvDateCreat(Date var1) {
      this.amoinvDateCreat = var1;
   }

   public Date getAmoinvDateModif() {
      return this.amoinvDateModif;
   }

   public void setAmoinvDateModif(Date var1) {
      this.amoinvDateModif = var1;
   }

   public int getAmoinvEtat() {
      return this.amoinvEtat;
   }

   public void setAmoinvEtat(int var1) {
      this.amoinvEtat = var1;
   }

   public Long getAmoinvId() {
      return this.amoinvId;
   }

   public void setAmoinvId(Long var1) {
      this.amoinvId = var1;
   }

   public String getAmoinvObs() {
      return this.amoinvObs;
   }

   public void setAmoinvObs(String var1) {
      this.amoinvObs = var1;
   }

   public String getAmoinvPhoto() {
      return this.amoinvPhoto;
   }

   public void setAmoinvPhoto(String var1) {
      this.amoinvPhoto = var1;
   }

   public long getAmoinvUserCreat() {
      return this.amoinvUserCreat;
   }

   public void setAmoinvUserCreat(long var1) {
      this.amoinvUserCreat = var1;
   }

   public long getAmoinvUserModif() {
      return this.amoinvUserModif;
   }

   public void setAmoinvUserModif(long var1) {
      this.amoinvUserModif = var1;
   }

   public Amortissements getAmortissements() {
      return this.amortissements;
   }

   public void setAmortissements(Amortissements var1) {
      this.amortissements = var1;
   }

   public double getAmoinvLatitude() {
      return this.amoinvLatitude;
   }

   public void setAmoinvLatitude(double var1) {
      this.amoinvLatitude = var1;
   }

   public double getAmoinvLongitude() {
      return this.amoinvLongitude;
   }

   public void setAmoinvLongitude(double var1) {
      this.amoinvLongitude = var1;
   }
}
