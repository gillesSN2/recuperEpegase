package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ValorisationEnteteAchats implements Serializable {
   private long valId;
   private Date valDateCreat;
   private Date valDateModif;
   private long valIdCreateur;
   private String valNomCreateur;
   private long valIdModif;
   private String valNomModif;
   private Date valDate;
   private String valNum;
   private String valSerie;
   private String valSite;
   private String valDepartement;
   private String valService;
   private String valRegion;
   private String valSecteur;
   private String valPdv;
   private int valNature1;
   private int valNature2;
   private String valNomResponsable;
   private long valIdResponsable;
   private double valTotalCommande;
   private double valTotalReception;
   private double valTotalRetour;
   private double valTotalNoteDebit;
   private double valTotalReexpedition;
   private double valTotalFrais1;
   private double valTotalFrais2;
   private float valCoef1;
   private float valCoef2;
   private double valPr1;
   private double valPr1Ttc;
   private double valPr2;
   private int valCalcul;
   private String valObjet;
   private String valDossierTransit;
   private String valAnalytique;
   private Date valDateIntention;
   private Date valDateIntentionFin;
   private String valRefCredoc;
   private String valNomBateau;
   private String valPortChargement;
   private Date valDateChargement;
   private String valPortDechargement;
   private Date valDateDechargement;
   private String valBureauDouane;
   private Date valDateArrivee;
   private String valManifeste;
   private String valDeclaration;
   private double valTotalExpert;
   private double valTotalReference;
   private long valIdBanque;
   private String valBanque;
   private int valNbVirement;
   private float valPoidsBrut;
   private float valPoidsNet;
   private int valPoidsUnite;
   private int valNbColis;
   private int valNbContener;
   private int valNbCamion;
   private int valNbWagon;
   private Date valDateImp;
   private String ValModeleImp;
   private int valEtatVal;
   private int valEtat;
   private String valNumTrf;
   private Date valDateValide;
   private double valTotalFob;
   private double valTotalDivers;
   private double valTotalFret;
   private double valTotalFraisProv;
   private double valTotalFinancierProv;
   private double valTotalFinancierTheo;
   private double valTotalFinancierReelle;
   private double valTotalAssuranceProv;
   private double valTotalAssuranceTheo;
   private double valTotalAssuranceReelle;
   private double valTotalDouaneProv;
   private double valTotalDouaneTheo;
   private double valTotalDouaneReelle;
   private double valTotalTvaDouaneProv;
   private double valTotalTvaDouaneTheo;
   private double valTotalTvaDouaneReelle;
   private double valTotalTransit;
   private double valTotalDebours;
   private int valFictif;
   private int valCalculPr;
   private boolean valExoTva;
   private boolean valExoDouane;
   private long valIdAssureur;
   private String valNomAssureur;
   private long valIdTransitaire;
   private String valNomTransitaire;
   private long valIdTransporteur;
   private String valNomTransporteur;
   private String valDevise;
   private float valCoefDeviseDouane;
   private String valLta;
   private int valMode;
   private String valDpi;
   private Date valDateTransfert;
   private float valCoefForfaitTransport;
   private double valForfaitTransport;
   private double valValeurDouane;
   private ExercicesAchats exercicesAchats;
   private Users users;
   private String var_nature1;
   private String var_nature2;
   private String libelleEta;
   private String libelleMode;
   private double var_valeur_douane;

   public String getLibelleMode() {
      if (this.valFictif == 0) {
         this.libelleMode = "Reel";
      } else if (this.valFictif == 1) {
         this.libelleMode = "Théo.";
      } else if (this.valFictif == 2) {
         this.libelleMode = "Prov.";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public String getLibelleEta() {
      if (this.valEtat == 0) {
         this.libelleEta = "En cours";
      } else if (this.valEtat == 1) {
         this.libelleEta = "Validé";
      } else if (this.valEtat == 2) {
         this.libelleEta = "Gelé";
      } else if (this.valEtat == 3) {
         this.libelleEta = "Annulé";
      } else if (this.valEtat == 4) {
         this.libelleEta = "Transformé";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getVar_nature1() {
      if (this.valNature1 == 12) {
         this.var_nature1 = "Commande";
      } else if (this.valNature1 == 13) {
         this.var_nature1 = "Réception";
      }

      return this.var_nature1;
   }

   public void setVar_nature1(String var1) {
      this.var_nature1 = var1;
   }

   public String getVar_nature2() {
      if (this.valNature2 == 17) {
         this.var_nature2 = "Note débit";
      }

      return this.var_nature2;
   }

   public void setVar_nature2(String var1) {
      this.var_nature2 = var1;
   }

   public double getVar_valeur_douane() {
      this.var_valeur_douane = this.valTotalFob + this.valTotalFret + this.valTotalAssuranceReelle + this.valForfaitTransport;
      return this.var_valeur_douane;
   }

   public void setVar_valeur_douane(double var1) {
      this.var_valeur_douane = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public Date getValDate() {
      return this.valDate;
   }

   public void setValDate(Date var1) {
      this.valDate = var1;
   }

   public Date getValDateCreat() {
      return this.valDateCreat;
   }

   public void setValDateCreat(Date var1) {
      this.valDateCreat = var1;
   }

   public Date getValDateModif() {
      return this.valDateModif;
   }

   public void setValDateModif(Date var1) {
      this.valDateModif = var1;
   }

   public long getValId() {
      return this.valId;
   }

   public void setValId(long var1) {
      this.valId = var1;
   }

   public long getValIdCreateur() {
      return this.valIdCreateur;
   }

   public void setValIdCreateur(long var1) {
      this.valIdCreateur = var1;
   }

   public long getValIdModif() {
      return this.valIdModif;
   }

   public void setValIdModif(long var1) {
      this.valIdModif = var1;
   }

   public String getValNomCreateur() {
      return this.valNomCreateur;
   }

   public void setValNomCreateur(String var1) {
      this.valNomCreateur = var1;
   }

   public String getValNomModif() {
      return this.valNomModif;
   }

   public void setValNomModif(String var1) {
      this.valNomModif = var1;
   }

   public String getValNum() {
      return this.valNum;
   }

   public void setValNum(String var1) {
      this.valNum = var1;
   }

   public String getValService() {
      return this.valService;
   }

   public void setValService(String var1) {
      this.valService = var1;
   }

   public long getValIdResponsable() {
      return this.valIdResponsable;
   }

   public void setValIdResponsable(long var1) {
      this.valIdResponsable = var1;
   }

   public String getValNomResponsable() {
      return this.valNomResponsable;
   }

   public void setValNomResponsable(String var1) {
      this.valNomResponsable = var1;
   }

   public String getValBanque() {
      return this.valBanque;
   }

   public void setValBanque(String var1) {
      this.valBanque = var1;
   }

   public String getValBureauDouane() {
      return this.valBureauDouane;
   }

   public void setValBureauDouane(String var1) {
      this.valBureauDouane = var1;
   }

   public int getValCalcul() {
      return this.valCalcul;
   }

   public void setValCalcul(int var1) {
      this.valCalcul = var1;
   }

   public Date getValDateArrivee() {
      return this.valDateArrivee;
   }

   public void setValDateArrivee(Date var1) {
      this.valDateArrivee = var1;
   }

   public Date getValDateChargement() {
      return this.valDateChargement;
   }

   public void setValDateChargement(Date var1) {
      this.valDateChargement = var1;
   }

   public Date getValDateDechargement() {
      return this.valDateDechargement;
   }

   public void setValDateDechargement(Date var1) {
      this.valDateDechargement = var1;
   }

   public Date getValDateIntention() {
      return this.valDateIntention;
   }

   public void setValDateIntention(Date var1) {
      this.valDateIntention = var1;
   }

   public Date getValDateIntentionFin() {
      return this.valDateIntentionFin;
   }

   public void setValDateIntentionFin(Date var1) {
      this.valDateIntentionFin = var1;
   }

   public String getValDossierTransit() {
      return this.valDossierTransit;
   }

   public void setValDossierTransit(String var1) {
      this.valDossierTransit = var1;
   }

   public String getValManifeste() {
      return this.valManifeste;
   }

   public void setValManifeste(String var1) {
      this.valManifeste = var1;
   }

   public int getValNbCamion() {
      return this.valNbCamion;
   }

   public void setValNbCamion(int var1) {
      this.valNbCamion = var1;
   }

   public int getValNbColis() {
      return this.valNbColis;
   }

   public void setValNbColis(int var1) {
      this.valNbColis = var1;
   }

   public int getValNbContener() {
      return this.valNbContener;
   }

   public void setValNbContener(int var1) {
      this.valNbContener = var1;
   }

   public int getValNbWagon() {
      return this.valNbWagon;
   }

   public void setValNbWagon(int var1) {
      this.valNbWagon = var1;
   }

   public String getValNomBateau() {
      return this.valNomBateau;
   }

   public void setValNomBateau(String var1) {
      this.valNomBateau = var1;
   }

   public float getValPoidsBrut() {
      return this.valPoidsBrut;
   }

   public void setValPoidsBrut(float var1) {
      this.valPoidsBrut = var1;
   }

   public float getValPoidsNet() {
      return this.valPoidsNet;
   }

   public void setValPoidsNet(float var1) {
      this.valPoidsNet = var1;
   }

   public String getValPortChargement() {
      return this.valPortChargement;
   }

   public void setValPortChargement(String var1) {
      this.valPortChargement = var1;
   }

   public String getValPortDechargement() {
      return this.valPortDechargement;
   }

   public void setValPortDechargement(String var1) {
      this.valPortDechargement = var1;
   }

   public String getValRefCredoc() {
      return this.valRefCredoc;
   }

   public void setValRefCredoc(String var1) {
      this.valRefCredoc = var1;
   }

   public double getValTotalExpert() {
      return this.valTotalExpert;
   }

   public void setValTotalExpert(double var1) {
      this.valTotalExpert = var1;
   }

   public double getValTotalReference() {
      return this.valTotalReference;
   }

   public void setValTotalReference(double var1) {
      this.valTotalReference = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public Date getValDateImp() {
      return this.valDateImp;
   }

   public void setValDateImp(Date var1) {
      this.valDateImp = var1;
   }

   public Date getValDateValide() {
      return this.valDateValide;
   }

   public void setValDateValide(Date var1) {
      this.valDateValide = var1;
   }

   public int getValEtat() {
      return this.valEtat;
   }

   public void setValEtat(int var1) {
      this.valEtat = var1;
   }

   public int getValEtatVal() {
      return this.valEtatVal;
   }

   public void setValEtatVal(int var1) {
      this.valEtatVal = var1;
   }

   public String getValObjet() {
      return this.valObjet;
   }

   public void setValObjet(String var1) {
      this.valObjet = var1;
   }

   public int getValNature1() {
      return this.valNature1;
   }

   public void setValNature1(int var1) {
      this.valNature1 = var1;
   }

   public int getValNature2() {
      return this.valNature2;
   }

   public void setValNature2(int var1) {
      this.valNature2 = var1;
   }

   public int getValPoidsUnite() {
      return this.valPoidsUnite;
   }

   public void setValPoidsUnite(int var1) {
      this.valPoidsUnite = var1;
   }

   public String getValModeleImp() {
      return this.ValModeleImp;
   }

   public void setValModeleImp(String var1) {
      this.ValModeleImp = var1;
   }

   public String getValSerie() {
      return this.valSerie;
   }

   public void setValSerie(String var1) {
      this.valSerie = var1;
   }

   public String getValDepartement() {
      return this.valDepartement;
   }

   public void setValDepartement(String var1) {
      this.valDepartement = var1;
   }

   public String getValSite() {
      return this.valSite;
   }

   public void setValSite(String var1) {
      this.valSite = var1;
   }

   public String getValPdv() {
      return this.valPdv;
   }

   public void setValPdv(String var1) {
      this.valPdv = var1;
   }

   public String getValRegion() {
      return this.valRegion;
   }

   public void setValRegion(String var1) {
      this.valRegion = var1;
   }

   public String getValSecteur() {
      return this.valSecteur;
   }

   public void setValSecteur(String var1) {
      this.valSecteur = var1;
   }

   public float getValCoef1() {
      return this.valCoef1;
   }

   public void setValCoef1(float var1) {
      this.valCoef1 = var1;
   }

   public float getValCoef2() {
      return this.valCoef2;
   }

   public void setValCoef2(float var1) {
      this.valCoef2 = var1;
   }

   public double getValTotalCommande() {
      return this.valTotalCommande;
   }

   public void setValTotalCommande(double var1) {
      this.valTotalCommande = var1;
   }

   public double getValTotalFrais1() {
      return this.valTotalFrais1;
   }

   public void setValTotalFrais1(double var1) {
      this.valTotalFrais1 = var1;
   }

   public double getValTotalFrais2() {
      return this.valTotalFrais2;
   }

   public void setValTotalFrais2(double var1) {
      this.valTotalFrais2 = var1;
   }

   public double getValTotalNoteDebit() {
      return this.valTotalNoteDebit;
   }

   public void setValTotalNoteDebit(double var1) {
      this.valTotalNoteDebit = var1;
   }

   public double getValTotalReception() {
      return this.valTotalReception;
   }

   public void setValTotalReception(double var1) {
      this.valTotalReception = var1;
   }

   public double getValTotalReexpedition() {
      return this.valTotalReexpedition;
   }

   public void setValTotalReexpedition(double var1) {
      this.valTotalReexpedition = var1;
   }

   public double getValTotalRetour() {
      return this.valTotalRetour;
   }

   public void setValTotalRetour(double var1) {
      this.valTotalRetour = var1;
   }

   public double getValPr1() {
      return this.valPr1;
   }

   public void setValPr1(double var1) {
      this.valPr1 = var1;
   }

   public double getValPr2() {
      return this.valPr2;
   }

   public void setValPr2(double var1) {
      this.valPr2 = var1;
   }

   public double getValTotalDebours() {
      return this.valTotalDebours;
   }

   public void setValTotalDebours(double var1) {
      this.valTotalDebours = var1;
   }

   public double getValTotalDouaneReelle() {
      return this.valTotalDouaneReelle;
   }

   public void setValTotalDouaneReelle(double var1) {
      this.valTotalDouaneReelle = var1;
   }

   public double getValTotalDouaneTheo() {
      return this.valTotalDouaneTheo;
   }

   public void setValTotalDouaneTheo(double var1) {
      this.valTotalDouaneTheo = var1;
   }

   public double getValTotalFret() {
      return this.valTotalFret;
   }

   public void setValTotalFret(double var1) {
      this.valTotalFret = var1;
   }

   public double getValTotalTransit() {
      return this.valTotalTransit;
   }

   public void setValTotalTransit(double var1) {
      this.valTotalTransit = var1;
   }

   public double getValTotalTvaDouaneReelle() {
      return this.valTotalTvaDouaneReelle;
   }

   public void setValTotalTvaDouaneReelle(double var1) {
      this.valTotalTvaDouaneReelle = var1;
   }

   public double getValTotalTvaDouaneTheo() {
      return this.valTotalTvaDouaneTheo;
   }

   public void setValTotalTvaDouaneTheo(double var1) {
      this.valTotalTvaDouaneTheo = var1;
   }

   public double getValTotalDivers() {
      return this.valTotalDivers;
   }

   public void setValTotalDivers(double var1) {
      this.valTotalDivers = var1;
   }

   public double getValTotalFob() {
      return this.valTotalFob;
   }

   public void setValTotalFob(double var1) {
      this.valTotalFob = var1;
   }

   public double getValTotalAssuranceReelle() {
      return this.valTotalAssuranceReelle;
   }

   public void setValTotalAssuranceReelle(double var1) {
      this.valTotalAssuranceReelle = var1;
   }

   public double getValTotalAssuranceTheo() {
      return this.valTotalAssuranceTheo;
   }

   public void setValTotalAssuranceTheo(double var1) {
      this.valTotalAssuranceTheo = var1;
   }

   public int getValFictif() {
      return this.valFictif;
   }

   public void setValFictif(int var1) {
      this.valFictif = var1;
   }

   public int getValCalculPr() {
      return this.valCalculPr;
   }

   public void setValCalculPr(int var1) {
      this.valCalculPr = var1;
   }

   public boolean isValExoDouane() {
      return this.valExoDouane;
   }

   public void setValExoDouane(boolean var1) {
      this.valExoDouane = var1;
   }

   public boolean isValExoTva() {
      return this.valExoTva;
   }

   public void setValExoTva(boolean var1) {
      this.valExoTva = var1;
   }

   public long getValIdAssureur() {
      return this.valIdAssureur;
   }

   public void setValIdAssureur(long var1) {
      this.valIdAssureur = var1;
   }

   public long getValIdTransitaire() {
      return this.valIdTransitaire;
   }

   public void setValIdTransitaire(long var1) {
      this.valIdTransitaire = var1;
   }

   public long getValIdTransporteur() {
      return this.valIdTransporteur;
   }

   public void setValIdTransporteur(long var1) {
      this.valIdTransporteur = var1;
   }

   public String getValNomAssureur() {
      return this.valNomAssureur;
   }

   public void setValNomAssureur(String var1) {
      this.valNomAssureur = var1;
   }

   public String getValNomTransitaire() {
      return this.valNomTransitaire;
   }

   public void setValNomTransitaire(String var1) {
      this.valNomTransitaire = var1;
   }

   public String getValNomTransporteur() {
      return this.valNomTransporteur;
   }

   public void setValNomTransporteur(String var1) {
      this.valNomTransporteur = var1;
   }

   public float getValCoefDeviseDouane() {
      return this.valCoefDeviseDouane;
   }

   public void setValCoefDeviseDouane(float var1) {
      this.valCoefDeviseDouane = var1;
   }

   public String getValLta() {
      return this.valLta;
   }

   public void setValLta(String var1) {
      this.valLta = var1;
   }

   public int getValMode() {
      return this.valMode;
   }

   public void setValMode(int var1) {
      this.valMode = var1;
   }

   public String getValDpi() {
      return this.valDpi;
   }

   public void setValDpi(String var1) {
      this.valDpi = var1;
   }

   public String getValDevise() {
      return this.valDevise;
   }

   public void setValDevise(String var1) {
      this.valDevise = var1;
   }

   public double getValTotalFinancierReelle() {
      return this.valTotalFinancierReelle;
   }

   public void setValTotalFinancierReelle(double var1) {
      this.valTotalFinancierReelle = var1;
   }

   public double getValTotalFinancierTheo() {
      return this.valTotalFinancierTheo;
   }

   public void setValTotalFinancierTheo(double var1) {
      this.valTotalFinancierTheo = var1;
   }

   public Date getValDateTransfert() {
      return this.valDateTransfert;
   }

   public void setValDateTransfert(Date var1) {
      this.valDateTransfert = var1;
   }

   public long getValIdBanque() {
      return this.valIdBanque;
   }

   public void setValIdBanque(long var1) {
      this.valIdBanque = var1;
   }

   public int getValNbVirement() {
      return this.valNbVirement;
   }

   public void setValNbVirement(int var1) {
      this.valNbVirement = var1;
   }

   public float getValCoefForfaitTransport() {
      return this.valCoefForfaitTransport;
   }

   public void setValCoefForfaitTransport(float var1) {
      this.valCoefForfaitTransport = var1;
   }

   public double getValForfaitTransport() {
      this.valForfaitTransport = (double)(this.valPoidsBrut * this.valCoefForfaitTransport);
      return this.valForfaitTransport;
   }

   public void setValForfaitTransport(double var1) {
      this.valForfaitTransport = var1;
   }

   public String getValNumTrf() {
      return this.valNumTrf;
   }

   public void setValNumTrf(String var1) {
      this.valNumTrf = var1;
   }

   public double getValPr1Ttc() {
      return this.valPr1Ttc;
   }

   public void setValPr1Ttc(double var1) {
      this.valPr1Ttc = var1;
   }

   public double getValValeurDouane() {
      return this.valValeurDouane;
   }

   public void setValValeurDouane(double var1) {
      this.valValeurDouane = var1;
   }

   public String getValDeclaration() {
      return this.valDeclaration;
   }

   public void setValDeclaration(String var1) {
      this.valDeclaration = var1;
   }

   public double getValTotalAssuranceProv() {
      return this.valTotalAssuranceProv;
   }

   public void setValTotalAssuranceProv(double var1) {
      this.valTotalAssuranceProv = var1;
   }

   public double getValTotalDouaneProv() {
      return this.valTotalDouaneProv;
   }

   public void setValTotalDouaneProv(double var1) {
      this.valTotalDouaneProv = var1;
   }

   public double getValTotalFinancierProv() {
      return this.valTotalFinancierProv;
   }

   public void setValTotalFinancierProv(double var1) {
      this.valTotalFinancierProv = var1;
   }

   public double getValTotalTvaDouaneProv() {
      return this.valTotalTvaDouaneProv;
   }

   public void setValTotalTvaDouaneProv(double var1) {
      this.valTotalTvaDouaneProv = var1;
   }

   public double getValTotalFraisProv() {
      return this.valTotalFraisProv;
   }

   public void setValTotalFraisProv(double var1) {
      this.valTotalFraisProv = var1;
   }

   public String getValAnalytique() {
      return this.valAnalytique;
   }

   public void setValAnalytique(String var1) {
      this.valAnalytique = var1;
   }
}
