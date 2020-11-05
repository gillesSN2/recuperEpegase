package com.epegase.systeme.xml;

import java.io.Serializable;

public class OptionComptabilite implements Serializable {
   private String adresseFtp;
   private String loginFtp;
   private String portFtp;
   private String passwdFtp;
   private String nbcr;
   private String nbcrExport;
   private String calculCompte;
   private String typelib;
   private String tri_jrx;
   private String tri_extrait;
   private String trf_brl;
   private String trf_cpte;
   private String trf_cpteAchats;
   private String trf_cpteVentes;
   private String trf_cptePaye;
   private String trf_cpteImmo;
   private String trf_cpteTreso;
   private String exportOd;
   private String verrouImport;
   private String brouillardImport;
   private String clotureSansControle;
   private String clotureSansRappro;
   private String clotureLettrage;
   private String clotureLettrageInutile;
   private String clotureBackup;
   private String ecartDebit;
   private String ecartCredit;
   private String trf_rapprochement;
   private String trf_rapprochementMode;
   private String analytique;
   private String saisieAnalytique;
   private String analytiqueErreur;
   private String analytiqueTransfert;
   private String anal_c1;
   private String anal_c2;
   private String anal_c3;
   private String anal_c4;
   private String anal_c5;
   private String anal_c6;
   private String anal_c7;
   private String anal_c8;
   private String anal_c9;
   private String anal_c10;
   private String anal_c11;
   private String anal_c12;
   private String anal_c13;
   private String anal_c14;
   private String anal_c15;
   private String anal_c16;
   private String anal_c17;
   private String anal_c18;
   private String anal_c19;
   private String anal_c20;
   private String anal_c21;
   private String anal_c22;
   private String anal_c23;
   private String anal_c24;
   private String tresorerie;
   private String budget;
   private String bud_c1;
   private String bud_c2;
   private String bud_c3;
   private String bud_c4;
   private String bud_c5;
   private String bud_c6;
   private String bud_c7;
   private String bud_c8;
   private String bud_c9;
   private String bud_c10;
   private String bud_c11;
   private String bud_c12;
   private String bud_c13;
   private String bud_c14;
   private String bud_c15;
   private String bud_c16;
   private String bud_c17;
   private String bud_c18;
   private String bud_c19;
   private String bud_c20;
   private String bud_c21;
   private String bud_c22;
   private String bud_c23;
   private String bud_c24;
   private String compte_treso;
   private String colContrePartie;
   private String colNumReference1;
   private String colNumReference2;
   private String planCpteLiasse;
   private String calculImmobilisation;
   private String testRef1Piece = "false";
   private String testRef2Piece = "false";
   private String testContrePartie = "false";
   private boolean griserAnalytique;
   private String nbLigneMaxBr;
   private String nbLigneMaxJr;
   private String nbLigneMaxEx;
   private String nbLigneMaxAm;
   private String nbLigneMaxLo;
   private String nbLigneMaxBu;
   private String dossierExport;
   private String cen_c20;
   private String cen_c21;
   private String cen_c22;
   private String cen_c23;
   private String cen_c24;
   private String cen_c25;
   private String cen_c26;
   private String cen_c27;
   private String cen_c28;
   private String cen_c29;
   private String cen_c30;
   private String cen_c31;
   private String cen_c32;
   private String cen_c33;
   private String cen_c34;
   private String cen_c35;
   private String cen_c36;
   private String cen_c37;
   private String cen_c38;
   private String cen_c39;
   private String cen_c40;
   private String cen_c41;
   private String cen_c42;
   private String cen_c43;
   private String cen_c44;
   private String cen_c45;
   private String cen_c46;
   private String cen_c47;
   private String cen_c48;
   private String cen_c49;
   private String mailClotureRappro;
   private String mailClotureJournal;

   public String getTestContrePartie() {
      if (this.colContrePartie.equalsIgnoreCase("masquée")) {
         this.testContrePartie = "false";
      } else if (this.colContrePartie.equalsIgnoreCase("visible")) {
         this.testContrePartie = "true";
      }

      return this.testContrePartie;
   }

   public void setTestContrePartie(String var1) {
      this.testContrePartie = var1;
   }

