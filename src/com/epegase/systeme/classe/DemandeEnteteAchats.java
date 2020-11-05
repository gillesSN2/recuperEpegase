package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class DemandeEnteteAchats implements Serializable {
   private long demId;
   private Date demDateCreat;
   private Date demDateModif;
   private long demIdCreateur;
   private String demNomCreateur;
   private long demIdModif;
   private String demNomModif;
   private Date demDate;
   private String demNum;
   private String demNomResponsable;
   private long demIdResponsable;
   private String demSerie;
   private String demObject;
   private String demObservation;
   private String demBudget;
   private double demBudgetDispo;
   private double demBudgetTreso;
   private double demBudgetDispoMois;
   private double demBudgetTresoMois;
   private double demTotHt;
   private double demTotTva;
   private double demTotTc;
   private double demTotTtc;
   private String demActivite;
   private String demSite;
   private String demDepartement;
   private String demService;
   private String demRegion;
   private String demSecteur;
   private String demPdv;
   private String demAnal2;
   private String demAnal4;
   private String demInfo1;
   private String demInfo2;
   private String demInfo3;
   private String demInfo4;
   private String demInfo5;
   private String demInfo6;
   private String demInfo7;
   private String demInfo8;
   private String demInfo9;
   private String demInfo10;
   private String demFormule1;
   private String demFormule2;
   private String demAnnexe1;
   private String demAnnexe2;
   private Date demDateImp;
   private String demModeleImp;
   private int demEtatVal;
   private int demGele;
   private int demEtat;
   private Date demDateValidite;
   private Date demDateRelance;
   private Date demDateValide;
   private int demPosSignature;
   private Date demDateTransforme;
   private int demTypeTransforme;
   private Date demDateAnnule;
   private String demMotifAnnule;
   private String demSource;
   private ExercicesAchats exercicesAchats;
   private Users users;
   private String libelleEta;
   private boolean var_select_ligne;
   private int var_format_devise;
   private Structure structure;
   private String numCmd;
   private Date dateCmd;
   private String numRec;
   private Date dateRec;
   private String numFac;
   private Date dateFac;

   public DemandeEnteteAchats() {
   }

   public DemandeEnteteAchats(Structure var1) {
      this.structure = var1;
   }

   public Date getDateCmd() {
      return this.dateCmd;
   }

   public void setDateCmd(Date var1) {
      this.dateCmd = var1;
   }

   public Date getDateFac() {
      return this.dateFac;
   }

   public void setDateFac(Date var1) {
      this.dateFac = var1;
   }

   public Date getDateRec() {
      return this.dateRec;
   }

   public void setDateRec(Date var1) {
      this.dateRec = var1;
   }

   public String getNumCmd() {
      return this.numCmd;
   }

   public void setNumCmd(String var1) {
      this.numCmd = var1;
   }

   public String getNumFac() {
      return this.numFac;
   }

   public void setNumFac(String var1) {
      this.numFac = var1;
   }

   public String getNumRec() {
      return this.numRec;
   }

   public void setNumRec(String var1) {
      this.numRec = var1;
   }

   public int getVar_format_devise() {
      if (this.structure != null) {
         this.var_format_devise = this.structure.getStrformatdevise();
      } else {
         this.var_format_devise = 0;
      }

      return this.var_format_devise;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public String getLibelleEta() {
      if (this.demEtat == 0) {
         this.libelleEta = "En cours";
      } else if (this.demEtat == 1) {
         this.libelleEta = "Validé";
      } else if (this.demEtat == 2) {
         this.libelleEta = "Transformé";
      } else if (this.demEtat == 3) {
         this.libelleEta = "Annulé";
      } else if (this.demEtat == 4) {
         this.libelleEta = "Gelé";
      } else if (this.demEtat == 5) {
         this.libelleEta = "PrP";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getDemActivite() {
      return this.demActivite;
   }

   public void setDemActivite(String var1) {
      this.demActivite = var1;
   }

   public String getDemAnal2() {
      return this.demAnal2;
   }

   public void setDemAnal2(String var1) {
      this.demAnal2 = var1;
   }

   public String getDemAnal4() {
      return this.demAnal4;
   }

   public void setDemAnal4(String var1) {
      this.demAnal4 = var1;
   }

   public String getDemAnnexe1() {
      return this.demAnnexe1;
   }

   public void setDemAnnexe1(String var1) {
      this.demAnnexe1 = var1;
   }

   public String getDemAnnexe2() {
      return this.demAnnexe2;
   }

   public void setDemAnnexe2(String var1) {
      this.demAnnexe2 = var1;
   }

   public String getDemBudget() {
      return this.demBudget;
   }

   public void setDemBudget(String var1) {
      this.demBudget = var1;
   }

   public double getDemBudgetDispo() {
      return this.demBudgetDispo;
   }

   public void setDemBudgetDispo(double var1) {
      this.demBudgetDispo = var1;
   }

   public double getDemBudgetDispoMois() {
      return this.demBudgetDispoMois;
   }

   public void setDemBudgetDispoMois(double var1) {
      this.demBudgetDispoMois = var1;
   }

   public double getDemBudgetTreso() {
      return this.demBudgetTreso;
   }

   public void setDemBudgetTreso(double var1) {
      this.demBudgetTreso = var1;
   }

   public double getDemBudgetTresoMois() {
      return this.demBudgetTresoMois;
   }

   public void setDemBudgetTresoMois(double var1) {
      this.demBudgetTresoMois = var1;
   }

   public Date getDemDate() {
      return this.demDate;
   }

   public void setDemDate(Date var1) {
      this.demDate = var1;
   }

   public Date getDemDateAnnule() {
      return this.demDateAnnule;
   }

   public void setDemDateAnnule(Date var1) {
      this.demDateAnnule = var1;
   }

   public Date getDemDateCreat() {
      return this.demDateCreat;
   }

   public void setDemDateCreat(Date var1) {
      this.demDateCreat = var1;
   }

   public Date getDemDateImp() {
      return this.demDateImp;
   }

   public void setDemDateImp(Date var1) {
      this.demDateImp = var1;
   }

   public Date getDemDateModif() {
      return this.demDateModif;
   }

   public void setDemDateModif(Date var1) {
      this.demDateModif = var1;
   }

   public Date getDemDateRelance() {
      return this.demDateRelance;
   }

   public void setDemDateRelance(Date var1) {
      this.demDateRelance = var1;
   }

   public Date getDemDateTransforme() {
      return this.demDateTransforme;
   }

   public void setDemDateTransforme(Date var1) {
      this.demDateTransforme = var1;
   }

   public Date getDemDateValide() {
      return this.demDateValide;
   }

   public void setDemDateValide(Date var1) {
      this.demDateValide = var1;
   }

   public Date getDemDateValidite() {
      return this.demDateValidite;
   }

   public void setDemDateValidite(Date var1) {
      this.demDateValidite = var1;
   }

   public String getDemDepartement() {
      return this.demDepartement;
   }

   public void setDemDepartement(String var1) {
      this.demDepartement = var1;
   }

   public int getDemEtat() {
      return this.demEtat;
   }

   public void setDemEtat(int var1) {
      this.demEtat = var1;
   }

   public int getDemEtatVal() {
      return this.demEtatVal;
   }

   public void setDemEtatVal(int var1) {
      this.demEtatVal = var1;
   }

   public String getDemFormule1() {
      return this.demFormule1;
   }

   public void setDemFormule1(String var1) {
      this.demFormule1 = var1;
   }

   public String getDemFormule2() {
      return this.demFormule2;
   }

   public void setDemFormule2(String var1) {
      this.demFormule2 = var1;
   }

   public int getDemGele() {
      return this.demGele;
   }

   public void setDemGele(int var1) {
      this.demGele = var1;
   }

   public long getDemId() {
      return this.demId;
   }

   public void setDemId(long var1) {
      this.demId = var1;
   }

   public long getDemIdCreateur() {
      return this.demIdCreateur;
   }

   public void setDemIdCreateur(long var1) {
      this.demIdCreateur = var1;
   }

   public long getDemIdModif() {
      return this.demIdModif;
   }

   public void setDemIdModif(long var1) {
      this.demIdModif = var1;
   }

   public long getDemIdResponsable() {
      return this.demIdResponsable;
   }

   public void setDemIdResponsable(long var1) {
      this.demIdResponsable = var1;
   }

   public String getDemInfo1() {
      return this.demInfo1;
   }

   public void setDemInfo1(String var1) {
      this.demInfo1 = var1;
   }

   public String getDemInfo10() {
      return this.demInfo10;
   }

   public void setDemInfo10(String var1) {
      this.demInfo10 = var1;
   }

   public String getDemInfo2() {
      return this.demInfo2;
   }

   public void setDemInfo2(String var1) {
      this.demInfo2 = var1;
   }

   public String getDemInfo3() {
      return this.demInfo3;
   }

   public void setDemInfo3(String var1) {
      this.demInfo3 = var1;
   }

   public String getDemInfo4() {
      return this.demInfo4;
   }

   public void setDemInfo4(String var1) {
      this.demInfo4 = var1;
   }

   public String getDemInfo5() {
      return this.demInfo5;
   }

   public void setDemInfo5(String var1) {
      this.demInfo5 = var1;
   }

   public String getDemInfo6() {
      return this.demInfo6;
   }

   public void setDemInfo6(String var1) {
      this.demInfo6 = var1;
   }

   public String getDemInfo7() {
      return this.demInfo7;
   }

   public void setDemInfo7(String var1) {
      this.demInfo7 = var1;
   }

   public String getDemInfo8() {
      return this.demInfo8;
   }

   public void setDemInfo8(String var1) {
      this.demInfo8 = var1;
   }

   public String getDemInfo9() {
      return this.demInfo9;
   }

   public void setDemInfo9(String var1) {
      this.demInfo9 = var1;
   }

   public String getDemModeleImp() {
      return this.demModeleImp;
   }

   public void setDemModeleImp(String var1) {
      this.demModeleImp = var1;
   }

   public String getDemMotifAnnule() {
      return this.demMotifAnnule;
   }

   public void setDemMotifAnnule(String var1) {
      this.demMotifAnnule = var1;
   }

   public String getDemNomCreateur() {
      return this.demNomCreateur;
   }

   public void setDemNomCreateur(String var1) {
      this.demNomCreateur = var1;
   }

   public String getDemNomModif() {
      return this.demNomModif;
   }

   public void setDemNomModif(String var1) {
      this.demNomModif = var1;
   }

   public String getDemNomResponsable() {
      return this.demNomResponsable;
   }

   public void setDemNomResponsable(String var1) {
      this.demNomResponsable = var1;
   }

   public String getDemNum() {
      return this.demNum;
   }

   public void setDemNum(String var1) {
      this.demNum = var1;
   }

   public String getDemObject() {
      return this.demObject;
   }

   public void setDemObject(String var1) {
      this.demObject = var1;
   }

   public String getDemObservation() {
      return this.demObservation;
   }

   public void setDemObservation(String var1) {
      this.demObservation = var1;
   }

   public String getDemPdv() {
      return this.demPdv;
   }

   public void setDemPdv(String var1) {
      this.demPdv = var1;
   }

   public String getDemRegion() {
      return this.demRegion;
   }

   public void setDemRegion(String var1) {
      this.demRegion = var1;
   }

   public String getDemSecteur() {
      return this.demSecteur;
   }

   public void setDemSecteur(String var1) {
      this.demSecteur = var1;
   }

   public String getDemSerie() {
      return this.demSerie;
   }

   public void setDemSerie(String var1) {
      this.demSerie = var1;
   }

   public String getDemService() {
      return this.demService;
   }

   public void setDemService(String var1) {
      this.demService = var1;
   }

   public String getDemSite() {
      return this.demSite;
   }

   public void setDemSite(String var1) {
      this.demSite = var1;
   }

   public double getDemTotHt() {
      return this.demTotHt;
   }

   public void setDemTotHt(double var1) {
      this.demTotHt = var1;
   }

   public double getDemTotTc() {
      return this.demTotTc;
   }

   public void setDemTotTc(double var1) {
      this.demTotTc = var1;
   }

   public double getDemTotTtc() {
      return this.demTotTtc;
   }

   public void setDemTotTtc(double var1) {
      this.demTotTtc = var1;
   }

   public double getDemTotTva() {
      return this.demTotTva;
   }

   public void setDemTotTva(double var1) {
      this.demTotTva = var1;
   }

   public int getDemTypeTransforme() {
      return this.demTypeTransforme;
   }

   public void setDemTypeTransforme(int var1) {
      this.demTypeTransforme = var1;
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

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public int getDemPosSignature() {
      return this.demPosSignature;
   }

   public void setDemPosSignature(int var1) {
      this.demPosSignature = var1;
   }

   public Structure getStructure() {
      return this.structure;
   }

   public void setStructure(Structure var1) {
      this.structure = var1;
   }

   public String getDemSource() {
      return this.demSource;
   }

   public void setDemSource(String var1) {
      this.demSource = var1;
   }
}
