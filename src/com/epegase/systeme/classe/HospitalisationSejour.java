package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class HospitalisationSejour implements Serializable {
   private long hossejId;
   private Date hossejDateCreat;
   private Date hossejDateModif;
   private long hossejUserCreat;
   private long hossejUserModif;
   private String hossejLit;
   private String hossejLibelle;
   private Date hossejDateEntree;
   private Date hossejDateSortie;
   private int hossejNbJourTheo;
   private int hossejNbJour;
   private String hossejService;
   private long hossejIdMedecin;
   private String hossejMedecin;
   private String hossejMotifEntree;
   private String hossejProvenance;
   private String hossejMotifSortie;
   private String hossejDestination;
   private float hossejCoef;
   private double hossejPu;
   private double hossejPuCnamgs;
   private double hossejPuAssurance;
   private float hossejRemise;
   private double hossejRabais;
   private double hossejPuRem;
   private double hossejPatientHt;
   private double hossejPatientTaxe;
   private double hossejSocieteHt;
   private double hossejSocieteTaxe;
   private double hossejAssuranceHt;
   private double hossejAssuranceTaxe;
   private double hossejComplementaireHt;
   private double hossejComplementaireTaxe;
   private double hossejTotal;
   private double hossejTaxe;
   private float hossejTauxTva;
   private String hossejCodeTva;
   private String hossejCodeDiag1;
   private String hossejCodeDiag2;
   private String hossejCodeDiag11;
   private String hossejCodeDiag12;
   private String hossejCodeDiag13;
   private String hossejCodeDiag14;
   private String hossejCodeDiag15;
   private int hossejPoidsEntree;
   private int hossejIndiceIgs;
   private int hossejNbSeances;
   private boolean hossejHospitAvant;
   private boolean hossejHospit48;
   private String hossejEvolution;
   private String hossejObservation;
   private double hossejRegPatient;
   private double hossejRegTiers;
   private HospitalisationEntete hospitalisationEntete;
   private Patients patients;
   private double totalPatient;
   private double totalTiers;
   private String lib_diag1;
   private String lib_diag2;
   private String lib_diag11;
   private String lib_diag12;
   private String lib_diag13;
   private String lib_diag14;
   private String lib_diag15;
   private String libelleProvenance;
   private String libelleDestination;
   private String antecedent;
   private String examensComplementaires;
   private String medicaments;
   private String evolution;
   private String observationsComplementaires;
   private String code;
   private String libelle;
   private String lettre;
   private String service;
   private String medecin;
   private float qte;
   private double valeur;
   private double pu;
   private double pt;
   private double pt_tiers;
   private double reg_pat;
   private double reg_tiers;
   private int type;
   private Date date;

   public Date getDate() {
      return this.date;
   }

   public void setDate(Date var1) {
      this.date = var1;
   }

   public String getAntecedent() {
      return this.antecedent;
   }

   public void setAntecedent(String var1) {
      this.antecedent = var1;
   }

   public String getEvolution() {
      return this.evolution;
   }

   public void setEvolution(String var1) {
      this.evolution = var1;
   }

   public String getExamensComplementaires() {
      return this.examensComplementaires;
   }

   public void setExamensComplementaires(String var1) {
      this.examensComplementaires = var1;
   }

   public String getMedicaments() {
      return this.medicaments;
   }

   public void setMedicaments(String var1) {
      this.medicaments = var1;
   }

   public String getObservationsComplementaires() {
      return this.observationsComplementaires;
   }

   public void setObservationsComplementaires(String var1) {
      this.observationsComplementaires = var1;
   }

   public String getLibelleDestination() {
      if (this.hossejMotifSortie != null && !this.hossejMotifSortie.isEmpty()) {
         if (this.hossejMotifSortie.equals("0")) {
            this.libelleDestination = "Trf. autre service";
         } else if (this.hossejMotifSortie.equals("6")) {
            this.libelleDestination = "Mutation";
         } else if (this.hossejMotifSortie.equals("7")) {
            this.libelleDestination = "Trf. normal";
         } else if (this.hossejMotifSortie.equals("8")) {
            this.libelleDestination = "Domicile";
         } else if (this.hossejMotifSortie.equals("9")) {
            this.libelleDestination = "Dècés";
         } else {
            this.libelleDestination = "";
         }
      } else {
         this.libelleDestination = "";
      }

      return this.libelleDestination;
   }

   public void setLibelleDestination(String var1) {
      this.libelleDestination = var1;
   }

   public String getLibelleProvenance() {
      if (this.hossejMotifEntree != null && !this.hossejMotifEntree.isEmpty()) {
         if (this.hossejMotifEntree.equals("0")) {
            this.libelleProvenance = "Trf. autre service";
         } else if (this.hossejMotifEntree.equals("6")) {
            this.libelleProvenance = "Mutation";
         } else if (this.hossejMotifEntree.equals("7")) {
            this.libelleProvenance = "Trf. normal";
         } else if (this.hossejMotifEntree.equals("8")) {
            this.libelleProvenance = "Domicile";
         } else {
            this.libelleProvenance = "";
         }
      } else {
         this.libelleProvenance = "";
      }

      return this.libelleProvenance;
   }

   public void setLibelleProvenance(String var1) {
      this.libelleProvenance = var1;
   }

   public double getTotalPatient() {
      this.totalPatient = this.hossejPatientHt + this.hossejPatientTaxe;
      return this.totalPatient;
   }

   public void setTotalPatient(double var1) {
      this.totalPatient = var1;
   }

   public double getTotalTiers() {
      this.totalTiers = this.hossejAssuranceHt + this.hossejAssuranceTaxe + this.hossejComplementaireHt + this.hossejComplementaireTaxe + this.hossejSocieteHt + this.hossejSocieteTaxe;
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public HospitalisationEntete getHospitalisationEntete() {
      return this.hospitalisationEntete;
   }

   public void setHospitalisationEntete(HospitalisationEntete var1) {
      this.hospitalisationEntete = var1;
   }

   public Patients getPatients() {
      return this.patients;
   }

   public void setPatients(Patients var1) {
      this.patients = var1;
   }

   public double getHossejAssuranceHt() {
      return this.hossejAssuranceHt;
   }

   public void setHossejAssuranceHt(double var1) {
      this.hossejAssuranceHt = var1;
   }

   public double getHossejAssuranceTaxe() {
      return this.hossejAssuranceTaxe;
   }

   public void setHossejAssuranceTaxe(double var1) {
      this.hossejAssuranceTaxe = var1;
   }

   public String getHossejCodeTva() {
      return this.hossejCodeTva;
   }

   public void setHossejCodeTva(String var1) {
      this.hossejCodeTva = var1;
   }

   public double getHossejComplementaireHt() {
      return this.hossejComplementaireHt;
   }

   public void setHossejComplementaireHt(double var1) {
      this.hossejComplementaireHt = var1;
   }

   public double getHossejComplementaireTaxe() {
      return this.hossejComplementaireTaxe;
   }

   public void setHossejComplementaireTaxe(double var1) {
      this.hossejComplementaireTaxe = var1;
   }

   public Date getHossejDateEntree() {
      return this.hossejDateEntree;
   }

   public void setHossejDateEntree(Date var1) {
      this.hossejDateEntree = var1;
   }

   public Date getHossejDateSortie() {
      return this.hossejDateSortie;
   }

   public void setHossejDateSortie(Date var1) {
      this.hossejDateSortie = var1;
   }

   public String getHossejDestination() {
      return this.hossejDestination;
   }

   public void setHossejDestination(String var1) {
      this.hossejDestination = var1;
   }

   public long getHossejId() {
      return this.hossejId;
   }

   public void setHossejId(long var1) {
      this.hossejId = var1;
   }

   public String getHossejLibelle() {
      return this.hossejLibelle;
   }

   public void setHossejLibelle(String var1) {
      this.hossejLibelle = var1;
   }

   public String getHossejLit() {
      return this.hossejLit;
   }

   public void setHossejLit(String var1) {
      this.hossejLit = var1;
   }

   public int getHossejNbJour() {
      return this.hossejNbJour;
   }

   public void setHossejNbJour(int var1) {
      this.hossejNbJour = var1;
   }

   public double getHossejPatientHt() {
      return this.hossejPatientHt;
   }

   public void setHossejPatientHt(double var1) {
      this.hossejPatientHt = var1;
   }

   public double getHossejPatientTaxe() {
      return this.hossejPatientTaxe;
   }

   public void setHossejPatientTaxe(double var1) {
      this.hossejPatientTaxe = var1;
   }

   public String getHossejProvenance() {
      return this.hossejProvenance;
   }

   public void setHossejProvenance(String var1) {
      this.hossejProvenance = var1;
   }

   public double getHossejPu() {
      return this.hossejPu;
   }

   public void setHossejPu(double var1) {
      this.hossejPu = var1;
   }

   public double getHossejPuRem() {
      return this.hossejPuRem;
   }

   public void setHossejPuRem(double var1) {
      this.hossejPuRem = var1;
   }

   public float getHossejRemise() {
      return this.hossejRemise;
   }

   public void setHossejRemise(float var1) {
      this.hossejRemise = var1;
   }

   public String getHossejService() {
      return this.hossejService;
   }

   public void setHossejService(String var1) {
      this.hossejService = var1;
   }

   public double getHossejSocieteHt() {
      return this.hossejSocieteHt;
   }

   public void setHossejSocieteHt(double var1) {
      this.hossejSocieteHt = var1;
   }

   public double getHossejSocieteTaxe() {
      return this.hossejSocieteTaxe;
   }

   public void setHossejSocieteTaxe(double var1) {
      this.hossejSocieteTaxe = var1;
   }

   public float getHossejTauxTva() {
      return this.hossejTauxTva;
   }

   public void setHossejTauxTva(float var1) {
      this.hossejTauxTva = var1;
   }

   public double getHossejTaxe() {
      return this.hossejTaxe;
   }

   public void setHossejTaxe(double var1) {
      this.hossejTaxe = var1;
   }

   public double getHossejTotal() {
      return this.hossejTotal;
   }

   public void setHossejTotal(double var1) {
      this.hossejTotal = var1;
   }

   public long getHossejIdMedecin() {
      return this.hossejIdMedecin;
   }

   public void setHossejIdMedecin(long var1) {
      this.hossejIdMedecin = var1;
   }

   public String getHossejMedecin() {
      return this.hossejMedecin;
   }

   public void setHossejMedecin(String var1) {
      this.hossejMedecin = var1;
   }

   public String getHossejMotifEntree() {
      return this.hossejMotifEntree;
   }

   public void setHossejMotifEntree(String var1) {
      this.hossejMotifEntree = var1;
   }

   public String getHossejMotifSortie() {
      return this.hossejMotifSortie;
   }

   public void setHossejMotifSortie(String var1) {
      this.hossejMotifSortie = var1;
   }

   public String getLib_diag1() {
      return this.lib_diag1;
   }

   public void setLib_diag1(String var1) {
      this.lib_diag1 = var1;
   }

   public String getLib_diag11() {
      return this.lib_diag11;
   }

   public void setLib_diag11(String var1) {
      this.lib_diag11 = var1;
   }

   public String getLib_diag12() {
      return this.lib_diag12;
   }

   public void setLib_diag12(String var1) {
      this.lib_diag12 = var1;
   }

   public String getLib_diag13() {
      return this.lib_diag13;
   }

   public void setLib_diag13(String var1) {
      this.lib_diag13 = var1;
   }

   public String getLib_diag14() {
      return this.lib_diag14;
   }

   public void setLib_diag14(String var1) {
      this.lib_diag14 = var1;
   }

   public String getLib_diag15() {
      return this.lib_diag15;
   }

   public void setLib_diag15(String var1) {
      this.lib_diag15 = var1;
   }

   public String getLib_diag2() {
      return this.lib_diag2;
   }

   public void setLib_diag2(String var1) {
      this.lib_diag2 = var1;
   }

   public String getHossejCodeDiag1() {
      return this.hossejCodeDiag1;
   }

   public void setHossejCodeDiag1(String var1) {
      this.hossejCodeDiag1 = var1;
   }

   public String getHossejCodeDiag11() {
      return this.hossejCodeDiag11;
   }

   public void setHossejCodeDiag11(String var1) {
      this.hossejCodeDiag11 = var1;
   }

   public String getHossejCodeDiag12() {
      return this.hossejCodeDiag12;
   }

   public void setHossejCodeDiag12(String var1) {
      this.hossejCodeDiag12 = var1;
   }

   public String getHossejCodeDiag13() {
      return this.hossejCodeDiag13;
   }

   public void setHossejCodeDiag13(String var1) {
      this.hossejCodeDiag13 = var1;
   }

   public String getHossejCodeDiag14() {
      return this.hossejCodeDiag14;
   }

   public void setHossejCodeDiag14(String var1) {
      this.hossejCodeDiag14 = var1;
   }

   public String getHossejCodeDiag15() {
      return this.hossejCodeDiag15;
   }

   public void setHossejCodeDiag15(String var1) {
      this.hossejCodeDiag15 = var1;
   }

   public String getHossejCodeDiag2() {
      return this.hossejCodeDiag2;
   }

   public void setHossejCodeDiag2(String var1) {
      this.hossejCodeDiag2 = var1;
   }

   public String getHossejEvolution() {
      return this.hossejEvolution;
   }

   public void setHossejEvolution(String var1) {
      this.hossejEvolution = var1;
   }

   public boolean isHossejHospit48() {
      return this.hossejHospit48;
   }

   public void setHossejHospit48(boolean var1) {
      this.hossejHospit48 = var1;
   }

   public boolean isHossejHospitAvant() {
      return this.hossejHospitAvant;
   }

   public void setHossejHospitAvant(boolean var1) {
      this.hossejHospitAvant = var1;
   }

   public int getHossejIndiceIgs() {
      return this.hossejIndiceIgs;
   }

   public void setHossejIndiceIgs(int var1) {
      this.hossejIndiceIgs = var1;
   }

   public int getHossejNbSeances() {
      return this.hossejNbSeances;
   }

   public void setHossejNbSeances(int var1) {
      this.hossejNbSeances = var1;
   }

   public String getHossejObservation() {
      return this.hossejObservation;
   }

   public void setHossejObservation(String var1) {
      this.hossejObservation = var1;
   }

   public int getHossejPoidsEntree() {
      return this.hossejPoidsEntree;
   }

   public void setHossejPoidsEntree(int var1) {
      this.hossejPoidsEntree = var1;
   }

   public double getHossejPuAssurance() {
      return this.hossejPuAssurance;
   }

   public void setHossejPuAssurance(double var1) {
      this.hossejPuAssurance = var1;
   }

   public double getHossejPuCnamgs() {
      return this.hossejPuCnamgs;
   }

   public void setHossejPuCnamgs(double var1) {
      this.hossejPuCnamgs = var1;
   }

   public float getHossejCoef() {
      return this.hossejCoef;
   }

   public void setHossejCoef(float var1) {
      this.hossejCoef = var1;
   }

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public String getLettre() {
      return this.lettre;
   }

   public void setLettre(String var1) {
      this.lettre = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }

   public double getValeur() {
      return this.valeur;
   }

   public void setValeur(double var1) {
      this.valeur = var1;
   }

   public double getPt() {
      return this.pt;
   }

   public void setPt(double var1) {
      this.pt = var1;
   }

   public double getPu() {
      return this.pu;
   }

   public void setPu(double var1) {
      this.pu = var1;
   }

   public float getQte() {
      return this.qte;
   }

   public void setQte(float var1) {
      this.qte = var1;
   }

   public int getType() {
      return this.type;
   }

   public void setType(int var1) {
      this.type = var1;
   }

   public String getService() {
      return this.service;
   }

   public void setService(String var1) {
      this.service = var1;
   }

   public String getMedecin() {
      return this.medecin;
   }

   public void setMedecin(String var1) {
      this.medecin = var1;
   }

   public double getHossejRegPatient() {
      return this.hossejRegPatient;
   }

   public void setHossejRegPatient(double var1) {
      this.hossejRegPatient = var1;
   }

   public double getHossejRegTiers() {
      return this.hossejRegTiers;
   }

   public void setHossejRegTiers(double var1) {
      this.hossejRegTiers = var1;
   }

   public int getHossejNbJourTheo() {
      return this.hossejNbJourTheo;
   }

   public void setHossejNbJourTheo(int var1) {
      this.hossejNbJourTheo = var1;
   }

   public double getPt_tiers() {
      return this.pt_tiers;
   }

   public void setPt_tiers(double var1) {
      this.pt_tiers = var1;
   }

   public double getReg_pat() {
      return this.reg_pat;
   }

   public void setReg_pat(double var1) {
      this.reg_pat = var1;
   }

   public double getReg_tiers() {
      return this.reg_tiers;
   }

   public void setReg_tiers(double var1) {
      this.reg_tiers = var1;
   }

   public Date getHossejDateCreat() {
      return this.hossejDateCreat;
   }

   public void setHossejDateCreat(Date var1) {
      this.hossejDateCreat = var1;
   }

   public Date getHossejDateModif() {
      return this.hossejDateModif;
   }

   public void setHossejDateModif(Date var1) {
      this.hossejDateModif = var1;
   }

   public long getHossejUserCreat() {
      return this.hossejUserCreat;
   }

   public void setHossejUserCreat(long var1) {
      this.hossejUserCreat = var1;
   }

   public long getHossejUserModif() {
      return this.hossejUserModif;
   }

   public void setHossejUserModif(long var1) {
      this.hossejUserModif = var1;
   }

   public double getHossejRabais() {
      return this.hossejRabais;
   }

   public void setHossejRabais(double var1) {
      this.hossejRabais = var1;
   }
}
