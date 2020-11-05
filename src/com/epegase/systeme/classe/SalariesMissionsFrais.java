package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class SalariesMissionsFrais implements Serializable {
   private long salmisfraId;
   private Date salmisfraDate;
   private String salmisfraObjet;
   private int salmisfraMode;
   private int salmisfraType;
   private String salmisfraReference;
   private String salmisfraFournisseur;
   private double salmisfraCout;
   private Missions missions;
   private Salaries salaries;
   private String lib_mode;
   private String lib_type;

   public String getLib_mode() {
      if (this.salmisfraMode == 0) {
         this.lib_mode = "Préparation";
      } else if (this.salmisfraMode == 1) {
         this.lib_mode = "Retour";
      }

      return this.lib_mode;
   }

   public void setLib_mode(String var1) {
      this.lib_mode = var1;
   }

   public String getLib_type() {
      if (this.salmisfraType == 0) {
         this.lib_type = "Transport";
      } else if (this.salmisfraType == 1) {
         this.lib_type = "Hébergement";
      } else if (this.salmisfraType == 2) {
         this.lib_type = "Restauration";
      } else if (this.salmisfraType == 3) {
         this.lib_type = "Divers";
      }

      return this.lib_type;
   }

   public void setLib_type(String var1) {
      this.lib_type = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public Missions getMissions() {
      return this.missions;
   }

   public void setMissions(Missions var1) {
      this.missions = var1;
   }

   public double getSalmisfraCout() {
      return this.salmisfraCout;
   }

   public void setSalmisfraCout(double var1) {
      this.salmisfraCout = var1;
   }

   public Date getSalmisfraDate() {
      return this.salmisfraDate;
   }

   public void setSalmisfraDate(Date var1) {
      this.salmisfraDate = var1;
   }

   public String getSalmisfraFournisseur() {
      return this.salmisfraFournisseur;
   }

   public void setSalmisfraFournisseur(String var1) {
      this.salmisfraFournisseur = var1;
   }

   public long getSalmisfraId() {
      return this.salmisfraId;
   }

   public void setSalmisfraId(long var1) {
      this.salmisfraId = var1;
   }

   public int getSalmisfraMode() {
      return this.salmisfraMode;
   }

   public void setSalmisfraMode(int var1) {
      this.salmisfraMode = var1;
   }

   public String getSalmisfraObjet() {
      return this.salmisfraObjet;
   }

   public void setSalmisfraObjet(String var1) {
      this.salmisfraObjet = var1;
   }

   public String getSalmisfraReference() {
      return this.salmisfraReference;
   }

   public void setSalmisfraReference(String var1) {
      this.salmisfraReference = var1;
   }

   public int getSalmisfraType() {
      return this.salmisfraType;
   }

   public void setSalmisfraType(int var1) {
      this.salmisfraType = var1;
   }
}
