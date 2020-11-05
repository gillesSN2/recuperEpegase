package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetSites implements Serializable {
   private String nom;
   private String url;

   public String getNom() {
      return this.nom;
   }

   public void setNom(String var1) {
      this.nom = var1;
   }

   public String getUrl() {
      return this.url;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }
}
