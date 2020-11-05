package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class LaboratoireLigne implements Serializable {
   private long labligId;
   private String labligLaboratoire;
   private String labligProduit;
   private String labligLibelle;
   private String labligFamille;
   private String labligLettre;
   private float labligNb;
   private float labligNbCnamgs;
   private double labligValeur;
   private double labligValeurCnamgs;
   private float labligCoef;
   private double labligPu;
   private double labligPuCnamgs;
   private double labligPuAssurance;
   private float labligRemise;
   private double labligRabais;
   private double labligPuRem;
   private float labligQte;
   private double labligPatientHt;
   private double labligPatientTaxe;
   private double labligSocieteHt;
   private double labligSocieteTaxe;
   private double labligAssuranceHt;
   private double labligAssuranceTaxe;
   private double labligComplementaireHt;
   private double labligComplementaireTaxe;
   private double labligTotal;
   private double labligTaxe;
   private float labligTauxTva;
   private String labligCodeTva;
   private int labligEtat;
   private String labligAppareil;
   private Date labligDateRealisee;
   private double labligRegPatient;
   private double labligRegTiers;
   private String labligCommentaire;
   private String labligScan;
   private LaboratoireEntete laboratoireEntete;
   private double totalTiers;
   private double totlalPatient;
   private String libelle_etat;
   private double nouveauPaiement;
   private int typeExamen;
   private double resultatExamenNumerique;
   private Date resultatExamenDate;
   private String resultatExamenTexte;
   private boolean ouvertureZone;

   public Date getResultatExamenDate() {
      return this.resultatExamenDate;
   }

   public void setResultatExamenDate(Date var1) {
      this.resultatExamenDate = var1;
   }

   public String getResultatExamenTexte() {
      return this.resultatExamenTexte;
   }

   public void setResultatExamenTexte(String var1) {
      this.resultatExamenTexte = var1;
   }

   public boolean isOuvertureZone() {
      return this.ouvertureZone;
   }

   public void setOuvertureZone(boolean var1) {
      this.ouvertureZone = var1;
   }

   public double getResultatExamenNumerique() {
      return this.resultatExamenNumerique;
   }

   public void setResultatExamenNumerique(double var1) {
      this.resultatExamenNumerique = var1;
   }

   public int getTypeExamen() {
      return this.typeExamen;
   }

   public void setTypeExamen(int var1) {
      this.typeExamen = var1;
   }

   public double getNouveauPaiement() {
      return this.nouveauPaiement;
   }

   public void setNouveauPaiement(double var1) {
      this.nouveauPaiement = var1;
   }

   public String getLibelle_etat() {
      if (this.labligEtat == 0) {
         this.libelle_etat = "En cours";
      } else if (this.labligEtat == 1) {
         this.libelle_etat = "Effectué";
      } else if (this.labligEtat == 2) {
         this.libelle_etat = "Gelé";
      } else if (this.labligEtat == 3) {
         this.libelle_etat = "Annulé";
      } else if (this.labligEtat == 4) {
         this.libelle_etat = "Cloturé";
      }

      return this.libelle_etat;
   }

   public void setLibelle_etat(String var1) {
      this.libelle_etat = var1;
   }

   public double getTotalTiers() {
      this.totalTiers = this.labligAssuranceHt + this.labligAssuranceTaxe + this.labligComplementaireHt + this.labligComplementaireTaxe + this.labligSocieteHt + this.labligSocieteTaxe;
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public double getTotlalPatient() {
      this.totlalPatient = this.labligPatientHt + this.labligPatientTaxe;
      return this.totlalPatient;
   }

   public void setTotlalPatient(double var1) {
      this.totlalPatient = var1;
   }

   public double getLabligAssuranceHt() {
      return this.labligAssuranceHt;
   }

   public void setLabligAssuranceHt(double var1) {
      this.labligAssuranceHt = var1;
   }

   public double getLabligAssuranceTaxe() {
      return this.labligAssuranceTaxe;
   }

   public void setLabligAssuranceTaxe(double var1) {
      this.labligAssuranceTaxe = var1;
   }

   public String getLabligCodeTva() {
      return this.labligCodeTva;
   }

   public void setLabligCodeTva(String var1) {
      this.labligCodeTva = var1;
   }

   public float getLabligCoef() {
      return this.labligCoef;
   }

   public void setLabligCoef(float var1) {
      this.labligCoef = var1;
   }

   public double getLabligComplementaireHt() {
      return this.labligComplementaireHt;
   }

   public void setLabligComplementaireHt(double var1) {
      this.labligComplementaireHt = var1;
   }

   public double getLabligComplementaireTaxe() {
      return this.labligComplementaireTaxe;
   }

   public void setLabligComplementaireTaxe(double var1) {
      this.labligComplementaireTaxe = var1;
   }

   public long getLabligId() {
      return this.labligId;
   }

   public void setLabligId(long var1) {
      this.labligId = var1;
   }

   public String getLabligLettre() {
      return this.labligLettre;
   }

   public void setLabligLettre(String var1) {
      this.labligLettre = var1;
   }

   public String getLabligLibelle() {
      return this.labligLibelle;
   }

   public void setLabligLibelle(String var1) {
      this.labligLibelle = var1;
   }

   public float getLabligNb() {
      return this.labligNb;
   }

   public void setLabligNb(float var1) {
      this.labligNb = var1;
   }

   public double getLabligPatientHt() {
      return this.labligPatientHt;
   }

   public void setLabligPatientHt(double var1) {
      this.labligPatientHt = var1;
   }

   public double getLabligPatientTaxe() {
      return this.labligPatientTaxe;
   }

   public void setLabligPatientTaxe(double var1) {
      this.labligPatientTaxe = var1;
   }

   public String getLabligProduit() {
      return this.labligProduit;
   }

   public void setLabligProduit(String var1) {
      this.labligProduit = var1;
   }

   public double getLabligPu() {
      return this.labligPu;
   }

   public void setLabligPu(double var1) {
      this.labligPu = var1;
   }

   public double getLabligPuRem() {
      return this.labligPuRem;
   }

   public void setLabligPuRem(double var1) {
      this.labligPuRem = var1;
   }

   public float getLabligQte() {
      return this.labligQte;
   }

   public void setLabligQte(float var1) {
      this.labligQte = var1;
   }

   public float getLabligRemise() {
      return this.labligRemise;
   }

   public void setLabligRemise(float var1) {
      this.labligRemise = var1;
   }

   public double getLabligSocieteHt() {
      return this.labligSocieteHt;
   }

   public void setLabligSocieteHt(double var1) {
      this.labligSocieteHt = var1;
   }

   public double getLabligSocieteTaxe() {
      return this.labligSocieteTaxe;
   }

   public void setLabligSocieteTaxe(double var1) {
      this.labligSocieteTaxe = var1;
   }

   public float getLabligTauxTva() {
      return this.labligTauxTva;
   }

   public void setLabligTauxTva(float var1) {
      this.labligTauxTva = var1;
   }

   public double getLabligTaxe() {
      return this.labligTaxe;
   }

   public void setLabligTaxe(double var1) {
      this.labligTaxe = var1;
   }

   public double getLabligTotal() {
      return this.labligTotal;
   }

   public void setLabligTotal(double var1) {
      this.labligTotal = var1;
   }

   public double getLabligValeur() {
      return this.labligValeur;
   }

   public void setLabligValeur(double var1) {
      this.labligValeur = var1;
   }

   public LaboratoireEntete getLaboratoireEntete() {
      return this.laboratoireEntete;
   }

   public void setLaboratoireEntete(LaboratoireEntete var1) {
      this.laboratoireEntete = var1;
   }

   public int getLabligEtat() {
      return this.labligEtat;
   }

   public void setLabligEtat(int var1) {
      this.labligEtat = var1;
   }

   public String getLabligAppareil() {
      return this.labligAppareil;
   }

   public void setLabligAppareil(String var1) {
      this.labligAppareil = var1;
   }

   public Date getLabligDateRealisee() {
      return this.labligDateRealisee;
   }

   public void setLabligDateRealisee(Date var1) {
      this.labligDateRealisee = var1;
   }

   public String getLabligFamille() {
      return this.labligFamille;
   }

   public void setLabligFamille(String var1) {
      this.labligFamille = var1;
   }

   public float getLabligNbCnamgs() {
      return this.labligNbCnamgs;
   }

   public void setLabligNbCnamgs(float var1) {
      this.labligNbCnamgs = var1;
   }

   public double getLabligPuAssurance() {
      return this.labligPuAssurance;
   }

   public void setLabligPuAssurance(double var1) {
      this.labligPuAssurance = var1;
   }

   public double getLabligPuCnamgs() {
      return this.labligPuCnamgs;
   }

   public void setLabligPuCnamgs(double var1) {
      this.labligPuCnamgs = var1;
   }

   public double getLabligValeurCnamgs() {
      return this.labligValeurCnamgs;
   }

   public void setLabligValeurCnamgs(double var1) {
      this.labligValeurCnamgs = var1;
   }

   public double getLabligRegPatient() {
      return this.labligRegPatient;
   }

   public void setLabligRegPatient(double var1) {
      this.labligRegPatient = var1;
   }

   public String getLabligCommentaire() {
      return this.labligCommentaire;
   }

   public void setLabligCommentaire(String var1) {
      this.labligCommentaire = var1;
   }

   public String getLabligLaboratoire() {
      return this.labligLaboratoire;
   }

   public void setLabligLaboratoire(String var1) {
      this.labligLaboratoire = var1;
   }

   public double getLabligRegTiers() {
      return this.labligRegTiers;
   }

   public void setLabligRegTiers(double var1) {
      this.labligRegTiers = var1;
   }

   public String getLabligScan() {
      return this.labligScan;
   }

   public void setLabligScan(String var1) {
      this.labligScan = var1;
   }

   public double getLabligRabais() {
      return this.labligRabais;
   }

   public void setLabligRabais(double var1) {
      this.labligRabais = var1;
   }
}
