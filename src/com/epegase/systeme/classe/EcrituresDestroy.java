package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class EcrituresDestroy implements Serializable {
   private long ecrId;
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
   private boolean ecrAnaAxe11;
   private boolean ecrAnaAxe12;
   private boolean ecrAnaAxe13;
   private Date ecrDateDelete;
   private long ecrUserDelete;
   private long ecrIdGene;
   private boolean sel_ecriture;

   public boolean isSel_ecriture() {
      return this.sel_ecriture;
   }

   public void setSel_ecriture(boolean var1) {
      this.sel_ecriture = var1;
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

   public Date getEcrDateDelete() {
      return this.ecrDateDelete;
   }

   public void setEcrDateDelete(Date var1) {
      this.ecrDateDelete = var1;
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

   public long getEcrUserDelete() {
      return this.ecrUserDelete;
   }

   public void setEcrUserDelete(long var1) {
      this.ecrUserDelete = var1;
   }

   public long getEcrUserModif() {
      return this.ecrUserModif;
   }

   public void setEcrUserModif(long var1) {
      this.ecrUserModif = var1;
   }

   public String getEcrTypeOrigine() {
      return this.ecrTypeOrigine;
   }

   public void setEcrTypeOrigine(String var1) {
      this.ecrTypeOrigine = var1;
   }

   public long getEcrIdGene() {
      return this.ecrIdGene;
   }

   public void setEcrIdGene(long var1) {
      this.ecrIdGene = var1;
   }

   public int getEcrAnaActif() {
      return this.ecrAnaActif;
   }

   public void setEcrAnaActif(int var1) {
      this.ecrAnaActif = var1;
   }

   public int getEcrEtat() {
      return this.ecrEtat;
   }

   public void setEcrEtat(int var1) {
      this.ecrEtat = var1;
   }

   public String getEcrLibCompte() {
      return this.ecrLibCompte;
   }

   public void setEcrLibCompte(String var1) {
      this.ecrLibCompte = var1;
   }

   public int getEcrOrigineBanque() {
      return this.ecrOrigineBanque;
   }

   public void setEcrOrigineBanque(int var1) {
      this.ecrOrigineBanque = var1;
   }

   public long getEcrId() {
      return this.ecrId;
   }

   public void setEcrId(long var1) {
      this.ecrId = var1;
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

   public Date getEcrDteRapprochement() {
      return this.ecrDteRapprochement;
   }

   public void setEcrDteRapprochement(Date var1) {
      this.ecrDteRapprochement = var1;
   }
}
