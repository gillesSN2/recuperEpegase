package com.epegase.systeme.classe;

import java.io.Serializable;

public class Chrono implements Serializable {
   private long chrId;
   private int chrNature;
   private String chrSerie;
   private String chrNom;
   private int chrPrive;
   private String chrService;
   private int chrNbCar;
   private int chrMode;
   private int chrFormat;
   private String chrPrefixe;
   private long chrNum;
   private long chrNumAn;
   private long chrNum01;
   private long chrNum02;
   private long chrNum03;
   private long chrNum04;
   private long chrNum05;
   private long chrNum06;
   private long chrNum07;
   private long chrNum08;
   private long chrNum09;
   private long chrNum10;
   private long chrNum11;
   private long chrNum12;
   private String chrSufixe;
   private String chrJournal;
   private String chrJournalOd;
   private String chrCodeCaisse;
   private int chrModeCaisse;
   private String chrPeriode;
   private long chrNum_1;
   private long chrNumAn_1;
   private long chrNum01_1;
   private long chrNum02_1;
   private long chrNum03_1;
   private long chrNum04_1;
   private long chrNum05_1;
   private long chrNum06_1;
   private long chrNum07_1;
   private long chrNum08_1;
   private long chrNum09_1;
   private long chrNum10_1;
   private long chrNum11_1;
   private long chrNum12_1;
   private String chrPrefixe_1;
   private String chrSufixe_1;
   private long chrNum_2;
   private long chrNumAn_2;
   private long chrNum01_2;
   private long chrNum02_2;
   private long chrNum03_2;
   private long chrNum04_2;
   private long chrNum05_2;
   private long chrNum06_2;
   private long chrNum07_2;
   private long chrNum08_2;
   private long chrNum09_2;
   private long chrNum10_2;
   private long chrNum11_2;
   private long chrNum12_2;
   private String chrPrefixe_2;
   private String chrSufixe_2;
   private long chrNum_3;
   private long chrNumAn_3;
   private long chrNum01_3;
   private long chrNum02_3;
   private long chrNum03_3;
   private long chrNum04_3;
   private long chrNum05_3;
   private long chrNum06_3;
   private long chrNum07_3;
   private long chrNum08_3;
   private long chrNum09_3;
   private long chrNum10_3;
   private long chrNum11_3;
   private long chrNum12_3;
   private String chrPrefixe_3;
   private String chrSufixe_3;
   private long chrNum_4;
   private long chrNumAn_4;
   private long chrNum01_4;
   private long chrNum02_4;
   private long chrNum03_4;
   private long chrNum04_4;
   private long chrNum05_4;
   private long chrNum06_4;
   private long chrNum07_4;
   private long chrNum08_4;
   private long chrNum09_4;
   private long chrNum10_4;
   private long chrNum11_4;
   private long chrNum12_4;
   private String chrPrefixe_4;
   private String chrSufixe_4;
   private long chrNum_5;
   private long chrNumAn_5;
   private long chrNum01_5;
   private long chrNum02_5;
   private long chrNum03_5;
   private long chrNum04_5;
   private long chrNum05_5;
   private long chrNum06_5;
   private long chrNum07_5;
   private long chrNum08_5;
   private long chrNum09_5;
   private long chrNum10_5;
   private long chrNum11_5;
   private long chrNum12_5;
   private String chrPrefixe_5;
   private String chrSufixe_5;
   private long chrNum_6;
   private long chrNumAn_6;
   private long chrNum01_6;
   private long chrNum02_6;
   private long chrNum03_6;
   private long chrNum04_6;
   private long chrNum05_6;
   private long chrNum06_6;
   private long chrNum07_6;
   private long chrNum08_6;
   private long chrNum09_6;
   private long chrNum10_6;
   private long chrNum11_6;
   private long chrNum12_6;
   private String chrPrefixe_6;
   private String chrSufixe_6;
   private long chrNum_7;
   private long chrNumAn_7;
   private long chrNum01_7;
   private long chrNum02_7;
   private long chrNum03_7;
   private long chrNum04_7;
   private long chrNum05_7;
   private long chrNum06_7;
   private long chrNum07_7;
   private long chrNum08_7;
   private long chrNum09_7;
   private long chrNum10_7;
   private long chrNum11_7;
   private long chrNum12_7;
   private String chrPrefixe_7;
   private String chrSufixe_7;
   private long chrNum_8;
   private long chrNumAn_8;
   private long chrNum01_8;
   private long chrNum02_8;
   private long chrNum03_8;
   private long chrNum04_8;
   private long chrNum05_8;
   private long chrNum06_8;
   private long chrNum07_8;
   private long chrNum08_8;
   private long chrNum09_8;
   private long chrNum10_8;
   private long chrNum11_8;
   private long chrNum12_8;
   private String chrPrefixe_8;
   private String chrSufixe_8;
   private long chrNum_9;
   private long chrNumAn_9;
   private long chrNum01_9;
   private long chrNum02_9;
   private long chrNum03_9;
   private long chrNum04_9;
   private long chrNum05_9;
   private long chrNum06_9;
   private long chrNum07_9;
   private long chrNum08_9;
   private long chrNum09_9;
   private long chrNum10_9;
   private long chrNum11_9;
   private long chrNum12_9;
   private String chrPrefixe_9;
   private String chrSufixe_9;
   private long chrNum_A;
   private long chrNumAn_A;
   private long chrNum01_A;
   private long chrNum02_A;
   private long chrNum03_A;
   private long chrNum04_A;
   private long chrNum05_A;
   private long chrNum06_A;
   private long chrNum07_A;
   private long chrNum08_A;
   private long chrNum09_A;
   private long chrNum10_A;
   private long chrNum11_A;
   private long chrNum12_A;
   private String chrPrefixe_A;
   private String chrSufixe_A;
   private long chrIdStr;
   private String libnature;
   private String libmode;
   private String libformat;
   private String lib_num;

   public String getLibformat() {
      if (this.chrFormat == 0) {
         this.libformat = "Chrono simple";
      } else if (this.chrFormat == 1) {
         this.libformat = "MM+Chrono";
      } else if (this.chrFormat == 2) {
         this.libformat = "AA+MM+Chrono";
      } else if (this.chrFormat == 3) {
         this.libformat = "Chrono/AA";
      } else if (this.chrFormat == 4) {
         this.libformat = "Chrono/AAMM";
      } else if (this.chrFormat == 5) {
         this.libformat = "Chrono/JR";
      } else if (this.chrFormat == 6) {
         this.libformat = "Chrono/MM/JR";
      } else if (this.chrFormat == 7) {
         this.libformat = "AAAAMMJJChrono";
      } else if (this.chrFormat == 8) {
         this.libformat = "AA-Chrono";
      } else if (this.chrFormat == 9) {
         this.libformat = "Chrono/MM";
      } else if (this.chrFormat == 10) {
         this.libformat = "AAChrono";
      }

      return this.libformat;
   }

