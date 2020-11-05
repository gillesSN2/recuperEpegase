package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class StructurePeg implements Serializable {
   private long strId;
   private Date strdtecreat;
   private Date strdtemodif;
   private long strusercreat;
   private long strusermodif;
   private int stretat;
   private int strmaitrecabinet;
   private int strmode;
   private String strraisonsociale;
   private String strsigle;
   private String strnompays;
   private String strcodepays;
   private String strdevise;
   private String strlangue;
   private String strzonefiscale;
   private String strzonecommerciale;
   private String strformatdate;
   private String strformatheure;
   private String strHrDeb;
   private String strPas;
   private String strHrFin;
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
   private String stradresseserveur;
   private String strrepertoire;
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
   private int strformatdevise;
   private Date strdtedebmandat;
   private Date strdtefinmandat;
   private int stretatmandat;
   private CabinetPeg cabinetPeg;
   private String libmode;
   private String libetat;
   private String libmaitre;
   private String libmandat;
   private boolean selectStructure;
   private String styleColor;

   public void StructurePeg() {
   }

   public String getStyleColor() {
      if (this.strmod4 != null && !this.strmod4.isEmpty()) {
         if (this.strmod4.equals("80500")) {
            this.styleColor = "color:red;font-weight:bold;";
         } else {
            this.styleColor = "color:black;font-weight:normal;";
         }
      } else {
         this.styleColor = "color:black;font-weight:normal;";
      }

      return this.styleColor;
   }

   public void setStyleColor(String var1) {
      this.styleColor = var1;
   }

   public boolean isSelectStructure() {
      return this.selectStructure;
   }

   public void setSelectStructure(boolean var1) {
      this.selectStructure = var1;
   }

   public String getLibetat() {
      if (this.stretat == 0) {
         this.libetat = "N.Actif";
      } else if (this.stretat == 1) {
         this.libetat = "Actif";
      } else if (this.stretat == 2) {
         this.libetat = "Blqué";
      } else if (this.stretat == 3) {
         this.libetat = "Cloturé";
      }

      return this.libetat;
   }

   public void setLibetat(String var1) {
      this.libetat = var1;
   }

   public String getLibmode() {
      if (this.strmode == 0) {
         this.libmode = "Internet";
      } else if (this.strmode == 1) {
         this.libmode = "Intranet";
      } else if (this.strmode == 2) {
         this.libmode = "Mixte";
      } else if (this.strmode == 3) {
         this.libmode = "Spécial";
      }

      return this.libmode;
   }

   public void setLibmode(String var1) {
      this.libmode = var1;
   }

   public String getLibmaitre() {
      if (this.strmaitrecabinet != 0) {
         this.libmaitre = "***";
      } else {
         this.libmaitre = "";
      }

      return this.libmaitre;
   }

   public void setLibmaitre(String var1) {
      this.libmaitre = var1;
   }

   public String getLibmandat() {
      if (this.stretatmandat == 0) {
         this.libmandat = "En cours";
      } else if (this.stretatmandat == 1) {
         this.libmandat = "Terminé";
      } else if (this.stretatmandat == 2) {
         this.libmandat = "Litige";
      } else if (this.stretatmandat == 3) {
         this.libmandat = "Abandonné";
      }

      return this.libmandat;
   }

   public void setLibmandat(String var1) {
      this.libmandat = var1;
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

   public int getStretat() {
      return this.stretat;
   }

   public void setStretat(int var1) {
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

   public String getStrlangue() {
      return this.strlangue;
   }

   public void setStrlangue(String var1) {
      this.strlangue = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
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

   public int getStrmode() {
      return this.strmode;
   }

   public void setStrmode(int var1) {
      this.strmode = var1;
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

   public void setStrusermodif(int var1) {
      this.strusermodif = (long)var1;
   }

   public String getStrville() {
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

   public String getStrPas() {
      return this.strPas;
   }

   public void setStrPas(String var1) {
      this.strPas = var1;
   }

   public String getStrcodepays() {
      return this.strcodepays;
   }

   public void setStrcodepays(String var1) {
      this.strcodepays = var1;
   }

   public CabinetPeg getCabinetPeg() {
      return this.cabinetPeg;
   }

   public void setCabinetPeg(CabinetPeg var1) {
      this.cabinetPeg = var1;
   }

   public int getStrmaitrecabinet() {
      return this.strmaitrecabinet;
   }

   public void setStrmaitrecabinet(int var1) {
      this.strmaitrecabinet = var1;
   }

   public Date getStrdtedebmandat() {
      return this.strdtedebmandat;
   }

   public void setStrdtedebmandat(Date var1) {
      this.strdtedebmandat = var1;
   }

   public Date getStrdtefinmandat() {
      return this.strdtefinmandat;
   }

   public void setStrdtefinmandat(Date var1) {
      this.strdtefinmandat = var1;
   }

   public int getStretatmandat() {
      return this.stretatmandat;
   }

   public void setStretatmandat(int var1) {
      this.stretatmandat = var1;
   }
}
