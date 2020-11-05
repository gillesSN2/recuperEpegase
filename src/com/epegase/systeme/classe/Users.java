package com.epegase.systeme.classe;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Date;
import javax.swing.ImageIcon;

public class Users implements Serializable {
   private long usrid;
   private Date usrDateCreat;
   private Date usrDateModif;
   private long usrUserCreat;
   private long usrUserModif;
   private int usrEtat;
   private String usrCivilite;
   private String usrNom;
   private String usrPrenom;
   private String usrInitiale;
   private String usrPatronyme;
   private String usrCompte;
   private String usrLogin;
   private String usrPw;
   private String usrPwEspaceClient;
   private int usrChange;
   private String usrCodeSecret;
   private int usrConnexion;
   private int usrSysteme;
   private Date usrDateNaissance;
   private String usrAnniversaire;
   private String usrLangue;
   private String usrTemplates;
   private String usrThemes;
   private String usrCollaboration;
   private String usrFonction;
   private String usrMetier;
   private String usrAdresse;
   private String usrBp;
   private String usrVille;
   private String usrNomPays;
   private String usrTelBureau;
   private String usrTelDomicile;
   private String usrCel1;
   private String usrCel2;
   private String usrCel3;
   private int usrAccesMail;
   private int usrMailParapheur;
   private String usrMail;
   private String usrYahoo;
   private String usrMsn;
   private String usrAol;
   private String usrSkype;
   private Date usrLastLog;
   private Date usrFirstLog;
   private double usrNblog;
   private String usrPhoto;
   private String usrSignature;
   private int usrDepotSel;
   private String usrSite;
   private String usrSiteSecondaire;
   private String usrDepartement;
   private String usrDepartementSecondaire;
   private String usrService;
   private String usrServiceSecondaire;
   private String usrStartup;
   private double usrPr;
   private double usrPv;
   private int usrRespCaissier;
   private int usrCaissier;
   private int usrCaissierDepense;
   private int usrCaissierRecette;
   private int usrCaissierModif;
   private int usrCaissierAnnule;
   private int usrCaissierDelete;
   private int usrCaissierTransfert;
   private int usrCaissierService;
   private int usrRecus;
   private int usrRecusJour;
   private int usrPayeAlerte;
   private int usrPaye;
   private int usrPayeService;
   private int usrPayeBulletin;
   private int usrPayeContrat;
   private int usrPayeCaisse;
   private int usrTiers;
   private int usrPlanning;
   private int usrMailCopie;
   private String usrPlanningService;
   private int usrAchats;
   private int usrRespAchats;
   private int usrDemandeurAchats;
   private int usrFactureDeCaisse;
   private int usrVentes;
   private int usrFactureCaisse;
   private int usrCommVentes;
   private int usrCommAchats;
   private int usrMf;
   private int usrMedical;
   private int usrMedicalAlerte;
   private int usrMedicalAvoir;
   private String usrJrxInterdit;
   private String usrCptInterdit;
   private int usrAccesBrouillard;
   private int usrAccesCorrection;
   private int usrJrxReserve;
   private int usrAchTrfDa;
   private int usrAchTrfCot;
   private int usrAchTrfCmd;
   private int usrAchTrfRec;
   private int usrAchTrfRet;
   private int usrAchTrfFac;
   private int usrAchTrfAvr;
   private int usrAchTrfNdd;
   private int usrAchTrfFra;
   private int usrAchLibelle;
   private int usrVteLibelle;
   private int usrVteTotaux;
   private int usrAchPump;
   private int usrVteTrfBes;
   private int usrVteTrfDev;
   private int usrVteTrfBc;
   private int usrVteTrfBl;
   private int usrVteTrfFac;
   private int usrVteTrfRet;
   private int usrVteTrfAvr;
   private int usrVteTrfNdd;
   private int usrAffPump;
   private int usrAffPvMarche;
   private int usrAffPlancher;
   private int usrVerRemise;
   private int usrVerRabais;
   private int usrVerPv;
   private int usrProdService;
   private int usrVerRemiseAch;
   private int usrVerRabaisAch;
   private int usrVerPaAch;
   private int usrProdServiceAch;
   private Date usrDateDebutIndisponibilite;
   private Date usrDateFinIndisponibilite;
   private int usrDateAch;
   private int usrDateStk;
   private int usrDateVte;
   private int usrDatePrc;
   private int usrDateLivre;
   private int usrDateCai;
   private int usrDateMed;
   private int usrImputCai;
   private int usrTiersCai;
   private int usrMontantCai;
   private int usrLibelleCai;
   private int usrModifLiasse;
   private int usrSignatureOffice;
   private int usrSignatureCompta;
   private int usrSignaturePaye;
   private int usrSignatureParc;
   private int usrSignatureAchats;
   private int usrSignatureVentes;
   private long usrResponsableVentes;
   private int usrSignatureCaisse;
   private int usrSignatureMedical;
   private int usrSignatureMicroFinance;
   private int usrSignatureEducation;
   private int usrVendeur;
   private int usrAcheteur;
   private long usrIdEquipe;
   private String usrNomEquipe;
   private String usrFeuilleInterdite;
   private float usrCommPourcentage;
   private int usrCommType;
   private int usrLissage;
   private int usrChgDosAchat;
   private int usrCabinet;
   private int usrCreationSociete;
   private int usrPayPointage;
   private long usrIdTiersGuest;
   private String usrNomTiersGuest;
   private long usrIdSalarieGuest;
   private String usrNomSalarieGuest;
   private int usrModifSerieVte;
   private int usrModifSerieAch;
   private int usrParcAlerte;
   private int usrBaseCopie;
   private int usrSansHabilitation;
   private String usrNomBaseCopie;
   private String usrSpecialite;
   private int usrVteCtrAlerte;
   private boolean usrCptStructure;
   private boolean usrCptChantier;
   private boolean usrCptMission;
   private boolean usrCptSite;
   private boolean usrCptRegion;
   private boolean usrCptUsine;
   private boolean usrCptActivite;
   private boolean usrCptParc;
   private boolean usrCptDossier;
   private boolean usrCptAgent;
   private boolean usrCptCles;
   private boolean usrCptProjet;
   private boolean usrMyLifeChat;
   private int usrConfigListe;
   private int usrAssistant;
   private String usrImei;
   private String usrPermandroid;
   private String usrNumStat;
   private int usrExtraitAnal;
   private Groupe groupe;
   private BufferedImage image;
   private ImageIcon img;
   private Object labelphoto;
   private boolean selectUser;
   private String var_fonction;
   private String var_options;
   private String genreAssistant;
   private String resetQrCode;
   private String accesDirect;
   private String color;
   private String objectifAnnee;
   private double objectifDevis;
   private double objectifBc;
   private double objectifBl;
   private double objectifBr;
   private double objectifFacture;
   private double objectifNdb;
   private double objectifAvoir;
   private double objectifRdv;

