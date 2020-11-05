package com.epegase.systeme.classe;

import java.io.Serializable;

public class Groupe implements Serializable {
   private long grpId;
   private String grpCode;
   private String grpLibelle;
   private int grpModuleTie;
   private int grpModuleOff;
   private int grpModuleAch;
   private int grpModuleStk;
   private int grpModuleVte;
   private int grpModuleCpt;
   private int grpModulePrc;
   private int grpModuleCai;
   private int grpModulePay;
   private int grpModuleMed;
   private int grpModuleEdu;
   private int grpModuleMef;
   private int grpModuleFree;
   private int grpModuleGuest;
   private int grpAccesMail;
   private int grpMailCopie;
   private int grpMailParapheur;
   private int grpCaissier;
   private int grpCaissierService;
   private int grpService;
   private int grpRecus;
   private int grpDateCai;
   private int grpImputCai;
   private int grpMontantCai;
   private int grpAchats;
   private int grpCommAchats;
   private int grpAchPump;
   private int grpDateAch;
   private int grpDateStk;
   private int grpVerRemiseAch;
   private int grpVerRabaisAch;
   private int grpVerPaAch;
   private int grpProdServiceAch;
   private int grpDepotSel;
   private int grpAchTrfDa;
   private int grpAchTrfCot;
   private int grpAchTrfCmd;
   private int grpAchTrfRec;
   private int grpAchTrfRet;
   private int grpAchTrfFac;
   private int grpAchTrfFra;
   private int grpAchTrfAvr;
   private int grpAchTrfNdd;
   private int grpVentes;
   private int grpCommVentes;
   private int grpFactureCaisse;
   private int grpAffPump;
   private int grpAffPvMarche;
   private int grpAffPlancher;
   private int grpDateVte;
   private int grpVerRemise;
   private int grpVerRabais;
   private int grpVerPv;
   private int grpProdService;
   private int grpVteTrfBes;
   private int grpVteTrfDev;
   private int grpVteTrfBc;
   private int grpVteTrfBl;
   private int grpVteTrfRet;
   private int grpVteTrfFac;
   private int grpVteTrfAvr;
   private int grpVteTrfNdd;
   private int grpMedicalService;
   private int grpMedical;
   private int grpDateMed;
   private int grpPaye;
   private int grpPayeService;
   private int grpMf;
   private int grpAccesBrouillard;
   private int grpAccesCorrection;
   private int grpJrxReserve;
   private String grpJrxInterdit;
   private int grpModifLiasse;
   private int grpPlanning;
   private String grpPlanningService;
   private int grpAchLibelle;
   private int grpVteLibelle;
   private int grpAcheteur;
   private int grpCaissierDelete;
   private int grpCaissierDepense;
   private int grpCaissierRecette;
   private int grpCaissierModif;
   private int grpCaissierTransfert;
   private float grpCommPourcentage;
   private int grpCommType;
   private String grpCptInterdit;
   private int grpCreationSociete;
   private int grpDateLivre;
   private int grpDatePrc;
   private int grpDemandeurAchats;
   private String grpMail;
   private int grpModifSerieAch;
   private int grpModifSerieVte;
   private int grpParcAlerte;
   private int grpPayPointage;
   private int grpPayeAlerte;
   private int grpPayeBulletin;
   private int grpPayeContrat;
   private double grpPr;
   private int grpRespAchats;
   private int grpSignatureOffice;
   private int grpSignatureCompta;
   private int grpSignaturePaye;
   private int grpSignatureParc;
   private int grpSignatureAchats;
   private int grpSignatureVentes;
   private long grpResponsableVentes;
   private int grpSignatureCaisse;
   private int grpSignatureMedical;
   private int grpSignatureMicroFinance;
   private int grpSignatureEducation;
   private int grpTiers;
   private int grpTiersCai;
   private int grpVendeur;
   private String grpLie;
   private int grpModuleRep;

   public long getGrpId() {
      return this.grpId;
   }

   public void setGrpId(long var1) {
      this.grpId = var1;
   }

   public String getGrpLibelle() {
      return this.grpLibelle;
   }

   public void setGrpLibelle(String var1) {
      this.grpLibelle = var1;
   }

