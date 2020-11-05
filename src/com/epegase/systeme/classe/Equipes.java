package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Equipes implements Serializable {
   private long equId;
   private Date equDateCreat;
   private Date equDateModif;
   private long equUserCreat;
   private long equUserModif;
   private int equType;
   private String equCode;
   private String equNomFr;
   private String equNomUk;
   private String equNomSp;
   private int equInactif;
   private int equQuart;
   private int equHeureDebut;
   private int equHeureFin;
   private int equMinuteDebut;
   private int equMinuteFin;
   private long equIdResponsable;
   private String equNomResponsable;
   private String equIdAgent;
   private String equNomAgent;
   private String equDepot;
   private String equDepotOrigine;
   private String equCaisse;
   private int equStock;
   private boolean afficheImag;
   private String etat;
   private boolean select_equipe = false;
   private String libType;

   public String getEtat() {
      if (this.equInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.equInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.equInactif != 1 && this.equInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getLibType() {
      if (this.equType == 3) {
         this.libType = "Secrétariat";
      } else if (this.equType == 4) {
         this.libType = "Administrative";
      } else if (this.equType == 5) {
         this.libType = "R.H.";
      } else if (this.equType == 60) {
         this.libType = "Logistique";
      } else if (this.equType == 61) {
         this.libType = "Production";
      } else if (this.equType == 7) {
         this.libType = "Technique";
      } else if (this.equType == 80) {
         this.libType = "Commerciale";
      } else if (this.equType == 81) {
         this.libType = "Médicale";
      } else if (this.equType == 9) {
         this.libType = "Caissier";
      }

      return this.libType;
   }

   public void setLibType(String var1) {
      this.libType = var1;
   }

   public boolean isSelect_equipe() {
      return this.select_equipe;
   }

   public void setSelect_equipe(boolean var1) {
      this.select_equipe = var1;
   }

   public long getEquIdResponsable() {
      return this.equIdResponsable;
   }

   public void setEquIdResponsable(long var1) {
      this.equIdResponsable = var1;
   }

   public String getEquNomResponsable() {
      return this.equNomResponsable;
   }

   public void setEquNomResponsable(String var1) {
      this.equNomResponsable = var1;
   }

   public String getEquCode() {
      if (this.equCode != null && !this.equCode.isEmpty()) {
         this.equCode = this.equCode.toUpperCase();
      }

      return this.equCode;
   }

   public void setEquCode(String var1) {
      this.equCode = var1;
   }

   public Date getEquDateCreat() {
      return this.equDateCreat;
   }

   public void setEquDateCreat(Date var1) {
      this.equDateCreat = var1;
   }

   public Date getEquDateModif() {
      return this.equDateModif;
   }

   public void setEquDateModif(Date var1) {
      this.equDateModif = var1;
   }

   public int getEquHeureDebut() {
      return this.equHeureDebut;
   }

   public void setEquHeureDebut(int var1) {
      this.equHeureDebut = var1;
   }

   public int getEquHeureFin() {
      return this.equHeureFin;
   }

   public void setEquHeureFin(int var1) {
      this.equHeureFin = var1;
   }

   public int getEquMinuteDebut() {
      return this.equMinuteDebut;
   }

   public void setEquMinuteDebut(int var1) {
      this.equMinuteDebut = var1;
   }

   public int getEquMinuteFin() {
      return this.equMinuteFin;
   }

   public void setEquMinuteFin(int var1) {
      this.equMinuteFin = var1;
   }

   public long getEquId() {
      return this.equId;
   }

   public void setEquId(long var1) {
      this.equId = var1;
   }

   public int getEquInactif() {
      return this.equInactif;
   }

   public void setEquInactif(int var1) {
      this.equInactif = var1;
   }

   public String getEquNomFr() {
      if (this.equNomFr != null && !this.equNomFr.isEmpty()) {
         this.equNomFr = this.equNomFr.toUpperCase();
      }

      return this.equNomFr;
   }

   public void setEquNomFr(String var1) {
      this.equNomFr = var1;
   }

   public String getEquNomSp() {
      return this.equNomSp;
   }

   public void setEquNomSp(String var1) {
      this.equNomSp = var1;
   }

   public String getEquNomUk() {
      return this.equNomUk;
   }

   public void setEquNomUk(String var1) {
      this.equNomUk = var1;
   }

   public int getEquQuart() {
      return this.equQuart;
   }

   public void setEquQuart(int var1) {
      this.equQuart = var1;
   }

   public long getEquUserCreat() {
      return this.equUserCreat;
   }

   public void setEquUserCreat(long var1) {
      this.equUserCreat = var1;
   }

   public long getEquUserModif() {
      return this.equUserModif;
   }

   public void setEquUserModif(long var1) {
      this.equUserModif = var1;
   }

   public int getEquType() {
      return this.equType;
   }

   public void setEquType(int var1) {
      this.equType = var1;
   }

   public String getEquIdAgent() {
      return this.equIdAgent;
   }

   public void setEquIdAgent(String var1) {
      this.equIdAgent = var1;
   }

   public String getEquNomAgent() {
      return this.equNomAgent;
   }

   public void setEquNomAgent(String var1) {
      this.equNomAgent = var1;
   }

   public String getEquCaisse() {
      return this.equCaisse;
   }

   public void setEquCaisse(String var1) {
      this.equCaisse = var1;
   }

   public String getEquDepot() {
      return this.equDepot;
   }

   public void setEquDepot(String var1) {
      this.equDepot = var1;
   }

   public String getEquDepotOrigine() {
      return this.equDepotOrigine;
   }

   public void setEquDepotOrigine(String var1) {
      this.equDepotOrigine = var1;
   }

   public int getEquStock() {
      return this.equStock;
   }

   public void setEquStock(int var1) {
      this.equStock = var1;
   }
}