   public void setLibformat(String var1) {
      this.libformat = var1;
   }

   public String getLibmode() {
      if (this.chrMode == 0) {
         this.libmode = "Chrono annuel";
      } else if (this.chrMode == 1) {
         this.libmode = "Chrono mensuel";
      } else if (this.chrMode == 2) {
         this.libmode = "Chrono continu";
      }

      return this.libmode;
   }

   public void setLibmode(String var1) {
      this.libmode = var1;
   }

   public String getLibnature() {
      if (this.chrNature == 2) {
         this.libnature = "Messagerie envoyée";
      } else if (this.chrNature == 3) {
         this.libnature = "Messagerie reçue";
      } else if (this.chrNature == 4) {
         this.libnature = "Messagerie autre";
      } else if (this.chrNature == 5) {
         this.libnature = "Réunion interne";
      } else if (this.chrNature == 6) {
         this.libnature = "Ticket";
      } else if (this.chrNature == 7) {
         this.libnature = "Commission";
      } else if (this.chrNature == 8) {
         this.libnature = "Simultation";
      } else if (this.chrNature == 9) {
         this.libnature = "Contrat LASA";
      } else if (this.chrNature == 10) {
         this.libnature = "Demande Achat";
      } else if (this.chrNature == 11) {
         this.libnature = "Cotation";
      } else if (this.chrNature == 12) {
         this.libnature = "Commande fournisseur";
      } else if (this.chrNature == 13) {
         this.libnature = "Réception";
      } else if (this.chrNature == 14) {
         this.libnature = "Retour fournisseur";
      } else if (this.chrNature == 15) {
         this.libnature = "Facture fournisseur";
      } else if (this.chrNature == 16) {
         this.libnature = "Avoir fournisseur";
      } else if (this.chrNature == 17) {
         this.libnature = "Note débit fournisseur";
      } else if (this.chrNature == 18) {
         this.libnature = "Frais";
      } else if (this.chrNature == 19) {
         this.libnature = "Bon décaissement";
      } else if (this.chrNature == 150) {
         this.libnature = "Réacheminement";
      } else if (this.chrNature == 20) {
         this.libnature = "Besoin";
      } else if (this.chrNature == 21) {
         this.libnature = "Devis";
      } else if (this.chrNature == 22) {
         this.libnature = "Bon commande client";
      } else if (this.chrNature == 23) {
         this.libnature = "Bon livraison client";
      } else if (this.chrNature == 24) {
         this.libnature = "Bon retour client";
      } else if (this.chrNature == 25) {
         this.libnature = "Facture client";
      } else if (this.chrNature == 26) {
         this.libnature = "Avoir client";
      } else if (this.chrNature == 27) {
         this.libnature = "Note débit client";
      } else if (this.chrNature == 28) {
         this.libnature = "Chargement";
      } else if (this.chrNature == 29) {
         this.libnature = "Bon encaissement";
      } else if (this.chrNature == 140) {
         this.libnature = "Contrat";
      } else if (this.chrNature == 141) {
         this.libnature = "Campagne";
      } else if (this.chrNature == 142) {
         this.libnature = "Facture Interne";
      } else if (this.chrNature == 30) {
         this.libnature = "Inventaire";
      } else if (this.chrNature == 31) {
         this.libnature = "Bon entrée (stk)";
      } else if (this.chrNature == 32) {
         this.libnature = "Bon sortie (stk)";
      } else if (this.chrNature == 33) {
         this.libnature = "Cession";
      } else if (this.chrNature == 34) {
         this.libnature = "Production";
      } else if (this.chrNature == 35) {
         this.libnature = "Valorisation";
      } else if (this.chrNature == 36) {
         this.libnature = "Sommier";
      } else if (this.chrNature == 37) {
         this.libnature = "Sérialisation";
      } else if (this.chrNature == 38) {
         this.libnature = "Lot";
      } else if (this.chrNature == 40) {
         this.libnature = "Transport Personnel";
      } else if (this.chrNature == 41) {
         this.libnature = "Transport Matériel";
      } else if (this.chrNature == 42) {
         this.libnature = "Travaux Publics";
      } else if (this.chrNature == 43) {
         this.libnature = "Location";
      } else if (this.chrNature == 44) {
         this.libnature = "Localisation";
      } else if (this.chrNature == 45) {
         this.libnature = "Consommation";
      } else if (this.chrNature == 46) {
         this.libnature = "O.R.";
      } else if (this.chrNature == 47) {
         this.libnature = "Manifest + LV";
      } else if (this.chrNature == 48) {
         this.libnature = "Collecte";
      } else if (this.chrNature == 49) {
         this.libnature = "Chargement";
      } else if (this.chrNature == 50) {
         this.libnature = "Loyer";
      } else if (this.chrNature == 51) {
         this.libnature = "Amortissement";
      } else if (this.chrNature == 52) {
         this.libnature = "Budget";
      } else if (this.chrNature == 53) {
         this.libnature = "Journaux";
      } else if (this.chrNature == 531) {
         this.libnature = "Brouillard jour";
      } else if (this.chrNature == 532) {
         this.libnature = "Brouillard mois";
      } else if (this.chrNature == 534) {
         this.libnature = "Extrait compte";
      } else if (this.chrNature == 533) {
         this.libnature = "Impressions";
      } else if (this.chrNature == 535) {
         this.libnature = "Extrait analytique";
      } else if (this.chrNature == 536) {
         this.libnature = "Extrait budget";
      } else if (this.chrNature == 537) {
         this.libnature = "Etats Financiers";
      } else if (this.chrNature == 538) {
         this.libnature = "Extrait classe";
      } else if (this.chrNature == 539) {
         this.libnature = "Extrait projet";
      } else if (this.chrNature == 54) {
         this.libnature = "Budget Tréso.";
      } else if (this.chrNature == 55) {
         this.libnature = "Transfert";
      } else if (this.chrNature == 56) {
         this.libnature = "Rapprochement";
      } else if (this.chrNature == 57) {
         this.libnature = "Notes Externes";
      } else if (this.chrNature == 60) {
         this.libnature = "Caisse";
      } else if (this.chrNature == 61) {
         this.libnature = "Reçu";
      } else if (this.chrNature == 62) {
         this.libnature = "Bon sortie (cais)";
      } else if (this.chrNature == 63) {
         this.libnature = "Bon entrée (cais)";
      } else if (this.chrNature == 64) {
         this.libnature = "Virement interne";
      } else if (this.chrNature == 65) {
         this.libnature = "Traite domiciliée";
      } else if (this.chrNature == 66) {
         this.libnature = "Traite simplifiée";
      } else if (this.chrNature == 67) {
         this.libnature = "Traite entreprise";
      } else if (this.chrNature == 68) {
         this.libnature = "Inventaire caisse";
      } else if (this.chrNature == 69) {
         this.libnature = "Prévisionnel";
      } else if (this.chrNature == 70) {
         this.libnature = "Patient";
      } else if (this.chrNature == 71) {
         this.libnature = "Consultation Géné.";
      } else if (this.chrNature == 72) {
         this.libnature = "Consultation Spéc.";
      } else if (this.chrNature == 73) {
         this.libnature = "Pharmacie";
      } else if (this.chrNature == 74) {
         this.libnature = "Laboratoire";
      } else if (this.chrNature == 75) {
         this.libnature = "Lettre de garantie";
      } else if (this.chrNature == 76) {
         this.libnature = "Hospitalisation";
      } else if (this.chrNature == 77) {
         this.libnature = "Devis";
      } else if (this.chrNature == 78) {
         this.libnature = "Refacturation";
      } else if (this.chrNature == 79) {
         this.libnature = "Bon encaissement";
      } else if (this.chrNature == 180) {
         this.libnature = "Rapport médical";
      } else if (this.chrNature == 181) {
         this.libnature = "Facturation externe";
      } else if (this.chrNature == 182) {
         this.libnature = "Récapitulatif refacturation";
      } else if (this.chrNature == 80) {
         this.libnature = "R.H";
      } else if (this.chrNature == 81) {
         this.libnature = "Matricule";
      } else if (this.chrNature == 82) {
         this.libnature = "Contrat";
      } else if (this.chrNature == 83) {
         this.libnature = "Attestation";
      } else if (this.chrNature == 84) {
         this.libnature = "Cursus";
      } else if (this.chrNature == 85) {
         this.libnature = "Certificat";
      } else if (this.chrNature == 86) {
         this.libnature = "Correspondance";
      } else if (this.chrNature == 87) {
         this.libnature = "Prêt (interne/externe/manuel)";
      } else if (this.chrNature == 88) {
         this.libnature = "Congés";
      } else if (this.chrNature == 89) {
         this.libnature = "Absence";
      } else if (this.chrNature == 90) {
         this.libnature = "Bulletin";
      } else if (this.chrNature == 91) {
         this.libnature = "Mission";
      } else if (this.chrNature == 92) {
         this.libnature = "Pointage";
      } else if (this.chrNature == 93) {
         this.libnature = "RH";
      } else if (this.chrNature == 94) {
         this.libnature = "Temps";
      } else if (this.chrNature == 99) {
         this.libnature = "CV";
      } else if (this.chrNature == 100) {
         this.libnature = "Eleves";
      } else if (this.chrNature == 101) {
         this.libnature = "Médiatheque";
      } else if (this.chrNature == 102) {
         this.libnature = "Inscription/Facturation";
      } else if (this.chrNature == 103) {
         this.libnature = "Appels";
      } else if (this.chrNature == 104) {
         this.libnature = "Note";
      } else if (this.chrNature == 105) {
         this.libnature = "Violences";
      } else if (this.chrNature == 109) {
         this.libnature = "Bon encaissement";
      } else if (this.chrNature == 120) {
         this.libnature = "Réunion Tiers";
      } else if (this.chrNature == 121) {
         this.libnature = "Réunion Commericale";
      } else if (this.chrNature == 122) {
         this.libnature = "SMS";
      } else if (this.chrNature == 123) {
         this.libnature = "VisioConference";
      } else if (this.chrNature == 124) {
         this.libnature = "Certification";
      } else if (this.chrNature == 125) {
         this.libnature = "Messagerie interne envoyée";
      } else if (this.chrNature == 126) {
         this.libnature = "Messagerie interne reçue";
      } else if (this.chrNature == 127) {
         this.libnature = "Porte feuille affaire";
      } else if (this.chrNature == 128) {
         this.libnature = "Imputation analytique affaire";
      } else if (this.chrNature == 300) {
         this.libnature = "Fournisseur";
      } else if (this.chrNature == 301) {
         this.libnature = "Suspect";
      } else if (this.chrNature == 302) {
         this.libnature = "Prospect";
      } else if (this.chrNature == 303) {
         this.libnature = "Client";
      } else if (this.chrNature == 304) {
         this.libnature = "Proprietaire";
      } else if (this.chrNature == 305) {
         this.libnature = "Copropriété";
      } else if (this.chrNature == 306) {
         this.libnature = "Locataire";
      } else if (this.chrNature == 160) {
         this.libnature = "Bien";
      } else if (this.chrNature == 161) {
         this.libnature = "Contrat Gérance";
      } else if (this.chrNature == 162) {
         this.libnature = "Bail Location";
      } else if (this.chrNature == 163) {
         this.libnature = "Travaux";
      } else if (this.chrNature == 164) {
         this.libnature = "Facture Charges";
      } else if (this.chrNature == 165) {
         this.libnature = "Locations";
      } else if (this.chrNature == 171) {
         this.libnature = "Contrat Syndic";
      } else if (this.chrNature == 172) {
         this.libnature = "Budget";
      } else if (this.chrNature == 173) {
         this.libnature = "Appel de Charges";
      } else if (this.chrNature == 175) {
         this.libnature = "Préparation PV";
      } else if (this.chrNature == 176) {
         this.libnature = "Décisions AG";
      } else if (this.chrNature == 200) {
         this.libnature = "";
      } else if (this.chrNature == 220) {
         this.libnature = "Demande";
      } else if (this.chrNature == 250) {
         this.libnature = "Inventaire";
      } else if (this.chrNature == 251) {
         this.libnature = "Carnet Chantier";
      } else if (this.chrNature == 252) {
         this.libnature = "B. rupture";
      } else if (this.chrNature == 253) {
         this.libnature = "B. route";
      } else if (this.chrNature == 254) {
         this.libnature = "B. expédition";
      } else if (this.chrNature == 255) {
         this.libnature = "Note Crédit";
      } else if (this.chrNature == 256) {
         this.libnature = "Spécification";
      } else if (this.chrNature == 257) {
         this.libnature = "Taxe martelage";
      } else if (this.chrNature == 258) {
         this.libnature = "Redevance attibution";
      } else if (this.chrNature == 259) {
         this.libnature = "Releve SNBG";
      } else if (this.chrNature == 260) {
         this.libnature = "Fermage et Précompte";
      }

      return this.libnature;
   }

