package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ClassementMediatheque implements Serializable {
   private long clamedId;
   private Date clamedDateCreat;
   private Date clamedDateModif;
   private long clamedUserCreat;
   private long clamedUserModif;
   private String clamedCode;
   private String clamedSujet;
   private String clamedTheme;
   private String clamedDomaine;
   private int clamedType;
   private int clamedInactif;
   private boolean afficheImag;
   private String libelleType;
   private String etat;
   private boolean select = false;

   public String getLibelleType() {
      this.libelleType = "";
      if (this.clamedType == 0) {
         this.libelleType = "Sujet";
      } else if (this.clamedInactif == 1) {
         this.libelleType = "Type";
      } else if (this.clamedInactif == 2) {
         this.libelleType = "Support";
      } else if (this.clamedInactif == 3) {
         this.libelleType = "Contenant";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public String getEtat() {
      if (this.clamedInactif == 1) {
         this.etat = "/images/desclamediver.png";
      } else if (this.clamedInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.clamedInactif != 1 && this.clamedInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getClamedCode() {
      return this.clamedCode;
   }

   public void setClamedCode(String var1) {
      this.clamedCode = var1;
   }

   public Date getClamedDateCreat() {
      return this.clamedDateCreat;
   }

   public void setClamedDateCreat(Date var1) {
      this.clamedDateCreat = var1;
   }

   public Date getClamedDateModif() {
      return this.clamedDateModif;
   }

   public void setClamedDateModif(Date var1) {
      this.clamedDateModif = var1;
   }

   public String getClamedDomaine() {
      return this.clamedDomaine;
   }

   public void setClamedDomaine(String var1) {
      this.clamedDomaine = var1;
   }

   public long getClamedId() {
      return this.clamedId;
   }

   public void setClamedId(long var1) {
      this.clamedId = var1;
   }

   public int getClamedInactif() {
      return this.clamedInactif;
   }

   public void setClamedInactif(int var1) {
      this.clamedInactif = var1;
   }

   public String getClamedSujet() {
      return this.clamedSujet;
   }

   public void setClamedSujet(String var1) {
      this.clamedSujet = var1;
   }

   public String getClamedTheme() {
      return this.clamedTheme;
   }

   public void setClamedTheme(String var1) {
      this.clamedTheme = var1;
   }

   public long getClamedUserCreat() {
      return this.clamedUserCreat;
   }

   public void setClamedUserCreat(long var1) {
      this.clamedUserCreat = var1;
   }

   public long getClamedUserModif() {
      return this.clamedUserModif;
   }

   public void setClamedUserModif(long var1) {
      this.clamedUserModif = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public int getClamedType() {
      return this.clamedType;
   }

   public void setClamedType(int var1) {
      this.clamedType = var1;
   }
}
