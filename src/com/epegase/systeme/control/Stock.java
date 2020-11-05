package com.epegase.systeme.control;

import java.io.Serializable;
import java.util.Date;

public class Stock implements Serializable {
   private long stk_id;
   private String stk_lib_type;
   private int stk_type;
   private String stk_etat;
   private String stk_code_depot;
   private String stk_code_produit;
   private String stk_serie;
   private String stk_numero;
   private String stk_tiers;
   private String stk_commercial;
   private String stk_divers;
   private String stk_activite;
   private String stk_dossier;
   private Date stk_date_mvt;
   private int stk_format_devise;
   private float stk_devise;
   private float stk_coefPr;
   private double stk_pa;
   private double stk_pv;
   private double stk_pump;
   private double stk_prKg;
   private float stk_qte_in;
   private float stk_qte_out;
   private float stk_qte_mini;
   private float stk_qte_maxi;
   private float stk_qte;
   private float stk_qte_progress;
   private float stk_qte_attCmdAch;
   private float stk_qte_attRecAch;
   private float stk_qte_attCmdVte;
   private float stk_qte_attRecVte;
   private int stk_annee;
   private int stk_mois;
   private String stk_Obs;
   private String stk_code_generique;
   private long stk_equipe;
   private int factureDirecte;
   private int stkOrigine;
   private String stkReference;
   private String stkLibelle;
   private String stkFamille;
   private String stkTaxe;
   private float stkTauxTaxe;
   private String stkUnite;
   private String stkDevise;
   private float stkTauxRemise;
   private double stkRabais;
   private double stkPuRem;
   private double stkPuTtc;
   private double stkPuRemTtc;
   private double stkPt;
   private double stkTva;
   private double stkTc;
   private double stkTtc;
   private boolean select;

   public String getStk_code_depot() {
      return this.stk_code_depot;
   }

   public void setStk_code_depot(String var1) {
      this.stk_code_depot = var1;
   }

   public String getStk_code_produit() {
      return this.stk_code_produit;
   }

   public void setStk_code_produit(String var1) {
      this.stk_code_produit = var1;
   }

   public Date getStk_date_mvt() {
      return this.stk_date_mvt;
   }

   public void setStk_date_mvt(Date var1) {
      this.stk_date_mvt = var1;
   }

   public float getStk_qte_in() {
      return this.stk_qte_in;
   }

   public void setStk_qte_in(float var1) {
      this.stk_qte_in = var1;
   }

   public float getStk_qte_out() {
      return this.stk_qte_out;
   }

   public void setStk_qte_out(float var1) {
      this.stk_qte_out = var1;
   }

   public double getStk_pa() {
      return this.stk_pa;
   }

   public void setStk_pa(double var1) {
      this.stk_pa = var1;
   }

   public double getStk_pump() {
      return this.stk_pump;
   }

   public void setStk_pump(double var1) {
      this.stk_pump = var1;
   }

   public String getStk_lib_type() {
      return this.stk_lib_type;
   }

   public void setStk_lib_type(String var1) {
      this.stk_lib_type = var1;
   }

   public int getStk_type() {
      return this.stk_type;
   }

   public void setStk_type(int var1) {
      this.stk_type = var1;
   }

   public String getStk_numero() {
      return this.stk_numero;
   }

   public void setStk_numero(String var1) {
      this.stk_numero = var1;
   }

   public String getStk_tiers() {
      return this.stk_tiers;
   }

   public void setStk_tiers(String var1) {
      this.stk_tiers = var1;
   }

   public String getStk_activite() {
      return this.stk_activite;
   }

   public void setStk_activite(String var1) {
      this.stk_activite = var1;
   }

   public double getStk_pv() {
      return this.stk_pv;
   }

   public void setStk_pv(double var1) {
      this.stk_pv = var1;
   }

   public String getStkDevise() {
      return this.stkDevise;
   }

   public void setStkDevise(String var1) {
      this.stkDevise = var1;
   }

   public String getStkFamille() {
      return this.stkFamille;
   }

   public void setStkFamille(String var1) {
      this.stkFamille = var1;
   }

   public String getStkLibelle() {
      return this.stkLibelle;
   }

   public void setStkLibelle(String var1) {
      this.stkLibelle = var1;
   }

   public double getStkPt() {
      return this.stkPt;
   }

   public void setStkPt(double var1) {
      this.stkPt = var1;
   }

   public double getStkPuRem() {
      return this.stkPuRem;
   }

   public void setStkPuRem(double var1) {
      this.stkPuRem = var1;
   }

   public double getStkPuRemTtc() {
      return this.stkPuRemTtc;
   }

   public void setStkPuRemTtc(double var1) {
      this.stkPuRemTtc = var1;
   }

   public double getStkPuTtc() {
      return this.stkPuTtc;
   }

   public void setStkPuTtc(double var1) {
      this.stkPuTtc = var1;
   }

   public double getStkRabais() {
      return this.stkRabais;
   }

   public void setStkRabais(double var1) {
      this.stkRabais = var1;
   }

   public String getStkReference() {
      return this.stkReference;
   }

   public void setStkReference(String var1) {
      this.stkReference = var1;
   }

   public float getStkTauxRemise() {
      return this.stkTauxRemise;
   }