   public void setLibnature(String var1) {
      this.libnature = var1;
   }

   public String getLib_num() {
      if (this.chrMode == 0) {
         this.lib_num = "" + this.chrNumAn;
      } else if (this.chrMode == 1) {
         this.lib_num = "(lst/mois)";
      } else if (this.chrMode == 2) {
         this.lib_num = "" + this.chrNum;
      }

      return this.lib_num;
   }

   public void setLib_num(String var1) {
      this.lib_num = var1;
   }

   public int getChrFormat() {
      return this.chrFormat;
   }

   public void setChrFormat(int var1) {
      this.chrFormat = var1;
   }

   public long getChrId() {
      return this.chrId;
   }

   public void setChrId(long var1) {
      this.chrId = var1;
   }

   public int getChrMode() {
      return this.chrMode;
   }

   public void setChrMode(int var1) {
      this.chrMode = var1;
   }

   public int getChrNature() {
      return this.chrNature;
   }

   public void setChrNature(int var1) {
      this.chrNature = var1;
   }

   public int getChrNbCar() {
      return this.chrNbCar;
   }

   public void setChrNbCar(int var1) {
      this.chrNbCar = var1;
   }

   public String getChrNom() {
      return this.chrNom;
   }

   public void setChrNom(String var1) {
      this.chrNom = var1;
   }

