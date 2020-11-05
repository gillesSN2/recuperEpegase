package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ReceptionLotAchats implements Serializable {
   private long reclotId;
   private long reclotIdLigne;
   private String reclotNum;
   private Date reclotDateAchat;
   private long reclotIdLigneFab;
   private String reclotNumFab;
   private Date reclotDateFab;
   private Date reclotDateValable;
   private float reclotQte;
   private float reclotQteUtil;
   private float reclotQteConso;
   private float reclotQteUtilConso;
   private String reclotCode;
   private String reclotDepot;
   private double reclotPr;
   private float reclotLong;
   private float reclotLarg;
   private float reclotHaut;
   private float reclotDiam;
   private float reclotNb;
   private float reclotPoidsNet;
   private float reclotPoidsBrut;
   private float reclotPoidsTare;
   private String reclotNumero;
   private float var_qteDispo;
   private float var_volumeDispo;

   public float getVar_qteDispo() {
      this.var_qteDispo = this.reclotQte - this.reclotQteConso;
      return this.var_qteDispo;
   }

   public void setVar_qteDispo(float var1) {
      this.var_qteDispo = var1;
   }

   public float getVar_volumeDispo() {
      this.var_volumeDispo = this.reclotQteUtil - this.reclotQteUtilConso;
      return this.var_volumeDispo;
   }

   public void setVar_volumeDispo(float var1) {
      this.var_volumeDispo = var1;
   }

   public String getReclotCode() {
      return this.reclotCode;
   }

   public void setReclotCode(String var1) {
      this.reclotCode = var1;
   }

   public Date getReclotDateAchat() {
      return this.reclotDateAchat;
   }

   public void setReclotDateAchat(Date var1) {
      this.reclotDateAchat = var1;
   }

   public Date getReclotDateValable() {
      return this.reclotDateValable;
   }

   public void setReclotDateValable(Date var1) {
      this.reclotDateValable = var1;
   }

   public long getReclotId() {
      return this.reclotId;
   }

   public void setReclotId(long var1) {
      this.reclotId = var1;
   }

   public String getReclotNum() {
      return this.reclotNum;
   }

   public void setReclotNum(String var1) {
      this.reclotNum = var1;
   }

   public double getReclotPr() {
      return this.reclotPr;
   }

   public void setReclotPr(double var1) {
      this.reclotPr = var1;
   }

   public float getReclotQte() {
      return this.reclotQte;
   }

   public void setReclotQte(float var1) {
      this.reclotQte = var1;
   }

   public float getReclotDiam() {
      return this.reclotDiam;
   }

   public void setReclotDiam(float var1) {
      this.reclotDiam = var1;
   }

   public float getReclotHaut() {
      return this.reclotHaut;
   }

   public void setReclotHaut(float var1) {
      this.reclotHaut = var1;
   }

   public float getReclotLarg() {
      return this.reclotLarg;
   }

   public void setReclotLarg(float var1) {
      this.reclotLarg = var1;
   }

   public float getReclotLong() {
      return this.reclotLong;
   }

   public void setReclotLong(float var1) {
      this.reclotLong = var1;
   }

   public float getReclotNb() {
      return this.reclotNb;
   }

   public void setReclotNb(float var1) {
      this.reclotNb = var1;
   }

   public float getReclotPoidsBrut() {
      return this.reclotPoidsBrut;
   }

   public void setReclotPoidsBrut(float var1) {
      this.reclotPoidsBrut = var1;
   }

   public float getReclotPoidsNet() {
      return this.reclotPoidsNet;
   }

   public void setReclotPoidsNet(float var1) {
      this.reclotPoidsNet = var1;
   }

   public String getReclotNumero() {
      return this.reclotNumero;
   }

   public void setReclotNumero(String var1) {
      this.reclotNumero = var1;
   }

   public String getReclotDepot() {
      return this.reclotDepot;
   }

   public void setReclotDepot(String var1) {
      this.reclotDepot = var1;
   }

   public float getReclotQteConso() {
      return this.reclotQteConso;
   }

   public void setReclotQteConso(float var1) {
      this.reclotQteConso = var1;
   }

   public float getReclotQteUtilConso() {
      return this.reclotQteUtilConso;
   }

   public void setReclotQteUtilConso(float var1) {
      this.reclotQteUtilConso = var1;
   }

   public float getReclotQteUtil() {
      return this.reclotQteUtil;
   }

   public void setReclotQteUtil(float var1) {
      this.reclotQteUtil = var1;
   }

   public float getReclotPoidsTare() {
      return this.reclotPoidsTare;
   }

   public void setReclotPoidsTare(float var1) {
      this.reclotPoidsTare = var1;
   }

   public long getReclotIdLigne() {
      return this.reclotIdLigne;
   }

   public void setReclotIdLigne(long var1) {
      this.reclotIdLigne = var1;
   }

   public Date getReclotDateFab() {
      return this.reclotDateFab;
   }

   public void setReclotDateFab(Date var1) {
      this.reclotDateFab = var1;
   }

   public long getReclotIdLigneFab() {
      return this.reclotIdLigneFab;
   }

   public void setReclotIdLigneFab(long var1) {
      this.reclotIdLigneFab = var1;
   }

   public String getReclotNumFab() {
      return this.reclotNumFab;
   }

   public void setReclotNumFab(String var1) {
      this.reclotNumFab = var1;
   }
}
