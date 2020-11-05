package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reglements implements Serializable {
   private long rglId;
   private String rglCle1;
   private String rglCle2;
   private String rglCle3;
   private String rglCle4;
   private String rglPeriode;
   private Date rglDateCreation;
   private long rglUserCreat;
   private String rglGrp;
   private Date rglDateModif;
   private long rglUserModif;
   private Date rglDateReg;
   private Date rglDateRemise;
   private Date rglDateRegQuart;
   private String rglQuart;
   private Date rglDateValeur;
   private int rglNatureDoc;
   private long rglIdDocument;
   private String rglDocument;
   private long rglIdBon;
   private String rglBon;
   private String rglSource;
   private String rglSerie;
   private String rglNum;
   private boolean rglPj;
   private String rglCodeCaiss;
   private String rglLibCaiss;
   private String rglLibelle;
   private String rglObjet;
   private int rglCategorie;
   private int rglTypeReg;
   private String rglMode;
   private double rglDepense;
   private double rglRecette;
   private double rglFrais;
   private double rglTimbre;
   private double rglRendu;
   private String rglDevise;
   private int rglFormatDevise;
   private String rglNomTiers;
   private long rglIdTiers;
   private int rglDepotTiers;
   private String rglNomContact;
   private long rglIdContact;
   private long rglIdCaissier;
   private String rglNomCaissier;
   private String rglBudget;
   private String rglActivite;
   private String rglDossier;
   private String rglParc;
   private String rglSite;
   private String rglDepartement;
   private String rglService;
   private String rglRegion;
   private String rglSecteur;
   private String rglPdv;
   private String rglCle1Repartition;
   private String rglCle2Repartition;
   private String rglModele;
   private Date rglDateImp;
   private int rglImp;
   private int rglTrf;
   private Date rglDateTransfert;
   private Date rglDateCloture;
   private String rglLibEmetrice;
   private String rglCodeEmetrice;
   private String rglLibReceptrice;
   private String rglCodeReceptrice;
   private int rglTypeTiers;
   private String rglBanqueTireur;
   private String rglNumChqBdx;
   private String rglOperation;
   private Date rglDateMvt1;
   private String rglCaisseMvt1;
   private String rglNumMvt1;
   private Date rglDateMvt2;
   private String rglBanqueMvt2;
   private String rglNumMvt2;
   private int rglB1;
   private int rglB2;
   private int rglB3;
   private int rglB4;
   private int rglB5;
   private int rglB6;
   private int rglB7;
   private int rglB8;
   private int rglB9;
   private int rglB10;
   private int rglP1;
   private int rglP2;
   private int rglP3;
   private int rglP4;
   private int rglP5;
   private int rglP6;
   private int rglP7;
   private int rglP8;
   private int rglP9;
   private int rglP10;
   private String rglNumTrf;
   private Date rglDateExecBc;
   private String rglCodeBudgetTreso;
   private String rglCodePosteTreso;
   private long rglIdResponsable;
   private String rglNomResponsable;
   private long rglIdCommercial;
   private String rglNomCommercial;
   private long rglIdEquipe;
   private String rglNomEquipe;
   private double rglCommission;
   private Date rglDateEncaissement;
   private Date rglDateRejet;
   private String rglActiviteCompte;
   private float rglActiviteTaux;
   private boolean rglActiviteExo;
   private String rglInfo1;
   private String rglInfo2;
   private String rglInfo3;
   private String rglInfo4;
   private String rglInfo5;
   private String rglInfo6;
   private String rglInfo7;
   private String rglInfo8;
   private String rglInfo9;
   private String rglInfo10;
   private boolean rglAnnuler;
   private ExercicesCaisse exercicesCaisse;
   private String var_lib_nat;
   private boolean var_bloque_trf;
   private String demandeurBs;
   private String motifBs;
   private String var_etat;
   private boolean sel_ecriture;
   private String couleur;
   private String gras;
   private String numeCompte;
   private double val_depense;
   private double val_recette;
   private String libelleOperation;
   private double montantReglement;
   private String rglLibTypReg;
   private double var_comUnite;
   private float var_comPourcentage;
   private double var_totCommission;
   private String com_num;
   private Date com_date;
   private Date com_lastDatereg;
   private long com_nbJour;
   private String com_serie;
   private String com_cat;
   private String com_nomTiers;
   private long com_idTiers;
   private String com_civilite;
   private String com_nomContact;
   private long com_idContact;
   private String com_civiliteContact;
   private String com_nomResponsable;
   private long com_idResponsable;
   private String com_nomCommercial;
   private long com_idCommercial;
   private String com_nomEquipe;
   private long com_idEquipe;
   private double recetteReelle;
   private String banqueDepot;
   private Date dateDepot;
   private String numDepot;
   private Date dateValeur;
   private double totalFacture;
   private double totalReglement;
   private double totalRecette;
   private double totalTimbre;
   private List lesLignesRecus = new ArrayList();

   public ExercicesCaisse getExercicesCaisse() {
      return this.exercicesCaisse;
   }

   public List getLesLignesRecus() {
      return this.lesLignesRecus;
   }

   public void setLesLignesRecus(List var1) {
      this.lesLignesRecus = var1;
   }

   public double getRecetteReelle() {
      this.recetteReelle = this.rglRecette - this.rglRendu;
      return this.recetteReelle;
   }

   public void setRecetteReelle(double var1) {
      this.recetteReelle = var1;
   }

   public String getLibelleOperation() {
      if (this.rglOperation != null && !this.rglOperation.isEmpty()) {
         if (this.rglOperation.equals("01")) {
            this.libelleOperation = "Règlement facture";
         } else if (this.rglOperation.equals("02")) {
            this.libelleOperation = "Acompte facture";
         } else if (this.rglOperation.equals("03")) {
            this.libelleOperation = "Avce/Rmb personnel";
         } else if (this.rglOperation.equals("05")) {
            this.libelleOperation = "Centralisation recette";
         } else if (this.rglOperation.equals("06")) {
            this.libelleOperation = "Régul. erreur";
         } else if (this.rglOperation.equals("07")) {
            this.libelleOperation = "Règlement ticket";
         } else if (this.rglOperation.equals("10")) {
            this.libelleOperation = "Autres recettes";
         } else if (this.rglOperation.equals("11")) {
            this.libelleOperation = "Traites domicilées";
         } else if (this.rglOperation.equals("12")) {
            this.libelleOperation = "Traites en portefeuille";
         } else if (this.rglOperation.equals("13")) {
            this.libelleOperation = "Déposit client";
         } else if (this.rglOperation.equals("17")) {
            this.libelleOperation = "Ecart caisse";
         } else if (this.rglOperation.equals("18")) {
            this.libelleOperation = "Regul. Ecart caisse";
         } else if (this.rglOperation.equals("19")) {
            this.libelleOperation = "Impayés chèque client";
         } else if (this.rglOperation.equals("20")) {
            this.libelleOperation = "Autres dépenses";
         } else if (this.rglOperation.equals("21")) {
            this.libelleOperation = "Paiement facture fournisseur";
         } else if (this.rglOperation.equals("22")) {
            this.libelleOperation = "Traite société";
         } else if (this.rglOperation.equals("23")) {
            this.libelleOperation = "Avce/Rmb personnel";
         } else if (this.rglOperation.equals("24")) {
            this.libelleOperation = "Paiement commissions";
         } else if (this.rglOperation.equals("25")) {
            this.libelleOperation = "Bon caisse";
         } else if (this.rglOperation.equals("26")) {
            this.libelleOperation = "Regul. Bon caisse";
         } else if (this.rglOperation.equals("27")) {
            this.libelleOperation = "Ecart caisse";
         } else if (this.rglOperation.equals("28")) {
            this.libelleOperation = "Regul. Ecart caisse";
         } else if (this.rglOperation.equals("29")) {
            this.libelleOperation = "Impayés chèque fournisseur";
         } else if (this.rglOperation.equals("50")) {
            this.libelleOperation = "Règlement frais";
         } else if (this.rglOperation.equals("55")) {
            this.libelleOperation = "Paiement salaire";
         } else if (this.rglOperation.equals("71")) {
            this.libelleOperation = "Appro. Caisse/Caisse";
         } else if (this.rglOperation.equals("73")) {
            this.libelleOperation = "Vrt. Banque/Caisse";
         } else if (this.rglOperation.equals("74")) {
            this.libelleOperation = "Vrt. Banque/Banque";
         } else if (this.rglOperation.equals("76")) {
            this.libelleOperation = "Ech. Chèque/Banque";
         } else if (this.rglOperation.equals("77")) {
            this.libelleOperation = "Ech. Chèque/Espèce";
         } else if (this.rglOperation.equals("80")) {
            this.libelleOperation = "Mvt. Caisse/Caisse";
         } else if (this.rglOperation.equals("81")) {
            this.libelleOperation = "Mvt. Chèque/Caisse";
         } else if (this.rglOperation.equals("82")) {
            this.libelleOperation = "Mvt. Traite/Caisse";
         } else if (this.rglOperation.equals("83")) {
            this.libelleOperation = "Rem. Chèque/Banque";
         } else if (this.rglOperation.equals("84")) {
            this.libelleOperation = "Rem. Traite/Banque";
         } else if (this.rglOperation.equals("85")) {
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

   public double getMontantReglement() {
      if (this.rglRecette != 0.0D && this.rglDepense == 0.0D) {
         this.montantReglement = this.rglRecette;
      } else if (this.rglRecette == 0.0D && this.rglDepense != 0.0D) {
         this.montantReglement = this.rglDepense;
      }

      return this.montantReglement;
   }

   public void setMontantReglement(double var1) {
      this.montantReglement = var1;
   }

   public double getVal_depense() {
      if (this.rglDepense != 0.0D && this.rglRecette == 0.0D) {
         this.val_depense = this.rglDepense + this.rglTimbre;
      } else {
         this.val_depense = 0.0D;
      }

      return this.val_depense;
   }

   public void setVal_depense(double var1) {
      this.val_depense = var1;
   }

   public double getVal_recette() {
      if (this.rglRecette != 0.0D && this.rglDepense == 0.0D) {
         this.val_recette = this.rglRecette - this.rglRendu + this.rglTimbre;
      } else {
         this.val_recette = 0.0D;
      }

      return this.val_recette;
   }

   public void setVal_recette(double var1) {
      this.val_recette = var1;
   }

   public String getCouleur() {
      if (this.rglTypeReg == 9) {
         this.couleur = "blue";
      } else {
         this.couleur = "black";
      }

      return this.couleur;
   }

   public void setCouleur(String var1) {
      this.couleur = var1;
   }

   public String getGras() {
      if (this.sel_ecriture) {
         this.gras = "font-weight:bold;text-align:center";
      } else {
         this.gras = "";
      }

      return this.gras;
   }

   public void setGras(String var1) {
      this.gras = var1;
   }

   public boolean isSel_ecriture() {
      return this.sel_ecriture;
   }

   public void setSel_ecriture(boolean var1) {
      this.sel_ecriture = var1;
   }

   public String getVar_etat() {
      if (this.rglDateCloture != null && this.rglDateTransfert == null) {
         this.var_etat = "Clo";
      } else if (this.rglDateCloture != null && this.rglDateTransfert != null) {
         this.var_etat = "Trf";
      } else {
         this.var_etat = "EC";
      }

      return this.var_etat;
   }

   public void setVar_etat(String var1) {
      this.var_etat = var1;
   }

   public String getVar_lib_nat() {
      if (this.rglNatureDoc == 10) {
         this.var_lib_nat = "Demande Achat";
      } else if (this.rglNatureDoc == 11) {
         this.var_lib_nat = "Cotation";
      } else if (this.rglNatureDoc == 12) {
         this.var_lib_nat = "Commande fournisseur";
      } else if (this.rglNatureDoc == 13) {
         this.var_lib_nat = "Réception";
      } else if (this.rglNatureDoc == 14) {
         this.var_lib_nat = "Retour fournisseur";
      } else if (this.rglNatureDoc == 15) {
         this.var_lib_nat = "Facture fournisseur";
      } else if (this.rglNatureDoc == 16) {
         this.var_lib_nat = "Avoir fournisseur";
      } else if (this.rglNatureDoc == 17) {
         this.var_lib_nat = "Note débit fournisseur";
      } else if (this.rglNatureDoc == 18) {
         this.var_lib_nat = "Facture de frais";
      } else if (this.rglNatureDoc == 19) {
         this.var_lib_nat = "Collecte";
      } else if (this.rglNatureDoc == 20) {
         this.var_lib_nat = "Besoin";
      } else if (this.rglNatureDoc == 21) {
         this.var_lib_nat = "Devis";
      } else if (this.rglNatureDoc == 22) {
         this.var_lib_nat = "Commande client";
      } else if (this.rglNatureDoc == 23) {
         this.var_lib_nat = "Livraison client";
      } else if (this.rglNatureDoc == 24) {
         this.var_lib_nat = "Retour client";
      } else if (this.rglNatureDoc == 25) {
         this.var_lib_nat = "Facture client";
      } else if (this.rglNatureDoc == 26) {
         this.var_lib_nat = "Avoir client";
      } else if (this.rglNatureDoc == 27) {
         this.var_lib_nat = "Note débit client";
      } else if (this.rglNatureDoc == 28) {
         this.var_lib_nat = "chargement";
      } else if (this.rglNatureDoc != 60) {
         if (this.rglNatureDoc == 61) {
            this.var_lib_nat = "reçu";
         } else if (this.rglNatureDoc == 62) {
            this.var_lib_nat = "bons de sortie";
         } else if (this.rglNatureDoc == 63) {
            this.var_lib_nat = "bons d'entré";
         } else if (this.rglNatureDoc == 64) {
            this.var_lib_nat = "virement interne";
         } else if (this.rglNatureDoc == 65) {
            this.var_lib_nat = "ordre de paiement";
         } else if (this.rglNatureDoc == 71) {
            this.var_lib_nat = "Consultation Géné.";
         } else if (this.rglNatureDoc == 72) {
            this.var_lib_nat = "Consultation Spéc.";
         } else if (this.rglNatureDoc == 73) {
            this.var_lib_nat = "Pharmacie";
         } else if (this.rglNatureDoc == 74) {
            this.var_lib_nat = "Laboratoire";
         } else if (this.rglNatureDoc == 76) {
            this.var_lib_nat = "Hospitalisation";
         } else if (this.rglNatureDoc == 78) {
            this.var_lib_nat = "Refacturation";
         } else if (this.rglNatureDoc == 165) {
            this.var_lib_nat = "Locations";
         } else if (this.rglNatureDoc == 173) {
            this.var_lib_nat = "Appel de Charges";
         }
      }

      return this.var_lib_nat;
   }

   public void setVar_lib_nat(String var1) {
      this.var_lib_nat = var1;
   }

   public boolean isVar_bloque_trf() {
      if (this.rglTrf == 1) {
         this.var_bloque_trf = true;
      } else {
         this.var_bloque_trf = false;
      }

      return this.var_bloque_trf;
   }

   public void setVar_bloque_trf(boolean var1) {
      this.var_bloque_trf = var1;
   }

   public String getRglLibTypReg() {
      if (this.rglTypeReg == 0) {
         this.rglLibTypReg = "Espèce";
      } else if (this.rglTypeReg == 1) {
         this.rglLibTypReg = "Chéque";
      } else if (this.rglTypeReg == 2) {
         this.rglLibTypReg = "Virement";
      } else if (this.rglTypeReg == 3) {
         this.rglLibTypReg = "Traite";
      } else if (this.rglTypeReg == 4) {
         this.rglLibTypReg = "T.P.E.";
      } else if (this.rglTypeReg == 5) {
         this.rglLibTypReg = "Transfert argent";
      } else if (this.rglTypeReg == 6) {
         this.rglLibTypReg = "ePaiement";
      } else if (this.rglTypeReg == 7) {
         this.rglLibTypReg = "Crédoc";
      } else if (this.rglTypeReg == 8) {
         this.rglLibTypReg = "Factor";
      } else if (this.rglTypeReg == 9) {
         this.rglLibTypReg = "Compense";
      } else if (this.rglTypeReg == 10) {
         this.rglLibTypReg = "Terme";
      } else if (this.rglTypeReg == 11) {
         this.rglLibTypReg = "Espèces sans timbre";
      } else if (this.rglTypeReg == 12) {
         this.rglLibTypReg = "Lettre de garantie";
      } else if (this.rglTypeReg == 13) {
         this.rglLibTypReg = "Prélèvement";
      } else if (this.rglTypeReg == 14) {
         this.rglLibTypReg = "Alcoin";
      } else if (this.rglTypeReg == 90) {
         this.rglLibTypReg = "Déposit/Ristourne";
      } else {
         String var1;
         String[] var2;
         if (this.rglTypeReg == 98) {
            var1 = "";
            if (this.rglNomEquipe != null && !this.rglNomEquipe.isEmpty() && this.rglNomEquipe.contains(":")) {
               var2 = this.rglNomEquipe.split(":");
               var1 = var2[2];
            }

            this.rglLibTypReg = "SALARIE:" + var1;
         } else if (this.rglTypeReg == 99) {
            var1 = "";
            if (this.rglNomEquipe != null && !this.rglNomEquipe.isEmpty() && this.rglNomEquipe.contains(":")) {
               var2 = this.rglNomEquipe.split(":");
               var1 = var2[2];
            }

            this.rglLibTypReg = "USER: " + var1;
         } else {
            this.rglLibTypReg = "Autre";
         }
      }

      return this.rglLibTypReg;
   }

   public void setRglLibTypReg(String var1) {
      this.rglLibTypReg = var1;
   }

   public void setExercicesCaisse(ExercicesCaisse var1) {
      this.exercicesCaisse = var1;
   }

   public String getRglActivite() {
      return this.rglActivite;
   }

   public void setRglActivite(String var1) {
      this.rglActivite = var1;
   }

   public String getRglBudget() {
      return this.rglBudget;
   }

   public void setRglBudget(String var1) {
      this.rglBudget = var1;
   }

   public int getRglCategorie() {
      return this.rglCategorie;
   }

   public void setRglCategorie(int var1) {
      this.rglCategorie = var1;
   }

   public Date getRglDateCreation() {
      return this.rglDateCreation;
   }

   public void setRglDateCreation(Date var1) {
      this.rglDateCreation = var1;
   }

   public Date getRglDateModif() {
      return this.rglDateModif;
   }

   public void setRglDateModif(Date var1) {
      this.rglDateModif = var1;
   }

   public String getRglDepartement() {
      return this.rglDepartement;
   }

   public void setRglDepartement(String var1) {
      this.rglDepartement = var1;
   }

   public double getRglDepense() {
      return this.rglDepense;
   }

   public void setRglDepense(double var1) {
      this.rglDepense = var1;
   }

   public String getRglDevise() {
      return this.rglDevise;
   }

   public void setRglDevise(String var1) {
      this.rglDevise = var1;
   }

   public String getRglDocument() {
      return this.rglDocument;
   }

   public void setRglDocument(String var1) {
      this.rglDocument = var1;
   }

   public long getRglId() {
      return this.rglId;
   }

   public void setRglId(long var1) {
      this.rglId = var1;
   }

   public long getRglIdCaissier() {
      return this.rglIdCaissier;
   }

   public void setRglIdCaissier(long var1) {
      this.rglIdCaissier = var1;
   }

   public String getRglLibelle() {
      return this.rglLibelle;
   }

   public void setRglLibelle(String var1) {
      this.rglLibelle = var1;
   }

   public String getRglModele() {
      return this.rglModele;
   }

   public void setRglModele(String var1) {
      this.rglModele = var1;
   }

   public int getRglNatureDoc() {
      return this.rglNatureDoc;
   }

   public void setRglNatureDoc(int var1) {
      this.rglNatureDoc = var1;
   }

   public String getRglNomCaissier() {
      return this.rglNomCaissier;
   }

   public void setRglNomCaissier(String var1) {
      this.rglNomCaissier = var1;
   }

   public String getRglNum() {
      return this.rglNum;
   }

   public void setRglNum(String var1) {
      this.rglNum = var1;
   }

   public String getRglPdv() {
      return this.rglPdv;
   }

   public void setRglPdv(String var1) {
      this.rglPdv = var1;
   }

   public double getRglRecette() {
      return this.rglRecette;
   }

   public void setRglRecette(double var1) {
      this.rglRecette = var1;
   }

   public String getRglSecteur() {
      return this.rglSecteur;
   }

   public void setRglSecteur(String var1) {
      this.rglSecteur = var1;
   }

   public String getRglSerie() {
      return this.rglSerie;
   }

   public void setRglSerie(String var1) {
      this.rglSerie = var1;
   }

   public String getRglService() {
      return this.rglService;
   }

   public void setRglService(String var1) {
      this.rglService = var1;
   }

   public String getRglSite() {
      return this.rglSite;
   }

   public void setRglSite(String var1) {
      this.rglSite = var1;
   }

   public int getRglTypeReg() {
      return this.rglTypeReg;
   }

   public void setRglTypeReg(int var1) {
      this.rglTypeReg = var1;
   }

   public long getRglUserCreat() {
      return this.rglUserCreat;
   }

   public void setRglUserCreat(long var1) {
      this.rglUserCreat = var1;
   }

   public long getRglUserModif() {
      return this.rglUserModif;
   }

   public void setRglUserModif(long var1) {
      this.rglUserModif = var1;
   }

   public Date getRglDateReg() {
      return this.rglDateReg;
   }

   public void setRglDateReg(Date var1) {
      this.rglDateReg = var1;
   }

   public String getRglRegion() {
      return this.rglRegion;
   }

   public void setRglRegion(String var1) {
      this.rglRegion = var1;
   }

   public String getRglNomTiers() {
      return this.rglNomTiers;
   }

   public void setRglNomTiers(String var1) {
      this.rglNomTiers = var1;
   }

   public Date getRglDateValeur() {
      return this.rglDateValeur;
   }

   public void setRglDateValeur(Date var1) {
      this.rglDateValeur = var1;
   }

   public String getRglObjet() {
      return this.rglObjet;
   }

   public void setRglObjet(String var1) {
      this.rglObjet = var1;
   }

   public String getRglMode() {
      return this.rglMode;
   }

   public void setRglMode(String var1) {
      this.rglMode = var1;
   }

   public long getRglIdDocument() {
      return this.rglIdDocument;
   }

   public void setRglIdDocument(long var1) {
      this.rglIdDocument = var1;
   }

   public String getRglCle1() {
      return this.rglCle1;
   }

   public void setRglCle1(String var1) {
      this.rglCle1 = var1;
   }

   public String getRglCle2() {
      return this.rglCle2;
   }

   public void setRglCle2(String var1) {
      this.rglCle2 = var1;
   }

   public String getRglPeriode() {
      return this.rglPeriode;
   }

   public void setRglPeriode(String var1) {
      this.rglPeriode = var1;
   }

   public String getRglLibCaiss() {
      return this.rglLibCaiss;
   }

   public void setRglLibCaiss(String var1) {
      this.rglLibCaiss = var1;
   }

   public String getRglNomResponsable() {
      return this.rglNomResponsable;
   }

   public void setRglNomResponsable(String var1) {
      this.rglNomResponsable = var1;
   }

   public String getRglCodeEmetrice() {
      return this.rglCodeEmetrice;
   }

   public void setRglCodeEmetrice(String var1) {
      this.rglCodeEmetrice = var1;
   }

   public String getRglCodeReceptrice() {
      return this.rglCodeReceptrice;
   }

   public void setRglCodeReceptrice(String var1) {
      this.rglCodeReceptrice = var1;
   }

   public String getRglLibEmetrice() {
      return this.rglLibEmetrice;
   }

   public void setRglLibEmetrice(String var1) {
      this.rglLibEmetrice = var1;
   }

   public String getRglLibReceptrice() {
      return this.rglLibReceptrice;
   }

   public void setRglLibReceptrice(String var1) {
      this.rglLibReceptrice = var1;
   }

   public int getRglTypeTiers() {
      return this.rglTypeTiers;
   }

   public void setRglTypeTiers(int var1) {
      this.rglTypeTiers = var1;
   }

   public String getRglCodeCaiss() {
      return this.rglCodeCaiss;
   }

   public void setRglCodeCaiss(String var1) {
      this.rglCodeCaiss = var1;
   }

   public long getRglIdTiers() {
      return this.rglIdTiers;
   }

   public void setRglIdTiers(long var1) {
      this.rglIdTiers = var1;
   }

   public long getRglIdBon() {
      return this.rglIdBon;
   }

   public void setRglIdBon(long var1) {
      this.rglIdBon = var1;
   }

   public String getRglBon() {
      return this.rglBon;
   }

   public void setRglBon(String var1) {
      this.rglBon = var1;
   }

   public int getRglDepotTiers() {
      return this.rglDepotTiers;
   }

   public void setRglDepotTiers(int var1) {
      this.rglDepotTiers = var1;
   }

   public int getRglFormatDevise() {
      return this.rglFormatDevise;
   }

   public void setRglFormatDevise(int var1) {
      this.rglFormatDevise = var1;
   }

   public Date getRglDateImp() {
      return this.rglDateImp;
   }

   public void setRglDateImp(Date var1) {
      this.rglDateImp = var1;
   }

   public Date getRglDateTransfert() {
      return this.rglDateTransfert;
   }

   public void setRglDateTransfert(Date var1) {
      this.rglDateTransfert = var1;
   }

   public int getRglTrf() {
      return this.rglTrf;
   }

   public void setRglTrf(int var1) {
      this.rglTrf = var1;
   }

   public double getRglTimbre() {
      return this.rglTimbre;
   }

   public void setRglTimbre(double var1) {
      this.rglTimbre = var1;
   }

   public String getRglBanqueTireur() {
      return this.rglBanqueTireur;
   }

   public void setRglBanqueTireur(String var1) {
      this.rglBanqueTireur = var1;
   }

   public String getRglNumChqBdx() {
      return this.rglNumChqBdx;
   }

   public void setRglNumChqBdx(String var1) {
      this.rglNumChqBdx = var1;
   }

   public String getRglDossier() {
      return this.rglDossier;
   }

   public void setRglDossier(String var1) {
      this.rglDossier = var1;
   }

   public String getRglParc() {
      return this.rglParc;
   }

   public void setRglParc(String var1) {
      this.rglParc = var1;
   }

   public String getRglNomContact() {
      return this.rglNomContact;
   }

   public void setRglNomContact(String var1) {
      this.rglNomContact = var1;
   }

   public long getRglIdContact() {
      return this.rglIdContact;
   }

   public void setRglIdContact(long var1) {
      this.rglIdContact = var1;
   }

   public String getRglCle1Repartition() {
      return this.rglCle1Repartition;
   }

   public void setRglCle1Repartition(String var1) {
      this.rglCle1Repartition = var1;
   }

   public String getRglCle2Repartition() {
      return this.rglCle2Repartition;
   }

   public void setRglCle2Repartition(String var1) {
      this.rglCle2Repartition = var1;
   }

   public int getRglImp() {
      return this.rglImp;
   }

   public void setRglImp(int var1) {
      this.rglImp = var1;
   }

   public String getDemandeurBs() {
      return this.demandeurBs;
   }

   public void setDemandeurBs(String var1) {
      this.demandeurBs = var1;
   }

   public String getMotifBs() {
      return this.motifBs;
   }

   public void setMotifBs(String var1) {
      this.motifBs = var1;
   }

   public Date getRglDateCloture() {
      return this.rglDateCloture;
   }

   public void setRglDateCloture(Date var1) {
      this.rglDateCloture = var1;
   }

   public String getRglOperation() {
      return this.rglOperation;
   }

   public void setRglOperation(String var1) {
      this.rglOperation = var1;
   }

   public Date getRglDateMvt1() {
      return this.rglDateMvt1;
   }

   public void setRglDateMvt1(Date var1) {
      this.rglDateMvt1 = var1;
   }

   public Date getRglDateMvt2() {
      return this.rglDateMvt2;
   }

   public void setRglDateMvt2(Date var1) {
      this.rglDateMvt2 = var1;
   }

   public String getRglNumMvt1() {
      return this.rglNumMvt1;
   }

   public void setRglNumMvt1(String var1) {
      this.rglNumMvt1 = var1;
   }

   public String getRglNumMvt2() {
      return this.rglNumMvt2;
   }

   public void setRglNumMvt2(String var1) {
      this.rglNumMvt2 = var1;
   }

   public int getRglB1() {
      return this.rglB1;
   }

   public void setRglB1(int var1) {
      this.rglB1 = var1;
   }

   public int getRglB10() {
      return this.rglB10;
   }

   public void setRglB10(int var1) {
      this.rglB10 = var1;
   }

   public int getRglB2() {
      return this.rglB2;
   }

   public void setRglB2(int var1) {
      this.rglB2 = var1;
   }

   public int getRglB3() {
      return this.rglB3;
   }

   public void setRglB3(int var1) {
      this.rglB3 = var1;
   }

   public int getRglB4() {
      return this.rglB4;
   }

   public void setRglB4(int var1) {
      this.rglB4 = var1;
   }

   public int getRglB5() {
      return this.rglB5;
   }

   public void setRglB5(int var1) {
      this.rglB5 = var1;
   }

   public int getRglB6() {
      return this.rglB6;
   }

   public void setRglB6(int var1) {
      this.rglB6 = var1;
   }

   public int getRglB7() {
      return this.rglB7;
   }

   public void setRglB7(int var1) {
      this.rglB7 = var1;
   }

   public int getRglB8() {
      return this.rglB8;
   }

   public void setRglB8(int var1) {
      this.rglB8 = var1;
   }

   public int getRglB9() {
      return this.rglB9;
   }

   public void setRglB9(int var1) {
      this.rglB9 = var1;
   }

   public int getRglP1() {
      return this.rglP1;
   }

   public void setRglP1(int var1) {
      this.rglP1 = var1;
   }

   public int getRglP10() {
      return this.rglP10;
   }

   public void setRglP10(int var1) {
      this.rglP10 = var1;
   }

   public int getRglP2() {
      return this.rglP2;
   }

   public void setRglP2(int var1) {
      this.rglP2 = var1;
   }

   public int getRglP3() {
      return this.rglP3;
   }

   public void setRglP3(int var1) {
      this.rglP3 = var1;
   }

   public int getRglP4() {
      return this.rglP4;
   }

   public void setRglP4(int var1) {
      this.rglP4 = var1;
   }

   public int getRglP5() {
      return this.rglP5;
   }

   public void setRglP5(int var1) {
      this.rglP5 = var1;
   }

   public int getRglP6() {
      return this.rglP6;
   }

   public void setRglP6(int var1) {
      this.rglP6 = var1;
   }

   public int getRglP7() {
      return this.rglP7;
   }

   public void setRglP7(int var1) {
      this.rglP7 = var1;
   }

   public int getRglP8() {
      return this.rglP8;
   }

   public void setRglP8(int var1) {
      this.rglP8 = var1;
   }

   public int getRglP9() {
      return this.rglP9;
   }

   public void setRglP9(int var1) {
      this.rglP9 = var1;
   }

   public String getNumeCompte() {
      return this.numeCompte;
   }

   public void setNumeCompte(String var1) {
      this.numeCompte = var1;
   }

   public String getRglBanqueMvt2() {
      return this.rglBanqueMvt2;
   }

   public void setRglBanqueMvt2(String var1) {
      this.rglBanqueMvt2 = var1;
   }

   public String getRglCaisseMvt1() {
      return this.rglCaisseMvt1;
   }

   public void setRglCaisseMvt1(String var1) {
      this.rglCaisseMvt1 = var1;
   }

   public String getRglNumTrf() {
      return this.rglNumTrf;
   }

   public void setRglNumTrf(String var1) {
      this.rglNumTrf = var1;
   }

   public Date getRglDateExecBc() {
      return this.rglDateExecBc;
   }

   public void setRglDateExecBc(Date var1) {
      this.rglDateExecBc = var1;
   }

   public double getRglFrais() {
      return this.rglFrais;
   }

   public void setRglFrais(double var1) {
      this.rglFrais = var1;
   }

   public String getRglCodeBudgetTreso() {
      return this.rglCodeBudgetTreso;
   }

   public void setRglCodeBudgetTreso(String var1) {
      this.rglCodeBudgetTreso = var1;
   }

   public String getRglCodePosteTreso() {
      return this.rglCodePosteTreso;
   }

   public void setRglCodePosteTreso(String var1) {
      this.rglCodePosteTreso = var1;
   }

   public long getRglIdCommercial() {
      return this.rglIdCommercial;
   }

   public void setRglIdCommercial(long var1) {
      this.rglIdCommercial = var1;
   }

   public long getRglIdEquipe() {
      return this.rglIdEquipe;
   }

   public void setRglIdEquipe(long var1) {
      this.rglIdEquipe = var1;
   }

   public String getRglNomCommercial() {
      return this.rglNomCommercial;
   }

   public void setRglNomCommercial(String var1) {
      this.rglNomCommercial = var1;
   }

   public String getRglNomEquipe() {
      return this.rglNomEquipe;
   }

   public void setRglNomEquipe(String var1) {
      this.rglNomEquipe = var1;
   }

   public long getRglIdResponsable() {
      return this.rglIdResponsable;
   }

   public void setRglIdResponsable(long var1) {
      this.rglIdResponsable = var1;
   }

   public String getCom_cat() {
      return this.com_cat;
   }

   public void setCom_cat(String var1) {
      this.com_cat = var1;
   }

   public String getCom_civilite() {
      return this.com_civilite;
   }

   public void setCom_civilite(String var1) {
      this.com_civilite = var1;
   }

   public String getCom_civiliteContact() {
      return this.com_civiliteContact;
   }

   public void setCom_civiliteContact(String var1) {
      this.com_civiliteContact = var1;
   }

   public Date getCom_date() {
      return this.com_date;
   }

   public void setCom_date(Date var1) {
      this.com_date = var1;
   }

   public long getCom_idCommercial() {
      return this.com_idCommercial;
   }

   public void setCom_idCommercial(long var1) {
      this.com_idCommercial = var1;
   }

   public long getCom_idContact() {
      return this.com_idContact;
   }

   public void setCom_idContact(long var1) {
      this.com_idContact = var1;
   }

   public long getCom_idEquipe() {
      return this.com_idEquipe;
   }

   public void setCom_idEquipe(long var1) {
      this.com_idEquipe = var1;
   }

   public long getCom_idResponsable() {
      return this.com_idResponsable;
   }

   public void setCom_idResponsable(long var1) {
      this.com_idResponsable = var1;
   }

   public long getCom_idTiers() {
      return this.com_idTiers;
   }

   public void setCom_idTiers(long var1) {
      this.com_idTiers = var1;
   }

   public Date getCom_lastDatereg() {
      return this.com_lastDatereg;
   }

   public void setCom_lastDatereg(Date var1) {
      this.com_lastDatereg = var1;
   }

   public long getCom_nbJour() {
      return this.com_nbJour;
   }

   public void setCom_nbJour(long var1) {
      this.com_nbJour = var1;
   }

   public String getCom_nomCommercial() {
      return this.com_nomCommercial;
   }

   public void setCom_nomCommercial(String var1) {
      this.com_nomCommercial = var1;
   }

   public String getCom_nomContact() {
      return this.com_nomContact;
   }

   public void setCom_nomContact(String var1) {
      this.com_nomContact = var1;
   }

   public String getCom_nomEquipe() {
      return this.com_nomEquipe;
   }

   public void setCom_nomEquipe(String var1) {
      this.com_nomEquipe = var1;
   }

   public String getCom_nomResponsable() {
      return this.com_nomResponsable;
   }

   public void setCom_nomResponsable(String var1) {
      this.com_nomResponsable = var1;
   }

   public String getCom_nomTiers() {
      return this.com_nomTiers;
   }

   public void setCom_nomTiers(String var1) {
      this.com_nomTiers = var1;
   }

   public String getCom_num() {
      return this.com_num;
   }

   public void setCom_num(String var1) {
      this.com_num = var1;
   }

   public String getCom_serie() {
      return this.com_serie;
   }

   public void setCom_serie(String var1) {
      this.com_serie = var1;
   }

   public float getVar_comPourcentage() {
      return this.var_comPourcentage;
   }

   public void setVar_comPourcentage(float var1) {
      this.var_comPourcentage = var1;
   }

   public double getVar_comUnite() {
      return this.var_comUnite;
   }

   public void setVar_comUnite(double var1) {
      this.var_comUnite = var1;
   }

   public double getVar_totCommission() {
      return this.var_totCommission;
   }

   public void setVar_totCommission(double var1) {
      this.var_totCommission = var1;
   }

   public double getRglCommission() {
      return this.rglCommission;
   }

   public void setRglCommission(double var1) {
      this.rglCommission = var1;
   }

   public double getRglRendu() {
      return this.rglRendu;
   }

   public void setRglRendu(double var1) {
      this.rglRendu = var1;
   }

   public String getRglCle3() {
      return this.rglCle3;
   }

   public void setRglCle3(String var1) {
      this.rglCle3 = var1;
   }

   public String getRglCle4() {
      return this.rglCle4;
   }

   public void setRglCle4(String var1) {
      this.rglCle4 = var1;
   }

   public String getBanqueDepot() {
      return this.banqueDepot;
   }

   public void setBanqueDepot(String var1) {
      this.banqueDepot = var1;
   }

   public Date getDateDepot() {
      return this.dateDepot;
   }

   public void setDateDepot(Date var1) {
      this.dateDepot = var1;
   }

   public String getNumDepot() {
      return this.numDepot;
   }

   public void setNumDepot(String var1) {
      this.numDepot = var1;
   }

   public Date getDateValeur() {
      return this.dateValeur;
   }

   public void setDateValeur(Date var1) {
      this.dateValeur = var1;
   }

   public Date getRglDateEncaissement() {
      return this.rglDateEncaissement;
   }

   public void setRglDateEncaissement(Date var1) {
      this.rglDateEncaissement = var1;
   }

   public Date getRglDateRejet() {
      return this.rglDateRejet;
   }

   public void setRglDateRejet(Date var1) {
      this.rglDateRejet = var1;
   }

   public String getRglActiviteCompte() {
      return this.rglActiviteCompte;
   }

   public void setRglActiviteCompte(String var1) {
      this.rglActiviteCompte = var1;
   }

   public boolean isRglActiviteExo() {
      return this.rglActiviteExo;
   }

   public void setRglActiviteExo(boolean var1) {
      this.rglActiviteExo = var1;
   }

   public float getRglActiviteTaux() {
      return this.rglActiviteTaux;
   }

   public void setRglActiviteTaux(float var1) {
      this.rglActiviteTaux = var1;
   }

   public String getRglInfo1() {
      return this.rglInfo1;
   }

   public void setRglInfo1(String var1) {
      this.rglInfo1 = var1;
   }

   public String getRglInfo10() {
      return this.rglInfo10;
   }

   public void setRglInfo10(String var1) {
      this.rglInfo10 = var1;
   }

   public String getRglInfo2() {
      return this.rglInfo2;
   }

   public void setRglInfo2(String var1) {
      this.rglInfo2 = var1;
   }

   public String getRglInfo3() {
      return this.rglInfo3;
   }

   public void setRglInfo3(String var1) {
      this.rglInfo3 = var1;
   }

   public String getRglInfo4() {
      return this.rglInfo4;
   }

   public void setRglInfo4(String var1) {
      this.rglInfo4 = var1;
   }

   public String getRglInfo5() {
      return this.rglInfo5;
   }

   public void setRglInfo5(String var1) {
      this.rglInfo5 = var1;
   }

   public String getRglInfo6() {
      return this.rglInfo6;
   }

   public void setRglInfo6(String var1) {
      this.rglInfo6 = var1;
   }

   public String getRglInfo7() {
      return this.rglInfo7;
   }

   public void setRglInfo7(String var1) {
      this.rglInfo7 = var1;
   }

   public String getRglInfo8() {
      return this.rglInfo8;
   }

   public void setRglInfo8(String var1) {
      this.rglInfo8 = var1;
   }

   public String getRglInfo9() {
      return this.rglInfo9;
   }

   public void setRglInfo9(String var1) {
      this.rglInfo9 = var1;
   }

   public double getTotalFacture() {
      return this.totalFacture;
   }

   public void setTotalFacture(double var1) {
      this.totalFacture = var1;
   }

   public double getTotalReglement() {
      return this.totalReglement;
   }

   public void setTotalReglement(double var1) {
      this.totalReglement = var1;
   }

   public Date getRglDateRegQuart() {
      return this.rglDateRegQuart;
   }

   public void setRglDateRegQuart(Date var1) {
      this.rglDateRegQuart = var1;
   }

   public String getRglQuart() {
      return this.rglQuart;
   }

   public void setRglQuart(String var1) {
      this.rglQuart = var1;
   }

   public double getTotalRecette() {
      return this.totalRecette;
   }

   public void setTotalRecette(double var1) {
      this.totalRecette = var1;
   }

   public double getTotalTimbre() {
      return this.totalTimbre;
   }

   public void setTotalTimbre(double var1) {
      this.totalTimbre = var1;
   }

   public String getRglGrp() {
      return this.rglGrp;
   }

   public void setRglGrp(String var1) {
      this.rglGrp = var1;
   }

   public Date getRglDateRemise() {
      return this.rglDateRemise;
   }

   public void setRglDateRemise(Date var1) {
      this.rglDateRemise = var1;
   }

   public boolean isRglAnnuler() {
      return this.rglAnnuler;
   }

   public void setRglAnnuler(boolean var1) {
      this.rglAnnuler = var1;
   }

   public boolean isRglPj() {
      return this.rglPj;
   }

   public void setRglPj(boolean var1) {
      this.rglPj = var1;
   }

   public String getRglSource() {
      return this.rglSource;
   }

   public void setRglSource(String var1) {
      this.rglSource = var1;
   }
}