   public long getChrNum() {
      return this.chrNum;
   }

   public void setChrNum(long var1) {
      this.chrNum = var1;
   }

   public String getChrPrefixe() {
      if (this.chrPrefixe != null && !this.chrPrefixe.isEmpty()) {
         this.chrPrefixe = this.chrPrefixe.toUpperCase();
      }

      return this.chrPrefixe;
   }

   public void setChrPrefixe(String var1) {
      this.chrPrefixe = var1;
   }

   public String getChrSerie() {
      if (this.chrSerie != null && !this.chrSerie.isEmpty()) {
         this.chrSerie = this.chrSerie.toUpperCase();
      }

      return this.chrSerie;
   }

   public void setChrSerie(String var1) {
      this.chrSerie = var1;
   }

   public String getChrService() {
      return this.chrService;
   }

   public void setChrService(String var1) {
      this.chrService = var1;
   }

   public String getChrSufixe() {
      if (this.chrSufixe != null && !this.chrSufixe.isEmpty()) {
         this.chrSufixe = this.chrSufixe.toUpperCase();
      }

      return this.chrSufixe;
   }

   public void setChrSufixe(String var1) {
      this.chrSufixe = var1;
   }

   public String getChrJournal() {
      return this.chrJournal;
   }

   public void setChrJournal(String var1) {
      this.chrJournal = var1;
   }

   public String getChrPeriode() {
      return this.chrPeriode;
   }

   public void setChrPeriode(String var1) {
      this.chrPeriode = var1;
   }

   public long getChrNum01() {
      return this.chrNum01;
   }

   public void setChrNum01(long var1) {
      this.chrNum01 = var1;
   }

   public long getChrNum02() {
      return this.chrNum02;
   }

   public void setChrNum02(long var1) {
      this.chrNum02 = var1;
   }

   public long getChrNum03() {
      return this.chrNum03;
   }

   public void setChrNum03(long var1) {
      this.chrNum03 = var1;
   }

   public long getChrNum04() {
      return this.chrNum04;
   }

   public void setChrNum04(long var1) {
      this.chrNum04 = var1;
   }

   public long getChrNum05() {
      return this.chrNum05;
   }

   public void setChrNum05(long var1) {
      this.chrNum05 = var1;
   }

   public long getChrNum06() {
      return this.chrNum06;
   }

   public void setChrNum06(long var1) {
      this.chrNum06 = var1;
   }

   public long getChrNum07() {
      return this.chrNum07;
   }

   public void setChrNum07(long var1) {
      this.chrNum07 = var1;
   }

   public long getChrNum08() {
      return this.chrNum08;
   }

   public void setChrNum08(long var1) {
      this.chrNum08 = var1;
   }

   public long getChrNum09() {
      return this.chrNum09;
   }

   public void setChrNum09(long var1) {
      this.chrNum09 = var1;
   }

   public long getChrNum10() {
      return this.chrNum10;
   }

   public void setChrNum10(long var1) {
      this.chrNum10 = var1;
   }

   public long getChrNum11() {
      return this.chrNum11;
   }

   public void setChrNum11(long var1) {
      this.chrNum11 = var1;
   }

   public long getChrNum12() {
      return this.chrNum12;
   }

   public void setChrNum12(long var1) {
      this.chrNum12 = var1;
   }

   public long getChrNumAn() {
      return this.chrNumAn;
   }

   public void setChrNumAn(long var1) {
      this.chrNumAn = var1;
   }

   public int getChrPrive() {
      return this.chrPrive;
   }

   public void setChrPrive(int var1) {
      this.chrPrive = var1;
   }

   public long getChrNum01_1() {
      return this.chrNum01_1;
   }

   public void setChrNum01_1(long var1) {
      this.chrNum01_1 = var1;
   }

   public long getChrNum01_2() {
      return this.chrNum01_2;
   }

   public void setChrNum01_2(long var1) {
      this.chrNum01_2 = var1;
   }

   public long getChrNum01_3() {
      return this.chrNum01_3;
   }

   public void setChrNum01_3(long var1) {
      this.chrNum01_3 = var1;
   }

   public long getChrNum01_4() {
      return this.chrNum01_4;
   }

   public void setChrNum01_4(long var1) {
      this.chrNum01_4 = var1;
   }

   public long getChrNum01_5() {
      return this.chrNum01_5;
   }

   public void setChrNum01_5(long var1) {
      this.chrNum01_5 = var1;
   }

   public long getChrNum01_6() {
      return this.chrNum01_6;
   }

   public void setChrNum01_6(long var1) {
      this.chrNum01_6 = var1;
   }

   public long getChrNum01_7() {
      return this.chrNum01_7;
   }

   public void setChrNum01_7(long var1) {
      this.chrNum01_7 = var1;
   }

   public long getChrNum01_8() {
      return this.chrNum01_8;
   }

   public void setChrNum01_8(long var1) {
      this.chrNum01_8 = var1;
   }

   public long getChrNum01_9() {
      return this.chrNum01_9;
   }

