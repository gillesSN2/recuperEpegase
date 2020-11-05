package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class SpecialitesMedical implements Serializable {
   private long spemedId;
   private long spemedUserCreation;
   private long spemedUserModif;
   private Date spemedDateCreation;
   private Date spemedDateModif;
   private int spemedType;
   private int spemedInactif;
   private String spemedCode;
   private String spemedNom;
   private String spemedAdresse;
   private String spemedBP;
   private String spemedTel1;
   private String spemedTel2;
   private String spemedFax;
   private String spemedNomAssistant;
   private String spemedMail;
   private String spemedNomResponsable;
   private String spemedPavillion;
   private String spemedDocteur1;
   private String spemedDocteur2;
   private String spemedDocteur3;
   private String spemedDocteur4;
   private String spemedDocteur5;
   private String spemedDocteur6;
   private String spemedDocteur7;
   private String spemedDocteur8;
   private String spemedDocteur9;
   private String spemedDocteur10;
   private Service service;
   private String type;

   public String getType() {
      this.type = "";
      if (this.spemedType == 0) {
         this.type = "Aide aux diagnostics (laboratoire)";
      } else if (this.spemedType == 1) {
         this.type = "Aide aux diagnostics (radiologie)";
      } else if (this.spemedType == 10) {
         this.type = "Service médicaux";
      } else if (this.spemedType == 11) {
         this.type = "Service chirurgicaux";
      } else if (this.spemedType == 12) {
         this.type = "Service Pharmacie";
      } else if (this.spemedType == 20) {
         this.type = "Service administratif";
      } else if (this.spemedType == 21) {
         this.type = "Service Technique";
      }

      return this.type;
   }

   public void setType(String var1) {
      this.type = var1;
   }

   public Service getService() {
      return this.service;
   }

   public void setService(Service var1) {
      this.service = var1;
   }

   public int getSpemedType() {
      return this.spemedType;
   }

   public void setSpemedType(int var1) {
      this.spemedType = var1;
   }

   public String getSpemedDocteur1() {
      return this.spemedDocteur1;
   }

   public void setSpemedDocteur1(String var1) {
      this.spemedDocteur1 = var1;
   }

   public String getSpemedDocteur10() {
      return this.spemedDocteur10;
   }

   public void setSpemedDocteur10(String var1) {
      this.spemedDocteur10 = var1;
   }

   public String getSpemedDocteur2() {
      return this.spemedDocteur2;
   }

   public void setSpemedDocteur2(String var1) {
      this.spemedDocteur2 = var1;
   }

   public String getSpemedDocteur3() {
      return this.spemedDocteur3;
   }

   public void setSpemedDocteur3(String var1) {
      this.spemedDocteur3 = var1;
   }

   public String getSpemedDocteur4() {
      return this.spemedDocteur4;
   }

   public void setSpemedDocteur4(String var1) {
      this.spemedDocteur4 = var1;
   }

   public String getSpemedDocteur5() {
      return this.spemedDocteur5;
   }

   public void setSpemedDocteur5(String var1) {
      this.spemedDocteur5 = var1;
   }

   public String getSpemedDocteur6() {
      return this.spemedDocteur6;
   }

   public void setSpemedDocteur6(String var1) {
      this.spemedDocteur6 = var1;
   }

   public String getSpemedDocteur7() {
      return this.spemedDocteur7;
   }

   public void setSpemedDocteur7(String var1) {
      this.spemedDocteur7 = var1;
   }

   public String getSpemedDocteur8() {
      return this.spemedDocteur8;
   }

   public void setSpemedDocteur8(String var1) {
      this.spemedDocteur8 = var1;
   }

   public String getSpemedDocteur9() {
      return this.spemedDocteur9;
   }

   public void setSpemedDocteur9(String var1) {
      this.spemedDocteur9 = var1;
   }

   public String getSpemedPavillion() {
      return this.spemedPavillion;
   }

   public void setSpemedPavillion(String var1) {
      this.spemedPavillion = var1;
   }

   public String getSpemedAdresse() {
      return this.spemedAdresse;
   }

   public void setSpemedAdresse(String var1) {
      this.spemedAdresse = var1;
   }

   public String getSpemedBP() {
      return this.spemedBP;
   }

   public void setSpemedBP(String var1) {
      this.spemedBP = var1;
   }

   public Date getSpemedDateCreation() {
      return this.spemedDateCreation;
   }

   public void setSpemedDateCreation(Date var1) {
      this.spemedDateCreation = var1;
   }

   public Date getSpemedDateModif() {
      return this.spemedDateModif;
   }

   public void setSpemedDateModif(Date var1) {
      this.spemedDateModif = var1;
   }

   public String getSpemedFax() {
      return this.spemedFax;
   }

   public void setSpemedFax(String var1) {
      this.spemedFax = var1;
   }

   public long getSpemedId() {
      return this.spemedId;
   }

   public void setSpemedId(long var1) {
      this.spemedId = var1;
   }

   public String getSpemedMail() {
      return this.spemedMail;
   }

   public void setSpemedMail(String var1) {
      this.spemedMail = var1;
   }

   public String getSpemedNom() {
      return this.spemedNom;
   }

   public void setSpemedNom(String var1) {
      this.spemedNom = var1;
   }

   public String getSpemedNomAssistant() {
      return this.spemedNomAssistant;
   }

   public void setSpemedNomAssistant(String var1) {
      this.spemedNomAssistant = var1;
   }

   public String getSpemedNomResponsable() {
      return this.spemedNomResponsable;
   }

   public void setSpemedNomResponsable(String var1) {
      this.spemedNomResponsable = var1;
   }

   public String getSpemedTel1() {
      return this.spemedTel1;
   }

   public void setSpemedTel1(String var1) {
      this.spemedTel1 = var1;
   }

   public String getSpemedTel2() {
      return this.spemedTel2;
   }

   public void setSpemedTel2(String var1) {
      this.spemedTel2 = var1;
   }

   public long getSpemedUserCreation() {
      return this.spemedUserCreation;
   }

   public void setSpemedUserCreation(long var1) {
      this.spemedUserCreation = var1;
   }

   public long getSpemedUserModif() {
      return this.spemedUserModif;
   }

   public void setSpemedUserModif(long var1) {
      this.spemedUserModif = var1;
   }

   public String getSpemedCode() {
      return this.spemedCode;
   }

   public void setSpemedCode(String var1) {
      this.spemedCode = var1;
   }

   public int getSpemedInactif() {
      return this.spemedInactif;
   }

   public void setSpemedInactif(int var1) {
      this.spemedInactif = var1;
   }
}
