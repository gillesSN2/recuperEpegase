package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Parc implements Serializable {
   private long prcId;
   private Date prcDateCreat;
   private Date prcDateModif;
   private long prcUserCreat;
   private long prcUserModif;
   private String prcNomFr;
   private String prcNomUk;
   private String prcNomSp;
   private int prcInactif;
   private long prcImmobilisation;
   private long prcIdImmobilisation;
   private String prcPhoto;
   private int prcPhotoTaille;
   private int prcNature;
   private String prcLibNature;
   private String prcFamille;
   private String prcLibFamille;
   private String prcSousFamille;
   private String prcLibSousFamille;
   private String prcMarque;
   private String prcImmatriculation;
   private String prcBalise;
   private String prcChassis;
   private String prcMoteur;
   private String prcArrangement;
   private Date prcDateAchat;
   private String prcAnniversaire;
   private int prcAnneeFab;
   private double prcPrixAchat;
   private double prcPrixRevient;
   private double prcPrixVente;
   private Date prcDateMeS;
   private double prcPrixArgus;
   private Date prcDateSortie;
   private double prcPrixCession;
   private int prcEtat;
   private int prcFonction;
   private String prcLieu;
   private String prcPanne;
   private int prcOrigine;
   private float prcPuisFiscale;
   private float prcPuisChev;
   private float prcConsommation;
   private float prcCote;
   private int prcCompteur;
   private int prcAlimentation;
   private float prcAmpere;
   private float prcVolt;
   private int prcEssence;
   private String prcMatSalarie;
   private String prcNomSalarie;
   private String prcPrenomSalarie;
   private String prcService;
   private String prcLibService;
   private int prcAlerte;
   private String prcMailAlerte;
   private long prcIdTiers;
   private String prcNomTiers;
   private String prcAdresse;
   private String prcTel;
   private String prcVille;
   private String prcContact;
   private String prcModele;
   private String prcNumSerie;
   private String prcProcesseur;
   private String prcOs;
   private String prcMemoire;
   private String prcDd;
   private String prcTypeImprimante;
   private String prcCartouche;
   private String libAlimentation;
   private String libEssence;
   private String libOrigine;
   private String libEtat;
   private String libFonction;
   private String libCompteur;
   private boolean afficheImag;
   private String etat;
   private boolean select_parc = false;
   private String libelleParc;

   public String getLibelleParc() {
      this.libelleParc = "";
      if (this.prcLibFamille != null && !this.prcLibFamille.isEmpty()) {
         this.libelleParc = this.libelleParc + this.prcLibFamille + " ";
      }

      if (this.prcLibSousFamille != null && !this.prcLibSousFamille.isEmpty()) {
         this.libelleParc = this.libelleParc + this.prcLibSousFamille + " ";
      }

      if (this.prcMarque != null && !this.prcMarque.isEmpty()) {
         this.libelleParc = this.libelleParc + "(" + this.prcMarque + ") ";
      }

      return this.libelleParc;
   }

   public void setLibelleParc(String var1) {
      this.libelleParc = var1;
   }

   public int getPrcInactif() {
      return this.prcInactif;
   }

   public void setPrcInactif(int var1) {
      this.prcInactif = var1;
   }

   public String getEtat() {
      if (this.prcInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.prcInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.prcInactif != 1 && this.prcInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public Date getPrcDateCreat() {
      return this.prcDateCreat;
   }

   public void setPrcDateCreat(Date var1) {
      this.prcDateCreat = var1;
   }

   public Date getPrcDateModif() {
      return this.prcDateModif;
   }

   public void setPrcDateModif(Date var1) {
      this.prcDateModif = var1;
   }

   public long getPrcId() {
      return this.prcId;
   }

   public void setPrcId(long var1) {
      this.prcId = var1;
   }

   public String getPrcNomFr() {
      return this.prcNomFr;
   }

   public void setPrcNomFr(String var1) {
      this.prcNomFr = var1;
   }

   public String getPrcNomSp() {
      return this.prcNomSp;
   }

   public void setPrcNomSp(String var1) {
      this.prcNomSp = var1;
   }

   public String getPrcNomUk() {
      return this.prcNomUk;
   }

   public void setPrcNomUk(String var1) {
      this.prcNomUk = var1;
   }

   public long getPrcUserCreat() {
      return this.prcUserCreat;
   }

   public void setPrcUserCreat(long var1) {
      this.prcUserCreat = var1;
   }

   public long getPrcUserModif() {
      return this.prcUserModif;
   }

   public void setPrcUserModif(long var1) {
      this.prcUserModif = var1;
   }

   public int getPrcAlerte() {
      return this.prcAlerte;
   }

   public void setPrcAlerte(int var1) {
      this.prcAlerte = var1;
   }

   public int getPrcAlimentation() {
      return this.prcAlimentation;
   }

   public void setPrcAlimentation(int var1) {
      this.prcAlimentation = var1;
   }

   public float getPrcAmpere() {
      return this.prcAmpere;
   }

   public void setPrcAmpere(float var1) {
      this.prcAmpere = var1;
   }

   public String getPrcArrangement() {
      return this.prcArrangement;
   }

   public void setPrcArrangement(String var1) {
      this.prcArrangement = var1;
   }

   public String getPrcChassis() {
      return this.prcChassis;
   }

   public void setPrcChassis(String var1) {
      this.prcChassis = var1;
   }

   public int getPrcCompteur() {
      return this.prcCompteur;
   }

   public void setPrcCompteur(int var1) {
      this.prcCompteur = var1;
   }

   public float getPrcConsommation() {
      return this.prcConsommation;
   }

   public void setPrcConsommation(float var1) {
      this.prcConsommation = var1;
   }

   public float getPrcCote() {
      return this.prcCote;
   }

   public void setPrcCote(float var1) {
      this.prcCote = var1;
   }

   public Date getPrcDateAchat() {
      return this.prcDateAchat;
   }

   public void setPrcDateAchat(Date var1) {
      this.prcDateAchat = var1;
   }

   public Date getPrcDateMeS() {
      return this.prcDateMeS;
   }

   public void setPrcDateMeS(Date var1) {
      this.prcDateMeS = var1;
   }

   public Date getPrcDateSortie() {
      return this.prcDateSortie;
   }

   public void setPrcDateSortie(Date var1) {
      this.prcDateSortie = var1;
   }

   public int getPrcEssence() {
      return this.prcEssence;
   }

   public void setPrcEssence(int var1) {
      this.prcEssence = var1;
   }

   public int getPrcEtat() {
      return this.prcEtat;
   }

   public void setPrcEtat(int var1) {
      this.prcEtat = var1;
   }

   public String getPrcFamille() {
      return this.prcFamille;
   }

   public void setPrcFamille(String var1) {
      this.prcFamille = var1;
   }

   public int getPrcFonction() {
      return this.prcFonction;
   }

   public void setPrcFonction(int var1) {
      this.prcFonction = var1;
   }

   public String getPrcImmatriculation() {
      return this.prcImmatriculation;
   }

   public void setPrcImmatriculation(String var1) {
      this.prcImmatriculation = var1;
   }

   public long getPrcImmobilisation() {
      return this.prcImmobilisation;
   }

   public void setPrcImmobilisation(long var1) {
      this.prcImmobilisation = var1;
   }

   public String getPrcLibFamille() {
      return this.prcLibFamille;
   }

   public void setPrcLibFamille(String var1) {
      this.prcLibFamille = var1;
   }

   public String getPrcLibSousFamille() {
      return this.prcLibSousFamille;
   }

   public void setPrcLibSousFamille(String var1) {
      this.prcLibSousFamille = var1;
   }

   public String getPrcLieu() {
      return this.prcLieu;
   }

   public void setPrcLieu(String var1) {
      this.prcLieu = var1;
   }

   public String getPrcMailAlerte() {
      return this.prcMailAlerte;
   }

   public void setPrcMailAlerte(String var1) {
      this.prcMailAlerte = var1;
   }

   public String getPrcMarque() {
      if (this.prcMarque != null && !this.prcMarque.isEmpty()) {
         this.prcMarque = this.prcMarque.toUpperCase();
      }

      return this.prcMarque;
   }

   public void setPrcMarque(String var1) {
      this.prcMarque = var1;
   }

   public String getPrcMoteur() {
      return this.prcMoteur;
   }

   public void setPrcMoteur(String var1) {
      this.prcMoteur = var1;
   }

   public int getPrcNature() {
      return this.prcNature;
   }

   public void setPrcNature(int var1) {
      this.prcNature = var1;
   }

   public int getPrcOrigine() {
      return this.prcOrigine;
   }

   public void setPrcOrigine(int var1) {
      this.prcOrigine = var1;
   }

   public String getPrcPanne() {
      return this.prcPanne;
   }

   public void setPrcPanne(String var1) {
      this.prcPanne = var1;
   }

   public String getPrcPhoto() {
      return this.prcPhoto;
   }

   public void setPrcPhoto(String var1) {
      this.prcPhoto = var1;
   }

   public double getPrcPrixAchat() {
      return this.prcPrixAchat;
   }

   public void setPrcPrixAchat(double var1) {
      this.prcPrixAchat = var1;
   }

   public double getPrcPrixArgus() {
      return this.prcPrixArgus;
   }

   public void setPrcPrixArgus(double var1) {
      this.prcPrixArgus = var1;
   }

   public double getPrcPrixCession() {
      return this.prcPrixCession;
   }

   public void setPrcPrixCession(double var1) {
      this.prcPrixCession = var1;
   }

   public double getPrcPrixRevient() {
      return this.prcPrixRevient;
   }

   public void setPrcPrixRevient(double var1) {
      this.prcPrixRevient = var1;
   }

   public float getPrcPuisChev() {
      return this.prcPuisChev;
   }

   public void setPrcPuisChev(float var1) {
      this.prcPuisChev = var1;
   }

   public float getPrcPuisFiscale() {
      return this.prcPuisFiscale;
   }

   public void setPrcPuisFiscale(float var1) {
      this.prcPuisFiscale = var1;
   }

   public String getPrcSousFamille() {
      return this.prcSousFamille;
   }

   public void setPrcSousFamille(String var1) {
      this.prcSousFamille = var1;
   }

   public float getPrcVolt() {
      return this.prcVolt;
   }

   public void setPrcVolt(float var1) {
      this.prcVolt = var1;
   }

   public int getPrcAnneeFab() {
      return this.prcAnneeFab;
   }

   public void setPrcAnneeFab(int var1) {
      this.prcAnneeFab = var1;
   }

   public double getPrcPrixVente() {
      return this.prcPrixVente;
   }

   public void setPrcPrixVente(double var1) {
      this.prcPrixVente = var1;
   }

   public String getPrcService() {
      return this.prcService;
   }

   public void setPrcService(String var1) {
      this.prcService = var1;
   }

   public long getPrcIdTiers() {
      return this.prcIdTiers;
   }

   public void setPrcIdTiers(long var1) {
      this.prcIdTiers = var1;
   }

   public String getPrcNomTiers() {
      return this.prcNomTiers;
   }

   public void setPrcNomTiers(String var1) {
      this.prcNomTiers = var1;
   }

   public String getLibAlimentation() {
      if (this.getPrcAlimentation() == 0) {
         this.libAlimentation = "Sans";
      } else if (this.getPrcAlimentation() == 1) {
         this.libAlimentation = "Essence";
      } else if (this.getPrcAlimentation() == 2) {
         this.libAlimentation = "Gazoil";
      } else if (this.getPrcAlimentation() == 3) {
         this.libAlimentation = "GPL";
      } else if (this.getPrcAlimentation() == 4) {
         this.libAlimentation = "Kérosène";
      } else if (this.getPrcAlimentation() == 5) {
         this.libAlimentation = "Fuel";
      } else if (this.getPrcAlimentation() == 6) {
         this.libAlimentation = "Jet A1";
      } else if (this.getPrcAlimentation() == 7) {
         this.libAlimentation = "Electrique";
      } else if (this.getPrcAlimentation() == 8) {
         this.libAlimentation = "Hybride";
      } else if (this.getPrcAlimentation() == 9) {
         this.libAlimentation = "Solaire";
      } else if (this.getPrcAlimentation() == 10) {
         this.libAlimentation = "Charbon";
      } else if (this.getPrcAlimentation() == 11) {
         this.libAlimentation = "Nucléaire";
      } else if (this.getPrcAlimentation() == 12) {
         this.libAlimentation = "Autre";
      }

      return this.libAlimentation;
   }

   public void setLibAlimentation(String var1) {
      this.libAlimentation = var1;
   }

   public String getLibEssence() {
      if (this.getPrcEssence() == 0) {
         this.libEssence = "";
      } else if (this.getPrcEssence() == 1) {
         this.libEssence = "Ordinaire";
      } else if (this.getPrcEssence() == 2) {
         this.libEssence = "Super 98";
      } else if (this.getPrcEssence() == 3) {
         this.libEssence = "Super 99";
      }

      return this.libEssence;
   }

   public void setLibEssence(String var1) {
      this.libEssence = var1;
   }

   public String getLibEtat() {
      if (this.getPrcEtat() == 0) {
         this.libEtat = "Actif";
      } else if (this.getPrcEtat() == 1) {
         this.libEtat = "Cession";
      } else if (this.getPrcEtat() == 2) {
         this.libEtat = "Rebut";
      }

      return this.libEtat;
   }

   public void setLibEtat(String var1) {
      this.libEtat = var1;
   }

   public String getLibFonction() {
      if (this.getPrcFonction() == 0) {
         this.libFonction = "Fonction";
      } else if (this.getPrcFonction() == 1) {
         this.libFonction = "Arrêt";
      } else if (this.getPrcFonction() == 2) {
         this.libFonction = "Panne";
      }

      return this.libFonction;
   }

   public void setLibFonction(String var1) {
      this.libFonction = var1;
   }

   public String getLibOrigine() {
      if (this.getPrcOrigine() == 0) {
         this.libOrigine = "Interne";
      } else if (this.getPrcOrigine() == 1) {
         this.libOrigine = "Externe";
      } else if (this.getPrcOrigine() == 2) {
         this.libOrigine = "Fabriqué";
      }

      return this.libOrigine;
   }

   public void setLibOrigine(String var1) {
      this.libOrigine = var1;
   }

   public String getLibCompteur() {
      if (this.getPrcCompteur() == 0) {
         this.libCompteur = "Distance";
      } else if (this.getPrcCompteur() == 1) {
         this.libCompteur = "Kilométrique";
      } else if (this.getPrcCompteur() == 2) {
         this.libCompteur = "Horaire";
      }

      return this.libCompteur;
   }

   public void setLibCompteur(String var1) {
      this.libCompteur = var1;
   }

   public String getPrcLibNature() {
      return this.prcLibNature;
   }

   public void setPrcLibNature(String var1) {
      this.prcLibNature = var1;
   }

   public String getPrcAdresse() {
      return this.prcAdresse;
   }

   public void setPrcAdresse(String var1) {
      this.prcAdresse = var1;
   }

   public String getPrcTel() {
      return this.prcTel;
   }

   public void setPrcTel(String var1) {
      this.prcTel = var1;
   }

   public long getPrcIdImmobilisation() {
      return this.prcIdImmobilisation;
   }

   public void setPrcIdImmobilisation(long var1) {
      this.prcIdImmobilisation = var1;
   }

   public String getPrcLibService() {
      return this.prcLibService;
   }

   public void setPrcLibService(String var1) {
      this.prcLibService = var1;
   }

   public String getPrcMatSalarie() {
      return this.prcMatSalarie;
   }

   public void setPrcMatSalarie(String var1) {
      this.prcMatSalarie = var1;
   }

   public String getPrcNomSalarie() {
      return this.prcNomSalarie;
   }

   public void setPrcNomSalarie(String var1) {
      this.prcNomSalarie = var1;
   }

   public String getPrcPrenomSalarie() {
      return this.prcPrenomSalarie;
   }

   public void setPrcPrenomSalarie(String var1) {
      this.prcPrenomSalarie = var1;
   }

   public String getPrcContact() {
      return this.prcContact;
   }

   public void setPrcContact(String var1) {
      this.prcContact = var1;
   }

   public String getPrcVille() {
      return this.prcVille;
   }

   public void setPrcVille(String var1) {
      this.prcVille = var1;
   }

   public boolean isSelect_parc() {
      return this.select_parc;
   }

   public void setSelect_parc(boolean var1) {
      this.select_parc = var1;
   }

   public String getPrcAnniversaire() {
      return this.prcAnniversaire;
   }

   public void setPrcAnniversaire(String var1) {
      this.prcAnniversaire = var1;
   }

   public int getPrcPhotoTaille() {
      return this.prcPhotoTaille;
   }

   public void setPrcPhotoTaille(int var1) {
      this.prcPhotoTaille = var1;
   }

   public String getPrcBalise() {
      return this.prcBalise;
   }

   public void setPrcBalise(String var1) {
      this.prcBalise = var1;
   }

   public String getPrcDd() {
      return this.prcDd;
   }

   public void setPrcDd(String var1) {
      this.prcDd = var1;
   }

   public String getPrcMemoire() {
      return this.prcMemoire;
   }

   public void setPrcMemoire(String var1) {
      this.prcMemoire = var1;
   }

   public String getPrcModele() {
      return this.prcModele;
   }

   public void setPrcModele(String var1) {
      this.prcModele = var1;
   }

   public String getPrcNumSerie() {
      return this.prcNumSerie;
   }

   public void setPrcNumSerie(String var1) {
      this.prcNumSerie = var1;
   }

   public String getPrcOs() {
      return this.prcOs;
   }

   public void setPrcOs(String var1) {
      this.prcOs = var1;
   }

   public String getPrcProcesseur() {
      return this.prcProcesseur;
   }

   public void setPrcProcesseur(String var1) {
      this.prcProcesseur = var1;
   }

   public String getPrcCartouche() {
      return this.prcCartouche;
   }

   public void setPrcCartouche(String var1) {
      this.prcCartouche = var1;
   }

   public String getPrcTypeImprimante() {
      return this.prcTypeImprimante;
   }

   public void setPrcTypeImprimante(String var1) {
      this.prcTypeImprimante = var1;
   }
}