   public void setStkTauxRemise(float var1) {
      this.stkTauxRemise = var1;
   }

   public float getStkTauxTaxe() {
      return this.stkTauxTaxe;
   }

   public void setStkTauxTaxe(float var1) {
      this.stkTauxTaxe = var1;
   }

   public String getStkTaxe() {
      return this.stkTaxe;
   }

   public void setStkTaxe(String var1) {
      this.stkTaxe = var1;
   }

   public double getStkTc() {
      return this.stkTc;
   }

   public void setStkTc(double var1) {
      this.stkTc = var1;
   }

   public double getStkTtc() {
      return this.stkTtc;
   }

   public void setStkTtc(double var1) {
      this.stkTtc = var1;
   }

   public double getStkTva() {
      return this.stkTva;
   }

   public void setStkTva(double var1) {
      this.stkTva = var1;
   }

   public String getStkUnite() {
      return this.stkUnite;
   }

   public void setStkUnite(String var1) {
      this.stkUnite = var1;
   }

   public int getStk_annee() {
      this.stk_annee = this.stk_date_mvt.getYear() + 1900;
      return this.stk_annee;
   }

   public void setStk_annee(int var1) {
      this.stk_annee = var1;
   }

   public int getStk_mois() {
      this.stk_mois = this.stk_date_mvt.getMonth() + 1;
      return this.stk_mois;
   }

   public void setStk_mois(int var1) {
      this.stk_mois = var1;
   }

   public String getStk_etat() {
      return this.stk_etat;
   }

   public void setStk_etat(String var1) {
      this.stk_etat = var1;
   }

   public int getStk_format_devise() {
      return this.stk_format_devise;
   }

   public void setStk_format_devise(int var1) {
      this.stk_format_devise = var1;
   }

   public float getStk_qte_attCmdAch() {
      return this.stk_qte_attCmdAch;
   }

   public void setStk_qte_attCmdAch(float var1) {
      this.stk_qte_attCmdAch = var1;
   }

   public float getStk_qte_attCmdVte() {
      return this.stk_qte_attCmdVte;
   }

   public void setStk_qte_attCmdVte(float var1) {
      this.stk_qte_attCmdVte = var1;
   }

   public float getStk_qte_attRecAch() {
      return this.stk_qte_attRecAch;
   }

   public void setStk_qte_attRecAch(float var1) {
      this.stk_qte_attRecAch = var1;
   }

   public float getStk_qte_attRecVte() {
      return this.stk_qte_attRecVte;
   }

   public void setStk_qte_attRecVte(float var1) {
      this.stk_qte_attRecVte = var1;
   }

   public float getStk_qte_progress() {
      return this.stk_qte_progress;
   }

   public void setStk_qte_progress(float var1) {
      this.stk_qte_progress = var1;
   }

   public String getStk_divers() {
      return this.stk_divers;
   }

   public void setStk_divers(String var1) {
      this.stk_divers = var1;
   }

   public String getStk_code_generique() {
      return this.stk_code_generique;
   }

   public void setStk_code_generique(String var1) {
      this.stk_code_generique = var1;
   }

   public long getStk_equipe() {
      return this.stk_equipe;
   }

   public void setStk_equipe(long var1) {
      this.stk_equipe = var1;
   }

   public String getStk_commercial() {
      return this.stk_commercial;
   }

   public void setStk_commercial(String var1) {
      this.stk_commercial = var1;
   }

   public long getStk_id() {
      return this.stk_id;
   }

   public void setStk_id(long var1) {
      this.stk_id = var1;
   }

   public float getStk_devise() {
      return this.stk_devise;
   }

   public void setStk_devise(float var1) {
      this.stk_devise = var1;
   }

   public int getStkOrigine() {
      return this.stkOrigine;
   }

   public void setStkOrigine(int var1) {
      this.stkOrigine = var1;
   }

   public int getFactureDirecte() {
      return this.factureDirecte;
   }

   public void setFactureDirecte(int var1) {
      this.factureDirecte = var1;
   }

   public double getStk_prKg() {
      return this.stk_prKg;
   }

   public void setStk_prKg(double var1) {
      this.stk_prKg = var1;
   }

   public String getStk_dossier() {
      return this.stk_dossier;
   }

   public void setStk_dossier(String var1) {
      this.stk_dossier = var1;
   }

   public float getStk_coefPr() {
      return this.stk_coefPr;
   }

   public void setStk_coefPr(float var1) {
      this.stk_coefPr = var1;
   }

   public float getStk_qte_maxi() {
      return this.stk_qte_maxi;
   }

   public void setStk_qte_maxi(float var1) {
      this.stk_qte_maxi = var1;
   }

   public float getStk_qte_mini() {
      return this.stk_qte_mini;
   }

   public void setStk_qte_mini(float var1) {
      this.stk_qte_mini = var1;
   }

   public float getStk_qte() {
      return this.stk_qte;
   }

   public void setStk_qte(float var1) {
      this.stk_qte = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public String getStk_Obs() {
      return this.stk_Obs;
   }

   public void setStk_Obs(String var1) {
      this.stk_Obs = var1;
   }

   public String getStk_serie() {
      return this.stk_serie;
   }

   public void setStk_serie(String var1) {
      this.stk_serie = var1;
   }
}
