package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CampagneEnteteVentes implements Serializable {
   private long camId;
   private Date camDateCreat;
   private String camNum;
   private String camSerie;
   private int camType;
   private Date camDate;
   private String camObjet;
   private long camIdCreateur;
   private String camNomCreateur;
   private Date camDateModif;
   private long camIdModif;
   private String camNomModif;
   private Date camDateDebut;
   private Date camDateFin;
   private String camDescriptif;
   private String camNomResponsable;
   private long camIdResponsable;
   private String camNomCommercial;
   private long camIdCommercial;
   private String camNomEquipe;
   private long camIdEquipe;
   private double camTotBudget;
   private double camTotDepense;
   private double camTotRecette;
   private double camMarge;
   private String camActivite;
   private String camSite;
   private String camDepartement;
   private String camService;
   private String camAnal2;
   private String camAnal4;
   private Date camDateImp;
   private String camModeleImp;
   private int camEtatVal;
   private int camGele;
   private int camEtat;
   private Date camDateValidite;
   private Date camDateValide;
   private Date camDateAnnule;
   private String camMotifAnnule;
   private Date camDateTransfert;
   private ExercicesVentes exerciceventes;
   private Users users;
   private String libelleEta;
   private double var_marge;
   private boolean var_select_ligne;
   private String nomConcerne;
   private String libelleType;

   public String getLibelleType() {
      if (this.camType == 0) {
         this.libelleType = "Site";
      } else if (this.camType == 1) {
         this.libelleType = "Mail";
      } else if (this.camType == 2) {
         this.libelleType = "Sms";
      } else if (this.camType == 2) {
         this.libelleType = "Mail+Sms";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public String getNomConcerne() {
      if (this.camIdResponsable != 0L) {
         this.nomConcerne = this.camNomResponsable;
      } else {
         this.nomConcerne = this.camNomCommercial;
      }

      return this.nomConcerne;
   }

   public void setNomConcerne(String var1) {
      this.nomConcerne = var1;
   }

   public String getLibelleEta() {
      if (this.camEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.camEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.camEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.camEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.camEtat == 4) {
         this.libelleEta = "Term.";
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

   public double getVar_marge() {
      this.var_marge = this.camTotRecette - this.camTotDepense;
      return this.var_marge;
   }

   public void setVar_marge(double var1) {
      this.var_marge = var1;
   }

   public String getCamActivite() {
      return this.camActivite;
   }

   public void setCamActivite(String var1) {
      this.camActivite = var1;
   }

   public String getCamAnal2() {
      return this.camAnal2;
   }

   public void setCamAnal2(String var1) {
      this.camAnal2 = var1;
   }

   public String getCamAnal4() {
      return this.camAnal4;
   }

   public void setCamAnal4(String var1) {
      this.camAnal4 = var1;
   }

   public Date getCamDate() {
      return this.camDate;
   }

   public void setCamDate(Date var1) {
      this.camDate = var1;
   }

   public Date getCamDateAnnule() {
      return this.camDateAnnule;
   }

   public void setCamDateAnnule(Date var1) {
      this.camDateAnnule = var1;
   }

   public Date getCamDateCreat() {
      return this.camDateCreat;
   }

   public void setCamDateCreat(Date var1) {
      this.camDateCreat = var1;
   }

   public Date getCamDateDebut() {
      return this.camDateDebut;
   }

   public void setCamDateDebut(Date var1) {
      this.camDateDebut = var1;
   }

   public Date getCamDateFin() {
      return this.camDateFin;
   }

   public void setCamDateFin(Date var1) {
      this.camDateFin = var1;
   }

   public Date getCamDateImp() {
      return this.camDateImp;
   }

   public void setCamDateImp(Date var1) {
      this.camDateImp = var1;
   }

   public Date getCamDateModif() {
      return this.camDateModif;
   }

   public void setCamDateModif(Date var1) {
      this.camDateModif = var1;
   }

   public Date getCamDateTransfert() {
      return this.camDateTransfert;
   }

   public void setCamDateTransfert(Date var1) {
      this.camDateTransfert = var1;
   }

   public Date getCamDateValide() {
      return this.camDateValide;
   }

   public void setCamDateValide(Date var1) {
      this.camDateValide = var1;
   }

   public Date getCamDateValidite() {
      return this.camDateValidite;
   }

   public void setCamDateValidite(Date var1) {
      this.camDateValidite = var1;
   }

   public String getCamDepartement() {
      return this.camDepartement;
   }

   public void setCamDepartement(String var1) {
      this.camDepartement = var1;
   }

   public int getCamEtat() {
      return this.camEtat;
   }

   public void setCamEtat(int var1) {
      this.camEtat = var1;
   }

   public int getCamEtatVal() {
      return this.camEtatVal;
   }

   public void setCamEtatVal(int var1) {
      this.camEtatVal = var1;
   }

   public int getCamGele() {
      return this.camGele;
   }

   public void setCamGele(int var1) {
      this.camGele = var1;
   }

   public long getCamId() {
      return this.camId;
   }

   public void setCamId(long var1) {
      this.camId = var1;
   }

   public long getCamIdCommercial() {
      return this.camIdCommercial;
   }

   public void setCamIdCommercial(long var1) {
      this.camIdCommercial = var1;
   }

   public long getCamIdCreateur() {
      return this.camIdCreateur;
   }

   public void setCamIdCreateur(long var1) {
      this.camIdCreateur = var1;
   }

   public long getCamIdEquipe() {
      return this.camIdEquipe;
   }

   public void setCamIdEquipe(long var1) {
      this.camIdEquipe = var1;
   }

   public long getCamIdModif() {
      return this.camIdModif;
   }

   public void setCamIdModif(long var1) {
      this.camIdModif = var1;
   }

   public long getCamIdResponsable() {
      return this.camIdResponsable;
   }

   public void setCamIdResponsable(long var1) {
      this.camIdResponsable = var1;
   }

   public double getCamMarge() {
      return this.camMarge;
   }

   public void setCamMarge(double var1) {
      this.camMarge = var1;
   }

   public String getCamModeleImp() {
      return this.camModeleImp;
   }

   public void setCamModeleImp(String var1) {
      this.camModeleImp = var1;
   }

   public String getCamMotifAnnule() {
      return this.camMotifAnnule;
   }

   public void setCamMotifAnnule(String var1) {
      this.camMotifAnnule = var1;
   }

   public String getCamNomCommercial() {
      return this.camNomCommercial;
   }

   public void setCamNomCommercial(String var1) {
      this.camNomCommercial = var1;
   }

   public String getCamNomCreateur() {
      return this.camNomCreateur;
   }

   public void setCamNomCreateur(String var1) {
      this.camNomCreateur = var1;
   }

   public String getCamNomEquipe() {
      return this.camNomEquipe;
   }

   public void setCamNomEquipe(String var1) {
      this.camNomEquipe = var1;
   }

   public String getCamNomModif() {
      return this.camNomModif;
   }

   public void setCamNomModif(String var1) {
      this.camNomModif = var1;
   }

   public String getCamNomResponsable() {
      return this.camNomResponsable;
   }

   public void setCamNomResponsable(String var1) {
      this.camNomResponsable = var1;
   }

   public String getCamNum() {
      return this.camNum;
   }

   public void setCamNum(String var1) {
      this.camNum = var1;
   }

   public String getCamService() {
      return this.camService;
   }

   public void setCamService(String var1) {
      this.camService = var1;
   }

   public String getCamSite() {
      return this.camSite;
   }

   public void setCamSite(String var1) {
      this.camSite = var1;
   }

   public double getCamTotDepense() {
      return this.camTotDepense;
   }

   public void setCamTotDepense(double var1) {
      this.camTotDepense = var1;
   }

   public double getCamTotRecette() {
      return this.camTotRecette;
   }

   public void setCamTotRecette(double var1) {
      this.camTotRecette = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public String getCamSerie() {
      return this.camSerie;
   }

   public void setCamSerie(String var1) {
      this.camSerie = var1;
   }

   public String getCamObjet() {
      return this.camObjet;
   }

   public void setCamObjet(String var1) {
      this.camObjet = var1;
   }

   public String getCamDescriptif() {
      return this.camDescriptif;
   }

   public void setCamDescriptif(String var1) {
      this.camDescriptif = var1;
   }

   public double getCamTotBudget() {
      return this.camTotBudget;
   }

   public void setCamTotBudget(double var1) {
      this.camTotBudget = var1;
   }

   public int getCamType() {
      return this.camType;
   }

   public void setCamType(int var1) {
      this.camType = var1;
   }
}
