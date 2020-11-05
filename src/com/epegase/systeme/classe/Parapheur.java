package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Parapheur implements Serializable {
   private long phrId;
   private int phrNature;
   private int phrNatureOrigine;
   private double phrMontant;
   private int phrMode;
   private int phrNombre;
   private int phrPosition;
   private int phrUser1Cat;
   private long phrUser1Id;
   private String phrUser1Nom;
   private int phrUser2Cat;
   private long phrUser2Id;
   private String phrUser2Nom;
   private int phrUser3Cat;
   private long phrUser3Id;
   private String phrUser3Nom;
   private int phrUser4Cat;
   private long phrUser4Id;
   private String phrUser4Nom;
   private int phrUser5Cat;
   private long phrUser5Id;
   private String phrUser5Nom;
   private int phrUser6Cat;
   private long phrUser6Id;
   private String phrUser6Nom;
   private Date phrUser1DteRep;
   private Date phrUser2DteRep;
   private Date phrUser3DteRep;
   private Date phrUser4DteRep;
   private Date phrUser5DteRep;
   private Date phrUser6DteRep;
   private int phrUser1Etat;
   private int phrUser2Etat;
   private int phrUser3Etat;
   private int phrUser4Etat;
   private int phrUser5Etat;
   private int phrUser6Etat;
   private String phrUser1Explication;
   private String phrUser2Explication;
   private String phrUser3Explication;
   private String phrUser4Explication;
   private String phrUser5Explication;
   private String phrUser6Explication;
   private String phrUser1MemoExplication;
   private String phrUser2MemoExplication;
   private String phrUser3MemoExplication;
   private String phrUser4MemoExplication;
   private String phrUser5MemoExplication;
   private String phrUser6MemoExplication;
   private int phrEtat;
   private long phrDocId;
   private String phrNum;
   private String phrNomTiers;
   private Date phrDate;
   private String phrModeleImp;
   private boolean phrUser1Col01;
   private boolean phrUser1Col02;
   private boolean phrUser1Col03;
   private boolean phrUser1Col04;
   private boolean phrUser1Col05;
   private boolean phrUser1Col06;
   private boolean phrUser1Col07;
   private boolean phrUser2Col01;
   private boolean phrUser2Col02;
   private boolean phrUser2Col03;
   private boolean phrUser2Col04;
   private boolean phrUser2Col05;
   private boolean phrUser2Col06;
   private boolean phrUser2Col07;
   private boolean phrUser3Col01;
   private boolean phrUser3Col02;
   private boolean phrUser3Col03;
   private boolean phrUser3Col04;
   private boolean phrUser3Col05;
   private boolean phrUser3Col06;
   private boolean phrUser3Col07;
   private boolean phrUser4Col01;
   private boolean phrUser4Col02;
   private boolean phrUser4Col03;
   private boolean phrUser4Col04;
   private boolean phrUser4Col05;
   private boolean phrUser4Col06;
   private boolean phrUser4Col07;
   private boolean phrUser5Col01;
   private boolean phrUser5Col02;
   private boolean phrUser5Col03;
   private boolean phrUser5Col04;
   private boolean phrUser5Col05;
   private boolean phrUser5Col06;
   private boolean phrUser5Col07;
   private boolean phrUser6Col01;
   private boolean phrUser6Col02;
   private boolean phrUser6Col03;
   private boolean phrUser6Col04;
   private boolean phrUser6Col05;
   private boolean phrUser6Col06;
   private boolean phrUser6Col07;
   private String libNature;
   private String libellePhr;
   private String libelleEtat1;
   private String libelleEtat2;
   private String libelleEtat3;
   private String libelleEtat4;
   private String libelleEtat5;
   private String libelleEtat6;
   private boolean select;

   public String natParapheur(int var1) {
      String var2 = "";
      if (var1 == 10) {
         var2 = "Demande Achat";
      } else if (var1 == 11) {
         var2 = "Cotation";
      } else if (var1 == 12) {
         var2 = "Commande fournisseur";
      } else if (var1 == 13) {
         var2 = "Réception";
      } else if (var1 == 14) {
         var2 = "Retour fournisseur";
      } else if (var1 == 15) {
         var2 = "Facture fournisseur";
      } else if (var1 == 16) {
         var2 = "Avoir fournisseur";
      } else if (var1 == 17) {
         var2 = "Note débit fournisseur";
      } else if (var1 == 18) {
         var2 = "Facture de frais";
      } else if (var1 == 19) {
         var2 = "Bon décaissement";
      } else if (var1 == 8) {
         var2 = "Simulation vente";
      } else if (var1 == 20) {
         var2 = "Besoin";
      } else if (var1 == 21) {
         var2 = "Devis";
      } else if (var1 == 22) {
         var2 = "Commande client";
      } else if (var1 == 23) {
         var2 = "Livraison client";
      } else if (var1 == 24) {
         var2 = "Retour client";
      } else if (var1 == 25) {
         var2 = "Facture client";
      } else if (var1 == 26) {
         var2 = "Avoir client";
      } else if (var1 == 27) {
         var2 = "Note débit client";
      } else if (var1 == 29) {
         var2 = "Bon encaissement";
      } else if (var1 == 30) {
         var2 = "Inventaire";
      } else if (var1 == 31) {
         var2 = "Bon entrée";
      } else if (var1 == 32) {
         var2 = "Bon sortie";
      } else if (var1 == 33) {
         var2 = "Cession";
      } else if (var1 == 34) {
         var2 = "Production";
      } else if (var1 == 35) {
         var2 = "Réexpédition";
      } else if (var1 == 40) {
         var2 = "Transport";
      } else if (var1 == 41) {
         var2 = "Travaux Publics";
      } else if (var1 == 42) {
         var2 = "Location";
      } else if (var1 == 43) {
         var2 = "Localisation";
      } else if (var1 == 44) {
         var2 = "Consommation";
      } else if (var1 == 45) {
         var2 = "O.R.";
      } else if (var1 == 50) {
         var2 = "Loyer";
      } else if (var1 == 51) {
         var2 = "Amortissement";
      } else if (var1 == 52) {
         var2 = "Brouillard";
      } else if (var1 == 53) {
         var2 = "Journaux";
      } else if (var1 == 54) {
         var2 = "O.P.";
      } else if (var1 == 60) {
         var2 = "Caisse";
      } else if (var1 == 61) {
         var2 = "Reçu";
      } else if (var1 == 62) {
         var2 = "Bon de sortie";
      } else if (var1 == 63) {
         var2 = "Bon d'entrée";
      } else if (var1 == 64) {
         var2 = "Ordre de virement";
      } else if (var1 == 70) {
         var2 = "Consult. Géné.";
      } else if (var1 == 71) {
         var2 = "Consult. Spé.";
      } else if (var1 == 72) {
         var2 = "Ordonnance";
      } else if (var1 == 73) {
         var2 = "Pharmacie";
      } else if (var1 == 74) {
         var2 = "Laboratoire";
      } else if (var1 == 75) {
         var2 = "Paillasse";
      } else if (var1 == 76) {
         var2 = "Hospitalisation";
      } else if (var1 == 77) {
         var2 = "Devis";
      } else if (var1 == 78) {
         var2 = "Refacturation";
      } else if (var1 == 81) {
         var2 = "Matricule";
      } else if (var1 == 82) {
         var2 = "Contrat";
      } else if (var1 == 83) {
         var2 = "Attestation";
      } else if (var1 == 84) {
         var2 = "Cursus";
      } else if (var1 == 85) {
         var2 = "Certificat";
      } else if (var1 == 86) {
         var2 = "Correspondance";
      } else if (var1 == 87) {
         var2 = "Prêts (internes/externes/manuels)";
      } else if (var1 == 88) {
         var2 = "Congés";
      } else if (var1 == 89) {
         var2 = "Absences";
      }

      return var2;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public String getLibellePhr() {
      this.libellePhr = this.natParapheur(this.phrNature);
      return this.libellePhr;
   }

   public void setLibellePhr(String var1) {
      this.libellePhr = var1;
   }

   public String getLibelleEtat1() {
      String var1 = "";
      if (this.phrUser1Etat == 0) {
         var1 = "En cours";
      } else if (this.phrUser1Etat == 1) {
         var1 = "Validé(e)";
      } else if (this.phrUser1Etat == 2) {
         var1 = "Gelé(e)";
      } else if (this.phrUser1Etat == 3) {
         var1 = "Annulé(e)";
      } else if (this.phrUser1Etat == 4) {
         var1 = "Corrigé(e)";
      }

      this.libelleEtat1 = var1;
      return this.libelleEtat1;
   }

   public void setLibelleEtat1(String var1) {
      this.libelleEtat1 = var1;
   }

   public String getLibelleEtat2() {
      String var1 = "";
      if (this.phrUser2Etat == 0) {
         var1 = "En cours";
      } else if (this.phrUser2Etat == 1) {
         var1 = "Validé(e)";
      } else if (this.phrUser2Etat == 2) {
         var1 = "Gelé(e)";
      } else if (this.phrUser2Etat == 3) {
         var1 = "Annulé(e)";
      } else if (this.phrUser2Etat == 4) {
         var1 = "Corrigé(e)";
      }

      this.libelleEtat2 = var1;
      return this.libelleEtat2;
   }

   public void setLibelleEtat2(String var1) {
      this.libelleEtat2 = var1;
   }

   public String getLibelleEtat3() {
      String var1 = "";
      if (this.phrUser3Etat == 0) {
         var1 = "En cours";
      } else if (this.phrUser3Etat == 1) {
         var1 = "Validé(e)";
      } else if (this.phrUser3Etat == 2) {
         var1 = "Gelé(e)";
      } else if (this.phrUser3Etat == 3) {
         var1 = "Annulé(e)";
      } else if (this.phrUser3Etat == 4) {
         var1 = "Corrigé(e)";
      }

      this.libelleEtat3 = var1;
      return this.libelleEtat3;
   }

   public void setLibelleEtat3(String var1) {
      this.libelleEtat3 = var1;
   }

   public String getLibelleEtat4() {
      String var1 = "";
      if (this.phrUser4Etat == 0) {
         var1 = "En cours";
      } else if (this.phrUser4Etat == 1) {
         var1 = "Validé(e)";
      } else if (this.phrUser4Etat == 2) {
         var1 = "Gelé(e)";
      } else if (this.phrUser4Etat == 3) {
         var1 = "Annulé(e)";
      } else if (this.phrUser4Etat == 4) {
         var1 = "Corrigé(e)";
      }

      this.libelleEtat4 = var1;
      return this.libelleEtat4;
   }

   public void setLibelleEtat4(String var1) {
      this.libelleEtat4 = var1;
   }

   public String getLibelleEtat5() {
      String var1 = "";
      if (this.phrUser5Etat == 0) {
         var1 = "En cours";
      } else if (this.phrUser5Etat == 1) {
         var1 = "Validé(e)";
      } else if (this.phrUser5Etat == 2) {
         var1 = "Gelé(e)";
      } else if (this.phrUser5Etat == 3) {
         var1 = "Annulé(e)";
      } else if (this.phrUser5Etat == 4) {
         var1 = "Corrigé(e)";
      }

      this.libelleEtat5 = var1;
      return this.libelleEtat5;
   }

   public void setLibelleEtat5(String var1) {
      this.libelleEtat5 = var1;
   }

   public String getLibelleEtat6() {
      String var1 = "";
      if (this.phrUser6Etat == 0) {
         var1 = "En cours";
      } else if (this.phrUser6Etat == 1) {
         var1 = "Validé(e)";
      } else if (this.phrUser6Etat == 2) {
         var1 = "Gelé(e)";
      } else if (this.phrUser6Etat == 3) {
         var1 = "Annulé(e)";
      } else if (this.phrUser6Etat == 4) {
         var1 = "Corrigé(e)";
      }

      this.libelleEtat6 = var1;
      return this.libelleEtat6;
   }

   public void setLibelleEtat6(String var1) {
      this.libelleEtat6 = var1;
   }

   public String getLibNature() {
      this.libNature = this.natParapheur(this.phrNature);
      return this.libNature;
   }

   public void setLibNature(String var1) {
      this.libNature = var1;
   }

   public Date getPhrDate() {
      return this.phrDate;
   }

   public void setPhrDate(Date var1) {
      this.phrDate = var1;
   }

   public long getPhrId() {
      return this.phrId;
   }

   public void setPhrId(long var1) {
      this.phrId = var1;
   }

   public int getPhrMode() {
      return this.phrMode;
   }

   public void setPhrMode(int var1) {
      this.phrMode = var1;
   }

   public int getPhrNature() {
      return this.phrNature;
   }

   public void setPhrNature(int var1) {
      this.phrNature = var1;
   }

   public String getPhrNum() {
      return this.phrNum;
   }

   public void setPhrNum(String var1) {
      this.phrNum = var1;
   }

   public int getPhrUser1Cat() {
      return this.phrUser1Cat;
   }

   public void setPhrUser1Cat(int var1) {
      this.phrUser1Cat = var1;
   }

   public Date getPhrUser1DteRep() {
      return this.phrUser1DteRep;
   }

   public void setPhrUser1DteRep(Date var1) {
      this.phrUser1DteRep = var1;
   }

   public int getPhrUser1Etat() {
      return this.phrUser1Etat;
   }

   public void setPhrUser1Etat(int var1) {
      this.phrUser1Etat = var1;
   }

   public String getPhrUser1Explication() {
      return this.phrUser1Explication;
   }

   public void setPhrUser1Explication(String var1) {
      this.phrUser1Explication = var1;
   }

   public long getPhrUser1Id() {
      return this.phrUser1Id;
   }

   public void setPhrUser1Id(long var1) {
      this.phrUser1Id = var1;
   }

   public String getPhrUser1Nom() {
      return this.phrUser1Nom;
   }

   public void setPhrUser1Nom(String var1) {
      this.phrUser1Nom = var1;
   }

   public int getPhrUser2Cat() {
      return this.phrUser2Cat;
   }

   public void setPhrUser2Cat(int var1) {
      this.phrUser2Cat = var1;
   }

   public Date getPhrUser2DteRep() {
      return this.phrUser2DteRep;
   }

   public void setPhrUser2DteRep(Date var1) {
      this.phrUser2DteRep = var1;
   }

   public int getPhrUser2Etat() {
      return this.phrUser2Etat;
   }

   public void setPhrUser2Etat(int var1) {
      this.phrUser2Etat = var1;
   }

   public String getPhrUser2Explication() {
      return this.phrUser2Explication;
   }

   public void setPhrUser2Explication(String var1) {
      this.phrUser2Explication = var1;
   }

   public long getPhrUser2Id() {
      return this.phrUser2Id;
   }

   public void setPhrUser2Id(long var1) {
      this.phrUser2Id = var1;
   }

   public String getPhrUser2Nom() {
      return this.phrUser2Nom;
   }

   public void setPhrUser2Nom(String var1) {
      this.phrUser2Nom = var1;
   }

   public int getPhrUser3Cat() {
      return this.phrUser3Cat;
   }

   public void setPhrUser3Cat(int var1) {
      this.phrUser3Cat = var1;
   }

   public Date getPhrUser3DteRep() {
      return this.phrUser3DteRep;
   }

   public void setPhrUser3DteRep(Date var1) {
      this.phrUser3DteRep = var1;
   }

   public int getPhrUser3Etat() {
      return this.phrUser3Etat;
   }

   public void setPhrUser3Etat(int var1) {
      this.phrUser3Etat = var1;
   }

   public String getPhrUser3Explication() {
      return this.phrUser3Explication;
   }

   public void setPhrUser3Explication(String var1) {
      this.phrUser3Explication = var1;
   }

   public long getPhrUser3Id() {
      return this.phrUser3Id;
   }

   public void setPhrUser3Id(long var1) {
      this.phrUser3Id = var1;
   }

   public String getPhrUser3Nom() {
      return this.phrUser3Nom;
   }

   public void setPhrUser3Nom(String var1) {
      this.phrUser3Nom = var1;
   }

   public int getPhrUser4Cat() {
      return this.phrUser4Cat;
   }

   public void setPhrUser4Cat(int var1) {
      this.phrUser4Cat = var1;
   }

   public Date getPhrUser4DteRep() {
      return this.phrUser4DteRep;
   }

   public void setPhrUser4DteRep(Date var1) {
      this.phrUser4DteRep = var1;
   }

   public int getPhrUser4Etat() {
      return this.phrUser4Etat;
   }

   public void setPhrUser4Etat(int var1) {
      this.phrUser4Etat = var1;
   }

   public String getPhrUser4Explication() {
      return this.phrUser4Explication;
   }

   public void setPhrUser4Explication(String var1) {
      this.phrUser4Explication = var1;
   }

   public long getPhrUser4Id() {
      return this.phrUser4Id;
   }

   public void setPhrUser4Id(long var1) {
      this.phrUser4Id = var1;
   }

   public String getPhrUser4Nom() {
      return this.phrUser4Nom;
   }

   public void setPhrUser4Nom(String var1) {
      this.phrUser4Nom = var1;
   }

   public int getPhrUser5Cat() {
      return this.phrUser5Cat;
   }

   public void setPhrUser5Cat(int var1) {
      this.phrUser5Cat = var1;
   }

   public Date getPhrUser5DteRep() {
      return this.phrUser5DteRep;
   }

   public void setPhrUser5DteRep(Date var1) {
      this.phrUser5DteRep = var1;
   }

   public int getPhrUser5Etat() {
      return this.phrUser5Etat;
   }

   public void setPhrUser5Etat(int var1) {
      this.phrUser5Etat = var1;
   }

   public String getPhrUser5Explication() {
      return this.phrUser5Explication;
   }

   public void setPhrUser5Explication(String var1) {
      this.phrUser5Explication = var1;
   }

   public long getPhrUser5Id() {
      return this.phrUser5Id;
   }

   public void setPhrUser5Id(long var1) {
      this.phrUser5Id = var1;
   }

   public String getPhrUser5Nom() {
      return this.phrUser5Nom;
   }

   public void setPhrUser5Nom(String var1) {
      this.phrUser5Nom = var1;
   }

   public int getPhrUser6Cat() {
      return this.phrUser6Cat;
   }

   public void setPhrUser6Cat(int var1) {
      this.phrUser6Cat = var1;
   }

   public Date getPhrUser6DteRep() {
      return this.phrUser6DteRep;
   }

   public void setPhrUser6DteRep(Date var1) {
      this.phrUser6DteRep = var1;
   }

   public int getPhrUser6Etat() {
      return this.phrUser6Etat;
   }

   public void setPhrUser6Etat(int var1) {
      this.phrUser6Etat = var1;
   }

   public String getPhrUser6Explication() {
      return this.phrUser6Explication;
   }

   public void setPhrUser6Explication(String var1) {
      this.phrUser6Explication = var1;
   }

   public long getPhrUser6Id() {
      return this.phrUser6Id;
   }

   public void setPhrUser6Id(long var1) {
      this.phrUser6Id = var1;
   }

   public String getPhrUser6Nom() {
      return this.phrUser6Nom;
   }

   public void setPhrUser6Nom(String var1) {
      this.phrUser6Nom = var1;
   }

   public long getPhrDocId() {
      return this.phrDocId;
   }

   public void setPhrDocId(long var1) {
      this.phrDocId = var1;
   }

   public double getPhrMontant() {
      return this.phrMontant;
   }

   public void setPhrMontant(double var1) {
      this.phrMontant = var1;
   }

   public int getPhrNombre() {
      return this.phrNombre;
   }

   public void setPhrNombre(int var1) {
      this.phrNombre = var1;
   }

   public int getPhrPosition() {
      return this.phrPosition;
   }

   public void setPhrPosition(int var1) {
      this.phrPosition = var1;
   }

   public int getPhrEtat() {
      return this.phrEtat;
   }

   public void setPhrEtat(int var1) {
      this.phrEtat = var1;
   }

   public String getPhrModeleImp() {
      return this.phrModeleImp;
   }

   public void setPhrModeleImp(String var1) {
      this.phrModeleImp = var1;
   }

   public int getPhrNatureOrigine() {
      return this.phrNatureOrigine;
   }

   public void setPhrNatureOrigine(int var1) {
      this.phrNatureOrigine = var1;
   }

   public boolean isPhrUser1Col01() {
      return this.phrUser1Col01;
   }

   public void setPhrUser1Col01(boolean var1) {
      this.phrUser1Col01 = var1;
   }

   public boolean isPhrUser1Col02() {
      return this.phrUser1Col02;
   }

   public void setPhrUser1Col02(boolean var1) {
      this.phrUser1Col02 = var1;
   }

   public boolean isPhrUser1Col03() {
      return this.phrUser1Col03;
   }

   public void setPhrUser1Col03(boolean var1) {
      this.phrUser1Col03 = var1;
   }

   public boolean isPhrUser1Col04() {
      return this.phrUser1Col04;
   }

   public void setPhrUser1Col04(boolean var1) {
      this.phrUser1Col04 = var1;
   }

   public boolean isPhrUser1Col05() {
      return this.phrUser1Col05;
   }

   public void setPhrUser1Col05(boolean var1) {
      this.phrUser1Col05 = var1;
   }

   public boolean isPhrUser1Col06() {
      return this.phrUser1Col06;
   }

   public void setPhrUser1Col06(boolean var1) {
      this.phrUser1Col06 = var1;
   }

   public boolean isPhrUser1Col07() {
      return this.phrUser1Col07;
   }

   public void setPhrUser1Col07(boolean var1) {
      this.phrUser1Col07 = var1;
   }

   public boolean isPhrUser2Col01() {
      return this.phrUser2Col01;
   }

   public void setPhrUser2Col01(boolean var1) {
      this.phrUser2Col01 = var1;
   }

   public boolean isPhrUser2Col02() {
      return this.phrUser2Col02;
   }

   public void setPhrUser2Col02(boolean var1) {
      this.phrUser2Col02 = var1;
   }

   public boolean isPhrUser2Col03() {
      return this.phrUser2Col03;
   }

   public void setPhrUser2Col03(boolean var1) {
      this.phrUser2Col03 = var1;
   }

   public boolean isPhrUser2Col04() {
      return this.phrUser2Col04;
   }

   public void setPhrUser2Col04(boolean var1) {
      this.phrUser2Col04 = var1;
   }

   public boolean isPhrUser2Col05() {
      return this.phrUser2Col05;
   }

   public void setPhrUser2Col05(boolean var1) {
      this.phrUser2Col05 = var1;
   }

   public boolean isPhrUser2Col06() {
      return this.phrUser2Col06;
   }

   public void setPhrUser2Col06(boolean var1) {
      this.phrUser2Col06 = var1;
   }

   public boolean isPhrUser2Col07() {
      return this.phrUser2Col07;
   }

   public void setPhrUser2Col07(boolean var1) {
      this.phrUser2Col07 = var1;
   }

   public boolean isPhrUser3Col01() {
      return this.phrUser3Col01;
   }

   public void setPhrUser3Col01(boolean var1) {
      this.phrUser3Col01 = var1;
   }

   public boolean isPhrUser3Col02() {
      return this.phrUser3Col02;
   }

   public void setPhrUser3Col02(boolean var1) {
      this.phrUser3Col02 = var1;
   }

   public boolean isPhrUser3Col03() {
      return this.phrUser3Col03;
   }

   public void setPhrUser3Col03(boolean var1) {
      this.phrUser3Col03 = var1;
   }

   public boolean isPhrUser3Col04() {
      return this.phrUser3Col04;
   }

   public void setPhrUser3Col04(boolean var1) {
      this.phrUser3Col04 = var1;
   }

   public boolean isPhrUser3Col05() {
      return this.phrUser3Col05;
   }

   public void setPhrUser3Col05(boolean var1) {
      this.phrUser3Col05 = var1;
   }

   public boolean isPhrUser3Col06() {
      return this.phrUser3Col06;
   }

   public void setPhrUser3Col06(boolean var1) {
      this.phrUser3Col06 = var1;
   }

   public boolean isPhrUser3Col07() {
      return this.phrUser3Col07;
   }

   public void setPhrUser3Col07(boolean var1) {
      this.phrUser3Col07 = var1;
   }

   public boolean isPhrUser4Col01() {
      return this.phrUser4Col01;
   }

   public void setPhrUser4Col01(boolean var1) {
      this.phrUser4Col01 = var1;
   }

   public boolean isPhrUser4Col02() {
      return this.phrUser4Col02;
   }

   public void setPhrUser4Col02(boolean var1) {
      this.phrUser4Col02 = var1;
   }

   public boolean isPhrUser4Col03() {
      return this.phrUser4Col03;
   }

   public void setPhrUser4Col03(boolean var1) {
      this.phrUser4Col03 = var1;
   }

   public boolean isPhrUser4Col04() {
      return this.phrUser4Col04;
   }

   public void setPhrUser4Col04(boolean var1) {
      this.phrUser4Col04 = var1;
   }

   public boolean isPhrUser4Col05() {
      return this.phrUser4Col05;
   }

   public void setPhrUser4Col05(boolean var1) {
      this.phrUser4Col05 = var1;
   }

   public boolean isPhrUser4Col06() {
      return this.phrUser4Col06;
   }

   public void setPhrUser4Col06(boolean var1) {
      this.phrUser4Col06 = var1;
   }

   public boolean isPhrUser4Col07() {
      return this.phrUser4Col07;
   }

   public void setPhrUser4Col07(boolean var1) {
      this.phrUser4Col07 = var1;
   }

   public boolean isPhrUser5Col01() {
      return this.phrUser5Col01;
   }

   public void setPhrUser5Col01(boolean var1) {
      this.phrUser5Col01 = var1;
   }

   public boolean isPhrUser5Col02() {
      return this.phrUser5Col02;
   }

   public void setPhrUser5Col02(boolean var1) {
      this.phrUser5Col02 = var1;
   }

   public boolean isPhrUser5Col03() {
      return this.phrUser5Col03;
   }

   public void setPhrUser5Col03(boolean var1) {
      this.phrUser5Col03 = var1;
   }

   public boolean isPhrUser5Col04() {
      return this.phrUser5Col04;
   }

   public void setPhrUser5Col04(boolean var1) {
      this.phrUser5Col04 = var1;
   }

   public boolean isPhrUser5Col05() {
      return this.phrUser5Col05;
   }

   public void setPhrUser5Col05(boolean var1) {
      this.phrUser5Col05 = var1;
   }

   public boolean isPhrUser5Col06() {
      return this.phrUser5Col06;
   }

   public void setPhrUser5Col06(boolean var1) {
      this.phrUser5Col06 = var1;
   }

   public boolean isPhrUser5Col07() {
      return this.phrUser5Col07;
   }

   public void setPhrUser5Col07(boolean var1) {
      this.phrUser5Col07 = var1;
   }

   public boolean isPhrUser6Col01() {
      return this.phrUser6Col01;
   }

   public void setPhrUser6Col01(boolean var1) {
      this.phrUser6Col01 = var1;
   }

   public boolean isPhrUser6Col02() {
      return this.phrUser6Col02;
   }

   public void setPhrUser6Col02(boolean var1) {
      this.phrUser6Col02 = var1;
   }

   public boolean isPhrUser6Col03() {
      return this.phrUser6Col03;
   }

   public void setPhrUser6Col03(boolean var1) {
      this.phrUser6Col03 = var1;
   }

   public boolean isPhrUser6Col04() {
      return this.phrUser6Col04;
   }

   public void setPhrUser6Col04(boolean var1) {
      this.phrUser6Col04 = var1;
   }

   public boolean isPhrUser6Col05() {
      return this.phrUser6Col05;
   }

   public void setPhrUser6Col05(boolean var1) {
      this.phrUser6Col05 = var1;
   }

   public boolean isPhrUser6Col06() {
      return this.phrUser6Col06;
   }

   public void setPhrUser6Col06(boolean var1) {
      this.phrUser6Col06 = var1;
   }

   public boolean isPhrUser6Col07() {
      return this.phrUser6Col07;
   }

   public void setPhrUser6Col07(boolean var1) {
      this.phrUser6Col07 = var1;
   }

   public String getPhrUser1MemoExplication() {
      return this.phrUser1MemoExplication;
   }

   public void setPhrUser1MemoExplication(String var1) {
      this.phrUser1MemoExplication = var1;
   }

   public String getPhrUser2MemoExplication() {
      return this.phrUser2MemoExplication;
   }

   public void setPhrUser2MemoExplication(String var1) {
      this.phrUser2MemoExplication = var1;
   }

   public String getPhrUser3MemoExplication() {
      return this.phrUser3MemoExplication;
   }

   public void setPhrUser3MemoExplication(String var1) {
      this.phrUser3MemoExplication = var1;
   }

   public String getPhrUser4MemoExplication() {
      return this.phrUser4MemoExplication;
   }

   public void setPhrUser4MemoExplication(String var1) {
      this.phrUser4MemoExplication = var1;
   }

   public String getPhrUser5MemoExplication() {
      return this.phrUser5MemoExplication;
   }

   public void setPhrUser5MemoExplication(String var1) {
      this.phrUser5MemoExplication = var1;
   }

   public String getPhrUser6MemoExplication() {
      return this.phrUser6MemoExplication;
   }

   public void setPhrUser6MemoExplication(String var1) {
      this.phrUser6MemoExplication = var1;
   }

   public String getPhrNomTiers() {
      return this.phrNomTiers;
   }

   public void setPhrNomTiers(String var1) {
      this.phrNomTiers = var1;
   }
}
