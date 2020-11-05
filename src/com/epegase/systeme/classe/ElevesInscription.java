package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ElevesInscription implements Serializable {
   private long eleinsId;
   private Date eleinsDateCreat;
   private long eleinsIdCreateur;
   private Date eleinsDateModif;
   private long eleinsIdModif;
   private String eleinsAnnee;
   private String eleinsSerie;
   private Date eleinsDate;
   private Date eleinsDateFacturation;
   private Date eleinsDateDebut;
   private Date eleinsDateFin;
   private int eleinsnbMois;
   private int eleinsnbTrimestre;
   private int eleinsnbSemestre;
   private double eleinsTarifDossier;
   private double eleinsTarifInscription;
   private double eleinsTarifReinscription;
   private double eleinsTarifScolarite;
   private int eleinsModeScolarite;
   private double eleinsTarifCantine;
   private double eleinsTarifTransport;
   private double eleinsTarifTenue;
   private double eleinsTarifDivers;
   private double eleinsTarifExamens;
   private double eleinsTarifAssociation;
   private double eleinsTarifAssurance;
   private int eleinsEtatVal;
   private int eleinsEtat;
   private Date eleinsDateValidite;
   private Date eleinsDateValide;
   private String eleinsSite;
   private String eleinsDepartement;
   private String eleinsService;
   private String eleinsRegion;
   private String eleinsSecteur;
   private String eleinsPdv;
   private String eleinsCaisse;
   private String eleinsNomResponsable;
   private long eleinsIdResponsable;
   private String eleinsNomCommercial;
   private long eleinsIdCommercial;
   private Date eleinsDateEche01;
   private Date eleinsDateEche02;
   private Date eleinsDateEche03;
   private Date eleinsDateEche04;
   private Date eleinsDateEche05;
   private Date eleinsDateEche06;
   private Date eleinsDateEche07;
   private Date eleinsDateEche08;
   private Date eleinsDateEche09;
   private Date eleinsDateEche10;
   private Date eleinsDateEche11;
   private Date eleinsDateEche12;
   private double eleinsScolarite01;
   private double eleinsScolarite02;
   private double eleinsScolarite03;
   private double eleinsScolarite04;
   private double eleinsScolarite05;
   private double eleinsScolarite06;
   private double eleinsScolarite07;
   private double eleinsScolarite08;
   private double eleinsScolarite09;
   private double eleinsScolarite10;
   private double eleinsScolarite11;
   private double eleinsScolarite12;
   private double eleinsCantine01;
   private double eleinsCantine02;
   private double eleinsCantine03;
   private double eleinsCantine04;
   private double eleinsCantine05;
   private double eleinsCantine06;
   private double eleinsCantine07;
   private double eleinsCantine08;
   private double eleinsCantine09;
   private double eleinsCantine10;
   private double eleinsCantine11;
   private double eleinsCantine12;
   private double eleinsTransport01;
   private double eleinsTransport02;
   private double eleinsTransport03;
   private double eleinsTransport04;
   private double eleinsTransport05;
   private double eleinsTransport06;
   private double eleinsTransport07;
   private double eleinsTransport08;
   private double eleinsTransport09;
   private double eleinsTransport10;
   private double eleinsTransport11;
   private double eleinsTransport12;
   private Eleves eleves;
   private FilieresEducation filieresEducation;
   private String libelleEtat;
   private String libelleMode;

   public Eleves getEleves() {
      return this.eleves;
   }

   public void setEleves(Eleves var1) {
      this.eleves = var1;
   }

   public String getLibelleEtat() {
      if (this.eleinsEtat == 0) {
         this.libelleEtat = "E.C.";
      } else if (this.eleinsEtat == 1) {
         this.libelleEtat = "Val.";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public String getLibelleMode() {
      if (this.eleinsModeScolarite == 0) {
         this.libelleMode = "Mensuel";
      } else if (this.eleinsModeScolarite == 1) {
         this.libelleMode = "Trimestriel";
      } else if (this.eleinsModeScolarite == 2) {
         this.libelleMode = "Semestriel";
      } else if (this.eleinsModeScolarite == 3) {
         this.libelleMode = "Annuel";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public String getEleinsAnnee() {
      return this.eleinsAnnee;
   }

   public void setEleinsAnnee(String var1) {
      this.eleinsAnnee = var1;
   }

   public Date getEleinsDateDebut() {
      return this.eleinsDateDebut;
   }

   public void setEleinsDateDebut(Date var1) {
      this.eleinsDateDebut = var1;
   }

   public Date getEleinsDateFin() {
      return this.eleinsDateFin;
   }

   public void setEleinsDateFin(Date var1) {
      this.eleinsDateFin = var1;
   }

   public long getEleinsId() {
      return this.eleinsId;
   }

   public void setEleinsId(long var1) {
      this.eleinsId = var1;
   }

   public int getEleinsModeScolarite() {
      return this.eleinsModeScolarite;
   }

   public void setEleinsModeScolarite(int var1) {
      this.eleinsModeScolarite = var1;
   }

   public double getEleinsTarifAssociation() {
      return this.eleinsTarifAssociation;
   }

   public void setEleinsTarifAssociation(double var1) {
      this.eleinsTarifAssociation = var1;
   }

   public double getEleinsTarifCantine() {
      return this.eleinsTarifCantine;
   }

   public void setEleinsTarifCantine(double var1) {
      this.eleinsTarifCantine = var1;
   }

   public double getEleinsTarifDivers() {
      return this.eleinsTarifDivers;
   }

   public void setEleinsTarifDivers(double var1) {
      this.eleinsTarifDivers = var1;
   }

   public double getEleinsTarifDossier() {
      return this.eleinsTarifDossier;
   }

   public void setEleinsTarifDossier(double var1) {
      this.eleinsTarifDossier = var1;
   }

   public double getEleinsTarifExamens() {
      return this.eleinsTarifExamens;
   }

   public void setEleinsTarifExamens(double var1) {
      this.eleinsTarifExamens = var1;
   }

   public double getEleinsTarifInscription() {
      return this.eleinsTarifInscription;
   }

   public void setEleinsTarifInscription(double var1) {
      this.eleinsTarifInscription = var1;
   }

   public double getEleinsTarifReinscription() {
      return this.eleinsTarifReinscription;
   }

   public void setEleinsTarifReinscription(double var1) {
      this.eleinsTarifReinscription = var1;
   }

   public double getEleinsTarifScolarite() {
      return this.eleinsTarifScolarite;
   }

   public void setEleinsTarifScolarite(double var1) {
      this.eleinsTarifScolarite = var1;
   }

   public double getEleinsTarifTenue() {
      return this.eleinsTarifTenue;
   }

   public void setEleinsTarifTenue(double var1) {
      this.eleinsTarifTenue = var1;
   }

   public FilieresEducation getFilieresEducation() {
      return this.filieresEducation;
   }

   public void setFilieresEducation(FilieresEducation var1) {
      this.filieresEducation = var1;
   }

   public Date getEleinsDateValide() {
      return this.eleinsDateValide;
   }

   public void setEleinsDateValide(Date var1) {
      this.eleinsDateValide = var1;
   }

   public Date getEleinsDateValidite() {
      return this.eleinsDateValidite;
   }

   public void setEleinsDateValidite(Date var1) {
      this.eleinsDateValidite = var1;
   }

   public int getEleinsEtat() {
      return this.eleinsEtat;
   }

   public void setEleinsEtat(int var1) {
      this.eleinsEtat = var1;
   }

   public int getEleinsEtatVal() {
      return this.eleinsEtatVal;
   }

   public void setEleinsEtatVal(int var1) {
      this.eleinsEtatVal = var1;
   }

   public Date getEleinsDateCreat() {
      return this.eleinsDateCreat;
   }

   public void setEleinsDateCreat(Date var1) {
      this.eleinsDateCreat = var1;
   }

   public Date getEleinsDateModif() {
      return this.eleinsDateModif;
   }

   public void setEleinsDateModif(Date var1) {
      this.eleinsDateModif = var1;
   }

   public long getEleinsIdCreateur() {
      return this.eleinsIdCreateur;
   }

   public void setEleinsIdCreateur(long var1) {
      this.eleinsIdCreateur = var1;
   }

   public long getEleinsIdModif() {
      return this.eleinsIdModif;
   }

   public void setEleinsIdModif(long var1) {
      this.eleinsIdModif = var1;
   }

   public double getEleinsTarifTransport() {
      return this.eleinsTarifTransport;
   }

   public void setEleinsTarifTransport(double var1) {
      this.eleinsTarifTransport = var1;
   }

   public Date getEleinsDate() {
      return this.eleinsDate;
   }

   public void setEleinsDate(Date var1) {
      this.eleinsDate = var1;
   }

   public double getEleinsCantine01() {
      return this.eleinsCantine01;
   }

   public void setEleinsCantine01(double var1) {
      this.eleinsCantine01 = var1;
   }

   public double getEleinsCantine02() {
      return this.eleinsCantine02;
   }

   public void setEleinsCantine02(double var1) {
      this.eleinsCantine02 = var1;
   }

   public double getEleinsCantine03() {
      return this.eleinsCantine03;
   }

   public void setEleinsCantine03(double var1) {
      this.eleinsCantine03 = var1;
   }

   public double getEleinsCantine04() {
      return this.eleinsCantine04;
   }

   public void setEleinsCantine04(double var1) {
      this.eleinsCantine04 = var1;
   }

   public double getEleinsCantine05() {
      return this.eleinsCantine05;
   }

   public void setEleinsCantine05(double var1) {
      this.eleinsCantine05 = var1;
   }

   public double getEleinsCantine06() {
      return this.eleinsCantine06;
   }

   public void setEleinsCantine06(double var1) {
      this.eleinsCantine06 = var1;
   }

   public double getEleinsCantine07() {
      return this.eleinsCantine07;
   }

   public void setEleinsCantine07(double var1) {
      this.eleinsCantine07 = var1;
   }

   public double getEleinsCantine08() {
      return this.eleinsCantine08;
   }

   public void setEleinsCantine08(double var1) {
      this.eleinsCantine08 = var1;
   }

   public double getEleinsCantine09() {
      return this.eleinsCantine09;
   }

   public void setEleinsCantine09(double var1) {
      this.eleinsCantine09 = var1;
   }

   public double getEleinsCantine10() {
      return this.eleinsCantine10;
   }

   public void setEleinsCantine10(double var1) {
      this.eleinsCantine10 = var1;
   }

   public double getEleinsCantine11() {
      return this.eleinsCantine11;
   }

   public void setEleinsCantine11(double var1) {
      this.eleinsCantine11 = var1;
   }

   public double getEleinsCantine12() {
      return this.eleinsCantine12;
   }

   public void setEleinsCantine12(double var1) {
      this.eleinsCantine12 = var1;
   }

   public Date getEleinsDateEche01() {
      return this.eleinsDateEche01;
   }

   public void setEleinsDateEche01(Date var1) {
      this.eleinsDateEche01 = var1;
   }

   public Date getEleinsDateEche02() {
      return this.eleinsDateEche02;
   }

   public void setEleinsDateEche02(Date var1) {
      this.eleinsDateEche02 = var1;
   }

   public Date getEleinsDateEche03() {
      return this.eleinsDateEche03;
   }

   public void setEleinsDateEche03(Date var1) {
      this.eleinsDateEche03 = var1;
   }

   public Date getEleinsDateEche04() {
      return this.eleinsDateEche04;
   }

   public void setEleinsDateEche04(Date var1) {
      this.eleinsDateEche04 = var1;
   }

   public Date getEleinsDateEche05() {
      return this.eleinsDateEche05;
   }

   public void setEleinsDateEche05(Date var1) {
      this.eleinsDateEche05 = var1;
   }

   public Date getEleinsDateEche06() {
      return this.eleinsDateEche06;
   }

   public void setEleinsDateEche06(Date var1) {
      this.eleinsDateEche06 = var1;
   }

   public Date getEleinsDateEche07() {
      return this.eleinsDateEche07;
   }

   public void setEleinsDateEche07(Date var1) {
      this.eleinsDateEche07 = var1;
   }

   public Date getEleinsDateEche08() {
      return this.eleinsDateEche08;
   }

   public void setEleinsDateEche08(Date var1) {
      this.eleinsDateEche08 = var1;
   }

   public Date getEleinsDateEche09() {
      return this.eleinsDateEche09;
   }

   public void setEleinsDateEche09(Date var1) {
      this.eleinsDateEche09 = var1;
   }

   public Date getEleinsDateEche10() {
      return this.eleinsDateEche10;
   }

   public void setEleinsDateEche10(Date var1) {
      this.eleinsDateEche10 = var1;
   }

   public Date getEleinsDateEche11() {
      return this.eleinsDateEche11;
   }

   public void setEleinsDateEche11(Date var1) {
      this.eleinsDateEche11 = var1;
   }

   public Date getEleinsDateEche12() {
      return this.eleinsDateEche12;
   }

   public void setEleinsDateEche12(Date var1) {
      this.eleinsDateEche12 = var1;
   }

   public double getEleinsScolarite01() {
      return this.eleinsScolarite01;
   }

   public void setEleinsScolarite01(double var1) {
      this.eleinsScolarite01 = var1;
   }

   public double getEleinsScolarite02() {
      return this.eleinsScolarite02;
   }

   public void setEleinsScolarite02(double var1) {
      this.eleinsScolarite02 = var1;
   }

   public double getEleinsScolarite03() {
      return this.eleinsScolarite03;
   }

   public void setEleinsScolarite03(double var1) {
      this.eleinsScolarite03 = var1;
   }

   public double getEleinsScolarite04() {
      return this.eleinsScolarite04;
   }

   public void setEleinsScolarite04(double var1) {
      this.eleinsScolarite04 = var1;
   }

   public double getEleinsScolarite05() {
      return this.eleinsScolarite05;
   }

   public void setEleinsScolarite05(double var1) {
      this.eleinsScolarite05 = var1;
   }

   public double getEleinsScolarite06() {
      return this.eleinsScolarite06;
   }

   public void setEleinsScolarite06(double var1) {
      this.eleinsScolarite06 = var1;
   }

   public double getEleinsScolarite07() {
      return this.eleinsScolarite07;
   }

   public void setEleinsScolarite07(double var1) {
      this.eleinsScolarite07 = var1;
   }

   public double getEleinsScolarite08() {
      return this.eleinsScolarite08;
   }

   public void setEleinsScolarite08(double var1) {
      this.eleinsScolarite08 = var1;
   }

   public double getEleinsScolarite09() {
      return this.eleinsScolarite09;
   }

   public void setEleinsScolarite09(double var1) {
      this.eleinsScolarite09 = var1;
   }

   public double getEleinsScolarite10() {
      return this.eleinsScolarite10;
   }

   public void setEleinsScolarite10(double var1) {
      this.eleinsScolarite10 = var1;
   }

   public double getEleinsScolarite11() {
      return this.eleinsScolarite11;
   }

   public void setEleinsScolarite11(double var1) {
      this.eleinsScolarite11 = var1;
   }

   public double getEleinsScolarite12() {
      return this.eleinsScolarite12;
   }

   public void setEleinsScolarite12(double var1) {
      this.eleinsScolarite12 = var1;
   }

   public double getEleinsTransport01() {
      return this.eleinsTransport01;
   }

   public void setEleinsTransport01(double var1) {
      this.eleinsTransport01 = var1;
   }

   public double getEleinsTransport02() {
      return this.eleinsTransport02;
   }

   public void setEleinsTransport02(double var1) {
      this.eleinsTransport02 = var1;
   }

   public double getEleinsTransport03() {
      return this.eleinsTransport03;
   }

   public void setEleinsTransport03(double var1) {
      this.eleinsTransport03 = var1;
   }

   public double getEleinsTransport04() {
      return this.eleinsTransport04;
   }

   public void setEleinsTransport04(double var1) {
      this.eleinsTransport04 = var1;
   }

   public double getEleinsTransport05() {
      return this.eleinsTransport05;
   }

   public void setEleinsTransport05(double var1) {
      this.eleinsTransport05 = var1;
   }

   public double getEleinsTransport06() {
      return this.eleinsTransport06;
   }

   public void setEleinsTransport06(double var1) {
      this.eleinsTransport06 = var1;
   }

   public double getEleinsTransport07() {
      return this.eleinsTransport07;
   }

   public void setEleinsTransport07(double var1) {
      this.eleinsTransport07 = var1;
   }

   public double getEleinsTransport08() {
      return this.eleinsTransport08;
   }

   public void setEleinsTransport08(double var1) {
      this.eleinsTransport08 = var1;
   }

   public double getEleinsTransport09() {
      return this.eleinsTransport09;
   }

   public void setEleinsTransport09(double var1) {
      this.eleinsTransport09 = var1;
   }

   public double getEleinsTransport10() {
      return this.eleinsTransport10;
   }

   public void setEleinsTransport10(double var1) {
      this.eleinsTransport10 = var1;
   }

   public double getEleinsTransport11() {
      return this.eleinsTransport11;
   }

   public void setEleinsTransport11(double var1) {
      this.eleinsTransport11 = var1;
   }

   public double getEleinsTransport12() {
      return this.eleinsTransport12;
   }

   public void setEleinsTransport12(double var1) {
      this.eleinsTransport12 = var1;
   }

   public int getEleinsnbMois() {
      return this.eleinsnbMois;
   }

   public void setEleinsnbMois(int var1) {
      this.eleinsnbMois = var1;
   }

   public int getEleinsnbSemestre() {
      return this.eleinsnbSemestre;
   }

   public void setEleinsnbSemestre(int var1) {
      this.eleinsnbSemestre = var1;
   }

   public int getEleinsnbTrimestre() {
      return this.eleinsnbTrimestre;
   }

   public void setEleinsnbTrimestre(int var1) {
      this.eleinsnbTrimestre = var1;
   }

   public Date getEleinsDateFacturation() {
      return this.eleinsDateFacturation;
   }

   public void setEleinsDateFacturation(Date var1) {
      this.eleinsDateFacturation = var1;
   }

   public String getEleinsSerie() {
      return this.eleinsSerie;
   }

   public void setEleinsSerie(String var1) {
      this.eleinsSerie = var1;
   }

   public String getEleinsDepartement() {
      return this.eleinsDepartement;
   }

   public void setEleinsDepartement(String var1) {
      this.eleinsDepartement = var1;
   }

   public long getEleinsIdCommercial() {
      return this.eleinsIdCommercial;
   }

   public void setEleinsIdCommercial(long var1) {
      this.eleinsIdCommercial = var1;
   }

   public long getEleinsIdResponsable() {
      return this.eleinsIdResponsable;
   }

   public void setEleinsIdResponsable(long var1) {
      this.eleinsIdResponsable = var1;
   }

   public String getEleinsNomCommercial() {
      return this.eleinsNomCommercial;
   }

   public void setEleinsNomCommercial(String var1) {
      this.eleinsNomCommercial = var1;
   }

   public String getEleinsNomResponsable() {
      return this.eleinsNomResponsable;
   }

   public void setEleinsNomResponsable(String var1) {
      this.eleinsNomResponsable = var1;
   }

   public String getEleinsPdv() {
      return this.eleinsPdv;
   }

   public void setEleinsPdv(String var1) {
      this.eleinsPdv = var1;
   }

   public String getEleinsRegion() {
      return this.eleinsRegion;
   }

   public void setEleinsRegion(String var1) {
      this.eleinsRegion = var1;
   }

   public String getEleinsSecteur() {
      return this.eleinsSecteur;
   }

   public void setEleinsSecteur(String var1) {
      this.eleinsSecteur = var1;
   }

   public String getEleinsService() {
      return this.eleinsService;
   }

   public void setEleinsService(String var1) {
      this.eleinsService = var1;
   }

   public String getEleinsSite() {
      return this.eleinsSite;
   }

   public void setEleinsSite(String var1) {
      this.eleinsSite = var1;
   }

   public String getEleinsCaisse() {
      return this.eleinsCaisse;
   }

   public void setEleinsCaisse(String var1) {
      this.eleinsCaisse = var1;
   }

   public double getEleinsTarifAssurance() {
      return this.eleinsTarifAssurance;
   }

   public void setEleinsTarifAssurance(double var1) {
      this.eleinsTarifAssurance = var1;
   }
}