   public String getTestRef1Piece() {
      if (this.colNumReference1.equalsIgnoreCase("masquée")) {
         this.testRef1Piece = "false";
      } else if (this.colNumReference1.equalsIgnoreCase("visible")) {
         this.testRef1Piece = "true";
      }

      return this.testRef1Piece;
   }

   public void setTestRef1Piece(String var1) {
      this.testRef1Piece = var1;
   }

   public String getTestRef2Piece() {
      if (this.colNumReference2.equalsIgnoreCase("masquée")) {
         this.testRef2Piece = "false";
      } else if (this.colNumReference2.equalsIgnoreCase("visible")) {
         this.testRef2Piece = "true";
      }

      return this.testRef2Piece;
   }

   public void setTestRef2Piece(String var1) {
      this.testRef2Piece = var1;
   }

   public String getAnal_c1() {
      return this.anal_c1;
   }

   public void setAnal_c1(String var1) {
      this.anal_c1 = var1;
   }

   public String getAnal_c10() {
      return this.anal_c10;
   }

   public void setAnal_c10(String var1) {
      this.anal_c10 = var1;
   }

   public String getAnal_c11() {
      return this.anal_c11;
   }

   public void setAnal_c11(String var1) {
      this.anal_c11 = var1;
   }

   public String getAnal_c12() {
      return this.anal_c12;
   }

   public void setAnal_c12(String var1) {
      this.anal_c12 = var1;
   }

   public String getAnal_c13() {
      return this.anal_c13;
   }

   public void setAnal_c13(String var1) {
      this.anal_c13 = var1;
   }

   public String getAnal_c14() {
      return this.anal_c14;
   }

   public void setAnal_c14(String var1) {
      this.anal_c14 = var1;
   }

   public String getAnal_c15() {
      return this.anal_c15;
   }

   public void setAnal_c15(String var1) {
      this.anal_c15 = var1;
   }

   public String getAnal_c16() {
      return this.anal_c16;
   }

   public void setAnal_c16(String var1) {
      this.anal_c16 = var1;
   }

   public String getAnal_c17() {
      return this.anal_c17;
   }

   public void setAnal_c17(String var1) {
      this.anal_c17 = var1;
   }

   public String getAnal_c18() {
      return this.anal_c18;
   }

   public void setAnal_c18(String var1) {
      this.anal_c18 = var1;
   }

   public String getAnal_c2() {
      return this.anal_c2;
   }

   public void setAnal_c2(String var1) {
      this.anal_c2 = var1;
   }

   public String getAnal_c3() {
      return this.anal_c3;
   }

   public void setAnal_c3(String var1) {
      this.anal_c3 = var1;
   }

   public String getAnal_c4() {
      return this.anal_c4;
   }

   public void setAnal_c4(String var1) {
      this.anal_c4 = var1;
   }

   public String getAnal_c5() {
      return this.anal_c5;
   }

   public void setAnal_c5(String var1) {
      this.anal_c5 = var1;
   }

   public String getAnal_c6() {
      return this.anal_c6;
   }

   public void setAnal_c6(String var1) {
      this.anal_c6 = var1;
   }

   public String getAnal_c7() {
      return this.anal_c7;
   }

   public void setAnal_c7(String var1) {
      this.anal_c7 = var1;
   }

   public String getAnal_c8() {
      return this.anal_c8;
   }

   public void setAnal_c8(String var1) {
      this.anal_c8 = var1;
   }

   public String getAnal_c9() {
      return this.anal_c9;
   }

   public void setAnal_c9(String var1) {
      this.anal_c9 = var1;
   }

   public String getAnalytique() {
      return this.analytique;
   }

   public void setAnalytique(String var1) {
      this.analytique = var1;
   }

   public String getBud_c1() {
      return this.bud_c1;
   }

   public void setBud_c1(String var1) {
      this.bud_c1 = var1;
   }

   public String getBud_c10() {
      return this.bud_c10;
   }

   public void setBud_c10(String var1) {
      this.bud_c10 = var1;
   }

   public String getBud_c11() {
      return this.bud_c11;
   }

   public void setBud_c11(String var1) {
      this.bud_c11 = var1;
   }

   public String getBud_c12() {
      return this.bud_c12;
   }

