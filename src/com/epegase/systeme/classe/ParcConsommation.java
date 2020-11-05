package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ParcConsommation implements Serializable {
   private long prcconId;
   private Date prcconDateCreat;
   private Date prcconDateModif;
   private long prcconIdCreateur;
   private String prcconNomCreateur;
   private long prcconIdModif;
   private String prcconNomModif;
   private Date prcconDate;
   private String prcconNum;
   private String prcconNomPompiste;
   private long prcconIdPompiste;
   private String prcconNomDemandeur;
   private long prcconIdDemandeur;
   private int prcconType;
   private String prcconSerie;
   private String prcconDepot;
   private String prcconCode;
   private String prcconLibelle;
   private float prcconQte;
   private double prcconPu;
   private double prcconTotal;
   private String prcconActivite;
   private String prcconSite;
   private String prcconDepartement;
   private String prcconService;
   private String prcconRegion;
   private String prcconSecteur;
   private String prcconPdv;
   private String prcconAnal2;
   private String prcconAnal4;
   private Date prcconDateImp;
   private String prcconModeleImp;
   private int prcconEtatVal;
   private int prcconGele;
   private int prcconEtat;
   private Date prcconDateValide;
   private Date prcconDateAnnule;
   private String prcconMotifAnnule;
   private long prcconCompteur;
   private int prcconTypeCompteur;
   private float prcconPoidsNet;
   private float prcconPoidsBrut;
   private ExercicesParc exercicesParc;
   private Parc parc;
   private String libelleEta;

   public String getLibelleEta() {
      if (this.prcconEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.prcconEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.prcconEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.prcconEtat == 3) {
         this.libelleEta = "Annul.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public ExercicesParc getExercicesParc() {
      return this.exercicesParc;
   }

   public void setExercicesParc(ExercicesParc var1) {
      this.exercicesParc = var1;
   }

   public Parc getParc() {
      return this.parc;
   }

   public void setParc(Parc var1) {
      this.parc = var1;
   }

   public String getPrcconActivite() {
      return this.prcconActivite;
   }

   public void setPrcconActivite(String var1) {
      this.prcconActivite = var1;
   }

   public String getPrcconAnal2() {
      return this.prcconAnal2;
   }

   public void setPrcconAnal2(String var1) {
      this.prcconAnal2 = var1;
   }

   public String getPrcconAnal4() {
      return this.prcconAnal4;
   }

   public void setPrcconAnal4(String var1) {
      this.prcconAnal4 = var1;
   }

   public Date getPrcconDate() {
      return this.prcconDate;
   }

   public void setPrcconDate(Date var1) {
      this.prcconDate = var1;
   }

   public Date getPrcconDateAnnule() {
      return this.prcconDateAnnule;
   }

   public void setPrcconDateAnnule(Date var1) {
      this.prcconDateAnnule = var1;
   }

   public Date getPrcconDateCreat() {
      return this.prcconDateCreat;
   }

   public void setPrcconDateCreat(Date var1) {
      this.prcconDateCreat = var1;
   }

   public Date getPrcconDateImp() {
      return this.prcconDateImp;
   }

   public void setPrcconDateImp(Date var1) {
      this.prcconDateImp = var1;
   }

   public Date getPrcconDateModif() {
      return this.prcconDateModif;
   }

   public void setPrcconDateModif(Date var1) {
      this.prcconDateModif = var1;
   }

   public Date getPrcconDateValide() {
      return this.prcconDateValide;
   }

   public void setPrcconDateValide(Date var1) {
      this.prcconDateValide = var1;
   }

   public String getPrcconDepartement() {
      return this.prcconDepartement;
   }

   public void setPrcconDepartement(String var1) {
      this.prcconDepartement = var1;
   }

   public String getPrcconDepot() {
      return this.prcconDepot;
   }

   public void setPrcconDepot(String var1) {
      this.prcconDepot = var1;
   }

   public int getPrcconEtat() {
      return this.prcconEtat;
   }

   public void setPrcconEtat(int var1) {
      this.prcconEtat = var1;
   }

   public int getPrcconEtatVal() {
      return this.prcconEtatVal;
   }

   public void setPrcconEtatVal(int var1) {
      this.prcconEtatVal = var1;
   }

   public int getPrcconGele() {
      return this.prcconGele;
   }

   public void setPrcconGele(int var1) {
      this.prcconGele = var1;
   }

   public long getPrcconId() {
      return this.prcconId;
   }

   public void setPrcconId(long var1) {
      this.prcconId = var1;
   }

   public long getPrcconIdCreateur() {
      return this.prcconIdCreateur;
   }

   public void setPrcconIdCreateur(long var1) {
      this.prcconIdCreateur = var1;
   }

   public long getPrcconIdDemandeur() {
      return this.prcconIdDemandeur;
   }

   public void setPrcconIdDemandeur(long var1) {
      this.prcconIdDemandeur = var1;
   }

   public long getPrcconIdModif() {
      return this.prcconIdModif;
   }

   public void setPrcconIdModif(long var1) {
      this.prcconIdModif = var1;
   }

   public long getPrcconIdPompiste() {
      return this.prcconIdPompiste;
   }

   public void setPrcconIdPompiste(long var1) {
      this.prcconIdPompiste = var1;
   }

   public String getPrcconModeleImp() {
      return this.prcconModeleImp;
   }

   public void setPrcconModeleImp(String var1) {
      this.prcconModeleImp = var1;
   }

   public String getPrcconMotifAnnule() {
      return this.prcconMotifAnnule;
   }

   public void setPrcconMotifAnnule(String var1) {
      this.prcconMotifAnnule = var1;
   }

   public String getPrcconNomCreateur() {
      return this.prcconNomCreateur;
   }

   public void setPrcconNomCreateur(String var1) {
      this.prcconNomCreateur = var1;
   }

   public String getPrcconNomDemandeur() {
      return this.prcconNomDemandeur;
   }

   public void setPrcconNomDemandeur(String var1) {
      this.prcconNomDemandeur = var1;
   }

   public String getPrcconNomModif() {
      return this.prcconNomModif;
   }

   public void setPrcconNomModif(String var1) {
      this.prcconNomModif = var1;
   }

   public String getPrcconNomPompiste() {
      return this.prcconNomPompiste;
   }

   public void setPrcconNomPompiste(String var1) {
      this.prcconNomPompiste = var1;
   }

   public String getPrcconNum() {
      return this.prcconNum;
   }

   public void setPrcconNum(String var1) {
      this.prcconNum = var1;
   }

   public String getPrcconPdv() {
      return this.prcconPdv;
   }

   public void setPrcconPdv(String var1) {
      this.prcconPdv = var1;
   }

   public double getPrcconPu() {
      return this.prcconPu;
   }

   public void setPrcconPu(double var1) {
      this.prcconPu = var1;
   }

   public float getPrcconQte() {
      return this.prcconQte;
   }

   public void setPrcconQte(float var1) {
      this.prcconQte = var1;
   }

   public String getPrcconRegion() {
      return this.prcconRegion;
   }

   public void setPrcconRegion(String var1) {
      this.prcconRegion = var1;
   }

   public String getPrcconSecteur() {
      return this.prcconSecteur;
   }

   public void setPrcconSecteur(String var1) {
      this.prcconSecteur = var1;
   }

   public String getPrcconSerie() {
      return this.prcconSerie;
   }

   public void setPrcconSerie(String var1) {
      this.prcconSerie = var1;
   }

   public String getPrcconService() {
      return this.prcconService;
   }

   public void setPrcconService(String var1) {
      this.prcconService = var1;
   }

   public String getPrcconSite() {
      return this.prcconSite;
   }

   public void setPrcconSite(String var1) {
      this.prcconSite = var1;
   }

   public double getPrcconTotal() {
      return this.prcconTotal;
   }

   public void setPrcconTotal(double var1) {
      this.prcconTotal = var1;
   }

   public int getPrcconType() {
      return this.prcconType;
   }

   public void setPrcconType(int var1) {
      this.prcconType = var1;
   }

   public String getPrcconCode() {
      return this.prcconCode;
   }

   public void setPrcconCode(String var1) {
      this.prcconCode = var1;
   }

   public String getPrcconLibelle() {
      return this.prcconLibelle;
   }

   public void setPrcconLibelle(String var1) {
      this.prcconLibelle = var1;
   }

   public long getPrcconCompteur() {
      return this.prcconCompteur;
   }

   public void setPrcconCompteur(long var1) {
      this.prcconCompteur = var1;
   }

   public int getPrcconTypeCompteur() {
      return this.prcconTypeCompteur;
   }

   public void setPrcconTypeCompteur(int var1) {
      this.prcconTypeCompteur = var1;
   }

   public float getPrcconPoidsBrut() {
      return this.prcconPoidsBrut;
   }

   public void setPrcconPoidsBrut(float var1) {
      this.prcconPoidsBrut = var1;
   }

   public float getPrcconPoidsNet() {
      return this.prcconPoidsNet;
   }

   public void setPrcconPoidsNet(float var1) {
      this.prcconPoidsNet = var1;
   }
}
