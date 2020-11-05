package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FeuilleCalcul implements Serializable {
   private long feu_id;
   private String feuNature;
   private Date feuDateCreat;
   private Date feuDateModif;
   private long feuUserCreat;
   private long feuUserModif;
   private String feuCode;
   private String feuLibelleFr;
   private String feuLibelleUk;
   private String feuLibelleSp;
   private String feuModele;
   private String feuModeleMat;
   private String feuJournal;
   private String feuCompte;
   private int feuDecale;
   private int feuInactif;
   private ExercicesPaye exercicesPaye;
   private String etat;
   private boolean afficheImag;
   private String libelleNature;
   private boolean select;
   private int feuilleOrigine;

   public int getFeuilleOrigine() {
      return this.feuilleOrigine;
   }

   public void setFeuilleOrigine(int var1) {
      this.feuilleOrigine = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public String getLibelleNature() {
      if (this.feuNature != null && !this.feuNature.isEmpty() && this.feuNature.contains(":")) {
         String[] var1 = this.feuNature.split(":");
         if (var1[0].equalsIgnoreCase("01D")) {
            this.libelleNature = "Mensuel CDD";
         } else if (var1[0].equalsIgnoreCase("01I")) {
            this.libelleNature = "Mensuel CDI";
         } else if (var1[0].equalsIgnoreCase("02D")) {
            this.libelleNature = "Expatrié CDD";
         } else if (var1[0].equalsIgnoreCase("02I")) {
            this.libelleNature = "Expatrié CDI";
         } else if (var1[0].equalsIgnoreCase("03D")) {
            this.libelleNature = "Horaire CDD";
         } else if (var1[0].equalsIgnoreCase("03I")) {
            this.libelleNature = "Horaire CDI";
         } else if (var1[0].equalsIgnoreCase("04")) {
            this.libelleNature = "Journalier";
         } else if (var1[0].equalsIgnoreCase("05")) {
            this.libelleNature = "Stagiaire";
         } else if (var1[0].equalsIgnoreCase("11")) {
            this.libelleNature = "Stagiaire temporaire";
         } else if (var1[0].equalsIgnoreCase("12")) {
            this.libelleNature = "Intérimaire";
         } else if (var1[0].equalsIgnoreCase("13")) {
            this.libelleNature = "Prestataire";
         } else if (var1[0].equalsIgnoreCase("14")) {
            this.libelleNature = "Vacataire";
         } else if (var1[0].equalsIgnoreCase("15")) {
            this.libelleNature = "Consultant";
         } else if (var1[0].equalsIgnoreCase("20")) {
            this.libelleNature = "Autre";
         } else if (var1[0].equalsIgnoreCase("99")) {
            this.libelleNature = "Pool agents (non actifs)";
         } else if (var1[0].equalsIgnoreCase("01")) {
            this.libelleNature = "Mensuel";
         } else if (var1[0].equalsIgnoreCase("03")) {
            this.libelleNature = "Horaire";
         } else {
            this.libelleNature = "";
         }
      } else {
         this.libelleNature = "";
      }

      return this.libelleNature;
   }

   public void setLibelleNature(String var1) {
      this.libelleNature = var1;
   }

   public String getEtat() {
      if (this.feuInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.feuInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.feuInactif != 1 && this.feuInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public String getFeuCode() {
      return this.feuCode;
   }

   public void setFeuCode(String var1) {
      this.feuCode = var1;
   }

   public String getFeuCompte() {
      return this.feuCompte;
   }

   public void setFeuCompte(String var1) {
      this.feuCompte = var1;
   }

   public Date getFeuDateCreat() {
      return this.feuDateCreat;
   }

   public void setFeuDateCreat(Date var1) {
      this.feuDateCreat = var1;
   }

   public Date getFeuDateModif() {
      return this.feuDateModif;
   }

   public void setFeuDateModif(Date var1) {
      this.feuDateModif = var1;
   }

   public int getFeuDecale() {
      return this.feuDecale;
   }

   public void setFeuDecale(int var1) {
      this.feuDecale = var1;
   }

   public int getFeuInactif() {
      return this.feuInactif;
   }

   public void setFeuInactif(int var1) {
      this.feuInactif = var1;
   }

   public String getFeuJournal() {
      return this.feuJournal;
   }

   public void setFeuJournal(String var1) {
      this.feuJournal = var1;
   }

   public String getFeuLibelleFr() {
      return this.feuLibelleFr;
   }

   public void setFeuLibelleFr(String var1) {
      this.feuLibelleFr = var1;
   }

   public String getFeuLibelleSp() {
      return this.feuLibelleSp;
   }

   public void setFeuLibelleSp(String var1) {
      this.feuLibelleSp = var1;
   }

   public String getFeuLibelleUk() {
      return this.feuLibelleUk;
   }

   public void setFeuLibelleUk(String var1) {
      this.feuLibelleUk = var1;
   }

   public String getFeuModele() {
      return this.feuModele;
   }

   public void setFeuModele(String var1) {
      this.feuModele = var1;
   }

   public String getFeuNature() {
      return this.feuNature;
   }

   public void setFeuNature(String var1) {
      this.feuNature = var1;
   }

   public long getFeuUserCreat() {
      return this.feuUserCreat;
   }

   public void setFeuUserCreat(long var1) {
      this.feuUserCreat = var1;
   }

   public long getFeuUserModif() {
      return this.feuUserModif;
   }

   public void setFeuUserModif(long var1) {
      this.feuUserModif = var1;
   }

   public long getFeu_id() {
      return this.feu_id;
   }

   public void setFeu_id(long var1) {
      this.feu_id = var1;
   }

   public String getFeuModeleMat() {
      return this.feuModeleMat;
   }

   public void setFeuModeleMat(String var1) {
      this.feuModeleMat = var1;
   }
}
