package com.epegase.systeme.classe;

import java.io.Serializable;

public class ProcessLigneAchats implements Serializable {
   private long procesligId;
   private int procesligType;
   private int procesligOrdre;
   private String procesligCode;
   private String procesligLibClient;
   private String procesligLibTech;
   private String procesligDepot;
   private String procesligUnite;
   private double procesligQte;
   private double procesligQteSur;
   private double procesligPrht;
   private double procesligPvht;
   private int procesligJj;
   private int procesligHh;
   private int procesligMm;
   private int procesligSs;
   private boolean procesligInterChange;
   private String procesligMetier;
   private String procesligMateriel;
   private String procesligProduitInterchangeable;
   private ProcessEnteteAchats processEnteteAchats;

   public ProcessEnteteAchats getProcessEnteteAchats() {
      return this.processEnteteAchats;
   }

   public void setProcessEnteteAchats(ProcessEnteteAchats var1) {
      this.processEnteteAchats = var1;
   }

   public String getProcesligDepot() {
      return this.procesligDepot;
   }

   public void setProcesligDepot(String var1) {
      this.procesligDepot = var1;
   }

   public long getProcesligId() {
      return this.procesligId;
   }

   public void setProcesligId(long var1) {
      this.procesligId = var1;
   }

   public String getProcesligLibClient() {
      return this.procesligLibClient;
   }

   public void setProcesligLibClient(String var1) {
      this.procesligLibClient = var1;
   }

   public String getProcesligLibTech() {
      return this.procesligLibTech;
   }

   public void setProcesligLibTech(String var1) {
      this.procesligLibTech = var1;
   }

   public String getProcesligUnite() {
      return this.procesligUnite;
   }

   public void setProcesligUnite(String var1) {
      this.procesligUnite = var1;
   }

   public String getProcesligCode() {
      return this.procesligCode;
   }

   public void setProcesligCode(String var1) {
      this.procesligCode = var1;
   }

   public int getProcesligType() {
      return this.procesligType;
   }

   public void setProcesligType(int var1) {
      this.procesligType = var1;
   }

   public double getProcesligPrht() {
      return this.procesligPrht;
   }

   public void setProcesligPrht(double var1) {
      this.procesligPrht = var1;
   }

   public double getProcesligPvht() {
      return this.procesligPvht;
   }

   public void setProcesligPvht(double var1) {
      this.procesligPvht = var1;
   }

   public int getProcesligHh() {
      return this.procesligHh;
   }

   public void setProcesligHh(int var1) {
      this.procesligHh = var1;
   }

   public int getProcesligJj() {
      return this.procesligJj;
   }

   public void setProcesligJj(int var1) {
      this.procesligJj = var1;
   }

   public int getProcesligMm() {
      return this.procesligMm;
   }

   public void setProcesligMm(int var1) {
      this.procesligMm = var1;
   }

   public int getProcesligSs() {
      return this.procesligSs;
   }

   public void setProcesligSs(int var1) {
      this.procesligSs = var1;
   }

   public boolean isProcesligInterChange() {
      return this.procesligInterChange;
   }

   public void setProcesligInterChange(boolean var1) {
      this.procesligInterChange = var1;
   }

   public String getProcesligMateriel() {
      return this.procesligMateriel;
   }

   public void setProcesligMateriel(String var1) {
      this.procesligMateriel = var1;
   }

   public String getProcesligMetier() {
      return this.procesligMetier;
   }

   public void setProcesligMetier(String var1) {
      this.procesligMetier = var1;
   }

   public String getProcesligProduitInterchangeable() {
      return this.procesligProduitInterchangeable;
   }

   public void setProcesligProduitInterchangeable(String var1) {
      this.procesligProduitInterchangeable = var1;
   }

   public int getProcesligOrdre() {
      return this.procesligOrdre;
   }

   public void setProcesligOrdre(int var1) {
      this.procesligOrdre = var1;
   }

   public double getProcesligQte() {
      return this.procesligQte;
   }

   public void setProcesligQte(double var1) {
      this.procesligQte = var1;
   }

   public double getProcesligQteSur() {
      return this.procesligQteSur;
   }

   public void setProcesligQteSur(double var1) {
      this.procesligQteSur = var1;
   }
}
