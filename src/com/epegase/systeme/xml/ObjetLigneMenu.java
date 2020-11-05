package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetLigneMenu implements Serializable {
   private int indice;
   private String libelle_FR;
   private String libelle_UK;
   private String libelle_SP;
   private String pagemenu;
   private String commande;
   private String type;
   private String genre;
   private boolean acc = false;
   private boolean add = false;
   private boolean dup = false;
   private boolean maj = false;
   private boolean sup = false;
   private boolean imp = false;
   private boolean clo = false;
   private boolean trf = false;

   public String getCommande() {
      return this.commande;
   }

   public void setCommande(String var1) {
      this.commande = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }

   public String getLibelle_FR() {
      return this.libelle_FR;
   }

   public void setLibelle_FR(String var1) {
      this.libelle_FR = var1;
   }

   public String getLibelle_SP() {
      return this.libelle_SP;
   }

   public void setLibelle_SP(String var1) {
      this.libelle_SP = var1;
   }

   public String getLibelle_UK() {
      return this.libelle_UK;
   }

   public void setLibelle_UK(String var1) {
      this.libelle_UK = var1;
   }

   public String getPagemenu() {
      return this.pagemenu;
   }

   public void setPagemenu(String var1) {
      this.pagemenu = var1;
   }

   public String getGenre() {
      return this.genre;
   }

   public void setGenre(String var1) {
      this.genre = var1;
   }

   public String getType() {
      return this.type;
   }

   public void setType(String var1) {
      this.type = var1;
   }

   public boolean isAcc() {
      return this.acc;
   }

   public void setAcc(boolean var1) {
      this.acc = var1;
   }

   public boolean isAdd() {
      return this.add;
   }

   public void setAdd(boolean var1) {
      this.add = var1;
   }

   public boolean isClo() {
      return this.clo;
   }

   public void setClo(boolean var1) {
      this.clo = var1;
   }

   public boolean isDup() {
      return this.dup;
   }

   public void setDup(boolean var1) {
      this.dup = var1;
   }

   public boolean isImp() {
      return this.imp;
   }

   public void setImp(boolean var1) {
      this.imp = var1;
   }

   public boolean isMaj() {
      return this.maj;
   }

   public void setMaj(boolean var1) {
      this.maj = var1;
   }

   public boolean isSup() {
      return this.sup;
   }

   public void setSup(boolean var1) {
      this.sup = var1;
   }

   public boolean isTrf() {
      return this.trf;
   }

   public void setTrf(boolean var1) {
      this.trf = var1;
   }
}