   public void setBud_c12(String var1) {
      this.bud_c12 = var1;
   }

   public String getBud_c13() {
      return this.bud_c13;
   }

   public void setBud_c13(String var1) {
      this.bud_c13 = var1;
   }

   public String getBud_c14() {
      return this.bud_c14;
   }

   public void setBud_c14(String var1) {
      this.bud_c14 = var1;
   }

   public String getBud_c15() {
      return this.bud_c15;
   }

   public void setBud_c15(String var1) {
      this.bud_c15 = var1;
   }

   public String getBud_c16() {
      return this.bud_c16;
   }

   public void setBud_c16(String var1) {
      this.bud_c16 = var1;
   }

   public String getBud_c17() {
      return this.bud_c17;
   }

   public void setBud_c17(String var1) {
      this.bud_c17 = var1;
   }

   public String getBud_c18() {
      return this.bud_c18;
   }

   public void setBud_c18(String var1) {
      this.bud_c18 = var1;
   }

   public String getBud_c2() {
      return this.bud_c2;
   }

   public void setBud_c2(String var1) {
      this.bud_c2 = var1;
   }

   public String getBud_c3() {
      return this.bud_c3;
   }

   public void setBud_c3(String var1) {
      this.bud_c3 = var1;
   }

   public String getBud_c4() {
      return this.bud_c4;
   }

   public void setBud_c4(String var1) {
      this.bud_c4 = var1;
   }

   public String getBud_c5() {
      return this.bud_c5;
   }

   public void setBud_c5(String var1) {
      this.bud_c5 = var1;
   }

   public String getBud_c6() {
      return this.bud_c6;
   }

   public void setBud_c6(String var1) {
      this.bud_c6 = var1;
   }

   public String getBud_c7() {
      return this.bud_c7;
   }

   public void setBud_c7(String var1) {
      this.bud_c7 = var1;
   }

   public String getBud_c8() {
      return this.bud_c8;
   }

   public void setBud_c8(String var1) {
      this.bud_c8 = var1;
   }

   public String getBud_c9() {
      return this.bud_c9;
   }

   public void setBud_c9(String var1) {
      this.bud_c9 = var1;
   }

   public String getBudget() {
      return this.budget;
   }

   public void setBudget(String var1) {
      this.budget = var1;
   }

   public String getColContrePartie() {
      return this.colContrePartie;
   }

   public void setColContrePartie(String var1) {
      this.colContrePartie = var1;
   }

   public String getColNumReference1() {
      return this.colNumReference1;
   }

   public void setColNumReference1(String var1) {
      this.colNumReference1 = var1;
   }

   public String getColNumReference2() {
      return this.colNumReference2;
   }

   public void setColNumReference2(String var1) {
      this.colNumReference2 = var1;
   }

   public String getCompte_treso() {
      return this.compte_treso;
   }

   public void setCompte_treso(String var1) {
      this.compte_treso = var1;
   }

   public String getNbcr() {
      return this.nbcr;
   }

   public void setNbcr(String var1) {
      this.nbcr = var1;
   }

   public String getTresorerie() {
      return this.tresorerie;
   }

   public void setTresorerie(String var1) {
      this.tresorerie = var1;
   }

   public String getTrf_brl() {
      return this.trf_brl;
   }

   public void setTrf_brl(String var1) {
      this.trf_brl = var1;
   }

   public String getTrf_cpte() {
      return this.trf_cpte;
   }

   public void setTrf_cpte(String var1) {
      this.trf_cpte = var1;
   }

   public String getTri_extrait() {
      return this.tri_extrait;
   }

   public void setTri_extrait(String var1) {
      this.tri_extrait = var1;
   }

   public String getTri_jrx() {
      return this.tri_jrx;
   }

   public void setTri_jrx(String var1) {
      this.tri_jrx = var1;
   }

   public String getTypelib() {
      return this.typelib;
   }

   public void setTypelib(String var1) {
      this.typelib = var1;
   }

   public String getAnal_c19() {
      return this.anal_c19;
   }

   public void setAnal_c19(String var1) {
      this.anal_c19 = var1;
   }

   public String getAnal_c20() {
      return this.anal_c20;
   }

   public void setAnal_c20(String var1) {
      this.anal_c20 = var1;
   }

