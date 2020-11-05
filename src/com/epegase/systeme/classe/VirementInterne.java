package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class VirementInterne implements Serializable {
   private long virId;
   private Date virDateCreat;
   private long virUserCreat;
   private String virGrp;
   private Date virDateModif;
   private long virUserModif;
   private int virNature;
   private String virNomEmetrice;
   private String virNomReceptrice;
   private String virCodEmetrice;
   private String virCodReceptrice;
   private String virCodeCaiss;
   private String virLibCaiss;
   private String virNum;
   private boolean virPj;
   private String virCle;
   private String virNomResponsable;
   private long virIdResponsable;
   private String virSerie;
   private String virDevise;
   private double virMontant;
   private int virActif;
   private String virLibelle;
   private int virTypeReg;
   private int virEtat;
   private int virGele;
   private Date virDateValeur;
   private Date virDate;
   private String virModeleImp;
   private Date virDateImpression;
   private Date virDateImp;
   private String virActivite;
   private String virSite;
   private String virDepartement;
   private String virService;
   private String virRegion;
   private String virSecteur;
   private String virPdv;
   private String virBudget;
   private double virBudgetDispo;
   private double virBudgetTreso;
   private double virBudgetDispoMois;
   private double virBudgetTresoMois;
   private String virDossier;
   private String virParc;
   private String virNumChqBdx;
   private int virEtatVal;
   private int virPosSignature;
   private Date virDateValide;
   private String virCodeBudgetTreso;
   private String virCodePosteTreso;
   private String virInfo1;
   private String virInfo2;
   private String virInfo3;
   private String virInfo4;
   private String virInfo5;
   private String virInfo6;
   private String virInfo7;
   private String virInfo8;
   private String virInfo9;
   private String virInfo10;
   private ExercicesCaisse exercicesCaisse;
   private String var_lib_nat;
   private String var_etat;
   private String var_compteEmetteur;
   private String var_nomBanqueEmetteur;
   private String var_nomBanquierEmetteur;
   private String var_adresseBanqueEmetteur;
   private String var_villeBanqueEmetteur;
   private String var_compteReceptteur;
   private String var_nomBanqueReceptteur;
   private String var_nomBanquierReceptteur;
   private String var_adresseBanqueReceptteur;
   private String var_villeBanqueReceptteur;
   private String var_fonctionResponsable;
   private String var_nom_createur;

   public String getVar_nom_createur() {
      return this.var_nom_createur;
   }

   public void setVar_nom_createur(String var1) {
      this.var_nom_createur = var1;
   }

   public String getVar_fonctionResponsable() {
      return this.var_fonctionResponsable;
   }

   public void setVar_fonctionResponsable(String var1) {
      this.var_fonctionResponsable = var1;
   }

   public String getVar_adresseBanqueEmetteur() {
      return this.var_adresseBanqueEmetteur;
   }

   public void setVar_adresseBanqueEmetteur(String var1) {
      this.var_adresseBanqueEmetteur = var1;
   }

   public String getVar_adresseBanqueReceptteur() {
      return this.var_adresseBanqueReceptteur;
   }

   public void setVar_adresseBanqueReceptteur(String var1) {
      this.var_adresseBanqueReceptteur = var1;
   }

   public String getVar_compteEmetteur() {
      return this.var_compteEmetteur;
   }

   public void setVar_compteEmetteur(String var1) {
      this.var_compteEmetteur = var1;
   }

   public String getVar_compteReceptteur() {
      return this.var_compteReceptteur;
   }

   public void setVar_compteReceptteur(String var1) {
      this.var_compteReceptteur = var1;
   }

   public String getVar_nomBanqueEmetteur() {
      return this.var_nomBanqueEmetteur;
   }

   public void setVar_nomBanqueEmetteur(String var1) {
      this.var_nomBanqueEmetteur = var1;
   }

   public String getVar_nomBanqueReceptteur() {
      return this.var_nomBanqueReceptteur;
   }

   public void setVar_nomBanqueReceptteur(String var1) {
      this.var_nomBanqueReceptteur = var1;
   }

   public String getVar_nomBanquierEmetteur() {
      return this.var_nomBanquierEmetteur;
   }

   public void setVar_nomBanquierEmetteur(String var1) {
      this.var_nomBanquierEmetteur = var1;
   }

   public String getVar_nomBanquierReceptteur() {
      return this.var_nomBanquierReceptteur;
   }

   public void setVar_nomBanquierReceptteur(String var1) {
      this.var_nomBanquierReceptteur = var1;
   }

   public String getVar_villeBanqueEmetteur() {
      return this.var_villeBanqueEmetteur;
   }

   public void setVar_villeBanqueEmetteur(String var1) {
      this.var_villeBanqueEmetteur = var1;
   }

   public String getVar_villeBanqueReceptteur() {
      return this.var_villeBanqueReceptteur;
   }

   public void setVar_villeBanqueReceptteur(String var1) {
      this.var_villeBanqueReceptteur = var1;
   }

   public String getVar_lib_nat() {
      return this.var_lib_nat;
   }

   public void setVar_lib_nat(String var1) {
      this.var_lib_nat = var1;
   }

   public String getVar_etat() {
      if (this.virEtat == 0) {
         this.var_etat = "En cours";
      } else if (this.virEtat == 1) {
         this.var_etat = "Validé";
      } else if (this.virEtat == 2) {
         this.var_etat = "Gelé";
      } else if (this.virEtat == 3) {
         this.var_etat = "Annulé";
      } else if (this.virEtat == 4) {
         this.var_etat = "Exécuté";
      }

      return this.var_etat;
   }

   public void setVar_etat(String var1) {
      this.var_etat = var1;
   }

   public ExercicesCaisse getExercicesCaisse() {
      return this.exercicesCaisse;
   }

   public void setExercicesCaisse(ExercicesCaisse var1) {
      this.exercicesCaisse = var1;
   }

   public int getVirActif() {
      return this.virActif;
   }

   public void setVirActif(int var1) {
      this.virActif = var1;
   }

   public String getVirCle() {
      return this.virCle;
   }

   public void setVirCle(String var1) {
      this.virCle = var1;
   }

   public String getVirCodEmetrice() {
      return this.virCodEmetrice;
   }

   public void setVirCodEmetrice(String var1) {
      this.virCodEmetrice = var1;
   }

   public String getVirCodReceptrice() {
      return this.virCodReceptrice;
   }

   public void setVirCodReceptrice(String var1) {
      this.virCodReceptrice = var1;
   }

   public String getVirCodeCaiss() {
      return this.virCodeCaiss;
   }

   public void setVirCodeCaiss(String var1) {
      this.virCodeCaiss = var1;
   }

   public Date getVirDate() {
      return this.virDate;
   }

   public void setVirDate(Date var1) {
      this.virDate = var1;
   }

   public Date getVirDateCreat() {
      return this.virDateCreat;
   }

   public void setVirDateCreat(Date var1) {
      this.virDateCreat = var1;
   }

   public Date getVirDateModif() {
      return this.virDateModif;
   }

   public void setVirDateModif(Date var1) {
      this.virDateModif = var1;
   }

   public Date getVirDateValeur() {
      return this.virDateValeur;
   }

   public void setVirDateValeur(Date var1) {
      this.virDateValeur = var1;
   }

   public String getVirDevise() {
      return this.virDevise;
   }

   public void setVirDevise(String var1) {
      this.virDevise = var1;
   }

   public int getVirEtat() {
      return this.virEtat;
   }

   public void setVirEtat(int var1) {
      this.virEtat = var1;
   }

   public long getVirId() {
      return this.virId;
   }

   public void setVirId(long var1) {
      this.virId = var1;
   }

   public String getVirLibCaiss() {
      return this.virLibCaiss;
   }

   public void setVirLibCaiss(String var1) {
      this.virLibCaiss = var1;
   }

   public String getVirLibelle() {
      return this.virLibelle;
   }

   public void setVirLibelle(String var1) {
      this.virLibelle = var1;
   }

   public String getVirModeleImp() {
      return this.virModeleImp;
   }

   public void setVirModeleImp(String var1) {
      this.virModeleImp = var1;
   }

   public double getVirMontant() {
      return this.virMontant;
   }

   public void setVirMontant(double var1) {
      this.virMontant = var1;
   }

   public int getVirNature() {
      return this.virNature;
   }

   public void setVirNature(int var1) {
      this.virNature = var1;
   }

   public String getVirNomEmetrice() {
      return this.virNomEmetrice;
   }

   public void setVirNomEmetrice(String var1) {
      this.virNomEmetrice = var1;
   }

   public String getVirNomReceptrice() {
      return this.virNomReceptrice;
   }

   public void setVirNomReceptrice(String var1) {
      this.virNomReceptrice = var1;
   }

   public String getVirNomResponsable() {
      return this.virNomResponsable;
   }

   public void setVirNomResponsable(String var1) {
      this.virNomResponsable = var1;
   }

   public String getVirNum() {
      return this.virNum;
   }

   public void setVirNum(String var1) {
      this.virNum = var1;
   }

   public String getVirSerie() {
      return this.virSerie;
   }

   public void setVirSerie(String var1) {
      this.virSerie = var1;
   }

   public int getVirTypeReg() {
      return this.virTypeReg;
   }

   public void setVirTypeReg(int var1) {
      this.virTypeReg = var1;
   }

   public Date getVirDateImp() {
      return this.virDateImp;
   }

   public void setVirDateImp(Date var1) {
      this.virDateImp = var1;
   }

   public long getVirUserCreat() {
      return this.virUserCreat;
   }

   public void setVirUserCreat(long var1) {
      this.virUserCreat = var1;
   }

   public long getVirUserModif() {
      return this.virUserModif;
   }

   public void setVirUserModif(long var1) {
      this.virUserModif = var1;
   }

   public String getVirActivite() {
      return this.virActivite;
   }

   public void setVirActivite(String var1) {
      this.virActivite = var1;
   }

   public String getVirBudget() {
      return this.virBudget;
   }

   public void setVirBudget(String var1) {
      this.virBudget = var1;
   }

   public String getVirDepartement() {
      return this.virDepartement;
   }

   public void setVirDepartement(String var1) {
      this.virDepartement = var1;
   }

   public String getVirPdv() {
      return this.virPdv;
   }

   public void setVirPdv(String var1) {
      this.virPdv = var1;
   }

   public String getVirRegion() {
      return this.virRegion;
   }

   public void setVirRegion(String var1) {
      this.virRegion = var1;
   }

   public String getVirSecteur() {
      return this.virSecteur;
   }

   public void setVirSecteur(String var1) {
      this.virSecteur = var1;
   }

   public String getVirService() {
      return this.virService;
   }

   public void setVirService(String var1) {
      this.virService = var1;
   }

   public String getVirSite() {
      return this.virSite;
   }

   public void setVirSite(String var1) {
      this.virSite = var1;
   }

   public double getVirBudgetDispo() {
      return this.virBudgetDispo;
   }

   public void setVirBudgetDispo(double var1) {
      this.virBudgetDispo = var1;
   }

   public double getVirBudgetDispoMois() {
      return this.virBudgetDispoMois;
   }

   public void setVirBudgetDispoMois(double var1) {
      this.virBudgetDispoMois = var1;
   }

   public double getVirBudgetTreso() {
      return this.virBudgetTreso;
   }

   public void setVirBudgetTreso(double var1) {
      this.virBudgetTreso = var1;
   }

   public double getVirBudgetTresoMois() {
      return this.virBudgetTresoMois;
   }

   public void setVirBudgetTresoMois(double var1) {
      this.virBudgetTresoMois = var1;
   }

   public String getVirDossier() {
      return this.virDossier;
   }

   public void setVirDossier(String var1) {
      this.virDossier = var1;
   }

   public String getVirParc() {
      return this.virParc;
   }

   public void setVirParc(String var1) {
      this.virParc = var1;
   }

   public String getVirNumChqBdx() {
      return this.virNumChqBdx;
   }

   public void setVirNumChqBdx(String var1) {
      this.virNumChqBdx = var1;
   }

   public Date getVirDateValide() {
      return this.virDateValide;
   }

   public void setVirDateValide(Date var1) {
      this.virDateValide = var1;
   }

   public int getVirEtatVal() {
      return this.virEtatVal;
   }

   public void setVirEtatVal(int var1) {
      this.virEtatVal = var1;
   }

   public Date getVirDateImpression() {
      return this.virDateImpression;
   }

   public void setVirDateImpression(Date var1) {
      this.virDateImpression = var1;
   }

   public String getVirCodeBudgetTreso() {
      return this.virCodeBudgetTreso;
   }

   public void setVirCodeBudgetTreso(String var1) {
      this.virCodeBudgetTreso = var1;
   }

   public String getVirCodePosteTreso() {
      return this.virCodePosteTreso;
   }

   public void setVirCodePosteTreso(String var1) {
      this.virCodePosteTreso = var1;
   }

   public long getVirIdResponsable() {
      return this.virIdResponsable;
   }

   public void setVirIdResponsable(long var1) {
      this.virIdResponsable = var1;
   }

   public String getVirInfo1() {
      return this.virInfo1;
   }

   public void setVirInfo1(String var1) {
      this.virInfo1 = var1;
   }

   public String getVirInfo10() {
      return this.virInfo10;
   }

   public void setVirInfo10(String var1) {
      this.virInfo10 = var1;
   }

   public String getVirInfo2() {
      return this.virInfo2;
   }

   public void setVirInfo2(String var1) {
      this.virInfo2 = var1;
   }

   public String getVirInfo3() {
      return this.virInfo3;
   }

   public void setVirInfo3(String var1) {
      this.virInfo3 = var1;
   }

   public String getVirInfo4() {
      return this.virInfo4;
   }

   public void setVirInfo4(String var1) {
      this.virInfo4 = var1;
   }

   public String getVirInfo5() {
      return this.virInfo5;
   }

   public void setVirInfo5(String var1) {
      this.virInfo5 = var1;
   }

   public String getVirInfo6() {
      return this.virInfo6;
   }

   public void setVirInfo6(String var1) {
      this.virInfo6 = var1;
   }

   public String getVirInfo7() {
      return this.virInfo7;
   }

   public void setVirInfo7(String var1) {
      this.virInfo7 = var1;
   }

   public String getVirInfo8() {
      return this.virInfo8;
   }

   public void setVirInfo8(String var1) {
      this.virInfo8 = var1;
   }

   public String getVirInfo9() {
      return this.virInfo9;
   }

   public void setVirInfo9(String var1) {
      this.virInfo9 = var1;
   }

   public String getVirGrp() {
      return this.virGrp;
   }

   public void setVirGrp(String var1) {
      this.virGrp = var1;
   }

   public int getVirPosSignature() {
      return this.virPosSignature;
   }

   public void setVirPosSignature(int var1) {
      this.virPosSignature = var1;
   }

   public int getVirGele() {
      return this.virGele;
   }

   public void setVirGele(int var1) {
      this.virGele = var1;
   }

   public boolean isVirPj() {
      return this.virPj;
   }

   public void setVirPj(boolean var1) {
      this.virPj = var1;
   }
}