   public String getGrpCode() {
      return this.grpCode;
   }

   public void setGrpCode(String var1) {
      this.grpCode = var1;
   }

   public int getGrpModuleAch() {
      return this.grpModuleAch;
   }

   public void setGrpModuleAch(int var1) {
      this.grpModuleAch = var1;
   }

   public int getGrpModuleCai() {
      return this.grpModuleCai;
   }

   public void setGrpModuleCai(int var1) {
      this.grpModuleCai = var1;
   }

   public int getGrpModuleCpt() {
      return this.grpModuleCpt;
   }

   public void setGrpModuleCpt(int var1) {
      this.grpModuleCpt = var1;
   }

   public int getGrpModuleMed() {
      return this.grpModuleMed;
   }

   public void setGrpModuleMed(int var1) {
      this.grpModuleMed = var1;
   }

   public int getGrpModuleOff() {
      return this.grpModuleOff;
   }

   public void setGrpModuleOff(int var1) {
      this.grpModuleOff = var1;
   }

   public int getGrpModulePay() {
      return this.grpModulePay;
   }

   public void setGrpModulePay(int var1) {
      this.grpModulePay = var1;
   }

   public int getGrpModulePrc() {
      return this.grpModulePrc;
   }

   public void setGrpModulePrc(int var1) {
      this.grpModulePrc = var1;
   }

   public int getGrpModuleStk() {
      return this.grpModuleStk;
   }

   public void setGrpModuleStk(int var1) {
      this.grpModuleStk = var1;
   }

   public int getGrpModuleTie() {
      return this.grpModuleTie;
   }

   public void setGrpModuleTie(int var1) {
      this.grpModuleTie = var1;
   }

   public int getGrpModuleVte() {
      return this.grpModuleVte;
   }

   public void setGrpModuleVte(int var1) {
      this.grpModuleVte = var1;
   }

   public int getGrpModuleFree() {
      return this.grpModuleFree;
   }

   public void setGrpModuleFree(int var1) {
      this.grpModuleFree = var1;
   }

   public int getGrpAccesMail() {
      return this.grpAccesMail;
   }

   public void setGrpAccesMail(int var1) {
      this.grpAccesMail = var1;
   }

   public int getGrpAchPump() {
      return this.grpAchPump;
   }

   public void setGrpAchPump(int var1) {
      this.grpAchPump = var1;
   }

   public int getGrpAchTrfAvr() {
      return this.grpAchTrfAvr;
   }

   public void setGrpAchTrfAvr(int var1) {
      this.grpAchTrfAvr = var1;
   }

   public int getGrpAchTrfCmd() {
      return this.grpAchTrfCmd;
   }

   public void setGrpAchTrfCmd(int var1) {
      this.grpAchTrfCmd = var1;
   }

   public int getGrpAchTrfDa() {
      return this.grpAchTrfDa;
   }

   public void setGrpAchTrfDa(int var1) {
      this.grpAchTrfDa = var1;
   }

   public int getGrpAchTrfFac() {
      return this.grpAchTrfFac;
   }

   public void setGrpAchTrfFac(int var1) {
      this.grpAchTrfFac = var1;
   }

   public int getGrpAchTrfNdd() {
      return this.grpAchTrfNdd;
   }

   public void setGrpAchTrfNdd(int var1) {
      this.grpAchTrfNdd = var1;
   }

   public int getGrpAchTrfRec() {
      return this.grpAchTrfRec;
   }

   public void setGrpAchTrfRec(int var1) {
      this.grpAchTrfRec = var1;
   }

   public int getGrpAchTrfRet() {
      return this.grpAchTrfRet;
   }

   public void setGrpAchTrfRet(int var1) {
      this.grpAchTrfRet = var1;
   }

   public int getGrpAchats() {
      return this.grpAchats;
   }

   public void setGrpAchats(int var1) {
      this.grpAchats = var1;
   }

   public int getGrpAffPlancher() {
      return this.grpAffPlancher;
   }

   public void setGrpAffPlancher(int var1) {
      this.grpAffPlancher = var1;
   }

   public int getGrpAffPump() {
      return this.grpAffPump;
   }

