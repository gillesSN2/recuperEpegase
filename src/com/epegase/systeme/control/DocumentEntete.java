package com.epegase.systeme.control;

import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import java.io.Serializable;
import java.util.Date;

public class DocumentEntete implements Serializable {
   private String docCodeBanq;
   private String docLibBanq;
   private String docLibEmetrice;
   private String docCodeEmetrice;
   private String docLibReceptrice;
   private String docCodeReceptrice;
   private String docCodeCaiss;
   private String docLibCaiss;
   private long docId;
   private int docNature;
   private Date docDateCreat;
   private String docNum;
   private String docNumDocument;
   private long docIdCreateur;
   private long docIdResponsable;
   private String docNomResponsable;
   private long docIdCommercial;
   private long docIdEquipe;
   private String docNomEquipe;
   private String docNomTiers;
   private String docNomContact;
   private String docNomCommercial;
   private String docLibelle;
   private String docSerie;
   private int docExoTva;
   private String docCat;
   private int docCategorie;
   private String docEntree;
   private String docObject;
   private String docDevise;
   private int docFormat;
   private double docTotHt;
   private double docTotTva;
   private double docTotTc;
   private double docTotTtc;
   private double docTotReglement;
   private double docAPayer;
   private float docQte;
   private Date docDateEcheReg;
   private Date docDateValeur;
   private int docTypeReg;
   private String docSource;
   private String docActivite;
   private String docLibTypeReg;
   private String docAnal2;
   private String docAnal4;
   private String docSite;
   private String docDepartement;
   private String docService;
   private String docRegion;
   private String docSecteur;
   private String docPdv;
   private String docBudget;
   private String docTreso;
   private int docEtat;
   private String docLibelleEtat;
   private Date docDateRelance;
   private Date docDate;
   private String docModeleImp;
   private String docCaiss;
   private String docNomCaissier;
   private String docNomPayeur;
   private long docIdPayeur;
   private int docMode;
   private String docNumBon;
   private String docConditionReg;
   private boolean docSelect;
   private ExercicesCaisse exercicesCaisse;
   private ExercicesVentes exerciceventes;
   private ExercicesAchats exerciceachats;
   private Contacts contacts;
   private Tiers tiers;
   private int docTypeTiers;
   private Users users;
   private String numComptetier;
   private String var_lib_nat;
   private String var_lib_mode_reg;
   private String var_solde;
   private String libelleEta;
   private int var_format_devise;
   private float pourcent;
   private float valeurPoint;
   private int nbPoint;
   private double reliquat;
   private int nbrDoc;
   private int nbrTrf;
   private float valTrf;

   public double getReliquat() {
      this.reliquat = this.docTotTtc - this.docTotReglement;
      return this.reliquat;
   }

   public void setReliquat(double var1) {
      this.reliquat = var1;
   }

