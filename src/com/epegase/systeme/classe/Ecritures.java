package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Ecritures implements Serializable {
   private long ecr_id;
   private long ecrIdOrigine;
   private String ecrTypeOrigine;
   private String ecrCle1;
   private String ecrCle2;
   private Date ecrDateCreat;
   private Date ecrDateModif;
   private long ecrUserCreat;
   private long ecrUserModif;
   private String ecrCode;
   private Date ecrDateSaisie;
   private String ecrPeriode;
   private int ecrJour;
   private String ecrAnnee;
   private String ecrCompte;
   private String ecrLibCompte;
   private int ecrNature;
   private String ecrClasse;
   private String ecrContrePartie;
   private String ecrDeviseSaisie;
   private double ecrDebitSaisie;
   private double ecrCreditSaisie;
   private float ecrCoefEuro;
   private double ecrDebitEuro;
   private double ecrCreditEuro;
   private String ecrDevisePays;
   private float ecrCoefPays;
   private double ecrDebitPays;
   private double ecrCreditPays;
   private String ecrDeviseGrp;
   private float ecrCoefGrp;
   private double ecrDebitGrp;
   private double ecrCreditGrp;
   private String ecrLettrage;
   private String ecrPointage;
   private String ecrRapprochement;
   private Date ecrDteRapprochement;
   private int ecrCloture;
   private Date ecrDateEcheance;
   private int ecrOrigineBanque;
   private Date ecrDateValeurTheo;
   private Date ecrDateValeurReelle;
   private String ecrLibelle;
   private String ecrPiece;
   private boolean ecrPj;
   private String ecrNumTrf;
   private String ecrReference1;
   private String ecrReference2;
   private String ecrTreso;
   private Date ecrDatePaiement;
   private String ecrNumIf;
   private long ecrOrdre;
   private int ecrNatureJrx;
   private int ecrReserve;
   private int ecrEtat;
   private String ecrBudgetTreso;
   private String ecrPosteTreso;
   private String ecrDossier;
   private int ecrAnaActif;
   private boolean ecrAnaAxe01;
   private boolean ecrAnaAxe02;
   private boolean ecrAnaAxe03;
   private boolean ecrAnaAxe04;
   private boolean ecrAnaAxe05;
   private boolean ecrAnaAxe06;
   private boolean ecrAnaAxe07;
   private boolean ecrAnaAxe08;
   private boolean ecrAnaAxe09;
   private boolean ecrAnaAxe10;
   private boolean ecrAnaAxe11;
   private boolean ecrAnaAxe12;
   private boolean ecrAnaAxe13;
   private ExercicesComptable exercicesComptable;
   private Brouillard brouillard;
   private boolean nbrEcrLettrage = false;
   private String lib_etat;
   private boolean sel_ecriture;
   private String couleur;
   private String gras;
   private String erreurLettrage;
   private boolean erreurAnalytique;
   private int verrouImport = 0;
   private String libelleOrigine;

   public String getLibelleOrigine() {
      if (this.ecrIdOrigine != 0L) {
         if (this.ecrTypeOrigine != null && !this.ecrTypeOrigine.isEmpty()) {
            if (this.ecrTypeOrigine.equals("12")) {
               this.libelleOrigine = "Commande achat";
            } else if (this.ecrTypeOrigine.equals("15")) {
               this.libelleOrigine = "Facture achat";
            } else if (this.ecrTypeOrigine.equals("16")) {
               this.libelleOrigine = "Avoir achat";
            } else if (this.ecrTypeOrigine.equals("17")) {
               this.libelleOrigine = "Note débit achat";
            } else if (this.ecrTypeOrigine.equals("18")) {
               this.libelleOrigine = "Facture frais achat";
            } else if (this.ecrTypeOrigine.equals("22")) {
               this.libelleOrigine = "Commande vente";
            } else if (this.ecrTypeOrigine.equals("23")) {
               this.libelleOrigine = "Livraison vente";
            } else if (this.ecrTypeOrigine.equals("24")) {
               this.libelleOrigine = "Retour vente";
            } else if (this.ecrTypeOrigine.equals("25")) {
               this.libelleOrigine = "Facture vente";
            } else if (this.ecrTypeOrigine.equals("26")) {
               this.libelleOrigine = "Avoir vente";
            } else if (this.ecrTypeOrigine.equals("27")) {
               this.libelleOrigine = "Note débit vente";
            } else if (this.ecrTypeOrigine.equals("142")) {
               this.libelleOrigine = "Facture interne vente";
            } else if (this.ecrTypeOrigine.equals("57")) {
               this.libelleOrigine = "Note Extene";
            } else if (this.ecrTypeOrigine.equals("60")) {
               this.libelleOrigine = "Opération caisse";
            } else if (this.ecrTypeOrigine.equals("71")) {
               this.libelleOrigine = "Consultation générale";
            } else if (this.ecrTypeOrigine.equals("72")) {
               this.libelleOrigine = "Consultation spécialisée";
            } else if (this.ecrTypeOrigine.equals("73")) {
               this.libelleOrigine = "Pharmacie";
            } else if (this.ecrTypeOrigine.equals("74")) {
               this.libelleOrigine = "Laboratoire";
            } else if (this.ecrTypeOrigine.equals("76")) {
               this.libelleOrigine = "Hospitalisation";
            } else if (this.ecrTypeOrigine.equals("78")) {
               this.libelleOrigine = "Refacturation médicale";
            } else if (this.ecrTypeOrigine.equals("181")) {
               this.libelleOrigine = "Facturation médicale externe";
            } else if (this.ecrTypeOrigine.equals("102")) {
               this.libelleOrigine = "Facture éducation";
            } else if (this.ecrTypeOrigine.equals("165")) {
               this.libelleOrigine = "Facturation location";
            } else if (this.ecrTypeOrigine.equals("173")) {
               this.libelleOrigine = "Appel de charges";
            } else if (this.ecrTypeOrigine.equals("AM")) {
               this.libelleOrigine = "Amortissement";
            } else if (this.ecrTypeOrigine.equals("IM")) {
               this.libelleOrigine = "Import externe";
            } else if (this.ecrTypeOrigine.equals("LO")) {
               this.libelleOrigine = "Loyer";
            } else if (this.ecrTypeOrigine.equals("PY")) {
               this.libelleOrigine = "Paye";
            } else {
               this.libelleOrigine = "Origine non référencée";
            }
         } else {
            this.libelleOrigine = "Erreur origine";
         }
      } else {
         this.libelleOrigine = "";
      }

      return this.libelleOrigine;
   }

   public void setLibelleOrigine(String var1) {
      this.libelleOrigine = var1;
   }

   public boolean isErreurAnalytique() {
      return this.erreurAnalytique;
   }

   public void setErreurAnalytique(boolean var1) {
      this.erreurAnalytique = var1;
   }

   public String getErreurLettrage() {
      return this.erreurLettrage;
   }

   public void setErreurLettrage(String var1) {
      this.erreurLettrage = var1;
   }

   public boolean isNbrEcrLettrage() {
      this.nbrEcrLettrage = false;
      if (this.verrouImport == 0 && this.getEcrIdOrigine() != 0L || this.getEcrEtat() == 1 || this.getEcrLettrage() != null && !this.getEcrLettrage().isEmpty() || this.getEcrRapprochement() != null && !this.getEcrRapprochement().isEmpty()) {
         this.nbrEcrLettrage = true;
      }

      return this.nbrEcrLettrage;
   }

   public void setNbrEcrLettrage(boolean var1) {
      this.nbrEcrLettrage = var1;
   }

   public String getLib_etat() {
      if (this.ecrEtat == 0) {
         this.lib_etat = "E.C.";
      } else if (this.ecrEtat == 1) {
         this.lib_etat = "Val.";
      } else if (this.ecrEtat == 2) {
         this.lib_etat = "Att.";
      }

      return this.lib_etat;
   }

   public void setLib_etat(String var1) {
      this.lib_etat = var1;
   }

   public String getCouleur() {
      if (this.ecrEtat == 2) {
         this.couleur = "blue";
      } else {
         this.couleur = "black";
      }

      return this.couleur;
   }

   public void setCouleur(String var1) {
      this.couleur = var1;
   }

   public boolean isSel_ecriture() {
      return this.sel_ecriture;
   }

   public void setSel_ecriture(boolean var1) {
      this.sel_ecriture = var1;
   }

   public String getGras() {
      if (this.sel_ecriture) {
         this.gras = "font-weight:bold;text-align:right;";
      } else {
         this.gras = "";
      }

      return this.gras;
   }

   public void setGras(String var1) {
      this.gras = var1;
   }

   public int getEcrAnaActif() {
      return this.ecrAnaActif;
   }

   public void setEcrAnaActif(int var1) {
      this.ecrAnaActif = var1;
   }

   public String getEcrAnnee() {
      return this.ecrAnnee;
   }

   public void setEcrAnnee(String var1) {
      this.ecrAnnee = var1;
   }

   public String getEcrClasse() {
      return this.ecrClasse;
   }

   public void setEcrClasse(String var1) {
      this.ecrClasse = var1;
   }

   public String getEcrCle1() {
      return this.ecrCle1;
   }

   public void setEcrCle1(String var1) {
      this.ecrCle1 = var1;
   }

   public String getEcrCle2() {
      return this.ecrCle2;
   }

   public void setEcrCle2(String var1) {
      this.ecrCle2 = var1;
   }

   public int getEcrCloture() {
      return this.ecrCloture;
   }

   public void setEcrCloture(int var1) {
      this.ecrCloture = var1;
   }

   public String getEcrCode() {
      return this.ecrCode;
   }

   public void setEcrCode(String var1) {
      this.ecrCode = var1;
   }

   public float getEcrCoefEuro() {
      return this.ecrCoefEuro;
   }

   public void setEcrCoefEuro(float var1) {
      this.ecrCoefEuro = var1;
   }

   public float getEcrCoefGrp() {
      return this.ecrCoefGrp;
   }

   public void setEcrCoefGrp(float var1) {
      this.ecrCoefGrp = var1;
   }

   public float getEcrCoefPays() {
      return this.ecrCoefPays;
   }

   public void setEcrCoefPays(float var1) {
      this.ecrCoefPays = var1;
   }

   public String getEcrCompte() {
      return this.ecrCompte;
   }

   public void setEcrCompte(String var1) {
      this.ecrCompte = var1;
   }

   public String getEcrContrePartie() {
      return this.ecrContrePartie;
   }

   public void setEcrContrePartie(String var1) {
      this.ecrContrePartie = var1;
   }

   public double getEcrCreditEuro() {
      return this.ecrCreditEuro;
   }

   public void setEcrCreditEuro(double var1) {
      this.ecrCreditEuro = var1;
   }

   public double getEcrCreditGrp() {
      return this.ecrCreditGrp;
   }

   public void setEcrCreditGrp(double var1) {
      this.ecrCreditGrp = var1;
   }

   public double getEcrCreditPays() {
      return this.ecrCreditPays;
   }

   public void setEcrCreditPays(double var1) {
      this.ecrCreditPays = var1;
   }

   public double getEcrCreditSaisie() {
      return this.ecrCreditSaisie;
   }

   public void setEcrCreditSaisie(double var1) {
      this.ecrCreditSaisie = var1;
   }

   public Date getEcrDateCreat() {
      return this.ecrDateCreat;
   }

   public void setEcrDateCreat(Date var1) {
      this.ecrDateCreat = var1;
   }

   public Date getEcrDateEcheance() {
      return this.ecrDateEcheance;
   }

   public void setEcrDateEcheance(Date var1) {
      this.ecrDateEcheance = var1;
   }

   public Date getEcrDateModif() {
      return this.ecrDateModif;
   }

   public void setEcrDateModif(Date var1) {
      this.ecrDateModif = var1;
   }

   public Date getEcrDatePaiement() {
      return this.ecrDatePaiement;
   }

   public void setEcrDatePaiement(Date var1) {
      this.ecrDatePaiement = var1;
   }

   public Date getEcrDateSaisie() {
      return this.ecrDateSaisie;
   }

   public void setEcrDateSaisie(Date var1) {
      this.ecrDateSaisie = var1;
   }

   public Date getEcrDateValeurReelle() {
      return this.ecrDateValeurReelle;
   }

   public void setEcrDateValeurReelle(Date var1) {
      this.ecrDateValeurReelle = var1;
   }

   public Date getEcrDateValeurTheo() {
      return this.ecrDateValeurTheo;
   }

   public void setEcrDateValeurTheo(Date var1) {
      this.ecrDateValeurTheo = var1;
   }

   public double getEcrDebitEuro() {
      return this.ecrDebitEuro;
   }

   public void setEcrDebitEuro(double var1) {
      this.ecrDebitEuro = var1;
   }

   public double getEcrDebitGrp() {
      return this.ecrDebitGrp;
   }

   public void setEcrDebitGrp(double var1) {
      this.ecrDebitGrp = var1;
   }

   public double getEcrDebitPays() {
      return this.ecrDebitPays;
   }

   public void setEcrDebitPays(double var1) {
      this.ecrDebitPays = var1;
   }

   public double getEcrDebitSaisie() {
      return this.ecrDebitSaisie;
   }

   public void setEcrDebitSaisie(double var1) {
      this.ecrDebitSaisie = var1;
   }

   public String getEcrDeviseGrp() {
      return this.ecrDeviseGrp;
   }

   public void setEcrDeviseGrp(String var1) {
      this.ecrDeviseGrp = var1;
   }

   public String getEcrDevisePays() {
      return this.ecrDevisePays;
   }

   public void setEcrDevisePays(String var1) {
      this.ecrDevisePays = var1;
   }

   public String getEcrDeviseSaisie() {
      return this.ecrDeviseSaisie;
   }

   public void setEcrDeviseSaisie(String var1) {
      this.ecrDeviseSaisie = var1;
   }

   public long getEcrIdOrigine() {
      return this.ecrIdOrigine;
   }

   public void setEcrIdOrigine(long var1) {
      this.ecrIdOrigine = var1;
   }

   public int getEcrJour() {
      return this.ecrJour;
   }

   public void setEcrJour(int var1) {
      this.ecrJour = var1;
   }

   public String getEcrLettrage() {
      return this.ecrLettrage;
   }

   public void setEcrLettrage(String var1) {
      this.ecrLettrage = var1;
   }

   public String getEcrLibCompte() {
      return this.ecrLibCompte;
   }

   public void setEcrLibCompte(String var1) {
      this.ecrLibCompte = var1;
   }

   public String getEcrLibelle() {
      return this.ecrLibelle;
   }

   public void setEcrLibelle(String var1) {
      this.ecrLibelle = var1;
   }

   public int getEcrNature() {
      return this.ecrNature;
   }

   public void setEcrNature(int var1) {
      this.ecrNature = var1;
   }

   public int getEcrNatureJrx() {
      return this.ecrNatureJrx;
   }

   public void setEcrNatureJrx(int var1) {
      this.ecrNatureJrx = var1;
   }

   public String getEcrNumIf() {
      return this.ecrNumIf;
   }

   public void setEcrNumIf(String var1) {
      this.ecrNumIf = var1;
   }

   public long getEcrOrdre() {
      return this.ecrOrdre;
   }

   public void setEcrOrdre(long var1) {
      this.ecrOrdre = var1;
   }

   public String getEcrPeriode() {
      return this.ecrPeriode;
   }

   public void setEcrPeriode(String var1) {
      this.ecrPeriode = var1;
   }

   public String getEcrPiece() {
      return this.ecrPiece;
   }

   public void setEcrPiece(String var1) {
      this.ecrPiece = var1;
   }

   public String getEcrPointage() {
      return this.ecrPointage;
   }

   public void setEcrPointage(String var1) {
      this.ecrPointage = var1;
   }

   public String getEcrRapprochement() {
      return this.ecrRapprochement;
   }

   public void setEcrRapprochement(String var1) {
      this.ecrRapprochement = var1;
   }

   public String getEcrReference1() {
      return this.ecrReference1;
   }

   public void setEcrReference1(String var1) {
      this.ecrReference1 = var1;
   }

   public String getEcrReference2() {
      return this.ecrReference2;
   }

   public void setEcrReference2(String var1) {
      this.ecrReference2 = var1;
   }

   public int getEcrReserve() {
      return this.ecrReserve;
   }

   public void setEcrReserve(int var1) {
      this.ecrReserve = var1;
   }

   public String getEcrTreso() {
      return this.ecrTreso;
   }

   public void setEcrTreso(String var1) {
      this.ecrTreso = var1;
   }

   public long getEcrUserCreat() {
      return this.ecrUserCreat;
   }

   public void setEcrUserCreat(long var1) {
      this.ecrUserCreat = var1;
   }

   public long getEcrUserModif() {
      return this.ecrUserModif;
   }

   public void setEcrUserModif(long var1) {
      this.ecrUserModif = var1;
   }

   public long getEcr_id() {
      return this.ecr_id;
   }

   public void setEcr_id(long var1) {
      this.ecr_id = var1;
   }

   public ExercicesComptable getExercicesComptable() {
      return this.exercicesComptable;
   }

   public void setExercicesComptable(ExercicesComptable var1) {
      this.exercicesComptable = var1;
   }

   public String getEcrTypeOrigine() {
      return this.ecrTypeOrigine;
   }

   public void setEcrTypeOrigine(String var1) {
      this.ecrTypeOrigine = var1;
   }

   public Brouillard getBrouillard() {
      return this.brouillard;
   }

   public void setBrouillard(Brouillard var1) {
      this.brouillard = var1;
   }

   public int getEcrEtat() {
      return this.ecrEtat;
   }

   public void setEcrEtat(int var1) {
      this.ecrEtat = var1;
   }

   public int getEcrOrigineBanque() {
      return this.ecrOrigineBanque;
   }

   public void setEcrOrigineBanque(int var1) {
      this.ecrOrigineBanque = var1;
   }

   public String getEcrNumTrf() {
      return this.ecrNumTrf;
   }

   public void setEcrNumTrf(String var1) {
      this.ecrNumTrf = var1;
   }

   public String getEcrBudgetTreso() {
      return this.ecrBudgetTreso;
   }

   public void setEcrBudgetTreso(String var1) {
      this.ecrBudgetTreso = var1;
   }

   public String getEcrPosteTreso() {
      return this.ecrPosteTreso;
   }

   public void setEcrPosteTreso(String var1) {
      this.ecrPosteTreso = var1;
   }

   public String getEcrDossier() {
      return this.ecrDossier;
   }

   public void setEcrDossier(String var1) {
      this.ecrDossier = var1;
   }

   public boolean isEcrAnaAxe01() {
      return this.ecrAnaAxe01;
   }

   public void setEcrAnaAxe01(boolean var1) {
      this.ecrAnaAxe01 = var1;
   }

   public boolean isEcrAnaAxe02() {
      return this.ecrAnaAxe02;
   }

   public void setEcrAnaAxe02(boolean var1) {
      this.ecrAnaAxe02 = var1;
   }

   public boolean isEcrAnaAxe03() {
      return this.ecrAnaAxe03;
   }

   public void setEcrAnaAxe03(boolean var1) {
      this.ecrAnaAxe03 = var1;
   }

   public boolean isEcrAnaAxe04() {
      return this.ecrAnaAxe04;
   }

   public void setEcrAnaAxe04(boolean var1) {
      this.ecrAnaAxe04 = var1;
   }

   public boolean isEcrAnaAxe05() {
      return this.ecrAnaAxe05;
   }

   public void setEcrAnaAxe05(boolean var1) {
      this.ecrAnaAxe05 = var1;
   }

   public boolean isEcrAnaAxe06() {
      return this.ecrAnaAxe06;
   }

   public void setEcrAnaAxe06(boolean var1) {
      this.ecrAnaAxe06 = var1;
   }

   public boolean isEcrAnaAxe07() {
      return this.ecrAnaAxe07;
   }

   public void setEcrAnaAxe07(boolean var1) {
      this.ecrAnaAxe07 = var1;
   }

   public boolean isEcrAnaAxe08() {
      return this.ecrAnaAxe08;
   }

   public void setEcrAnaAxe08(boolean var1) {
      this.ecrAnaAxe08 = var1;
   }

   public boolean isEcrAnaAxe09() {
      return this.ecrAnaAxe09;
   }

   public void setEcrAnaAxe09(boolean var1) {
      this.ecrAnaAxe09 = var1;
   }

   public boolean isEcrAnaAxe11() {
      return this.ecrAnaAxe11;
   }

   public void setEcrAnaAxe11(boolean var1) {
      this.ecrAnaAxe11 = var1;
   }

   public boolean isEcrAnaAxe12() {
      return this.ecrAnaAxe12;
   }

   public void setEcrAnaAxe12(boolean var1) {
      this.ecrAnaAxe12 = var1;
   }

   public boolean isEcrAnaAxe13() {
      return this.ecrAnaAxe13;
   }

   public void setEcrAnaAxe13(boolean var1) {
      this.ecrAnaAxe13 = var1;
   }

   public boolean isEcrAnaAxe10() {
      return this.ecrAnaAxe10;
   }

   public void setEcrAnaAxe10(boolean var1) {
      this.ecrAnaAxe10 = var1;
   }

   public Date getEcrDteRapprochement() {
      return this.ecrDteRapprochement;
   }

   public void setEcrDteRapprochement(Date var1) {
      this.ecrDteRapprochement = var1;
   }

   public boolean isEcrPj() {
      return this.ecrPj;
   }

   public void setEcrPj(boolean var1) {
      this.ecrPj = var1;
   }

   public int getVerrouImport() {
      return this.verrouImport;
   }

   public void setVerrouImport(int var1) {
      this.verrouImport = var1;
   }
}
