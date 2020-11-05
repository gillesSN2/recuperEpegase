package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Mails implements Serializable {
   private long maiId;
   private Date maiDateCreation;
   private long maiUserCreation;
   private Date maiDateModif;
   private long maiUserModif;
   private Date maiDateTransfert;
   private String maiNum;
   private int maiType;
   private int maiSens;
   private int maiSensOld;
   private long maiStr;
   private String maiGrp;
   private long maiUsr;
   private String maiNosRef;
   private String maiVosRef;
   private int maiPriorite;
   private String maiModele;
   private String maiObjet;
   private String maiCodeNature;
   private String maiNature;
   private String maiScanCourrier;
   private String maiEmetteur;
   private long maiTiersId;
   private String maiTiersRs;
   private String maiTiersDivers;
   private long maiPatientId;
   private String maiPatientNom;
   private long maiAgentId;
   private String maiAgentNom;
   private long maiSalarieId;
   private String maiSalarieNom;
   private String maiDestinataire;
   private String maiCc;
   private String maiCci;
   private String maiActivite;
   private String maiService;
   private int maiPj;
   private String maiCorps;
   private String MaiStatut;
   private boolean MaiErreur;
   private int MaiTaille;
   private String MaiListeStructure;
   private String MaiListeIdUser;
   private String MaiListeNomUser;
   private String prioriteLib;
   private String pj;
   private String scan;
   private String sens;
   private String type;
   private String color;
   private String nomCreateur;
   private String statut;
   private String nomTiers;
   private String destinataire;
   private String reference;

   public String getReference() {
      if (this.maiVosRef != null && !this.maiVosRef.isEmpty()) {
         this.reference = this.maiVosRef;
      } else if (this.maiNosRef != null && !this.maiNosRef.isEmpty()) {
         this.reference = this.maiNosRef;
      } else {
         this.reference = "";
      }

      return this.reference;
   }

   public void setReference(String var1) {
      this.reference = var1;
   }

   public String getDestinataire() {
      return this.destinataire;
   }

   public void setDestinataire(String var1) {
      this.destinataire = var1;
   }

   public String getNomTiers() {
      if (this.maiTiersId != 0L) {
         if (this.maiTiersDivers != null && !this.maiTiersDivers.isEmpty()) {
            this.nomTiers = this.maiTiersDivers;
         } else {
            this.nomTiers = this.maiTiersRs;
         }
      } else if (this.maiPatientId != 0L) {
         this.nomTiers = this.maiPatientNom;
      } else if (this.maiAgentId != 0L) {
         this.nomTiers = this.maiAgentNom;
      }

      return this.nomTiers;
   }

   public void setNomTiers(String var1) {
      this.nomTiers = var1;
   }

   public String getStatut() {
      if (this.MaiErreur) {
         this.statut = "ERREUR";
      } else {
         this.statut = "";
      }

      return this.statut;
   }

   public void setStatut(String var1) {
      this.statut = var1;
   }

   public String getNomCreateur() {
      return this.nomCreateur;
   }

   public void setNomCreateur(String var1) {
      this.nomCreateur = var1;
   }

   public String getColor() {
      if (this.MaiErreur) {
         this.color = "red";
      } else {
         this.color = "black";
      }

      return this.color;
   }

   public void setColor(String var1) {
      this.color = var1;
   }

   public String getPrioriteLib() {
      if (this.maiPriorite == 0) {
         this.prioriteLib = "Normale";
      } else if (this.maiPriorite == 1) {
         this.prioriteLib = "Importante";
      } else if (this.maiPriorite == 2) {
         this.prioriteLib = "Prioritaire";
      } else if (this.maiPriorite == 3) {
         this.prioriteLib = "Projet";
      } else if (this.maiPriorite == 4) {
         this.prioriteLib = "Réunion";
      }

      return this.prioriteLib;
   }

   public void setPrioriteLib(String var1) {
      this.prioriteLib = var1;
   }

   public String getScan() {
      if (this.maiScanCourrier != null && !this.maiScanCourrier.isEmpty()) {
         this.scan = "/images/mail_pj.png";
      } else {
         this.scan = null;
      }

      return this.scan;
   }

   public void setScan(String var1) {
      this.scan = var1;
   }

   public String getPj() {
      if (this.maiPj == 0) {
         this.pj = null;
      } else if (this.maiPj == 1) {
         this.pj = "/images/mail_pj.png";
      }

      return this.pj;
   }

   public void setPj(String var1) {
      this.pj = var1;
   }

   public String getSens() {
      if (this.maiSens == 0) {
         this.sens = "/images/mail_sortie.png";
      } else if (this.maiSens == 1) {
         this.sens = "/images/mail_entree.png";
      } else if (this.maiSens == 2) {
         this.sens = "/images/mail_brouillons.png";
      } else if (this.maiSens == 3) {
         this.sens = "/images/mail_sortie.png";
      } else if (this.maiSens == 4) {
         this.sens = "/images/mail_entree.png";
      } else if (this.maiSens == 5) {
         this.sens = "/images/mail_poubelles.png";
      } else if (this.maiSens == 6) {
         this.sens = "/images/mail_spam.png";
      } else if (this.maiSens == 125) {
         this.sens = "/images/mail_sortie.png";
      } else if (this.maiSens == 126) {
         this.sens = "/images/mail_entree.png";
      }

      return this.sens;
   }

   public void setSens(String var1) {
      this.sens = var1;
   }

   public String getType() {
      if (this.maiType == 0) {
         this.type = "/images/mail.png";
      } else if (this.maiType == 1) {
         this.type = "/images/fichier_word.png";
      }

      return this.type;
   }

   public void setType(String var1) {
      this.type = var1;
   }

   public long getMaiAgentId() {
      return this.maiAgentId;
   }

   public void setMaiAgentId(long var1) {
      this.maiAgentId = var1;
   }

   public String getMaiAgentNom() {
      return this.maiAgentNom;
   }

   public void setMaiAgentNom(String var1) {
      this.maiAgentNom = var1;
   }

   public String getMaiCc() {
      return this.maiCc;
   }

   public void setMaiCc(String var1) {
      this.maiCc = var1;
   }

   public String getMaiCci() {
      return this.maiCci;
   }

   public void setMaiCci(String var1) {
      this.maiCci = var1;
   }

   public String getMaiCorps() {
      return this.maiCorps;
   }

   public void setMaiCorps(String var1) {
      this.maiCorps = var1;
   }

   public Date getMaiDateCreation() {
      return this.maiDateCreation;
   }

   public void setMaiDateCreation(Date var1) {
      this.maiDateCreation = var1;
   }

   public Date getMaiDateModif() {
      return this.maiDateModif;
   }

   public void setMaiDateModif(Date var1) {
      this.maiDateModif = var1;
   }

   public String getMaiDestinataire() {
      return this.maiDestinataire;
   }

   public void setMaiDestinataire(String var1) {
      this.maiDestinataire = var1;
   }

   public String getMaiEmetteur() {
      return this.maiEmetteur;
   }

   public void setMaiEmetteur(String var1) {
      this.maiEmetteur = var1;
   }

   public long getMaiId() {
      return this.maiId;
   }

   public void setMaiId(long var1) {
      this.maiId = var1;
   }

   public String getMaiModele() {
      return this.maiModele;
   }

   public void setMaiModele(String var1) {
      this.maiModele = var1;
   }

   public String getMaiNosRef() {
      return this.maiNosRef;
   }

   public void setMaiNosRef(String var1) {
      this.maiNosRef = var1;
   }

   public String getMaiNum() {
      return this.maiNum;
   }

   public void setMaiNum(String var1) {
      this.maiNum = var1;
   }

   public String getMaiObjet() {
      return this.maiObjet;
   }

   public void setMaiObjet(String var1) {
      this.maiObjet = var1;
   }

   public long getMaiPatientId() {
      return this.maiPatientId;
   }

   public void setMaiPatientId(long var1) {
      this.maiPatientId = var1;
   }

   public String getMaiPatientNom() {
      if (this.maiPatientNom != null && !this.maiPatientNom.isEmpty()) {
         this.maiPatientNom = this.maiPatientNom.toUpperCase();
      }

      return this.maiPatientNom;
   }

   public void setMaiPatientNom(String var1) {
      this.maiPatientNom = var1;
   }

   public int getMaiPriorite() {
      return this.maiPriorite;
   }

   public void setMaiPriorite(int var1) {
      this.maiPriorite = var1;
   }

   public long getMaiTiersId() {
      return this.maiTiersId;
   }

   public void setMaiTiersId(long var1) {
      this.maiTiersId = var1;
   }

   public String getMaiTiersRs() {
      if (this.maiTiersRs != null && !this.maiTiersRs.isEmpty()) {
         this.maiTiersRs = this.maiTiersRs.toUpperCase();
      }

      return this.maiTiersRs;
   }

   public void setMaiTiersRs(String var1) {
      this.maiTiersRs = var1;
   }

   public int getMaiType() {
      return this.maiType;
   }

   public void setMaiType(int var1) {
      this.maiType = var1;
   }

   public long getMaiUserCreation() {
      return this.maiUserCreation;
   }

   public void setMaiUserCreation(long var1) {
      this.maiUserCreation = var1;
   }

   public long getMaiUserModif() {
      return this.maiUserModif;
   }

   public void setMaiUserModif(long var1) {
      this.maiUserModif = var1;
   }

   public String getMaiVosRef() {
      return this.maiVosRef;
   }

   public void setMaiVosRef(String var1) {
      this.maiVosRef = var1;
   }

   public String getMaiGrp() {
      return this.maiGrp;
   }

   public void setMaiGrp(String var1) {
      this.maiGrp = var1;
   }

   public long getMaiStr() {
      return this.maiStr;
   }

   public void setMaiStr(long var1) {
      this.maiStr = var1;
   }

   public long getMaiUsr() {
      return this.maiUsr;
   }

   public void setMaiUsr(long var1) {
      this.maiUsr = var1;
   }

   public int getMaiSens() {
      return this.maiSens;
   }

   public void setMaiSens(int var1) {
      this.maiSens = var1;
   }

   public int getMaiPj() {
      return this.maiPj;
   }

   public void setMaiPj(int var1) {
      this.maiPj = var1;
   }

   public String getMaiActivite() {
      return this.maiActivite;
   }

   public void setMaiActivite(String var1) {
      this.maiActivite = var1;
   }

   public String getMaiService() {
      return this.maiService;
   }

   public void setMaiService(String var1) {
      this.maiService = var1;
   }

   public int getMaiSensOld() {
      return this.maiSensOld;
   }

   public void setMaiSensOld(int var1) {
      this.maiSensOld = var1;
   }

   public int getMaiTaille() {
      return this.MaiTaille;
   }

   public void setMaiTaille(int var1) {
      this.MaiTaille = var1;
   }

   public String getMaiStatut() {
      return this.MaiStatut;
   }

   public void setMaiStatut(String var1) {
      this.MaiStatut = var1;
   }

   public boolean isMaiErreur() {
      return this.MaiErreur;
   }

   public void setMaiErreur(boolean var1) {
      this.MaiErreur = var1;
   }

   public String getMaiNature() {
      return this.maiNature;
   }

   public void setMaiNature(String var1) {
      this.maiNature = var1;
   }

   public String getMaiScanCourrier() {
      return this.maiScanCourrier;
   }

   public void setMaiScanCourrier(String var1) {
      this.maiScanCourrier = var1;
   }

   public String getMaiListeStructure() {
      return this.MaiListeStructure;
   }

   public void setMaiListeStructure(String var1) {
      this.MaiListeStructure = var1;
   }

   public String getMaiTiersDivers() {
      return this.maiTiersDivers;
   }

   public void setMaiTiersDivers(String var1) {
      this.maiTiersDivers = var1;
   }

   public String getMaiListeIdUser() {
      return this.MaiListeIdUser;
   }

   public void setMaiListeIdUser(String var1) {
      this.MaiListeIdUser = var1;
   }

   public String getMaiListeNomUser() {
      return this.MaiListeNomUser;
   }

   public void setMaiListeNomUser(String var1) {
      this.MaiListeNomUser = var1;
   }

   public long getMaiSalarieId() {
      return this.maiSalarieId;
   }

   public void setMaiSalarieId(long var1) {
      this.maiSalarieId = var1;
   }

   public String getMaiSalarieNom() {
      return this.maiSalarieNom;
   }

   public void setMaiSalarieNom(String var1) {
      this.maiSalarieNom = var1;
   }

   public String getMaiCodeNature() {
      return this.maiCodeNature;
   }

   public void setMaiCodeNature(String var1) {
      this.maiCodeNature = var1;
   }

   public Date getMaiDateTransfert() {
      return this.maiDateTransfert;
   }

   public void setMaiDateTransfert(Date var1) {
      this.maiDateTransfert = var1;
   }
}
