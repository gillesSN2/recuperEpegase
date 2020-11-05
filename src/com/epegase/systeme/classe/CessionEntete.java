package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CessionEntete implements Serializable {
   private long cesId;
   private Date cesDateCreat;
   private Date cesDateModif;
   private long cesIdCreateur;
   private String cesNomCreateur;
   private long cesIdModif;
   private String cesNomModif;
   private Date cesDate;
   private String cesNum;
   private String cesDepotOrigine;
   private String cesDepotDestination;
   private int cesTypeDepot;
   private String cesSommier;
   private String cesNomEquipe;
   private long cesIdEquipe;
   private String cesNomResponsable;
   private long cesIdResponsable;
   private String cesSerie;
   private String cesObject;
   private double cesTotPump;
   private String cesActivite;
   private String cesSite;
   private String cesDepartement;
   private String cesService;
   private String cesRegion;
   private String cesSecteur;
   private String cesPdv;
   private String cesAnal1;
   private String cesAnal2;
   private String cesAnal4;
   private String cesInfo1;
   private String cesInfo2;
   private String cesInfo3;
   private String cesInfo4;
   private String cesInfo5;
   private String cesInfo6;
   private String cesInfo7;
   private String cesInfo8;
   private String cesInfo9;
   private String cesInfo10;
   private Date cesDateImp;
   private String cesModeleImp;
   private int cesEtatVal;
   private int cesGele;
   private int cesEtat;
   private Date cesDateValide;
   private int cesPosSignature;
   private Date cesDateAnnule;
   private String cesMotifAnnule;
   private ExercicesAchats exercicesAchats;
   private Users users;
   private String libelleEta;
   private String libelleOrigine;
   private String libelleDestination;

   public String getLibelleDestination() {
      return this.libelleDestination;
   }

   public void setLibelleDestination(String var1) {
      this.libelleDestination = var1;
   }

   public String getLibelleOrigine() {
      return this.libelleOrigine;
   }

   public void setLibelleOrigine(String var1) {
      this.libelleOrigine = var1;
   }

   public String getLibelleEta() {
      if (this.cesEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.cesEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.cesEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.cesEtat == 3) {
         this.libelleEta = "Annul.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getCesActivite() {
      return this.cesActivite;
   }

   public void setCesActivite(String var1) {
      this.cesActivite = var1;
   }

   public String getCesAnal2() {
      return this.cesAnal2;
   }

   public void setCesAnal2(String var1) {
      this.cesAnal2 = var1;
   }

   public String getCesAnal4() {
      return this.cesAnal4;
   }

   public void setCesAnal4(String var1) {
      this.cesAnal4 = var1;
   }

   public Date getCesDate() {
      return this.cesDate;
   }

   public void setCesDate(Date var1) {
      this.cesDate = var1;
   }

   public Date getCesDateAnnule() {
      return this.cesDateAnnule;
   }

   public void setCesDateAnnule(Date var1) {
      this.cesDateAnnule = var1;
   }

   public Date getCesDateCreat() {
      return this.cesDateCreat;
   }

   public void setCesDateCreat(Date var1) {
      this.cesDateCreat = var1;
   }

   public Date getCesDateImp() {
      return this.cesDateImp;
   }

   public void setCesDateImp(Date var1) {
      this.cesDateImp = var1;
   }

   public Date getCesDateModif() {
      return this.cesDateModif;
   }

   public void setCesDateModif(Date var1) {
      this.cesDateModif = var1;
   }

   public Date getCesDateValide() {
      return this.cesDateValide;
   }

   public void setCesDateValide(Date var1) {
      this.cesDateValide = var1;
   }

   public String getCesDepartement() {
      return this.cesDepartement;
   }

   public void setCesDepartement(String var1) {
      this.cesDepartement = var1;
   }

   public String getCesDepotDestination() {
      return this.cesDepotDestination;
   }

   public void setCesDepotDestination(String var1) {
      this.cesDepotDestination = var1;
   }

   public String getCesDepotOrigine() {
      return this.cesDepotOrigine;
   }

   public void setCesDepotOrigine(String var1) {
      this.cesDepotOrigine = var1;
   }

   public int getCesEtat() {
      return this.cesEtat;
   }

   public void setCesEtat(int var1) {
      this.cesEtat = var1;
   }

   public int getCesEtatVal() {
      return this.cesEtatVal;
   }

   public void setCesEtatVal(int var1) {
      this.cesEtatVal = var1;
   }

   public int getCesGele() {
      return this.cesGele;
   }

   public void setCesGele(int var1) {
      this.cesGele = var1;
   }

   public long getCesId() {
      return this.cesId;
   }

   public void setCesId(long var1) {
      this.cesId = var1;
   }

   public long getCesIdCreateur() {
      return this.cesIdCreateur;
   }

   public void setCesIdCreateur(long var1) {
      this.cesIdCreateur = var1;
   }

   public long getCesIdModif() {
      return this.cesIdModif;
   }

   public void setCesIdModif(long var1) {
      this.cesIdModif = var1;
   }

   public long getCesIdResponsable() {
      return this.cesIdResponsable;
   }

   public void setCesIdResponsable(long var1) {
      this.cesIdResponsable = var1;
   }

   public String getCesInfo1() {
      return this.cesInfo1;
   }

   public void setCesInfo1(String var1) {
      this.cesInfo1 = var1;
   }

   public String getCesInfo10() {
      return this.cesInfo10;
   }

   public void setCesInfo10(String var1) {
      this.cesInfo10 = var1;
   }

   public String getCesInfo2() {
      return this.cesInfo2;
   }

   public void setCesInfo2(String var1) {
      this.cesInfo2 = var1;
   }

   public String getCesInfo3() {
      return this.cesInfo3;
   }

   public void setCesInfo3(String var1) {
      this.cesInfo3 = var1;
   }

   public String getCesInfo4() {
      return this.cesInfo4;
   }

   public void setCesInfo4(String var1) {
      this.cesInfo4 = var1;
   }

   public String getCesInfo5() {
      return this.cesInfo5;
   }

   public void setCesInfo5(String var1) {
      this.cesInfo5 = var1;
   }

   public String getCesInfo6() {
      return this.cesInfo6;
   }

   public void setCesInfo6(String var1) {
      this.cesInfo6 = var1;
   }

   public String getCesInfo7() {
      return this.cesInfo7;
   }

   public void setCesInfo7(String var1) {
      this.cesInfo7 = var1;
   }

   public String getCesInfo8() {
      return this.cesInfo8;
   }

   public void setCesInfo8(String var1) {
      this.cesInfo8 = var1;
   }

   public String getCesInfo9() {
      return this.cesInfo9;
   }

   public void setCesInfo9(String var1) {
      this.cesInfo9 = var1;
   }

   public String getCesModeleImp() {
      return this.cesModeleImp;
   }

   public void setCesModeleImp(String var1) {
      this.cesModeleImp = var1;
   }

   public String getCesMotifAnnule() {
      return this.cesMotifAnnule;
   }

   public void setCesMotifAnnule(String var1) {
      this.cesMotifAnnule = var1;
   }

   public String getCesNomCreateur() {
      return this.cesNomCreateur;
   }

   public void setCesNomCreateur(String var1) {
      this.cesNomCreateur = var1;
   }

   public String getCesNomModif() {
      return this.cesNomModif;
   }

   public void setCesNomModif(String var1) {
      this.cesNomModif = var1;
   }

   public String getCesNomResponsable() {
      return this.cesNomResponsable;
   }

   public void setCesNomResponsable(String var1) {
      this.cesNomResponsable = var1;
   }

   public String getCesNum() {
      return this.cesNum;
   }

   public void setCesNum(String var1) {
      this.cesNum = var1;
   }

   public String getCesObject() {
      return this.cesObject;
   }

   public void setCesObject(String var1) {
      this.cesObject = var1;
   }

   public String getCesPdv() {
      return this.cesPdv;
   }

   public void setCesPdv(String var1) {
      this.cesPdv = var1;
   }

   public String getCesRegion() {
      return this.cesRegion;
   }

   public void setCesRegion(String var1) {
      this.cesRegion = var1;
   }

   public String getCesSecteur() {
      return this.cesSecteur;
   }

   public void setCesSecteur(String var1) {
      this.cesSecteur = var1;
   }

   public String getCesSerie() {
      return this.cesSerie;
   }

   public void setCesSerie(String var1) {
      this.cesSerie = var1;
   }

   public String getCesService() {
      return this.cesService;
   }

   public void setCesService(String var1) {
      this.cesService = var1;
   }

   public String getCesSite() {
      return this.cesSite;
   }

   public void setCesSite(String var1) {
      this.cesSite = var1;
   }

   public double getCesTotPump() {
      return this.cesTotPump;
   }

   public void setCesTotPump(double var1) {
      this.cesTotPump = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public long getCesIdEquipe() {
      return this.cesIdEquipe;
   }

   public void setCesIdEquipe(long var1) {
      this.cesIdEquipe = var1;
   }

   public String getCesNomEquipe() {
      return this.cesNomEquipe;
   }

   public void setCesNomEquipe(String var1) {
      this.cesNomEquipe = var1;
   }

   public String getCesSommier() {
      return this.cesSommier;
   }

   public void setCesSommier(String var1) {
      this.cesSommier = var1;
   }

   public int getCesTypeDepot() {
      return this.cesTypeDepot;
   }

   public void setCesTypeDepot(int var1) {
      this.cesTypeDepot = var1;
   }

   public int getCesPosSignature() {
      return this.cesPosSignature;
   }

   public void setCesPosSignature(int var1) {
      this.cesPosSignature = var1;
   }

   public String getCesAnal1() {
      return this.cesAnal1;
   }

   public void setCesAnal1(String var1) {
      this.cesAnal1 = var1;
   }
}
