package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ParcAffectation implements Serializable {
   private long prcaffId;
   private Date prcaffDateCreat;
   private Date prcaffDateModif;
   private long prcaffUserCreat;
   private long prcaffUserModif;
   private int prcaffType;
   private String prcaffMatSalarie;
   private String prcaffNomSalarie;
   private String prcaffPrenomSalarie;
   private String prcaffService;
   private String prcaffLibService;
   private long prcaffIdTiers;
   private String prcaffNomTiers;
   private String prcaffContactTiers;
   private String prcaffTelTiers;
   private String prcaffVilleTiers;
   private String prcaffAdresseTiers;
   private Date prcaffDateDebut;
   private Date prcaffDateFin;
   private Parc parc;

   public Date getPrcaffDateCreat() {
      return this.prcaffDateCreat;
   }

   public void setPrcaffDateCreat(Date var1) {
      this.prcaffDateCreat = var1;
   }

   public Date getPrcaffDateDebut() {
      return this.prcaffDateDebut;
   }

   public void setPrcaffDateDebut(Date var1) {
      this.prcaffDateDebut = var1;
   }

   public Date getPrcaffDateFin() {
      return this.prcaffDateFin;
   }

   public void setPrcaffDateFin(Date var1) {
      this.prcaffDateFin = var1;
   }

   public Date getPrcaffDateModif() {
      return this.prcaffDateModif;
   }

   public void setPrcaffDateModif(Date var1) {
      this.prcaffDateModif = var1;
   }

   public long getPrcaffId() {
      return this.prcaffId;
   }

   public void setPrcaffId(long var1) {
      this.prcaffId = var1;
   }

   public String getPrcaffLibService() {
      return this.prcaffLibService;
   }

   public void setPrcaffLibService(String var1) {
      this.prcaffLibService = var1;
   }

   public String getPrcaffMatSalarie() {
      return this.prcaffMatSalarie;
   }

   public void setPrcaffMatSalarie(String var1) {
      this.prcaffMatSalarie = var1;
   }

   public String getPrcaffNomSalarie() {
      return this.prcaffNomSalarie;
   }

   public void setPrcaffNomSalarie(String var1) {
      this.prcaffNomSalarie = var1;
   }

   public String getPrcaffService() {
      return this.prcaffService;
   }

   public void setPrcaffService(String var1) {
      this.prcaffService = var1;
   }

   public int getPrcaffType() {
      return this.prcaffType;
   }

   public void setPrcaffType(int var1) {
      this.prcaffType = var1;
   }

   public long getPrcaffUserCreat() {
      return this.prcaffUserCreat;
   }

   public void setPrcaffUserCreat(long var1) {
      this.prcaffUserCreat = var1;
   }

   public long getPrcaffUserModif() {
      return this.prcaffUserModif;
   }

   public void setPrcaffUserModif(long var1) {
      this.prcaffUserModif = var1;
   }

   public Parc getParc() {
      return this.parc;
   }

   public void setParc(Parc var1) {
      this.parc = var1;
   }

   public String getPrcaffPrenomSalarie() {
      return this.prcaffPrenomSalarie;
   }

   public void setPrcaffPrenomSalarie(String var1) {
      this.prcaffPrenomSalarie = var1;
   }

   public String getPrcaffContactTiers() {
      return this.prcaffContactTiers;
   }

   public void setPrcaffContactTiers(String var1) {
      this.prcaffContactTiers = var1;
   }

   public long getPrcaffIdTiers() {
      return this.prcaffIdTiers;
   }

   public void setPrcaffIdTiers(long var1) {
      this.prcaffIdTiers = var1;
   }

   public String getPrcaffNomTiers() {
      return this.prcaffNomTiers;
   }

   public void setPrcaffNomTiers(String var1) {
      this.prcaffNomTiers = var1;
   }

   public String getPrcaffTelTiers() {
      return this.prcaffTelTiers;
   }

   public void setPrcaffTelTiers(String var1) {
      this.prcaffTelTiers = var1;
   }

   public String getPrcaffAdresseTiers() {
      return this.prcaffAdresseTiers;
   }

   public void setPrcaffAdresseTiers(String var1) {
      this.prcaffAdresseTiers = var1;
   }

   public String getPrcaffVilleTiers() {
      return this.prcaffVilleTiers;
   }

   public void setPrcaffVilleTiers(String var1) {
      this.prcaffVilleTiers = var1;
   }
}
