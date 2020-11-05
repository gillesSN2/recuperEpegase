package com.epegase.systeme.classe;

import java.io.Serializable;

public class GroupeFavoris implements Serializable {
   private long grpfavId;
   private int grpfavNature;
   private String grpfavRepertoire;
   private boolean grpfavAcces;
   private boolean grpfavAjout;
   private boolean grpfavModif;
   private boolean grpfavSupp;
   private Groupe groupe;

   public Groupe getGroupe() {
      return this.groupe;
   }

   public void setGroupe(Groupe var1) {
      this.groupe = var1;
   }

   public int getGrpfavNature() {
      return this.grpfavNature;
   }

   public void setGrpfavNature(int var1) {
      this.grpfavNature = var1;
   }

   public long getGrpfavId() {
      return this.grpfavId;
   }

   public void setGrpfavId(long var1) {
      this.grpfavId = var1;
   }

   public String getGrpfavRepertoire() {
      return this.grpfavRepertoire;
   }

   public void setGrpfavRepertoire(String var1) {
      this.grpfavRepertoire = var1;
   }

   public boolean isGrpfavAjout() {
      return this.grpfavAjout;
   }

   public void setGrpfavAjout(boolean var1) {
      this.grpfavAjout = var1;
   }

   public boolean isGrpfavModif() {
      return this.grpfavModif;
   }

   public void setGrpfavModif(boolean var1) {
      this.grpfavModif = var1;
   }

   public boolean isGrpfavSupp() {
      return this.grpfavSupp;
   }

   public void setGrpfavSupp(boolean var1) {
      this.grpfavSupp = var1;
   }

   public boolean isGrpfavAcces() {
      return this.grpfavAcces;
   }

   public void setGrpfavAcces(boolean var1) {
      this.grpfavAcces = var1;
   }
}
