package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PlanPaye implements Serializable {
   private long plpId;
   private Date plpDateCreat;
   private Date plpDateModif;
   private long plpUserCreat;
   private long plpUserModif;
   private String plpCode;
   private String plpCodeLie;
   private String plpLibelleFR;
   private String plpCommentaire;
   private String plpLibelleUK;
   private String plpLibelleSP;
   private int plpNature;
   private String plpLibelleNatureFR;
   private int plpSens;
   private int plpOption;
   private int plpProrataTemporis;
   private int plpGroupe;
   private int plpGroupeCp;
   private int plpInactif;
   private String plpCompteNormal;
   private String plpComptePrestataire;
   private String plpCpNormal;
   private String plpCpPrestataire;
   private int plpAnalytique;
   private int plpRan;
   private int plpProtege;
   private boolean plpBaseFiscale;
   private boolean plpBaseSociale;
   private boolean plpBaseAutre;
   private boolean plpBasePatronale;
   private boolean plpBaseConges;
   private float plpTauxFiscale;
   private float plpTauxSociale;
   private float plpTauxPatronal;
   private String plpFormuleFiscale;
   private String plpFormuleSociale;
   private String plpFormulePatronale;
   private boolean plpFacture;
   private String plpCalculBase;
   private String plpActivite;
   private ExercicesPaye exercicesPaye;
   private boolean afficheImag;
   private String etat;
   private boolean var_select;
   private String libelleNature;
   private String libelleSens;
   private String libelleOption;
   private String libelleGroupe;
   private String couleurImpot;

   public String getCouleurImpot() {
      if (this.plpCode != null && !this.plpCode.isEmpty()) {
         int var1 = Integer.parseInt(this.plpCode);
         if (var1 >= 109500 && var1 <= 109559) {
            this.couleurImpot = "color:magenta";
         } else if (var1 >= 109560 && var1 <= 109599) {
            this.couleurImpot = "color:blue";
         } else {
            this.couleurImpot = "color:black";
         }
      } else {
         this.couleurImpot = "color:black";
      }

      return this.couleurImpot;
   }

   public void setCouleurImpot(String var1) {
      this.couleurImpot = var1;
   }

   public String getLibelleGroupe() {
      if (this.plpCompteNormal != null && !this.plpCompteNormal.isEmpty()) {
         if (this.plpGroupe == 0) {
            this.libelleGroupe = "Groupé";
         } else if (this.plpGroupe == 1) {
            this.libelleGroupe = "Classement";
         } else if (this.plpGroupe == 2) {
            this.libelleGroupe = "Matricule";
         } else if (this.plpGroupe == 3) {
            this.libelleGroupe = "Nat/non nat.";
         } else if (this.plpGroupe == 4) {
            this.libelleGroupe = "Nat/non nat.+classement";
         } else if (this.plpGroupe == 5) {
            this.libelleGroupe = "???";
         } else if (this.plpGroupe == 6) {
            this.libelleGroupe = "???";
         } else if (this.plpGroupe == 7) {
            this.libelleGroupe = "Feuille";
         } else if (this.plpGroupe == 8) {
            this.libelleGroupe = "Centre Impôt";
         } else if (this.plpGroupe == 9) {
            this.libelleGroupe = "Service";
         }
      } else {
         this.libelleGroupe = "";
      }

      return this.libelleGroupe;
   }

   public void setLibelleGroupe(String var1) {
      this.libelleGroupe = var1;
   }

   public String getLibelleOption() {
      if (this.plpNature != 60 && this.plpNature != 61 && this.plpNature != 62 && this.plpNature != 90) {
         this.libelleOption = "";
      } else if (this.plpOption == 0) {
         this.libelleOption = "Mensuelle";
      } else if (this.plpOption == 1) {
         this.libelleOption = "Annuelle";
      } else if (this.plpOption == 2) {
         this.libelleOption = "Sans";
      }

      return this.libelleOption;
   }

   public void setLibelleOption(String var1) {
      this.libelleOption = var1;
   }

   public String getLibelleSens() {
      if (this.plpSens == 0) {
         this.libelleSens = "+";
      } else if (this.plpSens == 1) {
         this.libelleSens = "-";
      } else if (this.plpSens == 2) {
         this.libelleSens = "Calcul";
      } else if (this.plpSens == 3) {
         this.libelleSens = "Résultat";
      } else if (this.plpSens == 4) {
         this.libelleSens = "Non Cum.";
      }

      return this.libelleSens;
   }

   public void setLibelleSens(String var1) {
      this.libelleSens = var1;
   }

   public String getEtat() {
      if (this.plpInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.plpInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.plpInactif != 1 && this.plpInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getLibelleNature() {
      if (this.plpNature == 10) {
         this.libelleNature = "Eléments de base";
      } else if (this.plpNature == 11) {
         this.libelleNature = "Heures supplémentaires";
      } else if (this.plpNature == 20) {
         this.libelleNature = "Primes imposables";
      } else if (this.plpNature == 21) {
         this.libelleNature = "Indemnités imposables";
      } else if (this.plpNature == 25) {
         this.libelleNature = "Indemnités compensatrices";
      } else if (this.plpNature == 30) {
         this.libelleNature = "Retenues imposables";
      } else if (this.plpNature == 40) {
         this.libelleNature = "Congés";
      } else if (this.plpNature == 41) {
         this.libelleNature = "Licenciement";
      } else if (this.plpNature == 42) {
         this.libelleNature = "Primes fin d`année";
      } else if (this.plpNature == 50) {
         this.libelleNature = "Avantages en nature";
      } else if (this.plpNature == 59) {
         this.libelleNature = "Total brut";
      } else if (this.plpNature == 60) {
         this.libelleNature = "Impôts : charges fiscales";
      } else if (this.plpNature == 61) {
         this.libelleNature = "Impôts : charges sociales";
      } else if (this.plpNature == 62) {
         this.libelleNature = "Impôts : autres charges";
      } else if (this.plpNature == 69) {
         this.libelleNature = "Total net";
      } else if (this.plpNature == 70) {
         this.libelleNature = "Indemnités non imposables";
      } else if (this.plpNature == 80) {
         this.libelleNature = "Retenues non imposables";
      } else if (this.plpNature == 88) {
         this.libelleNature = "Appoints mensuels";
      } else if (this.plpNature == 89) {
         this.libelleNature = "Total net à payer";
      } else if (this.plpNature == 90) {
         this.libelleNature = "Charges patronales";
      } else if (this.plpNature == 99) {
         this.libelleNature = "Salaire à atteindre";
      }

      return this.libelleNature;
   }

   public void setLibelleNature(String var1) {
      this.libelleNature = var1;
   }

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public String getPlpCode() {
      return this.plpCode;
   }

   public void setPlpCode(String var1) {
      this.plpCode = var1;
   }

   public String getPlpCompteNormal() {
      return this.plpCompteNormal;
   }

   public void setPlpCompteNormal(String var1) {
      this.plpCompteNormal = var1;
   }

   public String getPlpComptePrestataire() {
      return this.plpComptePrestataire;
   }

   public void setPlpComptePrestataire(String var1) {
      this.plpComptePrestataire = var1;
   }

   public Date getPlpDateCreat() {
      return this.plpDateCreat;
   }

   public void setPlpDateCreat(Date var1) {
      this.plpDateCreat = var1;
   }

   public Date getPlpDateModif() {
      return this.plpDateModif;
   }

   public void setPlpDateModif(Date var1) {
      this.plpDateModif = var1;
   }

   public long getPlpId() {
      return this.plpId;
   }

   public void setPlpId(long var1) {
      this.plpId = var1;
   }

   public int getPlpInactif() {
      return this.plpInactif;
   }

   public void setPlpInactif(int var1) {
      this.plpInactif = var1;
   }

   public String getPlpLibelleFR() {
      return this.plpLibelleFR;
   }

   public void setPlpLibelleFR(String var1) {
      this.plpLibelleFR = var1;
   }

   public String getPlpLibelleNatureFR() {
      return this.plpLibelleNatureFR;
   }

   public void setPlpLibelleNatureFR(String var1) {
      this.plpLibelleNatureFR = var1;
   }

   public String getPlpLibelleSP() {
      return this.plpLibelleSP;
   }

   public void setPlpLibelleSP(String var1) {
      this.plpLibelleSP = var1;
   }

   public String getPlpLibelleUK() {
      return this.plpLibelleUK;
   }

   public void setPlpLibelleUK(String var1) {
      this.plpLibelleUK = var1;
   }

   public int getPlpNature() {
      return this.plpNature;
   }

   public void setPlpNature(int var1) {
      this.plpNature = var1;
   }

   public int getPlpSens() {
      return this.plpSens;
   }

   public void setPlpSens(int var1) {
      this.plpSens = var1;
   }

   public long getPlpUserCreat() {
      return this.plpUserCreat;
   }

   public void setPlpUserCreat(long var1) {
      this.plpUserCreat = var1;
   }

   public long getPlpUserModif() {
      return this.plpUserModif;
   }

   public void setPlpUserModif(long var1) {
      this.plpUserModif = var1;
   }

   public boolean isVar_select() {
      return this.var_select;
   }

   public void setVar_select(boolean var1) {
      this.var_select = var1;
   }

   public int getPlpGroupe() {
      return this.plpGroupe;
   }

   public void setPlpGroupe(int var1) {
      this.plpGroupe = var1;
   }

   public int getPlpOption() {
      return this.plpOption;
   }

   public void setPlpOption(int var1) {
      this.plpOption = var1;
   }

   public String getPlpCommentaire() {
      return this.plpCommentaire;
   }

   public void setPlpCommentaire(String var1) {
      this.plpCommentaire = var1;
   }

   public int getPlpAnalytique() {
      return this.plpAnalytique;
   }

   public void setPlpAnalytique(int var1) {
      this.plpAnalytique = var1;
   }

   public int getPlpRan() {
      return this.plpRan;
   }

   public void setPlpRan(int var1) {
      this.plpRan = var1;
   }

   public int getPlpProtege() {
      return this.plpProtege;
   }

   public void setPlpProtege(int var1) {
      this.plpProtege = var1;
   }

   public String getPlpCpNormal() {
      return this.plpCpNormal;
   }

   public void setPlpCpNormal(String var1) {
      this.plpCpNormal = var1;
   }

   public String getPlpCpPrestataire() {
      return this.plpCpPrestataire;
   }

   public void setPlpCpPrestataire(String var1) {
      this.plpCpPrestataire = var1;
   }

   public boolean isPlpBaseAutre() {
      return this.plpBaseAutre;
   }

   public void setPlpBaseAutre(boolean var1) {
      this.plpBaseAutre = var1;
   }

   public boolean isPlpBaseFiscale() {
      return this.plpBaseFiscale;
   }

   public void setPlpBaseFiscale(boolean var1) {
      this.plpBaseFiscale = var1;
   }

   public boolean isPlpBaseSociale() {
      return this.plpBaseSociale;
   }

   public void setPlpBaseSociale(boolean var1) {
      this.plpBaseSociale = var1;
   }

   public float getPlpTauxFiscale() {
      return this.plpTauxFiscale;
   }

   public void setPlpTauxFiscale(float var1) {
      this.plpTauxFiscale = var1;
   }

   public float getPlpTauxSociale() {
      return this.plpTauxSociale;
   }

   public void setPlpTauxSociale(float var1) {
      this.plpTauxSociale = var1;
   }

   public String getPlpFormuleFiscale() {
      return this.plpFormuleFiscale;
   }

   public void setPlpFormuleFiscale(String var1) {
      this.plpFormuleFiscale = var1;
   }

   public String getPlpFormuleSociale() {
      return this.plpFormuleSociale;
   }

   public void setPlpFormuleSociale(String var1) {
      this.plpFormuleSociale = var1;
   }

   public boolean isPlpBasePatronale() {
      return this.plpBasePatronale;
   }

   public void setPlpBasePatronale(boolean var1) {
      this.plpBasePatronale = var1;
   }

   public String getPlpFormulePatronale() {
      return this.plpFormulePatronale;
   }

   public void setPlpFormulePatronale(String var1) {
      this.plpFormulePatronale = var1;
   }

   public float getPlpTauxPatronal() {
      return this.plpTauxPatronal;
   }

   public void setPlpTauxPatronal(float var1) {
      this.plpTauxPatronal = var1;
   }

   public boolean isPlpFacture() {
      return this.plpFacture;
   }

   public void setPlpFacture(boolean var1) {
      this.plpFacture = var1;
   }

   public int getPlpProrataTemporis() {
      return this.plpProrataTemporis;
   }

   public void setPlpProrataTemporis(int var1) {
      this.plpProrataTemporis = var1;
   }

   public String getPlpCalculBase() {
      return this.plpCalculBase;
   }

   public void setPlpCalculBase(String var1) {
      this.plpCalculBase = var1;
   }

   public int getPlpGroupeCp() {
      return this.plpGroupeCp;
   }

   public void setPlpGroupeCp(int var1) {
      this.plpGroupeCp = var1;
   }

   public boolean isPlpBaseConges() {
      return this.plpBaseConges;
   }

   public void setPlpBaseConges(boolean var1) {
      this.plpBaseConges = var1;
   }

   public String getPlpCodeLie() {
      return this.plpCodeLie;
   }

   public void setPlpCodeLie(String var1) {
      this.plpCodeLie = var1;
   }

   public String getPlpActivite() {
      return this.plpActivite;
   }

   public void setPlpActivite(String var1) {
      this.plpActivite = var1;
   }
}
