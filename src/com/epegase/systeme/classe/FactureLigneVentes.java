package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FactureLigneVentes implements Serializable {
   private long facligId;
   private int facligOrdre;
   private long facligIdDvs;
   private long facligIdBcm;
   private long facligIdBlv;
   private long facligIdFac;
   private String facligCode;
   private String facligFamille;
   private String facligLibelle;
   private String facligComplement;
   private String facligReference;
   private String facligTaxe;
   private float facligTauxTaxe;
   private String facligUnite;
   private String facligCondition;
   private String facligDescription;
   private String facligDepot;
   private int facligEchelle;
   private float facligQte;
   private float facligLong;
   private float facligLarg;
   private float facligHaut;
   private float facligDiam;
   private float facligNb;
   private float facligPoidsNet;
   private float facligPoidsBrut;
   private float facligVolume;
   private float facligQteUtil;
   private float facligQteStock;
   private int facligStock;
   private String facligLot;
   private String facligNumSerie;
   private String facligDevise;
   private double facligManquant;
   private float facligQteManquant;
   private double facligPu;
   private double facligPuTtc;
   private float facligTauxRemise;
   private double facligRabais;
   private double facligPuRem;
   private double facligPuRemTtc;
   private double facligPt;
   private double facligTva;
   private double facligTc;
   private double facligTtc;
   private double facligPump;
   private int facligEntStock;
   private double facligCommission;
   private String facligGroupe;
   private int facligModeGroupe;
   private FactureEnteteVentes factureEnteteVentes;
   private List var_listDepotItem = new ArrayList();
   private String var_depotLigne;
   private float var_qteDejaTrf;
   private float var_qteReliquat;
   private String var_lib_uni_condit;
   private String var_lib_des_condit;
   private boolean var_choix_qte;
   private Unite unite = new Unite();
   private String var_desciptif;
   private String var_photo;
   private int var_photo_taille;
   private String styleLigne;
   private double var_totalTrf;
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

   public double getVar_totalTrf() {
      return this.var_totalTrf;
   }

   public void setVar_totalTrf(double var1) {
      this.var_totalTrf = var1;
   }

   public String getStyleLigne() {
      if (this.facligGroupe != null && !this.facligGroupe.isEmpty()) {
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
      if (this.facligCondition != null && !this.facligCondition.isEmpty() && this.facligCondition.contains(":")) {
         if (this.facligDescription != null && !this.facligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.facligDescription;
         } else if (this.facligCondition.contains("/")) {
            String[] var1 = this.facligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.facligCondition;
         }
      } else if (this.facligCondition != null && !this.facligCondition.isEmpty() && !this.facligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.facligCondition));
      } else if (this.facligUnite != null && !this.facligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.facligUnite;
      } else {
         this.var_lib_uni_condit = "";
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public String getVar_lib_des_condit() {
      return this.var_lib_des_condit;
   }

   public void setVar_lib_des_condit(String var1) {
      this.var_lib_des_condit = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public boolean isVar_choix_qte() {
      if (this.facligCondition != null && !this.facligCondition.isEmpty() && !this.facligCondition.contains(":")) {
         this.var_choix_qte = true;
      } else {
         this.var_choix_qte = false;
      }

      return this.var_choix_qte;
   }

   public void setVar_choix_qte(boolean var1) {
      this.var_choix_qte = var1;
   }

   public FactureEnteteVentes getFactureEnteteVentes() {
      return this.factureEnteteVentes;
   }

   public void setFactureEnteteVentes(FactureEnteteVentes var1) {
      this.factureEnteteVentes = var1;
   }

   public String getFacligCode() {
      return this.facligCode;
   }

   public void setFacligCode(String var1) {
      this.facligCode = var1;
   }

   public String getFacligDepot() {
      return this.facligDepot;
   }

   public void setFacligDepot(String var1) {
      this.facligDepot = var1;
   }

   public String getFacligDevise() {
      return this.facligDevise;
   }

   public void setFacligDevise(String var1) {
      this.facligDevise = var1;
   }

   public String getFacligFamille() {
      return this.facligFamille;
   }

   public void setFacligFamille(String var1) {
      this.facligFamille = var1;
   }

   public long getFacligId() {
      return this.facligId;
   }

   public void setFacligId(long var1) {
      this.facligId = var1;
   }

   public long getFacligIdBcm() {
      return this.facligIdBcm;
   }

   public void setFacligIdBcm(long var1) {
      this.facligIdBcm = var1;
   }

   public long getFacligIdDvs() {
      return this.facligIdDvs;
   }

   public void setFacligIdDvs(long var1) {
      this.facligIdDvs = var1;
   }

   public String getFacligLibelle() {
      return this.facligLibelle;
   }

   public void setFacligLibelle(String var1) {
      this.facligLibelle = var1;
   }

   public String getFacligLot() {
      return this.facligLot;
   }

   public void setFacligLot(String var1) {
      this.facligLot = var1;
   }

   public String getFacligNumSerie() {
      return this.facligNumSerie;
   }

   public void setFacligNumSerie(String var1) {
      this.facligNumSerie = var1;
   }

   public double getFacligPt() {
      return this.facligPt;
   }

   public void setFacligPt(double var1) {
      this.facligPt = var1;
   }

   public double getFacligPu() {
      return this.facligPu;
   }

   public void setFacligPu(double var1) {
      this.facligPu = var1;
   }

   public double getFacligPuRem() {
      return this.facligPuRem;
   }

   public void setFacligPuRem(double var1) {
      this.facligPuRem = var1;
   }

   public double getFacligPump() {
      return this.facligPump;
   }

   public void setFacligPump(double var1) {
      this.facligPump = var1;
   }

   public float getFacligQte() {
      return this.facligQte;
   }

   public void setFacligQte(float var1) {
      this.facligQte = var1;
   }

   public float getFacligQteStock() {
      return this.facligQteStock;
   }

   public void setFacligQteStock(float var1) {
      this.facligQteStock = var1;
   }

   public double getFacligRabais() {
      return this.facligRabais;
   }

   public void setFacligRabais(double var1) {
      this.facligRabais = var1;
   }

   public String getFacligReference() {
      return this.facligReference;
   }

   public void setFacligReference(String var1) {
      this.facligReference = var1;
   }

   public float getFacligTauxRemise() {
      return this.facligTauxRemise;
   }

   public void setFacligTauxRemise(float var1) {
      this.facligTauxRemise = var1;
   }

   public float getFacligTauxTaxe() {
      return this.facligTauxTaxe;
   }

   public void setFacligTauxTaxe(float var1) {
      this.facligTauxTaxe = var1;
   }

   public String getFacligTaxe() {
      return this.facligTaxe;
   }

   public void setFacligTaxe(String var1) {
      this.facligTaxe = var1;
   }

   public double getFacligTc() {
      return this.facligTc;
   }

   public void setFacligTc(double var1) {
      this.facligTc = var1;
   }

   public double getFacligTtc() {
      return this.facligTtc;
   }

   public void setFacligTtc(double var1) {
      this.facligTtc = var1;
   }

   public double getFacligTva() {
      return this.facligTva;
   }

   public void setFacligTva(double var1) {
      this.facligTva = var1;
   }

   public String getFacligUnite() {
      return this.facligUnite;
   }

   public void setFacligUnite(String var1) {
      this.facligUnite = var1;
   }

   public long getFacligIdBlv() {
      return this.facligIdBlv;
   }

   public void setFacligIdBlv(long var1) {
      this.facligIdBlv = var1;
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

   public double getFacligPuRemTtc() {
      return this.facligPuRemTtc;
   }

   public void setFacligPuRemTtc(double var1) {
      this.facligPuRemTtc = var1;
   }

   public double getFacligPuTtc() {
      return this.facligPuTtc;
   }

   public void setFacligPuTtc(double var1) {
      this.facligPuTtc = var1;
   }

   public String getFacligCondition() {
      return this.facligCondition;
   }

   public void setFacligCondition(String var1) {
      this.facligCondition = var1;
   }

   public float getFacligDiam() {
      return this.facligDiam;
   }

   public void setFacligDiam(float var1) {
      this.facligDiam = var1;
   }

   public float getFacligHaut() {
      return this.facligHaut;
   }

   public void setFacligHaut(float var1) {
      this.facligHaut = var1;
   }

   public float getFacligLarg() {
      return this.facligLarg;
   }

   public void setFacligLarg(float var1) {
      this.facligLarg = var1;
   }

   public float getFacligLong() {
      return this.facligLong;
   }

   public void setFacligLong(float var1) {
      this.facligLong = var1;
   }

   public float getFacligNb() {
      return this.facligNb;
   }

   public void setFacligNb(float var1) {
      this.facligNb = var1;
   }

   public float getFacligQteUtil() {
      return this.facligQteUtil;
   }

   public void setFacligQteUtil(float var1) {
      this.facligQteUtil = var1;
   }

   public float getFacligPoidsBrut() {
      return this.facligPoidsBrut;
   }

   public void setFacligPoidsBrut(float var1) {
      this.facligPoidsBrut = var1;
   }

   public float getFacligPoidsNet() {
      return this.facligPoidsNet;
   }

   public void setFacligPoidsNet(float var1) {
      this.facligPoidsNet = var1;
   }

   public float getFacligVolume() {
      return this.facligVolume;
   }

   public void setFacligVolume(float var1) {
      this.facligVolume = var1;
   }

   public int getFacligStock() {
      return this.facligStock;
   }

   public void setFacligStock(int var1) {
      this.facligStock = var1;
   }

   public int getFacligEchelle() {
      return this.facligEchelle;
   }

   public void setFacligEchelle(int var1) {
      this.facligEchelle = var1;
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

   public String getFacligDescription() {
      return this.facligDescription;
   }

   public void setFacligDescription(String var1) {
      this.facligDescription = var1;
   }

   public int getFacligEntStock() {
      return this.facligEntStock;
   }

   public void setFacligEntStock(int var1) {
      this.facligEntStock = var1;
   }

   public double getFacligCommission() {
      return this.facligCommission;
   }

   public void setFacligCommission(double var1) {
      this.facligCommission = var1;
   }

   public int getFacligOrdre() {
      return this.facligOrdre;
   }

   public void setFacligOrdre(int var1) {
      this.facligOrdre = var1;
   }

   public String getFacligComplement() {
      return this.facligComplement;
   }

   public void setFacligComplement(String var1) {
      this.facligComplement = var1;
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

   public String getFacligGroupe() {
      return this.facligGroupe;
   }

   public void setFacligGroupe(String var1) {
      this.facligGroupe = var1;
   }

   public int getFacligModeGroupe() {
      return this.facligModeGroupe;
   }

   public void setFacligModeGroupe(int var1) {
      this.facligModeGroupe = var1;
   }

   public long getFacligIdFac() {
      return this.facligIdFac;
   }

   public void setFacligIdFac(long var1) {
      this.facligIdFac = var1;
   }

   public double getFacligManquant() {
      return this.facligManquant;
   }

   public void setFacligManquant(double var1) {
      this.facligManquant = var1;
   }

   public float getFacligQteManquant() {
      return this.facligQteManquant;
   }

   public void setFacligQteManquant(float var1) {
      this.facligQteManquant = var1;
   }
}
