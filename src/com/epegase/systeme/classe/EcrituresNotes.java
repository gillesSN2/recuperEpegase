package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class EcrituresNotes implements Serializable {
   private long ecrnotId;
   private Date ecrnotDateCreat;
   private Date ecrnotDateModif;
   private long ecrnotUserCreat;
   private long ecrnotUserModif;
   private String ecrnotNum;
   private Date ecrnotDate;
   private String ecrnotPeriode;
   private String ecrnotAnnee;
   private double ecrnotMontant;
   private String ecrnotLibelle;
   private int ecrnotCategorie;
   private String ecrnotPiece;
   private int ecrnotEtat;
   private int ecrnotType;
   private double ecrnotLongitude;
   private double ecrnotLatitude;
   private boolean ecrnotPj;
   private String ecrnotScanFacture;
   private Date ecrnotDateTransfert;
   private Users users;
   private String libelleCategorie;
   private String libelleType;
   private String pj;

   public String getPj() {
      if (!this.ecrnotPj) {
         this.pj = null;
      } else if (this.ecrnotPj) {
         this.pj = "/images/mail_pj.png";
      }

      return this.pj;
   }

   public void setPj(String var1) {
      this.pj = var1;
   }

   public String getLibelleType() {
      if (this.ecrnotType == 0) {
         this.libelleType = "Note frais";
      } else if (this.ecrnotType == 1) {
         this.libelleType = "Pièce externe";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public String getLibelleCategorie() {
      if (this.ecrnotCategorie == 0) {
         this.libelleCategorie = "Note de frais: Carburant";
      } else if (this.ecrnotCategorie == 1) {
         this.libelleCategorie = "Note de frais: Amende";
      } else if (this.ecrnotCategorie == 2) {
         this.libelleCategorie = "Note de frais: Péage";
      } else if (this.ecrnotCategorie == 3) {
         this.libelleCategorie = "Note de frais: Taxi";
      } else if (this.ecrnotCategorie == 4) {
         this.libelleCategorie = "Note de frais: Transport Urbain";
      } else if (this.ecrnotCategorie == 5) {
         this.libelleCategorie = "Note de frais: Restaurant seul";
      } else if (this.ecrnotCategorie == 6) {
         this.libelleCategorie = "Note de frais: Restaurant avec Client";
      } else if (this.ecrnotCategorie == 7) {
         this.libelleCategorie = "Note de frais: Hébergement";
      } else if (this.ecrnotCategorie == 8) {
         this.libelleCategorie = "Note de frais: Entretien Véhicule";
      } else {
         this.libelleCategorie = "Note de frais: Inconnu";
      }

      return this.libelleCategorie;
   }

   public void setLibelleCategorie(String var1) {
      this.libelleCategorie = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public String getEcrnotAnnee() {
      return this.ecrnotAnnee;
   }

   public void setEcrnotAnnee(String var1) {
      this.ecrnotAnnee = var1;
   }

   public Date getEcrnotDate() {
      return this.ecrnotDate;
   }

   public void setEcrnotDate(Date var1) {
      this.ecrnotDate = var1;
   }

   public String getEcrnotLibelle() {
      return this.ecrnotLibelle;
   }

   public void setEcrnotLibelle(String var1) {
      this.ecrnotLibelle = var1;
   }

   public double getEcrnotMontant() {
      return this.ecrnotMontant;
   }

   public void setEcrnotMontant(double var1) {
      this.ecrnotMontant = var1;
   }

   public String getEcrnotPeriode() {
      return this.ecrnotPeriode;
   }

   public void setEcrnotPeriode(String var1) {
      this.ecrnotPeriode = var1;
   }

   public String getEcrnotPiece() {
      return this.ecrnotPiece;
   }

   public void setEcrnotPiece(String var1) {
      this.ecrnotPiece = var1;
   }

   public int getEcrnotType() {
      return this.ecrnotType;
   }

   public void setEcrnotType(int var1) {
      this.ecrnotType = var1;
   }

   public double getEcrnotLatitude() {
      return this.ecrnotLatitude;
   }

   public void setEcrnotLatitude(double var1) {
      this.ecrnotLatitude = var1;
   }

   public double getEcrnotLongitude() {
      return this.ecrnotLongitude;
   }

   public void setEcrnotLongitude(double var1) {
      this.ecrnotLongitude = var1;
   }

   public int getEcrnotCategorie() {
      return this.ecrnotCategorie;
   }

   public void setEcrnotCategorie(int var1) {
      this.ecrnotCategorie = var1;
   }

   public int getEcrnotEtat() {
      return this.ecrnotEtat;
   }

   public void setEcrnotEtat(int var1) {
      this.ecrnotEtat = var1;
   }

   public Date getEcrnotDateCreat() {
      return this.ecrnotDateCreat;
   }

   public void setEcrnotDateCreat(Date var1) {
      this.ecrnotDateCreat = var1;
   }

   public Date getEcrnotDateModif() {
      return this.ecrnotDateModif;
   }

   public void setEcrnotDateModif(Date var1) {
      this.ecrnotDateModif = var1;
   }

   public long getEcrnotId() {
      return this.ecrnotId;
   }

   public void setEcrnotId(long var1) {
      this.ecrnotId = var1;
   }

   public long getEcrnotUserCreat() {
      return this.ecrnotUserCreat;
   }

   public void setEcrnotUserCreat(long var1) {
      this.ecrnotUserCreat = var1;
   }

   public long getEcrnotUserModif() {
      return this.ecrnotUserModif;
   }

   public void setEcrnotUserModif(long var1) {
      this.ecrnotUserModif = var1;
   }

   public boolean isEcrnotPj() {
      return this.ecrnotPj;
   }

   public void setEcrnotPj(boolean var1) {
      this.ecrnotPj = var1;
   }

   public String getEcrnotScanFacture() {
      return this.ecrnotScanFacture;
   }

   public void setEcrnotScanFacture(String var1) {
      this.ecrnotScanFacture = var1;
   }

   public String getEcrnotNum() {
      return this.ecrnotNum;
   }

   public void setEcrnotNum(String var1) {
      this.ecrnotNum = var1;
   }

   public Date getEcrnotDateTransfert() {
      return this.ecrnotDateTransfert;
   }

   public void setEcrnotDateTransfert(Date var1) {
      this.ecrnotDateTransfert = var1;
   }
}
