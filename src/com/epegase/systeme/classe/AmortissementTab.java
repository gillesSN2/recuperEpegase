package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class AmortissementTab implements Serializable {
   private Long amotabId;
   private Date amotabDateDeb;
   private Date amotabDateFin;
   private double amotabMontant;
   private Date amotabDateTrf;
   private Date amotabDateSortie;
   private double amotabValeur;
   private double amotabValeurCession;
   private double amotabVnc;
   private String amotabSite;
   private String amotabLibSite;
   private String amotabDepartement;
   private String amotabLibDepartement;
   private String amotabService;
   private String amotabLibService;
   private String amotabRegion;
   private String amotabLibRegion;
   private String amotabSecteur;
   private String amotabLibSecteur;
   private String amotabPdv;
   private String amotabLibPdv;
   private String amotabAnal1;
   private String amotabLibAnal1;
   private String amotabAnal2;
   private String amotabLibAnal2;
   private String amotabAnal3;
   private String amotabLibAnal3;
   private String amotabAnal4;
   private String amotabLibAnal4;
   private String amotabActivite;
   private String amotabLibActivite;
   private String amotabProjet;
   private String amotabLibProjet;
   private String amotabBudget;
   private String amotabLibBudget;
   private int amotabMontantForce;
   private Amortissements amortissements;

   public Amortissements getAmortissements() {
      return this.amortissements;
   }

   public void setAmortissements(Amortissements var1) {
      this.amortissements = var1;
   }

   public Date getAmotabDateDeb() {
      return this.amotabDateDeb;
   }

   public void setAmotabDateDeb(Date var1) {
      this.amotabDateDeb = var1;
   }

   public Date getAmotabDateFin() {
      return this.amotabDateFin;
   }

   public void setAmotabDateFin(Date var1) {
      this.amotabDateFin = var1;
   }

   public Long getAmotabId() {
      return this.amotabId;
   }

   public void setAmotabId(Long var1) {
      this.amotabId = var1;
   }

   public double getAmotabMontant() {
      return this.amotabMontant;
   }

   public void setAmotabMontant(double var1) {
      this.amotabMontant = var1;
   }

   public Date getAmotabDateTrf() {
      return this.amotabDateTrf;
   }

   public void setAmotabDateTrf(Date var1) {
      this.amotabDateTrf = var1;
   }

   public double getAmotabValeur() {
      return this.amotabValeur;
   }

   public void setAmotabValeur(double var1) {
      this.amotabValeur = var1;
   }

   public double getAmotabVnc() {
      return this.amotabVnc;
   }

   public void setAmotabVnc(double var1) {
      this.amotabVnc = var1;
   }

   public String getAmotabActivite() {
      return this.amotabActivite;
   }

   public void setAmotabActivite(String var1) {
      this.amotabActivite = var1;
   }

   public String getAmotabAnal1() {
      return this.amotabAnal1;
   }

   public void setAmotabAnal1(String var1) {
      this.amotabAnal1 = var1;
   }

   public String getAmotabAnal2() {
      return this.amotabAnal2;
   }

   public void setAmotabAnal2(String var1) {
      this.amotabAnal2 = var1;
   }

   public String getAmotabAnal3() {
      return this.amotabAnal3;
   }

   public void setAmotabAnal3(String var1) {
      this.amotabAnal3 = var1;
   }

   public String getAmotabAnal4() {
      return this.amotabAnal4;
   }

   public void setAmotabAnal4(String var1) {
      this.amotabAnal4 = var1;
   }

   public String getAmotabBudget() {
      return this.amotabBudget;
   }

   public void setAmotabBudget(String var1) {
      this.amotabBudget = var1;
   }

   public String getAmotabDepartement() {
      return this.amotabDepartement;
   }

   public void setAmotabDepartement(String var1) {
      this.amotabDepartement = var1;
   }

   public String getAmotabLibActivite() {
      return this.amotabLibActivite;
   }

   public void setAmotabLibActivite(String var1) {
      this.amotabLibActivite = var1;
   }

   public String getAmotabLibAnal1() {
      return this.amotabLibAnal1;
   }

   public void setAmotabLibAnal1(String var1) {
      this.amotabLibAnal1 = var1;
   }

   public String getAmotabLibAnal2() {
      return this.amotabLibAnal2;
   }

   public void setAmotabLibAnal2(String var1) {
      this.amotabLibAnal2 = var1;
   }

   public String getAmotabLibAnal3() {
      return this.amotabLibAnal3;
   }

   public void setAmotabLibAnal3(String var1) {
      this.amotabLibAnal3 = var1;
   }

   public String getAmotabLibAnal4() {
      return this.amotabLibAnal4;
   }

   public void setAmotabLibAnal4(String var1) {
      this.amotabLibAnal4 = var1;
   }

   public String getAmotabLibBudget() {
      return this.amotabLibBudget;
   }

   public void setAmotabLibBudget(String var1) {
      this.amotabLibBudget = var1;
   }

   public String getAmotabLibDepartement() {
      return this.amotabLibDepartement;
   }

   public void setAmotabLibDepartement(String var1) {
      this.amotabLibDepartement = var1;
   }

   public String getAmotabLibPdv() {
      return this.amotabLibPdv;
   }

   public void setAmotabLibPdv(String var1) {
      this.amotabLibPdv = var1;
   }

   public String getAmotabLibProjet() {
      return this.amotabLibProjet;
   }

   public void setAmotabLibProjet(String var1) {
      this.amotabLibProjet = var1;
   }

   public String getAmotabLibRegion() {
      return this.amotabLibRegion;
   }

   public void setAmotabLibRegion(String var1) {
      this.amotabLibRegion = var1;
   }

   public String getAmotabLibSecteur() {
      return this.amotabLibSecteur;
   }

   public void setAmotabLibSecteur(String var1) {
      this.amotabLibSecteur = var1;
   }

   public String getAmotabLibService() {
      return this.amotabLibService;
   }

   public void setAmotabLibService(String var1) {
      this.amotabLibService = var1;
   }

   public String getAmotabLibSite() {
      return this.amotabLibSite;
   }

   public void setAmotabLibSite(String var1) {
      this.amotabLibSite = var1;
   }

   public String getAmotabPdv() {
      return this.amotabPdv;
   }

   public void setAmotabPdv(String var1) {
      this.amotabPdv = var1;
   }

   public String getAmotabProjet() {
      return this.amotabProjet;
   }

   public void setAmotabProjet(String var1) {
      this.amotabProjet = var1;
   }

   public String getAmotabRegion() {
      return this.amotabRegion;
   }

   public void setAmotabRegion(String var1) {
      this.amotabRegion = var1;
   }

   public String getAmotabSecteur() {
      return this.amotabSecteur;
   }

   public void setAmotabSecteur(String var1) {
      this.amotabSecteur = var1;
   }

   public String getAmotabService() {
      return this.amotabService;
   }

   public void setAmotabService(String var1) {
      this.amotabService = var1;
   }

   public String getAmotabSite() {
      return this.amotabSite;
   }

   public void setAmotabSite(String var1) {
      this.amotabSite = var1;
   }

   public Date getAmotabDateSortie() {
      return this.amotabDateSortie;
   }

   public void setAmotabDateSortie(Date var1) {
      this.amotabDateSortie = var1;
   }

   public double getAmotabValeurCession() {
      return this.amotabValeurCession;
   }

   public void setAmotabValeurCession(double var1) {
      this.amotabValeurCession = var1;
   }

   public int getAmotabMontantForce() {
      return this.amotabMontantForce;
   }

   public void setAmotabMontantForce(int var1) {
      this.amotabMontantForce = var1;
   }
}
