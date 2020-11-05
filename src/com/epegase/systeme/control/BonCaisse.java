package com.epegase.systeme.control;

import java.io.Serializable;
import java.util.Date;

public class BonCaisse implements Serializable {
   private long bonCaisId;
   private int bonCaisNature;
   private String bonCaisOperation;
   private String bonCaisNum;
   private String bonCaisNumOrigine;
   private long bonCaisIdOrigine;
   private Date bonCaisDate;
   private Date bonCaisDateRemise;
   private String bonCaisNomResponsable;
   private long bonCaisIdTiers;
   private String bonCaisNomTiers;
   private int bonCaisTypeTiers;
   private String bonCaisSerie;
   private String bonCaisDevise;
   private double bonCaisMontant;
   private int bonCaisTypeReg;
   private String bonCaisActivite;
   private String bonCaisLibelle;
   private String bonCaisCodeCaiss;
   private String bonCaisLibCaiss;
   private String bonCaisCodeBanqEmetteur;
   private String bonCaisLibBanqEmetteur;
   private String bonCaisCodeBanqRecepteur;
   private String bonCaisLibBanqRecepteur;
   private boolean bonCaisDepot;
   private String bonCaisModeleImp;
   private Date bonDateTransfert;
   private Date bonDateCloture;
   private String bonCaisFacture;
   private String bonCaisService;
   private String bonCaisClient;
   private Date bonDateMvt2;
   private Date bonCaisDateEncaissement;
   private Date bonCaisDateRejet;
   private String bonCaisNumChqBdx;
   private String bonCaisBanqueTirreur;
   private String bonGrp;
   private boolean bonAnnuler;
   private String var_lib_nat;
   private String libelleTypeTiers;
   private String libelleTypeReg;
   private int origine;
   private String var_etat;
   private BonCaisse bonCaissePrint;
   private String libelleOperation;
   private double depense;
   private double recette;
   private double timbre;
   private String lib_activite;
   private String color;

   public String getColor() {
      if (this.bonCaisDateRemise != null) {
         if (this.bonCaisDateRemise.compareTo(this.bonCaisDate) > 0) {
            this.color = "color:red";
         } else {
            this.color = "color:black";
         }
      } else {
         this.color = "color:black";
      }

      return this.color;
   }

   public void setColor(String var1) {
      this.color = var1;
   }

   public String getLib_activite() {
      if (this.bonCaisActivite != null && !this.bonCaisActivite.isEmpty()) {
         if (this.bonCaisActivite.startsWith("null")) {
            this.lib_activite = "";
         } else {
            this.lib_activite = this.bonCaisActivite;
         }
      } else {
         this.lib_activite = "";
      }

      return this.lib_activite;
   }

   public void setLib_activite(String var1) {
      this.lib_activite = var1;
   }

   public double getDepense() {
      if (this.bonCaisOperation != null && !this.bonCaisOperation.isEmpty()) {
         if (!this.bonCaisOperation.startsWith("2") && !this.bonCaisOperation.startsWith("5")) {
            if (!this.bonCaisOperation.startsWith("7") && !this.bonCaisOperation.startsWith("8")) {
               this.depense = 0.0D;
            } else if (!this.bonCaisOperation.equals("83") && !this.bonCaisOperation.equals("85")) {
               if (this.bonCaisCodeBanqEmetteur != null && !this.bonCaisCodeBanqEmetteur.isEmpty() && this.bonCaisCodeBanqRecepteur != null && !this.bonCaisCodeBanqRecepteur.isEmpty()) {
                  this.depense = this.bonCaisMontant;
               } else {
                  this.depense = 0.0D;
               }
            } else {
               this.depense = this.bonCaisMontant;
            }
         } else {
            this.depense = this.bonCaisMontant;
         }
      } else if (this.bonCaisTypeTiers != 1 && this.bonCaisTypeTiers != 2 && this.bonCaisTypeTiers != 3) {
         this.depense = 0.0D;
      } else {
         this.depense = this.bonCaisMontant;
      }

      return this.depense;
   }

