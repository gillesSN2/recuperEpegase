package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ContratEcheanceVentes implements Serializable {
   private long crtechId;
   private Date crtechDateTheo;
   private double crtechMontantTheo;
   private Date crtechDateReel;
   private double crtechMontantReel;
   private int crtechMode;
   private String crtechCaisse;
   private String crtechLibelle;
   private long crtechIdCaissier;
   private String crtechNomCaissier;
   private ContratEnteteVentes contratEnteteVentes;

   public ContratEnteteVentes getContratEnteteVentes() {
      return this.contratEnteteVentes;
   }

   public void setContratEnteteVentes(ContratEnteteVentes var1) {
      this.contratEnteteVentes = var1;
   }

   public String getCrtechCaisse() {
      return this.crtechCaisse;
   }

   public void setCrtechCaisse(String var1) {
      this.crtechCaisse = var1;
   }

   public Date getCrtechDateReel() {
      return this.crtechDateReel;
   }

   public void setCrtechDateReel(Date var1) {
      this.crtechDateReel = var1;
   }

   public Date getCrtechDateTheo() {
      return this.crtechDateTheo;
   }

   public void setCrtechDateTheo(Date var1) {
      this.crtechDateTheo = var1;
   }

   public long getCrtechId() {
      return this.crtechId;
   }

   public void setCrtechId(long var1) {
      this.crtechId = var1;
   }

   public long getCrtechIdCaissier() {
      return this.crtechIdCaissier;
   }

   public void setCrtechIdCaissier(long var1) {
      this.crtechIdCaissier = var1;
   }

   public String getCrtechLibelle() {
      return this.crtechLibelle;
   }

   public void setCrtechLibelle(String var1) {
      this.crtechLibelle = var1;
   }

   public int getCrtechMode() {
      return this.crtechMode;
   }

   public void setCrtechMode(int var1) {
      this.crtechMode = var1;
   }

   public double getCrtechMontantReel() {
      return this.crtechMontantReel;
   }

   public void setCrtechMontantReel(double var1) {
      this.crtechMontantReel = var1;
   }

   public double getCrtechMontantTheo() {
      return this.crtechMontantTheo;
   }

   public void setCrtechMontantTheo(double var1) {
      this.crtechMontantTheo = var1;
   }

   public String getCrtechNomCaissier() {
      return this.crtechNomCaissier;
   }

   public void setCrtechNomCaissier(String var1) {
      this.crtechNomCaissier = var1;
   }
}
