package com.epegase.systeme.classe;

import java.util.Date;

public class EcrituresModeles {
   private long modId;
   private Date modDateCreat;
   private Date modDateModif;
   private long modUserCreat;
   private long modUserModif;
   private int modType;
   private String modCode;
   private String modLibelle;
   private int modNature;
   private String modJournal;
   private boolean modInactif;
   private String type;

   public String getType() {
      if (this.modType == 0) {
         this.type = "Modéle Ecriture";
      } else if (this.modType == 1) {
         this.type = "Modéle Amortissmeent";
      } else if (this.modType == 2) {
         this.type = "Modèle Note externe";
      } else {
         this.type = "???";
      }

      return this.type;
   }

   public void setType(String var1) {
      this.type = var1;
   }

   public String getModCode() {
      return this.modCode;
   }

   public void setModCode(String var1) {
      this.modCode = var1;
   }

   public Date getModDateCreat() {
      return this.modDateCreat;
   }

   public void setModDateCreat(Date var1) {
      this.modDateCreat = var1;
   }

   public Date getModDateModif() {
      return this.modDateModif;
   }

   public void setModDateModif(Date var1) {
      this.modDateModif = var1;
   }

   public long getModId() {
      return this.modId;
   }

   public void setModId(long var1) {
      this.modId = var1;
   }

   public boolean isModInactif() {
      return this.modInactif;
   }

   public void setModInactif(boolean var1) {
      this.modInactif = var1;
   }

   public String getModLibelle() {
      return this.modLibelle;
   }

   public void setModLibelle(String var1) {
      this.modLibelle = var1;
   }

   public int getModType() {
      return this.modType;
   }

   public void setModType(int var1) {
      this.modType = var1;
   }

   public long getModUserCreat() {
      return this.modUserCreat;
   }

   public void setModUserCreat(long var1) {
      this.modUserCreat = var1;
   }

   public long getModUserModif() {
      return this.modUserModif;
   }

   public void setModUserModif(long var1) {
      this.modUserModif = var1;
   }

   public int getModNature() {
      return this.modNature;
   }

   public void setModNature(int var1) {
      this.modNature = var1;
   }

   public String getModJournal() {
      return this.modJournal;
   }

   public void setModJournal(String var1) {
      this.modJournal = var1;
   }
}
