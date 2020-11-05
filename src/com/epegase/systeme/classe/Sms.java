package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Sms implements Serializable {
   private long smsId;
   private Date smsDate;
   private String smsNum;
   private String smsTexte;
   private String smsStatus;
   private String smsMobile;
   private String smsNomContact;
   private String smsCiviliteContact;
   private long smsIdContact;
   private int smsTypeTiers;
   private String smsNomTiers;
   private long smsIdTiers;
   private int smsQte;
   private Users users;

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public String getSmsCiviliteContact() {
      return this.smsCiviliteContact;
   }

   public void setSmsCiviliteContact(String var1) {
      this.smsCiviliteContact = var1;
   }

   public Date getSmsDate() {
      return this.smsDate;
   }

   public void setSmsDate(Date var1) {
      this.smsDate = var1;
   }

   public long getSmsId() {
      return this.smsId;
   }

   public void setSmsId(long var1) {
      this.smsId = var1;
   }

   public long getSmsIdContact() {
      return this.smsIdContact;
   }

   public void setSmsIdContact(long var1) {
      this.smsIdContact = var1;
   }

   public long getSmsIdTiers() {
      return this.smsIdTiers;
   }

   public void setSmsIdTiers(long var1) {
      this.smsIdTiers = var1;
   }

   public String getSmsMobile() {
      return this.smsMobile;
   }

   public void setSmsMobile(String var1) {
      this.smsMobile = var1;
   }

   public String getSmsNomContact() {
      return this.smsNomContact;
   }

   public void setSmsNomContact(String var1) {
      this.smsNomContact = var1;
   }

   public String getSmsNomTiers() {
      return this.smsNomTiers;
   }

   public void setSmsNomTiers(String var1) {
      this.smsNomTiers = var1;
   }

   public String getSmsNum() {
      return this.smsNum;
   }

   public void setSmsNum(String var1) {
      this.smsNum = var1;
   }

   public int getSmsQte() {
      return this.smsQte;
   }

   public void setSmsQte(int var1) {
      this.smsQte = var1;
   }

   public String getSmsStatus() {
      return this.smsStatus;
   }

   public void setSmsStatus(String var1) {
      this.smsStatus = var1;
   }

   public String getSmsTexte() {
      return this.smsTexte;
   }

   public void setSmsTexte(String var1) {
      this.smsTexte = var1;
   }

   public int getSmsTypeTiers() {
      return this.smsTypeTiers;
   }

   public void setSmsTypeTiers(int var1) {
      this.smsTypeTiers = var1;
   }
}