   public void setDepense(double var1) {
      this.depense = var1;
   }

   public double getRecette() {
      if (this.bonCaisOperation != null && !this.bonCaisOperation.isEmpty()) {
         if (!this.bonCaisOperation.startsWith("0") && !this.bonCaisOperation.startsWith("1")) {
            if (!this.bonCaisOperation.startsWith("7") && !this.bonCaisOperation.startsWith("8")) {
               this.recette = 0.0D;
            } else if (!this.bonCaisOperation.equals("83") && !this.bonCaisOperation.equals("85")) {
               if ((this.bonCaisCodeBanqEmetteur == null || this.bonCaisCodeBanqEmetteur.isEmpty() || this.bonCaisCodeBanqRecepteur != null && !this.bonCaisCodeBanqRecepteur.isEmpty()) && this.bonDateMvt2 == null) {
                  this.recette = 0.0D;
               } else {
                  this.recette = this.bonCaisMontant;
               }
            } else {
               this.recette = 0.0D;
            }
         } else {
            this.recette = this.bonCaisMontant;
         }
      } else if (this.bonCaisTypeTiers != 0 && this.bonCaisTypeTiers != 4 && this.bonCaisTypeTiers != 5) {
         this.recette = 0.0D;
      } else {
         this.recette = this.bonCaisMontant;
      }

      return this.recette;
   }

   public void setRecette(double var1) {
      this.recette = var1;
   }

   public double getTimbre() {
      return this.timbre;
   }

   public void setTimbre(double var1) {
      this.timbre = var1;
   }

   public String getVar_etat() {
      if (this.bonDateCloture != null && this.bonDateTransfert == null) {
         this.var_etat = "Clo";
      } else if (this.bonDateCloture != null && this.bonDateTransfert != null) {
         this.var_etat = "Trf";
      } else {
         this.var_etat = "EC";
      }

      return this.var_etat;
   }

   public void setVar_etat(String var1) {
      this.var_etat = var1;
   }

   public String getLibelleTypeReg() {
      if (this.bonCaisTypeReg == 0) {
         this.libelleTypeReg = "Espèces";
      } else if (this.bonCaisTypeReg == 1) {
         this.libelleTypeReg = "Chèques";
      } else if (this.bonCaisTypeReg == 2) {
         this.libelleTypeReg = "Virements";
      } else if (this.bonCaisTypeReg == 3) {
         this.libelleTypeReg = "Traites";
      } else if (this.bonCaisTypeReg == 4) {
         this.libelleTypeReg = "Cartes";
      } else if (this.bonCaisTypeReg == 5) {
         this.libelleTypeReg = "Transferts";
      } else if (this.bonCaisTypeReg == 6) {
         this.libelleTypeReg = "ePaiements";
      } else if (this.bonCaisTypeReg == 7) {
         this.libelleTypeReg = "Credocs";
      } else if (this.bonCaisTypeReg == 8) {
         this.libelleTypeReg = "Factors";
      } else if (this.bonCaisTypeReg == 9) {
         this.libelleTypeReg = "Compense";
      } else if (this.bonCaisTypeReg == 10) {
         this.libelleTypeReg = "Terme";
      } else if (this.bonCaisTypeReg == 11) {
         this.libelleTypeReg = "Espèces sans timbre";
      } else if (this.bonCaisTypeReg == 12) {
         this.libelleTypeReg = "Lettre de garantie";
      } else if (this.bonCaisTypeReg == 13) {
         this.libelleTypeReg = "Prélèvement";
      } else if (this.bonCaisTypeReg == 14) {
         this.libelleTypeReg = "Alcoin";
      }

      return this.libelleTypeReg;
   }

   public void setLibelleTypeReg(String var1) {
      this.libelleTypeReg = var1;
   }