   public void setChrNum01_9(long var1) {
      this.chrNum01_9 = var1;
   }

   public long getChrNum02_1() {
      return this.chrNum02_1;
   }

   public void setChrNum02_1(long var1) {
      this.chrNum02_1 = var1;
   }

   public long getChrNum02_2() {
      return this.chrNum02_2;
   }

   public void setChrNum02_2(long var1) {
      this.chrNum02_2 = var1;
   }

   public long getChrNum02_3() {
      return this.chrNum02_3;
   }

   public void setChrNum02_3(long var1) {
      this.chrNum02_3 = var1;
   }

   public long getChrNum02_4() {
      return this.chrNum02_4;
   }

   public void setChrNum02_4(long var1) {
      this.chrNum02_4 = var1;
   }

   public long getChrNum02_5() {
      return this.chrNum02_5;
   }

   public void setChrNum02_5(long var1) {
      this.chrNum02_5 = var1;
   }

   public long getChrNum02_6() {
      return this.chrNum02_6;
   }

   public void setChrNum02_6(long var1) {
      this.chrNum02_6 = var1;
   }

   public long getChrNum02_7() {
      return this.chrNum02_7;
   }

   public void setChrNum02_7(long var1) {
      this.chrNum02_7 = var1;
   }

   public long getChrNum02_8() {
      return this.chrNum02_8;
   }

   public void setChrNum02_8(long var1) {
      this.chrNum02_8 = var1;
   }

   public long getChrNum02_9() {
      return this.chrNum02_9;
   }

   public void setChrNum02_9(long var1) {
      this.chrNum02_9 = var1;
   }

   public long getChrNum03_1() {
      return this.chrNum03_1;
   }

   public void setChrNum03_1(long var1) {
      this.chrNum03_1 = var1;
   }

   public long getChrNum03_2() {
      return this.chrNum03_2;
   }

   public void setChrNum03_2(long var1) {
      this.chrNum03_2 = var1;
   }

   public long getChrNum03_3() {
      return this.chrNum03_3;
   }

   public void setChrNum03_3(long var1) {
      this.chrNum03_3 = var1;
   }

   public long getChrNum03_4() {
      return this.chrNum03_4;
   }

   public void setChrNum03_4(long var1) {
      this.chrNum03_4 = var1;
   }

   public long getChrNum03_5() {
      return this.chrNum03_5;
   }

   public void setChrNum03_5(long var1) {
      this.chrNum03_5 = var1;
   }

   public long getChrNum03_6() {
      return this.chrNum03_6;
   }

   public void setChrNum03_6(long var1) {
      this.chrNum03_6 = var1;
   }

   public long getChrNum03_7() {
      return this.chrNum03_7;
   }

   public void setChrNum03_7(long var1) {
      this.chrNum03_7 = var1;
   }

   public long getChrNum03_8() {
      return this.chrNum03_8;
   }

   public void setChrNum03_8(long var1) {
      this.chrNum03_8 = var1;
   }

   public long getChrNum03_9() {
      return this.chrNum03_9;
   }

   public void setChrNum03_9(long var1) {
      this.chrNum03_9 = var1;
   }

   public long getChrNum04_1() {
      return this.chrNum04_1;
   }

   public void setChrNum04_1(long var1) {
      this.chrNum04_1 = var1;
   }

   public long getChrNum04_2() {
      return this.chrNum04_2;
   }

   public void setChrNum04_2(long var1) {
      this.chrNum04_2 = var1;
   }

   public long getChrNum04_3() {
      return this.chrNum04_3;
   }

   public void setChrNum04_3(long var1) {
      this.chrNum04_3 = var1;
   }

   public long getChrNum04_4() {
      return this.chrNum04_4;
   }

   public void setChrNum04_4(long var1) {
      this.chrNum04_4 = var1;
   }

   public long getChrNum04_5() {
      return this.chrNum04_5;
   }

   public void setChrNum04_5(long var1) {
      this.chrNum04_5 = var1;
   }

   public long getChrNum04_6() {
      return this.chrNum04_6;
   }

   public void setChrNum04_6(long var1) {
      this.chrNum04_6 = var1;
   }

   public long getChrNum04_7() {
      return this.chrNum04_7;
   }

   public void setChrNum04_7(long var1) {
      this.chrNum04_7 = var1;
   }

   public long getChrNum04_8() {
      return this.chrNum04_8;
   }

   public void setChrNum04_8(long var1) {
      this.chrNum04_8 = var1;
   }

   public long getChrNum04_9() {
      return this.chrNum04_9;
   }

   public void setChrNum04_9(long var1) {
      this.chrNum04_9 = var1;
   }

   public long getChrNum05_1() {
      return this.chrNum05_1;
   }

   public void setChrNum05_1(long var1) {
      this.chrNum05_1 = var1;
   }

   public long getChrNum05_2() {
      return this.chrNum05_2;
   }

   public void setChrNum05_2(long var1) {
      this.chrNum05_2 = var1;
   }

   public long getChrNum05_3() {
      return this.chrNum05_3;
   }

   public void setChrNum05_3(long var1) {
      this.chrNum05_3 = var1;
   }

   public long getChrNum05_4() {
      return this.chrNum05_4;
   }

   public void setChrNum05_4(long var1) {
      this.chrNum05_4 = var1;
   }

   public long getChrNum05_5() {
      return this.chrNum05_5;
   }

   public void setChrNum05_5(long var1) {
      this.chrNum05_5 = var1;
   }

   public long getChrNum05_6() {
      return this.chrNum05_6;
   }

   public void setChrNum05_6(long var1) {
      this.chrNum05_6 = var1;
   }

   public long getChrNum05_7() {
      return this.chrNum05_7;
   }

   public void setChrNum05_7(long var1) {
      this.chrNum05_7 = var1;
   }

   public long getChrNum05_8() {
      return this.chrNum05_8;
   }

   public void setChrNum05_8(long var1) {
      this.chrNum05_8 = var1;
   }

   public long getChrNum05_9() {
      return this.chrNum05_9;
   }

   public void setChrNum05_9(long var1) {
      this.chrNum05_9 = var1;
   }

   public long getChrNum06_1() {
      return this.chrNum06_1;
   }

   public void setChrNum06_1(long var1) {
      this.chrNum06_1 = var1;
   }

   public long getChrNum06_2() {
      return this.chrNum06_2;
   }

   public void setChrNum06_2(long var1) {
      this.chrNum06_2 = var1;
   }

   public long getChrNum06_3() {
      return this.chrNum06_3;
   }

   public void setChrNum06_3(long var1) {
      this.chrNum06_3 = var1;
   }