   public String getAnal_c21() {
      return this.anal_c21;
   }

   public void setAnal_c21(String var1) {
      this.anal_c21 = var1;
   }

   public String getAnal_c22() {
      return this.anal_c22;
   }

   public void setAnal_c22(String var1) {
      this.anal_c22 = var1;
   }

   public String getAnal_c23() {
      return this.anal_c23;
   }

   public void setAnal_c23(String var1) {
      this.anal_c23 = var1;
   }

   public String getAnal_c24() {
      return this.anal_c24;
   }

   public void setAnal_c24(String var1) {
      this.anal_c24 = var1;
   }

   public String getBud_c19() {
      return this.bud_c19;
   }

   public void setBud_c19(String var1) {
      this.bud_c19 = var1;
   }

   public String getBud_c20() {
      return this.bud_c20;
   }

   public void setBud_c20(String var1) {
      this.bud_c20 = var1;
   }

   public String getBud_c21() {
      return this.bud_c21;
   }

   public void setBud_c21(String var1) {
      this.bud_c21 = var1;
   }

   public String getBud_c22() {
      return this.bud_c22;
   }

   public void setBud_c22(String var1) {
      this.bud_c22 = var1;
   }

   public String getBud_c23() {
      return this.bud_c23;
   }

   public void setBud_c23(String var1) {
      this.bud_c23 = var1;
   }

   public String getBud_c24() {
      return this.bud_c24;
   }

   public void setBud_c24(String var1) {
      this.bud_c24 = var1;
   }

   public boolean isGriserAnalytique() {
      return this.griserAnalytique;
   }

   public void setGriserAnalytique(boolean var1) {
      this.griserAnalytique = var1;
   }

   public String getAdresseFtp() {
      return this.adresseFtp;
   }

   public void setAdresseFtp(String var1) {
      this.adresseFtp = var1;
   }

   public String getLoginFtp() {
      return this.loginFtp;
   }

   public void setLoginFtp(String var1) {
      this.loginFtp = var1;
   }

   public String getPasswdFtp() {
      return this.passwdFtp;
   }

   public void setPasswdFtp(String var1) {
      this.passwdFtp = var1;
   }

   public String getPortFtp() {
      return this.portFtp;
   }

   public void setPortFtp(String var1) {
      this.portFtp = var1;
   }

   public String getNbLigneMaxBr() {
      return this.nbLigneMaxBr;
   }

   public void setNbLigneMaxBr(String var1) {
      this.nbLigneMaxBr = var1;
   }

   public String getNbLigneMaxEx() {
      return this.nbLigneMaxEx;
   }

   public void setNbLigneMaxEx(String var1) {
      this.nbLigneMaxEx = var1;
   }

   public String getNbLigneMaxJr() {
      return this.nbLigneMaxJr;
   }

   public void setNbLigneMaxJr(String var1) {
      this.nbLigneMaxJr = var1;
   }

   public String getNbLigneMaxAm() {
      return this.nbLigneMaxAm;
   }

   public void setNbLigneMaxAm(String var1) {
      this.nbLigneMaxAm = var1;
   }

   public String getNbLigneMaxBu() {
      return this.nbLigneMaxBu;
   }

   public void setNbLigneMaxBu(String var1) {
      this.nbLigneMaxBu = var1;
   }

   public String getNbLigneMaxLo() {
      return this.nbLigneMaxLo;
   }

   public void setNbLigneMaxLo(String var1) {
      this.nbLigneMaxLo = var1;
   }

   public String getEcartCredit() {
      return this.ecartCredit;
   }

   public void setEcartCredit(String var1) {
      this.ecartCredit = var1;
   }

   public String getEcartDebit() {
      return this.ecartDebit;
   }

   public void setEcartDebit(String var1) {
      this.ecartDebit = var1;
   }

   public String getDossierExport() {
      return this.dossierExport;
   }

   public void setDossierExport(String var1) {
      this.dossierExport = var1;
   }

   public String getClotureSansControle() {
      return this.clotureSansControle;
   }

   public void setClotureSansControle(String var1) {
      this.clotureSansControle = var1;
   }

   public String getTrf_cpteAchats() {
      return this.trf_cpteAchats;
   }

