package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ForetGrume implements Serializable {
   private long gruId;
   private String gruNumInv;
   private Date gruDateInv;
   private String gruArbre;
   private boolean gruPhoto;
   private String gruEcoCertifie;
   private String gruTrace;
   private String gruRfidInv;
   private String gruEssence;
   private String gruChantier;
   private String gruMarteau;
   private double gruLocX;
   private double gruLocY;
   private String gruClasInv;
   private int gruDiamBasInv;
   private int gruDiamHauInv;
   private int gruDiamMoyInv;
   private int gruLongInv;
   private float gruCubInv;
   private String gruNumCar;
   private Date gruDateCar;
   private String gruGrumeCar;
   private String gruClasCar;
   private int gruDiamCar;
   private int gruLongCar;
   private float gruCubCar;
   private Date gruDateAbattage;
   private Date gruDateEvac;
   private String gruDestCar;
   private String gruNumRup;
   private Date gruDateRup;
   private String gruLieuRup;
   private String gruGrumePlaq;
   private String gruRfidRup;
   private int gruDiamRup;
   private int gruLongRup;
   private float gruCubRup;
   private String gruObsRup;
   private String gruNumRou;
   private Date gruDateRou;
   private String gruLieuRou;
   private String gruClasRou;
   private int gruDiamRou;
   private int gruLongRou;
   private float gruCubRou;
   private int gruRefDiamRou;
   private int gruRefLongRou;
   private float gruRefCubRou;
   private String gruObsRou;
   private String gruNumExp;
   private Date gruDateExp;
   private String gruLieuExp;
   private int gruDiamExp;
   private int gruLongExp;
   private float gruCubExp;
   private String gruObsExp;
   private String gruNumNdc;
   private Date gruDateNdc;
   private int gruDiamNdc;
   private int gruLongNdc;
   private int gruRefDiamNdc;
   private int gruRefLongNdc;
   private float gruCubNdc;
   private float gruRefCubNdc;
   private double gruPaNdc;
   private String gruObsNdc;
   private String gruNumSpe;
   private Date gruDateSpe;
   private String gruLieuSpe;
   private int gruDiamSpe;
   private int gruLongSpe;
   private float gruCubSpe;
   private double gruPvSpe;
   private String gruObsSpe;
   private ForetInventaire foretInventaire;
   private ForetCarnet foretCarnet;
   private String styleLigne;
   private String photo;
   private String anneeInv;
   private String chemin;

   public String getChemin() {
      return this.chemin;
   }

   public void setChemin(String var1) {
      this.chemin = var1;
   }

   public String getAnneeInv() {
      if (this.gruDateInv != null) {
         this.anneeInv = "" + (this.gruDateInv.getYear() + 1900);
      } else {
         this.anneeInv = "";
      }

      return this.anneeInv;
   }

   public void setAnneeInv(String var1) {
      this.anneeInv = var1;
   }

   public String getPhoto() {
      if (this.gruArbre != null && !this.gruArbre.isEmpty()) {
         this.photo = this.gruChantier + ":" + this.gruEssence + ":" + this.gruArbre.replace("/", "_") + ".jpg";
      } else {
         this.photo = "";
      }

      return this.photo;
   }

   public void setPhoto(String var1) {
      this.photo = var1;
   }

   public String getStyleLigne() {
      this.styleLigne = "font-style:normal;";
      return this.styleLigne;
   }

   public void setStyleLigne(String var1) {
      this.styleLigne = var1;
   }

   public ForetInventaire getForetInventaire() {
      return this.foretInventaire;
   }

   public void setForetInventaire(ForetInventaire var1) {
      this.foretInventaire = var1;
   }

   public ForetCarnet getForetCarnet() {
      return this.foretCarnet;
   }

   public void setForetCarnet(ForetCarnet var1) {
      this.foretCarnet = var1;
   }

   public long getGruId() {
      return this.gruId;
   }

   public void setGruId(long var1) {
      this.gruId = var1;
   }

   public String getGruArbre() {
      return this.gruArbre;
   }

   public void setGruArbre(String var1) {
      this.gruArbre = var1;
   }

   public String getGruChantier() {
      return this.gruChantier;
   }

   public void setGruChantier(String var1) {
      this.gruChantier = var1;
   }

   public String getGruClasRou() {
      return this.gruClasRou;
   }

   public void setGruClasRou(String var1) {
      this.gruClasRou = var1;
   }

   public float getGruCubCar() {
      return this.gruCubCar;
   }

   public void setGruCubCar(float var1) {
      this.gruCubCar = var1;
   }

   public float getGruCubExp() {
      return this.gruCubExp;
   }

   public void setGruCubExp(float var1) {
      this.gruCubExp = var1;
   }

   public float getGruCubInv() {
      return this.gruCubInv;
   }

   public void setGruCubInv(float var1) {
      this.gruCubInv = var1;
   }

   public float getGruCubNdc() {
      return this.gruCubNdc;
   }

   public void setGruCubNdc(float var1) {
      this.gruCubNdc = var1;
   }

   public float getGruCubRou() {
      return this.gruCubRou;
   }

   public void setGruCubRou(float var1) {
      this.gruCubRou = var1;
   }

   public float getGruCubRup() {
      return this.gruCubRup;
   }

   public void setGruCubRup(float var1) {
      this.gruCubRup = var1;
   }

   public float getGruCubSpe() {
      return this.gruCubSpe;
   }

   public void setGruCubSpe(float var1) {
      this.gruCubSpe = var1;
   }

   public Date getGruDateAbattage() {
      return this.gruDateAbattage;
   }

   public void setGruDateAbattage(Date var1) {
      this.gruDateAbattage = var1;
   }

   public Date getGruDateCar() {
      return this.gruDateCar;
   }

   public void setGruDateCar(Date var1) {
      this.gruDateCar = var1;
   }

   public Date getGruDateEvac() {
      return this.gruDateEvac;
   }

   public void setGruDateEvac(Date var1) {
      this.gruDateEvac = var1;
   }

   public Date getGruDateExp() {
      return this.gruDateExp;
   }

   public void setGruDateExp(Date var1) {
      this.gruDateExp = var1;
   }

   public Date getGruDateInv() {
      return this.gruDateInv;
   }

   public void setGruDateInv(Date var1) {
      this.gruDateInv = var1;
   }

   public Date getGruDateNdc() {
      return this.gruDateNdc;
   }

   public void setGruDateNdc(Date var1) {
      this.gruDateNdc = var1;
   }

   public Date getGruDateRou() {
      return this.gruDateRou;
   }

   public void setGruDateRou(Date var1) {
      this.gruDateRou = var1;
   }

   public Date getGruDateRup() {
      return this.gruDateRup;
   }

   public void setGruDateRup(Date var1) {
      this.gruDateRup = var1;
   }

   public Date getGruDateSpe() {
      return this.gruDateSpe;
   }

   public void setGruDateSpe(Date var1) {
      this.gruDateSpe = var1;
   }

   public String getGruDestCar() {
      return this.gruDestCar;
   }

   public void setGruDestCar(String var1) {
      this.gruDestCar = var1;
   }

   public int getGruDiamBasInv() {
      return this.gruDiamBasInv;
   }

   public void setGruDiamBasInv(int var1) {
      this.gruDiamBasInv = var1;
   }

   public int getGruDiamCar() {
      return this.gruDiamCar;
   }

   public void setGruDiamCar(int var1) {
      this.gruDiamCar = var1;
   }

   public int getGruDiamExp() {
      return this.gruDiamExp;
   }

   public void setGruDiamExp(int var1) {
      this.gruDiamExp = var1;
   }

   public int getGruDiamHauInv() {
      return this.gruDiamHauInv;
   }

   public void setGruDiamHauInv(int var1) {
      this.gruDiamHauInv = var1;
   }

   public int getGruDiamMoyInv() {
      return this.gruDiamMoyInv;
   }

   public void setGruDiamMoyInv(int var1) {
      this.gruDiamMoyInv = var1;
   }

   public int getGruDiamNdc() {
      return this.gruDiamNdc;
   }

   public void setGruDiamNdc(int var1) {
      this.gruDiamNdc = var1;
   }

   public int getGruDiamRou() {
      return this.gruDiamRou;
   }

   public void setGruDiamRou(int var1) {
      this.gruDiamRou = var1;
   }

   public int getGruDiamRup() {
      return this.gruDiamRup;
   }

   public void setGruDiamRup(int var1) {
      this.gruDiamRup = var1;
   }

   public int getGruDiamSpe() {
      return this.gruDiamSpe;
   }

   public void setGruDiamSpe(int var1) {
      this.gruDiamSpe = var1;
   }

   public String getGruEcoCertifie() {
      return this.gruEcoCertifie;
   }

   public void setGruEcoCertifie(String var1) {
      this.gruEcoCertifie = var1;
   }

   public String getGruEssence() {
      return this.gruEssence;
   }

   public void setGruEssence(String var1) {
      this.gruEssence = var1;
   }

   public String getGruGrumeCar() {
      return this.gruGrumeCar;
   }

   public void setGruGrumeCar(String var1) {
      this.gruGrumeCar = var1;
   }

   public String getGruGrumePlaq() {
      return this.gruGrumePlaq;
   }

   public void setGruGrumePlaq(String var1) {
      this.gruGrumePlaq = var1;
   }

   public String getGruLieuExp() {
      return this.gruLieuExp;
   }

   public void setGruLieuExp(String var1) {
      this.gruLieuExp = var1;
   }

   public String getGruLieuRou() {
      return this.gruLieuRou;
   }

   public void setGruLieuRou(String var1) {
      this.gruLieuRou = var1;
   }

   public String getGruLieuRup() {
      return this.gruLieuRup;
   }

   public void setGruLieuRup(String var1) {
      this.gruLieuRup = var1;
   }

   public String getGruLieuSpe() {
      return this.gruLieuSpe;
   }

   public void setGruLieuSpe(String var1) {
      this.gruLieuSpe = var1;
   }

   public double getGruLocX() {
      return this.gruLocX;
   }

   public void setGruLocX(double var1) {
      this.gruLocX = var1;
   }

   public double getGruLocY() {
      return this.gruLocY;
   }

   public void setGruLocY(double var1) {
      this.gruLocY = var1;
   }

   public int getGruLongCar() {
      return this.gruLongCar;
   }

   public void setGruLongCar(int var1) {
      this.gruLongCar = var1;
   }

   public int getGruLongExp() {
      return this.gruLongExp;
   }

   public void setGruLongExp(int var1) {
      this.gruLongExp = var1;
   }

   public int getGruLongInv() {
      return this.gruLongInv;
   }

   public void setGruLongInv(int var1) {
      this.gruLongInv = var1;
   }

   public int getGruLongNdc() {
      return this.gruLongNdc;
   }

   public void setGruLongNdc(int var1) {
      this.gruLongNdc = var1;
   }

   public int getGruLongRou() {
      return this.gruLongRou;
   }

   public void setGruLongRou(int var1) {
      this.gruLongRou = var1;
   }

   public int getGruLongRup() {
      return this.gruLongRup;
   }

   public void setGruLongRup(int var1) {
      this.gruLongRup = var1;
   }

   public int getGruLongSpe() {
      return this.gruLongSpe;
   }

   public void setGruLongSpe(int var1) {
      this.gruLongSpe = var1;
   }

   public String getGruMarteau() {
      return this.gruMarteau;
   }

   public void setGruMarteau(String var1) {
      this.gruMarteau = var1;
   }

   public String getGruNumCar() {
      return this.gruNumCar;
   }

   public void setGruNumCar(String var1) {
      this.gruNumCar = var1;
   }

   public String getGruNumExp() {
      return this.gruNumExp;
   }

   public void setGruNumExp(String var1) {
      this.gruNumExp = var1;
   }

   public String getGruNumInv() {
      return this.gruNumInv;
   }

   public void setGruNumInv(String var1) {
      this.gruNumInv = var1;
   }

   public String getGruNumNdc() {
      return this.gruNumNdc;
   }

   public void setGruNumNdc(String var1) {
      this.gruNumNdc = var1;
   }

   public String getGruNumRou() {
      return this.gruNumRou;
   }

   public void setGruNumRou(String var1) {
      this.gruNumRou = var1;
   }

   public String getGruNumRup() {
      return this.gruNumRup;
   }

   public void setGruNumRup(String var1) {
      this.gruNumRup = var1;
   }

   public String getGruNumSpe() {
      return this.gruNumSpe;
   }

   public void setGruNumSpe(String var1) {
      this.gruNumSpe = var1;
   }

   public String getGruObsExp() {
      return this.gruObsExp;
   }

   public void setGruObsExp(String var1) {
      this.gruObsExp = var1;
   }

   public String getGruObsNdc() {
      return this.gruObsNdc;
   }

   public void setGruObsNdc(String var1) {
      this.gruObsNdc = var1;
   }

   public String getGruObsRou() {
      return this.gruObsRou;
   }

   public void setGruObsRou(String var1) {
      this.gruObsRou = var1;
   }

   public String getGruObsRup() {
      return this.gruObsRup;
   }

   public void setGruObsRup(String var1) {
      this.gruObsRup = var1;
   }

   public String getGruObsSpe() {
      return this.gruObsSpe;
   }

   public void setGruObsSpe(String var1) {
      this.gruObsSpe = var1;
   }

   public double getGruPaNdc() {
      return this.gruPaNdc;
   }

   public void setGruPaNdc(double var1) {
      this.gruPaNdc = var1;
   }

   public boolean isGruPhoto() {
      return this.gruPhoto;
   }

   public void setGruPhoto(boolean var1) {
      this.gruPhoto = var1;
   }

   public double getGruPvSpe() {
      return this.gruPvSpe;
   }

   public void setGruPvSpe(double var1) {
      this.gruPvSpe = var1;
   }

   public float getGruRefCubNdc() {
      return this.gruRefCubNdc;
   }

   public void setGruRefCubNdc(float var1) {
      this.gruRefCubNdc = var1;
   }

   public float getGruRefCubRou() {
      return this.gruRefCubRou;
   }

   public void setGruRefCubRou(float var1) {
      this.gruRefCubRou = var1;
   }

   public int getGruRefDiamNdc() {
      return this.gruRefDiamNdc;
   }

   public void setGruRefDiamNdc(int var1) {
      this.gruRefDiamNdc = var1;
   }

   public int getGruRefDiamRou() {
      return this.gruRefDiamRou;
   }

   public void setGruRefDiamRou(int var1) {
      this.gruRefDiamRou = var1;
   }

   public int getGruRefLongNdc() {
      return this.gruRefLongNdc;
   }

   public void setGruRefLongNdc(int var1) {
      this.gruRefLongNdc = var1;
   }

   public int getGruRefLongRou() {
      return this.gruRefLongRou;
   }

   public void setGruRefLongRou(int var1) {
      this.gruRefLongRou = var1;
   }

   public String getGruRfidInv() {
      return this.gruRfidInv;
   }

   public void setGruRfidInv(String var1) {
      this.gruRfidInv = var1;
   }

   public String getGruTrace() {
      return this.gruTrace;
   }

   public void setGruTrace(String var1) {
      this.gruTrace = var1;
   }

   public String getGruRfidRup() {
      return this.gruRfidRup;
   }

   public void setGruRfidRup(String var1) {
      this.gruRfidRup = var1;
   }

   public String getGruClasInv() {
      return this.gruClasInv;
   }

   public void setGruClasInv(String var1) {
      this.gruClasInv = var1;
   }

   public String getGruClasCar() {
      return this.gruClasCar;
   }

   public void setGruClasCar(String var1) {
      this.gruClasCar = var1;
   }
}
