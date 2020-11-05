package com.epegase.systeme.control;

import com.epegase.systeme.classe.Ecritures;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EcrituresAnalytiqueCtrl implements Serializable {
   private long ecranaId;
   private long ecranaIdOrigine;
   private String ecranaTypeOrigine;
   private int ecranaAxe;
   private String ecranaCle;
   private String ecranaCode;
   private Date ecranaDateSaisie;
   private String ecranaPeriode;
   private int ecranaNature;
   private int ecranaReserve;
   private double ecranaMontantSaisie;
   private float ecranaQteSaisie;
   private long ecranaOrdre;
   private String ecranaLibelle;
   private String ecranaSite;
   private String ecranaSiteLib;
   private String ecranaDepartement;
   private String ecranaDepartementLib;
   private String ecranaService;
   private String ecranaServiceLib;
   private String ecranaRegion;
   private String ecranaRegionLib;
   private String ecranaSecteur;
   private String ecranaSecteurLib;
   private String ecranaPdv;
   private String ecranaPdvLib;
   private String ecranaLigne;
   private String ecranaLigneLib;
   private String ecranaAtelier;
   private String ecranaAtelierLib;
   private String ecranaAnal1;
   private String ecranaAnal1Lib;
   private String ecranaAnal2;
   private String ecranaAnal2Lib;
   private String ecranaAnal3;
   private String ecranaAnal3Lib;
   private String ecranaAnal4;
   private String ecranaAnal4Lib;
   private String ecranaActivite;
   private String ecranaActiviteLib;
   private String ecranaCompte;
   private String ecranaCle1;
   private String ecranaCle2;
   private String ecranaClasse;
   private String ecranaPiece;
   private String ecranaReference1;
   private String ecranaReference2;
   private int ecranaNatureJrx;
   private float ecranaPourcentage;
   private String ecranaStr;
   private String ecranaStrLib;
   private String ecranaAgent;
   private String ecranaAgentLib;
   private String ecranaStrCle;
   private String ecranaRepCle;
   private String ecranaProjet;
   private String ecranaProjetLib;
   private String ecranaEntite;
   private String ecranaEntiteLib;
   private String ecranaPoste;
   private String ecranaPosteLib;
   private int ecranaTypeCle;
   private Ecritures ecriture;
   private String zoneSite;
   private String zoneDepartement;
   private String zoneService;
   private String zoneRegion;
   private String zoneSecteur;
   private String zonePdv;
   private String zoneSitePrd;
   private String zoneLigne;
   private String zoneAtelier;
   private double montantBudget;
   private String poste;
   private String libPoste;
   private String zoneActivite;
   private String zoneCol1;
   private String zoneCol2;
   private String zoneCol3;
   private String zoneProjet;
   private String zoneEntite;
   private String zonePoste;
   private List mesSitesItems = new ArrayList();
   private List mesDepartementsItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private List mesRegionsItems = new ArrayList();
   private List mesSecteursItems = new ArrayList();
   private List mesPdvItems = new ArrayList();
   private List mesSitesPrdItems = new ArrayList();
   private List mesLignesItems = new ArrayList();
   private List mesAteliersItems = new ArrayList();
   private List mesColonnes1Items = new ArrayList();
   private List mesColonnes2Items = new ArrayList();
   private List mesColonnes3Items = new ArrayList();
   private List mesProjetsItems = new ArrayList();
   private List mesPostesItems = new ArrayList();
   private List mesEntitesItems = new ArrayList();
   private boolean depVide;
   private boolean serVide;
   private boolean secVide;
   private boolean pdvVide;
   private boolean ligVide;
   private boolean ateVide;
   private boolean entVide;
   private boolean posVide;
   private String zoneAnal1;
   private String zoneAnal3;

   public boolean isDepVide() {
      if (this.mesDepartementsItems.size() == 0) {
         this.depVide = true;
         this.serVide = true;
      } else {
         this.depVide = false;
      }

      return this.depVide;
   }

   public void setDepVide(boolean var1) {
      this.depVide = var1;
   }

   public boolean isSerVide() {
      if (this.mesServicesItems.size() == 0) {
         this.serVide = true;
      } else {
         this.serVide = false;
      }

      return this.serVide;
   }

   public void setSerVide(boolean var1) {
      this.serVide = var1;
   }

   public boolean isAteVide() {
      if (this.mesAteliersItems.size() == 0) {
         this.ateVide = true;
      } else {
         this.ateVide = false;
      }

      return this.ateVide;
   }

   public void setAteVide(boolean var1) {
      this.ateVide = var1;
   }

   public boolean isLigVide() {
      if (this.mesLignesItems.size() == 0) {
         this.ligVide = true;
         this.ateVide = true;
      } else {
         this.ligVide = false;
      }

      return this.ligVide;
   }

   public void setLigVide(boolean var1) {
      this.ligVide = var1;
   }

   public boolean isPdvVide() {
      if (this.mesPdvItems.size() == 0) {
         this.pdvVide = true;
      } else {
         this.pdvVide = false;
      }

      return this.pdvVide;
   }

   public void setPdvVide(boolean var1) {
      this.pdvVide = var1;
   }

   public boolean isSecVide() {
      if (this.mesSecteursItems.size() == 0) {
         this.secVide = true;
         this.pdvVide = true;
      } else {
         this.secVide = false;
      }

      return this.secVide;
   }

   public void setSecVide(boolean var1) {
      this.secVide = var1;
   }

   public String getEcranaActivite() {
      return this.ecranaActivite;
   }

   public void setEcranaActivite(String var1) {
      this.ecranaActivite = var1;
   }

   public String getEcranaActiviteLib() {
      return this.ecranaActiviteLib;
   }

   public void setEcranaActiviteLib(String var1) {
      this.ecranaActiviteLib = var1;
   }

   public String getEcranaAnal1() {
      return this.ecranaAnal1;
   }

   public void setEcranaAnal1(String var1) {
      this.ecranaAnal1 = var1;
   }

   public String getEcranaAnal1Lib() {
      return this.ecranaAnal1Lib;
   }

   public void setEcranaAnal1Lib(String var1) {
      this.ecranaAnal1Lib = var1;
   }

   public String getEcranaAnal2() {
      return this.ecranaAnal2;
   }

   public void setEcranaAnal2(String var1) {
      this.ecranaAnal2 = var1;
   }

   public String getEcranaAnal2Lib() {
      return this.ecranaAnal2Lib;
   }

   public void setEcranaAnal2Lib(String var1) {
      this.ecranaAnal2Lib = var1;
   }

   public String getEcranaAnal3() {
      return this.ecranaAnal3;
   }

   public void setEcranaAnal3(String var1) {
      this.ecranaAnal3 = var1;
   }

   public String getEcranaAnal3Lib() {
      return this.ecranaAnal3Lib;
   }

   public void setEcranaAnal3Lib(String var1) {
      this.ecranaAnal3Lib = var1;
   }

   public String getEcranaAnal4() {
      return this.ecranaAnal4;
   }

   public void setEcranaAnal4(String var1) {
      this.ecranaAnal4 = var1;
   }

   public String getEcranaAnal4Lib() {
      return this.ecranaAnal4Lib;
   }

   public void setEcranaAnal4Lib(String var1) {
      this.ecranaAnal4Lib = var1;
   }

   public int getEcranaAxe() {
      return this.ecranaAxe;
   }

   public void setEcranaAxe(int var1) {
      this.ecranaAxe = var1;
   }

   public String getEcranaClasse() {
      return this.ecranaClasse;
   }

   public void setEcranaClasse(String var1) {
      this.ecranaClasse = var1;
   }

   public String getEcranaCle() {
      return this.ecranaCle;
   }

   public void setEcranaCle(String var1) {
      this.ecranaCle = var1;
   }

   public String getEcranaCle1() {
      return this.ecranaCle1;
   }

   public void setEcranaCle1(String var1) {
      this.ecranaCle1 = var1;
   }

   public String getEcranaCle2() {
      return this.ecranaCle2;
   }

   public void setEcranaCle2(String var1) {
      this.ecranaCle2 = var1;
   }

   public String getEcranaCode() {
      return this.ecranaCode;
   }

   public void setEcranaCode(String var1) {
      this.ecranaCode = var1;
   }

   public String getEcranaCompte() {
      return this.ecranaCompte;
   }

   public void setEcranaCompte(String var1) {
      this.ecranaCompte = var1;
   }

   public Date getEcranaDateSaisie() {
      return this.ecranaDateSaisie;
   }

   public void setEcranaDateSaisie(Date var1) {
      this.ecranaDateSaisie = var1;
   }

   public String getEcranaDepartement() {
      return this.ecranaDepartement;
   }

   public void setEcranaDepartement(String var1) {
      this.ecranaDepartement = var1;
   }

   public String getEcranaDepartementLib() {
      return this.ecranaDepartementLib;
   }

   public void setEcranaDepartementLib(String var1) {
      this.ecranaDepartementLib = var1;
   }

   public long getEcranaId() {
      return this.ecranaId;
   }

   public void setEcranaId(long var1) {
      this.ecranaId = var1;
   }

   public long getEcranaIdOrigine() {
      return this.ecranaIdOrigine;
   }

   public void setEcranaIdOrigine(long var1) {
      this.ecranaIdOrigine = var1;
   }

   public String getEcranaLibelle() {
      return this.ecranaLibelle;
   }

   public void setEcranaLibelle(String var1) {
      this.ecranaLibelle = var1;
   }

   public double getEcranaMontantSaisie() {
      return this.ecranaMontantSaisie;
   }

   public void setEcranaMontantSaisie(double var1) {
      this.ecranaMontantSaisie = var1;
   }

   public int getEcranaNature() {
      return this.ecranaNature;
   }

   public void setEcranaNature(int var1) {
      this.ecranaNature = var1;
   }

   public int getEcranaNatureJrx() {
      return this.ecranaNatureJrx;
   }

   public void setEcranaNatureJrx(int var1) {
      this.ecranaNatureJrx = var1;
   }

   public long getEcranaOrdre() {
      return this.ecranaOrdre;
   }

   public void setEcranaOrdre(long var1) {
      this.ecranaOrdre = var1;
   }

   public String getEcranaPdv() {
      return this.ecranaPdv;
   }

   public void setEcranaPdv(String var1) {
      this.ecranaPdv = var1;
   }

   public String getEcranaPdvLib() {
      return this.ecranaPdvLib;
   }

   public void setEcranaPdvLib(String var1) {
      this.ecranaPdvLib = var1;
   }

   public String getEcranaPeriode() {
      return this.ecranaPeriode;
   }

   public void setEcranaPeriode(String var1) {
      this.ecranaPeriode = var1;
   }

   public String getEcranaPiece() {
      return this.ecranaPiece;
   }

   public void setEcranaPiece(String var1) {
      this.ecranaPiece = var1;
   }

   public float getEcranaPourcentage() {
      return this.ecranaPourcentage;
   }

   public void setEcranaPourcentage(float var1) {
      this.ecranaPourcentage = var1;
   }

   public String getEcranaProjet() {
      return this.ecranaProjet;
   }

   public void setEcranaProjet(String var1) {
      this.ecranaProjet = var1;
   }

   public String getEcranaProjetLib() {
      return this.ecranaProjetLib;
   }

   public void setEcranaProjetLib(String var1) {
      this.ecranaProjetLib = var1;
   }

   public String getEcranaReference1() {
      return this.ecranaReference1;
   }

   public void setEcranaReference1(String var1) {
      this.ecranaReference1 = var1;
   }

   public String getEcranaReference2() {
      return this.ecranaReference2;
   }

   public void setEcranaReference2(String var1) {
      this.ecranaReference2 = var1;
   }

   public String getEcranaRegion() {
      return this.ecranaRegion;
   }

   public void setEcranaRegion(String var1) {
      this.ecranaRegion = var1;
   }

   public String getEcranaRegionLib() {
      return this.ecranaRegionLib;
   }

   public void setEcranaRegionLib(String var1) {
      this.ecranaRegionLib = var1;
   }

   public int getEcranaReserve() {
      return this.ecranaReserve;
   }

   public void setEcranaReserve(int var1) {
      this.ecranaReserve = var1;
   }

   public String getEcranaSecteur() {
      return this.ecranaSecteur;
   }

   public void setEcranaSecteur(String var1) {
      this.ecranaSecteur = var1;
   }

   public String getEcranaSecteurLib() {
      return this.ecranaSecteurLib;
   }

   public void setEcranaSecteurLib(String var1) {
      this.ecranaSecteurLib = var1;
   }

   public String getEcranaService() {
      return this.ecranaService;
   }

   public void setEcranaService(String var1) {
      this.ecranaService = var1;
   }

   public String getEcranaServiceLib() {
      return this.ecranaServiceLib;
   }

   public void setEcranaServiceLib(String var1) {
      this.ecranaServiceLib = var1;
   }

   public String getEcranaSite() {
      return this.ecranaSite;
   }

   public void setEcranaSite(String var1) {
      this.ecranaSite = var1;
   }

   public String getEcranaSiteLib() {
      return this.ecranaSiteLib;
   }

   public void setEcranaSiteLib(String var1) {
      this.ecranaSiteLib = var1;
   }

   public String getEcranaTypeOrigine() {
      return this.ecranaTypeOrigine;
   }

   public void setEcranaTypeOrigine(String var1) {
      this.ecranaTypeOrigine = var1;
   }

   public Ecritures getEcriture() {
      return this.ecriture;
   }

   public void setEcriture(Ecritures var1) {
      this.ecriture = var1;
   }

   public String getEcranaAtelier() {
      return this.ecranaAtelier;
   }

   public void setEcranaAtelier(String var1) {
      this.ecranaAtelier = var1;
   }

   public String getEcranaAtelierLib() {
      return this.ecranaAtelierLib;
   }

   public void setEcranaAtelierLib(String var1) {
      this.ecranaAtelierLib = var1;
   }

   public String getEcranaLigne() {
      return this.ecranaLigne;
   }

   public void setEcranaLigne(String var1) {
      this.ecranaLigne = var1;
   }

   public String getEcranaLigneLib() {
      return this.ecranaLigneLib;
   }

   public void setEcranaLigneLib(String var1) {
      this.ecranaLigneLib = var1;
   }

   public double getMontantBudget() {
      return this.montantBudget;
   }

   public void setMontantBudget(double var1) {
      this.montantBudget = var1;
   }

   public String getLibPoste() {
      return this.libPoste;
   }

   public void setLibPoste(String var1) {
      this.libPoste = var1;
   }

   public String getPoste() {
      return this.poste;
   }

   public void setPoste(String var1) {
      this.poste = var1;
   }

   public String getEcranaStr() {
      return this.ecranaStr;
   }

   public void setEcranaStr(String var1) {
      this.ecranaStr = var1;
   }

   public String getEcranaStrLib() {
      return this.ecranaStrLib;
   }

   public void setEcranaStrLib(String var1) {
      this.ecranaStrLib = var1;
   }

   public String getEcranaAgent() {
      return this.ecranaAgent;
   }

   public void setEcranaAgent(String var1) {
      this.ecranaAgent = var1;
   }

   public String getEcranaAgentLib() {
      return this.ecranaAgentLib;
   }

   public void setEcranaAgentLib(String var1) {
      this.ecranaAgentLib = var1;
   }

   public String getZoneAtelier() {
      return this.zoneAtelier;
   }

   public void setZoneAtelier(String var1) {
      this.zoneAtelier = var1;
   }

   public String getZoneDepartement() {
      return this.zoneDepartement;
   }

   public void setZoneDepartement(String var1) {
      this.zoneDepartement = var1;
   }

   public String getZoneLigne() {
      return this.zoneLigne;
   }

   public void setZoneLigne(String var1) {
      this.zoneLigne = var1;
   }

   public String getZonePdv() {
      return this.zonePdv;
   }

   public void setZonePdv(String var1) {
      this.zonePdv = var1;
   }

   public String getZoneRegion() {
      return this.zoneRegion;
   }

   public void setZoneRegion(String var1) {
      this.zoneRegion = var1;
   }

   public String getZoneSecteur() {
      return this.zoneSecteur;
   }

   public void setZoneSecteur(String var1) {
      this.zoneSecteur = var1;
   }

   public String getZoneService() {
      return this.zoneService;
   }

   public void setZoneService(String var1) {
      this.zoneService = var1;
   }

   public String getZoneSite() {
      return this.zoneSite;
   }

   public void setZoneSite(String var1) {
      this.zoneSite = var1;
   }

   public String getZoneSitePrd() {
      return this.zoneSitePrd;
   }

   public void setZoneSitePrd(String var1) {
      this.zoneSitePrd = var1;
   }

   public String getZoneCol1() {
      return this.zoneCol1;
   }

   public void setZoneCol1(String var1) {
      this.zoneCol1 = var1;
   }

   public String getZoneCol2() {
      return this.zoneCol2;
   }

   public void setZoneCol2(String var1) {
      this.zoneCol2 = var1;
   }

   public String getZoneCol3() {
      return this.zoneCol3;
   }

   public void setZoneCol3(String var1) {
      this.zoneCol3 = var1;
   }

   public List getMesAteliersItems() {
      return this.mesAteliersItems;
   }

   public void setMesAteliersItems(List var1) {
      this.mesAteliersItems = var1;
   }

   public List getMesColonnes1Items() {
      return this.mesColonnes1Items;
   }

   public void setMesColonnes1Items(List var1) {
      this.mesColonnes1Items = var1;
   }

   public List getMesColonnes2Items() {
      return this.mesColonnes2Items;
   }

   public void setMesColonnes2Items(List var1) {
      this.mesColonnes2Items = var1;
   }

   public List getMesColonnes3Items() {
      return this.mesColonnes3Items;
   }

   public void setMesColonnes3Items(List var1) {
      this.mesColonnes3Items = var1;
   }

   public List getMesDepartementsItems() {
      return this.mesDepartementsItems;
   }

   public void setMesDepartementsItems(List var1) {
      this.mesDepartementsItems = var1;
   }

   public List getMesLignesItems() {
      return this.mesLignesItems;
   }

   public void setMesLignesItems(List var1) {
      this.mesLignesItems = var1;
   }

   public List getMesPdvItems() {
      return this.mesPdvItems;
   }

   public void setMesPdvItems(List var1) {
      this.mesPdvItems = var1;
   }

   public List getMesRegionsItems() {
      return this.mesRegionsItems;
   }

   public void setMesRegionsItems(List var1) {
      this.mesRegionsItems = var1;
   }

   public List getMesSecteursItems() {
      return this.mesSecteursItems;
   }

   public void setMesSecteursItems(List var1) {
      this.mesSecteursItems = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public List getMesSitesItems() {
      return this.mesSitesItems;
   }

   public void setMesSitesItems(List var1) {
      this.mesSitesItems = var1;
   }

   public List getMesSitesPrdItems() {
      return this.mesSitesPrdItems;
   }

   public void setMesSitesPrdItems(List var1) {
      this.mesSitesPrdItems = var1;
   }

   public String getZoneActivite() {
      return this.zoneActivite;
   }

   public void setZoneActivite(String var1) {
      this.zoneActivite = var1;
   }

   public String getZoneAnal1() {
      return this.zoneAnal1;
   }

   public void setZoneAnal1(String var1) {
      this.zoneAnal1 = var1;
   }

   public String getZoneAnal3() {
      return this.zoneAnal3;
   }

   public void setZoneAnal3(String var1) {
      this.zoneAnal3 = var1;
   }

   public String getEcranaRepCle() {
      return this.ecranaRepCle;
   }

   public void setEcranaRepCle(String var1) {
      this.ecranaRepCle = var1;
   }

   public String getEcranaStrCle() {
      return this.ecranaStrCle;
   }

   public void setEcranaStrCle(String var1) {
      this.ecranaStrCle = var1;
   }

   public int getEcranaTypeCle() {
      return this.ecranaTypeCle;
   }

   public void setEcranaTypeCle(int var1) {
      this.ecranaTypeCle = var1;
   }

   public String getEcranaPoste() {
      return this.ecranaPoste;
   }

   public void setEcranaPoste(String var1) {
      this.ecranaPoste = var1;
   }

   public String getEcranaPosteLib() {
      return this.ecranaPosteLib;
   }

   public void setEcranaPosteLib(String var1) {
      this.ecranaPosteLib = var1;
   }

   public List getMesPostesItems() {
      return this.mesPostesItems;
   }

   public void setMesPostesItems(List var1) {
      this.mesPostesItems = var1;
   }

   public List getMesProjetsItems() {
      return this.mesProjetsItems;
   }

   public void setMesProjetsItems(List var1) {
      this.mesProjetsItems = var1;
   }

   public boolean isPosVide() {
      if (this.mesPostesItems.size() == 0) {
         this.posVide = true;
      } else {
         this.posVide = false;
      }

      return this.posVide;
   }

   public void setPosVide(boolean var1) {
      this.posVide = var1;
   }

   public String getZonePoste() {
      return this.zonePoste;
   }

   public void setZonePoste(String var1) {
      this.zonePoste = var1;
   }

   public String getZoneProjet() {
      return this.zoneProjet;
   }

   public void setZoneProjet(String var1) {
      this.zoneProjet = var1;
   }

   public String getEcranaEntite() {
      return this.ecranaEntite;
   }

   public void setEcranaEntite(String var1) {
      this.ecranaEntite = var1;
   }

   public String getEcranaEntiteLib() {
      return this.ecranaEntiteLib;
   }

   public void setEcranaEntiteLib(String var1) {
      this.ecranaEntiteLib = var1;
   }

   public boolean isEntVide() {
      if (this.mesEntitesItems.size() == 0) {
         this.entVide = true;
         this.posVide = true;
      } else {
         this.entVide = false;
      }

      return this.entVide;
   }

   public void setEntVide(boolean var1) {
      this.entVide = var1;
   }

   public List getMesEntitesItems() {
      return this.mesEntitesItems;
   }

   public void setMesEntitesItems(List var1) {
      this.mesEntitesItems = var1;
   }

   public String getZoneEntite() {
      return this.zoneEntite;
   }

   public void setZoneEntite(String var1) {
      this.zoneEntite = var1;
   }

   public float getEcranaQteSaisie() {
      return this.ecranaQteSaisie;
   }

   public void setEcranaQteSaisie(float var1) {
      this.ecranaQteSaisie = var1;
   }
}