   public String getLibelleTypeTiers() {
      if (this.bonCaisTypeTiers == 0) {
         this.libelleTypeTiers = "Client";
      } else if (this.bonCaisTypeTiers == 1) {
         this.libelleTypeTiers = "Fournisseur";
      } else if (this.bonCaisTypeTiers == 2) {
         this.libelleTypeTiers = "Agent";
      } else if (this.bonCaisTypeTiers == 3) {
         this.libelleTypeTiers = "Plan Comptable";
      } else if (this.bonCaisTypeTiers == 4) {
         this.libelleTypeTiers = "Patient";
      } else if (this.bonCaisTypeTiers == 5) {
         this.libelleTypeTiers = "Elève";
      }

      return this.libelleTypeTiers;
   }

   public void setLibelleTypeTiers(String var1) {
      this.libelleTypeTiers = var1;
   }

   public String getLibelleOperation() {
      if (this.bonCaisOperation != null && !this.bonCaisOperation.isEmpty()) {
         if (this.bonCaisOperation.equals("01")) {
            this.libelleOperation = "Règlement facture";
         } else if (this.bonCaisOperation.equals("02")) {
            this.libelleOperation = "Acompte facture";
         } else if (this.bonCaisOperation.equals("03")) {
            this.libelleOperation = "Avce/Rmb personnel";
         } else if (this.bonCaisOperation.equals("05")) {
            this.libelleOperation = "Centralisation recette";
         } else if (this.bonCaisOperation.equals("06")) {
            this.libelleOperation = "Régul. erreur";
         } else if (this.bonCaisOperation.equals("10")) {
            this.libelleOperation = "Autres recettes";
         } else if (this.bonCaisOperation.equals("11")) {
            this.libelleOperation = "Traites domicilées";
         } else if (this.bonCaisOperation.equals("12")) {
            this.libelleOperation = "Traites en portefeuille";
         } else if (this.bonCaisOperation.equals("13")) {
            this.libelleOperation = "Déposit client";
         } else if (this.bonCaisOperation.equals("17")) {
            this.libelleOperation = "Ecart caisse";
         } else if (this.bonCaisOperation.equals("18")) {
            this.libelleOperation = "Regul. Ecart caisse";
         } else if (this.bonCaisOperation.equals("19")) {
            this.libelleOperation = "Impyés chèque client";
         } else if (this.bonCaisOperation.equals("20")) {
            this.libelleOperation = "Autres dépenses";
         } else if (this.bonCaisOperation.equals("21")) {
            this.libelleOperation = "Paiement facture fournisseur";
         } else if (this.bonCaisOperation.equals("22")) {
            this.libelleOperation = "Traite société";
         } else if (this.bonCaisOperation.equals("23")) {
            this.libelleOperation = "Avce/Rmb personnel";
         } else if (this.bonCaisOperation.equals("24")) {
            this.libelleOperation = "Paiement commissions";
         } else if (this.bonCaisOperation.equals("25")) {
            this.libelleOperation = "Bon caisse";
         } else if (this.bonCaisOperation.equals("26")) {
            this.libelleOperation = "Regul. Bon caisse";
         } else if (this.bonCaisOperation.equals("27")) {
            this.libelleOperation = "Ecart caisse";
         } else if (this.bonCaisOperation.equals("28")) {
            this.libelleOperation = "Regul. Ecart caisse";
         } else if (this.bonCaisOperation.equals("29")) {
            this.libelleOperation = "Impayés chèque fournisseur";
         } else if (this.bonCaisOperation.equals("50")) {
            this.libelleOperation = "Règlement frais";
         } else if (this.bonCaisOperation.equals("55")) {
            this.libelleOperation = "Paiement salaire";
         } else if (this.bonCaisOperation.equals("71")) {
            this.libelleOperation = "Appro. Caisse/Caisse";
         } else if (this.bonCaisOperation.equals("73")) {
            this.libelleOperation = "Vrt. Banque/Caisse";
         } else if (this.bonCaisOperation.equals("74")) {
            this.libelleOperation = "Vrt. Banque/Banque";
         } else if (this.bonCaisOperation.equals("76")) {
            this.libelleOperation = "Ech. Chèque/Banque";
         } else if (this.bonCaisOperation.equals("77")) {
            this.libelleOperation = "Ech. Chèque/Espèce";
         } else if (this.bonCaisOperation.equals("80")) {
            this.libelleOperation = "Mvt. Caisse/Caisse";
         } else if (this.bonCaisOperation.equals("81")) {
            this.libelleOperation = "Mvt. Chèque/Caisse";
         } else if (this.bonCaisOperation.equals("82")) {
            this.libelleOperation = "Mvt. Traite/Caisse";
         } else if (this.bonCaisOperation.equals("83")) {
            this.libelleOperation = "Rem. Chèque/Banque";
         } else if (this.bonCaisOperation.equals("84")) {
            this.libelleOperation = "Rem. Traite/Banque";
         } else if (this.bonCaisOperation.equals("85")) {
            this.libelleOperation = "Rem. Espèce/Banque";
         } else {
            this.libelleOperation = "";
         }
      } else {
         this.libelleOperation = "";
      }

      return this.libelleOperation;
   }

