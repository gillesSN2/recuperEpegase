package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CommissionEnteteVentes implements Serializable {
   private long comId;
   private Date comDateCreat;
   private String comNum;
   private Date comDate;
   private long comIdCreateur;
   private String comNomCreateur;
   private Date comDateModif;
   private long comIdModif;
   private String comNomModif;
   private Date comDateDebut;
   private Date comDateFin;
   private String comNomResponsable;
   private long comIdResponsable;
   private String comNomCommercial;
   private long comIdCommercial;
   private String comNomEquipe;
   private long comIdEquipe;
   private double comTotHt;
   private double comTotCommission;
   private double comTotTaxe;
   private float comTauxTaxe;
   private double comNetPayer;
   private double comTotReglement;
   private int comSolde;
   private int comTypeReg;
   private String comModeReg;
   private int comNbJourReg;
   private int comArrondiReg;
   private String comConditionReg;
   private Date comDateEcheReg;
   private Date comDateLastReg;
   private String comActivite;
   private String comSite;
   private String comDepartement;
   private String comService;
   private String comAnal2;
   private String comAnal4;
   private Date comDateImp;
   private String comModeleImp;
   private int comEtatVal;
   private int comGele;
   private int comEtat;
   private Date comDateValidite;
   private Date comDateValide;
   private Date comDateAnnule;
   private String comMotifAnnule;
   private Date comDateTransfert;
   private ExercicesVentes exerciceventes;
   private Users users;
   private String libelleEta;
   private String var_solde;
   private boolean var_select_ligne;
   private String nomConcerne;
   private double reliquat;

   public double getReliquat() {
      this.reliquat = this.comNetPayer - this.comTotReglement;
      return this.reliquat;
   }

   public void setReliquat(double var1) {
      this.reliquat = var1;
   }

   public String getNomConcerne() {
      if (this.comIdResponsable != 0L) {
         this.nomConcerne = this.comNomResponsable;
      } else {
         this.nomConcerne = this.comNomCommercial;
      }

      return this.nomConcerne;
   }

   public void setNomConcerne(String var1) {
      this.nomConcerne = var1;
   }

   public String getLibelleEta() {
      if (this.comEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.comEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.comEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.comEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.comEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.comEtat == 5) {
         this.libelleEta = "Trf.T.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getVar_solde() {
      if (this.comSolde == 1) {
         this.var_solde = "Soldé";
      } else {
         this.var_solde = "";
      }

      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public String getComActivite() {
      return this.comActivite;
   }

   public void setComActivite(String var1) {
      this.comActivite = var1;
   }

   public String getComAnal2() {
      return this.comAnal2;
   }

   public void setComAnal2(String var1) {
      this.comAnal2 = var1;
   }

   public String getComAnal4() {
      return this.comAnal4;
   }

   public void setComAnal4(String var1) {
      this.comAnal4 = var1;
   }

   public int getComArrondiReg() {
      return this.comArrondiReg;
   }

   public void setComArrondiReg(int var1) {
      this.comArrondiReg = var1;
   }

   public String getComConditionReg() {
      return this.comConditionReg;
   }

   public void setComConditionReg(String var1) {
      this.comConditionReg = var1;
   }

   public Date getComDateAnnule() {
      return this.comDateAnnule;
   }

   public void setComDateAnnule(Date var1) {
      this.comDateAnnule = var1;
   }

   public Date getComDateCreat() {
      return this.comDateCreat;
   }

   public void setComDateCreat(Date var1) {
      this.comDateCreat = var1;
   }

   public Date getComDateDebut() {
      return this.comDateDebut;
   }

   public void setComDateDebut(Date var1) {
      this.comDateDebut = var1;
   }

   public Date getComDateEcheReg() {
      return this.comDateEcheReg;
   }

   public void setComDateEcheReg(Date var1) {
      this.comDateEcheReg = var1;
   }

   public Date getComDateFin() {
      return this.comDateFin;
   }

   public void setComDateFin(Date var1) {
      this.comDateFin = var1;
   }

   public Date getComDateImp() {
      return this.comDateImp;
   }

   public void setComDateImp(Date var1) {
      this.comDateImp = var1;
   }

   public Date getComDateLastReg() {
      return this.comDateLastReg;
   }

   public void setComDateLastReg(Date var1) {
      this.comDateLastReg = var1;
   }

   public Date getComDateModif() {
      return this.comDateModif;
   }

   public void setComDateModif(Date var1) {
      this.comDateModif = var1;
   }

   public Date getComDateTransfert() {
      return this.comDateTransfert;
   }

   public void setComDateTransfert(Date var1) {
      this.comDateTransfert = var1;
   }

   public Date getComDateValide() {
      return this.comDateValide;
   }

   public void setComDateValide(Date var1) {
      this.comDateValide = var1;
   }

   public Date getComDateValidite() {
      return this.comDateValidite;
   }

   public void setComDateValidite(Date var1) {
      this.comDateValidite = var1;
   }

   public String getComDepartement() {
      return this.comDepartement;
   }

   public void setComDepartement(String var1) {
      this.comDepartement = var1;
   }

   public int getComEtat() {
      return this.comEtat;
   }

   public void setComEtat(int var1) {
      this.comEtat = var1;
   }

   public int getComEtatVal() {
      return this.comEtatVal;
   }

   public void setComEtatVal(int var1) {
      this.comEtatVal = var1;
   }

   public int getComGele() {
      return this.comGele;
   }

   public void setComGele(int var1) {
      this.comGele = var1;
   }

   public long getComId() {
      return this.comId;
   }

   public void setComId(long var1) {
      this.comId = var1;
   }

   public long getComIdCommercial() {
      return this.comIdCommercial;
   }

   public void setComIdCommercial(long var1) {
      this.comIdCommercial = var1;
   }

   public long getComIdCreateur() {
      return this.comIdCreateur;
   }

   public void setComIdCreateur(long var1) {
      this.comIdCreateur = var1;
   }

   public long getComIdModif() {
      return this.comIdModif;
   }

   public void setComIdModif(long var1) {
      this.comIdModif = var1;
   }

   public long getComIdResponsable() {
      return this.comIdResponsable;
   }

   public void setComIdResponsable(long var1) {
      this.comIdResponsable = var1;
   }

   public String getComModeReg() {
      return this.comModeReg;
   }

   public void setComModeReg(String var1) {
      this.comModeReg = var1;
   }

   public String getComModeleImp() {
      return this.comModeleImp;
   }

   public void setComModeleImp(String var1) {
      this.comModeleImp = var1;
   }

   public String getComMotifAnnule() {
      return this.comMotifAnnule;
   }

   public void setComMotifAnnule(String var1) {
      this.comMotifAnnule = var1;
   }

   public int getComNbJourReg() {
      return this.comNbJourReg;
   }

   public void setComNbJourReg(int var1) {
      this.comNbJourReg = var1;
   }

   public String getComNomCommercial() {
      return this.comNomCommercial;
   }

   public void setComNomCommercial(String var1) {
      this.comNomCommercial = var1;
   }

   public String getComNomCreateur() {
      return this.comNomCreateur;
   }

   public void setComNomCreateur(String var1) {
      this.comNomCreateur = var1;
   }

   public String getComNomModif() {
      return this.comNomModif;
   }

   public void setComNomModif(String var1) {
      this.comNomModif = var1;
   }

   public String getComNomResponsable() {
      return this.comNomResponsable;
   }

   public void setComNomResponsable(String var1) {
      this.comNomResponsable = var1;
   }

   public String getComNum() {
      return this.comNum;
   }

   public void setComNum(String var1) {
      this.comNum = var1;
   }

   public String getComService() {
      return this.comService;
   }

   public void setComService(String var1) {
      this.comService = var1;
   }

   public String getComSite() {
      return this.comSite;
   }

   public void setComSite(String var1) {
      this.comSite = var1;
   }

   public int getComSolde() {
      return this.comSolde;
   }

   public void setComSolde(int var1) {
      this.comSolde = var1;
   }

   public double getComTotReglement() {
      return this.comTotReglement;
   }

   public void setComTotReglement(double var1) {
      this.comTotReglement = var1;
   }

   public double getComTotCommission() {
      return this.comTotCommission;
   }

   public void setComTotCommission(double var1) {
      this.comTotCommission = var1;
   }

   public int getComTypeReg() {
      return this.comTypeReg;
   }

   public void setComTypeReg(int var1) {
      this.comTypeReg = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public Date getComDate() {
      return this.comDate;
   }

   public void setComDate(Date var1) {
      this.comDate = var1;
   }

   public long getComIdEquipe() {
      return this.comIdEquipe;
   }

   public void setComIdEquipe(long var1) {
      this.comIdEquipe = var1;
   }

   public String getComNomEquipe() {
      return this.comNomEquipe;
   }

   public void setComNomEquipe(String var1) {
      this.comNomEquipe = var1;
   }

   public double getComNetPayer() {
      return this.comNetPayer;
   }

   public void setComNetPayer(double var1) {
      this.comNetPayer = var1;
   }

   public float getComTauxTaxe() {
      return this.comTauxTaxe;
   }

   public void setComTauxTaxe(float var1) {
      this.comTauxTaxe = var1;
   }

   public double getComTotTaxe() {
      return this.comTotTaxe;
   }

   public void setComTotTaxe(double var1) {
      this.comTotTaxe = var1;
   }

   public double getComTotHt() {
      return this.comTotHt;
   }

   public void setComTotHt(double var1) {
      this.comTotHt = var1;
   }
}
