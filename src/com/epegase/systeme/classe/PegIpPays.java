package com.epegase.systeme.classe;

import java.io.Serializable;

public class PegIpPays implements Serializable {
   private long ipId;
   private String ipIso;
   private String ipPays;
   private long ipDebut;
   private long ipFin;

   public long getIpDebut() {
      return this.ipDebut;
   }

   public void setIpDebut(long var1) {
      this.ipDebut = var1;
   }

   public long getIpFin() {
      return this.ipFin;
   }

   public void setIpFin(long var1) {
      this.ipFin = var1;
   }

   public long getIpId() {
      return this.ipId;
   }

   public void setIpId(long var1) {
      this.ipId = var1;
   }

   public String getIpIso() {
      return this.ipIso;
   }

   public void setIpIso(String var1) {
      this.ipIso = var1;
   }

   public String getIpPays() {
      return this.ipPays;
   }

   public void setIpPays(String var1) {
      this.ipPays = var1;
   }
}
