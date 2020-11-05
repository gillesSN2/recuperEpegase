package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Structure implements Serializable {
   private int strECommerceVal;
   private long strid;
   private Date strdtecreat;
   private Date strdtemodif;
   private long strusercreat;
   private long strusermodif;
   private Integer stretat;
   private Integer strmode;
   private int strmaitrecabinet;
   private String strraisonsociale;
   private String strdescriptif;
   private String strsigle;
   private String strnompays;
   private String strcodepays;
   private String strisopays;
   private int strMeteoCodeVille;
   private String strdevise;
   private int strsitedevise;
   private String strlangue;
   private String strzonefiscale;
   private String strzonefiscale2;
   private Date strdatefiscale2;
   private String strzonecommerciale;
   private String strbilansocial;
   private String strformatdate;
   private String strformatheure;
   private String strHrDeb;
   private String strMnDeb;
   private String strHrPas;
   private String strMnPas;
   private String strHrFin;
   private String strMnFin;
   private String strformejuridique;
   private String strtypeentreprise;
   private String stradresse;
   private String strrue;
   private String strlot;
   private String strporte;
   private String strquartier;
   private String strville;
   private String strcommune;
   private String strdepartement;
   private String strzone;
   private String strbatiment;
   private String stretage;
   private String strbp;
   private String strcedex;
   private String strtel1;
   private String strtel2;
   private String strtel3;
   private String strfax;
   private String strtelex;
   private String strsitewzb;
   private String stradresseserveur;
   private String strrepertoire;
   private String stractiviteCommerciale;
   private String strmod1;
   private String strmod2;
   private String strmod3;
   private String strmod4;
   private String strmod5;
   private String strmod6;
   private String strmod7;
   private String strmod8;
   private String strmod9;
   private String strmod10;
   private String strnum1;
   private String strnum2;
   private String strnum3;
   private String strnum4;
   private String strnum5;
   private String strnum6;
   private String strnum7;
   private String strnum8;
   private String strnum9;
   private String strnum10;
   private String strnum11;
   private String strnum12;
   private String strnum13;
   private String strnum14;
   private String strnum15;
   private String strnum16;
   private String strnum17;
   private String strnum18;
   private String strnum19;
   private String strnum20;
   private String strLogo1;
   private String strLogo2;
   private String strLogo3;
   private String strLogo4;
   private String strLogo5;
   private String strLogo6;
   private String strLogo7;
   private String strLogo8;
   private String strLogo9;
   private String strLogo10;
   private int strformatdevise;
   private int strtypeContact;
   private String strdomaine;
   private String strip;
   private String strnombd;
   private String strlogbd;
   private String strpwbd;
   private String strrepimage;
   private String strRepDocument;
   private String strRepConfiguration;
   private String strRepSource;
   private String strResponsable;
   private String strQualiteResponsable;
   private String strCapital;
   private boolean strStructure;
   private boolean strChantier;
   private boolean strMission;
   private boolean strSite;
   private boolean strRegion;
   private boolean strUsine;
   private boolean strActivite;
   private int strActiviteModeSasie;
   private boolean strParc;
   private int strDossier;
   private int strChainageAxes;
   private boolean strAgent;
   private boolean strCles;
   private boolean strProjet;
   private String strQuart1DebutHeure;
   private String strQuart1DebutMinute;
   private String strQuart1FinHeure;
   private String strQuart1FinMinute;
   private String strQuart2FinHeure;
   private String strQuart2FinMinute;
   private String strQuart3FinHeure;
   private String strQuart3FinMinute;
   private String strBanqueDefaut;
   private Date strDteDebMandat;
   private Date strDteFinMandat;
   private int strEtatMandat;
   private String stradressemail;
   private String stradressemailreponse;
   private String strpw;
   private String strpopserveur;
   private int strpopport;
   private int strpopauthentification;
   private int strssl;
   private int strpopexemplaire;
   private String strimapserveur;
   private int strimapport;
   private String strsmtpserveur;
   private int strsmtpport;
   private int strsmtauthentification;
   private int strsmtChoix;
   private String strSignature;
   private int strClusterMap;
   private int strHangout;
   private int strAddInto;
   private int strGoogleTraduction;
   private String strappDropbox;
   private int strmajcabinet;
   private String strbistriLink;
   private int strstockNegatif;
   private int strDepotStock;
   private String strcpteorange;
   private String strcptebicitel;
   private int strNumSecuMultiple;
   private int strNumRetraiteMultiple;
   private String strcpteuniversign;
   private String strpwuniversign;
   private String codeIso;
   private String nomVille;
   private String nomPays;
   private String strCode1;
   private String strLib1;
   private String strCode2;
   private String strLib2;
   private String strCode3;
   private String strLib3;
   private boolean afficheUniverSign;

   public boolean isAfficheUniverSign() {
      if (this.getStrcpteuniversign() != null && !this.getStrcpteuniversign().isEmpty() && this.getStrpwuniversign() != null && !this.getStrpwuniversign().isEmpty()) {
         this.afficheUniverSign = true;
      } else {
         this.afficheUniverSign = false;
      }

      return this.afficheUniverSign;
   }

   public void setAfficheUniverSign(boolean var1) {
      this.afficheUniverSign = var1;
   }

   public String getCodeIso() {
      this.codeIso = this.strisopays.toLowerCase();
      return this.codeIso;
   }

   public void setCodeIso(String var1) {
      this.codeIso = var1;
   }

   public String getNomPays() {
      this.nomPays = this.strnompays.toLowerCase();
      return this.nomPays;
   }

   public void setNomPays(String var1) {
      this.nomPays = var1;
   }

   public String getNomVille() {
      this.nomVille = this.strville.toLowerCase();
      return this.nomVille;
   }

   public void setNomVille(String var1) {
      this.nomVille = var1;
   }

   public String getStradresse() {
      return this.stradresse;
   }

   public void setStradresse(String var1) {
      this.stradresse = var1;
   }

   public String getStradresseserveur() {
      return this.stradresseserveur;
   }

   public void setStradresseserveur(String var1) {
      this.stradresseserveur = var1;
   }

   public String getStrbatiment() {
      return this.strbatiment;
   }

   public void setStrbatiment(String var1) {
      this.strbatiment = var1;
   }

   public String getStrbp() {
      return this.strbp;
   }

   public void setStrbp(String var1) {
      this.strbp = var1;
   }

   public String getStrcedex() {
      return this.strcedex;
   }

   public void setStrcedex(String var1) {
      this.strcedex = var1;
   }

   public String getStrcommune() {
      return this.strcommune;
   }

   public void setStrcommune(String var1) {
      this.strcommune = var1;
   }

   public String getStrdepartement() {
      return this.strdepartement;
   }

   public void setStrdepartement(String var1) {
      this.strdepartement = var1;
   }

   public String getStrdevise() {
      return this.strdevise;
   }

   public void setStrdevise(String var1) {
      this.strdevise = var1;
   }

   public Date getStrdtecreat() {
      return this.strdtecreat;
   }

   public void setStrdtecreat(Date var1) {
      this.strdtecreat = var1;
   }

   public Date getStrdtemodif() {
      return this.strdtemodif;
   }

   public void setStrdtemodif(Date var1) {
      this.strdtemodif = var1;
   }

   public Integer getStretat() {
      return this.stretat;
   }

   public void setStretat(Integer var1) {
      this.stretat = var1;
   }

   public String getStrfax() {
      return this.strfax;
   }

   public void setStrfax(String var1) {
      this.strfax = var1;
   }

   public String getStrformatdate() {
      return this.strformatdate;
   }

   public void setStrformatdate(String var1) {
      this.strformatdate = var1;
   }

   public String getStrformatheure() {
      return this.strformatheure;
   }

   public void setStrformatheure(String var1) {
      this.strformatheure = var1;
   }

   public String getStrformejuridique() {
      return this.strformejuridique;
   }

   public void setStrformejuridique(String var1) {
      this.strformejuridique = var1;
   }

   public long getStrid() {
      return this.strid;
   }

   public void setStrid(long var1) {
      this.strid = var1;
   }

   public String getStrlangue() {
      return this.strlangue;
   }

   public void setStrlangue(String var1) {
      this.strlangue = var1;
   }

   public String getStrlot() {
      return this.strlot;
   }

   public void setStrlot(String var1) {
      this.strlot = var1;
   }

   public int getStrformatdevise() {
      return this.strformatdevise;
   }

   public void setStrformatdevise(int var1) {
      this.strformatdevise = var1;
   }

   public String getStrmod1() {
      return this.strmod1;
   }

   public void setStrmod1(String var1) {
      this.strmod1 = var1;
   }

   public String getStrmod10() {
      return this.strmod10;
   }

   public void setStrmod10(String var1) {
      this.strmod10 = var1;
   }

   public String getStrmod2() {
      return this.strmod2;
   }

   public void setStrmod2(String var1) {
      this.strmod2 = var1;
   }

   public String getStrmod3() {
      return this.strmod3;
   }

   public void setStrmod3(String var1) {
      this.strmod3 = var1;
   }

   public String getStrmod4() {
      return this.strmod4;
   }

   public void setStrmod4(String var1) {
      this.strmod4 = var1;
   }

   public String getStrmod5() {
      return this.strmod5;
   }

   public void setStrmod5(String var1) {
      this.strmod5 = var1;
   }

   public String getStrmod6() {
      return this.strmod6;
   }

   public void setStrmod6(String var1) {
      this.strmod6 = var1;
   }

   public String getStrmod7() {
      return this.strmod7;
   }

   public void setStrmod7(String var1) {
      this.strmod7 = var1;
   }

   public String getStrmod8() {
      return this.strmod8;
   }

   public void setStrmod8(String var1) {
      this.strmod8 = var1;
   }

   public String getStrmod9() {
      return this.strmod9;
   }

   public void setStrmod9(String var1) {
      this.strmod9 = var1;
   }

   public Integer getStrmode() {
      return this.strmode;
   }

   public void setStrmode(Integer var1) {
      this.strmode = var1;
   }

   public String getStrnompays() {
      return this.strnompays;
   }

   public void setStrnompays(String var1) {
      this.strnompays = var1;
   }

   public String getStrporte() {
      return this.strporte;
   }

   public void setStrporte(String var1) {
      this.strporte = var1;
   }

   public String getStrquartier() {
      return this.strquartier;
   }

   public void setStrquartier(String var1) {
      this.strquartier = var1;
   }

   public String getStrraisonsociale() {
      if (this.strraisonsociale != null && !this.strraisonsociale.isEmpty()) {
         this.strraisonsociale = this.strraisonsociale.toUpperCase();
      }

      return this.strraisonsociale;
   }

   public void setStrraisonsociale(String var1) {
      this.strraisonsociale = var1;
   }

   public String getStrrepertoire() {
      return this.strrepertoire;
   }

   public void setStrrepertoire(String var1) {
      this.strrepertoire = var1;
   }

   public String getStrrue() {
      return this.strrue;
   }

   public void setStrrue(String var1) {
      this.strrue = var1;
   }

   public String getStrsigle() {
      return this.strsigle;
   }

   public void setStrsigle(String var1) {
      this.strsigle = var1;
   }

   public String getStrsitewzb() {
      return this.strsitewzb;
   }

   public void setStrsitewzb(String var1) {
      this.strsitewzb = var1;
   }

   public String getStrtel1() {
      return this.strtel1;
   }

   public void setStrtel1(String var1) {
      this.strtel1 = var1;
   }

   public String getStrtel2() {
      return this.strtel2;
   }

   public void setStrtel2(String var1) {
      this.strtel2 = var1;
   }

   public String getStrtel3() {
      return this.strtel3;
   }

   public void setStrtel3(String var1) {
      this.strtel3 = var1;
   }

   public String getStrtelex() {
      return this.strtelex;
   }

   public void setStrtelex(String var1) {
      this.strtelex = var1;
   }

   public String getStrtypeentreprise() {
      return this.strtypeentreprise;
   }

   public void setStrtypeentreprise(String var1) {
      this.strtypeentreprise = var1;
   }

   public long getStrusercreat() {
      return this.strusercreat;
   }

   public void setStrusercreat(long var1) {
      this.strusercreat = var1;
   }

   public long getStrusermodif() {
      return this.strusermodif;
   }

   public void setStrusermodif(long var1) {
      this.strusermodif = var1;
   }

   public String getStrville() {
      if (this.strville != null && !this.strville.isEmpty()) {
         this.strville = this.strville.toUpperCase();
      }

      return this.strville;
   }

   public void setStrville(String var1) {
      this.strville = var1;
   }

   public String getStrzone() {
      return this.strzone;
   }

   public void setStrzone(String var1) {
      this.strzone = var1;
   }

   public String getStrzonecommerciale() {
      return this.strzonecommerciale;
   }

   public void setStrzonecommerciale(String var1) {
      this.strzonecommerciale = var1;
   }

   public String getStrzonefiscale() {
      return this.strzonefiscale;
   }

   public void setStrzonefiscale(String var1) {
      this.strzonefiscale = var1;
   }

   public String getStretage() {
      return this.stretage;
   }

   public void setStretage(String var1) {
      this.stretage = var1;
   }

   public String getStrHrDeb() {
      return this.strHrDeb;
   }

   public void setStrHrDeb(String var1) {
      this.strHrDeb = var1;
   }

   public String getStrHrFin() {
      return this.strHrFin;
   }

   public void setStrHrFin(String var1) {
      this.strHrFin = var1;
   }

   public String getStrHrPas() {
      return this.strHrPas;
   }

   public void setStrHrPas(String var1) {
      this.strHrPas = var1;
   }

   public String getStrMnDeb() {
      return this.strMnDeb;
   }

   public void setStrMnDeb(String var1) {
      this.strMnDeb = var1;
   }

   public String getStrMnFin() {
      return this.strMnFin;
   }

   public void setStrMnFin(String var1) {
      this.strMnFin = var1;
   }

   public String getStrMnPas() {
      return this.strMnPas;
   }

   public void setStrMnPas(String var1) {
      this.strMnPas = var1;
   }

   public String getStrLogo1() {
      return this.strLogo1;
   }

   public void setStrLogo1(String var1) {
      this.strLogo1 = var1;
   }

   public String getStrLogo2() {
      return this.strLogo2;
   }

   public void setStrLogo2(String var1) {
      this.strLogo2 = var1;
   }

   public String getStrLogo3() {
      return this.strLogo3;
   }

   public void setStrLogo3(String var1) {
      this.strLogo3 = var1;
   }

   public String getStrLogo4() {
      return this.strLogo4;
   }

   public void setStrLogo4(String var1) {
      this.strLogo4 = var1;
   }

   public String getStrnum1() {
      return this.strnum1;
   }

   public void setStrnum1(String var1) {
      this.strnum1 = var1;
   }

   public String getStrnum10() {
      return this.strnum10;
   }

   public void setStrnum10(String var1) {
      this.strnum10 = var1;
   }

   public String getStrnum11() {
      return this.strnum11;
   }

   public void setStrnum11(String var1) {
      this.strnum11 = var1;
   }

   public String getStrnum12() {
      return this.strnum12;
   }

   public void setStrnum12(String var1) {
      this.strnum12 = var1;
   }

   public String getStrnum13() {
      return this.strnum13;
   }

   public void setStrnum13(String var1) {
      this.strnum13 = var1;
   }

   public String getStrnum14() {
      return this.strnum14;
   }

   public void setStrnum14(String var1) {
      this.strnum14 = var1;
   }

   public String getStrnum15() {
      return this.strnum15;
   }

   public void setStrnum15(String var1) {
      this.strnum15 = var1;
   }

   public String getStrnum16() {
      return this.strnum16;
   }

   public void setStrnum16(String var1) {
      this.strnum16 = var1;
   }

   public String getStrnum17() {
      return this.strnum17;
   }

   public void setStrnum17(String var1) {
      this.strnum17 = var1;
   }

   public String getStrnum18() {
      return this.strnum18;
   }

   public void setStrnum18(String var1) {
      this.strnum18 = var1;
   }

   public String getStrnum19() {
      return this.strnum19;
   }

   public void setStrnum19(String var1) {
      this.strnum19 = var1;
   }

   public String getStrnum2() {
      return this.strnum2;
   }

   public void setStrnum2(String var1) {
      this.strnum2 = var1;
   }

   public String getStrnum20() {
      return this.strnum20;
   }

   public void setStrnum20(String var1) {
      this.strnum20 = var1;
   }

   public String getStrnum3() {
      return this.strnum3;
   }

   public void setStrnum3(String var1) {
      this.strnum3 = var1;
   }

   public String getStrnum4() {
      return this.strnum4;
   }

   public void setStrnum4(String var1) {
      this.strnum4 = var1;
   }

   public String getStrnum5() {
      return this.strnum5;
   }

   public void setStrnum5(String var1) {
      this.strnum5 = var1;
   }

   public String getStrnum6() {
      return this.strnum6;
   }

   public void setStrnum6(String var1) {
      this.strnum6 = var1;
   }

   public String getStrnum7() {
      return this.strnum7;
   }

   public void setStrnum7(String var1) {
      this.strnum7 = var1;
   }

   public String getStrnum8() {
      return this.strnum8;
   }

   public void setStrnum8(String var1) {
      this.strnum8 = var1;
   }

   public String getStrnum9() {
      return this.strnum9;
   }

   public void setStrnum9(String var1) {
      this.strnum9 = var1;
   }

   public String getStrcodepays() {
      return this.strcodepays;
   }

   public void setStrcodepays(String var1) {
      this.strcodepays = var1;
   }

   public String getStrdomaine() {
      return this.strdomaine;
   }

   public void setStrdomaine(String var1) {
      this.strdomaine = var1;
   }

   public String getStrip() {
      return this.strip;
   }

   public void setStrip(String var1) {
      this.strip = var1;
   }

   public String getStrlogbd() {
      return this.strlogbd;
   }

   public void setStrlogbd(String var1) {
      this.strlogbd = var1;
   }

   public String getStrnombd() {
      return this.strnombd;
   }

   public void setStrnombd(String var1) {
      this.strnombd = var1;
   }

   public String getStrpwbd() {
      return this.strpwbd;
   }

   public void setStrpwbd(String var1) {
      this.strpwbd = var1;
   }

   public String getStrrepimage() {
      return this.strrepimage;
   }

   public void setStrrepimage(String var1) {
      this.strrepimage = var1;
   }

   public int getStrECommerceVal() {
      return this.strECommerceVal;
   }

   public void setStrECommerceVal(int var1) {
      this.strECommerceVal = var1;
   }

   public int getStrtypeContact() {
      return this.strtypeContact;
   }

   public void setStrtypeContact(int var1) {
      this.strtypeContact = var1;
   }

   public String getStrBanqueDefaut() {
      return this.strBanqueDefaut;
   }

   public void setStrBanqueDefaut(String var1) {
      this.strBanqueDefaut = var1;
   }

   public int getStrmaitrecabinet() {
      return this.strmaitrecabinet;
   }

   public void setStrmaitrecabinet(int var1) {
      this.strmaitrecabinet = var1;
   }

   public Date getStrDteDebMandat() {
      return this.strDteDebMandat;
   }

   public void setStrDteDebMandat(Date var1) {
      this.strDteDebMandat = var1;
   }

   public Date getStrDteFinMandat() {
      return this.strDteFinMandat;
   }

   public void setStrDteFinMandat(Date var1) {
      this.strDteFinMandat = var1;
   }

   public int getStrEtatMandat() {
      return this.strEtatMandat;
   }

   public void setStrEtatMandat(int var1) {
      this.strEtatMandat = var1;
   }

   public String getStrRepDocument() {
      return this.strRepDocument;
   }

   public void setStrRepDocument(String var1) {
      this.strRepDocument = var1;
   }

   public String getStrRepConfiguration() {
      return this.strRepConfiguration;
   }

   public void setStrRepConfiguration(String var1) {
      this.strRepConfiguration = var1;
   }

   public String getStrRepSource() {
      return this.strRepSource;
   }

   public void setStrRepSource(String var1) {
      this.strRepSource = var1;
   }

   public int getStrsitedevise() {
      return this.strsitedevise;
   }

   public void setStrsitedevise(int var1) {
      this.strsitedevise = var1;
   }

   public String getStrLogo5() {
      return this.strLogo5;
   }

   public void setStrLogo5(String var1) {
      this.strLogo5 = var1;
   }

   public String getStrLogo6() {
      return this.strLogo6;
   }

   public void setStrLogo6(String var1) {
      this.strLogo6 = var1;
   }

   public String getStrLogo7() {
      return this.strLogo7;
   }

   public void setStrLogo7(String var1) {
      this.strLogo7 = var1;
   }

   public String getStrLogo8() {
      return this.strLogo8;
   }

   public void setStrLogo8(String var1) {
      this.strLogo8 = var1;
   }

   public String getStrLogo10() {
      return this.strLogo10;
   }

   public void setStrLogo10(String var1) {
      this.strLogo10 = var1;
   }

   public String getStrLogo9() {
      return this.strLogo9;
   }

   public void setStrLogo9(String var1) {
      this.strLogo9 = var1;
   }

   public String getStractiviteCommerciale() {
      return this.stractiviteCommerciale;
   }

   public void setStractiviteCommerciale(String var1) {
      this.stractiviteCommerciale = var1;
   }

   public String getStrCapital() {
      return this.strCapital;
   }

   public void setStrCapital(String var1) {
      this.strCapital = var1;
   }

   public String getStrQualiteResponsable() {
      return this.strQualiteResponsable;
   }

   public void setStrQualiteResponsable(String var1) {
      this.strQualiteResponsable = var1;
   }

   public String getStrResponsable() {
      return this.strResponsable;
   }

   public void setStrResponsable(String var1) {
      this.strResponsable = var1;
   }

   public String getStrisopays() {
      return this.strisopays;
   }

   public void setStrisopays(String var1) {
      this.strisopays = var1;
   }

   public int getStrMeteoCodeVille() {
      return this.strMeteoCodeVille;
   }

   public void setStrMeteoCodeVille(int var1) {
      this.strMeteoCodeVille = var1;
   }

   public String getStrCode1() {
      if (this.strCode1 != null && !this.strCode1.isEmpty()) {
         this.strCode1 = this.strCode1.toUpperCase();
      }

      return this.strCode1;
   }

   public void setStrCode1(String var1) {
      this.strCode1 = var1;
   }

   public String getStrCode2() {
      if (this.strCode2 != null && !this.strCode2.isEmpty()) {
         this.strCode2 = this.strCode2.toUpperCase();
      }

      return this.strCode2;
   }

   public void setStrCode2(String var1) {
      this.strCode2 = var1;
   }

   public String getStrCode3() {
      if (this.strCode3 != null && !this.strCode3.isEmpty()) {
         this.strCode3 = this.strCode3.toUpperCase();
      }

      return this.strCode3;
   }

   public void setStrCode3(String var1) {
      this.strCode3 = var1;
   }

   public String getStrLib1() {
      if (this.strLib1 != null && !this.strLib1.isEmpty()) {
         this.strLib1 = this.strLib1.toUpperCase();
      }

      return this.strLib1;
   }

   public void setStrLib1(String var1) {
      this.strLib1 = var1;
   }

   public String getStrLib2() {
      if (this.strLib2 != null && !this.strLib2.isEmpty()) {
         this.strLib2 = this.strLib2.toUpperCase();
      }

      return this.strLib2;
   }

   public void setStrLib2(String var1) {
      this.strLib2 = var1;
   }

   public String getStrLib3() {
      if (this.strLib3 != null && !this.strLib3.isEmpty()) {
         this.strLib3 = this.strLib3.toUpperCase();
      }

      return this.strLib3;
   }

   public void setStrLib3(String var1) {
      this.strLib3 = var1;
   }

   public String getStrSignature() {
      return this.strSignature;
   }

   public void setStrSignature(String var1) {
      this.strSignature = var1;
   }

   public String getStradressemail() {
      return this.stradressemail;
   }

   public void setStradressemail(String var1) {
      this.stradressemail = var1;
   }

   public String getStradressemailreponse() {
      return this.stradressemailreponse;
   }

   public void setStradressemailreponse(String var1) {
      this.stradressemailreponse = var1;
   }

   public int getStrimapport() {
      return this.strimapport;
   }

   public void setStrimapport(int var1) {
      this.strimapport = var1;
   }

   public String getStrimapserveur() {
      return this.strimapserveur;
   }

   public void setStrimapserveur(String var1) {
      this.strimapserveur = var1;
   }

   public int getStrpopauthentification() {
      return this.strpopauthentification;
   }

   public void setStrpopauthentification(int var1) {
      this.strpopauthentification = var1;
   }

   public int getStrpopexemplaire() {
      return this.strpopexemplaire;
   }

   public void setStrpopexemplaire(int var1) {
      this.strpopexemplaire = var1;
   }

   public int getStrpopport() {
      return this.strpopport;
   }

   public void setStrpopport(int var1) {
      this.strpopport = var1;
   }

   public String getStrpopserveur() {
      return this.strpopserveur;
   }

   public void setStrpopserveur(String var1) {
      this.strpopserveur = var1;
   }

   public String getStrpw() {
      return this.strpw;
   }

   public void setStrpw(String var1) {
      this.strpw = var1;
   }

   public int getStrsmtauthentification() {
      return this.strsmtauthentification;
   }

   public void setStrsmtauthentification(int var1) {
      this.strsmtauthentification = var1;
   }

   public int getStrsmtpport() {
      return this.strsmtpport;
   }

   public void setStrsmtpport(int var1) {
      this.strsmtpport = var1;
   }

   public String getStrsmtpserveur() {
      return this.strsmtpserveur;
   }

   public void setStrsmtpserveur(String var1) {
      this.strsmtpserveur = var1;
   }

   public int getStrssl() {
      return this.strssl;
   }

   public void setStrssl(int var1) {
      this.strssl = var1;
   }

   public String getStrappDropbox() {
      return this.strappDropbox;
   }

   public void setStrappDropbox(String var1) {
      this.strappDropbox = var1;
   }

   public int getStrmajcabinet() {
      return this.strmajcabinet;
   }

   public void setStrmajcabinet(int var1) {
      this.strmajcabinet = var1;
   }

   public int getStrClusterMap() {
      return this.strClusterMap;
   }

   public void setStrClusterMap(int var1) {
      this.strClusterMap = var1;
   }

   public String getStrbistriLink() {
      return this.strbistriLink;
   }

   public void setStrbistriLink(String var1) {
      this.strbistriLink = var1;
   }

   public String getStrbilansocial() {
      return this.strbilansocial;
   }

   public void setStrbilansocial(String var1) {
      this.strbilansocial = var1;
   }

   public int getStrHangout() {
      return this.strHangout;
   }

   public void setStrHangout(int var1) {
      this.strHangout = var1;
   }

   public int getStrstockNegatif() {
      return this.strstockNegatif;
   }

   public void setStrstockNegatif(int var1) {
      this.strstockNegatif = var1;
   }

   public String getStrcpteorange() {
      return this.strcpteorange;
   }

   public void setStrcpteorange(String var1) {
      this.strcpteorange = var1;
   }

   public String getStrcptebicitel() {
      return this.strcptebicitel;
   }

   public void setStrcptebicitel(String var1) {
      this.strcptebicitel = var1;
   }

   public int getStrAddInto() {
      return this.strAddInto;
   }

   public void setStrAddInto(int var1) {
      this.strAddInto = var1;
   }

   public int getStrsmtChoix() {
      return this.strsmtChoix;
   }

   public void setStrsmtChoix(int var1) {
      this.strsmtChoix = var1;
   }

   public int getStrNumSecuMultiple() {
      return this.strNumSecuMultiple;
   }

   public void setStrNumSecuMultiple(int var1) {
      this.strNumSecuMultiple = var1;
   }

   public String getStrcpteuniversign() {
      return this.strcpteuniversign;
   }

   public void setStrcpteuniversign(String var1) {
      this.strcpteuniversign = var1;
   }

   public String getStrpwuniversign() {
      return this.strpwuniversign;
   }

   public void setStrpwuniversign(String var1) {
      this.strpwuniversign = var1;
   }

   public boolean isStrStructure() {
      return this.strStructure;
   }

   public void setStrStructure(boolean var1) {
      this.strStructure = var1;
   }

   public boolean isStrChantier() {
      return this.strChantier;
   }

   public void setStrChantier(boolean var1) {
      this.strChantier = var1;
   }

   public boolean isStrMission() {
      return this.strMission;
   }

   public void setStrMission(boolean var1) {
      this.strMission = var1;
   }

   public boolean isStrAgent() {
      return this.strAgent;
   }

   public void setStrAgent(boolean var1) {
      this.strAgent = var1;
   }

   public boolean isStrCles() {
      return this.strCles;
   }

   public void setStrCles(boolean var1) {
      this.strCles = var1;
   }

   public int getStrDossier() {
      return this.strDossier;
   }

   public void setStrDossier(int var1) {
      this.strDossier = var1;
   }

   public boolean isStrParc() {
      return this.strParc;
   }

   public void setStrParc(boolean var1) {
      this.strParc = var1;
   }

   public boolean isStrRegion() {
      return this.strRegion;
   }

   public void setStrRegion(boolean var1) {
      this.strRegion = var1;
   }

   public boolean isStrSite() {
      return this.strSite;
   }

   public void setStrSite(boolean var1) {
      this.strSite = var1;
   }

   public boolean isStrUsine() {
      return this.strUsine;
   }

   public void setStrUsine(boolean var1) {
      this.strUsine = var1;
   }

   public boolean isStrActivite() {
      return this.strActivite;
   }

   public void setStrActivite(boolean var1) {
      this.strActivite = var1;
   }

   public boolean isStrProjet() {
      return this.strProjet;
   }

   public void setStrProjet(boolean var1) {
      this.strProjet = var1;
   }

   public int getStrGoogleTraduction() {
      return this.strGoogleTraduction;
   }

   public void setStrGoogleTraduction(int var1) {
      this.strGoogleTraduction = var1;
   }

   public String getStrQuart1DebutHeure() {
      return this.strQuart1DebutHeure;
   }

   public void setStrQuart1DebutHeure(String var1) {
      this.strQuart1DebutHeure = var1;
   }

   public String getStrQuart1DebutMinute() {
      return this.strQuart1DebutMinute;
   }

   public void setStrQuart1DebutMinute(String var1) {
      this.strQuart1DebutMinute = var1;
   }

   public String getStrQuart1FinHeure() {
      return this.strQuart1FinHeure;
   }

   public void setStrQuart1FinHeure(String var1) {
      this.strQuart1FinHeure = var1;
   }

   public String getStrQuart1FinMinute() {
      return this.strQuart1FinMinute;
   }

   public void setStrQuart1FinMinute(String var1) {
      this.strQuart1FinMinute = var1;
   }

   public String getStrQuart2FinHeure() {
      return this.strQuart2FinHeure;
   }

   public void setStrQuart2FinHeure(String var1) {
      this.strQuart2FinHeure = var1;
   }

   public String getStrQuart2FinMinute() {
      return this.strQuart2FinMinute;
   }

   public void setStrQuart2FinMinute(String var1) {
      this.strQuart2FinMinute = var1;
   }

   public String getStrQuart3FinHeure() {
      return this.strQuart3FinHeure;
   }

   public void setStrQuart3FinHeure(String var1) {
      this.strQuart3FinHeure = var1;
   }

   public String getStrQuart3FinMinute() {
      return this.strQuart3FinMinute;
   }

   public void setStrQuart3FinMinute(String var1) {
      this.strQuart3FinMinute = var1;
   }

   public String getStrzonefiscale2() {
      return this.strzonefiscale2;
   }

   public void setStrzonefiscale2(String var1) {
      this.strzonefiscale2 = var1;
   }

   public Date getStrdatefiscale2() {
      return this.strdatefiscale2;
   }

   public void setStrdatefiscale2(Date var1) {
      this.strdatefiscale2 = var1;
   }

   public int getStrNumRetraiteMultiple() {
      return this.strNumRetraiteMultiple;
   }

   public void setStrNumRetraiteMultiple(int var1) {
      this.strNumRetraiteMultiple = var1;
   }

   public String getStrdescriptif() {
      return this.strdescriptif;
   }

   public void setStrdescriptif(String var1) {
      this.strdescriptif = var1;
   }

   public int getStrActiviteModeSasie() {
      return this.strActiviteModeSasie;
   }

   public void setStrActiviteModeSasie(int var1) {
      this.strActiviteModeSasie = var1;
   }

   public int getStrDepotStock() {
      return this.strDepotStock;
   }

   public void setStrDepotStock(int var1) {
      this.strDepotStock = var1;
   }

   public int getStrChainageAxes() {
      return this.strChainageAxes;
   }

   public void setStrChainageAxes(int var1) {
      this.strChainageAxes = var1;
   }
}
