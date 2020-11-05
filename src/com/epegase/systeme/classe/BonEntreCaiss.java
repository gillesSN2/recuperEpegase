package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BonEntreCaiss implements Serializable {
   private long entrId;
   private int entrNature;
   private Date entrDateCreat;
   private long entrUserCreat;
   private String entrGrp;
   private Date entrDateModif;
   private long entrUserModif;
   private Date entrDateValidation;
   private long entrUserValidation;
   private String entrNum;
   private boolean entrPj;
   private Date entrDate;
   private String entrCle;
   private String entrNomResponsable;
   private long entrIdResponsable;
   private String entrNomTiers;
   private long entrIdTiers;
   private int entrDepotTiers;
   private int entrTypeTiers;
   private String entrSource;
   private String entrSerie;
   private String entrDevise;
   private double entrMontant;
   private int entrTypeReg;
   private String entrActivite;
   private String entrSite;
   private String entrDepartement;
   private String entrService;
   private String entrRegion;
   private String entrSecteur;
   private String entrPdv;
   private String entrBudget;
   private double entrBudgetDispo;
   private double entrBudgetTreso;
   private double entrBudgetDispoMois;
   private double entrBudgetTresoMois;
   private String entrDossier;
   private String entrParc;
   private int entrActif;
   private String entrLibelle;
   private int entrGele;
   private int entrEtat;
   private Date entrDateValeur;
   private String entrModeleImp;
   private Date entrDateImpression;
   private String entrCodeBanq;
   private String entrLibBanq;
   private String entrLibCaiss;
   private String entrCodeCaiss;
   private String entrBanqueTireur;
   private String entrNumChqBdx;
   private int entrEtatVal;
   private Date entrDateValide;
   private int entrPosSignature;
   private String entrCodeBudgetTreso;
   private String entrCodePosteTreso;
   private String entrActiviteCompte;
   private float entrActiviteTaux;
   private boolean entrActiviteExo;
   private String entrInfo1;
   private String entrInfo2;
   private String entrInfo3;
   private String entrInfo4;
   private String entrInfo5;
   private String entrInfo6;
   private String entrInfo7;
   private String entrInfo8;
   private String entrInfo9;
   private String entrInfo10;
   private ExercicesCaisse exercicesCaisse;
   private String var_lib_nat;
   private String libelleTypeTiers;
   private String var_etat;
   private String lib_activite;
   private String montantLettre;
   private String var_compte;
   private String var_banque;
   private String var_nomBanquier;
   private String var_adresseBanque;
   private String var_villeBanque;
   private String var_adresseTiers;
   private String var_nomTiers;
   private String var_fonctionResponsable;
   private String var_nom_createur;

   public String getVar_nom_createur() {
      return this.var_nom_createur;
   }

   public void setVar_nom_createur(String var1) {
      this.var_nom_createur = var1;
   }

   public String getMontantLettre() {
      return this.montantLettre;
   }

   public void setMontantLettre(String var1) {
      this.montantLettre = var1;
   }

   public String getVar_adresseBanque() {
      return this.var_adresseBanque;
   }

   public void setVar_adresseBanque(String var1) {
      this.var_adresseBanque = var1;
   }

   public String getVar_adresseTiers() {
      return this.var_adresseTiers;
   }

   public void setVar_adresseTiers(String var1) {
      this.var_adresseTiers = var1;
   }

   public String getVar_banque() {
      return this.var_banque;
   }

   public void setVar_banque(String var1) {
      this.var_banque = var1;
   }

   public String getVar_compte() {
      return this.var_compte;
   }

   public void setVar_compte(String var1) {
      this.var_compte = var1;
   }

   public String getVar_fonctionResponsable() {
      return this.var_fonctionResponsable;
   }

   public void setVar_fonctionResponsable(String var1) {
      this.var_fonctionResponsable = var1;
   }

   public String getVar_nomBanquier() {
      return this.var_nomBanquier;
   }

   public void setVar_nomBanquier(String var1) {
      this.var_nomBanquier = var1;
   }

   public String getVar_nomTiers() {
      return this.var_nomTiers;
   }

   public void setVar_nomTiers(String var1) {
      this.var_nomTiers = var1;
   }

   public String getVar_villeBanque() {
      return this.var_villeBanque;
   }

   public void setVar_villeBanque(String var1) {
      this.var_villeBanque = var1;
   }

   public String getLib_activite() {
      if (this.entrActivite != null && !this.entrActivite.isEmpty()) {
         if (this.entrActivite.startsWith("null")) {
            this.lib_activite = "";
         } else {
            this.lib_activite = this.entrActivite;
         }
      } else {
         this.lib_activite = "";
      }

      return this.lib_activite;
   }

   public void setLib_activite(String var1) {
      this.lib_activite = var1;
   }

   public String getLibelleTypeTiers() {
      if (this.entrTypeTiers == 0) {
         this.libelleTypeTiers = "Client";
      } else if (this.entrTypeTiers == 1) {
         this.libelleTypeTiers = "Fournisseur";
      } else if (this.entrTypeTiers == 2) {
         this.libelleTypeTiers = "Agent";
      } else if (this.entrTypeTiers == 3) {
         this.libelleTypeTiers = "Plan Comptable";
      } else if (this.entrTypeTiers == 4) {
         this.libelleTypeTiers = "Patient";
      } else if (this.entrTypeTiers == 5) {
         this.libelleTypeTiers = "Elève";
      }

      return this.libelleTypeTiers;
   }

   public void setLibelleTypeTiers(String var1) {
      this.libelleTypeTiers = var1;
   }

   public String getVar_lib_nat() {
      return this.var_lib_nat;
   }

   public void setVar_lib_nat(String var1) {
      this.var_lib_nat = var1;
   }

   public String getVar_etat() {
      if (this.entrEtat == 0) {
         this.var_etat = "En cours";
      } else if (this.entrEtat == 1) {
         this.var_etat = "Validé";
      } else if (this.entrEtat == 2) {
         this.var_etat = "Gelé";
      } else if (this.entrEtat == 3) {
         this.var_etat = "Annulé";
      } else if (this.entrEtat == 4) {
         this.var_etat = "Exécuté";
      }

      return this.var_etat;
   }

   public void setVar_etat(String var1) {
      this.var_etat = var1;
   }

   public int getEntrActif() {
      return this.entrActif;
   }

   public void setEntrActif(int var1) {
      this.entrActif = var1;
   }

   public String getEntrActivite() {
      return this.entrActivite;
   }

   public void setEntrActivite(String var1) {
      this.entrActivite = var1;
   }

   public String getEntrBudget() {
      return this.entrBudget;
   }

   public void setEntrBudget(String var1) {
      this.entrBudget = var1;
   }

   public Date getEntrDate() {
      return this.entrDate;
   }

   public void setEntrDate(Date var1) {
      this.entrDate = var1;
   }

   public Date getEntrDateCreat() {
      return this.entrDateCreat;
   }

   public void setEntrDateCreat(Date var1) {
      this.entrDateCreat = var1;
   }

   public Date getEntrDateModif() {
      return this.entrDateModif;
   }

   public void setEntrDateModif(Date var1) {
      this.entrDateModif = var1;
   }

   public Date getEntrDateValeur() {
      return this.entrDateValeur;
   }

   public void setEntrDateValeur(Date var1) {
      this.entrDateValeur = var1;
   }

   public String getEntrDepartement() {
      return this.entrDepartement;
   }

   public void setEntrDepartement(String var1) {
      this.entrDepartement = var1;
   }

   public String getEntrDevise() {
      return this.entrDevise;
   }

   public void setEntrDevise(String var1) {
      this.entrDevise = var1;
   }

   public int getEntrEtat() {
      return this.entrEtat;
   }

   public void setEntrEtat(int var1) {
      this.entrEtat = var1;
   }

   public long getEntrId() {
      return this.entrId;
   }

   public void setEntrId(long var1) {
      this.entrId = var1;
   }

   public String getEntrLibelle() {
      return this.entrLibelle;
   }

   public void setEntrLibelle(String var1) {
      this.entrLibelle = var1;
   }

   public String getEntrModeleImp() {
      return this.entrModeleImp;
   }

   public void setEntrModeleImp(String var1) {
      this.entrModeleImp = var1;
   }

   public double getEntrMontant() {
      return this.entrMontant;
   }

   public void setEntrMontant(double var1) {
      this.entrMontant = var1;
   }

   public int getEntrNature() {
      return this.entrNature;
   }

   public void setEntrNature(int var1) {
      this.entrNature = var1;
   }

   public String getEntrNomResponsable() {
      return this.entrNomResponsable;
   }

   public void setEntrNomResponsable(String var1) {
      this.entrNomResponsable = var1;
   }

   public String getEntrNomTiers() {
      if (this.entrNomTiers != null && !this.entrNomTiers.isEmpty()) {
         this.entrNomTiers = this.entrNomTiers.toUpperCase();
      }

      return this.entrNomTiers;
   }

   public void setEntrNomTiers(String var1) {
      this.entrNomTiers = var1;
   }

   public String getEntrNum() {
      return this.entrNum;
   }

   public void setEntrNum(String var1) {
      this.entrNum = var1;
   }

   public String getEntrPdv() {
      return this.entrPdv;
   }

   public void setEntrPdv(String var1) {
      this.entrPdv = var1;
   }

   public String getEntrRegion() {
      return this.entrRegion;
   }

   public void setEntrRegion(String var1) {
      this.entrRegion = var1;
   }

   public String getEntrSecteur() {
      return this.entrSecteur;
   }

   public void setEntrSecteur(String var1) {
      this.entrSecteur = var1;
   }

   public String getEntrSerie() {
      return this.entrSerie;
   }

   public void setEntrSerie(String var1) {
      this.entrSerie = var1;
   }

   public String getEntrService() {
      return this.entrService;
   }

   public void setEntrService(String var1) {
      this.entrService = var1;
   }

   public String getEntrSite() {
      return this.entrSite;
   }

   public void setEntrSite(String var1) {
      this.entrSite = var1;
   }

   public int getEntrTypeReg() {
      return this.entrTypeReg;
   }

   public void setEntrTypeReg(int var1) {
      this.entrTypeReg = var1;
   }

   public ExercicesCaisse getExercicesCaisse() {
      return this.exercicesCaisse;
   }

   public void setExercicesCaisse(ExercicesCaisse var1) {
      this.exercicesCaisse = var1;
   }

   public String getEntrCle() {
      return this.entrCle;
   }

   public void setEntrCle(String var1) {
      this.entrCle = var1;
   }

   public int getEntrTypeTiers() {
      return this.entrTypeTiers;
   }

   public void setEntrTypeTiers(int var1) {
      this.entrTypeTiers = var1;
   }

   public String getEntrCodeCaiss() {
      return this.entrCodeCaiss;
   }

   public void setEntrCodeCaiss(String var1) {
      this.entrCodeCaiss = var1;
   }

   public String getEntrLibCaiss() {
      return this.entrLibCaiss;
   }

   public void setEntrLibCaiss(String var1) {
      this.entrLibCaiss = var1;
   }

   public String getEntrCodeBanq() {
      return this.entrCodeBanq;
   }

   public void setEntrCodeBanq(String var1) {
      this.entrCodeBanq = var1;
   }

   public String getEntrLibBanq() {
      return this.entrLibBanq;
   }

   public void setEntrLibBanq(String var1) {
      this.entrLibBanq = var1;
   }

   public Date getEntrDateImpression() {
      return this.entrDateImpression;
   }

   public void setEntrDateImpression(Date var1) {
      this.entrDateImpression = var1;
   }

   public long getEntrIdTiers() {
      return this.entrIdTiers;
   }

   public void setEntrIdTiers(long var1) {
      this.entrIdTiers = var1;
   }

   public long getEntrUserCreat() {
      return this.entrUserCreat;
   }

   public void setEntrUserCreat(long var1) {
      this.entrUserCreat = var1;
   }

   public long getEntrUserModif() {
      return this.entrUserModif;
   }

   public void setEntrUserModif(long var1) {
      this.entrUserModif = var1;
   }

   public int getEntrDepotTiers() {
      return this.entrDepotTiers;
   }

   public void setEntrDepotTiers(int var1) {
      this.entrDepotTiers = var1;
   }

   public String getEntrBanqueTireur() {
      return this.entrBanqueTireur;
   }

   public void setEntrBanqueTireur(String var1) {
      this.entrBanqueTireur = var1;
   }

   public String getEntrNumChqBdx() {
      return this.entrNumChqBdx;
   }

   public void setEntrNumChqBdx(String var1) {
      this.entrNumChqBdx = var1;
   }

   public double getEntrBudgetDispo() {
      return this.entrBudgetDispo;
   }

   public void setEntrBudgetDispo(double var1) {
      this.entrBudgetDispo = var1;
   }

   public double getEntrBudgetDispoMois() {
      return this.entrBudgetDispoMois;
   }

   public void setEntrBudgetDispoMois(double var1) {
      this.entrBudgetDispoMois = var1;
   }

   public double getEntrBudgetTreso() {
      return this.entrBudgetTreso;
   }

   public void setEntrBudgetTreso(double var1) {
      this.entrBudgetTreso = var1;
   }

   public double getEntrBudgetTresoMois() {
      return this.entrBudgetTresoMois;
   }

   public void setEntrBudgetTresoMois(double var1) {
      this.entrBudgetTresoMois = var1;
   }

   public String getEntrDossier() {
      return this.entrDossier;
   }

   public void setEntrDossier(String var1) {
      this.entrDossier = var1;
   }

   public String getEntrParc() {
      return this.entrParc;
   }

   public void setEntrParc(String var1) {
      this.entrParc = var1;
   }

   public String getEntrCodeBudgetTreso() {
      return this.entrCodeBudgetTreso;
   }

   public void setEntrCodeBudgetTreso(String var1) {
      this.entrCodeBudgetTreso = var1;
   }

   public String getEntrCodePosteTreso() {
      return this.entrCodePosteTreso;
   }

   public void setEntrCodePosteTreso(String var1) {
      this.entrCodePosteTreso = var1;
   }

   public long getEntrIdResponsable() {
      return this.entrIdResponsable;
   }

   public void setEntrIdResponsable(long var1) {
      this.entrIdResponsable = var1;
   }

   public String getEntrActiviteCompte() {
      return this.entrActiviteCompte;
   }

   public void setEntrActiviteCompte(String var1) {
      this.entrActiviteCompte = var1;
   }

   public boolean isEntrActiviteExo() {
      return this.entrActiviteExo;
   }

   public void setEntrActiviteExo(boolean var1) {
      this.entrActiviteExo = var1;
   }

   public float getEntrActiviteTaux() {
      return this.entrActiviteTaux;
   }

   public void setEntrActiviteTaux(float var1) {
      this.entrActiviteTaux = var1;
   }

   public String getEntrInfo1() {
      return this.entrInfo1;
   }

   public void setEntrInfo1(String var1) {
      this.entrInfo1 = var1;
   }

   public String getEntrInfo10() {
      return this.entrInfo10;
   }

   public void setEntrInfo10(String var1) {
      this.entrInfo10 = var1;
   }

   public String getEntrInfo2() {
      return this.entrInfo2;
   }

   public void setEntrInfo2(String var1) {
      this.entrInfo2 = var1;
   }

   public String getEntrInfo3() {
      return this.entrInfo3;
   }

   public void setEntrInfo3(String var1) {
      this.entrInfo3 = var1;
   }

   public String getEntrInfo4() {
      return this.entrInfo4;
   }

   public void setEntrInfo4(String var1) {
      this.entrInfo4 = var1;
   }

   public String getEntrInfo5() {
      return this.entrInfo5;
   }

   public void setEntrInfo5(String var1) {
      this.entrInfo5 = var1;
   }

   public String getEntrInfo6() {
      return this.entrInfo6;
   }

   public void setEntrInfo6(String var1) {
      this.entrInfo6 = var1;
   }

   public String getEntrInfo7() {
      return this.entrInfo7;
   }

   public void setEntrInfo7(String var1) {
      this.entrInfo7 = var1;
   }

   public String getEntrInfo8() {
      return this.entrInfo8;
   }

   public void setEntrInfo8(String var1) {
      this.entrInfo8 = var1;
   }

   public String getEntrInfo9() {
      return this.entrInfo9;
   }

   public void setEntrInfo9(String var1) {
      this.entrInfo9 = var1;
   }

   public Date getEntrDateValidation() {
      return this.entrDateValidation;
   }

   public void setEntrDateValidation(Date var1) {
      this.entrDateValidation = var1;
   }

   public long getEntrUserValidation() {
      return this.entrUserValidation;
   }

   public void setEntrUserValidation(long var1) {
      this.entrUserValidation = var1;
   }

   public String getEntrGrp() {
      return this.entrGrp;
   }

   public void setEntrGrp(String var1) {
      this.entrGrp = var1;
   }

   public Date getEntrDateValide() {
      return this.entrDateValide;
   }

   public void setEntrDateValide(Date var1) {
      this.entrDateValide = var1;
   }

   public int getEntrEtatVal() {
      return this.entrEtatVal;
   }

   public void setEntrEtatVal(int var1) {
      this.entrEtatVal = var1;
   }

   public int getEntrPosSignature() {
      return this.entrPosSignature;
   }

   public void setEntrPosSignature(int var1) {
      this.entrPosSignature = var1;
   }

   public int getEntrGele() {
      return this.entrGele;
   }

   public void setEntrGele(int var1) {
      this.entrGele = var1;
   }

   public boolean isEntrPj() {
      return this.entrPj;
   }

   public void setEntrPj(boolean var1) {
      this.entrPj = var1;
   }

   public String getEntrSource() {
      return this.entrSource;
   }

   public void setEntrSource(String var1) {
      this.entrSource = var1;
   }
}