   public long getChrNum06_4() {
      return this.chrNum06_4;
   }

   public void setChrNum06_4(long var1) {
      this.chrNum06_4 = var1;
   }

   public long getChrNum06_5() {
      return this.chrNum06_5;
   }

   public void setChrNum06_5(long var1) {
      this.chrNum06_5 = var1;
   }

   public long getChrNum06_6() {
      return this.chrNum06_6;
   }

   public void setChrNum06_6(long var1) {
      this.chrNum06_6 = var1;
   }

   public long getChrNum06_7() {
      return this.chrNum06_7;
   }

   public void setChrNum06_7(long var1) {
      this.chrNum06_7 = var1;
   }

   public long getChrNum06_8() {
      return this.chrNum06_8;
   }

   public void setChrNum06_8(long var1) {
      this.chrNum06_8 = var1;
   }

   public long getChrNum06_9() {
      return this.chrNum06_9;
   }

   public void setChrNum06_9(long var1) {
      this.chrNum06_9 = var1;
   }

   public long getChrNum07_1() {
      return this.chrNum07_1;
   }

   public void setChrNum07_1(long var1) {
      this.chrNum07_1 = var1;
   }

   public long getChrNum07_2() {
      return this.chrNum07_2;
   }

   public void setChrNum07_2(long var1) {
      this.chrNum07_2 = var1;
   }

   public long getChrNum07_3() {
      return this.chrNum07_3;
   }

   public void setChrNum07_3(long var1) {
      this.chrNum07_3 = var1;
   }

   public long getChrNum07_4() {
      return this.chrNum07_4;
   }

   public void setChrNum07_4(long var1) {
      this.chrNum07_4 = var1;
   }

   public long getChrNum07_5() {
      return this.chrNum07_5;
   }

   public void setChrNum07_5(long var1) {
      this.chrNum07_5 = var1;
   }

   public long getChrNum07_6() {
      return this.chrNum07_6;
   }

   public void setChrNum07_6(long var1) {
      this.chrNum07_6 = var1;
   }

   public long getChrNum07_7() {
      return this.chrNum07_7;
   }

   public void setChrNum07_7(long var1) {
      this.chrNum07_7 = var1;
   }

   public long getChrNum07_8() {
      return this.chrNum07_8;
   }

   public void setChrNum07_8(long var1) {
      this.chrNum07_8 = var1;
   }

   public long getChrNum07_9() {
      return this.chrNum07_9;
   }

   public void setChrNum07_9(long var1) {
      this.chrNum07_9 = var1;
   }

   public long getChrNum08_1() {
      return this.chrNum08_1;
   }

   public void setChrNum08_1(long var1) {
      this.chrNum08_1 = var1;
   }

   public long getChrNum08_2() {
      return this.chrNum08_2;
   }

   public void setChrNum08_2(long var1) {
      this.chrNum08_2 = var1;
   }

   public long getChrNum08_3() {
      return this.chrNum08_3;
   }

   public void setChrNum08_3(long var1) {
      this.chrNum08_3 = var1;
   }

   public long getChrNum08_4() {
      return this.chrNum08_4;
   }

   public void setChrNum08_4(long var1) {
      this.chrNum08_4 = var1;
   }

   public long getChrNum08_5() {
      return this.chrNum08_5;
   }

   public void setChrNum08_5(long var1) {
      this.chrNum08_5 = var1;
   }

   public long getChrNum08_6() {
      return this.chrNum08_6;
   }

   public void setChrNum08_6(long var1) {
      this.chrNum08_6 = var1;
   }

   public long getChrNum08_7() {
      return this.chrNum08_7;
   }

   public void setChrNum08_7(long var1) {
      this.chrNum08_7 = var1;
   }

   public long getChrNum08_8() {
      return this.chrNum08_8;
   }

   public void setChrNum08_8(long var1) {
      this.chrNum08_8 = var1;
   }

   public long getChrNum08_9() {
      return this.chrNum08_9;
   }

   public void setChrNum08_9(long var1) {
      this.chrNum08_9 = var1;
   }

   public long getChrNum09_1() {
      return this.chrNum09_1;
   }

   public void setChrNum09_1(long var1) {
      this.chrNum09_1 = var1;
   }

   public long getChrNum09_2() {
      return this.chrNum09_2;
   }

   public void setChrNum09_2(long var1) {
      this.chrNum09_2 = var1;
   }

   public long getChrNum09_3() {
      return this.chrNum09_3;
   }

   public void setChrNum09_3(long var1) {
      this.chrNum09_3 = var1;
   }

   public long getChrNum09_4() {
      return this.chrNum09_4;
   }

   public void setChrNum09_4(long var1) {
      this.chrNum09_4 = var1;
   }

   public long getChrNum09_5() {
      return this.chrNum09_5;
   }

   public void setChrNum09_5(long var1) {
      this.chrNum09_5 = var1;
   }

   public long getChrNum09_6() {
      return this.chrNum09_6;
   }

   public void setChrNum09_6(long var1) {
      this.chrNum09_6 = var1;
   }

   public long getChrNum09_7() {
      return this.chrNum09_7;
   }

   public void setChrNum09_7(long var1) {
      this.chrNum09_7 = var1;
   }

   public long getChrNum09_8() {
      return this.chrNum09_8;
   }

   public void setChrNum09_8(long var1) {
      this.chrNum09_8 = var1;
   }

   public long getChrNum09_9() {
      return this.chrNum09_9;
   }

   public void setChrNum09_9(long var1) {
      this.chrNum09_9 = var1;
   }

   public long getChrNum10_1() {
      return this.chrNum10_1;
   }

   public void setChrNum10_1(long var1) {
      this.chrNum10_1 = var1;
   }

   public long getChrNum10_2() {
      return this.chrNum10_2;
   }

   public void setChrNum10_2(long var1) {
      this.chrNum10_2 = var1;
   }

   public long getChrNum10_3() {
      return this.chrNum10_3;
   }

   public void setChrNum10_3(long var1) {
      this.chrNum10_3 = var1;
   }

   public long getChrNum10_4() {
      return this.chrNum10_4;
   }

   public void setChrNum10_4(long var1) {
      this.chrNum10_4 = var1;
   }

   public long getChrNum10_5() {
      return this.chrNum10_5;
   }

   public void setChrNum10_5(long var1) {
      this.chrNum10_5 = var1;
   }

   public long getChrNum10_6() {
      return this.chrNum10_6;
   }

   public void setChrNum10_6(long var1) {
      this.chrNum10_6 = var1;
   }

