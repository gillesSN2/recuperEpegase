package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Espion implements Serializable {
   private long espid;
   private Date espdtecreat;
   private String espaction;
   private int esptype;
   private long esptIdTiers;
   private Users users;
   private String libelleType;

   public String getLibelleType() {
      if (this.esptype == 0) {
         this.libelleType = "Action";
      } else if (this.esptype == 1) {
         this.libelleType = "Log.";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public String getEspaction() {
      return this.espaction;
   }

   public void setEspaction(String var1) {
      this.espaction = var1;
   }

   public Date getEspdtecreat() {
      return this.espdtecreat;
   }

   public void setEspdtecreat(Date var1) {
      this.espdtecreat = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public long getEspid() {
      return this.espid;
   }

   public void setEspid(long var1) {
      this.espid = var1;
   }

   public int getEsptype() {
      return this.esptype;
   }

   public void setEsptype(int var1) {
      this.esptype = var1;
   }

   public long getEsptIdTiers() {
      return this.esptIdTiers;
   }

   public void setEsptIdTiers(long var1) {
      this.esptIdTiers = var1;
   }
}
