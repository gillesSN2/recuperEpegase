package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BienTravauxLigne implements Serializable {
   private long bietraligId;
   private long bietraligIdTiers;
   private String bietraligCivilTiers;
   private int bietraligTypeTiers;
   private String bietraligNomTiers;
   private String bietraligNumFacture;
   private Date bietraligDateFacture;
   private String bietraligObjetFacture;
   private String bietraligReferenceFacture;
   private double bietraligHt;
   private double bietraligTva;
   private double bietraligTtc;
   private String bietraligScanFacture;
   private long bietraligIdBien;
   private String bietraligCodeGroupe;
   private String bietraligCodeLocal;
   private String bietraligPoste;
   private String bietraligLibellePoste;
   private int bietraligEtat;
   private String bietraligPaiement;
   private Date bietraligDatePaiement;
   private Date bietraligDateImp;
   private String bietraligModeleImp;
   private BienTravauxEntete bienTravauxEntete;
   private Bien bien;
   private String pj;
   private String libelleEtat;
   private String nomPoste;
   private double montantPoste;

   public double getMontantPoste() {
      return this.montantPoste;
   }

   public void setMontantPoste(double var1) {
      this.montantPoste = var1;
   }

   public String getNomPoste() {
      return this.nomPoste;
   }

   public void setNomPoste(String var1) {
      this.nomPoste = var1;
   }

   public Bien getBien() {
      return this.bien;
   }

   public void setBien(Bien var1) {
      this.bien = var1;
   }

   public String getLibelleEtat() {
      if (this.bietraligEtat == 0) {
         this.libelleEtat = "En cours";
      } else if (this.bietraligEtat == 1) {
         this.libelleEtat = "Validé";
      } else if (this.bietraligEtat == 2) {
         this.libelleEtat = "Gelé";
      } else if (this.bietraligEtat == 3) {
         this.libelleEtat = "Annulé";
      } else if (this.bietraligEtat == 4) {
         this.libelleEtat = "Terminé";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public String getPj() {
      if (this.bietraligScanFacture != null && !this.bietraligScanFacture.isEmpty()) {
         this.pj = "/images/mail_pj.png";
      } else {
         this.pj = null;
      }

      return this.pj;
   }

   public void setPj(String var1) {
      this.pj = var1;
   }

   public BienTravauxEntete getBienTravauxEntete() {
      return this.bienTravauxEntete;
   }

   public void setBienTravauxEntete(BienTravauxEntete var1) {
      this.bienTravauxEntete = var1;
   }

   public String getBietraligCivilTiers() {
      return this.bietraligCivilTiers;
   }

   public void setBietraligCivilTiers(String var1) {
      this.bietraligCivilTiers = var1;
   }

   public Date getBietraligDateFacture() {
      return this.bietraligDateFacture;
   }

   public void setBietraligDateFacture(Date var1) {
      this.bietraligDateFacture = var1;
   }

   public double getBietraligHt() {
      return this.bietraligHt;
   }

   public void setBietraligHt(double var1) {
      this.bietraligHt = var1;
   }

   public long getBietraligId() {
      return this.bietraligId;
   }

   public void setBietraligId(long var1) {
      this.bietraligId = var1;
   }

   public long getBietraligIdTiers() {
      return this.bietraligIdTiers;
   }

   public void setBietraligIdTiers(long var1) {
      this.bietraligIdTiers = var1;
   }

   public String getBietraligNomTiers() {
      return this.bietraligNomTiers;
   }

   public void setBietraligNomTiers(String var1) {
      this.bietraligNomTiers = var1;
   }

   public String getBietraligNumFacture() {
      return this.bietraligNumFacture;
   }

   public void setBietraligNumFacture(String var1) {
      this.bietraligNumFacture = var1;
   }

   public String getBietraligObjetFacture() {
      return this.bietraligObjetFacture;
   }

   public void setBietraligObjetFacture(String var1) {
      this.bietraligObjetFacture = var1;
   }

   public double getBietraligTtc() {
      return this.bietraligTtc;
   }

   public void setBietraligTtc(double var1) {
      this.bietraligTtc = var1;
   }

   public double getBietraligTva() {
      return this.bietraligTva;
   }

   public void setBietraligTva(double var1) {
      this.bietraligTva = var1;
   }

   public int getBietraligTypeTiers() {
      return this.bietraligTypeTiers;
   }

   public void setBietraligTypeTiers(int var1) {
      this.bietraligTypeTiers = var1;
   }

   public String getBietraligScanFacture() {
      return this.bietraligScanFacture;
   }

   public void setBietraligScanFacture(String var1) {
      this.bietraligScanFacture = var1;
   }

   public long getBietraligIdBien() {
      return this.bietraligIdBien;
   }

   public void setBietraligIdBien(long var1) {
      this.bietraligIdBien = var1;
   }

   public String getBietraligPoste() {
      return this.bietraligPoste;
   }

   public void setBietraligPoste(String var1) {
      this.bietraligPoste = var1;
   }

   public String getBietraligCodeGroupe() {
      return this.bietraligCodeGroupe;
   }

   public void setBietraligCodeGroupe(String var1) {
      this.bietraligCodeGroupe = var1;
   }

   public int getBietraligEtat() {
      return this.bietraligEtat;
   }

   public void setBietraligEtat(int var1) {
      this.bietraligEtat = var1;
   }

   public String getBietraligPaiement() {
      return this.bietraligPaiement;
   }

   public void setBietraligPaiement(String var1) {
      this.bietraligPaiement = var1;
   }

   public Date getBietraligDatePaiement() {
      return this.bietraligDatePaiement;
   }

   public void setBietraligDatePaiement(Date var1) {
      this.bietraligDatePaiement = var1;
   }

   public Date getBietraligDateImp() {
      return this.bietraligDateImp;
   }

   public void setBietraligDateImp(Date var1) {
      this.bietraligDateImp = var1;
   }

   public String getBietraligModeleImp() {
      return this.bietraligModeleImp;
   }

   public void setBietraligModeleImp(String var1) {
      this.bietraligModeleImp = var1;
   }

   public String getBietraligCodeLocal() {
      return this.bietraligCodeLocal;
   }

   public void setBietraligCodeLocal(String var1) {
      this.bietraligCodeLocal = var1;
   }

   public String getBietraligReferenceFacture() {
      return this.bietraligReferenceFacture;
   }

   public void setBietraligReferenceFacture(String var1) {
      this.bietraligReferenceFacture = var1;
   }

   public String getBietraligLibellePoste() {
      return this.bietraligLibellePoste;
   }

   public void setBietraligLibellePoste(String var1) {
      this.bietraligLibellePoste = var1;
   }
}
