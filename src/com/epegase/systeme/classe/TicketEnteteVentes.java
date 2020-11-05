package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class TicketEnteteVentes implements Serializable {
   private long ticId;
   private Date ticDate;
   private String ticNum;
   private String ticCaisse;
   private String ticTable;
   private String ticChambre;
   private String ticFidele;
   private String ticNomEquipe;
   private long ticIdEquipe;
   private String ticNomResponsable;
   private long ticIdResponsable;
   private String ticNomLivreur;
   private long ticIdLivreur;
   private String ticNomCommercial;
   private long ticIdCommercial;
   private String ticNomTiers;
   private String ticCivilTiers;
   private String ticCat;
   private String ticSite;
   private String ticDepartement;
   private String ticService;
   private double ticTotalHt;
   private double ticTotalTva;
   private float ticTauxTc;
   private double ticTotalTc;
   private double ticTotalTtc;
   private double ticTotalReglement;
   private int ticTypeReg;
   private String ticModeReg;
   private int ticNbJourReg;
   private int ticArrondiReg;
   private Date ticDateEcheReg;
   private int ticEtat;
   private String ticDevise;
   private String ticTelephne;
   private String ticMail;
   private Date ticDateTransfert;
   private ExercicesVentes exerciceventes;
   private Tiers tiers;
   private Users users;

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public int getTicArrondiReg() {
      return this.ticArrondiReg;
   }

   public void setTicArrondiReg(int var1) {
      this.ticArrondiReg = var1;
   }

   public String getTicCivilTiers() {
      return this.ticCivilTiers;
   }

   public void setTicCivilTiers(String var1) {
      this.ticCivilTiers = var1;
   }

   public Date getTicDate() {
      return this.ticDate;
   }

   public void setTicDate(Date var1) {
      this.ticDate = var1;
   }

   public Date getTicDateEcheReg() {
      return this.ticDateEcheReg;
   }

   public void setTicDateEcheReg(Date var1) {
      this.ticDateEcheReg = var1;
   }

   public String getTicDepartement() {
      return this.ticDepartement;
   }

   public void setTicDepartement(String var1) {
      this.ticDepartement = var1;
   }

   public long getTicId() {
      return this.ticId;
   }

   public void setTicId(long var1) {
      this.ticId = var1;
   }

   public long getTicIdCommercial() {
      return this.ticIdCommercial;
   }

   public void setTicIdCommercial(long var1) {
      this.ticIdCommercial = var1;
   }

   public String getTicModeReg() {
      return this.ticModeReg;
   }

   public void setTicModeReg(String var1) {
      this.ticModeReg = var1;
   }

   public int getTicNbJourReg() {
      return this.ticNbJourReg;
   }

   public void setTicNbJourReg(int var1) {
      this.ticNbJourReg = var1;
   }

   public String getTicNomCommercial() {
      return this.ticNomCommercial;
   }

   public void setTicNomCommercial(String var1) {
      this.ticNomCommercial = var1;
   }

   public String getTicNomTiers() {
      return this.ticNomTiers;
   }

   public void setTicNomTiers(String var1) {
      this.ticNomTiers = var1;
   }

   public String getTicNum() {
      return this.ticNum;
   }

   public void setTicNum(String var1) {
      this.ticNum = var1;
   }

   public String getTicService() {
      return this.ticService;
   }

   public void setTicService(String var1) {
      this.ticService = var1;
   }

   public String getTicSite() {
      return this.ticSite;
   }

   public void setTicSite(String var1) {
      this.ticSite = var1;
   }

   public double getTicTotalHt() {
      return this.ticTotalHt;
   }

   public void setTicTotalHt(double var1) {
      this.ticTotalHt = var1;
   }

   public double getTicTotalReglement() {
      return this.ticTotalReglement;
   }

   public void setTicTotalReglement(double var1) {
      this.ticTotalReglement = var1;
   }

   public double getTicTotalTc() {
      return this.ticTotalTc;
   }

   public void setTicTotalTc(double var1) {
      this.ticTotalTc = var1;
   }

   public double getTicTotalTtc() {
      return this.ticTotalTtc;
   }

   public void setTicTotalTtc(double var1) {
      this.ticTotalTtc = var1;
   }

   public double getTicTotalTva() {
      return this.ticTotalTva;
   }

   public void setTicTotalTva(double var1) {
      this.ticTotalTva = var1;
   }

   public int getTicTypeReg() {
      return this.ticTypeReg;
   }

   public void setTicTypeReg(int var1) {
      this.ticTypeReg = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public long getTicIdResponsable() {
      return this.ticIdResponsable;
   }

   public void setTicIdResponsable(long var1) {
      this.ticIdResponsable = var1;
   }

   public String getTicNomResponsable() {
      return this.ticNomResponsable;
   }

   public void setTicNomResponsable(String var1) {
      this.ticNomResponsable = var1;
   }

   public float getTicTauxTc() {
      return this.ticTauxTc;
   }

   public void setTicTauxTc(float var1) {
      this.ticTauxTc = var1;
   }

   public long getTicIdEquipe() {
      return this.ticIdEquipe;
   }

   public void setTicIdEquipe(long var1) {
      this.ticIdEquipe = var1;
   }

   public String getTicNomEquipe() {
      return this.ticNomEquipe;
   }

   public void setTicNomEquipe(String var1) {
      this.ticNomEquipe = var1;
   }

   public String getTicDevise() {
      return this.ticDevise;
   }

   public void setTicDevise(String var1) {
      this.ticDevise = var1;
   }

   public int getTicEtat() {
      return this.ticEtat;
   }

   public void setTicEtat(int var1) {
      this.ticEtat = var1;
   }

   public long getTicIdLivreur() {
      return this.ticIdLivreur;
   }

   public void setTicIdLivreur(long var1) {
      this.ticIdLivreur = var1;
   }

   public String getTicNomLivreur() {
      return this.ticNomLivreur;
   }

   public void setTicNomLivreur(String var1) {
      this.ticNomLivreur = var1;
   }

   public String getTicCat() {
      return this.ticCat;
   }

   public void setTicCat(String var1) {
      this.ticCat = var1;
   }

   public String getTicCaisse() {
      return this.ticCaisse;
   }

   public void setTicCaisse(String var1) {
      this.ticCaisse = var1;
   }

   public String getTicMail() {
      return this.ticMail;
   }

   public void setTicMail(String var1) {
      this.ticMail = var1;
   }

   public String getTicTelephne() {
      return this.ticTelephne;
   }

   public void setTicTelephne(String var1) {
      this.ticTelephne = var1;
   }

   public String getTicChambre() {
      return this.ticChambre;
   }

   public void setTicChambre(String var1) {
      this.ticChambre = var1;
   }

   public String getTicTable() {
      return this.ticTable;
   }

   public void setTicTable(String var1) {
      this.ticTable = var1;
   }

   public String getTicFidele() {
      return this.ticFidele;
   }

   public void setTicFidele(String var1) {
      this.ticFidele = var1;
   }

   public Date getTicDateTransfert() {
      return this.ticDateTransfert;
   }

   public void setTicDateTransfert(Date var1) {
      this.ticDateTransfert = var1;
   }
}