   public void setGrpAffPump(int var1) {
      this.grpAffPump = var1;
   }

   public int getGrpCaissier() {
      return this.grpCaissier;
   }

   public void setGrpCaissier(int var1) {
      this.grpCaissier = var1;
   }

   public int getGrpCaissierService() {
      return this.grpCaissierService;
   }

   public void setGrpCaissierService(int var1) {
      this.grpCaissierService = var1;
   }

   public int getGrpCommAchats() {
      return this.grpCommAchats;
   }

   public void setGrpCommAchats(int var1) {
      this.grpCommAchats = var1;
   }

   public int getGrpCommVentes() {
      return this.grpCommVentes;
   }

   public void setGrpCommVentes(int var1) {
      this.grpCommVentes = var1;
   }

   public int getGrpDateAch() {
      return this.grpDateAch;
   }

   public void setGrpDateAch(int var1) {
      this.grpDateAch = var1;
   }

   public int getGrpDateCai() {
      return this.grpDateCai;
   }

   public void setGrpDateCai(int var1) {
      this.grpDateCai = var1;
   }

   public int getGrpDateMed() {
      return this.grpDateMed;
   }

   public void setGrpDateMed(int var1) {
      this.grpDateMed = var1;
   }

   public int getGrpDateStk() {
      return this.grpDateStk;
   }

   public void setGrpDateStk(int var1) {
      this.grpDateStk = var1;
   }

   public int getGrpDateVte() {
      return this.grpDateVte;
   }

   public void setGrpDateVte(int var1) {
      this.grpDateVte = var1;
   }

   public int getGrpFactureCaisse() {
      return this.grpFactureCaisse;
   }

   public void setGrpFactureCaisse(int var1) {
      this.grpFactureCaisse = var1;
   }

   public int getGrpImputCai() {
      return this.grpImputCai;
   }

   public void setGrpImputCai(int var1) {
      this.grpImputCai = var1;
   }

   public int getGrpMailCopie() {
      return this.grpMailCopie;
   }

   public void setGrpMailCopie(int var1) {
      this.grpMailCopie = var1;
   }

   public int getGrpMailParapheur() {
      return this.grpMailParapheur;
   }

   public void setGrpMailParapheur(int var1) {
      this.grpMailParapheur = var1;
   }

   public int getGrpMedical() {
      return this.grpMedical;
   }

   public void setGrpMedical(int var1) {
      this.grpMedical = var1;
   }

   public int getGrpMedicalService() {
      return this.grpMedicalService;
   }

   public void setGrpMedicalService(int var1) {
      this.grpMedicalService = var1;
   }

   public int getGrpMontantCai() {
      return this.grpMontantCai;
   }

   public void setGrpMontantCai(int var1) {
      this.grpMontantCai = var1;
   }

   public int getGrpPaye() {
      return this.grpPaye;
   }

   public void setGrpPaye(int var1) {
      this.grpPaye = var1;
   }

   public int getGrpPayeService() {
      return this.grpPayeService;
   }

   public void setGrpPayeService(int var1) {
      this.grpPayeService = var1;
   }

   public int getGrpProdService() {
      return this.grpProdService;
   }

   public void setGrpProdService(int var1) {
      this.grpProdService = var1;
   }

   public int getGrpProdServiceAch() {
      return this.grpProdServiceAch;
   }

   public void setGrpProdServiceAch(int var1) {
      this.grpProdServiceAch = var1;
   }

   public int getGrpRecus() {
      return this.grpRecus;
   }

   public void setGrpRecus(int var1) {
      this.grpRecus = var1;
   }

   public int getGrpService() {
      return this.grpService;
   }

   public void setGrpService(int var1) {
      this.grpService = var1;
   }

   public int getGrpVentes() {
      return this.grpVentes;
   }

   public void setGrpVentes(int var1) {
      this.grpVentes = var1;
   }

   public int getGrpVerPaAch() {
      return this.grpVerPaAch;
   }

   public void setGrpVerPaAch(int var1) {
      this.grpVerPaAch = var1;
   }

   public int getGrpVerPv() {
      return this.grpVerPv;
   }

   public void setGrpVerPv(int var1) {
      this.grpVerPv = var1;
   }

