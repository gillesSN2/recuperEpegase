package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Taches implements Serializable {
   private long tacId;
   private Date tacDateCreat;
   private Date tacDateModif;
   private long tacUserCreat;
   private long tacUserModif;
   private String tacMission;
   private String tacCode;
   private String tacNomFr;
   private String tacNomUk;
   private String tacNomSp;
   private int tacInactif;
   private float tacValPr;
   private float tacValPv;
   private int tacValJj;
   private int tacValHh;
   private int tacValMm;
   private int tacValSs;
   private String etat;
   private boolean afficheImag;

   public String getTacCode() {
      if (this.tacCode != null && !this.tacCode.isEmpty()) {
         this.tacCode = this.tacCode.toUpperCase();
      }

      return this.tacCode;
   }

   public void setTacCode(String var1) {
      this.tacCode = var1;
   }

   public Date getTacDateCreat() {
      return this.tacDateCreat;
   }

   public void setTacDateCreat(Date var1) {
      this.tacDateCreat = var1;
   }

   public Date getTacDateModif() {
      return this.tacDateModif;
   }

   public void setTacDateModif(Date var1) {
      this.tacDateModif = var1;
   }

   public long getTacId() {
      return this.tacId;
   }

   public void setTacId(long var1) {
      this.tacId = var1;
   }

   public int getTacInactif() {
      return this.tacInactif;
   }

   public void setTacInactif(int var1) {
      this.tacInactif = var1;
   }

   public String getTacNomFr() {
      if (this.tacNomFr != null && !this.tacNomFr.isEmpty()) {
         this.tacNomFr = this.tacNomFr.toUpperCase();
      }

      return this.tacNomFr;
   }

   public void setTacNomFr(String var1) {
      this.tacNomFr = var1;
   }

   public String getTacNomSp() {
      return this.tacNomSp;
   }

   public void setTacNomSp(String var1) {
      this.tacNomSp = var1;
   }

   public String getTacNomUk() {
      return this.tacNomUk;
   }

   public void setTacNomUk(String var1) {
      this.tacNomUk = var1;
   }

   public long getTacUserCreat() {
      return this.tacUserCreat;
   }

   public void setTacUserCreat(long var1) {
      this.tacUserCreat = var1;
   }

   public long getTacUserModif() {
      return this.tacUserModif;
   }

   public void setTacUserModif(long var1) {
      this.tacUserModif = var1;
   }

   public float getTacValPr() {
      return this.tacValPr;
   }

   public void setTacValPr(float var1) {
      this.tacValPr = var1;
   }

   public float getTacValPv() {
      return this.tacValPv;
   }

   public void setTacValPv(float var1) {
      this.tacValPv = var1;
   }

   public String getEtat() {
      if (this.tacInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.tacInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.tacInactif != 1 && this.tacInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public int getTacValHh() {
      return this.tacValHh;
   }

   public void setTacValHh(int var1) {
      this.tacValHh = var1;
   }

   public int getTacValJj() {
      return this.tacValJj;
   }

   public void setTacValJj(int var1) {
      this.tacValJj = var1;
   }

   public int getTacValMm() {
      return this.tacValMm;
   }

   public void setTacValMm(int var1) {
      this.tacValMm = var1;
   }

   public int getTacValSs() {
      return this.tacValSs;
   }

   public void setTacValSs(int var1) {
      this.tacValSs = var1;
   }

   public String getTacMission() {
      return this.tacMission;
   }

   public void setTacMission(String var1) {
      this.tacMission = var1;
   }
}
