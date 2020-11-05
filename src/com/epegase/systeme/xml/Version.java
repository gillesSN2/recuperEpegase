package com.epegase.systeme.xml;

import java.io.Serializable;

public class Version implements Serializable {
   private String version_numero;
   private String version_date;
   private String version_internet;
   private String version_os;
   private String version_base;
   private String version_serveur;
   private String version_imageStartup;
   private String version_pageStartup;

   public String getVersion_base() {
      return this.version_base;
   }

   public void setVersion_base(String var1) {
      this.version_base = var1;
   }

   public String getVersion_date() {
      return this.version_date;
   }

   public void setVersion_date(String var1) {
      this.version_date = var1;
   }

   public String getVersion_imageStartup() {
      return this.version_imageStartup;
   }

   public void setVersion_imageStartup(String var1) {
      this.version_imageStartup = var1;
   }

   public String getVersion_internet() {
      return this.version_internet;
   }

   public void setVersion_internet(String var1) {
      this.version_internet = var1;
   }

   public String getVersion_numero() {
      return this.version_numero;
   }

   public void setVersion_numero(String var1) {
      this.version_numero = var1;
   }

   public String getVersion_os() {
      return this.version_os;
   }

   public void setVersion_os(String var1) {
      this.version_os = var1;
   }

   public String getVersion_serveur() {
      return this.version_serveur;
   }

   public void setVersion_serveur(String var1) {
      this.version_serveur = var1;
   }

   public String getVersion_pageStartup() {
      return this.version_pageStartup;
   }

   public void setVersion_pageStartup(String var1) {
      this.version_pageStartup = var1;
   }
}
