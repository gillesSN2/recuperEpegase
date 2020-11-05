package com.epegase.systeme.classe;

import java.io.Serializable;

public class CvAgents implements Serializable {
   private long cvaId;
   private String cvaAgent;
   private int cvaAge;
   private String cvaGenre;
   private String cvaNationalite;
   private String cvaResidence;
   private String cvaDiplomeMax;
   private String cvaCommentaires;
   private float cvaNote;
   private CvSession cvSession;

   public CvSession getCvSession() {
      return this.cvSession;
   }

   public void setCvSession(CvSession var1) {
      this.cvSession = var1;
   }

   public int getCvaAge() {
      return this.cvaAge;
   }

   public void setCvaAge(int var1) {
      this.cvaAge = var1;
   }

   public String getCvaAgent() {
      return this.cvaAgent;
   }

   public void setCvaAgent(String var1) {
      this.cvaAgent = var1;
   }

   public String getCvaCommentaires() {
      return this.cvaCommentaires;
   }

   public void setCvaCommentaires(String var1) {
      this.cvaCommentaires = var1;
   }

   public String getCvaDiplomeMax() {
      return this.cvaDiplomeMax;
   }

   public void setCvaDiplomeMax(String var1) {
      this.cvaDiplomeMax = var1;
   }

   public String getCvaGenre() {
      return this.cvaGenre;
   }

   public void setCvaGenre(String var1) {
      this.cvaGenre = var1;
   }

   public long getCvaId() {
      return this.cvaId;
   }

   public void setCvaId(long var1) {
      this.cvaId = var1;
   }

   public String getCvaNationalite() {
      return this.cvaNationalite;
   }

   public void setCvaNationalite(String var1) {
      this.cvaNationalite = var1;
   }

   public float getCvaNote() {
      return this.cvaNote;
   }

   public void setCvaNote(float var1) {
      this.cvaNote = var1;
   }

   public String getCvaResidence() {
      return this.cvaResidence;
   }

   public void setCvaResidence(String var1) {
      this.cvaResidence = var1;
   }
}
