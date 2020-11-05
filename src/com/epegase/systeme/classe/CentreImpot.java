package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CentreImpot implements Serializable {
   private long cenimpId;
   private long cenimpUserCreation;
   private long cenimpUserModif;
   private Date cenimpDateCreation;
   private Date cenimpDateModif;
   private int cenimpType;
   private String cenimpCode;
   private String cenimpNom;
   private String cenimpAdresse;
   private String cenimpVille;
   private String cenimpBP;
   private String cenimpTel1;
   private String cenimpTel2;
   private String cenimpFax;
   private String cenimpMail;
   private String cenimpNomResponsable;
   private String cenimpNumeroImmatriculation;

   public String getCenimpAdresse() {
      return this.cenimpAdresse;
   }

   public void setCenimpAdresse(String var1) {
      this.cenimpAdresse = var1;
   }

   public String getCenimpBP() {
      return this.cenimpBP;
   }

   public void setCenimpBP(String var1) {
      this.cenimpBP = var1;
   }

   public String getCenimpCode() {
      return this.cenimpCode;
   }

   public void setCenimpCode(String var1) {
      this.cenimpCode = var1;
   }

   public Date getCenimpDateCreation() {
      return this.cenimpDateCreation;
   }

   public void setCenimpDateCreation(Date var1) {
      this.cenimpDateCreation = var1;
   }

   public Date getCenimpDateModif() {
      return this.cenimpDateModif;
   }

   public void setCenimpDateModif(Date var1) {
      this.cenimpDateModif = var1;
   }

   public String getCenimpFax() {
      return this.cenimpFax;
   }

   public void setCenimpFax(String var1) {
      this.cenimpFax = var1;
   }

   public long getCenimpId() {
      return this.cenimpId;
   }

   public void setCenimpId(long var1) {
      this.cenimpId = var1;
   }

   public String getCenimpMail() {
      return this.cenimpMail;
   }

   public void setCenimpMail(String var1) {
      this.cenimpMail = var1;
   }

   public String getCenimpNom() {
      return this.cenimpNom;
   }

   public void setCenimpNom(String var1) {
      this.cenimpNom = var1;
   }

   public String getCenimpNomResponsable() {
      return this.cenimpNomResponsable;
   }

   public void setCenimpNomResponsable(String var1) {
      this.cenimpNomResponsable = var1;
   }

   public String getCenimpNumeroImmatriculation() {
      return this.cenimpNumeroImmatriculation;
   }

   public void setCenimpNumeroImmatriculation(String var1) {
      this.cenimpNumeroImmatriculation = var1;
   }

   public String getCenimpTel1() {
      return this.cenimpTel1;
   }

   public void setCenimpTel1(String var1) {
      this.cenimpTel1 = var1;
   }

   public String getCenimpTel2() {
      return this.cenimpTel2;
   }

   public void setCenimpTel2(String var1) {
      this.cenimpTel2 = var1;
   }

   public long getCenimpUserCreation() {
      return this.cenimpUserCreation;
   }

   public void setCenimpUserCreation(long var1) {
      this.cenimpUserCreation = var1;
   }

   public long getCenimpUserModif() {
      return this.cenimpUserModif;
   }

   public void setCenimpUserModif(long var1) {
      this.cenimpUserModif = var1;
   }

   public String getCenimpVille() {
      return this.cenimpVille;
   }

   public void setCenimpVille(String var1) {
      this.cenimpVille = var1;
   }

   public int getCenimpType() {
      return this.cenimpType;
   }

   public void setCenimpType(int var1) {
      this.cenimpType = var1;
   }
}
