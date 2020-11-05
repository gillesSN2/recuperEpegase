package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Quartier implements Serializable {
   private long quaId;
   private Date quaDateCreat;
   private Date quaDateModif;
   private long quaUserCreat;
   private long quaUserModif;
   private String quaCode;
   private String quaNomFr;
   private String quaNomUk;
   private String quaNomSp;
   private int quaInactif;
   private float quaPourcentage;
   private long quaIdResponsable;
   private String quaNomResponsable;
   private Region region;
   private Secteur secteur;
   private PointDeVente pointDeVente;
   private Ville ville;
   private boolean afficheImag;
   private String etat;

   public boolean isAfficheImag() {
      if (this.quaInactif != 1 && this.quaInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getEtat() {
      if (this.quaInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.quaInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public PointDeVente getPointDeVente() {
      return this.pointDeVente;
   }

   public void setPointDeVente(PointDeVente var1) {
      this.pointDeVente = var1;
   }

   public Region getRegion() {
      return this.region;
   }

   public void setRegion(Region var1) {
      this.region = var1;
   }

   public Secteur getSecteur() {
      return this.secteur;
   }

   public void setSecteur(Secteur var1) {
      this.secteur = var1;
   }

   public Ville getVille() {
      return this.ville;
   }

   public void setVille(Ville var1) {
      this.ville = var1;
   }

   public String getQuaCode() {
      return this.quaCode;
   }

   public void setQuaCode(String var1) {
      this.quaCode = var1;
   }

   public Date getQuaDateCreat() {
      return this.quaDateCreat;
   }

   public void setQuaDateCreat(Date var1) {
      this.quaDateCreat = var1;
   }

   public Date getQuaDateModif() {
      return this.quaDateModif;
   }

   public void setQuaDateModif(Date var1) {
      this.quaDateModif = var1;
   }

   public long getQuaId() {
      return this.quaId;
   }

   public void setQuaId(long var1) {
      this.quaId = var1;
   }

   public long getQuaIdResponsable() {
      return this.quaIdResponsable;
   }

   public void setQuaIdResponsable(long var1) {
      this.quaIdResponsable = var1;
   }

   public int getQuaInactif() {
      return this.quaInactif;
   }

   public void setQuaInactif(int var1) {
      this.quaInactif = var1;
   }

   public String getQuaNomFr() {
      return this.quaNomFr;
   }

   public void setQuaNomFr(String var1) {
      this.quaNomFr = var1;
   }

   public String getQuaNomResponsable() {
      return this.quaNomResponsable;
   }

   public void setQuaNomResponsable(String var1) {
      this.quaNomResponsable = var1;
   }

   public String getQuaNomSp() {
      return this.quaNomSp;
   }

   public void setQuaNomSp(String var1) {
      this.quaNomSp = var1;
   }

   public String getQuaNomUk() {
      return this.quaNomUk;
   }

   public void setQuaNomUk(String var1) {
      this.quaNomUk = var1;
   }

   public float getQuaPourcentage() {
      return this.quaPourcentage;
   }

   public void setQuaPourcentage(float var1) {
      this.quaPourcentage = var1;
   }

   public long getQuaUserCreat() {
      return this.quaUserCreat;
   }

   public void setQuaUserCreat(long var1) {
      this.quaUserCreat = var1;
   }

   public long getQuaUserModif() {
      return this.quaUserModif;
   }

   public void setQuaUserModif(long var1) {
      this.quaUserModif = var1;
   }
}
