package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ReacheminementEnteteAchats implements Serializable {
   private long reaId;
   private Date reaDateCreat;
   private Date reaDateModif;
   private long reaIdCreateur;
   private String reaNomCreateur;
   private long reaIdModif;
   private String reaNomModif;
   private Date reaDate;
   private String reaNum;
   private String reaNumAnnonce;
   private String reaValo;
   private String reaNomResponsable;
   private long reaIdResponsable;
   private String reaNomTiers;
   private String reaCivilTiers;
   private long reaIdContact;
   private String reaNomContact;
   private String reaCivilContact;
   private String reaSerie;
   private int reaExoTva;
   private int reaExoDouane;
   private String reaJournalReg;
   private String reaCat;
   private String reaDevise;
   private float reaCoefDevise;
   private String reaObject;
   private String reaObservation;
   private double reaTotHt;
   private double reaTotRemise;
   private double reaTotRabais;
   private double reaTotTva;
   private double reaTotTc;
   private double reaTotTtc;
   private float reaTotPoidsBrut;
   private float reaTotPoidsNet;
   private float reaTotQte;
   private int reaTotNbSac;
   private int reaTotNbCamion;
   private String reaAnal4;
   private String reaInfo1;
   private String reaInfo2;
   private String reaInfo3;
   private String reaInfo4;
   private String reaInfo5;
   private String reaInfo6;
   private String reaInfo7;
   private String reaInfo8;
   private String reaInfo9;
   private String reaInfo10;
   private String reaFormule1;
   private String reaFormule2;
   private String reaAnnexe1;
   private String reaAnnexe2;
   private String reaContrat;
   private String reaIncoterm;
   private String reaLieuLivraison;
   private Date reaDateLivraison;
   private String reaInfoLivraison;
   private String reaNomBateau;
   private int reaTypeMarchandise;
   private Date reaDateImp;
   private String reaModeleImp;
   private int reaEtatVal;
   private int reaValorisation;
   private float reaCoefValo;
   private int reaGele;
   private int reaEtat;
   private Date reaDateValidite;
   private Date reaDateRelance;
   private Date reaDateValide;
   private int reaPosSignature;
   private Date reaDateFacture;
   private String reaNumFature;
   private Date reaDateTransforme;
   private int reaTypeTransforme;
   private Date reaDateAnnule;
   private String reaMotifAnnule;
   private String reaCommentaire;
   private int reaDiversTiers;
   private String reaDiversNom;
   private String reaDiversAdresse;
   private String reaDiversVille;
   private String reaDiversTel;
   private String reaDiversMail;
   private ExercicesAchats exercicesAchats;
   private Tiers tiers;
   private Users users;
   private String libelleEta;
   private boolean var_select_ligne;
   private int var_format_devise;
   private String mode_valorisation;
   private double totRabaisRemise;
   private String var_nomContact;
   private String var_nom_tiers;
   private String libelleTypeMarchandise;

   public String getLibelleTypeMarchandise() {
      if (this.reaTypeMarchandise == 0) {
         this.libelleTypeMarchandise = "vrac";
      } else {
         this.libelleTypeMarchandise = "sac";
      }

      return this.libelleTypeMarchandise;
   }

   public void setLibelleTypeMarchandise(String var1) {
      this.libelleTypeMarchandise = var1;
   }

   public String getVar_nom_tiers() {
      if (this.reaDiversNom != null && !this.reaDiversNom.isEmpty()) {
         this.var_nom_tiers = this.reaDiversNom;
      } else if (this.reaCivilTiers != null && !this.reaCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.reaCivilTiers + " " + this.reaNomTiers;
      } else {
         this.var_nom_tiers = this.reaNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.reaDiversNom != null && !this.reaDiversNom.isEmpty()) {
         this.var_nomContact = "(fournisseur divers)";
      } else if (this.reaCivilContact != null && !this.reaCivilContact.isEmpty()) {
         if (this.reaNomContact != null && !this.reaNomContact.isEmpty()) {
            this.var_nomContact = this.reaCivilContact + " " + this.reaNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.reaNomContact != null && !this.reaNomContact.isEmpty()) {
         this.var_nomContact = this.reaNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public String getLibelleEta() {
      if (this.reaEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.reaEtat == 1) {
         this.libelleEta = "Validée";
      } else if (this.reaEtat == 2) {
         this.libelleEta = "Gelée";
      } else if (this.reaEtat == 3) {
         this.libelleEta = "Annulée";
      } else if (this.reaEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.reaEtat == 5) {
         this.libelleEta = "Trf.T.";
      } else if (this.reaEtat == 6) {
         this.libelleEta = "Valorisée";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getMode_valorisation() {
      if (this.reaValorisation == 0) {
         this.mode_valorisation = "Coef.rea.";
      } else if (this.reaValorisation == 1) {
         this.mode_valorisation = "Frais";
      } else if (this.reaValorisation == 2) {
         this.mode_valorisation = "Coef.Fam.";
      }

      return this.mode_valorisation;
   }

   public void setMode_valorisation(String var1) {
      this.mode_valorisation = var1;
   }

   public double getTotRabaisRemise() {
      this.totRabaisRemise = this.reaTotRabais + this.reaTotRemise;
      return this.totRabaisRemise;
   }

   public void setTotRabaisRemise(double var1) {
      this.totRabaisRemise = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public int getVar_format_devise() {
      if (this.reaDevise != null && !this.reaDevise.isEmpty()) {
         if (!this.reaDevise.equals("XOF") && !this.reaDevise.equals("XAF")) {
            if (!this.reaDevise.equals("EUR") && !this.reaDevise.equals("XEU") && !this.reaDevise.equals("CHF")) {
               this.var_format_devise = 0;
            } else {
               this.var_format_devise = 1;
            }
         } else {
            this.var_format_devise = 2;
         }
      } else {
         this.var_format_devise = 0;
      }

      return this.var_format_devise;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public String getReaAnal4() {
      return this.reaAnal4;
   }

   public void setReaAnal4(String var1) {
      this.reaAnal4 = var1;
   }

   public String getReaAnnexe1() {
      return this.reaAnnexe1;
   }

   public void setReaAnnexe1(String var1) {
      this.reaAnnexe1 = var1;
   }

   public String getReaAnnexe2() {
      return this.reaAnnexe2;
   }

   public void setReaAnnexe2(String var1) {
      this.reaAnnexe2 = var1;
   }

   public String getReaCat() {
      return this.reaCat;
   }

   public void setReaCat(String var1) {
      this.reaCat = var1;
   }

   public String getReaCivilContact() {
      return this.reaCivilContact;
   }

   public void setReaCivilContact(String var1) {
      this.reaCivilContact = var1;
   }

   public String getReaCivilTiers() {
      return this.reaCivilTiers;
   }

   public void setReaCivilTiers(String var1) {
      this.reaCivilTiers = var1;
   }

   public float getReaCoefDevise() {
      return this.reaCoefDevise;
   }

   public void setReaCoefDevise(float var1) {
      this.reaCoefDevise = var1;
   }

   public float getReaCoefValo() {
      return this.reaCoefValo;
   }

   public void setReaCoefValo(float var1) {
      this.reaCoefValo = var1;
   }

   public String getReaCommentaire() {
      return this.reaCommentaire;
   }

   public void setReaCommentaire(String var1) {
      this.reaCommentaire = var1;
   }

   public String getReaContrat() {
      return this.reaContrat;
   }

   public void setReaContrat(String var1) {
      this.reaContrat = var1;
   }

   public Date getReaDate() {
      return this.reaDate;
   }

   public void setReaDate(Date var1) {
      this.reaDate = var1;
   }

   public Date getReaDateAnnule() {
      return this.reaDateAnnule;
   }

   public void setReaDateAnnule(Date var1) {
      this.reaDateAnnule = var1;
   }

   public Date getReaDateCreat() {
      return this.reaDateCreat;
   }

   public void setReaDateCreat(Date var1) {
      this.reaDateCreat = var1;
   }

   public Date getReaDateFacture() {
      return this.reaDateFacture;
   }

   public void setReaDateFacture(Date var1) {
      this.reaDateFacture = var1;
   }

   public Date getReaDateImp() {
      return this.reaDateImp;
   }

   public void setReaDateImp(Date var1) {
      this.reaDateImp = var1;
   }

   public Date getReaDateLivraison() {
      return this.reaDateLivraison;
   }

   public void setReaDateLivraison(Date var1) {
      this.reaDateLivraison = var1;
   }

   public Date getReaDateModif() {
      return this.reaDateModif;
   }

   public void setReaDateModif(Date var1) {
      this.reaDateModif = var1;
   }

   public Date getReaDateRelance() {
      return this.reaDateRelance;
   }

   public void setReaDateRelance(Date var1) {
      this.reaDateRelance = var1;
   }

   public Date getReaDateTransforme() {
      return this.reaDateTransforme;
   }

   public void setReaDateTransforme(Date var1) {
      this.reaDateTransforme = var1;
   }

   public Date getReaDateValide() {
      return this.reaDateValide;
   }

   public void setReaDateValide(Date var1) {
      this.reaDateValide = var1;
   }

   public Date getReaDateValidite() {
      return this.reaDateValidite;
   }

   public void setReaDateValidite(Date var1) {
      this.reaDateValidite = var1;
   }

   public String getReaDevise() {
      return this.reaDevise;
   }

   public void setReaDevise(String var1) {
      this.reaDevise = var1;
   }

   public String getReaDiversAdresse() {
      return this.reaDiversAdresse;
   }

   public void setReaDiversAdresse(String var1) {
      this.reaDiversAdresse = var1;
   }

   public String getReaDiversMail() {
      return this.reaDiversMail;
   }

   public void setReaDiversMail(String var1) {
      this.reaDiversMail = var1;
   }

   public String getReaDiversNom() {
      return this.reaDiversNom;
   }

   public void setReaDiversNom(String var1) {
      this.reaDiversNom = var1;
   }

   public String getReaDiversTel() {
      return this.reaDiversTel;
   }

   public void setReaDiversTel(String var1) {
      this.reaDiversTel = var1;
   }

   public int getReaDiversTiers() {
      return this.reaDiversTiers;
   }

   public void setReaDiversTiers(int var1) {
      this.reaDiversTiers = var1;
   }

   public String getReaDiversVille() {
      return this.reaDiversVille;
   }

   public void setReaDiversVille(String var1) {
      this.reaDiversVille = var1;
   }

   public int getReaEtat() {
      return this.reaEtat;
   }

   public void setReaEtat(int var1) {
      this.reaEtat = var1;
   }

   public int getReaEtatVal() {
      return this.reaEtatVal;
   }

   public void setReaEtatVal(int var1) {
      this.reaEtatVal = var1;
   }

   public int getReaExoDouane() {
      return this.reaExoDouane;
   }

   public void setReaExoDouane(int var1) {
      this.reaExoDouane = var1;
   }

   public int getReaExoTva() {
      return this.reaExoTva;
   }

   public void setReaExoTva(int var1) {
      this.reaExoTva = var1;
   }

   public String getReaFormule1() {
      return this.reaFormule1;
   }

   public void setReaFormule1(String var1) {
      this.reaFormule1 = var1;
   }

   public String getReaFormule2() {
      return this.reaFormule2;
   }

   public void setReaFormule2(String var1) {
      this.reaFormule2 = var1;
   }

   public int getReaGele() {
      return this.reaGele;
   }

   public void setReaGele(int var1) {
      this.reaGele = var1;
   }

   public long getReaId() {
      return this.reaId;
   }

   public void setReaId(long var1) {
      this.reaId = var1;
   }

   public long getReaIdContact() {
      return this.reaIdContact;
   }

   public void setReaIdContact(long var1) {
      this.reaIdContact = var1;
   }

   public long getReaIdCreateur() {
      return this.reaIdCreateur;
   }

   public void setReaIdCreateur(long var1) {
      this.reaIdCreateur = var1;
   }

   public long getReaIdModif() {
      return this.reaIdModif;
   }

   public void setReaIdModif(long var1) {
      this.reaIdModif = var1;
   }

   public long getReaIdResponsable() {
      return this.reaIdResponsable;
   }

   public void setReaIdResponsable(long var1) {
      this.reaIdResponsable = var1;
   }

   public String getReaIncoterm() {
      return this.reaIncoterm;
   }

   public void setReaIncoterm(String var1) {
      this.reaIncoterm = var1;
   }

   public String getReaInfo1() {
      return this.reaInfo1;
   }

   public void setReaInfo1(String var1) {
      this.reaInfo1 = var1;
   }

   public String getReaInfo10() {
      return this.reaInfo10;
   }

   public void setReaInfo10(String var1) {
      this.reaInfo10 = var1;
   }

   public String getReaInfo2() {
      return this.reaInfo2;
   }

   public void setReaInfo2(String var1) {
      this.reaInfo2 = var1;
   }

   public String getReaInfo3() {
      return this.reaInfo3;
   }

   public void setReaInfo3(String var1) {
      this.reaInfo3 = var1;
   }

   public String getReaInfo4() {
      return this.reaInfo4;
   }

   public void setReaInfo4(String var1) {
      this.reaInfo4 = var1;
   }

   public String getReaInfo5() {
      return this.reaInfo5;
   }

   public void setReaInfo5(String var1) {
      this.reaInfo5 = var1;
   }

   public String getReaInfo6() {
      return this.reaInfo6;
   }

   public void setReaInfo6(String var1) {
      this.reaInfo6 = var1;
   }

   public String getReaInfo7() {
      return this.reaInfo7;
   }

   public void setReaInfo7(String var1) {
      this.reaInfo7 = var1;
   }

   public String getReaInfo8() {
      return this.reaInfo8;
   }

   public void setReaInfo8(String var1) {
      this.reaInfo8 = var1;
   }

   public String getReaInfo9() {
      return this.reaInfo9;
   }

   public void setReaInfo9(String var1) {
      this.reaInfo9 = var1;
   }

   public String getReaInfoLivraison() {
      return this.reaInfoLivraison;
   }

   public void setReaInfoLivraison(String var1) {
      this.reaInfoLivraison = var1;
   }

   public String getReaJournalReg() {
      return this.reaJournalReg;
   }

   public void setReaJournalReg(String var1) {
      this.reaJournalReg = var1;
   }

   public String getReaLieuLivraison() {
      return this.reaLieuLivraison;
   }

   public void setReaLieuLivraison(String var1) {
      this.reaLieuLivraison = var1;
   }

   public String getReaModeleImp() {
      return this.reaModeleImp;
   }

   public void setReaModeleImp(String var1) {
      this.reaModeleImp = var1;
   }

   public String getReaMotifAnnule() {
      return this.reaMotifAnnule;
   }

   public void setReaMotifAnnule(String var1) {
      this.reaMotifAnnule = var1;
   }

   public String getReaNomContact() {
      return this.reaNomContact;
   }

   public void setReaNomContact(String var1) {
      this.reaNomContact = var1;
   }

   public String getReaNomCreateur() {
      return this.reaNomCreateur;
   }

   public void setReaNomCreateur(String var1) {
      this.reaNomCreateur = var1;
   }

   public String getReaNomModif() {
      return this.reaNomModif;
   }

   public void setReaNomModif(String var1) {
      this.reaNomModif = var1;
   }

   public String getReaNomResponsable() {
      return this.reaNomResponsable;
   }

   public void setReaNomResponsable(String var1) {
      this.reaNomResponsable = var1;
   }

   public String getReaNomTiers() {
      return this.reaNomTiers;
   }

   public void setReaNomTiers(String var1) {
      this.reaNomTiers = var1;
   }

   public String getReaNum() {
      return this.reaNum;
   }

   public void setReaNum(String var1) {
      this.reaNum = var1;
   }

   public String getReaNumAnnonce() {
      return this.reaNumAnnonce;
   }

   public void setReaNumAnnonce(String var1) {
      this.reaNumAnnonce = var1;
   }

   public String getReaNumFature() {
      return this.reaNumFature;
   }

   public void setReaNumFature(String var1) {
      this.reaNumFature = var1;
   }

   public String getReaObject() {
      return this.reaObject;
   }

   public void setReaObject(String var1) {
      this.reaObject = var1;
   }

   public String getReaObservation() {
      return this.reaObservation;
   }

   public void setReaObservation(String var1) {
      this.reaObservation = var1;
   }

   public int getReaPosSignature() {
      return this.reaPosSignature;
   }

   public void setReaPosSignature(int var1) {
      this.reaPosSignature = var1;
   }

   public String getReaSerie() {
      return this.reaSerie;
   }

   public void setReaSerie(String var1) {
      this.reaSerie = var1;
   }

   public double getReaTotHt() {
      return this.reaTotHt;
   }

   public void setReaTotHt(double var1) {
      this.reaTotHt = var1;
   }

   public float getReaTotPoidsBrut() {
      return this.reaTotPoidsBrut;
   }

   public void setReaTotPoidsBrut(float var1) {
      this.reaTotPoidsBrut = var1;
   }

   public float getReaTotPoidsNet() {
      return this.reaTotPoidsNet;
   }

   public void setReaTotPoidsNet(float var1) {
      this.reaTotPoidsNet = var1;
   }

   public float getReaTotQte() {
      return this.reaTotQte;
   }

   public void setReaTotQte(float var1) {
      this.reaTotQte = var1;
   }

   public double getReaTotRabais() {
      return this.reaTotRabais;
   }

   public void setReaTotRabais(double var1) {
      this.reaTotRabais = var1;
   }

   public double getReaTotRemise() {
      return this.reaTotRemise;
   }

   public void setReaTotRemise(double var1) {
      this.reaTotRemise = var1;
   }

   public double getReaTotTc() {
      return this.reaTotTc;
   }

   public void setReaTotTc(double var1) {
      this.reaTotTc = var1;
   }

   public double getReaTotTtc() {
      return this.reaTotTtc;
   }

   public void setReaTotTtc(double var1) {
      this.reaTotTtc = var1;
   }

   public double getReaTotTva() {
      return this.reaTotTva;
   }

   public void setReaTotTva(double var1) {
      this.reaTotTva = var1;
   }

   public int getReaTypeTransforme() {
      return this.reaTypeTransforme;
   }

   public void setReaTypeTransforme(int var1) {
      this.reaTypeTransforme = var1;
   }

   public String getReaValo() {
      return this.reaValo;
   }

   public void setReaValo(String var1) {
      this.reaValo = var1;
   }

   public int getReaValorisation() {
      return this.reaValorisation;
   }

   public void setReaValorisation(int var1) {
      this.reaValorisation = var1;
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

   public String getReaNomBateau() {
      return this.reaNomBateau;
   }

   public void setReaNomBateau(String var1) {
      this.reaNomBateau = var1;
   }

   public int getReaTypeMarchandise() {
      return this.reaTypeMarchandise;
   }

   public void setReaTypeMarchandise(int var1) {
      this.reaTypeMarchandise = var1;
   }

   public int getReaTotNbSac() {
      return this.reaTotNbSac;
   }

   public void setReaTotNbSac(int var1) {
      this.reaTotNbSac = var1;
   }

   public int getReaTotNbCamion() {
      return this.reaTotNbCamion;
   }

   public void setReaTotNbCamion(int var1) {
      this.reaTotNbCamion = var1;
   }
}
