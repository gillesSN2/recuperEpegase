package com.epegase.systeme.xml;

import java.io.Serializable;
import java.util.Date;

public class ObjetCompte implements Serializable {
   private Integer indice;
   private String code;
   private String nom_FR;
   private String nom_UK;
   private String nom_SP;
   private String sens;
   private String type;
   private boolean valide;
   private boolean valideLocation;
   private boolean valideSyndic;
   private boolean valideNegoce;
   private boolean validePromoteur;
   private Integer numAxe;
   private long centreId;
   private String centreAdresse;
   private String centreBP;
   private String centreVille;
   private String centreTel1;
   private String centreTel2;
   private String centreFax;
   private String centreMail;
   private String centreNomResponsable;
   private String centreNumeroImmatriculation;
   private boolean demande;
   private boolean effectue;
   private String lot;
   private Date datePeremption;
   private String style;

   public String getStyle() {
      if (!this.code.equals("0") && !this.code.equals("83") && !this.code.equals("84") && !this.code.equals("85") && !this.code.equals("86")) {
         this.style = "";
         this.demande = true;
      } else {
         this.style = "font-weight:bold;text-align:center";
         this.demande = false;
      }

      return this.style;
   }

   public void setStyle(String var1) {
      this.style = var1;
   }

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public Integer getIndice() {
      return this.indice;
   }

   public void setIndice(Integer var1) {
      this.indice = var1;
   }

   public String getNom_FR() {
      return this.nom_FR;
   }

   public void setNom_FR(String var1) {
      this.nom_FR = var1;
   }

   public String getNom_SP() {
      return this.nom_SP;
   }

   public void setNom_SP(String var1) {
      this.nom_SP = var1;
   }

   public String getNom_UK() {
      return this.nom_UK;
   }

   public void setNom_UK(String var1) {
      this.nom_UK = var1;
   }

   public String getSens() {
      return this.sens;
   }

   public void setSens(String var1) {
      this.sens = var1;
   }

   public boolean isValide() {
      return this.valide;
   }

   public void setValide(boolean var1) {
      this.valide = var1;
   }

   public String getType() {
      return this.type;
   }

   public void setType(String var1) {
      this.type = var1;
   }

   public boolean isValideLocation() {
      return this.valideLocation;
   }

   public void setValideLocation(boolean var1) {
      this.valideLocation = var1;
   }

   public boolean isValideNegoce() {
      return this.valideNegoce;
   }

   public void setValideNegoce(boolean var1) {
      this.valideNegoce = var1;
   }

   public boolean isValideSyndic() {
      return this.valideSyndic;
   }

   public void setValideSyndic(boolean var1) {
      this.valideSyndic = var1;
   }

   public String getCentreAdresse() {
      return this.centreAdresse;
   }

   public void setCentreAdresse(String var1) {
      this.centreAdresse = var1;
   }

   public String getCentreBP() {
      return this.centreBP;
   }

   public void setCentreBP(String var1) {
      this.centreBP = var1;
   }

   public String getCentreFax() {
      return this.centreFax;
   }

   public void setCentreFax(String var1) {
      this.centreFax = var1;
   }

   public long getCentreId() {
      return this.centreId;
   }

   public void setCentreId(long var1) {
      this.centreId = var1;
   }

   public String getCentreMail() {
      return this.centreMail;
   }

   public void setCentreMail(String var1) {
      this.centreMail = var1;
   }

   public String getCentreNomResponsable() {
      return this.centreNomResponsable;
   }

   public void setCentreNomResponsable(String var1) {
      this.centreNomResponsable = var1;
   }

   public String getCentreNumeroImmatriculation() {
      return this.centreNumeroImmatriculation;
   }

   public void setCentreNumeroImmatriculation(String var1) {
      this.centreNumeroImmatriculation = var1;
   }

   public String getCentreTel1() {
      return this.centreTel1;
   }

   public void setCentreTel1(String var1) {
      this.centreTel1 = var1;
   }

   public String getCentreTel2() {
      return this.centreTel2;
   }

   public void setCentreTel2(String var1) {
      this.centreTel2 = var1;
   }

   public boolean isDemande() {
      return this.demande;
   }

   public void setDemande(boolean var1) {
      this.demande = var1;
   }

   public boolean isEffectue() {
      return this.effectue;
   }

   public void setEffectue(boolean var1) {
      this.effectue = var1;
   }

   public String getLot() {
      return this.lot;
   }

   public void setLot(String var1) {
      this.lot = var1;
   }

   public Date getDatePeremption() {
      return this.datePeremption;
   }

   public void setDatePeremption(Date var1) {
      this.datePeremption = var1;
   }

   public String getCentreVille() {
      return this.centreVille;
   }

   public void setCentreVille(String var1) {
      this.centreVille = var1;
   }

   public Integer getNumAxe() {
      return this.numAxe;
   }

   public void setNumAxe(Integer var1) {
      this.numAxe = var1;
   }

   public boolean isValidePromoteur() {
      return this.validePromoteur;
   }

   public void setValidePromoteur(boolean var1) {
      this.validePromoteur = var1;
   }
}
