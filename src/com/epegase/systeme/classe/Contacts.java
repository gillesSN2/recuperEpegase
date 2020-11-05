package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Contacts implements Serializable {
   private long conid;
   private Date condatecreat;
   private Date condatemodif;
   private long conusercreat;
   private long conusermodif;
   private int conetat;
   private String connom;
   private String conprenom;
   private String conpatronyme;
   private String conPwEspaceClient;
   private String concivilite;
   private String connompays;
   private String conlangue;
   private String confonction;
   private String conservice;
   private Date condatenaissance;
   private String conanniversaire;
   private String contelbur;
   private String conteldom;
   private String concel1;
   private String concel2;
   private String concel3;
   private String confax;
   private String conadresse;
   private String conrue;
   private String conlot;
   private String conilot;
   private String conbatiment;
   private String conporte;
   private String conescalier;
   private String conascensseur;
   private String conquartier;
   private String concommune;
   private String condeparte;
   private String conzone;
   private String conbp;
   private String concedex;
   private String conville;
   private String conyahoo;
   private String conmsn;
   private String conskype;
   private String conaol;
   private String conmail1;
   private String conmail2;
   private String conmail3;
   private String conmail4;
   private String conmail5;
   private String conblog;
   private String conweb;
   private String conobservation;
   private String conappreciation;
   private String connumbanque;
   private String conguichetbanque;
   private String concomptebanque;
   private String conclebanque;
   private String conrefbanque;
   private String coniban;
   private String conswift;
   private String conJournal;
   private int conType;
   private String conCiNum;
   private String conCiPar;
   private Date conCiDateDebut;
   private Date conCiDateFin;
   private String conPhoto;
   private String conSignature;
   private Tiers tiers;
   private String mailgeneric;
   private boolean select;
   private String mailCumul;

   public String getMailCumul() {
      if (this.conmail1 != null && !this.conmail1.isEmpty()) {
         this.mailCumul = this.conmail1;
      } else if (this.conmail2 != null && !this.conmail2.isEmpty()) {
         this.mailCumul = this.conmail2;
      } else if (this.conmail3 != null && !this.conmail3.isEmpty()) {
         this.mailCumul = this.conmail3;
      } else if (this.conmail4 != null && !this.conmail4.isEmpty()) {
         this.mailCumul = this.conmail4;
      } else if (this.conmail5 != null && !this.conmail5.isEmpty()) {
         this.mailCumul = this.conmail5;
      }

      return this.mailCumul;
   }

   public void setMailCumul(String var1) {
      this.mailCumul = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public String getConadresse() {
      return this.conadresse;
   }

   public void setConadresse(String var1) {
      this.conadresse = var1;
   }

   public String getConanniversaire() {
      return this.conanniversaire;
   }

   public void setConanniversaire(String var1) {
      this.conanniversaire = var1;
   }

   public String getConaol() {
      return this.conaol;
   }

   public void setConaol(String var1) {
      this.conaol = var1;
   }

   public String getConascensseur() {
      return this.conascensseur;
   }

   public void setConascensseur(String var1) {
      this.conascensseur = var1;
   }

   public String getConbatiment() {
      return this.conbatiment;
   }

   public void setConbatiment(String var1) {
      this.conbatiment = var1;
   }

   public String getConblog() {
      return this.conblog;
   }

   public void setConblog(String var1) {
      this.conblog = var1;
   }

   public String getConbp() {
      return this.conbp;
   }

   public void setConbp(String var1) {
      this.conbp = var1;
   }

   public String getConcedex() {
      return this.concedex;
   }

   public void setConcedex(String var1) {
      this.concedex = var1;
   }

   public String getConcel1() {
      return this.concel1;
   }

   public void setConcel1(String var1) {
      this.concel1 = var1;
   }

   public String getConcel2() {
      return this.concel2;
   }

   public void setConcel2(String var1) {
      this.concel2 = var1;
   }

   public String getConcel3() {
      return this.concel3;
   }

   public void setConcel3(String var1) {
      this.concel3 = var1;
   }

   public String getConcivilite() {
      return this.concivilite;
   }

   public void setConcivilite(String var1) {
      this.concivilite = var1;
   }

   public String getConcommune() {
      return this.concommune;
   }

   public void setConcommune(String var1) {
      this.concommune = var1;
   }

   public Date getCondatecreat() {
      return this.condatecreat;
   }

   public void setCondatecreat(Date var1) {
      this.condatecreat = var1;
   }

   public Date getCondatemodif() {
      return this.condatemodif;
   }

   public void setCondatemodif(Date var1) {
      this.condatemodif = var1;
   }

   public Date getCondatenaissance() {
      return this.condatenaissance;
   }

   public void setCondatenaissance(Date var1) {
      this.condatenaissance = var1;
   }

   public String getCondeparte() {
      return this.condeparte;
   }

   public void setCondeparte(String var1) {
      this.condeparte = var1;
   }

   public String getConescalier() {
      return this.conescalier;
   }

   public void setConescalier(String var1) {
      this.conescalier = var1;
   }

   public int getConetat() {
      return this.conetat;
   }

   public void setConetat(int var1) {
      this.conetat = var1;
   }

   public String getConfax() {
      return this.confax;
   }

   public void setConfax(String var1) {
      this.confax = var1;
   }

   public String getConfonction() {
      return this.confonction;
   }

   public void setConfonction(String var1) {
      this.confonction = var1;
   }

   public long getConid() {
      return this.conid;
   }

   public void setConid(long var1) {
      this.conid = var1;
   }

   public String getConlangue() {
      return this.conlangue;
   }

   public void setConlangue(String var1) {
      this.conlangue = var1;
   }

   public String getConlot() {
      return this.conlot;
   }

   public void setConlot(String var1) {
      this.conlot = var1;
   }

   public String getConmail1() {
      return this.conmail1;
   }

   public void setConmail1(String var1) {
      this.conmail1 = var1;
   }

   public String getConmail2() {
      return this.conmail2;
   }

   public void setConmail2(String var1) {
      this.conmail2 = var1;
   }

   public String getConmail3() {
      return this.conmail3;
   }

   public void setConmail3(String var1) {
      this.conmail3 = var1;
   }

   public String getConmail4() {
      return this.conmail4;
   }

   public void setConmail4(String var1) {
      this.conmail4 = var1;
   }

   public String getConmsn() {
      return this.conmsn;
   }

   public void setConmsn(String var1) {
      this.conmsn = var1;
   }

   public String getConnom() {
      if (this.connom != null && !this.connom.isEmpty()) {
         this.connom = this.connom.toUpperCase();
      }

      return this.connom;
   }

   public void setConnom(String var1) {
      this.connom = var1;
   }

   public String getConnompays() {
      return this.connompays;
   }

   public void setConnompays(String var1) {
      this.connompays = var1;
   }

   public String getConporte() {
      return this.conporte;
   }

   public void setConporte(String var1) {
      this.conporte = var1;
   }

   public String getConprenom() {
      return this.conprenom;
   }

   public void setConprenom(String var1) {
      this.conprenom = var1;
   }

   public String getConquartier() {
      return this.conquartier;
   }

   public void setConquartier(String var1) {
      this.conquartier = var1;
   }

   public String getConrue() {
      return this.conrue;
   }

   public void setConrue(String var1) {
      this.conrue = var1;
   }

   public String getConservice() {
      return this.conservice;
   }

   public void setConservice(String var1) {
      this.conservice = var1;
   }

   public String getConskype() {
      return this.conskype;
   }

   public void setConskype(String var1) {
      this.conskype = var1;
   }

   public String getContelbur() {
      return this.contelbur;
   }

   public void setContelbur(String var1) {
      this.contelbur = var1;
   }

   public String getConteldom() {
      return this.conteldom;
   }

   public void setConteldom(String var1) {
      this.conteldom = var1;
   }

   public long getConusercreat() {
      return this.conusercreat;
   }

   public void setConusercreat(long var1) {
      this.conusercreat = var1;
   }

   public long getConusermodif() {
      return this.conusermodif;
   }

   public void setConusermodif(long var1) {
      this.conusermodif = var1;
   }

   public String getConville() {
      return this.conville;
   }

   public void setConville(String var1) {
      this.conville = var1;
   }

   public String getConweb() {
      return this.conweb;
   }

   public void setConweb(String var1) {
      this.conweb = var1;
   }

   public String getConyahoo() {
      return this.conyahoo;
   }

   public void setConyahoo(String var1) {
      this.conyahoo = var1;
   }

   public String getConzone() {
      return this.conzone;
   }

   public void setConzone(String var1) {
      this.conzone = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public String getConilot() {
      return this.conilot;
   }

   public void setConilot(String var1) {
      this.conilot = var1;
   }

   public String getConappreciation() {
      return this.conappreciation;
   }

   public void setConappreciation(String var1) {
      this.conappreciation = var1;
   }

   public String getConobservation() {
      return this.conobservation;
   }

   public void setConobservation(String var1) {
      this.conobservation = var1;
   }

   public String getConclebanque() {
      return this.conclebanque;
   }

   public void setConclebanque(String var1) {
      this.conclebanque = var1;
   }

   public String getConcomptebanque() {
      return this.concomptebanque;
   }

   public void setConcomptebanque(String var1) {
      this.concomptebanque = var1;
   }

   public String getConguichetbanque() {
      return this.conguichetbanque;
   }

   public void setConguichetbanque(String var1) {
      this.conguichetbanque = var1;
   }

   public String getConiban() {
      return this.coniban;
   }

   public void setConiban(String var1) {
      this.coniban = var1;
   }

   public String getConnumbanque() {
      return this.connumbanque;
   }

   public void setConnumbanque(String var1) {
      this.connumbanque = var1;
   }

   public String getConswift() {
      return this.conswift;
   }

   public void setConswift(String var1) {
      this.conswift = var1;
   }

   public String getMailgeneric() {
      return this.mailgeneric;
   }

   public void setMailgeneric(String var1) {
      this.mailgeneric = var1;
   }

   public String getConmail5() {
      return this.conmail5;
   }

   public void setConmail5(String var1) {
      this.conmail5 = var1;
   }

   public String getConpatronyme() {
      return this.conpatronyme;
   }

   public void setConpatronyme(String var1) {
      this.conpatronyme = var1;
   }

   public String getConJournal() {
      return this.conJournal;
   }

   public void setConJournal(String var1) {
      this.conJournal = var1;
   }

   public String getConPwEspaceClient() {
      return this.conPwEspaceClient;
   }

   public void setConPwEspaceClient(String var1) {
      this.conPwEspaceClient = var1;
   }

   public int getConType() {
      return this.conType;
   }

   public void setConType(int var1) {
      this.conType = var1;
   }

   public Date getConCiDateDebut() {
      return this.conCiDateDebut;
   }

   public void setConCiDateDebut(Date var1) {
      this.conCiDateDebut = var1;
   }

   public Date getConCiDateFin() {
      return this.conCiDateFin;
   }

   public void setConCiDateFin(Date var1) {
      this.conCiDateFin = var1;
   }

   public String getConCiNum() {
      return this.conCiNum;
   }

   public void setConCiNum(String var1) {
      this.conCiNum = var1;
   }

   public String getConCiPar() {
      return this.conCiPar;
   }

   public void setConCiPar(String var1) {
      this.conCiPar = var1;
   }

   public String getConPhoto() {
      return this.conPhoto;
   }

   public void setConPhoto(String var1) {
      this.conPhoto = var1;
   }

   public String getConSignature() {
      return this.conSignature;
   }

   public void setConSignature(String var1) {
      this.conSignature = var1;
   }

   public String getConrefbanque() {
      return this.conrefbanque;
   }

   public void setConrefbanque(String var1) {
      this.conrefbanque = var1;
   }
}
