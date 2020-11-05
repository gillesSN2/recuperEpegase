package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContratLigneVentes implements Serializable {
   private long crtligId;
   private int crtligOrdre;
   private String crtligCode;
   private String crtligFamille;
   private String crtligLibelle;
   private String crtligComplement;
   private String crtligReference;
   private String crtligTaxe;
   private float crtligTauxTaxe;
   private String crtligUnite;
   private String crtligCondition;
   private String crtligDescription;
   private String crtligDepot;
   private int crtligEchelle;
   private float crtligQte;
   private float crtligLong;
   private float crtligLarg;
   private float crtligHaut;
   private float crtligDiam;
   private float crtligNb;
   private float crtligPoidsNet;
   private float crtligPoidsBrut;
   private float crtligVolume;
   private float crtligQteUtil;
   private float crtligQteStock;
   private int crtligStock;
   private String crtligLot;
   private String crtligNumSerie;
   private String crtligDevise;
   private double crtligPu;
   private double crtligPuTtc;
   private float crtligTauxRemise;
   private double crtligRabais;
   private double crtligPuRem;
   private double crtligPuRemTtc;
   private double crtligPt;
   private double crtligTva;
   private double crtligTc;
   private double crtligTtc;
   private double crtligPump;
   private int crtligEntStock;
   private double crtligCommission;
   private String crtligGroupe;
   private int crtligModeGroupe;
   private ContratEnteteVentes contratEnteteVentes;
   private List var_listDepotItem = new ArrayList();
   private String var_depotLigne;
   private float var_qteDejaTrf;
   private float var_qteReliquat;
   private String var_lib_uni_condit;
   private boolean var_choix_qte;
   private Unite unite = new Unite();
   private String styleLigne;

   public String getStyleLigne() {
      if (this.crtligGroupe != null && !this.crtligGroupe.isEmpty()) {
         this.styleLigne = "font-style:italic;font-size:7px;";
      } else {
         this.styleLigne = "font-style:normal;";
      }

      return this.styleLigne;
   }

   public void setStyleLigne(String var1) {
      this.styleLigne = var1;
   }

   public String getVar_lib_uni_condit() {
      if (this.crtligCondition != null && !this.crtligCondition.isEmpty() && this.crtligCondition.contains(":")) {
         if (this.crtligDescription != null && !this.crtligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.crtligDescription;
         } else if (this.crtligCondition.contains("/")) {
            String[] var1 = this.crtligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.crtligCondition;
         }
      } else if (this.crtligCondition != null && !this.crtligCondition.isEmpty() && !this.crtligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.crtligCondition));
      } else if (this.crtligUnite != null && !this.crtligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.crtligUnite;
      } else {
         this.var_lib_uni_condit = "";
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public boolean isVar_choix_qte() {
      if (this.crtligCondition != null && !this.crtligCondition.isEmpty() && !this.crtligCondition.contains(":")) {
         this.var_choix_qte = true;
      } else {
         this.var_choix_qte = false;
      }

      return this.var_choix_qte;
   }

   public void setVar_choix_qte(boolean var1) {
      this.var_choix_qte = var1;
   }

   public String getCrtligCode() {
      return this.crtligCode;
   }

   public void setCrtligCode(String var1) {
      this.crtligCode = var1;
   }

   public double getCrtligCommission() {
      return this.crtligCommission;
   }

   public void setCrtligCommission(double var1) {
      this.crtligCommission = var1;
   }

   public String getCrtligComplement() {
      return this.crtligComplement;
   }

   public void setCrtligComplement(String var1) {
      this.crtligComplement = var1;
   }

   public String getCrtligCondition() {
      return this.crtligCondition;
   }

   public void setCrtligCondition(String var1) {
      this.crtligCondition = var1;
   }

   public String getCrtligDepot() {
      return this.crtligDepot;
   }

   public void setCrtligDepot(String var1) {
      this.crtligDepot = var1;
   }

   public String getCrtligDescription() {
      return this.crtligDescription;
   }

   public void setCrtligDescription(String var1) {
      this.crtligDescription = var1;
   }

   public String getCrtligDevise() {
      return this.crtligDevise;
   }

   public void setCrtligDevise(String var1) {
      this.crtligDevise = var1;
   }

   public float getCrtligDiam() {
      return this.crtligDiam;
   }

   public void setCrtligDiam(float var1) {
      this.crtligDiam = var1;
   }

   public int getCrtligEchelle() {
      return this.crtligEchelle;
   }

   public void setCrtligEchelle(int var1) {
      this.crtligEchelle = var1;
   }

   public int getCrtligEntStock() {
      return this.crtligEntStock;
   }

   public void setCrtligEntStock(int var1) {
      this.crtligEntStock = var1;
   }

   public String getCrtligFamille() {
      return this.crtligFamille;
   }

   public void setCrtligFamille(String var1) {
      this.crtligFamille = var1;
   }

   public float getCrtligHaut() {
      return this.crtligHaut;
   }

   public void setCrtligHaut(float var1) {
      this.crtligHaut = var1;
   }

   public long getCrtligId() {
      return this.crtligId;
   }

   public void setCrtligId(long var1) {
      this.crtligId = var1;
   }

   public float getCrtligLarg() {
      return this.crtligLarg;
   }

   public void setCrtligLarg(float var1) {
      this.crtligLarg = var1;
   }

   public String getCrtligLibelle() {
      return this.crtligLibelle;
   }

   public void setCrtligLibelle(String var1) {
      this.crtligLibelle = var1;
   }

   public float getCrtligLong() {
      return this.crtligLong;
   }

   public void setCrtligLong(float var1) {
      this.crtligLong = var1;
   }

   public String getCrtligLot() {
      return this.crtligLot;
   }

   public void setCrtligLot(String var1) {
      this.crtligLot = var1;
   }

   public float getCrtligNb() {
      return this.crtligNb;
   }

   public void setCrtligNb(float var1) {
      this.crtligNb = var1;
   }

   public String getCrtligNumSerie() {
      return this.crtligNumSerie;
   }

   public void setCrtligNumSerie(String var1) {
      this.crtligNumSerie = var1;
   }

   public int getCrtligOrdre() {
      return this.crtligOrdre;
   }

   public void setCrtligOrdre(int var1) {
      this.crtligOrdre = var1;
   }

   public float getCrtligPoidsBrut() {
      return this.crtligPoidsBrut;
   }

   public void setCrtligPoidsBrut(float var1) {
      this.crtligPoidsBrut = var1;
   }

   public float getCrtligPoidsNet() {
      return this.crtligPoidsNet;
   }

   public void setCrtligPoidsNet(float var1) {
      this.crtligPoidsNet = var1;
   }

   public double getCrtligPt() {
      return this.crtligPt;
   }

   public void setCrtligPt(double var1) {
      this.crtligPt = var1;
   }

   public double getCrtligPu() {
      return this.crtligPu;
   }

   public void setCrtligPu(double var1) {
      this.crtligPu = var1;
   }

   public double getCrtligPuRem() {
      return this.crtligPuRem;
   }

   public void setCrtligPuRem(double var1) {
      this.crtligPuRem = var1;
   }

   public double getCrtligPuRemTtc() {
      return this.crtligPuRemTtc;
   }

   public void setCrtligPuRemTtc(double var1) {
      this.crtligPuRemTtc = var1;
   }

   public double getCrtligPuTtc() {
      return this.crtligPuTtc;
   }

   public void setCrtligPuTtc(double var1) {
      this.crtligPuTtc = var1;
   }

   public double getCrtligPump() {
      return this.crtligPump;
   }

   public void setCrtligPump(double var1) {
      this.crtligPump = var1;
   }

   public float getCrtligQte() {
      return this.crtligQte;
   }

   public void setCrtligQte(float var1) {
      this.crtligQte = var1;
   }

   public float getCrtligQteStock() {
      return this.crtligQteStock;
   }

   public void setCrtligQteStock(float var1) {
      this.crtligQteStock = var1;
   }

   public float getCrtligQteUtil() {
      return this.crtligQteUtil;
   }

   public void setCrtligQteUtil(float var1) {
      this.crtligQteUtil = var1;
   }

   public double getCrtligRabais() {
      return this.crtligRabais;
   }

   public void setCrtligRabais(double var1) {
      this.crtligRabais = var1;
   }

   public String getCrtligReference() {
      return this.crtligReference;
   }

   public void setCrtligReference(String var1) {
      this.crtligReference = var1;
   }

   public int getCrtligStock() {
      return this.crtligStock;
   }

   public void setCrtligStock(int var1) {
      this.crtligStock = var1;
   }

   public float getCrtligTauxRemise() {
      return this.crtligTauxRemise;
   }

   public void setCrtligTauxRemise(float var1) {
      this.crtligTauxRemise = var1;
   }

   public float getCrtligTauxTaxe() {
      return this.crtligTauxTaxe;
   }

   public void setCrtligTauxTaxe(float var1) {
      this.crtligTauxTaxe = var1;
   }

   public String getCrtligTaxe() {
      return this.crtligTaxe;
   }

   public void setCrtligTaxe(String var1) {
      this.crtligTaxe = var1;
   }

   public double getCrtligTc() {
      return this.crtligTc;
   }

   public void setCrtligTc(double var1) {
      this.crtligTc = var1;
   }

   public double getCrtligTtc() {
      return this.crtligTtc;
   }

   public void setCrtligTtc(double var1) {
      this.crtligTtc = var1;
   }

   public double getCrtligTva() {
      return this.crtligTva;
   }

   public void setCrtligTva(double var1) {
      this.crtligTva = var1;
   }

   public String getCrtligUnite() {
      return this.crtligUnite;
   }

   public void setCrtligUnite(String var1) {
      this.crtligUnite = var1;
   }

   public float getCrtligVolume() {
      return this.crtligVolume;
   }

   public void setCrtligVolume(float var1) {
      this.crtligVolume = var1;
   }

   public ContratEnteteVentes getContratEnteteVentes() {
      return this.contratEnteteVentes;
   }

   public void setContratEnteteVentes(ContratEnteteVentes var1) {
      this.contratEnteteVentes = var1;
   }

   public String getVar_depotLigne() {
      return this.var_depotLigne;
   }

   public void setVar_depotLigne(String var1) {
      this.var_depotLigne = var1;
   }

   public List getVar_listDepotItem() {
      return this.var_listDepotItem;
   }

   public void setVar_listDepotItem(List var1) {
      this.var_listDepotItem = var1;
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

   public String getCrtligGroupe() {
      return this.crtligGroupe;
   }

   public void setCrtligGroupe(String var1) {
      this.crtligGroupe = var1;
   }

   public int getCrtligModeGroupe() {
      return this.crtligModeGroupe;
   }

   public void setCrtligModeGroupe(int var1) {
      this.crtligModeGroupe = var1;
   }
}
