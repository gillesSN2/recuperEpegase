package com.epegase.systeme.control;

import java.io.Serializable;
import java.util.Date;

public class ObjetMail implements Serializable {
   private int mailIndice;
   private long mailNumero;
   private String mailSujet;
   private String mailDescription;
   private String mailContentType;
   private String mailDisposition;
   private String mailFileName;
   private String mailFlag;
   private String mailFolder;
   private Date mailDateEnvoie;
   private Date mailDateRecue;
   private int mailSize;
   private String mailContent;
   private String mailExpediteur;
   private String mailDestinataire;
   private String mailDestinataireCC;
   private String mailDestinataireCCI;
   private boolean mailPj;
   private long maiIdContact;
   private String maiNomContact;
   private long maiIdTiers;
   private String maiRaisonSociale;

   public String getMailContent() {
      return this.mailContent;
   }

   public void setMailContent(String var1) {
      this.mailContent = var1;
   }

   public String getMailContentType() {
      return this.mailContentType;
   }

   public void setMailContentType(String var1) {
      this.mailContentType = var1;
   }

   public Date getMailDateEnvoie() {
      return this.mailDateEnvoie;
   }

   public void setMailDateEnvoie(Date var1) {
      this.mailDateEnvoie = var1;
   }

   public Date getMailDateRecue() {
      return this.mailDateRecue;
   }

   public void setMailDateRecue(Date var1) {
      this.mailDateRecue = var1;
   }

   public String getMailDescription() {
      return this.mailDescription;
   }

   public void setMailDescription(String var1) {
      this.mailDescription = var1;
   }

   public String getMailDestinataire() {
      return this.mailDestinataire;
   }

   public void setMailDestinataire(String var1) {
      this.mailDestinataire = var1;
   }

   public String getMailDestinataireCC() {
      return this.mailDestinataireCC;
   }

   public void setMailDestinataireCC(String var1) {
      this.mailDestinataireCC = var1;
   }

   public String getMailDestinataireCCI() {
      return this.mailDestinataireCCI;
   }

   public void setMailDestinataireCCI(String var1) {
      this.mailDestinataireCCI = var1;
   }

   public String getMailDisposition() {
      return this.mailDisposition;
   }

   public void setMailDisposition(String var1) {
      this.mailDisposition = var1;
   }

   public String getMailExpediteur() {
      return this.mailExpediteur;
   }

   public void setMailExpediteur(String var1) {
      this.mailExpediteur = var1;
   }

   public String getMailFileName() {
      return this.mailFileName;
   }

   public void setMailFileName(String var1) {
      this.mailFileName = var1;
   }

   public String getMailFlag() {
      return this.mailFlag;
   }

   public void setMailFlag(String var1) {
      this.mailFlag = var1;
   }

   public String getMailFolder() {
      return this.mailFolder;
   }

   public void setMailFolder(String var1) {
      this.mailFolder = var1;
   }

   public int getMailIndice() {
      return this.mailIndice;
   }

   public void setMailIndice(int var1) {
      this.mailIndice = var1;
   }

   public int getMailSize() {
      return this.mailSize;
   }

   public void setMailSize(int var1) {
      this.mailSize = var1;
   }

   public String getMailSujet() {
      return this.mailSujet;
   }

   public void setMailSujet(String var1) {
      this.mailSujet = var1;
   }

   public long getMailNumero() {
      return this.mailNumero;
   }

   public void setMailNumero(long var1) {
      this.mailNumero = var1;
   }

   public boolean isMailPj() {
      return this.mailPj;
   }

   public void setMailPj(boolean var1) {
      this.mailPj = var1;
   }

   public long getMaiIdContact() {
      return this.maiIdContact;
   }

   public void setMaiIdContact(long var1) {
      this.maiIdContact = var1;
   }

   public long getMaiIdTiers() {
      return this.maiIdTiers;
   }

   public void setMaiIdTiers(long var1) {
      this.maiIdTiers = var1;
   }

   public String getMaiNomContact() {
      return this.maiNomContact;
   }

   public void setMaiNomContact(String var1) {
      this.maiNomContact = var1;
   }

   public String getMaiRaisonSociale() {
      return this.maiRaisonSociale;
   }

   public void setMaiRaisonSociale(String var1) {
      this.maiRaisonSociale = var1;
   }
}
