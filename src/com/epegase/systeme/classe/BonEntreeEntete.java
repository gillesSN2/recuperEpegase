package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BonEntreeEntete implements Serializable {
   private long binId;
   private Date binDateCreat;
   private Date binDateModif;
   private long binIdCreateur;
   private String binNomCreateur;
   private long binIdModif;
   private String binNomModif;
   private Date binDate;
   private String binNum;
   private String binContrat;
   private String binDepot;
   private String binNomEquipe;
   private long binIdEquipe;
   private String binNomResponsable;
   private long binIdResponsable;
   private String binNomRapporteur;
   private long binIdRapporteur;
   private String binSerie;
   private String binObject;
   private double binTotPump;
   private String binActivite;
   private String binSite;
   private String binDepartement;
   private String binService;
   private String binRegion;
   private String binSecteur;
   private String binPdv;
   private String binAnal1;
   private String binAnal2;
   private String binAnal4;
   private String binInfo1;
   private String binInfo2;
   private String binInfo3;
   private String binInfo4;
   private String binInfo5;
   private String binInfo6;
   private String binInfo7;
   private String binInfo8;
   private String binInfo9;
   private String binInfo10;
   private Date binDateImp;
   private String binModeleImp;
   private int binEtatVal;
   private int binGele;
   private int binEtat;
   private Date binDateValide;
   private int binPosSignature;
   private Date binDateAnnule;
   private String binMotifAnnule;
   private ExercicesAchats exercicesAchats;
   private Users users;
   private String libelleEta;

   public String getLibelleEta() {
      if (this.binEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.binEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.binEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.binEtat == 3) {
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

   public String getBinActivite() {
      return this.binActivite;
   }

   public void setBinActivite(String var1) {
      this.binActivite = var1;
   }

   public String getBinAnal2() {
      return this.binAnal2;
   }

   public void setBinAnal2(String var1) {
      this.binAnal2 = var1;
   }

   public String getBinAnal4() {
      return this.binAnal4;
   }

   public void setBinAnal4(String var1) {
      this.binAnal4 = var1;
   }

   public Date getBinDate() {
      return this.binDate;
   }

   public void setBinDate(Date var1) {
      this.binDate = var1;
   }

   public Date getBinDateAnnule() {
      return this.binDateAnnule;
   }

   public void setBinDateAnnule(Date var1) {
      this.binDateAnnule = var1;
   }

   public Date getBinDateCreat() {
      return this.binDateCreat;
   }

   public void setBinDateCreat(Date var1) {
      this.binDateCreat = var1;
   }

   public Date getBinDateImp() {
      return this.binDateImp;
   }

   public void setBinDateImp(Date var1) {
      this.binDateImp = var1;
   }

   public Date getBinDateModif() {
      return this.binDateModif;
   }

   public void setBinDateModif(Date var1) {
      this.binDateModif = var1;
   }

   public Date getBinDateValide() {
      return this.binDateValide;
   }

   public void setBinDateValide(Date var1) {
      this.binDateValide = var1;
   }

   public String getBinDepartement() {
      return this.binDepartement;
   }

   public void setBinDepartement(String var1) {
      this.binDepartement = var1;
   }

   public String getBinDepot() {
      return this.binDepot;
   }

   public void setBinDepot(String var1) {
      this.binDepot = var1;
   }

   public int getBinEtat() {
      return this.binEtat;
   }

   public void setBinEtat(int var1) {
      this.binEtat = var1;
   }

   public int getBinEtatVal() {
      return this.binEtatVal;
   }

   public void setBinEtatVal(int var1) {
      this.binEtatVal = var1;
   }

   public int getBinGele() {
      return this.binGele;
   }

   public void setBinGele(int var1) {
      this.binGele = var1;
   }

   public long getBinId() {
      return this.binId;
   }

   public void setBinId(long var1) {
      this.binId = var1;
   }

   public long getBinIdCreateur() {
      return this.binIdCreateur;
   }

   public void setBinIdCreateur(long var1) {
      this.binIdCreateur = var1;
   }

   public long getBinIdModif() {
      return this.binIdModif;
   }

   public void setBinIdModif(long var1) {
      this.binIdModif = var1;
   }

   public long getBinIdResponsable() {
      return this.binIdResponsable;
   }

   public void setBinIdResponsable(long var1) {
      this.binIdResponsable = var1;
   }

   public String getBinInfo1() {
      return this.binInfo1;
   }

   public void setBinInfo1(String var1) {
      this.binInfo1 = var1;
   }

   public String getBinInfo10() {
      return this.binInfo10;
   }

   public void setBinInfo10(String var1) {
      this.binInfo10 = var1;
   }

   public String getBinInfo2() {
      return this.binInfo2;
   }

   public void setBinInfo2(String var1) {
      this.binInfo2 = var1;
   }

   public String getBinInfo3() {
      return this.binInfo3;
   }

   public void setBinInfo3(String var1) {
      this.binInfo3 = var1;
   }

   public String getBinInfo4() {
      return this.binInfo4;
   }

   public void setBinInfo4(String var1) {
      this.binInfo4 = var1;
   }

   public String getBinInfo5() {
      return this.binInfo5;
   }

   public void setBinInfo5(String var1) {
      this.binInfo5 = var1;
   }

   public String getBinInfo6() {
      return this.binInfo6;
   }

   public void setBinInfo6(String var1) {
      this.binInfo6 = var1;
   }

   public String getBinInfo7() {
      return this.binInfo7;
   }

   public void setBinInfo7(String var1) {
      this.binInfo7 = var1;
   }

   public String getBinInfo8() {
      return this.binInfo8;
   }

   public void setBinInfo8(String var1) {
      this.binInfo8 = var1;
   }

   public String getBinInfo9() {
      return this.binInfo9;
   }

   public void setBinInfo9(String var1) {
      this.binInfo9 = var1;
   }

   public String getBinModeleImp() {
      return this.binModeleImp;
   }

   public void setBinModeleImp(String var1) {
      this.binModeleImp = var1;
   }

   public String getBinMotifAnnule() {
      return this.binMotifAnnule;
   }

   public void setBinMotifAnnule(String var1) {
      this.binMotifAnnule = var1;
   }

   public String getBinNomCreateur() {
      return this.binNomCreateur;
   }

   public void setBinNomCreateur(String var1) {
      this.binNomCreateur = var1;
   }

   public String getBinNomModif() {
      return this.binNomModif;
   }

   public void setBinNomModif(String var1) {
      this.binNomModif = var1;
   }

   public String getBinNomResponsable() {
      return this.binNomResponsable;
   }

   public void setBinNomResponsable(String var1) {
      this.binNomResponsable = var1;
   }

   public String getBinNum() {
      return this.binNum;
   }

   public void setBinNum(String var1) {
      this.binNum = var1;
   }

   public String getBinObject() {
      return this.binObject;
   }

   public void setBinObject(String var1) {
      this.binObject = var1;
   }

   public String getBinPdv() {
      return this.binPdv;
   }

   public void setBinPdv(String var1) {
      this.binPdv = var1;
   }

   public String getBinRegion() {
      return this.binRegion;
   }

   public void setBinRegion(String var1) {
      this.binRegion = var1;
   }

   public String getBinSecteur() {
      return this.binSecteur;
   }

   public void setBinSecteur(String var1) {
      this.binSecteur = var1;
   }

   public String getBinSerie() {
      return this.binSerie;
   }

   public void setBinSerie(String var1) {
      this.binSerie = var1;
   }

   public String getBinService() {
      return this.binService;
   }

   public void setBinService(String var1) {
      this.binService = var1;
   }

   public String getBinSite() {
      return this.binSite;
   }

   public void setBinSite(String var1) {
      this.binSite = var1;
   }

   public double getBinTotPump() {
      return this.binTotPump;
   }

   public void setBinTotPump(double var1) {
      this.binTotPump = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public long getBinIdRapporteur() {
      return this.binIdRapporteur;
   }

   public void setBinIdRapporteur(long var1) {
      this.binIdRapporteur = var1;
   }

   public String getBinNomRapporteur() {
      return this.binNomRapporteur;
   }

   public void setBinNomRapporteur(String var1) {
      this.binNomRapporteur = var1;
   }

   public String getBinContrat() {
      return this.binContrat;
   }

   public void setBinContrat(String var1) {
      this.binContrat = var1;
   }

   public long getBinIdEquipe() {
      return this.binIdEquipe;
   }

   public void setBinIdEquipe(long var1) {
      this.binIdEquipe = var1;
   }

   public String getBinNomEquipe() {
      return this.binNomEquipe;
   }

   public void setBinNomEquipe(String var1) {
      this.binNomEquipe = var1;
   }

   public int getBinPosSignature() {
      return this.binPosSignature;
   }

   public void setBinPosSignature(int var1) {
      this.binPosSignature = var1;
   }

   public String getBinAnal1() {
      return this.binAnal1;
   }

   public void setBinAnal1(String var1) {
      this.binAnal1 = var1;
   }
}
