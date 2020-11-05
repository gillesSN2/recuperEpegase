package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetLigneOnglet implements Serializable {
   private int indice;
   private String libelle;
   private String code;
   private boolean acc;
   private boolean add;
   private boolean maj;
   private boolean sup;
   private boolean imp;

   public boolean isAcc() {
      return this.acc;
   }

   public void setAcc(boolean var1) {
      this.acc = var1;
   }

   public boolean isAdd() {
      return this.add;
   }

   public void setAdd(boolean var1) {
      this.add = var1;
   }

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public boolean isImp() {
      return this.imp;
   }

   public void setImp(boolean var1) {
      this.imp = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }

   public boolean isMaj() {
      return this.maj;
   }

   public void setMaj(boolean var1) {
      this.maj = var1;
   }

   public boolean isSup() {
      return this.sup;
   }

   public void setSup(boolean var1) {
      this.sup = var1;
   }
}
