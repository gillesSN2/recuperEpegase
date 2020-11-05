package com.epegase.systeme.classe;

import java.io.Serializable;

public class ReunionPresence implements Serializable {
   private long reupreId;
   private String reupreNum;
   private long reupreIdUser;
   private String reupreNomUser;
   private String reuprePrenomUser;
   private String reupreCiviliteUser;
   private String reupreMotif;
   private boolean reupreSansStatut;
   private boolean reupreConvoquer;
   private boolean reuprePresent;
   private boolean reupreAbsentAutorise;
   private boolean reupreAbsentInterdit;
   private double reupreCaDevis;
   private double reupreObjectifDevis;
   private int reupreNbDocDevis;
   private double reupreCaTrfDevis;
   private int reupreNbTrfDevis;
   private int reupreNbJourDevis;
   private double reupreCaJourDevis;
   private int reupreNbClientDevis;
   private double reupreCaClientDevis;
   private int reupreSansSourceDevis;
   private double reupreCaBc;
   private double reupreObjectifBc;
   private int reupreNbDocBc;
   private double reupreCaTrfBc;
   private int reupreNbTrfBc;
   private int reupreNbJourBc;
   private double reupreCaJourBc;
   private int reupreNbClientBc;
   private double reupreCaClientBc;
   private double reupreCaBl;
   private double reupreObjectifBl;
   private int reupreSansSourceBc;
   private int reupreNbDocBl;
   private double reupreCaTrfBl;
   private int reupreNbTrfBl;
   private int reupreNbJourBl;
   private double reupreCaJourBl;
   private int reupreNbClientBl;
   private double reupreCaClientBl;
   private int reupreSansSourceBl;
   private double reupreCaBr;
   private double reupreObjectifBr;
   private int reupreNbDocBr;
   private double reupreCaTrfBr;
   private int reupreNbTrfBr;
   private int reupreNbJourBr;
   private double reupreCaJourBr;
   private int reupreNbClientBr;
   private double reupreCaClientBr;
   private int reupreSansSourceBr;
   private double reupreCaFa;
   private double reupreObjectifFa;
   private int reupreNbDocFa;
   private double reupreCaTrfFa;
   private int reupreNbTrfFa;
   private int reupreNbJourFa;
   private double reupreCaJourFa;
   private int reupreNbClientFa;
   private double reupreCaClientFa;
   private int reupreSansSourceFa;
   private double reupreCaNd;
   private double reupreObjectifNd;
   private int reupreNbDocNd;
   private double reupreCaTrfNd;
   private int reupreNbTrfNd;
   private int reupreNbJourNd;
   private double reupreCaJourNd;
   private int reupreNbClientNd;
   private double reupreCaClientNd;
   private int reupreSansSourceNd;
   private double reupreCaAv;
   private double reupreObjectifAv;
   private int reupreNbDocAv;
   private double reupreCaTrfAv;
   private int reupreNbTrfAv;
   private int reupreNbJourAv;
   private double reupreCaJourAv;
   private int reupreNbClientAv;
   private double reupreCaClientAv;
   private int reupreSansSourceAv;
   private int reupreNbRdv;
   private int reupreObjectifRdv;
   private int reupreNbRdvFait;
   private int reupreNbRdvNonFait;
   private int reupreNbRdvReport;
   private int reupreNbRdvAnnule;
   private ReunionEntete reunionEntete;

   public ReunionEntete getReunionEntete() {
      return this.reunionEntete;
   }

   public void setReunionEntete(ReunionEntete var1) {
      this.reunionEntete = var1;
   }

   public String getReupreCiviliteUser() {
      return this.reupreCiviliteUser;
   }

   public void setReupreCiviliteUser(String var1) {
      this.reupreCiviliteUser = var1;
   }

   public long getReupreId() {
      return this.reupreId;
   }

   public void setReupreId(long var1) {
      this.reupreId = var1;
   }

   public long getReupreIdUser() {
      return this.reupreIdUser;
   }

   public void setReupreIdUser(long var1) {
      this.reupreIdUser = var1;
   }

