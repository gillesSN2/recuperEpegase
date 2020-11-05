package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class LaboratoireEntete implements Serializable {
   private long labId;
   private Date labDateCreat;
   private Date labDateModif;
   private long labIdCreateur;
   private String labNomCreateur;
   private long labIdModif;
   private String labNomModif;
   private String labNum;
   private String labFeuille;
   private Date labDate;
   private String labSerie;
   private Date labDateTransfert;
   private Date labDateAnnule;
   private String labMotifAnnule;
   private String labMotifDecloture;
   private Date labEcheanceReliquat;
   private String labNumPieceTiers;
   private int labEtatVal;
   private int labCloture;
   private int labEtat;
   private int labEtatPaillasse;
   private String labNumHospit;
   private String labNumRum;
   private String labService;
   private String labLaboratoire;
   private String labProtocole;
   private String labPathologie;
   private String labEntree;
   private String labPrescripteur;
   private long labIdMedecin;
   private String labMedecin;
   private String labNumBc;
   private String labNumSecteur;
   private long labIdPatient;
   private String labCivilite;
   private String labNomPatient;
   private long labIdSociete;
   private String labNomSociete;
   private String labMatricule;
   private long labIdAssurance;
   private String labNomAssurance;
   private String labContratAssurance;
   private long labIdComplementaire;
   private String labNomComplemtaire;
   private String labContratComplementaire;
   private long labIdEmployeur;
   private String labNomEmployeur;
   private float labPecCnamgs;
   private int labFondCnamgs;
   private long labFam;
   private long labComplementaire;
   private double labTotPatient;
   private double labTotSociete;
   private double labTotAssurance;
   private double labTotComplmentaire;
   private double labTotTaxePatient;
   private double labTotTaxeSociete;
   private double labTotTaxeAssurance;
   private double labTotTaxeComplementaire;
   private double labTotGeneral;
   private double labTotRabais;
   private double labTotTaxeGeneral;
   private double labRegPatient;
   private int labSoldePatient;
   private double labRegTiers;
   private int labSoldeTiers;
   private String labBanque;
   private int labTypeReg;
   private String labModeReg;
   private int labNbJourReg;
   private int labArrondiReg;
   private Date labDateEcheReg;
   private String labActivite;
   private String labInfo1;
   private String labInfo2;
   private String labInfo3;
   private String labInfo4;
   private String labInfo5;
   private String labInfo6;
   private String labInfo7;
   private String labInfo8;
   private String labInfo9;
   private String labInfo10;
   private Date labDateImp;
   private String labModeleImp;
   private Date labDateResultat;
   private Date labDatePrelevement;
   private int labLieuPrelevement;
   private int labPartenaire;
   private Date labDateRegles;
   private boolean labAnonyme;
   private String labNomAssurePrincipal;
   private boolean labAyantDroit;
   private boolean labBloqueRefacturation;
   private String labCommentaire;
   private String labNomResultat;
   private String labModeleImpResultat;
   private boolean labGrossesse;
   private boolean labDiabete;
   private boolean labImmunodepressif;
   private boolean labTraitement;
   private String labLequel;
   private int labUrgent;
   private ExercicesVentes exerciceventes;
   private Patients patients;
   private String libelleEta;
   private String var_solde;
   private boolean var_select_ligne;
   private double var_reliquat;
   private double totalTiers;
   private double totalPatient;
   private String nom_anonyme;
   private String libelleFamille;
   private String motifEntree;
   private String entree;

   public String getEntree() {
      if (this.labEntree != null && !this.labEntree.isEmpty() && this.labEntree.contains(":")) {
         String[] var1 = this.labEntree.split(":");
         this.entree = var1[0];
      }

      return this.entree;
   }

   public void setEntree(String var1) {
      this.entree = var1;
   }

   public String getMotifEntree() {
      if (this.labEntree != null && !this.labEntree.isEmpty()) {
         if (!this.labEntree.startsWith("VME") && !this.labEntree.startsWith("VMA") && !this.labEntree.startsWith("AT")) {
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
      if (this.labFam == 0L) {
         this.libelleFamille = "Non Assuré";
      } else if (this.labFam == -1L) {
         this.libelleFamille = "Cas Social";
      } else if (this.labFam == -2L) {
         this.libelleFamille = "Etat";
      } else {
         this.libelleFamille = "Assuré";
      }

      return this.libelleFamille;
   }

   public void setLibelleFamille(String var1) {
      this.libelleFamille = var1;
   }

   public String getNom_anonyme() {
      if (this.labAnonyme) {
         this.nom_anonyme = "ANONYME N°" + this.labIdPatient;
      } else {
         this.nom_anonyme = this.labNomPatient;
      }

      return this.nom_anonyme;
   }

   public void setNom_anonyme(String var1) {
      this.nom_anonyme = var1;
   }

   public String getLibelleEta() {
      if (this.labEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.labEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.labEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.labEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.labEtat == 4) {
         this.libelleEta = "Clot.";
      } else if (this.labEtat == 5) {
         this.libelleEta = "Ctrl.";
      } else if (this.labEtat == 6) {
         this.libelleEta = "Refact.Std";
      } else if (this.labEtat == 7) {
         this.libelleEta = "Refact.Cpl";
      }

      if (this.labCloture == 1) {
         this.libelleEta = this.libelleEta + "Clot.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public double getTotalPatient() {
      this.totalPatient = this.labTotPatient + this.labTotTaxePatient;
      return this.totalPatient;
   }

   public void setTotalPatient(double var1) {
      this.totalPatient = var1;
   }

   public double getTotalTiers() {
      this.totalTiers = this.labTotAssurance + this.labTotTaxeAssurance + this.labTotComplmentaire + this.labTotTaxeComplementaire + this.labTotSociete + this.labTotTaxeSociete;
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.labTotPatient + this.labTotTaxePatient - this.labRegPatient;
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
      if (this.labSoldePatient == 1) {
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

   public String getLabActivite() {
      return this.labActivite;
   }

   public void setLabActivite(String var1) {
      this.labActivite = var1;
   }

   public int getLabArrondiReg() {
      return this.labArrondiReg;
   }

   public void setLabArrondiReg(int var1) {
      this.labArrondiReg = var1;
   }

   public String getLabBanque() {
      return this.labBanque;
   }

   public void setLabBanque(String var1) {
      this.labBanque = var1;
   }

   public String getLabCivilite() {
      return this.labCivilite;
   }

   public void setLabCivilite(String var1) {
      this.labCivilite = var1;
   }

   public int getLabCloture() {
      return this.labCloture;
   }

   public void setLabCloture(int var1) {
      this.labCloture = var1;
   }

   public String getLabContratAssurance() {
      return this.labContratAssurance;
   }

   public void setLabContratAssurance(String var1) {
      this.labContratAssurance = var1;
   }

   public String getLabContratComplementaire() {
      return this.labContratComplementaire;
   }

   public void setLabContratComplementaire(String var1) {
      this.labContratComplementaire = var1;
   }

   public Date getLabDate() {
      return this.labDate;
   }

   public void setLabDate(Date var1) {
      this.labDate = var1;
   }

   public Date getLabDateCreat() {
      return this.labDateCreat;
   }

   public void setLabDateCreat(Date var1) {
      this.labDateCreat = var1;
   }

   public Date getLabDateEcheReg() {
      return this.labDateEcheReg;
   }

   public void setLabDateEcheReg(Date var1) {
      this.labDateEcheReg = var1;
   }

   public Date getLabDateImp() {
      return this.labDateImp;
   }

   public void setLabDateImp(Date var1) {
      this.labDateImp = var1;
   }

   public Date getLabDateModif() {
      return this.labDateModif;
   }

   public void setLabDateModif(Date var1) {
      this.labDateModif = var1;
   }

   public Date getLabDatePrelevement() {
      return this.labDatePrelevement;
   }

   public void setLabDatePrelevement(Date var1) {
      this.labDatePrelevement = var1;
   }

   public Date getLabDateRegles() {
      return this.labDateRegles;
   }

   public void setLabDateRegles(Date var1) {
      this.labDateRegles = var1;
   }

   public Date getLabDateResultat() {
      return this.labDateResultat;
   }

   public void setLabDateResultat(Date var1) {
      this.labDateResultat = var1;
   }

   public Date getLabDateTransfert() {
      return this.labDateTransfert;
   }

   public void setLabDateTransfert(Date var1) {
      this.labDateTransfert = var1;
   }

   public Date getLabEcheanceReliquat() {
      return this.labEcheanceReliquat;
   }

   public void setLabEcheanceReliquat(Date var1) {
      this.labEcheanceReliquat = var1;
   }

   public int getLabEtat() {
      return this.labEtat;
   }

   public void setLabEtat(int var1) {
      this.labEtat = var1;
   }

   public int getLabEtatVal() {
      return this.labEtatVal;
   }

   public void setLabEtatVal(int var1) {
      this.labEtatVal = var1;
   }

   public long getLabComplementaire() {
      return this.labComplementaire;
   }

   public void setLabComplementaire(long var1) {
      this.labComplementaire = var1;
   }

   public long getLabFam() {
      return this.labFam;
   }

   public void setLabFam(long var1) {
      this.labFam = var1;
   }

   public long getLabId() {
      return this.labId;
   }

   public void setLabId(long var1) {
      this.labId = var1;
   }

   public long getLabIdAssurance() {
      return this.labIdAssurance;
   }

   public void setLabIdAssurance(long var1) {
      this.labIdAssurance = var1;
   }

   public long getLabIdComplementaire() {
      return this.labIdComplementaire;
   }

   public void setLabIdComplementaire(long var1) {
      this.labIdComplementaire = var1;
   }

   public long getLabIdCreateur() {
      return this.labIdCreateur;
   }

   public void setLabIdCreateur(long var1) {
      this.labIdCreateur = var1;
   }

   public long getLabIdMedecin() {
      return this.labIdMedecin;
   }

   public void setLabIdMedecin(long var1) {
      this.labIdMedecin = var1;
   }

   public long getLabIdModif() {
      return this.labIdModif;
   }

   public void setLabIdModif(long var1) {
      this.labIdModif = var1;
   }

   public long getLabIdPatient() {
      return this.labIdPatient;
   }

   public void setLabIdPatient(long var1) {
      this.labIdPatient = var1;
   }

   public long getLabIdSociete() {
      return this.labIdSociete;
   }

   public void setLabIdSociete(long var1) {
      this.labIdSociete = var1;
   }

   public String getLabInfo1() {
      return this.labInfo1;
   }

   public void setLabInfo1(String var1) {
      this.labInfo1 = var1;
   }

   public String getLabInfo10() {
      return this.labInfo10;
   }

   public void setLabInfo10(String var1) {
      this.labInfo10 = var1;
   }

   public String getLabInfo2() {
      return this.labInfo2;
   }

   public void setLabInfo2(String var1) {
      this.labInfo2 = var1;
   }

   public String getLabInfo3() {
      return this.labInfo3;
   }

   public void setLabInfo3(String var1) {
      this.labInfo3 = var1;
   }

   public String getLabInfo4() {
      return this.labInfo4;
   }

   public void setLabInfo4(String var1) {
      this.labInfo4 = var1;
   }

   public String getLabInfo5() {
      return this.labInfo5;
   }

   public void setLabInfo5(String var1) {
      this.labInfo5 = var1;
   }

   public String getLabInfo6() {
      return this.labInfo6;
   }

   public void setLabInfo6(String var1) {
      this.labInfo6 = var1;
   }

   public String getLabInfo7() {
      return this.labInfo7;
   }

   public void setLabInfo7(String var1) {
      this.labInfo7 = var1;
   }

   public String getLabInfo8() {
      return this.labInfo8;
   }

   public void setLabInfo8(String var1) {
      this.labInfo8 = var1;
   }

   public String getLabInfo9() {
      return this.labInfo9;
   }

   public void setLabInfo9(String var1) {
      this.labInfo9 = var1;
   }

   public int getLabLieuPrelevement() {
      return this.labLieuPrelevement;
   }

   public void setLabLieuPrelevement(int var1) {
      this.labLieuPrelevement = var1;
   }

   public String getLabMatricule() {
      return this.labMatricule;
   }

   public void setLabMatricule(String var1) {
      this.labMatricule = var1;
   }

   public String getLabMedecin() {
      return this.labMedecin;
   }

   public void setLabMedecin(String var1) {
      this.labMedecin = var1;
   }

   public String getLabModeReg() {
      return this.labModeReg;
   }

   public void setLabModeReg(String var1) {
      this.labModeReg = var1;
   }

   public String getLabModeleImp() {
      return this.labModeleImp;
   }

   public void setLabModeleImp(String var1) {
      this.labModeleImp = var1;
   }

   public int getLabNbJourReg() {
      return this.labNbJourReg;
   }

   public void setLabNbJourReg(int var1) {
      this.labNbJourReg = var1;
   }

   public String getLabNomAssurance() {
      return this.labNomAssurance;
   }

   public void setLabNomAssurance(String var1) {
      this.labNomAssurance = var1;
   }

   public String getLabNomComplemtaire() {
      return this.labNomComplemtaire;
   }

   public void setLabNomComplemtaire(String var1) {
      this.labNomComplemtaire = var1;
   }

   public String getLabNomCreateur() {
      return this.labNomCreateur;
   }

   public void setLabNomCreateur(String var1) {
      this.labNomCreateur = var1;
   }

   public String getLabNomModif() {
      return this.labNomModif;
   }

   public void setLabNomModif(String var1) {
      this.labNomModif = var1;
   }

   public String getLabNomPatient() {
      return this.labNomPatient;
   }

   public void setLabNomPatient(String var1) {
      this.labNomPatient = var1;
   }

   public String getLabNomSociete() {
      return this.labNomSociete;
   }

   public void setLabNomSociete(String var1) {
      this.labNomSociete = var1;
   }

   public String getLabNum() {
      return this.labNum;
   }

   public void setLabNum(String var1) {
      this.labNum = var1;
   }

   public String getLabNumBc() {
      return this.labNumBc;
   }

   public void setLabNumBc(String var1) {
      this.labNumBc = var1;
   }

   public String getLabNumHospit() {
      return this.labNumHospit;
   }

   public void setLabNumHospit(String var1) {
      this.labNumHospit = var1;
   }

   public String getLabNumRum() {
      return this.labNumRum;
   }

   public void setLabNumRum(String var1) {
      this.labNumRum = var1;
   }

   public int getLabPartenaire() {
      return this.labPartenaire;
   }

   public void setLabPartenaire(int var1) {
      this.labPartenaire = var1;
   }

   public String getLabPathologie() {
      return this.labPathologie;
   }

   public void setLabPathologie(String var1) {
      this.labPathologie = var1;
   }

   public int getLabFondCnamgs() {
      return this.labFondCnamgs;
   }

   public void setLabFondCnamgs(int var1) {
      this.labFondCnamgs = var1;
   }

   public long getLabIdEmployeur() {
      return this.labIdEmployeur;
   }

   public void setLabIdEmployeur(long var1) {
      this.labIdEmployeur = var1;
   }

   public float getLabPecCnamgs() {
      return this.labPecCnamgs;
   }

   public void setLabPecCnamgs(float var1) {
      this.labPecCnamgs = var1;
   }

   public String getLabPrescripteur() {
      return this.labPrescripteur;
   }

   public void setLabPrescripteur(String var1) {
      this.labPrescripteur = var1;
   }

   public String getLabProtocole() {
      return this.labProtocole;
   }

   public void setLabProtocole(String var1) {
      this.labProtocole = var1;
   }

   public double getLabRegPatient() {
      return this.labRegPatient;
   }

   public void setLabRegPatient(double var1) {
      this.labRegPatient = var1;
   }

   public double getLabRegTiers() {
      return this.labRegTiers;
   }

   public void setLabRegTiers(double var1) {
      this.labRegTiers = var1;
   }

   public String getLabSerie() {
      return this.labSerie;
   }

   public void setLabSerie(String var1) {
      this.labSerie = var1;
   }

   public String getLabService() {
      return this.labService;
   }

   public void setLabService(String var1) {
      this.labService = var1;
   }

   public int getLabSoldePatient() {
      return this.labSoldePatient;
   }

   public void setLabSoldePatient(int var1) {
      this.labSoldePatient = var1;
   }

   public int getLabSoldeTiers() {
      return this.labSoldeTiers;
   }

   public void setLabSoldeTiers(int var1) {
      this.labSoldeTiers = var1;
   }

   public double getLabTotAssurance() {
      return this.labTotAssurance;
   }

   public void setLabTotAssurance(double var1) {
      this.labTotAssurance = var1;
   }

   public double getLabTotComplmentaire() {
      return this.labTotComplmentaire;
   }

   public void setLabTotComplmentaire(double var1) {
      this.labTotComplmentaire = var1;
   }

   public double getLabTotGeneral() {
      return this.labTotGeneral;
   }

   public void setLabTotGeneral(double var1) {
      this.labTotGeneral = var1;
   }

   public double getLabTotPatient() {
      return this.labTotPatient;
   }

   public void setLabTotPatient(double var1) {
      this.labTotPatient = var1;
   }

   public double getLabTotSociete() {
      return this.labTotSociete;
   }

   public void setLabTotSociete(double var1) {
      this.labTotSociete = var1;
   }

   public double getLabTotTaxeAssurance() {
      return this.labTotTaxeAssurance;
   }

   public void setLabTotTaxeAssurance(double var1) {
      this.labTotTaxeAssurance = var1;
   }

   public double getLabTotTaxeComplementaire() {
      return this.labTotTaxeComplementaire;
   }

   public void setLabTotTaxeComplementaire(double var1) {
      this.labTotTaxeComplementaire = var1;
   }

   public double getLabTotTaxeGeneral() {
      return this.labTotTaxeGeneral;
   }

   public void setLabTotTaxeGeneral(double var1) {
      this.labTotTaxeGeneral = var1;
   }

   public double getLabTotTaxePatient() {
      return this.labTotTaxePatient;
   }

   public void setLabTotTaxePatient(double var1) {
      this.labTotTaxePatient = var1;
   }

   public double getLabTotTaxeSociete() {
      return this.labTotTaxeSociete;
   }

   public void setLabTotTaxeSociete(double var1) {
      this.labTotTaxeSociete = var1;
   }

   public int getLabTypeReg() {
      return this.labTypeReg;
   }

   public void setLabTypeReg(int var1) {
      this.labTypeReg = var1;
   }

   public Patients getPatients() {
      return this.patients;
   }

   public void setPatients(Patients var1) {
      this.patients = var1;
   }

   public String getLabLaboratoire() {
      return this.labLaboratoire;
   }

   public void setLabLaboratoire(String var1) {
      this.labLaboratoire = var1;
   }

   public boolean isLabAnonyme() {
      return this.labAnonyme;
   }

   public void setLabAnonyme(boolean var1) {
      this.labAnonyme = var1;
   }

   public Date getLabDateAnnule() {
      return this.labDateAnnule;
   }

   public void setLabDateAnnule(Date var1) {
      this.labDateAnnule = var1;
   }

   public String getLabMotifAnnule() {
      return this.labMotifAnnule;
   }

   public void setLabMotifAnnule(String var1) {
      this.labMotifAnnule = var1;
   }

   public String getLabNumSecteur() {
      return this.labNumSecteur;
   }

   public void setLabNumSecteur(String var1) {
      this.labNumSecteur = var1;
   }

   public boolean isLabAyantDroit() {
      return this.labAyantDroit;
   }

   public void setLabAyantDroit(boolean var1) {
      this.labAyantDroit = var1;
   }

   public String getLabNomAssurePrincipal() {
      return this.labNomAssurePrincipal;
   }

   public void setLabNomAssurePrincipal(String var1) {
      this.labNomAssurePrincipal = var1;
   }

   public int getLabEtatPaillasse() {
      return this.labEtatPaillasse;
   }

   public void setLabEtatPaillasse(int var1) {
      this.labEtatPaillasse = var1;
   }

   public String getLabCommentaire() {
      return this.labCommentaire;
   }

   public void setLabCommentaire(String var1) {
      this.labCommentaire = var1;
   }

   public String getLabNomResultat() {
      return this.labNomResultat;
   }

   public void setLabNomResultat(String var1) {
      this.labNomResultat = var1;
   }

   public String getLabModeleImpResultat() {
      return this.labModeleImpResultat;
   }

   public void setLabModeleImpResultat(String var1) {
      this.labModeleImpResultat = var1;
   }

   public boolean isLabDiabete() {
      return this.labDiabete;
   }

   public void setLabDiabete(boolean var1) {
      this.labDiabete = var1;
   }

   public boolean isLabGrossesse() {
      return this.labGrossesse;
   }

   public void setLabGrossesse(boolean var1) {
      this.labGrossesse = var1;
   }

   public boolean isLabImmunodepressif() {
      return this.labImmunodepressif;
   }

   public void setLabImmunodepressif(boolean var1) {
      this.labImmunodepressif = var1;
   }

   public String getLabLequel() {
      return this.labLequel;
   }

   public void setLabLequel(String var1) {
      this.labLequel = var1;
   }

   public boolean isLabTraitement() {
      return this.labTraitement;
   }

   public void setLabTraitement(boolean var1) {
      this.labTraitement = var1;
   }

   public int getLabUrgent() {
      return this.labUrgent;
   }

   public void setLabUrgent(int var1) {
      this.labUrgent = var1;
   }

   public String getLabNomEmployeur() {
      return this.labNomEmployeur;
   }

   public void setLabNomEmployeur(String var1) {
      this.labNomEmployeur = var1;
   }

   public String getLabNumPieceTiers() {
      return this.labNumPieceTiers;
   }

   public void setLabNumPieceTiers(String var1) {
      this.labNumPieceTiers = var1;
   }

   public boolean isLabBloqueRefacturation() {
      return this.labBloqueRefacturation;
   }

   public void setLabBloqueRefacturation(boolean var1) {
      this.labBloqueRefacturation = var1;
   }

   public String getLabFeuille() {
      return this.labFeuille;
   }

   public void setLabFeuille(String var1) {
      this.labFeuille = var1;
   }

   public String getLabEntree() {
      return this.labEntree;
   }

   public void setLabEntree(String var1) {
      this.labEntree = var1;
   }

   public double getLabTotRabais() {
      return this.labTotRabais;
   }

   public void setLabTotRabais(double var1) {
      this.labTotRabais = var1;
   }

   public String getLabMotifDecloture() {
      return this.labMotifDecloture;
   }

   public void setLabMotifDecloture(String var1) {
      this.labMotifDecloture = var1;
   }
}
