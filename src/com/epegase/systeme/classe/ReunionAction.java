package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ReunionAction implements Serializable {
   private long reuactId;
   private String reuactNum;
   private long reuactIdUser;
   private String reuactNomUser;
   private String reuactPrenomUser;
   private String reuactCiviliteUser;
   private String reuactFonctionUser;
   private String reuactQuoi;
   private String reuactQuand;
   private Date reuactDate;
   private String reuactOu;
   private int reuactEtat;
   private Date reuactDateReport;
   private Date reuactDateExecution;
   private String reuactNumExecution;
   private String reuactObsExecution;
   private ReunionEntete reunionEntete;
   private String libelleEtat;

   public String getLibelleEtat() {
      if (this.reuactEtat == 0) {
         this.libelleEtat = "En cours";
      } else if (this.reuactEtat == 1) {
         this.libelleEtat = "Traité Succès";
      } else if (this.reuactEtat == 2) {
         this.libelleEtat = "Traité Echec";
      } else if (this.reuactEtat == 3) {
         this.libelleEtat = "Non Traité";
      } else if (this.reuactEtat == 4) {
         this.libelleEtat = "Repporté";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public ReunionEntete getReunionEntete() {
      return this.reunionEntete;
   }

   public void setReunionEntete(ReunionEntete var1) {
      this.reunionEntete = var1;
   }

   public String getReuactCiviliteUser() {
      return this.reuactCiviliteUser;
   }

   public void setReuactCiviliteUser(String var1) {
      this.reuactCiviliteUser = var1;
   }

   public Date getReuactDate() {
      return this.reuactDate;
   }

   public void setReuactDate(Date var1) {
      this.reuactDate = var1;
   }

   public Date getReuactDateReport() {
      return this.reuactDateReport;
   }

   public void setReuactDateReport(Date var1) {
      this.reuactDateReport = var1;
   }

   public int getReuactEtat() {
      return this.reuactEtat;
   }

   public void setReuactEtat(int var1) {
      this.reuactEtat = var1;
   }

   public long getReuactId() {
      return this.reuactId;
   }

   public void setReuactId(long var1) {
      this.reuactId = var1;
   }

   public long getReuactIdUser() {
      return this.reuactIdUser;
   }

   public void setReuactIdUser(long var1) {
      this.reuactIdUser = var1;
   }

   public String getReuactNomUser() {
      return this.reuactNomUser;
   }

   public void setReuactNomUser(String var1) {
      this.reuactNomUser = var1;
   }

   public String getReuactNum() {
      return this.reuactNum;
   }

   public void setReuactNum(String var1) {
      this.reuactNum = var1;
   }

   public String getReuactOu() {
      return this.reuactOu;
   }

   public void setReuactOu(String var1) {
      this.reuactOu = var1;
   }

   public String getReuactPrenomUser() {
      return this.reuactPrenomUser;
   }

   public void setReuactPrenomUser(String var1) {
      this.reuactPrenomUser = var1;
   }

   public String getReuactQuand() {
      return this.reuactQuand;
   }

   public void setReuactQuand(String var1) {
      this.reuactQuand = var1;
   }

   public String getReuactQuoi() {
      return this.reuactQuoi;
   }

   public void setReuactQuoi(String var1) {
      this.reuactQuoi = var1;
   }

   public String getReuactFonctionUser() {
      return this.reuactFonctionUser;
   }

   public void setReuactFonctionUser(String var1) {
      this.reuactFonctionUser = var1;
   }

   public Date getReuactDateExecution() {
      return this.reuactDateExecution;
   }

   public void setReuactDateExecution(Date var1) {
      this.reuactDateExecution = var1;
   }

   public String getReuactNumExecution() {
      return this.reuactNumExecution;
   }

   public void setReuactNumExecution(String var1) {
      this.reuactNumExecution = var1;
   }

   public String getReuactObsExecution() {
      return this.reuactObsExecution;
   }

   public void setReuactObsExecution(String var1) {
      this.reuactObsExecution = var1;
   }
}