   public String getReupreNomUser() {
      return this.reupreNomUser;
   }

   public void setReupreNomUser(String var1) {
      this.reupreNomUser = var1;
   }

   public String getReupreNum() {
      return this.reupreNum;
   }

   public void setReupreNum(String var1) {
      this.reupreNum = var1;
   }

   public String getReuprePrenomUser() {
      return this.reuprePrenomUser;
   }

   public void setReuprePrenomUser(String var1) {
      this.reuprePrenomUser = var1;
   }

   public String getReupreMotif() {
      return this.reupreMotif;
   }

   public void setReupreMotif(String var1) {
      this.reupreMotif = var1;
   }

   public boolean isReupreAbsentAutorise() {
      return this.reupreAbsentAutorise;
   }

   public void setReupreAbsentAutorise(boolean var1) {
      this.reupreAbsentAutorise = var1;
   }

   public boolean isReupreAbsentInterdit() {
      return this.reupreAbsentInterdit;
   }

   public void setReupreAbsentInterdit(boolean var1) {
      this.reupreAbsentInterdit = var1;
   }

   public boolean isReupreConvoquer() {
      return this.reupreConvoquer;
   }

   public void setReupreConvoquer(boolean var1) {
      this.reupreConvoquer = var1;
   }

   public boolean isReuprePresent() {
      return this.reuprePresent;
   }

   public void setReuprePresent(boolean var1) {
      this.reuprePresent = var1;
   }

   public boolean isReupreSansStatut() {
      return this.reupreSansStatut;
   }

   public void setReupreSansStatut(boolean var1) {
      this.reupreSansStatut = var1;
   }

   public double getReupreCaAv() {
      return this.reupreCaAv;
   }

   public void setReupreCaAv(double var1) {
      this.reupreCaAv = var1;
   }

   public double getReupreCaBc() {
      return this.reupreCaBc;
   }

   public void setReupreCaBc(double var1) {
      this.reupreCaBc = var1;
   }

   public double getReupreCaBl() {
      return this.reupreCaBl;
   }

   public void setReupreCaBl(double var1) {
      this.reupreCaBl = var1;
   }

   public double getReupreCaBr() {
      return this.reupreCaBr;
   }

   public void setReupreCaBr(double var1) {
      this.reupreCaBr = var1;
   }

   public double getReupreCaClientAv() {
      return this.reupreCaClientAv;
   }

   public void setReupreCaClientAv(double var1) {
      this.reupreCaClientAv = var1;
   }

   public double getReupreCaClientBc() {
      return this.reupreCaClientBc;
   }

   public void setReupreCaClientBc(double var1) {
      this.reupreCaClientBc = var1;
   }

   public double getReupreCaClientBl() {
      return this.reupreCaClientBl;
   }

   public void setReupreCaClientBl(double var1) {
      this.reupreCaClientBl = var1;
   }

   public double getReupreCaClientBr() {
      return this.reupreCaClientBr;
   }

   public void setReupreCaClientBr(double var1) {
      this.reupreCaClientBr = var1;
   }

   public double getReupreCaClientDevis() {
      return this.reupreCaClientDevis;
   }

   public void setReupreCaClientDevis(double var1) {
      this.reupreCaClientDevis = var1;
   }

   public double getReupreCaClientFa() {
      return this.reupreCaClientFa;
   }

   public void setReupreCaClientFa(double var1) {
      this.reupreCaClientFa = var1;
   }

   public double getReupreCaClientNd() {
      return this.reupreCaClientNd;
   }

   public void setReupreCaClientNd(double var1) {
      this.reupreCaClientNd = var1;
   }

   public double getReupreCaDevis() {
      return this.reupreCaDevis;
   }

   public void setReupreCaDevis(double var1) {
      this.reupreCaDevis = var1;
   }

   public double getReupreCaFa() {
      return this.reupreCaFa;
   }

   public void setReupreCaFa(double var1) {
      this.reupreCaFa = var1;
   }

