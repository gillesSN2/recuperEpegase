package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FraisTheoAchats implements Serializable {
   private long fstId;
   private Date fstDateCreat;
   private Date fstDateModif;
   private long fstUserCreat;
   private long fstUserModif;
   private String fstFeuille;
   private int fstType;
   private int fstCategorie;
   private String fstMode;
   private int fstNature;
   private int fstReponse;
   private long fstIdTiers;
   private String fstRubrique;
   private String fstDevise;
   private String fstCode;
   private String fstNomFr;
   private String fstNomUk;
   private String fstNomSp;
   private int fstInactif;
   private String fstTranche;
   private String fstFormuleA;
   private String fstFormuleB;
   private String fstFormuleC;
   private String fstFormuleD;
   private String fstFormuleE;
   private String fstFormuleF;
   private String fstTrancheA;
   private String fstTrancheB;
   private String fstTrancheC;
   private String fstTrancheD;
   private String fstTrancheE;
   private String fstTrancheF;
   private int fstOrdre;
   private int fstColType;
   private int fstDecimalA;
   private int fstDecimalB;
   private int fstDecimalC;
   private int fstDecimalD;
   private int fstDecimalE;
   private int fstDecimalF;
   private String libelle_type;
   private String stypeNature;
   private String libelle_cat;
   private String libelle_nature;

   public String getLibelle_nature() {
      if (this.fstNature == 0) {
         this.libelle_nature = "Avion";
      } else if (this.fstNature == 1) {
         this.libelle_nature = "Bateau";
      } else if (this.fstNature == 2) {
         this.libelle_nature = "Express";
      } else if (this.fstNature == 3) {
         this.libelle_nature = "Route";
      } else if (this.fstNature == 4) {
         this.libelle_nature = "Train";
      }

      return this.libelle_nature;
   }

   public void setLibelle_nature(String var1) {
      this.libelle_nature = var1;
   }

   public String getLibelle_cat() {
      if (this.fstCategorie == 0) {
         this.libelle_cat = "Non spécifié";
      } else if (this.fstCategorie == 1) {
         this.libelle_cat = "Douanes";
      } else if (this.fstCategorie == 2) {
         this.libelle_cat = "Débours";
      } else if (this.fstCategorie == 3) {
         this.libelle_cat = "Prestations";
      } else if (this.fstCategorie == 4) {
         this.libelle_cat = "Autre";
      }

      return this.libelle_cat;
   }

   public void setLibelle_cat(String var1) {
      this.libelle_cat = var1;
   }

   public String getStypeNature() {
      if (this.fstColType == 0) {
         this.stypeNature = "font-style:normal;";
      } else if (this.fstColType == 1) {
         this.stypeNature = "font-weight:bold;";
      } else if (this.fstColType == 2) {
         this.stypeNature = "font-weight:bold;";
      } else if (this.fstColType == 3) {
         this.stypeNature = "font-style:italic;";
      }

      return this.stypeNature;
   }

   public void setStypeNature(String var1) {
      this.stypeNature = var1;
   }

   public String getLibelle_type() {
      if (this.fstType == 0) {
         this.libelle_type = "Calcul sur Fiche Produit";
      } else if (this.fstType == 1) {
         this.libelle_type = "Calcul sur Cotation Achat";
      } else if (this.fstType == 2) {
         this.libelle_type = "Calcul sur Commande Achat";
      } else if (this.fstType == 3) {
         this.libelle_type = "Calcul sur Fournisseur";
      }

      return this.libelle_type;
   }

   public void setLibelle_type(String var1) {
      this.libelle_type = var1;
   }

   public String getFstCode() {
      return this.fstCode;
   }

   public void setFstCode(String var1) {
      this.fstCode = var1;
   }

   public Date getFstDateCreat() {
      return this.fstDateCreat;
   }

   public void setFstDateCreat(Date var1) {
      this.fstDateCreat = var1;
   }

   public Date getFstDateModif() {
      return this.fstDateModif;
   }

   public void setFstDateModif(Date var1) {
      this.fstDateModif = var1;
   }

   public String getFstFeuille() {
      return this.fstFeuille;
   }

   public void setFstFeuille(String var1) {
      this.fstFeuille = var1;
   }

   public String getFstTranche() {
      return this.fstTranche;
   }

   public void setFstTranche(String var1) {
      this.fstTranche = var1;
   }

   public long getFstId() {
      return this.fstId;
   }

   public void setFstId(long var1) {
      this.fstId = var1;
   }

   public int getFstInactif() {
      return this.fstInactif;
   }

   public void setFstInactif(int var1) {
      this.fstInactif = var1;
   }

   public String getFstNomFr() {
      return this.fstNomFr;
   }

   public void setFstNomFr(String var1) {
      this.fstNomFr = var1;
   }

   public String getFstNomSp() {
      return this.fstNomSp;
   }

   public void setFstNomSp(String var1) {
      this.fstNomSp = var1;
   }

   public String getFstNomUk() {
      return this.fstNomUk;
   }

   public void setFstNomUk(String var1) {
      this.fstNomUk = var1;
   }

   public int getFstOrdre() {
      return this.fstOrdre;
   }

   public void setFstOrdre(int var1) {
      this.fstOrdre = var1;
   }

   public long getFstUserCreat() {
      return this.fstUserCreat;
   }

   public void setFstUserCreat(long var1) {
      this.fstUserCreat = var1;
   }

   public long getFstUserModif() {
      return this.fstUserModif;
   }

   public void setFstUserModif(long var1) {
      this.fstUserModif = var1;
   }

   public int getFstType() {
      return this.fstType;
   }

   public void setFstType(int var1) {
      this.fstType = var1;
   }

   public int getFstColType() {
      return this.fstColType;
   }

   public void setFstColType(int var1) {
      this.fstColType = var1;
   }

   public String getFstFormuleA() {
      return this.fstFormuleA;
   }

   public void setFstFormuleA(String var1) {
      this.fstFormuleA = var1;
   }

   public String getFstFormuleB() {
      return this.fstFormuleB;
   }

   public void setFstFormuleB(String var1) {
      this.fstFormuleB = var1;
   }

   public String getFstFormuleC() {
      return this.fstFormuleC;
   }

   public void setFstFormuleC(String var1) {
      this.fstFormuleC = var1;
   }

   public String getFstFormuleD() {
      return this.fstFormuleD;
   }

   public void setFstFormuleD(String var1) {
      this.fstFormuleD = var1;
   }

   public int getFstDecimalA() {
      return this.fstDecimalA;
   }

   public void setFstDecimalA(int var1) {
      this.fstDecimalA = var1;
   }

   public int getFstDecimalB() {
      return this.fstDecimalB;
   }

   public void setFstDecimalB(int var1) {
      this.fstDecimalB = var1;
   }

   public int getFstDecimalC() {
      return this.fstDecimalC;
   }

   public void setFstDecimalC(int var1) {
      this.fstDecimalC = var1;
   }

   public int getFstDecimalD() {
      return this.fstDecimalD;
   }

   public void setFstDecimalD(int var1) {
      this.fstDecimalD = var1;
   }

   public long getFstIdTiers() {
      return this.fstIdTiers;
   }

   public void setFstIdTiers(long var1) {
      this.fstIdTiers = var1;
   }

   public String getFstTrancheA() {
      return this.fstTrancheA;
   }

   public void setFstTrancheA(String var1) {
      this.fstTrancheA = var1;
   }

   public String getFstTrancheB() {
      return this.fstTrancheB;
   }

   public void setFstTrancheB(String var1) {
      this.fstTrancheB = var1;
   }

   public String getFstTrancheC() {
      return this.fstTrancheC;
   }

   public void setFstTrancheC(String var1) {
      this.fstTrancheC = var1;
   }

   public String getFstTrancheD() {
      return this.fstTrancheD;
   }

   public void setFstTrancheD(String var1) {
      this.fstTrancheD = var1;
   }

   public int getFstCategorie() {
      return this.fstCategorie;
   }

   public void setFstCategorie(int var1) {
      this.fstCategorie = var1;
   }

   public String getFstMode() {
      return this.fstMode;
   }

   public void setFstMode(String var1) {
      this.fstMode = var1;
   }

   public int getFstNature() {
      return this.fstNature;
   }

   public void setFstNature(int var1) {
      this.fstNature = var1;
   }

   public String getFstFormuleE() {
      return this.fstFormuleE;
   }

   public void setFstFormuleE(String var1) {
      this.fstFormuleE = var1;
   }

   public String getFstTrancheE() {
      return this.fstTrancheE;
   }

   public void setFstTrancheE(String var1) {
      this.fstTrancheE = var1;
   }

   public int getFstDecimalE() {
      return this.fstDecimalE;
   }

   public void setFstDecimalE(int var1) {
      this.fstDecimalE = var1;
   }

   public String getFstRubrique() {
      return this.fstRubrique;
   }

   public void setFstRubrique(String var1) {
      this.fstRubrique = var1;
   }

   public String getFstDevise() {
      return this.fstDevise;
   }

   public void setFstDevise(String var1) {
      this.fstDevise = var1;
   }

   public int getFstReponse() {
      return this.fstReponse;
   }

   public void setFstReponse(int var1) {
      this.fstReponse = var1;
   }

   public int getFstDecimalF() {
      return this.fstDecimalF;
   }

   public void setFstDecimalF(int var1) {
      this.fstDecimalF = var1;
   }

   public String getFstFormuleF() {
      return this.fstFormuleF;
   }

   public void setFstFormuleF(String var1) {
      this.fstFormuleF = var1;
   }

   public String getFstTrancheF() {
      return this.fstTrancheF;
   }

   public void setFstTrancheF(String var1) {
      this.fstTrancheF = var1;
   }
}
