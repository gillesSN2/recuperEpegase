package com.epegase.systeme.classe;

import java.io.Serializable;

public class NoteDebitLigneAchats implements Serializable {
   private long ndfligId;
   private String ndfligCode;
   private String ndfligFamille;
   private String ndfligLibelle;
   private String ndfligLibelleFournisseur;
   private String ndfligComplement;
   private String ndfligReference;
   private String ndfligTaxe;
   private float ndfligTauxTaxe;
   private String ndfligUnite;
   private String ndfligCondition;
   private String ndfligDescription;
   private float ndfligQte;
   private int ndfligEchelle;
   private float ndfligLong;
   private float ndfligLarg;
   private float ndfligHaut;
   private float ndfligDiam;
   private float ndfligNb;
   private float ndfligPoidsNet;
   private float ndfligPoidsBrut;
   private float ndfligVolume;
   private float ndfligQteUtil;
   private String ndfligDevise;
   private double ndfligPu;
   private double ndfligPr;
   private float ndfligTauxRemise;
   private double ndfligRabais;
   private double ndfligPuRem;
   private double ndfligPt;
   private double ndfligTva;
   private double ndfligTc;
   private double ndfligTtc;
   private double ndfligPump;
   private NoteDebitEnteteAchats noteDebitEnteteAchats;
   private float var_qteDejaTrf;
   private float var_qteReliquat;
   private String var_lib_uni_condit;