   public long getChrNum10_7() {
      return this.chrNum10_7;
   }

   public void setChrNum10_7(long var1) {
      this.chrNum10_7 = var1;
   }

   public long getChrNum10_8() {
      return this.chrNum10_8;
   }

   public void setChrNum10_8(long var1) {
      this.chrNum10_8 = var1;
   }

   public long getChrNum10_9() {
      return this.chrNum10_9;
   }

   public void setChrNum10_9(long var1) {
      this.chrNum10_9 = var1;
   }

   public long getChrNum11_1() {
      return this.chrNum11_1;
   }

   public void setChrNum11_1(long var1) {
      this.chrNum11_1 = var1;
   }

   public long getChrNum11_2() {
      return this.chrNum11_2;
   }

   public void setChrNum11_2(long var1) {
      this.chrNum11_2 = var1;
   }

   public long getChrNum11_3() {
      return this.chrNum11_3;
   }

   public void setChrNum11_3(long var1) {
      this.chrNum11_3 = var1;
   }

   public long getChrNum11_4() {
      return this.chrNum11_4;
   }

   public void setChrNum11_4(long var1) {
      this.chrNum11_4 = var1;
   }

   public long getChrNum11_5() {
      return this.chrNum11_5;
   }

   public void setChrNum11_5(long var1) {
      this.chrNum11_5 = var1;
   }

   public long getChrNum11_6() {
      return this.chrNum11_6;
   }

   public void setChrNum11_6(long var1) {
      this.chrNum11_6 = var1;
   }

   public long getChrNum11_7() {
      return this.chrNum11_7;
   }

   public void setChrNum11_7(long var1) {
      this.chrNum11_7 = var1;
   }

   public long getChrNum11_8() {
      return this.chrNum11_8;
   }

   public void setChrNum11_8(long var1) {
      this.chrNum11_8 = var1;
   }

   public long getChrNum11_9() {
      return this.chrNum11_9;
   }

   public void setChrNum11_9(long var1) {
      this.chrNum11_9 = var1;
   }

   public long getChrNum12_1() {
      return this.chrNum12_1;
   }

   public void setChrNum12_1(long var1) {
      this.chrNum12_1 = var1;
   }

   public long getChrNum12_2() {
      return this.chrNum12_2;
   }

   public void setChrNum12_2(long var1) {
      this.chrNum12_2 = var1;
   }

   public long getChrNum12_3() {
      return this.chrNum12_3;
   }

   public void setChrNum12_3(long var1) {
      this.chrNum12_3 = var1;
   }

   public long getChrNum12_4() {
      return this.chrNum12_4;
   }

   public void setChrNum12_4(long var1) {
      this.chrNum12_4 = var1;
   }

   public long getChrNum12_5() {
      return this.chrNum12_5;
   }

   public void setChrNum12_5(long var1) {
      this.chrNum12_5 = var1;
   }

   public long getChrNum12_6() {
      return this.chrNum12_6;
   }

   public void setChrNum12_6(long var1) {
      this.chrNum12_6 = var1;
   }

   public long getChrNum12_7() {
      return this.chrNum12_7;
   }

   public void setChrNum12_7(long var1) {
      this.chrNum12_7 = var1;
   }

   public long getChrNum12_8() {
      return this.chrNum12_8;
   }

   public void setChrNum12_8(long var1) {
      this.chrNum12_8 = var1;
   }

   public long getChrNum12_9() {
      return this.chrNum12_9;
   }

   public void setChrNum12_9(long var1) {
      this.chrNum12_9 = var1;
   }

   public long getChrNumAn_1() {
      return this.chrNumAn_1;
   }

   public void setChrNumAn_1(long var1) {
      this.chrNumAn_1 = var1;
   }

   public long getChrNumAn_2() {
      return this.chrNumAn_2;
   }

   public void setChrNumAn_2(long var1) {
      this.chrNumAn_2 = var1;
   }

   public long getChrNumAn_3() {
      return this.chrNumAn_3;
   }

   public void setChrNumAn_3(long var1) {
      this.chrNumAn_3 = var1;
   }

   public long getChrNumAn_4() {
      return this.chrNumAn_4;
   }

   public void setChrNumAn_4(long var1) {
      this.chrNumAn_4 = var1;
   }

   public long getChrNumAn_5() {
      return this.chrNumAn_5;
   }

   public void setChrNumAn_5(long var1) {
      this.chrNumAn_5 = var1;
   }

   public long getChrNumAn_6() {
      return this.chrNumAn_6;
   }

   public void setChrNumAn_6(long var1) {
      this.chrNumAn_6 = var1;
   }

   public long getChrNumAn_7() {
      return this.chrNumAn_7;
   }

   public void setChrNumAn_7(long var1) {
      this.chrNumAn_7 = var1;
   }

   public long getChrNumAn_8() {
      return this.chrNumAn_8;
   }

   public void setChrNumAn_8(long var1) {
      this.chrNumAn_8 = var1;
   }

   public long getChrNumAn_9() {
      return this.chrNumAn_9;
   }

   public void setChrNumAn_9(long var1) {
      this.chrNumAn_9 = var1;
   }

   public long getChrNum_1() {
      return this.chrNum_1;
   }

   public void setChrNum_1(long var1) {
      this.chrNum_1 = var1;
   }

   public long getChrNum_2() {
      return this.chrNum_2;
   }

   public void setChrNum_2(long var1) {
      this.chrNum_2 = var1;
   }

   public long getChrNum_3() {
      return this.chrNum_3;
   }

   public void setChrNum_3(long var1) {
      this.chrNum_3 = var1;
   }

   public long getChrNum_4() {
      return this.chrNum_4;
   }

   public void setChrNum_4(long var1) {
      this.chrNum_4 = var1;
   }

   public long getChrNum_5() {
      return this.chrNum_5;
   }

   public void setChrNum_5(long var1) {
      this.chrNum_5 = var1;
   }

   public long getChrNum_6() {
      return this.chrNum_6;
   }

   public void setChrNum_6(long var1) {
      this.chrNum_6 = var1;
   }

   public long getChrNum_7() {
      return this.chrNum_7;
   }

   public void setChrNum_7(long var1) {
      this.chrNum_7 = var1;
   }

   public long getChrNum_8() {
      return this.chrNum_8;
   }

   public void setChrNum_8(long var1) {
      this.chrNum_8 = var1;
   }

   public long getChrNum_9() {
      return this.chrNum_9;
   }

   public void setChrNum_9(long var1) {
      this.chrNum_9 = var1;
   }

   public String getChrPrefixe_1() {
      return this.chrPrefixe_1;
   }

