package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class DocumentMediatheque implements Serializable {
   private long docmedId;
   private Date docmedDateCreat;
   private Date docmedDateModif;
   private long docmedUserCreat;
   private long docmedUserModif;
   private String docmedNum;
   private String docmedTitre;
   private String docmedAuteur;
   private String docmedEditeur;
   private String docmedDistributeur;
   private String docmedPhoto;
   private String docmedScan;
   private String docmedCode;
   private String docmedClasse;
   private String docmedDivision;
   private String docmedDomaine;
   private String docmedCollection;
   private String docmedGenre;
   private String docmedIssn;
   private String docmedIsbn;
   private String docmedSalle;
   private String docmedCasier;
   private String docmedLangue;
   private String docmedPublic;
   private String docmedOrigine;
   private String docmedPays;
   private String docmedSupport;
   private String docmedType;
   private String docmedContenant;
   private String docmedAnneeParution;
   private String docmedAnneeEdition;
   private String docmedLieuEdition;
   private String docmedAnneePromotion;
   private String docmedAnneeSoutenance;
   private int docmedNbExemplaire;
   private String docmedExemplaire;
   private int docmedNbPage;
   private int docmedNbVolume;
   private String docmedDuree;
   private String docmedInfo1;
   private String docmedInfo2;
   private String docmedInfo3;
   private String docmedInfo4;
   private String docmedResume;
   private String docmedCommentaire;
   private String docmedadresseInternet;
   private String docmedadresseYoutube;
   private String docmedMotsCles;

   public String getDocmedAnneeEdition() {
      return this.docmedAnneeEdition;
   }

   public void setDocmedAnneeEdition(String var1) {
      this.docmedAnneeEdition = var1;
   }

   public String getDocmedAnneeParution() {
      return this.docmedAnneeParution;
   }

   public void setDocmedAnneeParution(String var1) {
      this.docmedAnneeParution = var1;
   }

   public String getDocmedAnneePromotion() {
      return this.docmedAnneePromotion;
   }

   public void setDocmedAnneePromotion(String var1) {
      this.docmedAnneePromotion = var1;
   }

   public String getDocmedAnneeSoutenance() {
      return this.docmedAnneeSoutenance;
   }

   public void setDocmedAnneeSoutenance(String var1) {
      this.docmedAnneeSoutenance = var1;
   }

   public String getDocmedAuteur() {
      return this.docmedAuteur;
   }

   public void setDocmedAuteur(String var1) {
      this.docmedAuteur = var1;
   }

   public String getDocmedCasier() {
      return this.docmedCasier;
   }

   public void setDocmedCasier(String var1) {
      this.docmedCasier = var1;
   }

   public String getDocmedCode() {
      return this.docmedCode;
   }

   public void setDocmedCode(String var1) {
      this.docmedCode = var1;
   }

   public String getDocmedCollection() {
      return this.docmedCollection;
   }

   public void setDocmedCollection(String var1) {
      this.docmedCollection = var1;
   }

   public String getDocmedCommentaire() {
      return this.docmedCommentaire;
   }

   public void setDocmedCommentaire(String var1) {
      this.docmedCommentaire = var1;
   }

   public String getDocmedContenant() {
      return this.docmedContenant;
   }

   public void setDocmedContenant(String var1) {
      this.docmedContenant = var1;
   }

   public Date getDocmedDateCreat() {
      return this.docmedDateCreat;
   }

   public void setDocmedDateCreat(Date var1) {
      this.docmedDateCreat = var1;
   }

   public Date getDocmedDateModif() {
      return this.docmedDateModif;
   }

   public void setDocmedDateModif(Date var1) {
      this.docmedDateModif = var1;
   }

   public String getDocmedDistributeur() {
      return this.docmedDistributeur;
   }

   public void setDocmedDistributeur(String var1) {
      this.docmedDistributeur = var1;
   }

   public String getDocmedDomaine() {
      return this.docmedDomaine;
   }

   public void setDocmedDomaine(String var1) {
      this.docmedDomaine = var1;
   }

   public String getDocmedEditeur() {
      return this.docmedEditeur;
   }

   public void setDocmedEditeur(String var1) {
      this.docmedEditeur = var1;
   }

   public String getDocmedExemplaire() {
      return this.docmedExemplaire;
   }

   public void setDocmedExemplaire(String var1) {
      this.docmedExemplaire = var1;
   }

   public String getDocmedGenre() {
      return this.docmedGenre;
   }

   public void setDocmedGenre(String var1) {
      this.docmedGenre = var1;
   }

   public long getDocmedId() {
      return this.docmedId;
   }

   public void setDocmedId(long var1) {
      this.docmedId = var1;
   }

   public String getDocmedInfo1() {
      return this.docmedInfo1;
   }

   public void setDocmedInfo1(String var1) {
      this.docmedInfo1 = var1;
   }

   public String getDocmedInfo2() {
      return this.docmedInfo2;
   }

   public void setDocmedInfo2(String var1) {
      this.docmedInfo2 = var1;
   }

   public String getDocmedInfo3() {
      return this.docmedInfo3;
   }

   public void setDocmedInfo3(String var1) {
      this.docmedInfo3 = var1;
   }

   public String getDocmedInfo4() {
      return this.docmedInfo4;
   }

   public void setDocmedInfo4(String var1) {
      this.docmedInfo4 = var1;
   }

   public String getDocmedIsbn() {
      return this.docmedIsbn;
   }

   public void setDocmedIsbn(String var1) {
      this.docmedIsbn = var1;
   }

   public String getDocmedIssn() {
      return this.docmedIssn;
   }

   public void setDocmedIssn(String var1) {
      this.docmedIssn = var1;
   }

   public String getDocmedLangue() {
      return this.docmedLangue;
   }

   public void setDocmedLangue(String var1) {
      this.docmedLangue = var1;
   }

   public String getDocmedLieuEdition() {
      return this.docmedLieuEdition;
   }

   public void setDocmedLieuEdition(String var1) {
      this.docmedLieuEdition = var1;
   }

   public int getDocmedNbPage() {
      return this.docmedNbPage;
   }

   public void setDocmedNbPage(int var1) {
      this.docmedNbPage = var1;
   }

   public int getDocmedNbVolume() {
      return this.docmedNbVolume;
   }

   public void setDocmedNbVolume(int var1) {
      this.docmedNbVolume = var1;
   }

   public String getDocmedNum() {
      return this.docmedNum;
   }

   public void setDocmedNum(String var1) {
      this.docmedNum = var1;
   }

   public String getDocmedOrigine() {
      return this.docmedOrigine;
   }

   public void setDocmedOrigine(String var1) {
      this.docmedOrigine = var1;
   }

   public String getDocmedPays() {
      return this.docmedPays;
   }

   public void setDocmedPays(String var1) {
      this.docmedPays = var1;
   }

   public String getDocmedPhoto() {
      return this.docmedPhoto;
   }

   public void setDocmedPhoto(String var1) {
      this.docmedPhoto = var1;
   }

   public String getDocmedPublic() {
      return this.docmedPublic;
   }

   public void setDocmedPublic(String var1) {
      this.docmedPublic = var1;
   }

   public String getDocmedResume() {
      return this.docmedResume;
   }

   public void setDocmedResume(String var1) {
      this.docmedResume = var1;
   }

   public String getDocmedSalle() {
      return this.docmedSalle;
   }

   public void setDocmedSalle(String var1) {
      this.docmedSalle = var1;
   }

   public String getDocmedSupport() {
      return this.docmedSupport;
   }

   public void setDocmedSupport(String var1) {
      this.docmedSupport = var1;
   }

   public String getDocmedClasse() {
      return this.docmedClasse;
   }

   public void setDocmedClasse(String var1) {
      this.docmedClasse = var1;
   }

   public String getDocmedDivision() {
      return this.docmedDivision;
   }

   public void setDocmedDivision(String var1) {
      this.docmedDivision = var1;
   }

   public String getDocmedTitre() {
      return this.docmedTitre;
   }

   public void setDocmedTitre(String var1) {
      this.docmedTitre = var1;
   }

   public String getDocmedType() {
      return this.docmedType;
   }

   public void setDocmedType(String var1) {
      this.docmedType = var1;
   }

   public long getDocmedUserCreat() {
      return this.docmedUserCreat;
   }

   public void setDocmedUserCreat(long var1) {
      this.docmedUserCreat = var1;
   }

   public long getDocmedUserModif() {
      return this.docmedUserModif;
   }

   public void setDocmedUserModif(long var1) {
      this.docmedUserModif = var1;
   }

   public String getDocmedadresseInternet() {
      return this.docmedadresseInternet;
   }

   public void setDocmedadresseInternet(String var1) {
      this.docmedadresseInternet = var1;
   }

   public String getDocmedadresseYoutube() {
      return this.docmedadresseYoutube;
   }

   public void setDocmedadresseYoutube(String var1) {
      this.docmedadresseYoutube = var1;
   }

   public String getDocmedMotsCles() {
      return this.docmedMotsCles;
   }

   public void setDocmedMotsCles(String var1) {
      this.docmedMotsCles = var1;
   }

   public String getDocmedScan() {
      return this.docmedScan;
   }

   public void setDocmedScan(String var1) {
      this.docmedScan = var1;
   }

   public String getDocmedDuree() {
      return this.docmedDuree;
   }

   public void setDocmedDuree(String var1) {
      this.docmedDuree = var1;
   }

   public int getDocmedNbExemplaire() {
      return this.docmedNbExemplaire;
   }

   public void setDocmedNbExemplaire(int var1) {
      this.docmedNbExemplaire = var1;
   }
}
