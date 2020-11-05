package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Activites implements Serializable {
   private long actId;
   private Date actDateCreat;
   private Date actDateModif;
   private long actUserCreat;
   private long actUserModif;
   private String actCode;
   private String actNomFr;
   private String actNomUk;
   private String actNomSp;
   private int actInactif;
   private int actAnneeDebut;
   private int actAnneeFin;
   private boolean actVte;
   private boolean actAch;
   private boolean actPrd;
   private boolean actFrg;
   private boolean actInv;
   private boolean actTva;
   private boolean actTax;
   private boolean actSal;
   private int actOptions;
   private long actIdResponsable;
   private String actNomResponsable;
   private String actRegroupement;
   private String actColonne;
   private String actCompteTaxe;
   private float actTauxTaxe;
   private boolean afficheImag;
   private String etat;
   private boolean select_activite = false;
   private String libOptions;

   public String getEtat() {
      if (this.actInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.actInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.actInactif != 1 && this.actInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getLibOptions() {
      if (this.actOptions == 0) {
         this.libOptions = "";
      } else if (this.actOptions == 1) {
         this.libOptions = "N° Contrat";
      } else if (this.actOptions == 2) {
         this.libOptions = "N° Dossier";
      } else if (this.actOptions == 3) {
         this.libOptions = "N° Parc";
      } else if (this.actOptions == 4) {
         this.libOptions = "N° O.R.";
      } else if (this.actOptions == 5) {
         this.libOptions = "N° CMD";
      } else if (this.actOptions == 6) {
         this.libOptions = this.actCompteTaxe;
      } else if (this.actOptions == 7) {
         this.libOptions = "N° Tableau";
      }

      return this.libOptions;
   }

   public void setLibOptions(String var1) {
      this.libOptions = var1;
   }

   public int getActInactif() {
      return this.actInactif;
   }

   public void setActInactif(int var1) {
      this.actInactif = var1;
   }

   public int getActAnneeDebut() {
      return this.actAnneeDebut;
   }

   public void setActAnneeDebut(int var1) {
      this.actAnneeDebut = var1;
   }

   public int getActAnneeFin() {
      return this.actAnneeFin;
   }

   public void setActAnneeFin(int var1) {
      this.actAnneeFin = var1;
   }

   public String getActCode() {
      if (this.actCode != null && !this.actCode.isEmpty()) {
         this.actCode = this.actCode.toUpperCase();
      }

      return this.actCode;
   }

   public void setActCode(String var1) {
      this.actCode = var1;
   }

   public Date getActDateCreat() {
      return this.actDateCreat;
   }

   public void setActDateCreat(Date var1) {
      this.actDateCreat = var1;
   }

   public Date getActDateModif() {
      return this.actDateModif;
   }

   public void setActDateModif(Date var1) {
      this.actDateModif = var1;
   }

   public long getActId() {
      return this.actId;
   }

   public void setActId(long var1) {
      this.actId = var1;
   }

   public String getActNomFr() {
      if (this.actNomFr != null && !this.actNomFr.isEmpty()) {
         this.actNomFr = this.actNomFr.toUpperCase();
      }

      return this.actNomFr;
   }

   public void setActNomFr(String var1) {
      this.actNomFr = var1;
   }

   public String getActNomSp() {
      return this.actNomSp;
   }

   public void setActNomSp(String var1) {
      this.actNomSp = var1;
   }

   public String getActNomUk() {
      return this.actNomUk;
   }

   public void setActNomUk(String var1) {
      this.actNomUk = var1;
   }

   public long getActUserCreat() {
      return this.actUserCreat;
   }

   public void setActUserCreat(long var1) {
      this.actUserCreat = var1;
   }

   public long getActUserModif() {
      return this.actUserModif;
   }

   public void setActUserModif(long var1) {
      this.actUserModif = var1;
   }

   public boolean isSelect_activite() {
      return this.select_activite;
   }

   public void setSelect_activite(boolean var1) {
      this.select_activite = var1;
   }

   public boolean isActAch() {
      return this.actAch;
   }

   public void setActAch(boolean var1) {
      this.actAch = var1;
   }

   public boolean isActFrg() {
      return this.actFrg;
   }

   public void setActFrg(boolean var1) {
      this.actFrg = var1;
   }

   public boolean isActInv() {
      return this.actInv;
   }

   public void setActInv(boolean var1) {
      this.actInv = var1;
   }

   public boolean isActPrd() {
      return this.actPrd;
   }

   public void setActPrd(boolean var1) {
      this.actPrd = var1;
   }

   public boolean isActSal() {
      return this.actSal;
   }

   public void setActSal(boolean var1) {
      this.actSal = var1;
   }

   public boolean isActTax() {
      return this.actTax;
   }

   public void setActTax(boolean var1) {
      this.actTax = var1;
   }

   public boolean isActTva() {
      return this.actTva;
   }

   public void setActTva(boolean var1) {
      this.actTva = var1;
   }

   public boolean isActVte() {
      return this.actVte;
   }

   public void setActVte(boolean var1) {
      this.actVte = var1;
   }

   public int getActOptions() {
      return this.actOptions;
   }

   public void setActOptions(int var1) {
      this.actOptions = var1;
   }

   public long getActIdResponsable() {
      return this.actIdResponsable;
   }

   public void setActIdResponsable(long var1) {
      this.actIdResponsable = var1;
   }

   public String getActNomResponsable() {
      return this.actNomResponsable;
   }

   public void setActNomResponsable(String var1) {
      this.actNomResponsable = var1;
   }

   public String getActRegroupement() {
      if (this.actRegroupement != null && !this.actRegroupement.isEmpty()) {
         this.actRegroupement = this.actRegroupement.toUpperCase();
      }

      return this.actRegroupement;
   }

   public void setActRegroupement(String var1) {
      this.actRegroupement = var1;
   }

   public String getActColonne() {
      return this.actColonne;
   }

   public void setActColonne(String var1) {
      this.actColonne = var1;
   }

   public String getActCompteTaxe() {
      return this.actCompteTaxe;
   }

   public void setActCompteTaxe(String var1) {
      this.actCompteTaxe = var1;
   }

   public float getActTauxTaxe() {
      return this.actTauxTaxe;
   }

   public void setActTauxTaxe(float var1) {
      this.actTauxTaxe = var1;
   }
}
