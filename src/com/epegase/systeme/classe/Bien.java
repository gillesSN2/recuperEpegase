package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Bien implements Serializable {
   private long bieId;
   private Date bieDateCreat;
   private Date bieDateModif;
   private long bieUserCreat;
   private long bieUserModif;
   private String bieNum;
   private String bieModele;
   private int bieCategorie;
   private int bieType;
   private int bieMode;
   private String bieNom;
   private String bieAdresse;
   private String bieRue;
   private String bieLot;
   private String bieIlot;
   private String bieBatiment;
   private String biePorte;
   private String bieEtage;
   private String bieEscalier;
   private String bieAscenseur;
   private String bieQuartier;
   private String bieCommune;
   private String bieDepart;
   private String bieZone;
   private String bieVille;
   private String bieNomPays;
   private String bieCodePays;
   private String bieDescriptif;
   private int bieGestion;
   private long bieIdGroupe;
   private String bieGroupe;
   private String bieNomGroupe;
   private boolean bieCopropriete;
   private int bieMillieme;
   private float bieSurperficie;
   private int bieNbPiece;
   private int bieNbChambre;
   private int bieNbSalon;
   private int bieNbCuisine;
   private int bieNbWc;
   private int bieNbSalleBain;
   private int bieNbSalleEau;
   private int bieNbGarage;
   private String bieNumGarage;
   private int bieNbCave;
   private String bieNumCave;
   private int bieNbParking;
   private int bieNbVitrine;
   private int bieNbEtage;
   private int bieNbBatiment;
   private int bieNbAppartement;
   private int bieNbBureau;
   private int bieNbAscenseur;
   private int bieJardin;
   private int biePiscine;
   private int bieParking;
   private int bieGroupElectrogene;
   private int bieGardien;
   private int bieViabilise;
   private int bieCloture;
   private String bieParcelle;
   private String bieTitreFoncier;
   private Date bieDateAchat;
   private double bieBaseLoyer;
   private double bieCharges;
   private String bieTiers;
   private String bieNomTiers;
   private String bieCivilTiers;
   private String bieCompteCharge;
   private String bieLibelleCharge;
   private String bieCompteGestion;
   private String bieLibelleGestion;
   private int bieNbLocaux;
   private String bieListeLocaux;
   private String bieCodeBloc;
   private int biePublication;
   private int bieOccupe;
   private String bieTmpBail;
   private int bieTmpUsage;
   private int bieTmpFacturation;
   private String bieTmpLocataire;
   private double bieTmpLoyer;
   private double bieTmpValeurPv;
   private int bieEtat;
   private Tiers tiers;
   private String libelleEtat;
   private String libelleType;
   private String libelleMode;
   private String libelleModeGestion;
   private double pu;
   private double ptHt;
   private double ptTaxe;
   private double ptTtc;
   private String numlot;
   private double puReliquat;
   private double ptHtReliquat;
   private double ptTaxeReliquat;
   private double ptTtcReliquat;

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public String getNumlot() {
      return this.numlot;
   }

   public void setNumlot(String var1) {
      this.numlot = var1;
   }

   public double getPtHt() {
      return this.ptHt;
   }

   public void setPtHt(double var1) {
      this.ptHt = var1;
   }

   public double getPu() {
      return this.pu;
   }

   public void setPu(double var1) {
      this.pu = var1;
   }

   public double getPtTaxe() {
      return this.ptTaxe;
   }

   public void setPtTaxe(double var1) {
      this.ptTaxe = var1;
   }

   public double getPtTtc() {
      return this.ptTtc;
   }

   public void setPtTtc(double var1) {
      this.ptTtc = var1;
   }

   public String getLibelleEtat() {
      if (this.bieEtat == 0) {
         this.libelleEtat = "En construction";
      } else if (this.bieEtat == 1) {
         this.libelleEtat = "Libre";
      } else if (this.bieEtat == 2) {
         this.libelleEtat = "Vendu";
      } else if (this.bieEtat == 3) {
         this.libelleEtat = "Litige";
      } else if (this.bieEtat == 4) {
         this.libelleEtat = "Détruit";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public String getLibelleMode() {
      if (this.bieMode == 0) {
         this.libelleMode = "Standard";
      } else if (this.bieMode == 1) {
         this.libelleMode = "Moyen";
      } else if (this.bieMode == 2) {
         this.libelleMode = "Grand Standing";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public String getLibelleModeGestion() {
      if (this.bieCategorie == 0) {
         this.libelleModeGestion = "Location";
      } else if (this.bieCategorie == 1) {
         this.libelleModeGestion = "SYndic";
      } else if (this.bieCategorie == 2) {
         this.libelleModeGestion = "Negoce";
      } else if (this.bieCategorie == 3) {
         this.libelleModeGestion = "Location/Syndic";
      } else if (this.bieCategorie == 4) {
         this.libelleModeGestion = "Location/Syndic/Negoce";
      }

      return this.libelleModeGestion;
   }

   public void setLibelleModeGestion(String var1) {
      this.libelleModeGestion = var1;
   }

   public String getLibelleType() {
      if (this.bieType == 0) {
         this.libelleType = "Villa";
      } else if (this.bieType == 1) {
         this.libelleType = "Appartement";
      } else if (this.bieType == 2) {
         this.libelleType = "Immeuble";
      } else if (this.bieType == 3) {
         this.libelleType = "Bureau";
      } else if (this.bieType == 4) {
         this.libelleType = "Commerce";
      } else if (this.bieType == 5) {
         this.libelleType = "Garage";
      } else if (this.bieType == 6) {
         this.libelleType = "Hangar";
      } else if (this.bieType == 7) {
         this.libelleType = "Usine";
      } else if (this.bieType == 8) {
         this.libelleType = "Box";
      } else if (this.bieType == 9) {
         this.libelleType = "Parc";
      } else if (this.bieType == 10) {
         this.libelleType = "Chambre";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public String getBieAdresse() {
      return this.bieAdresse;
   }

   public void setBieAdresse(String var1) {
      this.bieAdresse = var1;
   }

   public double getBieBaseLoyer() {
      return this.bieBaseLoyer;
   }

   public void setBieBaseLoyer(double var1) {
      this.bieBaseLoyer = var1;
   }

   public double getBieCharges() {
      return this.bieCharges;
   }

   public void setBieCharges(double var1) {
      this.bieCharges = var1;
   }

   public boolean isBieCopropriete() {
      return this.bieCopropriete;
   }

   public void setBieCopropriete(boolean var1) {
      this.bieCopropriete = var1;
   }

   public Date getBieDateCreat() {
      return this.bieDateCreat;
   }

   public void setBieDateCreat(Date var1) {
      this.bieDateCreat = var1;
   }

   public String getBieDescriptif() {
      return this.bieDescriptif;
   }

   public void setBieDescriptif(String var1) {
      this.bieDescriptif = var1;
   }

   public String getBieEtage() {
      return this.bieEtage;
   }

   public void setBieEtage(String var1) {
      this.bieEtage = var1;
   }

   public int getBieGestion() {
      return this.bieGestion;
   }

   public void setBieGestion(int var1) {
      this.bieGestion = var1;
   }

   public int getBieJardin() {
      return this.bieJardin;
   }

   public void setBieJardin(int var1) {
      this.bieJardin = var1;
   }

   public int getBieMillieme() {
      return this.bieMillieme;
   }

   public void setBieMillieme(int var1) {
      this.bieMillieme = var1;
   }

   public int getBieMode() {
      return this.bieMode;
   }

   public void setBieMode(int var1) {
      this.bieMode = var1;
   }

   public int getBieNbChambre() {
      return this.bieNbChambre;
   }

   public void setBieNbChambre(int var1) {
      this.bieNbChambre = var1;
   }

   public int getBieNbCuisine() {
      return this.bieNbCuisine;
   }

   public void setBieNbCuisine(int var1) {
      this.bieNbCuisine = var1;
   }

   public int getBieNbGarage() {
      return this.bieNbGarage;
   }

   public void setBieNbGarage(int var1) {
      this.bieNbGarage = var1;
   }

   public int getBieNbPiece() {
      return this.bieNbPiece;
   }

   public void setBieNbPiece(int var1) {
      this.bieNbPiece = var1;
   }

   public int getBieNbSalleBain() {
      return this.bieNbSalleBain;
   }

   public void setBieNbSalleBain(int var1) {
      this.bieNbSalleBain = var1;
   }

   public int getBieNbSalleEau() {
      return this.bieNbSalleEau;
   }

   public void setBieNbSalleEau(int var1) {
      this.bieNbSalleEau = var1;
   }

   public int getBieNbSalon() {
      return this.bieNbSalon;
   }

   public void setBieNbSalon(int var1) {
      this.bieNbSalon = var1;
   }

   public int getBieNbVitrine() {
      return this.bieNbVitrine;
   }

   public void setBieNbVitrine(int var1) {
      this.bieNbVitrine = var1;
   }

   public String getBieNom() {
      return this.bieNom;
   }

   public void setBieNom(String var1) {
      this.bieNom = var1;
   }

   public String getBieNum() {
      return this.bieNum;
   }

   public void setBieNum(String var1) {
      this.bieNum = var1;
   }

   public float getBieSurperficie() {
      return this.bieSurperficie;
   }

   public void setBieSurperficie(float var1) {
      this.bieSurperficie = var1;
   }

   public int getBieType() {
      return this.bieType;
   }

   public void setBieType(int var1) {
      this.bieType = var1;
   }

   public long getBieUserCreat() {
      return this.bieUserCreat;
   }

   public void setBieUserCreat(long var1) {
      this.bieUserCreat = var1;
   }

   public long getBieUserModif() {
      return this.bieUserModif;
   }

   public void setBieUserModif(long var1) {
      this.bieUserModif = var1;
   }

   public String getBieVille() {
      return this.bieVille;
   }

   public void setBieVille(String var1) {
      this.bieVille = var1;
   }

   public String getBieZone() {
      return this.bieZone;
   }

   public void setBieZone(String var1) {
      this.bieZone = var1;
   }

   public long getBieId() {
      return this.bieId;
   }

   public void setBieId(long var1) {
      this.bieId = var1;
   }

   public Date getBieDateModif() {
      return this.bieDateModif;
   }

   public void setBieDateModif(Date var1) {
      this.bieDateModif = var1;
   }

   public Date getBieDateAchat() {
      return this.bieDateAchat;
   }

   public void setBieDateAchat(Date var1) {
      this.bieDateAchat = var1;
   }

   public String getBieParcelle() {
      return this.bieParcelle;
   }

   public void setBieParcelle(String var1) {
      this.bieParcelle = var1;
   }

   public String getBieTitreFoncier() {
      return this.bieTitreFoncier;
   }

   public void setBieTitreFoncier(String var1) {
      this.bieTitreFoncier = var1;
   }

   public String getBieGroupe() {
      return this.bieGroupe;
   }

   public void setBieGroupe(String var1) {
      this.bieGroupe = var1;
   }

   public String getBieAscenseur() {
      return this.bieAscenseur;
   }

   public void setBieAscenseur(String var1) {
      this.bieAscenseur = var1;
   }

   public String getBieBatiment() {
      return this.bieBatiment;
   }

   public void setBieBatiment(String var1) {
      this.bieBatiment = var1;
   }

   public String getBieCommune() {
      return this.bieCommune;
   }

   public void setBieCommune(String var1) {
      this.bieCommune = var1;
   }

   public String getBieDepart() {
      return this.bieDepart;
   }

   public void setBieDepart(String var1) {
      this.bieDepart = var1;
   }

   public String getBieLot() {
      return this.bieLot;
   }

   public void setBieLot(String var1) {
      this.bieLot = var1;
   }

   public String getBiePorte() {
      return this.biePorte;
   }

   public void setBiePorte(String var1) {
      this.biePorte = var1;
   }

   public String getBieQuartier() {
      return this.bieQuartier;
   }

   public void setBieQuartier(String var1) {
      this.bieQuartier = var1;
   }

   public String getBieRue() {
      return this.bieRue;
   }

   public void setBieRue(String var1) {
      this.bieRue = var1;
   }

   public String getBieCodePays() {
      return this.bieCodePays;
   }

   public void setBieCodePays(String var1) {
      this.bieCodePays = var1;
   }

   public String getBieEscalier() {
      return this.bieEscalier;
   }

   public void setBieEscalier(String var1) {
      this.bieEscalier = var1;
   }

   public String getBieIlot() {
      return this.bieIlot;
   }

   public void setBieIlot(String var1) {
      this.bieIlot = var1;
   }

   public String getBieNomPays() {
      return this.bieNomPays;
   }

   public void setBieNomPays(String var1) {
      this.bieNomPays = var1;
   }

   public String getBieNomGroupe() {
      return this.bieNomGroupe;
   }

   public void setBieNomGroupe(String var1) {
      this.bieNomGroupe = var1;
   }

   public int getBieNbWc() {
      return this.bieNbWc;
   }

   public void setBieNbWc(int var1) {
      this.bieNbWc = var1;
   }

   public int getBiePiscine() {
      return this.biePiscine;
   }

   public void setBiePiscine(int var1) {
      this.biePiscine = var1;
   }

   public String getBieNomTiers() {
      return this.bieNomTiers;
   }

   public void setBieNomTiers(String var1) {
      this.bieNomTiers = var1;
   }

   public String getBieCivilTiers() {
      return this.bieCivilTiers;
   }

   public void setBieCivilTiers(String var1) {
      this.bieCivilTiers = var1;
   }

   public int getBieGardien() {
      return this.bieGardien;
   }

   public void setBieGardien(int var1) {
      this.bieGardien = var1;
   }

   public int getBieGroupElectrogene() {
      return this.bieGroupElectrogene;
   }

   public void setBieGroupElectrogene(int var1) {
      this.bieGroupElectrogene = var1;
   }

   public int getBieParking() {
      return this.bieParking;
   }

   public void setBieParking(int var1) {
      this.bieParking = var1;
   }

   public int getBieCategorie() {
      return this.bieCategorie;
   }

   public void setBieCategorie(int var1) {
      this.bieCategorie = var1;
   }

   public int getBieNbAppartement() {
      return this.bieNbAppartement;
   }

   public void setBieNbAppartement(int var1) {
      this.bieNbAppartement = var1;
   }

   public int getBieNbAscenseur() {
      return this.bieNbAscenseur;
   }

   public void setBieNbAscenseur(int var1) {
      this.bieNbAscenseur = var1;
   }

   public int getBieNbBatiment() {
      return this.bieNbBatiment;
   }

   public void setBieNbBatiment(int var1) {
      this.bieNbBatiment = var1;
   }

   public int getBieNbEtage() {
      return this.bieNbEtage;
   }

   public void setBieNbEtage(int var1) {
      this.bieNbEtage = var1;
   }

   public String getBieModele() {
      return this.bieModele;
   }

   public void setBieModele(String var1) {
      this.bieModele = var1;
   }

   public long getBieIdGroupe() {
      return this.bieIdGroupe;
   }

   public void setBieIdGroupe(long var1) {
      this.bieIdGroupe = var1;
   }

   public int getBieCloture() {
      return this.bieCloture;
   }

   public void setBieCloture(int var1) {
      this.bieCloture = var1;
   }

   public int getBieViabilise() {
      return this.bieViabilise;
   }

   public void setBieViabilise(int var1) {
      this.bieViabilise = var1;
   }

   public String getBieCompteCharge() {
      return this.bieCompteCharge;
   }

   public void setBieCompteCharge(String var1) {
      this.bieCompteCharge = var1;
   }

   public String getBieCompteGestion() {
      return this.bieCompteGestion;
   }

   public void setBieCompteGestion(String var1) {
      this.bieCompteGestion = var1;
   }

   public String getBieLibelleCharge() {
      return this.bieLibelleCharge;
   }

   public void setBieLibelleCharge(String var1) {
      this.bieLibelleCharge = var1;
   }

   public String getBieLibelleGestion() {
      return this.bieLibelleGestion;
   }

   public void setBieLibelleGestion(String var1) {
      this.bieLibelleGestion = var1;
   }

   public int getBieNbLocaux() {
      return this.bieNbLocaux;
   }

   public void setBieNbLocaux(int var1) {
      this.bieNbLocaux = var1;
   }

   public int getBiePublication() {
      return this.biePublication;
   }

   public void setBiePublication(int var1) {
      this.biePublication = var1;
   }

   public int getBieOccupe() {
      return this.bieOccupe;
   }

   public void setBieOccupe(int var1) {
      this.bieOccupe = var1;
   }

   public String getBieTiers() {
      return this.bieTiers;
   }

   public void setBieTiers(String var1) {
      this.bieTiers = var1;
   }

   public int getBieNbParking() {
      return this.bieNbParking;
   }

   public void setBieNbParking(int var1) {
      this.bieNbParking = var1;
   }

   public String getBieListeLocaux() {
      return this.bieListeLocaux;
   }

   public void setBieListeLocaux(String var1) {
      this.bieListeLocaux = var1;
   }

   public String getBieCodeBloc() {
      return this.bieCodeBloc;
   }

   public void setBieCodeBloc(String var1) {
      this.bieCodeBloc = var1;
   }

   public int getBieNbCave() {
      return this.bieNbCave;
   }

   public void setBieNbCave(int var1) {
      this.bieNbCave = var1;
   }

   public String getBieNumCave() {
      return this.bieNumCave;
   }

   public void setBieNumCave(String var1) {
      this.bieNumCave = var1;
   }

   public String getBieNumGarage() {
      return this.bieNumGarage;
   }

   public void setBieNumGarage(String var1) {
      this.bieNumGarage = var1;
   }

   public int getBieNbBureau() {
      return this.bieNbBureau;
   }

   public void setBieNbBureau(int var1) {
      this.bieNbBureau = var1;
   }

   public String getBieTmpBail() {
      return this.bieTmpBail;
   }

   public void setBieTmpBail(String var1) {
      this.bieTmpBail = var1;
   }

   public int getBieTmpFacturation() {
      return this.bieTmpFacturation;
   }

   public void setBieTmpFacturation(int var1) {
      this.bieTmpFacturation = var1;
   }

   public String getBieTmpLocataire() {
      return this.bieTmpLocataire;
   }

   public void setBieTmpLocataire(String var1) {
      this.bieTmpLocataire = var1;
   }

   public int getBieTmpUsage() {
      return this.bieTmpUsage;
   }

   public void setBieTmpUsage(int var1) {
      this.bieTmpUsage = var1;
   }

   public double getBieTmpLoyer() {
      return this.bieTmpLoyer;
   }

   public void setBieTmpLoyer(double var1) {
      this.bieTmpLoyer = var1;
   }

   public double getPtHtReliquat() {
      return this.ptHtReliquat;
   }

   public void setPtHtReliquat(double var1) {
      this.ptHtReliquat = var1;
   }

   public double getPtTaxeReliquat() {
      return this.ptTaxeReliquat;
   }

   public void setPtTaxeReliquat(double var1) {
      this.ptTaxeReliquat = var1;
   }

   public double getPtTtcReliquat() {
      return this.ptTtcReliquat;
   }

   public void setPtTtcReliquat(double var1) {
      this.ptTtcReliquat = var1;
   }

   public double getPuReliquat() {
      return this.puReliquat;
   }

   public void setPuReliquat(double var1) {
      this.puReliquat = var1;
   }

   public int getBieEtat() {
      return this.bieEtat;
   }

   public void setBieEtat(int var1) {
      this.bieEtat = var1;
   }

   public double getBieTmpValeurPv() {
      return this.bieTmpValeurPv;
   }

   public void setBieTmpValeurPv(double var1) {
      this.bieTmpValeurPv = var1;
   }
}
