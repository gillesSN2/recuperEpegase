package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BesoinLigneVentes implements Serializable {
   private long besligId;
   private String besligCode;
   private String besligFamille;
   private String besligLibelle;
   private String besligReference;
   private String besligTaxe;
   private float besligTauxTaxe;
   private String besligUnite;
   private String besligCondition;
   private String besligDescription;
   private int besligEchelle;
   private float besligQte;
   private float besligLong;
   private float besligLarg;
   private float besligHaut;
   private float besligDiam;
   private float besligNb;
   private float besligPoidsNet;
   private float besligPoidsBrut;
   private float besligVolume;
   private float besligQteUtil;
   private int besligStock;
   private String besligDepot;
   private String besligDevise;
   private double besligPu;
   private float besligTauxRemise;
   private double besligRabais;
   private double besligPuRem;
   private double besligPuTtc;
   private double besligPuRemTtc;
   private double besligPt;
   private double besligTva;
   private double besligTc;
   private double besligTtc;
   private double besligPump;
   private String besligGroupe;
   private int besligModeGroupe;
   private BesoinEnteteVentes besoinEnteteVentes;
   private List var_listDepotItem = new ArrayList();
   private String var_depotLigne;
   private float var_qteDejaTrf;
   private float var_qteReliquat;
   private String var_lib_uni_condit;
   private boolean var_choix_qte;
   private Unite unite = new Unite();
   private String styleLigne;

   public String getStyleLigne() {
      if (this.besligGroupe != null && !this.besligGroupe.isEmpty()) {
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
      if (this.besligCondition != null && !this.besligCondition.isEmpty() && this.besligCondition.contains(":")) {
         if (this.besligDescription != null && !this.besligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.besligDescription;
         } else if (this.besligCondition.contains("/")) {
            String[] var1 = this.besligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.besligCondition;
         }
      } else if (this.besligCondition != null && !this.besligCondition.isEmpty() && !this.besligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.besligCondition));
      } else if (this.besligUnite != null && !this.besligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.besligUnite;
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
      if (this.besligCondition != null && !this.besligCondition.isEmpty() && !this.besligCondition.contains(":")) {
         this.var_choix_qte = true;
      } else {
         this.var_choix_qte = false;
      }

      return this.var_choix_qte;
   }

   public void setVar_choix_qte(boolean var1) {
      this.var_choix_qte = var1;
   }

   public BesoinEnteteVentes getBesoinEnteteVentes() {
      return this.besoinEnteteVentes;
   }

   public void setBesoinEnteteVentes(BesoinEnteteVentes var1) {
      this.besoinEnteteVentes = var1;
   }

   public String getBesligCode() {
      return this.besligCode;
   }

   public void setBesligCode(String var1) {
      this.besligCode = var1;
   }

   public String getBesligCondition() {
      return this.besligCondition;
   }

   public void setBesligCondition(String var1) {
      this.besligCondition = var1;
   }

   public String getBesligDepot() {
      return this.besligDepot;
   }

   public void setBesligDepot(String var1) {
      this.besligDepot = var1;
   }

   public String getBesligDescription() {
      return this.besligDescription;
   }

   public void setBesligDescription(String var1) {
      this.besligDescription = var1;
   }

   public String getBesligDevise() {
      return this.besligDevise;
   }

   public void setBesligDevise(String var1) {
      this.besligDevise = var1;
   }

   public float getBesligDiam() {
      return this.besligDiam;
   }

   public void setBesligDiam(float var1) {
      this.besligDiam = var1;
   }

   public int getBesligEchelle() {
      return this.besligEchelle;
   }

   public void setBesligEchelle(int var1) {
      this.besligEchelle = var1;
   }

   public String getBesligFamille() {
      return this.besligFamille;
   }

   public void setBesligFamille(String var1) {
      this.besligFamille = var1;
   }

   public float getBesligHaut() {
      return this.besligHaut;
   }

   public void setBesligHaut(float var1) {
      this.besligHaut = var1;
   }

   public long getBesligId() {
      return this.besligId;
   }

   public void setBesligId(long var1) {
      this.besligId = var1;
   }

   public float getBesligLarg() {
      return this.besligLarg;
   }

   public void setBesligLarg(float var1) {
      this.besligLarg = var1;
   }

   public String getBesligLibelle() {
      return this.besligLibelle;
   }

   public void setBesligLibelle(String var1) {
      this.besligLibelle = var1;
   }

   public float getBesligLong() {
      return this.besligLong;
   }

   public void setBesligLong(float var1) {
      this.besligLong = var1;
   }

   public float getBesligNb() {
      return this.besligNb;
   }

   public void setBesligNb(float var1) {
      this.besligNb = var1;
   }

   public float getBesligPoidsBrut() {
      return this.besligPoidsBrut;
   }

   public void setBesligPoidsBrut(float var1) {
      this.besligPoidsBrut = var1;
   }

   public float getBesligPoidsNet() {
      return this.besligPoidsNet;
   }

   public void setBesligPoidsNet(float var1) {
      this.besligPoidsNet = var1;
   }

   public double getBesligPt() {
      return this.besligPt;
   }

   public void setBesligPt(double var1) {
      this.besligPt = var1;
   }

   public double getBesligPu() {
      return this.besligPu;
   }

   public void setBesligPu(double var1) {
      this.besligPu = var1;
   }

   public double getBesligPuRem() {
      return this.besligPuRem;
   }

   public void setBesligPuRem(double var1) {
      this.besligPuRem = var1;
   }

   public double getBesligPuRemTtc() {
      return this.besligPuRemTtc;
   }

   public void setBesligPuRemTtc(double var1) {
      this.besligPuRemTtc = var1;
   }

   public double getBesligPuTtc() {
      return this.besligPuTtc;
   }

   public void setBesligPuTtc(double var1) {
      this.besligPuTtc = var1;
   }

   public double getBesligPump() {
      return this.besligPump;
   }

   public void setBesligPump(double var1) {
      this.besligPump = var1;
   }

   public float getBesligQte() {
      return this.besligQte;
   }

   public void setBesligQte(float var1) {
      this.besligQte = var1;
   }

   public float getBesligQteUtil() {
      return this.besligQteUtil;
   }

   public void setBesligQteUtil(float var1) {
      this.besligQteUtil = var1;
   }

   public double getBesligRabais() {
      return this.besligRabais;
   }

   public void setBesligRabais(double var1) {
      this.besligRabais = var1;
   }

   public String getBesligReference() {
      return this.besligReference;
   }

   public void setBesligReference(String var1) {
      this.besligReference = var1;
   }

   public int getBesligStock() {
      return this.besligStock;
   }

   public void setBesligStock(int var1) {
      this.besligStock = var1;
   }

   public float getBesligTauxRemise() {
      return this.besligTauxRemise;
   }

   public void setBesligTauxRemise(float var1) {
      this.besligTauxRemise = var1;
   }

   public float getBesligTauxTaxe() {
      return this.besligTauxTaxe;
   }

   public void setBesligTauxTaxe(float var1) {
      this.besligTauxTaxe = var1;
   }

   public String getBesligTaxe() {
      return this.besligTaxe;
   }

   public void setBesligTaxe(String var1) {
      this.besligTaxe = var1;
   }

   public double getBesligTc() {
      return this.besligTc;
   }

   public void setBesligTc(double var1) {
      this.besligTc = var1;
   }

   public double getBesligTtc() {
      return this.besligTtc;
   }

   public void setBesligTtc(double var1) {
      this.besligTtc = var1;
   }

   public double getBesligTva() {
      return this.besligTva;
   }

   public void setBesligTva(double var1) {
      this.besligTva = var1;
   }

   public String getBesligUnite() {
      return this.besligUnite;
   }

   public void setBesligUnite(String var1) {
      this.besligUnite = var1;
   }

   public float getBesligVolume() {
      return this.besligVolume;
   }

   public void setBesligVolume(float var1) {
      this.besligVolume = var1;
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

   public String getBesligGroupe() {
      return this.besligGroupe;
   }

   public void setBesligGroupe(String var1) {
      this.besligGroupe = var1;
   }

   public int getBesligModeGroupe() {
      return this.besligModeGroupe;
   }

   public void setBesligModeGroupe(int var1) {
      this.besligModeGroupe = var1;
   }
}
