package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ExercicesComptable implements Serializable {
   private long execpt_id;
   private Date execptDateCreat;
   private Date execptDateModif;
   private Date execptDateCloture;
   private long execptUserCreat;
   private long execptUserCloture;
   private long execptUserModif;
   private Date execptDateDebut;
   private Date execptDateFin;
   private Date execptETDateDebut;
   private Date execptETDateFin;
   private Date execptTBDateDebut;
   private Date execptTBDateFin;
   private int execptEtat;
   private int execptEtatAnterieur;
   private int execptResultat;
   private boolean execptJrxSit;
   private boolean execptJrxRsv;
   private String execptEtatStr;
   private Date execptDateCreationEntreprise;
   private String execptAnneeActivitePays;
   private int execptNbEtablissementPays;
   private int execptNbEtablissementHors;
   private boolean execptCtrlPublique;
   private boolean execptCtrlPriveLoc;
   private boolean execptCtrlPriveEtr;
   private Date execptDateClotPrec;
   private int execptDureePrec;
   private Date execptDateArretCompte;
   private String execptCodeActivite;
   private String execptLibActivite;
   private int execptCapProduction;
   private String execptAgrement;
   private Date execptDateAgrement;
   private String execptDureeAgrement;
   private String execptConvention;
   private int execptTypeEntreprise;
   private int execptRegime;
   private String execptCentreImpot;
   private String execptInscription;
   private boolean execptAnalytique;
   private String execptNomComptable;
   private String execptAdresseComptable;
   private String execptVilleComptable;
   private boolean execptSalarieComptable;
   private String execptTelephoneComptable;
   private String execptNomContact;
   private String execptAdresseContact;
   private String execptVilleContact;
   private String execptTelephoneContact;
   private String execptNomCabinet;
   private String execptAdresseCabinet;
   private String execptVilleCabinet;
   private String execptTelephoneCabinet;
   private String execptQuaContact;
   private String execptNomCommissaire;
   private String execptAdresseCommissaire;
   private String execptVilleCommissaire;
   private String execptTelephoneCommissaire;
   private String execptNomSignataire;
   private String execptQuaSignataire;
   private boolean execptEFCNA;
   private boolean execptEFCR;
   private boolean execptEFCAR;
   private boolean execptEFASR;
   private boolean execptEFANA;
   private boolean execptEFANAP;
   private boolean execptEFAAP;
   private boolean execptLiasse;
   private int execptN1;
   private int execptN2;
   private int execptN3A;
   private int execptN3B;
   private int execptN3C;
   private int execptN3D;
   private int execptN3E;
   private int execptN4;
   private int execptN5;
   private int execptN6;
   private int execptN7;
   private int execptN8;
   private int execptN8A;
   private int execptN9;
   private int execptN10;
   private int execptN11;
   private int execptN12;
   private int execptN13;
   private int execptN14;
   private int execptN15A;
   private int execptN15B;
   private int execptN16A;
   private int execptN16B;
   private int execptN16BB;
   private int execptN16C;
   private int execptN17;
   private int execptN18;
   private int execptN19;
   private int execptN20;
   private int execptN21;
   private int execptN22;
   private int execptN23;
   private int execptN24;
   private int execptN25;
   private int execptN26;
   private int execptN27A;
   private int execptN27B;
   private int execptN28;
   private int execptN29;
   private int execptN30;
   private int execptN31;
   private int execptN32;
   private int execptN33;
   private int execptN34;
   private int execptN35;
   private int execptN36;
   private int execptN37;
   private int execptN38;
   private int execptN39;
   private int execptN40;
   private int execptN41;
   private int execptN42;
   private int execptN43;
   private int execptN44;
   private int execptN45;
   private int execptN46;
   private int execptN47;
   private int execptN48;
   private int execptN49;
   private int execptN50;
   private int execptN51;
   private boolean execptSaisie1;
   private boolean execptSaisie2;
   private boolean execptSaisie3;
   private boolean execptSaisie4;
   private boolean execptSaisie5;
   private int execptSaisie6;
   private int execptSaisie7;
   private int indice;
   private String etat;

   public String getEtat() {
      if (this.execptEtat == 0) {
         this.etat = "Ouvert";
      } else if (this.execptEtat == 1) {
         this.etat = "Cloture provisoire";
      } else if (this.execptEtat == 2) {
         this.etat = "Cloture définitive";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public String getExecptEtatStr() {
      if (this.execptEtat == 0) {
         this.execptEtatStr = "Ouvert";
      } else {
         this.execptEtatStr = "Cloturé";
      }

      return this.execptEtatStr;
   }

   public void setExecptEtatStr(String var1) {
      this.execptEtatStr = var1;
   }

   public Date getExecptDateCloture() {
      return this.execptDateCloture;
   }

   public void setExecptDateCloture(Date var1) {
      this.execptDateCloture = var1;
   }

   public Date getExecptDateCreat() {
      return this.execptDateCreat;
   }

   public void setExecptDateCreat(Date var1) {
      this.execptDateCreat = var1;
   }

   public Date getExecptDateDebut() {
      return this.execptDateDebut;
   }

   public void setExecptDateDebut(Date var1) {
      this.execptDateDebut = var1;
   }

   public Date getExecptDateFin() {
      return this.execptDateFin;
   }

   public void setExecptDateFin(Date var1) {
      this.execptDateFin = var1;
   }

   public Date getExecptDateModif() {
      return this.execptDateModif;
   }

   public void setExecptDateModif(Date var1) {
      this.execptDateModif = var1;
   }

   public int getExecptEtat() {
      return this.execptEtat;
   }

   public void setExecptEtat(int var1) {
      this.execptEtat = var1;
   }

   public long getExecpt_id() {
      return this.execpt_id;
   }

   public void setExecpt_id(long var1) {
      this.execpt_id = var1;
   }

   public long getExecptUserCloture() {
      return this.execptUserCloture;
   }

   public void setExecptUserCloture(long var1) {
      this.execptUserCloture = var1;
   }

   public long getExecptUserCreat() {
      return this.execptUserCreat;
   }

   public void setExecptUserCreat(long var1) {
      this.execptUserCreat = var1;
   }

   public long getExecptUserModif() {
      return this.execptUserModif;
   }

   public void setExecptUserModif(long var1) {
      this.execptUserModif = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }

   public Date getExecptETDateDebut() {
      return this.execptETDateDebut;
   }

   public void setExecptETDateDebut(Date var1) {
      this.execptETDateDebut = var1;
   }

   public Date getExecptETDateFin() {
      return this.execptETDateFin;
   }

   public void setExecptETDateFin(Date var1) {
      this.execptETDateFin = var1;
   }

   public boolean isExecptJrxRsv() {
      return this.execptJrxRsv;
   }

   public void setExecptJrxRsv(boolean var1) {
      this.execptJrxRsv = var1;
   }

   public boolean isExecptJrxSit() {
      return this.execptJrxSit;
   }

   public void setExecptJrxSit(boolean var1) {
      this.execptJrxSit = var1;
   }

   public String getExecptAdresseCommissaire() {
      return this.execptAdresseCommissaire;
   }

   public void setExecptAdresseCommissaire(String var1) {
      this.execptAdresseCommissaire = var1;
   }

   public String getExecptAdresseComptable() {
      return this.execptAdresseComptable;
   }

   public void setExecptAdresseComptable(String var1) {
      this.execptAdresseComptable = var1;
   }

   public String getExecptAdresseContact() {
      return this.execptAdresseContact;
   }

   public void setExecptAdresseContact(String var1) {
      this.execptAdresseContact = var1;
   }

   public String getExecptAgrement() {
      return this.execptAgrement;
   }

   public void setExecptAgrement(String var1) {
      this.execptAgrement = var1;
   }

   public boolean isExecptAnalytique() {
      return this.execptAnalytique;
   }

   public void setExecptAnalytique(boolean var1) {
      this.execptAnalytique = var1;
   }

   public String getExecptCentreImpot() {
      return this.execptCentreImpot;
   }

   public void setExecptCentreImpot(String var1) {
      this.execptCentreImpot = var1;
   }

   public String getExecptConvention() {
      return this.execptConvention;
   }

   public void setExecptConvention(String var1) {
      this.execptConvention = var1;
   }

   public Date getExecptDateAgrement() {
      return this.execptDateAgrement;
   }

   public void setExecptDateAgrement(Date var1) {
      this.execptDateAgrement = var1;
   }

   public Date getExecptDateCreationEntreprise() {
      return this.execptDateCreationEntreprise;
   }

   public void setExecptDateCreationEntreprise(Date var1) {
      this.execptDateCreationEntreprise = var1;
   }

   public String getExecptDureeAgrement() {
      return this.execptDureeAgrement;
   }

   public void setExecptDureeAgrement(String var1) {
      this.execptDureeAgrement = var1;
   }

   public String getExecptInscription() {
      return this.execptInscription;
   }

   public void setExecptInscription(String var1) {
      this.execptInscription = var1;
   }

   public String getExecptNomCommissaire() {
      return this.execptNomCommissaire;
   }

   public void setExecptNomCommissaire(String var1) {
      this.execptNomCommissaire = var1;
   }

   public String getExecptNomComptable() {
      return this.execptNomComptable;
   }

   public void setExecptNomComptable(String var1) {
      this.execptNomComptable = var1;
   }

   public String getExecptNomContact() {
      return this.execptNomContact;
   }

   public void setExecptNomContact(String var1) {
      this.execptNomContact = var1;
   }

   public int getExecptRegime() {
      return this.execptRegime;
   }

   public void setExecptRegime(int var1) {
      this.execptRegime = var1;
   }

   public boolean isExecptSalarieComptable() {
      return this.execptSalarieComptable;
   }

   public void setExecptSalarieComptable(boolean var1) {
      this.execptSalarieComptable = var1;
   }

   public String getExecptTelephoneCommissaire() {
      return this.execptTelephoneCommissaire;
   }

   public void setExecptTelephoneCommissaire(String var1) {
      this.execptTelephoneCommissaire = var1;
   }

   public String getExecptTelephoneComptable() {
      return this.execptTelephoneComptable;
   }

   public void setExecptTelephoneComptable(String var1) {
      this.execptTelephoneComptable = var1;
   }

   public String getExecptTelephoneContact() {
      return this.execptTelephoneContact;
   }

   public void setExecptTelephoneContact(String var1) {
      this.execptTelephoneContact = var1;
   }

   public int getExecptTypeEntreprise() {
      return this.execptTypeEntreprise;
   }

   public void setExecptTypeEntreprise(int var1) {
      this.execptTypeEntreprise = var1;
   }

   public String getExecptVilleCommissaire() {
      return this.execptVilleCommissaire;
   }

   public void setExecptVilleCommissaire(String var1) {
      this.execptVilleCommissaire = var1;
   }

   public String getExecptVilleComptable() {
      return this.execptVilleComptable;
   }

   public void setExecptVilleComptable(String var1) {
      this.execptVilleComptable = var1;
   }

   public String getExecptVilleContact() {
      return this.execptVilleContact;
   }

   public void setExecptVilleContact(String var1) {
      this.execptVilleContact = var1;
   }

   public int getExecptNbEtablissementHors() {
      return this.execptNbEtablissementHors;
   }

   public void setExecptNbEtablissementHors(int var1) {
      this.execptNbEtablissementHors = var1;
   }

   public int getExecptNbEtablissementPays() {
      return this.execptNbEtablissementPays;
   }

   public void setExecptNbEtablissementPays(int var1) {
      this.execptNbEtablissementPays = var1;
   }

   public String getExecptAdresseCabinet() {
      return this.execptAdresseCabinet;
   }

   public void setExecptAdresseCabinet(String var1) {
      this.execptAdresseCabinet = var1;
   }

   public String getExecptAnneeActivitePays() {
      return this.execptAnneeActivitePays;
   }

   public void setExecptAnneeActivitePays(String var1) {
      this.execptAnneeActivitePays = var1;
   }

   public int getExecptCapProduction() {
      return this.execptCapProduction;
   }

   public void setExecptCapProduction(int var1) {
      this.execptCapProduction = var1;
   }

   public String getExecptCodeActivite() {
      return this.execptCodeActivite;
   }

   public void setExecptCodeActivite(String var1) {
      this.execptCodeActivite = var1;
   }

   public boolean isExecptCtrlPriveEtr() {
      return this.execptCtrlPriveEtr;
   }

   public void setExecptCtrlPriveEtr(boolean var1) {
      this.execptCtrlPriveEtr = var1;
   }

   public boolean isExecptCtrlPublique() {
      return this.execptCtrlPublique;
   }

   public void setExecptCtrlPublique(boolean var1) {
      this.execptCtrlPublique = var1;
   }

   public Date getExecptDateArretCompte() {
      return this.execptDateArretCompte;
   }

   public void setExecptDateArretCompte(Date var1) {
      this.execptDateArretCompte = var1;
   }

   public boolean isExecptEFAAP() {
      return this.execptEFAAP;
   }

   public void setExecptEFAAP(boolean var1) {
      this.execptEFAAP = var1;
   }

   public boolean isExecptEFANA() {
      return this.execptEFANA;
   }

   public void setExecptEFANA(boolean var1) {
      this.execptEFANA = var1;
   }

   public boolean isExecptEFANAP() {
      return this.execptEFANAP;
   }

   public void setExecptEFANAP(boolean var1) {
      this.execptEFANAP = var1;
   }

   public boolean isExecptEFASR() {
      return this.execptEFASR;
   }

   public void setExecptEFASR(boolean var1) {
      this.execptEFASR = var1;
   }

   public boolean isExecptEFCAR() {
      return this.execptEFCAR;
   }

   public void setExecptEFCAR(boolean var1) {
      this.execptEFCAR = var1;
   }

   public boolean isExecptEFCNA() {
      return this.execptEFCNA;
   }

   public void setExecptEFCNA(boolean var1) {
      this.execptEFCNA = var1;
   }

   public boolean isExecptEFCR() {
      return this.execptEFCR;
   }

   public void setExecptEFCR(boolean var1) {
      this.execptEFCR = var1;
   }

   public String getExecptLibActivite() {
      return this.execptLibActivite;
   }

   public void setExecptLibActivite(String var1) {
      this.execptLibActivite = var1;
   }

   public String getExecptNomCabinet() {
      return this.execptNomCabinet;
   }

   public void setExecptNomCabinet(String var1) {
      this.execptNomCabinet = var1;
   }

   public String getExecptNomSignataire() {
      return this.execptNomSignataire;
   }

   public void setExecptNomSignataire(String var1) {
      this.execptNomSignataire = var1;
   }

   public String getExecptQuaSignataire() {
      return this.execptQuaSignataire;
   }

   public void setExecptQuaSignataire(String var1) {
      this.execptQuaSignataire = var1;
   }

   public String getExecptTelephoneCabinet() {
      return this.execptTelephoneCabinet;
   }

   public void setExecptTelephoneCabinet(String var1) {
      this.execptTelephoneCabinet = var1;
   }

   public String getExecptVilleCabinet() {
      return this.execptVilleCabinet;
   }

   public void setExecptVilleCabinet(String var1) {
      this.execptVilleCabinet = var1;
   }

   public Date getExecptDateClotPrec() {
      return this.execptDateClotPrec;
   }

   public void setExecptDateClotPrec(Date var1) {
      this.execptDateClotPrec = var1;
   }

   public int getExecptDureePrec() {
      return this.execptDureePrec;
   }

   public void setExecptDureePrec(int var1) {
      this.execptDureePrec = var1;
   }

   public String getExecptQuaContact() {
      return this.execptQuaContact;
   }

   public void setExecptQuaContact(String var1) {
      this.execptQuaContact = var1;
   }

   public boolean isExecptCtrlPriveLoc() {
      return this.execptCtrlPriveLoc;
   }

   public void setExecptCtrlPriveLoc(boolean var1) {
      this.execptCtrlPriveLoc = var1;
   }

   public Date getExecptTBDateDebut() {
      return this.execptTBDateDebut;
   }

   public void setExecptTBDateDebut(Date var1) {
      this.execptTBDateDebut = var1;
   }

   public Date getExecptTBDateFin() {
      return this.execptTBDateFin;
   }

   public void setExecptTBDateFin(Date var1) {
      this.execptTBDateFin = var1;
   }

   public int getExecptEtatAnterieur() {
      return this.execptEtatAnterieur;
   }

   public void setExecptEtatAnterieur(int var1) {
      this.execptEtatAnterieur = var1;
   }

   public boolean isExecptLiasse() {
      return this.execptLiasse;
   }

   public void setExecptLiasse(boolean var1) {
      this.execptLiasse = var1;
   }

   public int getExecptResultat() {
      return this.execptResultat;
   }

   public void setExecptResultat(int var1) {
      this.execptResultat = var1;
   }

   public int getExecptN1() {
      return this.execptN1;
   }

   public void setExecptN1(int var1) {
      this.execptN1 = var1;
   }

   public int getExecptN10() {
      return this.execptN10;
   }

   public void setExecptN10(int var1) {
      this.execptN10 = var1;
   }

   public int getExecptN11() {
      return this.execptN11;
   }

   public void setExecptN11(int var1) {
      this.execptN11 = var1;
   }

   public int getExecptN12() {
      return this.execptN12;
   }

   public void setExecptN12(int var1) {
      this.execptN12 = var1;
   }

   public int getExecptN13() {
      return this.execptN13;
   }

   public void setExecptN13(int var1) {
      this.execptN13 = var1;
   }

   public int getExecptN14() {
      return this.execptN14;
   }

   public void setExecptN14(int var1) {
      this.execptN14 = var1;
   }

   public int getExecptN15A() {
      return this.execptN15A;
   }

   public void setExecptN15A(int var1) {
      this.execptN15A = var1;
   }

   public int getExecptN15B() {
      return this.execptN15B;
   }

   public void setExecptN15B(int var1) {
      this.execptN15B = var1;
   }

   public int getExecptN16A() {
      return this.execptN16A;
   }

   public void setExecptN16A(int var1) {
      this.execptN16A = var1;
   }

   public int getExecptN16B() {
      return this.execptN16B;
   }

   public void setExecptN16B(int var1) {
      this.execptN16B = var1;
   }

   public int getExecptN16BB() {
      return this.execptN16BB;
   }

   public void setExecptN16BB(int var1) {
      this.execptN16BB = var1;
   }

   public int getExecptN16C() {
      return this.execptN16C;
   }

   public void setExecptN16C(int var1) {
      this.execptN16C = var1;
   }

   public int getExecptN17() {
      return this.execptN17;
   }

   public void setExecptN17(int var1) {
      this.execptN17 = var1;
   }

   public int getExecptN18() {
      return this.execptN18;
   }

   public void setExecptN18(int var1) {
      this.execptN18 = var1;
   }

   public int getExecptN19() {
      return this.execptN19;
   }

   public void setExecptN19(int var1) {
      this.execptN19 = var1;
   }

   public int getExecptN2() {
      return this.execptN2;
   }

   public void setExecptN2(int var1) {
      this.execptN2 = var1;
   }

   public int getExecptN20() {
      return this.execptN20;
   }

   public void setExecptN20(int var1) {
      this.execptN20 = var1;
   }

   public int getExecptN21() {
      return this.execptN21;
   }

   public void setExecptN21(int var1) {
      this.execptN21 = var1;
   }

   public int getExecptN22() {
      return this.execptN22;
   }

   public void setExecptN22(int var1) {
      this.execptN22 = var1;
   }

   public int getExecptN23() {
      return this.execptN23;
   }

   public void setExecptN23(int var1) {
      this.execptN23 = var1;
   }

   public int getExecptN24() {
      return this.execptN24;
   }

   public void setExecptN24(int var1) {
      this.execptN24 = var1;
   }

   public int getExecptN25() {
      return this.execptN25;
   }

   public void setExecptN25(int var1) {
      this.execptN25 = var1;
   }

   public int getExecptN26() {
      return this.execptN26;
   }

   public void setExecptN26(int var1) {
      this.execptN26 = var1;
   }

   public int getExecptN27A() {
      return this.execptN27A;
   }

   public void setExecptN27A(int var1) {
      this.execptN27A = var1;
   }

   public int getExecptN27B() {
      return this.execptN27B;
   }

   public void setExecptN27B(int var1) {
      this.execptN27B = var1;
   }

   public int getExecptN28() {
      return this.execptN28;
   }

   public void setExecptN28(int var1) {
      this.execptN28 = var1;
   }

   public int getExecptN29() {
      return this.execptN29;
   }

   public void setExecptN29(int var1) {
      this.execptN29 = var1;
   }

   public int getExecptN30() {
      return this.execptN30;
   }

   public void setExecptN30(int var1) {
      this.execptN30 = var1;
   }

   public int getExecptN31() {
      return this.execptN31;
   }

   public void setExecptN31(int var1) {
      this.execptN31 = var1;
   }

   public int getExecptN32() {
      return this.execptN32;
   }

   public void setExecptN32(int var1) {
      this.execptN32 = var1;
   }

   public int getExecptN33() {
      return this.execptN33;
   }

   public void setExecptN33(int var1) {
      this.execptN33 = var1;
   }

   public int getExecptN34() {
      return this.execptN34;
   }

   public void setExecptN34(int var1) {
      this.execptN34 = var1;
   }

   public int getExecptN35() {
      return this.execptN35;
   }

   public void setExecptN35(int var1) {
      this.execptN35 = var1;
   }

   public int getExecptN36() {
      return this.execptN36;
   }

   public void setExecptN36(int var1) {
      this.execptN36 = var1;
   }

   public int getExecptN37() {
      return this.execptN37;
   }

   public void setExecptN37(int var1) {
      this.execptN37 = var1;
   }

   public int getExecptN3A() {
      return this.execptN3A;
   }

   public void setExecptN3A(int var1) {
      this.execptN3A = var1;
   }

   public int getExecptN3B() {
      return this.execptN3B;
   }

   public void setExecptN3B(int var1) {
      this.execptN3B = var1;
   }

   public int getExecptN3C() {
      return this.execptN3C;
   }

   public void setExecptN3C(int var1) {
      this.execptN3C = var1;
   }

   public int getExecptN3D() {
      return this.execptN3D;
   }

   public void setExecptN3D(int var1) {
      this.execptN3D = var1;
   }

   public int getExecptN3E() {
      return this.execptN3E;
   }

   public void setExecptN3E(int var1) {
      this.execptN3E = var1;
   }

   public int getExecptN4() {
      return this.execptN4;
   }

   public void setExecptN4(int var1) {
      this.execptN4 = var1;
   }

   public int getExecptN5() {
      return this.execptN5;
   }

   public void setExecptN5(int var1) {
      this.execptN5 = var1;
   }

   public int getExecptN6() {
      return this.execptN6;
   }

   public void setExecptN6(int var1) {
      this.execptN6 = var1;
   }

   public int getExecptN7() {
      return this.execptN7;
   }

   public void setExecptN7(int var1) {
      this.execptN7 = var1;
   }

   public int getExecptN8() {
      return this.execptN8;
   }

   public void setExecptN8(int var1) {
      this.execptN8 = var1;
   }

   public int getExecptN8A() {
      return this.execptN8A;
   }

   public void setExecptN8A(int var1) {
      this.execptN8A = var1;
   }

   public int getExecptN9() {
      return this.execptN9;
   }

   public void setExecptN9(int var1) {
      this.execptN9 = var1;
   }

   public int getExecptN38() {
      return this.execptN38;
   }

   public void setExecptN38(int var1) {
      this.execptN38 = var1;
   }

   public int getExecptN39() {
      return this.execptN39;
   }

   public void setExecptN39(int var1) {
      this.execptN39 = var1;
   }

   public int getExecptN40() {
      return this.execptN40;
   }

   public void setExecptN40(int var1) {
      this.execptN40 = var1;
   }

   public int getExecptN41() {
      return this.execptN41;
   }

   public void setExecptN41(int var1) {
      this.execptN41 = var1;
   }

   public int getExecptN42() {
      return this.execptN42;
   }

   public void setExecptN42(int var1) {
      this.execptN42 = var1;
   }

   public int getExecptN43() {
      return this.execptN43;
   }

   public void setExecptN43(int var1) {
      this.execptN43 = var1;
   }

   public int getExecptN44() {
      return this.execptN44;
   }

   public void setExecptN44(int var1) {
      this.execptN44 = var1;
   }

   public int getExecptN45() {
      return this.execptN45;
   }

   public void setExecptN45(int var1) {
      this.execptN45 = var1;
   }

   public int getExecptN46() {
      return this.execptN46;
   }

   public void setExecptN46(int var1) {
      this.execptN46 = var1;
   }

   public int getExecptN47() {
      return this.execptN47;
   }

   public void setExecptN47(int var1) {
      this.execptN47 = var1;
   }

   public int getExecptN48() {
      return this.execptN48;
   }

   public void setExecptN48(int var1) {
      this.execptN48 = var1;
   }

   public int getExecptN49() {
      return this.execptN49;
   }

   public void setExecptN49(int var1) {
      this.execptN49 = var1;
   }

   public int getExecptN50() {
      return this.execptN50;
   }

   public void setExecptN50(int var1) {
      this.execptN50 = var1;
   }

   public int getExecptN51() {
      return this.execptN51;
   }

   public void setExecptN51(int var1) {
      this.execptN51 = var1;
   }

   public boolean isExecptSaisie1() {
      return this.execptSaisie1;
   }

   public void setExecptSaisie1(boolean var1) {
      this.execptSaisie1 = var1;
   }

   public boolean isExecptSaisie2() {
      return this.execptSaisie2;
   }

   public void setExecptSaisie2(boolean var1) {
      this.execptSaisie2 = var1;
   }

   public boolean isExecptSaisie3() {
      return this.execptSaisie3;
   }

   public void setExecptSaisie3(boolean var1) {
      this.execptSaisie3 = var1;
   }

   public boolean isExecptSaisie4() {
      return this.execptSaisie4;
   }

   public void setExecptSaisie4(boolean var1) {
      this.execptSaisie4 = var1;
   }

   public boolean isExecptSaisie5() {
      return this.execptSaisie5;
   }

   public void setExecptSaisie5(boolean var1) {
      this.execptSaisie5 = var1;
   }

   public int getExecptSaisie6() {
      return this.execptSaisie6;
   }

   public void setExecptSaisie6(int var1) {
      this.execptSaisie6 = var1;
   }

   public int getExecptSaisie7() {
      return this.execptSaisie7;
   }

   public void setExecptSaisie7(int var1) {
      this.execptSaisie7 = var1;
   }
}
