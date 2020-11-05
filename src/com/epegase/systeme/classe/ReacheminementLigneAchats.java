package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReacheminementLigneAchats implements Serializable {
   private long realigId;
   private long realigIdRec;
   private int realigOrdre;
   private String realigCode;
   private String realigFamille;
   private String realigLibelle;
   private int realigStock;
   private String realigUnite;
   private String realigCondition;
   private String realigDescription;
   private int realigEchelle;
   private float realigLong;
   private float realigLarg;
   private float realigHaut;
   private float realigDiam;
   private float realigNb;
   private float realigVolume;
   private Date realigOrigDate;
   private float realigOrigQte;
   private float realigOrigPoidsNet;
   private float realigOrigPoidsBrut;
   private int realigOrigNbSac;
   private float realigOrigQteUtil;
   private String realigOrigDepot;
   private Date realigDestDate;
   private float realigDestQte;
   private float realigDestPoidsNet;
   private float realigDestPoidsBrut;
   private int realigDestNbSac;
   private float realigDestQteUtil;
   private String realigDestDepot;
   private double realigPr;
   private double realigPump;
   private String realigSommier;
   private String realigDouane;
   private float realigTauxDouane;
   private int realigMode;
   private float realigGr;
   private String realigCouleur;
   private String realigNumParc;
   private String realigNumTrie;
   private Date realigDateTrie;
   private String realigNumConvoi;
   private ReacheminementEnteteAchats reacheminementEnteteAchats;
   private List var_listDepotItem = new ArrayList();
   private String var_depotLigne;
   private boolean nonModif;
   private String var_lib_uni_condit;
   private Unite unite = new Unite();
   private String codeFamille;
   private String format;
   private double pv_ht;

   public List getVar_listDepotItem() {
      return this.var_listDepotItem;
   }

   public void setVar_listDepotItem(List var1) {
      this.var_listDepotItem = var1;
   }

   public String getVar_lib_uni_condit() {
      if (this.realigCondition != null && !this.realigCondition.isEmpty() && this.realigCondition.contains(":")) {
         if (this.realigDescription != null && !this.realigDescription.isEmpty()) {
            this.var_lib_uni_condit = this.realigDescription;
         } else if (this.realigCondition.contains("/")) {
            String[] var1 = this.realigCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.realigCondition;
         }
      } else if (this.realigCondition != null && !this.realigCondition.isEmpty() && !this.realigCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.realigCondition));
      } else if (this.realigUnite != null && !this.realigUnite.isEmpty()) {
         this.var_lib_uni_condit = this.realigUnite;
      } else {
         this.var_lib_uni_condit = "";
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public String getCodeFamille() {
      if (this.realigFamille != null && !this.realigFamille.isEmpty() && this.realigFamille.contains(":")) {
         String[] var1 = this.realigFamille.split(":");
         this.codeFamille = var1[0];
      } else {
         this.codeFamille = this.realigFamille;
      }

      return this.codeFamille;
   }

   public String getFormat() {
      if (this.realigMode == 0) {
         this.format = this.realigHaut + "x" + this.realigLong;
      } else {
         this.format = "" + this.realigLarg;
      }

      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public void setCodeFamille(String var1) {
      this.codeFamille = var1;
   }

   public boolean isNonModif() {
      return this.nonModif;
   }

   public void setNonModif(boolean var1) {
      this.nonModif = var1;
   }

   public double getPv_ht() {
      return this.pv_ht;
   }

   public void setPv_ht(double var1) {
      this.pv_ht = var1;
   }

   public String getVar_depotLigne() {
      return this.var_depotLigne;
   }

   public void setVar_depotLigne(String var1) {
      this.var_depotLigne = var1;
   }

   public ReacheminementEnteteAchats getReacheminementEnteteAchats() {
      return this.reacheminementEnteteAchats;
   }

   public void setReacheminementEnteteAchats(ReacheminementEnteteAchats var1) {
      this.reacheminementEnteteAchats = var1;
   }

   public String getRealigCode() {
      return this.realigCode;
   }

   public void setRealigCode(String var1) {
      this.realigCode = var1;
   }

   public String getRealigCondition() {
      return this.realigCondition;
   }

   public void setRealigCondition(String var1) {
      this.realigCondition = var1;
   }

   public String getRealigCouleur() {
      return this.realigCouleur;
   }

   public void setRealigCouleur(String var1) {
      this.realigCouleur = var1;
   }

   public Date getRealigDateTrie() {
      return this.realigDateTrie;
   }

   public void setRealigDateTrie(Date var1) {
      this.realigDateTrie = var1;
   }

   public String getRealigDescription() {
      return this.realigDescription;
   }

   public void setRealigDescription(String var1) {
      this.realigDescription = var1;
   }

   public Date getRealigDestDate() {
      return this.realigDestDate;
   }

   public void setRealigDestDate(Date var1) {
      this.realigDestDate = var1;
   }

   public String getRealigDestDepot() {
      return this.realigDestDepot;
   }

   public void setRealigDestDepot(String var1) {
      this.realigDestDepot = var1;
   }

   public int getRealigDestNbSac() {
      return this.realigDestNbSac;
   }

   public void setRealigDestNbSac(int var1) {
      this.realigDestNbSac = var1;
   }

   public float getRealigDestPoidsBrut() {
      return this.realigDestPoidsBrut;
   }

   public void setRealigDestPoidsBrut(float var1) {
      this.realigDestPoidsBrut = var1;
   }

   public float getRealigDestPoidsNet() {
      return this.realigDestPoidsNet;
   }

   public void setRealigDestPoidsNet(float var1) {
      this.realigDestPoidsNet = var1;
   }

   public float getRealigDestQte() {
      return this.realigDestQte;
   }

   public void setRealigDestQte(float var1) {
      this.realigDestQte = var1;
   }

   public float getRealigDestQteUtil() {
      return this.realigDestQteUtil;
   }

   public void setRealigDestQteUtil(float var1) {
      this.realigDestQteUtil = var1;
   }

   public float getRealigDiam() {
      return this.realigDiam;
   }

   public void setRealigDiam(float var1) {
      this.realigDiam = var1;
   }

   public String getRealigDouane() {
      return this.realigDouane;
   }

   public void setRealigDouane(String var1) {
      this.realigDouane = var1;
   }

   public int getRealigEchelle() {
      return this.realigEchelle;
   }

   public void setRealigEchelle(int var1) {
      this.realigEchelle = var1;
   }

   public String getRealigFamille() {
      return this.realigFamille;
   }

   public void setRealigFamille(String var1) {
      this.realigFamille = var1;
   }

   public float getRealigGr() {
      return this.realigGr;
   }

   public void setRealigGr(float var1) {
      this.realigGr = var1;
   }

   public float getRealigHaut() {
      return this.realigHaut;
   }

   public void setRealigHaut(float var1) {
      this.realigHaut = var1;
   }

   public long getRealigId() {
      return this.realigId;
   }

   public void setRealigId(long var1) {
      this.realigId = var1;
   }

   public long getRealigIdRec() {
      return this.realigIdRec;
   }

   public void setRealigIdRec(long var1) {
      this.realigIdRec = var1;
   }

   public float getRealigLarg() {
      return this.realigLarg;
   }

   public void setRealigLarg(float var1) {
      this.realigLarg = var1;
   }

   public String getRealigLibelle() {
      return this.realigLibelle;
   }

   public void setRealigLibelle(String var1) {
      this.realigLibelle = var1;
   }

   public float getRealigLong() {
      return this.realigLong;
   }

   public void setRealigLong(float var1) {
      this.realigLong = var1;
   }

   public int getRealigMode() {
      return this.realigMode;
   }

   public void setRealigMode(int var1) {
      this.realigMode = var1;
   }

   public float getRealigNb() {
      return this.realigNb;
   }

   public void setRealigNb(float var1) {
      this.realigNb = var1;
   }

   public String getRealigNumParc() {
      return this.realigNumParc;
   }

   public void setRealigNumParc(String var1) {
      this.realigNumParc = var1;
   }

   public String getRealigNumTrie() {
      return this.realigNumTrie;
   }

   public void setRealigNumTrie(String var1) {
      this.realigNumTrie = var1;
   }

   public Date getRealigOrigDate() {
      return this.realigOrigDate;
   }

   public void setRealigOrigDate(Date var1) {
      this.realigOrigDate = var1;
   }

   public String getRealigOrigDepot() {
      return this.realigOrigDepot;
   }

   public void setRealigOrigDepot(String var1) {
      this.realigOrigDepot = var1;
   }

   public int getRealigOrigNbSac() {
      return this.realigOrigNbSac;
   }

   public void setRealigOrigNbSac(int var1) {
      this.realigOrigNbSac = var1;
   }

   public float getRealigOrigPoidsBrut() {
      return this.realigOrigPoidsBrut;
   }

   public void setRealigOrigPoidsBrut(float var1) {
      this.realigOrigPoidsBrut = var1;
   }

   public float getRealigOrigPoidsNet() {
      return this.realigOrigPoidsNet;
   }

   public void setRealigOrigPoidsNet(float var1) {
      this.realigOrigPoidsNet = var1;
   }

   public float getRealigOrigQte() {
      return this.realigOrigQte;
   }

   public void setRealigOrigQte(float var1) {
      this.realigOrigQte = var1;
   }

   public float getRealigOrigQteUtil() {
      return this.realigOrigQteUtil;
   }

   public void setRealigOrigQteUtil(float var1) {
      this.realigOrigQteUtil = var1;
   }

   public double getRealigPr() {
      return this.realigPr;
   }

   public void setRealigPr(double var1) {
      this.realigPr = var1;
   }

   public double getRealigPump() {
      return this.realigPump;
   }

   public void setRealigPump(double var1) {
      this.realigPump = var1;
   }

   public String getRealigSommier() {
      return this.realigSommier;
   }

   public void setRealigSommier(String var1) {
      this.realigSommier = var1;
   }

   public int getRealigStock() {
      return this.realigStock;
   }

   public void setRealigStock(int var1) {
      this.realigStock = var1;
   }

   public float getRealigTauxDouane() {
      return this.realigTauxDouane;
   }

   public void setRealigTauxDouane(float var1) {
      this.realigTauxDouane = var1;
   }

   public String getRealigUnite() {
      return this.realigUnite;
   }

   public void setRealigUnite(String var1) {
      this.realigUnite = var1;
   }

   public float getRealigVolume() {
      return this.realigVolume;
   }

   public void setRealigVolume(float var1) {
      this.realigVolume = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public int getRealigOrdre() {
      return this.realigOrdre;
   }

   public void setRealigOrdre(int var1) {
      this.realigOrdre = var1;
   }

   public String getRealigNumConvoi() {
      return this.realigNumConvoi;
   }

   public void setRealigNumConvoi(String var1) {
      this.realigNumConvoi = var1;
   }
}