   public void setLibelleOperation(String var1) {
      this.libelleOperation = var1;
   }

   public String getVar_lib_nat() {
      if (this.bonCaisNature == 0) {
         this.var_lib_nat = "Opération caisse";
      } else if (this.bonCaisNature == 12) {
         this.var_lib_nat = "Commande fournisseur";
      } else if (this.bonCaisNature == 15) {
         this.var_lib_nat = "Facture fournisseur";
      } else if (this.bonCaisNature == 16) {
         this.var_lib_nat = "Avoir fournisseur";
      } else if (this.bonCaisNature == 17) {
         this.var_lib_nat = "Note débit fournisseur";
      } else if (this.bonCaisNature == 18) {
         this.var_lib_nat = "Frais";
      } else if (this.bonCaisNature == 7) {
         this.var_lib_nat = "Commission";
      } else if (this.bonCaisNature == 21) {
         this.var_lib_nat = "Devis";
      } else if (this.bonCaisNature == 22) {
         this.var_lib_nat = "Bon commande client";
      } else if (this.bonCaisNature == 23) {
         this.var_lib_nat = "Bon livraison client";
      } else if (this.bonCaisNature == 25) {
         this.var_lib_nat = "Facture client";
      } else if (this.bonCaisNature == 26) {
         this.var_lib_nat = "Avoir client";
      } else if (this.bonCaisNature == 27) {
         this.var_lib_nat = "Note debit client";
      } else if (this.bonCaisNature == 28) {
         this.var_lib_nat = "Frais chargement";
      } else if (this.bonCaisNature == 29) {
         this.var_lib_nat = "Facture élève";
      } else if (this.bonCaisNature == 60) {
         this.var_lib_nat = "Caisse";
      } else if (this.bonCaisNature == 61) {
         this.var_lib_nat = "Reçu";
      } else if (this.bonCaisNature == 62) {
         this.var_lib_nat = "Bon sortie";
      } else if (this.bonCaisNature == 63) {
         this.var_lib_nat = "Bon entrée";
      } else if (this.bonCaisNature == 64) {
         this.var_lib_nat = "Virement";
      } else if (this.bonCaisNature == 65) {
         this.var_lib_nat = "Ordre paiement";
      } else if (this.bonCaisNature == 71) {
         this.var_lib_nat = "Consult. Géné.";
      } else if (this.bonCaisNature == 72) {
         this.var_lib_nat = "Consult. Spé.";
      } else if (this.bonCaisNature == 73) {
         this.var_lib_nat = "Pharmacie";
      } else if (this.bonCaisNature == 74) {
         this.var_lib_nat = "Laboratoire";
      } else if (this.bonCaisNature == 76) {
         this.var_lib_nat = "Hospitalisation";
      } else if (this.bonCaisNature == 78) {
         this.var_lib_nat = "Refacturation";
      } else if (this.bonCaisNature == 87) {
         this.var_lib_nat = "Paiement prêt";
      } else if (this.bonCaisNature == 88) {
         this.var_lib_nat = "Paiement salaire";
      } else if (this.bonCaisNature == 102) {
         this.var_lib_nat = "Factures Elève";
      } else if (this.bonCaisNature == 165) {
         this.var_lib_nat = "Factures location";
      } else if (this.bonCaisNature == 173) {
         this.var_lib_nat = "Appel de charges";
      } else {
         this.var_lib_nat = "???";
      }

      return this.var_lib_nat;
   }

