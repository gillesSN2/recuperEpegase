package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class DocumentTraceAchats implements Serializable {
   private long doctrfId;
   private Date doctrfDateCreat;
   private long doctrfUserId;
   private String doctrfUserNom;
   private int doctrfOrgType;
   private String doctrfOrgNum;
   private Date doctrfOrgDate;
   private String doctrfOrgSerie;
   private long doctrfOrgId;
   private int doctrfDstType;
   private String doctrfDstNum;
   private Date doctrfDstDate;
   private String doctrfDstSerie;
   private long doctrfDstId;
   private ExercicesAchats exercicesAchats;
   private String var_lib_org;
   private String var_lib_dst;

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public String getVar_lib_dst() {
      if (this.doctrfDstType == 10) {
         this.var_lib_dst = "Demande Achat";
      } else if (this.doctrfDstType == 11) {
         this.var_lib_dst = "Cotation";
      } else if (this.doctrfDstType == 12) {
         this.var_lib_dst = "Commande fournisseur";
      } else if (this.doctrfDstType == 13) {
         this.var_lib_dst = "Réception";
      } else if (this.doctrfDstType == 14) {
         this.var_lib_dst = "Retour fournisseur";
      } else if (this.doctrfDstType == 15) {
         this.var_lib_dst = "Facture fournisseur";
      } else if (this.doctrfDstType == 16) {
         this.var_lib_dst = "Avoir fournisseur";
      } else if (this.doctrfDstType == 17) {
         this.var_lib_dst = "Note débit fournisseur";
      } else if (this.doctrfDstType == 18) {
         this.var_lib_dst = "Frais fournisseur";
      } else if (this.doctrfDstType == 19) {
         this.var_lib_dst = "Collecte";
      } else if (this.doctrfDstType == 20) {
         this.var_lib_dst = "Besoin";
      } else if (this.doctrfDstType == 21) {
         this.var_lib_dst = "Devis";
      } else if (this.doctrfDstType == 22) {
         this.var_lib_dst = "Bon commande";
      } else if (this.doctrfDstType == 23) {
         this.var_lib_dst = "Bon livraison";
      } else if (this.doctrfDstType == 24) {
         this.var_lib_dst = "Bon retour";
      } else if (this.doctrfDstType == 25) {
         this.var_lib_dst = "Facture";
      } else if (this.doctrfDstType == 26) {
         this.var_lib_dst = "Avoir";
      } else if (this.doctrfDstType == 27) {
         this.var_lib_dst = "Note debit";
      } else if (this.doctrfDstType == 28) {
         this.var_lib_dst = "Chargement";
      }

      return this.var_lib_dst;
   }

   public void setVar_lib_dst(String var1) {
      this.var_lib_dst = var1;
   }

   public String getVar_lib_org() {
      if (this.doctrfOrgType == 10) {
         this.var_lib_org = "Demande Achat";
      } else if (this.doctrfOrgType == 11) {
         this.var_lib_org = "Cotation";
      } else if (this.doctrfOrgType == 12) {
         this.var_lib_org = "Commande fournisseur";
      } else if (this.doctrfOrgType == 13) {
         this.var_lib_org = "Réception";
      } else if (this.doctrfOrgType == 14) {
         this.var_lib_org = "Retour fournisseur";
      } else if (this.doctrfOrgType == 15) {
         this.var_lib_org = "Facture fournisseur";
      } else if (this.doctrfOrgType == 16) {
         this.var_lib_org = "Avoir fournisseur";
      } else if (this.doctrfOrgType == 17) {
         this.var_lib_org = "Note débit fournisseur";
      } else if (this.doctrfOrgType == 18) {
         this.var_lib_org = "Frais fournisseur";
      } else if (this.doctrfOrgType == 19) {
         this.var_lib_org = "Collecte";
      } else if (this.doctrfOrgType == 20) {
         this.var_lib_org = "Besoin";
      } else if (this.doctrfOrgType == 21) {
         this.var_lib_org = "Devis";
      } else if (this.doctrfOrgType == 22) {
         this.var_lib_org = "Bon commande";
      } else if (this.doctrfOrgType == 23) {
         this.var_lib_org = "Bon livraison";
      } else if (this.doctrfOrgType == 24) {
         this.var_lib_org = "Bon retour";
      } else if (this.doctrfOrgType == 25) {
         this.var_lib_org = "Facture";
      } else if (this.doctrfOrgType == 26) {
         this.var_lib_org = "Avoir";
      } else if (this.doctrfOrgType == 27) {
         this.var_lib_org = "Note debit";
      } else if (this.doctrfOrgType == 28) {
         this.var_lib_org = "Chargement";
      }

      return this.var_lib_org;
   }

   public void setVar_lib_org(String var1) {
      this.var_lib_org = var1;
   }

   public Date getDoctrfDateCreat() {
      return this.doctrfDateCreat;
   }

   public void setDoctrfDateCreat(Date var1) {
      this.doctrfDateCreat = var1;
   }

   public Date getDoctrfDstDate() {
      return this.doctrfDstDate;
   }

   public void setDoctrfDstDate(Date var1) {
      this.doctrfDstDate = var1;
   }

   public long getDoctrfDstId() {
      return this.doctrfDstId;
   }

   public void setDoctrfDstId(long var1) {
      this.doctrfDstId = var1;
   }

   public String getDoctrfDstNum() {
      return this.doctrfDstNum;
   }

   public void setDoctrfDstNum(String var1) {
      this.doctrfDstNum = var1;
   }

   public String getDoctrfDstSerie() {
      return this.doctrfDstSerie;
   }

   public void setDoctrfDstSerie(String var1) {
      this.doctrfDstSerie = var1;
   }

   public int getDoctrfDstType() {
      return this.doctrfDstType;
   }

   public void setDoctrfDstType(int var1) {
      this.doctrfDstType = var1;
   }

   public long getDoctrfId() {
      return this.doctrfId;
   }

   public void setDoctrfId(long var1) {
      this.doctrfId = var1;
   }

   public Date getDoctrfOrgDate() {
      return this.doctrfOrgDate;
   }

   public void setDoctrfOrgDate(Date var1) {
      this.doctrfOrgDate = var1;
   }

   public long getDoctrfOrgId() {
      return this.doctrfOrgId;
   }

   public void setDoctrfOrgId(long var1) {
      this.doctrfOrgId = var1;
   }

   public String getDoctrfOrgNum() {
      return this.doctrfOrgNum;
   }

   public void setDoctrfOrgNum(String var1) {
      this.doctrfOrgNum = var1;
   }

   public String getDoctrfOrgSerie() {
      return this.doctrfOrgSerie;
   }

   public void setDoctrfOrgSerie(String var1) {
      this.doctrfOrgSerie = var1;
   }

   public int getDoctrfOrgType() {
      return this.doctrfOrgType;
   }

   public void setDoctrfOrgType(int var1) {
      this.doctrfOrgType = var1;
   }

   public long getDoctrfUserId() {
      return this.doctrfUserId;
   }

   public void setDoctrfUserId(long var1) {
      this.doctrfUserId = var1;
   }

   public String getDoctrfUserNom() {
      return this.doctrfUserNom;
   }

   public void setDoctrfUserNom(String var1) {
      this.doctrfUserNom = var1;
   }
}
