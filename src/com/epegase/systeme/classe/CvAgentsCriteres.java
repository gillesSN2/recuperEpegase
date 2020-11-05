package com.epegase.systeme.classe;

import java.io.Serializable;

public class CvAgentsCriteres implements Serializable {
   private long cvacId;
   private String cvacCritere;
   private int cvacPoints;
   private boolean cvacSelect;
   private CvSession cvSession;
   private CvAgents cvAgents;

   public CvSession getCvSession() {
      return this.cvSession;
   }

   public void setCvSession(CvSession var1) {
      this.cvSession = var1;
   }

   public CvAgents getCvAgents() {
      return this.cvAgents;
   }

   public void setCvAgents(CvAgents var1) {
      this.cvAgents = var1;
   }

   public String getCvacCritere() {
      return this.cvacCritere;
   }

   public void setCvacCritere(String var1) {
      this.cvacCritere = var1;
   }

   public long getCvacId() {
      return this.cvacId;
   }

   public void setCvacId(long var1) {
      this.cvacId = var1;
   }

   public int getCvacPoints() {
      return this.cvacPoints;
   }

   public void setCvacPoints(int var1) {
      this.cvacPoints = var1;
   }

   public boolean isCvacSelect() {
      return this.cvacSelect;
   }

   public void setCvacSelect(boolean var1) {
      this.cvacSelect = var1;
   }
}
