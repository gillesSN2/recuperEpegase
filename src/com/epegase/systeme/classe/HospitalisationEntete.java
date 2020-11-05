package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class HospitalisationEntete implements Serializable {
   private long hosId;
   private Date hosDateCreat;
   private Date hosDateModif;
   private long hosIdCreateur;
   private String hosNomCreateur;
   private long hosIdModif;
   private String hosNomModif;
   private String hosNum;
   private String hosFeuille;
   private Date hosDateEntree;
   private Date hosDateSortie;
   private int hosNbJour;
   private String hosMotifEntree;
   private String hosProvenance;
   private String hosMotifSortie;
   private String hosDestination;
   private int hosCategorie;
   private String hosSerie;
   private Date hosDateTransfert;
   private Date hosDateAnnule;
   private String hosMotifAnnule;
   private Date hosEcheanceReliquat;
   private String hosNumPieceTiers;
   private int hosEtatVal;
   private int hosCloture;
   private int hosEtat;
   private String hosNumRss;
   private String hosNumRum;
   private String hosService;
   private String hosProtocole;
   private String hosPathologie;
   private String hosPrescripteur;
   private long hosIdMedecin;
   private String hosMedecin;
   private String hosNumBc;
   private long hosIdPatient;
   private String hosCivilite;
   private String hosNomPatient;
   private long hosIdSociete;
   private String hosNomSociete;
   private String hosMatricule;
   private long hosIdAssurance;
   private String hosNomAssurance;
   private String hosContratAssurance;
   private long hosIdComplementaire;
   private String hosNomComplemtaire;
   private String hosContratComplementaire;
   private long hosIdEmployeur;
   private String hosNomEmployeur;
   private float hosPecCnamgs;
   private int hosFondCnamgs;
   private long hosFam;
   private long hosComplementaire;
   private double hosTotPatient;
   private double hosTotSociete;
   private double hosTotAssurance;
   private double hosTotComplmentaire;
   private double hosTotTaxePatient;
   private double hosTotTaxeSociete;
   private double hosTotTaxeAssurance;
   private double hosTotTaxeComplementaire;
   private double hosTotGeneral;
   private double hosTotRabais;
   private double hosTotTaxeGeneral;
   private double hosRegPatient;
   private double hosTotCaution;
   private int hosSoldePatient;
   private double hosRegTiers;
   private int hosSoldeTiers;
   private String hosBanque;
   private int hosTypeReg;
   private String hosModeReg;
   private int hosNbJourReg;
   private int hosArrondiReg;
   private Date hosDateEcheReg;
   private String hosActivite;
   private String hosInfo1;
   private String hosInfo2;
   private String hosInfo3;
   private String hosInfo4;
   private String hosInfo5;
   private String hosInfo6;
   private String hosInfo7;
   private String hosInfo8;
   private String hosInfo9;
   private String hosInfo10;
   private Date hosDateImp;
   private String hosModeleImp;
   private String hosNomAssurePrincipal;
   private boolean hosAyantDroit;
   private boolean hosBloqueRefacturation;
   private boolean hosCaution;
   private ExercicesVentes exerciceventes;
   private Patients patients;
   private String libelleEta;
   private String var_solde;
   private boolean var_select_ligne;
   private double var_reliquat;
   private double totalTiers;
   private double totalPatient;
   private String libelleProvenance;
   private String libelleDestination;
   private String libelleMotifEntree;
   private String libelleMotifSortie;
   private String libelleCategorie;
   private String libelleFamille;

   public String getLibelleMotifEntree() {
      if (this.hosMotifEntree != null && !this.hosMotifEntree.isEmpty()) {
         if (this.hosMotifEntree.equals("0")) {
            this.libelleMotifEntree = "Trf. autre service";
         } else if (this.hosMotifEntree.equals("6")) {
            this.libelleMotifEntree = "Mutation";
         } else if (this.hosMotifEntree.equals("7")) {
            this.libelleMotifEntree = "Trf. normal";
         } else if (this.hosMotifEntree.equals("8")) {
            this.libelleMotifEntree = "Domicile";
         } else {
            this.libelleMotifEntree = "";
         }
      } else {
         this.libelleMotifEntree = "";
      }

      return this.libelleMotifEntree;
   }

   public void setLibelleMotifEntree(String var1) {
      this.libelleMotifEntree = var1;
   }

   public String getLibelleMotifSortie() {
      if (this.hosMotifSortie != null && !this.hosMotifSortie.isEmpty()) {
         if (this.hosMotifSortie.equals("0")) {
            this.libelleMotifSortie = "Trf. autre service";
         } else if (this.hosMotifSortie.equals("6")) {
            this.libelleMotifSortie = "Mutation";
         } else if (this.hosMotifSortie.equals("7")) {
            this.libelleMotifSortie = "Trf. normal";
         } else if (this.hosMotifSortie.equals("8")) {
            this.libelleMotifSortie = "Domicile";
         } else if (this.hosMotifSortie.equals("9")) {
            this.libelleMotifSortie = "Dècés";
         } else {
            this.libelleMotifSortie = "";
         }
      } else {
         this.libelleMotifSortie = "";
      }

      return this.libelleMotifSortie;
   }

   public void setLibelleMotifSortie(String var1) {
      this.libelleMotifSortie = var1;
   }

   public String getLibelleFamille() {
      if (this.hosFam == 0L) {
         this.libelleFamille = "Non Assuré";
      } else if (this.hosFam == -1L) {
         this.libelleFamille = "Cas Social";
      } else if (this.hosFam == -2L) {
         this.libelleFamille = "Etat";
      } else {
         this.libelleFamille = "Assuré";
      }

      return this.libelleFamille;
   }

   public void setLibelleFamille(String var1) {
      this.libelleFamille = var1;
   }

   public String getLibelleCategorie() {
      if (this.hosCategorie == 0) {
         this.libelleCategorie = "N.S.";
      } else if (this.hosCategorie == 1) {
         this.libelleCategorie = "Acc. Domestique";
      } else if (this.hosCategorie == 2) {
         this.libelleCategorie = "Acc. Routier";
      } else if (this.hosCategorie == 3) {
         this.libelleCategorie = "Acc. Travail";
      } else if (this.hosCategorie == 4) {
         this.libelleCategorie = "Maladie";
      } else if (this.hosCategorie == 5) {
         this.libelleCategorie = "Autre";
      } else {
         this.libelleCategorie = "???";
      }

      return this.libelleCategorie;
   }

   public void setLibelleCategorie(String var1) {
      this.libelleCategorie = var1;
   }

   public String getLibelleDestination() {
      return this.libelleDestination;
   }

   public void setLibelleDestination(String var1) {
      this.libelleDestination = var1;
   }

   public String getLibelleProvenance() {
      return this.libelleProvenance;
   }

   public void setLibelleProvenance(String var1) {
      this.libelleProvenance = var1;
   }

   public double getTotalTiers() {
      this.totalTiers = this.hosTotSociete + this.hosTotAssurance + this.hosTotComplmentaire + this.hosTotTaxeSociete + this.hosTotTaxeAssurance + this.hosTotTaxeComplementaire;
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public double getTotalPatient() {
      this.totalPatient = this.hosTotPatient + this.hosTotTaxePatient;
      return this.totalPatient;
   }

   public void setTotalPatient(double var1) {
      this.totalPatient = var1;
   }

   public String getLibelleEta() {
      if (this.hosEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.hosEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.hosEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.hosEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.hosEtat == 4) {
         this.libelleEta = "Clot.";
      } else if (this.hosEtat == 5) {
         this.libelleEta = "Ctrl.";
      } else if (this.hosEtat == 6) {
         this.libelleEta = "Refact.Std";
      } else if (this.hosEtat == 7) {
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
      if (this.hosSoldePatient == 1) {
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
      this.var_reliquat = this.hosTotPatient + this.hosTotTaxePatient - this.hosRegPatient;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public String getHosActivite() {
      return this.hosActivite;
   }

   public void setHosActivite(String var1) {
      this.hosActivite = var1;
   }

   public int getHosArrondiReg() {
      return this.hosArrondiReg;
   }

   public void setHosArrondiReg(int var1) {
      this.hosArrondiReg = var1;
   }

   public String getHosBanque() {
      return this.hosBanque;
   }

   public void setHosBanque(String var1) {
      this.hosBanque = var1;
   }

   public String getHosCivilite() {
      return this.hosCivilite;
   }

   public void setHosCivilite(String var1) {
      this.hosCivilite = var1;
   }

   public int getHosCloture() {
      return this.hosCloture;
   }

   public void setHosCloture(int var1) {
      this.hosCloture = var1;
   }

   public String getHosContratAssurance() {
      return this.hosContratAssurance;
   }

   public void setHosContratAssurance(String var1) {
      this.hosContratAssurance = var1;
   }

   public String getHosContratComplementaire() {
      return this.hosContratComplementaire;
   }

   public void setHosContratComplementaire(String var1) {
      this.hosContratComplementaire = var1;
   }

   public Date getHosDateCreat() {
      return this.hosDateCreat;
   }

   public void setHosDateCreat(Date var1) {
      this.hosDateCreat = var1;
   }

   public Date getHosDateEcheReg() {
      return this.hosDateEcheReg;
   }

   public void setHosDateEcheReg(Date var1) {
      this.hosDateEcheReg = var1;
   }

   public Date getHosDateImp() {
      return this.hosDateImp;
   }

   public void setHosDateImp(Date var1) {
      this.hosDateImp = var1;
   }

   public Date getHosDateModif() {
      return this.hosDateModif;
   }

   public void setHosDateModif(Date var1) {
      this.hosDateModif = var1;
   }

   public Date getHosEcheanceReliquat() {
      return this.hosEcheanceReliquat;
   }

   public void setHosEcheanceReliquat(Date var1) {
      this.hosEcheanceReliquat = var1;
   }

   public int getHosEtat() {
      return this.hosEtat;
   }

   public void setHosEtat(int var1) {
      this.hosEtat = var1;
   }

   public int getHosEtatVal() {
      return this.hosEtatVal;
   }

   public void setHosEtatVal(int var1) {
      this.hosEtatVal = var1;
   }

   public long getHosComplementaire() {
      return this.hosComplementaire;
   }

   public void setHosComplementaire(long var1) {
      this.hosComplementaire = var1;
   }

   public long getHosFam() {
      return this.hosFam;
   }

   public void setHosFam(long var1) {
      this.hosFam = var1;
   }

   public long getHosId() {
      return this.hosId;
   }

   public void setHosId(long var1) {
      this.hosId = var1;
   }

   public long getHosIdAssurance() {
      return this.hosIdAssurance;
   }

   public void setHosIdAssurance(long var1) {
      this.hosIdAssurance = var1;
   }

   public long getHosIdComplementaire() {
      return this.hosIdComplementaire;
   }

   public void setHosIdComplementaire(long var1) {
      this.hosIdComplementaire = var1;
   }

   public long getHosIdCreateur() {
      return this.hosIdCreateur;
   }

   public void setHosIdCreateur(long var1) {
      this.hosIdCreateur = var1;
   }

   public long getHosIdMedecin() {
      return this.hosIdMedecin;
   }

   public void setHosIdMedecin(long var1) {
      this.hosIdMedecin = var1;
   }

   public long getHosIdModif() {
      return this.hosIdModif;
   }

   public void setHosIdModif(long var1) {
      this.hosIdModif = var1;
   }

   public long getHosIdPatient() {
      return this.hosIdPatient;
   }

   public void setHosIdPatient(long var1) {
      this.hosIdPatient = var1;
   }

   public long getHosIdSociete() {
      return this.hosIdSociete;
   }

   public void setHosIdSociete(long var1) {
      this.hosIdSociete = var1;
   }

   public String getHosInfo1() {
      return this.hosInfo1;
   }

   public void setHosInfo1(String var1) {
      this.hosInfo1 = var1;
   }

   public String getHosInfo10() {
      return this.hosInfo10;
   }

   public void setHosInfo10(String var1) {
      this.hosInfo10 = var1;
   }

   public String getHosInfo2() {
      return this.hosInfo2;
   }

   public void setHosInfo2(String var1) {
      this.hosInfo2 = var1;
   }

   public String getHosInfo3() {
      return this.hosInfo3;
   }

   public void setHosInfo3(String var1) {
      this.hosInfo3 = var1;
   }

   public String getHosInfo4() {
      return this.hosInfo4;
   }

   public void setHosInfo4(String var1) {
      this.hosInfo4 = var1;
   }

   public String getHosInfo5() {
      return this.hosInfo5;
   }

   public void setHosInfo5(String var1) {
      this.hosInfo5 = var1;
   }

   public String getHosInfo6() {
      return this.hosInfo6;
   }

   public void setHosInfo6(String var1) {
      this.hosInfo6 = var1;
   }

   public String getHosInfo7() {
      return this.hosInfo7;
   }

   public void setHosInfo7(String var1) {
      this.hosInfo7 = var1;
   }

   public String getHosInfo8() {
      return this.hosInfo8;
   }

   public void setHosInfo8(String var1) {
      this.hosInfo8 = var1;
   }

   public String getHosInfo9() {
      return this.hosInfo9;
   }

   public void setHosInfo9(String var1) {
      this.hosInfo9 = var1;
   }

   public String getHosMatricule() {
      return this.hosMatricule;
   }

   public void setHosMatricule(String var1) {
      this.hosMatricule = var1;
   }

   public String getHosMedecin() {
      return this.hosMedecin;
   }

   public void setHosMedecin(String var1) {
      this.hosMedecin = var1;
   }

   public String getHosModeReg() {
      return this.hosModeReg;
   }

   public void setHosModeReg(String var1) {
      this.hosModeReg = var1;
   }

   public String getHosModeleImp() {
      return this.hosModeleImp;
   }

   public void setHosModeleImp(String var1) {
      this.hosModeleImp = var1;
   }

   public int getHosNbJourReg() {
      return this.hosNbJourReg;
   }

   public void setHosNbJourReg(int var1) {
      this.hosNbJourReg = var1;
   }

   public String getHosNomAssurance() {
      return this.hosNomAssurance;
   }

   public void setHosNomAssurance(String var1) {
      this.hosNomAssurance = var1;
   }

   public String getHosNomComplemtaire() {
      return this.hosNomComplemtaire;
   }

   public void setHosNomComplemtaire(String var1) {
      this.hosNomComplemtaire = var1;
   }

   public String getHosNomCreateur() {
      return this.hosNomCreateur;
   }

   public void setHosNomCreateur(String var1) {
      this.hosNomCreateur = var1;
   }

   public String getHosNomModif() {
      return this.hosNomModif;
   }

   public void setHosNomModif(String var1) {
      this.hosNomModif = var1;
   }

   public String getHosNomPatient() {
      return this.hosNomPatient;
   }

   public void setHosNomPatient(String var1) {
      this.hosNomPatient = var1;
   }

   public String getHosNomSociete() {
      return this.hosNomSociete;
   }

   public void setHosNomSociete(String var1) {
      this.hosNomSociete = var1;
   }

   public String getHosNum() {
      return this.hosNum;
   }

   public void setHosNum(String var1) {
      this.hosNum = var1;
   }

   public String getHosNumBc() {
      return this.hosNumBc;
   }

   public void setHosNumBc(String var1) {
      this.hosNumBc = var1;
   }

   public String getHosNumRss() {
      return this.hosNumRss;
   }

   public void setHosNumRss(String var1) {
      this.hosNumRss = var1;
   }

   public String getHosNumRum() {
      return this.hosNumRum;
   }

   public void setHosNumRum(String var1) {
      this.hosNumRum = var1;
   }

   public String getHosPathologie() {
      return this.hosPathologie;
   }

   public void setHosPathologie(String var1) {
      this.hosPathologie = var1;
   }

   public int getHosFondCnamgs() {
      return this.hosFondCnamgs;
   }

   public void setHosFondCnamgs(int var1) {
      this.hosFondCnamgs = var1;
   }

   public long getHosIdEmployeur() {
      return this.hosIdEmployeur;
   }

   public void setHosIdEmployeur(long var1) {
      this.hosIdEmployeur = var1;
   }

   public float getHosPecCnamgs() {
      return this.hosPecCnamgs;
   }

   public void setHosPecCnamgs(float var1) {
      this.hosPecCnamgs = var1;
   }

   public String getHosPrescripteur() {
      return this.hosPrescripteur;
   }

   public void setHosPrescripteur(String var1) {
      this.hosPrescripteur = var1;
   }

   public String getHosProtocole() {
      return this.hosProtocole;
   }

   public void setHosProtocole(String var1) {
      this.hosProtocole = var1;
   }

   public double getHosRegPatient() {
      return this.hosRegPatient;
   }

   public void setHosRegPatient(double var1) {
      this.hosRegPatient = var1;
   }

   public double getHosRegTiers() {
      return this.hosRegTiers;
   }

   public void setHosRegTiers(double var1) {
      this.hosRegTiers = var1;
   }

   public String getHosSerie() {
      return this.hosSerie;
   }

   public void setHosSerie(String var1) {
      this.hosSerie = var1;
   }

   public String getHosService() {
      return this.hosService;
   }

   public void setHosService(String var1) {
      this.hosService = var1;
   }

   public int getHosSoldePatient() {
      return this.hosSoldePatient;
   }

   public void setHosSoldePatient(int var1) {
      this.hosSoldePatient = var1;
   }

   public int getHosSoldeTiers() {
      return this.hosSoldeTiers;
   }

   public void setHosSoldeTiers(int var1) {
      this.hosSoldeTiers = var1;
   }

   public double getHosTotAssurance() {
      return this.hosTotAssurance;
   }

   public void setHosTotAssurance(double var1) {
      this.hosTotAssurance = var1;
   }

   public double getHosTotComplmentaire() {
      return this.hosTotComplmentaire;
   }

   public void setHosTotComplmentaire(double var1) {
      this.hosTotComplmentaire = var1;
   }

   public double getHosTotGeneral() {
      return this.hosTotGeneral;
   }

   public void setHosTotGeneral(double var1) {
      this.hosTotGeneral = var1;
   }

   public double getHosTotPatient() {
      return this.hosTotPatient;
   }

   public void setHosTotPatient(double var1) {
      this.hosTotPatient = var1;
   }

   public double getHosTotSociete() {
      return this.hosTotSociete;
   }

   public void setHosTotSociete(double var1) {
      this.hosTotSociete = var1;
   }

   public double getHosTotTaxeAssurance() {
      return this.hosTotTaxeAssurance;
   }

   public void setHosTotTaxeAssurance(double var1) {
      this.hosTotTaxeAssurance = var1;
   }

   public double getHosTotTaxeComplementaire() {
      return this.hosTotTaxeComplementaire;
   }

   public void setHosTotTaxeComplementaire(double var1) {
      this.hosTotTaxeComplementaire = var1;
   }

   public double getHosTotTaxeGeneral() {
      return this.hosTotTaxeGeneral;
   }

   public void setHosTotTaxeGeneral(double var1) {
      this.hosTotTaxeGeneral = var1;
   }

   public double getHosTotTaxePatient() {
      return this.hosTotTaxePatient;
   }

   public void setHosTotTaxePatient(double var1) {
      this.hosTotTaxePatient = var1;
   }

   public double getHosTotTaxeSociete() {
      return this.hosTotTaxeSociete;
   }

   public void setHosTotTaxeSociete(double var1) {
      this.hosTotTaxeSociete = var1;
   }

   public int getHosTypeReg() {
      return this.hosTypeReg;
   }

   public void setHosTypeReg(int var1) {
      this.hosTypeReg = var1;
   }

   public Patients getPatients() {
      return this.patients;
   }

   public void setPatients(Patients var1) {
      this.patients = var1;
   }

   public Date getHosDateEntree() {
      return this.hosDateEntree;
   }

   public void setHosDateEntree(Date var1) {
      this.hosDateEntree = var1;
   }

   public Date getHosDateSortie() {
      return this.hosDateSortie;
   }

   public void setHosDateSortie(Date var1) {
      this.hosDateSortie = var1;
   }

   public String getHosMotifEntree() {
      return this.hosMotifEntree;
   }

   public void setHosMotifEntree(String var1) {
      this.hosMotifEntree = var1;
   }

   public String getHosMotifSortie() {
      return this.hosMotifSortie;
   }

   public void setHosMotifSortie(String var1) {
      this.hosMotifSortie = var1;
   }

   public int getHosNbJour() {
      return this.hosNbJour;
   }

   public void setHosNbJour(int var1) {
      this.hosNbJour = var1;
   }

   public Date getHosDateTransfert() {
      return this.hosDateTransfert;
   }

   public void setHosDateTransfert(Date var1) {
      this.hosDateTransfert = var1;
   }

   public int getHosCategorie() {
      return this.hosCategorie;
   }

   public void setHosCategorie(int var1) {
      this.hosCategorie = var1;
   }

   public Date getHosDateAnnule() {
      return this.hosDateAnnule;
   }

   public void setHosDateAnnule(Date var1) {
      this.hosDateAnnule = var1;
   }

   public String getHosMotifAnnule() {
      return this.hosMotifAnnule;
   }

   public void setHosMotifAnnule(String var1) {
      this.hosMotifAnnule = var1;
   }

   public boolean isHosAyantDroit() {
      return this.hosAyantDroit;
   }

   public void setHosAyantDroit(boolean var1) {
      this.hosAyantDroit = var1;
   }

   public String getHosNomAssurePrincipal() {
      return this.hosNomAssurePrincipal;
   }

   public void setHosNomAssurePrincipal(String var1) {
      this.hosNomAssurePrincipal = var1;
   }

   public String getHosNomEmployeur() {
      return this.hosNomEmployeur;
   }

   public void setHosNomEmployeur(String var1) {
      this.hosNomEmployeur = var1;
   }

   public String getHosNumPieceTiers() {
      return this.hosNumPieceTiers;
   }

   public void setHosNumPieceTiers(String var1) {
      this.hosNumPieceTiers = var1;
   }

   public boolean isHosBloqueRefacturation() {
      return this.hosBloqueRefacturation;
   }

   public void setHosBloqueRefacturation(boolean var1) {
      this.hosBloqueRefacturation = var1;
   }

   public double getHosTotCaution() {
      return this.hosTotCaution;
   }

   public void setHosTotCaution(double var1) {
      this.hosTotCaution = var1;
   }

   public String getHosDestination() {
      return this.hosDestination;
   }

   public void setHosDestination(String var1) {
      this.hosDestination = var1;
   }

   public String getHosProvenance() {
      return this.hosProvenance;
   }

   public void setHosProvenance(String var1) {
      this.hosProvenance = var1;
   }

   public boolean isHosCaution() {
      return this.hosCaution;
   }

   public void setHosCaution(boolean var1) {
      this.hosCaution = var1;
   }

   public String getHosFeuille() {
      return this.hosFeuille;
   }

   public void setHosFeuille(String var1) {
      this.hosFeuille = var1;
   }

   public double getHosTotRabais() {
      return this.hosTotRabais;
   }

   public void setHosTotRabais(double var1) {
      this.hosTotRabais = var1;
   }
}
