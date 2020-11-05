package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FamillesParc2 implements Serializable {
   private long famprc2Id;
   private Date famprc2DateCreation;
   private Date famprc2DateModif;
   private long famprc2UserCreation;
   private long famprc2UserModif;
   private String famprc2Code;
   private String famprc2LibelleFr;
   private String famprc2LibelleUk;
   private String famprc2LibelleSp;
   private int famprc2Inactif;
   private FamillesParc1 famillesParc1;
   private boolean etat;
   private String afficheImag;

   public FamillesParc1 getFamillesParc1() {
      return this.famillesParc1;
   }

   public void setFamillesParc1(FamillesParc1 var1) {
      this.famillesParc1 = var1;
   }

   public String getFamprc2Code() {
      return this.famprc2Code;
   }

   public void setFamprc2Code(String var1) {
      this.famprc2Code = var1;
   }

   public Date getFamprc2DateCreation() {
      return this.famprc2DateCreation;
   }

   public void setFamprc2DateCreation(Date var1) {
      this.famprc2DateCreation = var1;
   }

   public Date getFamprc2DateModif() {
      return this.famprc2DateModif;
   }

   public void setFamprc2DateModif(Date var1) {
      this.famprc2DateModif = var1;
   }

   public int getFamprc2Inactif() {
      return this.famprc2Inactif;
   }

   public void setFamprc2Inactif(int var1) {
      this.famprc2Inactif = var1;
   }

   public String getFamprc2LibelleFr() {
      return this.famprc2LibelleFr;
   }

   public void setFamprc2LibelleFr(String var1) {
      this.famprc2LibelleFr = var1;
   }

   public String getFamprc2LibelleSp() {
      return this.famprc2LibelleSp;
   }

   public void setFamprc2LibelleSp(String var1) {
      this.famprc2LibelleSp = var1;
   }

   public String getFamprc2LibelleUk() {
      return this.famprc2LibelleUk;
   }

   public void setFamprc2LibelleUk(String var1) {
      this.famprc2LibelleUk = var1;
   }

   public long getFamprc2UserCreation() {
      return this.famprc2UserCreation;
   }

   public void setFamprc2UserCreation(long var1) {
      this.famprc2UserCreation = var1;
   }

   public long getFamprc2UserModif() {
      return this.famprc2UserModif;
   }

   public void setFamprc2UserModif(long var1) {
      this.famprc2UserModif = var1;
   }

   public long getFamprc2Id() {
      return this.famprc2Id;
   }

   public void setFamprc2Id(long var1) {
      this.famprc2Id = var1;
   }

   public String getAfficheImag() {
      return this.afficheImag;
   }

   public void setAfficheImag(String var1) {
      this.afficheImag = var1;
   }

   public boolean isEtat() {
      return this.etat;
   }

   public void setEtat(boolean var1) {
      this.etat = var1;
   }
}
