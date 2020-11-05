package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Produits implements Serializable {
   private long proId;
   private Date proDateCreat;
   private Date proDateModif;
   private long proUserCreat;
   private long proUserModif;
   private String proCode;
   private String proCodeOption;
   private String proBarre;
   private String proDescrip;
   private String proLibClient;
   private String proLibTech;
   private String proAchCode;
   private String proAchLib;
   private String proAchDouane;
   private String proAchTva;
   private String proAchCpteLoc;
   private String proAchCpteZ;
   private String proAchCpteHz;
   private String proAchCpteCh;
   private String proAchCpteSt;
   private String proAchCpteEc;
   private String proAchNat;
   private String proVteCode;
   private String proVteLib;
   private String proVteDouane;
   private String proVteTva;
   private String proVteCpteLoc;
   private String proVteCpteNTx;
   private String proVteCpteZ;
   private String proVteCpteHz;
   private String proVteCptePr;
   private String proVteCpteSt;
   private String proVteCpteCa;
   private String proVteNat;
   private int proStock;
   private String proCondition1;
   private String proCondition2;
   private String proCondition3;
   private String proCondition4;
   private String proCondition5;
   private String proActivite;
   private String proCle1;
   private String proCle2;
   private String proPromo;
   private String proLettre;
   private float proLongueur;
   private float proLargeur;
   private float proEpaisseur;
   private float proVolume;
   private float proPoidsBrut;
   private float proPoidsNet;
   private float proPoidsTare;
   private float proDiamInt;
   private float proDiamExt;
   private float proDensite;
   private String proEtat;
   private float proPression;
   private String proUsage;
   private String proManchon;
   private float proNbUnite;
   private float proNbUniteCnamgs;
   private String proDepotAch;
   private String proDepotPrd;
   private String proDepotVte;
   private double proDefPump;
   private Date proDefDtePump;
   private String proGrpInv;
   private int proMode;
   private int proGrace;
   private String proMarque;
   private String proCouleur;
   private String proConstructeur;
   private String proCodeLie;
   private float proQteLie;
   private int proImpDesciption;
   private int proInactif;
   private String proPhoto;
   private int proPhotoTaille;
   private String proPdf;
   private String proFormule;
   private int proPublic;
   private Date proDatePublic;
   private boolean publicBool;
   private String proEnergie;
   private int proNbPorte;
   private int proBoiteVitesse;
   private int proPuissance;
   private int proCylindree;
   private String proGenre;
   private String proCarrosserie;
   private int proNbPlace;
   private int proPuissanceDin;
   private int proRemise;
   private double proPrcHt;
   private double proPrcExoP;
   private double proPrcExoT;
   private double proPrgHt;
   private double proPrgExoP;
   private double proPrgExoT;
   private double proPA;
   private double proFret;
   private double proAssurance;
   private String proDevise;
   private float proCoefDevise;
   private double proCaf;
   private float proQteStock;
   private float proQteCmdFournisseur;
   private float proQteCmdClient;
   private double proComUnite;
   private float proComPourcentage;
   private int proProcess;
   private String proModelePr;
   private boolean proAvecService;
   private int proPecBilan;
   private int proMajoration;
   private boolean proExoTva;
   private String proSerie;
   private String lib_stock;
   private boolean inactif;
   private boolean afficheImag;
   private String etat;
   private boolean var_select;
   private boolean libelle_libre;
   private double pa;
   private float proCoefVte;
   private double pump;
   private double pv1;
   private double pv2;
   private double pv3;
   private double pv4;
   private double pv5;
   private double pv6;
   private double pv7;
   private double pv8;
   private double pv9;
   private double pv10;
   private double pvCnamgs;
   private double pv1Marche;
   private double pv2Marche;
   private double pv3Marche;
   private double pv4Marche;
   private double pv5Marche;
   private double pv6Marche;
   private double pv7Marche;
   private double pv8Marche;
   private double pv9Marche;
   private double pv10Marche;
   private String photo;
   private String lib_mode;
   private String commentaire;
   private float qteConditionne;
   private String nomTarif;
   private String prixTarif;

   public String getPrixTarif() {
      return this.prixTarif;
   }

   public void setPrixTarif(String var1) {
      this.prixTarif = var1;
   }

   public String getNomTarif() {
      return this.nomTarif;
   }

   public void setNomTarif(String var1) {
      this.nomTarif = var1;
   }

   public float getQteConditionne() {
      this.qteConditionne = 0.0F;
      if (this.proCondition5 != null && !this.proCondition5.isEmpty() && this.proCondition5.contains("/") && this.proCondition5.contains(":")) {
         String[] var1 = this.proCondition5.split("/");
         String[] var2 = var1[1].split(":");
         float var3 = Float.parseFloat(var2[0]);
         double var4 = 0.0D;
         int var6 = 0;
         int var7 = 0;
         int var8 = 0;
         if (var3 != 0.0F) {
            var4 = (double)(this.proQteStock / var3);
            var6 = (int)(this.proQteStock / var3);
            var7 = (int)((double)var6 * var4 - (double)this.proQteStock);
            var8 = (int)((float)((int)this.proQteStock) - (float)var6 * var3);
         } else if (this.proNbUnite != 0.0F) {
            var4 = (double)(this.proQteStock / this.proNbUnite);
            var6 = (int)(this.proQteStock / this.proNbUnite);
            var7 = (int)((double)var6 * var4 - (double)this.proQteStock);
            var8 = (int)((float)((int)this.proQteStock) - (float)var6 * this.proNbUnite);
         }

         if (var7 != 0) {
            if (var8 < 0) {
               this.qteConditionne = (float)var8;
            } else {
               this.qteConditionne = Float.parseFloat(var6 + "." + var8);
            }
         } else {
            this.qteConditionne = (float)var6;
         }
      }

      return this.qteConditionne;
   }

   public void setQteConditionne(float var1) {
      this.qteConditionne = var1;
   }

   public String getCommentaire() {
      return this.commentaire;
   }

   public void setCommentaire(String var1) {
      this.commentaire = var1;
   }

   public String getLib_stock() {
      if (this.proStock == 0) {
         this.lib_stock = "Sans stock";
      } else if (this.proStock == 1) {
         this.lib_stock = "Simple";
      } else if (this.proStock == 2) {
         this.lib_stock = "LIFO";
      } else if (this.proStock == 3) {
         this.lib_stock = "FIFO";
      } else if (this.proStock == 4) {
         this.lib_stock = "PEREMPTION";
      } else if (this.proStock == 5) {
         this.lib_stock = "SERIALISE";
      } else if (this.proStock == 6) {
         this.lib_stock = "CONSIGNE";
      } else if (this.proStock == 7) {
         this.lib_stock = "DEBOURS";
      }

      return this.lib_stock;
   }

   public void setLib_stock(String var1) {
      this.lib_stock = var1;
   }

   public String getEtat() {
      if (this.proInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.proInactif == 2) {
         this.etat = "/images/supprimer.gif";
      } else {
         this.etat = "";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.proInactif != 1 && this.proInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public double getPv1() {
      return this.pv1;
   }

   public void setPv1(double var1) {
      this.pv1 = var1;
   }

   public double getPv2() {
      return this.pv2;
   }

   public void setPv2(double var1) {
      this.pv2 = var1;
   }

   public double getPv3() {
      return this.pv3;
   }

   public void setPv3(double var1) {
      this.pv3 = var1;
   }

   public double getPv4() {
      return this.pv4;
   }

   public void setPv4(double var1) {
      this.pv4 = var1;
   }

   public double getPv5() {
      return this.pv5;
   }

   public void setPv5(double var1) {
      this.pv5 = var1;
   }

   public String getPhoto() {
      return this.photo;
   }

   public void setPhoto(String var1) {
      this.photo = var1;
   }

   public String getLib_mode() {
      if (this.proAchNat != null) {
         if (this.proAchNat.equals("0104")) {
            if (this.proMode == 0) {
               this.lib_mode = "NR";
            } else if (this.proMode == 1) {
               this.lib_mode = "Essence";
            } else if (this.proMode == 2) {
               this.lib_mode = "Gazoil";
            } else if (this.proMode == 3) {
               this.lib_mode = "GPL";
            } else if (this.proMode == 4) {
               this.lib_mode = "Kérosène";
            } else if (this.proMode == 5) {
               this.lib_mode = "Fuel";
            } else if (this.proMode == 6) {
               this.lib_mode = "JetA1";
            } else if (this.proMode == 7) {
               this.lib_mode = "Electrique";
            } else if (this.proMode == 8) {
               this.lib_mode = "Hybride";
            } else if (this.proMode == 9) {
               this.lib_mode = "Solaire";
            } else if (this.proMode == 10) {
               this.lib_mode = "Charbon";
            } else if (this.proMode == 11) {
               this.lib_mode = "Nucléaire";
            } else if (this.proMode == 12) {
               this.lib_mode = "Autre";
            }
         } else if (this.proAchNat.equals("0108")) {
            if (this.proMode == 0) {
               this.lib_mode = "Divers";
            } else if (this.proMode == 1) {
               this.lib_mode = "Action";
            } else if (this.proMode == 2) {
               this.lib_mode = "Traitement";
            } else if (this.proMode == 3) {
               this.lib_mode = "Vaccin";
            }
         } else if (this.proAchNat.equals("0112")) {
            if (this.proMode == 0) {
               this.lib_mode = "Divers";
            } else if (this.proMode == 1) {
               this.lib_mode = "Fret";
            } else if (this.proMode == 2) {
               this.lib_mode = "Assurance";
            } else if (this.proMode == 3) {
               this.lib_mode = "Douane";
            } else if (this.proMode == 4) {
               this.lib_mode = "Tva";
            } else if (this.proMode == 5) {
               this.lib_mode = "Transit";
            } else if (this.proMode == 6) {
               this.lib_mode = "Débours";
            } else if (this.proMode == 7) {
               this.lib_mode = "Caution";
            } else if (this.proMode == 8) {
               this.lib_mode = "Financier";
            } else if (this.proMode == 9) {
               this.lib_mode = "Achat Compl.";
            }
         } else if (this.proMode == 0) {
            this.lib_mode = "";
         } else if (this.proMode == 1) {
            this.lib_mode = "GrpV.";
         } else if (this.proMode == 2) {
            this.lib_mode = "GrpI.";
         } else if (this.proMode == 3) {
            this.lib_mode = "For.";
         } else if (this.proMode == 4) {
            this.lib_mode = "Cal.";
         } else if (this.proMode == 5) {
            this.lib_mode = "Gen.";
         }
      } else if (this.proVteNat != null) {
         if (this.proVteNat.equals("1612")) {
            this.lib_mode = "Chargement";
         } else if (this.proMode == 0) {
            this.lib_mode = "";
         } else if (this.proMode == 1) {
            this.lib_mode = "GrpV.";
         } else if (this.proMode == 2) {
            this.lib_mode = "GrpI.";
         } else if (this.proMode == 3) {
            this.lib_mode = "For.";
         } else if (this.proMode == 4) {
            this.lib_mode = "Cal.";
         } else if (this.proMode == 5) {
            this.lib_mode = "Gen.";
         }
      } else if (this.proMode == 0) {
         this.lib_mode = "";
      } else if (this.proMode == 1) {
         this.lib_mode = "GrpV.";
      } else if (this.proMode == 2) {
         this.lib_mode = "GrpI.";
      } else if (this.proMode == 3) {
         this.lib_mode = "For.";
      } else if (this.proMode == 4) {
         this.lib_mode = "Cal.";
      } else if (this.proMode == 5) {
         this.lib_mode = "Gen.";
      }

      return this.lib_mode;
   }

   public void setLib_mode(String var1) {
      this.lib_mode = var1;
   }

   public String getProAchCode() {
      return this.proAchCode;
   }

   public String getProBarre() {
      return this.proBarre;
   }

   public String getProDescrip() {
      return this.proDescrip;
   }

   public void setProDescrip(String var1) {
      this.proDescrip = var1;
   }

   public void setProAchCode(String var1) {
      this.proAchCode = var1;
   }

   public String getProAchCpteCh() {
      return this.proAchCpteCh;
   }

   public void setProAchCpteCh(String var1) {
      this.proAchCpteCh = var1;
   }

   public String getProAchCpteHz() {
      return this.proAchCpteHz;
   }

   public void setProAchCpteHz(String var1) {
      this.proAchCpteHz = var1;
   }

   public String getProAchCpteLoc() {
      return this.proAchCpteLoc;
   }

   public void setProAchCpteLoc(String var1) {
      this.proAchCpteLoc = var1;
   }

   public String getProAchCpteSt() {
      return this.proAchCpteSt;
   }

   public void setProAchCpteSt(String var1) {
      this.proAchCpteSt = var1;
   }

   public String getProAchCpteZ() {
      return this.proAchCpteZ;
   }

   public void setProAchCpteZ(String var1) {
      this.proAchCpteZ = var1;
   }

   public String getProAchDouane() {
      return this.proAchDouane;
   }

   public void setProAchDouane(String var1) {
      this.proAchDouane = var1;
   }

   public String getProAchLib() {
      return this.proAchLib;
   }

   public void setProAchLib(String var1) {
      this.proAchLib = var1;
   }

   public String getProAchNat() {
      return this.proAchNat;
   }

   public void setProAchNat(String var1) {
      this.proAchNat = var1;
   }

   public String getProAchTva() {
      return this.proAchTva;
   }

   public void setProAchTva(String var1) {
      this.proAchTva = var1;
   }

   public String getProActivite() {
      return this.proActivite;
   }

   public void setProActivite(String var1) {
      this.proActivite = var1;
   }

   public String getProCode() {
      if (this.proCode != null && !this.proCode.isEmpty()) {
         this.proCode = this.proCode.toUpperCase();
      }

      return this.proCode;
   }

   public void setProCode(String var1) {
      this.proCode = var1;
   }

   public String getProCodeLie() {
      if (this.proCodeLie != null && !this.proCodeLie.isEmpty()) {
         this.proCodeLie = this.proCodeLie.toUpperCase();
      }

      return this.proCodeLie;
   }

   public void setProCodeLie(String var1) {
      this.proCodeLie = var1;
   }

   public String getProConstructeur() {
      if (this.proConstructeur != null && !this.proConstructeur.isEmpty()) {
         this.proConstructeur = this.proConstructeur.toUpperCase();
      }

      return this.proConstructeur;
   }

   public void setProConstructeur(String var1) {
      this.proConstructeur = var1;
   }

   public Date getProDefDtePump() {
      return this.proDefDtePump;
   }

   public void setProDefDtePump(Date var1) {
      this.proDefDtePump = var1;
   }

   public double getProDefPump() {
      return this.proDefPump;
   }

   public void setProDefPump(double var1) {
      this.proDefPump = var1;
   }

   public float getProDensite() {
      return this.proDensite;
   }

   public void setProDensite(float var1) {
      this.proDensite = var1;
   }

   public String getProDepotAch() {
      return this.proDepotAch;
   }

   public void setProDepotAch(String var1) {
      this.proDepotAch = var1;
   }

   public String getProDepotPrd() {
      return this.proDepotPrd;
   }

   public void setProDepotPrd(String var1) {
      this.proDepotPrd = var1;
   }

   public String getProDepotVte() {
      return this.proDepotVte;
   }

   public void setProDepotVte(String var1) {
      this.proDepotVte = var1;
   }

   public float getProDiamExt() {
      return this.proDiamExt;
   }

   public void setProDiamExt(float var1) {
      this.proDiamExt = var1;
   }

   public float getProDiamInt() {
      return this.proDiamInt;
   }

   public void setProDiamInt(float var1) {
      this.proDiamInt = var1;
   }

   public float getProEpaisseur() {
      return this.proEpaisseur;
   }

   public void setProEpaisseur(float var1) {
      this.proEpaisseur = var1;
   }

   public String getProGrpInv() {
      return this.proGrpInv;
   }

   public void setProGrpInv(String var1) {
      this.proGrpInv = var1;
   }

   public long getProId() {
      return this.proId;
   }

   public void setProId(long var1) {
      this.proId = var1;
   }

   public int getProImpDesciption() {
      return this.proImpDesciption;
   }

   public void setProImpDesciption(int var1) {
      this.proImpDesciption = var1;
   }

   public int getProInactif() {
      return this.proInactif;
   }

   public void setProInactif(int var1) {
      this.proInactif = var1;
   }

   public float getProLargeur() {
      return this.proLargeur;
   }

   public void setProLargeur(float var1) {
      this.proLargeur = var1;
   }

   public String getProLettre() {
      return this.proLettre;
   }

   public void setProLettre(String var1) {
      this.proLettre = var1;
   }

   public String getProLibClient() {
      if (this.proLibClient != null && !this.proLibClient.isEmpty()) {
         this.proLibClient = this.proLibClient.toUpperCase();
      }

      return this.proLibClient;
   }

   public void setProLibClient(String var1) {
      this.proLibClient = var1;
   }

   public String getProLibTech() {
      if (this.proLibTech != null && !this.proLibTech.isEmpty()) {
         this.proLibTech = this.proLibTech.toUpperCase();
      }

      return this.proLibTech;
   }

   public void setProLibTech(String var1) {
      this.proLibTech = var1;
   }

   public float getProLongueur() {
      return this.proLongueur;
   }

   public void setProLongueur(float var1) {
      this.proLongueur = var1;
   }

   public String getProMarque() {
      return this.proMarque;
   }

   public void setProMarque(String var1) {
      this.proMarque = var1;
   }

   public int getProMode() {
      return this.proMode;
   }

   public void setProMode(int var1) {
      this.proMode = var1;
   }

   public float getProNbUnite() {
      return this.proNbUnite;
   }

   public void setProNbUnite(float var1) {
      this.proNbUnite = var1;
   }

   public String getProPdf() {
      if (this.proPdf == null || this.proPdf.isEmpty()) {
         this.proPdf = null;
      }

      return this.proPdf;
   }

   public void setProPdf(String var1) {
      this.proPdf = var1;
   }

   public String getProPhoto() {
      if (this.proPhoto == null || this.proPhoto.isEmpty()) {
         this.proPhoto = null;
      }

      return this.proPhoto;
   }

   public void setProPhoto(String var1) {
      this.proPhoto = var1;
   }

   public float getProPoidsBrut() {
      return this.proPoidsBrut;
   }

   public void setProPoidsBrut(float var1) {
      this.proPoidsBrut = var1;
   }

   public float getProPoidsNet() {
      return this.proPoidsNet;
   }

   public void setProPoidsNet(float var1) {
      this.proPoidsNet = var1;
   }

   public float getProPression() {
      return this.proPression;
   }

   public void setProPression(float var1) {
      this.proPression = var1;
   }

   public String getProCondition1() {
      return this.proCondition1;
   }

   public void setProCondition1(String var1) {
      this.proCondition1 = var1;
   }

   public String getProCondition2() {
      return this.proCondition2;
   }

   public void setProCondition2(String var1) {
      this.proCondition2 = var1;
   }

   public String getProCondition3() {
      return this.proCondition3;
   }

   public void setProCondition3(String var1) {
      this.proCondition3 = var1;
   }

   public String getProCondition4() {
      return this.proCondition4;
   }

   public void setProCondition4(String var1) {
      this.proCondition4 = var1;
   }

   public String getProCondition5() {
      return this.proCondition5;
   }

   public void setProCondition5(String var1) {
      this.proCondition5 = var1;
   }

   public float getProQteLie() {
      return this.proQteLie;
   }

   public void setProQteLie(float var1) {
      this.proQteLie = var1;
   }

   public int getProStock() {
      return this.proStock;
   }

   public void setProStock(int var1) {
      this.proStock = var1;
   }

   public float getProVolume() {
      return this.proVolume;
   }

   public void setProVolume(float var1) {
      this.proVolume = var1;
   }

   public String getProVteCode() {
      return this.proVteCode;
   }

   public void setProVteCode(String var1) {
      this.proVteCode = var1;
   }

   public String getProVteCpteHz() {
      return this.proVteCpteHz;
   }

   public void setProVteCpteHz(String var1) {
      this.proVteCpteHz = var1;
   }

   public String getProVteCpteLoc() {
      return this.proVteCpteLoc;
   }

   public void setProVteCpteLoc(String var1) {
      this.proVteCpteLoc = var1;
   }

   public String getProVteCptePr() {
      return this.proVteCptePr;
   }

   public void setProVteCptePr(String var1) {
      this.proVteCptePr = var1;
   }

   public String getProVteCpteSt() {
      return this.proVteCpteSt;
   }

   public void setProVteCpteSt(String var1) {
      this.proVteCpteSt = var1;
   }

   public String getProVteCpteZ() {
      return this.proVteCpteZ;
   }

   public void setProVteCpteZ(String var1) {
      this.proVteCpteZ = var1;
   }

   public String getProVteDouane() {
      return this.proVteDouane;
   }

   public void setProVteDouane(String var1) {
      this.proVteDouane = var1;
   }

   public String getProVteLib() {
      return this.proVteLib;
   }

   public void setProVteLib(String var1) {
      this.proVteLib = var1;
   }

   public String getProVteNat() {
      return this.proVteNat;
   }

   public void setProVteNat(String var1) {
      this.proVteNat = var1;
   }

   public String getProVteTva() {
      return this.proVteTva;
   }

   public void setProVteTva(String var1) {
      this.proVteTva = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public String getProEtat() {
      return this.proEtat;
   }

   public void setProEtat(String var1) {
      this.proEtat = var1;
   }

   public String getProFormule() {
      return this.proFormule;
   }

   public void setProFormule(String var1) {
      this.proFormule = var1;
   }

   public void setProBarre(String var1) {
      this.proBarre = var1;
   }

   public Date getProDateCreat() {
      return this.proDateCreat;
   }

   public void setProDateCreat(Date var1) {
      this.proDateCreat = var1;
   }

   public Date getProDateModif() {
      return this.proDateModif;
   }

   public void setProDateModif(Date var1) {
      this.proDateModif = var1;
   }

   public long getProUserCreat() {
      return this.proUserCreat;
   }

   public void setProUserCreat(long var1) {
      this.proUserCreat = var1;
   }

   public long getProUserModif() {
      return this.proUserModif;
   }

   public void setProUserModif(long var1) {
      this.proUserModif = var1;
   }

   public int getProPublic() {
      return this.proPublic;
   }

   public void setProPublic(int var1) {
      this.proPublic = var1;
   }

   public Date getProDatePublic() {
      return this.proDatePublic;
   }

   public void setProDatePublic(Date var1) {
      this.proDatePublic = var1;
   }

   public boolean isPublicBool() {
      if (this.proPublic == 0) {
         this.publicBool = false;
      } else {
         this.publicBool = true;
      }

      return this.publicBool;
   }

   public void setPublicBool(boolean var1) {
      this.publicBool = var1;
   }

   public String getProPromo() {
      return this.proPromo;
   }

   public void setProPromo(String var1) {
      this.proPromo = var1;
   }

   public boolean isVar_select() {
      return this.var_select;
   }

   public void setVar_select(boolean var1) {
      this.var_select = var1;
   }

   public float getProPoidsTare() {
      return this.proPoidsTare;
   }

   public void setProPoidsTare(float var1) {
      this.proPoidsTare = var1;
   }

   public boolean isLibelle_libre() {
      return this.libelle_libre;
   }

   public void setLibelle_libre(boolean var1) {
      this.libelle_libre = var1;
   }

   public int getProBoiteVitesse() {
      return this.proBoiteVitesse;
   }

   public void setProBoiteVitesse(int var1) {
      this.proBoiteVitesse = var1;
   }

   public String getProCarrosserie() {
      return this.proCarrosserie;
   }

   public void setProCarrosserie(String var1) {
      this.proCarrosserie = var1;
   }

   public int getProCylindree() {
      return this.proCylindree;
   }

   public void setProCylindree(int var1) {
      this.proCylindree = var1;
   }

   public String getProEnergie() {
      return this.proEnergie;
   }

   public void setProEnergie(String var1) {
      this.proEnergie = var1;
   }

   public String getProGenre() {
      return this.proGenre;
   }

   public void setProGenre(String var1) {
      this.proGenre = var1;
   }

   public int getProNbPlace() {
      return this.proNbPlace;
   }

   public void setProNbPlace(int var1) {
      this.proNbPlace = var1;
   }

   public int getProNbPorte() {
      return this.proNbPorte;
   }

   public void setProNbPorte(int var1) {
      this.proNbPorte = var1;
   }

   public int getProPuissance() {
      return this.proPuissance;
   }

   public void setProPuissance(int var1) {
      this.proPuissance = var1;
   }

   public int getProRemise() {
      return this.proRemise;
   }

   public void setProRemise(int var1) {
      this.proRemise = var1;
   }

   public int getProPuissanceDin() {
      return this.proPuissanceDin;
   }

   public void setProPuissanceDin(int var1) {
      this.proPuissanceDin = var1;
   }

   public double getProPrcExoP() {
      return this.proPrcExoP;
   }

   public void setProPrcExoP(double var1) {
      this.proPrcExoP = var1;
   }

   public double getProPrcExoT() {
      return this.proPrcExoT;
   }

   public void setProPrcExoT(double var1) {
      this.proPrcExoT = var1;
   }

   public double getProPrcHt() {
      return this.proPrcHt;
   }

   public void setProPrcHt(double var1) {
      this.proPrcHt = var1;
   }

   public double getProPrgExoP() {
      return this.proPrgExoP;
   }

   public void setProPrgExoP(double var1) {
      this.proPrgExoP = var1;
   }

   public double getProPrgExoT() {
      return this.proPrgExoT;
   }

   public void setProPrgExoT(double var1) {
      this.proPrgExoT = var1;
   }

   public double getProPrgHt() {
      return this.proPrgHt;
   }

   public void setProPrgHt(double var1) {
      this.proPrgHt = var1;
   }

   public double getProAssurance() {
      return this.proAssurance;
   }

   public void setProAssurance(double var1) {
      this.proAssurance = var1;
   }

   public double getProCaf() {
      return this.proCaf;
   }

   public void setProCaf(double var1) {
      this.proCaf = var1;
   }

   public float getProCoefDevise() {
      return this.proCoefDevise;
   }

   public void setProCoefDevise(float var1) {
      this.proCoefDevise = var1;
   }

   public String getProDevise() {
      return this.proDevise;
   }

   public void setProDevise(String var1) {
      this.proDevise = var1;
   }

   public double getProFret() {
      return this.proFret;
   }

   public void setProFret(double var1) {
      this.proFret = var1;
   }

   public double getProPA() {
      return this.proPA;
   }

   public void setProPA(double var1) {
      this.proPA = var1;
   }

   public String getProCouleur() {
      return this.proCouleur;
   }

   public void setProCouleur(String var1) {
      this.proCouleur = var1;
   }

   public String getProCle1() {
      return this.proCle1;
   }

   public void setProCle1(String var1) {
      this.proCle1 = var1;
   }

   public String getProCle2() {
      return this.proCle2;
   }

   public void setProCle2(String var1) {
      this.proCle2 = var1;
   }

   public String getProCodeOption() {
      return this.proCodeOption;
   }

   public void setProCodeOption(String var1) {
      this.proCodeOption = var1;
   }

   public float getProQteCmdClient() {
      return this.proQteCmdClient;
   }

   public void setProQteCmdClient(float var1) {
      this.proQteCmdClient = var1;
   }

   public float getProQteCmdFournisseur() {
      return this.proQteCmdFournisseur;
   }

   public void setProQteCmdFournisseur(float var1) {
      this.proQteCmdFournisseur = var1;
   }

   public float getProQteStock() {
      return this.proQteStock;
   }

   public void setProQteStock(float var1) {
      this.proQteStock = var1;
   }

   public double getPv10() {
      return this.pv10;
   }

   public void setPv10(double var1) {
      this.pv10 = var1;
   }

   public double getPv6() {
      return this.pv6;
   }

   public void setPv6(double var1) {
      this.pv6 = var1;
   }

   public double getPv7() {
      return this.pv7;
   }

   public void setPv7(double var1) {
      this.pv7 = var1;
   }

   public double getPv8() {
      return this.pv8;
   }

   public void setPv8(double var1) {
      this.pv8 = var1;
   }

   public double getPv9() {
      return this.pv9;
   }

   public void setPv9(double var1) {
      this.pv9 = var1;
   }

   public double getPv10Marche() {
      return this.pv10Marche;
   }

   public void setPv10Marche(double var1) {
      this.pv10Marche = var1;
   }

   public double getPv1Marche() {
      return this.pv1Marche;
   }

   public void setPv1Marche(double var1) {
      this.pv1Marche = var1;
   }

   public double getPv2Marche() {
      return this.pv2Marche;
   }

   public void setPv2Marche(double var1) {
      this.pv2Marche = var1;
   }

   public double getPv3Marche() {
      return this.pv3Marche;
   }

   public void setPv3Marche(double var1) {
      this.pv3Marche = var1;
   }

   public double getPv4Marche() {
      return this.pv4Marche;
   }

   public void setPv4Marche(double var1) {
      this.pv4Marche = var1;
   }

   public double getPv5Marche() {
      return this.pv5Marche;
   }

   public void setPv5Marche(double var1) {
      this.pv5Marche = var1;
   }

   public double getPv6Marche() {
      return this.pv6Marche;
   }

   public void setPv6Marche(double var1) {
      this.pv6Marche = var1;
   }

   public double getPv7Marche() {
      return this.pv7Marche;
   }

   public void setPv7Marche(double var1) {
      this.pv7Marche = var1;
   }

   public double getPv8Marche() {
      return this.pv8Marche;
   }

   public void setPv8Marche(double var1) {
      this.pv8Marche = var1;
   }

   public double getPv9Marche() {
      return this.pv9Marche;
   }

   public void setPv9Marche(double var1) {
      this.pv9Marche = var1;
   }

   public String getProVteCpteNTx() {
      return this.proVteCpteNTx;
   }

   public void setProVteCpteNTx(String var1) {
      this.proVteCpteNTx = var1;
   }

   public float getProComPourcentage() {
      return this.proComPourcentage;
   }

   public void setProComPourcentage(float var1) {
      this.proComPourcentage = var1;
   }

   public double getProComUnite() {
      return this.proComUnite;
   }

   public void setProComUnite(double var1) {
      this.proComUnite = var1;
   }

   public String getProAchCpteEc() {
      return this.proAchCpteEc;
   }

   public void setProAchCpteEc(String var1) {
      this.proAchCpteEc = var1;
   }

   public int getProPhotoTaille() {
      return this.proPhotoTaille;
   }

   public void setProPhotoTaille(int var1) {
      this.proPhotoTaille = var1;
   }

   public double getPa() {
      return this.pa;
   }

   public void setPa(double var1) {
      this.pa = var1;
   }

   public double getPump() {
      return this.pump;
   }

   public void setPump(double var1) {
      this.pump = var1;
   }

   public float getProNbUniteCnamgs() {
      return this.proNbUniteCnamgs;
   }

   public void setProNbUniteCnamgs(float var1) {
      this.proNbUniteCnamgs = var1;
   }

   public double getPvCnamgs() {
      return this.pvCnamgs;
   }

   public void setPvCnamgs(double var1) {
      this.pvCnamgs = var1;
   }

   public int getProProcess() {
      return this.proProcess;
   }

   public void setProProcess(int var1) {
      this.proProcess = var1;
   }

   public String getProModelePr() {
      return this.proModelePr;
   }

   public void setProModelePr(String var1) {
      this.proModelePr = var1;
   }

   public String getProVteCpteCa() {
      return this.proVteCpteCa;
   }

   public void setProVteCpteCa(String var1) {
      this.proVteCpteCa = var1;
   }

   public boolean isProAvecService() {
      return this.proAvecService;
   }

   public void setProAvecService(boolean var1) {
      this.proAvecService = var1;
   }

   public int getProPecBilan() {
      return this.proPecBilan;
   }

   public void setProPecBilan(int var1) {
      this.proPecBilan = var1;
   }

   public int getProMajoration() {
      return this.proMajoration;
   }

   public void setProMajoration(int var1) {
      this.proMajoration = var1;
   }

   public String getProManchon() {
      return this.proManchon;
   }

   public void setProManchon(String var1) {
      this.proManchon = var1;
   }

   public String getProUsage() {
      return this.proUsage;
   }

   public void setProUsage(String var1) {
      this.proUsage = var1;
   }

   public boolean isProExoTva() {
      return this.proExoTva;
   }

   public void setProExoTva(boolean var1) {
      this.proExoTva = var1;
   }

   public int getProGrace() {
      return this.proGrace;
   }

   public void setProGrace(int var1) {
      this.proGrace = var1;
   }

   public String getProSerie() {
      return this.proSerie;
   }

   public void setProSerie(String var1) {
      this.proSerie = var1;
   }

   public float getProCoefVte() {
      return this.proCoefVte;
   }

   public void setProCoefVte(float var1) {
      this.proCoefVte = var1;
   }
}