   public String getColor() {
      if (this.usrCabinet == 1) {
         this.color = "color:blue";
      } else {
         this.color = "color:black";
      }

      return this.color;
   }

   public void setColor(String var1) {
      this.color = var1;
   }

   public String getAccesDirect() {
      return this.accesDirect;
   }

   public void setAccesDirect(String var1) {
      this.accesDirect = var1;
   }

   public String getResetQrCode() {
      return this.resetQrCode;
   }

   public void setResetQrCode(String var1) {
      this.resetQrCode = var1;
   }

   public String getGenreAssistant() {
      if (this.usrAssistant == 2) {
         this.genreAssistant = "French Male";
      } else {
         this.genreAssistant = "French Female";
      }

      return this.genreAssistant;
   }

   public void setGenreAssistant(String var1) {
      this.genreAssistant = var1;
   }

   public String getVar_options() {
      if (this.usrMetier != null && !this.usrMetier.isEmpty()) {
         this.var_options = this.usrMetier;
      } else {
         if (this.usrVendeur != 0) {
            this.var_options = "Commercial ";
         }

         if (this.usrCaissier != 0) {
            this.var_options = "Caissier ";
         }
      }

      return this.var_options;
   }

   public void setVar_options(String var1) {
      this.var_options = var1;
   }

   public String getVar_fonction() {
      if (this.usrFonction != null && !this.usrFonction.isEmpty()) {
         if (this.usrFonction.equals("Sélectionnez une fonction")) {
            this.var_fonction = "";
         } else {
            this.var_fonction = this.usrFonction;
         }
      } else {
         this.var_fonction = "";
      }

      return this.var_fonction;
   }

   public void setVar_fonction(String var1) {
      this.var_fonction = var1;
   }

   public Groupe getGroupe() {
      return this.groupe;
   }

   public void setGroupe(Groupe var1) {
      this.groupe = var1;
   }

   public int getUsrAchats() {
      return this.usrAchats;
   }

   public void setUsrAchats(int var1) {
      this.usrAchats = var1;
   }

   public String getUsrAdresse() {
      return this.usrAdresse;
   }

   public void setUsrAdresse(String var1) {
      this.usrAdresse = var1;
   }

   public String getUsrAnniversaire() {
      return this.usrAnniversaire;
   }

   public void setUsrAnniversaire(String var1) {
      this.usrAnniversaire = var1;
   }

   public String getUsrBp() {
      return this.usrBp;
   }

   public void setUsrBp(String var1) {
      this.usrBp = var1;
   }

   public int getUsrCaissier() {
      return this.usrCaissier;
   }

   public void setUsrCaissier(int var1) {
      this.usrCaissier = var1;
   }

   public String getUsrCel1() {
      return this.usrCel1;
   }

   public void setUsrCel1(String var1) {
      this.usrCel1 = var1;
   }

   public String getUsrCel2() {
      return this.usrCel2;
   }

   public void setUsrCel2(String var1) {
      this.usrCel2 = var1;
   }

   public String getUsrCel3() {
      return this.usrCel3;
   }

   public void setUsrCel3(String var1) {
      this.usrCel3 = var1;
   }

   public int getUsrChange() {
      return this.usrChange;
   }

   public void setUsrChange(int var1) {
      this.usrChange = var1;
   }

   public String getUsrCodeSecret() {
      return this.usrCodeSecret;
   }

   public void setUsrCodeSecret(String var1) {
      this.usrCodeSecret = var1;
   }

   public String getUsrCollaboration() {
      return this.usrCollaboration;
   }

   public void setUsrCollaboration(String var1) {
      this.usrCollaboration = var1;
   }

   public int getUsrConnexion() {
      return this.usrConnexion;
   }

   public void setUsrConnexion(int var1) {
      this.usrConnexion = var1;
   }

   public Date getUsrDateCreat() {
      return this.usrDateCreat;
   }

   public void setUsrDateCreat(Date var1) {
      this.usrDateCreat = var1;
   }

   public Date getUsrDateModif() {
      return this.usrDateModif;
   }

   public void setUsrDateModif(Date var1) {
      this.usrDateModif = var1;
   }

   public Date getUsrDateNaissance() {
      return this.usrDateNaissance;
   }

   public void setUsrDateNaissance(Date var1) {
      this.usrDateNaissance = var1;
   }

   public String getUsrDepartement() {
      return this.usrDepartement;
   }

   public void setUsrDepartement(String var1) {
      this.usrDepartement = var1;
   }