   public double getReupreCaJourAv() {
      return this.reupreCaJourAv;
   }

   public void setReupreCaJourAv(double var1) {
      this.reupreCaJourAv = var1;
   }

   public double getReupreCaJourBc() {
      return this.reupreCaJourBc;
   }

   public void setReupreCaJourBc(double var1) {
      this.reupreCaJourBc = var1;
   }

   public double getReupreCaJourBl() {
      return this.reupreCaJourBl;
   }

   public void setReupreCaJourBl(double var1) {
      this.reupreCaJourBl = var1;
   }

   public double getReupreCaJourBr() {
      return this.reupreCaJourBr;
   }

   public void setReupreCaJourBr(double var1) {
      this.reupreCaJourBr = var1;
   }

   public double getReupreCaJourDevis() {
      return this.reupreCaJourDevis;
   }

   public void setReupreCaJourDevis(double var1) {
      this.reupreCaJourDevis = var1;
   }

   public double getReupreCaJourFa() {
      return this.reupreCaJourFa;
   }

   public void setReupreCaJourFa(double var1) {
      this.reupreCaJourFa = var1;
   }

   public double getReupreCaJourNd() {
      return this.reupreCaJourNd;
   }

   public void setReupreCaJourNd(double var1) {
      this.reupreCaJourNd = var1;
   }

   public double getReupreCaNd() {
      return this.reupreCaNd;
   }

   public void setReupreCaNd(double var1) {
      this.reupreCaNd = var1;
   }

   public double getReupreCaTrfAv() {
      return this.reupreCaTrfAv;
   }

   public void setReupreCaTrfAv(double var1) {
      this.reupreCaTrfAv = var1;
   }

   public double getReupreCaTrfBc() {
      return this.reupreCaTrfBc;
   }

   public void setReupreCaTrfBc(double var1) {
      this.reupreCaTrfBc = var1;
   }

   public double getReupreCaTrfBl() {
      return this.reupreCaTrfBl;
   }

   public void setReupreCaTrfBl(double var1) {
      this.reupreCaTrfBl = var1;
   }

   public double getReupreCaTrfBr() {
      return this.reupreCaTrfBr;
   }

   public void setReupreCaTrfBr(double var1) {
      this.reupreCaTrfBr = var1;
   }

   public double getReupreCaTrfDevis() {
      return this.reupreCaTrfDevis;
   }

   public void setReupreCaTrfDevis(double var1) {
      this.reupreCaTrfDevis = var1;
   }

   public double getReupreCaTrfNd() {
      return this.reupreCaTrfNd;
   }

   public void setReupreCaTrfNd(double var1) {
      this.reupreCaTrfNd = var1;
   }

   public double getReupreCaTrfFa() {
      return this.reupreCaTrfFa;
   }

   public void setReupreCaTrfFa(double var1) {
      this.reupreCaTrfFa = var1;
   }

   public int getReupreNbClientAv() {
      return this.reupreNbClientAv;
   }

   public void setReupreNbClientAv(int var1) {
      this.reupreNbClientAv = var1;
   }

   public int getReupreNbClientBc() {
      return this.reupreNbClientBc;
   }

   public void setReupreNbClientBc(int var1) {
      this.reupreNbClientBc = var1;
   }

   public int getReupreNbClientBl() {
      return this.reupreNbClientBl;
   }

   public void setReupreNbClientBl(int var1) {
      this.reupreNbClientBl = var1;
   }

   public int getReupreNbClientBr() {
      return this.reupreNbClientBr;
   }

   public void setReupreNbClientBr(int var1) {
      this.reupreNbClientBr = var1;
   }

   public int getReupreNbClientDevis() {
      return this.reupreNbClientDevis;
   }

   public void setReupreNbClientDevis(int var1) {
      this.reupreNbClientDevis = var1;
   }

   public int getReupreNbClientFa() {
      return this.reupreNbClientFa;
   }

   public void setReupreNbClientFa(int var1) {
      this.reupreNbClientFa = var1;
   }

   public int getReupreNbClientNd() {
      return this.reupreNbClientNd;
   }

