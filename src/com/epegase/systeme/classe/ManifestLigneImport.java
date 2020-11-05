package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ManifestLigneImport implements Serializable {
   private long vtelvId;
   private String vtelvNum;
   private int vtelvOrdre;
   private String vtelvRefParc;
   private String vtelvImmaParc;
   private String vtelvCamion;
   private String vtelvModelCamion;
   private String vtelvImmaCamion;
   private String vtelvMatChauffeurExp;
   private String vtelvNomPrenomChauffeurExp;
   private String vtelvNumClientExp;
   private String vtelvIntituleClientExp;
   private String vtelvMatRespExp;
   private String vtelvNomPrenomRespExp;
   private Date vtelvDateExp;
   private String vtelvAdresseExp;
   private String vtelvRefLieuExp;
   private String vtelvLibLieuExp;
   private String vtelvContactExp;
   private String vtelvMatChauffeurDest;
   private String vtelvNomPrenomChauffeurDest;
   private String vtelvNumClientDest;
   private String vtelvIntituleClientDest;
   private String vtelvMatRespDest;
   private String vtelvNomPrenomRespDest;
   private Date vtelvDateDest;
   private String vtelvAdresseDest;
   private String vtelvRefLieuDest;
   private String vtelvLibLieuDest;
   private String vtelvContactDest;
   private String vtelvFinSaisie;
   private String vtelvDossier;
   private String vtelvObservation;
   private String vtelvPortPaye;
   private String vtelvPortDu;
   private String vtelvValeurAssuree;
   private String vtelvPerteVol;
   private String vtelvTousRisques;
   private String vtelvTransport;
   private String vtelvTca;
   private String vtelvNumManifest;
   private String vtelvRefTypeColis;
   private String vtelvLibTypeColis;
   private String vtelvNatureColis;
   private int vtelvNbreColis;
   private float vtelvPoids;
   private float vtelvVolume;
   private String vtelvDescription;
   private String vtelvIntituleClient;
   private String vtelvNumClient;
   private String vtelvCompteClient;
   private Date vtelvDateSaisie;
   private Date vtelvDateModification;
   private String vtelvLoginUser;
   private String vtelvModelParc;
   private String vtelvImmaTc;
   private String vtelvModelTc;

   public String getVtelvAdresseDest() {
      return this.vtelvAdresseDest;
   }

   public void setVtelvAdresseDest(String var1) {
      this.vtelvAdresseDest = var1;
   }

   public String getVtelvAdresseExp() {
      return this.vtelvAdresseExp;
   }

   public void setVtelvAdresseExp(String var1) {
      this.vtelvAdresseExp = var1;
   }

   public String getVtelvCamion() {
      return this.vtelvCamion;
   }

   public void setVtelvCamion(String var1) {
      this.vtelvCamion = var1;
   }

   public String getVtelvCompteClient() {
      return this.vtelvCompteClient;
   }

   public void setVtelvCompteClient(String var1) {
      this.vtelvCompteClient = var1;
   }

   public String getVtelvContactDest() {
      return this.vtelvContactDest;
   }

   public void setVtelvContactDest(String var1) {
      this.vtelvContactDest = var1;
   }

   public String getVtelvContactExp() {
      return this.vtelvContactExp;
   }

   public void setVtelvContactExp(String var1) {
      this.vtelvContactExp = var1;
   }

   public Date getVtelvDateDest() {
      return this.vtelvDateDest;
   }

   public void setVtelvDateDest(Date var1) {
      this.vtelvDateDest = var1;
   }

   public Date getVtelvDateExp() {
      return this.vtelvDateExp;
   }

   public void setVtelvDateExp(Date var1) {
      this.vtelvDateExp = var1;
   }

   public Date getVtelvDateModification() {
      return this.vtelvDateModification;
   }

   public void setVtelvDateModification(Date var1) {
      this.vtelvDateModification = var1;
   }

   public Date getVtelvDateSaisie() {
      return this.vtelvDateSaisie;
   }

   public void setVtelvDateSaisie(Date var1) {
      this.vtelvDateSaisie = var1;
   }

   public String getVtelvDescription() {
      return this.vtelvDescription;
   }

   public void setVtelvDescription(String var1) {
      this.vtelvDescription = var1;
   }

   public String getVtelvDossier() {
      return this.vtelvDossier;
   }

   public void setVtelvDossier(String var1) {
      this.vtelvDossier = var1;
   }

   public String getVtelvFinSaisie() {
      return this.vtelvFinSaisie;
   }

   public void setVtelvFinSaisie(String var1) {
      this.vtelvFinSaisie = var1;
   }

   public long getVtelvId() {
      return this.vtelvId;
   }

   public void setVtelvId(long var1) {
      this.vtelvId = var1;
   }

   public String getVtelvImmaCamion() {
      return this.vtelvImmaCamion;
   }

   public void setVtelvImmaCamion(String var1) {
      this.vtelvImmaCamion = var1;
   }

   public String getVtelvImmaParc() {
      return this.vtelvImmaParc;
   }

   public void setVtelvImmaParc(String var1) {
      this.vtelvImmaParc = var1;
   }

   public String getVtelvImmaTc() {
      return this.vtelvImmaTc;
   }

   public void setVtelvImmaTc(String var1) {
      this.vtelvImmaTc = var1;
   }

   public String getVtelvIntituleClient() {
      return this.vtelvIntituleClient;
   }

   public void setVtelvIntituleClient(String var1) {
      this.vtelvIntituleClient = var1;
   }

   public String getVtelvIntituleClientDest() {
      return this.vtelvIntituleClientDest;
   }

   public void setVtelvIntituleClientDest(String var1) {
      this.vtelvIntituleClientDest = var1;
   }

   public String getVtelvIntituleClientExp() {
      return this.vtelvIntituleClientExp;
   }

   public void setVtelvIntituleClientExp(String var1) {
      this.vtelvIntituleClientExp = var1;
   }

   public String getVtelvLibLieuDest() {
      return this.vtelvLibLieuDest;
   }

   public void setVtelvLibLieuDest(String var1) {
      this.vtelvLibLieuDest = var1;
   }

   public String getVtelvLibLieuExp() {
      return this.vtelvLibLieuExp;
   }

   public void setVtelvLibLieuExp(String var1) {
      this.vtelvLibLieuExp = var1;
   }

   public String getVtelvLibTypeColis() {
      return this.vtelvLibTypeColis;
   }

   public void setVtelvLibTypeColis(String var1) {
      this.vtelvLibTypeColis = var1;
   }

   public String getVtelvLoginUser() {
      return this.vtelvLoginUser;
   }

   public void setVtelvLoginUser(String var1) {
      this.vtelvLoginUser = var1;
   }

   public String getVtelvMatChauffeurDest() {
      return this.vtelvMatChauffeurDest;
   }

   public void setVtelvMatChauffeurDest(String var1) {
      this.vtelvMatChauffeurDest = var1;
   }

   public String getVtelvMatChauffeurExp() {
      return this.vtelvMatChauffeurExp;
   }

   public void setVtelvMatChauffeurExp(String var1) {
      this.vtelvMatChauffeurExp = var1;
   }

   public String getVtelvMatRespDest() {
      return this.vtelvMatRespDest;
   }

   public void setVtelvMatRespDest(String var1) {
      this.vtelvMatRespDest = var1;
   }

   public String getVtelvMatRespExp() {
      return this.vtelvMatRespExp;
   }

   public void setVtelvMatRespExp(String var1) {
      this.vtelvMatRespExp = var1;
   }

   public String getVtelvModelCamion() {
      return this.vtelvModelCamion;
   }

   public void setVtelvModelCamion(String var1) {
      this.vtelvModelCamion = var1;
   }

   public String getVtelvModelParc() {
      return this.vtelvModelParc;
   }

   public void setVtelvModelParc(String var1) {
      this.vtelvModelParc = var1;
   }

   public String getVtelvModelTc() {
      return this.vtelvModelTc;
   }

   public void setVtelvModelTc(String var1) {
      this.vtelvModelTc = var1;
   }

   public String getVtelvNatureColis() {
      return this.vtelvNatureColis;
   }

   public void setVtelvNatureColis(String var1) {
      this.vtelvNatureColis = var1;
   }

   public int getVtelvNbreColis() {
      return this.vtelvNbreColis;
   }

   public void setVtelvNbreColis(int var1) {
      this.vtelvNbreColis = var1;
   }

   public String getVtelvNomPrenomChauffeurDest() {
      return this.vtelvNomPrenomChauffeurDest;
   }

   public void setVtelvNomPrenomChauffeurDest(String var1) {
      this.vtelvNomPrenomChauffeurDest = var1;
   }

   public String getVtelvNomPrenomChauffeurExp() {
      return this.vtelvNomPrenomChauffeurExp;
   }

   public void setVtelvNomPrenomChauffeurExp(String var1) {
      this.vtelvNomPrenomChauffeurExp = var1;
   }

   public String getVtelvNomPrenomRespDest() {
      return this.vtelvNomPrenomRespDest;
   }

   public void setVtelvNomPrenomRespDest(String var1) {
      this.vtelvNomPrenomRespDest = var1;
   }

   public String getVtelvNomPrenomRespExp() {
      return this.vtelvNomPrenomRespExp;
   }

   public void setVtelvNomPrenomRespExp(String var1) {
      this.vtelvNomPrenomRespExp = var1;
   }

   public String getVtelvNum() {
      return this.vtelvNum;
   }

   public void setVtelvNum(String var1) {
      this.vtelvNum = var1;
   }

   public String getVtelvNumClient() {
      return this.vtelvNumClient;
   }

   public void setVtelvNumClient(String var1) {
      this.vtelvNumClient = var1;
   }

   public String getVtelvNumClientDest() {
      return this.vtelvNumClientDest;
   }

   public void setVtelvNumClientDest(String var1) {
      this.vtelvNumClientDest = var1;
   }

   public String getVtelvNumClientExp() {
      return this.vtelvNumClientExp;
   }

   public void setVtelvNumClientExp(String var1) {
      this.vtelvNumClientExp = var1;
   }

   public String getVtelvNumManifest() {
      return this.vtelvNumManifest;
   }

   public void setVtelvNumManifest(String var1) {
      this.vtelvNumManifest = var1;
   }

   public String getVtelvObservation() {
      return this.vtelvObservation;
   }

   public void setVtelvObservation(String var1) {
      this.vtelvObservation = var1;
   }

   public int getVtelvOrdre() {
      return this.vtelvOrdre;
   }

   public void setVtelvOrdre(int var1) {
      this.vtelvOrdre = var1;
   }

   public String getVtelvPerteVol() {
      return this.vtelvPerteVol;
   }

   public void setVtelvPerteVol(String var1) {
      this.vtelvPerteVol = var1;
   }

   public float getVtelvPoids() {
      return this.vtelvPoids;
   }

   public void setVtelvPoids(float var1) {
      this.vtelvPoids = var1;
   }

   public String getVtelvPortDu() {
      return this.vtelvPortDu;
   }

   public void setVtelvPortDu(String var1) {
      this.vtelvPortDu = var1;
   }

   public String getVtelvPortPaye() {
      return this.vtelvPortPaye;
   }

   public void setVtelvPortPaye(String var1) {
      this.vtelvPortPaye = var1;
   }

   public String getVtelvRefLieuDest() {
      return this.vtelvRefLieuDest;
   }

   public void setVtelvRefLieuDest(String var1) {
      this.vtelvRefLieuDest = var1;
   }

   public String getVtelvRefLieuExp() {
      return this.vtelvRefLieuExp;
   }

   public void setVtelvRefLieuExp(String var1) {
      this.vtelvRefLieuExp = var1;
   }

   public String getVtelvRefParc() {
      return this.vtelvRefParc;
   }

   public void setVtelvRefParc(String var1) {
      this.vtelvRefParc = var1;
   }

   public String getVtelvRefTypeColis() {
      return this.vtelvRefTypeColis;
   }

   public void setVtelvRefTypeColis(String var1) {
      this.vtelvRefTypeColis = var1;
   }

   public String getVtelvTca() {
      return this.vtelvTca;
   }

   public void setVtelvTca(String var1) {
      this.vtelvTca = var1;
   }

   public String getVtelvTousRisques() {
      return this.vtelvTousRisques;
   }

   public void setVtelvTousRisques(String var1) {
      this.vtelvTousRisques = var1;
   }

   public String getVtelvTransport() {
      return this.vtelvTransport;
   }

   public void setVtelvTransport(String var1) {
      this.vtelvTransport = var1;
   }

   public String getVtelvValeurAssuree() {
      return this.vtelvValeurAssuree;
   }

   public void setVtelvValeurAssuree(String var1) {
      this.vtelvValeurAssuree = var1;
   }

   public float getVtelvVolume() {
      return this.vtelvVolume;
   }

   public void setVtelvVolume(float var1) {
      this.vtelvVolume = var1;
   }
}
