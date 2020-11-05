package com.epegase.systeme.fileUtil;

public class OwnerFile {
   private String Name;
   private String mime;
   private long length;
   private byte[] data;

   public byte[] getData() {
      return this.data;
   }

   public void setData(byte[] var1) {
      this.data = var1;
   }

   public String getName() {
      return this.Name;
   }

   public void setName(String var1) {
      this.Name = var1;
      int var2 = var1.lastIndexOf(46);
      if (var2 > 0) {
         String var3 = var1.substring(var2 + 1);
         if ("bmp".equals(var3)) {
            this.mime = "image/bmp";
         } else if ("jpg".equals(var3)) {
            this.mime = "image/jpeg";
         } else if ("gif".equals(var3)) {
            this.mime = "image/gif";
         } else if ("pdf".equals(var3)) {
            this.mime = "image/pdf";
         } else if ("doc".equals(var3)) {
            this.mime = "image/doc";
         } else if ("xls".equals(var3)) {
            this.mime = "image/xls";
         } else if ("png".equals(var3)) {
            this.mime = "image/png";
         } else {
            this.mime = "image/unknown";
         }
      }

   }

   public long getLength() {
      return this.length;
   }

   public void setLength(long var1) {
      this.length = var1;
   }

   public String getMime() {
      return this.mime;
   }
}
