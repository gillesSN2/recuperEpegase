package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ManifestLigne implements Serializable {
   private long vtelvId;
   private Date vtelvDateCreat;
   private Date vtelvDateModif;
   private long vtelvIdUserCreat;
   private long vtelvIdUserModif;
   private String vtelvNum;
   private int vtelvOrdre;
   private String vtelvImmaCamion;
   private String vtelvModelCamion;
   private String vtelvImmaRemorque1;
   private String vtelvImmaRemorque2;
   private String vtelvMatChauffeurExp;
   private String vtelvNomPrenomChauffeurExp;
   private double vtelvKmsExp;
   private String vtelvIntituleClientExp;
   private String vtelvMatRespExp;
   private String vtelvNomPrenomRespExp;
   private Date vtelvDateExp;
   private String vtelvAdresseExp;
   private String vtelvContactExp;
   private String vtelvMatChauffeurDest;
   private String vtelvNomPrenomChauffeurDest;
   private double vtelvKmsDest;
   private double vtelvKmsReel;
   private String vtelvIntituleClientDest;
   private String vtelvMatRespDest;
   private String vtelvNomPrenomRespDest;
   private Date vtelvDateDest;
   private String vtelvAdresseDest;
   private String vtelvContactDest;
   private String vtelvDossier;
   private String vtelvObservation;
   private int vtelvValeurAssuree;
   private String vtelvNumManifest;
   private int vtelvNbreColisExp;
   private float vtelvPoidsExp;
   private float vtelvVolumeExp;
   private int vtelvNbreColisDest;
   private float vtelvPoidsDest;
   private float vtelvVolumeDest;
   private String vtelvIntituleClient;
   private String vtelvCompteClient;
   private String vtelvCat;
   private int vtelvExoTva;
   private int vtelvExoTc;
   private int vtelvModeClient;
   private int vtelvModeFacture;
   private int vtelvModeAssuree;
   private int vtelvModeGroupe;
   private double vtelvTotalHt;
   private double vtelvTotalTva;
   private double vtelvTotalTtc;
   private double vtelvTc;
   private double vtelvTotalReglement;
   private String vtelvNumDevis;
   private String vtelvNumFacture;
   private ManifestEntete manifestEntete;
   private Tiers tiers;
   private String styleLigne;
   private String nomProduit;
   private String numContener;
   private String numPlomb;
   private int nombre;
   private float poids;
   private float volume;

   public ManifestEntete getManifestEntete() {
      return this.manifestEntete;
   }

   public void setManifestEntete(ManifestEntete var1) {
      this.manifestEntete = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public int getNombre() {
      return this.nombre;
   }

   public void setNombre(int var1) {
      this.nombre = var1;
   }

   public float getPoids() {
      return this.poids;
   }

   public void setPoids(float var1) {
      this.poids = var1;
   }

   public float getVolume() {
      return this.volume;
   }

   public void setVolume(float var1) {
      this.volume = var1;
   }

   public String getNomProduit() {
      return this.nomProduit;
   }

   public void setNomProduit(String var1) {
      this.nomProduit = var1;
   }

   public String getNumContener() {
      return this.numContener;
   }

   public void setNumContener(String var1) {
      this.numContener = var1;
   }

   public String getNumPlomb() {
      return this.numPlomb;
   }

   public void setNumPlomb(String var1) {
      this.numPlomb = var1;
   }

   public String getStyleLigne() {
      return this.styleLigne;
   }

   public void setStyleLigne(String var1) {
      this.styleLigne = var1;
   }

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

   public String getVtelvCat() {
      return this.vtelvCat;
   }

   public void setVtelvCat(String var1) {
      this.vtelvCat = var1;
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

   public Date getVtelvDateCreat() {
      return this.vtelvDateCreat;
   }

   public void setVtelvDateCreat(Date var1) {
      this.vtelvDateCreat = var1;
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

   public Date getVtelvDateModif() {
      return this.vtelvDateModif;
   }

   public void setVtelvDateModif(Date var1) {
      this.vtelvDateModif = var1;
   }

   public String getVtelvDossier() {
      return this.vtelvDossier;
   }

   public void setVtelvDossier(String var1) {
      this.vtelvDossier = var1;
   }

   public int getVtelvExoTc() {
      return this.vtelvExoTc;
   }

   public void setVtelvExoTc(int var1) {
      this.vtelvExoTc = var1;
   }

   public int getVtelvExoTva() {
      return this.vtelvExoTva;
   }

   public void setVtelvExoTva(int var1) {
      this.vtelvExoTva = var1;
   }

   public long getVtelvId() {
      return this.vtelvId;
   }

   public void setVtelvId(long var1) {
      this.vtelvId = var1;
   }

   public long getVtelvIdUserCreat() {
      return this.vtelvIdUserCreat;
   }

   public void setVtelvIdUserCreat(long var1) {
      this.vtelvIdUserCreat = var1;
   }

   public long getVtelvIdUserModif() {
      return this.vtelvIdUserModif;
   }

   public void setVtelvIdUserModif(long var1) {
      this.vtelvIdUserModif = var1;
   }

   public String getVtelvImmaCamion() {
      return this.vtelvImmaCamion;
   }

   public void setVtelvImmaCamion(String var1) {
      this.vtelvImmaCamion = var1;
   }

   public String getVtelvImmaRemorque1() {
      return this.vtelvImmaRemorque1;
   }

   public void setVtelvImmaRemorque1(String var1) {
      this.vtelvImmaRemorque1 = var1;
   }

   public String getVtelvImmaRemorque2() {
      return this.vtelvImmaRemorque2;
   }

   public void setVtelvImmaRemorque2(String var1) {
      this.vtelvImmaRemorque2 = var1;
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

   public double getVtelvKmsDest() {
      return this.vtelvKmsDest;
   }

   public void setVtelvKmsDest(double var1) {
      this.vtelvKmsDest = var1;
   }

   public double getVtelvKmsExp() {
      return this.vtelvKmsExp;
   }

   public void setVtelvKmsExp(double var1) {
      this.vtelvKmsExp = var1;
   }

   public double getVtelvKmsReel() {
      return this.vtelvKmsReel;
   }

   public void setVtelvKmsReel(double var1) {
      this.vtelvKmsReel = var1;
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

   public int getVtelvModeClient() {
      return this.vtelvModeClient;
   }

   public void setVtelvModeClient(int var1) {
      this.vtelvModeClient = var1;
   }

   public int getVtelvModeFacture() {
      return this.vtelvModeFacture;
   }

   public void setVtelvModeFacture(int var1) {
      this.vtelvModeFacture = var1;
   }

   public String getVtelvModelCamion() {
      return this.vtelvModelCamion;
   }

   public void setVtelvModelCamion(String var1) {
      this.vtelvModelCamion = var1;
   }

   public int getVtelvNbreColisDest() {
      return this.vtelvNbreColisDest;
   }

   public void setVtelvNbreColisDest(int var1) {
      this.vtelvNbreColisDest = var1;
   }

   public int getVtelvNbreColisExp() {
      return this.vtelvNbreColisExp;
   }

   public void setVtelvNbreColisExp(int var1) {
      this.vtelvNbreColisExp = var1;
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

   public String getVtelvNumDevis() {
      return this.vtelvNumDevis;
   }

   public void setVtelvNumDevis(String var1) {
      this.vtelvNumDevis = var1;
   }

   public String getVtelvNumFacture() {
      return this.vtelvNumFacture;
   }

   public void setVtelvNumFacture(String var1) {
      this.vtelvNumFacture = var1;
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

   public float getVtelvPoidsDest() {
      return this.vtelvPoidsDest;
   }

   public void setVtelvPoidsDest(float var1) {
      this.vtelvPoidsDest = var1;
   }

   public float getVtelvPoidsExp() {
      return this.vtelvPoidsExp;
   }

   public void setVtelvPoidsExp(float var1) {
      this.vtelvPoidsExp = var1;
   }

   public double getVtelvTc() {
      return this.vtelvTc;
   }

   public void setVtelvTc(double var1) {
      this.vtelvTc = var1;
   }

   public double getVtelvTotalHt() {
      return this.vtelvTotalHt;
   }

   public void setVtelvTotalHt(double var1) {
      this.vtelvTotalHt = var1;
   }

   public double getVtelvTotalReglement() {
      return this.vtelvTotalReglement;
   }

   public void setVtelvTotalReglement(double var1) {
      this.vtelvTotalReglement = var1;
   }

   public double getVtelvTotalTtc() {
      return this.vtelvTotalTtc;
   }

   public void setVtelvTotalTtc(double var1) {
      this.vtelvTotalTtc = var1;
   }

   public double getVtelvTotalTva() {
      return this.vtelvTotalTva;
   }

   public void setVtelvTotalTva(double var1) {
      this.vtelvTotalTva = var1;
   }

   public int getVtelvValeurAssuree() {
      return this.vtelvValeurAssuree;
   }

   public void setVtelvValeurAssuree(int var1) {
      this.vtelvValeurAssuree = var1;
   }

   public float getVtelvVolumeDest() {
      return this.vtelvVolumeDest;
   }

   public void setVtelvVolumeDest(float var1) {
      this.vtelvVolumeDest = var1;
   }

   public float getVtelvVolumeExp() {
      return this.vtelvVolumeExp;
   }

   public void setVtelvVolumeExp(float var1) {
      this.vtelvVolumeExp = var1;
   }

   public int getVtelvModeAssuree() {
      return this.vtelvModeAssuree;
   }

   public void setVtelvModeAssuree(int var1) {
      this.vtelvModeAssuree = var1;
   }

   public int getVtelvModeGroupe() {
      return this.vtelvModeGroupe;
   }

   public void setVtelvModeGroupe(int var1) {
      this.vtelvModeGroupe = var1;
   }
}
