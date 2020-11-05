package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class DocumentTraceVentes implements Serializable {
   private long doctraId;
   private Date doctraDateCreat;
   private long doctraUserId;
   private String doctraUserNom;
   private int doctraOrgType;
   private String doctraOrgNum;
   private Date doctraOrgDate;
   private String doctraOrgSerie;
   private long doctraOrgId;
   private int doctraDstType;
   private String doctraDstNum;
   private Date doctraDstDate;
   private String doctraDstSerie;
   private long doctraDstId;
   private ExercicesVentes exerciceventes;
   private String var_lib_org;
   private String var_lib_dst;

   public Date getDoctraDateCreat() {
      return this.doctraDateCreat;
   }

   public void setDoctraDateCreat(Date var1) {
      this.doctraDateCreat = var1;
   }

   public Date getDoctraDstDate() {
      return this.doctraDstDate;
   }

   public void setDoctraDstDate(Date var1) {
      this.doctraDstDate = var1;
   }

   public long getDoctraDstId() {
      return this.doctraDstId;
   }

   public void setDoctraDstId(long var1) {
      this.doctraDstId = var1;
   }

   public String getDoctraDstNum() {
      return this.doctraDstNum;
   }

   public void setDoctraDstNum(String var1) {
      this.doctraDstNum = var1;
   }

   public String getDoctraDstSerie() {
      return this.doctraDstSerie;
   }

   public void setDoctraDstSerie(String var1) {
      this.doctraDstSerie = var1;
   }

   public int getDoctraDstType() {
      return this.doctraDstType;
   }

   public void setDoctraDstType(int var1) {
      this.doctraDstType = var1;
   }

   public long getDoctraId() {
      return this.doctraId;
   }

   public void setDoctraId(long var1) {
      this.doctraId = var1;
   }

   public Date getDoctraOrgDate() {
      return this.doctraOrgDate;
   }

   public void setDoctraOrgDate(Date var1) {
      this.doctraOrgDate = var1;
   }

   public long getDoctraOrgId() {
      return this.doctraOrgId;
   }

   public void setDoctraOrgId(long var1) {
      this.doctraOrgId = var1;
   }

   public String getDoctraOrgNum() {
      return this.doctraOrgNum;
   }

   public void setDoctraOrgNum(String var1) {
      this.doctraOrgNum = var1;
   }

   public String getDoctraOrgSerie() {
      return this.doctraOrgSerie;
   }

   public void setDoctraOrgSerie(String var1) {
      this.doctraOrgSerie = var1;
   }

   public int getDoctraOrgType() {
      return this.doctraOrgType;
   }

   public void setDoctraOrgType(int var1) {
      this.doctraOrgType = var1;
   }

   public long getDoctraUserId() {
      return this.doctraUserId;
   }

   public void setDoctraUserId(long var1) {
      this.doctraUserId = var1;
   }

   public String getDoctraUserNom() {
      return this.doctraUserNom;
   }

   public void setDoctraUserNom(String var1) {
      this.doctraUserNom = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public String getVar_lib_dst() {
      if (this.doctraOrgType == 10) {
         this.var_lib_dst = "Demande Achat";
      } else if (this.doctraDstType == 11) {
         this.var_lib_dst = "Cotation";
      } else if (this.doctraDstType == 12) {
         this.var_lib_dst = "Commande fournisseur";
      } else if (this.doctraDstType == 13) {
         this.var_lib_dst = "Réception";
      } else if (this.doctraDstType == 14) {
         this.var_lib_dst = "Retour fournisseur";
      } else if (this.doctraDstType == 15) {
         this.var_lib_dst = "Facture fournisseur";
      } else if (this.doctraDstType == 16) {
         this.var_lib_dst = "Avoir fournisseur";
      } else if (this.doctraDstType == 17) {
         this.var_lib_dst = "Note débit fournisseur";
      } else if (this.doctraDstType == 18) {
         this.var_lib_dst = "Frais fournisseur";
      } else if (this.doctraDstType == 19) {
         this.var_lib_dst = "Collecte";
      } else if (this.doctraDstType == 20) {
         this.var_lib_dst = "Besoin";
      } else if (this.doctraDstType == 21) {
         this.var_lib_dst = "Devis";
      } else if (this.doctraDstType == 22) {
         this.var_lib_dst = "Bon commande";
      } else if (this.doctraDstType == 23) {
         this.var_lib_dst = "Bon livraison";
      } else if (this.doctraDstType == 24) {
         this.var_lib_dst = "Bon retour";
      } else if (this.doctraDstType == 25) {
         this.var_lib_dst = "Facture";
      } else if (this.doctraDstType == 26) {
         this.var_lib_dst = "Avoir";
      } else if (this.doctraDstType == 27) {
         this.var_lib_dst = "Note debit";
      } else if (this.doctraDstType == 28) {
         this.var_lib_dst = "Chargement";
      }

      return this.var_lib_dst;
   }

   public void setVar_lib_dst(String var1) {
      this.var_lib_dst = var1;
   }

   public String getVar_lib_org() {
      if (this.doctraOrgType == 10) {
         this.var_lib_org = "Demande Achat";
      } else if (this.doctraOrgType == 11) {
         this.var_lib_org = "Cotation";
      } else if (this.doctraOrgType == 12) {
         this.var_lib_org = "Commande fournisseur";
      } else if (this.doctraOrgType == 13) {
         this.var_lib_org = "Réception";
      } else if (this.doctraOrgType == 14) {
         this.var_lib_org = "Retour fournisseur";
      } else if (this.doctraOrgType == 15) {
         this.var_lib_org = "Facture fournisseur";
      } else if (this.doctraOrgType == 16) {
         this.var_lib_org = "Avoir fournisseur";
      } else if (this.doctraOrgType == 17) {
         this.var_lib_org = "Note débit fournisseur";
      } else if (this.doctraOrgType == 18) {
         this.var_lib_org = "Frais fournisseur";
      } else if (this.doctraOrgType == 19) {
         this.var_lib_org = "Collecte";
      } else if (this.doctraOrgType == 20) {
         this.var_lib_org = "Besoin";
      } else if (this.doctraOrgType == 21) {
         this.var_lib_org = "Devis";
      } else if (this.doctraOrgType == 22) {
         this.var_lib_org = "Bon commande";
      } else if (this.doctraOrgType == 23) {
         this.var_lib_org = "Bon livraison";
      } else if (this.doctraOrgType == 24) {
         this.var_lib_org = "Bon retour";
      } else if (this.doctraOrgType == 25) {
         this.var_lib_org = "Facture";
      } else if (this.doctraOrgType == 26) {
         this.var_lib_org = "Avoir";
      } else if (this.doctraOrgType == 27) {
         this.var_lib_org = "Note debit";
      } else if (this.doctraOrgType == 28) {
         this.var_lib_org = "Chargement";
      }

      return this.var_lib_org;
   }

   public void setVar_lib_org(String var1) {
      this.var_lib_org = var1;
   }
}