   public int getGrpVerRemise() {
      return this.grpVerRemise;
   }

   public void setGrpVerRemise(int var1) {
      this.grpVerRemise = var1;
   }

   public int getGrpVerRemiseAch() {
      return this.grpVerRemiseAch;
   }

   public void setGrpVerRemiseAch(int var1) {
      this.grpVerRemiseAch = var1;
   }

   public int getGrpVteTrfAvr() {
      return this.grpVteTrfAvr;
   }

   public void setGrpVteTrfAvr(int var1) {
      this.grpVteTrfAvr = var1;
   }

   public int getGrpVteTrfBc() {
      return this.grpVteTrfBc;
   }

   public void setGrpVteTrfBc(int var1) {
      this.grpVteTrfBc = var1;
   }

   public int getGrpVteTrfBes() {
      return this.grpVteTrfBes;
   }

   public void setGrpVteTrfBes(int var1) {
      this.grpVteTrfBes = var1;
   }

   public int getGrpVteTrfBl() {
      return this.grpVteTrfBl;
   }

   public void setGrpVteTrfBl(int var1) {
      this.grpVteTrfBl = var1;
   }

   public int getGrpVteTrfDev() {
      return this.grpVteTrfDev;
   }

   public void setGrpVteTrfDev(int var1) {
      this.grpVteTrfDev = var1;
   }

   public int getGrpVteTrfFac() {
      return this.grpVteTrfFac;
   }

   public void setGrpVteTrfFac(int var1) {
      this.grpVteTrfFac = var1;
   }

   public int getGrpVteTrfNdd() {
      return this.grpVteTrfNdd;
   }

   public void setGrpVteTrfNdd(int var1) {
      this.grpVteTrfNdd = var1;
   }

   public int getGrpVteTrfRet() {
      return this.grpVteTrfRet;
   }

   public void setGrpVteTrfRet(int var1) {
      this.grpVteTrfRet = var1;
   }

   public int getGrpAchTrfCot() {
      return this.grpAchTrfCot;
   }

   public void setGrpAchTrfCot(int var1) {
      this.grpAchTrfCot = var1;
   }

   public int getGrpDepotSel() {
      return this.grpDepotSel;
   }

   public void setGrpDepotSel(int var1) {
      this.grpDepotSel = var1;
   }

   public int getGrpAccesBrouillard() {
      return this.grpAccesBrouillard;
   }

   public void setGrpAccesBrouillard(int var1) {
      this.grpAccesBrouillard = var1;
   }

   public int getGrpAccesCorrection() {
      return this.grpAccesCorrection;
   }

   public void setGrpAccesCorrection(int var1) {
      this.grpAccesCorrection = var1;
   }

   public int getGrpAchTrfFra() {
      return this.grpAchTrfFra;
   }

   public void setGrpAchTrfFra(int var1) {
      this.grpAchTrfFra = var1;
   }

   public String getGrpJrxInterdit() {
      return this.grpJrxInterdit;
   }

   public void setGrpJrxInterdit(String var1) {
      this.grpJrxInterdit = var1;
   }

   public int getGrpJrxReserve() {
      return this.grpJrxReserve;
   }

   public void setGrpJrxReserve(int var1) {
      this.grpJrxReserve = var1;
   }

   public int getGrpMf() {
      return this.grpMf;
   }

   public void setGrpMf(int var1) {
      this.grpMf = var1;
   }

   public int getGrpModifLiasse() {
      return this.grpModifLiasse;
   }

   public void setGrpModifLiasse(int var1) {
      this.grpModifLiasse = var1;
   }

   public int getGrpPlanning() {
      return this.grpPlanning;
   }

   public void setGrpPlanning(int var1) {
      this.grpPlanning = var1;
   }

   public String getGrpPlanningService() {
      return this.grpPlanningService;
   }

   public void setGrpPlanningService(String var1) {
      this.grpPlanningService = var1;
   }

   public int getGrpAffPvMarche() {
      return this.grpAffPvMarche;
   }

   public void setGrpAffPvMarche(int var1) {
      this.grpAffPvMarche = var1;
   }