   public void setTrf_cpteAchats(String var1) {
      this.trf_cpteAchats = var1;
   }

   public String getTrf_cpteVentes() {
      return this.trf_cpteVentes;
   }

   public void setTrf_cpteVentes(String var1) {
      this.trf_cpteVentes = var1;
   }

   public String getTrf_cptePaye() {
      return this.trf_cptePaye;
   }

   public void setTrf_cptePaye(String var1) {
      this.trf_cptePaye = var1;
   }

   public String getTrf_cpteImmo() {
      return this.trf_cpteImmo;
   }

   public void setTrf_cpteImmo(String var1) {
      this.trf_cpteImmo = var1;
   }

   public String getPlanCpteLiasse() {
      return this.planCpteLiasse;
   }

   public void setPlanCpteLiasse(String var1) {
      this.planCpteLiasse = var1;
   }

   public String getCalculImmobilisation() {
      return this.calculImmobilisation;
   }

   public void setCalculImmobilisation(String var1) {
      this.calculImmobilisation = var1;
   }

   public String getClotureSansRappro() {
      return this.clotureSansRappro;
   }

   public void setClotureSansRappro(String var1) {
      this.clotureSansRappro = var1;
   }

   public String getClotureLettrage() {
      return this.clotureLettrage;
   }

   public void setClotureLettrage(String var1) {
      this.clotureLettrage = var1;
   }

   public String getClotureLettrageInutile() {
      return this.clotureLettrageInutile;
   }

   public void setClotureLettrageInutile(String var1) {
      this.clotureLettrageInutile = var1;
   }

   public String getCalculCompte() {
      return this.calculCompte;
   }

   public void setCalculCompte(String var1) {
      this.calculCompte = var1;
   }

   public String getCen_c20() {
      return this.cen_c20;
   }

   public void setCen_c20(String var1) {
      this.cen_c20 = var1;
   }

   public String getCen_c21() {
      return this.cen_c21;
   }

   public void setCen_c21(String var1) {
      this.cen_c21 = var1;
   }

   public String getCen_c22() {
      return this.cen_c22;
   }

   public void setCen_c22(String var1) {
      this.cen_c22 = var1;
   }

   public String getCen_c23() {
      return this.cen_c23;
   }

   public void setCen_c23(String var1) {
      this.cen_c23 = var1;
   }

   public String getCen_c24() {
      return this.cen_c24;
   }

   public void setCen_c24(String var1) {
      this.cen_c24 = var1;
   }

   public String getCen_c25() {
      return this.cen_c25;
   }

   public void setCen_c25(String var1) {
      this.cen_c25 = var1;
   }

   public String getCen_c26() {
      return this.cen_c26;
   }

   public void setCen_c26(String var1) {
      this.cen_c26 = var1;
   }

   public String getCen_c27() {
      return this.cen_c27;
   }

   public void setCen_c27(String var1) {
      this.cen_c27 = var1;
   }

   public String getCen_c28() {
      return this.cen_c28;
   }

   public void setCen_c28(String var1) {
      this.cen_c28 = var1;
   }

   public String getCen_c29() {
      return this.cen_c29;
   }

   public void setCen_c29(String var1) {
      this.cen_c29 = var1;
   }

   public String getCen_c30() {
      return this.cen_c30;
   }

   public void setCen_c30(String var1) {
      this.cen_c30 = var1;
   }

   public String getCen_c31() {
      return this.cen_c31;
   }

   public void setCen_c31(String var1) {
      this.cen_c31 = var1;
   }

   public String getCen_c32() {
      return this.cen_c32;
   }

   public void setCen_c32(String var1) {
      this.cen_c32 = var1;
   }

   public String getCen_c33() {
      return this.cen_c33;
   }

   public void setCen_c33(String var1) {
      this.cen_c33 = var1;
   }

   public String getCen_c34() {
      return this.cen_c34;
   }

   public void setCen_c34(String var1) {
      this.cen_c34 = var1;
   }

   public String getCen_c35() {
      return this.cen_c35;
   }

   public void setCen_c35(String var1) {
      this.cen_c35 = var1;
   }

   public String getCen_c36() {
      return this.cen_c36;
   }

   public void setCen_c36(String var1) {
      this.cen_c36 = var1;
   }