   public void setChrPrefixe_1(String var1) {
      this.chrPrefixe_1 = var1;
   }

   public String getChrPrefixe_2() {
      return this.chrPrefixe_2;
   }

   public void setChrPrefixe_2(String var1) {
      this.chrPrefixe_2 = var1;
   }

   public String getChrPrefixe_3() {
      return this.chrPrefixe_3;
   }

   public void setChrPrefixe_3(String var1) {
      this.chrPrefixe_3 = var1;
   }

   public String getChrPrefixe_4() {
      return this.chrPrefixe_4;
   }

   public void setChrPrefixe_4(String var1) {
      this.chrPrefixe_4 = var1;
   }

   public String getChrPrefixe_5() {
      return this.chrPrefixe_5;
   }

   public void setChrPrefixe_5(String var1) {
      this.chrPrefixe_5 = var1;
   }

   public String getChrPrefixe_6() {
      return this.chrPrefixe_6;
   }

   public void setChrPrefixe_6(String var1) {
      this.chrPrefixe_6 = var1;
   }

   public String getChrPrefixe_7() {
      return this.chrPrefixe_7;
   }

   public void setChrPrefixe_7(String var1) {
      this.chrPrefixe_7 = var1;
   }

   public String getChrPrefixe_8() {
      return this.chrPrefixe_8;
   }

   public void setChrPrefixe_8(String var1) {
      this.chrPrefixe_8 = var1;
   }

   public String getChrPrefixe_9() {
      return this.chrPrefixe_9;
   }

   public void setChrPrefixe_9(String var1) {
      this.chrPrefixe_9 = var1;
   }

   public String getChrSufixe_1() {
      return this.chrSufixe_1;
   }

   public void setChrSufixe_1(String var1) {
      this.chrSufixe_1 = var1;
   }

   public String getChrSufixe_2() {
      return this.chrSufixe_2;
   }

   public void setChrSufixe_2(String var1) {
      this.chrSufixe_2 = var1;
   }

   public String getChrSufixe_3() {
      return this.chrSufixe_3;
   }

   public void setChrSufixe_3(String var1) {
      this.chrSufixe_3 = var1;
   }

   public String getChrSufixe_4() {
      return this.chrSufixe_4;
   }

   public void setChrSufixe_4(String var1) {
      this.chrSufixe_4 = var1;
   }

   public String getChrSufixe_5() {
      return this.chrSufixe_5;
   }

   public void setChrSufixe_5(String var1) {
      this.chrSufixe_5 = var1;
   }

   public String getChrSufixe_6() {
      return this.chrSufixe_6;
   }

   public void setChrSufixe_6(String var1) {
      this.chrSufixe_6 = var1;
   }

   public String getChrSufixe_7() {
      return this.chrSufixe_7;
   }

   public void setChrSufixe_7(String var1) {
      this.chrSufixe_7 = var1;
   }

   public String getChrSufixe_8() {
      return this.chrSufixe_8;
   }

   public void setChrSufixe_8(String var1) {
      this.chrSufixe_8 = var1;
   }

   public String getChrSufixe_9() {
      return this.chrSufixe_9;
   }

   public void setChrSufixe_9(String var1) {
      this.chrSufixe_9 = var1;
   }

   public long getChrNum01_A() {
      return this.chrNum01_A;
   }

   public void setChrNum01_A(long var1) {
      this.chrNum01_A = var1;
   }

   public long getChrNum02_A() {
      return this.chrNum02_A;
   }

   public void setChrNum02_A(long var1) {
      this.chrNum02_A = var1;
   }

   public long getChrNum03_A() {
      return this.chrNum03_A;
   }

   public void setChrNum03_A(long var1) {
      this.chrNum03_A = var1;
   }

   public long getChrNum04_A() {
      return this.chrNum04_A;
   }

   public void setChrNum04_A(long var1) {
      this.chrNum04_A = var1;
   }

   public long getChrNum05_A() {
      return this.chrNum05_A;
   }

   public void setChrNum05_A(long var1) {
      this.chrNum05_A = var1;
   }

   public long getChrNum06_A() {
      return this.chrNum06_A;
   }

   public void setChrNum06_A(long var1) {
      this.chrNum06_A = var1;
   }

   public long getChrNum07_A() {
      return this.chrNum07_A;
   }

   public void setChrNum07_A(long var1) {
      this.chrNum07_A = var1;
   }

   public long getChrNum08_A() {
      return this.chrNum08_A;
   }

   public void setChrNum08_A(long var1) {
      this.chrNum08_A = var1;
   }

   public long getChrNum09_A() {
      return this.chrNum09_A;
   }

   public void setChrNum09_A(long var1) {
      this.chrNum09_A = var1;
   }

   public long getChrNum10_A() {
      return this.chrNum10_A;
   }

   public void setChrNum10_A(long var1) {
      this.chrNum10_A = var1;
   }

   public long getChrNum11_A() {
      return this.chrNum11_A;
   }

   public void setChrNum11_A(long var1) {
      this.chrNum11_A = var1;
   }

   public long getChrNum12_A() {
      return this.chrNum12_A;
   }

   public void setChrNum12_A(long var1) {
      this.chrNum12_A = var1;
   }

   public long getChrNumAn_A() {
      return this.chrNumAn_A;
   }

   public void setChrNumAn_A(long var1) {
      this.chrNumAn_A = var1;
   }

   public long getChrNum_A() {
      return this.chrNum_A;
   }

   public void setChrNum_A(long var1) {
      this.chrNum_A = var1;
   }

   public String getChrPrefixe_A() {
      return this.chrPrefixe_A;
   }

   public void setChrPrefixe_A(String var1) {
      this.chrPrefixe_A = var1;
   }

   public String getChrSufixe_A() {
      return this.chrSufixe_A;
   }

   public void setChrSufixe_A(String var1) {
      this.chrSufixe_A = var1;
   }

   public String getChrJournalOd() {
      return this.chrJournalOd;
   }

   public void setChrJournalOd(String var1) {
      this.chrJournalOd = var1;
   }

   public String getChrCodeCaisse() {
      return this.chrCodeCaisse;
   }

   public void setChrCodeCaisse(String var1) {
      this.chrCodeCaisse = var1;
   }

   public int getChrModeCaisse() {
      return this.chrModeCaisse;
   }

   public void setChrModeCaisse(int var1) {
      this.chrModeCaisse = var1;
   }

   public long getChrIdStr() {
      return this.chrIdStr;
   }

   public void setChrIdStr(long var1) {
      this.chrIdStr = var1;
   }
}
