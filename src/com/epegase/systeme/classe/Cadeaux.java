package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Cadeaux implements Serializable {
   private long cadId;
   private Date cadDateCreat;
   private Date cadDateModif;
   private long cadIdCreateur;
   private String cadNomCreateur;
   private long cadIdModif;
   private String cadNomModif;
   private Date cadDate;
   private int cadEtat;
   private String cadCampagne;
   private int cadTypeTiers;
   private long cadIdTiers;
   private String cadNomTiers;
   private String cadCivilTiers;
   private long cadIdContact;
   private String cadNomContact;
   private String cadCivilContact;
   private long cadIdCommercial;
   private String cadNomCommercial;
   private long cadIdResponsable;
   private String cadNomResponsable;
   private String cadCode;
   private String cadFamille;
   private String cadLibelle;
   private String cadUnite;
   private String cadCondition;
   private int cadEchelle;
   private float cadQte;
   private float cadLong;
   private float cadLarg;
   private float cadHaut;
   private float cadDiam;
   private float cadNb;
   private float cadPoidsNet;
   private float cadPoidsBrut;
   private float cadVolume;
   private String cadDepot;
   private float cadQteUtil;
   private double cadPump;
   private String cadModele;
   private String libelleEtat;

   public String getLibelleEtat() {
      if (this.cadEtat == 0) {
         this.libelleEtat = "E.C.";
      } else if (this.cadEtat == 1) {
         this.libelleEtat = "Val.";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public String getCadCampagne() {
      return this.cadCampagne;
   }

   public void setCadCampagne(String var1) {
      this.cadCampagne = var1;
   }

   public String getCadCivilContact() {
      return this.cadCivilContact;
   }

   public void setCadCivilContact(String var1) {
      this.cadCivilContact = var1;
   }

   public String getCadCivilTiers() {
      return this.cadCivilTiers;
   }

   public void setCadCivilTiers(String var1) {
      this.cadCivilTiers = var1;
   }

   public String getCadCode() {
      return this.cadCode;
   }

   public void setCadCode(String var1) {
      this.cadCode = var1;
   }

   public String getCadCondition() {
      return this.cadCondition;
   }

   public void setCadCondition(String var1) {
      this.cadCondition = var1;
   }

   public Date getCadDate() {
      return this.cadDate;
   }

   public void setCadDate(Date var1) {
      this.cadDate = var1;
   }

   public String getCadDepot() {
      return this.cadDepot;
   }

   public void setCadDepot(String var1) {
      this.cadDepot = var1;
   }

   public float getCadDiam() {
      return this.cadDiam;
   }

   public void setCadDiam(float var1) {
      this.cadDiam = var1;
   }

   public int getCadEchelle() {
      return this.cadEchelle;
   }

   public void setCadEchelle(int var1) {
      this.cadEchelle = var1;
   }

   public String getCadFamille() {
      return this.cadFamille;
   }

   public void setCadFamille(String var1) {
      this.cadFamille = var1;
   }

   public float getCadHaut() {
      return this.cadHaut;
   }

   public void setCadHaut(float var1) {
      this.cadHaut = var1;
   }

   public long getCadId() {
      return this.cadId;
   }

   public void setCadId(long var1) {
      this.cadId = var1;
   }

   public long getCadIdCommercial() {
      return this.cadIdCommercial;
   }

   public void setCadIdCommercial(long var1) {
      this.cadIdCommercial = var1;
   }

   public long getCadIdContact() {
      return this.cadIdContact;
   }

   public void setCadIdContact(long var1) {
      this.cadIdContact = var1;
   }

   public long getCadIdTiers() {
      return this.cadIdTiers;
   }

   public void setCadIdTiers(long var1) {
      this.cadIdTiers = var1;
   }

   public float getCadLarg() {
      return this.cadLarg;
   }

   public void setCadLarg(float var1) {
      this.cadLarg = var1;
   }

   public String getCadLibelle() {
      return this.cadLibelle;
   }

   public void setCadLibelle(String var1) {
      this.cadLibelle = var1;
   }

   public float getCadLong() {
      return this.cadLong;
   }

   public void setCadLong(float var1) {
      this.cadLong = var1;
   }

   public float getCadNb() {
      return this.cadNb;
   }

   public void setCadNb(float var1) {
      this.cadNb = var1;
   }

   public String getCadNomCommercial() {
      return this.cadNomCommercial;
   }

   public void setCadNomCommercial(String var1) {
      this.cadNomCommercial = var1;
   }

   public String getCadNomContact() {
      return this.cadNomContact;
   }

   public void setCadNomContact(String var1) {
      this.cadNomContact = var1;
   }

   public String getCadNomTiers() {
      return this.cadNomTiers;
   }

   public void setCadNomTiers(String var1) {
      this.cadNomTiers = var1;
   }

   public float getCadPoidsBrut() {
      return this.cadPoidsBrut;
   }

   public void setCadPoidsBrut(float var1) {
      this.cadPoidsBrut = var1;
   }

   public float getCadPoidsNet() {
      return this.cadPoidsNet;
   }

   public void setCadPoidsNet(float var1) {
      this.cadPoidsNet = var1;
   }

   public double getCadPump() {
      return this.cadPump;
   }

   public void setCadPump(double var1) {
      this.cadPump = var1;
   }

   public float getCadQte() {
      return this.cadQte;
   }

   public void setCadQte(float var1) {
      this.cadQte = var1;
   }

   public float getCadQteUtil() {
      return this.cadQteUtil;
   }

   public void setCadQteUtil(float var1) {
      this.cadQteUtil = var1;
   }

   public String getCadUnite() {
      return this.cadUnite;
   }

   public void setCadUnite(String var1) {
      this.cadUnite = var1;
   }

   public float getCadVolume() {
      return this.cadVolume;
   }

   public void setCadVolume(float var1) {
      this.cadVolume = var1;
   }

   public Date getCadDateCreat() {
      return this.cadDateCreat;
   }

   public void setCadDateCreat(Date var1) {
      this.cadDateCreat = var1;
   }

   public Date getCadDateModif() {
      return this.cadDateModif;
   }

   public void setCadDateModif(Date var1) {
      this.cadDateModif = var1;
   }

   public long getCadIdCreateur() {
      return this.cadIdCreateur;
   }

   public void setCadIdCreateur(long var1) {
      this.cadIdCreateur = var1;
   }

   public long getCadIdModif() {
      return this.cadIdModif;
   }

   public void setCadIdModif(long var1) {
      this.cadIdModif = var1;
   }

   public long getCadIdResponsable() {
      return this.cadIdResponsable;
   }

   public void setCadIdResponsable(long var1) {
      this.cadIdResponsable = var1;
   }

   public String getCadNomCreateur() {
      return this.cadNomCreateur;
   }

   public void setCadNomCreateur(String var1) {
      this.cadNomCreateur = var1;
   }

   public String getCadNomModif() {
      return this.cadNomModif;
   }

   public void setCadNomModif(String var1) {
      this.cadNomModif = var1;
   }

   public String getCadNomResponsable() {
      return this.cadNomResponsable;
   }

   public void setCadNomResponsable(String var1) {
      this.cadNomResponsable = var1;
   }

   public int getCadTypeTiers() {
      return this.cadTypeTiers;
   }

   public void setCadTypeTiers(int var1) {
      this.cadTypeTiers = var1;
   }

   public String getCadModele() {
      return this.cadModele;
   }

   public void setCadModele(String var1) {
      this.cadModele = var1;
   }

   public int getCadEtat() {
      return this.cadEtat;
   }

   public void setCadEtat(int var1) {
      this.cadEtat = var1;
   }
}
