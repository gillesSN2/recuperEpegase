package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;

public class SalariesPrets implements Serializable {
   private long salpreId;
   private Date salpreDateCreat;
   private Date salpreDateModif;
   private long salpreUserCreat;
   private long salpreUserModif;
   private int salpreType;
   private int salpreNature;
   private Date salpreDateSouscription;
   private String salpreNum;
   private String salpreContrat;
   private double salpreMontant;
   private double salpreRmb;
   private Date salpreDateDebut;
   private Date salpreDateFin;
   private int salpreEcheance;
   private String salpreObjet;
   private String salpreDescriptif;
   private String salpreReference;
   private String salpreResponsable;
   private String salpreService;
   private String salpreJournal;
   private int salpreEtatVal;
   private int salpreEtat;
   private Date salpreDateValide;
   private int salprePosSignature;
   private Date salpreDateImp;
   private int salpreArrondi;
   private String salpreCompte;
   private Salaries salaries;
   private String lib_nature;
   private String libelleEtat;
   private Date date_echeance;
   private double montant_echeance;
   private String color;
   private double solde;
   private String lib_type;
   private Date dateFin;
   private List mesNaturesPretsItems;

   public SalariesPrets() {
      this.mesNaturesPretsItems = new ArrayList();
   }

   public SalariesPrets(List var1) {
      this.mesNaturesPretsItems = var1;
   }

   public Date getDateFin() {
      return this.dateFin;
   }

   public void setDateFin(Date var1) {
      this.dateFin = var1;
   }

   public String getLib_type() {
      if (this.salpreType == 0) {
         this.lib_type = "Prêt interne";
      } else if (this.salpreType == 1) {
         this.lib_type = "Prêt externe";
      } else if (this.salpreType == 2) {
         this.lib_type = "Prêt manuel";
      }

      return this.lib_type;
   }

   public void setLib_type(String var1) {
      this.lib_type = var1;
   }

   public double getSolde() {
      this.solde = this.salpreMontant - this.salpreRmb;
      return this.solde;
   }

   public void setSolde(double var1) {
      this.solde = var1;
   }

   public String getColor() {
      if (this.salpreEtat == 2) {
         this.color = "color:grey;";
      } else if (this.salaries.getSalProtege() == 1) {
         if (this.salpreRmb < this.salpreMontant && this.salpreMontant != 0.0D) {
            this.color = "color:purple;";
         } else {
            this.color = "color:grey;";
         }
      } else if (this.salpreRmb < this.salpreMontant && this.salpreMontant != 0.0D) {
         this.color = "color:red;";
      } else {
         this.color = "color:black;";
      }

      return this.color;
   }

   public void setColor(String var1) {
      this.color = var1;
   }

   public Date getDate_echeance() {
      return this.date_echeance;
   }

   public void setDate_echeance(Date var1) {
      this.date_echeance = var1;
   }

   public double getMontant_echeance() {
      return this.montant_echeance;
   }

   public void setMontant_echeance(double var1) {
      this.montant_echeance = var1;
   }

   public String getLib_nature() {
      if (this.mesNaturesPretsItems != null && this.mesNaturesPretsItems.size() != 0) {
         for(int var1 = 0; var1 < this.mesNaturesPretsItems.size(); ++var1) {
            if (((SelectItem)this.mesNaturesPretsItems.get(var1)).getValue().toString().equals("" + this.salpreNature)) {
               this.lib_nature = ((SelectItem)this.mesNaturesPretsItems.get(var1)).getLabel().toString();
            }
         }
      } else if (this.salpreNature == 0) {
         this.lib_nature = "Non renseigné";
      } else if (this.salpreNature == 1) {
         this.lib_nature = "Avances Exceptionnelles";
      } else if (this.salpreNature == 2) {
         this.lib_nature = "Soins Médicaux";
      } else if (this.salpreNature == 3) {
         this.lib_nature = "Cessions";
      } else if (this.salpreNature == 4) {
         this.lib_nature = "Traites";
      } else if (this.salpreNature == 5) {
         this.lib_nature = "Familiaux";
      } else if (this.salpreNature == 6) {
         this.lib_nature = "Religieux";
      } else if (this.salpreNature == 7) {
         this.lib_nature = "Avances étalées";
      } else {
         this.lib_nature = "Autre nature";
      }

      return this.lib_nature;
   }

   public void setLib_nature(String var1) {
      this.lib_nature = var1;
   }

