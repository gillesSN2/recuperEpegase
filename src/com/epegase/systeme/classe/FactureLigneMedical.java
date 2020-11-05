package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FactureLigneMedical implements Serializable {
   private long facligId;
   private int facligOrdre;
   private String facligCode;
   private String facligFamille;
   private String facligLibelleFamille;
   private String facligLibelle;
   private String facligReference;
   private String facligTaxe;
   private float facligTauxTaxe;
   private float facligPecCnamgs;
   private float facligQte;
   private String facligDevise;
   private double facligPu;
   private double facligPuTtc;
   private float facligTauxRemise;
   private double facligRabais;
   private double facligPuRem;
   private double facligPuRemTtc;
   private double facligPt;
   private double facligTva;
   private double facligTc;
   private double facligTtc;
   private double facligTtcActe;
   private double facligTotPatient;
   private double facligTotReglement;
   private String facligNumFeuille;
   private String facligNumBc;
   private String facligMatricule;
   private String facligMatriculeAssure;
   private String facligNomAssure;
   private String facligDossier;
   private String facligDossierAssure;
   private String facligNom;
   private String facligPrenom;
   private String facligCivilite;
   private String facligQualite;
   private String facligNumConsultation;
   private long facligIdConsultation;
   private String facligNumLaboratoire;
   private long facligIdLaboratoire;
   private String facligNumPharmacie;
   private long facligIdPharmacie;
   private String facligNumHospitalisation;
   private long facligIdHospitalisationSejour;
   private long facligIdHospitalisationActe;
   private long facligIdHospitalisationLabo;
   private long facligIdHospitalisationMedic;
   private long facligIdHospitalisationPrest;
   private Date facligDateVisite;
   private Date facligDateSortie;
   private String facligService;
   private double facligMontantPaye;
   private int facligOrigine;
   private FactureEnteteMedical factureEnteteMedical;
   private float var_qteDejaTrf;
   private float var_qteReliquat;
   private double var_totalTrf;
   private String styleLigne;
   private String numCnamgs;
   private String triPatient;
   private String patientTel;
   private String patientAdresse;
   private String employeur;

   public String getEmployeur() {
      return this.employeur;
   }

   public void setEmployeur(String var1) {
      this.employeur = var1;
   }

   public String getPatientAdresse() {
      return this.patientAdresse;
   }

   public void setPatientAdresse(String var1) {
      this.patientAdresse = var1;
   }

   public String getPatientTel() {
      return this.patientTel;
   }

   public void setPatientTel(String var1) {
      this.patientTel = var1;
   }

   public String getTriPatient() {
      if (this.facligPrenom != null && !this.facligPrenom.isEmpty()) {
         this.triPatient = this.facligNom + this.facligPrenom + this.facligDossier;
      } else {
         this.triPatient = this.facligNom + this.facligDossier;
      }

      return this.triPatient;
   }

   public void setTriPatient(String var1) {
      this.triPatient = var1;
   }

   public String getNumCnamgs() {
      return this.numCnamgs;
   }

   public void setNumCnamgs(String var1) {
      this.numCnamgs = var1;
   }

   public String getStyleLigne() {
      this.styleLigne = "font-style:normal;";
      return this.styleLigne;
   }

   public void setStyleLigne(String var1) {
      this.styleLigne = var1;
   }

   public float getVar_qteDejaTrf() {
      return this.var_qteDejaTrf;
   }

   public void setVar_qteDejaTrf(float var1) {
      this.var_qteDejaTrf = var1;
   }

   public float getVar_qteReliquat() {
      return this.var_qteReliquat;
   }

   public void setVar_qteReliquat(float var1) {
      this.var_qteReliquat = var1;
   }

   public double getVar_totalTrf() {
      return this.var_totalTrf;
   }

   public void setVar_totalTrf(double var1) {
      this.var_totalTrf = var1;
   }

   public FactureEnteteMedical getFactureEnteteMedical() {
      return this.factureEnteteMedical;
   }

   public void setFactureEnteteMedical(FactureEnteteMedical var1) {
      this.factureEnteteMedical = var1;
   }

   public String getFacligCode() {
      return this.facligCode;
   }

   public void setFacligCode(String var1) {
      this.facligCode = var1;
   }

   public String getFacligDevise() {
      return this.facligDevise;
   }

   public void setFacligDevise(String var1) {
      this.facligDevise = var1;
   }

   public String getFacligFamille() {
      return this.facligFamille;
   }

   public void setFacligFamille(String var1) {
      this.facligFamille = var1;
   }

   public long getFacligId() {
      return this.facligId;
   }

   public void setFacligId(long var1) {
      this.facligId = var1;
   }

   public String getFacligLibelle() {
      return this.facligLibelle;
   }

   public void setFacligLibelle(String var1) {
      this.facligLibelle = var1;
   }

   public double getFacligPt() {
      return this.facligPt;
   }

   public void setFacligPt(double var1) {
      this.facligPt = var1;
   }

   public double getFacligPu() {
      return this.facligPu;
   }

   public void setFacligPu(double var1) {
      this.facligPu = var1;
   }

   public double getFacligPuRem() {
      return this.facligPuRem;
   }

   public void setFacligPuRem(double var1) {
      this.facligPuRem = var1;
   }

   public float getFacligQte() {
      return this.facligQte;
   }

   public void setFacligQte(float var1) {
      this.facligQte = var1;
   }

   public double getFacligRabais() {
      return this.facligRabais;
   }

   public void setFacligRabais(double var1) {
      this.facligRabais = var1;
   }

   public String getFacligReference() {
      return this.facligReference;
   }

   public void setFacligReference(String var1) {
      this.facligReference = var1;
   }

   public float getFacligTauxRemise() {
      return this.facligTauxRemise;
   }

   public void setFacligTauxRemise(float var1) {
      this.facligTauxRemise = var1;
   }

   public float getFacligTauxTaxe() {
      return this.facligTauxTaxe;
   }

   public void setFacligTauxTaxe(float var1) {
      this.facligTauxTaxe = var1;
   }

   public String getFacligTaxe() {
      return this.facligTaxe;
   }

   public void setFacligTaxe(String var1) {
      this.facligTaxe = var1;
   }

   public double getFacligTc() {
      return this.facligTc;
   }

   public void setFacligTc(double var1) {
      this.facligTc = var1;
   }

   public double getFacligTtc() {
      return this.facligTtc;
   }

   public void setFacligTtc(double var1) {
      this.facligTtc = var1;
   }

   public double getFacligTva() {
      return this.facligTva;
   }

   public void setFacligTva(double var1) {
      this.facligTva = var1;
   }

   public double getFacligPuRemTtc() {
      return this.facligPuRemTtc;
   }

   public void setFacligPuRemTtc(double var1) {
      this.facligPuRemTtc = var1;
   }

   public double getFacligPuTtc() {
      return this.facligPuTtc;
   }

   public void setFacligPuTtc(double var1) {
      this.facligPuTtc = var1;
   }

   public int getFacligOrdre() {
      return this.facligOrdre;
   }

   public void setFacligOrdre(int var1) {
      this.facligOrdre = var1;
   }

   public String getFacligCivilite() {
      return this.facligCivilite;
   }

   public void setFacligCivilite(String var1) {
      this.facligCivilite = var1;
   }

   public String getFacligDossier() {
      return this.facligDossier;
   }

   public void setFacligDossier(String var1) {
      this.facligDossier = var1;
   }

   public String getFacligNom() {
      return this.facligNom;
   }

   public void setFacligNom(String var1) {
      this.facligNom = var1;
   }

   public String getFacligNumConsultation() {
      return this.facligNumConsultation;
   }

   public void setFacligNumConsultation(String var1) {
      this.facligNumConsultation = var1;
   }

   public String getFacligNumHospitalisation() {
      return this.facligNumHospitalisation;
   }

   public void setFacligNumHospitalisation(String var1) {
      this.facligNumHospitalisation = var1;
   }

   public String getFacligPrenom() {
      return this.facligPrenom;
   }

   public void setFacligPrenom(String var1) {
      this.facligPrenom = var1;
   }

   public Date getFacligDateVisite() {
      return this.facligDateVisite;
   }

   public void setFacligDateVisite(Date var1) {
      this.facligDateVisite = var1;
   }

   public String getFacligNumLaboratoire() {
      return this.facligNumLaboratoire;
   }

   public void setFacligNumLaboratoire(String var1) {
      this.facligNumLaboratoire = var1;
   }

   public String getFacligNumPharmacie() {
      return this.facligNumPharmacie;
   }

   public void setFacligNumPharmacie(String var1) {
      this.facligNumPharmacie = var1;
   }

   public long getFacligIdConsultation() {
      return this.facligIdConsultation;
   }

   public void setFacligIdConsultation(long var1) {
      this.facligIdConsultation = var1;
   }

   public long getFacligIdHospitalisationActe() {
      return this.facligIdHospitalisationActe;
   }

   public void setFacligIdHospitalisationActe(long var1) {
      this.facligIdHospitalisationActe = var1;
   }

   public long getFacligIdHospitalisationLabo() {
      return this.facligIdHospitalisationLabo;
   }

   public void setFacligIdHospitalisationLabo(long var1) {
      this.facligIdHospitalisationLabo = var1;
   }

   public long getFacligIdHospitalisationMedic() {
      return this.facligIdHospitalisationMedic;
   }

   public void setFacligIdHospitalisationMedic(long var1) {
      this.facligIdHospitalisationMedic = var1;
   }

   public long getFacligIdHospitalisationPrest() {
      return this.facligIdHospitalisationPrest;
   }

   public void setFacligIdHospitalisationPrest(long var1) {
      this.facligIdHospitalisationPrest = var1;
   }

   public long getFacligIdHospitalisationSejour() {
      return this.facligIdHospitalisationSejour;
   }

   public void setFacligIdHospitalisationSejour(long var1) {
      this.facligIdHospitalisationSejour = var1;
   }

   public long getFacligIdLaboratoire() {
      return this.facligIdLaboratoire;
   }

   public void setFacligIdLaboratoire(long var1) {
      this.facligIdLaboratoire = var1;
   }

   public long getFacligIdPharmacie() {
      return this.facligIdPharmacie;
   }

   public void setFacligIdPharmacie(long var1) {
      this.facligIdPharmacie = var1;
   }

   public String getFacligService() {
      return this.facligService;
   }

   public void setFacligService(String var1) {
      this.facligService = var1;
   }

   public String getFacligLibelleFamille() {
      return this.facligLibelleFamille;
   }

   public void setFacligLibelleFamille(String var1) {
      this.facligLibelleFamille = var1;
   }

   public double getFacligTotReglement() {
      return this.facligTotReglement;
   }

   public void setFacligTotReglement(double var1) {
      this.facligTotReglement = var1;
   }

   public Date getFacligDateSortie() {
      return this.facligDateSortie;
   }

   public void setFacligDateSortie(Date var1) {
      this.facligDateSortie = var1;
   }

   public String getFacligMatricule() {
      return this.facligMatricule;
   }

   public void setFacligMatricule(String var1) {
      this.facligMatricule = var1;
   }

   public String getFacligNomAssure() {
      return this.facligNomAssure;
   }

   public void setFacligNomAssure(String var1) {
      this.facligNomAssure = var1;
   }

   public double getFacligTtcActe() {
      return this.facligTtcActe;
   }

   public void setFacligTtcActe(double var1) {
      this.facligTtcActe = var1;
   }

   public String getFacligQualite() {
      return this.facligQualite;
   }

   public void setFacligQualite(String var1) {
      this.facligQualite = var1;
   }

   public double getFacligMontantPaye() {
      return this.facligMontantPaye;
   }

   public void setFacligMontantPaye(double var1) {
      this.facligMontantPaye = var1;
   }

   public double getFacligTotPatient() {
      return this.facligTotPatient;
   }

   public void setFacligTotPatient(double var1) {
      this.facligTotPatient = var1;
   }

   public String getFacligNumBc() {
      return this.facligNumBc;
   }

   public void setFacligNumBc(String var1) {
      this.facligNumBc = var1;
   }

   public String getFacligNumFeuille() {
      return this.facligNumFeuille;
   }

   public void setFacligNumFeuille(String var1) {
      this.facligNumFeuille = var1;
   }

   public float getFacligPecCnamgs() {
      return this.facligPecCnamgs;
   }

   public void setFacligPecCnamgs(float var1) {
      this.facligPecCnamgs = var1;
   }

   public String getFacligMatriculeAssure() {
      return this.facligMatriculeAssure;
   }

   public void setFacligMatriculeAssure(String var1) {
      this.facligMatriculeAssure = var1;
   }

   public String getFacligDossierAssure() {
      return this.facligDossierAssure;
   }

   public void setFacligDossierAssure(String var1) {
      this.facligDossierAssure = var1;
   }

   public int getFacligOrigine() {
      return this.facligOrigine;
   }

   public void setFacligOrigine(int var1) {
      this.facligOrigine = var1;
   }
}
