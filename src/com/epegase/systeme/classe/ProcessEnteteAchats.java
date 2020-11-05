package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ProcessEnteteAchats implements Serializable {
   private long procesId;
   private Date procesDateCreat;
   private Date procesDateModif;
   private long procesUserCreat;
   private long procesUserModif;
   private int procesMode;
   private int procesOption1;
   private int procesOption2;
   private String procesCode;
   private String procesLibClient;
   private String procesLibTech;
   private String procesDepot;
   private int procesStock;
   private String procesUnite;
   private String procesCondition;
   private int procesEchelle;
   private float procesCoef;
   private String procesSite;
   private String procesLigne;
   private String procesAtelier;
   private String procesService;
   private String procesActivite;
   private double procesTotPump;
   private int procesInactif;
   private int procesCreationLot;
   private String procesMethode;
   private String procesPiege;
   private String procesSuffixe;
   private boolean selectProcess;
   private String modeStock;
   private String libelleCreationLot;

   public String getLibelleCreationLot() {
      if (this.procesCreationLot == 1) {
         this.libelleCreationLot = "Création Lot";
      } else {
         this.libelleCreationLot = "";
      }

      return this.libelleCreationLot;
   }

   public void setLibelleCreationLot(String var1) {
      this.libelleCreationLot = var1;
   }

   public String getModeStock() {
      if (this.procesStock == 0) {
         this.modeStock = "Sans";
      } else if (this.procesStock == 1) {
         this.modeStock = "Simple";
      } else if (this.procesStock == 2) {
         this.modeStock = "LIFO (lot)";
      } else if (this.procesStock == 3) {
         this.modeStock = "FIFO (lot)";
      } else if (this.procesStock == 4) {
         this.modeStock = "Péremption (lot)";
      } else if (this.procesStock == 5) {
         this.modeStock = "Sérialisé";
      }

      return this.modeStock;
   }

   public void setModeStock(String var1) {
      this.modeStock = var1;
   }

   public boolean isSelectProcess() {
      return this.selectProcess;
   }

   public void setSelectProcess(boolean var1) {
      this.selectProcess = var1;
   }

   public String getProcesCode() {
      return this.procesCode;
   }

   public void setProcesCode(String var1) {
      this.procesCode = var1;
   }

   public Date getProcesDateCreat() {
      return this.procesDateCreat;
   }

   public void setProcesDateCreat(Date var1) {
      this.procesDateCreat = var1;
   }

   public Date getProcesDateModif() {
      return this.procesDateModif;
   }

   public void setProcesDateModif(Date var1) {
      this.procesDateModif = var1;
   }

   public long getProcesId() {
      return this.procesId;
   }

   public void setProcesId(long var1) {
      this.procesId = var1;
   }

   public String getProcesLibClient() {
      return this.procesLibClient;
   }

   public void setProcesLibClient(String var1) {
      this.procesLibClient = var1;
   }

   public String getProcesLibTech() {
      return this.procesLibTech;
   }

   public void setProcesLibTech(String var1) {
      this.procesLibTech = var1;
   }

   public long getProcesUserCreat() {
      return this.procesUserCreat;
   }

   public void setProcesUserCreat(long var1) {
      this.procesUserCreat = var1;
   }

   public long getProcesUserModif() {
      return this.procesUserModif;
   }

   public void setProcesUserModif(long var1) {
      this.procesUserModif = var1;
   }

   public String getProcesAtelier() {
      return this.procesAtelier;
   }

   public void setProcesAtelier(String var1) {
      this.procesAtelier = var1;
   }

   public float getProcesCoef() {
      return this.procesCoef;
   }

   public void setProcesCoef(float var1) {
      this.procesCoef = var1;
   }

   public String getProcesDepot() {
      return this.procesDepot;
   }

   public void setProcesDepot(String var1) {
      this.procesDepot = var1;
   }

   public String getProcesLigne() {
      return this.procesLigne;
   }

   public void setProcesLigne(String var1) {
      this.procesLigne = var1;
   }

   public String getProcesSite() {
      return this.procesSite;
   }

   public void setProcesSite(String var1) {
      this.procesSite = var1;
   }

   public String getProcesUnite() {
      return this.procesUnite;
   }

   public void setProcesUnite(String var1) {
      this.procesUnite = var1;
   }

   public int getProcesInactif() {
      return this.procesInactif;
   }

   public void setProcesInactif(int var1) {
      this.procesInactif = var1;
   }

   public String getProcesActivite() {
      return this.procesActivite;
   }

   public void setProcesActivite(String var1) {
      this.procesActivite = var1;
   }

   public double getProcesTotPump() {
      return this.procesTotPump;
   }

   public void setProcesTotPump(double var1) {
      this.procesTotPump = var1;
   }

   public int getProcesMode() {
      return this.procesMode;
   }

   public void setProcesMode(int var1) {
      this.procesMode = var1;
   }

   public int getProcesOption1() {
      return this.procesOption1;
   }

   public void setProcesOption1(int var1) {
      this.procesOption1 = var1;
   }

   public String getProcesMethode() {
      return this.procesMethode;
   }

   public void setProcesMethode(String var1) {
      this.procesMethode = var1;
   }

   public String getProcesPiege() {
      return this.procesPiege;
   }

   public void setProcesPiege(String var1) {
      this.procesPiege = var1;
   }

   public String getProcesService() {
      return this.procesService;
   }

   public void setProcesService(String var1) {
      this.procesService = var1;
   }

   public int getProcesStock() {
      return this.procesStock;
   }

   public void setProcesStock(int var1) {
      this.procesStock = var1;
   }

   public int getProcesCreationLot() {
      return this.procesCreationLot;
   }

   public void setProcesCreationLot(int var1) {
      this.procesCreationLot = var1;
   }

   public String getProcesCondition() {
      return this.procesCondition;
   }

   public void setProcesCondition(String var1) {
      this.procesCondition = var1;
   }

   public int getProcesEchelle() {
      return this.procesEchelle;
   }

   public void setProcesEchelle(int var1) {
      this.procesEchelle = var1;
   }

   public String getProcesSuffixe() {
      return this.procesSuffixe;
   }

   public void setProcesSuffixe(String var1) {
      this.procesSuffixe = var1;
   }

   public int getProcesOption2() {
      return this.procesOption2;
   }

   public void setProcesOption2(int var1) {
      this.procesOption2 = var1;
   }
}