   public int getUsrDepotSel() {
      return this.usrDepotSel;
   }

   public void setUsrDepotSel(int var1) {
      this.usrDepotSel = var1;
   }

   public int getUsrEtat() {
      return this.usrEtat;
   }

   public void setUsrEtat(int var1) {
      this.usrEtat = var1;
   }

   public Date getUsrFirstLog() {
      return this.usrFirstLog;
   }

   public void setUsrFirstLog(Date var1) {
      this.usrFirstLog = var1;
   }

   public String getUsrFonction() {
      return this.usrFonction;
   }

   public void setUsrFonction(String var1) {
      this.usrFonction = var1;
   }

   public String getUsrLangue() {
      return this.usrLangue;
   }

   public void setUsrLangue(String var1) {
      this.usrLangue = var1;
   }

   public Date getUsrLastLog() {
      return this.usrLastLog;
   }

   public void setUsrLastLog(Date var1) {
      this.usrLastLog = var1;
   }

   public String getUsrMail() {
      return this.usrMail;
   }

   public void setUsrMail(String var1) {
      this.usrMail = var1;
   }

   public int getUsrMedical() {
      return this.usrMedical;
   }

   public void setUsrMedical(int var1) {
      this.usrMedical = var1;
   }

   public int getUsrMf() {
      return this.usrMf;
   }

   public void setUsrMf(int var1) {
      this.usrMf = var1;
   }

   public String getUsrMsn() {
      return this.usrMsn;
   }

   public void setUsrMsn(String var1) {
      this.usrMsn = var1;
   }

   public String getUsrNom() {
      if (this.usrNom != null && !this.usrNom.isEmpty()) {
         this.usrNom = this.usrNom.toUpperCase();
      }

      return this.usrNom;
   }

   public void setUsrNom(String var1) {
      this.usrNom = var1;
   }

   public String getUsrNomPays() {
      return this.usrNomPays;
   }

   public void setUsrNomPays(String var1) {
      this.usrNomPays = var1;
   }

   public String getUsrPhoto() {
      return this.usrPhoto;
   }

   public void setUsrPhoto(String var1) {
      this.usrPhoto = var1;
   }

   public double getUsrPr() {
      return this.usrPr;
   }

   public void setUsrPr(double var1) {
      this.usrPr = var1;
   }

   public String getUsrPrenom() {
      return this.usrPrenom;
   }

   public void setUsrPrenom(String var1) {
      this.usrPrenom = var1;
   }

   public double getUsrPv() {
      return this.usrPv;
   }

   public void setUsrPv(double var1) {
      this.usrPv = var1;
   }

   public String getUsrPw() {
      return this.usrPw;
   }

   public void setUsrPw(String var1) {
      this.usrPw = var1;
   }

   public String getUsrService() {
      return this.usrService;
   }

   public void setUsrService(String var1) {
      this.usrService = var1;
   }

   public String getUsrSignature() {
      return this.usrSignature;
   }

   public void setUsrSignature(String var1) {
      this.usrSignature = var1;
   }

   public String getUsrSite() {
      return this.usrSite;
   }

   public void setUsrSite(String var1) {
      this.usrSite = var1;
   }

   public String getUsrSkype() {
      return this.usrSkype;
   }

   public void setUsrSkype(String var1) {
      this.usrSkype = var1;
   }

   public String getUsrStartup() {
      return this.usrStartup;
   }

   public void setUsrStartup(String var1) {
      this.usrStartup = var1;
   }

   public int getUsrSysteme() {
      return this.usrSysteme;
   }

   public void setUsrSysteme(int var1) {
      this.usrSysteme = var1;
   }

   public String getUsrTelBureau() {
      return this.usrTelBureau;
   }

   public void setUsrTelBureau(String var1) {
      this.usrTelBureau = var1;
   }

   public String getUsrTelDomicile() {
      return this.usrTelDomicile;
   }

   public void setUsrTelDomicile(String var1) {
      this.usrTelDomicile = var1;
   }

   public String getUsrTemplates() {
      return this.usrTemplates;
   }

   public void setUsrTemplates(String var1) {
      this.usrTemplates = var1;
   }

   public String getUsrThemes() {
      return this.usrThemes;
   }

   public void setUsrThemes(String var1) {
      this.usrThemes = var1;
   }

   public int getUsrTiers() {
      return this.usrTiers;
   }

   public void setUsrTiers(int var1) {
      this.usrTiers = var1;
   }

   public long getUsrUserCreat() {
      return this.usrUserCreat;
   }

   public void setUsrUserCreat(long var1) {
      this.usrUserCreat = var1;
   }

   public long getUsrUserModif() {
      return this.usrUserModif;
   }

   public void setUsrUserModif(long var1) {
      this.usrUserModif = var1;
   }

   public int getUsrVentes() {
      return this.usrVentes;
   }

   public void setUsrVentes(int var1) {
      this.usrVentes = var1;
   }

   public String getUsrVille() {
      return this.usrVille;
   }

   public void setUsrVille(String var1) {
      this.usrVille = var1;
   }

   public String getUsrYahoo() {
      return this.usrYahoo;
   }

   public void setUsrYahoo(String var1) {
      this.usrYahoo = var1;
   }

   public long getUsrid() {
      return this.usrid;
   }

   public void setUsrid(long var1) {
      this.usrid = var1;
   }

   public String getUsrCivilite() {
      return this.usrCivilite;
   }

   public void setUsrCivilite(String var1) {
      this.usrCivilite = var1;
   }

   public String getUsrAol() {
      return this.usrAol;
   }

   public void setUsrAol(String var1) {
      this.usrAol = var1;
   }

