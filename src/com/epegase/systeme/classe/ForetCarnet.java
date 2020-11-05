package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ForetCarnet implements Serializable {
   private long forcarId;
   private Date forcarDateCreat;
   private Date forcarDateModif;
   private long forcarUserCreat;
   private long forcarUserModif;
   private String forcarNomEquipe;
   private long forcarIdEquipe;
   private String forcarNomResponsable;
   private long forcarIdResponsable;
   private String forcarNomCommercial;
   private long forcarIdCommercial;
   private String forcarNum;
   private Date forcarDate;
   private String forcarSerie;
   private String forcarChantier;
   private String forcarRegion;
   private String forcarMarteau;
   private float forcarCubInv;
   private int forcarTotArbre;
   private int forcarTotGrume;
   private float forcarTotCub;
   private int forcarEtat;
   private int forcarEtatVal;
   private Date forcarDateValide;
   private String forcarModeleImp;
   private Date forcarDateImp;
   private Date forcarDateAnnule;
   private String forcarMotifAnnule;
   private ExercicesVentes exercicesVentes;
   private String libelleEta;
   private boolean var_select_ligne;

   public String getLibelleEta() {
      if (this.forcarEtat == 0) {
         this.libelleEta = "EC";
      } else if (this.forcarEtat == 1) {
         this.libelleEta = "VAL.";
      } else if (this.forcarEtat == 2) {
         this.libelleEta = "GEL.";
      } else if (this.forcarEtat == 3) {
         this.libelleEta = "ANN.";
      } else if (this.forcarEtat == 6) {
         this.libelleEta = "COR.";
      } else if (this.forcarEtat == 7) {
         this.libelleEta = "REJ.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public String getForcarChantier() {
      return this.forcarChantier;
   }

   public void setForcarChantier(String var1) {
      this.forcarChantier = var1;
   }

   public float getForcarCubInv() {
      return this.forcarCubInv;
   }

   public void setForcarCubInv(float var1) {
      this.forcarCubInv = var1;
   }

   public Date getForcarDate() {
      return this.forcarDate;
   }

   public void setForcarDate(Date var1) {
      this.forcarDate = var1;
   }

   public Date getForcarDateAnnule() {
      return this.forcarDateAnnule;
   }

   public void setForcarDateAnnule(Date var1) {
      this.forcarDateAnnule = var1;
   }

   public Date getForcarDateCreat() {
      return this.forcarDateCreat;
   }

   public void setForcarDateCreat(Date var1) {
      this.forcarDateCreat = var1;
   }

   public Date getForcarDateImp() {
      return this.forcarDateImp;
   }

   public void setForcarDateImp(Date var1) {
      this.forcarDateImp = var1;
   }

   public Date getForcarDateModif() {
      return this.forcarDateModif;
   }

   public void setForcarDateModif(Date var1) {
      this.forcarDateModif = var1;
   }

   public Date getForcarDateValide() {
      return this.forcarDateValide;
   }

   public void setForcarDateValide(Date var1) {
      this.forcarDateValide = var1;
   }

   public int getForcarEtat() {
      return this.forcarEtat;
   }

   public void setForcarEtat(int var1) {
      this.forcarEtat = var1;
   }

   public int getForcarEtatVal() {
      return this.forcarEtatVal;
   }

   public void setForcarEtatVal(int var1) {
      this.forcarEtatVal = var1;
   }

   public long getForcarId() {
      return this.forcarId;
   }

   public void setForcarId(long var1) {
      this.forcarId = var1;
   }

   public long getForcarIdCommercial() {
      return this.forcarIdCommercial;
   }

   public void setForcarIdCommercial(long var1) {
      this.forcarIdCommercial = var1;
   }

   public long getForcarIdEquipe() {
      return this.forcarIdEquipe;
   }

   public void setForcarIdEquipe(long var1) {
      this.forcarIdEquipe = var1;
   }

   public long getForcarIdResponsable() {
      return this.forcarIdResponsable;
   }

   public void setForcarIdResponsable(long var1) {
      this.forcarIdResponsable = var1;
   }

   public String getForcarMarteau() {
      return this.forcarMarteau;
   }

   public void setForcarMarteau(String var1) {
      this.forcarMarteau = var1;
   }

   public String getForcarModeleImp() {
      return this.forcarModeleImp;
   }

   public void setForcarModeleImp(String var1) {
      this.forcarModeleImp = var1;
   }

   public String getForcarMotifAnnule() {
      return this.forcarMotifAnnule;
   }

   public void setForcarMotifAnnule(String var1) {
      this.forcarMotifAnnule = var1;
   }

   public String getForcarNomCommercial() {
      return this.forcarNomCommercial;
   }

   public void setForcarNomCommercial(String var1) {
      this.forcarNomCommercial = var1;
   }

   public String getForcarNomEquipe() {
      return this.forcarNomEquipe;
   }

   public void setForcarNomEquipe(String var1) {
      this.forcarNomEquipe = var1;
   }

   public String getForcarNomResponsable() {
      return this.forcarNomResponsable;
   }

   public void setForcarNomResponsable(String var1) {
      this.forcarNomResponsable = var1;
   }

   public String getForcarNum() {
      return this.forcarNum;
   }

   public void setForcarNum(String var1) {
      this.forcarNum = var1;
   }

   public String getForcarRegion() {
      return this.forcarRegion;
   }

   public void setForcarRegion(String var1) {
      this.forcarRegion = var1;
   }

   public String getForcarSerie() {
      return this.forcarSerie;
   }

   public void setForcarSerie(String var1) {
      this.forcarSerie = var1;
   }

   public int getForcarTotArbre() {
      return this.forcarTotArbre;
   }

   public void setForcarTotArbre(int var1) {
      this.forcarTotArbre = var1;
   }

   public float getForcarTotCub() {
      return this.forcarTotCub;
   }

   public void setForcarTotCub(float var1) {
      this.forcarTotCub = var1;
   }

   public int getForcarTotGrume() {
      return this.forcarTotGrume;
   }

   public void setForcarTotGrume(int var1) {
      this.forcarTotGrume = var1;
   }

   public long getForcarUserCreat() {
      return this.forcarUserCreat;
   }

   public void setForcarUserCreat(long var1) {
      this.forcarUserCreat = var1;
   }

   public long getForcarUserModif() {
      return this.forcarUserModif;
   }

   public void setForcarUserModif(long var1) {
      this.forcarUserModif = var1;
   }
}