   public int getGrpVerRabaisAch() {
      return this.grpVerRabaisAch;
   }

   public void setGrpVerRabaisAch(int var1) {
      this.grpVerRabaisAch = var1;
   }

   public int getGrpVerRabais() {
      return this.grpVerRabais;
   }

   public void setGrpVerRabais(int var1) {
      this.grpVerRabais = var1;
   }

   public int getGrpModuleEdu() {
      return this.grpModuleEdu;
   }

   public void setGrpModuleEdu(int var1) {
      this.grpModuleEdu = var1;
   }

   public int getGrpModuleGuest() {
      return this.grpModuleGuest;
   }

   public void setGrpModuleGuest(int var1) {
      this.grpModuleGuest = var1;
   }

   public int getGrpAchLibelle() {
      return this.grpAchLibelle;
   }

   public void setGrpAchLibelle(int var1) {
      this.grpAchLibelle = var1;
   }

   public int getGrpAcheteur() {
      return this.grpAcheteur;
   }

   public void setGrpAcheteur(int var1) {
      this.grpAcheteur = var1;
   }

   public int getGrpCaissierDelete() {
      return this.grpCaissierDelete;
   }

   public void setGrpCaissierDelete(int var1) {
      this.grpCaissierDelete = var1;
   }

   public int getGrpCaissierDepense() {
      return this.grpCaissierDepense;
   }

   public void setGrpCaissierDepense(int var1) {
      this.grpCaissierDepense = var1;
   }

   public int getGrpCaissierModif() {
      return this.grpCaissierModif;
   }

   public void setGrpCaissierModif(int var1) {
      this.grpCaissierModif = var1;
   }

   public int getGrpCaissierRecette() {
      return this.grpCaissierRecette;
   }

   public void setGrpCaissierRecette(int var1) {
      this.grpCaissierRecette = var1;
   }

   public int getGrpCaissierTransfert() {
      return this.grpCaissierTransfert;
   }

   public void setGrpCaissierTransfert(int var1) {
      this.grpCaissierTransfert = var1;
   }

   public float getGrpCommPourcentage() {
      return this.grpCommPourcentage;
   }

   public void setGrpCommPourcentage(float var1) {
      this.grpCommPourcentage = var1;
   }

   public int getGrpCommType() {
      return this.grpCommType;
   }

   public void setGrpCommType(int var1) {
      this.grpCommType = var1;
   }

   public String getGrpCptInterdit() {
      return this.grpCptInterdit;
   }

   public void setGrpCptInterdit(String var1) {
      this.grpCptInterdit = var1;
   }

   public int getGrpCreationSociete() {
      return this.grpCreationSociete;
   }

   public void setGrpCreationSociete(int var1) {
      this.grpCreationSociete = var1;
   }

   public int getGrpDateLivre() {
      return this.grpDateLivre;
   }

   public void setGrpDateLivre(int var1) {
      this.grpDateLivre = var1;
   }

   public int getGrpDatePrc() {
      return this.grpDatePrc;
   }

   public void setGrpDatePrc(int var1) {
      this.grpDatePrc = var1;
   }

   public int getGrpDemandeurAchats() {
      return this.grpDemandeurAchats;
   }

   public void setGrpDemandeurAchats(int var1) {
      this.grpDemandeurAchats = var1;
   }

   public String getGrpMail() {
      return this.grpMail;
   }

   public void setGrpMail(String var1) {
      this.grpMail = var1;
   }

   public int getGrpModifSerieAch() {
      return this.grpModifSerieAch;
   }

   public void setGrpModifSerieAch(int var1) {
      this.grpModifSerieAch = var1;
   }

   public int getGrpModifSerieVte() {
      return this.grpModifSerieVte;
   }

   public void setGrpModifSerieVte(int var1) {
      this.grpModifSerieVte = var1;
   }

   public int getGrpPayPointage() {
      return this.grpPayPointage;
   }

   public void setGrpPayPointage(int var1) {
      this.grpPayPointage = var1;
   }

   public int getGrpPayeAlerte() {
      return this.grpPayeAlerte;
   }

   public void setGrpPayeAlerte(int var1) {
      this.grpPayeAlerte = var1;
   }

