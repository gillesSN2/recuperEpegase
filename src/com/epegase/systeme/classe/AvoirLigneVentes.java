package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AvoirLigneVentes implements Serializable {
   private long avrligId;
   private int avrligOrdre;
   private long avrligIdBlv;
   private long avrligIdFac;
   private long avrligIdNdb;
   private String avrligCode;
   private String avrligFamille;
   private String avrligLibelle;
   private String avrligComplement;
   private String avrligReference;
   private String avrligTaxe;
   private float avrligTauxTaxe;
   private String avrligUnite;
   private String avrligCondition;
   private String avrligDescription;
   private String avrligDepot;
   private int avrligEchelle;
   private float avrligQte;
   private float avrligLong;
   private float avrligLarg;
   private float avrligHaut;
   private float avrligDiam;
   private float avrligNb;
   private float avrligPoidsNet;
   private float avrligPoidsBrut;
   private float avrligVolume;
   private float avrligQteUtil;
   private int avrligStock;
   private float avrligQteStock;
   private String avrligLot;
   private String avrligNumSerie;
   private String avrligDevise;
   private double avrligPu;
   private double avrligPuTtc;
   private float avrligTauxRemise;
   private double avrligRabais;
   private double avrligPuRem;
   private double avrligPuRemTtc;
   private double avrligPt;
   private double avrligTva;
   private double avrligTc;
   private double avrligTtc;
   private double avrligPump;
   private double avrligCommission;
   private String avrligGroupe;
   private int avrligModeGroupe;
   private AvoirEnteteVentes avoirEnteteVentes;
   private List var_listDepotItem = new ArrayList();
   private String var_depotLigne;
   private float var_qteDejaTrf;
   private float var_qteReliquat;
   private String var_lib_uni_condit;
   private String var_lib_des_condit;
   private boolean var_choix_qte;
   private Unite unite = new Unite();
   private double var_comUnite;
   private String styleLigne;
   private float var_comPourcentage;
   private double var_totCommission;
   private String com_num;
   private Date com_date;
   private Date com_lastDatereg;
   private long com_nbJour;
   private String com_serie;
   private String com_cat;
   private String com_nomTiers;
   private long com_idTiers;
   private String com_civilite;
   private String com_nomContact;
   private long com_idContact;
   private String com_civiliteContact;
   private String com_nomResponsable;
   private long com_idResponsable;
   private String com_nomCommercial;
   private long com_idCommercial;
   private String com_nomEquipe;
   private long com_idEquipe;

   public String getVar_lib_des_condit() {
      return this.var_lib_des_condit;
   }

   public void setVar_lib_des_condit(String var1) {
      this.var_lib_des_condit = var1;
   }

   public String getStyleLigne() {
      if (this.avrligGroupe != null && !this.avrligGroupe.isEmpty()) {
         this.styleLigne = "font-style:italic;font-size:7px;";
      } else {
         this.styleLigne = "font-style:normal;";
      }

      return this.styleLigne;
   }

   public void setStyleLigne(String var1) {
      this.styleLigne = var1;
   }

   public String getCom_cat() {
      return this.com_cat;
   }

   public void setCom_cat(String var1) {
      this.com_cat = var1;
   }

   public String getCom_civilite() {
      return this.com_civilite;
   }

   public void setCom_civilite(String var1) {
      this.com_civilite = var1;
   }

   public String getCom_civiliteContact() {
      return this.com_civiliteContact;
   }

   public void setCom_civiliteContact(String var1) {
      this.com_civiliteContact = var1;
   }

   public Date getCom_date() {
      return this.com_date;
   }

   public void setCom_date(Date var1) {
      this.com_date = var1;
   }

   public long getCom_idCommercial() {
      return this.com_idCommercial;
   }

   public void setCom_idCommercial(long var1) {
      this.com_idCommercial = var1;
   }

   public long getCom_idContact() {
      return this.com_idContact;
   }

   public void setCom_idContact(long var1) {
      this.com_idContact = var1;
   }

   public long getCom_idResponsable() {
      return this.com_idResponsable;
   }

   public void setCom_idResponsable(long var1) {
      this.com_idResponsable = var1;
   }

   public long getCom_idTiers() {
      return this.com_idTiers;
   }

   public void setCom_idTiers(long var1) {
      this.com_idTiers = var1;
   }

   public Date getCom_lastDatereg() {
      return this.com_lastDatereg;
   }

   public void setCom_lastDatereg(Date var1) {
      this.com_lastDatereg = var1;
   }

   public long getCom_nbJour() {
      return this.com_nbJour;
   }

   public void setCom_nbJour(long var1) {
      this.com_nbJour = var1;
   }

   public String getCom_nomCommercial() {
      return this.com_nomCommercial;
   }

   public void setCom_nomCommercial(String var1) {
      this.com_nomCommercial = var1;
   }

   public String getCom_nomContact() {
      return this.com_nomContact;
   }

   public void setCom_nomContact(String var1) {
      this.com_nomContact = var1;
   }

   public String getCom_nomResponsable() {
      return this.com_nomResponsable;
   }

   public void setCom_nomResponsable(String var1) {
      this.com_nomResponsable = var1;
   }

   public String getCom_nomTiers() {
      return this.com_nomTiers;
   }

   public void setCom_nomTiers(String var1) {
      this.com_nomTiers = var1;
   }

   public String getCom_num() {
      return this.com_num;
   }

   public void setCom_num(String var1) {
      this.com_num = var1;
   }

   public String getCom_serie() {
      return this.com_serie;
   }

   public void setCom_serie(String var1) {
      this.com_serie = var1;
   }

   public float getVar_comPourcentage() {
      return this.var_comPourcentage;
   }

   public void setVar_comPourcentage(float var1) {
      this.var_comPourcentage = var1;
   }

   public double getVar_comUnite() {
      return this.var_comUnite;
   }

   public void setVar_comUnite(double var1) {
      this.var_comUnite = var1;
   }

   public double getVar_totCommission() {
      return this.var_totCommission;
   }

   public void setVar_totCommission(double var1) {
      this.var_totCommission = var1;
   }

   public String getVar_lib_uni_condit() {
      if (this.avrligCondition != null && !this.avrligCondition.isEmpty() && this.avrligCondition.contains(":")) {
         if (this.avrligDescription != null && !this.avrligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.avrligDescription;
         } else if (this.avrligCondition.contains("/")) {
            String[] var1 = this.avrligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.avrligCondition;
         }
      } else if (this.avrligCondition != null && !this.avrligCondition.isEmpty() && !this.avrligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.avrligCondition));
      } else if (this.avrligUnite != null && !this.avrligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.avrligUnite;
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
      if (this.avrligCondition != null && !this.avrligCondition.isEmpty() && !this.avrligCondition.contains(":")) {
         this.var_choix_qte = true;
      } else {
         this.var_choix_qte = false;
      }

      return this.var_choix_qte;
   }

   public void setVar_choix_qte(boolean var1) {
      this.var_choix_qte = var1;
   }

   public String getAvrligCode() {
      return this.avrligCode;
   }

   public void setAvrligCode(String var1) {
      this.avrligCode = var1;
   }

   public String getAvrligDepot() {
      return this.avrligDepot;
   }

   public void setAvrligDepot(String var1) {
      this.avrligDepot = var1;
   }

   public String getAvrligDevise() {
      return this.avrligDevise;
   }

   public void setAvrligDevise(String var1) {
      this.avrligDevise = var1;
   }

   public String getAvrligFamille() {
      return this.avrligFamille;
   }

   public void setAvrligFamille(String var1) {
      this.avrligFamille = var1;
   }

   public long getAvrligId() {
      return this.avrligId;
   }

   public void setAvrligId(long var1) {
      this.avrligId = var1;
   }

   public String getAvrligLibelle() {
      return this.avrligLibelle;
   }

   public void setAvrligLibelle(String var1) {
      this.avrligLibelle = var1;
   }

   public String getAvrligLot() {
      return this.avrligLot;
   }

   public void setAvrligLot(String var1) {
      this.avrligLot = var1;
   }

   public String getAvrligNumSerie() {
      return this.avrligNumSerie;
   }

   public void setAvrligNumSerie(String var1) {
      this.avrligNumSerie = var1;
   }

   public double getAvrligPt() {
      return this.avrligPt;
   }

   public void setAvrligPt(double var1) {
      this.avrligPt = var1;
   }

   public double getAvrligPu() {
      return this.avrligPu;
   }

   public void setAvrligPu(double var1) {
      this.avrligPu = var1;
   }

   public double getAvrligPuRem() {
      return this.avrligPuRem;
   }

   public void setAvrligPuRem(double var1) {
      this.avrligPuRem = var1;
   }

   public double getAvrligPump() {
      return this.avrligPump;
   }

   public void setAvrligPump(double var1) {
      this.avrligPump = var1;
   }

   public float getAvrligQte() {
      return this.avrligQte;
   }

   public void setAvrligQte(float var1) {
      this.avrligQte = var1;
   }

   public float getAvrligQteStock() {
      return this.avrligQteStock;
   }

   public void setAvrligQteStock(float var1) {
      this.avrligQteStock = var1;
   }

   public double getAvrligRabais() {
      return this.avrligRabais;
   }

   public void setAvrligRabais(double var1) {
      this.avrligRabais = var1;
   }

   public String getAvrligReference() {
      return this.avrligReference;
   }

   public void setAvrligReference(String var1) {
      this.avrligReference = var1;
   }

   public float getAvrligTauxRemise() {
      return this.avrligTauxRemise;
   }

   public void setAvrligTauxRemise(float var1) {
      this.avrligTauxRemise = var1;
   }

   public float getAvrligTauxTaxe() {
      return this.avrligTauxTaxe;
   }

   public void setAvrligTauxTaxe(float var1) {
      this.avrligTauxTaxe = var1;
   }

   public String getAvrligTaxe() {
      return this.avrligTaxe;
   }

   public void setAvrligTaxe(String var1) {
      this.avrligTaxe = var1;
   }

   public double getAvrligTc() {
      return this.avrligTc;
   }

   public void setAvrligTc(double var1) {
      this.avrligTc = var1;
   }

   public double getAvrligTtc() {
      return this.avrligTtc;
   }

   public void setAvrligTtc(double var1) {
      this.avrligTtc = var1;
   }

   public double getAvrligTva() {
      return this.avrligTva;
   }

   public void setAvrligTva(double var1) {
      this.avrligTva = var1;
   }

   public String getAvrligUnite() {
      return this.avrligUnite;
   }

   public void setAvrligUnite(String var1) {
      this.avrligUnite = var1;
   }

   public AvoirEnteteVentes getAvoirEnteteVentes() {
      return this.avoirEnteteVentes;
   }

   public void setAvoirEnteteVentes(AvoirEnteteVentes var1) {
      this.avoirEnteteVentes = var1;
   }

   public long getAvrligIdFac() {
      return this.avrligIdFac;
   }

   public void setAvrligIdFac(long var1) {
      this.avrligIdFac = var1;
   }

   public long getAvrligIdNdb() {
      return this.avrligIdNdb;
   }

   public void setAvrligIdNdb(long var1) {
      this.avrligIdNdb = var1;
   }

   public double getAvrligPuRemTtc() {
      return this.avrligPuRemTtc;
   }

   public void setAvrligPuRemTtc(double var1) {
      this.avrligPuRemTtc = var1;
   }

   public double getAvrligPuTtc() {
      return this.avrligPuTtc;
   }

   public void setAvrligPuTtc(double var1) {
      this.avrligPuTtc = var1;
   }

   public String getAvrligCondition() {
      return this.avrligCondition;
   }

   public void setAvrligCondition(String var1) {
      this.avrligCondition = var1;
   }

   public float getAvrligDiam() {
      return this.avrligDiam;
   }

   public void setAvrligDiam(float var1) {
      this.avrligDiam = var1;
   }

   public float getAvrligHaut() {
      return this.avrligHaut;
   }

   public void setAvrligHaut(float var1) {
      this.avrligHaut = var1;
   }

   public float getAvrligLarg() {
      return this.avrligLarg;
   }

   public void setAvrligLarg(float var1) {
      this.avrligLarg = var1;
   }

   public float getAvrligLong() {
      return this.avrligLong;
   }

   public void setAvrligLong(float var1) {
      this.avrligLong = var1;
   }

   public float getAvrligNb() {
      return this.avrligNb;
   }

   public void setAvrligNb(float var1) {
      this.avrligNb = var1;
   }

   public float getAvrligQteUtil() {
      return this.avrligQteUtil;
   }

   public void setAvrligQteUtil(float var1) {
      this.avrligQteUtil = var1;
   }

   public float getAvrligPoidsBrut() {
      return this.avrligPoidsBrut;
   }

   public void setAvrligPoidsBrut(float var1) {
      this.avrligPoidsBrut = var1;
   }

   public float getAvrligPoidsNet() {
      return this.avrligPoidsNet;
   }

   public void setAvrligPoidsNet(float var1) {
      this.avrligPoidsNet = var1;
   }

   public float getAvrligVolume() {
      return this.avrligVolume;
   }

   public void setAvrligVolume(float var1) {
      this.avrligVolume = var1;
   }

   public int getAvrligStock() {
      return this.avrligStock;
   }

   public void setAvrligStock(int var1) {
      this.avrligStock = var1;
   }

   public int getAvrligEchelle() {
      return this.avrligEchelle;
   }

   public void setAvrligEchelle(int var1) {
      this.avrligEchelle = var1;
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

   public String getAvrligDescription() {
      return this.avrligDescription;
   }

   public void setAvrligDescription(String var1) {
      this.avrligDescription = var1;
   }

   public double getAvrligCommission() {
      return this.avrligCommission;
   }

   public void setAvrligCommission(double var1) {
      this.avrligCommission = var1;
   }

   public long getAvrligIdBlv() {
      return this.avrligIdBlv;
   }

   public void setAvrligIdBlv(long var1) {
      this.avrligIdBlv = var1;
   }

   public String getAvrligComplement() {
      return this.avrligComplement;
   }

   public void setAvrligComplement(String var1) {
      this.avrligComplement = var1;
   }

   public int getAvrligOrdre() {
      return this.avrligOrdre;
   }

   public void setAvrligOrdre(int var1) {
      this.avrligOrdre = var1;
   }

   public long getCom_idEquipe() {
      return this.com_idEquipe;
   }

   public void setCom_idEquipe(long var1) {
      this.com_idEquipe = var1;
   }

   public String getCom_nomEquipe() {
      return this.com_nomEquipe;
   }

   public void setCom_nomEquipe(String var1) {
      this.com_nomEquipe = var1;
   }

   public String getAvrligGroupe() {
      return this.avrligGroupe;
   }

   public void setAvrligGroupe(String var1) {
      this.avrligGroupe = var1;
   }

   public int getAvrligModeGroupe() {
      return this.avrligModeGroupe;
   }

   public void setAvrligModeGroupe(int var1) {
      this.avrligModeGroupe = var1;
   }
}
