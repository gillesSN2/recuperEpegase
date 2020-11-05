package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ChargementEntete implements Serializable {
   private long chamobId;
   private Date chamobDateCreat;
   private Date chamobDateModif;
   private long chamobUserCreat;
   private String chamobNomUserCreat;
   private long chamobUserModif;
   private String chamobNomUserModif;
   private String chamobNomEquipe;
   private long chamobIdEquipe;
   private String chamobNomResponsable;
   private long chamobIdResponsable;
   private String chamobNomCommercial;
   private long chamobIdCommercial;
   private String chamobCat;
   private Date chamobDate;
   private String chamobNum;
   private String chamobSerie;
   private String chamobParc;
   private String chamobDepotCharg;
   private String chamobObjet;
   private String chamobObservation;
   private int chamobEtatVal;
   private int chamobEtat;
   private Date chamobDateTransforme;
   private Date chamobDateAnnule;
   private String chamobMotifAnnule;
   private String chamobBudget;
   private String chamobContener;
   private String chamobActivite;
   private String chamobSite;
   private String chamobDepartement;
   private String chamobService;
   private String chamobAnal2;
   private String chamobAnal4;
   private double chamobTotHt;
   private double chamobTotRemise;
   private double chamobTotRabais;
   private double chamobTotTva;
   private float chamobTauxTc;
   private double chamobTotTc;
   private double chamobTotTtc;
   private double chamobTotFacture;
   private double chamobTotReglement;
   private int chamobSolde;
   private Date chamobDateImp;
   private String chamobModeleImp;
   private Date chamobDateFacture;
   private Date chamobDateReglement;
   private float chamobPoids;
   private ExercicesVentes exercicesVentes;
   private Users users;
   private String libelleEta;
   private String var_solde;
   private double var_reliquat;
   private boolean var_select_ligne;

   public String getLibelleEta() {
      if (this.chamobEtat == 0) {
         this.libelleEta = "En cours";
      } else if (this.chamobEtat == 1) {
         this.libelleEta = "Validé";
      } else if (this.chamobEtat == 2) {
         this.libelleEta = "Gelé";
      } else if (this.chamobEtat == 3) {
         this.libelleEta = "Annulé";
      } else if (this.chamobEtat == 4) {
         this.libelleEta = "Déchargé";
      } else if (this.chamobEtat == 5) {
         this.libelleEta = "Trf. Cpte";
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
      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.chamobTotFacture - this.chamobTotReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public Date getChamobDate() {
      return this.chamobDate;
   }

   public void setChamobDate(Date var1) {
      this.chamobDate = var1;
   }

   public Date getChamobDateCreat() {
      return this.chamobDateCreat;
   }

   public void setChamobDateCreat(Date var1) {
      this.chamobDateCreat = var1;
   }

   public Date getChamobDateModif() {
      return this.chamobDateModif;
   }

   public void setChamobDateModif(Date var1) {
      this.chamobDateModif = var1;
   }

   public String getChamobDepotCharg() {
      return this.chamobDepotCharg;
   }

   public void setChamobDepotCharg(String var1) {
      this.chamobDepotCharg = var1;
   }

   public long getChamobId() {
      return this.chamobId;
   }

   public void setChamobId(long var1) {
      this.chamobId = var1;
   }

   public String getChamobNum() {
      return this.chamobNum;
   }

   public void setChamobNum(String var1) {
      this.chamobNum = var1;
   }

   public String getChamobObservation() {
      return this.chamobObservation;
   }

   public void setChamobObservation(String var1) {
      this.chamobObservation = var1;
   }

   public String getChamobParc() {
      return this.chamobParc;
   }

   public void setChamobParc(String var1) {
      this.chamobParc = var1;
   }

   public long getChamobUserCreat() {
      return this.chamobUserCreat;
   }

   public void setChamobUserCreat(long var1) {
      this.chamobUserCreat = var1;
   }

   public long getChamobUserModif() {
      return this.chamobUserModif;
   }

   public void setChamobUserModif(long var1) {
      this.chamobUserModif = var1;
   }

   public Date getChamobDateAnnule() {
      return this.chamobDateAnnule;
   }

   public void setChamobDateAnnule(Date var1) {
      this.chamobDateAnnule = var1;
   }

   public Date getChamobDateTransforme() {
      return this.chamobDateTransforme;
   }

   public void setChamobDateTransforme(Date var1) {
      this.chamobDateTransforme = var1;
   }

   public int getChamobEtat() {
      return this.chamobEtat;
   }

   public void setChamobEtat(int var1) {
      this.chamobEtat = var1;
   }

   public int getChamobEtatVal() {
      return this.chamobEtatVal;
   }

   public void setChamobEtatVal(int var1) {
      this.chamobEtatVal = var1;
   }

   public String getChamobMotifAnnule() {
      return this.chamobMotifAnnule;
   }

   public void setChamobMotifAnnule(String var1) {
      this.chamobMotifAnnule = var1;
   }

   public String getChamobActivite() {
      return this.chamobActivite;
   }

   public void setChamobActivite(String var1) {
      this.chamobActivite = var1;
   }

   public String getChamobAnal2() {
      return this.chamobAnal2;
   }

   public void setChamobAnal2(String var1) {
      this.chamobAnal2 = var1;
   }

   public String getChamobAnal4() {
      return this.chamobAnal4;
   }

   public void setChamobAnal4(String var1) {
      this.chamobAnal4 = var1;
   }

   public String getChamobBudget() {
      return this.chamobBudget;
   }

   public void setChamobBudget(String var1) {
      this.chamobBudget = var1;
   }

   public String getChamobDepartement() {
      return this.chamobDepartement;
   }

   public void setChamobDepartement(String var1) {
      this.chamobDepartement = var1;
   }

   public String getChamobService() {
      return this.chamobService;
   }

   public void setChamobService(String var1) {
      this.chamobService = var1;
   }

   public String getChamobSite() {
      return this.chamobSite;
   }

   public void setChamobSite(String var1) {
      this.chamobSite = var1;
   }

   public String getChamobSerie() {
      return this.chamobSerie;
   }

   public void setChamobSerie(String var1) {
      this.chamobSerie = var1;
   }

   public long getChamobIdResponsable() {
      return this.chamobIdResponsable;
   }

   public void setChamobIdResponsable(long var1) {
      this.chamobIdResponsable = var1;
   }

   public String getChamobNomResponsable() {
      return this.chamobNomResponsable;
   }

   public void setChamobNomResponsable(String var1) {
      this.chamobNomResponsable = var1;
   }

   public String getChamobNomUserCreat() {
      return this.chamobNomUserCreat;
   }

   public void setChamobNomUserCreat(String var1) {
      this.chamobNomUserCreat = var1;
   }

   public String getChamobNomUserModif() {
      return this.chamobNomUserModif;
   }

   public void setChamobNomUserModif(String var1) {
      this.chamobNomUserModif = var1;
   }

   public long getChamobIdCommercial() {
      return this.chamobIdCommercial;
   }

   public void setChamobIdCommercial(long var1) {
      this.chamobIdCommercial = var1;
   }

   public String getChamobNomCommercial() {
      return this.chamobNomCommercial;
   }

   public void setChamobNomCommercial(String var1) {
      this.chamobNomCommercial = var1;
   }

   public int getChamobSolde() {
      return this.chamobSolde;
   }

   public void setChamobSolde(int var1) {
      this.chamobSolde = var1;
   }

   public float getChamobTauxTc() {
      return this.chamobTauxTc;
   }

   public void setChamobTauxTc(float var1) {
      this.chamobTauxTc = var1;
   }

   public double getChamobTotHt() {
      return this.chamobTotHt;
   }

   public void setChamobTotHt(double var1) {
      this.chamobTotHt = var1;
   }

   public double getChamobTotRabais() {
      return this.chamobTotRabais;
   }

   public void setChamobTotRabais(double var1) {
      this.chamobTotRabais = var1;
   }

   public double getChamobTotReglement() {
      return this.chamobTotReglement;
   }

   public void setChamobTotReglement(double var1) {
      this.chamobTotReglement = var1;
   }

   public double getChamobTotRemise() {
      return this.chamobTotRemise;
   }

   public void setChamobTotRemise(double var1) {
      this.chamobTotRemise = var1;
   }

   public double getChamobTotTc() {
      return this.chamobTotTc;
   }

   public void setChamobTotTc(double var1) {
      this.chamobTotTc = var1;
   }

   public double getChamobTotTtc() {
      return this.chamobTotTtc;
   }

   public void setChamobTotTtc(double var1) {
      this.chamobTotTtc = var1;
   }

   public double getChamobTotTva() {
      return this.chamobTotTva;
   }

   public void setChamobTotTva(double var1) {
      this.chamobTotTva = var1;
   }

   public String getChamobCat() {
      return this.chamobCat;
   }

   public void setChamobCat(String var1) {
      this.chamobCat = var1;
   }

   public Date getChamobDateImp() {
      return this.chamobDateImp;
   }

   public void setChamobDateImp(Date var1) {
      this.chamobDateImp = var1;
   }

   public String getChamobModeleImp() {
      return this.chamobModeleImp;
   }

   public void setChamobModeleImp(String var1) {
      this.chamobModeleImp = var1;
   }

   public Date getChamobDateFacture() {
      return this.chamobDateFacture;
   }

   public void setChamobDateFacture(Date var1) {
      this.chamobDateFacture = var1;
   }

   public Date getChamobDateReglement() {
      return this.chamobDateReglement;
   }

   public void setChamobDateReglement(Date var1) {
      this.chamobDateReglement = var1;
   }

   public double getChamobTotFacture() {
      return this.chamobTotFacture;
   }

   public void setChamobTotFacture(double var1) {
      this.chamobTotFacture = var1;
   }

   public String getChamobObjet() {
      return this.chamobObjet;
   }

   public void setChamobObjet(String var1) {
      this.chamobObjet = var1;
   }

   public long getChamobIdEquipe() {
      return this.chamobIdEquipe;
   }

   public void setChamobIdEquipe(long var1) {
      this.chamobIdEquipe = var1;
   }

   public String getChamobNomEquipe() {
      return this.chamobNomEquipe;
   }

   public void setChamobNomEquipe(String var1) {
      this.chamobNomEquipe = var1;
   }

   public String getChamobContener() {
      return this.chamobContener;
   }

   public void setChamobContener(String var1) {
      this.chamobContener = var1;
   }

   public float getChamobPoids() {
      return this.chamobPoids;
   }

   public void setChamobPoids(float var1) {
      this.chamobPoids = var1;
   }
}
