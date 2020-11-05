package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class SalariesGrh implements Serializable {
   private long salgrhId;
   private Date salgrhDateCreat;
   private Date salgrhDateModif;
   private long salgrhUserCreat;
   private long salgrhUserModif;
   private String salgrhNum;
   private int salgrhNature;
   private Date salgrhDate;
   private String salgrhObjet;
   private Date salgrhDateAlerte;
   private String salgrhTexte;
   private String salgrhResponsable;
   private String salgrhLieu;
   private String salgrhService;
   private int salgrhType;
   private int salgrhDotation;
   private Date salgrhDateFin;
   private String salgrhFonction;
   private String salgrhCategorie;
   private String salgrhActivite;
   private int salgrhEval1;
   private int salgrhEval2;
   private int salgrhEval3;
   private int salgrhEval4;
   private int salgrhEval5;
   private int salgrhEval6;
   private int salgrhEval7;
   private int salgrhEval8;
   private int salgrhEval9;
   private int salgrhEval10;
   private int salgrhEval11;
   private int salgrhEval12;
   private int salgrhTotEval;
   private int salgrhTravail;
   private int salgrhGenre;
   private int salgrhFiscal;
   private int salgrhNiveauScolaire;
   private int salgrhDuree;
   private double salgrhCout;
   private int salgrhSuspension;
   private int salgrhMedical;
   private String salgrhGroupeSanguin;
   private String salgrhFeuilleOld;
   private String salgrhFeuille;
   private String salgrhSerie;
   private String salgrhTaille;
   private String salgrhCouleur;
   private int salgrhQte;
   private int salgrhEtatVal;
   private int salgrhEtat;
   private Date salgrhDateValide;
   private int salgrhPosSignature;
   private Date salgrhDateImp;
   private int salgrhQualite;
   private String salgrhLangue;
   private int salgrhLangueLu;
   private int salgrhLangueParle;
   private int salgrhLangueEcrit;
   private String salgrhAppreciation;
   private String salgrhProbleme;
   private int salgrhMissionOrigine;
   private String salgrhDocument;
   private int salgrhHeure;
   private int salgrhMinute;
   private Date salgrhDateDeclaration;
   private String salgrhCirconstance;
   private String salgrhTemoins;
   private String salgrhRapportMedical;
   private String salgrhTempsIndisponibilite;
   private String salgrhNatureAccident;
   private String salgrhMotif;
   private String salgrhNatureLesions;
   private String salgrhSiegeLesions;
   private String salgrhCauseAccident;
   private String salgrhMedecinAccident;
   private String salgrhNomDeclarant;
   private int salgrhSuiteAccident;
   private String salgrhNumFiscal;
   private String salgrhNomJf;
   private String salgrhEmployeurNom;
   private String salgrhEmployeurAdresse;
   private String salgrhEmployeurBp;
   private String salgrhEmployeurVille;
   private String salgrhEmployeurTel;
   private String salgrhEmployeurFonction;
   private Salaries salaries;
   private String lib_nature;
   private String lib_type;
   private String libelleEtat;
   private String libLangueLu;
   private String libLangueEcrit;
   private String libLangueParle;
   private String libQualiteExperience;
   private String libReference;
   private String libDescription;
   private boolean rhSelect;
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

   public String getLib_type() {
      if (this.salgrhType == 1) {
         this.lib_type = "Accident de travail";
      } else if (this.salgrhType == 30) {
         this.lib_type = "Centre d`intérets";
      } else if (this.salgrhType == 11) {
         this.lib_type = "Dotation en équipement";
      } else if (this.salgrhType == 12) {
         this.lib_type = "Dotation en mobilier";
      } else if (this.salgrhType == 16) {
         this.lib_type = "Liste des conjoint(e)";
      } else if (this.salgrhType == 15) {
         this.lib_type = "Liste des enfants à charge";
      } else if (this.salgrhType == 31) {
         this.lib_type = "Loisir";
      } else if (this.salgrhType == 17) {
         this.lib_type = "Mission";
      } else if (this.salgrhType == 18) {
         this.lib_type = "Personne à prévenir";
      } else if (this.salgrhType == 25) {
         this.lib_type = "Renouvellement documents";
      } else if (this.salgrhType == 28) {
         this.lib_type = "Visite médicale";
      } else if (this.salgrhType == 83) {
         this.lib_type = "libre";
      } else if (this.salgrhType == 8300) {
         this.lib_type = "de congés";
      } else if (this.salgrhType == 8301) {
         this.lib_type = "de logement";
      } else if (this.salgrhType == 8302) {
         this.lib_type = "d`emploi";
      } else if (this.salgrhType == 8303) {
         this.lib_type = "autre";
      } else if (this.salgrhType == 84) {
         this.lib_type = "Cursus";
      } else if (this.salgrhType == 8400) {
         this.lib_type = "Affectation - Mutation";
      } else if (this.salgrhType == 8401) {
         this.lib_type = "Diplôme";
      } else if (this.salgrhType == 8402) {
         this.lib_type = "Fiche du poste";
      } else if (this.salgrhType == 8403) {
         this.lib_type = "Fiche Notation – Évaluation";
      } else if (this.salgrhType == 8404) {
         this.lib_type = "Qualification : Niveau scolaire";
      } else if (this.salgrhType == 8405) {
         this.lib_type = "Qualification : Expérience professionnelle";
      } else if (this.salgrhType == 8406) {
         this.lib_type = "Qualification : Formation initiale";
      } else if (this.salgrhType == 8407) {
         this.lib_type = "Qualification : Formation sécurité";
      } else if (this.salgrhType == 8408) {
         this.lib_type = "Qualification : Langues maîtrisées";
      } else if (this.salgrhType == 8409) {
         this.lib_type = "Qualification : Renforcement des capacités/Stages";
      } else if (this.salgrhType == 8410) {
         this.lib_type = "Curriculum vitae";
      } else if (this.salgrhType == 85) {
         this.lib_type = "Certificat";
      } else if (this.salgrhType == 8500) {
         this.lib_type = "d`embauche";
      } else if (this.salgrhType == 8501) {
         this.lib_type = "de travail";
      } else if (this.salgrhType == 8502) {
         this.lib_type = "de cessation de travail";
      } else if (this.salgrhType == 8503) {
         this.lib_type = "d`aptitude";
      } else if (this.salgrhType == 8504) {
         this.lib_type = "de stage";
      } else if (this.salgrhType == 8505) {
         this.lib_type = "d`obtention de diplôme";
      } else if (this.salgrhType == 8506) {
         this.lib_type = "autre";
      } else if (this.salgrhType == 86) {
         this.lib_type = "Correspondance";
      } else if (this.salgrhType == 8600) {
         this.lib_type = "Accord de congés";
      } else if (this.salgrhType == 8601) {
         this.lib_type = "Avertissement";
      } else if (this.salgrhType == 8602) {
         this.lib_type = "Congés pour formation";
      } else if (this.salgrhType == 8603) {
         this.lib_type = "Congés pour maternité";
      } else if (this.salgrhType == 8604) {
         this.lib_type = "Condamnation";
      } else if (this.salgrhType == 8605) {
         this.lib_type = "Demande d`explications";
      } else if (this.salgrhType == 8606) {
         this.lib_type = "Distinction";
      } else if (this.salgrhType == 8607) {
         this.lib_type = "Félicitation";
      } else if (this.salgrhType == 8608) {
         this.lib_type = "Note de service";
      } else if (this.salgrhType == 8609) {
         this.lib_type = "Notification d`accident de travail (Organismes sociaux)";
      } else if (this.salgrhType == 8610) {
         this.lib_type = "Notification d`augmentation de salaire";
      } else if (this.salgrhType == 8611) {
         this.lib_type = "Notification de départ à la retraite (Organismes sociaux)";
      } else if (this.salgrhType == 8612) {
         this.lib_type = "Notification de départ à la retraite (salarié)";
      } else if (this.salgrhType == 8613) {
         this.lib_type = "Notification de licenciement";
      } else if (this.salgrhType == 8614) {
         this.lib_type = "Notification de mise à pied";
      } else if (this.salgrhType == 8615) {
         this.lib_type = "Ordre de virement";
      } else if (this.salgrhType == 8616) {
         this.lib_type = "Passation de service";
      } else if (this.salgrhType == 8617) {
         this.lib_type = "Sanction";
      } else if (this.salgrhType == 8618) {
         this.lib_type = "Suspension";
      }

      return this.lib_type;
   }

   public void setLib_type(String var1) {
      this.lib_type = var1;
   }

   public String getLib_nature() {
      if (this.salgrhNature == 0) {
         this.lib_nature = "Environnement Agent";
      } else if (this.salgrhNature == 83) {
         this.lib_nature = "Attestation";
      } else if (this.salgrhNature == 84) {
         this.lib_nature = "Cursus";
      } else if (this.salgrhNature == 85) {
         this.lib_nature = "Certificat";
      } else if (this.salgrhNature == 86) {
         this.lib_nature = "Correspondance";
      } else {
         this.lib_nature = "Environnement Agent";
      }

      return this.lib_nature;
   }

   public void setLib_nature(String var1) {
      this.lib_nature = var1;
   }

   public String getLibelleEtat() {
      if (this.salgrhEtat == 0) {
         this.libelleEtat = "N.Val.";
      } else if (this.salgrhEtat == 1) {
         this.libelleEtat = "Val.";
      } else if (this.salgrhEtat == 2) {
         this.libelleEtat = "Gel.";
      } else if (this.salgrhEtat == 3) {
         this.libelleEtat = "Annul.";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public String getLibLangueEcrit() {
      if (this.salgrhLangueEcrit == 0) {
         this.libLangueEcrit = "Non";
      } else if (this.salgrhLangueEcrit == 1) {
         this.libLangueEcrit = "Passable";
      } else if (this.salgrhLangueEcrit == 2) {
         this.libLangueEcrit = "Correct";
      } else if (this.salgrhLangueEcrit == 3) {
         this.libLangueEcrit = "Excellent";
      } else if (this.salgrhLangueEcrit == 4) {
         this.libLangueEcrit = "Interprête";
      }

      return this.libLangueEcrit;
   }

   public void setLibLangueEcrit(String var1) {
      this.libLangueEcrit = var1;
   }

   public String getLibLangueLu() {
      if (this.salgrhLangueLu == 0) {
         this.libLangueLu = "Non";
      } else if (this.salgrhLangueLu == 1) {
         this.libLangueLu = "Passable";
      } else if (this.salgrhLangueLu == 2) {
         this.libLangueLu = "Correct";
      } else if (this.salgrhLangueLu == 3) {
         this.libLangueLu = "Excellent";
      } else if (this.salgrhLangueLu == 4) {
         this.libLangueLu = "Interprête";
      }

      return this.libLangueLu;
   }

   public void setLibLangueLu(String var1) {
      this.libLangueLu = var1;
   }

   public String getLibLangueParle() {
      if (this.salgrhLangueParle == 0) {
         this.libLangueParle = "Non";
      } else if (this.salgrhLangueParle == 1) {
         this.libLangueParle = "Passable";
      } else if (this.salgrhLangueParle == 2) {
         this.libLangueParle = "Correct";
      } else if (this.salgrhLangueParle == 3) {
         this.libLangueParle = "Excellent";
      } else if (this.salgrhLangueParle == 4) {
         this.libLangueParle = "Interprête";
      }

      return this.libLangueParle;
   }

   public void setLibLangueParle(String var1) {
      this.libLangueParle = var1;
   }

   public String getLibQualiteExperience() {
      if (this.salgrhQualite == 0) {
         this.libQualiteExperience = "Stagiaire/débutant";
      } else if (this.salgrhQualite == 1) {
         this.libQualiteExperience = "Junior";
      } else if (this.salgrhQualite == 2) {
         this.libQualiteExperience = "Junior Confirmé";
      } else if (this.salgrhQualite == 3) {
         this.libQualiteExperience = "Sénior";
      } else if (this.salgrhQualite == 4) {
         this.libQualiteExperience = "Sénior Expérimenté";
      }

      return this.libQualiteExperience;
   }

   public void setLibQualiteExperience(String var1) {
      this.libQualiteExperience = var1;
   }

   public String getLibReference() {
      if (this.salgrhNature == 34) {
         this.libReference = this.salgrhLangue;
      } else {
         this.libReference = this.salgrhNum;
      }

      return this.libReference;
   }

   public void setLibReference(String var1) {
      this.libReference = var1;
   }

   public String getLibDescription() {
      this.libDescription = "";
      if (this.salgrhNature == 34) {
         if (this.salgrhLangueLu == 0) {
            this.libDescription = "Lu : non";
         } else if (this.salgrhLangueLu == 1) {
            this.libDescription = "Lu : passable";
         } else if (this.salgrhLangueLu == 2) {
            this.libDescription = "Lu : correct";
         } else if (this.salgrhLangueLu == 3) {
            this.libDescription = "Lu : excellent";
         } else if (this.salgrhLangueLu == 4) {
            this.libDescription = "Lu : interprête";
         }

         if (this.salgrhLangueEcrit == 0) {
            this.libDescription = this.libDescription + ", Ecrit : non";
         } else if (this.salgrhLangueEcrit == 1) {
            this.libDescription = this.libDescription + ", Ecrit : passable";
         } else if (this.salgrhLangueEcrit == 2) {
            this.libDescription = this.libDescription + ", Ecrit : correct";
         } else if (this.salgrhLangueEcrit == 3) {
            this.libDescription = this.libDescription + ", Ecrit : excellent";
         } else if (this.salgrhLangueEcrit == 4) {
            this.libDescription = this.libDescription + ", Ecrit : interprête";
         }

         if (this.salgrhLangueParle == 0) {
            this.libDescription = this.libDescription + ", Parlé : non";
         } else if (this.salgrhLangueParle == 1) {
            this.libDescription = this.libDescription + ", Parlé : passable";
         } else if (this.salgrhLangueParle == 2) {
            this.libDescription = this.libDescription + ", Parlé : correct";
         } else if (this.salgrhLangueParle == 3) {
            this.libDescription = this.libDescription + ", Parlé : excellent";
         } else if (this.salgrhLangueParle == 4) {
            this.libDescription = this.libDescription + ", Parlé : interprête";
         }
      } else {
         this.libDescription = this.salgrhObjet;
      }

      return this.libDescription;
   }

   public void setLibDescription(String var1) {
      this.libDescription = var1;
   }

   public boolean isRhSelect() {
      return this.rhSelect;
   }

   public void setRhSelect(boolean var1) {
      this.rhSelect = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public String getSalgrhActivite() {
      return this.salgrhActivite;
   }

   public void setSalgrhActivite(String var1) {
      this.salgrhActivite = var1;
   }

   public String getSalgrhCategorie() {
      return this.salgrhCategorie;
   }

   public void setSalgrhCategorie(String var1) {
      this.salgrhCategorie = var1;
   }

   public Date getSalgrhDate() {
      return this.salgrhDate;
   }

   public void setSalgrhDate(Date var1) {
      this.salgrhDate = var1;
   }

   public Date getSalgrhDateCreat() {
      return this.salgrhDateCreat;
   }

   public void setSalgrhDateCreat(Date var1) {
      this.salgrhDateCreat = var1;
   }

   public Date getSalgrhDateFin() {
      return this.salgrhDateFin;
   }

   public void setSalgrhDateFin(Date var1) {
      this.salgrhDateFin = var1;
   }

   public Date getSalgrhDateModif() {
      return this.salgrhDateModif;
   }

   public void setSalgrhDateModif(Date var1) {
      this.salgrhDateModif = var1;
   }

   public int getSalgrhDuree() {
      return this.salgrhDuree;
   }

   public void setSalgrhDuree(int var1) {
      this.salgrhDuree = var1;
   }

   public int getSalgrhEval1() {
      return this.salgrhEval1;
   }

   public void setSalgrhEval1(int var1) {
      this.salgrhEval1 = var1;
   }

   public int getSalgrhEval2() {
      return this.salgrhEval2;
   }

   public void setSalgrhEval2(int var1) {
      this.salgrhEval2 = var1;
   }

   public int getSalgrhEval3() {
      return this.salgrhEval3;
   }

   public void setSalgrhEval3(int var1) {
      this.salgrhEval3 = var1;
   }

   public int getSalgrhEval4() {
      return this.salgrhEval4;
   }

   public void setSalgrhEval4(int var1) {
      this.salgrhEval4 = var1;
   }

   public int getSalgrhEval5() {
      return this.salgrhEval5;
   }

   public void setSalgrhEval5(int var1) {
      this.salgrhEval5 = var1;
   }

   public int getSalgrhEval6() {
      return this.salgrhEval6;
   }

   public void setSalgrhEval6(int var1) {
      this.salgrhEval6 = var1;
   }

   public String getSalgrhFonction() {
      return this.salgrhFonction;
   }

   public void setSalgrhFonction(String var1) {
      this.salgrhFonction = var1;
   }

   public int getSalgrhGenre() {
      return this.salgrhGenre;
   }

   public void setSalgrhGenre(int var1) {
      this.salgrhGenre = var1;
   }

   public String getSalgrhGroupeSanguin() {
      return this.salgrhGroupeSanguin;
   }

   public void setSalgrhGroupeSanguin(String var1) {
      this.salgrhGroupeSanguin = var1;
   }

   public long getSalgrhId() {
      return this.salgrhId;
   }

   public void setSalgrhId(long var1) {
      this.salgrhId = var1;
   }

   public String getSalgrhLieu() {
      return this.salgrhLieu;
   }

   public void setSalgrhLieu(String var1) {
      this.salgrhLieu = var1;
   }

   public int getSalgrhMedical() {
      return this.salgrhMedical;
   }

   public void setSalgrhMedical(int var1) {
      this.salgrhMedical = var1;
   }

   public int getSalgrhNature() {
      return this.salgrhNature;
   }

   public void setSalgrhNature(int var1) {
      this.salgrhNature = var1;
   }

   public int getSalgrhNiveauScolaire() {
      return this.salgrhNiveauScolaire;
   }

   public void setSalgrhNiveauScolaire(int var1) {
      this.salgrhNiveauScolaire = var1;
   }

   public String getSalgrhNum() {
      return this.salgrhNum;
   }

   public void setSalgrhNum(String var1) {
      this.salgrhNum = var1;
   }

   public String getSalgrhObjet() {
      return this.salgrhObjet;
   }

   public void setSalgrhObjet(String var1) {
      this.salgrhObjet = var1;
   }

   public String getSalgrhResponsable() {
      return this.salgrhResponsable;
   }

   public void setSalgrhResponsable(String var1) {
      this.salgrhResponsable = var1;
   }

   public String getSalgrhService() {
      return this.salgrhService;
   }

   public void setSalgrhService(String var1) {
      this.salgrhService = var1;
   }

   public int getSalgrhSuspension() {
      return this.salgrhSuspension;
   }

   public void setSalgrhSuspension(int var1) {
      this.salgrhSuspension = var1;
   }

   public String getSalgrhTexte() {
      return this.salgrhTexte;
   }

   public void setSalgrhTexte(String var1) {
      this.salgrhTexte = var1;
   }

   public int getSalgrhTotEval() {
      return this.salgrhTotEval;
   }

   public void setSalgrhTotEval(int var1) {
      this.salgrhTotEval = var1;
   }

   public int getSalgrhTravail() {
      return this.salgrhTravail;
   }

   public void setSalgrhTravail(int var1) {
      this.salgrhTravail = var1;
   }

   public int getSalgrhType() {
      return this.salgrhType;
   }

   public void setSalgrhType(int var1) {
      this.salgrhType = var1;
   }

   public long getSalgrhUserCreat() {
      return this.salgrhUserCreat;
   }

   public void setSalgrhUserCreat(long var1) {
      this.salgrhUserCreat = var1;
   }

   public long getSalgrhUserModif() {
      return this.salgrhUserModif;
   }

   public void setSalgrhUserModif(long var1) {
      this.salgrhUserModif = var1;
   }

   public int getSalgrhQte() {
      return this.salgrhQte;
   }

   public void setSalgrhQte(int var1) {
      this.salgrhQte = var1;
   }

   public String getSalgrhFeuille() {
      return this.salgrhFeuille;
   }

   public void setSalgrhFeuille(String var1) {
      this.salgrhFeuille = var1;
   }

   public String getSalgrhSerie() {
      return this.salgrhSerie;
   }

   public void setSalgrhSerie(String var1) {
      this.salgrhSerie = var1;
   }

   public String getSalgrhCouleur() {
      return this.salgrhCouleur;
   }

   public void setSalgrhCouleur(String var1) {
      this.salgrhCouleur = var1;
   }

   public String getSalgrhTaille() {
      return this.salgrhTaille;
   }

   public void setSalgrhTaille(String var1) {
      this.salgrhTaille = var1;
   }

   public double getSalgrhCout() {
      return this.salgrhCout;
   }

   public void setSalgrhCout(double var1) {
      this.salgrhCout = var1;
   }

   public Date getSalgrhDateValide() {
      return this.salgrhDateValide;
   }

   public void setSalgrhDateValide(Date var1) {
      this.salgrhDateValide = var1;
   }

   public int getSalgrhEtat() {
      return this.salgrhEtat;
   }

   public void setSalgrhEtat(int var1) {
      this.salgrhEtat = var1;
   }

   public int getSalgrhEtatVal() {
      return this.salgrhEtatVal;
   }

   public void setSalgrhEtatVal(int var1) {
      this.salgrhEtatVal = var1;
   }

   public Date getSalgrhDateImp() {
      return this.salgrhDateImp;
   }

   public void setSalgrhDateImp(Date var1) {
      this.salgrhDateImp = var1;
   }

   public int getSalgrhEval10() {
      return this.salgrhEval10;
   }

   public void setSalgrhEval10(int var1) {
      this.salgrhEval10 = var1;
   }

   public int getSalgrhEval7() {
      return this.salgrhEval7;
   }

   public void setSalgrhEval7(int var1) {
      this.salgrhEval7 = var1;
   }

   public int getSalgrhEval8() {
      return this.salgrhEval8;
   }

   public void setSalgrhEval8(int var1) {
      this.salgrhEval8 = var1;
   }

   public int getSalgrhEval9() {
      return this.salgrhEval9;
   }

   public void setSalgrhEval9(int var1) {
      this.salgrhEval9 = var1;
   }

   public int getSalgrhQualite() {
      return this.salgrhQualite;
   }

   public void setSalgrhQualite(int var1) {
      this.salgrhQualite = var1;
   }

   public String getSalgrhLangue() {
      return this.salgrhLangue;
   }

   public void setSalgrhLangue(String var1) {
      this.salgrhLangue = var1;
   }

   public int getSalgrhLangueEcrit() {
      return this.salgrhLangueEcrit;
   }

   public void setSalgrhLangueEcrit(int var1) {
      this.salgrhLangueEcrit = var1;
   }

   public int getSalgrhLangueLu() {
      return this.salgrhLangueLu;
   }

   public void setSalgrhLangueLu(int var1) {
      this.salgrhLangueLu = var1;
   }

   public int getSalgrhLangueParle() {
      return this.salgrhLangueParle;
   }

   public void setSalgrhLangueParle(int var1) {
      this.salgrhLangueParle = var1;
   }

   public String getSalgrhAppreciation() {
      return this.salgrhAppreciation;
   }

   public void setSalgrhAppreciation(String var1) {
      this.salgrhAppreciation = var1;
   }

   public String getSalgrhProbleme() {
      return this.salgrhProbleme;
   }

   public void setSalgrhProbleme(String var1) {
      this.salgrhProbleme = var1;
   }

   public int getSalgrhMissionOrigine() {
      return this.salgrhMissionOrigine;
   }

   public void setSalgrhMissionOrigine(int var1) {
      this.salgrhMissionOrigine = var1;
   }

   public String getSalgrhDocument() {
      return this.salgrhDocument;
   }

   public void setSalgrhDocument(String var1) {
      this.salgrhDocument = var1;
   }

   public String getSalgrhCirconstance() {
      return this.salgrhCirconstance;
   }

   public void setSalgrhCirconstance(String var1) {
      this.salgrhCirconstance = var1;
   }

   public Date getSalgrhDateDeclaration() {
      return this.salgrhDateDeclaration;
   }

   public void setSalgrhDateDeclaration(Date var1) {
      this.salgrhDateDeclaration = var1;
   }

   public int getSalgrhHeure() {
      return this.salgrhHeure;
   }

   public void setSalgrhHeure(int var1) {
      this.salgrhHeure = var1;
   }

   public int getSalgrhMinute() {
      return this.salgrhMinute;
   }

   public void setSalgrhMinute(int var1) {
      this.salgrhMinute = var1;
   }

   public String getSalgrhNatureAccident() {
      return this.salgrhNatureAccident;
   }

   public void setSalgrhNatureAccident(String var1) {
      this.salgrhNatureAccident = var1;
   }

   public String getSalgrhRapportMedical() {
      return this.salgrhRapportMedical;
   }

   public void setSalgrhRapportMedical(String var1) {
      this.salgrhRapportMedical = var1;
   }

   public String getSalgrhTemoins() {
      return this.salgrhTemoins;
   }

   public void setSalgrhTemoins(String var1) {
      this.salgrhTemoins = var1;
   }

   public String getSalgrhTempsIndisponibilite() {
      return this.salgrhTempsIndisponibilite;
   }

   public void setSalgrhTempsIndisponibilite(String var1) {
      this.salgrhTempsIndisponibilite = var1;
   }

   public String getSalgrhMotif() {
      return this.salgrhMotif;
   }

   public void setSalgrhMotif(String var1) {
      this.salgrhMotif = var1;
   }

   public int getSalgrhEval11() {
      return this.salgrhEval11;
   }

   public void setSalgrhEval11(int var1) {
      this.salgrhEval11 = var1;
   }

   public int getSalgrhEval12() {
      return this.salgrhEval12;
   }

   public void setSalgrhEval12(int var1) {
      this.salgrhEval12 = var1;
   }

   public String getSalgrhFeuilleOld() {
      return this.salgrhFeuilleOld;
   }

   public void setSalgrhFeuilleOld(String var1) {
      this.salgrhFeuilleOld = var1;
   }

   public String getSalgrhCauseAccident() {
      return this.salgrhCauseAccident;
   }

   public void setSalgrhCauseAccident(String var1) {
      this.salgrhCauseAccident = var1;
   }

   public String getSalgrhMedecinAccident() {
      return this.salgrhMedecinAccident;
   }

   public void setSalgrhMedecinAccident(String var1) {
      this.salgrhMedecinAccident = var1;
   }

   public String getSalgrhNatureLesions() {
      return this.salgrhNatureLesions;
   }

   public void setSalgrhNatureLesions(String var1) {
      this.salgrhNatureLesions = var1;
   }

   public String getSalgrhNomDeclarant() {
      return this.salgrhNomDeclarant;
   }

   public void setSalgrhNomDeclarant(String var1) {
      this.salgrhNomDeclarant = var1;
   }

   public String getSalgrhSiegeLesions() {
      return this.salgrhSiegeLesions;
   }

   public void setSalgrhSiegeLesions(String var1) {
      this.salgrhSiegeLesions = var1;
   }

   public int getSalgrhSuiteAccident() {
      return this.salgrhSuiteAccident;
   }

   public void setSalgrhSuiteAccident(int var1) {
      this.salgrhSuiteAccident = var1;
   }

   public String getSalgrhEmployeurAdresse() {
      return this.salgrhEmployeurAdresse;
   }

   public void setSalgrhEmployeurAdresse(String var1) {
      this.salgrhEmployeurAdresse = var1;
   }

   public String getSalgrhEmployeurBp() {
      return this.salgrhEmployeurBp;
   }

   public void setSalgrhEmployeurBp(String var1) {
      this.salgrhEmployeurBp = var1;
   }

   public String getSalgrhEmployeurFonction() {
      return this.salgrhEmployeurFonction;
   }

   public void setSalgrhEmployeurFonction(String var1) {
      this.salgrhEmployeurFonction = var1;
   }

   public String getSalgrhEmployeurNom() {
      return this.salgrhEmployeurNom;
   }

   public void setSalgrhEmployeurNom(String var1) {
      this.salgrhEmployeurNom = var1;
   }

   public String getSalgrhEmployeurTel() {
      return this.salgrhEmployeurTel;
   }

   public void setSalgrhEmployeurTel(String var1) {
      this.salgrhEmployeurTel = var1;
   }

   public String getSalgrhEmployeurVille() {
      return this.salgrhEmployeurVille;
   }

   public void setSalgrhEmployeurVille(String var1) {
      this.salgrhEmployeurVille = var1;
   }

   public String getSalgrhNomJf() {
      return this.salgrhNomJf;
   }

   public void setSalgrhNomJf(String var1) {
      this.salgrhNomJf = var1;
   }

   public String getSalgrhNumFiscal() {
      return this.salgrhNumFiscal;
   }

   public void setSalgrhNumFiscal(String var1) {
      this.salgrhNumFiscal = var1;
   }

   public int getSalgrhPosSignature() {
      return this.salgrhPosSignature;
   }

   public void setSalgrhPosSignature(int var1) {
      this.salgrhPosSignature = var1;
   }

   public int getSalgrhFiscal() {
      return this.salgrhFiscal;
   }

   public void setSalgrhFiscal(int var1) {
      this.salgrhFiscal = var1;
   }

   public int getSalgrhDotation() {
      return this.salgrhDotation;
   }

   public void setSalgrhDotation(int var1) {
      this.salgrhDotation = var1;
   }

   public Date getSalgrhDateAlerte() {
      return this.salgrhDateAlerte;
   }

   public void setSalgrhDateAlerte(Date var1) {
      this.salgrhDateAlerte = var1;
   }
}