   public int getUsrPlanning() {
      return this.usrPlanning;
   }

   public void setUsrPlanning(int var1) {
      this.usrPlanning = var1;
   }

   public String getUsrPlanningService() {
      return this.usrPlanningService;
   }

   public void setUsrPlanningService(String var1) {
      this.usrPlanningService = var1;
   }

   public String getUsrCptInterdit() {
      return this.usrCptInterdit;
   }

   public void setUsrCptInterdit(String var1) {
      this.usrCptInterdit = var1;
   }

   public String getUsrJrxInterdit() {
      return this.usrJrxInterdit;
   }

   public void setUsrJrxInterdit(String var1) {
      this.usrJrxInterdit = var1;
   }

   public int getUsrJrxReserve() {
      return this.usrJrxReserve;
   }

   public void setUsrJrxReserve(int var1) {
      this.usrJrxReserve = var1;
   }

   public int getUsrAffPump() {
      return this.usrAffPump;
   }

   public void setUsrAffPump(int var1) {
      this.usrAffPump = var1;
   }

   public int getUsrVerPv() {
      return this.usrVerPv;
   }

   public void setUsrVerPv(int var1) {
      this.usrVerPv = var1;
   }

   public int getUsrVerRemise() {
      return this.usrVerRemise;
   }

   public void setUsrVerRemise(int var1) {
      this.usrVerRemise = var1;
   }

   public String getUsrLogin() {
      return this.usrLogin;
   }

   public void setUsrLogin(String var1) {
      this.usrLogin = var1;
   }

   public int getUsrAchTrfAvr() {
      return this.usrAchTrfAvr;
   }

   public void setUsrAchTrfAvr(int var1) {
      this.usrAchTrfAvr = var1;
   }

   public int getUsrAchTrfCmd() {
      return this.usrAchTrfCmd;
   }

   public void setUsrAchTrfCmd(int var1) {
      this.usrAchTrfCmd = var1;
   }

   public int getUsrAchTrfCot() {
      return this.usrAchTrfCot;
   }

   public void setUsrAchTrfCot(int var1) {
      this.usrAchTrfCot = var1;
   }

   public int getUsrAchTrfDa() {
      return this.usrAchTrfDa;
   }

   public void setUsrAchTrfDa(int var1) {
      this.usrAchTrfDa = var1;
   }

   public int getUsrAchTrfFac() {
      return this.usrAchTrfFac;
   }

   public void setUsrAchTrfFac(int var1) {
      this.usrAchTrfFac = var1;
   }

   public int getUsrAchTrfNdd() {
      return this.usrAchTrfNdd;
   }

   public void setUsrAchTrfNdd(int var1) {
      this.usrAchTrfNdd = var1;
   }

   public int getUsrAchTrfRec() {
      return this.usrAchTrfRec;
   }

   public void setUsrAchTrfRec(int var1) {
      this.usrAchTrfRec = var1;
   }

   public int getUsrAchTrfRet() {
      return this.usrAchTrfRet;
   }

   public void setUsrAchTrfRet(int var1) {
      this.usrAchTrfRet = var1;
   }

   public int getUsrVteTrfAvr() {
      return this.usrVteTrfAvr;
   }

   public void setUsrVteTrfAvr(int var1) {
      this.usrVteTrfAvr = var1;
   }

   public int getUsrVteTrfBc() {
      return this.usrVteTrfBc;
   }

   public void setUsrVteTrfBc(int var1) {
      this.usrVteTrfBc = var1;
   }

   public int getUsrVteTrfBes() {
      return this.usrVteTrfBes;
   }

   public void setUsrVteTrfBes(int var1) {
      this.usrVteTrfBes = var1;
   }

   public int getUsrVteTrfBl() {
      return this.usrVteTrfBl;
   }

   public void setUsrVteTrfBl(int var1) {
      this.usrVteTrfBl = var1;
   }

   public int getUsrVteTrfDev() {
      return this.usrVteTrfDev;
   }

   public void setUsrVteTrfDev(int var1) {
      this.usrVteTrfDev = var1;
   }

   public int getUsrVteTrfFac() {
      return this.usrVteTrfFac;
   }

   public void setUsrVteTrfFac(int var1) {
      this.usrVteTrfFac = var1;
   }

   public int getUsrVteTrfNdd() {
      return this.usrVteTrfNdd;
   }

   public void setUsrVteTrfNdd(int var1) {
      this.usrVteTrfNdd = var1;
   }

   public int getUsrVteTrfRet() {
      return this.usrVteTrfRet;
   }

   public void setUsrVteTrfRet(int var1) {
      this.usrVteTrfRet = var1;
   }

   public BufferedImage getImage() {
      return this.image;
   }

   public void setImage(BufferedImage var1) {
      this.image = var1;
   }

   public ImageIcon getImg() {
      return this.img;
   }

   public void setImg(ImageIcon var1) {
      this.img = var1;
   }

   public Object getLabelphoto() {
      return this.labelphoto;
   }

   public void setLabelphoto(Object var1) {
      this.labelphoto = var1;
   }

   public int getUsrAccesMail() {
      return this.usrAccesMail;
   }

   public void setUsrAccesMail(int var1) {
      this.usrAccesMail = var1;
   }

   public String getUsrPatronyme() {
      return this.usrPatronyme;
   }

   public void setUsrPatronyme(String var1) {
      this.usrPatronyme = var1;
   }

   public int getUsrProdService() {
      return this.usrProdService;
   }

   public void setUsrProdService(int var1) {
      this.usrProdService = var1;
   }

   public int getUsrProdServiceAch() {
      return this.usrProdServiceAch;
   }

   public void setUsrProdServiceAch(int var1) {
      this.usrProdServiceAch = var1;
   }

