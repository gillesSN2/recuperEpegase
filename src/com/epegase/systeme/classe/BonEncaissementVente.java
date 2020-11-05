package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BonEncaissementVente implements Serializable {
   private long bonId;
   private Date bonDateCreat;
   private Date bonDateModif;
   private Date bonDateAnnule;
   private long bonUserCreat;
   private long bonUserModif;
   private long bonUserAnnule;
   private String bonMotifAnnule;
   private String bonGrp;
   private String bonRef;
   private long bonIdRef;
   private int bonNatRef;
   private String bonChg;
   private long bonIdChg;
   private String bonCodeCaisse;
   private String bonLibCaisse;
   private String bonNum;
   private Date bonDate;
   private String bonNomTiers;
   private long bonIdTiers;
   private int bonTypeTiers;
   private long bonIdContact;
   private String bonNomContact;
   private String bonObservation;
   private String bonSerie;
   private String bonObject;
   private String bonDevise;
   private double bonTotTtc;
   private double bonAPayer;
   private double bonAPayerReliquat;
   private Date bonDateRemise;
   private Date bonDateEcheReg;
   private int bonTypeReg;
   private String bonActivite;
   private String bonSite;
   private String bonDepartement;
   private String bonService;
   private String bonRegion;
   private String bonSecteur;
   private String bonPdv;
   private String bonBudget;
   private int bonEtat;
   private String bonCodeBanq;
   private String bonLibBanq;
   private int bonActif;
   private int bonPosSignature;
   private String bonLibelle;
   private Date bonDateValeur;
   private Date bonDateRelance;
   private String bonModeleImp;
   private int bonMode;
   private double bonEncaisse;
   private double bonRendu;
   private boolean bonGarde;
   private String bonBanqueTireur;
   private String bonNumChqBdx;
   private String bonFacture;
   private String bonClient;
   private String bonMontant;
   private String bonCodeBudgetTreso;
   private String bonCodePosteTreso;
   private long bonIdResponsable;
   private String bonNomResponsable;
   private long bonIdCommercial;
   private String bonNomCommercial;
   private long bonIdEquipe;
   private String bonNomEquipe;
   private String bonLettreGarantie;
   private int bonType;
   private String var_lib_nat;
   private String var_lib_mode_reg;
   private int var_format_devise;
   private String var_lib_type;

   public String getVar_lib_type() {
      if (this.bonType == 1) {
         this.var_lib_type = "Appel de fonds";
      } else if (this.bonType == 0) {
         this.var_lib_type = "Bon encaissement";
      }

      return this.var_lib_type;
   }

   public void setVar_lib_type(String var1) {
      this.var_lib_type = var1;
   }

   public String getVar_lib_mode_reg() {
      if (this.bonTypeReg == 0) {
         this.var_lib_mode_reg = "Comptant";
      } else if (this.bonTypeReg == 1) {
         this.var_lib_mode_reg = "Terme date de facture";
      } else if (this.bonTypeReg == 2) {
         this.var_lib_mode_reg = "Terme fin mois";
      } else if (this.bonTypeReg == 3) {
         this.var_lib_mode_reg = "arrivée/payée";
      } else if (this.bonTypeReg == 4) {
         this.var_lib_mode_reg = "B.Encaissement";
      }

      return this.var_lib_mode_reg;
   }

   public void setVar_lib_mode_reg(String var1) {
      this.var_lib_mode_reg = var1;
   }

   public String getVar_lib_nat() {
      if (this.bonNatRef == 7) {
         this.var_lib_nat = "Commission";
      } else if (this.bonNatRef == 12) {
         this.var_lib_nat = "Commande fournisseur";
      } else if (this.bonNatRef == 15) {
         this.var_lib_nat = "Facture fournisseur";
      } else if (this.bonNatRef == 16) {
         this.var_lib_nat = "Avoir fournisseur";
      } else if (this.bonNatRef == 17) {
         this.var_lib_nat = "Note débit fournisseur";
      } else if (this.bonNatRef == 18) {
         this.var_lib_nat = "Frais";
      } else if (this.bonNatRef == 21) {
         this.var_lib_nat = "Devis";
      } else if (this.bonNatRef == 22) {
         this.var_lib_nat = "Bon commande client";
      } else if (this.bonNatRef == 23) {
         this.var_lib_nat = "Bon livraison client";
      } else if (this.bonNatRef == 25) {
         this.var_lib_nat = "Facture client";
      } else if (this.bonNatRef == 26) {
         this.var_lib_nat = "Avoir client";
      } else if (this.bonNatRef == 27) {
         this.var_lib_nat = "Note de débit client";
      } else if (this.bonNatRef == 28) {
         this.var_lib_nat = "Frais Chargement";
      } else if (this.bonNatRef == 71) {
         this.var_lib_nat = "Consultation Géné.";
      } else if (this.bonNatRef == 72) {
         this.var_lib_nat = "Consultation Spéc.";
      } else if (this.bonNatRef == 73) {
         this.var_lib_nat = "Pharmacie";
      } else if (this.bonNatRef == 74) {
         this.var_lib_nat = "Laboratoire";
      } else if (this.bonNatRef == 76) {
         this.var_lib_nat = "Hospitalisation";
      } else if (this.bonNatRef == 78) {
         this.var_lib_nat = "Refacturation";
      } else if (this.bonNatRef == 102) {
         this.var_lib_nat = "Facture école";
      } else if (this.bonNatRef == 165) {
         this.var_lib_nat = "Facture location";
      } else if (this.bonNatRef == 173) {
         this.var_lib_nat = "Appel de charges";
      } else {
         this.var_lib_nat = "???";
      }

      return this.var_lib_nat;
   }

   public void setVar_lib_nat(String var1) {
      this.var_lib_nat = var1;
   }

   public int getVar_format_devise() {
      if (!this.bonDevise.equals("XOF") && !this.bonDevise.equals("XAF")) {
         if (!this.bonDevise.equals("EUR") && !this.bonDevise.equals("XEU") && !this.bonDevise.equals("CHF")) {
            this.var_format_devise = 0;
         } else {
            this.var_format_devise = 1;
         }
      } else {
         this.var_format_devise = 2;
      }

      return this.var_format_devise;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public String getBonActivite() {
      return this.bonActivite;
   }

   public void setBonActivite(String var1) {
      this.bonActivite = var1;
   }

   public Date getBonDate() {
      return this.bonDate;
   }

   public void setBonDate(Date var1) {
      this.bonDate = var1;
   }

   public Date getBonDateCreat() {
      return this.bonDateCreat;
   }

   public void setBonDateCreat(Date var1) {
      this.bonDateCreat = var1;
   }

   public Date getBonDateEcheReg() {
      return this.bonDateEcheReg;
   }

   public void setBonDateEcheReg(Date var1) {
      this.bonDateEcheReg = var1;
   }

   public Date getBonDateRelance() {
      return this.bonDateRelance;
   }

   public void setBonDateRelance(Date var1) {
      this.bonDateRelance = var1;
   }

   public int getBonEtat() {
      return this.bonEtat;
   }

   public void setBonEtat(int var1) {
      this.bonEtat = var1;
   }

   public long getBonId() {
      return this.bonId;
   }

   public void setBonId(long var1) {
      this.bonId = var1;
   }

   public long getBonUserCreat() {
      return this.bonUserCreat;
   }

   public void setBonUserCreat(long var1) {
      this.bonUserCreat = var1;
   }

   public long getBonUserModif() {
      return this.bonUserModif;
   }

   public void setBonUserModif(long var1) {
      this.bonUserModif = var1;
   }

   public String getBonNomResponsable() {
      return this.bonNomResponsable;
   }

   public void setBonNomResponsable(String var1) {
      this.bonNomResponsable = var1;
   }

   public String getBonNomTiers() {
      return this.bonNomTiers;
   }

   public void setBonNomTiers(String var1) {
      this.bonNomTiers = var1;
   }

   public String getBonNum() {
      return this.bonNum;
   }

   public void setBonNum(String var1) {
      this.bonNum = var1;
   }

   public String getBonObject() {
      return this.bonObject;
   }

   public void setBonObject(String var1) {
      this.bonObject = var1;
   }

   public String getBonSerie() {
      return this.bonSerie;
   }

   public void setBonSerie(String var1) {
      this.bonSerie = var1;
   }

   public double getBonTotTtc() {
      return this.bonTotTtc;
   }

   public void setBonTotTtc(double var1) {
      this.bonTotTtc = var1;
   }

   public double getBonAPayer() {
      return this.bonAPayer;
   }

   public void setBonAPayer(double var1) {
      this.bonAPayer = var1;
   }

   public int getBonTypeReg() {
      return this.bonTypeReg;
   }

   public void setBonTypeReg(int var1) {
      this.bonTypeReg = var1;
   }

   public String getBonBudget() {
      return this.bonBudget;
   }

   public void setBonBudget(String var1) {
      this.bonBudget = var1;
   }

   public String getBonDepartement() {
      return this.bonDepartement;
   }

   public void setBonDepartement(String var1) {
      this.bonDepartement = var1;
   }

   public String getBonPdv() {
      return this.bonPdv;
   }

   public void setBonPdv(String var1) {
      this.bonPdv = var1;
   }

   public String getBonRegion() {
      return this.bonRegion;
   }

   public void setBonRegion(String var1) {
      this.bonRegion = var1;
   }

   public String getBonSecteur() {
      return this.bonSecteur;
   }

   public void setBonSecteur(String var1) {
      this.bonSecteur = var1;
   }

   public String getBonService() {
      return this.bonService;
   }

   public void setBonService(String var1) {
      this.bonService = var1;
   }

   public String getBonSite() {
      return this.bonSite;
   }

   public void setBonSite(String var1) {
      this.bonSite = var1;
   }

   public String getBonDevise() {
      return this.bonDevise;
   }

   public void setBonDevise(String var1) {
      this.bonDevise = var1;
   }

   public String getBonModeleImp() {
      return this.bonModeleImp;
   }

   public void setBonModeleImp(String var1) {
      this.bonModeleImp = var1;
   }

   public int getBonMode() {
      return this.bonMode;
   }

   public void setBonMode(int var1) {
      this.bonMode = var1;
   }

   public Date getBonDateModif() {
      return this.bonDateModif;
   }

   public void setBonDateModif(Date var1) {
      this.bonDateModif = var1;
   }

   public String getBonRef() {
      return this.bonRef;
   }

   public void setBonRef(String var1) {
      this.bonRef = var1;
   }

   public String getBonObservation() {
      return this.bonObservation;
   }

   public void setBonObservation(String var1) {
      this.bonObservation = var1;
   }

   public Date getBonDateValeur() {
      return this.bonDateValeur;
   }

   public void setBonDateValeur(Date var1) {
      this.bonDateValeur = var1;
   }

   public String getBonLibelle() {
      return this.bonLibelle;
   }

   public void setBonLibelle(String var1) {
      this.bonLibelle = var1;
   }

   public int getBonActif() {
      return this.bonActif;
   }

   public void setBonActif(int var1) {
      this.bonActif = var1;
   }

   public String getBonCodeCaisse() {
      return this.bonCodeCaisse;
   }

   public void setBonCodeCaisse(String var1) {
      this.bonCodeCaisse = var1;
   }

   public String getBonLibCaisse() {
      return this.bonLibCaisse;
   }

   public void setBonLibCaisse(String var1) {
      this.bonLibCaisse = var1;
   }

   public String getBonCodeBanq() {
      return this.bonCodeBanq;
   }

   public void setBonCodeBanq(String var1) {
      this.bonCodeBanq = var1;
   }

   public String getBonLibBanq() {
      return this.bonLibBanq;
   }

   public void setBonLibBanq(String var1) {
      this.bonLibBanq = var1;
   }

   public long getBonIdTiers() {
      return this.bonIdTiers;
   }

   public void setBonIdTiers(long var1) {
      this.bonIdTiers = var1;
   }

   public int getBonTypeTiers() {
      return this.bonTypeTiers;
   }

   public void setBonTypeTiers(int var1) {
      this.bonTypeTiers = var1;
   }

   public long getBonIdRef() {
      return this.bonIdRef;
   }

   public void setBonIdRef(long var1) {
      this.bonIdRef = var1;
   }

   public int getBonNatRef() {
      return this.bonNatRef;
   }

   public void setBonNatRef(int var1) {
      this.bonNatRef = var1;
   }

   public double getBonEncaisse() {
      return this.bonEncaisse;
   }

   public void setBonEncaisse(double var1) {
      this.bonEncaisse = var1;
   }

   public boolean isBonGarde() {
      return this.bonGarde;
   }

   public void setBonGarde(boolean var1) {
      this.bonGarde = var1;
   }

   public double getBonRendu() {
      return this.bonRendu;
   }

   public void setBonRendu(double var1) {
      this.bonRendu = var1;
   }

   public String getBonBanqueTireur() {
      return this.bonBanqueTireur;
   }

   public void setBonBanqueTireur(String var1) {
      this.bonBanqueTireur = var1;
   }

   public String getBonNumChqBdx() {
      return this.bonNumChqBdx;
   }

   public void setBonNumChqBdx(String var1) {
      this.bonNumChqBdx = var1;
   }

   public long getBonIdContact() {
      return this.bonIdContact;
   }

   public void setBonIdContact(long var1) {
      this.bonIdContact = var1;
   }

   public String getBonNomContact() {
      return this.bonNomContact;
   }

   public void setBonNomContact(String var1) {
      this.bonNomContact = var1;
   }

   public String getBonChg() {
      return this.bonChg;
   }

   public void setBonChg(String var1) {
      this.bonChg = var1;
   }

   public long getBonIdChg() {
      return this.bonIdChg;
   }

   public void setBonIdChg(long var1) {
      this.bonIdChg = var1;
   }

   public String getBonClient() {
      return this.bonClient;
   }

   public void setBonClient(String var1) {
      this.bonClient = var1;
   }

   public String getBonFacture() {
      return this.bonFacture;
   }

   public void setBonFacture(String var1) {
      this.bonFacture = var1;
   }

   public String getBonMontant() {
      return this.bonMontant;
   }

   public void setBonMontant(String var1) {
      this.bonMontant = var1;
   }

   public String getBonCodeBudgetTreso() {
      return this.bonCodeBudgetTreso;
   }

   public void setBonCodeBudgetTreso(String var1) {
      this.bonCodeBudgetTreso = var1;
   }

   public String getBonCodePosteTreso() {
      return this.bonCodePosteTreso;
   }

   public void setBonCodePosteTreso(String var1) {
      this.bonCodePosteTreso = var1;
   }

   public long getBonIdCommercial() {
      return this.bonIdCommercial;
   }

   public void setBonIdCommercial(long var1) {
      this.bonIdCommercial = var1;
   }

   public long getBonIdEquipe() {
      return this.bonIdEquipe;
   }

   public void setBonIdEquipe(long var1) {
      this.bonIdEquipe = var1;
   }

   public String getBonNomCommercial() {
      return this.bonNomCommercial;
   }

   public void setBonNomCommercial(String var1) {
      this.bonNomCommercial = var1;
   }

   public String getBonNomEquipe() {
      return this.bonNomEquipe;
   }

   public void setBonNomEquipe(String var1) {
      this.bonNomEquipe = var1;
   }

   public long getBonIdResponsable() {
      return this.bonIdResponsable;
   }

   public void setBonIdResponsable(long var1) {
      this.bonIdResponsable = var1;
   }

   public double getBonAPayerReliquat() {
      return this.bonAPayerReliquat;
   }

   public void setBonAPayerReliquat(double var1) {
      this.bonAPayerReliquat = var1;
   }

   public String getBonLettreGarantie() {
      return this.bonLettreGarantie;
   }

   public void setBonLettreGarantie(String var1) {
      this.bonLettreGarantie = var1;
   }

   public String getBonGrp() {
      return this.bonGrp;
   }

   public void setBonGrp(String var1) {
      this.bonGrp = var1;
   }

   public int getBonPosSignature() {
      return this.bonPosSignature;
   }

   public void setBonPosSignature(int var1) {
      this.bonPosSignature = var1;
   }

   public Date getBonDateRemise() {
      return this.bonDateRemise;
   }

   public void setBonDateRemise(Date var1) {
      this.bonDateRemise = var1;
   }

   public Date getBonDateAnnule() {
      return this.bonDateAnnule;
   }

   public void setBonDateAnnule(Date var1) {
      this.bonDateAnnule = var1;
   }

   public String getBonMotifAnnule() {
      return this.bonMotifAnnule;
   }

   public void setBonMotifAnnule(String var1) {
      this.bonMotifAnnule = var1;
   }

   public long getBonUserAnnule() {
      return this.bonUserAnnule;
   }

   public void setBonUserAnnule(long var1) {
      this.bonUserAnnule = var1;
   }

   public int getBonType() {
      return this.bonType;
   }

   public void setBonType(int var1) {
      this.bonType = var1;
   }
}
