package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class InventaireEntete implements Serializable {
   private long invId;
   private Date invDateCreat;
   private Date invDateModif;
   private long invIdCreateur;
   private String invNomCreateur;
   private long invIdModif;
   private String invNomModif;
   private Date invDate;
   private String invNum;
   private int invType;
   private String invDepot;
   private int invMode;
   private String invModeSpecif;
   private String invNomEquipe;
   private long invIdEquipe;
   private String invNomResponsable;
   private long invIdResponsable;
   private String invSerie;
   private String invObject;
   private double invTotPump;
   private String invActivite;
   private String invSite;
   private String invDepartement;
   private String invService;
   private String invRegion;
   private String invSecteur;
   private String invPdv;
   private String invAnal2;
   private String invAnal4;
   private String invInfo1;
   private String invInfo2;
   private String invInfo3;
   private String invInfo4;
   private String invInfo5;
   private String invInfo6;
   private String invInfo7;
   private String invInfo8;
   private String invInfo9;
   private String invInfo10;
   private Date invDateImp;
   private String invModeleImp;
   private int invEtatVal;
   private int invGele;
   private int invEtat;
   private Date invDateValide;
   private int invPosSignature;
   private Date invDateAnnule;
   private String invMotifAnnule;
   private ExercicesAchats exercicesAchats;
   private Users users;
   private String libelleEta;

   public String getLibelleEta() {
      if (this.invEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.invEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.invEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.invEtat == 3) {
         this.libelleEta = "Annul.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public String getInvActivite() {
      return this.invActivite;
   }

   public void setInvActivite(String var1) {
      this.invActivite = var1;
   }

   public String getInvAnal2() {
      return this.invAnal2;
   }

   public void setInvAnal2(String var1) {
      this.invAnal2 = var1;
   }

   public String getInvAnal4() {
      return this.invAnal4;
   }

   public void setInvAnal4(String var1) {
      this.invAnal4 = var1;
   }

   public Date getInvDate() {
      return this.invDate;
   }

   public void setInvDate(Date var1) {
      this.invDate = var1;
   }

   public Date getInvDateCreat() {
      return this.invDateCreat;
   }

   public void setInvDateCreat(Date var1) {
      this.invDateCreat = var1;
   }

   public Date getInvDateImp() {
      return this.invDateImp;
   }

   public void setInvDateImp(Date var1) {
      this.invDateImp = var1;
   }

   public Date getInvDateModif() {
      return this.invDateModif;
   }

   public void setInvDateModif(Date var1) {
      this.invDateModif = var1;
   }

   public Date getInvDateValide() {
      return this.invDateValide;
   }

   public void setInvDateValide(Date var1) {
      this.invDateValide = var1;
   }

   public String getInvDepartement() {
      return this.invDepartement;
   }

   public void setInvDepartement(String var1) {
      this.invDepartement = var1;
   }

   public int getInvEtat() {
      return this.invEtat;
   }

   public void setInvEtat(int var1) {
      this.invEtat = var1;
   }

   public int getInvEtatVal() {
      return this.invEtatVal;
   }

   public void setInvEtatVal(int var1) {
      this.invEtatVal = var1;
   }

   public int getInvGele() {
      return this.invGele;
   }

   public void setInvGele(int var1) {
      this.invGele = var1;
   }

   public long getInvId() {
      return this.invId;
   }

   public void setInvId(long var1) {
      this.invId = var1;
   }

   public long getInvIdCreateur() {
      return this.invIdCreateur;
   }

   public void setInvIdCreateur(long var1) {
      this.invIdCreateur = var1;
   }

   public long getInvIdModif() {
      return this.invIdModif;
   }

   public void setInvIdModif(long var1) {
      this.invIdModif = var1;
   }

   public long getInvIdResponsable() {
      return this.invIdResponsable;
   }

   public void setInvIdResponsable(long var1) {
      this.invIdResponsable = var1;
   }

   public String getInvInfo1() {
      return this.invInfo1;
   }

   public void setInvInfo1(String var1) {
      this.invInfo1 = var1;
   }

   public String getInvInfo10() {
      return this.invInfo10;
   }

   public void setInvInfo10(String var1) {
      this.invInfo10 = var1;
   }

   public String getInvInfo2() {
      return this.invInfo2;
   }

   public void setInvInfo2(String var1) {
      this.invInfo2 = var1;
   }

   public String getInvInfo3() {
      return this.invInfo3;
   }

   public void setInvInfo3(String var1) {
      this.invInfo3 = var1;
   }

   public String getInvInfo4() {
      return this.invInfo4;
   }

   public void setInvInfo4(String var1) {
      this.invInfo4 = var1;
   }

   public String getInvInfo5() {
      return this.invInfo5;
   }

   public void setInvInfo5(String var1) {
      this.invInfo5 = var1;
   }

   public String getInvInfo6() {
      return this.invInfo6;
   }

   public void setInvInfo6(String var1) {
      this.invInfo6 = var1;
   }

   public String getInvInfo7() {
      return this.invInfo7;
   }

   public void setInvInfo7(String var1) {
      this.invInfo7 = var1;
   }

   public String getInvInfo8() {
      return this.invInfo8;
   }

   public void setInvInfo8(String var1) {
      this.invInfo8 = var1;
   }

   public String getInvInfo9() {
      return this.invInfo9;
   }

   public void setInvInfo9(String var1) {
      this.invInfo9 = var1;
   }

   public String getInvModeleImp() {
      return this.invModeleImp;
   }

   public void setInvModeleImp(String var1) {
      this.invModeleImp = var1;
   }

   public String getInvMotifAnnule() {
      return this.invMotifAnnule;
   }

   public void setInvMotifAnnule(String var1) {
      this.invMotifAnnule = var1;
   }

   public String getInvNomCreateur() {
      return this.invNomCreateur;
   }

   public void setInvNomCreateur(String var1) {
      this.invNomCreateur = var1;
   }

   public String getInvNomModif() {
      return this.invNomModif;
   }

   public void setInvNomModif(String var1) {
      this.invNomModif = var1;
   }

   public String getInvNomResponsable() {
      return this.invNomResponsable;
   }

   public void setInvNomResponsable(String var1) {
      this.invNomResponsable = var1;
   }

   public String getInvNum() {
      return this.invNum;
   }

   public void setInvNum(String var1) {
      this.invNum = var1;
   }

   public String getInvObject() {
      return this.invObject;
   }

   public void setInvObject(String var1) {
      this.invObject = var1;
   }

   public String getInvPdv() {
      return this.invPdv;
   }

   public void setInvPdv(String var1) {
      this.invPdv = var1;
   }

   public String getInvRegion() {
      return this.invRegion;
   }

   public void setInvRegion(String var1) {
      this.invRegion = var1;
   }

   public String getInvSecteur() {
      return this.invSecteur;
   }

   public void setInvSecteur(String var1) {
      this.invSecteur = var1;
   }

   public String getInvSerie() {
      return this.invSerie;
   }

   public void setInvSerie(String var1) {
      this.invSerie = var1;
   }

   public String getInvService() {
      return this.invService;
   }

   public void setInvService(String var1) {
      this.invService = var1;
   }

   public String getInvSite() {
      return this.invSite;
   }

   public void setInvSite(String var1) {
      this.invSite = var1;
   }

   public double getInvTotPump() {
      return this.invTotPump;
   }

   public void setInvTotPump(double var1) {
      this.invTotPump = var1;
   }

   public Date getInvDateAnnule() {
      return this.invDateAnnule;
   }

   public void setInvDateAnnule(Date var1) {
      this.invDateAnnule = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public String getInvDepot() {
      return this.invDepot;
   }

   public void setInvDepot(String var1) {
      this.invDepot = var1;
   }

   public int getInvMode() {
      return this.invMode;
   }

   public void setInvMode(int var1) {
      this.invMode = var1;
   }

   public String getInvModeSpecif() {
      return this.invModeSpecif;
   }

   public void setInvModeSpecif(String var1) {
      this.invModeSpecif = var1;
   }

   public int getInvType() {
      return this.invType;
   }

   public void setInvType(int var1) {
      this.invType = var1;
   }

   public long getInvIdEquipe() {
      return this.invIdEquipe;
   }

   public void setInvIdEquipe(long var1) {
      this.invIdEquipe = var1;
   }

   public String getInvNomEquipe() {
      return this.invNomEquipe;
   }

   public void setInvNomEquipe(String var1) {
      this.invNomEquipe = var1;
   }

   public int getInvPosSignature() {
      return this.invPosSignature;
   }

   public void setInvPosSignature(int var1) {
      this.invPosSignature = var1;
   }
}
