package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LivraisonLigneVentes implements Serializable {
   private long blvligId;
   private int blvligOrdre;
   private long blvligIdDvs;
   private long blvligIdBcm;
   private String blvligCode;
   private int blvligProcess;
   private String blvligFamille;
   private String blvligLibelle;
   private String blvligComplement;
   private int blvligGenerique;
   private String blvligReference;
   private String blvligTaxe;
   private float blvligTauxTaxe;
   private String blvligUnite;
   private String blvligCondition;
   private String blvligDescription;
   private String blvligDepot;
   private String blvligDepotCmd;
   private int blvligEchelle;
   private float blvligQte;
   private int blvligStock;
   private float blvligLong;
   private float blvligLarg;
   private float blvligHaut;
   private float blvligDiam;
   private float blvligNb;
   private float blvligPoidsNet;
   private float blvligPoidsBrut;
   private float blvligVolume;
   private float blvligQteUtil;
   private float blvligQteStock;
   private float blvligQteUtilStock;
   private String blvligLot;
   private String blvligNumSerie;
   private String blvligDevise;
   private double blvligPu;
   private double blvligPuTtc;
   private float blvligTauxRemise;
   private double blvligRabais;
   private double blvligPuRem;
   private double blvligPuRemTtc;
   private double blvligPt;
   private double blvligTva;
   private double blvligTc;
   private double blvligTtc;
   private double blvligPump;
   private String blvligGroupe;
   private int blvligModeGroupe;
   private int blvligEntStock;
   private LivraisonEnteteVentes livraisonEnteteVentes;
   private List var_listDepotItem = new ArrayList();
   private String var_depotLigne;
   private float var_qteDejaTrf;
   private float var_qteDejaLiv;
   private float var_qteReliquat;
   private String var_lib_uni_condit;
   private String var_lib_des_condit;
   private boolean var_choix_qte;
   private Unite unite = new Unite();
   private String numSerie;
   private String var_desciptif;
   private String var_photo;
   private int var_photo_taille;
   private String styleLigne;

   public String getVar_lib_des_condit() {
      return this.var_lib_des_condit;
   }

   public void setVar_lib_des_condit(String var1) {
      this.var_lib_des_condit = var1;
   }

   public String getVar_desciptif() {
      return this.var_desciptif;
   }

   public void setVar_desciptif(String var1) {
      this.var_desciptif = var1;
   }

   public String getVar_photo() {
      return this.var_photo;
   }

   public void setVar_photo(String var1) {
      this.var_photo = var1;
   }

   public int getVar_photo_taille() {
      return this.var_photo_taille;
   }

   public void setVar_photo_taille(int var1) {
      this.var_photo_taille = var1;
   }

   public String getStyleLigne() {
      if (this.blvligGroupe != null && !this.blvligGroupe.isEmpty()) {
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
      if (this.blvligCondition != null && !this.blvligCondition.isEmpty() && this.blvligCondition.contains(":")) {
         if (this.blvligDescription != null && !this.blvligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.blvligDescription;
         } else if (this.blvligCondition.contains("/")) {
            String[] var1 = this.blvligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.blvligCondition;
         }
      } else if (this.blvligCondition != null && !this.blvligCondition.isEmpty() && !this.blvligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.blvligCondition));
      } else if (this.blvligUnite != null && !this.blvligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.blvligUnite;
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
      if (this.blvligCondition != null && !this.blvligCondition.isEmpty() && !this.blvligCondition.contains(":")) {
         this.var_choix_qte = true;
      } else {
         this.var_choix_qte = false;
      }

      return this.var_choix_qte;
   }

   public void setVar_choix_qte(boolean var1) {
      this.var_choix_qte = var1;
   }

   public LivraisonEnteteVentes getLivraisonEnteteVentes() {
      return this.livraisonEnteteVentes;
   }

   public void setLivraisonEnteteVentes(LivraisonEnteteVentes var1) {
      this.livraisonEnteteVentes = var1;
   }

   public String getBlvligCode() {
      return this.blvligCode;
   }

   public void setBlvligCode(String var1) {
      this.blvligCode = var1;
   }

   public String getBlvligDepot() {
      return this.blvligDepot;
   }

   public void setBlvligDepot(String var1) {
      this.blvligDepot = var1;
   }

   public String getBlvligDevise() {
      return this.blvligDevise;
   }

   public void setBlvligDevise(String var1) {
      this.blvligDevise = var1;
   }

   public String getBlvligFamille() {
      return this.blvligFamille;
   }

   public void setBlvligFamille(String var1) {
      this.blvligFamille = var1;
   }

   public long getBlvligId() {
      return this.blvligId;
   }

   public void setBlvligId(long var1) {
      this.blvligId = var1;
   }

   public String getBlvligLibelle() {
      return this.blvligLibelle;
   }

   public void setBlvligLibelle(String var1) {
      this.blvligLibelle = var1;
   }

   public String getBlvligLot() {
      return this.blvligLot;
   }

   public void setBlvligLot(String var1) {
      this.blvligLot = var1;
   }

   public String getBlvligNumSerie() {
      return this.blvligNumSerie;
   }

   public void setBlvligNumSerie(String var1) {
      this.blvligNumSerie = var1;
   }

   public double getBlvligPt() {
      return this.blvligPt;
   }

   public void setBlvligPt(double var1) {
      this.blvligPt = var1;
   }

   public double getBlvligPu() {
      return this.blvligPu;
   }

   public void setBlvligPu(double var1) {
      this.blvligPu = var1;
   }

   public double getBlvligPuRem() {
      return this.blvligPuRem;
   }

   public void setBlvligPuRem(double var1) {
      this.blvligPuRem = var1;
   }

   public float getBlvligQte() {
      return this.blvligQte;
   }

   public void setBlvligQte(float var1) {
      this.blvligQte = var1;
   }

   public float getBlvligQteStock() {
      return this.blvligQteStock;
   }

   public void setBlvligQteStock(float var1) {
      this.blvligQteStock = var1;
   }

   public double getBlvligRabais() {
      return this.blvligRabais;
   }

   public void setBlvligRabais(double var1) {
      this.blvligRabais = var1;
   }

   public String getBlvligReference() {
      return this.blvligReference;
   }

   public void setBlvligReference(String var1) {
      this.blvligReference = var1;
   }

   public float getBlvligTauxRemise() {
      return this.blvligTauxRemise;
   }

   public void setBlvligTauxRemise(float var1) {
      this.blvligTauxRemise = var1;
   }

   public float getBlvligTauxTaxe() {
      return this.blvligTauxTaxe;
   }

   public void setBlvligTauxTaxe(float var1) {
      this.blvligTauxTaxe = var1;
   }

   public String getBlvligTaxe() {
      return this.blvligTaxe;
   }

   public void setBlvligTaxe(String var1) {
      this.blvligTaxe = var1;
   }

   public double getBlvligTc() {
      return this.blvligTc;
   }

   public void setBlvligTc(double var1) {
      this.blvligTc = var1;
   }

   public double getBlvligTtc() {
      return this.blvligTtc;
   }

   public void setBlvligTtc(double var1) {
      this.blvligTtc = var1;
   }

   public double getBlvligTva() {
      return this.blvligTva;
   }

   public void setBlvligTva(double var1) {
      this.blvligTva = var1;
   }

   public String getBlvligUnite() {
      return this.blvligUnite;
   }

   public void setBlvligUnite(String var1) {
      this.blvligUnite = var1;
   }

   public long getBlvligIdBcm() {
      return this.blvligIdBcm;
   }

   public void setBlvligIdBcm(long var1) {
      this.blvligIdBcm = var1;
   }

   public long getBlvligIdDvs() {
      return this.blvligIdDvs;
   }

   public void setBlvligIdDvs(long var1) {
      this.blvligIdDvs = var1;
   }

   public double getBlvligPump() {
      return this.blvligPump;
   }

   public void setBlvligPump(double var1) {
      this.blvligPump = var1;
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

   public double getBlvligPuRemTtc() {
      return this.blvligPuRemTtc;
   }

   public void setBlvligPuRemTtc(double var1) {
      this.blvligPuRemTtc = var1;
   }

   public double getBlvligPuTtc() {
      return this.blvligPuTtc;
   }

   public void setBlvligPuTtc(double var1) {
      this.blvligPuTtc = var1;
   }

   public String getBlvligCondition() {
      return this.blvligCondition;
   }

   public void setBlvligCondition(String var1) {
      this.blvligCondition = var1;
   }

   public float getBlvligDiam() {
      return this.blvligDiam;
   }

   public void setBlvligDiam(float var1) {
      this.blvligDiam = var1;
   }

   public float getBlvligHaut() {
      return this.blvligHaut;
   }

   public void setBlvligHaut(float var1) {
      this.blvligHaut = var1;
   }

   public float getBlvligLarg() {
      return this.blvligLarg;
   }

   public void setBlvligLarg(float var1) {
      this.blvligLarg = var1;
   }

   public float getBlvligLong() {
      return this.blvligLong;
   }

   public void setBlvligLong(float var1) {
      this.blvligLong = var1;
   }

   public float getBlvligNb() {
      return this.blvligNb;
   }

   public void setBlvligNb(float var1) {
      this.blvligNb = var1;
   }

   public float getBlvligQteUtil() {
      return this.blvligQteUtil;
   }

   public void setBlvligQteUtil(float var1) {
      this.blvligQteUtil = var1;
   }

   public float getBlvligPoidsBrut() {
      return this.blvligPoidsBrut;
   }

   public void setBlvligPoidsBrut(float var1) {
      this.blvligPoidsBrut = var1;
   }

   public float getBlvligPoidsNet() {
      return this.blvligPoidsNet;
   }

   public void setBlvligPoidsNet(float var1) {
      this.blvligPoidsNet = var1;
   }

   public float getBlvligVolume() {
      return this.blvligVolume;
   }

   public void setBlvligVolume(float var1) {
      this.blvligVolume = var1;
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

   public String getBlvligDepotCmd() {
      return this.blvligDepotCmd;
   }

   public void setBlvligDepotCmd(String var1) {
      this.blvligDepotCmd = var1;
   }

   public float getBlvligQteUtilStock() {
      return this.blvligQteUtilStock;
   }

   public void setBlvligQteUtilStock(float var1) {
      this.blvligQteUtilStock = var1;
   }

   public float getVar_qteDejaLiv() {
      return this.var_qteDejaLiv;
   }

   public void setVar_qteDejaLiv(float var1) {
      this.var_qteDejaLiv = var1;
   }

   public int getBlvligStock() {
      return this.blvligStock;
   }

   public void setBlvligStock(int var1) {
      this.blvligStock = var1;
   }

   public int getBlvligEchelle() {
      return this.blvligEchelle;
   }

   public void setBlvligEchelle(int var1) {
      this.blvligEchelle = var1;
   }

   public String getBlvligDescription() {
      return this.blvligDescription;
   }

   public void setBlvligDescription(String var1) {
      this.blvligDescription = var1;
   }

   public String getNumSerie() {
      return this.numSerie;
   }

   public void setNumSerie(String var1) {
      this.numSerie = var1;
   }

   public int getBlvligGenerique() {
      return this.blvligGenerique;
   }

   public void setBlvligGenerique(int var1) {
      this.blvligGenerique = var1;
   }

   public int getBlvligOrdre() {
      return this.blvligOrdre;
   }

   public void setBlvligOrdre(int var1) {
      this.blvligOrdre = var1;
   }

   public String getBlvligComplement() {
      return this.blvligComplement;
   }

   public void setBlvligComplement(String var1) {
      this.blvligComplement = var1;
   }

   public String getBlvligGroupe() {
      return this.blvligGroupe;
   }

   public void setBlvligGroupe(String var1) {
      this.blvligGroupe = var1;
   }

   public int getBlvligModeGroupe() {
      return this.blvligModeGroupe;
   }

   public void setBlvligModeGroupe(int var1) {
      this.blvligModeGroupe = var1;
   }

   public int getBlvligProcess() {
      return this.blvligProcess;
   }

   public void setBlvligProcess(int var1) {
      this.blvligProcess = var1;
   }

   public int getBlvligEntStock() {
      return this.blvligEntStock;
   }

   public void setBlvligEntStock(int var1) {
      this.blvligEntStock = var1;
   }
}