   public void setReupreNbClientNd(int var1) {
      this.reupreNbClientNd = var1;
   }

   public int getReupreNbDocAv() {
      return this.reupreNbDocAv;
   }

   public void setReupreNbDocAv(int var1) {
      this.reupreNbDocAv = var1;
   }

   public int getReupreNbDocBc() {
      return this.reupreNbDocBc;
   }

   public void setReupreNbDocBc(int var1) {
      this.reupreNbDocBc = var1;
   }

   public int getReupreNbDocBl() {
      return this.reupreNbDocBl;
   }

   public void setReupreNbDocBl(int var1) {
      this.reupreNbDocBl = var1;
   }

   public int getReupreNbDocBr() {
      return this.reupreNbDocBr;
   }

   public void setReupreNbDocBr(int var1) {
      this.reupreNbDocBr = var1;
   }

   public int getReupreNbDocDevis() {
      return this.reupreNbDocDevis;
   }

   public void setReupreNbDocDevis(int var1) {
      this.reupreNbDocDevis = var1;
   }

   public int getReupreNbDocFa() {
      return this.reupreNbDocFa;
   }

   public void setReupreNbDocFa(int var1) {
      this.reupreNbDocFa = var1;
   }

   public int getReupreNbDocNd() {
      return this.reupreNbDocNd;
   }

   public void setReupreNbDocNd(int var1) {
      this.reupreNbDocNd = var1;
   }

   public int getReupreNbJourAv() {
      return this.reupreNbJourAv;
   }

   public void setReupreNbJourAv(int var1) {
      this.reupreNbJourAv = var1;
   }

   public int getReupreNbJourBc() {
      return this.reupreNbJourBc;
   }

   public void setReupreNbJourBc(int var1) {
      this.reupreNbJourBc = var1;
   }

   public int getReupreNbJourBl() {
      return this.reupreNbJourBl;
   }

   public void setReupreNbJourBl(int var1) {
      this.reupreNbJourBl = var1;
   }

   public int getReupreNbJourBr() {
      return this.reupreNbJourBr;
   }

   public void setReupreNbJourBr(int var1) {
      this.reupreNbJourBr = var1;
   }

   public int getReupreNbJourDevis() {
      return this.reupreNbJourDevis;
   }

   public void setReupreNbJourDevis(int var1) {
      this.reupreNbJourDevis = var1;
   }

   public int getReupreNbJourFa() {
      return this.reupreNbJourFa;
   }

   public void setReupreNbJourFa(int var1) {
      this.reupreNbJourFa = var1;
   }

   public int getReupreNbJourNd() {
      return this.reupreNbJourNd;
   }

   public void setReupreNbJourNd(int var1) {
      this.reupreNbJourNd = var1;
   }

   public int getReupreNbTrfAv() {
      return this.reupreNbTrfAv;
   }

   public void setReupreNbTrfAv(int var1) {
      this.reupreNbTrfAv = var1;
   }

   public int getReupreNbTrfBc() {
      return this.reupreNbTrfBc;
   }

   public void setReupreNbTrfBc(int var1) {
      this.reupreNbTrfBc = var1;
   }

   public int getReupreNbTrfBl() {
      return this.reupreNbTrfBl;
   }

   public void setReupreNbTrfBl(int var1) {
      this.reupreNbTrfBl = var1;
   }

   public int getReupreNbTrfBr() {
      return this.reupreNbTrfBr;
   }

   public void setReupreNbTrfBr(int var1) {
      this.reupreNbTrfBr = var1;
   }

   public int getReupreNbTrfDevis() {
      return this.reupreNbTrfDevis;
   }

   public void setReupreNbTrfDevis(int var1) {
      this.reupreNbTrfDevis = var1;
   }

   public int getReupreNbTrfFa() {
      return this.reupreNbTrfFa;
   }

   public void setReupreNbTrfFa(int var1) {
      this.reupreNbTrfFa = var1;
   }

   public int getReupreNbTrfNd() {
      return this.reupreNbTrfNd;
   }