   public int getGrpPayeBulletin() {
      return this.grpPayeBulletin;
   }

   public void setGrpPayeBulletin(int var1) {
      this.grpPayeBulletin = var1;
   }

   public int getGrpPayeContrat() {
      return this.grpPayeContrat;
   }

   public void setGrpPayeContrat(int var1) {
      this.grpPayeContrat = var1;
   }

   public double getGrpPr() {
      return this.grpPr;
   }

   public void setGrpPr(double var1) {
      this.grpPr = var1;
   }

   public int getGrpRespAchats() {
      return this.grpRespAchats;
   }

   public void setGrpRespAchats(int var1) {
      this.grpRespAchats = var1;
   }

   public long getGrpResponsableVentes() {
      return this.grpResponsableVentes;
   }

   public void setGrpResponsableVentes(long var1) {
      this.grpResponsableVentes = var1;
   }

   public int getGrpSignatureAchats() {
      return this.grpSignatureAchats;
   }

   public void setGrpSignatureAchats(int var1) {
      this.grpSignatureAchats = var1;
   }

   public int getGrpSignatureCaisse() {
      return this.grpSignatureCaisse;
   }

   public void setGrpSignatureCaisse(int var1) {
      this.grpSignatureCaisse = var1;
   }

   public int getGrpSignatureCompta() {
      return this.grpSignatureCompta;
   }

   public void setGrpSignatureCompta(int var1) {
      this.grpSignatureCompta = var1;
   }

   public int getGrpSignatureEducation() {
      return this.grpSignatureEducation;
   }

   public void setGrpSignatureEducation(int var1) {
      this.grpSignatureEducation = var1;
   }

   public int getGrpSignatureMedical() {
      return this.grpSignatureMedical;
   }

   public void setGrpSignatureMedical(int var1) {
      this.grpSignatureMedical = var1;
   }

   public int getGrpSignatureMicroFinance() {
      return this.grpSignatureMicroFinance;
   }

   public void setGrpSignatureMicroFinance(int var1) {
      this.grpSignatureMicroFinance = var1;
   }

   public int getGrpSignatureOffice() {
      return this.grpSignatureOffice;
   }

   public void setGrpSignatureOffice(int var1) {
      this.grpSignatureOffice = var1;
   }

   public int getGrpSignatureParc() {
      return this.grpSignatureParc;
   }

   public void setGrpSignatureParc(int var1) {
      this.grpSignatureParc = var1;
   }

   public int getGrpSignaturePaye() {
      return this.grpSignaturePaye;
   }

   public void setGrpSignaturePaye(int var1) {
      this.grpSignaturePaye = var1;
   }

   public int getGrpSignatureVentes() {
      return this.grpSignatureVentes;
   }

   public void setGrpSignatureVentes(int var1) {
      this.grpSignatureVentes = var1;
   }

   public int getGrpTiers() {
      return this.grpTiers;
   }

   public void setGrpTiers(int var1) {
      this.grpTiers = var1;
   }

   public int getGrpTiersCai() {
      return this.grpTiersCai;
   }

   public void setGrpTiersCai(int var1) {
      this.grpTiersCai = var1;
   }

   public int getGrpVteLibelle() {
      return this.grpVteLibelle;
   }

   public void setGrpVteLibelle(int var1) {
      this.grpVteLibelle = var1;
   }

   public int getGrpParcAlerte() {
      return this.grpParcAlerte;
   }

   public void setGrpParcAlerte(int var1) {
      this.grpParcAlerte = var1;
   }

   public int getGrpVendeur() {
      return this.grpVendeur;
   }

   public void setGrpVendeur(int var1) {
      this.grpVendeur = var1;
   }

   public int getGrpModuleMef() {
      return this.grpModuleMef;
   }

   public void setGrpModuleMef(int var1) {
      this.grpModuleMef = var1;
   }

   public String getGrpLie() {
      return this.grpLie;
   }

   public void setGrpLie(String var1) {
      this.grpLie = var1;
   }

   public int getGrpModuleRep() {
      return this.grpModuleRep;
   }

   public void setGrpModuleRep(int var1) {
      this.grpModuleRep = var1;
   }
}
