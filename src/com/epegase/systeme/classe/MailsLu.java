package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class MailsLu implements Serializable {
   private long mailuId;
   private Date malluDateLecture;
   private String malluNote;
   private String malluUser;
   private Users users;
   private Mails mails;

   public Mails getMails() {
      return this.mails;
   }

   public void setMails(Mails var1) {
      this.mails = var1;
   }

   public long getMailuId() {
      return this.mailuId;
   }

   public void setMailuId(long var1) {
      this.mailuId = var1;
   }

   public Date getMalluDateLecture() {
      return this.malluDateLecture;
   }

   public void setMalluDateLecture(Date var1) {
      this.malluDateLecture = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public String getMalluUser() {
      return this.malluUser;
   }

   public void setMalluUser(String var1) {
      this.malluUser = var1;
   }

   public String getMalluNote() {
      return this.malluNote;
   }

   public void setMalluNote(String var1) {
      this.malluNote = var1;
   }
}
