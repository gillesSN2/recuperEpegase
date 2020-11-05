package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CaissesOperations implements Serializable {
   private long caiopeId;
   private Date caiopeDateCreat;
   private Date caiopeDateModif;
   private long caiopeUserCreat;
   private long caiopeUserModif;
   private String caiopeCode;
   private String caiopeNom;
   private int caiopeInactif;
   private int caiopeType;
   private int caiopeTransfert;
   private int caiopeCategorie;
   private String etat;
   private boolean afficheImag;
   private String libMode;
   private String libType;
   private boolean select;
   private double plafond;
   private String libCategorie;

   public boolean isAfficheImag() {
      if (this.caiopeInactif != 1 && this.caiopeInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getEtat() {
      if (this.caiopeInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.caiopeInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public String getLibMode() {
      if (this.caiopeTransfert == 0) {
         this.libMode = "Transférable";
      } else {
         this.libMode = "Non transférable";
      }

      return this.libMode;
   }

   public void setLibMode(String var1) {
      this.libMode = var1;
   }

   public String getLibType() {
      if (this.caiopeType == 0) {
         this.libType = "Entrée";
      } else if (this.caiopeType == 1) {
         this.libType = "Sortie";
      } else {
         this.libType = "Entrée/Sortie";
      }

      return this.libType;
   }

   public void setLibType(String var1) {
      this.libType = var1;
   }

   public String getLibCategorie() {
      if (this.caiopeCategorie == 0) {
         this.libCategorie = "Client";
      } else if (this.caiopeCategorie == 1) {
         this.libCategorie = "Fournisseur";
      } else if (this.caiopeCategorie == 2) {
         this.libCategorie = "Personnel";
      } else if (this.caiopeCategorie == 3) {
         this.libCategorie = "Mouvement";
      } else if (this.caiopeCategorie == 4) {
         this.libCategorie = "Plan comptable";
      } else if (this.caiopeCategorie == 5) {
         this.libCategorie = "Utilisateur";
      } else if (this.caiopeCategorie == 6) {
         this.libCategorie = "Patient";
      } else if (this.caiopeCategorie == 7) {
         this.libCategorie = "Eleve";
      }

      return this.libCategorie;
   }

   public void setLibCategorie(String var1) {
      this.libCategorie = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public double getPlafond() {
      return this.plafond;
   }

   public void setPlafond(double var1) {
      this.plafond = var1;
   }

   public String getCaiopeCode() {
      if (this.caiopeCode != null && !this.caiopeCode.isEmpty()) {
         this.caiopeCode = this.caiopeCode.toUpperCase();
      }

      return this.caiopeCode;
   }

   public void setCaiopeCode(String var1) {
      this.caiopeCode = var1;
   }

   public Date getCaiopeDateCreat() {
      return this.caiopeDateCreat;
   }

   public void setCaiopeDateCreat(Date var1) {
      this.caiopeDateCreat = var1;
   }

   public Date getCaiopeDateModif() {
      return this.caiopeDateModif;
   }

   public void setCaiopeDateModif(Date var1) {
      this.caiopeDateModif = var1;
   }

   public long getCaiopeId() {
      return this.caiopeId;
   }

   public void setCaiopeId(long var1) {
      this.caiopeId = var1;
   }

   public int getCaiopeInactif() {
      return this.caiopeInactif;
   }

   public void setCaiopeInactif(int var1) {
      this.caiopeInactif = var1;
   }

   public String getCaiopeNom() {
      if (this.caiopeNom != null && !this.caiopeNom.isEmpty()) {
         this.caiopeNom = this.caiopeNom.toUpperCase();
      }

      return this.caiopeNom;
   }

   public void setCaiopeNom(String var1) {
      this.caiopeNom = var1;
   }

   public int getCaiopeTransfert() {
      return this.caiopeTransfert;
   }

   public void setCaiopeTransfert(int var1) {
      this.caiopeTransfert = var1;
   }

   public long getCaiopeUserCreat() {
      return this.caiopeUserCreat;
   }

   public void setCaiopeUserCreat(long var1) {
      this.caiopeUserCreat = var1;
   }

   public long getCaiopeUserModif() {
      return this.caiopeUserModif;
   }

   public void setCaiopeUserModif(long var1) {
      this.caiopeUserModif = var1;
   }

   public int getCaiopeType() {
      return this.caiopeType;
   }

   public void setCaiopeType(int var1) {
      this.caiopeType = var1;
   }

   public int getCaiopeCategorie() {
      return this.caiopeCategorie;
   }

   public void setCaiopeCategorie(int var1) {
      this.caiopeCategorie = var1;
   }
}