   public String getCen_c37() {
      return this.cen_c37;
   }

   public void setCen_c37(String var1) {
      this.cen_c37 = var1;
   }

   public String getCen_c38() {
      return this.cen_c38;
   }

   public void setCen_c38(String var1) {
      this.cen_c38 = var1;
   }

   public String getCen_c39() {
      return this.cen_c39;
   }

   public void setCen_c39(String var1) {
      this.cen_c39 = var1;
   }

   public String getCen_c40() {
      return this.cen_c40;
   }

   public void setCen_c40(String var1) {
      this.cen_c40 = var1;
   }

   public String getCen_c41() {
      return this.cen_c41;
   }

   public void setCen_c41(String var1) {
      this.cen_c41 = var1;
   }

   public String getCen_c42() {
      return this.cen_c42;
   }

   public void setCen_c42(String var1) {
      this.cen_c42 = var1;
   }

   public String getCen_c43() {
      return this.cen_c43;
   }

   public void setCen_c43(String var1) {
      this.cen_c43 = var1;
   }

   public String getCen_c44() {
      return this.cen_c44;
   }

   public void setCen_c44(String var1) {
      this.cen_c44 = var1;
   }

   public String getCen_c45() {
      return this.cen_c45;
   }

   public void setCen_c45(String var1) {
      this.cen_c45 = var1;
   }

   public String getCen_c46() {
      return this.cen_c46;
   }

   public void setCen_c46(String var1) {
      this.cen_c46 = var1;
   }

   public String getCen_c47() {
      return this.cen_c47;
   }

   public void setCen_c47(String var1) {
      this.cen_c47 = var1;
   }

   public String getCen_c48() {
      return this.cen_c48;
   }

   public void setCen_c48(String var1) {
      this.cen_c48 = var1;
   }

   public String getCen_c49() {
      return this.cen_c49;
   }

   public void setCen_c49(String var1) {
      this.cen_c49 = var1;
   }

   public String getTrf_rapprochement() {
      return this.trf_rapprochement;
   }

   public void setTrf_rapprochement(String var1) {
      this.trf_rapprochement = var1;
   }

   public String getSaisieAnalytique() {
      return this.saisieAnalytique;
   }

   public void setSaisieAnalytique(String var1) {
      this.saisieAnalytique = var1;
   }

   public String getExportOd() {
      return this.exportOd;
   }

   public void setExportOd(String var1) {
      this.exportOd = var1;
   }

   public String getAnalytiqueErreur() {
      return this.analytiqueErreur;
   }

   public void setAnalytiqueErreur(String var1) {
      this.analytiqueErreur = var1;
   }

   public String getAnalytiqueTransfert() {
      return this.analytiqueTransfert;
   }

   public void setAnalytiqueTransfert(String var1) {
      this.analytiqueTransfert = var1;
   }

   public String getClotureBackup() {
      return this.clotureBackup;
   }

   public void setClotureBackup(String var1) {
      this.clotureBackup = var1;
   }

   public String getVerrouImport() {
      return this.verrouImport;
   }

   public void setVerrouImport(String var1) {
      this.verrouImport = var1;
   }

   public String getNbcrExport() {
      return this.nbcrExport;
   }

   public void setNbcrExport(String var1) {
      this.nbcrExport = var1;
   }

   public String getBrouillardImport() {
      return this.brouillardImport;
   }

   public void setBrouillardImport(String var1) {
      this.brouillardImport = var1;
   }

   public String getTrf_rapprochementMode() {
      return this.trf_rapprochementMode;
   }

   public void setTrf_rapprochementMode(String var1) {
      this.trf_rapprochementMode = var1;
   }

   public String getTrf_cpteTreso() {
      return this.trf_cpteTreso;
   }

   public void setTrf_cpteTreso(String var1) {
      this.trf_cpteTreso = var1;
   }

   public String getMailClotureJournal() {
      return this.mailClotureJournal;
   }

   public void setMailClotureJournal(String var1) {
      this.mailClotureJournal = var1;
   }

   public String getMailClotureRappro() {
      return this.mailClotureRappro;
   }

   public void setMailClotureRappro(String var1) {
      this.mailClotureRappro = var1;
   }
}
