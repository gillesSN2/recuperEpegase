package com.epegase.systeme.control;

import java.io.Serializable;

public class ObjetTempsFactures implements Serializable {
   private String mission;
   private String client;
   private float duree;
   private double pr;
   private double pv;
   private double totalFacture;

   public String getClient() {
      return this.client;
   }

   public void setClient(String var1) {
      this.client = var1;
   }

   public float getDuree() {
      return this.duree;
   }

   public void setDuree(float var1) {
      this.duree = var1;
   }

   public String getMission() {
      return this.mission;
   }

   public void setMission(String var1) {
      this.mission = var1;
   }

   public double getPr() {
      return this.pr;
   }

   public void setPr(double var1) {
      this.pr = var1;
   }

   public double getPv() {
      return this.pv;
   }

   public void setPv(double var1) {
      this.pv = var1;
   }

   public double getTotalFacture() {
      return this.totalFacture;
   }

   public void setTotalFacture(double var1) {
      this.totalFacture = var1;
   }
}
