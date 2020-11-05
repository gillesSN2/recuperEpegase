package com.epegase.systeme.classe;

import java.io.Serializable;

public class CvCriteres implements Serializable {
   private long cvcId;
   private String cvcCritere;
   private int cvcPoints;
   private CvSession cvSession;

   public CvSession getCvSession() {
      return this.cvSession;
   }

   public void setCvSession(CvSession var1) {
      this.cvSession = var1;
   }

   public String getCvcCritere() {
      return this.cvcCritere;
   }

   public void setCvcCritere(String var1) {
      this.cvcCritere = var1;
   }

   public long getCvcId() {
      return this.cvcId;
   }

   public void setCvcId(long var1) {
      this.cvcId = var1;
   }

   public int getCvcPoints() {
      return this.cvcPoints;
   }

   public void setCvcPoints(int var1) {
      this.cvcPoints = var1;
   }
}
