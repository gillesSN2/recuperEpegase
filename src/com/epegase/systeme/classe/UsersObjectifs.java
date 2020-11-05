package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class UsersObjectifs implements Serializable {
   private long usrobjId;
   private Date usrobjDateCreat;
   private Date usrobjDateModif;
   private long usrobjUserCreat;
   private long usrobjUserModif;
   private Integer usrobjNature;
   private String usrobjAnnee;
   private double usrobjCaTotal;
   private double usrobjCa01;
   private double usrobjCa02;
   private double usrobjCa03;
   private double usrobjCa04;
   private double usrobjCa05;
   private double usrobjCa06;
   private double usrobjCa07;
   private double usrobjCa08;
   private double usrobjCa09;
   private double usrobjCa10;
   private double usrobjCa11;
   private double usrobjCa12;
   private Users users;
   private String libelleNature;

   public String getLibelleNature() {
      if (this.usrobjNature == 21) {
         this.libelleNature = "CA Devis";
      } else if (this.usrobjNature == 22) {
         this.libelleNature = "CA B.C.";
      } else if (this.usrobjNature == 23) {
         this.libelleNature = "CA B.L.";
      } else if (this.usrobjNature == 24) {
         this.libelleNature = "CA B.R.";
      } else if (this.usrobjNature == 25) {
         this.libelleNature = "CA Facture";
      } else if (this.usrobjNature == 26) {
         this.libelleNature = "CA N.D.B.";
      } else if (this.usrobjNature == 27) {
         this.libelleNature = "CA Avoir";
      } else if (this.usrobjNature == 2) {
         this.libelleNature = "Nb RDV";
      }

      return this.libelleNature;
   }

   public void setLibelleNature(String var1) {
      this.libelleNature = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public String getUsrobjAnnee() {
      return this.usrobjAnnee;
   }

   public void setUsrobjAnnee(String var1) {
      this.usrobjAnnee = var1;
   }

   public double getUsrobjCa01() {
      return this.usrobjCa01;
   }

   public void setUsrobjCa01(double var1) {
      this.usrobjCa01 = var1;
   }

   public double getUsrobjCa02() {
      return this.usrobjCa02;
   }

   public void setUsrobjCa02(double var1) {
      this.usrobjCa02 = var1;
   }

   public double getUsrobjCa03() {
      return this.usrobjCa03;
   }

   public void setUsrobjCa03(double var1) {
      this.usrobjCa03 = var1;
   }

   public double getUsrobjCa04() {
      return this.usrobjCa04;
   }

   public void setUsrobjCa04(double var1) {
      this.usrobjCa04 = var1;
   }

   public double getUsrobjCa05() {
      return this.usrobjCa05;
   }

   public void setUsrobjCa05(double var1) {
      this.usrobjCa05 = var1;
   }

   public double getUsrobjCa06() {
      return this.usrobjCa06;
   }

   public void setUsrobjCa06(double var1) {
      this.usrobjCa06 = var1;
   }

   public double getUsrobjCa07() {
      return this.usrobjCa07;
   }

   public void setUsrobjCa07(double var1) {
      this.usrobjCa07 = var1;
   }

   public double getUsrobjCa08() {
      return this.usrobjCa08;
   }

   public void setUsrobjCa08(double var1) {
      this.usrobjCa08 = var1;
   }

   public double getUsrobjCa09() {
      return this.usrobjCa09;
   }

   public void setUsrobjCa09(double var1) {
      this.usrobjCa09 = var1;
   }

   public double getUsrobjCa10() {
      return this.usrobjCa10;
   }

   public void setUsrobjCa10(double var1) {
      this.usrobjCa10 = var1;
   }

   public double getUsrobjCa11() {
      return this.usrobjCa11;
   }

   public void setUsrobjCa11(double var1) {
      this.usrobjCa11 = var1;
   }

   public double getUsrobjCa12() {
      return this.usrobjCa12;
   }

   public void setUsrobjCa12(double var1) {
      this.usrobjCa12 = var1;
   }

   public double getUsrobjCaTotal() {
      return this.usrobjCaTotal;
   }

   public void setUsrobjCaTotal(double var1) {
      this.usrobjCaTotal = var1;
   }

   public Date getUsrobjDateCreat() {
      return this.usrobjDateCreat;
   }

   public void setUsrobjDateCreat(Date var1) {
      this.usrobjDateCreat = var1;
   }

   public Date getUsrobjDateModif() {
      return this.usrobjDateModif;
   }

   public void setUsrobjDateModif(Date var1) {
      this.usrobjDateModif = var1;
   }

   public long getUsrobjId() {
      return this.usrobjId;
   }

   public void setUsrobjId(long var1) {
      this.usrobjId = var1;
   }

   public Integer getUsrobjNature() {
      return this.usrobjNature;
   }

   public void setUsrobjNature(Integer var1) {
      this.usrobjNature = var1;
   }

   public long getUsrobjUserCreat() {
      return this.usrobjUserCreat;
   }

   public void setUsrobjUserCreat(long var1) {
      this.usrobjUserCreat = var1;
   }

   public long getUsrobjUserModif() {
      return this.usrobjUserModif;
   }

   public void setUsrobjUserModif(long var1) {
      this.usrobjUserModif = var1;
   }
}
