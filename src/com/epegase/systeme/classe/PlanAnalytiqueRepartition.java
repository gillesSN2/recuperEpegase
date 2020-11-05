package com.epegase.systeme.classe;

import java.io.Serializable;

public class PlanAnalytiqueRepartition implements Serializable {
   private long cleId;
   private int cleOrdre;
   private String cleCodeActivite;
   private String cleLibelleActivite;
   private double cleRepActivite;
   private String cleCodeSite;
   private String cleLibelleSite;
   private double cleRepSite;
   private String cleCodeDepartement;
   private String cleLibelleDepartement;
   private double cleRepDepartement;
   private String cleCodeService;
   private String cleLibelleService;
   private double cleRepService;
   private String cleCodeRegion;
   private String cleLibelleRegion;
   private double cleRepRegion;
   private String cleCodeSecteur;
   private String cleLibelleSecteur;
   private double cleRepSecteur;
   private String cleCodePdv;
   private String cleLibellePdv;
   private double cleRepPdv;
   private String cleCodeLigne;
   private String cleLibelleLigne;
   private double cleRepLigne;
   private String cleCodeAtelier;
   private String cleLibelleAtelier;
   private double cleRepAtelier;
   private String cleCodeDossier;
   private String cleLibelleDossier;
   private double cleRepDossier;
   private String cleCodeChantier;
   private String cleLibelleChantier;
   private double cleRepChantier;
   private String cleCodeMission;
   private String cleLibelleMission;
   private double cleRepMission;
   private String cleCodeParc;
   private String cleLibelleParc;
   private double cleRepParc;
   private String cleCodeAgent;
   private String cleLibelleAgent;
   private double cleRepAgent;
   private long cleIdStr;
   private String cleSigleStr;
   private String cleNomStr;
   private double cleRepStr;
   private PlansAnalytiques plansAnalytiques;
   private boolean affiche_activite = false;
   private boolean affiche_site = false;
   private boolean affiche_departement = false;
   private boolean affiche_service = false;
   private boolean affiche_region = false;
   private boolean affiche_secteur = false;
   private boolean affiche_pdv = false;
   private boolean affiche_ligne = false;
   private boolean affiche_atelier = false;
   private boolean affiche_dossier = false;
   private boolean affiche_chantier = false;
   private boolean affiche_mission = false;
   private boolean affiche_str = false;
   private boolean affiche_parc = false;
   private boolean affiche_agent = false;
   private boolean affiche_anal1 = false;
   private boolean affiche_anal2 = false;
   private boolean affiche_anal3 = false;
   private boolean affiche_anal4 = false;
   private boolean select_activite = false;
   private boolean select_site = false;
   private boolean select_departement = false;
   private boolean select_service = false;
   private boolean select_region = false;
   private boolean select_secteur = false;
   private boolean select_pdv = false;
   private boolean select_ligne = false;
   private boolean select_atelier = false;
   private boolean select_dossier = false;
   private boolean select_chantier = false;
   private boolean select_mission = false;
   private boolean select_str = false;
   private boolean select_parc = false;
   private boolean select_agent = false;
   private String zoneActivite;
   private String zoneAnal1;
   private String zoneAnal3;
   private double valDebit;
   private double valCredit;

   public String getCleCodeDepartement() {
      return this.cleCodeDepartement;
   }

   public void setCleCodeDepartement(String var1) {
      this.cleCodeDepartement = var1;
   }

   public String getCleCodeService() {
      return this.cleCodeService;
   }

   public void setCleCodeService(String var1) {
      this.cleCodeService = var1;
   }

   public String getCleCodeSite() {
      return this.cleCodeSite;
   }

   public void setCleCodeSite(String var1) {
      this.cleCodeSite = var1;
   }

   public long getCleId() {
      return this.cleId;
   }

   public void setCleId(long var1) {
      this.cleId = var1;
   }

   public String getCleLibelleDepartement() {
      return this.cleLibelleDepartement;
   }

   public void setCleLibelleDepartement(String var1) {
      this.cleLibelleDepartement = var1;
   }

   public String getCleLibelleService() {
      return this.cleLibelleService;
   }

   public void setCleLibelleService(String var1) {
      this.cleLibelleService = var1;
   }

   public String getCleLibelleSite() {
      return this.cleLibelleSite;
   }

   public void setCleLibelleSite(String var1) {
      this.cleLibelleSite = var1;
   }

