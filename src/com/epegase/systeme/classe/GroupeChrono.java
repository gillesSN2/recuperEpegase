package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class GroupeChrono implements Serializable {
   private long grpchrId;
   private Date grpchrDateCreat;
   private Date grpchrDateModif;
   private long grpchrUserCreat;
   private long grpchrUserModif;
   private String grpchrSerie;
   private String grpchrLib;
   private int grpchrNature;
   private int grpchrValidation;
   private int grpchrDeValidation;
   private int grpchrDupplication;
   private int grpchrUpdate;
   private int grpchrPrive;
   private Groupe groupe;
   private String lib_validation;
   private String lib_devalidation;
   private String lib_dupplication;
   private String lib_update;

   public String getLib_dupplication() {
      if (this.grpchrDupplication == 0) {
         this.lib_dupplication = "Interdit";
      } else if (this.grpchrDupplication == 1) {
         this.lib_dupplication = "Autorisé";
      }

      return this.lib_dupplication;
   }

   public void setLib_dupplication(String var1) {
      this.lib_dupplication = var1;
   }

   public String getLib_devalidation() {
      if (this.grpchrDeValidation == 0) {
         this.lib_devalidation = "Interdit";
      } else if (this.grpchrDeValidation == 1) {
         this.lib_devalidation = "Autorisé";
      }

      return this.lib_devalidation;
   }

   public void setLib_devalidation(String var1) {
      this.lib_devalidation = var1;
   }

   public String getLib_validation() {
      if (this.grpchrValidation == 0) {
         this.lib_validation = "Impression";
      } else if (this.grpchrValidation == 1) {
         this.lib_validation = "Enregistrement";
      } else if (this.grpchrValidation == 2) {
         this.lib_validation = "Bouton";
      }

      return this.lib_validation;
   }

   public void setLib_validation(String var1) {
      this.lib_validation = var1;
   }

   public String getLib_update() {
      if (this.grpchrUpdate == 0) {
         this.lib_update = "Autorisé";
      } else if (this.grpchrUpdate == 1) {
         this.lib_update = "Interdit";
      }

      return this.lib_update;
   }

   public void setLib_update(String var1) {
      this.lib_update = var1;
   }

   public Groupe getGroupe() {
      return this.groupe;
   }

   public void setGroupe(Groupe var1) {
      this.groupe = var1;
   }

   public Date getGrpchrDateCreat() {
      return this.grpchrDateCreat;
   }

   public void setGrpchrDateCreat(Date var1) {
      this.grpchrDateCreat = var1;
   }

   public Date getGrpchrDateModif() {
      return this.grpchrDateModif;
   }

   public void setGrpchrDateModif(Date var1) {
      this.grpchrDateModif = var1;
   }

   public int getGrpchrDeValidation() {
      return this.grpchrDeValidation;
   }

   public void setGrpchrDeValidation(int var1) {
      this.grpchrDeValidation = var1;
   }

   public int getGrpchrDupplication() {
      return this.grpchrDupplication;
   }

   public void setGrpchrDupplication(int var1) {
      this.grpchrDupplication = var1;
   }

   public long getGrpchrId() {
      return this.grpchrId;
   }

   public void setGrpchrId(long var1) {
      this.grpchrId = var1;
   }

   public String getGrpchrLib() {
      return this.grpchrLib;
   }

   public void setGrpchrLib(String var1) {
      this.grpchrLib = var1;
   }

   public int getGrpchrNature() {
      return this.grpchrNature;
   }

   public void setGrpchrNature(int var1) {
      this.grpchrNature = var1;
   }

   public int getGrpchrPrive() {
      return this.grpchrPrive;
   }

   public void setGrpchrPrive(int var1) {
      this.grpchrPrive = var1;
   }

   public String getGrpchrSerie() {
      return this.grpchrSerie;
   }

   public void setGrpchrSerie(String var1) {
      this.grpchrSerie = var1;
   }

   public int getGrpchrUpdate() {
      return this.grpchrUpdate;
   }

   public void setGrpchrUpdate(int var1) {
      this.grpchrUpdate = var1;
   }

   public long getGrpchrUserCreat() {
      return this.grpchrUserCreat;
   }

   public void setGrpchrUserCreat(long var1) {
      this.grpchrUserCreat = var1;
   }

   public long getGrpchrUserModif() {
      return this.grpchrUserModif;
   }

   public void setGrpchrUserModif(long var1) {
      this.grpchrUserModif = var1;
   }

   public int getGrpchrValidation() {
      return this.grpchrValidation;
   }

   public void setGrpchrValidation(int var1) {
      this.grpchrValidation = var1;
   }
}
