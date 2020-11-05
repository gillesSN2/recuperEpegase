package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class SalariesElements implements Serializable {
   private long saleleId;
   private Date saleleDateCreat;
   private Date saleleDateModif;
   private long saleleUserCreat;
   private long saleleUserModif;
   private String saleleContrat;
   private String salelePeriode;
   private Date saleleJour;
   private String saleleMatricule;
   private String saleleNature;
   private int saleleEtat;
   private int saleleModeSolde;
   private String saleleCivilite;
   private String saleleFonction;
   private String saleleSite;
   private String saleleDepartement;
   private String saleleService;
   private String saleleLibService;
   private String saleleActivite;
   private String saleleLocalisation;
   private String saleleBudget;
   private String saleleParc;
   private int saleleSitFamille;
   private int saleleGenre;
   private int saleleNbEnfant;
   private float saleleNbPartFiscal;
   private int saleleNbFemme;
   private float saleleNbPartTrimf;
   private float saleleNbJourCp;
   private float saleleNbJourTr;
   private Date saleleDateMarie;
   private Date saleleDateDivorce;
   private Date saleleDateVeuf;
   private Date saleleDateConcubinage;
   private Date saleleDatePacs;
   private String saleleConvention;
   private String saleleLibConvention;
   private String saleleCentresImpots;
   private String saleleLibCentresImpots;
   private String saleleCentresSecurite;
   private String saleleLibCentresSecurite;
   private String saleleClassement;
   private String saleleLibClassement;
   private String saleleNivEmploi;
   private String saleleLibNivEmploi;
   private String saleleGrille;
   private String saleleLibGrille;
   private String saleleFeuille;
   private Date saleleDateEntree;
   private Date saleleDateSortie;
   private String saleleMotifSortie;
   private String saleleCle1Anal;
   private String saleleCle2Anal;
   private String saleleLibCle1Anal;
   private String saleleLibCle2Anal;
   private int saleleModeReglement;
   private String saleleNumBanque;
   private String saleleGuichetBanque;
   private String saleleCompteBanque;
   private String saleleCleBanque;
   private String saleleIban;
   private String saleleSwift;
   private String saleleCompteMembre;
   private int saleleDureeJour;
   private int saleleChefFamille;
   private Salaries salaries;
   private boolean effectue;

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public boolean isEffectue() {
      return this.effectue;
   }

   public void setEffectue(boolean var1) {
      this.effectue = var1;
   }

   public String getSaleleActivite() {
      return this.saleleActivite;
   }

   public void setSaleleActivite(String var1) {
      this.saleleActivite = var1;
   }

   public String getSaleleBudget() {
      return this.saleleBudget;
   }

   public void setSaleleBudget(String var1) {
      this.saleleBudget = var1;
   }

   public String getSaleleCentresImpots() {
      return this.saleleCentresImpots;
   }

   public void setSaleleCentresImpots(String var1) {
      this.saleleCentresImpots = var1;
   }

   public String getSaleleCivilite() {
      return this.saleleCivilite;
   }

   public void setSaleleCivilite(String var1) {
      this.saleleCivilite = var1;
   }

   public String getSaleleClassement() {
      return this.saleleClassement;
   }

   public void setSaleleClassement(String var1) {
      this.saleleClassement = var1;
   }

   public String getSaleleConvention() {
      return this.saleleConvention;
   }

   public void setSaleleConvention(String var1) {
      this.saleleConvention = var1;
   }

   public Date getSaleleDateConcubinage() {
      return this.saleleDateConcubinage;
   }

   public void setSaleleDateConcubinage(Date var1) {
      this.saleleDateConcubinage = var1;
   }

   public Date getSaleleDateDivorce() {
      return this.saleleDateDivorce;
   }

   public void setSaleleDateDivorce(Date var1) {
      this.saleleDateDivorce = var1;
   }

   public Date getSaleleDateMarie() {
      return this.saleleDateMarie;
   }

   public void setSaleleDateMarie(Date var1) {
      this.saleleDateMarie = var1;
   }

   public Date getSaleleDatePacs() {
      return this.saleleDatePacs;
   }

   public void setSaleleDatePacs(Date var1) {
      this.saleleDatePacs = var1;
   }

   public Date getSaleleDateVeuf() {
      return this.saleleDateVeuf;
   }

   public void setSaleleDateVeuf(Date var1) {
      this.saleleDateVeuf = var1;
   }

   public String getSaleleDepartement() {
      return this.saleleDepartement;
   }

   public void setSaleleDepartement(String var1) {
      this.saleleDepartement = var1;
   }

   public int getSaleleEtat() {
      return this.saleleEtat;
   }

   public void setSaleleEtat(int var1) {
      this.saleleEtat = var1;
   }

   public String getSaleleFeuille() {
      return this.saleleFeuille;
   }

   public void setSaleleFeuille(String var1) {
      this.saleleFeuille = var1;
   }

   public String getSaleleFonction() {
      return this.saleleFonction;
   }

   public void setSaleleFonction(String var1) {
      this.saleleFonction = var1;
   }

   public int getSaleleGenre() {
      return this.saleleGenre;
   }

   public void setSaleleGenre(int var1) {
      this.saleleGenre = var1;
   }

   public String getSaleleGrille() {
      return this.saleleGrille;
   }

   public void setSaleleGrille(String var1) {
      this.saleleGrille = var1;
   }

   public long getSaleleId() {
      return this.saleleId;
   }

   public void setSaleleId(long var1) {
      this.saleleId = var1;
   }

   public String getSaleleLibCentresImpots() {
      return this.saleleLibCentresImpots;
   }

   public void setSaleleLibCentresImpots(String var1) {
      this.saleleLibCentresImpots = var1;
   }

   public String getSaleleLibClassement() {
      return this.saleleLibClassement;
   }

   public void setSaleleLibClassement(String var1) {
      this.saleleLibClassement = var1;
   }

   public String getSaleleLibConvention() {
      return this.saleleLibConvention;
   }

   public void setSaleleLibConvention(String var1) {
      this.saleleLibConvention = var1;
   }

   public String getSaleleLibGrille() {
      return this.saleleLibGrille;
   }

   public void setSaleleLibGrille(String var1) {
      this.saleleLibGrille = var1;
   }

   public String getSaleleLibNivEmploi() {
      return this.saleleLibNivEmploi;
   }

   public void setSaleleLibNivEmploi(String var1) {
      this.saleleLibNivEmploi = var1;
   }

   public String getSaleleMatricule() {
      return this.saleleMatricule;
   }

   public void setSaleleMatricule(String var1) {
      this.saleleMatricule = var1;
   }

   public String getSaleleNature() {
      return this.saleleNature;
   }

   public void setSaleleNature(String var1) {
      this.saleleNature = var1;
   }

   public int getSaleleNbEnfant() {
      return this.saleleNbEnfant;
   }

   public void setSaleleNbEnfant(int var1) {
      this.saleleNbEnfant = var1;
   }

   public int getSaleleNbFemme() {
      return this.saleleNbFemme;
   }

   public void setSaleleNbFemme(int var1) {
      this.saleleNbFemme = var1;
   }

   public float getSaleleNbJourCp() {
      return this.saleleNbJourCp;
   }

   public void setSaleleNbJourCp(float var1) {
      this.saleleNbJourCp = var1;
   }

   public float getSaleleNbJourTr() {
      return this.saleleNbJourTr;
   }

   public void setSaleleNbJourTr(float var1) {
      this.saleleNbJourTr = var1;
   }

   public float getSaleleNbPartFiscal() {
      return this.saleleNbPartFiscal;
   }

   public void setSaleleNbPartFiscal(float var1) {
      this.saleleNbPartFiscal = var1;
   }

   public float getSaleleNbPartTrimf() {
      return this.saleleNbPartTrimf;
   }

   public void setSaleleNbPartTrimf(float var1) {
      this.saleleNbPartTrimf = var1;
   }

   public String getSaleleNivEmploi() {
      return this.saleleNivEmploi;
   }

   public void setSaleleNivEmploi(String var1) {
      this.saleleNivEmploi = var1;
   }

   public String getSaleleParc() {
      return this.saleleParc;
   }

   public void setSaleleParc(String var1) {
      this.saleleParc = var1;
   }

   public String getSaleleService() {
      return this.saleleService;
   }

   public void setSaleleService(String var1) {
      this.saleleService = var1;
   }

   public int getSaleleSitFamille() {
      return this.saleleSitFamille;
   }

   public void setSaleleSitFamille(int var1) {
      this.saleleSitFamille = var1;
   }

   public String getSaleleSite() {
      return this.saleleSite;
   }

   public void setSaleleSite(String var1) {
      this.saleleSite = var1;
   }

   public String getSalelePeriode() {
      return this.salelePeriode;
   }

   public void setSalelePeriode(String var1) {
      this.salelePeriode = var1;
   }

   public Date getSaleleDateSortie() {
      return this.saleleDateSortie;
   }

   public void setSaleleDateSortie(Date var1) {
      this.saleleDateSortie = var1;
   }

   public String getSaleleMotifSortie() {
      return this.saleleMotifSortie;
   }

   public void setSaleleMotifSortie(String var1) {
      this.saleleMotifSortie = var1;
   }

   public String getSaleleCle1Anal() {
      return this.saleleCle1Anal;
   }

   public void setSaleleCle1Anal(String var1) {
      this.saleleCle1Anal = var1;
   }

   public String getSaleleCle2Anal() {
      return this.saleleCle2Anal;
   }

   public void setSaleleCle2Anal(String var1) {
      this.saleleCle2Anal = var1;
   }

   public String getSaleleLibCle1Anal() {
      return this.saleleLibCle1Anal;
   }

   public void setSaleleLibCle1Anal(String var1) {
      this.saleleLibCle1Anal = var1;
   }

   public String getSaleleLibCle2Anal() {
      return this.saleleLibCle2Anal;
   }

   public void setSaleleLibCle2Anal(String var1) {
      this.saleleLibCle2Anal = var1;
   }

   public String getSaleleCleBanque() {
      return this.saleleCleBanque;
   }

   public void setSaleleCleBanque(String var1) {
      this.saleleCleBanque = var1;
   }

   public String getSaleleCompteBanque() {
      return this.saleleCompteBanque;
   }

   public void setSaleleCompteBanque(String var1) {
      this.saleleCompteBanque = var1;
   }

   public String getSaleleGuichetBanque() {
      return this.saleleGuichetBanque;
   }

   public void setSaleleGuichetBanque(String var1) {
      this.saleleGuichetBanque = var1;
   }

   public String getSaleleIban() {
      return this.saleleIban;
   }

   public void setSaleleIban(String var1) {
      this.saleleIban = var1;
   }

   public int getSaleleModeReglement() {
      return this.saleleModeReglement;
   }

   public void setSaleleModeReglement(int var1) {
      this.saleleModeReglement = var1;
   }

   public String getSaleleNumBanque() {
      return this.saleleNumBanque;
   }

   public void setSaleleNumBanque(String var1) {
      this.saleleNumBanque = var1;
   }

   public String getSaleleSwift() {
      return this.saleleSwift;
   }

   public void setSaleleSwift(String var1) {
      this.saleleSwift = var1;
   }

   public String getSaleleContrat() {
      return this.saleleContrat;
   }

   public void setSaleleContrat(String var1) {
      this.saleleContrat = var1;
   }

   public Date getSaleleDateEntree() {
      return this.saleleDateEntree;
   }

   public void setSaleleDateEntree(Date var1) {
      this.saleleDateEntree = var1;
   }

   public int getSaleleDureeJour() {
      return this.saleleDureeJour;
   }

   public void setSaleleDureeJour(int var1) {
      this.saleleDureeJour = var1;
   }

   public Date getSaleleJour() {
      return this.saleleJour;
   }

   public void setSaleleJour(Date var1) {
      this.saleleJour = var1;
   }

   public String getSaleleCompteMembre() {
      return this.saleleCompteMembre;
   }

   public void setSaleleCompteMembre(String var1) {
      this.saleleCompteMembre = var1;
   }

   public String getSaleleLibService() {
      return this.saleleLibService;
   }

   public void setSaleleLibService(String var1) {
      this.saleleLibService = var1;
   }

   public int getSaleleModeSolde() {
      return this.saleleModeSolde;
   }

   public void setSaleleModeSolde(int var1) {
      this.saleleModeSolde = var1;
   }

   public String getSaleleLocalisation() {
      return this.saleleLocalisation;
   }

   public void setSaleleLocalisation(String var1) {
      this.saleleLocalisation = var1;
   }

   public String getSaleleCentresSecurite() {
      return this.saleleCentresSecurite;
   }

   public void setSaleleCentresSecurite(String var1) {
      this.saleleCentresSecurite = var1;
   }

   public String getSaleleLibCentresSecurite() {
      return this.saleleLibCentresSecurite;
   }

   public void setSaleleLibCentresSecurite(String var1) {
      this.saleleLibCentresSecurite = var1;
   }

   public int getSaleleChefFamille() {
      return this.saleleChefFamille;
   }

   public void setSaleleChefFamille(int var1) {
      this.saleleChefFamille = var1;
   }

   public Date getSaleleDateCreat() {
      return this.saleleDateCreat;
   }

   public void setSaleleDateCreat(Date var1) {
      this.saleleDateCreat = var1;
   }

   public Date getSaleleDateModif() {
      return this.saleleDateModif;
   }

   public void setSaleleDateModif(Date var1) {
      this.saleleDateModif = var1;
   }

   public long getSaleleUserCreat() {
      return this.saleleUserCreat;
   }

   public void setSaleleUserCreat(long var1) {
      this.saleleUserCreat = var1;
   }

   public long getSaleleUserModif() {
      return this.saleleUserModif;
   }

   public void setSaleleUserModif(long var1) {
      this.saleleUserModif = var1;
   }
}
