package com.epegase.systeme.classe;

import java.io.Serializable;

public class MailsPj implements Serializable {
   private long maipjId;
   private String malpjAcces;
   private Mails mails;

   public Mails getMails() {
      return this.mails;
   }

   public void setMails(Mails var1) {
      this.mails = var1;
   }

   public long getMaipjId() {
      return this.maipjId;
   }

   public void setMaipjId(long var1) {
      this.maipjId = var1;
   }

   public String getMalpjAcces() {
      return this.malpjAcces;
   }

   public void setMalpjAcces(String var1) {
      this.malpjAcces = var1;
   }
}
