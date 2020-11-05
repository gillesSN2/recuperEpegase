package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BienHistorique implements Serializable {
   private long biehisId;
   private Date biehisDateCreat;
   private Date biehisDateModif;
   private long biehisUserCreat;
   private long biehisUserModif;
   private Date biehisDateVente;
   private double biehisMontant;
   private String biehisEtude;
   private String biehisNomNotaire;
   private String biehisCivilNotaire;
   private long biehisIdOldProprietaire;
   private String biehisOldProprietaire;
   private String biehisNomOldProprietaire;
   private String biehisCivilOldProprietaire;
   private long biehisIdNewProprietaire;
   private String biehisNewProprietaire;
   private String biehisNomNewProprietaire;
   private String biehisCivilNewProprietaire;
   private String biehisSacnActeVente;
   private Bien bien;
   private Tiers tiers;

   public Bien getBien() {
      return this.bien;
   }

   public void setBien(Bien var1) {
      this.bien = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public long getBiehisId() {
      return this.biehisId;
   }

   public void setBiehisId(long var1) {
      this.biehisId = var1;
   }

   public String getBiehisEtude() {
      return this.biehisEtude;
   }

   public void setBiehisEtude(String var1) {
      this.biehisEtude = var1;
   }

   public String getBiehisCivilNotaire() {
      return this.biehisCivilNotaire;
   }

   public void setBiehisCivilNotaire(String var1) {
      this.biehisCivilNotaire = var1;
   }

   public Date getBiehisDateCreat() {
      return this.biehisDateCreat;
   }

   public void setBiehisDateCreat(Date var1) {
      this.biehisDateCreat = var1;
   }

   public Date getBiehisDateModif() {
      return this.biehisDateModif;
   }

   public void setBiehisDateModif(Date var1) {
      this.biehisDateModif = var1;
   }

   public Date getBiehisDateVente() {
      return this.biehisDateVente;
   }

   public void setBiehisDateVente(Date var1) {
      this.biehisDateVente = var1;
   }

   public double getBiehisMontant() {
      return this.biehisMontant;
   }

   public void setBiehisMontant(double var1) {
      this.biehisMontant = var1;
   }

   public String getBiehisNomNotaire() {
      return this.biehisNomNotaire;
   }

   public void setBiehisNomNotaire(String var1) {
      this.biehisNomNotaire = var1;
   }

   public String getBiehisSacnActeVente() {
      return this.biehisSacnActeVente;
   }

   public void setBiehisSacnActeVente(String var1) {
      this.biehisSacnActeVente = var1;
   }

   public long getBiehisUserCreat() {
      return this.biehisUserCreat;
   }

   public void setBiehisUserCreat(long var1) {
      this.biehisUserCreat = var1;
   }

   public long getBiehisUserModif() {
      return this.biehisUserModif;
   }

   public void setBiehisUserModif(long var1) {
      this.biehisUserModif = var1;
   }

   public String getBiehisCivilOldProprietaire() {
      return this.biehisCivilOldProprietaire;
   }

   public void setBiehisCivilOldProprietaire(String var1) {
      this.biehisCivilOldProprietaire = var1;
   }

   public long getBiehisIdOldProprietaire() {
      return this.biehisIdOldProprietaire;
   }

   public void setBiehisIdOldProprietaire(long var1) {
      this.biehisIdOldProprietaire = var1;
   }

   public String getBiehisNomOldProprietaire() {
      return this.biehisNomOldProprietaire;
   }

   public void setBiehisNomOldProprietaire(String var1) {
      this.biehisNomOldProprietaire = var1;
   }

   public String getBiehisOldProprietaire() {
      return this.biehisOldProprietaire;
   }

   public void setBiehisOldProprietaire(String var1) {
      this.biehisOldProprietaire = var1;
   }

   public String getBiehisCivilNewProprietaire() {
      return this.biehisCivilNewProprietaire;
   }

   public void setBiehisCivilNewProprietaire(String var1) {
      this.biehisCivilNewProprietaire = var1;
   }

   public long getBiehisIdNewProprietaire() {
      return this.biehisIdNewProprietaire;
   }

   public void setBiehisIdNewProprietaire(long var1) {
      this.biehisIdNewProprietaire = var1;
   }

   public String getBiehisNewProprietaire() {
      return this.biehisNewProprietaire;
   }

   public void setBiehisNewProprietaire(String var1) {
      this.biehisNewProprietaire = var1;
   }

   public String getBiehisNomNewProprietaire() {
      return this.biehisNomNewProprietaire;
   }

   public void setBiehisNomNewProprietaire(String var1) {
      this.biehisNomNewProprietaire = var1;
   }
}
