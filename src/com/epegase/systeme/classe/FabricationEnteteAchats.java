package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FabricationEnteteAchats implements Serializable {
   private long fabId;
   private Date fabDateCreat;
   private Date fabDateModif;
   private long fabIdCreateur;
   private String fabNomCreateur;
   private long fabIdModif;
   private String fabNomModif;
   private int fabMode;
   private int fabOption1;
   private int fabOption2;
   private Date fabDate;
   private String fabNum;
   private String fabNumLot;
   private int fabQuart;
   private String fabProcess;
   private String fabCommande;
   private String fabLibClient;
   private String fabLibTech;
   private String fabUnite;
   private String fabCondition;
   private int fabEchelle;
   private String fabDescription;
   private String fabFamille;
   private float fabCoef;
   private float fabQte;
   private float fabQteUtil;
   private float fabQteSur;
   private String fabDepot;
   private int fabStock;
   private String fabNomEquipe;
   private long fabIdEquipe;
   private String fabNomResponsable;
   private long fabIdResponsable;
   private String fabSerie;
   private String fabObject;
   private double fabPump;
   private double fabTotPump;
   private String fabActivite;
   private String fabSite;
   private String fabLigne;
   private String fabAtelier;
   private String fabService;
   private String fabAnal1;
   private String fabAnal2;
   private String fabAnal4;
   private String fabInfo1;
   private String fabInfo2;
   private String fabInfo3;
   private String fabInfo4;
   private String fabInfo5;
   private String fabInfo6;
   private String fabInfo7;
   private String fabInfo8;
   private String fabInfo9;
   private String fabInfo10;
   private Date fabDateImp;
   private String fabModeleImp;
   private int fabEtatVal;
   private int fabGele;
   private int fabEtat;
   private Date fabDateValide;
   private int fabPosSignature;
   private Date fabDateAnnule;
   private String fabMotifAnnule;
   private Date fabDatePeremption;
   private String fabSuffixe;
   private ExercicesAchats exercicesAchats;
   private Users users;
   private String libelleEta;
   private String modeStock;

   public String getModeStock() {
      if (this.fabStock == 0) {
         this.modeStock = "Sans";
      } else if (this.fabStock == 1) {
         this.modeStock = "Simple";
      } else if (this.fabStock == 2) {
         this.modeStock = "LIFO (lot)";
      } else if (this.fabStock == 3) {
         this.modeStock = "FIFO (lot)";
      } else if (this.fabStock == 4) {
         this.modeStock = "Péremption (lot)";
      } else if (this.fabStock == 5) {
         this.modeStock = "Sérialisé";
      }

      return this.modeStock;
   }

   public void setModeStock(String var1) {
      this.modeStock = var1;
   }

   public String getLibelleEta() {
      if (this.fabEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.fabEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.fabEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.fabEtat == 3) {
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

   public String getFabActivite() {
      return this.fabActivite;
   }

   public void setFabActivite(String var1) {
      this.fabActivite = var1;
   }

   public String getFabAnal2() {
      return this.fabAnal2;
   }

   public void setFabAnal2(String var1) {
      this.fabAnal2 = var1;
   }

   public String getFabAnal4() {
      return this.fabAnal4;
   }

   public void setFabAnal4(String var1) {
      this.fabAnal4 = var1;
   }

   public String getFabAtelier() {
      return this.fabAtelier;
   }

   public void setFabAtelier(String var1) {
      this.fabAtelier = var1;
   }

   public String getFabProcess() {
      return this.fabProcess;
   }

   public void setFabProcess(String var1) {
      this.fabProcess = var1;
   }

   public Date getFabDate() {
      return this.fabDate;
   }

   public void setFabDate(Date var1) {
      this.fabDate = var1;
   }

   public Date getFabDateAnnule() {
      return this.fabDateAnnule;
   }

   public void setFabDateAnnule(Date var1) {
      this.fabDateAnnule = var1;
   }

   public Date getFabDateCreat() {
      return this.fabDateCreat;
   }

   public void setFabDateCreat(Date var1) {
      this.fabDateCreat = var1;
   }

   public Date getFabDateImp() {
      return this.fabDateImp;
   }

   public void setFabDateImp(Date var1) {
      this.fabDateImp = var1;
   }

   public Date getFabDateModif() {
      return this.fabDateModif;
   }

   public void setFabDateModif(Date var1) {
      this.fabDateModif = var1;
   }

   public Date getFabDateValide() {
      return this.fabDateValide;
   }

   public void setFabDateValide(Date var1) {
      this.fabDateValide = var1;
   }

   public String getFabDepot() {
      return this.fabDepot;
   }

   public void setFabDepot(String var1) {
      this.fabDepot = var1;
   }

   public int getFabEtat() {
      return this.fabEtat;
   }

   public void setFabEtat(int var1) {
      this.fabEtat = var1;
   }

   public int getFabEtatVal() {
      return this.fabEtatVal;
   }

   public void setFabEtatVal(int var1) {
      this.fabEtatVal = var1;
   }

   public int getFabGele() {
      return this.fabGele;
   }

   public void setFabGele(int var1) {
      this.fabGele = var1;
   }

   public long getFabId() {
      return this.fabId;
   }

   public void setFabId(long var1) {
      this.fabId = var1;
   }

   public long getFabIdCreateur() {
      return this.fabIdCreateur;
   }

   public void setFabIdCreateur(long var1) {
      this.fabIdCreateur = var1;
   }

   public long getFabIdEquipe() {
      return this.fabIdEquipe;
   }

   public void setFabIdEquipe(long var1) {
      this.fabIdEquipe = var1;
   }

   public long getFabIdModif() {
      return this.fabIdModif;
   }

   public void setFabIdModif(long var1) {
      this.fabIdModif = var1;
   }

   public long getFabIdResponsable() {
      return this.fabIdResponsable;
   }

   public void setFabIdResponsable(long var1) {
      this.fabIdResponsable = var1;
   }

   public String getFabInfo1() {
      return this.fabInfo1;
   }

   public void setFabInfo1(String var1) {
      this.fabInfo1 = var1;
   }

   public String getFabInfo10() {
      return this.fabInfo10;
   }

   public void setFabInfo10(String var1) {
      this.fabInfo10 = var1;
   }

   public String getFabInfo2() {
      return this.fabInfo2;
   }

   public void setFabInfo2(String var1) {
      this.fabInfo2 = var1;
   }

   public String getFabInfo3() {
      return this.fabInfo3;
   }

   public void setFabInfo3(String var1) {
      this.fabInfo3 = var1;
   }

   public String getFabInfo4() {
      return this.fabInfo4;
   }

   public void setFabInfo4(String var1) {
      this.fabInfo4 = var1;
   }

   public String getFabInfo5() {
      return this.fabInfo5;
   }

   public void setFabInfo5(String var1) {
      this.fabInfo5 = var1;
   }

   public String getFabInfo6() {
      return this.fabInfo6;
   }

   public void setFabInfo6(String var1) {
      this.fabInfo6 = var1;
   }

   public String getFabInfo7() {
      return this.fabInfo7;
   }

   public void setFabInfo7(String var1) {
      this.fabInfo7 = var1;
   }

   public String getFabInfo8() {
      return this.fabInfo8;
   }

   public void setFabInfo8(String var1) {
      this.fabInfo8 = var1;
   }

   public String getFabInfo9() {
      return this.fabInfo9;
   }

   public void setFabInfo9(String var1) {
      this.fabInfo9 = var1;
   }

   public String getFabLigne() {
      return this.fabLigne;
   }

   public void setFabLigne(String var1) {
      this.fabLigne = var1;
   }

   public String getFabModeleImp() {
      return this.fabModeleImp;
   }

   public void setFabModeleImp(String var1) {
      this.fabModeleImp = var1;
   }

   public String getFabMotifAnnule() {
      return this.fabMotifAnnule;
   }

   public void setFabMotifAnnule(String var1) {
      this.fabMotifAnnule = var1;
   }

   public String getFabNomCreateur() {
      return this.fabNomCreateur;
   }

   public void setFabNomCreateur(String var1) {
      this.fabNomCreateur = var1;
   }

   public String getFabNomEquipe() {
      return this.fabNomEquipe;
   }

   public void setFabNomEquipe(String var1) {
      this.fabNomEquipe = var1;
   }

   public String getFabNomModif() {
      return this.fabNomModif;
   }

   public void setFabNomModif(String var1) {
      this.fabNomModif = var1;
   }

   public String getFabNomResponsable() {
      return this.fabNomResponsable;
   }

   public void setFabNomResponsable(String var1) {
      this.fabNomResponsable = var1;
   }

   public String getFabNum() {
      return this.fabNum;
   }

   public void setFabNum(String var1) {
      this.fabNum = var1;
   }

   public String getFabObject() {
      return this.fabObject;
   }

   public void setFabObject(String var1) {
      this.fabObject = var1;
   }

   public String getFabSerie() {
      return this.fabSerie;
   }

   public void setFabSerie(String var1) {
      this.fabSerie = var1;
   }

   public String getFabSite() {
      return this.fabSite;
   }

   public void setFabSite(String var1) {
      this.fabSite = var1;
   }

   public double getFabTotPump() {
      return this.fabTotPump;
   }

   public void setFabTotPump(double var1) {
      this.fabTotPump = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public int getFabQuart() {
      return this.fabQuart;
   }

   public void setFabQuart(int var1) {
      this.fabQuart = var1;
   }

   public String getFabCommande() {
      return this.fabCommande;
   }

   public void setFabCommande(String var1) {
      this.fabCommande = var1;
   }

   public String getFabLibClient() {
      return this.fabLibClient;
   }

   public void setFabLibClient(String var1) {
      this.fabLibClient = var1;
   }

   public String getFabLibTech() {
      return this.fabLibTech;
   }

   public void setFabLibTech(String var1) {
      this.fabLibTech = var1;
   }

   public String getFabUnite() {
      return this.fabUnite;
   }

   public void setFabUnite(String var1) {
      this.fabUnite = var1;
   }

   public float getFabCoef() {
      return this.fabCoef;
   }

   public void setFabCoef(float var1) {
      this.fabCoef = var1;
   }

   public float getFabQte() {
      return this.fabQte;
   }

   public void setFabQte(float var1) {
      this.fabQte = var1;
   }

   public String getFabFamille() {
      return this.fabFamille;
   }

   public void setFabFamille(String var1) {
      this.fabFamille = var1;
   }

   public int getFabMode() {
      return this.fabMode;
   }

   public void setFabMode(int var1) {
      this.fabMode = var1;
   }

   public int getFabOption1() {
      return this.fabOption1;
   }

   public void setFabOption1(int var1) {
      this.fabOption1 = var1;
   }

   public int getFabPosSignature() {
      return this.fabPosSignature;
   }

   public void setFabPosSignature(int var1) {
      this.fabPosSignature = var1;
   }

   public float getFabQteSur() {
      return this.fabQteSur;
   }

   public void setFabQteSur(float var1) {
      this.fabQteSur = var1;
   }

   public String getFabService() {
      return this.fabService;
   }

   public void setFabService(String var1) {
      this.fabService = var1;
   }

   public int getFabStock() {
      return this.fabStock;
   }

   public void setFabStock(int var1) {
      this.fabStock = var1;
   }

   public Date getFabDatePeremption() {
      return this.fabDatePeremption;
   }

   public void setFabDatePeremption(Date var1) {
      this.fabDatePeremption = var1;
   }

   public String getFabNumLot() {
      return this.fabNumLot;
   }

   public void setFabNumLot(String var1) {
      this.fabNumLot = var1;
   }

   public String getFabCondition() {
      return this.fabCondition;
   }

   public void setFabCondition(String var1) {
      this.fabCondition = var1;
   }

   public int getFabEchelle() {
      return this.fabEchelle;
   }

   public void setFabEchelle(int var1) {
      this.fabEchelle = var1;
   }

   public float getFabQteUtil() {
      return this.fabQteUtil;
   }

   public void setFabQteUtil(float var1) {
      this.fabQteUtil = var1;
   }

   public String getFabDescription() {
      return this.fabDescription;
   }

   public void setFabDescription(String var1) {
      this.fabDescription = var1;
   }

   public String getFabSuffixe() {
      return this.fabSuffixe;
   }

   public void setFabSuffixe(String var1) {
      this.fabSuffixe = var1;
   }

   public int getFabOption2() {
      return this.fabOption2;
   }

   public void setFabOption2(int var1) {
      this.fabOption2 = var1;
   }

   public double getFabPump() {
      return this.fabPump;
   }

   public void setFabPump(double var1) {
      this.fabPump = var1;
   }

   public String getFabAnal1() {
      return this.fabAnal1;
   }

   public void setFabAnal1(String var1) {
      this.fabAnal1 = var1;
   }
}
