package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Service implements Serializable {
   private long serId;
   private Date serDateCreat;
   private Date serDateModif;
   private long serUserCreat;
   private long serUserModif;
   private String serCode;
   private String serNomFr;
   private String serNomUk;
   private String serNomSp;
   private int serInactif;
   private float serPourcentage;
   private long serIdResponsable;
   private String serNomResponsable;
   private Site site;
   private Departement departement;
   private boolean afficheImag;
   private String etat;
   private boolean select;

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public int getSerInactif() {
      return this.serInactif;
   }

   public void setSerInactif(int var1) {
      this.serInactif = var1;
   }

   public String getEtat() {
      if (this.serInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.serInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.serInactif != 1 && this.serInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public Departement getDepartement() {
      return this.departement;
   }

   public void setDepartement(Departement var1) {
      this.departement = var1;
   }

   public String getSerCode() {
      if (this.serCode != null && !this.serCode.isEmpty()) {
         this.serCode = this.serCode.toUpperCase();
      }

      return this.serCode;
   }

   public void setSerCode(String var1) {
      this.serCode = var1;
   }

   public Date getSerDateCreat() {
      return this.serDateCreat;
   }

   public void setSerDateCreat(Date var1) {
      this.serDateCreat = var1;
   }

   public Date getSerDateModif() {
      return this.serDateModif;
   }

   public void setSerDateModif(Date var1) {
      this.serDateModif = var1;
   }

   public long getSerId() {
      return this.serId;
   }

   public void setSerId(long var1) {
      this.serId = var1;
   }

   public String getSerNomFr() {
      if (this.serNomFr != null && !this.serNomFr.isEmpty()) {
         this.serNomFr = this.serNomFr.toUpperCase();
      }

      return this.serNomFr;
   }

   public void setSerNomFr(String var1) {
      this.serNomFr = var1;
   }

   public String getSerNomSp() {
      return this.serNomSp;
   }

   public void setSerNomSp(String var1) {
      this.serNomSp = var1;
   }

   public String getSerNomUk() {
      return this.serNomUk;
   }

   public void setSerNomUk(String var1) {
      this.serNomUk = var1;
   }

   public long getSerUserModif() {
      return this.serUserModif;
   }

   public void setSerUserModif(long var1) {
      this.serUserModif = var1;
   }

   public long getSerUserCreat() {
      return this.serUserCreat;
   }

   public void setSerUserCreat(long var1) {
      this.serUserCreat = var1;
   }

   public float getSerPourcentage() {
      return this.serPourcentage;
   }

   public void setSerPourcentage(float var1) {
      this.serPourcentage = var1;
   }

   public Site getSite() {
      return this.site;
   }

   public void setSite(Site var1) {
      this.site = var1;
   }

   public long getSerIdResponsable() {
      return this.serIdResponsable;
   }

   public void setSerIdResponsable(long var1) {
      this.serIdResponsable = var1;
   }

   public String getSerNomResponsable() {
      return this.serNomResponsable;
   }

   public void setSerNomResponsable(String var1) {
      this.serNomResponsable = var1;
   }
}