   public void setVar_lib_nat(String var1) {
      this.var_lib_nat = var1;
   }

   public String getBonCaisActivite() {
      return this.bonCaisActivite;
   }

   public void setBonCaisActivite(String var1) {
      this.bonCaisActivite = var1;
   }

   public String getBonCaisCodeCaiss() {
      return this.bonCaisCodeCaiss;
   }

   public void setBonCaisCodeCaiss(String var1) {
      this.bonCaisCodeCaiss = var1;
   }

   public Date getBonCaisDate() {
      return this.bonCaisDate;
   }

   public void setBonCaisDate(Date var1) {
      this.bonCaisDate = var1;
   }

   public String getBonCaisDevise() {
      return this.bonCaisDevise;
   }

   public void setBonCaisDevise(String var1) {
      this.bonCaisDevise = var1;
   }

   public long getBonCaisId() {
      return this.bonCaisId;
   }

   public void setBonCaisId(long var1) {
      this.bonCaisId = var1;
   }

   public String getBonCaisLibCaiss() {
      return this.bonCaisLibCaiss;
   }

   public void setBonCaisLibCaiss(String var1) {
      this.bonCaisLibCaiss = var1;
   }

   public String getBonCaisLibelle() {
      return this.bonCaisLibelle;
   }

   public void setBonCaisLibelle(String var1) {
      this.bonCaisLibelle = var1;
   }

   public double getBonCaisMontant() {
      return this.bonCaisMontant;
   }

   public void setBonCaisMontant(double var1) {
      this.bonCaisMontant = var1;
   }

   public int getBonCaisNature() {
      return this.bonCaisNature;
   }

   public void setBonCaisNature(int var1) {
      this.bonCaisNature = var1;
   }

   public String getBonCaisNomResponsable() {
      return this.bonCaisNomResponsable;
   }

   public void setBonCaisNomResponsable(String var1) {
      this.bonCaisNomResponsable = var1;
   }

   public String getBonCaisNomTiers() {
      return this.bonCaisNomTiers;
   }

   public void setBonCaisNomTiers(String var1) {
      this.bonCaisNomTiers = var1;
   }

   public String getBonCaisNum() {
      return this.bonCaisNum;
   }

   public void setBonCaisNum(String var1) {
      this.bonCaisNum = var1;
   }

   public String getBonCaisSerie() {
      return this.bonCaisSerie;
   }

   public void setBonCaisSerie(String var1) {
      this.bonCaisSerie = var1;
   }

   public int getBonCaisTypeReg() {
      return this.bonCaisTypeReg;
   }

   public void setBonCaisTypeReg(int var1) {
      this.bonCaisTypeReg = var1;
   }

   public int getBonCaisTypeTiers() {
      return this.bonCaisTypeTiers;
   }

   public void setBonCaisTypeTiers(int var1) {
      this.bonCaisTypeTiers = var1;
   }

   public String getBonCaisCodeBanqEmetteur() {
      return this.bonCaisCodeBanqEmetteur;
   }

   public void setBonCaisCodeBanqEmetteur(String var1) {
      this.bonCaisCodeBanqEmetteur = var1;
   }

   public String getBonCaisCodeBanqRecepteur() {
      return this.bonCaisCodeBanqRecepteur;
   }

   public void setBonCaisCodeBanqRecepteur(String var1) {
      this.bonCaisCodeBanqRecepteur = var1;
   }

   public String getBonCaisLibBanqEmetteur() {
      return this.bonCaisLibBanqEmetteur;
   }

   public void setBonCaisLibBanqEmetteur(String var1) {
      this.bonCaisLibBanqEmetteur = var1;
   }

   public String getBonCaisLibBanqRecepteur() {
      return this.bonCaisLibBanqRecepteur;
   }

