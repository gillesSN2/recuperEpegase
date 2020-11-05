package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class SommierEnteteAchats implements Serializable {
   private long somId;
   private Date somDateCreat;
   private Date somDateModif;
   private long somIdCreateur;
   private String somNomCreateur;
   private long somIdModif;
   private String somNomModif;
   private Date somDate;
   private Date somDateExpiration;
   private Date somDateProrogation;
   private String somNum;
   private int somType;
   private String somNomResponsable;
   private long somIdResponsable;
   private String somDossierTransit;
   private String somReception;
   private String somCession;
   private Date somDateImp;
   private String somModeleImp;
   private int somEtat;
   private String somRegime;
   private String somNomTiers;
   private ExercicesAchats exercicesAchats;
   private Users users;
   private String libelleEta;
   private String libelleType;

   public String getLibelleEta() {
      if (this.somEtat == 0) {
         this.libelleEta = "En cours";
      } else if (this.somEtat == 1) {
         this.libelleEta = "Cloturé";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getLibelleType() {
      if (this.somType == 0) {
         this.libelleType = "Entrée";
      } else {
         this.libelleType = "Sortie";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public Date getSomDate() {
      return this.somDate;
   }

   public void setSomDate(Date var1) {
      this.somDate = var1;
   }

   public Date getSomDateCreat() {
      return this.somDateCreat;
   }

   public void setSomDateCreat(Date var1) {
      this.somDateCreat = var1;
   }

   public Date getSomDateImp() {
      return this.somDateImp;
   }

   public void setSomDateImp(Date var1) {
      this.somDateImp = var1;
   }

   public Date getSomDateModif() {
      return this.somDateModif;
   }

   public void setSomDateModif(Date var1) {
      this.somDateModif = var1;
   }

   public String getSomDossierTransit() {
      return this.somDossierTransit;
   }

   public void setSomDossierTransit(String var1) {
      this.somDossierTransit = var1;
   }

   public int getSomEtat() {
      return this.somEtat;
   }

   public void setSomEtat(int var1) {
      this.somEtat = var1;
   }

   public long getSomId() {
      return this.somId;
   }

   public void setSomId(long var1) {
      this.somId = var1;
   }

   public long getSomIdCreateur() {
      return this.somIdCreateur;
   }

   public void setSomIdCreateur(long var1) {
      this.somIdCreateur = var1;
   }

   public long getSomIdModif() {
      return this.somIdModif;
   }

   public void setSomIdModif(long var1) {
      this.somIdModif = var1;
   }

   public long getSomIdResponsable() {
      return this.somIdResponsable;
   }

   public void setSomIdResponsable(long var1) {
      this.somIdResponsable = var1;
   }

   public String getSomModeleImp() {
      return this.somModeleImp;
   }

   public void setSomModeleImp(String var1) {
      this.somModeleImp = var1;
   }

   public String getSomNomCreateur() {
      return this.somNomCreateur;
   }

   public void setSomNomCreateur(String var1) {
      this.somNomCreateur = var1;
   }

   public String getSomNomModif() {
      return this.somNomModif;
   }

   public void setSomNomModif(String var1) {
      this.somNomModif = var1;
   }

   public String getSomNomResponsable() {
      return this.somNomResponsable;
   }

   public void setSomNomResponsable(String var1) {
      this.somNomResponsable = var1;
   }

   public String getSomNum() {
      return this.somNum;
   }

   public void setSomNum(String var1) {
      this.somNum = var1;
   }

   public String getSomReception() {
      return this.somReception;
   }

   public void setSomReception(String var1) {
      this.somReception = var1;
   }

   public int getSomType() {
      return this.somType;
   }

   public void setSomType(int var1) {
      this.somType = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public String getSomCession() {
      return this.somCession;
   }

   public void setSomCession(String var1) {
      this.somCession = var1;
   }

   public String getSomNomTiers() {
      return this.somNomTiers;
   }

   public void setSomNomTiers(String var1) {
      this.somNomTiers = var1;
   }

   public String getSomRegime() {
      return this.somRegime;
   }

   public void setSomRegime(String var1) {
      this.somRegime = var1;
   }

   public Date getSomDateExpiration() {
      return this.somDateExpiration;
   }

   public void setSomDateExpiration(Date var1) {
      this.somDateExpiration = var1;
   }

   public Date getSomDateProrogation() {
      return this.somDateProrogation;
   }

   public void setSomDateProrogation(Date var1) {
      this.somDateProrogation = var1;
   }
}
