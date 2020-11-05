package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteDebitLigneVentes implements Serializable {
   private long ndbligId;
   private int ndbligOrdre;
   private long ndbligIdDvs;
   private long ndbligIdBcm;
   private long ndbligIdBlv;
   private String ndbligCode;
   private String ndbligFamille;
   private String ndbligLibelle;
   private String ndbligComplement;
   private String ndbligReference;
   private String ndbligTaxe;
   private float ndbligTauxTaxe;
   private String ndbligUnite;
   private String ndbligCondition;
   private String ndbligDescription;
   private String ndbligDepot;
   private int ndbligStock;
   private int ndbligEchelle;
   private float ndbligQte;
   private float ndbligLong;
   private float ndbligLarg;
   private float ndbligHaut;
   private float ndbligDiam;
   private float ndbligNb;
   private float ndbligPoidsNet;
   private float ndbligPoidsBrut;
   private float ndbligVolume;
   private float ndbligQteUtil;
   private float ndbligQteStock;
   private String ndbligLot;
   private String ndbligNumSerie;
   private String ndbligDevise;
   private double ndbligPu;
   private double ndbligPuTtc;
   private float ndbligTauxRemise;
   private double ndbligRabais;
   private double ndbligPuRem;
   private double ndbligPuRemTtc;
   private double ndbligPt;
   private double ndbligTva;
   private double ndbligTc;
   private double ndbligTtc;
   private double ndbligPump;
   private double ndbligCommission;
   private String ndbligGroupe;
   private int ndbligModeGroupe;
   private NoteDebitEnteteVentes noteDebitEnteteVentes;
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

   public String getVar_lib_des_condit() {
      return this.var_lib_des_condit;
   }

   public void setVar_lib_des_condit(String var1) {
      this.var_lib_des_condit = var1;
   }

   public String getStyleLigne() {
      if (this.ndbligGroupe != null && !this.ndbligGroupe.isEmpty()) {
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
      if (this.ndbligCondition != null && !this.ndbligCondition.isEmpty() && this.ndbligCondition.contains(":")) {
         if (this.ndbligDescription != null && !this.ndbligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.ndbligDescription;
         } else if (this.ndbligCondition.contains("/")) {
            String[] var1 = this.ndbligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.ndbligCondition;
         }
      } else if (this.ndbligCondition != null && !this.ndbligCondition.isEmpty() && !this.ndbligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.ndbligCondition));
      } else if (this.ndbligUnite != null && !this.ndbligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.ndbligUnite;
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
      if (this.ndbligCondition != null && !this.ndbligCondition.isEmpty() && !this.ndbligCondition.contains(":")) {
         this.var_choix_qte = true;
      } else {
         this.var_choix_qte = false;
      }

      return this.var_choix_qte;
   }

   public void setVar_choix_qte(boolean var1) {
      this.var_choix_qte = var1;
   }

   public NoteDebitEnteteVentes getNoteDebitEnteteVentes() {
      return this.noteDebitEnteteVentes;
   }

   public void setNoteDebitEnteteVentes(NoteDebitEnteteVentes var1) {
      this.noteDebitEnteteVentes = var1;
   }

   public String getNdbligCode() {
      return this.ndbligCode;
   }

   public void setNdbligCode(String var1) {
      this.ndbligCode = var1;
   }

   public String getNdbligDepot() {
      return this.ndbligDepot;
   }

   public void setNdbligDepot(String var1) {
      this.ndbligDepot = var1;
   }

   public String getNdbligDevise() {
      return this.ndbligDevise;
   }

   public void setNdbligDevise(String var1) {
      this.ndbligDevise = var1;
   }

   public String getNdbligFamille() {
      return this.ndbligFamille;
   }

   public void setNdbligFamille(String var1) {
      this.ndbligFamille = var1;
   }

   public long getNdbligId() {
      return this.ndbligId;
   }

   public void setNdbligId(long var1) {
      this.ndbligId = var1;
   }

   public long getNdbligIdBcm() {
      return this.ndbligIdBcm;
   }

   public void setNdbligIdBcm(long var1) {
      this.ndbligIdBcm = var1;
   }

   public long getNdbligIdBlv() {
      return this.ndbligIdBlv;
   }

   public void setNdbligIdBlv(long var1) {
      this.ndbligIdBlv = var1;
   }

   public long getNdbligIdDvs() {
      return this.ndbligIdDvs;
   }

   public void setNdbligIdDvs(long var1) {
      this.ndbligIdDvs = var1;
   }

   public String getNdbligLibelle() {
      return this.ndbligLibelle;
   }

   public void setNdbligLibelle(String var1) {
      this.ndbligLibelle = var1;
   }

   public String getNdbligLot() {
      return this.ndbligLot;
   }

   public void setNdbligLot(String var1) {
      this.ndbligLot = var1;
   }

   public String getNdbligNumSerie() {
      return this.ndbligNumSerie;
   }

   public void setNdbligNumSerie(String var1) {
      this.ndbligNumSerie = var1;
   }

   public double getNdbligPt() {
      return this.ndbligPt;
   }

   public void setNdbligPt(double var1) {
      this.ndbligPt = var1;
   }

   public double getNdbligPu() {
      return this.ndbligPu;
   }

   public void setNdbligPu(double var1) {
      this.ndbligPu = var1;
   }

   public double getNdbligPuRem() {
      return this.ndbligPuRem;
   }

   public void setNdbligPuRem(double var1) {
      this.ndbligPuRem = var1;
   }

   public double getNdbligPump() {
      return this.ndbligPump;
   }

   public void setNdbligPump(double var1) {
      this.ndbligPump = var1;
   }

   public float getNdbligQte() {
      return this.ndbligQte;
   }

   public void setNdbligQte(float var1) {
      this.ndbligQte = var1;
   }

   public float getNdbligQteStock() {
      return this.ndbligQteStock;
   }

   public void setNdbligQteStock(float var1) {
      this.ndbligQteStock = var1;
   }

   public double getNdbligRabais() {
      return this.ndbligRabais;
   }

   public void setNdbligRabais(double var1) {
      this.ndbligRabais = var1;
   }

   public String getNdbligReference() {
      return this.ndbligReference;
   }

   public void setNdbligReference(String var1) {
      this.ndbligReference = var1;
   }

   public float getNdbligTauxRemise() {
      return this.ndbligTauxRemise;
   }

   public void setNdbligTauxRemise(float var1) {
      this.ndbligTauxRemise = var1;
   }

   public float getNdbligTauxTaxe() {
      return this.ndbligTauxTaxe;
   }

   public void setNdbligTauxTaxe(float var1) {
      this.ndbligTauxTaxe = var1;
   }

   public String getNdbligTaxe() {
      return this.ndbligTaxe;
   }

   public void setNdbligTaxe(String var1) {
      this.ndbligTaxe = var1;
   }

   public double getNdbligTc() {
      return this.ndbligTc;
   }

   public void setNdbligTc(double var1) {
      this.ndbligTc = var1;
   }

   public double getNdbligTtc() {
      return this.ndbligTtc;
   }

   public void setNdbligTtc(double var1) {
      this.ndbligTtc = var1;
   }

   public double getNdbligTva() {
      return this.ndbligTva;
   }

   public void setNdbligTva(double var1) {
      this.ndbligTva = var1;
   }

   public String getNdbligUnite() {
      return this.ndbligUnite;
   }

   public void setNdbligUnite(String var1) {
      this.ndbligUnite = var1;
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

   public double getNdbligPuRemTtc() {
      return this.ndbligPuRemTtc;
   }

   public void setNdbligPuRemTtc(double var1) {
      this.ndbligPuRemTtc = var1;
   }

   public double getNdbligPuTtc() {
      return this.ndbligPuTtc;
   }

   public void setNdbligPuTtc(double var1) {
      this.ndbligPuTtc = var1;
   }

   public String getNdbligCondition() {
      return this.ndbligCondition;
   }

   public void setNdbligCondition(String var1) {
      this.ndbligCondition = var1;
   }

   public float getNdbligDiam() {
      return this.ndbligDiam;
   }

   public void setNdbligDiam(float var1) {
      this.ndbligDiam = var1;
   }

   public float getNdbligHaut() {
      return this.ndbligHaut;
   }

   public void setNdbligHaut(float var1) {
      this.ndbligHaut = var1;
   }

   public float getNdbligLarg() {
      return this.ndbligLarg;
   }

   public void setNdbligLarg(float var1) {
      this.ndbligLarg = var1;
   }

   public float getNdbligLong() {
      return this.ndbligLong;
   }

   public void setNdbligLong(float var1) {
      this.ndbligLong = var1;
   }

   public float getNdbligNb() {
      return this.ndbligNb;
   }

   public void setNdbligNb(float var1) {
      this.ndbligNb = var1;
   }

   public float getNdbligQteUtil() {
      return this.ndbligQteUtil;
   }

   public void setNdbligQteUtil(float var1) {
      this.ndbligQteUtil = var1;
   }

   public float getNdbligPoidsBrut() {
      return this.ndbligPoidsBrut;
   }

   public void setNdbligPoidsBrut(float var1) {
      this.ndbligPoidsBrut = var1;
   }

   public float getNdbligPoidsNet() {
      return this.ndbligPoidsNet;
   }

   public void setNdbligPoidsNet(float var1) {
      this.ndbligPoidsNet = var1;
   }

   public float getNdbligVolume() {
      return this.ndbligVolume;
   }

   public void setNdbligVolume(float var1) {
      this.ndbligVolume = var1;
   }

   public int getNdbligStock() {
      return this.ndbligStock;
   }

   public void setNdbligStock(int var1) {
      this.ndbligStock = var1;
   }

   public int getNdbligEchelle() {
      return this.ndbligEchelle;
   }

   public void setNdbligEchelle(int var1) {
      this.ndbligEchelle = var1;
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

   public String getNdbligDescription() {
      return this.ndbligDescription;
   }

   public void setNdbligDescription(String var1) {
      this.ndbligDescription = var1;
   }

   public double getNdbligCommission() {
      return this.ndbligCommission;
   }

   public void setNdbligCommission(double var1) {
      this.ndbligCommission = var1;
   }

   public int getNdbligOrdre() {
      return this.ndbligOrdre;
   }

   public void setNdbligOrdre(int var1) {
      this.ndbligOrdre = var1;
   }

   public String getNdbligComplement() {
      return this.ndbligComplement;
   }

   public void setNdbligComplement(String var1) {
      this.ndbligComplement = var1;
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

   public String getNdbligGroupe() {
      return this.ndbligGroupe;
   }

   public void setNdbligGroupe(String var1) {
      this.ndbligGroupe = var1;
   }

   public int getNdbligModeGroupe() {
      return this.ndbligModeGroupe;
   }

   public void setNdbligModeGroupe(int var1) {
      this.ndbligModeGroupe = var1;
   }
}
