package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FamillesParc1 implements Serializable {
   private long famprc1Id;
   private Date famprc1DateCreation;
   private Date famprc1DateModif;
   private long famprc1UserCreation;
   private long famprc1UserModif;
   private int famprc1Nature;
   private String famprc1LibNature;
   private String famprc1Code;
   private String famprc1LibelleFr;
   private String famprc1LibelleUk;
   private String famprc1LibelleSp;
   private int famprc1Inactif;
   private boolean etat;
   private String afficheImag;

   public long getFamprc1Id() {
      return this.famprc1Id;
   }

   public void setFamprc1Id(long var1) {
      this.famprc1Id = var1;
   }

   public String getFamprc1Code() {
      return this.famprc1Code;
   }

   public void setFamprc1Code(String var1) {
      this.famprc1Code = var1;
   }

   public Date getFamprc1DateCreation() {
      return this.famprc1DateCreation;
   }

   public void setFamprc1DateCreation(Date var1) {
      this.famprc1DateCreation = var1;
   }

   public Date getFamprc1DateModif() {
      return this.famprc1DateModif;
   }

   public void setFamprc1DateModif(Date var1) {
      this.famprc1DateModif = var1;
   }

   public int getFamprc1Inactif() {
      return this.famprc1Inactif;
   }

   public void setFamprc1Inactif(int var1) {
      this.famprc1Inactif = var1;
   }

   public String getFamprc1LibelleFr() {
      return this.famprc1LibelleFr;
   }

   public void setFamprc1LibelleFr(String var1) {
      this.famprc1LibelleFr = var1;
   }

   public String getFamprc1LibelleSp() {
      return this.famprc1LibelleSp;
   }

   public void setFamprc1LibelleSp(String var1) {
      this.famprc1LibelleSp = var1;
   }

   public String getFamprc1LibelleUk() {
      return this.famprc1LibelleUk;
   }

   public void setFamprc1LibelleUk(String var1) {
      this.famprc1LibelleUk = var1;
   }

   public int getFamprc1Nature() {
      return this.famprc1Nature;
   }

   public void setFamprc1Nature(int var1) {
      this.famprc1Nature = var1;
   }

   public long getFamprc1UserCreation() {
      return this.famprc1UserCreation;
   }

   public void setFamprc1UserCreation(long var1) {
      this.famprc1UserCreation = var1;
   }

   public long getFamprc1UserModif() {
      return this.famprc1UserModif;
   }

   public void setFamprc1UserModif(long var1) {
      this.famprc1UserModif = var1;
   }

   public String getFamprc1LibNature() {
      return this.famprc1LibNature;
   }

   public void setFamprc1LibNature(String var1) {
      this.famprc1LibNature = var1;
   }

   public boolean isEtat() {
      return this.etat;
   }

   public void setEtat(boolean var1) {
      this.etat = var1;
   }

   public String getAfficheImag() {
      return this.afficheImag;
   }

   public void setAfficheImag(String var1) {
      this.afficheImag = var1;
   }
}
