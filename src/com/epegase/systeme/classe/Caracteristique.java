package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Caracteristique implements Serializable {
   private long carId;
   private Date carDateCreat;
   private Date carDateModif;
   private long carUserCreat;
   private long carUserModif;
   private int carNature;
   private String carLibNature;
   private String carFamille;
   private String carLibFamille;
   private String carSousFamille;
   private String carLibSousFamille;
   private int carInactif;
   private int carOrgane;
   private int carInventaire;
   private String carLibelle;
   private int carType;
   private FamillesParc1 famillesParc1;
   private String libOrgane;
   private String libInventaire;
   private boolean etat;
   private String afficheImag;

   public String getLibOrgane() {
      if (this.getCarOrgane() == 0) {
         this.libOrgane = "Non renseigné";
      } else if (this.getCarOrgane() == 1) {
         this.libOrgane = "Mécanique";
      } else if (this.getCarOrgane() == 2) {
         this.libOrgane = "Hydraulique";
      } else if (this.getCarOrgane() == 3) {
         this.libOrgane = "Electrique";
      } else if (this.getCarOrgane() == 4) {
         this.libOrgane = "Pneumatique";
      } else if (this.getCarOrgane() == 5) {
         this.libOrgane = "Equipement";
      } else if (this.getCarOrgane() == 6) {
         this.libOrgane = "Cellerie";
      } else if (this.getCarOrgane() == 9) {
         this.libOrgane = "Autre";
      }

      return this.libOrgane;
   }

   public void setLibOrgane(String var1) {
      this.libOrgane = var1;
   }

   public String getLibInventaire() {
      if (this.getCarInventaire() == 0) {
         this.libInventaire = "Document administratif";
      } else if (this.getCarInventaire() == 1) {
         this.libInventaire = "Document technique";
      } else if (this.getCarInventaire() == 2) {
         this.libInventaire = "Outils";
      } else if (this.getCarInventaire() == 3) {
         this.libInventaire = "Consommable";
      } else if (this.getCarInventaire() == 4) {
         this.libInventaire = "Pièces rechanges";
      } else if (this.getCarInventaire() == 5) {
         this.libInventaire = "Accessoires";
      } else if (this.getCarInventaire() == 9) {
         this.libInventaire = "Autre";
      }

      return this.libInventaire;
   }

   public void setLibInventaire(String var1) {
      this.libInventaire = var1;
   }

   public Date getCarDateCreat() {
      return this.carDateCreat;
   }

   public void setCarDateCreat(Date var1) {
      this.carDateCreat = var1;
   }

   public Date getCarDateModif() {
      return this.carDateModif;
   }

   public void setCarDateModif(Date var1) {
      this.carDateModif = var1;
   }

   public String getCarFamille() {
      return this.carFamille;
   }

   public void setCarFamille(String var1) {
      this.carFamille = var1;
   }

   public long getCarId() {
      return this.carId;
   }

   public void setCarId(long var1) {
      this.carId = var1;
   }

   public int getCarInactif() {
      return this.carInactif;
   }

   public void setCarInactif(int var1) {
      this.carInactif = var1;
   }

   public String getCarLibFamille() {
      return this.carLibFamille;
   }

   public void setCarLibFamille(String var1) {
      this.carLibFamille = var1;
   }

   public String getCarLibNature() {
      return this.carLibNature;
   }

   public void setCarLibNature(String var1) {
      this.carLibNature = var1;
   }

   public String getCarLibelle() {
      if (this.carLibelle != null && !this.carLibelle.isEmpty()) {
         this.carLibelle = this.carLibelle.toUpperCase();
      }

      return this.carLibelle;
   }

   public void setCarLibelle(String var1) {
      this.carLibelle = var1;
   }

   public String getCarLibSousFamille() {
      return this.carLibSousFamille;
   }

   public void setCarLibSousFamille(String var1) {
      this.carLibSousFamille = var1;
   }

   public int getCarNature() {
      return this.carNature;
   }

   public void setCarNature(int var1) {
      this.carNature = var1;
   }

   public int getCarOrgane() {
      return this.carOrgane;
   }

   public void setCarOrgane(int var1) {
      this.carOrgane = var1;
   }

   public String getCarSousFamille() {
      return this.carSousFamille;
   }

   public void setCarSousFamille(String var1) {
      this.carSousFamille = var1;
   }

   public long getCarUserCreat() {
      return this.carUserCreat;
   }

   public void setCarUserCreat(long var1) {
      this.carUserCreat = var1;
   }

   public long getCarUserModif() {
      return this.carUserModif;
   }

   public void setCarUserModif(long var1) {
      this.carUserModif = var1;
   }

   public FamillesParc1 getFamillesParc1() {
      return this.famillesParc1;
   }

   public void setFamillesParc1(FamillesParc1 var1) {
      this.famillesParc1 = var1;
   }

   public String getAfficheImag() {
      return this.afficheImag;
   }

   public void setAfficheImag(String var1) {
      this.afficheImag = var1;
   }

   public boolean isEtat() {
      return this.etat;
   }

   public void setEtat(boolean var1) {
      this.etat = var1;
   }

   public int getCarType() {
      return this.carType;
   }

   public void setCarType(int var1) {
      this.carType = var1;
   }

   public int getCarInventaire() {
      return this.carInventaire;
   }

   public void setCarInventaire(int var1) {
      this.carInventaire = var1;
   }
}
