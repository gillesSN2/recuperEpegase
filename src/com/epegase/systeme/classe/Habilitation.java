package com.epegase.systeme.classe;

import java.io.Serializable;

public class Habilitation implements Serializable {
   private long habId;
   private int habNature;
   private int habMode;
   private int habNombre;
   private int habMailBloque;
   private long habUser1Id;
   private int habUser1Cat;
   private String habUser1Nom;
   private int habUser2Cat;
   private long habUser2Id;
   private String habUser2Nom;
   private int habUser3Cat;
   private long habUser3Id;
   private String habUser3Nom;
   private int habUser4Cat;
   private long habUser4Id;
   private String habUser4Nom;
   private int habUser5Cat;
   private long habUser5Id;
   private String habUser5Nom;
   private int habUser6Cat;
   private long habUser6Id;
   private String habUser6Nom;
   private long habRemplace1Id;
   private String habRemplace1Nom;
   private long habRemplace2Id;
   private String habRemplace2Nom;
   private long habRemplace3Id;
   private String habRemplace3Nom;
   private long habRemplace4Id;
   private String habRemplace4Nom;
   private long habRemplace5Id;
   private String habRemplace5Nom;
   private long habRemplace6Id;
   private String habRemplace6Nom;
   private String libelleMode;
   private String libelleHab;
   private String libelleMail;

   public long getHabId() {
      return this.habId;
   }

   public String getLibelleMail() {
      if (this.habMailBloque == 0) {
         this.libelleMail = "Autorisé";
      } else {
         this.libelleMail = "Bloqué";
      }

      return this.libelleMail;
   }

   public void setLibelleMail(String var1) {
      this.libelleMail = var1;
   }

   public String getLibelleHab() {
      if (this.habNature == 10) {
         this.libelleHab = "Demande Achat";
      } else if (this.habNature == 11) {
         this.libelleHab = "Cotation";
      } else if (this.habNature == 12) {
         this.libelleHab = "Commande fournisseur";
      } else if (this.habNature == 19) {
         this.libelleHab = "Bon décaissement";
      } else if (this.habNature == 8) {
         this.libelleHab = "Simulation";
      } else if (this.habNature == 20) {
         this.libelleHab = "Besoin";
      } else if (this.habNature == 21) {
         this.libelleHab = "Devis";
      } else if (this.habNature == 22) {
         this.libelleHab = "Bon commande";
      } else if (this.habNature == 23) {
         this.libelleHab = "Bon livraison";
      } else if (this.habNature == 24) {
         this.libelleHab = "Bon retour";
      } else if (this.habNature == 25) {
         this.libelleHab = "Facture";
      } else if (this.habNature == 26) {
         this.libelleHab = "Avoir";
      } else if (this.habNature == 27) {
         this.libelleHab = "Note debit";
      } else if (this.habNature == 28) {
         this.libelleHab = "Chargement";
      } else if (this.habNature == 29) {
         this.libelleHab = "Bon encaissement";
      } else if (this.habNature == 140) {
         this.libelleHab = "Contrat vente";
      } else if (this.habNature == 142) {
         this.libelleHab = "Facture interne";
      } else if (this.habNature == 30) {
         this.libelleHab = "Inventaire";
      } else if (this.habNature == 31) {
         this.libelleHab = "Bon d'entrée";
      } else if (this.habNature == 32) {
         this.libelleHab = "Bon de sortie";
      } else if (this.habNature == 33) {
         this.libelleHab = "Cession";
      } else if (this.habNature == 34) {
         this.libelleHab = "Production";
      } else if (this.habNature == 50) {
         this.libelleHab = "Loyer";
      } else if (this.habNature == 51) {
         this.libelleHab = "Amortissement";
      } else if (this.habNature == 52) {
         this.libelleHab = "Budget";
      } else if (this.habNature == 56) {
         this.libelleHab = "Rapprochement";
      } else if (this.habNature == 62) {
         this.libelleHab = "Bon de sortie";
      } else if (this.habNature == 63) {
         this.libelleHab = "Bon d'entrée";
      } else if (this.habNature == 64) {
         this.libelleHab = "Virement interne";
      } else if (this.habNature == 65) {
         this.libelleHab = "Traite domiciliée";
      } else if (this.habNature == 66) {
         this.libelleHab = "Traite simplifié";
      } else if (this.habNature == 67) {
         this.libelleHab = "Traite entreprise";
      } else if (this.habNature == 71) {
         this.libelleHab = "Consult. Spé.";
      } else if (this.habNature == 73) {
         this.libelleHab = "Pharmacie";
      } else if (this.habNature == 74) {
         this.libelleHab = "Laboratoire";
      } else if (this.habNature == 76) {
         this.libelleHab = "Hospitalisation";
      } else if (this.habNature == 77) {
         this.libelleHab = "Devis";
      } else if (this.habNature == 78) {
         this.libelleHab = "Refacturation";
      } else if (this.habNature == 82) {
         this.libelleHab = "Contrat";
      } else if (this.habNature == 83) {
         this.libelleHab = "Attestation";
      } else if (this.habNature == 84) {
         this.libelleHab = "Cursus";
      } else if (this.habNature == 85) {
         this.libelleHab = "Certificat";
      } else if (this.habNature == 86) {
         this.libelleHab = "Correspondance";
      } else if (this.habNature == 87) {
         this.libelleHab = "Prêts (internes/externes/manuels)";
      } else if (this.habNature == 88) {
         this.libelleHab = "Congés";
      } else if (this.habNature == 89) {
         this.libelleHab = "Absences";
      }

      return this.libelleHab;
   }

