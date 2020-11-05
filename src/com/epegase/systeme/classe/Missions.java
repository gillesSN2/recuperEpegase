package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Missions implements Serializable {
   private long misId;
   private Date misDateCreat;
   private Date misDateModif;
   private long misUserCreat;
   private long misUserModif;
   private String misNum;
   private String misPays;
   private int misNature;
   private int misMode;
   private double misPuPerdiem;
   private int misNbJourTheo;
   private double misPerdiemTheo;
   private String misObjectif;
   private String misDetail;
   private int misEtat;
   private String misService;
   private String misActivite;
   private String misBudget;
   private double misBudgetDispo;
   private double misBudgetDispoMois;
   private double misBudgetTreso;
   private double misBudgetTresoMois;
   private long misIdResponsable;
   private String misNomResponsable;
   private Date misDateDebut;
   private Date misDateFin;
   private Date misDateDebutReel;
   private Date misDateFinReel;
   private int misNbJourReel;
   private double misPerdiemReel;
   private String misOrdreMission;
   private String misItineraire;
   private String misRapportMission;
   private double misTotalTransport;
   private double misTotalHebergement;
   private double misTotalRestauration;
   private double misTotalDivers;
   private double misTotalVisa;
   private double misTotalPerdiem;
   private double misTotalCout;
   private ExercicesPaye exercicesPaye;
   private String lib_nature;
   private String lib_mode;
   private String lib_etat;

   public String getLib_etat() {
      if (this.misEtat == 0) {
         this.lib_etat = "En cours";
      } else if (this.misEtat == 1) {
         this.lib_etat = "Approuvé";
      } else if (this.misEtat == 2) {
         this.lib_etat = "Exécution";
      } else if (this.misEtat == 3) {
         this.lib_etat = "Retour";
      } else if (this.misEtat == 4) {
         this.lib_etat = "Cloturé";
      } else if (this.misEtat == 5) {
         this.lib_etat = "Annulé";
      } else if (this.misEtat == 6) {
         this.lib_etat = "Gelé";
      }

      return this.lib_etat;
   }

   public void setLib_etat(String var1) {
      this.lib_etat = var1;
   }

   public String getLib_mode() {
      if (this.misMode == 0) {
         this.lib_mode = "Local";
      } else if (this.misMode == 1) {
         this.lib_mode = "Etranger";
      }

      return this.lib_mode;
   }

   public void setLib_mode(String var1) {
      this.lib_mode = var1;
   }

   public String getLib_nature() {
      if (this.misNature == 0) {
         this.lib_nature = "Formation";
      } else if (this.misNature == 1) {
         this.lib_nature = "Réunion";
      } else if (this.misNature == 2) {
         this.lib_nature = "Séminaire";
      } else if (this.misNature == 3) {
         this.lib_nature = "Terrain";
      } else if (this.misNature == 4) {
         this.lib_nature = "Visite";
      }

      return this.lib_nature;
   }

   public void setLib_nature(String var1) {
      this.lib_nature = var1;
   }

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public String getMisActivite() {
      return this.misActivite;
   }

   public void setMisActivite(String var1) {
      this.misActivite = var1;
   }

   public String getMisBudget() {
      return this.misBudget;
   }

   public void setMisBudget(String var1) {
      this.misBudget = var1;
   }

   public Date getMisDateDebut() {
      return this.misDateDebut;
   }

   public void setMisDateDebut(Date var1) {
      this.misDateDebut = var1;
   }

   public Date getMisDateFin() {
      return this.misDateFin;
   }

   public void setMisDateFin(Date var1) {
      this.misDateFin = var1;
   }

   public String getMisDetail() {
      return this.misDetail;
   }

   public void setMisDetail(String var1) {
      this.misDetail = var1;
   }

   public int getMisEtat() {
      return this.misEtat;
   }

   public void setMisEtat(int var1) {
      this.misEtat = var1;
   }

   public long getMisId() {
      return this.misId;
   }

   public void setMisId(long var1) {
      this.misId = var1;
   }

   public long getMisIdResponsable() {
      return this.misIdResponsable;
   }

   public void setMisIdResponsable(long var1) {
      this.misIdResponsable = var1;
   }

   public int getMisMode() {
      return this.misMode;
   }

   public void setMisMode(int var1) {
      this.misMode = var1;
   }

   public int getMisNature() {
      return this.misNature;
   }

   public void setMisNature(int var1) {
      this.misNature = var1;
   }

   public int getMisNbJourReel() {
      return this.misNbJourReel;
   }

   public void setMisNbJourReel(int var1) {
      this.misNbJourReel = var1;
   }

   public int getMisNbJourTheo() {
      return this.misNbJourTheo;
   }

   public void setMisNbJourTheo(int var1) {
      this.misNbJourTheo = var1;
   }

   public String getMisNomResponsable() {
      return this.misNomResponsable;
   }

   public void setMisNomResponsable(String var1) {
      this.misNomResponsable = var1;
   }

   public String getMisObjectif() {
      return this.misObjectif;
   }

   public void setMisObjectif(String var1) {
      this.misObjectif = var1;
   }

   public String getMisOrdreMission() {
      return this.misOrdreMission;
   }

   public void setMisOrdreMission(String var1) {
      this.misOrdreMission = var1;
   }

   public double getMisPerdiemReel() {
      return this.misPerdiemReel;
   }

   public void setMisPerdiemReel(double var1) {
      this.misPerdiemReel = var1;
   }

   public double getMisPerdiemTheo() {
      return this.misPerdiemTheo;
   }

   public void setMisPerdiemTheo(double var1) {
      this.misPerdiemTheo = var1;
   }

   public double getMisPuPerdiem() {
      return this.misPuPerdiem;
   }

   public void setMisPuPerdiem(double var1) {
      this.misPuPerdiem = var1;
   }

   public String getMisRapportMission() {
      return this.misRapportMission;
   }

   public void setMisRapportMission(String var1) {
      this.misRapportMission = var1;
   }

   public String getMisService() {
      return this.misService;
   }

   public void setMisService(String var1) {
      this.misService = var1;
   }

   public double getMisTotalCout() {
      return this.misTotalCout;
   }

   public void setMisTotalCout(double var1) {
      this.misTotalCout = var1;
   }

   public Date getMisDateCreat() {
      return this.misDateCreat;
   }

   public void setMisDateCreat(Date var1) {
      this.misDateCreat = var1;
   }

   public Date getMisDateModif() {
      return this.misDateModif;
   }

   public void setMisDateModif(Date var1) {
      this.misDateModif = var1;
   }

   public String getMisNum() {
      return this.misNum;
   }

   public void setMisNum(String var1) {
      this.misNum = var1;
   }

   public long getMisUserCreat() {
      return this.misUserCreat;
   }

   public void setMisUserCreat(long var1) {
      this.misUserCreat = var1;
   }

   public long getMisUserModif() {
      return this.misUserModif;
   }

   public void setMisUserModif(long var1) {
      this.misUserModif = var1;
   }

   public String getMisPays() {
      return this.misPays;
   }

   public void setMisPays(String var1) {
      this.misPays = var1;
   }

   public Date getMisDateDebutReel() {
      return this.misDateDebutReel;
   }

   public void setMisDateDebutReel(Date var1) {
      this.misDateDebutReel = var1;
   }

   public Date getMisDateFinReel() {
      return this.misDateFinReel;
   }

   public void setMisDateFinReel(Date var1) {
      this.misDateFinReel = var1;
   }

   public double getMisTotalDivers() {
      return this.misTotalDivers;
   }

   public void setMisTotalDivers(double var1) {
      this.misTotalDivers = var1;
   }

   public double getMisTotalHebergement() {
      return this.misTotalHebergement;
   }

   public void setMisTotalHebergement(double var1) {
      this.misTotalHebergement = var1;
   }

   public double getMisTotalRestauration() {
      return this.misTotalRestauration;
   }

   public void setMisTotalRestauration(double var1) {
      this.misTotalRestauration = var1;
   }

   public double getMisTotalTransport() {
      return this.misTotalTransport;
   }

   public void setMisTotalTransport(double var1) {
      this.misTotalTransport = var1;
   }

   public double getMisTotalVisa() {
      return this.misTotalVisa;
   }

   public void setMisTotalVisa(double var1) {
      this.misTotalVisa = var1;
   }

   public double getMisTotalPerdiem() {
      return this.misTotalPerdiem;
   }

   public void setMisTotalPerdiem(double var1) {
      this.misTotalPerdiem = var1;
   }

   public String getMisItineraire() {
      return this.misItineraire;
   }

   public void setMisItineraire(String var1) {
      this.misItineraire = var1;
   }

   public double getMisBudgetDispo() {
      return this.misBudgetDispo;
   }

   public void setMisBudgetDispo(double var1) {
      this.misBudgetDispo = var1;
   }

   public double getMisBudgetDispoMois() {
      return this.misBudgetDispoMois;
   }

   public void setMisBudgetDispoMois(double var1) {
      this.misBudgetDispoMois = var1;
   }

   public double getMisBudgetTreso() {
      return this.misBudgetTreso;
   }

   public void setMisBudgetTreso(double var1) {
      this.misBudgetTreso = var1;
   }

   public double getMisBudgetTresoMois() {
      return this.misBudgetTresoMois;
   }

   public void setMisBudgetTresoMois(double var1) {
      this.misBudgetTresoMois = var1;
   }
}
