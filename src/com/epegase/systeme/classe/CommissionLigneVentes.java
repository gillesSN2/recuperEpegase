package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CommissionLigneVentes implements Serializable {
   private long comligId;
   private Date comligDate;
   private Date comligDateLastReg;
   private long comligNbJour;
   private String comligNum;
   private int comligNature;
   private String comligNomResponsable;
   private long comligIdResponsable;
   private String comligNomCommercial;
   private long comligIdCommercial;
   private String comligNomEquipe;
   private long comligIdEquipe;
   private String comligNomTiers;
   private long comligIdTiers;
   private String comligCivilTiers;
   private long comligIdContact;
   private String comligNomContact;
   private String comligCivilContact;
   private String comligSerie;
   private String comligCat;
   private String comligDevise;
   private long comligIdligne;
   private String comligService;
   private String comligCode;
   private String comligLibelle;
   private float comligQte;
   private double comligTotHt;
   private double comligComUnite;
   private float comligComPourcentage;
   private double comligTotCommission;
   private double comligTotCommissionReel;
   private double comligPayePatient;
   private double comligPayeTier;
   private double comligTotVerse;
   private long comligIdRecu;
   private CommissionEnteteVentes commissionEnteteVentes;
   private double dejaPaye;
   private double payePatient;
   private double payeTiers;
   private boolean select;
   private String numStat;

   public double getPayePatient() {
      return this.payePatient;
   }

   public void setPayePatient(double var1) {
      this.payePatient = var1;
   }

   public double getPayeTiers() {
      return this.payeTiers;
   }

   public void setPayeTiers(double var1) {
      this.payeTiers = var1;
   }

   public String getNumStat() {
      return this.numStat;
   }

   public void setNumStat(String var1) {
      this.numStat = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public CommissionEnteteVentes getCommissionEnteteVentes() {
      return this.commissionEnteteVentes;
   }

   public void setCommissionEnteteVentes(CommissionEnteteVentes var1) {
      this.commissionEnteteVentes = var1;
   }

   public double getDejaPaye() {
      return this.dejaPaye;
   }

   public void setDejaPaye(double var1) {
      this.dejaPaye = var1;
   }

   public String getComligCat() {
      return this.comligCat;
   }

   public void setComligCat(String var1) {
      this.comligCat = var1;
   }

   public String getComligCivilContact() {
      return this.comligCivilContact;
   }

   public void setComligCivilContact(String var1) {
      this.comligCivilContact = var1;
   }

   public String getComligCivilTiers() {
      return this.comligCivilTiers;
   }

   public void setComligCivilTiers(String var1) {
      this.comligCivilTiers = var1;
   }

   public String getComligCode() {
      return this.comligCode;
   }

   public void setComligCode(String var1) {
      this.comligCode = var1;
   }

   public float getComligComPourcentage() {
      return this.comligComPourcentage;
   }

   public void setComligComPourcentage(float var1) {
      this.comligComPourcentage = var1;
   }

   public double getComligComUnite() {
      return this.comligComUnite;
   }

   public void setComligComUnite(double var1) {
      this.comligComUnite = var1;
   }

   public Date getComligDate() {
      return this.comligDate;
   }

   public void setComligDate(Date var1) {
      this.comligDate = var1;
   }

   public String getComligDevise() {
      return this.comligDevise;
   }

   public void setComligDevise(String var1) {
      this.comligDevise = var1;
   }

   public long getComligIdCommercial() {
      return this.comligIdCommercial;
   }

   public void setComligIdCommercial(long var1) {
      this.comligIdCommercial = var1;
   }

   public long getComligIdContact() {
      return this.comligIdContact;
   }

   public void setComligIdContact(long var1) {
      this.comligIdContact = var1;
   }

   public long getComligIdResponsable() {
      return this.comligIdResponsable;
   }

   public void setComligIdResponsable(long var1) {
      this.comligIdResponsable = var1;
   }

   public String getComligLibelle() {
      return this.comligLibelle;
   }

   public void setComligLibelle(String var1) {
      this.comligLibelle = var1;
   }

   public int getComligNature() {
      return this.comligNature;
   }

   public void setComligNature(int var1) {
      this.comligNature = var1;
   }

   public String getComligNomCommercial() {
      return this.comligNomCommercial;
   }

   public void setComligNomCommercial(String var1) {
      this.comligNomCommercial = var1;
   }

   public String getComligNomResponsable() {
      return this.comligNomResponsable;
   }

   public void setComligNomResponsable(String var1) {
      this.comligNomResponsable = var1;
   }

   public String getComligNomTiers() {
      return this.comligNomTiers;
   }

   public void setComligNomTiers(String var1) {
      this.comligNomTiers = var1;
   }

   public String getComligNum() {
      return this.comligNum;
   }

   public void setComligNum(String var1) {
      this.comligNum = var1;
   }

   public float getComligQte() {
      return this.comligQte;
   }

   public void setComligQte(float var1) {
      this.comligQte = var1;
   }

   public String getComligSerie() {
      return this.comligSerie;
   }

   public void setComligSerie(String var1) {
      this.comligSerie = var1;
   }

   public double getComligTotCommission() {
      return this.comligTotCommission;
   }

   public void setComligTotCommission(double var1) {
      this.comligTotCommission = var1;
   }

   public double getComligTotHt() {
      return this.comligTotHt;
   }

   public void setComligTotHt(double var1) {
      this.comligTotHt = var1;
   }

   public long getComligId() {
      return this.comligId;
   }

   public void setComligId(long var1) {
      this.comligId = var1;
   }

   public Date getComligDateLastReg() {
      return this.comligDateLastReg;
   }

   public void setComligDateLastReg(Date var1) {
      this.comligDateLastReg = var1;
   }

   public long getComligNbJour() {
      return this.comligNbJour;
   }

   public void setComligNbJour(long var1) {
      this.comligNbJour = var1;
   }

   public String getComligNomContact() {
      return this.comligNomContact;
   }

   public void setComligNomContact(String var1) {
      this.comligNomContact = var1;
   }

   public long getComligIdTiers() {
      return this.comligIdTiers;
   }

   public void setComligIdTiers(long var1) {
      this.comligIdTiers = var1;
   }

   public long getComligIdligne() {
      return this.comligIdligne;
   }

   public void setComligIdligne(long var1) {
      this.comligIdligne = var1;
   }

   public long getComligIdEquipe() {
      return this.comligIdEquipe;
   }

   public void setComligIdEquipe(long var1) {
      this.comligIdEquipe = var1;
   }

   public String getComligNomEquipe() {
      return this.comligNomEquipe;
   }

   public void setComligNomEquipe(String var1) {
      this.comligNomEquipe = var1;
   }

   public String getComligService() {
      return this.comligService;
   }

   public void setComligService(String var1) {
      this.comligService = var1;
   }

   public double getComligTotVerse() {
      return this.comligTotVerse;
   }

   public void setComligTotVerse(double var1) {
      this.comligTotVerse = var1;
   }

   public long getComligIdRecu() {
      return this.comligIdRecu;
   }

   public void setComligIdRecu(long var1) {
      this.comligIdRecu = var1;
   }

   public double getComligTotCommissionReel() {
      return this.comligTotCommissionReel;
   }

   public void setComligTotCommissionReel(double var1) {
      this.comligTotCommissionReel = var1;
   }

   public double getComligPayePatient() {
      return this.comligPayePatient;
   }

   public void setComligPayePatient(double var1) {
      this.comligPayePatient = var1;
   }

   public double getComligPayeTier() {
      return this.comligPayeTier;
   }

   public void setComligPayeTier(double var1) {
      this.comligPayeTier = var1;
   }
}
