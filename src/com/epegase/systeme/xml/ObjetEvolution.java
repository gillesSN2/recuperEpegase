package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetEvolution implements Serializable {
   private String version;
   private String date;
   private String type;
   private String module;
   private String ecran;
   private String objet;
   private String detail;
   private String developpeur;

   public String getDate() {
      return this.date;
   }

   public void setDate(String var1) {
      this.date = var1;
   }

   public String getDetail() {
      return this.detail;
   }

   public void setDetail(String var1) {
      this.detail = var1;
   }

   public String getDeveloppeur() {
      return this.developpeur;
   }

   public void setDeveloppeur(String var1) {
      this.developpeur = var1;
   }

   public String getEcran() {
      return this.ecran;
   }

   public void setEcran(String var1) {
      this.ecran = var1;
   }

   public String getModule() {
      return this.module;
   }

   public void setModule(String var1) {
      this.module = var1;
   }

   public String getObjet() {
      return this.objet;
   }

   public void setObjet(String var1) {
      this.objet = var1;
   }

   public String getType() {
      return this.type;
   }

   public void setType(String var1) {
      this.type = var1;
   }

   public String getVersion() {
      return this.version;
   }

   public void setVersion(String var1) {
      this.version = var1;
   }
}
