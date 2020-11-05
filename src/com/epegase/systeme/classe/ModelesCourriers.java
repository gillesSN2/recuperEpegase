package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ModelesCourriers implements Serializable {
   private long modId;
   private Date modDateCreat;
   private Date modDateModif;
   private long modUserCreat;
   private long modUserModif;
   private String modCode;
   private String modNomFr;
   private String modNomUk;
   private String modNomSp;
   private int modInactif;
   private int modNature;
   private int modType;
   private String modTexte;
   private String modOption;
   private String modConditionPaiement;
   private int modAccessoire;
   private int modAcompte;
   private float modTauxAcompte;
   private int modAmortissement;
   private float modTauxAmortissement;
   private int modFraisFinancier;
   private float modTauxFraisFinancier;
   private int modContratEntretien;
   private float modTauxContratEntretien;
   private int modAssurance;
   private float modTauxAssurance;
   private int modFranchise;
   private float modTauxFranchise;
   private int modFraisStructure;
   private float modTauxFraisStructure;
   private int modRemplacement;
   private float modTauxRemplacement;
   private int modRemplissage;
   private float modTauxRemplissage;
   private int modMarge;
   private float modTauxMarge;
   private int modValeurResiduelle;
   private float modTauxValeurResiduelle;
   private int modDureeMin;
   private int modDureeMax;
   private String lib_nature;
   private String lib_type;
   private boolean afficheImag;
   private String etat;

   public String getLib_nature() {
      if (this.modNature == 10) {
         this.lib_nature = "Modèle Mail";
      } else if (this.modNature == 20) {
         this.lib_nature = "Lettre accompagnement";
      } else if (this.modNature == 21) {
         this.lib_nature = "Annexe";
      } else if (this.modNature == 22) {
         this.lib_nature = "Correspondance";
      } else if (this.modNature == 25) {
         this.lib_nature = "Contrat";
      } else if (this.modNature == 82) {
         this.lib_nature = "Contrat";
      } else if (this.modNature == 83) {
         this.lib_nature = "Attestation";
      } else if (this.modNature == 84) {
         this.lib_nature = "Cursus";
      } else if (this.modNature == 85) {
         this.lib_nature = "Certificat";
      } else if (this.modNature == 86) {
         this.lib_nature = "Correspondance";
      }

      return this.lib_nature;
   }

   public void setLib_nature(String var1) {
      this.lib_nature = var1;
   }

   public String getLib_type() {
      if (this.modNature <= 24) {
         this.lib_type = "";
      } else if (this.modNature == 25) {
         if (this.modType == 0) {
            this.lib_type = "Contrat vente";
         } else if (this.modType == 1) {
            this.lib_type = "Contrat leasing";
         } else if (this.modType == 2) {
            this.lib_type = "Contrat de garanti";
         } else if (this.modType == 3) {
            this.lib_type = "Contrat de formation";
         } else if (this.modType == 4) {
            this.lib_type = "Contrat de location";
         } else if (this.modType == 5) {
            this.lib_type = "Contrat de gérance";
         } else if (this.modType == 20) {
            this.lib_type = "Contrat de maintenance";
         } else if (this.modType == 21) {
            this.lib_type = "Contrat d'assistance";
         } else if (this.modType == 22) {
            this.lib_type = "Contrat d'abonnement";
         } else if (this.modType == 23) {
            this.lib_type = "Contrat de sauvegarde";
         } else if (this.modType == 99) {
            this.lib_type = "Autre Contrat";
         }
      } else if (this.modType == 1) {
         this.lib_type = "Accident de travail";
      } else if (this.modType == 30) {
         this.lib_type = "Centre d`intérets";
      } else if (this.modType == 11) {
         this.lib_type = "Dotation en équipement";
      } else if (this.modType == 12) {
         this.lib_type = "Dotation en mobilier";
      } else if (this.modType == 16) {
         this.lib_type = "Liste des conjoint(e)";
      } else if (this.modType == 15) {
         this.lib_type = "Liste des enfants à charge";
      } else if (this.modType == 30) {
         this.lib_type = "Centre d`intéret";
      } else if (this.modType == 31) {
         this.lib_type = "Loisir";
      } else if (this.modType == 17) {
         this.lib_type = "Mission";
      } else if (this.modType == 18) {
         this.lib_type = "Personne à prévenir";
      } else if (this.modType == 25) {
         this.lib_type = "Renouvellement documents";
      } else if (this.modType == 28) {
         this.lib_type = "Visite médicale";
      } else if (this.modType == 99) {
         this.lib_type = "Autre environnement";
      } else if (this.modType == 83) {
         this.lib_type = "ATTESTATION";
      } else if (this.modType == 8300) {
         this.lib_type = "de congés";
      } else if (this.modType == 8301) {
         this.lib_type = "de logement";
      } else if (this.modType == 8302) {
         this.lib_type = "d`emploi";
      } else if (this.modType == 8303) {
         this.lib_type = "Attestation de non endettement";
      } else if (this.modType == 8399) {
         this.lib_type = "Autre attestation";
      } else if (this.modType == 84) {
         this.lib_type = "CURSUS";
      } else if (this.modType == 8400) {
         this.lib_type = "Affectation - Mutation";
      } else if (this.modType == 8401) {
         this.lib_type = "Diplôme";
      } else if (this.modType == 8402) {
         this.lib_type = "Fiche du poste";
      } else if (this.modType == 8403) {
         this.lib_type = "Fiche Notation – Évaluation";
      } else if (this.modType == 8404) {
         this.lib_type = "Qualification : Niveau scolaire";
      } else if (this.modType == 8405) {
         this.lib_type = "Qualification : Expérience professionnelle";
      } else if (this.modType == 8406) {
         this.lib_type = "Qualification : Formation initiale";
      } else if (this.modType == 8407) {
         this.lib_type = "Qualification : Formation sécurité";
      } else if (this.modType == 8408) {
         this.lib_type = "Qualification : Langues maîtrisées";
      } else if (this.modType == 8409) {
         this.lib_type = "Qualification : Renforcement des capacités/Stages";
      } else if (this.modType == 8410) {
         this.lib_type = "Curriculum vitae";
      } else if (this.modType == 85) {
         this.lib_type = "CERTIFICAT";
      } else if (this.modType == 8500) {
         this.lib_type = "d`embauche";
      } else if (this.modType == 8501) {
         this.lib_type = "de travail";
      } else if (this.modType == 8502) {
         this.lib_type = "de cessation de travail";
      } else if (this.modType == 8503) {
         this.lib_type = "d`aptitude";
      } else if (this.modType == 8504) {
         this.lib_type = "de stage";
      } else if (this.modType == 8505) {
         this.lib_type = "d`obtention de diplôme";
      } else if (this.modType == 8506) {
         this.lib_type = "Certificat médical";
      } else if (this.modType == 8599) {
         this.lib_type = "Autre certificat";
      } else if (this.modType == 86) {
         this.lib_type = "CORRESPODANCE";
      } else if (this.modType == 8600) {
         this.lib_type = "Accord de congés";
      } else if (this.modType == 8601) {
         this.lib_type = "Avertissement";
      } else if (this.modType == 8602) {
         this.lib_type = "Congés pour formation";
      } else if (this.modType == 8603) {
         this.lib_type = "Congés pour maternité";
      } else if (this.modType == 8604) {
         this.lib_type = "Condamnation";
      } else if (this.modType == 8605) {
         this.lib_type = "Demande d`explications";
      } else if (this.modType == 8606) {
         this.lib_type = "Distinction";
      } else if (this.modType == 8607) {
         this.lib_type = "Félicitation";
      } else if (this.modType == 8608) {
         this.lib_type = "Note de service";
      } else if (this.modType == 8609) {
         this.lib_type = "Notification d`accident de travail (Organismes sociaux)";
      } else if (this.modType == 8610) {
         this.lib_type = "Notification d`augmentation de salaire";
      } else if (this.modType == 8611) {
         this.lib_type = "Notification de départ à la retraite (Organismes sociaux)";
      } else if (this.modType == 8612) {
         this.lib_type = "Notification de départ à la retraite (salarié)";
      } else if (this.modType == 8613) {
         this.lib_type = "Notification de licenciement";
      } else if (this.modType == 8614) {
         this.lib_type = "Notification de mise à pied";
      } else if (this.modType == 8615) {
         this.lib_type = "Ordre de virement";
      } else if (this.modType == 8616) {
         this.lib_type = "Passation de service";
      } else if (this.modType == 8617) {
         this.lib_type = "Sanction";
      } else if (this.modType == 8618) {
         this.lib_type = "Suspension";
      } else if (this.modType == 8699) {
         this.lib_type = "Autre correspondance";
      }

      return this.lib_type;
   }

   public void setLib_type(String var1) {
      this.lib_type = var1;
   }

   public String getEtat() {
      if (this.modInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.modInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.modInactif != 1 && this.modInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getModCode() {
      if (this.modCode != null && !this.modCode.isEmpty()) {
         this.modCode = this.modCode.toUpperCase();
      }

      return this.modCode;
   }

   public void setModCode(String var1) {
      this.modCode = var1;
   }

   public Date getModDateCreat() {
      return this.modDateCreat;
   }

   public void setModDateCreat(Date var1) {
      this.modDateCreat = var1;
   }

   public Date getModDateModif() {
      return this.modDateModif;
   }

   public void setModDateModif(Date var1) {
      this.modDateModif = var1;
   }

   public long getModId() {
      return this.modId;
   }

   public void setModId(long var1) {
      this.modId = var1;
   }

   public int getModInactif() {
      return this.modInactif;
   }

   public void setModInactif(int var1) {
      this.modInactif = var1;
   }

   public int getModNature() {
      return this.modNature;
   }

   public void setModNature(int var1) {
      this.modNature = var1;
   }

   public String getModNomFr() {
      if (this.modNomFr != null && !this.modNomFr.isEmpty()) {
         this.modNomFr = this.modNomFr.toUpperCase();
      }

      return this.modNomFr;
   }

   public void setModNomFr(String var1) {
      this.modNomFr = var1;
   }

   public String getModNomSp() {
      return this.modNomSp;
   }

   public void setModNomSp(String var1) {
      this.modNomSp = var1;
   }

   public String getModNomUk() {
      return this.modNomUk;
   }

   public void setModNomUk(String var1) {
      this.modNomUk = var1;
   }

   public int getModType() {
      return this.modType;
   }

   public void setModType(int var1) {
      this.modType = var1;
   }

   public long getModUserCreat() {
      return this.modUserCreat;
   }

   public void setModUserCreat(long var1) {
      this.modUserCreat = var1;
   }

   public long getModUserModif() {
      return this.modUserModif;
   }

   public void setModUserModif(long var1) {
      this.modUserModif = var1;
   }

   public String getModTexte() {
      return this.modTexte;
   }

   public void setModTexte(String var1) {
      this.modTexte = var1;
   }

   public int getModAmortissement() {
      return this.modAmortissement;
   }

   public void setModAmortissement(int var1) {
      this.modAmortissement = var1;
   }

   public int getModAssurance() {
      return this.modAssurance;
   }

   public void setModAssurance(int var1) {
      this.modAssurance = var1;
   }

   public int getModContratEntretien() {
      return this.modContratEntretien;
   }

   public void setModContratEntretien(int var1) {
      this.modContratEntretien = var1;
   }

   public int getModFraisFinancier() {
      return this.modFraisFinancier;
   }

   public void setModFraisFinancier(int var1) {
      this.modFraisFinancier = var1;
   }

   public int getModFraisStructure() {
      return this.modFraisStructure;
   }

   public void setModFraisStructure(int var1) {
      this.modFraisStructure = var1;
   }

   public int getModFranchise() {
      return this.modFranchise;
   }

   public void setModFranchise(int var1) {
      this.modFranchise = var1;
   }

   public int getModMarge() {
      return this.modMarge;
   }

   public void setModMarge(int var1) {
      this.modMarge = var1;
   }

   public int getModRemplacement() {
      return this.modRemplacement;
   }

   public void setModRemplacement(int var1) {
      this.modRemplacement = var1;
   }

   public int getModRemplissage() {
      return this.modRemplissage;
   }

   public void setModRemplissage(int var1) {
      this.modRemplissage = var1;
   }

   public float getModTauxAmortissement() {
      return this.modTauxAmortissement;
   }

   public void setModTauxAmortissement(float var1) {
      this.modTauxAmortissement = var1;
   }

   public float getModTauxAssurance() {
      return this.modTauxAssurance;
   }

   public void setModTauxAssurance(float var1) {
      this.modTauxAssurance = var1;
   }

   public float getModTauxContratEntretien() {
      return this.modTauxContratEntretien;
   }

   public void setModTauxContratEntretien(float var1) {
      this.modTauxContratEntretien = var1;
   }

   public float getModTauxFraisFinancier() {
      return this.modTauxFraisFinancier;
   }

   public void setModTauxFraisFinancier(float var1) {
      this.modTauxFraisFinancier = var1;
   }

   public float getModTauxFraisStructure() {
      return this.modTauxFraisStructure;
   }

   public void setModTauxFraisStructure(float var1) {
      this.modTauxFraisStructure = var1;
   }

   public float getModTauxFranchise() {
      return this.modTauxFranchise;
   }

   public void setModTauxFranchise(float var1) {
      this.modTauxFranchise = var1;
   }

   public float getModTauxMarge() {
      return this.modTauxMarge;
   }

   public void setModTauxMarge(float var1) {
      this.modTauxMarge = var1;
   }

   public float getModTauxRemplacement() {
      return this.modTauxRemplacement;
   }

   public void setModTauxRemplacement(float var1) {
      this.modTauxRemplacement = var1;
   }

   public float getModTauxRemplissage() {
      return this.modTauxRemplissage;
   }

   public void setModTauxRemplissage(float var1) {
      this.modTauxRemplissage = var1;
   }

   public int getModAccessoire() {
      return this.modAccessoire;
   }

   public void setModAccessoire(int var1) {
      this.modAccessoire = var1;
   }

   public int getModAcompte() {
      return this.modAcompte;
   }

   public void setModAcompte(int var1) {
      this.modAcompte = var1;
   }

   public int getModDureeMax() {
      return this.modDureeMax;
   }

   public void setModDureeMax(int var1) {
      this.modDureeMax = var1;
   }

   public int getModDureeMin() {
      return this.modDureeMin;
   }

   public void setModDureeMin(int var1) {
      this.modDureeMin = var1;
   }

   public float getModTauxAcompte() {
      return this.modTauxAcompte;
   }

   public void setModTauxAcompte(float var1) {
      this.modTauxAcompte = var1;
   }

   public float getModTauxValeurResiduelle() {
      return this.modTauxValeurResiduelle;
   }

   public void setModTauxValeurResiduelle(float var1) {
      this.modTauxValeurResiduelle = var1;
   }

   public int getModValeurResiduelle() {
      return this.modValeurResiduelle;
   }

   public void setModValeurResiduelle(int var1) {
      this.modValeurResiduelle = var1;
   }

   public String getModConditionPaiement() {
      return this.modConditionPaiement;
   }

   public void setModConditionPaiement(String var1) {
      this.modConditionPaiement = var1;
   }

   public String getModOption() {
      return this.modOption;
   }

   public void setModOption(String var1) {
      this.modOption = var1;
   }
}
