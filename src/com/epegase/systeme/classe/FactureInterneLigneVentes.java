package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FactureInterneLigneVentes implements Serializable {
   private long fitligId;
   private int fitligOrdre;
   private long fitligIdDvs;
   private long fitligIdBcm;
   private long fitligIdBlv;
   private String fitligCode;
   private String fitligFamille;
   private String fitligLibelle;
   private String fitligComplement;
   private String fitligReference;
   private String fitligTaxe;
   private float fitligTauxTaxe;
   private String fitligUnite;
   private String fitligCondition;
   private String fitligDescription;
   private String fitligDepot;
   private int fitligStock;
   private int fitligEchelle;
   private float fitligQte;
   private float fitligLong;
   private float fitligLarg;
   private float fitligHaut;
   private float fitligDiam;
   private float fitligNb;
   private float fitligPoidsNet;
   private float fitligPoidsBrut;
   private float fitligVolume;
   private float fitligQteUtil;
   private float fitligQteStock;
   private String fitligLot;
   private String fitligNumSerie;
   private String fitligDevise;
   private double fitligManquant;
   private float fitligQteManquant;
   private double fitligPu;
   private double fitligPuTtc;
   private float fitligTauxRemise;
   private double fitligRabais;
   private double fitligPuRem;
   private double fitligPuRemTtc;
   private double fitligPt;
   private double fitligTva;
   private double fitligTc;
   private double fitligTtc;
   private double fitligPump;
   private double fitligCommission;
   private String fitligGroupe;
   private int fitligModeGroupe;
   private FactureInterneEnteteVentes factureInterneEnteteVentes;
   private List var_listDepotItem = new ArrayList();
   private String var_depotLigne;
   private float var_qteDejaTrf;
   private float var_qteReliquat;
   private String var_lib_uni_condit;
   private String var_lib_des_condit;
   private boolean var_choix_qte;
   private Unite unite = new Unite();
   private String styleLigne;
   private double var_comUnite;
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

   public String getStyleLigne() {
      if (this.fitligGroupe != null && !this.fitligGroupe.isEmpty()) {
         this.styleLigne = "font-style:italic;font-size:7px;";
      } else {
         this.styleLigne = "font-style:normal;";
      }

      return this.styleLigne;
   }

   public void setStyleLigne(String var1) {
      this.styleLigne = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public boolean isVar_choix_qte() {
      if (this.fitligCondition != null && !this.fitligCondition.isEmpty() && !this.fitligCondition.contains(":")) {
         this.var_choix_qte = true;
      } else {
         this.var_choix_qte = false;
      }

      return this.var_choix_qte;
   }

   public void setVar_choix_qte(boolean var1) {
      this.var_choix_qte = var1;
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

   public String getVar_depotLigne() {
      return this.var_depotLigne;
   }

   public void setVar_depotLigne(String var1) {
      this.var_depotLigne = var1;
   }

   public String getVar_lib_des_condit() {
      return this.var_lib_des_condit;
   }

   public void setVar_lib_des_condit(String var1) {
      this.var_lib_des_condit = var1;
   }

   public String getVar_lib_uni_condit() {
      if (this.fitligCondition != null && !this.fitligCondition.isEmpty() && this.fitligCondition.contains(":")) {
         if (this.fitligDescription != null && !this.fitligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.fitligDescription;
         } else if (this.fitligCondition.contains("/")) {
            String[] var1 = this.fitligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.fitligCondition;
         }
      } else if (this.fitligCondition != null && !this.fitligCondition.isEmpty() && !this.fitligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.fitligCondition));
      } else if (this.fitligUnite != null && !this.fitligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.fitligUnite;
      } else {
         this.var_lib_uni_condit = "";
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
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

   public double getVar_totCommission() {
      return this.var_totCommission;
   }

   public void setVar_totCommission(double var1) {
      this.var_totCommission = var1;
   }

   public FactureInterneEnteteVentes getFactureInterneEnteteVentes() {
      return this.factureInterneEnteteVentes;
   }

   public void setFactureInterneEnteteVentes(FactureInterneEnteteVentes var1) {
      this.factureInterneEnteteVentes = var1;
   }

   public String getFitligCode() {
      return this.fitligCode;
   }

   public void setFitligCode(String var1) {
      this.fitligCode = var1;
   }

   public double getFitligCommission() {
      return this.fitligCommission;
   }

   public void setFitligCommission(double var1) {
      this.fitligCommission = var1;
   }

   public String getFitligComplement() {
      return this.fitligComplement;
   }

   public void setFitligComplement(String var1) {
      this.fitligComplement = var1;
   }

   public String getFitligCondition() {
      return this.fitligCondition;
   }

   public void setFitligCondition(String var1) {
      this.fitligCondition = var1;
   }

   public String getFitligDepot() {
      return this.fitligDepot;
   }

   public void setFitligDepot(String var1) {
      this.fitligDepot = var1;
   }

   public String getFitligDescription() {
      return this.fitligDescription;
   }

   public void setFitligDescription(String var1) {
      this.fitligDescription = var1;
   }

   public String getFitligDevise() {
      return this.fitligDevise;
   }

   public void setFitligDevise(String var1) {
      this.fitligDevise = var1;
   }

   public float getFitligDiam() {
      return this.fitligDiam;
   }

   public void setFitligDiam(float var1) {
      this.fitligDiam = var1;
   }

   public int getFitligEchelle() {
      return this.fitligEchelle;
   }

   public void setFitligEchelle(int var1) {
      this.fitligEchelle = var1;
   }

   public String getFitligFamille() {
      return this.fitligFamille;
   }

   public void setFitligFamille(String var1) {
      this.fitligFamille = var1;
   }

   public String getFitligGroupe() {
      return this.fitligGroupe;
   }

   public void setFitligGroupe(String var1) {
      this.fitligGroupe = var1;
   }

   public float getFitligHaut() {
      return this.fitligHaut;
   }

   public void setFitligHaut(float var1) {
      this.fitligHaut = var1;
   }

   public long getFitligId() {
      return this.fitligId;
   }

   public void setFitligId(long var1) {
      this.fitligId = var1;
   }

   public long getFitligIdBcm() {
      return this.fitligIdBcm;
   }

   public void setFitligIdBcm(long var1) {
      this.fitligIdBcm = var1;
   }

   public long getFitligIdBlv() {
      return this.fitligIdBlv;
   }

   public void setFitligIdBlv(long var1) {
      this.fitligIdBlv = var1;
   }

   public long getFitligIdDvs() {
      return this.fitligIdDvs;
   }

   public void setFitligIdDvs(long var1) {
      this.fitligIdDvs = var1;
   }

   public float getFitligLarg() {
      return this.fitligLarg;
   }

   public void setFitligLarg(float var1) {
      this.fitligLarg = var1;
   }

   public String getFitligLibelle() {
      return this.fitligLibelle;
   }

   public void setFitligLibelle(String var1) {
      this.fitligLibelle = var1;
   }

   public float getFitligLong() {
      return this.fitligLong;
   }

   public void setFitligLong(float var1) {
      this.fitligLong = var1;
   }

   public String getFitligLot() {
      return this.fitligLot;
   }

   public void setFitligLot(String var1) {
      this.fitligLot = var1;
   }

   public int getFitligModeGroupe() {
      return this.fitligModeGroupe;
   }

   public void setFitligModeGroupe(int var1) {
      this.fitligModeGroupe = var1;
   }

   public float getFitligNb() {
      return this.fitligNb;
   }

   public void setFitligNb(float var1) {
      this.fitligNb = var1;
   }

   public String getFitligNumSerie() {
      return this.fitligNumSerie;
   }

   public void setFitligNumSerie(String var1) {
      this.fitligNumSerie = var1;
   }

   public int getFitligOrdre() {
      return this.fitligOrdre;
   }

   public void setFitligOrdre(int var1) {
      this.fitligOrdre = var1;
   }

   public float getFitligPoidsBrut() {
      return this.fitligPoidsBrut;
   }

   public void setFitligPoidsBrut(float var1) {
      this.fitligPoidsBrut = var1;
   }

   public float getFitligPoidsNet() {
      return this.fitligPoidsNet;
   }

   public void setFitligPoidsNet(float var1) {
      this.fitligPoidsNet = var1;
   }

   public double getFitligPt() {
      return this.fitligPt;
   }

   public void setFitligPt(double var1) {
      this.fitligPt = var1;
   }

   public double getFitligPu() {
      return this.fitligPu;
   }

   public void setFitligPu(double var1) {
      this.fitligPu = var1;
   }

   public double getFitligPuRem() {
      return this.fitligPuRem;
   }

   public void setFitligPuRem(double var1) {
      this.fitligPuRem = var1;
   }

   public double getFitligPuRemTtc() {
      return this.fitligPuRemTtc;
   }

   public void setFitligPuRemTtc(double var1) {
      this.fitligPuRemTtc = var1;
   }

   public double getFitligPuTtc() {
      return this.fitligPuTtc;
   }

   public void setFitligPuTtc(double var1) {
      this.fitligPuTtc = var1;
   }

   public double getFitligPump() {
      return this.fitligPump;
   }

   public void setFitligPump(double var1) {
      this.fitligPump = var1;
   }

   public float getFitligQte() {
      return this.fitligQte;
   }

   public void setFitligQte(float var1) {
      this.fitligQte = var1;
   }

   public float getFitligQteStock() {
      return this.fitligQteStock;
   }

   public void setFitligQteStock(float var1) {
      this.fitligQteStock = var1;
   }

   public float getFitligQteUtil() {
      return this.fitligQteUtil;
   }

   public void setFitligQteUtil(float var1) {
      this.fitligQteUtil = var1;
   }

   public double getFitligRabais() {
      return this.fitligRabais;
   }

   public void setFitligRabais(double var1) {
      this.fitligRabais = var1;
   }

   public String getFitligReference() {
      return this.fitligReference;
   }

   public void setFitligReference(String var1) {
      this.fitligReference = var1;
   }

   public int getFitligStock() {
      return this.fitligStock;
   }

   public void setFitligStock(int var1) {
      this.fitligStock = var1;
   }

   public float getFitligTauxRemise() {
      return this.fitligTauxRemise;
   }

   public void setFitligTauxRemise(float var1) {
      this.fitligTauxRemise = var1;
   }

   public float getFitligTauxTaxe() {
      return this.fitligTauxTaxe;
   }

   public void setFitligTauxTaxe(float var1) {
      this.fitligTauxTaxe = var1;
   }

   public String getFitligTaxe() {
      return this.fitligTaxe;
   }

   public void setFitligTaxe(String var1) {
      this.fitligTaxe = var1;
   }

   public double getFitligTc() {
      return this.fitligTc;
   }

   public void setFitligTc(double var1) {
      this.fitligTc = var1;
   }

   public double getFitligTtc() {
      return this.fitligTtc;
   }

   public void setFitligTtc(double var1) {
      this.fitligTtc = var1;
   }

   public double getFitligTva() {
      return this.fitligTva;
   }

   public void setFitligTva(double var1) {
      this.fitligTva = var1;
   }

   public String getFitligUnite() {
      return this.fitligUnite;
   }

   public void setFitligUnite(String var1) {
      this.fitligUnite = var1;
   }

   public float getFitligVolume() {
      return this.fitligVolume;
   }

   public void setFitligVolume(float var1) {
      this.fitligVolume = var1;
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

   public long getCom_idEquipe() {
      return this.com_idEquipe;
   }

   public void setCom_idEquipe(long var1) {
      this.com_idEquipe = var1;
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

   public String getCom_nomEquipe() {
      return this.com_nomEquipe;
   }

   public void setCom_nomEquipe(String var1) {
      this.com_nomEquipe = var1;
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

   public double getFitligManquant() {
      return this.fitligManquant;
   }

   public void setFitligManquant(double var1) {
      this.fitligManquant = var1;
   }

   public float getFitligQteManquant() {
      return this.fitligQteManquant;
   }

   public void setFitligQteManquant(float var1) {
      this.fitligQteManquant = var1;
   }
}
