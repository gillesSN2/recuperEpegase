package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Patients implements Serializable {
   private long patId;
   private String patDossier;
   private Date patDateCreat;
   private Date patDateModif;
   private long patUserCreat;
   private long patUserModif;
   private int patEtat;
   private float patPourcentCasSocial;
   private String patNumContrat;
   private String patImmatriculation;
   private String patNom;
   private String patPrenom;
   private String patNomJf;
   private String patSurnom;
   private String patPec;
   private String patSociete;
   private long patIdSociete;
   private String patAssurance;
   private long patIdAssurance;
   private String patComplementaire;
   private long patIdComplementaire;
   private long patIdCouvertPar;
   private String patCi;
   private String patPassport;
   private String patSecu;
   private String patCnamgs;
   private String patCouvert;
   private String patCivilite;
   private String patLangueParle;
   private String patTelDom;
   private String patCel1;
   private String patCel2;
   private String patCel3;
   private String patTelVoiture;
   private int patSexe;
   private Date patDateNaissance;
   private Date patDateEmbauche;
   private String patLieuNaissance;
   private String patPaysNaissance;
   private String patObservations;
   private String patAdresse;
   private String patRue;
   private String patLot;
   private String patIlot;
   private String patBatiment;
   private String patPorte;
   private String patEtage;
   private String patAscensseur;
   private String patQuartier;
   private String patCommune;
   private String patDepart;
   private String patZone;
   private String patBp;
   private String patCedex;
   private String patVille;
   private String patPays;
   private String patBurTel1;
   private String patBurTel2;
   private String patBurFax;
   private String patYahoo;
   private String patMsn;
   private String patSkype;
   private String patMail1;
   private int patNomFamille;
   private long patPecComplementaire;
   private String patSerie;
   private String patNomBanque;
   private String patAdresseBanque;
   private String patNumBanque;
   private String patGuichetBanque;
   private String patCompteBanque;
   private String patCleBanque;
   private String patIban;
   private String patSwift;
   private String patCompte;
   private Date patDatePrelev1;
   private String patGroupe1;
   private int patD1;
   private int patC1;
   private int patCc1;
   private int patE1;
   private int patEe1;
   private int patCde1;
   private int patK1;
   private Date patDatePrelev2;
   private String patGroupe2;
   private String patRhesus1;
   private String patRhesus2;
   private int patD2;
   private int patC2;
   private int patCc2;
   private int patE2;
   private int patEe2;
   private int patCde2;
   private int patK2;
   private int patSitFam;
   private int patHabitat;
   private int patNbEnfant;
   private String patSecteurActivite;
   private String patProfession;
   private String patProfObs;
   private String patNomPere;
   private String patNomMere;
   private String patReligion;
   private String patModereg;
   private int patTypereg;
   private int patNbecheance;
   private int patNbarrondi;
   private String patConditionreg;
   private String patPhoto;
   private String patQualite;
   private long patIdUserPaiement;
   private String patSalariePaiement;
   private String etat;
   private boolean inactif;
   private String patronyme;
   private String telephone;
   private String cipasseport;
   private String couleur;
   private String libelleFamille;
   private String symbole;
   private float age;
   private String genre;

   public String getGenre() {
      if (this.patSexe == 0) {
         this.genre = "Femme";
      } else {
         this.genre = "Homme";
      }

      return this.genre;
   }

   public void setGenre(String var1) {
      this.genre = var1;
   }

   public float getAge() {
      return this.age;
   }

   public void setAge(float var1) {
      this.age = var1;
   }

   public String getTelephone() {
      this.telephone = "";
      if (this.patTelDom != null && !this.patTelDom.isEmpty()) {
         this.telephone = this.patTelDom;
      }

      if (this.patCel1 != null && !this.patCel1.isEmpty()) {
         this.telephone = this.telephone + " " + this.patCel1;
      }

      if (this.patCel2 != null && !this.patCel2.isEmpty()) {
         this.telephone = this.telephone + " " + this.patCel2;
      }

      if (this.patCel3 != null && !this.patCel3.isEmpty()) {
         this.telephone = this.telephone + " " + this.patCel3;
      }

      return this.telephone;
   }

   public void setTelephone(String var1) {
      this.telephone = var1;
   }

   public String getCipasseport() {
      this.cipasseport = "";
      if (this.patCi != null && !this.patCi.isEmpty()) {
         this.cipasseport = this.patCi;
      } else if (this.patPassport != null && !this.patPassport.isEmpty()) {
         this.cipasseport = this.patPassport;
      }

      return this.cipasseport;
   }

   public void setCipasseport(String var1) {
      this.cipasseport = var1;
   }

   public String getSymbole() {
      if (this.patSexe == 0) {
         this.symbole = "../../images/femme.png";
      } else {
         this.symbole = "../../images/homme.png";
      }

      return this.symbole;
   }

   public void setSymbole(String var1) {
      this.symbole = var1;
   }

   public String getLibelleFamille() {
      if (this.patNomFamille == 0) {
         this.libelleFamille = "Non Assuré";
      } else if (this.patNomFamille == -1) {
         this.libelleFamille = "Cas Social";
      } else if (this.patNomFamille == -2) {
         this.libelleFamille = "Etat";
      } else {
         this.libelleFamille = "Assuré";
      }

      return this.libelleFamille;
   }

   public void setLibelleFamille(String var1) {
      this.libelleFamille = var1;
   }

   public String getCouleur() {
      if (this.patIdCouvertPar != 0L) {
         this.couleur = "color:blue";
      } else {
         this.couleur = "color:black";
      }

      return this.couleur;
   }

   public void setCouleur(String var1) {
      this.couleur = var1;
   }

   public String getPatronyme() {
      if (this.patPrenom != null && !this.patPrenom.isEmpty()) {
         this.patronyme = this.patNom + " " + this.patPrenom;
      } else {
         this.patronyme = this.patNom;
      }

      return this.patronyme;
   }

   public void setPatronyme(String var1) {
      this.patronyme = var1;
   }

   public String getPatDossier() {
      return this.patDossier;
   }

   public void setPatDossier(String var1) {
      this.patDossier = var1;
   }

   public float getPatPourcentCasSocial() {
      return this.patPourcentCasSocial;
   }

   public void setPatPourcentCasSocial(float var1) {
      this.patPourcentCasSocial = var1;
   }

   public String getEtat() {
      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public String getPatRhesus1() {
      return this.patRhesus1;
   }

   public void setPatRhesus1(String var1) {
      this.patRhesus1 = var1;
   }

   public String getPatRhesus2() {
      return this.patRhesus2;
   }

   public void setPatRhesus2(String var1) {
      this.patRhesus2 = var1;
   }

   public int getPatC1() {
      return this.patC1;
   }

   public void setPatC1(int var1) {
      this.patC1 = var1;
   }

   public int getPatC2() {
      return this.patC2;
   }

   public void setPatC2(int var1) {
      this.patC2 = var1;
   }

   public int getPatCc1() {
      return this.patCc1;
   }

   public void setPatCc1(int var1) {
      this.patCc1 = var1;
   }

   public int getPatCc2() {
      return this.patCc2;
   }

   public void setPatCc2(int var1) {
      this.patCc2 = var1;
   }

   public int getPatCde1() {
      return this.patCde1;
   }

   public void setPatCde1(int var1) {
      this.patCde1 = var1;
   }

   public int getPatCde2() {
      return this.patCde2;
   }

   public void setPatCde2(int var1) {
      this.patCde2 = var1;
   }

   public int getPatD1() {
      return this.patD1;
   }

   public void setPatD1(int var1) {
      this.patD1 = var1;
   }

   public int getPatD2() {
      return this.patD2;
   }

   public void setPatD2(int var1) {
      this.patD2 = var1;
   }

   public int getPatE1() {
      return this.patE1;
   }

   public void setPatE1(int var1) {
      this.patE1 = var1;
   }

   public int getPatE2() {
      return this.patE2;
   }

   public void setPatE2(int var1) {
      this.patE2 = var1;
   }

   public int getPatEe1() {
      return this.patEe1;
   }

   public void setPatEe1(int var1) {
      this.patEe1 = var1;
   }

   public int getPatEe2() {
      return this.patEe2;
   }

   public void setPatEe2(int var1) {
      this.patEe2 = var1;
   }

   public int getPatK1() {
      return this.patK1;
   }

   public void setPatK1(int var1) {
      this.patK1 = var1;
   }

   public int getPatK2() {
      return this.patK2;
   }

   public void setPatK2(int var1) {
      this.patK2 = var1;
   }

   public String getPatAdresse() {
      return this.patAdresse;
   }

   public void setPatAdresse(String var1) {
      this.patAdresse = var1;
   }

   public String getPatAdresseBanque() {
      return this.patAdresseBanque;
   }

   public void setPatAdresseBanque(String var1) {
      this.patAdresseBanque = var1;
   }

   public String getPatAscensseur() {
      return this.patAscensseur;
   }

   public void setPatAscensseur(String var1) {
      this.patAscensseur = var1;
   }

   public String getPatBatiment() {
      return this.patBatiment;
   }

   public void setPatBatiment(String var1) {
      this.patBatiment = var1;
   }

   public String getPatBp() {
      return this.patBp;
   }

   public void setPatBp(String var1) {
      this.patBp = var1;
   }

   public String getPatBurFax() {
      return this.patBurFax;
   }

   public void setPatBurFax(String var1) {
      this.patBurFax = var1;
   }

   public String getPatBurTel1() {
      return this.patBurTel1;
   }

   public void setPatBurTel1(String var1) {
      this.patBurTel1 = var1;
   }

   public String getPatBurTel2() {
      return this.patBurTel2;
   }

   public void setPatBurTel2(String var1) {
      this.patBurTel2 = var1;
   }

   public String getPatCedex() {
      return this.patCedex;
   }

   public void setPatCedex(String var1) {
      this.patCedex = var1;
   }

   public String getPatCel1() {
      return this.patCel1;
   }

   public void setPatCel1(String var1) {
      this.patCel1 = var1;
   }

   public String getPatCel2() {
      return this.patCel2;
   }

   public void setPatCel2(String var1) {
      this.patCel2 = var1;
   }

   public String getPatCel3() {
      return this.patCel3;
   }

   public void setPatCel3(String var1) {
      this.patCel3 = var1;
   }

   public String getPatCi() {
      return this.patCi;
   }

   public void setPatCi(String var1) {
      this.patCi = var1;
   }

   public String getPatCivilite() {
      return this.patCivilite;
   }

   public void setPatCivilite(String var1) {
      this.patCivilite = var1;
   }

   public String getPatCleBanque() {
      return this.patCleBanque;
   }

   public void setPatCleBanque(String var1) {
      this.patCleBanque = var1;
   }

   public String getPatCommune() {
      return this.patCommune;
   }

   public void setPatCommune(String var1) {
      this.patCommune = var1;
   }

   public String getPatCompte() {
      return this.patCompte;
   }

   public void setPatCompte(String var1) {
      this.patCompte = var1;
   }

   public String getPatCompteBanque() {
      return this.patCompteBanque;
   }

   public void setPatCompteBanque(String var1) {
      this.patCompteBanque = var1;
   }

   public String getPatCouvert() {
      return this.patCouvert;
   }

   public void setPatCouvert(String var1) {
      this.patCouvert = var1;
   }

   public Date getPatDateCreat() {
      return this.patDateCreat;
   }

   public void setPatDateCreat(Date var1) {
      this.patDateCreat = var1;
   }

   public Date getPatDateModif() {
      return this.patDateModif;
   }

   public void setPatDateModif(Date var1) {
      this.patDateModif = var1;
   }

   public Date getPatDateNaissance() {
      return this.patDateNaissance;
   }

   public void setPatDateNaissance(Date var1) {
      this.patDateNaissance = var1;
   }

   public Date getPatDatePrelev1() {
      return this.patDatePrelev1;
   }

   public void setPatDatePrelev1(Date var1) {
      this.patDatePrelev1 = var1;
   }

   public Date getPatDatePrelev2() {
      return this.patDatePrelev2;
   }

   public void setPatDatePrelev2(Date var1) {
      this.patDatePrelev2 = var1;
   }

   public String getPatDepart() {
      return this.patDepart;
   }

   public void setPatDepart(String var1) {
      this.patDepart = var1;
   }

   public String getPatEtage() {
      return this.patEtage;
   }

   public void setPatEtage(String var1) {
      this.patEtage = var1;
   }

   public int getPatEtat() {
      return this.patEtat;
   }

   public void setPatEtat(int var1) {
      this.patEtat = var1;
   }

   public String getPatGroupe1() {
      return this.patGroupe1;
   }

   public void setPatGroupe1(String var1) {
      this.patGroupe1 = var1;
   }

   public String getPatGroupe2() {
      return this.patGroupe2;
   }

   public void setPatGroupe2(String var1) {
      this.patGroupe2 = var1;
   }

   public String getPatGuichetBanque() {
      return this.patGuichetBanque;
   }

   public void setPatGuichetBanque(String var1) {
      this.patGuichetBanque = var1;
   }

   public int getPatHabitat() {
      return this.patHabitat;
   }

   public void setPatHabitat(int var1) {
      this.patHabitat = var1;
   }

   public String getPatIban() {
      return this.patIban;
   }

   public void setPatIban(String var1) {
      this.patIban = var1;
   }

   public long getPatId() {
      return this.patId;
   }

   public void setPatId(long var1) {
      this.patId = var1;
   }

   public String getPatIlot() {
      return this.patIlot;
   }

   public void setPatIlot(String var1) {
      this.patIlot = var1;
   }

   public String getPatLangueParle() {
      return this.patLangueParle;
   }

   public void setPatLangueParle(String var1) {
      this.patLangueParle = var1;
   }

   public String getPatLieuNaissance() {
      return this.patLieuNaissance;
   }

   public void setPatLieuNaissance(String var1) {
      this.patLieuNaissance = var1;
   }

   public String getPatLot() {
      return this.patLot;
   }

   public void setPatLot(String var1) {
      this.patLot = var1;
   }

   public String getPatMail1() {
      return this.patMail1;
   }

   public void setPatMail1(String var1) {
      this.patMail1 = var1;
   }

   public String getPatMsn() {
      return this.patMsn;
   }

   public void setPatMsn(String var1) {
      this.patMsn = var1;
   }

   public int getPatNbEnfant() {
      return this.patNbEnfant;
   }

   public void setPatNbEnfant(int var1) {
      this.patNbEnfant = var1;
   }

   public String getPatNom() {
      if (this.patNom != null && !this.patNom.isEmpty()) {
         this.patNom = this.patNom.toUpperCase();
      }

      return this.patNom;
   }

   public void setPatNom(String var1) {
      this.patNom = var1;
   }

   public String getPatNomBanque() {
      return this.patNomBanque;
   }

   public void setPatNomBanque(String var1) {
      this.patNomBanque = var1;
   }

   public int getPatNomFamille() {
      return this.patNomFamille;
   }

   public void setPatNomFamille(int var1) {
      this.patNomFamille = var1;
   }

   public String getPatNomJf() {
      if (this.patNomJf != null && !this.patNomJf.isEmpty()) {
         this.patNomJf = this.patNomJf.toUpperCase();
      }

      return this.patNomJf;
   }

   public void setPatNomJf(String var1) {
      this.patNomJf = var1;
   }

   public String getPatNomMere() {
      return this.patNomMere;
   }

   public void setPatNomMere(String var1) {
      this.patNomMere = var1;
   }

   public String getPatNomPere() {
      return this.patNomPere;
   }

   public void setPatNomPere(String var1) {
      this.patNomPere = var1;
   }

   public String getPatNumBanque() {
      return this.patNumBanque;
   }

   public void setPatNumBanque(String var1) {
      this.patNumBanque = var1;
   }

   public String getPatObservations() {
      return this.patObservations;
   }

   public void setPatObservations(String var1) {
      this.patObservations = var1;
   }

   public String getPatPaysNaissance() {
      return this.patPaysNaissance;
   }

   public void setPatPaysNaissance(String var1) {
      this.patPaysNaissance = var1;
   }

   public String getPatPorte() {
      return this.patPorte;
   }

   public void setPatPorte(String var1) {
      this.patPorte = var1;
   }

   public String getPatPrenom() {
      return this.patPrenom;
   }

   public void setPatPrenom(String var1) {
      this.patPrenom = var1;
   }

   public String getPatProfObs() {
      return this.patProfObs;
   }

   public void setPatProfObs(String var1) {
      this.patProfObs = var1;
   }

   public String getPatProfession() {
      return this.patProfession;
   }

   public void setPatProfession(String var1) {
      this.patProfession = var1;
   }

   public String getPatQuartier() {
      return this.patQuartier;
   }

   public void setPatQuartier(String var1) {
      this.patQuartier = var1;
   }

   public String getPatRue() {
      return this.patRue;
   }

   public void setPatRue(String var1) {
      this.patRue = var1;
   }

   public String getPatSecteurActivite() {
      return this.patSecteurActivite;
   }

   public void setPatSecteurActivite(String var1) {
      this.patSecteurActivite = var1;
   }

   public String getPatSecu() {
      return this.patSecu;
   }

   public void setPatSecu(String var1) {
      this.patSecu = var1;
   }

   public String getPatSerie() {
      return this.patSerie;
   }

   public void setPatSerie(String var1) {
      this.patSerie = var1;
   }

   public int getPatSexe() {
      return this.patSexe;
   }

   public void setPatSexe(int var1) {
      this.patSexe = var1;
   }

   public int getPatSitFam() {
      return this.patSitFam;
   }

   public void setPatSitFam(int var1) {
      this.patSitFam = var1;
   }

   public String getPatSkype() {
      return this.patSkype;
   }

   public void setPatSkype(String var1) {
      this.patSkype = var1;
   }

   public String getPatSurnom() {
      if (this.patSurnom != null && !this.patSurnom.isEmpty()) {
         this.patSurnom = this.patSurnom.toUpperCase();
      }

      return this.patSurnom;
   }

   public void setPatSurnom(String var1) {
      this.patSurnom = var1;
   }

   public String getPatSwift() {
      return this.patSwift;
   }

   public void setPatSwift(String var1) {
      this.patSwift = var1;
   }

   public String getPatTelDom() {
      return this.patTelDom;
   }

   public void setPatTelDom(String var1) {
      this.patTelDom = var1;
   }

   public String getPatTelVoiture() {
      return this.patTelVoiture;
   }

   public void setPatTelVoiture(String var1) {
      this.patTelVoiture = var1;
   }

   public long getPatUserCreat() {
      return this.patUserCreat;
   }

   public void setPatUserCreat(long var1) {
      this.patUserCreat = var1;
   }

   public long getPatUserModif() {
      return this.patUserModif;
   }

   public void setPatUserModif(long var1) {
      this.patUserModif = var1;
   }

   public String getPatVille() {
      return this.patVille;
   }

   public void setPatVille(String var1) {
      this.patVille = var1;
   }

   public String getPatYahoo() {
      return this.patYahoo;
   }

   public void setPatYahoo(String var1) {
      this.patYahoo = var1;
   }

   public String getPatZone() {
      return this.patZone;
   }

   public void setPatZone(String var1) {
      this.patZone = var1;
   }

   public String getPatAssurance() {
      return this.patAssurance;
   }

   public void setPatAssurance(String var1) {
      this.patAssurance = var1;
   }

   public String getPatComplementaire() {
      return this.patComplementaire;
   }

   public void setPatComplementaire(String var1) {
      this.patComplementaire = var1;
   }

   public long getPatIdAssurance() {
      return this.patIdAssurance;
   }

   public void setPatIdAssurance(long var1) {
      this.patIdAssurance = var1;
   }

   public long getPatIdComplementaire() {
      return this.patIdComplementaire;
   }

   public void setPatIdComplementaire(long var1) {
      this.patIdComplementaire = var1;
   }

   public long getPatIdSociete() {
      return this.patIdSociete;
   }

   public void setPatIdSociete(long var1) {
      this.patIdSociete = var1;
   }

   public String getPatSociete() {
      return this.patSociete;
   }

   public void setPatSociete(String var1) {
      this.patSociete = var1;
   }

   public String getPatPays() {
      return this.patPays;
   }

   public void setPatPays(String var1) {
      this.patPays = var1;
   }

   public String getPatPec() {
      return this.patPec;
   }

   public void setPatPec(String var1) {
      this.patPec = var1;
   }

   public String getPatNumContrat() {
      return this.patNumContrat;
   }

   public void setPatNumContrat(String var1) {
      this.patNumContrat = var1;
   }

   public String getPatConditionreg() {
      return this.patConditionreg;
   }

   public void setPatConditionreg(String var1) {
      this.patConditionreg = var1;
   }

   public String getPatModereg() {
      return this.patModereg;
   }

   public void setPatModereg(String var1) {
      this.patModereg = var1;
   }

   public int getPatNbarrondi() {
      return this.patNbarrondi;
   }

   public void setPatNbarrondi(int var1) {
      this.patNbarrondi = var1;
   }

   public int getPatNbecheance() {
      return this.patNbecheance;
   }

   public void setPatNbecheance(int var1) {
      this.patNbecheance = var1;
   }

   public int getPatTypereg() {
      return this.patTypereg;
   }

   public void setPatTypereg(int var1) {
      this.patTypereg = var1;
   }

   public String getPatPhoto() {
      return this.patPhoto;
   }

   public void setPatPhoto(String var1) {
      this.patPhoto = var1;
   }

   public String getPatCnamgs() {
      return this.patCnamgs;
   }

   public void setPatCnamgs(String var1) {
      this.patCnamgs = var1;
   }

   public long getPatIdCouvertPar() {
      return this.patIdCouvertPar;
   }

   public void setPatIdCouvertPar(long var1) {
      this.patIdCouvertPar = var1;
   }

   public String getPatImmatriculation() {
      return this.patImmatriculation;
   }

   public void setPatImmatriculation(String var1) {
      this.patImmatriculation = var1;
   }

   public String getPatQualite() {
      return this.patQualite;
   }

   public void setPatQualite(String var1) {
      this.patQualite = var1;
   }

   public long getPatPecComplementaire() {
      return this.patPecComplementaire;
   }

   public void setPatPecComplementaire(long var1) {
      this.patPecComplementaire = var1;
   }

   public String getPatReligion() {
      return this.patReligion;
   }

   public void setPatReligion(String var1) {
      this.patReligion = var1;
   }

   public Date getPatDateEmbauche() {
      return this.patDateEmbauche;
   }

   public void setPatDateEmbauche(Date var1) {
      this.patDateEmbauche = var1;
   }

   public String getPatPassport() {
      return this.patPassport;
   }

   public void setPatPassport(String var1) {
      this.patPassport = var1;
   }

   public long getPatIdUserPaiement() {
      return this.patIdUserPaiement;
   }

   public void setPatIdUserPaiement(long var1) {
      this.patIdUserPaiement = var1;
   }

   public String getPatSalariePaiement() {
      return this.patSalariePaiement;
   }

   public void setPatSalariePaiement(String var1) {
      this.patSalariePaiement = var1;
   }
}
