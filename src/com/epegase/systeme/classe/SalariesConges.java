package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class SalariesConges implements Serializable {
   private long salcngId;
   private Date salcngDateCreat;
   private Date salcngDateModif;
   private long salcngUserCreat;
   private long salcngUserModif;
   private String salcngContrat;
   private int salcngType;
   private int salcngNature;
   private Date salcngDateDebut;
   private int salcngSemaineDebut;
   private Date salcngDateFin;
   private int salcngSemaineFin;
   private float salcngDuree;
   private boolean salcngAm;
   private boolean salcngPm;
   private String salcngObjet;
   private String salcngResponsable;
   private String salcngLieu;
   private float salcngNbHeure;
   private int salcngEtatVal;
   private int salcngEtat;
   private Date salcngDateValide;
   private int salcngPosSignature;
   private Date salcngDateImp;
   private float salcngNbJoursExclus;
   private Salaries salaries;
   private String lib_nature;
   private String libelleEtat;
   private String protege;

   public String getProtege() {
      if (this.salaries.getSalProtege() == 1) {
         this.protege = "color:grey";
      } else {
         this.protege = "color:black";
      }

      return this.protege;
   }

   public void setProtege(String var1) {
      this.protege = var1;
   }

   public String getLib_nature() {
      if (this.salcngNature == 0) {
         this.lib_nature = "Demande Congés";
      } else if (this.salcngNature == 1) {
         this.lib_nature = "Congés Normaux solde total";
      } else if (this.salcngNature == 2) {
         this.lib_nature = "Bulletin de congés";
      } else if (this.salcngNature == 3) {
         this.lib_nature = "Congés Travaillés";
      } else if (this.salcngNature == 4) {
         this.lib_nature = "Congés Non Calculés";
      } else if (this.salcngNature == 5) {
         this.lib_nature = "Congés Maternités";
      } else if (this.salcngNature == 6) {
         this.lib_nature = "Congés Normaux en nb jours";
      } else if (this.salcngNature == 7) {
         this.lib_nature = "Mise à disposition";
      } else if (this.salcngNature == 10) {
         this.lib_nature = "Demande absence";
      } else if (this.salcngNature == 11) {
         this.lib_nature = "Absence payée";
      } else if (this.salcngNature == 12) {
         this.lib_nature = "Absence non payée";
      } else if (this.salcngNature == 13) {
         this.lib_nature = "Absence payée à déduire su CP";
      } else if (this.salcngNature == 14) {
         this.lib_nature = "Retard non payé";
      } else if (this.salcngNature == 15) {
         this.lib_nature = "Retard payé";
      } else if (this.salcngNature == 16) {
         this.lib_nature = "Absence payée pour repos médical";
      } else if (this.salcngNature == 17) {
         this.lib_nature = "Absence payée pour visite médicale";
      }

      return this.lib_nature;
   }

   public void setLib_nature(String var1) {
      this.lib_nature = var1;
   }

   public String getLibelleEtat() {
      if (this.salcngEtat == 0) {
         this.libelleEtat = "N.Val.";
      } else if (this.salcngEtat == 1) {
         this.libelleEtat = "Val.";
      } else if (this.salcngEtat == 2) {
         this.libelleEtat = "Gel.";
      } else if (this.salcngEtat == 3) {
         this.libelleEtat = "Annul.";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public Date getSalcngDateCreat() {
      return this.salcngDateCreat;
   }

   public void setSalcngDateCreat(Date var1) {
      this.salcngDateCreat = var1;
   }

   public Date getSalcngDateDebut() {
      return this.salcngDateDebut;
   }

   public void setSalcngDateDebut(Date var1) {
      this.salcngDateDebut = var1;
   }

   public Date getSalcngDateFin() {
      return this.salcngDateFin;
   }

   public void setSalcngDateFin(Date var1) {
      this.salcngDateFin = var1;
   }

   public Date getSalcngDateImp() {
      return this.salcngDateImp;
   }

   public void setSalcngDateImp(Date var1) {
      this.salcngDateImp = var1;
   }

   public Date getSalcngDateModif() {
      return this.salcngDateModif;
   }

   public void setSalcngDateModif(Date var1) {
      this.salcngDateModif = var1;
   }

   public Date getSalcngDateValide() {
      return this.salcngDateValide;
   }

   public void setSalcngDateValide(Date var1) {
      this.salcngDateValide = var1;
   }

   public float getSalcngDuree() {
      return this.salcngDuree;
   }

   public void setSalcngDuree(float var1) {
      this.salcngDuree = var1;
   }

   public int getSalcngEtat() {
      return this.salcngEtat;
   }

   public void setSalcngEtat(int var1) {
      this.salcngEtat = var1;
   }

   public int getSalcngEtatVal() {
      return this.salcngEtatVal;
   }

   public void setSalcngEtatVal(int var1) {
      this.salcngEtatVal = var1;
   }

   public long getSalcngId() {
      return this.salcngId;
   }

   public void setSalcngId(long var1) {
      this.salcngId = var1;
   }

   public String getSalcngLieu() {
      return this.salcngLieu;
   }

   public void setSalcngLieu(String var1) {
      this.salcngLieu = var1;
   }

   public int getSalcngNature() {
      return this.salcngNature;
   }

   public void setSalcngNature(int var1) {
      this.salcngNature = var1;
   }

   public String getSalcngObjet() {
      return this.salcngObjet;
   }

   public void setSalcngObjet(String var1) {
      this.salcngObjet = var1;
   }

   public String getSalcngResponsable() {
      return this.salcngResponsable;
   }

   public void setSalcngResponsable(String var1) {
      this.salcngResponsable = var1;
   }

   public long getSalcngUserCreat() {
      return this.salcngUserCreat;
   }

   public void setSalcngUserCreat(long var1) {
      this.salcngUserCreat = var1;
   }

   public long getSalcngUserModif() {
      return this.salcngUserModif;
   }

   public void setSalcngUserModif(long var1) {
      this.salcngUserModif = var1;
   }

   public int getSalcngType() {
      return this.salcngType;
   }

   public void setSalcngType(int var1) {
      this.salcngType = var1;
   }

   public float getSalcngNbHeure() {
      return this.salcngNbHeure;
   }

   public void setSalcngNbHeure(float var1) {
      this.salcngNbHeure = var1;
   }

   public boolean isSalcngAm() {
      return this.salcngAm;
   }

   public void setSalcngAm(boolean var1) {
      this.salcngAm = var1;
   }

   public boolean isSalcngPm() {
      return this.salcngPm;
   }

   public void setSalcngPm(boolean var1) {
      this.salcngPm = var1;
   }

   public int getSalcngSemaineDebut() {
      return this.salcngSemaineDebut;
   }

   public void setSalcngSemaineDebut(int var1) {
      this.salcngSemaineDebut = var1;
   }

   public int getSalcngSemaineFin() {
      return this.salcngSemaineFin;
   }

   public void setSalcngSemaineFin(int var1) {
      this.salcngSemaineFin = var1;
   }

   public float getSalcngNbJoursExclus() {
      return this.salcngNbJoursExclus;
   }

   public void setSalcngNbJoursExclus(float var1) {
      this.salcngNbJoursExclus = var1;
   }

   public int getSalcngPosSignature() {
      return this.salcngPosSignature;
   }

   public void setSalcngPosSignature(int var1) {
      this.salcngPosSignature = var1;
   }

   public String getSalcngContrat() {
      return this.salcngContrat;
   }

   public void setSalcngContrat(String var1) {
      this.salcngContrat = var1;
   }
}