   public PlansAnalytiques getPlansAnalytiques() {
      return this.plansAnalytiques;
   }

   public void setPlansAnalytiques(PlansAnalytiques var1) {
      this.plansAnalytiques = var1;
   }

   public double getCleRepDepartement() {
      return this.cleRepDepartement;
   }

   public void setCleRepDepartement(double var1) {
      this.cleRepDepartement = var1;
   }

   public double getCleRepService() {
      return this.cleRepService;
   }

   public void setCleRepService(double var1) {
      this.cleRepService = var1;
   }

   public double getCleRepSite() {
      return this.cleRepSite;
   }

   public void setCleRepSite(double var1) {
      this.cleRepSite = var1;
   }

   public boolean isAffiche_site() {
      return this.affiche_site;
   }

   public void setAffiche_site(boolean var1) {
      this.affiche_site = var1;
   }

   public boolean isAffiche_departement() {
      return this.affiche_departement;
   }

   public void setAffiche_departement(boolean var1) {
      this.affiche_departement = var1;
   }

   public boolean isAffiche_service() {
      return this.affiche_service;
   }

   public void setAffiche_service(boolean var1) {
      this.affiche_service = var1;
   }

   public boolean isAffiche_activite() {
      return this.affiche_activite;
   }

   public void setAffiche_activite(boolean var1) {
      this.affiche_activite = var1;
   }

   public String getCleCodeActivite() {
      return this.cleCodeActivite;
   }

   public void setCleCodeActivite(String var1) {
      this.cleCodeActivite = var1;
   }

   public String getCleLibelleActivite() {
      return this.cleLibelleActivite;
   }

   public void setCleLibelleActivite(String var1) {
      this.cleLibelleActivite = var1;
   }

   public double getCleRepActivite() {
      return this.cleRepActivite;
   }

   public void setCleRepActivite(double var1) {
      this.cleRepActivite = var1;
   }

   public boolean isAffiche_agent() {
      return this.affiche_agent;
   }

   public void setAffiche_agent(boolean var1) {
      this.affiche_agent = var1;
   }

   public boolean isAffiche_atelier() {
      return this.affiche_atelier;
   }

   public void setAffiche_atelier(boolean var1) {
      this.affiche_atelier = var1;
   }

   public boolean isAffiche_dossier() {
      return this.affiche_dossier;
   }

   public void setAffiche_dossier(boolean var1) {
      this.affiche_dossier = var1;
   }

   public boolean isAffiche_ligne() {
      return this.affiche_ligne;
   }

   public void setAffiche_ligne(boolean var1) {
      this.affiche_ligne = var1;
   }

   public boolean isAffiche_parc() {
      return this.affiche_parc;
   }

   public void setAffiche_parc(boolean var1) {
      this.affiche_parc = var1;
   }

   public boolean isAffiche_pdv() {
      return this.affiche_pdv;
   }

   public void setAffiche_pdv(boolean var1) {
      this.affiche_pdv = var1;
   }

   public boolean isAffiche_region() {
      return this.affiche_region;
   }

   public void setAffiche_region(boolean var1) {
      this.affiche_region = var1;
   }

   public boolean isAffiche_secteur() {
      return this.affiche_secteur;
   }

   public void setAffiche_secteur(boolean var1) {
      this.affiche_secteur = var1;
   }

   public String getCleCodeAgent() {
      return this.cleCodeAgent;
   }

   public void setCleCodeAgent(String var1) {
      this.cleCodeAgent = var1;
   }

   public String getCleCodeAtelier() {
      return this.cleCodeAtelier;
   }

   public void setCleCodeAtelier(String var1) {
      this.cleCodeAtelier = var1;
   }

   public String getCleCodeDossier() {
      return this.cleCodeDossier;
   }

   public void setCleCodeDossier(String var1) {
      this.cleCodeDossier = var1;
   }

   public String getCleCodeLigne() {
      return this.cleCodeLigne;
   }

   public void setCleCodeLigne(String var1) {
      this.cleCodeLigne = var1;
   }

   public String getCleCodeParc() {
      return this.cleCodeParc;
   }

   public void setCleCodeParc(String var1) {
      this.cleCodeParc = var1;
   }

   public String getCleCodePdv() {
      return this.cleCodePdv;
   }

   public void setCleCodePdv(String var1) {
      this.cleCodePdv = var1;
   }

   public String getCleCodeRegion() {
      return this.cleCodeRegion;
   }

