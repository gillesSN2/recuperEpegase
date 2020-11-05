package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class DepotAchats implements Serializable {
   private long dpoId;
   private Date dpoDateCreation;
   private Date dpoDateModif;
   private long dpoUserCreation;
   private long dpoUserModif;
   private String dpoCode;
   private String dpoLibelle;
   private String dpoService;
   private String dpoDepartement;
   private String dpoSite;
   private int dpoType;
   private float dpoQteMin;
   private float dpoQteMax;
   private int dpoDefautIn;
   private int dpoDefautOut;
   private int dpoInactif;
   private int dpoReception;
   private int dpoRetourAch;
   private int dpoCollecteAch;
   private int dpoLivraison;
   private int dpoPharmacie;
   private int dpoCarburant;
   private int dpoRetourVent;
   private int dpoMobileVent;
   private int dpoReachmin;
   private int dpoFabrication;
   private int dpoCession;
   private int dpoBonSortie;
   private int dpoBonEntree;
   private int dpoInventaire;
   private String typLib;
   private String dpoAdresse;
   private String dpoResponsable;
   private String etat;
   private boolean inactif;
   private boolean selectDepot;
   private boolean reception;
   private boolean retourAch;
   private boolean livraison;
   private boolean retourVent;
   private boolean mobileVent;
   private boolean inventaire;
   private boolean bonEntree;
   private boolean bonSortie;
   private boolean cession;
   private boolean fabrication;
   private boolean reachmin;
   private boolean carburant;

   public boolean isBonEntree() {
      if (this.dpoBonEntree == 1) {
         this.bonEntree = true;
      } else {
         this.bonEntree = false;
      }

      return this.bonEntree;
   }

   public void setBonEntree(boolean var1) {
      this.bonEntree = var1;
   }

   public boolean isBonSortie() {
      if (this.dpoBonSortie == 1) {
         this.bonSortie = true;
      } else {
         this.bonSortie = false;
      }

      return this.bonSortie;
   }

   public void setBonSortie(boolean var1) {
      this.bonSortie = var1;
   }

   public boolean isCarburant() {
      if (this.dpoCarburant == 1) {
         this.carburant = true;
      } else {
         this.carburant = false;
      }

      return this.carburant;
   }

   public void setCarburant(boolean var1) {
      this.carburant = var1;
   }

   public boolean isCession() {
      if (this.dpoCession == 1) {
         this.cession = true;
      } else {
         this.cession = false;
      }

      return this.cession;
   }

   public void setCession(boolean var1) {
      this.cession = var1;
   }

   public boolean isFabrication() {
      if (this.dpoFabrication == 1) {
         this.fabrication = true;
      } else {
         this.fabrication = false;
      }

      return this.fabrication;
   }

   public void setFabrication(boolean var1) {
      this.fabrication = var1;
   }

   public boolean isInventaire() {
      if (this.dpoInventaire == 1) {
         this.inventaire = true;
      } else {
         this.inventaire = false;
      }

      return this.inventaire;
   }

   public void setInventaire(boolean var1) {
      this.inventaire = var1;
   }

   public boolean isLivraison() {
      if (this.dpoLivraison == 1) {
         this.livraison = true;
      } else {
         this.livraison = false;
      }

      return this.livraison;
   }

   public void setLivraison(boolean var1) {
      this.livraison = var1;
   }

   public boolean isMobileVent() {
      if (this.dpoMobileVent == 1) {
         this.mobileVent = true;
      } else {
         this.mobileVent = false;
      }

      return this.mobileVent;
   }

   public void setMobileVent(boolean var1) {
      this.mobileVent = var1;
   }

   public boolean isReachmin() {
      if (this.dpoReachmin == 1) {
         this.reachmin = true;
      } else {
         this.reachmin = false;
      }

      return this.reachmin;
   }

   public void setReachmin(boolean var1) {
      this.reachmin = var1;
   }

   public boolean isReception() {
      if (this.dpoReception == 1) {
         this.reception = true;
      } else {
         this.reception = false;
      }

      return this.reception;
   }

   public void setReception(boolean var1) {
      this.reception = var1;
   }

   public boolean isRetourAch() {
      if (this.dpoRetourAch == 1) {
         this.retourAch = true;
      } else {
         this.retourAch = false;
      }

      return this.retourAch;
   }

   public void setRetourAch(boolean var1) {
      this.retourAch = var1;
   }

   public boolean isRetourVent() {
      if (this.dpoRetourVent == 1) {
         this.retourVent = true;
      } else {
         this.retourVent = false;
      }

      return this.retourVent;
   }

   public void setRetourVent(boolean var1) {
      this.retourVent = var1;
   }

   public boolean isSelectDepot() {
      return this.selectDepot;
   }

   public void setSelectDepot(boolean var1) {
      this.selectDepot = var1;
   }

   public String getDpoCode() {
      return this.dpoCode;
   }

   public void setDpoCode(String var1) {
      this.dpoCode = var1;
   }

   public Date getDpoDateCreation() {
      return this.dpoDateCreation;
   }

   public void setDpoDateCreation(Date var1) {
      this.dpoDateCreation = var1;
   }

   public Date getDpoDateModif() {
      return this.dpoDateModif;
   }

   public void setDpoDateModif(Date var1) {
      this.dpoDateModif = var1;
   }

   public long getDpoId() {
      return this.dpoId;
   }

   public void setDpoId(long var1) {
      this.dpoId = var1;
   }

   public int getDpoInactif() {
      return this.dpoInactif;
   }

   public void setDpoInactif(int var1) {
      this.dpoInactif = var1;
   }

   public String getDpoLibelle() {
      return this.dpoLibelle;
   }

   public void setDpoLibelle(String var1) {
      this.dpoLibelle = var1;
   }

   public float getDpoQteMax() {
      return this.dpoQteMax;
   }

   public void setDpoQteMax(float var1) {
      this.dpoQteMax = var1;
   }

   public float getDpoQteMin() {
      return this.dpoQteMin;
   }

   public void setDpoQteMin(float var1) {
      this.dpoQteMin = var1;
   }

   public int getDpoType() {
      return this.dpoType;
   }

   public void setDpoType(int var1) {
      this.dpoType = var1;
   }

   public long getDpoUserCreation() {
      return this.dpoUserCreation;
   }

   public void setDpoUserCreation(long var1) {
      this.dpoUserCreation = var1;
   }

   public long getDpoUserModif() {
      return this.dpoUserModif;
   }

   public void setDpoUserModif(long var1) {
      this.dpoUserModif = var1;
   }

   public String getEtat() {
      if (this.dpoInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.dpoInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      if (this.dpoInactif != 1 && this.dpoInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public String getTypLib() {
      if (this.dpoType == 0) {
         this.typLib = "Standard";
      } else if (this.dpoType == 1) {
         this.typLib = "Mobile";
      } else if (this.dpoType == 2) {
         this.typLib = "Fictif";
      } else if (this.dpoType == 3) {
         this.typLib = "Déchet";
      }

      return this.typLib;
   }

   public void setTypLib(String var1) {
      this.typLib = var1;
   }

   public int getDpoBonEntree() {
      return this.dpoBonEntree;
   }

   public void setDpoBonEntree(int var1) {
      this.dpoBonEntree = var1;
   }

   public int getDpoBonSortie() {
      return this.dpoBonSortie;
   }

   public void setDpoBonSortie(int var1) {
      this.dpoBonSortie = var1;
   }

   public int getDpoCession() {
      return this.dpoCession;
   }

   public void setDpoCession(int var1) {
      this.dpoCession = var1;
   }

   public int getDpoCollecteAch() {
      return this.dpoCollecteAch;
   }

   public void setDpoCollecteAch(int var1) {
      this.dpoCollecteAch = var1;
   }

   public int getDpoDefautIn() {
      return this.dpoDefautIn;
   }

   public void setDpoDefautIn(int var1) {
      this.dpoDefautIn = var1;
   }

   public int getDpoDefautOut() {
      return this.dpoDefautOut;
   }

   public void setDpoDefautOut(int var1) {
      this.dpoDefautOut = var1;
   }

   public int getDpoFabrication() {
      return this.dpoFabrication;
   }

   public void setDpoFabrication(int var1) {
      this.dpoFabrication = var1;
   }

   public int getDpoInventaire() {
      return this.dpoInventaire;
   }

   public void setDpoInventaire(int var1) {
      this.dpoInventaire = var1;
   }

   public int getDpoLivraison() {
      return this.dpoLivraison;
   }

   public void setDpoLivraison(int var1) {
      this.dpoLivraison = var1;
   }

   public int getDpoMobileVent() {
      return this.dpoMobileVent;
   }

   public void setDpoMobileVent(int var1) {
      this.dpoMobileVent = var1;
   }

   public int getDpoReachmin() {
      return this.dpoReachmin;
   }

   public void setDpoReachmin(int var1) {
      this.dpoReachmin = var1;
   }

   public int getDpoReception() {
      return this.dpoReception;
   }

   public void setDpoReception(int var1) {
      this.dpoReception = var1;
   }

   public int getDpoRetourAch() {
      return this.dpoRetourAch;
   }

   public void setDpoRetourAch(int var1) {
      this.dpoRetourAch = var1;
   }

   public int getDpoRetourVent() {
      return this.dpoRetourVent;
   }

   public void setDpoRetourVent(int var1) {
      this.dpoRetourVent = var1;
   }

   public int getDpoPharmacie() {
      return this.dpoPharmacie;
   }

   public void setDpoPharmacie(int var1) {
      this.dpoPharmacie = var1;
   }

   public int getDpoCarburant() {
      return this.dpoCarburant;
   }

   public void setDpoCarburant(int var1) {
      this.dpoCarburant = var1;
   }

   public String getDpoService() {
      return this.dpoService;
   }

   public void setDpoService(String var1) {
      this.dpoService = var1;
   }

   public String getDpoAdresse() {
      return this.dpoAdresse;
   }

   public void setDpoAdresse(String var1) {
      this.dpoAdresse = var1;
   }

   public String getDpoResponsable() {
      return this.dpoResponsable;
   }

   public void setDpoResponsable(String var1) {
      this.dpoResponsable = var1;
   }

   public String getDpoDepartement() {
      return this.dpoDepartement;
   }

   public void setDpoDepartement(String var1) {
      this.dpoDepartement = var1;
   }

   public String getDpoSite() {
      return this.dpoSite;
   }

   public void setDpoSite(String var1) {
      this.dpoSite = var1;
   }
}
