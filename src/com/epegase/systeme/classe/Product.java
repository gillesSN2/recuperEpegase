package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
   private long productId;
   private long vendorId;
   private long productParentId;
   private String productSku;
   private String productSDesc;
   private String productDesc;
   private String productThumbImage;
   private String productFullImage;
   private String productPublish;
   private float productWeight;
   private String productWeightUom;
   private float productLength;
   private float productWidth;
   private float productHeight;
   private float productLwhUom;
   private String productUrl;
   private int productInStock;
   private Date productAvailableDate;
   private String productAvailability;
   private String productSpecial;
   private long productDiscountId;
   private int shipCodeId;
   private int cdate;
   private int mdate;
   private String productName;
   private int productSales;
   private String attribute;
   private String customAttribute;
   private long productTaxId;
   private String productUnit;
   private int productPackaging;
   private String childOptions;
   private String quantityOptions;
   private String childOptionIds;
   private String productOrderLevels;

   public String getAttribute() {
      return this.attribute;
   }

   public void setAttribute(String var1) {
      this.attribute = var1;
   }

   public int getCdate() {
      return this.cdate;
   }

   public void setCdate(int var1) {
      this.cdate = var1;
   }

   public String getChildOptionIds() {
      return this.childOptionIds;
   }

   public void setChildOptionIds(String var1) {
      this.childOptionIds = var1;
   }

   public String getChildOptions() {
      return this.childOptions;
   }

   public void setChildOptions(String var1) {
      this.childOptions = var1;
   }

   public String getCustomAttribute() {
      return this.customAttribute;
   }

   public void setCustomAttribute(String var1) {
      this.customAttribute = var1;
   }

   public int getMdate() {
      return this.mdate;
   }

   public void setMdate(int var1) {
      this.mdate = var1;
   }

   public String getProductAvailability() {
      return this.productAvailability;
   }

   public void setProductAvailability(String var1) {
      this.productAvailability = var1;
   }

   public Date getProductAvailableDate() {
      return this.productAvailableDate;
   }

   public void setProductAvailableDate(Date var1) {
      this.productAvailableDate = var1;
   }

   public String getProductDesc() {
      return this.productDesc;
   }

   public void setProductDesc(String var1) {
      this.productDesc = var1;
   }

   public long getProductDiscountId() {
      return this.productDiscountId;
   }

   public void setProductDiscountId(long var1) {
      this.productDiscountId = var1;
   }

   public String getProductFullImage() {
      return this.productFullImage;
   }

   public void setProductFullImage(String var1) {
      this.productFullImage = var1;
   }

   public float getProductHeight() {
      return this.productHeight;
   }

   public void setProductHeight(float var1) {
      this.productHeight = var1;
   }

   public long getProductId() {
      return this.productId;
   }

   public void setProductId(long var1) {
      this.productId = var1;
   }

   public int getProductInStock() {
      return this.productInStock;
   }

   public void setProductInStock(int var1) {
      this.productInStock = var1;
   }

   public float getProductLength() {
      return this.productLength;
   }

   public void setProductLength(float var1) {
      this.productLength = var1;
   }

   public float getProductLwhUom() {
      return this.productLwhUom;
   }

   public void setProductLwhUom(float var1) {
      this.productLwhUom = var1;
   }

   public String getProductName() {
      return this.productName;
   }

   public void setProductName(String var1) {
      this.productName = var1;
   }

   public String getProductOrderLevels() {
      return this.productOrderLevels;
   }

   public void setProductOrderLevels(String var1) {
      this.productOrderLevels = var1;
   }

   public int getProductPackaging() {
      return this.productPackaging;
   }

   public void setProductPackaging(int var1) {
      this.productPackaging = var1;
   }

   public long getProductParentId() {
      return this.productParentId;
   }

   public void setProductParentId(long var1) {
      this.productParentId = var1;
   }

   public String getProductPublish() {
      return this.productPublish;
   }

   public void setProductPublish(String var1) {
      this.productPublish = var1;
   }

   public String getProductSDesc() {
      return this.productSDesc;
   }

   public void setProductSDesc(String var1) {
      this.productSDesc = var1;
   }

   public int getProductSales() {
      return this.productSales;
   }

   public void setProductSales(int var1) {
      this.productSales = var1;
   }

   public String getProductSku() {
      return this.productSku;
   }

   public void setProductSku(String var1) {
      this.productSku = var1;
   }

   public String getProductSpecial() {
      return this.productSpecial;
   }

   public void setProductSpecial(String var1) {
      this.productSpecial = var1;
   }

   public long getProductTaxId() {
      return this.productTaxId;
   }

   public void setProductTaxId(long var1) {
      this.productTaxId = var1;
   }

   public String getProductThumbImage() {
      return this.productThumbImage;
   }

   public void setProductThumbImage(String var1) {
      this.productThumbImage = var1;
   }

   public String getProductUnit() {
      return this.productUnit;
   }

   public void setProductUnit(String var1) {
      this.productUnit = var1;
   }

   public String getProductUrl() {
      return this.productUrl;
   }

   public void setProductUrl(String var1) {
      this.productUrl = var1;
   }

   public float getProductWeight() {
      return this.productWeight;
   }

   public void setProductWeight(float var1) {
      this.productWeight = var1;
   }

   public String getProductWeightUom() {
      return this.productWeightUom;
   }

   public void setProductWeightUom(String var1) {
      this.productWeightUom = var1;
   }

   public float getProductWidth() {
      return this.productWidth;
   }

   public void setProductWidth(float var1) {
      this.productWidth = var1;
   }

   public String getQuantityOptions() {
      return this.quantityOptions;
   }

   public void setQuantityOptions(String var1) {
      this.quantityOptions = var1;
   }

   public int getShipCodeId() {
      return this.shipCodeId;
   }

   public void setShipCodeId(int var1) {
      this.shipCodeId = var1;
   }

   public long getVendorId() {
      return this.vendorId;
   }

   public void setVendorId(long var1) {
      this.vendorId = var1;
   }
}
