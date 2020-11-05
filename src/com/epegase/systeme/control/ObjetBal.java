package com.epegase.systeme.control;

import java.io.Serializable;

public class ObjetBal implements Serializable {
   private boolean ligneSelect;
   private String lignePatronyme;
   private String ligneMail;

   public String getLigneMail() {
      return this.ligneMail;
   }

   public void setLigneMail(String var1) {
      this.ligneMail = var1;
   }

   public String getLignePatronyme() {
      return this.lignePatronyme;
   }

   public void setLignePatronyme(String var1) {
      this.lignePatronyme = var1;
   }

   public boolean isLigneSelect() {
      return this.ligneSelect;
   }

   public void setLigneSelect(boolean var1) {
      this.ligneSelect = var1;
   }
}
