package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DemandeLigneAchats implements Serializable {
   private long demligId;
   private int demligOrdre;
   private String demligCode;
   private String demligFamille;
   private String demligLibelle;
   private String demligComplement;
   private String demligReference;
   private String demligTaxe;
   private float demligTauxTaxe;
   private String demligUnite;
   private String demligCondition;
   private String demligDescription;
   private float demligQte;
   private float demligLong;
   private float demligLarg;
   private float demligHaut;
   private float demligDiam;
   private float demligNb;
   private float demligPoidsNet;
   private float demligPoidsBrut;
   private float demligVolume;
   private float demligQteUtil;
   private float demligQteStock;
   private String demligDevise;
   private double demligPu;
   private double demligPt;
   private double demligTva;
   private double demligTtc;
   private double demligPr;
   private double demligPump;
   private String demligNomTiers;
   private String demligCivilTiers;
   private long demligIdTiers;
   private DemandeEnteteAchats demandeEnteteAchats;
   private List lesTiers = new ArrayList();
   private String listFournisseur;
   private String listeIdFournisseur;
   private boolean verouCod;
   private float var_qteDejaTrf;
   private float var_qteReliquat;
   private String var_lib_uni_condit;
   private boolean selectionLigne;

   public boolean isSelectionLigne() {
      return this.selectionLigne;
   }

   public void setSelectionLigne(boolean var1) {
      this.selectionLigne = var1;
   }

   public boolean isVerouCod() {
      if (this.demligId != 0L) {
         this.verouCod = true;
      } else {
         this.verouCod = false;
      }

      return this.verouCod;
   }

   public void setVerouCod(boolean var1) {
      this.verouCod = var1;
   }

   public String getVar_lib_uni_condit() {
      if (this.demligCondition != null && !this.demligCondition.isEmpty() && this.demligCondition.contains(":")) {
         if (this.demligDescription != null && !this.demligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.demligDescription;
         } else if (this.demligCondition.contains("/")) {
            String[] var1 = this.demligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.demligCondition;
         }
      } else if (this.demligCondition == null || this.demligCondition.isEmpty() || this.demligCondition.contains(":")) {
         if (this.demligUnite != null && !this.demligUnite.isEmpty()) {
            this.var_lib_uni_condit = this.demligUnite;
         } else {
            this.var_lib_uni_condit = "";
         }
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public DemandeEnteteAchats getDemandeEnteteAchats() {
      return this.demandeEnteteAchats;
   }

   public void setDemandeEnteteAchats(DemandeEnteteAchats var1) {
      this.demandeEnteteAchats = var1;
   }

   public String getDemligCivilTiers() {
      return this.demligCivilTiers;
   }

   public void setDemligCivilTiers(String var1) {
      this.demligCivilTiers = var1;
   }

   public String getDemligCode() {
      return this.demligCode;
   }

   public void setDemligCode(String var1) {
      this.demligCode = var1;
   }

   public String getDemligCondition() {
      return this.demligCondition;
   }

   public void setDemligCondition(String var1) {
      this.demligCondition = var1;
   }

   public String getDemligDevise() {
      return this.demligDevise;
   }

   public void setDemligDevise(String var1) {
      this.demligDevise = var1;
   }

   public float getDemligDiam() {
      return this.demligDiam;
   }

   public void setDemligDiam(float var1) {
      this.demligDiam = var1;
   }

   public String getDemligFamille() {
      return this.demligFamille;
   }

   public void setDemligFamille(String var1) {
      this.demligFamille = var1;
   }

   public float getDemligHaut() {
      return this.demligHaut;
   }

   public void setDemligHaut(float var1) {
      this.demligHaut = var1;
   }

   public long getDemligId() {
      return this.demligId;
   }

   public void setDemligId(long var1) {
      this.demligId = var1;
   }

   public long getDemligIdTiers() {
      return this.demligIdTiers;
   }

   public void setDemligIdTiers(long var1) {
      this.demligIdTiers = var1;
   }

   public float getDemligLarg() {
      return this.demligLarg;
   }

   public void setDemligLarg(float var1) {
      this.demligLarg = var1;
   }

   public String getDemligLibelle() {
      return this.demligLibelle;
   }

   public void setDemligLibelle(String var1) {
      this.demligLibelle = var1;
   }

   public float getDemligLong() {
      return this.demligLong;
   }

   public void setDemligLong(float var1) {
      this.demligLong = var1;
   }

   public float getDemligNb() {
      return this.demligNb;
   }

   public void setDemligNb(float var1) {
      this.demligNb = var1;
   }

   public String getDemligNomTiers() {
      return this.demligNomTiers;
   }

   public void setDemligNomTiers(String var1) {
      this.demligNomTiers = var1;
   }

   public float getDemligPoidsBrut() {
      return this.demligPoidsBrut;
   }

   public void setDemligPoidsBrut(float var1) {
      this.demligPoidsBrut = var1;
   }

   public float getDemligPoidsNet() {
      return this.demligPoidsNet;
   }

   public void setDemligPoidsNet(float var1) {
      this.demligPoidsNet = var1;
   }

   public double getDemligPr() {
      return this.demligPr;
   }

   public void setDemligPr(double var1) {
      this.demligPr = var1;
   }

   public double getDemligPt() {
      return this.demligPt;
   }

   public void setDemligPt(double var1) {
      this.demligPt = var1;
   }

   public double getDemligPu() {
      return this.demligPu;
   }

   public void setDemligPu(double var1) {
      this.demligPu = var1;
   }

   public double getDemligPump() {
      return this.demligPump;
   }

   public void setDemligPump(double var1) {
      this.demligPump = var1;
   }

   public float getDemligQte() {
      return this.demligQte;
   }

   public void setDemligQte(float var1) {
      this.demligQte = var1;
   }

   public float getDemligQteStock() {
      return this.demligQteStock;
   }

   public void setDemligQteStock(float var1) {
      this.demligQteStock = var1;
   }

   public float getDemligQteUtil() {
      return this.demligQteUtil;
   }

   public void setDemligQteUtil(float var1) {
      this.demligQteUtil = var1;
   }

   public String getDemligReference() {
      return this.demligReference;
   }

   public void setDemligReference(String var1) {
      this.demligReference = var1;
   }

   public float getDemligTauxTaxe() {
      return this.demligTauxTaxe;
   }

   public void setDemligTauxTaxe(float var1) {
      this.demligTauxTaxe = var1;
   }

   public String getDemligTaxe() {
      return this.demligTaxe;
   }

   public void setDemligTaxe(String var1) {
      this.demligTaxe = var1;
   }

   public double getDemligTtc() {
      return this.demligTtc;
   }

   public void setDemligTtc(double var1) {
      this.demligTtc = var1;
   }

   public double getDemligTva() {
      return this.demligTva;
   }

   public void setDemligTva(double var1) {
      this.demligTva = var1;
   }

   public String getDemligUnite() {
      return this.demligUnite;
   }

   public void setDemligUnite(String var1) {
      this.demligUnite = var1;
   }

   public float getDemligVolume() {
      return this.demligVolume;
   }

   public void setDemligVolume(float var1) {
      this.demligVolume = var1;
   }

   public float getVar_qteDejaTrf() {
      return this.var_qteDejaTrf;
   }

   public void setVar_qteDejaTrf(float var1) {
      this.var_qteDejaTrf = var1;
   }

   public float getVar_qteReliquat() {
      return this.var_qteReliquat;
   }

   public void setVar_qteReliquat(float var1) {
      this.var_qteReliquat = var1;
   }

   public String getDemligDescription() {
      return this.demligDescription;
   }

   public void setDemligDescription(String var1) {
      this.demligDescription = var1;
   }

   public List getLesTiers() {
      return this.lesTiers;
   }

   public void setLesTiers(List var1) {
      this.lesTiers = var1;
   }

   public String getListFournisseur() {
      return this.listFournisseur;
   }

   public void setListFournisseur(String var1) {
      this.listFournisseur = var1;
   }

   public String getListeIdFournisseur() {
      return this.listeIdFournisseur;
   }

   public void setListeIdFournisseur(String var1) {
      this.listeIdFournisseur = var1;
   }

   public String getDemligComplement() {
      return this.demligComplement;
   }

   public void setDemligComplement(String var1) {
      this.demligComplement = var1;
   }

   public int getDemligOrdre() {
      return this.demligOrdre;
   }

   public void setDemligOrdre(int var1) {
      this.demligOrdre = var1;
   }
}
