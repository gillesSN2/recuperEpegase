package com.epegase.systeme.menu;

import java.io.Serializable;

public class MenudroitXml implements Serializable {
   private String indice;
   private String libelleFR;
   private String libelleUK;
   private String libelleSP;
   private String pagemenu;
   private String commande;
   private String type;
   private String genre;
   private String acc;
   private String add;
   private String dup;
   private String mod;
   private String sup;
   private String imp;
   private String clo;
   private String trf;

   public String getAcc() {
      return this.acc;
   }

   public void setAcc(String var1) {
      this.acc = var1;
   }

   public String getAdd() {
      return this.add;
   }

   public void setAdd(String var1) {
      this.add = var1;
   }

   public String getClo() {
      return this.clo;
   }

   public void setClo(String var1) {
      this.clo = var1;
   }

   public String getCommande() {
      return this.commande;
   }

   public void setCommande(String var1) {
      this.commande = var1;
   }

   public String getDup() {
      return this.dup;
   }

   public void setDup(String var1) {
      this.dup = var1;
   }

   public String getGenre() {
      return this.genre;
   }

   public void setGenre(String var1) {
      this.genre = var1;
   }

   public String getImp() {
      return this.imp;
   }

   public void setImp(String var1) {
      this.imp = var1;
   }

   public String getIndice() {
      return this.indice;
   }

   public void setIndice(String var1) {
      this.indice = var1;
   }

   public String getLibelleFR() {
      return this.libelleFR;
   }

   public void setLibelleFR(String var1) {
      this.libelleFR = var1;
   }

   public String getLibelleSP() {
      return this.libelleSP;
   }

   public void setLibelleSP(String var1) {
      this.libelleSP = var1;
   }

   public String getLibelleUK() {
      return this.libelleUK;
   }

   public void setLibelleUK(String var1) {
      this.libelleUK = var1;
   }

   public String getMod() {
      return this.mod;
   }

   public void setMod(String var1) {
      this.mod = var1;
   }

   public String getPagemenu() {
      return this.pagemenu;
   }

   public void setPagemenu(String var1) {
      this.pagemenu = var1;
   }

   public String getSup() {
      return this.sup;
   }

   public void setSup(String var1) {
      this.sup = var1;
   }

   public String getTrf() {
      return this.trf;
   }

   public void setTrf(String var1) {
      this.trf = var1;
   }

   public String getType() {
      return this.type;
   }

   public void setType(String var1) {
      this.type = var1;
   }
}