   public int getUsrVerPaAch() {
      return this.usrVerPaAch;
   }

   public void setUsrVerPaAch(int var1) {
      this.usrVerPaAch = var1;
   }

   public int getUsrVerRemiseAch() {
      return this.usrVerRemiseAch;
   }

   public void setUsrVerRemiseAch(int var1) {
      this.usrVerRemiseAch = var1;
   }

   public int getUsrAchTrfFra() {
      return this.usrAchTrfFra;
   }

   public void setUsrAchTrfFra(int var1) {
      this.usrAchTrfFra = var1;
   }

   public int getUsrCaissierService() {
      return this.usrCaissierService;
   }

   public void setUsrCaissierService(int var1) {
      this.usrCaissierService = var1;
   }

   public int getUsrCommVentes() {
      return this.usrCommVentes;
   }

   public void setUsrCommVentes(int var1) {
      this.usrCommVentes = var1;
   }

   public int getUsrRespAchats() {
      return this.usrRespAchats;
   }

   public void setUsrRespAchats(int var1) {
      this.usrRespAchats = var1;
   }

   public int getUsrMailCopie() {
      return this.usrMailCopie;
   }

   public void setUsrMailCopie(int var1) {
      this.usrMailCopie = var1;
   }

   public Date getUsrDateDebutIndisponibilite() {
      return this.usrDateDebutIndisponibilite;
   }

   public void setUsrDateDebutIndisponibilite(Date var1) {
      this.usrDateDebutIndisponibilite = var1;
   }

   public Date getUsrDateFinIndisponibilite() {
      return this.usrDateFinIndisponibilite;
   }

   public void setUsrDateFinIndisponibilite(Date var1) {
      this.usrDateFinIndisponibilite = var1;
   }

   public double getUsrNblog() {
      return this.usrNblog;
   }

   public void setUsrNblog(double var1) {
      this.usrNblog = var1;
   }

   public int getUsrAccesBrouillard() {
      return this.usrAccesBrouillard;
   }

   public void setUsrAccesBrouillard(int var1) {
      this.usrAccesBrouillard = var1;
   }

   public int getUsrPaye() {
      return this.usrPaye;
   }

   public void setUsrPaye(int var1) {
      this.usrPaye = var1;
   }

   public int getUsrPayeService() {
      return this.usrPayeService;
   }

   public void setUsrPayeService(int var1) {
      this.usrPayeService = var1;
   }

   public int getUsrCommAchats() {
      return this.usrCommAchats;
   }

   public void setUsrCommAchats(int var1) {
      this.usrCommAchats = var1;
   }

   public int getUsrAchPump() {
      return this.usrAchPump;
   }

   public void setUsrAchPump(int var1) {
      this.usrAchPump = var1;
   }

   public int getUsrAccesCorrection() {
      return this.usrAccesCorrection;
   }

   public void setUsrAccesCorrection(int var1) {
      this.usrAccesCorrection = var1;
   }

   public int getUsrFactureCaisse() {
      return this.usrFactureCaisse;
   }

   public void setUsrFactureCaisse(int var1) {
      this.usrFactureCaisse = var1;
   }

   public int getUsrDateAch() {
      return this.usrDateAch;
   }

   public void setUsrDateAch(int var1) {
      this.usrDateAch = var1;
   }

   public int getUsrDateCai() {
      return this.usrDateCai;
   }

   public void setUsrDateCai(int var1) {
      this.usrDateCai = var1;
   }

   public int getUsrDateMed() {
      return this.usrDateMed;
   }

   public void setUsrDateMed(int var1) {
      this.usrDateMed = var1;
   }

   public int getUsrDateStk() {
      return this.usrDateStk;
   }

   public void setUsrDateStk(int var1) {
      this.usrDateStk = var1;
   }

   public int getUsrDateVte() {
      return this.usrDateVte;
   }

   public void setUsrDateVte(int var1) {
      this.usrDateVte = var1;
   }

   public int getUsrImputCai() {
      return this.usrImputCai;
   }

   public void setUsrImputCai(int var1) {
      this.usrImputCai = var1;
   }

   public int getUsrMontantCai() {
      return this.usrMontantCai;
   }

   public void setUsrMontantCai(int var1) {
      this.usrMontantCai = var1;
   }

   public int getUsrModifLiasse() {
      return this.usrModifLiasse;
   }

   public void setUsrModifLiasse(int var1) {
      this.usrModifLiasse = var1;
   }

   public int getUsrAffPlancher() {
      return this.usrAffPlancher;
   }

   public void setUsrAffPlancher(int var1) {
      this.usrAffPlancher = var1;
   }

   public int getUsrMailParapheur() {
      return this.usrMailParapheur;
   }

   public void setUsrMailParapheur(int var1) {
      this.usrMailParapheur = var1;
   }

   public int getUsrAffPvMarche() {
      return this.usrAffPvMarche;
   }

   public void setUsrAffPvMarche(int var1) {
      this.usrAffPvMarche = var1;
   }

   public boolean isSelectUser() {
      return this.selectUser;
   }

   public void setSelectUser(boolean var1) {
      this.selectUser = var1;
   }

   public int getUsrVerRabais() {
      return this.usrVerRabais;
   }

   public void setUsrVerRabais(int var1) {
      this.usrVerRabais = var1;
   }

   public int getUsrRecus() {
      return this.usrRecus;
   }

   public void setUsrRecus(int var1) {
      this.usrRecus = var1;
   }

   public int getUsrVerRabaisAch() {
      return this.usrVerRabaisAch;
   }

   public void setUsrVerRabaisAch(int var1) {
      this.usrVerRabaisAch = var1;
   }