   public void setLibelleHab(String var1) {
      this.libelleHab = var1;
   }

   public String getLibelleMode() {
      if (this.habMode == 0) {
         this.libelleMode = "Mono-signature";
      } else if (this.habMode == 1) {
         this.libelleMode = "Multi-signature";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public void setHabId(long var1) {
      this.habId = var1;
   }

   public int getHabMode() {
      return this.habMode;
   }

   public void setHabMode(int var1) {
      this.habMode = var1;
   }

   public int getHabNature() {
      return this.habNature;
   }

   public void setHabNature(int var1) {
      this.habNature = var1;
   }

   public int getHabUser1Cat() {
      return this.habUser1Cat;
   }

   public void setHabUser1Cat(int var1) {
      this.habUser1Cat = var1;
   }

   public long getHabUser1Id() {
      return this.habUser1Id;
   }

   public void setHabUser1Id(long var1) {
      this.habUser1Id = var1;
   }

   public String getHabUser1Nom() {
      return this.habUser1Nom;
   }

   public void setHabUser1Nom(String var1) {
      this.habUser1Nom = var1;
   }

   public int getHabUser2Cat() {
      return this.habUser2Cat;
   }

   public void setHabUser2Cat(int var1) {
      this.habUser2Cat = var1;
   }

   public long getHabUser2Id() {
      return this.habUser2Id;
   }

   public void setHabUser2Id(long var1) {
      this.habUser2Id = var1;
   }

   public String getHabUser2Nom() {
      return this.habUser2Nom;
   }

   public void setHabUser2Nom(String var1) {
      this.habUser2Nom = var1;
   }

   public int getHabUser3Cat() {
      return this.habUser3Cat;
   }

   public void setHabUser3Cat(int var1) {
      this.habUser3Cat = var1;
   }

   public long getHabUser3Id() {
      return this.habUser3Id;
   }

   public void setHabUser3Id(long var1) {
      this.habUser3Id = var1;
   }

   public String getHabUser3Nom() {
      return this.habUser3Nom;
   }

   public void setHabUser3Nom(String var1) {
      this.habUser3Nom = var1;
   }

   public int getHabUser4Cat() {
      return this.habUser4Cat;
   }

   public void setHabUser4Cat(int var1) {
      this.habUser4Cat = var1;
   }

   public long getHabUser4Id() {
      return this.habUser4Id;
   }

   public void setHabUser4Id(long var1) {
      this.habUser4Id = var1;
   }

   public String getHabUser4Nom() {
      return this.habUser4Nom;
   }

   public void setHabUser4Nom(String var1) {
      this.habUser4Nom = var1;
   }

   public int getHabUser5Cat() {
      return this.habUser5Cat;
   }

   public void setHabUser5Cat(int var1) {
      this.habUser5Cat = var1;
   }

   public long getHabUser5Id() {
      return this.habUser5Id;
   }

   public void setHabUser5Id(long var1) {
      this.habUser5Id = var1;
   }

   public String getHabUser5Nom() {
      return this.habUser5Nom;
   }

   public void setHabUser5Nom(String var1) {
      this.habUser5Nom = var1;
   }

   public int getHabUser6Cat() {
      return this.habUser6Cat;
   }

   public void setHabUser6Cat(int var1) {
      this.habUser6Cat = var1;
   }

   public long getHabUser6Id() {
      return this.habUser6Id;
   }

   public void setHabUser6Id(long var1) {
      this.habUser6Id = var1;
   }

   public String getHabUser6Nom() {
      return this.habUser6Nom;
   }

   public void setHabUser6Nom(String var1) {
      this.habUser6Nom = var1;
   }

   public long getHabRemplace1Id() {
      return this.habRemplace1Id;
   }

   public void setHabRemplace1Id(long var1) {
      this.habRemplace1Id = var1;
   }

   public String getHabRemplace1Nom() {
      return this.habRemplace1Nom;
   }

   public void setHabRemplace1Nom(String var1) {
      this.habRemplace1Nom = var1;
   }

   public long getHabRemplace2Id() {
      return this.habRemplace2Id;
   }

   public void setHabRemplace2Id(long var1) {
      this.habRemplace2Id = var1;
   }

   public String getHabRemplace2Nom() {
      return this.habRemplace2Nom;
   }

   public void setHabRemplace2Nom(String var1) {
      this.habRemplace2Nom = var1;
   }

   public long getHabRemplace3Id() {
      return this.habRemplace3Id;
   }

   public void setHabRemplace3Id(long var1) {
      this.habRemplace3Id = var1;
   }

   public String getHabRemplace3Nom() {
      return this.habRemplace3Nom;
   }

   public void setHabRemplace3Nom(String var1) {
      this.habRemplace3Nom = var1;
   }

   public long getHabRemplace4Id() {
      return this.habRemplace4Id;
   }

   public void setHabRemplace4Id(long var1) {
      this.habRemplace4Id = var1;
   }

   public String getHabRemplace4Nom() {
      return this.habRemplace4Nom;
   }

   public void setHabRemplace4Nom(String var1) {
      this.habRemplace4Nom = var1;
   }

   public long getHabRemplace5Id() {
      return this.habRemplace5Id;
   }

   public void setHabRemplace5Id(long var1) {
      this.habRemplace5Id = var1;
   }

   public String getHabRemplace5Nom() {
      return this.habRemplace5Nom;
   }

   public void setHabRemplace5Nom(String var1) {
      this.habRemplace5Nom = var1;
   }

   public long getHabRemplace6Id() {
      return this.habRemplace6Id;
   }

   public void setHabRemplace6Id(long var1) {
      this.habRemplace6Id = var1;
   }

   public String getHabRemplace6Nom() {
      return this.habRemplace6Nom;
   }

   public void setHabRemplace6Nom(String var1) {
      this.habRemplace6Nom = var1;
   }

   public int getHabNombre() {
      return this.habNombre;
   }

   public void setHabNombre(int var1) {
      this.habNombre = var1;
   }

   public int getHabMailBloque() {
      return this.habMailBloque;
   }

   public void setHabMailBloque(int var1) {
      this.habMailBloque = var1;
   }
}
