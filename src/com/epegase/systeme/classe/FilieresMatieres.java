package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FilieresMatieres implements Serializable {
   private long filmatId;
   private Date filmatDateCreat;
   private Date filmatDateModif;
   private long filmatUserCreat;
   private long filmatUserModif;
   private String filmatCode;
   private String filmatLibelle;
   private int filmatMode;
   private String filmatNomProfesseur;
   private long filmatIdProfesseur;
   private String filmatDescription;
   private float filmatNbHeures;
   private float filmatMoy1T;
   private float filmatMoy2T;
   private float filmatMoy3T;
   private float filmatMoy4T;
   private float filmatMoyG;
   private float filmatNbAbsJ1T;
   private float filmatNbAbsNJ1T;
   private float filmatNbAbsEX1T;
   private float filmatNbRetJ1T;
   private float filmatNbRetNJ1T;
   private float filmatNbAbsJ2T;
   private float filmatNbAbsNJ2T;
   private float filmatNbAbsEX2T;
   private float filmatNbRetJ2T;
   private float filmatNbRetNJ2T;
   private float filmatNbAbsJ3T;
   private float filmatNbAbsNJ3T;
   private float filmatNbAbsEX3T;
   private float filmatNbRetJ3T;
   private float filmatNbRetNJ3T;
   private float filmatNbAbsJ4T;
   private float filmatNbAbsNJ4T;
   private float filmatNbAbsEX4T;
   private float filmatNbRetJ4T;
   private float filmatNbRetNJ4T;
   private int filmatNbEle1T;
   private int filmatNbEle2T;
   private int filmatNbEle3T;
   private int filmatNbEle4T;
   private int filmatNbEleG;
   private int filmatNbViolSubi1T;
   private int filmatNbViolCause1T;
   private int filmatNbViolSubi2T;
   private int filmatNbViolCause2T;
   private int filmatNbViolSubi3T;
   private int filmatNbViolCause3T;
   private int filmatNbViolSubi4T;
   private int filmatNbViolCause4T;
   private FilieresEducation filieresEducation;
   private String libelleMode;

   public FilieresEducation getFilieresEducation() {
      return this.filieresEducation;
   }

   public void setFilieresEducation(FilieresEducation var1) {
      this.filieresEducation = var1;
   }

   public String getLibelleMode() {
      this.libelleMode = "";
      if (this.filmatMode == 0) {
         this.libelleMode = "Appréciation";
      } else if (this.filmatMode == 1) {
         this.libelleMode = "Moyenne";
      } else if (this.filmatMode == 2) {
         this.libelleMode = "U.E.";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public String getFilmatCode() {
      return this.filmatCode;
   }

   public void setFilmatCode(String var1) {
      this.filmatCode = var1;
   }

   public Date getFilmatDateCreat() {
      return this.filmatDateCreat;
   }

   public void setFilmatDateCreat(Date var1) {
      this.filmatDateCreat = var1;
   }

   public Date getFilmatDateModif() {
      return this.filmatDateModif;
   }

   public void setFilmatDateModif(Date var1) {
      this.filmatDateModif = var1;
   }

   public long getFilmatId() {
      return this.filmatId;
   }

   public void setFilmatId(long var1) {
      this.filmatId = var1;
   }

   public long getFilmatIdProfesseur() {
      return this.filmatIdProfesseur;
   }

   public void setFilmatIdProfesseur(long var1) {
      this.filmatIdProfesseur = var1;
   }

   public String getFilmatLibelle() {
      return this.filmatLibelle;
   }

   public void setFilmatLibelle(String var1) {
      this.filmatLibelle = var1;
   }

   public int getFilmatMode() {
      return this.filmatMode;
   }

   public void setFilmatMode(int var1) {
      this.filmatMode = var1;
   }

   public String getFilmatNomProfesseur() {
      return this.filmatNomProfesseur;
   }

   public void setFilmatNomProfesseur(String var1) {
      this.filmatNomProfesseur = var1;
   }

   public long getFilmatUserCreat() {
      return this.filmatUserCreat;
   }

   public void setFilmatUserCreat(long var1) {
      this.filmatUserCreat = var1;
   }

   public long getFilmatUserModif() {
      return this.filmatUserModif;
   }

   public void setFilmatUserModif(long var1) {
      this.filmatUserModif = var1;
   }

   public String getFilmatDescription() {
      return this.filmatDescription;
   }

   public void setFilmatDescription(String var1) {
      this.filmatDescription = var1;
   }

   public float getFilmatNbHeures() {
      return this.filmatNbHeures;
   }

   public void setFilmatNbHeures(float var1) {
      this.filmatNbHeures = var1;
   }

   public float getFilmatMoy1T() {
      return this.filmatMoy1T;
   }

   public void setFilmatMoy1T(float var1) {
      this.filmatMoy1T = var1;
   }

   public float getFilmatMoy2T() {
      return this.filmatMoy2T;
   }

   public void setFilmatMoy2T(float var1) {
      this.filmatMoy2T = var1;
   }

   public float getFilmatMoy3T() {
      return this.filmatMoy3T;
   }

   public void setFilmatMoy3T(float var1) {
      this.filmatMoy3T = var1;
   }

   public float getFilmatMoy4T() {
      return this.filmatMoy4T;
   }

   public void setFilmatMoy4T(float var1) {
      this.filmatMoy4T = var1;
   }

   public float getFilmatMoyG() {
      return this.filmatMoyG;
   }

   public void setFilmatMoyG(float var1) {
      this.filmatMoyG = var1;
   }

   public int getFilmatNbEle1T() {
      return this.filmatNbEle1T;
   }

   public void setFilmatNbEle1T(int var1) {
      this.filmatNbEle1T = var1;
   }

   public int getFilmatNbEle2T() {
      return this.filmatNbEle2T;
   }

   public void setFilmatNbEle2T(int var1) {
      this.filmatNbEle2T = var1;
   }

   public int getFilmatNbEle3T() {
      return this.filmatNbEle3T;
   }

   public void setFilmatNbEle3T(int var1) {
      this.filmatNbEle3T = var1;
   }

   public int getFilmatNbEle4T() {
      return this.filmatNbEle4T;
   }

   public void setFilmatNbEle4T(int var1) {
      this.filmatNbEle4T = var1;
   }

   public int getFilmatNbEleG() {
      return this.filmatNbEleG;
   }

   public void setFilmatNbEleG(int var1) {
      this.filmatNbEleG = var1;
   }

   public float getFilmatNbAbsEX1T() {
      return this.filmatNbAbsEX1T;
   }

   public void setFilmatNbAbsEX1T(float var1) {
      this.filmatNbAbsEX1T = var1;
   }

   public float getFilmatNbAbsEX2T() {
      return this.filmatNbAbsEX2T;
   }

   public void setFilmatNbAbsEX2T(float var1) {
      this.filmatNbAbsEX2T = var1;
   }

   public float getFilmatNbAbsEX3T() {
      return this.filmatNbAbsEX3T;
   }

   public void setFilmatNbAbsEX3T(float var1) {
      this.filmatNbAbsEX3T = var1;
   }

   public float getFilmatNbAbsEX4T() {
      return this.filmatNbAbsEX4T;
   }

   public void setFilmatNbAbsEX4T(float var1) {
      this.filmatNbAbsEX4T = var1;
   }

   public float getFilmatNbAbsJ1T() {
      return this.filmatNbAbsJ1T;
   }

   public void setFilmatNbAbsJ1T(float var1) {
      this.filmatNbAbsJ1T = var1;
   }

   public float getFilmatNbAbsJ2T() {
      return this.filmatNbAbsJ2T;
   }

   public void setFilmatNbAbsJ2T(float var1) {
      this.filmatNbAbsJ2T = var1;
   }

   public float getFilmatNbAbsJ3T() {
      return this.filmatNbAbsJ3T;
   }

   public void setFilmatNbAbsJ3T(float var1) {
      this.filmatNbAbsJ3T = var1;
   }

   public float getFilmatNbAbsJ4T() {
      return this.filmatNbAbsJ4T;
   }

   public void setFilmatNbAbsJ4T(float var1) {
      this.filmatNbAbsJ4T = var1;
   }

   public float getFilmatNbAbsNJ1T() {
      return this.filmatNbAbsNJ1T;
   }

   public void setFilmatNbAbsNJ1T(float var1) {
      this.filmatNbAbsNJ1T = var1;
   }

   public float getFilmatNbAbsNJ2T() {
      return this.filmatNbAbsNJ2T;
   }

   public void setFilmatNbAbsNJ2T(float var1) {
      this.filmatNbAbsNJ2T = var1;
   }

   public float getFilmatNbAbsNJ3T() {
      return this.filmatNbAbsNJ3T;
   }

   public void setFilmatNbAbsNJ3T(float var1) {
      this.filmatNbAbsNJ3T = var1;
   }

   public float getFilmatNbAbsNJ4T() {
      return this.filmatNbAbsNJ4T;
   }

   public void setFilmatNbAbsNJ4T(float var1) {
      this.filmatNbAbsNJ4T = var1;
   }

   public float getFilmatNbRetJ1T() {
      return this.filmatNbRetJ1T;
   }

   public void setFilmatNbRetJ1T(float var1) {
      this.filmatNbRetJ1T = var1;
   }

   public float getFilmatNbRetJ2T() {
      return this.filmatNbRetJ2T;
   }

   public void setFilmatNbRetJ2T(float var1) {
      this.filmatNbRetJ2T = var1;
   }

   public float getFilmatNbRetJ3T() {
      return this.filmatNbRetJ3T;
   }

   public void setFilmatNbRetJ3T(float var1) {
      this.filmatNbRetJ3T = var1;
   }

   public float getFilmatNbRetJ4T() {
      return this.filmatNbRetJ4T;
   }

   public void setFilmatNbRetJ4T(float var1) {
      this.filmatNbRetJ4T = var1;
   }

   public float getFilmatNbRetNJ1T() {
      return this.filmatNbRetNJ1T;
   }

   public void setFilmatNbRetNJ1T(float var1) {
      this.filmatNbRetNJ1T = var1;
   }

   public float getFilmatNbRetNJ2T() {
      return this.filmatNbRetNJ2T;
   }

   public void setFilmatNbRetNJ2T(float var1) {
      this.filmatNbRetNJ2T = var1;
   }

   public float getFilmatNbRetNJ3T() {
      return this.filmatNbRetNJ3T;
   }

   public void setFilmatNbRetNJ3T(float var1) {
      this.filmatNbRetNJ3T = var1;
   }

   public float getFilmatNbRetNJ4T() {
      return this.filmatNbRetNJ4T;
   }

   public void setFilmatNbRetNJ4T(float var1) {
      this.filmatNbRetNJ4T = var1;
   }

   public int getFilmatNbViolCause1T() {
      return this.filmatNbViolCause1T;
   }

   public void setFilmatNbViolCause1T(int var1) {
      this.filmatNbViolCause1T = var1;
   }

   public int getFilmatNbViolCause2T() {
      return this.filmatNbViolCause2T;
   }

   public void setFilmatNbViolCause2T(int var1) {
      this.filmatNbViolCause2T = var1;
   }

   public int getFilmatNbViolCause3T() {
      return this.filmatNbViolCause3T;
   }

   public void setFilmatNbViolCause3T(int var1) {
      this.filmatNbViolCause3T = var1;
   }

   public int getFilmatNbViolCause4T() {
      return this.filmatNbViolCause4T;
   }

   public void setFilmatNbViolCause4T(int var1) {
      this.filmatNbViolCause4T = var1;
   }

   public int getFilmatNbViolSubi1T() {
      return this.filmatNbViolSubi1T;
   }

   public void setFilmatNbViolSubi1T(int var1) {
      this.filmatNbViolSubi1T = var1;
   }

   public int getFilmatNbViolSubi2T() {
      return this.filmatNbViolSubi2T;
   }

   public void setFilmatNbViolSubi2T(int var1) {
      this.filmatNbViolSubi2T = var1;
   }

   public int getFilmatNbViolSubi3T() {
      return this.filmatNbViolSubi3T;
   }

   public void setFilmatNbViolSubi3T(int var1) {
      this.filmatNbViolSubi3T = var1;
   }

   public int getFilmatNbViolSubi4T() {
      return this.filmatNbViolSubi4T;
   }

   public void setFilmatNbViolSubi4T(int var1) {
      this.filmatNbViolSubi4T = var1;
   }
}
