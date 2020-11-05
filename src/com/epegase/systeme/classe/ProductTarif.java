package com.epegase.systeme.classe;

import java.io.Serializable;

public class ProductTarif implements Serializable {
   private long productPriceId;
   private double productPrice;
   private String productCurrency;
   private int productPriceVdate;
   private int productPriceEdate;
   private int cdate;
   private int mdate;
   private long shopperGroupId;
   private int priceQuantityStart;
   private int priceQuantityEnd;
   private Product product;

   public int getCdate() {
      return this.cdate;
   }

   public void setCdate(int var1) {
      this.cdate = var1;
   }

   public int getMdate() {
      return this.mdate;
   }

   public void setMdate(int var1) {
      this.mdate = var1;
   }

   public int getPriceQuantityEnd() {
      return this.priceQuantityEnd;
   }

   public void setPriceQuantityEnd(int var1) {
      this.priceQuantityEnd = var1;
   }

   public int getPriceQuantityStart() {
      return this.priceQuantityStart;
   }

   public void setPriceQuantityStart(int var1) {
      this.priceQuantityStart = var1;
   }

   public Product getProduct() {
      return this.product;
   }

   public void setProduct(Product var1) {
      this.product = var1;
   }

   public String getProductCurrency() {
      return this.productCurrency;
   }

   public void setProductCurrency(String var1) {
      this.productCurrency = var1;
   }

   public double getProductPrice() {
      return this.productPrice;
   }

   public void setProductPrice(double var1) {
      this.productPrice = var1;
   }

   public int getProductPriceEdate() {
      return this.productPriceEdate;
   }

   public void setProductPriceEdate(int var1) {
      this.productPriceEdate = var1;
   }

   public long getProductPriceId() {
      return this.productPriceId;
   }

   public void setProductPriceId(long var1) {
      this.productPriceId = var1;
   }

   public int getProductPriceVdate() {
      return this.productPriceVdate;
   }

   public void setProductPriceVdate(int var1) {
      this.productPriceVdate = var1;
   }

   public long getShopperGroupId() {
      return this.shopperGroupId;
   }

   public void setShopperGroupId(long var1) {
      this.shopperGroupId = var1;
   }
}
