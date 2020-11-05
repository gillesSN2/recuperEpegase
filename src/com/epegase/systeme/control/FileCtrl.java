package com.epegase.systeme.control;

import java.io.Serializable;

public class FileCtrl implements Serializable {
   public static String separator;
   private String Name;
   private String mime;
   private String chemin;
   private int length;
   private byte[] data;
   private int typeFichier;

   public FileCtrl(String var1) {
      this.data = new byte[this.length];
   }

   public FileCtrl() {
      this.data = new byte[this.length];
   }

   public int getTypeFichier() {
      return this.typeFichier;
   }

   public void setTypeFichier(int var1) {
      this.typeFichier = var1;
   }

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
   }

   public int getLength() {
      return this.length;
   }

   public void setLength(int var1) {
      this.length = var1;
   }

   public String getMime() {
      int var1 = this.Name.lastIndexOf(46);
      if (var1 > 0) {
         if (this.Name.endsWith(".pdf")) {
            this.mime = "application/pdf";
         } else if (this.Name.endsWith(".rtf")) {
            this.mime = "application/rtf";
         } else if (this.Name.endsWith(".html")) {
            this.mime = "application/html";
         } else if (this.Name.endsWith(".doc")) {
            this.mime = "application/doc";
         } else if (this.Name.endsWith(".docx")) {
            this.mime = "application/msword";
         } else if (this.Name.endsWith(".odt")) {
            this.mime = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
         } else if (!this.Name.endsWith(".xls") && !this.Name.endsWith(".xlsx")) {
            if (this.Name.endsWith(".ods")) {
               this.mime = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            } else if (!this.Name.endsWith(".ppt") && !this.Name.endsWith(".pptx")) {
               if (this.Name.endsWith(".odp")) {
                  this.mime = "application/powerpoint";
               } else if (!this.Name.endsWith(".txt") && !this.Name.endsWith(".sql") && !this.Name.endsWith(".log")) {
                  if (!this.Name.endsWith(".zip") && !this.Name.endsWith(".rar")) {
                     if (!this.Name.endsWith(".mp3") && !this.Name.endsWith(".mp4")) {
                        if (this.Name.endsWith(".lnk")) {
                           this.mime = "application/html";
                        } else {
                           this.mime = "application/octet-stream";
                        }
                     } else {
                        this.mime = "application/octet-stream";
                     }
                  } else {
                     this.mime = "application/octet-stream";
                  }
               } else {
                  this.mime = "text/plain";
               }
            } else {
               this.mime = "application/vnd.ms-powerpoint";
            }
         } else {
            this.mime = "application/vnd.ms-excel";
         }
      }

      return this.mime;
   }

   public void setMime(String var1) {
      this.mime = var1;
   }

   public String getChemin() {
      return this.chemin;
   }

   public void setChemin(String var1) {
      this.chemin = var1;
   }
}
