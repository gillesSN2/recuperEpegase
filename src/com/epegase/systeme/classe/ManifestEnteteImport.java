package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ManifestEnteteImport implements Serializable {
   private long vtemanId;
   private String vtemanTypeTransport;
   private String vtemanNum;
   private String vtemanRefNavire;
   private String vtemanLibNavire;
   private String vtemanRefPortDep;
   private String vtemanLibPortDep;
   private String vtemanRefPortArr;
   private String vtemanLibPortArr;
   private Date vtemanDateDep;
   private Date vtemanDateArr;
   private String vtemanRefLieuDep;
   private String vtemanLibLieuDep;
   private String vtemanRefLieuArr;
   private String vtemanLibLieuArr;
   private String vtemanNumBl;
   private String vtemanLoginUser;
   private Date vtemanDateSaisie;
   private Date vtemanDateModification;
   private int vtemanEtat;
   private String vtemanObjet;

   public Date getVtemanDateArr() {
      return this.vtemanDateArr;
   }

   public void setVtemanDateArr(Date var1) {
      this.vtemanDateArr = var1;
   }

   public Date getVtemanDateDep() {
      return this.vtemanDateDep;
   }

   public void setVtemanDateDep(Date var1) {
      this.vtemanDateDep = var1;
   }

   public Date getVtemanDateModification() {
      return this.vtemanDateModification;
   }

   public void setVtemanDateModification(Date var1) {
      this.vtemanDateModification = var1;
   }

   public Date getVtemanDateSaisie() {
      return this.vtemanDateSaisie;
   }

   public void setVtemanDateSaisie(Date var1) {
      this.vtemanDateSaisie = var1;
   }

   public int getVtemanEtat() {
      return this.vtemanEtat;
   }

   public void setVtemanEtat(int var1) {
      this.vtemanEtat = var1;
   }

   public String getVtemanLibLieuArr() {
      return this.vtemanLibLieuArr;
   }

   public void setVtemanLibLieuArr(String var1) {
      this.vtemanLibLieuArr = var1;
   }

   public String getVtemanLibLieuDep() {
      return this.vtemanLibLieuDep;
   }

   public void setVtemanLibLieuDep(String var1) {
      this.vtemanLibLieuDep = var1;
   }

   public String getVtemanLibNavire() {
      return this.vtemanLibNavire;
   }

   public void setVtemanLibNavire(String var1) {
      this.vtemanLibNavire = var1;
   }

   public String getVtemanLibPortArr() {
      return this.vtemanLibPortArr;
   }

   public void setVtemanLibPortArr(String var1) {
      this.vtemanLibPortArr = var1;
   }

   public String getVtemanLibPortDep() {
      return this.vtemanLibPortDep;
   }

   public void setVtemanLibPortDep(String var1) {
      this.vtemanLibPortDep = var1;
   }

   public String getVtemanLoginUser() {
      return this.vtemanLoginUser;
   }

   public void setVtemanLoginUser(String var1) {
      this.vtemanLoginUser = var1;
   }

   public String getVtemanNum() {
      return this.vtemanNum;
   }

   public void setVtemanNum(String var1) {
      this.vtemanNum = var1;
   }

   public String getVtemanNumBl() {
      return this.vtemanNumBl;
   }

   public void setVtemanNumBl(String var1) {
      this.vtemanNumBl = var1;
   }

   public String getVtemanObjet() {
      return this.vtemanObjet;
   }

   public void setVtemanObjet(String var1) {
      this.vtemanObjet = var1;
   }

   public String getVtemanRefLieuArr() {
      return this.vtemanRefLieuArr;
   }

   public void setVtemanRefLieuArr(String var1) {
      this.vtemanRefLieuArr = var1;
   }

   public String getVtemanRefLieuDep() {
      return this.vtemanRefLieuDep;
   }

   public void setVtemanRefLieuDep(String var1) {
      this.vtemanRefLieuDep = var1;
   }

   public String getVtemanRefNavire() {
      return this.vtemanRefNavire;
   }

   public void setVtemanRefNavire(String var1) {
      this.vtemanRefNavire = var1;
   }

   public String getVtemanRefPortArr() {
      return this.vtemanRefPortArr;
   }

   public void setVtemanRefPortArr(String var1) {
      this.vtemanRefPortArr = var1;
   }

   public String getVtemanRefPortDep() {
      return this.vtemanRefPortDep;
   }

   public void setVtemanRefPortDep(String var1) {
      this.vtemanRefPortDep = var1;
   }

   public String getVtemanTypeTransport() {
      return this.vtemanTypeTransport;
   }

   public void setVtemanTypeTransport(String var1) {
      this.vtemanTypeTransport = var1;
   }

   public long getVtemanId() {
      return this.vtemanId;
   }

   public void setVtemanId(long var1) {
      this.vtemanId = var1;
   }
}
