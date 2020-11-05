package com.epegase.systeme.classe;

import java.io.Serializable;

public class PegMedicemmentDci implements Serializable {
   private long meddciId;
   private String meddciDci;
   private String meddciForme;
   private String meddciIndic;
   private String meddciPoso;
   private String meddciCindic;
   private String meddciEffet;
   private int meddciType;
   private int meddciCat;

   public int getMeddciCat() {
      return this.meddciCat;
   }

   public void setMeddciCat(int var1) {
      this.meddciCat = var1;
   }

   public String getMeddciCindic() {
      return this.meddciCindic;
   }

   public void setMeddciCindic(String var1) {
      this.meddciCindic = var1;
   }

   public String getMeddciDci() {
      return this.meddciDci;
   }

   public void setMeddciDci(String var1) {
      this.meddciDci = var1;
   }

   public String getMeddciEffet() {
      return this.meddciEffet;
   }

   public void setMeddciEffet(String var1) {
      this.meddciEffet = var1;
   }

   public String getMeddciForme() {
      return this.meddciForme;
   }

   public void setMeddciForme(String var1) {
      this.meddciForme = var1;
   }

   public long getMeddciId() {
      return this.meddciId;
   }

   public void setMeddciId(long var1) {
      this.meddciId = var1;
   }

   public String getMeddciIndic() {
      return this.meddciIndic;
   }

   public void setMeddciIndic(String var1) {
      this.meddciIndic = var1;
   }

   public String getMeddciPoso() {
      return this.meddciPoso;
   }

   public void setMeddciPoso(String var1) {
      this.meddciPoso = var1;
   }

   public int getMeddciType() {
      return this.meddciType;
   }

   public void setMeddciType(int var1) {
      this.meddciType = var1;
   }
}
