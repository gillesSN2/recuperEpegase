package com.epegase.systeme.classe;

import java.io.Serializable;

public class ElevesContact implements Serializable {
   private long eleconId;
   private String eleconCivilite;
   private String eleconQualite;
   private String eleconNom;
   private String eleconPrenom;
   private String eleconAdresse;
   private String eleconEmployeur;
   private String eleconAdresseEmployeur;
   private String eleconTelBur;
   private String eleconTelDom;
   private String eleconCel;
   private String eleconMail;
   private String eleconObs;
   private String eleconCodeBanque;
   private String eleconCodeGuichet;
   private String eleconCompteBanque;
   private String eleconCleRib;
   private String eleconCodeSwift;
   private String eleconCodeIban;
   private int eleconFacture;
   private int eleconNote;
   private Eleves eleves;
   private String patronyme;

   public Eleves getEleves() {
      return this.eleves;
   }

   public void setEleves(Eleves var1) {
      this.eleves = var1;
   }

   public String getPatronyme() {
      if (this.eleconPrenom != null && !this.eleconPrenom.isEmpty()) {
         this.patronyme = this.eleconNom + " " + this.eleconPrenom;
      } else {
         this.patronyme = this.eleconNom;
      }

      return this.patronyme;
   }

   public void setPatronyme(String var1) {
      this.patronyme = var1;
   }

   public String getEleconAdresse() {
      return this.eleconAdresse;
   }

   public void setEleconAdresse(String var1) {
      this.eleconAdresse = var1;
   }

   public String getEleconCel() {
      return this.eleconCel;
   }

   public void setEleconCel(String var1) {
      this.eleconCel = var1;
   }

   public String getEleconCivilite() {
      return this.eleconCivilite;
   }

   public void setEleconCivilite(String var1) {
      this.eleconCivilite = var1;
   }

   public long getEleconId() {
      return this.eleconId;
   }

   public void setEleconId(long var1) {
      this.eleconId = var1;
   }

   public String getEleconMail() {
      return this.eleconMail;
   }

   public void setEleconMail(String var1) {
      this.eleconMail = var1;
   }

   public String getEleconNom() {
      return this.eleconNom;
   }

   public void setEleconNom(String var1) {
      this.eleconNom = var1;
   }

   public String getEleconObs() {
      return this.eleconObs;
   }

   public void setEleconObs(String var1) {
      this.eleconObs = var1;
   }

   public String getEleconPrenom() {
      return this.eleconPrenom;
   }

   public void setEleconPrenom(String var1) {
      this.eleconPrenom = var1;
   }

   public String getEleconQualite() {
      return this.eleconQualite;
   }

   public void setEleconQualite(String var1) {
      this.eleconQualite = var1;
   }

   public String getEleconTelBur() {
      return this.eleconTelBur;
   }

   public void setEleconTelBur(String var1) {
      this.eleconTelBur = var1;
   }

   public String getEleconTelDom() {
      return this.eleconTelDom;
   }

   public void setEleconTelDom(String var1) {
      this.eleconTelDom = var1;
   }

   public String getEleconAdresseEmployeur() {
      return this.eleconAdresseEmployeur;
   }

   public void setEleconAdresseEmployeur(String var1) {
      this.eleconAdresseEmployeur = var1;
   }

   public String getEleconCleRib() {
      return this.eleconCleRib;
   }

   public void setEleconCleRib(String var1) {
      this.eleconCleRib = var1;
   }

   public String getEleconCodeBanque() {
      return this.eleconCodeBanque;
   }

   public void setEleconCodeBanque(String var1) {
      this.eleconCodeBanque = var1;
   }

   public String getEleconCodeGuichet() {
      return this.eleconCodeGuichet;
   }

   public void setEleconCodeGuichet(String var1) {
      this.eleconCodeGuichet = var1;
   }

   public String getEleconCodeIban() {
      return this.eleconCodeIban;
   }

   public void setEleconCodeIban(String var1) {
      this.eleconCodeIban = var1;
   }

   public String getEleconCodeSwift() {
      return this.eleconCodeSwift;
   }

   public void setEleconCodeSwift(String var1) {
      this.eleconCodeSwift = var1;
   }

   public String getEleconCompteBanque() {
      return this.eleconCompteBanque;
   }

   public void setEleconCompteBanque(String var1) {
      this.eleconCompteBanque = var1;
   }

   public String getEleconEmployeur() {
      return this.eleconEmployeur;
   }

   public void setEleconEmployeur(String var1) {
      this.eleconEmployeur = var1;
   }

   public int getEleconFacture() {
      return this.eleconFacture;
   }

   public void setEleconFacture(int var1) {
      this.eleconFacture = var1;
   }

   public int getEleconNote() {
      return this.eleconNote;
   }

   public void setEleconNote(int var1) {
      this.eleconNote = var1;
   }
}
