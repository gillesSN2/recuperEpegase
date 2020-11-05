package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PatientProt implements Serializable {
   private long patprtId;
   private Date patprtDateDebut;
   private Date patprtDatefin;
   private String patprtCode;
   private String patprtLibelle;
   private Patients patient;

   public Patients getPatient() {
      return this.patient;
   }

   public void setPatient(Patients var1) {
      this.patient = var1;
   }

   public Date getPatprtDateDebut() {
      return this.patprtDateDebut;
   }

   public void setPatprtDateDebut(Date var1) {
      this.patprtDateDebut = var1;
   }

   public Date getPatprtDatefin() {
      return this.patprtDatefin;
   }

   public void setPatprtDatefin(Date var1) {
      this.patprtDatefin = var1;
   }

   public long getPatprtId() {
      return this.patprtId;
   }

   public void setPatprtId(long var1) {
      this.patprtId = var1;
   }

   public String getPatprtCode() {
      return this.patprtCode;
   }

   public void setPatprtCode(String var1) {
      this.patprtCode = var1;
   }

   public String getPatprtLibelle() {
      return this.patprtLibelle;
   }

   public void setPatprtLibelle(String var1) {
      this.patprtLibelle = var1;
   }
}
