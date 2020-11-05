package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ReunionEntete implements Serializable {
   private long reuId;
   private Date reuDateCreat;
   private Date reuDateModif;
   private long reuIdCreateur;
   private String reuNomCreateur;
   private long reuIdModif;
   private String reuNomModif;
   private Date reuDate;
   private Date reuDateDebut;
   private Date reuDateFin;
   private int reuNature;
   private int reuType;
   private int reuMethode;
   private String reuHeureDeb;
   private String reuHeureFin;
   private String reuMinuteDeb;
   private String reuMinuteFin;
   private String reuNum;
   private String reuNomPresident;
   private long reuIdPresident;
   private String reuCivilPresident;
   private String reuNomSecretaire;
   private long reuIdSecretaire;
   private String reuCivilSecretaire;
   private String reuNomTiers;
   private long reuIdTiers;
   private String reuCivilTiers;
   private long reuIdContact;
   private String reuNomContact;
   private String reuCivilContact;
   private long reuIdFrontOffice;
   private String reuNomFrontOffice;
   private String reuCivilFrontOffice;
   private long reuIdBackOffice;
   private String reuNomBackOffice;
   private String reuCivilBackOffice;
   private String reuObject;
   private String reuIntroduction;
   private String reuContenu;
   private String reuConclusion;
   private String reuLieu;
   private String reuActivite;
   private String reuService;
   private String reuInfo1;
   private String reuInfo2;
   private String reuInfo3;
   private String reuInfo4;
   private String reuInfo5;
   private String reuInfo6;
   private String reuInfo7;
   private String reuInfo8;
   private String reuInfo9;
   private String reuInfo10;
   private Date reuDateImp;
   private Date reuDateEnvoie;
   private Date reuDateCRImp;
   private String reuModeleImp;
   private String reuModeleCRImp;
   private int reuEtatVal;
   private int reuEtat;
   private Date reuDateValide;
   private String libelleEta;
   private String libelleType;
   private String libelleMethode;
   private String listeConvocation;
   private String listeParticipant;
   private String listeAbsent;
   private String libelle_service;
   private String listeActionOld;
   private String listeActionNew;
   private String listeAnalyse;

   public String getListeAnalyse() {
      return this.listeAnalyse;
   }

   public void setListeAnalyse(String var1) {
      this.listeAnalyse = var1;
   }

   public String getLibelleMethode() {
      if (this.reuMethode == 0) {
         this.libelleMethode = "In situ";
      } else if (this.reuMethode == 1) {
         this.libelleMethode = "En extérieur";
      } else if (this.reuMethode == 2) {
         this.libelleMethode = "Par téléphone";
      } else if (this.reuMethode == 3) {
         this.libelleMethode = "Par skype";
      } else if (this.reuMethode == 4) {
         this.libelleMethode = "En vidéo conférence";
      } else if (this.reuMethode == 5) {
         this.libelleMethode = "Par internet";
      } else if (this.reuMethode == 6) {
         this.libelleMethode = "Live Webcast";
      } else if (this.reuMethode == 10) {
         this.libelleMethode = "Rév. 1";
      } else if (this.reuMethode == 11) {
         this.libelleMethode = "Rév. 2";
      } else if (this.reuMethode == 12) {
         this.libelleMethode = "Rév. 3";
      } else if (this.reuMethode == 13) {
         this.libelleMethode = "Rév. 4";
      } else if (this.reuMethode == 14) {
         this.libelleMethode = "Rév. 5";
      } else if (this.reuMethode == 15) {
         this.libelleMethode = "Rév. 6";
      } else if (this.reuMethode == 16) {
         this.libelleMethode = "Rév. 7";
      } else if (this.reuMethode == 17) {
         this.libelleMethode = "Rév. 8";
      } else if (this.reuMethode == 18) {
         this.libelleMethode = "Rév. 9";
      } else if (this.reuMethode == 19) {
         this.libelleMethode = "Rév. 10";
      } else if (this.reuMethode == 20) {
         this.libelleMethode = "Rév. 11";
      } else if (this.reuMethode == 21) {
         this.libelleMethode = "Rév. 12";
      } else if (this.reuMethode == 22) {
         this.libelleMethode = "Rév. 13";
      } else if (this.reuMethode == 23) {
         this.libelleMethode = "Rév. 14";
      } else if (this.reuMethode == 24) {
         this.libelleMethode = "Rév. 15";
      } else if (this.reuMethode == 25) {
         this.libelleMethode = "Rév. 16";
      } else if (this.reuMethode == 26) {
         this.libelleMethode = "Rév. 17";
      } else if (this.reuMethode == 27) {
         this.libelleMethode = "Rév. 18";
      } else if (this.reuMethode == 28) {
         this.libelleMethode = "Rév. 19";
      } else if (this.reuMethode == 29) {
         this.libelleMethode = "Rév. 20";
      }

      return this.libelleMethode;
   }

   public void setLibelleMethode(String var1) {
      this.libelleMethode = var1;
   }

   public String getLibelle_service() {
      if (this.reuService != null && !this.reuService.isEmpty()) {
         if (this.reuService.equals("100")) {
            this.libelle_service = "TOUS SERVICES";
         } else {
            this.libelle_service = this.reuService;
         }
      }

      return this.libelle_service;
   }

   public void setLibelle_service(String var1) {
      this.libelle_service = var1;
   }

   public String getLibelleEta() {
      if (this.reuEtat == 0) {
         this.libelleEta = "Convocation";
      } else if (this.reuEtat == 1) {
         this.libelleEta = "Compte rendu";
      } else if (this.reuEtat == 2) {
         this.libelleEta = "Cloturé";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getLibelleType() {
      if (this.reuType == 0) {
         this.libelleType = "Normale";
      } else if (this.reuType == 1) {
         this.libelleType = "Journalière";
      } else if (this.reuType == 2) {
         this.libelleType = "Hebdomadaire";
      } else if (this.reuType == 3) {
         this.libelleType = "Mensuelle";
      } else if (this.reuType == 4) {
         this.libelleType = "Trimestrielle";
      } else if (this.reuType == 5) {
         this.libelleType = "Semestrielle";
      } else if (this.reuType == 6) {
         this.libelleType = "Annuelle";
      } else if (this.reuType == 7) {
         this.libelleType = "Exceptionnelle";
      } else if (this.reuType == 10) {
         this.libelleType = "Commercial";
      } else if (this.reuType == 11) {
         this.libelleType = "Production";
      } else if (this.reuType == 20) {
         this.libelleType = "Normale";
      } else if (this.reuType == 21) {
         this.libelleType = "Démarches commerciales";
      } else if (this.reuType == 22) {
         this.libelleType = "Démarches administratives";
      } else if (this.reuType == 23) {
         this.libelleType = "Démarches financières";
      } else if (this.reuType == 24) {
         this.libelleType = "Analyses techniques";
      } else if (this.reuType == 25) {
         this.libelleType = "Problèmes adminstratifs";
      } else if (this.reuType == 26) {
         this.libelleType = "Problèmes financiers";
      } else if (this.reuType == 27) {
         this.libelleType = "Problèmes techniques";
      } else if (this.reuType == 28) {
         this.libelleType = "Problèmes relationnels";
      } else if (this.reuType == 29) {
         this.libelleType = "Autres types de problèmes";
      } else if (this.reuType == 30) {
         this.libelleType = "Autres types de réunion";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public String getReuActivite() {
      return this.reuActivite;
   }

   public void setReuActivite(String var1) {
      this.reuActivite = var1;
   }

   public String getReuConclusion() {
      return this.reuConclusion;
   }

   public void setReuConclusion(String var1) {
      this.reuConclusion = var1;
   }

   public String getReuContenu() {
      return this.reuContenu;
   }

   public void setReuContenu(String var1) {
      this.reuContenu = var1;
   }

   public Date getReuDate() {
      return this.reuDate;
   }

   public void setReuDate(Date var1) {
      this.reuDate = var1;
   }

   public Date getReuDateCreat() {
      return this.reuDateCreat;
   }

   public void setReuDateCreat(Date var1) {
      this.reuDateCreat = var1;
   }

   public Date getReuDateImp() {
      return this.reuDateImp;
   }

   public void setReuDateImp(Date var1) {
      this.reuDateImp = var1;
   }

   public Date getReuDateModif() {
      return this.reuDateModif;
   }

   public void setReuDateModif(Date var1) {
      this.reuDateModif = var1;
   }

   public Date getReuDateValide() {
      return this.reuDateValide;
   }

   public void setReuDateValide(Date var1) {
      this.reuDateValide = var1;
   }

   public int getReuEtat() {
      return this.reuEtat;
   }

   public void setReuEtat(int var1) {
      this.reuEtat = var1;
   }

   public int getReuEtatVal() {
      return this.reuEtatVal;
   }

   public void setReuEtatVal(int var1) {
      this.reuEtatVal = var1;
   }

   public String getReuHeureDeb() {
      return this.reuHeureDeb;
   }

   public void setReuHeureDeb(String var1) {
      this.reuHeureDeb = var1;
   }

   public String getReuHeureFin() {
      return this.reuHeureFin;
   }

   public void setReuHeureFin(String var1) {
      this.reuHeureFin = var1;
   }

   public String getReuMinuteDeb() {
      return this.reuMinuteDeb;
   }

   public void setReuMinuteDeb(String var1) {
      this.reuMinuteDeb = var1;
   }

   public String getReuMinuteFin() {
      return this.reuMinuteFin;
   }

   public void setReuMinuteFin(String var1) {
      this.reuMinuteFin = var1;
   }

   public long getReuId() {
      return this.reuId;
   }

   public void setReuId(long var1) {
      this.reuId = var1;
   }

   public long getReuIdCreateur() {
      return this.reuIdCreateur;
   }

   public void setReuIdCreateur(long var1) {
      this.reuIdCreateur = var1;
   }

   public long getReuIdModif() {
      return this.reuIdModif;
   }

   public void setReuIdModif(long var1) {
      this.reuIdModif = var1;
   }

   public String getReuInfo1() {
      return this.reuInfo1;
   }

   public void setReuInfo1(String var1) {
      this.reuInfo1 = var1;
   }

   public String getReuInfo10() {
      return this.reuInfo10;
   }

   public void setReuInfo10(String var1) {
      this.reuInfo10 = var1;
   }

   public String getReuInfo2() {
      return this.reuInfo2;
   }

   public void setReuInfo2(String var1) {
      this.reuInfo2 = var1;
   }

   public String getReuInfo3() {
      return this.reuInfo3;
   }

   public void setReuInfo3(String var1) {
      this.reuInfo3 = var1;
   }

   public String getReuInfo4() {
      return this.reuInfo4;
   }

   public void setReuInfo4(String var1) {
      this.reuInfo4 = var1;
   }

   public String getReuInfo5() {
      return this.reuInfo5;
   }

   public void setReuInfo5(String var1) {
      this.reuInfo5 = var1;
   }

   public String getReuInfo6() {
      return this.reuInfo6;
   }

   public void setReuInfo6(String var1) {
      this.reuInfo6 = var1;
   }

   public String getReuInfo7() {
      return this.reuInfo7;
   }

   public void setReuInfo7(String var1) {
      this.reuInfo7 = var1;
   }

   public String getReuInfo8() {
      return this.reuInfo8;
   }

   public void setReuInfo8(String var1) {
      this.reuInfo8 = var1;
   }

   public String getReuInfo9() {
      return this.reuInfo9;
   }

   public void setReuInfo9(String var1) {
      this.reuInfo9 = var1;
   }

   public String getReuIntroduction() {
      return this.reuIntroduction;
   }

   public void setReuIntroduction(String var1) {
      this.reuIntroduction = var1;
   }

   public String getReuLieu() {
      return this.reuLieu;
   }

   public void setReuLieu(String var1) {
      this.reuLieu = var1;
   }

   public String getReuModeleImp() {
      return this.reuModeleImp;
   }

   public void setReuModeleImp(String var1) {
      this.reuModeleImp = var1;
   }

   public String getReuNomCreateur() {
      return this.reuNomCreateur;
   }

   public void setReuNomCreateur(String var1) {
      this.reuNomCreateur = var1;
   }

   public String getReuNomModif() {
      return this.reuNomModif;
   }

   public void setReuNomModif(String var1) {
      this.reuNomModif = var1;
   }

   public String getReuNum() {
      return this.reuNum;
   }

   public void setReuNum(String var1) {
      this.reuNum = var1;
   }

   public String getReuObject() {
      return this.reuObject;
   }

   public void setReuObject(String var1) {
      this.reuObject = var1;
   }

   public String getReuService() {
      return this.reuService;
   }

   public void setReuService(String var1) {
      this.reuService = var1;
   }

   public int getReuType() {
      return this.reuType;
   }

   public void setReuType(int var1) {
      this.reuType = var1;
   }

   public long getReuIdPresident() {
      return this.reuIdPresident;
   }

   public void setReuIdPresident(long var1) {
      this.reuIdPresident = var1;
   }

   public long getReuIdSecretaire() {
      return this.reuIdSecretaire;
   }

   public void setReuIdSecretaire(long var1) {
      this.reuIdSecretaire = var1;
   }

   public String getReuNomPresident() {
      return this.reuNomPresident;
   }

   public void setReuNomPresident(String var1) {
      this.reuNomPresident = var1;
   }

   public String getReuNomSecretaire() {
      return this.reuNomSecretaire;
   }

   public void setReuNomSecretaire(String var1) {
      this.reuNomSecretaire = var1;
   }

   public String getReuCivilContact() {
      return this.reuCivilContact;
   }

   public void setReuCivilContact(String var1) {
      this.reuCivilContact = var1;
   }

   public String getReuCivilTiers() {
      return this.reuCivilTiers;
   }

   public void setReuCivilTiers(String var1) {
      this.reuCivilTiers = var1;
   }

   public long getReuIdContact() {
      return this.reuIdContact;
   }

   public void setReuIdContact(long var1) {
      this.reuIdContact = var1;
   }

   public String getReuNomContact() {
      return this.reuNomContact;
   }

   public void setReuNomContact(String var1) {
      this.reuNomContact = var1;
   }

   public String getReuNomTiers() {
      return this.reuNomTiers;
   }

   public void setReuNomTiers(String var1) {
      this.reuNomTiers = var1;
   }

   public int getReuNature() {
      return this.reuNature;
   }

   public void setReuNature(int var1) {
      this.reuNature = var1;
   }

   public String getListeConvocation() {
      return this.listeConvocation;
   }

   public void setListeConvocation(String var1) {
      this.listeConvocation = var1;
   }

   public String getListeParticipant() {
      return this.listeParticipant;
   }

   public void setListeParticipant(String var1) {
      this.listeParticipant = var1;
   }

   public String getListeAbsent() {
      return this.listeAbsent;
   }

   public void setListeAbsent(String var1) {
      this.listeAbsent = var1;
   }

   public Date getReuDateCRImp() {
      return this.reuDateCRImp;
   }

   public void setReuDateCRImp(Date var1) {
      this.reuDateCRImp = var1;
   }

   public Date getReuDateEnvoie() {
      return this.reuDateEnvoie;
   }

   public void setReuDateEnvoie(Date var1) {
      this.reuDateEnvoie = var1;
   }

   public int getReuMethode() {
      return this.reuMethode;
   }

   public void setReuMethode(int var1) {
      this.reuMethode = var1;
   }

   public String getReuModeleCRImp() {
      return this.reuModeleCRImp;
   }

   public void setReuModeleCRImp(String var1) {
      this.reuModeleCRImp = var1;
   }

   public String getListeActionNew() {
      return this.listeActionNew;
   }

   public void setListeActionNew(String var1) {
      this.listeActionNew = var1;
   }

   public String getListeActionOld() {
      return this.listeActionOld;
   }

   public void setListeActionOld(String var1) {
      this.listeActionOld = var1;
   }

   public Date getReuDateDebut() {
      return this.reuDateDebut;
   }

   public void setReuDateDebut(Date var1) {
      this.reuDateDebut = var1;
   }

   public Date getReuDateFin() {
      return this.reuDateFin;
   }

   public void setReuDateFin(Date var1) {
      this.reuDateFin = var1;
   }

   public long getReuIdTiers() {
      return this.reuIdTiers;
   }

   public void setReuIdTiers(long var1) {
      this.reuIdTiers = var1;
   }

   public String getReuCivilBackOffice() {
      return this.reuCivilBackOffice;
   }

   public void setReuCivilBackOffice(String var1) {
      this.reuCivilBackOffice = var1;
   }

   public String getReuCivilFrontOffice() {
      return this.reuCivilFrontOffice;
   }

   public void setReuCivilFrontOffice(String var1) {
      this.reuCivilFrontOffice = var1;
   }

   public long getReuIdBackOffice() {
      return this.reuIdBackOffice;
   }

   public void setReuIdBackOffice(long var1) {
      this.reuIdBackOffice = var1;
   }

   public long getReuIdFrontOffice() {
      return this.reuIdFrontOffice;
   }

   public void setReuIdFrontOffice(long var1) {
      this.reuIdFrontOffice = var1;
   }

   public String getReuNomBackOffice() {
      return this.reuNomBackOffice;
   }

   public void setReuNomBackOffice(String var1) {
      this.reuNomBackOffice = var1;
   }

   public String getReuNomFrontOffice() {
      return this.reuNomFrontOffice;
   }

   public void setReuNomFrontOffice(String var1) {
      this.reuNomFrontOffice = var1;
   }

   public String getReuCivilPresident() {
      return this.reuCivilPresident;
   }

   public void setReuCivilPresident(String var1) {
      this.reuCivilPresident = var1;
   }

   public String getReuCivilSecretaire() {
      return this.reuCivilSecretaire;
   }

   public void setReuCivilSecretaire(String var1) {
      this.reuCivilSecretaire = var1;
   }
}
