package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ConsultationEnteteGene implements Serializable {
   private long csgId;
   private Date csgDateCreat;
   private Date csgDateModif;
   private long csgIdCreateur;
   private String csgNomCreateur;
   private long csgIdModif;
   private String csgNomModif;
   private String csgNum;
   private String csgFeuille;
   private Date csgDate;
   private String csgSerie;
   private Date csgDateTransfert;
   private Date csgDateAnnule;
   private String csgMotifAnnule;
   private Date csgEcheanceReliquat;
   private String csgNumPieceTiers;
   private int csgEtatVal;
   private int csgCloture;
   private int csgEtat;
   private String csgNumHospit;
   private String csgNumRum;
   private long csgIdSejour;
   private String csgService;
   private String csgProtocole;
   private String csgPathologie;
   private String csgEntree;
   private String csgObjet;
   private String csgPrescripteur;
   private long csgIdMedecin;
   private String csgMedecin;
   private String csgNumBc;
   private String csgNumSecteur;
   private long csgIdPatient;
   private String csgCivilite;
   private String csgNomPatient;
   private long csgIdSociete;
   private String csgNomSociete;
   private String csgMatricule;
   private long csgIdAssurance;
   private String csgNomAssurance;
   private String csgContratAssurance;
   private long csgIdComplementaire;
   private String csgNomComplemtaire;
   private String csgContratComplementaire;
   private long csgIdEmployeur;
   private String csgNomEmployeur;
   private float csgPecCnamgs;
   private int csgFondCnamgs;
   private long csgFam;
   private long csgComplementaire;
   private double csgTotPatient;
   private double csgTotSociete;
   private double csgTotAssurance;
   private double csgTotComplmentaire;
   private double csgTotTaxePatient;
   private double csgTotTaxeSociete;
   private double csgTotTaxeAssurance;
   private double csgTotTaxeComplementaire;
   private double csgTotGeneral;
   private double csgTotRabais;
   private double csgTotTaxeGeneral;
   private double csgRegPatient;
   private int csgSoldePatient;
   private double csgRegTiers;
   private int csgSoldeTiers;
   private String csgBanque;
   private int csgTypeReg;
   private String csgModeReg;
   private int csgNbJourReg;
   private int csgArrondiReg;
   private Date csgDateEcheReg;
   private String csgActivite;
   private Date csgDateImp;
   private String csgModeleImp;
   private String csgAnamese;
   private float csgPoids;
   private float csgTaille;
   private float csgImc;
   private float csgTemperature;
   private float csgTension;
   private float csgTensionDroit;
   private float csgFreCar;
   private float csgFreRes;
   private float csgDiurese;
   private float csgOeilGauche;
   private float csgOeilDroit;
   private String csgExamClinique;
   private String csgDiscution;
   private String csgEvolution;
   private String csgPronostic;
   private String csgCodeDiag1;
   private String csgCodeDiag2;
   private String csgCodeDiag3;
   private String csgCodeDiag4;
   private String csgCodeDiag5;
   private String csgCodeDiag11;
   private String csgCodeDiag12;
   private boolean csgChoixHospit;
   private boolean csgChoixObs;
   private boolean csgChoixRefere;
   private boolean csgChoixVisitepa;
   private Date csgRdv;
   private String csgNomAssurePrincipal;
   private boolean csgAyantDroit;
   private boolean csgBloqueRefacturation;
   private ExercicesVentes exerciceventes;
   private Patients patients;
   private String libelleEta;
   private String var_solde;
   private boolean var_select_ligne;
   private double var_reliquat;
   private String lib_diag1;
   private String lib_diag2;
   private String lib_diag3;
   private String lib_diag4;
   private String lib_diag5;
   private String lib_diag11;
   private String lib_diag12;
   private String lib_diag13;
   private double totalTiers;
   private double totalPatient;
   private String lib_fonds;
   private String libelleFamille;
   private String nomActe;
   private boolean prescriptOrdo;
   private boolean sortieMed;
   private String nomMed;
   private boolean prescripLabo;
   private String typeExamen;
   private int nbJourArretTravail;
   private Date du;
   private Date au;
   private String motifEntree;
   private String entree;

   public double getTotalTiers() {
      this.totalTiers = this.csgTotSociete + this.csgTotAssurance + this.csgTotComplmentaire + this.csgTotTaxeSociete + this.csgTotTaxeAssurance + this.csgTotTaxeComplementaire;
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public String getEntree() {
      if (this.csgEntree != null && !this.csgEntree.isEmpty() && this.csgEntree.contains(":")) {
         String[] var1 = this.csgEntree.split(":");
         this.entree = var1[0];
      }

      return this.entree;
   }

   public void setEntree(String var1) {
      this.entree = var1;
   }

   public String getMotifEntree() {
      if (this.csgEntree != null && !this.csgEntree.isEmpty()) {
         if (!this.csgEntree.startsWith("VME") && !this.csgEntree.startsWith("VMA") && !this.csgEntree.startsWith("AT")) {
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
      if (this.csgFam == 0L) {
         this.libelleFamille = "Non Assuré";
      } else if (this.csgFam == -1L) {
         this.libelleFamille = "Cas Social";
      } else if (this.csgFam == -2L) {
         this.libelleFamille = "Etat";
      } else {
         this.libelleFamille = "Assuré";
      }

      return this.libelleFamille;
   }

   public void setLibelleFamille(String var1) {
      this.libelleFamille = var1;
   }

   public String getLib_fonds() {
      if (this.csgFondCnamgs == 0) {
         this.lib_fonds = "";
      } else if (this.csgFondCnamgs == 1) {
         this.lib_fonds = "Fonds 1 + Consultations";
      } else if (this.csgFondCnamgs == 2) {
         this.lib_fonds = "Fonds 2 + Consultations";
      } else if (this.csgFondCnamgs == 3) {
         this.lib_fonds = "Fonds 3 + Consultations";
      } else if (this.csgFondCnamgs == 11) {
         this.lib_fonds = "Fonds 1 + Examens";
      } else if (this.csgFondCnamgs == 12) {
         this.lib_fonds = "Fonds 2 + Examens";
      } else if (this.csgFondCnamgs == 13) {
         this.lib_fonds = "Fonds 3 + Examens";
      }

      return this.lib_fonds;
   }

   public void setLib_fonds(String var1) {
      this.lib_fonds = var1;
   }

   public double getTotalPatient() {
      this.totalPatient = this.csgTotPatient + this.csgTotTaxePatient;
      return this.totalPatient;
   }

   public void setTotalPatient(double var1) {
      this.totalPatient = var1;
   }

   public String getLibelleEta() {
      if (this.csgEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.csgEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.csgEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.csgEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.csgEtat == 4) {
         this.libelleEta = "Clot.";
      } else if (this.csgEtat == 5) {
         this.libelleEta = "Ctrl.";
      } else if (this.csgEtat == 6) {
         this.libelleEta = "Refact.Std";
      } else if (this.csgEtat == 7) {
         this.libelleEta = "Refact.Cpl";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public String getVar_solde() {
      if (this.csgSoldePatient == 1) {
         this.var_solde = "Soldé";
      } else {
         this.var_solde = "";
      }

      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.csgTotPatient + this.csgTotTaxePatient - this.csgRegPatient;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public String getCsgActivite() {
      return this.csgActivite;
   }

   public void setCsgActivite(String var1) {
      this.csgActivite = var1;
   }

   public int getCsgArrondiReg() {
      return this.csgArrondiReg;
   }

   public void setCsgArrondiReg(int var1) {
      this.csgArrondiReg = var1;
   }

   public String getCsgBanque() {
      return this.csgBanque;
   }

   public void setCsgBanque(String var1) {
      this.csgBanque = var1;
   }

   public String getCsgCivilite() {
      return this.csgCivilite;
   }

   public void setCsgCivilite(String var1) {
      this.csgCivilite = var1;
   }

   public int getCsgCloture() {
      return this.csgCloture;
   }

   public void setCsgCloture(int var1) {
      this.csgCloture = var1;
   }

   public String getCsgContratAssurance() {
      return this.csgContratAssurance;
   }

   public void setCsgContratAssurance(String var1) {
      this.csgContratAssurance = var1;
   }

   public String getCsgContratComplementaire() {
      return this.csgContratComplementaire;
   }

   public void setCsgContratComplementaire(String var1) {
      this.csgContratComplementaire = var1;
   }

   public Date getCsgDate() {
      return this.csgDate;
   }

   public void setCsgDate(Date var1) {
      this.csgDate = var1;
   }

   public Date getCsgDateCreat() {
      return this.csgDateCreat;
   }

   public void setCsgDateCreat(Date var1) {
      this.csgDateCreat = var1;
   }

   public Date getCsgDateEcheReg() {
      return this.csgDateEcheReg;
   }

   public void setCsgDateEcheReg(Date var1) {
      this.csgDateEcheReg = var1;
   }

   public Date getCsgDateImp() {
      return this.csgDateImp;
   }

   public void setCsgDateImp(Date var1) {
      this.csgDateImp = var1;
   }

   public Date getCsgDateModif() {
      return this.csgDateModif;
   }

   public void setCsgDateModif(Date var1) {
      this.csgDateModif = var1;
   }

   public Date getCsgDateTransfert() {
      return this.csgDateTransfert;
   }

   public void setCsgDateTransfert(Date var1) {
      this.csgDateTransfert = var1;
   }

   public String getCsgEntree() {
      return this.csgEntree;
   }

   public void setCsgEntree(String var1) {
      this.csgEntree = var1;
   }

   public int getCsgEtat() {
      return this.csgEtat;
   }

   public void setCsgEtat(int var1) {
      this.csgEtat = var1;
   }

   public long getCsgId() {
      return this.csgId;
   }

   public void setCsgId(long var1) {
      this.csgId = var1;
   }

   public long getCsgIdAssurance() {
      return this.csgIdAssurance;
   }

   public void setCsgIdAssurance(long var1) {
      this.csgIdAssurance = var1;
   }

   public long getCsgIdComplementaire() {
      return this.csgIdComplementaire;
   }

   public void setCsgIdComplementaire(long var1) {
      this.csgIdComplementaire = var1;
   }

   public long getCsgIdCreateur() {
      return this.csgIdCreateur;
   }

   public void setCsgIdCreateur(long var1) {
      this.csgIdCreateur = var1;
   }

   public long getCsgIdMedecin() {
      return this.csgIdMedecin;
   }

   public void setCsgIdMedecin(long var1) {
      this.csgIdMedecin = var1;
   }

   public long getCsgIdModif() {
      return this.csgIdModif;
   }

   public void setCsgIdModif(long var1) {
      this.csgIdModif = var1;
   }

   public long getCsgIdSociete() {
      return this.csgIdSociete;
   }

   public void setCsgIdSociete(long var1) {
      this.csgIdSociete = var1;
   }

   public String getCsgMatricule() {
      return this.csgMatricule;
   }

   public void setCsgMatricule(String var1) {
      this.csgMatricule = var1;
   }

   public String getCsgMedecin() {
      return this.csgMedecin;
   }

   public void setCsgMedecin(String var1) {
      this.csgMedecin = var1;
   }

   public String getCsgModeReg() {
      return this.csgModeReg;
   }

   public void setCsgModeReg(String var1) {
      this.csgModeReg = var1;
   }

   public String getCsgModeleImp() {
      return this.csgModeleImp;
   }

   public void setCsgModeleImp(String var1) {
      this.csgModeleImp = var1;
   }

   public int getCsgNbJourReg() {
      return this.csgNbJourReg;
   }

   public void setCsgNbJourReg(int var1) {
      this.csgNbJourReg = var1;
   }

   public String getCsgNomAssurance() {
      return this.csgNomAssurance;
   }

   public void setCsgNomAssurance(String var1) {
      this.csgNomAssurance = var1;
   }

   public String getCsgNomComplemtaire() {
      return this.csgNomComplemtaire;
   }

   public void setCsgNomComplemtaire(String var1) {
      this.csgNomComplemtaire = var1;
   }

   public String getCsgNomCreateur() {
      return this.csgNomCreateur;
   }

   public void setCsgNomCreateur(String var1) {
      this.csgNomCreateur = var1;
   }

   public String getCsgNomModif() {
      return this.csgNomModif;
   }

   public void setCsgNomModif(String var1) {
      this.csgNomModif = var1;
   }

   public String getCsgNomPatient() {
      return this.csgNomPatient;
   }

   public void setCsgNomPatient(String var1) {
      this.csgNomPatient = var1;
   }

   public String getCsgNomSociete() {
      return this.csgNomSociete;
   }

   public void setCsgNomSociete(String var1) {
      this.csgNomSociete = var1;
   }

   public String getCsgNum() {
      return this.csgNum;
   }

   public void setCsgNum(String var1) {
      this.csgNum = var1;
   }

   public String getCsgNumBc() {
      return this.csgNumBc;
   }

   public void setCsgNumBc(String var1) {
      this.csgNumBc = var1;
   }

   public String getCsgNumHospit() {
      return this.csgNumHospit;
   }

   public void setCsgNumHospit(String var1) {
      this.csgNumHospit = var1;
   }

   public String getCsgNumRum() {
      return this.csgNumRum;
   }

   public void setCsgNumRum(String var1) {
      this.csgNumRum = var1;
   }

   public String getCsgPrescripteur() {
      return this.csgPrescripteur;
   }

   public void setCsgPrescripteur(String var1) {
      this.csgPrescripteur = var1;
   }

   public String getCsgProtocole() {
      return this.csgProtocole;
   }

   public void setCsgProtocole(String var1) {
      this.csgProtocole = var1;
   }

   public double getCsgRegPatient() {
      return this.csgRegPatient;
   }

   public void setCsgRegPatient(double var1) {
      this.csgRegPatient = var1;
   }

   public double getCsgRegTiers() {
      return this.csgRegTiers;
   }

   public void setCsgRegTiers(double var1) {
      this.csgRegTiers = var1;
   }

   public String getCsgSerie() {
      return this.csgSerie;
   }

   public void setCsgSerie(String var1) {
      this.csgSerie = var1;
   }

   public String getCsgService() {
      return this.csgService;
   }

   public void setCsgService(String var1) {
      this.csgService = var1;
   }

   public int getCsgSoldePatient() {
      return this.csgSoldePatient;
   }

   public void setCsgSoldePatient(int var1) {
      this.csgSoldePatient = var1;
   }

   public int getCsgSoldeTiers() {
      return this.csgSoldeTiers;
   }

   public void setCsgSoldeTiers(int var1) {
      this.csgSoldeTiers = var1;
   }

   public double getCsgTotAssurance() {
      return this.csgTotAssurance;
   }

   public void setCsgTotAssurance(double var1) {
      this.csgTotAssurance = var1;
   }

   public double getCsgTotComplmentaire() {
      return this.csgTotComplmentaire;
   }

   public void setCsgTotComplmentaire(double var1) {
      this.csgTotComplmentaire = var1;
   }

   public double getCsgTotGeneral() {
      return this.csgTotGeneral;
   }

   public void setCsgTotGeneral(double var1) {
      this.csgTotGeneral = var1;
   }

   public double getCsgTotPatient() {
      return this.csgTotPatient;
   }

   public void setCsgTotPatient(double var1) {
      this.csgTotPatient = var1;
   }

   public double getCsgTotSociete() {
      return this.csgTotSociete;
   }

   public void setCsgTotSociete(double var1) {
      this.csgTotSociete = var1;
   }

   public double getCsgTotTaxeAssurance() {
      return this.csgTotTaxeAssurance;
   }

   public void setCsgTotTaxeAssurance(double var1) {
      this.csgTotTaxeAssurance = var1;
   }

   public double getCsgTotTaxeComplementaire() {
      return this.csgTotTaxeComplementaire;
   }

   public void setCsgTotTaxeComplementaire(double var1) {
      this.csgTotTaxeComplementaire = var1;
   }

   public double getCsgTotTaxePatient() {
      return this.csgTotTaxePatient;
   }

   public void setCsgTotTaxePatient(double var1) {
      this.csgTotTaxePatient = var1;
   }

   public double getCsgTotTaxeSociete() {
      return this.csgTotTaxeSociete;
   }

   public void setCsgTotTaxeSociete(double var1) {
      this.csgTotTaxeSociete = var1;
   }

   public int getCsgTypeReg() {
      return this.csgTypeReg;
   }

   public void setCsgTypeReg(int var1) {
      this.csgTypeReg = var1;
   }

   public long getCsgIdPatient() {
      return this.csgIdPatient;
   }

   public void setCsgIdPatient(long var1) {
      this.csgIdPatient = var1;
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

   public long getCsgFam() {
      return this.csgFam;
   }

   public void setCsgFam(long var1) {
      this.csgFam = var1;
   }

   public String getCsgPathologie() {
      return this.csgPathologie;
   }

   public void setCsgPathologie(String var1) {
      this.csgPathologie = var1;
   }

   public String getCsgAnamese() {
      return this.csgAnamese;
   }

   public void setCsgAnamese(String var1) {
      this.csgAnamese = var1;
   }

   public float getCsgOeilDroit() {
      return this.csgOeilDroit;
   }

   public void setCsgOeilDroit(float var1) {
      this.csgOeilDroit = var1;
   }

   public float getCsgOeilGauche() {
      return this.csgOeilGauche;
   }

   public void setCsgOeilGauche(float var1) {
      this.csgOeilGauche = var1;
   }

   public float getCsgPoids() {
      return this.csgPoids;
   }

   public void setCsgPoids(float var1) {
      this.csgPoids = var1;
   }

   public float getCsgTaille() {
      return this.csgTaille;
   }

   public void setCsgTaille(float var1) {
      this.csgTaille = var1;
   }

   public float getCsgTemperature() {
      return this.csgTemperature;
   }

   public void setCsgTemperature(float var1) {
      this.csgTemperature = var1;
   }

   public String getCsgExamClinique() {
      return this.csgExamClinique;
   }

   public void setCsgExamClinique(String var1) {
      this.csgExamClinique = var1;
   }

   public boolean isCsgChoixHospit() {
      return this.csgChoixHospit;
   }

   public void setCsgChoixHospit(boolean var1) {
      this.csgChoixHospit = var1;
   }

   public boolean isCsgChoixObs() {
      return this.csgChoixObs;
   }

   public void setCsgChoixObs(boolean var1) {
      this.csgChoixObs = var1;
   }

   public boolean isCsgChoixRefere() {
      return this.csgChoixRefere;
   }

   public void setCsgChoixRefere(boolean var1) {
      this.csgChoixRefere = var1;
   }

   public boolean isCsgChoixVisitepa() {
      return this.csgChoixVisitepa;
   }

   public void setCsgChoixVisitepa(boolean var1) {
      this.csgChoixVisitepa = var1;
   }

   public String getCsgCodeDiag1() {
      return this.csgCodeDiag1;
   }

   public void setCsgCodeDiag1(String var1) {
      this.csgCodeDiag1 = var1;
   }

   public String getCsgCodeDiag2() {
      return this.csgCodeDiag2;
   }

   public void setCsgCodeDiag2(String var1) {
      this.csgCodeDiag2 = var1;
   }

   public Date getCsgRdv() {
      return this.csgRdv;
   }

   public void setCsgRdv(Date var1) {
      this.csgRdv = var1;
   }

   public String getLib_diag1() {
      return this.lib_diag1;
   }

   public void setLib_diag1(String var1) {
      this.lib_diag1 = var1;
   }

   public String getLib_diag2() {
      return this.lib_diag2;
   }

   public void setLib_diag2(String var1) {
      this.lib_diag2 = var1;
   }

   public float getCsgPecCnamgs() {
      return this.csgPecCnamgs;
   }

   public void setCsgPecCnamgs(float var1) {
      this.csgPecCnamgs = var1;
   }

   public float getCsgFreCar() {
      return this.csgFreCar;
   }

   public void setCsgFreCar(float var1) {
      this.csgFreCar = var1;
   }

   public float getCsgFreRes() {
      return this.csgFreRes;
   }

   public void setCsgFreRes(float var1) {
      this.csgFreRes = var1;
   }

   public float getCsgTension() {
      return this.csgTension;
   }

   public void setCsgTension(float var1) {
      this.csgTension = var1;
   }

   public float getCsgDiurese() {
      return this.csgDiurese;
   }

   public void setCsgDiurese(float var1) {
      this.csgDiurese = var1;
   }

   public String getCsgCodeDiag11() {
      return this.csgCodeDiag11;
   }

   public void setCsgCodeDiag11(String var1) {
      this.csgCodeDiag11 = var1;
   }

   public String getCsgCodeDiag12() {
      return this.csgCodeDiag12;
   }

   public void setCsgCodeDiag12(String var1) {
      this.csgCodeDiag12 = var1;
   }

   public String getCsgCodeDiag3() {
      return this.csgCodeDiag3;
   }

   public void setCsgCodeDiag3(String var1) {
      this.csgCodeDiag3 = var1;
   }

   public String getCsgCodeDiag4() {
      return this.csgCodeDiag4;
   }

   public void setCsgCodeDiag4(String var1) {
      this.csgCodeDiag4 = var1;
   }

   public String getCsgCodeDiag5() {
      return this.csgCodeDiag5;
   }

   public void setCsgCodeDiag5(String var1) {
      this.csgCodeDiag5 = var1;
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

   public String getLib_diag3() {
      return this.lib_diag3;
   }

   public void setLib_diag3(String var1) {
      this.lib_diag3 = var1;
   }

   public String getLib_diag4() {
      return this.lib_diag4;
   }

   public void setLib_diag4(String var1) {
      this.lib_diag4 = var1;
   }

   public String getLib_diag5() {
      return this.lib_diag5;
   }

   public void setLib_diag5(String var1) {
      this.lib_diag5 = var1;
   }

   public String getCsgDiscution() {
      return this.csgDiscution;
   }

   public void setCsgDiscution(String var1) {
      this.csgDiscution = var1;
   }

   public String getCsgEvolution() {
      return this.csgEvolution;
   }

   public void setCsgEvolution(String var1) {
      this.csgEvolution = var1;
   }

   public String getCsgPronostic() {
      return this.csgPronostic;
   }

   public void setCsgPronostic(String var1) {
      this.csgPronostic = var1;
   }

   public int getCsgEtatVal() {
      return this.csgEtatVal;
   }

   public void setCsgEtatVal(int var1) {
      this.csgEtatVal = var1;
   }

   public double getCsgTotTaxeGeneral() {
      return this.csgTotTaxeGeneral;
   }

   public void setCsgTotTaxeGeneral(double var1) {
      this.csgTotTaxeGeneral = var1;
   }

   public Date getCsgEcheanceReliquat() {
      return this.csgEcheanceReliquat;
   }

   public void setCsgEcheanceReliquat(Date var1) {
      this.csgEcheanceReliquat = var1;
   }

   public int getCsgFondCnamgs() {
      return this.csgFondCnamgs;
   }

   public void setCsgFondCnamgs(int var1) {
      this.csgFondCnamgs = var1;
   }

   public long getCsgIdEmployeur() {
      return this.csgIdEmployeur;
   }

   public void setCsgIdEmployeur(long var1) {
      this.csgIdEmployeur = var1;
   }

   public long getCsgComplementaire() {
      return this.csgComplementaire;
   }

   public void setCsgComplementaire(long var1) {
      this.csgComplementaire = var1;
   }

   public Date getCsgDateAnnule() {
      return this.csgDateAnnule;
   }

   public void setCsgDateAnnule(Date var1) {
      this.csgDateAnnule = var1;
   }

   public String getCsgMotifAnnule() {
      return this.csgMotifAnnule;
   }

   public void setCsgMotifAnnule(String var1) {
      this.csgMotifAnnule = var1;
   }

   public String getCsgNumSecteur() {
      return this.csgNumSecteur;
   }

   public void setCsgNumSecteur(String var1) {
      this.csgNumSecteur = var1;
   }

   public boolean isCsgAyantDroit() {
      return this.csgAyantDroit;
   }

   public void setCsgAyantDroit(boolean var1) {
      this.csgAyantDroit = var1;
   }

   public String getCsgNomAssurePrincipal() {
      return this.csgNomAssurePrincipal;
   }

   public void setCsgNomAssurePrincipal(String var1) {
      this.csgNomAssurePrincipal = var1;
   }

   public String getCsgObjet() {
      return this.csgObjet;
   }

   public void setCsgObjet(String var1) {
      this.csgObjet = var1;
   }

   public Date getAu() {
      return this.au;
   }

   public void setAu(Date var1) {
      this.au = var1;
   }

   public Date getDu() {
      return this.du;
   }

   public void setDu(Date var1) {
      this.du = var1;
   }

   public int getNbJourArretTravail() {
      return this.nbJourArretTravail;
   }

   public void setNbJourArretTravail(int var1) {
      this.nbJourArretTravail = var1;
   }

   public String getNomMed() {
      return this.nomMed;
   }

   public void setNomMed(String var1) {
      this.nomMed = var1;
   }

   public boolean isPrescripLabo() {
      return this.prescripLabo;
   }

   public void setPrescripLabo(boolean var1) {
      this.prescripLabo = var1;
   }

   public boolean isPrescriptOrdo() {
      return this.prescriptOrdo;
   }

   public void setPrescriptOrdo(boolean var1) {
      this.prescriptOrdo = var1;
   }

   public boolean isSortieMed() {
      return this.sortieMed;
   }

   public void setSortieMed(boolean var1) {
      this.sortieMed = var1;
   }

   public String getTypeExamen() {
      return this.typeExamen;
   }

   public void setTypeExamen(String var1) {
      this.typeExamen = var1;
   }

   public String getNomActe() {
      return this.nomActe;
   }

   public void setNomActe(String var1) {
      this.nomActe = var1;
   }

   public String getCsgNomEmployeur() {
      return this.csgNomEmployeur;
   }

   public void setCsgNomEmployeur(String var1) {
      this.csgNomEmployeur = var1;
   }

   public float getCsgImc() {
      return this.csgImc;
   }

   public void setCsgImc(float var1) {
      this.csgImc = var1;
   }

   public float getCsgTensionDroit() {
      return this.csgTensionDroit;
   }

   public void setCsgTensionDroit(float var1) {
      this.csgTensionDroit = var1;
   }

   public String getCsgNumPieceTiers() {
      return this.csgNumPieceTiers;
   }

   public void setCsgNumPieceTiers(String var1) {
      this.csgNumPieceTiers = var1;
   }

   public long getCsgIdSejour() {
      return this.csgIdSejour;
   }

   public void setCsgIdSejour(long var1) {
      this.csgIdSejour = var1;
   }

   public boolean isCsgBloqueRefacturation() {
      return this.csgBloqueRefacturation;
   }

   public void setCsgBloqueRefacturation(boolean var1) {
      this.csgBloqueRefacturation = var1;
   }

   public String getCsgFeuille() {
      return this.csgFeuille;
   }

   public void setCsgFeuille(String var1) {
      this.csgFeuille = var1;
   }

   public double getCsgTotRabais() {
      return this.csgTotRabais;
   }

   public void setCsgTotRabais(double var1) {
      this.csgTotRabais = var1;
   }
}