   public String getLibelleEtat() {
      if (this.salpreEtat == 0) {
         this.libelleEtat = "N.Val.";
      } else if (this.salpreEtat == 1) {
         this.libelleEtat = "Val.";
      } else if (this.salpreEtat == 2) {
         this.libelleEtat = "Gel.";
      } else if (this.salpreEtat == 3) {
         this.libelleEtat = "Annul.";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public Date getSalpreDateCreat() {
      return this.salpreDateCreat;
   }

   public void setSalpreDateCreat(Date var1) {
      this.salpreDateCreat = var1;
   }

   public Date getSalpreDateDebut() {
      return this.salpreDateDebut;
   }

   public void setSalpreDateDebut(Date var1) {
      this.salpreDateDebut = var1;
   }

   public Date getSalpreDateImp() {
      return this.salpreDateImp;
   }

   public void setSalpreDateImp(Date var1) {
      this.salpreDateImp = var1;
   }

   public Date getSalpreDateModif() {
      return this.salpreDateModif;
   }

   public void setSalpreDateModif(Date var1) {
      this.salpreDateModif = var1;
   }

   public Date getSalpreDateSouscription() {
      return this.salpreDateSouscription;
   }

   public void setSalpreDateSouscription(Date var1) {
      this.salpreDateSouscription = var1;
   }

   public Date getSalpreDateValide() {
      return this.salpreDateValide;
   }

   public void setSalpreDateValide(Date var1) {
      this.salpreDateValide = var1;
   }

   public int getSalpreEcheance() {
      return this.salpreEcheance;
   }

   public void setSalpreEcheance(int var1) {
      this.salpreEcheance = var1;
   }

   public int getSalpreEtat() {
      return this.salpreEtat;
   }

   public void setSalpreEtat(int var1) {
      this.salpreEtat = var1;
   }

   public int getSalpreEtatVal() {
      return this.salpreEtatVal;
   }

   public void setSalpreEtatVal(int var1) {
      this.salpreEtatVal = var1;
   }

   public long getSalpreId() {
      return this.salpreId;
   }

   public void setSalpreId(long var1) {
      this.salpreId = var1;
   }

   public String getSalpreJournal() {
      return this.salpreJournal;
   }

   public void setSalpreJournal(String var1) {
      this.salpreJournal = var1;
   }

   public double getSalpreMontant() {
      return this.salpreMontant;
   }

   public void setSalpreMontant(double var1) {
      this.salpreMontant = var1;
   }

   public int getSalpreNature() {
      return this.salpreNature;
   }

   public void setSalpreNature(int var1) {
      this.salpreNature = var1;
   }

   public String getSalpreNum() {
      return this.salpreNum;
   }

   public void setSalpreNum(String var1) {
      this.salpreNum = var1;
   }

   public String getSalpreObjet() {
      return this.salpreObjet;
   }

   public void setSalpreObjet(String var1) {
      this.salpreObjet = var1;
   }

   public String getSalpreReference() {
      return this.salpreReference;
   }

   public void setSalpreReference(String var1) {
      this.salpreReference = var1;
   }

   public String getSalpreResponsable() {
      return this.salpreResponsable;
   }

   public void setSalpreResponsable(String var1) {
      this.salpreResponsable = var1;
   }

   public int getSalpreType() {
      return this.salpreType;
   }

   public void setSalpreType(int var1) {
      this.salpreType = var1;
   }

   public long getSalpreUserCreat() {
      return this.salpreUserCreat;
   }

   public void setSalpreUserCreat(long var1) {
      this.salpreUserCreat = var1;
   }

   public long getSalpreUserModif() {
      return this.salpreUserModif;
   }

   public void setSalpreUserModif(long var1) {
      this.salpreUserModif = var1;
   }

   public double getSalpreRmb() {
      return this.salpreRmb;
   }

   public void setSalpreRmb(double var1) {
      this.salpreRmb = var1;
   }

   public String getSalpreService() {
      return this.salpreService;
   }

   public void setSalpreService(String var1) {
      this.salpreService = var1;
   }

   public String getSalpreDescriptif() {
      return this.salpreDescriptif;
   }

   public void setSalpreDescriptif(String var1) {
      this.salpreDescriptif = var1;
   }

   public Date getSalpreDateFin() {
      return this.salpreDateFin;
   }

   public void setSalpreDateFin(Date var1) {
      this.salpreDateFin = var1;
   }

   public int getSalpreArrondi() {
      return this.salpreArrondi;
   }

   public void setSalpreArrondi(int var1) {
      this.salpreArrondi = var1;
   }

   public String getSalpreCompte() {
      return this.salpreCompte;
   }

   public void setSalpreCompte(String var1) {
      this.salpreCompte = var1;
   }

   public int getSalprePosSignature() {
      return this.salprePosSignature;
   }

   public void setSalprePosSignature(int var1) {
      this.salprePosSignature = var1;
   }

   public String getSalpreContrat() {
      return this.salpreContrat;
   }

   public void setSalpreContrat(String var1) {
      this.salpreContrat = var1;
   }
}
