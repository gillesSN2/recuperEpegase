package com.epegase.systeme.classe;

import java.io.Serializable;

public class TicketLigneVentes implements Serializable {
   private long ticligId;
   private String ticligCode;
   private String ticligFamille;
   private String ticligLibelle;
   private String ticligActivite;
   private String ticligTaxe;
   private float ticligTauxTaxe;
   private String ticligDepot;
   private float ticligQte;
   private float ticligQteUtil;
   private int ticligStock;
   private double ticligPu;
   private double ticligPuTtc;
   private float ticligTauxRemise;
   private double ticligPuRem;
   private double ticligPuRemTtc;
   private double ticligPt;
   private double ticligTva;
   private float TicligTauxTc;
   private double ticligTc;
   private double ticligTtc;
   private double ticligPump;
   private float ticligPoidsNet;
   private float ticligPoidsBrut;
   private TicketEnteteVentes ticketEnteteVentes;
   private String photo;

   public String getPhoto() {
      return this.photo;
   }

   public void setPhoto(String var1) {
      this.photo = var1;
   }

   public float getTicligTauxTc() {
      return this.TicligTauxTc;
   }

   public void setTicligTauxTc(float var1) {
      this.TicligTauxTc = var1;
   }

   public TicketEnteteVentes getTicketEnteteVentes() {
      return this.ticketEnteteVentes;
   }

   public void setTicketEnteteVentes(TicketEnteteVentes var1) {
      this.ticketEnteteVentes = var1;
   }

   public String getTicligActivite() {
      return this.ticligActivite;
   }

   public void setTicligActivite(String var1) {
      this.ticligActivite = var1;
   }

   public String getTicligCode() {
      return this.ticligCode;
   }

   public void setTicligCode(String var1) {
      this.ticligCode = var1;
   }

   public String getTicligDepot() {
      return this.ticligDepot;
   }

   public void setTicligDepot(String var1) {
      this.ticligDepot = var1;
   }

   public String getTicligFamille() {
      return this.ticligFamille;
   }

   public void setTicligFamille(String var1) {
      this.ticligFamille = var1;
   }

   public long getTicligId() {
      return this.ticligId;
   }

   public void setTicligId(long var1) {
      this.ticligId = var1;
   }

   public String getTicligLibelle() {
      return this.ticligLibelle;
   }

   public void setTicligLibelle(String var1) {
      this.ticligLibelle = var1;
   }

   public double getTicligPt() {
      return this.ticligPt;
   }

   public void setTicligPt(double var1) {
      this.ticligPt = var1;
   }

   public double getTicligPu() {
      return this.ticligPu;
   }

   public void setTicligPu(double var1) {
      this.ticligPu = var1;
   }

   public double getTicligPuRem() {
      return this.ticligPuRem;
   }

   public void setTicligPuRem(double var1) {
      this.ticligPuRem = var1;
   }

   public double getTicligPuRemTtc() {
      return this.ticligPuRemTtc;
   }

   public void setTicligPuRemTtc(double var1) {
      this.ticligPuRemTtc = var1;
   }

   public double getTicligPuTtc() {
      return this.ticligPuTtc;
   }

   public void setTicligPuTtc(double var1) {
      this.ticligPuTtc = var1;
   }

   public double getTicligPump() {
      return this.ticligPump;
   }

   public void setTicligPump(double var1) {
      this.ticligPump = var1;
   }

   public float getTicligQte() {
      return this.ticligQte;
   }

   public void setTicligQte(float var1) {
      this.ticligQte = var1;
   }

   public float getTicligQteUtil() {
      return this.ticligQteUtil;
   }

   public void setTicligQteUtil(float var1) {
      this.ticligQteUtil = var1;
   }

   public int getTicligStock() {
      return this.ticligStock;
   }

   public void setTicligStock(int var1) {
      this.ticligStock = var1;
   }

   public float getTicligTauxRemise() {
      return this.ticligTauxRemise;
   }

   public void setTicligTauxRemise(float var1) {
      this.ticligTauxRemise = var1;
   }

   public float getTicligTauxTaxe() {
      return this.ticligTauxTaxe;
   }

   public void setTicligTauxTaxe(float var1) {
      this.ticligTauxTaxe = var1;
   }

   public String getTicligTaxe() {
      return this.ticligTaxe;
   }

   public void setTicligTaxe(String var1) {
      this.ticligTaxe = var1;
   }

   public double getTicligTc() {
      return this.ticligTc;
   }

   public void setTicligTc(double var1) {
      this.ticligTc = var1;
   }

   public double getTicligTtc() {
      return this.ticligTtc;
   }

   public void setTicligTtc(double var1) {
      this.ticligTtc = var1;
   }

   public double getTicligTva() {
      return this.ticligTva;
   }

   public void setTicligTva(double var1) {
      this.ticligTva = var1;
   }

   public float getTicligPoidsBrut() {
      return this.ticligPoidsBrut;
   }

   public void setTicligPoidsBrut(float var1) {
      this.ticligPoidsBrut = var1;
   }

   public float getTicligPoidsNet() {
      return this.ticligPoidsNet;
   }

   public void setTicligPoidsNet(float var1) {
      this.ticligPoidsNet = var1;
   }
}
