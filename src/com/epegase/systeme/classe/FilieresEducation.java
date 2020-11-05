package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FilieresEducation implements Serializable {
   private long filId;
   private Date filDateCreat;
   private Date filDateModif;
   private long filUserCreat;
   private long filUserModif;
   private int filEtat;
   private String filCode;
   private String filLibelle;
   private int filType;
   private int filMode;
   private String filSalle;
   private String filMoisDebut;
   private String filMoisFin;
   private int filnbMois;
   private int filnbTrimestre;
   private int filnbSemestre;
   private String filDescription;
   private double filTarifDossier;
   private double filTarifInscription;
   private double filTarifReinscription;
   private double filTarifScolarite;
   private double filTarifTransport;
   private double filTarifCantine;
   private double filTarifTenue;
   private double filTarifDivers;
   private double filTarifExamens;
   private double filTarifAssociation;
   private String etat;
   private boolean inactif;
   private String libelleType;
   private String libelleMode;

   public String getEtat() {
      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public String getLibelleMode() {
      this.libelleMode = "";
      if (this.filMode == 0) {
         this.libelleMode = "Appréciation";
      } else if (this.filMode == 1) {
         this.libelleMode = "Moyenne";
      } else if (this.filMode == 2) {
         this.libelleMode = "U.E.";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public String getLibelleType() {
      this.libelleType = "";
      if (this.filType == 0) {
         this.libelleType = "Maternelle";
      } else if (this.filType == 1) {
         this.libelleType = "Elémentaire";
      } else if (this.filType == 2) {
         this.libelleType = "Collège";
      } else if (this.filType == 3) {
         this.libelleType = "Lycée";
      } else if (this.filType == 4) {
         this.libelleType = "Supérieur";
      } else if (this.filType == 5) {
         this.libelleType = "Centre de formation";
      } else if (this.filType == 6) {
         this.libelleType = "Cours du soir";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public String getFilCode() {
      return this.filCode;
   }

   public void setFilCode(String var1) {
      this.filCode = var1;
   }

   public Date getFilDateCreat() {
      return this.filDateCreat;
   }

   public void setFilDateCreat(Date var1) {
      this.filDateCreat = var1;
   }

   public Date getFilDateModif() {
      return this.filDateModif;
   }

   public void setFilDateModif(Date var1) {
      this.filDateModif = var1;
   }

   public String getFilDescription() {
      return this.filDescription;
   }

   public void setFilDescription(String var1) {
      this.filDescription = var1;
   }

   public int getFilEtat() {
      return this.filEtat;
   }

   public void setFilEtat(int var1) {
      this.filEtat = var1;
   }

   public long getFilId() {
      return this.filId;
   }

   public void setFilId(long var1) {
      this.filId = var1;
   }

   public String getFilLibelle() {
      return this.filLibelle;
   }

   public void setFilLibelle(String var1) {
      this.filLibelle = var1;
   }

   public int getFilMode() {
      return this.filMode;
   }

   public void setFilMode(int var1) {
      this.filMode = var1;
   }

   public String getFilSalle() {
      return this.filSalle;
   }

   public void setFilSalle(String var1) {
      this.filSalle = var1;
   }

   public double getFilTarifCantine() {
      return this.filTarifCantine;
   }

   public void setFilTarifCantine(double var1) {
      this.filTarifCantine = var1;
   }

   public double getFilTarifDivers() {
      return this.filTarifDivers;
   }

   public void setFilTarifDivers(double var1) {
      this.filTarifDivers = var1;
   }

   public double getFilTarifDossier() {
      return this.filTarifDossier;
   }

   public void setFilTarifDossier(double var1) {
      this.filTarifDossier = var1;
   }

   public double getFilTarifExamens() {
      return this.filTarifExamens;
   }

   public void setFilTarifExamens(double var1) {
      this.filTarifExamens = var1;
   }

   public double getFilTarifInscription() {
      return this.filTarifInscription;
   }

   public void setFilTarifInscription(double var1) {
      this.filTarifInscription = var1;
   }

   public double getFilTarifReinscription() {
      return this.filTarifReinscription;
   }

   public void setFilTarifReinscription(double var1) {
      this.filTarifReinscription = var1;
   }

   public double getFilTarifScolarite() {
      return this.filTarifScolarite;
   }

   public void setFilTarifScolarite(double var1) {
      this.filTarifScolarite = var1;
   }

   public double getFilTarifTenue() {
      return this.filTarifTenue;
   }

   public void setFilTarifTenue(double var1) {
      this.filTarifTenue = var1;
   }

   public int getFilType() {
      return this.filType;
   }

   public void setFilType(int var1) {
      this.filType = var1;
   }

   public long getFilUserCreat() {
      return this.filUserCreat;
   }

   public void setFilUserCreat(long var1) {
      this.filUserCreat = var1;
   }

   public long getFilUserModif() {
      return this.filUserModif;
   }

   public void setFilUserModif(long var1) {
      this.filUserModif = var1;
   }

   public String getFilMoisDebut() {
      return this.filMoisDebut;
   }

   public void setFilMoisDebut(String var1) {
      this.filMoisDebut = var1;
   }

   public String getFilMoisFin() {
      return this.filMoisFin;
   }

   public void setFilMoisFin(String var1) {
      this.filMoisFin = var1;
   }

   public double getFilTarifAssociation() {
      return this.filTarifAssociation;
   }

   public void setFilTarifAssociation(double var1) {
      this.filTarifAssociation = var1;
   }

   public double getFilTarifTransport() {
      return this.filTarifTransport;
   }

   public void setFilTarifTransport(double var1) {
      this.filTarifTransport = var1;
   }

   public int getFilnbMois() {
      return this.filnbMois;
   }

   public void setFilnbMois(int var1) {
      this.filnbMois = var1;
   }

   public int getFilnbSemestre() {
      return this.filnbSemestre;
   }

   public void setFilnbSemestre(int var1) {
      this.filnbSemestre = var1;
   }

   public int getFilnbTrimestre() {
      return this.filnbTrimestre;
   }

   public void setFilnbTrimestre(int var1) {
      this.filnbTrimestre = var1;
   }
}
