package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BonSortieCaiss implements Serializable {
   private long sortId;
   private int sortNature;
   private Date sortDateCreat;
   private long sortUserCreat;
   private String sortGrp;
   private Date sortDateModif;
   private long sortUserModif;
   private Date sortDateValidation;
   private long sortUserValidation;
   private String sortNum;
   private boolean sortPj;
   private String sortCle;
   private String sortNomResponsable;
   private long sortIdResponsable;
   private String sortNomTiers;
   private long sortIdTiers;
   private int sortDepotTiers;
   private int sortTypeTiers;
   private String sortSource;
   private String sortSerie;
   private String sortDevise;
   private double sortMontant;
   private int sortTypeReg;
   private String sortActivite;
   private String sortSite;
   private String sortDepartement;
   private String sortService;
   private String sortRegion;
   private String sortSecteur;
   private String sortPdv;
   private String sortBudget;
   private double sortBudgetDispo;
   private double sortBudgetTreso;
   private double sortBudgetDispoMois;
   private double sortBudgetTresoMois;
   private String sortDossier;
   private String sortParc;
   private String sortCle1Repartition;
   private String sortCle2Repartition;
   private int sortEtat;
   private int sortGele;
   private int sortActif;
   private String sortLibelle;
   private String sortDocument;
   private String sortObjet;
   private Date sortDateValeur;
   private Date sortDate;
   private String sortModeleImp;
   private Date sortDateImpression;
   private String sortCodeCaiss;
   private String sortLibCaiss;
   private String sortCodeBanq;
   private String sortLibBanq;
   private String sortBanqueTireur;
   private String sortNumChqBdx;
   private int sortEtatVal;
   private int sortPosSignature;
   private Date sortDateValide;
   private String sortCodeBudgetTreso;
   private String sortCodePosteTreso;
   private String sortOperation;
   private String sortActiviteCompte;
   private float sortActiviteTaux;
   private boolean sortActiviteExo;
   private String sortInfo1;
   private String sortInfo2;
   private String sortInfo3;
   private String sortInfo4;
   private String sortInfo5;
   private String sortInfo6;
   private String sortInfo7;
   private String sortInfo8;
   private String sortInfo9;
   private String sortInfo10;
   private ExercicesCaisse exercicesCaisse;
   private String var_lib_nat;
   private String libelleTypeTiers;
   private String var_etat;
   private String lib_activite;
   private String var_compte;
   private String var_banque;
   private String var_nomBanquier;
   private String var_adresseBanque;
   private String var_villeBanque;
   private String var_adresseTiers;
   private String var_nomTiers;
   private String var_fonctionResponsable;
   private String var_nom_createur;
   private String var_num_nif;

   public String getVar_num_nif() {
      return this.var_num_nif;
   }

   public void setVar_num_nif(String var1) {
      this.var_num_nif = var1;
   }

   public String getVar_nom_createur() {
      return this.var_nom_createur;
   }

   public void setVar_nom_createur(String var1) {
      this.var_nom_createur = var1;
   }

   public String getVar_adresseTiers() {
      return this.var_adresseTiers;
   }

   public void setVar_adresseTiers(String var1) {
      this.var_adresseTiers = var1;
   }

   public String getVar_fonctionResponsable() {
      return this.var_fonctionResponsable;
   }

   public void setVar_fonctionResponsable(String var1) {
      this.var_fonctionResponsable = var1;
   }

   public String getVar_nomTiers() {
      return this.var_nomTiers;
   }

   public void setVar_nomTiers(String var1) {
      this.var_nomTiers = var1;
   }

   public String getVar_adresseBanque() {
      return this.var_adresseBanque;
   }

   public void setVar_adresseBanque(String var1) {
      this.var_adresseBanque = var1;
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

   public String getVar_nomBanquier() {
      return this.var_nomBanquier;
   }

   public void setVar_nomBanquier(String var1) {
      this.var_nomBanquier = var1;
   }

   public String getVar_villeBanque() {
      return this.var_villeBanque;
   }

   public void setVar_villeBanque(String var1) {
      this.var_villeBanque = var1;
   }

   public String getLibelleTypeTiers() {
      if (this.sortTypeTiers == 0) {
         this.libelleTypeTiers = "Client";
      } else if (this.sortTypeTiers == 1) {
         this.libelleTypeTiers = "Fournisseur";
      } else if (this.sortTypeTiers == 2) {
         this.libelleTypeTiers = "Agent";
      } else if (this.sortTypeTiers == 3) {
         this.libelleTypeTiers = "Plan Comptable";
      } else if (this.sortTypeTiers == 4) {
         this.libelleTypeTiers = "Patient";
      } else if (this.sortTypeTiers == 5) {
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
      if (this.sortEtat == 0) {
         this.var_etat = "En cours";
      } else if (this.sortEtat == 1) {
         this.var_etat = "Validé";
      } else if (this.sortEtat == 2) {
         this.var_etat = "Gelé";
      } else if (this.sortEtat == 3) {
         this.var_etat = "Correction";
      } else if (this.sortEtat == 4) {
         this.var_etat = "Exécuté";
      } else if (this.sortEtat == 5) {
         this.var_etat = "Rejeté";
      }

      return this.var_etat;
   }

   public void setVar_etat(String var1) {
      this.var_etat = var1;
   }

   public String getLib_activite() {
      if (this.sortActivite != null && !this.sortActivite.isEmpty()) {
         if (this.sortActivite.startsWith("null")) {
            this.lib_activite = "";
         } else {
            this.lib_activite = this.sortActivite;
         }
      } else {
         this.lib_activite = "";
      }

      return this.lib_activite;
   }

   public void setLib_activite(String var1) {
      this.lib_activite = var1;
   }

   public ExercicesCaisse getExercicesCaisse() {
      return this.exercicesCaisse;
   }

   public void setExercicesCaisse(ExercicesCaisse var1) {
      this.exercicesCaisse = var1;
   }

   public int getSortActif() {
      return this.sortActif;
   }

   public void setSortActif(int var1) {
      this.sortActif = var1;
   }

   public String getSortActivite() {
      return this.sortActivite;
   }

   public void setSortActivite(String var1) {
      this.sortActivite = var1;
   }

   public String getSortBudget() {
      return this.sortBudget;
   }

   public void setSortBudget(String var1) {
      this.sortBudget = var1;
   }

   public Date getSortDate() {
      return this.sortDate;
   }

   public void setSortDate(Date var1) {
      this.sortDate = var1;
   }

   public Date getSortDateCreat() {
      return this.sortDateCreat;
   }

   public void setSortDateCreat(Date var1) {
      this.sortDateCreat = var1;
   }

   public Date getSortDateModif() {
      return this.sortDateModif;
   }

   public void setSortDateModif(Date var1) {
      this.sortDateModif = var1;
   }

   public Date getSortDateValeur() {
      return this.sortDateValeur;
   }

   public void setSortDateValeur(Date var1) {
      this.sortDateValeur = var1;
   }

   public String getSortDepartement() {
      return this.sortDepartement;
   }

   public void setSortDepartement(String var1) {
      this.sortDepartement = var1;
   }

   public String getSortDevise() {
      return this.sortDevise;
   }

   public void setSortDevise(String var1) {
      this.sortDevise = var1;
   }

   public int getSortEtat() {
      return this.sortEtat;
   }

   public void setSortEtat(int var1) {
      this.sortEtat = var1;
   }

   public long getSortId() {
      return this.sortId;
   }

   public void setSortId(long var1) {
      this.sortId = var1;
   }

   public String getSortLibelle() {
      return this.sortLibelle;
   }

   public void setSortLibelle(String var1) {
      this.sortLibelle = var1;
   }

   public String getSortModeleImp() {
      return this.sortModeleImp;
   }

   public void setSortModeleImp(String var1) {
      this.sortModeleImp = var1;
   }

   public double getSortMontant() {
      return this.sortMontant;
   }

   public void setSortMontant(double var1) {
      this.sortMontant = var1;
   }

   public int getSortNature() {
      return this.sortNature;
   }

   public void setSortNature(int var1) {
      this.sortNature = var1;
   }

   public String getSortNomResponsable() {
      return this.sortNomResponsable;
   }

   public void setSortNomResponsable(String var1) {
      this.sortNomResponsable = var1;
   }

   public String getSortNomTiers() {
      return this.sortNomTiers;
   }

   public void setSortNomTiers(String var1) {
      this.sortNomTiers = var1;
   }

   public String getSortNum() {
      return this.sortNum;
   }

   public void setSortNum(String var1) {
      this.sortNum = var1;
   }

   public String getSortPdv() {
      return this.sortPdv;
   }

   public void setSortPdv(String var1) {
      this.sortPdv = var1;
   }

   public String getSortRegion() {
      return this.sortRegion;
   }

   public void setSortRegion(String var1) {
      this.sortRegion = var1;
   }

   public String getSortSecteur() {
      return this.sortSecteur;
   }

   public void setSortSecteur(String var1) {
      this.sortSecteur = var1;
   }

   public String getSortSerie() {
      return this.sortSerie;
   }

   public void setSortSerie(String var1) {
      this.sortSerie = var1;
   }

   public String getSortService() {
      return this.sortService;
   }

   public void setSortService(String var1) {
      this.sortService = var1;
   }

   public String getSortSite() {
      return this.sortSite;
   }

   public void setSortSite(String var1) {
      this.sortSite = var1;
   }

   public int getSortTypeReg() {
      return this.sortTypeReg;
   }

   public void setSortTypeReg(int var1) {
      this.sortTypeReg = var1;
   }

   public String getSortCle() {
      return this.sortCle;
   }

   public void setSortCle(String var1) {
      this.sortCle = var1;
   }

   public int getSortTypeTiers() {
      return this.sortTypeTiers;
   }

   public void setSortTypeTiers(int var1) {
      this.sortTypeTiers = var1;
   }

   public String getSortLibCaiss() {
      return this.sortLibCaiss;
   }

   public void setSortLibCaiss(String var1) {
      this.sortLibCaiss = var1;
   }

   public String getSortCodeCaiss() {
      return this.sortCodeCaiss;
   }

   public void setSortCodeCaiss(String var1) {
      this.sortCodeCaiss = var1;
   }

   public String getSortCodeBanq() {
      return this.sortCodeBanq;
   }

   public void setSortCodeBanq(String var1) {
      this.sortCodeBanq = var1;
   }

   public String getSortLibBanq() {
      return this.sortLibBanq;
   }

   public void setSortLibBanq(String var1) {
      this.sortLibBanq = var1;
   }

   public long getSortUserCreat() {
      return this.sortUserCreat;
   }

   public void setSortUserCreat(long var1) {
      this.sortUserCreat = var1;
   }

   public long getSortUserModif() {
      return this.sortUserModif;
   }

   public void setSortUserModif(long var1) {
      this.sortUserModif = var1;
   }

   public long getSortIdTiers() {
      return this.sortIdTiers;
   }

   public void setSortIdTiers(long var1) {
      this.sortIdTiers = var1;
   }

   public Date getSortDateImpression() {
      return this.sortDateImpression;
   }

   public void setSortDateImpression(Date var1) {
      this.sortDateImpression = var1;
   }

   public int getSortDepotTiers() {
      return this.sortDepotTiers;
   }

   public void setSortDepotTiers(int var1) {
      this.sortDepotTiers = var1;
   }

   public String getSortBanqueTireur() {
      return this.sortBanqueTireur;
   }

   public void setSortBanqueTireur(String var1) {
      this.sortBanqueTireur = var1;
   }

   public String getSortNumChqBdx() {
      return this.sortNumChqBdx;
   }

   public void setSortNumChqBdx(String var1) {
      this.sortNumChqBdx = var1;
   }

   public String getSortDossier() {
      return this.sortDossier;
   }

   public void setSortDossier(String var1) {
      this.sortDossier = var1;
   }

   public String getSortParc() {
      return this.sortParc;
   }

   public void setSortParc(String var1) {
      this.sortParc = var1;
   }

   public double getSortBudgetDispo() {
      return this.sortBudgetDispo;
   }

   public void setSortBudgetDispo(double var1) {
      this.sortBudgetDispo = var1;
   }

   public double getSortBudgetDispoMois() {
      return this.sortBudgetDispoMois;
   }

   public void setSortBudgetDispoMois(double var1) {
      this.sortBudgetDispoMois = var1;
   }

   public double getSortBudgetTreso() {
      return this.sortBudgetTreso;
   }

   public void setSortBudgetTreso(double var1) {
      this.sortBudgetTreso = var1;
   }

   public double getSortBudgetTresoMois() {
      return this.sortBudgetTresoMois;
   }

   public void setSortBudgetTresoMois(double var1) {
      this.sortBudgetTresoMois = var1;
   }

   public Date getSortDateValide() {
      return this.sortDateValide;
   }

   public void setSortDateValide(Date var1) {
      this.sortDateValide = var1;
   }

   public int getSortEtatVal() {
      return this.sortEtatVal;
   }

   public void setSortEtatVal(int var1) {
      this.sortEtatVal = var1;
   }

   public String getSortCle1Repartition() {
      return this.sortCle1Repartition;
   }

   public void setSortCle1Repartition(String var1) {
      this.sortCle1Repartition = var1;
   }

   public String getSortCle2Repartition() {
      return this.sortCle2Repartition;
   }

   public void setSortCle2Repartition(String var1) {
      this.sortCle2Repartition = var1;
   }

   public String getSortCodeBudgetTreso() {
      return this.sortCodeBudgetTreso;
   }

   public void setSortCodeBudgetTreso(String var1) {
      this.sortCodeBudgetTreso = var1;
   }

   public String getSortCodePosteTreso() {
      return this.sortCodePosteTreso;
   }

   public void setSortCodePosteTreso(String var1) {
      this.sortCodePosteTreso = var1;
   }

   public String getSortOperation() {
      return this.sortOperation;
   }

   public void setSortOperation(String var1) {
      this.sortOperation = var1;
   }

   public String getSortDocument() {
      return this.sortDocument;
   }

   public void setSortDocument(String var1) {
      this.sortDocument = var1;
   }

   public String getSortObjet() {
      return this.sortObjet;
   }

   public void setSortObjet(String var1) {
      this.sortObjet = var1;
   }

   public long getSortIdResponsable() {
      return this.sortIdResponsable;
   }

   public void setSortIdResponsable(long var1) {
      this.sortIdResponsable = var1;
   }

   public String getSortActiviteCompte() {
      return this.sortActiviteCompte;
   }

   public void setSortActiviteCompte(String var1) {
      this.sortActiviteCompte = var1;
   }

   public boolean isSortActiviteExo() {
      return this.sortActiviteExo;
   }

   public void setSortActiviteExo(boolean var1) {
      this.sortActiviteExo = var1;
   }

   public float getSortActiviteTaux() {
      return this.sortActiviteTaux;
   }

   public void setSortActiviteTaux(float var1) {
      this.sortActiviteTaux = var1;
   }

   public String getSortInfo1() {
      return this.sortInfo1;
   }

   public void setSortInfo1(String var1) {
      this.sortInfo1 = var1;
   }

   public String getSortInfo10() {
      return this.sortInfo10;
   }

   public void setSortInfo10(String var1) {
      this.sortInfo10 = var1;
   }

   public String getSortInfo2() {
      return this.sortInfo2;
   }

   public void setSortInfo2(String var1) {
      this.sortInfo2 = var1;
   }

   public String getSortInfo3() {
      return this.sortInfo3;
   }

   public void setSortInfo3(String var1) {
      this.sortInfo3 = var1;
   }

   public String getSortInfo4() {
      return this.sortInfo4;
   }

   public void setSortInfo4(String var1) {
      this.sortInfo4 = var1;
   }

   public String getSortInfo5() {
      return this.sortInfo5;
   }

   public void setSortInfo5(String var1) {
      this.sortInfo5 = var1;
   }

   public String getSortInfo6() {
      return this.sortInfo6;
   }

   public void setSortInfo6(String var1) {
      this.sortInfo6 = var1;
   }

   public String getSortInfo7() {
      return this.sortInfo7;
   }

   public void setSortInfo7(String var1) {
      this.sortInfo7 = var1;
   }

   public String getSortInfo8() {
      return this.sortInfo8;
   }

   public void setSortInfo8(String var1) {
      this.sortInfo8 = var1;
   }

   public String getSortInfo9() {
      return this.sortInfo9;
   }

   public void setSortInfo9(String var1) {
      this.sortInfo9 = var1;
   }

   public Date getSortDateValidation() {
      return this.sortDateValidation;
   }

   public void setSortDateValidation(Date var1) {
      this.sortDateValidation = var1;
   }

   public long getSortUserValidation() {
      return this.sortUserValidation;
   }

   public void setSortUserValidation(long var1) {
      this.sortUserValidation = var1;
   }

   public String getSortGrp() {
      return this.sortGrp;
   }

   public void setSortGrp(String var1) {
      this.sortGrp = var1;
   }

   public int getSortPosSignature() {
      return this.sortPosSignature;
   }

   public void setSortPosSignature(int var1) {
      this.sortPosSignature = var1;
   }

   public int getSortGele() {
      return this.sortGele;
   }

   public void setSortGele(int var1) {
      this.sortGele = var1;
   }

   public boolean isSortPj() {
      return this.sortPj;
   }

   public void setSortPj(boolean var1) {
      this.sortPj = var1;
   }

   public String getSortSource() {
      return this.sortSource;
   }

   public void setSortSource(String var1) {
      this.sortSource = var1;
   }
}
