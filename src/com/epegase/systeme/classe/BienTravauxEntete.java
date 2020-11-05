package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BienTravauxEntete implements Serializable {
   private long bietraentId;
   private Date bietraentDateCreat;
   private Date bietraentDateModif;
   private long bietraentUserCreat;
   private long bietraentUserModif;
   private Date bietraentDateDebut;
   private Date bietraentDateFin;
   private String bietraentNum;
   private String bietraentCodeBien;
   private int bietraentDuree;
   private int bietraentEtat;
   private String bietraentSerie;
   private String bietraentNomResponsable;
   private long bietraentIdResponsable;
   private String bietraentObjet;
   private String bietraentDescriptif;
   private double bietraentCoutTheorique;
   private double bietraentCoutReel;
   private Date bietraentDateCtrl;
   private String bietraentObsCtrl;
   private String bietraentRapportCtrl;
   private String bietraentNomCtrl;
   private long bietraentIdCtrl;
   private Date bietraentDateImp;
   private String bietraentModeleImp;
   private long bietraentIdEquipe;
   private Date bietraentDateLivraison;
   private int bietraentCompteurReport;
   private String bietraentInfoLivraison;
   private int bietraentModeLivraison;
   private int bietraentHoraireLivraison;
   private String bietraentHeureLivraison;
   private String bietraentContactLivraison;
   private String bietraentTelephoneLivraison;
   private int bietraentEtatLivraison;
   private String bietraentObservationLivraison;
   private int bietraentPhase;
   private Bien bien;
   private String libelleEta;
   private boolean var_select_ligne;
   private String var_nomContact;
   private String var_contactLivraison;
   private String var_nom_tiers;
   private String heure;
   private String minute;
   private String periode;
   private int annee;
   private String libelleMode;
   private String color;
   private String texteAffiche;

   public int getAnnee() {
      return this.annee;
   }

   public void setAnnee(int var1) {
      this.annee = var1;
   }

   public String getColor() {
      return this.color;
   }

   public void setColor(String var1) {
      this.color = var1;
   }

   public String getHeure() {
      return this.heure;
   }

   public void setHeure(String var1) {
      this.heure = var1;
   }

   public String getLibelleEta() {
      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getLibelleMode() {
      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public String getMinute() {
      return this.minute;
   }

   public void setMinute(String var1) {
      this.minute = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public String getTexteAffiche() {
      return this.texteAffiche;
   }

   public void setTexteAffiche(String var1) {
      this.texteAffiche = var1;
   }

   public String getVar_contactLivraison() {
      return this.var_contactLivraison;
   }

   public void setVar_contactLivraison(String var1) {
      this.var_contactLivraison = var1;
   }

   public String getVar_nomContact() {
      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public String getVar_nom_tiers() {
      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public Bien getBien() {
      return this.bien;
   }

   public void setBien(Bien var1) {
      this.bien = var1;
   }

   public Date getBietraentDateCreat() {
      return this.bietraentDateCreat;
   }

   public void setBietraentDateCreat(Date var1) {
      this.bietraentDateCreat = var1;
   }

   public Date getBietraentDateDebut() {
      return this.bietraentDateDebut;
   }

   public void setBietraentDateDebut(Date var1) {
      this.bietraentDateDebut = var1;
   }

   public Date getBietraentDateFin() {
      return this.bietraentDateFin;
   }

   public void setBietraentDateFin(Date var1) {
      this.bietraentDateFin = var1;
   }

   public Date getBietraentDateModif() {
      return this.bietraentDateModif;
   }

   public void setBietraentDateModif(Date var1) {
      this.bietraentDateModif = var1;
   }

   public int getBietraentDuree() {
      return this.bietraentDuree;
   }

   public void setBietraentDuree(int var1) {
      this.bietraentDuree = var1;
   }

   public int getBietraentEtat() {
      return this.bietraentEtat;
   }

   public void setBietraentEtat(int var1) {
      this.bietraentEtat = var1;
   }

   public long getBietraentId() {
      return this.bietraentId;
   }

   public void setBietraentId(long var1) {
      this.bietraentId = var1;
   }

   public long getBietraentIdResponsable() {
      return this.bietraentIdResponsable;
   }

   public void setBietraentIdResponsable(long var1) {
      this.bietraentIdResponsable = var1;
   }

   public String getBietraentNomResponsable() {
      return this.bietraentNomResponsable;
   }

   public void setBietraentNomResponsable(String var1) {
      this.bietraentNomResponsable = var1;
   }

   public String getBietraentNum() {
      return this.bietraentNum;
   }

   public void setBietraentNum(String var1) {
      this.bietraentNum = var1;
   }

   public String getBietraentSerie() {
      return this.bietraentSerie;
   }

   public void setBietraentSerie(String var1) {
      this.bietraentSerie = var1;
   }

   public long getBietraentUserCreat() {
      return this.bietraentUserCreat;
   }

   public void setBietraentUserCreat(long var1) {
      this.bietraentUserCreat = var1;
   }

   public long getBietraentUserModif() {
      return this.bietraentUserModif;
   }

   public void setBietraentUserModif(long var1) {
      this.bietraentUserModif = var1;
   }

   public String getBietraentDescriptif() {
      return this.bietraentDescriptif;
   }

   public void setBietraentDescriptif(String var1) {
      this.bietraentDescriptif = var1;
   }

   public String getBietraentObjet() {
      return this.bietraentObjet;
   }

   public void setBietraentObjet(String var1) {
      this.bietraentObjet = var1;
   }

   public double getBietraentCoutReel() {
      return this.bietraentCoutReel;
   }

   public void setBietraentCoutReel(double var1) {
      this.bietraentCoutReel = var1;
   }

   public double getBietraentCoutTheorique() {
      return this.bietraentCoutTheorique;
   }

   public void setBietraentCoutTheorique(double var1) {
      this.bietraentCoutTheorique = var1;
   }

   public Date getBietraentDateCtrl() {
      return this.bietraentDateCtrl;
   }

   public void setBietraentDateCtrl(Date var1) {
      this.bietraentDateCtrl = var1;
   }

   public String getBietraentObsCtrl() {
      return this.bietraentObsCtrl;
   }

   public void setBietraentObsCtrl(String var1) {
      this.bietraentObsCtrl = var1;
   }

   public String getBietraentCodeBien() {
      return this.bietraentCodeBien;
   }

   public void setBietraentCodeBien(String var1) {
      this.bietraentCodeBien = var1;
   }

   public String getBietraentRapportCtrl() {
      return this.bietraentRapportCtrl;
   }

   public void setBietraentRapportCtrl(String var1) {
      this.bietraentRapportCtrl = var1;
   }

   public long getBietraentIdCtrl() {
      return this.bietraentIdCtrl;
   }

   public void setBietraentIdCtrl(long var1) {
      this.bietraentIdCtrl = var1;
   }

   public String getBietraentNomCtrl() {
      return this.bietraentNomCtrl;
   }

   public void setBietraentNomCtrl(String var1) {
      this.bietraentNomCtrl = var1;
   }

   public Date getBietraentDateImp() {
      return this.bietraentDateImp;
   }

   public void setBietraentDateImp(Date var1) {
      this.bietraentDateImp = var1;
   }

   public String getBietraentModeleImp() {
      return this.bietraentModeleImp;
   }

   public void setBietraentModeleImp(String var1) {
      this.bietraentModeleImp = var1;
   }

   public int getBietraentCompteurReport() {
      return this.bietraentCompteurReport;
   }

   public void setBietraentCompteurReport(int var1) {
      this.bietraentCompteurReport = var1;
   }

   public String getBietraentContactLivraison() {
      return this.bietraentContactLivraison;
   }

   public void setBietraentContactLivraison(String var1) {
      this.bietraentContactLivraison = var1;
   }

   public Date getBietraentDateLivraison() {
      return this.bietraentDateLivraison;
   }

   public void setBietraentDateLivraison(Date var1) {
      this.bietraentDateLivraison = var1;
   }

   public int getBietraentEtatLivraison() {
      return this.bietraentEtatLivraison;
   }

   public void setBietraentEtatLivraison(int var1) {
      this.bietraentEtatLivraison = var1;
   }

   public String getBietraentHeureLivraison() {
      return this.bietraentHeureLivraison;
   }

   public void setBietraentHeureLivraison(String var1) {
      this.bietraentHeureLivraison = var1;
   }

   public int getBietraentHoraireLivraison() {
      return this.bietraentHoraireLivraison;
   }

   public void setBietraentHoraireLivraison(int var1) {
      this.bietraentHoraireLivraison = var1;
   }

   public String getBietraentInfoLivraison() {
      return this.bietraentInfoLivraison;
   }

   public void setBietraentInfoLivraison(String var1) {
      this.bietraentInfoLivraison = var1;
   }

   public int getBietraentModeLivraison() {
      return this.bietraentModeLivraison;
   }

   public void setBietraentModeLivraison(int var1) {
      this.bietraentModeLivraison = var1;
   }

   public String getBietraentObservationLivraison() {
      return this.bietraentObservationLivraison;
   }

   public void setBietraentObservationLivraison(String var1) {
      this.bietraentObservationLivraison = var1;
   }

   public int getBietraentPhase() {
      return this.bietraentPhase;
   }

   public void setBietraentPhase(int var1) {
      this.bietraentPhase = var1;
   }

   public String getBietraentTelephoneLivraison() {
      return this.bietraentTelephoneLivraison;
   }

   public void setBietraentTelephoneLivraison(String var1) {
      this.bietraentTelephoneLivraison = var1;
   }

   public long getBietraentIdEquipe() {
      return this.bietraentIdEquipe;
   }

   public void setBietraentIdEquipe(long var1) {
      this.bietraentIdEquipe = var1;
   }
}