   public int getUsrSignatureAchats() {
      return this.usrSignatureAchats;
   }

   public void setUsrSignatureAchats(int var1) {
      this.usrSignatureAchats = var1;
   }

   public int getUsrSignatureCaisse() {
      return this.usrSignatureCaisse;
   }

   public void setUsrSignatureCaisse(int var1) {
      this.usrSignatureCaisse = var1;
   }

   public int getUsrSignatureCompta() {
      return this.usrSignatureCompta;
   }

   public void setUsrSignatureCompta(int var1) {
      this.usrSignatureCompta = var1;
   }

   public int getUsrSignatureEducation() {
      return this.usrSignatureEducation;
   }

   public void setUsrSignatureEducation(int var1) {
      this.usrSignatureEducation = var1;
   }

   public int getUsrSignatureMedical() {
      return this.usrSignatureMedical;
   }

   public void setUsrSignatureMedical(int var1) {
      this.usrSignatureMedical = var1;
   }

   public int getUsrSignatureMicroFinance() {
      return this.usrSignatureMicroFinance;
   }

   public void setUsrSignatureMicroFinance(int var1) {
      this.usrSignatureMicroFinance = var1;
   }

   public int getUsrSignatureOffice() {
      return this.usrSignatureOffice;
   }

   public void setUsrSignatureOffice(int var1) {
      this.usrSignatureOffice = var1;
   }

   public int getUsrSignatureParc() {
      return this.usrSignatureParc;
   }

   public void setUsrSignatureParc(int var1) {
      this.usrSignatureParc = var1;
   }

   public int getUsrSignaturePaye() {
      return this.usrSignaturePaye;
   }

   public void setUsrSignaturePaye(int var1) {
      this.usrSignaturePaye = var1;
   }

   public int getUsrSignatureVentes() {
      return this.usrSignatureVentes;
   }

   public void setUsrSignatureVentes(int var1) {
      this.usrSignatureVentes = var1;
   }

   public int getUsrVendeur() {
      return this.usrVendeur;
   }

   public void setUsrVendeur(int var1) {
      this.usrVendeur = var1;
   }

   public int getUsrLibelleCai() {
      return this.usrLibelleCai;
   }

   public void setUsrLibelleCai(int var1) {
      this.usrLibelleCai = var1;
   }

   public int getUsrTiersCai() {
      return this.usrTiersCai;
   }

   public void setUsrTiersCai(int var1) {
      this.usrTiersCai = var1;
   }

   public long getUsrResponsableVentes() {
      return this.usrResponsableVentes;
   }

   public void setUsrResponsableVentes(long var1) {
      this.usrResponsableVentes = var1;
   }

   public int getUsrCaissierDepense() {
      return this.usrCaissierDepense;
   }

   public void setUsrCaissierDepense(int var1) {
      this.usrCaissierDepense = var1;
   }

   public int getUsrCaissierModif() {
      return this.usrCaissierModif;
   }

   public void setUsrCaissierModif(int var1) {
      this.usrCaissierModif = var1;
   }

   public int getUsrCaissierRecette() {
      return this.usrCaissierRecette;
   }

   public void setUsrCaissierRecette(int var1) {
      this.usrCaissierRecette = var1;
   }

   public long getUsrIdEquipe() {
      return this.usrIdEquipe;
   }

   public void setUsrIdEquipe(long var1) {
      this.usrIdEquipe = var1;
   }

   public String getUsrNomEquipe() {
      return this.usrNomEquipe;
   }

   public void setUsrNomEquipe(String var1) {
      this.usrNomEquipe = var1;
   }

   public int getUsrCaissierTransfert() {
      return this.usrCaissierTransfert;
   }

   public void setUsrCaissierTransfert(int var1) {
      this.usrCaissierTransfert = var1;
   }

   public int getUsrCaissierDelete() {
      return this.usrCaissierDelete;
   }

   public void setUsrCaissierDelete(int var1) {
      this.usrCaissierDelete = var1;
   }

   public String getUsrFeuilleInterdite() {
      return this.usrFeuilleInterdite;
   }

   public void setUsrFeuilleInterdite(String var1) {
      this.usrFeuilleInterdite = var1;
   }

   public String getUsrPwEspaceClient() {
      return this.usrPwEspaceClient;
   }

   public void setUsrPwEspaceClient(String var1) {
      this.usrPwEspaceClient = var1;
   }

   public float getUsrCommPourcentage() {
      return this.usrCommPourcentage;
   }

   public void setUsrCommPourcentage(float var1) {
      this.usrCommPourcentage = var1;
   }

   public int getUsrCommType() {
      return this.usrCommType;
   }

   public void setUsrCommType(int var1) {
      this.usrCommType = var1;
   }

   public int getUsrDateLivre() {
      return this.usrDateLivre;
   }

   public void setUsrDateLivre(int var1) {
      this.usrDateLivre = var1;
   }

   public int getUsrLissage() {
      return this.usrLissage;
   }

   public void setUsrLissage(int var1) {
      this.usrLissage = var1;
   }

   public int getUsrChgDosAchat() {
      return this.usrChgDosAchat;
   }

   public void setUsrChgDosAchat(int var1) {
      this.usrChgDosAchat = var1;
   }

   public int getUsrCreationSociete() {
      return this.usrCreationSociete;
   }

   public void setUsrCreationSociete(int var1) {
      this.usrCreationSociete = var1;
   }

   public int getUsrPayeBulletin() {
      return this.usrPayeBulletin;
   }

   public void setUsrPayeBulletin(int var1) {
      this.usrPayeBulletin = var1;
   }

   public int getUsrDatePrc() {
      return this.usrDatePrc;
   }

