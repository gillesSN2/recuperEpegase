package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Baremes implements Serializable {
   private long barId;
   private Date barDateCreat;
   private Date barDateModif;
   private long barUserCreat;
   private long barUserModif;
   private String barCode;
   private String barNomFr;
   private String barNomUk;
   private String barNomSp;
   private int barInactif;
   private int barOptions;
   private int barType;
   private long barIdTiers;
   private long barIdMedecin;
   private String barNomTiers;
   private String barCategorieTiers;
   private int barOrdreTarif;
   private String barCodeProduit;
   private String barLibelleProduit;
   private String barCodeVte;
   private String barLibelleVte;
   private Date barDateDebut;
   private Date barDateFin;
   private float barRemise;
   private double barRabais;
   private double barPrix;
   private boolean afficheImag;
   private String etat;
   private String libOptions;

   public String getEtat() {
      if (this.barInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.barInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.barInactif != 1 && this.barInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getLibOptions() {
      if (this.barOptions == 0) {
         this.libOptions = "Tiers";
      } else if (this.barOptions == 1) {
         this.libOptions = "Produit";
      }

      return this.libOptions;
   }

   public void setLibOptions(String var1) {
      this.libOptions = var1;
   }

   public String getBarCode() {
      return this.barCode;
   }

   public void setBarCode(String var1) {
      this.barCode = var1;
   }

   public String getBarCodeProduit() {
      return this.barCodeProduit;
   }

   public void setBarCodeProduit(String var1) {
      this.barCodeProduit = var1;
   }

   public String getBarCodeVte() {
      return this.barCodeVte;
   }

   public void setBarCodeVte(String var1) {
      this.barCodeVte = var1;
   }

   public Date getBarDateCreat() {
      return this.barDateCreat;
   }

   public void setBarDateCreat(Date var1) {
      this.barDateCreat = var1;
   }

   public Date getBarDateDebut() {
      return this.barDateDebut;
   }

   public void setBarDateDebut(Date var1) {
      this.barDateDebut = var1;
   }

   public Date getBarDateFin() {
      return this.barDateFin;
   }

   public void setBarDateFin(Date var1) {
      this.barDateFin = var1;
   }

   public Date getBarDateModif() {
      return this.barDateModif;
   }

   public void setBarDateModif(Date var1) {
      this.barDateModif = var1;
   }

   public long getBarId() {
      return this.barId;
   }

   public void setBarId(long var1) {
      this.barId = var1;
   }

   public long getBarIdTiers() {
      return this.barIdTiers;
   }

   public void setBarIdTiers(long var1) {
      this.barIdTiers = var1;
   }

   public int getBarInactif() {
      return this.barInactif;
   }

   public void setBarInactif(int var1) {
      this.barInactif = var1;
   }

   public String getBarLibelleProduit() {
      return this.barLibelleProduit;
   }

   public void setBarLibelleProduit(String var1) {
      this.barLibelleProduit = var1;
   }

   public String getBarLibelleVte() {
      return this.barLibelleVte;
   }

   public void setBarLibelleVte(String var1) {
      this.barLibelleVte = var1;
   }

   public String getBarNomFr() {
      return this.barNomFr;
   }

   public void setBarNomFr(String var1) {
      this.barNomFr = var1;
   }

   public String getBarNomSp() {
      return this.barNomSp;
   }

   public void setBarNomSp(String var1) {
      this.barNomSp = var1;
   }

   public String getBarNomTiers() {
      return this.barNomTiers;
   }

   public void setBarNomTiers(String var1) {
      this.barNomTiers = var1;
   }

   public String getBarNomUk() {
      return this.barNomUk;
   }

   public void setBarNomUk(String var1) {
      this.barNomUk = var1;
   }

   public int getBarOptions() {
      return this.barOptions;
   }

   public void setBarOptions(int var1) {
      this.barOptions = var1;
   }

   public double getBarPrix() {
      return this.barPrix;
   }

   public void setBarPrix(double var1) {
      this.barPrix = var1;
   }

   public double getBarRabais() {
      return this.barRabais;
   }

   public void setBarRabais(double var1) {
      this.barRabais = var1;
   }

   public float getBarRemise() {
      return this.barRemise;
   }

   public void setBarRemise(float var1) {
      this.barRemise = var1;
   }

   public long getBarUserCreat() {
      return this.barUserCreat;
   }

   public void setBarUserCreat(long var1) {
      this.barUserCreat = var1;
   }

   public long getBarUserModif() {
      return this.barUserModif;
   }

   public void setBarUserModif(long var1) {
      this.barUserModif = var1;
   }

   public int getBarType() {
      return this.barType;
   }

   public void setBarType(int var1) {
      this.barType = var1;
   }

   public long getBarIdMedecin() {
      return this.barIdMedecin;
   }

   public void setBarIdMedecin(long var1) {
      this.barIdMedecin = var1;
   }

   public String getBarCategorieTiers() {
      return this.barCategorieTiers;
   }

   public void setBarCategorieTiers(String var1) {
      this.barCategorieTiers = var1;
   }

   public int getBarOrdreTarif() {
      return this.barOrdreTarif;
   }

   public void setBarOrdreTarif(int var1) {
      this.barOrdreTarif = var1;
   }
}
