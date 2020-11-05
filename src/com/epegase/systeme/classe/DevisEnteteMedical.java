package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class DevisEnteteMedical implements Serializable {
   private long dvsId;
   private Date dvsDateCreat;
   private Date dvsDateModif;
   private long dvsIdCreateur;
   private String dvsNomCreateur;
   private long dvsIdModif;
   private String dvsNomModif;
   private String dvsNum;
   private String dvsFeuille;
   private Date dvsDate;
   private String dvsSerie;
   private Date dvsDateTransfert;
   private Date dvsDateAnnule;
   private String dvsMotifAnnule;
   private Date dvsEcheanceReliquat;
   private String dvsNumPieceTiers;
   private int dvsEtatVal;
   private int dvsCloture;
   private int dvsEtat;
   private int dvsEtatPaillasse;
   private String dvsNumHospit;
   private String dvsNumRum;
   private String dvsService;
   private String dvsProtocole;
   private String dvsPathologie;
   private String dvsEntree;
   private String dvsPrescripteur;
   private long dvsIdMedecin;
   private String dvsMedecin;
   private String dvsNumBc;
   private String dvsNumSecteur;
   private long dvsIdPatient;
   private String dvsCivilite;
   private String dvsNomPatient;
   private long dvsIdSociete;
   private String dvsNomSociete;
   private String dvsMatricule;
   private long dvsIdAssurance;
   private String dvsNomAssurance;
   private String dvsContratAssurance;
   private long dvsIdComplementaire;
   private String dvsNomComplemtaire;
   private String dvsContratComplementaire;
   private long dvsIdEmployeur;
   private String dvsNomEmployeur;
   private float dvsPecCnamgs;
   private int dvsFondCnamgs;
   private long dvsFam;
   private long dvsComplementaire;
   private double dvsTotPatient;
   private double dvsTotSociete;
   private double dvsTotAssurance;
   private double dvsTotComplmentaire;
   private double dvsTotTaxePatient;
   private double dvsTotTaxeSociete;
   private double dvsTotTaxeAssurance;
   private double dvsTotTaxeComplementaire;
   private double dvsTotGeneral;
   private double dvsTotRabais;
   private double dvsTotTaxeGeneral;
   private double dvsRegPatient;
   private int dvsSoldePatient;
   private double dvsRegTiers;
   private int dvsSoldeTiers;
   private String dvsBanque;
   private int dvsTypeReg;
   private String dvsModeReg;
   private int dvsNbJourReg;
   private int dvsArrondiReg;
   private Date dvsDateEcheReg;
   private String dvsActivite;
   private String dvsInfo1;
   private String dvsInfo2;
   private String dvsInfo3;
   private String dvsInfo4;
   private String dvsInfo5;
   private String dvsInfo6;
   private String dvsInfo7;
   private String dvsInfo8;
   private String dvsInfo9;
   private String dvsInfo10;
   private Date dvsDateImp;
   private String dvsModeleImp;
   private String dvsNomAssurePrincipal;
   private boolean dvsAyantDroit;
   private boolean dvsBloqueRefacturation;
   private String dvsCommentaire;
   private ExercicesVentes exerciceventes;
   private Patients patients;
   private String libelleEta;
   private String var_solde;
   private boolean var_select_ligne;
   private double var_reliquat;
   private double totalTiers;
   private double totalPatient;
   private String libelleFamille;
   private String motifEntree;
   private String entree;

   public String getEntree() {
      if (this.dvsEntree != null && !this.dvsEntree.isEmpty() && this.dvsEntree.contains(":")) {
         String[] var1 = this.dvsEntree.split(":");
         this.entree = var1[0];
      }

      return this.entree;
   }

   public void setEntree(String var1) {
      this.entree = var1;
   }

   public String getMotifEntree() {
      if (this.dvsEntree != null && !this.dvsEntree.isEmpty()) {
         if (!this.dvsEntree.startsWith("VME") && !this.dvsEntree.startsWith("VMA") && !this.dvsEntree.startsWith("AT")) {
            this.motifEntree = "CS";
         } else {
            this.motifEntree = "VME-VMA-AT";
         }
      } else {
         this.motifEntree = "";
      }

      return this.motifEntree;
   }

   public void setMotifEntree(String var1) {
      this.motifEntree = var1;
   }

   public String getLibelleFamille() {
      if (this.dvsFam == 0L) {
         this.libelleFamille = "Non Assuré";
      } else if (this.dvsFam == -1L) {
         this.libelleFamille = "Cas Social";
      } else if (this.dvsFam == -2L) {
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
      if (this.dvsEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.dvsEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.dvsEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.dvsEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.dvsEtat == 4) {
         this.libelleEta = "Clot.";
      } else if (this.dvsEtat == 5) {
         this.libelleEta = "Ctrl.";
      } else if (this.dvsEtat == 6) {
         this.libelleEta = "Refact.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public double getTotalPatient() {
      this.totalPatient = this.dvsTotPatient + this.dvsTotTaxePatient;
      return this.totalPatient;
   }

   public void setTotalPatient(double var1) {
      this.totalPatient = var1;
   }

   public double getTotalTiers() {
      this.totalTiers = this.dvsTotAssurance + this.dvsTotTaxeAssurance + this.dvsTotComplmentaire + this.dvsTotTaxeComplementaire + this.dvsTotSociete + this.dvsTotTaxeSociete;
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.dvsTotPatient + this.dvsTotTaxePatient - this.dvsRegPatient;
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
      if (this.dvsSoldePatient == 1) {
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

   public String getDvsActivite() {
      return this.dvsActivite;
   }

   public void setDvsActivite(String var1) {
      this.dvsActivite = var1;
   }

   public int getDvsArrondiReg() {
      return this.dvsArrondiReg;
   }

   public void setDvsArrondiReg(int var1) {
      this.dvsArrondiReg = var1;
   }

   public boolean isDvsAyantDroit() {
      return this.dvsAyantDroit;
   }

   public void setDvsAyantDroit(boolean var1) {
      this.dvsAyantDroit = var1;
   }

   public String getDvsBanque() {
      return this.dvsBanque;
   }

   public void setDvsBanque(String var1) {
      this.dvsBanque = var1;
   }

   public boolean isDvsBloqueRefacturation() {
      return this.dvsBloqueRefacturation;
   }

   public void setDvsBloqueRefacturation(boolean var1) {
      this.dvsBloqueRefacturation = var1;
   }

   public String getDvsCivilite() {
      return this.dvsCivilite;
   }

   public void setDvsCivilite(String var1) {
      this.dvsCivilite = var1;
   }

   public int getDvsCloture() {
      return this.dvsCloture;
   }

   public void setDvsCloture(int var1) {
      this.dvsCloture = var1;
   }

   public String getDvsCommentaire() {
      return this.dvsCommentaire;
   }

   public void setDvsCommentaire(String var1) {
      this.dvsCommentaire = var1;
   }

   public long getDvsComplementaire() {
      return this.dvsComplementaire;
   }

   public void setDvsComplementaire(long var1) {
      this.dvsComplementaire = var1;
   }

   public String getDvsContratAssurance() {
      return this.dvsContratAssurance;
   }

   public void setDvsContratAssurance(String var1) {
      this.dvsContratAssurance = var1;
   }

   public String getDvsContratComplementaire() {
      return this.dvsContratComplementaire;
   }

   public void setDvsContratComplementaire(String var1) {
      this.dvsContratComplementaire = var1;
   }

   public Date getDvsDate() {
      return this.dvsDate;
   }

   public void setDvsDate(Date var1) {
      this.dvsDate = var1;
   }

   public Date getDvsDateAnnule() {
      return this.dvsDateAnnule;
   }

   public void setDvsDateAnnule(Date var1) {
      this.dvsDateAnnule = var1;
   }

   public Date getDvsDateCreat() {
      return this.dvsDateCreat;
   }

   public void setDvsDateCreat(Date var1) {
      this.dvsDateCreat = var1;
   }

   public Date getDvsDateEcheReg() {
      return this.dvsDateEcheReg;
   }

   public void setDvsDateEcheReg(Date var1) {
      this.dvsDateEcheReg = var1;
   }

   public Date getDvsDateImp() {
      return this.dvsDateImp;
   }

   public void setDvsDateImp(Date var1) {
      this.dvsDateImp = var1;
   }

   public Date getDvsDateModif() {
      return this.dvsDateModif;
   }

   public void setDvsDateModif(Date var1) {
      this.dvsDateModif = var1;
   }

   public Date getDvsDateTransfert() {
      return this.dvsDateTransfert;
   }

   public void setDvsDateTransfert(Date var1) {
      this.dvsDateTransfert = var1;
   }

   public Date getDvsEcheanceReliquat() {
      return this.dvsEcheanceReliquat;
   }

   public void setDvsEcheanceReliquat(Date var1) {
      this.dvsEcheanceReliquat = var1;
   }

   public String getDvsEntree() {
      return this.dvsEntree;
   }

   public void setDvsEntree(String var1) {
      this.dvsEntree = var1;
   }

   public int getDvsEtat() {
      return this.dvsEtat;
   }

   public void setDvsEtat(int var1) {
      this.dvsEtat = var1;
   }

   public int getDvsEtatPaillasse() {
      return this.dvsEtatPaillasse;
   }

   public void setDvsEtatPaillasse(int var1) {
      this.dvsEtatPaillasse = var1;
   }

   public int getDvsEtatVal() {
      return this.dvsEtatVal;
   }

   public void setDvsEtatVal(int var1) {
      this.dvsEtatVal = var1;
   }

   public long getDvsFam() {
      return this.dvsFam;
   }

   public void setDvsFam(long var1) {
      this.dvsFam = var1;
   }

   public String getDvsFeuille() {
      return this.dvsFeuille;
   }

   public void setDvsFeuille(String var1) {
      this.dvsFeuille = var1;
   }

   public int getDvsFondCnamgs() {
      return this.dvsFondCnamgs;
   }

   public void setDvsFondCnamgs(int var1) {
      this.dvsFondCnamgs = var1;
   }

   public long getDvsId() {
      return this.dvsId;
   }

   public void setDvsId(long var1) {
      this.dvsId = var1;
   }

   public long getDvsIdAssurance() {
      return this.dvsIdAssurance;
   }

   public void setDvsIdAssurance(long var1) {
      this.dvsIdAssurance = var1;
   }

   public long getDvsIdComplementaire() {
      return this.dvsIdComplementaire;
   }

   public void setDvsIdComplementaire(long var1) {
      this.dvsIdComplementaire = var1;
   }

   public long getDvsIdCreateur() {
      return this.dvsIdCreateur;
   }

   public void setDvsIdCreateur(long var1) {
      this.dvsIdCreateur = var1;
   }

   public long getDvsIdEmployeur() {
      return this.dvsIdEmployeur;
   }

   public void setDvsIdEmployeur(long var1) {
      this.dvsIdEmployeur = var1;
   }

   public long getDvsIdMedecin() {
      return this.dvsIdMedecin;
   }

   public void setDvsIdMedecin(long var1) {
      this.dvsIdMedecin = var1;
   }

   public long getDvsIdModif() {
      return this.dvsIdModif;
   }

   public void setDvsIdModif(long var1) {
      this.dvsIdModif = var1;
   }

   public long getDvsIdPatient() {
      return this.dvsIdPatient;
   }

   public void setDvsIdPatient(long var1) {
      this.dvsIdPatient = var1;
   }

   public long getDvsIdSociete() {
      return this.dvsIdSociete;
   }

   public void setDvsIdSociete(long var1) {
      this.dvsIdSociete = var1;
   }

   public String getDvsInfo1() {
      return this.dvsInfo1;
   }

   public void setDvsInfo1(String var1) {
      this.dvsInfo1 = var1;
   }

   public String getDvsInfo10() {
      return this.dvsInfo10;
   }

   public void setDvsInfo10(String var1) {
      this.dvsInfo10 = var1;
   }

   public String getDvsInfo2() {
      return this.dvsInfo2;
   }

   public void setDvsInfo2(String var1) {
      this.dvsInfo2 = var1;
   }

   public String getDvsInfo3() {
      return this.dvsInfo3;
   }

   public void setDvsInfo3(String var1) {
      this.dvsInfo3 = var1;
   }

   public String getDvsInfo4() {
      return this.dvsInfo4;
   }

   public void setDvsInfo4(String var1) {
      this.dvsInfo4 = var1;
   }

   public String getDvsInfo5() {
      return this.dvsInfo5;
   }

   public void setDvsInfo5(String var1) {
      this.dvsInfo5 = var1;
   }

   public String getDvsInfo6() {
      return this.dvsInfo6;
   }

   public void setDvsInfo6(String var1) {
      this.dvsInfo6 = var1;
   }

   public String getDvsInfo7() {
      return this.dvsInfo7;
   }

   public void setDvsInfo7(String var1) {
      this.dvsInfo7 = var1;
   }

   public String getDvsInfo8() {
      return this.dvsInfo8;
   }

   public void setDvsInfo8(String var1) {
      this.dvsInfo8 = var1;
   }

   public String getDvsInfo9() {
      return this.dvsInfo9;
   }

   public void setDvsInfo9(String var1) {
      this.dvsInfo9 = var1;
   }

   public String getDvsMatricule() {
      return this.dvsMatricule;
   }

   public void setDvsMatricule(String var1) {
      this.dvsMatricule = var1;
   }

   public String getDvsMedecin() {
      return this.dvsMedecin;
   }

   public void setDvsMedecin(String var1) {
      this.dvsMedecin = var1;
   }

   public String getDvsModeReg() {
      return this.dvsModeReg;
   }

   public void setDvsModeReg(String var1) {
      this.dvsModeReg = var1;
   }

   public String getDvsModeleImp() {
      return this.dvsModeleImp;
   }

   public void setDvsModeleImp(String var1) {
      this.dvsModeleImp = var1;
   }

   public String getDvsMotifAnnule() {
      return this.dvsMotifAnnule;
   }

   public void setDvsMotifAnnule(String var1) {
      this.dvsMotifAnnule = var1;
   }

   public int getDvsNbJourReg() {
      return this.dvsNbJourReg;
   }

   public void setDvsNbJourReg(int var1) {
      this.dvsNbJourReg = var1;
   }

   public String getDvsNomAssurance() {
      return this.dvsNomAssurance;
   }

   public void setDvsNomAssurance(String var1) {
      this.dvsNomAssurance = var1;
   }

   public String getDvsNomAssurePrincipal() {
      return this.dvsNomAssurePrincipal;
   }

   public void setDvsNomAssurePrincipal(String var1) {
      this.dvsNomAssurePrincipal = var1;
   }

   public String getDvsNomComplemtaire() {
      return this.dvsNomComplemtaire;
   }

   public void setDvsNomComplemtaire(String var1) {
      this.dvsNomComplemtaire = var1;
   }

   public String getDvsNomCreateur() {
      return this.dvsNomCreateur;
   }

   public void setDvsNomCreateur(String var1) {
      this.dvsNomCreateur = var1;
   }

   public String getDvsNomEmployeur() {
      return this.dvsNomEmployeur;
   }

   public void setDvsNomEmployeur(String var1) {
      this.dvsNomEmployeur = var1;
   }

   public String getDvsNomModif() {
      return this.dvsNomModif;
   }

   public void setDvsNomModif(String var1) {
      this.dvsNomModif = var1;
   }

   public String getDvsNomPatient() {
      return this.dvsNomPatient;
   }

   public void setDvsNomPatient(String var1) {
      this.dvsNomPatient = var1;
   }

   public String getDvsNomSociete() {
      return this.dvsNomSociete;
   }

   public void setDvsNomSociete(String var1) {
      this.dvsNomSociete = var1;
   }

   public String getDvsNum() {
      return this.dvsNum;
   }

   public void setDvsNum(String var1) {
      this.dvsNum = var1;
   }

   public String getDvsNumBc() {
      return this.dvsNumBc;
   }

   public void setDvsNumBc(String var1) {
      this.dvsNumBc = var1;
   }

   public String getDvsNumHospit() {
      return this.dvsNumHospit;
   }

   public void setDvsNumHospit(String var1) {
      this.dvsNumHospit = var1;
   }

   public String getDvsNumPieceTiers() {
      return this.dvsNumPieceTiers;
   }

   public void setDvsNumPieceTiers(String var1) {
      this.dvsNumPieceTiers = var1;
   }

   public String getDvsNumRum() {
      return this.dvsNumRum;
   }

   public void setDvsNumRum(String var1) {
      this.dvsNumRum = var1;
   }

   public String getDvsNumSecteur() {
      return this.dvsNumSecteur;
   }

   public void setDvsNumSecteur(String var1) {
      this.dvsNumSecteur = var1;
   }

   public String getDvsPathologie() {
      return this.dvsPathologie;
   }

   public void setDvsPathologie(String var1) {
      this.dvsPathologie = var1;
   }

   public float getDvsPecCnamgs() {
      return this.dvsPecCnamgs;
   }

   public void setDvsPecCnamgs(float var1) {
      this.dvsPecCnamgs = var1;
   }

   public String getDvsPrescripteur() {
      return this.dvsPrescripteur;
   }

   public void setDvsPrescripteur(String var1) {
      this.dvsPrescripteur = var1;
   }

   public String getDvsProtocole() {
      return this.dvsProtocole;
   }

   public void setDvsProtocole(String var1) {
      this.dvsProtocole = var1;
   }

   public double getDvsRegPatient() {
      return this.dvsRegPatient;
   }

   public void setDvsRegPatient(double var1) {
      this.dvsRegPatient = var1;
   }

   public double getDvsRegTiers() {
      return this.dvsRegTiers;
   }

   public void setDvsRegTiers(double var1) {
      this.dvsRegTiers = var1;
   }

   public String getDvsSerie() {
      return this.dvsSerie;
   }

   public void setDvsSerie(String var1) {
      this.dvsSerie = var1;
   }

   public String getDvsService() {
      return this.dvsService;
   }

   public void setDvsService(String var1) {
      this.dvsService = var1;
   }

   public int getDvsSoldePatient() {
      return this.dvsSoldePatient;
   }

   public void setDvsSoldePatient(int var1) {
      this.dvsSoldePatient = var1;
   }

   public int getDvsSoldeTiers() {
      return this.dvsSoldeTiers;
   }

   public void setDvsSoldeTiers(int var1) {
      this.dvsSoldeTiers = var1;
   }

   public double getDvsTotAssurance() {
      return this.dvsTotAssurance;
   }

   public void setDvsTotAssurance(double var1) {
      this.dvsTotAssurance = var1;
   }

   public double getDvsTotComplmentaire() {
      return this.dvsTotComplmentaire;
   }

   public void setDvsTotComplmentaire(double var1) {
      this.dvsTotComplmentaire = var1;
   }

   public double getDvsTotGeneral() {
      return this.dvsTotGeneral;
   }

   public void setDvsTotGeneral(double var1) {
      this.dvsTotGeneral = var1;
   }

   public double getDvsTotPatient() {
      return this.dvsTotPatient;
   }

   public void setDvsTotPatient(double var1) {
      this.dvsTotPatient = var1;
   }

   public double getDvsTotRabais() {
      return this.dvsTotRabais;
   }

   public void setDvsTotRabais(double var1) {
      this.dvsTotRabais = var1;
   }

   public double getDvsTotSociete() {
      return this.dvsTotSociete;
   }

   public void setDvsTotSociete(double var1) {
      this.dvsTotSociete = var1;
   }

   public double getDvsTotTaxeAssurance() {
      return this.dvsTotTaxeAssurance;
   }

   public void setDvsTotTaxeAssurance(double var1) {
      this.dvsTotTaxeAssurance = var1;
   }

   public double getDvsTotTaxeComplementaire() {
      return this.dvsTotTaxeComplementaire;
   }

   public void setDvsTotTaxeComplementaire(double var1) {
      this.dvsTotTaxeComplementaire = var1;
   }

   public double getDvsTotTaxeGeneral() {
      return this.dvsTotTaxeGeneral;
   }

   public void setDvsTotTaxeGeneral(double var1) {
      this.dvsTotTaxeGeneral = var1;
   }

   public double getDvsTotTaxePatient() {
      return this.dvsTotTaxePatient;
   }

   public void setDvsTotTaxePatient(double var1) {
      this.dvsTotTaxePatient = var1;
   }

   public double getDvsTotTaxeSociete() {
      return this.dvsTotTaxeSociete;
   }

   public void setDvsTotTaxeSociete(double var1) {
      this.dvsTotTaxeSociete = var1;
   }

   public int getDvsTypeReg() {
      return this.dvsTypeReg;
   }

   public void setDvsTypeReg(int var1) {
      this.dvsTypeReg = var1;
   }

   public Patients getPatients() {
      return this.patients;
   }

   public void setPatients(Patients var1) {
      this.patients = var1;
   }
}
