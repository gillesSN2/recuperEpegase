package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PharmacieEntete implements Serializable {
   private long phaId;
   private Date phaDateCreat;
   private Date phaDateModif;
   private long phaIdCreateur;
   private String phaNomCreateur;
   private long phaIdModif;
   private String phaNomModif;
   private String phaNum;
   private String phaFeuille;
   private Date phaDate;
   private String phaSerie;
   private Date phaDateTransfert;
   private Date phaDateAnnule;
   private String phaMotifAnnule;
   private Date phaEcheanceReliquat;
   private String phaNumPieceTiers;
   private int phaEtatVal;
   private int phaCloture;
   private int phaEtat;
   private String phaNumHospit;
   private String phaNumRum;
   private String phaService;
   private String phaPharmacie;
   private String phaProtocole;
   private String phaPathologie;
   private String phaPrescripteur;
   private long phaIdMedecin;
   private String phaMedecin;
   private String phaNumBc;
   private String phaNumSecteur;
   private long phaIdPatient;
   private String phaCivilite;
   private String phaNomPatient;
   private long phaIdSociete;
   private String phaNomSociete;
   private String phaMatricule;
   private long phaIdAssurance;
   private String phaNomAssurance;
   private String phaContratAssurance;
   private long phaIdComplementaire;
   private String phaNomComplemtaire;
   private String phaContratComplementaire;
   private long phaIdEmployeur;
   private String phaNomEmployeur;
   private float phaPecCnamgs;
   private int phaFondCnamgs;
   private long phaFam;
   private long phaComplementaire;
   private double phaTotPatient;
   private double phaTotSociete;
   private double phaTotAssurance;
   private double phaTotComplmentaire;
   private double phaTotTaxePatient;
   private double phaTotTaxeSociete;
   private double phaTotTaxeAssurance;
   private double phaTotTaxeComplementaire;
   private double phaTotGeneral;
   private double phaTotRabais;
   private double phaTotTaxeGeneral;
   private double phaRegPatient;
   private int phaSoldePatient;
   private double phaRegTiers;
   private int phaSoldeTiers;
   private String phaBanque;
   private int phaTypeReg;
   private String phaModeReg;
   private int phaNbJourReg;
   private int phaArrondiReg;
   private Date phaDateEcheReg;
   private String phaActivite;
   private String phaInfo1;
   private String phaInfo2;
   private String phaInfo3;
   private String phaInfo4;
   private String phaInfo5;
   private String phaInfo6;
   private String phaInfo7;
   private String phaInfo8;
   private String phaInfo9;
   private String phaInfo10;
   private Date phaDateImp;
   private String phaModeleImp;
   private String phaNomAssurePrincipal;
   private boolean phaAyantDroit;
   private boolean phaBloqueRefacturation;
   private ExercicesVentes exerciceventes;
   private Patients patients;
   private String libelleEta;
   private String var_solde;
   private boolean var_select_ligne;
   private double var_reliquat;
   private double totalTiers;
   private double totalPatient;
   private String libelleFamille;

   public String getLibelleFamille() {
      if (this.phaFam == 0L) {
         this.libelleFamille = "Non Assuré";
      } else if (this.phaFam == -1L) {
         this.libelleFamille = "Cas Social";
      } else if (this.phaFam == -2L) {
         this.libelleFamille = "Etat";
      } else {
         this.libelleFamille = "Assuré";
      }

      return this.libelleFamille;
   }

   public void setLibelleFamille(String var1) {
      this.libelleFamille = var1;
   }

   public String getLibelleEta() {
      if (this.phaEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.phaEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.phaEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.phaEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.phaEtat == 4) {
         this.libelleEta = "Clot.";
      } else if (this.phaEtat == 5) {
         this.libelleEta = "Ctrl.";
      } else if (this.phaEtat == 6) {
         this.libelleEta = "Refact.Std";
      } else if (this.phaEtat == 7) {
         this.libelleEta = "Refact.Cpl";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public double getTotalPatient() {
      this.totalPatient = this.phaTotPatient + this.phaTotTaxePatient;
      return this.totalPatient;
   }

   public void setTotalPatient(double var1) {
      this.totalPatient = var1;
   }

   public double getTotalTiers() {
      this.totalTiers = this.phaTotAssurance + this.phaTotTaxeAssurance + this.phaTotComplmentaire + this.phaTotTaxeComplementaire + this.phaTotSociete + this.phaTotTaxeSociete;
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.phaTotPatient + this.phaTotTaxePatient - this.phaRegPatient;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public String getVar_solde() {
      if (this.phaSoldePatient == 1) {
         this.var_solde = "Soldé";
      } else {
         this.var_solde = "";
      }

      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public Patients getPatients() {
      return this.patients;
   }

   public void setPatients(Patients var1) {
      this.patients = var1;
   }

   public String getPhaActivite() {
      return this.phaActivite;
   }

   public void setPhaActivite(String var1) {
      this.phaActivite = var1;
   }

   public int getPhaArrondiReg() {
      return this.phaArrondiReg;
   }

   public void setPhaArrondiReg(int var1) {
      this.phaArrondiReg = var1;
   }

   public String getPhaBanque() {
      return this.phaBanque;
   }

   public void setPhaBanque(String var1) {
      this.phaBanque = var1;
   }

   public String getPhaCivilite() {
      return this.phaCivilite;
   }

   public void setPhaCivilite(String var1) {
      this.phaCivilite = var1;
   }

   public int getPhaCloture() {
      return this.phaCloture;
   }

   public void setPhaCloture(int var1) {
      this.phaCloture = var1;
   }

   public String getPhaContratAssurance() {
      return this.phaContratAssurance;
   }

   public void setPhaContratAssurance(String var1) {
      this.phaContratAssurance = var1;
   }

   public String getPhaContratComplementaire() {
      return this.phaContratComplementaire;
   }

   public void setPhaContratComplementaire(String var1) {
      this.phaContratComplementaire = var1;
   }

   public Date getPhaDate() {
      return this.phaDate;
   }

   public void setPhaDate(Date var1) {
      this.phaDate = var1;
   }

   public Date getPhaDateCreat() {
      return this.phaDateCreat;
   }

   public void setPhaDateCreat(Date var1) {
      this.phaDateCreat = var1;
   }

   public Date getPhaDateEcheReg() {
      return this.phaDateEcheReg;
   }

   public void setPhaDateEcheReg(Date var1) {
      this.phaDateEcheReg = var1;
   }

   public Date getPhaDateImp() {
      return this.phaDateImp;
   }

   public void setPhaDateImp(Date var1) {
      this.phaDateImp = var1;
   }

   public Date getPhaDateModif() {
      return this.phaDateModif;
   }

   public void setPhaDateModif(Date var1) {
      this.phaDateModif = var1;
   }

   public Date getPhaDateTransfert() {
      return this.phaDateTransfert;
   }

   public void setPhaDateTransfert(Date var1) {
      this.phaDateTransfert = var1;
   }

   public Date getPhaEcheanceReliquat() {
      return this.phaEcheanceReliquat;
   }

   public void setPhaEcheanceReliquat(Date var1) {
      this.phaEcheanceReliquat = var1;
   }

   public int getPhaEtat() {
      return this.phaEtat;
   }

   public void setPhaEtat(int var1) {
      this.phaEtat = var1;
   }

   public int getPhaEtatVal() {
      return this.phaEtatVal;
   }

   public void setPhaEtatVal(int var1) {
      this.phaEtatVal = var1;
   }

   public long getPhaComplementaire() {
      return this.phaComplementaire;
   }

   public void setPhaComplementaire(long var1) {
      this.phaComplementaire = var1;
   }

   public long getPhaFam() {
      return this.phaFam;
   }

   public void setPhaFam(long var1) {
      this.phaFam = var1;
   }

   public long getPhaId() {
      return this.phaId;
   }

   public void setPhaId(long var1) {
      this.phaId = var1;
   }

   public long getPhaIdAssurance() {
      return this.phaIdAssurance;
   }

   public void setPhaIdAssurance(long var1) {
      this.phaIdAssurance = var1;
   }

   public long getPhaIdComplementaire() {
      return this.phaIdComplementaire;
   }

   public void setPhaIdComplementaire(long var1) {
      this.phaIdComplementaire = var1;
   }

   public long getPhaIdCreateur() {
      return this.phaIdCreateur;
   }

   public void setPhaIdCreateur(long var1) {
      this.phaIdCreateur = var1;
   }

   public long getPhaIdMedecin() {
      return this.phaIdMedecin;
   }

   public void setPhaIdMedecin(long var1) {
      this.phaIdMedecin = var1;
   }

   public long getPhaIdModif() {
      return this.phaIdModif;
   }

   public void setPhaIdModif(long var1) {
      this.phaIdModif = var1;
   }

   public long getPhaIdPatient() {
      return this.phaIdPatient;
   }

   public void setPhaIdPatient(long var1) {
      this.phaIdPatient = var1;
   }

   public long getPhaIdSociete() {
      return this.phaIdSociete;
   }

   public void setPhaIdSociete(long var1) {
      this.phaIdSociete = var1;
   }

   public String getPhaInfo1() {
      return this.phaInfo1;
   }

   public void setPhaInfo1(String var1) {
      this.phaInfo1 = var1;
   }

   public String getPhaInfo10() {
      return this.phaInfo10;
   }

   public void setPhaInfo10(String var1) {
      this.phaInfo10 = var1;
   }

   public String getPhaInfo2() {
      return this.phaInfo2;
   }

   public void setPhaInfo2(String var1) {
      this.phaInfo2 = var1;
   }

   public String getPhaInfo3() {
      return this.phaInfo3;
   }

   public void setPhaInfo3(String var1) {
      this.phaInfo3 = var1;
   }

   public String getPhaInfo4() {
      return this.phaInfo4;
   }

   public void setPhaInfo4(String var1) {
      this.phaInfo4 = var1;
   }

   public String getPhaInfo5() {
      return this.phaInfo5;
   }

   public void setPhaInfo5(String var1) {
      this.phaInfo5 = var1;
   }

   public String getPhaInfo6() {
      return this.phaInfo6;
   }

   public void setPhaInfo6(String var1) {
      this.phaInfo6 = var1;
   }

   public String getPhaInfo7() {
      return this.phaInfo7;
   }

   public void setPhaInfo7(String var1) {
      this.phaInfo7 = var1;
   }

   public String getPhaInfo8() {
      return this.phaInfo8;
   }

   public void setPhaInfo8(String var1) {
      this.phaInfo8 = var1;
   }

   public String getPhaInfo9() {
      return this.phaInfo9;
   }

   public void setPhaInfo9(String var1) {
      this.phaInfo9 = var1;
   }

   public String getPhaMatricule() {
      return this.phaMatricule;
   }

   public void setPhaMatricule(String var1) {
      this.phaMatricule = var1;
   }

   public String getPhaMedecin() {
      return this.phaMedecin;
   }

   public void setPhaMedecin(String var1) {
      this.phaMedecin = var1;
   }

   public String getPhaModeReg() {
      return this.phaModeReg;
   }

   public void setPhaModeReg(String var1) {
      this.phaModeReg = var1;
   }

   public String getPhaModeleImp() {
      return this.phaModeleImp;
   }

   public void setPhaModeleImp(String var1) {
      this.phaModeleImp = var1;
   }

   public int getPhaNbJourReg() {
      return this.phaNbJourReg;
   }

   public void setPhaNbJourReg(int var1) {
      this.phaNbJourReg = var1;
   }

   public String getPhaNomAssurance() {
      return this.phaNomAssurance;
   }

   public void setPhaNomAssurance(String var1) {
      this.phaNomAssurance = var1;
   }

   public String getPhaNomComplemtaire() {
      return this.phaNomComplemtaire;
   }

   public void setPhaNomComplemtaire(String var1) {
      this.phaNomComplemtaire = var1;
   }

   public String getPhaNomCreateur() {
      return this.phaNomCreateur;
   }

   public void setPhaNomCreateur(String var1) {
      this.phaNomCreateur = var1;
   }

   public String getPhaNomModif() {
      return this.phaNomModif;
   }

   public void setPhaNomModif(String var1) {
      this.phaNomModif = var1;
   }

   public String getPhaNomPatient() {
      return this.phaNomPatient;
   }

   public void setPhaNomPatient(String var1) {
      this.phaNomPatient = var1;
   }

   public String getPhaNomSociete() {
      return this.phaNomSociete;
   }

   public void setPhaNomSociete(String var1) {
      this.phaNomSociete = var1;
   }

   public String getPhaNum() {
      return this.phaNum;
   }

   public void setPhaNum(String var1) {
      this.phaNum = var1;
   }

   public String getPhaNumBc() {
      return this.phaNumBc;
   }

   public void setPhaNumBc(String var1) {
      this.phaNumBc = var1;
   }

   public String getPhaNumHospit() {
      return this.phaNumHospit;
   }

   public void setPhaNumHospit(String var1) {
      this.phaNumHospit = var1;
   }

   public String getPhaNumRum() {
      return this.phaNumRum;
   }

   public void setPhaNumRum(String var1) {
      this.phaNumRum = var1;
   }

   public String getPhaPathologie() {
      return this.phaPathologie;
   }

   public void setPhaPathologie(String var1) {
      this.phaPathologie = var1;
   }

   public int getPhaFondCnamgs() {
      return this.phaFondCnamgs;
   }

   public void setPhaFondCnamgs(int var1) {
      this.phaFondCnamgs = var1;
   }

   public float getPhaPecCnamgs() {
      return this.phaPecCnamgs;
   }

   public void setPhaPecCnamgs(float var1) {
      this.phaPecCnamgs = var1;
   }

   public String getPhaPrescripteur() {
      return this.phaPrescripteur;
   }

   public void setPhaPrescripteur(String var1) {
      this.phaPrescripteur = var1;
   }

   public String getPhaProtocole() {
      return this.phaProtocole;
   }

   public void setPhaProtocole(String var1) {
      this.phaProtocole = var1;
   }

   public double getPhaRegPatient() {
      return this.phaRegPatient;
   }

   public void setPhaRegPatient(double var1) {
      this.phaRegPatient = var1;
   }

   public double getPhaRegTiers() {
      return this.phaRegTiers;
   }

   public void setPhaRegTiers(double var1) {
      this.phaRegTiers = var1;
   }

   public String getPhaSerie() {
      return this.phaSerie;
   }

   public void setPhaSerie(String var1) {
      this.phaSerie = var1;
   }

   public String getPhaService() {
      return this.phaService;
   }

   public void setPhaService(String var1) {
      this.phaService = var1;
   }

   public int getPhaSoldePatient() {
      return this.phaSoldePatient;
   }

   public void setPhaSoldePatient(int var1) {
      this.phaSoldePatient = var1;
   }

   public int getPhaSoldeTiers() {
      return this.phaSoldeTiers;
   }

   public void setPhaSoldeTiers(int var1) {
      this.phaSoldeTiers = var1;
   }

   public double getPhaTotAssurance() {
      return this.phaTotAssurance;
   }

   public void setPhaTotAssurance(double var1) {
      this.phaTotAssurance = var1;
   }

   public double getPhaTotComplmentaire() {
      return this.phaTotComplmentaire;
   }

   public void setPhaTotComplmentaire(double var1) {
      this.phaTotComplmentaire = var1;
   }

   public double getPhaTotGeneral() {
      return this.phaTotGeneral;
   }

   public void setPhaTotGeneral(double var1) {
      this.phaTotGeneral = var1;
   }

   public double getPhaTotPatient() {
      return this.phaTotPatient;
   }

   public void setPhaTotPatient(double var1) {
      this.phaTotPatient = var1;
   }

   public double getPhaTotSociete() {
      return this.phaTotSociete;
   }

   public void setPhaTotSociete(double var1) {
      this.phaTotSociete = var1;
   }

   public double getPhaTotTaxeAssurance() {
      return this.phaTotTaxeAssurance;
   }

   public void setPhaTotTaxeAssurance(double var1) {
      this.phaTotTaxeAssurance = var1;
   }

   public double getPhaTotTaxeComplementaire() {
      return this.phaTotTaxeComplementaire;
   }

   public void setPhaTotTaxeComplementaire(double var1) {
      this.phaTotTaxeComplementaire = var1;
   }

   public double getPhaTotTaxeGeneral() {
      return this.phaTotTaxeGeneral;
   }

   public void setPhaTotTaxeGeneral(double var1) {
      this.phaTotTaxeGeneral = var1;
   }

   public double getPhaTotTaxePatient() {
      return this.phaTotTaxePatient;
   }

   public void setPhaTotTaxePatient(double var1) {
      this.phaTotTaxePatient = var1;
   }

   public double getPhaTotTaxeSociete() {
      return this.phaTotTaxeSociete;
   }

   public void setPhaTotTaxeSociete(double var1) {
      this.phaTotTaxeSociete = var1;
   }

   public int getPhaTypeReg() {
      return this.phaTypeReg;
   }

   public void setPhaTypeReg(int var1) {
      this.phaTypeReg = var1;
   }

   public String getPhaPharmacie() {
      return this.phaPharmacie;
   }

   public void setPhaPharmacie(String var1) {
      this.phaPharmacie = var1;
   }

   public long getPhaIdEmployeur() {
      return this.phaIdEmployeur;
   }

   public void setPhaIdEmployeur(long var1) {
      this.phaIdEmployeur = var1;
   }

   public Date getPhaDateAnnule() {
      return this.phaDateAnnule;
   }

   public void setPhaDateAnnule(Date var1) {
      this.phaDateAnnule = var1;
   }

   public String getPhaMotifAnnule() {
      return this.phaMotifAnnule;
   }

   public void setPhaMotifAnnule(String var1) {
      this.phaMotifAnnule = var1;
   }

   public String getPhaNumSecteur() {
      return this.phaNumSecteur;
   }

   public void setPhaNumSecteur(String var1) {
      this.phaNumSecteur = var1;
   }

   public boolean isPhaAyantDroit() {
      return this.phaAyantDroit;
   }

   public void setPhaAyantDroit(boolean var1) {
      this.phaAyantDroit = var1;
   }

   public String getPhaNomAssurePrincipal() {
      return this.phaNomAssurePrincipal;
   }

   public void setPhaNomAssurePrincipal(String var1) {
      this.phaNomAssurePrincipal = var1;
   }

   public String getPhaNomEmployeur() {
      return this.phaNomEmployeur;
   }

   public void setPhaNomEmployeur(String var1) {
      this.phaNomEmployeur = var1;
   }

   public String getPhaNumPieceTiers() {
      return this.phaNumPieceTiers;
   }

   public void setPhaNumPieceTiers(String var1) {
      this.phaNumPieceTiers = var1;
   }

   public boolean isPhaBloqueRefacturation() {
      return this.phaBloqueRefacturation;
   }

   public void setPhaBloqueRefacturation(boolean var1) {
      this.phaBloqueRefacturation = var1;
   }

   public String getPhaFeuille() {
      return this.phaFeuille;
   }

   public void setPhaFeuille(String var1) {
      this.phaFeuille = var1;
   }

   public double getPhaTotRabais() {
      return this.phaTotRabais;
   }

   public void setPhaTotRabais(double var1) {
      this.phaTotRabais = var1;
   }
}
