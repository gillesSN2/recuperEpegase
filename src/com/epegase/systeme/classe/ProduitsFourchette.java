package com.epegase.systeme.classe;

import java.io.Serializable;

public class ProduitsFourchette implements Serializable {
   private long profchId;
   private String profchCode;
   private int profchSexe;
   private int profchAge;
   private float profchAgeDebut;
   private float profchAgeFin;
   private float profchFmini;
   private float profchFmaxi;
   private float profchLmini;
   private float profchLmaxi;
   private String profchNorme;
   private ProduitsLaboratoire produitsLaboratoire;
   private ProduitsDetail produitsDetail;
   private String var_sexe;
   private String var_age;

   public ProduitsLaboratoire getProduitsLaboratoire() {
      return this.produitsLaboratoire;
   }

   public void setProduitsLaboratoire(ProduitsLaboratoire var1) {
      this.produitsLaboratoire = var1;
   }

   public int getProfchAge() {
      return this.profchAge;
   }

   public void setProfchAge(int var1) {
      this.profchAge = var1;
   }

   public float getProfchAgeDebut() {
      return this.profchAgeDebut;
   }

   public void setProfchAgeDebut(float var1) {
      this.profchAgeDebut = var1;
   }

   public float getProfchAgeFin() {
      return this.profchAgeFin;
   }

   public void setProfchAgeFin(float var1) {
      this.profchAgeFin = var1;
   }

   public float getProfchFmaxi() {
      return this.profchFmaxi;
   }

   public void setProfchFmaxi(float var1) {
      this.profchFmaxi = var1;
   }

   public float getProfchFmini() {
      return this.profchFmini;
   }

   public void setProfchFmini(float var1) {
      this.profchFmini = var1;
   }

   public long getProfchId() {
      return this.profchId;
   }

   public void setProfchId(long var1) {
      this.profchId = var1;
   }

   public float getProfchLmaxi() {
      return this.profchLmaxi;
   }

   public void setProfchLmaxi(float var1) {
      this.profchLmaxi = var1;
   }

   public float getProfchLmini() {
      return this.profchLmini;
   }

   public void setProfchLmini(float var1) {
      this.profchLmini = var1;
   }

   public String getProfchNorme() {
      return this.profchNorme;
   }

   public void setProfchNorme(String var1) {
      this.profchNorme = var1;
   }

   public int getProfchSexe() {
      return this.profchSexe;
   }

   public void setProfchSexe(int var1) {
      this.profchSexe = var1;
   }

   public String getVar_age() {
      if (this.profchAge == 0) {
         this.var_age = "Tout age";
      } else if (this.profchAge == 1) {
         this.var_age = "Bébé";
      } else if (this.profchAge == 2) {
         this.var_age = "Enfant";
      } else if (this.profchAge == 3) {
         this.var_age = "Adolescent";
      } else if (this.profchAge == 4) {
         this.var_age = "Adulte";
      } else if (this.profchAge == 5) {
         this.var_age = "Sénior";
      } else if (this.profchAge == 10) {
         this.var_age = "Age Année";
      } else if (this.profchAge == 11) {
         this.var_age = "Age Mois";
      } else if (this.profchAge == 12) {
         this.var_age = "Age Jour";
      }

      return this.var_age;
   }

   public void setVar_age(String var1) {
      this.var_age = var1;
   }

   public String getVar_sexe() {
      if (this.profchSexe == 0) {
         this.var_sexe = "Femme";
      } else if (this.profchSexe == 1) {
         this.var_sexe = "Homme";
      } else if (this.profchSexe == 2) {
         this.var_sexe = "Tout sexe";
      }

      return this.var_sexe;
   }

   public void setVar_sexe(String var1) {
      this.var_sexe = var1;
   }

   public ProduitsDetail getProduitsDetail() {
      return this.produitsDetail;
   }

   public void setProduitsDetail(ProduitsDetail var1) {
      this.produitsDetail = var1;
   }

   public String getProfchCode() {
      return this.profchCode;
   }

   public void setProfchCode(String var1) {
      this.profchCode = var1;
   }
}
