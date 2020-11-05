package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ProduitsDci implements Serializable {
   private long prodciId;
   private Date prodciDateCreation;
   private Date prodciDateModif;
   private long prodciUserCreation;
   private long prodciUserModif;
   private String prodciCode;
   private String prodciForme;
   private String prodciIndication;
   private String prodciPosologie;
   private String prodciContreIndic;
   private String prodciEffetSecond;
   private int prodciType;
   private int prodciCat;

   public String getProdciForme() {
      return this.prodciForme;
   }

   public void setProdciForme(String var1) {
      this.prodciForme = var1;
   }

   public String getProdciCode() {
      return this.prodciCode;
   }

   public void setProdciCode(String var1) {
      this.prodciCode = var1;
   }

   public String getProdciContreIndic() {
      return this.prodciContreIndic;
   }

   public void setProdciContreIndic(String var1) {
      this.prodciContreIndic = var1;
   }

   public Date getProdciDateCreation() {
      return this.prodciDateCreation;
   }

   public void setProdciDateCreation(Date var1) {
      this.prodciDateCreation = var1;
   }

   public Date getProdciDateModif() {
      return this.prodciDateModif;
   }

   public void setProdciDateModif(Date var1) {
      this.prodciDateModif = var1;
   }

   public String getProdciEffetSecond() {
      return this.prodciEffetSecond;
   }

   public void setProdciEffetSecond(String var1) {
      this.prodciEffetSecond = var1;
   }

   public long getProdciId() {
      return this.prodciId;
   }

   public void setProdciId(long var1) {
      this.prodciId = var1;
   }

   public String getProdciIndication() {
      return this.prodciIndication;
   }

   public void setProdciIndication(String var1) {
      this.prodciIndication = var1;
   }

   public String getProdciPosologie() {
      return this.prodciPosologie;
   }

   public void setProdciPosologie(String var1) {
      this.prodciPosologie = var1;
   }

   public int getProdciType() {
      return this.prodciType;
   }

   public void setProdciType(int var1) {
      this.prodciType = var1;
   }

   public long getProdciUserCreation() {
      return this.prodciUserCreation;
   }

   public void setProdciUserCreation(long var1) {
      this.prodciUserCreation = var1;
   }

   public long getProdciUserModif() {
      return this.prodciUserModif;
   }

   public void setProdciUserModif(long var1) {
      this.prodciUserModif = var1;
   }

   public int getProdciCat() {
      return this.prodciCat;
   }

   public void setProdciCat(int var1) {
      this.prodciCat = var1;
   }
}
