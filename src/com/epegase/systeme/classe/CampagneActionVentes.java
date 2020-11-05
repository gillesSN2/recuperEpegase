package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CampagneActionVentes implements Serializable {
   private long camactId;
   private Date camactDateCreat;
   private long camactIdCreateur;
   private String camactNomCreateur;
   private Date camactDateModif;
   private long camactIdModif;
   private String camactNomModif;
   private Date camactDate;
   private String camactCommentaire;
   private String camactAction;
   private Date camactDateFin;
   private int camactResultat;
   private Date camactDateReport;
   private String camactSuite;
   private String camactNomCommercial;
   private long camactIdCommercial;
   private CampagneEnteteVentes campagneEnteteVentes;
   private String libelleResultat;

   public CampagneEnteteVentes getCampagneEnteteVentes() {
      return this.campagneEnteteVentes;
   }

   public void setCampagneEnteteVentes(CampagneEnteteVentes var1) {
      this.campagneEnteteVentes = var1;
   }

   public String getLibelleResultat() {
      if (this.camactResultat == 0) {
         this.libelleResultat = "E.C.";
      } else if (this.camactResultat == 1) {
         this.libelleResultat = "Traitée";
      } else if (this.camactResultat == 2) {
         this.libelleResultat = "Non Traitée";
      } else if (this.camactResultat == 3) {
         this.libelleResultat = "Reportée";
      } else if (this.camactResultat == 4) {
         this.libelleResultat = "Annulée";
      }

      return this.libelleResultat;
   }

   public void setLibelleResultat(String var1) {
      this.libelleResultat = var1;
   }

   public String getCamactAction() {
      return this.camactAction;
   }

   public void setCamactAction(String var1) {
      this.camactAction = var1;
   }

   public String getCamactCommentaire() {
      return this.camactCommentaire;
   }

   public void setCamactCommentaire(String var1) {
      this.camactCommentaire = var1;
   }

   public Date getCamactDate() {
      return this.camactDate;
   }

   public void setCamactDate(Date var1) {
      this.camactDate = var1;
   }

   public Date getCamactDateCreat() {
      return this.camactDateCreat;
   }

   public void setCamactDateCreat(Date var1) {
      this.camactDateCreat = var1;
   }

   public Date getCamactDateFin() {
      return this.camactDateFin;
   }

   public void setCamactDateFin(Date var1) {
      this.camactDateFin = var1;
   }

   public Date getCamactDateModif() {
      return this.camactDateModif;
   }

   public void setCamactDateModif(Date var1) {
      this.camactDateModif = var1;
   }

   public Date getCamactDateReport() {
      return this.camactDateReport;
   }

   public void setCamactDateReport(Date var1) {
      this.camactDateReport = var1;
   }

   public long getCamactId() {
      return this.camactId;
   }

   public void setCamactId(long var1) {
      this.camactId = var1;
   }

   public long getCamactIdCreateur() {
      return this.camactIdCreateur;
   }

   public void setCamactIdCreateur(long var1) {
      this.camactIdCreateur = var1;
   }

   public long getCamactIdModif() {
      return this.camactIdModif;
   }

   public void setCamactIdModif(long var1) {
      this.camactIdModif = var1;
   }

   public String getCamactNomCreateur() {
      return this.camactNomCreateur;
   }

   public void setCamactNomCreateur(String var1) {
      this.camactNomCreateur = var1;
   }

   public String getCamactNomModif() {
      return this.camactNomModif;
   }

   public void setCamactNomModif(String var1) {
      this.camactNomModif = var1;
   }

   public int getCamactResultat() {
      return this.camactResultat;
   }

   public void setCamactResultat(int var1) {
      this.camactResultat = var1;
   }

   public String getCamactSuite() {
      return this.camactSuite;
   }

   public void setCamactSuite(String var1) {
      this.camactSuite = var1;
   }

   public long getCamactIdCommercial() {
      return this.camactIdCommercial;
   }

   public void setCamactIdCommercial(long var1) {
      this.camactIdCommercial = var1;
   }

   public String getCamactNomCommercial() {
      return this.camactNomCommercial;
   }

   public void setCamactNomCommercial(String var1) {
      this.camactNomCommercial = var1;
   }
}
