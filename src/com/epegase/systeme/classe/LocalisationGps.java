package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class LocalisationGps implements Serializable {
   private long locgpsId;
   private String locgpsBalise;
   private Date locgpsDate;
   private Date locgpsJour;
   private float locgpsLongitude;
   private float locgpsLatitude;
   private ExercicesParc exercicesParc;
   private Parc parc;

   public ExercicesParc getExercicesParc() {
      return this.exercicesParc;
   }

   public void setExercicesParc(ExercicesParc var1) {
      this.exercicesParc = var1;
   }

   public String getLocgpsBalise() {
      return this.locgpsBalise;
   }

   public void setLocgpsBalise(String var1) {
      this.locgpsBalise = var1;
   }

   public Date getLocgpsDate() {
      return this.locgpsDate;
   }

   public void setLocgpsDate(Date var1) {
      this.locgpsDate = var1;
   }

   public long getLocgpsId() {
      return this.locgpsId;
   }

   public void setLocgpsId(long var1) {
      this.locgpsId = var1;
   }

   public float getLocgpsLatitude() {
      return this.locgpsLatitude;
   }

   public void setLocgpsLatitude(float var1) {
      this.locgpsLatitude = var1;
   }

   public float getLocgpsLongitude() {
      return this.locgpsLongitude;
   }

   public void setLocgpsLongitude(float var1) {
      this.locgpsLongitude = var1;
   }

   public Parc getParc() {
      return this.parc;
   }

   public void setParc(Parc var1) {
      this.parc = var1;
   }

   public Date getLocgpsJour() {
      return this.locgpsJour;
   }

   public void setLocgpsJour(Date var1) {
      this.locgpsJour = var1;
   }
}
