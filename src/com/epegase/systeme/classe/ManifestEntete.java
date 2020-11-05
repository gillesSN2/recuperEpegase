package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ManifestEntete implements Serializable {
   private long vtemanId;
   private int vtemanTypeTransport;
   private String vtemanNum;
   private String vtemanRefNavire;
   private String vtemanLibNavire;
   private String vtemanRefPortDep;
   private String vtemanLibPortDep;
   private double vtemanKmsDep;
   private String vtemanRefPortArr;
   private String vtemanLibPortArr;
   private double vtemanKmsArr;
   private double vtemanDistance;
   private Date vtemanDateDep;
   private Date vtemanDateArr;
   private String vtemanRefLieuDep;
   private String vtemanLibLieuDep;
   private String vtemanRefLieuArr;
   private String vtemanLibLieuArr;
   private String vtemanNumBl;
   private String vtemanLoginUser;
   private Date vtemanDateSaisie;
   private Date vtemanDateModification;
   private String vtemanSerie;
   private Date vtemanDateCreat;
   private Date vtemanDateModif;
   private long vtemanUserCreat;
   private long vtemanUserModif;
   private int vtemanEtat;
   private Date vtemanDateImp;
   private String vtemanModeleImp;
   private String vtemanNomResponsable;
   private long vtemanIdResponsable;
   private String vtemanNomEquipe;
   private long vtemanIdEquipe;
   private String vtemanNomCommercial;
   private long vtemanIdCommercial;
   private String vtemanActivite;
   private String vtemanSite;
   private String vtemanDepartement;
   private String vtemanService;
   private int vtemanEtatVal;
   private Date vtemanDateValide;
   private int vtemanPosSignature;
   private int vtemanGele;
   private Date vtemanDateAnnule;
   private String vtemanMotifAnnule;
   private Date vtemanDateTransforme;
   private int vtemanTypeTransforme;
   private double vtemanTotalHt;
   private double vtemanTotalTva;
   private double vtemanTotalTtc;
   private double vtemanTc;
   private double vtemanTotalReglement;
   private String vtemanObjet;
   private int vtemanNbColisExp;
   private float vtemanPoidsExp;
   private float vtemanVolumeExp;
   private ExercicesParc exercicesParc;
   private String libelleEta;
   private String libelleNAture;
   private double varTotTtcGlob;
   private double var_reliquatListe;
   private boolean var_select_ligne;
   private int var_format_devise;
   private double solde;

   public ExercicesParc getExercicesParc() {
      return this.exercicesParc;
   }

   public void setExercicesParc(ExercicesParc var1) {
      this.exercicesParc = var1;
   }

   public String getLibelleNAture() {
      if (this.vtemanTypeTransport == 1) {
         this.libelleNAture = "Maritime";
      } else if (this.vtemanTypeTransport == 2) {
         this.libelleNAture = "Fluvial";
      } else if (this.vtemanTypeTransport == 3) {
         this.libelleNAture = "Aérien";
      } else if (this.vtemanTypeTransport == 4) {
         this.libelleNAture = "Routier";
      } else if (this.vtemanTypeTransport == 5) {
         this.libelleNAture = "Ferrovier";
      } else {
         this.libelleNAture = "SANS";
      }

      return this.libelleNAture;
   }

   public void setLibelleNAture(String var1) {
      this.libelleNAture = var1;
   }

   public double getSolde() {
      this.solde = this.vtemanTotalTtc + this.vtemanTc - this.vtemanTotalReglement;
      return this.solde;
   }

   public void setSolde(double var1) {
      this.solde = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.vtemanTotalTtc + this.vtemanTc;
      return this.varTotTtcGlob;
   }

   public void setVarTotTtcGlob(double var1) {
      this.varTotTtcGlob = var1;
   }

   public int getVar_format_devise() {
      return this.var_format_devise;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public double getVar_reliquatListe() {
      this.var_reliquatListe = this.varTotTtcGlob - this.vtemanTotalReglement;
      return this.var_reliquatListe;
   }

   public void setVar_reliquatListe(double var1) {
      this.var_reliquatListe = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public String getLibelleEta() {
      if (this.vtemanEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.vtemanEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.vtemanEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.vtemanEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.vtemanEtat == 4) {
         this.libelleEta = "Fac.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getVtemanActivite() {
      return this.vtemanActivite;
   }

   public void setVtemanActivite(String var1) {
      this.vtemanActivite = var1;
   }

   public Date getVtemanDateAnnule() {
      return this.vtemanDateAnnule;
   }

   public void setVtemanDateAnnule(Date var1) {
      this.vtemanDateAnnule = var1;
   }

   public Date getVtemanDateArr() {
      return this.vtemanDateArr;
   }

   public void setVtemanDateArr(Date var1) {
      this.vtemanDateArr = var1;
   }

   public Date getVtemanDateCreat() {
      return this.vtemanDateCreat;
   }

   public void setVtemanDateCreat(Date var1) {
      this.vtemanDateCreat = var1;
   }

   public Date getVtemanDateDep() {
      return this.vtemanDateDep;
   }

   public void setVtemanDateDep(Date var1) {
      this.vtemanDateDep = var1;
   }

   public Date getVtemanDateImp() {
      return this.vtemanDateImp;
   }

   public void setVtemanDateImp(Date var1) {
      this.vtemanDateImp = var1;
   }

   public Date getVtemanDateModif() {
      return this.vtemanDateModif;
   }

   public void setVtemanDateModif(Date var1) {
      this.vtemanDateModif = var1;
   }

   public Date getVtemanDateTransforme() {
      return this.vtemanDateTransforme;
   }

   public void setVtemanDateTransforme(Date var1) {
      this.vtemanDateTransforme = var1;
   }

   public Date getVtemanDateValide() {
      return this.vtemanDateValide;
   }

   public void setVtemanDateValide(Date var1) {
      this.vtemanDateValide = var1;
   }

   public String getVtemanDepartement() {
      return this.vtemanDepartement;
   }

   public void setVtemanDepartement(String var1) {
      this.vtemanDepartement = var1;
   }

   public int getVtemanEtat() {
      return this.vtemanEtat;
   }

   public void setVtemanEtat(int var1) {
      this.vtemanEtat = var1;
   }

   public int getVtemanEtatVal() {
      return this.vtemanEtatVal;
   }

   public void setVtemanEtatVal(int var1) {
      this.vtemanEtatVal = var1;
   }

   public int getVtemanGele() {
      return this.vtemanGele;
   }

   public void setVtemanGele(int var1) {
      this.vtemanGele = var1;
   }

   public long getVtemanId() {
      return this.vtemanId;
   }

   public void setVtemanId(long var1) {
      this.vtemanId = var1;
   }

   public long getVtemanIdCommercial() {
      return this.vtemanIdCommercial;
   }

   public void setVtemanIdCommercial(long var1) {
      this.vtemanIdCommercial = var1;
   }

   public long getVtemanIdEquipe() {
      return this.vtemanIdEquipe;
   }

   public void setVtemanIdEquipe(long var1) {
      this.vtemanIdEquipe = var1;
   }

   public long getVtemanIdResponsable() {
      return this.vtemanIdResponsable;
   }

   public void setVtemanIdResponsable(long var1) {
      this.vtemanIdResponsable = var1;
   }

   public String getVtemanLibLieuArr() {
      return this.vtemanLibLieuArr;
   }

   public void setVtemanLibLieuArr(String var1) {
      this.vtemanLibLieuArr = var1;
   }

   public String getVtemanLibLieuDep() {
      return this.vtemanLibLieuDep;
   }

   public void setVtemanLibLieuDep(String var1) {
      this.vtemanLibLieuDep = var1;
   }

   public String getVtemanLibNavire() {
      return this.vtemanLibNavire;
   }

   public void setVtemanLibNavire(String var1) {
      this.vtemanLibNavire = var1;
   }

   public String getVtemanLibPortArr() {
      return this.vtemanLibPortArr;
   }

   public void setVtemanLibPortArr(String var1) {
      this.vtemanLibPortArr = var1;
   }

   public String getVtemanLibPortDep() {
      return this.vtemanLibPortDep;
   }

   public void setVtemanLibPortDep(String var1) {
      this.vtemanLibPortDep = var1;
   }

   public String getVtemanModeleImp() {
      return this.vtemanModeleImp;
   }

   public void setVtemanModeleImp(String var1) {
      this.vtemanModeleImp = var1;
   }

   public String getVtemanMotifAnnule() {
      return this.vtemanMotifAnnule;
   }

   public void setVtemanMotifAnnule(String var1) {
      this.vtemanMotifAnnule = var1;
   }

   public String getVtemanNomCommercial() {
      return this.vtemanNomCommercial;
   }

   public void setVtemanNomCommercial(String var1) {
      this.vtemanNomCommercial = var1;
   }

   public String getVtemanNomEquipe() {
      return this.vtemanNomEquipe;
   }

   public void setVtemanNomEquipe(String var1) {
      this.vtemanNomEquipe = var1;
   }

   public String getVtemanNomResponsable() {
      return this.vtemanNomResponsable;
   }

   public void setVtemanNomResponsable(String var1) {
      this.vtemanNomResponsable = var1;
   }

   public String getVtemanNum() {
      return this.vtemanNum;
   }

   public void setVtemanNum(String var1) {
      this.vtemanNum = var1;
   }

   public String getVtemanNumBl() {
      return this.vtemanNumBl;
   }

   public void setVtemanNumBl(String var1) {
      this.vtemanNumBl = var1;
   }

   public int getVtemanPosSignature() {
      return this.vtemanPosSignature;
   }

   public void setVtemanPosSignature(int var1) {
      this.vtemanPosSignature = var1;
   }

   public String getVtemanRefLieuArr() {
      return this.vtemanRefLieuArr;
   }

   public void setVtemanRefLieuArr(String var1) {
      this.vtemanRefLieuArr = var1;
   }

   public String getVtemanRefLieuDep() {
      return this.vtemanRefLieuDep;
   }

   public void setVtemanRefLieuDep(String var1) {
      this.vtemanRefLieuDep = var1;
   }

   public String getVtemanRefNavire() {
      return this.vtemanRefNavire;
   }

   public void setVtemanRefNavire(String var1) {
      this.vtemanRefNavire = var1;
   }

   public String getVtemanRefPortArr() {
      return this.vtemanRefPortArr;
   }

   public void setVtemanRefPortArr(String var1) {
      this.vtemanRefPortArr = var1;
   }

   public String getVtemanRefPortDep() {
      return this.vtemanRefPortDep;
   }

   public void setVtemanRefPortDep(String var1) {
      this.vtemanRefPortDep = var1;
   }

   public String getVtemanService() {
      return this.vtemanService;
   }

   public void setVtemanService(String var1) {
      this.vtemanService = var1;
   }

   public String getVtemanSite() {
      return this.vtemanSite;
   }

   public void setVtemanSite(String var1) {
      this.vtemanSite = var1;
   }

   public int getVtemanTypeTransforme() {
      return this.vtemanTypeTransforme;
   }

   public void setVtemanTypeTransforme(int var1) {
      this.vtemanTypeTransforme = var1;
   }

   public long getVtemanUserCreat() {
      return this.vtemanUserCreat;
   }

   public void setVtemanUserCreat(long var1) {
      this.vtemanUserCreat = var1;
   }

   public long getVtemanUserModif() {
      return this.vtemanUserModif;
   }

   public void setVtemanUserModif(long var1) {
      this.vtemanUserModif = var1;
   }

   public String getVtemanSerie() {
      return this.vtemanSerie;
   }

   public void setVtemanSerie(String var1) {
      this.vtemanSerie = var1;
   }

   public double getVtemanTc() {
      return this.vtemanTc;
   }

   public void setVtemanTc(double var1) {
      this.vtemanTc = var1;
   }

   public double getVtemanTotalHt() {
      return this.vtemanTotalHt;
   }

   public void setVtemanTotalHt(double var1) {
      this.vtemanTotalHt = var1;
   }

   public double getVtemanTotalTtc() {
      return this.vtemanTotalTtc;
   }

   public void setVtemanTotalTtc(double var1) {
      this.vtemanTotalTtc = var1;
   }

   public double getVtemanTotalTva() {
      return this.vtemanTotalTva;
   }

   public void setVtemanTotalTva(double var1) {
      this.vtemanTotalTva = var1;
   }

   public double getVtemanTotalReglement() {
      return this.vtemanTotalReglement;
   }

   public void setVtemanTotalReglement(double var1) {
      this.vtemanTotalReglement = var1;
   }

   public String getVtemanObjet() {
      return this.vtemanObjet;
   }

   public void setVtemanObjet(String var1) {
      this.vtemanObjet = var1;
   }

   public Date getVtemanDateModification() {
      return this.vtemanDateModification;
   }

   public void setVtemanDateModification(Date var1) {
      this.vtemanDateModification = var1;
   }

   public Date getVtemanDateSaisie() {
      return this.vtemanDateSaisie;
   }

   public void setVtemanDateSaisie(Date var1) {
      this.vtemanDateSaisie = var1;
   }

   public String getVtemanLoginUser() {
      return this.vtemanLoginUser;
   }

   public void setVtemanLoginUser(String var1) {
      this.vtemanLoginUser = var1;
   }

   public int getVtemanTypeTransport() {
      return this.vtemanTypeTransport;
   }

   public void setVtemanTypeTransport(int var1) {
      this.vtemanTypeTransport = var1;
   }

   public double getVtemanDistance() {
      return this.vtemanDistance;
   }

   public void setVtemanDistance(double var1) {
      this.vtemanDistance = var1;
   }

   public double getVtemanKmsArr() {
      return this.vtemanKmsArr;
   }

   public void setVtemanKmsArr(double var1) {
      this.vtemanKmsArr = var1;
   }

   public double getVtemanKmsDep() {
      return this.vtemanKmsDep;
   }

   public void setVtemanKmsDep(double var1) {
      this.vtemanKmsDep = var1;
   }

   public int getVtemanNbColisExp() {
      return this.vtemanNbColisExp;
   }

   public void setVtemanNbColisExp(int var1) {
      this.vtemanNbColisExp = var1;
   }

   public float getVtemanPoidsExp() {
      return this.vtemanPoidsExp;
   }

   public void setVtemanPoidsExp(float var1) {
      this.vtemanPoidsExp = var1;
   }

   public float getVtemanVolumeExp() {
      return this.vtemanVolumeExp;
   }

   public void setVtemanVolumeExp(float var1) {
      this.vtemanVolumeExp = var1;
   }
}
