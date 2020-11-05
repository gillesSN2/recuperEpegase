package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Unite implements Serializable {
   private long uniId;
   private Date uniDateCreation;
   private Date uniDateModif;
   private long uniUserCreation;
   private long uniUserModif;
   private String uniLibelle = "";
   private int uniEchelle = 0;
   private int uniInactif = 0;
   private String etat;
   private boolean inactif;
   private String var_lib_echelle;

   public Date getUniDateCreation() {
      return this.uniDateCreation;
   }

   public void setUniDateCreation(Date var1) {
      this.uniDateCreation = var1;
   }

   public Date getUniDateModif() {
      return this.uniDateModif;
   }

   public void setUniDateModif(Date var1) {
      this.uniDateModif = var1;
   }

   public int getUniEchelle() {
      return this.uniEchelle;
   }

   public void setUniEchelle(int var1) {
      this.uniEchelle = var1;
   }

   public long getUniId() {
      return this.uniId;
   }

   public void setUniId(long var1) {
      this.uniId = var1;
   }

   public int getUniInactif() {
      return this.uniInactif;
   }

   public void setUniInactif(int var1) {
      this.uniInactif = var1;
   }

   public String getUniLibelle() {
      return this.uniLibelle;
   }

   public void setUniLibelle(String var1) {
      this.uniLibelle = var1;
   }

   public long getUniUserCreation() {
      return this.uniUserCreation;
   }

   public void setUniUserCreation(long var1) {
      this.uniUserCreation = var1;
   }

   public long getUniUserModif() {
      return this.uniUserModif;
   }

   public void setUniUserModif(long var1) {
      this.uniUserModif = var1;
   }

   public String getEtat() {
      if (this.uniInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.uniInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      if (this.uniInactif != 1 && this.uniInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public String calculUnite(int var1) {
      this.uniEchelle = var1;
      this.var_lib_echelle = this.conversion();
      return this.var_lib_echelle;
   }

   public String conversion() {
      if (this.uniEchelle == 0) {
         this.var_lib_echelle = "";
      } else if (this.uniEchelle == 150) {
         this.var_lib_echelle = "millimètre linéaire";
      } else if (this.uniEchelle == 151) {
         this.var_lib_echelle = "centimètre linéaire";
      } else if (this.uniEchelle == 152) {
         this.var_lib_echelle = "décimètre linéaire";
      } else if (this.uniEchelle == 153) {
         this.var_lib_echelle = "mètre linéaire";
      } else if (this.uniEchelle == 154) {
         this.var_lib_echelle = "décamètre linéaire";
      } else if (this.uniEchelle == 155) {
         this.var_lib_echelle = "hectomètre linéaire";
      } else if (this.uniEchelle == 156) {
         this.var_lib_echelle = "kilomètre linéaire";
      } else if (this.uniEchelle == 250) {
         this.var_lib_echelle = "millimètre carré";
      } else if (this.uniEchelle == 251) {
         this.var_lib_echelle = "centimètre carré";
      } else if (this.uniEchelle == 252) {
         this.var_lib_echelle = "décimètre carré";
      } else if (this.uniEchelle == 253) {
         this.var_lib_echelle = "mètre carré";
      } else if (this.uniEchelle == 254) {
         this.var_lib_echelle = "décamètre carré";
      } else if (this.uniEchelle == 255) {
         this.var_lib_echelle = "hectomètre carré";
      } else if (this.uniEchelle == 256) {
         this.var_lib_echelle = "kilomètre carré";
      } else if (this.uniEchelle == 257) {
         this.var_lib_echelle = "are";
      } else if (this.uniEchelle == 258) {
         this.var_lib_echelle = "hectare";
      } else if (this.uniEchelle == 350) {
         this.var_lib_echelle = "millimètre cube";
      } else if (this.uniEchelle == 351) {
         this.var_lib_echelle = "centimètre cube";
      } else if (this.uniEchelle == 332) {
         this.var_lib_echelle = "décimètre cube";
      } else if (this.uniEchelle == 353) {
         this.var_lib_echelle = "mètre cube";
      } else if (this.uniEchelle == 354) {
         this.var_lib_echelle = "décamètre cube";
      } else if (this.uniEchelle == 355) {
         this.var_lib_echelle = "hectomètre cube";
      } else if (this.uniEchelle == 356) {
         this.var_lib_echelle = "kilomètre cube";
      } else if (this.uniEchelle == 357) {
         this.var_lib_echelle = "20 pieds";
      } else if (this.uniEchelle == 358) {
         this.var_lib_echelle = "40 pieds";
      } else if (this.uniEchelle == 450) {
         this.var_lib_echelle = "millimètre cube";
      } else if (this.uniEchelle == 451) {
         this.var_lib_echelle = "centimètre cube";
      } else if (this.uniEchelle == 432) {
         this.var_lib_echelle = "décimètre cube";
      } else if (this.uniEchelle == 453) {
         this.var_lib_echelle = "mètre cube";
      } else if (this.uniEchelle == 454) {
         this.var_lib_echelle = "décamètre cube";
      } else if (this.uniEchelle == 455) {
         this.var_lib_echelle = "hectomètre cube";
      } else if (this.uniEchelle == 456) {
         this.var_lib_echelle = "kilomètre cube";
      } else if (this.uniEchelle == 550) {
         this.var_lib_echelle = "millilitre";
      } else if (this.uniEchelle == 551) {
         this.var_lib_echelle = "centilitre";
      } else if (this.uniEchelle == 552) {
         this.var_lib_echelle = "décilitre";
      } else if (this.uniEchelle == 553) {
         this.var_lib_echelle = "litre";
      } else if (this.uniEchelle == 554) {
         this.var_lib_echelle = "décalitre";
      } else if (this.uniEchelle == 555) {
         this.var_lib_echelle = "hectolitre";
      } else if (this.uniEchelle == 556) {
         this.var_lib_echelle = "kilolitre";
      } else if (this.uniEchelle == 557) {
         this.var_lib_echelle = "gallon";
      } else if (this.uniEchelle == 558) {
         this.var_lib_echelle = "baril";
      } else if (this.uniEchelle == 559) {
         this.var_lib_echelle = "fut";
      } else if (this.uniEchelle == 560) {
         this.var_lib_echelle = "cubi";
      } else if (this.uniEchelle == 650) {
         this.var_lib_echelle = "milligramme";
      } else if (this.uniEchelle == 651) {
         this.var_lib_echelle = "centigramme";
      } else if (this.uniEchelle == 652) {
         this.var_lib_echelle = "décigramme";
      } else if (this.uniEchelle == 653) {
         this.var_lib_echelle = "gramme";
      } else if (this.uniEchelle == 654) {
         this.var_lib_echelle = "décagramme";
      } else if (this.uniEchelle == 655) {
         this.var_lib_echelle = "hectogramme";
      } else if (this.uniEchelle == 656) {
         this.var_lib_echelle = "kilogramme";
      } else if (this.uniEchelle == 657) {
         this.var_lib_echelle = "quintal";
      } else if (this.uniEchelle == 658) {
         this.var_lib_echelle = "tonne";
      } else if (this.uniEchelle == 750) {
         this.var_lib_echelle = "unité";
      } else if (this.uniEchelle == 751) {
         this.var_lib_echelle = "sac";
      } else if (this.uniEchelle == 752) {
         this.var_lib_echelle = "carat";
      } else if (this.uniEchelle == 810) {
         this.var_lib_echelle = "pièce";
      } else if (this.uniEchelle == 860) {
         this.var_lib_echelle = "pression";
      }

      return this.var_lib_echelle;
   }

   public String getVar_lib_echelle() {
      this.var_lib_echelle = this.conversion();
      return this.var_lib_echelle;
   }

   public void setVar_lib_echelle(String var1) {
      this.var_lib_echelle = var1;
   }
}
