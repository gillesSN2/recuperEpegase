package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class MotifEntreeMedical implements Serializable {
   private long mteId;
   private long mteUserCreation;
   private long mteUserModif;
   private Date mteDateCreation;
   private Date mteDateModif;
   private String mteCode;
   private String mteLibelle;
   private int mteInactif;
   private int mteConGene;
   private int mteConSpe;
   private int mteLab;
   private int mtePha;
   private int mteHosp;
   private int mteConv;
   private int mteConvAss;
   private int mteAT;
   private int mteVaccin;
   private int mteAudio;
   private int mteVme;
   private int mteVma;
   private int mteTubertest;
   private ExercicesVentes exerciceventes;
   private String etat;
   private boolean inactif;
   private boolean var_conGene;
   private boolean var_conSpe;
   private boolean var_lab;
   private boolean var_pha;
   private boolean var_hosp;
   private boolean var_convSoc;
   private boolean var_convAss;
   private boolean var_at;
   private boolean var_vaccin;
   private boolean var_audio;
   private boolean var_vme;
   private boolean var_vma;
   private boolean var_tubertest;

   public boolean isVar_convAss() {
      if (this.mteConvAss == 1) {
         this.var_convAss = true;
      } else {
         this.var_convAss = false;
      }

      return this.var_convAss;
   }

   public void setVar_convAss(boolean var1) {
      this.var_convAss = var1;
   }

   public boolean isVar_convSoc() {
      if (this.mteConv == 1) {
         this.var_convSoc = true;
      } else {
         this.var_convSoc = false;
      }

      return this.var_convSoc;
   }

   public void setVar_convSoc(boolean var1) {
      this.var_convSoc = var1;
   }

   public boolean isVar_tubertest() {
      if (this.mteTubertest == 1) {
         this.var_tubertest = true;
      } else {
         this.var_tubertest = false;
      }

      return this.var_tubertest;
   }

   public void setVar_tubertest(boolean var1) {
      this.var_tubertest = var1;
   }

   public boolean isVar_vma() {
      if (this.mteVma == 1) {
         this.var_vma = true;
      } else {
         this.var_vma = false;
      }

      return this.var_vma;
   }

   public void setVar_vma(boolean var1) {
      this.var_vma = var1;
   }

   public boolean isVar_vme() {
      if (this.mteVme == 1) {
         this.var_vme = true;
      } else {
         this.var_vme = false;
      }

      return this.var_vme;
   }

   public void setVar_vme(boolean var1) {
      this.var_vme = var1;
   }

   public String getEtat() {
      if (this.mteInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.mteInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isVar_audio() {
      if (this.mteAudio == 1) {
         this.var_audio = true;
      } else {
         this.var_audio = false;
      }

      return this.var_audio;
   }

   public void setVar_audio(boolean var1) {
      this.var_audio = var1;
   }

   public boolean isInactif() {
      if (this.mteInactif != 1 && this.mteInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public String getMteCode() {
      if (this.mteCode != null && !this.mteCode.isEmpty()) {
         this.mteCode = this.mteCode.toUpperCase();
      }

      return this.mteCode;
   }

   public void setMteCode(String var1) {
      this.mteCode = var1;
   }

   public Date getMteDateCreation() {
      return this.mteDateCreation;
   }

   public void setMteDateCreation(Date var1) {
      this.mteDateCreation = var1;
   }

   public Date getMteDateModif() {
      return this.mteDateModif;
   }

   public void setMteDateModif(Date var1) {
      this.mteDateModif = var1;
   }

   public long getMteId() {
      return this.mteId;
   }

   public void setMteId(long var1) {
      this.mteId = var1;
   }

   public int getMteInactif() {
      return this.mteInactif;
   }

   public void setMteInactif(int var1) {
      this.mteInactif = var1;
   }

   public String getMteLibelle() {
      if (this.mteLibelle != null && !this.mteLibelle.isEmpty()) {
         this.mteLibelle = this.mteLibelle.toUpperCase();
      }

      return this.mteLibelle;
   }

   public void setMteLibelle(String var1) {
      this.mteLibelle = var1;
   }

   public long getMteUserCreation() {
      return this.mteUserCreation;
   }

   public void setMteUserCreation(long var1) {
      this.mteUserCreation = var1;
   }

   public long getMteUserModif() {
      return this.mteUserModif;
   }

   public void setMteUserModif(long var1) {
      this.mteUserModif = var1;
   }

   public int getMteConGene() {
      return this.mteConGene;
   }

   public void setMteConGene(int var1) {
      this.mteConGene = var1;
   }

   public int getMteConSpe() {
      return this.mteConSpe;
   }

   public void setMteConSpe(int var1) {
      this.mteConSpe = var1;
   }

   public int getMteHosp() {
      return this.mteHosp;
   }

   public void setMteHosp(int var1) {
      this.mteHosp = var1;
   }

   public int getMteLab() {
      return this.mteLab;
   }

   public void setMteLab(int var1) {
      this.mteLab = var1;
   }

   public int getMtePha() {
      return this.mtePha;
   }

   public void setMtePha(int var1) {
      this.mtePha = var1;
   }

   public boolean isVar_conGene() {
      if (this.mteConGene == 1) {
         this.var_conGene = true;
      } else {
         this.var_conGene = false;
      }

      return this.var_conGene;
   }

   public void setVar_conGene(boolean var1) {
      this.var_conGene = var1;
   }

   public boolean isVar_conSpe() {
      if (this.mteConSpe == 1) {
         this.var_conSpe = true;
      } else {
         this.var_conSpe = false;
      }

      return this.var_conSpe;
   }

   public void setVar_conSpe(boolean var1) {
      this.var_conSpe = var1;
   }

   public boolean isVar_hosp() {
      if (this.mteHosp == 1) {
         this.var_hosp = true;
      } else {
         this.var_hosp = false;
      }

      return this.var_hosp;
   }

   public void setVar_hosp(boolean var1) {
      this.var_hosp = var1;
   }

   public boolean isVar_lab() {
      if (this.mteLab == 1) {
         this.var_lab = true;
      } else {
         this.var_lab = false;
      }

      return this.var_lab;
   }

   public void setVar_lab(boolean var1) {
      this.var_lab = var1;
   }

   public boolean isVar_pha() {
      if (this.mtePha == 1) {
         this.var_pha = true;
      } else {
         this.var_pha = false;
      }

      return this.var_pha;
   }

   public void setVar_pha(boolean var1) {
      this.var_pha = var1;
   }

   public int getMteAT() {
      return this.mteAT;
   }

   public void setMteAT(int var1) {
      this.mteAT = var1;
   }

   public boolean isVar_at() {
      if (this.mteAT == 1) {
         this.var_at = true;
      } else {
         this.var_at = false;
      }

      return this.var_at;
   }

   public void setVar_at(boolean var1) {
      this.var_at = var1;
   }

   public int getMteVaccin() {
      return this.mteVaccin;
   }

   public void setMteVaccin(int var1) {
      this.mteVaccin = var1;
   }

   public boolean isVar_vaccin() {
      if (this.mteVaccin == 1) {
         this.var_vaccin = true;
      } else {
         this.var_vaccin = false;
      }

      return this.var_vaccin;
   }

   public void setVar_vaccin(boolean var1) {
      this.var_vaccin = var1;
   }

   public int getMteAudio() {
      return this.mteAudio;
   }

   public void setMteAudio(int var1) {
      this.mteAudio = var1;
   }

   public int getMteTubertest() {
      return this.mteTubertest;
   }

   public void setMteTubertest(int var1) {
      this.mteTubertest = var1;
   }

   public int getMteVma() {
      return this.mteVma;
   }

   public void setMteVma(int var1) {
      this.mteVma = var1;
   }

   public int getMteVme() {
      return this.mteVme;
   }

   public void setMteVme(int var1) {
      this.mteVme = var1;
   }

   public int getMteConv() {
      return this.mteConv;
   }

   public void setMteConv(int var1) {
      this.mteConv = var1;
   }

   public int getMteConvAss() {
      return this.mteConvAss;
   }

   public void setMteConvAss(int var1) {
      this.mteConvAss = var1;
   }
}
