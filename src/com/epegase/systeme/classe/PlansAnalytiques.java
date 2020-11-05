package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PlansAnalytiques implements Serializable {
   private long anaId;
   private String anaAnnee;
   private Date anaDateCreat;
   private Date anaDateModif;
   private long anaUserCreat;
   private long anaUserModif;
   private String anaNature;
   private int anaOrdre;
   private String anaCode;
   private String anaCodeComplet;
   private String anaAnalytique;
   private String anaIndice;
   private String anaNomFr;
   private String anaNomUk;
   private String anaNomSp;
   private int anaInactif;
   private int anaNatureRepartition;
   private int anaAnneeDebut;
   private int anaAnneeFin;
   private String anaTypeDossier;
   private String anaTypeDevise;
   private float anaTypeTauxDevise;
   private boolean anaTypeExoTva;
   private boolean anaTypeExoDouane;
   private Date anaMissionDebut;
   private Date anaMissionFin;
   private String anaMissionProprietaire;
   private String anaMissionLettreCmd;
   private String anaMissionChef;
   private double anaMissionCoutTheorique;
   private int anaMissionEtat;
   private String anaTiersCivilite;
   private String anaTiersTelephone;
   private String anaTiersFax;
   private String anaTiersAdresse;
   private String anaTiersBp;
   private String anaTiersMail;
   private String anaTiersVille;
   private String anaTiersPdv;
   private String anaTiersSecteur;
   private String anaTiersRegion;
   private String anaTiersAppreciation;
   private String anaTiersNompays;
   private String anaTiersdevise;
   private int anaTiersFormatDevise;
   private String anaTierssource;
   private String anaTierslangue;
   private String anaTiersObs;
   private String anaTiersRegroupe;
   private boolean anaVte;
   private boolean anaAch;
   private boolean anaPrd;
   private boolean anaFrg;
   private boolean anaInv;
   private boolean anaTva;
   private boolean anaTax;
   private boolean anaSal;
   private boolean anaStr;
   private long anaIdTiers;
   private String anaAffaireService;
   private int anaAffaireEtat;
   private int anaAffaireEtatVal;
   private int anaAffaireGele;
   private Date anaAffaireDateValide;
   private String anaAffaireMdeleImp;
   private String anaAffaireAgent;
   private double anaAffaireTheo;
   private double anaAffaireReel;
   private double anaAffaireMargeTheo;
   private double anaAffaireMargeReel;
   private String anaAffaireContact;
   private Date anaDateInformation;
   private Date anaDateRdv;
   private double anaAffaireCoutTheo;
   private double anaAffaireCoutReel;
   private int anaAffaireNbJourRetard;
   private int anaAffaireMode;
   private long anaAffaireIdClient;
   private String anaAffaireNomClient;
   private String anaAffaireCiviliteClient;
   private String anaAffaireCatClient;
   private long anaAffaireIdContact;
   private String anaAffaireNomContact;
   private String anaAffaireCiviliteContact;
   private long anaAffaireIdResponsable;
   private String anaAffaireNomResponsable;
   private String anaAffaireCiviliteResponsable;
   private long anaAffaireIdCommercial;
   private String anaAffaireNomCommercial;
   private String anaAffaireCiviliteCommercial;
   private Date anaAffaireDateAnnule;
   private Date anaAffaireDateDemande;
   private Date anaAffaireDatelimite;
   private Date anaAffaireDateCotation;
   private Date anaAffaireDatePrp;
   private Date anaAffaireDateCommande;
   private Date anaAffaireDateReception;
   private Date anaAffaireDateDevis;
   private Date anaAffaireDateDevisEnvoie;
   private Date anaAffaireDateLivree;
   private Date anaAffaireDateFacture;
   private int anaAffaireExoDouane;
   private int anaAffaireExoTva;
   private int anaAffaireAvion;
   private int anaAffaireBateau;
   private int anaAffaireExpress;
   private int anaAffaireRoute;
   private int anaAffaireTrain;
   private int anaAffaireReachem1;
   private int anaAffaireReachem2;
   private int anaAffaireReachem3;
   private int anaLotEtat;
   private int anaType;
   private int anaMode;
   private int anaUtilisation;
   private String anaMarteau;
   private String anaRegion;
   private String anaPermis;
   private String anaProprietaire;
   private float anaTauxFermageOkm;
   private double anaPrixOkm;
   private float anaTauxFermageBd;
   private double anaPrixBd;
   private float anaTauxPrecompte;
   private float anaTauxFermage;
   private float anaTauxRedevance;
   private double anaPrixPied;
   private boolean afficheImag;
   private String etat;
   private boolean select_analytique = false;
   private String lib_type;
   private String lib_dossier;
   private String etatLot;
   private String libellePdv;
   private String libelle_mode;
   private String libelle_etat;
   private String libelle_tva;
   private String libelle_douane;
   private int nbJourRetard;
   private String libelleMode;
   private String libelleType;
   private String libelleUtilisation;

   public String getLibelleMode() {
      if (this.anaMode == 0) {
         this.libelleMode = "N.S.";
      } else if (this.anaMode == 1) {
         this.libelleMode = "ATIBT";
      } else if (this.anaMode == 2) {
         this.libelleMode = "OCTRA";
      } else if (this.anaMode == 3) {
         this.libelleMode = "EXPORT";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public String getLibelleType() {
      if (this.anaType == 0) {
         this.libelleType = "Chantier";
      } else if (this.anaType == 1) {
         this.libelleType = "Rupture";
      } else if (this.anaType == 2) {
         this.libelleType = "Gare";
      } else if (this.anaType == 3) {
         this.libelleType = "Beach";
      } else if (this.anaType == 4) {
         this.libelleType = "Usine";
      } else if (this.anaType == 5) {
         this.libelleType = "Port";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public String getLibelleUtilisation() {
      if (this.anaUtilisation == 0) {
         this.libelleUtilisation = "B.Rupture";
      } else if (this.anaUtilisation == 1) {
         this.libelleUtilisation = "B.Route";
      } else if (this.anaUtilisation == 2) {
         this.libelleUtilisation = "B.Expédition";
      } else if (this.anaUtilisation == 3) {
         this.libelleUtilisation = "Spécification";
      } else if (this.anaUtilisation == 4) {
         this.libelleUtilisation = "Usine";
      } else if (this.anaUtilisation == 5) {
         this.libelleUtilisation = "Tous Bord.";
      }

      return this.libelleUtilisation;
   }

   public void setLibelleUtilisation(String var1) {
      this.libelleUtilisation = var1;
   }

   public int getNbJourRetard() {
      if (this.anaAffaireDatelimite != null) {
         this.nbJourRetard = (new Date()).getDay() - this.anaAffaireDatelimite.getDay();
      } else {
         this.nbJourRetard = 0;
      }

      return this.nbJourRetard;
   }

   public void setNbJourRetard(int var1) {
      this.nbJourRetard = var1;
   }

   public String getLibelle_douane() {
      if (this.anaAffaireExoDouane == 0) {
         this.libelle_douane = "";
      } else if (this.anaAffaireExoDouane == 1) {
         this.libelle_douane = "EXO.";
      } else if (this.anaAffaireExoDouane == 2) {
         this.libelle_douane = "REDUIT";
      }

      return this.libelle_douane;
   }

   public void setLibelle_douane(String var1) {
      this.libelle_douane = var1;
   }

   public String getLibelle_tva() {
      if (this.anaAffaireExoTva == 0) {
         this.libelle_tva = "";
      } else if (this.anaAffaireExoTva == 1) {
         this.libelle_tva = "EXO.";
      }

      return this.libelle_tva;
   }

   public void setLibelle_tva(String var1) {
      this.libelle_tva = var1;
   }

   public String getLibelle_etat() {
      if (this.anaAffaireEtat == 0) {
         this.libelle_etat = "E.C.";
      } else if (this.anaAffaireEtat == 1) {
         this.libelle_etat = "VAL";
      } else if (this.anaAffaireEtat == 2) {
         this.libelle_etat = "ANN.";
      } else if (this.anaAffaireEtat == 3) {
         this.libelle_etat = "GEL";
      } else if (this.anaAffaireEtat == 4) {
         this.libelle_etat = "TER.";
      }

      return this.libelle_etat;
   }

   public void setLibelle_etat(String var1) {
      this.libelle_etat = var1;
   }

   public String getLibelle_mode() {
      if (this.anaAffaireMode == 0) {
         this.libelle_mode = "Normal";
      } else if (this.anaAffaireMode == 1) {
         this.libelle_mode = "Urgent";
      } else if (this.anaAffaireMode == 2) {
         this.libelle_mode = "Tres urgent";
      } else if (this.anaAffaireMode == 3) {
         this.libelle_mode = "Appel offre";
      }

      return this.libelle_mode;
   }

   public void setLibelle_mode(String var1) {
      this.libelle_mode = var1;
   }

   public String getLibellePdv() {
      return this.libellePdv;
   }

   public void setLibellePdv(String var1) {
      this.libellePdv = var1;
   }

   public String getEtatLot() {
      if (this.anaLotEtat == 0) {
         this.etatLot = "En Cours";
      } else if (this.anaLotEtat == 1) {
         this.etatLot = "Terminé";
      } else if (this.anaLotEtat == 2) {
         this.etatLot = "Gelé";
      } else if (this.anaLotEtat == 3) {
         this.etatLot = "Abandonné";
      }

      return this.etatLot;
   }

   public void setEtatLot(String var1) {
      this.etatLot = var1;
   }

   public String getLib_dossier() {
      if (this.anaTypeDossier != null && !this.anaTypeDossier.isEmpty()) {
         if (this.anaTypeDossier.equals("0")) {
            this.lib_dossier = "Maritime";
         } else if (this.anaTypeDossier.equals("1")) {
            this.lib_dossier = "Aérien";
         } else if (this.anaTypeDossier.equals("2")) {
            this.lib_dossier = "Express";
         } else if (this.anaTypeDossier.equals("3")) {
            this.lib_dossier = "Routier";
         }
      } else {
         this.lib_dossier = "";
      }

      return this.lib_dossier;
   }

   public void setLib_dossier(String var1) {
      this.lib_dossier = var1;
   }

   public String getEtat() {
      if (this.anaInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.anaInactif == 2) {
         this.etat = "/images/supprimer.gif";
      } else if (this.anaInactif == 3) {
         this.etat = "/images/cadenas_cl.png";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.anaInactif != 1 && this.anaInactif != 2 && this.anaInactif != 3) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getLib_type() {
      if (this.anaNatureRepartition == 10) {
         this.lib_type = "Ventes Commerciales";
      } else if (this.anaNatureRepartition == 11) {
         this.lib_type = "Ventes Administratives";
      } else if (this.anaNatureRepartition == 20) {
         this.lib_type = "Achats Commerciaux";
      } else if (this.anaNatureRepartition == 21) {
         this.lib_type = "Achats Administratifs";
      } else if (this.anaNatureRepartition == 30) {
         this.lib_type = "Production";
      } else if (this.anaNatureRepartition == 40) {
         this.lib_type = "Frais Généraux Commerciaux";
      } else if (this.anaNatureRepartition == 41) {
         this.lib_type = "Frais Généraux Administratifs";
      } else if (this.anaNatureRepartition == 50) {
         this.lib_type = "Investissements";
      } else if (this.anaNatureRepartition == 60) {
         this.lib_type = "TVA";
      } else if (this.anaNatureRepartition == 70) {
         this.lib_type = "Impôts et Taxes";
      } else if (this.anaNatureRepartition == 80) {
         this.lib_type = "Personnels";
      } else if (this.anaNatureRepartition == 120) {
         this.lib_type = "Parcs";
      } else if (this.anaNatureRepartition == 121) {
         this.lib_type = "Dossiers";
      } else if (this.anaNatureRepartition == 122) {
         this.lib_type = "Agents";
      }

      return this.lib_type;
   }

   public void setLib_type(String var1) {
      this.lib_type = var1;
   }

   public int getAnaAnneeDebut() {
      return this.anaAnneeDebut;
   }

   public void setAnaAnneeDebut(int var1) {
      this.anaAnneeDebut = var1;
   }

   public int getAnaAnneeFin() {
      return this.anaAnneeFin;
   }

   public void setAnaAnneeFin(int var1) {
      this.anaAnneeFin = var1;
   }

   public String getAnaCode() {
      if (this.anaCode != null && !this.anaCode.isEmpty()) {
         this.anaCode = this.anaCode.toUpperCase();
      }

      return this.anaCode;
   }

   public void setAnaCode(String var1) {
      this.anaCode = var1;
   }

   public Date getAnaDateCreat() {
      return this.anaDateCreat;
   }

   public void setAnaDateCreat(Date var1) {
      this.anaDateCreat = var1;
   }

   public Date getAnaDateModif() {
      return this.anaDateModif;
   }

   public void setAnaDateModif(Date var1) {
      this.anaDateModif = var1;
   }

   public long getAnaId() {
      return this.anaId;
   }

   public void setAnaId(long var1) {
      this.anaId = var1;
   }

   public int getAnaInactif() {
      return this.anaInactif;
   }

   public void setAnaInactif(int var1) {
      this.anaInactif = var1;
   }

   public String getAnaNature() {
      return this.anaNature;
   }

   public void setAnaNature(String var1) {
      this.anaNature = var1;
   }

   public String getAnaNomFr() {
      if (this.anaNomFr != null && !this.anaNomFr.isEmpty()) {
         this.anaNomFr = this.anaNomFr.toUpperCase();
      }

      return this.anaNomFr;
   }

   public void setAnaNomFr(String var1) {
      this.anaNomFr = var1;
   }

   public String getAnaNomSp() {
      return this.anaNomSp;
   }

   public void setAnaNomSp(String var1) {
      this.anaNomSp = var1;
   }

   public String getAnaNomUk() {
      return this.anaNomUk;
   }

   public void setAnaNomUk(String var1) {
      this.anaNomUk = var1;
   }

   public long getAnaUserCreat() {
      return this.anaUserCreat;
   }

   public void setAnaUserCreat(long var1) {
      this.anaUserCreat = var1;
   }

   public long getAnaUserModif() {
      return this.anaUserModif;
   }

   public void setAnaUserModif(long var1) {
      this.anaUserModif = var1;
   }

   public String getAnaAnnee() {
      return this.anaAnnee;
   }

   public void setAnaAnnee(String var1) {
      this.anaAnnee = var1;
   }

   public int getAnaOrdre() {
      return this.anaOrdre;
   }

   public void setAnaOrdre(int var1) {
      this.anaOrdre = var1;
   }

   public Date getAnaMissionDebut() {
      return this.anaMissionDebut;
   }

   public void setAnaMissionDebut(Date var1) {
      this.anaMissionDebut = var1;
   }

   public Date getAnaMissionFin() {
      return this.anaMissionFin;
   }

   public void setAnaMissionFin(Date var1) {
      this.anaMissionFin = var1;
   }

   public String getAnaTypeDossier() {
      return this.anaTypeDossier;
   }

   public void setAnaTypeDossier(String var1) {
      this.anaTypeDossier = var1;
   }

   public boolean isSelect_analytique() {
      return this.select_analytique;
   }

   public void setSelect_analytique(boolean var1) {
      this.select_analytique = var1;
   }

   public int getAnaNatureRepartition() {
      return this.anaNatureRepartition;
   }

   public void setAnaNatureRepartition(int var1) {
      this.anaNatureRepartition = var1;
   }

   public String getAnaTiersAdresse() {
      return this.anaTiersAdresse;
   }

   public void setAnaTiersAdresse(String var1) {
      this.anaTiersAdresse = var1;
   }

   public String getAnaTiersAppreciation() {
      return this.anaTiersAppreciation;
   }

   public void setAnaTiersAppreciation(String var1) {
      this.anaTiersAppreciation = var1;
   }

   public String getAnaTiersBp() {
      return this.anaTiersBp;
   }

   public void setAnaTiersBp(String var1) {
      this.anaTiersBp = var1;
   }

   public String getAnaTiersCivilite() {
      return this.anaTiersCivilite;
   }

   public void setAnaTiersCivilite(String var1) {
      this.anaTiersCivilite = var1;
   }

   public String getAnaTiersFax() {
      return this.anaTiersFax;
   }

   public void setAnaTiersFax(String var1) {
      this.anaTiersFax = var1;
   }

   public int getAnaTiersFormatDevise() {
      return this.anaTiersFormatDevise;
   }

   public void setAnaTiersFormatDevise(int var1) {
      this.anaTiersFormatDevise = var1;
   }

   public String getAnaTiersMail() {
      return this.anaTiersMail;
   }

   public void setAnaTiersMail(String var1) {
      this.anaTiersMail = var1;
   }

   public String getAnaTiersNompays() {
      return this.anaTiersNompays;
   }

   public void setAnaTiersNompays(String var1) {
      this.anaTiersNompays = var1;
   }

   public String getAnaTiersObs() {
      return this.anaTiersObs;
   }

   public void setAnaTiersObs(String var1) {
      this.anaTiersObs = var1;
   }

   public String getAnaTiersPdv() {
      return this.anaTiersPdv;
   }

   public void setAnaTiersPdv(String var1) {
      this.anaTiersPdv = var1;
   }

   public String getAnaTiersTelephone() {
      return this.anaTiersTelephone;
   }

   public void setAnaTiersTelephone(String var1) {
      this.anaTiersTelephone = var1;
   }

   public String getAnaTiersVille() {
      return this.anaTiersVille;
   }

   public void setAnaTiersVille(String var1) {
      this.anaTiersVille = var1;
   }

   public String getAnaTiersdevise() {
      return this.anaTiersdevise;
   }

   public void setAnaTiersdevise(String var1) {
      this.anaTiersdevise = var1;
   }

   public String getAnaTierslangue() {
      return this.anaTierslangue;
   }

   public void setAnaTierslangue(String var1) {
      this.anaTierslangue = var1;
   }

   public String getAnaTierssource() {
      return this.anaTierssource;
   }

   public void setAnaTierssource(String var1) {
      this.anaTierssource = var1;
   }

   public boolean isAnaAch() {
      return this.anaAch;
   }

   public void setAnaAch(boolean var1) {
      this.anaAch = var1;
   }

   public boolean isAnaFrg() {
      return this.anaFrg;
   }

   public void setAnaFrg(boolean var1) {
      this.anaFrg = var1;
   }

   public boolean isAnaInv() {
      return this.anaInv;
   }

   public void setAnaInv(boolean var1) {
      this.anaInv = var1;
   }

   public boolean isAnaPrd() {
      return this.anaPrd;
   }

   public void setAnaPrd(boolean var1) {
      this.anaPrd = var1;
   }

   public boolean isAnaSal() {
      return this.anaSal;
   }

   public void setAnaSal(boolean var1) {
      this.anaSal = var1;
   }

   public boolean isAnaTax() {
      return this.anaTax;
   }

   public void setAnaTax(boolean var1) {
      this.anaTax = var1;
   }

   public boolean isAnaTva() {
      return this.anaTva;
   }

   public void setAnaTva(boolean var1) {
      this.anaTva = var1;
   }

   public boolean isAnaVte() {
      return this.anaVte;
   }

   public void setAnaVte(boolean var1) {
      this.anaVte = var1;
   }

   public String getAnaMissionChef() {
      return this.anaMissionChef;
   }

   public void setAnaMissionChef(String var1) {
      this.anaMissionChef = var1;
   }

   public double getAnaMissionCoutTheorique() {
      return this.anaMissionCoutTheorique;
   }

   public void setAnaMissionCoutTheorique(double var1) {
      this.anaMissionCoutTheorique = var1;
   }

   public int getAnaMissionEtat() {
      return this.anaMissionEtat;
   }

   public void setAnaMissionEtat(int var1) {
      this.anaMissionEtat = var1;
   }

   public String getAnaMissionLettreCmd() {
      return this.anaMissionLettreCmd;
   }

   public void setAnaMissionLettreCmd(String var1) {
      this.anaMissionLettreCmd = var1;
   }

   public String getAnaMissionProprietaire() {
      return this.anaMissionProprietaire;
   }

   public void setAnaMissionProprietaire(String var1) {
      this.anaMissionProprietaire = var1;
   }

   public String getAnaTypeDevise() {
      return this.anaTypeDevise;
   }

   public void setAnaTypeDevise(String var1) {
      this.anaTypeDevise = var1;
   }

   public boolean isAnaTypeExoDouane() {
      return this.anaTypeExoDouane;
   }

   public void setAnaTypeExoDouane(boolean var1) {
      this.anaTypeExoDouane = var1;
   }

   public boolean isAnaTypeExoTva() {
      return this.anaTypeExoTva;
   }

   public void setAnaTypeExoTva(boolean var1) {
      this.anaTypeExoTva = var1;
   }

   public float getAnaTypeTauxDevise() {
      return this.anaTypeTauxDevise;
   }

   public void setAnaTypeTauxDevise(float var1) {
      this.anaTypeTauxDevise = var1;
   }

   public String getAnaTiersRegroupe() {
      if (this.anaTiersRegroupe != null && !this.anaTiersRegroupe.isEmpty()) {
         this.anaTiersRegroupe = this.anaTiersRegroupe.toUpperCase();
      }

      return this.anaTiersRegroupe;
   }

   public void setAnaTiersRegroupe(String var1) {
      this.anaTiersRegroupe = var1;
   }

   public long getAnaIdTiers() {
      return this.anaIdTiers;
   }

   public void setAnaIdTiers(long var1) {
      this.anaIdTiers = var1;
   }

   public String getAnaAffaireService() {
      return this.anaAffaireService;
   }

   public void setAnaAffaireService(String var1) {
      this.anaAffaireService = var1;
   }

   public int getAnaAffaireEtat() {
      return this.anaAffaireEtat;
   }

   public void setAnaAffaireEtat(int var1) {
      this.anaAffaireEtat = var1;
   }

   public String getAnaAffaireAgent() {
      return this.anaAffaireAgent;
   }

   public void setAnaAffaireAgent(String var1) {
      this.anaAffaireAgent = var1;
   }

   public double getAnaAffaireReel() {
      return this.anaAffaireReel;
   }

   public void setAnaAffaireReel(double var1) {
      this.anaAffaireReel = var1;
   }

   public double getAnaAffaireTheo() {
      return this.anaAffaireTheo;
   }

   public void setAnaAffaireTheo(double var1) {
      this.anaAffaireTheo = var1;
   }

   public String getAnaAffaireContact() {
      return this.anaAffaireContact;
   }

   public void setAnaAffaireContact(String var1) {
      this.anaAffaireContact = var1;
   }

   public double getAnaAffaireCoutReel() {
      return this.anaAffaireCoutReel;
   }

   public void setAnaAffaireCoutReel(double var1) {
      this.anaAffaireCoutReel = var1;
   }

   public double getAnaAffaireCoutTheo() {
      return this.anaAffaireCoutTheo;
   }

   public void setAnaAffaireCoutTheo(double var1) {
      this.anaAffaireCoutTheo = var1;
   }

   public Date getAnaDateInformation() {
      return this.anaDateInformation;
   }

   public void setAnaDateInformation(Date var1) {
      this.anaDateInformation = var1;
   }

   public Date getAnaDateRdv() {
      return this.anaDateRdv;
   }

   public void setAnaDateRdv(Date var1) {
      this.anaDateRdv = var1;
   }

   public boolean isAnaStr() {
      return this.anaStr;
   }

   public void setAnaStr(boolean var1) {
      this.anaStr = var1;
   }

   public double getAnaAffaireMargeReel() {
      return this.anaAffaireMargeReel;
   }

   public void setAnaAffaireMargeReel(double var1) {
      this.anaAffaireMargeReel = var1;
   }

   public double getAnaAffaireMargeTheo() {
      return this.anaAffaireMargeTheo;
   }

   public void setAnaAffaireMargeTheo(double var1) {
      this.anaAffaireMargeTheo = var1;
   }

   public int getAnaLotEtat() {
      return this.anaLotEtat;
   }

   public void setAnaLotEtat(int var1) {
      this.anaLotEtat = var1;
   }

   public String getAnaTiersRegion() {
      return this.anaTiersRegion;
   }

   public void setAnaTiersRegion(String var1) {
      this.anaTiersRegion = var1;
   }

   public String getAnaTiersSecteur() {
      return this.anaTiersSecteur;
   }

   public void setAnaTiersSecteur(String var1) {
      this.anaTiersSecteur = var1;
   }

   public String getAnaAffaireCiviliteCommercial() {
      return this.anaAffaireCiviliteCommercial;
   }

   public void setAnaAffaireCiviliteCommercial(String var1) {
      this.anaAffaireCiviliteCommercial = var1;
   }

   public String getAnaAffaireCiviliteResponsable() {
      return this.anaAffaireCiviliteResponsable;
   }

   public void setAnaAffaireCiviliteResponsable(String var1) {
      this.anaAffaireCiviliteResponsable = var1;
   }

   public Date getAnaAffaireDateDemande() {
      return this.anaAffaireDateDemande;
   }

   public void setAnaAffaireDateDemande(Date var1) {
      this.anaAffaireDateDemande = var1;
   }

   public Date getAnaAffaireDatelimite() {
      return this.anaAffaireDatelimite;
   }

   public void setAnaAffaireDatelimite(Date var1) {
      this.anaAffaireDatelimite = var1;
   }

   public long getAnaAffaireIdCommercial() {
      return this.anaAffaireIdCommercial;
   }

   public void setAnaAffaireIdCommercial(long var1) {
      this.anaAffaireIdCommercial = var1;
   }

   public long getAnaAffaireIdResponsable() {
      return this.anaAffaireIdResponsable;
   }

   public void setAnaAffaireIdResponsable(long var1) {
      this.anaAffaireIdResponsable = var1;
   }

   public int getAnaAffaireMode() {
      return this.anaAffaireMode;
   }

   public void setAnaAffaireMode(int var1) {
      this.anaAffaireMode = var1;
   }

   public int getAnaAffaireNbJourRetard() {
      return this.anaAffaireNbJourRetard;
   }

   public void setAnaAffaireNbJourRetard(int var1) {
      this.anaAffaireNbJourRetard = var1;
   }

   public String getAnaAffaireNomCommercial() {
      return this.anaAffaireNomCommercial;
   }

   public void setAnaAffaireNomCommercial(String var1) {
      this.anaAffaireNomCommercial = var1;
   }

   public String getAnaAffaireNomResponsable() {
      return this.anaAffaireNomResponsable;
   }

   public void setAnaAffaireNomResponsable(String var1) {
      this.anaAffaireNomResponsable = var1;
   }

   public String getAnaAffaireCiviliteClient() {
      return this.anaAffaireCiviliteClient;
   }

   public void setAnaAffaireCiviliteClient(String var1) {
      this.anaAffaireCiviliteClient = var1;
   }

   public long getAnaAffaireIdClient() {
      return this.anaAffaireIdClient;
   }

   public void setAnaAffaireIdClient(long var1) {
      this.anaAffaireIdClient = var1;
   }

   public String getAnaAffaireNomClient() {
      return this.anaAffaireNomClient;
   }

   public void setAnaAffaireNomClient(String var1) {
      this.anaAffaireNomClient = var1;
   }

   public String getAnaAffaireCatClient() {
      return this.anaAffaireCatClient;
   }

   public void setAnaAffaireCatClient(String var1) {
      this.anaAffaireCatClient = var1;
   }

   public int getAnaAffaireExoDouane() {
      return this.anaAffaireExoDouane;
   }

   public void setAnaAffaireExoDouane(int var1) {
      this.anaAffaireExoDouane = var1;
   }

   public int getAnaAffaireExoTva() {
      return this.anaAffaireExoTva;
   }

   public void setAnaAffaireExoTva(int var1) {
      this.anaAffaireExoTva = var1;
   }

   public String getAnaAffaireCiviliteContact() {
      return this.anaAffaireCiviliteContact;
   }

   public void setAnaAffaireCiviliteContact(String var1) {
      this.anaAffaireCiviliteContact = var1;
   }

   public long getAnaAffaireIdContact() {
      return this.anaAffaireIdContact;
   }

   public void setAnaAffaireIdContact(long var1) {
      this.anaAffaireIdContact = var1;
   }

   public String getAnaAffaireNomContact() {
      return this.anaAffaireNomContact;
   }

   public void setAnaAffaireNomContact(String var1) {
      this.anaAffaireNomContact = var1;
   }

   public int getAnaAffaireAvion() {
      return this.anaAffaireAvion;
   }

   public void setAnaAffaireAvion(int var1) {
      this.anaAffaireAvion = var1;
   }

   public int getAnaAffaireBateau() {
      return this.anaAffaireBateau;
   }

   public void setAnaAffaireBateau(int var1) {
      this.anaAffaireBateau = var1;
   }

   public int getAnaAffaireExpress() {
      return this.anaAffaireExpress;
   }

   public void setAnaAffaireExpress(int var1) {
      this.anaAffaireExpress = var1;
   }

   public int getAnaAffaireReachem1() {
      return this.anaAffaireReachem1;
   }

   public void setAnaAffaireReachem1(int var1) {
      this.anaAffaireReachem1 = var1;
   }

   public int getAnaAffaireReachem2() {
      return this.anaAffaireReachem2;
   }

   public void setAnaAffaireReachem2(int var1) {
      this.anaAffaireReachem2 = var1;
   }

   public int getAnaAffaireReachem3() {
      return this.anaAffaireReachem3;
   }

   public void setAnaAffaireReachem3(int var1) {
      this.anaAffaireReachem3 = var1;
   }

   public int getAnaAffaireRoute() {
      return this.anaAffaireRoute;
   }

   public void setAnaAffaireRoute(int var1) {
      this.anaAffaireRoute = var1;
   }

   public int getAnaAffaireEtatVal() {
      return this.anaAffaireEtatVal;
   }

   public void setAnaAffaireEtatVal(int var1) {
      this.anaAffaireEtatVal = var1;
   }

   public int getAnaAffaireGele() {
      return this.anaAffaireGele;
   }

   public void setAnaAffaireGele(int var1) {
      this.anaAffaireGele = var1;
   }

   public Date getAnaAffaireDateValide() {
      return this.anaAffaireDateValide;
   }

   public void setAnaAffaireDateValide(Date var1) {
      this.anaAffaireDateValide = var1;
   }

   public String getAnaAffaireMdeleImp() {
      return this.anaAffaireMdeleImp;
   }

   public void setAnaAffaireMdeleImp(String var1) {
      this.anaAffaireMdeleImp = var1;
   }

   public Date getAnaAffaireDateFacture() {
      return this.anaAffaireDateFacture;
   }

   public void setAnaAffaireDateFacture(Date var1) {
      this.anaAffaireDateFacture = var1;
   }

   public Date getAnaAffaireDateLivree() {
      return this.anaAffaireDateLivree;
   }

   public void setAnaAffaireDateLivree(Date var1) {
      this.anaAffaireDateLivree = var1;
   }

   public Date getAnaAffaireDateCommande() {
      return this.anaAffaireDateCommande;
   }

   public void setAnaAffaireDateCommande(Date var1) {
      this.anaAffaireDateCommande = var1;
   }

   public Date getAnaAffaireDateReception() {
      return this.anaAffaireDateReception;
   }

   public void setAnaAffaireDateReception(Date var1) {
      this.anaAffaireDateReception = var1;
   }

   public Date getAnaAffaireDateAnnule() {
      return this.anaAffaireDateAnnule;
   }

   public void setAnaAffaireDateAnnule(Date var1) {
      this.anaAffaireDateAnnule = var1;
   }

   public Date getAnaAffaireDateDevis() {
      return this.anaAffaireDateDevis;
   }

   public void setAnaAffaireDateDevis(Date var1) {
      this.anaAffaireDateDevis = var1;
   }

   public String getAnaAnalytique() {
      return this.anaAnalytique;
   }

   public void setAnaAnalytique(String var1) {
      this.anaAnalytique = var1;
   }

   public int getAnaAffaireTrain() {
      return this.anaAffaireTrain;
   }

   public void setAnaAffaireTrain(int var1) {
      this.anaAffaireTrain = var1;
   }

   public String getAnaCodeComplet() {
      return this.anaCodeComplet;
   }

   public void setAnaCodeComplet(String var1) {
      this.anaCodeComplet = var1;
   }

   public Date getAnaAffaireDatePrp() {
      return this.anaAffaireDatePrp;
   }

   public void setAnaAffaireDatePrp(Date var1) {
      this.anaAffaireDatePrp = var1;
   }

   public Date getAnaAffaireDateCotation() {
      return this.anaAffaireDateCotation;
   }

   public void setAnaAffaireDateCotation(Date var1) {
      this.anaAffaireDateCotation = var1;
   }

   public String getAnaIndice() {
      return this.anaIndice;
   }

   public void setAnaIndice(String var1) {
      this.anaIndice = var1;
   }

   public Date getAnaAffaireDateDevisEnvoie() {
      return this.anaAffaireDateDevisEnvoie;
   }

   public void setAnaAffaireDateDevisEnvoie(Date var1) {
      this.anaAffaireDateDevisEnvoie = var1;
   }

   public String getAnaMarteau() {
      return this.anaMarteau;
   }

   public void setAnaMarteau(String var1) {
      this.anaMarteau = var1;
   }

   public int getAnaMode() {
      return this.anaMode;
   }

   public void setAnaMode(int var1) {
      this.anaMode = var1;
   }

   public String getAnaPermis() {
      return this.anaPermis;
   }

   public void setAnaPermis(String var1) {
      this.anaPermis = var1;
   }

   public double getAnaPrixBd() {
      return this.anaPrixBd;
   }

   public void setAnaPrixBd(double var1) {
      this.anaPrixBd = var1;
   }

   public double getAnaPrixOkm() {
      return this.anaPrixOkm;
   }

   public void setAnaPrixOkm(double var1) {
      this.anaPrixOkm = var1;
   }

   public double getAnaPrixPied() {
      return this.anaPrixPied;
   }

   public void setAnaPrixPied(double var1) {
      this.anaPrixPied = var1;
   }

   public String getAnaProprietaire() {
      return this.anaProprietaire;
   }

   public void setAnaProprietaire(String var1) {
      this.anaProprietaire = var1;
   }

   public String getAnaRegion() {
      return this.anaRegion;
   }

   public void setAnaRegion(String var1) {
      this.anaRegion = var1;
   }

   public float getAnaTauxFermage() {
      return this.anaTauxFermage;
   }

   public void setAnaTauxFermage(float var1) {
      this.anaTauxFermage = var1;
   }

   public float getAnaTauxFermageBd() {
      return this.anaTauxFermageBd;
   }

   public void setAnaTauxFermageBd(float var1) {
      this.anaTauxFermageBd = var1;
   }

   public float getAnaTauxFermageOkm() {
      return this.anaTauxFermageOkm;
   }

   public void setAnaTauxFermageOkm(float var1) {
      this.anaTauxFermageOkm = var1;
   }

   public float getAnaTauxPrecompte() {
      return this.anaTauxPrecompte;
   }

   public void setAnaTauxPrecompte(float var1) {
      this.anaTauxPrecompte = var1;
   }

   public int getAnaUtilisation() {
      return this.anaUtilisation;
   }

   public void setAnaUtilisation(int var1) {
      this.anaUtilisation = var1;
   }

   public int getAnaType() {
      return this.anaType;
   }

   public void setAnaType(int var1) {
      this.anaType = var1;
   }

   public float getAnaTauxRedevance() {
      return this.anaTauxRedevance;
   }

   public void setAnaTauxRedevance(float var1) {
      this.anaTauxRedevance = var1;
   }
}
