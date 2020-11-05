package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CaissesCommerciales implements Serializable {
   private long caiId;
   private Date caiDateCreat;
   private Date caiDateModif;
   private long caiUserCreat;
   private long caiUserModif;
   private String caiCode;
   private String caiNom;
   private int caiPrive;
   private int caiInactif;
   private double caiMontantPlafond;
   private String caiJrEspece;
   private String caiJrEspeceST;
   private String caiJrCheque;
   private String caiJrVirement;
   private String caiJrTraite;
   private String caiJrTpe;
   private String caiJrTransfert;
   private String caiJrePaiement;
   private String caiJrCredoc;
   private String caiJrFactor;
   private String caiJrCompense;
   private String caiJrTerme;
   private String caiJrLettreGarantie;
   private String caiJrPrelevement;
   private String caiJrAlcoin;
   private String caiNomJrEspece;
   private String caiNomJrEspeceST;
   private String caiNomJrCheque;
   private String caiNomJrVirement;
   private String caiNomJrTraite;
   private String caiNomJrTpe;
   private String caiNomJrTransfert;
   private String caiNomJrePaiement;
   private String caiNomJrCredoc;
   private String caiNomJrFactor;
   private String caiNomJrCompense;
   private String caiNomJrTerme;
   private String caiNomJrLettreGarantie;
   private String caiNomJrPrelevement;
   private String caiNomJrAlcoin;
   private String caiCompteVrt;
   private String caiLibCompteVrt;
   private String caiCompteEff;
   private String caiLibCompteEff;
   private int caiMode;
   private String caiCodeBanqueDefaut;
   private String caiNomBanqueDefaut;
   private double caiMontantInitEspece;
   private double caiMontantInitCheque;
   private double caiMontantInitVirement;
   private double caiMontantInitTraite;
   private double caiMontantInitTpe;
   private double caiMontantInitePaiement;
   private double caiMontantInitTransfert;
   private double caiMontantInitCredoc;
   private double caiMontantInitFactor;
   private double caiMontantInitCompense;
   private double caiMontantInitTerme;
   private double caiMontantInitLettreGarantie;
   private double caiMontantInitPrelevement;
   private double caiMontantInitAlcoin;
   private Date caiDateInit;
   private double caiMontantInit;
   private double caiMontantFondCaisse;
   private double caiMontantFondCaisseMax;
   private double caiMontantMaxDepense;
   private String caiOperation;
   private int caiMvtCheBnq;
   private boolean caiExportJrEspece;
   private boolean caiExportJrCheque;
   private boolean caiExportJrVirement;
   private boolean caiExportJrTraite;
   private boolean caiExportJrTpe;
   private boolean caiExportJrTrf;
   private boolean caiExportJrePaiement;
   private boolean caiExportJrCredoc;
   private boolean caiExportJrFactor;
   private boolean caiExportJrCompense;
   private boolean caiExportJrTerme;
   private boolean caiExportJrLettreGarantie;
   private boolean caiExportJrPrelevement;
   private boolean caiExportJrAlcoin;
   private String caiProjet;
   private int caiNegatif;
   private ExercicesCaisse exercicesCaisse;
   private String etat;
   private boolean afficheImag;
   private String libMode;
   private boolean caisseSelected;
   private boolean recuSelected;

   public String getCaiCode() {
      if (this.caiCode != null && !this.caiCode.isEmpty()) {
         this.caiCode = this.caiCode.toUpperCase();
      }

      return this.caiCode;
   }

   public boolean isRecuSelected() {
      return this.recuSelected;
   }

   public void setRecuSelected(boolean var1) {
      this.recuSelected = var1;
   }

   public boolean isCaisseSelected() {
      return this.caisseSelected;
   }

   public void setCaisseSelected(boolean var1) {
      this.caisseSelected = var1;
   }

   public String getLibMode() {
      if (this.caiMode == 0) {
         this.libMode = "Mixte";
      } else if (this.caiMode == 1) {
         this.libMode = "Dépnses";
      } else if (this.caiMode == 2) {
         this.libMode = "Recettes";
      }

      return this.libMode;
   }

   public void setLibMode(String var1) {
      this.libMode = var1;
   }

   public void setCaiCode(String var1) {
      this.caiCode = var1;
   }

   public Date getCaiDateCreat() {
      return this.caiDateCreat;
   }

   public void setCaiDateCreat(Date var1) {
      this.caiDateCreat = var1;
   }

   public Date getCaiDateModif() {
      return this.caiDateModif;
   }

   public void setCaiDateModif(Date var1) {
      this.caiDateModif = var1;
   }

   public long getCaiId() {
      return this.caiId;
   }

   public void setCaiId(long var1) {
      this.caiId = var1;
   }

   public int getCaiInactif() {
      return this.caiInactif;
   }

   public void setCaiInactif(int var1) {
      this.caiInactif = var1;
   }

   public String getCaiNom() {
      if (this.caiNom != null && !this.caiNom.isEmpty()) {
         this.caiNom = this.caiNom.toUpperCase();
      }

      return this.caiNom;
   }

   public void setCaiNom(String var1) {
      this.caiNom = var1;
   }

   public long getCaiUserCreat() {
      return this.caiUserCreat;
   }

   public void setCaiUserCreat(long var1) {
      this.caiUserCreat = var1;
   }

   public long getCaiUserModif() {
      return this.caiUserModif;
   }

   public void setCaiUserModif(long var1) {
      this.caiUserModif = var1;
   }

   public ExercicesCaisse getExercicesCaisse() {
      return this.exercicesCaisse;
   }

   public void setExercicesCaisse(ExercicesCaisse var1) {
      this.exercicesCaisse = var1;
   }

   public boolean isAfficheImag() {
      if (this.caiInactif != 1 && this.caiInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getEtat() {
      if (this.caiInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.caiInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public String getCaiCompteVrt() {
      return this.caiCompteVrt;
   }

   public void setCaiCompteVrt(String var1) {
      this.caiCompteVrt = var1;
   }

   public String getCaiLibCompteVrt() {
      return this.caiLibCompteVrt;
   }

   public void setCaiLibCompteVrt(String var1) {
      this.caiLibCompteVrt = var1;
   }

   public int getCaiPrive() {
      return this.caiPrive;
   }

   public void setCaiPrive(int var1) {
      this.caiPrive = var1;
   }

   public double getCaiMontantPlafond() {
      return this.caiMontantPlafond;
   }

   public void setCaiMontantPlafond(double var1) {
      this.caiMontantPlafond = var1;
   }

   public String getCaiCompteEff() {
      return this.caiCompteEff;
   }

   public void setCaiCompteEff(String var1) {
      this.caiCompteEff = var1;
   }

   public String getCaiLibCompteEff() {
      return this.caiLibCompteEff;
   }

   public void setCaiLibCompteEff(String var1) {
      this.caiLibCompteEff = var1;
   }

   public String getCaiJrCheque() {
      return this.caiJrCheque;
   }

   public void setCaiJrCheque(String var1) {
      this.caiJrCheque = var1;
   }

   public String getCaiJrEspece() {
      return this.caiJrEspece;
   }

   public void setCaiJrEspece(String var1) {
      this.caiJrEspece = var1;
   }

   public String getCaiNomJrCheque() {
      return this.caiNomJrCheque;
   }

   public void setCaiNomJrCheque(String var1) {
      this.caiNomJrCheque = var1;
   }

   public String getCaiNomJrEspece() {
      return this.caiNomJrEspece;
   }

   public void setCaiNomJrEspece(String var1) {
      this.caiNomJrEspece = var1;
   }

   public int getCaiMode() {
      return this.caiMode;
   }

   public void setCaiMode(int var1) {
      this.caiMode = var1;
   }

   public String getCaiCodeBanqueDefaut() {
      return this.caiCodeBanqueDefaut;
   }

   public void setCaiCodeBanqueDefaut(String var1) {
      this.caiCodeBanqueDefaut = var1;
   }

   public String getCaiNomBanqueDefaut() {
      return this.caiNomBanqueDefaut;
   }

   public void setCaiNomBanqueDefaut(String var1) {
      this.caiNomBanqueDefaut = var1;
   }

   public String getCaiJrCompense() {
      return this.caiJrCompense;
   }

   public void setCaiJrCompense(String var1) {
      this.caiJrCompense = var1;
   }

   public String getCaiJrCredoc() {
      return this.caiJrCredoc;
   }

   public void setCaiJrCredoc(String var1) {
      this.caiJrCredoc = var1;
   }

   public String getCaiJrFactor() {
      return this.caiJrFactor;
   }

   public void setCaiJrFactor(String var1) {
      this.caiJrFactor = var1;
   }

   public String getCaiJrTerme() {
      return this.caiJrTerme;
   }

   public void setCaiJrTerme(String var1) {
      this.caiJrTerme = var1;
   }

   public String getCaiJrTpe() {
      return this.caiJrTpe;
   }

   public void setCaiJrTpe(String var1) {
      this.caiJrTpe = var1;
   }

   public String getCaiJrTraite() {
      return this.caiJrTraite;
   }

   public void setCaiJrTraite(String var1) {
      this.caiJrTraite = var1;
   }

   public String getCaiJrTransfert() {
      return this.caiJrTransfert;
   }

   public void setCaiJrTransfert(String var1) {
      this.caiJrTransfert = var1;
   }

   public String getCaiJrVirement() {
      return this.caiJrVirement;
   }

   public void setCaiJrVirement(String var1) {
      this.caiJrVirement = var1;
   }

   public String getCaiJrePaiement() {
      return this.caiJrePaiement;
   }

   public void setCaiJrePaiement(String var1) {
      this.caiJrePaiement = var1;
   }

   public String getCaiNomJrCompense() {
      return this.caiNomJrCompense;
   }

   public void setCaiNomJrCompense(String var1) {
      this.caiNomJrCompense = var1;
   }

   public String getCaiNomJrCredoc() {
      return this.caiNomJrCredoc;
   }

   public void setCaiNomJrCredoc(String var1) {
      this.caiNomJrCredoc = var1;
   }

   public String getCaiNomJrFactor() {
      return this.caiNomJrFactor;
   }

   public void setCaiNomJrFactor(String var1) {
      this.caiNomJrFactor = var1;
   }

   public String getCaiNomJrTerme() {
      return this.caiNomJrTerme;
   }

   public void setCaiNomJrTerme(String var1) {
      this.caiNomJrTerme = var1;
   }

   public String getCaiNomJrTpe() {
      return this.caiNomJrTpe;
   }

   public void setCaiNomJrTpe(String var1) {
      this.caiNomJrTpe = var1;
   }

   public String getCaiNomJrTraite() {
      return this.caiNomJrTraite;
   }

   public void setCaiNomJrTraite(String var1) {
      this.caiNomJrTraite = var1;
   }

   public String getCaiNomJrTransfert() {
      return this.caiNomJrTransfert;
   }

   public void setCaiNomJrTransfert(String var1) {
      this.caiNomJrTransfert = var1;
   }

   public String getCaiNomJrVirement() {
      return this.caiNomJrVirement;
   }

   public void setCaiNomJrVirement(String var1) {
      this.caiNomJrVirement = var1;
   }

   public String getCaiNomJrePaiement() {
      return this.caiNomJrePaiement;
   }

   public void setCaiNomJrePaiement(String var1) {
      this.caiNomJrePaiement = var1;
   }

   public double getCaiMontantInitCheque() {
      return this.caiMontantInitCheque;
   }

   public void setCaiMontantInitCheque(double var1) {
      this.caiMontantInitCheque = var1;
   }

   public double getCaiMontantInitCompense() {
      return this.caiMontantInitCompense;
   }

   public void setCaiMontantInitCompense(double var1) {
      this.caiMontantInitCompense = var1;
   }

   public double getCaiMontantInitCredoc() {
      return this.caiMontantInitCredoc;
   }

   public void setCaiMontantInitCredoc(double var1) {
      this.caiMontantInitCredoc = var1;
   }

   public double getCaiMontantInitEspece() {
      return this.caiMontantInitEspece;
   }

   public void setCaiMontantInitEspece(double var1) {
      this.caiMontantInitEspece = var1;
   }

   public double getCaiMontantInitFactor() {
      return this.caiMontantInitFactor;
   }

   public void setCaiMontantInitFactor(double var1) {
      this.caiMontantInitFactor = var1;
   }

   public double getCaiMontantInitTerme() {
      return this.caiMontantInitTerme;
   }

   public void setCaiMontantInitTerme(double var1) {
      this.caiMontantInitTerme = var1;
   }

   public double getCaiMontantInitTpe() {
      return this.caiMontantInitTpe;
   }

   public void setCaiMontantInitTpe(double var1) {
      this.caiMontantInitTpe = var1;
   }

   public double getCaiMontantInitTraite() {
      return this.caiMontantInitTraite;
   }

   public void setCaiMontantInitTraite(double var1) {
      this.caiMontantInitTraite = var1;
   }

   public double getCaiMontantInitTransfert() {
      return this.caiMontantInitTransfert;
   }

   public void setCaiMontantInitTransfert(double var1) {
      this.caiMontantInitTransfert = var1;
   }

   public double getCaiMontantInitVirement() {
      return this.caiMontantInitVirement;
   }

   public void setCaiMontantInitVirement(double var1) {
      this.caiMontantInitVirement = var1;
   }

   public double getCaiMontantInitePaiement() {
      return this.caiMontantInitePaiement;
   }

   public void setCaiMontantInitePaiement(double var1) {
      this.caiMontantInitePaiement = var1;
   }

   public Date getCaiDateInit() {
      return this.caiDateInit;
   }

   public void setCaiDateInit(Date var1) {
      this.caiDateInit = var1;
   }

   public double getCaiMontantInit() {
      return this.caiMontantInit;
   }

   public void setCaiMontantInit(double var1) {
      this.caiMontantInit = var1;
   }

   public double getCaiMontantFondCaisse() {
      return this.caiMontantFondCaisse;
   }

   public void setCaiMontantFondCaisse(double var1) {
      this.caiMontantFondCaisse = var1;
   }

   public double getCaiMontantMaxDepense() {
      return this.caiMontantMaxDepense;
   }

   public void setCaiMontantMaxDepense(double var1) {
      this.caiMontantMaxDepense = var1;
   }

   public String getCaiOperation() {
      return this.caiOperation;
   }

   public void setCaiOperation(String var1) {
      this.caiOperation = var1;
   }

   public String getCaiJrEspeceST() {
      return this.caiJrEspeceST;
   }

   public void setCaiJrEspeceST(String var1) {
      this.caiJrEspeceST = var1;
   }

   public String getCaiNomJrEspeceST() {
      return this.caiNomJrEspeceST;
   }

   public void setCaiNomJrEspeceST(String var1) {
      this.caiNomJrEspeceST = var1;
   }

   public double getCaiMontantFondCaisseMax() {
      return this.caiMontantFondCaisseMax;
   }

   public void setCaiMontantFondCaisseMax(double var1) {
      this.caiMontantFondCaisseMax = var1;
   }

   public int getCaiMvtCheBnq() {
      return this.caiMvtCheBnq;
   }

   public void setCaiMvtCheBnq(int var1) {
      this.caiMvtCheBnq = var1;
   }

   public boolean isCaiExportJrCheque() {
      return this.caiExportJrCheque;
   }

   public void setCaiExportJrCheque(boolean var1) {
      this.caiExportJrCheque = var1;
   }

   public boolean isCaiExportJrCompense() {
      return this.caiExportJrCompense;
   }

   public void setCaiExportJrCompense(boolean var1) {
      this.caiExportJrCompense = var1;
   }

   public boolean isCaiExportJrCredoc() {
      return this.caiExportJrCredoc;
   }

   public void setCaiExportJrCredoc(boolean var1) {
      this.caiExportJrCredoc = var1;
   }

   public boolean isCaiExportJrEspece() {
      return this.caiExportJrEspece;
   }

   public void setCaiExportJrEspece(boolean var1) {
      this.caiExportJrEspece = var1;
   }

   public boolean isCaiExportJrFactor() {
      return this.caiExportJrFactor;
   }

   public void setCaiExportJrFactor(boolean var1) {
      this.caiExportJrFactor = var1;
   }

   public boolean isCaiExportJrTerme() {
      return this.caiExportJrTerme;
   }

   public void setCaiExportJrTerme(boolean var1) {
      this.caiExportJrTerme = var1;
   }

   public boolean isCaiExportJrTpe() {
      return this.caiExportJrTpe;
   }

   public void setCaiExportJrTpe(boolean var1) {
      this.caiExportJrTpe = var1;
   }

   public boolean isCaiExportJrTraite() {
      return this.caiExportJrTraite;
   }

   public void setCaiExportJrTraite(boolean var1) {
      this.caiExportJrTraite = var1;
   }

   public boolean isCaiExportJrTrf() {
      return this.caiExportJrTrf;
   }

   public void setCaiExportJrTrf(boolean var1) {
      this.caiExportJrTrf = var1;
   }

   public boolean isCaiExportJrVirement() {
      return this.caiExportJrVirement;
   }

   public void setCaiExportJrVirement(boolean var1) {
      this.caiExportJrVirement = var1;
   }

   public boolean isCaiExportJrePaiement() {
      return this.caiExportJrePaiement;
   }

   public void setCaiExportJrePaiement(boolean var1) {
      this.caiExportJrePaiement = var1;
   }

   public String getCaiProjet() {
      return this.caiProjet;
   }

   public void setCaiProjet(String var1) {
      this.caiProjet = var1;
   }

   public boolean isCaiExportJrLettreGarantie() {
      return this.caiExportJrLettreGarantie;
   }

   public void setCaiExportJrLettreGarantie(boolean var1) {
      this.caiExportJrLettreGarantie = var1;
   }

   public String getCaiJrLettreGarantie() {
      return this.caiJrLettreGarantie;
   }

   public void setCaiJrLettreGarantie(String var1) {
      this.caiJrLettreGarantie = var1;
   }

   public double getCaiMontantInitLettreGarantie() {
      return this.caiMontantInitLettreGarantie;
   }

   public void setCaiMontantInitLettreGarantie(double var1) {
      this.caiMontantInitLettreGarantie = var1;
   }

   public String getCaiNomJrLettreGarantie() {
      return this.caiNomJrLettreGarantie;
   }

   public void setCaiNomJrLettreGarantie(String var1) {
      this.caiNomJrLettreGarantie = var1;
   }

   public int getCaiNegatif() {
      return this.caiNegatif;
   }

   public void setCaiNegatif(int var1) {
      this.caiNegatif = var1;
   }

   public boolean isCaiExportJrAlcoin() {
      return this.caiExportJrAlcoin;
   }

   public void setCaiExportJrAlcoin(boolean var1) {
      this.caiExportJrAlcoin = var1;
   }

   public boolean isCaiExportJrPrelevement() {
      return this.caiExportJrPrelevement;
   }

   public void setCaiExportJrPrelevement(boolean var1) {
      this.caiExportJrPrelevement = var1;
   }

   public String getCaiJrAlcoin() {
      return this.caiJrAlcoin;
   }

   public void setCaiJrAlcoin(String var1) {
      this.caiJrAlcoin = var1;
   }

   public String getCaiJrPrelevement() {
      return this.caiJrPrelevement;
   }

   public void setCaiJrPrelevement(String var1) {
      this.caiJrPrelevement = var1;
   }

   public double getCaiMontantInitAlcoin() {
      return this.caiMontantInitAlcoin;
   }

   public void setCaiMontantInitAlcoin(double var1) {
      this.caiMontantInitAlcoin = var1;
   }

   public double getCaiMontantInitPrelevement() {
      return this.caiMontantInitPrelevement;
   }

   public void setCaiMontantInitPrelevement(double var1) {
      this.caiMontantInitPrelevement = var1;
   }

   public String getCaiNomJrAlcoin() {
      return this.caiNomJrAlcoin;
   }

   public void setCaiNomJrAlcoin(String var1) {
      this.caiNomJrAlcoin = var1;
   }

   public String getCaiNomJrPrelevement() {
      return this.caiNomJrPrelevement;
   }

   public void setCaiNomJrPrelevement(String var1) {
      this.caiNomJrPrelevement = var1;
   }
}