   public void setBonCaisLibBanqRecepteur(String var1) {
      this.bonCaisLibBanqRecepteur = var1;
   }

   public String getBonCaisNumOrigine() {
      return this.bonCaisNumOrigine;
   }

   public void setBonCaisNumOrigine(String var1) {
      this.bonCaisNumOrigine = var1;
   }

   public boolean isBonCaisDepot() {
      return this.bonCaisDepot;
   }

   public void setBonCaisDepot(boolean var1) {
      this.bonCaisDepot = var1;
   }

   public BonCaisse getBonCaissePrint() {
      return this.bonCaissePrint;
   }

   public void setBonCaissePrint(BonCaisse var1) {
      this.bonCaissePrint = var1;
   }

   public int getOrigine() {
      return this.origine;
   }

   public void setOrigine(int var1) {
      this.origine = var1;
   }

   public String getBonCaisModeleImp() {
      return this.bonCaisModeleImp;
   }

   public void setBonCaisModeleImp(String var1) {
      this.bonCaisModeleImp = var1;
   }

   public Date getBonDateCloture() {
      return this.bonDateCloture;
   }

   public void setBonDateCloture(Date var1) {
      this.bonDateCloture = var1;
   }

   public Date getBonDateTransfert() {
      return this.bonDateTransfert;
   }

   public void setBonDateTransfert(Date var1) {
      this.bonDateTransfert = var1;
   }

   public String getBonCaisClient() {
      return this.bonCaisClient;
   }

   public void setBonCaisClient(String var1) {
      this.bonCaisClient = var1;
   }

   public String getBonCaisFacture() {
      return this.bonCaisFacture;
   }

   public void setBonCaisFacture(String var1) {
      this.bonCaisFacture = var1;
   }

   public String getBonCaisOperation() {
      return this.bonCaisOperation;
   }

   public void setBonCaisOperation(String var1) {
      this.bonCaisOperation = var1;
   }

   public Date getBonDateMvt2() {
      return this.bonDateMvt2;
   }

   public void setBonDateMvt2(Date var1) {
      this.bonDateMvt2 = var1;
   }

   public Date getBonCaisDateEncaissement() {
      return this.bonCaisDateEncaissement;
   }

   public void setBonCaisDateEncaissement(Date var1) {
      this.bonCaisDateEncaissement = var1;
   }

   public Date getBonCaisDateRejet() {
      return this.bonCaisDateRejet;
   }

   public void setBonCaisDateRejet(Date var1) {
      this.bonCaisDateRejet = var1;
   }

   public String getBonCaisNumChqBdx() {
      return this.bonCaisNumChqBdx;
   }

   public void setBonCaisNumChqBdx(String var1) {
      this.bonCaisNumChqBdx = var1;
   }

   public String getBonCaisBanqueTirreur() {
      return this.bonCaisBanqueTirreur;
   }

   public void setBonCaisBanqueTirreur(String var1) {
      this.bonCaisBanqueTirreur = var1;
   }

   public String getBonGrp() {
      return this.bonGrp;
   }

   public void setBonGrp(String var1) {
      this.bonGrp = var1;
   }

   public long getBonCaisIdOrigine() {
      return this.bonCaisIdOrigine;
   }

   public void setBonCaisIdOrigine(long var1) {
      this.bonCaisIdOrigine = var1;
   }

   public String getBonCaisService() {
      return this.bonCaisService;
   }

   public void setBonCaisService(String var1) {
      this.bonCaisService = var1;
   }

   public Date getBonCaisDateRemise() {
      return this.bonCaisDateRemise;
   }

   public void setBonCaisDateRemise(Date var1) {
      this.bonCaisDateRemise = var1;
   }

   public long getBonCaisIdTiers() {
      return this.bonCaisIdTiers;
   }

   public void setBonCaisIdTiers(long var1) {
      this.bonCaisIdTiers = var1;
   }

   public boolean isBonAnnuler() {
      return this.bonAnnuler;
   }

   public void setBonAnnuler(boolean var1) {
      this.bonAnnuler = var1;
   }
}