   public void setReupreNbTrfNd(int var1) {
      this.reupreNbTrfNd = var1;
   }

   public int getReupreNbRdv() {
      return this.reupreNbRdv;
   }

   public void setReupreNbRdv(int var1) {
      this.reupreNbRdv = var1;
   }

   public int getReupreNbRdvAnnule() {
      return this.reupreNbRdvAnnule;
   }

   public void setReupreNbRdvAnnule(int var1) {
      this.reupreNbRdvAnnule = var1;
   }

   public int getReupreNbRdvFait() {
      return this.reupreNbRdvFait;
   }

   public void setReupreNbRdvFait(int var1) {
      this.reupreNbRdvFait = var1;
   }

   public int getReupreNbRdvNonFait() {
      return this.reupreNbRdvNonFait;
   }

   public void setReupreNbRdvNonFait(int var1) {
      this.reupreNbRdvNonFait = var1;
   }

   public int getReupreNbRdvReport() {
      return this.reupreNbRdvReport;
   }

   public void setReupreNbRdvReport(int var1) {
      this.reupreNbRdvReport = var1;
   }

   public double getReupreObjectifAv() {
      return this.reupreObjectifAv;
   }

   public void setReupreObjectifAv(double var1) {
      this.reupreObjectifAv = var1;
   }

   public double getReupreObjectifBc() {
      return this.reupreObjectifBc;
   }

   public void setReupreObjectifBc(double var1) {
      this.reupreObjectifBc = var1;
   }

   public double getReupreObjectifBl() {
      return this.reupreObjectifBl;
   }

   public void setReupreObjectifBl(double var1) {
      this.reupreObjectifBl = var1;
   }

   public double getReupreObjectifBr() {
      return this.reupreObjectifBr;
   }

   public void setReupreObjectifBr(double var1) {
      this.reupreObjectifBr = var1;
   }

   public double getReupreObjectifDevis() {
      return this.reupreObjectifDevis;
   }

   public void setReupreObjectifDevis(double var1) {
      this.reupreObjectifDevis = var1;
   }

   public double getReupreObjectifFa() {
      return this.reupreObjectifFa;
   }

   public void setReupreObjectifFa(double var1) {
      this.reupreObjectifFa = var1;
   }

   public double getReupreObjectifNd() {
      return this.reupreObjectifNd;
   }

   public void setReupreObjectifNd(double var1) {
      this.reupreObjectifNd = var1;
   }

   public int getReupreObjectifRdv() {
      return this.reupreObjectifRdv;
   }

   public void setReupreObjectifRdv(int var1) {
      this.reupreObjectifRdv = var1;
   }

   public int getReupreSansSourceAv() {
      return this.reupreSansSourceAv;
   }

   public void setReupreSansSourceAv(int var1) {
      this.reupreSansSourceAv = var1;
   }

   public int getReupreSansSourceBc() {
      return this.reupreSansSourceBc;
   }

   public void setReupreSansSourceBc(int var1) {
      this.reupreSansSourceBc = var1;
   }

   public int getReupreSansSourceBl() {
      return this.reupreSansSourceBl;
   }

   public void setReupreSansSourceBl(int var1) {
      this.reupreSansSourceBl = var1;
   }

   public int getReupreSansSourceBr() {
      return this.reupreSansSourceBr;
   }

   public void setReupreSansSourceBr(int var1) {
      this.reupreSansSourceBr = var1;
   }

   public int getReupreSansSourceDevis() {
      return this.reupreSansSourceDevis;
   }

   public void setReupreSansSourceDevis(int var1) {
      this.reupreSansSourceDevis = var1;
   }

   public int getReupreSansSourceFa() {
      return this.reupreSansSourceFa;
   }

   public void setReupreSansSourceFa(int var1) {
      this.reupreSansSourceFa = var1;
   }

   public int getReupreSansSourceNd() {
      return this.reupreSansSourceNd;
   }

   public void setReupreSansSourceNd(int var1) {
      this.reupreSansSourceNd = var1;
   }
}
