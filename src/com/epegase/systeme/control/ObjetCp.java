package com.epegase.systeme.control;

import java.io.Serializable;
import java.util.Date;

public class ObjetCp implements Serializable {
   private String matricule;
   private String patronyme;
   double baseConges;
   Date dateEntree;
   Date dateRetour;
   Date dateDepartTheo;
   double nbJourCp;
   double nbJourTr;
   double nbJourPris;
   double nbJourAcquis;
   double nbJourAnciennete;
   double nbJourEnfant;
   double nbJourDu;
   double valeurCongesTheo;
   double valeurCongesTheoAnciennete;
   double valeurCongesTheoEnfant;

   public double getBaseConges() {
      return this.baseConges;
   }

   public void setBaseConges(double var1) {
      this.baseConges = var1;
   }

   public Date getDateDepartTheo() {
      return this.dateDepartTheo;
   }

   public void setDateDepartTheo(Date var1) {
      this.dateDepartTheo = var1;
   }

   public Date getDateEntree() {
      return this.dateEntree;
   }

   public void setDateEntree(Date var1) {
      this.dateEntree = var1;
   }

   public Date getDateRetour() {
      return this.dateRetour;
   }

   public void setDateRetour(Date var1) {
      this.dateRetour = var1;
   }

   public String getMatricule() {
      return this.matricule;
   }

   public void setMatricule(String var1) {
      this.matricule = var1;
   }

   public double getNbJourAcquis() {
      return this.nbJourAcquis;
   }

   public void setNbJourAcquis(double var1) {
      this.nbJourAcquis = var1;
   }

   public double getNbJourAnciennete() {
      return this.nbJourAnciennete;
   }

   public void setNbJourAnciennete(double var1) {
      this.nbJourAnciennete = var1;
   }

   public double getNbJourCp() {
      return this.nbJourCp;
   }

   public void setNbJourCp(double var1) {
      this.nbJourCp = var1;
   }

   public double getNbJourDu() {
      return this.nbJourDu;
   }

   public void setNbJourDu(double var1) {
      this.nbJourDu = var1;
   }

   public double getNbJourEnfant() {
      return this.nbJourEnfant;
   }

   public void setNbJourEnfant(double var1) {
      this.nbJourEnfant = var1;
   }

   public double getNbJourPris() {
      return this.nbJourPris;
   }

   public void setNbJourPris(double var1) {
      this.nbJourPris = var1;
   }

   public double getNbJourTr() {
      return this.nbJourTr;
   }

   public void setNbJourTr(double var1) {
      this.nbJourTr = var1;
   }

   public String getPatronyme() {
      return this.patronyme;
   }

   public void setPatronyme(String var1) {
      this.patronyme = var1;
   }

   public double getValeurCongesTheo() {
      return this.valeurCongesTheo;
   }

   public void setValeurCongesTheo(double var1) {
      this.valeurCongesTheo = var1;
   }

   public double getValeurCongesTheoAnciennete() {
      return this.valeurCongesTheoAnciennete;
   }

   public void setValeurCongesTheoAnciennete(double var1) {
      this.valeurCongesTheoAnciennete = var1;
   }

   public double getValeurCongesTheoEnfant() {
      return this.valeurCongesTheoEnfant;
   }

   public void setValeurCongesTheoEnfant(double var1) {
      this.valeurCongesTheoEnfant = var1;
   }
}
