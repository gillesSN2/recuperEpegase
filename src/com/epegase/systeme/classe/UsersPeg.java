package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class UsersPeg implements Serializable {
   private long usrid;
   private Date usrdatecreat;
   private Date usrdatemodif;
   private String usrlangue;
   private String usrfonction;
   private String usradresse;
   private int usrcabinet;
   private String usrcollaboration;
   private String usrbp;
   private String usrville;
   private String usrnompays;
   private String usrtelbureau;
   private String usrteldomicile;
   private String usrmail;
   private int usretat;
   private String usrnom;
   private String usrprenom;
   private String usrlogin;
   private String usrpw;
   private String usrcodesecret;
   private int usrconnexion;
   private int usrsysteme;
   private StructurePeg structurePeg;
   private CabinetPeg cabinetPeg;
   private String color;

   public String getColor() {
      if (this.usrcabinet == 1) {
         this.color = "color:blue";
      } else {
         this.color = "color:black";
      }

      return this.color;
   }

   public void setColor(String var1) {
      this.color = var1;
   }

   public StructurePeg getStructurePeg() {
      return this.structurePeg;
   }

   public void setStructurePeg(StructurePeg var1) {
      this.structurePeg = var1;
   }

   public CabinetPeg getCabinetPeg() {
      return this.cabinetPeg;
   }

   public void setCabinetPeg(CabinetPeg var1) {
      this.cabinetPeg = var1;
   }

   public String getUsradresse() {
      return this.usradresse;
   }

   public void setUsradresse(String var1) {
      this.usradresse = var1;
   }

   public String getUsrbp() {
      return this.usrbp;
   }

   public void setUsrbp(String var1) {
      this.usrbp = var1;
   }

   public String getUsrcodesecret() {
      return this.usrcodesecret;
   }

   public void setUsrcodesecret(String var1) {
      this.usrcodesecret = var1;
   }

   public String getUsrcollaboration() {
      return this.usrcollaboration;
   }

   public void setUsrcollaboration(String var1) {
      this.usrcollaboration = var1;
   }

   public int getUsrconnexion() {
      return this.usrconnexion;
   }

   public void setUsrconnexion(int var1) {
      this.usrconnexion = var1;
   }

   public Date getUsrdatecreat() {
      return this.usrdatecreat;
   }

   public void setUsrdatecreat(Date var1) {
      this.usrdatecreat = var1;
   }

   public Date getUsrdatemodif() {
      return this.usrdatemodif;
   }

   public void setUsrdatemodif(Date var1) {
      this.usrdatemodif = var1;
   }

   public int getUsretat() {
      return this.usretat;
   }

   public void setUsretat(int var1) {
      this.usretat = var1;
   }

   public String getUsrfonction() {
      return this.usrfonction;
   }

   public void setUsrfonction(String var1) {
      this.usrfonction = var1;
   }

   public long getUsrid() {
      return this.usrid;
   }

   public void setUsrid(long var1) {
      this.usrid = var1;
   }

   public String getUsrlangue() {
      return this.usrlangue;
   }

   public void setUsrlangue(String var1) {
      this.usrlangue = var1;
   }

   public String getUsrlogin() {
      return this.usrlogin;
   }

   public void setUsrlogin(String var1) {
      this.usrlogin = var1;
   }

   public String getUsrmail() {
      return this.usrmail;
   }

   public void setUsrmail(String var1) {
      this.usrmail = var1;
   }

   public String getUsrnom() {
      return this.usrnom;
   }

   public void setUsrnom(String var1) {
      this.usrnom = var1;
   }

   public String getUsrnompays() {
      return this.usrnompays;
   }

   public void setUsrnompays(String var1) {
      this.usrnompays = var1;
   }

   public String getUsrprenom() {
      return this.usrprenom;
   }

   public void setUsrprenom(String var1) {
      this.usrprenom = var1;
   }

   public String getUsrpw() {
      return this.usrpw;
   }

   public void setUsrpw(String var1) {
      this.usrpw = var1;
   }

   public int getUsrsysteme() {
      return this.usrsysteme;
   }

   public void setUsrsysteme(int var1) {
      this.usrsysteme = var1;
   }

   public String getUsrtelbureau() {
      return this.usrtelbureau;
   }

   public void setUsrtelbureau(String var1) {
      this.usrtelbureau = var1;
   }

   public String getUsrteldomicile() {
      return this.usrteldomicile;
   }

   public void setUsrteldomicile(String var1) {
      this.usrteldomicile = var1;
   }

   public String getUsrville() {
      return this.usrville;
   }

   public void setUsrville(String var1) {
      this.usrville = var1;
   }

   public int getUsrcabinet() {
      return this.usrcabinet;
   }

   public void setUsrcabinet(int var1) {
      this.usrcabinet = var1;
   }
}
