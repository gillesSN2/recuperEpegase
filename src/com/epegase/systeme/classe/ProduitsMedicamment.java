package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ProduitsMedicamment implements Serializable {
   private long promdcId;
   private long promdcUserCreation;
   private long promdcUserModif;
   private Date promdcDateCreation;
   private Date promdcDateModif;
   private String promdcCodeCip;
   private String promdcCodeCophase;
   private String promdcCodeDci;
   private String promdcDosage;
   private String promdcSpecialite;
   private String promdcForme;
   private String promdcClasse;
   private double promdcPrix;
   private String promdcListe;
   private String promdcLaboratoire;
   private String promdcDateMes;
   private int promdcType;
   private String promdcCodeCis;
   private String promdcCodeCip13;
   private String promdcAdmission;
   private String promdcUsage;

   public String getPromdcAdmission() {
      return this.promdcAdmission;
   }

   public void setPromdcAdmission(String var1) {
      this.promdcAdmission = var1;
   }

   public String getPromdcClasse() {
      return this.promdcClasse;
   }

   public void setPromdcClasse(String var1) {
      this.promdcClasse = var1;
   }

   public String getPromdcCodeCip() {
      return this.promdcCodeCip;
   }

   public void setPromdcCodeCip(String var1) {
      this.promdcCodeCip = var1;
   }

   public String getPromdcCodeCophase() {
      return this.promdcCodeCophase;
   }

   public void setPromdcCodeCophase(String var1) {
      this.promdcCodeCophase = var1;
   }

   public String getPromdcCodeDci() {
      return this.promdcCodeDci;
   }

   public void setPromdcCodeDci(String var1) {
      this.promdcCodeDci = var1;
   }

   public Date getPromdcDateCreation() {
      return this.promdcDateCreation;
   }

   public void setPromdcDateCreation(Date var1) {
      this.promdcDateCreation = var1;
   }

   public String getPromdcDateMes() {
      return this.promdcDateMes;
   }

   public void setPromdcDateMes(String var1) {
      this.promdcDateMes = var1;
   }

   public Date getPromdcDateModif() {
      return this.promdcDateModif;
   }

   public void setPromdcDateModif(Date var1) {
      this.promdcDateModif = var1;
   }

   public String getPromdcDosage() {
      return this.promdcDosage;
   }

   public void setPromdcDosage(String var1) {
      this.promdcDosage = var1;
   }

   public String getPromdcForme() {
      return this.promdcForme;
   }

   public void setPromdcForme(String var1) {
      this.promdcForme = var1;
   }

   public long getPromdcId() {
      return this.promdcId;
   }

   public void setPromdcId(long var1) {
      this.promdcId = var1;
   }

   public String getPromdcLaboratoire() {
      return this.promdcLaboratoire;
   }

   public void setPromdcLaboratoire(String var1) {
      this.promdcLaboratoire = var1;
   }

   public String getPromdcListe() {
      return this.promdcListe;
   }

   public void setPromdcListe(String var1) {
      this.promdcListe = var1;
   }

   public double getPromdcPrix() {
      return this.promdcPrix;
   }

   public void setPromdcPrix(double var1) {
      this.promdcPrix = var1;
   }

   public String getPromdcSpecialite() {
      return this.promdcSpecialite;
   }

   public void setPromdcSpecialite(String var1) {
      this.promdcSpecialite = var1;
   }

   public int getPromdcType() {
      return this.promdcType;
   }

   public void setPromdcType(int var1) {
      this.promdcType = var1;
   }

   public String getPromdcUsage() {
      return this.promdcUsage;
   }

   public void setPromdcUsage(String var1) {
      this.promdcUsage = var1;
   }

   public long getPromdcUserCreation() {
      return this.promdcUserCreation;
   }

   public void setPromdcUserCreation(long var1) {
      this.promdcUserCreation = var1;
   }

   public long getPromdcUserModif() {
      return this.promdcUserModif;
   }

   public void setPromdcUserModif(long var1) {
      this.promdcUserModif = var1;
   }

   public String getPromdcCodeCip13() {
      return this.promdcCodeCip13;
   }

   public void setPromdcCodeCip13(String var1) {
      this.promdcCodeCip13 = var1;
   }

   public String getPromdcCodeCis() {
      return this.promdcCodeCis;
   }

   public void setPromdcCodeCis(String var1) {
      this.promdcCodeCis = var1;
   }
}
