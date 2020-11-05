package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Rdv implements Serializable {
   private long rdvId;
   private int rdvNature;
   private Date rdvDateCreation;
   private long rdvUsrDe;
   private String rdvMailContact;
   private String rdvNomUsers;
   private long rdvTieIdDe;
   private String rdvNomTiers;
   private long rdvPatIdDe;
   private String rdvNomPat;
   private long rdvSalIdDe;
   private String rdvNomSal;
   private Date rdvDteDe;
   private String rdvHrDe;
   private String rdvMnDe;
   private String rdvHrDuree;
   private String rdvMnDuree;
   private Date rdvDteFi;
   private String rdvHrFi;
   private String rdvMnFi;
   private String rdvSujet;
   private String rdvDescript;
   private String rdvTache;
   private float rdvTachePr;
   private float rdvTachePv;
   private String rdvLieu;
   private String rdvMode;
   private int rdvEtat;
   private Date rdvDteExec;
   private String rdvCr;
   private String rdvConclusion;
   private int rdvDiversTiers;
   private String rdvDiversNom;
   private String rdvCollaborateur;
   private long rdvIdPrincipal;
   private long rdvIdPrincipalRdv;
   private String rdvStatut;
   private boolean rdvErreur;
   private String rdvService;
   private double rdvX;
   private double rdvY;
   private String rdvBudget;
   private String rdvApport;
   private String rdvDelais;
   private String rdvModeFin;
   private Date rdvDateProchaine;
   private Users users;
   private String debut;
   private String fin;
   private String libNature;
   private String libType;
   private String libEtat;
   private String color;
   private String texteAffiche;
   private String nomTiers;

   public String getNomTiers() {
      if (this.rdvNomTiers != null && !this.rdvNomTiers.isEmpty()) {
         this.nomTiers = this.rdvNomTiers;
      } else if (this.rdvNomSal != null && !this.rdvNomSal.isEmpty()) {
         this.nomTiers = this.rdvNomSal;
      } else if (this.rdvNomPat != null && !this.rdvNomPat.isEmpty()) {
         this.nomTiers = this.rdvNomPat;
      } else if (this.rdvNomUsers != null && !this.rdvNomUsers.isEmpty()) {
         this.nomTiers = this.rdvNomUsers;
      }

      return this.nomTiers;
   }

   public void setNomTiers(String var1) {
      this.nomTiers = var1;
   }

   public String getTexteAffiche() {
      this.texteAffiche = "";
      if (this.rdvNomTiers != null && !this.rdvNomTiers.isEmpty()) {
         this.texteAffiche = this.rdvNomTiers;
      } else if (this.rdvNomSal != null && !this.rdvNomSal.isEmpty()) {
         this.texteAffiche = this.rdvNomSal;
      } else if (this.rdvNomPat != null && !this.rdvNomPat.isEmpty()) {
         this.texteAffiche = this.rdvNomPat;
      } else if (this.rdvNomUsers != null && !this.rdvNomUsers.isEmpty()) {
         this.texteAffiche = this.rdvNomUsers;
      } else if (this.rdvDiversNom != null && !this.rdvDiversNom.isEmpty()) {
         this.texteAffiche = this.rdvDiversNom;
      }

      if (this.rdvSujet != null && !this.rdvSujet.isEmpty()) {
         if (this.texteAffiche != null && !this.texteAffiche.isEmpty()) {
            this.texteAffiche = this.texteAffiche + " " + this.rdvSujet;
         } else {
            this.texteAffiche = this.rdvSujet;
         }
      }

      return this.texteAffiche;
   }

   public void setTexteAffiche(String var1) {
      this.texteAffiche = var1;
   }

   public String getColor() {
      if (this.rdvNature == 0) {
         this.color = "color:#000000;";
      } else if (this.rdvNature == 1) {
         this.color = "color:#0000FF;";
      } else if (this.rdvNature == 2) {
         this.color = "color:#B404AE;";
      } else if (this.rdvNature == 3) {
         this.color = "color:#610B0B;";
      } else if (this.rdvNature == 4) {
         this.color = "color:#173B0B";
      } else if (this.rdvNature == 5) {
         this.color = "color:#FAAC58;";
      } else if (this.rdvNature == 6) {
         this.color = "color:#01A9DB;";
      } else if (this.rdvNature == 7) {
         this.color = "color:#FF8000;";
      } else if (this.rdvNature == 8) {
         this.color = "color:#FF0040;text-decoration: blink;";
      } else if (this.rdvNature == 9) {
         this.color = "color:#585858;";
      } else if (this.rdvNature == 10) {
         this.color = "color:#FA58F4;";
      }

      return this.color;
   }

   public void setColor(String var1) {
      this.color = var1;
   }

   public String getLibNature() {
      if (this.rdvSujet != null && !this.rdvSujet.isEmpty()) {
         if (this.rdvNature == 0) {
            this.libNature = "Rappel";
         } else if (this.rdvNature == 1) {
            this.libNature = "Rdv";
         } else if (this.rdvNature == 2) {
            this.libNature = "To Do";
         } else if (this.rdvNature == 3) {
            this.libNature = "Emploi du temps";
         } else if (this.rdvNature == 4) {
            this.libNature = "Visite";
         } else if (this.rdvNature == 5) {
            this.libNature = "Intervention";
         } else if (this.rdvNature == 6) {
            this.libNature = "Appel";
         } else if (this.rdvNature == 7) {
            this.libNature = "Pointage";
         } else if (this.rdvNature == 8) {
            this.libNature = "Réunion";
         } else if (this.rdvNature == 9) {
            this.libNature = "Message";
         } else if (this.rdvNature == 10) {
            this.libNature = "Post-it";
         } else if (this.rdvNature == 11) {
            this.libNature = "Cal.Fiscal";
         }
      } else {
         this.libNature = "";
      }

      return this.libNature;
   }

   public void setLibNature(String var1) {
      this.libNature = var1;
   }

   public String getLibType() {
      if (this.rdvTieIdDe != 0L && this.rdvPatIdDe == 0L && this.rdvSalIdDe == 0L && this.rdvUsrDe == 0L) {
         this.libType = "Tiers";
      } else if (this.rdvTieIdDe == 0L && this.rdvPatIdDe != 0L && this.rdvSalIdDe == 0L && this.rdvUsrDe == 0L) {
         this.libType = "Pat.";
      } else if (this.rdvTieIdDe == 0L && this.rdvPatIdDe == 0L && this.rdvSalIdDe != 0L && this.rdvUsrDe == 0L) {
         this.libType = "Agt.";
      } else {
         this.libType = "User";
      }

      return this.libType;
   }

   public void setLibType(String var1) {
      this.libType = var1;
   }

   public String getLibEtat() {
      if (this.rdvEtat == 1) {
         this.libEtat = "Traité";
      } else if (this.rdvEtat == 2) {
         this.libEtat = "Annulé";
      } else {
         this.libEtat = "En cours";
      }

      return this.libEtat;
   }

   public void setLibEtat(String var1) {
      this.libEtat = var1;
   }

   public String getRdvDescript() {
      return this.rdvDescript;
   }

   public void setRdvDescript(String var1) {
      this.rdvDescript = var1;
   }

   public Date getRdvDteDe() {
      return this.rdvDteDe;
   }

   public void setRdvDteDe(Date var1) {
      this.rdvDteDe = var1;
   }

   public Date getRdvDteFi() {
      return this.rdvDteFi;
   }

   public void setRdvDteFi(Date var1) {
      this.rdvDteFi = var1;
   }

   public String getRdvHrDuree() {
      return this.rdvHrDuree;
   }

   public void setRdvHrDuree(String var1) {
      this.rdvHrDuree = var1;
   }

   public String getRdvMnDuree() {
      return this.rdvMnDuree;
   }

   public void setRdvMnDuree(String var1) {
      this.rdvMnDuree = var1;
   }

   public int getRdvEtat() {
      return this.rdvEtat;
   }

   public void setRdvEtat(int var1) {
      this.rdvEtat = var1;
   }

   public String getRdvHrDe() {
      return this.rdvHrDe;
   }

   public void setRdvHrDe(String var1) {
      this.rdvHrDe = var1;
   }

   public String getRdvHrFi() {
      return this.rdvHrFi;
   }

   public void setRdvHrFi(String var1) {
      this.rdvHrFi = var1;
   }

   public long getRdvId() {
      return this.rdvId;
   }

   public void setRdvId(long var1) {
      this.rdvId = var1;
   }

   public String getRdvLieu() {
      return this.rdvLieu;
   }

   public void setRdvLieu(String var1) {
      this.rdvLieu = var1;
   }

   public String getRdvMode() {
      return this.rdvMode;
   }

   public void setRdvMode(String var1) {
      this.rdvMode = var1;
   }

   public int getRdvNature() {
      return this.rdvNature;
   }

   public void setRdvNature(int var1) {
      this.rdvNature = var1;
   }

   public String getRdvSujet() {
      return this.rdvSujet;
   }

   public void setRdvSujet(String var1) {
      this.rdvSujet = var1;
   }

   public String getRdvTache() {
      return this.rdvTache;
   }

   public void setRdvTache(String var1) {
      this.rdvTache = var1;
   }

   public long getRdvUsrDe() {
      return this.rdvUsrDe;
   }

   public void setRdvUsrDe(long var1) {
      this.rdvUsrDe = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public String getDebut() {
      return this.debut;
   }

   public void setDebut(String var1) {
      this.debut = var1;
   }

   public String getFin() {
      return this.fin;
   }

   public void setFin(String var1) {
      this.fin = var1;
   }

   public Date getRdvDateCreation() {
      return this.rdvDateCreation;
   }

   public void setRdvDateCreation(Date var1) {
      this.rdvDateCreation = var1;
   }

   public String getRdvNomTiers() {
      if (this.rdvNomTiers != null && !this.rdvNomTiers.isEmpty()) {
         this.rdvNomTiers = this.rdvNomTiers.toUpperCase();
      }

      return this.rdvNomTiers;
   }

   public void setRdvNomTiers(String var1) {
      this.rdvNomTiers = var1;
   }

   public String getRdvMnDe() {
      return this.rdvMnDe;
   }

   public void setRdvMnDe(String var1) {
      this.rdvMnDe = var1;
   }

   public String getRdvMnFi() {
      return this.rdvMnFi;
   }

   public void setRdvMnFi(String var1) {
      this.rdvMnFi = var1;
   }

   public String getRdvNomUsers() {
      return this.rdvNomUsers;
   }

   public void setRdvNomUsers(String var1) {
      this.rdvNomUsers = var1;
   }

   public long getRdvTieIdDe() {
      return this.rdvTieIdDe;
   }

   public void setRdvTieIdDe(long var1) {
      this.rdvTieIdDe = var1;
   }

   public String getRdvNomPat() {
      if (this.rdvNomPat != null && !this.rdvNomPat.isEmpty()) {
         this.rdvNomPat = this.rdvNomPat.toUpperCase();
      }

      return this.rdvNomPat;
   }

   public void setRdvNomPat(String var1) {
      this.rdvNomPat = var1;
   }

   public String getRdvNomSal() {
      return this.rdvNomSal;
   }

   public void setRdvNomSal(String var1) {
      this.rdvNomSal = var1;
   }

   public long getRdvPatIdDe() {
      return this.rdvPatIdDe;
   }

   public void setRdvPatIdDe(long var1) {
      this.rdvPatIdDe = var1;
   }

   public long getRdvSalIdDe() {
      return this.rdvSalIdDe;
   }

   public void setRdvSalIdDe(long var1) {
      this.rdvSalIdDe = var1;
   }

   public float getRdvTachePr() {
      return this.rdvTachePr;
   }

   public void setRdvTachePr(float var1) {
      this.rdvTachePr = var1;
   }

   public float getRdvTachePv() {
      return this.rdvTachePv;
   }

   public void setRdvTachePv(float var1) {
      this.rdvTachePv = var1;
   }

   public Date getRdvDteExec() {
      return this.rdvDteExec;
   }

   public void setRdvDteExec(Date var1) {
      this.rdvDteExec = var1;
   }

   public String getRdvCr() {
      return this.rdvCr;
   }

   public void setRdvCr(String var1) {
      this.rdvCr = var1;
   }

   public String getRdvDiversNom() {
      if (this.rdvDiversNom != null && !this.rdvDiversNom.isEmpty()) {
         this.rdvDiversNom = this.rdvDiversNom.toUpperCase();
      }

      return this.rdvDiversNom;
   }

   public void setRdvDiversNom(String var1) {
      this.rdvDiversNom = var1;
   }

   public int getRdvDiversTiers() {
      return this.rdvDiversTiers;
   }

   public void setRdvDiversTiers(int var1) {
      this.rdvDiversTiers = var1;
   }

   public String getRdvMailContact() {
      return this.rdvMailContact;
   }

   public void setRdvMailContact(String var1) {
      this.rdvMailContact = var1;
   }

   public String getRdvCollaborateur() {
      return this.rdvCollaborateur;
   }

   public void setRdvCollaborateur(String var1) {
      this.rdvCollaborateur = var1;
   }

   public long getRdvIdPrincipal() {
      return this.rdvIdPrincipal;
   }

   public void setRdvIdPrincipal(long var1) {
      this.rdvIdPrincipal = var1;
   }

   public boolean isRdvErreur() {
      return this.rdvErreur;
   }

   public void setRdvErreur(boolean var1) {
      this.rdvErreur = var1;
   }

   public String getRdvStatut() {
      return this.rdvStatut;
   }

   public void setRdvStatut(String var1) {
      this.rdvStatut = var1;
   }

   public String getRdvService() {
      return this.rdvService;
   }

   public void setRdvService(String var1) {
      this.rdvService = var1;
   }

   public double getRdvX() {
      return this.rdvX;
   }

   public void setRdvX(double var1) {
      this.rdvX = var1;
   }

   public double getRdvY() {
      return this.rdvY;
   }

   public void setRdvY(double var1) {
      this.rdvY = var1;
   }

   public String getRdvApport() {
      return this.rdvApport;
   }

   public void setRdvApport(String var1) {
      this.rdvApport = var1;
   }

   public String getRdvBudget() {
      return this.rdvBudget;
   }

   public void setRdvBudget(String var1) {
      this.rdvBudget = var1;
   }

   public Date getRdvDateProchaine() {
      return this.rdvDateProchaine;
   }

   public void setRdvDateProchaine(Date var1) {
      this.rdvDateProchaine = var1;
   }

   public String getRdvDelais() {
      return this.rdvDelais;
   }

   public void setRdvDelais(String var1) {
      this.rdvDelais = var1;
   }

   public String getRdvModeFin() {
      return this.rdvModeFin;
   }

   public void setRdvModeFin(String var1) {
      this.rdvModeFin = var1;
   }

   public long getRdvIdPrincipalRdv() {
      return this.rdvIdPrincipalRdv;
   }

   public void setRdvIdPrincipalRdv(long var1) {
      this.rdvIdPrincipalRdv = var1;
   }

   public String getRdvConclusion() {
      return this.rdvConclusion;
   }

   public void setRdvConclusion(String var1) {
      this.rdvConclusion = var1;
   }
}
