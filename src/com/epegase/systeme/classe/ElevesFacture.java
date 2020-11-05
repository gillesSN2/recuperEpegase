package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ElevesFacture implements Serializable {
   private long elefacId;
   private Date elefacDateCreat;
   private long elefacIdCreateur;
   private Date elefacDateModif;
   private long elefacIdModif;
   private String elefacAnnee;
   private String elefacSerie;
   private int elefacType;
   private String elefacNum;
   private Date elefacDate;
   private double elefacTarifDossier;
   private double elefacTarifInscription;
   private double elefacTarifReinscription;
   private double elefacTarifScolarite;
   private int elefacModeScolarite;
   private double elefacTarifCantine;
   private double elefacTarifTransport;
   private double elefacTarifTenue;
   private double elefacTarifDivers;
   private double elefacTarifExamens;
   private double elefacTarifAssociation;
   private double elefacTarifAssurance;
   private int elefacSolde;
   private double elefacTotal;
   private double elefacReglement;
   private int elefacEtatVal;
   private int elefacEtat;
   private Date elefacDateValidite;
   private Date elefacDateValide;
   private String elefacSite;
   private String elefacDepartement;
   private String elefacService;
   private String elefacRegion;
   private String elefacSecteur;
   private String elefacPdv;
   private String elefacCaisse;
   private String elefacNomResponsable;
   private long elefacIdResponsable;
   private String elefacNomCommercial;
   private long elefacIdCommercial;
   private Date elefacDateEche01;
   private Date elefacDateEche02;
   private Date elefacDateEche03;
   private Date elefacDateEche04;
   private Date elefacDateEche05;
   private Date elefacDateEche06;
   private Date elefacDateEche07;
   private Date elefacDateEche08;
   private Date elefacDateEche09;
   private Date elefacDateEche10;
   private Date elefacDateEche11;
   private Date elefacDateEche12;
   private double elefacScolarite01;
   private double elefacScolarite02;
   private double elefacScolarite03;
   private double elefacScolarite04;
   private double elefacScolarite05;
   private double elefacScolarite06;
   private double elefacScolarite07;
   private double elefacScolarite08;
   private double elefacScolarite09;
   private double elefacScolarite10;
   private double elefacScolarite11;
   private double elefacScolarite12;
   private double elefacCantine01;
   private double elefacCantine02;
   private double elefacCantine03;
   private double elefacCantine04;
   private double elefacCantine05;
   private double elefacCantine06;
   private double elefacCantine07;
   private double elefacCantine08;
   private double elefacCantine09;
   private double elefacCantine10;
   private double elefacCantine11;
   private double elefacCantine12;
   private double elefacTransport01;
   private double elefacTransport02;
   private double elefacTransport03;
   private double elefacTransport04;
   private double elefacTransport05;
   private double elefacTransport06;
   private double elefacTransport07;
   private double elefacTransport08;
   private double elefacTransport09;
   private double elefacTransport10;
   private double elefacTransport11;
   private double elefacTransport12;
   private String elefacCodeTaxe;
   private float elefacTauxTaxe;
   private double elefacTotalTaxe;
   private float elefacTauxTc;
   private double elefacTotalTc;
   private double elefacTotalTimbre;
   private Date elefacDateLastReg;
   private int elefacTypeReg;
   private Eleves eleves;
   private ElevesInscription elevesInscription;
   private ExercicesVentes exercicesVentes;
   private String libelleEtat;
   private String libelleMode;
   private String libelleType;
   private double solde;
   private double total;
   private double var_reliquat;
   private boolean var_select_ligne;
   private double var_fac_timbre;
   private double montantReglementManuel;
   private double totalTtc;

   public Eleves getEleves() {
      return this.eleves;
   }

   public void setEleves(Eleves var1) {
      this.eleves = var1;
   }

   public double getMontantReglementManuel() {
      return this.montantReglementManuel;
   }

   public void setMontantReglementManuel(double var1) {
      this.montantReglementManuel = var1;
   }

   public double getTotalTtc() {
      this.totalTtc = this.elefacTarifAssociation + this.elefacTarifDossier + this.elefacTarifExamens + this.elefacTarifInscription + this.elefacTarifReinscription + this.elefacTarifCantine + this.elefacTarifScolarite + this.elefacTarifTenue + this.elefacTarifDivers + this.elefacTarifTransport + this.elefacTarifAssurance + this.elefacTotalTaxe + this.elefacTotalTc;
      return this.totalTtc;
   }

   public void setTotalTtc(double var1) {
      this.totalTtc = var1;
   }

   public double getVar_fac_timbre() {
      return this.var_fac_timbre;
   }

   public void setVar_fac_timbre(double var1) {
      this.var_fac_timbre = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.elefacTotal - this.elefacReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public ElevesInscription getElevesInscription() {
      return this.elevesInscription;
   }

   public void setElevesInscription(ElevesInscription var1) {
      this.elevesInscription = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public double getTotal() {
      this.total = this.elefacTarifAssociation + this.elefacTarifDossier + this.elefacTarifExamens + this.elefacTarifInscription + this.elefacTarifReinscription + this.elefacTarifCantine + this.elefacTarifScolarite + this.elefacTarifTenue + this.elefacTarifDivers + this.elefacTarifTransport + this.elefacTarifAssurance;
      return this.total;
   }

   public void setTotal(double var1) {
      this.total = var1;
   }

   public double getSolde() {
      this.solde = this.total - this.elefacReglement;
      return this.solde;
   }

   public void setSolde(double var1) {
      this.solde = var1;
   }

   public String getLibelleEtat() {
      if (this.elefacEtat == 0) {
         this.libelleEtat = "E.C.";
      } else if (this.elefacEtat == 1) {
         this.libelleEtat = "Val.";
      } else if (this.elefacEtat == 2) {
         this.libelleEtat = "Gel.";
      } else if (this.elefacEtat == 3) {
         this.libelleEtat = "Annul.";
      } else if (this.elefacEtat == 4) {
         this.libelleEtat = "Trf.P.";
      } else if (this.elefacEtat == 5) {
         this.libelleEtat = "Trf.T.";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public String getLibelleMode() {
      if (this.elefacModeScolarite == 0) {
         this.libelleMode = "Mensuel";
      } else if (this.elefacModeScolarite == 1) {
         this.libelleMode = "Trimestriel";
      } else if (this.elefacModeScolarite == 2) {
         this.libelleMode = "Semestriel";
      } else if (this.elefacModeScolarite == 3) {
         this.libelleMode = "Annuel";
      } else if (this.elefacModeScolarite == 4) {
         this.libelleMode = "";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public String getLibelleType() {
      this.libelleType = "";
      if (this.elefacType == 0) {
         this.libelleType = "Divers";
      } else if (this.elefacType == 1) {
         if (this.elefacTarifDossier != 0.0D) {
            this.libelleType = "Dossier";
         }

         if (this.elefacTarifInscription != 0.0D) {
            if (this.libelleType != null && !this.libelleType.isEmpty()) {
               this.libelleType = this.libelleType + ", Inscription";
            } else {
               this.libelleType = "Inscription";
            }
         }

         if (this.elefacTarifReinscription != 0.0D) {
            if (this.libelleType != null && !this.libelleType.isEmpty()) {
               this.libelleType = this.libelleType + ", Ré-inscription";
            } else {
               this.libelleType = "Ré-inscription";
            }
         }

         if (this.elefacTarifAssociation != 0.0D) {
            if (this.libelleType != null && !this.libelleType.isEmpty()) {
               this.libelleType = this.libelleType + ", Association";
            } else {
               this.libelleType = "Association";
            }
         }

         if (this.elefacTarifTenue != 0.0D) {
            if (this.libelleType != null && !this.libelleType.isEmpty()) {
               this.libelleType = this.libelleType + ", Tenue";
            } else {
               this.libelleType = "Tenue";
            }
         }
      } else if (this.elefacType == 2) {
         if (this.elefacTarifScolarite != 0.0D) {
            if (this.libelleType != null && !this.libelleType.isEmpty()) {
               this.libelleType = this.libelleType + ", Scolarité";
            } else {
               this.libelleType = "Scolarité";
            }
         }

         if (this.elefacTarifTransport != 0.0D) {
            if (this.libelleType != null && !this.libelleType.isEmpty()) {
               this.libelleType = this.libelleType + ", Transport";
            } else {
               this.libelleType = "Transport";
            }
         }

         if (this.elefacTarifCantine != 0.0D) {
            if (this.libelleType != null && !this.libelleType.isEmpty()) {
               this.libelleType = this.libelleType + ", Cantine";
            } else {
               this.libelleType = "Cantine";
            }
         }
      } else if (this.elefacType == 3) {
         if (this.elefacTarifExamens != 0.0D) {
            if (this.libelleType != null && !this.libelleType.isEmpty()) {
               this.libelleType = this.libelleType + ", Examen";
            } else {
               this.libelleType = "Examen";
            }
         }
      } else if (this.elefacType == 4) {
         if (this.elefacTarifDivers != 0.0D) {
            if (this.libelleType != null && !this.libelleType.isEmpty()) {
               this.libelleType = this.libelleType + ", Divers";
            } else {
               this.libelleType = "Divers";
            }
         }
      } else if (this.elefacType == 5 && this.elefacTarifAssurance != 0.0D) {
         if (this.libelleType != null && !this.libelleType.isEmpty()) {
            this.libelleType = this.libelleType + ", Assurance";
         } else {
            this.libelleType = "Assurance";
         }
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public String getElefacAnnee() {
      return this.elefacAnnee;
   }

   public void setElefacAnnee(String var1) {
      this.elefacAnnee = var1;
   }

   public Date getElefacDate() {
      return this.elefacDate;
   }

   public void setElefacDate(Date var1) {
      this.elefacDate = var1;
   }

   public Date getElefacDateCreat() {
      return this.elefacDateCreat;
   }

   public void setElefacDateCreat(Date var1) {
      this.elefacDateCreat = var1;
   }

   public Date getElefacDateModif() {
      return this.elefacDateModif;
   }

   public void setElefacDateModif(Date var1) {
      this.elefacDateModif = var1;
   }

   public Date getElefacDateValide() {
      return this.elefacDateValide;
   }

   public void setElefacDateValide(Date var1) {
      this.elefacDateValide = var1;
   }

   public Date getElefacDateValidite() {
      return this.elefacDateValidite;
   }

   public void setElefacDateValidite(Date var1) {
      this.elefacDateValidite = var1;
   }

   public int getElefacEtat() {
      return this.elefacEtat;
   }

   public void setElefacEtat(int var1) {
      this.elefacEtat = var1;
   }

   public int getElefacEtatVal() {
      return this.elefacEtatVal;
   }

   public void setElefacEtatVal(int var1) {
      this.elefacEtatVal = var1;
   }

   public long getElefacId() {
      return this.elefacId;
   }

   public void setElefacId(long var1) {
      this.elefacId = var1;
   }

   public long getElefacIdCreateur() {
      return this.elefacIdCreateur;
   }

   public void setElefacIdCreateur(long var1) {
      this.elefacIdCreateur = var1;
   }

   public long getElefacIdModif() {
      return this.elefacIdModif;
   }

   public void setElefacIdModif(long var1) {
      this.elefacIdModif = var1;
   }

   public int getElefacModeScolarite() {
      return this.elefacModeScolarite;
   }

   public void setElefacModeScolarite(int var1) {
      this.elefacModeScolarite = var1;
   }

   public String getElefacNum() {
      return this.elefacNum;
   }

   public void setElefacNum(String var1) {
      this.elefacNum = var1;
   }

   public double getElefacTarifAssociation() {
      return this.elefacTarifAssociation;
   }

   public void setElefacTarifAssociation(double var1) {
      this.elefacTarifAssociation = var1;
   }

   public double getElefacTarifCantine() {
      return this.elefacTarifCantine;
   }

   public void setElefacTarifCantine(double var1) {
      this.elefacTarifCantine = var1;
   }

   public double getElefacTarifDivers() {
      return this.elefacTarifDivers;
   }

   public void setElefacTarifDivers(double var1) {
      this.elefacTarifDivers = var1;
   }

   public double getElefacTarifDossier() {
      return this.elefacTarifDossier;
   }

   public void setElefacTarifDossier(double var1) {
      this.elefacTarifDossier = var1;
   }

   public double getElefacTarifExamens() {
      return this.elefacTarifExamens;
   }

   public void setElefacTarifExamens(double var1) {
      this.elefacTarifExamens = var1;
   }

   public double getElefacTarifInscription() {
      return this.elefacTarifInscription;
   }

   public void setElefacTarifInscription(double var1) {
      this.elefacTarifInscription = var1;
   }

   public double getElefacTarifReinscription() {
      return this.elefacTarifReinscription;
   }

   public void setElefacTarifReinscription(double var1) {
      this.elefacTarifReinscription = var1;
   }

   public double getElefacTarifScolarite() {
      return this.elefacTarifScolarite;
   }

   public void setElefacTarifScolarite(double var1) {
      this.elefacTarifScolarite = var1;
   }

   public double getElefacTarifTenue() {
      return this.elefacTarifTenue;
   }

   public void setElefacTarifTenue(double var1) {
      this.elefacTarifTenue = var1;
   }

   public Date getElefacDateEche01() {
      return this.elefacDateEche01;
   }

   public void setElefacDateEche01(Date var1) {
      this.elefacDateEche01 = var1;
   }

   public Date getElefacDateEche02() {
      return this.elefacDateEche02;
   }

   public void setElefacDateEche02(Date var1) {
      this.elefacDateEche02 = var1;
   }

   public Date getElefacDateEche03() {
      return this.elefacDateEche03;
   }

   public void setElefacDateEche03(Date var1) {
      this.elefacDateEche03 = var1;
   }

   public Date getElefacDateEche04() {
      return this.elefacDateEche04;
   }

   public void setElefacDateEche04(Date var1) {
      this.elefacDateEche04 = var1;
   }

   public Date getElefacDateEche05() {
      return this.elefacDateEche05;
   }

   public void setElefacDateEche05(Date var1) {
      this.elefacDateEche05 = var1;
   }

   public Date getElefacDateEche06() {
      return this.elefacDateEche06;
   }

   public void setElefacDateEche06(Date var1) {
      this.elefacDateEche06 = var1;
   }

   public Date getElefacDateEche07() {
      return this.elefacDateEche07;
   }

   public void setElefacDateEche07(Date var1) {
      this.elefacDateEche07 = var1;
   }

   public Date getElefacDateEche08() {
      return this.elefacDateEche08;
   }

   public void setElefacDateEche08(Date var1) {
      this.elefacDateEche08 = var1;
   }

   public Date getElefacDateEche09() {
      return this.elefacDateEche09;
   }

   public void setElefacDateEche09(Date var1) {
      this.elefacDateEche09 = var1;
   }

   public Date getElefacDateEche10() {
      return this.elefacDateEche10;
   }

   public void setElefacDateEche10(Date var1) {
      this.elefacDateEche10 = var1;
   }

   public Date getElefacDateEche11() {
      return this.elefacDateEche11;
   }

   public void setElefacDateEche11(Date var1) {
      this.elefacDateEche11 = var1;
   }

   public Date getElefacDateEche12() {
      return this.elefacDateEche12;
   }

   public void setElefacDateEche12(Date var1) {
      this.elefacDateEche12 = var1;
   }

   public double getElefacTarifTransport() {
      return this.elefacTarifTransport;
   }

   public void setElefacTarifTransport(double var1) {
      this.elefacTarifTransport = var1;
   }

   public int getElefacType() {
      return this.elefacType;
   }

   public void setElefacType(int var1) {
      this.elefacType = var1;
   }

   public double getElefacReglement() {
      return this.elefacReglement;
   }

   public void setElefacReglement(double var1) {
      this.elefacReglement = var1;
   }

   public double getElefacTotal() {
      return this.elefacTotal;
   }

   public void setElefacTotal(double var1) {
      this.elefacTotal = var1;
   }

   public double getElefacCantine01() {
      return this.elefacCantine01;
   }

   public void setElefacCantine01(double var1) {
      this.elefacCantine01 = var1;
   }

   public double getElefacCantine02() {
      return this.elefacCantine02;
   }

   public void setElefacCantine02(double var1) {
      this.elefacCantine02 = var1;
   }

   public double getElefacCantine03() {
      return this.elefacCantine03;
   }

   public void setElefacCantine03(double var1) {
      this.elefacCantine03 = var1;
   }

   public double getElefacCantine04() {
      return this.elefacCantine04;
   }

   public void setElefacCantine04(double var1) {
      this.elefacCantine04 = var1;
   }

   public double getElefacCantine05() {
      return this.elefacCantine05;
   }

   public void setElefacCantine05(double var1) {
      this.elefacCantine05 = var1;
   }

   public double getElefacCantine06() {
      return this.elefacCantine06;
   }

   public void setElefacCantine06(double var1) {
      this.elefacCantine06 = var1;
   }

   public double getElefacCantine07() {
      return this.elefacCantine07;
   }

   public void setElefacCantine07(double var1) {
      this.elefacCantine07 = var1;
   }

   public double getElefacCantine08() {
      return this.elefacCantine08;
   }

   public void setElefacCantine08(double var1) {
      this.elefacCantine08 = var1;
   }

   public double getElefacCantine09() {
      return this.elefacCantine09;
   }

   public void setElefacCantine09(double var1) {
      this.elefacCantine09 = var1;
   }

   public double getElefacCantine10() {
      return this.elefacCantine10;
   }

   public void setElefacCantine10(double var1) {
      this.elefacCantine10 = var1;
   }

   public double getElefacCantine11() {
      return this.elefacCantine11;
   }

   public void setElefacCantine11(double var1) {
      this.elefacCantine11 = var1;
   }

   public double getElefacCantine12() {
      return this.elefacCantine12;
   }

   public void setElefacCantine12(double var1) {
      this.elefacCantine12 = var1;
   }

   public double getElefacScolarite01() {
      return this.elefacScolarite01;
   }

   public void setElefacScolarite01(double var1) {
      this.elefacScolarite01 = var1;
   }

   public double getElefacScolarite02() {
      return this.elefacScolarite02;
   }

   public void setElefacScolarite02(double var1) {
      this.elefacScolarite02 = var1;
   }

   public double getElefacScolarite03() {
      return this.elefacScolarite03;
   }

   public void setElefacScolarite03(double var1) {
      this.elefacScolarite03 = var1;
   }

   public double getElefacScolarite04() {
      return this.elefacScolarite04;
   }

   public void setElefacScolarite04(double var1) {
      this.elefacScolarite04 = var1;
   }

   public double getElefacScolarite05() {
      return this.elefacScolarite05;
   }

   public void setElefacScolarite05(double var1) {
      this.elefacScolarite05 = var1;
   }

   public double getElefacScolarite06() {
      return this.elefacScolarite06;
   }

   public void setElefacScolarite06(double var1) {
      this.elefacScolarite06 = var1;
   }

   public double getElefacScolarite07() {
      return this.elefacScolarite07;
   }

   public void setElefacScolarite07(double var1) {
      this.elefacScolarite07 = var1;
   }

   public double getElefacScolarite08() {
      return this.elefacScolarite08;
   }

   public void setElefacScolarite08(double var1) {
      this.elefacScolarite08 = var1;
   }

   public double getElefacScolarite09() {
      return this.elefacScolarite09;
   }

   public void setElefacScolarite09(double var1) {
      this.elefacScolarite09 = var1;
   }

   public double getElefacScolarite10() {
      return this.elefacScolarite10;
   }

   public void setElefacScolarite10(double var1) {
      this.elefacScolarite10 = var1;
   }

   public double getElefacScolarite11() {
      return this.elefacScolarite11;
   }

   public void setElefacScolarite11(double var1) {
      this.elefacScolarite11 = var1;
   }

   public double getElefacScolarite12() {
      return this.elefacScolarite12;
   }

   public void setElefacScolarite12(double var1) {
      this.elefacScolarite12 = var1;
   }

   public double getElefacTransport01() {
      return this.elefacTransport01;
   }

   public void setElefacTransport01(double var1) {
      this.elefacTransport01 = var1;
   }

   public double getElefacTransport02() {
      return this.elefacTransport02;
   }

   public void setElefacTransport02(double var1) {
      this.elefacTransport02 = var1;
   }

   public double getElefacTransport03() {
      return this.elefacTransport03;
   }

   public void setElefacTransport03(double var1) {
      this.elefacTransport03 = var1;
   }

   public double getElefacTransport04() {
      return this.elefacTransport04;
   }

   public void setElefacTransport04(double var1) {
      this.elefacTransport04 = var1;
   }

   public double getElefacTransport05() {
      return this.elefacTransport05;
   }

   public void setElefacTransport05(double var1) {
      this.elefacTransport05 = var1;
   }

   public double getElefacTransport06() {
      return this.elefacTransport06;
   }

   public void setElefacTransport06(double var1) {
      this.elefacTransport06 = var1;
   }

   public double getElefacTransport07() {
      return this.elefacTransport07;
   }

   public void setElefacTransport07(double var1) {
      this.elefacTransport07 = var1;
   }

   public double getElefacTransport08() {
      return this.elefacTransport08;
   }

   public void setElefacTransport08(double var1) {
      this.elefacTransport08 = var1;
   }

   public double getElefacTransport09() {
      return this.elefacTransport09;
   }

   public void setElefacTransport09(double var1) {
      this.elefacTransport09 = var1;
   }

   public double getElefacTransport10() {
      return this.elefacTransport10;
   }

   public void setElefacTransport10(double var1) {
      this.elefacTransport10 = var1;
   }

   public double getElefacTransport11() {
      return this.elefacTransport11;
   }

   public void setElefacTransport11(double var1) {
      this.elefacTransport11 = var1;
   }

   public double getElefacTransport12() {
      return this.elefacTransport12;
   }

   public void setElefacTransport12(double var1) {
      this.elefacTransport12 = var1;
   }

   public String getElefacSerie() {
      return this.elefacSerie;
   }

   public void setElefacSerie(String var1) {
      this.elefacSerie = var1;
   }

   public String getElefacDepartement() {
      return this.elefacDepartement;
   }

   public void setElefacDepartement(String var1) {
      this.elefacDepartement = var1;
   }

   public long getElefacIdCommercial() {
      return this.elefacIdCommercial;
   }

   public void setElefacIdCommercial(long var1) {
      this.elefacIdCommercial = var1;
   }

   public long getElefacIdResponsable() {
      return this.elefacIdResponsable;
   }

   public void setElefacIdResponsable(long var1) {
      this.elefacIdResponsable = var1;
   }

   public String getElefacNomCommercial() {
      return this.elefacNomCommercial;
   }

   public void setElefacNomCommercial(String var1) {
      this.elefacNomCommercial = var1;
   }

   public String getElefacNomResponsable() {
      return this.elefacNomResponsable;
   }

   public void setElefacNomResponsable(String var1) {
      this.elefacNomResponsable = var1;
   }

   public String getElefacPdv() {
      return this.elefacPdv;
   }

   public void setElefacPdv(String var1) {
      this.elefacPdv = var1;
   }

   public String getElefacRegion() {
      return this.elefacRegion;
   }

   public void setElefacRegion(String var1) {
      this.elefacRegion = var1;
   }

   public String getElefacSecteur() {
      return this.elefacSecteur;
   }

   public void setElefacSecteur(String var1) {
      this.elefacSecteur = var1;
   }

   public String getElefacService() {
      return this.elefacService;
   }

   public void setElefacService(String var1) {
      this.elefacService = var1;
   }

   public String getElefacSite() {
      return this.elefacSite;
   }

   public void setElefacSite(String var1) {
      this.elefacSite = var1;
   }

   public String getElefacCaisse() {
      return this.elefacCaisse;
   }

   public void setElefacCaisse(String var1) {
      this.elefacCaisse = var1;
   }

   public int getElefacSolde() {
      return this.elefacSolde;
   }

   public void setElefacSolde(int var1) {
      this.elefacSolde = var1;
   }

   public String getElefacCodeTaxe() {
      return this.elefacCodeTaxe;
   }

   public void setElefacCodeTaxe(String var1) {
      this.elefacCodeTaxe = var1;
   }

   public float getElefacTauxTaxe() {
      return this.elefacTauxTaxe;
   }

   public void setElefacTauxTaxe(float var1) {
      this.elefacTauxTaxe = var1;
   }

   public float getElefacTauxTc() {
      return this.elefacTauxTc;
   }

   public void setElefacTauxTc(float var1) {
      this.elefacTauxTc = var1;
   }

   public double getElefacTotalTaxe() {
      return this.elefacTotalTaxe;
   }

   public void setElefacTotalTaxe(double var1) {
      this.elefacTotalTaxe = var1;
   }

   public double getElefacTotalTc() {
      return this.elefacTotalTc;
   }

   public void setElefacTotalTc(double var1) {
      this.elefacTotalTc = var1;
   }

   public double getElefacTotalTimbre() {
      return this.elefacTotalTimbre;
   }

   public void setElefacTotalTimbre(double var1) {
      this.elefacTotalTimbre = var1;
   }

   public Date getElefacDateLastReg() {
      return this.elefacDateLastReg;
   }

   public void setElefacDateLastReg(Date var1) {
      this.elefacDateLastReg = var1;
   }

   public int getElefacTypeReg() {
      return this.elefacTypeReg;
   }

   public void setElefacTypeReg(int var1) {
      this.elefacTypeReg = var1;
   }

   public double getElefacTarifAssurance() {
      return this.elefacTarifAssurance;
   }

   public void setElefacTarifAssurance(double var1) {
      this.elefacTarifAssurance = var1;
   }
}
