package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class RecapitulatifMedical implements Serializable {
   private long facrecId;
   private Date facrecDateCreat;
   private String facrecNum;
   private long facrecIdCreateur;
   private String facrecNomCreateur;
   private Date facrecDateModif;
   private long facrecIdModif;
   private String facrecNomModif;
   private Date facrecDate;
   private Date facrecDateDebut;
   private Date facrecDateFin;
   private String facrecPeriode;
   private String facrecNomCommercial;
   private long facrecIdCommercial;
   private String facrecNomTiers;
   private String facrecCivilTiers;
   private String facrecTiersRegroupe;
   private long facrecIdContact;
   private String facrecNomContact;
   private String facrecCivilContact;
   private String facrecSerie;
   private int facrecExoTva;
   private String facrecJournalReg;
   private String facrecCat;
   private String facrecDevise;
   private String facrecObject;
   private float facrecTauxRemise;
   private double facrecTotHt;
   private double facrecTotRemise;
   private double facrecTotRabais;
   private double facrecTotTva;
   private float facrecTauxTc;
   private double facrecTotTc;
   private double facrecTotTtc;
   private double facrecTotReglement;
   private double facrecTotTimbre;
   private int facrecSolde;
   private String facrecBanque;
   private int facrecTypeReg;
   private String facrecModeReg;
   private Date facrecEcheanceReliquat;
   private int facrecNbJourReg;
   private int facrecArrondiReg;
   private String facrecConditionReg;
   private Date facrecDateEcheReg;
   private Date facrecDateLastReg;
   private Date facrecDateImp;
   private String facrecModeleImp;
   private int facrecEtatVal;
   private int facrecGele;
   private int facrecEtat;
   private String facrecNumTrf;
   private Date facrecDateValidite;
   private Date facrecDateRelance;
   private Date facrecDateValide;
   private Date facrecDateTransforme;
   private int facrecTypeTransforme;
   private Date facrecDateAnnule;
   private String facrecMotifAnnule;
   private String facrecMotifExo;
   private String facrecNumVisa;
   private Date facrecDateVisa;
   private String facrecRangeVisa;
   private Date facrecDateTransfert;
   private String facrecNumAvoir;
   private String facrecSecteurAgent;
   private long facrecIdAdherent;
   private String facrecNomAdherent;
   private float facrecPecCnamgs;
   private int facrecFondCnamgs;
   private String facrecOrigine;
   private ExercicesVentes exerciceventes;
   private Tiers tiers;
   private Users users;
   private String libelleEta;
   private String libelleFonds;
   private String var_solde;
   private double var_reliquat;
   private boolean var_select_ligne;
   private int var_format_devise;
   private double varTotTtcGlob;
   private String var_nomContact;
   private String var_nom_tiers;
   private double var_facrec_timbre;
   private String entite;
   private String montantLettre;
   private String dupplicata;
   private String infoOrigineDoc;
   private double montantReglementManuel;

   public String getLibelleFonds() {
      if (this.facrecFondCnamgs == 1) {
         this.libelleFonds = "F1 + Consultations (SP)";
      } else if (this.facrecFondCnamgs == 2) {
         this.libelleFonds = "F2 + Consultations (AP)";
      } else if (this.facrecFondCnamgs == 3) {
         this.libelleFonds = "F3 + Consultations (GEF)";
      } else if (this.facrecFondCnamgs == 11) {
         this.libelleFonds = "F1 + Examens (SP)";
      } else if (this.facrecFondCnamgs == 12) {
         this.libelleFonds = "F2 + Examens (AP)";
      } else if (this.facrecFondCnamgs == 13) {
         this.libelleFonds = "F3 + Examens (GEF)";
      } else if (this.facrecFondCnamgs == 21) {
         this.libelleFonds = "F1 + Pharmacie (SP)";
      } else if (this.facrecFondCnamgs == 22) {
         this.libelleFonds = "F2 + Pharmacie (AP)";
      } else if (this.facrecFondCnamgs == 23) {
         this.libelleFonds = "F3 + Pharmacie (GEF)";
      } else if (this.facrecFondCnamgs == 31) {
         this.libelleFonds = "F1 + Hospitalisation (SP)";
      } else if (this.facrecFondCnamgs == 32) {
         this.libelleFonds = "F2 + Hospitalisation (AP)";
      } else if (this.facrecFondCnamgs == 33) {
         this.libelleFonds = "F3 + Hospitalisation (GEF)";
      } else {
         this.libelleFonds = "";
      }

      return this.libelleFonds;
   }

   public void setLibelleFonds(String var1) {
      this.libelleFonds = var1;
   }

   public String getEntite() {
      this.entite = "";
      if (this.facrecSecteurAgent != null && !this.facrecSecteurAgent.isEmpty()) {
         this.entite = this.facrecSecteurAgent;
      } else if (this.facrecNomAdherent != null && !this.facrecNomAdherent.isEmpty()) {
         this.entite = this.facrecNomAdherent;
      }

      return this.entite;
   }

   public void setEntite(String var1) {
      this.entite = var1;
   }

   public double getMontantReglementManuel() {
      return this.montantReglementManuel;
   }

   public void setMontantReglementManuel(double var1) {
      this.montantReglementManuel = var1;
   }

   public double getVar_facrec_timbre() {
      return this.var_facrec_timbre;
   }

   public void setVar_facrec_timbre(double var1) {
      this.var_facrec_timbre = var1;
   }

   public String getVar_nom_tiers() {
      if (this.facrecCivilTiers != null && !this.facrecCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.facrecCivilTiers + " " + this.facrecNomTiers;
      } else {
         this.var_nom_tiers = this.facrecNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.facrecCivilContact != null && !this.facrecCivilContact.isEmpty()) {
         this.var_nomContact = this.facrecCivilContact + " " + this.facrecNomContact;
      } else {
         this.var_nomContact = this.facrecNomContact;
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.facrecTotTtc + this.facrecTotTc;
      return this.varTotTtcGlob;
   }

   public void setVarTotTtcGlob(double var1) {
      this.varTotTtcGlob = var1;
   }

   public String getLibelleEta() {
      if (this.facrecEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.facrecEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.facrecEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.facrecEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.facrecEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.facrecEtat == 5) {
         this.libelleEta = "Trf.T.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getVar_solde() {
      if (this.facrecSolde == 1) {
         this.var_solde = "Soldé";
      } else {
         this.var_solde = "";
      }

      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.facrecTotTtc + this.facrecTotTc + this.facrecTotTimbre + this.var_facrec_timbre - this.facrecTotReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public int getVar_format_devise() {
      if (!this.facrecDevise.equals("XOF") && !this.facrecDevise.equals("XAF")) {
         if (!this.facrecDevise.equals("EUR") && !this.facrecDevise.equals("XEU") && !this.facrecDevise.equals("CHF")) {
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

   public String getMontantLettre() {
      return this.montantLettre;
   }

   public void setMontantLettre(String var1) {
      this.montantLettre = var1;
   }

   public String getDupplicata() {
      return this.dupplicata;
   }

   public void setDupplicata(String var1) {
      this.dupplicata = var1;
   }

   public String getInfoOrigineDoc() {
      return this.infoOrigineDoc;
   }

   public void setInfoOrigineDoc(String var1) {
      this.infoOrigineDoc = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public int getFacrecArrondiReg() {
      return this.facrecArrondiReg;
   }

   public void setFacrecArrondiReg(int var1) {
      this.facrecArrondiReg = var1;
   }

   public String getFacrecBanque() {
      return this.facrecBanque;
   }

   public void setFacrecBanque(String var1) {
      this.facrecBanque = var1;
   }

   public String getFacrecCat() {
      return this.facrecCat;
   }

   public void setFacrecCat(String var1) {
      this.facrecCat = var1;
   }

   public String getFacrecCivilContact() {
      return this.facrecCivilContact;
   }

   public void setFacrecCivilContact(String var1) {
      this.facrecCivilContact = var1;
   }

   public String getFacrecCivilTiers() {
      return this.facrecCivilTiers;
   }

   public void setFacrecCivilTiers(String var1) {
      this.facrecCivilTiers = var1;
   }

   public String getFacrecConditionReg() {
      return this.facrecConditionReg;
   }

   public void setFacrecConditionReg(String var1) {
      this.facrecConditionReg = var1;
   }

   public Date getFacrecDate() {
      return this.facrecDate;
   }

   public void setFacrecDate(Date var1) {
      this.facrecDate = var1;
   }

   public Date getFacrecDateAnnule() {
      return this.facrecDateAnnule;
   }

   public void setFacrecDateAnnule(Date var1) {
      this.facrecDateAnnule = var1;
   }

   public Date getFacrecDateCreat() {
      return this.facrecDateCreat;
   }

   public void setFacrecDateCreat(Date var1) {
      this.facrecDateCreat = var1;
   }

   public Date getFacrecDateDebut() {
      return this.facrecDateDebut;
   }

   public void setFacrecDateDebut(Date var1) {
      this.facrecDateDebut = var1;
   }

   public Date getFacrecDateEcheReg() {
      return this.facrecDateEcheReg;
   }

   public void setFacrecDateEcheReg(Date var1) {
      this.facrecDateEcheReg = var1;
   }

   public Date getFacrecDateFin() {
      return this.facrecDateFin;
   }

   public void setFacrecDateFin(Date var1) {
      this.facrecDateFin = var1;
   }

   public Date getFacrecDateImp() {
      return this.facrecDateImp;
   }

   public void setFacrecDateImp(Date var1) {
      this.facrecDateImp = var1;
   }

   public Date getFacrecDateLastReg() {
      return this.facrecDateLastReg;
   }

   public void setFacrecDateLastReg(Date var1) {
      this.facrecDateLastReg = var1;
   }

   public Date getFacrecDateModif() {
      return this.facrecDateModif;
   }

   public void setFacrecDateModif(Date var1) {
      this.facrecDateModif = var1;
   }

   public Date getFacrecDateRelance() {
      return this.facrecDateRelance;
   }

   public void setFacrecDateRelance(Date var1) {
      this.facrecDateRelance = var1;
   }

   public Date getFacrecDateTransfert() {
      return this.facrecDateTransfert;
   }

   public void setFacrecDateTransfert(Date var1) {
      this.facrecDateTransfert = var1;
   }

   public Date getFacrecDateTransforme() {
      return this.facrecDateTransforme;
   }

   public void setFacrecDateTransforme(Date var1) {
      this.facrecDateTransforme = var1;
   }

   public Date getFacrecDateValide() {
      return this.facrecDateValide;
   }

   public void setFacrecDateValide(Date var1) {
      this.facrecDateValide = var1;
   }

   public Date getFacrecDateValidite() {
      return this.facrecDateValidite;
   }

   public void setFacrecDateValidite(Date var1) {
      this.facrecDateValidite = var1;
   }

   public Date getFacrecDateVisa() {
      return this.facrecDateVisa;
   }

   public void setFacrecDateVisa(Date var1) {
      this.facrecDateVisa = var1;
   }

   public String getFacrecDevise() {
      return this.facrecDevise;
   }

   public void setFacrecDevise(String var1) {
      this.facrecDevise = var1;
   }

   public Date getFacrecEcheanceReliquat() {
      return this.facrecEcheanceReliquat;
   }

   public void setFacrecEcheanceReliquat(Date var1) {
      this.facrecEcheanceReliquat = var1;
   }

   public int getFacrecEtat() {
      return this.facrecEtat;
   }

   public void setFacrecEtat(int var1) {
      this.facrecEtat = var1;
   }

   public int getFacrecEtatVal() {
      return this.facrecEtatVal;
   }

   public void setFacrecEtatVal(int var1) {
      this.facrecEtatVal = var1;
   }

   public int getFacrecExoTva() {
      return this.facrecExoTva;
   }

   public void setFacrecExoTva(int var1) {
      this.facrecExoTva = var1;
   }

   public int getFacrecFondCnamgs() {
      return this.facrecFondCnamgs;
   }

   public void setFacrecFondCnamgs(int var1) {
      this.facrecFondCnamgs = var1;
   }

   public int getFacrecGele() {
      return this.facrecGele;
   }

   public void setFacrecGele(int var1) {
      this.facrecGele = var1;
   }

   public long getFacrecId() {
      return this.facrecId;
   }

   public void setFacrecId(long var1) {
      this.facrecId = var1;
   }

   public long getFacrecIdAdherent() {
      return this.facrecIdAdherent;
   }

   public void setFacrecIdAdherent(long var1) {
      this.facrecIdAdherent = var1;
   }

   public long getFacrecIdCommercial() {
      return this.facrecIdCommercial;
   }

   public void setFacrecIdCommercial(long var1) {
      this.facrecIdCommercial = var1;
   }

   public long getFacrecIdContact() {
      return this.facrecIdContact;
   }

   public void setFacrecIdContact(long var1) {
      this.facrecIdContact = var1;
   }

   public long getFacrecIdCreateur() {
      return this.facrecIdCreateur;
   }

   public void setFacrecIdCreateur(long var1) {
      this.facrecIdCreateur = var1;
   }

   public long getFacrecIdModif() {
      return this.facrecIdModif;
   }

   public void setFacrecIdModif(long var1) {
      this.facrecIdModif = var1;
   }

   public String getFacrecJournalReg() {
      return this.facrecJournalReg;
   }

   public void setFacrecJournalReg(String var1) {
      this.facrecJournalReg = var1;
   }

   public String getFacrecModeReg() {
      return this.facrecModeReg;
   }

   public void setFacrecModeReg(String var1) {
      this.facrecModeReg = var1;
   }

   public String getFacrecModeleImp() {
      return this.facrecModeleImp;
   }

   public void setFacrecModeleImp(String var1) {
      this.facrecModeleImp = var1;
   }

   public String getFacrecMotifAnnule() {
      return this.facrecMotifAnnule;
   }

   public void setFacrecMotifAnnule(String var1) {
      this.facrecMotifAnnule = var1;
   }

   public String getFacrecMotifExo() {
      return this.facrecMotifExo;
   }

   public void setFacrecMotifExo(String var1) {
      this.facrecMotifExo = var1;
   }

   public int getFacrecNbJourReg() {
      return this.facrecNbJourReg;
   }

   public void setFacrecNbJourReg(int var1) {
      this.facrecNbJourReg = var1;
   }

   public String getFacrecNomAdherent() {
      return this.facrecNomAdherent;
   }

   public void setFacrecNomAdherent(String var1) {
      this.facrecNomAdherent = var1;
   }

   public String getFacrecNomCommercial() {
      return this.facrecNomCommercial;
   }

   public void setFacrecNomCommercial(String var1) {
      this.facrecNomCommercial = var1;
   }

   public String getFacrecNomContact() {
      return this.facrecNomContact;
   }

   public void setFacrecNomContact(String var1) {
      this.facrecNomContact = var1;
   }

   public String getFacrecNomCreateur() {
      return this.facrecNomCreateur;
   }

   public void setFacrecNomCreateur(String var1) {
      this.facrecNomCreateur = var1;
   }

   public String getFacrecNomModif() {
      return this.facrecNomModif;
   }

   public void setFacrecNomModif(String var1) {
      this.facrecNomModif = var1;
   }

   public String getFacrecNomTiers() {
      return this.facrecNomTiers;
   }

   public void setFacrecNomTiers(String var1) {
      this.facrecNomTiers = var1;
   }

   public String getFacrecNum() {
      return this.facrecNum;
   }

   public void setFacrecNum(String var1) {
      this.facrecNum = var1;
   }

   public String getFacrecNumAvoir() {
      return this.facrecNumAvoir;
   }

   public void setFacrecNumAvoir(String var1) {
      this.facrecNumAvoir = var1;
   }

   public String getFacrecNumTrf() {
      return this.facrecNumTrf;
   }

   public void setFacrecNumTrf(String var1) {
      this.facrecNumTrf = var1;
   }

   public String getFacrecNumVisa() {
      return this.facrecNumVisa;
   }

   public void setFacrecNumVisa(String var1) {
      this.facrecNumVisa = var1;
   }

   public String getFacrecObject() {
      return this.facrecObject;
   }

   public void setFacrecObject(String var1) {
      this.facrecObject = var1;
   }

   public String getFacrecOrigine() {
      return this.facrecOrigine;
   }

   public void setFacrecOrigine(String var1) {
      this.facrecOrigine = var1;
   }

   public float getFacrecPecCnamgs() {
      return this.facrecPecCnamgs;
   }

   public void setFacrecPecCnamgs(float var1) {
      this.facrecPecCnamgs = var1;
   }

   public String getFacrecPeriode() {
      return this.facrecPeriode;
   }

   public void setFacrecPeriode(String var1) {
      this.facrecPeriode = var1;
   }

   public String getFacrecRangeVisa() {
      return this.facrecRangeVisa;
   }

   public void setFacrecRangeVisa(String var1) {
      this.facrecRangeVisa = var1;
   }

   public String getFacrecSecteurAgent() {
      return this.facrecSecteurAgent;
   }

   public void setFacrecSecteurAgent(String var1) {
      this.facrecSecteurAgent = var1;
   }

   public String getFacrecSerie() {
      return this.facrecSerie;
   }

   public void setFacrecSerie(String var1) {
      this.facrecSerie = var1;
   }

   public int getFacrecSolde() {
      return this.facrecSolde;
   }

   public void setFacrecSolde(int var1) {
      this.facrecSolde = var1;
   }

   public float getFacrecTauxRemise() {
      return this.facrecTauxRemise;
   }

   public void setFacrecTauxRemise(float var1) {
      this.facrecTauxRemise = var1;
   }

   public float getFacrecTauxTc() {
      return this.facrecTauxTc;
   }

   public void setFacrecTauxTc(float var1) {
      this.facrecTauxTc = var1;
   }

   public String getFacrecTiersRegroupe() {
      return this.facrecTiersRegroupe;
   }

   public void setFacrecTiersRegroupe(String var1) {
      this.facrecTiersRegroupe = var1;
   }

   public double getFacrecTotHt() {
      return this.facrecTotHt;
   }

   public void setFacrecTotHt(double var1) {
      this.facrecTotHt = var1;
   }

   public double getFacrecTotRabais() {
      return this.facrecTotRabais;
   }

   public void setFacrecTotRabais(double var1) {
      this.facrecTotRabais = var1;
   }

   public double getFacrecTotReglement() {
      return this.facrecTotReglement;
   }

   public void setFacrecTotReglement(double var1) {
      this.facrecTotReglement = var1;
   }

   public double getFacrecTotRemise() {
      return this.facrecTotRemise;
   }

   public void setFacrecTotRemise(double var1) {
      this.facrecTotRemise = var1;
   }

   public double getFacrecTotTc() {
      return this.facrecTotTc;
   }

   public void setFacrecTotTc(double var1) {
      this.facrecTotTc = var1;
   }

   public double getFacrecTotTimbre() {
      return this.facrecTotTimbre;
   }

   public void setFacrecTotTimbre(double var1) {
      this.facrecTotTimbre = var1;
   }

   public double getFacrecTotTtc() {
      return this.facrecTotTtc;
   }

   public void setFacrecTotTtc(double var1) {
      this.facrecTotTtc = var1;
   }

   public double getFacrecTotTva() {
      return this.facrecTotTva;
   }

   public void setFacrecTotTva(double var1) {
      this.facrecTotTva = var1;
   }

   public int getFacrecTypeReg() {
      return this.facrecTypeReg;
   }

   public void setFacrecTypeReg(int var1) {
      this.facrecTypeReg = var1;
   }

   public int getFacrecTypeTransforme() {
      return this.facrecTypeTransforme;
   }

   public void setFacrecTypeTransforme(int var1) {
      this.facrecTypeTransforme = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }
}
