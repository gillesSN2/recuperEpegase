package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ProduitsTarif implements Serializable {
   private long protarId;
   private float protarCoef;
   private String protarClient;
   private String protarLettre;
   private double protarValeur;
   private double protarValeurCnamgs;
   private float protarNb;
   private float protarNbCnamgs;
   private double protarPv;
   private double protarPvCnamgs;
   private String protarCondit;
   private String protarUnite;
   private int protarInactif;
   private String etat;
   private int protarOrdre;
   private boolean inactif;
   private boolean protarExoTva;
   private boolean protarExoDd;
   private float protarTauxTva;
   private double protarPvMarche;
   private double protarPvCc1;
   private double protarPvCc2;
   private double protarPvCc3;
   private Date protarDateMarche;
   private Date protarDateCc1;
   private Date protarDateCc2;
   private Date protarDateCc3;
   private String protarNomCc1;
   private String protarNomCc2;
   private String protarNomCc3;
   private String protarTarifQte;
   private Produits produits;
   private Unite unite = new Unite();
   private String var_lib_uni_condit;

   public String getVar_lib_uni_condit() {
      if (this.protarCondit != null && !this.protarCondit.isEmpty() && this.protarCondit.contains(":")) {
         this.var_lib_uni_condit = this.protarCondit;
      } else if (this.protarCondit != null && !this.protarCondit.isEmpty() && !this.protarCondit.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.protarCondit));
      } else if (this.protarUnite != null && !this.protarUnite.isEmpty()) {
         this.var_lib_uni_condit = this.protarUnite;
      } else {
         this.var_lib_uni_condit = "";
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public String getProtarClient() {
      return this.protarClient;
   }

   public void setProtarClient(String var1) {
      this.protarClient = var1;
   }

   public float getProtarCoef() {
      return this.protarCoef;
   }

   public void setProtarCoef(float var1) {
      this.protarCoef = var1;
   }

   public long getProtarId() {
      return this.protarId;
   }

   public void setProtarId(long var1) {
      this.protarId = var1;
   }

   public String getProtarLettre() {
      return this.protarLettre;
   }

   public void setProtarLettre(String var1) {
      this.protarLettre = var1;
   }

   public float getProtarNb() {
      return this.protarNb;
   }

   public void setProtarNb(float var1) {
      this.protarNb = var1;
   }

   public double getProtarPv() {
      return this.protarPv;
   }

   public void setProtarPv(double var1) {
      this.protarPv = var1;
   }

   public String getEtat() {
      if (this.protarInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.protarInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      if (this.protarInactif != 1 && this.protarInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public int getProtarInactif() {
      return this.protarInactif;
   }

   public void setProtarInactif(int var1) {
      this.protarInactif = var1;
   }

   public int getProtarOrdre() {
      return this.protarOrdre;
   }

   public void setProtarOrdre(int var1) {
      this.protarOrdre = var1;
   }

   public String getProtarCondit() {
      return this.protarCondit;
   }

   public void setProtarCondit(String var1) {
      this.protarCondit = var1;
   }

   public String getProtarUnite() {
      return this.protarUnite;
   }

   public void setProtarUnite(String var1) {
      this.protarUnite = var1;
   }

   public double getProtarValeur() {
      return this.protarValeur;
   }

   public void setProtarValeur(double var1) {
      this.protarValeur = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public boolean isProtarExoDd() {
      return this.protarExoDd;
   }

   public void setProtarExoDd(boolean var1) {
      this.protarExoDd = var1;
   }

   public boolean isProtarExoTva() {
      return this.protarExoTva;
   }

   public void setProtarExoTva(boolean var1) {
      this.protarExoTva = var1;
   }

   public float getProtarTauxTva() {
      return this.protarTauxTva;
   }

   public void setProtarTauxTva(float var1) {
      this.protarTauxTva = var1;
   }

   public double getProtarPvCc1() {
      return this.protarPvCc1;
   }

   public void setProtarPvCc1(double var1) {
      this.protarPvCc1 = var1;
   }

   public double getProtarPvCc2() {
      return this.protarPvCc2;
   }

   public void setProtarPvCc2(double var1) {
      this.protarPvCc2 = var1;
   }

   public double getProtarPvCc3() {
      return this.protarPvCc3;
   }

   public void setProtarPvCc3(double var1) {
      this.protarPvCc3 = var1;
   }

   public double getProtarPvMarche() {
      return this.protarPvMarche;
   }

   public void setProtarPvMarche(double var1) {
      this.protarPvMarche = var1;
   }

   public Date getProtarDateCc1() {
      return this.protarDateCc1;
   }

   public void setProtarDateCc1(Date var1) {
      this.protarDateCc1 = var1;
   }

   public Date getProtarDateCc2() {
      return this.protarDateCc2;
   }

   public void setProtarDateCc2(Date var1) {
      this.protarDateCc2 = var1;
   }

   public Date getProtarDateCc3() {
      return this.protarDateCc3;
   }

   public void setProtarDateCc3(Date var1) {
      this.protarDateCc3 = var1;
   }

   public Date getProtarDateMarche() {
      return this.protarDateMarche;
   }

   public void setProtarDateMarche(Date var1) {
      this.protarDateMarche = var1;
   }

   public String getProtarTarifQte() {
      return this.protarTarifQte;
   }

   public void setProtarTarifQte(String var1) {
      this.protarTarifQte = var1;
   }

   public String getProtarNomCc1() {
      return this.protarNomCc1;
   }

   public void setProtarNomCc1(String var1) {
      this.protarNomCc1 = var1;
   }

   public String getProtarNomCc2() {
      return this.protarNomCc2;
   }

   public void setProtarNomCc2(String var1) {
      this.protarNomCc2 = var1;
   }

   public String getProtarNomCc3() {
      return this.protarNomCc3;
   }

   public void setProtarNomCc3(String var1) {
      this.protarNomCc3 = var1;
   }

   public float getProtarNbCnamgs() {
      return this.protarNbCnamgs;
   }

   public void setProtarNbCnamgs(float var1) {
      this.protarNbCnamgs = var1;
   }

   public double getProtarPvCnamgs() {
      return this.protarPvCnamgs;
   }

   public void setProtarPvCnamgs(double var1) {
      this.protarPvCnamgs = var1;
   }

   public double getProtarValeurCnamgs() {
      return this.protarValeurCnamgs;
   }

   public void setProtarValeurCnamgs(double var1) {
      this.protarValeurCnamgs = var1;
   }
}
