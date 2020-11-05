package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BonSortieEntete implements Serializable {
   private long bouId;
   private Date bouDateCreat;
   private Date bouDateModif;
   private long bouIdCreateur;
   private String bouNomCreateur;
   private long bouIdModif;
   private String bouNomModif;
   private Date bouDate;
   private String bouNum;
   private String bouDepot;
   private String bouNomEquipe;
   private long bouIdEquipe;
   private String bouNomResponsable;
   private long bouIdResponsable;
   private String bouNomDemandeur;
   private long bouIdDemandeur;
   private String bouSerie;
   private String bouObject;
   private double bouTotPump;
   private String bouActivite;
   private String bouSite;
   private String bouDepartement;
   private String bouService;
   private String bouRegion;
   private String bouSecteur;
   private String bouPdv;
   private String bouAnal1;
   private String bouAnal2;
   private String bouAnal4;
   private String bouInfo1;
   private String bouInfo2;
   private String bouInfo3;
   private String bouInfo4;
   private String bouInfo5;
   private String bouInfo6;
   private String bouInfo7;
   private String bouInfo8;
   private String bouInfo9;
   private String bouInfo10;
   private Date bouDateImp;
   private String bouModeleImp;
   private int bouEtatVal;
   private int bouGele;
   private int bouEtat;
   private Date bouDateValide;
   private int bouPosSignature;
   private Date bouDateAnnule;
   private String bouMotifAnnule;
   private ExercicesAchats exercicesAchats;
   private Users users;
   private String libelleEta;

   public String getLibelleEta() {
      if (this.bouEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.bouEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.bouEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.bouEtat == 3) {
         this.libelleEta = "Annul.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getBouActivite() {
      return this.bouActivite;
   }

   public void setBouActivite(String var1) {
      this.bouActivite = var1;
   }

   public String getBouAnal2() {
      return this.bouAnal2;
   }

   public void setBouAnal2(String var1) {
      this.bouAnal2 = var1;
   }

   public String getBouAnal4() {
      return this.bouAnal4;
   }

   public void setBouAnal4(String var1) {
      this.bouAnal4 = var1;
   }

   public Date getBouDate() {
      return this.bouDate;
   }

   public void setBouDate(Date var1) {
      this.bouDate = var1;
   }

   public Date getBouDateAnnule() {
      return this.bouDateAnnule;
   }

   public void setBouDateAnnule(Date var1) {
      this.bouDateAnnule = var1;
   }

   public Date getBouDateCreat() {
      return this.bouDateCreat;
   }

   public void setBouDateCreat(Date var1) {
      this.bouDateCreat = var1;
   }

   public Date getBouDateImp() {
      return this.bouDateImp;
   }

   public void setBouDateImp(Date var1) {
      this.bouDateImp = var1;
   }

   public Date getBouDateModif() {
      return this.bouDateModif;
   }

   public void setBouDateModif(Date var1) {
      this.bouDateModif = var1;
   }

   public Date getBouDateValide() {
      return this.bouDateValide;
   }

   public void setBouDateValide(Date var1) {
      this.bouDateValide = var1;
   }

   public String getBouDepartement() {
      return this.bouDepartement;
   }

   public void setBouDepartement(String var1) {
      this.bouDepartement = var1;
   }

   public String getBouDepot() {
      return this.bouDepot;
   }

   public void setBouDepot(String var1) {
      this.bouDepot = var1;
   }

   public int getBouEtat() {
      return this.bouEtat;
   }

   public void setBouEtat(int var1) {
      this.bouEtat = var1;
   }

   public int getBouEtatVal() {
      return this.bouEtatVal;
   }

   public void setBouEtatVal(int var1) {
      this.bouEtatVal = var1;
   }

   public int getBouGele() {
      return this.bouGele;
   }

   public void setBouGele(int var1) {
      this.bouGele = var1;
   }

   public long getBouId() {
      return this.bouId;
   }

   public void setBouId(long var1) {
      this.bouId = var1;
   }

   public long getBouIdCreateur() {
      return this.bouIdCreateur;
   }

   public void setBouIdCreateur(long var1) {
      this.bouIdCreateur = var1;
   }

   public long getBouIdModif() {
      return this.bouIdModif;
   }

   public void setBouIdModif(long var1) {
      this.bouIdModif = var1;
   }

   public long getBouIdResponsable() {
      return this.bouIdResponsable;
   }

   public void setBouIdResponsable(long var1) {
      this.bouIdResponsable = var1;
   }

   public String getBouInfo1() {
      return this.bouInfo1;
   }

   public void setBouInfo1(String var1) {
      this.bouInfo1 = var1;
   }

   public String getBouInfo10() {
      return this.bouInfo10;
   }

   public void setBouInfo10(String var1) {
      this.bouInfo10 = var1;
   }

   public String getBouInfo2() {
      return this.bouInfo2;
   }

   public void setBouInfo2(String var1) {
      this.bouInfo2 = var1;
   }

   public String getBouInfo3() {
      return this.bouInfo3;
   }

   public void setBouInfo3(String var1) {
      this.bouInfo3 = var1;
   }

   public String getBouInfo4() {
      return this.bouInfo4;
   }

   public void setBouInfo4(String var1) {
      this.bouInfo4 = var1;
   }

   public String getBouInfo5() {
      return this.bouInfo5;
   }

   public void setBouInfo5(String var1) {
      this.bouInfo5 = var1;
   }

   public String getBouInfo6() {
      return this.bouInfo6;
   }

   public void setBouInfo6(String var1) {
      this.bouInfo6 = var1;
   }

   public String getBouInfo7() {
      return this.bouInfo7;
   }

   public void setBouInfo7(String var1) {
      this.bouInfo7 = var1;
   }

   public String getBouInfo8() {
      return this.bouInfo8;
   }

   public void setBouInfo8(String var1) {
      this.bouInfo8 = var1;
   }

   public String getBouInfo9() {
      return this.bouInfo9;
   }

   public void setBouInfo9(String var1) {
      this.bouInfo9 = var1;
   }

   public String getBouModeleImp() {
      return this.bouModeleImp;
   }

   public void setBouModeleImp(String var1) {
      this.bouModeleImp = var1;
   }

   public String getBouMotifAnnule() {
      return this.bouMotifAnnule;
   }

   public void setBouMotifAnnule(String var1) {
      this.bouMotifAnnule = var1;
   }

   public String getBouNomCreateur() {
      return this.bouNomCreateur;
   }

   public void setBouNomCreateur(String var1) {
      this.bouNomCreateur = var1;
   }

   public String getBouNomModif() {
      return this.bouNomModif;
   }

   public void setBouNomModif(String var1) {
      this.bouNomModif = var1;
   }

   public String getBouNomResponsable() {
      return this.bouNomResponsable;
   }

   public void setBouNomResponsable(String var1) {
      this.bouNomResponsable = var1;
   }

   public String getBouNum() {
      return this.bouNum;
   }

   public void setBouNum(String var1) {
      this.bouNum = var1;
   }

   public String getBouObject() {
      return this.bouObject;
   }

   public void setBouObject(String var1) {
      this.bouObject = var1;
   }

   public String getBouPdv() {
      return this.bouPdv;
   }

   public void setBouPdv(String var1) {
      this.bouPdv = var1;
   }

   public String getBouRegion() {
      return this.bouRegion;
   }

   public void setBouRegion(String var1) {
      this.bouRegion = var1;
   }

   public String getBouSecteur() {
      return this.bouSecteur;
   }

   public void setBouSecteur(String var1) {
      this.bouSecteur = var1;
   }

   public String getBouSerie() {
      return this.bouSerie;
   }

   public void setBouSerie(String var1) {
      this.bouSerie = var1;
   }

   public String getBouService() {
      return this.bouService;
   }

   public void setBouService(String var1) {
      this.bouService = var1;
   }

   public String getBouSite() {
      return this.bouSite;
   }

   public void setBouSite(String var1) {
      this.bouSite = var1;
   }

   public double getBouTotPump() {
      return this.bouTotPump;
   }

   public void setBouTotPump(double var1) {
      this.bouTotPump = var1;
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

   public long getBouIdDemandeur() {
      return this.bouIdDemandeur;
   }

   public void setBouIdDemandeur(long var1) {
      this.bouIdDemandeur = var1;
   }

   public String getBouNomDemandeur() {
      return this.bouNomDemandeur;
   }

   public void setBouNomDemandeur(String var1) {
      this.bouNomDemandeur = var1;
   }

   public long getBouIdEquipe() {
      return this.bouIdEquipe;
   }

   public void setBouIdEquipe(long var1) {
      this.bouIdEquipe = var1;
   }

   public String getBouNomEquipe() {
      return this.bouNomEquipe;
   }

   public void setBouNomEquipe(String var1) {
      this.bouNomEquipe = var1;
   }

   public int getBouPosSignature() {
      return this.bouPosSignature;
   }

   public void setBouPosSignature(int var1) {
      this.bouPosSignature = var1;
   }

   public String getBouAnal1() {
      return this.bouAnal1;
   }

   public void setBouAnal1(String var1) {
      this.bouAnal1 = var1;
   }
}
