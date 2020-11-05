package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class LivraisonLivreeVentes implements Serializable {
   private long blvlivId;
   private long blvlivIdBl;
   private String blvlivCode;
   private String blvlivDepot;
   private float blvlivQteLivree;
   private float blvlivQteUtilLivree;
   private Date blvlivDate;
   private String blvlivChauffeur;
   private String blvlivVehicule;
   private String blvlivPreparateur;
   private LivraisonLigneVentes livraisonLigneVentes;
   private Set livrees = new HashSet();
   private float var_qteDejaLiv;

   public Set getLivrees() {
      return this.livrees;
   }

   public void setLivrees(Set var1) {
      this.livrees = var1;
   }

   public String getBlvlivCode() {
      return this.blvlivCode;
   }

   public void setBlvlivCode(String var1) {
      this.blvlivCode = var1;
   }

   public float getBlvlivQteUtilLivree() {
      return this.blvlivQteUtilLivree;
   }

   public void setBlvlivQteUtilLivree(float var1) {
      this.blvlivQteUtilLivree = var1;
   }

   public Date getBlvlivDate() {
      return this.blvlivDate;
   }

   public void setBlvlivDate(Date var1) {
      this.blvlivDate = var1;
   }

   public String getBlvlivDepot() {
      return this.blvlivDepot;
   }

   public void setBlvlivDepot(String var1) {
      this.blvlivDepot = var1;
   }

   public long getBlvlivId() {
      return this.blvlivId;
   }

   public void setBlvlivId(long var1) {
      this.blvlivId = var1;
   }

   public long getBlvlivIdBl() {
      return this.blvlivIdBl;
   }

   public void setBlvlivIdBl(long var1) {
      this.blvlivIdBl = var1;
   }

   public float getBlvlivQteLivree() {
      return this.blvlivQteLivree;
   }

   public void setBlvlivQteLivree(float var1) {
      this.blvlivQteLivree = var1;
   }

   public LivraisonLigneVentes getLivraisonLigneVentes() {
      return this.livraisonLigneVentes;
   }

   public void setLivraisonLigneVentes(LivraisonLigneVentes var1) {
      this.livraisonLigneVentes = var1;
   }

   public float getVar_qteDejaLiv() {
      return this.var_qteDejaLiv;
   }

   public void setVar_qteDejaLiv(float var1) {
      this.var_qteDejaLiv = var1;
   }

   public String getBlvlivChauffeur() {
      return this.blvlivChauffeur;
   }

   public void setBlvlivChauffeur(String var1) {
      this.blvlivChauffeur = var1;
   }

   public String getBlvlivPreparateur() {
      return this.blvlivPreparateur;
   }

   public void setBlvlivPreparateur(String var1) {
      this.blvlivPreparateur = var1;
   }

   public String getBlvlivVehicule() {
      return this.blvlivVehicule;
   }

   public void setBlvlivVehicule(String var1) {
      this.blvlivVehicule = var1;
   }
}
