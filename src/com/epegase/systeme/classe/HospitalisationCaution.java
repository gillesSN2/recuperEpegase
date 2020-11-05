package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class HospitalisationCaution implements Serializable {
   private long hoscauId;
   private long hoscauIdSejour;
   private double hoscauMontant;
   private int hoscauEtat;
   private Date hoscauDate;
   private String hoscauCaisse;
   private long hoscauIdRecu;
   private String hoscauNumRecu;
   private long hoscauIdBonEncaissement;
   private String hoscauService;
   private HospitalisationEntete hospitalisationEntete;

   public String getHoscauCaisse() {
      return this.hoscauCaisse;
   }

   public void setHoscauCaisse(String var1) {
      this.hoscauCaisse = var1;
   }

   public Date getHoscauDate() {
      return this.hoscauDate;
   }

   public void setHoscauDate(Date var1) {
      this.hoscauDate = var1;
   }

   public int getHoscauEtat() {
      return this.hoscauEtat;
   }

   public void setHoscauEtat(int var1) {
      this.hoscauEtat = var1;
   }

   public long getHoscauId() {
      return this.hoscauId;
   }

   public void setHoscauId(long var1) {
      this.hoscauId = var1;
   }

   public long getHoscauIdBonEncaissement() {
      return this.hoscauIdBonEncaissement;
   }

   public void setHoscauIdBonEncaissement(long var1) {
      this.hoscauIdBonEncaissement = var1;
   }

   public long getHoscauIdRecu() {
      return this.hoscauIdRecu;
   }

   public void setHoscauIdRecu(long var1) {
      this.hoscauIdRecu = var1;
   }

   public long getHoscauIdSejour() {
      return this.hoscauIdSejour;
   }

   public void setHoscauIdSejour(long var1) {
      this.hoscauIdSejour = var1;
   }

   public double getHoscauMontant() {
      return this.hoscauMontant;
   }

   public void setHoscauMontant(double var1) {
      this.hoscauMontant = var1;
   }

   public String getHoscauNumRecu() {
      return this.hoscauNumRecu;
   }

   public void setHoscauNumRecu(String var1) {
      this.hoscauNumRecu = var1;
   }

   public HospitalisationEntete getHospitalisationEntete() {
      return this.hospitalisationEntete;
   }

   public void setHospitalisationEntete(HospitalisationEntete var1) {
      this.hospitalisationEntete = var1;
   }

   public String getHoscauService() {
      return this.hoscauService;
   }

   public void setHoscauService(String var1) {
      this.hoscauService = var1;
   }
}