   public void setUsrDatePrc(int var1) {
      this.usrDatePrc = var1;
   }

   public int getUsrPayPointage() {
      return this.usrPayPointage;
   }

   public void setUsrPayPointage(int var1) {
      this.usrPayPointage = var1;
   }

   public long getUsrIdTiersGuest() {
      return this.usrIdTiersGuest;
   }

   public void setUsrIdTiersGuest(long var1) {
      this.usrIdTiersGuest = var1;
   }

   public String getUsrNomTiersGuest() {
      return this.usrNomTiersGuest;
   }

   public void setUsrNomTiersGuest(String var1) {
      this.usrNomTiersGuest = var1;
   }

   public int getUsrPayeContrat() {
      return this.usrPayeContrat;
   }

   public void setUsrPayeContrat(int var1) {
      this.usrPayeContrat = var1;
   }

   public int getUsrModifSerieAch() {
      return this.usrModifSerieAch;
   }

   public void setUsrModifSerieAch(int var1) {
      this.usrModifSerieAch = var1;
   }

   public int getUsrModifSerieVte() {
      return this.usrModifSerieVte;
   }

   public void setUsrModifSerieVte(int var1) {
      this.usrModifSerieVte = var1;
   }

   public int getUsrPayeAlerte() {
      return this.usrPayeAlerte;
   }

   public void setUsrPayeAlerte(int var1) {
      this.usrPayeAlerte = var1;
   }

   public int getUsrParcAlerte() {
      return this.usrParcAlerte;
   }

   public void setUsrParcAlerte(int var1) {
      this.usrParcAlerte = var1;
   }

   public double getObjectifAvoir() {
      return this.objectifAvoir;
   }

   public void setObjectifAvoir(double var1) {
      this.objectifAvoir = var1;
   }

   public double getObjectifBc() {
      return this.objectifBc;
   }

   public void setObjectifBc(double var1) {
      this.objectifBc = var1;
   }

   public double getObjectifBl() {
      return this.objectifBl;
   }

   public void setObjectifBl(double var1) {
      this.objectifBl = var1;
   }

   public double getObjectifBr() {
      return this.objectifBr;
   }

   public void setObjectifBr(double var1) {
      this.objectifBr = var1;
   }

   public double getObjectifDevis() {
      return this.objectifDevis;
   }

   public void setObjectifDevis(double var1) {
      this.objectifDevis = var1;
   }

   public double getObjectifFacture() {
      return this.objectifFacture;
   }

   public void setObjectifFacture(double var1) {
      this.objectifFacture = var1;
   }

   public double getObjectifNdb() {
      return this.objectifNdb;
   }

   public void setObjectifNdb(double var1) {
      this.objectifNdb = var1;
   }

   public double getObjectifRdv() {
      return this.objectifRdv;
   }

   public void setObjectifRdv(double var1) {
      this.objectifRdv = var1;
   }

   public String getObjectifAnnee() {
      return this.objectifAnnee;
   }

   public void setObjectifAnnee(String var1) {
      this.objectifAnnee = var1;
   }

   public String getUsrCompte() {
      if (this.usrCompte != null && !this.usrCompte.isEmpty()) {
         this.usrCompte = this.usrCompte.toUpperCase();
      }

      return this.usrCompte;
   }

   public void setUsrCompte(String var1) {
      this.usrCompte = var1;
   }

   public int getUsrDemandeurAchats() {
      return this.usrDemandeurAchats;
   }

   public void setUsrDemandeurAchats(int var1) {
      this.usrDemandeurAchats = var1;
   }

   public int getUsrBaseCopie() {
      return this.usrBaseCopie;
   }

   public void setUsrBaseCopie(int var1) {
      this.usrBaseCopie = var1;
   }

   public String getUsrNomBaseCopie() {
      return this.usrNomBaseCopie;
   }

   public void setUsrNomBaseCopie(String var1) {
      this.usrNomBaseCopie = var1;
   }

   public int getUsrAcheteur() {
      return this.usrAcheteur;
   }

   public void setUsrAcheteur(int var1) {
      this.usrAcheteur = var1;
   }

   public String getUsrSpecialite() {
      return this.usrSpecialite;
   }

   public void setUsrSpecialite(String var1) {
      this.usrSpecialite = var1;
   }

   public int getUsrAchLibelle() {
      return this.usrAchLibelle;
   }

   public void setUsrAchLibelle(int var1) {
      this.usrAchLibelle = var1;
   }

   public int getUsrVteLibelle() {
      return this.usrVteLibelle;
   }

   public void setUsrVteLibelle(int var1) {
      this.usrVteLibelle = var1;
   }

   public long getUsrIdSalarieGuest() {
      return this.usrIdSalarieGuest;
   }

   public void setUsrIdSalarieGuest(long var1) {
      this.usrIdSalarieGuest = var1;
   }

   public String getUsrNomSalarieGuest() {
      return this.usrNomSalarieGuest;
   }

   public void setUsrNomSalarieGuest(String var1) {
      this.usrNomSalarieGuest = var1;
   }

   public int getUsrVteCtrAlerte() {
      return this.usrVteCtrAlerte;
   }

   public void setUsrVteCtrAlerte(int var1) {
      this.usrVteCtrAlerte = var1;
   }

   public String getUsrMetier() {
      return this.usrMetier;
   }

   public void setUsrMetier(String var1) {
      this.usrMetier = var1;
   }

   public int getUsrRespCaissier() {
      return this.usrRespCaissier;
   }

   public void setUsrRespCaissier(int var1) {
      this.usrRespCaissier = var1;
   }

   public boolean isUsrCptActivite() {
      return this.usrCptActivite;
   }

