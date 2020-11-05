package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Android implements Serializable {
   private long eveId;
   private long eveIdUser;
   private int eveNature;
   private int eveCategorie;
   private long eveIdInit;
   private Date eveHoraire;
   private long eveIdTie;
   private String eveTieRaisonSocialeNom;
   private long eveIdPat;
   private String evePatNomPrenom;
   private String eveTieBurTel;
   private String eveConPatroyme;
   private String eveConFonction;
   private String eveMessage;
   private float eveMontant;
   private int eveEstimation;
   private double eveLongitude;
   private double eveLatitude;
   private int eveTraitee;
   private String eveMission;
   private String eveTache;
   private String eveActe;

   public int getEveCategorie() {
      return this.eveCategorie;
   }

   public void setEveCategorie(int var1) {
      this.eveCategorie = var1;
   }

   public String getEveConFonction() {
      return this.eveConFonction;
   }

   public void setEveConFonction(String var1) {
      this.eveConFonction = var1;
   }

   public String getEveConPatroyme() {
      return this.eveConPatroyme;
   }

   public void setEveConPatroyme(String var1) {
      this.eveConPatroyme = var1;
   }

   public int getEveEstimation() {
      return this.eveEstimation;
   }

   public void setEveEstimation(int var1) {
      this.eveEstimation = var1;
   }

   public Date getEveHoraire() {
      return this.eveHoraire;
   }

   public void setEveHoraire(Date var1) {
      this.eveHoraire = var1;
   }

   public long getEveId() {
      return this.eveId;
   }

   public void setEveId(long var1) {
      this.eveId = var1;
   }

   public long getEveIdInit() {
      return this.eveIdInit;
   }

   public void setEveIdInit(long var1) {
      this.eveIdInit = var1;
   }

   public long getEveIdTie() {
      return this.eveIdTie;
   }

   public void setEveIdTie(long var1) {
      this.eveIdTie = var1;
   }

   public long getEveIdUser() {
      return this.eveIdUser;
   }

   public void setEveIdUser(long var1) {
      this.eveIdUser = var1;
   }

   public double getEveLatitude() {
      return this.eveLatitude;
   }

   public void setEveLatitude(double var1) {
      this.eveLatitude = var1;
   }

   public double getEveLongitude() {
      return this.eveLongitude;
   }

   public void setEveLongitude(double var1) {
      this.eveLongitude = var1;
   }

   public String getEveMessage() {
      return this.eveMessage;
   }

   public void setEveMessage(String var1) {
      this.eveMessage = var1;
   }

   public float getEveMontant() {
      return this.eveMontant;
   }

   public void setEveMontant(float var1) {
      this.eveMontant = var1;
   }

   public int getEveNature() {
      return this.eveNature;
   }

   public void setEveNature(int var1) {
      this.eveNature = var1;
   }

   public String getEveTieBurTel() {
      return this.eveTieBurTel;
   }

   public void setEveTieBurTel(String var1) {
      this.eveTieBurTel = var1;
   }

   public String getEveTieRaisonSocialeNom() {
      return this.eveTieRaisonSocialeNom;
   }

   public void setEveTieRaisonSocialeNom(String var1) {
      this.eveTieRaisonSocialeNom = var1;
   }

   public int getEveTraitee() {
      return this.eveTraitee;
   }

   public void setEveTraitee(int var1) {
      this.eveTraitee = var1;
   }

   public String getEveActe() {
      return this.eveActe;
   }

   public void setEveActe(String var1) {
      this.eveActe = var1;
   }

   public long getEveIdPat() {
      return this.eveIdPat;
   }

   public void setEveIdPat(long var1) {
      this.eveIdPat = var1;
   }

   public String getEveMission() {
      return this.eveMission;
   }

   public void setEveMission(String var1) {
      this.eveMission = var1;
   }

   public String getEvePatNomPrenom() {
      return this.evePatNomPrenom;
   }

   public void setEvePatNomPrenom(String var1) {
      this.evePatNomPrenom = var1;
   }

   public String getEveTache() {
      return this.eveTache;
   }

   public void setEveTache(String var1) {
      this.eveTache = var1;
   }
}
