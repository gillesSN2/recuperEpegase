package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ForetInventaire implements Serializable {
   private long forinvId;
   private Date forinvDateCreat;
   private Date forinvDateModif;
   private long forinvUserCreat;
   private long forinvUserModif;
   private String forinvNomEquipe;
   private long forinvIdEquipe;
   private String forinvNomResponsable;
   private long forinvIdResponsable;
   private String forinvNomCommercial;
   private long forinvIdCommercial;
   private String forinvNum;
   private Date forinvDate;
   private String forinvSerie;
   private String forinvChantier;
   private String forinvRegion;
   private String forinvMarteau;
   private float forinvCubInv;
   private int forinvTotArbre;
   private float forinvTotCub;
   private int forinvEtat;
   private int forinvEtatVal;
   private Date forinvDateValide;
   private String forinvModeleImp;
   private Date forinvDateImp;
   private Date forinvDateAnnule;
   private String forinvMotifAnnule;
   private ExercicesVentes exercicesVentes;
   private String libelleEta;
   private boolean var_select_ligne;

   public String getLibelleEta() {
      if (this.forinvEtat == 0) {
         this.libelleEta = "EC";
      } else if (this.forinvEtat == 1) {
         this.libelleEta = "VAL.";
      } else if (this.forinvEtat == 2) {
         this.libelleEta = "GEL.";
      } else if (this.forinvEtat == 3) {
         this.libelleEta = "ANN.";
      } else if (this.forinvEtat == 6) {
         this.libelleEta = "COR.";
      } else if (this.forinvEtat == 7) {
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

   public String getForinvChantier() {
      return this.forinvChantier;
   }

   public void setForinvChantier(String var1) {
      this.forinvChantier = var1;
   }

   public float getForinvCubInv() {
      return this.forinvCubInv;
   }

   public void setForinvCubInv(float var1) {
      this.forinvCubInv = var1;
   }

   public Date getForinvDateCreat() {
      return this.forinvDateCreat;
   }

   public void setForinvDateCreat(Date var1) {
      this.forinvDateCreat = var1;
   }

   public Date getForinvDateModif() {
      return this.forinvDateModif;
   }

   public void setForinvDateModif(Date var1) {
      this.forinvDateModif = var1;
   }

   public long getForinvId() {
      return this.forinvId;
   }

   public void setForinvId(long var1) {
      this.forinvId = var1;
   }

   public String getForinvMarteau() {
      return this.forinvMarteau;
   }

   public void setForinvMarteau(String var1) {
      this.forinvMarteau = var1;
   }

   public int getForinvTotArbre() {
      return this.forinvTotArbre;
   }

   public void setForinvTotArbre(int var1) {
      this.forinvTotArbre = var1;
   }

   public float getForinvTotCub() {
      return this.forinvTotCub;
   }

   public void setForinvTotCub(float var1) {
      this.forinvTotCub = var1;
   }

   public long getForinvUserCreat() {
      return this.forinvUserCreat;
   }

   public void setForinvUserCreat(long var1) {
      this.forinvUserCreat = var1;
   }

   public long getForinvUserModif() {
      return this.forinvUserModif;
   }

   public void setForinvUserModif(long var1) {
      this.forinvUserModif = var1;
   }

   public String getForinvSerie() {
      return this.forinvSerie;
   }

   public void setForinvSerie(String var1) {
      this.forinvSerie = var1;
   }

   public int getForinvEtat() {
      return this.forinvEtat;
   }

   public void setForinvEtat(int var1) {
      this.forinvEtat = var1;
   }

   public long getForinvIdCommercial() {
      return this.forinvIdCommercial;
   }

   public void setForinvIdCommercial(long var1) {
      this.forinvIdCommercial = var1;
   }

   public long getForinvIdEquipe() {
      return this.forinvIdEquipe;
   }

   public void setForinvIdEquipe(long var1) {
      this.forinvIdEquipe = var1;
   }

   public long getForinvIdResponsable() {
      return this.forinvIdResponsable;
   }

   public void setForinvIdResponsable(long var1) {
      this.forinvIdResponsable = var1;
   }

   public String getForinvNomCommercial() {
      return this.forinvNomCommercial;
   }

   public void setForinvNomCommercial(String var1) {
      this.forinvNomCommercial = var1;
   }

   public String getForinvNomEquipe() {
      return this.forinvNomEquipe;
   }

   public void setForinvNomEquipe(String var1) {
      this.forinvNomEquipe = var1;
   }

   public String getForinvNomResponsable() {
      return this.forinvNomResponsable;
   }

   public void setForinvNomResponsable(String var1) {
      this.forinvNomResponsable = var1;
   }

   public Date getForinvDateValide() {
      return this.forinvDateValide;
   }

   public void setForinvDateValide(Date var1) {
      this.forinvDateValide = var1;
   }

   public int getForinvEtatVal() {
      return this.forinvEtatVal;
   }

   public void setForinvEtatVal(int var1) {
      this.forinvEtatVal = var1;
   }

   public String getForinvModeleImp() {
      return this.forinvModeleImp;
   }

   public void setForinvModeleImp(String var1) {
      this.forinvModeleImp = var1;
   }

   public Date getForinvDateImp() {
      return this.forinvDateImp;
   }

   public void setForinvDateImp(Date var1) {
      this.forinvDateImp = var1;
   }

   public Date getForinvDateAnnule() {
      return this.forinvDateAnnule;
   }

   public void setForinvDateAnnule(Date var1) {
      this.forinvDateAnnule = var1;
   }

   public Date getForinvDate() {
      return this.forinvDate;
   }

   public void setForinvDate(Date var1) {
      this.forinvDate = var1;
   }

   public String getForinvNum() {
      return this.forinvNum;
   }

   public void setForinvNum(String var1) {
      this.forinvNum = var1;
   }

   public String getForinvRegion() {
      return this.forinvRegion;
   }

   public void setForinvRegion(String var1) {
      this.forinvRegion = var1;
   }

   public String getForinvMotifAnnule() {
      return this.forinvMotifAnnule;
   }

   public void setForinvMotifAnnule(String var1) {
      this.forinvMotifAnnule = var1;
   }
}