   public void setCleCodeRegion(String var1) {
      this.cleCodeRegion = var1;
   }

   public String getCleCodeSecteur() {
      return this.cleCodeSecteur;
   }

   public void setCleCodeSecteur(String var1) {
      this.cleCodeSecteur = var1;
   }

   public String getCleLibelleAgent() {
      return this.cleLibelleAgent;
   }

   public void setCleLibelleAgent(String var1) {
      this.cleLibelleAgent = var1;
   }

   public String getCleLibelleAtelier() {
      return this.cleLibelleAtelier;
   }

   public void setCleLibelleAtelier(String var1) {
      this.cleLibelleAtelier = var1;
   }

   public String getCleLibelleDossier() {
      return this.cleLibelleDossier;
   }

   public void setCleLibelleDossier(String var1) {
      this.cleLibelleDossier = var1;
   }

   public String getCleLibelleLigne() {
      return this.cleLibelleLigne;
   }

   public void setCleLibelleLigne(String var1) {
      this.cleLibelleLigne = var1;
   }

   public String getCleLibelleParc() {
      return this.cleLibelleParc;
   }

   public void setCleLibelleParc(String var1) {
      this.cleLibelleParc = var1;
   }

   public String getCleLibellePdv() {
      return this.cleLibellePdv;
   }

   public void setCleLibellePdv(String var1) {
      this.cleLibellePdv = var1;
   }

   public String getCleLibelleRegion() {
      return this.cleLibelleRegion;
   }

   public void setCleLibelleRegion(String var1) {
      this.cleLibelleRegion = var1;
   }

   public String getCleLibelleSecteur() {
      return this.cleLibelleSecteur;
   }

   public void setCleLibelleSecteur(String var1) {
      this.cleLibelleSecteur = var1;
   }

   public double getCleRepAgent() {
      return this.cleRepAgent;
   }

   public void setCleRepAgent(double var1) {
      this.cleRepAgent = var1;
   }

   public double getCleRepAtelier() {
      return this.cleRepAtelier;
   }

   public void setCleRepAtelier(double var1) {
      this.cleRepAtelier = var1;
   }

   public double getCleRepDossier() {
      return this.cleRepDossier;
   }

   public void setCleRepDossier(double var1) {
      this.cleRepDossier = var1;
   }

   public double getCleRepLigne() {
      return this.cleRepLigne;
   }

   public void setCleRepLigne(double var1) {
      this.cleRepLigne = var1;
   }

   public double getCleRepParc() {
      return this.cleRepParc;
   }

   public void setCleRepParc(double var1) {
      this.cleRepParc = var1;
   }

   public double getCleRepPdv() {
      return this.cleRepPdv;
   }

   public void setCleRepPdv(double var1) {
      this.cleRepPdv = var1;
   }

   public double getCleRepRegion() {
      return this.cleRepRegion;
   }

   public void setCleRepRegion(double var1) {
      this.cleRepRegion = var1;
   }

   public double getCleRepSecteur() {
      return this.cleRepSecteur;
   }

   public void setCleRepSecteur(double var1) {
      this.cleRepSecteur = var1;
   }

   public boolean isSelect_activite() {
      return this.select_activite;
   }

   public void setSelect_activite(boolean var1) {
      this.select_activite = var1;
   }

   public boolean isSelect_agent() {
      return this.select_agent;
   }

   public void setSelect_agent(boolean var1) {
      this.select_agent = var1;
   }

   public boolean isSelect_atelier() {
      return this.select_atelier;
   }

   public void setSelect_atelier(boolean var1) {
      this.select_atelier = var1;
   }

   public boolean isSelect_departement() {
      return this.select_departement;
   }

   public void setSelect_departement(boolean var1) {
      this.select_departement = var1;
   }

   public boolean isSelect_dossier() {
      return this.select_dossier;
   }

   public void setSelect_dossier(boolean var1) {
      this.select_dossier = var1;
   }

   public boolean isSelect_ligne() {
      return this.select_ligne;
   }

   public void setSelect_ligne(boolean var1) {
      this.select_ligne = var1;
   }

   public boolean isSelect_parc() {
      return this.select_parc;
   }

   public void setSelect_parc(boolean var1) {
      this.select_parc = var1;
   }

   public boolean isSelect_pdv() {
      return this.select_pdv;
   }

   public void setSelect_pdv(boolean var1) {
      this.select_pdv = var1;
   }