   public void setUsrCptActivite(boolean var1) {
      this.usrCptActivite = var1;
   }

   public boolean isUsrCptAgent() {
      return this.usrCptAgent;
   }

   public void setUsrCptAgent(boolean var1) {
      this.usrCptAgent = var1;
   }

   public boolean isUsrCptChantier() {
      return this.usrCptChantier;
   }

   public void setUsrCptChantier(boolean var1) {
      this.usrCptChantier = var1;
   }

   public boolean isUsrCptCles() {
      return this.usrCptCles;
   }

   public void setUsrCptCles(boolean var1) {
      this.usrCptCles = var1;
   }

   public boolean isUsrCptDossier() {
      return this.usrCptDossier;
   }

   public void setUsrCptDossier(boolean var1) {
      this.usrCptDossier = var1;
   }

   public boolean isUsrCptMission() {
      return this.usrCptMission;
   }

   public void setUsrCptMission(boolean var1) {
      this.usrCptMission = var1;
   }

   public boolean isUsrCptParc() {
      return this.usrCptParc;
   }

   public void setUsrCptParc(boolean var1) {
      this.usrCptParc = var1;
   }

   public boolean isUsrCptProjet() {
      return this.usrCptProjet;
   }

   public void setUsrCptProjet(boolean var1) {
      this.usrCptProjet = var1;
   }

   public boolean isUsrCptRegion() {
      return this.usrCptRegion;
   }

   public void setUsrCptRegion(boolean var1) {
      this.usrCptRegion = var1;
   }

   public boolean isUsrCptSite() {
      return this.usrCptSite;
   }

   public void setUsrCptSite(boolean var1) {
      this.usrCptSite = var1;
   }

   public boolean isUsrCptStructure() {
      return this.usrCptStructure;
   }

   public void setUsrCptStructure(boolean var1) {
      this.usrCptStructure = var1;
   }

   public boolean isUsrCptUsine() {
      return this.usrCptUsine;
   }

   public void setUsrCptUsine(boolean var1) {
      this.usrCptUsine = var1;
   }

   public boolean isUsrMyLifeChat() {
      return this.usrMyLifeChat;
   }

   public void setUsrMyLifeChat(boolean var1) {
      this.usrMyLifeChat = var1;
   }

   public int getUsrSansHabilitation() {
      return this.usrSansHabilitation;
   }

   public void setUsrSansHabilitation(int var1) {
      this.usrSansHabilitation = var1;
   }

   public int getUsrMedicalAvoir() {
      return this.usrMedicalAvoir;
   }

   public void setUsrMedicalAvoir(int var1) {
      this.usrMedicalAvoir = var1;
   }

   public int getUsrConfigListe() {
      return this.usrConfigListe;
   }

   public void setUsrConfigListe(int var1) {
      this.usrConfigListe = var1;
   }

   public int getUsrFactureDeCaisse() {
      return this.usrFactureDeCaisse;
   }

   public void setUsrFactureDeCaisse(int var1) {
      this.usrFactureDeCaisse = var1;
   }

   public int getUsrCaissierAnnule() {
      return this.usrCaissierAnnule;
   }

   public void setUsrCaissierAnnule(int var1) {
      this.usrCaissierAnnule = var1;
   }

   public int getUsrAssistant() {
      return this.usrAssistant;
   }

   public void setUsrAssistant(int var1) {
      this.usrAssistant = var1;
   }

   public int getUsrRecusJour() {
      return this.usrRecusJour;
   }

   public void setUsrRecusJour(int var1) {
      this.usrRecusJour = var1;
   }

   public String getUsrInitiale() {
      return this.usrInitiale;
   }

   public void setUsrInitiale(String var1) {
      this.usrInitiale = var1;
   }

   public int getUsrVteTotaux() {
      return this.usrVteTotaux;
   }

   public void setUsrVteTotaux(int var1) {
      this.usrVteTotaux = var1;
   }

   public String getUsrServiceSecondaire() {
      return this.usrServiceSecondaire;
   }

   public void setUsrServiceSecondaire(String var1) {
      this.usrServiceSecondaire = var1;
   }

   public String getUsrDepartementSecondaire() {
      return this.usrDepartementSecondaire;
   }

   public void setUsrDepartementSecondaire(String var1) {
      this.usrDepartementSecondaire = var1;
   }

   public String getUsrSiteSecondaire() {
      return this.usrSiteSecondaire;
   }

   public void setUsrSiteSecondaire(String var1) {
      this.usrSiteSecondaire = var1;
   }

   public String getUsrImei() {
      return this.usrImei;
   }

   public void setUsrImei(String var1) {
      this.usrImei = var1;
   }

   public String getUsrPermandroid() {
      return this.usrPermandroid;
   }

   public void setUsrPermandroid(String var1) {
      this.usrPermandroid = var1;
   }

   public String getUsrNumStat() {
      return this.usrNumStat;
   }

   public void setUsrNumStat(String var1) {
      this.usrNumStat = var1;
   }

   public int getUsrExtraitAnal() {
      return this.usrExtraitAnal;
   }

   public void setUsrExtraitAnal(int var1) {
      this.usrExtraitAnal = var1;
   }

   public int getUsrPayeCaisse() {
      return this.usrPayeCaisse;
   }

   public void setUsrPayeCaisse(int var1) {
      this.usrPayeCaisse = var1;
   }

   public int getUsrCabinet() {
      return this.usrCabinet;
   }

   public void setUsrCabinet(int var1) {
      this.usrCabinet = var1;
   }

   public int getUsrMedicalAlerte() {
      return this.usrMedicalAlerte;
   }

   public void setUsrMedicalAlerte(int var1) {
      this.usrMedicalAlerte = var1;
   }
}
