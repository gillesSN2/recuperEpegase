package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BienPv implements Serializable {
   private long biepvId;
   private Date biepvDateCreat;
   private Date biepvDateModif;
   private long biepvIdCreateur;
   private String biepvNomCreateur;
   private long biepvIdModif;
   private String biepvNomModif;
   private Date biepvDate;
   private String biepvNum;
   private String biepvBien;
   private String biepvZone;
   private String biepvNomResponsable;
   private long biepvIdResponsable;
   private String biepvNomCommercial;
   private long biepvIdCommercial;
   private String biepvSerie;
   private String biepvObject;
   private String biepvObservation;
   private String biepvSite;
   private String biepvDepartement;
   private String biepvService;
   private String biepvRegion;
   private String biepvSecteur;
   private String biepvPdv;
   private String biepvInfo1;
   private String biepvInfo2;
   private String biepvInfo3;
   private String biepvInfo4;
   private String biepvInfo5;
   private String biepvInfo6;
   private String biepvInfo7;
   private String biepvInfo8;
   private String biepvInfo9;
   private String biepvInfo10;
   private Date biepvDateImp;
   private String biepvModeleImp;
   private int biepvEtatVal;
   private int biepvGele;
   private int biepvEtat;
   private Date biepvDateValidite;
   private Date biepvDateRelance;
   private Date biepvDateValide;
   private Date biepvDateTransforme;
   private int biepvTypeTransforme;
   private Date biepvDateAnnule;
   private String biepvMotifAnnule;
   private String biepvProprietaire;
   private String biepvNomProprietaire;
   private String biepvCivilProprietaire;
   private long biepvIdProprietaire;
   private ExercicesVentes exerciceventes;
   private Users users;
   private String libelleEta;
   private boolean var_select_ligne;
   private String var_nom_proprietaire;

   public String getVar_nom_proprietaire() {
      if (this.biepvCivilProprietaire != null && !this.biepvCivilProprietaire.isEmpty()) {
         this.var_nom_proprietaire = this.biepvCivilProprietaire + " " + this.biepvNomProprietaire;
      } else {
         this.var_nom_proprietaire = this.biepvNomProprietaire;
      }

      return this.var_nom_proprietaire;
   }

   public void setVar_nom_proprietaire(String var1) {
      this.var_nom_proprietaire = var1;
   }

   public String getLibelleEta() {
      if (this.biepvEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.biepvEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.biepvEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.biepvEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.biepvEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.biepvEtat == 5) {
         this.libelleEta = "Trf.T.";
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

   public String getBiepvBien() {
      return this.biepvBien;
   }

   public void setBiepvBien(String var1) {
      this.biepvBien = var1;
   }

   public String getBiepvCivilProprietaire() {
      return this.biepvCivilProprietaire;
   }

   public void setBiepvCivilProprietaire(String var1) {
      this.biepvCivilProprietaire = var1;
   }

   public Date getBiepvDate() {
      return this.biepvDate;
   }

   public void setBiepvDate(Date var1) {
      this.biepvDate = var1;
   }

   public Date getBiepvDateAnnule() {
      return this.biepvDateAnnule;
   }

   public void setBiepvDateAnnule(Date var1) {
      this.biepvDateAnnule = var1;
   }

   public Date getBiepvDateCreat() {
      return this.biepvDateCreat;
   }

   public void setBiepvDateCreat(Date var1) {
      this.biepvDateCreat = var1;
   }

   public Date getBiepvDateImp() {
      return this.biepvDateImp;
   }

   public void setBiepvDateImp(Date var1) {
      this.biepvDateImp = var1;
   }

   public Date getBiepvDateModif() {
      return this.biepvDateModif;
   }

   public void setBiepvDateModif(Date var1) {
      this.biepvDateModif = var1;
   }

   public Date getBiepvDateRelance() {
      return this.biepvDateRelance;
   }

   public void setBiepvDateRelance(Date var1) {
      this.biepvDateRelance = var1;
   }

   public Date getBiepvDateTransforme() {
      return this.biepvDateTransforme;
   }

   public void setBiepvDateTransforme(Date var1) {
      this.biepvDateTransforme = var1;
   }

   public Date getBiepvDateValide() {
      return this.biepvDateValide;
   }

   public void setBiepvDateValide(Date var1) {
      this.biepvDateValide = var1;
   }

   public Date getBiepvDateValidite() {
      return this.biepvDateValidite;
   }

   public void setBiepvDateValidite(Date var1) {
      this.biepvDateValidite = var1;
   }

   public String getBiepvDepartement() {
      return this.biepvDepartement;
   }

   public void setBiepvDepartement(String var1) {
      this.biepvDepartement = var1;
   }

   public int getBiepvEtat() {
      return this.biepvEtat;
   }

   public void setBiepvEtat(int var1) {
      this.biepvEtat = var1;
   }

   public int getBiepvEtatVal() {
      return this.biepvEtatVal;
   }

   public void setBiepvEtatVal(int var1) {
      this.biepvEtatVal = var1;
   }

   public int getBiepvGele() {
      return this.biepvGele;
   }

   public void setBiepvGele(int var1) {
      this.biepvGele = var1;
   }

   public long getBiepvId() {
      return this.biepvId;
   }

   public void setBiepvId(long var1) {
      this.biepvId = var1;
   }

   public long getBiepvIdCommercial() {
      return this.biepvIdCommercial;
   }

   public void setBiepvIdCommercial(long var1) {
      this.biepvIdCommercial = var1;
   }

   public long getBiepvIdCreateur() {
      return this.biepvIdCreateur;
   }

   public void setBiepvIdCreateur(long var1) {
      this.biepvIdCreateur = var1;
   }

   public long getBiepvIdModif() {
      return this.biepvIdModif;
   }

   public void setBiepvIdModif(long var1) {
      this.biepvIdModif = var1;
   }

   public long getBiepvIdProprietaire() {
      return this.biepvIdProprietaire;
   }

   public void setBiepvIdProprietaire(long var1) {
      this.biepvIdProprietaire = var1;
   }

   public long getBiepvIdResponsable() {
      return this.biepvIdResponsable;
   }

   public void setBiepvIdResponsable(long var1) {
      this.biepvIdResponsable = var1;
   }

   public String getBiepvInfo1() {
      return this.biepvInfo1;
   }

   public void setBiepvInfo1(String var1) {
      this.biepvInfo1 = var1;
   }

   public String getBiepvInfo10() {
      return this.biepvInfo10;
   }

   public void setBiepvInfo10(String var1) {
      this.biepvInfo10 = var1;
   }

   public String getBiepvInfo2() {
      return this.biepvInfo2;
   }

   public void setBiepvInfo2(String var1) {
      this.biepvInfo2 = var1;
   }

   public String getBiepvInfo3() {
      return this.biepvInfo3;
   }

   public void setBiepvInfo3(String var1) {
      this.biepvInfo3 = var1;
   }

   public String getBiepvInfo4() {
      return this.biepvInfo4;
   }

   public void setBiepvInfo4(String var1) {
      this.biepvInfo4 = var1;
   }

   public String getBiepvInfo5() {
      return this.biepvInfo5;
   }

   public void setBiepvInfo5(String var1) {
      this.biepvInfo5 = var1;
   }

   public String getBiepvInfo6() {
      return this.biepvInfo6;
   }

   public void setBiepvInfo6(String var1) {
      this.biepvInfo6 = var1;
   }

   public String getBiepvInfo7() {
      return this.biepvInfo7;
   }

   public void setBiepvInfo7(String var1) {
      this.biepvInfo7 = var1;
   }

   public String getBiepvInfo8() {
      return this.biepvInfo8;
   }

   public void setBiepvInfo8(String var1) {
      this.biepvInfo8 = var1;
   }

   public String getBiepvInfo9() {
      return this.biepvInfo9;
   }

   public void setBiepvInfo9(String var1) {
      this.biepvInfo9 = var1;
   }

   public String getBiepvModeleImp() {
      return this.biepvModeleImp;
   }

   public void setBiepvModeleImp(String var1) {
      this.biepvModeleImp = var1;
   }

   public String getBiepvMotifAnnule() {
      return this.biepvMotifAnnule;
   }

   public void setBiepvMotifAnnule(String var1) {
      this.biepvMotifAnnule = var1;
   }

   public String getBiepvNomCommercial() {
      return this.biepvNomCommercial;
   }

   public void setBiepvNomCommercial(String var1) {
      this.biepvNomCommercial = var1;
   }

   public String getBiepvNomCreateur() {
      return this.biepvNomCreateur;
   }

   public void setBiepvNomCreateur(String var1) {
      this.biepvNomCreateur = var1;
   }

   public String getBiepvNomModif() {
      return this.biepvNomModif;
   }

   public void setBiepvNomModif(String var1) {
      this.biepvNomModif = var1;
   }

   public String getBiepvNomProprietaire() {
      return this.biepvNomProprietaire;
   }

   public void setBiepvNomProprietaire(String var1) {
      this.biepvNomProprietaire = var1;
   }

   public String getBiepvNomResponsable() {
      return this.biepvNomResponsable;
   }

   public void setBiepvNomResponsable(String var1) {
      this.biepvNomResponsable = var1;
   }

   public String getBiepvNum() {
      return this.biepvNum;
   }

   public void setBiepvNum(String var1) {
      this.biepvNum = var1;
   }

   public String getBiepvObject() {
      return this.biepvObject;
   }

   public void setBiepvObject(String var1) {
      this.biepvObject = var1;
   }

   public String getBiepvObservation() {
      return this.biepvObservation;
   }

   public void setBiepvObservation(String var1) {
      this.biepvObservation = var1;
   }

   public String getBiepvPdv() {
      return this.biepvPdv;
   }

   public void setBiepvPdv(String var1) {
      this.biepvPdv = var1;
   }

   public String getBiepvProprietaire() {
      return this.biepvProprietaire;
   }

   public void setBiepvProprietaire(String var1) {
      this.biepvProprietaire = var1;
   }

   public String getBiepvRegion() {
      return this.biepvRegion;
   }

   public void setBiepvRegion(String var1) {
      this.biepvRegion = var1;
   }

   public String getBiepvSecteur() {
      return this.biepvSecteur;
   }

   public void setBiepvSecteur(String var1) {
      this.biepvSecteur = var1;
   }

   public String getBiepvSerie() {
      return this.biepvSerie;
   }

   public void setBiepvSerie(String var1) {
      this.biepvSerie = var1;
   }

   public String getBiepvService() {
      return this.biepvService;
   }

   public void setBiepvService(String var1) {
      this.biepvService = var1;
   }

   public String getBiepvSite() {
      return this.biepvSite;
   }

   public void setBiepvSite(String var1) {
      this.biepvSite = var1;
   }

   public int getBiepvTypeTransforme() {
      return this.biepvTypeTransforme;
   }

   public void setBiepvTypeTransforme(int var1) {
      this.biepvTypeTransforme = var1;
   }

   public String getBiepvZone() {
      return this.biepvZone;
   }

   public void setBiepvZone(String var1) {
      this.biepvZone = var1;
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
}