   public String getVar_lib_uni_condit() {
      if (this.ndfligCondition != null && !this.ndfligCondition.isEmpty() && this.ndfligCondition.contains(":")) {
         if (this.ndfligDescription != null && !this.ndfligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.ndfligDescription;
         } else if (this.ndfligCondition.contains("/")) {
            String[] var1 = this.ndfligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.ndfligCondition;
         }
      } else if (this.ndfligCondition == null || this.ndfligCondition.isEmpty() || this.ndfligCondition.contains(":")) {
         if (this.ndfligUnite != null && !this.ndfligUnite.isEmpty()) {
            this.var_lib_uni_condit = this.ndfligUnite;
         } else {
            this.var_lib_uni_condit = "";
         }
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public String getNdfligCode() {
      return this.ndfligCode;
   }

   public void setNdfligCode(String var1) {
      this.ndfligCode = var1;
   }

   public String getNdfligDevise() {
      return this.ndfligDevise;
   }

   public void setNdfligDevise(String var1) {
      this.ndfligDevise = var1;
   }

   public String getNdfligFamille() {
      return this.ndfligFamille;
   }

   public void setNdfligFamille(String var1) {
      this.ndfligFamille = var1;
   }

   public long getNdfligId() {
      return this.ndfligId;
   }

   public void setNdfligId(long var1) {
      this.ndfligId = var1;
   }

   public String getNdfligLibelle() {
      return this.ndfligLibelle;
   }

   public void setNdfligLibelle(String var1) {
      this.ndfligLibelle = var1;
   }

   public double getNdfligPt() {
      return this.ndfligPt;
   }

   public void setNdfligPt(double var1) {
      this.ndfligPt = var1;
   }

   public double getNdfligPu() {
      return this.ndfligPu;
   }

   public void setNdfligPu(double var1) {
      this.ndfligPu = var1;
   }

   public double getNdfligPuRem() {
      return this.ndfligPuRem;
   }

   public void setNdfligPuRem(double var1) {
      this.ndfligPuRem = var1;
   }

   public float getNdfligQte() {
      return this.ndfligQte;
   }

   public void setNdfligQte(float var1) {
      this.ndfligQte = var1;
   }

   public double getNdfligRabais() {
      return this.ndfligRabais;
   }

   public void setNdfligRabais(double var1) {
      this.ndfligRabais = var1;
   }

   public String getNdfligReference() {
      return this.ndfligReference;
   }

   public void setNdfligReference(String var1) {
      this.ndfligReference = var1;
   }

   public float getNdfligTauxRemise() {
      return this.ndfligTauxRemise;
   }

   public void setNdfligTauxRemise(float var1) {
      this.ndfligTauxRemise = var1;
   }

   public float getNdfligTauxTaxe() {
      return this.ndfligTauxTaxe;
   }

   public void setNdfligTauxTaxe(float var1) {
      this.ndfligTauxTaxe = var1;
   }

   public String getNdfligTaxe() {
      return this.ndfligTaxe;
   }

   public void setNdfligTaxe(String var1) {
      this.ndfligTaxe = var1;
   }

   public double getNdfligTc() {
      return this.ndfligTc;
   }

   public void setNdfligTc(double var1) {
      this.ndfligTc = var1;
   }

   public double getNdfligTtc() {
      return this.ndfligTtc;
   }

   public void setNdfligTtc(double var1) {
      this.ndfligTtc = var1;
   }

   public double getNdfligTva() {
      return this.ndfligTva;
   }

   public void setNdfligTva(double var1) {
      this.ndfligTva = var1;
   }

   public String getNdfligUnite() {
      return this.ndfligUnite;
   }

   public void setNdfligUnite(String var1) {
      this.ndfligUnite = var1;
   }

   public NoteDebitEnteteAchats getNoteDebitEnteteAchats() {
      return this.noteDebitEnteteAchats;
   }

   public void setNoteDebitEnteteAchats(NoteDebitEnteteAchats var1) {
      this.noteDebitEnteteAchats = var1;
   }

   public double getNdfligPump() {
      return this.ndfligPump;
   }

   public void setNdfligPump(double var1) {
      this.ndfligPump = var1;
   }

   public String getNdfligCondition() {
      return this.ndfligCondition;
   }

   public void setNdfligCondition(String var1) {
      this.ndfligCondition = var1;
   }

   public float getNdfligDiam() {
      return this.ndfligDiam;
   }

   public void setNdfligDiam(float var1) {
      this.ndfligDiam = var1;
   }

   public float getNdfligHaut() {
      return this.ndfligHaut;
   }

   public void setNdfligHaut(float var1) {
      this.ndfligHaut = var1;
   }

   public float getNdfligLarg() {
      return this.ndfligLarg;
   }

   public void setNdfligLarg(float var1) {
      this.ndfligLarg = var1;
   }

   public float getNdfligLong() {
      return this.ndfligLong;
   }

   public void setNdfligLong(float var1) {
      this.ndfligLong = var1;
   }

   public float getNdfligNb() {
      return this.ndfligNb;
   }

   public void setNdfligNb(float var1) {
      this.ndfligNb = var1;
   }

   public float getNdfligQteUtil() {
      return this.ndfligQteUtil;
   }

   public void setNdfligQteUtil(float var1) {
      this.ndfligQteUtil = var1;
   }

   public float getNdfligPoidsBrut() {
      return this.ndfligPoidsBrut;
   }

   public void setNdfligPoidsBrut(float var1) {
      this.ndfligPoidsBrut = var1;
   }

   public float getNdfligPoidsNet() {
      return this.ndfligPoidsNet;
   }

   public void setNdfligPoidsNet(float var1) {
      this.ndfligPoidsNet = var1;
   }

   public float getNdfligVolume() {
      return this.ndfligVolume;
   }

   public void setNdfligVolume(float var1) {
      this.ndfligVolume = var1;
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

   public int getNdfligEchelle() {
      return this.ndfligEchelle;
   }

   public void setNdfligEchelle(int var1) {
      this.ndfligEchelle = var1;
   }

   public String getNdfligDescription() {
      return this.ndfligDescription;
   }

   public void setNdfligDescription(String var1) {
      this.ndfligDescription = var1;
   }

   public String getNdfligComplement() {
      return this.ndfligComplement;
   }

   public void setNdfligComplement(String var1) {
      this.ndfligComplement = var1;
   }

   public double getNdfligPr() {
      return this.ndfligPr;
   }

   public void setNdfligPr(double var1) {
      this.ndfligPr = var1;
   }

   public String getNdfligLibelleFournisseur() {
      return this.ndfligLibelleFournisseur;
   }

   public void setNdfligLibelleFournisseur(String var1) {
      this.ndfligLibelleFournisseur = var1;
   }
}