   public boolean isSelect_region() {
      return this.select_region;
   }

   public void setSelect_region(boolean var1) {
      this.select_region = var1;
   }

   public boolean isSelect_secteur() {
      return this.select_secteur;
   }

   public void setSelect_secteur(boolean var1) {
      this.select_secteur = var1;
   }

   public boolean isSelect_service() {
      return this.select_service;
   }

   public void setSelect_service(boolean var1) {
      this.select_service = var1;
   }

   public boolean isSelect_site() {
      return this.select_site;
   }

   public void setSelect_site(boolean var1) {
      this.select_site = var1;
   }

   public int getCleOrdre() {
      return this.cleOrdre;
   }

   public void setCleOrdre(int var1) {
      this.cleOrdre = var1;
   }

   public boolean isAffiche_anal1() {
      return this.affiche_anal1;
   }

   public void setAffiche_anal1(boolean var1) {
      this.affiche_anal1 = var1;
   }

   public boolean isAffiche_anal2() {
      return this.affiche_anal2;
   }

   public void setAffiche_anal2(boolean var1) {
      this.affiche_anal2 = var1;
   }

   public boolean isAffiche_anal3() {
      return this.affiche_anal3;
   }

   public void setAffiche_anal3(boolean var1) {
      this.affiche_anal3 = var1;
   }

   public boolean isAffiche_anal4() {
      return this.affiche_anal4;
   }

   public void setAffiche_anal4(boolean var1) {
      this.affiche_anal4 = var1;
   }

   public double getValCredit() {
      return this.valCredit;
   }

   public void setValCredit(double var1) {
      this.valCredit = var1;
   }

   public double getValDebit() {
      return this.valDebit;
   }

   public void setValDebit(double var1) {
      this.valDebit = var1;
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

   public long getCleIdStr() {
      return this.cleIdStr;
   }

   public void setCleIdStr(long var1) {
      this.cleIdStr = var1;
   }

   public String getCleNomStr() {
      return this.cleNomStr;
   }

   public void setCleNomStr(String var1) {
      this.cleNomStr = var1;
   }

   public double getCleRepStr() {
      return this.cleRepStr;
   }

   public void setCleRepStr(double var1) {
      this.cleRepStr = var1;
   }

   public String getCleSigleStr() {
      return this.cleSigleStr;
   }

   public void setCleSigleStr(String var1) {
      this.cleSigleStr = var1;
   }

   public String getCleCodeChantier() {
      return this.cleCodeChantier;
   }

   public void setCleCodeChantier(String var1) {
      this.cleCodeChantier = var1;
   }

   public String getCleCodeMission() {
      return this.cleCodeMission;
   }

   public void setCleCodeMission(String var1) {
      this.cleCodeMission = var1;
   }

   public String getCleLibelleChantier() {
      return this.cleLibelleChantier;
   }

   public void setCleLibelleChantier(String var1) {
      this.cleLibelleChantier = var1;
   }

   public String getCleLibelleMission() {
      return this.cleLibelleMission;
   }

   public void setCleLibelleMission(String var1) {
      this.cleLibelleMission = var1;
   }

   public double getCleRepChantier() {
      return this.cleRepChantier;
   }

   public void setCleRepChantier(double var1) {
      this.cleRepChantier = var1;
   }

   public double getCleRepMission() {
      return this.cleRepMission;
   }

   public void setCleRepMission(double var1) {
      this.cleRepMission = var1;
   }

   public boolean isAffiche_chantier() {
      return this.affiche_chantier;
   }

   public void setAffiche_chantier(boolean var1) {
      this.affiche_chantier = var1;
   }

   public boolean isAffiche_mission() {
      return this.affiche_mission;
   }

   public void setAffiche_mission(boolean var1) {
      this.affiche_mission = var1;
   }

   public boolean isAffiche_str() {
      return this.affiche_str;
   }

   public void setAffiche_str(boolean var1) {
      this.affiche_str = var1;
   }

   public boolean isSelect_chantier() {
      return this.select_chantier;
   }

   public void setSelect_chantier(boolean var1) {
      this.select_chantier = var1;
   }

   public boolean isSelect_mission() {
      return this.select_mission;
   }

   public void setSelect_mission(boolean var1) {
      this.select_mission = var1;
   }

   public boolean isSelect_str() {
      return this.select_str;
   }

   public void setSelect_str(boolean var1) {
      this.select_str = var1;
   }
}
