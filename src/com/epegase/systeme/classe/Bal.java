package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Bal implements Serializable {
   private long balid;
   private Date baldatecreat;
   private Date baldatemodif;
   private long balusercreat;
   private long balusermodif;
   private String balnomcompte;
   private int balinactif;
   private String baladressemail;
   private String baladressemailreponse;
   private String balpw;
   private String balpopserveur;
   private int balpopport;
   private int balpopauthentification;
   private int balssl;
   private int balpopexemplaire;
   private String balimapserveur;
   private int balimapport;
   private String balsmtpserveur;
   private int balsmtpport;
   private int balsmtauthentification;
   private String balSignature;
   private long balUser;
   private String balGroupe;
   private long balStructure;
   private boolean balDefaut;
   private boolean afficheImag;
   private String etat;

   public String getEtat() {
      if (this.balinactif == 1) {
         this.etat = "/images/desactiver.png";
      } else {
         this.etat = "";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.balinactif == 1) {
         this.afficheImag = true;
      } else {
         this.afficheImag = false;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getBalGroupe() {
      return this.balGroupe;
   }

   public void setBalGroupe(String var1) {
      this.balGroupe = var1;
   }

   public String getBalSignature() {
      return this.balSignature;
   }

   public void setBalSignature(String var1) {
      this.balSignature = var1;
   }

   public long getBalStructure() {
      return this.balStructure;
   }

   public void setBalStructure(long var1) {
      this.balStructure = var1;
   }

   public long getBalUser() {
      return this.balUser;
   }

   public void setBalUser(long var1) {
      this.balUser = var1;
   }

   public String getBaladressemail() {
      return this.baladressemail;
   }

   public void setBaladressemail(String var1) {
      this.baladressemail = var1;
   }

   public Date getBaldatecreat() {
      return this.baldatecreat;
   }

   public void setBaldatecreat(Date var1) {
      this.baldatecreat = var1;
   }

   public Date getBaldatemodif() {
      return this.baldatemodif;
   }

   public void setBaldatemodif(Date var1) {
      this.baldatemodif = var1;
   }

   public long getBalid() {
      return this.balid;
   }

   public void setBalid(long var1) {
      this.balid = var1;
   }

   public int getBalinactif() {
      return this.balinactif;
   }

   public void setBalinactif(int var1) {
      this.balinactif = var1;
   }

   public String getBalnomcompte() {
      return this.balnomcompte;
   }

   public void setBalnomcompte(String var1) {
      this.balnomcompte = var1;
   }

   public int getBalpopauthentification() {
      return this.balpopauthentification;
   }

   public void setBalpopauthentification(int var1) {
      this.balpopauthentification = var1;
   }

   public int getBalpopexemplaire() {
      return this.balpopexemplaire;
   }

   public void setBalpopexemplaire(int var1) {
      this.balpopexemplaire = var1;
   }

   public int getBalpopport() {
      return this.balpopport;
   }

   public void setBalpopport(int var1) {
      this.balpopport = var1;
   }

   public String getBalpopserveur() {
      return this.balpopserveur;
   }

   public void setBalpopserveur(String var1) {
      this.balpopserveur = var1;
   }

   public int getBalssl() {
      return this.balssl;
   }

   public void setBalssl(int var1) {
      this.balssl = var1;
   }

   public String getBalpw() {
      return this.balpw;
   }

   public void setBalpw(String var1) {
      this.balpw = var1;
   }

   public int getBalsmtpport() {
      return this.balsmtpport;
   }

   public void setBalsmtpport(int var1) {
      this.balsmtpport = var1;
   }

   public String getBalsmtpserveur() {
      return this.balsmtpserveur;
   }

   public void setBalsmtpserveur(String var1) {
      this.balsmtpserveur = var1;
   }

   public long getBalusercreat() {
      return this.balusercreat;
   }

   public void setBalusercreat(long var1) {
      this.balusercreat = var1;
   }

   public long getBalusermodif() {
      return this.balusermodif;
   }

   public void setBalusermodif(long var1) {
      this.balusermodif = var1;
   }

   public String getBaladressemailreponse() {
      return this.baladressemailreponse;
   }

   public void setBaladressemailreponse(String var1) {
      this.baladressemailreponse = var1;
   }

   public int getBalimapport() {
      return this.balimapport;
   }

   public void setBalimapport(int var1) {
      this.balimapport = var1;
   }

   public String getBalimapserveur() {
      return this.balimapserveur;
   }

   public void setBalimapserveur(String var1) {
      this.balimapserveur = var1;
   }

   public int getBalsmtauthentification() {
      return this.balsmtauthentification;
   }

   public void setBalsmtauthentification(int var1) {
      this.balsmtauthentification = var1;
   }

   public boolean isBalDefaut() {
      return this.balDefaut;
   }

   public void setBalDefaut(boolean var1) {
      this.balDefaut = var1;
   }
}
