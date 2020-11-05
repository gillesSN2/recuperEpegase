package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Eleves implements Serializable {
   private long eleId;
   private String eleDossier;
   private Date eleDateCreat;
   private Date eleDateModif;
   private long eleUserCreat;
   private long eleUserModif;
   private int eleEtat;
   private String eleNom;
   private String elePrenom;
   private String elePhoto;
   private String eleNomJf;
   private String eleCi;
   private String eleSecu;
   private String eleCouvert;
   private String eleCivilite;
   private String eleTelDom;
   private String eleCel1;
   private String eleCel2;
   private String eleCel3;
   private String eleTelVoiture;
   private int eleSexe;
   private Date eleDateNaissance;
   private String eleLieuNaissance;
   private String elePaysNaissance;
   private String eleObservations;
   private String eleAdresse;
   private String eleRue;
   private String eleLot;
   private String eleIlot;
   private String eleBatiment;
   private String elePorte;
   private String eleEtage;
   private String eleAscensseur;
   private String eleQuartier;
   private String eleCommune;
   private String eleDepart;
   private String eleZone;
   private String eleBp;
   private String eleCedex;
   private String eleVille;
   private String elePays;
   private String eleYahoo;
   private String eleMsn;
   private String eleSkype;
   private String eleMail1;
   private String eleNomFamille;
   private String eleSerie;
   private String eleNomBanque;
   private String eleAdresseBanque;
   private String eleNumBanque;
   private String eleGuichetBanque;
   private String eleCompteBanque;
   private String eleCleBanque;
   private String eleIban;
   private String eleSwift;
   private String eleCompte0;
   private String eleCompte1;
   private String eleCompte2;
   private String eleCompte3;
   private String eleCompte4;
   private String eleCompteSage;
   private int eleTransfertCpte;
   private int eleSitFam;
   private String eleNomPere;
   private String eleNomMere;
   private String eleModereg;
   private int eleTypereg;
   private int eleNbecheance;
   private int eleNbarrondi;
   private String eleConditionreg;
   private String eleAnneeBac;
   private String eleCentreBac;
   private String eleDernierDiplome;
   private String eleEtablAnterieur;
   private String eleStatutBourse;
   private double eleDepotAvance;
   private String etat;
   private boolean inactif;
   private String patronyme;

   public String getPatronyme() {
      if (this.elePrenom != null && !this.elePrenom.isEmpty()) {
         this.patronyme = this.eleNom + " " + this.elePrenom;
      } else {
         this.patronyme = this.eleNom;
      }

      return this.patronyme;
   }

   public void setPatronyme(String var1) {
      this.patronyme = var1;
   }

   public String getEleAdresse() {
      return this.eleAdresse;
   }

   public void setEleAdresse(String var1) {
      this.eleAdresse = var1;
   }

   public String getEleAdresseBanque() {
      return this.eleAdresseBanque;
   }

   public void setEleAdresseBanque(String var1) {
      this.eleAdresseBanque = var1;
   }

   public String getEleAscensseur() {
      return this.eleAscensseur;
   }

   public void setEleAscensseur(String var1) {
      this.eleAscensseur = var1;
   }

   public String getEleBatiment() {
      return this.eleBatiment;
   }

   public void setEleBatiment(String var1) {
      this.eleBatiment = var1;
   }

   public String getEleBp() {
      return this.eleBp;
   }

   public void setEleBp(String var1) {
      this.eleBp = var1;
   }

   public String getEleCedex() {
      return this.eleCedex;
   }

   public void setEleCedex(String var1) {
      this.eleCedex = var1;
   }

   public String getEleCel1() {
      return this.eleCel1;
   }

   public void setEleCel1(String var1) {
      this.eleCel1 = var1;
   }

   public String getEleCel2() {
      return this.eleCel2;
   }

   public void setEleCel2(String var1) {
      this.eleCel2 = var1;
   }

   public String getEleCel3() {
      return this.eleCel3;
   }

   public void setEleCel3(String var1) {
      this.eleCel3 = var1;
   }

   public String getEleCi() {
      return this.eleCi;
   }

   public void setEleCi(String var1) {
      this.eleCi = var1;
   }

   public String getEleCivilite() {
      return this.eleCivilite;
   }

   public void setEleCivilite(String var1) {
      this.eleCivilite = var1;
   }

   public String getEleCleBanque() {
      return this.eleCleBanque;
   }

   public void setEleCleBanque(String var1) {
      this.eleCleBanque = var1;
   }

   public String getEleCommune() {
      return this.eleCommune;
   }

   public void setEleCommune(String var1) {
      this.eleCommune = var1;
   }

   public String getEleCompte0() {
      return this.eleCompte0;
   }

   public void setEleCompte0(String var1) {
      this.eleCompte0 = var1;
   }

   public String getEleCompte1() {
      return this.eleCompte1;
   }

   public void setEleCompte1(String var1) {
      this.eleCompte1 = var1;
   }

   public String getEleCompte2() {
      return this.eleCompte2;
   }

   public void setEleCompte2(String var1) {
      this.eleCompte2 = var1;
   }

   public String getEleCompte3() {
      return this.eleCompte3;
   }

   public void setEleCompte3(String var1) {
      this.eleCompte3 = var1;
   }

   public String getEleCompte4() {
      return this.eleCompte4;
   }

   public void setEleCompte4(String var1) {
      this.eleCompte4 = var1;
   }

   public String getEleCompteBanque() {
      return this.eleCompteBanque;
   }

   public void setEleCompteBanque(String var1) {
      this.eleCompteBanque = var1;
   }

   public String getEleConditionreg() {
      return this.eleConditionreg;
   }

   public void setEleConditionreg(String var1) {
      this.eleConditionreg = var1;
   }

   public String getEleCouvert() {
      return this.eleCouvert;
   }

   public void setEleCouvert(String var1) {
      this.eleCouvert = var1;
   }

   public Date getEleDateCreat() {
      return this.eleDateCreat;
   }

   public void setEleDateCreat(Date var1) {
      this.eleDateCreat = var1;
   }

   public Date getEleDateModif() {
      return this.eleDateModif;
   }

   public void setEleDateModif(Date var1) {
      this.eleDateModif = var1;
   }

   public Date getEleDateNaissance() {
      return this.eleDateNaissance;
   }

   public void setEleDateNaissance(Date var1) {
      this.eleDateNaissance = var1;
   }

   public String getEleDepart() {
      return this.eleDepart;
   }

   public void setEleDepart(String var1) {
      this.eleDepart = var1;
   }

   public String getEleDossier() {
      return this.eleDossier;
   }

   public void setEleDossier(String var1) {
      this.eleDossier = var1;
   }

   public String getEleEtage() {
      return this.eleEtage;
   }

   public void setEleEtage(String var1) {
      this.eleEtage = var1;
   }

   public int getEleEtat() {
      return this.eleEtat;
   }

   public void setEleEtat(int var1) {
      this.eleEtat = var1;
   }

   public String getEleGuichetBanque() {
      return this.eleGuichetBanque;
   }

   public void setEleGuichetBanque(String var1) {
      this.eleGuichetBanque = var1;
   }

   public String getEleIban() {
      return this.eleIban;
   }

   public void setEleIban(String var1) {
      this.eleIban = var1;
   }

   public long getEleId() {
      return this.eleId;
   }

   public void setEleId(long var1) {
      this.eleId = var1;
   }

   public String getEleIlot() {
      return this.eleIlot;
   }

   public void setEleIlot(String var1) {
      this.eleIlot = var1;
   }

   public String getEleLieuNaissance() {
      return this.eleLieuNaissance;
   }

   public void setEleLieuNaissance(String var1) {
      this.eleLieuNaissance = var1;
   }

   public String getEleLot() {
      return this.eleLot;
   }

   public void setEleLot(String var1) {
      this.eleLot = var1;
   }

   public String getEleMail1() {
      return this.eleMail1;
   }

   public void setEleMail1(String var1) {
      this.eleMail1 = var1;
   }

   public String getEleModereg() {
      return this.eleModereg;
   }

   public void setEleModereg(String var1) {
      this.eleModereg = var1;
   }

   public String getEleMsn() {
      return this.eleMsn;
   }

   public void setEleMsn(String var1) {
      this.eleMsn = var1;
   }

   public int getEleNbarrondi() {
      return this.eleNbarrondi;
   }

   public void setEleNbarrondi(int var1) {
      this.eleNbarrondi = var1;
   }

   public int getEleNbecheance() {
      return this.eleNbecheance;
   }

   public void setEleNbecheance(int var1) {
      this.eleNbecheance = var1;
   }

   public String getEleNom() {
      if (this.eleNom != null && !this.eleNom.isEmpty()) {
         this.eleNom = this.eleNom.toUpperCase();
      }

      return this.eleNom;
   }

   public void setEleNom(String var1) {
      this.eleNom = var1;
   }

   public String getEleNomBanque() {
      return this.eleNomBanque;
   }

   public void setEleNomBanque(String var1) {
      this.eleNomBanque = var1;
   }

   public String getEleNomFamille() {
      return this.eleNomFamille;
   }

   public void setEleNomFamille(String var1) {
      this.eleNomFamille = var1;
   }

   public String getEleNomJf() {
      if (this.eleNomJf != null && !this.eleNomJf.isEmpty()) {
         this.eleNomJf = this.eleNomJf.toUpperCase();
      }

      return this.eleNomJf;
   }

   public void setEleNomJf(String var1) {
      this.eleNomJf = var1;
   }

   public String getEleNomMere() {
      return this.eleNomMere;
   }

   public void setEleNomMere(String var1) {
      this.eleNomMere = var1;
   }

   public String getEleNomPere() {
      return this.eleNomPere;
   }

   public void setEleNomPere(String var1) {
      this.eleNomPere = var1;
   }

   public String getEleNumBanque() {
      return this.eleNumBanque;
   }

   public void setEleNumBanque(String var1) {
      this.eleNumBanque = var1;
   }

   public String getEleObservations() {
      return this.eleObservations;
   }

   public void setEleObservations(String var1) {
      this.eleObservations = var1;
   }

   public String getElePays() {
      return this.elePays;
   }

   public void setElePays(String var1) {
      this.elePays = var1;
   }

   public String getElePaysNaissance() {
      return this.elePaysNaissance;
   }

   public void setElePaysNaissance(String var1) {
      this.elePaysNaissance = var1;
   }

   public String getElePorte() {
      return this.elePorte;
   }

   public void setElePorte(String var1) {
      this.elePorte = var1;
   }

   public String getElePrenom() {
      return this.elePrenom;
   }

   public void setElePrenom(String var1) {
      this.elePrenom = var1;
   }

   public String getEleQuartier() {
      return this.eleQuartier;
   }

   public void setEleQuartier(String var1) {
      this.eleQuartier = var1;
   }

   public String getEleRue() {
      return this.eleRue;
   }

   public void setEleRue(String var1) {
      this.eleRue = var1;
   }

   public String getEleSecu() {
      return this.eleSecu;
   }

   public void setEleSecu(String var1) {
      this.eleSecu = var1;
   }

   public String getEleSerie() {
      return this.eleSerie;
   }

   public void setEleSerie(String var1) {
      this.eleSerie = var1;
   }

   public int getEleSexe() {
      return this.eleSexe;
   }

   public void setEleSexe(int var1) {
      this.eleSexe = var1;
   }

   public int getEleSitFam() {
      return this.eleSitFam;
   }

   public void setEleSitFam(int var1) {
      this.eleSitFam = var1;
   }

   public String getEleSkype() {
      return this.eleSkype;
   }

   public void setEleSkype(String var1) {
      this.eleSkype = var1;
   }

   public String getEleSwift() {
      return this.eleSwift;
   }

   public void setEleSwift(String var1) {
      this.eleSwift = var1;
   }

   public String getEleTelDom() {
      return this.eleTelDom;
   }

   public void setEleTelDom(String var1) {
      this.eleTelDom = var1;
   }

   public String getEleTelVoiture() {
      return this.eleTelVoiture;
   }

   public void setEleTelVoiture(String var1) {
      this.eleTelVoiture = var1;
   }

   public int getEleTypereg() {
      return this.eleTypereg;
   }

   public void setEleTypereg(int var1) {
      this.eleTypereg = var1;
   }

   public long getEleUserCreat() {
      return this.eleUserCreat;
   }

   public void setEleUserCreat(long var1) {
      this.eleUserCreat = var1;
   }

   public long getEleUserModif() {
      return this.eleUserModif;
   }

   public void setEleUserModif(long var1) {
      this.eleUserModif = var1;
   }

   public String getEleVille() {
      return this.eleVille;
   }

   public void setEleVille(String var1) {
      this.eleVille = var1;
   }

   public String getEleYahoo() {
      return this.eleYahoo;
   }

   public void setEleYahoo(String var1) {
      this.eleYahoo = var1;
   }

   public String getEleZone() {
      return this.eleZone;
   }

   public void setEleZone(String var1) {
      this.eleZone = var1;
   }

   public String getEtat() {
      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public String getElePhoto() {
      return this.elePhoto;
   }

   public void setElePhoto(String var1) {
      this.elePhoto = var1;
   }

   public String getEleAnneeBac() {
      return this.eleAnneeBac;
   }

   public void setEleAnneeBac(String var1) {
      this.eleAnneeBac = var1;
   }

   public String getEleCentreBac() {
      return this.eleCentreBac;
   }

   public void setEleCentreBac(String var1) {
      this.eleCentreBac = var1;
   }

   public String getEleDernierDiplome() {
      return this.eleDernierDiplome;
   }

   public void setEleDernierDiplome(String var1) {
      this.eleDernierDiplome = var1;
   }

   public String getEleEtablAnterieur() {
      return this.eleEtablAnterieur;
   }

   public void setEleEtablAnterieur(String var1) {
      this.eleEtablAnterieur = var1;
   }

   public String getEleStatutBourse() {
      return this.eleStatutBourse;
   }

   public void setEleStatutBourse(String var1) {
      this.eleStatutBourse = var1;
   }

   public String getEleCompteSage() {
      return this.eleCompteSage;
   }

   public void setEleCompteSage(String var1) {
      this.eleCompteSage = var1;
   }

   public int getEleTransfertCpte() {
      return this.eleTransfertCpte;
   }

   public void setEleTransfertCpte(int var1) {
      this.eleTransfertCpte = var1;
   }

   public double getEleDepotAvance() {
      return this.eleDepotAvance;
   }

   public void setEleDepotAvance(double var1) {
      this.eleDepotAvance = var1;
   }
}
