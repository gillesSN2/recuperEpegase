package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ChargementLigne implements Serializable {
   private long chaligId;
   private long chaligIdBes;
   private long chaligIdBcm;
   private int chaligOrdre;
   private String chaligCode;
   private String chaligFamille;
   private String chaligLibelle;
   private int chaligGenerique;
   private String chaligReference;
   private String chaligTaxe;
   private float chaligTauxTaxe;
   private String chaligUnite;
   private String chaligCondition;
   private String chaligDescription;
   private String chaligCasier;
   private int chaligStock;
   private float chaligQteDem;
   private String chaligDepotCharg;
   private float chaligQteCharg;
   private double chaligPu;
   private double chaligPuTtc;
   private float chaligTauxRemise;
   private double chaligRabais;
   private double chaligPuRem;
   private double chaligPuRemTtc;
   private double chaligPt;
   private double chaligTva;
   private double chaligTc;
   private double chaligTtc;
   private double chaligPump;
   private int chaligEchelle;
   private float chaligQteFacture;
   private float chaligQteDon;
   private float chaligQteAvoir;
   private float chaligQteRetour;
   private float chaligQteRamene;
   private float chaligQteNconforme;
   private float chaligQteDefectueux;
   private float chaligQtePerime;
   private float chaligQteManquant;
   private float chaligQteReprise;
   private float chaligQteEcart;
   private float chaligQteUtil;
   private float chaligLong;
   private float chaligLarg;
   private float chaligHaut;
   private float chaligDiam;
   private float chaligNb;
   private float chaligPoidsNet;
   private float chaligPoidsBrut;
   private float chaligVolume;
   private Date chaligDateChargement;
   private int chaligRechargement;
   private int chaligNombreRechargement;
   private ChargementEntete chargementEntete;
   private String var_lib_uni_condit;
   private boolean var_generique;

   public String getVar_lib_uni_condit() {
      if (this.chaligCondition != null && !this.chaligCondition.isEmpty() && this.chaligCondition.contains(":")) {
         if (this.chaligDescription != null && !this.chaligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.chaligDescription;
         } else if (this.chaligCondition.contains("/")) {
            String[] var1 = this.chaligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.chaligCondition;
         }
      } else if (this.chaligCondition != null && !this.chaligCondition.isEmpty() && !this.chaligCondition.contains(":")) {
         this.var_lib_uni_condit = "";
      } else if (this.chaligUnite != null && !this.chaligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.chaligUnite;
      } else {
         this.var_lib_uni_condit = "";
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public boolean isVar_generique() {
      if (this.chaligGenerique == 5) {
         this.var_generique = true;
      } else {
         this.var_generique = false;
      }

      return this.var_generique;
   }

   public void setVar_generique(boolean var1) {
      this.var_generique = var1;
   }

   public String getChaligCasier() {
      return this.chaligCasier;
   }

   public void setChaligCasier(String var1) {
      this.chaligCasier = var1;
   }

   public String getChaligCode() {
      return this.chaligCode;
   }

   public void setChaligCode(String var1) {
      this.chaligCode = var1;
   }

   public String getChaligDepotCharg() {
      return this.chaligDepotCharg;
   }

   public void setChaligDepotCharg(String var1) {
      this.chaligDepotCharg = var1;
   }

   public String getChaligFamille() {
      return this.chaligFamille;
   }

   public void setChaligFamille(String var1) {
      this.chaligFamille = var1;
   }

   public String getChaligLibelle() {
      return this.chaligLibelle;
   }

   public void setChaligLibelle(String var1) {
      this.chaligLibelle = var1;
   }

   public double getChaligPump() {
      return this.chaligPump;
   }

   public void setChaligPump(double var1) {
      this.chaligPump = var1;
   }

   public float getChaligQteAvoir() {
      return this.chaligQteAvoir;
   }

   public void setChaligQteAvoir(float var1) {
      this.chaligQteAvoir = var1;
   }

   public float getChaligQteCharg() {
      return this.chaligQteCharg;
   }

   public void setChaligQteCharg(float var1) {
      this.chaligQteCharg = var1;
   }

   public float getChaligQteDon() {
      return this.chaligQteDon;
   }

   public void setChaligQteDon(float var1) {
      this.chaligQteDon = var1;
   }

   public float getChaligQteEcart() {
      return this.chaligQteEcart;
   }

   public void setChaligQteEcart(float var1) {
      this.chaligQteEcart = var1;
   }

   public float getChaligQteManquant() {
      return this.chaligQteManquant;
   }

   public void setChaligQteManquant(float var1) {
      this.chaligQteManquant = var1;
   }

   public float getChaligQteNconforme() {
      return this.chaligQteNconforme;
   }

   public void setChaligQteNconforme(float var1) {
      this.chaligQteNconforme = var1;
   }

   public float getChaligQtePerime() {
      return this.chaligQtePerime;
   }

   public void setChaligQtePerime(float var1) {
      this.chaligQtePerime = var1;
   }

   public String getChaligReference() {
      return this.chaligReference;
   }

   public void setChaligReference(String var1) {
      this.chaligReference = var1;
   }

   public float getChaligTauxTaxe() {
      return this.chaligTauxTaxe;
   }

   public void setChaligTauxTaxe(float var1) {
      this.chaligTauxTaxe = var1;
   }

   public String getChaligTaxe() {
      return this.chaligTaxe;
   }

   public void setChaligTaxe(String var1) {
      this.chaligTaxe = var1;
   }

   public String getChaligUnite() {
      return this.chaligUnite;
   }

   public void setChaligUnite(String var1) {
      this.chaligUnite = var1;
   }

   public long getChaligId() {
      return this.chaligId;
   }

   public void setChaligId(long var1) {
      this.chaligId = var1;
   }

   public ChargementEntete getChargementEntete() {
      return this.chargementEntete;
   }

   public void setChargementEntete(ChargementEntete var1) {
      this.chargementEntete = var1;
   }

   public double getChaligPt() {
      return this.chaligPt;
   }

   public void setChaligPt(double var1) {
      this.chaligPt = var1;
   }

   public double getChaligPu() {
      return this.chaligPu;
   }

   public void setChaligPu(double var1) {
      this.chaligPu = var1;
   }

   public double getChaligPuRem() {
      return this.chaligPuRem;
   }

   public void setChaligPuRem(double var1) {
      this.chaligPuRem = var1;
   }

   public double getChaligPuRemTtc() {
      return this.chaligPuRemTtc;
   }

   public void setChaligPuRemTtc(double var1) {
      this.chaligPuRemTtc = var1;
   }

   public double getChaligPuTtc() {
      return this.chaligPuTtc;
   }

   public void setChaligPuTtc(double var1) {
      this.chaligPuTtc = var1;
   }

   public double getChaligRabais() {
      return this.chaligRabais;
   }

   public void setChaligRabais(double var1) {
      this.chaligRabais = var1;
   }

   public float getChaligTauxRemise() {
      return this.chaligTauxRemise;
   }

   public void setChaligTauxRemise(float var1) {
      this.chaligTauxRemise = var1;
   }

   public double getChaligTc() {
      return this.chaligTc;
   }

   public void setChaligTc(double var1) {
      this.chaligTc = var1;
   }

   public double getChaligTtc() {
      return this.chaligTtc;
   }

   public void setChaligTtc(double var1) {
      this.chaligTtc = var1;
   }

   public double getChaligTva() {
      return this.chaligTva;
   }

   public void setChaligTva(double var1) {
      this.chaligTva = var1;
   }

   public String getChaligCondition() {
      return this.chaligCondition;
   }

   public void setChaligCondition(String var1) {
      this.chaligCondition = var1;
   }

   public float getChaligDiam() {
      return this.chaligDiam;
   }

   public void setChaligDiam(float var1) {
      this.chaligDiam = var1;
   }

   public float getChaligHaut() {
      return this.chaligHaut;
   }

   public void setChaligHaut(float var1) {
      this.chaligHaut = var1;
   }

   public float getChaligLarg() {
      return this.chaligLarg;
   }

   public void setChaligLarg(float var1) {
      this.chaligLarg = var1;
   }

   public float getChaligLong() {
      return this.chaligLong;
   }

   public void setChaligLong(float var1) {
      this.chaligLong = var1;
   }

   public float getChaligNb() {
      return this.chaligNb;
   }

   public void setChaligNb(float var1) {
      this.chaligNb = var1;
   }

   public float getChaligPoidsBrut() {
      return this.chaligPoidsBrut;
   }

   public void setChaligPoidsBrut(float var1) {
      this.chaligPoidsBrut = var1;
   }

   public float getChaligPoidsNet() {
      return this.chaligPoidsNet;
   }

   public void setChaligPoidsNet(float var1) {
      this.chaligPoidsNet = var1;
   }

   public float getChaligQteUtil() {
      return this.chaligQteUtil;
   }

   public void setChaligQteUtil(float var1) {
      this.chaligQteUtil = var1;
   }

   public float getChaligVolume() {
      return this.chaligVolume;
   }

   public void setChaligVolume(float var1) {
      this.chaligVolume = var1;
   }

   public int getChaligStock() {
      return this.chaligStock;
   }

   public void setChaligStock(int var1) {
      this.chaligStock = var1;
   }

   public String getChaligDescription() {
      return this.chaligDescription;
   }

   public void setChaligDescription(String var1) {
      this.chaligDescription = var1;
   }

   public Date getChaligDateChargement() {
      return this.chaligDateChargement;
   }

   public void setChaligDateChargement(Date var1) {
      this.chaligDateChargement = var1;
   }

   public int getChaligRechargement() {
      return this.chaligRechargement;
   }

   public void setChaligRechargement(int var1) {
      this.chaligRechargement = var1;
   }

   public int getChaligEchelle() {
      return this.chaligEchelle;
   }

   public void setChaligEchelle(int var1) {
      this.chaligEchelle = var1;
   }

   public float getChaligQteDefectueux() {
      return this.chaligQteDefectueux;
   }

   public void setChaligQteDefectueux(float var1) {
      this.chaligQteDefectueux = var1;
   }

   public float getChaligQteFacture() {
      return this.chaligQteFacture;
   }

   public void setChaligQteFacture(float var1) {
      this.chaligQteFacture = var1;
   }

   public float getChaligQteReprise() {
      return this.chaligQteReprise;
   }

   public void setChaligQteReprise(float var1) {
      this.chaligQteReprise = var1;
   }

   public float getChaligQteRetour() {
      return this.chaligQteRetour;
   }

   public void setChaligQteRetour(float var1) {
      this.chaligQteRetour = var1;
   }

   public long getChaligIdBes() {
      return this.chaligIdBes;
   }

   public void setChaligIdBes(long var1) {
      this.chaligIdBes = var1;
   }

   public long getChaligIdBcm() {
      return this.chaligIdBcm;
   }

   public void setChaligIdBcm(long var1) {
      this.chaligIdBcm = var1;
   }

   public int getChaligGenerique() {
      return this.chaligGenerique;
   }

   public void setChaligGenerique(int var1) {
      this.chaligGenerique = var1;
   }

   public float getChaligQteDem() {
      return this.chaligQteDem;
   }

   public void setChaligQteDem(float var1) {
      this.chaligQteDem = var1;
   }

   public int getChaligOrdre() {
      return this.chaligOrdre;
   }

   public void setChaligOrdre(int var1) {
      this.chaligOrdre = var1;
   }

   public float getChaligQteRamene() {
      return this.chaligQteRamene;
   }

   public void setChaligQteRamene(float var1) {
      this.chaligQteRamene = var1;
   }

   public int getChaligNombreRechargement() {
      return this.chaligNombreRechargement;
   }

   public void setChaligNombreRechargement(int var1) {
      this.chaligNombreRechargement = var1;
   }
}
