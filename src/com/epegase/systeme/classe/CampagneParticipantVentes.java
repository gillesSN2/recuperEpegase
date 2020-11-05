package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CampagneParticipantVentes implements Serializable {
   private long camparId;
   private Date camparDateCreat;
   private long camparIdCreateur;
   private String camparNomCreateur;
   private Date camparDateModif;
   private long camparIdModif;
   private String camparNomModif;
   private Date camparDate;
   private String camparCommentaire;
   private String camparAction;
   private String camparCadeau;
   private String camparNomTiers;
   private long camparIdTiers;
   private String camparNomCommercial;
   private long camparIdCommercial;
   private CampagneEnteteVentes campagneEnteteVentes;
   private Contacts contacts;

   public CampagneEnteteVentes getCampagneEnteteVentes() {
      return this.campagneEnteteVentes;
   }

   public void setCampagneEnteteVentes(CampagneEnteteVentes var1) {
      this.campagneEnteteVentes = var1;
   }

   public Contacts getContacts() {
      return this.contacts;
   }

   public void setContacts(Contacts var1) {
      this.contacts = var1;
   }

   public String getCamparAction() {
      return this.camparAction;
   }

   public void setCamparAction(String var1) {
      this.camparAction = var1;
   }

   public String getCamparCadeau() {
      return this.camparCadeau;
   }

   public void setCamparCadeau(String var1) {
      this.camparCadeau = var1;
   }

   public String getCamparCommentaire() {
      return this.camparCommentaire;
   }

   public void setCamparCommentaire(String var1) {
      this.camparCommentaire = var1;
   }

   public Date getCamparDate() {
      return this.camparDate;
   }

   public void setCamparDate(Date var1) {
      this.camparDate = var1;
   }

   public Date getCamparDateCreat() {
      return this.camparDateCreat;
   }

   public void setCamparDateCreat(Date var1) {
      this.camparDateCreat = var1;
   }

   public Date getCamparDateModif() {
      return this.camparDateModif;
   }

   public void setCamparDateModif(Date var1) {
      this.camparDateModif = var1;
   }

   public long getCamparId() {
      return this.camparId;
   }

   public void setCamparId(long var1) {
      this.camparId = var1;
   }

   public long getCamparIdCreateur() {
      return this.camparIdCreateur;
   }

   public void setCamparIdCreateur(long var1) {
      this.camparIdCreateur = var1;
   }

   public long getCamparIdModif() {
      return this.camparIdModif;
   }

   public void setCamparIdModif(long var1) {
      this.camparIdModif = var1;
   }

   public String getCamparNomCreateur() {
      return this.camparNomCreateur;
   }

   public void setCamparNomCreateur(String var1) {
      this.camparNomCreateur = var1;
   }

   public String getCamparNomModif() {
      return this.camparNomModif;
   }

   public void setCamparNomModif(String var1) {
      this.camparNomModif = var1;
   }

   public String getCamparNomTiers() {
      return this.camparNomTiers;
   }

   public void setCamparNomTiers(String var1) {
      this.camparNomTiers = var1;
   }

   public long getCamparIdTiers() {
      return this.camparIdTiers;
   }

   public void setCamparIdTiers(long var1) {
      this.camparIdTiers = var1;
   }

   public long getCamparIdCommercial() {
      return this.camparIdCommercial;
   }

   public void setCamparIdCommercial(long var1) {
      this.camparIdCommercial = var1;
   }

   public String getCamparNomCommercial() {
      return this.camparNomCommercial;
   }

   public void setCamparNomCommercial(String var1) {
      this.camparNomCommercial = var1;
   }
}