   public String getLibelleEta() {
      if (this.docEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.docEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.docEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.docEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.docEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.docEtat == 5) {
         this.libelleEta = "Trf.T.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getVar_lib_nat() {
      if (this.docNature == 2) {
         this.var_lib_nat = "Messagerie";
      } else if (this.docNature == 5) {
         this.var_lib_nat = "Réunion";
      } else if (this.docNature == 6) {
         this.var_lib_nat = "Ticket";
      } else if (this.docNature == 10) {
         this.var_lib_nat = "Demande Achat";
      } else if (this.docNature == 11) {
         this.var_lib_nat = "Cotation";
      } else if (this.docNature == 12) {
         this.var_lib_nat = "Commande fournisseur";
      } else if (this.docNature == 13) {
         this.var_lib_nat = "Réception";
      } else if (this.docNature == 14) {
         this.var_lib_nat = "Retour fournisseur";
      } else if (this.docNature == 15) {
         this.var_lib_nat = "Facture fournisseur";
      } else if (this.docNature == 16) {
         this.var_lib_nat = "Avoir fournisseur";
      } else if (this.docNature == 17) {
         this.var_lib_nat = "Note débit fournisseur";
      } else if (this.docNature == 18) {
         this.var_lib_nat = "Frais";
      } else if (this.docNature == 19) {
         this.var_lib_nat = "Bon décaissement";
      } else if (this.docNature == 20) {
         this.var_lib_nat = "Besoin";
      } else if (this.docNature == 21) {
         this.var_lib_nat = "Devis";
      } else if (this.docNature == 22) {
         this.var_lib_nat = "Bon commande client";
      } else if (this.docNature == 23) {
         this.var_lib_nat = "Bon livraison client";
      } else if (this.docNature == 24) {
         this.var_lib_nat = "Bon retour client";
      } else if (this.docNature == 25) {
         this.var_lib_nat = "Facture client";
      } else if (this.docNature == 26) {
         this.var_lib_nat = "Avoir client";
      } else if (this.docNature == 27) {
         this.var_lib_nat = "Note débit client";
      } else if (this.docNature == 28) {
         this.var_lib_nat = "Frais Chargement";
      } else if (this.docNature == 29) {
         this.var_lib_nat = "Bon encaissement";
      } else if (this.docNature == 142) {
         this.var_lib_nat = "Facture interne";
      } else if (this.docNature == 30) {
         this.var_lib_nat = "Inventaire";
      } else if (this.docNature == 31) {
         this.var_lib_nat = "Bon entrée";
      } else if (this.docNature == 32) {
         this.var_lib_nat = "Bon sortie";
      } else if (this.docNature == 33) {
         this.var_lib_nat = "Cession";
      } else if (this.docNature == 34) {
         this.var_lib_nat = "Production";
      } else if (this.docNature == 35) {
         this.var_lib_nat = "Valorisation";
      } else if (this.docNature == 40) {
         this.var_lib_nat = "Transport Personnel";
      } else if (this.docNature == 41) {
         this.var_lib_nat = "Transport Matériel";
      } else if (this.docNature == 42) {
         this.var_lib_nat = "Travaux Publics";
      } else if (this.docNature == 43) {
         this.var_lib_nat = "Location";
      } else if (this.docNature == 44) {
         this.var_lib_nat = "Localisation";
      } else if (this.docNature == 45) {
         this.var_lib_nat = "Consommation";
      } else if (this.docNature == 46) {
         this.var_lib_nat = "O.R.";
      } else if (this.docNature == 47) {
         this.var_lib_nat = "Manifest + LV";
      } else if (this.docNature == 48) {
         this.var_lib_nat = "Collecte";
      } else if (this.docNature == 49) {
         this.var_lib_nat = "Chargement";
      } else if (this.docNature == 50) {
         this.var_lib_nat = "Loyer";
      } else if (this.docNature == 51) {
         this.var_lib_nat = "Amortissement";
      } else if (this.docNature == 52) {
         this.var_lib_nat = "Budget";
      } else if (this.docNature == 53) {
         this.var_lib_nat = "Journaux";
      } else if (this.docNature == 60) {
         this.var_lib_nat = "Caisse";
      } else if (this.docNature == 61) {
         this.var_lib_nat = "Reçu";
      } else if (this.docNature == 62) {
         this.var_lib_nat = "Bon de sortie";
      } else if (this.docNature == 63) {
         this.var_lib_nat = "Bon d'entrée";
      } else if (this.docNature == 64) {
         this.var_lib_nat = "Virement interne";
      } else if (this.docNature == 65) {
         this.var_lib_nat = "Ordre de payement";
      } else if (this.docNature == 71) {
         this.var_lib_nat = "Consult. Géné.";
      } else if (this.docNature == 72) {
         this.var_lib_nat = "Consult. Spé.";
      } else if (this.docNature == 73) {
         this.var_lib_nat = "Pharmacie";
      } else if (this.docNature == 74) {
         this.var_lib_nat = "Laboratoire";
      } else if (this.docNature == 75) {
         this.var_lib_nat = "Paillasse";
      } else if (this.docNature == 76) {
         this.var_lib_nat = "Hospitalisation";
      } else if (this.docNature == 77) {
         this.var_lib_nat = "Devis";
      } else if (this.docNature == 78) {
         this.var_lib_nat = "Refacturation";
      } else if (this.docNature == 79) {
         this.var_lib_nat = "Bon encaissement";
      } else if (this.docNature == 80) {
         this.var_lib_nat = "R.H";
      } else if (this.docNature == 81) {
         this.var_lib_nat = "Matricule";
      } else if (this.docNature == 82) {
         this.var_lib_nat = "Contrat";
      } else if (this.docNature == 83) {
         this.var_lib_nat = "Attestation";
      } else if (this.docNature == 84) {
         this.var_lib_nat = "Cursus";
      } else if (this.docNature == 85) {
         this.var_lib_nat = "Certificat";
      } else if (this.docNature == 86) {
         this.var_lib_nat = "Correspondance";
      } else if (this.docNature == 87) {
         this.var_lib_nat = "Prêt (interne/externe/manuel)";
      } else if (this.docNature == 88) {
         this.var_lib_nat = "Bulletin";
      } else if (this.docNature == 165) {
         this.var_lib_nat = "Facture loyer";
      }

      return this.var_lib_nat;
   }

   public void setVar_lib_nat(String var1) {
      this.var_lib_nat = var1;
   }

   public String getVar_lib_mode_reg() {
      if (this.docTypeReg == 0) {
         this.var_lib_mode_reg = "Comptant";
      } else if (this.docTypeReg == 1) {
         this.var_lib_mode_reg = "Terme date de facture";
      } else if (this.docTypeReg == 2) {
         this.var_lib_mode_reg = "Terme fin mois";
      } else if (this.docTypeReg == 3) {
         this.var_lib_mode_reg = "arrivée/payée";
      } else if (this.docTypeReg == 4) {
         this.var_lib_mode_reg = "B.Encaissement";
      }

      return this.var_lib_mode_reg;
   }

   public void setVar_lib_mode_reg(String var1) {
      this.var_lib_mode_reg = var1;
   }

   public String getDocLibTypeReg() {
      if (this.docTypeReg == 0) {
         this.docLibTypeReg = "Espece";
      } else if (this.docTypeReg == 1) {
         this.docLibTypeReg = "Cheque";
      } else if (this.docTypeReg == 2) {
         this.docLibTypeReg = "Virement";
      }

      return this.docLibTypeReg;
   }

   public void setDocLibTypeReg(String var1) {
      this.docLibTypeReg = var1;
   }

   public String getVar_solde() {
      if (this.docTotReglement >= this.docTotTtc) {
         this.var_solde = "Soldé";
      } else {
         this.var_solde = "";
      }

      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public int getVar_format_devise() {
      if (!this.docDevise.equals("XOF") && !this.docDevise.equals("XAF")) {
         if (!this.docDevise.equals("EUR") && !this.docDevise.equals("XEU") && !this.docDevise.equals("CHF")) {
            this.var_format_devise = 0;
         } else {
            this.var_format_devise = 1;
         }
      } else {
         this.var_format_devise = 2;
      }

      return this.var_format_devise;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public Contacts getContacts() {
      return this.contacts;
   }

   public void setContacts(Contacts var1) {
      this.contacts = var1;
   }

   public String getDocActivite() {
      return this.docActivite;
   }

   public void setDocActivite(String var1) {
      this.docActivite = var1;
   }

   public String getDocCat() {
      return this.docCat;
   }

   public void setDocCat(String var1) {
      this.docCat = var1;
   }

   public Date getDocDate() {
      return this.docDate;
   }

   public void setDocDate(Date var1) {
      this.docDate = var1;
   }

   public Date getDocDateCreat() {
      return this.docDateCreat;
   }

   public void setDocDateCreat(Date var1) {
      this.docDateCreat = var1;
   }

   public Date getDocDateEcheReg() {
      return this.docDateEcheReg;
   }

   public void setDocDateEcheReg(Date var1) {
      this.docDateEcheReg = var1;
   }

   public Date getDocDateRelance() {
      return this.docDateRelance;
   }

   public void setDocDateRelance(Date var1) {
      this.docDateRelance = var1;
   }

   public int getDocEtat() {
      return this.docEtat;
   }

   public void setDocEtat(int var1) {
      this.docEtat = var1;
   }

   public int getDocExoTva() {
      return this.docExoTva;
   }

   public void setDocExoTva(int var1) {
      this.docExoTva = var1;
   }

   public long getDocId() {
      return this.docId;
   }

   public void setDocId(long var1) {
      this.docId = var1;
   }

   public long getDocIdCreateur() {
      return this.docIdCreateur;
   }

   public void setDocIdCreateur(long var1) {
      this.docIdCreateur = var1;
   }

   public String getDocNomContact() {
      return this.docNomContact;
   }

   public void setDocNomContact(String var1) {
      this.docNomContact = var1;
   }

   public String getDocNomResponsable() {
      return this.docNomResponsable;
   }

   public void setDocNomResponsable(String var1) {
      this.docNomResponsable = var1;
   }

   public String getDocNomTiers() {
      return this.docNomTiers;
   }

   public void setDocNomTiers(String var1) {
      this.docNomTiers = var1;
   }

   public String getDocNum() {
      return this.docNum;
   }

   public void setDocNum(String var1) {
      this.docNum = var1;
   }

   public String getDocObject() {
      return this.docObject;
   }

   public void setDocObject(String var1) {
      this.docObject = var1;
   }

   public String getDocSerie() {
      return this.docSerie;
   }

   public void setDocSerie(String var1) {
      this.docSerie = var1;
   }

   public double getDocTotHt() {
      return this.docTotHt;
   }

   public void setDocTotHt(double var1) {
      this.docTotHt = var1;
   }

   public double getDocTotReglement() {
      return this.docTotReglement;
   }

   public void setDocTotReglement(double var1) {
      this.docTotReglement = var1;
   }

   public double getDocTotTtc() {
      return this.docTotTtc;
   }

   public void setDocTotTtc(double var1) {
      this.docTotTtc = var1;
   }

   public double getDocTotTva() {
      return this.docTotTva;
   }

   public void setDocTotTva(double var1) {
      this.docTotTva = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public ExercicesAchats getExerciceachats() {
      return this.exerciceachats;
   }

   public void setExerciceachats(ExercicesAchats var1) {
      this.exerciceachats = var1;
   }

   public int getDocNature() {
      return this.docNature;
   }

   public void setDocNature(int var1) {
      this.docNature = var1;
   }

   public double getDocAPayer() {
      return this.docAPayer;
   }

   public void setDocAPayer(double var1) {
      this.docAPayer = var1;
   }

   public int getDocTypeReg() {
      return this.docTypeReg;
   }

   public void setDocTypeReg(int var1) {
      this.docTypeReg = var1;
   }

   public String getDocAnal2() {
      return this.docAnal2;
   }

   public void setDocAnal2(String var1) {
      this.docAnal2 = var1;
   }

   public String getDocAnal4() {
      return this.docAnal4;
   }

   public void setDocAnal4(String var1) {
      this.docAnal4 = var1;
   }

   public String getDocBudget() {
      return this.docBudget;
   }

   public void setDocBudget(String var1) {
      this.docBudget = var1;
   }

   public String getDocDepartement() {
      return this.docDepartement;
   }

   public void setDocDepartement(String var1) {
      this.docDepartement = var1;
   }

   public String getDocPdv() {
      return this.docPdv;
   }

   public void setDocPdv(String var1) {
      this.docPdv = var1;
   }

   public String getDocRegion() {
      return this.docRegion;
   }

   public void setDocRegion(String var1) {
      this.docRegion = var1;
   }

   public String getDocSecteur() {
      return this.docSecteur;
   }

   public void setDocSecteur(String var1) {
      this.docSecteur = var1;
   }

   public String getDocService() {
      return this.docService;
   }

   public void setDocService(String var1) {
      this.docService = var1;
   }

   public String getDocSite() {
      return this.docSite;
   }

   public void setDocSite(String var1) {
      this.docSite = var1;
   }

   public String getDocTreso() {
      return this.docTreso;
   }

   public void setDocTreso(String var1) {
      this.docTreso = var1;
   }

   public String getDocDevise() {
      return this.docDevise;
   }

   public void setDocDevise(String var1) {
      this.docDevise = var1;
   }

   public String getDocModeleImp() {
      return this.docModeleImp;
   }

   public void setDocModeleImp(String var1) {
      this.docModeleImp = var1;
   }

   public int getDocMode() {
      return this.docMode;
   }

   public void setDocMode(int var1) {
      this.docMode = var1;
   }

   public String getDocNumDocument() {
      return this.docNumDocument;
   }

   public void setDocNumDocument(String var1) {
      this.docNumDocument = var1;
   }

   public ExercicesCaisse getExercicesCaisse() {
      return this.exercicesCaisse;
   }

   public void setExercicesCaisse(ExercicesCaisse var1) {
      this.exercicesCaisse = var1;
   }

   public String getDocNumBon() {
      return this.docNumBon;
   }

   public void setDocNumBon(String var1) {
      this.docNumBon = var1;
   }

   public String getDocCaiss() {
      return this.docCaiss;
   }

   public void setDocCaiss(String var1) {
      this.docCaiss = var1;
   }

   public String getDocLibCaiss() {
      return this.docLibCaiss;
   }

   public void setDocLibCaiss(String var1) {
      this.docLibCaiss = var1;
   }

   public String getDocNomCaissier() {
      return this.docNomCaissier;
   }

   public void setDocNomCaissier(String var1) {
      this.docNomCaissier = var1;
   }

   public String getDocNomPayeur() {
      return this.docNomPayeur;
   }

   public void setDocNomPayeur(String var1) {
      this.docNomPayeur = var1;
   }

   public String getDocConditionReg() {
      return this.docConditionReg;
   }

   public void setDocConditionReg(String var1) {
      this.docConditionReg = var1;
   }

   public int getDocTypeTiers() {
      return this.docTypeTiers;
   }

   public void setDocTypeTiers(int var1) {
      this.docTypeTiers = var1;
   }

   public String getDocCodeEmetrice() {
      return this.docCodeEmetrice;
   }

   public void setDocCodeEmetrice(String var1) {
      this.docCodeEmetrice = var1;
   }

   public String getDocCodeReceptrice() {
      return this.docCodeReceptrice;
   }

   public void setDocCodeReceptrice(String var1) {
      this.docCodeReceptrice = var1;
   }

   public String getDocLibEmetrice() {
      return this.docLibEmetrice;
   }

   public void setDocLibEmetrice(String var1) {
      this.docLibEmetrice = var1;
   }

   public String getDocLibReceptrice() {
      return this.docLibReceptrice;
   }

   public void setDocLibReceptrice(String var1) {
      this.docLibReceptrice = var1;
   }

   public String getDocCodeCaiss() {
      return this.docCodeCaiss;
   }

   public void setDocCodeCaiss(String var1) {
      this.docCodeCaiss = var1;
   }

   public Date getDocDateValeur() {
      return this.docDateValeur;
   }

   public void setDocDateValeur(Date var1) {
      this.docDateValeur = var1;
   }

   public int getDocCategorie() {
      return this.docCategorie;
   }

   public void setDocCategorie(int var1) {
      this.docCategorie = var1;
   }

   public String getDocLibelle() {
      return this.docLibelle;
   }

   public void setDocLibelle(String var1) {
      this.docLibelle = var1;
   }

   public String getDocCodeBanq() {
      return this.docCodeBanq;
   }

   public void setDocCodeBanq(String var1) {
      this.docCodeBanq = var1;
   }

   public String getDocLibBanq() {
      return this.docLibBanq;
   }

   public void setDocLibBanq(String var1) {
      this.docLibBanq = var1;
   }

   public boolean isDocSelect() {
      return this.docSelect;
   }

   public void setDocSelect(boolean var1) {
      this.docSelect = var1;
   }

   public int getDocFormat() {
      return this.docFormat;
   }

   public void setDocFormat(int var1) {
      this.docFormat = var1;
   }

   public double getDocTotTc() {
      return this.docTotTc;
   }

   public void setDocTotTc(double var1) {
      this.docTotTc = var1;
   }

   public float getDocQte() {
      return this.docQte;
   }

   public void setDocQte(float var1) {
      this.docQte = var1;
   }

   public long getDocIdCommercial() {
      return this.docIdCommercial;
   }

   public void setDocIdCommercial(long var1) {
      this.docIdCommercial = var1;
   }

   public long getDocIdResponsable() {
      return this.docIdResponsable;
   }

   public void setDocIdResponsable(long var1) {
      this.docIdResponsable = var1;
   }

   public String getNumComptetier() {
      return this.numComptetier;
   }

   public void setNumComptetier(String var1) {
      this.numComptetier = var1;
   }

   public long getDocIdEquipe() {
      return this.docIdEquipe;
   }

   public void setDocIdEquipe(long var1) {
      this.docIdEquipe = var1;
   }

   public String getDocNomEquipe() {
      return this.docNomEquipe;
   }

   public void setDocNomEquipe(String var1) {
      this.docNomEquipe = var1;
   }

   public String getDocSource() {
      return this.docSource;
   }

   public void setDocSource(String var1) {
      this.docSource = var1;
   }

   public String getDocNomCommercial() {
      return this.docNomCommercial;
   }

   public void setDocNomCommercial(String var1) {
      this.docNomCommercial = var1;
   }

   public String getDocLibelleEtat() {
      return this.docLibelleEtat;
   }

   public void setDocLibelleEtat(String var1) {
      this.docLibelleEtat = var1;
   }

   public int getNbPoint() {
      return this.nbPoint;
   }

   public void setNbPoint(int var1) {
      this.nbPoint = var1;
   }

   public float getPourcent() {
      return this.pourcent;
   }

   public void setPourcent(float var1) {
      this.pourcent = var1;
   }

   public float getValeurPoint() {
      return this.valeurPoint;
   }

   public void setValeurPoint(float var1) {
      this.valeurPoint = var1;
   }

   public String getDocEntree() {
      return this.docEntree;
   }

   public void setDocEntree(String var1) {
      this.docEntree = var1;
   }

   public long getDocIdPayeur() {
      return this.docIdPayeur;
   }

   public void setDocIdPayeur(long var1) {
      this.docIdPayeur = var1;
   }

   public float getValTrf() {
      return this.valTrf;
   }

   public void setValTrf(float var1) {
      this.valTrf = var1;
   }

   public int getNbrDoc() {
      return this.nbrDoc;
   }

   public void setNbrDoc(int var1) {
      this.nbrDoc = var1;
   }

   public int getNbrTrf() {
      return this.nbrTrf;
   }

   public void setNbrTrf(int var1) {
      this.nbrTrf = var1;
   }
}
